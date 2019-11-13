/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.execution.core.workflow.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbex Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.SymbexOption#getConstraintSolver <em>Constraint Solver</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.SymbexOption#getRawOptions <em>Raw Options</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getSymbexOption()
 * @model
 * @generated
 */
public interface SymbexOption extends EObject {

	/**
	 * Returns the value of the '<em><b>Constraint Solver</b></em>' attribute.
	 * The default value is <code>"CVC4"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.SolverKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Solver</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.SolverKind
	 * @see #setConstraintSolver(SolverKind)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getSymbexOption_ConstraintSolver()
	 * @model default="CVC4"
	 * @generated
	 */
	SolverKind getConstraintSolver();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.SymbexOption#getConstraintSolver <em>Constraint Solver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Solver</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.SolverKind
	 * @see #getConstraintSolver()
	 * @generated
	 */
	void setConstraintSolver(SolverKind value);

	/**
	 * Returns the value of the '<em><b>Raw Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Options</em>' attribute.
	 * @see #setRawOptions(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getSymbexOption_RawOptions()
	 * @model
	 * @generated
	 */
	String getRawOptions();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.SymbexOption#getRawOptions <em>Raw Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Options</em>' attribute.
	 * @see #getRawOptions()
	 * @generated
	 */
	void setRawOptions(String value);
} // SymbexOption
