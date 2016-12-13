/**
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.runconfiguration.ui;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.runconfiguration.workflow.IWorkflowConfigurationConstants;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractTabComponentPage
		implements IWorkflowConfigurationConstants {

	protected AbstractSewLaunchConfigurationTab fParentTab;

	protected Composite fCompositeParent;

	protected Composite fCompositeControl;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public AbstractTabComponentPage(AbstractSewLaunchConfigurationTab parentTab) {
		fParentTab = parentTab;

		fCompositeParent = null;

		fCompositeControl = null;
	}

	abstract public void createControl(Composite parent);

	public void setVisible(boolean visible) {
		if( fCompositeControl != null ) {
			fParentTab.visibleAndExclude(fCompositeControl, visible);
		}
	}

	public void setEnabled(boolean enabled) {
		setVisible(enabled);
	}


	abstract public void setDefaults(
			ILaunchConfigurationWorkingCopy configuration);

	abstract public void initializeFrom(ILaunchConfiguration configuration);

	abstract public void performApply(
			ILaunchConfigurationWorkingCopy configuration);


	abstract public boolean isValid(ILaunchConfiguration launchConfig);

	protected void setWarningMessage(String warningMessage) {
		fParentTab.setWarningMessage(warningMessage);
	}

	protected void setErrorMessage(String errorMessage) {
		fParentTab.setErrorMessage(errorMessage);
	}

}
