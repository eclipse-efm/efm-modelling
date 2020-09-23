/**
 * Copyright (c) 2020 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html\n\nContributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Increment Or Decrement Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression#getLeftHandSide <em>Left Hand Side</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getIncrementOrDecrementExpression()
 * @model abstract="true"
 * @generated
 */
public interface IncrementOrDecrementExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getIncrementOrDecrementExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression#getOperator <em>Operator</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #setLeftHandSide(LeftHandSideExpression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getIncrementOrDecrementExpression_LeftHandSide()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LeftHandSideExpression getLeftHandSide();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression#getLeftHandSide <em>Left Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #getLeftHandSide()
	 * @generated
	 */
	void setLeftHandSide(LeftHandSideExpression value);

} // IncrementOrDecrementExpression
