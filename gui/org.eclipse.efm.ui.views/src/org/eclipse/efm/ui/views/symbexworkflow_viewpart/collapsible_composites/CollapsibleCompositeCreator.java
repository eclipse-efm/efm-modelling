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

import org.eclipse.efm.ui.views.GenericCompositeCreator;
import org.eclipse.efm.ui.views.SymbexWorkflowView;
import org.eclipse.efm.ui.views.mitems.ManagerLinker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Button;

public abstract class CollapsibleCompositeCreator {

	protected Map<String, Object> last_lcAttributes;
	
	Composite parentComposite;
	Composite composite;
	Composite collapsible_part;
	GridData collapsible_gd;
	Button button_collapse;
	ManagerLinker ml; 
	ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
	
	public CollapsibleCompositeCreator(ManagerLinker ml, SymbexWorkflowView swv) {
		this.ml = ml;
		last_lcAttributes = new HashMap<String, Object>();
		swv.collapsibles.add(this);
		this.addComposite(swv.selfCreatedMainComposite);
	}
	
	public abstract void addComposite(Composite parentComposite);
	
	protected void addComposite_internal(Composite parentComposite, String title) {
		this.parentComposite = parentComposite;
		composite = GenericCompositeCreator.create_GridListing_HorizontalGrabbing_Composite(parentComposite, 1);
		
		Composite titlecomposite = GenericCompositeCreator.create_GridListing_HorizontalGrabbing_Composite(composite, 2);
		
		button_collapse = new Button(titlecomposite, SWT.LEFT);
		button_collapse.setImage(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO).createImage());
		
		Label label_title = new Label(titlecomposite, SWT.LEFT);
		label_title.setText("     " + title);
		
		collapsible_part = GenericCompositeCreator.create_GridListing_HorizontalGrabbing_Composite(composite, 1);
		collapsible_gd = (GridData) collapsible_part.getLayoutData();
		collapsible_gd.exclude = !collapsible_gd.exclude;
		
		addCollapsedContent();
		collapsible_part.setVisible(!collapsible_gd.exclude);
		repackParentComposite();
		
		button_collapse.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				collapsible_gd.exclude = !collapsible_gd.exclude;
				collapsible_part.setVisible(!collapsible_gd.exclude);
				repackParentComposite();
				if (collapsible_gd.exclude) {
					button_collapse.setImage(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO).createImage());
				} else {
					button_collapse.setImage(sharedImages.getImageDescriptor(ISharedImages.IMG_ELCL_COLLAPSEALL).createImage());
				}
				updateCollapsedContent(null);
			}
		});
	}
		
	private void repackParentComposite() {
		int width = parentComposite.getSize().x;
		parentComposite.pack();
		int height = parentComposite.getSize().y;
		parentComposite.setSize(width, height);
	}
	
	protected abstract void addCollapsedContent();
	
	public abstract void updateCollapsedContent(Map<String, Object> lcAttributes);
}
