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

import org.eclipse.efm.ecore.formalml.common.AbstractElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.MetaStatement#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.MetaStatement#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getMetaStatement()
 * @model
 * @generated
 */
public interface MetaStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.statement.MetaStatementKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.statement.MetaStatementKind
	 * @see #setOp(MetaStatementKind)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getMetaStatement_Op()
	 * @model required="true"
	 * @generated
	 */
	MetaStatementKind getOp();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.MetaStatement#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.statement.MetaStatementKind
	 * @see #getOp()
	 * @generated
	 */
	void setOp(MetaStatementKind value);

	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.common.AbstractElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getMetaStatement_Operand()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractElement> getOperand();

} // MetaStatement
