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
package org.eclipse.efm.ecore.formalml.statement.impl;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement;
import org.eclipse.efm.ecore.formalml.statement.StatementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Block Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.ConditionalBlockStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.ConditionalBlockStatementImpl#getBodyBlock <em>Body Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalBlockStatementImpl extends StatementImpl implements ConditionalBlockStatement {
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
	 * The cached value of the '{@link #getBodyBlock() <em>Body Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyBlock()
	 * @generated
	 * @ordered
	 */
	protected BlockStatement bodyBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalBlockStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION, oldCondition, newCondition);
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
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockStatement getBodyBlock() {
		return bodyBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyBlock(BlockStatement newBodyBlock, NotificationChain msgs) {
		BlockStatement oldBodyBlock = bodyBlock;
		bodyBlock = newBodyBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK, oldBodyBlock, newBodyBlock);
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
	public void setBodyBlock(BlockStatement newBodyBlock) {
		if (newBodyBlock != bodyBlock) {
			NotificationChain msgs = null;
			if (bodyBlock != null)
				msgs = ((InternalEObject)bodyBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK, null, msgs);
			if (newBodyBlock != null)
				msgs = ((InternalEObject)newBodyBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK, null, msgs);
			msgs = basicSetBodyBlock(newBodyBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK, newBodyBlock, newBodyBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK:
				return basicSetBodyBlock(null, msgs);
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
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION:
				return getCondition();
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK:
				return getBodyBlock();
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
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION:
				setCondition((Expression)newValue);
				return;
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK:
				setBodyBlock((BlockStatement)newValue);
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
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION:
				setCondition((Expression)null);
				return;
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK:
				setBodyBlock((BlockStatement)null);
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
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__CONDITION:
				return condition != null;
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK:
				return bodyBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionalBlockStatementImpl
