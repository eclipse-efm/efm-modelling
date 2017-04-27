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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class SupervisorConfigurationPage extends AbstractConfigurationPage {

	//	public static final String ATTR_BEHAVIOR_ANALYSIS_TRANSITION_NAME =
	//	Activator.PLUGIN_ID + ".ATTR_BEHAVIOR_ANALYSIS_TRANSITION_NAME"; //$NON-NLS-1$

	private IntegerFieldEditor fNodeIntegerField;
	private IntegerFieldEditor fWidthIntegerField;
	private IntegerFieldEditor fHeightIntegerField;
	private IntegerFieldEditor fStepsIntegerField;
	private IntegerFieldEditor fTimeoutIntegerField;
	//private StringFieldEditor fTransitionNameStringField;

	//private Group groupBehaviorCharacterization;

	
	public SupervisorConfigurationPage(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);
	}


	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		createControlNodesHeightWidth(parent, widgetToolkit);
		createControlEvaluationLimits(parent, widgetToolkit);

//		createBehaviorCharacterization(parent, widgetToolkit);
	}

	private void createControlNodesHeightWidth(Composite parent, IWidgetToolkit widgetToolkit) {
        Group group = widgetToolkit.createGroup(parent,
        		"Graph size limits", 5, 2, GridData.FILL_HORIZONTAL);

        Composite comp = widgetToolkit.createComposite(group, 1, 1, GridData.FILL_HORIZONTAL);

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

	private void createControlEvaluationLimits(Composite parent, IWidgetToolkit widgetToolkit) {
        Group group = widgetToolkit.createGroup(parent,
        		"Evaluation limits", 5, 2, GridData.FILL_HORIZONTAL);

        Composite comp = widgetToolkit.createComposite(
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


//	public void createBehaviorCharacterization(Composite parent, IWidgetToolkit widgetToolkit) {
//        groupBehaviorCharacterization = widgetToolkit.createGroup(
//        		parent, "Behavior Characterization",
//        		5, 2, GridData.FILL_HORIZONTAL);
//
//        Composite comp = widgetToolkit.createComposite(
//        		groupBehaviorCharacterization, 1, 1, GridData.FILL_HORIZONTAL);
//
//		fTransitionNameStringField = new StringFieldEditor(this,
//				ATTR_BEHAVIOR_ANALYSIS_TRANSITION_NAME,
//				"&Transition Name List:", comp,
//				"Select a transition name list");
//	}


	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {
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
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, "");

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
	}

	@Override
	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		fNodeIntegerField.initializeFrom(configuration);
		fWidthIntegerField.initializeFrom(configuration);
		fHeightIntegerField.initializeFrom(configuration);
		
		fStepsIntegerField.initializeFrom(configuration);
		fTimeoutIntegerField.initializeFrom(configuration);

		// Timeout grisé tant que pas de solution pour le prendre en compte
		//
		// fTimeoutIntegerField.setEnabled(false);

//		// Cas fTransitionNameStringField
//		//
//		fTransitionNameStringField.initializeFrom(configuration);
//		initializeBehaviorCharacterization(configuration);
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
//			e.printStackTrace();
//		}
//	}

	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		fNodeIntegerField.performApply(configuration);
		fWidthIntegerField.performApply(configuration);
		fHeightIntegerField.performApply(configuration);
		
		fStepsIntegerField.performApply(configuration);
		fTimeoutIntegerField.performApply(configuration);
		
//		fTransitionNameStringField.performApply(configuration);
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		if( ! fNodeIntegerField.isValid() ) {
			return new FieldValidationReturn(false, "Node is not a valid integer");
		}
		if( ! fWidthIntegerField.isValid() ) {
			return new FieldValidationReturn(false, "Width is not a valid integer");
		}
		if( ! fHeightIntegerField.isValid() ) {
			return new FieldValidationReturn(false, "Height is not a valid integer");
		}
		if( ! fStepsIntegerField.isValid() ) {
			return new FieldValidationReturn(false, "Evaluation Steps is not a valid integer");
		}
		if( ! fTimeoutIntegerField.isValid() ) {
			return new FieldValidationReturn(false, "Timeout is not a valid integer");
		}
//		if( ! fTransitionNameStringField.isValid() ) {
//			return new FieldValidationReturn(false, "Transition Name is not a valid string");
//		}
		return new FieldValidationReturn(true, null);
	}

}
