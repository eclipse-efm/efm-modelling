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
package org.eclipse.efm.ecore.formalml.common.impl;

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;
import org.eclipse.efm.ecore.formalml.common.QualifiedName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.common.impl.QualifiedNameImpl#getIsAmbiguous <em>Is Ambiguous</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.common.impl.QualifiedNameImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.common.impl.QualifiedNameImpl#getNameBinding <em>Name Binding</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.common.impl.QualifiedNameImpl#getUnqualifiedName <em>Unqualified Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedNameImpl extends AbstractElementImpl implements QualifiedName {
	/**
	 * The default value of the '{@link #getIsAmbiguous() <em>Is Ambiguous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAmbiguous()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_AMBIGUOUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsAmbiguous() <em>Is Ambiguous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAmbiguous()
	 * @generated
	 * @ordered
	 */
	protected Boolean isAmbiguous = IS_AMBIGUOUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathName() <em>Path Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected String pathName = PATH_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNameBinding() <em>Name Binding</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameBinding()
	 * @generated
	 * @ordered
	 */
	protected EList<String> nameBinding;

	/**
	 * The default value of the '{@link #getUnqualifiedName() <em>Unqualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnqualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String UNQUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnqualifiedName() <em>Unqualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnqualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String unqualifiedName = UNQUALIFIED_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifiedNameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.QUALIFIED_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getIsAmbiguous() {
		return isAmbiguous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAmbiguous(Boolean newIsAmbiguous) {
		Boolean oldIsAmbiguous = isAmbiguous;
		isAmbiguous = newIsAmbiguous;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.QUALIFIED_NAME__IS_AMBIGUOUS, oldIsAmbiguous, isAmbiguous));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPathName() {
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPathName(String newPathName) {
		String oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.QUALIFIED_NAME__PATH_NAME, oldPathName, pathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getNameBinding() {
		if (nameBinding == null) {
			nameBinding = new EDataTypeUniqueEList<String>(String.class, this, CommonPackage.QUALIFIED_NAME__NAME_BINDING);
		}
		return nameBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUnqualifiedName() {
		return unqualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnqualifiedName(String newUnqualifiedName) {
		String oldUnqualifiedName = unqualifiedName;
		unqualifiedName = newUnqualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.QUALIFIED_NAME__UNQUALIFIED_NAME, oldUnqualifiedName, unqualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.QUALIFIED_NAME__IS_AMBIGUOUS:
				return getIsAmbiguous();
			case CommonPackage.QUALIFIED_NAME__PATH_NAME:
				return getPathName();
			case CommonPackage.QUALIFIED_NAME__NAME_BINDING:
				return getNameBinding();
			case CommonPackage.QUALIFIED_NAME__UNQUALIFIED_NAME:
				return getUnqualifiedName();
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
			case CommonPackage.QUALIFIED_NAME__IS_AMBIGUOUS:
				setIsAmbiguous((Boolean)newValue);
				return;
			case CommonPackage.QUALIFIED_NAME__PATH_NAME:
				setPathName((String)newValue);
				return;
			case CommonPackage.QUALIFIED_NAME__NAME_BINDING:
				getNameBinding().clear();
				getNameBinding().addAll((Collection<? extends String>)newValue);
				return;
			case CommonPackage.QUALIFIED_NAME__UNQUALIFIED_NAME:
				setUnqualifiedName((String)newValue);
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
			case CommonPackage.QUALIFIED_NAME__IS_AMBIGUOUS:
				setIsAmbiguous(IS_AMBIGUOUS_EDEFAULT);
				return;
			case CommonPackage.QUALIFIED_NAME__PATH_NAME:
				setPathName(PATH_NAME_EDEFAULT);
				return;
			case CommonPackage.QUALIFIED_NAME__NAME_BINDING:
				getNameBinding().clear();
				return;
			case CommonPackage.QUALIFIED_NAME__UNQUALIFIED_NAME:
				setUnqualifiedName(UNQUALIFIED_NAME_EDEFAULT);
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
			case CommonPackage.QUALIFIED_NAME__IS_AMBIGUOUS:
				return IS_AMBIGUOUS_EDEFAULT == null ? isAmbiguous != null : !IS_AMBIGUOUS_EDEFAULT.equals(isAmbiguous);
			case CommonPackage.QUALIFIED_NAME__PATH_NAME:
				return PATH_NAME_EDEFAULT == null ? pathName != null : !PATH_NAME_EDEFAULT.equals(pathName);
			case CommonPackage.QUALIFIED_NAME__NAME_BINDING:
				return nameBinding != null && !nameBinding.isEmpty();
			case CommonPackage.QUALIFIED_NAME__UNQUALIFIED_NAME:
				return UNQUALIFIED_NAME_EDEFAULT == null ? unqualifiedName != null : !UNQUALIFIED_NAME_EDEFAULT.equals(unqualifiedName);
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
		result.append(" (isAmbiguous: ");
		result.append(isAmbiguous);
		result.append(", pathName: ");
		result.append(pathName);
		result.append(", nameBinding: ");
		result.append(nameBinding);
		result.append(", unqualifiedName: ");
		result.append(unqualifiedName);
		result.append(')');
		return result.toString();
	}

} //QualifiedNameImpl
