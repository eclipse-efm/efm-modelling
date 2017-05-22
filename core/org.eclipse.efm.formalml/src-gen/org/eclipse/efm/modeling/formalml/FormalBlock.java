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
 *   <li>{@link org.eclipse.efm.modeling.formalml.FormalBlock#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.FormalBlock#getRoutingBehavior <em>Routing Behavior</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getFormalBlock()
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
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getFormalBlock_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.modeling.formalml.FormalBlock#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

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
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getFormalBlock_RoutingBehavior()
	 * @model ordered="false"
	 * @generated
	 */
	OpaqueBehavior getRoutingBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.modeling.formalml.FormalBlock#getRoutingBehavior <em>Routing Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Routing Behavior</em>' reference.
	 * @see #getRoutingBehavior()
	 * @generated
	 */
	void setRoutingBehavior(OpaqueBehavior value);

} // FormalBlock
