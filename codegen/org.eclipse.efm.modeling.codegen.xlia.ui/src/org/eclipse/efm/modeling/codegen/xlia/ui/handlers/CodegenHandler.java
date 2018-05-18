/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.efm.modeling.codegen.xlia.util.SimpleLogger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.uml.diagram.common.handlers.CmdHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;

public class CodegenHandler extends CmdHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IProject project = getCurrentproject();
		if( project != null ) {
			CodegenModelElementsCreator modelElementsCreator =
					new CodegenModelElementsCreator(project);

			if( this.selectedEObject instanceof PackageableElement ) {
				generate(modelElementsCreator,
						(PackageableElement) (this.selectedEObject));
			}
			else if( this.selectedEObject instanceof NamedElement ) {
				generate(modelElementsCreator,
						(NamedElement) (this.selectedEObject));
			}

			IWorkbenchWindow window =
					HandlerUtil.getActiveWorkbenchWindowChecked(event);

			report(window.getShell(), modelElementsCreator.getReportLogger());
		}
		else {
			System.out.println("xLIA code generation handler done !");
		}
		return null;
	}


	public void report(Shell shell, SimpleLogger fml2xliaLogger) {
		//opening the dialog
		MessageDialog.open(fml2xliaLogger.getMessageDialogKind(),
				shell, "Formal Modeling Language to Concrete Syntax (xLIA)",
				fml2xliaLogger.getReport(), SWT.NONE);
	}



	private IProject getCurrentproject() {
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final URI uri = this.selectedEObject.eResource().getURI();
		final IProject project = root.getProject(uri.segment(1));

//		ISelectionService selectionService = PlatformUI.getWorkbench().
//				getActiveWorkbenchWindow().getSelectionService();
//
//		ISelection selection = selectionService.getSelection();
//
//		IProject project = null;
//		if( selection instanceof IStructuredSelection ) {
//			Object element = ((IStructuredSelection) selection).getFirstElement();
//
//			if( element instanceof IResource ) {
//				project = ((IResource)element ).getProject();
//			}
//		}

		return project;
	}


	private void generate(CodegenModelElementsCreator modelElementsCreator,
			NamedElement namedElement) {
		System.out.print("xLIA no-code generation for --> ");
		System.out.print(namedElement.getClass().getName());
		System.out.print(" : ");
		System.out.println(namedElement.getQualifiedName());
	
		if( namedElement instanceof Lifeline ) {
			if( modelElementsCreator instanceof CodegenModelElementsCreator )
			{
				((CodegenModelElementsCreator)modelElementsCreator).createElementFile(namedElement, null);
			}
		}
	
	}

	private void generate(CodegenModelElementsCreator modelElementsCreator,
			PackageableElement packageableElement) {
		modelElementsCreator.createPackageableElement(packageableElement, null, true);
	}


	@Override
	public boolean isEnabled() {
		updateSelectedEObject();

		return( this.selectedEObject instanceof /*Packageable*/NamedElement );
	}


}
