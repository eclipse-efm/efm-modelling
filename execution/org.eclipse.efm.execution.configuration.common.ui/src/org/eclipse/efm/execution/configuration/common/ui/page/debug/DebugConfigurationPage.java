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

package org.eclipse.efm.execution.configuration.common.ui.page.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.efm.execution.core.AbstractLaunchDelegate;
import org.eclipse.efm.execution.core.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class DebugConfigurationPage extends AbstractConfigurationPage {

	// Console Log
	private static final String[] CONSOLE_LEVEL_COMBO_ITEMS = new String[] {
			ConsoleVerbosityKind.SILENT.getLiteral(),
			ConsoleVerbosityKind.MINIMUM.getLiteral(),
			ConsoleVerbosityKind.MEDIUM.getLiteral(),
			ConsoleVerbosityKind.MAXIMUM.getLiteral()
	};

//		Arrays.stream(ConsoleVerbosityKind.values()).map(
//				ConsoleVerbosityKind::getLiteral).toArray(String[]::new);

	private Combo fConsoleLevelCombo = null;
	private ConsoleVerbosityKind fConsoleLevel = ConsoleVerbosityKind.MINIMUM;

	// First Symbex Workflow Page
	private BooleanFieldEditor fFirstParsedModelTextualEnabledBooleanField;
//		private StringFieldEditor  fFirstparsedModelTextualFileNameStringField;

	private BooleanFieldEditor fFirstParsedModelGraphizEnabledBooleanField;
//		private StringFieldEditor  fFirstParsedModelGraphizFileNameStringField;

	private BooleanFieldEditor fFirstCompiledModelTextualEnabledBooleanField;
//		private StringFieldEditor  fFirstCompiledModelTextualFileNameStringField;
	private boolean fEnabledSymbexDeveloperMode;

	private BooleanFieldEditor fFirstSymbexOutputTextualEnabledBooleanField;
//		private StringFieldEditor  fFirstSymbexOutputTextualFileNameStringField;

	private BooleanFieldEditor fFirstSymbexOutputGraphizEnabledBooleanField;
//		private StringFieldEditor  fFirstSymbexOutputGraphizFileNameStringField;
	private Group fGroupFirstSymbexOutputTrace;
	private Group fGroupFirstSymbexOutputFormat;

	private StringFieldEditor  fFirstSymbexOutputGraphizTraceStringField;
	private StringFieldEditor  fFirstSymbexOutputGraphizFormatStringField;
	

	// Second Symbex Workflow Page
	private Group fGroupSecondStageSymbexWorkflow;
//		private BooleanFieldEditor fSecondParsedModelGraphizEnabledBooleanField;
////		private StringFieldEditor  fSecondParsedModelGraphizFileNameStringField;
//
//		private BooleanFieldEditor fSecondParsedModelTextualEnabledBooleanField;
////		private StringFieldEditor  fSecondparsedModelTextualFileNameStringField;
//
//		private BooleanFieldEditor fSecondCompiledModelTextualEnabledBooleanField;
////		private StringFieldEditor  fSecondCompiledModelTextualFileNameStringField;

	private Group fGroupSymbexOutputGeneratedTraces;
	
	private BooleanFieldEditor fSecondSymbexOutputTextualEnabledBooleanField;
//		private StringFieldEditor  fSecondSymbexOutputTextualFileNameStringField;

	private BooleanFieldEditor fSecondSymbexOutputGraphizEnabledBooleanField;
//		private StringFieldEditor  fSecondSymbexOutputGraphizFileNameStringField;
	private Group fGroupSecondSymbexOutputTrace;
	private Group fGroupSecondSymbexOutputFormat;

	private StringFieldEditor  fSecondSymbexOutputGraphizTraceStringField;
	private StringFieldEditor  fSecondSymbexOutputGraphizFormatStringField;
	

	
	public DebugConfigurationPage(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);

		if( AbstractLaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION ) {
			fEnabledSymbexDeveloperMode = SymbexPreferenceUtil.getBooleanPreference(
					IWorkflowPreferenceConstants.PREF_SYMBEX_DEVELOPER_MODE);
		}
		else {
			fEnabledSymbexDeveloperMode = false;
		}
	}

	// ======================================================================================
	//                              Miscellaneous handling
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

			if (source == fConsoleLevelCombo) {
				handleConsoleLevelSelectionChange();
			}
		}
	}

	private TabListener fListener= new TabListener();

	private void handleConsoleLevelSelectionChange() {
		fConsoleLevel = ConsoleVerbosityKind.get( fConsoleLevelCombo.getText() );
		if( fConsoleLevel == null ) {
			fConsoleLevel = ConsoleVerbosityKind.MINIMUM;
		}

		propagateGUIupdate();
	}

	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		createDebugTracePage(parent, widgetToolkit);
	}

	private void createDebugTracePage(Composite parent, IWidgetToolkit widgetToolkit)
	{
		Group group = widgetToolkit.createGroup(parent,
				"Debug Trace", 1, 1, GridData.FILL_HORIZONTAL);

		createConsoleLogComponent(group, widgetToolkit);

		createFirstSymbexWorkflowPage(group, widgetToolkit);

		createSecondSymbexWorkflowtPage(group, widgetToolkit);
	}


	private void createConsoleLogComponent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		Group group = widgetToolkit.createGroup(parent,
				"Console Log", 2, 1, GridData.FILL_HORIZONTAL);

		widgetToolkit.createLabel(group, "&Verbose Level :", 1);

		fConsoleLevelCombo = widgetToolkit.createCombo(group,
				SWT.DROP_DOWN | SWT.READ_ONLY, 1, CONSOLE_LEVEL_COMBO_ITEMS);

		fConsoleLevelCombo.addSelectionListener(fListener);
	}


	public void createFirstSymbexWorkflowPage(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"First Stage Symbex Workflow Page",
				1, 1, GridData.FILL_HORIZONTAL);

		createFirstInputModelGraphicComponent(group, widgetToolkit);

		createFirstSymbexOutputComponent(group, widgetToolkit);
	}

	private void createFirstInputModelGraphicComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"Input Model Generated Traces",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fFirstParsedModelTextualEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_FIRST_PARSED_MODEL_TEXTUAL_GENERATION,
				"&Parsed Model as Textual Representation", comp, false);

		fFirstParsedModelGraphizEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_FIRST_PARSED_MODEL_GRAPHVIZ_GENERATION,
				"&Parsed Model as <Graphiz> Representation", comp, false);

		if( fEnabledSymbexDeveloperMode ) {
			fFirstCompiledModelTextualEnabledBooleanField =
				new BooleanFieldEditor(this,
					ATTR_ENABLED_FIRST_COMPILED_MODEL_TEXTUAL_GENERATION,
					"&Compiled Model as Textual Representation", comp, false);
		}
	}

	private void createFirstSymbexOutputComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		Group group = widgetToolkit.createGroup(parent,
				"Symbex Output Generated Traces",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fFirstSymbexOutputTextualEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_TEXTUAL_GENERATION,
				"&Basic Textual Representation", comp, false);


		group = widgetToolkit.createGroup(comp,
				"Symbex Output Generated Graphic Traces",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fFirstSymbexOutputGraphizEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION,
				"&<Graphiz> Representation", comp, false);
		fFirstSymbexOutputGraphizEnabledBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						setEnableFirstExecutionPage(
								fFirstSymbexOutputGraphizEnabledBooleanField.
								getBooleanValue() );
					}
				});

		fGroupFirstSymbexOutputTrace = widgetToolkit.createGroup(
				comp, "&Trace ", 1, 2, GridData.FILL_BOTH);
		fFirstSymbexOutputGraphizTraceStringField = new StringFieldEditor(
				this, ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				"", fGroupFirstSymbexOutputTrace,
				DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);

		fGroupFirstSymbexOutputFormat = widgetToolkit.createGroup(
				comp, "&Format ", 1, 2, GridData.FILL_BOTH);
		fFirstSymbexOutputGraphizFormatStringField = new StringFieldEditor(
				this, ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				"", fGroupFirstSymbexOutputFormat,
				DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
	}


	private void setEnableFirstExecutionPage(boolean checked) {
		propagateVisibility(fGroupFirstSymbexOutputTrace, checked);
		
		propagateVisibility(fGroupFirstSymbexOutputFormat, checked);
	}


	public void createSecondSymbexWorkflowtPage(Composite parent, IWidgetToolkit widgetToolkit) {
		fGroupSecondStageSymbexWorkflow = widgetToolkit.createGroup(parent,
				"Second Stage Symbex Workflow Page", 1, 1, GridData.FILL_HORIZONTAL);

//			createSecondInputModelGraphicComponent(group);

		createSecondSymbexOutputComponent(fGroupSecondStageSymbexWorkflow, widgetToolkit);
	}


//		private void createSecondInputModelGraphicComponent(Composite parent) {
//			Group group = SWTFactory.createGroup(parent,
//					"Input Model Generated Traces",
//					1, 1, GridData.FILL_HORIZONTAL);
//
//			Composite comp = SWTFactory.createComposite(
//					group, 1, 1, GridData.FILL_HORIZONTAL);
//
//			fSecondParsedModelTextualEnabledBooleanField = new BooleanFieldEditor(
//					this, ATTR_ENABLED_SECOND_PARSED_MODEL_TEXTUAL_GENERATION,
//					"&Parsed Model as Textual Representation", comp, false);
//
//			fSecondParsedModelGraphizEnabledBooleanField = new BooleanFieldEditor(
//					this, ATTR_ENABLED_SECOND_PARSED_MODEL_GRAPHVIZ_GENERATION,
//					"&Parsed Model as <Graphiz> Representation", comp, false);
//
//			if( fEnabledSymbexDeveloperMode ) {
//				fSecondCompiledModelTextualEnabledBooleanField =
//					new BooleanFieldEditor(this,
//						ATTR_ENABLED_SECOND_COMPILED_MODEL_TEXTUAL_GENERATION,
//						"&Compiled Model as Textual Representation", comp, false);
//			}
//		}

	private void createSecondSymbexOutputComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		fGroupSymbexOutputGeneratedTraces = widgetToolkit.createGroup(parent,
				"Symbex Output Generated Traces",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				fGroupSymbexOutputGeneratedTraces, 1, 1, GridData.FILL_HORIZONTAL);

		fSecondSymbexOutputTextualEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_TEXTUAL_GENERATION,
				"&Basic Textual Representation", comp, false);


		Group group = widgetToolkit.createGroup(comp,
				"Symbex Output Generated Graphic Traces",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		fSecondSymbexOutputGraphizEnabledBooleanField = new BooleanFieldEditor(
				this, ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION,
				"&<Graphiz> Representation", comp, false);
		fSecondSymbexOutputGraphizEnabledBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						setEnableSecondExecutionPage(
								fSecondSymbexOutputGraphizEnabledBooleanField.
								getBooleanValue() );
					}
				});

		fGroupSecondSymbexOutputTrace = widgetToolkit.createGroup(
				comp, "&Trace ", 1, 2, GridData.FILL_BOTH);
		fSecondSymbexOutputGraphizTraceStringField = new StringFieldEditor(
				this, ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				"", fGroupSecondSymbexOutputTrace,
				DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);

		fGroupSecondSymbexOutputFormat = widgetToolkit.createGroup(
				comp, "&Format ", 1, 2, GridData.FILL_BOTH);
		fSecondSymbexOutputGraphizFormatStringField = new StringFieldEditor(
				this, ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				"", fGroupSecondSymbexOutputFormat,
				DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
	}


	private void setEnableSecondExecutionPage(boolean checked) {
		propagateVisibility(fGroupSecondSymbexOutputTrace, checked);
		
		propagateVisibility(fGroupSecondSymbexOutputFormat, checked);
	}

	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_CONSOLE_LOG_VERBOSE_LEVEL, "MINIMUM");

		// First Symbex Workflow Page
//			fFirstParsedModelTextualEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_FIRST_PARSED_MODEL_TEXTUAL_GENERATION, false);

		configuration.setAttribute(
				ATTR_FIRST_PARSED_MODEL_TEXTUAL_FILENAME,
				"model_parsed.xlia");

//			fFirstParsedModelGraphizEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_FIRST_PARSED_MODEL_GRAPHVIZ_GENERATION, false);

		configuration.setAttribute(
				ATTR_FIRST_PARSED_MODEL_GRAPHVIZ_FILENAME,
				"model_parsed_graph.gv");

		if( fEnabledSymbexDeveloperMode ) {
//				fFirstCompiledModelTextualEnabledBooleanField.setDefaults(configuration);
			configuration.setAttribute(
					ATTR_ENABLED_FIRST_COMPILED_MODEL_TEXTUAL_GENERATION, false);

			configuration.setAttribute(
					ATTR_FIRST_COMPILED_MODEL_TEXTUAL_FILENAME,
					"phase1_compiled_model.fexe");
		}

//			fFirstSymbexOutputTextualEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_TEXTUAL_GENERATION, false);

		configuration.setAttribute(
				ATTR_FIRST_SYMBEX_OUTPUT_TEXTUAL_FILENAME,
				DEFAULT_FIRST_SYMBEX_OUTPUT_TEXTUAL_FILENAME);

//			fFirstSymbexOutputGraphizEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION, false);

		configuration.setAttribute(
				ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME,
				DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME);

//			fFirstSymbexOutputGraphizTraceStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC);

//			fFirstSymbexOutputGraphizFormatStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC);

		// Second Symbex Workflow Page
//			fSecondParsedModelTextualEnabledBooleanField.setDefaults(configuration);
//			configuration.setAttribute(
//					ATTR_ENABLED_SECOND_PARSED_MODEL_TEXTUAL_GENERATION, false);

		configuration.setAttribute(
				ATTR_SECOND_PARSED_MODEL_TEXTUAL_FILENAME,
				"phase2_parsed_model.xlia");

//			fSecondParsedModelGraphizEnabledBooleanField.setDefaults(configuration);
//			configuration.setAttribute(
//					ATTR_ENABLED_SECOND_PARSED_MODEL_GRAPHVIZ_GENERATION, false);

		configuration.setAttribute(
				ATTR_SECOND_PARSED_MODEL_GRAPHVIZ_FILENAME,
				"phase2_parsed_model.gv");

		if( fEnabledSymbexDeveloperMode ) {
//				fSecondCompiledModelTextualEnabledBooleanField.setDefaults(configuration);
			configuration.setAttribute(
					ATTR_ENABLED_SECOND_COMPILED_MODEL_TEXTUAL_GENERATION, false);

			configuration.setAttribute(
					ATTR_SECOND_COMPILED_MODEL_TEXTUAL_FILENAME,
					"phase2_compiled_model.fexe");
		}

//			fSecondSymbexOutputTextualEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_TEXTUAL_GENERATION, false);

		configuration.setAttribute(
				ATTR_SECOND_SYMBEX_OUTPUT_TEXTUAL_FILENAME,
				DEFAULT_SECOND_SYMBEX_OUTPUT_TEXTUAL_FILENAME);

//			fSecondSymbexOutputGraphizEnabledBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION, false);

		configuration.setAttribute(
				ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME,
				DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME);

//			fSecondSymbexOutputGraphizTraceStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC);

//			fSecondSymbexOutputGraphizFormatStringField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC);
	}

	@Override
	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		try {
			fConsoleLevel = ConsoleVerbosityKind.get(
					configuration.getAttribute(ATTR_CONSOLE_LOG_VERBOSE_LEVEL,
							ConsoleVerbosityKind.MINIMUM.getLiteral()) );
		}
		catch (CoreException e) {
			e.printStackTrace();

			fConsoleLevel = ConsoleVerbosityKind.MINIMUM;
		}

		if( fConsoleLevel == null ) {
			fConsoleLevel = ConsoleVerbosityKind.MINIMUM;
		}
		initializeConsoleLevel();

		fFirstParsedModelTextualEnabledBooleanField.initializeFrom(configuration);
		fFirstParsedModelGraphizEnabledBooleanField.initializeFrom(configuration);
		if( fEnabledSymbexDeveloperMode ) {
			fFirstCompiledModelTextualEnabledBooleanField.initializeFrom(configuration);
		}

		fFirstSymbexOutputTextualEnabledBooleanField.initializeFrom(configuration);
		fFirstSymbexOutputGraphizEnabledBooleanField.initializeFrom(configuration);
		fFirstSymbexOutputGraphizTraceStringField.initializeFrom(configuration);

		fFirstSymbexOutputGraphizFormatStringField.initializeFrom(configuration);


//			fSecondParsedModelTextualEnabledBooleanField.initializeFrom(configuration);
//			fSecondParsedModelGraphizEnabledBooleanField.initializeFrom(configuration);
//			if( fEnabledSymbexDeveloperMode ) {
//				fSecondCompiledModelTextualEnabledBooleanField.initializeFrom(configuration);
//			}

		fSecondSymbexOutputTextualEnabledBooleanField.initializeFrom(configuration);
		fSecondSymbexOutputGraphizEnabledBooleanField.initializeFrom(configuration);
		fSecondSymbexOutputGraphizTraceStringField.initializeFrom(configuration);

		fSecondSymbexOutputGraphizFormatStringField.initializeFrom(configuration);


		setEnableFirstExecutionPage(
				fFirstSymbexOutputGraphizEnabledBooleanField.getBooleanValue() );

		setEnableSecondExecutionPage(
				fSecondSymbexOutputGraphizEnabledBooleanField.getBooleanValue() );
		
		try {
			propagateVisibility(fGroupSecondStageSymbexWorkflow,
					configuration.getAttribute(ATTR_ENABLED_TRACE_EXTENSION, false));
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void initializeConsoleLevel() {
		switch ( fConsoleLevel ) {
			case SILENT:
				fConsoleLevelCombo.select(0);
				break;
			case MINIMUM:
				fConsoleLevelCombo.select(1);
				break;
			case MEDIUM:
				fConsoleLevelCombo.select(2);
				break;
			case MAXIMUM:
				fConsoleLevelCombo.select(3);
				break;
			default:
				fConsoleLevelCombo.select(0);
				break;
		}
	}


	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_CONSOLE_LOG_VERBOSE_LEVEL, fConsoleLevel.getLiteral());

		fFirstParsedModelTextualEnabledBooleanField.performApply(configuration);
		fFirstParsedModelGraphizEnabledBooleanField.performApply(configuration);
		if( fEnabledSymbexDeveloperMode ) {
			fFirstCompiledModelTextualEnabledBooleanField.performApply(configuration);
		}

		fFirstSymbexOutputTextualEnabledBooleanField.performApply(configuration);
		fFirstSymbexOutputGraphizEnabledBooleanField.performApply(configuration);
		fFirstSymbexOutputGraphizTraceStringField.performApply(configuration);

		fFirstSymbexOutputGraphizFormatStringField.performApply(configuration);


//		fSecondParsedModelTextualEnabledBooleanField.performApply(configuration);
//		fSecondParsedModelGraphizEnabledBooleanField.performApply(configuration);
//		if( fEnabledSymbexDeveloperMode ) {
//			fSecondCompiledModelTextualEnabledBooleanField.performApply(configuration);
//		}

		fSecondSymbexOutputTextualEnabledBooleanField.performApply(configuration);
		fSecondSymbexOutputGraphizEnabledBooleanField.performApply(configuration);
		fSecondSymbexOutputGraphizTraceStringField.performApply(configuration);

		fSecondSymbexOutputGraphizFormatStringField.performApply(configuration);


		setEnableFirstExecutionPage(
				fFirstSymbexOutputGraphizEnabledBooleanField.getBooleanValue() );

		setEnableSecondExecutionPage(
				fSecondSymbexOutputGraphizEnabledBooleanField.getBooleanValue() );
	}


	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		return new FieldValidationReturn(true, null);
	}

	
	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	protected void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_ENABLED_TRACE_EXTENSION:
//			fGroupSecondStageSymbexWorkflow.setEnabled( (Boolean)( event.getNewValue() ) );
			
			propagateVisibility(fGroupSecondStageSymbexWorkflow,
					(Boolean)( event.getNewValue() ) );
			
//			propagateVisibility(fGroupSymbexOutputGeneratedTraces,
//					(Boolean)( event.getNewValue() ) );
			break;
				
		default:
			break;
		}
	}
	

}

