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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class StopCriteriaCompositeCreator extends SectionCompositeCreator {

	private Text gslim_nodes;
	private Text gslim_width;
	private Text gslim_height;
	
	private Text evalim_steps;
	private Text evalim_timeout;
	
	public StopCriteriaCompositeCreator(ManagerLinker ml, SymbexWorkflowView swv, ToolBarManager tbm) {
		super(ml, swv, tbm);
	}
	
	public void addComposite(FormToolkit toolkit, ScrolledForm scrollform, IToolBarManager tbm) {
		addComposite_internal(toolkit, scrollform, tbm, "Graph Browsing Criteria");
	}

	@Override
	protected void addCollapsedContent(FormToolkit toolkit, ScrolledForm scrollform) {
		toolkit.createLabel(sectionClient, "Graph size limits");
		
		gslim_nodes = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, sectionClient, "Nodes :", 2);
		gslim_width = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, sectionClient, "Width :", 2);
		gslim_height = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, sectionClient, "Height :", 2);
	
		toolkit.createLabel(sectionClient, "Evaluation Limits");
		
		evalim_steps = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, sectionClient, "Steps :", 2);
		evalim_timeout = GenericCompositeCreator.createComposite_label_text_from_toolkit(toolkit, sectionClient, "Timeout :", 2);
	}

	@Override
	public void updateCollapsedContent(Map<String, Object> lcAttributes) {
		if(lcAttributes == null) {
			lcAttributes = last_lcAttributes;
		}
		if(lcAttributes.isEmpty()) {
			gslim_nodes.setText("...");
			gslim_width.setText("...");
			gslim_height.setText("...");
			
			evalim_steps.setText("...");
			evalim_timeout.setText("...");
		} else {
			String gsnodes = Integer.toString( (int) lcAttributes.get(IWorkflowConfigurationConstants.ATTR_SPECIFICATION_STOP_CRITERIA_NODE) );
			gslim_nodes.setText(gsnodes);
			
			String gswidth = Integer.toString( (int) lcAttributes.get(IWorkflowConfigurationConstants.ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH) );
			gslim_width.setText(gswidth);
			
			String gsheight = Integer.toString( (int)  lcAttributes.get(IWorkflowConfigurationConstants.ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT) );
			gslim_height.setText(gsheight);
			
			String evsteps = Integer.toString( (int)  lcAttributes.get(IWorkflowConfigurationConstants.ATTR_SPECIFICATION_STOP_CRITERIA_STEPS) );
			evalim_steps.setText(evsteps);
			
			String evtimeout = Integer.toString( (int)  lcAttributes.get(IWorkflowConfigurationConstants.ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT) );
			evalim_timeout.setText(evtimeout);
		}
		last_lcAttributes = lcAttributes;
	}
}
