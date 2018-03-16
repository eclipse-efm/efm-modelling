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

import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;

public abstract class AbstractSymbexWorkflowView extends ViewPart
		implements ILaunchConfigurationGUIelement , IWorkflowConfigurationConstants {

	protected Composite parentComposite;

	protected FormWidgetToolkit toolkit;

	public ScrolledForm scrollform;

	private Label message_text_display;
	private Label message_image_display;


	protected void setupFormFrame() {
		toolkit = new FormWidgetToolkit(parentComposite.getDisplay());

		scrollform = toolkit.createScrolledForm(parentComposite);
		//scrollform.setText("Run Configuration");
		GridLayout layout = new GridLayout(1, false);
		scrollform.getBody().setLayout(layout);

		createMessageDisplayGraphics();
	}


	private Composite message_display_parentcomposite;

	private void createMessageDisplayGraphics() {
		message_display_parentcomposite = toolkit.createComposite(scrollform.getBody());

		GridLayout gl = new GridLayout(2, false);
		message_display_parentcomposite.setLayout(gl);

		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		message_display_parentcomposite.setLayoutData(gd);

		message_image_display = toolkit.createLabel(message_display_parentcomposite, null);

		GridData gd2 = new GridData(SWT.FILL,SWT.FILL, true, false);

		message_text_display = toolkit.createLabel(message_display_parentcomposite, null);
		message_text_display.setLayoutData(gd2);
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
		toolkit.fillToolBar(toolBarMenuManager, acts);
	}

	protected void showMessage(String message) {
		MessageDialog.openInformation(scrollform.getShell(), "Symbex Workflow", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		scrollform.setFocus();
	}

	// ======================================================================================
	//                              ILaunchConfigurationGUIelement interface methods
	// ======================================================================================


	///////////////////////////////////////////////////////////////////////////
	// Form / Widget Toolkit
	///////////////////////////////////////////////////////////////////////////

	@Override
	public IWidgetToolkit getWidgetToolkit() {
		return toolkit;
	}

	public FormWidgetToolkit getFormWidgetToolkit() {
		return toolkit;
	}


	///////////////////////////////////////////////////////////////////////////
	// Message API
	///////////////////////////////////////////////////////////////////////////

	@Override
	public void clearErrorMessage() {
		AnalysisProfileKind analysisProfile =
				AnalysisProfileKind.get(message_text_display.getText());
		if( analysisProfile == null  ) {
			message_text_display.setText("");
			message_image_display.setImage(null);
		}
	}

	@Override
	public void setMessage(String message){
		if(message != null) {
			message_text_display.setText(message);
		} else {
			message_text_display.setText("");
		}
		message_image_display.setImage(
				ImageResources.getImage(
						ImageResources.IMAGE__QUICKASSIST_ELCL16_ICON));

		message_display_parentcomposite.layout();
	}

	@Override
	public void setWarningMessage(String warningMessage){
		if(warningMessage != null) {
			message_text_display.setText(warningMessage);

			message_image_display.setImage(
					ImageResources.getImage(
							ImageResources.IMAGE__WARNING_ICON));
		} else {
			message_text_display.setText("");
			message_image_display.setImage(null);
		}

		message_display_parentcomposite.layout();
	}

	@Override
	public void setErrorMessage(String errorMessage){
		if(errorMessage != null) {
			message_text_display.setText(errorMessage);

			message_image_display.setImage(
					ImageResources.getImage(
							ImageResources.IMAGE__ERROR_ICON));
		} else {
			message_text_display.setText("");
			message_image_display.setImage(null);
		}

		message_display_parentcomposite.layout();
	}

}
