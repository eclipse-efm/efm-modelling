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

package org.eclipse.efm.execution.configuration.common.ui.api;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public interface IWidgetToolkit {

	///////////////////////////////////////////////////////////////////////////
	// Widget Toolkit Factory
	///////////////////////////////////////////////////////////////////////////

	/**
	 * Marks the control as visible if the argument is <code>true</code>,
	 * and marks it invisible and disable otherwise.
	 * @param control the receiver
	 * @param visible visible the new visibility state
	 */
	abstract public void setVisibleAndEnabled(Composite aComposite, boolean visible);
	
	public default void propagateVisibility(Composite aComposite, boolean visible) { 
		aComposite.setVisible(visible);

		Object gd = aComposite.getLayoutData();
		if (gd instanceof GridData) {
			GridData data = (GridData) gd;
			data.exclude = (! visible);
			aComposite.requestLayout();
		} else {
			//
		}
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
	abstract public void createSectionPart(AbstractSectionPart sectionPart,
			Composite parent, int style, IToolBarManager toolBarManager);

	/**
	 * Creates a CTabFolder
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new CTabFolder with a style
	 */
	public abstract CTabFolder createTabFolder(Composite parent, int style);


	/**
	 * Creates a composite
	 * @param parent the parent to add the composite to
	 * @return a new composite
	 */
	public Composite newComposite(Composite parent);

	/**
	 * Creates a composite
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new composite with a style
	 */
	public Composite newComposite(Composite parent, int style);

	/**
	 * Creates a composite that uses the parent's font and style and has a default grid layout
	 * @param parent the parent to add the composite to
	 * @return a new composite with a grid layout
	 */
	public default Composite createComposite(Composite parent) {
		return createComposite(parent, 1, 1, GridData.FILL_HORIZONTAL);
	}

	/**
	 * Creates a composite  that uses the parent's font and has a default grid layout and a style
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new composite with a grid layout
	 */
	public default Composite createComposite(Composite parent, int style) {
		return createComposite(parent, style, 1, 1, GridData.FILL_HORIZONTAL);
	}

	/**
	 * Creates a composite that uses the parent's font and has a grid layout
	 * @param parent the parent to add the composite to
	 * @param columns the number of columns the composite should have
	 * @param hspan the horizontal span the new composite should take up in the parent
	 * @param fill the fill style of the composite {@link GridData}
	 * @return a new composite with a grid layout
	 */
	public default Composite createComposite(
			Composite parent, int columns, int hspan, int fill)
	{
		Composite composite = newComposite(parent);
		composite.setLayout(new GridLayout(columns, false));
		composite.setFont(parent.getFont());
		GridData gd = new GridData(fill);
		gd.horizontalSpan = hspan;
		composite.setLayoutData(gd);
		return composite;
	}

	/**
	 * Creates a composite that uses the parent's font and has a grid layout
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @param columns the number of columns the composite should have
	 * @param hspan the horizontal span the new composite should take up in the parent
	 * @param fill the fill style of the composite {@link GridData}
	 * @return a new composite with a grid layout
	 */
	public default Composite createComposite(
			Composite parent, int style, int columns, int hspan, int fill)
	{
		Composite composite = newComposite(parent, style);
		composite.setLayout(new GridLayout(columns, false));
		composite.setFont(parent.getFont());
		GridData gd = new GridData(fill);
		gd.horizontalSpan = hspan;
		composite.setLayoutData(gd);
		return composite;
	}

	/**
	 * Creates a Composite widget
	 * @param parent the parent composite to add this composite to
	 * @param font the font to set on the control
	 * @param columns the number of columns within the composite
	 * @param hspan the horizontal span the composite should take up on the parent
	 * @param fill the style for how this composite should fill into its parent
	 * @return the new composite
	 */
	public default Composite createComposite(
			Composite parent, Font font, int columns, int hspan, int fill)
	{
		Composite gcomposite = newComposite(parent);
		gcomposite.setLayout(new GridLayout(columns, false));
		gcomposite.setFont(font);
		GridData gd = new GridData(fill);
		gd.horizontalSpan = hspan;
		gcomposite.setLayoutData(gd);
		return gcomposite;
	}

	/**
	 * Creates a Composite widget
	 * @param parent the parent composite to add this composite to
	 * @param font the font to set on the control
	 * @param columns the number of columns within the composite
	 * @param hspan the horizontal span the composite should take up on the parent
	 * @param fill the style for how this composite should fill into its parent
	 * @param marginwidth the width of the margin to place on the sides of the composite (default is 5, specified by GridLayout)
	 * @param marginheight the height of the margin to place o the top and bottom of the composite
	 * @return the new composite
	 */
	public default Composite createComposite(Composite parent, Font font,
			int columns, int hspan, int fill, int marginwidth, int marginheight)
	{
		Composite composite = newComposite(parent);
		GridLayout layout = new GridLayout(columns, false);
		layout.marginWidth = marginwidth;
		layout.marginHeight = marginheight;
		composite.setLayout(layout);
		composite.setFont(font);
		GridData gd = new GridData(fill);
		gd.horizontalSpan = hspan;
		composite.setLayoutData(gd);
		return composite;
	}


	/**
	 * Creates a ScrolledComposite
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new ScrolledComposite with a style
	 */
	public ScrolledComposite newScrolledComposite(Composite parent, int style);

	/**
	 * Creates a ScrolledComposite
	 * @param parent the parent to add the composite to
	 * @return a new ScrolledComposite with a style
	 */
	public default ScrolledComposite createScrolledComposite(Composite parent) {
		ScrolledComposite scrolledComposite =
				newScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL );

		scrolledComposite.setFont(parent.getFont());

		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setShowFocusedControl(true);

		return scrolledComposite;
	}



	/**
	 * Creates a group that uses the parent's style
	 * @param parent the parent to add the composite to
	 * @return a new group
	 */
	public default Group newGroup(Composite parent) {
		return newGroup(parent, parent.getStyle());
	}

	/**
	 * Creates a group that has a style
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new group with a style
	 */
	public Group newGroup(Composite parent, int style);

	/**
	 * Creates a Group widget
	 * @param parent the parent composite to add this group to
	 * @param text the text for the heading of the group
	 * @param columns the number of columns within the group
	 * @param hspan the horizontal span the group should take up on the parent
	 * @param fill the style for how this composite should fill into its parent
	 * @return the new group
	 *
	 */
	public default Group createGroup(
			Composite parent, String text, int columns, int hspan, int fill) {
		Group group = newGroup(parent, parent.getStyle());
		group.setLayout(new GridLayout(columns, false));
		
		if( text != null ) {
			group.setText(text);
		}

		group.setFont(parent.getFont());
		GridData gd = new GridData(fill);
		gd.horizontalSpan = hspan;
		group.setLayoutData(gd);
		return group;
	}


	/**
	 * Creates a button with the given label and style.
	 * @param parent parent control
	 * @param text button label or <code>null</code>
	 * @param style the style for the Button
	 * @return a new button
	 */
	public Button newButton(Composite parent, String text, int style);

	/**
	 * Returns a width hint for a button control.
	 */
	public default int getButtonWidthHint(Button button) {
		/*button.setFont(JFaceResources.getDialogFont());*/
		PixelConverter converter= new PixelConverter(button);
		int widthHint= converter.convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		return Math.max(widthHint, button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);
	}

	/**
	 * Sets width and height hint for the button control.
	 * <b>Note:</b> This is a NOP if the button's layout data is not
	 * an instance of <code>GridData</code>.
	 * @param button the button for which to set the dimension hint
	 */
	public default void setButtonDimensionHint(Button button) {
		Assert.isNotNull(button);
		Object gd= button.getLayoutData();
		if (gd instanceof GridData) {
			((GridData)gd).widthHint= getButtonWidthHint(button);
			((GridData)gd).horizontalAlignment = GridData.FILL;
		}
	}


	/**
	 * Creates and returns a new radio button with the given
	 * label.
	 *
	 * @param parent parent control
	 * @param text button label or <code>null</code>
	 *
	 * @return a new radio button
	 */
	public default Button createRadioButton(Composite parent, String text) {
		Button button = newButton(parent, text, SWT.RADIO);
		button.setFont(parent.getFont());
		GridData gd = new GridData();
		button.setLayoutData(gd);
		setButtonDimensionHint(button);
		return button;
	}

	/**
	 * Creates and returns a new push button with the given
	 * label and/or image.
	 * @param parent parent control
	 * @param text button label or <code>null</code>
	 * @return a new push button
	 */
	public default Button createPushButton(Composite parent, String text) {
		Button button = newButton(parent, text, SWT.PUSH);
		button.setFont(parent.getFont());
		GridData gd = new GridData();
		button.setLayoutData(gd);
		setButtonDimensionHint(button);
		return button;
	}


	/**
	 * Creates a button with the given label and style.
	 * @param parent parent control
	 * @param style the style for the Button
	 * @return a new button
	 */
	public Combo newCombo(Composite parent, int style);

	/**
	 * This method is used to make a combo box with a default fill style of GridData.FILL_HORIZONTAL
	 * @param parent the parent composite to add the new combo to
	 * @param style the style for the Combo
	 * @param hspan the horizontal span to take up on the parent composite
	 * @param items the item to put into the combo
	 * @return a new Combo instance
	 */
	public default Combo createCombo(Composite parent, int style, int hspan, String[] items) {
		Combo combo = newCombo(parent, style);
		combo.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = hspan;
		combo.setLayoutData(gd);
		if (items != null){
			combo.setItems(items);
		}
		// Some platforms open up combos in bad sizes without this, see bug 245569
		combo.setVisibleItemCount(30);
		combo.select(0);
		return combo;
	}

	/**
	 * Creates a new label widget
	 * @param parent the parent composite to add this label widget to
	 * @param text the text for the label
	 * @return the new label
	 *
	 */
	public Label newLabel(Composite parent, String text);

	/**
	 * Creates a new label widget
	 * @param parent the parent composite to add this label widget to
	 * @param text the text for the label
	 * @param style the style for the composite
	 * @return the new label
	 *
	 */
	public Label newLabel(Composite parent, String text, int style);

	/**
	 * Creates a new label widget
	 * @param parent the parent composite to add this label widget to
	 * @param text the text for the label
	 * @param hspan the horizontal span to take up in the parent composite
	 * @return the new label
	 *
	 */
	public default Label createLabel(Composite parent, String text, int hspan) {
		Label label = newLabel(parent, text);
		label.setFont(parent.getFont());
		
		if( text != null ) {
			label.setText(text);
		}

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = hspan;
		gd.grabExcessHorizontalSpace = false;
		label.setLayoutData(gd);
		return label;
	}


	/**
	 * Creates a new text widget
	 * @param parent the parent composite to add this text widget to
	 * @param value the value for the text widget
	 * @param style the style for the composite
	 * @return the new text widget
	 */
	public Text newText(Composite parent, String value, int style);

	/**
	 * Creates a new text widget
	 * @param parent the parent composite to add this text widget to
	 * @param style the style bits for the text widget
	 * @param hspan the horizontal span to take up on the parent composite
	 * @return the new text widget
	 * @since 3.3
	 */
	public default Text createText(Composite parent, int style, int hspan) {
		Text text = newText(parent, null, style);
		text.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = hspan;
		text.setLayoutData(gd);
		return text;
	}


	/**
	 * Creates a new text widget
	 * @param parent the parent composite to add this text widget to
	 * @param hspan the horizontal span to take up on the parent composite
	 * @return the new text widget
	 */
	public default Text createSingleText(Composite parent, int hspan) {
		Text t = newText(parent, null, SWT.SINGLE | SWT.BORDER);

		t.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = hspan;
		t.setLayoutData(gd);
		return t;
	}

}
