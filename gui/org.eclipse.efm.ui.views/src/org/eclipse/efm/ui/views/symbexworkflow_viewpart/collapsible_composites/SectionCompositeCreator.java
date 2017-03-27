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

import java.util.HashMap;
import java.util.Map;


import org.eclipse.efm.ui.views.SymbexWorkflowView;
import org.eclipse.efm.ui.views.mitems.LaunchManagerSWVlinker;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public abstract class SectionCompositeCreator {

	protected Map<String, Object> last_lcAttributes;
	
	public Section section;
	protected Composite sectionClient;
	
	public SectionCompositeCreator(SymbexWorkflowView swv, ToolBarManager tbm, Composite innertabcompo) {
		last_lcAttributes = new HashMap<String, Object>();
		swv.compositeSections.add(this);
		this.addComposite(swv.toolkit, swv.scrollform, innertabcompo, tbm);
	}
	
	public abstract void addComposite(FormToolkit toolkit, ScrolledForm scrollform, Composite innertabcompo, IToolBarManager tbm);
	
	protected void addComposite_internal(FormToolkit toolkit, ScrolledForm scrollform, Composite innertabcompo, IToolBarManager tbm, String title) {
		section = toolkit.createSection(innertabcompo, Section.DESCRIPTION|Section.TWISTIE|Section.TITLE_BAR|Section.EXPANDED);
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		section.setLayoutData(gd);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				scrollform.reflow(true);
				updateCollapsedContent(null);
			}
		});
		section.setText(title);
		
		//ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = ((ToolBarManager) tbm).createControl(section);
		section.setTextClient(toolbar);
		
		sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout());
		addCollapsedContent(toolkit);
		section.setClient(sectionClient);
	}
	
	protected abstract void addCollapsedContent(FormToolkit toolkit);
	
	public abstract void updateCollapsedContent(Map<String, Object> lcAttributes);
}
