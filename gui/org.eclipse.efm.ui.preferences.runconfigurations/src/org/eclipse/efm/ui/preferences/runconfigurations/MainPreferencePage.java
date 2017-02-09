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
package org.eclipse.efm.ui.preferences.runconfigurations;

import org.eclipse.core.runtime.Path;
import org.eclipse.efm.runconfiguration.Activator;
import org.eclipse.efm.runconfiguration.ToolConstants;
import org.eclipse.efm.runconfiguration.ui.internal.SWTFactory;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class MainPreferencePage extends FieldEditorPreferencePage
			implements IWorkbenchPreferencePage , ToolConstants {

	public MainPreferencePage() {
		super(GRID);

		setPreferenceStore( Activator.getDefault().getPreferenceStore() );

		setDescription( "The SEW Abstract Virtual Machine" );
	}


	private FileFieldEditor fSEPLocationFileField;

	@Override
	protected void createFieldEditors() {
		addField( new DirectoryFieldEditor( ATTR_DIVERSITY_INSTALLATION_LOCATION,
//				"The Diversity tool installation directory:",
				"Installation:",
				getFieldEditorParent()) );

//		addField( new PathEditor( ATTR_DIVERSITY_INSTALL_PATH,
//				"The Diversity tool installation directory:",
//				"Choose a Directory",
//				getFieldEditorParent()) );

		SWTFactory.createHorizontalSpacer(getFieldEditorParent(), 3);


		fSEPLocationFileField = new FileFieldEditor(
				ATTR_DIVERSITY_AVM_EXECUTABLE_LOCATION,
//				"The Diversity AVM executable location:",
				"Executable:",
				true, FileFieldEditor.VALIDATE_ON_FOCUS_LOST,
				getFieldEditorParent());

		fSEPLocationFileField.setFileExtensions(
				new String[] { "*.exe" , "*.*" } );

		addField( fSEPLocationFileField );
	}


	@Override
	public boolean performOk() {
		if( super.performOk() ) {
			IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();

			Activator.setDiversityAvmExecLocation( new Path( prefs.getString(
					ATTR_DIVERSITY_AVM_EXECUTABLE_LOCATION) ) );

//			Activator.setDiversityAvmExecLocation(
//					new Path( fSEPLocationFileField.getStringValue() ) );

//			prefs.setValue(ATTR_DIVERSITY_AVM_EXECUTABLE_VERSION, "1.O.O");
//
//			Activator.getDefault().savePluginPreferences();

			return true;
		}
		else {
			return false;
		}
	}

	public void init(IWorkbench workbench) {
	}

}
