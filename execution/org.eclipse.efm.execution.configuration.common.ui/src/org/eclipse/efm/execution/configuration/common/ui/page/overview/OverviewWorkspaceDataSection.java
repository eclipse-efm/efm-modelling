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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationSection;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class OverviewWorkspaceDataSection extends AbstractConfigurationSection {

	private StringFieldEditor fWorkspaceRootLocationStringField;
	
	private StringFieldEditor fWorkspaceOutputLocationStringField;

	
	public OverviewWorkspaceDataSection(AbstractConfigurationPage configurationPage)
	{
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Workspace Data";
	}

	@Override
	public String getSectionDescription() {
		return "Enter forlders name for workspace configuration";
	}

	
	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		String root =  ResourcesPlugin.getWorkspace().getRoot()
				.getLocation().append( "<project-folder-name>" ).toString();

		String toolTipText = "Name of the subfolder in the root and output folders";
		String toolTipText2 = "Name of the subfolder in the root folder";
		String toolTipText3 = "Name of the subfolder in the output folder";
		setToolTipText(toolTipText);

		fWorkspaceRootLocationStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_ROOT_LOCATION, "Location", parent, root);
		fWorkspaceRootLocationStringField.setEnabled(false);
		fWorkspaceRootLocationStringField.setToolTipText(toolTipText2);
		fWorkspaceRootLocationStringField.setEmptyStringAllowed(false);
		addField(fWorkspaceRootLocationStringField);

		fWorkspaceOutputLocationStringField =
				new StringFieldEditor(fConfigurationPage,
						ATTR_WORKSPACE_OUTPUT_FOLDER_NAME, "Output", parent,
						DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME);
		fWorkspaceOutputLocationStringField.setToolTipText(toolTipText2);
		addField(fWorkspaceOutputLocationStringField);
		fWorkspaceOutputLocationStringField.setEmptyStringAllowed(false);

		if( getConfigurationPage().isEnabledSymbexDeveloperMode() ) {
			StringFieldEditor folderNameStringFieldEditor =
					new StringFieldEditor(fConfigurationPage,
							ATTR_WORKSPACE_LOG_FOLDER_NAME, "Log",
							parent, DEFAULT_WORKSPACE_LOG_FOLDER_NAME);
			folderNameStringFieldEditor.setToolTipText(toolTipText3);
			addField(folderNameStringFieldEditor);
			folderNameStringFieldEditor.setEmptyStringAllowed(false);

			folderNameStringFieldEditor =
					new StringFieldEditor(fConfigurationPage,
							ATTR_WORKSPACE_DEBUG_FOLDER_NAME, "Debug",
							parent, DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME);
			folderNameStringFieldEditor.setToolTipText(toolTipText3);
			addField(folderNameStringFieldEditor);
			folderNameStringFieldEditor.setEmptyStringAllowed(false);
		}
	}

	
	@Override
	public void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		// WORKSPACE // DEVELOPER MODE
		configuration.setAttribute(
				ATTR_WORKSPACE_ROOT_LOCATION,
				DEFAULT_WORKSPACE_ROOT_LOCATION);

		configuration.setAttribute(
				ATTR_WORKSPACE_OUTPUT_FOLDER_NAME,
				DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME);

		if( getConfigurationPage().isEnabledSymbexDeveloperMode() ) {
			configuration.setAttribute(
					ATTR_WORKSPACE_LOG_FOLDER_NAME,
					DEFAULT_WORKSPACE_LOG_FOLDER_NAME);

			configuration.setAttribute(
					ATTR_WORKSPACE_DEBUG_FOLDER_NAME,
					DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME);
		}
	}

	
	public void updateWorkspaceRootPath(IResource resource) {
		final String projectLocation =
				resource.getProject().getLocation().toString();
				
		fWorkspaceRootLocationStringField.setStringValue(
				projectLocation);
		
		updateWorkspaceOutputPath( resource );
	}

	public void updateWorkspaceRootPath(String modelPath) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = new Path(modelPath);
		IResource resource = root.findMember(path);
		if( (resource != null) && resource.exists() ) {
			fWorkspaceRootLocationStringField.setStringValue(
					resource.getProject().getLocation().toString());
			
			if( DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME.equals(
					fWorkspaceOutputLocationStringField.getStringValue()) )
			{
				updateWorkspaceOutputPath( resource );
			}
		}
		else if( root.getLocation().isPrefixOf(path) ) {
			path = root.getLocation().append( path.segment(
					path.matchingFirstSegments( root.getLocation() ) ));
			fWorkspaceRootLocationStringField.setStringValue(path.toString());
		}
		else {
			fWorkspaceRootLocationStringField.setStringValue(
				root.getLocation().append(
						"<project-folder-name>" ).toString() );
		}

		fWorkspaceRootLocationStringField.updateLaunchConfigurationDialog();
	}

	public void updateWorkspaceOutputPath(IResource resource) {
		final IResource parentResource = resource.getParent();
		
		if( (resource instanceof IFile) && (resource.getProject() != parentResource)
			&& fWorkspaceOutputLocationStringField.getStringValue().endsWith(
					DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME)
			&& (! parentResource.getName().endsWith( "src"           ))
			&& (! parentResource.getName().endsWith( "source"        ))
			&& (! parentResource.getName().endsWith( "model"         ))
			&& (! parentResource.getName().endsWith( "spec"          ))
			&& (! parentResource.getName().endsWith( "specification" )) )
		{
			fWorkspaceOutputLocationStringField.setStringValue(
					parentResource.getProjectRelativePath().toString()
					+ IPath.SEPARATOR + DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME);
		}
	}


	@Override
	public void initializeFromImpl(ILaunchConfiguration configuration) {
		try {
			String specMainFileLocation = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
					DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);
			
			updateWorkspaceRootPath( specMainFileLocation );
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		//!! NOTHING
	}


	@Override
	public boolean isValidImpl(ILaunchConfiguration launchConfig) {
		return true;
	}

}
