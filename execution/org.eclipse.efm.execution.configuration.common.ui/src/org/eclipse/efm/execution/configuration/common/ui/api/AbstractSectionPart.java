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

import org.eclipse.swt.widgets.Composite;

public abstract class AbstractSectionPart {
	
	private Composite fSection;
	
	private Composite fSectionClient;


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

	
	// Layout
	public void updateLayouts() {
		fSectionClient.layout(true);
		
		fSection.layout(true);
		
		fSectionClient.layout(true);
	}

	public void requestLayout() {
		fSection.layout();
		fSection.requestLayout();
	}


}
