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
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRightOperator <em>Right Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRightOperand <em>Right Operand</em>}</li>
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
	 * Returns the value of the '<em><b>Right Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operator</em>' attribute.
	 * @see #setRightOperator(String)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getRelationalTernaryExpression_RightOperator()
	 * @model required="true"
	 * @generated
	 */
	String getRightOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRightOperator <em>Right Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operator</em>' attribute.
	 * @see #getRightOperator()
	 * @generated
	 */
	void setRightOperator(String value);

	/**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getRelationalTernaryExpression_RightOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRightOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(Expression value);

} // RelationalTernaryExpression
