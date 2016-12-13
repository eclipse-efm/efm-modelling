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
package org.eclipse.efm.ecore.formalml.statement.impl;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.efm.ecore.formalml.statement.NewfreshStatement;
import org.eclipse.efm.ecore.formalml.statement.StatementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Newfresh Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.NewfreshStatementImpl#getLeftValue <em>Left Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewfreshStatementImpl extends StatementImpl implements NewfreshStatement {
	/**
	 * The cached value of the '{@link #getLeftValue() <em>Left Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftValue()
	 * @generated
	 * @ordered
	 */
	protected Expression leftValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewfreshStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.NEWFRESH_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeftValue() {
		return leftValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftValue(Expression newLeftValue, NotificationChain msgs) {
		Expression oldLeftValue = leftValue;
		leftValue = newLeftValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE, oldLeftValue, newLeftValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftValue(Expression newLeftValue) {
		if (newLeftValue != leftValue) {
			NotificationChain msgs = null;
			if (leftValue != null)
				msgs = ((InternalEObject)leftValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE, null, msgs);
			if (newLeftValue != null)
				msgs = ((InternalEObject)newLeftValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE, null, msgs);
			msgs = basicSetLeftValue(newLeftValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE, newLeftValue, newLeftValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE:
				return basicSetLeftValue(null, msgs);
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
			case StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE:
				return getLeftValue();
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
			case StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE:
				setLeftValue((Expression)newValue);
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
			case StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE:
				setLeftValue((Expression)null);
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
			case StatementPackage.NEWFRESH_STATEMENT__LEFT_VALUE:
				return leftValue != null;
		}
		return super.eIsSet(featureID);
	}

} //NewfreshStatementImpl
