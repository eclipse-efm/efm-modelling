/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.page.overview;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.sew.xtext.ui.internal.XtextActivator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class OverviewExtraneousModuleConfigurationProfile
		extends AbstractConfigurationProfile {

	private BooleanFieldEditor fEnabledAsMainWorkerBooleanField;

	private EmbeddedEditorModelAccess fEmbededEditorModelAccess;

	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewExtraneousModuleConfigurationProfile(
			AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Extraneous Module";
	}

	@Override
	public String getSectionDescription() {
		return "Incubation module or additional worker, raw configuration section";
	}


	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		Composite composite = widgetToolkit.createComposite(
				parent, 1, 1, GridData.FILL_HORIZONTAL);
		fEnabledAsMainWorkerBooleanField = new BooleanFieldEditor(
				this.fConfigurationPage,
				ATTR_OPAQUE_MODULE_ENABLED_AS_ADDITIONAL_WORKER,
				"&Enabled as additional Worker", composite,
				DEFAULT_OPAQUE_MODULE_ENABLED_AS_ADDITIONAL_WORKER);
		addFieldEditor(fEnabledAsMainWorkerBooleanField);

		Group group  = widgetToolkit.createGroup(parent,
				"&Full Textual Configuration", 1, 1, GridData.FILL_BOTH);

		createEmbededXtextSEWEditor(group);
	}


	private void createEmbededXtextSEWEditor(Composite parent) {
		XtextActivator activator = XtextActivator.getInstance();
		Injector injector =
				activator.getInjector(XtextActivator.ORG_ECLIPSE_EFM_SEW_XTEXT_SEW);

		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {
			@Override
			public XtextResource createResource() {
				try {
					Resource resource = resourceSet.createResource(
							URI.createURI(".sew/workflow-opaque-configuration.sew"));

					return (XtextResource) resource;
				} catch (Exception e) {
					return null;
				}
			}
		};

		EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);

		EmbeddedEditor handle = factory.newEditor(resourceProvider).withParent(parent);

		fEmbededEditorModelAccess = handle.createPartialEditor();

//		GridData gd = new GridData(GridData.FILL, GridData.FILL, true, true, 2, 0);
//		handle.getViewer().getControl().setLayoutData(gd);
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_OPAQUE_MODULE_TEXTUAL_CONFIGURATION,
				DEFAULT_OPAQUE_MODULE_TEXTUAL_CONFIGURATION);
	}

	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration) {
		String opaqueConfig;
		try {
			opaqueConfig = configuration.getAttribute(
					ATTR_OPAQUE_MODULE_TEXTUAL_CONFIGURATION,
					DEFAULT_OPAQUE_MODULE_TEXTUAL_CONFIGURATION);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			opaqueConfig = DEFAULT_OPAQUE_MODULE_TEXTUAL_CONFIGURATION;
		}
		if( (opaqueConfig == null) || opaqueConfig.isEmpty() ) {
			opaqueConfig = "";
		}

		fEmbededEditorModelAccess.updateModel(opaqueConfig);
	}


	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		final String opaqueConfig =
				fEmbededEditorModelAccess.getEditablePart();

		configuration.setAttribute(
				ATTR_OPAQUE_MODULE_TEXTUAL_CONFIGURATION, opaqueConfig);
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		final String opaqueConfig =
				fEmbededEditorModelAccess.getEditablePart();

		return( (opaqueConfig != null) && (! opaqueConfig.isEmpty())
				&& (! opaqueConfig.equals(DEFAULT_OPAQUE_MODULE_TEXTUAL_CONFIGURATION)) );
	}


	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	public void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_SPECIFICATION_MODEL_FILE_LOCATION: {
			break;
		}
		default:
			break;
		}
	}

}
