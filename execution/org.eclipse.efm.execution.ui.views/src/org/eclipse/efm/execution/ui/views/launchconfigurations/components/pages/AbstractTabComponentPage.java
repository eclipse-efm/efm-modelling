/**
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
 */
package org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationEditorComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;

public abstract class AbstractTabComponentPage
		implements IWorkflowConfigurationConstants {

	protected ILaunchConfigurationEditorComposite fParentTab;

	public Composite fCompositeParent;

	private ExpandableComposite masterExpandableComposite;
	public Composite fCompositeControl;

	/**
	 * Constructor
	 * @param parentTab
	 */
	public AbstractTabComponentPage(ILaunchConfigurationEditorComposite parentTab) {
		fParentTab = parentTab;
	}

	abstract public void createPageWithToolkit(Composite parentComposite, FormToolkit toolkit);
	
	public void collapseAndLockPage() {
		masterExpandableComposite.setExpanded(false);
		masterExpandableComposite.setEnabled(false);
	}
	public void unlockAndExpandPage() {
		masterExpandableComposite.setEnabled(true);
		masterExpandableComposite.setExpanded(true);
	}
	
	public void updateLayouts() {
		fCompositeControl.layout(true);
		masterExpandableComposite.layout(true);
		fCompositeControl.layout(true);
	}
	
	protected void createExpandableFrameWithToolkit(Composite parentComposite, FormToolkit toolkit, String compo_title) {
		fCompositeParent = parentComposite;
		masterExpandableComposite = toolkit.createExpandableComposite(fCompositeParent,
				ExpandableComposite.CLIENT_INDENT | ExpandableComposite.TWISTIE);
		masterExpandableComposite.setText(compo_title);
		GridLayout gl = new GridLayout(1, false);
		masterExpandableComposite.setLayout(gl);
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		masterExpandableComposite.setLayoutData(gd);
		
		fCompositeControl = toolkit.createComposite(masterExpandableComposite, fCompositeParent.getStyle());
		GridLayout gl2 = new GridLayout(1, false);
		fCompositeControl.setLayout(gl2);
		GridData gd2 = new GridData(SWT.FILL,SWT.FILL, true, false);
		fCompositeControl.setLayoutData(gd2);
		
		masterExpandableComposite.setClient(fCompositeControl);
		collapseAndLockPage();
		}


	abstract public void setDefaults(
			ILaunchConfigurationWorkingCopy configuration);

	abstract public void initializeFrom(ILaunchConfiguration configuration);

	abstract public void performApply(
			ILaunchConfigurationWorkingCopy configuration);


	abstract public boolean isValid(ILaunchConfiguration launchConfig);

	protected void setWarningMessage(String warningMessage) {
		fParentTab.propagateWarningMessage(warningMessage);
	}

	protected void setErrorMessage(String errorMessage) {
		fParentTab.propagateErrorMessage(errorMessage);
	}

}
