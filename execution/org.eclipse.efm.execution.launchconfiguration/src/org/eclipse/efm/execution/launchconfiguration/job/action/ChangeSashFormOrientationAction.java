/*******************************************************************************
 * Copyright (c) 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.launchconfiguration.job.action;

import org.eclipse.efm.execution.launchconfiguration.job.console.SymbexSpiderConsolePage;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.texteditor.IUpdate;

public class ChangeSashFormOrientationAction extends Action implements IUpdate  {

	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;

	final ImageDescriptor enablePaneRightImage =
			ImageResources.getImageDescriptor(
					ImageResources.IMG_ELCL16_PANE_RIGHT);

	final ImageDescriptor disablePaneRightImage =
			ImageResources.getImageDescriptor(
					ImageResources.IMG_DLCL16_PANE_RIGHT);

	final ImageDescriptor EnablePaneUnderImage =
			ImageResources.getImageDescriptor(
					ImageResources.IMG_ELCL16_PANE_UNDER);

	final ImageDescriptor disablePaneUnderImage =
			ImageResources.getImageDescriptor(
					ImageResources.IMG_DLCL16_PANE_UNDER);


	protected void setImageDescriptor() {
		if( fSymbexSpiderConsolePage.isSashFormOrientationHorizontal() ) {
			setImageDescriptor(EnablePaneUnderImage);
			setHoverImageDescriptor(EnablePaneUnderImage);
			setDisabledImageDescriptor(disablePaneUnderImage);
		}
		else {
			setImageDescriptor(enablePaneRightImage);
			setHoverImageDescriptor(enablePaneRightImage);
			setDisabledImageDescriptor(disablePaneRightImage);
		}
	}


	public ChangeSashFormOrientationAction(
			final SymbexSpiderConsolePage symbexSpiderConsolePage) {
		super("Change Sash Orientation");

		this.fSymbexSpiderConsolePage = symbexSpiderConsolePage;

		setToolTipText("Change Sash Orientation");

		setImageDescriptor();

//		PlatformUI.getWorkbench().getHelpSystem().setHelp(
//				this, IConsoleHelpContextIds.CONSOLE_WORD_WRAP_ACTION);

		update();
	}

	@Override
	public void run() {
		fSymbexSpiderConsolePage.changeSashFormOrientation();

		setImageDescriptor();
	}

	@Override
	public void update() {
		setEnabled(true);
	}

	public void dispose() {
		fSymbexSpiderConsolePage = null;
	}

}
