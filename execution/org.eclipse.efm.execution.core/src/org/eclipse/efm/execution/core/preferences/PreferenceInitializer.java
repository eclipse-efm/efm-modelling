/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.execution.core.preferences;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.efm.execution.core.AbstractLaunchDelegate;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.service.datalocation.Location;

public class PreferenceInitializer extends AbstractPreferenceInitializer
			implements IWorkflowPreferenceConstants {

	public PreferenceInitializer() {
		//!! NOTHING
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore prefStore =
				SymbexPreferenceUtil.getDefaultPreferenceStore();

		// Sets the default values of the preferences.
		Location location = Platform.getInstanceLocation();
		if( location == null ) {
			location = Platform.getInstallLocation();
			if( location == null ) {
				location = Platform.getUserLocation();
			}
		}

		if( location != null ) {
			IPath installPath = new Path( location.getURL().getPath() );
			installPath = installPath.removeLastSegments(1);

			prefStore.setDefault(PREF_DIVERSITY_INSTALLATION_LOCATION,
					installPath.toOSString());


			IPath execPath = installPath.append("bin").append("diversity.exe");

			prefStore.setDefault(PREF_DIVERSITY_AVM_EXECUTABLE_LOCATION,
					execPath.toOSString());


			IPath viewerPath = installPath.append("tools")
					.append("zgrviewer").append("run.bat");

			prefStore.setDefault(PREF_DIVERSITY_GRAPH_VIEWER_LOCATION,
					viewerPath.toOSString());
		}

		// LaunchConfigurationPreferencePage Default Values
		prefStore.setDefault(PREF_EXPERT_MODE, true);

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_INCUBATION_MODE_OPTION ) {
			prefStore.setDefault(PREF_INCUBATION_MODE, true);
		}

		prefStore.setDefault(PREF_DEBUG_OPTIONS, true);

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION ) {
			prefStore.setDefault(PREF_SYMBEX_DEVELOPER_MODE, false);
		}
	}

}
