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

package org.eclipse.efm.execution.configuration.common.ui.page.developer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.efm.execution.core.workflow.common.DebuglevelKind;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class DeveloperTuningConfigurationPage extends AbstractConfigurationPage {

	private static final String[] TRACE_LEVEL_COMBO_ITEMS = new String[] {
			DebuglevelKind.ZERO.getLiteral(),
			DebuglevelKind.LOW.getLiteral(),
			DebuglevelKind.MEDIUM.getLiteral(),
			DebuglevelKind.HIGH.getLiteral(),
			DebuglevelKind.ULTRA.getLiteral(),
			DebuglevelKind.GOD_MODE.getLiteral()
	};

//	Arrays.stream(DebuglevelKind.values()).map(
//			DebuglevelKind::getLiteral).toArray(String[]::new);


	private Label fDebugTraceLevelLabel = null;

	private Group fGroupDebugTraceOptions;

	private Combo fDebugTraceLevelCombo = null;

	private DebuglevelKind fDebugTraceLevel = DebuglevelKind.ZERO;


	private BooleanFieldEditor fDeveloperModeEnabledBooleanField;
	private StringFieldEditor  fLogFileNameStringField;
	private StringFieldEditor  fDebugTraceFileNameStringField;

	// General Context
	private BooleanFieldEditor fParsingEnabledBooleanField;
	private BooleanFieldEditor fConfigureEnabledBooleanField;
	private BooleanFieldEditor fCompilingEnabledBooleanField;

	private BooleanFieldEditor fLoadingEnabledBooleanField;
	private BooleanFieldEditor fComputingEnabledBooleanField;
	private BooleanFieldEditor fReportingEnabledBooleanField;

	private BooleanFieldEditor fSolverEnabledBooleanField;
	private BooleanFieldEditor fProfilingEnabledBooleanField;

	// Symbex Process
	private BooleanFieldEditor fSymbexProcessEnabledBooleanField;

	private BooleanFieldEditor fPreProcessingEnabledBooleanField;
	private BooleanFieldEditor fPostProcessingEnabledBooleanField;
	private BooleanFieldEditor fProcessingEnabledBooleanField;

	private BooleanFieldEditor fPreFilteringEnabledBooleanField;
	private BooleanFieldEditor fPostFilteringEnabledBooleanField;
	private BooleanFieldEditor fFilteringEnabledBooleanField;

	private BooleanFieldEditor fQueueEnabledBooleanField;

	// Statement Evaluation
	private BooleanFieldEditor fProgramEnabledBooleanField;

	private BooleanFieldEditor fStatementEnabledBooleanField;
	private BooleanFieldEditor fStatementAssignEnabledBooleanField;
	private BooleanFieldEditor fStatementCommunicationEnabledBooleanField;
	private BooleanFieldEditor fStatementDecisionEnabledBooleanField;

	private BooleanFieldEditor fStatementBytecodeEnabledBooleanField;
	private BooleanFieldEditor fDataEnabledBooleanField;
	private BooleanFieldEditor fTraceEnabledBooleanField;

	// Element, Component
	private BooleanFieldEditor fVariableEnabledBooleanField;
	private BooleanFieldEditor fBufferEnabledBooleanField;
	private BooleanFieldEditor fPortEnabledBooleanField;
	private BooleanFieldEditor fSignalEnabledBooleanField;
	private BooleanFieldEditor fConnexionEnabledBooleanField;
	private BooleanFieldEditor fTimeEnabledBooleanField;

	private BooleanFieldEditor fExecutableEnabledBooleanField;
	private BooleanFieldEditor fActivityEnabledBooleanField;
	private BooleanFieldEditor fRoutineEnabledBooleanField;
	private BooleanFieldEditor fTransitionEnabledBooleanField;
	private BooleanFieldEditor fMachineEnabledBooleanField;
	private BooleanFieldEditor fStatemachineEnabledBooleanField;


	// Name Identifier
	private BooleanFieldEditor fNameIdEnabledBooleanField;
	private BooleanFieldEditor fQualifiedNameIdEnabledBooleanField;
	private BooleanFieldEditor fFullyQualifiedNameIdEnabledBooleanField;

	// Various
	private BooleanFieldEditor fRedundanceEnabledBooleanField;
	private BooleanFieldEditor fReferenceCountingEnabledBooleanField;

	// God Mode
	private BooleanFieldEditor fNothingEnabledBooleanField;
	private BooleanFieldEditor fGodModeEnabledBooleanField;

	public DeveloperTuningConfigurationPage(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);
	}


	// ======================================================================================
	//                              Miscellaneous Handling
	// ======================================================================================

	private class TabListener extends SelectionAdapter implements ModifyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		@Override
		public void modifyText(ModifyEvent e) {
			propagateGUIupdate();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			final Object source= e.getSource();

			if (source == fDebugTraceLevelCombo) {
				handleDebugTraceLevelSelectionChange();
			}
		}
	}

	private TabListener fListener= new TabListener();

	private void handleDebugTraceLevelSelectionChange() {
		fDebugTraceLevel = DebuglevelKind.get( fDebugTraceLevelCombo.getText() );
		if( fDebugTraceLevel == null ) {
			fDebugTraceLevel = DebuglevelKind.ZERO;
		}

		propagateVisibility(fGroupDebugTraceOptions,
				(fDebugTraceLevel != DebuglevelKind.ZERO));

		propagateGUIupdate();
	}

	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		createDeveloperTuningOptionsComponent(parent, widgetToolkit);
	}

	private void createDeveloperTuningOptionsComponent(
			Composite parent, IWidgetToolkit widgetToolkit)
	{
		Group group = widgetToolkit.createGroup(parent,
				"Developer Tuning Options", 2, 2, GridData.FILL_HORIZONTAL);

		createDeveloperModeComponent(group, widgetToolkit);

		createDebugTraceOptionsComponent(group, widgetToolkit);
	}

	private void setEnableDeveloperTuningOptionsPage(boolean enabled) {
		fLogFileNameStringField.setEnabled(enabled);
		fDebugTraceFileNameStringField.setEnabled(enabled);

		fDebugTraceLevelLabel.setEnabled(enabled);
		fDebugTraceLevelCombo.setEnabled(enabled);

		fGodModeEnabledBooleanField.setEnabled(enabled);

		enabled = enabled
				&& (fDebugTraceLevel != DebuglevelKind.ZERO)
				&& (! fGodModeEnabledBooleanField.getBooleanValue());

		propagateVisibility(fGroupDebugTraceOptions, enabled);
	}



	private void createDeveloperModeComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Composite comp = widgetToolkit.createComposite(
				parent, 1, 5, GridData.FILL_HORIZONTAL);

		fDeveloperModeEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_DEVELOPER_TUNING, "&Developer Mode", comp, false);
		
		fDeveloperModeEnabledBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						setEnableDeveloperTuningOptionsPage(
								fDeveloperModeEnabledBooleanField.getBooleanValue() );
					}
				});

		comp = widgetToolkit.createComposite(
				parent, 1, 5, GridData.FILL_HORIZONTAL);

		fLogFileNameStringField = new StringFieldEditor(this,
				ATTR_DEVELOPER_TUNING_LOG_FILENAME, "&Log File:",comp,
				DEFAULT_DEVELOPER_TUNING_LOG_FILENAME);

		fDebugTraceFileNameStringField = new StringFieldEditor(this,
				ATTR_DEVELOPER_TUNING_DEBUG_FILENAME, "&Debug File:", comp,
				DEFAULT_DEVELOPER_TUNING_DEBUG_FILENAME);


		fDebugTraceLevelLabel = widgetToolkit.createLabel(comp, "&Debug Level:", 1);

		fDebugTraceLevelCombo = widgetToolkit.createCombo(comp,
				SWT.DROP_DOWN | SWT.READ_ONLY, 1, TRACE_LEVEL_COMBO_ITEMS);

		fDebugTraceLevelCombo.addSelectionListener(fListener);
	}


	private void createDebugTraceOptionsComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		fGroupDebugTraceOptions = widgetToolkit.createGroup(parent,
				"Debug Trace Options", 3, 2, GridData.FILL_HORIZONTAL);

		// General Context
		Group group = widgetToolkit.createGroup(fGroupDebugTraceOptions,
				"General Context", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fParsingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_PARSING, "&PARSING", comp, false);

		fConfigureEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_CONFIGURING, "CONFIGURING", comp, false);

		fCompilingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_COMPILING, "COMPILING", comp, false);

		fLoadingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_LOADING, "LOADING", comp, false);

		fComputingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_COMPUTING, "COMPUTING", comp, false);

		fReportingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_REPORTING, "REPORTING", comp, false);

		fSolverEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_SOLVING, "SOLVING [SAT,SMT] ", comp, false);

		fProfilingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_PROFILING, "PROFILING", comp, false);


		// Process Stage: Processing, Filtering, ...
		group = widgetToolkit.createGroup(fGroupDebugTraceOptions,
				"Symbex Process Stage", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fSymbexProcessEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_ALL_PROCESS_STAGE,
				"ALL_PROCESS_STAGE", comp, false);

		fPreProcessingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_PRE_PROCESSING,
				"PRE_PROCESSING", comp, false);

		fPostProcessingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_POST_PROCESSING,
				"POST_PROCESSING", comp, false);

		fProcessingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_PROCESSING, "PROCESSING", comp, false);

		fPreFilteringEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_PRE_FILTERING,
				"PRE_FILTERING", comp, false);

		fPostFilteringEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_POST_FILTERING,
				"POST_FILTERING", comp, false);

		fFilteringEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_FILTERING, "FILTERING", comp, false);

		fQueueEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_QUEUE, "SYMBEX QUEUE", comp, false);


		// Statement Evaluation
		group = widgetToolkit.createGroup(fGroupDebugTraceOptions,
				"Evaluation: Statement, Trace, ...", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fProgramEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_PROGRAM, "PROGRAM", comp, false);

		fStatementEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_STATEMENT, "STATEMENT", comp, false);

		fStatementAssignEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_STATEMENT_ASSIGNMENT,
				"ASSIGNMENT", comp, false);

		fStatementCommunicationEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_TRACE_STATEMENT_COMMUNICATION,
				"COMMUNICATION", comp, false);

		fStatementDecisionEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_STATEMENT_TEST_DECISION,
				"TEST DECISION", comp, false);

		fStatementBytecodeEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_BYTECODE, "BYTECODE", comp, false);

		fDataEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_DATA, "DATA", comp, false);

		fTraceEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_TRACE, "TRACE [POINT]", comp, false);


		// Element: Property, Signal...
		group = widgetToolkit.createGroup(fGroupDebugTraceOptions,
				"Element: Property, Signal, ...", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fVariableEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_VARIABLE, "VARIABLE", comp, false);

		fBufferEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_BUFFER, "BUFFER", comp, false);

		fPortEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_PORT, "PORT", comp, false);

		fSignalEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_SIGNAL, "SIGNAL", comp, false);

		fConnexionEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_CONNEXION, "CONNEXION", comp, false);

		fTimeEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_TIME, "TIME", comp, false);


		// Executable Component...
		group = widgetToolkit.createGroup(fGroupDebugTraceOptions,
				"Executable Component", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fExecutableEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_EXECUTABLE, "EXECUTABLE", comp, false);

		fActivityEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_ACTIVITY, "ACTIVITY", comp, false);

		fRoutineEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_ROUTINE, "ROUTINE", comp, false);

		fTransitionEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_TRANSITION, "TRANSITION", comp, false);

		fMachineEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_MACHINE, "MACHINE", comp, false);

		fStatemachineEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_STATEMACHINE, "STATEMACHINE", comp, false);


		// Others: [Qualified]NameID, RefCount, ...
		group = widgetToolkit.createGroup(fGroupDebugTraceOptions,
				"Others: NameID, RefCount, ...",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fNameIdEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_NAME_ID, "NAME_ID", comp, false);

		fQualifiedNameIdEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_QUALIFIED_NAME_ID,
				"QUALIFIED_NAME_ID", comp, false);

		fFullyQualifiedNameIdEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_FULLY_QUALIFIED_NAME_ID,
				"FULLY_QUALIFIED_NAME_ID", comp, false);

		fRedundanceEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_REDUNDANCE, "REDUNDANCE", comp, false);

		fReferenceCountingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_REFERENCE_COUNTING,
				"REFERENCE_COUNTING", comp, false);

		fNothingEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_NOTHING, "NOTHING", comp, false);

		// God Mode
		comp = widgetToolkit.createComposite(
				parent, 2, 1, GridData.FILL_HORIZONTAL);

		fGodModeEnabledBooleanField = new BooleanFieldEditor(this,
				ATTR_ENABLED_TRACE_GOD_MODE, "GOD_MODE", comp, false);
	}

	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================


	@Override
	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {
//		fDeveloperModeEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_DEVELOPER_TUNING, false);

//		fLogFileNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_DEVELOPER_TUNING_LOG_FILENAME,
				DEFAULT_DEVELOPER_TUNING_LOG_FILENAME);

//		fDebugTraceFileNameStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_DEVELOPER_TUNING_DEBUG_FILENAME,
				DEFAULT_DEVELOPER_TUNING_DEBUG_FILENAME);

		configuration.setAttribute(ATTR_DEVELOPER_TUNING_DEBUG_LEVEL, "ZERO");


		// General Context
//		fParsingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_PARSING, false);

//		fConfigureEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_CONFIGURING, false);

//		fCompilingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_COMPILING, false);

//		fLoadingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_LOADING, false);

//		fComputingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_COMPUTING, false);

//		fReportingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_REPORTING, false);

//		fSolverEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_SOLVING, false);

//		fProfilingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_SOLVING, false);

		// Process Stage: Processing, Filtering, ...
//		fSymbexProcessEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_ALL_PROCESS_STAGE, false);

//		fPreProcessingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_PRE_PROCESSING, false);

//		fPostProcessingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_POST_PROCESSING, false);

//		fProcessingEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_PROCESSING, false);

//		fPreFilteringEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_PRE_FILTERING, false);

//		fPostFilteringEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_POST_FILTERING, false);

//		fFilteringEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_FILTERING, false);

//		fQueueEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_QUEUE, false);

		// Statement Evaluation
//		fProgramEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_PROGRAM, false);

//		fStatementEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_STATEMENT, false);

//		fStatementAssignEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_TRACE_STATEMENT_ASSIGNMENT, false);

//		fStatementCommunicationEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_TRACE_STATEMENT_COMMUNICATION, false);

//		fStatementDecisionEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_TRACE_STATEMENT_TEST_DECISION, false);

//		fStatementBytecodeEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_BYTECODE, false);

//		fDataEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_DATA, false);

//		fTraceEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_TRACE, false);

		// Element: Property, Signal...
//		fVariableEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_VARIABLE, false);

//		fBufferEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_BUFFER, false);

//		fPortEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_PORT, false);

//		fSignalEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_SIGNAL, false);

//		fConnexionEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_CONNEXION, false);

//		fTimeEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_TIME, false);

		// Executable Component...
//		fExecutableEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_EXECUTABLE, false);

//		fActivityEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_ACTIVITY, false);

//		fRoutineEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_ROUTINE, false);

//		fTransitionEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_TRANSITION, false);

//		fMachineEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_MACHINE, false);

//		fStatemachineEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_STATEMACHINE, false);


		// Others: [Qualified]NameID, RefCount, ...
//		fNameIdEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_NAME_ID, false);

//		fQualifiedNameIdEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_QUALIFIED_NAME_ID, false);

//		fFullyQualifiedNameIdEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_TRACE_FULLY_QUALIFIED_NAME_ID, false);

//		fRedundanceEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_REDUNDANCE, false);

//		fReferenceCountingEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_REFERENCE_COUNTING, false);

		// God Mode
//		fNothingEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_NOTHING, false);

//		fGodModeEnabledBooleanField.performApply(configuration);
		configuration.setAttribute(ATTR_ENABLED_TRACE_GOD_MODE, false);
	}

	@Override
	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		fDeveloperModeEnabledBooleanField.initializeFrom(configuration);
		fLogFileNameStringField.initializeFrom(configuration);
		fDebugTraceFileNameStringField.initializeFrom(configuration);

		try {
			fDebugTraceLevel = DebuglevelKind.get(
					configuration.getAttribute(
							ATTR_DEVELOPER_TUNING_DEBUG_LEVEL,
							DebuglevelKind.ZERO.getLiteral()) );
		}
		catch (CoreException e) {
			e.printStackTrace();

			fDebugTraceLevel = DebuglevelKind.ZERO;
		}

		if( fDebugTraceLevel == null ) {
			fDebugTraceLevel = DebuglevelKind.ZERO;
		}
		initializeTraceLevel();


		fParsingEnabledBooleanField.initializeFrom(configuration);
		fConfigureEnabledBooleanField.initializeFrom(configuration);
		fCompilingEnabledBooleanField.initializeFrom(configuration);

		fLoadingEnabledBooleanField.initializeFrom(configuration);
		fComputingEnabledBooleanField.initializeFrom(configuration);
		fReportingEnabledBooleanField.initializeFrom(configuration);

		fSolverEnabledBooleanField.initializeFrom(configuration);
		fProfilingEnabledBooleanField.initializeFrom(configuration);

		// Process Stage: Processing, Filtering, ...
		fSymbexProcessEnabledBooleanField.initializeFrom(configuration);

		fPreProcessingEnabledBooleanField.initializeFrom(configuration);
		fPostProcessingEnabledBooleanField.initializeFrom(configuration);
		fProcessingEnabledBooleanField.initializeFrom(configuration);

		fPreFilteringEnabledBooleanField.initializeFrom(configuration);
		fPostFilteringEnabledBooleanField.initializeFrom(configuration);
		fFilteringEnabledBooleanField.initializeFrom(configuration);

		fQueueEnabledBooleanField.initializeFrom(configuration);


		// Statement Evaluation
		fProgramEnabledBooleanField.initializeFrom(configuration);
		fStatementEnabledBooleanField.initializeFrom(configuration);
		fStatementAssignEnabledBooleanField.initializeFrom(configuration);
		fStatementCommunicationEnabledBooleanField.initializeFrom(configuration);
		fStatementDecisionEnabledBooleanField.initializeFrom(configuration);
		fStatementBytecodeEnabledBooleanField.initializeFrom(configuration);

		fDataEnabledBooleanField.initializeFrom(configuration);
		fTraceEnabledBooleanField.initializeFrom(configuration);

		// Element: Property, Signal...
		fVariableEnabledBooleanField.initializeFrom(configuration);
		fBufferEnabledBooleanField.initializeFrom(configuration);
		fPortEnabledBooleanField.initializeFrom(configuration);
		fSignalEnabledBooleanField.initializeFrom(configuration);
		fConnexionEnabledBooleanField.initializeFrom(configuration);
		fTimeEnabledBooleanField.initializeFrom(configuration);

		// Executable Component...
		fExecutableEnabledBooleanField.initializeFrom(configuration);
		fActivityEnabledBooleanField.initializeFrom(configuration);
		fRoutineEnabledBooleanField.initializeFrom(configuration);
		fTransitionEnabledBooleanField.initializeFrom(configuration);
		fMachineEnabledBooleanField.initializeFrom(configuration);
		fStatemachineEnabledBooleanField.initializeFrom(configuration);

		// Others: [Qualified]NameID, RefCount, ...
		fNameIdEnabledBooleanField.initializeFrom(configuration);
		fQualifiedNameIdEnabledBooleanField.initializeFrom(configuration);
		fFullyQualifiedNameIdEnabledBooleanField.initializeFrom(configuration);

		fRedundanceEnabledBooleanField.initializeFrom(configuration);
		fReferenceCountingEnabledBooleanField.initializeFrom(configuration);

		// God Mode
		fNothingEnabledBooleanField.initializeFrom(configuration);
		fGodModeEnabledBooleanField.initializeFrom(configuration);

		setEnableDeveloperTuningOptionsPage(
				fDeveloperModeEnabledBooleanField.getBooleanValue() );
	}


	private void initializeTraceLevel() {
		switch ( fDebugTraceLevel ) {
			case ZERO:
				fDebugTraceLevelCombo.select(0);
				break;
			case LOW:
				fDebugTraceLevelCombo.select(1);
				break;
			case MEDIUM:
				fDebugTraceLevelCombo.select(2);
				break;
			case HIGH:
				fDebugTraceLevelCombo.select(3);
				break;
			case ULTRA:
				fDebugTraceLevelCombo.select(4);
				break;
			case GOD_MODE:
				fDebugTraceLevelCombo.select(5);
				break;

			default:
				fDebugTraceLevelCombo.select(0);
				break;
		}
	}

	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		fDeveloperModeEnabledBooleanField.performApply(configuration);

		setEnableDeveloperTuningOptionsPage(
				fDeveloperModeEnabledBooleanField.getBooleanValue() );

		fLogFileNameStringField.performApply(configuration);
		fDebugTraceFileNameStringField.performApply(configuration);

		configuration.setAttribute(
				ATTR_DEVELOPER_TUNING_DEBUG_LEVEL,
				fDebugTraceLevel.getLiteral());

		// General Context
		fParsingEnabledBooleanField.performApply(configuration);
		fConfigureEnabledBooleanField.performApply(configuration);
		fCompilingEnabledBooleanField.performApply(configuration);

		fLoadingEnabledBooleanField.performApply(configuration);
		fComputingEnabledBooleanField.performApply(configuration);
		fReportingEnabledBooleanField.performApply(configuration);

		fSolverEnabledBooleanField.performApply(configuration);
		fProfilingEnabledBooleanField.performApply(configuration);

		// Process Stage: Processing, Filtering, ...
		fSymbexProcessEnabledBooleanField.performApply(configuration);

		fPreProcessingEnabledBooleanField.performApply(configuration);
		fPostProcessingEnabledBooleanField.performApply(configuration);
		fProcessingEnabledBooleanField.performApply(configuration);

		fPreFilteringEnabledBooleanField.performApply(configuration);
		fPostFilteringEnabledBooleanField.performApply(configuration);
		fFilteringEnabledBooleanField.performApply(configuration);

		fQueueEnabledBooleanField.performApply(configuration);

		// Statement Evaluation
		fProgramEnabledBooleanField.performApply(configuration);
		fStatementEnabledBooleanField.performApply(configuration);
		fStatementAssignEnabledBooleanField.performApply(configuration);
		fStatementCommunicationEnabledBooleanField.performApply(configuration);
		fStatementDecisionEnabledBooleanField.performApply(configuration);
		fStatementBytecodeEnabledBooleanField.performApply(configuration);

		fDataEnabledBooleanField.performApply(configuration);
		fTraceEnabledBooleanField.performApply(configuration);

		// Element: Property, Signal...
		fVariableEnabledBooleanField.performApply(configuration);
		fBufferEnabledBooleanField.performApply(configuration);
		fPortEnabledBooleanField.performApply(configuration);
		fSignalEnabledBooleanField.performApply(configuration);
		fConnexionEnabledBooleanField.performApply(configuration);
		fTimeEnabledBooleanField.performApply(configuration);

		// Executable Component...
		fExecutableEnabledBooleanField.performApply(configuration);
		fActivityEnabledBooleanField.performApply(configuration);
		fRoutineEnabledBooleanField.performApply(configuration);
		fTransitionEnabledBooleanField.performApply(configuration);
		fMachineEnabledBooleanField.performApply(configuration);
		fStatemachineEnabledBooleanField.performApply(configuration);

		// Others: [Qualified]NameID, RefCount, ...
		fNameIdEnabledBooleanField.performApply(configuration);
		fQualifiedNameIdEnabledBooleanField.performApply(configuration);
		fFullyQualifiedNameIdEnabledBooleanField.performApply(configuration);

		fRedundanceEnabledBooleanField.performApply(configuration);
		fReferenceCountingEnabledBooleanField.performApply(configuration);

		// God Mode
		fNothingEnabledBooleanField.performApply(configuration);
		fGodModeEnabledBooleanField.performApply(configuration);
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		return new FieldValidationReturn(true, null);
	}

}
