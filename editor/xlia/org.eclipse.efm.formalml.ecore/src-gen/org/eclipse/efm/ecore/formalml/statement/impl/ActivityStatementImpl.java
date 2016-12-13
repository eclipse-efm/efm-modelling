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
import org.eclipse.efm.ecore.formalml.expression.TupleExpression;

import org.eclipse.efm.ecore.formalml.statement.ActivityStatement;
import org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind;
import org.eclipse.efm.ecore.formalml.statement.StatementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.ActivityStatementImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.ActivityStatementImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.impl.ActivityStatementImpl#getTuple <em>Tuple</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActivityStatementImpl extends StatementImpl implements ActivityStatement {
	/**
	 * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected static final ActivityStatementKind OP_EDEFAULT = ActivityStatementKind.INIT;

	/**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected ActivityStatementKind op = OP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected Expression machine;

	/**
	 * The cached value of the '{@link #getTuple() <em>Tuple</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTuple()
	 * @generated
	 * @ordered
	 */
	protected TupleExpression tuple;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.ACTIVITY_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityStatementKind getOp() {
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(ActivityStatementKind newOp) {
		ActivityStatementKind oldOp = op;
		op = newOp == null ? OP_EDEFAULT : newOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.ACTIVITY_STATEMENT__OP, oldOp, op));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getMachine() {
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMachine(Expression newMachine, NotificationChain msgs) {
		Expression oldMachine = machine;
		machine = newMachine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.ACTIVITY_STATEMENT__MACHINE, oldMachine, newMachine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachine(Expression newMachine) {
		if (newMachine != machine) {
			NotificationChain msgs = null;
			if (machine != null)
				msgs = ((InternalEObject)machine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ACTIVITY_STATEMENT__MACHINE, null, msgs);
			if (newMachine != null)
				msgs = ((InternalEObject)newMachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ACTIVITY_STATEMENT__MACHINE, null, msgs);
			msgs = basicSetMachine(newMachine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.ACTIVITY_STATEMENT__MACHINE, newMachine, newMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleExpression getTuple() {
		return tuple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTuple(TupleExpression newTuple, NotificationChain msgs) {
		TupleExpression oldTuple = tuple;
		tuple = newTuple;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.ACTIVITY_STATEMENT__TUPLE, oldTuple, newTuple);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTuple(TupleExpression newTuple) {
		if (newTuple != tuple) {
			NotificationChain msgs = null;
			if (tuple != null)
				msgs = ((InternalEObject)tuple).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ACTIVITY_STATEMENT__TUPLE, null, msgs);
			if (newTuple != null)
				msgs = ((InternalEObject)newTuple).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.ACTIVITY_STATEMENT__TUPLE, null, msgs);
			msgs = basicSetTuple(newTuple, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.ACTIVITY_STATEMENT__TUPLE, newTuple, newTuple));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.ACTIVITY_STATEMENT__MACHINE:
				return basicSetMachine(null, msgs);
			case StatementPackage.ACTIVITY_STATEMENT__TUPLE:
				return basicSetTuple(null, msgs);
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
			case StatementPackage.ACTIVITY_STATEMENT__OP:
				return getOp();
			case StatementPackage.ACTIVITY_STATEMENT__MACHINE:
				return getMachine();
			case StatementPackage.ACTIVITY_STATEMENT__TUPLE:
				return getTuple();
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
			case StatementPackage.ACTIVITY_STATEMENT__OP:
				setOp((ActivityStatementKind)newValue);
				return;
			case StatementPackage.ACTIVITY_STATEMENT__MACHINE:
				setMachine((Expression)newValue);
				return;
			case StatementPackage.ACTIVITY_STATEMENT__TUPLE:
				setTuple((TupleExpression)newValue);
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
			case StatementPackage.ACTIVITY_STATEMENT__OP:
				setOp(OP_EDEFAULT);
				return;
			case StatementPackage.ACTIVITY_STATEMENT__MACHINE:
				setMachine((Expression)null);
				return;
			case StatementPackage.ACTIVITY_STATEMENT__TUPLE:
				setTuple((TupleExpression)null);
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
			case StatementPackage.ACTIVITY_STATEMENT__OP:
				return op != OP_EDEFAULT;
			case StatementPackage.ACTIVITY_STATEMENT__MACHINE:
				return machine != null;
			case StatementPackage.ACTIVITY_STATEMENT__TUPLE:
				return tuple != null;
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
		result.append(" (op: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}

} //ActivityStatementImpl
