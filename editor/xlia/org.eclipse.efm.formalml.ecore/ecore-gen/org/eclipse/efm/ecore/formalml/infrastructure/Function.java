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
package org.eclipse.efm.ecore.formalml.infrastructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Function#getParameterSet <em>Parameter Set</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Function#getResultSet <em>Result Set</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends PropertyDefinition {
	/**
	 * Returns the value of the '<em><b>Parameter Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Set</em>' containment reference.
	 * @see #setParameterSet(ParameterSet)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getFunction_ParameterSet()
	 * @model containment="true"
	 * @generated
	 */
	ParameterSet getParameterSet();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Function#getParameterSet <em>Parameter Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Set</em>' containment reference.
	 * @see #getParameterSet()
	 * @generated
	 */
	void setParameterSet(ParameterSet value);

	/**
	 * Returns the value of the '<em><b>Result Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Set</em>' containment reference.
	 * @see #setResultSet(ParameterSet)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getFunction_ResultSet()
	 * @model containment="true"
	 * @generated
	 */
	ParameterSet getResultSet();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Function#getResultSet <em>Result Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Set</em>' containment reference.
	 * @see #getResultSet()
	 * @generated
	 */
	void setResultSet(ParameterSet value);

} // Function
