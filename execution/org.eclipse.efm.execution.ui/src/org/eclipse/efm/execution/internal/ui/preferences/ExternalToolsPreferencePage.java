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

import java.util.Locale;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.efm.execution.core.preferences.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ExternalToolsPreferencePage extends FieldEditorPreferencePage
			implements IWorkbenchPreferencePage , IWorkflowPreferenceConstants {

	public ExternalToolsPreferencePage() {
		super(GRID);

		setDescription( "External tool for Dot Format (from graphviz.org) Graph Viewer" );
	}

	@Override
	public void init(final IWorkbench workbench) {
		setPreferenceStore( SymbexPreferenceUtil.getDefaultPreferenceStore() );
	}

	@Override
	protected void createFieldEditors() {
		final FileFieldEditor fileField = new FileFieldEditor(
				PREF_DIVERSITY_GRAPH_VIEWER_LOCATION,
				//		"The Diversity AVM executable location:",
				"Graph Viewer:",
				false, FileFieldEditor.VALIDATE_ON_FOCUS_LOST,
				getFieldEditorParent());

	    String[] filterExtensions = new String[] {"*.bat", "*.sh", "*.exe", "*.*"};

	    if( Platform.getOS().startsWith(Platform.OS_WIN32) ||
	    	(Platform.getOS().toLowerCase(Locale.ENGLISH).indexOf("win") >= 0) ) {
	    	filterExtensions = new String[] { "*.bat", "*.exe", "*.*"};
	    }
	    else {
	    	filterExtensions = new String[] { "*.sh", "*.*" };
	    }

		fileField.setFileExtensions( filterExtensions );

		addField( fileField );
	}

	@Override
	public boolean performOk() {
		if( super.performOk() ) {
			SymbexPreferenceUtil.setExternalDotGraphViewerPath(
					new Path( SymbexPreferenceUtil.getStringPreference(
							PREF_DIVERSITY_GRAPH_VIEWER_LOCATION) ) );

			return true;
		}
		else {
			return false;
		}
	}

}

