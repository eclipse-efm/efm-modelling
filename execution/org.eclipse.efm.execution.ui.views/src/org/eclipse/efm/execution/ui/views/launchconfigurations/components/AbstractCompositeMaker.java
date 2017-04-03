/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/

package org.eclipse.efm.execution.ui.views.launchconfigurations.components;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationEditorComposite;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public abstract class AbstractCompositeMaker implements ILaunchConfigurationEditorComposite, IWorkflowConfigurationConstants {

	private ILaunchConfigurationGUIelement masterGUIelement;
	
	public abstract void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration);
	
	public abstract void initializeFieldValuesFrom(ILaunchConfiguration configuration);
	
	public abstract void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration);
	
	public AbstractCompositeMaker(ILaunchConfigurationGUIelement masterGUIelement) {
		this.masterGUIelement = masterGUIelement;
	}
	
	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================	

	public final class FieldValidationReturn {
	    private final boolean fieldValidation;
	    private final String reasonString;

	    public FieldValidationReturn(boolean fieldValidation, String reasonString) {
	        this.fieldValidation = fieldValidation;
	        this.reasonString = reasonString;
	    }

	    public boolean areFieldsValid() {
	        return fieldValidation;
	    }

	    public String getReason() {
	        return reasonString;
	    }
	}
	
	public abstract FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig);
	
	public abstract Composite createControlMain(Composite parent);
	
	@Override
	public void propagateMessage(String message) {
		if (masterGUIelement != null) {
			masterGUIelement.setMessage(message);
		}
	}
	
	@Override
	public void propagateWarningMessage(String warningmessage) {
		if (masterGUIelement != null) {
			masterGUIelement.setWarningMessage(warningmessage);
		}
	}
	
	@Override
	public void propagateErrorMessage(String errormessage) {
		if (masterGUIelement != null) {
			masterGUIelement.setErrorMessage(errormessage);
		}

	}
	
	@Override
	public void propagateGUIupdate() {
		if (masterGUIelement != null) {
			masterGUIelement.updateGUI();
		}
	}

	@Override
	public void propagateVisibility(Control aControl, boolean visible) {
		aControl.setVisible(visible);

		Object gd = aControl.getLayoutData();
		if (gd instanceof GridData) {
			((GridData)gd).exclude = (! visible);
		}
	}	
	
	@Override
	public void propagateUpdateJobScheduling() {
		if (masterGUIelement != null) {
			masterGUIelement.scheduleUpdateJob();
		}
	}
	
}
