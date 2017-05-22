/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - Initial API and implementation
 *     Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - New Interfacing (AbstractConfigurationPage)
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.editors;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.swt.widgets.Composite;

public class ListOfStringFieldEditor extends FieldEditor {

	private List< String > fValue;
	private List< String > fDefaultValue;

	public ListOfStringFieldEditor(AbstractConfigurationPage configurationPage,
			String storeKey, String labelText, Composite parent, List< String > defaultValue) {
		super(configurationPage, storeKey, labelText, parent);
		this.fDefaultValue = defaultValue;
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(getStoreKey(), fDefaultValue);
	}

	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration) {
		try {
			fValue = configuration.getAttribute( getStoreKey(), fDefaultValue);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
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
