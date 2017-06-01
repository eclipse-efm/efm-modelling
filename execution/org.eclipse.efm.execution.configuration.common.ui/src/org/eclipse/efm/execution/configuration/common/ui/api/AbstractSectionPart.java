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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.editors.FieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractSectionPart {
	
    /**
     * The field editors, or <code>null</code> if not created yet.
     */
    private List<FieldEditor> fFields = null;


	private Composite fSection;
	
	private Composite fSectionClient;

	
	public AbstractSectionPart() {
		this.fFields = null;
		
		this.fSection = null;
		this.fSectionClient = null;
	}

	// Title / Description
	public abstract String getSectionTitle();

	public abstract String getSectionDescription();

	
	// The Section part
	public Composite getSection() {
		return fSection;
	}
	
	public void setSection(Composite section) {
		fSection = section;
	}
	
	
	// The Client of the Section
	public Composite getSectionClient() {
		return fSectionClient;
	}
	
	public void setSectionClient(Composite sectionClient) {
		fSectionClient = sectionClient;
	}

	
	public Composite getControl() {
		return fSection;
	}


	///////////////////////////////////////////////////////////////////////////
	// Fields Editors API
	///////////////////////////////////////////////////////////////////////////
	
    /**
     * Adds the given field editor to this page.
     * @param editor the field editor
     */
    protected void addField(FieldEditor editor) {
        if (fFields == null) {
			fFields = new ArrayList<>();
		}
        fFields.add(editor);
    }

	public List<FieldEditor> getFieldEditors() {
		return fFields;
	}

	
	
	abstract protected void setDefaultsImpl(
			ILaunchConfigurationWorkingCopy configuration);

	public final void setDefaults(
			ILaunchConfigurationWorkingCopy configuration) {
		if( fFields != null ) {
			for (FieldEditor fieldEditor : fFields) {
				fieldEditor.setDefaults(configuration);
			}
		}
		
		setDefaultsImpl(configuration);
	}

	
	abstract protected void initializeFromImpl(ILaunchConfiguration configuration);

	public final void initializeFrom(ILaunchConfiguration configuration) {
		if( fFields != null ) {
			for (FieldEditor fieldEditor : fFields) {
				fieldEditor.initializeFrom(configuration);
			}
		}
		
		initializeFromImpl( configuration );
	}

	
	abstract protected void performApplyImpl(
			ILaunchConfigurationWorkingCopy configuration);

	public final void performApply(
			ILaunchConfigurationWorkingCopy configuration) {
		if( fFields != null ) {
			for (FieldEditor fieldEditor : fFields) {
				fieldEditor.performApply(configuration);
			}
		}
		
		performApplyImpl(configuration);
	}


	abstract protected boolean isValidImpl(ILaunchConfiguration launchConfig);

	public final boolean isValid(ILaunchConfiguration launchConfig) {
		if( isValidImpl(launchConfig) ) {
			if( fFields != null ) {
				for (FieldEditor fieldEditor : fFields) {
					if( ! fieldEditor.isValid() ) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}


	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	public void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		//!! Default 
	}

}
