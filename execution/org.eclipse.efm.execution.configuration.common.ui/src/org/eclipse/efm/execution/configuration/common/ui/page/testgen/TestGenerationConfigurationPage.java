/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial Implementation (tab-based, inserted in Run Configurations dialog)
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - New API (free-composite-based, no type assumptions on parent)
 *******************************************************************************/

package org.eclipse.efm.execution.configuration.common.ui.page.testgen;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TestGenerationConfigurationPage extends AbstractConfigurationPage {
	
	private Group groupTraceExtension;
	private Group groupExtensionObjective;

	private BooleanFieldEditor fTraceExtensionEnabledBooleanField;
	private IntegerFieldEditor fTraceExtensionEvaluationStepsLimitIntegerField;
	private StringFieldEditor  fTraceExtensionObjectiveStringField;

	// BASIC TRACE GENERATION
	private TestGenerationBasicTraceConfigurationProfile fBasicTracePage;

	// TTCN TRACE GENERATION
	private TestGenerationTTCNConfigurationProfile fTTCNTracePage;

	public TestGenerationConfigurationPage(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);
		fBasicTracePage = new TestGenerationBasicTraceConfigurationProfile(this);

		fTTCNTracePage = new TestGenerationTTCNConfigurationProfile(this);
	}

	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		createExtensionFormatPage(parent, widgetToolkit);

		fBasicTracePage.createControl(parent, widgetToolkit);

		fTTCNTracePage.createControl(parent, widgetToolkit);
	}

	public void createExtensionFormatPage(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(
				parent, "Trace Extension Page",
				1, 1, GridData.FILL_HORIZONTAL);

		createExtensionSelectionComponent(group, widgetToolkit);
	}

	private void createExtensionSelectionComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		groupTraceExtension = widgetToolkit.createGroup(parent,
				"Trace Extension for Test Generation Purpose",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				groupTraceExtension, 1, 1,  GridData.FILL_HORIZONTAL);

		fTraceExtensionEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_TRACE_EXTENSION,
				"&Enabled Extension", comp, false);
		
		fTraceExtensionEnabledBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						handleEnablingTraceExtension();
						
						propertyChange( new PropertyChangeEvent(this, ATTR_ENABLED_TRACE_EXTENSION,
								new Boolean(fTraceExtensionEnabledBooleanField.getBooleanValue()),
								new Boolean(fTraceExtensionEnabledBooleanField.getBooleanValue()) ));

					}
				});


		groupExtensionObjective = widgetToolkit.createGroup(
				groupTraceExtension, "Extension of Traces to reach Observables",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				groupExtensionObjective,
				1, 1, GridData.FILL_HORIZONTAL);

		fTraceExtensionEvaluationStepsLimitIntegerField =
				new IntegerFieldEditor(this,
						ATTR_TRACE_EXTENSION_EVALUATION_STEPS,
						"&Evaluation Steps :", comp, -1);

		fTraceExtensionEvaluationStepsLimitIntegerField.setToolTipText(
				"Maximal evaluation steps (-1 <=> no-limit) " +
				"during the extension of symbolic execution");

		Group group = widgetToolkit.createGroup(
				groupTraceExtension, "Trace Ending with ",
				1, 1, GridData.FILL_HORIZONTAL);

		fTraceExtensionObjectiveStringField = new StringFieldEditor(
				this, ATTR_TRACE_EXTENSION_OBJECTIVE,
				"", group, DEFAULT_TRACE_EXTENSION_OBJECTIVE,
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
	}

	private void handleEnablingTraceExtension() {
		propagateVisibility(groupExtensionObjective,
				fTraceExtensionEnabledBooleanField.getBooleanValue() );
	}


	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {

//		fTraceExtensionEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_TRACE_EXTENSION, false);

//		fTraceExtensionEvaluationStepsLimitIntegerField.setDefaults(
//				configuration);
		configuration.setAttribute(
				ATTR_TRACE_EXTENSION_EVALUATION_STEPS, -1);

//		fTraceExtensionObjectiveStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRACE_EXTENSION_OBJECTIVE,
				DEFAULT_TRACE_EXTENSION_OBJECTIVE);


		fBasicTracePage.setDefaults(configuration);

		fTTCNTracePage.setDefaults(configuration);
	}

	@Override
	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		fTraceExtensionEnabledBooleanField.initializeFrom(configuration);
		fTraceExtensionEvaluationStepsLimitIntegerField.initializeFrom(configuration);
		fTraceExtensionObjectiveStringField.initializeFrom(configuration);

//		String analysisProfile;
//		try {
//			analysisProfile = configuration.getAttribute(
//					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, "");
//		}
//		catch (CoreException e) {
//			analysisProfile = "";
//
//			e.printStackTrace();
//		}
//
//		if ( analysisProfile.equals(ANALYSIS_PROFILE_MODEL_TEST_OFFLINE ) ) {
//			fTraceExtensionEnabledBooleanField.setEnabled(false);
//		}

		handleEnablingTraceExtension();


		fBasicTracePage.initializeFrom(configuration);

		fTTCNTracePage.initializeFrom(configuration);
	}


	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration)
	{
		fTraceExtensionEnabledBooleanField.performApply(configuration);

		fTraceExtensionEvaluationStepsLimitIntegerField.performApply(configuration);
		fTraceExtensionObjectiveStringField.performApply(configuration);

		fBasicTracePage.performApply(configuration);

		fTTCNTracePage.performApply(configuration);
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		if( ! fTraceExtensionEvaluationStepsLimitIntegerField.isValid() ) {
			return new FieldValidationReturn(false, "Evaluation Steps is not a valid integer");
		}
		
		if( ! fBasicTracePage.isValid(launchConfig) ) {
			return new FieldValidationReturn(false, null);
		}
		
		if( ! fTTCNTracePage.isValid(launchConfig) ) {
			return new FieldValidationReturn(false, null);
		}
		
		return new FieldValidationReturn(true, null);
	}

	
	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	protected void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE:
			switch ( event.getNewValue().toString() ) {
			case ANALYSIS_PROFILE_MODEL_TEST_OFFLINE:
				groupTraceExtension.setEnabled(false);
				
				propagateVisibility(groupExtensionObjective, false);
				
				setVisibleAndEnabled(fBasicTracePage.getSection(), false);
				setVisibleAndEnabled(fTTCNTracePage.getSection() , false);
				
				break;
				
			case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION:
			case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR:
			case ANALYSIS_PROFILE_MODEL_EXPLORATION:
			default:
				groupTraceExtension.setEnabled(true);
				
				propagateVisibility(groupExtensionObjective, true);
				
				setVisibleAndEnabled(fBasicTracePage.getSection(), true);
				setVisibleAndEnabled(fTTCNTracePage.getSection() , true);

				
				handleEnablingTraceExtension();;
				break;
			}
			
			break;

		default:
			break;
		}
	}
	
}
