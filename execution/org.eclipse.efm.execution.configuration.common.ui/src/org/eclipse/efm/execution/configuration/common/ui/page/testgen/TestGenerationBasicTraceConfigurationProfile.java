/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.page.testgen;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.util.GenericCompositeCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TestGenerationBasicTraceConfigurationProfile extends AbstractConfigurationProfile {

	private Group groupBasicConfiguration;
	private Group groupBasicObservable;

	private BooleanFieldEditor fBasicTraceEnabledGenerationBooleanField;

	private StringFieldEditor fBasicTraceFolderNameStringField;
	private StringFieldEditor fBasicTraceFileNameStringField;

	private BooleanFieldEditor fBasicTraceNormalizationBooleanField;
	private BooleanFieldEditor fBasicTraceShowInitializationBooleanField;

	private BooleanFieldEditor fBasicTraceAllExternalInputComBooleanField;
	private BooleanFieldEditor fBasicTraceAllExternalOutputComBooleanField;

	private BooleanFieldEditor fBasicTraceAllInternalInputComBooleanField;
	private BooleanFieldEditor fBasicTraceAllInternalOutputComBooleanField;

	private BooleanFieldEditor fBasicTraceTimeBooleanField;
	private BooleanFieldEditor fBasicTraceAllVariableBooleanField;
	private BooleanFieldEditor fBasicTraceAllTransitionBooleanField;
	private BooleanFieldEditor fBasicTraceAllStateBooleanField;

	private StringFieldEditor fBasicTraceObservableTraceDetailsStringField;
	private StringFieldEditor fBasicTraceObservableFormatStringField;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public TestGenerationBasicTraceConfigurationProfile(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Basic Tests Generation";
	}

	@Override
	public String getSectionDescription() {
		return "Basic <Ad'hoc> Tests Generation, configuration section";
	}


	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit) {
		Composite comp = widgetToolkit.createComposite(
				parent, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceEnabledGenerationBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ENABLED_GENERATION,
						"&Enabled Generation", comp, false);

		createBasicConfigurationComponent(parent, widgetToolkit);

		createObservableSelectionComponent(parent, widgetToolkit);
	}

	private void createBasicConfigurationComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		groupBasicConfiguration = widgetToolkit.createGroup(parent,
				"&Configuration", 2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				groupBasicConfiguration, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceFolderNameStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_FOLDER_NAME, "&Folder:",
				comp, DEFAULT_BASIC_TRACE_FOLDER_NAME);
		fBasicTraceFolderNameStringField.setToolTipText(
				"Folder name w.r.t. <workspace-root>/<output>");

		comp = widgetToolkit.createComposite(
				groupBasicConfiguration, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceFileNameStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_FILE_NAME, "&File:",
				comp, DEFAULT_BASIC_TRACE_FILE_NAME);
		fBasicTraceFileNameStringField.setToolTipText("File name");

		comp = widgetToolkit.createComposite(groupBasicConfiguration,
				1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceNormalizationBooleanField = new BooleanFieldEditor(
				fConfigurationPage, ATTR_BASIC_TRACE_ENABLED_NORMALIZATION,
				"&Normalization (Redundance Elimination...)", comp, true);

		comp = widgetToolkit.createComposite(groupBasicConfiguration,
				1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceShowInitializationBooleanField = new BooleanFieldEditor(
				fConfigurationPage, ATTR_BASIC_TRACE_SHOW_INITIALIZATION,
				"&Show Parameters Initialization", comp, false);
	}

	public void createObservableSelectionComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		groupBasicObservable = widgetToolkit.createGroup(parent,
				"&Observable Traces Selection", 3, 1, GridData.FILL_HORIZONTAL);

		createExternalCommunicationComponent(groupBasicObservable, widgetToolkit);

		createInternalCommunicationComponent(groupBasicObservable, widgetToolkit);

		createOtherObservableComponent(groupBasicObservable, widgetToolkit);

		createObservableDetailsComponent(groupBasicObservable, widgetToolkit);

		createObservableFormatComponent(groupBasicObservable, widgetToolkit);
	}

	private void createExternalCommunicationComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"External Communication", 2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				"External, Input or Output, Communication Selection" );


		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllExternalInputComBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION,
						"&Input", comp, true);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllExternalOutputComBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION,
						"&Output", comp, true);
	}

	private void createInternalCommunicationComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"&Any Communication", 2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText( "External or Internal, "
				+ "Input or Output, Communication Selection" );


		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllInternalInputComBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_INPUT_COM_SELECTION,
						"&Input", comp, false);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllInternalOutputComBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_OUTPUT_COM_SELECTION,
						"&Output", comp, false);
	}

	private void createOtherObservableComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"&Other Elements", 4, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText( "Other Elements like, Time, Variable, "
				+ "Transition, State..., Communication Selection" );

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceTimeBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_TIME_SELECTION,
						"&Time", comp, true);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllVariableBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION,
						"&Variable", comp, false);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllTransitionBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION,
						"&Transition", comp, false);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllStateBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_STATE_SELECTION,
						"&State", comp, false);
	}

	private void createObservableDetailsComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"&Details", 1, 3, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceObservableTraceDetailsStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST, "",
				comp, DEFAULT_BASIC_TRACE_DETAILS_ELEMENT_LIST, SWT.MULTI);
	}


	private void createObservableFormatComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"&Ad'Hoc Element Format for Tests",
				1, 3, GridData.FILL_HORIZONTAL);
		group.setToolTipText( HELPER_TRACE_FORMAT_SPECIFICATION );

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText( HELPER_TRACE_FORMAT_SPECIFICATION );

		fBasicTraceObservableFormatStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_BASIC_TRACE_FORMAT_ELEMENT_LIST, "", comp,
				DEFAULT_BASIC_TRACE_FORMAT_ELEMENT_LIST, SWT.MULTI);
		fBasicTraceObservableFormatStringField.setToolTipText(
				HELPER_TRACE_FORMAT_SPECIFICATION );
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration)
	{
//		fBasicTraceEnabledGenerationBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ENABLED_GENERATION, false);

//		fBasicTraceFolderNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_FOLDER_NAME, DEFAULT_BASIC_TRACE_FOLDER_NAME);

//		fBasicTraceFileNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_FILE_NAME, DEFAULT_BASIC_TRACE_FILE_NAME);

//		fBasicTraceNormalizationBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ENABLED_NORMALIZATION, true);

//		fBasicTraceShowInitializationBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_SHOW_INITIALIZATION, false);

//		fBasicTraceAllExternalInputComBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION, true);

//		fBasicTraceAllExternalOutputComBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION, true);

//		fBasicTraceAllInternalInputComBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_INTERNAL_INPUT_COM_SELECTION, true);

//		fBasicTraceAllInternalOutputComBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_INTERNAL_OUTPUT_COM_SELECTION, true);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_OUTPUT_COM_SELECTION, false);

//		fBasicTraceTimeBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_TIME_SELECTION, true);

//		fBasicTraceAllVariableBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION, false);

//		fBasicTraceAllTransitionBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION, false);

//		fBasicTraceAllStateBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_STATE_SELECTION, false);

//		fBasicTraceObservableTraceDetailsStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST,
				DEFAULT_BASIC_TRACE_DETAILS_ELEMENT_LIST);

//		fBasicTraceObservableFormatStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BASIC_TRACE_FORMAT_ELEMENT_LIST,
				DEFAULT_BASIC_TRACE_FORMAT_ELEMENT_LIST);
	}

	private String getAnalysisProfile(ILaunchConfiguration configuration) {
		String modelAnalysisProfile;
		try {
			modelAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, "");
		}
		catch (CoreException e) {
			e.printStackTrace();
			modelAnalysisProfile = "";
		}
		return modelAnalysisProfile;
	}

	private boolean getBasicTraceEnableGeneration(ILaunchConfiguration configuration) {
		boolean basicTraceEnableGeneration;
		try {
			basicTraceEnableGeneration = configuration.getAttribute(ATTR_BASIC_TRACE_ENABLED_GENERATION, false);
		} catch (CoreException e) {
			e.printStackTrace();
			basicTraceEnableGeneration = false;
		}
		return basicTraceEnableGeneration;
	}

	private void updateGreyedOutAreas(String modelAnalysisProfile, boolean basicTraceEnableGeneration) {
		if ( modelAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL_TEST_OFFLINE ) ) {
			fBasicTraceEnabledGenerationBooleanField.setEnabled(false);
			GenericCompositeCreator.recursiveSetEnabled(groupBasicConfiguration, false);
			GenericCompositeCreator.recursiveSetEnabled(groupBasicObservable, false);
		}
		else {
			fBasicTraceEnabledGenerationBooleanField.setEnabled(true);
			if (basicTraceEnableGeneration) {
				GenericCompositeCreator.recursiveSetEnabled(groupBasicConfiguration, true);
				GenericCompositeCreator.recursiveSetEnabled(groupBasicObservable, true);
			} else {
				GenericCompositeCreator.recursiveSetEnabled(groupBasicConfiguration, false);
				GenericCompositeCreator.recursiveSetEnabled(groupBasicObservable, false);
			}
			fBasicTraceNormalizationBooleanField.setEnabled(true);
			fBasicTraceShowInitializationBooleanField.setEnabled(true);
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		String analysisProfile = getAnalysisProfile(configuration);
		boolean basicTraceEnableGeneration = getBasicTraceEnableGeneration(configuration);
		updateGreyedOutAreas(analysisProfile, basicTraceEnableGeneration);

		if ( ! analysisProfile.equals(ANALYSIS_PROFILE_MODEL_TEST_OFFLINE ) ) {
			fBasicTraceEnabledGenerationBooleanField.initializeFrom(configuration);
			fBasicTraceFolderNameStringField.initializeFrom(configuration);
			fBasicTraceFileNameStringField.initializeFrom(configuration);
			fBasicTraceNormalizationBooleanField.initializeFrom(configuration);
			fBasicTraceShowInitializationBooleanField.initializeFrom(configuration);

			fBasicTraceAllExternalInputComBooleanField.initializeFrom(configuration);
			fBasicTraceAllExternalOutputComBooleanField.initializeFrom(configuration);
			fBasicTraceAllInternalInputComBooleanField.initializeFrom(configuration);
			fBasicTraceAllInternalOutputComBooleanField.initializeFrom(configuration);

			fBasicTraceTimeBooleanField.initializeFrom(configuration);
			fBasicTraceAllVariableBooleanField.initializeFrom(configuration);
			fBasicTraceAllTransitionBooleanField.initializeFrom(configuration);
			fBasicTraceAllStateBooleanField.initializeFrom(configuration);

			fBasicTraceObservableTraceDetailsStringField.initializeFrom(configuration);
			fBasicTraceObservableFormatStringField.initializeFrom(configuration);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		fBasicTraceEnabledGenerationBooleanField.performApply(configuration);

		fBasicTraceFolderNameStringField.performApply(configuration);
		fBasicTraceFileNameStringField.performApply(configuration);

		fBasicTraceNormalizationBooleanField.performApply(configuration);
		fBasicTraceShowInitializationBooleanField.performApply(configuration);

		fBasicTraceAllExternalInputComBooleanField.performApply(configuration);
		fBasicTraceAllExternalOutputComBooleanField.performApply(configuration);
		fBasicTraceAllInternalInputComBooleanField.performApply(configuration);
		fBasicTraceAllInternalOutputComBooleanField.performApply(configuration);

		fBasicTraceTimeBooleanField.performApply(configuration);
		fBasicTraceAllVariableBooleanField.performApply(configuration);
		fBasicTraceAllTransitionBooleanField.performApply(configuration);
		fBasicTraceAllStateBooleanField.performApply(configuration);

		fBasicTraceObservableTraceDetailsStringField.performApply(configuration);
		fBasicTraceObservableFormatStringField.performApply(configuration);

		updateGreyedOutAreas(getAnalysisProfile(configuration),
				getBasicTraceEnableGeneration(configuration));
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		return true;
	}

}
