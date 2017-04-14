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
package org.eclipse.efm.execution.ui.views.delegates;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;

public class LaunchConfigurationManager {

	private static final String SYMBEX_LAUNCH_CONFIGURATION_TYPE =
			"org.eclipse.efm.execution.launchconfiguration.sew_type";

	private static ILaunchManager lc_manager;
	private static ILaunchConfigurationType lc_symbex_type;

	protected ILaunchConfiguration[] configurations;
	protected String[] names;

	protected ILaunchConfiguration selection;


	public LaunchConfigurationManager() {
		lc_manager = null;
		lc_symbex_type = null;

		configurations = new ILaunchConfiguration[0];
		names = new String[0];

		selection = null;

		refresh();
	}


	public void refresh() {
		lc_manager = DebugPlugin.getDefault().getLaunchManager();
		lc_symbex_type = lc_manager.getLaunchConfigurationType(
				SYMBEX_LAUNCH_CONFIGURATION_TYPE);
		try {
			configurations = lc_manager.getLaunchConfigurations(lc_symbex_type);

			if( (selection == null) && (configurations.length > 0) ) {
				selection = configurations[0];
			}

			names = new String[configurations.length];
			for( int i = 0 ; i < configurations.length ; i++ ) {
				names[i] = configurations[i].getName();
			}

		} catch (CoreException e) {
			e.printStackTrace();
			configurations = new ILaunchConfiguration[0];

			names = new String[0];
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
		return( configurations.length > 0 );
	}

	public ILaunchConfiguration[] getConfigurations() {
		return configurations;
	}

	public ILaunchConfiguration firstConfiguration() {
		return configurations[0];
	}

	public ILaunchConfiguration getConfiguration(int index) {
		return configurations[index];
	}


	public ILaunchConfiguration getSelection() {
		return selection;
	}

	public boolean hasSelection() {
		return( selection != null );
	}

	public void select(int index) {
		if( (index >= 0) && (index < configurations.length) ) {
			selection = configurations[index];
		}
		else {
			selection = null;
		}
	}


	public String[] getNames() {
		return names;
	}


}
