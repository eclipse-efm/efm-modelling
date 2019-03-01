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
 * A representation of the literals of the enumeration '<em><b>Graph Exploration Strategy Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationStrategyKind()
 * @model
 * @generated
 */
public enum GraphExplorationStrategyKind implements Enumerator {
	/**
	 * The '<em><b>BEST FIRST SEARCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEST_FIRST_SEARCH_VALUE
	 * @generated
	 * @ordered
	 */
	BEST_FIRST_SEARCH(0, "BEST_FIRST_SEARCH", "BEST_FIRST_SEARCH"),

	/**
	 * The '<em><b>BREADTH FIRST SEARCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREADTH_FIRST_SEARCH_VALUE
	 * @generated
	 * @ordered
	 */
	BREADTH_FIRST_SEARCH(1, "BREADTH_FIRST_SEARCH", "BREADTH_FIRST_SEARCH"),

	/**
	 * The '<em><b>DEPTH FIRST SEARCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_FIRST_SEARCH_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_FIRST_SEARCH(2, "DEPTH_FIRST_SEARCH", "DEPTH_FIRST_SEARCH"),

	/**
	 * The '<em><b>RANDOM FIRST SEARCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RANDOM_FIRST_SEARCH_VALUE
	 * @generated
	 * @ordered
	 */
	RANDOM_FIRST_SEARCH(3, "RANDOM_FIRST_SEARCH", "RANDOM_FIRST_SEARCH"),

	/**
	 * The '<em><b>XFS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XFS_VALUE
	 * @generated
	 * @ordered
	 */
	XFS(4, "XFS", "XFS"),

	/**
	 * The '<em><b>FIRST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST(5, "FIRST", "FIRST"),

	/**
	 * The '<em><b>LAST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAST_VALUE
	 * @generated
	 * @ordered
	 */
	LAST(6, "LAST", "LAST"),

	/**
	 * The '<em><b>ALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_VALUE
	 * @generated
	 * @ordered
	 */
	ALL(7, "ALL", "ALL");

	/**
	 * The '<em><b>BEST FIRST SEARCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BEST FIRST SEARCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BEST_FIRST_SEARCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BEST_FIRST_SEARCH_VALUE = 0;

	/**
	 * The '<em><b>BREADTH FIRST SEARCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BREADTH FIRST SEARCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BREADTH_FIRST_SEARCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BREADTH_FIRST_SEARCH_VALUE = 1;

	/**
	 * The '<em><b>DEPTH FIRST SEARCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEPTH FIRST SEARCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEPTH_FIRST_SEARCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_FIRST_SEARCH_VALUE = 2;

	/**
	 * The '<em><b>RANDOM FIRST SEARCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RANDOM FIRST SEARCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RANDOM_FIRST_SEARCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RANDOM_FIRST_SEARCH_VALUE = 3;

	/**
	 * The '<em><b>XFS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XFS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XFS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XFS_VALUE = 4;

	/**
	 * The '<em><b>FIRST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIRST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_VALUE = 5;

	/**
	 * The '<em><b>LAST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LAST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LAST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LAST_VALUE = 6;

	/**
	 * The '<em><b>ALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_VALUE = 7;

	/**
	 * An array of all the '<em><b>Graph Exploration Strategy Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GraphExplorationStrategyKind[] VALUES_ARRAY =
		new GraphExplorationStrategyKind[] {
			BEST_FIRST_SEARCH,
			BREADTH_FIRST_SEARCH,
			DEPTH_FIRST_SEARCH,
			RANDOM_FIRST_SEARCH,
			XFS,
			FIRST,
			LAST,
			ALL,
		};

	/**
	 * A public read-only list of all the '<em><b>Graph Exploration Strategy Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GraphExplorationStrategyKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Graph Exploration Strategy Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphExplorationStrategyKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphExplorationStrategyKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Graph Exploration Strategy Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphExplorationStrategyKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphExplorationStrategyKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Graph Exploration Strategy Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphExplorationStrategyKind get(int value) {
		switch (value) {
			case BEST_FIRST_SEARCH_VALUE: return BEST_FIRST_SEARCH;
			case BREADTH_FIRST_SEARCH_VALUE: return BREADTH_FIRST_SEARCH;
			case DEPTH_FIRST_SEARCH_VALUE: return DEPTH_FIRST_SEARCH;
			case RANDOM_FIRST_SEARCH_VALUE: return RANDOM_FIRST_SEARCH;
			case XFS_VALUE: return XFS;
			case FIRST_VALUE: return FIRST;
			case LAST_VALUE: return LAST;
			case ALL_VALUE: return ALL;
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
	private GraphExplorationStrategyKind(int value, String name, String literal) {
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
	
} //GraphExplorationStrategyKind
