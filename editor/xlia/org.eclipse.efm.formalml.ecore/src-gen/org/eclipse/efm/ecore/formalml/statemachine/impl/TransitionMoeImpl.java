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
package org.eclipse.efm.ecore.formalml.statemachine.impl;

import org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage;
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoc;
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Moe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionMoeImpl#getMoc <em>Moc</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionMoeImpl#isIsElse <em>Is Else</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionMoeImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionMoeImpl#getProbability <em>Probability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionMoeImpl extends MinimalEObjectImpl.Container implements TransitionMoe {
	/**
	 * The default value of the '{@link #getMoc() <em>Moc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoc()
	 * @generated
	 * @ordered
	 */
	protected static final TransitionMoc MOC_EDEFAULT = TransitionMoc.SIMPLE;

	/**
	 * The cached value of the '{@link #getMoc() <em>Moc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoc()
	 * @generated
	 * @ordered
	 */
	protected TransitionMoc moc = MOC_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsElse() <em>Is Else</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsElse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ELSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsElse() <em>Is Else</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsElse()
	 * @generated
	 * @ordered
	 */
	protected boolean isElse = IS_ELSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected static final float PROBABILITY_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected float probability = PROBABILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionMoeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinePackage.Literals.TRANSITION_MOE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransitionMoc getMoc() {
		return moc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMoc(TransitionMoc newMoc) {
		TransitionMoc oldMoc = moc;
		moc = newMoc == null ? MOC_EDEFAULT : newMoc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION_MOE__MOC, oldMoc, moc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsElse() {
		return isElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsElse(boolean newIsElse) {
		boolean oldIsElse = isElse;
		isElse = newIsElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION_MOE__IS_ELSE, oldIsElse, isElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION_MOE__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProbability(float newProbability) {
		float oldProbability = probability;
		probability = newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION_MOE__PROBABILITY, oldProbability, probability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatemachinePackage.TRANSITION_MOE__MOC:
				return getMoc();
			case StatemachinePackage.TRANSITION_MOE__IS_ELSE:
				return isIsElse();
			case StatemachinePackage.TRANSITION_MOE__PRIORITY:
				return getPriority();
			case StatemachinePackage.TRANSITION_MOE__PROBABILITY:
				return getProbability();
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
			case StatemachinePackage.TRANSITION_MOE__MOC:
				setMoc((TransitionMoc)newValue);
				return;
			case StatemachinePackage.TRANSITION_MOE__IS_ELSE:
				setIsElse((Boolean)newValue);
				return;
			case StatemachinePackage.TRANSITION_MOE__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case StatemachinePackage.TRANSITION_MOE__PROBABILITY:
				setProbability((Float)newValue);
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
			case StatemachinePackage.TRANSITION_MOE__MOC:
				setMoc(MOC_EDEFAULT);
				return;
			case StatemachinePackage.TRANSITION_MOE__IS_ELSE:
				setIsElse(IS_ELSE_EDEFAULT);
				return;
			case StatemachinePackage.TRANSITION_MOE__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case StatemachinePackage.TRANSITION_MOE__PROBABILITY:
				setProbability(PROBABILITY_EDEFAULT);
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
			case StatemachinePackage.TRANSITION_MOE__MOC:
				return moc != MOC_EDEFAULT;
			case StatemachinePackage.TRANSITION_MOE__IS_ELSE:
				return isElse != IS_ELSE_EDEFAULT;
			case StatemachinePackage.TRANSITION_MOE__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case StatemachinePackage.TRANSITION_MOE__PROBABILITY:
				return probability != PROBABILITY_EDEFAULT;
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
		result.append(" (moc: ");
		result.append(moc);
		result.append(", isElse: ");
		result.append(isElse);
		result.append(", priority: ");
		result.append(priority);
		result.append(", probability: ");
		result.append(probability);
		result.append(')');
		return result.toString();
	}

} //TransitionMoeImpl
