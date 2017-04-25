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
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.FieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.Composite;

public class OverviewWorkspaceDataSection extends AbstractConfigurationSection {

	public OverviewWorkspaceDataSection(
			AbstractConfigurationPage configurationPage,
			Composite parent, ToolBarManager toolBarManager)
	{
		super(configurationPage, parent, toolBarManager);
	}


	@Override
	public String getSectionTitle() {
		return "Workspace Data";
	}

	@Override
	public String getSectionDescription() {
		return "Enter forlders name for workspace configuration";
	}

	
	private FieldEditor[] contentFieldEdit;

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		String root =  ResourcesPlugin.getWorkspace().getRoot()
				.getLocation().append( "<project-folder-name>" ).toString();

		String toolTipText = "Name of the subfolder in the root and output folders";
		String toolTipText2 = "Name of the subfolder in the root folder";
		String toolTipText3 = "Name of the subfolder in the output folder";
		setToolTipText(toolTipText);

		StringFieldEditor fWorkspaceRootLocationStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_ROOT_LOCATION, "Location", parent, root);
		fWorkspaceRootLocationStringField.setEnabled(false);
		fWorkspaceRootLocationStringField.setToolTipText(toolTipText2);

		StringFieldEditor fWorkspaceOuputFolderNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_OUTPUT_FOLDER_NAME, "Output", parent,
						DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME);
		fWorkspaceOuputFolderNameStringField.setToolTipText(toolTipText2);

		StringFieldEditor fWorkspaceLogFolderNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_LOG_FOLDER_NAME, "Log",
						parent, DEFAULT_WORKSPACE_LOG_FOLDER_NAME);
		fWorkspaceLogFolderNameStringField.setToolTipText(toolTipText3);

		StringFieldEditor fWorkspaceDebugFolderNameStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_DEBUG_FOLDER_NAME, "Debug",
						parent, DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME);
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
