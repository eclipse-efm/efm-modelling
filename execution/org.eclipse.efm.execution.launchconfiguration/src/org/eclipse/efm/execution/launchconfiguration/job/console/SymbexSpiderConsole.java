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

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.ui.console.IConsoleColorProvider;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.launchconfiguration.Activator;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.part.IPageBookViewPage;

public class SymbexSpiderConsole extends MessageConsole { // ProcessConsole
	/**
	 * Console type identifier (value <code>"org.eclipse.efm.execution.launchconfiguration.SymbexProcessConsoleType"</code>).
	 */
	public static final String ID_PROCESS_CONSOLE_TYPE =
			Activator.PLUGIN_ID + ".SymbexProcessConsoleType"; //$NON-NLS-1$


	private IProcess fProcess = null;

	private final static ImageDescriptor IDESC_CONSOLE =
			ImageResources.getImageDescriptor(ImageResources.IMAGE__DIVERSITY_ICON);

	private final static String[] DEFAULT_ENVIRONMENT_VARS = new String[0];


	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;


	public SymbexSpiderConsole(String name) {
		super(name, IDESC_CONSOLE);

		this.fProcess = null;

		setType(ID_PROCESS_CONSOLE_TYPE);
	}

	public SymbexSpiderConsole(IProcess process,
			IConsoleColorProvider colorProvider, String encoding) {
		super(process.getLaunch().getLaunchConfiguration().getName(), IDESC_CONSOLE);
//		super(process, colorProvider, null);

		this.fProcess = process;

		setType(ID_PROCESS_CONSOLE_TYPE);
	}


	public IProcess getProcess() {
		return fProcess;
	}

	@Override
	public IPageBookViewPage createPage(IConsoleView view) {
		if(  fSymbexSpiderConsolePage == null ) {
			fSymbexSpiderConsolePage = new SymbexSpiderConsolePage(this, view);
		}
		return fSymbexSpiderConsolePage;
	}


	public IStatus startSymbex(String[] commandLine,
			IPath symbexWorkflowPath, IProgressMonitor monitor) {
		if( fSymbexSpiderConsolePage == null ) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				//!! NOTHING
			}
		}

		if( fSymbexSpiderConsolePage != null ) {
			monitor.beginTask("Diversity", IProgressMonitor.UNKNOWN);

			File workingDirectory = WorkflowFileUtils.WORKSPACE_PATH.toFile();

			fSymbexSpiderConsolePage.sewLaunchExecProcess("user", monitor,
					commandLine, workingDirectory, DEFAULT_ENVIRONMENT_VARS);

			return Status.OK_STATUS;
		}

		System.out.print("No SymbexSpiderConsolePage for evaluation of ");
		System.out.println(symbexWorkflowPath.toString());

		return Status.CANCEL_STATUS;
	}



}
