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
package org.eclipse.efm.ecore.formalml.expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#isCallProcedure <em>Call Procedure</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getInvokable <em>Invokable</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getRets <em>Rets</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getInvokeExpression()
 * @model
 * @generated
 */
public interface InvokeExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Call Procedure</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Procedure</em>' attribute.
	 * @see #setCallProcedure(boolean)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getInvokeExpression_CallProcedure()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isCallProcedure();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#isCallProcedure <em>Call Procedure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Procedure</em>' attribute.
	 * @see #isCallProcedure()
	 * @generated
	 */
	void setCallProcedure(boolean value);

	/**
	 * Returns the value of the '<em><b>Invokable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invokable</em>' containment reference.
	 * @see #setInvokable(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getInvokeExpression_Invokable()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInvokable();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getInvokable <em>Invokable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invokable</em>' containment reference.
	 * @see #getInvokable()
	 * @generated
	 */
	void setInvokable(Expression value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.expression.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getInvokeExpression_Args()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArgs();

	/**
	 * Returns the value of the '<em><b>Rets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.expression.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rets</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getInvokeExpression_Rets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getRets();

} // InvokeExpression
