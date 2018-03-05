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
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class OverviewBehaviorSelectionConfigurationProfile extends AbstractConfigurationProfile {

	private Group groupSelectionHeuristic;
	
	private Group groupExplorationHeuristic;

	private IntegerFieldEditor fHoJLocalHeight;
	private IntegerFieldEditor fHoJTrialLimit;
	
	private Group groupHitOrJumpHeuristic;

	private IntegerFieldEditor fHoJHitCount;
	private IntegerFieldEditor fHoJJumpCount;


	private Group groupTraceSequence;

	private StringFieldEditor fBehaviorSpecificationStringField;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewBehaviorSelectionConfigurationProfile(AbstractConfigurationPage configurationPage) {
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
				parent, 1, 1, GridData.FILL_HORIZONTAL);
		
		// Trace Sequence
		groupTraceSequence = widgetToolkit.createGroup(
				container, "&Trace Sequence ", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				groupTraceSequence, 1, 1, GridData.FILL_HORIZONTAL);

		fBehaviorSpecificationStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST, "",
				comp, BEHAVIOR_DESCRIPTION, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		fBehaviorSpecificationStringField.setToolTipText(BEHAVIOR_DESCRIPTION);
		addField(fBehaviorSpecificationStringField);

		
		// Selection Heuristic
		groupSelectionHeuristic = widgetToolkit.createGroup(container,
				"&Exploration && Selection Heuristic ", 2, 1, GridData.FILL_HORIZONTAL);
		
//		comp = widgetToolkit.createComposite(
//				groupSelectionHeuristic, 1, 1, GridData.FILL_HORIZONTAL);
		
		// Exploration Heuristic
		groupExplorationHeuristic = widgetToolkit.createGroup(groupSelectionHeuristic,
				"&Local Exploration Limit ", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				groupExplorationHeuristic, 1, 1, GridData.FILL_HORIZONTAL);

		// Local exploration height before the next selection by HIT or JUMP
		fHoJLocalHeight = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT,
				"&Height :", comp, 6);
		fHoJLocalHeight.setToolTipText(
				"Local exploration height before the next selection by HIT or JUMP");
		addField( fHoJLocalHeight );

		// Local exploration trials number
		fHoJTrialLimit = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT,
				"&Trials :", comp, -1);
		fHoJTrialLimit.setToolTipText(
				"Local exploration trials number for the Trace Sequence Coverage");
		addField( fHoJTrialLimit );

		// HIT or JUMP Heuristic
		groupHitOrJumpHeuristic = widgetToolkit.createGroup(groupSelectionHeuristic,
				"&Hit or Jump Selection Count ", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				groupHitOrJumpHeuristic, 1, 1, GridData.FILL_HORIZONTAL);
		
		
		// Number of paths to choose from HIT
		fHoJHitCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT,
				"&Hit :", comp, 1);
		fHoJHitCount.setToolTipText(
				"Number of paths to choose when HIT (i.e. new properties have been covered)");
		addField( fHoJHitCount );
		
		// Number of paths to choose from JUMP
		fHoJJumpCount = new IntegerFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT,
				"&Jump :", comp, 1);
		fHoJJumpCount.setToolTipText(
				"Number of paths to choose when JUMP (i.e. no new property covered)");
		addField( fHoJJumpCount );
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT, 6);

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

		// Trace Sequence Validation
		String[] tabString = fBehaviorSpecificationStringField
				.getStringValue().split(";\n");

		String kind;
		int pos;

		for(String eltString : tabString) {
			eltString = eltString.trim();

			if( eltString.length() == 0 ) {
				setErrorMessage("You must select at least one element");
				return false;
			}
			else if( eltString.startsWith("//") ) {
				//!! COMMENT
			}
			else if( (pos = eltString.indexOf('=')) > 0 ) {
				kind = eltString.substring(0, pos).trim();
//				object = eltString.substring(pos+1).trim();

				if( kind.equals( "transition" ) ) {
					// Check if the object is a transition and exists !
				}
				else if( kind.equals( "state" ) ) {
					// Check if the object is a state and exists !
				}

				else if( kind.equals( "input" ) ) {
					// Check if the object is an input port/signal and exists !
				}
				else if( kind.equals( "output" ) ) {
					// Check if the object is an output port/signal and exists !
				}

				else if( kind.equals( "inout" ) ) {
					// Check if the object is an inout port/signal and exists !
				}
				else if( kind.equals( "com" ) ) {
					// Check if the object is a communicated port/signal and exists !
				}

				else {
					setErrorMessage("The element \"" +
						eltString + "\" is not a valid element");
					return false;
				}
			}
			else {
				setErrorMessage("The element \"" +
					eltString + "\" is not a valid element");
				return false;
			}
		}

		return true;
	}


}
