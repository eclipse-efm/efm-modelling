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
package org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.ui.views.editors.impls.BooleanFieldEditor;
import org.eclipse.efm.execution.ui.views.editors.impls.StringFieldEditor;
import org.eclipse.efm.execution.ui.views.utils.GenericCompositeCreator;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationEditorComposite;
import org.eclipse.efm.execution.ui.views.utils.SWTFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class TestGenerationBasicTracePage extends AbstractTabComponentPage {

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
	public TestGenerationBasicTracePage(
			ILaunchConfigurationEditorComposite parentTab) {
		super(parentTab);
	}

	@Override
	public void createPageWithToolkit(Composite parentComposite, FormToolkit toolkit) {
		createExpandableFrameWithToolkit(parentComposite, toolkit, "BASIC <Ad'hoc> Tests Generation Page");

		Composite comp = SWTFactory.createComposite(
				fCompositeControl, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceEnabledGenerationBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_ENABLED_GENERATION,
						"&Enabled Generation", comp, false);

		createBasicConfigurationComponent(fCompositeControl);

		createObservableSelectionComponent(fCompositeControl);
	}


	private void createBasicConfigurationComponent(Composite parent) {
		groupBasicConfiguration = SWTFactory.createGroup(parent,
				"&Configuration", 2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				groupBasicConfiguration, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceFolderNameStringField = new StringFieldEditor(fParentTab,
				ATTR_BASIC_TRACE_FOLDER_NAME, "&Folder:",
				comp, DEFAULT_BASIC_TRACE_FOLDER_NAME);
		fBasicTraceFolderNameStringField.setToolTipText(
				"Folder name w.r.t. <workspace-root>/<output>");

		comp = SWTFactory.createComposite(
				groupBasicConfiguration, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceFileNameStringField = new StringFieldEditor(fParentTab,
				ATTR_BASIC_TRACE_FILE_NAME, "&File:",
				comp, DEFAULT_BASIC_TRACE_FILE_NAME);
		fBasicTraceFileNameStringField.setToolTipText("File name");

		comp = SWTFactory.createComposite(groupBasicConfiguration,
				1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceNormalizationBooleanField = new BooleanFieldEditor(
				fParentTab, ATTR_BASIC_TRACE_ENABLED_NORMALIZATION,
				"&Normalization (Redundance Elimination...)", comp, true);

		comp = SWTFactory.createComposite(groupBasicConfiguration,
				1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceShowInitializationBooleanField = new BooleanFieldEditor(
				fParentTab, ATTR_BASIC_TRACE_SHOW_INITIALIZATION,
				"&Show Parameters Initialization", comp, false);
	}

	public void createObservableSelectionComponent(Composite parent) {
		groupBasicObservable = SWTFactory.createGroup(parent,
				"&Observable Traces Selection", 3, 1, GridData.FILL_HORIZONTAL);

		createExternalCommunicationComponent(groupBasicObservable);

		createInternalCommunicationComponent(groupBasicObservable);

		createOtherObservableComponent(groupBasicObservable);

		createObservableDetailsComponent(groupBasicObservable);

		createObservableFormatComponent(groupBasicObservable);
	}

	private void createExternalCommunicationComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"External Communication", 2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				"External, Input or Output, Communication Selection" );


		Composite comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllExternalInputComBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION,
						"&Input", comp, true);


		comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllExternalOutputComBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION,
						"&Output", comp, true);
	}

	private void createInternalCommunicationComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"&Any Communication", 2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText( "External or Internal, "
				+ "Input or Output, Communication Selection" );


		Composite comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllInternalInputComBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_ALL_INPUT_COM_SELECTION,
						"&Input", comp, false);


		comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllInternalOutputComBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_ALL_OUTPUT_COM_SELECTION,
						"&Output", comp, false);
	}

	private void createOtherObservableComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"&Other Elements", 4, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText( "Other Elements like, Time, Variable, "
				+ "Transition, State..., Communication Selection" );

		Composite comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceTimeBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_TIME_SELECTION,
						"&Time", comp, true);


		comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllVariableBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION,
						"&Variable", comp, false);


		comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllTransitionBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION,
						"&Transition", comp, false);


		comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceAllStateBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_BASIC_TRACE_ALL_STATE_SELECTION,
						"&State", comp, false);
	}

	private void createObservableDetailsComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"&Details", 1, 3, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceObservableTraceDetailsStringField = new StringFieldEditor(
				fParentTab, ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST, "",
				comp, DEFAULT_BASIC_TRACE_DETAILS_ELEMENT_LIST, SWT.MULTI);
	}


	private void createObservableFormatComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"&Ad'Hoc Element Format for Tests",
				1, 3, GridData.FILL_HORIZONTAL);
		group.setToolTipText( HELPER_TRACE_FORMAT_SPECIFICATION );

		Composite comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText( HELPER_TRACE_FORMAT_SPECIFICATION );

		fBasicTraceObservableFormatStringField = new StringFieldEditor(
				fParentTab, ATTR_BASIC_TRACE_FORMAT_ELEMENT_LIST, "", comp,
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
		String analysisProfile;
		try {
			analysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");
		}
		catch (CoreException e) {
			e.printStackTrace();
			analysisProfile = "";
		}
		return analysisProfile;
	}
	
	private boolean getBasicTraceEnableGeneration(ILaunchConfiguration configuration) {
		boolean basicTraceEnableGeneration;
		try {
			basicTraceEnableGeneration = configuration.getAttribute(ATTR_BASIC_TRACE_ENABLED_GENERATION, false);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			basicTraceEnableGeneration = false;
		}
		return basicTraceEnableGeneration;
	}
	
	private void updateGreyedOutAreas(String analysisProfile, boolean basicTraceEnableGeneration) {
		if ( analysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE ) ) {
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

		if ( !analysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE ) ) {
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
