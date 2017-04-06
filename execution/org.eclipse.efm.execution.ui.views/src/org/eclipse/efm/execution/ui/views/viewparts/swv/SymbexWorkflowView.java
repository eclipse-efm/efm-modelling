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
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.efm.execution.ui.views.delegates.LaunchManagerSWVlinker;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.AbstractTabItemContentCreator;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.CommonCriteriaTabItemContentCreator;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.MainTabItemContentCreator;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.TestGenerationTabItemContentCreator;
import org.eclipse.efm.execution.ui.views.utils.GenericCompositeCreator;
import org.eclipse.jface.action.Action;
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

public class SymbexWorkflowView extends AbstractSymbexWorkflowView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.efm.ui.views.SymbexWorkflowView";
	
	//public Set<SectionCompositeCreator> compositeSections;
	
	private Set<AbstractTabItemContentCreator> compMakers;
	
	private Combo combo;

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		parentComposite = parent;
		//compositeSections = new HashSet<SectionCompositeCreator>();
		
		// Actions
		makeActions();
		setupTopLevelActionBars(new Action[] {action_launch_runconf, action_launch_debugconf, action_opend_runconf, action_opend_debugconf, action_apply_changes});
		
		// Frame
		setupFormFrame();
		
		combo = GenericCompositeCreator.createComposite_combo_text_from_toolkit(getFormToolkit(), scrollform.getBody(), "Run Configuration :", 2);
				//new Combo(scrollform.getBody(), SWT.READ_ONLY);
		UpdateSymbexWorkflowViewListener.updateAnySWVcombo(combo);
		//text_model_file_path = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, scrollform.getBody(), "Model File :", 2);
		
		tabbedCompositeMaster = getFormToolkit().createComposite(scrollform.getBody());
		GridLayout gl = new GridLayout(1, false);
		tabbedCompositeMaster.setLayout(gl);
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true);
		tabbedCompositeMaster.setLayoutData(gd);
		
		tabFolder = new CTabFolder( tabbedCompositeMaster, SWT.BOTTOM );
	    tabFolder.setLayoutData(new GridData(SWT.FILL,SWT.FILL, true, true));
	    getFormToolkit().adapt(tabFolder, true, true);
		
	    createSectionsContent();
	
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "");
		
		addUpdateSWVlistener();
		

	}
	
	private void addUpdateSWVlistener() {
		try {
			UpdateSymbexWorkflowViewListener uSWVl = new UpdateSymbexWorkflowViewListener(combo, this);
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
	
	private CTabItem createTabItemAndComposite(String tabname) {
		CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE );
		tabItem.setText(tabname);
		
		Composite tbcomp = getFormToolkit().createComposite(tabFolder);
		
		GridLayout gl = new GridLayout(1, false);
		tbcomp.setLayout(gl);
		
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true);
		tbcomp.setLayoutData(gd);
		
		tabItem.setControl(tbcomp);
		
		return tabItem;
	}
	
	private Composite first_tbcomp;
	private CTabItem fst_tabitem;
	
	//private Map<Integer, AbstractCompositeMaker> quickDico;
	private Composite cc_tbcomp;
	private CTabItem cc_tabitem;
	private Composite tg_tbcomp;
	private CTabItem tg_tabitem;
	
	private void createSectionsContent() {
		
		compMakers = new HashSet<AbstractTabItemContentCreator>();
		
		fst_tabitem = createTabItemAndComposite("Main");
		first_tbcomp = (Composite) fst_tabitem.getControl();
		MainTabItemContentCreator firstcmp = new MainTabItemContentCreator(this, first_tbcomp);
		Map<String, Action> firstacts = new HashMap<String, Action>();
		firstacts.put("action_apply_changes", action_apply_changes);
		firstcmp.setRegisteredActions(firstacts);
		firstcmp.createTabItemContent();
		compMakers.add(firstcmp);
//		quickDico.put(1, firstcmp);

		cc_tabitem = createTabItemAndComposite("Common Criteria");
		cc_tbcomp = (Composite) cc_tabitem.getControl();
		CommonCriteriaTabItemContentCreator cccmp = new CommonCriteriaTabItemContentCreator(this, cc_tbcomp);
		cccmp.createTabItemContent();
		compMakers.add(cccmp);
//		quickDico.put(1, cccmp);
		
		tg_tabitem = createTabItemAndComposite("Test Generation");
		tg_tbcomp = (Composite) tg_tabitem.getControl();
		TestGenerationTabItemContentCreator tgcmp = new TestGenerationTabItemContentCreator(this, tg_tbcomp);
		tgcmp.createTabItemContent();
		compMakers.add(tgcmp);
//		quickDico.put(3, tgcmp);		
		
//
//		tg_tabitem = createTabItemAndComposite("Test Generation");
//		tg_tbcomp = (Composite) tg_tabitem.getControl();
//		AbstractCompositeMaker tgcmp = new TestGenerationCompositeMaker(this);
//		//tgcmp.initializeFieldValuesFrom(null);
//		tgcmp.createControlMain(tg_tbcomp);
//		compMakers.add(tgcmp);
//		quickDico.put(3, tgcmp);
//		//toolkit.adapt(inner_tg_tbcomp);
//		//tgcmp.propagateVisibility(tg_tbcomp, false);
//
//	    tabFolder.setSelection(0);
//	    updateEnableTab(false);
		
		
		
	    //tabFolder.setTabHeight(height);
	    //tabFolder.getSelection()
	    //tabFolder.pack();
	    
//	    tabFolder.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				tabFolder.update();
//				System.err.println("bip");
//				System.err.println( Integer.toString(tabFolder.getTabHeight()) );
//				Control tbicontr = tabFolder.getSelection().getControl();
//				Integer content_height = tbicontr.getSize().y;
//				System.err.println( content_height );
//				scrollform.reflow(true);
//				System.err.println("bip");
//				System.err.println( Integer.toString(tabFolder.getTabHeight()) );
//				tbicontr = tabFolder.getSelection().getControl();
//				content_height = tbicontr.getSize().y;
//				System.err.println( content_height );
//				System.err.println( "===" );
//				if (quickDico.containsKey(tabFolder.getSelectionIndex())) {
//					AbstractCompositeMaker current = quickDico.get(tabFolder.getSelectionIndex());
//					Integer mysize = current.getControlMain().getSize().y;
//					System.err.println( "==" );
//					System.err.println(Integer.toString(mysize));
//					System.err.println( "==" );
//					
//				}
//			}
//	    });
	    
	    
	    
	    combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateGUI();
			}
		});
	}
	
	private void updateEnableTab(boolean isLaunchConfSelected) {
		if(isLaunchConfSelected) {
		    first_tbcomp.setEnabled(true);
		    //tg_tbcomp.setEnabled(true);
		    //cc_tbcomp.setEnabled(true);
		} else {
		    first_tbcomp.setEnabled(false);
		    //tg_tbcomp.setEnabled(false);
		    //cc_tbcomp.setEnabled(false);
		}
	}
	
	private void openLaunchConfigurationDialog(ILaunchConfiguration launchConfig, String mode) {
		IStructuredSelection selection = new StructuredSelection(launchConfig);
		ILaunchGroup group = DebugUITools.getLaunchGroup(launchConfig, mode);
		String groupIdentifier = group == null ? IDebugUIConstants.ID_RUN_LAUNCH_GROUP : group.getIdentifier();
		DebugUITools.openLaunchConfigurationDialogOnGroup(scrollform.getShell(), selection, groupIdentifier, null);
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
	
		action_apply_changes = new Action() {
			public void run() {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = LaunchManagerSWVlinker.getSymbexRunConfigurations()[index];
					ILaunchConfigurationWorkingCopy newcopy;
					try {
						newcopy = selectedLC.getWorkingCopy();
						for(AbstractTabItemContentCreator acm : compMakers) {
							acm.applyUpdatesOnFieldValuesFrom(newcopy);
						}
						newcopy.doSave();
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
	
	private ILaunchConfigurationWorkingCopy lastlcwc;
	
	@Override
	public void updateGUI() {
		int index = combo.getSelectionIndex();
		if (index != -1) {
			ILaunchConfiguration selectedLC = LaunchManagerSWVlinker.getSymbexRunConfigurations()[index];
			updateEnableTab(true);
			
			try {
				ILaunchConfigurationWorkingCopy newcopy = selectedLC.getWorkingCopy();
				if(lastlcwc != null && lastlcwc.contentsEqual(newcopy)) {
					return;
				} else {
					lastlcwc = newcopy;
					System.err.println("++++---- Biopp");
					for(AbstractTabItemContentCreator acm : compMakers) {
						acm.initializeFieldValuesFrom(newcopy);
					}
				}
				
			} catch (CoreException e) {
				setErrorMessage("could not get launch configuration working copy");
				e.printStackTrace();
			}
		}
		else {
			tabFolder.setSelection(0);
			updateEnableTab(false);
		}
	}	

	@Override // to change visibility to public
	public void scheduleUpdateJob(){
		scrollform.reflow(true);
		tabbedCompositeMaster.layout();
		tabFolder.layout();
		tabbedCompositeMaster.layout();
		scrollform.reflow(true);
	}	
	
}
