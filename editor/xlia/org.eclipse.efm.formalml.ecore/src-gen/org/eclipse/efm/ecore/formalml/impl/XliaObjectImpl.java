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

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.FormalmlPackage;
import org.eclipse.efm.ecore.formalml.XliaNamedElement;
import org.eclipse.efm.ecore.formalml.XliaObject;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xlia Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.impl.XliaObjectImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.impl.XliaObjectImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XliaObjectImpl extends XliaNamedElementImpl implements XliaObject {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Expression value;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<XliaNamedElement> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XliaObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormalmlPackage.Literals.XLIA_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs) {
		Expression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormalmlPackage.XLIA_OBJECT__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Expression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormalmlPackage.XLIA_OBJECT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormalmlPackage.XLIA_OBJECT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalmlPackage.XLIA_OBJECT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XliaNamedElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<XliaNamedElement>(XliaNamedElement.class, this, FormalmlPackage.XLIA_OBJECT__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FormalmlPackage.XLIA_OBJECT__VALUE:
				return basicSetValue(null, msgs);
			case FormalmlPackage.XLIA_OBJECT__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case FormalmlPackage.XLIA_OBJECT__VALUE:
				return getValue();
			case FormalmlPackage.XLIA_OBJECT__ELEMENTS:
				return getElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FormalmlPackage.XLIA_OBJECT__VALUE:
				setValue((Expression)newValue);
				return;
			case FormalmlPackage.XLIA_OBJECT__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends XliaNamedElement>)newValue);
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
			case FormalmlPackage.XLIA_OBJECT__VALUE:
				setValue((Expression)null);
				return;
			case FormalmlPackage.XLIA_OBJECT__ELEMENTS:
				getElements().clear();
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
			case FormalmlPackage.XLIA_OBJECT__VALUE:
				return value != null;
			case FormalmlPackage.XLIA_OBJECT__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XliaObjectImpl
