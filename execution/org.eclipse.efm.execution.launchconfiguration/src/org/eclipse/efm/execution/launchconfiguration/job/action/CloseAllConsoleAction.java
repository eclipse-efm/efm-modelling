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

import org.eclipse.efm.execution.launchconfiguration.job.SymbexJob;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.texteditor.IUpdate;

public class CloseAllConsoleAction extends Action implements IUpdate  {

	public CloseAllConsoleAction() {
		super("CloseAll");

		setToolTipText("Remove All Launches");

		final ImageDescriptor imageDescriptor =
				ImageResources.getImageDescriptor(
						ImageResources.IMG_ELCL16_REMOVE_ALL);

		setImageDescriptor(imageDescriptor);
		setHoverImageDescriptor(imageDescriptor);
		setDisabledImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMG_DLCL16_REMOVE_ALL));

		update();
	}

	@Override
	public void run() {
		if( MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),
				"Confirm", "Please confirm "
				+ "<< Remove All Terminated Launches >>!") )
		{
			SymbexJob.removeAllConsole();
		}
	}

	@Override
	public void update() {
		setEnabled( SymbexJob.hasTerminatedConsole() );
	}

}
