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
package org.eclipse.efm.ui.views;



import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.efm.runconfiguration.workflow.IWorkflowConfigurationConstants;
import org.eclipse.efm.ui.views.mitems.ManagerLinker;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.AnalysisProfileCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.DevelopperCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.ExecutionCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.ExpertCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.SectionCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.StopCriteriaCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.TestGenCompositeCreator;
import org.eclipse.efm.ui.resources.UIfmlResources;

public class SymbexWorkflowView extends AbstractSymbexWorkflowView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.efm.ui.views.SymbexWorkflowView";
	
	private ManagerLinker mLinker;
	
	public Set<SectionCompositeCreator> compositeSections;
	
	private Text text_model_file_path;
	
	private Combo combo;
	
	/**
	 * The constructor.
	 */
	public SymbexWorkflowView() {
		mLinker = new ManagerLinker();
		compositeSections = new HashSet<SectionCompositeCreator>();
		makeActions();
		}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		parentComposite = parent;

		setupFormFrame();
		createContents();

		contributeToActionBars();
	}
	
	private void createContents() {
		combo = new Combo(scrollform.getBody(), SWT.READ_ONLY);
		String[] contents = mLinker.getSymbexRunConfigurationNames();
		combo.setItems(contents);
		
		text_model_file_path = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, scrollform.getBody(), "Model File :", 1);
		
		new StopCriteriaCompositeCreator(mLinker, this);
		
		new AnalysisProfileCompositeCreator(mLinker, this);
		
		new ExpertCompositeCreator(mLinker, this);
		
		new DevelopperCompositeCreator(mLinker, this);
		
		new ExecutionCompositeCreator(mLinker, this);
		
		new TestGenCompositeCreator(mLinker, this);
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = mLinker.getSymbexRunConfigurations()[index];
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

	private void makeActions() {
		Action action_runconf = new Action() {
			public void run() {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = mLinker.getSymbexRunConfigurations()[index];
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
		action_runconf.setText("Launch Run Configuration");
		action_runconf.setToolTipText("Launch Selected Run Configuration");
		action_runconf.setImageDescriptor(UIfmlResources.getImageDescriptor(UIfmlResources.IMAGE__RUNCONF_ICON));
		
		Action action_debugconf = new Action() {
			public void run() {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					ILaunchConfiguration selectedLC = mLinker.getSymbexRunConfigurations()[index];
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
		action_debugconf.setText("Launch Debug Configuration");
		action_debugconf.setToolTipText("Launch Selected Debug Configuration");
		action_debugconf.setImageDescriptor(UIfmlResources.getImageDescriptor(UIfmlResources.IMAGE__RUNDEBUG_ICON));
		
		actions = (new Action[] {action_runconf, action_debugconf});
	}

}
