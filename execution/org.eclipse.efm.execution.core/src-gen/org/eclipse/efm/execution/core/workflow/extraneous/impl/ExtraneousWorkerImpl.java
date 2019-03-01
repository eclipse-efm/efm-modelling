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
package org.eclipse.efm.execution.core.workflow.extraneous.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;

import org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousPackage;
import org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker;

import org.eclipse.efm.execution.core.workflow.impl.WorkerImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Worker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousWorkerImpl#getExtraSEW <em>Extra SEW</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousWorkerImpl#getAnalysisProfileRequired <em>Analysis Profile Required</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ExtraneousWorkerImpl extends WorkerImpl implements ExtraneousWorker {
	/**
	 * The default value of the '{@link #getExtraSEW() <em>Extra SEW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraSEW()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTRA_SEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtraSEW() <em>Extra SEW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraSEW()
	 * @generated
	 * @ordered
	 */
	protected String extraSEW = EXTRA_SEW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnalysisProfileRequired() <em>Analysis Profile Required</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisProfileRequired()
	 * @generated
	 * @ordered
	 */
	protected EList<AnalysisProfileKind> analysisProfileRequired;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtraneousWorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtraneousPackage.Literals.EXTRANEOUS_WORKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExtraSEW() {
		return extraSEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtraSEW(String newExtraSEW) {
		String oldExtraSEW = extraSEW;
		extraSEW = newExtraSEW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtraneousPackage.EXTRANEOUS_WORKER__EXTRA_SEW, oldExtraSEW, extraSEW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<AnalysisProfileKind> getAnalysisProfileRequired() {
		if (analysisProfileRequired == null) {
			analysisProfileRequired = new EDataTypeUniqueEList<AnalysisProfileKind>(AnalysisProfileKind.class, this, ExtraneousPackage.EXTRANEOUS_WORKER__ANALYSIS_PROFILE_REQUIRED);
		}
		return analysisProfileRequired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExtraneousPackage.EXTRANEOUS_WORKER__EXTRA_SEW:
				return getExtraSEW();
			case ExtraneousPackage.EXTRANEOUS_WORKER__ANALYSIS_PROFILE_REQUIRED:
				return getAnalysisProfileRequired();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExtraneousPackage.EXTRANEOUS_WORKER__EXTRA_SEW:
				setExtraSEW((String)newValue);
				return;
			case ExtraneousPackage.EXTRANEOUS_WORKER__ANALYSIS_PROFILE_REQUIRED:
				getAnalysisProfileRequired().clear();
				getAnalysisProfileRequired().addAll((Collection<? extends AnalysisProfileKind>)newValue);
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
			case ExtraneousPackage.EXTRANEOUS_WORKER__EXTRA_SEW:
				setExtraSEW(EXTRA_SEW_EDEFAULT);
				return;
			case ExtraneousPackage.EXTRANEOUS_WORKER__ANALYSIS_PROFILE_REQUIRED:
				getAnalysisProfileRequired().clear();
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
			case ExtraneousPackage.EXTRANEOUS_WORKER__EXTRA_SEW:
				return EXTRA_SEW_EDEFAULT == null ? extraSEW != null : !EXTRA_SEW_EDEFAULT.equals(extraSEW);
			case ExtraneousPackage.EXTRANEOUS_WORKER__ANALYSIS_PROFILE_REQUIRED:
				return analysisProfileRequired != null && !analysisProfileRequired.isEmpty();
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
		result.append(" (extraSEW: ");
		result.append(extraSEW);
		result.append(", AnalysisProfileRequired: ");
		result.append(analysisProfileRequired);
		result.append(')');
		return result.toString();
	}

} //ExtraneousWorkerImpl
