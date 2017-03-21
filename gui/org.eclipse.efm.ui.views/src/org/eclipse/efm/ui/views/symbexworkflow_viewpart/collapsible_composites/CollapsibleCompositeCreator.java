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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Button;

public abstract class CollapsibleCompositeCreator {

	Combo combo;
	Composite parentComposite;
	Composite composite;
	Composite collapsible_part;
	GridData collapsible_gd;
	Button button_collapse;
	ManagerLinker ml; 
	ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
	
	public CollapsibleCompositeCreator(ManagerLinker ml, Combo combo) {
		this.ml = ml;
		this.combo = combo;
	}
	
	public abstract void addComposite(Composite parentComposite);
	
	protected void addComposite_internal(Composite parentComposite, String title) {
		this.parentComposite = parentComposite;
		composite = GenericCompositeCreator.create_GridListing_HorizontalGrabbing_Composite(parentComposite, 1);
		
		Composite titlecomposite = GenericCompositeCreator.create_GridListing_HorizontalGrabbing_Composite(composite, 2);
		
		Label label_title = new Label(titlecomposite, SWT.LEFT);
		label_title.setText("     " + title);
		
		button_collapse = new Button(titlecomposite, SWT.RIGHT);
		button_collapse.setImage(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO).createImage());
		
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
				updateCollapsedContent();
			}
		});
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCollapsedContent();
			}
		});
	}
		
	private void repackParentComposite() {
//		GridLayout parentgridlayout = (GridLayout) composite.getParent().getLayout();
//		GridData parentgriddata = (GridData) composite.getParent().getLayoutData();
//		composite.getParent().pack();
//		composite.getParent().setLayout(parentgridlayout);
//		composite.getParent().setLayoutData(parentgriddata);
		//parentComposite.pack();
		//parentComposite.computeSize(SWT.FILL, SWT.FILL, true);
		
		//parentComposite.setSize(parentComposite.computeSize(SWT.FILL, SWT.FILL, true));
		//parentComposite.setSize(parentComposite.computeSize(SWT.FILL, SWT.FILL, true));
		//parentComposite.setSize(parentComposite.computeSize(SWT.FILL, SWT.DEFAULT, true));
		//parentComposite.pack(true);
		int width = parentComposite.getSize().x;
		parentComposite.pack();
		int height = parentComposite.getSize().y;
		
		parentComposite.setSize(width, height);
//		GridLayout gl = new GridLayout(1, false);
//		parentComposite.setLayout(gl);
//		
		//GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
//		parentComposite.setLayoutData(gd);
	}
	
	protected abstract void addCollapsedContent();
	
	protected abstract void updateCollapsedContent();
}
