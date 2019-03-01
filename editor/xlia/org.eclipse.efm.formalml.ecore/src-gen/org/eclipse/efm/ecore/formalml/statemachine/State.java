/**
 * Copyright (c) 2018 CEA LIST.
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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.State#isSimple <em>Simple</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.State#isComposite <em>Composite</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.State#isOrthogonal <em>Orthogonal</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.State#getRegion <em>Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getState()
 * @model
 * @generated
 */
public interface State extends Vertex {
	/**
	 * Returns the value of the '<em><b>Simple</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple</em>' attribute.
	 * @see #setSimple(boolean)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getState_Simple()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isSimple();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.State#isSimple <em>Simple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple</em>' attribute.
	 * @see #isSimple()
	 * @generated
	 */
	void setSimple(boolean value);

	/**
	 * Returns the value of the '<em><b>Composite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite</em>' attribute.
	 * @see #setComposite(boolean)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getState_Composite()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isComposite();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.State#isComposite <em>Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite</em>' attribute.
	 * @see #isComposite()
	 * @generated
	 */
	void setComposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Orthogonal</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orthogonal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orthogonal</em>' attribute.
	 * @see #setOrthogonal(boolean)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getState_Orthogonal()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isOrthogonal();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.State#isOrthogonal <em>Orthogonal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orthogonal</em>' attribute.
	 * @see #isOrthogonal()
	 * @generated
	 */
	void setOrthogonal(boolean value);

	/**
	 * Returns the value of the '<em><b>Region</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.statemachine.Region}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getState_Region()
	 * @model containment="true"
	 * @generated
	 */
	EList<Region> getRegion();

} // State
