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

import org.eclipse.efm.ecore.formalml.infrastructure.Machine;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Parent Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralParentExpression()
 * @model
 * @generated
 */
public interface LiteralParentExpression extends LiteralReferenceExpression {

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(Machine)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralParentExpression_Model()
	 * @model
	 * @generated
	 */
	Machine getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Machine value);
} // LiteralParentExpression
