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
 * A representation of the model object '<em><b>Literal Integer Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralIntegerExpression()
 * @model
 * @generated
 */
public interface LiteralIntegerExpression extends LiteralExpression {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(long)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralIntegerExpression_Value()
	 * @model default="0" required="true"
	 * @generated
	 */
	long getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(long value);

} // LiteralIntegerExpression
