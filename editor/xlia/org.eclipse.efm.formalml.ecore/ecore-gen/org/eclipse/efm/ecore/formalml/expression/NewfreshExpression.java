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
 * A representation of the model object '<em><b>Newfresh Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.NewfreshExpression#getLeftHandSide <em>Left Hand Side</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getNewfreshExpression()
 * @model
 * @generated
 */
public interface NewfreshExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #setLeftHandSide(LeftHandSideExpression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getNewfreshExpression_LeftHandSide()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LeftHandSideExpression getLeftHandSide();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.NewfreshExpression#getLeftHandSide <em>Left Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #getLeftHandSide()
	 * @generated
	 */
	void setLeftHandSide(LeftHandSideExpression value);

} // NewfreshExpression
