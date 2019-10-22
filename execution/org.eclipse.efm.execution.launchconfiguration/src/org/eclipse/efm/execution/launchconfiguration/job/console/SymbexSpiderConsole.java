/**
 * Copyright (c) 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.execution.launchconfiguration.job.console;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.ui.console.IConsoleColorProvider;
import org.eclipse.efm.execution.launchconfiguration.Activator;
import org.eclipse.efm.execution.launchconfiguration.job.sew.ISymbexWorkflowProvider;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.part.IPageBookViewPage;

public class SymbexSpiderConsole extends MessageConsole { // ProcessConsole
	/**
	 * Console type identifier (value <code>"org.eclipse.efm.execution.launchconfiguration.SymbexProcessConsoleType"</code>).
	 */
	public static final String ID_PROCESS_CONSOLE_TYPE =
			Activator.PLUGIN_ID + ".SymbexProcessConsoleType"; //$NON-NLS-1$

	private final IPath fResourcePath;

	private IProcess fProcess = null;

	private final static ImageDescriptor IDESC_CONSOLE =
			ImageResources.getImageDescriptor(ImageResources.IMAGE__DIVERSITY_ICON);


	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;

	private static int fConsoleOffset = 0;

	private static String title(final String prompt, final IPath resourcePath) {
		final StringBuilder bufTitle = new StringBuilder( prompt );

		bufTitle.append("#").append( fConsoleOffset++ )
			.append(":> ").append(resourcePath);

		return bufTitle.toString();
	}


	public SymbexSpiderConsole(final String prompt, final IPath resourcePath) {
		super(title(prompt, resourcePath), IDESC_CONSOLE);

		this.fResourcePath = resourcePath;

		this.fProcess = null;

		setType(ID_PROCESS_CONSOLE_TYPE);
	}

	public SymbexSpiderConsole(final IProcess process,
			final IConsoleColorProvider colorProvider, final String encoding) {
		super(process.getLaunch().getLaunchConfiguration().getName(), IDESC_CONSOLE);
//		super(process, colorProvider, null);

		this.fResourcePath = null;

		this.fProcess = process;

		setType(ID_PROCESS_CONSOLE_TYPE);
	}

	// GETTERS

	public IPath getfResourcePath() {
		return fResourcePath;
	}

	public IProcess getProcess() {
		return fProcess;
	}

	public SymbexSpiderConsolePage getDefaultPage() {
		return fSymbexSpiderConsolePage;
	}



	@Override
	public IPageBookViewPage createPage(final IConsoleView view) {
		if(  fSymbexSpiderConsolePage == null ) {
			fSymbexSpiderConsolePage = new SymbexSpiderConsolePage(this, view);
		}
		return fSymbexSpiderConsolePage;
	}


	public IStatus startSymbex(final ISymbexWorkflowProvider sewProvider,
			final IProgressMonitor monitor) {
		int waitingTime = 16;
		while( (fSymbexSpiderConsolePage == null) && (waitingTime <= 1024) ) {
			try {
				Thread.sleep( waitingTime *= 2 );
			} catch (final InterruptedException e) {
				//!! NOTHING
			}
		}

		if( fSymbexSpiderConsolePage != null ) {
			monitor.beginTask("Diversity", IProgressMonitor.UNKNOWN);

			fSymbexSpiderConsolePage.sewLaunchExecProcess(sewProvider, monitor);

			return Status.OK_STATUS;
		}

		MessageDialog.openInformation(getDefaultShell(), "SYMBEX ANALYSIS",
				"No SymbexSpiderConsolePage for evaluation of "
				+ sewProvider.getSymbexWorkflowPath().toString() + " !"
				+ "\nRetry again, please...");

		return Status.CANCEL_STATUS;
	}

	public static Shell getDefaultShell() {
		return PlatformUI.getWorkbench().getDisplay().getActiveShell();
	}

}
