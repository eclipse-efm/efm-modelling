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

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.efm.execution.launchconfiguration.job.RunSewFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class RunSewToolsHandler extends AbstractHandler {

	/**
	 * Used last valid selection if current selection is invalid
	 */
	private IFile fLastSelectionFile = null;

	/**
	 * executeWorkflow
	 * @param event
	 * @return
	 */
	private Object executeWorkflow(ExecutionEvent event,
			IWorkbenchWindow window, IFile sewFile) {

		fLastSelectionFile = sewFile;

		if( ! RunSewFactory.run(window, sewFile) ) {
			//!!! ERROR
		}

		return null;
	}

	/**
	 * executeGraphiz
	 * @param window
	 * @param aFile
	 * @return
	 */
	private Object executeGraphiz(ExecutionEvent event,
			IWorkbenchWindow window, IFile gvFile) {

		fLastSelectionFile = gvFile;

		if( SymbexPreferenceUtil.hasExternalDotGraphViewerPath() ) {
			try {
				String[] cmdLine = {
						SymbexPreferenceUtil.strExternalDotGraphViewerPath(),
						gvFile.getLocation().toOSString()
					};

				File workingDir = ResourcesPlugin.getWorkspace().
						getRoot().getLocation().toFile();

				Process viewerProcess = Runtime.getRuntime().
						exec(cmdLine, null, workingDir);

				if( viewerProcess == null ) {
					System.out.println(event.toString());
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else {
			MessageDialog.openWarning(
					window.getShell(), "Preference Warning",
					"Set GraphViz viewer tools preference property");
		}

		return null;
	}


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection selection = window.getSelectionService().getSelection();

		if( selection instanceof IStructuredSelection ) {
			Object selObj =((IStructuredSelection) selection).getFirstElement();
			if( selObj instanceof IFile ) {
				IFile selectedFile = (IFile) selObj;

				if( Util.isWorkflowFile(selectedFile) )
				{
					return( executeWorkflow(event, window, selectedFile) );
				}
				else if( Util.isGraphizFile(selectedFile) ) {
					return( executeGraphiz(event, window, selectedFile) );
				}
			}
		}

		IEditorInput editorInput = HandlerUtil.getActiveEditorInput(event);
		if( editorInput instanceof IFileEditorInput ) {
			IFile selectedFile = ((IFileEditorInput) editorInput).getFile();

			if( Util.isWorkflowFile(selectedFile) )
			{
				return( executeWorkflow(event, window, selectedFile) );
			}
			else if( Util.isGraphizFile(selectedFile) ) {
				return( executeGraphiz(event, window, selectedFile) );
			}
		}


		if( (fLastSelectionFile != null) && fLastSelectionFile.exists() ) {
			if( Util.isWorkflowFile(fLastSelectionFile) )
			{
				return( executeWorkflow(event, window, fLastSelectionFile) );
			}
			else if( Util.isGraphizFile(fLastSelectionFile) ) {
				return( executeGraphiz(event, window, fLastSelectionFile) );
			}
		}

		return null;
	}

}
