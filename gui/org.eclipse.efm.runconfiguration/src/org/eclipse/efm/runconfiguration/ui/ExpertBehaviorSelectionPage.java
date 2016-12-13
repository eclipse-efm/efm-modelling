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
package org.eclipse.efm.runconfiguration.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.runconfiguration.ui.internal.SWTFactory;
import org.eclipse.efm.runconfiguration.ui.internal.fieldeditor.BooleanFieldEditor;
import org.eclipse.efm.runconfiguration.ui.internal.fieldeditor.IntegerFieldEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class ExpertBehaviorSelectionPage extends AbstractTabComponentPage {

	// HIT OR JUMP
	//
	private IntegerFieldEditor fHoJBeginStep;

	private BooleanFieldEditor fHoJHeuristic;
	private BooleanFieldEditor fHoJStop;
	private BooleanFieldEditor fHoJSlice;

	private BooleanFieldEditor fHoJLocallySearchScope;

	private BooleanFieldEditor fHoJSchedulerOrdered;
	private BooleanFieldEditor fHoJHitConsecutive;

	private BooleanFieldEditor fHoJHitFolding;
	private BooleanFieldEditor fHoJHitLucky;
	private BooleanFieldEditor fHoJHitMax;
	private BooleanFieldEditor fHoJJumpSlice;

	private IntegerFieldEditor fHoJJumpHeight;
	private IntegerFieldEditor fHoJJumpLimit;
	private IntegerFieldEditor fHoJHitCount;
	private IntegerFieldEditor fHoJJumpCount;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public ExpertBehaviorSelectionPage(
			AbstractSewLaunchConfigurationTab parentTab) {
		super(parentTab);
	}


	@Override
	public void createControl(Composite parent) {
		fCompositeParent = parent;

		fCompositeControl = SWTFactory.createGroup(fCompositeParent,
				"Behavior Selection Page", 1, 2, GridData.FILL_HORIZONTAL);

		Group groupHoJProperty = SWTFactory.createGroup(fCompositeControl,
				"Section PROPERTY", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp1 = SWTFactory.createComposite(groupHoJProperty, 1, 1,
				GridData.FILL_HORIZONTAL);

		fHoJBeginStep = new IntegerFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_BEGIN_STEP,
				"&Begin Step:", comp1, 0);
		fHoJBeginStep.setToolTipText("Number of \"cumulated\" steps "
				+ "before begining the research of the behavior");

		Group groupCommon = SWTFactory.createGroup(groupHoJProperty,
				"&Common", 3, 2, GridData.FILL_HORIZONTAL);

		Composite compCommon = SWTFactory.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJHeuristic = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_HEURISTIC,
				"&Heuristic", compCommon, true);
		fHoJHeuristic.setToolTipText("Activate the use of heuristics");

		compCommon = SWTFactory.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJStop = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_STOP, "&Stop", compCommon, true);
		fHoJStop.setToolTipText("Stop the symbolic excution "
				+ "as soon as the behavior is covered");

		compCommon = SWTFactory.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJSlice = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_SLICE, "&Slice", compCommon, true);
		fHoJSlice.setToolTipText("Pruning the symbolic execution graph "
				+ "at the end of the analysis");


		Group groupScope = SWTFactory.createGroup(groupHoJProperty,
				"&Search Scope", 2, 2, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				groupScope, 1, 1, GridData.FILL_HORIZONTAL);

		fHoJLocallySearchScope = new BooleanFieldEditor(
				fParentTab, ATTR_BEHAVIOR_SELECTION_HOJ_SEARCH_SCOPE_LOCALLY,
				"&Search Locally scope instead Globally", comp, false);

		Group groupScheduler = SWTFactory.createGroup(groupHoJProperty,
				"&Scheduler", 2, 2, GridData.FILL_HORIZONTAL);

		Composite compScheduler = SWTFactory.createComposite(
				groupScheduler, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJSchedulerOrdered = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED,
				"&Ordered", compScheduler, true);
		fHoJSchedulerOrdered.setToolTipText("Search ordered traces");

		compScheduler = SWTFactory.createComposite(
				groupScheduler, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJHitConsecutive = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE,
				"&Consecutive", compScheduler, false);
		fHoJHitConsecutive.setToolTipText(
				"Search ordered traces with consecutive observables");


		Group groupOption = SWTFactory.createGroup(groupHoJProperty,
				"&Options", 4, 2, GridData.FILL_HORIZONTAL);

		Composite compOption = SWTFactory.createComposite(
				groupOption, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJHitFolding = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_FOLDING,
				"&Folding", compOption, true);
		fHoJHitFolding.setToolTipText(
				"Enabled checking many trace point in one context");

		compOption = SWTFactory.createComposite(
				groupOption, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJHitLucky = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_LUCKY,
				"&Lucky", compOption, false);
		fHoJHitLucky.setToolTipText(
				"Search one trace in a lucky way - no backtracking");

		compOption = SWTFactory.createComposite(
				groupOption, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJHitMax = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_MAX,
				"&Maximun Trace", compOption, false);
		fHoJHitMax.setToolTipText("Search a maximun trace");

		compOption = SWTFactory.createComposite(
				groupOption, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJJumpSlice = new BooleanFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_SLICE,
				"&Jump Slice", compOption, false);
		fHoJJumpSlice.setToolTipText(
				"Pruning intermediate at the end of hit or jump");


		Group groupHoJHeuristic = SWTFactory.createGroup(fCompositeControl,
				"Section HEURISTIC", 1, 1, GridData.FILL_HORIZONTAL);

		Composite compHeuristic = SWTFactory.createComposite(
				groupHoJHeuristic, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJJumpHeight = new IntegerFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT,
				"&Jump Height:", compHeuristic, 6);

		fHoJJumpLimit = new IntegerFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT,
				"&Jump Trials Limit:", compHeuristic, -1);

		fHoJHitCount = new IntegerFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT,
				"&Hit Count:", compHeuristic, 1);

		fHoJJumpCount = new IntegerFieldEditor(fParentTab,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT,
				"&Jump Count:", compHeuristic, 1);
	}


	private void setEnableGroupHOJPage(ILaunchConfiguration configuration) {
		String fAnalysisProfile;
		String fModelAnalysis;
		try {
			fAnalysisProfile = configuration.getAttribute(
					MainTab.ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");
			fModelAnalysis = configuration.getAttribute(
					MainTab.ATTR_SPECIFICATION_MODEL_ANALYSIS, "");

			setVisible(fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL)
					&& fModelAnalysis.equals(
							ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) );
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
//		fHoJBeginStep.setDefaults(configuration);
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_BEGIN_STEP, 0);

//		fHoJHeuristic.setDefaults(configuration);
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_HEURISTIC, true);

//		fHoJStop.setDefaults(configuration);
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_STOP, true);

//		fHoJSlice.setDefaults(configuration);
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_SLICE, true);

//		fHoJLocallySearchScope.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_SEARCH_SCOPE_LOCALLY, false);

//		fHoJSchedulerOrdered.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED, true);

//		fHoJHitConsecutive.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE, false);

//		fHoJHitFolding.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_FOLDING, true);

//		fHoJHitLucky.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_LUCKY, false);

//		fHoJHitMax.setDefaults(configuration);
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_HIT_MAX, false);

//		fHoJJumpSlice.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_SLICE, false);

//		fHoJJumpHeight.setDefaults(configuration);
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT, 6);

//		fHoJJumpLimit.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT, -1);

//		fHoJHitCount.setDefaults(configuration);
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT, 1);

//		fHoJJumpCount.setDefaults(configuration);
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT, 1);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		setEnableGroupHOJPage(configuration);

		fHoJBeginStep.initializeFrom(configuration);
		fHoJHeuristic.initializeFrom(configuration);
		fHoJStop.initializeFrom(configuration);
		fHoJSlice.initializeFrom(configuration);

		fHoJLocallySearchScope.initializeFrom(configuration);

		fHoJSchedulerOrdered.initializeFrom(configuration);
		fHoJHitConsecutive.initializeFrom(configuration);

		fHoJHitFolding.initializeFrom(configuration);
		fHoJHitLucky.initializeFrom(configuration);
		fHoJHitMax.initializeFrom(configuration);
		fHoJJumpSlice.initializeFrom(configuration);

		fHoJJumpHeight.initializeFrom(configuration);
		fHoJJumpLimit.initializeFrom(configuration);
		fHoJHitCount.initializeFrom(configuration);
		fHoJJumpCount.initializeFrom(configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		setEnableGroupHOJPage(configuration);

		fHoJBeginStep.performApply(configuration);
		fHoJHeuristic.performApply(configuration);
		fHoJStop.performApply(configuration);
		fHoJSlice.performApply(configuration);

		fHoJLocallySearchScope.performApply(configuration);

		fHoJSchedulerOrdered.performApply(configuration);
		fHoJHitConsecutive.performApply(configuration);

		fHoJHitFolding.performApply(configuration);
		fHoJHitLucky.performApply(configuration);
		fHoJHitMax.performApply(configuration);
		fHoJJumpSlice.performApply(configuration);

		fHoJJumpHeight.performApply(configuration);
		fHoJJumpLimit.performApply(configuration);
		fHoJHitCount.performApply(configuration);
		fHoJJumpCount.performApply(configuration);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if( ! fHoJBeginStep.isValid() ) {
			setErrorMessage("Begin Step is not a valid integer");
			return false;
		}
		if( ! fHoJJumpHeight.isValid() ) {
			setErrorMessage("Jump Height is not a valid integer");
			return false;
		}
		if( ! fHoJJumpLimit.isValid() ) {
			setErrorMessage("Jump Limit is not a valid integer");
			return false;
		}
		if( ! fHoJHitCount.isValid() ) {
			setErrorMessage("Hit Count is not a valid integer");
			return false;
		}
		if( ! fHoJJumpCount.isValid() ) {
			setErrorMessage("Jump Count is not a valid integer");
			return false;
		}

		return true;
	}

}
