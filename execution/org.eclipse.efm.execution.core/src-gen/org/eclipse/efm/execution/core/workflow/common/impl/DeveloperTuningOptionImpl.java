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
package org.eclipse.efm.execution.core.workflow.common.impl;

import org.eclipse.efm.execution.core.workflow.common.CommonPackage;
import org.eclipse.efm.execution.core.workflow.common.DebuglevelKind;
import org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Developer Tuning Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getLogTraceFilename <em>Log Trace Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getDebugTraceFilename <em>Debug Trace Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getDebugLevel <em>Debug Level</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getDebugFilename <em>Debug Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getOutputFilename <em>Output Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getSpecificationFilename <em>Specification Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getExecutableFilename <em>Executable Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getSymbexGraphFilename <em>Symbex Graph Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getParsedModelFilename <em>Parsed Model Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getCompiledModelFilename <em>Compiled Model Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#getSymbexTraceFilename <em>Symbex Trace Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledParsing <em>Enabled Parsing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledConfiguring <em>Enabled Configuring</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledCompiling <em>Enabled Compiling</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledLoading <em>Enabled Loading</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledComputing <em>Enabled Computing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledReporting <em>Enabled Reporting</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledSolving <em>Enabled Solving</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledProfiling <em>Enabled Profiling</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledAllProcessStage <em>Enabled All Process Stage</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledPreProcessing <em>Enabled Pre Processing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledPostProcessing <em>Enabled Post Processing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledProcessing <em>Enabled Processing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledPreFiltering <em>Enabled Pre Filtering</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledPostFiltering <em>Enabled Post Filtering</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledFiltering <em>Enabled Filtering</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledQueue <em>Enabled Queue</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledProgram <em>Enabled Program</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledStatement <em>Enabled Statement</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledStatementAssignment <em>Enabled Statement Assignment</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledStatementCommunication <em>Enabled Statement Communication</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledStatementTestDecision <em>Enabled Statement Test Decision</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledBytecode <em>Enabled Bytecode</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledData <em>Enabled Data</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledTrace <em>Enabled Trace</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledVariable <em>Enabled Variable</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledBuffer <em>Enabled Buffer</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledPort <em>Enabled Port</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledSignal <em>Enabled Signal</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledConnexion <em>Enabled Connexion</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledTime <em>Enabled Time</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledExecutable <em>Enabled Executable</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledActivity <em>Enabled Activity</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledRoutine <em>Enabled Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledTransition <em>Enabled Transition</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledMachine <em>Enabled Machine</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledStatemachine <em>Enabled Statemachine</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledNameId <em>Enabled Name Id</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledQualifiedNameId <em>Enabled Qualified Name Id</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledFullyQualifiedNameId <em>Enabled Fully Qualified Name Id</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledRedundance <em>Enabled Redundance</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledReferenceCounting <em>Enabled Reference Counting</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledNothing <em>Enabled Nothing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.DeveloperTuningOptionImpl#isEnabledGodMode <em>Enabled God Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeveloperTuningOptionImpl extends MinimalEObjectImpl.Container implements DeveloperTuningOption {
	/**
	 * The default value of the '{@link #getLogTraceFilename() <em>Log Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogTraceFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_TRACE_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogTraceFilename() <em>Log Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogTraceFilename()
	 * @generated
	 * @ordered
	 */
	protected String logTraceFilename = LOG_TRACE_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDebugTraceFilename() <em>Debug Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugTraceFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String DEBUG_TRACE_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDebugTraceFilename() <em>Debug Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugTraceFilename()
	 * @generated
	 * @ordered
	 */
	protected String debugTraceFilename = DEBUG_TRACE_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDebugLevel() <em>Debug Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugLevel()
	 * @generated
	 * @ordered
	 */
	protected static final DebuglevelKind DEBUG_LEVEL_EDEFAULT = DebuglevelKind.ZERO;

	/**
	 * The cached value of the '{@link #getDebugLevel() <em>Debug Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugLevel()
	 * @generated
	 * @ordered
	 */
	protected DebuglevelKind debugLevel = DEBUG_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getDebugFilename() <em>Debug Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String DEBUG_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDebugFilename() <em>Debug Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugFilename()
	 * @generated
	 * @ordered
	 */
	protected String debugFilename = DEBUG_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputFilename() <em>Output Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputFilename() <em>Output Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputFilename()
	 * @generated
	 * @ordered
	 */
	protected String outputFilename = OUTPUT_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpecificationFilename() <em>Specification Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificationFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATION_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecificationFilename() <em>Specification Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificationFilename()
	 * @generated
	 * @ordered
	 */
	protected String specificationFilename = SPECIFICATION_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecutableFilename() <em>Executable Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutableFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String EXECUTABLE_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecutableFilename() <em>Executable Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutableFilename()
	 * @generated
	 * @ordered
	 */
	protected String executableFilename = EXECUTABLE_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSymbexGraphFilename() <em>Symbex Graph Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbexGraphFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBEX_GRAPH_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymbexGraphFilename() <em>Symbex Graph Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbexGraphFilename()
	 * @generated
	 * @ordered
	 */
	protected String symbexGraphFilename = SYMBEX_GRAPH_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getParsedModelFilename() <em>Parsed Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsedModelFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String PARSED_MODEL_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParsedModelFilename() <em>Parsed Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsedModelFilename()
	 * @generated
	 * @ordered
	 */
	protected String parsedModelFilename = PARSED_MODEL_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompiledModelFilename() <em>Compiled Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompiledModelFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPILED_MODEL_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompiledModelFilename() <em>Compiled Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompiledModelFilename()
	 * @generated
	 * @ordered
	 */
	protected String compiledModelFilename = COMPILED_MODEL_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSymbexTraceFilename() <em>Symbex Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbexTraceFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBEX_TRACE_FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymbexTraceFilename() <em>Symbex Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbexTraceFilename()
	 * @generated
	 * @ordered
	 */
	protected String symbexTraceFilename = SYMBEX_TRACE_FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledParsing() <em>Enabled Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledParsing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_PARSING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledParsing() <em>Enabled Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledParsing()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledParsing = ENABLED_PARSING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledConfiguring() <em>Enabled Configuring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledConfiguring()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_CONFIGURING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledConfiguring() <em>Enabled Configuring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledConfiguring()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledConfiguring = ENABLED_CONFIGURING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledCompiling() <em>Enabled Compiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledCompiling()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_COMPILING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledCompiling() <em>Enabled Compiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledCompiling()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledCompiling = ENABLED_COMPILING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledLoading() <em>Enabled Loading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledLoading()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_LOADING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledLoading() <em>Enabled Loading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledLoading()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledLoading = ENABLED_LOADING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledComputing() <em>Enabled Computing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledComputing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_COMPUTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledComputing() <em>Enabled Computing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledComputing()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledComputing = ENABLED_COMPUTING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledReporting() <em>Enabled Reporting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledReporting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_REPORTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledReporting() <em>Enabled Reporting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledReporting()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledReporting = ENABLED_REPORTING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledSolving() <em>Enabled Solving</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledSolving()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_SOLVING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledSolving() <em>Enabled Solving</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledSolving()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledSolving = ENABLED_SOLVING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledProfiling() <em>Enabled Profiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledProfiling()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_PROFILING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledProfiling() <em>Enabled Profiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledProfiling()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledProfiling = ENABLED_PROFILING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledAllProcessStage() <em>Enabled All Process Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledAllProcessStage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_ALL_PROCESS_STAGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledAllProcessStage() <em>Enabled All Process Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledAllProcessStage()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledAllProcessStage = ENABLED_ALL_PROCESS_STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledPreProcessing() <em>Enabled Pre Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPreProcessing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_PRE_PROCESSING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledPreProcessing() <em>Enabled Pre Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPreProcessing()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledPreProcessing = ENABLED_PRE_PROCESSING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledPostProcessing() <em>Enabled Post Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPostProcessing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_POST_PROCESSING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledPostProcessing() <em>Enabled Post Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPostProcessing()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledPostProcessing = ENABLED_POST_PROCESSING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledProcessing() <em>Enabled Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledProcessing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_PROCESSING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledProcessing() <em>Enabled Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledProcessing()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledProcessing = ENABLED_PROCESSING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledPreFiltering() <em>Enabled Pre Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPreFiltering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_PRE_FILTERING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledPreFiltering() <em>Enabled Pre Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPreFiltering()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledPreFiltering = ENABLED_PRE_FILTERING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledPostFiltering() <em>Enabled Post Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPostFiltering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_POST_FILTERING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledPostFiltering() <em>Enabled Post Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPostFiltering()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledPostFiltering = ENABLED_POST_FILTERING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledFiltering() <em>Enabled Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledFiltering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_FILTERING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledFiltering() <em>Enabled Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledFiltering()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledFiltering = ENABLED_FILTERING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledQueue() <em>Enabled Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledQueue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_QUEUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledQueue() <em>Enabled Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledQueue()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledQueue = ENABLED_QUEUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledProgram() <em>Enabled Program</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledProgram()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_PROGRAM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledProgram() <em>Enabled Program</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledProgram()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledProgram = ENABLED_PROGRAM_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledStatement() <em>Enabled Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_STATEMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledStatement() <em>Enabled Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatement()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledStatement = ENABLED_STATEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledStatementAssignment() <em>Enabled Statement Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatementAssignment()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_STATEMENT_ASSIGNMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledStatementAssignment() <em>Enabled Statement Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatementAssignment()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledStatementAssignment = ENABLED_STATEMENT_ASSIGNMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledStatementCommunication() <em>Enabled Statement Communication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatementCommunication()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_STATEMENT_COMMUNICATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledStatementCommunication() <em>Enabled Statement Communication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatementCommunication()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledStatementCommunication = ENABLED_STATEMENT_COMMUNICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledStatementTestDecision() <em>Enabled Statement Test Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatementTestDecision()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_STATEMENT_TEST_DECISION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledStatementTestDecision() <em>Enabled Statement Test Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatementTestDecision()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledStatementTestDecision = ENABLED_STATEMENT_TEST_DECISION_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledBytecode() <em>Enabled Bytecode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledBytecode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_BYTECODE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledBytecode() <em>Enabled Bytecode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledBytecode()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledBytecode = ENABLED_BYTECODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledData() <em>Enabled Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledData()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_DATA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledData() <em>Enabled Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledData()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledData = ENABLED_DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledTrace() <em>Enabled Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledTrace()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_TRACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledTrace() <em>Enabled Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledTrace()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledTrace = ENABLED_TRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledVariable() <em>Enabled Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledVariable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_VARIABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledVariable() <em>Enabled Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledVariable()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledVariable = ENABLED_VARIABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledBuffer() <em>Enabled Buffer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledBuffer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_BUFFER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledBuffer() <em>Enabled Buffer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledBuffer()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledBuffer = ENABLED_BUFFER_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledPort() <em>Enabled Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPort()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_PORT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledPort() <em>Enabled Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledPort()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledPort = ENABLED_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledSignal() <em>Enabled Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledSignal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_SIGNAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledSignal() <em>Enabled Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledSignal()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledSignal = ENABLED_SIGNAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledConnexion() <em>Enabled Connexion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledConnexion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_CONNEXION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledConnexion() <em>Enabled Connexion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledConnexion()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledConnexion = ENABLED_CONNEXION_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledTime() <em>Enabled Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledTime()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_TIME_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledTime() <em>Enabled Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledTime()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledTime = ENABLED_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledExecutable() <em>Enabled Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledExecutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EXECUTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledExecutable() <em>Enabled Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledExecutable()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledExecutable = ENABLED_EXECUTABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledActivity() <em>Enabled Activity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledActivity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_ACTIVITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledActivity() <em>Enabled Activity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledActivity()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledActivity = ENABLED_ACTIVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledRoutine() <em>Enabled Routine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledRoutine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_ROUTINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledRoutine() <em>Enabled Routine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledRoutine()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledRoutine = ENABLED_ROUTINE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledTransition() <em>Enabled Transition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledTransition()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_TRANSITION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledTransition() <em>Enabled Transition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledTransition()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledTransition = ENABLED_TRANSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledMachine() <em>Enabled Machine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledMachine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_MACHINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledMachine() <em>Enabled Machine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledMachine()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledMachine = ENABLED_MACHINE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledStatemachine() <em>Enabled Statemachine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatemachine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_STATEMACHINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledStatemachine() <em>Enabled Statemachine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledStatemachine()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledStatemachine = ENABLED_STATEMACHINE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledNameId() <em>Enabled Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledNameId()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_NAME_ID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledNameId() <em>Enabled Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledNameId()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledNameId = ENABLED_NAME_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledQualifiedNameId() <em>Enabled Qualified Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledQualifiedNameId()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_QUALIFIED_NAME_ID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledQualifiedNameId() <em>Enabled Qualified Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledQualifiedNameId()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledQualifiedNameId = ENABLED_QUALIFIED_NAME_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledFullyQualifiedNameId() <em>Enabled Fully Qualified Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledFullyQualifiedNameId()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_FULLY_QUALIFIED_NAME_ID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledFullyQualifiedNameId() <em>Enabled Fully Qualified Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledFullyQualifiedNameId()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledFullyQualifiedNameId = ENABLED_FULLY_QUALIFIED_NAME_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledRedundance() <em>Enabled Redundance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledRedundance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_REDUNDANCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledRedundance() <em>Enabled Redundance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledRedundance()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledRedundance = ENABLED_REDUNDANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledReferenceCounting() <em>Enabled Reference Counting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledReferenceCounting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_REFERENCE_COUNTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledReferenceCounting() <em>Enabled Reference Counting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledReferenceCounting()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledReferenceCounting = ENABLED_REFERENCE_COUNTING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledNothing() <em>Enabled Nothing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledNothing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_NOTHING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledNothing() <em>Enabled Nothing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledNothing()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledNothing = ENABLED_NOTHING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledGodMode() <em>Enabled God Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledGodMode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_GOD_MODE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledGodMode() <em>Enabled God Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledGodMode()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledGodMode = ENABLED_GOD_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeveloperTuningOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.DEVELOPER_TUNING_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogTraceFilename() {
		return logTraceFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogTraceFilename(String newLogTraceFilename) {
		String oldLogTraceFilename = logTraceFilename;
		logTraceFilename = newLogTraceFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__LOG_TRACE_FILENAME, oldLogTraceFilename, logTraceFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDebugTraceFilename() {
		return debugTraceFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugTraceFilename(String newDebugTraceFilename) {
		String oldDebugTraceFilename = debugTraceFilename;
		debugTraceFilename = newDebugTraceFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_TRACE_FILENAME, oldDebugTraceFilename, debugTraceFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebuglevelKind getDebugLevel() {
		return debugLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugLevel(DebuglevelKind newDebugLevel) {
		DebuglevelKind oldDebugLevel = debugLevel;
		debugLevel = newDebugLevel == null ? DEBUG_LEVEL_EDEFAULT : newDebugLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_LEVEL, oldDebugLevel, debugLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDebugFilename() {
		return debugFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugFilename(String newDebugFilename) {
		String oldDebugFilename = debugFilename;
		debugFilename = newDebugFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_FILENAME, oldDebugFilename, debugFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputFilename() {
		return outputFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputFilename(String newOutputFilename) {
		String oldOutputFilename = outputFilename;
		outputFilename = newOutputFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__OUTPUT_FILENAME, oldOutputFilename, outputFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecificationFilename() {
		return specificationFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificationFilename(String newSpecificationFilename) {
		String oldSpecificationFilename = specificationFilename;
		specificationFilename = newSpecificationFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__SPECIFICATION_FILENAME, oldSpecificationFilename, specificationFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExecutableFilename() {
		return executableFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutableFilename(String newExecutableFilename) {
		String oldExecutableFilename = executableFilename;
		executableFilename = newExecutableFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__EXECUTABLE_FILENAME, oldExecutableFilename, executableFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbexGraphFilename() {
		return symbexGraphFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbexGraphFilename(String newSymbexGraphFilename) {
		String oldSymbexGraphFilename = symbexGraphFilename;
		symbexGraphFilename = newSymbexGraphFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_GRAPH_FILENAME, oldSymbexGraphFilename, symbexGraphFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParsedModelFilename() {
		return parsedModelFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParsedModelFilename(String newParsedModelFilename) {
		String oldParsedModelFilename = parsedModelFilename;
		parsedModelFilename = newParsedModelFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__PARSED_MODEL_FILENAME, oldParsedModelFilename, parsedModelFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompiledModelFilename() {
		return compiledModelFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompiledModelFilename(String newCompiledModelFilename) {
		String oldCompiledModelFilename = compiledModelFilename;
		compiledModelFilename = newCompiledModelFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__COMPILED_MODEL_FILENAME, oldCompiledModelFilename, compiledModelFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbexTraceFilename() {
		return symbexTraceFilename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbexTraceFilename(String newSymbexTraceFilename) {
		String oldSymbexTraceFilename = symbexTraceFilename;
		symbexTraceFilename = newSymbexTraceFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_TRACE_FILENAME, oldSymbexTraceFilename, symbexTraceFilename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledParsing() {
		return enabledParsing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledParsing(boolean newEnabledParsing) {
		boolean oldEnabledParsing = enabledParsing;
		enabledParsing = newEnabledParsing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PARSING, oldEnabledParsing, enabledParsing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledConfiguring() {
		return enabledConfiguring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledConfiguring(boolean newEnabledConfiguring) {
		boolean oldEnabledConfiguring = enabledConfiguring;
		enabledConfiguring = newEnabledConfiguring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONFIGURING, oldEnabledConfiguring, enabledConfiguring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledCompiling() {
		return enabledCompiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledCompiling(boolean newEnabledCompiling) {
		boolean oldEnabledCompiling = enabledCompiling;
		enabledCompiling = newEnabledCompiling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPILING, oldEnabledCompiling, enabledCompiling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledLoading() {
		return enabledLoading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledLoading(boolean newEnabledLoading) {
		boolean oldEnabledLoading = enabledLoading;
		enabledLoading = newEnabledLoading;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_LOADING, oldEnabledLoading, enabledLoading));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledComputing() {
		return enabledComputing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledComputing(boolean newEnabledComputing) {
		boolean oldEnabledComputing = enabledComputing;
		enabledComputing = newEnabledComputing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPUTING, oldEnabledComputing, enabledComputing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledReporting() {
		return enabledReporting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledReporting(boolean newEnabledReporting) {
		boolean oldEnabledReporting = enabledReporting;
		enabledReporting = newEnabledReporting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REPORTING, oldEnabledReporting, enabledReporting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledSolving() {
		return enabledSolving;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledSolving(boolean newEnabledSolving) {
		boolean oldEnabledSolving = enabledSolving;
		enabledSolving = newEnabledSolving;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SOLVING, oldEnabledSolving, enabledSolving));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledProfiling() {
		return enabledProfiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledProfiling(boolean newEnabledProfiling) {
		boolean oldEnabledProfiling = enabledProfiling;
		enabledProfiling = newEnabledProfiling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROFILING, oldEnabledProfiling, enabledProfiling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledAllProcessStage() {
		return enabledAllProcessStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledAllProcessStage(boolean newEnabledAllProcessStage) {
		boolean oldEnabledAllProcessStage = enabledAllProcessStage;
		enabledAllProcessStage = newEnabledAllProcessStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ALL_PROCESS_STAGE, oldEnabledAllProcessStage, enabledAllProcessStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledPreProcessing() {
		return enabledPreProcessing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledPreProcessing(boolean newEnabledPreProcessing) {
		boolean oldEnabledPreProcessing = enabledPreProcessing;
		enabledPreProcessing = newEnabledPreProcessing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_PROCESSING, oldEnabledPreProcessing, enabledPreProcessing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledPostProcessing() {
		return enabledPostProcessing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledPostProcessing(boolean newEnabledPostProcessing) {
		boolean oldEnabledPostProcessing = enabledPostProcessing;
		enabledPostProcessing = newEnabledPostProcessing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_PROCESSING, oldEnabledPostProcessing, enabledPostProcessing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledProcessing() {
		return enabledProcessing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledProcessing(boolean newEnabledProcessing) {
		boolean oldEnabledProcessing = enabledProcessing;
		enabledProcessing = newEnabledProcessing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROCESSING, oldEnabledProcessing, enabledProcessing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledPreFiltering() {
		return enabledPreFiltering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledPreFiltering(boolean newEnabledPreFiltering) {
		boolean oldEnabledPreFiltering = enabledPreFiltering;
		enabledPreFiltering = newEnabledPreFiltering;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_FILTERING, oldEnabledPreFiltering, enabledPreFiltering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledPostFiltering() {
		return enabledPostFiltering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledPostFiltering(boolean newEnabledPostFiltering) {
		boolean oldEnabledPostFiltering = enabledPostFiltering;
		enabledPostFiltering = newEnabledPostFiltering;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_FILTERING, oldEnabledPostFiltering, enabledPostFiltering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledFiltering() {
		return enabledFiltering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledFiltering(boolean newEnabledFiltering) {
		boolean oldEnabledFiltering = enabledFiltering;
		enabledFiltering = newEnabledFiltering;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FILTERING, oldEnabledFiltering, enabledFiltering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledQueue() {
		return enabledQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledQueue(boolean newEnabledQueue) {
		boolean oldEnabledQueue = enabledQueue;
		enabledQueue = newEnabledQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUEUE, oldEnabledQueue, enabledQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledProgram() {
		return enabledProgram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledProgram(boolean newEnabledProgram) {
		boolean oldEnabledProgram = enabledProgram;
		enabledProgram = newEnabledProgram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROGRAM, oldEnabledProgram, enabledProgram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledStatement() {
		return enabledStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledStatement(boolean newEnabledStatement) {
		boolean oldEnabledStatement = enabledStatement;
		enabledStatement = newEnabledStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT, oldEnabledStatement, enabledStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledStatementAssignment() {
		return enabledStatementAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledStatementAssignment(boolean newEnabledStatementAssignment) {
		boolean oldEnabledStatementAssignment = enabledStatementAssignment;
		enabledStatementAssignment = newEnabledStatementAssignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_ASSIGNMENT, oldEnabledStatementAssignment, enabledStatementAssignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledStatementCommunication() {
		return enabledStatementCommunication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledStatementCommunication(boolean newEnabledStatementCommunication) {
		boolean oldEnabledStatementCommunication = enabledStatementCommunication;
		enabledStatementCommunication = newEnabledStatementCommunication;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_COMMUNICATION, oldEnabledStatementCommunication, enabledStatementCommunication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledStatementTestDecision() {
		return enabledStatementTestDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledStatementTestDecision(boolean newEnabledStatementTestDecision) {
		boolean oldEnabledStatementTestDecision = enabledStatementTestDecision;
		enabledStatementTestDecision = newEnabledStatementTestDecision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_TEST_DECISION, oldEnabledStatementTestDecision, enabledStatementTestDecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledBytecode() {
		return enabledBytecode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledBytecode(boolean newEnabledBytecode) {
		boolean oldEnabledBytecode = enabledBytecode;
		enabledBytecode = newEnabledBytecode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BYTECODE, oldEnabledBytecode, enabledBytecode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledData() {
		return enabledData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledData(boolean newEnabledData) {
		boolean oldEnabledData = enabledData;
		enabledData = newEnabledData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_DATA, oldEnabledData, enabledData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledTrace() {
		return enabledTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledTrace(boolean newEnabledTrace) {
		boolean oldEnabledTrace = enabledTrace;
		enabledTrace = newEnabledTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRACE, oldEnabledTrace, enabledTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledVariable() {
		return enabledVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledVariable(boolean newEnabledVariable) {
		boolean oldEnabledVariable = enabledVariable;
		enabledVariable = newEnabledVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_VARIABLE, oldEnabledVariable, enabledVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledBuffer() {
		return enabledBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledBuffer(boolean newEnabledBuffer) {
		boolean oldEnabledBuffer = enabledBuffer;
		enabledBuffer = newEnabledBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BUFFER, oldEnabledBuffer, enabledBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledPort() {
		return enabledPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledPort(boolean newEnabledPort) {
		boolean oldEnabledPort = enabledPort;
		enabledPort = newEnabledPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PORT, oldEnabledPort, enabledPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledSignal() {
		return enabledSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledSignal(boolean newEnabledSignal) {
		boolean oldEnabledSignal = enabledSignal;
		enabledSignal = newEnabledSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SIGNAL, oldEnabledSignal, enabledSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledConnexion() {
		return enabledConnexion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledConnexion(boolean newEnabledConnexion) {
		boolean oldEnabledConnexion = enabledConnexion;
		enabledConnexion = newEnabledConnexion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONNEXION, oldEnabledConnexion, enabledConnexion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledTime() {
		return enabledTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledTime(boolean newEnabledTime) {
		boolean oldEnabledTime = enabledTime;
		enabledTime = newEnabledTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TIME, oldEnabledTime, enabledTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledExecutable() {
		return enabledExecutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledExecutable(boolean newEnabledExecutable) {
		boolean oldEnabledExecutable = enabledExecutable;
		enabledExecutable = newEnabledExecutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_EXECUTABLE, oldEnabledExecutable, enabledExecutable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledActivity() {
		return enabledActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledActivity(boolean newEnabledActivity) {
		boolean oldEnabledActivity = enabledActivity;
		enabledActivity = newEnabledActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ACTIVITY, oldEnabledActivity, enabledActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledRoutine() {
		return enabledRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledRoutine(boolean newEnabledRoutine) {
		boolean oldEnabledRoutine = enabledRoutine;
		enabledRoutine = newEnabledRoutine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ROUTINE, oldEnabledRoutine, enabledRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledTransition() {
		return enabledTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledTransition(boolean newEnabledTransition) {
		boolean oldEnabledTransition = enabledTransition;
		enabledTransition = newEnabledTransition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRANSITION, oldEnabledTransition, enabledTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledMachine() {
		return enabledMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledMachine(boolean newEnabledMachine) {
		boolean oldEnabledMachine = enabledMachine;
		enabledMachine = newEnabledMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_MACHINE, oldEnabledMachine, enabledMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledStatemachine() {
		return enabledStatemachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledStatemachine(boolean newEnabledStatemachine) {
		boolean oldEnabledStatemachine = enabledStatemachine;
		enabledStatemachine = newEnabledStatemachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMACHINE, oldEnabledStatemachine, enabledStatemachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledNameId() {
		return enabledNameId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledNameId(boolean newEnabledNameId) {
		boolean oldEnabledNameId = enabledNameId;
		enabledNameId = newEnabledNameId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NAME_ID, oldEnabledNameId, enabledNameId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledQualifiedNameId() {
		return enabledQualifiedNameId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledQualifiedNameId(boolean newEnabledQualifiedNameId) {
		boolean oldEnabledQualifiedNameId = enabledQualifiedNameId;
		enabledQualifiedNameId = newEnabledQualifiedNameId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUALIFIED_NAME_ID, oldEnabledQualifiedNameId, enabledQualifiedNameId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledFullyQualifiedNameId() {
		return enabledFullyQualifiedNameId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledFullyQualifiedNameId(boolean newEnabledFullyQualifiedNameId) {
		boolean oldEnabledFullyQualifiedNameId = enabledFullyQualifiedNameId;
		enabledFullyQualifiedNameId = newEnabledFullyQualifiedNameId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FULLY_QUALIFIED_NAME_ID, oldEnabledFullyQualifiedNameId, enabledFullyQualifiedNameId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledRedundance() {
		return enabledRedundance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledRedundance(boolean newEnabledRedundance) {
		boolean oldEnabledRedundance = enabledRedundance;
		enabledRedundance = newEnabledRedundance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REDUNDANCE, oldEnabledRedundance, enabledRedundance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledReferenceCounting() {
		return enabledReferenceCounting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledReferenceCounting(boolean newEnabledReferenceCounting) {
		boolean oldEnabledReferenceCounting = enabledReferenceCounting;
		enabledReferenceCounting = newEnabledReferenceCounting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REFERENCE_COUNTING, oldEnabledReferenceCounting, enabledReferenceCounting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledNothing() {
		return enabledNothing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledNothing(boolean newEnabledNothing) {
		boolean oldEnabledNothing = enabledNothing;
		enabledNothing = newEnabledNothing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NOTHING, oldEnabledNothing, enabledNothing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledGodMode() {
		return enabledGodMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledGodMode(boolean newEnabledGodMode) {
		boolean oldEnabledGodMode = enabledGodMode;
		enabledGodMode = newEnabledGodMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_GOD_MODE, oldEnabledGodMode, enabledGodMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.DEVELOPER_TUNING_OPTION__LOG_TRACE_FILENAME:
				return getLogTraceFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_TRACE_FILENAME:
				return getDebugTraceFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_LEVEL:
				return getDebugLevel();
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_FILENAME:
				return getDebugFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__OUTPUT_FILENAME:
				return getOutputFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__SPECIFICATION_FILENAME:
				return getSpecificationFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__EXECUTABLE_FILENAME:
				return getExecutableFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_GRAPH_FILENAME:
				return getSymbexGraphFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__PARSED_MODEL_FILENAME:
				return getParsedModelFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__COMPILED_MODEL_FILENAME:
				return getCompiledModelFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_TRACE_FILENAME:
				return getSymbexTraceFilename();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PARSING:
				return isEnabledParsing();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONFIGURING:
				return isEnabledConfiguring();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPILING:
				return isEnabledCompiling();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_LOADING:
				return isEnabledLoading();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPUTING:
				return isEnabledComputing();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REPORTING:
				return isEnabledReporting();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SOLVING:
				return isEnabledSolving();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROFILING:
				return isEnabledProfiling();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ALL_PROCESS_STAGE:
				return isEnabledAllProcessStage();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_PROCESSING:
				return isEnabledPreProcessing();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_PROCESSING:
				return isEnabledPostProcessing();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROCESSING:
				return isEnabledProcessing();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_FILTERING:
				return isEnabledPreFiltering();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_FILTERING:
				return isEnabledPostFiltering();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FILTERING:
				return isEnabledFiltering();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUEUE:
				return isEnabledQueue();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROGRAM:
				return isEnabledProgram();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT:
				return isEnabledStatement();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_ASSIGNMENT:
				return isEnabledStatementAssignment();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_COMMUNICATION:
				return isEnabledStatementCommunication();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_TEST_DECISION:
				return isEnabledStatementTestDecision();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BYTECODE:
				return isEnabledBytecode();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_DATA:
				return isEnabledData();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRACE:
				return isEnabledTrace();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_VARIABLE:
				return isEnabledVariable();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BUFFER:
				return isEnabledBuffer();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PORT:
				return isEnabledPort();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SIGNAL:
				return isEnabledSignal();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONNEXION:
				return isEnabledConnexion();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TIME:
				return isEnabledTime();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_EXECUTABLE:
				return isEnabledExecutable();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ACTIVITY:
				return isEnabledActivity();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ROUTINE:
				return isEnabledRoutine();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRANSITION:
				return isEnabledTransition();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_MACHINE:
				return isEnabledMachine();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMACHINE:
				return isEnabledStatemachine();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NAME_ID:
				return isEnabledNameId();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUALIFIED_NAME_ID:
				return isEnabledQualifiedNameId();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FULLY_QUALIFIED_NAME_ID:
				return isEnabledFullyQualifiedNameId();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REDUNDANCE:
				return isEnabledRedundance();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REFERENCE_COUNTING:
				return isEnabledReferenceCounting();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NOTHING:
				return isEnabledNothing();
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_GOD_MODE:
				return isEnabledGodMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonPackage.DEVELOPER_TUNING_OPTION__LOG_TRACE_FILENAME:
				setLogTraceFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_TRACE_FILENAME:
				setDebugTraceFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_LEVEL:
				setDebugLevel((DebuglevelKind)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_FILENAME:
				setDebugFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__OUTPUT_FILENAME:
				setOutputFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__SPECIFICATION_FILENAME:
				setSpecificationFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__EXECUTABLE_FILENAME:
				setExecutableFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_GRAPH_FILENAME:
				setSymbexGraphFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__PARSED_MODEL_FILENAME:
				setParsedModelFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__COMPILED_MODEL_FILENAME:
				setCompiledModelFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_TRACE_FILENAME:
				setSymbexTraceFilename((String)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PARSING:
				setEnabledParsing((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONFIGURING:
				setEnabledConfiguring((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPILING:
				setEnabledCompiling((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_LOADING:
				setEnabledLoading((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPUTING:
				setEnabledComputing((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REPORTING:
				setEnabledReporting((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SOLVING:
				setEnabledSolving((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROFILING:
				setEnabledProfiling((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ALL_PROCESS_STAGE:
				setEnabledAllProcessStage((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_PROCESSING:
				setEnabledPreProcessing((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_PROCESSING:
				setEnabledPostProcessing((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROCESSING:
				setEnabledProcessing((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_FILTERING:
				setEnabledPreFiltering((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_FILTERING:
				setEnabledPostFiltering((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FILTERING:
				setEnabledFiltering((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUEUE:
				setEnabledQueue((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROGRAM:
				setEnabledProgram((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT:
				setEnabledStatement((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_ASSIGNMENT:
				setEnabledStatementAssignment((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_COMMUNICATION:
				setEnabledStatementCommunication((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_TEST_DECISION:
				setEnabledStatementTestDecision((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BYTECODE:
				setEnabledBytecode((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_DATA:
				setEnabledData((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRACE:
				setEnabledTrace((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_VARIABLE:
				setEnabledVariable((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BUFFER:
				setEnabledBuffer((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PORT:
				setEnabledPort((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SIGNAL:
				setEnabledSignal((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONNEXION:
				setEnabledConnexion((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TIME:
				setEnabledTime((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_EXECUTABLE:
				setEnabledExecutable((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ACTIVITY:
				setEnabledActivity((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ROUTINE:
				setEnabledRoutine((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRANSITION:
				setEnabledTransition((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_MACHINE:
				setEnabledMachine((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMACHINE:
				setEnabledStatemachine((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NAME_ID:
				setEnabledNameId((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUALIFIED_NAME_ID:
				setEnabledQualifiedNameId((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FULLY_QUALIFIED_NAME_ID:
				setEnabledFullyQualifiedNameId((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REDUNDANCE:
				setEnabledRedundance((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REFERENCE_COUNTING:
				setEnabledReferenceCounting((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NOTHING:
				setEnabledNothing((Boolean)newValue);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_GOD_MODE:
				setEnabledGodMode((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CommonPackage.DEVELOPER_TUNING_OPTION__LOG_TRACE_FILENAME:
				setLogTraceFilename(LOG_TRACE_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_TRACE_FILENAME:
				setDebugTraceFilename(DEBUG_TRACE_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_LEVEL:
				setDebugLevel(DEBUG_LEVEL_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_FILENAME:
				setDebugFilename(DEBUG_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__OUTPUT_FILENAME:
				setOutputFilename(OUTPUT_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__SPECIFICATION_FILENAME:
				setSpecificationFilename(SPECIFICATION_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__EXECUTABLE_FILENAME:
				setExecutableFilename(EXECUTABLE_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_GRAPH_FILENAME:
				setSymbexGraphFilename(SYMBEX_GRAPH_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__PARSED_MODEL_FILENAME:
				setParsedModelFilename(PARSED_MODEL_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__COMPILED_MODEL_FILENAME:
				setCompiledModelFilename(COMPILED_MODEL_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_TRACE_FILENAME:
				setSymbexTraceFilename(SYMBEX_TRACE_FILENAME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PARSING:
				setEnabledParsing(ENABLED_PARSING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONFIGURING:
				setEnabledConfiguring(ENABLED_CONFIGURING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPILING:
				setEnabledCompiling(ENABLED_COMPILING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_LOADING:
				setEnabledLoading(ENABLED_LOADING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPUTING:
				setEnabledComputing(ENABLED_COMPUTING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REPORTING:
				setEnabledReporting(ENABLED_REPORTING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SOLVING:
				setEnabledSolving(ENABLED_SOLVING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROFILING:
				setEnabledProfiling(ENABLED_PROFILING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ALL_PROCESS_STAGE:
				setEnabledAllProcessStage(ENABLED_ALL_PROCESS_STAGE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_PROCESSING:
				setEnabledPreProcessing(ENABLED_PRE_PROCESSING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_PROCESSING:
				setEnabledPostProcessing(ENABLED_POST_PROCESSING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROCESSING:
				setEnabledProcessing(ENABLED_PROCESSING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_FILTERING:
				setEnabledPreFiltering(ENABLED_PRE_FILTERING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_FILTERING:
				setEnabledPostFiltering(ENABLED_POST_FILTERING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FILTERING:
				setEnabledFiltering(ENABLED_FILTERING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUEUE:
				setEnabledQueue(ENABLED_QUEUE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROGRAM:
				setEnabledProgram(ENABLED_PROGRAM_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT:
				setEnabledStatement(ENABLED_STATEMENT_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_ASSIGNMENT:
				setEnabledStatementAssignment(ENABLED_STATEMENT_ASSIGNMENT_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_COMMUNICATION:
				setEnabledStatementCommunication(ENABLED_STATEMENT_COMMUNICATION_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_TEST_DECISION:
				setEnabledStatementTestDecision(ENABLED_STATEMENT_TEST_DECISION_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BYTECODE:
				setEnabledBytecode(ENABLED_BYTECODE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_DATA:
				setEnabledData(ENABLED_DATA_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRACE:
				setEnabledTrace(ENABLED_TRACE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_VARIABLE:
				setEnabledVariable(ENABLED_VARIABLE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BUFFER:
				setEnabledBuffer(ENABLED_BUFFER_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PORT:
				setEnabledPort(ENABLED_PORT_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SIGNAL:
				setEnabledSignal(ENABLED_SIGNAL_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONNEXION:
				setEnabledConnexion(ENABLED_CONNEXION_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TIME:
				setEnabledTime(ENABLED_TIME_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_EXECUTABLE:
				setEnabledExecutable(ENABLED_EXECUTABLE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ACTIVITY:
				setEnabledActivity(ENABLED_ACTIVITY_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ROUTINE:
				setEnabledRoutine(ENABLED_ROUTINE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRANSITION:
				setEnabledTransition(ENABLED_TRANSITION_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_MACHINE:
				setEnabledMachine(ENABLED_MACHINE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMACHINE:
				setEnabledStatemachine(ENABLED_STATEMACHINE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NAME_ID:
				setEnabledNameId(ENABLED_NAME_ID_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUALIFIED_NAME_ID:
				setEnabledQualifiedNameId(ENABLED_QUALIFIED_NAME_ID_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FULLY_QUALIFIED_NAME_ID:
				setEnabledFullyQualifiedNameId(ENABLED_FULLY_QUALIFIED_NAME_ID_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REDUNDANCE:
				setEnabledRedundance(ENABLED_REDUNDANCE_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REFERENCE_COUNTING:
				setEnabledReferenceCounting(ENABLED_REFERENCE_COUNTING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NOTHING:
				setEnabledNothing(ENABLED_NOTHING_EDEFAULT);
				return;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_GOD_MODE:
				setEnabledGodMode(ENABLED_GOD_MODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonPackage.DEVELOPER_TUNING_OPTION__LOG_TRACE_FILENAME:
				return LOG_TRACE_FILENAME_EDEFAULT == null ? logTraceFilename != null : !LOG_TRACE_FILENAME_EDEFAULT.equals(logTraceFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_TRACE_FILENAME:
				return DEBUG_TRACE_FILENAME_EDEFAULT == null ? debugTraceFilename != null : !DEBUG_TRACE_FILENAME_EDEFAULT.equals(debugTraceFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_LEVEL:
				return debugLevel != DEBUG_LEVEL_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__DEBUG_FILENAME:
				return DEBUG_FILENAME_EDEFAULT == null ? debugFilename != null : !DEBUG_FILENAME_EDEFAULT.equals(debugFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__OUTPUT_FILENAME:
				return OUTPUT_FILENAME_EDEFAULT == null ? outputFilename != null : !OUTPUT_FILENAME_EDEFAULT.equals(outputFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__SPECIFICATION_FILENAME:
				return SPECIFICATION_FILENAME_EDEFAULT == null ? specificationFilename != null : !SPECIFICATION_FILENAME_EDEFAULT.equals(specificationFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__EXECUTABLE_FILENAME:
				return EXECUTABLE_FILENAME_EDEFAULT == null ? executableFilename != null : !EXECUTABLE_FILENAME_EDEFAULT.equals(executableFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_GRAPH_FILENAME:
				return SYMBEX_GRAPH_FILENAME_EDEFAULT == null ? symbexGraphFilename != null : !SYMBEX_GRAPH_FILENAME_EDEFAULT.equals(symbexGraphFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__PARSED_MODEL_FILENAME:
				return PARSED_MODEL_FILENAME_EDEFAULT == null ? parsedModelFilename != null : !PARSED_MODEL_FILENAME_EDEFAULT.equals(parsedModelFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__COMPILED_MODEL_FILENAME:
				return COMPILED_MODEL_FILENAME_EDEFAULT == null ? compiledModelFilename != null : !COMPILED_MODEL_FILENAME_EDEFAULT.equals(compiledModelFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__SYMBEX_TRACE_FILENAME:
				return SYMBEX_TRACE_FILENAME_EDEFAULT == null ? symbexTraceFilename != null : !SYMBEX_TRACE_FILENAME_EDEFAULT.equals(symbexTraceFilename);
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PARSING:
				return enabledParsing != ENABLED_PARSING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONFIGURING:
				return enabledConfiguring != ENABLED_CONFIGURING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPILING:
				return enabledCompiling != ENABLED_COMPILING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_LOADING:
				return enabledLoading != ENABLED_LOADING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_COMPUTING:
				return enabledComputing != ENABLED_COMPUTING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REPORTING:
				return enabledReporting != ENABLED_REPORTING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SOLVING:
				return enabledSolving != ENABLED_SOLVING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROFILING:
				return enabledProfiling != ENABLED_PROFILING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ALL_PROCESS_STAGE:
				return enabledAllProcessStage != ENABLED_ALL_PROCESS_STAGE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_PROCESSING:
				return enabledPreProcessing != ENABLED_PRE_PROCESSING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_PROCESSING:
				return enabledPostProcessing != ENABLED_POST_PROCESSING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROCESSING:
				return enabledProcessing != ENABLED_PROCESSING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PRE_FILTERING:
				return enabledPreFiltering != ENABLED_PRE_FILTERING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_POST_FILTERING:
				return enabledPostFiltering != ENABLED_POST_FILTERING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FILTERING:
				return enabledFiltering != ENABLED_FILTERING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUEUE:
				return enabledQueue != ENABLED_QUEUE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PROGRAM:
				return enabledProgram != ENABLED_PROGRAM_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT:
				return enabledStatement != ENABLED_STATEMENT_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_ASSIGNMENT:
				return enabledStatementAssignment != ENABLED_STATEMENT_ASSIGNMENT_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_COMMUNICATION:
				return enabledStatementCommunication != ENABLED_STATEMENT_COMMUNICATION_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_TEST_DECISION:
				return enabledStatementTestDecision != ENABLED_STATEMENT_TEST_DECISION_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BYTECODE:
				return enabledBytecode != ENABLED_BYTECODE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_DATA:
				return enabledData != ENABLED_DATA_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRACE:
				return enabledTrace != ENABLED_TRACE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_VARIABLE:
				return enabledVariable != ENABLED_VARIABLE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_BUFFER:
				return enabledBuffer != ENABLED_BUFFER_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_PORT:
				return enabledPort != ENABLED_PORT_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_SIGNAL:
				return enabledSignal != ENABLED_SIGNAL_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_CONNEXION:
				return enabledConnexion != ENABLED_CONNEXION_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TIME:
				return enabledTime != ENABLED_TIME_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_EXECUTABLE:
				return enabledExecutable != ENABLED_EXECUTABLE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ACTIVITY:
				return enabledActivity != ENABLED_ACTIVITY_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_ROUTINE:
				return enabledRoutine != ENABLED_ROUTINE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_TRANSITION:
				return enabledTransition != ENABLED_TRANSITION_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_MACHINE:
				return enabledMachine != ENABLED_MACHINE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_STATEMACHINE:
				return enabledStatemachine != ENABLED_STATEMACHINE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NAME_ID:
				return enabledNameId != ENABLED_NAME_ID_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_QUALIFIED_NAME_ID:
				return enabledQualifiedNameId != ENABLED_QUALIFIED_NAME_ID_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_FULLY_QUALIFIED_NAME_ID:
				return enabledFullyQualifiedNameId != ENABLED_FULLY_QUALIFIED_NAME_ID_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REDUNDANCE:
				return enabledRedundance != ENABLED_REDUNDANCE_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_REFERENCE_COUNTING:
				return enabledReferenceCounting != ENABLED_REFERENCE_COUNTING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_NOTHING:
				return enabledNothing != ENABLED_NOTHING_EDEFAULT;
			case CommonPackage.DEVELOPER_TUNING_OPTION__ENABLED_GOD_MODE:
				return enabledGodMode != ENABLED_GOD_MODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (logTraceFilename: ");
		result.append(logTraceFilename);
		result.append(", debugTraceFilename: ");
		result.append(debugTraceFilename);
		result.append(", debugLevel: ");
		result.append(debugLevel);
		result.append(", debugFilename: ");
		result.append(debugFilename);
		result.append(", outputFilename: ");
		result.append(outputFilename);
		result.append(", specificationFilename: ");
		result.append(specificationFilename);
		result.append(", executableFilename: ");
		result.append(executableFilename);
		result.append(", symbexGraphFilename: ");
		result.append(symbexGraphFilename);
		result.append(", parsedModelFilename: ");
		result.append(parsedModelFilename);
		result.append(", compiledModelFilename: ");
		result.append(compiledModelFilename);
		result.append(", symbexTraceFilename: ");
		result.append(symbexTraceFilename);
		result.append(", enabledParsing: ");
		result.append(enabledParsing);
		result.append(", enabledConfiguring: ");
		result.append(enabledConfiguring);
		result.append(", enabledCompiling: ");
		result.append(enabledCompiling);
		result.append(", enabledLoading: ");
		result.append(enabledLoading);
		result.append(", enabledComputing: ");
		result.append(enabledComputing);
		result.append(", enabledReporting: ");
		result.append(enabledReporting);
		result.append(", enabledSolving: ");
		result.append(enabledSolving);
		result.append(", enabledProfiling: ");
		result.append(enabledProfiling);
		result.append(", enabledAllProcessStage: ");
		result.append(enabledAllProcessStage);
		result.append(", enabledPreProcessing: ");
		result.append(enabledPreProcessing);
		result.append(", enabledPostProcessing: ");
		result.append(enabledPostProcessing);
		result.append(", enabledProcessing: ");
		result.append(enabledProcessing);
		result.append(", enabledPreFiltering: ");
		result.append(enabledPreFiltering);
		result.append(", enabledPostFiltering: ");
		result.append(enabledPostFiltering);
		result.append(", enabledFiltering: ");
		result.append(enabledFiltering);
		result.append(", enabledQueue: ");
		result.append(enabledQueue);
		result.append(", enabledProgram: ");
		result.append(enabledProgram);
		result.append(", enabledStatement: ");
		result.append(enabledStatement);
		result.append(", enabledStatementAssignment: ");
		result.append(enabledStatementAssignment);
		result.append(", enabledStatementCommunication: ");
		result.append(enabledStatementCommunication);
		result.append(", enabledStatementTestDecision: ");
		result.append(enabledStatementTestDecision);
		result.append(", enabledBytecode: ");
		result.append(enabledBytecode);
		result.append(", enabledData: ");
		result.append(enabledData);
		result.append(", enabledTrace: ");
		result.append(enabledTrace);
		result.append(", enabledVariable: ");
		result.append(enabledVariable);
		result.append(", enabledBuffer: ");
		result.append(enabledBuffer);
		result.append(", enabledPort: ");
		result.append(enabledPort);
		result.append(", enabledSignal: ");
		result.append(enabledSignal);
		result.append(", enabledConnexion: ");
		result.append(enabledConnexion);
		result.append(", enabledTime: ");
		result.append(enabledTime);
		result.append(", enabledExecutable: ");
		result.append(enabledExecutable);
		result.append(", enabledActivity: ");
		result.append(enabledActivity);
		result.append(", enabledRoutine: ");
		result.append(enabledRoutine);
		result.append(", enabledTransition: ");
		result.append(enabledTransition);
		result.append(", enabledMachine: ");
		result.append(enabledMachine);
		result.append(", enabledStatemachine: ");
		result.append(enabledStatemachine);
		result.append(", enabledNameId: ");
		result.append(enabledNameId);
		result.append(", enabledQualifiedNameId: ");
		result.append(enabledQualifiedNameId);
		result.append(", enabledFullyQualifiedNameId: ");
		result.append(enabledFullyQualifiedNameId);
		result.append(", enabledRedundance: ");
		result.append(enabledRedundance);
		result.append(", enabledReferenceCounting: ");
		result.append(enabledReferenceCounting);
		result.append(", enabledNothing: ");
		result.append(enabledNothing);
		result.append(", enabledGodMode: ");
		result.append(enabledGodMode);
		result.append(')');
		return result.toString();
	}

} //DeveloperTuningOptionImpl
