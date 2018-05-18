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
package org.eclipse.efm.ecore.formalml.infrastructure.impl;

import org.eclipse.efm.ecore.formalml.common.impl.AbstractElementImpl;

import org.eclipse.efm.ecore.formalml.datatype.CollectionType;

import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification;

import org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind;
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol;
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Com Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ComProtocolImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ComProtocolImpl#getCast <em>Cast</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ComProtocolImpl#getInner_buffer <em>Inner buffer</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ComProtocolImpl#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComProtocolImpl extends AbstractElementImpl implements ComProtocol {
	/**
	 * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final ComProtocolKind PROTOCOL_EDEFAULT = ComProtocolKind.NONE;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected ComProtocolKind protocol = PROTOCOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCast() <em>Cast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCast()
	 * @generated
	 * @ordered
	 */
	protected static final ComCastKind CAST_EDEFAULT = ComCastKind.NONE;

	/**
	 * The cached value of the '{@link #getCast() <em>Cast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCast()
	 * @generated
	 * @ordered
	 */
	protected ComCastKind cast = CAST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInner_buffer() <em>Inner buffer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInner_buffer()
	 * @generated
	 * @ordered
	 */
	protected CollectionType inner_buffer;

	/**
	 * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffer()
	 * @generated
	 * @ordered
	 */
	protected ValueElementSpecification buffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.COM_PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComProtocolKind getProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(ComProtocolKind newProtocol) {
		ComProtocolKind oldProtocol = protocol;
		protocol = newProtocol == null ? PROTOCOL_EDEFAULT : newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.COM_PROTOCOL__PROTOCOL, oldProtocol, protocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComCastKind getCast() {
		return cast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCast(ComCastKind newCast) {
		ComCastKind oldCast = cast;
		cast = newCast == null ? CAST_EDEFAULT : newCast;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.COM_PROTOCOL__CAST, oldCast, cast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionType getInner_buffer() {
		return inner_buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInner_buffer(CollectionType newInner_buffer, NotificationChain msgs) {
		CollectionType oldInner_buffer = inner_buffer;
		inner_buffer = newInner_buffer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER, oldInner_buffer, newInner_buffer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInner_buffer(CollectionType newInner_buffer) {
		if (newInner_buffer != inner_buffer) {
			NotificationChain msgs = null;
			if (inner_buffer != null)
				msgs = ((InternalEObject)inner_buffer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER, null, msgs);
			if (newInner_buffer != null)
				msgs = ((InternalEObject)newInner_buffer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER, null, msgs);
			msgs = basicSetInner_buffer(newInner_buffer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER, newInner_buffer, newInner_buffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueElementSpecification getBuffer() {
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBuffer(ValueElementSpecification newBuffer, NotificationChain msgs) {
		ValueElementSpecification oldBuffer = buffer;
		buffer = newBuffer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.COM_PROTOCOL__BUFFER, oldBuffer, newBuffer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuffer(ValueElementSpecification newBuffer) {
		if (newBuffer != buffer) {
			NotificationChain msgs = null;
			if (buffer != null)
				msgs = ((InternalEObject)buffer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.COM_PROTOCOL__BUFFER, null, msgs);
			if (newBuffer != null)
				msgs = ((InternalEObject)newBuffer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.COM_PROTOCOL__BUFFER, null, msgs);
			msgs = basicSetBuffer(newBuffer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.COM_PROTOCOL__BUFFER, newBuffer, newBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER:
				return basicSetInner_buffer(null, msgs);
			case InfrastructurePackage.COM_PROTOCOL__BUFFER:
				return basicSetBuffer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InfrastructurePackage.COM_PROTOCOL__PROTOCOL:
				return getProtocol();
			case InfrastructurePackage.COM_PROTOCOL__CAST:
				return getCast();
			case InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER:
				return getInner_buffer();
			case InfrastructurePackage.COM_PROTOCOL__BUFFER:
				return getBuffer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InfrastructurePackage.COM_PROTOCOL__PROTOCOL:
				setProtocol((ComProtocolKind)newValue);
				return;
			case InfrastructurePackage.COM_PROTOCOL__CAST:
				setCast((ComCastKind)newValue);
				return;
			case InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER:
				setInner_buffer((CollectionType)newValue);
				return;
			case InfrastructurePackage.COM_PROTOCOL__BUFFER:
				setBuffer((ValueElementSpecification)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InfrastructurePackage.COM_PROTOCOL__PROTOCOL:
				setProtocol(PROTOCOL_EDEFAULT);
				return;
			case InfrastructurePackage.COM_PROTOCOL__CAST:
				setCast(CAST_EDEFAULT);
				return;
			case InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER:
				setInner_buffer((CollectionType)null);
				return;
			case InfrastructurePackage.COM_PROTOCOL__BUFFER:
				setBuffer((ValueElementSpecification)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InfrastructurePackage.COM_PROTOCOL__PROTOCOL:
				return protocol != PROTOCOL_EDEFAULT;
			case InfrastructurePackage.COM_PROTOCOL__CAST:
				return cast != CAST_EDEFAULT;
			case InfrastructurePackage.COM_PROTOCOL__INNER_BUFFER:
				return inner_buffer != null;
			case InfrastructurePackage.COM_PROTOCOL__BUFFER:
				return buffer != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (protocol: ");
		result.append(protocol);
		result.append(", cast: ");
		result.append(cast);
		result.append(')');
		return result.toString();
	}

} //ComProtocolImpl
