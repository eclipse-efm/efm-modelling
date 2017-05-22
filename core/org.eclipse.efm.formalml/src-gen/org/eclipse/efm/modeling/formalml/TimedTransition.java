/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.modeling.formalml;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.modeling.formalml.TimedTransition#getTguard <em>Tguard</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.TimedTransition#getBase_Transition <em>Base Transition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getTimedTransition()
 * @model
 * @generated
 */
public interface TimedTransition extends EObject {
	/**
	 * Returns the value of the '<em><b>Tguard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tguard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tguard</em>' reference.
	 * @see #setTguard(Constraint)
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getTimedTransition_Tguard()
	 * @model ordered="false"
	 * @generated
	 */
	Constraint getTguard();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.modeling.formalml.TimedTransition#getTguard <em>Tguard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tguard</em>' reference.
	 * @see #getTguard()
	 * @generated
	 */
	void setTguard(Constraint value);

	/**
	 * Returns the value of the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Transition</em>' reference.
	 * @see #setBase_Transition(Transition)
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getTimedTransition_Base_Transition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Transition getBase_Transition();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.modeling.formalml.TimedTransition#getBase_Transition <em>Base Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Transition</em>' reference.
	 * @see #getBase_Transition()
	 * @generated
	 */
	void setBase_Transition(Transition value);

} // TimedTransition
