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
package org.eclipse.efm.execution.configuration.common.ui.api;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public abstract class AbstractConfigurationComponent
		implements IWorkflowConfigurationConstants {

	protected AbstractConfigurationPage fConfigurationPage;

	public Composite fCompositeParent;

	private ExpandableComposite masterExpandableComposite;
	public Composite fCompositeControl;

	/**
	 * Constructor
	 * @param parentTab
	 */
	public AbstractConfigurationComponent(AbstractConfigurationPage configurationPage) {
		fConfigurationPage = configurationPage;
	}

	abstract public void createPageWithToolkit(Composite parentComposite);
	
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
	
	protected void createExpandableFrameWithToolkit(Composite parentComposite, String title)
	{
		fCompositeParent = parentComposite;
		FormToolkit toolkit = fConfigurationPage.getMasterFormToolkit();

//		masterExpandableComposite = toolkit.createExpandableComposite(fCompositeParent,
//				ExpandableComposite.CLIENT_INDENT | ExpandableComposite.TWISTIE);
//		masterExpandableComposite.setText(title);
//		GridLayout gl = new GridLayout(1, false);
//		masterExpandableComposite.setLayout(gl);
//		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
//		masterExpandableComposite.setLayoutData(gd);
//		
//		fCompositeControl = toolkit.createComposite(
//				masterExpandableComposite, fCompositeParent.getStyle());
//		GridLayout gl2 = new GridLayout(1, false);
//		fCompositeControl.setLayout(gl2);
//		GridData gd2 = new GridData(SWT.FILL,SWT.FILL, true, false);
//		fCompositeControl.setLayoutData(gd2);
//		
		masterExpandableComposite = toolkit.createSection(fCompositeParent,
				Section.DESCRIPTION|Section.TWISTIE|Section.TITLE_BAR|Section.EXPANDED);
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		masterExpandableComposite.setLayoutData(gd);
		masterExpandableComposite.setText(title);
		
		fCompositeControl = toolkit.createComposite(masterExpandableComposite);
		fCompositeControl.setLayout(new GridLayout());

		
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
		fConfigurationPage.propagateWarningMessage(warningMessage);
	}

	protected void setErrorMessage(String errorMessage) {
		fConfigurationPage.propagateErrorMessage(errorMessage);
	}

}
