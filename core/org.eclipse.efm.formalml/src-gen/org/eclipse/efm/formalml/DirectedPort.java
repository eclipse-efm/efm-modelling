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

import org.eclipse.uml2.uml.Port;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directed Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.formalml.DirectedPort#getBasePort <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.DirectedPort#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.formalml.formalmlPackage#getDirectedPort()
 * @model
 * @generated
 */
public interface DirectedPort extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBasePort(Port)
	 * @see org.eclipse.efm.formalml.formalmlPackage#getDirectedPort_BasePort()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='base_Port'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='extension_FlowPort'"
	 * @generated
	 */
	Port getBasePort();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.DirectedPort#getBasePort <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Port</em>' reference.
	 * @see #getBasePort()
	 * @generated
	 */
	void setBasePort(Port value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.formalml.PortDirectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.efm.formalml.PortDirectionKind
	 * @see #setDirection(PortDirectionKind)
	 * @see org.eclipse.efm.formalml.formalmlPackage#getDirectedPort_Direction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PortDirectionKind getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.DirectedPort#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.efm.formalml.PortDirectionKind
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(PortDirectionKind value);

} // DirectedPort
