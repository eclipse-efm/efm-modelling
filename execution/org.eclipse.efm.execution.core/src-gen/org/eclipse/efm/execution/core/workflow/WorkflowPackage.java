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
package org.eclipse.efm.execution.core.workflow;

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
 * @see org.eclipse.efm.execution.core.workflow.WorkflowFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface WorkflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/Workflow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Workflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowPackage eINSTANCE = org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.impl.NamedObjectImpl <em>Named Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.impl.NamedObjectImpl
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getNamedObject()
	 * @generated
	 */
	int NAMED_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT__COMMENT = 2;

	/**
	 * The number of structural features of the '<em>Named Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Named Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getWorkflow()
	 * @generated
	 */
	int WORKFLOW = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__NAME = NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__DESCRIPTION = NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__COMMENT = NAMED_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__MANIFEST = NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Workspace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__WORKSPACE = NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Director</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__DIRECTOR = NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Symbex Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__SYMBEX_OPTION = NAMED_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__CONSOLE = NAMED_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Shell Mode</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__SHELL_MODE = NAMED_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Developer Tuning</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__DEVELOPER_TUNING = NAMED_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_FEATURE_COUNT = NAMED_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_OPERATION_COUNT = NAMED_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.impl.DirectorImpl <em>Director</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.impl.DirectorImpl
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getDirector()
	 * @generated
	 */
	int DIRECTOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__NAME = NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__DESCRIPTION = NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__COMMENT = NAMED_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__MANIFEST = NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Workflow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__WORKFLOW = NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__PROJECT = NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Supervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__SUPERVISOR = NAMED_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Worker</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__WORKER = NAMED_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__CONSOLE = NAMED_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Developer Tuning</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__DEVELOPER_TUNING = NAMED_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Director</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR_FEATURE_COUNT = NAMED_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Director</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR_OPERATION_COUNT = NAMED_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.impl.WorkerImpl <em>Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getWorker()
	 * @generated
	 */
	int WORKER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__NAME = NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__DESCRIPTION = NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__COMMENT = NAMED_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__MANIFEST = NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__DIRECTOR = NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__CONSOLE = NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FEATURE_COUNT = NAMED_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_OPERATION_COUNT = NAMED_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl <em>Supervisor Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getSupervisorWorker()
	 * @generated
	 */
	int SUPERVISOR_WORKER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__NAME = WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__DESCRIPTION = WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__COMMENT = WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__MANIFEST = WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__DIRECTOR = WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__CONSOLE = WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Limit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__LIMIT = WORKER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Queue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__QUEUE = WORKER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extender</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__EXTENDER = WORKER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Redundancy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER__REDUNDANCY = WORKER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Supervisor Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER_FEATURE_COUNT = WORKER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Supervisor Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERVISOR_WORKER_OPERATION_COUNT = WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.impl.CoverageWorkerImpl <em>Coverage Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.impl.CoverageWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getCoverageWorker()
	 * @generated
	 */
	int COVERAGE_WORKER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__NAME = WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__DESCRIPTION = WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__COMMENT = WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__MANIFEST = WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__DIRECTOR = WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__CONSOLE = WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__TRACE = WORKER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__NORMALIZATION_ENABLED = WORKER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__MINIMIZATION_ENABLED = WORKER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__STOP_WHEN_COMPLETE = WORKER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__BREAK_ENABLED = WORKER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__SLICE_WHEN_COMPLETE = WORKER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__HEURISTIC_ENABLED = WORKER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__SCOPE = WORKER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER__HEURISTIC_CONFIG = WORKER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER_FEATURE_COUNT = WORKER_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_WORKER_OPERATION_COUNT = WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.impl.TestWorkerImpl <em>Test Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.impl.TestWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getTestWorker()
	 * @generated
	 */
	int TEST_WORKER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_WORKER__NAME = WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_WORKER__DESCRIPTION = WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_WORKER__COMMENT = WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_WORKER__MANIFEST = WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_WORKER__DIRECTOR = WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_WORKER__CONSOLE = WORKER__CONSOLE;

	/**
	 * The number of structural features of the '<em>Test Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_WORKER_FEATURE_COUNT = WORKER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Test Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_WORKER_OPERATION_COUNT = WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl <em>Serializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.impl.SerializerImpl
	 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getSerializer()
	 * @generated
	 */
	int SERIALIZER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__NAME = WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__DESCRIPTION = WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__COMMENT = WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__MANIFEST = WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__DIRECTOR = WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__CONSOLE = WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__FORMAT = WORKER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__TRACE = WORKER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__FOLDER_NAME = WORKER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__FILE_NAME = WORKER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__ENABLED_NORMALIZATION = WORKER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING = WORKER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__ENABLED_LIFELINES_PRINTING = WORKER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_FEATURE_COUNT = WORKER_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_OPERATION_COUNT = WORKER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.NamedObject <em>Named Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Object</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.NamedObject
	 * @generated
	 */
	EClass getNamedObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.NamedObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.NamedObject#getName()
	 * @see #getNamedObject()
	 * @generated
	 */
	EAttribute getNamedObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.NamedObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.NamedObject#getDescription()
	 * @see #getNamedObject()
	 * @generated
	 */
	EAttribute getNamedObject_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.NamedObject#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.NamedObject#getComment()
	 * @see #getNamedObject()
	 * @generated
	 */
	EAttribute getNamedObject_Comment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.Workflow <em>Workflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workflow</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Workflow
	 * @generated
	 */
	EClass getWorkflow();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Workflow#getManifest <em>Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Manifest</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Workflow#getManifest()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_Manifest();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Workflow#getWorkspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Workspace</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Workflow#getWorkspace()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_Workspace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.execution.core.workflow.Workflow#getDirector <em>Director</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Director</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Workflow#getDirector()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_Director();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Workflow#getSymbexOption <em>Symbex Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Symbex Option</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Workflow#getSymbexOption()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_SymbexOption();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Workflow#getConsole <em>Console</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Console</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Workflow#getConsole()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_Console();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Workflow#getShellMode <em>Shell Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Shell Mode</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Workflow#getShellMode()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_ShellMode();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Workflow#getDeveloperTuning <em>Developer Tuning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Developer Tuning</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Workflow#getDeveloperTuning()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_DeveloperTuning();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.Director <em>Director</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Director</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Director
	 * @generated
	 */
	EClass getDirector();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Director#getManifest <em>Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Manifest</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Director#getManifest()
	 * @see #getDirector()
	 * @generated
	 */
	EReference getDirector_Manifest();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.execution.core.workflow.Director#getWorkflow <em>Workflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Workflow</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Director#getWorkflow()
	 * @see #getDirector()
	 * @generated
	 */
	EReference getDirector_Workflow();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Director#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Director#getProject()
	 * @see #getDirector()
	 * @generated
	 */
	EReference getDirector_Project();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Director#getSupervisor <em>Supervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Supervisor</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Director#getSupervisor()
	 * @see #getDirector()
	 * @generated
	 */
	EReference getDirector_Supervisor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.execution.core.workflow.Director#getWorker <em>Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Director#getWorker()
	 * @see #getDirector()
	 * @generated
	 */
	EReference getDirector_Worker();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Director#getConsole <em>Console</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Console</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Director#getConsole()
	 * @see #getDirector()
	 * @generated
	 */
	EReference getDirector_Console();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Director#getDeveloperTuning <em>Developer Tuning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Developer Tuning</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Director#getDeveloperTuning()
	 * @see #getDirector()
	 * @generated
	 */
	EReference getDirector_DeveloperTuning();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.Worker <em>Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Worker
	 * @generated
	 */
	EClass getWorker();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Worker#getManifest <em>Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Manifest</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Worker#getManifest()
	 * @see #getWorker()
	 * @generated
	 */
	EReference getWorker_Manifest();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.execution.core.workflow.Worker#getDirector <em>Director</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Director</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Worker#getDirector()
	 * @see #getWorker()
	 * @generated
	 */
	EReference getWorker_Director();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Worker#getConsole <em>Console</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Console</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Worker#getConsole()
	 * @see #getWorker()
	 * @generated
	 */
	EReference getWorker_Console();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.SupervisorWorker <em>Supervisor Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supervisor Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.SupervisorWorker
	 * @generated
	 */
	EClass getSupervisorWorker();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.SupervisorWorker#getLimit <em>Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Limit</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.SupervisorWorker#getLimit()
	 * @see #getSupervisorWorker()
	 * @generated
	 */
	EReference getSupervisorWorker_Limit();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.SupervisorWorker#getQueue <em>Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Queue</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.SupervisorWorker#getQueue()
	 * @see #getSupervisorWorker()
	 * @generated
	 */
	EReference getSupervisorWorker_Queue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.SupervisorWorker#getExtender <em>Extender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extender</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.SupervisorWorker#getExtender()
	 * @see #getSupervisorWorker()
	 * @generated
	 */
	EReference getSupervisorWorker_Extender();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.execution.core.workflow.SupervisorWorker#getRedundancy <em>Redundancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Redundancy</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.SupervisorWorker#getRedundancy()
	 * @see #getSupervisorWorker()
	 * @generated
	 */
	EReference getSupervisorWorker_Redundancy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker <em>Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coverage Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker
	 * @generated
	 */
	EClass getCoverageWorker();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trace</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#getTrace()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EReference getCoverageWorker_Trace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isNormalizationEnabled <em>Normalization Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normalization Enabled</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#isNormalizationEnabled()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EAttribute getCoverageWorker_NormalizationEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isMinimizationEnabled <em>Minimization Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimization Enabled</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#isMinimizationEnabled()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EAttribute getCoverageWorker_MinimizationEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isStopWhenComplete <em>Stop When Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop When Complete</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#isStopWhenComplete()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EAttribute getCoverageWorker_StopWhenComplete();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isBreakEnabled <em>Break Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Break Enabled</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#isBreakEnabled()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EAttribute getCoverageWorker_BreakEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isSliceWhenComplete <em>Slice When Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slice When Complete</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#isSliceWhenComplete()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EAttribute getCoverageWorker_SliceWhenComplete();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isHeuristicEnabled <em>Heuristic Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heuristic Enabled</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#isHeuristicEnabled()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EAttribute getCoverageWorker_HeuristicEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#getScope()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EAttribute getCoverageWorker_Scope();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getHeuristicConfig <em>Heuristic Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heuristic Config</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker#getHeuristicConfig()
	 * @see #getCoverageWorker()
	 * @generated
	 */
	EReference getCoverageWorker_HeuristicConfig();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.TestWorker <em>Test Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.TestWorker
	 * @generated
	 */
	EClass getTestWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.Serializer <em>Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serializer</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer
	 * @generated
	 */
	EClass getSerializer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Serializer#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Format</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer#getFormat()
	 * @see #getSerializer()
	 * @generated
	 */
	EReference getSerializer_Format();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.Serializer#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trace</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer#getTrace()
	 * @see #getSerializer()
	 * @generated
	 */
	EReference getSerializer_Trace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.Serializer#getFolderName <em>Folder Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Folder Name</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer#getFolderName()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_FolderName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.Serializer#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer#getFileName()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledNormalization <em>Enabled Normalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Normalization</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer#isEnabledNormalization()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_EnabledNormalization();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledInitialValuesPrinting <em>Enabled Initial Values Printing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Initial Values Printing</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer#isEnabledInitialValuesPrinting()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_EnabledInitialValuesPrinting();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledLifelinesPrinting <em>Enabled Lifelines Printing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Lifelines Printing</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer#isEnabledLifelinesPrinting()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_EnabledLifelinesPrinting();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkflowFactory getWorkflowFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.impl.NamedObjectImpl <em>Named Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.impl.NamedObjectImpl
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getNamedObject()
		 * @generated
		 */
		EClass NAMED_OBJECT = eINSTANCE.getNamedObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_OBJECT__NAME = eINSTANCE.getNamedObject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_OBJECT__DESCRIPTION = eINSTANCE.getNamedObject_Description();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_OBJECT__COMMENT = eINSTANCE.getNamedObject_Comment();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getWorkflow()
		 * @generated
		 */
		EClass WORKFLOW = eINSTANCE.getWorkflow();

		/**
		 * The meta object literal for the '<em><b>Manifest</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__MANIFEST = eINSTANCE.getWorkflow_Manifest();

		/**
		 * The meta object literal for the '<em><b>Workspace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__WORKSPACE = eINSTANCE.getWorkflow_Workspace();

		/**
		 * The meta object literal for the '<em><b>Director</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__DIRECTOR = eINSTANCE.getWorkflow_Director();

		/**
		 * The meta object literal for the '<em><b>Symbex Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__SYMBEX_OPTION = eINSTANCE.getWorkflow_SymbexOption();

		/**
		 * The meta object literal for the '<em><b>Console</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__CONSOLE = eINSTANCE.getWorkflow_Console();

		/**
		 * The meta object literal for the '<em><b>Shell Mode</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__SHELL_MODE = eINSTANCE.getWorkflow_ShellMode();

		/**
		 * The meta object literal for the '<em><b>Developer Tuning</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__DEVELOPER_TUNING = eINSTANCE.getWorkflow_DeveloperTuning();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.impl.DirectorImpl <em>Director</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.impl.DirectorImpl
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getDirector()
		 * @generated
		 */
		EClass DIRECTOR = eINSTANCE.getDirector();

		/**
		 * The meta object literal for the '<em><b>Manifest</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTOR__MANIFEST = eINSTANCE.getDirector_Manifest();

		/**
		 * The meta object literal for the '<em><b>Workflow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTOR__WORKFLOW = eINSTANCE.getDirector_Workflow();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTOR__PROJECT = eINSTANCE.getDirector_Project();

		/**
		 * The meta object literal for the '<em><b>Supervisor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTOR__SUPERVISOR = eINSTANCE.getDirector_Supervisor();

		/**
		 * The meta object literal for the '<em><b>Worker</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTOR__WORKER = eINSTANCE.getDirector_Worker();

		/**
		 * The meta object literal for the '<em><b>Console</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTOR__CONSOLE = eINSTANCE.getDirector_Console();

		/**
		 * The meta object literal for the '<em><b>Developer Tuning</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTOR__DEVELOPER_TUNING = eINSTANCE.getDirector_DeveloperTuning();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.impl.WorkerImpl <em>Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getWorker()
		 * @generated
		 */
		EClass WORKER = eINSTANCE.getWorker();

		/**
		 * The meta object literal for the '<em><b>Manifest</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKER__MANIFEST = eINSTANCE.getWorker_Manifest();

		/**
		 * The meta object literal for the '<em><b>Director</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKER__DIRECTOR = eINSTANCE.getWorker_Director();

		/**
		 * The meta object literal for the '<em><b>Console</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKER__CONSOLE = eINSTANCE.getWorker_Console();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl <em>Supervisor Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getSupervisorWorker()
		 * @generated
		 */
		EClass SUPERVISOR_WORKER = eINSTANCE.getSupervisorWorker();

		/**
		 * The meta object literal for the '<em><b>Limit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERVISOR_WORKER__LIMIT = eINSTANCE.getSupervisorWorker_Limit();

		/**
		 * The meta object literal for the '<em><b>Queue</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERVISOR_WORKER__QUEUE = eINSTANCE.getSupervisorWorker_Queue();

		/**
		 * The meta object literal for the '<em><b>Extender</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERVISOR_WORKER__EXTENDER = eINSTANCE.getSupervisorWorker_Extender();

		/**
		 * The meta object literal for the '<em><b>Redundancy</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERVISOR_WORKER__REDUNDANCY = eINSTANCE.getSupervisorWorker_Redundancy();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.impl.CoverageWorkerImpl <em>Coverage Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.impl.CoverageWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getCoverageWorker()
		 * @generated
		 */
		EClass COVERAGE_WORKER = eINSTANCE.getCoverageWorker();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COVERAGE_WORKER__TRACE = eINSTANCE.getCoverageWorker_Trace();

		/**
		 * The meta object literal for the '<em><b>Normalization Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_WORKER__NORMALIZATION_ENABLED = eINSTANCE.getCoverageWorker_NormalizationEnabled();

		/**
		 * The meta object literal for the '<em><b>Minimization Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_WORKER__MINIMIZATION_ENABLED = eINSTANCE.getCoverageWorker_MinimizationEnabled();

		/**
		 * The meta object literal for the '<em><b>Stop When Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_WORKER__STOP_WHEN_COMPLETE = eINSTANCE.getCoverageWorker_StopWhenComplete();

		/**
		 * The meta object literal for the '<em><b>Break Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_WORKER__BREAK_ENABLED = eINSTANCE.getCoverageWorker_BreakEnabled();

		/**
		 * The meta object literal for the '<em><b>Slice When Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_WORKER__SLICE_WHEN_COMPLETE = eINSTANCE.getCoverageWorker_SliceWhenComplete();

		/**
		 * The meta object literal for the '<em><b>Heuristic Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_WORKER__HEURISTIC_ENABLED = eINSTANCE.getCoverageWorker_HeuristicEnabled();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_WORKER__SCOPE = eINSTANCE.getCoverageWorker_Scope();

		/**
		 * The meta object literal for the '<em><b>Heuristic Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COVERAGE_WORKER__HEURISTIC_CONFIG = eINSTANCE.getCoverageWorker_HeuristicConfig();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.impl.TestWorkerImpl <em>Test Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.impl.TestWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getTestWorker()
		 * @generated
		 */
		EClass TEST_WORKER = eINSTANCE.getTestWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl <em>Serializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.impl.SerializerImpl
		 * @see org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl#getSerializer()
		 * @generated
		 */
		EClass SERIALIZER = eINSTANCE.getSerializer();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER__FORMAT = eINSTANCE.getSerializer_Format();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER__TRACE = eINSTANCE.getSerializer_Trace();

		/**
		 * The meta object literal for the '<em><b>Folder Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__FOLDER_NAME = eINSTANCE.getSerializer_FolderName();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__FILE_NAME = eINSTANCE.getSerializer_FileName();

		/**
		 * The meta object literal for the '<em><b>Enabled Normalization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__ENABLED_NORMALIZATION = eINSTANCE.getSerializer_EnabledNormalization();

		/**
		 * The meta object literal for the '<em><b>Enabled Initial Values Printing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING = eINSTANCE.getSerializer_EnabledInitialValuesPrinting();

		/**
		 * The meta object literal for the '<em><b>Enabled Lifelines Printing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__ENABLED_LIFELINES_PRINTING = eINSTANCE.getSerializer_EnabledLifelinesPrinting();

	}

} //WorkflowPackage
