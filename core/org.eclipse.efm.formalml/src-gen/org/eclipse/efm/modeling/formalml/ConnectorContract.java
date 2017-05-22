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
 * A representation of the model object '<em><b>Connector Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.modeling.formalml.ConnectorContract#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getConnectorContract()
 * @model
 * @generated
 */
public interface ConnectorContract extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Opaque Behavior</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Opaque Behavior</em>' reference.
	 * @see #setBase_OpaqueBehavior(OpaqueBehavior)
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getConnectorContract_Base_OpaqueBehavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OpaqueBehavior getBase_OpaqueBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.modeling.formalml.ConnectorContract#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Opaque Behavior</em>' reference.
	 * @see #getBase_OpaqueBehavior()
	 * @generated
	 */
	void setBase_OpaqueBehavior(OpaqueBehavior value);

} // ConnectorContract
