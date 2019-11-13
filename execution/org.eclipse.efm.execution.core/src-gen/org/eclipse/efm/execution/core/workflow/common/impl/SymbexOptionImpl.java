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
import org.eclipse.efm.execution.core.workflow.common.SolverKind;
import org.eclipse.efm.execution.core.workflow.common.SymbexOption;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbex Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.SymbexOptionImpl#getConstraintSolver <em>Constraint Solver</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.SymbexOptionImpl#getRawOptions <em>Raw Options</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SymbexOptionImpl extends MinimalEObjectImpl.Container implements SymbexOption {
	/**
	 * The default value of the '{@link #getConstraintSolver() <em>Constraint Solver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintSolver()
	 * @generated
	 * @ordered
	 */
	protected static final SolverKind CONSTRAINT_SOLVER_EDEFAULT = SolverKind.CVC4;
	/**
	 * The cached value of the '{@link #getConstraintSolver() <em>Constraint Solver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintSolver()
	 * @generated
	 * @ordered
	 */
	protected SolverKind constraintSolver = CONSTRAINT_SOLVER_EDEFAULT;
	/**
	 * The default value of the '{@link #getRawOptions() <em>Raw Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawOptions()
	 * @generated
	 * @ordered
	 */
	protected static final String RAW_OPTIONS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRawOptions() <em>Raw Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawOptions()
	 * @generated
	 * @ordered
	 */
	protected String rawOptions = RAW_OPTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SymbexOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.SYMBEX_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SolverKind getConstraintSolver() {
		return constraintSolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstraintSolver(SolverKind newConstraintSolver) {
		SolverKind oldConstraintSolver = constraintSolver;
		constraintSolver = newConstraintSolver == null ? CONSTRAINT_SOLVER_EDEFAULT : newConstraintSolver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.SYMBEX_OPTION__CONSTRAINT_SOLVER, oldConstraintSolver, constraintSolver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRawOptions() {
		return rawOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRawOptions(String newRawOptions) {
		String oldRawOptions = rawOptions;
		rawOptions = newRawOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.SYMBEX_OPTION__RAW_OPTIONS, oldRawOptions, rawOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.SYMBEX_OPTION__CONSTRAINT_SOLVER:
				return getConstraintSolver();
			case CommonPackage.SYMBEX_OPTION__RAW_OPTIONS:
				return getRawOptions();
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
			case CommonPackage.SYMBEX_OPTION__CONSTRAINT_SOLVER:
				setConstraintSolver((SolverKind)newValue);
				return;
			case CommonPackage.SYMBEX_OPTION__RAW_OPTIONS:
				setRawOptions((String)newValue);
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
			case CommonPackage.SYMBEX_OPTION__CONSTRAINT_SOLVER:
				setConstraintSolver(CONSTRAINT_SOLVER_EDEFAULT);
				return;
			case CommonPackage.SYMBEX_OPTION__RAW_OPTIONS:
				setRawOptions(RAW_OPTIONS_EDEFAULT);
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
			case CommonPackage.SYMBEX_OPTION__CONSTRAINT_SOLVER:
				return constraintSolver != CONSTRAINT_SOLVER_EDEFAULT;
			case CommonPackage.SYMBEX_OPTION__RAW_OPTIONS:
				return RAW_OPTIONS_EDEFAULT == null ? rawOptions != null : !RAW_OPTIONS_EDEFAULT.equals(rawOptions);
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
		result.append(" (constraintSolver: ");
		result.append(constraintSolver);
		result.append(", rawOptions: ");
		result.append(rawOptions);
		result.append(')');
		return result.toString();
	}

} //SymbexOptionImpl
