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
 * A representation of the model object '<em><b>As Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine#getMachine <em>Machine</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getExpressionAsMachine()
 * @model
 * @generated
 */
public interface ExpressionAsMachine extends Expression {
	/**
	 * Returns the value of the '<em><b>Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' containment reference.
	 * @see #setMachine(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getExpressionAsMachine_Machine()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getMachine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine#getMachine <em>Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine</em>' containment reference.
	 * @see #getMachine()
	 * @generated
	 */
	void setMachine(Expression value);

} // ExpressionAsMachine