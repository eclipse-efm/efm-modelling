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

import org.eclipse.efm.ui.views.GenericCompositeCreator;
import org.eclipse.efm.ui.views.mitems.ManagerLinker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class StopCriteriaCompositeCreator extends CollapsibleCompositeCreator {

	private Text gslim_nodes;
	private Text gslim_width;
	private Text gslim_height;
	
	private Text evalim_steps;
	private Text evalim_timeout;
	
	public StopCriteriaCompositeCreator(ManagerLinker ml, Combo combo) {
		super(ml, combo);
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
	protected void updateCollapsedContent() {
		int index = combo.getSelectionIndex();
		if (index != -1) {
			String text = ml.getSymbexRunConfigurations()[index].getName();
			
			gslim_nodes.setText(text);
			gslim_width.setText(text);
			gslim_height.setText(text);
			
			evalim_steps.setText(text);
			evalim_timeout.setText(text);
		}
	}
}
