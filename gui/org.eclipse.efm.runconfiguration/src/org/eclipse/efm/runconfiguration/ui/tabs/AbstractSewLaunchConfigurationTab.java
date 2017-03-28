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
package org.eclipse.efm.runconfiguration.ui.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.efm.core.workflow.Activator;
import org.eclipse.efm.runconfiguration.LaunchConfigurationTabGroup;
import org.eclipse.efm.ui.views.launchconfigurations.components.AbstractCompositeMaker;
import org.eclipse.efm.ui.views.launchconfigurations.components.AbstractCompositeMaker.FieldValidationReturn;
import org.eclipse.efm.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

public abstract class AbstractSewLaunchConfigurationTab extends AbstractLaunchConfigurationTab implements ILaunchConfigurationGUIelement {

	protected LaunchConfigurationTabGroup fGroupTab;
	protected AbstractCompositeMaker contentCompositeManager;

	/**
	 * Constructor
	 * @param groupTab
	 */
	public AbstractSewLaunchConfigurationTab(LaunchConfigurationTabGroup groupTab) {
		super();
		this.fGroupTab = groupTab;
	}
	
	public LaunchConfigurationTabGroup getGroupTab() {
		return fGroupTab;
	}

	public MainTab getMainTab() {
		return fGroupTab.getMainTab();
	}

	@Override
	public void createControl(Composite parent) {
		Composite simpleComposite = contentCompositeManager.createControlMain(parent);
		setControl(simpleComposite);
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
	
	// ======================================================================================
	//                              ILaunchConfigurationGUIelement interface methods
	// ======================================================================================	
	
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
