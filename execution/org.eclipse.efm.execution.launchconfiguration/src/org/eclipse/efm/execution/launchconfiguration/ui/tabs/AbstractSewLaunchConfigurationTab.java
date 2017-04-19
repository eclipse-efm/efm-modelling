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
package org.eclipse.efm.execution.launchconfiguration.ui.tabs;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage.FieldValidationReturn;
import org.eclipse.efm.execution.configuration.common.ui.util.SWTFactory;
import org.eclipse.efm.execution.core.Activator;
import org.eclipse.efm.execution.launchconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;

public abstract class AbstractSewLaunchConfigurationTab extends AbstractLaunchConfigurationTab implements ILaunchConfigurationGUIelement {

	private FormToolkit toolkit;
	protected LaunchConfigurationTabGroup fGroupTab;
	protected AbstractConfigurationPage contentCompositeManager;

	/**
	 * Constructor
	 * @param groupTab
	 */
	public AbstractSewLaunchConfigurationTab(LaunchConfigurationTabGroup groupTab) {
		super();
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		toolkit = new FormToolkit(display);
		this.fGroupTab = groupTab;

		this.contentCompositeManager = null;
	}
	

	@Override
	public FormToolkit getFormToolkit() {
		return toolkit;
	}
	
	@Override
	public Composite createComposite(Composite parent) {
		return SWTFactory.createComposite(parent, 1, 1, GridData.FILL_HORIZONTAL);
	}
	
	@Override
	public Composite createComposite(Composite parent, int style) {
		return SWTFactory.createComposite(parent, style, 1, 1, GridData.FILL_HORIZONTAL);
	}
	
	@Override
	public Text createText(Composite parent, String value, int style) {
		Text text = SWTFactory.createText(parent, style, 1);
		
		if (value != null) {
			text.setText(value);
		}

		return text;
	}
	

	public LaunchConfigurationTabGroup getGroupTab() {
		return fGroupTab;
	}

	public OverviewTab getMainTab() {
		return fGroupTab.getMainTab();
	}

	@Override
	public void createControl(Composite parent) {
		Composite main_composite = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_BOTH, 0, 0);
//		Font font =  parent.getFont();
//		int columns = 1;
//		int hspan = 1;
//		int fill = GridData.FILL_BOTH;
//		int marginwidth = 0;
//		int marginheight = 0;
//		System.err.println(parent.getStyle());
//		Composite main_composite = new Composite(parent, parent.getStyle()|SWT.NO_SCROLL);
//		GridLayout layout = new GridLayout(columns, false);
//		layout.marginWidth = marginwidth;
//		layout.marginHeight = marginheight;
//		main_composite.setLayout(layout);
//		main_composite.setFont(font);
//		GridData gd = new GridData(fill);
//		gd.horizontalSpan = hspan;
//		main_composite.setLayoutData(gd);
//

//		try {
			contentCompositeManager.createTabItemContent(main_composite);
			setControl(main_composite);
			//setControl(parent);
//		} catch(InstantiationException | IllegalAccessException | IllegalArgumentException
//				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
//			e.printStackTrace();
//		}

		setControl(main_composite);
		//setControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), getHelpContextId());
	}



	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		contentCompositeManager.setDefaultFieldValues(configuration);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		contentCompositeManager.initializeFieldValuesFrom(configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		contentCompositeManager.applyUpdatesOnFieldValuesFrom(configuration);
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#isValid(ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		FieldValidationReturn fieldValidation = contentCompositeManager.areFieldsValid(launchConfig);
		if (fieldValidation.areFieldsValid()) {
			setMessage(fieldValidation.getReason());
		} else {
			setErrorMessage(fieldValidation.getReason());
		}
		return fieldValidation.areFieldsValid();
	}


	/**
	 * Returns the {@link IDialogSettings} for the given id
	 *
	 * @param id the id of the dialog settings to get
	 * @return the {@link IDialogSettings} to pass into the {@link ContainerSelectionDialog}
	 * @since 3.6
	 */
	public final IDialogSettings getDialogBoundsSettings(String id) {
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		IDialogSettings section = settings.getSection(id);
		if(section == null) {
			section = settings.addNewSection(id);
		}
		return section;
	}

	// =========================================================================
	//         ILaunchConfigurationGUIelement interface methods
	// =========================================================================

	@Override
	public void updateGUI() {
		updateLaunchConfigurationDialog();
	}

	@Override // to change visibility to public
	public void setMessage(String message){
		super.setMessage(message);
	}

	@Override // to change visibility to public
	public void setWarningMessage(String warningmessage){
		super.setWarningMessage(warningmessage);
	}

	@Override // to change visibility to public
	public void setErrorMessage(String errormessage){
		super.setErrorMessage(errormessage);
	}

	@Override // to change visibility to public
	public void scheduleUpdateJob(){
		super.scheduleUpdateJob();
	}

}
