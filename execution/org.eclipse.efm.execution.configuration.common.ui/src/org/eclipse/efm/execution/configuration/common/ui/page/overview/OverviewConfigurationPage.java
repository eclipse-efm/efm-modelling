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
package org.eclipse.efm.execution.configuration.common.ui.page.overview;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class OverviewConfigurationPage extends AbstractConfigurationPage {

	/////////////////////////////////////
	// MODEL SELECTION
	/////////////////////////////////////

	private IProject fProject;

    private Text fModelPathText;
    private Button fModelWorkspaceBrowse;

	private String fOldModelPathLocation;


	/////////////////////////////////////
	// WORKSPACE // DEVELOPER MODE
	/////////////////////////////////////

    OverviewWorkspaceDataSection fOverviewWorkspaceDataSection;

	/////////////////////////////////////
	// ANALYSIS PROFILE
	/////////////////////////////////////

	OverviewAnalysisProfileSection fAnalysisProfileSection;


	public OverviewConfigurationPage(final ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);

		fAnalysisProfileSection = new OverviewAnalysisProfileSection(this);

		fOverviewWorkspaceDataSection = new OverviewWorkspaceDataSection(this);

		fOldModelPathLocation = null;
	}

	@Override
	public String getSectionTitle() {
		return "Overview";
	}

	@Override
	public String getSectionDescription() {
		return "Overview";
	}


	/**
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(final ModifyEvent evt) {
			propagateUpdateJobScheduling();

			final String absoluteLocation =
					WorkflowFileUtils.makeAbsoluteLocation(
							fModelPathText.getText());

			if( ! absoluteLocation.equals(fOldModelPathLocation) ) {
		        propertyChange( new PropertyChangeEvent(this,
		        		ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
		        		fOldModelPathLocation, absoluteLocation) );

		        fOldModelPathLocation = absoluteLocation;
			}
		}
	};

	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(final Composite parent, final IWidgetToolkit widgetToolkit)
	{
		createModelFileSelectionComponent(parent, widgetToolkit);

		fOverviewWorkspaceDataSection.createControl(parent, widgetToolkit);
		fOverviewWorkspaceDataSection.setExpanded(false);

		fAnalysisProfileSection.createControl(parent, widgetToolkit);
	}


	/**
	 * Creates the component set for the capture output composite
	 * @param parent the parent to add this component to
	 */
	private void createModelFileSelectionComponent(
			final Composite parent, final IWidgetToolkit widgetToolkit)
	{
		final Group group  = widgetToolkit.createGroup(parent,
				"&Model File Selection", 1, 1, GridData.FILL_HORIZONTAL);

		final Composite comp = widgetToolkit.createComposite(group, 3, 1, GridData.FILL_HORIZONTAL);

		fModelPathText = widgetToolkit.createText(comp,
				SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL,
				1, GridData.FILL_HORIZONTAL);
		fModelPathText.getAccessible().addAccessibleListener(
				new AccessibleAdapter() {
					@Override
					public void getName(final AccessibleEvent e) {
						e.result = "Model File";
					}
				} );

		fModelWorkspaceBrowse = widgetToolkit.createPushButton(comp, "&Workspace...", null);

		fModelPathText.addModifyListener(fBasicModifyListener);

		fModelWorkspaceBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final IResource resource = handleModelWorkspaceBrowse(parent);

				if(resource != null) {
					fProject = resource.getProject();

					fModelPathText.setText(
							WorkflowFileUtils.makeRelativeLocation(
									resource.getLocation()));
					fModelPathText.setToolTipText(
							resource.getLocation().toString());

					fOverviewWorkspaceDataSection.updateWorkspaceRootPath(resource);
				}
			}
		});
	}

	private IResource handleModelWorkspaceBrowse(final Composite parent) {
		final ElementTreeSelectionDialog dialog =
				new ElementTreeSelectionDialog(
						parent.getShell(),
						new WorkbenchLabelProvider(),
						new WorkbenchContentProvider() );
		dialog.setTitle("Select a Diversity Specification");
		dialog.setMessage("Select a resource to redirect output to:");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.setComparator(
				new ResourceComparator(ResourceComparator.NAME));
//		dialog.setDialogBoundsSettings(
//				getDialogBoundsSettings(WORKSPACE_SELECTION_DIALOG),
//				Dialog.DIALOG_PERSISTSIZE);
		if(dialog.open() == Window.OK) {
			return (IResource) dialog.getFirstResult();
		}
		return null;
	}

	private IResource handleModelWorkspaceBrowse2(final Composite parent) {
		final IWorkspaceRoot rootElement =
				ResourcesPlugin.getWorkspace().getRoot();

//		getSite().getWorkbenchWindow().getSelectionService()

		final ResourceSelectionDialog dialog =
				new ResourceSelectionDialog(parent.getShell(),
						rootElement, "Select a xLIA file resource");

		final int ret = dialog.open();
        if( ret == ResourceSelectionDialog.OK ) {
    		final Object[] results = dialog.getResult();
    		if( (results != null) && (results.length > 0)
    			&& (results[0] instanceof IFile) )
    		{
    			final IFile file = (IFile)( results[0] );

				return file;
			}
		}
		return null;
	}


	private IResource handleModelWorkspaceBrowse3(final Composite parent) {
		IResource[] rootElement = new IResource[0];
		try {
			rootElement = ResourcesPlugin.getWorkspace().getRoot().members();
		} catch (final CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		getSite().getWorkbenchWindow().getSelectionService()

		final ResourceListSelectionDialog  dialog =
				new ResourceListSelectionDialog (parent.getShell(),
						rootElement);//, "Select a xLIA file resource");

		final int ret = dialog.open();
        if( ret == ResourceSelectionDialog.OK ) {
    		final Object[] results = dialog.getResult();
    		if( (results != null) && (results.length > 0)
    			&& (results[0] instanceof IFile) )
    		{
    			final IFile file = (IFile)( results[0] );

				return file;
			}
		}
		return null;
	}

	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultsImpl(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_LOCATION,
				DEFAULT_SPECIFICATION_PROJECT_LOCATION);

		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME,
				DEFAULT_SPECIFICATION_PROJECT_NAME);

		// MODEL SELECTION
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
				DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);

		// WORKSPACE DATA
		fOverviewWorkspaceDataSection.setDefaults(configuration);

		// ANALYSIS PROFILE
		fAnalysisProfileSection.setDefaults(configuration);
	}

	@Override
	public void initializeFromImpl(final ILaunchConfiguration configuration) {
		final String specMainFileLocation =
				WorkflowFileUtils.getRelativeLocation(configuration,
						ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
						DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);
		fModelPathText.setText( specMainFileLocation );

		fModelPathText.setToolTipText(
				WorkflowFileUtils.makeAbsoluteLocation(specMainFileLocation));

		// WORKSPACE DATA
		fOverviewWorkspaceDataSection.initializeFrom(configuration);

		// ANALYSIS PROFILE
		fAnalysisProfileSection.initializeFrom(configuration);
	}


	@Override
	public void performApplyImpl(final ILaunchConfigurationWorkingCopy configuration) {
		if( fProject != null ) {
			WorkflowFileUtils.setRelativeLocation(configuration,
					ATTR_SPECIFICATION_PROJECT_LOCATION,
					fProject.getLocation().toString());

			configuration.setAttribute(
					ATTR_SPECIFICATION_PROJECT_NAME, fProject.getName());
		}

		WorkflowFileUtils.setRelativeLocation(configuration,
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION, fModelPathText.getText());

		// WORKSPACE DATA
		fOverviewWorkspaceDataSection.performApply(configuration);

		// ANALYSIS PROFILE
		fAnalysisProfileSection.performApply(configuration);
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValidImpl(final ILaunchConfiguration launchConfig) {
		String messageToSend = null;

		final String filePath = WorkflowFileUtils.makeAbsoluteLocation(
				fModelPathText.getText() );
		if( (filePath == null) || filePath.isEmpty() ) {
			messageToSend = "The resource model file path is empty (or null)";
		}
		else {
			final File aFile = new File(filePath);
			if( ! aFile.exists() ) {
				messageToSend="The resource model file \"" +
						filePath + "\" does not exist.";
			}
			else if( ! aFile.isFile() ) {
				messageToSend = "The resource model \"" +
						filePath + "\" is not a file.";
			}
		}

		// ANALYSIS PROFILE
		final boolean isValid = fOverviewWorkspaceDataSection.isValid(launchConfig)
				&& fAnalysisProfileSection.isValid(launchConfig);

		return new FieldValidationReturn(isValid, messageToSend);
	}


	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	public void handleConfigurationPropertyChange(final PropertyChangeEvent event) {
		fOverviewWorkspaceDataSection.handleConfigurationPropertyChange(event);

		fAnalysisProfileSection.handleConfigurationPropertyChange(event);

		getMasterGUIelement().handleConfigurationPropertyChange(event);
	}

}
