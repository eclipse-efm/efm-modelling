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
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getPrior <em>Prior</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getProba <em>Proba</em>}</li>
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
	 * <p>
	 * If the meaning of the '<em>Moc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Is Else</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * Returns the value of the '<em><b>Prior</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prior</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prior</em>' attribute.
	 * @see #setPrior(int)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransitionMoe_Prior()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPrior();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getPrior <em>Prior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prior</em>' attribute.
	 * @see #getPrior()
	 * @generated
	 */
	void setPrior(int value);

	/**
	 * Returns the value of the '<em><b>Proba</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proba</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proba</em>' attribute.
	 * @see #setProba(float)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransitionMoe_Proba()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	float getProba();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe#getProba <em>Proba</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proba</em>' attribute.
	 * @see #getProba()
	 * @generated
	 */
	void setProba(float value);

} // TransitionMoe
