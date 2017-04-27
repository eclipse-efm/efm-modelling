/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.ui.views.symbexlauncher;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationListener;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;

public class LaunchConfigurationManager implements ILaunchConfigurationListener {

	private static final String SYMBEX_LAUNCH_CONFIGURATION_TYPE =
			"org.eclipse.efm.execution.launchconfiguration.sew_type";

	private SymbexWorkflowView symbexWorkflowView;

	private static ILaunchManager fLaunchManager;
	private static ILaunchConfigurationType fLaunchConfigurationType;

	
	private final ILaunchConfiguration[] EMPTY_CONFIGURATIONS = new ILaunchConfiguration[0];
	private final String[] EMPTY_NAMES = new String[0];

	protected ILaunchConfiguration[] fConfigurations;
	protected String[] fNames;

	protected ILaunchConfiguration fSelection;


	public LaunchConfigurationManager(SymbexWorkflowView symbexWorkflowView) {
		this.symbexWorkflowView = symbexWorkflowView;
		
		fLaunchManager = null;
		fLaunchConfigurationType = null;

		fConfigurations = EMPTY_CONFIGURATIONS;
		fNames = EMPTY_NAMES;

		fSelection = null;

		addLaunchConfigurationListener();

		refresh();
	}


	public void refresh() {
		fLaunchManager = DebugPlugin.getDefault().getLaunchManager();
		fLaunchConfigurationType = fLaunchManager.getLaunchConfigurationType(
				SYMBEX_LAUNCH_CONFIGURATION_TYPE);
		try {
			fConfigurations = fLaunchManager.getLaunchConfigurations(fLaunchConfigurationType);

			if( (fSelection == null) && (fConfigurations.length > 0) ) {
				fSelection = fConfigurations[0];
			}

			fNames = new String[fConfigurations.length];
			for( int i = 0 ; i < fConfigurations.length ; i++ ) {
				fNames[i] = fConfigurations[i].getName();
			}

		} catch (CoreException e) {
			e.printStackTrace();
			fConfigurations = EMPTY_CONFIGURATIONS;

			fNames = EMPTY_NAMES;
		}

//		for (ILaunchConfiguration iLaunchConfiguration : lcs) {
//			if (iLaunchConfiguration.getName().equals("Test PThread")) {
//				ILaunchConfigurationWorkingCopy t = iLaunchConfiguration.getWorkingCopy();
//				ILaunchConfiguration config = t.doSave();
//				if (config != null) {
//					// config.launch(ILaunchManager.RUN_MODE, null);
//					DebugUITools.launch(config, ILaunchManager.DEBUG_MODE);
//				}
//			}
//		}

	}


	public boolean isPopulated() {
		return( fConfigurations.length > 0 );
	}

	public ILaunchConfiguration[] getConfigurations() {
		return fConfigurations;
	}

	public ILaunchConfiguration firstConfiguration() {
		return fConfigurations[0];
	}

	public ILaunchConfiguration getConfiguration(int index) {
		return fConfigurations[index];
	}


	public ILaunchConfiguration getSelection() {
		return fSelection;
	}

	public boolean hasSelection() {
		return( fSelection != null );
	}

	public void select(int index) {
		if( (index >= 0) && (index < fConfigurations.length) ) {
			fSelection = fConfigurations[index];
		}
		else {
			fSelection = null;
		}
	}


	public String[] getNames() {
		return fNames;
	}


	////////////////////////////////////////////////////////////////////////////
	// ILaunchConfigurationListener
	
	private void addLaunchConfigurationListener() {
		fLaunchManager = DebugPlugin.getDefault().getLaunchManager();
		fLaunchManager.addLaunchConfigurationListener(this);
	}
	
	public void dispose() {	
		fLaunchManager = DebugPlugin.getDefault().getLaunchManager();
		fLaunchManager.removeLaunchConfigurationListener(this);
	}

	
	@Override
	public void launchConfigurationAdded(ILaunchConfiguration configuration) {
		refresh();

		symbexWorkflowView.refreshLaunchConfigurationsGUI();
	}

	@Override
	public void launchConfigurationChanged(ILaunchConfiguration configuration) {
		if(configuration.isWorkingCopy()) {
			return;
		}
		List<String> contents = Arrays.asList(fNames);
		String chg_name = configuration.getName();

		if(contents.contains(chg_name)) {
//			System.err.println("conf changed detected on symbex launch conf " + chg_name);
			int new_index = contents.indexOf(chg_name);
			
			symbexWorkflowView.launchConfigurationChanged(configuration, new_index);
		} else {
			symbexWorkflowView.launchConfigurationChanged(configuration, -1);
		}
	}

	@Override
	public void launchConfigurationRemoved(ILaunchConfiguration configuration) {
		refresh();

		symbexWorkflowView.refreshLaunchConfigurationsGUI();
	}


	
}
