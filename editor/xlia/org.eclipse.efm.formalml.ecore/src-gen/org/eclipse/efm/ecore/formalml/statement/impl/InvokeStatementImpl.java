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

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.common.NamedElement;

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.TupleExpression;

import org.eclipse.efm.ecore.formalml.infrastructure.Variable;

import org.eclipse.efm.ecore.formalml.statement.InvokeStatement;
import org.eclipse.efm.ecore.formalml.statement.StatementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl#isCallProcedure <em>Call Procedure</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl#isExecRoutine <em>Exec Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl#getInvokable <em>Invokable</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl#getRets <em>Rets</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvokeStatementImpl extends StatementImpl implements InvokeStatement {
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
	 * The default value of the '{@link #isExecRoutine() <em>Exec Routine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecRoutine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXEC_ROUTINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExecRoutine() <em>Exec Routine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecRoutine()
	 * @generated
	 * @ordered
	 */
	protected boolean execRoutine = EXEC_ROUTINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInvokable() <em>Invokable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvokable()
	 * @generated
	 * @ordered
	 */
	protected NamedElement invokable;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected TupleExpression args;

	/**
	 * The cached value of the '{@link #getRets() <em>Rets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRets()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> rets;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvokeStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.INVOKE_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCallProcedure() {
		return callProcedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallProcedure(boolean newCallProcedure) {
		boolean oldCallProcedure = callProcedure;
		callProcedure = newCallProcedure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.INVOKE_STATEMENT__CALL_PROCEDURE, oldCallProcedure, callProcedure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExecRoutine() {
		return execRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecRoutine(boolean newExecRoutine) {
		boolean oldExecRoutine = execRoutine;
		execRoutine = newExecRoutine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.INVOKE_STATEMENT__EXEC_ROUTINE, oldExecRoutine, execRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getInvokable() {
		if (invokable != null && invokable.eIsProxy()) {
			InternalEObject oldInvokable = (InternalEObject)invokable;
			invokable = (NamedElement)eResolveProxy(oldInvokable);
			if (invokable != oldInvokable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatementPackage.INVOKE_STATEMENT__INVOKABLE, oldInvokable, invokable));
			}
		}
		return invokable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetInvokable() {
		return invokable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvokable(NamedElement newInvokable) {
		NamedElement oldInvokable = invokable;
		invokable = newInvokable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.INVOKE_STATEMENT__INVOKABLE, oldInvokable, invokable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleExpression getArgs() {
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArgs(TupleExpression newArgs, NotificationChain msgs) {
		TupleExpression oldArgs = args;
		args = newArgs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.INVOKE_STATEMENT__ARGS, oldArgs, newArgs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgs(TupleExpression newArgs) {
		if (newArgs != args) {
			NotificationChain msgs = null;
			if (args != null)
				msgs = ((InternalEObject)args).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.INVOKE_STATEMENT__ARGS, null, msgs);
			if (newArgs != null)
				msgs = ((InternalEObject)newArgs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.INVOKE_STATEMENT__ARGS, null, msgs);
			msgs = basicSetArgs(newArgs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.INVOKE_STATEMENT__ARGS, newArgs, newArgs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getRets() {
		if (rets == null) {
			rets = new EObjectResolvingEList<Variable>(Variable.class, this, StatementPackage.INVOKE_STATEMENT__RETS);
		}
		return rets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.INVOKE_STATEMENT__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.INVOKE_STATEMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.INVOKE_STATEMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.INVOKE_STATEMENT__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.INVOKE_STATEMENT__ARGS:
				return basicSetArgs(null, msgs);
			case StatementPackage.INVOKE_STATEMENT__EXPRESSION:
				return basicSetExpression(null, msgs);
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
			case StatementPackage.INVOKE_STATEMENT__CALL_PROCEDURE:
				return isCallProcedure();
			case StatementPackage.INVOKE_STATEMENT__EXEC_ROUTINE:
				return isExecRoutine();
			case StatementPackage.INVOKE_STATEMENT__INVOKABLE:
				if (resolve) return getInvokable();
				return basicGetInvokable();
			case StatementPackage.INVOKE_STATEMENT__ARGS:
				return getArgs();
			case StatementPackage.INVOKE_STATEMENT__RETS:
				return getRets();
			case StatementPackage.INVOKE_STATEMENT__EXPRESSION:
				return getExpression();
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
			case StatementPackage.INVOKE_STATEMENT__CALL_PROCEDURE:
				setCallProcedure((Boolean)newValue);
				return;
			case StatementPackage.INVOKE_STATEMENT__EXEC_ROUTINE:
				setExecRoutine((Boolean)newValue);
				return;
			case StatementPackage.INVOKE_STATEMENT__INVOKABLE:
				setInvokable((NamedElement)newValue);
				return;
			case StatementPackage.INVOKE_STATEMENT__ARGS:
				setArgs((TupleExpression)newValue);
				return;
			case StatementPackage.INVOKE_STATEMENT__RETS:
				getRets().clear();
				getRets().addAll((Collection<? extends Variable>)newValue);
				return;
			case StatementPackage.INVOKE_STATEMENT__EXPRESSION:
				setExpression((Expression)newValue);
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
			case StatementPackage.INVOKE_STATEMENT__CALL_PROCEDURE:
				setCallProcedure(CALL_PROCEDURE_EDEFAULT);
				return;
			case StatementPackage.INVOKE_STATEMENT__EXEC_ROUTINE:
				setExecRoutine(EXEC_ROUTINE_EDEFAULT);
				return;
			case StatementPackage.INVOKE_STATEMENT__INVOKABLE:
				setInvokable((NamedElement)null);
				return;
			case StatementPackage.INVOKE_STATEMENT__ARGS:
				setArgs((TupleExpression)null);
				return;
			case StatementPackage.INVOKE_STATEMENT__RETS:
				getRets().clear();
				return;
			case StatementPackage.INVOKE_STATEMENT__EXPRESSION:
				setExpression((Expression)null);
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
			case StatementPackage.INVOKE_STATEMENT__CALL_PROCEDURE:
				return callProcedure != CALL_PROCEDURE_EDEFAULT;
			case StatementPackage.INVOKE_STATEMENT__EXEC_ROUTINE:
				return execRoutine != EXEC_ROUTINE_EDEFAULT;
			case StatementPackage.INVOKE_STATEMENT__INVOKABLE:
				return invokable != null;
			case StatementPackage.INVOKE_STATEMENT__ARGS:
				return args != null;
			case StatementPackage.INVOKE_STATEMENT__RETS:
				return rets != null && !rets.isEmpty();
			case StatementPackage.INVOKE_STATEMENT__EXPRESSION:
				return expression != null;
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
		result.append(" (callProcedure: ");
		result.append(callProcedure);
		result.append(", execRoutine: ");
		result.append(execRoutine);
		result.append(')');
		return result.toString();
	}

} //InvokeStatementImpl
