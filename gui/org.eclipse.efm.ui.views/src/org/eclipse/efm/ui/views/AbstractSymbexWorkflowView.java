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



import org.eclipse.ui.part.ViewPart;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractSymbexWorkflowView extends ViewPart {
	
	protected Composite parentComposite;
	
	public FormToolkit toolkit;
	public ScrolledForm scrollform;
	protected Composite tabbedCompositeMaster;
	public CTabFolder tabFolder;
	
	protected void setupFormFrame() {
		toolkit = new FormToolkit(parentComposite.getDisplay());
		scrollform = toolkit.createScrolledForm(parentComposite);
		scrollform.setText("Run Configuration");
		GridLayout layout = new GridLayout(1, false);
		scrollform.getBody().setLayout(layout);

		//scrollform.addHelpListener(listener);
		//this.setHelpContextId("org.eclipse.efm.runconfiguration.efm_runconf_commoncriteria_tab");
	}

	protected void setupTopLevelActionBars(Action[] acts) {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager pullDownMenuManager = bars.getMenuManager();
		pullDownMenuManager.removeAll();
		for(Action action: acts) {
			pullDownMenuManager.add(action);
			pullDownMenuManager.add(new Separator());
		}
		IToolBarManager toolBarMenuManager = bars.getToolBarManager();
		toolBarMenuManager.removeAll();
		fillToolBar(toolBarMenuManager, acts);
	}
	
	protected void fillToolBar(IToolBarManager manager, Action[] acts) {
		for(Action action: acts) {
			manager.add(action);
		}
	}
	
	protected void showMessage(String message) {
		MessageDialog.openInformation(
				scrollform.getShell(),
			"Symbex Workflow",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		scrollform.setFocus();
	}
}
