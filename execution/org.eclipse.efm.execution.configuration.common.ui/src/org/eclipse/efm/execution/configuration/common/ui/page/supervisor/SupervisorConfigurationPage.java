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

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.swt.widgets.Composite;

public class SupervisorConfigurationPage extends AbstractConfigurationPage {

	private SupervisorGraphSizeLimitsSection  fGraphSizeLimitsSection;

	private SupervisorEvaluationLimitsSection fEvaluationLimitsSection;


	public SupervisorConfigurationPage(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);

		fGraphSizeLimitsSection  = new SupervisorGraphSizeLimitsSection(this);

		fEvaluationLimitsSection = new SupervisorEvaluationLimitsSection(this);
	}

	@Override
	public String getSectionTitle() {
		return "Supervisor";
	}

	@Override
	public String getSectionDescription() {
		return "Supervisor";
	}


	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		fGraphSizeLimitsSection.createControl(parent, widgetToolkit);

		fEvaluationLimitsSection.createControl(parent, widgetToolkit);
	}



	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		fGraphSizeLimitsSection.setDefaults(configuration);

		fEvaluationLimitsSection.setDefaults(configuration);
	}

	@Override
	public void initializeFromImpl(ILaunchConfiguration configuration) {
		fGraphSizeLimitsSection.initializeFrom(configuration);

		fEvaluationLimitsSection.initializeFrom(configuration);
	}


	@Override
	public void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		fGraphSizeLimitsSection.performApply(configuration);

		fEvaluationLimitsSection.performApply(configuration);
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValidImpl(ILaunchConfiguration launchConfig) {
		if( ! fGraphSizeLimitsSection.isValid(launchConfig) ) {
			return new FieldValidationReturn(false, null);
		}

		if( ! fEvaluationLimitsSection.isValid(launchConfig) ) {
			return new FieldValidationReturn(false, null);
		}

		return new FieldValidationReturn(true, null);
	}

}
