/**
 * Copyright (c) 2020 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html\n\nContributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.statement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Meta Statement Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getMetaStatementKind()
 * @model
 * @generated
 */
public enum MetaStatementKind implements Enumerator {
	/**
	 * The '<em><b>Informal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INFORMAL_VALUE
	 * @generated
	 * @ordered
	 */
	INFORMAL(0, "informal", "informal"),

	/**
	 * The '<em><b>Trace</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACE_VALUE
	 * @generated
	 * @ordered
	 */
	TRACE(1, "trace", "trace"),

	/**
	 * The '<em><b>Debug</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEBUG_VALUE
	 * @generated
	 * @ordered
	 */
	DEBUG(2, "debug", "debug"),

	/**
	 * The '<em><b>Comment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMENT_VALUE
	 * @generated
	 * @ordered
	 */
	COMMENT(3, "comment", "comment"),

	/**
	 * The '<em><b>Quote</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUOTE_VALUE
	 * @generated
	 * @ordered
	 */
	QUOTE(4, "quote", "quote"),

	/**
	 * The '<em><b>Eval</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVAL_VALUE
	 * @generated
	 * @ordered
	 */
	EVAL(5, "eval", "eval"),

	/**
	 * The '<em><b>Run</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUN_VALUE
	 * @generated
	 * @ordered
	 */
	RUN(6, "run", "run");

	/**
	 * The '<em><b>Informal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INFORMAL
	 * @model name="informal"
	 * @generated
	 * @ordered
	 */
	public static final int INFORMAL_VALUE = 0;

	/**
	 * The '<em><b>Trace</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACE
	 * @model name="trace"
	 * @generated
	 * @ordered
	 */
	public static final int TRACE_VALUE = 1;

	/**
	 * The '<em><b>Debug</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEBUG
	 * @model name="debug"
	 * @generated
	 * @ordered
	 */
	public static final int DEBUG_VALUE = 2;

	/**
	 * The '<em><b>Comment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMENT
	 * @model name="comment"
	 * @generated
	 * @ordered
	 */
	public static final int COMMENT_VALUE = 3;

	/**
	 * The '<em><b>Quote</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUOTE
	 * @model name="quote"
	 * @generated
	 * @ordered
	 */
	public static final int QUOTE_VALUE = 4;

	/**
	 * The '<em><b>Eval</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVAL
	 * @model name="eval"
	 * @generated
	 * @ordered
	 */
	public static final int EVAL_VALUE = 5;

	/**
	 * The '<em><b>Run</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUN
	 * @model name="run"
	 * @generated
	 * @ordered
	 */
	public static final int RUN_VALUE = 6;

	/**
	 * An array of all the '<em><b>Meta Statement Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MetaStatementKind[] VALUES_ARRAY =
		new MetaStatementKind[] {
			INFORMAL,
			TRACE,
			DEBUG,
			COMMENT,
			QUOTE,
			EVAL,
			RUN,
		};

	/**
	 * A public read-only list of all the '<em><b>Meta Statement Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MetaStatementKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Meta Statement Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetaStatementKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MetaStatementKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Meta Statement Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetaStatementKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MetaStatementKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Meta Statement Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetaStatementKind get(int value) {
		switch (value) {
			case INFORMAL_VALUE: return INFORMAL;
			case TRACE_VALUE: return TRACE;
			case DEBUG_VALUE: return DEBUG;
			case COMMENT_VALUE: return COMMENT;
			case QUOTE_VALUE: return QUOTE;
			case EVAL_VALUE: return EVAL;
			case RUN_VALUE: return RUN;
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
	private MetaStatementKind(int value, String name, String literal) {
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
	
} //MetaStatementKind
