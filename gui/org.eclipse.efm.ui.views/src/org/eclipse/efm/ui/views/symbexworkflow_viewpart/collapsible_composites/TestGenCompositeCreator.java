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
package org.eclipse.efm.ui.views.symbexworkflow_viewpart.collapsible_composites;

import java.util.Map;

import org.eclipse.efm.runconfiguration.workflow.IWorkflowConfigurationConstants;
import org.eclipse.efm.ui.views.GenericCompositeCreator;
import org.eclipse.efm.ui.views.SymbexWorkflowView;
import org.eclipse.efm.ui.views.mitems.ManagerLinker;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class TestGenCompositeCreator extends SectionCompositeCreator {
	
	public TestGenCompositeCreator(ManagerLinker ml, SymbexWorkflowView swv) {
		super(ml, swv);
	}
	
	public void addComposite(FormToolkit toolkit, ScrolledForm scrollform, Action[] actions) {
		addComposite_internal(toolkit, scrollform, actions, "Execution");
	}

	@Override
	protected void addCollapsedContent(FormToolkit toolkit, ScrolledForm scrollform) {
	}

	@Override
	public void updateCollapsedContent(Map<String, Object> lcAttributes) {
		if(lcAttributes == null) {
			lcAttributes = last_lcAttributes;
		}
		if(lcAttributes.isEmpty()) {

		} else {

		}
		last_lcAttributes = lcAttributes;
	}
}
