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
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.util.SWTFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class ExpertConfigurationPage extends AbstractConfigurationPage {

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
	public void createTabItemContent(Composite parentComposite) {
//		inner_main_composite = SWTFactory.createComposite(parent,
//				parent.getFont(), 1, 1, GridData.FILL_BOTH, 0, 0);

		// EXPLORATION PAGE
		createExplorationPage(parentComposite);

		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage.createPageWithToolkit(parentComposite);

		// TRANSITION COVERAGE
		fTransitionCoveragePage.createPageWithToolkit(parentComposite);
	}

	private void setEnableGroupExplorationPage(ILaunchConfiguration configuration) {
		try {
			String fAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");

			String fModelAnalysis = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS, "");

			propagateVisibility(groupExplorationPage,
					(fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL)
					&& fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_EXPLORATION)
					) || fAnalysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE) );
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void createExplorationPage(Composite parent) {
		groupExplorationPage = SWTFactory.createGroup(parent,
				"Exploration Page", 1, 2, GridData.FILL_HORIZONTAL);

        Composite comp = SWTFactory.createComposite(groupExplorationPage, 1, 1,
        		GridData.FILL_HORIZONTAL);

        SWTFactory.createLabel(comp, "&No expert mode for Exploration "
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

	public void performApplyExploration(
			ILaunchConfigurationWorkingCopy configuration) {
		setEnableGroupExplorationPage(configuration);
	}


	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		performApplyExploration(configuration);

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

}
