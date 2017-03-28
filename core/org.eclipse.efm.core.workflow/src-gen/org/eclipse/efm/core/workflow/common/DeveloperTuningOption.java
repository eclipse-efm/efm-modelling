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
package org.eclipse.efm.core.workflow.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Developer Tuning Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getLogTraceFilename <em>Log Trace Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getDebugTraceFilename <em>Debug Trace Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getDebugLevel <em>Debug Level</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getDebugFilename <em>Debug Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getOutputFilename <em>Output Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getSpecificationFilename <em>Specification Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getExecutableFilename <em>Executable Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getSymbexGraphFilename <em>Symbex Graph Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getParsedModelFilename <em>Parsed Model Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getCompiledModelFilename <em>Compiled Model Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getSymbexTraceFilename <em>Symbex Trace Filename</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledParsing <em>Enabled Parsing</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledConfiguring <em>Enabled Configuring</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledCompiling <em>Enabled Compiling</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledLoading <em>Enabled Loading</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledComputing <em>Enabled Computing</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledReporting <em>Enabled Reporting</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledSolver <em>Enabled Solver</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledProfiling <em>Enabled Profiling</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledAllProcessStage <em>Enabled All Process Stage</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPreProcessing <em>Enabled Pre Processing</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPostProcessing <em>Enabled Post Processing</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledProcessing <em>Enabled Processing</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPreFiltering <em>Enabled Pre Filtering</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPostFiltering <em>Enabled Post Filtering</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledFiltering <em>Enabled Filtering</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledQueue <em>Enabled Queue</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledProgram <em>Enabled Program</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatement <em>Enabled Statement</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatementAssignment <em>Enabled Statement Assignment</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatementCommunication <em>Enabled Statement Communication</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatementTestDecision <em>Enabled Statement Test Decision</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledBytecode <em>Enabled Bytecode</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledData <em>Enabled Data</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledTrace <em>Enabled Trace</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledVariable <em>Enabled Variable</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledBuffer <em>Enabled Buffer</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPort <em>Enabled Port</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledSignal <em>Enabled Signal</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledConnexion <em>Enabled Connexion</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledTime <em>Enabled Time</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledExecutable <em>Enabled Executable</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledActivity <em>Enabled Activity</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledRoutine <em>Enabled Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledTransition <em>Enabled Transition</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledMachine <em>Enabled Machine</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatemachine <em>Enabled Statemachine</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledNameId <em>Enabled Name Id</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledQualifiedNameId <em>Enabled Qualified Name Id</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledFullyQualifiedNameId <em>Enabled Fully Qualified Name Id</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledRedundance <em>Enabled Redundance</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledReferenceCounting <em>Enabled Reference Counting</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledNothing <em>Enabled Nothing</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledGodMode <em>Enabled God Mode</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption()
 * @model
 * @generated
 */
public interface DeveloperTuningOption extends EObject {
	/**
	 * Returns the value of the '<em><b>Log Trace Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Trace Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Trace Filename</em>' attribute.
	 * @see #setLogTraceFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_LogTraceFilename()
	 * @model
	 * @generated
	 */
	String getLogTraceFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getLogTraceFilename <em>Log Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Trace Filename</em>' attribute.
	 * @see #getLogTraceFilename()
	 * @generated
	 */
	void setLogTraceFilename(String value);

	/**
	 * Returns the value of the '<em><b>Debug Trace Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug Trace Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Trace Filename</em>' attribute.
	 * @see #setDebugTraceFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_DebugTraceFilename()
	 * @model
	 * @generated
	 */
	String getDebugTraceFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getDebugTraceFilename <em>Debug Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Trace Filename</em>' attribute.
	 * @see #getDebugTraceFilename()
	 * @generated
	 */
	void setDebugTraceFilename(String value);

	/**
	 * Returns the value of the '<em><b>Debug Level</b></em>' attribute.
	 * The default value is <code>"ZERO"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.core.workflow.common.DebuglevelKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Level</em>' attribute.
	 * @see org.eclipse.efm.core.workflow.common.DebuglevelKind
	 * @see #setDebugLevel(DebuglevelKind)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_DebugLevel()
	 * @model default="ZERO"
	 * @generated
	 */
	DebuglevelKind getDebugLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getDebugLevel <em>Debug Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Level</em>' attribute.
	 * @see org.eclipse.efm.core.workflow.common.DebuglevelKind
	 * @see #getDebugLevel()
	 * @generated
	 */
	void setDebugLevel(DebuglevelKind value);

	/**
	 * Returns the value of the '<em><b>Debug Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Filename</em>' attribute.
	 * @see #setDebugFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_DebugFilename()
	 * @model
	 * @generated
	 */
	String getDebugFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getDebugFilename <em>Debug Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Filename</em>' attribute.
	 * @see #getDebugFilename()
	 * @generated
	 */
	void setDebugFilename(String value);

	/**
	 * Returns the value of the '<em><b>Output Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Filename</em>' attribute.
	 * @see #setOutputFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_OutputFilename()
	 * @model
	 * @generated
	 */
	String getOutputFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getOutputFilename <em>Output Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Filename</em>' attribute.
	 * @see #getOutputFilename()
	 * @generated
	 */
	void setOutputFilename(String value);

	/**
	 * Returns the value of the '<em><b>Specification Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification Filename</em>' attribute.
	 * @see #setSpecificationFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_SpecificationFilename()
	 * @model
	 * @generated
	 */
	String getSpecificationFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getSpecificationFilename <em>Specification Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Filename</em>' attribute.
	 * @see #getSpecificationFilename()
	 * @generated
	 */
	void setSpecificationFilename(String value);

	/**
	 * Returns the value of the '<em><b>Executable Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executable Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executable Filename</em>' attribute.
	 * @see #setExecutableFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_ExecutableFilename()
	 * @model
	 * @generated
	 */
	String getExecutableFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getExecutableFilename <em>Executable Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executable Filename</em>' attribute.
	 * @see #getExecutableFilename()
	 * @generated
	 */
	void setExecutableFilename(String value);

	/**
	 * Returns the value of the '<em><b>Symbex Graph Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbex Graph Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbex Graph Filename</em>' attribute.
	 * @see #setSymbexGraphFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_SymbexGraphFilename()
	 * @model
	 * @generated
	 */
	String getSymbexGraphFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getSymbexGraphFilename <em>Symbex Graph Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbex Graph Filename</em>' attribute.
	 * @see #getSymbexGraphFilename()
	 * @generated
	 */
	void setSymbexGraphFilename(String value);

	/**
	 * Returns the value of the '<em><b>Parsed Model Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parsed Model Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parsed Model Filename</em>' attribute.
	 * @see #setParsedModelFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_ParsedModelFilename()
	 * @model
	 * @generated
	 */
	String getParsedModelFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getParsedModelFilename <em>Parsed Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parsed Model Filename</em>' attribute.
	 * @see #getParsedModelFilename()
	 * @generated
	 */
	void setParsedModelFilename(String value);

	/**
	 * Returns the value of the '<em><b>Compiled Model Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compiled Model Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compiled Model Filename</em>' attribute.
	 * @see #setCompiledModelFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_CompiledModelFilename()
	 * @model
	 * @generated
	 */
	String getCompiledModelFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getCompiledModelFilename <em>Compiled Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compiled Model Filename</em>' attribute.
	 * @see #getCompiledModelFilename()
	 * @generated
	 */
	void setCompiledModelFilename(String value);

	/**
	 * Returns the value of the '<em><b>Symbex Trace Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbex Trace Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbex Trace Filename</em>' attribute.
	 * @see #setSymbexTraceFilename(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_SymbexTraceFilename()
	 * @model
	 * @generated
	 */
	String getSymbexTraceFilename();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#getSymbexTraceFilename <em>Symbex Trace Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbex Trace Filename</em>' attribute.
	 * @see #getSymbexTraceFilename()
	 * @generated
	 */
	void setSymbexTraceFilename(String value);

	/**
	 * Returns the value of the '<em><b>Enabled Parsing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Parsing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Parsing</em>' attribute.
	 * @see #setEnabledParsing(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledParsing()
	 * @model
	 * @generated
	 */
	boolean isEnabledParsing();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledParsing <em>Enabled Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Parsing</em>' attribute.
	 * @see #isEnabledParsing()
	 * @generated
	 */
	void setEnabledParsing(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Configuring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Configuring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Configuring</em>' attribute.
	 * @see #setEnabledConfiguring(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledConfiguring()
	 * @model
	 * @generated
	 */
	boolean isEnabledConfiguring();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledConfiguring <em>Enabled Configuring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Configuring</em>' attribute.
	 * @see #isEnabledConfiguring()
	 * @generated
	 */
	void setEnabledConfiguring(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Compiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Compiling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Compiling</em>' attribute.
	 * @see #setEnabledCompiling(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledCompiling()
	 * @model
	 * @generated
	 */
	boolean isEnabledCompiling();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledCompiling <em>Enabled Compiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Compiling</em>' attribute.
	 * @see #isEnabledCompiling()
	 * @generated
	 */
	void setEnabledCompiling(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Loading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Loading</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Loading</em>' attribute.
	 * @see #setEnabledLoading(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledLoading()
	 * @model
	 * @generated
	 */
	boolean isEnabledLoading();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledLoading <em>Enabled Loading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Loading</em>' attribute.
	 * @see #isEnabledLoading()
	 * @generated
	 */
	void setEnabledLoading(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Computing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Computing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Computing</em>' attribute.
	 * @see #setEnabledComputing(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledComputing()
	 * @model
	 * @generated
	 */
	boolean isEnabledComputing();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledComputing <em>Enabled Computing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Computing</em>' attribute.
	 * @see #isEnabledComputing()
	 * @generated
	 */
	void setEnabledComputing(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Reporting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Reporting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Reporting</em>' attribute.
	 * @see #setEnabledReporting(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledReporting()
	 * @model
	 * @generated
	 */
	boolean isEnabledReporting();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledReporting <em>Enabled Reporting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Reporting</em>' attribute.
	 * @see #isEnabledReporting()
	 * @generated
	 */
	void setEnabledReporting(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Solver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Solver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Solver</em>' attribute.
	 * @see #setEnabledSolver(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledSolver()
	 * @model
	 * @generated
	 */
	boolean isEnabledSolver();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledSolver <em>Enabled Solver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Solver</em>' attribute.
	 * @see #isEnabledSolver()
	 * @generated
	 */
	void setEnabledSolver(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Profiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Profiling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Profiling</em>' attribute.
	 * @see #setEnabledProfiling(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledProfiling()
	 * @model
	 * @generated
	 */
	boolean isEnabledProfiling();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledProfiling <em>Enabled Profiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Profiling</em>' attribute.
	 * @see #isEnabledProfiling()
	 * @generated
	 */
	void setEnabledProfiling(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled All Process Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled All Process Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled All Process Stage</em>' attribute.
	 * @see #setEnabledAllProcessStage(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledAllProcessStage()
	 * @model
	 * @generated
	 */
	boolean isEnabledAllProcessStage();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledAllProcessStage <em>Enabled All Process Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled All Process Stage</em>' attribute.
	 * @see #isEnabledAllProcessStage()
	 * @generated
	 */
	void setEnabledAllProcessStage(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Pre Processing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Pre Processing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Pre Processing</em>' attribute.
	 * @see #setEnabledPreProcessing(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledPreProcessing()
	 * @model
	 * @generated
	 */
	boolean isEnabledPreProcessing();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPreProcessing <em>Enabled Pre Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Pre Processing</em>' attribute.
	 * @see #isEnabledPreProcessing()
	 * @generated
	 */
	void setEnabledPreProcessing(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Post Processing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Post Processing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Post Processing</em>' attribute.
	 * @see #setEnabledPostProcessing(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledPostProcessing()
	 * @model
	 * @generated
	 */
	boolean isEnabledPostProcessing();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPostProcessing <em>Enabled Post Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Post Processing</em>' attribute.
	 * @see #isEnabledPostProcessing()
	 * @generated
	 */
	void setEnabledPostProcessing(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Processing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Processing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Processing</em>' attribute.
	 * @see #setEnabledProcessing(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledProcessing()
	 * @model
	 * @generated
	 */
	boolean isEnabledProcessing();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledProcessing <em>Enabled Processing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Processing</em>' attribute.
	 * @see #isEnabledProcessing()
	 * @generated
	 */
	void setEnabledProcessing(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Pre Filtering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Pre Filtering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Pre Filtering</em>' attribute.
	 * @see #setEnabledPreFiltering(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledPreFiltering()
	 * @model
	 * @generated
	 */
	boolean isEnabledPreFiltering();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPreFiltering <em>Enabled Pre Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Pre Filtering</em>' attribute.
	 * @see #isEnabledPreFiltering()
	 * @generated
	 */
	void setEnabledPreFiltering(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Post Filtering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Post Filtering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Post Filtering</em>' attribute.
	 * @see #setEnabledPostFiltering(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledPostFiltering()
	 * @model
	 * @generated
	 */
	boolean isEnabledPostFiltering();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPostFiltering <em>Enabled Post Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Post Filtering</em>' attribute.
	 * @see #isEnabledPostFiltering()
	 * @generated
	 */
	void setEnabledPostFiltering(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Filtering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Filtering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Filtering</em>' attribute.
	 * @see #setEnabledFiltering(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledFiltering()
	 * @model
	 * @generated
	 */
	boolean isEnabledFiltering();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledFiltering <em>Enabled Filtering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Filtering</em>' attribute.
	 * @see #isEnabledFiltering()
	 * @generated
	 */
	void setEnabledFiltering(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Queue</em>' attribute.
	 * @see #setEnabledQueue(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledQueue()
	 * @model
	 * @generated
	 */
	boolean isEnabledQueue();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledQueue <em>Enabled Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Queue</em>' attribute.
	 * @see #isEnabledQueue()
	 * @generated
	 */
	void setEnabledQueue(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Program</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Program</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Program</em>' attribute.
	 * @see #setEnabledProgram(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledProgram()
	 * @model
	 * @generated
	 */
	boolean isEnabledProgram();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledProgram <em>Enabled Program</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Program</em>' attribute.
	 * @see #isEnabledProgram()
	 * @generated
	 */
	void setEnabledProgram(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Statement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Statement</em>' attribute.
	 * @see #setEnabledStatement(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledStatement()
	 * @model
	 * @generated
	 */
	boolean isEnabledStatement();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatement <em>Enabled Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Statement</em>' attribute.
	 * @see #isEnabledStatement()
	 * @generated
	 */
	void setEnabledStatement(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Statement Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Statement Assignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Statement Assignment</em>' attribute.
	 * @see #setEnabledStatementAssignment(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledStatementAssignment()
	 * @model
	 * @generated
	 */
	boolean isEnabledStatementAssignment();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatementAssignment <em>Enabled Statement Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Statement Assignment</em>' attribute.
	 * @see #isEnabledStatementAssignment()
	 * @generated
	 */
	void setEnabledStatementAssignment(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Statement Communication</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Statement Communication</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Statement Communication</em>' attribute.
	 * @see #setEnabledStatementCommunication(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledStatementCommunication()
	 * @model
	 * @generated
	 */
	boolean isEnabledStatementCommunication();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatementCommunication <em>Enabled Statement Communication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Statement Communication</em>' attribute.
	 * @see #isEnabledStatementCommunication()
	 * @generated
	 */
	void setEnabledStatementCommunication(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Statement Test Decision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Statement Test Decision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Statement Test Decision</em>' attribute.
	 * @see #setEnabledStatementTestDecision(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledStatementTestDecision()
	 * @model
	 * @generated
	 */
	boolean isEnabledStatementTestDecision();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatementTestDecision <em>Enabled Statement Test Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Statement Test Decision</em>' attribute.
	 * @see #isEnabledStatementTestDecision()
	 * @generated
	 */
	void setEnabledStatementTestDecision(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Bytecode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Bytecode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Bytecode</em>' attribute.
	 * @see #setEnabledBytecode(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledBytecode()
	 * @model
	 * @generated
	 */
	boolean isEnabledBytecode();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledBytecode <em>Enabled Bytecode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Bytecode</em>' attribute.
	 * @see #isEnabledBytecode()
	 * @generated
	 */
	void setEnabledBytecode(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Data</em>' attribute.
	 * @see #setEnabledData(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledData()
	 * @model
	 * @generated
	 */
	boolean isEnabledData();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledData <em>Enabled Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Data</em>' attribute.
	 * @see #isEnabledData()
	 * @generated
	 */
	void setEnabledData(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Trace</em>' attribute.
	 * @see #setEnabledTrace(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledTrace()
	 * @model
	 * @generated
	 */
	boolean isEnabledTrace();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledTrace <em>Enabled Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Trace</em>' attribute.
	 * @see #isEnabledTrace()
	 * @generated
	 */
	void setEnabledTrace(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Variable</em>' attribute.
	 * @see #setEnabledVariable(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledVariable()
	 * @model
	 * @generated
	 */
	boolean isEnabledVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledVariable <em>Enabled Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Variable</em>' attribute.
	 * @see #isEnabledVariable()
	 * @generated
	 */
	void setEnabledVariable(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Buffer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Buffer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Buffer</em>' attribute.
	 * @see #setEnabledBuffer(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledBuffer()
	 * @model
	 * @generated
	 */
	boolean isEnabledBuffer();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledBuffer <em>Enabled Buffer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Buffer</em>' attribute.
	 * @see #isEnabledBuffer()
	 * @generated
	 */
	void setEnabledBuffer(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Port</em>' attribute.
	 * @see #setEnabledPort(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledPort()
	 * @model
	 * @generated
	 */
	boolean isEnabledPort();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledPort <em>Enabled Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Port</em>' attribute.
	 * @see #isEnabledPort()
	 * @generated
	 */
	void setEnabledPort(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Signal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Signal</em>' attribute.
	 * @see #setEnabledSignal(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledSignal()
	 * @model
	 * @generated
	 */
	boolean isEnabledSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledSignal <em>Enabled Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Signal</em>' attribute.
	 * @see #isEnabledSignal()
	 * @generated
	 */
	void setEnabledSignal(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Connexion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Connexion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Connexion</em>' attribute.
	 * @see #setEnabledConnexion(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledConnexion()
	 * @model
	 * @generated
	 */
	boolean isEnabledConnexion();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledConnexion <em>Enabled Connexion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Connexion</em>' attribute.
	 * @see #isEnabledConnexion()
	 * @generated
	 */
	void setEnabledConnexion(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Time</em>' attribute.
	 * @see #setEnabledTime(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledTime()
	 * @model
	 * @generated
	 */
	boolean isEnabledTime();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledTime <em>Enabled Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Time</em>' attribute.
	 * @see #isEnabledTime()
	 * @generated
	 */
	void setEnabledTime(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Executable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Executable</em>' attribute.
	 * @see #setEnabledExecutable(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledExecutable()
	 * @model
	 * @generated
	 */
	boolean isEnabledExecutable();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledExecutable <em>Enabled Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Executable</em>' attribute.
	 * @see #isEnabledExecutable()
	 * @generated
	 */
	void setEnabledExecutable(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Activity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Activity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Activity</em>' attribute.
	 * @see #setEnabledActivity(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledActivity()
	 * @model
	 * @generated
	 */
	boolean isEnabledActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledActivity <em>Enabled Activity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Activity</em>' attribute.
	 * @see #isEnabledActivity()
	 * @generated
	 */
	void setEnabledActivity(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Routine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Routine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Routine</em>' attribute.
	 * @see #setEnabledRoutine(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledRoutine()
	 * @model
	 * @generated
	 */
	boolean isEnabledRoutine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledRoutine <em>Enabled Routine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Routine</em>' attribute.
	 * @see #isEnabledRoutine()
	 * @generated
	 */
	void setEnabledRoutine(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Transition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Transition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Transition</em>' attribute.
	 * @see #setEnabledTransition(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledTransition()
	 * @model
	 * @generated
	 */
	boolean isEnabledTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledTransition <em>Enabled Transition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Transition</em>' attribute.
	 * @see #isEnabledTransition()
	 * @generated
	 */
	void setEnabledTransition(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Machine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Machine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Machine</em>' attribute.
	 * @see #setEnabledMachine(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledMachine()
	 * @model
	 * @generated
	 */
	boolean isEnabledMachine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledMachine <em>Enabled Machine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Machine</em>' attribute.
	 * @see #isEnabledMachine()
	 * @generated
	 */
	void setEnabledMachine(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Statemachine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Statemachine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Statemachine</em>' attribute.
	 * @see #setEnabledStatemachine(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledStatemachine()
	 * @model
	 * @generated
	 */
	boolean isEnabledStatemachine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledStatemachine <em>Enabled Statemachine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Statemachine</em>' attribute.
	 * @see #isEnabledStatemachine()
	 * @generated
	 */
	void setEnabledStatemachine(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Name Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Name Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Name Id</em>' attribute.
	 * @see #setEnabledNameId(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledNameId()
	 * @model
	 * @generated
	 */
	boolean isEnabledNameId();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledNameId <em>Enabled Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Name Id</em>' attribute.
	 * @see #isEnabledNameId()
	 * @generated
	 */
	void setEnabledNameId(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Qualified Name Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Qualified Name Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Qualified Name Id</em>' attribute.
	 * @see #setEnabledQualifiedNameId(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledQualifiedNameId()
	 * @model
	 * @generated
	 */
	boolean isEnabledQualifiedNameId();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledQualifiedNameId <em>Enabled Qualified Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Qualified Name Id</em>' attribute.
	 * @see #isEnabledQualifiedNameId()
	 * @generated
	 */
	void setEnabledQualifiedNameId(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Fully Qualified Name Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Fully Qualified Name Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Fully Qualified Name Id</em>' attribute.
	 * @see #setEnabledFullyQualifiedNameId(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledFullyQualifiedNameId()
	 * @model
	 * @generated
	 */
	boolean isEnabledFullyQualifiedNameId();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledFullyQualifiedNameId <em>Enabled Fully Qualified Name Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Fully Qualified Name Id</em>' attribute.
	 * @see #isEnabledFullyQualifiedNameId()
	 * @generated
	 */
	void setEnabledFullyQualifiedNameId(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Redundance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Redundance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Redundance</em>' attribute.
	 * @see #setEnabledRedundance(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledRedundance()
	 * @model
	 * @generated
	 */
	boolean isEnabledRedundance();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledRedundance <em>Enabled Redundance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Redundance</em>' attribute.
	 * @see #isEnabledRedundance()
	 * @generated
	 */
	void setEnabledRedundance(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Reference Counting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Reference Counting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Reference Counting</em>' attribute.
	 * @see #setEnabledReferenceCounting(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledReferenceCounting()
	 * @model
	 * @generated
	 */
	boolean isEnabledReferenceCounting();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledReferenceCounting <em>Enabled Reference Counting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Reference Counting</em>' attribute.
	 * @see #isEnabledReferenceCounting()
	 * @generated
	 */
	void setEnabledReferenceCounting(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Nothing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Nothing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Nothing</em>' attribute.
	 * @see #setEnabledNothing(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledNothing()
	 * @model
	 * @generated
	 */
	boolean isEnabledNothing();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledNothing <em>Enabled Nothing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Nothing</em>' attribute.
	 * @see #isEnabledNothing()
	 * @generated
	 */
	void setEnabledNothing(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled God Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled God Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled God Mode</em>' attribute.
	 * @see #setEnabledGodMode(boolean)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getDeveloperTuningOption_EnabledGodMode()
	 * @model
	 * @generated
	 */
	boolean isEnabledGodMode();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.DeveloperTuningOption#isEnabledGodMode <em>Enabled God Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled God Mode</em>' attribute.
	 * @see #isEnabledGodMode()
	 * @generated
	 */
	void setEnabledGodMode(boolean value);

} // DeveloperTuningOption
