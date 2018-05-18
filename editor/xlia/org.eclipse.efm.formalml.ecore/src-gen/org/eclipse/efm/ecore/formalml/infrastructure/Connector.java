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

import org.eclipse.efm.ecore.formalml.common.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector#getCast <em>Cast</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector#getComPoints <em>Com Points</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getConnector()
 * @model
 * @generated
 */
public interface Connector extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' containment reference.
	 * @see #setProtocol(ComProtocol)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getConnector_Protocol()
	 * @model containment="true"
	 * @generated
	 */
	ComProtocol getProtocol();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector#getProtocol <em>Protocol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' containment reference.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(ComProtocol value);

	/**
	 * Returns the value of the '<em><b>Cast</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cast</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cast</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind
	 * @see #setCast(ComCastKind)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getConnector_Cast()
	 * @model
	 * @generated
	 */
	ComCastKind getCast();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector#getCast <em>Cast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cast</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind
	 * @see #getCast()
	 * @generated
	 */
	void setCast(ComCastKind value);

	/**
	 * Returns the value of the '<em><b>Com Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.ComPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Com Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Com Points</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getConnector_ComPoints()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ComPoint> getComPoints();

} // Connector
