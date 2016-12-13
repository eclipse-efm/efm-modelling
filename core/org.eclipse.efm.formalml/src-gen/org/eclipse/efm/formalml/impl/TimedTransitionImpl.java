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

import org.eclipse.efm.formalml.TimedTransition;
import org.eclipse.efm.formalml.formalmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.formalml.impl.TimedTransitionImpl#getTguard <em>Tguard</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.impl.TimedTransitionImpl#getBase_Transition <em>Base Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimedTransitionImpl extends MinimalEObjectImpl.Container implements TimedTransition {
	/**
	 * The cached value of the '{@link #getTguard() <em>Tguard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTguard()
	 * @generated
	 * @ordered
	 */
	protected Constraint tguard;

	/**
	 * The cached value of the '{@link #getBase_Transition() <em>Base Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Transition()
	 * @generated
	 * @ordered
	 */
	protected Transition base_Transition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimedTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return formalmlPackage.Literals.TIMED_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getTguard() {
		if (tguard != null && tguard.eIsProxy()) {
			InternalEObject oldTguard = (InternalEObject)tguard;
			tguard = (Constraint)eResolveProxy(oldTguard);
			if (tguard != oldTguard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, formalmlPackage.TIMED_TRANSITION__TGUARD, oldTguard, tguard));
			}
		}
		return tguard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint basicGetTguard() {
		return tguard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTguard(Constraint newTguard) {
		Constraint oldTguard = tguard;
		tguard = newTguard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, formalmlPackage.TIMED_TRANSITION__TGUARD, oldTguard, tguard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getBase_Transition() {
		if (base_Transition != null && base_Transition.eIsProxy()) {
			InternalEObject oldBase_Transition = (InternalEObject)base_Transition;
			base_Transition = (Transition)eResolveProxy(oldBase_Transition);
			if (base_Transition != oldBase_Transition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, formalmlPackage.TIMED_TRANSITION__BASE_TRANSITION, oldBase_Transition, base_Transition));
			}
		}
		return base_Transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition basicGetBase_Transition() {
		return base_Transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Transition(Transition newBase_Transition) {
		Transition oldBase_Transition = base_Transition;
		base_Transition = newBase_Transition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, formalmlPackage.TIMED_TRANSITION__BASE_TRANSITION, oldBase_Transition, base_Transition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case formalmlPackage.TIMED_TRANSITION__TGUARD:
				if (resolve) return getTguard();
				return basicGetTguard();
			case formalmlPackage.TIMED_TRANSITION__BASE_TRANSITION:
				if (resolve) return getBase_Transition();
				return basicGetBase_Transition();
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
			case formalmlPackage.TIMED_TRANSITION__TGUARD:
				setTguard((Constraint)newValue);
				return;
			case formalmlPackage.TIMED_TRANSITION__BASE_TRANSITION:
				setBase_Transition((Transition)newValue);
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
			case formalmlPackage.TIMED_TRANSITION__TGUARD:
				setTguard((Constraint)null);
				return;
			case formalmlPackage.TIMED_TRANSITION__BASE_TRANSITION:
				setBase_Transition((Transition)null);
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
			case formalmlPackage.TIMED_TRANSITION__TGUARD:
				return tguard != null;
			case formalmlPackage.TIMED_TRANSITION__BASE_TRANSITION:
				return base_Transition != null;
		}
		return super.eIsSet(featureID);
	}

} //TimedTransitionImpl
