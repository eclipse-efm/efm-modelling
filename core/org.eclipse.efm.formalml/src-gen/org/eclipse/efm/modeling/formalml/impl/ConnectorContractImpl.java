/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.modeling.formalml.impl;

import org.eclipse.efm.modeling.formalml.ConnectorContract;
import org.eclipse.efm.modeling.formalml.FormalMLPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.ConnectorContractImpl#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectorContractImpl extends MinimalEObjectImpl.Container implements ConnectorContract {
	/**
	 * The cached value of the '{@link #getBase_OpaqueBehavior() <em>Base Opaque Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_OpaqueBehavior()
	 * @generated
	 * @ordered
	 */
	protected OpaqueBehavior base_OpaqueBehavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorContractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormalMLPackage.Literals.CONNECTOR_CONTRACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBehavior getBase_OpaqueBehavior() {
		if (base_OpaqueBehavior != null && base_OpaqueBehavior.eIsProxy()) {
			InternalEObject oldBase_OpaqueBehavior = (InternalEObject)base_OpaqueBehavior;
			base_OpaqueBehavior = (OpaqueBehavior)eResolveProxy(oldBase_OpaqueBehavior);
			if (base_OpaqueBehavior != oldBase_OpaqueBehavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormalMLPackage.CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR, oldBase_OpaqueBehavior, base_OpaqueBehavior));
			}
		}
		return base_OpaqueBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBehavior basicGetBase_OpaqueBehavior() {
		return base_OpaqueBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_OpaqueBehavior(OpaqueBehavior newBase_OpaqueBehavior) {
		OpaqueBehavior oldBase_OpaqueBehavior = base_OpaqueBehavior;
		base_OpaqueBehavior = newBase_OpaqueBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR, oldBase_OpaqueBehavior, base_OpaqueBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormalMLPackage.CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR:
				if (resolve) return getBase_OpaqueBehavior();
				return basicGetBase_OpaqueBehavior();
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
			case FormalMLPackage.CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR:
				setBase_OpaqueBehavior((OpaqueBehavior)newValue);
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
			case FormalMLPackage.CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR:
				setBase_OpaqueBehavior((OpaqueBehavior)null);
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
			case FormalMLPackage.CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR:
				return base_OpaqueBehavior != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectorContractImpl
