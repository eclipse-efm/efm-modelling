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

public interface IWorkflowConfigurationSyntax {

	////////////////////////////////////////////////////////////////////////////
	// HELPERS for BEHAVIOR SELECTION ANALYSIS
	///////////////////////////////////////////////////////////////////////////

	String BEHAVIOR_DESCRIPTION
			= "Select a list of elements to characterize the behavior to be find."
			+ "\nThe list can be a set of following elements:"
			+ "\n\t- transition =\"a-transition-name\""
			+ "\n\t- state  =\"a-state-name\""
			+ "\n\t- input  =\"an_input_port_or_signal_used_in_a_statement\""
			+ "\n\t_ output =\"an_output_port_or_signal_used_in_a_statement\""
			+ "\n\t_ com =\"a_com_input_or_output_port_or_signal_used_in_a_statement\""
			+ "\nAll items must be separated by newline or semicolon.";

	List<String> BEHAVIOR_INITIAL_SAMPLE
			= Arrays.asList(
					"// Sequence of elements characterizing the desired behavior."
//					"\n// The elements of the sequence may be selected from:",
//					"\ntransition =\"<transition_name_id>\"",
//					"\nstate  =\"<state_name_id>\"",
//					"\ninput  =\"<input_port_or_signal_name_id>\"",
//					"\ninout  =\"<inout_port_or_signal_name_id>\"",
//					"\noutput =\"<output_port_or_signal_name_id>\"",
//					"\ncom =\"<input_or_output_port_or_signal_name_id>\"",
//					"\nformula=\"<predicat_expression_on_variable>\""
			);


	////////////////////////////////////////////////////////////////////////////
	// HELPERS for TEST OFFLINE ANALYSIS
	///////////////////////////////////////////////////////////////////////////

	String TEST_OFFLINE_OBSERVABLE
			= "Selection of Observable Element";

	String TEST_OFFLINE_CONTROLLABLE
			= "Selection of Controllable Element";


	////////////////////////////////////////////////////////////////////////////
	// TRACE SPECIFICATION
	////////////////////////////////////////////////////////////////////////////

	String SYNTAX_TRACE_SPECIFICATION
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


	String SYNTAX_TRACE_SPECIFICATION_LINK
			= "// See full grammar of [Trace Specification] "
			+ "at the end of this generated file";


	////////////////////////////////////////////////////////////////////////////
	// AD'HOC FORMAT SPECIFICATION
	////////////////////////////////////////////////////////////////////////////

	String SYNTAX_TRACE_FORMAT_SPECIFICATION
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
			+ "\n- file#header = \"TRACE NUMBER %1%\""
			+ "\n- file#begin  = \"\""
			+ "\n- file#end    = \"\""
			+ "\n"
			+ "\n// %1% --> trace number"
			+ "\n// %2% --> execution context leaf identifier"
			+ "\n- testcase#header = \"TRACE NUMBER %1%\""
			+ "\n- testcase#begin  = \"\""
			+ "\n- testcase#end    = \"\""
			+ "\n- testcase#end    = \"\""
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
			+ "\n// %5% --> machine sender   identifier name"
			+ "\n// %6% --> machine receiver identifier name"

			+ "\n- time   = \"\\t%4%\""

			+ "\n- assign = \"\\t%2%:%3% = %4%\""

			+ "\n- newfresh = \"\\tnewfresh %2%->%3%( %4% )\""

			+ "\n- input  = \"\\tinput  %2%->%3%%4%\""
			+ "\n- output = \"\\toutput %2%->%3%%4%\""

			+ "\n- input#env  = \"\\tINPUT  %2%->%3%%4%\""
			+ "\n- output#env = \"\\tOUTPUT %2%->%3%%4%\""

			+ "\n- trace = \"%4%\"";


	  String SYNTAX_TRACE_FORMAT_SPECIFICATION_LINK
			= "// See full grammar of [Trace Format Specification] "
			+ "at the end of this generated file";


	////////////////////////////////////////////////////////////////////////////
	// HELPERS for AD'HOC FORMAT SPECIFICATION
	////////////////////////////////////////////////////////////////////////////

	  String HELPER_TRACE_FORMAT_SPECIFICATION
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

	String HELPER_MODULE_TESTCASE_IMPLEMENTATION_TEMPLATE
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


	String HELPER_MODULE_TESTCASE_STARTING_ENDING_PATTERN_PARAMETERS
			= "%1% --> <system identifier>";


	String HELPER_MODULE_TESTCASE_COMMUNICATION_PATTERN_PARAMETERS
			=   "%1% --> <port name id>"
			+ "\n%2% --> <container/lifeline/component name id>"
			+ "\n%3% --> <system name id>"
			+ "\n%4% --> <environment channel id>"
			+ "\n%5% --> <message type name id>"
			+ "\n%6% --> <port type name id>"
			+ "\n%7% --> <port instance name id>"
			+ "\n%8% --> <port parameters template message>";


	String HELPER_MODULE_ADAPTATION_IMPLEMENTATION_TEMPLATE
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
	// HELPER for INCUBATION MODULE as OPAQUE WORKER
	////////////////////////////////////////////////////////////////////////////

	String HELPER_OPAQUE_MODULE_TEXTUAL_CONFIGURATION
			= "// a sample of opaque worker workflow with its textual configuration\n"
			+ "incubation#worker  new_incubation_worker {\n"
			+ "\tproperty [\n"
			+ "\t\tattribute#bool = true\n"
			+ "\t\tattribute#integert = 42\n"
			+ "\t\tattribute#string = \"string value\"\n"
			+ "\t] // end property\n"
			+ "} // end new_incubation_worker\n";  //$NON-NLS-1$


	////////////////////////////////////////////////////////////////////////////
	// :  a.k.a.
	///////////////////////////////////////////////////////////////////////////



}
