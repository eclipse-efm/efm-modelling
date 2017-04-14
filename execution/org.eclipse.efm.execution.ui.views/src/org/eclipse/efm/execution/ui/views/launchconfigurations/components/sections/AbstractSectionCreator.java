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
package org.eclipse.efm.execution.ui.views.launchconfigurations.components.sections;


import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.ui.views.editors.FieldEditor;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationEditorComposite;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public abstract class AbstractSectionCreator implements IWorkflowConfigurationConstants {
	
	public Section section;
	protected Composite sectionClient;
	protected ILaunchConfigurationEditorComposite fLaunchConfCommInt;
	protected ILaunchConfigurationGUIelement guielt;
	
	public AbstractSectionCreator(ILaunchConfigurationGUIelement guielt, 
			ILaunchConfigurationEditorComposite fLaunchConfCommInt, ToolBarManager tbm, Composite innertabcompo) {
		this.fLaunchConfCommInt = fLaunchConfCommInt;
		this.guielt = guielt;
		this.addComposite(innertabcompo, tbm);
	}
	
	public abstract void addComposite(Composite innertabcompo, IToolBarManager tbm);
	
	protected void addComposite_internal(Composite innertabcompo, IToolBarManager tbm, String title) {
		FormToolkit toolkit = guielt.getFormToolkit();
		section = toolkit.createSection(innertabcompo, Section.DESCRIPTION|Section.TWISTIE|Section.TITLE_BAR|Section.EXPANDED);
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		section.setLayoutData(gd);
		section.setText(title);
		
		if (tbm != null) {
			ToolBar toolbar = ((ToolBarManager) tbm).createControl(section);
			section.setTextClient(toolbar);
		}
		sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout());
		addCollapsedContent(toolkit);
		section.setClient(sectionClient);
	}
	
	protected abstract void addCollapsedContent(FormToolkit toolkit);
	
	public abstract FieldEditor[] getFieldEditors();
	
}
