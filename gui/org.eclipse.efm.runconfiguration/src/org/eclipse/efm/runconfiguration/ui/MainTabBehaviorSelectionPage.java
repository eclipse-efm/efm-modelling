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

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.ui.views.editors.impls.StringFieldEditor;
import org.eclipse.efm.ui.views.utils.SWTFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class MainTabBehaviorSelectionPage extends AbstractTabComponentPage {

	private StringFieldEditor fBehaviorSpecificationStringField;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public MainTabBehaviorSelectionPage(
			AbstractSewLaunchConfigurationTab parentTab) {
		super(parentTab);
	}

	public void createControl(Composite parent) {
		fCompositeParent = parent;

		fCompositeControl = SWTFactory.createGroup(parent,
				"&Behavior Characterization", 1, 1, GridData.FILL_HORIZONTAL);
		fCompositeControl.setToolTipText(BEHAVIOR_DESCRIPTION);

//		compModelAnalysisBehavior = SWTFactory.createComposite(parent, 1, 1,
//				GridData.FILL_HORIZONTAL);
//		GridData gridData1 = new GridData(GridData.FILL_HORIZONTAL);
//		gridData1.horizontalIndent = DETAIL_HORIZONTAL_INDENT;
//		compModelAnalysisBehavior.setLayoutData(gridData1);

		Composite comp2 = SWTFactory.createComposite(
				fCompositeControl, 1, 1, GridData.FILL_HORIZONTAL);
		fBehaviorSpecificationStringField = new StringFieldEditor(fParentTab,
				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST, "",
				comp2, BEHAVIOR_DESCRIPTION, SWT.MULTI);

		fBehaviorSpecificationStringField.setToolTipText(BEHAVIOR_DESCRIPTION);
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST,
				BEHAVIOR_INITIAL_SAMPLE);

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		fBehaviorSpecificationStringField.initializeFrom(configuration);

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		fBehaviorSpecificationStringField.performApply(configuration);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
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
