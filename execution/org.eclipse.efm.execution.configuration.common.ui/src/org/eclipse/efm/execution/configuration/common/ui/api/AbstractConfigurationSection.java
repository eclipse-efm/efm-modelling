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
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public abstract class AbstractConfigurationSection implements IWorkflowConfigurationConstants {
	
	protected AbstractConfigurationPage fConfigurationPage;
	
	public Section section;
	protected Composite sectionClient;
	
	public AbstractConfigurationSection(AbstractConfigurationPage configurationPage,
			ToolBarManager tbm, Composite innertabcompo)
	{
		this.fConfigurationPage = configurationPage;
		
		this.addComposite(innertabcompo, tbm);
	}
	
	public abstract void addComposite(Composite innertabcompo, IToolBarManager tbm);
	
	protected void addComposite_internal(Composite innertabcompo, IToolBarManager tbm, String title) {
		FormToolkit toolkit = fConfigurationPage.getMasterFormToolkit();
		section = toolkit.createSection(innertabcompo,
				Section.DESCRIPTION|Section.TWISTIE|Section.TITLE_BAR|Section.EXPANDED);
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		section.setLayoutData(gd);
		section.setText(title);
		
		if (tbm != null) {
			ToolBar toolbar = ((ToolBarManager) tbm).createControl(section);
			section.setTextClient(toolbar);
		}
		sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout());
		
		addCollapsedContent();
		
		section.setClient(sectionClient);
	}
	
	public void requestLayout() {
		section.layout();
		section.requestLayout();
	}
	
    /**
     * Sets the label control's tool tip text to the argument
     */
    public void setToolTipText(String string) {
//    	section.setToolTipText(string);
    }

	
	protected abstract void addCollapsedContent();
	
	public abstract FieldEditor[] getFieldEditors();
	
}
