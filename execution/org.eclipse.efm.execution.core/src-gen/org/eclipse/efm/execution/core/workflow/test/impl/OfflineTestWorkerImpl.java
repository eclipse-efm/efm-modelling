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
package org.eclipse.efm.execution.core.workflow.test.impl;

import org.eclipse.efm.execution.core.workflow.common.TraceSpecification;

import org.eclipse.efm.execution.core.workflow.impl.WorkerImpl;

import org.eclipse.efm.execution.core.workflow.test.OfflineTestWorker;
import org.eclipse.efm.execution.core.workflow.test.TestPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Offline Test Worker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.test.impl.OfflineTestWorkerImpl#getMergedTraceFile <em>Merged Trace File</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.test.impl.OfflineTestWorkerImpl#getTestPurposeFile <em>Test Purpose File</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.test.impl.OfflineTestWorkerImpl#getObservable <em>Observable</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.test.impl.OfflineTestWorkerImpl#getControllable <em>Controllable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OfflineTestWorkerImpl extends WorkerImpl implements OfflineTestWorker {
	/**
	 * The default value of the '{@link #getMergedTraceFile() <em>Merged Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMergedTraceFile()
	 * @generated
	 * @ordered
	 */
	protected static final String MERGED_TRACE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMergedTraceFile() <em>Merged Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMergedTraceFile()
	 * @generated
	 * @ordered
	 */
	protected String mergedTraceFile = MERGED_TRACE_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTestPurposeFile() <em>Test Purpose File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestPurposeFile()
	 * @generated
	 * @ordered
	 */
	protected static final String TEST_PURPOSE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestPurposeFile() <em>Test Purpose File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestPurposeFile()
	 * @generated
	 * @ordered
	 */
	protected String testPurposeFile = TEST_PURPOSE_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getObservable() <em>Observable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservable()
	 * @generated
	 * @ordered
	 */
	protected TraceSpecification observable;

	/**
	 * The cached value of the '{@link #getControllable() <em>Controllable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllable()
	 * @generated
	 * @ordered
	 */
	protected TraceSpecification controllable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OfflineTestWorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestPackage.Literals.OFFLINE_TEST_WORKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMergedTraceFile() {
		return mergedTraceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMergedTraceFile(String newMergedTraceFile) {
		String oldMergedTraceFile = mergedTraceFile;
		mergedTraceFile = newMergedTraceFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.OFFLINE_TEST_WORKER__MERGED_TRACE_FILE, oldMergedTraceFile, mergedTraceFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestPurposeFile() {
		return testPurposeFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestPurposeFile(String newTestPurposeFile) {
		String oldTestPurposeFile = testPurposeFile;
		testPurposeFile = newTestPurposeFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.OFFLINE_TEST_WORKER__TEST_PURPOSE_FILE, oldTestPurposeFile, testPurposeFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSpecification getObservable() {
		return observable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObservable(TraceSpecification newObservable, NotificationChain msgs) {
		TraceSpecification oldObservable = observable;
		observable = newObservable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE, oldObservable, newObservable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObservable(TraceSpecification newObservable) {
		if (newObservable != observable) {
			NotificationChain msgs = null;
			if (observable != null)
				msgs = ((InternalEObject)observable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE, null, msgs);
			if (newObservable != null)
				msgs = ((InternalEObject)newObservable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE, null, msgs);
			msgs = basicSetObservable(newObservable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE, newObservable, newObservable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSpecification getControllable() {
		return controllable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetControllable(TraceSpecification newControllable, NotificationChain msgs) {
		TraceSpecification oldControllable = controllable;
		controllable = newControllable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE, oldControllable, newControllable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllable(TraceSpecification newControllable) {
		if (newControllable != controllable) {
			NotificationChain msgs = null;
			if (controllable != null)
				msgs = ((InternalEObject)controllable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE, null, msgs);
			if (newControllable != null)
				msgs = ((InternalEObject)newControllable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE, null, msgs);
			msgs = basicSetControllable(newControllable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE, newControllable, newControllable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE:
				return basicSetObservable(null, msgs);
			case TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE:
				return basicSetControllable(null, msgs);
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
			case TestPackage.OFFLINE_TEST_WORKER__MERGED_TRACE_FILE:
				return getMergedTraceFile();
			case TestPackage.OFFLINE_TEST_WORKER__TEST_PURPOSE_FILE:
				return getTestPurposeFile();
			case TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE:
				return getObservable();
			case TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE:
				return getControllable();
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
			case TestPackage.OFFLINE_TEST_WORKER__MERGED_TRACE_FILE:
				setMergedTraceFile((String)newValue);
				return;
			case TestPackage.OFFLINE_TEST_WORKER__TEST_PURPOSE_FILE:
				setTestPurposeFile((String)newValue);
				return;
			case TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE:
				setObservable((TraceSpecification)newValue);
				return;
			case TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE:
				setControllable((TraceSpecification)newValue);
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
			case TestPackage.OFFLINE_TEST_WORKER__MERGED_TRACE_FILE:
				setMergedTraceFile(MERGED_TRACE_FILE_EDEFAULT);
				return;
			case TestPackage.OFFLINE_TEST_WORKER__TEST_PURPOSE_FILE:
				setTestPurposeFile(TEST_PURPOSE_FILE_EDEFAULT);
				return;
			case TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE:
				setObservable((TraceSpecification)null);
				return;
			case TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE:
				setControllable((TraceSpecification)null);
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
			case TestPackage.OFFLINE_TEST_WORKER__MERGED_TRACE_FILE:
				return MERGED_TRACE_FILE_EDEFAULT == null ? mergedTraceFile != null : !MERGED_TRACE_FILE_EDEFAULT.equals(mergedTraceFile);
			case TestPackage.OFFLINE_TEST_WORKER__TEST_PURPOSE_FILE:
				return TEST_PURPOSE_FILE_EDEFAULT == null ? testPurposeFile != null : !TEST_PURPOSE_FILE_EDEFAULT.equals(testPurposeFile);
			case TestPackage.OFFLINE_TEST_WORKER__OBSERVABLE:
				return observable != null;
			case TestPackage.OFFLINE_TEST_WORKER__CONTROLLABLE:
				return controllable != null;
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
		result.append(" (mergedTraceFile: ");
		result.append(mergedTraceFile);
		result.append(", testPurposeFile: ");
		result.append(testPurposeFile);
		result.append(')');
		return result.toString();
	}

} //OfflineTestWorkerImpl
