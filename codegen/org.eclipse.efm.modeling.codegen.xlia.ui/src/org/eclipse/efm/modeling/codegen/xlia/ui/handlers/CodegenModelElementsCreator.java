/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.ui.handlers;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.efm.modeling.codegen.xlia.core.MainCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.util.SimpleLogger;
import org.eclipse.papyrus.designer.languages.common.base.HierarchyLocationStrategy;
import org.eclipse.papyrus.designer.languages.common.base.ModelElementsCreator;
import org.eclipse.papyrus.infra.tools.file.ProjectBasedFileAccess;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;

public class CodegenModelElementsCreator extends ModelElementsCreator {

	public static final String FML_GEN_FOLDER = "fml-gen"; //$NON-NLS-1$

	public static final String FML_LANGUAGE = "formalML"; //$NON-NLS-1$

	protected MainCodeGenerator fCodeGenerator;

	public CodegenModelElementsCreator(IProject project) {
		super(new ProjectBasedFileAccess(project),
				new HierarchyLocationStrategy(), FML_LANGUAGE);

		this.fCodeGenerator = new MainCodeGenerator();
	}

	/**
	 * Transformation reporting
	 */
	public SimpleLogger getReportLogger() {
		return this.fCodeGenerator.getReportLogger();
	}

	@Override
	protected void createPackageableElementFile(
			PackageableElement classifier, IProgressMonitor monitor) {

		if( (classifier instanceof org.eclipse.uml2.uml.Class) ||
			(classifier instanceof org.eclipse.uml2.uml.Model) ) {

			final IPath fileLocation = (new Path(FML_GEN_FOLDER))
					.append(this.locStrategy.getFileName(classifier))
					.addFileExtension("xlia");

			this.fileSystemAccess.generateFile(fileLocation.toString(),
					this.fCodeGenerator.performTransform(classifier));

//			PackageableElementCodeGenerator.generateCode(classifier).toString());
//
//			if( MainCodeGenerator.performTransform(classifier, fileLocation) ) {
//
//			}
		}
	}

	@Override
	protected boolean noCodeGen(Element element) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	protected void createElementFile(
			NamedElement namedElement, IProgressMonitor monitor)
	{
		final IPath fileLocation = (new Path(FML_GEN_FOLDER))
				.append(this.locStrategy.getFileName(namedElement))
				.addFileExtension("xlia");

		this.fileSystemAccess.generateFile(fileLocation.toString(),
				this.fCodeGenerator.performTransform(namedElement));
	}



}
