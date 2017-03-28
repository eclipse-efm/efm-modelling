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
package org.eclipse.efm.runconfiguration.ui.tabs;

import org.eclipse.efm.core.workflow.Activator;
import org.eclipse.efm.runconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.efm.ui.views.launchconfigurations.components.DeveloperTuningCompositeMaker;
import org.eclipse.efm.ui.resources.HelpCoReferee;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

public class DeveloperTuningTab extends AbstractSewLaunchConfigurationTab {

	public DeveloperTuningTab(LaunchConfigurationTabGroup groupTab) {
		super(groupTab);
		contentCompositeManager = new DeveloperTuningCompositeMaker(this);
		setHelpContextId(HelpCoReferee.efm_runconf_debug_tab);
	}

	@Override
	public String getName() {
		return "Developer";
	}
}
