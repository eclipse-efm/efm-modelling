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
package org.eclipse.efm.ecore.formalml.expression.impl;

import org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Test Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl#getThenOperand <em>Then Operand</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl#getElseSeparator <em>Else Separator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl#getElseOperand <em>Else Operand</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalTestExpressionImpl extends ExpressionImpl implements ConditionalTestExpression {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

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
	 * The cached value of the '{@link #getThenOperand() <em>Then Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenOperand()
	 * @generated
	 * @ordered
	 */
	protected Expression thenOperand;

	/**
	 * The default value of the '{@link #getElseSeparator() <em>Else Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String ELSE_SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElseSeparator() <em>Else Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseSeparator()
	 * @generated
	 * @ordered
	 */
	protected String elseSeparator = ELSE_SEPARATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElseOperand() <em>Else Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseOperand()
	 * @generated
	 * @ordered
	 */
	protected Expression elseOperand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalTestExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION, oldCondition, newCondition);
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
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperator(String newOperator) {
		String oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getThenOperand() {
		return thenOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenOperand(Expression newThenOperand, NotificationChain msgs) {
		Expression oldThenOperand = thenOperand;
		thenOperand = newThenOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND, oldThenOperand, newThenOperand);
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
	public void setThenOperand(Expression newThenOperand) {
		if (newThenOperand != thenOperand) {
			NotificationChain msgs = null;
			if (thenOperand != null)
				msgs = ((InternalEObject)thenOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND, null, msgs);
			if (newThenOperand != null)
				msgs = ((InternalEObject)newThenOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND, null, msgs);
			msgs = basicSetThenOperand(newThenOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND, newThenOperand, newThenOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElseSeparator() {
		return elseSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElseSeparator(String newElseSeparator) {
		String oldElseSeparator = elseSeparator;
		elseSeparator = newElseSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR, oldElseSeparator, elseSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getElseOperand() {
		return elseOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseOperand(Expression newElseOperand, NotificationChain msgs) {
		Expression oldElseOperand = elseOperand;
		elseOperand = newElseOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND, oldElseOperand, newElseOperand);
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
	public void setElseOperand(Expression newElseOperand) {
		if (newElseOperand != elseOperand) {
			NotificationChain msgs = null;
			if (elseOperand != null)
				msgs = ((InternalEObject)elseOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND, null, msgs);
			if (newElseOperand != null)
				msgs = ((InternalEObject)newElseOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND, null, msgs);
			msgs = basicSetElseOperand(newElseOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND, newElseOperand, newElseOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION:
				return basicSetCondition(null, msgs);
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND:
				return basicSetThenOperand(null, msgs);
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND:
				return basicSetElseOperand(null, msgs);
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
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION:
				return getCondition();
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__OPERATOR:
				return getOperator();
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND:
				return getThenOperand();
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR:
				return getElseSeparator();
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND:
				return getElseOperand();
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
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION:
				setCondition((Expression)newValue);
				return;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__OPERATOR:
				setOperator((String)newValue);
				return;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND:
				setThenOperand((Expression)newValue);
				return;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR:
				setElseSeparator((String)newValue);
				return;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND:
				setElseOperand((Expression)newValue);
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
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION:
				setCondition((Expression)null);
				return;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND:
				setThenOperand((Expression)null);
				return;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR:
				setElseSeparator(ELSE_SEPARATOR_EDEFAULT);
				return;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND:
				setElseOperand((Expression)null);
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
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__CONDITION:
				return condition != null;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__OPERATOR:
				return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND:
				return thenOperand != null;
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR:
				return ELSE_SEPARATOR_EDEFAULT == null ? elseSeparator != null : !ELSE_SEPARATOR_EDEFAULT.equals(elseSeparator);
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND:
				return elseOperand != null;
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
		result.append(" (operator: ");
		result.append(operator);
		result.append(", elseSeparator: ");
		result.append(elseSeparator);
		result.append(')');
		return result.toString();
	}

} //ConditionalTestExpressionImpl
