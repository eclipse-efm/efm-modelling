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
package org.eclipse.efm.execution.configuration.common.ui.page.expert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
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

public class ExpertTransitionCoverageConfigurationProfile extends AbstractConfigurationProfile {

	public static final String SCOPE_COMBO_ITEM_MODEL = "MODEL";
	public static final String SCOPE_COMBO_ITEM_INSTANCE = "INSTANCE";
	public static final String SCOPE_COMBO_ITEM_DETAILS = "DETAILS";
	public static final String[] SCOPE_COMBO_ITEMS = new String[] {
			SCOPE_COMBO_ITEM_MODEL ,
			SCOPE_COMBO_ITEM_INSTANCE ,
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
	public ExpertTransitionCoverageConfigurationProfile(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	private class TabListener extends SelectionAdapter implements ModifyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		@Override
		public void modifyText(ModifyEvent e) {
			fConfigurationPage.propagateGUIupdate();
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
		fConfigurationPage.propagateGUIupdate();
	}

	private void handleHeuristicStartSelectionChange() {
		fTCHeuristicStart = fTCHeuristicStartCombo.getText();
		fConfigurationPage.propagateGUIupdate();
	}

	private void handleDirectiveTraceHeuristicSelectionChange() {
		fTCDirectiveTraceHeuristic = fTCDirectiveTraceHeuristicCombo.getText();
		fConfigurationPage.propagateGUIupdate();
	}


	@Override
	public String getSectionTitle() {
		return "Transition Coverage Configuration";
	}

	@Override
	public String getSectionDescription() {
		return "Transition Coverage, heuristic (expert) configuration section";
	}

	
	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit) {
//		widgetToolkit.createGroup(parent,
//		"Transition Coverage Page", 1, 2, GridData.FILL_HORIZONTAL);

		// TRANSITION COVERAGE - section PROPERTY
		//
		Group groupTCProperty = widgetToolkit.createGroup(
				parent, "Section PROPERTY",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				groupTCProperty, 1, 1, GridData.FILL_HORIZONTAL);
		//		GridData.HORIZONTAL_ALIGN_BEGINNING);
		fTCBeginStep = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_BEGIN_STEP,
				"&Begin Step :", comp, 0);
		fTCBeginStep.setToolTipText("Number of \"cumulated\" steps "
				+ "before begining the verification cover");
		fTCBeginStep.setEnabled(false);
		addField(fTCBeginStep);

		Group groupCommon = widgetToolkit.createGroup(groupTCProperty,
				"&Common Coverage Configuration",
				4, 2, GridData.FILL_HORIZONTAL);

		Composite compCommon = widgetToolkit.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fTCHeuristic = new BooleanFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_HEURISTIC,
				"&Heuristic", compCommon, true);
		fTCHeuristic.setToolTipText("Activate the use of heuristics");
		addField(fTCHeuristic);
				
		compCommon = widgetToolkit.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fTCStop = new BooleanFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_STOP, "&Stop", compCommon, true);
		fTCStop.setToolTipText("Stop the symbolic excution "
				+ "as soon as the coverage is completed");
		addField(fTCStop);

		compCommon = widgetToolkit.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fTCSlice = new BooleanFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_SLICE, "&Slice", compCommon, true);
		fTCSlice.setToolTipText("Pruning symbolic execution "
				+ "graph at the end of the analysis");
		addField(fTCSlice);

		compCommon = widgetToolkit.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fTCMinimize = new BooleanFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_MINIMIZE,
				"&Minimize", compCommon, true);
		fTCMinimize.setToolTipText(
				"Stop the symbolic execution at the earliest");
		addField(fTCMinimize);
		

		Composite comp3 = widgetToolkit.createComposite(
				groupTCProperty, 2, 1, GridData.FILL_HORIZONTAL);
		widgetToolkit.createLabel(comp3, "&Scope :", 1);
		fTCScopeCombo = widgetToolkit.createCombo(comp3,
				SWT.DROP_DOWN | SWT.READ_ONLY, 1, SCOPE_COMBO_ITEMS);
		fTCScopeCombo.addSelectionListener(fListener);

		// TRANSITION COVERAGE - section HEURISTIC
		//
		Group groupTCHeuristic = widgetToolkit.createGroup(
				parent, "First Heuristic Configuration",
				2, 1, GridData.FILL_HORIZONTAL);

		Group group = widgetToolkit.createGroup(groupTCHeuristic,
				"&Configuration", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		widgetToolkit.createLabel(comp, "&Start :", 1);
		fTCHeuristicStartCombo = widgetToolkit.createCombo(
				comp, SWT.DROP_DOWN | SWT.READ_ONLY,
				1, HEURISTIC_START_COMBO_ITEMS);
		fTCHeuristicStartCombo.addSelectionListener(fListener);

		fTCHeuristicTrials = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_HEURISTIC_TRIALS, "&Trials :", comp, -1);
		fTCHeuristicTrials.widthInChars = 10;
		//fTCHeuristicTrials.setTextLimit(20);
		addField(fTCHeuristicTrials);


		group = widgetToolkit.createGroup(groupTCHeuristic,
				"&Target Objective", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTCObjectiveRate = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_OBJECTIVE_RATE, "&Rate :", comp, 100);
		//fTCObjectiveRate.widthInChars = 3;
		fTCObjectiveRate.setTextLimit(3);
		addField(fTCObjectiveRate);

		fTCObjectiveRest = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_OBJECTIVE_REST, "&Rest :", comp, 0);
		//fTCObjectiveRest.widthInChars = 3;
		fTCObjectiveRest.setTextLimit(3);
		addField(fTCObjectiveRest);


		group = widgetToolkit.createGroup(groupTCHeuristic,
				"&Lookahead Scope", 1, 2, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		fTCCoverageHeight = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_LOOKAHEAD_DEPTH, "&Depth :", comp, 7);
		addField(fTCCoverageHeight);

		fTCCoverageHeightReachedLimit = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_LOOKAHEAD_WIDTH, "&Width :", comp, 42);
		addField(fTCCoverageHeightReachedLimit);


		Group groupStrategy = widgetToolkit.createGroup(groupTCHeuristic,
				"Strategy of Selection of Contexts in the Queue w.r.t. "
						+ "the number of Fireable transitions",
						3, 2, GridData.FILL_HORIZONTAL);


		group = widgetToolkit.createGroup(groupStrategy,
				"&Strongly Fireable Transition Selection",
				1, 1, GridData.FILL_HORIZONTAL);

		Composite compGroup = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				compGroup, 1, 2, GridData.FILL_HORIZONTAL);

		fTCHitStronglyRandom = new BooleanFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_RANDOM,
				"&Hit Random", comp, false);
		addField(fTCHitStronglyRandom);

		fTCHitStronglyCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_COUNT,
				"&Hit Count :", compGroup, 1);
		addField(fTCHitStronglyCount);


		group = widgetToolkit.createGroup(groupStrategy,
				"&Weakly Fireable Transition Selection",
				1, 1, GridData.FILL_HORIZONTAL);

		compGroup = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				compGroup, 1, 2, GridData.FILL_HORIZONTAL);

		fTCHitWeaklyRandom = new BooleanFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_RANDOM,
				"&Hit Random", comp, false);
		addField(fTCHitWeaklyRandom);

		fTCHitWeaklyCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_COUNT,
				"&Hit Count :", compGroup, 1);
		addField(fTCHitWeaklyCount);


		group = widgetToolkit.createGroup(groupStrategy,
				"&Other Fireable Transition Selection",
				1, 1, GridData.FILL_HORIZONTAL);

		compGroup = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				compGroup, 1, 2, GridData.FILL_HORIZONTAL);

		fTCHitOtherRandom = new BooleanFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_HIT_OTHER_RANDOM,
				"&Hit Random", comp, false);
		addField(fTCHitOtherRandom);

		fTCHitOtherCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_HIT_OTHER_COUNT,
				"&Hit Count :", compGroup, 1);
		addField(fTCHitOtherCount);


		groupTCHeuristic = widgetToolkit.createGroup(
				parent, "Second Heuristic Configuration",
				2, 1, GridData.FILL_HORIZONTAL);

		group = widgetToolkit.createGroup(groupTCHeuristic,
				"&Directive Trace: Strategy & Limit",
				1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 1, 1, GridData.FILL_HORIZONTAL);

		widgetToolkit.createLabel(comp, "&Heuristic :", 1);
		fTCDirectiveTraceHeuristicCombo = widgetToolkit.createCombo(
				comp, SWT.DROP_DOWN | SWT.READ_ONLY, 1,
				DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEMS);
		fTCDirectiveTraceHeuristicCombo.addSelectionListener(fListener);

		fTCDirectiveTraceCountLimit = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_COUNT_LIMIT,
				"&Count :", comp, 8);
		addField(fTCDirectiveTraceCountLimit);

		fTCDirectiveTraceSizeLimit = new IntegerFieldEditor(fConfigurationPage,
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_SIZE_LIMIT,
				"&Size :", comp, 8);
		addField(fTCDirectiveTraceSizeLimit);
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
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
	protected void initializeFromImpl(ILaunchConfiguration configuration) {
		try {
			fTCScope = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_SCOPE, SCOPE_COMBO_ITEM_MODEL);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}

		try {
			if( configuration.getAttribute(
					ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false) )
			{
				fTCScope = SCOPE_COMBO_ITEM_DETAILS;
			}
			else if( fTCScope.equals( SCOPE_COMBO_ITEM_DETAILS ) ) {
				fTCScope = SCOPE_COMBO_ITEM_MODEL;
			}
		}
		catch (CoreException e) {
			e.printStackTrace();
		}

		switch ( fTCScope ) {
		case SCOPE_COMBO_ITEM_MODEL:
			fTCScopeCombo.select(0);
			break;
		case SCOPE_COMBO_ITEM_INSTANCE:
			fTCScopeCombo.select(1);
			break;
		case SCOPE_COMBO_ITEM_DETAILS:
			fTCScopeCombo.select(2);
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

		
		try {
			fTCDirectiveTraceHeuristic = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC,
					DIRECTIVE_TRACE_HEURISTIC_COMBO_ITEM_SMART);
		} catch (CoreException e) {
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
	}

	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		try {
			if( configuration.getAttribute(
					ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false) )
			{
				fTCScope = SCOPE_COMBO_ITEM_DETAILS;
			}
			else if( fTCScope.equals( SCOPE_COMBO_ITEM_DETAILS ) ) {
				fTCScope = SCOPE_COMBO_ITEM_MODEL;
			}
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SCOPE, fTCScope);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_HEURISTIC_START, fTCHeuristicStart);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC,
				fTCDirectiveTraceHeuristic);
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
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

	
	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	public void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION: {
			if( event.getNewValue() instanceof Boolean ) {
				if( (Boolean)(event.getNewValue()) ) {
					fTCScopeCombo.select(2); // SCOPE_COMBO_ITEM_DETAILS:
				}
				else {
					fTCScopeCombo.select(0); // SCOPE_COMBO_ITEM_MODEL:
				}
			}
			break;
		}
		default:
			break;
		}
	}

}
