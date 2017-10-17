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
//import org.eclipse.efm.execution.configuration.common.ui.page.supervisor.SupervisorEvaluationLimitsSection;
//import org.eclipse.efm.execution.configuration.common.ui.page.supervisor.SupervisorGraphSizeLimitsSection;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
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
	private BooleanFieldEditor fApplyInclusionBooleanField;
	private Composite fLoopDetectionTrivialComposite;

	
	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewExplorationConfigurationProfile(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
		
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
		public void widgetSelected(SelectionEvent e) {
			Object source = e.getSource();

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
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		createAnalyzeStrategy(parent, widgetToolkit);

		createControlInclusionCriterion(parent, widgetToolkit);

//		fGraphSizeLimitsSection.createControl(parent, widgetToolkit);
//		
//		fEvaluationLimitsSection.createControl(parent, widgetToolkit);
	}

	private void createControlInclusionCriterion(
			Composite parent, IWidgetToolkit widgetToolkit)
	{
        fGroupInclusionCriterion = widgetToolkit.createGroup(parent,
        		"Inclusion Criterion", 1, 2, GridData.FILL_HORIZONTAL);

        Composite comp = widgetToolkit.createComposite(
        		fGroupInclusionCriterion, 2, 1, GridData.FILL_HORIZONTAL);

        fApplyInclusionBooleanField =
        		new BooleanFieldEditor(this.fConfigurationPage,
        				ATTR_ENABLED_REDUNDANCY_INCLUSION_CRITERION,
        				"&Apply Inclusion", comp, false);
        addField(fApplyInclusionBooleanField);

        
        fLoopDetectionTrivialComposite = widgetToolkit.createComposite(
        		fGroupInclusionCriterion, 2, 1, GridData.FILL_HORIZONTAL);

        BooleanFieldEditor loopDetectionTrivialBooleanField =
        		new BooleanFieldEditor(this.fConfigurationPage,
        				ATTR_ENABLED_REDUNDANCY_LOOP_DETECTION_TRIVIAL,
        				"&Loop Detection Trivial",
        				fLoopDetectionTrivialComposite, false);
        addField(loopDetectionTrivialBooleanField);
        
        fApplyInclusionBooleanField.addSelectionListener( new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		handleEnablingRedundancyDetection();
        	}
		});
	}

	
	private void handleEnablingRedundancyDetection() {
		fConfigurationPage.setVisibleAndEnabled(fLoopDetectionTrivialComposite,
        		! fApplyInclusionBooleanField.getBooleanValue());
	}



	protected void createAnalyzeStrategy(Composite parent, IWidgetToolkit widgetToolkit) {
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
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(ATTR_SPECIFICATION_ANALYZE_STRATEGY,
				GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH.getLiteral());

		configuration.setAttribute(ATTR_ENABLED_REDUNDANCY_INCLUSION_CRITERION, false);

		configuration.setAttribute(ATTR_ENABLED_REDUNDANCY_LOOP_DETECTION_TRIVIAL, true);
		
//		fGraphSizeLimitsSection.setDefaults(configuration);
//		
//		fEvaluationLimitsSection.setDefaults(configuration);
	}

	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration)
	{
		// Case Analyze Strategy
		//
		GraphExplorationStrategyKind oldAnalyzeStrategy = fAnalyzeStrategy;
		
		try {
			fAnalyzeStrategy = GraphExplorationStrategyKind.get(
					configuration.getAttribute(ATTR_SPECIFICATION_ANALYZE_STRATEGY,
							GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH.getLiteral()) );
		} catch (CoreException e) {
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
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_SPECIFICATION_ANALYZE_STRATEGY,
				fAnalyzeStrategy.getLiteral());
		
//		fGraphSizeLimitsSection.performApply(configuration);
//		
//		fEvaluationLimitsSection.performApply(configuration);
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		return true;
	}

	
	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	public void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE:

			switch( event.getNewValue().toString() ) {
			case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR:
			case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION:
			case ANALYSIS_PROFILE_MODEL_TEST_OFFLINE: {
				fDFSButton.setSelection(false);
				fRFSButton.setSelection(false);
				fALLButton.setSelection(false);

				fBFSButton.setSelection(true); // BREADTH_FIRST_SEARCH
				break;
			}

			case ANALYSIS_PROFILE_MODEL_EXPLORATION:
			default:
				break;
			}

			break;

		default:
			break;
		}
	}


}
