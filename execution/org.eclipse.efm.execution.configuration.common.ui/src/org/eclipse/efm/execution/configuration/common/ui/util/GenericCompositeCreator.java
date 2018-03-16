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
package org.eclipse.efm.execution.configuration.common.ui.util;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class GenericCompositeCreator {

	public static Text createComposite_label_text_from_toolkit(FormToolkit toolkit, Composite parentComposite, String labeltext, int colnum) {

		Composite composite = toolkit.createComposite(parentComposite);

		GridLayout gl = new GridLayout(colnum, false);
		composite.setLayout(gl);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		composite.setLayoutData(gd);

		toolkit.createLabel(composite, labeltext);

		GridData gd2 = new GridData(SWT.FILL,SWT.FILL, true, false);

		Text label_content = toolkit.createText(composite, "...");
		label_content.setLayoutData(gd2);
		label_content.setEditable(false);

		return label_content;
	}

	public static Button createComposite_label_pushbutton_from_toolkit(FormToolkit toolkit,
			Composite parentComposite, String labeltext, String buttontext, int colnum)
	{
		Composite composite = toolkit.createComposite(parentComposite);

		GridLayout gl = new GridLayout(colnum, false);
		composite.setLayout(gl);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		composite.setLayoutData(gd);

		toolkit.createLabel(composite, labeltext);

		//GridData gd2 = new GridData(SWT.FILL,SWT.FILL, true, false);

		Button button = toolkit.createButton(composite, buttontext, SWT.PUSH);
//		Text label_content = toolkit.createText(composite, "...");
//		label_content.setLayoutData(gd2);
//		label_content.setEditable(false);

		return button;
	}



	public static Combo createComposite_combo_text_from_toolkit(
			FormToolkit toolkit, Composite parentComposite, String labeltext, int colnum) {

		Composite composite = toolkit.createComposite(parentComposite);

		//RowLayout rl = new RowLayout(SWT.HORIZONTAL);
		//rl.wrap = false;
		GridLayout gl = new GridLayout(colnum, false);
		//GridLayout gl = new GridLayout(0, 2);
		//GridLayout gl = new GridLayout();
		//gl.numColumns = 2; // colnum
		//RowLayout rl = new RowLayout(SWT.HORIZONTAL);
		composite.setLayout(gl);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
//		RowData rd = new RowData();
		composite.setLayoutData(gd);


		//Composite labelhost = toolkit.createComposite(composite);
		//labelhost.setLa
		Label lbl = toolkit.createLabel(composite, labeltext);
		lbl.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		//Label lbl = new Label(composite, SWT.NONE);
		//lbl.setText(labeltext);

		//Composite combohost = toolkit.createComposite(composite);

		//CCombo ccombo = new CCombo(composite, SWT.READ_ONLY);


		//GridData gdlb = new GridData(SWT.LEFT,SWT.TOP, false, false);
		//GridData gdlb = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		//gdlb.horizontalSpan = 2;
		//lbl.setLayoutData(gdlb);

		//GridData gdcb = new GridData(SWT.RIGHT,SWT.TOP, true, false);

		Combo combo = new Combo(composite, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
//		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		combo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		//combo.setLayoutData(gdcb);
		//combo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		toolkit.adapt(combo, true, true);

		return combo;
	}

	public static void recursiveSetEnabled(Control ctrl, boolean enabled) {
		if (ctrl instanceof Composite) {
			Composite comp = (Composite) ctrl;
			for (Control c : comp.getChildren())
				recursiveSetEnabled(c, enabled);
		} else {
			ctrl.setEnabled(enabled);
		}
	}


	public static void fillToolBar(IToolBarManager manager, Action[] acts) {
		for(Action action: acts) {
			manager.add(action);
		}
	}
}
