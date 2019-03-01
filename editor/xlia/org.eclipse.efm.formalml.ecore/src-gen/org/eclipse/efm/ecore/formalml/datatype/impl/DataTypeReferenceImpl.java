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

import org.eclipse.efm.ecore.formalml.datatype.DataType;
import org.eclipse.efm.ecore.formalml.datatype.DataTypeReference;
import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeReferenceImpl#getTyperef <em>Typeref</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeReferenceImpl#getSupport <em>Support</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataTypeReferenceImpl extends DataTypeImpl implements DataTypeReference {
	/**
	 * The cached value of the '{@link #getTyperef() <em>Typeref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTyperef()
	 * @generated
	 * @ordered
	 */
	protected DataType typeref;

	/**
	 * The cached value of the '{@link #getSupport() <em>Support</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupport()
	 * @generated
	 * @ordered
	 */
	protected DataType support;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypePackage.Literals.DATA_TYPE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getTyperef() {
		if (typeref != null && typeref.eIsProxy()) {
			InternalEObject oldTyperef = (InternalEObject)typeref;
			typeref = (DataType)eResolveProxy(oldTyperef);
			if (typeref != oldTyperef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypePackage.DATA_TYPE_REFERENCE__TYPEREF, oldTyperef, typeref));
			}
		}
		return typeref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetTyperef() {
		return typeref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTyperef(DataType newTyperef) {
		DataType oldTyperef = typeref;
		typeref = newTyperef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypePackage.DATA_TYPE_REFERENCE__TYPEREF, oldTyperef, typeref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getSupport() {
		return support;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSupport(DataType newSupport, NotificationChain msgs) {
		DataType oldSupport = support;
		support = newSupport;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT, oldSupport, newSupport);
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
	public void setSupport(DataType newSupport) {
		if (newSupport != support) {
			NotificationChain msgs = null;
			if (support != null)
				msgs = ((InternalEObject)support).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT, null, msgs);
			if (newSupport != null)
				msgs = ((InternalEObject)newSupport).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT, null, msgs);
			msgs = basicSetSupport(newSupport, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT, newSupport, newSupport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT:
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
			case DatatypePackage.DATA_TYPE_REFERENCE__TYPEREF:
				if (resolve) return getTyperef();
				return basicGetTyperef();
			case DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT:
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
			case DatatypePackage.DATA_TYPE_REFERENCE__TYPEREF:
				setTyperef((DataType)newValue);
				return;
			case DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT:
				setSupport((DataType)newValue);
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
			case DatatypePackage.DATA_TYPE_REFERENCE__TYPEREF:
				setTyperef((DataType)null);
				return;
			case DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT:
				setSupport((DataType)null);
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
			case DatatypePackage.DATA_TYPE_REFERENCE__TYPEREF:
				return typeref != null;
			case DatatypePackage.DATA_TYPE_REFERENCE__SUPPORT:
				return support != null;
		}
		return super.eIsSet(featureID);
	}

} //DataTypeReferenceImpl
