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
package org.eclipse.efm.execution.configuration.common.ui.page.overview;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationSection;
import org.eclipse.efm.execution.configuration.common.ui.editors.FieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.Composite;

public class OverviewWorkspaceSection extends AbstractConfigurationSection {
	
	public OverviewWorkspaceSection(
			AbstractConfigurationPage configurationPage,
			ToolBarManager tbm, Composite innertabcompo)
	{
		super(configurationPage, tbm, innertabcompo);
	}
	
	@Override
	public void addComposite(Composite innertabcompo, IToolBarManager tbm) {
		addComposite_internal(innertabcompo, tbm, "Workspace Folder Name");
	}

	private FieldEditor[] contentFieldEdit;
	
	@Override
	protected void addCollapsedContent() {
		String root =  ResourcesPlugin.getWorkspace().getRoot()
				.getLocation().append( "<project-folder-name>" ).toString();

		String toolTipText = "Name of the subfolder in the root and output folders";
		String toolTipText2 = "Name of the subfolder in the root folder";
		String toolTipText3 = "Name of the subfolder in the output folder";
		setToolTipText(toolTipText);

		StringFieldEditor fWorkspaceRootLocationStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_ROOT_LOCATION, "Root", sectionClient, root);
		fWorkspaceRootLocationStringField.setEnabled(false);
		fWorkspaceRootLocationStringField.setToolTipText(toolTipText2);

		StringFieldEditor fWorkspaceOuputFolderNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_OUTPUT_FOLDER_NAME, "Output", sectionClient,
						DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME);
		fWorkspaceOuputFolderNameStringField.setToolTipText(toolTipText2);

		StringFieldEditor fWorkspaceLogFolderNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_LOG_FOLDER_NAME, "Log",
						sectionClient, DEFAULT_WORKSPACE_LOG_FOLDER_NAME);
		fWorkspaceLogFolderNameStringField.setToolTipText(toolTipText3);

		StringFieldEditor fWorkspaceDebugFolderNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_DEBUG_FOLDER_NAME, "Debug",
						sectionClient, DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME);
		fWorkspaceDebugFolderNameStringField.setToolTipText(toolTipText3);
		
		contentFieldEdit = new FieldEditor[]{
				fWorkspaceRootLocationStringField,
				fWorkspaceOuputFolderNameStringField,
				fWorkspaceLogFolderNameStringField,
				fWorkspaceDebugFolderNameStringField
			};
	}

	@Override
	public FieldEditor[] getFieldEditors() {
		return contentFieldEdit;
	}
}
