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
package org.eclipse.efm.ui.views.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class GenericCompositeCreator {
	
	public static Text createComposite_label_text_from_toolkit(FormToolkit toolkit, Composite parentComposite, String labeltext, int colnum) {
		
		Composite composite = toolkit.createComposite(parentComposite);
		
		GridLayout gl = new GridLayout(colnum, false);
		composite.setLayout(gl);
		
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		composite.setLayoutData(gd);
		
		toolkit.createLabel(composite, labeltext);
		
		GridData gd2 = new GridData(SWT.FILL,SWT.FILL, true, false);
		
		Text label_content = toolkit.createText(composite, "...");
		label_content.setLayoutData(gd2);
		label_content.setEditable(false);
		 
		return label_content;
	}
	
}
