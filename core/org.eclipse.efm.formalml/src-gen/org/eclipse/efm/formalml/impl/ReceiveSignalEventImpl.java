/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml.impl;

import org.eclipse.efm.formalml.ReceiveSignalEvent;
import org.eclipse.efm.formalml.formalmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Receive Signal Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.formalml.impl.ReceiveSignalEventImpl#getBase_AnyReceiveEvent <em>Base Any Receive Event</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.impl.ReceiveSignalEventImpl#getBase_SignalEvent <em>Base Signal Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReceiveSignalEventImpl extends ReceiveEventImpl implements ReceiveSignalEvent {
	/**
	 * The cached value of the '{@link #getBase_AnyReceiveEvent() <em>Base Any Receive Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_AnyReceiveEvent()
	 * @generated
	 * @ordered
	 */
	protected AnyReceiveEvent base_AnyReceiveEvent;

	/**
	 * The cached value of the '{@link #getBase_SignalEvent() <em>Base Signal Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_SignalEvent()
	 * @generated
	 * @ordered
	 */
	protected SignalEvent base_SignalEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReceiveSignalEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return formalmlPackage.Literals.RECEIVE_SIGNAL_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyReceiveEvent getBase_AnyReceiveEvent() {
		if (base_AnyReceiveEvent != null && base_AnyReceiveEvent.eIsProxy()) {
			InternalEObject oldBase_AnyReceiveEvent = (InternalEObject)base_AnyReceiveEvent;
			base_AnyReceiveEvent = (AnyReceiveEvent)eResolveProxy(oldBase_AnyReceiveEvent);
			if (base_AnyReceiveEvent != oldBase_AnyReceiveEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT, oldBase_AnyReceiveEvent, base_AnyReceiveEvent));
			}
		}
		return base_AnyReceiveEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyReceiveEvent basicGetBase_AnyReceiveEvent() {
		return base_AnyReceiveEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_AnyReceiveEvent(AnyReceiveEvent newBase_AnyReceiveEvent) {
		AnyReceiveEvent oldBase_AnyReceiveEvent = base_AnyReceiveEvent;
		base_AnyReceiveEvent = newBase_AnyReceiveEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT, oldBase_AnyReceiveEvent, base_AnyReceiveEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalEvent getBase_SignalEvent() {
		if (base_SignalEvent != null && base_SignalEvent.eIsProxy()) {
			InternalEObject oldBase_SignalEvent = (InternalEObject)base_SignalEvent;
			base_SignalEvent = (SignalEvent)eResolveProxy(oldBase_SignalEvent);
			if (base_SignalEvent != oldBase_SignalEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT, oldBase_SignalEvent, base_SignalEvent));
			}
		}
		return base_SignalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalEvent basicGetBase_SignalEvent() {
		return base_SignalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_SignalEvent(SignalEvent newBase_SignalEvent) {
		SignalEvent oldBase_SignalEvent = base_SignalEvent;
		base_SignalEvent = newBase_SignalEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT, oldBase_SignalEvent, base_SignalEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT:
				if (resolve) return getBase_AnyReceiveEvent();
				return basicGetBase_AnyReceiveEvent();
			case formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT:
				if (resolve) return getBase_SignalEvent();
				return basicGetBase_SignalEvent();
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
			case formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT:
				setBase_AnyReceiveEvent((AnyReceiveEvent)newValue);
				return;
			case formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT:
				setBase_SignalEvent((SignalEvent)newValue);
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
			case formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT:
				setBase_AnyReceiveEvent((AnyReceiveEvent)null);
				return;
			case formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT:
				setBase_SignalEvent((SignalEvent)null);
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
			case formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT:
				return base_AnyReceiveEvent != null;
			case formalmlPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT:
				return base_SignalEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //ReceiveSignalEventImpl
