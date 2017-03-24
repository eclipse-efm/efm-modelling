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
package org.eclipse.efm.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class GenericCompositeCreator {

	public static Composite create_GridListing_HorizontalGrabbing_Composite(Composite parentComposite, int colnum) {
		Composite composite = new Composite(parentComposite, SWT.NONE);
		
		GridLayout gl = new GridLayout(colnum, false);
		composite.setLayout(gl);
		
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		composite.setLayoutData(gd);
		
		return composite;
	}
	
	
	public static Text createComposite_vertical_label_text(Composite parentComposite, String labeltext) {
		
		Composite composite = create_GridListing_HorizontalGrabbing_Composite(parentComposite, 1);
		
		Label label_title = new Label(composite, SWT.LEFT);
		label_title.setText(labeltext);
		
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		Text label_content = new Text(composite, SWT.LEFT);
		label_content.setLayoutData(gd);
		
		label_content.setText("...");
		label_content.setEditable(false);
		 
		return label_content;
	}
	
	public static Text createComposite_horizontal_label_text(Composite parentComposite, String labeltext) {
		
		Composite composite = create_GridListing_HorizontalGrabbing_Composite(parentComposite, 2);
		
		Label label_title = new Label(composite, SWT.LEFT);
		label_title.setText(labeltext);
		
		GridData gd2 = new GridData(SWT.FILL,SWT.FILL, true, false);
		Text label_content = new Text(composite, SWT.LEFT);
		label_content.setLayoutData(gd2);
		
		label_content.setText("...");
		label_content.setEditable(false);
		 
		return label_content;
	}
	
}
