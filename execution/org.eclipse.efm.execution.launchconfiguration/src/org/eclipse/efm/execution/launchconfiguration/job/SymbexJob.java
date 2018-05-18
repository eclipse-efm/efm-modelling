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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.launchconfiguration.job.console.SymbexSpiderConsole;
import org.eclipse.efm.execution.launchconfiguration.ui.views.SymbexConsoleView;
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
import org.eclipse.ui.internal.console.ConsoleView;

public class SymbexJob extends Job {
	///////////////////////////////////////////////////////////////////////////
	// SYMBEX LAUNCH OPTION
	///////////////////////////////////////////////////////////////////////////
	public static final String SYMBEX_LAUNCH_OPTION_ENABLE_SERVER_MODE =
			"--enable-server-mode";

	public static final String SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS =
			"--enable-print-spider-positions";

	///////////////////////////////////////////////////////////////////////////

	private IWorkbenchWindow fWindow;

	private String[] fCommandLine;

	private IResource fSymbexWorkflowFile;
	private IPath fSymbexWorkflowPath;

	private IConsoleView fConsoleView;


	static Map<IPath, SymbexSpiderConsole> fTableOfConsole =
			new HashMap<IPath, SymbexSpiderConsole>();

	protected SymbexSpiderConsole fSymbexSpiderConsole;

	protected MessageConsoleStream mcs;

	/**
	 * Some useful colors.
	 */
//	private static final Color RED =
//			Display.getCurrent().getSystemColor(SWT.COLOR_RED);

	public SymbexJob(IWorkbenchWindow window,
			String name, IFile symbexWorkflowFile)
	{
		super(name);

		this.fWindow = window;

		this.fSymbexWorkflowFile = symbexWorkflowFile;
		this.fSymbexWorkflowPath = symbexWorkflowFile.getLocation();

		this.fCommandLine = new String[] {
				SymbexPreferenceUtil.strDiversityAvmExecLocation(), //SEW_EXE
				symbexWorkflowFile.getLocation().toOSString(),
				SYMBEX_LAUNCH_OPTION_ENABLE_SERVER_MODE,
				SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS
		};

		showConsoleView(symbexWorkflowFile.getFullPath());
//		loadConsoleViewer(symbexWorkflowfile.getFullPath());

	}

	public SymbexJob(ILaunchConfiguration configuration, String mode,
			ILaunch launch, String[] commandLine, File workingDirectory, String[] envp)
	{
		super(configuration.getName());

		this.fWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if( fWindow != null ) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow[] wbWindow = workbench.getWorkbenchWindows();
			if( wbWindow.length > 0 ) {
				fWindow = wbWindow[0];
			}
		}

		this.fSymbexWorkflowFile = null;
		this.fSymbexWorkflowPath = null;

		this.fCommandLine = commandLine;

		if( (commandLine != null) && (commandLine.length > 1) )
		{
			this.fSymbexWorkflowPath = new Path(commandLine[1]);

			this.fSymbexWorkflowFile =
					WorkflowFileUtils.find(this.fSymbexWorkflowPath);

//			showConsoleView(this.fSymbexWorkflowPath);

			loadConsoleViewer(this.fSymbexWorkflowPath);
}
	}


	@Override
	public IStatus run(IProgressMonitor monitor) {
		if( fSymbexSpiderConsole != null ) {
			IStatus status = fSymbexSpiderConsole.startSymbex(
					fCommandLine, fSymbexWorkflowPath, monitor);

			if( monitor != null ) {
				monitor.done();
			}

			doRefresh();

			return status;
		}

		return Status.CANCEL_STATUS;
	}



	/*
	 * Refresh the Resource Navigator view
	 */
	private void doRefresh() {
		try {
			if( fSymbexWorkflowFile != null ) {
//    			if(fResource.getProject().getFolder("output") == null)
//    			{
//    				fResource.getProject().getFolder(
//							"output").create(true,true,null);
//    			}

				fSymbexWorkflowFile.getProject().refreshLocal(
    					IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
			else {
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(
						IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}

			//TODO : placer les fichiers de sortie fraichement
			// generes dans le folder "Outfiles"
		}
		catch(CoreException e) {
			e.printStackTrace();
		}
	}


	private void showConsoleView(IPath symbexResourcePath) {
		createConsole(symbexResourcePath, "Diversity Console");

		try {
			IConsoleView fConsoleView =
					(IConsoleView) fWindow.getActivePage().showView(
//							SymbolicExecutionView.SYMBEX_CONSOLE_VIEW_ID);
							IConsoleConstants.ID_CONSOLE_VIEW);

			fConsoleView.display(fSymbexSpiderConsole);
		}
		catch (PartInitException e) {
			e.printStackTrace();
		}

	}

	private void loadConsoleViewer(IPath symbexResourcePath) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow[] wbWindow = workbench.getWorkbenchWindows();
		if( wbWindow.length > 0 ) {
			fWindow = wbWindow[0];

			workbench.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						IViewPart viewPart = fWindow.getActivePage().
//								showView(SymbolicExecutionView.SYMBEX_CONSOLE_VIEW_ID);
								showView(IConsoleConstants.ID_CONSOLE_VIEW);

						if( viewPart instanceof SymbexConsoleView ) {
							fConsoleView = (SymbexConsoleView) viewPart;
						}
						else if( viewPart instanceof ConsoleView ) {
							fConsoleView = (ConsoleView) viewPart;
						}
					} catch (PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		if( fConsoleView != null ) {
			createConsole(symbexResourcePath, "Diversity Console");
		}
	}


	/*
	 * Create a console for this execution...
	 */
	private void createConsole(IPath symbexResourcePath, String prompt) {
	      ConsolePlugin plugin = ConsolePlugin.getDefault();
	      IConsoleManager consoleManager = plugin.getConsoleManager();

	      fSymbexSpiderConsole = fTableOfConsole.get(symbexResourcePath);
	      if( fSymbexSpiderConsole == null ) {
		      //no console found, so create a new one
		      StringBuffer bufName = new StringBuffer( prompt );
		      bufName.append("#").append(fTableOfConsole.size())
		      		.append(":> ").append(symbexResourcePath);

	    	  fSymbexSpiderConsole = new SymbexSpiderConsole(bufName.toString());
	    	  fTableOfConsole.put(symbexResourcePath, fSymbexSpiderConsole);

	    	  consoleManager.addConsoles(new IConsole[]{fSymbexSpiderConsole});
		      mcs = fSymbexSpiderConsole.newMessageStream();
	      }
	      else {
	  		mcs = fSymbexSpiderConsole.newMessageStream();
	  		mcs.println("=================================================================================");
	  		mcs.println("=================================================================================");
	  		mcs.println("=================================================================================");
	      }
	   }
}
