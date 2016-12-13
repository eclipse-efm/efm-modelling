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
package org.eclipse.efm.runconfiguration.workflow.coverage;

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
 * @see org.eclipse.efm.runconfiguration.workflow.coverage.CoverageFactory
 * @model kind="package"
 * @generated
 */
public interface CoveragePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "coverage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/Workflow/Coverage";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Coverage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoveragePackage eINSTANCE = org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.TransitionCoverageWorkerImpl <em>Transition Coverage Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.TransitionCoverageWorkerImpl
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getTransitionCoverageWorker()
	 * @generated
	 */
	int TRANSITION_COVERAGE_WORKER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__NAME = WorkflowPackage.COVERAGE_WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__DESCRIPTION = WorkflowPackage.COVERAGE_WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__COMMENT = WorkflowPackage.COVERAGE_WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__MANIFEST = WorkflowPackage.COVERAGE_WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__DIRECTOR = WorkflowPackage.COVERAGE_WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__CONSOLE = WorkflowPackage.COVERAGE_WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__TRACE = WorkflowPackage.COVERAGE_WORKER__TRACE;

	/**
	 * The feature id for the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__NORMALIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__MINIMIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__STOP_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__BREAK_ENABLED = WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED;

	/**
	 * The feature id for the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__SLICE_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__HEURISTIC_ENABLED = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__SCOPE = WorkflowPackage.COVERAGE_WORKER__SCOPE;

	/**
	 * The feature id for the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER__HEURISTIC_CONFIG = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG;

	/**
	 * The number of structural features of the '<em>Transition Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER_FEATURE_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Transition Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_COVERAGE_WORKER_OPERATION_COUNT = WorkflowPackage.COVERAGE_WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.InputOutputCoverageWorkerImpl <em>Input Output Coverage Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.InputOutputCoverageWorkerImpl
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getInputOutputCoverageWorker()
	 * @generated
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__NAME = WorkflowPackage.COVERAGE_WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__DESCRIPTION = WorkflowPackage.COVERAGE_WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__COMMENT = WorkflowPackage.COVERAGE_WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__MANIFEST = WorkflowPackage.COVERAGE_WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__DIRECTOR = WorkflowPackage.COVERAGE_WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__CONSOLE = WorkflowPackage.COVERAGE_WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__TRACE = WorkflowPackage.COVERAGE_WORKER__TRACE;

	/**
	 * The feature id for the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__NORMALIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__MINIMIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__STOP_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__BREAK_ENABLED = WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED;

	/**
	 * The feature id for the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__SLICE_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__HEURISTIC_ENABLED = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__SCOPE = WorkflowPackage.COVERAGE_WORKER__SCOPE;

	/**
	 * The feature id for the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER__HEURISTIC_CONFIG = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG;

	/**
	 * The number of structural features of the '<em>Input Output Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER_FEATURE_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Input Output Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_COVERAGE_WORKER_OPERATION_COUNT = WorkflowPackage.COVERAGE_WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.ConditionCoverageWorkerImpl <em>Condition Coverage Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.ConditionCoverageWorkerImpl
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getConditionCoverageWorker()
	 * @generated
	 */
	int CONDITION_COVERAGE_WORKER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__NAME = WorkflowPackage.COVERAGE_WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__DESCRIPTION = WorkflowPackage.COVERAGE_WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__COMMENT = WorkflowPackage.COVERAGE_WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__MANIFEST = WorkflowPackage.COVERAGE_WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__DIRECTOR = WorkflowPackage.COVERAGE_WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__CONSOLE = WorkflowPackage.COVERAGE_WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__TRACE = WorkflowPackage.COVERAGE_WORKER__TRACE;

	/**
	 * The feature id for the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__NORMALIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__MINIMIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__STOP_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__BREAK_ENABLED = WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED;

	/**
	 * The feature id for the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__SLICE_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__HEURISTIC_ENABLED = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__SCOPE = WorkflowPackage.COVERAGE_WORKER__SCOPE;

	/**
	 * The feature id for the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER__HEURISTIC_CONFIG = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG;

	/**
	 * The number of structural features of the '<em>Condition Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER_FEATURE_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Condition Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_COVERAGE_WORKER_OPERATION_COUNT = WorkflowPackage.COVERAGE_WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.DecisionCoverageWorkerImpl <em>Decision Coverage Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.DecisionCoverageWorkerImpl
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getDecisionCoverageWorker()
	 * @generated
	 */
	int DECISION_COVERAGE_WORKER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__NAME = WorkflowPackage.COVERAGE_WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__DESCRIPTION = WorkflowPackage.COVERAGE_WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__COMMENT = WorkflowPackage.COVERAGE_WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__MANIFEST = WorkflowPackage.COVERAGE_WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__DIRECTOR = WorkflowPackage.COVERAGE_WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__CONSOLE = WorkflowPackage.COVERAGE_WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__TRACE = WorkflowPackage.COVERAGE_WORKER__TRACE;

	/**
	 * The feature id for the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__NORMALIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__MINIMIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__STOP_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__BREAK_ENABLED = WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED;

	/**
	 * The feature id for the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__SLICE_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__HEURISTIC_ENABLED = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__SCOPE = WorkflowPackage.COVERAGE_WORKER__SCOPE;

	/**
	 * The feature id for the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER__HEURISTIC_CONFIG = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG;

	/**
	 * The number of structural features of the '<em>Decision Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER_FEATURE_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Decision Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_COVERAGE_WORKER_OPERATION_COUNT = WorkflowPackage.COVERAGE_WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.ConditionDecisionCoverageWorkerImpl <em>Condition Decision Coverage Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.ConditionDecisionCoverageWorkerImpl
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getConditionDecisionCoverageWorker()
	 * @generated
	 */
	int CONDITION_DECISION_COVERAGE_WORKER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__NAME = WorkflowPackage.COVERAGE_WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__DESCRIPTION = WorkflowPackage.COVERAGE_WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__COMMENT = WorkflowPackage.COVERAGE_WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__MANIFEST = WorkflowPackage.COVERAGE_WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__DIRECTOR = WorkflowPackage.COVERAGE_WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__CONSOLE = WorkflowPackage.COVERAGE_WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__TRACE = WorkflowPackage.COVERAGE_WORKER__TRACE;

	/**
	 * The feature id for the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__NORMALIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__MINIMIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__STOP_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__BREAK_ENABLED = WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED;

	/**
	 * The feature id for the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__SLICE_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__HEURISTIC_ENABLED = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__SCOPE = WorkflowPackage.COVERAGE_WORKER__SCOPE;

	/**
	 * The feature id for the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER__HEURISTIC_CONFIG = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG;

	/**
	 * The number of structural features of the '<em>Condition Decision Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER_FEATURE_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Condition Decision Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_DECISION_COVERAGE_WORKER_OPERATION_COUNT = WorkflowPackage.COVERAGE_WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.ModifiedConditionDecisionCoverageWorkerImpl <em>Modified Condition Decision Coverage Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.ModifiedConditionDecisionCoverageWorkerImpl
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getModifiedConditionDecisionCoverageWorker()
	 * @generated
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__NAME = WorkflowPackage.COVERAGE_WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__DESCRIPTION = WorkflowPackage.COVERAGE_WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__COMMENT = WorkflowPackage.COVERAGE_WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__MANIFEST = WorkflowPackage.COVERAGE_WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__DIRECTOR = WorkflowPackage.COVERAGE_WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__CONSOLE = WorkflowPackage.COVERAGE_WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__TRACE = WorkflowPackage.COVERAGE_WORKER__TRACE;

	/**
	 * The feature id for the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__NORMALIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__MINIMIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__STOP_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__BREAK_ENABLED = WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED;

	/**
	 * The feature id for the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__SLICE_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__HEURISTIC_ENABLED = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__SCOPE = WorkflowPackage.COVERAGE_WORKER__SCOPE;

	/**
	 * The feature id for the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER__HEURISTIC_CONFIG = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG;

	/**
	 * The number of structural features of the '<em>Modified Condition Decision Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER_FEATURE_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Modified Condition Decision Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_CONDITION_DECISION_COVERAGE_WORKER_OPERATION_COUNT = WorkflowPackage.COVERAGE_WORKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.BehaviorCoverageWorkerImpl <em>Behavior Coverage Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.BehaviorCoverageWorkerImpl
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getBehaviorCoverageWorker()
	 * @generated
	 */
	int BEHAVIOR_COVERAGE_WORKER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__NAME = WorkflowPackage.COVERAGE_WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__DESCRIPTION = WorkflowPackage.COVERAGE_WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__COMMENT = WorkflowPackage.COVERAGE_WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__MANIFEST = WorkflowPackage.COVERAGE_WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__DIRECTOR = WorkflowPackage.COVERAGE_WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__CONSOLE = WorkflowPackage.COVERAGE_WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__TRACE = WorkflowPackage.COVERAGE_WORKER__TRACE;

	/**
	 * The feature id for the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__NORMALIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__MINIMIZATION_ENABLED = WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED;

	/**
	 * The feature id for the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__STOP_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__BREAK_ENABLED = WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED;

	/**
	 * The feature id for the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__SLICE_WHEN_COMPLETE = WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE;

	/**
	 * The feature id for the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__HEURISTIC_ENABLED = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__SCOPE = WorkflowPackage.COVERAGE_WORKER__SCOPE;

	/**
	 * The feature id for the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__HEURISTIC_CONFIG = WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG;

	/**
	 * The feature id for the '<em><b>Checking Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__CHECKING_SCOPE = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ordered Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__ORDERED_TRACE = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Hit Consecutive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__HIT_CONSECUTIVE = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hit Folding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__HIT_FOLDING = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hit Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__HIT_MAX = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Hit Lucky</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__HIT_LUCKY = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Jump Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__JUMP_HEIGHT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Jump Trials Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__JUMP_TRIALS_LIMIT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Hit Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__HIT_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Jump Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__JUMP_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Jump Slice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__JUMP_SLICE = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER__BEHAVIOR = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Behavior Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER_FEATURE_COUNT = WorkflowPackage.COVERAGE_WORKER_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Behavior Coverage Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_COVERAGE_WORKER_OPERATION_COUNT = WorkflowPackage.COVERAGE_WORKER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.runconfiguration.workflow.coverage.TransitionCoverageWorker <em>Transition Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Coverage Worker</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.TransitionCoverageWorker
	 * @generated
	 */
	EClass getTransitionCoverageWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.runconfiguration.workflow.coverage.InputOutputCoverageWorker <em>Input Output Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Output Coverage Worker</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.InputOutputCoverageWorker
	 * @generated
	 */
	EClass getInputOutputCoverageWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.runconfiguration.workflow.coverage.ConditionCoverageWorker <em>Condition Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Coverage Worker</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.ConditionCoverageWorker
	 * @generated
	 */
	EClass getConditionCoverageWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.runconfiguration.workflow.coverage.DecisionCoverageWorker <em>Decision Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision Coverage Worker</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.DecisionCoverageWorker
	 * @generated
	 */
	EClass getDecisionCoverageWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.runconfiguration.workflow.coverage.ConditionDecisionCoverageWorker <em>Condition Decision Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Decision Coverage Worker</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.ConditionDecisionCoverageWorker
	 * @generated
	 */
	EClass getConditionDecisionCoverageWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.runconfiguration.workflow.coverage.ModifiedConditionDecisionCoverageWorker <em>Modified Condition Decision Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modified Condition Decision Coverage Worker</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.ModifiedConditionDecisionCoverageWorker
	 * @generated
	 */
	EClass getModifiedConditionDecisionCoverageWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker <em>Behavior Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Coverage Worker</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker
	 * @generated
	 */
	EClass getBehaviorCoverageWorker();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getCheckingScope <em>Checking Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checking Scope</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getCheckingScope()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_CheckingScope();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isOrderedTrace <em>Ordered Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordered Trace</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isOrderedTrace()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_OrderedTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isHitConsecutive <em>Hit Consecutive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Consecutive</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isHitConsecutive()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_HitConsecutive();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isHitFolding <em>Hit Folding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Folding</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isHitFolding()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_HitFolding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isHitMax <em>Hit Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Max</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isHitMax()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_HitMax();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isHitLucky <em>Hit Lucky</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Lucky</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isHitLucky()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_HitLucky();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getJumpHeight <em>Jump Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jump Height</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getJumpHeight()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_JumpHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getJumpTrialsLimit <em>Jump Trials Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jump Trials Limit</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getJumpTrialsLimit()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_JumpTrialsLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getHitCount <em>Hit Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Count</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getHitCount()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_HitCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getJumpCount <em>Jump Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jump Count</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getJumpCount()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_JumpCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isJumpSlice <em>Jump Slice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jump Slice</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#isJumpSlice()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EAttribute getBehaviorCoverageWorker_JumpSlice();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior</em>'.
	 * @see org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorker#getBehavior()
	 * @see #getBehaviorCoverageWorker()
	 * @generated
	 */
	EReference getBehaviorCoverageWorker_Behavior();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoverageFactory getCoverageFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.TransitionCoverageWorkerImpl <em>Transition Coverage Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.TransitionCoverageWorkerImpl
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getTransitionCoverageWorker()
		 * @generated
		 */
		EClass TRANSITION_COVERAGE_WORKER = eINSTANCE.getTransitionCoverageWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.InputOutputCoverageWorkerImpl <em>Input Output Coverage Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.InputOutputCoverageWorkerImpl
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getInputOutputCoverageWorker()
		 * @generated
		 */
		EClass INPUT_OUTPUT_COVERAGE_WORKER = eINSTANCE.getInputOutputCoverageWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.ConditionCoverageWorkerImpl <em>Condition Coverage Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.ConditionCoverageWorkerImpl
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getConditionCoverageWorker()
		 * @generated
		 */
		EClass CONDITION_COVERAGE_WORKER = eINSTANCE.getConditionCoverageWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.DecisionCoverageWorkerImpl <em>Decision Coverage Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.DecisionCoverageWorkerImpl
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getDecisionCoverageWorker()
		 * @generated
		 */
		EClass DECISION_COVERAGE_WORKER = eINSTANCE.getDecisionCoverageWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.ConditionDecisionCoverageWorkerImpl <em>Condition Decision Coverage Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.ConditionDecisionCoverageWorkerImpl
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getConditionDecisionCoverageWorker()
		 * @generated
		 */
		EClass CONDITION_DECISION_COVERAGE_WORKER = eINSTANCE.getConditionDecisionCoverageWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.ModifiedConditionDecisionCoverageWorkerImpl <em>Modified Condition Decision Coverage Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.ModifiedConditionDecisionCoverageWorkerImpl
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getModifiedConditionDecisionCoverageWorker()
		 * @generated
		 */
		EClass MODIFIED_CONDITION_DECISION_COVERAGE_WORKER = eINSTANCE.getModifiedConditionDecisionCoverageWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.runconfiguration.workflow.coverage.impl.BehaviorCoverageWorkerImpl <em>Behavior Coverage Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.BehaviorCoverageWorkerImpl
		 * @see org.eclipse.efm.runconfiguration.workflow.coverage.impl.CoveragePackageImpl#getBehaviorCoverageWorker()
		 * @generated
		 */
		EClass BEHAVIOR_COVERAGE_WORKER = eINSTANCE.getBehaviorCoverageWorker();

		/**
		 * The meta object literal for the '<em><b>Checking Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__CHECKING_SCOPE = eINSTANCE.getBehaviorCoverageWorker_CheckingScope();

		/**
		 * The meta object literal for the '<em><b>Ordered Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__ORDERED_TRACE = eINSTANCE.getBehaviorCoverageWorker_OrderedTrace();

		/**
		 * The meta object literal for the '<em><b>Hit Consecutive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__HIT_CONSECUTIVE = eINSTANCE.getBehaviorCoverageWorker_HitConsecutive();

		/**
		 * The meta object literal for the '<em><b>Hit Folding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__HIT_FOLDING = eINSTANCE.getBehaviorCoverageWorker_HitFolding();

		/**
		 * The meta object literal for the '<em><b>Hit Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__HIT_MAX = eINSTANCE.getBehaviorCoverageWorker_HitMax();

		/**
		 * The meta object literal for the '<em><b>Hit Lucky</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__HIT_LUCKY = eINSTANCE.getBehaviorCoverageWorker_HitLucky();

		/**
		 * The meta object literal for the '<em><b>Jump Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__JUMP_HEIGHT = eINSTANCE.getBehaviorCoverageWorker_JumpHeight();

		/**
		 * The meta object literal for the '<em><b>Jump Trials Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__JUMP_TRIALS_LIMIT = eINSTANCE.getBehaviorCoverageWorker_JumpTrialsLimit();

		/**
		 * The meta object literal for the '<em><b>Hit Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__HIT_COUNT = eINSTANCE.getBehaviorCoverageWorker_HitCount();

		/**
		 * The meta object literal for the '<em><b>Jump Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__JUMP_COUNT = eINSTANCE.getBehaviorCoverageWorker_JumpCount();

		/**
		 * The meta object literal for the '<em><b>Jump Slice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_COVERAGE_WORKER__JUMP_SLICE = eINSTANCE.getBehaviorCoverageWorker_JumpSlice();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_COVERAGE_WORKER__BEHAVIOR = eINSTANCE.getBehaviorCoverageWorker_Behavior();

	}

} //CoveragePackage
