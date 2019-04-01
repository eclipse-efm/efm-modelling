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
package org.eclipse.efm.execution.core;

import java.util.Arrays;
import java.util.List;

public interface IWorkflowConfigurationConstants extends IWorkflowConfigurationSyntax {

	/**
	 * Constant for the empty {@link String}
	 *
	 * @since org.eclipse.efm.runconfiguration 1.0.100
	 */
	public static final String EMPTY_STRING = ""; //$NON-NLS-1$


	public final String WORKSPACE_SELECTION_DIALOG =
			Activator.PLUGIN_ID + ".WORKSPACE_SELECTION_DIALOG"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// LAUNCH CONFIGURATION PLUGIN PREFIX ID
	////////////////////////////////////////////////////////////////////////////

	public final String PLUGIN_LAUNCH_ID = Activator.PLUGIN_ID; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// SYMBEX / DIVERSITY : RUNTIME LOCATION
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_LAUNCH_AVM_LOCATION_USED_DEFAULT =
			PLUGIN_LAUNCH_ID + ".ATTR_LAUNCH_AVM_LOCATION_USED_DEFAULT"; //$NON-NLS-1$

	public static final String ATTR_LAUNCH_AVM_LOCATION =
			PLUGIN_LAUNCH_ID + ".ATTR_LAUNCH_AVM_LOCATION"; //$NON-NLS-1$

	public static final String ATTR_LAUNCH_AVM_LOCATION_HISTORY =
			PLUGIN_LAUNCH_ID + ".ATTR_LAUNCH_AVM_LOCATION_HISTORY"; //$NON-NLS-1$


	public static final String ATTR_LAUNCH_PROJECT_IS_USED =
			PLUGIN_LAUNCH_ID + ".ATTR_LAUNCH_PROJECT_IS_USED"; //$NON-NLS-1$



	/**
	 * String attribute containing the arguments that should be passed to the
	 * tool. Default value is <code>null</code>, and encoding is tool specific.
	 */
	public static final String ATTR_TOOL_ARGUMENTS =
			PLUGIN_LAUNCH_ID + ".ATTR_TOOL_ARGUMENTS"; //$NON-NLS-1$

	/**
	 * String attribute identifying the working directory of an external tool.
	 * Default value is <code>null</code>, which indicates a default working
	 * directory, which is tool specific.
	 */
	public static final String ATTR_WORKING_DIRECTORY =
			PLUGIN_LAUNCH_ID + ".ATTR_WORKING_DIRECTORY"; //$NON-NLS-1$

////////////////////////////////////////////////////////////////////////////
	// PROJECT: MODEL SPECIFICATION a.k.a. MAIN INPUT FILE LOCATION
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_SPECIFICATION_PROJECT_LOCATION =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_PROJECT_LOCATION"; //$NON-NLS-1$

	public static final String DEFAULT_SPECIFICATION_PROJECT_LOCATION =
			"<project-location>"; //$NON-NLS-1$


	public static final String ATTR_SPECIFICATION_PROJECT_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_PROJECT_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_SPECIFICATION_PROJECT_NAME =
			"<project-name>"; //$NON-NLS-1$


	public static final String ATTR_SPECIFICATION_MODEL_FILE_LOCATION =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_MODEL_FILE_LOCATION"; //$NON-NLS-1$

	public static final String DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION =
			"<spec-model-file-location.xlia>"; //$NON-NLS-1$

	public static final String ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// PROJECT: MODEL SPECIFICATION a.k.a. MAIN INPUT FILE LOCATION
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_WORKSPACE_ROOT_LOCATION =
			PLUGIN_LAUNCH_ID + ".ATTR_WORKSPACE_ROOT_LOCATION"; //$NON-NLS-1$

	public static final String DEFAULT_WORKSPACE_ROOT_LOCATION =
			"<workspace-root-folder-location>"; //$NON-NLS-1$

	public static final String ATTR_WORKSPACE_OUTPUT_FOLDER_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_WORKSPACE_OUTPUT_FOLDER_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME =
			"output"; //$NON-NLS-1$


	public static final String ATTR_WORKSPACE_LOG_FOLDER_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_WORKSPACE_LOG_FOLDER_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_WORKSPACE_LOG_FOLDER_NAME =
			"log"; //$NON-NLS-1$


	public static final String ATTR_WORKSPACE_DEBUG_FOLDER_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_WORKSPACE_DEBUG_FOLDER_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME =
			"debug"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// SUPERVISOR: GRAPH EXPLORATION LIMIT a.k.a. STOP CRITERIA
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_SPECIFICATION_STOP_CRITERIA_NODE =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_STOP_CRITERIA_NODE"; //$NON-NLS-1$

	public static final String ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH"; //$NON-NLS-1$

	public static final String ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT"; //$NON-NLS-1$

	public static final String ATTR_SPECIFICATION_STOP_CRITERIA_STEPS =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_STOP_CRITERIA_STEPS"; //$NON-NLS-1$

	public static final String ATTR_SPECIFICATION_STOP_CRITERIA_EVALS =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_STOP_CRITERIA_EVALS"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// SUPERVISOR: TIME EXPLORATION LIMIT a.k.a. TIMEOUT
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_STOP_CRITERIA_TIMEOUT"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// SUPERVISOR: GRAPH SEARCH (QUEUE) STRATEGY a.k.a. ANALYSE STRATEGY
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_SPECIFICATION_ANALYZE_STRATEGY =
			PLUGIN_LAUNCH_ID + ".ATTR_SPECIFICATION_ANALYZE_STRATEGY"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// SUPERVISOR: REDUNDANCY DETECTOR a.k.a. INCLUSION CRITERION
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_ENABLED_REDUNDANCY_DETECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_REDUNDANCY_DETECTION"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_REDUNDANCY_TRIVIAL_LOOP_DETECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_REDUNDANCY_TRIVIAL_LOOP_DETECTION"; //$NON-NLS-1$


	public static final String ATTR_REDUNDANCY_COMPARER_OPERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_REDUNDANCY_COMPARER_OPERATION"; //$NON-NLS-1$

	public static final String ATTR_REDUNDANCY_PATH_SCOPE =
			PLUGIN_LAUNCH_ID + ".ATTR_REDUNDANCY_PATH_SCOPE"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// TRANSITION COVERAGE WORKER:  a.k.a. ALL | DETAILS
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_TRANSITION_COVERAGE_SCOPE =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_SCOPE"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_SELECTION"; //$NON-NLS-1$

	////////////////////////////////////////////////////////////////////////////
	// TRANSITION COVERAGE WORKER:  a.k.a. TRANSITION COVERAGE PROPERTY
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_TRANSITION_COVERAGE_BEGIN_STEP =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_BEGIN_STEP"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_STOP =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_STOP"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_MINIMIZE =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_MINIMIZE"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_SLICE =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_SLICE"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_HEURISTIC =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HEURISTIC"; //$NON-NLS-1$

	////////////////////////////////////////////////////////////////////////////
	// TRANSITION COVERAGE WORKER:  a.k.a. TRANSITION COVERAGE HEURISTIC
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_TRANSITION_COVERAGE_HEURISTIC_START =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HEURISTIC_START"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_HEURISTIC_TRIALS =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HEURISTIC_TRIALS"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_OBJECTIVE_RATE =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_OBJECTIVE_RATE"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_OBJECTIVE_REST =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_OBJECTIVE_REST"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_COUNT_LIMIT =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_COUNT_LIMIT"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_SIZE_LIMIT =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_SIZE_LIMIT"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_LOOKAHEAD_DEPTH =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_LOOKAHEAD_DEPTH"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_LOOKAHEAD_WIDTH =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_LOOKAHEAD_WIDTH"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_RANDOM =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_RANDOM"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_COUNT =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_COUNT"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_RANDOM =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_RANDOM"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_COUNT =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_COUNT"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_HIT_OTHER_RANDOM =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HIT_OTHER_RANDOM"; //$NON-NLS-1$

	public static final String ATTR_TRANSITION_COVERAGE_HIT_OTHER_COUNT =
			PLUGIN_LAUNCH_ID + ".ATTR_TRANSITION_COVERAGE_HIT_OTHER_COUNT"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// BEHAVIOR COVERAGE WORKER:  a.k.a. HIT OR JUMP PROPERTY
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_BEGIN_STEP =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_BEGIN_STEP"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_HEURISTIC =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_HEURISTIC"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_STOP =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_STOP"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_SLICE =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_SLICE"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_SEARCH_SCOPE_LOCALLY =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_SEARCH_SCOPE_LOCALLY"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_HIT_FOLDING =
			PLUGIN_LAUNCH_ID + ".ATTR_HIT_FOLDING"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_HIT_LUCKY =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_HIT_LUCKY"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_HIT_MAX =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_HIT_MAX"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_SLICE =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_SLICE"; //$NON-NLS-1$



	////////////////////////////////////////////////////////////////////////////
	// BEHAVIOR COVERAGE WORKER:  a.k.a. HIT OR JUMP HEURISTIC
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT"; //$NON-NLS-1$

	public static final int DEFAULT_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT = 6;

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT"; //$NON-NLS-1$

	public static final String ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT =
			PLUGIN_LAUNCH_ID + ".ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// TEST OFFLINE WORKER: CONFIGURATION a.k.a. INPUT FILE LOCATION
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION =
			PLUGIN_LAUNCH_ID + ".ATTR_TRACE_FILE_LOCATION"; //$NON-NLS-1$

	public static final String DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION =
			"<merge-trace-file-path>"; //$NON-NLS-1$

	public static final String ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION =
			PLUGIN_LAUNCH_ID + ".ATTR_TEST_PURPOSE_FILE_LOCATION"; //$NON-NLS-1$

	public static final String DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION =
			"<test-purpose-file-path>"; //$NON-NLS-1$

	public static final String ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION =
			PLUGIN_LAUNCH_ID + ".ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION"; //$NON-NLS-1$



	public static final String ATTR_TEST_OFFLINE_OBSERVABLE_SPECIFICATION =
			PLUGIN_LAUNCH_ID + ".ATTR_TEST_OFFLINE_OBSERVABLE_TRACE"; //$NON-NLS-1$

	public static final List<String> DEFAULT_TEST_OFFLINE_OBSERVABLE_SPECIFICATION
			= Arrays.asList(
					"//[*] , use for ANY element w.r.t. the kind",
					"//com_element_id ::= <port_name_id> | <signal_name_id>",
					"input#env = [*]",
					"output#env = [*]"
			);


	public static final String ATTR_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION =
			PLUGIN_LAUNCH_ID + ".ATTR_TEST_OFFLINE_CONTROLLABLE_TRACE"; //$NON-NLS-1$

	public static final List<String> DEFAULT_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION
			= Arrays.asList(
					"input#env = [*]"
			);


	////////////////////////////////////////////////////////////////////////////
	// INFERENCE WORKER: CONFIGURATION a.k.a. OUTPUT FILE LOCATION
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_INFERENCE_ANALYSIS_ELEMENT_NAME_LIST =
			PLUGIN_LAUNCH_ID + ".ATTR_INFERENCE_ANALYSIS_ELEMENT_NAME_LIST"; //$NON-NLS-1$

	public static final String ATTR_INFERENCE_SELECTION_HOJ_JUMP_HEIGHT =
			PLUGIN_LAUNCH_ID + ".ATTR_INFERENCE_SELECTION_HOJ_JUMP_HEIGHT"; //$NON-NLS-1$


	public static final String ATTR_INFERENCE_OUTPUT_FILE_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_INFERENCE_OUTPUT_FILE_NAME"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// EXTRANEOUS OPAQUE MODULE as EXTRA WORKER: CONFIGURATION a.k.a. RAW USER TEXT
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_OPAQUE_MODULE_TEXTUAL_CONFIGURATION =
			PLUGIN_LAUNCH_ID + ".ATTR_OPAQUE_MODULE_TEXTUAL_CONFIGURATION"; //$NON-NLS-1$

	public static final String DEFAULT_OPAQUE_MODULE_TEXTUAL_CONFIGURATION
			= "// a sample of incubation worker workflow textual configuration\n"
			+ "//incubation#worker  new_incubation_worker {\n"
			+ "//\tproperty [\n"
			+ "//\t\tattribute#bool = true\n"
			+ "//\t\tattribute#integert = 42\n"
			+ "//\t\tattribute#string = \"string value\"\n"
			+ "//\t] // end property\n"
			+ "//} // end new_incubation_worker\n";  //$NON-NLS-1$

	public static final String ATTR_OPAQUE_MODULE_ENABLED_AS_ADDITIONAL_WORKER =
			PLUGIN_LAUNCH_ID + ".ATTR_OPAQUE_MODULE_ENABLED_AS_ADDITIONAL_WORKER"; //$NON-NLS-1$

	public static final boolean DEFAULT_OPAQUE_MODULE_ENABLED_AS_ADDITIONAL_WORKER = false;


	////////////////////////////////////////////////////////////////////////////
	// TEST GENERATION WORKER :  a.k.a.
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_ENABLED_TRACE_EXTENSION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_EXTENSION"; //$NON-NLS-1$

	public static final String ATTR_TRACE_EXTENSION_EVALUATION_STEPS =
			PLUGIN_LAUNCH_ID + ".ATTR_TRACE_EXTENSION_EVALUATION_STEPS"; //$NON-NLS-1$

	public static final String ATTR_TRACE_EXTENSION_OBJECTIVE =
			PLUGIN_LAUNCH_ID + ".ATTR_TRACE_EXTENSION_OBJECTIVE"; //$NON-NLS-1$

	public static final List<String> DEFAULT_TRACE_EXTENSION_OBJECTIVE
			= Arrays.asList(
					SYNTAX_TRACE_SPECIFICATION_LINK,
					"output#env = [*]"
			);


	public static final String ATTR_BASIC_TRACE_ENABLED_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ENABLED_GENERATION"; //$NON-NLS-1$

	public static final boolean DEFAULT_BASIC_TRACE_ENABLED_GENERATION = false;


	public static final String ATTR_BASIC_TRACE_LIFELINES_ENABLED_PRINTING =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_LIFELINES_TRACE_ENABLED_PRINTING"; //$NON-NLS-1$

	public static final boolean DEFAULT_BASIC_TRACE_LIFELINES_ENABLED_PRINTING = false;


	public static final String DEFAULT_BASIC_TRACE_FOLDER_NAME =
			"basic"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRACE_FOLDER_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_FOLDER_NAME"; //$NON-NLS-1$


	public static final String ATTR_BASIC_TRACE_FILE_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_FILE_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_BASIC_TRACE_FILE_NAME =
			"testcases.txt"; //$NON-NLS-1$


	public static final String ATTR_BASIC_TRACE_ENABLED_NORMALIZATION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ELIMINATION_REDUNDANCE"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRACE_INITIAL_VALUES_ENABLED_PRINTING =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_INITIAL_VALUES_ENABLED_PRINTING"; //$NON-NLS-1$


	public static final String ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION"; //$NON-NLS-1$


	public static final String ATTR_BASIC_TRACE_ALL_INTERNAL_INPUT_COM_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_INTERNAL_INPUT_COM_SELECTION"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRACE_ALL_INTERNAL_OUTPUT_COM_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_INTERNAL_OUTPUT_COM_SELECTION"; //$NON-NLS-1$


	public static final String ATTR_BASIC_TRACE_ALL_INPUT_COM_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_INPUT_COM_SELECTION"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRACE_ALL_OUTPUT_COM_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_IOUTPUT_COM_SELECTION"; //$NON-NLS-1$


	public static final String ATTR_BASIC_TRACE_TIME_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_TIME_SELECTION"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRACE_ALL_STATE_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_ALL_STATE_SELECTION"; //$NON-NLS-1$


	public static final String ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST"; //$NON-NLS-1$

	public static final List<String> DEFAULT_BASIC_TRACE_DETAILS_ELEMENT_LIST
			= Arrays.asList(
					SYNTAX_TRACE_SPECIFICATION_LINK
			);


	public static final String ATTR_BASIC_TRACE_FORMAT_ELEMENT_LIST =
			PLUGIN_LAUNCH_ID + ".ATTR_BASIC_TRACE_FORMAT_ELEMENT_LIST"; //$NON-NLS-1$

	public static final List<String> DEFAULT_BASIC_TRACE_FORMAT_ELEMENT_LIST
			= Arrays.asList(
//					%1% --> string message
//					%2% --> execution context identifier
					"step#header = step %1% --> %2%\\n",
					"comment = \\t// %1%\\n",
//					%1% --> condition,
					"path#condition = \\tPC: %1%\\n",
					"path#timed#condition = \\tPtC: %1%\\n",
					"node#condition = \\tNC: %1%\\n",
					"node#timed#condition = \\tNtC: %1%\\n",
//					%1% --> machine runtime pid
//					%2% --> machine identifier name
//					%3% --> port | signal | variable | machine | transition | routine
//					%4% --> value
//					%5% --> machine target identifier name
					"time       = \\tdelta = %4%\\n",
//					"assign     = \\t2%:%3%=%4%\\n",
					"assign     = \\t%3%=%4%\\n",
					"newfresh   = \\tnewfresh(%2%:%3%) <- %4%\\n",

					"input#env  = \\tINPUT  %2%:%3%%4%\\n",
					"input#rdv  = \\tinput  %2%:%3%%4%\\n",
					"input      = \\tinput  %2%:%3%%4%\\n",
//					"input      = \\t%2%->%3% ? %4%\\n",
					"output#env = \\tOUTPUT %2%:%3%%4%\\n",
					"output#rdv = \\toutput %2%:%3%%4%\\n",
					"output     = \\toutput %2%:%3%%4%\\n",

					"routine    = \\tinvoke %2%:%3%\\n",
					"transition = \\tfired %1%:%3%\\n",

					"machine    = \\trun %2%:%3%\\n",

					"value#parameter#begin = \"(\"",
					"value#parameter#separator = \" , \"",
					"value#parameter#end = \")\""
			);


	// TTCN Tests Generation
	public static final String ATTR_TTCN_ENABLED_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_ENABLED_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_TTCN_ENABLED_CUSTOMIZATION =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_ENABLED_CUSTOMIZATION"; //$NON-NLS-1$

	public static final boolean DEFAULT_TTCN_ENABLED_CUSTOMIZATION = false;


	public static final String ATTR_TTCN_FOLDER_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_FOLDER_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_FOLDER_NAME =
			"TTCN"; //$NON-NLS-1$


	public static final List<String> DEFAULT_TTCN_TRACE_SPECIFICATION
			= Arrays.asList(
					SYNTAX_TRACE_SPECIFICATION_LINK,
					"input#env  = [*]\n",
					"output#env = [*]\n"
			);




	public static final String ATTR_TTCN_CONTROL_MODULE_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_CONTROL_MODULE_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_CONTROL_MODULE_NAME =
			"TTCN_ControlPart"; //$NON-NLS-1$


	public static final String ATTR_TTCN_DECLARATIONS_MODULE_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_DECLARATIONS_MODULE_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_DECLARATIONS_MODULE_NAME =
			"TTCN_Declarations"; //$NON-NLS-1$


	public static final String ATTR_TTCN_TEMPLATES_MODULE_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TEMPLATES_MODULE_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TEMPLATE_MODULE_NAME =
			"TTCN_Templates"; //$NON-NLS-1$


	public static final String ATTR_TTCN_TESTCASES_MODULE_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TESTCASES_MODULE_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TESTCASES_MODULE_NAME =
			"TTCN_TestsAndControl"; //$NON-NLS-1$


	public static final String ATTR_TTCN_TESTCASES_STARTING_WRAPPER =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TESTCASES_STARTING_WRAPPER"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TESTCASES_STARTING_WRAPPER =
//			%1% --> <system identifier>
			"\t\tf_start();"; //$NON-NLS-1$


	public static final String ATTR_TTCN_TESTCASES_ENDING_WRAPPER =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TESTCASES_ENDING_WRAPPER"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TESTCASES_ENDING_WRAPPER =
//			%1% --> <system identifier>
			"\t\tf_end();"; //$NON-NLS-1$


	public static final String ATTR_TTCN_TESTCASES_SENDING_WRAPPER =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TESTCASES_SENDING_WRAPPER"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TESTCASES_SENDING_WRAPPER =
			"\t\t%7%_send( %8% );";

//	%1% --> <port name id>
//	%2% --> <container/lifeline/component name id>
//	%3% --> <system name id>
//	%4% --> <environment channel id>
//	%5% --> <message type name id>
//	%6% --> <port type name id>
//	%7% --> <port instance name id>
//	%8% --> <port parameters template message>

	public static final String ATTR_TTCN_TESTCASES_RECEIVING_WRAPPER =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TESTCASES_RECEIVING_WRAPPER"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TESTCASES_RECEIVING_WRAPPER =
			"\t\t%7%_receive( %8% );";


	public static final String ATTR_TTCN_ADAPTATION_MODULE_NAME =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_ADAPTATION_MODULE_NAME"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_ADAPTATION_MODULE_NAME =
			"TTCN_Adaptation"; //$NON-NLS-1$


	public static final String ATTR_TTCN_ADAPTATION_UTILS_IMPL =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_ADAPTATION_UTILS_IMPL"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_ADAPTATION_UTILS_IMPL
			= "\t// A testcase could just call the function below, "
					+ "when it needs to wait for a timeout."
			+ "\n\t// In case the user wants he can activated "
					+ "altsteps in 'f_start()' to catch events"
			+ "\n\t// during this time period"

			+ "\n\tfunction f_waitForTimeout(float p_duration) {"
			+ "\n\t\ttimer t;"
			+ "\n\t\tt.start(p_duration);"
			+ "\n\t\tt.timeout;"
			+ "\n\t}";  //$NON-NLS-1$


	public static final String ATTR_TTCN_TESTCASES_STARTING_ENDING_IMPL =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TESTCASES_STARTING_ENDING_IMPL"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TESTCASES_STARTING_ENDING_IMPL
//			%1% --> <system identifier>
			= "\tfunction f_start() runs on runsOn_%1% { }" //$NON-NLS-1$
			+ "\n\tfunction f_end() runs on runsOn_%1% { }"; //$NON-NLS-1$


	public static final String ATTR_TTCN_TESTCASES_SENDING_IMPL =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TESTCASES_SENDING_IMPL"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TESTCASES_SENDING_IMPL
			= "\tfunction %1%_send( template %5% pdu ) runs on runsOn_%3% {"
			+ "\n\t\t%7%.send( %5% );"
			+ "\n\t}"; //$NON-NLS-1$

//	%1% --> <port name id>
//	%2% --> <container/lifeline/component name id>
//	%3% --> <system name id>
//	%4% --> <environment channel id>
//	%5% --> <message type name id>
//	%6% --> <port type name id>
//	%7% --> <port instance name id>
//	%8% --> <port parameters template message>

	public static final String ATTR_TTCN_TESTCASES_RECEIVING_IMPL =
			PLUGIN_LAUNCH_ID + ".ATTR_TTCN_TESTCASES_RECEIVING_IMPL"; //$NON-NLS-1$

	public static final String DEFAULT_TTCN_TESTCASES_RECEIVING_IMPL
			= "\tfunction %1%_receive( template %5% pdu ) runs on runsOn_%3% {"
			+ "\n\t\t%7%.receive( %5% );"
			+ "\n\t}"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// DEBUG:  a.k.a.
	////////////////////////////////////////////////////////////////////////////

	// Console Log
	public static final String ATTR_CONSOLE_LOG_VERBOSE_LEVEL =
			PLUGIN_LAUNCH_ID + ".ATTR_CONSOLE_LOG_VERBOSE_LEVEL"; //$NON-NLS-1$

	// First Symbex Workflow Page
	public static final String ATTR_ENABLED_FIRST_PARSED_MODEL_TEXTUAL_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_FIRST_PARSED_MODEL_TEXTUAL_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_FIRST_PARSED_MODEL_TEXTUAL_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_FIRST_PARSED_MODEL_TEXTUAL_FILENAME"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_FIRST_PARSED_MODEL_GRAPHVIZ_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_FIRST_PARSED_MODEL_GRAPHVIZ_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_FIRST_PARSED_MODEL_GRAPHVIZ_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_FIRST_PARSED_MODEL_GRAPHVIZ_FILENAME"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_FIRST_COMPILED_MODEL_TEXTUAL_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_FIRST_COMPILED_MODEL_TEXTUAL_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_FIRST_COMPILED_MODEL_TEXTUAL_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_FIRST_COMPILED_MODEL_TEXTUAL_FILENAME"; //$NON-NLS-1$


	public static final String ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_TEXTUAL_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_TEXTUAL_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_FIRST_SYMBEX_OUTPUT_TEXTUAL_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_FIRST_SYMBEX_OUTPUT_TEXTUAL_FILENAME"; //$NON-NLS-1$

	public static final String DEFAULT_FIRST_SYMBEX_OUTPUT_TEXTUAL_FILENAME =
			"symbex_output.fscn"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME"; //$NON-NLS-1$

	public static final String DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME =
			"symbex_output.gv"; //$NON-NLS-1$


	public static final String ATTR_SYMBEX_OUTPUT_GRAPHVIZ_ENABLED_MODIFIED_DATA_SELECTION =
			PLUGIN_LAUNCH_ID + ".ATTR_SYMBEX_OUTPUT_GRAPHVIZ_ENABLED_MODIFIED_DATA_SELECTION"; //$NON-NLS-1$

	public static final String ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC =
			PLUGIN_LAUNCH_ID + ".ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC"; //$NON-NLS-1$

	public static final List<String> DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC
			= Arrays.asList(
					SYNTAX_TRACE_SPECIFICATION_LINK,
					"transition = [*]\n",
					"com = [*]\n",
					"variable = [*]\n"
			);


	public static final String ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC =
			PLUGIN_LAUNCH_ID + ".ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC"; //$NON-NLS-1$

	public static final List<String> DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC
			= Arrays.asList(
					// %1% --> node#id
					// %2% --> node#label
					// %3% --> node#css
					// %4% --> node#data
					// %5% --> node#info
					// %6% --> node#trace#run
					// %7% --> node#trace#io
					"node = \\nEC%1% [%2%%3%\\n]",
//					"node#context = \\nEC%1% [%2%%3%\\n]%4%",
					// %1% --> node#id
					// %2% --> node#header
					// %3% --> node#data
					// %4% --> node#info
					// %5% --> node#trace#run
					// %6% --> node#trace#io
					"node#label = \\n\\tlabel=\"%2%%3%%4%\"",
//					"node#label = \\n\\tlabel=%2%%4%",
					// %1% --> ec#id
					// %2% --> ec#eval
					// %3% --> ec#hight
					// %4% --> ec#width
					// %5% --> ec#weight
					// %6% --> statemachine configuration i.e. lifelines state identifier
					"node#header = EC#%1%<Ev:%2% , H:%3%>\\n%6%",
					 // %1% --> ec#id
					 // %2% --> ec#assign
					 // %3% --> ec#path#condition
					 // %4% --> ec#path#timed#condition
					 // %5% --> ec#node#condition
					 // %6% --> ec#node#timed#condition
					 // %7% --> ec#node#buffer
					"node#data = \\n\\n%3%%4%%5%%6%%2%%7%",
//					"node#data = \\nEC%1% -> ED%1%\\nED%1% "
//					+ "[\\n\\tlabel=\"%3%%4%%5%%6%%2%%7%\"\\n\\tshape=box\\n]",
					// %1% --> lifeline runtime pid
					// %2% --> lifeline identifier
					// %3% --> state runtime pid
					// %3% --> state identifier
					"lifeline#state = %2%:%4%",
					// %1% --> condition
					"path#condition = PC: %1%",
					"path#timed#condition = PtC: %1%",
					"node#condition = NC: %1%",
					"node#timed#condition = NtC: %1%",
					// %1% --> machine runtime pid
					// %2% --> machine identifier name
					// %3% --> port | signal | variable | machine | transition | routine
					// %4% --> value
//					 "assign     = %2%:%3%=%4%",
					"assign     = %3%=%4%",
					"newfresh   = newfresh(%2%:%3%) <- %4%",

					"input#env  = INPUT %2%:%3%%4%",
					"input#rdv  = input %2%:%3%%4%",
					"input      = input %2%:%3%%4%",
//					"input      = %1%->%3% ? %4%",

					"output#env = OUTPUT %2%:%3%%4%",
					"output#rdv = output %2%:%3%%4%",
					"output     = output %2%:%3%%4%",
//					"output     = %1%->%3% ? %4%",

					"routine    = invoke %2%:%3%",
					"transition = fired %1%.%3%",

					"machine    = run %2%:%3%"
			);

	public static final String ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_CSS_SPEC =
			PLUGIN_LAUNCH_ID + ".ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_CSS_SPEC"; //$NON-NLS-1$

	public static final List<String> DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_CSS_SPEC
			// Node color / shape
			= Arrays.asList(
					"node#color = 'lightblue'",
					"node#shape = 'ellipse'",
					"node#style = 'filled'",

					"node#passed#color = 'yellow'",
					"node#passed#shape = 'ellipse'",
					"node#passed#style = 'filled'",

					"node#failed#color = 'red'",
					"node#failed#shape = 'doubleoctagon'",
					"node#failed#style = 'filled'",

					"node#inconclusive#color = 'orange'",
					"node#inconclusive#shape = 'octagon'",
					"node#inconclusive#style = 'filled'",

					"node#aborted#color = 'red'",
					"node#aborted#shape = 'octagon'",
					"node#aborted#style = 'filled'",

					"node#warning#color = 'orange'",
					"node#warning#shape = 'ellipse'",
					"node#warning#style = 'filled'",

					"node#error#color = 'red'",
					"node#error#shape = 'ellipse'",
					"node#error#style = 'filled'",

					"node#alert#color = 'red'",
					"node#alert#shape = 'ellipse'",
					"node#alert#style = 'filled'",

					"node#exit#color = 'orange'",
					"node#exit#shape = 'tripleoctagon'",
					"node#exit#style = 'filled'",

					"node#redundancy#source#color = 'green'",
					"node#redundancy#source#shape = 'cds'",
					"node#redundancy#source#style = 'filled'",

					"node#redundancy#target#color = 'greenyellow'",
					"node#redundancy#target#shape = 'septagon'",
					"node#redundancy#target#style = 'filled'",

					// Path color / shape
					"path#passed#color = 'lawngreen'",
					"path#passed#shape = 'tripleoctagon'",
					"path#passed#style = 'filled'",

					"path#failed#color = 'red'",
					"path#failed#shape = 'doubleoctagon'",
					"path#failed#style = 'filled'",

					"path#inconclusive#color = 'orange'",
					"path#inconclusive#shape = 'octagon'",
					"path#inconclusive#style = 'filled'",

					"path#aborted#color = 'red'",
					"path#aborted#shape = 'octagon'",
					"path#aborted#style = 'filled'"
			);


	// Second Symbex Workflow Page
	public static final String ATTR_ENABLED_SECOND_PARSED_MODEL_TEXTUAL_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_SECOND_PARSED_MODEL_TEXTUAL_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_SECOND_PARSED_MODEL_TEXTUAL_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_SECOND_PARSED_MODEL_TEXTUAL_FILENAME"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_SECOND_PARSED_MODEL_GRAPHVIZ_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_SECOND_PARSED_MODEL_GRAPHVIZ_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_SECOND_PARSED_MODEL_GRAPHVIZ_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_SECOND_PARSED_MODEL_GRAPHVIZ_FILENAME"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_SECOND_COMPILED_MODEL_TEXTUAL_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_SECOND_COMPILED_MODEL_TEXTUAL_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_SECOND_COMPILED_MODEL_TEXTUAL_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_SECOND_COMPILED_MODEL_TEXTUAL_FILENAME"; //$NON-NLS-1$


	public static final String ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_TEXTUAL_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_TEXTUAL_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_SECOND_SYMBEX_OUTPUT_TEXTUAL_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_SECOND_SYMBEX_OUTPUT_TEXTUAL_FILENAME"; //$NON-NLS-1$

	public static final String DEFAULT_SECOND_SYMBEX_OUTPUT_TEXTUAL_FILENAME =
			"symbex_output_extension.fscn"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION"; //$NON-NLS-1$

	public static final String ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME"; //$NON-NLS-1$

	public static final String DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME =
			"symbex_output_extension.gv"; //$NON-NLS-1$


	public static final String ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC =
			PLUGIN_LAUNCH_ID + ".ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC"; //$NON-NLS-1$

	public static final List<String> DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC
			= Arrays.asList(
					SYNTAX_TRACE_SPECIFICATION_LINK,
					"com = [*]\n"
			);


	public static final String ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC"; //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// DEVELOPER:  a.k.a. SYMBEX TUNING OPTION
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_ENABLED_DEVELOPER_TUNING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_DEVELOPER_TUNING"; //$NON-NLS-1$


	public static final String ATTR_DEVELOPER_TUNING_LOG_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_DEVELOPER_TUNING_LOG_FILENAME"; //$NON-NLS-1$

	public static final String DEFAULT_DEVELOPER_TUNING_LOG_FILENAME =
			"symbex.log"; //$NON-NLS-1$

	public static final String ATTR_DEVELOPER_TUNING_DEBUG_FILENAME =
			PLUGIN_LAUNCH_ID + ".ATTR_DEVELOPER_TUNING_DEBUG_FILENAME"; //$NON-NLS-1$

	public static final String DEFAULT_DEVELOPER_TUNING_DEBUG_FILENAME =
			"symbex.dbg"; //$NON-NLS-1$


	public static final String ATTR_DEVELOPER_TUNING_DEBUG_LEVEL =
			PLUGIN_LAUNCH_ID + ".ATTR_DEVELOPER_TUNING_DEBUG_LEVEL"; //$NON-NLS-1$


	// General Context
	public static final String ATTR_ENABLED_TRACE_PARSING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_PARSING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_CONFIGURING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_CONFIGURING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_COMPILING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_COMPILING"; //$NON-NLS-1$


	public static final String ATTR_ENABLED_TRACE_LOADING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_LOADING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_COMPUTING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_COMPUTING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_REPORTING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_REPORTING"; //$NON-NLS-1$


	public static final String ATTR_ENABLED_TRACE_SOLVING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_SOLVING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_PROFILING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_PROFILING"; //$NON-NLS-1$

	// Process Stage: Processing, Filtering, ...
	public static final String ATTR_ENABLED_TRACE_ALL_PROCESS_STAGE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_ALL_PROCESS_STAGE"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_PRE_PROCESSING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_PRE_PROCESSING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_POST_PROCESSING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_POST_PROCESSING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_PROCESSING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_PROCESSING"; //$NON-NLS-1$


	public static final String ATTR_ENABLED_TRACE_PRE_FILTERING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_PRE_FILTERING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_POST_FILTERING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_POST_FILTERING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_FILTERING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_FILTERING"; //$NON-NLS-1$


	public static final String ATTR_ENABLED_TRACE_QUEUE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_QUEUE"; //$NON-NLS-1$

	// Statement Evaluation
	public static final String ATTR_ENABLED_TRACE_PROGRAM =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_PROGRAM"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_STATEMENT =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_STATEMENT"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_STATEMENT_ASSIGNMENT =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_STATEMENT_ASSIGNMENT"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_STATEMENT_COMMUNICATION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_STATEMENT_COMMUNICATION"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_STATEMENT_TEST_DECISION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_STATEMENT_TEST_DECISION"; //$NON-NLS-1$


	public static final String ATTR_ENABLED_TRACE_BYTECODE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_BYTECODE"; //$NON-NLS-1$
	public static final String ATTR_ENABLED_TRACE_DATA =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_DATA"; //$NON-NLS-1$
	public static final String ATTR_ENABLED_TRACE_TRACE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_TRACE"; //$NON-NLS-1$

	// Element: Property, Signal...
	public static final String ATTR_ENABLED_TRACE_VARIABLE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_VARIABLE"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_BUFFER =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_BUFFER"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_PORT =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_PORT"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_SIGNAL =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_SIGNAL"; //$NON-NLS-1$


	public static final String ATTR_ENABLED_TRACE_CONNEXION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_CONNEXION"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_TIME =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_TIME"; //$NON-NLS-1$

	// Executable Component...
	public static final String ATTR_ENABLED_TRACE_EXECUTABLE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_EXECUTABLE"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_ACTIVITY =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_ACTIVITY"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_ROUTINE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_ROUTINE"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_TRANSITION =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_TRANSITION"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_MACHINE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_MACHINE"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_STATEMACHINE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_STATEMACHINE"; //$NON-NLS-1$

	// Others: [Qualified]NameID, RefCount, ...
	public static final String ATTR_ENABLED_TRACE_NAME_ID =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_NAME_ID"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_QUALIFIED_NAME_ID =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_QUALIFIED_NAME_ID"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_FULLY_QUALIFIED_NAME_ID =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_FULLY_QUALIFIED_NAME_ID"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_REDUNDANCE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_REDUNDANCE"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_REFERENCE_COUNTING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_REFERENCE_COUNTING"; //$NON-NLS-1$

	public static final String ATTR_ENABLED_TRACE_NOTHING =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_NOTHING"; //$NON-NLS-1$

	// God Mode
	public static final String ATTR_ENABLED_TRACE_GOD_MODE =
			PLUGIN_LAUNCH_ID + ".ATTR_ENABLED_TRACE_GOD_MODE"; //$NON-NLS-1$



	////////////////////////////////////////////////////////////////////////////
	// NON-REFRESSION:  a.k.a.
	////////////////////////////////////////////////////////////////////////////

	public static final String ATTR_ENABLED_NON_REGRESSION =
			Activator.PLUGIN_ID + ".ATTR_ENABLED_NON_REGRESSION"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRANSITION_BUTTON =
			Activator.PLUGIN_ID + ".ATTR_BASIC_TRANSITION_BUTTON"; //$NON-NLS-1$

	public static final String ATTR_SELECTED_TRANSITIONS =
			Activator.PLUGIN_ID + ".ATTR_SELECTED_TRANSITIONS"; //$NON-NLS-1$



}
