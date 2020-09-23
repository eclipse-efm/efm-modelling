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
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class GraphVizHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final ISelection selection = window.getSelectionService().getSelection();

		IFile gvFile = null;

		if( selection instanceof IStructuredSelection ) {
			final Object selObj =((IStructuredSelection) selection).getFirstElement();
			if( selObj instanceof IFile ) {
				gvFile = (IFile) selObj;
			}
		}
		else {
			final IEditorInput editorInput = HandlerUtil.getActiveEditorInput(event);
			if( editorInput instanceof IFileEditorInput ) {
				gvFile = ((IFileEditorInput) editorInput).getFile();

				if( ! Util.isGraphizFile(gvFile) )
				{
					gvFile = null;
				}
			}
		}

		if( gvFile != null ) {
			if( SymbexPreferenceUtil.hasExternalDotGraphViewerPath() ) {
				try {
					final String[] commandLine = {
							SymbexPreferenceUtil.strExternalDotGraphViewerPath(),
							gvFile.getLocation().toPortableString()
						};

//					File workingDir = ResourcesPlugin.getWorkspace().
//							getRoot().getLocation().toFile();

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
		}

		return null;
	}

}
