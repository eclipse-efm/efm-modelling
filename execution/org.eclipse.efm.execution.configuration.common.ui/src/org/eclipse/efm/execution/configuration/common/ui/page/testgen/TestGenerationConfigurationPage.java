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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TestGenerationConfigurationPage extends AbstractConfigurationPage {
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
		Group group = widgetToolkit.createGroup(parent,
				"Trace Extension for Test Generation Purpose",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1,  GridData.FILL_HORIZONTAL);

		fTraceExtensionEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_TRACE_EXTENSION,
				"&Enabled Extension", comp, false);


		groupExtensionObjective = widgetToolkit.createGroup(
				group, "Extension of Traces to reach Observables",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				groupExtensionObjective,
				1, 1, GridData.FILL_HORIZONTAL);

		fTraceExtensionEvaluationStepsLimitIntegerField =
				new IntegerFieldEditor(this,
						ATTR_TRACE_EXTENSION_EVALUATION_STEPS,
						"&Evaluation Steps:", comp, -1);

		fTraceExtensionEvaluationStepsLimitIntegerField.setToolTipText(
				"Maximal evaluation steps (-1 <=> no-limit) " +
				"during the extension of symbolic execution");

//		comp = SWTFactory.createComposite(
//				groupExtensionObjective,
//				1, 1,  GridData.FILL_HORIZONTAL);

		fTraceExtensionObjectiveStringField = new StringFieldEditor(
				this, ATTR_TRACE_EXTENSION_OBJECTIVE,
				"Trace Ending with:", comp,
				DEFAULT_TRACE_EXTENSION_OBJECTIVE, SWT.MULTI);
	}


	private void setEnableExtensionPage(ILaunchConfiguration configuration) {
		String fAnalysisProfile;
		boolean localEnable;

		try {
			fAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, "");

			localEnable = fTraceExtensionEnabledBooleanField.getBooleanValue() &&
				(! fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL_TEST_OFFLINE ) );

			fTraceExtensionEvaluationStepsLimitIntegerField.setEnabled(localEnable);

			propagateVisibility(groupExtensionObjective, localEnable);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
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
		String analysisProfile;
		try {
			analysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, "");
		}
		catch (CoreException e) {
			e.printStackTrace();
			analysisProfile = "";
		}

		if ( analysisProfile.equals(ANALYSIS_PROFILE_MODEL_TEST_OFFLINE ) ) {
			fTraceExtensionEnabledBooleanField.setEnabled(false);
		}
		else {
			fTraceExtensionEnabledBooleanField.setEnabled(true);

			fTraceExtensionEnabledBooleanField.initializeFrom(configuration);
			fTraceExtensionEvaluationStepsLimitIntegerField.initializeFrom(configuration);
			fTraceExtensionObjectiveStringField.initializeFrom(configuration);
		}

		setEnableExtensionPage(configuration);


		fBasicTracePage.initializeFrom(configuration);
		fBasicTracePage.setVisibleAndEnabled(true);

		fTTCNTracePage.initializeFrom(configuration);
		fTTCNTracePage.setVisibleAndEnabled(true);
	}


	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration)
	{
		fTraceExtensionEnabledBooleanField.performApply(configuration);

		setEnableExtensionPage(configuration);

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


}
