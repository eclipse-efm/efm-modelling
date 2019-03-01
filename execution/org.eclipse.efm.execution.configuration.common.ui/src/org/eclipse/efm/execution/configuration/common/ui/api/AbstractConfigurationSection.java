/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.api;


import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;

public abstract class AbstractConfigurationSection extends AbstractSectionPart
		implements IWorkflowConfigurationConstants {

	protected AbstractConfigurationPage fConfigurationPage;

	public AbstractConfigurationSection(
			AbstractConfigurationPage configurationPage, boolean showDefaultSectionActions)
	{
		super(showDefaultSectionActions);

		this.fConfigurationPage = configurationPage;
	}

	public AbstractConfigurationPage getConfigurationPage() {
		return fConfigurationPage;
	}

	public AbstractConfigurationPage[] getConfigurationPages() {
		return fConfigurationPage.getConfigurationPages();
	}

	@Override
	protected Action[] getDefaultSectionActions() {
		return fConfigurationPage.getDefaultSectionActions();
	}

	/**
	 * Programmatically changes expanded state.
	 *
	 * @param expanded
	 *            the new expanded state
	 */
	public void setExpanded(boolean expanded) {
		final Composite section = getSection();
		if( section instanceof ExpandableComposite ) {
			((ExpandableComposite) section).setExpanded(expanded);
		}
	}

    /**
     * Sets the label control's tool tip text to the argument
     */
    public void setToolTipText(String string) {
//    	section.setToolTipText(string);
    }

}
