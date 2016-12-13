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
package org.eclipse.efm.runconfiguration.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.efm.runconfiguration.Activator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class GraphVizHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection selection = window.getSelectionService().getSelection();

		IFile gvFile = null;

		if( selection instanceof IStructuredSelection ) {
			Object selObj =((IStructuredSelection) selection).getFirstElement();
			if( selObj instanceof IFile ) {
				gvFile = (IFile) selObj;
			}
		}
		else {
			IEditorInput editorInput = HandlerUtil.getActiveEditorInput(event);
			if( editorInput instanceof IFileEditorInput ) {
				gvFile = ((IFileEditorInput) editorInput).getFile();

				if( ! Util.isGraphizFile(gvFile) )
				{
					gvFile = null;
				}
			}
		}

		if( gvFile != null ) {
			if( Activator.hasExternalDotGraphViewerPath() ) {
				try {
					String[] cmdLine = {
							Activator.strExternalDotGraphViewerPath(),
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
		}

		return null;
	}

}
