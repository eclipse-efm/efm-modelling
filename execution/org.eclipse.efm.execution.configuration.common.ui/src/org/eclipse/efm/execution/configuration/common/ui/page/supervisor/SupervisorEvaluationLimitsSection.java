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

package org.eclipse.efm.execution.configuration.common.ui.page.supervisor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationSection;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class SupervisorEvaluationLimitsSection extends AbstractConfigurationSection {

	
	public SupervisorEvaluationLimitsSection(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Evaluation limits";
	}


	@Override
	public String getSectionDescription() {
		return "Evaluation limits: max step count or timeout";
	}


	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		IntegerFieldEditor integerField = new IntegerFieldEditor(fConfigurationPage,
				ATTR_SPECIFICATION_STOP_CRITERIA_STEPS,
				"&Symbex Step Count :", parent, 1000);
		integerField.setToolTipText("Maximal symbex step (possibly many evaluations by step)"
				+ " (-1 <=> no-limit) during the dynamic process");
		addField( integerField );

		integerField = new IntegerFieldEditor(fConfigurationPage,
				ATTR_SPECIFICATION_STOP_CRITERIA_EVALS,
				"&Symbex Eval Count :", parent, 1000);
		integerField.setToolTipText("Maximal symbex evaluation count"
				+ " (-1 <=> no-limit) during the dynamic process");
		addField( integerField );

		integerField = new IntegerFieldEditor(fConfigurationPage,
				ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT,
				"&Timeout (seconds) :", parent, -1);
		integerField.setToolTipText("Maximal duration "
				+ "(-1 <=> no-limit) of the symbex dynamic process");
		addField( integerField );

		integerField.setEnabled(false);
	}


	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_NODE, -1);

		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH, -1);

		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT, -1);

    	String fModelAnalysis;
		try {
			fModelAnalysis = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, "");
		}
		catch (CoreException e) {
			e.printStackTrace();
			
			fModelAnalysis = "";
		}

		if ( fModelAnalysis.equals(
				ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
		{
			configuration.setAttribute(
					ATTR_SPECIFICATION_STOP_CRITERIA_STEPS, -1);
			configuration.setAttribute(
					ATTR_SPECIFICATION_STOP_CRITERIA_EVALS, -1);
		}
		else {
			configuration.setAttribute(
					ATTR_SPECIFICATION_STOP_CRITERIA_STEPS, 1000);
			configuration.setAttribute(
					ATTR_SPECIFICATION_STOP_CRITERIA_EVALS, 1000);
		}

		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT, -1);
	}


	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration) {
		//!! NOTHING
	}


	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		//!! NOTHING
	}


	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		return( true );
	}


}
