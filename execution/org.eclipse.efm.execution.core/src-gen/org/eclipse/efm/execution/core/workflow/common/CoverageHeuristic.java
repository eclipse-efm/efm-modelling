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
 * A representation of the model object '<em><b>Coverage Heuristic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHeuristicTrials <em>Heuristic Trials</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getObjectiveRateGoal <em>Objective Rate Goal</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getObjectiveRestGoal <em>Objective Rest Goal</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHeuristicStart <em>Heuristic Start</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceCount <em>Directive Trace Count</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceSize <em>Directive Trace Size</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceHeuristic <em>Directive Trace Heuristic</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getLookaheadDepth <em>Lookahead Depth</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getLookaheadWidth <em>Lookahead Width</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitStronglyRandomEnabled <em>Hit Strongly Random Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitStronglyCount <em>Hit Strongly Count</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitWeaklyRandomEnabled <em>Hit Weakly Random Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitWeaklyCount <em>Hit Weakly Count</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitOtherRandomEnabled <em>Hit Other Random Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitOtherCount <em>Hit Other Count</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic()
 * @model
 * @generated
 */
public interface CoverageHeuristic extends EObject {
	/**
	 * Returns the value of the '<em><b>Heuristic Trials</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heuristic Trials</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heuristic Trials</em>' attribute.
	 * @see #setHeuristicTrials(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_HeuristicTrials()
	 * @model
	 * @generated
	 */
	int getHeuristicTrials();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHeuristicTrials <em>Heuristic Trials</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heuristic Trials</em>' attribute.
	 * @see #getHeuristicTrials()
	 * @generated
	 */
	void setHeuristicTrials(int value);

	/**
	 * Returns the value of the '<em><b>Objective Rate Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objective Rate Goal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective Rate Goal</em>' attribute.
	 * @see #setObjectiveRateGoal(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_ObjectiveRateGoal()
	 * @model
	 * @generated
	 */
	int getObjectiveRateGoal();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getObjectiveRateGoal <em>Objective Rate Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objective Rate Goal</em>' attribute.
	 * @see #getObjectiveRateGoal()
	 * @generated
	 */
	void setObjectiveRateGoal(int value);

	/**
	 * Returns the value of the '<em><b>Objective Rest Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objective Rest Goal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective Rest Goal</em>' attribute.
	 * @see #setObjectiveRestGoal(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_ObjectiveRestGoal()
	 * @model
	 * @generated
	 */
	int getObjectiveRestGoal();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getObjectiveRestGoal <em>Objective Rest Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objective Rest Goal</em>' attribute.
	 * @see #getObjectiveRestGoal()
	 * @generated
	 */
	void setObjectiveRestGoal(int value);

	/**
	 * Returns the value of the '<em><b>Heuristic Start</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heuristic Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heuristic Start</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind
	 * @see #setHeuristicStart(HeuristicClassKind)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_HeuristicStart()
	 * @model
	 * @generated
	 */
	HeuristicClassKind getHeuristicStart();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHeuristicStart <em>Heuristic Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heuristic Start</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind
	 * @see #getHeuristicStart()
	 * @generated
	 */
	void setHeuristicStart(HeuristicClassKind value);

	/**
	 * Returns the value of the '<em><b>Directive Trace Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directive Trace Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directive Trace Count</em>' attribute.
	 * @see #setDirectiveTraceCount(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_DirectiveTraceCount()
	 * @model
	 * @generated
	 */
	int getDirectiveTraceCount();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceCount <em>Directive Trace Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directive Trace Count</em>' attribute.
	 * @see #getDirectiveTraceCount()
	 * @generated
	 */
	void setDirectiveTraceCount(int value);

	/**
	 * Returns the value of the '<em><b>Directive Trace Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directive Trace Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directive Trace Size</em>' attribute.
	 * @see #setDirectiveTraceSize(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_DirectiveTraceSize()
	 * @model
	 * @generated
	 */
	int getDirectiveTraceSize();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceSize <em>Directive Trace Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directive Trace Size</em>' attribute.
	 * @see #getDirectiveTraceSize()
	 * @generated
	 */
	void setDirectiveTraceSize(int value);

	/**
	 * Returns the value of the '<em><b>Directive Trace Heuristic</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directive Trace Heuristic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directive Trace Heuristic</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind
	 * @see #setDirectiveTraceHeuristic(HeuristicClassKind)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_DirectiveTraceHeuristic()
	 * @model
	 * @generated
	 */
	HeuristicClassKind getDirectiveTraceHeuristic();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getDirectiveTraceHeuristic <em>Directive Trace Heuristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directive Trace Heuristic</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind
	 * @see #getDirectiveTraceHeuristic()
	 * @generated
	 */
	void setDirectiveTraceHeuristic(HeuristicClassKind value);

	/**
	 * Returns the value of the '<em><b>Lookahead Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lookahead Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lookahead Depth</em>' attribute.
	 * @see #setLookaheadDepth(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_LookaheadDepth()
	 * @model
	 * @generated
	 */
	int getLookaheadDepth();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getLookaheadDepth <em>Lookahead Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lookahead Depth</em>' attribute.
	 * @see #getLookaheadDepth()
	 * @generated
	 */
	void setLookaheadDepth(int value);

	/**
	 * Returns the value of the '<em><b>Lookahead Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lookahead Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lookahead Width</em>' attribute.
	 * @see #setLookaheadWidth(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_LookaheadWidth()
	 * @model
	 * @generated
	 */
	int getLookaheadWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getLookaheadWidth <em>Lookahead Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lookahead Width</em>' attribute.
	 * @see #getLookaheadWidth()
	 * @generated
	 */
	void setLookaheadWidth(int value);

	/**
	 * Returns the value of the '<em><b>Hit Strongly Random Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Strongly Random Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Strongly Random Enabled</em>' attribute.
	 * @see #setHitStronglyRandomEnabled(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_HitStronglyRandomEnabled()
	 * @model
	 * @generated
	 */
	boolean isHitStronglyRandomEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitStronglyRandomEnabled <em>Hit Strongly Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Strongly Random Enabled</em>' attribute.
	 * @see #isHitStronglyRandomEnabled()
	 * @generated
	 */
	void setHitStronglyRandomEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Hit Strongly Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Strongly Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Strongly Count</em>' attribute.
	 * @see #setHitStronglyCount(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_HitStronglyCount()
	 * @model
	 * @generated
	 */
	int getHitStronglyCount();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitStronglyCount <em>Hit Strongly Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Strongly Count</em>' attribute.
	 * @see #getHitStronglyCount()
	 * @generated
	 */
	void setHitStronglyCount(int value);

	/**
	 * Returns the value of the '<em><b>Hit Weakly Random Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Weakly Random Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Weakly Random Enabled</em>' attribute.
	 * @see #setHitWeaklyRandomEnabled(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_HitWeaklyRandomEnabled()
	 * @model
	 * @generated
	 */
	boolean isHitWeaklyRandomEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitWeaklyRandomEnabled <em>Hit Weakly Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Weakly Random Enabled</em>' attribute.
	 * @see #isHitWeaklyRandomEnabled()
	 * @generated
	 */
	void setHitWeaklyRandomEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Hit Weakly Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Weakly Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Weakly Count</em>' attribute.
	 * @see #setHitWeaklyCount(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_HitWeaklyCount()
	 * @model
	 * @generated
	 */
	int getHitWeaklyCount();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitWeaklyCount <em>Hit Weakly Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Weakly Count</em>' attribute.
	 * @see #getHitWeaklyCount()
	 * @generated
	 */
	void setHitWeaklyCount(int value);

	/**
	 * Returns the value of the '<em><b>Hit Other Random Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Other Random Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Other Random Enabled</em>' attribute.
	 * @see #setHitOtherRandomEnabled(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_HitOtherRandomEnabled()
	 * @model
	 * @generated
	 */
	boolean isHitOtherRandomEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#isHitOtherRandomEnabled <em>Hit Other Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Other Random Enabled</em>' attribute.
	 * @see #isHitOtherRandomEnabled()
	 * @generated
	 */
	void setHitOtherRandomEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Hit Other Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Other Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Other Count</em>' attribute.
	 * @see #setHitOtherCount(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getCoverageHeuristic_HitOtherCount()
	 * @model
	 * @generated
	 */
	int getHitOtherCount();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic#getHitOtherCount <em>Hit Other Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Other Count</em>' attribute.
	 * @see #getHitOtherCount()
	 * @generated
	 */
	void setHitOtherCount(int value);

} // CoverageHeuristic
