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
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableConfigProvider;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableViewer;
import org.eclipse.efm.execution.core.Activator;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.window.Window;
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

	private IWidgetToolkit fWidgetToolkit;

    private Text fTracePathText;
	private Button fTraceWorkspaceBrowse;

    private Text fTestPurposePathText;
	private Button fTestPurposeWorkspaceBrowse;

	private Composite fObservableControllableComposite;

	private BooleanFieldEditor fEnabledObservableControllableBooleanField;

	private TraceElementTableViewer fObservableTraceTableViewer;

	private TraceElementTableViewer fControllableTraceTableViewer;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewTestOfflineConfigurationProfile(
			final AbstractConfigurationPage configurationPage)
	{
		super(configurationPage, false);

		this.fWidgetToolkit = null;

		this.fObservableTraceTableViewer = null;

		this.fControllableTraceTableViewer = null;
	}

	/**
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private final ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(final ModifyEvent evt) {
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
	IDialogSettings getDialogBoundsSettings(final String id) {
		final IDialogSettings settings = Activator.getDefault().getDialogSettings();
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
	protected void createContent(final Composite parent, final IWidgetToolkit widgetToolkit) {
		fWidgetToolkit = widgetToolkit;

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
					public void getName(final AccessibleEvent e) {
						e.result = "Trace File";
					}
				} );
		fTracePathText.addModifyListener(fBasicModifyListener);

		fTraceWorkspaceBrowse =
				widgetToolkit.createPushButton(comp, "&Workspace...", null);
		fTraceWorkspaceBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final ElementTreeSelectionDialog dialog =
						new ElementTreeSelectionDialog(
								fCompositeParent.getShell(),
								new WorkbenchLabelProvider(),
								new WorkbenchContentProvider() );
				dialog.setTitle("Select a Resource");
				dialog.setMessage("Select a resource to redirect output to:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.setComparator(
						new ResourceComparator(ResourceComparator.NAME));
				dialog.setDialogBoundsSettings(
						getDialogBoundsSettings(WORKSPACE_SELECTION_DIALOG),
						Dialog.DIALOG_PERSISTSIZE);
				if(dialog.open() == Window.OK) {
					final IResource resource = (IResource) dialog.getFirstResult();
					if(resource != null) {
						final IPath path = resource.getLocation();

						fTracePathText.setToolTipText(path.toString());

						fTracePathText.setText(
								WorkflowFileUtils.makeRelativeLocation(path));
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
					public void getName(final AccessibleEvent e) {
						e.result = "Test Purpose File";
					}
				} );
		fTestPurposePathText.addModifyListener(fBasicModifyListener);

		fTestPurposeWorkspaceBrowse =
				widgetToolkit.createPushButton(comp, "&Workspace...", null);
		fTestPurposeWorkspaceBrowse.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						final ElementTreeSelectionDialog dialog =
								new ElementTreeSelectionDialog(
										fCompositeParent.getShell(),
										new WorkbenchLabelProvider(),
										new WorkbenchContentProvider());
						dialog.setTitle("Select a Resource");
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
							final IResource resource =
									(IResource) dialog.getFirstResult();
							if(resource != null) {
								final IPath path = resource.getLocation();

								fTestPurposePathText.setToolTipText(path.toString());

								fTestPurposePathText.setText(
										WorkflowFileUtils.makeRelativeLocation(path));
							}
						}
					}
				});


		fObservableControllableComposite = widgetToolkit.createComposite(
				parent, 1, 1, GridData.FILL_HORIZONTAL);

		fEnabledObservableControllableBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION,
						"&Enable Observable / Controllable Configuration",
						fObservableControllableComposite, true);
        addFieldEditor(fEnabledObservableControllableBooleanField);

		fEnabledObservableControllableBooleanField.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						handleEnablingTraceConfiguration();
					}
				});

		createObservableControllableContent();
	}

	private void createObservableControllableContent()
	{
		fObservableTraceTableViewer = new TraceElementTableViewer(null,
				fObservableControllableComposite, 1, fWidgetToolkit,
				TraceElementTableConfigProvider.getObservableTrace(
						fObservableControllableComposite.getFont()));
		addTableViewer(fObservableTraceTableViewer);

		fControllableTraceTableViewer = new TraceElementTableViewer(null,
				fObservableControllableComposite, 1, fWidgetToolkit,
				TraceElementTableConfigProvider.getControllableTrace(
						fObservableControllableComposite.getFont()));
		addTableViewer(fControllableTraceTableViewer);
	}


	private void handleEnablingTraceConfiguration() {
		final boolean enabled =
				fEnabledObservableControllableBooleanField.getBooleanValue();

		if( (fObservableTraceTableViewer == null)
			|| (fControllableTraceTableViewer == null) )
		{
			createObservableControllableContent();
		}

		fConfigurationPage.propagateVisibility(
				fObservableTraceTableViewer.getControl(), enabled);
		fConfigurationPage.propagateVisibility(
				fControllableTraceTableViewer.getControl(), enabled);
	}


	@Override
	protected void setDefaultsImpl(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
				DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION);

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
				DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION);

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION, true);

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
				DEFAULT_TEST_OFFLINE_OBSERVABLE_SPECIFICATION);

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
				DEFAULT_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION);
	}


	@Override
	protected void initializeFromImpl(final ILaunchConfiguration configuration) {
		final String traceFile =
				WorkflowFileUtils.getRelativeLocation(configuration,
						ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
						DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION);
		fTracePathText.setText(traceFile);

		fTracePathText.setToolTipText(
				WorkflowFileUtils.makeAbsoluteLocation(traceFile));


		final String testPurposeFile =
				WorkflowFileUtils.getRelativeLocation(configuration,
						ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
						DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION);
		fTestPurposePathText.setText(testPurposeFile);

		fTestPurposePathText.setToolTipText(
				WorkflowFileUtils.makeAbsoluteLocation(testPurposeFile));


		handleEnablingTraceConfiguration();
	}

	@Override
	protected void performApplyImpl(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
				fTracePathText.getText());

		configuration.setAttribute(
				ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
				fTestPurposePathText.getText());
	}


	@Override
	protected boolean isValidImpl(final ILaunchConfiguration launchConfig) {

		String filePath = WorkflowFileUtils.makeAbsoluteLocation(
				fTracePathText.getText() );

		if( (filePath == null) || filePath.isEmpty() ) {
			setErrorMessage("The ressource Test Offline trace "
					+ "file path is empty (or null)");

			return false;
		}
		if( filePath.endsWith(DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION) ) {
			setErrorMessage("Select a SUT Trace file for Offline-Testing");

				return false;
			}
		else if( ! ( new File(filePath) ).exists() ) {
			setErrorMessage("The ressource Test Offline trace "
					+ "file \"" + filePath + "\" does not exist.");

			return false;
		}


		filePath = WorkflowFileUtils.makeAbsoluteLocation(
				fTestPurposePathText.getText() );

		if( (filePath == null)
			|| filePath.isEmpty()
			|| filePath.endsWith(DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION) ) {
			//!! NOTHING
		}
		else if( ! ( new File(filePath) ).isFile() ) {
			setErrorMessage("The ressource Test Offline test "
					+ "purpose file \"" + filePath + "\" does not exist.");

			return false;
		}

		return true;
	}



}
