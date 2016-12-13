/**
 * ****************************************************************************
 * * Copyright (c) 2016 CEA LIST.
 * *
 * * All rights reserved. This program and the accompanying materials
 * * are made available under the terms of the Eclipse Public License v1.0
 * * which accompanies this distribution, and is available at
 * * http://www.eclipse.org/legal/epl-v10.html
 * *
 * * Contributors:
 * *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 * *  - Initial API and implementation
 * ****************************************************************************
 */
package org.eclipse.efm.papyrus.xtext.transition.impl;

import java.util.Collection;

import org.eclipse.efm.papyrus.xtext.transition.GuardRule;
import org.eclipse.efm.papyrus.xtext.transition.TGuardRule;
import org.eclipse.efm.papyrus.xtext.transition.TransitionPackage;
import org.eclipse.efm.papyrus.xtext.transition.TransitionRule;
import org.eclipse.efm.papyrus.xtext.transition.TriggerRule;

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
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.impl.TransitionRuleImpl#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.impl.TransitionRuleImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.impl.TransitionRuleImpl#getTguard <em>Tguard</em>}</li>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.impl.TransitionRuleImpl#getEffectBody <em>Effect Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionRuleImpl extends MinimalEObjectImpl.Container implements TransitionRule
{
  /**
   * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggers()
   * @generated
   * @ordered
   */
  protected EList<TriggerRule> triggers;

  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected GuardRule guard;

  /**
   * The cached value of the '{@link #getTguard() <em>Tguard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTguard()
   * @generated
   * @ordered
   */
  protected TGuardRule tguard;

  /**
   * The default value of the '{@link #getEffectBody() <em>Effect Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffectBody()
   * @generated
   * @ordered
   */
  protected static final String EFFECT_BODY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEffectBody() <em>Effect Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffectBody()
   * @generated
   * @ordered
   */
  protected String effectBody = EFFECT_BODY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionRuleImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TransitionPackage.Literals.TRANSITION_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TriggerRule> getTriggers()
  {
    if (triggers == null)
    {
      triggers = new EObjectContainmentEList<TriggerRule>(TriggerRule.class, this, TransitionPackage.TRANSITION_RULE__TRIGGERS);
    }
    return triggers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GuardRule getGuard()
  {
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuard(GuardRule newGuard, NotificationChain msgs)
  {
    GuardRule oldGuard = guard;
    guard = newGuard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransitionPackage.TRANSITION_RULE__GUARD, oldGuard, newGuard);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuard(GuardRule newGuard)
  {
    if (newGuard != guard)
    {
      NotificationChain msgs = null;
      if (guard != null)
        msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransitionPackage.TRANSITION_RULE__GUARD, null, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransitionPackage.TRANSITION_RULE__GUARD, null, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TransitionPackage.TRANSITION_RULE__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TGuardRule getTguard()
  {
    return tguard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTguard(TGuardRule newTguard, NotificationChain msgs)
  {
    TGuardRule oldTguard = tguard;
    tguard = newTguard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransitionPackage.TRANSITION_RULE__TGUARD, oldTguard, newTguard);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTguard(TGuardRule newTguard)
  {
    if (newTguard != tguard)
    {
      NotificationChain msgs = null;
      if (tguard != null)
        msgs = ((InternalEObject)tguard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransitionPackage.TRANSITION_RULE__TGUARD, null, msgs);
      if (newTguard != null)
        msgs = ((InternalEObject)newTguard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransitionPackage.TRANSITION_RULE__TGUARD, null, msgs);
      msgs = basicSetTguard(newTguard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TransitionPackage.TRANSITION_RULE__TGUARD, newTguard, newTguard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEffectBody()
  {
    return effectBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEffectBody(String newEffectBody)
  {
    String oldEffectBody = effectBody;
    effectBody = newEffectBody;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TransitionPackage.TRANSITION_RULE__EFFECT_BODY, oldEffectBody, effectBody));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TransitionPackage.TRANSITION_RULE__TRIGGERS:
        return ((InternalEList<?>)getTriggers()).basicRemove(otherEnd, msgs);
      case TransitionPackage.TRANSITION_RULE__GUARD:
        return basicSetGuard(null, msgs);
      case TransitionPackage.TRANSITION_RULE__TGUARD:
        return basicSetTguard(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TransitionPackage.TRANSITION_RULE__TRIGGERS:
        return getTriggers();
      case TransitionPackage.TRANSITION_RULE__GUARD:
        return getGuard();
      case TransitionPackage.TRANSITION_RULE__TGUARD:
        return getTguard();
      case TransitionPackage.TRANSITION_RULE__EFFECT_BODY:
        return getEffectBody();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TransitionPackage.TRANSITION_RULE__TRIGGERS:
        getTriggers().clear();
        getTriggers().addAll((Collection<? extends TriggerRule>)newValue);
        return;
      case TransitionPackage.TRANSITION_RULE__GUARD:
        setGuard((GuardRule)newValue);
        return;
      case TransitionPackage.TRANSITION_RULE__TGUARD:
        setTguard((TGuardRule)newValue);
        return;
      case TransitionPackage.TRANSITION_RULE__EFFECT_BODY:
        setEffectBody((String)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TransitionPackage.TRANSITION_RULE__TRIGGERS:
        getTriggers().clear();
        return;
      case TransitionPackage.TRANSITION_RULE__GUARD:
        setGuard((GuardRule)null);
        return;
      case TransitionPackage.TRANSITION_RULE__TGUARD:
        setTguard((TGuardRule)null);
        return;
      case TransitionPackage.TRANSITION_RULE__EFFECT_BODY:
        setEffectBody(EFFECT_BODY_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TransitionPackage.TRANSITION_RULE__TRIGGERS:
        return triggers != null && !triggers.isEmpty();
      case TransitionPackage.TRANSITION_RULE__GUARD:
        return guard != null;
      case TransitionPackage.TRANSITION_RULE__TGUARD:
        return tguard != null;
      case TransitionPackage.TRANSITION_RULE__EFFECT_BODY:
        return EFFECT_BODY_EDEFAULT == null ? effectBody != null : !EFFECT_BODY_EDEFAULT.equals(effectBody);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (effectBody: ");
    result.append(effectBody);
    result.append(')');
    return result.toString();
  }

} //TransitionRuleImpl
