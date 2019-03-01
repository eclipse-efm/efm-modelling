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
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind;

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
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getBound <em>Bound</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getStep <em>Step</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getReport <em>Report</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getVerbosity <em>Verbosity</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getSpiderInit <em>Spider Init</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getSpiderStep <em>Spider Step</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.ConsoleLogFormatImpl#getSpiderStop <em>Spider Stop</em>}</li>
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
	 * The default value of the '{@link #getVerbosity() <em>Verbosity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbosity()
	 * @generated
	 * @ordered
	 */
	protected static final ConsoleVerbosityKind VERBOSITY_EDEFAULT = ConsoleVerbosityKind.UNDEFINED;

	/**
	 * The cached value of the '{@link #getVerbosity() <em>Verbosity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbosity()
	 * @generated
	 * @ordered
	 */
	protected ConsoleVerbosityKind verbosity = VERBOSITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpiderInit() <em>Spider Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpiderInit()
	 * @generated
	 * @ordered
	 */
	protected static final String SPIDER_INIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpiderInit() <em>Spider Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpiderInit()
	 * @generated
	 * @ordered
	 */
	protected String spiderInit = SPIDER_INIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpiderStep() <em>Spider Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpiderStep()
	 * @generated
	 * @ordered
	 */
	protected static final String SPIDER_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpiderStep() <em>Spider Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpiderStep()
	 * @generated
	 * @ordered
	 */
	protected String spiderStep = SPIDER_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpiderStop() <em>Spider Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpiderStop()
	 * @generated
	 * @ordered
	 */
	protected static final String SPIDER_STOP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpiderStop() <em>Spider Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpiderStop()
	 * @generated
	 * @ordered
	 */
	protected String spiderStop = SPIDER_STOP_EDEFAULT;

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
	@Override
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getBound() {
		return bound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getStep() {
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getReport() {
		return report;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public ConsoleVerbosityKind getVerbosity() {
		return verbosity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerbosity(ConsoleVerbosityKind newVerbosity) {
		ConsoleVerbosityKind oldVerbosity = verbosity;
		verbosity = newVerbosity == null ? VERBOSITY_EDEFAULT : newVerbosity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__VERBOSITY, oldVerbosity, verbosity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSpiderInit() {
		return spiderInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpiderInit(String newSpiderInit) {
		String oldSpiderInit = spiderInit;
		spiderInit = newSpiderInit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_INIT, oldSpiderInit, spiderInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSpiderStep() {
		return spiderStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpiderStep(String newSpiderStep) {
		String oldSpiderStep = spiderStep;
		spiderStep = newSpiderStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STEP, oldSpiderStep, spiderStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSpiderStop() {
		return spiderStop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpiderStop(String newSpiderStop) {
		String oldSpiderStop = spiderStop;
		spiderStop = newSpiderStop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STOP, oldSpiderStop, spiderStop));
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
			case CommonPackage.CONSOLE_LOG_FORMAT__VERBOSITY:
				return getVerbosity();
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_INIT:
				return getSpiderInit();
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STEP:
				return getSpiderStep();
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STOP:
				return getSpiderStop();
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
			case CommonPackage.CONSOLE_LOG_FORMAT__VERBOSITY:
				setVerbosity((ConsoleVerbosityKind)newValue);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_INIT:
				setSpiderInit((String)newValue);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STEP:
				setSpiderStep((String)newValue);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STOP:
				setSpiderStop((String)newValue);
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
			case CommonPackage.CONSOLE_LOG_FORMAT__VERBOSITY:
				setVerbosity(VERBOSITY_EDEFAULT);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_INIT:
				setSpiderInit(SPIDER_INIT_EDEFAULT);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STEP:
				setSpiderStep(SPIDER_STEP_EDEFAULT);
				return;
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STOP:
				setSpiderStop(SPIDER_STOP_EDEFAULT);
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
			case CommonPackage.CONSOLE_LOG_FORMAT__VERBOSITY:
				return verbosity != VERBOSITY_EDEFAULT;
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_INIT:
				return SPIDER_INIT_EDEFAULT == null ? spiderInit != null : !SPIDER_INIT_EDEFAULT.equals(spiderInit);
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STEP:
				return SPIDER_STEP_EDEFAULT == null ? spiderStep != null : !SPIDER_STEP_EDEFAULT.equals(spiderStep);
			case CommonPackage.CONSOLE_LOG_FORMAT__SPIDER_STOP:
				return SPIDER_STOP_EDEFAULT == null ? spiderStop != null : !SPIDER_STOP_EDEFAULT.equals(spiderStop);
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
		result.append(", verbosity: ");
		result.append(verbosity);
		result.append(", spiderInit: ");
		result.append(spiderInit);
		result.append(", spiderStep: ");
		result.append(spiderStep);
		result.append(", spiderStop: ");
		result.append(spiderStop);
		result.append(')');
		return result.toString();
	}

} //ConsoleLogFormatImpl
