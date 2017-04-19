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

import org.eclipse.efm.modeling.formalml.FormalBlock;
import org.eclipse.efm.modeling.formalml.FormalMLPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.FormalBlockImpl#getRoutingBehavior <em>Routing Behavior</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.FormalBlockImpl#getBaseClass <em>Base Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FormalBlockImpl extends MinimalEObjectImpl.Container implements FormalBlock {
	/**
	 * The cached value of the '{@link #getRoutingBehavior() <em>Routing Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutingBehavior()
	 * @generated
	 * @ordered
	 */
	protected OpaqueBehavior routingBehavior;

	/**
	 * The cached value of the '{@link #getBaseClass() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class baseClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormalBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormalMLPackage.Literals.FORMAL_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBehavior getRoutingBehavior() {
		if (routingBehavior != null && routingBehavior.eIsProxy()) {
			InternalEObject oldRoutingBehavior = (InternalEObject)routingBehavior;
			routingBehavior = (OpaqueBehavior)eResolveProxy(oldRoutingBehavior);
			if (routingBehavior != oldRoutingBehavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormalMLPackage.FORMAL_BLOCK__ROUTING_BEHAVIOR, oldRoutingBehavior, routingBehavior));
			}
		}
		return routingBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBehavior basicGetRoutingBehavior() {
		return routingBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoutingBehavior(OpaqueBehavior newRoutingBehavior) {
		OpaqueBehavior oldRoutingBehavior = routingBehavior;
		routingBehavior = newRoutingBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.FORMAL_BLOCK__ROUTING_BEHAVIOR, oldRoutingBehavior, routingBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBaseClass() {
		if (baseClass != null && baseClass.eIsProxy()) {
			InternalEObject oldBaseClass = (InternalEObject)baseClass;
			baseClass = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBaseClass);
			if (baseClass != oldBaseClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormalMLPackage.FORMAL_BLOCK__BASE_CLASS, oldBaseClass, baseClass));
			}
		}
		return baseClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBaseClass() {
		return baseClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseClass(org.eclipse.uml2.uml.Class newBaseClass) {
		org.eclipse.uml2.uml.Class oldBaseClass = baseClass;
		baseClass = newBaseClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.FORMAL_BLOCK__BASE_CLASS, oldBaseClass, baseClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormalMLPackage.FORMAL_BLOCK__ROUTING_BEHAVIOR:
				if (resolve) return getRoutingBehavior();
				return basicGetRoutingBehavior();
			case FormalMLPackage.FORMAL_BLOCK__BASE_CLASS:
				if (resolve) return getBaseClass();
				return basicGetBaseClass();
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
			case FormalMLPackage.FORMAL_BLOCK__ROUTING_BEHAVIOR:
				setRoutingBehavior((OpaqueBehavior)newValue);
				return;
			case FormalMLPackage.FORMAL_BLOCK__BASE_CLASS:
				setBaseClass((org.eclipse.uml2.uml.Class)newValue);
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
			case FormalMLPackage.FORMAL_BLOCK__ROUTING_BEHAVIOR:
				setRoutingBehavior((OpaqueBehavior)null);
				return;
			case FormalMLPackage.FORMAL_BLOCK__BASE_CLASS:
				setBaseClass((org.eclipse.uml2.uml.Class)null);
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
			case FormalMLPackage.FORMAL_BLOCK__ROUTING_BEHAVIOR:
				return routingBehavior != null;
			case FormalMLPackage.FORMAL_BLOCK__BASE_CLASS:
				return baseClass != null;
		}
		return super.eIsSet(featureID);
	}

} //FormalBlockImpl