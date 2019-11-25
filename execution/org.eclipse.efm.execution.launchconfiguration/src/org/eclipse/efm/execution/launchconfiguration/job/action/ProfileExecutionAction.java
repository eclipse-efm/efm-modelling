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
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.texteditor.IUpdate;

public class ProfileExecutionAction extends Action implements IUpdate, IMenuCreator  {

	final ImageDescriptor eImageDescriptor =
			ImageResources.getImageDescriptor(
					ImageResources.IMG_ELCL16_PROFILE_EXEC);

	final ImageDescriptor dImageDescriptor =
			ImageResources.getImageDescriptor(
					ImageResources.IMG_DLCL16_PROFILE_EXEC);


	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;

	private Menu fMenu;


	private class ProfileExecutionCountAction extends Action implements IUpdate {

		private final int fExecutionCount;

		public ProfileExecutionCountAction(final String text, final int executionCount) {
			super(text);

			this.fExecutionCount = executionCount;

			setToolTipText("Profile " + executionCount
					+ " Execution of " + fSymbexSpiderConsolePage.getProcessName());


			setImageDescriptor(eImageDescriptor);
			setHoverImageDescriptor(eImageDescriptor);
			setDisabledImageDescriptor(dImageDescriptor);

//			PlatformUI.getWorkbench().getHelpSystem().setHelp(
//					this, IConsoleHelpContextIds.CONSOLE_WORD_WRAP_ACTION);

			update();
		}

		public ProfileExecutionCountAction(final int executionCount) {
			this("Profile " + executionCount + " Executions", executionCount);
		}

		@Override
		public void run() {
			fSymbexSpiderConsolePage.profileExecutionProcess(this.fExecutionCount);
		}

		@Override
		public void update() {
			setEnabled(! fSymbexSpiderConsolePage.isProcessRunning());
		}

//		public void dispose() {
//			fSymbexSpiderConsolePage = null;
//		}

	}


	public ProfileExecutionAction(
			final SymbexSpiderConsolePage symbexSpiderConsolePage) {
		super("ProfileExecution", AS_DROP_DOWN_MENU);

		this.fSymbexSpiderConsolePage = symbexSpiderConsolePage;

		setToolTipText("Profile Execution of "
				+ symbexSpiderConsolePage.getProcessName()
				+ " until Terminate Action");

		setImageDescriptor(eImageDescriptor);
		setHoverImageDescriptor(eImageDescriptor);
		setDisabledImageDescriptor(dImageDescriptor);

//		PlatformUI.getWorkbench().getHelpSystem().setHelp(
//				this, IConsoleHelpContextIds.CONSOLE_WORD_WRAP_ACTION);

		update();
	}

	@Override
	public void run() {
		fSymbexSpiderConsolePage.profileExecutionProcess(Integer.MAX_VALUE);
	}

	@Override
	public void update() {
		setEnabled(! fSymbexSpiderConsolePage.isProcessRunning());
	}

	@Override
	public void dispose() {
		fSymbexSpiderConsolePage = null;

		if (fMenu != null) {
			fMenu.dispose();
			fMenu = null;
		}
	}


	@Override
	public void runWithEvent(final Event event) {
		if( (event.detail == SWT.ARROW) && (event.widget instanceof ToolItem) ) {
			final ToolItem toolItem = (ToolItem) event.widget;
			final Control control = toolItem.getParent();
			final Menu menu = getMenu(control);

			final Rectangle bounds = toolItem.getBounds();
			final Point topLeft = new Point(bounds.x, bounds.y + bounds.height);
			menu.setLocation(control.toDisplay(topLeft));
			menu.setVisible(true);
		}
		else {
			run();
		}
	}

	@Override
	public Menu getMenu(final Control parent) {
		if (fMenu != null) {
			fMenu.dispose();
		}

		fMenu = new Menu(parent);
		int accel = 1;

		addActionToMenu(fMenu, new ProfileExecutionCountAction(
				"Profile Execution until Terminate Action", Integer.MAX_VALUE),
				accel++);

		addActionToMenu(fMenu, new ProfileExecutionCountAction(
				"Profile Execution up to FULL-Coverage", -1),
				accel++);
		new Separator("Profile_N_Executions").fill(fMenu, -1); //$NON-NLS-1$

		addActionToMenu(fMenu, new ProfileExecutionCountAction(10), accel++);

		addActionToMenu(fMenu, new ProfileExecutionCountAction(20), accel++);

		addActionToMenu(fMenu, new ProfileExecutionCountAction(42), accel++);

		addActionToMenu(fMenu, new ProfileExecutionCountAction(100), accel++);

		addActionToMenu(fMenu, new ProfileExecutionCountAction(1000), accel++);

		return fMenu;
	}

	private void addActionToMenu(final Menu parent, final Action action, final int accelerator) {
		if (accelerator < 10) {
			final StringBuilder label= new StringBuilder();
			//add the numerical accelerator
			label.append('&');
			label.append(accelerator);
			label.append(' ');
			label.append(action.getText());
			action.setText(label.toString());
		}

		final ActionContributionItem item = new ActionContributionItem(action);
		item.fill(parent, -1);
	}

	@Override
	public Menu getMenu(final Menu parent) {
		return null;
	}

}
