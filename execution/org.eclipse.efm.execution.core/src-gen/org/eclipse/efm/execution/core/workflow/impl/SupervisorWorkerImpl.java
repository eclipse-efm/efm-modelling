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
package org.eclipse.efm.execution.core.workflow.impl;

import org.eclipse.efm.execution.core.workflow.SupervisorWorker;
import org.eclipse.efm.execution.core.workflow.WorkflowPackage;

import org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue;
import org.eclipse.efm.execution.core.workflow.common.RedundancyDetection;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supervisor Worker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl#getLimit <em>Limit</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl#getQueue <em>Queue</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl#getExtender <em>Extender</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl#getRedundancy <em>Redundancy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupervisorWorkerImpl extends WorkerImpl implements SupervisorWorker {
	/**
	 * The cached value of the '{@link #getLimit() <em>Limit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimit()
	 * @generated
	 * @ordered
	 */
	protected GraphExplorationLimit limit;

	/**
	 * The cached value of the '{@link #getQueue() <em>Queue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueue()
	 * @generated
	 * @ordered
	 */
	protected GraphExplorationQueue queue;

	/**
	 * The cached value of the '{@link #getExtender() <em>Extender</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtender()
	 * @generated
	 * @ordered
	 */
	protected TraceSpecification extender;

	/**
	 * The cached value of the '{@link #getRedundancy() <em>Redundancy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedundancy()
	 * @generated
	 * @ordered
	 */
	protected RedundancyDetection redundancy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SupervisorWorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.SUPERVISOR_WORKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphExplorationLimit getLimit() {
		return limit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLimit(GraphExplorationLimit newLimit, NotificationChain msgs) {
		GraphExplorationLimit oldLimit = limit;
		limit = newLimit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.SUPERVISOR_WORKER__LIMIT, oldLimit, newLimit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLimit(GraphExplorationLimit newLimit) {
		if (newLimit != limit) {
			NotificationChain msgs = null;
			if (limit != null)
				msgs = ((InternalEObject)limit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SUPERVISOR_WORKER__LIMIT, null, msgs);
			if (newLimit != null)
				msgs = ((InternalEObject)newLimit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SUPERVISOR_WORKER__LIMIT, null, msgs);
			msgs = basicSetLimit(newLimit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SUPERVISOR_WORKER__LIMIT, newLimit, newLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphExplorationQueue getQueue() {
		return queue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQueue(GraphExplorationQueue newQueue, NotificationChain msgs) {
		GraphExplorationQueue oldQueue = queue;
		queue = newQueue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.SUPERVISOR_WORKER__QUEUE, oldQueue, newQueue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueue(GraphExplorationQueue newQueue) {
		if (newQueue != queue) {
			NotificationChain msgs = null;
			if (queue != null)
				msgs = ((InternalEObject)queue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SUPERVISOR_WORKER__QUEUE, null, msgs);
			if (newQueue != null)
				msgs = ((InternalEObject)newQueue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SUPERVISOR_WORKER__QUEUE, null, msgs);
			msgs = basicSetQueue(newQueue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SUPERVISOR_WORKER__QUEUE, newQueue, newQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSpecification getExtender() {
		return extender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtender(TraceSpecification newExtender, NotificationChain msgs) {
		TraceSpecification oldExtender = extender;
		extender = newExtender;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.SUPERVISOR_WORKER__EXTENDER, oldExtender, newExtender);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtender(TraceSpecification newExtender) {
		if (newExtender != extender) {
			NotificationChain msgs = null;
			if (extender != null)
				msgs = ((InternalEObject)extender).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SUPERVISOR_WORKER__EXTENDER, null, msgs);
			if (newExtender != null)
				msgs = ((InternalEObject)newExtender).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SUPERVISOR_WORKER__EXTENDER, null, msgs);
			msgs = basicSetExtender(newExtender, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SUPERVISOR_WORKER__EXTENDER, newExtender, newExtender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyDetection getRedundancy() {
		if (redundancy != null && redundancy.eIsProxy()) {
			InternalEObject oldRedundancy = (InternalEObject)redundancy;
			redundancy = (RedundancyDetection)eResolveProxy(oldRedundancy);
			if (redundancy != oldRedundancy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.SUPERVISOR_WORKER__REDUNDANCY, oldRedundancy, redundancy));
			}
		}
		return redundancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyDetection basicGetRedundancy() {
		return redundancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedundancy(RedundancyDetection newRedundancy) {
		RedundancyDetection oldRedundancy = redundancy;
		redundancy = newRedundancy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SUPERVISOR_WORKER__REDUNDANCY, oldRedundancy, redundancy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.SUPERVISOR_WORKER__LIMIT:
				return basicSetLimit(null, msgs);
			case WorkflowPackage.SUPERVISOR_WORKER__QUEUE:
				return basicSetQueue(null, msgs);
			case WorkflowPackage.SUPERVISOR_WORKER__EXTENDER:
				return basicSetExtender(null, msgs);
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
			case WorkflowPackage.SUPERVISOR_WORKER__LIMIT:
				return getLimit();
			case WorkflowPackage.SUPERVISOR_WORKER__QUEUE:
				return getQueue();
			case WorkflowPackage.SUPERVISOR_WORKER__EXTENDER:
				return getExtender();
			case WorkflowPackage.SUPERVISOR_WORKER__REDUNDANCY:
				if (resolve) return getRedundancy();
				return basicGetRedundancy();
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
			case WorkflowPackage.SUPERVISOR_WORKER__LIMIT:
				setLimit((GraphExplorationLimit)newValue);
				return;
			case WorkflowPackage.SUPERVISOR_WORKER__QUEUE:
				setQueue((GraphExplorationQueue)newValue);
				return;
			case WorkflowPackage.SUPERVISOR_WORKER__EXTENDER:
				setExtender((TraceSpecification)newValue);
				return;
			case WorkflowPackage.SUPERVISOR_WORKER__REDUNDANCY:
				setRedundancy((RedundancyDetection)newValue);
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
			case WorkflowPackage.SUPERVISOR_WORKER__LIMIT:
				setLimit((GraphExplorationLimit)null);
				return;
			case WorkflowPackage.SUPERVISOR_WORKER__QUEUE:
				setQueue((GraphExplorationQueue)null);
				return;
			case WorkflowPackage.SUPERVISOR_WORKER__EXTENDER:
				setExtender((TraceSpecification)null);
				return;
			case WorkflowPackage.SUPERVISOR_WORKER__REDUNDANCY:
				setRedundancy((RedundancyDetection)null);
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
			case WorkflowPackage.SUPERVISOR_WORKER__LIMIT:
				return limit != null;
			case WorkflowPackage.SUPERVISOR_WORKER__QUEUE:
				return queue != null;
			case WorkflowPackage.SUPERVISOR_WORKER__EXTENDER:
				return extender != null;
			case WorkflowPackage.SUPERVISOR_WORKER__REDUNDANCY:
				return redundancy != null;
		}
		return super.eIsSet(featureID);
	}

} //SupervisorWorkerImpl
