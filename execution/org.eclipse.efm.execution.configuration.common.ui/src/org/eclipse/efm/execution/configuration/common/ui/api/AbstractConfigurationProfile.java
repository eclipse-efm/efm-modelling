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

import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.jface.action.Action;

public abstract class AbstractConfigurationProfile extends AbstractSectionPart
		implements IWorkflowConfigurationConstants {

	protected AbstractConfigurationPage fConfigurationPage;

	/**
	 * Constructor
	 * @param parentTab
	 */
	public AbstractConfigurationProfile(
			AbstractConfigurationPage configurationPage, boolean showDefaultSectionActions)
	{
		super(showDefaultSectionActions);

		fConfigurationPage = configurationPage;
	}


	public AbstractConfigurationPage getConfigurationPage() {
		return fConfigurationPage;
	}

	@Override
	protected Action[] getDefaultSectionActions() {
		return fConfigurationPage.getDefaultSectionActions();
	}


	public void setVisibleAndEnabled(boolean visible) {
		fConfigurationPage.getWidgetToolkit().setVisibleAndEnabled(getSection(), visible);
	}


	public void setWarningMessage(String warningMessage) {
		fConfigurationPage.propagateWarningMessage(warningMessage);
	}

	public void setErrorMessage(String errorMessage) {
		fConfigurationPage.propagateErrorMessage(errorMessage);
	}

}
