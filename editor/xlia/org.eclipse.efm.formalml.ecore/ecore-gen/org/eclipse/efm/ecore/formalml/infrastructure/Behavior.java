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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getComputation <em>Computation</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getExecution <em>Execution</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getInteraction <em>Interaction</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getBehavior()
 * @model
 * @generated
 */
public interface Behavior extends Machine {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getBehavior_Parameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameter();

	/**
	 * Returns the value of the '<em><b>Computation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation</em>' containment reference.
	 * @see #setComputation(ModelOfComputation)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getBehavior_Computation()
	 * @model containment="true"
	 * @generated
	 */
	ModelOfComputation getComputation();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getComputation <em>Computation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computation</em>' containment reference.
	 * @see #getComputation()
	 * @generated
	 */
	void setComputation(ModelOfComputation value);

	/**
	 * Returns the value of the '<em><b>Execution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution</em>' containment reference.
	 * @see #setExecution(ModelOfExecution)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getBehavior_Execution()
	 * @model containment="true"
	 * @generated
	 */
	ModelOfExecution getExecution();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getExecution <em>Execution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution</em>' containment reference.
	 * @see #getExecution()
	 * @generated
	 */
	void setExecution(ModelOfExecution value);

	/**
	 * Returns the value of the '<em><b>Interaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction</em>' containment reference.
	 * @see #setInteraction(ModelOfInteraction)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getBehavior_Interaction()
	 * @model containment="true"
	 * @generated
	 */
	ModelOfInteraction getInteraction();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getInteraction <em>Interaction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction</em>' containment reference.
	 * @see #getInteraction()
	 * @generated
	 */
	void setInteraction(ModelOfInteraction value);

} // Behavior
