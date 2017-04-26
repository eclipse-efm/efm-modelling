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

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TestGenerationTTCNConfigurationProfile extends AbstractConfigurationProfile {

	private Group groupTTCNConfiguration;
	private Group groupTTCNModule;

	private BooleanFieldEditor fTTCNEnabledGenerationBooleanField;
	private BooleanFieldEditor fTTCNEnabledAdaptationModuleBooleanField;
	private StringFieldEditor fTTCNFolderNameStringField;

	private StringFieldEditor fTTCNControlModuleNameStringField;
	private StringFieldEditor fTTCNDeclarationsModuleNameStringField;
	private StringFieldEditor fTTCNTemplatesModuleNameStringField;

	private StringFieldEditor fTTCNTestcasesModuleNameStringField;
	private StringFieldEditor fTTCNTestcasesStartingWrapperStringField;
	private StringFieldEditor fTTCNTestcasesEndingWrapperStringField;
	private StringFieldEditor fTTCNTestcasesSendingWrapperStringField;
	private StringFieldEditor fTTCNTestcasesReceivingWrapperStringField;

	private StringFieldEditor fTTCNAdaptationModuleNameStringField;
	private StringFieldEditor fTTCNAdaptationUtilsImplStringField;
	private StringFieldEditor fTTCNTestcasesStartingEndingImplStringField;
	private StringFieldEditor fTTCNTestcasesSendingImplStringField;
	private StringFieldEditor fTTCNTestcasesReceivingImplStringField;


	/**
	 * COnstructor
	 * @param parentTab
	 */
	public TestGenerationTTCNConfigurationProfile(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "TTCN Tests Generation";
	}

	@Override
	public String getSectionDescription() {
		return "TTCN Tests Generation, configuration section";
	}


	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"Enabled Options", 2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNEnabledGenerationBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_TTCN_ENABLED_GENERATION,
						"&Generation", comp, false);

		fTTCNEnabledGenerationBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						handleEnablingGeneration();
					}
				});

		
		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNEnabledAdaptationModuleBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_TTCN_ENABLED_CUSTOMIZATION,
						"&Customization", comp,
						DEFAULT_TTCN_ENABLED_CUSTOMIZATION);

		fTTCNEnabledAdaptationModuleBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						handleEnablingAdaptationModule();
					}
				});

		
		createTTCNConfigurationComponent(parent, widgetToolkit);

		createTTCNModuleConfigurationComponent(parent, widgetToolkit);
	}

	private void handleEnablingGeneration() {
		fConfigurationPage.propagateVisibility(groupTTCNConfiguration,
				fTTCNEnabledGenerationBooleanField.getBooleanValue() );
		
		fTTCNEnabledAdaptationModuleBooleanField.setEnabled(
				fTTCNEnabledGenerationBooleanField.getBooleanValue() );
		
		fConfigurationPage.propagateVisibility(groupTTCNModule,
				fTTCNEnabledAdaptationModuleBooleanField.getBooleanValue() &&
				fTTCNEnabledGenerationBooleanField.getBooleanValue() );
	}

	private void handleEnablingAdaptationModule() {
		fConfigurationPage.propagateVisibility(groupTTCNModule,
				fTTCNEnabledAdaptationModuleBooleanField.getBooleanValue() &&
				fTTCNEnabledGenerationBooleanField.getBooleanValue() );
	}


	private void createTTCNConfigurationComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		groupTTCNConfiguration = widgetToolkit.createGroup(parent,
				"&Configuration", 2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				groupTTCNConfiguration, 1, 1, GridData.FILL_HORIZONTAL);

		fTTCNFolderNameStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_TTCN_FOLDER_NAME, "&Folder:", comp,
				DEFAULT_TTCN_FOLDER_NAME);
		fTTCNFolderNameStringField.setToolTipText(
				"Folder name w.r.t. <workspace-root>/<output>");
	}

	private void createTTCNModuleConfigurationComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		groupTTCNModule = widgetToolkit.createGroup(parent,
				"Modules Configuration", 3, 1, GridData.FILL_HORIZONTAL);

		createTTCNModuleControlComponent(groupTTCNModule, widgetToolkit);
		createTTCNModuleDeclarationComponent(groupTTCNModule, widgetToolkit);
		createTTCNModuleTemplatesComponent(groupTTCNModule, widgetToolkit);
		createTTCNModuleTestcasesComponent(groupTTCNModule, widgetToolkit);
		createTTCNModuleAdaptationComponent(groupTTCNModule, widgetToolkit);
	}


	private void createTTCNModuleControlComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"Control", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fTTCNControlModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_CONTROL_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_CONTROL_MODULE_NAME);
	}

	private void createTTCNModuleDeclarationComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"Declaration", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fTTCNDeclarationsModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_DECLARATIONS_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_DECLARATIONS_MODULE_NAME);
	}

	private void createTTCNModuleTemplatesComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"Templates", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNTemplatesModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_TEMPLATES_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_TEMPLATE_MODULE_NAME);
	}


	private void createTTCNModuleTestcasesComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"Testcases", 1, 3, GridData.FILL_HORIZONTAL);
		group.setToolTipText( HELPER_MODULE_TESTCASE_IMPLEMENTATION_TEMPLATE );

		Composite comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNTestcasesModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_TESTCASES_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_TESTCASES_MODULE_NAME);

		Group groupAdapters = widgetToolkit.createGroup(group,
				"Adapters", 2, 1, GridData.FILL_HORIZONTAL);
		groupAdapters.setToolTipText(
				HELPER_MODULE_TESTCASE_IMPLEMENTATION_TEMPLATE );

		group = widgetToolkit.createGroup(groupAdapters,
				"Wrappers for testcases Starting / Ending operations",
				2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		fTTCNTestcasesStartingWrapperStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_TTCN_TESTCASES_STARTING_WRAPPER, "&Starting:",
				comp, DEFAULT_TTCN_TESTCASES_STARTING_WRAPPER, SWT.MULTI);
		fTTCNTestcasesStartingWrapperStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		fTTCNTestcasesEndingWrapperStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_TTCN_TESTCASES_ENDING_WRAPPER, "&Ending:",
				comp, DEFAULT_TTCN_TESTCASES_ENDING_WRAPPER, SWT.MULTI);
		fTTCNTestcasesEndingWrapperStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		group = widgetToolkit.createGroup(groupAdapters,
				"Wrappers for testcases Sending / Receiving Operations",
				1, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );

		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );

		fTTCNTestcasesSendingWrapperStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_TTCN_TESTCASES_SENDING_WRAPPER, "&Sending:",
				comp, DEFAULT_TTCN_TESTCASES_SENDING_WRAPPER, SWT.MULTI);
		fTTCNTestcasesSendingWrapperStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );

		fTTCNTestcasesReceivingWrapperStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_TTCN_TESTCASES_RECEIVING_WRAPPER, "&Receiving:",
				comp, DEFAULT_TTCN_TESTCASES_RECEIVING_WRAPPER, SWT.MULTI);
		fTTCNTestcasesReceivingWrapperStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );
	}


	private void createTTCNModuleAdaptationComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"Adaptation", 1, 3, GridData.FILL_HORIZONTAL);
		group.setToolTipText( HELPER_MODULE_ADAPTATION_IMPLEMENTATION_TEMPLATE );

		Composite comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNAdaptationModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_ADAPTATION_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_ADAPTATION_MODULE_NAME);


		Group groupImpl = widgetToolkit.createGroup(group,
				"Implementations", 1, 1, GridData.FILL_HORIZONTAL);
		groupImpl.setToolTipText(
				HELPER_MODULE_ADAPTATION_IMPLEMENTATION_TEMPLATE );

		group = widgetToolkit.createGroup(groupImpl,
				"Implementations for Starting / Ending wrappers",
				2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		fTTCNTestcasesStartingEndingImplStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_TTCN_TESTCASES_STARTING_ENDING_IMPL, "",
				comp, DEFAULT_TTCN_TESTCASES_STARTING_ENDING_IMPL, SWT.MULTI);
		fTTCNTestcasesStartingEndingImplStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		group = widgetToolkit.createGroup(groupImpl,
				"Implementation of testcases Sending / Receiving wrappers",
				1, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );

		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );

		fTTCNTestcasesSendingImplStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_TESTCASES_SENDING_IMPL,
						"&Sending:", comp,
						DEFAULT_TTCN_TESTCASES_SENDING_IMPL, SWT.MULTI);
		fTTCNTestcasesSendingImplStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );

		fTTCNTestcasesReceivingImplStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_TTCN_TESTCASES_RECEIVING_IMPL, "&Receiving:",
				comp, DEFAULT_TTCN_TESTCASES_RECEIVING_IMPL, SWT.MULTI);
		fTTCNTestcasesReceivingImplStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );


		group = widgetToolkit.createGroup(groupImpl,
				"Implementation of utility functions such as 'f_timeout'",
				2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		fTTCNAdaptationUtilsImplStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_TTCN_ADAPTATION_UTILS_IMPL, "",
				comp, DEFAULT_TTCN_ADAPTATION_UTILS_IMPL, SWT.MULTI);
		fTTCNAdaptationUtilsImplStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );


	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
//		fTTCNEnabledGenerationBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_ENABLED_GENERATION, false);

//		fTTCNEnabledAdaptationModuleBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_ENABLED_CUSTOMIZATION,
				DEFAULT_TTCN_ENABLED_CUSTOMIZATION);

//		fTTCNFolderNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_FOLDER_NAME, DEFAULT_TTCN_FOLDER_NAME);


//		fTTCNControlModuleNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_CONTROL_MODULE_NAME,
				DEFAULT_TTCN_CONTROL_MODULE_NAME);

//		fTTCNDeclarationsModuleNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_DECLARATIONS_MODULE_NAME,
				DEFAULT_TTCN_DECLARATIONS_MODULE_NAME);

//		fTTCNTemplatesModuleNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TEMPLATES_MODULE_NAME,
				DEFAULT_TTCN_TEMPLATE_MODULE_NAME);


//		fTTCNTestcasesModuleNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_MODULE_NAME,
				DEFAULT_TTCN_TESTCASES_MODULE_NAME);

//		fTTCNTestcasesStartingWrapperStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_STARTING_WRAPPER,
				DEFAULT_TTCN_TESTCASES_STARTING_WRAPPER);

//		fTTCNTestcasesEndingWrapperStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_ENDING_WRAPPER,
				DEFAULT_TTCN_TESTCASES_ENDING_WRAPPER);

//		fTTCNTestcasesSendingWrapperStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_SENDING_WRAPPER,
				DEFAULT_TTCN_TESTCASES_SENDING_WRAPPER);

//		fTTCNTestcasesReceivingWrapperStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_STARTING_ENDING_IMPL,
				DEFAULT_TTCN_TESTCASES_STARTING_ENDING_IMPL);


//		fTTCNAdaptationModuleNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_ADAPTATION_MODULE_NAME,
				DEFAULT_TTCN_ADAPTATION_MODULE_NAME);

//		fTTCNAdaptationUtilsImplStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_ADAPTATION_UTILS_IMPL,
				DEFAULT_TTCN_ADAPTATION_UTILS_IMPL);

//		fTTCNTestcasesStartingEndingImplStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_STARTING_ENDING_IMPL,
				DEFAULT_TTCN_TESTCASES_STARTING_ENDING_IMPL);

//		fTTCNTestcasesReceivingWrapperStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_RECEIVING_WRAPPER,
				DEFAULT_TTCN_TESTCASES_RECEIVING_WRAPPER);


//		fTTCNTestcasesSendingImplStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_SENDING_IMPL,
				DEFAULT_TTCN_TESTCASES_SENDING_IMPL);

//		fTTCNTestcasesReceivingImplStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TTCN_TESTCASES_RECEIVING_IMPL,
				DEFAULT_TTCN_TESTCASES_RECEIVING_IMPL);
	}


	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		fTTCNEnabledGenerationBooleanField.initializeFrom(configuration);
		fTTCNEnabledAdaptationModuleBooleanField.initializeFrom(configuration);

		handleEnablingGeneration();
		handleEnablingAdaptationModule();

		fTTCNFolderNameStringField.initializeFrom(configuration);
		fTTCNControlModuleNameStringField.initializeFrom(configuration);
		fTTCNDeclarationsModuleNameStringField.initializeFrom(configuration);
		fTTCNTemplatesModuleNameStringField.initializeFrom(configuration);

		fTTCNTestcasesModuleNameStringField.initializeFrom(configuration);
		fTTCNTestcasesStartingWrapperStringField.initializeFrom(configuration);
		fTTCNTestcasesEndingWrapperStringField.initializeFrom(configuration);
		fTTCNTestcasesSendingWrapperStringField.initializeFrom(configuration);
		fTTCNTestcasesReceivingWrapperStringField.initializeFrom(configuration);

		fTTCNAdaptationModuleNameStringField.initializeFrom(configuration);
		fTTCNAdaptationUtilsImplStringField.initializeFrom(configuration);
		fTTCNTestcasesStartingEndingImplStringField.initializeFrom(configuration);
		fTTCNTestcasesSendingImplStringField.initializeFrom(configuration);
		fTTCNTestcasesReceivingImplStringField.initializeFrom(configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		fTTCNEnabledGenerationBooleanField.performApply(configuration);
		fTTCNEnabledAdaptationModuleBooleanField.performApply(configuration);

		fTTCNFolderNameStringField.performApply(configuration);

		fTTCNControlModuleNameStringField.performApply(configuration);
		fTTCNDeclarationsModuleNameStringField.performApply(configuration);
		fTTCNTemplatesModuleNameStringField.performApply(configuration);

		fTTCNTestcasesModuleNameStringField.performApply(configuration);
		fTTCNTestcasesStartingWrapperStringField.performApply(configuration);
		fTTCNTestcasesEndingWrapperStringField.performApply(configuration);
		fTTCNTestcasesSendingWrapperStringField.performApply(configuration);
		fTTCNTestcasesReceivingWrapperStringField.performApply(configuration);

		fTTCNAdaptationModuleNameStringField.performApply(configuration);
		fTTCNAdaptationUtilsImplStringField.performApply(configuration);
		fTTCNTestcasesStartingEndingImplStringField.performApply(configuration);
		fTTCNTestcasesSendingImplStringField.performApply(configuration);
		fTTCNTestcasesReceivingImplStringField.performApply(configuration);

//		String analysisProfile = getAnalysisProfile(configuration);
//		updateGreyedOutAreas(analysisProfile, fTTCNEnabledGenerationBooleanField.getBooleanValue());
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		return true;
	}

}
