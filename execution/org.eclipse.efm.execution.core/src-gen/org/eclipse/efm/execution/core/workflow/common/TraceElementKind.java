/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.execution.core.workflow.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Trace Element Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getTraceElementKind()
 * @model
 * @generated
 */
public enum TraceElementKind implements Enumerator {
	/**
	 * The '<em><b>UNDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEFINED(0, "UNDEFINED", "undefined"),

	/**
	 * The '<em><b>CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	CONDITION(1, "CONDITION", "condition"),

	/**
	 * The '<em><b>DECISION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECISION_VALUE
	 * @generated
	 * @ordered
	 */
	DECISION(2, "DECISION", "decision"),

	/**
	 * The '<em><b>FORMULA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORMULA_VALUE
	 * @generated
	 * @ordered
	 */
	FORMULA(3, "FORMULA", "formula"),

	/**
	 * The '<em><b>PATH CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATH_CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	PATH_CONDITION(4, "PATH_CONDITION", "path#condition"),

	/**
	 * The '<em><b>PATH CONDITION LEAF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATH_CONDITION_LEAF_VALUE
	 * @generated
	 * @ordered
	 */
	PATH_CONDITION_LEAF(5, "PATH_CONDITION_LEAF", "path#condition#leaf"),

	/**
	 * The '<em><b>PATH TIMED CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATH_TIMED_CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	PATH_TIMED_CONDITION(6, "PATH_TIMED_CONDITION", "path#timed#condition"),

	/**
	 * The '<em><b>PATH TIMED CONDITION LEAF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATH_TIMED_CONDITION_LEAF_VALUE
	 * @generated
	 * @ordered
	 */
	PATH_TIMED_CONDITION_LEAF(7, "PATH_TIMED_CONDITION_LEAF", "path#timed#condition#leaf"),

	/**
	 * The '<em><b>NODE CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_CONDITION(8, "NODE_CONDITION", "node#condition"),

	/**
	 * The '<em><b>NODE CONDITION LEAF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_CONDITION_LEAF_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_CONDITION_LEAF(9, "NODE_CONDITION_LEAF", "node#condition#leaf"),

	/**
	 * The '<em><b>NODE TIMED CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_TIMED_CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_TIMED_CONDITION(10, "NODE_TIMED_CONDITION", "node#timed#condition"),

	/**
	 * The '<em><b>NODE TIMED CONDITION LEAF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_TIMED_CONDITION_LEAF_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_TIMED_CONDITION_LEAF(11, "NODE_TIMED_CONDITION_LEAF", "node#timed#condition#leaf"),

	/**
	 * The '<em><b>ASSIGN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	ASSIGN(12, "ASSIGN", "assign"),

	/**
	 * The '<em><b>DELTA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELTA_VALUE
	 * @generated
	 * @ordered
	 */
	DELTA(13, "DELTA", "delta"),

	/**
	 * The '<em><b>TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME_VALUE
	 * @generated
	 * @ordered
	 */
	TIME(14, "TIME", "time"),

	/**
	 * The '<em><b>VARIABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	VARIABLE(15, "VARIABLE", "variable"),

	/**
	 * The '<em><b>NEWFRESH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEWFRESH_VALUE
	 * @generated
	 * @ordered
	 */
	NEWFRESH(16, "NEWFRESH", "newfresh"),

	/**
	 * The '<em><b>COM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COM_VALUE
	 * @generated
	 * @ordered
	 */
	COM(17, "COM", "com"),

	/**
	 * The '<em><b>INOUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INOUT_VALUE
	 * @generated
	 * @ordered
	 */
	INOUT(18, "INOUT", "inout"),

	/**
	 * The '<em><b>INPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT(19, "INPUT", "input"),

	/**
	 * The '<em><b>OUTPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT(20, "OUTPUT", "output"),

	/**
	 * The '<em><b>INPUT ENV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_ENV_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_ENV(21, "INPUT_ENV", "input#env"),

	/**
	 * The '<em><b>OUTPUT ENV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_ENV_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_ENV(22, "OUTPUT_ENV", "output#env"),

	/**
	 * The '<em><b>INPUT RDV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_RDV_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_RDV(23, "INPUT_RDV", "input#rdv"),

	/**
	 * The '<em><b>OUTPUT RDV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_RDV_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_RDV(24, "OUTPUT_RDV", "output#rdv"),

	/**
	 * The '<em><b>INPUT BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_BUFFER(25, "INPUT_BUFFER", "input#buffer"),

	/**
	 * The '<em><b>OUTPUT BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_BUFFER(26, "OUTPUT_BUFFER", "output#buffer"),

	/**
	 * The '<em><b>INPUT VAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_VAR_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_VAR(27, "INPUT_VAR", "input#var"),

	/**
	 * The '<em><b>OUTPUT VAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_VAR_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_VAR(28, "OUTPUT_VAR", "output#var"),

	/**
	 * The '<em><b>PORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PORT_VALUE
	 * @generated
	 * @ordered
	 */
	PORT(29, "PORT", "port"),

	/**
	 * The '<em><b>SIGNAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIGNAL_VALUE
	 * @generated
	 * @ordered
	 */
	SIGNAL(30, "SIGNAL", "signal"),

	/**
	 * The '<em><b>MESSAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE(31, "MESSAGE", "message"),

	/**
	 * The '<em><b>CHANNEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_VALUE
	 * @generated
	 * @ordered
	 */
	CHANNEL(32, "CHANNEL", "channel"),

	/**
	 * The '<em><b>BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	BUFFER(33, "BUFFER", "buffer"),

	/**
	 * The '<em><b>RUNNABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNNABLE_VALUE
	 * @generated
	 * @ordered
	 */
	RUNNABLE(34, "RUNNABLE", "runnable"),

	/**
	 * The '<em><b>ROUTINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUTINE_VALUE
	 * @generated
	 * @ordered
	 */
	ROUTINE(35, "ROUTINE", "routine"),

	/**
	 * The '<em><b>TRANSITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSITION_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSITION(36, "TRANSITION", "transition"),

	/**
	 * The '<em><b>STATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE(37, "STATE", "state"),

	/**
	 * The '<em><b>STATEMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATEMACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	STATEMACHINE(38, "STATEMACHINE", "statemachine"),

	/**
	 * The '<em><b>MODEL MACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODEL_MACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	MODEL_MACHINE(39, "MODEL_MACHINE", "model"),

	/**
	 * The '<em><b>PROTOTYPE MACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROTOTYPE_MACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	PROTOTYPE_MACHINE(40, "PROTOTYPE_MACHINE", "prototype"),

	/**
	 * The '<em><b>INSTANCE MACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_MACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	INSTANCE_MACHINE(41, "INSTANCE_MACHINE", "instance"),

	/**
	 * The '<em><b>MACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	MACHINE(42, "MACHINE", "machine"),

	/**
	 * The '<em><b>SYSTEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM(43, "SYSTEM", "system"),

	/**
	 * The '<em><b>FILE HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	FILE_HEADER(50, "FILE_HEADER", "file#header"),

	/**
	 * The '<em><b>FILE BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	FILE_BEGIN(51, "FILE_BEGIN", "file#begin"),

	/**
	 * The '<em><b>FILE END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_END_VALUE
	 * @generated
	 * @ordered
	 */
	FILE_END(52, "FILE_END", "file#end"),

	/**
	 * The '<em><b>TESTCASE HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	TESTCASE_HEADER(53, "TESTCASE_HEADER", "testcase#header"),

	/**
	 * The '<em><b>TESTCASE BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	TESTCASE_BEGIN(54, "TESTCASE_BEGIN", "testcase#begin"),

	/**
	 * The '<em><b>TESTCASE END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_END_VALUE
	 * @generated
	 * @ordered
	 */
	TESTCASE_END(55, "TESTCASE_END", "testcase#end"),

	/**
	 * The '<em><b>INIT HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INIT_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	INIT_HEADER(56, "INIT_HEADER", "init#header"),

	/**
	 * The '<em><b>INIT BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INIT_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	INIT_BEGIN(57, "INIT_BEGIN", "init#begin"),

	/**
	 * The '<em><b>INIT END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INIT_END_VALUE
	 * @generated
	 * @ordered
	 */
	INIT_END(58, "INIT_END", "init#end"),

	/**
	 * The '<em><b>STEP HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_HEADER(59, "STEP_HEADER", "step#header"),

	/**
	 * The '<em><b>STEP BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_BEGIN(60, "STEP_BEGIN", "step#begin"),

	/**
	 * The '<em><b>STEP END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_END_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_END(61, "STEP_END", "step#end"),

	/**
	 * The '<em><b>COMMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMENT_VALUE
	 * @generated
	 * @ordered
	 */
	COMMENT(62, "COMMENT", "comment"),

	/**
	 * The '<em><b>SEPARATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEPARATOR_VALUE
	 * @generated
	 * @ordered
	 */
	SEPARATOR(63, "SEPARATOR", "separator"),

	/**
	 * The '<em><b>NEWLINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEWLINE_VALUE
	 * @generated
	 * @ordered
	 */
	NEWLINE(64, "NEWLINE", "newline"),

	/**
	 * The '<em><b>NEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEXT_VALUE
	 * @generated
	 * @ordered
	 */
	NEXT(65, "NEXT", "next"),

	/**
	 * The '<em><b>LIFELINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE(66, "LIFELINE", "lifeline"),

	/**
	 * The '<em><b>LIFELINE HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_HEADER(67, "LIFELINE_HEADER", "lifeline#header"),

	/**
	 * The '<em><b>LIFELINE BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_BEGIN(68, "LIFELINE_BEGIN", "lifeline#begin"),

	/**
	 * The '<em><b>LIFELINE END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_END_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_END(69, "LIFELINE_END", "lifeline#end"),

	/**
	 * The '<em><b>LIFELINE ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_ID_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_ID(70, "LIFELINE_ID", "lifeline#id"),

	/**
	 * The '<em><b>LIFELINE STATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_STATE_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_STATE(71, "LIFELINE_STATE", "lifeline#state"),

	/**
	 * The '<em><b>RAW ATTRIBUTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAW_ATTRIBUTE_VALUE
	 * @generated
	 * @ordered
	 */
	RAW_ATTRIBUTE(72, "RAW_ATTRIBUTE", "__raw__"),

	/**
	 * The '<em><b>EXECUTION CONTEXT ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTION_CONTEXT_ID_VALUE
	 * @generated
	 * @ordered
	 */
	EXECUTION_CONTEXT_ID(80, "EXECUTION_CONTEXT_ID", "execution#context#id"), /**
	 * The '<em><b>NODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_VALUE
	 * @generated
	 * @ordered
	 */
	NODE(81, "NODE", "node"), /**
	 * The '<em><b>NODE LABEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_LABEL(82, "NODE_LABEL", "node#label"), /**
	 * The '<em><b>NODE HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_HEADER(83, "NODE_HEADER", "node#header"),

	/**
	 * The '<em><b>NODE DATA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_DATA_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_DATA(84, "NODE_DATA", "node#data"),

	/**
	 * The '<em><b>NODE INFO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_INFO_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_INFO(85, "NODE_INFO", "node#info"),

	/**
	 * The '<em><b>NODE TRACE RUN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_TRACE_RUN_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_TRACE_RUN(86, "NODE_TRACE_RUN", "node#trace#run"),

	/**
	 * The '<em><b>NODE TRACE IO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_TRACE_IO_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_TRACE_IO(87, "NODE_TRACE_IO", "node#trace#io"),

	/**
	 * The '<em><b>VALUE PARAMETER BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_PARAMETER_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_PARAMETER_BEGIN(88, "VALUE_PARAMETER_BEGIN", "value#parameter#begin"),

	/**
	 * The '<em><b>VALUE PARAMETER SEPARATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_PARAMETER_SEPARATOR_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_PARAMETER_SEPARATOR(89, "VALUE_PARAMETER_SEPARATOR", "value#parameter#separator"),

	/**
	 * The '<em><b>VALUE PARAMETER END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_PARAMETER_END_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_PARAMETER_END(90, "VALUE_PARAMETER_END", "value#parameter#end"),

	/**
	 * The '<em><b>VALUE ARRAY BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_ARRAY_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_ARRAY_BEGIN(91, "VALUE_ARRAY_BEGIN", "value#array#begin"),

	/**
	 * The '<em><b>VALUE ARRAY SEPARATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_ARRAY_SEPARATOR_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_ARRAY_SEPARATOR(92, "VALUE_ARRAY_SEPARATOR", "value#array#separator"),

	/**
	 * The '<em><b>VALUE ARRAY END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_ARRAY_END_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_ARRAY_END(93, "VALUE_ARRAY_END", "value#array#end"),

	/**
	 * The '<em><b>VALUE STRUCT BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_STRUCT_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_STRUCT_BEGIN(94, "VALUE_STRUCT_BEGIN", "value#struct#begin"),

	/**
	 * The '<em><b>VALUE STRUCT SEPARATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_STRUCT_SEPARATOR_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_STRUCT_SEPARATOR(95, "VALUE_STRUCT_SEPARATOR", "value#struct#separator"),

	/**
	 * The '<em><b>VALUE STRUCT END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_STRUCT_END_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE_STRUCT_END(96, "VALUE_STRUCT_END", "value#struct#end"),

	/**
	 * The '<em><b>META TRACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #META_TRACE_VALUE
	 * @generated
	 * @ordered
	 */
	META_TRACE(97, "META_TRACE", "trace"), /**
	 * The '<em><b>META DEBUG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #META_DEBUG_VALUE
	 * @generated
	 * @ordered
	 */
	META_DEBUG(98, "META_DEBUG", "debug"), /**
	 * The '<em><b>TIPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIPS_VALUE
	 * @generated
	 * @ordered
	 */
	TIPS(99, "TIPS", "tips");

	/**
	 * The '<em><b>UNDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @model literal="undefined"
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED_VALUE = 0;

	/**
	 * The '<em><b>CONDITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONDITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONDITION
	 * @model literal="condition"
	 * @generated
	 * @ordered
	 */
	public static final int CONDITION_VALUE = 1;

	/**
	 * The '<em><b>DECISION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECISION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECISION
	 * @model literal="decision"
	 * @generated
	 * @ordered
	 */
	public static final int DECISION_VALUE = 2;

	/**
	 * The '<em><b>FORMULA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FORMULA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORMULA
	 * @model literal="formula"
	 * @generated
	 * @ordered
	 */
	public static final int FORMULA_VALUE = 3;

	/**
	 * The '<em><b>PATH CONDITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PATH CONDITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PATH_CONDITION
	 * @model literal="path#condition"
	 * @generated
	 * @ordered
	 */
	public static final int PATH_CONDITION_VALUE = 4;

	/**
	 * The '<em><b>PATH CONDITION LEAF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PATH CONDITION LEAF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PATH_CONDITION_LEAF
	 * @model literal="path#condition#leaf"
	 * @generated
	 * @ordered
	 */
	public static final int PATH_CONDITION_LEAF_VALUE = 5;

	/**
	 * The '<em><b>PATH TIMED CONDITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PATH TIMED CONDITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PATH_TIMED_CONDITION
	 * @model literal="path#timed#condition"
	 * @generated
	 * @ordered
	 */
	public static final int PATH_TIMED_CONDITION_VALUE = 6;

	/**
	 * The '<em><b>PATH TIMED CONDITION LEAF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PATH TIMED CONDITION LEAF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PATH_TIMED_CONDITION_LEAF
	 * @model literal="path#timed#condition#leaf"
	 * @generated
	 * @ordered
	 */
	public static final int PATH_TIMED_CONDITION_LEAF_VALUE = 7;

	/**
	 * The '<em><b>NODE CONDITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE CONDITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_CONDITION
	 * @model literal="node#condition"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_CONDITION_VALUE = 8;

	/**
	 * The '<em><b>NODE CONDITION LEAF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE CONDITION LEAF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_CONDITION_LEAF
	 * @model literal="node#condition#leaf"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_CONDITION_LEAF_VALUE = 9;

	/**
	 * The '<em><b>NODE TIMED CONDITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE TIMED CONDITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_TIMED_CONDITION
	 * @model literal="node#timed#condition"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_TIMED_CONDITION_VALUE = 10;

	/**
	 * The '<em><b>NODE TIMED CONDITION LEAF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE TIMED CONDITION LEAF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_TIMED_CONDITION_LEAF
	 * @model literal="node#timed#condition#leaf"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_TIMED_CONDITION_LEAF_VALUE = 11;

	/**
	 * The '<em><b>ASSIGN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSIGN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSIGN
	 * @model literal="assign"
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGN_VALUE = 12;

	/**
	 * The '<em><b>DELTA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DELTA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELTA
	 * @model literal="delta"
	 * @generated
	 * @ordered
	 */
	public static final int DELTA_VALUE = 13;

	/**
	 * The '<em><b>TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIME
	 * @model literal="time"
	 * @generated
	 * @ordered
	 */
	public static final int TIME_VALUE = 14;

	/**
	 * The '<em><b>VARIABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VARIABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VARIABLE
	 * @model literal="variable"
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_VALUE = 15;

	/**
	 * The '<em><b>NEWFRESH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEWFRESH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEWFRESH
	 * @model literal="newfresh"
	 * @generated
	 * @ordered
	 */
	public static final int NEWFRESH_VALUE = 16;

	/**
	 * The '<em><b>COM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COM
	 * @model literal="com"
	 * @generated
	 * @ordered
	 */
	public static final int COM_VALUE = 17;

	/**
	 * The '<em><b>INOUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INOUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INOUT
	 * @model literal="inout"
	 * @generated
	 * @ordered
	 */
	public static final int INOUT_VALUE = 18;

	/**
	 * The '<em><b>INPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT
	 * @model literal="input"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_VALUE = 19;

	/**
	 * The '<em><b>OUTPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUTPUT
	 * @model literal="output"
	 * @generated
	 * @ordered
	 */
	public static final int OUTPUT_VALUE = 20;

	/**
	 * The '<em><b>INPUT ENV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPUT ENV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_ENV
	 * @model literal="input#env"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_ENV_VALUE = 21;

	/**
	 * The '<em><b>OUTPUT ENV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTPUT ENV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_ENV
	 * @model literal="output#env"
	 * @generated
	 * @ordered
	 */
	public static final int OUTPUT_ENV_VALUE = 22;

	/**
	 * The '<em><b>INPUT RDV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPUT RDV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_RDV
	 * @model literal="input#rdv"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_RDV_VALUE = 23;

	/**
	 * The '<em><b>OUTPUT RDV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTPUT RDV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_RDV
	 * @model literal="output#rdv"
	 * @generated
	 * @ordered
	 */
	public static final int OUTPUT_RDV_VALUE = 24;

	/**
	 * The '<em><b>INPUT BUFFER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPUT BUFFER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_BUFFER
	 * @model literal="input#buffer"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_BUFFER_VALUE = 25;

	/**
	 * The '<em><b>OUTPUT BUFFER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTPUT BUFFER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_BUFFER
	 * @model literal="output#buffer"
	 * @generated
	 * @ordered
	 */
	public static final int OUTPUT_BUFFER_VALUE = 26;

	/**
	 * The '<em><b>INPUT VAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPUT VAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_VAR
	 * @model literal="input#var"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_VAR_VALUE = 27;

	/**
	 * The '<em><b>OUTPUT VAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTPUT VAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_VAR
	 * @model literal="output#var"
	 * @generated
	 * @ordered
	 */
	public static final int OUTPUT_VAR_VALUE = 28;

	/**
	 * The '<em><b>PORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PORT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PORT
	 * @model literal="port"
	 * @generated
	 * @ordered
	 */
	public static final int PORT_VALUE = 29;

	/**
	 * The '<em><b>SIGNAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIGNAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIGNAL
	 * @model literal="signal"
	 * @generated
	 * @ordered
	 */
	public static final int SIGNAL_VALUE = 30;

	/**
	 * The '<em><b>MESSAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MESSAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MESSAGE
	 * @model literal="message"
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_VALUE = 31;

	/**
	 * The '<em><b>CHANNEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANNEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANNEL
	 * @model literal="channel"
	 * @generated
	 * @ordered
	 */
	public static final int CHANNEL_VALUE = 32;

	/**
	 * The '<em><b>BUFFER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUFFER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUFFER
	 * @model literal="buffer"
	 * @generated
	 * @ordered
	 */
	public static final int BUFFER_VALUE = 33;

	/**
	 * The '<em><b>RUNNABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUNNABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUNNABLE
	 * @model literal="runnable"
	 * @generated
	 * @ordered
	 */
	public static final int RUNNABLE_VALUE = 34;

	/**
	 * The '<em><b>ROUTINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROUTINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROUTINE
	 * @model literal="routine"
	 * @generated
	 * @ordered
	 */
	public static final int ROUTINE_VALUE = 35;

	/**
	 * The '<em><b>TRANSITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSITION
	 * @model literal="transition"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSITION_VALUE = 36;

	/**
	 * The '<em><b>STATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATE
	 * @model literal="state"
	 * @generated
	 * @ordered
	 */
	public static final int STATE_VALUE = 37;

	/**
	 * The '<em><b>STATEMACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATEMACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATEMACHINE
	 * @model literal="statemachine"
	 * @generated
	 * @ordered
	 */
	public static final int STATEMACHINE_VALUE = 38;

	/**
	 * The '<em><b>MODEL MACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODEL MACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODEL_MACHINE
	 * @model literal="model"
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_MACHINE_VALUE = 39;

	/**
	 * The '<em><b>PROTOTYPE MACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROTOTYPE MACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROTOTYPE_MACHINE
	 * @model literal="prototype"
	 * @generated
	 * @ordered
	 */
	public static final int PROTOTYPE_MACHINE_VALUE = 40;

	/**
	 * The '<em><b>INSTANCE MACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSTANCE MACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_MACHINE
	 * @model literal="instance"
	 * @generated
	 * @ordered
	 */
	public static final int INSTANCE_MACHINE_VALUE = 41;

	/**
	 * The '<em><b>MACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MACHINE
	 * @model literal="machine"
	 * @generated
	 * @ordered
	 */
	public static final int MACHINE_VALUE = 42;

	/**
	 * The '<em><b>SYSTEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SYSTEM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM
	 * @model literal="system"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_VALUE = 43;

	/**
	 * The '<em><b>FILE HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILE HEADER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE_HEADER
	 * @model literal="file#header"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_HEADER_VALUE = 50;

	/**
	 * The '<em><b>FILE BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILE BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE_BEGIN
	 * @model literal="file#begin"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_BEGIN_VALUE = 51;

	/**
	 * The '<em><b>FILE END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILE END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE_END
	 * @model literal="file#end"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_END_VALUE = 52;

	/**
	 * The '<em><b>TESTCASE HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TESTCASE HEADER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_HEADER
	 * @model literal="testcase#header"
	 * @generated
	 * @ordered
	 */
	public static final int TESTCASE_HEADER_VALUE = 53;

	/**
	 * The '<em><b>TESTCASE BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TESTCASE BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_BEGIN
	 * @model literal="testcase#begin"
	 * @generated
	 * @ordered
	 */
	public static final int TESTCASE_BEGIN_VALUE = 54;

	/**
	 * The '<em><b>TESTCASE END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TESTCASE END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_END
	 * @model literal="testcase#end"
	 * @generated
	 * @ordered
	 */
	public static final int TESTCASE_END_VALUE = 55;

	/**
	 * The '<em><b>INIT HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INIT HEADER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INIT_HEADER
	 * @model literal="init#header"
	 * @generated
	 * @ordered
	 */
	public static final int INIT_HEADER_VALUE = 56;

	/**
	 * The '<em><b>INIT BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INIT BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INIT_BEGIN
	 * @model literal="init#begin"
	 * @generated
	 * @ordered
	 */
	public static final int INIT_BEGIN_VALUE = 57;

	/**
	 * The '<em><b>INIT END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INIT END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INIT_END
	 * @model literal="init#end"
	 * @generated
	 * @ordered
	 */
	public static final int INIT_END_VALUE = 58;

	/**
	 * The '<em><b>STEP HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEP HEADER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP_HEADER
	 * @model literal="step#header"
	 * @generated
	 * @ordered
	 */
	public static final int STEP_HEADER_VALUE = 59;

	/**
	 * The '<em><b>STEP BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEP BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP_BEGIN
	 * @model literal="step#begin"
	 * @generated
	 * @ordered
	 */
	public static final int STEP_BEGIN_VALUE = 60;

	/**
	 * The '<em><b>STEP END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEP END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP_END
	 * @model literal="step#end"
	 * @generated
	 * @ordered
	 */
	public static final int STEP_END_VALUE = 61;

	/**
	 * The '<em><b>COMMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMENT
	 * @model literal="comment"
	 * @generated
	 * @ordered
	 */
	public static final int COMMENT_VALUE = 62;

	/**
	 * The '<em><b>SEPARATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEPARATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEPARATOR
	 * @model literal="separator"
	 * @generated
	 * @ordered
	 */
	public static final int SEPARATOR_VALUE = 63;

	/**
	 * The '<em><b>NEWLINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEWLINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEWLINE
	 * @model literal="newline"
	 * @generated
	 * @ordered
	 */
	public static final int NEWLINE_VALUE = 64;

	/**
	 * The '<em><b>NEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEXT
	 * @model literal="next"
	 * @generated
	 * @ordered
	 */
	public static final int NEXT_VALUE = 65;

	/**
	 * The '<em><b>LIFELINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIFELINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIFELINE
	 * @model literal="lifeline"
	 * @generated
	 * @ordered
	 */
	public static final int LIFELINE_VALUE = 66;

	/**
	 * The '<em><b>LIFELINE HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIFELINE HEADER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_HEADER
	 * @model literal="lifeline#header"
	 * @generated
	 * @ordered
	 */
	public static final int LIFELINE_HEADER_VALUE = 67;

	/**
	 * The '<em><b>LIFELINE BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIFELINE BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_BEGIN
	 * @model literal="lifeline#begin"
	 * @generated
	 * @ordered
	 */
	public static final int LIFELINE_BEGIN_VALUE = 68;

	/**
	 * The '<em><b>LIFELINE END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIFELINE END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_END
	 * @model literal="lifeline#end"
	 * @generated
	 * @ordered
	 */
	public static final int LIFELINE_END_VALUE = 69;

	/**
	 * The '<em><b>LIFELINE ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIFELINE ID</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_ID
	 * @model literal="lifeline#id"
	 * @generated
	 * @ordered
	 */
	public static final int LIFELINE_ID_VALUE = 70;

	/**
	 * The '<em><b>LIFELINE STATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIFELINE STATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_STATE
	 * @model literal="lifeline#state"
	 * @generated
	 * @ordered
	 */
	public static final int LIFELINE_STATE_VALUE = 71;

	/**
	 * The '<em><b>RAW ATTRIBUTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RAW ATTRIBUTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAW_ATTRIBUTE
	 * @model literal="__raw__"
	 * @generated
	 * @ordered
	 */
	public static final int RAW_ATTRIBUTE_VALUE = 72;

	/**
	 * The '<em><b>EXECUTION CONTEXT ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTION_CONTEXT_ID
	 * @model literal="execution#context#id"
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTION_CONTEXT_ID_VALUE = 80;

	/**
	 * The '<em><b>NODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE
	 * @model literal="node"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_VALUE = 81;

	/**
	 * The '<em><b>NODE LABEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE LABEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_LABEL
	 * @model literal="node#label"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_LABEL_VALUE = 82;

	/**
	 * The '<em><b>NODE HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE HEADER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_HEADER
	 * @model literal="node#header"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_HEADER_VALUE = 83;

	/**
	 * The '<em><b>NODE DATA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE DATA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_DATA
	 * @model literal="node#data"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_DATA_VALUE = 84;

	/**
	 * The '<em><b>NODE INFO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE INFO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_INFO
	 * @model literal="node#info"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_INFO_VALUE = 85;

	/**
	 * The '<em><b>NODE TRACE RUN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE TRACE RUN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_TRACE_RUN
	 * @model literal="node#trace#run"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_TRACE_RUN_VALUE = 86;

	/**
	 * The '<em><b>NODE TRACE IO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NODE TRACE IO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_TRACE_IO
	 * @model literal="node#trace#io"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_TRACE_IO_VALUE = 87;

	/**
	 * The '<em><b>VALUE PARAMETER BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE PARAMETER BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_PARAMETER_BEGIN
	 * @model literal="value#parameter#begin"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_PARAMETER_BEGIN_VALUE = 88;

	/**
	 * The '<em><b>VALUE PARAMETER SEPARATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE PARAMETER SEPARATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_PARAMETER_SEPARATOR
	 * @model literal="value#parameter#separator"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_PARAMETER_SEPARATOR_VALUE = 89;

	/**
	 * The '<em><b>VALUE PARAMETER END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE PARAMETER END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_PARAMETER_END
	 * @model literal="value#parameter#end"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_PARAMETER_END_VALUE = 90;

	/**
	 * The '<em><b>VALUE ARRAY BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE ARRAY BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_ARRAY_BEGIN
	 * @model literal="value#array#begin"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_ARRAY_BEGIN_VALUE = 91;

	/**
	 * The '<em><b>VALUE ARRAY SEPARATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE ARRAY SEPARATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_ARRAY_SEPARATOR
	 * @model literal="value#array#separator"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_ARRAY_SEPARATOR_VALUE = 92;

	/**
	 * The '<em><b>VALUE ARRAY END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE ARRAY END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_ARRAY_END
	 * @model literal="value#array#end"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_ARRAY_END_VALUE = 93;

	/**
	 * The '<em><b>VALUE STRUCT BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE STRUCT BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_STRUCT_BEGIN
	 * @model literal="value#struct#begin"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_STRUCT_BEGIN_VALUE = 94;

	/**
	 * The '<em><b>VALUE STRUCT SEPARATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE STRUCT SEPARATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_STRUCT_SEPARATOR
	 * @model literal="value#struct#separator"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_STRUCT_SEPARATOR_VALUE = 95;

	/**
	 * The '<em><b>VALUE STRUCT END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE STRUCT END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_STRUCT_END
	 * @model literal="value#struct#end"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_STRUCT_END_VALUE = 96;

	/**
	 * The '<em><b>META TRACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>META TRACE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #META_TRACE
	 * @model literal="trace"
	 * @generated
	 * @ordered
	 */
	public static final int META_TRACE_VALUE = 97;

	/**
	 * The '<em><b>META DEBUG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>META DEBUG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #META_DEBUG
	 * @model literal="debug"
	 * @generated
	 * @ordered
	 */
	public static final int META_DEBUG_VALUE = 98;

	/**
	 * The '<em><b>TIPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIPS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIPS
	 * @model literal="tips"
	 * @generated
	 * @ordered
	 */
	public static final int TIPS_VALUE = 99;

	/**
	 * An array of all the '<em><b>Trace Element Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TraceElementKind[] VALUES_ARRAY =
		new TraceElementKind[] {
			UNDEFINED,
			CONDITION,
			DECISION,
			FORMULA,
			PATH_CONDITION,
			PATH_CONDITION_LEAF,
			PATH_TIMED_CONDITION,
			PATH_TIMED_CONDITION_LEAF,
			NODE_CONDITION,
			NODE_CONDITION_LEAF,
			NODE_TIMED_CONDITION,
			NODE_TIMED_CONDITION_LEAF,
			ASSIGN,
			DELTA,
			TIME,
			VARIABLE,
			NEWFRESH,
			COM,
			INOUT,
			INPUT,
			OUTPUT,
			INPUT_ENV,
			OUTPUT_ENV,
			INPUT_RDV,
			OUTPUT_RDV,
			INPUT_BUFFER,
			OUTPUT_BUFFER,
			INPUT_VAR,
			OUTPUT_VAR,
			PORT,
			SIGNAL,
			MESSAGE,
			CHANNEL,
			BUFFER,
			RUNNABLE,
			ROUTINE,
			TRANSITION,
			STATE,
			STATEMACHINE,
			MODEL_MACHINE,
			PROTOTYPE_MACHINE,
			INSTANCE_MACHINE,
			MACHINE,
			SYSTEM,
			FILE_HEADER,
			FILE_BEGIN,
			FILE_END,
			TESTCASE_HEADER,
			TESTCASE_BEGIN,
			TESTCASE_END,
			INIT_HEADER,
			INIT_BEGIN,
			INIT_END,
			STEP_HEADER,
			STEP_BEGIN,
			STEP_END,
			COMMENT,
			SEPARATOR,
			NEWLINE,
			NEXT,
			LIFELINE,
			LIFELINE_HEADER,
			LIFELINE_BEGIN,
			LIFELINE_END,
			LIFELINE_ID,
			LIFELINE_STATE,
			RAW_ATTRIBUTE,
			EXECUTION_CONTEXT_ID,
			NODE,
			NODE_LABEL,
			NODE_HEADER,
			NODE_DATA,
			NODE_INFO,
			NODE_TRACE_RUN,
			NODE_TRACE_IO,
			VALUE_PARAMETER_BEGIN,
			VALUE_PARAMETER_SEPARATOR,
			VALUE_PARAMETER_END,
			VALUE_ARRAY_BEGIN,
			VALUE_ARRAY_SEPARATOR,
			VALUE_ARRAY_END,
			VALUE_STRUCT_BEGIN,
			VALUE_STRUCT_SEPARATOR,
			VALUE_STRUCT_END,
			META_TRACE,
			META_DEBUG,
			TIPS,
		};

	/**
	 * A public read-only list of all the '<em><b>Trace Element Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TraceElementKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Trace Element Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TraceElementKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TraceElementKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Element Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TraceElementKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TraceElementKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trace Element Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TraceElementKind get(int value) {
		switch (value) {
			case UNDEFINED_VALUE: return UNDEFINED;
			case CONDITION_VALUE: return CONDITION;
			case DECISION_VALUE: return DECISION;
			case FORMULA_VALUE: return FORMULA;
			case PATH_CONDITION_VALUE: return PATH_CONDITION;
			case PATH_CONDITION_LEAF_VALUE: return PATH_CONDITION_LEAF;
			case PATH_TIMED_CONDITION_VALUE: return PATH_TIMED_CONDITION;
			case PATH_TIMED_CONDITION_LEAF_VALUE: return PATH_TIMED_CONDITION_LEAF;
			case NODE_CONDITION_VALUE: return NODE_CONDITION;
			case NODE_CONDITION_LEAF_VALUE: return NODE_CONDITION_LEAF;
			case NODE_TIMED_CONDITION_VALUE: return NODE_TIMED_CONDITION;
			case NODE_TIMED_CONDITION_LEAF_VALUE: return NODE_TIMED_CONDITION_LEAF;
			case ASSIGN_VALUE: return ASSIGN;
			case DELTA_VALUE: return DELTA;
			case TIME_VALUE: return TIME;
			case VARIABLE_VALUE: return VARIABLE;
			case NEWFRESH_VALUE: return NEWFRESH;
			case COM_VALUE: return COM;
			case INOUT_VALUE: return INOUT;
			case INPUT_VALUE: return INPUT;
			case OUTPUT_VALUE: return OUTPUT;
			case INPUT_ENV_VALUE: return INPUT_ENV;
			case OUTPUT_ENV_VALUE: return OUTPUT_ENV;
			case INPUT_RDV_VALUE: return INPUT_RDV;
			case OUTPUT_RDV_VALUE: return OUTPUT_RDV;
			case INPUT_BUFFER_VALUE: return INPUT_BUFFER;
			case OUTPUT_BUFFER_VALUE: return OUTPUT_BUFFER;
			case INPUT_VAR_VALUE: return INPUT_VAR;
			case OUTPUT_VAR_VALUE: return OUTPUT_VAR;
			case PORT_VALUE: return PORT;
			case SIGNAL_VALUE: return SIGNAL;
			case MESSAGE_VALUE: return MESSAGE;
			case CHANNEL_VALUE: return CHANNEL;
			case BUFFER_VALUE: return BUFFER;
			case RUNNABLE_VALUE: return RUNNABLE;
			case ROUTINE_VALUE: return ROUTINE;
			case TRANSITION_VALUE: return TRANSITION;
			case STATE_VALUE: return STATE;
			case STATEMACHINE_VALUE: return STATEMACHINE;
			case MODEL_MACHINE_VALUE: return MODEL_MACHINE;
			case PROTOTYPE_MACHINE_VALUE: return PROTOTYPE_MACHINE;
			case INSTANCE_MACHINE_VALUE: return INSTANCE_MACHINE;
			case MACHINE_VALUE: return MACHINE;
			case SYSTEM_VALUE: return SYSTEM;
			case FILE_HEADER_VALUE: return FILE_HEADER;
			case FILE_BEGIN_VALUE: return FILE_BEGIN;
			case FILE_END_VALUE: return FILE_END;
			case TESTCASE_HEADER_VALUE: return TESTCASE_HEADER;
			case TESTCASE_BEGIN_VALUE: return TESTCASE_BEGIN;
			case TESTCASE_END_VALUE: return TESTCASE_END;
			case INIT_HEADER_VALUE: return INIT_HEADER;
			case INIT_BEGIN_VALUE: return INIT_BEGIN;
			case INIT_END_VALUE: return INIT_END;
			case STEP_HEADER_VALUE: return STEP_HEADER;
			case STEP_BEGIN_VALUE: return STEP_BEGIN;
			case STEP_END_VALUE: return STEP_END;
			case COMMENT_VALUE: return COMMENT;
			case SEPARATOR_VALUE: return SEPARATOR;
			case NEWLINE_VALUE: return NEWLINE;
			case NEXT_VALUE: return NEXT;
			case LIFELINE_VALUE: return LIFELINE;
			case LIFELINE_HEADER_VALUE: return LIFELINE_HEADER;
			case LIFELINE_BEGIN_VALUE: return LIFELINE_BEGIN;
			case LIFELINE_END_VALUE: return LIFELINE_END;
			case LIFELINE_ID_VALUE: return LIFELINE_ID;
			case LIFELINE_STATE_VALUE: return LIFELINE_STATE;
			case RAW_ATTRIBUTE_VALUE: return RAW_ATTRIBUTE;
			case EXECUTION_CONTEXT_ID_VALUE: return EXECUTION_CONTEXT_ID;
			case NODE_VALUE: return NODE;
			case NODE_LABEL_VALUE: return NODE_LABEL;
			case NODE_HEADER_VALUE: return NODE_HEADER;
			case NODE_DATA_VALUE: return NODE_DATA;
			case NODE_INFO_VALUE: return NODE_INFO;
			case NODE_TRACE_RUN_VALUE: return NODE_TRACE_RUN;
			case NODE_TRACE_IO_VALUE: return NODE_TRACE_IO;
			case VALUE_PARAMETER_BEGIN_VALUE: return VALUE_PARAMETER_BEGIN;
			case VALUE_PARAMETER_SEPARATOR_VALUE: return VALUE_PARAMETER_SEPARATOR;
			case VALUE_PARAMETER_END_VALUE: return VALUE_PARAMETER_END;
			case VALUE_ARRAY_BEGIN_VALUE: return VALUE_ARRAY_BEGIN;
			case VALUE_ARRAY_SEPARATOR_VALUE: return VALUE_ARRAY_SEPARATOR;
			case VALUE_ARRAY_END_VALUE: return VALUE_ARRAY_END;
			case VALUE_STRUCT_BEGIN_VALUE: return VALUE_STRUCT_BEGIN;
			case VALUE_STRUCT_SEPARATOR_VALUE: return VALUE_STRUCT_SEPARATOR;
			case VALUE_STRUCT_END_VALUE: return VALUE_STRUCT_END;
			case META_TRACE_VALUE: return META_TRACE;
			case META_DEBUG_VALUE: return META_DEBUG;
			case TIPS_VALUE: return TIPS;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TraceElementKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TraceElementKind
