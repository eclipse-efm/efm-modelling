/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.efm.papyrus.m2t.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.designer.languages.common.extensionpoints.ILangCodegen2;
import org.eclipse.papyrus.designer.languages.common.extensionpoints.MethodInfo;
import org.eclipse.papyrus.designer.languages.common.extensionpoints.SyncInformation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;

public class LangCodegen implements ILangCodegen2 {

	public LangCodegen() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generateCode(IProject project, PackageableElement element, IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public IProject getTargetProject(PackageableElement pe, boolean createIfMissing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileName(IProject project, NamedElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cleanCode(IProject project, PackageableElement element, IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SyncInformation getSyncInformation(String methodName, String body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEligible(Element modelElement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSuffix(FILE_KIND fileKind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MethodInfo getMethodInfo(NamedElement operationOrBehavior) {
		// TODO Auto-generated method stub
		return null;
	}

}
