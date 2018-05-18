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

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableConfigProvider;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class OverviewBehaviorSelectionConfigurationProfile extends AbstractConfigurationProfile {

	private TraceElementTableViewer fTraceElementTableViewer;

	private Group groupTraceSequenceOption;

	private Group groupOptionSelectionHeuristic;

	private Group groupExplorationHeuristic;

	private IntegerFieldEditor fHoJLocalHeight;
	private IntegerFieldEditor fHoJTrialLimit;

	private Group groupHitOrJumpHeuristic;

	private IntegerFieldEditor fHoJHitCount;
	private IntegerFieldEditor fHoJJumpCount;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewBehaviorSelectionConfigurationProfile(
			AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Behavior Selection";
	}

	@Override
	public String getSectionDescription() {
		return "Behavior Selection, configuration section";
	}


	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit) {
		parent.setToolTipText(BEHAVIOR_DESCRIPTION);

		Composite container = widgetToolkit.createComposite(
				parent, 2, 1, GridData.FILL_HORIZONTAL);

		// Trace Sequence
		fTraceElementTableViewer =
			new TraceElementTableViewer(this, container, 1, widgetToolkit,
					TraceElementTableConfigProvider.getBehaviorSelection(
							parent.getFont()));
		addTableViewer( fTraceElementTableViewer );

		// Options & Selection Heuristic
		groupOptionSelectionHeuristic = widgetToolkit.createGroup(container,
				"&Options && Selection Heuristic ", 1, 1, GridData.FILL_BOTH);

		// Sequence Options
		groupTraceSequenceOption = widgetToolkit.createGroup(groupOptionSelectionHeuristic,
				"&Sequence Option ", 1, 1, GridData.FILL_BOTH);

		Composite compOptions = widgetToolkit.createComposite(
				groupTraceSequenceOption, 1, 1, GridData.FILL_HORIZONTAL);
		BooleanFieldEditor fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED,
				"&Ordered", compOptions, true);
		fieldEditor.setToolTipText("Search ordered traces");
		addFieldEditor( fieldEditor );

		compOptions = widgetToolkit.createComposite(
				groupTraceSequenceOption, 1, 1, GridData.FILL_HORIZONTAL);
		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE,
				"&Consecutive", compOptions, false);
		fieldEditor.setToolTipText(
				"Search ordered traces with consecutive observables");
		addFieldEditor( fieldEditor );

		fieldEditor = new BooleanFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_FOLDING,
				"&Folding", compOptions, true);
		fieldEditor.setToolTipText(
				"Enabled verification of multiple trace properties per Symbex State");
		addFieldEditor( fieldEditor );


		// Exploration Heuristic
		groupExplorationHeuristic = widgetToolkit.createGroup(groupOptionSelectionHeuristic,
				"&Local Exploration Limit ", 1, 1, GridData.FILL_BOTH);

		Composite comp = widgetToolkit.createComposite(
				groupExplorationHeuristic, 1, 1, GridData.FILL_HORIZONTAL);

		// Local exploration height before the next selection by HIT or JUMP
		fHoJLocalHeight = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT, "&Height : ",
				comp, DEFAULT_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT);
		fHoJLocalHeight.setToolTipText(
				"Local exploration height before the next selection by HIT or JUMP");
		addFieldEditor( fHoJLocalHeight );

		// Local exploration trials number
		fHoJTrialLimit = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT,
				"&Trials : ", comp, -1);
		fHoJTrialLimit.setToolTipText(
				"Local exploration trials number for the Trace Sequence Coverage");
		addFieldEditor( fHoJTrialLimit );

		// HIT or JUMP Heuristic
		groupHitOrJumpHeuristic = widgetToolkit.createGroup(groupOptionSelectionHeuristic,
				"&Hit or Jump Selection Count ", 1, 1, GridData.FILL_BOTH);

		comp = widgetToolkit.createComposite(
				groupHitOrJumpHeuristic, 1, 1, GridData.FILL_HORIZONTAL);


		// Number of paths to choose from HIT
		fHoJHitCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT,
				"&Hit : ", comp, 1);
		fHoJHitCount.setToolTipText(
				"Number of paths to choose when HIT (i.e. new properties have been covered)");
		addFieldEditor( fHoJHitCount );

		// Number of paths to choose from JUMP
		fHoJJumpCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT,
				"&Jump : ", comp, 1);
		fHoJJumpCount.setToolTipText(
				"Number of paths to choose when JUMP (i.e. no new property covered)");
		addFieldEditor( fHoJJumpCount );
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT,
				DEFAULT_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT);

		configuration.setAttribute(
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT, -1);

		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT, 1);

		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT, 1);

		configuration.setAttribute(
				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST,
				BEHAVIOR_INITIAL_SAMPLE);
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
		// Exploration Heuristic Validation
		if( ! fHoJLocalHeight.isValid() ) {
			setErrorMessage("Jump Height is not a valid integer");
			return false;
		}
		if( ! fHoJTrialLimit.isValid() ) {
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
