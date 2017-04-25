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

package org.eclipse.efm.execution.configuration.common.ui.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.core.AbstractLaunchDelegate;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public abstract class AbstractConfigurationPage
		implements IWorkflowConfigurationConstants, IWorkflowPreferenceConstants {

	private ILaunchConfigurationGUIelement masterGUIelement;

	/**
	 * The control for this page, or <code>null</code>
	 */
	protected Composite fControl;

	protected boolean fEnabledSymbexDeveloperMode;

	protected boolean fEnabledSymbexIncubationMode;


	public boolean isEnabledSymbexDeveloperMode() {
		return fEnabledSymbexDeveloperMode;
	}

	public boolean isEnabledSymbexIncubationMode() {
		return fEnabledSymbexIncubationMode;
	}


	public abstract void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration);

	public abstract void initializeFieldValuesFrom(ILaunchConfiguration configuration);

	public abstract void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration);


	public AbstractConfigurationPage(ILaunchConfigurationGUIelement masterGUIelement) {
        Assert.isNotNull(masterGUIelement);
		this.masterGUIelement = masterGUIelement;

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION ) {
			fEnabledSymbexDeveloperMode =
					SymbexPreferenceUtil.getBooleanPreference(PREF_SYMBEX_DEVELOPER_MODE);
		} else {
			fEnabledSymbexDeveloperMode = false;
		}

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_INCUBATION_MODE_OPTION ) {
			fEnabledSymbexIncubationMode =
					SymbexPreferenceUtil.getBooleanPreference(
							IWorkflowPreferenceConstants.PREF_INCUBATION_MODE);
		} else {
			fEnabledSymbexIncubationMode = false;
		}

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


	public ILaunchConfigurationGUIelement getMasterGUIelement() {
		return masterGUIelement;
	}

	public IWidgetToolkit getWidgetToolkit() {
		return masterGUIelement.getWidgetToolkit();
	}


	public Composite getControl() {
		return fControl;
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


	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	public void createControl(Composite parent, IWidgetToolkit widgetToolkit)
	{
		fControl = widgetToolkit.createComposite(
				parent, 1, 1, GridData.FILL_BOTH);

		createContent(fControl, widgetToolkit);
	}

	protected abstract void createContent(
			Composite parent, IWidgetToolkit widgetToolkit);



	public void propagateMessage(String message) {
		masterGUIelement.setMessage(message);
	}

	public void propagateWarningMessage(String warningmessage) {
		masterGUIelement.setWarningMessage(warningmessage);
	}

	public void propagateErrorMessage(String errormessage) {
		masterGUIelement.setErrorMessage(errormessage);
	}

	/**
	 * API Interface
	 */

	public void propagateGUIupdate() {
		masterGUIelement.updateGUI();
	}

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

	public void propagateUpdateJobScheduling() {
		masterGUIelement.scheduleUpdateJob();
	}

	private Map<String, Action> registered_actions;

	public Map<String, Action> getRunnableActions() {
		return registered_actions;
	}

}
