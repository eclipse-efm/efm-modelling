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

import org.eclipse.efm.formalml.ReceiveAnyEvent;
import org.eclipse.efm.formalml.formalmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.AnyReceiveEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Receive Any Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.formalml.impl.ReceiveAnyEventImpl#getBaseAnyReceiveEvent <em>Base Any Receive Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReceiveAnyEventImpl extends ReceiveEventImpl implements ReceiveAnyEvent {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReceiveAnyEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return formalmlPackage.Literals.RECEIVE_ANY_EVENT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, formalmlPackage.RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT, oldBaseAnyReceiveEvent, baseAnyReceiveEvent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, formalmlPackage.RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT, oldBaseAnyReceiveEvent, baseAnyReceiveEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case formalmlPackage.RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT:
				if (resolve) return getBaseAnyReceiveEvent();
				return basicGetBaseAnyReceiveEvent();
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
			case formalmlPackage.RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT:
				setBaseAnyReceiveEvent((AnyReceiveEvent)newValue);
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
			case formalmlPackage.RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT:
				setBaseAnyReceiveEvent((AnyReceiveEvent)null);
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
			case formalmlPackage.RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT:
				return baseAnyReceiveEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //ReceiveAnyEventImpl
