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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.papyrus.xtext.transition.TransitionFactory
 * @model kind="package"
 * @generated
 */
public interface TransitionPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "transition";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/efm/papyrus/xtext/Transition";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "transition";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TransitionPackage eINSTANCE = org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.TransitionRuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionRuleImpl
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getTransitionRule()
   * @generated
   */
  int TRANSITION_RULE = 0;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_RULE__TRIGGERS = 0;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_RULE__GUARD = 1;

  /**
   * The feature id for the '<em><b>Tguard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_RULE__TGUARD = 2;

  /**
   * The feature id for the '<em><b>Effect Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_RULE__EFFECT_BODY = 3;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_RULE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.TriggerRuleImpl <em>Trigger Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TriggerRuleImpl
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getTriggerRule()
   * @generated
   */
  int TRIGGER_RULE = 1;

  /**
   * The feature id for the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_RULE__PORT = 0;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_RULE__EVENT = 1;

  /**
   * The number of structural features of the '<em>Trigger Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.EventRuleImpl <em>Event Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.EventRuleImpl
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getEventRule()
   * @generated
   */
  int EVENT_RULE = 2;

  /**
   * The number of structural features of the '<em>Event Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RULE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.ReceiveSignalEventRuleImpl <em>Receive Signal Event Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.ReceiveSignalEventRuleImpl
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getReceiveSignalEventRule()
   * @generated
   */
  int RECEIVE_SIGNAL_EVENT_RULE = 3;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_SIGNAL_EVENT_RULE__PARAMETERS = EVENT_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Receive Signal Event Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_SIGNAL_EVENT_RULE_FEATURE_COUNT = EVENT_RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.GuardRuleImpl <em>Guard Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.GuardRuleImpl
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getGuardRule()
   * @generated
   */
  int GUARD_RULE = 4;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_RULE__CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>Guard Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.TGuardRuleImpl <em>TGuard Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TGuardRuleImpl
   * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getTGuardRule()
   * @generated
   */
  int TGUARD_RULE = 5;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TGUARD_RULE__CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>TGuard Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TGUARD_RULE_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionRule
   * @generated
   */
  EClass getTransitionRule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getTriggers()
   * @see #getTransitionRule()
   * @generated
   */
  EReference getTransitionRule_Triggers();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getGuard()
   * @see #getTransitionRule()
   * @generated
   */
  EReference getTransitionRule_Guard();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getTguard <em>Tguard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tguard</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getTguard()
   * @see #getTransitionRule()
   * @generated
   */
  EReference getTransitionRule_Tguard();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getEffectBody <em>Effect Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Effect Body</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionRule#getEffectBody()
   * @see #getTransitionRule()
   * @generated
   */
  EAttribute getTransitionRule_EffectBody();

  /**
   * Returns the meta object for class '{@link org.eclipse.efm.papyrus.xtext.transition.TriggerRule <em>Trigger Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger Rule</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TriggerRule
   * @generated
   */
  EClass getTriggerRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.efm.papyrus.xtext.transition.TriggerRule#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Port</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TriggerRule#getPort()
   * @see #getTriggerRule()
   * @generated
   */
  EReference getTriggerRule_Port();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.efm.papyrus.xtext.transition.TriggerRule#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TriggerRule#getEvent()
   * @see #getTriggerRule()
   * @generated
   */
  EReference getTriggerRule_Event();

  /**
   * Returns the meta object for class '{@link org.eclipse.efm.papyrus.xtext.transition.EventRule <em>Event Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Rule</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.EventRule
   * @generated
   */
  EClass getEventRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.efm.papyrus.xtext.transition.ReceiveSignalEventRule <em>Receive Signal Event Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Receive Signal Event Rule</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.ReceiveSignalEventRule
   * @generated
   */
  EClass getReceiveSignalEventRule();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.efm.papyrus.xtext.transition.ReceiveSignalEventRule#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Parameters</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.ReceiveSignalEventRule#getParameters()
   * @see #getReceiveSignalEventRule()
   * @generated
   */
  EReference getReceiveSignalEventRule_Parameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.efm.papyrus.xtext.transition.GuardRule <em>Guard Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard Rule</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.GuardRule
   * @generated
   */
  EClass getGuardRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.efm.papyrus.xtext.transition.GuardRule#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.GuardRule#getConstraint()
   * @see #getGuardRule()
   * @generated
   */
  EAttribute getGuardRule_Constraint();

  /**
   * Returns the meta object for class '{@link org.eclipse.efm.papyrus.xtext.transition.TGuardRule <em>TGuard Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TGuard Rule</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TGuardRule
   * @generated
   */
  EClass getTGuardRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.efm.papyrus.xtext.transition.TGuardRule#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint</em>'.
   * @see org.eclipse.efm.papyrus.xtext.transition.TGuardRule#getConstraint()
   * @see #getTGuardRule()
   * @generated
   */
  EAttribute getTGuardRule_Constraint();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TransitionFactory getTransitionFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.TransitionRuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionRuleImpl
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getTransitionRule()
     * @generated
     */
    EClass TRANSITION_RULE = eINSTANCE.getTransitionRule();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_RULE__TRIGGERS = eINSTANCE.getTransitionRule_Triggers();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_RULE__GUARD = eINSTANCE.getTransitionRule_Guard();

    /**
     * The meta object literal for the '<em><b>Tguard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_RULE__TGUARD = eINSTANCE.getTransitionRule_Tguard();

    /**
     * The meta object literal for the '<em><b>Effect Body</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION_RULE__EFFECT_BODY = eINSTANCE.getTransitionRule_EffectBody();

    /**
     * The meta object literal for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.TriggerRuleImpl <em>Trigger Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TriggerRuleImpl
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getTriggerRule()
     * @generated
     */
    EClass TRIGGER_RULE = eINSTANCE.getTriggerRule();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_RULE__PORT = eINSTANCE.getTriggerRule_Port();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_RULE__EVENT = eINSTANCE.getTriggerRule_Event();

    /**
     * The meta object literal for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.EventRuleImpl <em>Event Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.EventRuleImpl
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getEventRule()
     * @generated
     */
    EClass EVENT_RULE = eINSTANCE.getEventRule();

    /**
     * The meta object literal for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.ReceiveSignalEventRuleImpl <em>Receive Signal Event Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.ReceiveSignalEventRuleImpl
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getReceiveSignalEventRule()
     * @generated
     */
    EClass RECEIVE_SIGNAL_EVENT_RULE = eINSTANCE.getReceiveSignalEventRule();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECEIVE_SIGNAL_EVENT_RULE__PARAMETERS = eINSTANCE.getReceiveSignalEventRule_Parameters();

    /**
     * The meta object literal for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.GuardRuleImpl <em>Guard Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.GuardRuleImpl
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getGuardRule()
     * @generated
     */
    EClass GUARD_RULE = eINSTANCE.getGuardRule();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GUARD_RULE__CONSTRAINT = eINSTANCE.getGuardRule_Constraint();

    /**
     * The meta object literal for the '{@link org.eclipse.efm.papyrus.xtext.transition.impl.TGuardRuleImpl <em>TGuard Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TGuardRuleImpl
     * @see org.eclipse.efm.papyrus.xtext.transition.impl.TransitionPackageImpl#getTGuardRule()
     * @generated
     */
    EClass TGUARD_RULE = eINSTANCE.getTGuardRule();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TGUARD_RULE__CONSTRAINT = eINSTANCE.getTGuardRule_Constraint();

  }

} //TransitionPackage
