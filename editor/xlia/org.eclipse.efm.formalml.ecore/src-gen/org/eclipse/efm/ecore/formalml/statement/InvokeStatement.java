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
package org.eclipse.efm.ecore.formalml.statement;

import org.eclipse.efm.ecore.formalml.common.NamedElement;

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.TupleExpression;

import org.eclipse.efm.ecore.formalml.infrastructure.Variable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#isCallProcedure <em>Call Procedure</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#isExecRoutine <em>Exec Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getInvokable <em>Invokable</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getRets <em>Rets</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInvokeStatement()
 * @model
 * @generated
 */
public interface InvokeStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Call Procedure</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Procedure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Procedure</em>' attribute.
	 * @see #setCallProcedure(boolean)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInvokeStatement_CallProcedure()
	 * @model default="false"
	 * @generated
	 */
	boolean isCallProcedure();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#isCallProcedure <em>Call Procedure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Procedure</em>' attribute.
	 * @see #isCallProcedure()
	 * @generated
	 */
	void setCallProcedure(boolean value);

	/**
	 * Returns the value of the '<em><b>Exec Routine</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exec Routine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exec Routine</em>' attribute.
	 * @see #setExecRoutine(boolean)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInvokeStatement_ExecRoutine()
	 * @model default="false"
	 * @generated
	 */
	boolean isExecRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#isExecRoutine <em>Exec Routine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exec Routine</em>' attribute.
	 * @see #isExecRoutine()
	 * @generated
	 */
	void setExecRoutine(boolean value);

	/**
	 * Returns the value of the '<em><b>Invokable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invokable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invokable</em>' reference.
	 * @see #setInvokable(NamedElement)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInvokeStatement_Invokable()
	 * @model
	 * @generated
	 */
	NamedElement getInvokable();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getInvokable <em>Invokable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invokable</em>' reference.
	 * @see #getInvokable()
	 * @generated
	 */
	void setInvokable(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference.
	 * @see #setArgs(TupleExpression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInvokeStatement_Args()
	 * @model containment="true"
	 * @generated
	 */
	TupleExpression getArgs();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getArgs <em>Args</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Args</em>' containment reference.
	 * @see #getArgs()
	 * @generated
	 */
	void setArgs(TupleExpression value);

	/**
	 * Returns the value of the '<em><b>Rets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rets</em>' reference list.
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInvokeStatement_Rets()
	 * @model
	 * @generated
	 */
	EList<Variable> getRets();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInvokeStatement_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // InvokeStatement
