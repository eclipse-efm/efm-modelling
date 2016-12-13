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
package org.eclipse.efm.ecore.formalml.statement;

import org.eclipse.efm.ecore.formalml.expression.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Newfresh Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.NewfreshStatement#getLeftValue <em>Left Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getNewfreshStatement()
 * @model
 * @generated
 */
public interface NewfreshStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Value</em>' containment reference.
	 * @see #setLeftValue(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getNewfreshStatement_LeftValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getLeftValue();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.NewfreshStatement#getLeftValue <em>Left Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Value</em>' containment reference.
	 * @see #getLeftValue()
	 * @generated
	 */
	void setLeftValue(Expression value);

} // NewfreshStatement
