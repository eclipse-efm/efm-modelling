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
package org.eclipse.efm.ui.views.editors.impls;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.ui.views.utils.LaunchConfigurationEditorCommunicationInterface;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.efm.ui.views.editors.FieldEditor;

public class ListOfStringFieldEditor extends FieldEditor {

	private List< String > fValue;
	private List< String > fDefaultValue;

	public ListOfStringFieldEditor(LaunchConfigurationEditorCommunicationInterface fLaunchConfCommInt,
			String storeKey, String labelText, Composite parent, List< String > defaultValue) {
		super(fLaunchConfCommInt, storeKey, labelText, parent);
		this.fDefaultValue = defaultValue;
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(getStoreKey(), fDefaultValue);

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			fValue = configuration.getAttribute( getStoreKey(), fDefaultValue);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(getStoreKey(), fValue);

	}


	@Override
	protected void adjustForNumColumns(int numColumns) {
		// TODO Auto-generated method stub

	}


	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		// TODO Auto-generated method stub

	}


	@Override
	public int getNumberOfControls() {
		// TODO Auto-generated method stub
		return 0;
	}

}
