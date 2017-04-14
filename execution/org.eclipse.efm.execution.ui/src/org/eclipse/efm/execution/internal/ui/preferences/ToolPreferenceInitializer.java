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
package org.eclipse.efm.execution.internal.ui.preferences;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.efm.execution.core.IWorkflowPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.service.datalocation.Location;

public class ToolPreferenceInitializer extends AbstractPreferenceInitializer
			implements IWorkflowPreferenceConstants {

	public ToolPreferenceInitializer() {
		//!! NOTHING
	}

	@Override
	public void initializeDefaultPreferences() {
		Location location = Platform.getInstallLocation();
		if( location == null ) {
			location = Platform.getInstanceLocation();
			if( location == null ) {
				location = Platform.getUserLocation();
			}
		}
		if( location != null ) {
			IPreferenceStore prefs = SymbexPreferenceUtil.getDefaultPreferenceStore();

			IPath installPath = new Path( location.getURL().getPath() );

			prefs.setDefault(PREF_DIVERSITY_INSTALLATION_LOCATION,
					installPath.toOSString());


			IPath execPath = installPath.removeLastSegments(1).
					append("bin").append("avm.exe");

			prefs.setDefault(PREF_DIVERSITY_AVM_EXECUTABLE_LOCATION,
					execPath.toOSString());


			IPath viewerPath = installPath.removeLastSegments(1).
					append("tools").append("zgrviewer").append("run.bat");

			prefs.setDefault(PREF_DIVERSITY_GRAPH_VIEWER_LOCATION,
					viewerPath.toOSString());
		}
	}

}
