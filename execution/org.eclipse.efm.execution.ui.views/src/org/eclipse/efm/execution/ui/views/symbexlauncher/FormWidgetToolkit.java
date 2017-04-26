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
package org.eclipse.efm.execution.ui.views.symbexlauncher;

import org.eclipse.efm.execution.configuration.common.ui.api.AbstractSectionPart;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class FormWidgetToolkit extends FormToolkit implements IWidgetToolkit {

	public FormWidgetToolkit(Display display) {
		super(display);
	}


	/**
	 * Marks the control as visible if the argument is <code>true</code>,
	 * and marks it invisible otherwise.
	 * @param control the receiver
	 * @param visible visible the new visibility state
	 */
	public void setVisibleAndEnabled(Composite aComposite, boolean visible) {
		if( aComposite instanceof ExpandableComposite ) {
			((ExpandableComposite)aComposite).setExpanded(visible);
		} else {
			propagateVisibility(aComposite, visible);
		}
		
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
		Section section = super.createSection(parent, style);
		
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		section.setLayoutData(gd);
		
		String text = sectionPart.getSectionTitle();
		if( text != null ) {
			section.setText(text);
		}
		
		text = sectionPart.getSectionDescription();
		if( text != null ) {
			section.setDescription(text);
		}

		if (toolBarManager != null) {
			ToolBar toolbar = ((ToolBarManager) toolBarManager).createControl(section);
			section.setTextClient(toolbar);
		}
		
		Composite sectionClient = createComposite(section);
		sectionClient.setLayout(new GridLayout());

		section.setClient(sectionClient);
		
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
		super.adapt(tabFolder, true, true);

		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true, 2, 1);
//		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		gd.heightHint = 2;
		tabFolder.setLayoutData(gd);

		FormColors colors = super.getColors();
		tabFolder.setSelectionBackground(
				new Color[] {
						colors.getColor(IFormColors.TB_BG),
						colors.getBackground()
					},
				new int[] {100}, true);

		return tabFolder;
	}

	/**
	 * Creates a composite
	 * @param parent the parent to add the composite to
	 * @return a new composite
	 */
	@Override
	public Composite newComposite(Composite parent) {
		return super.createComposite(parent);
	}

	/**
	 * Creates a composite
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new composite with a style
	 */
	@Override
	public Composite newComposite(Composite parent, int style) {
		return super.createComposite(parent, style);
	}

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
	 * Creates a group that has a style
	 * @param parent the parent to add the composite to
	 * @param style the style for the composite
	 * @return a new group with a style
	 */
	@Override
	public Group newGroup(Composite parent, int style) {
		Group group = new Group(parent, style);

		super.adapt(group, true, true);

		return group;
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
		return super.createButton(parent, text, style);
	}


	/**
	 * Creates a button with the given label and style.
	 * @param parent parent control
	 * @param style the style for the Button
	 * @return a new button
	 */
	public Combo newCombo(Composite parent, int style) {
		Combo combo = new Combo(parent, style);

		super.adapt(combo, true, true);

		return combo;
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
		return super.createLabel(parent, text);
	}

	@Override
	public Label newLabel(Composite parent, String text, int style) {
		return super.createLabel(parent, text, style);
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
		return super.createText(parent, value, style);
	}

}
