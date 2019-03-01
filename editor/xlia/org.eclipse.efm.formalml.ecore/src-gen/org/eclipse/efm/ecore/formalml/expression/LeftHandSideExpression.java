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
 * A representation of the model object '<em><b>Left Hand Side Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression#getLvalue <em>Lvalue</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLeftHandSideExpression()
 * @model
 * @generated
 */
public interface LeftHandSideExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Lvalue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lvalue</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lvalue</em>' containment reference.
	 * @see #setLvalue(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLeftHandSideExpression_Lvalue()
	 * @model containment="true"
	 * @generated
	 */
	Expression getLvalue();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression#getLvalue <em>Lvalue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lvalue</em>' containment reference.
	 * @see #getLvalue()
	 * @generated
	 */
	void setLvalue(Expression value);

} // LeftHandSideExpression
