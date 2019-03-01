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

import org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic;
import org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coverage Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isNormalizationEnabled <em>Normalization Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isMinimizationEnabled <em>Minimization Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isStopWhenComplete <em>Stop When Complete</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isBreakEnabled <em>Break Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isSliceWhenComplete <em>Slice When Complete</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isHeuristicEnabled <em>Heuristic Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getScope <em>Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getHeuristicConfig <em>Heuristic Config</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker()
 * @model abstract="true"
 * @generated
 */
public interface CoverageWorker extends Worker {
	/**
	 * Returns the value of the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' containment reference.
	 * @see #setTrace(TraceSpecification)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_Trace()
	 * @model containment="true"
	 * @generated
	 */
	TraceSpecification getTrace();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getTrace <em>Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' containment reference.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(TraceSpecification value);

	/**
	 * Returns the value of the '<em><b>Normalization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normalization Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normalization Enabled</em>' attribute.
	 * @see #setNormalizationEnabled(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_NormalizationEnabled()
	 * @model required="true"
	 * @generated
	 */
	boolean isNormalizationEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isNormalizationEnabled <em>Normalization Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalization Enabled</em>' attribute.
	 * @see #isNormalizationEnabled()
	 * @generated
	 */
	void setNormalizationEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Minimization Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimization Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimization Enabled</em>' attribute.
	 * @see #setMinimizationEnabled(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_MinimizationEnabled()
	 * @model required="true"
	 * @generated
	 */
	boolean isMinimizationEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isMinimizationEnabled <em>Minimization Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimization Enabled</em>' attribute.
	 * @see #isMinimizationEnabled()
	 * @generated
	 */
	void setMinimizationEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Stop When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop When Complete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop When Complete</em>' attribute.
	 * @see #setStopWhenComplete(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_StopWhenComplete()
	 * @model required="true"
	 * @generated
	 */
	boolean isStopWhenComplete();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isStopWhenComplete <em>Stop When Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop When Complete</em>' attribute.
	 * @see #isStopWhenComplete()
	 * @generated
	 */
	void setStopWhenComplete(boolean value);

	/**
	 * Returns the value of the '<em><b>Break Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Break Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Break Enabled</em>' attribute.
	 * @see #setBreakEnabled(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_BreakEnabled()
	 * @model required="true"
	 * @generated
	 */
	boolean isBreakEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isBreakEnabled <em>Break Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break Enabled</em>' attribute.
	 * @see #isBreakEnabled()
	 * @generated
	 */
	void setBreakEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Slice When Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slice When Complete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice When Complete</em>' attribute.
	 * @see #setSliceWhenComplete(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_SliceWhenComplete()
	 * @model required="true"
	 * @generated
	 */
	boolean isSliceWhenComplete();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isSliceWhenComplete <em>Slice When Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice When Complete</em>' attribute.
	 * @see #isSliceWhenComplete()
	 * @generated
	 */
	void setSliceWhenComplete(boolean value);

	/**
	 * Returns the value of the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heuristic Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heuristic Enabled</em>' attribute.
	 * @see #setHeuristicEnabled(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_HeuristicEnabled()
	 * @model required="true"
	 * @generated
	 */
	boolean isHeuristicEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#isHeuristicEnabled <em>Heuristic Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heuristic Enabled</em>' attribute.
	 * @see #isHeuristicEnabled()
	 * @generated
	 */
	void setHeuristicEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind
	 * @see #setScope(CoverageScopeKind)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_Scope()
	 * @model
	 * @generated
	 */
	CoverageScopeKind getScope();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind
	 * @see #getScope()
	 * @generated
	 */
	void setScope(CoverageScopeKind value);

	/**
	 * Returns the value of the '<em><b>Heuristic Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heuristic Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heuristic Config</em>' containment reference.
	 * @see #setHeuristicConfig(CoverageHeuristic)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getCoverageWorker_HeuristicConfig()
	 * @model containment="true"
	 * @generated
	 */
	CoverageHeuristic getHeuristicConfig();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker#getHeuristicConfig <em>Heuristic Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heuristic Config</em>' containment reference.
	 * @see #getHeuristicConfig()
	 * @generated
	 */
	void setHeuristicConfig(CoverageHeuristic value);

} // CoverageWorker
