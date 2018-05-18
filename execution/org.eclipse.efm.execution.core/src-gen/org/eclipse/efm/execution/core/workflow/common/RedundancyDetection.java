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
 * A representation of the model object '<em><b>Redundancy Detection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#isEnabledDetetction <em>Enabled Detetction</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getPathScope <em>Path Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getComparerOperation <em>Comparer Operation</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getSolverChoice <em>Solver Choice</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getDataScope <em>Data Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#isEnabledTrivialLoopDetetction <em>Enabled Trivial Loop Detetction</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection()
 * @model
 * @generated
 */
public interface RedundancyDetection extends EObject {
	/**
	 * Returns the value of the '<em><b>Enabled Detetction</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Detetction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Detetction</em>' attribute.
	 * @see #setEnabledDetetction(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_EnabledDetetction()
	 * @model default="true"
	 * @generated
	 */
	boolean isEnabledDetetction();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#isEnabledDetetction <em>Enabled Detetction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Detetction</em>' attribute.
	 * @see #isEnabledDetetction()
	 * @generated
	 */
	void setEnabledDetetction(boolean value);

	/**
	 * Returns the value of the '<em><b>Path Scope</b></em>' attribute.
	 * The default value is <code>"CURRENT"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.RedundancyPathScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Scope</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyPathScope
	 * @see #setPathScope(RedundancyPathScope)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_PathScope()
	 * @model default="CURRENT"
	 * @generated
	 */
	RedundancyPathScope getPathScope();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getPathScope <em>Path Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Scope</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyPathScope
	 * @see #getPathScope()
	 * @generated
	 */
	void setPathScope(RedundancyPathScope value);

	/**
	 * Returns the value of the '<em><b>Comparer Operation</b></em>' attribute.
	 * The default value is <code>"INCLUSION"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.RedundancyComparerOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparer Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparer Operation</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyComparerOperation
	 * @see #setComparerOperation(RedundancyComparerOperation)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_ComparerOperation()
	 * @model default="INCLUSION"
	 * @generated
	 */
	RedundancyComparerOperation getComparerOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getComparerOperation <em>Comparer Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparer Operation</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyComparerOperation
	 * @see #getComparerOperation()
	 * @generated
	 */
	void setComparerOperation(RedundancyComparerOperation value);

	/**
	 * Returns the value of the '<em><b>Solver Choice</b></em>' attribute.
	 * The default value is <code>"OMEGA"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.SolverKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solver Choice</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solver Choice</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.SolverKind
	 * @see #setSolverChoice(SolverKind)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_SolverChoice()
	 * @model default="OMEGA"
	 * @generated
	 */
	SolverKind getSolverChoice();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getSolverChoice <em>Solver Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solver Choice</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.SolverKind
	 * @see #getSolverChoice()
	 * @generated
	 */
	void setSolverChoice(SolverKind value);

	/**
	 * Returns the value of the '<em><b>Data Scope</b></em>' attribute.
	 * The default value is <code>"ALL"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Scope</em>' attribute.
	 * @see #setDataScope(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_DataScope()
	 * @model default="ALL"
	 * @generated
	 */
	String getDataScope();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getDataScope <em>Data Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Scope</em>' attribute.
	 * @see #getDataScope()
	 * @generated
	 */
	void setDataScope(String value);

	/**
	 * Returns the value of the '<em><b>Enabled Trivial Loop Detetction</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Trivial Loop Detetction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Trivial Loop Detetction</em>' attribute.
	 * @see #setEnabledTrivialLoopDetetction(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_EnabledTrivialLoopDetetction()
	 * @model default="true"
	 * @generated
	 */
	boolean isEnabledTrivialLoopDetetction();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#isEnabledTrivialLoopDetetction <em>Enabled Trivial Loop Detetction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Trivial Loop Detetction</em>' attribute.
	 * @see #isEnabledTrivialLoopDetetction()
	 * @generated
	 */
	void setEnabledTrivialLoopDetetction(boolean value);

} // RedundancyDetection
