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
package org.eclipse.efm.runconfiguration.workflow.impl;

import org.eclipse.efm.runconfiguration.workflow.CoverageWorker;
import org.eclipse.efm.runconfiguration.workflow.WorkflowPackage;
import org.eclipse.efm.runconfiguration.workflow.common.CoverageHeuristic;
import org.eclipse.efm.runconfiguration.workflow.common.CoverageScopeKind;
import org.eclipse.efm.runconfiguration.workflow.common.TraceSpecification;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Coverage Worker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#isNormalizationEnabled <em>Normalization Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#isMinimizationEnabled <em>Minimization Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#isStopWhenComplete <em>Stop When Complete</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#isBreakEnabled <em>Break Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#isSliceWhenComplete <em>Slice When Complete</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#isHeuristicEnabled <em>Heuristic Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.CoverageWorkerImpl#getHeuristicConfig <em>Heuristic Config</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CoverageWorkerImpl extends WorkerImpl implements CoverageWorker {
	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected TraceSpecification trace;

	/**
	 * The default value of the '{@link #isNormalizationEnabled() <em>Normalization Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNormalizationEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NORMALIZATION_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNormalizationEnabled() <em>Normalization Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNormalizationEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean normalizationEnabled = NORMALIZATION_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isMinimizationEnabled() <em>Minimization Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimizationEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MINIMIZATION_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMinimizationEnabled() <em>Minimization Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimizationEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean minimizationEnabled = MINIMIZATION_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isStopWhenComplete() <em>Stop When Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStopWhenComplete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STOP_WHEN_COMPLETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStopWhenComplete() <em>Stop When Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStopWhenComplete()
	 * @generated
	 * @ordered
	 */
	protected boolean stopWhenComplete = STOP_WHEN_COMPLETE_EDEFAULT;

	/**
	 * The default value of the '{@link #isBreakEnabled() <em>Break Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBreakEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BREAK_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBreakEnabled() <em>Break Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBreakEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean breakEnabled = BREAK_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSliceWhenComplete() <em>Slice When Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSliceWhenComplete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SLICE_WHEN_COMPLETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSliceWhenComplete() <em>Slice When Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSliceWhenComplete()
	 * @generated
	 * @ordered
	 */
	protected boolean sliceWhenComplete = SLICE_WHEN_COMPLETE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHeuristicEnabled() <em>Heuristic Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeuristicEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HEURISTIC_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHeuristicEnabled() <em>Heuristic Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeuristicEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean heuristicEnabled = HEURISTIC_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final CoverageScopeKind SCOPE_EDEFAULT = CoverageScopeKind.MODEL;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected CoverageScopeKind scope = SCOPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHeuristicConfig() <em>Heuristic Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeuristicConfig()
	 * @generated
	 * @ordered
	 */
	protected CoverageHeuristic heuristicConfig;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoverageWorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.COVERAGE_WORKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSpecification getTrace() {
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrace(TraceSpecification newTrace, NotificationChain msgs) {
		TraceSpecification oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__TRACE, oldTrace, newTrace);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(TraceSpecification newTrace) {
		if (newTrace != trace) {
			NotificationChain msgs = null;
			if (trace != null)
				msgs = ((InternalEObject)trace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.COVERAGE_WORKER__TRACE, null, msgs);
			if (newTrace != null)
				msgs = ((InternalEObject)newTrace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.COVERAGE_WORKER__TRACE, null, msgs);
			msgs = basicSetTrace(newTrace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__TRACE, newTrace, newTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNormalizationEnabled() {
		return normalizationEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalizationEnabled(boolean newNormalizationEnabled) {
		boolean oldNormalizationEnabled = normalizationEnabled;
		normalizationEnabled = newNormalizationEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED, oldNormalizationEnabled, normalizationEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMinimizationEnabled() {
		return minimizationEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimizationEnabled(boolean newMinimizationEnabled) {
		boolean oldMinimizationEnabled = minimizationEnabled;
		minimizationEnabled = newMinimizationEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED, oldMinimizationEnabled, minimizationEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStopWhenComplete() {
		return stopWhenComplete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopWhenComplete(boolean newStopWhenComplete) {
		boolean oldStopWhenComplete = stopWhenComplete;
		stopWhenComplete = newStopWhenComplete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE, oldStopWhenComplete, stopWhenComplete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBreakEnabled() {
		return breakEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakEnabled(boolean newBreakEnabled) {
		boolean oldBreakEnabled = breakEnabled;
		breakEnabled = newBreakEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED, oldBreakEnabled, breakEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSliceWhenComplete() {
		return sliceWhenComplete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSliceWhenComplete(boolean newSliceWhenComplete) {
		boolean oldSliceWhenComplete = sliceWhenComplete;
		sliceWhenComplete = newSliceWhenComplete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE, oldSliceWhenComplete, sliceWhenComplete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHeuristicEnabled() {
		return heuristicEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeuristicEnabled(boolean newHeuristicEnabled) {
		boolean oldHeuristicEnabled = heuristicEnabled;
		heuristicEnabled = newHeuristicEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED, oldHeuristicEnabled, heuristicEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageScopeKind getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(CoverageScopeKind newScope) {
		CoverageScopeKind oldScope = scope;
		scope = newScope == null ? SCOPE_EDEFAULT : newScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageHeuristic getHeuristicConfig() {
		return heuristicConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeuristicConfig(CoverageHeuristic newHeuristicConfig, NotificationChain msgs) {
		CoverageHeuristic oldHeuristicConfig = heuristicConfig;
		heuristicConfig = newHeuristicConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG, oldHeuristicConfig, newHeuristicConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeuristicConfig(CoverageHeuristic newHeuristicConfig) {
		if (newHeuristicConfig != heuristicConfig) {
			NotificationChain msgs = null;
			if (heuristicConfig != null)
				msgs = ((InternalEObject)heuristicConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG, null, msgs);
			if (newHeuristicConfig != null)
				msgs = ((InternalEObject)newHeuristicConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG, null, msgs);
			msgs = basicSetHeuristicConfig(newHeuristicConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG, newHeuristicConfig, newHeuristicConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.COVERAGE_WORKER__TRACE:
				return basicSetTrace(null, msgs);
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG:
				return basicSetHeuristicConfig(null, msgs);
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
			case WorkflowPackage.COVERAGE_WORKER__TRACE:
				return getTrace();
			case WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED:
				return isNormalizationEnabled();
			case WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED:
				return isMinimizationEnabled();
			case WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE:
				return isStopWhenComplete();
			case WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED:
				return isBreakEnabled();
			case WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE:
				return isSliceWhenComplete();
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED:
				return isHeuristicEnabled();
			case WorkflowPackage.COVERAGE_WORKER__SCOPE:
				return getScope();
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG:
				return getHeuristicConfig();
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
			case WorkflowPackage.COVERAGE_WORKER__TRACE:
				setTrace((TraceSpecification)newValue);
				return;
			case WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED:
				setNormalizationEnabled((Boolean)newValue);
				return;
			case WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED:
				setMinimizationEnabled((Boolean)newValue);
				return;
			case WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE:
				setStopWhenComplete((Boolean)newValue);
				return;
			case WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED:
				setBreakEnabled((Boolean)newValue);
				return;
			case WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE:
				setSliceWhenComplete((Boolean)newValue);
				return;
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED:
				setHeuristicEnabled((Boolean)newValue);
				return;
			case WorkflowPackage.COVERAGE_WORKER__SCOPE:
				setScope((CoverageScopeKind)newValue);
				return;
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG:
				setHeuristicConfig((CoverageHeuristic)newValue);
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
			case WorkflowPackage.COVERAGE_WORKER__TRACE:
				setTrace((TraceSpecification)null);
				return;
			case WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED:
				setNormalizationEnabled(NORMALIZATION_ENABLED_EDEFAULT);
				return;
			case WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED:
				setMinimizationEnabled(MINIMIZATION_ENABLED_EDEFAULT);
				return;
			case WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE:
				setStopWhenComplete(STOP_WHEN_COMPLETE_EDEFAULT);
				return;
			case WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED:
				setBreakEnabled(BREAK_ENABLED_EDEFAULT);
				return;
			case WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE:
				setSliceWhenComplete(SLICE_WHEN_COMPLETE_EDEFAULT);
				return;
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED:
				setHeuristicEnabled(HEURISTIC_ENABLED_EDEFAULT);
				return;
			case WorkflowPackage.COVERAGE_WORKER__SCOPE:
				setScope(SCOPE_EDEFAULT);
				return;
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG:
				setHeuristicConfig((CoverageHeuristic)null);
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
			case WorkflowPackage.COVERAGE_WORKER__TRACE:
				return trace != null;
			case WorkflowPackage.COVERAGE_WORKER__NORMALIZATION_ENABLED:
				return normalizationEnabled != NORMALIZATION_ENABLED_EDEFAULT;
			case WorkflowPackage.COVERAGE_WORKER__MINIMIZATION_ENABLED:
				return minimizationEnabled != MINIMIZATION_ENABLED_EDEFAULT;
			case WorkflowPackage.COVERAGE_WORKER__STOP_WHEN_COMPLETE:
				return stopWhenComplete != STOP_WHEN_COMPLETE_EDEFAULT;
			case WorkflowPackage.COVERAGE_WORKER__BREAK_ENABLED:
				return breakEnabled != BREAK_ENABLED_EDEFAULT;
			case WorkflowPackage.COVERAGE_WORKER__SLICE_WHEN_COMPLETE:
				return sliceWhenComplete != SLICE_WHEN_COMPLETE_EDEFAULT;
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_ENABLED:
				return heuristicEnabled != HEURISTIC_ENABLED_EDEFAULT;
			case WorkflowPackage.COVERAGE_WORKER__SCOPE:
				return scope != SCOPE_EDEFAULT;
			case WorkflowPackage.COVERAGE_WORKER__HEURISTIC_CONFIG:
				return heuristicConfig != null;
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
		result.append(" (normalizationEnabled: ");
		result.append(normalizationEnabled);
		result.append(", minimizationEnabled: ");
		result.append(minimizationEnabled);
		result.append(", stopWhenComplete: ");
		result.append(stopWhenComplete);
		result.append(", breakEnabled: ");
		result.append(breakEnabled);
		result.append(", sliceWhenComplete: ");
		result.append(sliceWhenComplete);
		result.append(", heuristicEnabled: ");
		result.append(heuristicEnabled);
		result.append(", scope: ");
		result.append(scope);
		result.append(')');
		return result.toString();
	}

} //CoverageWorkerImpl
