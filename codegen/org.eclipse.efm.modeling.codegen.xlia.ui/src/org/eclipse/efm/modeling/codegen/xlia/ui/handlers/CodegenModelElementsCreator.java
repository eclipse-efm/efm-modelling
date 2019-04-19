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
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;

public class CodegenModelElementsCreator extends ModelElementsCreator {

	public static final String FML_GEN_FOLDER = "fml-gen"; //$NON-NLS-1$

	public static final String FML_LANGUAGE = "formalML"; //$NON-NLS-1$


	public static final String FML_XLIA_FILE_EXTENSION  = "xlia"; //$NON-NLS-1$

	public static final String FML_SCXML_FILE_EXTENSION = "scxml"; //$NON-NLS-1$

	public static final String FML_GRAPHIC_FILE_EXTENSION = "puml"; //$NON-NLS-1$


	protected MainCodeGenerator  fXLIACodeGenerator;

//	protected SCXMLCodeGenerator fSCXMLCodeGenerator;


	public CodegenModelElementsCreator(final IProject project) {
		super(new ProjectBasedFileAccess(project),
				new HierarchyLocationStrategy(), FML_LANGUAGE);

		this.fXLIACodeGenerator  = new MainCodeGenerator();

//		this.fSCXMLCodeGenerator = new SCXMLCodeGenerator();
	}

	/**
	 * Transformation reporting
	 */
	public SimpleLogger getReportLogger() {
		return this.fXLIACodeGenerator.getReportLogger();
	}

	@Override
	protected void createPackageableElementFile(
			final PackageableElement classifier, final IProgressMonitor monitor) {

		if( (classifier instanceof org.eclipse.uml2.uml.Class) ||
			(classifier instanceof org.eclipse.uml2.uml.Model) ) {

			createElementFile(classifier, monitor);

//			PackageableElementCodeGenerator.generateCode(classifier).toString());
//
//			if( SCXMLCodeGenerator.performTransform(classifier, fileLocation) ) {
//
//			}
		}
	}

	@Override
	protected boolean noCodeGen(final Element element) {
		// TODO Auto-generated method stub
		return false;
	}


	protected void createElementFile(
			final NamedElement namedElement, final IProgressMonitor monitor)
	{
		// xLIA Code Generation
		final IPath xliaFileLocation = (new Path(FML_GEN_FOLDER))
				.append(this.locStrategy.getFileName(namedElement))
				.addFileExtension(FML_XLIA_FILE_EXTENSION);

		this.fileSystemAccess.generateFile(xliaFileLocation.toString(),
				this.fXLIACodeGenerator.performTransform(namedElement));

		// SCXML Code Generation ==> replace by XTEXT PlantUML generator
//		final IPath scxmlFileLocation = (new Path(FML_GEN_FOLDER))
//				.append(this.locStrategy.getFileName(namedElement))
//				.addFileExtension(FML_SCXML_FILE_EXTENSION);
//
//		this.fileSystemAccess.generateFile(scxmlFileLocation.toString(),
//				this.fSCXMLCodeGenerator.performTransform(namedElement));

//		// Graphic Code Generation
//		final IPath graphicFileLocation = (new Path(FML_GEN_FOLDER))
//				.append(this.locStrategy.getFileName(namedElement))
//				.addFileExtension(FML_GRAPHIC_FILE_EXTENSION);
//
//		this.fileSystemAccess.generateFile(graphicFileLocation.toString(),
//				this.fSCXMLCodeGenerator.performTransform(namedElement));
	}



}
