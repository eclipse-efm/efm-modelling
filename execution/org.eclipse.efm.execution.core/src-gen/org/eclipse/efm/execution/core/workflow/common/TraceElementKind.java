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
	UNDEFINED(1, "UNDEFINED", "undefined"),

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKNOWN(2, "UNKNOWN", "unknown"), /**
	 * The '<em><b>CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	CONDITION(0, "CONDITION", "condition"),

	/**
	 * The '<em><b>DECISION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECISION_VALUE
	 * @generated
	 * @ordered
	 */
	DECISION(0, "DECISION", "decision"),

	/**
	 * The '<em><b>FORMULA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORMULA_VALUE
	 * @generated
	 * @ordered
	 */
	FORMULA(0, "FORMULA", "formula"),

	/**
	 * The '<em><b>PATH CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATH_CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	PATH_CONDITION(0, "PATH_CONDITION", "path#condition"),

	/**
	 * The '<em><b>PATH CONDITION LEAF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATH_CONDITION_LEAF_VALUE
	 * @generated
	 * @ordered
	 */
	PATH_CONDITION_LEAF(0, "PATH_CONDITION_LEAF", "path#condition#leaf"),

	/**
	 * The '<em><b>PATH TIMED CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATH_TIMED_CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	PATH_TIMED_CONDITION(0, "PATH_TIMED_CONDITION", "path#timed#condition"),

	/**
	 * The '<em><b>PATH TIMED CONDITION LEAF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATH_TIMED_CONDITION_LEAF_VALUE
	 * @generated
	 * @ordered
	 */
	PATH_TIMED_CONDITION_LEAF(0, "PATH_TIMED_CONDITION_LEAF", "path#timed#condition#leaf"),

	/**
	 * The '<em><b>NODE CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_CONDITION(0, "NODE_CONDITION", "node#condition"),

	/**
	 * The '<em><b>NODE CONDITION LEAF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_CONDITION_LEAF_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_CONDITION_LEAF(0, "NODE_CONDITION_LEAF", "node#condition#leaf"),

	/**
	 * The '<em><b>NODE TIMED CONDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_TIMED_CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_TIMED_CONDITION(0, "NODE_TIMED_CONDITION", "node#timed#condition"),

	/**
	 * The '<em><b>NODE TIMED CONDITION LEAF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_TIMED_CONDITION_LEAF_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_TIMED_CONDITION_LEAF(0, "NODE_TIMED_CONDITION_LEAF", "node#timed#condition#leaf"),

	/**
	 * The '<em><b>ASSIGN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	ASSIGN(0, "ASSIGN", "assign"),

	/**
	 * The '<em><b>DELTA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELTA_VALUE
	 * @generated
	 * @ordered
	 */
	DELTA(0, "DELTA", "delta"),

	/**
	 * The '<em><b>TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME_VALUE
	 * @generated
	 * @ordered
	 */
	TIME(0, "TIME", "time"),

	/**
	 * The '<em><b>VARIABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	VARIABLE(0, "VARIABLE", "variable"),

	/**
	 * The '<em><b>NEWFRESH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEWFRESH_VALUE
	 * @generated
	 * @ordered
	 */
	NEWFRESH(0, "NEWFRESH", "newfresh"),

	/**
	 * The '<em><b>COM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COM_VALUE
	 * @generated
	 * @ordered
	 */
	COM(0, "COM", "com"),

	/**
	 * The '<em><b>INOUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INOUT_VALUE
	 * @generated
	 * @ordered
	 */
	INOUT(0, "INOUT", "inout"),

	/**
	 * The '<em><b>INPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT(0, "INPUT", "input"),

	/**
	 * The '<em><b>OUTPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT(0, "OUTPUT", "output"),

	/**
	 * The '<em><b>INPUT ENV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_ENV_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_ENV(0, "INPUT_ENV", "input#env"),

	/**
	 * The '<em><b>OUTPUT ENV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_ENV_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_ENV(0, "OUTPUT_ENV", "output#env"),

	/**
	 * The '<em><b>INPUT RDV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_RDV_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_RDV(0, "INPUT_RDV", "input#rdv"),

	/**
	 * The '<em><b>OUTPUT RDV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_RDV_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_RDV(0, "OUTPUT_RDV", "output#rdv"),

	/**
	 * The '<em><b>INPUT BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_BUFFER(0, "INPUT_BUFFER", "input#buffer"),

	/**
	 * The '<em><b>OUTPUT BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_BUFFER(0, "OUTPUT_BUFFER", "output#buffer"),

	/**
	 * The '<em><b>INPUT VAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_VAR_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_VAR(0, "INPUT_VAR", "input#var"),

	/**
	 * The '<em><b>OUTPUT VAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTPUT_VAR_VALUE
	 * @generated
	 * @ordered
	 */
	OUTPUT_VAR(0, "OUTPUT_VAR", "output#var"),

	/**
	 * The '<em><b>PORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PORT_VALUE
	 * @generated
	 * @ordered
	 */
	PORT(0, "PORT", "port"),

	/**
	 * The '<em><b>SIGNAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIGNAL_VALUE
	 * @generated
	 * @ordered
	 */
	SIGNAL(0, "SIGNAL", "signal"),

	/**
	 * The '<em><b>MESSAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE(0, "MESSAGE", "message"),

	/**
	 * The '<em><b>CHANNEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_VALUE
	 * @generated
	 * @ordered
	 */
	CHANNEL(0, "CHANNEL", "channel"),

	/**
	 * The '<em><b>BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	BUFFER(0, "BUFFER", "buffer"),

	/**
	 * The '<em><b>RUNNABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNNABLE_VALUE
	 * @generated
	 * @ordered
	 */
	RUNNABLE(0, "RUNNABLE", "runnable"),

	/**
	 * The '<em><b>ROUTINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUTINE_VALUE
	 * @generated
	 * @ordered
	 */
	ROUTINE(0, "ROUTINE", "routine"),

	/**
	 * The '<em><b>TRANSITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSITION_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSITION(0, "TRANSITION", "transition"),

	/**
	 * The '<em><b>MACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	MACHINE(0, "MACHINE", "machine"),

	/**
	 * The '<em><b>STATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE(0, "STATE", "state"),

	/**
	 * The '<em><b>STATEMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATEMACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	STATEMACHINE(0, "STATEMACHINE", "statemachine"),

	/**
	 * The '<em><b>SYSTEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM(0, "SYSTEM", "system"),

	/**
	 * The '<em><b>FILE HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	FILE_HEADER(0, "FILE_HEADER", "header"),

	/**
	 * The '<em><b>FILE BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	FILE_BEGIN(0, "FILE_BEGIN", "begin"),

	/**
	 * The '<em><b>FILE END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_END_VALUE
	 * @generated
	 * @ordered
	 */
	FILE_END(0, "FILE_END", "end"),

	/**
	 * The '<em><b>TESTCASE HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	TESTCASE_HEADER(0, "TESTCASE_HEADER", "testcase#header"),

	/**
	 * The '<em><b>TESTCASE BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	TESTCASE_BEGIN(0, "TESTCASE_BEGIN", "testcase#begin"),

	/**
	 * The '<em><b>TESTCASE END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESTCASE_END_VALUE
	 * @generated
	 * @ordered
	 */
	TESTCASE_END(0, "TESTCASE_END", "testcase#end"),

	/**
	 * The '<em><b>INIT HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INIT_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	INIT_HEADER(0, "INIT_HEADER", "init#header"),

	/**
	 * The '<em><b>INIT BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INIT_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	INIT_BEGIN(0, "INIT_BEGIN", "init#begin"),

	/**
	 * The '<em><b>INIT END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INIT_END_VALUE
	 * @generated
	 * @ordered
	 */
	INIT_END(0, "INIT_END", "init#end"),

	/**
	 * The '<em><b>STEP HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_HEADER(0, "STEP_HEADER", "step#header"),

	/**
	 * The '<em><b>STEP BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_BEGIN(0, "STEP_BEGIN", "step#begin"),

	/**
	 * The '<em><b>STEP END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_END_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_END(0, "STEP_END", "step#end"),

	/**
	 * The '<em><b>COMMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMENT_VALUE
	 * @generated
	 * @ordered
	 */
	COMMENT(0, "COMMENT", "comment"),

	/**
	 * The '<em><b>SEPARATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEPARATOR_VALUE
	 * @generated
	 * @ordered
	 */
	SEPARATOR(0, "SEPARATOR", "separator"),

	/**
	 * The '<em><b>NEWLINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEWLINE_VALUE
	 * @generated
	 * @ordered
	 */
	NEWLINE(0, "NEWLINE", "newline"),

	/**
	 * The '<em><b>NEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEXT_VALUE
	 * @generated
	 * @ordered
	 */
	NEXT(0, "NEXT", "next"), /**
	 * The '<em><b>LIFELINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE(0, "LIFELINE", "lifeline"), /**
	 * The '<em><b>LIFELINE HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_HEADER(0, "LIFELINE_HEADER", "lifeline#header"), /**
	 * The '<em><b>LIFELINE BEGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_BEGIN(0, "LIFELINE_BEGIN", "lifeline#begin"), /**
	 * The '<em><b>LIFELINE END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_END_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_END(0, "LIFELINE_END", "lifeline#end"), /**
	 * The '<em><b>LIFELINE ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_ID_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_ID(0, "LIFELINE_ID", "lifeline#id"), /**
	 * The '<em><b>LIFELINE STATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIFELINE_STATE_VALUE
	 * @generated
	 * @ordered
	 */
	LIFELINE_STATE(0, "LIFELINE_STATE", "lifeline#state");

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
	public static final int UNDEFINED_VALUE = 1;

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNKNOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @model literal="unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN_VALUE = 2;

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
	public static final int CONDITION_VALUE = 0;

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
	public static final int DECISION_VALUE = 0;

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
	public static final int FORMULA_VALUE = 0;

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
	public static final int PATH_CONDITION_VALUE = 0;

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
	public static final int PATH_CONDITION_LEAF_VALUE = 0;

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
	public static final int PATH_TIMED_CONDITION_VALUE = 0;

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
	public static final int PATH_TIMED_CONDITION_LEAF_VALUE = 0;

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
	public static final int NODE_CONDITION_VALUE = 0;

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
	public static final int NODE_CONDITION_LEAF_VALUE = 0;

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
	public static final int NODE_TIMED_CONDITION_VALUE = 0;

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
	public static final int NODE_TIMED_CONDITION_LEAF_VALUE = 0;

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
	public static final int ASSIGN_VALUE = 0;

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
	public static final int DELTA_VALUE = 0;

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
	public static final int TIME_VALUE = 0;

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
	public static final int VARIABLE_VALUE = 0;

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
	public static final int NEWFRESH_VALUE = 0;

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
	public static final int COM_VALUE = 0;

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
	public static final int INOUT_VALUE = 0;

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
	public static final int INPUT_VALUE = 0;

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
	public static final int OUTPUT_VALUE = 0;

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
	public static final int INPUT_ENV_VALUE = 0;

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
	public static final int OUTPUT_ENV_VALUE = 0;

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
	public static final int INPUT_RDV_VALUE = 0;

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
	public static final int OUTPUT_RDV_VALUE = 0;

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
	public static final int INPUT_BUFFER_VALUE = 0;

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
	public static final int OUTPUT_BUFFER_VALUE = 0;

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
	public static final int INPUT_VAR_VALUE = 0;

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
	public static final int OUTPUT_VAR_VALUE = 0;

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
	public static final int PORT_VALUE = 0;

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
	public static final int SIGNAL_VALUE = 0;

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
	public static final int MESSAGE_VALUE = 0;

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
	public static final int CHANNEL_VALUE = 0;

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
	public static final int BUFFER_VALUE = 0;

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
	public static final int RUNNABLE_VALUE = 0;

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
	public static final int ROUTINE_VALUE = 0;

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
	public static final int TRANSITION_VALUE = 0;

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
	public static final int MACHINE_VALUE = 0;

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
	public static final int STATE_VALUE = 0;

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
	public static final int STATEMACHINE_VALUE = 0;

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
	public static final int SYSTEM_VALUE = 0;

	/**
	 * The '<em><b>FILE HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILE HEADER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE_HEADER
	 * @model literal="header"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_HEADER_VALUE = 0;

	/**
	 * The '<em><b>FILE BEGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILE BEGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE_BEGIN
	 * @model literal="begin"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_BEGIN_VALUE = 0;

	/**
	 * The '<em><b>FILE END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FILE END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE_END
	 * @model literal="end"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_END_VALUE = 0;

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
	public static final int TESTCASE_HEADER_VALUE = 0;

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
	public static final int TESTCASE_BEGIN_VALUE = 0;

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
	public static final int TESTCASE_END_VALUE = 0;

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
	public static final int INIT_HEADER_VALUE = 0;

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
	public static final int INIT_BEGIN_VALUE = 0;

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
	public static final int INIT_END_VALUE = 0;

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
	public static final int STEP_HEADER_VALUE = 0;

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
	public static final int STEP_BEGIN_VALUE = 0;

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
	public static final int STEP_END_VALUE = 0;

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
	public static final int COMMENT_VALUE = 0;

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
	public static final int SEPARATOR_VALUE = 0;

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
	public static final int NEWLINE_VALUE = 0;

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
	public static final int NEXT_VALUE = 0;

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
	public static final int LIFELINE_VALUE = 0;

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
	public static final int LIFELINE_HEADER_VALUE = 0;

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
	public static final int LIFELINE_BEGIN_VALUE = 0;

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
	public static final int LIFELINE_END_VALUE = 0;

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
	public static final int LIFELINE_ID_VALUE = 0;

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
	public static final int LIFELINE_STATE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Trace Element Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TraceElementKind[] VALUES_ARRAY =
		new TraceElementKind[] {
			UNDEFINED,
			UNKNOWN,
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
			MACHINE,
			STATE,
			STATEMACHINE,
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
			case UNKNOWN_VALUE: return UNKNOWN;
			case CONDITION_VALUE: return CONDITION;
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
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
