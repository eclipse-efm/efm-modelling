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
package org.eclipse.efm.runconfiguration.workflow.common.impl;

import org.eclipse.efm.runconfiguration.workflow.common.CommonPackage;
import org.eclipse.efm.runconfiguration.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.runconfiguration.workflow.common.ConsoleVerboseKind;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Console Log Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.common.impl.ConsoleLogFormatImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.common.impl.ConsoleLogFormatImpl#getBound <em>Bound</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.common.impl.ConsoleLogFormatImpl#getStep <em>Step</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.common.impl.ConsoleLogFormatImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.common.impl.ConsoleLogFormatImpl#getReport <em>Report</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.common.impl.ConsoleLogFormatImpl#getVerbose <em>Verbose</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsoleLogFormatImpl extends MinimalEObjectImpl.Container implements ConsoleLogFormat {
	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBound() <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBound()
	 * @generated
	 * @ordered
	 */
	protected static final String BOUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBound() <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBound()
	 * @generated
	 * @ordered
	 */
	protected String bound = BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected static final String STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected String step = STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected String result = RESULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getReport() <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReport()
	 * @generated
	 * @ordered
	 */
	protected static final String REPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReport() <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReport()
	 * @generated
	 * @ordered
	 */
	protected String report = REPORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerbose() <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbose()
	 * @generated
	 * @ordered
	 */
	protected static final ConsoleVerboseKind VERBOSE_EDEFAULT = ConsoleVerboseKind.UNDEFINED;

	/**
	 * The cached value of the '{@link #getVerbose() <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbose()
	 * @generated
	 * @ordered
	 */
	protected ConsoleVerboseKind verbose = VERBOSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsoleLogFormatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.CONSOLE_LOG_FORMAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBound() {
		return bound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBound(String newBound) {
		String oldBound = bound;
		bound = newBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__BOUND, oldBound, bound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStep() {
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStep(String newStep) {
		String oldStep = step;
		step = newStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__STEP, oldStep, step));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(String newResult) {
		String oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReport() {
		return report;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReport(String newReport) {
		String oldReport = report;
		report = newReport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__REPORT, oldReport, report));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsoleVerboseKind getVerbose() {
		return verbose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerbose(ConsoleVerboseKind newVerbose) {
		ConsoleVerboseKind oldVerbose = verbose;
		verbose = newVerbose == null ? VERBOSE_EDEFAULT : newVerbose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.CONSOLE_LOG_FORMAT__FORMAT:
				return getFormat();
			case CommonPackage.CONSOLE_LOG_FORMAT__BOUND:
				return getBound();
			case CommonPackage.CONSOLE_LOG_FORMAT__STEP:
				return getStep();
			case CommonPackage.CONSOLE_LOG_FORMAT__RESULT:
				return getResult();
			case CommonPackage.CONSOLE_LOG_FORMAT__REPORT:
				return getReport();
			case CommonPackage.CONSOLE_LOG_FORMAT__VERBOSE:
				return getVerbose();
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
			case CommonPackage.CONSOLE_LOG_FORMAT__FORMAT:
				setFormat((String)newValue);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__BOUND:
				setBound((String)newValue);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__STEP:
				setStep((String)newValue);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__RESULT:
				setResult((String)newValue);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__REPORT:
				setReport((String)newValue);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__VERBOSE:
				setVerbose((ConsoleVerboseKind)newValue);
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
			case CommonPackage.CONSOLE_LOG_FORMAT__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__BOUND:
				setBound(BOUND_EDEFAULT);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__STEP:
				setStep(STEP_EDEFAULT);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__RESULT:
				setResult(RESULT_EDEFAULT);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__REPORT:
				setReport(REPORT_EDEFAULT);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
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
			case CommonPackage.CONSOLE_LOG_FORMAT__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case CommonPackage.CONSOLE_LOG_FORMAT__BOUND:
				return BOUND_EDEFAULT == null ? bound != null : !BOUND_EDEFAULT.equals(bound);
			case CommonPackage.CONSOLE_LOG_FORMAT__STEP:
				return STEP_EDEFAULT == null ? step != null : !STEP_EDEFAULT.equals(step);
			case CommonPackage.CONSOLE_LOG_FORMAT__RESULT:
				return RESULT_EDEFAULT == null ? result != null : !RESULT_EDEFAULT.equals(result);
			case CommonPackage.CONSOLE_LOG_FORMAT__REPORT:
				return REPORT_EDEFAULT == null ? report != null : !REPORT_EDEFAULT.equals(report);
			case CommonPackage.CONSOLE_LOG_FORMAT__VERBOSE:
				return verbose != VERBOSE_EDEFAULT;
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
		result.append(" (format: ");
		result.append(format);
		result.append(", bound: ");
		result.append(bound);
		result.append(", step: ");
		result.append(step);
		result.append(", result: ");
		result.append(result);
		result.append(", report: ");
		result.append(report);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(')');
		return result.toString();
	}

} //ConsoleLogFormatImpl
