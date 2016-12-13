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
package org.eclipse.efm.ecore.formalml.expression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Expression Pretty Printer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getFix <em>Fix</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getSpecific <em>Specific</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getValueExpressionPrettyPrinter()
 * @model abstract="true"
 * @generated
 */
public interface ValueExpressionPrettyPrinter extends EObject {
	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' attribute.
	 * @see #setSymbol(String)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getValueExpressionPrettyPrinter_Symbol()
	 * @model required="true"
	 * @generated
	 */
	String getSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(String value);

	/**
	 * Returns the value of the '<em><b>Fix</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fix</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX
	 * @see #setFix(PRINTER_FIX)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getValueExpressionPrettyPrinter_Fix()
	 * @model required="true"
	 * @generated
	 */
	PRINTER_FIX getFix();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getFix <em>Fix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fix</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX
	 * @see #getFix()
	 * @generated
	 */
	void setFix(PRINTER_FIX value);

	/**
	 * Returns the value of the '<em><b>Specific</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific</em>' attribute list.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getValueExpressionPrettyPrinter_Specific()
	 * @model
	 * @generated
	 */
	EList<String> getSpecific();

} // ValueExpressionPrettyPrinter
