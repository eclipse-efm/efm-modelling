/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.api;


import org.eclipse.efm.execution.configuration.common.ui.editors.FieldEditor;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;

public abstract class AbstractConfigurationSection extends AbstractSectionPart
		implements IWorkflowConfigurationConstants {

	protected AbstractConfigurationPage fConfigurationPage;

	public AbstractConfigurationSection(AbstractConfigurationPage configurationPage,
			Composite parent, ToolBarManager toolBarManager)
	{
		this.fConfigurationPage = configurationPage;

		this.initialize(parent, toolBarManager);
	}

	public AbstractConfigurationPage getConfigurationPage() {
		return fConfigurationPage;
	}

	public void initialize(Composite parent, IToolBarManager toolBarManager) {
		IWidgetToolkit toolkit = fConfigurationPage.getWidgetToolkit();
		
		toolkit.createSectionPart(this, parent,
				Section.TITLE_BAR | Section.DESCRIPTION |
				Section.EXPANDED  | Section.TWISTIE, toolBarManager);
		
		createContent(getSectionClient(), fConfigurationPage.getWidgetToolkit());
	}


    /**
     * Sets the label control's tool tip text to the argument
     */
    public void setToolTipText(String string) {
//    	section.setToolTipText(string);
    }


	protected abstract void createContent(Composite parent, IWidgetToolkit widgetToolkit);

	public abstract FieldEditor[] getFieldEditors();

}
