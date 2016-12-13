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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Com Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.OutputComStatement#getRigthValue <em>Rigth Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getOutputComStatement()
 * @model
 * @generated
 */
public interface OutputComStatement extends AbstractComStatement {
	/**
	 * Returns the value of the '<em><b>Rigth Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.expression.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rigth Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rigth Value</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getOutputComStatement_RigthValue()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getRigthValue();

} // OutputComStatement
