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
import org.eclipse.efm.execution.core.preferences.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.core.workflow.DirectorCustomImpl;
import org.eclipse.efm.execution.core.workflow.WorkflowCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJob;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJobFactory;
import org.eclipse.efm.execution.launchconfiguration.ui.views.page.LaunchExecConsoleManager;
import org.eclipse.efm.execution.launchconfiguration.util.BackgroundResourceRefresher;
import org.eclipse.efm.execution.launchconfiguration.util.CoreUtil;
import org.eclipse.osgi.util.NLS;

public class LaunchDelegate extends AbstractLaunchDelegate {


//	private final String PROJECT_FAVM = "project.favm";

	private final String BASENAME_SEP = "-";


	private final String WORKFLOW_FOLDER = ".sew";

	private final String WORKFLOW_BASENAME = "workflow";

	private final String WORKFLOW_EXTENSION = ".sew";


	private IPath fAvmExecLocation;

	private IPath fSewLocation;
	private IPath fWorkingDirectory;

	private IPath fLaunchingDirectory;


	public static AnalysisProfileKind fModelAnalysisProfile =
			AnalysisProfileKind.ANALYSIS_UNDEFINED_PROFILE;

	public static boolean fEnableTraceExtension = false;



	/**
	 * LaunchExecConsoleManager
	 */
	LaunchExecConsoleManager fConsoleManager;

	boolean fEnabledDebugOrDeveloperMode;

	public LaunchDelegate() {
		fSewLocation = null;
		fWorkingDirectory = null;

		fLaunchingDirectory = WorkflowFileUtils.WORKSPACE_PATH;

		fConsoleManager = new LaunchExecConsoleManager();

		fEnabledDebugOrDeveloperMode = false;
	}


	public static boolean isValidFilename(final String text)
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

	protected IPath getWorkflowPath(final ILaunchConfiguration configuration) {
		final String modelBasename =
				WorkflowFileUtils.getModelBasename( configuration );

		final String configName = configuration.getName();

		final String filename = WORKFLOW_BASENAME +
				(configName.isEmpty() ? "" : (BASENAME_SEP + configName)) +
				(modelBasename.isEmpty() ? "" : (BASENAME_SEP + modelBasename)) +
				WORKFLOW_EXTENSION;

		IPath workflowsFolderPath = fWorkingDirectory.append( WORKFLOW_FOLDER );

		final File workflowsFolderFile = workflowsFolderPath.toFile();
		if( ! workflowsFolderFile.isDirectory() ) {
			if( ! workflowsFolderFile.exists() ) {
				workflowsFolderFile.mkdirs();
			}
			else {
				workflowsFolderPath = fWorkingDirectory;
			}
		}

		if( isValidFilename( filename ) ) {
			return workflowsFolderPath.append( filename );
		}
		else {
			return workflowsFolderPath.append( WORKFLOW_BASENAME + WORKFLOW_EXTENSION );
		}
	}

	@Override
	public void launch(final ILaunchConfiguration configuration,
			final String mode, final ILaunch launch, final IProgressMonitor monitor)
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
			final IProject project = getCurrentProject(configuration);

			if( project != null ) {
				fWorkingDirectory = project.getLocation();

				final IPath relativeLaunchPath =
					WorkflowFileUtils.makeRootRelativeToWorkspacePath(fWorkingDirectory);

				final WorkflowCustomImpl workflow = WorkflowCustomImpl.create(
						configuration, fWorkingDirectory, relativeLaunchPath);

				fSewLocation = getWorkflowPath(configuration);

				workflow.toWriter( fSewLocation );

//				if( fEnabledDebugOrDeveloperMode ) {
//					WorkflowFAVM aWorkflowFAVM = new WorkflowFAVM();
//					aWorkflowFAVM.configure( configuration ,
//							fWorkingDirectory, PROJECT_FAVM );
//
////					fSewLocation = fWorkingDirectory.append(PROJECT_FAVM);
//				}

				fModelAnalysisProfile = AnalysisProfileKind.get(
						configuration.getAttribute(
							ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
							AnalysisProfileKind.ANALYSIS_UNDEFINED_PROFILE.getLiteral()));

				fEnableTraceExtension = configuration.getAttribute(
						ATTR_ENABLED_TRACE_EXTENSION, false);

				launchExec(configuration, mode, launch, monitor);
			}
		}
	}


	private void throwCoreException(final String message) throws CoreException {
		final IStatus status = new Status(IStatus.ERROR,
				Activator.PLUGIN_ID, IStatus.OK, message, null);

		throw new CoreException(status);
	}


	public IProject getCurrentProject(
			final ILaunchConfiguration configuration) throws CoreException {
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		final String projectName = configuration.getAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, "");

		if( (projectName != null) && (! projectName.isEmpty()) ) {
			final IProject project = root.getProject(projectName);
			if( project != null ) {
				return project;
			}
		}

		final String aLocation = WorkflowFileUtils.getAbsoluteLocation(
				configuration, ATTR_SPECIFICATION_MODEL_FILE_LOCATION, "");

		if( aLocation.isEmpty() ) {
			throwCoreException("The model file does not exist.");

			return null;
		}

//		aLocation = VariablesPlugin.getDefault().getStringVariableManager().
//				performStringSubstitution(aLocation);

		final IResource resource = root.findMember(aLocation);

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


	public static boolean isLaunchCoverageProfileFamily() {
		if( ! LaunchDelegate.fEnableTraceExtension ) {
			return DirectorCustomImpl.isCoverageAnalysisProfile(fModelAnalysisProfile);
		}
		return true;
	}

	public static boolean isLaunchExplorationProfileFamily() {
		return DirectorCustomImpl.isExplorationAnalysisProfile(fModelAnalysisProfile);
	}

	public void launchExec(final ILaunchConfiguration configuration, final String mode,
			final ILaunch launch, final IProgressMonitor monitor) throws CoreException {

		if (monitor.isCanceled()) {
			return;
		}

		// resolve working directory
//		IPath workingDirectory = CoreUtil.getWorkingDirectory(configuration);

		if (monitor.isCanceled()) {
			return;
		}

		// resolve arguments
		final String[] arguments = CoreUtil.getArguments(configuration);

		if (monitor.isCanceled()) {
			return;
		}

		final int cmdLineLength = 4 + ((arguments != null) ? arguments.length : 0);

		final String[] commandLine = new String[cmdLineLength];

		commandLine[0] = fAvmExecLocation.toOSString();
		commandLine[1] = fSewLocation.toOSString();
		commandLine[2] = SymbexJob.SYMBEX_LAUNCH_OPTION_ENABLE_SERVER_MODE;
		commandLine[3] = SymbexJob.SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS;

		if (arguments != null) {
			System.arraycopy(arguments, 0, commandLine, 4, arguments.length);
		}

		if (monitor.isCanceled()) {
			return;
		}

		final String[] envp = DebugPlugin.getDefault().getLaunchManager()
				.getEnvironment(configuration);

		if (monitor.isCanceled()) {
			return;
		}

//		boolean debugOptionMode = SymbexPreferenceUtil.getBooleanPreference(
//				IWorkflowPreferenceConstants.PREF_DEBUG_OPTIONS);

// Modif pour non-régression
//
//		defaultLaunchExecProcess(configuration, mode, launch,
//				monitor,commandLine, workingDir, envp);
//
//		System.out.println("Debut deuxieme execution");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		defaultLaunchExecProcess(configuration, mode, launch,
//				monitor,commandLine, workingDir, envp);


//		fConsoleManager.sewLaunchExecProcess(configuration, mode,
//				launch, monitor, commandLine, fLaunchingDirectory.toFile(), envp);

		SymbexJobFactory.run(configuration, mode, launch, //monitor,
				commandLine, fLaunchingDirectory, envp);

		// Console par défault
//		defaultLaunchExecProcess(configuration, mode, launch,
//				monitor,commandLine, fLaunchingDirectory, envp);
	}

	protected void defaultLaunchExecProcess(final ILaunchConfiguration configuration,
			final String mode, final ILaunch launch, final IProgressMonitor monitor,
			final String[] commandLine, final IPath workingDirecory, final String[] envp)
					throws CoreException {

		final File workingDir = (workingDirecory != null) ?
				workingDirecory.toFile() : null;

		final Process javaProcess = DebugPlugin.exec(commandLine, workingDir, envp);
		IProcess eclipseProcess = null;

		// add process type to process attributes
		final Map<String, String> processAttributes = new HashMap<String, String>();
		String programName = fAvmExecLocation.lastSegment();
		final String extension = fAvmExecLocation.getFileExtension();
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
			final IPath fStopavmLocation = getCurrentProject(configuration).
					getLocation().append("Output/log/stop.avm");
			final File fStopavmFile = fStopavmLocation.toFile();
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
				IProcess.ATTR_CMDLINE, generateCommandLine(commandLine));

		if( configuration.getAttribute(
				IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND, true) ) {
			// refresh resources after process finishes
			final String scope = configuration.getAttribute(
					RefreshUtil.ATTR_REFRESH_SCOPE, (String)null);
			if( scope != null ) {
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
					e.printStackTrace();
				}
			}
			// refresh resources
			RefreshUtil.refreshResources(configuration, monitor);
		}

		// Prise en compte du paramètre TIMEOUT
		//
		final int timeout = configuration.getAttribute(
				ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT, -1);
		if ( timeout != -1 ) {
			launchSupervisor(configuration, javaProcess, timeout);
		}
	}

	protected void launchSupervisor(final ILaunchConfiguration configuration,
			final Process javaProcess, final int timeout) {
		try {
			javaProcess.waitFor(timeout, TimeUnit.SECONDS);
		}
		catch (final InterruptedException e) {
			e.printStackTrace();
		}

		if ( javaProcess.isAlive() ) {
			try {
				final IPath fStopavmLocation =
						getCurrentProject(configuration).
						getLocation().append("Output/log/stop.avm");
				BufferedWriter stopavm;
				stopavm = new BufferedWriter(
						new FileWriter( fStopavmLocation.toFile() ) );
				stopavm.write("");
				stopavm.close();
			}
			catch (final IOException e) {
			}
			catch (final CoreException e) {
				e.printStackTrace();
			}

			System.out.println("TIMEOUT END");
		}
	}

	private String generateCommandLine(final String[] commandLine) {
		if (commandLine.length < 1)
			return "";
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

}
