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
package org.eclipse.efm.ecore.formalml.statemachine;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Moe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getMoc <em>Moc</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#isIsElse <em>Is Else</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getProbability <em>Probability</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransitionMoe()
 * @model
 * @generated
 */
public interface TransitionMoe extends EObject {
	/**
	 * Returns the value of the '<em><b>Moc</b></em>' attribute.
	 * The default value is <code>"simple"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoc}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.statemachine.TransitionMoc
	 * @see #setMoc(TransitionMoc)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransitionMoe_Moc()
	 * @model default="simple"
	 * @generated
	 */
	TransitionMoc getMoc();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getMoc <em>Moc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moc</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.statemachine.TransitionMoc
	 * @see #getMoc()
	 * @generated
	 */
	void setMoc(TransitionMoc value);

	/**
	 * Returns the value of the '<em><b>Is Else</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Else</em>' attribute.
	 * @see #setIsElse(boolean)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransitionMoe_IsElse()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsElse();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#isIsElse <em>Is Else</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Else</em>' attribute.
	 * @see #isIsElse()
	 * @generated
	 */
	void setIsElse(boolean value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransitionMoe_Priority()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(float)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransitionMoe_Probability()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	float getProbability();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(float value);

} // TransitionMoe
