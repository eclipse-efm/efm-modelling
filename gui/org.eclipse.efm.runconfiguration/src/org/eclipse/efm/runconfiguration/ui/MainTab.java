/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.runconfiguration.ui;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.core.workflow.Activator;
import org.eclipse.efm.core.workflow.ToolConstants;
import org.eclipse.efm.runconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.efm.runconfiguration.LaunchDelegate;
import org.eclipse.efm.ui.views.editors.impls.StringFieldEditor;
import org.eclipse.efm.ui.views.utils.SWTFactory;
import org.eclipse.efm.ui.resources.HelpCoReferee;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class MainTab extends AbstractSewLaunchConfigurationTab {

	private static final String[] MODEL_COMBO_ITEMS = new String[] {
			ANALYSIS_PROFILE_MODEL_EXPLORATION ,
			ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION ,
			ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR
	};


	private boolean fEnabledSymbexDeveloperMode;
	private boolean fEnabledSymbexIncubationMode;



	/////////////////////////////////////
	// MODEL SELECTION
	/////////////////////////////////////

	// AVM Location
	private String fProjectName;
    private Text fModelPathText;
    private Button fModelWorkspaceBrowse;

	private Button fModelButton = null;

	/////////////////////////////////////
	// WORKSPACE // DEVELOPER MODE
	/////////////////////////////////////

	private StringFieldEditor fWorkspaceRootLoacationStringField;
	private StringFieldEditor fWorkspaceOuputFolderNameStringField;
	private StringFieldEditor fWorkspaceLogFolderNameStringField;
	private StringFieldEditor fWorkspaceDebugFolderNameStringField;


	/////////////////////////////////////
	// ANALYSIS SELECTION
	/////////////////////////////////////

	private String fAnalysisProfile = ANALYSIS_PROFILE_MODEL;

	private Combo fModelCombo = null;

	private String fModelAnalysis = ANALYSIS_PROFILE_MODEL_EXPLORATION;


	/////////////////////////////////////
	// TRANSITION COVERAGE ANALYSIS
	/////////////////////////////////////

	MainTabTransitionCoveragePage fTransitionCoveragePage;

	/////////////////////////////////////
	// BEHAVIOR SELECTION ANALYSIS
	/////////////////////////////////////

	MainTabBehaviorSelectionPage fBehaviorSelectionPage;

	/////////////////////////////////////
	// TEST OFFLINE // INCUBATION MODE
	/////////////////////////////////////

	private Button fTestOfflineButton = null;

	MainTabTestOfflinePage fTestOfflinePage;


	/**
	 * Constructor
	 * @param groupTab
	 */
	public MainTab(LaunchConfigurationTabGroup groupTab) {
		super(groupTab);
		setHelpContextId(HelpCoReferee.efm_runconf_main_tab);

		if( LaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION ) {

			IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();

			fEnabledSymbexDeveloperMode =
					prefs.getBoolean(ToolConstants.PREF_SYMBEX_DEVELOPER_MODE);
		}
		else {
			fEnabledSymbexDeveloperMode = false;
		}

		if( LaunchDelegate.ENABLED_SYMBEX_INCUBATION_MODE_OPTION ) {

			IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();

			fEnabledSymbexIncubationMode =
					prefs.getBoolean(ToolConstants.PREF_INCUBATION_MODE);
		}
		else {
			fEnabledSymbexIncubationMode = false;
		}

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage = new MainTabTransitionCoveragePage(this);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage = new MainTabBehaviorSelectionPage(this);

		// TEST OFFLINE // INCUBATION MODE
		if( fEnabledSymbexIncubationMode ) {
			fTestOfflinePage = new MainTabTestOfflinePage(this);
		}
	}


	private class TabListener extends SelectionAdapter implements ModifyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		@Override
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			Object source = e.getSource();

			if(source == fModelButton) {
				handleModelButtonSelected();
			}
			else if(source == fTestOfflineButton) {
				handleTestOfflineButtonSelected();
			}
			else if(source == fModelCombo) {
				handleModelSelectionChange();
			}
		}
	}

	private TabListener fListener = new TabListener();


	public void handleModelButtonSelected() {
		if( fModelButton.getSelection() ) {
			fAnalysisProfile = ANALYSIS_PROFILE_MODEL;

			enableAnalysisModel(true);

			// TEST OFFLINE // INCUBATION MODE
			if( fEnabledSymbexIncubationMode )
			{
				enableAnalysisTestOfflineTrace(false);
			}

			if( fModelAnalysis.equals(
					ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) )
			{
				fTransitionCoveragePage.setVisible(false);

				fBehaviorSelectionPage.setVisible(true);
			}
			else if( fModelAnalysis.equals(
					ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
			{
				fTransitionCoveragePage.setVisible(true);

				fBehaviorSelectionPage.setVisible(false);
			}
			else {
				fTransitionCoveragePage.setVisible(false);

				fBehaviorSelectionPage.setVisible(false);
			}
		}
		updateLaunchConfigurationDialog();
	}

	public void handleTestOfflineButtonSelected() {
		if( fTestOfflineButton.getSelection() ) {
			fAnalysisProfile = ANALYSIS_PROFILE_TEST_OFFLINE;

			enableAnalysisModel(false);

			fTransitionCoveragePage.setVisible(false);

			fBehaviorSelectionPage.setVisible(false);

			enableAnalysisTestOfflineTrace(true);
		}
		updateLaunchConfigurationDialog();
	}

	private void handleModelSelectionChange() {
		fModelAnalysis = fModelCombo.getText();

		ExpertTab expertTab = getGroupTab().getExpertTab();
		if( expertTab != null ) {
			expertTab.setTabName("Expert <" + fModelAnalysis + ">");
		}

		if( fModelAnalysis.equals(
				ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) )
		{
			fBehaviorSelectionPage.setVisible(true);

			fTransitionCoveragePage.setVisible(false);
		}
		else if( fModelAnalysis.equals(
				ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
		{
			fTransitionCoveragePage.setVisible(true);

			fBehaviorSelectionPage.setVisible(false);
		}
		else {
			fTransitionCoveragePage.setVisible(false);

			fBehaviorSelectionPage.setVisible(false);
		}
		updateLaunchConfigurationDialog();
	}


	/**
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent evt) {
			scheduleUpdateJob();

			handleModelFileChange();
		}
	};

	/**
	 * Returns the {@link IDialogSettings} for the given id
	 *
	 * @param id the id of the dialog settings to get
	 * @return the {@link IDialogSettings} to pass into the {@link ContainerSelectionDialog}
	 * @since 3.6
	 */
	IDialogSettings getDialogBoundsSettings(String id) {
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		IDialogSettings section = settings.getSection(id);
		if(section == null) {
			section = settings.addNewSection(id);
		}
		return section;
	}


	@Override
	public void createControl(Composite parent) {

		Composite simpleComposite = SWTFactory.createComposite(parent,
				parent.getFont(), 1, 1, GridData.FILL_BOTH, 0, 0);
		setControl(simpleComposite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
				getControl(), getHelpContextId());

		createModelFileSelectionComponent(simpleComposite);

		createWorkspaceComponent(simpleComposite);

		createAnalyseProfileComponent(simpleComposite);
	}


	/**
	 * Creates the component set for the capture output composite
	 * @param parent the parent to add this component to
	 */
	private void createModelFileSelectionComponent(Composite parent) {
		Group group = SWTFactory.createGroup(
				parent, "Model File Selection", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				group, group.getFont(), 2, 1, GridData.FILL_BOTH, 0, 0);

		fModelPathText = SWTFactory.createSingleText(comp, 1);
		fModelPathText.getAccessible().addAccessibleListener(new AccessibleAdapter() {
			@Override
			public void getName(AccessibleEvent e) {
				e.result = "Model File";
			}
		});
		fModelPathText.addModifyListener(fBasicModifyListener);

		fModelWorkspaceBrowse = createPushButton(comp, "&Workspace...", null);
		fModelWorkspaceBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementTreeSelectionDialog dialog =
						new ElementTreeSelectionDialog(
								getShell(),
								new WorkbenchLabelProvider(),
								new WorkbenchContentProvider() );
				dialog.setTitle("Select a Diversity Specification:");
				dialog.setMessage("Select a resource to redirect output to:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.setComparator(
						new ResourceComparator(ResourceComparator.NAME));
				dialog.setDialogBoundsSettings(
						getDialogBoundsSettings(WORKSPACE_SELECTION_DIALOG),
						Dialog.DIALOG_PERSISTSIZE);
				if(dialog.open() == Window.OK) {
					IResource resource = (IResource) dialog.getFirstResult();
					if(resource != null) {
						fProjectName = resource.getProject().getName();

						String specFile = resource.getLocation().toString();
						fModelPathText.setText(specFile);

						updateWorkspaceRootPath(resource);
					}
				}

//				org.eclipse.ui.dialogs.ResourceSelectionDialog dialog =
//						new ResourceSelectionDialog(getShell(),
//								ResourcesPlugin.getWorkspace().getRoot(),
//								"Select a &Diversity Specification:");
//
//				if(dialog.open() == Window.OK) {
//					Object[] results = dialog.getResult();
//					if(results == null || results.length < 1) {
//						return;
//					}
//					else if( results[0] instanceof IPath ) {
//						IPath path = (IPath)results[0];
//						String specFile = path.toString();
//						fModelPathText.setText(specFile);
//					}
//				}
			}
		});

//		fFileBrowse = createPushButton(bcomp, "File &System...", null);
//		fFileBrowse.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				String filePath = fModelPathText.getText();
//				org.eclipse.swt.widgets.FileDialog dialog =
//						new FileDialog(getShell(), SWT.SAVE);
//				filePath = dialog.open();
//				if(filePath != null) {
//					fModelPathText.setText(filePath);
//				}
//			}
//		});
//		fVariables = createPushButton(bcomp, "Variables...", null);
//		fVariables.addSelectionListener(new SelectionListener() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				StringVariableSelectionDialog dialog =
//						new StringVariableSelectionDialog(getShell());
//				dialog.open();
//				String variable = dialog.getVariableExpression();
//				if(variable != null) {
//					fModelPathText.insert(variable);
//				}
//			}
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {}
//		});

	}


	private void updateWorkspaceRootPath(IResource resource) {
		fWorkspaceRootLoacationStringField.setStringValue(
				resource.getProject().getLocation().toString());
	}

	private void updateWorkspaceRootPath(String modelPath) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = new Path(modelPath);
		IResource resource = root.findMember(path);
		if( (resource != null) && resource.exists() ) {
			fWorkspaceRootLoacationStringField.setStringValue(
					resource.getProject().getLocation().toString());
		}
		else if( root.getLocation().isPrefixOf(path) ) {
			path = root.getLocation().append( path.segment(
					path.matchingFirstSegments( root.getLocation() ) ));
			fWorkspaceRootLoacationStringField.setStringValue(path.toString());
		}
		else {
			fWorkspaceRootLoacationStringField.setStringValue(
				root.getLocation().append(
						"<project-folder-name>" ).toString() );
		}

		fWorkspaceRootLoacationStringField.updateLaunchConfigurationDialog();
	}


	protected void createWorkspaceComponent(Composite parent) {
		String root =  ResourcesPlugin.getWorkspace().getRoot()
				.getLocation().append( "<project-folder-name>" ).toString();

		String toolTipText = "Name of the subfolder in the root folder";
		String toolTipText2 = "Name of the subfolder in the output folder";

		Group group = SWTFactory.createGroup(parent,
				"&Workspace Folder Name", 1, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText( toolTipText );

		Composite comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText( toolTipText );

		fWorkspaceRootLoacationStringField = new StringFieldEditor(this,
				ATTR_WORKSPACE_ROOT_LOCATION, "Root", comp, root);
		fWorkspaceRootLoacationStringField.setEnabled(false);

		fWorkspaceOuputFolderNameStringField = new StringFieldEditor(this,
				ATTR_WORKSPACE_OUTPUT_FOLDER_NAME, "Output", comp,
				DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME);
		fWorkspaceOuputFolderNameStringField.setToolTipText( toolTipText );

		if( fEnabledSymbexDeveloperMode ) {
			fWorkspaceLogFolderNameStringField = new StringFieldEditor(
					this, ATTR_WORKSPACE_LOG_FOLDER_NAME, "Log",
					comp, DEFAULT_WORKSPACE_LOG_FOLDER_NAME);
			fWorkspaceLogFolderNameStringField.setToolTipText( toolTipText2 );

			fWorkspaceDebugFolderNameStringField = new StringFieldEditor(
					this, ATTR_WORKSPACE_DEBUG_FOLDER_NAME, "Debug",
					comp, DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME);
			fWorkspaceDebugFolderNameStringField.setToolTipText( toolTipText2 );
		}
	}


	protected void createAnalyseProfileComponent(Composite parent) {
		Group groupAnalysisProfile= SWTFactory.createGroup(
				parent, "&Analysis Profile", 1, 1, GridData.FILL_HORIZONTAL);

		Group group = SWTFactory.createGroup(groupAnalysisProfile,
				"&Classical Model Analysis: Exploration, Transition Coverage...",
				2, 1, GridData.FILL_HORIZONTAL);

		Composite comp1 = SWTFactory.createComposite(
				group, 1, 2, GridData.FILL_HORIZONTAL);
		fModelButton = SWTFactory.createRadioButton(comp1, "&Selected");
		fModelButton.setToolTipText("Symbolic execution of the model");
		fModelButton.addSelectionListener(fListener);

		fModelCombo = SWTFactory.createCombo(comp1,
				SWT.DROP_DOWN | SWT.READ_ONLY, 1, MODEL_COMBO_ITEMS);
		fModelCombo.setToolTipText(
				  "Choice of the strategy for the symbolic execution of the model\n"
				+ "\t- Exploration: basic symbolic execution of the model\n"
				+ "\t- Transition Coverage: compute a symbolic tree which covers all transitions of the model\n"
				+ "\t- Behavior Selection: compute one or more symbolic path(s) which cover(s)\n"
				+ "\t\t\t   a predefined behavior\n");
		fModelCombo.addSelectionListener(fListener);

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.createControl(group);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.createControl(group);

		if( fEnabledSymbexIncubationMode ) {
			createIncubationTestOfflineComponent(groupAnalysisProfile);
		}
		else
		{
			fModelButton.setSelection(true);
		}
	}


	protected void createIncubationTestOfflineComponent(Composite parent) {
		//user enter choice
		Group groupTestOffline = SWTFactory.createGroup(
				parent, "&Test Verdict Computation: Offline testing...",
				2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				groupTestOffline, 1, 5, GridData.FILL_HORIZONTAL);
		fTestOfflineButton = SWTFactory.createRadioButton(
				comp, "&Selected");
		fTestOfflineButton.addSelectionListener(fListener);

		// WARNING WARNING WARNING WARNING WARNING
		//
		// Functionality not available at this time
		//
		// WARNING WARNING WARNING WARNING WARNING
//		groupTestOffline.setVisible(fEnabledSymbexIncubationMode);
//
//		fTestOfflineButton.setEnabled(fEnabledSymbexIncubationMode);

		// Trace File Selection
		//
		fTestOfflinePage.createControl(comp);
	}


	private void handleModelFileChange() {
		if( (fAnalysisProfile == ANALYSIS_PROFILE_MODEL)
		&& fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
		{
			fTransitionCoveragePage.handleModelFilePathChanged(
					fModelPathText.getText());
		}
	}


	/**
	 * Enable Model / Trace  Use Case Analysis radio button has been selected
	 */
	private void enableAnalysisModel(boolean bEnabled) {
		fModelButton.setSelection(bEnabled);

		fModelCombo.setEnabled(bEnabled);
	}

	// TEST OFFLINE // INCUBATION MODE
	private void enableAnalysisTestOfflineTrace(boolean bEnabled) {
		fTestOfflineButton.setSelection(bEnabled);

		fTestOfflinePage.setVisible(bEnabled);
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#isValid(ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		setWarningMessage(null);

		String filePath = fModelPathText.getText();
		if( (filePath == null) || filePath.isEmpty() ) {
			setErrorMessage("The resource model file path is empty (or null)");
		}
		else {
			File aFile = new File(filePath);
			if( ! aFile.exists() ) {
				setErrorMessage("The resource model file \"" +
						filePath + "\" does not exist.");
			}
			else if( ! aFile.isFile() ) {
				setErrorMessage("The resource model \"" +
						filePath + "\" is not a file.");
			}
		}

		switch( fAnalysisProfile ) {
			case ANALYSIS_PROFILE_MODEL: {
				switch( fModelAnalysis )
				{
					case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR:
					{
						// BEHAVIOR SELECTION ANALYSIS
						if( ! fBehaviorSelectionPage.isValid(launchConfig) )
						{
							return false;
						}

						break;
					}
					case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION:
					{
						// TRANSITION COVERAGE ANALYSIS
						if( ! fTransitionCoveragePage.isValid(launchConfig) )
						{
							return false;
						}

						break;
					}

					default:
						break;
				}
				break;
			}
			case ANALYSIS_PROFILE_TEST_OFFLINE:
			{
				// TEST OFFLINE // INCUBATION MODE
				if( fEnabledSymbexIncubationMode ) {
					if( ! fTestOfflinePage.isValid(launchConfig) )
					{
						return false;
					}
				}

				break;
			}
			default:
				break;
		}

		return true;
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, "<project-name>");

		// MODEL SELECTION
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
				DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);

		// WORKSPACE // DEVELOPER MODE
//		fWorkspaceRootLoacationStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_WORKSPACE_ROOT_LOCATION,
				DEFAULT_WORKSPACE_ROOT_LOCATION);

//		fWorkspaceOuputFolderNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_WORKSPACE_OUTPUT_FOLDER_NAME,
				DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME);

		if( fEnabledSymbexDeveloperMode ) {
//			fWorkspaceLogFolderNameStringField.setDefaults(configuration);
			configuration.setAttribute(
					ATTR_WORKSPACE_LOG_FOLDER_NAME,
					DEFAULT_WORKSPACE_LOG_FOLDER_NAME);

//			fWorkspaceDebugFolderNameStringField.setDefaults(configuration);
			configuration.setAttribute(
					ATTR_WORKSPACE_DEBUG_FOLDER_NAME,
					DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME);
		}

		// ANALYSIS SELECTION
		configuration.setAttribute(
				ATTR_SPECIFICATION_ANALYSIS_PROFILE,
				ANALYSIS_PROFILE_MODEL);

		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS,
				ANALYSIS_PROFILE_MODEL_EXPLORATION);

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.setDefaults(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.setDefaults(configuration);

		// TEST OFFLINE // INCUBATION MODE
		if( fEnabledSymbexIncubationMode ) {
			fTestOfflinePage.setDefaults(configuration);
		}
	}


	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			fProjectName = configuration.getAttribute(
					ATTR_SPECIFICATION_PROJECT_NAME, "");

			String specMainFileLocation = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
					DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);
			fModelPathText.setText( specMainFileLocation );
			updateWorkspaceRootPath( specMainFileLocation );

			fWorkspaceRootLoacationStringField.initializeFrom(configuration);
			fWorkspaceOuputFolderNameStringField.initializeFrom(configuration);

			if( fEnabledSymbexDeveloperMode ) {
				fWorkspaceLogFolderNameStringField.initializeFrom(configuration);
				fWorkspaceDebugFolderNameStringField.initializeFrom(configuration);
			}

			fAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_ANALYSIS_PROFILE,
					ANALYSIS_PROFILE_MODEL);
			initializeAnalysisProfile();

			fModelAnalysis = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS,
					ANALYSIS_PROFILE_MODEL_EXPLORATION);
			initializeModelAnalysis();
		}
		catch (CoreException e) {
			e.printStackTrace();
		}

		if( fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL) &&
			fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR)	)
		{
			fTransitionCoveragePage.setVisible(false);

			fBehaviorSelectionPage.setVisible(true);
		}
		else if( fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL) &&
				fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
		{
			fTransitionCoveragePage.setVisible(true);

			fBehaviorSelectionPage.setVisible(false);
		}
		else {
			fTransitionCoveragePage.setVisible(false);

			fBehaviorSelectionPage.setVisible(false);
		}

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.initializeFrom(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.initializeFrom(configuration);


		// TEST OFFLINE // INCUBATION MODE
		if( fEnabledSymbexIncubationMode ) {
			fTestOfflinePage.initializeFrom(configuration);
		}
	}

	private void initializeModelAnalysis() {
		switch ( fModelAnalysis ) {
		case ANALYSIS_PROFILE_MODEL_EXPLORATION:
			fModelCombo.select(0);
			break;
		case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION:
			fModelCombo.select(1);
			break;
		case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR:
			fModelCombo.select(2);
			break;
		default:
			fModelCombo.select(0);
			break;
		}
	}

	private void initializeAnalysisProfile() {
		if( ! fEnabledSymbexIncubationMode ) {
			fAnalysisProfile = ANALYSIS_PROFILE_MODEL;
		}

		switch ( fAnalysisProfile ) {
			case ANALYSIS_PROFILE_MODEL:
			{
				fModelButton.setSelection(true);
				enableAnalysisModel(true);

				if( fEnabledSymbexIncubationMode ) {
					fTestOfflineButton.setSelection(false);
					enableAnalysisTestOfflineTrace(false);
				}

				if( fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) )
				{
					fTransitionCoveragePage.setVisible(false);

					fBehaviorSelectionPage.setVisible(true);
				}
				else if( fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
				{
					fTransitionCoveragePage.setVisible(true);

					fBehaviorSelectionPage.setVisible(false);
				}
				else {
					fTransitionCoveragePage.setVisible(false);

					fBehaviorSelectionPage.setVisible(false);
				}

				break;
			}
			case ANALYSIS_PROFILE_TEST_OFFLINE:
			{
				fModelButton.setSelection(false);
				enableAnalysisModel(false);

				if( fEnabledSymbexIncubationMode ) {
					fTestOfflineButton.setSelection(true);
					enableAnalysisTestOfflineTrace(true);
				}

				fTransitionCoveragePage.setVisible(false);

				fBehaviorSelectionPage.setVisible(false);

				break;
			}
			default:
			{
				fModelButton.setSelection(true);
				fAnalysisProfile = ANALYSIS_PROFILE_MODEL;
				enableAnalysisModel(true);

				if( fEnabledSymbexIncubationMode ) {
					fTestOfflineButton.setSelection(false);
					enableAnalysisTestOfflineTrace(false);
				}

				if( fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) )
				{
					fTransitionCoveragePage.setVisible(false);

					fBehaviorSelectionPage.setVisible(true);
				}
				else if( fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
				{
					fTransitionCoveragePage.setVisible(true);

					fBehaviorSelectionPage.setVisible(false);
				}
				else {
					fTransitionCoveragePage.setVisible(false);

					fBehaviorSelectionPage.setVisible(false);
				}

				break;
			}
		}

		updateLaunchConfigurationDialog();
	}


	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, fProjectName);

		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
				fModelPathText.getText());

		fWorkspaceRootLoacationStringField.performApply(configuration);
		fWorkspaceOuputFolderNameStringField.performApply(configuration);

		if( fEnabledSymbexDeveloperMode ) {
			fWorkspaceLogFolderNameStringField.performApply(configuration);
			fWorkspaceDebugFolderNameStringField.performApply(configuration);
		}

		configuration.setAttribute(
				ATTR_SPECIFICATION_ANALYSIS_PROFILE, fAnalysisProfile);

		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS, fModelAnalysis);

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.performApply(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.performApply(configuration);

		// TEST OFFLINE // INCUBATION MODE
		if( fEnabledSymbexIncubationMode ) {
			fTestOfflinePage.performApply(configuration);
		}
	}

	@Override
	public String getName() {
		return "Main";
	}
}
