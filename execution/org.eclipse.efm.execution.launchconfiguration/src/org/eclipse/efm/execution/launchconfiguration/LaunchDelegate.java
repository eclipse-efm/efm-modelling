/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.execution.launchconfiguration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.RefreshUtil;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.efm.execution.core.AbstractLaunchDelegate;
import org.eclipse.efm.execution.core.Activator;
import org.eclipse.efm.execution.core.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.efm.execution.core.workflow.DirectorCustomImpl;
import org.eclipse.efm.execution.core.workflow.WorkflowCustomImpl;
import org.eclipse.efm.execution.launchconfiguration.ui.views.page.LaunchExecConsoleManager;
import org.eclipse.efm.execution.launchconfiguration.util.BackgroundResourceRefresher;
import org.eclipse.efm.execution.launchconfiguration.util.CoreUtil;
import org.eclipse.osgi.util.NLS;

public class LaunchDelegate extends AbstractLaunchDelegate {


//	private final String PROJECT_FAVM = "project.favm";

	private final String BASENAME_SEP = "-";

	private final String WORKFLOW_BASENAME = "workflow";

	private final String WORKFLOW_EXTENSION = ".sew";


	private IPath fAvmExecLocation;

	private IPath fSewLocation;
	private IPath fWorkingDirectory;

	public static String fModelAnalysisProfile = ANALYSIS_PROFILE_MODEL_UNDEFINED;

	public static boolean fEnableTraceExtension = false;

	

	/**
	 * LaunchExecConsoleManager
	 */
	LaunchExecConsoleManager fConsoleManager;

	boolean fEnabledDebugOrDeveloperMode;

	public LaunchDelegate() {
		fSewLocation = null;
		fWorkingDirectory = null;

		fConsoleManager = new LaunchExecConsoleManager();

		fEnabledDebugOrDeveloperMode = false;
	}
	
	
	public static boolean isValidFilename(String text)
	{
		final Pattern pattern = Pattern.compile(
				"# Match a valid Windows filename (unspecified file system).          \n" +
				"^                                # Anchor to start of string.        \n" +
				"(?!                              # Assert filename is not: CON, PRN, \n" +
				"  (?:                            # AUX, NUL, COM1, COM2, COM3, COM4, \n" +
				"    CON|PRN|AUX|NUL|             # COM5, COM6, COM7, COM8, COM9,     \n" +
				"    COM[1-9]|LPT[1-9]            # LPT1, LPT2, LPT3, LPT4, LPT5,     \n" +
				"  )                              # LPT6, LPT7, LPT8, and LPT9...     \n" +
				"  (?:\\.[^.]*)?                  # followed by optional extension    \n" +
				"  $                              # and end of string                 \n" +
				")                                # End negative lookahead assertion. \n" +
				"[^<>:\"/\\\\|?*\\x00-\\x1F]*     # Zero or more valid filename chars.\n" +
				"[^<>:\"/\\\\|?*\\x00-\\x1F\\ .]  # Last char is not a space or dot.  \n" +
				"$                                # Anchor to end of string.            ", 
				Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
		
		final Matcher matcher = pattern.matcher(text);

		return matcher.matches();
	}
	
	protected IPath getWorkflowPath(ILaunchConfiguration configuration) {
		final String modelBasename =
				DirectorCustomImpl.getModelBasename( configuration );
		
		final String configName = configuration.getName();
		
		final String filename = WORKFLOW_BASENAME +
				(configName.isEmpty() ? "" : (BASENAME_SEP + configName)) +
				(modelBasename.isEmpty() ? "" : (BASENAME_SEP + modelBasename)) +
				WORKFLOW_EXTENSION;
		
		if( isValidFilename( filename ) ) {
			return fWorkingDirectory.append( filename );
		}
		else {
			return fWorkingDirectory.append( WORKFLOW_BASENAME + WORKFLOW_EXTENSION );
		}
	}

	@Override
	public void launch(ILaunchConfiguration configuration,
			String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {

		fEnabledDebugOrDeveloperMode = ILaunchManager.DEBUG_MODE.equals(mode)
				&& ( SymbexPreferenceUtil.getBooleanPreference(
						IWorkflowPreferenceConstants.PREF_DEBUG_OPTIONS)
					|| SymbexPreferenceUtil.getBooleanPreference(
							IWorkflowPreferenceConstants.PREF_SYMBEX_DEVELOPER_MODE) );

		if( fEnabledDebugOrDeveloperMode ) {
			System.out.println("RUN DIVERSITY");
		}

		// resolve << avm.exe >> location
		fAvmExecLocation = CoreUtil.getLocation(configuration);
		if( fAvmExecLocation != null ) {
			IProject project = getCurrentProject(configuration);

			if( project != null ) {
				fWorkingDirectory = project.getLocation();

				WorkflowCustomImpl workflow =
						WorkflowCustomImpl.create(
								configuration, fWorkingDirectory);

				fSewLocation = getWorkflowPath(configuration);

				workflow.toWriter( fSewLocation );

//				if( fEnabledDebugOrDeveloperMode ) {
//					WorkflowFAVM aWorkflowFAVM = new WorkflowFAVM();
//					aWorkflowFAVM.configure( configuration ,
//							fWorkingDirectory, PROJECT_FAVM );
//
////					fSewLocation = fWorkingDirectory.append(PROJECT_FAVM);
//				}


				fModelAnalysisProfile = configuration.getAttribute(
						ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
						ANALYSIS_PROFILE_MODEL_UNDEFINED);

				fEnableTraceExtension = configuration.getAttribute(
						ATTR_ENABLED_TRACE_EXTENSION, false);

				launchExec(configuration, mode, launch, monitor);
			}
		}
	}


	private void throwCoreException(String message) throws CoreException {
		IStatus status = new Status(IStatus.ERROR,
				Activator.PLUGIN_ID, IStatus.OK, message, null);

		throw new CoreException(status);
	}


	public IProject getCurrentProject(
			ILaunchConfiguration configuration) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		String projectName = configuration.getAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, "");

		if( (projectName != null) && (! projectName.isEmpty()) ) {
			IProject project = root.getProject(projectName);
			if( project != null ) {
				return project;
			}
		}

		String aLocation = configuration.getAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION, "");

		if( (aLocation == null) || aLocation.isEmpty() ) {
			throwCoreException("The model file does not exist.");

			return null;
		}

//		aLocation = VariablesPlugin.getDefault().getStringVariableManager().
//				performStringSubstitution(aLocation);

		IResource resource = root.findMember(aLocation);

		if( (resource == null) || (! resource.exists()) ) {
			throwCoreException("The ressource model file \"" +
					aLocation + "\" does not exist.");

			return null;
		}

		return resource.getProject();
	}

	/**
	 * Status code indicating an unexpected internal error.
	 */
	public static final int ERR_INTERNAL_ERROR = 150;

	
	public static boolean isLaunchCoverageFamilyProfile() {
		return( LaunchDelegate.fEnableTraceExtension
		|| LaunchDelegate.fModelAnalysisProfile.equals(
				 ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION)
		|| LaunchDelegate.fModelAnalysisProfile.equals(
				 ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR) );
		
	}

	public static boolean isLaunchExplorationFamilyProfile() {
		return( LaunchDelegate.fModelAnalysisProfile.equals(
				 ANALYSIS_PROFILE_MODEL_EXPLORATION)
		|| LaunchDelegate.fModelAnalysisProfile.equals(
				 ANALYSIS_PROFILE_MODEL_TEST_OFFLINE)
		|| LaunchDelegate.fModelAnalysisProfile.equals(
				ANALYSIS_PROFILE_MODEL_UNDEFINED) );
	}

	public void launchExec(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		if (monitor.isCanceled()) {
			return;
		}

		// resolve working directory
//		IPath workingDirectory = CoreUtil.getWorkingDirectory(configuration);

		if (monitor.isCanceled()) {
			return;
		}

		// resolve arguments
		String[] arguments = CoreUtil.getArguments(configuration);

		if (monitor.isCanceled()) {
			return;
		}

		int cmdLineLength = 2 + ((arguments != null) ? arguments.length : 0);

		String[] cmdLine = new String[cmdLineLength];

		cmdLine[0] = fAvmExecLocation.toOSString();
		cmdLine[1] = fSewLocation.toOSString();

		if (arguments != null) {
			System.arraycopy(arguments, 0, cmdLine, 1, arguments.length);
		}

		if (monitor.isCanceled()) {
			return;
		}

		String[] envp = DebugPlugin.getDefault().getLaunchManager()
				.getEnvironment(configuration);

		if (monitor.isCanceled()) {
			return;
		}

		File workingDir = (fWorkingDirectory != null) ?
				fWorkingDirectory.toFile() : null;

		boolean debugOptionMode = SymbexPreferenceUtil.getBooleanPreference(
				IWorkflowPreferenceConstants.PREF_DEBUG_OPTIONS);

		String consoleLevel = configuration.getAttribute(
				ATTR_CONSOLE_LOG_VERBOSE_LEVEL, "MINIMUM");

		boolean spiderView = SymbexPreferenceUtil.getBooleanPreference(
				IWorkflowPreferenceConstants.PREF_SPIDER_VIEW);

		boolean consoleView = SymbexPreferenceUtil.getBooleanPreference(
				IWorkflowPreferenceConstants.PREF_CONSOLE_VIEW);


// Modif pour non-régression
//
//		defaultLaunchExecProcess(configuration, mode, launch,
//				monitor,cmdLine, workingDir, envp);
//
//		System.out.println("Debut deuxieme execution");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		defaultLaunchExecProcess(configuration, mode, launch,
//				monitor,cmdLine, workingDir, envp);




		if ( spiderView &&
			((! debugOptionMode) || consoleLevel.equals("MINIMUM")) ) {
			fConsoleManager.sewLaunchExecProcess(configuration, mode, launch,
					monitor,cmdLine, workingDir, envp);
		}
		else if ( consoleView ){
			// Console par défault
			defaultLaunchExecProcess(configuration, mode, launch,
					monitor,cmdLine, workingDir, envp);
		}
	}

	protected void defaultLaunchExecProcess(ILaunchConfiguration configuration,
			String mode, ILaunch launch, IProgressMonitor monitor,
			String[] cmdLine, File workingDir, String[] envp)
					throws CoreException {

		Process javaProcess = DebugPlugin.exec(cmdLine, workingDir, envp);
		IProcess eclipseProcess = null;

		// add process type to process attributes
		Map<String, String> processAttributes = new HashMap<String, String>();
		String programName = fAvmExecLocation.lastSegment();
		String extension = fAvmExecLocation.getFileExtension();
		if (extension != null) {
			programName = programName.substring(0, programName.length()
					- (extension.length() + 1));
		}
		programName = programName.toLowerCase();
		processAttributes.put(IProcess.ATTR_PROCESS_TYPE, programName);

		if( javaProcess != null ) {
			monitor.beginTask(NLS.bind("Running {0}...",
					new String[] { configuration.getName() }),
					IProgressMonitor.UNKNOWN);

			// Suppression d'un éventuel fichier stop.avm
			// d'une exécution précédente
			IPath fStopavmLocation = getCurrentProject(configuration).
					getLocation().append("Output/log/stop.avm");
			File fStopavmFile = fStopavmLocation.toFile();
			fStopavmFile.delete();

			eclipseProcess = DebugPlugin.newProcess(launch, javaProcess,
					fAvmExecLocation.toOSString(), processAttributes);

//			System.out.println("!!!!!!!!!!!!!!!!!!!!!!! launchSpiderJob(javaProcess) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//			launchSpiderJob(javaProcess);
		}

		if( (javaProcess == null) || (eclipseProcess == null) ) {
			if (javaProcess != null) {
				javaProcess.destroy();
			}
			throw new CoreException(new Status(IStatus.ERROR,
					Activator.PLUGIN_ID, ERR_INTERNAL_ERROR,
					"An IProcess could not be created for the launch", null));
		}

		eclipseProcess.setAttribute(
				IProcess.ATTR_CMDLINE, generateCommandLine(cmdLine));

		if( configuration.getAttribute(
				IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND, true) ) {
			// refresh resources after process finishes
			String scope = configuration.getAttribute(
					RefreshUtil.ATTR_REFRESH_SCOPE, (String)null);
			if( scope != null ) {
				BackgroundResourceRefresher refresher =
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
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// refresh resources
			RefreshUtil.refreshResources(configuration, monitor);
		}

		// Prise en compte du paramètre TIMEOUT
		//
		int timeout = configuration.getAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT, -1);
		if ( timeout != -1 ) {
			launchSupervisor(configuration, javaProcess, timeout);
		}
	}

	protected void launchSupervisor(ILaunchConfiguration configuration,
			Process javaProcess, int timeout) {
		try {
			javaProcess.waitFor(timeout, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		if ( javaProcess.isAlive() ) {
			try {
				IPath fStopavmLocation =
						getCurrentProject(configuration).
						getLocation().append("Output/log/stop.avm");
				BufferedWriter stopavm;
				stopavm = new BufferedWriter(
						new FileWriter( fStopavmLocation.toFile() ) );
				stopavm.write("");
				stopavm.close();
			}
			catch (IOException e) {
			}
			catch (CoreException e) {
				e.printStackTrace();
			}

			System.out.println("TIMEOUT END");
		}
	}

	private String generateCommandLine(String[] commandLine) {
		if (commandLine.length < 1)
			return "";
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < commandLine.length; i++) {
			buf.append(' ');
			char[] characters = commandLine[i].toCharArray();
			StringBuffer command = new StringBuffer();
			boolean containsSpace = false;
			for (int j = 0; j < characters.length; j++) {
				char character = characters[j];
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

}
