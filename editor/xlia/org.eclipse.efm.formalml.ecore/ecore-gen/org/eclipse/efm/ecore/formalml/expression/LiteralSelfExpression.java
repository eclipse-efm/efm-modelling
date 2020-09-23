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

import org.eclipse.efm.ecore.formalml.infrastructure.Machine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Self Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralSelfExpression()
 * @model
 * @generated
 */
public interface LiteralSelfExpression extends LiteralReferenceExpression {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(Machine)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralSelfExpression_Model()
	 * @model
	 * @generated
	 */
	Machine getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Machine value);

} // LiteralSelfExpression
