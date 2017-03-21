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
package org.eclipse.efm.ui.views.gitems;

import org.eclipse.core.resources.IResource;

public class TreeObject {

	private String name;
	private TreeParent parent;
	private IResource resource;
	
	public TreeObject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setParent(TreeParent parent) {
		this.parent = parent;
	}
	
	public TreeParent getParent() {
		return parent;
	}
	
	public String toString() {
		return getName();
	}
	
	public Object getAdapter(Class key) {
		return null;
	}
	
	protected IResource getResource() {
		return resource;
	}
	
	protected void setResource(IResource resource) {
		this.resource = resource;
	}
}
