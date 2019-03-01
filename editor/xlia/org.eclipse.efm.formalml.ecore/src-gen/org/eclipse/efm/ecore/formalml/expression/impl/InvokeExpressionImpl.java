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

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;
import org.eclipse.efm.ecore.formalml.expression.InvokeExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.InvokeExpressionImpl#isCallProcedure <em>Call Procedure</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.InvokeExpressionImpl#getInvokable <em>Invokable</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.InvokeExpressionImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.InvokeExpressionImpl#getRets <em>Rets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvokeExpressionImpl extends ExpressionImpl implements InvokeExpression {
	/**
	 * The default value of the '{@link #isCallProcedure() <em>Call Procedure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCallProcedure()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALL_PROCEDURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCallProcedure() <em>Call Procedure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCallProcedure()
	 * @generated
	 * @ordered
	 */
	protected boolean callProcedure = CALL_PROCEDURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInvokable() <em>Invokable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvokable()
	 * @generated
	 * @ordered
	 */
	protected Expression invokable;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> args;

	/**
	 * The cached value of the '{@link #getRets() <em>Rets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRets()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> rets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvokeExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.INVOKE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCallProcedure() {
		return callProcedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCallProcedure(boolean newCallProcedure) {
		boolean oldCallProcedure = callProcedure;
		callProcedure = newCallProcedure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.INVOKE_EXPRESSION__CALL_PROCEDURE, oldCallProcedure, callProcedure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getInvokable() {
		return invokable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvokable(Expression newInvokable, NotificationChain msgs) {
		Expression oldInvokable = invokable;
		invokable = newInvokable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE, oldInvokable, newInvokable);
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
	public void setInvokable(Expression newInvokable) {
		if (newInvokable != invokable) {
			NotificationChain msgs = null;
			if (invokable != null)
				msgs = ((InternalEObject)invokable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE, null, msgs);
			if (newInvokable != null)
				msgs = ((InternalEObject)newInvokable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE, null, msgs);
			msgs = basicSetInvokable(newInvokable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE, newInvokable, newInvokable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<Expression>(Expression.class, this, ExpressionPackage.INVOKE_EXPRESSION__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getRets() {
		if (rets == null) {
			rets = new EObjectContainmentEList<Expression>(Expression.class, this, ExpressionPackage.INVOKE_EXPRESSION__RETS);
		}
		return rets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE:
				return basicSetInvokable(null, msgs);
			case ExpressionPackage.INVOKE_EXPRESSION__ARGS:
				return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
			case ExpressionPackage.INVOKE_EXPRESSION__RETS:
				return ((InternalEList<?>)getRets()).basicRemove(otherEnd, msgs);
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
			case ExpressionPackage.INVOKE_EXPRESSION__CALL_PROCEDURE:
				return isCallProcedure();
			case ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE:
				return getInvokable();
			case ExpressionPackage.INVOKE_EXPRESSION__ARGS:
				return getArgs();
			case ExpressionPackage.INVOKE_EXPRESSION__RETS:
				return getRets();
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
			case ExpressionPackage.INVOKE_EXPRESSION__CALL_PROCEDURE:
				setCallProcedure((Boolean)newValue);
				return;
			case ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE:
				setInvokable((Expression)newValue);
				return;
			case ExpressionPackage.INVOKE_EXPRESSION__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends Expression>)newValue);
				return;
			case ExpressionPackage.INVOKE_EXPRESSION__RETS:
				getRets().clear();
				getRets().addAll((Collection<? extends Expression>)newValue);
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
			case ExpressionPackage.INVOKE_EXPRESSION__CALL_PROCEDURE:
				setCallProcedure(CALL_PROCEDURE_EDEFAULT);
				return;
			case ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE:
				setInvokable((Expression)null);
				return;
			case ExpressionPackage.INVOKE_EXPRESSION__ARGS:
				getArgs().clear();
				return;
			case ExpressionPackage.INVOKE_EXPRESSION__RETS:
				getRets().clear();
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
			case ExpressionPackage.INVOKE_EXPRESSION__CALL_PROCEDURE:
				return callProcedure != CALL_PROCEDURE_EDEFAULT;
			case ExpressionPackage.INVOKE_EXPRESSION__INVOKABLE:
				return invokable != null;
			case ExpressionPackage.INVOKE_EXPRESSION__ARGS:
				return args != null && !args.isEmpty();
			case ExpressionPackage.INVOKE_EXPRESSION__RETS:
				return rets != null && !rets.isEmpty();
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
		result.append(" (callProcedure: ");
		result.append(callProcedure);
		result.append(')');
		return result.toString();
	}

} //InvokeExpressionImpl
