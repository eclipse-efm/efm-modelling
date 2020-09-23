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
 * A representation of the model object '<em><b>As Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getExpressionAsBuffer()
 * @model
 * @generated
 */
public interface ExpressionAsBuffer extends Expression {
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' containment reference.
	 * @see #setBuffer(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getExpressionAsBuffer_Buffer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getBuffer();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer#getBuffer <em>Buffer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' containment reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(Expression value);

} // ExpressionAsBuffer
