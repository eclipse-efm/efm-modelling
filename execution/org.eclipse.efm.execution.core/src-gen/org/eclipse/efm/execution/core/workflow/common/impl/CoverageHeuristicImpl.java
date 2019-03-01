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
import org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic;
import org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Coverage Heuristic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getHeuristicTrials <em>Heuristic Trials</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getObjectiveRateGoal <em>Objective Rate Goal</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getObjectiveRestGoal <em>Objective Rest Goal</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getHeuristicStart <em>Heuristic Start</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getDirectiveTraceCount <em>Directive Trace Count</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getDirectiveTraceSize <em>Directive Trace Size</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getDirectiveTraceHeuristic <em>Directive Trace Heuristic</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getLookaheadDepth <em>Lookahead Depth</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getLookaheadWidth <em>Lookahead Width</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#isHitStronglyRandomEnabled <em>Hit Strongly Random Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getHitStronglyCount <em>Hit Strongly Count</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#isHitWeaklyRandomEnabled <em>Hit Weakly Random Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getHitWeaklyCount <em>Hit Weakly Count</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#isHitOtherRandomEnabled <em>Hit Other Random Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.CoverageHeuristicImpl#getHitOtherCount <em>Hit Other Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CoverageHeuristicImpl extends MinimalEObjectImpl.Container implements CoverageHeuristic {
	/**
	 * The default value of the '{@link #getHeuristicTrials() <em>Heuristic Trials</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeuristicTrials()
	 * @generated
	 * @ordered
	 */
	protected static final int HEURISTIC_TRIALS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeuristicTrials() <em>Heuristic Trials</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeuristicTrials()
	 * @generated
	 * @ordered
	 */
	protected int heuristicTrials = HEURISTIC_TRIALS_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjectiveRateGoal() <em>Objective Rate Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectiveRateGoal()
	 * @generated
	 * @ordered
	 */
	protected static final int OBJECTIVE_RATE_GOAL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getObjectiveRateGoal() <em>Objective Rate Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectiveRateGoal()
	 * @generated
	 * @ordered
	 */
	protected int objectiveRateGoal = OBJECTIVE_RATE_GOAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjectiveRestGoal() <em>Objective Rest Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectiveRestGoal()
	 * @generated
	 * @ordered
	 */
	protected static final int OBJECTIVE_REST_GOAL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getObjectiveRestGoal() <em>Objective Rest Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectiveRestGoal()
	 * @generated
	 * @ordered
	 */
	protected int objectiveRestGoal = OBJECTIVE_REST_GOAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeuristicStart() <em>Heuristic Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeuristicStart()
	 * @generated
	 * @ordered
	 */
	protected static final HeuristicClassKind HEURISTIC_START_EDEFAULT = HeuristicClassKind.BASIC;

	/**
	 * The cached value of the '{@link #getHeuristicStart() <em>Heuristic Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeuristicStart()
	 * @generated
	 * @ordered
	 */
	protected HeuristicClassKind heuristicStart = HEURISTIC_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirectiveTraceCount() <em>Directive Trace Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectiveTraceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int DIRECTIVE_TRACE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDirectiveTraceCount() <em>Directive Trace Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectiveTraceCount()
	 * @generated
	 * @ordered
	 */
	protected int directiveTraceCount = DIRECTIVE_TRACE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirectiveTraceSize() <em>Directive Trace Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectiveTraceSize()
	 * @generated
	 * @ordered
	 */
	protected static final int DIRECTIVE_TRACE_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDirectiveTraceSize() <em>Directive Trace Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectiveTraceSize()
	 * @generated
	 * @ordered
	 */
	protected int directiveTraceSize = DIRECTIVE_TRACE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirectiveTraceHeuristic() <em>Directive Trace Heuristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectiveTraceHeuristic()
	 * @generated
	 * @ordered
	 */
	protected static final HeuristicClassKind DIRECTIVE_TRACE_HEURISTIC_EDEFAULT = HeuristicClassKind.BASIC;

	/**
	 * The cached value of the '{@link #getDirectiveTraceHeuristic() <em>Directive Trace Heuristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectiveTraceHeuristic()
	 * @generated
	 * @ordered
	 */
	protected HeuristicClassKind directiveTraceHeuristic = DIRECTIVE_TRACE_HEURISTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getLookaheadDepth() <em>Lookahead Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookaheadDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int LOOKAHEAD_DEPTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLookaheadDepth() <em>Lookahead Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookaheadDepth()
	 * @generated
	 * @ordered
	 */
	protected int lookaheadDepth = LOOKAHEAD_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLookaheadWidth() <em>Lookahead Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookaheadWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int LOOKAHEAD_WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLookaheadWidth() <em>Lookahead Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookaheadWidth()
	 * @generated
	 * @ordered
	 */
	protected int lookaheadWidth = LOOKAHEAD_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isHitStronglyRandomEnabled() <em>Hit Strongly Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitStronglyRandomEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIT_STRONGLY_RANDOM_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHitStronglyRandomEnabled() <em>Hit Strongly Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitStronglyRandomEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean hitStronglyRandomEnabled = HIT_STRONGLY_RANDOM_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getHitStronglyCount() <em>Hit Strongly Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitStronglyCount()
	 * @generated
	 * @ordered
	 */
	protected static final int HIT_STRONGLY_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHitStronglyCount() <em>Hit Strongly Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitStronglyCount()
	 * @generated
	 * @ordered
	 */
	protected int hitStronglyCount = HIT_STRONGLY_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isHitWeaklyRandomEnabled() <em>Hit Weakly Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitWeaklyRandomEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIT_WEAKLY_RANDOM_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHitWeaklyRandomEnabled() <em>Hit Weakly Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitWeaklyRandomEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean hitWeaklyRandomEnabled = HIT_WEAKLY_RANDOM_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getHitWeaklyCount() <em>Hit Weakly Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitWeaklyCount()
	 * @generated
	 * @ordered
	 */
	protected static final int HIT_WEAKLY_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHitWeaklyCount() <em>Hit Weakly Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitWeaklyCount()
	 * @generated
	 * @ordered
	 */
	protected int hitWeaklyCount = HIT_WEAKLY_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isHitOtherRandomEnabled() <em>Hit Other Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitOtherRandomEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIT_OTHER_RANDOM_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHitOtherRandomEnabled() <em>Hit Other Random Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitOtherRandomEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean hitOtherRandomEnabled = HIT_OTHER_RANDOM_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getHitOtherCount() <em>Hit Other Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitOtherCount()
	 * @generated
	 * @ordered
	 */
	protected static final int HIT_OTHER_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHitOtherCount() <em>Hit Other Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitOtherCount()
	 * @generated
	 * @ordered
	 */
	protected int hitOtherCount = HIT_OTHER_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoverageHeuristicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.COVERAGE_HEURISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHeuristicTrials() {
		return heuristicTrials;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeuristicTrials(int newHeuristicTrials) {
		int oldHeuristicTrials = heuristicTrials;
		heuristicTrials = newHeuristicTrials;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_TRIALS, oldHeuristicTrials, heuristicTrials));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getObjectiveRateGoal() {
		return objectiveRateGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectiveRateGoal(int newObjectiveRateGoal) {
		int oldObjectiveRateGoal = objectiveRateGoal;
		objectiveRateGoal = newObjectiveRateGoal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_RATE_GOAL, oldObjectiveRateGoal, objectiveRateGoal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getObjectiveRestGoal() {
		return objectiveRestGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectiveRestGoal(int newObjectiveRestGoal) {
		int oldObjectiveRestGoal = objectiveRestGoal;
		objectiveRestGoal = newObjectiveRestGoal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_REST_GOAL, oldObjectiveRestGoal, objectiveRestGoal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HeuristicClassKind getHeuristicStart() {
		return heuristicStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeuristicStart(HeuristicClassKind newHeuristicStart) {
		HeuristicClassKind oldHeuristicStart = heuristicStart;
		heuristicStart = newHeuristicStart == null ? HEURISTIC_START_EDEFAULT : newHeuristicStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_START, oldHeuristicStart, heuristicStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDirectiveTraceCount() {
		return directiveTraceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDirectiveTraceCount(int newDirectiveTraceCount) {
		int oldDirectiveTraceCount = directiveTraceCount;
		directiveTraceCount = newDirectiveTraceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_COUNT, oldDirectiveTraceCount, directiveTraceCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDirectiveTraceSize() {
		return directiveTraceSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDirectiveTraceSize(int newDirectiveTraceSize) {
		int oldDirectiveTraceSize = directiveTraceSize;
		directiveTraceSize = newDirectiveTraceSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_SIZE, oldDirectiveTraceSize, directiveTraceSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HeuristicClassKind getDirectiveTraceHeuristic() {
		return directiveTraceHeuristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDirectiveTraceHeuristic(HeuristicClassKind newDirectiveTraceHeuristic) {
		HeuristicClassKind oldDirectiveTraceHeuristic = directiveTraceHeuristic;
		directiveTraceHeuristic = newDirectiveTraceHeuristic == null ? DIRECTIVE_TRACE_HEURISTIC_EDEFAULT : newDirectiveTraceHeuristic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_HEURISTIC, oldDirectiveTraceHeuristic, directiveTraceHeuristic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getLookaheadDepth() {
		return lookaheadDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLookaheadDepth(int newLookaheadDepth) {
		int oldLookaheadDepth = lookaheadDepth;
		lookaheadDepth = newLookaheadDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_DEPTH, oldLookaheadDepth, lookaheadDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getLookaheadWidth() {
		return lookaheadWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLookaheadWidth(int newLookaheadWidth) {
		int oldLookaheadWidth = lookaheadWidth;
		lookaheadWidth = newLookaheadWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_WIDTH, oldLookaheadWidth, lookaheadWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHitStronglyRandomEnabled() {
		return hitStronglyRandomEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitStronglyRandomEnabled(boolean newHitStronglyRandomEnabled) {
		boolean oldHitStronglyRandomEnabled = hitStronglyRandomEnabled;
		hitStronglyRandomEnabled = newHitStronglyRandomEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_RANDOM_ENABLED, oldHitStronglyRandomEnabled, hitStronglyRandomEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHitStronglyCount() {
		return hitStronglyCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitStronglyCount(int newHitStronglyCount) {
		int oldHitStronglyCount = hitStronglyCount;
		hitStronglyCount = newHitStronglyCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_COUNT, oldHitStronglyCount, hitStronglyCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHitWeaklyRandomEnabled() {
		return hitWeaklyRandomEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitWeaklyRandomEnabled(boolean newHitWeaklyRandomEnabled) {
		boolean oldHitWeaklyRandomEnabled = hitWeaklyRandomEnabled;
		hitWeaklyRandomEnabled = newHitWeaklyRandomEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_RANDOM_ENABLED, oldHitWeaklyRandomEnabled, hitWeaklyRandomEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHitWeaklyCount() {
		return hitWeaklyCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitWeaklyCount(int newHitWeaklyCount) {
		int oldHitWeaklyCount = hitWeaklyCount;
		hitWeaklyCount = newHitWeaklyCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_COUNT, oldHitWeaklyCount, hitWeaklyCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHitOtherRandomEnabled() {
		return hitOtherRandomEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitOtherRandomEnabled(boolean newHitOtherRandomEnabled) {
		boolean oldHitOtherRandomEnabled = hitOtherRandomEnabled;
		hitOtherRandomEnabled = newHitOtherRandomEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_RANDOM_ENABLED, oldHitOtherRandomEnabled, hitOtherRandomEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHitOtherCount() {
		return hitOtherCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitOtherCount(int newHitOtherCount) {
		int oldHitOtherCount = hitOtherCount;
		hitOtherCount = newHitOtherCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_COUNT, oldHitOtherCount, hitOtherCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_TRIALS:
				return getHeuristicTrials();
			case CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_RATE_GOAL:
				return getObjectiveRateGoal();
			case CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_REST_GOAL:
				return getObjectiveRestGoal();
			case CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_START:
				return getHeuristicStart();
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_COUNT:
				return getDirectiveTraceCount();
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_SIZE:
				return getDirectiveTraceSize();
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_HEURISTIC:
				return getDirectiveTraceHeuristic();
			case CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_DEPTH:
				return getLookaheadDepth();
			case CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_WIDTH:
				return getLookaheadWidth();
			case CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_RANDOM_ENABLED:
				return isHitStronglyRandomEnabled();
			case CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_COUNT:
				return getHitStronglyCount();
			case CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_RANDOM_ENABLED:
				return isHitWeaklyRandomEnabled();
			case CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_COUNT:
				return getHitWeaklyCount();
			case CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_RANDOM_ENABLED:
				return isHitOtherRandomEnabled();
			case CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_COUNT:
				return getHitOtherCount();
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
			case CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_TRIALS:
				setHeuristicTrials((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_RATE_GOAL:
				setObjectiveRateGoal((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_REST_GOAL:
				setObjectiveRestGoal((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_START:
				setHeuristicStart((HeuristicClassKind)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_COUNT:
				setDirectiveTraceCount((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_SIZE:
				setDirectiveTraceSize((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_HEURISTIC:
				setDirectiveTraceHeuristic((HeuristicClassKind)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_DEPTH:
				setLookaheadDepth((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_WIDTH:
				setLookaheadWidth((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_RANDOM_ENABLED:
				setHitStronglyRandomEnabled((Boolean)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_COUNT:
				setHitStronglyCount((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_RANDOM_ENABLED:
				setHitWeaklyRandomEnabled((Boolean)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_COUNT:
				setHitWeaklyCount((Integer)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_RANDOM_ENABLED:
				setHitOtherRandomEnabled((Boolean)newValue);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_COUNT:
				setHitOtherCount((Integer)newValue);
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
			case CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_TRIALS:
				setHeuristicTrials(HEURISTIC_TRIALS_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_RATE_GOAL:
				setObjectiveRateGoal(OBJECTIVE_RATE_GOAL_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_REST_GOAL:
				setObjectiveRestGoal(OBJECTIVE_REST_GOAL_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_START:
				setHeuristicStart(HEURISTIC_START_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_COUNT:
				setDirectiveTraceCount(DIRECTIVE_TRACE_COUNT_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_SIZE:
				setDirectiveTraceSize(DIRECTIVE_TRACE_SIZE_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_HEURISTIC:
				setDirectiveTraceHeuristic(DIRECTIVE_TRACE_HEURISTIC_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_DEPTH:
				setLookaheadDepth(LOOKAHEAD_DEPTH_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_WIDTH:
				setLookaheadWidth(LOOKAHEAD_WIDTH_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_RANDOM_ENABLED:
				setHitStronglyRandomEnabled(HIT_STRONGLY_RANDOM_ENABLED_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_COUNT:
				setHitStronglyCount(HIT_STRONGLY_COUNT_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_RANDOM_ENABLED:
				setHitWeaklyRandomEnabled(HIT_WEAKLY_RANDOM_ENABLED_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_COUNT:
				setHitWeaklyCount(HIT_WEAKLY_COUNT_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_RANDOM_ENABLED:
				setHitOtherRandomEnabled(HIT_OTHER_RANDOM_ENABLED_EDEFAULT);
				return;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_COUNT:
				setHitOtherCount(HIT_OTHER_COUNT_EDEFAULT);
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
			case CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_TRIALS:
				return heuristicTrials != HEURISTIC_TRIALS_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_RATE_GOAL:
				return objectiveRateGoal != OBJECTIVE_RATE_GOAL_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__OBJECTIVE_REST_GOAL:
				return objectiveRestGoal != OBJECTIVE_REST_GOAL_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__HEURISTIC_START:
				return heuristicStart != HEURISTIC_START_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_COUNT:
				return directiveTraceCount != DIRECTIVE_TRACE_COUNT_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_SIZE:
				return directiveTraceSize != DIRECTIVE_TRACE_SIZE_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__DIRECTIVE_TRACE_HEURISTIC:
				return directiveTraceHeuristic != DIRECTIVE_TRACE_HEURISTIC_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_DEPTH:
				return lookaheadDepth != LOOKAHEAD_DEPTH_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__LOOKAHEAD_WIDTH:
				return lookaheadWidth != LOOKAHEAD_WIDTH_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_RANDOM_ENABLED:
				return hitStronglyRandomEnabled != HIT_STRONGLY_RANDOM_ENABLED_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_STRONGLY_COUNT:
				return hitStronglyCount != HIT_STRONGLY_COUNT_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_RANDOM_ENABLED:
				return hitWeaklyRandomEnabled != HIT_WEAKLY_RANDOM_ENABLED_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_WEAKLY_COUNT:
				return hitWeaklyCount != HIT_WEAKLY_COUNT_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_RANDOM_ENABLED:
				return hitOtherRandomEnabled != HIT_OTHER_RANDOM_ENABLED_EDEFAULT;
			case CommonPackage.COVERAGE_HEURISTIC__HIT_OTHER_COUNT:
				return hitOtherCount != HIT_OTHER_COUNT_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (heuristicTrials: ");
		result.append(heuristicTrials);
		result.append(", objectiveRateGoal: ");
		result.append(objectiveRateGoal);
		result.append(", objectiveRestGoal: ");
		result.append(objectiveRestGoal);
		result.append(", heuristicStart: ");
		result.append(heuristicStart);
		result.append(", directiveTraceCount: ");
		result.append(directiveTraceCount);
		result.append(", directiveTraceSize: ");
		result.append(directiveTraceSize);
		result.append(", directiveTraceHeuristic: ");
		result.append(directiveTraceHeuristic);
		result.append(", lookaheadDepth: ");
		result.append(lookaheadDepth);
		result.append(", lookaheadWidth: ");
		result.append(lookaheadWidth);
		result.append(", hitStronglyRandomEnabled: ");
		result.append(hitStronglyRandomEnabled);
		result.append(", hitStronglyCount: ");
		result.append(hitStronglyCount);
		result.append(", hitWeaklyRandomEnabled: ");
		result.append(hitWeaklyRandomEnabled);
		result.append(", hitWeaklyCount: ");
		result.append(hitWeaklyCount);
		result.append(", hitOtherRandomEnabled: ");
		result.append(hitOtherRandomEnabled);
		result.append(", hitOtherCount: ");
		result.append(hitOtherCount);
		result.append(')');
		return result.toString();
	}

} //CoverageHeuristicImpl
