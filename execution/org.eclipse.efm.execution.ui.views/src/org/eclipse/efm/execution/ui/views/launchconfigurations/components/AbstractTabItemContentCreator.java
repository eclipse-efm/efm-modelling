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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationEditorComposite;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

public abstract class AbstractTabItemContentCreator
		implements ILaunchConfigurationEditorComposite, IWorkflowConfigurationConstants {

	private ILaunchConfigurationGUIelement masterGUIelement;

	public abstract void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration);

	public abstract void initializeFieldValuesFrom(ILaunchConfiguration configuration);

	public abstract void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration);

	public AbstractTabItemContentCreator(ILaunchConfigurationGUIelement masterGUIelement) {
		this.masterGUIelement = masterGUIelement;
		this.registered_actions = new HashMap<String, Action>();
	}

	public void setRegisteredActions(Map<String, Action> acts) {
		this.registered_actions = acts;
	}

	protected Action[] getActionsByStringKey(String[] kids) {
		Set<Action> foundActions = new HashSet<Action>();
		Action current;
		for(String kid: kids) {
			current = registered_actions.get(kid);
			if(current != null) {
				foundActions.add(current);
			}
		}
		return foundActions.toArray(new Action[foundActions.size()]);
	}


	protected FormToolkit getMasterFormToolkit() {
		return masterGUIelement.getFormToolkit();
	}

	protected ILaunchConfigurationGUIelement getMasterGUIelement() {
		return masterGUIelement;
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

	public abstract void createTabItemContent(Composite parentComposite);

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
			GridData data = (GridData) gd;
			data.exclude = (! visible);
			aControl.getShell().layout(false);
		} else {
			//
		}
	}

	@Override
	public void propagateUpdateJobScheduling() {
		if (masterGUIelement != null) {
			masterGUIelement.scheduleUpdateJob();
		}
	}

	private Map<String, Action> registered_actions;

	@Override
	public Map<String, Action> getRunnableActions() {
		return registered_actions;
	}

}
