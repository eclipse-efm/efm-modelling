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

package org.eclipse.efm.execution.configuration.common.ui.page.expert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class ExpertConfigurationPage extends AbstractConfigurationPage {

	public Composite fCompositeStack;
	public StackLayout fStackLayout;

	private Group groupExplorationPage;

	// BEHAVIOR SELECTION : HIT OR JUMP
	ExpertBehaviorSelectionConfigurationProfile fBehaviorSelectionPage;

	// TRANSITION COVERAGE
	ExpertTransitionCoverageConfigurationProfile fTransitionCoveragePage;

	public ExpertConfigurationPage(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);
		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage = new ExpertBehaviorSelectionConfigurationProfile(this);

		//  TRANSITION COVERAGE
		fTransitionCoveragePage = new ExpertTransitionCoverageConfigurationProfile(this);
	}


	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		// Stack Composite w.r.t. analysis profile
		fCompositeStack =  widgetToolkit.createComposite(parent, SWT.BORDER);
		fCompositeStack.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		fStackLayout = new StackLayout();
		fCompositeStack.setLayout(fStackLayout);

		// EXPLORATION PAGE
		createExplorationPage(fCompositeStack, widgetToolkit);
		
		fStackLayout.topControl = groupExplorationPage;
		fCompositeStack.layout();

		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage.createControl(fCompositeStack, widgetToolkit);

		// TRANSITION COVERAGE
		fTransitionCoveragePage.createControl(fCompositeStack, widgetToolkit);
	}

	private void setEnableGroupExplorationPage(ILaunchConfiguration configuration) {
		try {
			String modelAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, "");

			setVisibleProfilePage( modelAnalysisProfile );
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void setVisibleProfilePage(AbstractConfigurationProfile aProfilePage) {
		fStackLayout.topControl = aProfilePage.getSection();
		fCompositeStack.layout();
	}

	public void setVisibleProfilePage(String analysisProfile) {
		switch ( analysisProfile ) {
		case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION:
			setVisibleProfilePage( fTransitionCoveragePage );
			break;
		case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR:
			setVisibleProfilePage( fBehaviorSelectionPage );
			break;
			
		case ANALYSIS_PROFILE_MODEL_TEST_OFFLINE:
		case ANALYSIS_PROFILE_MODEL_EXPLORATION:
		default:
			fStackLayout.topControl = groupExplorationPage;
			fCompositeStack.layout();
			break;
		}
	}



	private void createExplorationPage(Composite parent, IWidgetToolkit widgetToolkit) {
		groupExplorationPage = widgetToolkit.createGroup(parent,
				"Exploration Page", 1, 2, GridData.FILL_HORIZONTAL);

        Composite comp = widgetToolkit.createComposite(groupExplorationPage, 1, 1,
        		GridData.FILL_HORIZONTAL);

        widgetToolkit.createLabel(comp, "&No expert mode for Exploration "
        		+ "of Model Analysis and Test Verdict Computation !", 1);
	}

	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {
		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage.setDefaults(configuration);

		// TRANSITION COVERAGE
		fTransitionCoveragePage.setDefaults(configuration);
	}


	@Override
	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		setEnableGroupExplorationPage(configuration);

		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage.initializeFrom(configuration);

		// TRANSITION COVERAGE
		fTransitionCoveragePage.initializeFrom(configuration);
	}


	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage.performApply(configuration);

		// TRANSITION COVERAGE
		fTransitionCoveragePage.performApply(configuration);
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		// BEHAVIOR SELECTION : HIT OR JUMP
		if( ! fBehaviorSelectionPage.isValid(launchConfig) ) {
			return new FieldValidationReturn(false, null);
		}
		
		// TRANSITION COVERAGE
		if( ! fTransitionCoveragePage.isValid(launchConfig) ) {
			return new FieldValidationReturn(false, null);
		}
		
		return new FieldValidationReturn(true, null);
	}

	
	///////////////////////////////////////////////////////////////////////////
	// Model Analysis Profile changed
	//
	@Override
	public void handleModelAnalysisProfileSelectionChanged(String analysisProfile) {
		setVisibleProfilePage(analysisProfile);
	}


}
