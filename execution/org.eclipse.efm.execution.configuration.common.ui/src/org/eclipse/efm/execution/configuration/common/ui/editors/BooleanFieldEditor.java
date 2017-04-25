/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - Initial API and implementation
 *     Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - New Interfacing (AbstractConfigurationPage)
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public class BooleanFieldEditor extends FieldEditor {

	private boolean fValue;
	private boolean fDefaultValue;

	/**
	 * Style constant (value <code>0</code>) indicating the default layout where
	 * the field editor's check box appears to the left of the label.
	 */
	public static final int DEFAULT = 0;

	/**
	 * Style constant (value <code>1</code>) indicating a layout where the field
	 * editor's label appears on the left with a check box on the right.
	 */
	public static final int SEPARATE_LABEL = 1;

	/**
	 * Style bits. Either <code>DEFAULT</code> or <code>SEPARATE_LABEL</code>.
	 */
	private int style;

	/**
	 * The previously selected, or "before", value.
	 */
	private boolean wasSelected;

	/**
	 * The checkbox control, or <code>null</code> if none.
	 */
	private Button checkBox = null;

	/**
	 * Creates a new boolean field editor
	 */
	public BooleanFieldEditor() {
	}

	/**
	 * Creates a boolean field editor in the given style.
	 *
	 * @param name
	 *            the name of the preference this field editor works on
	 * @param labelText
	 *            the label text of the field editor
	 * @param style
	 *            the style, either <code>DEFAULT</code> or
	 *            <code>SEPARATE_LABEL</code>
	 * @param parent
	 *            the parent of the field editor's control
	 * @see #DEFAULT
	 * @see #SEPARATE_LABEL
	 */
	public BooleanFieldEditor(AbstractConfigurationPage configurationPage,
			String storeKey, String labelText, int style, Composite parent, boolean defaultValue) {
		this.fDefaultValue = defaultValue;

		init(configurationPage, storeKey, labelText);
		this.style = style;
		createControl(parent);

	}

	/**
	 * Creates a boolean field editor in the default style.
	 *
	 * @param name
	 *            the name of the preference this field editor works on
	 * @param label
	 *            the label text of the field editor
	 * @param parent
	 *            the parent of the field editor's control
	 */
	public BooleanFieldEditor(AbstractConfigurationPage configurationPage,
			String storeKey, String labelText, Composite parent, boolean defaultValue) {
		this(configurationPage, storeKey, labelText, DEFAULT, parent, defaultValue);
	}

	public BooleanFieldEditor(AbstractConfigurationPage configurationPage,
			String storeKey, String labelText, Composite parent) {
		this(configurationPage, storeKey, labelText, DEFAULT, parent, false);
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {
		if (style == SEPARATE_LABEL) {
			numColumns--;
		}
		((GridData) checkBox.getLayoutData()).horizontalSpan = numColumns;
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		String text = getLabelText();
		switch (style) {
		case SEPARATE_LABEL:
			getLabelControl(parent);
			numColumns--;
			text = null;
			//$FALL-THROUGH$
		default:
			checkBox = getChangeControl(parent);
			GridData gd = new GridData();
			gd.horizontalSpan = numColumns;
			checkBox.setLayoutData(gd);
			if (text != null) {
				checkBox.setText(text);
			}
		}
	}

	/**
	 * Returns the control responsible for displaying this field editor's label.
	 * This method can be used to set a tooltip for a
	 * <code>BooleanFieldEditor</code>. Note that the normal pattern of
	 * <code>getLabelControl(parent).setToolTipText(tooltipText)</code> does not
	 * work for boolean field editors, as it can lead to duplicate text (see bug
	 * 259952).
	 *
	 * @param parent
	 *            the parent composite
	 * @return the control responsible for displaying the label
	 *
	 * @since 3.5
	 */
	public Control getDescriptionControl(Composite parent) {
		if (style == SEPARATE_LABEL) {
			return getLabelControl(parent);
		}
		return getChangeControl(parent);
	}

	/**
	 * Returns this field editor's current value.
	 *
	 * @return the value
	 */
	public boolean getBooleanValue() {
		return checkBox.getSelection();
	}

	/**
	 * Returns the change button for this field editor.
	 *
	 * @param parent
	 *            The Composite to create the receiver in.
	 *
	 * @return the change button
	 */
	protected Button getChangeControl(Composite parent) {
		if (checkBox == null) {
			checkBox = getConfigurationPage().getWidgetToolkit().newButton(
					parent, null, SWT.CHECK | SWT.LEFT);
			checkBox.setFont(parent.getFont());
			checkBox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					boolean isSelected = checkBox.getSelection();
					valueChanged(wasSelected, isSelected);
					wasSelected = isSelected;
				}
			});
			checkBox.addDisposeListener(new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent event) {
					checkBox = null;
				}
			});
		} else {
			checkParent(checkBox, parent);
		}
		return checkBox;
	}

	@Override
	public int getNumberOfControls() {
		switch (style) {
		case SEPARATE_LABEL:
			return 2;
		default:
			return 1;
		}
	}

	@Override
	public void setFocus() {
		if (checkBox != null) {
			checkBox.setFocus();
		}
	}

	@Override
	public void setLabelText(String text) {
		super.setLabelText(text);
		Label label = getLabelControl();
		if (label == null && checkBox != null) {
			checkBox.setText(text);
		}
	}

    /**
     * Sets the label control's tool tip text to the argument
     */
    public void setToolTipText(String string) {
    	if( checkBox != null ) {
    		checkBox.setToolTipText(string);
    	}
    	else {
    		super.setToolTipText(string);
    	}
    }

	/**
	 * Informs this field editor's listener, if it has one, about a change to
	 * the value (<code>VALUE</code> property) provided that the old and new
	 * values are different.
	 *
	 * @param oldValue
	 *            the old value
	 * @param newValue
	 *            the new value
	 */
	protected void valueChanged(boolean oldValue, boolean newValue) {
		setPresentsDefaultValue(false);
		if (oldValue != newValue) {
			fireStateChanged(fStoreKey, oldValue, newValue);
            fValue = newValue;
		}

        updateLaunchConfigurationDialog();
	}

	/*
	 * @see FieldEditor.setEnabled
	 */
	@Override
	public void setEnabled(boolean enabled, Composite parent) {
		// Only call super if there is a label already
		if (style == SEPARATE_LABEL) {
			super.setEnabled(enabled, parent);
		}
		getChangeControl(parent).setEnabled(enabled);
	}

	public void setEnabled(boolean enabled) {
        if( checkBox != null ) {
            if( style == SEPARATE_LABEL ) {
            	super.setEnabled(enabled, checkBox.getParent());
            }
        	checkBox.setEnabled(enabled);
        }
    }


	/**
	 * Adds the listener to the collection of listeners who will
	 * be notified when the control is selected by the user, by sending
	 * it one of the messages defined in the <code>SelectionListener</code>
	 * interface.
	 * @param listener
	 */
	public void addSelectionListener (SelectionListener listener) {
		if (checkBox != null) {
			checkBox.addSelectionListener(listener);
		}
	}



	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(getStoreKey(), fDefaultValue);

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			setBooleanValue( configuration.getAttribute(getStoreKey(), fDefaultValue) );
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void setBooleanValue(boolean bValue) {
		if( checkBox != null ) {
			fValue = checkBox.getSelection();

            if( fValue != bValue ) {
    			checkBox.setSelection( bValue );

                valueChanged(wasSelected, bValue);

                wasSelected = bValue;
            }
		}
	}


	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		if( isValid() ) {
			configuration.setAttribute(getStoreKey(), fValue);
		}
	}

}
