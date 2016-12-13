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
import org.eclipse.efm.runconfiguration.Activator;
import org.eclipse.efm.runconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.efm.runconfiguration.ui.internal.SWTFactory;
import org.eclipse.efm.runconfiguration.ui.internal.fieldeditor.BooleanFieldEditor;
import org.eclipse.efm.runconfiguration.ui.internal.fieldeditor.IntegerFieldEditor;
import org.eclipse.efm.runconfiguration.workflow.common.GraphExplorationStrategyKind;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

public class CommonCriteriaTab extends AbstractSewLaunchConfigurationTab {

	public CommonCriteriaTab(LaunchConfigurationTabGroup groupTab) {
		super(groupTab);
		setHelpContextId("org.eclipse.efm.runconfiguration.efm_runconf_commoncriteria_tab");
	}

//	public static final String ATTR_BEHAVIOR_ANALYSIS_TRANSITION_NAME =
//			Activator.PLUGIN_ID + ".ATTR_BEHAVIOR_ANALYSIS_TRANSITION_NAME"; //$NON-NLS-1$

	private IntegerFieldEditor fNodeIntegerField;
	private IntegerFieldEditor fWidthIntegerField;
	private IntegerFieldEditor fHeightIntegerField;
	private IntegerFieldEditor fStepsIntegerField;
	private IntegerFieldEditor fTimeoutIntegerField;
//	private StringFieldEditor fTransitionNameStringField;
	private BooleanFieldEditor fInclusionCriterionBooleanField;

	private Button fBFSButton = null;
	private Button fDFSButton = null;
	private Button fRFSButton = null;

	private GraphExplorationStrategyKind fAnalyzeStrategy =
			GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;

	private Group groupAnalyzeStrategy;
//	private Group groupBehaviorCharacterization;
	private Group groupInclusionCriterion;


	private class TabListener extends SelectionAdapter implements ModifyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		@Override
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			Object source= e.getSource();
//			if (source == fViewer.getTable() || source == fViewer) {
//				setParametersButtonsEnableState();
//			} else if (source == fParametersAddButton) {
//				handleParametersAddButtonSelected();
//			} else if (source == fParametersEditButton) {
//				handleParametersEditButtonSelected();
//			} else if (source == fParametersRemoveButton) {
//				handleParametersRemoveButtonSelected();
//			}

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
		}
	}

	private TabListener fListener= new TabListener();


	/**
	 * Returns the {@link IDialogSettings} for the given id
	 *
	 * @param id the id of the dialog settings to get
	 * @return the {@link IDialogSettings} to pass into the {@link ContainerSelectionDialog}
	 * @since 3.6
	 */
	IDialogSettings getDialogBoundsSettings(String id) {
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		IDialogSettings section = settings.getSection(id);
		if (section == null) {
			section = settings.addNewSection(id);
		}
		return section;
	}

	public void handleBFSButtonSelected() {
		if( fBFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
		}
		updateLaunchConfigurationDialog();
	}

	public void handleDFSButtonSelected() {
		if( fDFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.DEPTH_FIRST_SEARCH;
		}
		updateLaunchConfigurationDialog();
	}

	public void handleRFSButtonSelected() {
		if( fRFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.RANDOM_FIRST_SEARCH;
		}
		updateLaunchConfigurationDialog();
	}

	@Override
	public void createControl(Composite parent) {
		Composite simpleComposite = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_BOTH, 0, 0);
		setControl(simpleComposite);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), getHelpContextId());

		createControlNodesHeightWidth(simpleComposite);
		createControlEvaluationLimits(simpleComposite);
		createAnalyzeStrategy(simpleComposite);
		createControlInclusionCriterion(simpleComposite);
//		createBehaviorCharacterization(simpleComposite);
	}


	public void createControlNodesHeightWidth(Composite parent) {
        Group group = SWTFactory.createGroup(parent, "Graph size limits", 5, 2, GridData.FILL_HORIZONTAL);

        Composite comp = SWTFactory.createComposite(group, 1, 1, GridData.FILL_HORIZONTAL);

		fNodeIntegerField = new IntegerFieldEditor(this,
				ATTR_SPECIFICATION_STOP_CRITERIA_NODE, "&Nodes:", comp, -1);
		fNodeIntegerField.setToolTipText("Maximal number of nodes "
				+ "(-1 <=> no-limit) of the symbolic execution tree");

		fWidthIntegerField = new IntegerFieldEditor(this,
				ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH, "W&idth:", comp, -1);
		fWidthIntegerField.setToolTipText(
				"Maximal width (-1 <=> no-limit) of the symbolic execution tree");

		fHeightIntegerField = new IntegerFieldEditor(this,
				ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT, "&Height:", comp, 100);
		fHeightIntegerField.setToolTipText(
				"Maximal height (-1 <=> no-limit) of the symbolic execution tree");
	}

	public void createControlEvaluationLimits(Composite parent) {
        Group group = SWTFactory.createGroup(parent,
        		"Evaluation limits", 5, 2, GridData.FILL_HORIZONTAL);

        Composite comp = SWTFactory.createComposite(
        		group, 1, 1, GridData.FILL_HORIZONTAL);

		fStepsIntegerField = new IntegerFieldEditor(this,
				ATTR_SPECIFICATION_STOP_CRITERIA_STEPS,
				"&Evaluation Steps:", comp, 1000);
		fStepsIntegerField.setToolTipText("Maximal steps of calculus "
				+ "(-1 <=> no-limit) during the symbolic execution");

		fTimeoutIntegerField = new IntegerFieldEditor(this,
				ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT,
				"&Timeout (seconds):", comp, -1);
		fTimeoutIntegerField.setToolTipText("Maximal duration "
				+ "(-1 <=> no-limit) of the symbolic execution");
	}

	public void createControlInclusionCriterion(Composite parent) {
        groupInclusionCriterion = SWTFactory.createGroup(parent,
        		"Inclusion Criterion", 5, 2, GridData.FILL_HORIZONTAL);

        Composite comp = SWTFactory.createComposite(
        		groupInclusionCriterion, 1, 1, GridData.FILL_HORIZONTAL);

        fInclusionCriterionBooleanField = new BooleanFieldEditor(this,
        		ATTR_ENABLED_INCLUSION_CRITERION,
        		"&Apply Inclusion", comp, false);
	}


	protected void createAnalyzeStrategy(Composite parent) {
		groupAnalyzeStrategy = SWTFactory.createGroup(
				parent, "&Analyze Strategy", 3, 1, GridData.FILL_HORIZONTAL);

		fBFSButton = SWTFactory.createRadioButton(groupAnalyzeStrategy, "&BFS");
		fBFSButton.addSelectionListener(fListener);
		fBFSButton.setToolTipText("Breadth First Search");

		fDFSButton = SWTFactory.createRadioButton(groupAnalyzeStrategy, "&DFS");
		fDFSButton.addSelectionListener(fListener);
		fDFSButton.setToolTipText("Depth First Search");

		fRFSButton = SWTFactory.createRadioButton(groupAnalyzeStrategy, "&RFS");
		fRFSButton.addSelectionListener(fListener);
		fRFSButton.setToolTipText("Random First Search");

		fBFSButton.setSelection(false);
		fDFSButton.setSelection(false);
		fRFSButton.setSelection(false);
	}

//	public void createBehaviorCharacterization(Composite parent) {
//        groupBehaviorCharacterization = SWTFactory.createGroup(
//        		parent, "Behavior Characterization",
//        		5, 2, GridData.FILL_HORIZONTAL);
//
//        Composite comp = SWTFactory.createComposite(
//        		groupBehaviorCharacterization, 1, 1, GridData.FILL_HORIZONTAL);
//
//		fTransitionNameStringField = new StringFieldEditor(this,
//				ATTR_BEHAVIOR_ANALYSIS_TRANSITION_NAME,
//				"&Transition Name List:", comp,
//				"Select a transition name list");
//	}


	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#isValid(ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if( ! fNodeIntegerField.isValid() ) {
			setErrorMessage("Node is not a valid integer");
			return false;
		}
		if( ! fWidthIntegerField.isValid() ) {
			setErrorMessage("Width is not a valid integer");
			return false;
		}
		if( ! fHeightIntegerField.isValid() ) {
			setErrorMessage("Height is not a valid integer");
			return false;
		}
		if( ! fStepsIntegerField.isValid() ) {
			setErrorMessage("Evaluation Steps is not a valid integer");
			return false;
		}

		if( ! fTimeoutIntegerField.isValid() ) {
			setErrorMessage("Timeout is not a valid integer");
			return false;
		}

//		if( ! fTransitionNameStringField.isValid() ) {
//			setErrorMessage("Transition Name is not a valid string");
//			return false;
//		}

		return true;
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
//		fNodeIntegerField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_NODE, -1);

//		fWidthIntegerField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH, -1);

//		fHeightIntegerField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT, -1);

//		fStepsIntegerField.setDefaults(configuration);
    	String fModelAnalysis;
		try {
			fModelAnalysis = configuration.getAttribute(
					MainTab.ATTR_SPECIFICATION_MODEL_ANALYSIS, "");

			if ( fModelAnalysis.equals(
					ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
			{
				configuration.setAttribute(
						ATTR_SPECIFICATION_STOP_CRITERIA_STEPS, -1);
			}
			else {
				configuration.setAttribute(
						ATTR_SPECIFICATION_STOP_CRITERIA_STEPS, 1000);
			}
		}
		catch (CoreException e) {
			e.printStackTrace();
		}

//		fTimeoutIntegerField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT, -1);

//		fInclusionCriterionBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_INCLUSION_CRITERION, false);

		configuration.setAttribute(
				ATTR_SPECIFICATION_ANALYZE_STRATEGY, "BFS");
	}


	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		fNodeIntegerField.initializeFrom(configuration);
		fWidthIntegerField.initializeFrom(configuration);
		fHeightIntegerField.initializeFrom(configuration);
		fStepsIntegerField.initializeFrom(configuration);
		fTimeoutIntegerField.initializeFrom(configuration);

		fInclusionCriterionBooleanField.setEnabled(false);
		fInclusionCriterionBooleanField.initializeFrom(configuration);

		// Timeout grisé tant que pas de solution pour le prendre en compte
		//
		// fTimeoutIntegerField.setEnabled(false);

		// Cas fAnalyzeStrategy
		//
		try {
			fAnalyzeStrategy = GraphExplorationStrategyKind.get(
					configuration.getAttribute(
							ATTR_SPECIFICATION_ANALYZE_STRATEGY,
							GraphExplorationStrategyKind.
									BREADTH_FIRST_SEARCH.getLiteral()) );
		} catch (CoreException e) {
			e.printStackTrace();
		}
		finally {
			if( fAnalyzeStrategy == null ) {
				fAnalyzeStrategy = GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
			}
		}

		initializeAnalyzeStrategy(configuration);

//		// Cas fTransitionNameStringField
//		//
//		fTransitionNameStringField.initializeFrom(configuration);
//		initializeBehaviorCharacterization(configuration);
	}

	private void initializeAnalyzeStrategy(ILaunchConfiguration configuration) {
    	String fModelAnalysis;
    	String fAnalysisProfile;
		try {
			fModelAnalysis = configuration.getAttribute(
					MainTab.ATTR_SPECIFICATION_MODEL_ANALYSIS, "");

			fAnalysisProfile = configuration.getAttribute(
					MainTab.ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");

			if ( fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION)
				|| fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR)
				|| fAnalysisProfile.equals(ANALYSIS_PROFILE_TEST_OFFLINE) ) {
//				fBFSButton.setEnabled(false);
//				fDFSButton.setEnabled(false);
//				fRFSButton.setEnabled(false);

//				groupAnalyzeStrategy.setVisible(false);
				visibleAndExclude(groupAnalyzeStrategy,false);
				visibleAndExclude(groupInclusionCriterion,false);

				fBFSButton.setSelection(false);
				fDFSButton.setSelection(false);
				fRFSButton.setSelection(false);
			}
			else {
//				fBFSButton.setEnabled(true);
//				fDFSButton.setEnabled(true);
//				fRFSButton.setEnabled(true);
				groupAnalyzeStrategy.setVisible(true);
				visibleAndExclude(groupAnalyzeStrategy,true);
				visibleAndExclude(groupInclusionCriterion,true);

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
				default:
					fBFSButton.setSelection(true);
					fAnalyzeStrategy =
							GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
					break;
				}
			}

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private void initializeBehaviorCharacterization(ILaunchConfiguration configuration) {
//    	String fAnalysisProfile;
//    	String fModelAnalysis;
//		try {
//			fAnalysisProfile = configuration.getAttribute(
//					MainTab.ATTR_SPECIFICATION_ANALYSIS_PROFILE, "");
//			fModelAnalysis = configuration.getAttribute(
//					MainTab.ATTR_SPECIFICATION_MODEL_ANALYSIS, "");
//
//			if ( fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL) &&
//					fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR)	) {
////				fTransitionNameStringField.setEnabled(true);
//
////				groupBehaviorCharacterization.setVisible(true);
//				visibleAndExclude(groupBehaviorCharacterization,true);
//			}
//			else {
////				fTransitionNameStringField.setEnabled(false);
//
////				groupBehaviorCharacterization.setVisible(false);
//				visibleAndExclude(groupBehaviorCharacterization,false);
//			}
//
//		} catch (CoreException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		fNodeIntegerField.performApply(configuration);
		fWidthIntegerField.performApply(configuration);
		fHeightIntegerField.performApply(configuration);
		fStepsIntegerField.performApply(configuration);
		fTimeoutIntegerField.performApply(configuration);
//		fTransitionNameStringField.performApply(configuration);

		fInclusionCriterionBooleanField.performApply(configuration);
		fInclusionCriterionBooleanField.setEnabled(true);

		configuration.setAttribute(
				ATTR_SPECIFICATION_ANALYZE_STRATEGY,
				fAnalyzeStrategy.getLiteral());
	}

	@Override
	public String getName() {
		return "Common Criteria";
	}

}
