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
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getComparer <em>Comparer</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getSolver <em>Solver</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getPathScope <em>Path Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getDataScope <em>Data Scope</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection()
 * @model
 * @generated
 */
public interface RedundancyDetection extends EObject {
	/**
	 * Returns the value of the '<em><b>Comparer</b></em>' attribute.
	 * The default value is <code>"INCLUSION"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparer</em>' attribute.
	 * @see #setComparer(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_Comparer()
	 * @model default="INCLUSION"
	 * @generated
	 */
	String getComparer();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getComparer <em>Comparer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparer</em>' attribute.
	 * @see #getComparer()
	 * @generated
	 */
	void setComparer(String value);

	/**
	 * Returns the value of the '<em><b>Solver</b></em>' attribute.
	 * The default value is <code>"OMEGA"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solver</em>' attribute.
	 * @see #setSolver(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_Solver()
	 * @model default="OMEGA"
	 * @generated
	 */
	String getSolver();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getSolver <em>Solver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solver</em>' attribute.
	 * @see #getSolver()
	 * @generated
	 */
	void setSolver(String value);

	/**
	 * Returns the value of the '<em><b>Path Scope</b></em>' attribute.
	 * The default value is <code>"CURRENT"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Scope</em>' attribute.
	 * @see #setPathScope(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getRedundancyDetection_PathScope()
	 * @model default="CURRENT"
	 * @generated
	 */
	String getPathScope();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getPathScope <em>Path Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Scope</em>' attribute.
	 * @see #getPathScope()
	 * @generated
	 */
	void setPathScope(String value);

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

} // RedundancyDetection
