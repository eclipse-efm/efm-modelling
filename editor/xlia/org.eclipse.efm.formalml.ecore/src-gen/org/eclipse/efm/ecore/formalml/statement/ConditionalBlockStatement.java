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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Block Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement#getBodyBlock <em>Body Block</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getConditionalBlockStatement()
 * @model
 * @generated
 */
public interface ConditionalBlockStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getConditionalBlockStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Block</em>' containment reference.
	 * @see #setBodyBlock(BlockStatement)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getConditionalBlockStatement_BodyBlock()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BlockStatement getBodyBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement#getBodyBlock <em>Body Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Block</em>' containment reference.
	 * @see #getBodyBlock()
	 * @generated
	 */
	void setBodyBlock(BlockStatement value);

} // ConditionalBlockStatement
