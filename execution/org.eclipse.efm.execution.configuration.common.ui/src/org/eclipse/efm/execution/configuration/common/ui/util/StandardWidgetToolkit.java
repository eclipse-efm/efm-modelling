/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.util;

import org.eclipse.efm.execution.configuration.common.ui.api.AbstractSectionPart;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class StandardWidgetToolkit implements IWidgetToolkit {


	/**
	 * Marks the control as visible an enabled if the argument is <code>true</code>,
	 * and marks it invisible otherwise.
	 * @param control the receiver
	 * @param visible visible the new visibility state
	 */
	public void setVisibleAndEnabled(Composite aComposite, boolean visible) {
		propagateVisibility(aComposite, visible);
		
		aComposite.setEnabled(visible);
	}
	
	
	/**
	 * Creates a section as a part of the form.
	 * @param parent the section parent
	 * @param style the section style
	 * @param toolBarManager the section toolbar manager
	 * @param title the description title
	 * @param description the description text
	 * @return the section widget
	 */
	public void createSectionPart(AbstractSectionPart sectionPart,
			Composite parent, int style, IToolBarManager toolBarManager)
	{
		Group section = createGroup(parent,
				sectionPart.getSectionTitle(),
				1, 1, GridData.FILL_HORIZONTAL);

		Composite sectionClient = createComposite(section, 1, 1, GridData.FILL_HORIZONTAL);
		
		String text = sectionPart.getSectionDescription();
		if( text != null ) {
			createLabel(sectionClient, text, 2);
		}

		sectionPart.setSection(section);
		sectionPart.setSectionClient(sectionClient);
	}

	/**
	 * Creates a CTabFolder
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new CTabFolder with a style
	 */
	public CTabFolder createTabFolder(Composite parent, int style) {
		CTabFolder tabFolder = new CTabFolder( parent, style );
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true, 2, 1);
//		gd.heightHint = 2;
		tabFolder.setLayoutData(gd);

		return tabFolder;
	}


	/**
	 * Creates a composite
	 * @param parent the parent to add the composite to
	 * @return a new composite
	 */
	@Override
	public Composite newComposite(Composite parent) {
		return new Composite(parent, SWT.NONE);
	}


	/**
	 * Creates a composite
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new composite with a style
	 */
	@Override
	public Composite newComposite(Composite parent, int style) {
		return new Composite(parent, style);
	}


	/**
	 * Creates a ScrolledComposite
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new ScrolledComposite with a style
	 */
	/**
	 * Creates a ScrolledComposite
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new ScrolledComposite with a style
	 */
	public ScrolledComposite newScrolledComposite(Composite parent, int style) {
		return new ScrolledComposite(parent, style);
	}


	/**
	 * Creates a group
	 * @param parent the parent to add the composite to
	 * @return a new group  with a style
	 */
	@Override
	public Group newGroup(Composite parent, int style) {
		return new Group(parent, style);
	}


	/**
	 * Creates a button with the given label and style.
	 * @param parent parent control
	 * @param text button label or <code>null</code>
	 * @param style the style for the Button
	 * @return a new button
	 */
	@Override
	public Button newButton(Composite parent, String text, int style) {
		Button button = new Button(parent, style | SWT.FLAT );
		if (text != null) {
			button.setText(text);
		}
		return button;
	}

	/**
	 * Creates a button with the given label and style.
	 * @param parent parent control
	 * @param style the style for the Button
	 * @return a new button
	 */
	public Combo newCombo(Composite parent, int style) {
		return new Combo(parent, style);
	}


	/**
	 * Creates a new label widget
	 * @param parent the parent composite to add this label widget to
	 * @param text the text for the label
	 * @return the new label
	 *
	 */
	@Override
	public Label newLabel(Composite parent, String text) {
		Label label = new Label(parent, parent.getStyle());
		label.setText(text);

		return label;
	}

	/**
	 * Creates a new label widget
	 * @param parent the parent composite to add this label widget to
	 * @param text the text for the label
	 * @param style the style for the composite
	 * @return the new label
	 *
	 */
	@Override
	public Label newLabel(Composite parent, String text, int style) {
		Label label = new Label(parent, style);
		if( text != null ) {
			label.setText(text);
		}

		return label;
	}


	/**
	 * Creates a new text widget
	 * @param parent the parent composite to add this text widget to
	 * @param value the value for the text widget
	 * @param style the style for the composite
	 * @return the new text widget
	 */
	@Override
	public Text newText(Composite parent, String value, int style) {
		Text text = new Text(parent, style);

		if (value != null) {
			text.setText(value);
		}

		return text;
	}


}
