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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.texteditor.IUpdate;

public class CloseConsoleAction extends Action implements IUpdate  {

	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;

	public CloseConsoleAction(
			final SymbexSpiderConsolePage symbexSpiderConsolePage) {
		super("Close");

		this.fSymbexSpiderConsolePage = symbexSpiderConsolePage;

		setToolTipText("Remove Launch "
				+ symbexSpiderConsolePage.getProcessName());

		final ImageDescriptor imageDescriptor =
				ImageResources.getImageDescriptor(
						ImageResources.IMG_ELCL16_REMOVE);

		setImageDescriptor(imageDescriptor);
		setHoverImageDescriptor(imageDescriptor);
		setDisabledImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMG_DLCL16_REMOVE));

		update();
	}

	@Override
	public void run() {
		if( (! fSymbexSpiderConsolePage.isProcessRunning())
			|| MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),
					"Confirm",
					"Please confirm << Terminate & Close Launch "
					+ fSymbexSpiderConsolePage.getProcessName() + " >>!") )
		{
			fSymbexSpiderConsolePage.closePage();
		}
	}

	@Override
	public void update() {
		setEnabled(! fSymbexSpiderConsolePage.isProcessRunning());
	}

	public void dispose() {
		fSymbexSpiderConsolePage = null;
	}

}
