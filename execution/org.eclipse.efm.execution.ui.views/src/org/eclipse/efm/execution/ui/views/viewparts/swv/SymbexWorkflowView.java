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
package org.eclipse.efm.execution.ui.views.viewparts.swv;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.ui.views.delegates.LaunchManagerSWVlinker;
import org.eclipse.efm.execution.ui.views.utils.GenericCompositeCreator;
import org.eclipse.efm.execution.ui.views.viewparts.swv.sectionimpls.AnalysisProfileCompositeCreator;
import org.eclipse.efm.execution.ui.views.viewparts.swv.sectionimpls.DebugCompositeCreator;
import org.eclipse.efm.execution.ui.views.viewparts.swv.sectionimpls.ExecutionCompositeCreator;
import org.eclipse.efm.execution.ui.views.viewparts.swv.sectionimpls.StopCriteriaCompositeCreator;
import org.eclipse.efm.execution.ui.views.viewparts.swv.sectionimpls.TestGenCompositeCreator;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class SymbexWorkflowView extends AbstractSymbexWorkflowView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.efm.execution.ui.views.SymbexWorkflowView";
	
	public Set<SectionCompositeCreator> compositeSections;
	
	private Text text_model_file_path;
	
	private Combo combo;

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		parentComposite = parent;
		compositeSections = new HashSet<SectionCompositeCreator>();
		
		// Actions
		makeActions();
		setupTopLevelActionBars(new Action[] {action_launch_runconf, action_launch_debugconf, action_opend_runconf, action_opend_debugconf});
		
		// Frame
		setupFormFrame();
		
		combo = new Combo(scrollform.getBody(), SWT.READ_ONLY);
		UpdateSymbexWorkflowViewListener.updateAnySWVcombo(combo);
		
		text_model_file_path = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, scrollform.getBody(), "Model File :", 1);
		
		tabbedCompositeMaster = toolkit.createComposite(scrollform.getBody());
		GridLayout gl = new GridLayout(1, false);
		tabbedCompositeMaster.setLayout(gl);
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true);
		tabbedCompositeMaster.setLayoutData(gd);
		
		tabFolder = new CTabFolder( tabbedCompositeMaster, SWT.BOTTOM );
	    tabFolder.setLayoutData(new GridData(SWT.FILL,SWT.FILL, true, true));
	    toolkit.adapt(tabFolder, true, true);
		
	    createSectionsContent();
	
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "");
		
		addUpdateSWVlistener();
		

	}
	
	private void addUpdateSWVlistener() {
		try {
			UpdateSymbexWorkflowViewListener uSWVl = new UpdateSymbexWorkflowViewListener(combo);
			this.parentComposite.addDisposeListener(new DisposeListener() {

	            @Override
	            public void widgetDisposed(DisposeEvent e) {
	            	uSWVl.selfKill();
	            }
	        });
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Composite createTabItemAndComposite(String tabname) {
		CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE );
		tabItem.setText(tabname);
		
		Composite tbcomp = toolkit.createComposite(tabFolder);
		
		GridLayout gl = new GridLayout(1, false);
		tbcomp.setLayout(gl);
		
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true);
		tbcomp.setLayoutData(gd);
		
		tabItem.setControl(tbcomp);
		
		return tbcomp;
	}
	
	private void createSectionsContent() {
		ToolBarManager tbm;
		
		Composite overview_tbcomp = createTabItemAndComposite("Overview");
		
		tbm = new ToolBarManager(SWT.FLAT);
		fillToolBar(tbm, new Action[] {action_launch_runconf});
		new AnalysisProfileCompositeCreator(this, tbm, overview_tbcomp);
		
		tbm = new ToolBarManager(SWT.FLAT);
		fillToolBar(tbm, new Action[] {action_launch_runconf});
		new StopCriteriaCompositeCreator(this, tbm, overview_tbcomp);
		
		tbm = new ToolBarManager(SWT.FLAT);
		fillToolBar(tbm, new Action[] {action_launch_runconf, action_opend_runconf});
		new ExecutionCompositeCreator(this, tbm, overview_tbcomp);
		
		
		
		Composite testgen_tbcomp = createTabItemAndComposite("Test Generation");
		
		tbm = new ToolBarManager(SWT.FLAT);
		fillToolBar(tbm, new Action[] {action_launch_runconf});
		new TestGenCompositeCreator(this, tbm, testgen_tbcomp);
		
		
		
		Composite debug_tbcomp = createTabItemAndComposite("Debug");
		
		tbm = new ToolBarManager(SWT.FLAT);
		fillToolBar(tbm, new Action[] {action_launch_debugconf, action_opend_debugconf});
		new DebugCompositeCreator(this, tbm, debug_tbcomp);

		
	    tabFolder.setSelection(0);
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = LaunchManagerSWVlinker.getSymbexRunConfigurations()[index];
					Map<String, Object> lcAttributes;
					try {
						lcAttributes = selectedLC.getAttributes();
						text_model_file_path.setText((String) lcAttributes.get(IWorkflowConfigurationConstants.ATTR_SPECIFICATION_MODEL_FILE_LOCATION));
						for(SectionCompositeCreator ccc: compositeSections) {
							ccc.updateCollapsedContent(lcAttributes);
						}
					} catch (CoreException e1) {
						e1.printStackTrace();
					}
				}
				else {
					text_model_file_path.setText("...");
					for(SectionCompositeCreator ccc: compositeSections) {
						ccc.updateCollapsedContent(new HashMap<String, Object>());
					}
				}
			}
		});
	}
	
	private void openLaunchConfigurationDialog(ILaunchConfiguration launchConfig, String mode) {
		IStructuredSelection selection = new StructuredSelection(launchConfig);
		ILaunchGroup group = DebugUITools.getLaunchGroup(launchConfig, mode);
		String groupIdentifier = group == null ? IDebugUIConstants.ID_RUN_LAUNCH_GROUP : group.getIdentifier();
		DebugUITools.openLaunchConfigurationDialogOnGroup(scrollform.getShell(), selection, groupIdentifier, null);
	}

	private Action action_launch_runconf;
	private Action action_launch_debugconf;
	private Action action_opend_runconf;
	private Action action_opend_debugconf;
	
	private Action action_opend_help;
	
	private void makeActions() {
		action_launch_runconf = new Action() {
			public void run() {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = LaunchManagerSWVlinker.getSymbexRunConfigurations()[index];
					if (selectedLC != null) {
						DebugUITools.launch(selectedLC, "run");
					} else {
						showMessage("Selected Launch Configuration not found");
					}
				} else {
					showMessage("No Launch Configuration selected");
				}
			}
		};
		action_launch_runconf.setText("Launch Run Configuration");
		action_launch_runconf.setToolTipText("Launch Selected Run Configuration");
		action_launch_runconf.setImageDescriptor(ImageResources.getImageDescriptor(ImageResources.IMAGE__LAUNCHRUN_ICON));
		
		action_launch_debugconf = new Action() {
			public void run() {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = LaunchManagerSWVlinker.getSymbexRunConfigurations()[index];
					if (selectedLC != null) {
						DebugUITools.launch(selectedLC, "debug");
					} else {
						showMessage("Selected Launch Configuration not found");
					}
				} else {
					showMessage("No Launch Configuration selected");
				}
			}
		};
		action_launch_debugconf.setText("Launch Debug Configuration");
		action_launch_debugconf.setToolTipText("Launch Selected Debug Configuration");
		action_launch_debugconf.setImageDescriptor(ImageResources.getImageDescriptor(ImageResources.IMAGE__LAUNCHDEBUG_ICON));

		
		action_opend_runconf = new Action() {
			public void run() {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = LaunchManagerSWVlinker.getSymbexRunConfigurations()[index];
					if (selectedLC != null) {
						openLaunchConfigurationDialog(selectedLC, "run");
					} else {
						showMessage("Selected Launch Configuration not found");
					}
				} else {
					showMessage("No Launch Configuration selected");
				}
			}
		};
		action_opend_runconf.setText("Open Run Configurations...");
		action_opend_runconf.setToolTipText("Open the Run Configurations Dialog");
		action_opend_runconf.setImageDescriptor(ImageResources.getImageDescriptor(ImageResources.IMAGE__DIALRUN_ICON));
		
		action_opend_debugconf = new Action() {
			public void run() {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = LaunchManagerSWVlinker.getSymbexRunConfigurations()[index];
					if (selectedLC != null) {
						openLaunchConfigurationDialog(selectedLC, "debug");
					} else {
						showMessage("Selected Launch Configuration not found");
					}
				} else {
					showMessage("No Launch Configuration selected");
				}
			}
		};
		action_opend_debugconf.setText("Open Debug Configuration...");
		action_opend_debugconf.setToolTipText("Open the Debug Configuration Dialog");
		action_opend_debugconf.setImageDescriptor(ImageResources.getImageDescriptor(ImageResources.IMAGE__DIALDEBUG_ICON));
	
		action_opend_help = new Action() {
			public void run() {
				//PlatformUI.getWorkbench().getHelpSystem().displayHelp(String contextId);
			}
		};
		action_opend_help.setText("Open Diversity Help");
		action_opend_help.setToolTipText("Open the Diversity Help");
		action_opend_help.setImageDescriptor(ImageResources.getImageDescriptor(ImageResources.IMAGE__HELP_ICON));
	}

}
