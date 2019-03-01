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
package org.eclipse.efm.ecore.formalml.statement;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interrupt Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatement#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatement#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInterruptStatement()
 * @model
 * @generated
 */
public interface InterruptStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind
	 * @see #setKind(InterruptStatementKind)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInterruptStatement_Kind()
	 * @model
	 * @generated
	 */
	InterruptStatementKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatement#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(InterruptStatementKind value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.expression.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getInterruptStatement_Expr()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpr();

} // InterruptStatement
