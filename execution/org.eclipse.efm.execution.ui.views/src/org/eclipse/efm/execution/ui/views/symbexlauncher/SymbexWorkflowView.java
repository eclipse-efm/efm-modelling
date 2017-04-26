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

import java.util.Arrays;
import java.util.HashMap;
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
import org.eclipse.efm.execution.configuration.common.ui.page.overview.OverviewConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.page.supervisor.SupervisorConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.page.testgen.TestGenerationConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.util.GenericCompositeCreator;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class SymbexWorkflowView extends AbstractSymbexWorkflowView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.efm.execution.ui.views.SymbexWorkflowView";

	//public Set<SectionCompositeCreator> compositeSections;

	private AbstractConfigurationPage[] fConfigurationPages;
	

	protected Composite tabbedCompositeMaster;
	protected CTabFolder fTabFolder;
	protected Combo combo;

	protected LaunchConfigurationManager launchConfigurationManager;

	public String[] getLaunchConfigurationNames() {
		return launchConfigurationManager.getNames();
	}


	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		parentComposite = parent;
		//compositeSections = new HashSet<SectionCompositeCreator>();

		launchConfigurationManager = new LaunchConfigurationManager(this);

		// Actions
		makeActions();
		setupTopLevelActionBars(new Action[] {
				action_launch_runconf,
				action_launch_debugconf,
				action_opend_runconf,
				action_opend_debugconf,
				action_apply_changes
			});

		// Frame
		setupFormFrame();

		FormWidgetToolkit toolkit = getFormWidgetToolkit();

		combo = GenericCompositeCreator.createComposite_combo_text_from_toolkit(
				toolkit, scrollform.getBody(), "Run Configuration :", 2);
				//new Combo(scrollform.getBody(), SWT.READ_ONLY);

		combo.setItems( launchConfigurationManager.getNames() );

		//text_model_file_path = GenericCompositeCreator.createComposite_label_text_from_toolkit(
//				toolkit, scrollform.getBody(), "Model File :", 2);

		tabbedCompositeMaster = toolkit.createComposite(scrollform.getBody());
		GridLayout gl = new GridLayout(1, false);
		tabbedCompositeMaster.setLayout(gl);
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true);
		tabbedCompositeMaster.setLayoutData(gd);

		fTabFolder = toolkit.createTabFolder( tabbedCompositeMaster, SWT.FLAT | SWT.TOP );

	    createSectionsContent(toolkit);

		//PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "");

		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = combo.getSelectionIndex();

				launchConfigurationManager.select(index);

				initializeFieldValuesFrom(launchConfigurationManager.getSelection());

//				refreshGUI();
				if (index != -1) {
					launchConfigurationManager.select(index);
				}
			}
		});

		if( launchConfigurationManager.isPopulated() ) {
			launchConfigurationManager.select(0);

			combo.select(0);

			initializeFieldValuesFrom(launchConfigurationManager.getSelection());
		}
	}


	@Override
	public void dispose() {
		launchConfigurationManager.dispose();

		super.dispose();
	}

	public void refreshLaunchConfigurationsGUI() {
		int cur_index = combo.getSelectionIndex();
		String cur_name = null;
		if (cur_index != -1) {
			System.err.println(cur_index);
			cur_name = combo.getItem(cur_index);
		}

//		launchConfigurationManager.refresh();

		String[] contents = launchConfigurationManager.getNames();

		combo.setItems(contents);

		if( (cur_name != null) && Arrays.asList(contents).contains(cur_name) )
		{
			int new_index = Arrays.asList(contents).indexOf(cur_name);
			launchConfigurationManager.select(new_index);
			combo.select(new_index);
		} else if( launchConfigurationManager.isPopulated() ) {
			launchConfigurationManager.select(0);
			combo.select(0);
		} else {
			combo.deselectAll();
			launchConfigurationManager.select(-1);
		}

		refreshGUI();
		scheduleUpdateJob();
	}


	public void launchConfigurationChanged(ILaunchConfiguration configuration, int index) {
		if( index >= 0 ) {
			combo.select(index);

			initializeFieldValuesFrom(configuration);
		} else {
			combo.deselectAll();
		}
	}

	
	private void createSectionsContent(IWidgetToolkit widgetToolkit)
	{
		fConfigurationPages = new AbstractConfigurationPage[3];

		createOverviewTabItem(widgetToolkit);

		createSupervisorTabItem(widgetToolkit);

		createTestGenerationTabItem(widgetToolkit);

		fTabFolder.setSelection(fOverviewTabItem);
	}
	
	
	@Override
	public AbstractConfigurationPage[] getConfigurationPages() {
		return fConfigurationPages;
	}


	private CTabItem fOverviewTabItem;
	private Composite fOverviewControl;

	private void createOverviewTabItem(IWidgetToolkit widgetToolkit)
	{
		fOverviewTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fOverviewTabItem.setText("Main");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		OverviewConfigurationPage overviewPage = new OverviewConfigurationPage(this);

		Map<String, Action> firstacts = new HashMap<String, Action>();
		firstacts.put("action_apply_changes", action_apply_changes);
		overviewPage.setRegisteredActions(firstacts);

		overviewPage.createControl(scrolledComposite, widgetToolkit);

		fOverviewControl = overviewPage.getControl();
		if (fOverviewControl != null) {
			scrolledComposite.setContent(fOverviewControl);
			scrolledComposite.setMinSize(
					fOverviewControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fOverviewTabItem.setControl(scrolledComposite);
		}

		fConfigurationPages[0] = overviewPage;
	}


	private CTabItem fSupervisorTabItem;
	private Composite fSupervisorControl;

	private void createSupervisorTabItem(IWidgetToolkit widgetToolkit)
	{
		fSupervisorTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fSupervisorTabItem.setText("Supervisor");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		SupervisorConfigurationPage supervisorPage = new SupervisorConfigurationPage(this);

		supervisorPage.createControl(scrolledComposite, widgetToolkit);

		fSupervisorControl = supervisorPage.getControl();
		if (fSupervisorControl != null) {
			scrolledComposite.setContent(fSupervisorControl);
			scrolledComposite.setMinSize(
					fSupervisorControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fSupervisorTabItem.setControl(scrolledComposite);
		}

		fConfigurationPages[1] = supervisorPage;
	}


	private CTabItem fTestGenTabItem;
	private Composite fTestGenControl;

	private void createTestGenerationTabItem(IWidgetToolkit widgetToolkit)
	{
		fTestGenTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fTestGenTabItem.setText("Test Generation");

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		TestGenerationConfigurationPage testGenPage = new TestGenerationConfigurationPage(this);

		testGenPage.createControl(scrolledComposite, widgetToolkit);

		fTestGenControl = testGenPage.getControl();
		if (fTestGenControl != null) {
			scrolledComposite.setContent(fTestGenControl);
			scrolledComposite.setMinSize(
					fTestGenControl.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fTestGenTabItem.setControl(scrolledComposite);
		}

		fConfigurationPages[2] = testGenPage;
	}


	private void updateEnableTab(boolean isLaunchConfSelected) {
	    fOverviewControl.setEnabled(isLaunchConfSelected);
	    //fTestGenControl.setEnabled(isLaunchConfSelected);
	    //fSupervisorControl.setEnabled(isLaunchConfSelected);
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
			for(AbstractConfigurationPage acm : fConfigurationPages) {
				acm.applyUpdatesOnFieldValuesFrom(rwConfiguration);
			}
			rwConfiguration.doSave();
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

	private void makeActions() {
		action_launch_runconf = new Action() {
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
			public void run() {
				//PlatformUI.getWorkbench().getHelpSystem().displayHelp(String contextId);
			}
		};
		action_opend_help.setText("Open Diversity Help");
		action_opend_help.setToolTipText("Open the Diversity Help");
		action_opend_help.setImageDescriptor(
				ImageResources.getImageDescriptor(ImageResources.IMAGE__HELP_ICON));

		action_apply_changes = new Action() {
			public void run() {
				if( launchConfigurationManager.hasSelection() ) {
					saveLaunchConfiguration( launchConfigurationManager.getSelection() );
				}
			}
		};
		action_apply_changes.setText("Apply changes on Launch Configuration");
		action_apply_changes.setToolTipText("Apply changes on Launch Configuration");
		action_apply_changes.setImageDescriptor(ImageResources.getImageDescriptor(ImageResources.IMAGE__PUSH_ICON));
	}

	// ======================================================================================
	//                              ILaunchConfigurationGUIelement interface methods
	// ======================================================================================

	
	private ILaunchConfigurationWorkingCopy fLasLaunchConfigurationWorkingCopy;

	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		for(AbstractConfigurationPage acm : fConfigurationPages) {
			acm.initializeFieldValuesFrom(configuration);
		}

		scheduleUpdateJob();
	}

	public void refreshGUI() {
		if( launchConfigurationManager.hasSelection() ) {
			ILaunchConfiguration selectedLC = launchConfigurationManager.getSelection();
			updateEnableTab(true);

			try {
				ILaunchConfigurationWorkingCopy newcopy = selectedLC.getWorkingCopy();
				if( (fLasLaunchConfigurationWorkingCopy == null)
					|| (! fLasLaunchConfigurationWorkingCopy.contentsEqual(newcopy)) ) {
					fLasLaunchConfigurationWorkingCopy = newcopy;
					System.err.println("++++---- Biopp");

					for(AbstractConfigurationPage acm : fConfigurationPages) {
						acm.initializeFieldValuesFrom(selectedLC);
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

}
