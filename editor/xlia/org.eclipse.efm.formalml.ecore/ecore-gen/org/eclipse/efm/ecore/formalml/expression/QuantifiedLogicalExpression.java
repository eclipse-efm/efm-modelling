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

import org.eclipse.efm.ecore.formalml.infrastructure.Variable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantified Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getPredicate <em>Predicate</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getQuantifiedLogicalExpression()
 * @model
 * @generated
 */
public interface QuantifiedLogicalExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Quantifier</b></em>' attribute.
	 * The default value is <code>"forall"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantifier</em>' attribute.
	 * @see #setQuantifier(String)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getQuantifiedLogicalExpression_Quantifier()
	 * @model default="forall"
	 * @generated
	 */
	String getQuantifier();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getQuantifier <em>Quantifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantifier</em>' attribute.
	 * @see #getQuantifier()
	 * @generated
	 */
	void setQuantifier(String value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getQuantifiedLogicalExpression_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Variable> getVariable();

	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getQuantifiedLogicalExpression_Predicate()
	 * @model containment="true"
	 * @generated
	 */
	Expression getPredicate();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Expression value);

} // QuantifiedLogicalExpression
