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
import org.eclipse.ui.texteditor.IUpdate;

public class ChangeSashFormOrientationAction extends Action implements IUpdate  {

	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;

	public ChangeSashFormOrientationAction(
			final SymbexSpiderConsolePage symbexSpiderConsolePage) {
		super("Change Sash Orientation");

		this.fSymbexSpiderConsolePage = symbexSpiderConsolePage;

		setToolTipText("Change Sash Orientation");

		setHoverImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__REFRESH_ICON));

		setDisabledImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__REFRESH_ICON));
		setImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__REFRESH_ICON));

//		PlatformUI.getWorkbench().getHelpSystem().setHelp(
//				this, IConsoleHelpContextIds.CONSOLE_WORD_WRAP_ACTION);

		update();
	}

	@Override
	public void run() {
		fSymbexSpiderConsolePage.changeSashFormOrientation();
	}

	@Override
	public void update() {
		setEnabled(true);
	}

	public void dispose() {
		fSymbexSpiderConsolePage = null;
	}

}
