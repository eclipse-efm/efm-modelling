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
package org.eclipse.efm.ecore.formalml.expression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>PRINTER FIX</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getPRINTER_FIX()
 * @model
 * @generated
 */
public enum PRINTER_FIX implements Enumerator {
	/**
	 * The '<em><b>Infix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INFIX_VALUE
	 * @generated
	 * @ordered
	 */
	INFIX(0, "infix", "infix"),

	/**
	 * The '<em><b>Prefix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFIX_VALUE
	 * @generated
	 * @ordered
	 */
	PREFIX(1, "prefix", "prefix"),

	/**
	 * The '<em><b>Suffix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUFFIX_VALUE
	 * @generated
	 * @ordered
	 */
	SUFFIX(2, "suffix", "suffix"),

	/**
	 * The '<em><b>Functional</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTIONAL(3, "functional", "functional"),

	/**
	 * The '<em><b>Specific</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIFIC_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIFIC(4, "specific", "specific");

	/**
	 * The '<em><b>Infix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INFIX
	 * @model name="infix"
	 * @generated
	 * @ordered
	 */
	public static final int INFIX_VALUE = 0;

	/**
	 * The '<em><b>Prefix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFIX
	 * @model name="prefix"
	 * @generated
	 * @ordered
	 */
	public static final int PREFIX_VALUE = 1;

	/**
	 * The '<em><b>Suffix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUFFIX
	 * @model name="suffix"
	 * @generated
	 * @ordered
	 */
	public static final int SUFFIX_VALUE = 2;

	/**
	 * The '<em><b>Functional</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTIONAL
	 * @model name="functional"
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTIONAL_VALUE = 3;

	/**
	 * The '<em><b>Specific</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIFIC
	 * @model name="specific"
	 * @generated
	 * @ordered
	 */
	public static final int SPECIFIC_VALUE = 4;

	/**
	 * An array of all the '<em><b>PRINTER FIX</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PRINTER_FIX[] VALUES_ARRAY =
		new PRINTER_FIX[] {
			INFIX,
			PREFIX,
			SUFFIX,
			FUNCTIONAL,
			SPECIFIC,
		};

	/**
	 * A public read-only list of all the '<em><b>PRINTER FIX</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PRINTER_FIX> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>PRINTER FIX</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PRINTER_FIX get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PRINTER_FIX result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>PRINTER FIX</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PRINTER_FIX getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PRINTER_FIX result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>PRINTER FIX</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PRINTER_FIX get(int value) {
		switch (value) {
			case INFIX_VALUE: return INFIX;
			case PREFIX_VALUE: return PREFIX;
			case SUFFIX_VALUE: return SUFFIX;
			case FUNCTIONAL_VALUE: return FUNCTIONAL;
			case SPECIFIC_VALUE: return SPECIFIC;
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
	private PRINTER_FIX(int value, String name, String literal) {
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
	
} //PRINTER_FIX
