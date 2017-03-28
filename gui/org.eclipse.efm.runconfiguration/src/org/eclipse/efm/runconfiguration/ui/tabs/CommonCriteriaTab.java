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
package org.eclipse.efm.runconfiguration.ui.tabs;

import org.eclipse.efm.core.workflow.Activator;
import org.eclipse.efm.runconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.efm.ui.views.launchconfigurations.components.CommonCriteriaCompositeMaker;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.efm.ui.resources.HelpCoReferee;


public class CommonCriteriaTab extends AbstractSewLaunchConfigurationTab {

	public CommonCriteriaTab(LaunchConfigurationTabGroup groupTab) {
		super(groupTab);
		contentCompositeManager = new CommonCriteriaCompositeMaker(this);
		setHelpContextId(HelpCoReferee.efm_runconf_commoncriteria_tab);
	}

	@Override
	public String getName() {
		return "Common Criteria";
	}

}
