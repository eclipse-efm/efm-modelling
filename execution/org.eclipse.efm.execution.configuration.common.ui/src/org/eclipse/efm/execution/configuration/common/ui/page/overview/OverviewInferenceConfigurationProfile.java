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
package org.eclipse.efm.execution.configuration.common.ui.page.overview;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableConfigProvider;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class OverviewInferenceConfigurationProfile extends AbstractConfigurationProfile {

	private TraceElementTableViewer fTraceElementTableViewer;

//	private StringFieldEditor fInferenceStringField;

	private StringFieldEditor fOutputFileStringField;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewInferenceConfigurationProfile(
			AbstractConfigurationPage configurationPage)
	{
		super(configurationPage, false);
	}


	@Override
	public String getSectionTitle() {
		return "Properties Inference";
	}

	@Override
	public String getSectionDescription() {
		return "Properties Inference, configuration section";
	}


	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit) {
		parent.setToolTipText(BEHAVIOR_DESCRIPTION);

		// Trace Sequence
		fTraceElementTableViewer = new TraceElementTableViewer(this, parent, 2, widgetToolkit,
				TraceElementTableConfigProvider.getInferenceSelection(parent.getFont()));

		addTableViewer(fTraceElementTableViewer);

//		fInferenceStringField = new StringFieldEditor(fConfigurationPage,
//				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST, "",
//				parent, BEHAVIOR_DESCRIPTION, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
//		fInferenceStringField.setToolTipText(BEHAVIOR_DESCRIPTION);
//		addFieldEditor(fInferenceStringField);

		// output file
		Group group = widgetToolkit.createGroup(parent,
				"&Output File ", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fOutputFileStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_INFERENCE_OUTPUT_FILE_NAME, "File name", comp, "acslSpec.c");
		fOutputFileStringField.setToolTipText("Select the output file");
		addFieldEditor(fOutputFileStringField);
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_INFERENCE_ANALYSIS_ELEMENT_NAME_LIST,
				BEHAVIOR_INITIAL_SAMPLE);
	}


	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration) {
		//!! NOTHING
	}

	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ATTR_INFERENCE_SELECTION_HOJ_JUMP_HEIGHT, 3);
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		if( ! fTraceElementTableViewer.isValid( launchConfig ) ) {
			return false;
		}

		String outputFile = fOutputFileStringField.getStringValue();
		if( (outputFile == null) || outputFile.isEmpty() ) {
			return false;
		}

		return true;
	}


}
