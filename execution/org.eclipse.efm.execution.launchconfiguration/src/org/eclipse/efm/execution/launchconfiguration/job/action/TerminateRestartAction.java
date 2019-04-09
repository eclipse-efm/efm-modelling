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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IUpdate;

public class TerminateRestartAction extends Action implements IUpdate  {

	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;

	public TerminateRestartAction(
			final SymbexSpiderConsolePage symbexSpiderConsolePage) {
		super("Terminate and Restart");

		this.fSymbexSpiderConsolePage = symbexSpiderConsolePage;

		setToolTipText("Terminate and Restart "
				+ symbexSpiderConsolePage.getProcessName());

		setHoverImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__TERMINATE_RESTART_ELCL16_ICON));

		setDisabledImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__TERMINATE_RESTART_DLCL16_ICON));
		setImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__TERMINATE_RESTART_ELCL16_ICON));

//		PlatformUI.getWorkbench().getHelpSystem().setHelp(
//				this, IConsoleHelpContextIds.CONSOLE_WORD_WRAP_ACTION);

		update();
	}

	@Override
	public void run() {
		final Shell shell =
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		if( MessageDialog.openConfirm(shell, "Confirm",
				"Please confirm << Terminate & Restart Launch "
				+ fSymbexSpiderConsolePage.getProcessName() + " >>!") )
		{
			fSymbexSpiderConsolePage.TerminateRestartProcess();
		}
	}

	@Override
	public void update() {
		setEnabled(fSymbexSpiderConsolePage.isProcessRunning());
	}

	public void dispose() {
		fSymbexSpiderConsolePage = null;
	}

}
