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

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Each Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ForEachStatement#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ForEachStatement#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getForEachStatement()
 * @model
 * @generated
 */
public interface ForEachStatement extends ConditionalBlockStatement {
	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' containment reference.
	 * @see #setIterator(LeftHandSideExpression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getForEachStatement_Iterator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LeftHandSideExpression getIterator();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ForEachStatement#getIterator <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' containment reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(LeftHandSideExpression value);

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' containment reference.
	 * @see #setEnumeration(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getForEachStatement_Enumeration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getEnumeration();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ForEachStatement#getEnumeration <em>Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' containment reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(Expression value);

} // ForEachStatement
