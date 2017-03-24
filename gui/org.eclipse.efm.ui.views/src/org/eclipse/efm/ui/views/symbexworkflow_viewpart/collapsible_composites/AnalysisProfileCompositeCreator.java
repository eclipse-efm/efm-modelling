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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class AnalysisProfileCompositeCreator extends CollapsibleCompositeCreator {

	private Text ana_profile;
	private Text ana_strategy;
	
	public AnalysisProfileCompositeCreator(ManagerLinker ml, SymbexWorkflowView swv) {
		super(ml, swv);
	}
	
	public void addComposite(Composite parentComposite) {
		addComposite_internal(parentComposite, "Analysis");
	}

	@Override
	protected void addCollapsedContent() {
		ana_profile = GenericCompositeCreator.createComposite_horizontal_label_text(collapsible_part, "Profile :");
		ana_strategy = GenericCompositeCreator.createComposite_horizontal_label_text(collapsible_part, "Strategy :");
	}

	@Override
	public void updateCollapsedContent(Map<String, Object> lcAttributes) {
		if(lcAttributes == null) {
			lcAttributes = last_lcAttributes;
		}
		if(lcAttributes.isEmpty()) {
			ana_profile.setText("...");
			ana_strategy.setText("...");
		} else {
			String anap = (String) lcAttributes.get(IWorkflowConfigurationConstants.ATTR_SPECIFICATION_MODEL_ANALYSIS);
			ana_profile.setText(anap);
			
			String anas =(String) lcAttributes.get(IWorkflowConfigurationConstants.ATTR_SPECIFICATION_ANALYZE_STRATEGY);
			ana_strategy.setText(anas);
		}
		last_lcAttributes = lcAttributes;
	}
}
