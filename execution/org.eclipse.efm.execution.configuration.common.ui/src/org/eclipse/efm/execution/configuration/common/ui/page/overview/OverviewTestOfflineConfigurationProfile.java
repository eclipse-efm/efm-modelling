/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.page.overview;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.StringFieldEditor;
import org.eclipse.efm.execution.core.Activator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
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
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class OverviewTestOfflineConfigurationProfile extends AbstractConfigurationProfile {

	/////////////////////////////////////
	// TEST OFFLINE // INCUBATION MODE
	/////////////////////////////////////

    private Text fTracePathText;
	private Button fTraceWorkspaceBrowse;

    private Text fTestPurposePathText;
	private Button fTestPurposeWorkspaceBrowse;

	private BooleanFieldEditor fEnabledTraceConfigurationBooleanField;

	private Group fGroupObservable;
	private Group fGroupControllable;

	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewTestOfflineConfigurationProfile(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}

	/**
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent evt) {
			fConfigurationPage.propagateUpdateJobScheduling();
		}
	};

	/**
	 * Returns the {@link IDialogSettings} for the given id
	 *
	 * @param id the id of the dialog settings to get
	 * @return the {@link IDialogSettings} to pass into the {@link ContainerSelectionDialog}
	 * @since 3.6
	 */
	IDialogSettings getDialogBoundsSettings(String id) {
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		IDialogSettings section = settings.getSection(id);
		if(section == null) {
			section = settings.addNewSection(id);
		}
		return section;
	}


	@Override
	public String getSectionTitle() {
		return "Offline Testing";
	}

	@Override
	public String getSectionDescription() {
		return "Offline Testing, configuration section";
	}

	
	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit) {
//		SWTFactory.createGroup(
//				parent, "&Offline Testing Configuration",
//				1, 1, GridData.FILL_HORIZONTAL);

		Group group  = widgetToolkit.createGroup(parent,
				"&Trace File Selection", 1, 1, GridData.FILL_HORIZONTAL);

		Composite comp = widgetToolkit.createComposite(
				group, 3, 1, GridData.FILL_HORIZONTAL);

		fTracePathText = widgetToolkit.createSingleText(comp, 1);
		fTracePathText.getAccessible().addAccessibleListener(
				new AccessibleAdapter() {
					@Override
					public void getName(AccessibleEvent e) {
						e.result = "Trace File";
					}
				} );
		fTracePathText.addModifyListener(fBasicModifyListener);

		fTraceWorkspaceBrowse =
				widgetToolkit.createPushButton(comp, "&Workspace...");
		fTraceWorkspaceBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementTreeSelectionDialog dialog =
						new ElementTreeSelectionDialog(
								fCompositeParent.getShell(),
								new WorkbenchLabelProvider(),
								new WorkbenchContentProvider() );
				dialog.setTitle("Select a Resource:");
				dialog.setMessage("Select a resource to redirect output to:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.setComparator(
						new ResourceComparator(ResourceComparator.NAME));
				dialog.setDialogBoundsSettings(
						getDialogBoundsSettings(WORKSPACE_SELECTION_DIALOG),
						Dialog.DIALOG_PERSISTSIZE);
				if(dialog.open() == Window.OK) {
					IResource resource = (IResource) dialog.getFirstResult();
					if(resource != null) {
						String arg = resource.getLocation().toString();
						fTracePathText.setText(arg);
					}
				}
			}
		});

		// Test Purpose File Selection
		//
		group = widgetToolkit.createGroup(parent,
				"&Test Purpose File Selection", 1, 1, GridData.FILL_HORIZONTAL);

		comp = widgetToolkit.createComposite(
				group, 2, 1, GridData.FILL_HORIZONTAL);
		fTestPurposePathText = widgetToolkit.createSingleText(comp, 1);
		fTestPurposePathText.getAccessible().addAccessibleListener(
				new AccessibleAdapter() {
					@Override
					public void getName(AccessibleEvent e) {
						e.result = "Test Purpose File";
					}
				} );
		fTestPurposePathText.addModifyListener(fBasicModifyListener);

		fTestPurposeWorkspaceBrowse =
				widgetToolkit.createPushButton(comp, "&Workspace...");
		fTestPurposeWorkspaceBrowse.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						ElementTreeSelectionDialog dialog =
								new ElementTreeSelectionDialog(
										fCompositeParent.getShell(),
										new WorkbenchLabelProvider(),
										new WorkbenchContentProvider());
						dialog.setTitle("Select a Resource:");
						dialog.setMessage(
								"Select a resource to redirect output to:");
						dialog.setInput(
								ResourcesPlugin.getWorkspace().getRoot());
						dialog.setComparator(
								new ResourceComparator(
										ResourceComparator.NAME));
						dialog.setDialogBoundsSettings(
								getDialogBoundsSettings(
										WORKSPACE_SELECTION_DIALOG),
								Dialog.DIALOG_PERSISTSIZE);
						if(dialog.open() == Window.OK) {
							IResource resource =
									(IResource) dialog.getFirstResult();
							if(resource != null) {
								String arg = resource.getLocation().toString();
								fTestPurposePathText.setText(arg);
							}
						}
					}
				});


		comp = widgetToolkit.createComposite(
				parent, 1, 1, GridData.FILL_HORIZONTAL);

		fEnabledTraceConfigurationBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION,
						"&Enable Observable / Controllable Configuration",
						comp, false);

		fEnabledTraceConfigurationBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						handleEnablingTraceConfiguration();
					}
				});


		fGroupObservable  = widgetToolkit.createGroup(parent,
				"&Observable", 1, 1, GridData.FILL_HORIZONTAL);
		fGroupObservable.setToolTipText(TEST_OFFLINE_OBSERVABLE);

		StringFieldEditor textStringField =
				new StringFieldEditor(fConfigurationPage,
				ATTR_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
				"", fGroupObservable,
				DEFAULT_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		addField(textStringField);

		fGroupControllable = widgetToolkit.createGroup(parent,
				"&Controllable", 1, 1, GridData.FILL_HORIZONTAL);
		fGroupControllable.setToolTipText(TEST_OFFLINE_CONTROLLABLE);

		textStringField = new StringFieldEditor(fConfigurationPage,
				ATTR_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
				"", fGroupControllable,
				DEFAULT_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
				SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		addField(textStringField);
	}


	private void handleEnablingTraceConfiguration() {
		boolean enabled =
				fEnabledTraceConfigurationBooleanField.getBooleanValue();

		fConfigurationPage.propagateVisibility(fGroupObservable, enabled);
		fConfigurationPage.propagateVisibility(fGroupControllable, enabled);
	}



	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
				DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION);

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
				DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION);

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION, false);

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
				DEFAULT_TEST_OFFLINE_OBSERVABLE_SPECIFICATION);

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
				DEFAULT_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION);
	}


	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration) {
		String traceFile;
		try {
			traceFile = configuration.getAttribute(
					ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
					DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION);
		} catch( CoreException e ) {
			e.printStackTrace();
			traceFile = DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION;
		}
		fTracePathText.setText(traceFile);

		String testPurposeFile;
		try {
			testPurposeFile = configuration.getAttribute(
					ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
					DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION);
		} catch( CoreException e ) {
			e.printStackTrace();
			testPurposeFile = DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION;
		}
		fTestPurposePathText.setText(testPurposeFile);

		handleEnablingTraceConfiguration();
	}

	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
				fTracePathText.getText());

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
				fTestPurposePathText.getText());
	}


	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {

		String filePath = fTracePathText.getText();

		if( (filePath == null) || filePath.isEmpty() ) {
			setWarningMessage("The ressource Test Offline trace "
					+ "file path is empty (or null)");

			return false;
		}
		else if( ! ( new File(filePath) ).exists() ) {
			setWarningMessage("The ressource Test Offline trace "
					+ "file \"" + filePath + "\" does not exist.");

			return false;
		}

		
		filePath = fTestPurposePathText.getText();

		if( (filePath == null) || filePath.isEmpty() ) {
			setWarningMessage("The ressource Test Offline test "
					+ "purpose file path is empty (or null)");

			return false;
		}
		else if( filePath.equals(
				DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION) ) {
			//!! NOTHING
		}
		else if( ! ( new File(filePath) ).isFile() ) {
			setWarningMessage("The ressource Test Offline test "
					+ "purpose file \"" + filePath + "\" does not exist.");

			return false;
		}

		return true;
	}


}
