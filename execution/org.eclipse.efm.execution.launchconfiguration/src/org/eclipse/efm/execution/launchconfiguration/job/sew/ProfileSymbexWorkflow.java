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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;

public class ProfileSymbexWorkflow extends SymbexWorkflowProvider {


	protected IPath fReportFilePath;

	protected PrintWriter fLoggerWriter;

	protected static String CSV_SEPARATOR = " ; ";

	protected int fExecutionCount;

	protected long fTotalExecutionTime_COV;
	protected long fTotalExecutionTime_NOT;

	protected boolean fFullyCoverageFlag;
	protected int fFullyCoverageCount;


	public ProfileSymbexWorkflow(
			final SymbexWorkflowProvider symbexWorkflow, final int executionCount) {
		super(symbexWorkflow);

		this.fReportFilePath  = symbexWorkflow.getSymbexWorkflowPath()
				.removeFileExtension().addFileExtension("profile.csv");

		this.fLoggerWriter = null;

		this.fExecutionCount = executionCount;

		this.fTotalExecutionTime_COV = 0;
		this.fTotalExecutionTime_NOT = 0;

		this.fFullyCoverageFlag = false;
		this.fFullyCoverageCount = 0;
	}

	public ProfileSymbexWorkflow(final SymbexWorkflowProvider symbexWorkflow) {
		this(symbexWorkflow, 1000);
	}


	/*
	 * ANALYSIS PROFILE
	 */
	@Override
	public String getSymbexlAnalysisProfileName() {
		return "PROFILE EXECUTION: " + super.fIndex + " / " + this.fExecutionCount;
	}

	/*
	 * JOB / TASK / PROCESS
	 * NAME
	 */
	@Override
	public String getTaskName() {
		return super.fIndex + " / " + this.fExecutionCount + " : " + getJobName();
	}

	/*
	 * WORKFLOW
	 */
	@Override
	public boolean isConsistent() {
		return this.fWellFormednessFlag && super.isConsistent();
	}

	@Override
	public boolean isIterable() {
		return true;
	}

	@Override
	public int count() {
		return this.fExecutionCount;
	}

	@Override
	public boolean hasNext() {
		return (super.fIndex <= this.fExecutionCount) ;
	}

	@Override
	public void next() {
		super.fIndex = super.fIndex + 1;
	}


	/*
	 * INITIALIZE / FINALIZE
	 */
	@Override
	public boolean initialize() {
		if( super.initialize() )
		{
			super.fIndex = 1;

			try {
				final FileWriter buffer_ALL = new FileWriter( fReportFilePath.toOSString() );
				fLoggerWriter = new PrintWriter(buffer_ALL);
			}
			catch (final IOException e) {
				e.printStackTrace();
				return false;
			}

			logHeader(fLoggerWriter);

			return true;
		}

		return false;
	}

	public void logHeader(final PrintWriter logger) {
		logger.print( "Index" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Coverage" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Step" );
		logger.print( CSV_SEPARATOR );

		logger.print( "Execution Time" );

		logger.println();
		logger.flush();
		logger.flush();
	}

	@Override
	public void finalize() {
		fLoggerWriter.println();

		fLoggerWriter.print( "Total : " );
		fLoggerWriter.println( this.fExecutionCount );
		fLoggerWriter.print( "100 % : " );
		fLoggerWriter.println( this.fFullyCoverageCount );

		fLoggerWriter.print( "Average Fully Coverage Time: " );
		fLoggerWriter.println( (double)fTotalExecutionTime_COV / this.fFullyCoverageCount );

		fLoggerWriter.print( "Average Non Coverage Time  : " );
		fLoggerWriter.println( (double)fTotalExecutionTime_NOT /
				(this.fExecutionCount - this.fFullyCoverageCount) );

		fLoggerWriter.close();
	}


	/*
	 * LOGGING
	 */
	@Override
	public void beginLoggingSymbex() {
		resetExecutionStats();

		System.out.println( getTaskName() );
	}

	@Override
	public void log(final String message) {
		System.out.print(message);

		fLoggerWriter.print(message);
	}


	@Override
	public void endLoggingSymbex() {
		this.fFullyCoverageFlag = IWorkflowSpiderConfigurationUtils.
				SYMBEX_GOAL_ACHIEVED.equals(super.fExecutionVerdict);
		if( this.fFullyCoverageFlag ) {
			++this.fFullyCoverageCount;
			this.fTotalExecutionTime_COV += super.fExecutionTime;

			// Force l'arrêt avec hasNext() --> return (super.fIndex < this.fExecutionCount) ;
//			super.fIndex = this.fExecutionCount;
		}
		else {
			fTotalExecutionTime_NOT += super.fExecutionTime;
		}

		logSymbex( fLoggerWriter );
	}


	public void logSymbex(final PrintWriter logger) {
		logger.format( "%5d" , super.fIndex );
		logger.print( CSV_SEPARATOR );
		logger.format( "%8s" , (this.fFullyCoverageFlag ? "YES" : "NO") );
		logger.print( CSV_SEPARATOR );
		logger.format( "%4d" , super.fExecutionStepCount - 1 );
		logger.print( CSV_SEPARATOR );

		logger.format( "%11d" , super.fExecutionTime );
		logger.print( " ms" );

		logger.println();
		logger.flush();
	}



}
