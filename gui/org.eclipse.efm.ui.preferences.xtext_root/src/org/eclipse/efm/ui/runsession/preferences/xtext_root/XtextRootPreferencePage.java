/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.ui.runsession.preferences.xtext_root;


import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class XtextRootPreferencePage extends FieldEditorPreferencePage
			implements IWorkbenchPreferencePage {

	public XtextRootPreferencePage() {
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
	}

	public void init(IWorkbench workbench) {
	}

}
