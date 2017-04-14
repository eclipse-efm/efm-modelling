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
//package org.eclipse.efm.runconfiguration;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.FileLocator;
//import org.eclipse.core.runtime.IPath;
//import org.eclipse.core.runtime.Platform;
//import org.eclipse.debug.core.ILaunchConfiguration;
//import org.eclipse.efm.execution.core.Activator;
//import org.eclipse.efm.core.workflow.IWorkflowConfigurationConstants;
//import org.eclipse.efm.core.workflow.ToolConstants;
//import org.eclipse.efm.runconfiguration.ui.views.page.LaunchExecConsoleManager;
//import org.eclipse.jface.preference.IPreferenceStore;
//import org.osgi.framework.Bundle;
//
//public class WorkflowFAVM implements IWorkflowConfigurationConstants {
//
//	private final String FAVM_TEMPLATE = "resources/sew/template.favm";
//
//	private IPath fFavmLocation;
//	private IPath fWorkingDirectory;
//	private String fAnalysisProfile;
//
//	public static String fModelAnalysis = ANALYSIS_PROFILE_MODEL_UNDEFINED;
//
//	public boolean fEnableTraceExtension;
//
//
//	/**
//	 * LaunchExecConsoleManager
//	 */
//	LaunchExecConsoleManager fConsoleManager;
//
//	boolean fEnabledDebugOrDeveloperMode;
//
//	public WorkflowFAVM() {
//		fFavmLocation = null;
//		fWorkingDirectory = null;
//		fAnalysisProfile = null;
//
//		fConsoleManager = new LaunchExecConsoleManager();
//
//		fEnabledDebugOrDeveloperMode = false;
//
//		fEnableTraceExtension = false;
//	}
//
//	public void configure(ILaunchConfiguration configuration,
//			IPath xorkingDirectory, String favmFilename) {
//		fWorkingDirectory = xorkingDirectory;
//
//		fFavmLocation = fWorkingDirectory.append( favmFilename );
//
//		try {
//			int i;
//
//			fAnalysisProfile = configuration.getAttribute(
//					ATTR_SPECIFICATION_ANALYSIS_PROFILE, ANALYSIS_PROFILE_MODEL);
//
//			fModelAnalysis = configuration.getAttribute(
//					ATTR_SPECIFICATION_MODEL_ANALYSIS,
//					ANALYSIS_PROFILE_MODEL_UNDEFINED);
//
//			Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
//
//			URL url = bundle.getEntry(FAVM_TEMPLATE);
//
//			URL favmTemplateURL = FileLocator.toFileURL(url);
//			InputStream inputTemplate = favmTemplateURL.openStream();
//
//			BufferedReader bufferedTemplate = new BufferedReader(
//					new InputStreamReader (inputTemplate) );
//
//			StringBuffer buffer = new StringBuffer();
//
//			String line = bufferedTemplate.readLine();
//			while( line != null ) {
//				buffer.append(line);
//				buffer.append("\n");
//
//				line = bufferedTemplate.readLine();
//			}
//
//			bufferedTemplate.close();
//
//			String favmString = buffer.toString();
//
//			final String projectLocation = fWorkingDirectory.toString();
//
//			favmString = favmString.replace(
//					"__LOCATION_PROJECT__", projectLocation );
////			System.out.println("__LOCATION_PROJECT__ : " + projectLocation);
//
//			String fModelPath = configuration.getAttribute(
//					ATTR_SPECIFICATION_MODEL_FILE_LOCATION, "");
////			i = fModelPath.lastIndexOf("/");
//			if( fModelPath.startsWith(projectLocation) ) {
//				final boolean endWidthSeparator = (projectLocation.charAt(
//						projectLocation.length() - 1) == IPath.SEPARATOR);
//
//				fModelPath = fModelPath.substring(
//						projectLocation.length() + (endWidthSeparator? 0 : 1) );
//			}
//			favmString = favmString.replace(
//					"__SPECIFICATION_MAIN__", fModelPath );
////			System.out.println("__SPECIFICATION_MAIN__ : " + fModelPath);
//
//			i = configuration.getAttribute(
//					ATTR_SPECIFICATION_STOP_CRITERIA_NODE, -1);
//			favmString = favmString.replace( "__NODE__", Integer.toString(i) );
//
//			i = configuration.getAttribute(
//					ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH, -1);
//			favmString = favmString.replace( "__WIDTH__", Integer.toString(i) );
//
//			i = configuration.getAttribute(
//					ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT, -1);
//			favmString = favmString.replace( "__HEIGHT__", Integer.toString(i) );
//
//			i = configuration.getAttribute(
//					ATTR_SPECIFICATION_STOP_CRITERIA_STEPS, -1);
//			favmString = favmString.replace( "__EVAL__", Integer.toString(i) );
//
//			switch ( fAnalysisProfile ) {
//			case ANALYSIS_PROFILE_MODEL: {
//				switch ( fModelAnalysis ) {
//				case ANALYSIS_PROFILE_MODEL_EXPLORATION: {
//					favmString = favmString.replace(
//							"__EXECUTION_QUEUE_STRATEGY__",
//							configuration.getAttribute(
//									ATTR_SPECIFICATION_ANALYZE_STRATEGY, "") );
//					break;
//				}
//				case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION: {
//					favmString = favmString.replace(
//							"__EXECUTION_QUEUE_STRATEGY__", "WEIGHT_BFS");
//
//					break;
//				}
//				case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR: {
//					String fElementNameListStringField =
//							configuration.getAttribute(
//									ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST, "");
//
//					String[] tabString =
//							fElementNameListStringField.trim().split("\\R|;");
//
//					StringBuffer elementStringList = new StringBuffer();
//					String kind;
//					String object;
//					int pos;
//
//					for (String eltString : tabString) {
//						eltString = eltString.trim();
//
//						if ( eltString.length() == 0 ) {
//						}
//						else if ( eltString.startsWith("//") ) {
//							elementStringList.append("\t\t\t\t\t\t")
//								.append(eltString).append("\n");
//						}
//						else if( (pos = eltString.indexOf('=')) > 0 ) {
//							kind = eltString.substring(0, pos).trim();
//							object = eltString.substring(pos+1).trim();
//
//							if ( kind.equals( "transition" ) ) {
//								// Check if the object is a transition and exists !
//							}
//							else if ( kind.equals( "state" ) ) {
//								// Check if the object is a state and exists !
//							}
//
//							else if ( kind.equals( "input" ) ) {
//								// Check if the object is an input port/signal and exists !
//							}
//							else if ( kind.equals( "output" ) ) {
//								// Check if the object is an output port/signal and exists !
//							}
//
//							else if ( kind.equals( "inout" ) ) {
//								// Check if the object is an inout port/signal and exists !
//							}
//							else if ( kind.equals( "com" ) ) {
//								// Check if the object is a communicated port/signal and exists !
//							}
//
//							// check if the object ID contains space
//							if( object.matches("[^\"'].*\\s+.*[^\"']") ) {
//								object = "\"" + object +  "\"";
//							}
//
//							elementStringList.append("\t\t\t\t\t\t@")
//								.append(kind).append(" = ").append(object).append(";\n");
//						}
//						else {
//							elementStringList.append("\t\t\t\t\t\t@")
//								.append(eltString).append(";\n");
//						}
//					}
//
//					if ( elementStringList.length() > 0 ) {
//						favmString = favmString.replace(
//								"\t\t\t\t\t\t//__ELEMENT_LIST_TO_COVER__",
//								elementStringList);
//					}
//
//					favmString = favmString.replace(
//							"__EXECUTION_QUEUE_STRATEGY__", "WEIGHT_BFS");
//
//					break;
//				}
//				default:
//					favmString = favmString.replace(
//							"__EXECUTION_QUEUE_STRATEGY__",
//							configuration.getAttribute(
//									ATTR_SPECIFICATION_ANALYZE_STRATEGY, "") );
//					break;
//				}
//
//
//				favmString = suppressProcessString(favmString,
//						"//BEGIN_OFFLINE_TEST_PHASE1",
//						"//END_OFFLINE_TEST_PHASE1");
//
//
//				// Filter Redundancy Phase1
//				//
//				favmString = filterRedundancyPhase1(configuration, favmString);
//
//				break;
//			}
//			case ANALYSIS_PROFILE_TEST_OFFLINE: {
//				fModelAnalysis = ANALYSIS_PROFILE_MODEL_UNDEFINED;
//
//				String traceFile = configuration.getAttribute(
//						ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
//						"<DEFAULT trace file>");
//
//				favmString = favmString.replace( "__TRACE_FILE__", traceFile );
//
//				String testPurposeFile = configuration.getAttribute(
//						ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
//						"<test purpose file>");
//				if( testPurposeFile.equals("") || testPurposeFile.equals(
//						"<test purpose file>") ) {
//					favmString = favmString.replace(
//							"@testPurposeFile", "//__@testPurposeFile" );
//				}
//				else{
//					favmString = favmString.replace(
//							"__TEST_PURPOSE_FILE__", testPurposeFile );
//				}
//
//				favmString = favmString.replace(
//						"__EXECUTION_QUEUE_STRATEGY__", "WEIGHT_BFS");
//
//				favmString = favmString.replace(
//						"//__&process::offline_test", "&process::offline_test");
//
//				break;
//			}
//			default:
//				break;
//			}
//
//			// Filter Transition Coverage Phase1
//			//
//			favmString = filterTransitionCoveragePhase1(configuration, favmString);
//
//			// Process HOJ Phase1
//			//
//			favmString = processHOJPhase1(configuration, favmString);
//
//
//			// Graph slicer en phase 2
//			// Non utilisé pour le moment
//			//
//			favmString = suppressProcessString(favmString,
//					"//BEGIN_GRAPH_SLICER_IO_PHASE2",
//					"//END_GRAPH_SLICER_IO_PHASE2");
//
//			// Génération de test au format BASIC
//			//
//			//System.out.println("ATTR_BASIC_TRACE_ENABLED_GENERATION:> " +
//			//		configuration.getAttribute(
//			//				ATTR_BASIC_TRACE_ENABLED_GENERATION, false) );
//			if ( configuration.getAttribute(
//					ATTR_BASIC_TRACE_ENABLED_GENERATION, false) ) {
//				favmString = favmString.replace(
//						"//__&process::BASIC_trace_generator",
//						"&process::BASIC_trace_generator");
//				String fFolderName = configuration.getAttribute(
//						ATTR_BASIC_TRACE_FOLDER_NAME, "Basic");
//				favmString = favmString.replace( "__BASIC_FOLDER_NAME__", fFolderName);
//				String fFileName = configuration.getAttribute(
//						ATTR_BASIC_TRACE_FILE_NAME, "tests.txt");
//				favmString = favmString.replace( "__BASIC_FILE_NAME__", fFileName);
//
//				if ( configuration.getAttribute(ATTR_BASIC_TRACE_ENABLED_NORMALIZATION, true) ) {
//					favmString = favmString.replace(
//							"//__BASIC__@normalize = true;",
//							"@normalize = true;");
//				}
//				else {
//					favmString = favmString.replace(
//							"//__BASIC__@normalize = true;",
//							"@normalize = false;");
//				}
//
//
//				boolean enabled = configuration.getAttribute(
//						ATTR_BASIC_TRACE_TIME_SELECTION, false);
//				if( enabled ) {
//					favmString = favmString.replace(
//							"//__BASIC__@time", "@time");
//				}
//
//				enabled = configuration.getAttribute(
//						ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION, false);
//				if( enabled ) {
//					favmString = favmString.replace(
//							"//__BASIC__@input#env", "@input#env");
//				}
//
//				enabled = configuration.getAttribute(
//						ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION, false);
//				if( enabled ) {
//					favmString = favmString.replace(
//							"//__BASIC__@output#env", "@output#env");
//				}
//
//				enabled = configuration.getAttribute(
//						ATTR_BASIC_TRACE_ALL_INPUT_COM_SELECTION, false);
//				if( enabled ) {
//					favmString = favmString.replace(
//							"//__BASIC__@input", "@input");
//				}
//
//				enabled = configuration.getAttribute(
//						ATTR_BASIC_TRACE_ALL_OUTPUT_COM_SELECTION, false);
//				if( enabled ) {
//					favmString = favmString.replace(
//							"//__BASIC__@output", "@output");
//				}
//
//				enabled = configuration.getAttribute(
//						ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION, false);
//				if( enabled ) {
//					favmString = favmString.replace(
//							"//__BASIC__@variable", "@variable");
//				}
//
//				enabled = configuration.getAttribute(
//						ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION, false);
//				if( enabled ) {
//					favmString = favmString.replace(
//							"//__BASIC__@transition", "@transition");
//				}
//
//				enabled = configuration.getAttribute(
//						ATTR_BASIC_TRACE_ALL_STATE_SELECTION, false);
//				if( enabled ) {
//					favmString = favmString.replace(
//							"//__BASIC__@state", "@state");
//				}
//
//				String detailsTraceList = configuration.getAttribute(
//						ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST, "");
//
//				detailsTraceList = parseFormatTrace(
//						detailsTraceList, "\t\t\t\t\t\t");
//				if( ! detailsTraceList.isEmpty() ) {
//					favmString = favmString.replace(
//							"\t\t\t\t\t\t//__DetailsElementsListToTrace",
//							detailsTraceList);
//				}
//
//
//				favmString = favmString.replace(
//						"__EXECUTION_QUEUE_STRATEGY__", "WEIGHT_BFS");
//			}
//			else {
//				favmString = suppressProcessString(favmString,
//						"//BEGIN_BASIC_TRACE_GENERATOR_PHASE2",
//						"//END_BASIC_TRACE_GENERATOR_PHASE2");
//			}
//
//			// Génération de test au format TTCN
//			//
//			//System.out.println("ATTR_TTCN_ENABLED_GENERATION:> " +
//			//		configuration.getAttribute(ATTR_TTCN_ENABLED_GENERATION, false) );
//			if( configuration.getAttribute(ATTR_TTCN_ENABLED_GENERATION, false) ) {
//				favmString = favmString.replace(
//						"//__&process::TTCN_trace_generator",
//						"&process::TTCN_trace_generator");
//
//				String fFolderName = configuration.getAttribute(
//						ATTR_TTCN_FOLDER_NAME, "");
//				favmString = favmString.replace(
//						"__TTCN_FOLDER_NAME__", fFolderName);
//			}
//			else {
//				favmString = suppressProcessString(favmString,
//						"//BEGIN_TTCN_TRACE_GENERATOR_PHASE2",
//						"//END_TTCN_TRACE_GENERATOR_PHASE2");
//			}
//
//			// PAHSE 2 if required?
//			fEnableTraceExtension = configuration.getAttribute(
//					ATTR_ENABLED_TRACE_EXTENSION, false);
//			if ( fEnableTraceExtension ) {
//				i = configuration.getAttribute(
//						ATTR_TRACE_EXTENSION_EVALUATION_STEPS, -1);
//				favmString = favmString.replace(
//						"__EVAL2__", Integer.toString(i) );
//
//				favmString = favmString.replace(
//						"//__PHASE2_&process::hit_or_jump",
//						"&process::hit_or_jump" );
//
//				favmString = favmString.replace(
//						"//__&engine::io_continuation",
//						"&engine::io_continuation");
//
//
//				String detailsTraceList = configuration.getAttribute(
//						ATTR_TRACE_EXTENSION_OBJECTIVE, "");
//
//				detailsTraceList = parseFormatTrace(
//						detailsTraceList, "\t\t\t\t\t\t");
//
//				if( ! detailsTraceList.isEmpty() ) {
//					favmString = favmString.replace(
//							"\t\t\t\t\t\t//__EXTENSION_OBJECTIVE_TO_REACH__",
//							detailsTraceList);
//				}
//
//			}
//			else if( configuration.getAttribute(
//							ATTR_BASIC_TRACE_ENABLED_GENERATION, false)
//					|| configuration.getAttribute(
//							ATTR_TTCN_ENABLED_GENERATION, false) ) {
//
//				favmString = favmString.replace( "__EVAL2__", "0" );
//
//				favmString = suppressProcessString(favmString,
//						"//BEGIN_HOJ_PHASE2",
//						"//END_HOJ_PHASE2");
//
//				favmString = favmString.replace(
//						"//__&engine::io_continuation",
//						"&engine::io_continuation");
//			}
//			else {
//				favmString = suppressProcessString(favmString,
//						"//BEGIN_IO_CONTINUATION_PHASE2",
//						"//END_IO_CONTINUATION_PHASE2");
//
//				favmString = favmString.replace(
//						"\n\t\t\t//__&engine::io_continuation", "");
//			}
//
//			// Section DEBUG
//			//
//			favmString = modeDebug(configuration, favmString);
//
//			BufferedWriter writer = new BufferedWriter(
//					new FileWriter( fFavmLocation.toFile() ) );
//
//			writer.write(favmString);
//
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private String filterTransitionCoveragePhase1(
//			ILaunchConfiguration configuration, String currentFavmString) {
//		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
//		boolean expertMode = prefs.getBoolean(
//				ToolConstants.PREF_EXPERT_MODE);
//
//		if ( fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL)
//			&& fModelAnalysis.equals(
//					ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) ) {
//			try {
//				boolean enabledTransitionSelection = configuration.getAttribute(
//					ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false);
//
//				if ( enabledTransitionSelection )
//				{
//					currentFavmString = currentFavmString.replace(
//							"__TC1_SCOPE__", "DETAILS");
//
//					List< String > selectedTransitions =
//							configuration.getAttribute(
//									ATTR_TRANSITION_COVERAGE_SELECTION,
//									new ArrayList<String>());
//
//					StringBuffer TransitionStringList = new StringBuffer();
//
//					for (String eltString : selectedTransitions) {
//						TransitionStringList
//							.append( "\t\t\t\t\t\t@transition = \"" )
//							.append(eltString).append( "\";\n" );
//					}
//					currentFavmString = currentFavmString.replace(
//							"\t\t\t\t\t\t//__TC1_TransitionListToCover",
//							TransitionStringList.toString());
//				}
//				else {
//
//				}
//			} catch (CoreException e1) {
//				e1.printStackTrace();
//			}
//
//			// Mise en oeuvre du filtre Transition Coverage
//			//
//			currentFavmString = currentFavmString.replace(
//					"//__PHASE1_&filter::transition_coverage",
//					"&filter::transition_coverage");
//
//			if ( expertMode ) {
//				// Option EXPERT au niveau des préférences
//				// On récupère les informations de la page Transition Coverage de l'onglet Expert
//				//
//				try {
//					int i;
//					boolean b;
//
//					i = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_BEGIN_STEP, 0);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_BEGIN_STEP__", Integer.toString(i) );
//
//					b = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_STOP, true);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_STOP__", Boolean.toString(b) );
//
//					b = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_MINIMIZE, true);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_MINIMIZE__", Boolean.toString(b) );
//
//					b = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_SLICE, true);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_SLICE__", Boolean.toString(b) );
//
//					b = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_HEURISTIC, true);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HEURISTIC__", Boolean.toString(b) );
//
//					currentFavmString = currentFavmString.replace( "__TC1_SCOPE__",
//							configuration.getAttribute(ATTR_TRANSITION_COVERAGE_SCOPE, "MODEL"));
//
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HEURISTIC_START__",
//							configuration.getAttribute(
//									ATTR_TRANSITION_COVERAGE_HEURISTIC_START, "BASIC"));
//
//					i = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_HEURISTIC_TRIALS, -1);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HEURISTIC_TRIALS__", Integer.toString(i) );
//
//					i = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_OBJECTIVE_RATE, 100);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_OBJECTIVE_RATE__", Integer.toString(i) );
//
//					i = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_OBJECTIVE_REST, 0);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_OBJECTIVE_REST__", Integer.toString(i) );
//
//					currentFavmString = currentFavmString.replace(
//							"__TC1_DIRECTIVE_TRACE_HEURISTIC__",
//							configuration.getAttribute(
//									ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC, "SMART"));
//
//					i = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_COUNT_LIMIT, 8);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_DIRECTIVE_TRACE_COUNT_LIMIT__",
//							Integer.toString(i) );
//
//					i = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_SIZE_LIMIT, 8);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_DIRECTIVE_TRACE_SIZE_LIMIT__",
//							Integer.toString(i) );
//
//					i = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_LOOKAHEAD_DEPTH, 7);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_COVERAGE_HEIGHT__", Integer.toString(i) );
//
//					i = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_LOOKAHEAD_WIDTH, 42);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_COVERAGE_HEIGHT_REACHED_LIMIT__",
//							Integer.toString(i) );
//
//					b = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_RANDOM, false);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HIT_STRONGLY_RANDOM__",
//							Boolean.toString(b) );
//
//					i = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_COUNT, 1);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HIT_STRONGLY_COUNT__",
//							Integer.toString(i) );
//
//					b = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_RANDOM, false);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HIT_WEAKLY_RANDOM__",
//							Boolean.toString(b) );
//
//					i = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_COUNT, 1);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HIT_WEAKLY_COUNT__",
//							Integer.toString(i) );
//
//					b = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_HIT_OTHER_RANDOM, false);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HIT_OTHER_RANDOM__",
//							Boolean.toString(b) );
//
//					i = configuration.getAttribute(
//							ATTR_TRANSITION_COVERAGE_HIT_OTHER_COUNT, 1);
//					currentFavmString = currentFavmString.replace(
//							"__TC1_HIT_OTHER_COUNT__",
//							Integer.toString(i) );
//				} catch (CoreException e) {
//					e.printStackTrace();
//				}
//			}
//			else {
//				// Pas d'onglet EXPERT
//				// Le process Transition Coverage est paramétré
//				// avec les valeurs par défaut
//				currentFavmString = currentFavmString.replace(
//						"__TC1_BEGIN_STEP__", "0" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_STOP__", "true" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_MINIMIZE__", "true" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_SLICE__", "true" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HEURISTIC__", "true" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_SCOPE__", "MODEL" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HEURISTIC_START__", "BASIC" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HEURISTIC_TRIALS__", "7" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_OBJECTIVE_RATE__", "100" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_OBJECTIVE_REST__", "0" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_DIRECTIVE_TRACE_HEURISTIC__", "SMART" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_DIRECTIVE_TRACE_COUNT_LIMIT__", "8" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_DIRECTIVE_TRACE_SIZE_LIMIT__", "8" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_COVERAGE_HEIGHT__", "7" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_COVERAGE_HEIGHT_REACHED_LIMIT__", "42" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HIT_STRONGLY_RANDOM__", "false" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HIT_STRONGLY_COUNT__", "1" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HIT_WEAKLY_RANDOM__", "false" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HIT_WEAKLY_COUNT__", "1" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HIT_OTHER_RANDOM__", "false" );
//
//				currentFavmString = currentFavmString.replace(
//						"__TC1_HIT_OTHER_COUNT__", "1" );
//			}
//		}
//		else {
//			// Suppression du filtre Transition Coverage en Phase 1
//			//
//			currentFavmString = suppressProcessString(currentFavmString,
//					"//BEGIN_TRANSITION_COVERAGE_PHASE1",
//					"//END_TRANSITION_COVERAGE_PHASE1");
//		}
//		return currentFavmString;
//	}
//
//	private String filterRedundancyPhase1(
//			ILaunchConfiguration configuration, String currentFavmString) {
//		boolean enableInclusion;
//		try {
//			enableInclusion = configuration.getAttribute(
//					ATTR_ENABLED_INCLUSION_CRITERION, false);
//
//			if ( fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_EXPLORATION)
//				&& enableInclusion ) {
//				currentFavmString = currentFavmString.replace(
//						"//__PHASE1_&filter::redundancy",
//						"&filter::redundancy");
//			}
//			else {
//				// Suppression du filtre Redundancy en Phase 1
//				//
//				currentFavmString = suppressProcessString(currentFavmString,
//						"//BEGIN_REDUNDANCY_PHASE1",
//						"//END_REDUNDANCY_PHASE1");
//			}
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
//
//		return currentFavmString;
//	}
//
//	private String processHOJPhase1(
//			ILaunchConfiguration configuration, String currentFavmString) {
//		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
//		boolean expertMode = prefs.getBoolean(
//				ToolConstants.PREF_EXPERT_MODE);
//
//		if ( fAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL) &&
//			fModelAnalysis.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR)	) {
//			// Mise en oeuvre du process HOJ
//			//
//			currentFavmString = currentFavmString.replace(
//					"//__PHASE1_&process::hit_or_jump",
//					"&process::hit_or_jump");
//
//			if ( expertMode ) {
//				// Option EXPERT au niveau des préférences
//				// On récupère les informations de la page HitOrJump de l'onglet Expert
//				//
//				try {
//					int i;
//					boolean b;
//
//					i = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_BEGIN_STEP, 0);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_BEGIN_STEP__", Integer.toString(i) );
//
//					b = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_HEURISTIC, true);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_HEURISTIC__", Boolean.toString(b) );
//
//					b = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_STOP, true);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_STOP__", Boolean.toString(b) );
//
//					b = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_SLICE, true);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_SLICE__", Boolean.toString(b) );
//
//
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_SEARCH_SCOPE__", configuration.getAttribute(
//								ATTR_BEHAVIOR_SELECTION_HOJ_SEARCH_SCOPE_LOCALLY,
//									false) ? "LOCALLY" : "GLOBALLY" );
//
//					i = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT, 6);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_JUMP_HEIGHT__", Integer.toString(i) );
//
//					i = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT, 2);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_JUMP_LIMIT__", Integer.toString(i) );
//
//					i = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT, 1);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_HIT_COUNT__", Integer.toString(i) );
//
//					b = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE, false);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_HIT_CONSECUTIVE__", Boolean.toString(b) );
//
//					b = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_HIT_MAX, false);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_HIT_MAX__", Boolean.toString(b) );
//
//					i = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT, 1);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_JUMP_COUNT__", Integer.toString(i) );
//
//					b = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_SLICE, false);
//					currentFavmString = currentFavmString.replace(
//							"__HOJ1_JUMP_SLICE__", Boolean.toString(b) );
//
//					b = configuration.getAttribute(
//							ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED, true);
//					currentFavmString = currentFavmString.replace(
//								"__HOJ1_SCHEDULER__", (b ? "|;|" : "|i|") );
//
//				} catch (CoreException e) {
//					e.printStackTrace();
//				}
//			}
//			else {
//				// Pas d'onglet EXPERT
//				// Le process HitOrJump est paramétré avec les valeurs par défaut
//				//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_BEGIN_STEP__", "0" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_HEURISTIC__", "true" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_STOP__", "true" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_SLICE__", "true" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_SEARCH_SCOPE__", "LOCALLY" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_JUMP_HEIGHT__", "6" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_JUMP_LIMIT__", "2" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_HIT_COUNT__", "1" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_HIT_CONSECUTIVE__", "false" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_HIT_MAX__", "false" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_JUMP_COUNT__", "1" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_JUMP_SLICE__", "false" );
//
//				currentFavmString = currentFavmString.replace(
//						"__HOJ1_SCHEDULER__", "|;|" );
//			}
//		}
//		else {
//			// Suppression du process HOJ en Phase 1
//			//
//			currentFavmString = suppressProcessString(currentFavmString,
//					"//BEGIN_HOJ_PHASE1",
//					"//END_HOJ_PHASE1");
//		}
//		return currentFavmString;
//	}
//
//	private String modeDebug(
//			ILaunchConfiguration configuration, String currentFavmString) {
//		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
//
//		boolean debugOptionMode = prefs.getBoolean(
//				ToolConstants.PREF_DEBUG_OPTIONS);
//
//		if ( debugOptionMode ) {
//			// On récupère les informations de l'onglet Debug
//			//
//			try {
//				if( configuration.getAttribute(
//					ATTR_ENABLED_FIRST_PARSED_MODEL_GRAPHVIZ_GENERATION, false) ) {
//					currentFavmString = currentFavmString.replace(
//							"//__@file_statemachine_graph", "@file");
//					currentFavmString = currentFavmString.replace(
//							"//__PHASE1_&processor::serializer#statemachine",
//							"&processor::serializer#statemachine");
//				}
//				else {
//					// Suppression du filtre Serialize Statemachine en Phase 1
//					//
//					currentFavmString = suppressProcessString(currentFavmString,
//							"//BEGIN_SERIALIZER_STATEMACHINE_PHASE1",
//							"//END_SERIALIZER_STATEMACHINE_PHASE1");
//				}
//				if( configuration.getAttribute(
//					ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION, false) ) {
//					currentFavmString = currentFavmString.replace(
//							"//__@file_phase1_execution_graph", "@file");
//					currentFavmString = currentFavmString.replace(
//							"//__PHASE1_&processor::serializer#execution_graph",
//							"&processor::serializer#execution_graph");
//				}
//				else {
//					// Suppression du filtre Serialize Execution Graph en Phase 1
//					//
//					currentFavmString = suppressProcessString(currentFavmString,
//							"//BEGIN_SERIALIZER_EXECUTION_GRAPH_PHASE1",
//							"//END_SERIALIZER_EXECUTION_GRAPH_PHASE1");
//				}
//				if( configuration.getAttribute(
//					ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION, false) ) {
//					currentFavmString = currentFavmString.replace(
//							"//__@file_phase2_execution_graph", "@file");
//
//					currentFavmString = currentFavmString.replace(
//							"//__PHASE2_&processor::serializer#execution_graph",
//							"&processor::serializer#execution_graph");
//				}
//				else if( fEnableTraceExtension ) {
//					// Suppression du filtre Serialize Execution Graph en Phase 2
//					//
//					currentFavmString = suppressProcessString(currentFavmString,
//							"//BEGIN_SERIALIZER_EXECUTION_GRAPH_PHASE2",
//							"//END_SERIALIZER_EXECUTION_GRAPH_PHASE2");
//				}
//
//				currentFavmString = currentFavmString.replace(
//						"__CONSOLE_TRACE_LEVEL__",
//						configuration.getAttribute(
//								ATTR_CONSOLE_LOG_VERBOSE_LEVEL, "MINIMUM"));
//
//				//System.out.println("ATTR_ENABLED_DEVELOPER_TUNING:> " +
//				//		configuration.getAttribute(
////								ATTR_ENABLED_DEVELOPER_TUNING, false) );
//				if ( configuration.getAttribute(
//						ATTR_ENABLED_DEVELOPER_TUNING, false) ) {
//					currentFavmString = currentFavmString.replace(
//							"//__@log =", "@log =");
//
//					currentFavmString = currentFavmString.replace(
//							"__AVM_LOG__",
//							configuration.getAttribute(
//									ATTR_DEVELOPER_TUNING_LOG_FILENAME,
//									"avm.log"));
//
//					currentFavmString = currentFavmString.replace(
//							"//__@debug =", "@debug =");
//
//					currentFavmString = currentFavmString.replace(
//							"__AVM_TRACE__",
//							configuration.getAttribute(
//									ATTR_DEVELOPER_TUNING_DEBUG_FILENAME,
//									"avm.trace"));
//
//					currentFavmString = currentFavmString.replace(
//							"__TRACE_LEVEL__",
//							configuration.getAttribute(
//									ATTR_DEVELOPER_TUNING_DEBUG_LEVEL, "LOW"));
//
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_PARSING, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'PARSING';",
//								"@kind = 'PARSING';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_COMPILING, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'COMPILING';",
//								"@kind = 'COMPILING';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_COMPUTING, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'COMPUTING';",
//								"@kind = 'COMPUTING';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_ALL_PROCESS_STAGE, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'ALL_PROCESS_STAGE';",
//								"@kind = 'ALL_PROCESS_STAGE';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_PROGRAM, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'PROGRAM';",
//								"@kind = 'PROGRAM';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_STATEMENT_ASSIGNMENT, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'STMNT_ASSIGN';",
//								"@kind = 'STMNT_ASSIGN';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_STATEMENT, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'STATEMENT';",
//								"@kind = 'STATEMENT';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_BYTECODE, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'BYTECODE';",
//								"@kind = 'BYTECODE';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_STATEMENT_COMMUNICATION, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'STMNT_COM';",
//								"@kind = 'STMNT_COM';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_SOLVING, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'SOLVING';",
//								"@kind = 'SOLVING';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_DATA, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'DATA';",
//								"@kind = 'DATA';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_REPORTING, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'REPORTING';",
//								"@kind = 'REPORTING';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_CONFIGURING, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'CONFIGURING';",
//								"@kind = 'CONFIGURING';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_REDUNDANCE, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'REDUNDANCE';",
//								"@kind = 'REDUNDANCE';");
//					}
//					if ( configuration.getAttribute(
//							ATTR_ENABLED_TRACE_TRACE, false) ) {
//						currentFavmString = currentFavmString.replace(
//								"//__@kind = 'TRACE';",
//								"@kind = 'TRACE';");
//					}
//				}
//				else {
//					currentFavmString = currentFavmString.replace(
//							"__TRACE_LEVEL__", "ZERO");
//				}
//
//				//System.out.println("ATTR_ENABLED_OUTPUT_FILES_1:> " +
//				//		configuration.getAttribute(ATTR_ENABLED_OUTPUT_FILES_1, false) );
//				if( configuration.getAttribute(
//					ATTR_ENABLED_FIRST_COMPILED_MODEL_TEXTUAL_GENERATION, false) ) {
//					currentFavmString = currentFavmString.replace(
//							"//__PHASE1_@executable =", "@executable =");
//
//					currentFavmString = currentFavmString.replace(
//						"__PHASE1_EXE__",
//						configuration.getAttribute(
//							ATTR_FIRST_COMPILED_MODEL_TEXTUAL_FILENAME,
//							"phase1.fexe"));
//				}
//
//				if( configuration.getAttribute(
//					ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_TEXTUAL_GENERATION, false) ) {
//					currentFavmString = currentFavmString.replace(
//							"//__PHASE1_@scenarii =", "@scenarii =");
//
//					currentFavmString = currentFavmString.replace(
//						"__PHASE1_FSCN__",
//						configuration.getAttribute(
//							ATTR_FIRST_SYMBEX_OUTPUT_TEXTUAL_FILENAME,
//							DEFAULT_FIRST_SYMBEX_OUTPUT_TEXTUAL_FILENAME));
//				}
//
//				//System.out.println("ATTR_ENABLED_OUTPUT_FILES_2:> " +
//				//		configuration.getAttribute(
////								ATTR_ENABLED_OUTPUT_FILES_2, false) );
//				if( configuration.getAttribute(
//					ATTR_ENABLED_SECOND_COMPILED_MODEL_TEXTUAL_GENERATION, false) ) {
//					currentFavmString = currentFavmString.replace(
//							"//__PHASE2_@executable =", "@executable =");
//					currentFavmString = currentFavmString.replace(
//						"__PHASE2_EXE__",
//						configuration.getAttribute(
//							ATTR_ENABLED_SECOND_COMPILED_MODEL_TEXTUAL_GENERATION,
//							"phase2.fexe"));
//				}
//
//				if( configuration.getAttribute(
//					ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_TEXTUAL_GENERATION, false) ) {
//					currentFavmString = currentFavmString.replace(
//							"//__PHASE2_@scenarii =", "@scenarii =");
//
//					currentFavmString = currentFavmString.replace(
//						"__PHASE2_FSCN__",
//						configuration.getAttribute(
//							ATTR_SECOND_SYMBEX_OUTPUT_TEXTUAL_FILENAME,
//							DEFAULT_SECOND_SYMBEX_OUTPUT_TEXTUAL_FILENAME));
//				}
//			} catch (CoreException e) {
//				e.printStackTrace();
//			}
//		}
//		else {
//			// Pas d'option DEBUG au niveau des préférences
//			//
//			currentFavmString = currentFavmString.replace(
//					"__CONSOLE_TRACE_LEVEL__", "MINIMUM");
//
//			currentFavmString = currentFavmString.replace(
//					"__TRACE_LEVEL__", "ZERO");
//		}
//		return currentFavmString;
//	}
//
////	 private static String suppressProcessString(
////			String input, String beginString, String endString){
////		 int firstPos = input.indexOf(beginString) + beginString.length();
////		 int lastPos = input.indexOf(endString);
////		 String result = input.substring(0,firstPos) + "\n" +
////				input.substring(lastPos, input.length());
////		 return result;
////	 }
//
//
//	private static String parseFormatTrace(String traceText, String tab) {
//		String[] traceList = traceText.trim().split(";|\\R");
//		StringBuffer buffer = new StringBuffer();
//		int pos;
//		String kind;
//		String value;
//		for (String element : traceList) {
//			element = element.toString();
//			if( element.isEmpty() ) {
//				continue;
//			}
//			else if( element.startsWith("//") ) {
//				buffer.append( tab )
//					.append( element ).append( "\n" );
//			}
//			else if( (pos = element.indexOf('=')) > 0 ) {
//				kind = element.substring(0, pos).trim();
//				value = element.substring(pos+1).trim();
//
//				buffer.append( tab ).append("@").append( kind ).append(" = ");
//
//				if( value.isEmpty() ) {
//					buffer.append("\"\";\n" );
//				}
//				else if( (value.startsWith("\"") && value.endsWith("\""))
//						|| (value.startsWith("'") && value.endsWith("'")) ) {
//					buffer.append( value ).append( ";\n" );
//				}
//				else {
//					buffer.append("\"").append( value ).append( "\";\n" );
//				}
//			}
//			else {
//				buffer.append( tab ).append("//")
//					.append( element ).append( "\n" );
//			}
//		}
//
//		return buffer.toString();
//	}
//
//
//	 private static String suppressProcessString(
//			 String input, String beginString, String endString){
//		 int firstPos = input.indexOf(beginString);
//		 int lastPos = input.indexOf(endString) + endString.length() + 2;
//		 String result = input.substring(0,firstPos) +
//				 input.substring(lastPos, input.length());
//
//		 return result;
//
////		 int firstPos = input.indexOf(beginString);
////		 if( firstPos > 0 ) {
////			 int lastPos = input.indexOf(endString) + endString.length() + 2;
////			 if( lastPos > firstPos ) {
////				 String result = input.substring(0,firstPos) +
////		 				input.substring(lastPos, input.length());
////				 return result;
////			 }
////		 }
////		 return input;
//	 }
//
//}
