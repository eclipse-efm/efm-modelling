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
package org.eclipse.efm.ecore.formalml.statement;

import org.eclipse.efm.ecore.formalml.expression.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ForStatement#getInit <em>Init</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ForStatement#getIterate <em>Iterate</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends ConditionalBlockStatement {
	/**
	 * Returns the value of the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init</em>' containment reference.
	 * @see #setInit(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getForStatement_Init()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInit();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ForStatement#getInit <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' containment reference.
	 * @see #getInit()
	 * @generated
	 */
	void setInit(Expression value);

	/**
	 * Returns the value of the '<em><b>Iterate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterate</em>' containment reference.
	 * @see #setIterate(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getForStatement_Iterate()
	 * @model containment="true"
	 * @generated
	 */
	Expression getIterate();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ForStatement#getIterate <em>Iterate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterate</em>' containment reference.
	 * @see #getIterate()
	 * @generated
	 */
	void setIterate(Expression value);

} // ForStatement
