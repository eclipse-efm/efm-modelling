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
import org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression;
import org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relational Ternary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl#getLeftRelation <em>Left Relation</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl#getRightOperator <em>Right Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationalTernaryExpressionImpl extends ExpressionImpl implements RelationalTernaryExpression {
	/**
	 * The cached value of the '{@link #getLeftRelation() <em>Left Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftRelation()
	 * @generated
	 * @ordered
	 */
	protected RelationalBinaryExpression leftRelation;

	/**
	 * The default value of the '{@link #getRightOperator() <em>Right Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOperator()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGHT_OPERATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRightOperator() <em>Right Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOperator()
	 * @generated
	 * @ordered
	 */
	protected String rightOperator = RIGHT_OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRightOperand() <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOperand()
	 * @generated
	 * @ordered
	 */
	protected Expression rightOperand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationalTernaryExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.RELATIONAL_TERNARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalBinaryExpression getLeftRelation() {
		return leftRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftRelation(RelationalBinaryExpression newLeftRelation, NotificationChain msgs) {
		RelationalBinaryExpression oldLeftRelation = leftRelation;
		leftRelation = newLeftRelation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION, oldLeftRelation, newLeftRelation);
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
	public void setLeftRelation(RelationalBinaryExpression newLeftRelation) {
		if (newLeftRelation != leftRelation) {
			NotificationChain msgs = null;
			if (leftRelation != null)
				msgs = ((InternalEObject)leftRelation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION, null, msgs);
			if (newLeftRelation != null)
				msgs = ((InternalEObject)newLeftRelation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION, null, msgs);
			msgs = basicSetLeftRelation(newLeftRelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION, newLeftRelation, newLeftRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRightOperator() {
		return rightOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRightOperator(String newRightOperator) {
		String oldRightOperator = rightOperator;
		rightOperator = newRightOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR, oldRightOperator, rightOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getRightOperand() {
		return rightOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightOperand(Expression newRightOperand, NotificationChain msgs) {
		Expression oldRightOperand = rightOperand;
		rightOperand = newRightOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND, oldRightOperand, newRightOperand);
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
	public void setRightOperand(Expression newRightOperand) {
		if (newRightOperand != rightOperand) {
			NotificationChain msgs = null;
			if (rightOperand != null)
				msgs = ((InternalEObject)rightOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND, null, msgs);
			if (newRightOperand != null)
				msgs = ((InternalEObject)newRightOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND, null, msgs);
			msgs = basicSetRightOperand(newRightOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND, newRightOperand, newRightOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION:
				return basicSetLeftRelation(null, msgs);
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND:
				return basicSetRightOperand(null, msgs);
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION:
				return getLeftRelation();
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR:
				return getRightOperator();
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND:
				return getRightOperand();
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION:
				setLeftRelation((RelationalBinaryExpression)newValue);
				return;
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR:
				setRightOperator((String)newValue);
				return;
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND:
				setRightOperand((Expression)newValue);
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION:
				setLeftRelation((RelationalBinaryExpression)null);
				return;
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR:
				setRightOperator(RIGHT_OPERATOR_EDEFAULT);
				return;
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND:
				setRightOperand((Expression)null);
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION:
				return leftRelation != null;
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR:
				return RIGHT_OPERATOR_EDEFAULT == null ? rightOperator != null : !RIGHT_OPERATOR_EDEFAULT.equals(rightOperator);
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND:
				return rightOperand != null;
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
		result.append(" (rightOperator: ");
		result.append(rightOperator);
		result.append(')');
		return result.toString();
	}

} //RelationalTernaryExpressionImpl
