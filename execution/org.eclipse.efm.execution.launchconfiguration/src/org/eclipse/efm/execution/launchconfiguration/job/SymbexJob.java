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
package org.eclipse.efm.execution.launchconfiguration.job;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.efm.execution.launchconfiguration.job.console.SymbexSpiderConsole;
import org.eclipse.efm.execution.launchconfiguration.job.console.SymbexSpiderConsolePage;
import org.eclipse.efm.execution.launchconfiguration.job.sew.ISymbexWorkflowProvider;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsoleStream;

public class SymbexJob extends Job {


	private static final String SYMBEX_PROMPT = "Diversity";


	///////////////////////////////////////////////////////////////////////////

	private final ISymbexWorkflowProvider fSymbexWorkflowProvider;

	protected SymbexSpiderConsole fSymbexSpiderConsole;

	public static Map<IPath, SymbexSpiderConsole> fTableOfConsole =
			new HashMap<IPath, SymbexSpiderConsole>();


	public SymbexJob(final ISymbexWorkflowProvider sewProvider)
	{
		super(sewProvider.getJobName());

		fSymbexWorkflowProvider = sewProvider;

		this.fSymbexSpiderConsole = null;
	}


	@Override
	public IStatus run(final IProgressMonitor monitor) {
		if( this.fSymbexWorkflowProvider != null ) {
			loadConsoleViewer(this.fSymbexWorkflowProvider.getSymbexWorkflowPath());

			if( fSymbexSpiderConsole != null ) {
				final IStatus status = fSymbexSpiderConsole.startSymbex(
						fSymbexWorkflowProvider, monitor);

				doRefresh();

				if( monitor != null ) {
					monitor.done();
				}

				return status;
			}
		}

		return Status.CANCEL_STATUS;
	}



	/*
	 * Refresh the Resource Navigator view
	 */
	protected void doRefresh() {
		try {
			final IResource refreshResource =
					fSymbexWorkflowProvider.getRefreshResource();
			if( refreshResource != null ) {
//    			if(fResource.getProject().getFolder("output") == null)
//    			{
//    				fResource.getProject().getFolder(
//							"output").create(true,true,null);
//    			}

				refreshResource.getProject().refreshLocal(
    					IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
			else {
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(
						IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
		}
		catch(final CoreException e) {
			e.printStackTrace();
		}
	}

	private void loadConsoleViewer(final IPath symbexResourcePath) {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final IWorkbenchWindow[] wbWindow = workbench.getWorkbenchWindows();
		if( wbWindow.length > 0 ) {
			final IWorkbenchWindow window = wbWindow[0];

			workbench.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						final IViewPart viewPart = window.getActivePage().
//								showView(SymbolicExecutionView.SYMBEX_CONSOLE_VIEW_ID);
								showView(IConsoleConstants.ID_CONSOLE_VIEW);

						if( viewPart instanceof IConsoleView ) {
							createConsole((IConsoleView) viewPart,
									symbexResourcePath, SYMBEX_PROMPT);
						}
					} catch (final PartInitException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}


	/*
	 * Create a console for this execution...
	 */
	private void createConsole(final IConsoleView consoleView,
			final IPath symbexResourcePath, final String prompt) {
		fSymbexSpiderConsole = fTableOfConsole.get(symbexResourcePath);
		if( fSymbexSpiderConsole == null ) {
			//no console found, so create a new one
			fSymbexSpiderConsole =
					new SymbexSpiderConsole(prompt, symbexResourcePath);

			fTableOfConsole.put(symbexResourcePath, fSymbexSpiderConsole);

			final IConsoleManager consoleManager =
					ConsolePlugin.getDefault().getConsoleManager();

			consoleManager.addConsoles(new IConsole[]{ fSymbexSpiderConsole });
		}
		else {
			consoleView.display(fSymbexSpiderConsole);

			final MessageConsoleStream mcs = fSymbexSpiderConsole.newMessageStream();
			mcs.println("=================================================================================");
			mcs.println("=================================================================================");
			mcs.println("=================================================================================");
		}
	}

	public static void removeConsole(final SymbexSpiderConsole spiderConsole) {
		final IPath path = spiderConsole.getfResourcePath();

		if( path != null ) {
			fTableOfConsole.remove(path, spiderConsole);
		}

		final IConsoleManager consoleManager =
				ConsolePlugin.getDefault().getConsoleManager();

		consoleManager.removeConsoles(new IConsole[]{ spiderConsole });
	}


	////////////////////////////////////////////////////////////////////////////
	// Close All Terminated Console
	////////////////////////////////////////////////////////////////////////////
	public static boolean hasTerminatedConsole() {
		final IConsoleManager consoleManager =
				ConsolePlugin.getDefault().getConsoleManager();

		final IConsole[] consoles = consoleManager.getConsoles();
		for (final IConsole console : consoles) {
			if( console instanceof SymbexSpiderConsole ) {
				final SymbexSpiderConsolePage spiderConsolePage =
						((SymbexSpiderConsole) console).getDefaultPage();

				if( (spiderConsolePage != null)
					&& (! spiderConsolePage.isProcessRunning()) )
				{
					return true;
				}
			}
		}

		return false;
	}


	public static void removeAllConsole() {
		final IConsoleManager consoleManager =
				ConsolePlugin.getDefault().getConsoleManager();

		final IConsole[] consoles = consoleManager.getConsoles();
		for (final IConsole console : consoles) {
			if( console instanceof SymbexSpiderConsole ) {
				final SymbexSpiderConsole spiderConsole =
						(SymbexSpiderConsole) console;

				if( ! spiderConsole.getDefaultPage().isProcessRunning() )
				{
					final IPath path = spiderConsole.getfResourcePath();

					if( path != null ) {
						fTableOfConsole.remove(path, spiderConsole);
					}

					consoleManager.removeConsoles(new IConsole[]{ spiderConsole });
				}
			}
		}
	}



	////////////////////////////////////////////////////////////////////////////
	//Terminate All Running Console
	////////////////////////////////////////////////////////////////////////////
	public static boolean hasRunningConsole() {
		final IConsoleManager consoleManager =
				ConsolePlugin.getDefault().getConsoleManager();

		final IConsole[] consoles = consoleManager.getConsoles();
		for (final IConsole console : consoles) {
			if( console instanceof SymbexSpiderConsole ) {
				final SymbexSpiderConsolePage spiderConsolePage =
						((SymbexSpiderConsole) console).getDefaultPage();

				if( (spiderConsolePage != null)
					&& spiderConsolePage.isProcessRunning() )
				{
					return true;
				}
			}
		}

		return false;
	}

	public static void TerminateAllConsole() {
		final IConsoleManager consoleManager =
				ConsolePlugin.getDefault().getConsoleManager();

		final IConsole[] consoles = consoleManager.getConsoles();
		for (final IConsole console : consoles) {
			if( console instanceof SymbexSpiderConsole ) {
				final SymbexSpiderConsolePage spiderConsolePage =
						((SymbexSpiderConsole) console).getDefaultPage();

				if( (spiderConsolePage != null)
					&& spiderConsolePage.isProcessRunning() )
				{
					spiderConsolePage.terminateProcess();
				}
			}
		}
	}


}
