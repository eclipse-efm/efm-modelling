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
import org.eclipse.efm.execution.core.workflow.common.RedundancyComparerOperation;
import org.eclipse.efm.execution.core.workflow.common.RedundancyDetection;
import org.eclipse.efm.execution.core.workflow.common.RedundancyPathScope;
import org.eclipse.efm.execution.core.workflow.common.SolverKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Redundancy Detection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#isEnabledDetetction <em>Enabled Detetction</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#getPathScope <em>Path Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#getComparerOperation <em>Comparer Operation</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#getSolverChoice <em>Solver Choice</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#getDataScope <em>Data Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#isEnabledTrivialLoopDetetction <em>Enabled Trivial Loop Detetction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RedundancyDetectionImpl extends MinimalEObjectImpl.Container implements RedundancyDetection {
	/**
	 * The default value of the '{@link #isEnabledDetetction() <em>Enabled Detetction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledDetetction()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_DETETCTION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabledDetetction() <em>Enabled Detetction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledDetetction()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledDetetction = ENABLED_DETETCTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathScope() <em>Path Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathScope()
	 * @generated
	 * @ordered
	 */
	protected static final RedundancyPathScope PATH_SCOPE_EDEFAULT = RedundancyPathScope.CURRENT;

	/**
	 * The cached value of the '{@link #getPathScope() <em>Path Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathScope()
	 * @generated
	 * @ordered
	 */
	protected RedundancyPathScope pathScope = PATH_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getComparerOperation() <em>Comparer Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparerOperation()
	 * @generated
	 * @ordered
	 */
	protected static final RedundancyComparerOperation COMPARER_OPERATION_EDEFAULT = RedundancyComparerOperation.INCLUSION;

	/**
	 * The cached value of the '{@link #getComparerOperation() <em>Comparer Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparerOperation()
	 * @generated
	 * @ordered
	 */
	protected RedundancyComparerOperation comparerOperation = COMPARER_OPERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSolverChoice() <em>Solver Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolverChoice()
	 * @generated
	 * @ordered
	 */
	protected static final SolverKind SOLVER_CHOICE_EDEFAULT = SolverKind.OMEGA;

	/**
	 * The cached value of the '{@link #getSolverChoice() <em>Solver Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolverChoice()
	 * @generated
	 * @ordered
	 */
	protected SolverKind solverChoice = SOLVER_CHOICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataScope() <em>Data Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataScope()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_SCOPE_EDEFAULT = "ALL";

	/**
	 * The cached value of the '{@link #getDataScope() <em>Data Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataScope()
	 * @generated
	 * @ordered
	 */
	protected String dataScope = DATA_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledTrivialLoopDetetction() <em>Enabled Trivial Loop Detetction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledTrivialLoopDetetction()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_TRIVIAL_LOOP_DETETCTION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabledTrivialLoopDetetction() <em>Enabled Trivial Loop Detetction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledTrivialLoopDetetction()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledTrivialLoopDetetction = ENABLED_TRIVIAL_LOOP_DETETCTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RedundancyDetectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.REDUNDANCY_DETECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledDetetction() {
		return enabledDetetction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledDetetction(boolean newEnabledDetetction) {
		boolean oldEnabledDetetction = enabledDetetction;
		enabledDetetction = newEnabledDetetction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__ENABLED_DETETCTION, oldEnabledDetetction, enabledDetetction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyPathScope getPathScope() {
		return pathScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathScope(RedundancyPathScope newPathScope) {
		RedundancyPathScope oldPathScope = pathScope;
		pathScope = newPathScope == null ? PATH_SCOPE_EDEFAULT : newPathScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE, oldPathScope, pathScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyComparerOperation getComparerOperation() {
		return comparerOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComparerOperation(RedundancyComparerOperation newComparerOperation) {
		RedundancyComparerOperation oldComparerOperation = comparerOperation;
		comparerOperation = newComparerOperation == null ? COMPARER_OPERATION_EDEFAULT : newComparerOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__COMPARER_OPERATION, oldComparerOperation, comparerOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverKind getSolverChoice() {
		return solverChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolverChoice(SolverKind newSolverChoice) {
		SolverKind oldSolverChoice = solverChoice;
		solverChoice = newSolverChoice == null ? SOLVER_CHOICE_EDEFAULT : newSolverChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__SOLVER_CHOICE, oldSolverChoice, solverChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataScope() {
		return dataScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataScope(String newDataScope) {
		String oldDataScope = dataScope;
		dataScope = newDataScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE, oldDataScope, dataScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledTrivialLoopDetetction() {
		return enabledTrivialLoopDetetction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledTrivialLoopDetetction(boolean newEnabledTrivialLoopDetetction) {
		boolean oldEnabledTrivialLoopDetetction = enabledTrivialLoopDetetction;
		enabledTrivialLoopDetetction = newEnabledTrivialLoopDetetction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__ENABLED_TRIVIAL_LOOP_DETETCTION, oldEnabledTrivialLoopDetetction, enabledTrivialLoopDetetction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.REDUNDANCY_DETECTION__ENABLED_DETETCTION:
				return isEnabledDetetction();
			case CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE:
				return getPathScope();
			case CommonPackage.REDUNDANCY_DETECTION__COMPARER_OPERATION:
				return getComparerOperation();
			case CommonPackage.REDUNDANCY_DETECTION__SOLVER_CHOICE:
				return getSolverChoice();
			case CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE:
				return getDataScope();
			case CommonPackage.REDUNDANCY_DETECTION__ENABLED_TRIVIAL_LOOP_DETETCTION:
				return isEnabledTrivialLoopDetetction();
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
			case CommonPackage.REDUNDANCY_DETECTION__ENABLED_DETETCTION:
				setEnabledDetetction((Boolean)newValue);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE:
				setPathScope((RedundancyPathScope)newValue);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__COMPARER_OPERATION:
				setComparerOperation((RedundancyComparerOperation)newValue);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__SOLVER_CHOICE:
				setSolverChoice((SolverKind)newValue);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE:
				setDataScope((String)newValue);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__ENABLED_TRIVIAL_LOOP_DETETCTION:
				setEnabledTrivialLoopDetetction((Boolean)newValue);
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
			case CommonPackage.REDUNDANCY_DETECTION__ENABLED_DETETCTION:
				setEnabledDetetction(ENABLED_DETETCTION_EDEFAULT);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE:
				setPathScope(PATH_SCOPE_EDEFAULT);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__COMPARER_OPERATION:
				setComparerOperation(COMPARER_OPERATION_EDEFAULT);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__SOLVER_CHOICE:
				setSolverChoice(SOLVER_CHOICE_EDEFAULT);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE:
				setDataScope(DATA_SCOPE_EDEFAULT);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__ENABLED_TRIVIAL_LOOP_DETETCTION:
				setEnabledTrivialLoopDetetction(ENABLED_TRIVIAL_LOOP_DETETCTION_EDEFAULT);
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
			case CommonPackage.REDUNDANCY_DETECTION__ENABLED_DETETCTION:
				return enabledDetetction != ENABLED_DETETCTION_EDEFAULT;
			case CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE:
				return pathScope != PATH_SCOPE_EDEFAULT;
			case CommonPackage.REDUNDANCY_DETECTION__COMPARER_OPERATION:
				return comparerOperation != COMPARER_OPERATION_EDEFAULT;
			case CommonPackage.REDUNDANCY_DETECTION__SOLVER_CHOICE:
				return solverChoice != SOLVER_CHOICE_EDEFAULT;
			case CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE:
				return DATA_SCOPE_EDEFAULT == null ? dataScope != null : !DATA_SCOPE_EDEFAULT.equals(dataScope);
			case CommonPackage.REDUNDANCY_DETECTION__ENABLED_TRIVIAL_LOOP_DETETCTION:
				return enabledTrivialLoopDetetction != ENABLED_TRIVIAL_LOOP_DETETCTION_EDEFAULT;
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
		result.append(" (enabledDetetction: ");
		result.append(enabledDetetction);
		result.append(", pathScope: ");
		result.append(pathScope);
		result.append(", comparerOperation: ");
		result.append(comparerOperation);
		result.append(", solverChoice: ");
		result.append(solverChoice);
		result.append(", dataScope: ");
		result.append(dataScope);
		result.append(", enabledTrivialLoopDetetction: ");
		result.append(enabledTrivialLoopDetetction);
		result.append(')');
		return result.toString();
	}

} //RedundancyDetectionImpl
