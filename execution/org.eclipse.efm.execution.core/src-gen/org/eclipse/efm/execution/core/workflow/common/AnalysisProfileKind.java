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
 * A representation of the literals of the enumeration '<em><b>Analysis Profile Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getAnalysisProfileKind()
 * @model
 * @generated
 */
public enum AnalysisProfileKind implements Enumerator {
	/**
	 * The '<em><b>ANALYSIS UNDEFINED PROFILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_UNDEFINED_PROFILE_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYSIS_UNDEFINED_PROFILE(0, "ANALYSIS_UNDEFINED_PROFILE", "ANALYSIS_UNDEFINED_PROFILE"),

	/**
	 * The '<em><b>ANALYSIS EXPLORATION PROFILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_EXPLORATION_PROFILE_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYSIS_EXPLORATION_PROFILE(1, "ANALYSIS_EXPLORATION_PROFILE", "Exploration"),

	/**
	 * The '<em><b>ANALYSIS TRANSITION COVERAGE PROFILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_TRANSITION_COVERAGE_PROFILE_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYSIS_TRANSITION_COVERAGE_PROFILE(2, "ANALYSIS_TRANSITION_COVERAGE_PROFILE", "Transition Coverage"),

	/**
	 * The '<em><b>ANALYSIS BEHAVIOR SELECTION PROFILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_BEHAVIOR_SELECTION_PROFILE_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYSIS_BEHAVIOR_SELECTION_PROFILE(3, "ANALYSIS_BEHAVIOR_SELECTION_PROFILE", "Behavior Selection"),

	/**
	 * The '<em><b>ANALYSIS TEST OFFLINE PROFILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_TEST_OFFLINE_PROFILE_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYSIS_TEST_OFFLINE_PROFILE(4, "ANALYSIS_TEST_OFFLINE_PROFILE", "Test Offline"),

	/**
	 * The '<em><b>ANALYSIS ACSL GENERATION PROFILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_ACSL_GENERATION_PROFILE_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYSIS_ACSL_GENERATION_PROFILE(5, "ANALYSIS_ACSL_GENERATION_PROFILE", "Inference"),

	/**
	 * The '<em><b>ANALYSIS EXTRANEOUS PROFILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_EXTRANEOUS_PROFILE_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYSIS_EXTRANEOUS_PROFILE(10, "ANALYSIS_EXTRANEOUS_PROFILE", "Extra");

	/**
	 * The '<em><b>ANALYSIS UNDEFINED PROFILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYSIS UNDEFINED PROFILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_UNDEFINED_PROFILE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANALYSIS_UNDEFINED_PROFILE_VALUE = 0;

	/**
	 * The '<em><b>ANALYSIS EXPLORATION PROFILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYSIS EXPLORATION PROFILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_EXPLORATION_PROFILE
	 * @model literal="Exploration"
	 * @generated
	 * @ordered
	 */
	public static final int ANALYSIS_EXPLORATION_PROFILE_VALUE = 1;

	/**
	 * The '<em><b>ANALYSIS TRANSITION COVERAGE PROFILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYSIS TRANSITION COVERAGE PROFILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_TRANSITION_COVERAGE_PROFILE
	 * @model literal="Transition Coverage"
	 * @generated
	 * @ordered
	 */
	public static final int ANALYSIS_TRANSITION_COVERAGE_PROFILE_VALUE = 2;

	/**
	 * The '<em><b>ANALYSIS BEHAVIOR SELECTION PROFILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYSIS BEHAVIOR SELECTION PROFILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_BEHAVIOR_SELECTION_PROFILE
	 * @model literal="Behavior Selection"
	 * @generated
	 * @ordered
	 */
	public static final int ANALYSIS_BEHAVIOR_SELECTION_PROFILE_VALUE = 3;

	/**
	 * The '<em><b>ANALYSIS TEST OFFLINE PROFILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYSIS TEST OFFLINE PROFILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_TEST_OFFLINE_PROFILE
	 * @model literal="Test Offline"
	 * @generated
	 * @ordered
	 */
	public static final int ANALYSIS_TEST_OFFLINE_PROFILE_VALUE = 4;

	/**
	 * The '<em><b>ANALYSIS ACSL GENERATION PROFILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYSIS ACSL GENERATION PROFILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_ACSL_GENERATION_PROFILE
	 * @model literal="Inference"
	 * @generated
	 * @ordered
	 */
	public static final int ANALYSIS_ACSL_GENERATION_PROFILE_VALUE = 5;

	/**
	 * The '<em><b>ANALYSIS EXTRANEOUS PROFILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYSIS EXTRANEOUS PROFILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYSIS_EXTRANEOUS_PROFILE
	 * @model literal="Extra"
	 * @generated
	 * @ordered
	 */
	public static final int ANALYSIS_EXTRANEOUS_PROFILE_VALUE = 10;

	/**
	 * An array of all the '<em><b>Analysis Profile Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AnalysisProfileKind[] VALUES_ARRAY =
		new AnalysisProfileKind[] {
			ANALYSIS_UNDEFINED_PROFILE,
			ANALYSIS_EXPLORATION_PROFILE,
			ANALYSIS_TRANSITION_COVERAGE_PROFILE,
			ANALYSIS_BEHAVIOR_SELECTION_PROFILE,
			ANALYSIS_TEST_OFFLINE_PROFILE,
			ANALYSIS_ACSL_GENERATION_PROFILE,
			ANALYSIS_EXTRANEOUS_PROFILE,
		};

	/**
	 * A public read-only list of all the '<em><b>Analysis Profile Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AnalysisProfileKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Analysis Profile Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AnalysisProfileKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnalysisProfileKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Analysis Profile Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AnalysisProfileKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnalysisProfileKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Analysis Profile Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AnalysisProfileKind get(int value) {
		switch (value) {
			case ANALYSIS_UNDEFINED_PROFILE_VALUE: return ANALYSIS_UNDEFINED_PROFILE;
			case ANALYSIS_EXPLORATION_PROFILE_VALUE: return ANALYSIS_EXPLORATION_PROFILE;
			case ANALYSIS_TRANSITION_COVERAGE_PROFILE_VALUE: return ANALYSIS_TRANSITION_COVERAGE_PROFILE;
			case ANALYSIS_BEHAVIOR_SELECTION_PROFILE_VALUE: return ANALYSIS_BEHAVIOR_SELECTION_PROFILE;
			case ANALYSIS_TEST_OFFLINE_PROFILE_VALUE: return ANALYSIS_TEST_OFFLINE_PROFILE;
			case ANALYSIS_ACSL_GENERATION_PROFILE_VALUE: return ANALYSIS_ACSL_GENERATION_PROFILE;
			case ANALYSIS_EXTRANEOUS_PROFILE_VALUE: return ANALYSIS_EXTRANEOUS_PROFILE;
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
	private AnalysisProfileKind(int value, String name, String literal) {
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
	
} //AnalysisProfileKind
