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
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class OverviewBehaviorSelectionConfigurationProfile extends AbstractConfigurationProfile {

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

		fBehaviorSpecificationStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST, "",
				parent, BEHAVIOR_DESCRIPTION, SWT.MULTI);

		fBehaviorSpecificationStringField.setToolTipText(BEHAVIOR_DESCRIPTION);

//		compModelAnalysisBehavior = SWTFactory.createComposite(parent, 1, 1,
//		GridData.FILL_HORIZONTAL);
//		GridData gridData1 = new GridData(GridData.FILL_HORIZONTAL);
//		gridData1.horizontalIndent = DETAIL_HORIZONTAL_INDENT;
//		compModelAnalysisBehavior.setLayoutData(gridData1);
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
