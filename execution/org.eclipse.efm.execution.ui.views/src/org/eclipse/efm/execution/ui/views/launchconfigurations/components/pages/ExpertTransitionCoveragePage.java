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
package org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.ui.views.editors.impls.BooleanFieldEditor;
import org.eclipse.efm.execution.ui.views.editors.impls.IntegerFieldEditor;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationEditorComposite;
import org.eclipse.efm.execution.ui.views.utils.SWTFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class ExpertTransitionCoveragePage extends AbstractTabComponentPage {

	private static final String SCOPE_COMBO_ITEM_INSTANCE = "INSTANCE";
	private static final String SCOPE_COMBO_ITEM_MODEL = "MODEL";
	private static final String SCOPE_COMBO_ITEM_DETAILS = "DETAILS";
	private static final String[] SCOPE_COMBO_ITEMS = new String[] {
			SCOPE_COMBO_ITEM_INSTANCE ,
			SCOPE_COMBO_ITEM_MODEL ,
			SCOPE_COMBO_ITEM_DETAILS
	};
	private static final String HEURISTIC_START_COMBO_ITEM_BASIC = "BASIC";
	private static final String HEURISTIC_START_COMBO_ITEM_NAIVE = "NAIVE";
	private static final String HEURISTIC_START_COMBO_ITEM_SMART = "SMART";
	private static final String HEURISTIC_START_COMBO_ITEM_AGRESSIVE = "AGRESSIVE";
	private static final String[] HEURISTIC_START_COMBO_ITEMS = new String[] {
			HEURISTIC_START_COMBO_ITEM_BASIC ,
			HEURISTIC_START_COMBO_ITEM_NAIVE ,
			HEURISTIC_START_COMBO_ITEM_SMART ,
			HEURISTIC_START_COMBO_ITEM_AGRESSIVE
	};

	private static final String DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_BASIC = "BASIC";
	private static final String DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_NAIVE = "NAIVE";
	private static final String DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_SMART = "SMART";
	private static final String DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_AGRESSIVE = "AGRESSIVE";
	private static final String[] DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEMS = new String[] {
			DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_BASIC ,
			DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_NAIVE ,
			DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_SMART ,
			DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_AGRESSIVE
	};


	// TRANSITION COVERAGE - section PROPERTY
	//
	private IntegerFieldEditor fTCBeginStep;
	private BooleanFieldEditor fTCStop;
	private BooleanFieldEditor fTCMinimize;
	private BooleanFieldEditor fTCSlice;
	private BooleanFieldEditor fTCHeuristic;
	private Combo fTCScopeCombo = null;
	private String fTCScope = SCOPE_COMBO_ITEM_MODEL;

	// TRANSITION COVERAGE - section HEURISTIC
	//
	private Combo fTCHeuristicStartCombo = null;
	private String fTCHeuristicStart =
			DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_BASIC;
	private IntegerFieldEditor fTCHeuristicTrials;
	private IntegerFieldEditor fTCObjectiveRate;
	private IntegerFieldEditor fTCObjectiveRest;
	private Combo fTCDirectiveTraceHeuristicCombo = null;
	private String fTCDirectiveTraceHeuristic =
			DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_SMART;
	private IntegerFieldEditor fTCDirectiveTraceCountLimit;
	private IntegerFieldEditor fTCDirectiveTraceSizeLimit;
	private IntegerFieldEditor fTCCoverageHeight;
	private IntegerFieldEditor fTCCoverageHeightReachedLimit;
	private BooleanFieldEditor fTCHitStronglyRandom;
	private IntegerFieldEditor fTCHitStronglyCount;
	private BooleanFieldEditor fTCHitWeaklyRandom;
	private IntegerFieldEditor fTCHitWeaklyCount;
	private BooleanFieldEditor fTCHitOtherRandom;
	private IntegerFieldEditor fTCHitOtherCount;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public ExpertTransitionCoveragePage(
			ILaunchConfigurationEditorComposite parentTab) {
		super(parentTab);
	}


	private class TabListener extends SelectionAdapter implements ModifyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		@Override
		public void modifyText(ModifyEvent e) {
			fParentTab.propagateGUIupdate();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() == fTCScopeCombo) {
				handleScopeSelectionChange();
			}
			else if (e.getSource() == fTCHeuristicStartCombo) {
				handleHeuristicStartSelectionChange();
			}
			else if (e.getSource() == fTCDirectiveTraceHeuristicCombo) {
				handleDirectiveTraceHeuristicSelectionChange();
			}
		}
	}

	private TabListener fListener= new TabListener();


	private void handleScopeSelectionChange() {
		fTCScope = fTCScopeCombo.getText();
		fParentTab.propagateGUIupdate();
	}

	private void handleHeuristicStartSelectionChange() {
		fTCHeuristicStart = fTCHeuristicStartCombo.getText();
		fParentTab.propagateGUIupdate();
	}

	private void handleDirectiveTraceHeuristicSelectionChange() {
		fTCDirectiveTraceHeuristic = fTCDirectiveTraceHeuristicCombo.getText();
		fParentTab.propagateGUIupdate();
	}


	@Override
	public void createControl(Composite parent) {
		fCompositeParent = parent;

		fCompositeControl = SWTFactory.createGroup(parent,
				"Transition Coverage Page", 1, 2, GridData.FILL_HORIZONTAL);

		// TRANSITION COVERAGE - section PROPERTY
		//
		Group groupTCProperty = SWTFactory.createGroup(
				fCompositeControl, "Section PROPERTY",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				groupTCProperty, 1, 1, GridData.FILL_HORIZONTAL);
//				GridData.HORIZONTAL_ALIGN_BEGINNING);
		fTCBeginStep = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_BEGIN_STEP,
				"&Begin Step:", comp, 0);
		fTCBeginStep.setToolTipText("Number of \"cumulated\" steps "
				+ "before begining the verification cover");
		fTCBeginStep.setEnabled(false);

		Group groupCommon = SWTFactory.createGroup(groupTCProperty,
				"&Common Coverage Configuration",
				4, 2, GridData.FILL_HORIZONTAL);

		Composite compCommon = SWTFactory.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fTCHeuristic = new BooleanFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_HEURISTIC,
				"&Heuristic", compCommon, true);
		fTCHeuristic.setToolTipText("Activate the use of heuristics");

		compCommon = SWTFactory.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fTCStop = new BooleanFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_STOP, "&Stop", compCommon, true);
		fTCStop.setToolTipText("Stop the symbolic excution "
				+ "as soon as the coverage is completed");

		compCommon = SWTFactory.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fTCSlice = new BooleanFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_SLICE, "&Slice", compCommon, true);
		fTCSlice.setToolTipText("Pruning symbolic execution "
				+ "graph at the end of the analysis");

		compCommon = SWTFactory.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fTCMinimize = new BooleanFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_MINIMIZE,
				"&Minimize", compCommon, true);
		fTCMinimize.setToolTipText(
				"Stop the symbolic execution at the earliest");


		Composite comp3 = SWTFactory.createComposite(
				groupTCProperty, 2, 1, GridData.FILL_HORIZONTAL);
		SWTFactory.createLabel(comp3, "&Scope:", 1);
		fTCScopeCombo = SWTFactory.createCombo(comp3,
				SWT.DROP_DOWN | SWT.READ_ONLY, 1, SCOPE_COMBO_ITEMS);
		fTCScopeCombo.addSelectionListener(fListener);

		// TRANSITION COVERAGE - section HEURISTIC
		//
		Group groupTCHeuristic = SWTFactory.createGroup(
				fCompositeControl,
				"First Heuristic Configuration",
				2, 1, GridData.FILL_HORIZONTAL);

		Group group = SWTFactory.createGroup(groupTCHeuristic,
				"&Configuration", 1, 1, GridData.FILL_HORIZONTAL);

		comp = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		SWTFactory.createLabel(comp, "&Start:", 1);
		fTCHeuristicStartCombo = SWTFactory.createCombo(
				comp, SWT.DROP_DOWN | SWT.READ_ONLY,
				1, HEURISTIC_START_COMBO_ITEMS);
		fTCHeuristicStartCombo.addSelectionListener(fListener);

		fTCHeuristicTrials = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_HEURISTIC_TRIALS, "&Trials:", comp, -1);
		fTCHeuristicTrials.widthInChars = 10;
		//fTCHeuristicTrials.setTextLimit(20);


		group = SWTFactory.createGroup(groupTCHeuristic,
				"&Target Objective", 1, 1, GridData.FILL_HORIZONTAL);

		comp = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTCObjectiveRate = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_OBJECTIVE_RATE, "&Rate:", comp, 100);
		//fTCObjectiveRate.widthInChars = 3;
		fTCObjectiveRate.setTextLimit(3);

		fTCObjectiveRest = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_OBJECTIVE_REST, "&Rest:", comp, 0);
		//fTCObjectiveRest.widthInChars = 3;
		fTCObjectiveRest.setTextLimit(3);


		group = SWTFactory.createGroup(groupTCHeuristic,
				"&Lookahead Scope", 1, 2, GridData.FILL_HORIZONTAL);

		comp = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTCCoverageHeight = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_LOOKAHEAD_DEPTH, "&Depth:", comp, 7);

		fTCCoverageHeightReachedLimit = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_LOOKAHEAD_WIDTH, "&Width:", comp, 42);


		Group groupStrategy = SWTFactory.createGroup(groupTCHeuristic,
				"Strategy of Selection of Contexts in the Queue w.r.t. "
				+ "the number of Fireable transitions",
				3, 2, GridData.FILL_HORIZONTAL);


		group = SWTFactory.createGroup(groupStrategy,
				"&Strongly Fireable Transition Selection",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite compGroup = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		comp = SWTFactory.createComposite(
				compGroup, 1, 2, GridData.FILL_HORIZONTAL);

		fTCHitStronglyRandom = new BooleanFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_RANDOM,
				"&Hit Random", comp, false);

		fTCHitStronglyCount = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_COUNT,
				"&Hit Count:", compGroup, 1);


		group = SWTFactory.createGroup(groupStrategy,
				"&Weakly Fireable Transition Selection",
				1, 1, GridData.FILL_HORIZONTAL);

		compGroup = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		comp = SWTFactory.createComposite(
				compGroup, 1, 2, GridData.FILL_HORIZONTAL);

		fTCHitWeaklyRandom = new BooleanFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_RANDOM,
				"&Hit Random", comp, false);

		fTCHitWeaklyCount = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_COUNT,
				"&Hit Count:", compGroup, 1);


		group = SWTFactory.createGroup(groupStrategy,
				"&Other Fireable Transition Selection",
				1, 1, GridData.FILL_HORIZONTAL);

		compGroup = SWTFactory.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		comp = SWTFactory.createComposite(
				compGroup, 1, 2, GridData.FILL_HORIZONTAL);

		fTCHitOtherRandom = new BooleanFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_HIT_OTHER_RANDOM,
				"&Hit Random", comp, false);

		fTCHitOtherCount = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_HIT_OTHER_COUNT,
				"&Hit Count:", compGroup, 1);


		groupTCHeuristic = SWTFactory.createGroup(
				fCompositeControl,
				"Second Heuristic Configuration",
				2, 1, GridData.FILL_HORIZONTAL);

		group = SWTFactory.createGroup(groupTCHeuristic,
				"&Directive Trace: Strategy & Limit",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = SWTFactory.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		SWTFactory.createLabel(comp, "&Heuristic:", 1);
		fTCDirectiveTraceHeuristicCombo = SWTFactory.createCombo(
				comp, SWT.DROP_DOWN | SWT.READ_ONLY, 1,
				DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEMS);
		fTCDirectiveTraceHeuristicCombo.addSelectionListener(fListener);

		fTCDirectiveTraceCountLimit = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_COUNT_LIMIT,
				"&Count:", comp, 8);

		fTCDirectiveTraceSizeLimit = new IntegerFieldEditor(fParentTab,
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_SIZE_LIMIT,
				"&Size:", comp, 8);
	}


	private void setEnableGroupTCPage(ILaunchConfiguration configuration) {
		String fAnalysisProfile;
		String fModelAnalysis;
		try {
			fAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");
			fModelAnalysis = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS, "");

			setVisible(fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL)
					&& fModelAnalysis.equals(
							ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) );
		}
		catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
//		fTCBeginStep.setDefaults(configuration);
		configuration.setAttribute(ATTR_TRANSITION_COVERAGE_BEGIN_STEP, 0);

//		fTCStop.setDefaults(configuration);
		configuration.setAttribute(ATTR_TRANSITION_COVERAGE_STOP, true);

//		fTCMinimize.setDefaults(configuration);
		configuration.setAttribute(ATTR_TRANSITION_COVERAGE_MINIMIZE, true);

//		fTCSlice.setDefaults(configuration);
		configuration.setAttribute(ATTR_TRANSITION_COVERAGE_SLICE, true);

//		fTCHeuristic.setDefaults(configuration);
		configuration.setAttribute(ATTR_TRANSITION_COVERAGE_HEURISTIC, true);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SCOPE, SCOPE_COMBO_ITEM_MODEL);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HEURISTIC_START, "BASIC");

//		fTCHeuristicTrials.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HEURISTIC_TRIALS, -1);

//		fTCObjectiveRate.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_OBJECTIVE_RATE, 100);

//		fTCObjectiveRest.setDefaults(configuration);
		configuration.setAttribute(ATTR_TRANSITION_COVERAGE_OBJECTIVE_REST, 0);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC, "SMART");

//		fTCDirectiveTraceCountLimit.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_COUNT_LIMIT, 8);

//		fTCDirectiveTraceSizeLimit.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_SIZE_LIMIT, 8);

//		fTCCoverageHeight.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_LOOKAHEAD_DEPTH, 7);

//		fTCCoverageHeightReachedLimit.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_LOOKAHEAD_WIDTH, 42);

//		fTCHitStronglyRandom.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_RANDOM, false);

//		fTCHitStronglyCount.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_COUNT, 1);

//		fTCHitWeaklyRandom.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_RANDOM, false);

//		fTCHitWeaklyCount.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_COUNT, 1);

//		fTCHitOtherRandom.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HIT_OTHER_RANDOM, false);

//		fTCHitOtherCount.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HIT_OTHER_COUNT, 1);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		setEnableGroupTCPage(configuration);

		fTCBeginStep.initializeFrom(configuration);
		fTCStop.initializeFrom(configuration);
		fTCMinimize.initializeFrom(configuration);
		fTCSlice.initializeFrom(configuration);
		fTCHeuristic.initializeFrom(configuration);

		try {
			fTCScope = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_SCOPE, SCOPE_COMBO_ITEM_MODEL);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}

		switch ( fTCScope ) {
		case SCOPE_COMBO_ITEM_INSTANCE:
			fTCScopeCombo.select(0);
			break;
		case SCOPE_COMBO_ITEM_MODEL:
			fTCScopeCombo.select(1);
			break;
		default:
			fTCScopeCombo.select(0);
			break;
		}


		try {
			fTCHeuristicStart = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_HEURISTIC_START,
					HEURISTIC_START_COMBO_ITEM_BASIC);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}

		switch ( fTCHeuristicStart ) {
		case HEURISTIC_START_COMBO_ITEM_BASIC:
			fTCHeuristicStartCombo.select(0);
			break;
		case HEURISTIC_START_COMBO_ITEM_NAIVE:
			fTCHeuristicStartCombo.select(1);
			break;
		case HEURISTIC_START_COMBO_ITEM_SMART:
			fTCHeuristicStartCombo.select(2);
			break;
		case HEURISTIC_START_COMBO_ITEM_AGRESSIVE:
			fTCHeuristicStartCombo.select(3);
			break;
		default:
			fTCHeuristicStartCombo.select(0);
			break;
		}

		fTCHeuristicTrials.initializeFrom(configuration);
		fTCObjectiveRate.initializeFrom(configuration);
		fTCObjectiveRest.initializeFrom(configuration);

		try {
			fTCDirectiveTraceHeuristic = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC,
					DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_SMART);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch ( fTCDirectiveTraceHeuristic ) {
		case DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_BASIC:
			fTCDirectiveTraceHeuristicCombo.select(0);
			break;
		case DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_NAIVE:
			fTCDirectiveTraceHeuristicCombo.select(1);
			break;
		case DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_SMART:
			fTCDirectiveTraceHeuristicCombo.select(2);
			break;
		case DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_AGRESSIVE:
			fTCDirectiveTraceHeuristicCombo.select(3);
			break;
		default:
			fTCDirectiveTraceHeuristicCombo.select(0);
			break;
		}

		fTCDirectiveTraceCountLimit.initializeFrom(configuration);
		fTCDirectiveTraceSizeLimit.initializeFrom(configuration);
		fTCCoverageHeight.initializeFrom(configuration);
		fTCCoverageHeightReachedLimit.initializeFrom(configuration);
		fTCHitStronglyRandom.initializeFrom(configuration);
		fTCHitStronglyCount.initializeFrom(configuration);
		fTCHitWeaklyRandom.initializeFrom(configuration);
		fTCHitWeaklyCount.initializeFrom(configuration);
		fTCHitOtherRandom.initializeFrom(configuration);
		fTCHitOtherCount.initializeFrom(configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		setEnableGroupTCPage(configuration);

		fTCBeginStep.performApply(configuration);
		fTCStop.performApply(configuration);
		fTCMinimize.performApply(configuration);
		fTCSlice.performApply(configuration);
		fTCHeuristic.performApply(configuration);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SCOPE, fTCScope);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HEURISTIC_START, fTCHeuristicStart);

		fTCHeuristicTrials.performApply(configuration);
		fTCObjectiveRate.performApply(configuration);
		fTCObjectiveRest.performApply(configuration);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC,
				fTCDirectiveTraceHeuristic);

		fTCDirectiveTraceCountLimit.performApply(configuration);
		fTCDirectiveTraceSizeLimit.performApply(configuration);
		fTCCoverageHeight.performApply(configuration);
		fTCCoverageHeightReachedLimit.performApply(configuration);
		fTCHitStronglyRandom.performApply(configuration);
		fTCHitStronglyCount.performApply(configuration);
		fTCHitWeaklyRandom.performApply(configuration);
		fTCHitWeaklyCount.performApply(configuration);
		fTCHitOtherRandom.performApply(configuration);
		fTCHitOtherCount.performApply(configuration);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if( ! fTCBeginStep.isValid() ) {
			setErrorMessage("Begin Step is not a valid integer");
			return false;
		}
		if( ! fTCHeuristicTrials.isValid() ) {
			setErrorMessage("Heuristic Trials is not a valid integer");
			return false;
		}
		if( ! fTCObjectiveRate.isValid() ) {
			setErrorMessage("Objective Rate is not a valid integer");
			return false;
		}
		if( ! fTCObjectiveRest.isValid() ) {
			setErrorMessage("Objective Rest is not a valid integer");
			return false;
		}
		if( ! fTCDirectiveTraceCountLimit.isValid() ) {
			setErrorMessage("Directive Trace Count Limit is not a valid integer");
			return false;
		}
		if( ! fTCDirectiveTraceSizeLimit.isValid() ) {
			setErrorMessage("Directive Trace Size Limit is not a valid integer");
			return false;
		}
		if( ! fTCCoverageHeight.isValid() ) {
			setErrorMessage("Coverage Height is not a valid integer");
			return false;
		}
		if( ! fTCCoverageHeightReachedLimit.isValid() ) {
			setErrorMessage("Coverage Height Reached Limit is not a valid integer");
			return false;
		}
		if( ! fTCHitStronglyCount.isValid() ) {
			setErrorMessage("Hit Strongly Count is not a valid integer");
			return false;
		}
		if( ! fTCHitWeaklyCount.isValid() ) {
			setErrorMessage("Hit Weakly Count is not a valid integer");
			return false;
		}
		if( ! fTCHitOtherCount.isValid() ) {
			setErrorMessage("Hit Other Count is not a valid integer");
			return false;
		}

		return true;
	}

}
