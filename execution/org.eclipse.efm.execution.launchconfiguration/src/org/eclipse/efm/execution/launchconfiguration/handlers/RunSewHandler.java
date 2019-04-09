/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.execution.launchconfiguration.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJobFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class RunSewHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		IFile sewFile = null;

		final IEditorInput editorInput = HandlerUtil.getActiveEditorInput(event);
		if( editorInput instanceof IFileEditorInput ) {
			sewFile = ((IFileEditorInput) editorInput).getFile();

			if( ! Util.isWorkflowFile(sewFile) )
			{
				sewFile = null;
			}
		}

		ISelection selection = window.getSelectionService().getSelection();
		if( ! (selection instanceof IStructuredSelection) ) {
			selection = window.getSelectionService().getSelection(
					IPageLayout.ID_PROJECT_EXPLORER);
		}

		if( (sewFile == null ) && (selection instanceof IStructuredSelection) ) {
			final Object selObj =((IStructuredSelection) selection).getFirstElement();
			if( selObj instanceof IFile ) {
				sewFile = (IFile) selObj;

				if( ! Util.isWorkflowFile(sewFile) )
				{
					sewFile = null;
				}
			}
		}

		if( sewFile != null ) {

			if( ! SymbexJobFactory.run(window, sewFile) ) {
				//!!! ERROR
			}
		}

		return null;
	}

}
