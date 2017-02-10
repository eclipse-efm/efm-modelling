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

import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.formalml.FormalBlock#getBaseClass <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.FormalBlock#getRoutingBehavior <em>Routing Behavior</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.formalml.formalmlPackage#getFormalBlock()
 * @model abstract="true"
 * @generated
 */
public interface FormalBlock extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBaseClass(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.efm.formalml.formalmlPackage#getFormalBlock_BaseClass()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='base_Class'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='extension_FormalBlock'"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBaseClass();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.FormalBlock#getBaseClass <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBaseClass()
	 * @generated
	 */
	void setBaseClass(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Routing Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routing Behavior</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routing Behavior</em>' reference.
	 * @see #setRoutingBehavior(OpaqueBehavior)
	 * @see org.eclipse.efm.formalml.formalmlPackage#getFormalBlock_RoutingBehavior()
	 * @model ordered="false"
	 * @generated
	 */
	OpaqueBehavior getRoutingBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.FormalBlock#getRoutingBehavior <em>Routing Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Routing Behavior</em>' reference.
	 * @see #getRoutingBehavior()
	 * @generated
	 */
	void setRoutingBehavior(OpaqueBehavior value);

} // FormalBlock
