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
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl#getRigthOperator <em>Rigth Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl#getRigthOperand <em>Rigth Operand</em>}</li>
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
	 * The default value of the '{@link #getRigthOperator() <em>Rigth Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRigthOperator()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGTH_OPERATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRigthOperator() <em>Rigth Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRigthOperator()
	 * @generated
	 * @ordered
	 */
	protected String rigthOperator = RIGTH_OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRigthOperand() <em>Rigth Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRigthOperand()
	 * @generated
	 * @ordered
	 */
	protected Expression rigthOperand;

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
	public String getRigthOperator() {
		return rigthOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRigthOperator(String newRigthOperator) {
		String oldRigthOperator = rigthOperator;
		rigthOperator = newRigthOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERATOR, oldRigthOperator, rigthOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRigthOperand() {
		return rigthOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRigthOperand(Expression newRigthOperand, NotificationChain msgs) {
		Expression oldRigthOperand = rigthOperand;
		rigthOperand = newRigthOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND, oldRigthOperand, newRigthOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRigthOperand(Expression newRigthOperand) {
		if (newRigthOperand != rigthOperand) {
			NotificationChain msgs = null;
			if (rigthOperand != null)
				msgs = ((InternalEObject)rigthOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND, null, msgs);
			if (newRigthOperand != null)
				msgs = ((InternalEObject)newRigthOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND, null, msgs);
			msgs = basicSetRigthOperand(newRigthOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND, newRigthOperand, newRigthOperand));
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND:
				return basicSetRigthOperand(null, msgs);
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERATOR:
				return getRigthOperator();
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND:
				return getRigthOperand();
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERATOR:
				setRigthOperator((String)newValue);
				return;
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND:
				setRigthOperand((Expression)newValue);
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERATOR:
				setRigthOperator(RIGTH_OPERATOR_EDEFAULT);
				return;
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND:
				setRigthOperand((Expression)null);
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
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERATOR:
				return RIGTH_OPERATOR_EDEFAULT == null ? rigthOperator != null : !RIGTH_OPERATOR_EDEFAULT.equals(rigthOperator);
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION__RIGTH_OPERAND:
				return rigthOperand != null;
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
		result.append(" (rigthOperator: ");
		result.append(rigthOperator);
		result.append(')');
		return result.toString();
	}

} //RelationalTernaryExpressionImpl
