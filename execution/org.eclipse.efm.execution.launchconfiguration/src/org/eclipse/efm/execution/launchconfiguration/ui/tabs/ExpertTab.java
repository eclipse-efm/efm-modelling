/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial Implementation (tab-based, inserted in Run Configurations dialog)
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - New API (free-composite-based, no type assumptions on parent)
 *******************************************************************************/
package org.eclipse.efm.execution.launchconfiguration.ui.tabs;

import org.eclipse.efm.execution.configuration.common.ui.page.expert.ExpertConfigurationPage;
import org.eclipse.efm.execution.launchconfiguration.HelpContextIdConstants;
import org.eclipse.efm.execution.launchconfiguration.LaunchConfigurationTabGroup;

public class ExpertTab extends AbstractSewLaunchConfigurationTab {

	public ExpertTab(LaunchConfigurationTabGroup groupTab) {
		super(groupTab);

		contentCompositeManager = new ExpertConfigurationPage(this);

		setHelpContextId(HelpContextIdConstants.sew_launch_Expert_tab);
	}

	@Override
	public String getName() {
		return "Expert";
	}

}
