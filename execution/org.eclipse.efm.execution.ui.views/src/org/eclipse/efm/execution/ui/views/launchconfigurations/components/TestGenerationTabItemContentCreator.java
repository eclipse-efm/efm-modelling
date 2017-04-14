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

package org.eclipse.efm.execution.ui.views.launchconfigurations.components;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.ui.views.editors.impls.BooleanFieldEditor;
import org.eclipse.efm.execution.ui.views.editors.impls.IntegerFieldEditor;
import org.eclipse.efm.execution.ui.views.editors.impls.StringFieldEditor;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages.TestGenerationBasicTracePage;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages.TestGenerationTTCNTracePage;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.ui.views.utils.SWTFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TestGenerationTabItemContentCreator extends AbstractTabItemContentCreator {
	private Group groupExtensionObjective;

	private BooleanFieldEditor fTraceExtensionEnabledBooleanField;
	private IntegerFieldEditor fTraceExtensionEvaluationStepsLimitIntegerField;
	private StringFieldEditor  fTraceExtensionObjectiveStringField;

	// BASIC TRACE GENERATION
	private TestGenerationBasicTracePage fBasicTracePage;

	// TTCN TRACE GENERATION
	private TestGenerationTTCNTracePage fTTCNTracePage;

	public TestGenerationTabItemContentCreator(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);
		fBasicTracePage = new TestGenerationBasicTracePage(this);

		fTTCNTracePage = new TestGenerationTTCNTracePage(this);
	}

	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	public void createTabItemContent(Composite parentComposite) {
//		inner_main_composite = SWTFactory.createComposite(parent,
//				parent.getFont(), 1, 1, GridData.FILL_HORIZONTAL, 0, 0);

		createExtensionFormatPage(parentComposite);

		fBasicTracePage.createPageWithToolkit(parentComposite, getMasterFormToolkit());

		fTTCNTracePage.createPageWithToolkit(parentComposite, getMasterFormToolkit());
	}

	public void createExtensionFormatPage(Composite parent) {
		Group group = SWTFactory.createGroup(
				parent, "Trace Extension Page",
				1, 1, GridData.FILL_HORIZONTAL);

		createExtensionSelectionComponent(group);
	}

	private void createExtensionSelectionComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"Trace Extension for Test Generation Purpose",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				group, 1, 1,  GridData.FILL_HORIZONTAL);

		fTraceExtensionEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_TRACE_EXTENSION,
				"&Enabled Extension", comp, false);


		groupExtensionObjective = SWTFactory.createGroup(
				group, "Extension of Traces to reach Observables",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = SWTFactory.createComposite(
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
					ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");

			localEnable = fTraceExtensionEnabledBooleanField.getBooleanValue() &&
				(! fAnalysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE ) );

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
					ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");
		}
		catch (CoreException e) {
			e.printStackTrace();
			analysisProfile = "";
		}

		if ( analysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE ) ) {
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
		fBasicTracePage.unlockAndExpandPage();

		fTTCNTracePage.initializeFrom(configuration);
		fTTCNTracePage.unlockAndExpandPage();
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
