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
package org.eclipse.efm.execution.core;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;

public class SymbexPreferenceUtil {

	private static IPath fDiversityInstallationLocation = null;


	private static IPath fDiversityAvmExecLocation = null;

	// The external dot viewer path
	private static IPath fExternalDotGraphViewerPath;


	////////////////////////////////////////////////////////////////////////////
	// PREFERENCE STORE UTILS
	////////////////////////////////////////////////////////////////////////////

	public static IPreferenceStore getDefaultPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	public static boolean getBooleanPreference(String name) {
		return Activator.getDefault().getPreferenceStore().getBoolean(name);
	}

	public static String getStringPreference(String name) {
		return Activator.getDefault().getPreferenceStore().getString(name);
	}


	public static void loadGlobals(IPreferenceStore prefs) throws Exception {
		fDiversityInstallationLocation = new Path( prefs.getString(
				IWorkflowPreferenceConstants.PREF_DIVERSITY_INSTALLATION_LOCATION) );

		fDiversityAvmExecLocation = new Path( prefs.getString(
				IWorkflowPreferenceConstants.PREF_DIVERSITY_AVM_EXECUTABLE_LOCATION) );

		fExternalDotGraphViewerPath = new Path( prefs.getString(
				IWorkflowPreferenceConstants.PREF_DIVERSITY_GRAPH_VIEWER_LOCATION) );
	}


	/**
	 * GETTER - SETTER
	 * Diversity Installation Location
	 */
	public static IPath getDiversityInstallationLocation() {
		return fDiversityInstallationLocation;
	}

	public static String strDiversityInstallationLocation() {
		return fDiversityInstallationLocation.toOSString();
	}

	public static boolean hasDiversityInstallationLocation() {
		return( fDiversityInstallationLocation != null );
	}

	public static void setDiversityInstallationLocation(IPath path) {
		fDiversityInstallationLocation = path;
	}


	/**
	 * GETTER - SETTER
	 * Diversity AVM tool Installation Location
	 */
	public static IPath getDiversityAvmExecLocation() {
		return fDiversityAvmExecLocation;
	}

	public static String strDiversityAvmExecLocation() {
		return fDiversityAvmExecLocation.toOSString();
	}

	public static boolean hasDiversityAvmExecLocation() {
		return( (fDiversityAvmExecLocation != null) &&
				fDiversityAvmExecLocation.toFile().exists() );
	}

	public static void setDiversityAvmExecLocation(IPath path) {
		fDiversityAvmExecLocation = path;
	}


	/**
	 * GETTER - SETTER
	 * External Dot Graph Viewer
	 */
	public static IPath getExternalDotGraphViewerPath() {
		return fExternalDotGraphViewerPath;
	}

	public static String strExternalDotGraphViewerPath() {
		return fExternalDotGraphViewerPath.toOSString();
	}

	public static boolean hasExternalDotGraphViewerPath() {
		return( (fExternalDotGraphViewerPath != null) &&
				fExternalDotGraphViewerPath.toFile().exists() );
	}

	public static void setExternalDotGraphViewerPath(IPath path) {
		fExternalDotGraphViewerPath = path;
	}

}
