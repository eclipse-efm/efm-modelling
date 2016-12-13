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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Printable Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getPrinter <em>Printer</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getValuePrintableExpression()
 * @model
 * @generated
 */
public interface ValuePrintableExpression extends Expression {
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
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getValuePrintableExpression_Symbol()
	 * @model required="true"
	 * @generated
	 */
	String getSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(String value);

	/**
	 * Returns the value of the '<em><b>Printer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Printer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Printer</em>' containment reference.
	 * @see #setPrinter(ValueExpressionPrettyPrinter)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getValuePrintableExpression_Printer()
	 * @model containment="true"
	 * @generated
	 */
	ValueExpressionPrettyPrinter getPrinter();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getPrinter <em>Printer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Printer</em>' containment reference.
	 * @see #getPrinter()
	 * @generated
	 */
	void setPrinter(ValueExpressionPrettyPrinter value);

	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.expression.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getValuePrintableExpression_Operand()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getOperand();

} // ValuePrintableExpression
