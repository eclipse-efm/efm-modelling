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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class StopCriteriaCompositeCreator extends CollapsibleCompositeCreator {

	private Text gslim_nodes;
	private Text gslim_width;
	private Text gslim_height;
	
	private Text evalim_steps;
	private Text evalim_timeout;
	
	public StopCriteriaCompositeCreator(ManagerLinker ml, SymbexWorkflowView swv) {
		super(ml, swv);
	}
	
	public void addComposite(Composite parentComposite) {
		addComposite_internal(parentComposite, "Stop Criteria");
	}

	@Override
	protected void addCollapsedContent() {
		Label label_graphsize = new Label(collapsible_part, SWT.LEFT);
		label_graphsize.setText("Graph size limits");
		
		gslim_nodes = GenericCompositeCreator.createComposite_horizontal_label_text(collapsible_part, "Nodes :");
		gslim_width = GenericCompositeCreator.createComposite_horizontal_label_text(collapsible_part, "Width :");
		gslim_height = GenericCompositeCreator.createComposite_horizontal_label_text(collapsible_part, "Height :");
	
		Label label_evalimit = new Label(collapsible_part, SWT.LEFT);
		label_evalimit.setText("Evaluation Limits");
		
		evalim_steps = GenericCompositeCreator.createComposite_horizontal_label_text(collapsible_part, "Steps :");
		evalim_timeout = GenericCompositeCreator.createComposite_horizontal_label_text(collapsible_part, "Timeout :");
	}

	@Override
	public void updateCollapsedContent(Map<String, Object> lcAttributes) {
		if(lcAttributes == null) {
			lcAttributes = last_lcAttributes;
		}
		System.err.println("bip");
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
