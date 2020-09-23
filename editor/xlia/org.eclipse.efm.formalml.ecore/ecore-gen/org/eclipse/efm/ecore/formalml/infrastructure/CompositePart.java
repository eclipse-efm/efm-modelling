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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getRoutine <em>Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getMachine <em>Machine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getBehavior <em>Behavior</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getCompositePart()
 * @model
 * @generated
 */
public interface CompositePart extends EObject {
	/**
	 * Returns the value of the '<em><b>Routine</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Routine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routine</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getCompositePart_Routine()
	 * @model containment="true"
	 * @generated
	 */
	EList<Routine> getRoutine();

	/**
	 * Returns the value of the '<em><b>Procedure</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Procedure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getCompositePart_Procedure()
	 * @model containment="true"
	 * @generated
	 */
	EList<Procedure> getProcedure();

	/**
	 * Returns the value of the '<em><b>Machine</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Machine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getCompositePart_Machine()
	 * @model containment="true"
	 * @generated
	 */
	EList<Machine> getMachine();

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getCompositePart_Instance()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceMachine> getInstance();

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getCompositePart_Behavior()
	 * @model containment="true"
	 * @generated
	 */
	EList<Behavior> getBehavior();

} // CompositePart
