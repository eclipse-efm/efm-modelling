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
import org.eclipse.efm.execution.core.workflow.common.RedundancyDetection;

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
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#getComparer <em>Comparer</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#getSolver <em>Solver</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#getPathScope <em>Path Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.RedundancyDetectionImpl#getDataScope <em>Data Scope</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RedundancyDetectionImpl extends MinimalEObjectImpl.Container implements RedundancyDetection {
	/**
	 * The default value of the '{@link #getComparer() <em>Comparer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparer()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPARER_EDEFAULT = "INCLUSION";

	/**
	 * The cached value of the '{@link #getComparer() <em>Comparer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparer()
	 * @generated
	 * @ordered
	 */
	protected String comparer = COMPARER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSolver() <em>Solver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolver()
	 * @generated
	 * @ordered
	 */
	protected static final String SOLVER_EDEFAULT = "OMEGA";

	/**
	 * The cached value of the '{@link #getSolver() <em>Solver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolver()
	 * @generated
	 * @ordered
	 */
	protected String solver = SOLVER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathScope() <em>Path Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathScope()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_SCOPE_EDEFAULT = "CURRENT";

	/**
	 * The cached value of the '{@link #getPathScope() <em>Path Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathScope()
	 * @generated
	 * @ordered
	 */
	protected String pathScope = PATH_SCOPE_EDEFAULT;

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
	public String getComparer() {
		return comparer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComparer(String newComparer) {
		String oldComparer = comparer;
		comparer = newComparer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__COMPARER, oldComparer, comparer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolver() {
		return solver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolver(String newSolver) {
		String oldSolver = solver;
		solver = newSolver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__SOLVER, oldSolver, solver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathScope() {
		return pathScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathScope(String newPathScope) {
		String oldPathScope = pathScope;
		pathScope = newPathScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE, oldPathScope, pathScope));
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.REDUNDANCY_DETECTION__COMPARER:
				return getComparer();
			case CommonPackage.REDUNDANCY_DETECTION__SOLVER:
				return getSolver();
			case CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE:
				return getPathScope();
			case CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE:
				return getDataScope();
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
			case CommonPackage.REDUNDANCY_DETECTION__COMPARER:
				setComparer((String)newValue);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__SOLVER:
				setSolver((String)newValue);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE:
				setPathScope((String)newValue);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE:
				setDataScope((String)newValue);
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
			case CommonPackage.REDUNDANCY_DETECTION__COMPARER:
				setComparer(COMPARER_EDEFAULT);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__SOLVER:
				setSolver(SOLVER_EDEFAULT);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE:
				setPathScope(PATH_SCOPE_EDEFAULT);
				return;
			case CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE:
				setDataScope(DATA_SCOPE_EDEFAULT);
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
			case CommonPackage.REDUNDANCY_DETECTION__COMPARER:
				return COMPARER_EDEFAULT == null ? comparer != null : !COMPARER_EDEFAULT.equals(comparer);
			case CommonPackage.REDUNDANCY_DETECTION__SOLVER:
				return SOLVER_EDEFAULT == null ? solver != null : !SOLVER_EDEFAULT.equals(solver);
			case CommonPackage.REDUNDANCY_DETECTION__PATH_SCOPE:
				return PATH_SCOPE_EDEFAULT == null ? pathScope != null : !PATH_SCOPE_EDEFAULT.equals(pathScope);
			case CommonPackage.REDUNDANCY_DETECTION__DATA_SCOPE:
				return DATA_SCOPE_EDEFAULT == null ? dataScope != null : !DATA_SCOPE_EDEFAULT.equals(dataScope);
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
		result.append(" (comparer: ");
		result.append(comparer);
		result.append(", solver: ");
		result.append(solver);
		result.append(", pathScope: ");
		result.append(pathScope);
		result.append(", dataScope: ");
		result.append(dataScope);
		result.append(')');
		return result.toString();
	}

} //RedundancyDetectionImpl
