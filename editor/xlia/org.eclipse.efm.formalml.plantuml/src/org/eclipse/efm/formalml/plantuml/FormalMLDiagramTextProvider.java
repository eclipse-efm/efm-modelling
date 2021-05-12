/*****************************************************************************
* Copyright (c) 2021 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
*  - Initial API and implementation
*****************************************************************************/
package org.eclipse.efm.formalml.plantuml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import net.sourceforge.plantuml.eclipse.utils.DiagramTextProvider;
import net.sourceforge.plantuml.eclipse.utils.PlantumlConstants;


public class FormalMLDiagramTextProvider implements DiagramTextProvider {

	public final static String DEFAULT_PUML_TEXT =
			PlantumlConstants.START_UML + "\n"
			+ "\nIEditorPart -> ITextSelection: getEditorTextSelection Request"
			+ "\nITextSelection --> IEditorPart: getEditorTextSelection Response"

			+ "\nIEditorPart -> ITextSelection: getEcoreObjectSelection Request"
			+ "\nIEditorPart <-- ITextSelection: getEcoreObjectSelection Response\n"

			+ "\nIEditorPart -> ITextSelection: getDiagramText Request"
			+ "\nIEditorPart <-- ITextSelection: getDiagramText Response"
			+ "\n\n" + PlantumlConstants.END_UML;

	public final static String DEFAULT_PUML_TEXT_VIEW_PART =
			PlantumlConstants.START_UML + "\n"
			+ "\nIViewPart -> TreeSelection: getFilePath Request"
			+ "\nTreeSelection --> IViewPart: getFilePath Response"
			+ "\n\n" + PlantumlConstants.END_UML;


    private final FML2PlantUMLText fml2PlantUMLText = new FML2PlantUMLText();

    private final EObjectAtOffsetHelper eObjectAtOffsetHelper = new EObjectAtOffsetHelper();

	public FormalMLDiagramTextProvider() {
	}


	protected String textFileContent(final String gvFilePath) {
		String fileContent = "";
		try {
			fileContent = Files.readString(Path.of(gvFilePath));
		} catch (final IOException e) {
			fileContent = e.getMessage();
		}

		return fileContent;
	}

	protected String dotFileDiagramText(final String gvFilePath) {
		final StringBuffer gvBuffer = new StringBuffer(PlantumlConstants.START_UML);
		gvBuffer.append('\n')
				.append(textFileContent(gvFilePath))
				.append('\n')
				.append(PlantumlConstants.END_UML);

		return gvBuffer.toString();
	}


    public String fmlEcoreDiagramText(final IEditorPart editorPart, final ISelection selection) {
        final XtextEditor xe = (XtextEditor) editorPart;
        final XtextResource res = xe.getDocument().readOnly(new IUnitOfWork<XtextResource, XtextResource>() {
            @Override
            public XtextResource exec(final XtextResource st) {
                return st;
            }
        });

        if (selection instanceof ITextSelection) {
            final ITextSelection its = (ITextSelection) selection;
            final int offset = its.getOffset();
            final EObject eObj = eObjectAtOffsetHelper.resolveElementAt(res, offset);
            final List<? extends EObject> eObjs = fml2PlantUMLText.setupVisualizationEObjects(eObj);
            if (eObjs != null) {
                return fml2PlantUMLText.FML2PUML(eObjs);
            }
        }

        return fml2PlantUMLText.FML2PUML(res.getContents());
    }


	@Override
	public boolean supportsSelection(final ISelection selection) {
		return selection instanceof ITextSelection;
	}

	@Override
	public String getDiagramText(final IEditorPart editorPart, final ISelection selection) {
//		return DEFAULT_PUML_TEXT;
		final IEditorInput editorInput = editorPart.getEditorInput();
		if( editorInput instanceof FileEditorInput )
		{
			final IFile file = ((FileEditorInput) editorInput).getFile();
			if( "xlia".equals(file.getFileExtension())
				|| "fml".equals(file.getFileExtension()) ) {
				if( (editorPart instanceof XtextEditor) && (selection instanceof ITextSelection)) {
					return fmlEcoreDiagramText(editorPart, selection);
				}
			}
			else if( "gv".equals(file.getFileExtension()) ) {
				return dotFileDiagramText(file.getLocation().toOSString());
			}
//			else if( "puml".equals(file.getFileExtension()) ) {
//				return textFileContent(file.getLocation().toOSString());
//			}
		}
		return DiagramTextProvider.super.getDiagramText(editorPart, selection);
	}

	@Override
	public String getDiagramText(final IViewPart viewPart, final ISelection selection) {
//		return DEFAULT_PUML_TEXT_VIEW_PART;

		if( selection instanceof TreeSelection ) {
			final TreeSelection treeSelection = (TreeSelection) selection;
			if( ! treeSelection.isEmpty() ) {
				final Object element = treeSelection.getFirstElement();
				if( element instanceof IFile ) {
					final IResource resource = (IFile) element;
					if( "gv".equals(resource.getFileExtension()) ) {
						return dotFileDiagramText(resource.getLocation().toOSString());
					}
					else if( "puml".equals(resource.getFileExtension()) ) {
						return textFileContent(resource.getLocation().toOSString());
					}
				}
			}
		}
		return DiagramTextProvider.super.getDiagramText(viewPart, selection);
	}

	@Override
	public boolean supportsEditor(final IEditorPart editorPart) {
		final IEditorInput editorInput = editorPart.getEditorInput();
		if( editorInput instanceof FileEditorInput )
		{
			final IFile file = ((FileEditorInput) editorInput).getFile();
			return( "xlia".equals(file.getFileExtension())
				|| "fml".equals(file.getFileExtension())
				|| "gv".equals(file.getFileExtension()) );
		}

		return DiagramTextProvider.super.supportsEditor(editorPart);
	}

	@Override
	public boolean supportsView(final IViewPart viewPart) {
		if( viewPart instanceof ProjectExplorer ) {
			return true;
		}

		return DiagramTextProvider.super.supportsView(viewPart);
	}

//	@Override
//	public boolean supportsPath(final IPath path) {
//        return "xlia".equals(path.getFileExtension())
//        		|| "fml".equals(path.getFileExtension())
//        		|| "gv".equals(path.getFileExtension());
//	}
//
//	@Override
//	public String getDiagramText(final IEditorPart editorPart, final ISelection selection, final Map<String, Object> markerAttributes) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getDiagramText(final IPath path) {
//		if( "gv".equals(path.getFileExtension()) ) {
//			return dotFileDiagramText(path.toOSString());
//		}
//		else if( "puml".equals(path.getFileExtension()) ) {
//			return textFileContent(path.toOSString());
//		}
//		return null;
//	}


}