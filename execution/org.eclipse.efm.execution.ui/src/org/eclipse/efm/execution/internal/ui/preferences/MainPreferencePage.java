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

import org.eclipse.core.runtime.Path;
import org.eclipse.efm.execution.core.preferences.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class MainPreferencePage extends FieldEditorPreferencePage
			implements IWorkbenchPreferencePage , IWorkflowPreferenceConstants {

	public MainPreferencePage() {
		super(GRID);

		setDescription( "The SEW Abstract Virtual Machine" );
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore( SymbexPreferenceUtil.getDefaultPreferenceStore() );
	}


	private FileFieldEditor fSEPLocationFileField;

	@Override
	protected void createFieldEditors() {
		addField( new DirectoryFieldEditor( PREF_DIVERSITY_INSTALLATION_LOCATION,
//				"The Diversity tool installation directory:",
				"Installation:",
				getFieldEditorParent()) );

//		addField( new PathEditor( ATTR_DIVERSITY_INSTALL_PATH,
//				"The Diversity tool installation directory:",
//				"Choose a Directory",
//				getFieldEditorParent()) );

		createHorizontalSpacer(getFieldEditorParent(), 3);

		fSEPLocationFileField = new FileFieldEditor(
				PREF_DIVERSITY_AVM_EXECUTABLE_LOCATION,
//				"The Diversity AVM executable location:",
				"Executable:",
				false, FileFieldEditor.VALIDATE_ON_FOCUS_LOST,
				getFieldEditorParent());

		fSEPLocationFileField.setFileExtensions(
				new String[] { "*.exe" , "*.*" } );

		addField( fSEPLocationFileField );
	}


	/**
	 * inspired by SWTFactory.createHorizontalSpacer
	 * creates a horizontal spacer for separating components
	 * @param comp
	 * @param numlines
	 * @since 3.3
	 */
	public static void createHorizontalSpacer(Composite comp, int numlines) {
		Label lbl = new Label(comp, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numlines;
		lbl.setLayoutData(gd);
	}

	@Override
	public boolean performOk() {
		if( super.performOk() ) {
			SymbexPreferenceUtil.setDiversityAvmExecLocation(
					new Path( SymbexPreferenceUtil.getStringPreference(
							PREF_DIVERSITY_AVM_EXECUTABLE_LOCATION) ) );

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

}
