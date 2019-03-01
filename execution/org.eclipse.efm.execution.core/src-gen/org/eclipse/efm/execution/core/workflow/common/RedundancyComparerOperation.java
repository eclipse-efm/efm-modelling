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
 * A representation of the literals of the enumeration '<em><b>Redundancy Comparer Operation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyComparerOperation()
 * @model
 * @generated
 */
public enum RedundancyComparerOperation implements Enumerator {
	/**
	 * The '<em><b>INCLUSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCLUSION_VALUE
	 * @generated
	 * @ordered
	 */
	INCLUSION(0, "INCLUSION", "INCLUSION"),

	/**
	 * The '<em><b>EQUALITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUALITY_VALUE
	 * @generated
	 * @ordered
	 */
	EQUALITY(1, "EQUALITY", "EQUALITY"),

	/**
	 * The '<em><b>SYNTAXIC EQUALITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNTAXIC_EQUALITY_VALUE
	 * @generated
	 * @ordered
	 */
	SYNTAXIC_EQUALITY(2, "SYNTAXIC_EQUALITY", "SYNTAXIC_EQUALITY"),

	/**
	 * The '<em><b>ALPHA EQUIVALENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALPHA_EQUIVALENCE_VALUE
	 * @generated
	 * @ordered
	 */
	ALPHA_EQUIVALENCE(3, "ALPHA_EQUIVALENCE", "ALPHA_EQUIVALENCE"),

	/**
	 * The '<em><b>TRIVIALLY EQUALITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIVIALLY_EQUALITY_VALUE
	 * @generated
	 * @ordered
	 */
	TRIVIALLY_EQUALITY(4, "TRIVIALLY_EQUALITY", "TRIVIALLY_EQUALITY"),

	/**
	 * The '<em><b>CONTROL STATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROL_STATE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTROL_STATE(5, "CONTROL_STATE", "CONTROL_STATE");

	/**
	 * The '<em><b>INCLUSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INCLUSION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INCLUSION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INCLUSION_VALUE = 0;

	/**
	 * The '<em><b>EQUALITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUALITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUALITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUALITY_VALUE = 1;

	/**
	 * The '<em><b>SYNTAXIC EQUALITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SYNTAXIC EQUALITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYNTAXIC_EQUALITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SYNTAXIC_EQUALITY_VALUE = 2;

	/**
	 * The '<em><b>ALPHA EQUIVALENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALPHA EQUIVALENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALPHA_EQUIVALENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALPHA_EQUIVALENCE_VALUE = 3;

	/**
	 * The '<em><b>TRIVIALLY EQUALITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIVIALLY EQUALITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIVIALLY_EQUALITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIVIALLY_EQUALITY_VALUE = 4;

	/**
	 * The '<em><b>CONTROL STATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTROL STATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTROL_STATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTROL_STATE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Redundancy Comparer Operation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RedundancyComparerOperation[] VALUES_ARRAY =
		new RedundancyComparerOperation[] {
			INCLUSION,
			EQUALITY,
			SYNTAXIC_EQUALITY,
			ALPHA_EQUIVALENCE,
			TRIVIALLY_EQUALITY,
			CONTROL_STATE,
		};

	/**
	 * A public read-only list of all the '<em><b>Redundancy Comparer Operation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RedundancyComparerOperation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Redundancy Comparer Operation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RedundancyComparerOperation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedundancyComparerOperation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redundancy Comparer Operation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RedundancyComparerOperation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedundancyComparerOperation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redundancy Comparer Operation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RedundancyComparerOperation get(int value) {
		switch (value) {
			case INCLUSION_VALUE: return INCLUSION;
			case EQUALITY_VALUE: return EQUALITY;
			case SYNTAXIC_EQUALITY_VALUE: return SYNTAXIC_EQUALITY;
			case ALPHA_EQUIVALENCE_VALUE: return ALPHA_EQUIVALENCE;
			case TRIVIALLY_EQUALITY_VALUE: return TRIVIALLY_EQUALITY;
			case CONTROL_STATE_VALUE: return CONTROL_STATE;
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
	private RedundancyComparerOperation(int value, String name, String literal) {
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
	
} //RedundancyComparerOperation
