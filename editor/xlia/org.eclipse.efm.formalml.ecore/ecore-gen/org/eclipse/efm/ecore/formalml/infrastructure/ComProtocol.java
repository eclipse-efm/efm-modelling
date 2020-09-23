/**
 * Copyright (c) 2020 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html\n\nContributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.infrastructure;

import org.eclipse.efm.ecore.formalml.common.AbstractElement;

import org.eclipse.efm.ecore.formalml.datatype.CollectionType;

import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification;

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
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getBufferRef <em>Buffer Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getComProtocol()
 * @model
 * @generated
 */
public interface ComProtocol extends AbstractElement {
	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind}.
	 * <!-- begin-user-doc -->
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
	 * Returns the value of the '<em><b>Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' containment reference.
	 * @see #setBuffer(ValueElementSpecification)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getComProtocol_Buffer()
	 * @model containment="true"
	 * @generated
	 */
	ValueElementSpecification getBuffer();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getBuffer <em>Buffer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' containment reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(ValueElementSpecification value);

	/**
	 * Returns the value of the '<em><b>Buffer Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Ref</em>' containment reference.
	 * @see #setBufferRef(LiteralReferenceSpecification)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getComProtocol_BufferRef()
	 * @model containment="true"
	 * @generated
	 */
	LiteralReferenceSpecification getBufferRef();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getBufferRef <em>Buffer Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Ref</em>' containment reference.
	 * @see #getBufferRef()
	 * @generated
	 */
	void setBufferRef(LiteralReferenceSpecification value);

} // ComProtocol
