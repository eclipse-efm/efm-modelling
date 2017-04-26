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
package org.eclipse.efm.execution.launchconfiguration.ui.tabs;

import org.eclipse.efm.execution.configuration.common.ui.page.supervisor.SupervisorConfigurationPage;
import org.eclipse.efm.execution.launchconfiguration.HelpContextIdConstants;
import org.eclipse.efm.execution.launchconfiguration.LaunchConfigurationTabGroup;


public class SupervisorTab extends AbstractSewLaunchConfigurationTab {

	public SupervisorTab(LaunchConfigurationTabGroup groupTab) {
		super(groupTab);

		fContentCompositeManager = new SupervisorConfigurationPage(this);

		setHelpContextId(HelpContextIdConstants.sew_launch_Supervisor_tab);
	}

	@Override
	public String getName() {
		return "Supervisor";
	}

}
