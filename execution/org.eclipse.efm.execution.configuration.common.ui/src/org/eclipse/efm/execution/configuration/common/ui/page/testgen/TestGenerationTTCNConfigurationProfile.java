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
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationComponent;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.util.GenericCompositeCreator;
import org.eclipse.efm.execution.configuration.common.ui.util.SWTFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TestGenerationTTCNConfigurationProfile extends AbstractConfigurationComponent {

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
	public void createPageWithToolkit(Composite parentComposite) {
		createExpandableFrameWithToolkit(parentComposite, "TTCN Tests Generation Page");

		Group group = SWTFactory.createGroup(fCompositeControl,
				"Enabled Options", 2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNEnabledGenerationBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_TTCN_ENABLED_GENERATION,
						"&Generation", comp, false);

		comp = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNEnabledAdaptationModuleBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_TTCN_ENABLED_CUSTOMIZATION,
						"&Customization", comp,
						DEFAULT_TTCN_ENABLED_CUSTOMIZATION);

		createTTCNConfigurationComponent(fCompositeControl);

		createTTCNModuleConfigurationComponent(fCompositeControl);
	}


	private void createTTCNConfigurationComponent(Composite parent) {
		groupTTCNConfiguration = SWTFactory.createGroup(parent,
				"&Configuration", 2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				groupTTCNConfiguration, 1, 1, GridData.FILL_HORIZONTAL);

		fTTCNFolderNameStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_TTCN_FOLDER_NAME, "&Folder:", comp,
				DEFAULT_TTCN_FOLDER_NAME);
		fTTCNFolderNameStringField.setToolTipText(
				"Folder name w.r.t. <workspace-root>/<output>");
	}

	private void createTTCNModuleConfigurationComponent(Composite parent) {
		groupTTCNModule = SWTFactory.createGroup(parent,
				"Modules Configuration", 3, 1, GridData.FILL_HORIZONTAL);

		createTTCNModuleControlComponent(groupTTCNModule);
		createTTCNModuleDeclarationComponent(groupTTCNModule);
		createTTCNModuleTemplatesComponent(groupTTCNModule);
		createTTCNModuleTestcasesComponent(groupTTCNModule);
		createTTCNModuleAdaptationComponent(groupTTCNModule);
	}


	private void createTTCNModuleControlComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"Control", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fTTCNControlModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_CONTROL_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_CONTROL_MODULE_NAME);
	}

	private void createTTCNModuleDeclarationComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"Declaration", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fTTCNDeclarationsModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_DECLARATIONS_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_DECLARATIONS_MODULE_NAME);
	}

	private void createTTCNModuleTemplatesComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"Templates", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNTemplatesModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_TEMPLATES_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_TEMPLATE_MODULE_NAME);
	}


	private void createTTCNModuleTestcasesComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"Testcases", 1, 3, GridData.FILL_HORIZONTAL);
		group.setToolTipText( HELPER_MODULE_TESTCASE_IMPLEMENTATION_TEMPLATE );

		Composite comp = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNTestcasesModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_TESTCASES_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_TESTCASES_MODULE_NAME);

		Group groupAdapters = SWTFactory.createGroup(group,
				"Adapters", 2, 1, GridData.FILL_HORIZONTAL);
		groupAdapters.setToolTipText(
				HELPER_MODULE_TESTCASE_IMPLEMENTATION_TEMPLATE );

		group = SWTFactory.createGroup(groupAdapters,
				"Wrappers for testcases Starting / Ending operations",
				2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		comp = SWTFactory.createComposite(
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

		group = SWTFactory.createGroup(groupAdapters,
				"Wrappers for testcases Sending / Receiving Operations",
				1, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );

		comp = SWTFactory.createComposite(
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


	private void createTTCNModuleAdaptationComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"Adaptation", 1, 3, GridData.FILL_HORIZONTAL);
		group.setToolTipText( HELPER_MODULE_ADAPTATION_IMPLEMENTATION_TEMPLATE );

		Composite comp = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTTCNAdaptationModuleNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_TTCN_ADAPTATION_MODULE_NAME,
						"&Name:", comp,
						DEFAULT_TTCN_ADAPTATION_MODULE_NAME);


		Group groupImpl = SWTFactory.createGroup(group,
				"Implementations", 1, 1, GridData.FILL_HORIZONTAL);
		groupImpl.setToolTipText(
				HELPER_MODULE_ADAPTATION_IMPLEMENTATION_TEMPLATE );

		group = SWTFactory.createGroup(groupImpl,
				"Implementations for Starting / Ending wrappers",
				2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);
		comp.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		fTTCNTestcasesStartingEndingImplStringField = new StringFieldEditor(
				fConfigurationPage, ATTR_TTCN_TESTCASES_STARTING_ENDING_IMPL, "",
				comp, DEFAULT_TTCN_TESTCASES_STARTING_ENDING_IMPL, SWT.MULTI);
		fTTCNTestcasesStartingEndingImplStringField.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		group = SWTFactory.createGroup(groupImpl,
				"Implementation of testcases Sending / Receiving wrappers",
				1, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS );

		comp = SWTFactory.createComposite(
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


		group = SWTFactory.createGroup(groupImpl,
				"Implementation of utility functions such as 'f_timeout'",
				2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS );

		comp = SWTFactory.createComposite(
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
	
	private boolean getTTCNTraceEnableGeneration(ILaunchConfiguration configuration) {
		boolean basicTraceEnableGeneration;
		try {
			basicTraceEnableGeneration = configuration.getAttribute(ATTR_TTCN_ENABLED_GENERATION, false);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			basicTraceEnableGeneration = false;
		}
		return basicTraceEnableGeneration;
	}
	
	private void updateGreyedOutAreas(String analysisProfile, boolean TTCNEnableGeneration) {
		if ( analysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE ) ) {
			fTTCNEnabledGenerationBooleanField.setEnabled(false);
			fTTCNEnabledAdaptationModuleBooleanField.setEnabled(false);
			
			fTTCNEnabledAdaptationModuleBooleanField.setEnabled(false);
			GenericCompositeCreator.recursiveSetEnabled(groupTTCNConfiguration, false);
			GenericCompositeCreator.recursiveSetEnabled(groupTTCNModule, false);
		}
		else {
			fTTCNEnabledGenerationBooleanField.setEnabled(true);
			fTTCNEnabledAdaptationModuleBooleanField.setEnabled(true);
			if (TTCNEnableGeneration) {
				fTTCNEnabledAdaptationModuleBooleanField.setEnabled(true);
				GenericCompositeCreator.recursiveSetEnabled(groupTTCNConfiguration, true);
				boolean enabledAdaptation = fTTCNEnabledAdaptationModuleBooleanField.getBooleanValue();
				GenericCompositeCreator.recursiveSetEnabled(groupTTCNModule, enabledAdaptation);
			} else {
				fTTCNEnabledAdaptationModuleBooleanField.setEnabled(false);
				GenericCompositeCreator.recursiveSetEnabled(groupTTCNConfiguration, false);
				GenericCompositeCreator.recursiveSetEnabled(groupTTCNModule, false);
			}
		}
		
		
	}
		
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		String analysisProfile = getAnalysisProfile(configuration);
		boolean ttcn3TraceEnableGeneration = getTTCNTraceEnableGeneration(configuration);
		updateGreyedOutAreas(analysisProfile, ttcn3TraceEnableGeneration);
		if ( ! analysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE ) ) {
			fTTCNEnabledGenerationBooleanField.initializeFrom(configuration);
			fTTCNEnabledAdaptationModuleBooleanField.initializeFrom(configuration);
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

		String analysisProfile = getAnalysisProfile(configuration);
		boolean ttcn3TraceEnableGeneration = getTTCNTraceEnableGeneration(configuration);
		updateGreyedOutAreas(analysisProfile, ttcn3TraceEnableGeneration);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		return true;
	}

}
