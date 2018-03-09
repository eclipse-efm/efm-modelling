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

import org.eclipse.efm.execution.core.workflow.WorkflowPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.efm.execution.core.workflow.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "common";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/Workflow/Common";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Common";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonPackage eINSTANCE = org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.WorkspaceImpl <em>Workspace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.WorkspaceImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getWorkspace()
	 * @generated
	 */
	int WORKSPACE = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__PROJECT = 1;

	/**
	 * The number of structural features of the '<em>Workspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Workspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.LocationImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__OUTPUT = 1;

	/**
	 * The feature id for the '<em><b>Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__LOG = 2;

	/**
	 * The feature id for the '<em><b>Debug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__DEBUG = 3;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.ProjectImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__MODEL = 1;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl <em>Graph Exploration Limit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getGraphExplorationLimit()
	 * @generated
	 */
	int GRAPH_EXPLORATION_LIMIT = 3;

	/**
	 * The feature id for the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT__STEP = 0;

	/**
	 * The feature id for the '<em><b>Eval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT__EVAL = 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT__NODE = 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT__HEIGHT = 3;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT__WIDTH = 4;

	/**
	 * The feature id for the '<em><b>Report</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT__REPORT = 5;

	/**
	 * The feature id for the '<em><b>Save</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT__SAVE = 6;

	/**
	 * The number of structural features of the '<em>Graph Exploration Limit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Graph Exploration Limit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_LIMIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationQueueImpl <em>Graph Exploration Queue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationQueueImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getGraphExplorationQueue()
	 * @generated
	 */
	int GRAPH_EXPLORATION_QUEUE = 4;

	/**
	 * The feature id for the '<em><b>Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_QUEUE__STRATEGY = 0;

	/**
	 * The feature id for the '<em><b>Heuristic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_QUEUE__HEURISTIC = 1;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_QUEUE__WEIGHT = 2;

	/**
	 * The number of structural features of the '<em>Graph Exploration Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_QUEUE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Graph Exploration Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EXPLORATION_QUEUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl <em>Console Log Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getConsoleLogFormat()
	 * @generated
	 */
	int CONSOLE_LOG_FORMAT = 5;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_LOG_FORMAT__FORMAT = 0;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_LOG_FORMAT__BOUND = 1;

	/**
	 * The feature id for the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_LOG_FORMAT__STEP = 2;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_LOG_FORMAT__RESULT = 3;

	/**
	 * The feature id for the '<em><b>Report</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_LOG_FORMAT__REPORT = 4;

	/**
	 * The feature id for the '<em><b>Verbosity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_LOG_FORMAT__VERBOSITY = 5;

	/**
	 * The number of structural features of the '<em>Console Log Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_LOG_FORMAT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Console Log Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_LOG_FORMAT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.TraceElementImpl <em>Trace Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.TraceElementImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getTraceElement()
	 * @generated
	 */
	int TRACE_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__NATURE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Trace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Trace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.TraceSpecificationImpl <em>Trace Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.TraceSpecificationImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getTraceSpecification()
	 * @generated
	 */
	int TRACE_SPECIFICATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SPECIFICATION__NAME = WorkflowPackage.NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SPECIFICATION__DESCRIPTION = WorkflowPackage.NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SPECIFICATION__COMMENT = WorkflowPackage.NAMED_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SPECIFICATION__ELEMENT = WorkflowPackage.NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SPECIFICATION_FEATURE_COUNT = WorkflowPackage.NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Trace Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SPECIFICATION_OPERATION_COUNT = WorkflowPackage.NAMED_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.ManifestImpl <em>Manifest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.ManifestImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getManifest()
	 * @generated
	 */
	int MANIFEST = 8;

	/**
	 * The feature id for the '<em><b>Autoconf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIFEST__AUTOCONF = 0;

	/**
	 * The feature id for the '<em><b>Autostart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIFEST__AUTOSTART = 1;

	/**
	 * The number of structural features of the '<em>Manifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIFEST_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Manifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIFEST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.SymbexOptionImpl <em>Symbex Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.SymbexOptionImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getSymbexOption()
	 * @generated
	 */
	int SYMBEX_OPTION = 9;

	/**
	 * The number of structural features of the '<em>Symbex Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_OPTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Symbex Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_OPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.ShellModeImpl <em>Shell Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.ShellModeImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getShellMode()
	 * @generated
	 */
	int SHELL_MODE = 10;

	/**
	 * The feature id for the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_MODE__STOP = 0;

	/**
	 * The number of structural features of the '<em>Shell Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_MODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Shell Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_MODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl <em>Coverage Heuristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getCoverageHeuristic()
	 * @generated
	 */
	int COVERAGE_HEURISTIC = 11;

	/**
	 * The feature id for the '<em><b>Heuristic Trials</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__HEURISTIC_TRIALS = 0;

	/**
	 * The feature id for the '<em><b>Objective Rate Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__OBJECTIVE_RATE_GOAL = 1;

	/**
	 * The feature id for the '<em><b>Objective Rest Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__OBJECTIVE_REST_GOAL = 2;

	/**
	 * The feature id for the '<em><b>Heuristic Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__HEURISTIC_START = 3;

	/**
	 * The feature id for the '<em><b>Directive Trace Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__DIRECTIVE_TRACE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Directive Trace Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__DIRECTIVE_TRACE_SIZE = 5;

	/**
	 * The feature id for the '<em><b>Directive Trace Heuristic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__DIRECTIVE_TRACE_HEURISTIC = 6;

	/**
	 * The feature id for the '<em><b>Lookahead Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__LOOKAHEAD_DEPTH = 7;

	/**
	 * The feature id for the '<em><b>Lookahead Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__LOOKAHEAD_WIDTH = 8;

	/**
	 * The feature id for the '<em><b>Hit Strongly Random Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__HIT_STRONGLY_RANDOM_ENABLED = 9;

	/**
	 * The feature id for the '<em><b>Hit Strongly Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__HIT_STRONGLY_COUNT = 10;

	/**
	 * The feature id for the '<em><b>Hit Weakly Random Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__HIT_WEAKLY_RANDOM_ENABLED = 11;

	/**
	 * The feature id for the '<em><b>Hit Weakly Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__HIT_WEAKLY_COUNT = 12;

	/**
	 * The feature id for the '<em><b>Hit Other Random Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__HIT_OTHER_RANDOM_ENABLED = 13;

	/**
	 * The feature id for the '<em><b>Hit Other Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC__HIT_OTHER_COUNT = 14;

	/**
	 * The number of structural features of the '<em>Coverage Heuristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Coverage Heuristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_HEURISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl <em>Developer Tuning Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getDeveloperTuningOption()
	 * @generated
	 */
	int DEVELOPER_TUNING_OPTION = 12;

	/**
	 * The feature id for the '<em><b>Log Trace Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__LOG_TRACE_FILENAME = 0;

	/**
	 * The feature id for the '<em><b>Debug Trace Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__DEBUG_TRACE_FILENAME = 1;

	/**
	 * The feature id for the '<em><b>Debug Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__DEBUG_LEVEL = 2;

	/**
	 * The feature id for the '<em><b>Debug Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__DEBUG_FILENAME = 3;

	/**
	 * The feature id for the '<em><b>Output Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__OUTPUT_FILENAME = 4;

	/**
	 * The feature id for the '<em><b>Specification Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__SPECIFICATION_FILENAME = 5;

	/**
	 * The feature id for the '<em><b>Executable Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__EXECUTABLE_FILENAME = 6;

	/**
	 * The feature id for the '<em><b>Initialization Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__INITIALIZATION_FILENAME = 7;

	/**
	 * The feature id for the '<em><b>Symbex Graph Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__SYMBEX_GRAPH_FILENAME = 8;

	/**
	 * The feature id for the '<em><b>Parsed Model Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__PARSED_MODEL_FILENAME = 9;

	/**
	 * The feature id for the '<em><b>Compiled Model Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__COMPILED_MODEL_FILENAME = 10;

	/**
	 * The feature id for the '<em><b>Symbex Trace Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__SYMBEX_TRACE_FILENAME = 11;

	/**
	 * The feature id for the '<em><b>Enabled Parsing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_PARSING = 12;

	/**
	 * The feature id for the '<em><b>Enabled Configuring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_CONFIGURING = 13;

	/**
	 * The feature id for the '<em><b>Enabled Compiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_COMPILING = 14;

	/**
	 * The feature id for the '<em><b>Enabled Loading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_LOADING = 15;

	/**
	 * The feature id for the '<em><b>Enabled Computing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_COMPUTING = 16;

	/**
	 * The feature id for the '<em><b>Enabled Reporting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_REPORTING = 17;

	/**
	 * The feature id for the '<em><b>Enabled Solving</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_SOLVING = 18;

	/**
	 * The feature id for the '<em><b>Enabled Profiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_PROFILING = 19;

	/**
	 * The feature id for the '<em><b>Enabled All Process Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_ALL_PROCESS_STAGE = 20;

	/**
	 * The feature id for the '<em><b>Enabled Pre Processing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_PRE_PROCESSING = 21;

	/**
	 * The feature id for the '<em><b>Enabled Post Processing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_POST_PROCESSING = 22;

	/**
	 * The feature id for the '<em><b>Enabled Processing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_PROCESSING = 23;

	/**
	 * The feature id for the '<em><b>Enabled Pre Filtering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_PRE_FILTERING = 24;

	/**
	 * The feature id for the '<em><b>Enabled Post Filtering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_POST_FILTERING = 25;

	/**
	 * The feature id for the '<em><b>Enabled Filtering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_FILTERING = 26;

	/**
	 * The feature id for the '<em><b>Enabled Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_QUEUE = 27;

	/**
	 * The feature id for the '<em><b>Enabled Program</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_PROGRAM = 28;

	/**
	 * The feature id for the '<em><b>Enabled Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT = 29;

	/**
	 * The feature id for the '<em><b>Enabled Statement Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_ASSIGNMENT = 30;

	/**
	 * The feature id for the '<em><b>Enabled Statement Communication</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_COMMUNICATION = 31;

	/**
	 * The feature id for the '<em><b>Enabled Statement Test Decision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_TEST_DECISION = 32;

	/**
	 * The feature id for the '<em><b>Enabled Bytecode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_BYTECODE = 33;

	/**
	 * The feature id for the '<em><b>Enabled Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_DATA = 34;

	/**
	 * The feature id for the '<em><b>Enabled Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_TRACE = 35;

	/**
	 * The feature id for the '<em><b>Enabled Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_VARIABLE = 36;

	/**
	 * The feature id for the '<em><b>Enabled Buffer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_BUFFER = 37;

	/**
	 * The feature id for the '<em><b>Enabled Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_PORT = 38;

	/**
	 * The feature id for the '<em><b>Enabled Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_SIGNAL = 39;

	/**
	 * The feature id for the '<em><b>Enabled Connexion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_CONNEXION = 40;

	/**
	 * The feature id for the '<em><b>Enabled Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_TIME = 41;

	/**
	 * The feature id for the '<em><b>Enabled Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_EXECUTABLE = 42;

	/**
	 * The feature id for the '<em><b>Enabled Activity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_ACTIVITY = 43;

	/**
	 * The feature id for the '<em><b>Enabled Routine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_ROUTINE = 44;

	/**
	 * The feature id for the '<em><b>Enabled Transition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_TRANSITION = 45;

	/**
	 * The feature id for the '<em><b>Enabled Machine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_MACHINE = 46;

	/**
	 * The feature id for the '<em><b>Enabled Statemachine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_STATEMACHINE = 47;

	/**
	 * The feature id for the '<em><b>Enabled Name Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_NAME_ID = 48;

	/**
	 * The feature id for the '<em><b>Enabled Qualified Name Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_QUALIFIED_NAME_ID = 49;

	/**
	 * The feature id for the '<em><b>Enabled Fully Qualified Name Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_FULLY_QUALIFIED_NAME_ID = 50;

	/**
	 * The feature id for the '<em><b>Enabled Redundance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_REDUNDANCE = 51;

	/**
	 * The feature id for the '<em><b>Enabled Reference Counting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_REFERENCE_COUNTING = 52;

	/**
	 * The feature id for the '<em><b>Enabled Nothing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_NOTHING = 53;

	/**
	 * The feature id for the '<em><b>Enabled God Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION__ENABLED_GOD_MODE = 54;

	/**
	 * The number of structural features of the '<em>Developer Tuning Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION_FEATURE_COUNT = 55;

	/**
	 * The number of operations of the '<em>Developer Tuning Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVELOPER_TUNING_OPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl <em>Redundancy Detection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getRedundancyDetection()
	 * @generated
	 */
	int REDUNDANCY_DETECTION = 13;

	/**
	 * The feature id for the '<em><b>Comparer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_DETECTION__COMPARER = 0;

	/**
	 * The feature id for the '<em><b>Solver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_DETECTION__SOLVER = 1;

	/**
	 * The feature id for the '<em><b>Path Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_DETECTION__PATH_SCOPE = 2;

	/**
	 * The feature id for the '<em><b>Data Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_DETECTION__DATA_SCOPE = 3;

	/**
	 * The feature id for the '<em><b>Loop Detetction Trivial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_DETECTION__LOOP_DETETCTION_TRIVIAL = 4;

	/**
	 * The number of structural features of the '<em>Redundancy Detection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_DETECTION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Redundancy Detection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANCY_DETECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind <em>Graph Exploration Strategy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getGraphExplorationStrategyKind()
	 * @generated
	 */
	int GRAPH_EXPLORATION_STRATEGY_KIND = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind <em>Console Verbosity Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getConsoleVerbosityKind()
	 * @generated
	 */
	int CONSOLE_VERBOSITY_KIND = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.TraceElementKind <em>Trace Element Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.TraceElementKind
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getTraceElementKind()
	 * @generated
	 */
	int TRACE_ELEMENT_KIND = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind <em>Heuristic Class Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getHeuristicClassKind()
	 * @generated
	 */
	int HEURISTIC_CLASS_KIND = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind <em>Coverage Scope Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getCoverageScopeKind()
	 * @generated
	 */
	int COVERAGE_SCOPE_KIND = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.CheckingScopeKind <em>Checking Scope Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.CheckingScopeKind
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getCheckingScopeKind()
	 * @generated
	 */
	int CHECKING_SCOPE_KIND = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.common.DebuglevelKind <em>Debuglevel Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.common.DebuglevelKind
	 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getDebuglevelKind()
	 * @generated
	 */
	int DEBUGLEVEL_KIND = 20;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.Workspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workspace</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Workspace
	 * @generated
	 */
	EClass getWorkspace();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.common.Workspace#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Workspace#getLocation()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_Location();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.execution.core.workflow.common.Workspace#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Workspace#getProject()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_Project();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.Location#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Location#getRoot()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Root();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.Location#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Location#getOutput()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Output();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.Location#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Location#getLog()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Log();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.Location#getDebug <em>Debug</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Location#getDebug()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Debug();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.Project#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Project#getSource()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.Project#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Project#getModel()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Model();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit <em>Graph Exploration Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Exploration Limit</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit
	 * @generated
	 */
	EClass getGraphExplorationLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getStep()
	 * @see #getGraphExplorationLimit()
	 * @generated
	 */
	EAttribute getGraphExplorationLimit_Step();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getEval <em>Eval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eval</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getEval()
	 * @see #getGraphExplorationLimit()
	 * @generated
	 */
	EAttribute getGraphExplorationLimit_Eval();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getNode()
	 * @see #getGraphExplorationLimit()
	 * @generated
	 */
	EAttribute getGraphExplorationLimit_Node();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getHeight()
	 * @see #getGraphExplorationLimit()
	 * @generated
	 */
	EAttribute getGraphExplorationLimit_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getWidth()
	 * @see #getGraphExplorationLimit()
	 * @generated
	 */
	EAttribute getGraphExplorationLimit_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Report</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getReport()
	 * @see #getGraphExplorationLimit()
	 * @generated
	 */
	EAttribute getGraphExplorationLimit_Report();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getSave <em>Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Save</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getSave()
	 * @see #getGraphExplorationLimit()
	 * @generated
	 */
	EAttribute getGraphExplorationLimit_Save();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue <em>Graph Exploration Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Exploration Queue</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue
	 * @generated
	 */
	EClass getGraphExplorationQueue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#getStrategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strategy</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#getStrategy()
	 * @see #getGraphExplorationQueue()
	 * @generated
	 */
	EAttribute getGraphExplorationQueue_Strategy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#isHeuristic <em>Heuristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heuristic</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#isHeuristic()
	 * @see #getGraphExplorationQueue()
	 * @generated
	 */
	EAttribute getGraphExplorationQueue_Heuristic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#getWeight()
	 * @see #getGraphExplorationQueue()
	 * @generated
	 */
	EAttribute getGraphExplorationQueue_Weight();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat <em>Console Log Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Console Log Format</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat
	 * @generated
	 */
	EClass getConsoleLogFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getFormat()
	 * @see #getConsoleLogFormat()
	 * @generated
	 */
	EAttribute getConsoleLogFormat_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getBound <em>Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getBound()
	 * @see #getConsoleLogFormat()
	 * @generated
	 */
	EAttribute getConsoleLogFormat_Bound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getStep()
	 * @see #getConsoleLogFormat()
	 * @generated
	 */
	EAttribute getConsoleLogFormat_Step();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getResult()
	 * @see #getConsoleLogFormat()
	 * @generated
	 */
	EAttribute getConsoleLogFormat_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Report</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getReport()
	 * @see #getConsoleLogFormat()
	 * @generated
	 */
	EAttribute getConsoleLogFormat_Report();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getVerbosity <em>Verbosity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verbosity</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getVerbosity()
	 * @see #getConsoleLogFormat()
	 * @generated
	 */
	EAttribute getConsoleLogFormat_Verbosity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.TraceElement <em>Trace Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Element</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.TraceElement
	 * @generated
	 */
	EClass getTraceElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.TraceElement#getNature <em>Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nature</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.TraceElement#getNature()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_Nature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.TraceElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.TraceElement#getValue()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.TraceSpecification <em>Trace Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Specification</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.TraceSpecification
	 * @generated
	 */
	EClass getTraceSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.execution.core.workflow.common.TraceSpecification#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.TraceSpecification#getElement()
	 * @see #getTraceSpecification()
	 * @generated
	 */
	EReference getTraceSpecification_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.Manifest <em>Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manifest</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Manifest
	 * @generated
	 */
	EClass getManifest();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.Manifest#isAutoconf <em>Autoconf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autoconf</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Manifest#isAutoconf()
	 * @see #getManifest()
	 * @generated
	 */
	EAttribute getManifest_Autoconf();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.Manifest#isAutostart <em>Autostart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autostart</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.Manifest#isAutostart()
	 * @see #getManifest()
	 * @generated
	 */
	EAttribute getManifest_Autostart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.SymbexOption <em>Symbex Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbex Option</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.SymbexOption
	 * @generated
	 */
	EClass getSymbexOption();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.ShellMode <em>Shell Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shell Mode</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ShellMode
	 * @generated
	 */
	EClass getShellMode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.ShellMode#getStop <em>Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ShellMode#getStop()
	 * @see #getShellMode()
	 * @generated
	 */
	EAttribute getShellMode_Stop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic <em>Coverage Heuristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coverage Heuristic</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic
	 * @generated
	 */
	EClass getCoverageHeuristic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHeuristicTrials <em>Heuristic Trials</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heuristic Trials</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHeuristicTrials()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_HeuristicTrials();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getObjectiveRateGoal <em>Objective Rate Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Objective Rate Goal</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getObjectiveRateGoal()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_ObjectiveRateGoal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getObjectiveRestGoal <em>Objective Rest Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Objective Rest Goal</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getObjectiveRestGoal()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_ObjectiveRestGoal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHeuristicStart <em>Heuristic Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heuristic Start</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHeuristicStart()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_HeuristicStart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceCount <em>Directive Trace Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directive Trace Count</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceCount()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_DirectiveTraceCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceSize <em>Directive Trace Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directive Trace Size</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceSize()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_DirectiveTraceSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceHeuristic <em>Directive Trace Heuristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directive Trace Heuristic</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceHeuristic()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_DirectiveTraceHeuristic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getLookaheadDepth <em>Lookahead Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lookahead Depth</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getLookaheadDepth()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_LookaheadDepth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getLookaheadWidth <em>Lookahead Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lookahead Width</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getLookaheadWidth()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_LookaheadWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitStronglyRandomEnabled <em>Hit Strongly Random Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Strongly Random Enabled</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitStronglyRandomEnabled()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_HitStronglyRandomEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitStronglyCount <em>Hit Strongly Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Strongly Count</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitStronglyCount()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_HitStronglyCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitWeaklyRandomEnabled <em>Hit Weakly Random Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Weakly Random Enabled</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitWeaklyRandomEnabled()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_HitWeaklyRandomEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitWeaklyCount <em>Hit Weakly Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Weakly Count</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitWeaklyCount()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_HitWeaklyCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitOtherRandomEnabled <em>Hit Other Random Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Other Random Enabled</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitOtherRandomEnabled()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_HitOtherRandomEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitOtherCount <em>Hit Other Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit Other Count</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitOtherCount()
	 * @see #getCoverageHeuristic()
	 * @generated
	 */
	EAttribute getCoverageHeuristic_HitOtherCount();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption <em>Developer Tuning Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Developer Tuning Option</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption
	 * @generated
	 */
	EClass getDeveloperTuningOption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getLogTraceFilename <em>Log Trace Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Trace Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getLogTraceFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_LogTraceFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getDebugTraceFilename <em>Debug Trace Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Trace Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getDebugTraceFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_DebugTraceFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getDebugLevel <em>Debug Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Level</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getDebugLevel()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_DebugLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getDebugFilename <em>Debug Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getDebugFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_DebugFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getOutputFilename <em>Output Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getOutputFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_OutputFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getSpecificationFilename <em>Specification Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getSpecificationFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_SpecificationFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getExecutableFilename <em>Executable Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getExecutableFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_ExecutableFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getInitializationFilename <em>Initialization Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialization Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getInitializationFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_InitializationFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getSymbexGraphFilename <em>Symbex Graph Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbex Graph Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getSymbexGraphFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_SymbexGraphFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getParsedModelFilename <em>Parsed Model Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parsed Model Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getParsedModelFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_ParsedModelFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getCompiledModelFilename <em>Compiled Model Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compiled Model Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getCompiledModelFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_CompiledModelFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getSymbexTraceFilename <em>Symbex Trace Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbex Trace Filename</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#getSymbexTraceFilename()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_SymbexTraceFilename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledParsing <em>Enabled Parsing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Parsing</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledParsing()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledParsing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledConfiguring <em>Enabled Configuring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Configuring</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledConfiguring()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledConfiguring();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledCompiling <em>Enabled Compiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Compiling</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledCompiling()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledCompiling();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledLoading <em>Enabled Loading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Loading</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledLoading()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledLoading();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledComputing <em>Enabled Computing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Computing</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledComputing()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledComputing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledReporting <em>Enabled Reporting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Reporting</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledReporting()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledReporting();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledSolving <em>Enabled Solving</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Solving</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledSolving()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledSolving();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledProfiling <em>Enabled Profiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Profiling</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledProfiling()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledProfiling();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledAllProcessStage <em>Enabled All Process Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled All Process Stage</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledAllProcessStage()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledAllProcessStage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPreProcessing <em>Enabled Pre Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Pre Processing</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPreProcessing()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledPreProcessing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPostProcessing <em>Enabled Post Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Post Processing</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPostProcessing()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledPostProcessing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledProcessing <em>Enabled Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Processing</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledProcessing()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledProcessing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPreFiltering <em>Enabled Pre Filtering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Pre Filtering</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPreFiltering()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledPreFiltering();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPostFiltering <em>Enabled Post Filtering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Post Filtering</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPostFiltering()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledPostFiltering();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledFiltering <em>Enabled Filtering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Filtering</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledFiltering()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledFiltering();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledQueue <em>Enabled Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Queue</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledQueue()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledQueue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledProgram <em>Enabled Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Program</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledProgram()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledProgram();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatement <em>Enabled Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Statement</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatement()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatementAssignment <em>Enabled Statement Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Statement Assignment</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatementAssignment()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledStatementAssignment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatementCommunication <em>Enabled Statement Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Statement Communication</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatementCommunication()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledStatementCommunication();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatementTestDecision <em>Enabled Statement Test Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Statement Test Decision</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatementTestDecision()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledStatementTestDecision();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledBytecode <em>Enabled Bytecode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Bytecode</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledBytecode()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledBytecode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledData <em>Enabled Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Data</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledData()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledTrace <em>Enabled Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Trace</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledTrace()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledVariable <em>Enabled Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Variable</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledVariable()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledBuffer <em>Enabled Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Buffer</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledBuffer()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPort <em>Enabled Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Port</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledPort()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledSignal <em>Enabled Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Signal</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledSignal()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledSignal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledConnexion <em>Enabled Connexion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Connexion</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledConnexion()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledConnexion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledTime <em>Enabled Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Time</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledTime()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledExecutable <em>Enabled Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Executable</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledExecutable()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledExecutable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledActivity <em>Enabled Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Activity</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledActivity()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledActivity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledRoutine <em>Enabled Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Routine</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledRoutine()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledRoutine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledTransition <em>Enabled Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Transition</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledTransition()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledMachine <em>Enabled Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Machine</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledMachine()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledMachine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatemachine <em>Enabled Statemachine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Statemachine</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledStatemachine()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledStatemachine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledNameId <em>Enabled Name Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Name Id</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledNameId()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledNameId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledQualifiedNameId <em>Enabled Qualified Name Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Qualified Name Id</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledQualifiedNameId()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledQualifiedNameId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledFullyQualifiedNameId <em>Enabled Fully Qualified Name Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Fully Qualified Name Id</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledFullyQualifiedNameId()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledFullyQualifiedNameId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledRedundance <em>Enabled Redundance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Redundance</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledRedundance()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledRedundance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledReferenceCounting <em>Enabled Reference Counting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Reference Counting</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledReferenceCounting()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledReferenceCounting();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledNothing <em>Enabled Nothing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Nothing</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledNothing()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledNothing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledGodMode <em>Enabled God Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled God Mode</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption#isEnabledGodMode()
	 * @see #getDeveloperTuningOption()
	 * @generated
	 */
	EAttribute getDeveloperTuningOption_EnabledGodMode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection <em>Redundancy Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redundancy Detection</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyDetection
	 * @generated
	 */
	EClass getRedundancyDetection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getComparer <em>Comparer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comparer</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getComparer()
	 * @see #getRedundancyDetection()
	 * @generated
	 */
	EAttribute getRedundancyDetection_Comparer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getSolver <em>Solver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solver</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getSolver()
	 * @see #getRedundancyDetection()
	 * @generated
	 */
	EAttribute getRedundancyDetection_Solver();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getPathScope <em>Path Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Scope</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getPathScope()
	 * @see #getRedundancyDetection()
	 * @generated
	 */
	EAttribute getRedundancyDetection_PathScope();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getDataScope <em>Data Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Scope</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#getDataScope()
	 * @see #getRedundancyDetection()
	 * @generated
	 */
	EAttribute getRedundancyDetection_DataScope();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#isLoopDetetctionTrivial <em>Loop Detetction Trivial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loop Detetction Trivial</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.RedundancyDetection#isLoopDetetctionTrivial()
	 * @see #getRedundancyDetection()
	 * @generated
	 */
	EAttribute getRedundancyDetection_LoopDetetctionTrivial();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind <em>Graph Exploration Strategy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Graph Exploration Strategy Kind</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind
	 * @generated
	 */
	EEnum getGraphExplorationStrategyKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind <em>Console Verbosity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Console Verbosity Kind</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind
	 * @generated
	 */
	EEnum getConsoleVerbosityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.execution.core.workflow.common.TraceElementKind <em>Trace Element Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trace Element Kind</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.TraceElementKind
	 * @generated
	 */
	EEnum getTraceElementKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind <em>Heuristic Class Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Heuristic Class Kind</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind
	 * @generated
	 */
	EEnum getHeuristicClassKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind <em>Coverage Scope Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Coverage Scope Kind</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind
	 * @generated
	 */
	EEnum getCoverageScopeKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.execution.core.workflow.common.CheckingScopeKind <em>Checking Scope Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Checking Scope Kind</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.CheckingScopeKind
	 * @generated
	 */
	EEnum getCheckingScopeKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.execution.core.workflow.common.DebuglevelKind <em>Debuglevel Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Debuglevel Kind</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.common.DebuglevelKind
	 * @generated
	 */
	EEnum getDebuglevelKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.WorkspaceImpl <em>Workspace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.WorkspaceImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getWorkspace()
		 * @generated
		 */
		EClass WORKSPACE = eINSTANCE.getWorkspace();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE__LOCATION = eINSTANCE.getWorkspace_Location();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE__PROJECT = eINSTANCE.getWorkspace_Project();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.LocationImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__ROOT = eINSTANCE.getLocation_Root();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__OUTPUT = eINSTANCE.getLocation_Output();

		/**
		 * The meta object literal for the '<em><b>Log</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__LOG = eINSTANCE.getLocation_Log();

		/**
		 * The meta object literal for the '<em><b>Debug</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__DEBUG = eINSTANCE.getLocation_Debug();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.ProjectImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__SOURCE = eINSTANCE.getProject_Source();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__MODEL = eINSTANCE.getProject_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl <em>Graph Exploration Limit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getGraphExplorationLimit()
		 * @generated
		 */
		EClass GRAPH_EXPLORATION_LIMIT = eINSTANCE.getGraphExplorationLimit();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_LIMIT__STEP = eINSTANCE.getGraphExplorationLimit_Step();

		/**
		 * The meta object literal for the '<em><b>Eval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_LIMIT__EVAL = eINSTANCE.getGraphExplorationLimit_Eval();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_LIMIT__NODE = eINSTANCE.getGraphExplorationLimit_Node();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_LIMIT__HEIGHT = eINSTANCE.getGraphExplorationLimit_Height();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_LIMIT__WIDTH = eINSTANCE.getGraphExplorationLimit_Width();

		/**
		 * The meta object literal for the '<em><b>Report</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_LIMIT__REPORT = eINSTANCE.getGraphExplorationLimit_Report();

		/**
		 * The meta object literal for the '<em><b>Save</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_LIMIT__SAVE = eINSTANCE.getGraphExplorationLimit_Save();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationQueueImpl <em>Graph Exploration Queue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationQueueImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getGraphExplorationQueue()
		 * @generated
		 */
		EClass GRAPH_EXPLORATION_QUEUE = eINSTANCE.getGraphExplorationQueue();

		/**
		 * The meta object literal for the '<em><b>Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_QUEUE__STRATEGY = eINSTANCE.getGraphExplorationQueue_Strategy();

		/**
		 * The meta object literal for the '<em><b>Heuristic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_QUEUE__HEURISTIC = eINSTANCE.getGraphExplorationQueue_Heuristic();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_EXPLORATION_QUEUE__WEIGHT = eINSTANCE.getGraphExplorationQueue_Weight();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl <em>Console Log Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getConsoleLogFormat()
		 * @generated
		 */
		EClass CONSOLE_LOG_FORMAT = eINSTANCE.getConsoleLogFormat();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_LOG_FORMAT__FORMAT = eINSTANCE.getConsoleLogFormat_Format();

		/**
		 * The meta object literal for the '<em><b>Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_LOG_FORMAT__BOUND = eINSTANCE.getConsoleLogFormat_Bound();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_LOG_FORMAT__STEP = eINSTANCE.getConsoleLogFormat_Step();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_LOG_FORMAT__RESULT = eINSTANCE.getConsoleLogFormat_Result();

		/**
		 * The meta object literal for the '<em><b>Report</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_LOG_FORMAT__REPORT = eINSTANCE.getConsoleLogFormat_Report();

		/**
		 * The meta object literal for the '<em><b>Verbosity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_LOG_FORMAT__VERBOSITY = eINSTANCE.getConsoleLogFormat_Verbosity();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.TraceElementImpl <em>Trace Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.TraceElementImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getTraceElement()
		 * @generated
		 */
		EClass TRACE_ELEMENT = eINSTANCE.getTraceElement();

		/**
		 * The meta object literal for the '<em><b>Nature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__NATURE = eINSTANCE.getTraceElement_Nature();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__VALUE = eINSTANCE.getTraceElement_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.TraceSpecificationImpl <em>Trace Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.TraceSpecificationImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getTraceSpecification()
		 * @generated
		 */
		EClass TRACE_SPECIFICATION = eINSTANCE.getTraceSpecification();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SPECIFICATION__ELEMENT = eINSTANCE.getTraceSpecification_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.ManifestImpl <em>Manifest</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.ManifestImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getManifest()
		 * @generated
		 */
		EClass MANIFEST = eINSTANCE.getManifest();

		/**
		 * The meta object literal for the '<em><b>Autoconf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANIFEST__AUTOCONF = eINSTANCE.getManifest_Autoconf();

		/**
		 * The meta object literal for the '<em><b>Autostart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANIFEST__AUTOSTART = eINSTANCE.getManifest_Autostart();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.SymbexOptionImpl <em>Symbex Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.SymbexOptionImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getSymbexOption()
		 * @generated
		 */
		EClass SYMBEX_OPTION = eINSTANCE.getSymbexOption();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.ShellModeImpl <em>Shell Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.ShellModeImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getShellMode()
		 * @generated
		 */
		EClass SHELL_MODE = eINSTANCE.getShellMode();

		/**
		 * The meta object literal for the '<em><b>Stop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHELL_MODE__STOP = eINSTANCE.getShellMode_Stop();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl <em>Coverage Heuristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getCoverageHeuristic()
		 * @generated
		 */
		EClass COVERAGE_HEURISTIC = eINSTANCE.getCoverageHeuristic();

		/**
		 * The meta object literal for the '<em><b>Heuristic Trials</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__HEURISTIC_TRIALS = eINSTANCE.getCoverageHeuristic_HeuristicTrials();

		/**
		 * The meta object literal for the '<em><b>Objective Rate Goal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__OBJECTIVE_RATE_GOAL = eINSTANCE.getCoverageHeuristic_ObjectiveRateGoal();

		/**
		 * The meta object literal for the '<em><b>Objective Rest Goal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__OBJECTIVE_REST_GOAL = eINSTANCE.getCoverageHeuristic_ObjectiveRestGoal();

		/**
		 * The meta object literal for the '<em><b>Heuristic Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__HEURISTIC_START = eINSTANCE.getCoverageHeuristic_HeuristicStart();

		/**
		 * The meta object literal for the '<em><b>Directive Trace Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__DIRECTIVE_TRACE_COUNT = eINSTANCE.getCoverageHeuristic_DirectiveTraceCount();

		/**
		 * The meta object literal for the '<em><b>Directive Trace Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__DIRECTIVE_TRACE_SIZE = eINSTANCE.getCoverageHeuristic_DirectiveTraceSize();

		/**
		 * The meta object literal for the '<em><b>Directive Trace Heuristic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__DIRECTIVE_TRACE_HEURISTIC = eINSTANCE.getCoverageHeuristic_DirectiveTraceHeuristic();

		/**
		 * The meta object literal for the '<em><b>Lookahead Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__LOOKAHEAD_DEPTH = eINSTANCE.getCoverageHeuristic_LookaheadDepth();

		/**
		 * The meta object literal for the '<em><b>Lookahead Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__LOOKAHEAD_WIDTH = eINSTANCE.getCoverageHeuristic_LookaheadWidth();

		/**
		 * The meta object literal for the '<em><b>Hit Strongly Random Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__HIT_STRONGLY_RANDOM_ENABLED = eINSTANCE.getCoverageHeuristic_HitStronglyRandomEnabled();

		/**
		 * The meta object literal for the '<em><b>Hit Strongly Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__HIT_STRONGLY_COUNT = eINSTANCE.getCoverageHeuristic_HitStronglyCount();

		/**
		 * The meta object literal for the '<em><b>Hit Weakly Random Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__HIT_WEAKLY_RANDOM_ENABLED = eINSTANCE.getCoverageHeuristic_HitWeaklyRandomEnabled();

		/**
		 * The meta object literal for the '<em><b>Hit Weakly Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__HIT_WEAKLY_COUNT = eINSTANCE.getCoverageHeuristic_HitWeaklyCount();

		/**
		 * The meta object literal for the '<em><b>Hit Other Random Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__HIT_OTHER_RANDOM_ENABLED = eINSTANCE.getCoverageHeuristic_HitOtherRandomEnabled();

		/**
		 * The meta object literal for the '<em><b>Hit Other Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_HEURISTIC__HIT_OTHER_COUNT = eINSTANCE.getCoverageHeuristic_HitOtherCount();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl <em>Developer Tuning Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getDeveloperTuningOption()
		 * @generated
		 */
		EClass DEVELOPER_TUNING_OPTION = eINSTANCE.getDeveloperTuningOption();

		/**
		 * The meta object literal for the '<em><b>Log Trace Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__LOG_TRACE_FILENAME = eINSTANCE.getDeveloperTuningOption_LogTraceFilename();

		/**
		 * The meta object literal for the '<em><b>Debug Trace Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__DEBUG_TRACE_FILENAME = eINSTANCE.getDeveloperTuningOption_DebugTraceFilename();

		/**
		 * The meta object literal for the '<em><b>Debug Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__DEBUG_LEVEL = eINSTANCE.getDeveloperTuningOption_DebugLevel();

		/**
		 * The meta object literal for the '<em><b>Debug Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__DEBUG_FILENAME = eINSTANCE.getDeveloperTuningOption_DebugFilename();

		/**
		 * The meta object literal for the '<em><b>Output Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__OUTPUT_FILENAME = eINSTANCE.getDeveloperTuningOption_OutputFilename();

		/**
		 * The meta object literal for the '<em><b>Specification Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__SPECIFICATION_FILENAME = eINSTANCE.getDeveloperTuningOption_SpecificationFilename();

		/**
		 * The meta object literal for the '<em><b>Executable Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__EXECUTABLE_FILENAME = eINSTANCE.getDeveloperTuningOption_ExecutableFilename();

		/**
		 * The meta object literal for the '<em><b>Initialization Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__INITIALIZATION_FILENAME = eINSTANCE.getDeveloperTuningOption_InitializationFilename();

		/**
		 * The meta object literal for the '<em><b>Symbex Graph Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__SYMBEX_GRAPH_FILENAME = eINSTANCE.getDeveloperTuningOption_SymbexGraphFilename();

		/**
		 * The meta object literal for the '<em><b>Parsed Model Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__PARSED_MODEL_FILENAME = eINSTANCE.getDeveloperTuningOption_ParsedModelFilename();

		/**
		 * The meta object literal for the '<em><b>Compiled Model Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__COMPILED_MODEL_FILENAME = eINSTANCE.getDeveloperTuningOption_CompiledModelFilename();

		/**
		 * The meta object literal for the '<em><b>Symbex Trace Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__SYMBEX_TRACE_FILENAME = eINSTANCE.getDeveloperTuningOption_SymbexTraceFilename();

		/**
		 * The meta object literal for the '<em><b>Enabled Parsing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_PARSING = eINSTANCE.getDeveloperTuningOption_EnabledParsing();

		/**
		 * The meta object literal for the '<em><b>Enabled Configuring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_CONFIGURING = eINSTANCE.getDeveloperTuningOption_EnabledConfiguring();

		/**
		 * The meta object literal for the '<em><b>Enabled Compiling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_COMPILING = eINSTANCE.getDeveloperTuningOption_EnabledCompiling();

		/**
		 * The meta object literal for the '<em><b>Enabled Loading</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_LOADING = eINSTANCE.getDeveloperTuningOption_EnabledLoading();

		/**
		 * The meta object literal for the '<em><b>Enabled Computing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_COMPUTING = eINSTANCE.getDeveloperTuningOption_EnabledComputing();

		/**
		 * The meta object literal for the '<em><b>Enabled Reporting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_REPORTING = eINSTANCE.getDeveloperTuningOption_EnabledReporting();

		/**
		 * The meta object literal for the '<em><b>Enabled Solving</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_SOLVING = eINSTANCE.getDeveloperTuningOption_EnabledSolving();

		/**
		 * The meta object literal for the '<em><b>Enabled Profiling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_PROFILING = eINSTANCE.getDeveloperTuningOption_EnabledProfiling();

		/**
		 * The meta object literal for the '<em><b>Enabled All Process Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_ALL_PROCESS_STAGE = eINSTANCE.getDeveloperTuningOption_EnabledAllProcessStage();

		/**
		 * The meta object literal for the '<em><b>Enabled Pre Processing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_PRE_PROCESSING = eINSTANCE.getDeveloperTuningOption_EnabledPreProcessing();

		/**
		 * The meta object literal for the '<em><b>Enabled Post Processing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_POST_PROCESSING = eINSTANCE.getDeveloperTuningOption_EnabledPostProcessing();

		/**
		 * The meta object literal for the '<em><b>Enabled Processing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_PROCESSING = eINSTANCE.getDeveloperTuningOption_EnabledProcessing();

		/**
		 * The meta object literal for the '<em><b>Enabled Pre Filtering</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_PRE_FILTERING = eINSTANCE.getDeveloperTuningOption_EnabledPreFiltering();

		/**
		 * The meta object literal for the '<em><b>Enabled Post Filtering</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_POST_FILTERING = eINSTANCE.getDeveloperTuningOption_EnabledPostFiltering();

		/**
		 * The meta object literal for the '<em><b>Enabled Filtering</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_FILTERING = eINSTANCE.getDeveloperTuningOption_EnabledFiltering();

		/**
		 * The meta object literal for the '<em><b>Enabled Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_QUEUE = eINSTANCE.getDeveloperTuningOption_EnabledQueue();

		/**
		 * The meta object literal for the '<em><b>Enabled Program</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_PROGRAM = eINSTANCE.getDeveloperTuningOption_EnabledProgram();

		/**
		 * The meta object literal for the '<em><b>Enabled Statement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT = eINSTANCE.getDeveloperTuningOption_EnabledStatement();

		/**
		 * The meta object literal for the '<em><b>Enabled Statement Assignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_ASSIGNMENT = eINSTANCE.getDeveloperTuningOption_EnabledStatementAssignment();

		/**
		 * The meta object literal for the '<em><b>Enabled Statement Communication</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_COMMUNICATION = eINSTANCE.getDeveloperTuningOption_EnabledStatementCommunication();

		/**
		 * The meta object literal for the '<em><b>Enabled Statement Test Decision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_TEST_DECISION = eINSTANCE.getDeveloperTuningOption_EnabledStatementTestDecision();

		/**
		 * The meta object literal for the '<em><b>Enabled Bytecode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_BYTECODE = eINSTANCE.getDeveloperTuningOption_EnabledBytecode();

		/**
		 * The meta object literal for the '<em><b>Enabled Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_DATA = eINSTANCE.getDeveloperTuningOption_EnabledData();

		/**
		 * The meta object literal for the '<em><b>Enabled Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_TRACE = eINSTANCE.getDeveloperTuningOption_EnabledTrace();

		/**
		 * The meta object literal for the '<em><b>Enabled Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_VARIABLE = eINSTANCE.getDeveloperTuningOption_EnabledVariable();

		/**
		 * The meta object literal for the '<em><b>Enabled Buffer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_BUFFER = eINSTANCE.getDeveloperTuningOption_EnabledBuffer();

		/**
		 * The meta object literal for the '<em><b>Enabled Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_PORT = eINSTANCE.getDeveloperTuningOption_EnabledPort();

		/**
		 * The meta object literal for the '<em><b>Enabled Signal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_SIGNAL = eINSTANCE.getDeveloperTuningOption_EnabledSignal();

		/**
		 * The meta object literal for the '<em><b>Enabled Connexion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_CONNEXION = eINSTANCE.getDeveloperTuningOption_EnabledConnexion();

		/**
		 * The meta object literal for the '<em><b>Enabled Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_TIME = eINSTANCE.getDeveloperTuningOption_EnabledTime();

		/**
		 * The meta object literal for the '<em><b>Enabled Executable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_EXECUTABLE = eINSTANCE.getDeveloperTuningOption_EnabledExecutable();

		/**
		 * The meta object literal for the '<em><b>Enabled Activity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_ACTIVITY = eINSTANCE.getDeveloperTuningOption_EnabledActivity();

		/**
		 * The meta object literal for the '<em><b>Enabled Routine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_ROUTINE = eINSTANCE.getDeveloperTuningOption_EnabledRoutine();

		/**
		 * The meta object literal for the '<em><b>Enabled Transition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_TRANSITION = eINSTANCE.getDeveloperTuningOption_EnabledTransition();

		/**
		 * The meta object literal for the '<em><b>Enabled Machine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_MACHINE = eINSTANCE.getDeveloperTuningOption_EnabledMachine();

		/**
		 * The meta object literal for the '<em><b>Enabled Statemachine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_STATEMACHINE = eINSTANCE.getDeveloperTuningOption_EnabledStatemachine();

		/**
		 * The meta object literal for the '<em><b>Enabled Name Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_NAME_ID = eINSTANCE.getDeveloperTuningOption_EnabledNameId();

		/**
		 * The meta object literal for the '<em><b>Enabled Qualified Name Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_QUALIFIED_NAME_ID = eINSTANCE.getDeveloperTuningOption_EnabledQualifiedNameId();

		/**
		 * The meta object literal for the '<em><b>Enabled Fully Qualified Name Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_FULLY_QUALIFIED_NAME_ID = eINSTANCE.getDeveloperTuningOption_EnabledFullyQualifiedNameId();

		/**
		 * The meta object literal for the '<em><b>Enabled Redundance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_REDUNDANCE = eINSTANCE.getDeveloperTuningOption_EnabledRedundance();

		/**
		 * The meta object literal for the '<em><b>Enabled Reference Counting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_REFERENCE_COUNTING = eINSTANCE.getDeveloperTuningOption_EnabledReferenceCounting();

		/**
		 * The meta object literal for the '<em><b>Enabled Nothing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_NOTHING = eINSTANCE.getDeveloperTuningOption_EnabledNothing();

		/**
		 * The meta object literal for the '<em><b>Enabled God Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVELOPER_TUNING_OPTION__ENABLED_GOD_MODE = eINSTANCE.getDeveloperTuningOption_EnabledGodMode();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl <em>Redundancy Detection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getRedundancyDetection()
		 * @generated
		 */
		EClass REDUNDANCY_DETECTION = eINSTANCE.getRedundancyDetection();

		/**
		 * The meta object literal for the '<em><b>Comparer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDUNDANCY_DETECTION__COMPARER = eINSTANCE.getRedundancyDetection_Comparer();

		/**
		 * The meta object literal for the '<em><b>Solver</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDUNDANCY_DETECTION__SOLVER = eINSTANCE.getRedundancyDetection_Solver();

		/**
		 * The meta object literal for the '<em><b>Path Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDUNDANCY_DETECTION__PATH_SCOPE = eINSTANCE.getRedundancyDetection_PathScope();

		/**
		 * The meta object literal for the '<em><b>Data Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDUNDANCY_DETECTION__DATA_SCOPE = eINSTANCE.getRedundancyDetection_DataScope();

		/**
		 * The meta object literal for the '<em><b>Loop Detetction Trivial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDUNDANCY_DETECTION__LOOP_DETETCTION_TRIVIAL = eINSTANCE.getRedundancyDetection_LoopDetetctionTrivial();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind <em>Graph Exploration Strategy Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getGraphExplorationStrategyKind()
		 * @generated
		 */
		EEnum GRAPH_EXPLORATION_STRATEGY_KIND = eINSTANCE.getGraphExplorationStrategyKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind <em>Console Verbosity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getConsoleVerbosityKind()
		 * @generated
		 */
		EEnum CONSOLE_VERBOSITY_KIND = eINSTANCE.getConsoleVerbosityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.TraceElementKind <em>Trace Element Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.TraceElementKind
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getTraceElementKind()
		 * @generated
		 */
		EEnum TRACE_ELEMENT_KIND = eINSTANCE.getTraceElementKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind <em>Heuristic Class Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getHeuristicClassKind()
		 * @generated
		 */
		EEnum HEURISTIC_CLASS_KIND = eINSTANCE.getHeuristicClassKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind <em>Coverage Scope Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getCoverageScopeKind()
		 * @generated
		 */
		EEnum COVERAGE_SCOPE_KIND = eINSTANCE.getCoverageScopeKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.CheckingScopeKind <em>Checking Scope Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.CheckingScopeKind
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getCheckingScopeKind()
		 * @generated
		 */
		EEnum CHECKING_SCOPE_KIND = eINSTANCE.getCheckingScopeKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.common.DebuglevelKind <em>Debuglevel Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.common.DebuglevelKind
		 * @see org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl#getDebuglevelKind()
		 * @generated
		 */
		EEnum DEBUGLEVEL_KIND = eINSTANCE.getDebuglevelKind();

	}

} //CommonPackage
