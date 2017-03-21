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
package org.eclipse.efm.ui.views.mitems;

import org.eclipse.efm.ui.views.SymbexWorkflowView;
import org.eclipse.efm.ui.views.gitems.*;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;



class SymbexContentProvider implements ITreeContentProvider {

	private SymbexWorkflowView parentView;
	
	public SymbexContentProvider(SymbexWorkflowView parentView) {
		this.parentView = parentView;
	}
	
	
	public void inputChanged(Viewer v, Object oldInput, Object newInput){} 
	
	public void dispose() {}
	
	@Override
	public Object[] getElements(Object parent) {
//		if (parent.equals(parentView.getViewSite())) {
//			if (parentView.invisibleRoot == null) {
//				parentView.initialize();
//			}
//			return getChidlren(parentView.invisibleRoot);
//		}
		return getChildren(parent);
	}
	
	@Override
	public Object getParent(Object child) {
		if (child instanceof TreeObject) {
			return ((TreeObject) child).getParent();
		}
		return null;
	}
	
	@Override
	public Object[] getChildren(Object parent) {
		if (parent instanceof TreeParent) {
			return ((TreeParent) parent).getChildren();
		}
		return new Object[0];
	}

	@Override
	public boolean hasChildren(Object parent) {
		if (parent instanceof TreeParent) {
			return ((TreeParent) parent).hasChildren();
		}
		return false;
	}

}
