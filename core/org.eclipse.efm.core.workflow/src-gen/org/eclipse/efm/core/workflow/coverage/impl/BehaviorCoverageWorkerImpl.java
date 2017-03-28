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
package org.eclipse.efm.core.workflow.coverage.impl;

import org.eclipse.efm.core.workflow.common.CheckingScopeKind;
import org.eclipse.efm.core.workflow.common.TraceSpecification;

import org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker;
import org.eclipse.efm.core.workflow.coverage.CoveragePackage;

import org.eclipse.efm.core.workflow.impl.CoverageWorkerImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Coverage Worker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#getCheckingScope <em>Checking Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#isOrderedTrace <em>Ordered Trace</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#isHitConsecutive <em>Hit Consecutive</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#isHitFolding <em>Hit Folding</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#isHitMax <em>Hit Max</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#isHitLucky <em>Hit Lucky</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#getJumpHeight <em>Jump Height</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#getJumpTrialsLimit <em>Jump Trials Limit</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#getHitCount <em>Hit Count</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#getJumpCount <em>Jump Count</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#isJumpSlice <em>Jump Slice</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl#getBehavior <em>Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorCoverageWorkerImpl extends CoverageWorkerImpl implements BehaviorCoverageWorker {
	/**
	 * The default value of the '{@link #getCheckingScope() <em>Checking Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckingScope()
	 * @generated
	 * @ordered
	 */
	protected static final CheckingScopeKind CHECKING_SCOPE_EDEFAULT = CheckingScopeKind.GLOBALLY;

	/**
	 * The cached value of the '{@link #getCheckingScope() <em>Checking Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckingScope()
	 * @generated
	 * @ordered
	 */
	protected CheckingScopeKind checkingScope = CHECKING_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isOrderedTrace() <em>Ordered Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrderedTrace()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ORDERED_TRACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOrderedTrace() <em>Ordered Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrderedTrace()
	 * @generated
	 * @ordered
	 */
	protected boolean orderedTrace = ORDERED_TRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHitConsecutive() <em>Hit Consecutive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitConsecutive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIT_CONSECUTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHitConsecutive() <em>Hit Consecutive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitConsecutive()
	 * @generated
	 * @ordered
	 */
	protected boolean hitConsecutive = HIT_CONSECUTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHitFolding() <em>Hit Folding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitFolding()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIT_FOLDING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHitFolding() <em>Hit Folding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitFolding()
	 * @generated
	 * @ordered
	 */
	protected boolean hitFolding = HIT_FOLDING_EDEFAULT;

	/**
	 * The default value of the '{@link #isHitMax() <em>Hit Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitMax()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIT_MAX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHitMax() <em>Hit Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitMax()
	 * @generated
	 * @ordered
	 */
	protected boolean hitMax = HIT_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #isHitLucky() <em>Hit Lucky</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitLucky()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIT_LUCKY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHitLucky() <em>Hit Lucky</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHitLucky()
	 * @generated
	 * @ordered
	 */
	protected boolean hitLucky = HIT_LUCKY_EDEFAULT;

	/**
	 * The default value of the '{@link #getJumpHeight() <em>Jump Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJumpHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int JUMP_HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getJumpHeight() <em>Jump Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJumpHeight()
	 * @generated
	 * @ordered
	 */
	protected int jumpHeight = JUMP_HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getJumpTrialsLimit() <em>Jump Trials Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJumpTrialsLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int JUMP_TRIALS_LIMIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getJumpTrialsLimit() <em>Jump Trials Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJumpTrialsLimit()
	 * @generated
	 * @ordered
	 */
	protected int jumpTrialsLimit = JUMP_TRIALS_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getHitCount() <em>Hit Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitCount()
	 * @generated
	 * @ordered
	 */
	protected static final int HIT_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHitCount() <em>Hit Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitCount()
	 * @generated
	 * @ordered
	 */
	protected int hitCount = HIT_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getJumpCount() <em>Jump Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJumpCount()
	 * @generated
	 * @ordered
	 */
	protected static final int JUMP_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getJumpCount() <em>Jump Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJumpCount()
	 * @generated
	 * @ordered
	 */
	protected int jumpCount = JUMP_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isJumpSlice() <em>Jump Slice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isJumpSlice()
	 * @generated
	 * @ordered
	 */
	protected static final boolean JUMP_SLICE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isJumpSlice() <em>Jump Slice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isJumpSlice()
	 * @generated
	 * @ordered
	 */
	protected boolean jumpSlice = JUMP_SLICE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected TraceSpecification behavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorCoverageWorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CoveragePackage.Literals.BEHAVIOR_COVERAGE_WORKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckingScopeKind getCheckingScope() {
		return checkingScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckingScope(CheckingScopeKind newCheckingScope) {
		CheckingScopeKind oldCheckingScope = checkingScope;
		checkingScope = newCheckingScope == null ? CHECKING_SCOPE_EDEFAULT : newCheckingScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__CHECKING_SCOPE, oldCheckingScope, checkingScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrderedTrace() {
		return orderedTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderedTrace(boolean newOrderedTrace) {
		boolean oldOrderedTrace = orderedTrace;
		orderedTrace = newOrderedTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__ORDERED_TRACE, oldOrderedTrace, orderedTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHitConsecutive() {
		return hitConsecutive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHitConsecutive(boolean newHitConsecutive) {
		boolean oldHitConsecutive = hitConsecutive;
		hitConsecutive = newHitConsecutive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_CONSECUTIVE, oldHitConsecutive, hitConsecutive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHitFolding() {
		return hitFolding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHitFolding(boolean newHitFolding) {
		boolean oldHitFolding = hitFolding;
		hitFolding = newHitFolding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_FOLDING, oldHitFolding, hitFolding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHitMax() {
		return hitMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHitMax(boolean newHitMax) {
		boolean oldHitMax = hitMax;
		hitMax = newHitMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_MAX, oldHitMax, hitMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHitLucky() {
		return hitLucky;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHitLucky(boolean newHitLucky) {
		boolean oldHitLucky = hitLucky;
		hitLucky = newHitLucky;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_LUCKY, oldHitLucky, hitLucky));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getJumpHeight() {
		return jumpHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJumpHeight(int newJumpHeight) {
		int oldJumpHeight = jumpHeight;
		jumpHeight = newJumpHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_HEIGHT, oldJumpHeight, jumpHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getJumpTrialsLimit() {
		return jumpTrialsLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJumpTrialsLimit(int newJumpTrialsLimit) {
		int oldJumpTrialsLimit = jumpTrialsLimit;
		jumpTrialsLimit = newJumpTrialsLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_TRIALS_LIMIT, oldJumpTrialsLimit, jumpTrialsLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHitCount() {
		return hitCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHitCount(int newHitCount) {
		int oldHitCount = hitCount;
		hitCount = newHitCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_COUNT, oldHitCount, hitCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getJumpCount() {
		return jumpCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJumpCount(int newJumpCount) {
		int oldJumpCount = jumpCount;
		jumpCount = newJumpCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_COUNT, oldJumpCount, jumpCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isJumpSlice() {
		return jumpSlice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJumpSlice(boolean newJumpSlice) {
		boolean oldJumpSlice = jumpSlice;
		jumpSlice = newJumpSlice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_SLICE, oldJumpSlice, jumpSlice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSpecification getBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehavior(TraceSpecification newBehavior, NotificationChain msgs) {
		TraceSpecification oldBehavior = behavior;
		behavior = newBehavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR, oldBehavior, newBehavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(TraceSpecification newBehavior) {
		if (newBehavior != behavior) {
			NotificationChain msgs = null;
			if (behavior != null)
				msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR, null, msgs);
			if (newBehavior != null)
				msgs = ((InternalEObject)newBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR, null, msgs);
			msgs = basicSetBehavior(newBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR, newBehavior, newBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR:
				return basicSetBehavior(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__CHECKING_SCOPE:
				return getCheckingScope();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__ORDERED_TRACE:
				return isOrderedTrace();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_CONSECUTIVE:
				return isHitConsecutive();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_FOLDING:
				return isHitFolding();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_MAX:
				return isHitMax();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_LUCKY:
				return isHitLucky();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_HEIGHT:
				return getJumpHeight();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_TRIALS_LIMIT:
				return getJumpTrialsLimit();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_COUNT:
				return getHitCount();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_COUNT:
				return getJumpCount();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_SLICE:
				return isJumpSlice();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR:
				return getBehavior();
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
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__CHECKING_SCOPE:
				setCheckingScope((CheckingScopeKind)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__ORDERED_TRACE:
				setOrderedTrace((Boolean)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_CONSECUTIVE:
				setHitConsecutive((Boolean)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_FOLDING:
				setHitFolding((Boolean)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_MAX:
				setHitMax((Boolean)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_LUCKY:
				setHitLucky((Boolean)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_HEIGHT:
				setJumpHeight((Integer)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_TRIALS_LIMIT:
				setJumpTrialsLimit((Integer)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_COUNT:
				setHitCount((Integer)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_COUNT:
				setJumpCount((Integer)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_SLICE:
				setJumpSlice((Boolean)newValue);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR:
				setBehavior((TraceSpecification)newValue);
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
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__CHECKING_SCOPE:
				setCheckingScope(CHECKING_SCOPE_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__ORDERED_TRACE:
				setOrderedTrace(ORDERED_TRACE_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_CONSECUTIVE:
				setHitConsecutive(HIT_CONSECUTIVE_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_FOLDING:
				setHitFolding(HIT_FOLDING_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_MAX:
				setHitMax(HIT_MAX_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_LUCKY:
				setHitLucky(HIT_LUCKY_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_HEIGHT:
				setJumpHeight(JUMP_HEIGHT_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_TRIALS_LIMIT:
				setJumpTrialsLimit(JUMP_TRIALS_LIMIT_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_COUNT:
				setHitCount(HIT_COUNT_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_COUNT:
				setJumpCount(JUMP_COUNT_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_SLICE:
				setJumpSlice(JUMP_SLICE_EDEFAULT);
				return;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR:
				setBehavior((TraceSpecification)null);
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
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__CHECKING_SCOPE:
				return checkingScope != CHECKING_SCOPE_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__ORDERED_TRACE:
				return orderedTrace != ORDERED_TRACE_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_CONSECUTIVE:
				return hitConsecutive != HIT_CONSECUTIVE_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_FOLDING:
				return hitFolding != HIT_FOLDING_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_MAX:
				return hitMax != HIT_MAX_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_LUCKY:
				return hitLucky != HIT_LUCKY_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_HEIGHT:
				return jumpHeight != JUMP_HEIGHT_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_TRIALS_LIMIT:
				return jumpTrialsLimit != JUMP_TRIALS_LIMIT_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__HIT_COUNT:
				return hitCount != HIT_COUNT_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_COUNT:
				return jumpCount != JUMP_COUNT_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__JUMP_SLICE:
				return jumpSlice != JUMP_SLICE_EDEFAULT;
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER__BEHAVIOR:
				return behavior != null;
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
		result.append(" (checkingScope: ");
		result.append(checkingScope);
		result.append(", orderedTrace: ");
		result.append(orderedTrace);
		result.append(", hitConsecutive: ");
		result.append(hitConsecutive);
		result.append(", hitFolding: ");
		result.append(hitFolding);
		result.append(", hitMax: ");
		result.append(hitMax);
		result.append(", hitLucky: ");
		result.append(hitLucky);
		result.append(", jumpHeight: ");
		result.append(jumpHeight);
		result.append(", jumpTrialsLimit: ");
		result.append(jumpTrialsLimit);
		result.append(", hitCount: ");
		result.append(hitCount);
		result.append(", jumpCount: ");
		result.append(jumpCount);
		result.append(", jumpSlice: ");
		result.append(jumpSlice);
		result.append(')');
		return result.toString();
	}

} //BehaviorCoverageWorkerImpl
