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
package org.eclipse.efm.ecore.formalml.specification.impl;

import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem;
import org.eclipse.efm.ecore.formalml.specification.SpecificationPackage;
import org.eclipse.efm.ecore.formalml.specification.XliaModel;
import org.eclipse.efm.ecore.formalml.specification.XliaObject;
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
 *   <li>{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaModelImpl#getProlog <em>Prolog</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaModelImpl#getSystem <em>System</em>}</li>
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
	protected XliaSystem system;

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
		return SpecificationPackage.Literals.XLIA_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XliaObject getProlog() {
		return prolog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProlog(final XliaObject newProlog, NotificationChain msgs) {
		final XliaObject oldProlog = prolog;
		prolog = newProlog;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpecificationPackage.XLIA_MODEL__PROLOG, oldProlog, newProlog);
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
	public void setProlog(final XliaObject newProlog) {
		if (newProlog != prolog) {
			NotificationChain msgs = null;
			if (prolog != null)
				msgs = ((InternalEObject)prolog).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpecificationPackage.XLIA_MODEL__PROLOG, null, msgs);
			if (newProlog != null)
				msgs = ((InternalEObject)newProlog).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpecificationPackage.XLIA_MODEL__PROLOG, null, msgs);
			msgs = basicSetProlog(newProlog, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.XLIA_MODEL__PROLOG, newProlog, newProlog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XliaSystem getSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(final XliaSystem newSystem, NotificationChain msgs) {
		final XliaSystem oldSystem = system;
		system = newSystem;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpecificationPackage.XLIA_MODEL__SYSTEM, oldSystem, newSystem);
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
	public void setSystem(final XliaSystem newSystem) {
		if (newSystem != system) {
			NotificationChain msgs = null;
			if (system != null)
				msgs = ((InternalEObject)system).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpecificationPackage.XLIA_MODEL__SYSTEM, null, msgs);
			if (newSystem != null)
				msgs = ((InternalEObject)newSystem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpecificationPackage.XLIA_MODEL__SYSTEM, null, msgs);
			msgs = basicSetSystem(newSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.XLIA_MODEL__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
		switch (featureID) {
			case SpecificationPackage.XLIA_MODEL__PROLOG:
				return basicSetProlog(null, msgs);
			case SpecificationPackage.XLIA_MODEL__SYSTEM:
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
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
			case SpecificationPackage.XLIA_MODEL__PROLOG:
				return getProlog();
			case SpecificationPackage.XLIA_MODEL__SYSTEM:
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
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
			case SpecificationPackage.XLIA_MODEL__PROLOG:
				setProlog((XliaObject)newValue);
				return;
			case SpecificationPackage.XLIA_MODEL__SYSTEM:
				setSystem((XliaSystem)newValue);
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
	public void eUnset(final int featureID) {
		switch (featureID) {
			case SpecificationPackage.XLIA_MODEL__PROLOG:
				setProlog((XliaObject)null);
				return;
			case SpecificationPackage.XLIA_MODEL__SYSTEM:
				setSystem((XliaSystem)null);
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
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
			case SpecificationPackage.XLIA_MODEL__PROLOG:
				return prolog != null;
			case SpecificationPackage.XLIA_MODEL__SYSTEM:
				return system != null;
		}
		return super.eIsSet(featureID);
	}

} //XliaModelImpl
