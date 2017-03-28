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
package org.eclipse.efm.core.workflow;

public interface IWorkflowConfigurationSyntax {

	////////////////////////////////////////////////////////////////////////////
	// HELPERS for BEHAVIOR SELECTION ANALYSIS
	///////////////////////////////////////////////////////////////////////////

	public static final String BEHAVIOR_DESCRIPTION
			= "Select a list of elements to characterize the behavior to be find."
			+ "\nThe list can be a set of following elements:"
			+ "\n\t- transition =\"a transition name\""
			+ "\n\t- state  =\"a state name\""
			+ "\n\t- input  =\"an input name used in a statement\""
			+ "\n\t- output =\"an output name used in a statement\""
			+ "\n\t- com =\"a com (input or output) name used in a statement\""
			+ "\nAll items must be separated by newline or semicolon.";

	public static final String BEHAVIOR_INITIAL_SAMPLE
			= "// Sequence of elements (separated by newline or semicolon) "
			+ "\ncharacterizing the desired behavior."
			+ "\n// The elements of the sequence may be selected from:"
			+ "\ntransition =\"<transition-name-id>\""
			+ "\nstate  =\"<state-name-id>\""
			+ "\ninput  =\"<input-port-or-signal-name-id>\""
			+ "\ninout  =\"<inout-port-or-signal-name-id>\""
			+ "\noutput =\"<output-port-or-signal-name-id>\""
			+ "\ncom =\"<input-or-output-port-or-signal-name-id>\"";
		//	+ "\nformula=\"<predicat-expression-on-variable>\"";


	////////////////////////////////////////////////////////////////////////////
	// HELPERS for TEST OFFLINE ANALYSIS
	///////////////////////////////////////////////////////////////////////////

	public static final String TEST_OFFLINE_OBSERVABLE
			= "Selection of Observable Element";

	public static final String TEST_OFFLINE_CONTROLLABLE
			= "Selection of Controllable Element";


	////////////////////////////////////////////////////////////////////////////
	// TRACE SPECIFICATION
	////////////////////////////////////////////////////////////////////////////

	public static final String SYNTAX_TRACE_SPECIFICATION
			= "\n## Trace Specification"
			+ "\n- [*] , use for ANY element"
			+ "\n- com_element_id ::= <port_name_id> | <signal_name_id>"

			+ "\n- com = <com_element_id>"

			+ "\n- input = <com_element_id>"
			+ "\n- output = <com_element_id>"

			+ "\n- input#env = <com_element_id>"
			+ "\n- output#env = <com_element_id>"
			+ "\n"
			+ "\n- variable = <variable_name_id>"
			+ "\n- newfresh = <variable_name_id>"

			+ "\n- state = <state_name_id>"
			+ "\n- transition = <transition_name_id>"
			+ "\n- statemachine = <statemachine_name_id>";


	public static final String SYNTAX_TRACE_SPECIFICATION_LINK
			= "// See full grammar of [Trace Specification] "
			+ "at the end of this generated file";


	////////////////////////////////////////////////////////////////////////////
	// AD'HOC FORMAT SPECIFICATION
	////////////////////////////////////////////////////////////////////////////

	public static final String SYNTAX_TRACE_FORMAT_SPECIFICATION
			= "\n## Trace Format Specification"
			+ "\n- line#wrap#width = 80"
			+ "\n- line#wrap#separator = \"\\n\\\t\""
			+ "\n"
			+ "\n// %1% --> ec#id"
			+ "\n// %2% --> ec#eval"
			+ "\n// %3% --> ec#hight"
			+ "\n// %4% --> ec#width"
			+ "\n// %5% --> ec#weight"
			+ "\n// %6% --> statemachine configuration i.e. control node"
			+ "\n- context#ufid = \"ctx< %1% > %6%\""
			+ "\n"
			+ "\n// %1% --> trace number"
			+ "\n// %2% --> execution context leaf identifier"
			+ "\n- header = \"TRACE NUMBER %1%\""
			+ "\n- end    = \"\""
			+ "\n- init#begin = \"\\t// Initialization parameter values:\""
			+ "\n- init#end   = \"\\n\""
			+ "\n"
			+ "\n// %1% --> string message"
			+ "\n// %2% --> execution context identifier"
			+ "\n- comment   = \"//%1%\""
			+ "\n- separator = \"%1%\""
			+ "\n- newline   = \"\\n%1%\""
			+ "\n"
			+ "\n// %1% --> step identifier"
			+ "\n// %2% --> execution context identifier"
			+ "\n- step#begin = \"\\t#step#begin %1%\""
			+ "\n- step#end   = \"\\t#step#end %1%\""
			+ "\n"
			+ "\n// %1% --> condition"
			+ "\n// %2% --> execution context identifier"
			+ "\n- path#condition = \"\\tPC: %1%\""
			+ "\n- path#timed#condition = \"\\tPtC: %1%\""
			+ "\n- node#condition = \"\\tNC: %1%\""
			+ "\n- node#timed#condition = \"\\tNtC: %1%\""
			+ "\n"
			+ "\n// %1% --> machine runtime pid"
			+ "\n// %2% --> machine container identifier"
			+ "\n// %3% --> port | signal | variable | machine | transition | routine"
			+ "\n// %4% --> value"

			+ "\n- time   = \"\\t%4%\""

			+ "\n- assign = \"\\t%2%:%3% = %4%\""

			+ "\n- newfresh = \"\\tnewfresh %2%->%3%( %4% )\""

			+ "\n- input  = \"\\tinput  %2%->%3%%4%\""
			+ "\n- output = \"\\toutput %2%->%3%%4%\""

			+ "\n- input#env  = \"\\tINPUT  %2%->%3%%4%\""
			+ "\n- output#env = \"\\tOUTPUT %2%->%3%%4%\"";


	  public static final String SYNTAX_TRACE_FORMAT_SPECIFICATION_LINK
			= "// See full grammar of [Trace Format Specification] "
			+ "at the end of this generated file";


	////////////////////////////////////////////////////////////////////////////
	// HELPERS for AD'HOC FORMAT SPECIFICATION
	////////////////////////////////////////////////////////////////////////////

	  public final String HELPER_TRACE_FORMAT_SPECIFICATION
			= "// TracePoint with only <value> attribute as "
					+ "condition (e.g. path#condition...)"
			+ "\n%1% --> condition"
			+ "\n// Other TracePoint with all attributes"
			+ "\n%1% --> machine runtime pid"
			+ "\n%2% --> machine identifier name"
			+ "\n%3% --> port | signal | variable | machine | transition | routine"
			+ "\n%4% --> value"
			+ "\n// Tips: for hide all element for a given kind"
			+ "\n// Set an empty string as his attribute value";



	////////////////////////////////////////////////////////////////////////////
	// HELPERS for TTCN3  TESTCASES_IMPLEMENTATION
	///////////////////////////////////////////////////////////////////////////

	public final String HELPER_MODULE_TESTCASE_IMPLEMENTATION_TEMPLATE
			= "module TTCN_Testcases {"
			+ "\n\timport from TTCN_Adaptation all;"
			+ "\n\timport from TTCN_Templates all;"
			+ "\n\t// List of testcases"
			+ "\n\t..."
			+ "\n\ttestcase ..."
			+ "\n\t\t// Starting operation"
			+ "\n\t\t..."
			+ "\n\t\t// List of Sending / Receiving operations"
			+ "\n\t\t..."
			+ "\n\t\t..."
			+ "\n\t\t// Ending operation"
			+ "\n\t\t..."
			+ "\n\t}"
			+ "\n\t..."
			+ "\n}";


	public final String HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS
			= "%1% --> <system identifier>";


	public final String HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS
			= "%1% --> <system identifier>"
			+ "\n%2% --> <environment channel> | <(system|environment) port>"
			+ "\n%3% --> <template port as type>"
			+ "\n%4% --> <template port identifier>";


	public final String HELPER_MODULE_ADAPTATION_IMPLEMENTATION_TEMPLATE
			= "module TTCN_Adaptation {"
			+ "\n\timport from TTCN_Declarations all;"
			+ "\n\t// Components declaration"
			+ "\n\t..."
			+ "\n\t// Implementation of utility functions"
			+ "\n\t..."
			+ "\n\t// Implementation of testcases Starting / Ending wrappers"
			+ "\n\t..."
			+ "\n\t// Implementation of testcases Sending / Receiving wrappers"
			+ "\n\t..."
			+ "\n}";


	////////////////////////////////////////////////////////////////////////////
	// :  a.k.a.
	///////////////////////////////////////////////////////////////////////////



}
