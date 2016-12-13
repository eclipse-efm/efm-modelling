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
package org.eclipse.efm.ecore.formalml.impl;

import org.eclipse.efm.ecore.formalml.FormalmlPackage;
import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.ecore.formalml.XliaObject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xlia Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.impl.XliaModelImpl#getProlog <em>Prolog</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.impl.XliaModelImpl#getSystem <em>System</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XliaModelImpl extends MinimalEObjectImpl.Container implements XliaModel {
	/**
	 * The cached value of the '{@link #getProlog() <em>Prolog</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProlog()
	 * @generated
	 * @ordered
	 */
	protected XliaObject prolog;

	/**
	 * The cached value of the '{@link #getSystem() <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.efm.ecore.formalml.infrastructure.System system;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XliaModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormalmlPackage.Literals.XLIA_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XliaObject getProlog() {
		return prolog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProlog(XliaObject newProlog, NotificationChain msgs) {
		XliaObject oldProlog = prolog;
		prolog = newProlog;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormalmlPackage.XLIA_MODEL__PROLOG, oldProlog, newProlog);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProlog(XliaObject newProlog) {
		if (newProlog != prolog) {
			NotificationChain msgs = null;
			if (prolog != null)
				msgs = ((InternalEObject)prolog).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormalmlPackage.XLIA_MODEL__PROLOG, null, msgs);
			if (newProlog != null)
				msgs = ((InternalEObject)newProlog).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormalmlPackage.XLIA_MODEL__PROLOG, null, msgs);
			msgs = basicSetProlog(newProlog, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalmlPackage.XLIA_MODEL__PROLOG, newProlog, newProlog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.efm.ecore.formalml.infrastructure.System getSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(org.eclipse.efm.ecore.formalml.infrastructure.System newSystem, NotificationChain msgs) {
		org.eclipse.efm.ecore.formalml.infrastructure.System oldSystem = system;
		system = newSystem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormalmlPackage.XLIA_MODEL__SYSTEM, oldSystem, newSystem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(org.eclipse.efm.ecore.formalml.infrastructure.System newSystem) {
		if (newSystem != system) {
			NotificationChain msgs = null;
			if (system != null)
				msgs = ((InternalEObject)system).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormalmlPackage.XLIA_MODEL__SYSTEM, null, msgs);
			if (newSystem != null)
				msgs = ((InternalEObject)newSystem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormalmlPackage.XLIA_MODEL__SYSTEM, null, msgs);
			msgs = basicSetSystem(newSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalmlPackage.XLIA_MODEL__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FormalmlPackage.XLIA_MODEL__PROLOG:
				return basicSetProlog(null, msgs);
			case FormalmlPackage.XLIA_MODEL__SYSTEM:
				return basicSetSystem(null, msgs);
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
			case FormalmlPackage.XLIA_MODEL__PROLOG:
				return getProlog();
			case FormalmlPackage.XLIA_MODEL__SYSTEM:
				return getSystem();
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
			case FormalmlPackage.XLIA_MODEL__PROLOG:
				setProlog((XliaObject)newValue);
				return;
			case FormalmlPackage.XLIA_MODEL__SYSTEM:
				setSystem((org.eclipse.efm.ecore.formalml.infrastructure.System)newValue);
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
			case FormalmlPackage.XLIA_MODEL__PROLOG:
				setProlog((XliaObject)null);
				return;
			case FormalmlPackage.XLIA_MODEL__SYSTEM:
				setSystem((org.eclipse.efm.ecore.formalml.infrastructure.System)null);
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
			case FormalmlPackage.XLIA_MODEL__PROLOG:
				return prolog != null;
			case FormalmlPackage.XLIA_MODEL__SYSTEM:
				return system != null;
		}
		return super.eIsSet(featureID);
	}

} //XliaModelImpl
