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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;

public abstract class AbstractConfigurationProfile extends AbstractSectionPart
		implements IWorkflowConfigurationConstants {

	protected AbstractConfigurationPage fConfigurationPage;

	public Composite fCompositeParent;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public AbstractConfigurationProfile(AbstractConfigurationPage configurationPage) {
		fConfigurationPage = configurationPage;
	}

	public void setVisibleAndEnabled(boolean visible) {
		fConfigurationPage.getWidgetToolkit().setVisibleAndEnabled(getSection(), visible);
	}

	public final void createControl(Composite parent, IWidgetToolkit widgetToolkit)
	{
		fCompositeParent = parent;

		widgetToolkit.createSectionPart(this, parent,
				Section.TITLE_BAR | Section.DESCRIPTION |
				Section.EXPANDED  | Section.TWISTIE, null);

		createContent(getSectionClient(), widgetToolkit);
	}

	abstract protected void createContent(Composite parent, IWidgetToolkit widgetToolkit);


	protected void setWarningMessage(String warningMessage) {
		fConfigurationPage.propagateWarningMessage(warningMessage);
	}

	protected void setErrorMessage(String errorMessage) {
		fConfigurationPage.propagateErrorMessage(errorMessage);
	}

}
