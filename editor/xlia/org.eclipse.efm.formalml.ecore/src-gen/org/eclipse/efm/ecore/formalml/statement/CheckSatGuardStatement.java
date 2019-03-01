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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check Sat Guard Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement#getSolver <em>Solver</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getCheckSatGuardStatement()
 * @model
 * @generated
 */
public interface CheckSatGuardStatement extends AbstractGuardStatement {
	/**
	 * Returns the value of the '<em><b>Solver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solver</em>' attribute.
	 * @see #setSolver(String)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getCheckSatGuardStatement_Solver()
	 * @model
	 * @generated
	 */
	String getSolver();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement#getSolver <em>Solver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solver</em>' attribute.
	 * @see #getSolver()
	 * @generated
	 */
	void setSolver(String value);

} // CheckSatGuardStatement
