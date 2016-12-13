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
 *   - Initial API and Implementation
 */
package org.eclipse.efm.runconfiguration.workflow.test;

import org.eclipse.efm.runconfiguration.workflow.WorkflowPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.runconfiguration.workflow.test.TestFactory
 * @model kind="package"
 * @generated
 */
public interface TestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "test";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/Workflow/Test";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Test";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestPackage eINSTANCE = org.eclipse.efm.runconfiguration.workflow.test.impl.TestPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.runconfiguration.workflow.test.impl.OfflineTestWorkerImpl <em>Offline Test Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.runconfiguration.workflow.test.impl.OfflineTestWorkerImpl
	 * @see org.eclipse.efm.runconfiguration.workflow.test.impl.TestPackageImpl#getOfflineTestWorker()
	 * @generated
	 */
	int OFFLINE_TEST_WORKER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__NAME = WorkflowPackage.WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__DESCRIPTION = WorkflowPackage.WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__COMMENT = WorkflowPackage.WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__MANIFEST = WorkflowPackage.WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__DIRECTOR = WorkflowPackage.WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__CONSOLE = WorkflowPackage.WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Merged Trace File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__MERGED_TRACE_FILE = WorkflowPackage.WORKER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Test Purpose File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__TEST_PURPOSE_FILE = WorkflowPackage.WORKER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Observable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__OBSERVABLE = WorkflowPackage.WORKER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Controllable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER__CONTROLLABLE = WorkflowPackage.WORKER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Offline Test Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER_FEATURE_COUNT = WorkflowPackage.WORKER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Offline Test Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_TEST_WORKER_OPERATION_COUNT = WorkflowPackage.WORKER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker <em>Offline Test Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Offline Test Worker</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker
	 * @generated
	 */
	EClass getOfflineTestWorker();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker#getMergedTraceFile <em>Merged Trace File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Merged Trace File</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker#getMergedTraceFile()
	 * @see #getOfflineTestWorker()
	 * @generated
	 */
	EAttribute getOfflineTestWorker_MergedTraceFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker#getTestPurposeFile <em>Test Purpose File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Purpose File</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker#getTestPurposeFile()
	 * @see #getOfflineTestWorker()
	 * @generated
	 */
	EAttribute getOfflineTestWorker_TestPurposeFile();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker#getObservable <em>Observable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Observable</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker#getObservable()
	 * @see #getOfflineTestWorker()
	 * @generated
	 */
	EReference getOfflineTestWorker_Observable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker#getControllable <em>Controllable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Controllable</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorker#getControllable()
	 * @see #getOfflineTestWorker()
	 * @generated
	 */
	EReference getOfflineTestWorker_Controllable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestFactory getTestFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.efm.runconfiguration.workflow.test.impl.OfflineTestWorkerImpl <em>Offline Test Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.runconfiguration.workflow.test.impl.OfflineTestWorkerImpl
		 * @see org.eclipse.efm.runconfiguration.workflow.test.impl.TestPackageImpl#getOfflineTestWorker()
		 * @generated
		 */
		EClass OFFLINE_TEST_WORKER = eINSTANCE.getOfflineTestWorker();

		/**
		 * The meta object literal for the '<em><b>Merged Trace File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFLINE_TEST_WORKER__MERGED_TRACE_FILE = eINSTANCE.getOfflineTestWorker_MergedTraceFile();

		/**
		 * The meta object literal for the '<em><b>Test Purpose File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFLINE_TEST_WORKER__TEST_PURPOSE_FILE = eINSTANCE.getOfflineTestWorker_TestPurposeFile();

		/**
		 * The meta object literal for the '<em><b>Observable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OFFLINE_TEST_WORKER__OBSERVABLE = eINSTANCE.getOfflineTestWorker_Observable();

		/**
		 * The meta object literal for the '<em><b>Controllable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OFFLINE_TEST_WORKER__CONTROLLABLE = eINSTANCE.getOfflineTestWorker_Controllable();

	}

} //TestPackage
