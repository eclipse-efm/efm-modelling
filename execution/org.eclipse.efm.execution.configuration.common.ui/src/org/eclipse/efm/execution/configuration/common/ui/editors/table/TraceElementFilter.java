/*******************************************************************************
 * Copyright (c) 2016 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.editors.table;

import org.eclipse.efm.execution.core.workflow.common.TraceElement;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class TraceElementFilter extends ViewerFilter {

	private String searchString;

	public void setSearchText(String s) {
		// ensure that the value can be used for matching
		this.searchString = ".*" + s + ".*";
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if( searchString == null || searchString.length() == 0 ) {
			return true;
		}

		TraceElement traceElement = (TraceElement) element;

		if ( traceElement.getNature().getLiteral().matches(searchString) ) {
			return true;
		}

		if( traceElement.getValue().toString().matches(searchString) ) {
			return true;
		}

		return false;
	}
}
