/**
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
 */
package org.eclipse.efm.runconfiguration.workflow.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Heuristic Class Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.runconfiguration.workflow.common.CommonPackage#getHeuristicClassKind()
 * @model
 * @generated
 */
public enum HeuristicClassKind implements Enumerator {
	/**
	 * The '<em><b>BASIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASIC_VALUE
	 * @generated
	 * @ordered
	 */
	BASIC(0, "BASIC", "BASIC"),

	/**
	 * The '<em><b>NAIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAIVE_VALUE
	 * @generated
	 * @ordered
	 */
	NAIVE(1, "NAIVE", "NAIVE"),

	/**
	 * The '<em><b>SMART</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMART_VALUE
	 * @generated
	 * @ordered
	 */
	SMART(2, "SMART", "SMART"),

	/**
	 * The '<em><b>AGRESSIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGRESSIVE_VALUE
	 * @generated
	 * @ordered
	 */
	AGRESSIVE(3, "AGRESSIVE", "AGRESSIVE"),

	/**
	 * The '<em><b>NOTHING ELSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTHING_ELSE_VALUE
	 * @generated
	 * @ordered
	 */
	NOTHING_ELSE(4, "NOTHING_ELSE", "NOTHING_ELSE");

	/**
	 * The '<em><b>BASIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BASIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BASIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BASIC_VALUE = 0;

	/**
	 * The '<em><b>NAIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NAIVE_VALUE = 1;

	/**
	 * The '<em><b>SMART</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMART</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMART
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMART_VALUE = 2;

	/**
	 * The '<em><b>AGRESSIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AGRESSIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGRESSIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AGRESSIVE_VALUE = 3;

	/**
	 * The '<em><b>NOTHING ELSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTHING ELSE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTHING_ELSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTHING_ELSE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Heuristic Class Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HeuristicClassKind[] VALUES_ARRAY =
		new HeuristicClassKind[] {
			BASIC,
			NAIVE,
			SMART,
			AGRESSIVE,
			NOTHING_ELSE,
		};

	/**
	 * A public read-only list of all the '<em><b>Heuristic Class Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<HeuristicClassKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Heuristic Class Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HeuristicClassKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HeuristicClassKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Heuristic Class Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HeuristicClassKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HeuristicClassKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Heuristic Class Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HeuristicClassKind get(int value) {
		switch (value) {
			case BASIC_VALUE: return BASIC;
			case NAIVE_VALUE: return NAIVE;
			case SMART_VALUE: return SMART;
			case AGRESSIVE_VALUE: return AGRESSIVE;
			case NOTHING_ELSE_VALUE: return NOTHING_ELSE;
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
	private HeuristicClassKind(int value, String name, String literal) {
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
	
} //HeuristicClassKind
