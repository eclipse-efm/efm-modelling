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
package org.eclipse.efm.runconfiguration.ui.preferences;

import org.eclipse.efm.runconfiguration.Activator;
import org.eclipse.efm.runconfiguration.LaunchDelegate;
import org.eclipse.efm.runconfiguration.ToolConstants;
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


public class LaunchConfigurationPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public LaunchConfigurationPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preferences for Launch Configuration");
		initializeDefaults();
	}
/**
 * Sets the default values of the preferences.
 */
	private void initializeDefaults() {
	}

/**
 * Creates the field editors. Field editors are abstractions of
 * the common GUI blocks needed to manipulate various types
 * of preferences. Each field editor knows how to save and
 * restore itself.
 */

	public void createFieldEditors() {
		addField(new BooleanFieldEditor(
				ToolConstants.PREF_EXPERT_MODE,
				"&Expert Mode",getFieldEditorParent()));

		if( LaunchDelegate.ENABLED_SYMBEX_INCUBATION_MODE_OPTION ) {
			addField(new BooleanFieldEditor(
					ToolConstants.PREF_INCUBATION_MODE,
					"&Incubation Mode",getFieldEditorParent()));
		}

		addField(new BooleanFieldEditor(
				ToolConstants.PREF_DEBUG_OPTIONS,
				"&Debug Option",getFieldEditorParent()));

		if( LaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION ) {
			addField(new BooleanFieldEditor(
					ToolConstants.PREF_SYMBEX_DEVELOPER_MODE,
					"&Symbex Developer Mode",getFieldEditorParent()));
		}

		addField(new BooleanFieldEditor(
				ToolConstants.PREF_CONSOLE_VIEW,
				"&Display Console",getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				ToolConstants.PREF_SPIDER_VIEW,
				"&Display Spider",getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
	}
}