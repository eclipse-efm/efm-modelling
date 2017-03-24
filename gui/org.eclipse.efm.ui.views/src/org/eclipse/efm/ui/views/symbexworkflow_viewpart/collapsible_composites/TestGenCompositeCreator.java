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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;

public class TestGenCompositeCreator extends SectionCompositeCreator {
	
	public TestGenCompositeCreator(ManagerLinker ml, SymbexWorkflowView swv, ToolBarManager tbm) {
		super(ml, swv, tbm);
	}
	
	public void addComposite(FormToolkit toolkit, ScrolledForm scrollform, IToolBarManager tbm) {
		addComposite_internal(toolkit, scrollform, tbm, "Test Generation");
	}

	@Override
	protected void addCollapsedContent(FormToolkit toolkit, ScrolledForm scrollform) {
		ExpandableComposite tracext_composite = toolkit.createExpandableComposite(sectionClient, sectionClient.getStyle());
		tracext_composite.setText("Trace Extension");
		
		ExpandableComposite basic_composite = toolkit.createExpandableComposite(sectionClient, sectionClient.getStyle());
		basic_composite.setText("Basic Test Generation");
		
		
		
		
		
		ExpandableComposite ttcn_composite = toolkit.createExpandableComposite(sectionClient, sectionClient.getStyle());
		ttcn_composite.setText("TTCN-3 Test Generation");
		
		ExpandableComposite titan_composite = toolkit.createExpandableComposite(sectionClient, sectionClient.getStyle());
		titan_composite.setText("Titan Format Configuration");
		
		//ImageHyperlink eci = toolkit.createImageHyperlink(ec, SWT.NULL);
		//eci.setImage(FormArticlePlugin.getDefault().getImageRegistry().get(FormArticlePlugin.IMG_SAMPLE));
//		ec.setTextClient(eci);
//		ec.setText(Messages.getString("FormView.expandable")); //$NON-NLS-1$
//		String ctext = Messages.getString("FormView.expandableText")+ //$NON-NLS-1$
//		Messages.getString("FormView.expandablText2")+ //$NON-NLS-1$
//		Messages.getString("FormView.expandableText3")+ //$NON-NLS-1$
//		Messages.getString("FormView.expandableText4"); //$NON-NLS-1$
//		Label client = toolkit.createLabel(ec, ctext, SWT.WRAP);
//		ec.setClient(client);
//		td = new TableWrapData();
//		td.colspan = 2;
//		ec.setLayoutData(td);
//		ec.addExpansionListener(new ExpansionAdapter() {
//			public void expansionStateChanged(ExpansionEvent e) {
//				form.reflow(true);
//			}
//		});
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
