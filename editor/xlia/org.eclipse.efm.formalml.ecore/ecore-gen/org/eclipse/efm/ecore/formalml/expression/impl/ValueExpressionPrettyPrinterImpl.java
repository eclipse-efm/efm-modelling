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

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;
import org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX;
import org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Expression Pretty Printer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueExpressionPrettyPrinterImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueExpressionPrettyPrinterImpl#getFix <em>Fix</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueExpressionPrettyPrinterImpl#getSpecific <em>Specific</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ValueExpressionPrettyPrinterImpl extends MinimalEObjectImpl.Container implements ValueExpressionPrettyPrinter {
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
	 * The default value of the '{@link #getFix() <em>Fix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFix()
	 * @generated
	 * @ordered
	 */
	protected static final PRINTER_FIX FIX_EDEFAULT = PRINTER_FIX.INFIX;

	/**
	 * The cached value of the '{@link #getFix() <em>Fix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFix()
	 * @generated
	 * @ordered
	 */
	protected PRINTER_FIX fix = FIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpecific() <em>Specific</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecific()
	 * @generated
	 * @ordered
	 */
	protected EList<String> specific;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueExpressionPrettyPrinterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.VALUE_EXPRESSION_PRETTY_PRINTER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SYMBOL, oldSymbol, symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PRINTER_FIX getFix() {
		return fix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFix(PRINTER_FIX newFix) {
		PRINTER_FIX oldFix = fix;
		fix = newFix == null ? FIX_EDEFAULT : newFix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__FIX, oldFix, fix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getSpecific() {
		if (specific == null) {
			specific = new EDataTypeUniqueEList<String>(String.class, this, ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SPECIFIC);
		}
		return specific;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SYMBOL:
				return getSymbol();
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__FIX:
				return getFix();
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SPECIFIC:
				return getSpecific();
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
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SYMBOL:
				setSymbol((String)newValue);
				return;
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__FIX:
				setFix((PRINTER_FIX)newValue);
				return;
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SPECIFIC:
				getSpecific().clear();
				getSpecific().addAll((Collection<? extends String>)newValue);
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
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SYMBOL:
				setSymbol(SYMBOL_EDEFAULT);
				return;
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__FIX:
				setFix(FIX_EDEFAULT);
				return;
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SPECIFIC:
				getSpecific().clear();
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
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SYMBOL:
				return SYMBOL_EDEFAULT == null ? symbol != null : !SYMBOL_EDEFAULT.equals(symbol);
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__FIX:
				return fix != FIX_EDEFAULT;
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER__SPECIFIC:
				return specific != null && !specific.isEmpty();
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
		result.append(", fix: ");
		result.append(fix);
		result.append(", specific: ");
		result.append(specific);
		result.append(')');
		return result.toString();
	}

} //ValueExpressionPrettyPrinterImpl
