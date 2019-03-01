/**
 * Copyright (c) 2018 CEA LIST.
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
package org.eclipse.efm.ecore.formalml.datatype.impl;

import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Time Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTimeTypeImpl#isClock <em>Clock</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTimeTypeImpl#getSupport <em>Support</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveTimeTypeImpl extends PrimitiveNumberTypeImpl implements PrimitiveTimeType {
	/**
	 * The default value of the '{@link #isClock() <em>Clock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClock()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLOCK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClock() <em>Clock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClock()
	 * @generated
	 * @ordered
	 */
	protected boolean clock = CLOCK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupport() <em>Support</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupport()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveNumberType support;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTimeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypePackage.Literals.PRIMITIVE_TIME_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isClock() {
		return clock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClock(boolean newClock) {
		boolean oldClock = clock;
		clock = newClock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypePackage.PRIMITIVE_TIME_TYPE__CLOCK, oldClock, clock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveNumberType getSupport() {
		return support;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSupport(PrimitiveNumberType newSupport, NotificationChain msgs) {
		PrimitiveNumberType oldSupport = support;
		support = newSupport;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT, oldSupport, newSupport);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSupport(PrimitiveNumberType newSupport) {
		if (newSupport != support) {
			NotificationChain msgs = null;
			if (support != null)
				msgs = ((InternalEObject)support).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT, null, msgs);
			if (newSupport != null)
				msgs = ((InternalEObject)newSupport).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT, null, msgs);
			msgs = basicSetSupport(newSupport, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT, newSupport, newSupport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT:
				return basicSetSupport(null, msgs);
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
			case DatatypePackage.PRIMITIVE_TIME_TYPE__CLOCK:
				return isClock();
			case DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT:
				return getSupport();
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
			case DatatypePackage.PRIMITIVE_TIME_TYPE__CLOCK:
				setClock((Boolean)newValue);
				return;
			case DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT:
				setSupport((PrimitiveNumberType)newValue);
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
			case DatatypePackage.PRIMITIVE_TIME_TYPE__CLOCK:
				setClock(CLOCK_EDEFAULT);
				return;
			case DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT:
				setSupport((PrimitiveNumberType)null);
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
			case DatatypePackage.PRIMITIVE_TIME_TYPE__CLOCK:
				return clock != CLOCK_EDEFAULT;
			case DatatypePackage.PRIMITIVE_TIME_TYPE__SUPPORT:
				return support != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (clock: ");
		result.append(clock);
		result.append(')');
		return result.toString();
	}

} //PrimitiveTimeTypeImpl
