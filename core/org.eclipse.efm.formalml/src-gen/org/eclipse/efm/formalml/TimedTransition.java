/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml;

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
 *   <li>{@link org.eclipse.efm.formalml.TimedTransition#getTguard <em>Tguard</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.TimedTransition#getBaseTransition <em>Base Transition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.formalml.formalmlPackage#getTimedTransition()
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
	 * @see org.eclipse.efm.formalml.formalmlPackage#getTimedTransition_Tguard()
	 * @model ordered="false"
	 * @generated
	 */
	Constraint getTguard();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.TimedTransition#getTguard <em>Tguard</em>}' reference.
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
	 * @see #setBaseTransition(Transition)
	 * @see org.eclipse.efm.formalml.formalmlPackage#getTimedTransition_BaseTransition()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='base_Transition'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='extension_Transition'"
	 * @generated
	 */
	Transition getBaseTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.TimedTransition#getBaseTransition <em>Base Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Transition</em>' reference.
	 * @see #getBaseTransition()
	 * @generated
	 */
	void setBaseTransition(Transition value);

} // TimedTransition
