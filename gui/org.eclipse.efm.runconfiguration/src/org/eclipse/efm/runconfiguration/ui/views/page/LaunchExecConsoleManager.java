/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.runconfiguration.ui.views.page;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.runconfiguration.ui.views.SymbolicExecutionView;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class LaunchExecConsoleManager {

	private IWorkbenchWindow fWindow;

	private SymbolicExecutionView fSymbexView;


	public LaunchExecConsoleManager() {
		super();

		this.fWindow = null;

		fSymbexView = null;
	}

	private boolean loadConsoleViewer() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow[] wws = wb.getWorkbenchWindows();
		if( wws.length > 0 ) {
			fWindow = wws[0];

			wb.getDisplay().syncExec(new Runnable() {
				public void run() {
					try {
						IViewPart viewPart = fWindow.getActivePage().
								showView(SEWConsoleViewer.ID_SEW_CONSOLE_VIEW);
//								showView(IConsoleConstants.ID_CONSOLE_VIEW);

						if( viewPart instanceof SymbolicExecutionView ) {
							fSymbexView = (SymbolicExecutionView) viewPart;
						}
					} catch (PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		return( fSymbexView != null );
	}


	public void sewLaunchExecProcess(ILaunchConfiguration configuration,
			String mode, ILaunch launch, IProgressMonitor monitor,
			String[] cmdLine, File workingDir, String[] envp) {

		if( loadConsoleViewer() ) {
			fSymbexView.sewLaunchExecProcess(configuration, mode,
					launch, monitor, cmdLine, workingDir, envp);
		}
		else {
			System.out.println("loadConsoleViewer: KOOO !");
		}
	}


}
