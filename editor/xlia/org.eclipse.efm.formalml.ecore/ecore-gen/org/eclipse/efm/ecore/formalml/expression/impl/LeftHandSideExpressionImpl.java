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
package org.eclipse.efm.ecore.formalml.expression.impl;

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Left Hand Side Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.LeftHandSideExpressionImpl#getLvalue <em>Lvalue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LeftHandSideExpressionImpl extends ExpressionImpl implements LeftHandSideExpression {
	/**
	 * The cached value of the '{@link #getLvalue() <em>Lvalue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLvalue()
	 * @generated
	 * @ordered
	 */
	protected Expression lvalue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeftHandSideExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.LEFT_HAND_SIDE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getLvalue() {
		return lvalue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLvalue(Expression newLvalue, NotificationChain msgs) {
		Expression oldLvalue = lvalue;
		lvalue = newLvalue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE, oldLvalue, newLvalue);
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
	public void setLvalue(Expression newLvalue) {
		if (newLvalue != lvalue) {
			NotificationChain msgs = null;
			if (lvalue != null)
				msgs = ((InternalEObject)lvalue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE, null, msgs);
			if (newLvalue != null)
				msgs = ((InternalEObject)newLvalue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE, null, msgs);
			msgs = basicSetLvalue(newLvalue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE, newLvalue, newLvalue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE:
				return basicSetLvalue(null, msgs);
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
			case ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE:
				return getLvalue();
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
			case ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE:
				setLvalue((Expression)newValue);
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
			case ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE:
				setLvalue((Expression)null);
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
			case ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION__LVALUE:
				return lvalue != null;
		}
		return super.eIsSet(featureID);
	}

} //LeftHandSideExpressionImpl
