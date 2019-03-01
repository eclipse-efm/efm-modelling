/**
 * Copyright (c) 2018 CEA LIST.
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

import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.CompositePart;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.Procedure;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl#getRoutine <em>Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl#getBehavior <em>Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositePartImpl extends MinimalEObjectImpl.Container implements CompositePart {
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
	 * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected EList<Procedure> procedure;

	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected EList<Machine> machine;

	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceMachine> instance;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected EList<Behavior> behavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositePartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.COMPOSITE_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Routine> getRoutine() {
		if (routine == null) {
			routine = new EObjectContainmentEList<Routine>(Routine.class, this, InfrastructurePackage.COMPOSITE_PART__ROUTINE);
		}
		return routine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Procedure> getProcedure() {
		if (procedure == null) {
			procedure = new EObjectContainmentEList<Procedure>(Procedure.class, this, InfrastructurePackage.COMPOSITE_PART__PROCEDURE);
		}
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Machine> getMachine() {
		if (machine == null) {
			machine = new EObjectContainmentEList<Machine>(Machine.class, this, InfrastructurePackage.COMPOSITE_PART__MACHINE);
		}
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstanceMachine> getInstance() {
		if (instance == null) {
			instance = new EObjectContainmentEList<InstanceMachine>(InstanceMachine.class, this, InfrastructurePackage.COMPOSITE_PART__INSTANCE);
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Behavior> getBehavior() {
		if (behavior == null) {
			behavior = new EObjectContainmentEList<Behavior>(Behavior.class, this, InfrastructurePackage.COMPOSITE_PART__BEHAVIOR);
		}
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.COMPOSITE_PART__ROUTINE:
				return ((InternalEList<?>)getRoutine()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.COMPOSITE_PART__PROCEDURE:
				return ((InternalEList<?>)getProcedure()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.COMPOSITE_PART__MACHINE:
				return ((InternalEList<?>)getMachine()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.COMPOSITE_PART__INSTANCE:
				return ((InternalEList<?>)getInstance()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.COMPOSITE_PART__BEHAVIOR:
				return ((InternalEList<?>)getBehavior()).basicRemove(otherEnd, msgs);
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
			case InfrastructurePackage.COMPOSITE_PART__ROUTINE:
				return getRoutine();
			case InfrastructurePackage.COMPOSITE_PART__PROCEDURE:
				return getProcedure();
			case InfrastructurePackage.COMPOSITE_PART__MACHINE:
				return getMachine();
			case InfrastructurePackage.COMPOSITE_PART__INSTANCE:
				return getInstance();
			case InfrastructurePackage.COMPOSITE_PART__BEHAVIOR:
				return getBehavior();
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
			case InfrastructurePackage.COMPOSITE_PART__ROUTINE:
				getRoutine().clear();
				getRoutine().addAll((Collection<? extends Routine>)newValue);
				return;
			case InfrastructurePackage.COMPOSITE_PART__PROCEDURE:
				getProcedure().clear();
				getProcedure().addAll((Collection<? extends Procedure>)newValue);
				return;
			case InfrastructurePackage.COMPOSITE_PART__MACHINE:
				getMachine().clear();
				getMachine().addAll((Collection<? extends Machine>)newValue);
				return;
			case InfrastructurePackage.COMPOSITE_PART__INSTANCE:
				getInstance().clear();
				getInstance().addAll((Collection<? extends InstanceMachine>)newValue);
				return;
			case InfrastructurePackage.COMPOSITE_PART__BEHAVIOR:
				getBehavior().clear();
				getBehavior().addAll((Collection<? extends Behavior>)newValue);
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
			case InfrastructurePackage.COMPOSITE_PART__ROUTINE:
				getRoutine().clear();
				return;
			case InfrastructurePackage.COMPOSITE_PART__PROCEDURE:
				getProcedure().clear();
				return;
			case InfrastructurePackage.COMPOSITE_PART__MACHINE:
				getMachine().clear();
				return;
			case InfrastructurePackage.COMPOSITE_PART__INSTANCE:
				getInstance().clear();
				return;
			case InfrastructurePackage.COMPOSITE_PART__BEHAVIOR:
				getBehavior().clear();
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
			case InfrastructurePackage.COMPOSITE_PART__ROUTINE:
				return routine != null && !routine.isEmpty();
			case InfrastructurePackage.COMPOSITE_PART__PROCEDURE:
				return procedure != null && !procedure.isEmpty();
			case InfrastructurePackage.COMPOSITE_PART__MACHINE:
				return machine != null && !machine.isEmpty();
			case InfrastructurePackage.COMPOSITE_PART__INSTANCE:
				return instance != null && !instance.isEmpty();
			case InfrastructurePackage.COMPOSITE_PART__BEHAVIOR:
				return behavior != null && !behavior.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositePartImpl
