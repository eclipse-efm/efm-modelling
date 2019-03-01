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
package org.eclipse.efm.ecore.formalml.infrastructure.impl;

import org.eclipse.efm.ecore.formalml.infrastructure.Function;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.FunctionImpl#getParameterSet <em>Parameter Set</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.FunctionImpl#getResultSet <em>Result Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionImpl extends PropertyDefinitionImpl implements Function {
	/**
	 * The cached value of the '{@link #getParameterSet() <em>Parameter Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterSet()
	 * @generated
	 * @ordered
	 */
	protected ParameterSet parameterSet;

	/**
	 * The cached value of the '{@link #getResultSet() <em>Result Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultSet()
	 * @generated
	 * @ordered
	 */
	protected ParameterSet resultSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterSet getParameterSet() {
		return parameterSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterSet(ParameterSet newParameterSet, NotificationChain msgs) {
		ParameterSet oldParameterSet = parameterSet;
		parameterSet = newParameterSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.FUNCTION__PARAMETER_SET, oldParameterSet, newParameterSet);
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
	public void setParameterSet(ParameterSet newParameterSet) {
		if (newParameterSet != parameterSet) {
			NotificationChain msgs = null;
			if (parameterSet != null)
				msgs = ((InternalEObject)parameterSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.FUNCTION__PARAMETER_SET, null, msgs);
			if (newParameterSet != null)
				msgs = ((InternalEObject)newParameterSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.FUNCTION__PARAMETER_SET, null, msgs);
			msgs = basicSetParameterSet(newParameterSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.FUNCTION__PARAMETER_SET, newParameterSet, newParameterSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterSet getResultSet() {
		return resultSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultSet(ParameterSet newResultSet, NotificationChain msgs) {
		ParameterSet oldResultSet = resultSet;
		resultSet = newResultSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.FUNCTION__RESULT_SET, oldResultSet, newResultSet);
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
	public void setResultSet(ParameterSet newResultSet) {
		if (newResultSet != resultSet) {
			NotificationChain msgs = null;
			if (resultSet != null)
				msgs = ((InternalEObject)resultSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.FUNCTION__RESULT_SET, null, msgs);
			if (newResultSet != null)
				msgs = ((InternalEObject)newResultSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.FUNCTION__RESULT_SET, null, msgs);
			msgs = basicSetResultSet(newResultSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.FUNCTION__RESULT_SET, newResultSet, newResultSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.FUNCTION__PARAMETER_SET:
				return basicSetParameterSet(null, msgs);
			case InfrastructurePackage.FUNCTION__RESULT_SET:
				return basicSetResultSet(null, msgs);
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
			case InfrastructurePackage.FUNCTION__PARAMETER_SET:
				return getParameterSet();
			case InfrastructurePackage.FUNCTION__RESULT_SET:
				return getResultSet();
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
			case InfrastructurePackage.FUNCTION__PARAMETER_SET:
				setParameterSet((ParameterSet)newValue);
				return;
			case InfrastructurePackage.FUNCTION__RESULT_SET:
				setResultSet((ParameterSet)newValue);
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
			case InfrastructurePackage.FUNCTION__PARAMETER_SET:
				setParameterSet((ParameterSet)null);
				return;
			case InfrastructurePackage.FUNCTION__RESULT_SET:
				setResultSet((ParameterSet)null);
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
			case InfrastructurePackage.FUNCTION__PARAMETER_SET:
				return parameterSet != null;
			case InfrastructurePackage.FUNCTION__RESULT_SET:
				return resultSet != null;
		}
		return super.eIsSet(featureID);
	}

} //FunctionImpl
