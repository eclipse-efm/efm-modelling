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
package org.eclipse.efm.papyrus.xtext.transition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getTguard <em>Tguard</em>}</li>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getEffectBody <em>Effect Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getTransitionRule()
 * @model
 * @generated
 */
public interface TransitionRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.efm.papyrus.xtext.transition.TriggerRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getTransitionRule_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<TriggerRule> getTriggers();

  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(GuardRule)
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getTransitionRule_Guard()
   * @model containment="true"
   * @generated
   */
  GuardRule getGuard();

  /**
   * Sets the value of the '{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(GuardRule value);

  /**
   * Returns the value of the '<em><b>Tguard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tguard</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tguard</em>' containment reference.
   * @see #setTguard(TGuardRule)
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getTransitionRule_Tguard()
   * @model containment="true"
   * @generated
   */
  TGuardRule getTguard();

  /**
   * Sets the value of the '{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getTguard <em>Tguard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tguard</em>' containment reference.
   * @see #getTguard()
   * @generated
   */
  void setTguard(TGuardRule value);

  /**
   * Returns the value of the '<em><b>Effect Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Effect Body</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Effect Body</em>' attribute.
   * @see #setEffectBody(String)
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getTransitionRule_EffectBody()
   * @model
   * @generated
   */
  String getEffectBody();

  /**
   * Sets the value of the '{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getEffectBody <em>Effect Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Effect Body</em>' attribute.
   * @see #getEffectBody()
   * @generated
   */
  void setEffectBody(String value);

} // TransitionRule
