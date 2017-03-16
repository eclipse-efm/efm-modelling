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
package org.eclipse.efm.runconfiguration;

import java.util.ArrayList;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.efm.runconfiguration.ui.CommonCriteriaTab;
import org.eclipse.efm.runconfiguration.ui.DebugTab;
import org.eclipse.efm.runconfiguration.ui.DeveloperTuningTab;
import org.eclipse.efm.runconfiguration.ui.ExpertTab;
import org.eclipse.efm.runconfiguration.ui.MainTab;
import org.eclipse.efm.runconfiguration.ui.SymbexRuntimeTab;
import org.eclipse.efm.runconfiguration.ui.TestGenerationTab;
import org.eclipse.jface.preference.IPreferenceStore;

public class LaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

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
			if( prefs.getBoolean(ToolConstants.PREF_DEBUG_OPTIONS) )
			{
				tabList.add( new DebugTab(this) );
			}
			if( prefs.getBoolean(ToolConstants.PREF_EXPERT_MODE) )
			{
				fExpertTab = new ExpertTab(this);
				tabList.add( fExpertTab );
			}

			if( LaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION )
			{
				if ( prefs.getBoolean(ToolConstants.PREF_SYMBEX_DEVELOPER_MODE) )
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
