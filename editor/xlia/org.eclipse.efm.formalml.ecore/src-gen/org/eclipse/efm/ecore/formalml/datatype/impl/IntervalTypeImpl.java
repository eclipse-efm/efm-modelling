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
import org.eclipse.efm.ecore.formalml.datatype.IntervalType;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interval Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.impl.IntervalTypeImpl#isLopen <em>Lopen</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.impl.IntervalTypeImpl#isRopen <em>Ropen</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.impl.IntervalTypeImpl#getInfimum <em>Infimum</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.impl.IntervalTypeImpl#getSupremum <em>Supremum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntervalTypeImpl extends DataSupportedTypeImpl implements IntervalType {
	/**
	 * The default value of the '{@link #isLopen() <em>Lopen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLopen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOPEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLopen() <em>Lopen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLopen()
	 * @generated
	 * @ordered
	 */
	protected boolean lopen = LOPEN_EDEFAULT;

	/**
	 * The default value of the '{@link #isRopen() <em>Ropen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRopen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ROPEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRopen() <em>Ropen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRopen()
	 * @generated
	 * @ordered
	 */
	protected boolean ropen = ROPEN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInfimum() <em>Infimum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfimum()
	 * @generated
	 * @ordered
	 */
	protected Expression infimum;

	/**
	 * The cached value of the '{@link #getSupremum() <em>Supremum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupremum()
	 * @generated
	 * @ordered
	 */
	protected Expression supremum;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntervalTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypePackage.Literals.INTERVAL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLopen() {
		return lopen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLopen(boolean newLopen) {
		boolean oldLopen = lopen;
		lopen = newLopen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypePackage.INTERVAL_TYPE__LOPEN, oldLopen, lopen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRopen() {
		return ropen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRopen(boolean newRopen) {
		boolean oldRopen = ropen;
		ropen = newRopen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypePackage.INTERVAL_TYPE__ROPEN, oldRopen, ropen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getInfimum() {
		return infimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInfimum(Expression newInfimum, NotificationChain msgs) {
		Expression oldInfimum = infimum;
		infimum = newInfimum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DatatypePackage.INTERVAL_TYPE__INFIMUM, oldInfimum, newInfimum);
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
	public void setInfimum(Expression newInfimum) {
		if (newInfimum != infimum) {
			NotificationChain msgs = null;
			if (infimum != null)
				msgs = ((InternalEObject)infimum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DatatypePackage.INTERVAL_TYPE__INFIMUM, null, msgs);
			if (newInfimum != null)
				msgs = ((InternalEObject)newInfimum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DatatypePackage.INTERVAL_TYPE__INFIMUM, null, msgs);
			msgs = basicSetInfimum(newInfimum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypePackage.INTERVAL_TYPE__INFIMUM, newInfimum, newInfimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getSupremum() {
		return supremum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSupremum(Expression newSupremum, NotificationChain msgs) {
		Expression oldSupremum = supremum;
		supremum = newSupremum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DatatypePackage.INTERVAL_TYPE__SUPREMUM, oldSupremum, newSupremum);
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
	public void setSupremum(Expression newSupremum) {
		if (newSupremum != supremum) {
			NotificationChain msgs = null;
			if (supremum != null)
				msgs = ((InternalEObject)supremum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DatatypePackage.INTERVAL_TYPE__SUPREMUM, null, msgs);
			if (newSupremum != null)
				msgs = ((InternalEObject)newSupremum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DatatypePackage.INTERVAL_TYPE__SUPREMUM, null, msgs);
			msgs = basicSetSupremum(newSupremum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypePackage.INTERVAL_TYPE__SUPREMUM, newSupremum, newSupremum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatatypePackage.INTERVAL_TYPE__INFIMUM:
				return basicSetInfimum(null, msgs);
			case DatatypePackage.INTERVAL_TYPE__SUPREMUM:
				return basicSetSupremum(null, msgs);
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
			case DatatypePackage.INTERVAL_TYPE__LOPEN:
				return isLopen();
			case DatatypePackage.INTERVAL_TYPE__ROPEN:
				return isRopen();
			case DatatypePackage.INTERVAL_TYPE__INFIMUM:
				return getInfimum();
			case DatatypePackage.INTERVAL_TYPE__SUPREMUM:
				return getSupremum();
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
			case DatatypePackage.INTERVAL_TYPE__LOPEN:
				setLopen((Boolean)newValue);
				return;
			case DatatypePackage.INTERVAL_TYPE__ROPEN:
				setRopen((Boolean)newValue);
				return;
			case DatatypePackage.INTERVAL_TYPE__INFIMUM:
				setInfimum((Expression)newValue);
				return;
			case DatatypePackage.INTERVAL_TYPE__SUPREMUM:
				setSupremum((Expression)newValue);
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
			case DatatypePackage.INTERVAL_TYPE__LOPEN:
				setLopen(LOPEN_EDEFAULT);
				return;
			case DatatypePackage.INTERVAL_TYPE__ROPEN:
				setRopen(ROPEN_EDEFAULT);
				return;
			case DatatypePackage.INTERVAL_TYPE__INFIMUM:
				setInfimum((Expression)null);
				return;
			case DatatypePackage.INTERVAL_TYPE__SUPREMUM:
				setSupremum((Expression)null);
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
			case DatatypePackage.INTERVAL_TYPE__LOPEN:
				return lopen != LOPEN_EDEFAULT;
			case DatatypePackage.INTERVAL_TYPE__ROPEN:
				return ropen != ROPEN_EDEFAULT;
			case DatatypePackage.INTERVAL_TYPE__INFIMUM:
				return infimum != null;
			case DatatypePackage.INTERVAL_TYPE__SUPREMUM:
				return supremum != null;
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
		result.append(" (lopen: ");
		result.append(lopen);
		result.append(", ropen: ");
		result.append(ropen);
		result.append(')');
		return result.toString();
	}

} //IntervalTypeImpl
