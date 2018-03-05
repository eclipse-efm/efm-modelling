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

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationSection;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.IntegerFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class SupervisorGraphSizeLimitsSection extends AbstractConfigurationSection {

	
	public SupervisorGraphSizeLimitsSection(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Graph size limits";
	}


	@Override
	public String getSectionDescription() {
		return "Graph size limits";
	}


	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{	
        IntegerFieldEditor integerField = new IntegerFieldEditor(fConfigurationPage,
				ATTR_SPECIFICATION_STOP_CRITERIA_NODE, "&Nodes :", parent, -1);
		integerField.setToolTipText("Maximal number of nodes "
				+ "(-1 <=> no-limit) of the symbolic execution tree");
		addField( integerField );

		integerField = new IntegerFieldEditor(fConfigurationPage,
				ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH, "W&idth :", parent, -1);
		integerField.setToolTipText(
				"Maximal width (-1 <=> no-limit) of the symbolic execution tree");
		addField( integerField );

		integerField = new IntegerFieldEditor(fConfigurationPage,
				ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT, "&Height :", parent, 100);
		integerField.setToolTipText(
				"Maximal height (-1 <=> no-limit) of the symbolic execution tree");
		addField( integerField );
	}


	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_NODE, -1);

		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH, -1);

		configuration.setAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT, -1);
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
		return( true );
	}


}
