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
import java.util.Calendar;

import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;

public class ProfileSymbexWorkflow extends SymbexWorkflowProvider {


	protected IPath fReportFilePath;

	protected PrintWriter fLoggerWriter;

	protected static String CSV_SEPARATOR = " ; ";

	protected int fExecutionCount;

	protected boolean fStopWhenFullyCoverage;

	protected long fTotalExecutionTime_COV;
	protected long fTotalExecutionTime_NOT;

	protected long fTotalExecutionStepCount;
	protected long fTotalExecutionContextCount;
	protected long fTotalExecutionHeightMax;
	protected long fTotalExecutionWidthMax;

	protected boolean fFullyCoverageFlag;
	protected int fFullyCoverageCount;


	public ProfileSymbexWorkflow(
			final SymbexWorkflowProvider symbexWorkflow, final int executionCount) {
		super(symbexWorkflow);

		final Calendar CALENDAR = Calendar.getInstance();
		this.fReportFilePath  = symbexWorkflow.getSymbexWorkflowPath()
				.removeFileExtension().addFileExtension(
						"profile_" + CALENDAR.get(Calendar.HOUR_OF_DAY)
						+ "_" + CALENDAR.get(Calendar.MINUTE) + ".csv");

		this.fLoggerWriter = null;

		if( executionCount > 0 ) {
			this.fExecutionCount = executionCount;
			this.fStopWhenFullyCoverage = false;
		}
		else {
			this.fExecutionCount = Integer.MAX_VALUE;
			this.fStopWhenFullyCoverage = true;
		}


		this.fTotalExecutionTime_COV     = 0;
		this.fTotalExecutionTime_NOT     = 0;

		this.fTotalExecutionStepCount    = 0;
		this.fTotalExecutionContextCount = 0;
		this.fTotalExecutionHeightMax    = 0;
		this.fTotalExecutionWidthMax     = 0;

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
		return "PROFILING EXECUTION: " + super.fIndex + " / " + this.fExecutionCount;
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
		if( this.fStopWhenFullyCoverage && fFullyCoverageFlag) {
			return false;
		}
		return (super.fIndex <= this.fExecutionCount);
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
		logger.print( "Context" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Height" );
		logger.print( CSV_SEPARATOR );

		logger.print( "Execution Time" );

		logger.println();
		logger.flush();
	}

	public void reportStatistic(final PrintWriter logger) {
		logger.println();

		logger.print( "Average Step" );
		logger.print( CSV_SEPARATOR );

		logger.print( "Context" );
		logger.print( CSV_SEPARATOR );

		logger.print( "Height" );
		logger.print( CSV_SEPARATOR );

		logger.print( " Width" );
		logger.print( CSV_SEPARATOR );

		logger.print( "100% Time" );
		logger.print( CSV_SEPARATOR );

		logger.print( "@->Date" );

		logger.println();

		logger.format( "%12.1f",
				(double)this.fTotalExecutionStepCount / this.fFullyCoverageCount );
		logger.print( CSV_SEPARATOR );

		logger.format( "%7.1f",
				(double)this.fTotalExecutionContextCount / this.fFullyCoverageCount );
		logger.print( CSV_SEPARATOR );

		logger.format( "%6.1f",
				(double)this.fTotalExecutionHeightMax / this.fFullyCoverageCount );
		logger.print( CSV_SEPARATOR );

		logger.format( "%6.1f",
				(double)this.fTotalExecutionWidthMax / this.fFullyCoverageCount );
		logger.print( CSV_SEPARATOR );


		logger.format( "%9.1f",
				(double)this.fTotalExecutionTime_COV / this.fFullyCoverageCount );
		logger.print( CSV_SEPARATOR );

		logger.format( "%tT", Calendar.getInstance().getTime() );

		logger.println();

	}

	@Override
	public void finalize() {
		reportStatistic(fLoggerWriter);

		fLoggerWriter.println();

		fLoggerWriter.print( "Total : " );
		fLoggerWriter.println( super.fIndex - 1 );//Math.min(this.fExecutionCount, super.fIndex) );
		fLoggerWriter.print( "100 % : " );
		fLoggerWriter.println( this.fFullyCoverageCount );


		fLoggerWriter.print( "Average Execution Step Count   : " );
		fLoggerWriter.println(
				(double)this.fTotalExecutionStepCount / this.fFullyCoverageCount );

		fLoggerWriter.println();

		fLoggerWriter.print( "Average Execution Context Count: " );
		fLoggerWriter.println(
				(double)this.fTotalExecutionContextCount / this.fFullyCoverageCount );

		fLoggerWriter.println();

		fLoggerWriter.print( "Average Execution Height: " );
		fLoggerWriter.println(
				(double)this.fTotalExecutionHeightMax / this.fFullyCoverageCount );

		fLoggerWriter.print( "Average Execution Width : " );
		fLoggerWriter.println(
				(double)this.fTotalExecutionWidthMax / this.fFullyCoverageCount );

		fLoggerWriter.println();

		fLoggerWriter.print( "Average Fully Coverage Time: " );
		fLoggerWriter.println(
				(double)this.fTotalExecutionTime_COV / this.fFullyCoverageCount );

		fLoggerWriter.print( "Average Non Coverage Time  : " );
		fLoggerWriter.println( (double)this.fTotalExecutionTime_NOT /
				(this.fExecutionCount - this.fFullyCoverageCount) );

		fLoggerWriter.println();

		fLoggerWriter.println( Calendar.getInstance().getTime() );


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

			this.fTotalExecutionStepCount    += fExecutionStepCount;
			this.fTotalExecutionContextCount += fExecutionContextCount;
			this.fTotalExecutionHeightMax    += fExecutionHeightMax;
			this.fTotalExecutionWidthMax     += fExecutionWidthMax;

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

		logger.format( "%8s" , (this.fFullyCoverageFlag ? "100 %"
				: super.fCoverageCount + " / " + super.fCoverageTotal) );
		logger.print( CSV_SEPARATOR );

		logger.format( "%4d" , super.fExecutionStepCount );
		logger.print( CSV_SEPARATOR );

		logger.format( "%7d" , super.fExecutionContextCount );
		logger.print( CSV_SEPARATOR );

		logger.format( "%6d" , super.fExecutionHeightMax );
		logger.print( CSV_SEPARATOR );

		logger.format( "%11d" , super.fExecutionTime );
		logger.print( " ms" );

		if( ((super.fIndex % 5) == 0) && ((super.fIndex < this.fExecutionCount)) ) {
			logger.println();

			reportStatistic(logger);
			logger.flush();

			logger.println();
			logHeader(fLoggerWriter);
		}
		else {
			logger.println();
		}

		logger.flush();
		logger.flush();
	}



}
