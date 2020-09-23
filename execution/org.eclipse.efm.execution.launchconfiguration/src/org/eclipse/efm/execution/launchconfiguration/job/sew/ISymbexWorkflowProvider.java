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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJob;

public interface ISymbexWorkflowProvider {

	String DEFAULT_SYMBEX_WORKFLOW_JOB_NAME = "SymbexWorkflow";

	String DEFAULT_SYMBEX_PROCESS_NAME      = "Process";

	String DEFAULT_SYMBEX_EXECUTION_MODE    = "user";

	String DEFAULT_SYMBEX_ANALYSIS_PROFILE =
			AnalysisProfileKind.ANALYSIS_USER_SEW_PROFILE.getLiteral();

	IPath[] DEFAULT_XLIA_MODELS = new IPath[0];

	///////////////////////////////////////////////////////////////////////////
	// SYMBEX LAUNCH OPTION
	///////////////////////////////////////////////////////////////////////////

	String SYMBEX_LAUNCH_OPTION_ENABLE_SERVER_MODE =
			"--enable-server-mode";

	String SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS =
			"--enable-print-spider-positions";

	String[] DEFAULT_ENVIRONMENT_VARS = new String[0];


	/*
	 * JOB / TASK / PROCESS
	 * NAME
	 */
	default String getJobName() {
		return DEFAULT_SYMBEX_WORKFLOW_JOB_NAME;
	}

	default String getTaskName() {
		final IPath path = getXliaModelPath();
		return index() + " / " + count() + " : " + ( (path != null)?
				WorkflowFileUtils.makeRootRelativeToWorkspacePath(path)
				: getJobName() );
	}

	default String getProcessName() {
		return DEFAULT_SYMBEX_PROCESS_NAME;
	}

	/*
	 * ANALYSIS PROFILE / LAUNCH MODE
	 * NAME
	 */
	default String getSymbexlAnalysisProfileName() {
		return DEFAULT_SYMBEX_ANALYSIS_PROFILE;
	}

	default String getRunDebugLaunchMode() {
		return DEFAULT_SYMBEX_EXECUTION_MODE;
	}

	/*
	 *
	 */
	default IPath getWorkingDirectoryPath() {
		return WorkflowFileUtils.WORKSPACE_PATH;
	}

	default String[] getEnvironment() {
		return DEFAULT_ENVIRONMENT_VARS;
	}


	/*
	 * ITERATOR
	 */
	void next();

	boolean hasNext();

	ISymbexWorkflowProvider getNextWorkflow();

	/*
	 * WORKFLOW
	 */
	boolean isIterable();

	int count();

	int index();

	default boolean hasWorkflow() {
		return hasNext();
	}

	boolean isConsistent();

	/*
	 * SYMBEX WORKFLOW
	 */
	IPath genSymbexWorkflow();

	IPath getSymbexWorkflowPath();

	IResource getRefreshResource();


	/*
	 * XLIA MODEL
	 */
	IPath getXliaModelPath();

	/*
	 * COMMAND LINE
	 */
	String[] getCommandLine();


	/*
	 * REPORTING
	 */
	void analyzeReport(String line);

	void reportCoverage(String coverage);

	void setError();

	/*
	 * SYMBEX VERDICT
	 */
	default boolean hasVerdict() {
		return false;
	}

	default String getVerdict() {
		return null;
	}

	void setVerdict(String verdict);

	/*
	 * INITIALIZE / START / FINALIZE
	 */
	boolean initialize();

	default boolean start()  {
		if( initialize() ) {
			try {
				final SymbexJob job = new SymbexJob(this);

				job.setUser(true);

				job.schedule();

				return true;
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	void finalize();


	/*
	 * LOGGING
	 */
	void beginLoggingSymbex();
	void log(String message);
	void endLoggingSymbex();

}
