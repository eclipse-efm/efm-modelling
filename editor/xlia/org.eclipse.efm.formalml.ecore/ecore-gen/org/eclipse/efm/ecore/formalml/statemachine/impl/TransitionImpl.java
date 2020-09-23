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
package org.eclipse.efm.ecore.formalml.statemachine.impl;

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.common.impl.NamedElementImpl;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage;
import org.eclipse.efm.ecore.formalml.statemachine.Transition;
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe;
import org.eclipse.efm.ecore.formalml.statemachine.Vertex;

import org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.InputComStatement;
import org.eclipse.efm.ecore.formalml.statement.Statement;
import org.eclipse.efm.ecore.formalml.statement.TimedGuardStatement;

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
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#getMoe <em>Moe</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#getTguard <em>Tguard</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#getEffect <em>Effect</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.impl.TransitionImpl#getTargetExpression <em>Target Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends NamedElementImpl implements Transition {
	/**
	 * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean transient_ = TRANSIENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMoe() <em>Moe</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoe()
	 * @generated
	 * @ordered
	 */
	protected TransitionMoe moe;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Vertex target;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected BlockStatement behavior;

	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected EList<InputComStatement> trigger;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected AbstractGuardStatement guard;

	/**
	 * The cached value of the '{@link #getTguard() <em>Tguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTguard()
	 * @generated
	 * @ordered
	 */
	protected TimedGuardStatement tguard;

	/**
	 * The cached value of the '{@link #getEffect() <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffect()
	 * @generated
	 * @ordered
	 */
	protected Statement effect;

	/**
	 * The cached value of the '{@link #getTargetExpression() <em>Target Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression targetExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinePackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTransient() {
		return transient_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransient(boolean newTransient) {
		boolean oldTransient = transient_;
		transient_ = newTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__TRANSIENT, oldTransient, transient_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransitionMoe getMoe() {
		return moe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMoe(TransitionMoe newMoe, NotificationChain msgs) {
		TransitionMoe oldMoe = moe;
		moe = newMoe;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__MOE, oldMoe, newMoe);
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
	public void setMoe(TransitionMoe newMoe) {
		if (newMoe != moe) {
			NotificationChain msgs = null;
			if (moe != null)
				msgs = ((InternalEObject)moe).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__MOE, null, msgs);
			if (newMoe != null)
				msgs = ((InternalEObject)newMoe).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__MOE, null, msgs);
			msgs = basicSetMoe(newMoe, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__MOE, newMoe, newMoe));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vertex getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(Vertex newTarget) {
		Vertex oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockStatement getBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehavior(BlockStatement newBehavior, NotificationChain msgs) {
		BlockStatement oldBehavior = behavior;
		behavior = newBehavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__BEHAVIOR, oldBehavior, newBehavior);
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
	public void setBehavior(BlockStatement newBehavior) {
		if (newBehavior != behavior) {
			NotificationChain msgs = null;
			if (behavior != null)
				msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__BEHAVIOR, null, msgs);
			if (newBehavior != null)
				msgs = ((InternalEObject)newBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__BEHAVIOR, null, msgs);
			msgs = basicSetBehavior(newBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__BEHAVIOR, newBehavior, newBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InputComStatement> getTrigger() {
		if (trigger == null) {
			trigger = new EObjectContainmentEList<InputComStatement>(InputComStatement.class, this, StatemachinePackage.TRANSITION__TRIGGER);
		}
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractGuardStatement getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuard(AbstractGuardStatement newGuard, NotificationChain msgs) {
		AbstractGuardStatement oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__GUARD, oldGuard, newGuard);
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
	public void setGuard(AbstractGuardStatement newGuard) {
		if (newGuard != guard) {
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimedGuardStatement getTguard() {
		return tguard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTguard(TimedGuardStatement newTguard, NotificationChain msgs) {
		TimedGuardStatement oldTguard = tguard;
		tguard = newTguard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__TGUARD, oldTguard, newTguard);
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
	public void setTguard(TimedGuardStatement newTguard) {
		if (newTguard != tguard) {
			NotificationChain msgs = null;
			if (tguard != null)
				msgs = ((InternalEObject)tguard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__TGUARD, null, msgs);
			if (newTguard != null)
				msgs = ((InternalEObject)newTguard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__TGUARD, null, msgs);
			msgs = basicSetTguard(newTguard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__TGUARD, newTguard, newTguard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Statement getEffect() {
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEffect(Statement newEffect, NotificationChain msgs) {
		Statement oldEffect = effect;
		effect = newEffect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__EFFECT, oldEffect, newEffect);
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
	public void setEffect(Statement newEffect) {
		if (newEffect != effect) {
			NotificationChain msgs = null;
			if (effect != null)
				msgs = ((InternalEObject)effect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__EFFECT, null, msgs);
			if (newEffect != null)
				msgs = ((InternalEObject)newEffect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__EFFECT, null, msgs);
			msgs = basicSetEffect(newEffect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__EFFECT, newEffect, newEffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getTargetExpression() {
		return targetExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetExpression(Expression newTargetExpression, NotificationChain msgs) {
		Expression oldTargetExpression = targetExpression;
		targetExpression = newTargetExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__TARGET_EXPRESSION, oldTargetExpression, newTargetExpression);
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
	public void setTargetExpression(Expression newTargetExpression) {
		if (newTargetExpression != targetExpression) {
			NotificationChain msgs = null;
			if (targetExpression != null)
				msgs = ((InternalEObject)targetExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__TARGET_EXPRESSION, null, msgs);
			if (newTargetExpression != null)
				msgs = ((InternalEObject)newTargetExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatemachinePackage.TRANSITION__TARGET_EXPRESSION, null, msgs);
			msgs = basicSetTargetExpression(newTargetExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinePackage.TRANSITION__TARGET_EXPRESSION, newTargetExpression, newTargetExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatemachinePackage.TRANSITION__MOE:
				return basicSetMoe(null, msgs);
			case StatemachinePackage.TRANSITION__BEHAVIOR:
				return basicSetBehavior(null, msgs);
			case StatemachinePackage.TRANSITION__TRIGGER:
				return ((InternalEList<?>)getTrigger()).basicRemove(otherEnd, msgs);
			case StatemachinePackage.TRANSITION__GUARD:
				return basicSetGuard(null, msgs);
			case StatemachinePackage.TRANSITION__TGUARD:
				return basicSetTguard(null, msgs);
			case StatemachinePackage.TRANSITION__EFFECT:
				return basicSetEffect(null, msgs);
			case StatemachinePackage.TRANSITION__TARGET_EXPRESSION:
				return basicSetTargetExpression(null, msgs);
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
			case StatemachinePackage.TRANSITION__TRANSIENT:
				return isTransient();
			case StatemachinePackage.TRANSITION__MOE:
				return getMoe();
			case StatemachinePackage.TRANSITION__TARGET:
				return getTarget();
			case StatemachinePackage.TRANSITION__BEHAVIOR:
				return getBehavior();
			case StatemachinePackage.TRANSITION__TRIGGER:
				return getTrigger();
			case StatemachinePackage.TRANSITION__GUARD:
				return getGuard();
			case StatemachinePackage.TRANSITION__TGUARD:
				return getTguard();
			case StatemachinePackage.TRANSITION__EFFECT:
				return getEffect();
			case StatemachinePackage.TRANSITION__TARGET_EXPRESSION:
				return getTargetExpression();
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
			case StatemachinePackage.TRANSITION__TRANSIENT:
				setTransient((Boolean)newValue);
				return;
			case StatemachinePackage.TRANSITION__MOE:
				setMoe((TransitionMoe)newValue);
				return;
			case StatemachinePackage.TRANSITION__TARGET:
				setTarget((Vertex)newValue);
				return;
			case StatemachinePackage.TRANSITION__BEHAVIOR:
				setBehavior((BlockStatement)newValue);
				return;
			case StatemachinePackage.TRANSITION__TRIGGER:
				getTrigger().clear();
				getTrigger().addAll((Collection<? extends InputComStatement>)newValue);
				return;
			case StatemachinePackage.TRANSITION__GUARD:
				setGuard((AbstractGuardStatement)newValue);
				return;
			case StatemachinePackage.TRANSITION__TGUARD:
				setTguard((TimedGuardStatement)newValue);
				return;
			case StatemachinePackage.TRANSITION__EFFECT:
				setEffect((Statement)newValue);
				return;
			case StatemachinePackage.TRANSITION__TARGET_EXPRESSION:
				setTargetExpression((Expression)newValue);
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
			case StatemachinePackage.TRANSITION__TRANSIENT:
				setTransient(TRANSIENT_EDEFAULT);
				return;
			case StatemachinePackage.TRANSITION__MOE:
				setMoe((TransitionMoe)null);
				return;
			case StatemachinePackage.TRANSITION__TARGET:
				setTarget((Vertex)null);
				return;
			case StatemachinePackage.TRANSITION__BEHAVIOR:
				setBehavior((BlockStatement)null);
				return;
			case StatemachinePackage.TRANSITION__TRIGGER:
				getTrigger().clear();
				return;
			case StatemachinePackage.TRANSITION__GUARD:
				setGuard((AbstractGuardStatement)null);
				return;
			case StatemachinePackage.TRANSITION__TGUARD:
				setTguard((TimedGuardStatement)null);
				return;
			case StatemachinePackage.TRANSITION__EFFECT:
				setEffect((Statement)null);
				return;
			case StatemachinePackage.TRANSITION__TARGET_EXPRESSION:
				setTargetExpression((Expression)null);
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
			case StatemachinePackage.TRANSITION__TRANSIENT:
				return transient_ != TRANSIENT_EDEFAULT;
			case StatemachinePackage.TRANSITION__MOE:
				return moe != null;
			case StatemachinePackage.TRANSITION__TARGET:
				return target != null;
			case StatemachinePackage.TRANSITION__BEHAVIOR:
				return behavior != null;
			case StatemachinePackage.TRANSITION__TRIGGER:
				return trigger != null && !trigger.isEmpty();
			case StatemachinePackage.TRANSITION__GUARD:
				return guard != null;
			case StatemachinePackage.TRANSITION__TGUARD:
				return tguard != null;
			case StatemachinePackage.TRANSITION__EFFECT:
				return effect != null;
			case StatemachinePackage.TRANSITION__TARGET_EXPRESSION:
				return targetExpression != null;
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
		result.append(" (transient: ");
		result.append(transient_);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
