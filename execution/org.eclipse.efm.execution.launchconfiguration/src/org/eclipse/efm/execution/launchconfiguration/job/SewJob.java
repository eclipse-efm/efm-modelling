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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class SewJob extends Job {
	private IWorkbenchWindow fWindow;

	protected String fFileParameterLocation;
	protected IConsoleView fConsoleView;
	private ProcessBuilder avmProcessBuilder;
	private Process avmProcess;
	private IResource fResource;

	static Map<IResource, MessageConsole> fTableOfConsole =
			new HashMap<IResource, MessageConsole>();
	protected MessageConsole mc;
	protected MessageConsoleStream mcs;

	String SEW_EXE = SymbexPreferenceUtil.strDiversityAvmExecLocation();

	/**
	 * Some useful colors.
	 */
//	private static final Color RED =
//			Display.getCurrent().getSystemColor(SWT.COLOR_RED);

	public SewJob(IWorkbenchWindow window, String name,
			IFile sewFile, IResource resource) {
		super(name);

		this.fWindow = window;

		this.fFileParameterLocation = sewFile.getLocation().toOSString();
		this.fResource = resource;

		createConsole(sewFile, "Diversity Console");

		IConsoleView fConsoleView;
		try {
			fConsoleView = (IConsoleView) fWindow.getActivePage().
					showView(IConsoleConstants.ID_CONSOLE_VIEW);
			fConsoleView.display(mc);
		}
		catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	public SewJob(IWorkbenchWindow window, String name,
			String sewExecutable, IFile sewFile, IResource resource) {
		this(window, name, sewFile, resource);

		SEW_EXE = sewExecutable;
	}


	@Override
	public IStatus run(IProgressMonitor monitor) {
		monitor.beginTask("Diversity", IProgressMonitor.UNKNOWN);

		/*
		 * DIVERSITY Symbex Execution
		 */
		try {
			File execFile;
			if( (SEW_EXE == null) || SEW_EXE.isEmpty() )
			{
				MessageDialog.openWarning(fWindow.getShell(),
						"DIVERSITY Symbex (a.k.a AVM) executable",
						"Unfound exectable!" +
						"\nSee 'Symbolic Execution Workflow' Preference page.");

				return Status.CANCEL_STATUS;
			}
			else if( ! (execFile = new File(SEW_EXE)).canExecute() )
			{
				String errorMessage;
				if( ! execFile.exists() ) {
					errorMessage = "doesn't exist!";
				}
				else if( ! execFile.isFile() ) {
					errorMessage = "exists but is not a file!";
				}
				else {
					errorMessage = "is a file but not an executable!";
				}

				mcs.print( "error:> The DIVERSITY Symbex "
						+ "(a.k.a AVM) executable << " );
				mcs.print( SEW_EXE );
				mcs.print(" >> ");
				mcs.println( errorMessage );

				MessageDialog.openError(fWindow.getShell(),
						"DIVERSITY Symbex (a.k.a AVM) executable",
						"'" + SEW_EXE + "'" +
						"\nThese resource " + errorMessage +
						"\nSee 'Symbolic Execution Workflow' Preference page.");


				return Status.CANCEL_STATUS;
			}

			String[] cmdLine = { SEW_EXE , fFileParameterLocation , "--server" };
			File workingDir = ResourcesPlugin
					.getWorkspace().getRoot().getLocation().toFile();

// http://labs.excilys.com/2012/06/26/runtime-exec-pour-les-nuls-et-processbuilder/
// http://imss-www.upmf-grenoble.fr/prevert/Prog/Java/CoursJava/classeRuntimeProcess.html

			avmProcessBuilder = new ProcessBuilder(cmdLine);

			// on mélange les sorties du processus
			avmProcessBuilder = avmProcessBuilder.redirectErrorStream(true);

			avmProcessBuilder.directory(workingDir);

			avmProcess = avmProcessBuilder.start();

			if( avmProcess == null ) {
				return Status.CANCEL_STATUS;
			}

			InputStream inputStream = avmProcess.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

//			InputStream errorStream = avmProcess.getErrorStream();
//			InputStreamReader errorStreamReader = new InputStreamReader(errorStream);
//			BufferedReader errorBufferedReader = new BufferedReader(errorStreamReader);

			String traceLine = null;

//			Color mcsOldColor = mcs.getColor();

//			while( ((traceLine = bufferedReader.readLine()) != null) ) {
			while( true ) {
				if( bufferedReader.ready() ) {
					if( (traceLine = bufferedReader.readLine()) != null ) {
						if( traceLine.indexOf("@cerr:>") >= 0 ) {
							traceLine = traceLine.replace("@cerr:>", "");

//							synchronized( mcs ) {
//								mcsOldColor = mcs.getColor();
//								mcs.setColor(RED);

								mcs.println(traceLine);

//								mcs.setColor(mcsOldColor);
//							}
						}
						else /*synchronized( mcs )*/ {
							mcs.println(traceLine);
						}

						if( traceLine.contains(":>bye") ) {
							break;
						}

						traceLine = null;
					}
					else {
						break;
					}
				}

//				else if( errorBufferedReader.ready() ) {
//					if( (traceLine = errorBufferedReader.readLine()) != null ) {
//
////						synchronized( mcs ) {
////							mcsOldColor = mcs.getColor();
////							mcs.setColor(RED);
//
//							mcs.println(traceLine);
//
////							mcs.setColor(mcsOldColor);
////						}
//
//						if( traceLine.equals(":>bye") ) {
//							break;
//						}
//
//						traceLine = null;
//					}
//					else {
//						break;
//					}
//				}
//
				else {
					try {
						avmProcess.exitValue();
						break;
					}
					catch( IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ){
					avmProcess.destroy();

					mcs.println("\n***********************\n" +
							   	  "* EXECUTION ABORTED ! *\n" +
							   	  "***********************");

					return Status.CANCEL_STATUS;
				}
			}

//			try {
//				//avmProcess.destroy();
//
//				if(avmProcess.waitFor() != 0) {
//					StringBuffer strBuf = new StringBuffer("\nExit value : ");
//					strBuf.append(avmProcess.exitValue());
//					mcs.println(strBuf.toString());
//					mcs.flush();
//				}
//			}
//			catch(InterruptedException e) {
//				e.printStackTrace();
//			}

			return Status.OK_STATUS;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if( avmProcess != null ) {
				avmProcess.destroy();
			}

			monitor.done();

			doRefresh();
		}

		return Status.CANCEL_STATUS;
	}

	/*
	 * Refresh the Resource Navigator view
	 */
	private void doRefresh() {
		try {
			if( fResource != null ) {
    			if(fResource.getProject().getFolder("OutFiles") == null)
    			{
    				fResource.getProject().getFolder(
    						"OutFiles").create(true,true,null);
    			}

    			fResource.getProject().refreshLocal(
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

	/*
	 * Create a console for this execution...
	 */
	private void createConsole(IResource resource, String prompt) {
	      ConsolePlugin plugin = ConsolePlugin.getDefault();
	      IConsoleManager conMan = plugin.getConsoleManager();

	      mc = fTableOfConsole.get(resource);
	      if( mc == null ) {
		      StringBuffer bufName = new StringBuffer( prompt );
		      bufName.append("#").append(fTableOfConsole.size())
		      		.append(":> ").append(resource.getFullPath());

	    	  mc = new MessageConsole(bufName.toString(), null);
	    	  fTableOfConsole.put(resource, mc);

		      //no console found, so create a new one
		      conMan.addConsoles(new IConsole[]{mc});
				mcs = mc.newMessageStream();
	      }
	      else {
	  		mcs = mc.newMessageStream();
	  		mcs.println("=================================================================================");
	  		mcs.println("=================================================================================");
	  		mcs.println("=================================================================================");
	      }
	   }
}
