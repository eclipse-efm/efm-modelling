/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.modeling.formalml.impl;

import org.eclipse.efm.modeling.formalml.FormalMLPackage;
import org.eclipse.efm.modeling.formalml.ReceiveSignalEvent;

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
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.ReceiveSignalEventImpl#getBaseAnyReceiveEvent <em>Base Any Receive Event</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.ReceiveSignalEventImpl#getBaseSignalEvent <em>Base Signal Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReceiveSignalEventImpl extends ReceiveEventImpl implements ReceiveSignalEvent {
	/**
	 * The cached value of the '{@link #getBaseAnyReceiveEvent() <em>Base Any Receive Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseAnyReceiveEvent()
	 * @generated
	 * @ordered
	 */
	protected AnyReceiveEvent baseAnyReceiveEvent;

	/**
	 * The cached value of the '{@link #getBaseSignalEvent() <em>Base Signal Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseSignalEvent()
	 * @generated
	 * @ordered
	 */
	protected SignalEvent baseSignalEvent;

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
		return FormalMLPackage.Literals.RECEIVE_SIGNAL_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyReceiveEvent getBaseAnyReceiveEvent() {
		if (baseAnyReceiveEvent != null && baseAnyReceiveEvent.eIsProxy()) {
			InternalEObject oldBaseAnyReceiveEvent = (InternalEObject)baseAnyReceiveEvent;
			baseAnyReceiveEvent = (AnyReceiveEvent)eResolveProxy(oldBaseAnyReceiveEvent);
			if (baseAnyReceiveEvent != oldBaseAnyReceiveEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT, oldBaseAnyReceiveEvent, baseAnyReceiveEvent));
			}
		}
		return baseAnyReceiveEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyReceiveEvent basicGetBaseAnyReceiveEvent() {
		return baseAnyReceiveEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseAnyReceiveEvent(AnyReceiveEvent newBaseAnyReceiveEvent) {
		AnyReceiveEvent oldBaseAnyReceiveEvent = baseAnyReceiveEvent;
		baseAnyReceiveEvent = newBaseAnyReceiveEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT, oldBaseAnyReceiveEvent, baseAnyReceiveEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalEvent getBaseSignalEvent() {
		if (baseSignalEvent != null && baseSignalEvent.eIsProxy()) {
			InternalEObject oldBaseSignalEvent = (InternalEObject)baseSignalEvent;
			baseSignalEvent = (SignalEvent)eResolveProxy(oldBaseSignalEvent);
			if (baseSignalEvent != oldBaseSignalEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT, oldBaseSignalEvent, baseSignalEvent));
			}
		}
		return baseSignalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalEvent basicGetBaseSignalEvent() {
		return baseSignalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseSignalEvent(SignalEvent newBaseSignalEvent) {
		SignalEvent oldBaseSignalEvent = baseSignalEvent;
		baseSignalEvent = newBaseSignalEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT, oldBaseSignalEvent, baseSignalEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT:
				if (resolve) return getBaseAnyReceiveEvent();
				return basicGetBaseAnyReceiveEvent();
			case FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT:
				if (resolve) return getBaseSignalEvent();
				return basicGetBaseSignalEvent();
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
			case FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT:
				setBaseAnyReceiveEvent((AnyReceiveEvent)newValue);
				return;
			case FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT:
				setBaseSignalEvent((SignalEvent)newValue);
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
			case FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT:
				setBaseAnyReceiveEvent((AnyReceiveEvent)null);
				return;
			case FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT:
				setBaseSignalEvent((SignalEvent)null);
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
			case FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT:
				return baseAnyReceiveEvent != null;
			case FormalMLPackage.RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT:
				return baseSignalEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //ReceiveSignalEventImpl
