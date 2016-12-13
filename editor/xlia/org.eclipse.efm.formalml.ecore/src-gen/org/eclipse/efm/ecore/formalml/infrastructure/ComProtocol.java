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

import org.eclipse.efm.ecore.formalml.datatype.CollectionType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Com Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getCast <em>Cast</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getInner_buffer <em>Inner buffer</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getRef_buffer <em>Ref buffer</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getComProtocol()
 * @model
 * @generated
 */
public interface ComProtocol extends EObject {
	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind
	 * @see #setProtocol(ComProtocolKind)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getComProtocol_Protocol()
	 * @model
	 * @generated
	 */
	ComProtocolKind getProtocol();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getProtocol <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(ComProtocolKind value);

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
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getComProtocol_Cast()
	 * @model
	 * @generated
	 */
	ComCastKind getCast();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getCast <em>Cast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cast</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind
	 * @see #getCast()
	 * @generated
	 */
	void setCast(ComCastKind value);

	/**
	 * Returns the value of the '<em><b>Inner buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner buffer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner buffer</em>' containment reference.
	 * @see #setInner_buffer(CollectionType)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getComProtocol_Inner_buffer()
	 * @model containment="true"
	 * @generated
	 */
	CollectionType getInner_buffer();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getInner_buffer <em>Inner buffer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner buffer</em>' containment reference.
	 * @see #getInner_buffer()
	 * @generated
	 */
	void setInner_buffer(CollectionType value);

	/**
	 * Returns the value of the '<em><b>Ref buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref buffer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref buffer</em>' reference.
	 * @see #setRef_buffer(Buffer)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getComProtocol_Ref_buffer()
	 * @model
	 * @generated
	 */
	Buffer getRef_buffer();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getRef_buffer <em>Ref buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref buffer</em>' reference.
	 * @see #getRef_buffer()
	 * @generated
	 */
	void setRef_buffer(Buffer value);

} // ComProtocol
