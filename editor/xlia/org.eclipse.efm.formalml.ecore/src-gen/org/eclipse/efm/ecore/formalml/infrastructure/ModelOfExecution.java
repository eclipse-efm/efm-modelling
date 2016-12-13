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
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.infrastructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Of Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getInitRoutine <em>Init Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getFinalRoutine <em>Final Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getEnableRoutine <em>Enable Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getDisableRoutine <em>Disable Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getConcurrencyRoutine <em>Concurrency Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getScheduleRoutine <em>Schedule Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getIrunRoutine <em>Irun Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getRunRoutine <em>Run Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getRoutine <em>Routine</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution()
 * @model
 * @generated
 */
public interface ModelOfExecution extends EObject {
	/**
	 * Returns the value of the '<em><b>Init Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Routine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Routine</em>' containment reference.
	 * @see #setInitRoutine(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_InitRoutine()
	 * @model containment="true"
	 * @generated
	 */
	Routine getInitRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getInitRoutine <em>Init Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Routine</em>' containment reference.
	 * @see #getInitRoutine()
	 * @generated
	 */
	void setInitRoutine(Routine value);

	/**
	 * Returns the value of the '<em><b>Final Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final Routine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Routine</em>' containment reference.
	 * @see #setFinalRoutine(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_FinalRoutine()
	 * @model containment="true"
	 * @generated
	 */
	Routine getFinalRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getFinalRoutine <em>Final Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final Routine</em>' containment reference.
	 * @see #getFinalRoutine()
	 * @generated
	 */
	void setFinalRoutine(Routine value);

	/**
	 * Returns the value of the '<em><b>Enable Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Routine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Routine</em>' containment reference.
	 * @see #setEnableRoutine(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_EnableRoutine()
	 * @model containment="true"
	 * @generated
	 */
	Routine getEnableRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getEnableRoutine <em>Enable Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Routine</em>' containment reference.
	 * @see #getEnableRoutine()
	 * @generated
	 */
	void setEnableRoutine(Routine value);

	/**
	 * Returns the value of the '<em><b>Disable Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disable Routine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disable Routine</em>' containment reference.
	 * @see #setDisableRoutine(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_DisableRoutine()
	 * @model containment="true"
	 * @generated
	 */
	Routine getDisableRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getDisableRoutine <em>Disable Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disable Routine</em>' containment reference.
	 * @see #getDisableRoutine()
	 * @generated
	 */
	void setDisableRoutine(Routine value);

	/**
	 * Returns the value of the '<em><b>Concurrency Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concurrency Routine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concurrency Routine</em>' containment reference.
	 * @see #setConcurrencyRoutine(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_ConcurrencyRoutine()
	 * @model containment="true"
	 * @generated
	 */
	Routine getConcurrencyRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getConcurrencyRoutine <em>Concurrency Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concurrency Routine</em>' containment reference.
	 * @see #getConcurrencyRoutine()
	 * @generated
	 */
	void setConcurrencyRoutine(Routine value);

	/**
	 * Returns the value of the '<em><b>Schedule Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Routine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Routine</em>' containment reference.
	 * @see #setScheduleRoutine(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_ScheduleRoutine()
	 * @model containment="true"
	 * @generated
	 */
	Routine getScheduleRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getScheduleRoutine <em>Schedule Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Routine</em>' containment reference.
	 * @see #getScheduleRoutine()
	 * @generated
	 */
	void setScheduleRoutine(Routine value);

	/**
	 * Returns the value of the '<em><b>Irun Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Irun Routine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Irun Routine</em>' containment reference.
	 * @see #setIrunRoutine(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_IrunRoutine()
	 * @model containment="true"
	 * @generated
	 */
	Routine getIrunRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getIrunRoutine <em>Irun Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Irun Routine</em>' containment reference.
	 * @see #getIrunRoutine()
	 * @generated
	 */
	void setIrunRoutine(Routine value);

	/**
	 * Returns the value of the '<em><b>Run Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run Routine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run Routine</em>' containment reference.
	 * @see #setRunRoutine(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_RunRoutine()
	 * @model containment="true"
	 * @generated
	 */
	Routine getRunRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getRunRoutine <em>Run Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run Routine</em>' containment reference.
	 * @see #getRunRoutine()
	 * @generated
	 */
	void setRunRoutine(Routine value);

	/**
	 * Returns the value of the '<em><b>Routine</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Routine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routine</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routine</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfExecution_Routine()
	 * @model containment="true"
	 * @generated
	 */
	EList<Routine> getRoutine();

} // ModelOfExecution
