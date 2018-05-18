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
import org.eclipse.efm.execution.core.AbstractLaunchDelegate;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.preferences.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractConfigurationPage extends AbstractSectionPart
		implements IPropertyChangeListener,
				IWorkflowConfigurationConstants, IWorkflowPreferenceConstants {

	private ILaunchConfigurationGUIelement masterGUIelement;

	/**
	 * The control for this page, or <code>null</code>
	 */
	protected Composite fControl;

	protected boolean fEnabledSymbexDeveloperMode;

	protected boolean fEnabledSymbexIncubationMode;

	private Map<String, Action> fRegisteredActions;

	private Action[] fDefaultSectionActions;


	public boolean isEnabledSymbexDeveloperMode() {
		return fEnabledSymbexDeveloperMode;
	}

	public boolean isEnabledSymbexIncubationMode() {
		return fEnabledSymbexIncubationMode;
	}


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

		this.fRegisteredActions = new HashMap<String, Action>();

		this.fDefaultSectionActions = new Action[0];
	}


	public Map<String, Action> getRunnableActions() {
		return fRegisteredActions;
	}

	public void setRegisteredActions(Map<String, Action> acts) {
		this.fRegisteredActions = acts;
	}

	protected Action[] getActionsByStringKey(String[] kids) {
		Set<Action> foundActions = new HashSet<Action>();
		Action current;
		for(String kid: kids) {
			current = fRegisteredActions.get(kid);
			if(current != null) {
				foundActions.add(current);
			}
		}
		return foundActions.toArray(new Action[foundActions.size()]);
	}


	public Action[] getDefaultSectionActions() {
		return fDefaultSectionActions;
	}

	public void setDefaultSectionActions(Action[] defaultSectionActions) {
		this.fDefaultSectionActions = defaultSectionActions;
	}


	public ILaunchConfigurationGUIelement getMasterGUIelement() {
		return masterGUIelement;
	}

	public IWidgetToolkit getWidgetToolkit() {
		return masterGUIelement.getWidgetToolkit();
	}


	@Override
	public Composite getControl() {
		return fControl;
	}


	///////////////////////////////////////////////////////////////////////////
	// Property Change as Model Analysis Profile changed
	//
	@Override
	public void propertyChange(PropertyChangeEvent event) {
//		System.out.print( "PropertyChangeEvent : " );
//		System.out.print( event.getProperty() );
//		System.out.print( " <-- " );
//		System.out.println( event.getNewValue().toString() );

		for( AbstractConfigurationPage confPage : getConfigurationPages() ) {
			confPage.handleConfigurationPropertyChange(event);
		}
	}

	public AbstractConfigurationPage[] getConfigurationPages() {
		return masterGUIelement.getConfigurationPages();
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

	public abstract FieldValidationReturn areFieldsValidImpl(ILaunchConfiguration launchConfig);

	public final FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		if( isValid(launchConfig) ) {
			return areFieldsValidImpl(launchConfig);
		}
		else {
			return new FieldValidationReturn(false,
					"Field Editor or Trace TableViewer are invalid");
		}
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		return true;
	}


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


	public void clearErrorMessage() {
		masterGUIelement.clearErrorMessage();
	}


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

	public void setVisibleAndEnabled(Composite aComposite, boolean visible) {
		getWidgetToolkit().setVisibleAndEnabled(aComposite, visible);
	}

	public void propagateVisibility(Composite aComposite, boolean visible) {
		getWidgetToolkit().propagateVisibility(aComposite, visible);
	}

	public void propagateUpdateJobScheduling() {
		masterGUIelement.scheduleUpdateJob();
	}

}
