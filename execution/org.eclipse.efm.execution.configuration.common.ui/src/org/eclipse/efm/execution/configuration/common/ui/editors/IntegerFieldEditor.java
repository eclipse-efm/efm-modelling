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
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class IntegerFieldEditor extends StringFieldEditor {

	private int fDefaultValue;

	private int minValidValue = -1;

    private int maxValidValue = Integer.MAX_VALUE;

    private static final int DEFAULT_TEXT_LIMIT = 10;


	public IntegerFieldEditor(AbstractConfigurationPage configurationPage,
			String storeKey, String labelText, Composite parent, int defaultValue) {
		this(configurationPage, storeKey, labelText, parent, DEFAULT_TEXT_LIMIT, defaultValue);
	}

	public IntegerFieldEditor(AbstractConfigurationPage configurationPage,
			String storeKey, String labelText, Composite parent, int textLimit, int defaultValue) {
		super( Integer.toString(defaultValue) , true );

		fDefaultValue = defaultValue;

		init(configurationPage, storeKey, labelText);

        setTextLimit(textLimit);
//        widthInChars = 5;
        setEmptyStringAllowed(false);
        setErrorMessage(JFaceResources
                .getString("IntegerFieldEditor.errorMessage"));//$NON-NLS-1$
        createControl(parent);
	}


    /**
     * Sets the range of valid values for this field.
     *
     * @param min the minimum allowed value (inclusive)
     * @param max the maximum allowed value (inclusive)
     */
    public void setValidRange(int min, int max) {
        minValidValue = min;
        maxValidValue = max;
        setErrorMessage(JFaceResources.format(
        		"IntegerFieldEditor.errorMessageRange", //$NON-NLS-1$
        		new Object[] { new Integer(min), new Integer(max) }));
    }

    @Override
	protected boolean checkState() {

        Text text = getTextControl();

        if (text == null) {
			return false;
		}

        String numberString = text.getText();
        try {
            int number = Integer.valueOf(numberString).intValue();
            if (number >= minValidValue && number <= maxValidValue) {
				clearErrorMessage();
				return true;
			}

			showErrorMessage();
			return false;

        } catch (NumberFormatException e1) {
            showErrorMessage();
        }

        return false;
    }




	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(getStoreKey(), fDefaultValue);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			setStringValue( Integer.toString(
					configuration.getAttribute(getStoreKey(), fDefaultValue)) );
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		if( isValid() ) {
			try {
				configuration.setAttribute(getStoreKey(), getIntValue());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}


    /**
     * Returns this field editor's current value as an integer.
     *
     * @return the value
     * @exception NumberFormatException if the <code>String</code> does not
     *   contain a parsable integer
     */
    public int getIntValue() throws NumberFormatException {
    	String value = getStringValue();
        return value.isEmpty() ? fDefaultValue : Integer.parseInt(value);
    }


}
