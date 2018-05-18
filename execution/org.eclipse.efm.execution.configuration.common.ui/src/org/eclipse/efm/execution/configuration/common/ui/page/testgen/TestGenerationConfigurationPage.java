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
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableConfigProvider;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableViewer;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.jface.util.PropertyChangeEvent;
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

	private TraceElementTableViewer fExtensionObjectiveTraceElementTableViewer;


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

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		createExtensionFormatPage(parent, widgetToolkit);

		fBasicTracePage.createControl(parent, widgetToolkit);

		fTTCNTracePage.createControl(parent, widgetToolkit);
	}

	@Override
	public String getSectionTitle() {
		return "Test Generation";
	}

	@Override
	public String getSectionDescription() {
		return "Test Generation";
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
		addFieldEditor(fTraceExtensionEnabledBooleanField);


		groupExtensionObjective = widgetToolkit.createGroup(
				groupTraceExtension, "Extension of Traces to reach Observables",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				groupExtensionObjective,
				1, 1, GridData.FILL_HORIZONTAL);

		fTraceExtensionEvaluationStepsLimitIntegerField =
				new IntegerFieldEditor(this,
						ATTR_TRACE_EXTENSION_EVALUATION_STEPS,
						"&Evaluation Steps : ", comp, -1);
		fTraceExtensionEvaluationStepsLimitIntegerField.setToolTipText(
				"Maximal evaluation steps (-1 <=> no-limit) " +
				"during the extension of symbolic execution");
		addFieldEditor(fTraceExtensionEvaluationStepsLimitIntegerField);

		fExtensionObjectiveTraceElementTableViewer =
			new TraceElementTableViewer(null, groupTraceExtension, 1, widgetToolkit,
				TraceElementTableConfigProvider.getTraceExtensionObjective(
						parent.getFont()));
		addTableViewer(fExtensionObjectiveTraceElementTableViewer);
	}

	private void handleEnablingTraceExtension() {
		final boolean visible = fTraceExtensionEnabledBooleanField.getBooleanValue();

		propagateVisibility(groupExtensionObjective, visible);

		propagateVisibility(
				fExtensionObjectiveTraceElementTableViewer.getControl(), visible);
	}


	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_ENABLED_TRACE_EXTENSION, false);

		configuration.setAttribute(
				ATTR_TRACE_EXTENSION_EVALUATION_STEPS, -1);

		configuration.setAttribute(
				ATTR_TRACE_EXTENSION_OBJECTIVE,
				DEFAULT_TRACE_EXTENSION_OBJECTIVE);

		fBasicTracePage.setDefaults(configuration);

		fTTCNTracePage.setDefaults(configuration);
	}

	@Override
	public void initializeFromImpl(ILaunchConfiguration configuration) {
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
	public void performApplyImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		fBasicTracePage.performApply(configuration);

		fTTCNTracePage.performApply(configuration);
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValidImpl(ILaunchConfiguration launchConfig) {
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
	public void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE:
			switch ( (AnalysisProfileKind) event.getNewValue() ) {
			case ANALYSIS_TEST_OFFLINE_PROFILE:
				groupTraceExtension.setEnabled(false);

				propagateVisibility(groupExtensionObjective, false);

				setVisibleAndEnabled(fBasicTracePage.getSection(), false);
				setVisibleAndEnabled(fTTCNTracePage.getSection() , false);

				break;

			case ANALYSIS_TRANSITION_COVERAGE_PROFILE:
			case ANALYSIS_BEHAVIOR_SELECTION_PROFILE:
			case ANALYSIS_ACSL_GENERATION_PROFILE:
			case ANALYSIS_EXTRANEOUS_PROFILE:
			case ANALYSIS_EXPLORATION_PROFILE:
			default:
				groupTraceExtension.setEnabled(true);

				propagateVisibility(groupExtensionObjective, true);

				setVisibleAndEnabled(fBasicTracePage.getSection(), true);
				setVisibleAndEnabled(fTTCNTracePage.getSection() , true);


				handleEnablingTraceExtension();
				break;
			}

			break;

		default:
			break;
		}
	}

}
