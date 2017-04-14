/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial Implementation (tab-based, inserted in Run Configurations dialog)
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - New API (free-composite-based, no type assumptions on parent)
 *******************************************************************************/
package org.eclipse.efm.execution.ui.views.launchconfigurations.components;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.core.AbstractLaunchDelegate;
import org.eclipse.efm.execution.core.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.efm.execution.ui.views.editors.FieldEditor;
import org.eclipse.efm.execution.ui.views.editors.impls.StringFieldEditor;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages.MainTabBehaviorSelectionPage;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages.MainTabTestOfflinePage;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages.MainTabTransitionCoveragePage;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.sections.AnalysisProfile1SectionCreator;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.sections.WorkspaceFolderNameSectionCreator;
import org.eclipse.efm.execution.ui.views.utils.GenericCompositeCreator;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class MainTabItemContentCreator extends AbstractTabItemContentCreator
		implements IWorkflowPreferenceConstants {

	private boolean fEnabledSymbexDeveloperMode;
	private boolean fEnabledSymbexIncubationMode;

	/////////////////////////////////////
	// MODEL SELECTION
	/////////////////////////////////////

	private String fProjectName;
    private Text fModelPathText;
    private Button fModelWorkspaceBrowse;

	/////////////////////////////////////
	// WORKSPACE // DEVELOPER MODE
	/////////////////////////////////////

	private StringFieldEditor fWorkspaceRootLocationStringField;
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

	MainTabTestOfflinePage fTestOfflinePage;


	public MainTabItemContentCreator(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION ) {
			fEnabledSymbexDeveloperMode =
					SymbexPreferenceUtil.getBooleanPreference(PREF_SYMBEX_DEVELOPER_MODE);
		} else {
			fEnabledSymbexDeveloperMode = false;
		}

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_INCUBATION_MODE_OPTION ) {
			fEnabledSymbexIncubationMode =
					SymbexPreferenceUtil.getBooleanPreference(PREF_INCUBATION_MODE);
		} else {
			fEnabledSymbexIncubationMode = false;
		}
	}

	// ======================================================================================
	//                              Miscellaneous handling
	// ======================================================================================

	private void handleModelSelectionChange() {
		String model_combo_selected_text = fModelCombo.getText();
//		ExpertTab expertTab = getGroupTab().getExpertTab();
//		if( expertTab != null ) {
//			expertTab.setTabName("Expert <" + fModelAnalysis + ">");
//		}

		if(model_combo_selected_text.equals(ANALYSIS_PROFILE_MODEL_EXPLORATION)) {
			fBehaviorSelectionPage.collapseAndLockPage();
			fTransitionCoveragePage.collapseAndLockPage();
			fTestOfflinePage.collapseAndLockPage();
		} else if(model_combo_selected_text.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR)) {
			fBehaviorSelectionPage.unlockAndExpandPage();
			fTransitionCoveragePage.collapseAndLockPage();
			fTestOfflinePage.collapseAndLockPage();
		} else if(model_combo_selected_text.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION)) {
			fBehaviorSelectionPage.collapseAndLockPage();
			fTransitionCoveragePage.unlockAndExpandPage();
			fTestOfflinePage.collapseAndLockPage();
		} else if(model_combo_selected_text.equals(ANALYSIS_PROFILE_TEST_OFFLINE)) {
			fBehaviorSelectionPage.collapseAndLockPage();
			fTransitionCoveragePage.collapseAndLockPage();
			fTestOfflinePage.unlockAndExpandPage();
		} else {
			fBehaviorSelectionPage.collapseAndLockPage();
			fTransitionCoveragePage.collapseAndLockPage();
			fTestOfflinePage.collapseAndLockPage();
		}

		if (model_combo_selected_text.equals(ANALYSIS_PROFILE_TEST_OFFLINE)) {
			fAnalysisProfile = ANALYSIS_PROFILE_TEST_OFFLINE;
			fModelAnalysis = ANALYSIS_PROFILE_UNDEFINED;
		} else if (model_combo_selected_text.equals(ANALYSIS_PROFILE_MODEL_EXPLORATION) ||
				model_combo_selected_text.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) ||
				model_combo_selected_text.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION)
				) {
			fAnalysisProfile = ANALYSIS_PROFILE_MODEL;
			fModelAnalysis = model_combo_selected_text;
		}

		propagateGUIupdate();
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
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent evt) {
			propagateUpdateJobScheduling();

			handleModelFileChange();
		}
	};

	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	public void createTabItemContent(Composite parentComposite) {
		createModelFileSelectionComponent(parentComposite);
		createWorkspaceComponent(parentComposite);
		createAnalyseProfileComponent(parentComposite);
	}


	/**
	 * Creates the component set for the capture output composite
	 * @param parent the parent to add this component to
	 */
	private void createModelFileSelectionComponent(Composite parent) {
		FormToolkit toolkit = getMasterFormToolkit();
		fModelWorkspaceBrowse = GenericCompositeCreator.createComposite_label_pushbutton_from_toolkit(toolkit,
				parent,
				"Model File Selection",
				"&Workspace...",
				2);

		fModelPathText = toolkit.createText(parent, "", SWT.NONE);
		fModelPathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fModelPathText.getAccessible().addAccessibleListener(new AccessibleAdapter() {
			@Override
			public void getName(AccessibleEvent e) {
				e.result = "Model File";
			}
		});
		fModelPathText.addModifyListener(fBasicModifyListener);

		fModelWorkspaceBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementTreeSelectionDialog dialog =
						new ElementTreeSelectionDialog(
								parent.getShell(),
								new WorkbenchLabelProvider(),
								new WorkbenchContentProvider() );
				dialog.setTitle("Select a Diversity Specification:");
				dialog.setMessage("Select a resource to redirect output to:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.setComparator(
						new ResourceComparator(ResourceComparator.NAME));
//				dialog.setDialogBoundsSettings(
//						getDialogBoundsSettings(WORKSPACE_SELECTION_DIALOG),
//						Dialog.DIALOG_PERSISTSIZE);
				if(dialog.open() == Window.OK) {
					IResource resource = (IResource) dialog.getFirstResult();
					if(resource != null) {
						fProjectName = resource.getProject().getName();

						String specFile = resource.getLocation().toString();
						fModelPathText.setText(specFile);

						updateWorkspaceRootPath(resource);
					}
				}
			}
		});

	}


	private void updateWorkspaceRootPath(IResource resource) {
		fWorkspaceRootLocationStringField.setStringValue(
				resource.getProject().getLocation().toString());
	}

	private void updateWorkspaceRootPath(String modelPath) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = new Path(modelPath);
		IResource resource = root.findMember(path);
		if( (resource != null) && resource.exists() ) {
			fWorkspaceRootLocationStringField.setStringValue(
					resource.getProject().getLocation().toString());
		}
		else if( root.getLocation().isPrefixOf(path) ) {
			path = root.getLocation().append( path.segment(
					path.matchingFirstSegments( root.getLocation() ) ));
			fWorkspaceRootLocationStringField.setStringValue(path.toString());
		}
		else {
			fWorkspaceRootLocationStringField.setStringValue(
				root.getLocation().append(
						"<project-folder-name>" ).toString() );
		}

		fWorkspaceRootLocationStringField.updateLaunchConfigurationDialog();
	}


	protected void createWorkspaceComponent(Composite parent) {
		ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
		Action[] toputinbar = getActionsByStringKey(new String[]{"action_apply_changes"});
		GenericCompositeCreator.fillToolBar(tbm, toputinbar);

		WorkspaceFolderNameSectionCreator wfnsc =
				new WorkspaceFolderNameSectionCreator(
						this.getMasterGUIelement(), this, tbm, parent);
		FieldEditor[] editors = wfnsc.getFieldEditors();
		fWorkspaceRootLocationStringField = (StringFieldEditor) editors[0];
		fWorkspaceOuputFolderNameStringField = (StringFieldEditor) editors[1];
		fWorkspaceLogFolderNameStringField = (StringFieldEditor) editors[2];
		fWorkspaceDebugFolderNameStringField = (StringFieldEditor) editors[3];
	}

	protected void createAnalyseProfileComponent(Composite parent) {
		ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
		Action[] toputinbar = getActionsByStringKey(new String[]{"action_apply_changes"});
		GenericCompositeCreator.fillToolBar(tbm, toputinbar);
		AnalysisProfile1SectionCreator apsc =
				new AnalysisProfile1SectionCreator(
						this.getMasterGUIelement(), this, tbm, parent);



		fModelCombo = apsc.fModelCombo;
		fModelCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleModelSelectionChange();
				propagateUpdateJobScheduling();
			}
		});

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage = apsc.fTransitionCoveragePage;

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage = apsc.fBehaviorSelectionPage;

		fTestOfflinePage = apsc.fTestOfflinePage;

	}









	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, "<project-name>");

		// MODEL SELECTION
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
				DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);

		// WORKSPACE // DEVELOPER MODE
//		fWorkspaceRootLocationStringField.setDefaults(configuration);
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
//		fTransitionCoveragePage.setDefaults(configuration);

		configuration.setAttribute(
				ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SELECTION, new ArrayList<String>());

		// BEHAVIOR SELECTION ANALYSIS
//		fBehaviorSelectionPage.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST,
				BEHAVIOR_INITIAL_SAMPLE);

		// TEST OFFLINE // INCUBATION MODE
		if( fEnabledSymbexIncubationMode ) {
//			fTestOfflinePage.setDefaults(configuration);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
					DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
					DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION, false);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
					DEFAULT_TEST_OFFLINE_OBSERVABLE_SPECIFICATION);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
					DEFAULT_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION);
		}
	}


	@Override
	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		try {
			fProjectName = configuration.getAttribute(
					ATTR_SPECIFICATION_PROJECT_NAME, "");

			String specMainFileLocation = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
					DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);
			fModelPathText.setText( specMainFileLocation );
			updateWorkspaceRootPath( specMainFileLocation );

			fWorkspaceRootLocationStringField.initializeFrom(configuration);
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
			fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR)	){
			fTransitionCoveragePage.collapseAndLockPage();
			fBehaviorSelectionPage.unlockAndExpandPage();
		} else if( fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL) &&
				fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) ) {
			fTransitionCoveragePage.unlockAndExpandPage();
			fBehaviorSelectionPage.collapseAndLockPage();
		} else {
			fTransitionCoveragePage.collapseAndLockPage();
			fBehaviorSelectionPage.collapseAndLockPage();
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
		case ANALYSIS_PROFILE_TEST_OFFLINE:
			fModelCombo.select(3);
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
			case ANALYSIS_PROFILE_MODEL: {
				if( fEnabledSymbexIncubationMode ) {
					fTestOfflinePage.collapseAndLockPage();
				}
				if( fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) ) {
					fTransitionCoveragePage.collapseAndLockPage();
					fBehaviorSelectionPage.unlockAndExpandPage();
				}
				else if( fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) ) {
					fTransitionCoveragePage.unlockAndExpandPage();
					fBehaviorSelectionPage.collapseAndLockPage();
				} else {
					fTransitionCoveragePage.collapseAndLockPage();
					fBehaviorSelectionPage.collapseAndLockPage();
				}
				break;
			}
			case ANALYSIS_PROFILE_TEST_OFFLINE: {
				if( fEnabledSymbexIncubationMode ) {
					fTestOfflinePage.unlockAndExpandPage();
				}

				fTransitionCoveragePage.collapseAndLockPage();

				fBehaviorSelectionPage.collapseAndLockPage();

				break;
			}
			default:
			{
				fAnalysisProfile = ANALYSIS_PROFILE_MODEL;
				if( fEnabledSymbexIncubationMode ) {
					fTestOfflinePage.collapseAndLockPage();
				}

				if( fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) ) {
					fTransitionCoveragePage.collapseAndLockPage();
					fBehaviorSelectionPage.unlockAndExpandPage();
				}
				else if( fModelAnalysis.equals(
						ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) ) {
					fTransitionCoveragePage.unlockAndExpandPage();
					fBehaviorSelectionPage.collapseAndLockPage();
				} else {
					fTransitionCoveragePage.collapseAndLockPage();
					fBehaviorSelectionPage.collapseAndLockPage();
				}
				break;
			}
		}

		propagateGUIupdate();
	}


	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, fProjectName);

		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
				fModelPathText.getText());

		fWorkspaceRootLocationStringField.performApply(configuration);
		fWorkspaceOuputFolderNameStringField.performApply(configuration);

		if( fEnabledSymbexDeveloperMode ) {
			fWorkspaceLogFolderNameStringField.performApply(configuration);
			fWorkspaceDebugFolderNameStringField.performApply(configuration);
		}

		configuration.setAttribute(
				ATTR_SPECIFICATION_ANALYSIS_PROFILE, fAnalysisProfile);
		//System.err.println("+++++" + fAnalysisProfile);
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS, fModelAnalysis);
		//System.err.println("+++++" + fModelAnalysis);
		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.performApply(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.performApply(configuration);

		// TEST OFFLINE // INCUBATION MODE
		if( fEnabledSymbexIncubationMode ) {
			fTestOfflinePage.performApply(configuration);
		}
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================


	@Override
	public FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		String messageToSend = null;

		String filePath = fModelPathText.getText();
		if( (filePath == null) || filePath.isEmpty() ) {
			messageToSend = "The resource model file path is empty (or null)";
		}
		else {
			File aFile = new File(filePath);
			if( ! aFile.exists() ) {
				messageToSend="The resource model file \"" +
						filePath + "\" does not exist.";
			}
			else if( ! aFile.isFile() ) {
				messageToSend = "The resource model \"" +
						filePath + "\" is not a file.";
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
							return new FieldValidationReturn(false, messageToSend);
						}

						break;
					}
					case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION:
					{
						// TRANSITION COVERAGE ANALYSIS
						if( ! fTransitionCoveragePage.isValid(launchConfig) )
						{
							return new FieldValidationReturn(false, messageToSend);
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
						return new FieldValidationReturn(false, messageToSend);
					}
				}

				break;
			}
			default:
				break;
		}

		return new FieldValidationReturn(true, messageToSend);
	}



}
