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
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class AnalysisProfileCompositeCreator extends SectionCompositeCreator {

	private Text ana_profile;
	private Text ana_strategy;
	
	public AnalysisProfileCompositeCreator(ManagerLinker ml, SymbexWorkflowView swv, ToolBarManager tbm) {
		super(ml, swv, tbm);
	}
	
	public void addComposite(FormToolkit toolkit, ScrolledForm scrollform, IToolBarManager tbm) {
		addComposite_internal(toolkit, scrollform, tbm, "Analysis");
	}

	@Override
	protected void addCollapsedContent(FormToolkit toolkit, ScrolledForm scrollform) {
		ana_profile = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, sectionClient, "Profile :", 2);
		ana_strategy = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, sectionClient, "Strategy :", 2); 
	
		ExpandableComposite expert_composite = toolkit.createExpandableComposite(sectionClient, sectionClient.getStyle());
		expert_composite.setText("Expert Configuration");
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
