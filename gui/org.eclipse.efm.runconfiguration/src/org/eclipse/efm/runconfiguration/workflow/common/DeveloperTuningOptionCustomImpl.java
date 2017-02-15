/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.runconfiguration.workflow.common;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.runconfiguration.Activator;
import org.eclipse.efm.runconfiguration.LaunchDelegate;
import org.eclipse.efm.runconfiguration.ToolConstants;
import org.eclipse.efm.runconfiguration.workflow.IWorkflowConfigurationConstants;
import org.eclipse.efm.runconfiguration.workflow.common.impl.DeveloperTuningOptionImpl;
import org.eclipse.efm.runconfiguration.workflow.util.PrettyPrintWriter;
import org.eclipse.jface.preference.IPreferenceStore;

public class DeveloperTuningOptionCustomImpl extends DeveloperTuningOptionImpl
		implements IWorkflowConfigurationConstants {



	static boolean fEnabledDebugOptions;

	static boolean fEnabledSymbexDeveloperMode;


	public DeveloperTuningOptionCustomImpl() {
		super();
	}


	public static void setEnabledFlags(
			ILaunchConfiguration configuration) {

		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();

		fEnabledDebugOptions = prefs.getBoolean(
				ToolConstants.PREF_DEBUG_OPTIONS);

		if( LaunchDelegate.ENABLED_SYMBEX_DEVELOPER_MODE_OPTION ) {
			fEnabledSymbexDeveloperMode = prefs.getBoolean(
					ToolConstants.PREF_SYMBEX_DEVELOPER_MODE);
		}
		else {
			fEnabledSymbexDeveloperMode = false;
		}

		if( fEnabledSymbexDeveloperMode ) {
			try {
				fEnabledSymbexDeveloperMode = configuration.getAttribute(
						ATTR_ENABLED_DEVELOPER_TUNING, false);
			} catch( CoreException e ) {
				e.printStackTrace();

//				fEnabledSymbexDeveloperMode = false;
			}
		}
	}


	public static DeveloperTuningOptionCustomImpl createWorkflow(
			ILaunchConfiguration configuration) {

		setEnabledFlags(configuration);

		if( fEnabledSymbexDeveloperMode ) {
			DeveloperTuningOptionCustomImpl devTuning =
					new DeveloperTuningOptionCustomImpl();

			String str;

			try {
				str = configuration.getAttribute(
						ATTR_DEVELOPER_TUNING_LOG_FILENAME,
						DEFAULT_DEVELOPER_TUNING_LOG_FILENAME);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_DEVELOPER_TUNING_LOG_FILENAME;
			}
			devTuning.setLogTraceFilename( str );

			try {
				str = configuration.getAttribute(
						ATTR_DEVELOPER_TUNING_DEBUG_FILENAME,
						DEFAULT_DEVELOPER_TUNING_DEBUG_FILENAME);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_DEVELOPER_TUNING_DEBUG_FILENAME;
			}
			devTuning.setDebugTraceFilename( str );

			try {
				str = configuration.getAttribute(
						ATTR_DEVELOPER_TUNING_DEBUG_LEVEL, "ZERO");
			} catch( CoreException e ) {
				e.printStackTrace();

				str = "ZERO";
			}
			DebuglevelKind debugLevel = DebuglevelKind.get( str );
			if( debugLevel == null ) {
				debugLevel = DebuglevelKind.ZERO;
			}
			devTuning.setDebugLevel( debugLevel );

			devTuning.configureTuningOption( configuration );

			return( devTuning );
		}

		return( null );
	}


	public boolean configureTuningOption(ILaunchConfiguration configuration) {
		boolean enabled;

		// General Context
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_PARSING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledParsing( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_CONFIGURING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledConfiguring( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_COMPILING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledCompiling( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_LOADING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledLoading( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_COMPUTING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledComputing( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_REPORTING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledReporting( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_SOLVING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledSolver( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_PROFILING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledProfiling( enabled );

		// Symbex Process
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_ALL_PROCESS_STAGE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledAllProcessStage( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_PRE_PROCESSING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledPreProcessing( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_POST_PROCESSING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledPostProcessing( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_PROCESSING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledProcessing( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_PRE_FILTERING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledPreFiltering( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_POST_FILTERING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledPostFiltering( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_FILTERING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledFiltering( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_QUEUE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledQueue( enabled );

		// Statement Evaluation
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_PROGRAM, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledProgram( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_STATEMENT, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledStatement( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_STATEMENT_ASSIGNMENT, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledStatementAssignment( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_STATEMENT_COMMUNICATION, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledStatementCommunication( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_STATEMENT_TEST_DECISION, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledStatementTestDecision( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_BYTECODE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledBytecode( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_DATA, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledData( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_TRACE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledTrace( enabled );
		// Element
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_VARIABLE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledVariable( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_BUFFER, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledBuffer( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_PORT, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledPort( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_SIGNAL, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledSignal( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_CONNEXION, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledConnexion( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_TIME, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledTime( enabled );

		// Component
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_EXECUTABLE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledExecutable( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_ACTIVITY, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledActivity( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_ROUTINE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledRoutine( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_TRANSITION, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledTransition( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_MACHINE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledMachine( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_STATEMACHINE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledStatemachine( enabled );

		// Qualified Name Identifier
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_NAME_ID, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledNameId( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_QUALIFIED_NAME_ID, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledQualifiedNameId( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_FULLY_QUALIFIED_NAME_ID, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledFullyQualifiedNameId( enabled );

		// Various
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_REDUNDANCE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledRedundance( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_REFERENCE_COUNTING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledReferenceCounting( enabled );


		// Nothing
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_NOTHING, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledNothing( enabled );

		// God Mode
		try {
			enabled = configuration.getAttribute(
					ATTR_ENABLED_TRACE_GOD_MODE, false);
		}
		catch( CoreException e ) {
			enabled = false;
		}
		setEnabledGodMode( enabled );

		return( true );
	}



	public static String getModelFilename(ILaunchConfiguration configuration) {
		String modelPath;
		try {
			modelPath = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_FILE_LOCATION, "");
		}
		catch (CoreException e) {
			e.printStackTrace();

			modelPath = null;
		}

		if( (modelPath != null) && (! modelPath.isEmpty()) ) {
			int pos = modelPath.lastIndexOf(IPath.SEPARATOR);
			if( pos > 0 ) {
				modelPath = modelPath.substring(pos+1);
			}

			pos = modelPath.lastIndexOf('.');
			if( pos > 0 ) {
				modelPath = modelPath.substring(0, pos);
			}

			return( modelPath );
		}

		return( null );
	}

	public static DeveloperTuningOptionCustomImpl createDirector(
			ILaunchConfiguration configuration) {

		setEnabledFlags(configuration);

		if( fEnabledDebugOptions || fEnabledSymbexDeveloperMode ) {

			DeveloperTuningOptionCustomImpl devTuning =
					new DeveloperTuningOptionCustomImpl();

			devTuning.setDebugLevel( DebuglevelKind.NONE );

			boolean enabled;

			String modelFilename = getModelFilename(configuration);

			try {
				enabled = configuration.getAttribute(
					ATTR_ENABLED_FIRST_PARSED_MODEL_TEXTUAL_GENERATION, false);
			} catch( CoreException e ) {
				e.printStackTrace();

				enabled = false;
			}
			if( enabled ) {
				devTuning.setOutputFilename(modelFilename + "_%1%");
				devTuning.setSpecificationFilename(modelFilename + ".xlia");

				if( fEnabledSymbexDeveloperMode ) {
					devTuning.setDebugFilename(modelFilename + "_%1%");

					devTuning.setParsedModelFilename(
							modelFilename + "_parsed.xlia");
				}
			}

			try {
				enabled = configuration.getAttribute(
					ATTR_ENABLED_FIRST_COMPILED_MODEL_TEXTUAL_GENERATION, false);
			} catch( CoreException e ) {
				e.printStackTrace();

				enabled = false;
			}
			if( enabled ) {
				devTuning.setExecutableFilename(modelFilename + ".fexe");

				if( fEnabledSymbexDeveloperMode ) {
					devTuning.setCompiledModelFilename(
							modelFilename + "_compiled.fexe");
				}
			}

			try {
				enabled = configuration.getAttribute(
					ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_TEXTUAL_GENERATION, false);
			} catch( CoreException e ) {
				e.printStackTrace();

				enabled = false;
			}
			if( enabled ) {
				devTuning.setSymbexGraphFilename(modelFilename + ".fscn");

				if( fEnabledSymbexDeveloperMode ) {
					devTuning.setSymbexTraceFilename(modelFilename + ".fet");
				}
			}

			return( devTuning );
		}

		return( null );
	}


	public static DeveloperTuningOptionCustomImpl createSecondDirector(
			ILaunchConfiguration configuration) {

		setEnabledFlags(configuration);

		if( fEnabledDebugOptions || fEnabledSymbexDeveloperMode ) {

			DeveloperTuningOptionCustomImpl devTuning =
					new DeveloperTuningOptionCustomImpl();

			devTuning.setDebugLevel( DebuglevelKind.NONE );

			boolean enabled;

			String modelFilename = getModelFilename(configuration);

			try {
				enabled = configuration.getAttribute(
					ATTR_ENABLED_SECOND_PARSED_MODEL_TEXTUAL_GENERATION, false);
			} catch( CoreException e ) {
				e.printStackTrace();

				enabled = false;
			}

			if( enabled ) {
				devTuning.setOutputFilename(modelFilename + "_%1%");
				devTuning.setSpecificationFilename(modelFilename + ".xlia");

				if( fEnabledSymbexDeveloperMode ) {
					devTuning.setDebugFilename(modelFilename + "_%1%");

					devTuning.setParsedModelFilename(
							modelFilename + "_parsed.xlia");
				}
			}

			try {
				enabled = configuration.getAttribute(
					ATTR_ENABLED_SECOND_COMPILED_MODEL_TEXTUAL_GENERATION, false);
			} catch( CoreException e ) {
				e.printStackTrace();

				enabled = false;
			}
			if( enabled ) {
				devTuning.setExecutableFilename(modelFilename + ".fexe");

				if( fEnabledSymbexDeveloperMode ) {
					devTuning.setCompiledModelFilename(
							modelFilename + "_compiled.fexe");
				}
			}

			try {
				enabled = configuration.getAttribute(
					ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_TEXTUAL_GENERATION, false);
			} catch( CoreException e ) {
				e.printStackTrace();

				enabled = false;
			}
			if( enabled ) {
				devTuning.setSymbexGraphFilename(
						modelFilename + "_extension.fscn");

				if( fEnabledSymbexDeveloperMode ) {
					devTuning.setSymbexTraceFilename(
							modelFilename + "_extension.fet");
				}
			}

			return( devTuning );
		}

		return( null );
	}


	public void toWriter(PrettyPrintWriter writer) {
		// Output Files
		String strOutputFilename = getOutputFilename();
		String strSpecificationFilename = getSpecificationFilename();
		String strExecutableFilename = getExecutableFilename();
		String strScenariiFilename = getSymbexGraphFilename();

		if( (strOutputFilename != null)
			|| (strSpecificationFilename != null)
			|| (strExecutableFilename != null)
			|| (strScenariiFilename != null) ) {

			writer.appendTabEol( "output 'standard analysis file' [" );

			if( strOutputFilename != null ) {
				writer.appendTab2( "filename = '" )
						.append( strOutputFilename ).appendEol( "'" );
			}

			if( strSpecificationFilename != null ) {
				writer.appendTab2( "specification = '" )
						.append( strSpecificationFilename ).appendEol( "'" );
			}

			if( strExecutableFilename != null ) {
				writer.appendTab2( "executable = '" )
						.append( strExecutableFilename ).appendEol( "'" );
			}

			if( strScenariiFilename != null ) {
				writer.appendTab2( "scenarii = '" )
						.append( strScenariiFilename ).appendEol( "'" );
			}

			writer.appendTabEol( "] // end output" );
		}

		// Developer Files
		String strDebugFilename = getDebugFilename();
		String strParsedFilename = getParsedModelFilename();
		String strCompiledFilename = getCompiledModelFilename();
		String strExecutedFilename = getSymbexTraceFilename();

		if( (strDebugFilename != null)
			|| (strParsedFilename != null)
			|| (strCompiledFilename != null)
			|| (strExecutedFilename != null) ) {

			writer.appendTabEol( "debug 'analysis file at different stage' [" );

			if( strDebugFilename != null ) {
				writer.appendTab2( "filename = '" )
						.append( strDebugFilename ).appendEol( "'" );
			}

			if( strParsedFilename != null ) {
				writer.appendTab2( "parsing = '" )
						.append( strParsedFilename ).appendEol( "'" );
			}

			if( strCompiledFilename != null ) {
				writer.appendTab2( "compilation = '" )
						.append( strCompiledFilename ).appendEol( "'" );
			}

			if( strExecutedFilename != null ) {
				writer.appendTab2( "execution = '" )
						.append( strExecutedFilename ).appendEol( "'" );
			}

			writer.appendTabEol( "] // end debug" );
		}

		// Developer Traces
		String strLogTraceFilename = getLogTraceFilename();
		String strDebugTraceFilename = getDebugTraceFilename();
		DebuglevelKind debugLevel = getDebugLevel();

		if( (strLogTraceFilename != null)
			|| (strDebugTraceFilename != null)
			|| (debugLevel != DebuglevelKind.NONE) ) {

			writer.appendTabEol( "developer 'tuning options' [" );

			if( strLogTraceFilename != null ) {
				writer.appendTab2( "log   = '" )
					.append( strLogTraceFilename ).appendEol( "'" );
			}

			if( strDebugTraceFilename != null ) {
				writer.appendTab2( "debug = '" )
					.append( strDebugTraceFilename ).appendEol( "'" );
			}

			// ZERO < LOW < MEDIUM < HIGH < ULTRA
			if( debugLevel != DebuglevelKind.NONE ) {
				writer.appendTab2( "level = '")
					.append( debugLevel.getLiteral() ).appendEol( "'" );

				// God Mode
				boolean enabledGodMode = isEnabledGodMode();
				if( enabledGodMode && (debugLevel != DebuglevelKind.ZERO) ) {
					writer.appendTab2Eol("// Enable all debug trace flags");
					writer.appendTab2Eol( "flag = 'GOD_MODE'" );
				}

				boolean enabledNothing = isEnabledNothing();
				if( enabledNothing && (! enabledGodMode)
					&& (debugLevel != DebuglevelKind.ZERO) ) {

					writer.appendTab2Eol("// Disable all debug trace flags");
					writer.appendTab2Eol( "flag = 'NOTHING'" );
				}

				if( (! enabledGodMode) && (! enabledNothing)
					&& (debugLevel != DebuglevelKind.ZERO) ) {
					writer.appendTab2Eol("// Enable debug trace flags");

					// General Context
					if( isEnabledParsing() ) {
						writer.appendTab2Eol( "flag = 'PARSING'" );
					}

					if( isEnabledConfiguring() ) {
						writer.appendTab2Eol( "flag = 'CONFIGURE'" );
					}

					if( isEnabledCompiling() ) {
						writer.appendTab2Eol( "flag = 'COMPILING'" );
					}

					if( isEnabledLoading() ) {
						writer.appendTab2Eol( "flag = 'LOADING'" );
					}

					if( isEnabledComputing() ) {
						writer.appendTab2Eol( "flag = 'COMPUTING'" );
					}

					if( isEnabledReporting() ) {
						writer.appendTab2Eol( "flag = 'REPORTING'" );
					}

					if( isEnabledSolver() ) {
						writer.appendTab2Eol( "flag = 'SOLVER'" );
					}

					if( isEnabledProfiling() ) {
						writer.appendTab2Eol( "flag = 'PROFILING'" );
					}

					// Symbex Process
					if( isEnabledAllProcessStage() ) {
						writer.appendTab2Eol( "flag = 'ALL_PROCESS_STAGE'" );
					}

					if( isEnabledPreProcessing() ) {
						writer.appendTab2Eol( "flag = 'PRE_PROCESSING'" );
					}

					if( isEnabledPostProcessing() ) {
						writer.appendTab2Eol( "flag = 'POST_PROCESSING'" );
					}

					if( isEnabledProcessing() ) {
						writer.appendTab2Eol( "flag = 'PROCESSING'" );
					}

					if( isEnabledPreFiltering() ) {
						writer.appendTab2Eol( "flag = 'PRE_FILTERING'" );
					}

					if( isEnabledPostFiltering() ) {
						writer.appendTab2Eol( "flag = 'POST_FILTERING'" );
					}

					if( isEnabledFiltering() ) {
						writer.appendTab2Eol( "flag = 'FILTERING'" );
					}

					if( isEnabledQueue() ) {
						writer.appendTab2Eol( "flag = 'QUEUE'" );
					}

					// Statement Evaluation
					if( isEnabledProgram() ) {
						writer.appendTab2Eol( "flag = 'PROGRAM'" );
					}

					if( isEnabledStatement() ) {
						writer.appendTab2Eol( "flag = 'STATEMENT'" );
					}

					if( isEnabledStatementAssignment() ) {
						writer.appendTab2Eol( "flag = 'STATEMENT_ASSIGNMENT'" );
					}

					if( isEnabledStatementCommunication() ) {
						writer.appendTab2Eol( "flag = 'STATEMENT_COMMUNICATION'" );
					}

					if( isEnabledStatementTestDecision() ) {
						writer.appendTab2Eol( "flag = 'STATEMENT_TEST_DECISION'" );
					}

					if( isEnabledBytecode() ) {
						writer.appendTab2Eol( "flag = 'BYTECODE'" );
					}

					if( isEnabledData() ) {
						writer.appendTab2Eol( "flag = 'DATA'" );
					}

					if( isEnabledTrace() ) {
						writer.appendTab2Eol( "flag = 'TRACE'" );
					}
					// Element
					if( isEnabledVariable() ) {
						writer.appendTab2Eol( "flag = 'VARIABLE'" );
					}

					if( isEnabledBuffer() ) {
						writer.appendTab2Eol( "flag = 'BUFFER'" );
					}

					if( isEnabledPort() ) {
						writer.appendTab2Eol( "flag = 'PORT'" );
					}

					if( isEnabledSignal() ) {
						writer.appendTab2Eol( "flag = 'SIGNAL'" );
					}

					if( isEnabledConnexion() ) {
						writer.appendTab2Eol( "flag = 'CONNEXION'" );
					}

					if( isEnabledTime() ) {
						writer.appendTab2Eol( "flag = 'TIME'" );
					}

					// Component
					if( isEnabledExecutable() ) {
						writer.appendTab2Eol( "flag = 'EXECUTABLE'" );
					}

					if( isEnabledRoutine() ) {
						writer.appendTab2Eol( "flag = 'ROUTINE'" );
					}

					if( isEnabledTransition() ) {
						writer.appendTab2Eol( "flag = 'TRANSITION'" );
					}

					if( isEnabledActivity() ) {
						writer.appendTab2Eol( "flag = 'ACTIVITY'" );
					}

					if( isEnabledMachine() ) {
						writer.appendTab2Eol( "flag = 'MACHINE'" );
					}

					if( isEnabledStatemachine() ) {
						writer.appendTab2Eol( "flag = 'STATEMACHINE'" );
					}

					// Qualified Name Identifier
					if( isEnabledNameId() ) {
						writer.appendTab2Eol( "flag = 'NAME_ID'" );
					}

					if( isEnabledQualifiedNameId() ) {
						writer.appendTab2Eol( "flag = 'QUALIFIED_NAME_ID'" );
					}

					if( isEnabledFullyQualifiedNameId() ) {
						writer.appendTab2Eol(
								"flag = 'FULLY_QUALIFIED_NAME_ID'" );
					}

					// Various
					if( isEnabledRedundance() ) {
						writer.appendTab2Eol( "flag = 'REDUNDANCE'" );
					}

					if( isEnabledReferenceCounting() ) {
						writer.appendTab2Eol( "flag = 'REFERENCE_COUNTING'" );
					}
				}
			}

			writer.appendTabEol( "] // end developer" );
		}
	}


}
