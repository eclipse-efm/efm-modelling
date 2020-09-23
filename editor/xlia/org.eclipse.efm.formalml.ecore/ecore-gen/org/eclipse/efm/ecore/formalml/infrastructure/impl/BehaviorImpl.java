/**
 * Copyright (c) 2020 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html\n\nContributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.infrastructure.impl;

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfComputation;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction;
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorImpl#getComputation <em>Computation</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorImpl#getExecution <em>Execution</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorImpl#getInteraction <em>Interaction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorImpl extends MachineImpl implements Behavior {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameter;

	/**
	 * The cached value of the '{@link #getComputation() <em>Computation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputation()
	 * @generated
	 * @ordered
	 */
	protected ModelOfComputation computation;

	/**
	 * The cached value of the '{@link #getExecution() <em>Execution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecution()
	 * @generated
	 * @ordered
	 */
	protected ModelOfExecution execution;

	/**
	 * The cached value of the '{@link #getInteraction() <em>Interaction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteraction()
	 * @generated
	 * @ordered
	 */
	protected ModelOfInteraction interaction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, InfrastructurePackage.BEHAVIOR__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelOfComputation getComputation() {
		return computation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComputation(ModelOfComputation newComputation, NotificationChain msgs) {
		ModelOfComputation oldComputation = computation;
		computation = newComputation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.BEHAVIOR__COMPUTATION, oldComputation, newComputation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComputation(ModelOfComputation newComputation) {
		if (newComputation != computation) {
			NotificationChain msgs = null;
			if (computation != null)
				msgs = ((InternalEObject)computation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.BEHAVIOR__COMPUTATION, null, msgs);
			if (newComputation != null)
				msgs = ((InternalEObject)newComputation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.BEHAVIOR__COMPUTATION, null, msgs);
			msgs = basicSetComputation(newComputation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.BEHAVIOR__COMPUTATION, newComputation, newComputation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelOfExecution getExecution() {
		return execution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExecution(ModelOfExecution newExecution, NotificationChain msgs) {
		ModelOfExecution oldExecution = execution;
		execution = newExecution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.BEHAVIOR__EXECUTION, oldExecution, newExecution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExecution(ModelOfExecution newExecution) {
		if (newExecution != execution) {
			NotificationChain msgs = null;
			if (execution != null)
				msgs = ((InternalEObject)execution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.BEHAVIOR__EXECUTION, null, msgs);
			if (newExecution != null)
				msgs = ((InternalEObject)newExecution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.BEHAVIOR__EXECUTION, null, msgs);
			msgs = basicSetExecution(newExecution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.BEHAVIOR__EXECUTION, newExecution, newExecution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelOfInteraction getInteraction() {
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteraction(ModelOfInteraction newInteraction, NotificationChain msgs) {
		ModelOfInteraction oldInteraction = interaction;
		interaction = newInteraction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.BEHAVIOR__INTERACTION, oldInteraction, newInteraction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInteraction(ModelOfInteraction newInteraction) {
		if (newInteraction != interaction) {
			NotificationChain msgs = null;
			if (interaction != null)
				msgs = ((InternalEObject)interaction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.BEHAVIOR__INTERACTION, null, msgs);
			if (newInteraction != null)
				msgs = ((InternalEObject)newInteraction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.BEHAVIOR__INTERACTION, null, msgs);
			msgs = basicSetInteraction(newInteraction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.BEHAVIOR__INTERACTION, newInteraction, newInteraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.BEHAVIOR__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.BEHAVIOR__COMPUTATION:
				return basicSetComputation(null, msgs);
			case InfrastructurePackage.BEHAVIOR__EXECUTION:
				return basicSetExecution(null, msgs);
			case InfrastructurePackage.BEHAVIOR__INTERACTION:
				return basicSetInteraction(null, msgs);
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
			case InfrastructurePackage.BEHAVIOR__PARAMETER:
				return getParameter();
			case InfrastructurePackage.BEHAVIOR__COMPUTATION:
				return getComputation();
			case InfrastructurePackage.BEHAVIOR__EXECUTION:
				return getExecution();
			case InfrastructurePackage.BEHAVIOR__INTERACTION:
				return getInteraction();
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
			case InfrastructurePackage.BEHAVIOR__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case InfrastructurePackage.BEHAVIOR__COMPUTATION:
				setComputation((ModelOfComputation)newValue);
				return;
			case InfrastructurePackage.BEHAVIOR__EXECUTION:
				setExecution((ModelOfExecution)newValue);
				return;
			case InfrastructurePackage.BEHAVIOR__INTERACTION:
				setInteraction((ModelOfInteraction)newValue);
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
			case InfrastructurePackage.BEHAVIOR__PARAMETER:
				getParameter().clear();
				return;
			case InfrastructurePackage.BEHAVIOR__COMPUTATION:
				setComputation((ModelOfComputation)null);
				return;
			case InfrastructurePackage.BEHAVIOR__EXECUTION:
				setExecution((ModelOfExecution)null);
				return;
			case InfrastructurePackage.BEHAVIOR__INTERACTION:
				setInteraction((ModelOfInteraction)null);
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
			case InfrastructurePackage.BEHAVIOR__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case InfrastructurePackage.BEHAVIOR__COMPUTATION:
				return computation != null;
			case InfrastructurePackage.BEHAVIOR__EXECUTION:
				return execution != null;
			case InfrastructurePackage.BEHAVIOR__INTERACTION:
				return interaction != null;
		}
		return super.eIsSet(featureID);
	}

} //BehaviorImpl
