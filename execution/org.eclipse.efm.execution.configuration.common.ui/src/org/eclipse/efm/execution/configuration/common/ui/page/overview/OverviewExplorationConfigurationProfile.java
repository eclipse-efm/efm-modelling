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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
//import org.eclipse.efm.execution.configuration.common.ui.page.supervisor.SupervisorEvaluationLimitsSection;
//import org.eclipse.efm.execution.configuration.common.ui.page.supervisor.SupervisorGraphSizeLimitsSection;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind;
import org.eclipse.efm.execution.core.workflow.common.RedundancyComparerOperation;
import org.eclipse.efm.execution.core.workflow.common.RedundancyPathScope;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class OverviewExplorationConfigurationProfile extends AbstractConfigurationProfile {

	private Group groupAnalyzeStrategy;

	private Button fBFSButton = null;
	private Button fDFSButton = null;
	private Button fRFSButton = null;
	private Button fALLButton = null;

	private GraphExplorationStrategyKind fAnalyzeStrategy =
		GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;


//	private SupervisorGraphSizeLimitsSection  fGraphSizeLimitsSection;
//
//	private SupervisorEvaluationLimitsSection fEvaluationLimitsSection;


	private Group fGroupInclusionCriterion;
	private BooleanFieldEditor fEnabledRedundancyDetectionBooleanField;
	// OR EXCLUSIVE
	private Composite fLoopDetectionTrivialComposite;

	private Composite fRedundancyConfigurationComposite;

	public static final String[] REDUNDANCY_PATH_SCOPE_COMBO_ITEMS = new String[] {
			RedundancyPathScope.CURRENT.getLiteral() ,
			RedundancyPathScope.ALL.getLiteral() ,
			RedundancyPathScope.PARENT.getLiteral()
	};

	private Combo fRedundancyPathScopeCombo = null;

	private RedundancyPathScope fRedundancyPathScope =
			RedundancyPathScope.CURRENT;


	public static final String[] REDUNDANCY_COMPARER_OPERATION_COMBO_ITEMS = new String[] {
			RedundancyComparerOperation.INCLUSION.getLiteral() ,
			RedundancyComparerOperation.EQUALITY.getLiteral() ,
			RedundancyComparerOperation.SYNTAXIC_EQUALITY.getLiteral() ,
			RedundancyComparerOperation.CONTROL_STATE.getLiteral()
	};
	private Combo fRedundancyComparerOperationCombo = null;

	private RedundancyComparerOperation fRedundancyComparerOperation =
			RedundancyComparerOperation.INCLUSION;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewExplorationConfigurationProfile(
			final AbstractConfigurationPage configurationPage)
	{
		super(configurationPage, false);

//		fGraphSizeLimitsSection  = new SupervisorGraphSizeLimitsSection(configurationPage);
//
//		fEvaluationLimitsSection = new SupervisorEvaluationLimitsSection(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Model Exploration";
	}

	@Override
	public String getSectionDescription() {
		return "Choose an exploration strategy and "
				+ "set a limitation in Supervisor Tab";
	}


	private final class TabListener extends SelectionAdapter {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Object source = e.getSource();

			// Use case Analysis
			if (source == fBFSButton) {
				handleBFSButtonSelected();
			}
			else if (source == fDFSButton) {
				handleDFSButtonSelected();
			}
			else if (source == fRFSButton) {
				handleRFSButtonSelected();
			}
			else if (source == fALLButton) {
				handleALLButtonSelected();
			}
		}
	}

	private TabListener fListener= new TabListener();


	// ======================================================================================
	//                              Buttons handling
	// ======================================================================================

	public void handleBFSButtonSelected() {
		if( fBFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
		}
		fConfigurationPage.propagateGUIupdate();
	}

	public void handleDFSButtonSelected() {
		if( fDFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.DEPTH_FIRST_SEARCH;
		}
		fConfigurationPage.propagateGUIupdate();
	}

	public void handleRFSButtonSelected() {
		if( fRFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.RANDOM_FIRST_SEARCH;
		}
		fConfigurationPage.propagateGUIupdate();
	}

	public void handleALLButtonSelected() {
		if( fALLButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.ALL;
		}
		fConfigurationPage.propagateGUIupdate();
	}



	@Override
	protected void createContent(final Composite parent, final IWidgetToolkit widgetToolkit)
	{
		createAnalyzeStrategy(parent, widgetToolkit);

		createControlInclusionCriterion(parent, widgetToolkit);

//		fGraphSizeLimitsSection.createControl(parent, widgetToolkit);
//
//		fEvaluationLimitsSection.createControl(parent, widgetToolkit);
	}

	private void createControlInclusionCriterion(
			final Composite parent, final IWidgetToolkit widgetToolkit)
	{
        fGroupInclusionCriterion = widgetToolkit.createGroup(parent,
        		"Redundancy Detection", 1, 2, GridData.FILL_HORIZONTAL);

        final Composite comp = widgetToolkit.createComposite(
        		fGroupInclusionCriterion, 2, 1, GridData.FILL_HORIZONTAL);

        fEnabledRedundancyDetectionBooleanField =
        		new BooleanFieldEditor(this.fConfigurationPage,
        				ATTR_ENABLED_REDUNDANCY_DETECTION,
        				"&Enabled General Detection", comp, false);
        fEnabledRedundancyDetectionBooleanField.addSelectionListener(
        		new SelectionAdapter() {
        			@Override
        			public void widgetSelected(final SelectionEvent e) {
        				handleEnablingRedundancyDetection();
        			}
        		});
        addFieldEditor(fEnabledRedundancyDetectionBooleanField);

        fRedundancyConfigurationComposite = widgetToolkit.createComposite(
        		fGroupInclusionCriterion, 2, 1, GridData.FILL_HORIZONTAL);

		fRedundancyPathScopeCombo = widgetToolkit.createLabelledCombo(
				fRedundancyConfigurationComposite, "&Path Scope : ",
				SWT.DROP_DOWN | SWT.READ_ONLY, 1, REDUNDANCY_PATH_SCOPE_COMBO_ITEMS);
		fRedundancyPathScopeCombo.addSelectionListener( new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				handleRedundancyPathScopeSelectionChange();
			}
		});


		fRedundancyComparerOperationCombo = widgetToolkit.createLabelledCombo(
				fRedundancyConfigurationComposite, "&Comparer Operation : ",
				SWT.DROP_DOWN | SWT.READ_ONLY, 1,
				REDUNDANCY_COMPARER_OPERATION_COMBO_ITEMS);
		fRedundancyComparerOperationCombo.addSelectionListener( new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				handleRedundancyComparerOperationSelectionChange();
			}
		});


        fLoopDetectionTrivialComposite = widgetToolkit.createComposite(
        		fGroupInclusionCriterion, 2, 1, GridData.FILL_HORIZONTAL);

        final BooleanFieldEditor loopDetectionTrivialBooleanField =
        		new BooleanFieldEditor(this.fConfigurationPage,
        				ATTR_ENABLED_REDUNDANCY_TRIVIAL_LOOP_DETECTION,
        				"Enabled Trivial &Loop Detection",
        				fLoopDetectionTrivialComposite, false);
        addFieldEditor(loopDetectionTrivialBooleanField);
	}


	private void handleEnablingRedundancyDetection() {
		final boolean enabled =
				fEnabledRedundancyDetectionBooleanField.getBooleanValue();

		fConfigurationPage.setVisibleAndEnabled(
				fRedundancyConfigurationComposite, enabled);

		fConfigurationPage.setVisibleAndEnabled(
				fLoopDetectionTrivialComposite, ! enabled);
	}

	private void handleRedundancyPathScopeSelectionChange() {
		fRedundancyPathScope = RedundancyPathScope.get(
				fRedundancyPathScopeCombo.getText() );

		switch ( fRedundancyPathScope ) {
		case CURRENT:
			fRedundancyPathScopeCombo.setToolTipText(
					"Try to detect redundancy only on the current path" );
			break;

		case ALL:
			fRedundancyPathScopeCombo.setToolTipText(
					"Try to detect redundancy in the current graph");
			break;

		case PARENT:
			fRedundancyPathScopeCombo.setToolTipText(
					"Try to detect redundancy only in the parent node");
			break;

		default:
			fRedundancyPathScopeCombo.setToolTipText("Try to detect redundancy "
					+ "w.r.t. the defined scope in the current graph" );
			break;
		}
	}

	private void handleRedundancyComparerOperationSelectionChange() {
		fRedundancyComparerOperation = RedundancyComparerOperation.get(
				fRedundancyComparerOperationCombo.getText() );

		switch ( fRedundancyComparerOperation ) {
		case INCLUSION:
			fRedundancyComparerOperationCombo.setToolTipText(
					"Try to detect redundancy with "
					+ "semantic inclusion comparison on symbolic states");
			break;

		case EQUALITY:
			fRedundancyComparerOperationCombo.setToolTipText(
					"Try to detect redundancy with "
					+ "semantic equality comparisonon symbolic states");
			break;

		case SYNTAXIC_EQUALITY:
			fRedundancyComparerOperationCombo.setToolTipText(
					"Try to detect redundancy with "
					+ "syntaxic equality comparisonon symbolic states");
			break;

		case CONTROL_STATE:
			fRedundancyComparerOperationCombo.setToolTipText(
					"Try to detect redundancy with "
					+ "limited comparison to control state on symbolic states");
			break;

		default:
			fRedundancyComparerOperationCombo.setToolTipText(
					"Try to detect redundancy w.r.t. "
					+ "the defined comparer operation on symbolic states" );
			break;
		}
	}


	protected void createAnalyzeStrategy(final Composite parent, final IWidgetToolkit widgetToolkit) {
		groupAnalyzeStrategy = widgetToolkit.createGroup(
				parent, "&Analyze Strategy", 4, 1, GridData.FILL_HORIZONTAL);

		fBFSButton = widgetToolkit.createRadioButton(groupAnalyzeStrategy, "&BFS");
		fBFSButton.addSelectionListener(fListener);
		fBFSButton.setToolTipText("Breadth First Search");

		fDFSButton = widgetToolkit.createRadioButton(groupAnalyzeStrategy, "&DFS");
		fDFSButton.addSelectionListener(fListener);
		fDFSButton.setToolTipText("Depth First Search");

		fRFSButton = widgetToolkit.createRadioButton(groupAnalyzeStrategy, "&RFS");
		fRFSButton.addSelectionListener(fListener);
		fRFSButton.setToolTipText("Random First Search");

		fALLButton = widgetToolkit.createRadioButton(groupAnalyzeStrategy, "&ALL");
		fALLButton.addSelectionListener(fListener);
		fALLButton.setToolTipText("SEARCH IN ALL");
	}


	@Override
	protected void setDefaultsImpl(final ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(ATTR_SPECIFICATION_ANALYZE_STRATEGY,
				GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH.getLiteral());

		configuration.setAttribute(ATTR_ENABLED_REDUNDANCY_DETECTION, false);
		// OR EXCLUSIVE
		configuration.setAttribute(ATTR_ENABLED_REDUNDANCY_TRIVIAL_LOOP_DETECTION, true);

		configuration.setAttribute(ATTR_REDUNDANCY_PATH_SCOPE,
				RedundancyPathScope.CURRENT.getLiteral());

		configuration.setAttribute(ATTR_REDUNDANCY_COMPARER_OPERATION,
				RedundancyComparerOperation.INCLUSION.getLiteral());

//		fGraphSizeLimitsSection.setDefaults(configuration);
//
//		fEvaluationLimitsSection.setDefaults(configuration);
	}

	@Override
	protected void initializeFromImpl(final ILaunchConfiguration configuration)
	{
		// Case Analyze Strategy
		//
		final GraphExplorationStrategyKind oldAnalyzeStrategy = fAnalyzeStrategy;

		try {
			fAnalyzeStrategy = GraphExplorationStrategyKind.get(
					configuration.getAttribute(ATTR_SPECIFICATION_ANALYZE_STRATEGY,
							GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH.getLiteral()) );
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		finally {
			if( fAnalyzeStrategy == null ) {
				fAnalyzeStrategy = (oldAnalyzeStrategy != null) ? oldAnalyzeStrategy :
						GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
			}
		}

//		fGraphSizeLimitsSection.initializeFrom(configuration);
//
//		fEvaluationLimitsSection.initializeFrom(configuration);

		initializeAnalyzeStrategy();

		// REDUNDANCY DETECTION PATH SCOPE
		try {
			fRedundancyPathScope = RedundancyPathScope.get(
					configuration.getAttribute(
							ATTR_REDUNDANCY_PATH_SCOPE,
							RedundancyPathScope.CURRENT.getLiteral()));
		}
		catch (final CoreException e) {
			e.printStackTrace();
		}
		if( fRedundancyPathScope == null ) {
			fRedundancyPathScope = RedundancyPathScope.CURRENT;
		}
		switch ( fRedundancyPathScope ) {
		case CURRENT:
			fRedundancyPathScopeCombo.select(0);
			break;
		case ALL:
			fRedundancyPathScopeCombo.select(1);
			break;
		case PARENT:
			fRedundancyPathScopeCombo.select(2);
			break;
		default:
			fRedundancyPathScope = RedundancyPathScope.CURRENT;
			fRedundancyPathScopeCombo.select(0);
			break;
		}
		handleRedundancyPathScopeSelectionChange();

		// REDUNDANCY DETECTION COMPARER OPERATION
		try {
			fRedundancyComparerOperation = RedundancyComparerOperation.get(
					configuration.getAttribute(
							ATTR_REDUNDANCY_COMPARER_OPERATION,
							RedundancyComparerOperation.INCLUSION.getLiteral()));
		}
		catch (final CoreException e) {
			e.printStackTrace();
		}
		if( fRedundancyComparerOperation == null ) {
			fRedundancyComparerOperation = RedundancyComparerOperation.INCLUSION;
		}
		switch ( fRedundancyComparerOperation ) {
		case INCLUSION:
			fRedundancyComparerOperationCombo.select(0);
			break;
		case EQUALITY:
			fRedundancyComparerOperationCombo.select(1);
			break;
		case SYNTAXIC_EQUALITY:
			fRedundancyComparerOperationCombo.select(2);
			break;
		case CONTROL_STATE:
			fRedundancyComparerOperationCombo.select(3);
			break;
		default:
			fRedundancyComparerOperation = RedundancyComparerOperation.INCLUSION;
			fRedundancyComparerOperationCombo.select(0);
			break;
		}
		handleRedundancyComparerOperationSelectionChange();;

		handleEnablingRedundancyDetection();
	}


	private void initializeAnalyzeStrategy() {
		fBFSButton.setSelection(false);
		fDFSButton.setSelection(false);
		fRFSButton.setSelection(false);
		fALLButton.setSelection(false);

		switch( fAnalyzeStrategy ) {
		case BREADTH_FIRST_SEARCH:
			fBFSButton.setSelection(true);
			break;
		case DEPTH_FIRST_SEARCH:
			fDFSButton.setSelection(true);
			break;
		case RANDOM_FIRST_SEARCH:
			fRFSButton.setSelection(true);
			break;
		case ALL:
			fALLButton.setSelection(true);
			break;
		default:
			fBFSButton.setSelection(true);

			fAnalyzeStrategy =
					GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
			break;
		}
	}



	@Override
	protected void performApplyImpl(final ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_SPECIFICATION_ANALYZE_STRATEGY,
				fAnalyzeStrategy.getLiteral());

		configuration.setAttribute(
				ATTR_REDUNDANCY_PATH_SCOPE, fRedundancyPathScope.getLiteral());

		configuration.setAttribute(
				ATTR_REDUNDANCY_COMPARER_OPERATION, fRedundancyComparerOperation.getLiteral());

//		fGraphSizeLimitsSection.performApply(configuration);
//
//		fEvaluationLimitsSection.performApply(configuration);
	}

	@Override
	protected boolean isValidImpl(final ILaunchConfiguration launchConfig) {
		return true;
	}


	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	public void handleConfigurationPropertyChange(final PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE:

			switch( (AnalysisProfileKind) event.getNewValue() ) {
			case ANALYSIS_TRANSITION_COVERAGE_PROFILE:
			case ANALYSIS_BEHAVIOR_SELECTION_PROFILE:
			case ANALYSIS_TEST_OFFLINE_PROFILE:
			case ANALYSIS_ACSL_GENERATION_PROFILE: {
				fDFSButton.setSelection(false);
				fRFSButton.setSelection(false);
				fALLButton.setSelection(false);

				fBFSButton.setSelection(true); // BREADTH_FIRST_SEARCH
				break;
			}

			case ANALYSIS_EXTRANEOUS_PROFILE:
				break;

			case ANALYSIS_EXPLORATION_PROFILE:
			default:
				break;
			}

			break;

		default:
			break;
		}
	}


}
