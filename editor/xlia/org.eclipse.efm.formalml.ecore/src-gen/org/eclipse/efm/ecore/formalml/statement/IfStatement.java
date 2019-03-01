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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.IfStatement#getElseifStatement <em>Elseif Statement</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.IfStatement#getElseBlock <em>Else Block</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends ConditionalBlockStatement {
	/**
	 * Returns the value of the '<em><b>Elseif Statement</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elseif Statement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elseif Statement</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getIfStatement_ElseifStatement()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConditionalBlockStatement> getElseifStatement();

	/**
	 * Returns the value of the '<em><b>Else Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Block</em>' containment reference.
	 * @see #setElseBlock(BlockStatement)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getIfStatement_ElseBlock()
	 * @model containment="true"
	 * @generated
	 */
	BlockStatement getElseBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.IfStatement#getElseBlock <em>Else Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Block</em>' containment reference.
	 * @see #getElseBlock()
	 * @generated
	 */
	void setElseBlock(BlockStatement value);

} // IfStatement
