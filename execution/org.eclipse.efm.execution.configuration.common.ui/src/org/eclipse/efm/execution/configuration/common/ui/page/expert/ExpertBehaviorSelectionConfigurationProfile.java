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

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.FieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class ExpertBehaviorSelectionConfigurationProfile extends AbstractConfigurationProfile {

	// HIT OR JUMP
	//
	private IntegerFieldEditor fHoJBeginStep;

	private IntegerFieldEditor fHoJJumpHeight;
	private IntegerFieldEditor fHoJJumpLimit;
	private IntegerFieldEditor fHoJHitCount;
	private IntegerFieldEditor fHoJJumpCount;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public ExpertBehaviorSelectionConfigurationProfile(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Behavior Selection Configuration";
	}

	@Override
	public String getSectionDescription() {
		return "Behavior Selection, heuristic (expert) configuration section";
	}

	
	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit) {
//		SWTFactory.createGroup(parent,
//		"Behavior Selection Page", 1, 2, GridData.FILL_HORIZONTAL);

		Group groupHoJProperty = widgetToolkit.createGroup(parent,
				"Section PROPERTY", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp1 = widgetToolkit.createComposite(
				groupHoJProperty, 1, 1, GridData.FILL_HORIZONTAL);

		fHoJBeginStep = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_BEGIN_STEP,
				"&Begin Step:", comp1, 0);
		fHoJBeginStep.setToolTipText("Number of \"cumulated\" steps "
				+ "before begining the research of the behavior");
		addField( fHoJBeginStep );
		
		Group groupCommon = widgetToolkit.createGroup(groupHoJProperty,
				"&Common", 3, 2, GridData.FILL_HORIZONTAL);
		
		FieldEditor fieldEditor;

		Composite compCommon = widgetToolkit.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HEURISTIC,
				"&Heuristic", compCommon, true);
		fieldEditor.setToolTipText("Activate the use of heuristics");
		addField( fieldEditor );

		compCommon = widgetToolkit.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_STOP, "&Stop", compCommon, true);
		fieldEditor.setToolTipText("Stop the symbolic excution "
				+ "as soon as the behavior is covered");
		addField( fieldEditor );

		compCommon = widgetToolkit.createComposite(
				groupCommon, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_SLICE, "&Slice", compCommon, true);
		fieldEditor.setToolTipText("Pruning the symbolic execution graph "
				+ "at the end of the analysis");
		addField( fieldEditor );


		Group groupScope = widgetToolkit.createGroup(groupHoJProperty,
				"&Search Scope", 2, 2, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				groupScope, 1, 1, GridData.FILL_HORIZONTAL);

		addField( new BooleanFieldEditor(
				fConfigurationPage, ATTR_BEHAVIOR_SELECTION_HOJ_SEARCH_SCOPE_LOCALLY,
				"&Search Locally scope instead Globally", comp, false) );

		Group groupScheduler = widgetToolkit.createGroup(groupHoJProperty,
				"&Scheduler", 2, 2, GridData.FILL_HORIZONTAL);

		Composite compScheduler = widgetToolkit.createComposite(
				groupScheduler, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED,
				"&Ordered", compScheduler, true);
		fieldEditor.setToolTipText("Search ordered traces");
		addField( fieldEditor );
		
		compScheduler = widgetToolkit.createComposite(
				groupScheduler, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE,
				"&Consecutive", compScheduler, false);
		fieldEditor.setToolTipText(
				"Search ordered traces with consecutive observables");
		addField( fieldEditor );


		Group groupOption = widgetToolkit.createGroup(groupHoJProperty,
				"&Options", 4, 2, GridData.FILL_HORIZONTAL);

		Composite compOption = widgetToolkit.createComposite(
				groupOption, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_FOLDING,
				"&Folding", compOption, true);
		fieldEditor.setToolTipText(
				"Enabled checking many trace point in one context");
		addField( fieldEditor );

		compOption = widgetToolkit.createComposite(
				groupOption, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_LUCKY,
				"&Lucky", compOption, false);
		fieldEditor.setToolTipText(
				"Search one trace in a lucky way - no backtracking");
		addField( fieldEditor );

		compOption = widgetToolkit.createComposite(
				groupOption, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_MAX,
				"&Maximun Trace", compOption, false);
		fieldEditor.setToolTipText("Search a maximun trace");
		addField( fieldEditor );

		compOption = widgetToolkit.createComposite(
				groupOption, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_SLICE,
				"&Jump Slice", compOption, false);
		fieldEditor.setToolTipText(
				"Pruning intermediate at the end of hit or jump");
		addField( fieldEditor );


		Group groupHoJHeuristic = widgetToolkit.createGroup(parent,
				"Section HEURISTIC", 1, 1, GridData.FILL_HORIZONTAL);

		Composite compHeuristic = widgetToolkit.createComposite(
				groupHoJHeuristic, 1, 1, GridData.FILL_HORIZONTAL);
		fHoJJumpHeight = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT,
				"&Jump Height:", compHeuristic, 6);
		addField( fHoJJumpHeight );

		fHoJJumpLimit = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT,
				"&Jump Trials Limit:", compHeuristic, -1);
		addField( fHoJJumpLimit );

		fHoJHitCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT,
				"&Hit Count:", compHeuristic, 1);
		addField( fHoJHitCount );

		fHoJJumpCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT,
				"&Jump Count:", compHeuristic, 1);
		addField( fHoJJumpCount );
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
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
	protected void initializeFromImpl(ILaunchConfiguration configuration) {
		//!! NOTHING
	}

	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		//!! NOTHING
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
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
