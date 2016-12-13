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

import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression;

import org.eclipse.efm.ecore.formalml.statement.AssignmentStatement;
import org.eclipse.efm.ecore.formalml.statement.StatementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.AssignmentStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.AssignmentStatementImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.AssignmentStatementImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.AssignmentStatementImpl#getRigthHandSide <em>Rigth Hand Side</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentStatementImpl extends StatementImpl implements AssignmentStatement {
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected AssignmentExpression expression;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected String operator = OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLeftHandSide() <em>Left Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftHandSide()
	 * @generated
	 * @ordered
	 */
	protected LeftHandSideExpression leftHandSide;

	/**
	 * The cached value of the '{@link #getRigthHandSide() <em>Rigth Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRigthHandSide()
	 * @generated
	 * @ordered
	 */
	protected Expression rigthHandSide;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.ASSIGNMENT_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(AssignmentExpression newExpression, NotificationChain msgs) {
		AssignmentExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(AssignmentExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(String newOperator) {
		String oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.ASSIGNMENT_STATEMENT__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftHandSideExpression getLeftHandSide() {
		return leftHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftHandSide(LeftHandSideExpression newLeftHandSide, NotificationChain msgs) {
		LeftHandSideExpression oldLeftHandSide = leftHandSide;
		leftHandSide = newLeftHandSide;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE, oldLeftHandSide, newLeftHandSide);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftHandSide(LeftHandSideExpression newLeftHandSide) {
		if (newLeftHandSide != leftHandSide) {
			NotificationChain msgs = null;
			if (leftHandSide != null)
				msgs = ((InternalEObject)leftHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE, null, msgs);
			if (newLeftHandSide != null)
				msgs = ((InternalEObject)newLeftHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE, null, msgs);
			msgs = basicSetLeftHandSide(newLeftHandSide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE, newLeftHandSide, newLeftHandSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRigthHandSide() {
		return rigthHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRigthHandSide(Expression newRigthHandSide, NotificationChain msgs) {
		Expression oldRigthHandSide = rigthHandSide;
		rigthHandSide = newRigthHandSide;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE, oldRigthHandSide, newRigthHandSide);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRigthHandSide(Expression newRigthHandSide) {
		if (newRigthHandSide != rigthHandSide) {
			NotificationChain msgs = null;
			if (rigthHandSide != null)
				msgs = ((InternalEObject)rigthHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE, null, msgs);
			if (newRigthHandSide != null)
				msgs = ((InternalEObject)newRigthHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE, null, msgs);
			msgs = basicSetRigthHandSide(newRigthHandSide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE, newRigthHandSide, newRigthHandSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION:
				return basicSetExpression(null, msgs);
			case StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE:
				return basicSetLeftHandSide(null, msgs);
			case StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE:
				return basicSetRigthHandSide(null, msgs);
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
			case StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION:
				return getExpression();
			case StatementPackage.ASSIGNMENT_STATEMENT__OPERATOR:
				return getOperator();
			case StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE:
				return getLeftHandSide();
			case StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE:
				return getRigthHandSide();
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
			case StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION:
				setExpression((AssignmentExpression)newValue);
				return;
			case StatementPackage.ASSIGNMENT_STATEMENT__OPERATOR:
				setOperator((String)newValue);
				return;
			case StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE:
				setLeftHandSide((LeftHandSideExpression)newValue);
				return;
			case StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE:
				setRigthHandSide((Expression)newValue);
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
			case StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION:
				setExpression((AssignmentExpression)null);
				return;
			case StatementPackage.ASSIGNMENT_STATEMENT__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE:
				setLeftHandSide((LeftHandSideExpression)null);
				return;
			case StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE:
				setRigthHandSide((Expression)null);
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
			case StatementPackage.ASSIGNMENT_STATEMENT__EXPRESSION:
				return expression != null;
			case StatementPackage.ASSIGNMENT_STATEMENT__OPERATOR:
				return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
			case StatementPackage.ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE:
				return leftHandSide != null;
			case StatementPackage.ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE:
				return rigthHandSide != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //AssignmentStatementImpl
