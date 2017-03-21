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

public class AnalysisProfileCompositeCreator extends CollapsibleCompositeCreator {

	private Text ana_profile;
	private Text ana_strategy;
	
	public AnalysisProfileCompositeCreator(ManagerLinker ml, Combo combo) {
		super(ml, combo);
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
	protected void updateCollapsedContent() {
		int index = combo.getSelectionIndex();
		if (index != -1) {
			String text = ml.getSymbexRunConfigurations()[index].getName();
			
			ana_profile.setText(text);
			ana_strategy.setText(text);
		}
	}
}
