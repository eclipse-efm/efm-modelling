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
 * A representation of the model object '<em><b>Conditional Test Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getThenOperand <em>Then Operand</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getElseOperand <em>Else Operand</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getConditionalTestExpression()
 * @model
 * @generated
 */
public interface ConditionalTestExpression extends Expression {
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
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getConditionalTestExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

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
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getConditionalTestExpression_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Then Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Operand</em>' containment reference.
	 * @see #setThenOperand(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getConditionalTestExpression_ThenOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getThenOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getThenOperand <em>Then Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Operand</em>' containment reference.
	 * @see #getThenOperand()
	 * @generated
	 */
	void setThenOperand(Expression value);

	/**
	 * Returns the value of the '<em><b>Else Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Operand</em>' containment reference.
	 * @see #setElseOperand(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getConditionalTestExpression_ElseOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getElseOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getElseOperand <em>Else Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Operand</em>' containment reference.
	 * @see #getElseOperand()
	 * @generated
	 */
	void setElseOperand(Expression value);

} // ConditionalTestExpression
