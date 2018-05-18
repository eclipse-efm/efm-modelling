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

import org.eclipse.efm.execution.core.AbstractLaunchDelegate;
import org.eclipse.efm.execution.core.preferences.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */


public class LaunchConfigurationPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage, IWorkflowPreferenceConstants {

	public LaunchConfigurationPreferencePage() {
		super(GRID);

		setDescription("Preferences for Launch Configuration");
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore( SymbexPreferenceUtil.getDefaultPreferenceStore() );
	}

	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	@Override
	public void createFieldEditors() {
		addField(new BooleanFieldEditor(PREF_EXPERT_MODE,
				"&Expert Mode",getFieldEditorParent()));

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_INCUBATION_MODE_OPTION ) {
			addField(new BooleanFieldEditor(PREF_INCUBATION_MODE,
					"&Incubation Mode",getFieldEditorParent()));
		}

		addField(new BooleanFieldEditor(PREF_DEBUG_OPTIONS,
				"&Debug Option",getFieldEditorParent()));

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION ) {
			addField(new BooleanFieldEditor(PREF_SYMBEX_DEVELOPER_MODE,
					"&Symbex Developer Mode",getFieldEditorParent()));
		}
	}

}