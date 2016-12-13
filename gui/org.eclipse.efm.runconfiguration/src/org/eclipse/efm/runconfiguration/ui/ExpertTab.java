/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.runconfiguration.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.runconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.efm.runconfiguration.ui.internal.SWTFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

public class ExpertTab extends AbstractSewLaunchConfigurationTab {

	private String fTabName;

	private Group groupExplorationPage;

	// BEHAVIOR SELECTION : HIT OR JUMP
	ExpertBehaviorSelectionPage fBehaviorSelectionPage;

	// TRANSITION COVERAGE
	ExpertTransitionCoveragePage fTransitionCoveragePage;

	/**
	 * Constructor
	 * @param groupTab
	 */
	public ExpertTab(LaunchConfigurationTabGroup groupTab) {
		super(groupTab);
		setHelpContextId("org.eclipse.efm.runconfiguration.efm_runconf_expert_tab");

		fTabName = "Expert";

		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage = new ExpertBehaviorSelectionPage(this);

		//  TRANSITION COVERAGE
		fTransitionCoveragePage = new ExpertTransitionCoveragePage(this);
	}


	private Composite simpleComposite;


	@Override
	public void createControl(Composite parent) {
		simpleComposite = SWTFactory.createComposite(parent,
				parent.getFont(), 1, 1, GridData.FILL_BOTH, 0, 0);
		setControl(simpleComposite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
				getControl(), getHelpContextId());

		// EXPLORATION PAGE
		createExplorationPage(simpleComposite);

		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage.createControl(simpleComposite);

		// TRANSITION COVERAGE
		fTransitionCoveragePage.createControl(simpleComposite);
	}

	private void setEnableGroupExplorationPage(ILaunchConfiguration configuration) {
		try {
			String fAnalysisProfile = configuration.getAttribute(
					MainTab.ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");

			String fModelAnalysis = configuration.getAttribute(
					MainTab.ATTR_SPECIFICATION_MODEL_ANALYSIS, "");

			visibleAndExclude(groupExplorationPage,
					(fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL)
					&& fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_EXPLORATION)
					) || fAnalysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE) );
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}


	public void createExplorationPage(Composite parent) {
		groupExplorationPage = SWTFactory.createGroup(parent,
				"Exploration Page", 1, 2, GridData.FILL_HORIZONTAL);

        Composite comp = SWTFactory.createComposite(groupExplorationPage, 1, 1,
        		GridData.FILL_HORIZONTAL);

        SWTFactory.createLabel(comp, "&No expert mode for Exploration "
        		+ "of Model Analysis and Test Verdict Computation !", 1);
	}


	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#isValid(ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		// BEHAVIOR SELECTION : HIT OR JUMP
		if( ! fBehaviorSelectionPage.isValid(launchConfig) ) {
			return false;
		}

		// TRANSITION COVERAGE
		if( ! fTransitionCoveragePage.isValid(launchConfig) ) {
			return false;
		}

		return true;
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage.setDefaults(configuration);

		// TRANSITION COVERAGE
		fTransitionCoveragePage.setDefaults(configuration);
	}


	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
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
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		performApplyExploration(configuration);

		// BEHAVIOR SELECTION : HIT OR JUMP
		fBehaviorSelectionPage.performApply(configuration);

		// TRANSITION COVERAGE
		fTransitionCoveragePage.performApply(configuration);
	}

	@Override
	public String getName() {
		return fTabName;
	}

	public void setTabName(String tabName) {
		this.fTabName = tabName;
	}


}
