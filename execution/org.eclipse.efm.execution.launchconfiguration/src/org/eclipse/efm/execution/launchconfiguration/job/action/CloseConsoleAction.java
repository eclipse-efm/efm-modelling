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

public class CloseConsoleAction extends Action implements IUpdate  {

	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;

	public CloseConsoleAction(
			final SymbexSpiderConsolePage symbexSpiderConsolePage) {
		super("Close");

		this.fSymbexSpiderConsolePage = symbexSpiderConsolePage;

		setToolTipText("Close Console");

		setHoverImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__REMOVE_ELCL16_ICON));

		setDisabledImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__REMOVE_DLCL16_ICON));
		setImageDescriptor(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__REMOVE_ELCL16_ICON));

		update();
	}

	@Override
	public void run() {
		fSymbexSpiderConsolePage.closePage();
	}

	@Override
	public void update() {
		setEnabled(! fSymbexSpiderConsolePage.isProcessRunning());
	}

	public void dispose() {
		fSymbexSpiderConsolePage = null;
	}

}