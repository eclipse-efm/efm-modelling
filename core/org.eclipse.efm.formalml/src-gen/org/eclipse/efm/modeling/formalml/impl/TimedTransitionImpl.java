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
import org.eclipse.efm.modeling.formalml.TimedTransition;

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
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.TimedTransitionImpl#getTguard <em>Tguard</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.TimedTransitionImpl#getBaseTransition <em>Base Transition</em>}</li>
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
	 * The cached value of the '{@link #getBaseTransition() <em>Base Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseTransition()
	 * @generated
	 * @ordered
	 */
	protected Transition baseTransition;

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
		return FormalMLPackage.Literals.TIMED_TRANSITION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormalMLPackage.TIMED_TRANSITION__TGUARD, oldTguard, tguard));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.TIMED_TRANSITION__TGUARD, oldTguard, tguard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getBaseTransition() {
		if (baseTransition != null && baseTransition.eIsProxy()) {
			InternalEObject oldBaseTransition = (InternalEObject)baseTransition;
			baseTransition = (Transition)eResolveProxy(oldBaseTransition);
			if (baseTransition != oldBaseTransition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormalMLPackage.TIMED_TRANSITION__BASE_TRANSITION, oldBaseTransition, baseTransition));
			}
		}
		return baseTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition basicGetBaseTransition() {
		return baseTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseTransition(Transition newBaseTransition) {
		Transition oldBaseTransition = baseTransition;
		baseTransition = newBaseTransition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.TIMED_TRANSITION__BASE_TRANSITION, oldBaseTransition, baseTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormalMLPackage.TIMED_TRANSITION__TGUARD:
				if (resolve) return getTguard();
				return basicGetTguard();
			case FormalMLPackage.TIMED_TRANSITION__BASE_TRANSITION:
				if (resolve) return getBaseTransition();
				return basicGetBaseTransition();
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
			case FormalMLPackage.TIMED_TRANSITION__TGUARD:
				setTguard((Constraint)newValue);
				return;
			case FormalMLPackage.TIMED_TRANSITION__BASE_TRANSITION:
				setBaseTransition((Transition)newValue);
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
			case FormalMLPackage.TIMED_TRANSITION__TGUARD:
				setTguard((Constraint)null);
				return;
			case FormalMLPackage.TIMED_TRANSITION__BASE_TRANSITION:
				setBaseTransition((Transition)null);
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
			case FormalMLPackage.TIMED_TRANSITION__TGUARD:
				return tguard != null;
			case FormalMLPackage.TIMED_TRANSITION__BASE_TRANSITION:
				return baseTransition != null;
		}
		return super.eIsSet(featureID);
	}

} //TimedTransitionImpl
