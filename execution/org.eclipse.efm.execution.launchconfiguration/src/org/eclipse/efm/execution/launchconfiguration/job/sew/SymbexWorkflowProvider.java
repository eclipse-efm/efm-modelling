/*******************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.launchconfiguration.job.sew;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;

public class SymbexWorkflowProvider implements ISymbexWorkflowProvider {

	protected int fIndex;
	protected IPath[] fXliaModelsPath;

	protected IPath fXliaModelPath;

	protected IFile fWorkflowFile;
	protected IPath fWorkflowPath;

	protected IPath fWorkingDirectoryPath;
	protected String[] fEnvironment;

	protected String[] fCommandLine;

	protected String fJobName;
	protected String fRunDebugLaunchMode;
	protected String fAnalysisProfileName;


	protected boolean fConsistencyFlag;

	protected long fExecutionStepCount;
	protected long fExecutionContextCount;
	protected long fExecutionHeightMax;
	protected long fExecutionWidthMax;

	protected long fExecutionTime;

	protected long fDeadlockCount;
	protected long fLivelockCount;
	protected long fRunExitCount;

	protected long fTrivialLoopCount;
	protected long fTrivialLoopTest;

	protected long fRedundancyCount;
	protected long fRedundancyTest;


	public SymbexWorkflowProvider() {
		this.fIndex = 0;
		this.fXliaModelsPath = DEFAULT_XLIA_MODELS;
		this.fXliaModelPath = null;

		this.fWorkflowFile = null;
		this.fWorkflowPath = null;

		this.fWorkingDirectoryPath = WorkflowFileUtils.WORKSPACE_PATH;
		this.fEnvironment = DEFAULT_ENVIRONMENT_VARS;

		this.fCommandLine  = null;

		this.fJobName = DEFAULT_SYMBEX_WORKFLOW_JOB_NAME;
		this.fRunDebugLaunchMode  = ILaunchManager.RUN_MODE;
		this.fAnalysisProfileName = DEFAULT_SYMBEX_ANALYSIS_PROFILE;

		resetExecutionStats();
	}

	public SymbexWorkflowProvider(final String jobName,
			final String analysisProfileName, final IFile symbexWorkflowFile)
	{
		assert (symbexWorkflowFile != null) : "Unexpected a null Workflow File";

		this.fIndex = 0;
		this.fXliaModelsPath = DEFAULT_XLIA_MODELS;
		this.fXliaModelPath = null;

		this.fWorkflowFile = symbexWorkflowFile;
		this.fWorkflowPath = symbexWorkflowFile.getLocation();

		this.fWorkingDirectoryPath = WorkflowFileUtils.WORKSPACE_PATH;
		this.fEnvironment = DEFAULT_ENVIRONMENT_VARS;

		this.fCommandLine = new String[] {
				SymbexPreferenceUtil.strDiversityAvmExecLocation(), // SYMBEX_EXE
				symbexWorkflowFile.getLocation().toOSString(),      // SEW
				SYMBEX_LAUNCH_OPTION_ENABLE_SERVER_MODE,
				SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS
		};

		this.fJobName = jobName;
		this.fRunDebugLaunchMode  = ILaunchManager.RUN_MODE;
		this.fAnalysisProfileName = analysisProfileName;

		this.fConsistencyFlag = true;
	}

	public SymbexWorkflowProvider(final String jobName,
			final String analysisProfileName, final IPath symbexWorkflowPath)
	{
		assert (symbexWorkflowPath != null) : "Unexpected a null Workflow Path";

		this.fIndex = 0;
		this.fXliaModelsPath = DEFAULT_XLIA_MODELS;
		this.fXliaModelPath = null;

		this.fWorkflowFile = WorkflowFileUtils.findFile(symbexWorkflowPath);
		this.fWorkflowPath = symbexWorkflowPath;

		this.fWorkingDirectoryPath = WorkflowFileUtils.WORKSPACE_PATH;
		this.fEnvironment = DEFAULT_ENVIRONMENT_VARS;

		this.fCommandLine = new String[] {
				SymbexPreferenceUtil.strDiversityAvmExecLocation(), // SYMBEX_EXE
				symbexWorkflowPath.toOSString(),      // SEW
				SYMBEX_LAUNCH_OPTION_ENABLE_SERVER_MODE,
				SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS
		};

		this.fJobName = jobName;
		this.fRunDebugLaunchMode  = ILaunchManager.RUN_MODE;
		this.fAnalysisProfileName = analysisProfileName;

		this.fConsistencyFlag = true;
	}

	public SymbexWorkflowProvider(final ILaunchConfiguration configuration,
			final String runDebuglaunchMode, final String analysisProfileName,
			final String[] commandLine, final IPath workingDirectoryPath) {
		assert (commandLine != null) : "Unexpected a null Command Line";
		assert (commandLine.length > 1) : "No enough  a null Command Line Args";

		this.fIndex = 0;
		this.fXliaModelsPath = DEFAULT_XLIA_MODELS;
		this.fXliaModelPath = null;

		this.fWorkflowPath = new Path(commandLine[1]);
		this.fWorkflowFile = WorkflowFileUtils.findFile(this.fWorkflowPath);

		this.fWorkingDirectoryPath = (workingDirectoryPath != null) ?
				workingDirectoryPath : WorkflowFileUtils.WORKSPACE_PATH;
		try {
			this.fEnvironment = DebugPlugin.getDefault()
					.getLaunchManager().getEnvironment(configuration);
		} catch (final CoreException e) {
			this.fEnvironment = DEFAULT_ENVIRONMENT_VARS;
			e.printStackTrace();
		}

		this.fCommandLine  = commandLine;

		this.fJobName = configuration.getName();
		this.fRunDebugLaunchMode  = runDebuglaunchMode;
		this.fAnalysisProfileName = analysisProfileName;

		resetExecutionStats();

		this.fConsistencyFlag = true;
	}


	public SymbexWorkflowProvider(final String jobName,
			final String runDebuglaunchMode, final String[] commandLine,
			final IPath workingDirectoryPath, final String[] environment) {
		assert (commandLine != null) : "Unexpected a null Command Line";
		assert (commandLine.length > 1) : "No enough  a null Command Line Args";

		this.fIndex = 0;
		this.fXliaModelsPath = DEFAULT_XLIA_MODELS;
		this.fXliaModelPath = null;

		this.fWorkflowPath = new Path(commandLine[1]);
		this.fWorkflowFile = WorkflowFileUtils.findFile(this.fWorkflowPath);

		this.fWorkingDirectoryPath = (workingDirectoryPath != null) ?
				workingDirectoryPath : WorkflowFileUtils.WORKSPACE_PATH;
		this.fEnvironment = (environment != null) ?
				environment : DEFAULT_ENVIRONMENT_VARS;

		this.fCommandLine  = commandLine;

		this.fJobName = jobName;
		this.fRunDebugLaunchMode  = runDebuglaunchMode;
		this.fAnalysisProfileName = DEFAULT_SYMBEX_ANALYSIS_PROFILE;

		resetExecutionStats();

		this.fConsistencyFlag = true;
	}



	public void resetExecutionStats() {
		this.fConsistencyFlag = false;

		this.fExecutionStepCount    = 0;
		this.fExecutionContextCount = 0;
		this.fExecutionHeightMax    = 0;
		this.fExecutionWidthMax     = 0;

		this.fExecutionTime = 0;

		this.fDeadlockCount = 0;
		this.fLivelockCount = 0;
		this.fRunExitCount  = 0;

		this.fTrivialLoopCount = 0;
		this.fTrivialLoopTest  = 0;

		this.fRedundancyCount = 0;
		this.fRedundancyTest  = 0;
	}


	/*
	 * JOB / PROCESS
	 * NAME
	 */
	@Override
	public String getJobName() {
		return (fJobName != null) ? fJobName : DEFAULT_SYMBEX_WORKFLOW_JOB_NAME;
	}

	@Override
	public String getProcessName() {
		if( fJobName != null ) {
			return fJobName;
		}
		else if( fWorkflowPath != null ) {
			return fWorkflowPath.lastSegment();
		}

		return DEFAULT_SYMBEX_PROCESS_NAME;
	}


	/*
	 * ANALYSIS PROFILE / LAUNCH MODE
	 * NAME
	 */
	@Override
	public String getSymbexlAnalysisProfileName() {
		return this.fAnalysisProfileName;
	}

	@Override
	public String getRunDebugLaunchMode() {
		return fRunDebugLaunchMode;
	}

	/*
	 *
	 */
	@Override
	public IPath getWorkingDirectoryPath() {
		return fWorkingDirectoryPath;
	}

	@Override
	public String[] getEnvironment() {
		return fEnvironment;
	}


	/*
	 * ITERATOR
	 */
	@Override
	public void next() {
		this.fIndex = this.fIndex + 1;
	}

	@Override
	public boolean hasNext() {
		return (this.fIndex < this.fXliaModelsPath.length) ;
	}


	/*
	 * WORKFLOW
	 */
	@Override
	public boolean isIterable() {
		return false;
	}

	@Override
	public int count() {
		return this.fXliaModelsPath.length;
	}

	@Override
	public int index() {
		return this.fIndex;
	}

	@Override
	public boolean isConsistent() {
		return this.fConsistencyFlag;
	}

	/*
	 * SYMBEX WORKFLOW
	 */
	@Override
	public IPath genSymbexWorkflow() {
		return this.fWorkflowPath;
	}

	@Override
	public IPath getSymbexWorkflowPath() {
		return this.fWorkflowPath;
	}

	@Override
	public IFile getRefreshResource() {
		return this.fWorkflowFile;
	}

	/*
	 * XLIA MODEL
	 */
	@Override
	public IPath getXliaModelPath() {
		return this.fXliaModelPath;
	}


	/*
	 * COMMAND LINE
	 */
	@Override
	public String[] getCommandLine() {
		return fCommandLine;
	}


	/*
	 * REPORTING
	 */
    final static Pattern PATTERN_EXECUTION_STOP_STATS = Pattern.compile(
    		"stop:\\s*(\\d+)\\s*,\\s*context:\\s*(\\d+)\\s*,"
    		+ "\\s*height:\\s*(\\d+)\\s*,\\s*width:\\s*(\\d+).*");

    final static Pattern PATTERN_EXECUTION_TIME = Pattern.compile(
    		"\\$time<\\s*(\\d+)\\s*ms.+");
//    		"time:\\(real:\\s*(\\d+).+");


    final static Pattern PATTERN_DEADLOCK_COUNT = Pattern.compile(
    		"The DEADLOCK found : (\\d+).*");

    final static Pattern PATTERN_LIVELOCK_COUNT = Pattern.compile(
    		"The DEADLOCK found : (\\d+).*");

    final static Pattern PATTERN_RUN_EXIT_COUNT = Pattern.compile(
    		"The RUN#EXIT found : (\\d+).*");


   final static Pattern PATTERN_REDUNDANCY_COUNT = Pattern.compile(
    		"The redundancy count: (\\d+) for (\\d+) tests.*");

    final static Pattern PATTERN_TRIVIAL_LOOP_COUNT = Pattern.compile(
    		"The trivial loop count: (\\d+) for (\\d+) tests.*");


	@Override
	public void analyzeReport(final String line) {
        Matcher matcher = null;

		if( (matcher = PATTERN_DEADLOCK_COUNT.matcher(line)).find() ) {
			this.fDeadlockCount = Long.parseUnsignedLong( matcher.group(1) );
		}
		else if( (matcher = PATTERN_LIVELOCK_COUNT.matcher(line)).find() ) {
			this.fLivelockCount = Long.parseUnsignedLong( matcher.group(1) );
		}
		else if( (matcher = PATTERN_RUN_EXIT_COUNT.matcher(line)).find() ) {
			this.fRunExitCount = Long.parseUnsignedLong( matcher.group(1) );
		}

		else if( (matcher = PATTERN_REDUNDANCY_COUNT.matcher(line)).find() ) {
			this.fRedundancyCount = Integer.parseUnsignedInt( matcher.group(1) );
			this.fRedundancyTest  = Integer.parseUnsignedInt( matcher.group(2) );
		}
		else if( (matcher = PATTERN_TRIVIAL_LOOP_COUNT.matcher(line)).find() ) {
			this.fTrivialLoopCount = Integer.parseUnsignedInt( matcher.group(1) );
			this.fTrivialLoopTest  = Integer.parseUnsignedInt( matcher.group(2) );
		}

		else if( (matcher = PATTERN_EXECUTION_STOP_STATS.matcher(line)).find() ) {
			this.fExecutionStepCount = Integer.parseUnsignedInt( matcher.group(1) );
			this.fExecutionContextCount = Integer.parseUnsignedInt( matcher.group(2) );
			this.fExecutionHeightMax = Integer.parseUnsignedInt( matcher.group(3) );
			this.fExecutionWidthMax = Integer.parseUnsignedInt( matcher.group(4) );
		}

		else if( (matcher = PATTERN_EXECUTION_TIME.matcher(line)).find() ) {
			this.fExecutionTime = Long.parseUnsignedLong( matcher.group(1) );
		}
	}

	@Override
	public void reportCoverage(final String coverage) {
		System.out.println("COVRAGE: " + coverage);
	}


	/*
	 * SYMBEX VERDICT
	 */
	@Override
	public boolean hasVerdict() {
//		final boolean livenessFlag =
//				(this.fRedundancyCount == 1) &&
//				(this.fRedundancyTest  == 1) &&
//				(this.fDeadlockCount   == 0) &&
//				(this.fRunExitCount    == 0);
//
//		return livenessFlag;

		return false;
	}

	@Override
	public String getVerdict() {
		final boolean livenessFlag =
				(this.fRedundancyCount == 1) &&
				(this.fRedundancyTest  == 1) &&
				(this.fDeadlockCount   == 0) &&
				(this.fRunExitCount    == 0);

		return livenessFlag ? "LIVE" : "NO";
	}

	@Override
	public void setVerdict(final String verdict) {
		System.out.println("VERDICT: " + verdict);
	}


	/*
	 * INITIALIZE / START / FINALIZE
	 */
	@Override
	public
	boolean initialize() {
		if( fXliaModelsPath.length > 0 )
		{
			fIndex = 0;

			return true;
		}
		return false;
	}

	@Override
	public void finalize() {

	}


	/*
	 * LOGGING
	 */
	@Override
	public void beginLoggingSymbex() {
		resetExecutionStats();
	}

	@Override
	public void log(final String message) {

	}

	@Override
	public void endLoggingSymbex() {

	}

}
