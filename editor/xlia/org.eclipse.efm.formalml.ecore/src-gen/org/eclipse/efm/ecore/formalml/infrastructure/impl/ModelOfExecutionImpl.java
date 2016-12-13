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
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.infrastructure.impl;

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Of Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getInitRoutine <em>Init Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getFinalRoutine <em>Final Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getEnableRoutine <em>Enable Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getDisableRoutine <em>Disable Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getConcurrencyRoutine <em>Concurrency Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getScheduleRoutine <em>Schedule Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getIrunRoutine <em>Irun Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getRunRoutine <em>Run Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl#getRoutine <em>Routine</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelOfExecutionImpl extends MinimalEObjectImpl.Container implements ModelOfExecution {
	/**
	 * The cached value of the '{@link #getInitRoutine() <em>Init Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitRoutine()
	 * @generated
	 * @ordered
	 */
	protected Routine initRoutine;

	/**
	 * The cached value of the '{@link #getFinalRoutine() <em>Final Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalRoutine()
	 * @generated
	 * @ordered
	 */
	protected Routine finalRoutine;

	/**
	 * The cached value of the '{@link #getEnableRoutine() <em>Enable Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableRoutine()
	 * @generated
	 * @ordered
	 */
	protected Routine enableRoutine;

	/**
	 * The cached value of the '{@link #getDisableRoutine() <em>Disable Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisableRoutine()
	 * @generated
	 * @ordered
	 */
	protected Routine disableRoutine;

	/**
	 * The cached value of the '{@link #getConcurrencyRoutine() <em>Concurrency Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcurrencyRoutine()
	 * @generated
	 * @ordered
	 */
	protected Routine concurrencyRoutine;

	/**
	 * The cached value of the '{@link #getScheduleRoutine() <em>Schedule Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduleRoutine()
	 * @generated
	 * @ordered
	 */
	protected Routine scheduleRoutine;

	/**
	 * The cached value of the '{@link #getIrunRoutine() <em>Irun Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIrunRoutine()
	 * @generated
	 * @ordered
	 */
	protected Routine irunRoutine;

	/**
	 * The cached value of the '{@link #getRunRoutine() <em>Run Routine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunRoutine()
	 * @generated
	 * @ordered
	 */
	protected Routine runRoutine;

	/**
	 * The cached value of the '{@link #getRoutine() <em>Routine</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutine()
	 * @generated
	 * @ordered
	 */
	protected EList<Routine> routine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelOfExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.MODEL_OF_EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Routine getInitRoutine() {
		return initRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitRoutine(Routine newInitRoutine, NotificationChain msgs) {
		Routine oldInitRoutine = initRoutine;
		initRoutine = newInitRoutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE, oldInitRoutine, newInitRoutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitRoutine(Routine newInitRoutine) {
		if (newInitRoutine != initRoutine) {
			NotificationChain msgs = null;
			if (initRoutine != null)
				msgs = ((InternalEObject)initRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE, null, msgs);
			if (newInitRoutine != null)
				msgs = ((InternalEObject)newInitRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE, null, msgs);
			msgs = basicSetInitRoutine(newInitRoutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE, newInitRoutine, newInitRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Routine getFinalRoutine() {
		return finalRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinalRoutine(Routine newFinalRoutine, NotificationChain msgs) {
		Routine oldFinalRoutine = finalRoutine;
		finalRoutine = newFinalRoutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE, oldFinalRoutine, newFinalRoutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinalRoutine(Routine newFinalRoutine) {
		if (newFinalRoutine != finalRoutine) {
			NotificationChain msgs = null;
			if (finalRoutine != null)
				msgs = ((InternalEObject)finalRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE, null, msgs);
			if (newFinalRoutine != null)
				msgs = ((InternalEObject)newFinalRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE, null, msgs);
			msgs = basicSetFinalRoutine(newFinalRoutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE, newFinalRoutine, newFinalRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Routine getEnableRoutine() {
		return enableRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnableRoutine(Routine newEnableRoutine, NotificationChain msgs) {
		Routine oldEnableRoutine = enableRoutine;
		enableRoutine = newEnableRoutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE, oldEnableRoutine, newEnableRoutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableRoutine(Routine newEnableRoutine) {
		if (newEnableRoutine != enableRoutine) {
			NotificationChain msgs = null;
			if (enableRoutine != null)
				msgs = ((InternalEObject)enableRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE, null, msgs);
			if (newEnableRoutine != null)
				msgs = ((InternalEObject)newEnableRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE, null, msgs);
			msgs = basicSetEnableRoutine(newEnableRoutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE, newEnableRoutine, newEnableRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Routine getDisableRoutine() {
		return disableRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDisableRoutine(Routine newDisableRoutine, NotificationChain msgs) {
		Routine oldDisableRoutine = disableRoutine;
		disableRoutine = newDisableRoutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE, oldDisableRoutine, newDisableRoutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisableRoutine(Routine newDisableRoutine) {
		if (newDisableRoutine != disableRoutine) {
			NotificationChain msgs = null;
			if (disableRoutine != null)
				msgs = ((InternalEObject)disableRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE, null, msgs);
			if (newDisableRoutine != null)
				msgs = ((InternalEObject)newDisableRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE, null, msgs);
			msgs = basicSetDisableRoutine(newDisableRoutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE, newDisableRoutine, newDisableRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Routine getConcurrencyRoutine() {
		return concurrencyRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcurrencyRoutine(Routine newConcurrencyRoutine, NotificationChain msgs) {
		Routine oldConcurrencyRoutine = concurrencyRoutine;
		concurrencyRoutine = newConcurrencyRoutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE, oldConcurrencyRoutine, newConcurrencyRoutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcurrencyRoutine(Routine newConcurrencyRoutine) {
		if (newConcurrencyRoutine != concurrencyRoutine) {
			NotificationChain msgs = null;
			if (concurrencyRoutine != null)
				msgs = ((InternalEObject)concurrencyRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE, null, msgs);
			if (newConcurrencyRoutine != null)
				msgs = ((InternalEObject)newConcurrencyRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE, null, msgs);
			msgs = basicSetConcurrencyRoutine(newConcurrencyRoutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE, newConcurrencyRoutine, newConcurrencyRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Routine getScheduleRoutine() {
		return scheduleRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScheduleRoutine(Routine newScheduleRoutine, NotificationChain msgs) {
		Routine oldScheduleRoutine = scheduleRoutine;
		scheduleRoutine = newScheduleRoutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE, oldScheduleRoutine, newScheduleRoutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleRoutine(Routine newScheduleRoutine) {
		if (newScheduleRoutine != scheduleRoutine) {
			NotificationChain msgs = null;
			if (scheduleRoutine != null)
				msgs = ((InternalEObject)scheduleRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE, null, msgs);
			if (newScheduleRoutine != null)
				msgs = ((InternalEObject)newScheduleRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE, null, msgs);
			msgs = basicSetScheduleRoutine(newScheduleRoutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE, newScheduleRoutine, newScheduleRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Routine getIrunRoutine() {
		return irunRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIrunRoutine(Routine newIrunRoutine, NotificationChain msgs) {
		Routine oldIrunRoutine = irunRoutine;
		irunRoutine = newIrunRoutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE, oldIrunRoutine, newIrunRoutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIrunRoutine(Routine newIrunRoutine) {
		if (newIrunRoutine != irunRoutine) {
			NotificationChain msgs = null;
			if (irunRoutine != null)
				msgs = ((InternalEObject)irunRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE, null, msgs);
			if (newIrunRoutine != null)
				msgs = ((InternalEObject)newIrunRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE, null, msgs);
			msgs = basicSetIrunRoutine(newIrunRoutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE, newIrunRoutine, newIrunRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Routine getRunRoutine() {
		return runRoutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRunRoutine(Routine newRunRoutine, NotificationChain msgs) {
		Routine oldRunRoutine = runRoutine;
		runRoutine = newRunRoutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE, oldRunRoutine, newRunRoutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunRoutine(Routine newRunRoutine) {
		if (newRunRoutine != runRoutine) {
			NotificationChain msgs = null;
			if (runRoutine != null)
				msgs = ((InternalEObject)runRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE, null, msgs);
			if (newRunRoutine != null)
				msgs = ((InternalEObject)newRunRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE, null, msgs);
			msgs = basicSetRunRoutine(newRunRoutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE, newRunRoutine, newRunRoutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Routine> getRoutine() {
		if (routine == null) {
			routine = new EObjectContainmentEList<Routine>(Routine.class, this, InfrastructurePackage.MODEL_OF_EXECUTION__ROUTINE);
		}
		return routine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE:
				return basicSetInitRoutine(null, msgs);
			case InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE:
				return basicSetFinalRoutine(null, msgs);
			case InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE:
				return basicSetEnableRoutine(null, msgs);
			case InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE:
				return basicSetDisableRoutine(null, msgs);
			case InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE:
				return basicSetConcurrencyRoutine(null, msgs);
			case InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE:
				return basicSetScheduleRoutine(null, msgs);
			case InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE:
				return basicSetIrunRoutine(null, msgs);
			case InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE:
				return basicSetRunRoutine(null, msgs);
			case InfrastructurePackage.MODEL_OF_EXECUTION__ROUTINE:
				return ((InternalEList<?>)getRoutine()).basicRemove(otherEnd, msgs);
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
			case InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE:
				return getInitRoutine();
			case InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE:
				return getFinalRoutine();
			case InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE:
				return getEnableRoutine();
			case InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE:
				return getDisableRoutine();
			case InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE:
				return getConcurrencyRoutine();
			case InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE:
				return getScheduleRoutine();
			case InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE:
				return getIrunRoutine();
			case InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE:
				return getRunRoutine();
			case InfrastructurePackage.MODEL_OF_EXECUTION__ROUTINE:
				return getRoutine();
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
			case InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE:
				setInitRoutine((Routine)newValue);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE:
				setFinalRoutine((Routine)newValue);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE:
				setEnableRoutine((Routine)newValue);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE:
				setDisableRoutine((Routine)newValue);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE:
				setConcurrencyRoutine((Routine)newValue);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE:
				setScheduleRoutine((Routine)newValue);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE:
				setIrunRoutine((Routine)newValue);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE:
				setRunRoutine((Routine)newValue);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__ROUTINE:
				getRoutine().clear();
				getRoutine().addAll((Collection<? extends Routine>)newValue);
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
			case InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE:
				setInitRoutine((Routine)null);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE:
				setFinalRoutine((Routine)null);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE:
				setEnableRoutine((Routine)null);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE:
				setDisableRoutine((Routine)null);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE:
				setConcurrencyRoutine((Routine)null);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE:
				setScheduleRoutine((Routine)null);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE:
				setIrunRoutine((Routine)null);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE:
				setRunRoutine((Routine)null);
				return;
			case InfrastructurePackage.MODEL_OF_EXECUTION__ROUTINE:
				getRoutine().clear();
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
			case InfrastructurePackage.MODEL_OF_EXECUTION__INIT_ROUTINE:
				return initRoutine != null;
			case InfrastructurePackage.MODEL_OF_EXECUTION__FINAL_ROUTINE:
				return finalRoutine != null;
			case InfrastructurePackage.MODEL_OF_EXECUTION__ENABLE_ROUTINE:
				return enableRoutine != null;
			case InfrastructurePackage.MODEL_OF_EXECUTION__DISABLE_ROUTINE:
				return disableRoutine != null;
			case InfrastructurePackage.MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE:
				return concurrencyRoutine != null;
			case InfrastructurePackage.MODEL_OF_EXECUTION__SCHEDULE_ROUTINE:
				return scheduleRoutine != null;
			case InfrastructurePackage.MODEL_OF_EXECUTION__IRUN_ROUTINE:
				return irunRoutine != null;
			case InfrastructurePackage.MODEL_OF_EXECUTION__RUN_ROUTINE:
				return runRoutine != null;
			case InfrastructurePackage.MODEL_OF_EXECUTION__ROUTINE:
				return routine != null && !routine.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelOfExecutionImpl
