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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.RefreshUtil;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.core.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.SupervisorTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.DebugTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.DeveloperTuningTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.ExpertTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.OverviewTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.SymbexRuntimeTab;
import org.eclipse.efm.execution.launchconfiguration.ui.tabs.TestGenerationTab;

public class LaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	private AbstractConfigurationPage[] fConfigurationPages;
	
	protected OverviewTab fOverviewTab;

	protected ExpertTab fExpertTab;

	
	public AbstractConfigurationPage[] getConfigurationPages() {
		return fConfigurationPages;
	}

	public OverviewTab getOverviewTab() {
		return fOverviewTab;
	}

	public ExpertTab getExpertTab() {
		return fExpertTab;
	}


	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ArrayList<ILaunchConfigurationTab> tabList =
				new ArrayList<ILaunchConfigurationTab>();

		ArrayList<AbstractConfigurationPage> confPageList =
				new ArrayList<AbstractConfigurationPage>();

		// OverviewTab
		fOverviewTab = new OverviewTab(this);
		tabList.add( fOverviewTab );
		confPageList.add( fOverviewTab.getConfigurationPage() );

		// SupervisorTab
		SupervisorTab supervisorTab = new SupervisorTab(this);
		tabList.add( supervisorTab );
		confPageList.add( supervisorTab.getConfigurationPage() );
		
		// TestGenerationTab
		TestGenerationTab testGenerationTab = new TestGenerationTab(this);
		tabList.add( testGenerationTab );
		confPageList.add( testGenerationTab.getConfigurationPage() );

		if( ILaunchManager.DEBUG_MODE.equals(mode) )
		{
			if( SymbexPreferenceUtil.getBooleanPreference(
					IWorkflowPreferenceConstants.PREF_DEBUG_OPTIONS) )
			{
				tabList.add( new DebugTab(this) );
			}
			if( SymbexPreferenceUtil.getBooleanPreference(
					IWorkflowPreferenceConstants.PREF_EXPERT_MODE) )
			{
				fExpertTab = new ExpertTab(this);
				
				tabList.add( fExpertTab );
				confPageList.add( fExpertTab.getConfigurationPage() );
			}

			if( LaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION )
			{
				if ( SymbexPreferenceUtil.getBooleanPreference(
						IWorkflowPreferenceConstants.PREF_SYMBEX_DEVELOPER_MODE) )
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

		setTabs( tabList.toArray(
				new ILaunchConfigurationTab[tabList.size()] ) );
		
		fConfigurationPages = confPageList.toArray(
				new AbstractConfigurationPage[confPageList.size()]);
		

	}


	public void setDefaultAttributes(ILaunchConfigurationWorkingCopy configuration) {
		// Enabling REFRESH
		try {
			String refreshScope = configuration.getAttribute(RefreshUtil.ATTR_REFRESH_SCOPE, "");
			if( (refreshScope == null) || refreshScope.isEmpty() )
			{
				configuration.setAttribute(RefreshUtil.ATTR_REFRESH_SCOPE, "${project}");
			}
		} catch (CoreException e) {
			configuration.setAttribute(RefreshUtil.ATTR_REFRESH_SCOPE, "${project}");
		}
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);

		setDefaultAttributes(configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);

		setDefaultAttributes(configuration);
	}

}
