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
package org.eclipse.efm.execution.launchconfiguration;

import java.util.ArrayList;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.efm.execution.core.Activator;
import org.eclipse.efm.execution.core.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.CommonCriteriaTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.DebugTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.DeveloperTuningTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.ExpertTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.MainTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.SymbexRuntimeTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.TestGenerationTab;
import org.eclipse.jface.preference.IPreferenceStore;

public class LaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup
		implements IWorkflowPreferenceConstants {

	protected MainTab fMainTab;

	protected ExpertTab fExpertTab;

	public MainTab getMainTab() {
		return fMainTab;
	}

	public ExpertTab getExpertTab() {
		return fExpertTab;
	}



	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {

		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();

		ArrayList<ILaunchConfigurationTab> tabList =
				new ArrayList<ILaunchConfigurationTab>();

		fMainTab = new MainTab(this);
		tabList.add( fMainTab );

		tabList.add( new CommonCriteriaTab(this) );
		tabList.add( new TestGenerationTab(this) );

		if( ILaunchManager.DEBUG_MODE.equals(mode) )
		{
			if( prefs.getBoolean(PREF_DEBUG_OPTIONS) )
			{
				tabList.add( new DebugTab(this) );
			}
			if( prefs.getBoolean(PREF_EXPERT_MODE) )
			{
				fExpertTab = new ExpertTab(this);
				tabList.add( fExpertTab );
			}

			if( LaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION )
			{
				if ( prefs.getBoolean(PREF_SYMBEX_DEVELOPER_MODE) )
				{
					tabList.add( new DeveloperTuningTab(this) );
				}
			}
		}

		tabList.add( new RefreshTab() );

		if( ILaunchManager.DEBUG_MODE.equals(mode) )
		{
			tabList.add( new SymbexRuntimeTab() );
		}

		tabList.add( new CommonTab() );

		setTabs( tabList.toArray( new ILaunchConfigurationTab[tabList.size()] ) );
	}
}
