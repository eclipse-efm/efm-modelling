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
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ISharedImages;
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
import org.eclipse.efm.runconfiguration.workflow.IWorkflowConfigurationConstants;
import org.eclipse.efm.ui.views.mitems.ManagerLinker;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.AnalysisProfileCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.CollapsibleCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.StopCriteriaCompositeCreator;


public class SymbexWorkflowView extends AbstractSymbexWorkflowView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.efm.ui.views.SymbexWorkflowView";
	
	private ManagerLinker mLinker;
	
	public Set<CollapsibleCompositeCreator> collapsibles;
	
	private Text text_model_file_path;
	
	/**
	 * The constructor.
	 */
	public SymbexWorkflowView() {
		mLinker = new ManagerLinker();
		collapsibles = new HashSet<CollapsibleCompositeCreator>();
		}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		parentComposite = parent;
		
		selfCreatedMainComposite = GenericCompositeCreator.create_GridListing_HorizontalGrabbing_Composite(parentComposite, 1);
				
		createContents();

		makeActions();

		contributeToActionBars();
	}
	
	private void addSeparator() {
		Label label = new Label(selfCreatedMainComposite, SWT.LEFT);
		label.setText("==========");
	}
	
	private void createContents() {

		Label label = new Label(selfCreatedMainComposite, SWT.LEFT);
		label.setText("Selected Run Configuration");
		
		Combo combo = new Combo(selfCreatedMainComposite, SWT.READ_ONLY);
		String[] contents = mLinker.getSymbexRunConfigurationNames();
		combo.setItems(contents);
		
		addSeparator();
		
		text_model_file_path = GenericCompositeCreator.createComposite_vertical_label_text(selfCreatedMainComposite, "Model File :");
		
		addSeparator();
		new StopCriteriaCompositeCreator(mLinker, this);
		
		addSeparator();
		new AnalysisProfileCompositeCreator(mLinker, this);
		
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
						for(CollapsibleCompositeCreator ccc: collapsibles) {
							ccc.updateCollapsedContent(lcAttributes);
						}
					} catch (CoreException e1) {
						e1.printStackTrace();
					}
				}
				else {
					text_model_file_path.setText("...");
					for(CollapsibleCompositeCreator ccc: collapsibles) {
						ccc.updateCollapsedContent(new HashMap<String, Object>());
					}
				}
			}
		});
	}
	
	
	

	private void makeActions() {
		Action action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		Action action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		actions = (new Action[] {action1, action2});
	}

}
