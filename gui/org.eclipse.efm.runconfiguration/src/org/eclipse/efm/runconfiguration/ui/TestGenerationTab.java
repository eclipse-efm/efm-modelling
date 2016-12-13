/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.runconfiguration.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.runconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.efm.runconfiguration.ui.internal.SWTFactory;
import org.eclipse.efm.runconfiguration.ui.internal.fieldeditor.BooleanFieldEditor;
import org.eclipse.efm.runconfiguration.ui.internal.fieldeditor.IntegerFieldEditor;
import org.eclipse.efm.runconfiguration.ui.internal.fieldeditor.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

public class TestGenerationTab extends AbstractSewLaunchConfigurationTab {

	private Group groupExtensionObjective;

	private BooleanFieldEditor fTraceExtensionEnabledBooleanField;
	private IntegerFieldEditor fTraceExtensionEvaluationStepsLimitIntegerField;
	private StringFieldEditor  fTraceExtensionObjectiveStringField;

	// BASIC TRACE GENERATION
	private TestGenerationBasicTracePage fBasicTracePage;

	// TTCN TRACE GENERATION
	private TestGenerationTTCNTracePage fTTCNTracePage;

	/**
	 * Constructor
	 * @param groupTab
	 */
	public TestGenerationTab(LaunchConfigurationTabGroup groupTab) {
		super(groupTab);
		setHelpContextId("org.eclipse.efm.runconfiguration.efm_runconf_testgeneration_tab");

		fBasicTracePage = new TestGenerationBasicTracePage(this);

		fTTCNTracePage = new TestGenerationTTCNTracePage(this);
	}

	Composite simpleComposite;

	@Override
	public void createControl(Composite parent) {
		simpleComposite = SWTFactory.createComposite(parent,
				parent.getFont(), 1, 1, GridData.FILL_HORIZONTAL, 0, 0);
		setControl(simpleComposite);

		PlatformUI.getWorkbench().getHelpSystem()
			.setHelp(getControl(), getHelpContextId());

		createExtensionFormatPage(simpleComposite);

		fBasicTracePage.createControl(simpleComposite);

		fTTCNTracePage.createControl(simpleComposite);
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
					MainTab.ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");

			localEnable = fTraceExtensionEnabledBooleanField.getBooleanValue() &&
				(! fAnalysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE ) );

			fTraceExtensionEvaluationStepsLimitIntegerField.setEnabled(localEnable);

			visibleAndExclude(groupExtensionObjective, localEnable);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#isValid(ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if( ! fTraceExtensionEvaluationStepsLimitIntegerField.isValid() ) {
			setErrorMessage("Evaluation Steps is not a valid integer");
			return false;
		}

		if( ! fBasicTracePage.isValid(launchConfig) )
		{
			return false;
		}

		if( ! fTTCNTracePage.isValid(launchConfig) )
		{
			return false;
		}


		return true;
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

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
	public void initializeFrom(ILaunchConfiguration configuration) {
		String analysisProfile;
		try {
			analysisProfile = configuration.getAttribute(
					MainTab.ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");
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

		fTTCNTracePage.initializeFrom(configuration);
	}


	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration)
	{
		fTraceExtensionEnabledBooleanField.performApply(configuration);

		setEnableExtensionPage(configuration);

		fTraceExtensionEvaluationStepsLimitIntegerField.performApply(configuration);
		fTraceExtensionObjectiveStringField.performApply(configuration);

		fBasicTracePage.performApply(configuration);

		fTTCNTracePage.performApply(configuration);
	}

	@Override
	public String getName() {
		return "Test Generation";
	}
}
