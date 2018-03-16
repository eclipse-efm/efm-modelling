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

import org.eclipse.core.runtime.Assert;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public abstract class FieldEditor {

	protected String fStoreKey;

	public String getStoreKey() {
		return fStoreKey;
	}


    /**
     * Property name constant (value <code>"field_editor_is_valid"</code>)
     * to signal a change in the validity of the value of this field editor.
     */
    public static final String IS_VALID = "field_editor_is_valid";//$NON-NLS-1$

    /**
     * Gap between label and control.
     */
    protected static final int HORIZONTAL_GAP = 8;

    /**
     * Indicates whether the default value is currently displayed,
     * initially <code>false</code>.
     */
    private boolean isDefaultPresented = false;

    /**
     * The label's text.
     */
    private String labelText;

    /**
     * The label control.
     */
    private Label label;

    /**
     * Listener, or <code>null</code> if none
     */
    private IPropertyChangeListener propertyChangeListener;

    /**
     * The page containing this field editor
     */
    private AbstractConfigurationPage fConfigurationPage;


    /**
     * Creates a new field editor.
     */
    protected FieldEditor() {
    }

   /**
     * Creates a new field editor.
     *
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param parent the parent of the field editor's control
     */
    protected FieldEditor(AbstractConfigurationPage configurationPage,
    		String storeKey, String labelText, Composite parent) {
    	this.fConfigurationPage = configurationPage;
    	this.fStoreKey = storeKey;
        createControl(parent);
    }

    /**
     * Adjusts the horizontal span of this field editor's basic controls.
     * <p>
     * Subclasses must implement this method to adjust the horizontal span
     * of controls so they appear correct in the given number of columns.
     * </p>
     * <p>
     * The number of columns will always be equal to or greater than the
     * value returned by this editor's <code>getNumberOfControls</code> method.
     *
     * @param numColumns the number of columns
     */
    protected abstract void adjustForNumColumns(int numColumns);

    /**
     * Applies a font.
     * <p>
     * The default implementation of this framework method
     * does nothing. Subclasses should override this method
     * if they want to change the font of the SWT control to
     * a value different than the standard dialog font.
     * </p>
     */
    protected void applyFont() {
    }

    /**
     * Checks if the given parent is the current parent of the
     * supplied control; throws an (unchecked) exception if they
     * are not correctly related.
     *
     * @param control the control
     * @param parent the parent control
     */
    protected void checkParent(Control control, Composite parent) {
        Assert.isTrue(control.getParent() == parent, "Different parents");//$NON-NLS-1$
    }

    /**
     * Clears the error message from the message line.
     */
    protected void clearErrorMessage() {
        if (fConfigurationPage != null) {
        	fConfigurationPage.clearErrorMessage();
		}
    }

    /**
     * Clears the normal message from the message line.
     */
    protected void clearMessage() {
        if (fConfigurationPage != null) {
        	fConfigurationPage.propagateMessage(null);
		}
    }

    /**
     * Returns the number of pixels corresponding to the
     * given number of horizontal dialog units.
     * <p>
     * Clients may call this framework method, but should not override it.
     * </p>
     *
     * @param control the control being sized
     * @param dlus the number of horizontal dialog units
     * @return the number of pixels
     */
    protected int convertHorizontalDLUsToPixels(Control control, int dlus) {
        GC gc = new GC(control);
        gc.setFont(control.getFont());
        int averageWidth = gc.getFontMetrics().getAverageCharWidth();
        gc.dispose();

        double horizontalDialogUnitSize = averageWidth * 0.25;

        return (int) Math.round(dlus * horizontalDialogUnitSize);
    }

    /**
     * Returns the number of pixels corresponding to the
     * given number of vertical dialog units.
     * <p>
     * Clients may call this framework method, but should not override it.
     * </p>
     *
     * @param control the control being sized
     * @param dlus the number of vertical dialog units
     * @return the number of pixels
     */
    protected int convertVerticalDLUsToPixels(Control control, int dlus) {
        GC gc = new GC(control);
        gc.setFont(control.getFont());
        int height = gc.getFontMetrics().getHeight();
        gc.dispose();

        double verticalDialogUnitSize = height * 0.125;

        return (int) Math.round(dlus * verticalDialogUnitSize);
    }

    /**
     * Creates this field editor's main control containing all of its
     * basic controls.
     *
     * @param parent the parent control
     */
    protected void createControl(Composite parent) {
        GridLayout layout = new GridLayout();
        layout.numColumns = getNumberOfControls();
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        layout.horizontalSpacing = HORIZONTAL_GAP;
        parent.setLayout(layout);
        doFillIntoGrid(parent, layout.numColumns);
    }

    /**
     * Disposes the SWT resources used by this field editor.
     */
    public void dispose() {
        // nothing to dispose
    }

    /**
     * Fills this field editor's basic controls into the given parent.
     * <p>
     * Subclasses must implement this method to create the controls
     * for this field editor.
     * </p>
     * <p>
     * Note this method may be called by the constructor, so it must not access
     * fields on the receiver object because they will not be fully initialized.
     * </p>
     *
     * @param parent the composite used as a parent for the basic controls;
     *	the parent's layout must be a <code>GridLayout</code>
     * @param numColumns the number of columns
     */
    protected abstract void doFillIntoGrid(Composite parent, int numColumns);

//    /**
//     * Initializes this field editor with the preference value from
//     * the preference store.
//     * <p>
//     * Subclasses must implement this method to properly initialize
//     * the field editor.
//     * </p>
//     */
//    protected abstract void doLoad();
//
//    /**
//     * Initializes this field editor with the default preference value from
//     * the preference store.
//     * <p>
//     * Subclasses must implement this method to properly initialize
//     * the field editor.
//     * </p>
//     */
//    protected abstract void doLoadDefault();
//
//    /**
//     * Stores the preference value from this field editor into
//     * the preference store.
//     * <p>
//     * Subclasses must implement this method to save the entered value
//     * into the preference store.
//     * </p>
//     */
//    protected abstract void doStore();

    /**
     * Fills this field editor's basic controls into the given parent.
     *
     * @param parent the composite used as a parent for the basic controls;
     *	the parent's layout must be a <code>GridLayout</code>
     * @param numColumns the number of columns
     */
    public void fillIntoGrid(Composite parent, int numColumns) {
        Assert.isTrue(numColumns >= getNumberOfControls());
        Assert.isTrue(parent.getLayout() instanceof GridLayout);
        doFillIntoGrid(parent, numColumns);
    }

    /**
     * Informs this field editor's listener, if it has one, about a change to
     * one of this field editor's boolean-valued properties. Does nothing
     * if the old and new values are the same.
     *
     * @param property the field editor property name,
     *   such as <code>VALUE</code> or <code>IS_VALID</code>
     * @param oldValue the old value
     * @param newValue the new value
     */
    protected void fireStateChanged(String property, boolean oldValue,
            boolean newValue) {
        if (oldValue == newValue) {
			return;
		}
        fireValueChanged(property, oldValue ? Boolean.TRUE : Boolean.FALSE, newValue ? Boolean.TRUE : Boolean.FALSE);
    }

    /**
     * Informs this field editor's listener, if it has one, about a change to
     * one of this field editor's properties.
     *
     * @param property the field editor property name,
     *   such as <code>VALUE</code> or <code>IS_VALID</code>
     * @param oldValue the old value object, or <code>null</code>
     * @param newValue the new value, or <code>null</code>
     */
    protected void fireValueChanged(String property, Object oldValue,
            Object newValue) {
        if (propertyChangeListener == null) {
			return;
		}
        propertyChangeListener.propertyChange(new PropertyChangeEvent(this,
                property, oldValue, newValue));
    }

    /**
     * Returns the symbolic font name used by this field editor.
     *
     * @return the symbolic font name
     */
    public String getFieldEditorFontName() {
        return JFaceResources.DIALOG_FONT;
    }


    /**
     * Sets the label control's tool tip text to the argument
     */
    public void setToolTipText(String string) {
    	Label control = getLabelControl();
    	if( control != null ) {
    		control.setToolTipText(string);
    	}
    }


    /**
     * Returns the label control.
     *
     * @return the label control, or <code>null</code>
     *  if no label control has been created
     */
    protected Label getLabelControl() {
        return label;
    }

    /**
     * Returns this field editor's label component.
     * <p>
     * The label is created if it does not already exist
     * </p>
     *
     * @param parent the parent
     * @return the label control
     */
    public Label getLabelControl(Composite parent) {
        if (label == null) {
            label = fConfigurationPage.getWidgetToolkit().newLabel(
            		parent, getLabelText(), SWT.LEFT);
            label.setFont(parent.getFont());
            label.addDisposeListener(new DisposeListener() {
                @Override
				public void widgetDisposed(DisposeEvent event) {
                    label = null;
                }
            });
        } else {
            checkParent(label, parent);
        }
        return label;
    }

    /**
     * Returns this field editor's label text.
     *
     * @return the label text
     */
    public String getLabelText() {
        return labelText;
    }

    /**
     * Returns the number of basic controls this field editor consists of.
     *
     * @return the number of controls
     */
    public abstract int getNumberOfControls();

    /**
     * Return the DialogPage that the receiver is sending
     * updates to.
     *
     * @return DialogPage or <code>null</code> if it
     * has not been set.
     *
     * @since 3.1
     */
    protected AbstractConfigurationPage getConfigurationPage() {
    	return fConfigurationPage;
    }


    /**
     * Initialize the field editor with the given preference name and label.
     *
     * @param name the name of the preference this field editor works on
     * @param text the label text of the field editor
     */
    protected void init(AbstractConfigurationPage configurationPage,
    		String storeKey, String labelText) {
        Assert.isNotNull(configurationPage);
    	this.fConfigurationPage = configurationPage;

        Assert.isNotNull(storeKey);
    	this.fStoreKey = storeKey;

        Assert.isNotNull(labelText);
        this.labelText = labelText;

        // @NOT SYSTEMATIC, used with parsimony
//      setPropertyChangeListener( configurationPage );
    }

    /**
     * Returns whether this field editor contains a valid value.
     * <p>
     * The default implementation of this framework method
     * returns <code>true</code>. Subclasses wishing to perform
     * validation should override both this method and
     * <code>refreshValidState</code>.
     * </p>
     *
     * @return <code>true</code> if the field value is valid,
     *   and <code>false</code> if invalid
     * @see #refreshValidState()
     */
    public boolean isValid() {
        return true;
    }

//    /**
//     * Initializes this field editor with the preference value from
//     * the preference store.
//     */
//    public void load() {
//        if (preferenceStore != null) {
//            isDefaultPresented = false;
//            doLoad();
//            refreshValidState();
//        }
//    }
//
//    /**
//     * Initializes this field editor with the default preference value
//     * from the preference store.
//     */
//    public void loadDefault() {
//        if (preferenceStore != null) {
//            isDefaultPresented = true;
//            doLoadDefault();
//            refreshValidState();
//        }
//    }

    /**
     * Returns whether this field editor currently presents the
     * default value for its preference.
     *
     * @return <code>true</code> if the default value is presented,
     *   and <code>false</code> otherwise
     */
    public boolean presentsDefaultValue() {
        return isDefaultPresented;
    }

    /**
     * Refreshes this field editor's valid state after a value change
     * and fires an <code>IS_VALID</code> property change event if
     * warranted.
     * <p>
     * The default implementation of this framework method does
     * nothing. Subclasses wishing to perform validation should override
     * both this method and <code>isValid</code>.
     * </p>
     *
     * @see #isValid
     */
    protected void refreshValidState() {
    }

    /**
     * Sets the focus to this field editor.
     * <p>
     * The default implementation of this framework method
     * does nothing. Subclasses may reimplement.
     * </p>
     */
    public void setFocus() {
        // do nothing;
    }

    /**
     * Sets this field editor's label text.
     * The label is typically presented to the left of the entry field.
     *
     * @param text the label text
     */
    public void setLabelText(String text) {
        Assert.isNotNull(text);
        labelText = text;
        if (label != null) {
			label.setText(text);
		}
    }

    /**
     * Sets whether this field editor is presenting the default value.
     *
     * @param booleanValue <code>true</code> if the default value is being presented,
     *  and <code>false</code> otherwise
     */
    protected void setPresentsDefaultValue(boolean booleanValue) {
        isDefaultPresented = booleanValue;
    }

    /**
     * Sets or removes the property change listener for this field editor.
     * <p>
     * Note that field editors can support only a single listener.
     * </p>
     *
     * @param listener a property change listener, or <code>null</code>
     *  to remove
     */
    public void setPropertyChangeListener(IPropertyChangeListener listener) {
        propertyChangeListener = listener;
    }

    /**
     * Shows the given error message in the page for this
     * field editor if it has one.
     *
     * @param msg the error message
     */
    protected void showErrorMessage(String msg) {
        if (fConfigurationPage != null) {
			fConfigurationPage.propagateErrorMessage(msg);
		}
    }

    /**
     * Shows the given message in the page for this
     * field editor if it has one.
     *
     * @param msg the message
     */
    protected void showMessage(String msg) {
        if (fConfigurationPage != null) {
			fConfigurationPage.propagateMessage(msg);
		}
    }

    public void updateLaunchConfigurationDialog() {
        if (fConfigurationPage != null) {
			fConfigurationPage.propagateGUIupdate();
		}
    }

//    /**
//     * Stores this field editor's value back into the preference store.
//     */
//    public void store() {
//        if (preferenceStore == null) {
//			return;
//		}
//
//        if (isDefaultPresented) {
//            preferenceStore.setToDefault(fStoreKey);
//        } else {
//            doStore();
//        }
//    }

    /**
     * Set the GridData on button to be one that is spaced for the
     * current font.
     * @param button the button the data is being set on.
     */

    protected void setButtonLayoutData(Button button) {

        GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

        // Compute and store a font metric
        GC gc = new GC(button);
        gc.setFont(button.getFont());
        FontMetrics fontMetrics = gc.getFontMetrics();
        gc.dispose();

        int widthHint = org.eclipse.jface.dialogs.Dialog
                .convertVerticalDLUsToPixels(fontMetrics,
                        IDialogConstants.BUTTON_WIDTH);
        data.widthHint = Math.max(widthHint, button.computeSize(SWT.DEFAULT,
                SWT.DEFAULT, true).x);
        button.setLayoutData(data);
    }

    /**
     * Set whether or not the controls in the field editor
     * are enabled.
     * @param enabled The enabled state.
     * @param parent The parent of the controls in the group.
     *  Used to create the controls if required.
     */
    public void setEnabled(boolean enabled, Composite parent) {
        getLabelControl(parent).setEnabled(enabled);
    }


	/**
	 * Diversity Field Editor Configuration API
	 * @param configuration
	 */
    abstract protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration);

	public final void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		setDefaultsImpl(configuration);

		refreshValidState();
	}

	abstract protected void initializeFromImpl(ILaunchConfiguration configuration);

	public final void initializeFrom(ILaunchConfiguration configuration) {
		initializeFromImpl(configuration);

		refreshValidState();
	}

	abstract protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration);

	public final void performApply(ILaunchConfigurationWorkingCopy configuration) {
		performApplyImpl(configuration);
	}

}
