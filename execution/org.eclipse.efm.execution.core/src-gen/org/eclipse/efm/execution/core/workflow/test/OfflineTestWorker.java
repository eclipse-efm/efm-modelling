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
package org.eclipse.efm.execution.core.workflow.test;

import org.eclipse.efm.execution.core.workflow.Worker;

import org.eclipse.efm.execution.core.workflow.common.TraceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Offline Test Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker#getMergedTraceFile <em>Merged Trace File</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker#getTestPurposeFile <em>Test Purpose File</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker#getObservable <em>Observable</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker#getControllable <em>Controllable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.test.TestPackage#getOfflineTestWorker()
 * @model
 * @generated
 */
public interface OfflineTestWorker extends Worker {
	/**
	 * Returns the value of the '<em><b>Merged Trace File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merged Trace File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merged Trace File</em>' attribute.
	 * @see #setMergedTraceFile(String)
	 * @see org.eclipse.efm.execution.core.workflow.test.TestPackage#getOfflineTestWorker_MergedTraceFile()
	 * @model
	 * @generated
	 */
	String getMergedTraceFile();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker#getMergedTraceFile <em>Merged Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Merged Trace File</em>' attribute.
	 * @see #getMergedTraceFile()
	 * @generated
	 */
	void setMergedTraceFile(String value);

	/**
	 * Returns the value of the '<em><b>Test Purpose File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Purpose File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Purpose File</em>' attribute.
	 * @see #setTestPurposeFile(String)
	 * @see org.eclipse.efm.execution.core.workflow.test.TestPackage#getOfflineTestWorker_TestPurposeFile()
	 * @model
	 * @generated
	 */
	String getTestPurposeFile();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker#getTestPurposeFile <em>Test Purpose File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Purpose File</em>' attribute.
	 * @see #getTestPurposeFile()
	 * @generated
	 */
	void setTestPurposeFile(String value);

	/**
	 * Returns the value of the '<em><b>Observable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observable</em>' containment reference.
	 * @see #setObservable(TraceSpecification)
	 * @see org.eclipse.efm.execution.core.workflow.test.TestPackage#getOfflineTestWorker_Observable()
	 * @model containment="true"
	 * @generated
	 */
	TraceSpecification getObservable();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker#getObservable <em>Observable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observable</em>' containment reference.
	 * @see #getObservable()
	 * @generated
	 */
	void setObservable(TraceSpecification value);

	/**
	 * Returns the value of the '<em><b>Controllable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controllable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controllable</em>' containment reference.
	 * @see #setControllable(TraceSpecification)
	 * @see org.eclipse.efm.execution.core.workflow.test.TestPackage#getOfflineTestWorker_Controllable()
	 * @model containment="true"
	 * @generated
	 */
	TraceSpecification getControllable();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker#getControllable <em>Controllable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controllable</em>' containment reference.
	 * @see #getControllable()
	 * @generated
	 */
	void setControllable(TraceSpecification value);

} // OfflineTestWorker
