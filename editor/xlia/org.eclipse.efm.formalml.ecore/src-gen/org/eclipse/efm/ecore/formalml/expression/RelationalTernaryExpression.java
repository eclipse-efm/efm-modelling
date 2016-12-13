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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Ternary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getLeftRelation <em>Left Relation</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRigthOperator <em>Rigth Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRigthOperand <em>Rigth Operand</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getRelationalTernaryExpression()
 * @model
 * @generated
 */
public interface RelationalTernaryExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Left Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Relation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Relation</em>' containment reference.
	 * @see #setLeftRelation(RelationalBinaryExpression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getRelationalTernaryExpression_LeftRelation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RelationalBinaryExpression getLeftRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getLeftRelation <em>Left Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Relation</em>' containment reference.
	 * @see #getLeftRelation()
	 * @generated
	 */
	void setLeftRelation(RelationalBinaryExpression value);

	/**
	 * Returns the value of the '<em><b>Rigth Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rigth Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rigth Operator</em>' attribute.
	 * @see #setRigthOperator(String)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getRelationalTernaryExpression_RigthOperator()
	 * @model required="true"
	 * @generated
	 */
	String getRigthOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRigthOperator <em>Rigth Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rigth Operator</em>' attribute.
	 * @see #getRigthOperator()
	 * @generated
	 */
	void setRigthOperator(String value);

	/**
	 * Returns the value of the '<em><b>Rigth Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rigth Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rigth Operand</em>' containment reference.
	 * @see #setRigthOperand(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getRelationalTernaryExpression_RigthOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRigthOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRigthOperand <em>Rigth Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rigth Operand</em>' containment reference.
	 * @see #getRigthOperand()
	 * @generated
	 */
	void setRigthOperand(Expression value);

} // RelationalTernaryExpression
