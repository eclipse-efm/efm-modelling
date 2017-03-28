/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.runconfiguration.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.efm.core.workflow.IWorkflowConfigurationConstants;
import org.eclipse.efm.runconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.efm.ui.views.utils.LaunchConfigurationEditorCommunicationInterface;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractSewLaunchConfigurationTab
		extends AbstractLaunchConfigurationTab
		implements IWorkflowConfigurationConstants, LaunchConfigurationEditorCommunicationInterface{

	protected LaunchConfigurationTabGroup fGroupTab;

	public LaunchConfigurationTabGroup getGroupTab() {
		return fGroupTab;
	}

	public MainTab getMainTab() {
		return fGroupTab.getMainTab();
	}

	/**
	 * Constructor
	 * @param groupTab
	 */
	public AbstractSewLaunchConfigurationTab(LaunchConfigurationTabGroup groupTab) {
		super();
		this.fGroupTab = groupTab;
	}

	@Override
	public void setMessage(String message) {
		super.setMessage(message);
	}

	@Override
	public void setWarningMessage(String warningMessage) {
		super.setWarningMessage(warningMessage);
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		super.setErrorMessage(errorMessage);
	}


	@Override
	public void updateLaunchConfigurationDialog() {
		super.updateLaunchConfigurationDialog();
	}

	@Override
	public void scheduleUpdateJob() {
		super.scheduleUpdateJob();
	}

	@Override
	protected Shell getShell() {
		return super.getShell();
	}
	
	@Override
	public void updateGUI() {
		updateLaunchConfigurationDialog();
	}

	/**
	 * visibleAndExclude
	 * @param aControl
	 * @param visible
	 */
	public void visibleAndExclude(Control aControl, boolean visible) {
		aControl.setVisible(visible);

		Object gd = aControl.getLayoutData();
		if (gd instanceof GridData) {
			((GridData)gd).exclude = (! visible);
		}
	}

}
