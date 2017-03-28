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
package org.eclipse.efm.ui.views.delegates;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;

public class LaunchManagerSWVlinker {
	
	private static final String SYMBEX_LAUNCH_CONFIGURATION_ID = "org.eclipse.efm.runconfiguration.launchConfigurationType";
	
	private static ILaunchManager lc_manager;
	private static ILaunchConfigurationType lc_symbex_type;
	private static ILaunchConfiguration[] lcs;
	
	public static ILaunchConfiguration[] getSymbexRunConfigurations() {
		lc_manager = DebugPlugin.getDefault().getLaunchManager();
		lc_symbex_type = lc_manager.getLaunchConfigurationType(SYMBEX_LAUNCH_CONFIGURATION_ID);
		try {
			lcs = lc_manager.getLaunchConfigurations(lc_symbex_type);
		} catch (CoreException e) {
			e.printStackTrace();
			lcs = new ILaunchConfiguration[0];
		}
		return lcs;
//            for (ILaunchConfiguration iLaunchConfiguration : lcs) {
//                if (iLaunchConfiguration.getName().equals("Test PThread")) {
//                    ILaunchConfigurationWorkingCopy t = iLaunchConfiguration.getWorkingCopy();
//                    ILaunchConfiguration config = t.doSave();
//                    if (config != null) {
//                        // config.launch(ILaunchManager.RUN_MODE, null);
//                        DebugUITools.launch(config, ILaunchManager.DEBUG_MODE);
//                    }
//                }
//            }
	}
	
	public static String[] getSymbexRunConfigurationNames() {
		ILaunchConfiguration[] lcs = getSymbexRunConfigurations();
		String[] contents = new String[lcs.length];
		for (int i=0; i<lcs.length; i++) {
			contents[i] = lcs[i].getName();
		}
		return contents;
	}
	
}
