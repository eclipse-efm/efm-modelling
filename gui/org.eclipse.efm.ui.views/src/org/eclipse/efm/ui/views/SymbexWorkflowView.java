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
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.ui.views.mitems.ManagerLinker;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.AnalysisProfileCompositeCreator;
import org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites.StopCriteriaCompositeCreator;


public class SymbexWorkflowView extends AbstractSymbexWorkflowView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.efm.ui.views.SymbexWorkflowView";
	
	private ManagerLinker mLinker;
	
	private GridLayout gl_shell;
	
	private ILaunchConfiguration selectedLC;
	
	private Text text_model_file_path;
	private Text text_model_file_path2;
	
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	
	/**
	 * The constructor.
	 */
	public SymbexWorkflowView() {
		mLinker = new ManagerLinker();
		}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		parentComposite = parent;
		
		selfCreatedMainComposite = GenericCompositeCreator.create_GridListing_HorizontalGrabbing_Composite(parentComposite, 1);
				

		createContents();
		//viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
		//viewer.setContentProvider(ArrayContentProvider.getInstance());
		//viewer.setInput(new String[] { "One", "Two", "Three" });
		//String[] contents = mLinker.getSymbexRunConfigurationNames();

		//viewer.setInput(contents);
		
		//viewer.setLabelProvider(new ViewLabelProvider());
		//getSite().setSelectionProvider(viewer);
		makeActions();
		//hookContextMenu();
		//hookDoubleClickAction();
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
		
		text_model_file_path2 = GenericCompositeCreator.createComposite_horizontal_label_text(selfCreatedMainComposite, "Model File :");
		
		addSeparator();
		StopCriteriaCompositeCreator sccc = new StopCriteriaCompositeCreator(mLinker, combo);
		sccc.addComposite(selfCreatedMainComposite);
		
		addSeparator();
		AnalysisProfileCompositeCreator apcc = new AnalysisProfileCompositeCreator(mLinker, combo);
		apcc.addComposite(selfCreatedMainComposite);
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					String text = mLinker.getSymbexRunConfigurations()[index].getName();
					text_model_file_path.setText(text);
					text_model_file_path2.setText(text);
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
