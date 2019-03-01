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
package org.eclipse.efm.execution.launchconfiguration.ui.views.page;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.launchconfiguration.ui.views.SymbolicExecutionView;
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
		final IWorkbench wb = PlatformUI.getWorkbench();
		final IWorkbenchWindow[] wws = wb.getWorkbenchWindows();
		if( wws.length > 0 ) {
			fWindow = wws[0];

			wb.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						final IViewPart viewPart = fWindow.getActivePage().
								showView(SymbolicExecutionView.SYMBEX_CONSOLE_VIEW_ID);
//								showView(IConsoleConstants.ID_CONSOLE_VIEW);

						if( viewPart instanceof SymbolicExecutionView ) {
							fSymbexView = (SymbolicExecutionView) viewPart;
						}
					} catch (final PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		return( fSymbexView != null );
	}


	public void sewLaunchExecProcess(final ILaunchConfiguration configuration,
			final String mode, final ILaunch launch, final IProgressMonitor monitor,
			final String[] commandLine, final File workingDirectory, final String[] envp) {

		if( loadConsoleViewer() ) {
			fSymbexView.sewLaunchExecProcess(configuration, mode,
					launch, monitor, commandLine, workingDirectory, envp);
		}
		else {
			System.out.println("loadConsoleViewer: KOOO !");
		}
	}


}
