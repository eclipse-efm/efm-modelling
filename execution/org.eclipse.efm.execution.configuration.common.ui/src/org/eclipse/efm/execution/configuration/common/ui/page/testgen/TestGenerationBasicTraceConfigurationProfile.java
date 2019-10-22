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
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableConfigProvider;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TestGenerationBasicTraceConfigurationProfile extends AbstractConfigurationProfile {

	private Group groupBasicConfiguration;
	private Group groupBasicObservable;

	private BooleanFieldEditor fBasicTraceEnabledGenerationBooleanField;
	private BooleanFieldEditor fBasicTraceEnabledNumerizationBooleanField;
	private BooleanFieldEditor fBasicTraceLifelinesEnabledGenerationBooleanField;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public TestGenerationBasicTraceConfigurationProfile(
			final AbstractConfigurationPage configurationPage)
	{
		super(configurationPage, false);
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
	protected void createContent(final Composite parent, final IWidgetToolkit widgetToolkit) {
		final Group group = widgetToolkit.createGroup(parent,
				"Enabled Options", 3, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceEnabledGenerationBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ENABLED_GENERATION,
						"&Generation", comp,
						DEFAULT_BASIC_TRACE_ENABLED_GENERATION);
		addFieldEditor(fBasicTraceEnabledGenerationBooleanField);

		fBasicTraceEnabledGenerationBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						handleEnablingGeneration();
					}
				});

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceEnabledNumerizationBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ENABLED_NUMERIZATION,
						"&Numerization", comp,
						DEFAULT_BASIC_TRACE_ENABLED_NUMERIZATION);
		addFieldEditor(fBasicTraceEnabledNumerizationBooleanField);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fBasicTraceLifelinesEnabledGenerationBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_LIFELINES_ENABLED_PRINTING,
						"&Print Lifelines", comp,
						DEFAULT_BASIC_TRACE_LIFELINES_ENABLED_PRINTING);
		addFieldEditor(fBasicTraceLifelinesEnabledGenerationBooleanField);

		createBasicConfigurationComponent(parent, widgetToolkit);

		createObservableSelectionComponent(parent, widgetToolkit);
	}

	private void handleEnablingGeneration() {
		fBasicTraceEnabledNumerizationBooleanField.setEnabled(
				fBasicTraceEnabledGenerationBooleanField.getBooleanValue() );

		fBasicTraceLifelinesEnabledGenerationBooleanField.setEnabled(
				fBasicTraceEnabledGenerationBooleanField.getBooleanValue() );

		fConfigurationPage.propagateVisibility(groupBasicConfiguration,
				fBasicTraceEnabledGenerationBooleanField.getBooleanValue() );

		fConfigurationPage.propagateVisibility(groupBasicObservable,
				fBasicTraceEnabledGenerationBooleanField.getBooleanValue() );
	}

	private void createBasicConfigurationComponent(
			final Composite parent, final IWidgetToolkit widgetToolkit) {
		groupBasicConfiguration = widgetToolkit.createGroup(parent,
				"&Configuration", 2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				groupBasicConfiguration, 1, 1, GridData.FILL_HORIZONTAL);

		StringFieldEditor resourceNameStringField =
				new StringFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_FOLDER_NAME, "&Folder : ",
				comp, DEFAULT_BASIC_TRACE_FOLDER_NAME);
		resourceNameStringField.setToolTipText(
				"Folder name w.r.t. <workspace-root>/<output>");
		addFieldEditor(resourceNameStringField);

		comp = widgetToolkit.createComposite(
				groupBasicConfiguration, 1, 1, GridData.FILL_HORIZONTAL);

		resourceNameStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_FILE_NAME, "&File : ",
				comp, DEFAULT_BASIC_TRACE_FILE_NAME);
		resourceNameStringField.setToolTipText("File name");
		addFieldEditor(resourceNameStringField);

		comp = widgetToolkit.createComposite(groupBasicConfiguration,
				1, 1, GridData.FILL_HORIZONTAL);

		BooleanFieldEditor flagBooleanFieldEditor = new BooleanFieldEditor(
				fConfigurationPage, ATTR_BASIC_TRACE_ENABLED_NORMALIZATION,
				"&Normalization (Redundance Elimination...)", comp, true);
		addFieldEditor(flagBooleanFieldEditor);

		comp = widgetToolkit.createComposite(groupBasicConfiguration,
				1, 1, GridData.FILL_HORIZONTAL);

		flagBooleanFieldEditor = new BooleanFieldEditor(
				fConfigurationPage, ATTR_BASIC_TRACE_INITIAL_VALUES_ENABLED_PRINTING,
				"&Print Initial Values", comp, false);
		addFieldEditor(flagBooleanFieldEditor);
	}

	public void createObservableSelectionComponent(
			final Composite parent, final IWidgetToolkit widgetToolkit) {
		groupBasicObservable = widgetToolkit.createGroup(parent,
				"&Observable Traces Selection", 2, 1, GridData.FILL_HORIZONTAL);

		createExternalCommunicationComponent(groupBasicObservable, widgetToolkit);

		createInternalCommunicationComponent(groupBasicObservable, widgetToolkit);

		createOtherObservableComponent(groupBasicObservable, widgetToolkit);

		createTraceElementTableViewerComponent(groupBasicObservable, widgetToolkit);
	}

	private void createExternalCommunicationComponent(
			final Composite parent, final IWidgetToolkit widgetToolkit) {
		final Group group = widgetToolkit.createGroup(parent,
				"External Communication", 2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText(
				"External, Input or Output, Communication Selection" );


		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		BooleanFieldEditor flagBooleanFieldEditor =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION,
						"&Input", comp, true);
		addFieldEditor(flagBooleanFieldEditor);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		flagBooleanFieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION,
				"&Output", comp, true);
		addFieldEditor(flagBooleanFieldEditor);
	}

	private void createInternalCommunicationComponent(
			final Composite parent, final IWidgetToolkit widgetToolkit) {
		final Group group = widgetToolkit.createGroup(parent,
				"&Any Communication", 2, 1, GridData.FILL_HORIZONTAL);
		group.setToolTipText( "External or Internal, "
				+ "Input or Output, Communication Selection" );


		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		BooleanFieldEditor flagBooleanFieldEditor =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_ALL_INPUT_COM_SELECTION,
						"&Input", comp, false);
		addFieldEditor(flagBooleanFieldEditor);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		flagBooleanFieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_ALL_OUTPUT_COM_SELECTION, "&Output", comp, false);
		addFieldEditor(flagBooleanFieldEditor);
	}

	private void createOtherObservableComponent(
			final Composite parent, final IWidgetToolkit widgetToolkit) {
		final Group group = widgetToolkit.createGroup(parent,
				"&Other Elements", 4, 2, GridData.FILL_HORIZONTAL);
		group.setToolTipText( "Other Elements like, Time, Variable, "
				+ "Transition, State..., Communication Selection" );

		Composite comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		BooleanFieldEditor flagBooleanFieldEditor =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_BASIC_TRACE_TIME_SELECTION,
						"&Time", comp, true);
		addFieldEditor(flagBooleanFieldEditor);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		flagBooleanFieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION, "&Variable", comp, false);
		addFieldEditor(flagBooleanFieldEditor);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		flagBooleanFieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION, "&Transition", comp, false);
		addFieldEditor(flagBooleanFieldEditor);


		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		flagBooleanFieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BASIC_TRACE_ALL_STATE_SELECTION, "&State", comp, false);
		addFieldEditor(flagBooleanFieldEditor);
	}


	private TraceElementTableViewer fDetailTraceElementTableViewer;

	private TraceElementTableViewer fFormatTraceElementTableViewer;


	private void createTraceElementTableViewerComponent(
			final Composite parent, final IWidgetToolkit widgetToolkit) {

		final Composite comp = widgetToolkit.createComposite(
				parent, 1, 2, GridData.FILL_HORIZONTAL);

		fDetailTraceElementTableViewer =
			new TraceElementTableViewer(this, comp, 1, widgetToolkit,
				TraceElementTableConfigProvider.getTestGenerationTraceDetail(
						parent.getFont()));
		addTableViewer( fDetailTraceElementTableViewer );

		fFormatTraceElementTableViewer =
			new TraceElementTableViewer(this, comp, 1, widgetToolkit,
				TraceElementTableConfigProvider.getTestGenenrationTraceFormat(
								parent.getFont()));
		addTableViewer( fFormatTraceElementTableViewer );
	}


	@Override
	protected void setDefaultsImpl(final ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_BASIC_TRACE_ENABLED_GENERATION,
				DEFAULT_BASIC_TRACE_ENABLED_GENERATION);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ENABLED_NUMERIZATION,
				DEFAULT_BASIC_TRACE_ENABLED_NUMERIZATION);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_LIFELINES_ENABLED_PRINTING,
				DEFAULT_BASIC_TRACE_LIFELINES_ENABLED_PRINTING);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_FOLDER_NAME, DEFAULT_BASIC_TRACE_FOLDER_NAME);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_FILE_NAME, DEFAULT_BASIC_TRACE_FILE_NAME);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ENABLED_NORMALIZATION, true);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_INITIAL_VALUES_ENABLED_PRINTING, false);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION, true);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION, true);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_INTERNAL_INPUT_COM_SELECTION, true);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_INTERNAL_OUTPUT_COM_SELECTION, true);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_OUTPUT_COM_SELECTION, false);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_TIME_SELECTION, true);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION, false);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION, false);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_ALL_STATE_SELECTION, false);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST,
				DEFAULT_BASIC_TRACE_DETAILS_ELEMENT_LIST);

		configuration.setAttribute(
				ATTR_BASIC_TRACE_FORMAT_ELEMENT_LIST,
				DEFAULT_BASIC_TRACE_FORMAT_ELEMENT_LIST);
	}


	@Override
	protected void initializeFromImpl(final ILaunchConfiguration configuration) {
		handleEnablingGeneration();
	}

	@Override
	protected void performApplyImpl(final ILaunchConfigurationWorkingCopy configuration) {
		//!! NOTHING
	}

	@Override
	protected boolean isValidImpl(final ILaunchConfiguration launchConfig) {
		//!! NOTHING
		return true;
	}

}
