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
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJobFactory;
import org.eclipse.efm.execution.launchconfiguration.job.sew.LivenessCheckerSymbexWorkflow;
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
	private Object executeWorkflow(final ExecutionEvent event,
			final IWorkbenchWindow window, final IFile sewFile) {

		fLastSelectionFile = sewFile;

		if( ! SymbexJobFactory.run(window, sewFile) ) {
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
	private Object executeGraphiz(final ExecutionEvent event,
			final IWorkbenchWindow window, final IFile gvFile) {

		fLastSelectionFile = gvFile;

		if( SymbexPreferenceUtil.hasExternalDotGraphViewerPath() ) {
			try {
				final String[] commandLine = {
						SymbexPreferenceUtil.strExternalDotGraphViewerPath(),
						gvFile.getLocation().toPortableString()
					};

//				final File workingDir = ResourcesPlugin.getWorkspace().
//						getRoot().getLocation().toFile();

for( final String cmd : commandLine ) {
	System.out.println("ZGRV: " + cmd);
}

				final Process viewerProcess = Runtime.getRuntime().
						exec(commandLine);

				if( viewerProcess == null ) {
					for( final String cmd : commandLine ) {
						System.out.println("CMD: " + cmd);
					}
					System.out.println("viewerProcess == null");

					System.out.println(event.toString());
				}
			}
			catch(final Exception e)
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
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final ISelection selection = window.getSelectionService().getSelection();

		if( selection instanceof IStructuredSelection ) {
			final Object selObj =((IStructuredSelection) selection).getFirstElement();
			if( selObj instanceof IFile ) {
				final IFile selectedFile = (IFile) selObj;

				if( Util.isWorkflowFile(selectedFile) )
				{
					return( executeWorkflow(event, window, selectedFile) );
				}
				else if( Util.isGraphizFile(selectedFile) ) {
					return( executeGraphiz(event, window, selectedFile) );
				}
			}
			else if( selObj instanceof IContainer ) {
				return LivenessCheckerSymbexWorkflow.execute((IContainer) selObj);
			}
		}

		final IEditorInput editorInput = HandlerUtil.getActiveEditorInput(event);
		if( editorInput instanceof IFileEditorInput ) {
			final IFile selectedFile = ((IFileEditorInput) editorInput).getFile();

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
