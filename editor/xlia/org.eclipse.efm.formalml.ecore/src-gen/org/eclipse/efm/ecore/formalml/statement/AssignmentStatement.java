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

import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getRigthHandSide <em>Rigth Hand Side</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAssignmentStatement()
 * @model
 * @generated
 */
public interface AssignmentStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(AssignmentExpression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAssignmentStatement_Expression()
	 * @model containment="true"
	 * @generated
	 */
	AssignmentExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(AssignmentExpression value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAssignmentStatement_Operator()
	 * @model required="true"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

	/**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Hand Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #setLeftHandSide(LeftHandSideExpression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAssignmentStatement_LeftHandSide()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LeftHandSideExpression getLeftHandSide();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getLeftHandSide <em>Left Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #getLeftHandSide()
	 * @generated
	 */
	void setLeftHandSide(LeftHandSideExpression value);

	/**
	 * Returns the value of the '<em><b>Rigth Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rigth Hand Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rigth Hand Side</em>' containment reference.
	 * @see #setRigthHandSide(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAssignmentStatement_RigthHandSide()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRigthHandSide();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getRigthHandSide <em>Rigth Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rigth Hand Side</em>' containment reference.
	 * @see #getRigthHandSide()
	 * @generated
	 */
	void setRigthHandSide(Expression value);

} // AssignmentStatement
