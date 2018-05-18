/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.ui.views.symbexlauncher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.page.debug.DebugConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.page.developer.DeveloperTuningConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.page.expert.ExpertConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.page.overview.OverviewConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.page.supervisor.SupervisorConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.page.testgen.TestGenerationConfigurationPage;
import org.eclipse.efm.execution.core.preferences.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.efm.execution.launchconfiguration.LaunchDelegate;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class SymbexWorkflowView extends AbstractSymbexWorkflowView
		implements IWorkflowPreferenceConstants {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.efm.execution.ui.views.SymbexWorkflowView";

	//public Set<SectionCompositeCreator> compositeSections;

	private AbstractConfigurationPage[] fConfigurationPages;

	protected Composite tabbedCompositeMaster;
	protected CTabFolder fTabFolder;
	protected Combo fComboLaunchConfiguration;

	protected LaunchConfigurationManager launchConfigurationManager;

	public String[] getLaunchConfigurationNames() {
		return launchConfigurationManager.getNames();
	}


	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	public void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE:
			setMessage(event.getNewValue().toString());

			switch ( (AnalysisProfileKind) event.getNewValue() ) {
			case ANALYSIS_EXPLORATION_PROFILE:
			case ANALYSIS_TRANSITION_COVERAGE_PROFILE:
			case ANALYSIS_BEHAVIOR_SELECTION_PROFILE:
			case ANALYSIS_TEST_OFFLINE_PROFILE:
			default:
				break;
			}
		}
	}


	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		parentComposite = parent;
		//compositeSections = new HashSet<SectionCompositeCreator>();

		launchConfigurationManager = new LaunchConfigurationManager(this);

		// Frame
		setupFormFrame();

		// Actions
		makeActions();
		setupTopLevelActionBars(new Action[] {
				action_apply_changes,

				action_launch_runconf,
				action_launch_debugconf,

				action_opend_runconf,
				action_opend_debugconf
		});

		fComboLaunchConfiguration = toolkit.createLabelledCombo(scrollform.getBody(),
				"Run Configuration :", SWT.DROP_DOWN | SWT.READ_ONLY, 2,
				launchConfigurationManager.getNames() );

		tabbedCompositeMaster = toolkit.createComposite(scrollform.getBody(), 1, 1, SWT.FILL);
//		GridLayout gl = new GridLayout(1, false);
//		tabbedCompositeMaster.setLayout(gl);
//		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true);
//		tabbedCompositeMaster.setLayoutData(gd);

		fTabFolder = toolkit.createTabFolder( tabbedCompositeMaster, SWT.FLAT | SWT.TOP );

	    createSectionsContent(toolkit);

		//PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "");

		fComboLaunchConfiguration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = fComboLaunchConfiguration.getSelectionIndex();

				launchConfigurationManager.select(index);

				initializeFieldValuesFrom(launchConfigurationManager.getSelection());

//				refreshGUI();
				if (index != -1) {
					launchConfigurationManager.select(index);
				}
			}
		});

		if( launchConfigurationManager.isPopulated() ) {
			launchConfigurationManager.initializeSelection(0);

			fComboLaunchConfiguration.select(launchConfigurationManager.getSelectionIndex());

			initializeFieldValuesFrom(launchConfigurationManager.getSelection());
		}
	}


	@Override
	public void dispose() {
		launchConfigurationManager.dispose();

		super.dispose();
	}

	public void refreshLaunchConfigurationsGUI() {
		int cur_index = fComboLaunchConfiguration.getSelectionIndex();
		String cur_name = null;
		if (cur_index != -1) {
			cur_name = fComboLaunchConfiguration.getItem(cur_index);
		}

//		launchConfigurationManager.refresh();

		String[] contents = launchConfigurationManager.getNames();

		fComboLaunchConfiguration.setItems(contents);

		if( (cur_name != null) && Arrays.asList(contents).contains(cur_name) )
		{
			int new_index = Arrays.asList(contents).indexOf(cur_name);
			launchConfigurationManager.select(new_index);
			fComboLaunchConfiguration.select(new_index);
		} else if( launchConfigurationManager.isPopulated() ) {
			launchConfigurationManager.select(0);
			fComboLaunchConfiguration.select(0);
		} else {
			fComboLaunchConfiguration.deselectAll();
			launchConfigurationManager.select(-1);
		}

		refreshGUI();
		scheduleUpdateJob();
	}


	public void launchConfigurationChanged(ILaunchConfiguration configuration, int index) {
		if( index >= 0 ) {
			fComboLaunchConfiguration.select(index);

			initializeFieldValuesFrom(configuration);
		} else {
			fComboLaunchConfiguration.deselectAll();
		}
	}


	private void createSectionsContent(IWidgetToolkit widgetToolkit)
	{
		ArrayList< AbstractConfigurationPage > confPage = new ArrayList<>();

		createOverviewTabItem(widgetToolkit, confPage);

		createSupervisorTabItem(widgetToolkit, confPage);

		createTestGenerationTabItem(widgetToolkit, confPage);

		if( SymbexPreferenceUtil.getBooleanPreference(PREF_DEBUG_OPTIONS) )
		{
			createDebugTabItem(widgetToolkit, confPage);
		}
		if( SymbexPreferenceUtil.getBooleanPreference(PREF_EXPERT_MODE) )
		{
			createExpertTabItem(widgetToolkit, confPage);
		}

		if ( LaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION
			&& SymbexPreferenceUtil.getBooleanPreference(PREF_SYMBEX_DEVELOPER_MODE) )
		{
			createDeveloperTuningTabItem(widgetToolkit, confPage);
		}

		fConfigurationPages = confPage.toArray(
				new AbstractConfigurationPage[confPage.size()]);

		fTabFolder.setSelection(fOverviewTabItem);
	}


	@Override
	public AbstractConfigurationPage[] getConfigurationPages() {
		return fConfigurationPages;
	}


	private CTabItem fOverviewTabItem;
	private Composite fOverviewControl;

	private void createOverviewTabItem(
			IWidgetToolkit widgetToolkit, List<AbstractConfigurationPage> confPage)
	{
		fOverviewTabItem = new CTabItem(fTabFolder, SWT.BORDER );
		fOverviewTabItem.setText("Overview");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		OverviewConfigurationPage overviewPage = new OverviewConfigurationPage(this);

		overviewPage.setRegisteredActions(fRegisteredActions);

		overviewPage.setDefaultSectionActions(fDefaultSectionActions);

		overviewPage.createControl(scrolledComposite, widgetToolkit);

		fOverviewControl = overviewPage.getControl();
		if (fOverviewControl != null) {
			scrolledComposite.setContent(fOverviewControl);

//			System.out.print("fOverviewControl computeSize: ");
//			System.out.println(
//					fOverviewControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

//			scrolledComposite.setMinSize(
//					fOverviewControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fOverviewTabItem.setControl(scrolledComposite);
		}

		confPage.add( overviewPage );
	}


	private CTabItem fSupervisorTabItem;
	private Composite fSupervisorControl;

	private void createSupervisorTabItem(
			IWidgetToolkit widgetToolkit, List<AbstractConfigurationPage> confPage)
	{
		fSupervisorTabItem = new CTabItem(fTabFolder, SWT.BORDER );
		fSupervisorTabItem.setText("Supervisor");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		SupervisorConfigurationPage supervisorPage = new SupervisorConfigurationPage(this);

		supervisorPage.setRegisteredActions(fRegisteredActions);

		supervisorPage.setDefaultSectionActions(fDefaultSectionActions);

		supervisorPage.createControl(scrolledComposite, widgetToolkit);

		fSupervisorControl = supervisorPage.getControl();
		if (fSupervisorControl != null) {
			scrolledComposite.setContent(fSupervisorControl);

//			System.out.print("fSupervisorControl computeSize: ");
//			System.out.println(
//					fSupervisorControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

//			scrolledComposite.setMinSize(
//					fSupervisorControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fSupervisorTabItem.setControl(scrolledComposite);
		}

		confPage.add( supervisorPage );
	}


	private CTabItem fTestGenTabItem;
	private Composite fTestGenControl;

	private void createTestGenerationTabItem(
			IWidgetToolkit widgetToolkit, List<AbstractConfigurationPage> confPage)
	{
		fTestGenTabItem = new CTabItem(fTabFolder, SWT.BORDER );
		fTestGenTabItem.setText("Test Generation");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		TestGenerationConfigurationPage testGenPage = new TestGenerationConfigurationPage(this);

		testGenPage.setRegisteredActions(fRegisteredActions);

		testGenPage.setDefaultSectionActions(fDefaultSectionActions);

		testGenPage.createControl(scrolledComposite, widgetToolkit);

		fTestGenControl = testGenPage.getControl();
		if (fTestGenControl != null) {
			scrolledComposite.setContent(fTestGenControl);

//			System.out.print("fTestGenControl computeSize: ");
//			System.out.println(
//					fTestGenControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

//			scrolledComposite.setMinSize(
//					fTestGenControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fTestGenTabItem.setControl(scrolledComposite);
		}

		confPage.add( testGenPage );
	}

	private CTabItem fDebugTabItem;
	private Composite fDebugControl;

	private void createDebugTabItem(
			IWidgetToolkit widgetToolkit, List<AbstractConfigurationPage> confPage)
	{
		fDebugTabItem = new CTabItem(fTabFolder, SWT.BORDER );
		fDebugTabItem.setText("Debug");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		DebugConfigurationPage devugPage = new DebugConfigurationPage(this);

		devugPage.createControl(scrolledComposite, widgetToolkit);

		fDebugControl = devugPage.getControl();
		if (fDebugControl != null) {
			scrolledComposite.setContent(fDebugControl);

//			System.out.print("fDebugControl computeSize: ");
//			System.out.println(
//					fDebugControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

//			scrolledComposite.setMinSize(
//					fDebugControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fDebugTabItem.setControl(scrolledComposite);
		}

		confPage.add( devugPage );
	}

	private CTabItem fExpertTabItem;
	private Composite fExpertControl;

	private void createExpertTabItem(
			IWidgetToolkit widgetToolkit, List<AbstractConfigurationPage> confPage)
	{
		fExpertTabItem = new CTabItem(fTabFolder, SWT.BORDER );
		fExpertTabItem.setText("Expert");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		ExpertConfigurationPage expertPage = new ExpertConfigurationPage(this);

		expertPage.createControl(scrolledComposite, widgetToolkit);

		fExpertControl = expertPage.getControl();
		if (fExpertControl != null) {
			scrolledComposite.setContent(fExpertControl);

//			System.out.print("fExpertControl computeSize: ");
//			System.out.println(
//					fExpertControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

//			scrolledComposite.setMinSize(
//					fExpertControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fExpertTabItem.setControl(scrolledComposite);
		}

		confPage.add( expertPage );
	}

	private CTabItem fDeveloperTuningTabItem;
	private Composite fDeveloperTuningControl;

	private void createDeveloperTuningTabItem(IWidgetToolkit widgetToolkit,
			List<AbstractConfigurationPage> confPage)
	{
		fDeveloperTuningTabItem = new CTabItem(fTabFolder, SWT.BORDER );
		fDeveloperTuningTabItem.setText("Developer");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		DeveloperTuningConfigurationPage developerPage =
				new DeveloperTuningConfigurationPage(this);

		developerPage.createControl(scrolledComposite, widgetToolkit);

		fDeveloperTuningControl = developerPage.getControl();
		if (fDeveloperTuningControl != null) {
			scrolledComposite.setContent(fDeveloperTuningControl);

//			System.out.print("fDeveloperTuningControl computeSize: ");
//			System.out.println(
//					fDeveloperTuningControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

//			scrolledComposite.setMinSize(
//					fDeveloperTuningControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fDeveloperTuningTabItem.setControl(scrolledComposite);
		}

		confPage.add( developerPage );
	}


	private void updateEnableTab(boolean isLaunchConfSelected) {
	    fOverviewControl.setEnabled(isLaunchConfSelected);
	}

	///////////////////////////////////////////////////////////////////////////
	// Action utils
	//
	private void execLaunchConfiguration(
			final ILaunchConfiguration configuration, final String mode)
	{
		saveLaunchConfiguration( configuration );

		DebugUITools.launch(configuration, mode);
	}


	private void openLaunchConfigurationDialog(
			final ILaunchConfiguration configuration, final String mode)
	{
		saveLaunchConfiguration( configuration );

		IStructuredSelection selection = new StructuredSelection(configuration);
		ILaunchGroup group = DebugUITools.getLaunchGroup(configuration, mode);

		String groupIdentifier = group == null ?
				IDebugUIConstants.ID_RUN_LAUNCH_GROUP : group.getIdentifier();

		DebugUITools.openLaunchConfigurationDialogOnGroup(
				scrollform.getShell(), selection, groupIdentifier, null);
	}

	private void saveLaunchConfiguration(final ILaunchConfiguration configuration) {
		ILaunchConfigurationWorkingCopy rwConfiguration;
		try {
			rwConfiguration = configuration.getWorkingCopy();

			// Save Selection in Preferences
			SymbexPreferenceUtil.setPreference(
					PREF_LAUNCH_CONFIGURATION_SELECTION,
					launchConfigurationManager.getSelection().getName());

			for(AbstractConfigurationPage acm : fConfigurationPages) {
				acm.performApply(rwConfiguration);
			}
			rwConfiguration.doSave();

			if( action_apply_changes != null ) {
				action_apply_changes.setEnabled(false);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}




	// ======================================================================================
	//                              Actions for menus
	// ======================================================================================

	private Action action_launch_runconf;
	private Action action_launch_debugconf;
	private Action action_opend_runconf;
	private Action action_opend_debugconf;

	private Action action_opend_help;
	private Action action_apply_changes;

	private Map<String, Action> fRegisteredActions;

	private Action[] fDefaultSectionActions;


	private void makeActions() {
		action_apply_changes = new Action() {
			@Override
			public void run() {
				if( launchConfigurationManager.hasSelection() ) {
					saveLaunchConfiguration( launchConfigurationManager.getSelection() );
				}
			}
		};
		action_apply_changes.setText("Apply changes on Launch Configuration");
		action_apply_changes.setToolTipText("Apply changes on Launch Configuration");
		action_apply_changes.setImageDescriptor(
				ImageResources.getImageDescriptor(
//						ImageResources.IMAGE__PUSH_ICON));
						ImageResources.IMAGE__SAVE_ICON));

		action_apply_changes.setEnabled(false);

		action_launch_runconf = new Action() {
			@Override
			public void run() {
				if( launchConfigurationManager.hasSelection() ) {
					execLaunchConfiguration(
							launchConfigurationManager.getSelection(),
							ILaunchManager.RUN_MODE);
				} else {
					showMessage("No Launch Configuration selected");
				}
			}
		};
		action_launch_runconf.setText("Launch Run Configuration");
		action_launch_runconf.setToolTipText("Launch Selected Run Configuration");
		action_launch_runconf.setImageDescriptor(
				ImageResources.getImageDescriptor(ImageResources.IMAGE__LAUNCHRUN_ICON));

		action_launch_debugconf = new Action() {
			@Override
			public void run() {
				if( launchConfigurationManager.hasSelection() ) {
					execLaunchConfiguration(
							launchConfigurationManager.getSelection(),
							ILaunchManager.DEBUG_MODE);
				} else {
					showMessage("No Launch Configuration selected");
				}
			}
		};
		action_launch_debugconf.setText("Launch Debug Configuration");
		action_launch_debugconf.setToolTipText("Launch Selected Debug Configuration");
		action_launch_debugconf.setImageDescriptor(
				ImageResources.getImageDescriptor(ImageResources.IMAGE__LAUNCHDEBUG_ICON));


		action_opend_runconf = new Action() {
			@Override
			public void run() {
				if( launchConfigurationManager.hasSelection() ) {
					openLaunchConfigurationDialog(
							launchConfigurationManager.getSelection(),
							ILaunchManager.RUN_MODE);
				} else {
					showMessage("No Launch Configuration selected");
				}
			}
		};
		action_opend_runconf.setText("Open Run Configurations...");
		action_opend_runconf.setToolTipText("Open the Run Configurations Dialog");
		action_opend_runconf.setImageDescriptor(
				ImageResources.getImageDescriptor(ImageResources.IMAGE__DIALRUN_ICON));

		action_opend_debugconf = new Action() {
			@Override
			public void run() {
				if( launchConfigurationManager.hasSelection() ) {
					openLaunchConfigurationDialog(
							launchConfigurationManager.getSelection(),
							ILaunchManager.DEBUG_MODE);
				} else {
					showMessage("No Launch Configuration selected");
				}
			}
		};
		action_opend_debugconf.setText("Open Debug Configuration...");
		action_opend_debugconf.setToolTipText("Open the Debug Configuration Dialog");
		action_opend_debugconf.setImageDescriptor(
				ImageResources.getImageDescriptor(ImageResources.IMAGE__DIALDEBUG_ICON));

		action_opend_help = new Action() {
			@Override
			public void run() {
				//PlatformUI.getWorkbench().getHelpSystem().displayHelp(String contextId);
			}
		};
		action_opend_help.setText("Open Diversity Help");
		action_opend_help.setToolTipText("Open the Diversity Help");
		action_opend_help.setImageDescriptor(
				ImageResources.getImageDescriptor(ImageResources.IMAGE__HELP_ICON));

		fRegisteredActions = new HashMap<String, Action>();
		fRegisteredActions.put("action_apply_changes", action_apply_changes);
		fRegisteredActions.put("action_launch_runconf", action_launch_runconf);
		fRegisteredActions.put("action_launch_debugconf", action_launch_debugconf);

		fDefaultSectionActions = new Action[] {
				action_apply_changes, action_launch_runconf, action_launch_debugconf };
	}

	// ======================================================================================
	//                              ILaunchConfigurationGUIelement interface methods
	// ======================================================================================


	private ILaunchConfigurationWorkingCopy fLastLaunchConfigurationWorkingCopy;

	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		for(AbstractConfigurationPage acm : fConfigurationPages) {
			acm.initializeFrom(configuration);
		}

		scheduleUpdateJob();
	}

	public void refreshGUI() {
		if( launchConfigurationManager.hasSelection() ) {
			ILaunchConfiguration selectedLC = launchConfigurationManager.getSelection();
			updateEnableTab(true);

			if( action_apply_changes != null ) {
				action_apply_changes.setEnabled(true);
			}

			try {
				ILaunchConfigurationWorkingCopy newcopy = selectedLC.getWorkingCopy();
				if( (fLastLaunchConfigurationWorkingCopy == null)
					|| (! fLastLaunchConfigurationWorkingCopy.contentsEqual(newcopy)) ) {
					fLastLaunchConfigurationWorkingCopy = newcopy;
					System.err.println("++++---- Biopp");

					for(AbstractConfigurationPage acm : fConfigurationPages) {
						acm.initializeFrom(selectedLC);
					}
				}
			} catch (CoreException e) {
				setErrorMessage("could not get launch configuration working copy");
				e.printStackTrace();
			}
		}
		else {
			fTabFolder.setSelection(fOverviewTabItem);
			updateEnableTab(false);
		}
	}


	@Override
	public void updateGUI() {
		refreshGUI();
	}

	@Override // to change visibility to public
	public void scheduleUpdateJob(){
		scrollform.reflow(true);
		tabbedCompositeMaster.layout();
		fTabFolder.layout();
		tabbedCompositeMaster.layout();
		scrollform.reflow(true);
	}


	///////////////////////////////////////////////////////////////////////////
	// Message API
	///////////////////////////////////////////////////////////////////////////

	@Override // to change visibility to public
	public void setWarningMessage(String warningMessage){
		CTabItem selectedTabItem = fTabFolder.getSelection();
		if( selectedTabItem != null ) {
			if(warningMessage != null) {
				selectedTabItem.setToolTipText(warningMessage);

				selectedTabItem.setImage(
						ImageResources.getImage(ImageResources.IMAGE__WARNING_ICON));
			} else {
				selectedTabItem.setImage(null);
			}
		}
		super.setWarningMessage(warningMessage);
	}

	@Override // to change visibility to public
	public void setErrorMessage(String errorMessage){
		CTabItem selectedTabItem = fTabFolder.getSelection();
		if( selectedTabItem != null ) {
			if(errorMessage != null) {
				selectedTabItem.setToolTipText(errorMessage);

				selectedTabItem.setImage(
						ImageResources.getImage(ImageResources.IMAGE__ERROR_ICON));
			} else {
				selectedTabItem.setImage(null);
			}
		}
		super.setErrorMessage(errorMessage);
	}


}
