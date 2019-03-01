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
import org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter;
import org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression;

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
 * An implementation of the model object '<em><b>Value Printable Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValuePrintableExpressionImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValuePrintableExpressionImpl#getPrinter <em>Printer</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValuePrintableExpressionImpl#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValuePrintableExpressionImpl extends ExpressionImpl implements ValuePrintableExpression {
	/**
	 * The default value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected String symbol = SYMBOL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrinter() <em>Printer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrinter()
	 * @generated
	 * @ordered
	 */
	protected ValueExpressionPrettyPrinter printer;

	/**
	 * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperand()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> operand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValuePrintableExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.VALUE_PRINTABLE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSymbol() {
		return symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSymbol(String newSymbol) {
		String oldSymbol = symbol;
		symbol = newSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__SYMBOL, oldSymbol, symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueExpressionPrettyPrinter getPrinter() {
		return printer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrinter(ValueExpressionPrettyPrinter newPrinter, NotificationChain msgs) {
		ValueExpressionPrettyPrinter oldPrinter = printer;
		printer = newPrinter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER, oldPrinter, newPrinter);
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
	public void setPrinter(ValueExpressionPrettyPrinter newPrinter) {
		if (newPrinter != printer) {
			NotificationChain msgs = null;
			if (printer != null)
				msgs = ((InternalEObject)printer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER, null, msgs);
			if (newPrinter != null)
				msgs = ((InternalEObject)newPrinter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER, null, msgs);
			msgs = basicSetPrinter(newPrinter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER, newPrinter, newPrinter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getOperand() {
		if (operand == null) {
			operand = new EObjectContainmentEList<Expression>(Expression.class, this, ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__OPERAND);
		}
		return operand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER:
				return basicSetPrinter(null, msgs);
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__OPERAND:
				return ((InternalEList<?>)getOperand()).basicRemove(otherEnd, msgs);
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
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__SYMBOL:
				return getSymbol();
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER:
				return getPrinter();
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__OPERAND:
				return getOperand();
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
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__SYMBOL:
				setSymbol((String)newValue);
				return;
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER:
				setPrinter((ValueExpressionPrettyPrinter)newValue);
				return;
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__OPERAND:
				getOperand().clear();
				getOperand().addAll((Collection<? extends Expression>)newValue);
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
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__SYMBOL:
				setSymbol(SYMBOL_EDEFAULT);
				return;
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER:
				setPrinter((ValueExpressionPrettyPrinter)null);
				return;
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__OPERAND:
				getOperand().clear();
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
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__SYMBOL:
				return SYMBOL_EDEFAULT == null ? symbol != null : !SYMBOL_EDEFAULT.equals(symbol);
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__PRINTER:
				return printer != null;
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION__OPERAND:
				return operand != null && !operand.isEmpty();
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
		result.append(" (symbol: ");
		result.append(symbol);
		result.append(')');
		return result.toString();
	}

} //ValuePrintableExpressionImpl
