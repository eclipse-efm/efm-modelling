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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;

public class LivenessCheckerSymbexWorkflow extends SymbexWorkflowProvider {

	protected final IContainer fModelsContainer;

	protected IPath fReportFilePath_ALL;
	protected IPath fReportFilePath_LIVE;
	protected IPath fReportFilePath_NOT;

	protected PrintWriter fLoggerWriter_ALL;
	protected PrintWriter fLoggerWriter_LIVE;
	protected PrintWriter fLoggerWriter_NOT;

	protected static String CSV_SEPARATOR = " ; ";

	protected int fActorCount;
	protected int fChannelCount;
	protected int fTimedActorCount;
	protected int fPhaseActorCount;
	protected int fTickCount;
	protected int fFiringCount;

	protected boolean fLivenessFlag;

	protected long fWellFormedCount;
	protected long fConsistentCount;
	protected long fLivenessCount;

	protected long fTotalTick_LIVE;
	protected long fTotalTick_NOT;

	protected long fTotalFiring_LIVE;
	protected long fTotalFiring_NOT;

	protected long fTotalExecutionTime_LIVE;
	protected long fTotalExecutionTime_NOT;



	public LivenessCheckerSymbexWorkflow(
			final IContainer container, final String reportFilename) {
		super();

		assert (container != null) : "Unexpected a null Workflow Container";

		fModelsContainer = container;

		IPath path = container.getLocation();
		String filename = reportFilename;
		if( ! (container instanceof IProject) ) {
			filename = reportFilename + "_" + path.lastSegment();
			path = path.removeLastSegments(1);
		}
		this.fReportFilePath_ALL  = path.append(filename + "_ALL" ).addFileExtension("csv");
		this.fReportFilePath_LIVE = path.append(filename + "_LIVE").addFileExtension("csv");
		this.fReportFilePath_NOT  = path.append(filename + "_NOT" ).addFileExtension("csv");

		this.fLoggerWriter_ALL  = null;
		this.fLoggerWriter_LIVE = null;
		this.fLoggerWriter_NOT  = null;

		this.fActorCount = 0;
		this.fChannelCount = 0;
		this.fTimedActorCount = 0;
		this.fPhaseActorCount = 0;
		this.fTickCount = 0;
		this.fFiringCount = 0;

		this.fLivenessFlag = false;

		this.fWellFormedCount = 0;
		this.fConsistentCount = 0;
		this.fLivenessCount = 0;

		this.fTotalTick_LIVE = 0;
		this.fTotalTick_NOT = 0;

		this.fTotalFiring_LIVE = 0;
		this.fTotalFiring_NOT = 0;

		this.fTotalExecutionTime_LIVE = 0;
		this.fTotalExecutionTime_NOT = 0;
	}


	/*
	 * UTILS
	 */
	public void collectXliaModels() {
		final ArrayList<IPath> xliaModels = new ArrayList<IPath>();
		try {
			for( final IResource resource : this.fModelsContainer.members() ) {
				if( (resource instanceof IFile)
					&& "xlia".equals(resource.getFileExtension()) )
				{
					xliaModels.add(resource.getLocation());
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}

		super.fXliaModelsPath = xliaModels.toArray( new IPath[xliaModels.size()] );
	}


	public static String getSEW(final IPath folder, final IPath model)
	{
		final IPath launch = folder.makeRelativeTo(
				ResourcesPlugin.getWorkspace().getRoot().getLocation());

		final String sew = "@sew< workflow , 1.0 >:\n"
				+ "\n// Symbolic Execution Workflow"
				+ "\n// Diversity Tool Configuration"
				+ "\n// CEA - LIST"
				+ "\nworkflow {"
				+ "\n	workspace ["
				+ "\n		root   = \"" + folder.toString() + "\""
				+ "\n		launch = \"" + launch.toString() + "\""
				+ "\n		output = \"out\""
				+ "\n		log    = \"log\""
				+ "\n		debug  = \"debug\""
				+ "\n	] // end workspace"
				+ "\n	director exploration 'as main execution objective' {"
				+ "\n		manifest ["
				+ "\n			autoconf  = true"
				+ "\n			autostart = true"
				+ "\n		] // end manifest"
				+ "\n		project 'path of input model' ["
				+ "\n			source = \".\""
				+ "\n			model  = \"" + model.makeRelativeTo(folder).toString() + "\""
				+ "\n		] // end project"
				+ "\n		supervisor {"
				+ "\n			limit 'of graph exploration' ["
				+ "\n				step = -1"
				+ "\n				eval = -1"
				+ "\n			] // end limit"
				+ "\n			queue 'defining the exploration/search strategy' ["
				+ "\n				strategy = 'DEPTH_FIRST_SEARCH'"
				+ "\n			] // end queue"
				+ "\n			redundancy 'detection strategy' ["
				+ "\n				comparer = 'EQUALITY'"
				+ "\n				solver = 'OMEGA'"
				+ "\n				path_scope = 'CURRENT'"
				+ "\n				data_scope = 'ALL'"
				+ "\n			] // end redundancy"
				+ "\n			console ["
				+ "\n				format = \"\\nstep:%1% , context:%2% , height:%3% , width:%4%\\n\""
				+ "\n				report = \"\\nstop:%1% , context:%2% , height:%3% , width:%4%\\n\""
//				+ "\n				spider#init = \"\\n<$spider(%1%:%2%:%3%:%4%)%5%\\n\""
//				+ "\n				spider#step = \"\\n$spider(%1%:%2%:%3%:%4%)%5%\\n\""
//				+ "\n				spider#stop = \"\\n>$spider(%1%:%2%:%3%:%4%)%5%\\n\""
				+ "\n			] // end console"
				+ "\n		}"
				+ "\n		worker ["
				+ "\n		] // end worker"
				+ "\n	}"
				+ "\n	symbex 'option' ["
				+ "\n		name_id_separator = \"_\"   // default \"#\""
				+ "\n		newfresh_param_name_pid = false"
				+ "\n		pretty_printer_var_name = true   // default false"
				+ "\n		time_name_id = '$time'"
				+ "\n		delta_name_id = '$delta'"
				+ "\n		node_condition_enabled = false   // default false"
				+ "\n		separation_of_pc_disjunction = false"
				+ "\n		check_pathcondition_satisfiability = true"
				+ "\n		constraint_solver = 'CVC4'  // Z3"
				+ "\n	] // end symbex"
				+ "\n	console ["
				+ "\n		verbose = 'SILENT'"
				+ "\n	] // end console"
				+ "\n	shell ["
				+ "\n		// Stop stop the current execution if it detects the creation of the above file !"
				+ "\n		stop = \"symbex.stop\""
				+ "\n	] // end shell"
				+ "\n}"
				;

		return sew;
	}


	public static IPath generationSEW(final IPath folder,
			final IPath model, final IPath sewPath)
	{
		try {
			final FileWriter fileWriter = new FileWriter( sewPath.toOSString() );
			final PrintWriter writer = new PrintWriter(fileWriter);

			writer.write( getSEW(folder, model) );

			writer.close();

		} catch (final IOException e) {
			e.printStackTrace();
		}

		return sewPath;
	}


	/*
	 * ANALYSIS PROFILE
	 */
	@Override
	public String getSymbexlAnalysisProfileName() {
		return "LIVENESS CHECKING";
	}


	/*
	 * WORKFLOW
	 */
	@Override
	public boolean isIterable() {
		return true;
	}

	@Override
	public boolean isConsistent() {
		return this.fWellFormednessFlag && super.isConsistent();
	}

	/*
	 * SYMBEX WORKFLOW
	 */
	@Override
	public IPath getSymbexWorkflowPath() {
//		if( hasXliaModel() ) {
//			final IPath sewPath = this.fXliaModels[this.fXliaModelsIndex]
//					.removeFileExtension().addFileExtension("sew");
//
////			final String name = path.lastSegment() + "_livness";
////			sewPath = sewPath.removeLastSegments(1).append(name).addFileExtension("sew");
//		}

		final IPath sewPath = this.fModelsContainer.getLocation()
				.append("polygraph").addFileExtension("sew");

		generationSEW(this.fModelsContainer.getLocation(), getXliaModelPath(), sewPath);

		return sewPath;
	}

	@Override
	public IPath genSymbexWorkflow() {
		final IPath sewPath = getSymbexWorkflowPath();

		generationSEW(this.fModelsContainer.getLocation(), getXliaModelPath(), sewPath);

		return sewPath;
	}

	/*
	 * XLIA MODEL
	 */
	@Override
	public IPath getXliaModelPath() {
		return hasNext() ? super.fXliaModelsPath[super.fIndex] : null;
	}

	/*
	 * COMMAND LINE
	 */
	@Override
	public String[] getCommandLine() {
		return hasWorkflow() ?
				new String[] {
						SymbexPreferenceUtil.strDiversityAvmExecLocation(),
						genSymbexWorkflow().toOSString(),
						SYMBEX_LAUNCH_OPTION_ENABLE_SERVER_MODE,
						SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS
				}
				: null;
	}


	/*
	 * UTILS
	 */
    final static Pattern PATTERN_ACTOR   = Pattern.compile("actor\\s*=\\s*(\\d+)");

    final static Pattern PATTERN_CHANNEL = Pattern.compile("channel\\s*=\\s*(\\d+)");

    final static Pattern PATTERN_TIMED   = Pattern.compile("timed\\s*=\\s*(\\d+)");

    final static Pattern PATTERN_PHASE   = Pattern.compile("phase\\s*=\\s*(\\d+)");

    final static Pattern PATTERN_WELL_FORMED = Pattern.compile("well-formed\\s*=\\s*(\\w+)");

    final static Pattern PATTERN_CONSISTENCY = Pattern.compile("consistency\\s*=\\s*(\\w+)");

    final static Pattern PATTERN_TICKS   = Pattern.compile("tick_period\\s*=\\s*(\\d+)");

    final static Pattern PATTERN_FIRINGS = Pattern.compile("firings\\s*=\\s*(\\d+)");

    final static Pattern PATTERN_XLIA_HEADER = Pattern.compile("@(xlia|fml|xfml|xfsp)\\s*<.+");


	public void loadPolygraphInfo(final IPath xliaModel)
	{
		try {
			final FileReader fileReader = new FileReader( xliaModel.toOSString() );
	        final BufferedReader bufReader = new BufferedReader(fileReader);

            Matcher matcher = null;
	        String line = null;

	        while((line = bufReader.readLine())!= null) {
	        	line = line.trim();

	        	if( line.isEmpty() || line.startsWith("/") || line.startsWith("s") ) {
	        		continue;
	        	}

	            if( (matcher = PATTERN_ACTOR.matcher(line)).find() ) {
	    			this.fActorCount = Integer.parseUnsignedInt( matcher.group(1) );
	            }
	    		else if( (matcher = PATTERN_CHANNEL.matcher(line)).find() ) {
	    			this.fChannelCount = Integer.parseUnsignedInt( matcher.group(1) );
	    		}
	    		else if( (matcher = PATTERN_TIMED.matcher(line)).find() ) {
	    			this.fTimedActorCount = Integer.parseUnsignedInt( matcher.group(1) );
	    		}
	    		else if( (matcher = PATTERN_PHASE.matcher(line)).find() ) {
	    			this.fPhaseActorCount = Integer.parseUnsignedInt( matcher.group(1) );
	    		}

	    		else if( (matcher = PATTERN_WELL_FORMED.matcher(line)).find() ) {
	    			super.fWellFormednessFlag = Boolean.parseBoolean( matcher.group(1) );
	    		}
	    		else if( (matcher = PATTERN_CONSISTENCY.matcher(line)).find() ) {
	    			super.fConsistencyFlag = Boolean.parseBoolean( matcher.group(1) );
	    			if( ! super.fConsistencyFlag ) {
	    				break;
	    			}
	    		}
	    		else if( (matcher = PATTERN_TICKS.matcher(line)).find() ) {
	    			this.fTickCount = Integer.parseUnsignedInt( matcher.group(1) );
	    		}
	    		else if( (matcher = PATTERN_FIRINGS.matcher(line)).find() ) {
	    			this.fFiringCount = Integer.parseUnsignedInt( matcher.group(1) );
	    		}

	            else if( (matcher = PATTERN_XLIA_HEADER.matcher(line)).find() ) {
	    			super.fConsistencyFlag = true;
	    			break;
	            }

	    		else if( line.startsWith("}") ) {
	    			break;
	    		}
	        }

	        bufReader.close();
		}
		catch (final IOException e) {
			e.printStackTrace();
		}
		catch (final NumberFormatException e) {
			e.printStackTrace();
		}
	}


	/*
	 * SYMBEX VERDICT
	 */
	@Override
	public boolean hasVerdict() {
		return true;
	}

	@Override
	public String getVerdict() {
		this.fLivenessFlag =
				(super.fRedundancyCount == fExecutionWidthMax) &&
//				(super.fRedundancyTest  == 1) &&
				(super.fDeadlockCount   == 0) &&
				(super.fRunExitCount    == 0);

		return this.fLivenessFlag ? "LIVE" : "NO";
	}


	/*
	 * INITIALIZE / FINALIZE
	 */
	@Override
	public boolean initialize() {
		collectXliaModels();

		if( super.initialize() )
		{
			try {
				final FileWriter buffer_ALL = new FileWriter( fReportFilePath_ALL.toOSString() );
				fLoggerWriter_ALL = new PrintWriter(buffer_ALL);

				final FileWriter buffer_LIVE = new FileWriter( fReportFilePath_LIVE.toOSString() );
				fLoggerWriter_LIVE = new PrintWriter(buffer_LIVE);

				final FileWriter buffer_NOT = new FileWriter( fReportFilePath_NOT.toOSString() );
				fLoggerWriter_NOT = new PrintWriter(buffer_NOT);
			}
			catch (final IOException e) {
				e.printStackTrace();
				return false;
			}

			logHeader(fLoggerWriter_ALL);
			logHeader(fLoggerWriter_LIVE);
			logHeader(fLoggerWriter_NOT);

			return true;
		}

		return false;
	}

	public void logHeader(final PrintWriter logger) {
		logger.print( "Actor" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Channel" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Frequency" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Phase" );
		logger.print( CSV_SEPARATOR );

		logger.print( "Execution Time" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Liveness" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Firings" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Ticks" );
		logger.print( CSV_SEPARATOR );
		logger.print( "Min-CE" );

		logger.print( CSV_SEPARATOR );
		logger.print( "Filename" );

		logger.println();
		logger.flush();
	}

	@Override
	public void finalize() {
		fLoggerWriter_ALL.println();
		fLoggerWriter_LIVE.println();
		fLoggerWriter_NOT.println();

		fLoggerWriter_ALL.print( "Total : " );
		fLoggerWriter_ALL.println( super.fXliaModelsPath.length );
		fLoggerWriter_ALL.print( "Well-Formed : " );
		fLoggerWriter_ALL.println( this.fWellFormedCount );
		fLoggerWriter_ALL.print( "Consistent : " );
		fLoggerWriter_ALL.println( this.fConsistentCount );
		fLoggerWriter_ALL.print( "Live : " );
		fLoggerWriter_ALL.println( this.fLivenessCount );

		final long notLiveCount = fConsistentCount - fLivenessCount;

		fLoggerWriter_LIVE.print( "Average Execution Time: " );
		fLoggerWriter_LIVE.println( (double)fTotalExecutionTime_LIVE / fLivenessCount );

		fLoggerWriter_NOT.print( "Average Execution Time: " );
		fLoggerWriter_NOT.println( (double)fTotalExecutionTime_NOT / notLiveCount );


		fLoggerWriter_LIVE.print( "Average Tick: " );
		fLoggerWriter_LIVE.println( (double)fTotalTick_LIVE / fLivenessCount );

		fLoggerWriter_NOT.print( "Average Tick: " );
		fLoggerWriter_NOT.println( (double)fTotalTick_NOT / notLiveCount );


		fLoggerWriter_LIVE.print( "Average Firing: " );
		fLoggerWriter_LIVE.println( (double)fTotalFiring_LIVE / fLivenessCount );

		fLoggerWriter_NOT.print( "Average Firing: " );
		fLoggerWriter_NOT.println( (double)fTotalFiring_NOT / notLiveCount );


		fLoggerWriter_LIVE.print( "Average Minimal Consitent Execution (MCE): " );
		fLoggerWriter_LIVE.println( (double)(fTotalFiring_LIVE + fTotalTick_LIVE) / fLivenessCount );


		fLoggerWriter_ALL.close();
		fLoggerWriter_LIVE.close();
		fLoggerWriter_NOT.close();
	}


	/*
	 * LOGGING
	 */
	@Override
	public void beginLoggingSymbex() {
		super.fXliaModelPath = getXliaModelPath();

		resetExecutionStats();

		super.fConsistencyFlag    = false;
		super.fWellFormednessFlag = false;

		this.fLivenessFlag = false;

		loadPolygraphInfo(super.fXliaModelPath);

		System.out.println( getTaskName() );

//		fLoggerWriter.print( fXliaModel.lastSegment() );

	}

	@Override
	public void log(final String message) {
		System.out.print(message);

		fLoggerWriter_ALL.print(message);
	}


	@Override
	public void endLoggingSymbex() {
		System.out.println();

		if( super.fWellFormednessFlag ) {
			++this.fWellFormedCount;
		}
		else {
			System.out.println( " >> MAL-FORMED << " );
		}

		if( super.fConsistencyFlag ) {

			this.fLivenessFlag = (super.fRedundancyCount == fExecutionWidthMax) &&
							(super.fRedundancyTest  == 1) &&
							(super.fDeadlockCount   == 0) &&
							(super.fRunExitCount    == 0);

			++this.fConsistentCount;

			if( this.fLivenessFlag ) {
				++this.fLivenessCount;

				logSymbex( fLoggerWriter_LIVE );

				fTotalTick_LIVE += fTickCount;
				fTotalFiring_LIVE += fFiringCount;
				fTotalExecutionTime_LIVE += super.fExecutionTime;
			}
			else {
				logSymbex( fLoggerWriter_NOT );

				fTotalTick_NOT += super.fExecutionStepCount - 1;
//				fTotalFiring_NOT += fFiringCount;
				fTotalExecutionTime_NOT += super.fExecutionTime;
			}
		}
		else {
			System.out.println( " >> INCONSISTENT << " );
		}

		logSymbex( fLoggerWriter_ALL );
	}


	public void logSymbex(final PrintWriter logger) {
		logger.format( "%5d" , this.fActorCount );
		logger.print( CSV_SEPARATOR );
		logger.format( "%6d" , this.fChannelCount );
		logger.print( CSV_SEPARATOR );
		logger.format( "%10d" , this.fTimedActorCount );
		logger.print( CSV_SEPARATOR );
		logger.format( "%5d" , this.fPhaseActorCount );
		logger.print( CSV_SEPARATOR );

		logger.format( "%11d" , super.fExecutionTime );
		logger.print( " ms" );
		logger.print( CSV_SEPARATOR );



		if( this.fLivenessFlag ) {
			logger.format( "%8s" ,"YES" );
			logger.print( CSV_SEPARATOR );
			logger.format( "%7d" , this.fFiringCount );
			logger.print( CSV_SEPARATOR );
			logger.format( "%5d" , this.fTickCount );
			logger.print( CSV_SEPARATOR );
			logger.format( "%6d" , this.fFiringCount + this.fTickCount );
		}
		else {
			logger.format( "%8s" , super.fWellFormednessFlag ?
					(super.fConsistencyFlag ? "NO" : "INCONS") : "MALFORMED" );
			logger.print( CSV_SEPARATOR );
			logger.format( "%7s" , "_" );
			logger.print( CSV_SEPARATOR );
			logger.format( "%5d" , super.fExecutionStepCount - 1);
			logger.print( CSV_SEPARATOR );
			logger.format( "%6s" , "_" );
		}

		logger.print( CSV_SEPARATOR );
		logger.print( super.fXliaModelPath.lastSegment() );

		logger.println();
		logger.flush();
	}



}
