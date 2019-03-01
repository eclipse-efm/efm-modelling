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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.RefreshUtil;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.launchconfiguration.Activator;
import org.eclipse.efm.execution.launchconfiguration.util.BackgroundResourceRefresher;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbenchWindow;

public class SymbexJobFactory {

	public static final String EMPTY_STRING = ""; //$NON-NLS-1$


	public static boolean run(final IWorkbenchWindow window, final String jobName, final IFile sewFile)
	{
		if( sewFile != null ) {
			try {
				final SymbexJob job = new SymbexJob(window, jobName, sewFile);

				job.setUser(true);
				job.schedule();

				return( true );
			}
			catch(final Exception e) {
				e.printStackTrace();
			}
		}

		return( false );
	}


	public static boolean run(final ILaunchConfiguration configuration,
			final String mode, final ILaunch launch, final IProgressMonitor monitor,
			final String[] commandLine, final IPath workingDirecory, final String[] envp)
	{
//		Launch externLaunch = new Launch(configuration, ILaunchManager.RUN_MODE, null);

		if( commandLine != null ) {
//			launch(configuration, mode, commandLine,
//					workingDirecory, envp, launch, monitor);

			try {
				final File workingFile = (workingDirecory != null) ?
						workingDirecory.toFile() : WorkflowFileUtils.WORKSPACE_PATH.toFile();

				final SymbexJob job = new SymbexJob(configuration,
						mode, launch, commandLine, workingFile, envp);

				job.setUser(true);
				job.schedule();

				return( true );
			}
			catch(final Exception e) {
				e.printStackTrace();
			}
		}

		return( false );
	}

	public static IStatus launch(final ILaunchConfiguration configuration, final String mode,
			final String[] commandLine, final IPath workingDirectory, final String[] envp,
			final ILaunch launch, final IProgressMonitor monitor) {

		if (monitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		}

		File workingDir = null;
		if (workingDirectory != null) {
			workingDir = workingDirectory.toFile();
		}

		if (monitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		}

		try {
			final Process javaProcess =
					DebugPlugin.exec(commandLine, workingDir, envp);

			IProcess eclipseProcess = null;

			// add process type to process attributes
			final Map<String, String> processAttributes = new HashMap<String, String>();

			final IPath location = new Path( commandLine[0] );

			String programName = location.lastSegment();
			final String extension = location.getFileExtension();
			if (extension != null) {
				programName = programName.substring(0, programName.length()
						- (extension.length() + 1));
			}
			programName = programName.toLowerCase();
			processAttributes.put(IProcess.ATTR_PROCESS_TYPE, programName);

			if (javaProcess != null) {
				monitor.beginTask(NLS.bind("Running {0}...",
						new String[] { configuration.getName() }),
						IProgressMonitor.UNKNOWN);

				eclipseProcess = DebugPlugin.newProcess(launch,
						javaProcess, location.toOSString(), processAttributes);
			}

			if (javaProcess == null || eclipseProcess == null) {
				if (javaProcess != null) {
					javaProcess.destroy();
				}

				System.err.println("An IProcess could not be created for the launch");

				return new Status(IStatus.ERROR,
						Activator.PLUGIN_ID,
						"An IProcess could not be created for the launch");
			}
			eclipseProcess.setAttribute(IProcess.ATTR_CMDLINE,
					generateCommandLine(commandLine));

			if (configuration.getAttribute(
					IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND, true)) {
				// refresh resources after process finishes
				final String scope = configuration.getAttribute(
						RefreshUtil.ATTR_REFRESH_SCOPE, (String)null);
				if (scope != null) {
					final BackgroundResourceRefresher refresher =
							new BackgroundResourceRefresher(
									configuration, eclipseProcess);
					refresher.startBackgroundRefresh();
				}
			} else {
				// wait for process to exit
				while (!eclipseProcess.isTerminated()) {
					try {
						if (monitor.isCanceled()) {
							eclipseProcess.terminate();
							break;
						}
						Thread.sleep(50);
					} catch (final InterruptedException e) {
					}
				}

				// refresh resources
				RefreshUtil.refreshResources(configuration, monitor);

				return Status.OK_STATUS;
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}

		return Status.CANCEL_STATUS;
	}

	private static String generateCommandLine(final String[] commandLine) {
		if (commandLine.length < 1) {
			return EMPTY_STRING;
		}
		final StringBuilder buf = new StringBuilder();
		for (int i = 0; i < commandLine.length; i++) {
			buf.append(' ');
			final char[] characters = commandLine[i].toCharArray();
			final StringBuilder command = new StringBuilder();
			boolean containsSpace = false;
			for (int j = 0; j < characters.length; j++) {
				final char character = characters[j];
				if (character == '\"') {
					command.append('\\');
				} else if (character == ' ') {
					containsSpace = true;
				}
				command.append(character);
			}
			if (containsSpace) {
				buf.append('\"');
				buf.append(command);
				buf.append('\"');
			} else {
				buf.append(command);
			}
		}
		return buf.toString();
	}



	public static boolean run(final IWorkbenchWindow window, final IFile sewFile) {
		return run(window, "Symbolic Execution Workflow job", sewFile);
	}
}
