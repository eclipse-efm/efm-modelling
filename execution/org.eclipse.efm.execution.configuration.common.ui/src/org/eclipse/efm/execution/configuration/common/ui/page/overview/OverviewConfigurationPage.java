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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.util.GenericCompositeCreator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
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
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class OverviewConfigurationPage extends AbstractConfigurationPage {

	/////////////////////////////////////
	// MODEL SELECTION
	/////////////////////////////////////

	private String fProjectName;
    private Text fModelPathText;
    private Button fModelWorkspaceBrowse;

	/////////////////////////////////////
	// WORKSPACE // DEVELOPER MODE
	/////////////////////////////////////

    OverviewWorkspaceDataSection fOverviewWorkspaceDataSection;

	/////////////////////////////////////
	// ANALYSIS PROFILE
	/////////////////////////////////////

	OverviewAnalysisProfileSection fAnalysisProfileSection;


	public OverviewConfigurationPage(ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);
		
		fAnalysisProfileSection = new OverviewAnalysisProfileSection(this);
		
		fOverviewWorkspaceDataSection = new OverviewWorkspaceDataSection(this);
	}


	public String getModelPathText() {
		return fModelPathText.getText();
	}


	/**
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent evt) {
			propagateUpdateJobScheduling();

			fAnalysisProfileSection.handleModelFileChange();
		}
	};

	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		createModelFileSelectionComponent(parent, widgetToolkit);
		createWorkspaceComponent(parent, widgetToolkit);
		createAnalyseProfileComponent(parent, widgetToolkit);
	}


	/**
	 * Creates the component set for the capture output composite
	 * @param parent the parent to add this component to
	 */
	private void createModelFileSelectionComponent(
			Composite parent, IWidgetToolkit widgetToolkit)
	{
//		FormToolkit toolkit = getMasterFormToolkit();
//		fModelWorkspaceBrowse = GenericCompositeCreator.createComposite_label_pushbutton_from_toolkit(
//				toolkit, parent, "Model File Selection", "&Workspace...", 2);
//
//		fModelPathText = toolkit.createText(parent, "", SWT.NONE);
//		fModelPathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		fModelPathText.getAccessible().addAccessibleListener(new AccessibleAdapter() {
//			@Override
//			public void getName(AccessibleEvent e) {
//				e.result = "Model File";
//			}
//		});


		Group group  = widgetToolkit.createGroup(parent,
				"&Model File Selection", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(group, 3, 1, GridData.FILL_HORIZONTAL);

		fModelPathText = widgetToolkit.createSingleText(comp, 1);
		fModelPathText.getAccessible().addAccessibleListener(
				new AccessibleAdapter() {
					@Override
					public void getName(AccessibleEvent e) {
						e.result = "Model File";
					}
				} );

		fModelWorkspaceBrowse = widgetToolkit.createPushButton(comp, "&Workspace...");

		fModelPathText.addModifyListener(fBasicModifyListener);

		fModelWorkspaceBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementTreeSelectionDialog dialog =
						new ElementTreeSelectionDialog(
								parent.getShell(),
								new WorkbenchLabelProvider(),
								new WorkbenchContentProvider() );
				dialog.setTitle("Select a Diversity Specification:");
				dialog.setMessage("Select a resource to redirect output to:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.setComparator(
						new ResourceComparator(ResourceComparator.NAME));
//				dialog.setDialogBoundsSettings(
//						getDialogBoundsSettings(WORKSPACE_SELECTION_DIALOG),
//						Dialog.DIALOG_PERSISTSIZE);
				if(dialog.open() == Window.OK) {
					IResource resource = (IResource) dialog.getFirstResult();
					if(resource != null) {
						fProjectName = resource.getProject().getName();

						String specFile = resource.getLocation().toString();
						fModelPathText.setText(specFile);

						fOverviewWorkspaceDataSection.updateWorkspaceRootPath(resource);
					}
				}
			}
		});

	}


	protected void createWorkspaceComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		Action[] toputinbar = getActionsByStringKey(new String[]{"action_apply_changes"});
		GenericCompositeCreator.fillToolBar(toolBarManager, toputinbar);

		fOverviewWorkspaceDataSection.createControl(parent, toolBarManager, widgetToolkit);
	}

	protected void createAnalyseProfileComponent(Composite parent, IWidgetToolkit widgetToolkit) {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		Action[] toputinbar = getActionsByStringKey(new String[]{"action_apply_changes"});
		GenericCompositeCreator.fillToolBar(toolBarManager, toputinbar);
		
		fAnalysisProfileSection.createControl(parent, toolBarManager, widgetToolkit);
	}


	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, "<project-name>");

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
	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		try {
			fProjectName = configuration.getAttribute(
					ATTR_SPECIFICATION_PROJECT_NAME, "");
			
			String specMainFileLocation = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
					DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);
			fModelPathText.setText( specMainFileLocation );
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		
		// WORKSPACE DATA
		fOverviewWorkspaceDataSection.initializeFrom(configuration);

		// ANALYSIS PROFILE
		fAnalysisProfileSection.initializeFrom(configuration);
	}


	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, fProjectName);

		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
				fModelPathText.getText());

		// WORKSPACE DATA
		fOverviewWorkspaceDataSection.performApply(configuration);

		// ANALYSIS PROFILE
		fAnalysisProfileSection.performApply(configuration);
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		String messageToSend = null;

		String filePath = fModelPathText.getText();
		if( (filePath == null) || filePath.isEmpty() ) {
			messageToSend = "The resource model file path is empty (or null)";
		}
		else {
			File aFile = new File(filePath);
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
		boolean isValid = fOverviewWorkspaceDataSection.isValid(launchConfig)
				&& fAnalysisProfileSection.isValid(launchConfig);

		return new FieldValidationReturn(isValid, messageToSend);
	}


}
