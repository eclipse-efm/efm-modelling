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

import org.eclipse.efm.papyrus.xtext.transition.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransitionFactoryImpl extends EFactoryImpl implements TransitionFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TransitionFactory init()
  {
    try
    {
      TransitionFactory theTransitionFactory = (TransitionFactory)EPackage.Registry.INSTANCE.getEFactory(TransitionPackage.eNS_URI);
      if (theTransitionFactory != null)
      {
        return theTransitionFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TransitionFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TransitionPackage.TRANSITION_RULE: return createTransitionRule();
      case TransitionPackage.TRIGGER_RULE: return createTriggerRule();
      case TransitionPackage.EVENT_RULE: return createEventRule();
      case TransitionPackage.RECEIVE_SIGNAL_EVENT_RULE: return createReceiveSignalEventRule();
      case TransitionPackage.GUARD_RULE: return createGuardRule();
      case TransitionPackage.TGUARD_RULE: return createTGuardRule();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRule createTransitionRule()
  {
    TransitionRuleImpl transitionRule = new TransitionRuleImpl();
    return transitionRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerRule createTriggerRule()
  {
    TriggerRuleImpl triggerRule = new TriggerRuleImpl();
    return triggerRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventRule createEventRule()
  {
    EventRuleImpl eventRule = new EventRuleImpl();
    return eventRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReceiveSignalEventRule createReceiveSignalEventRule()
  {
    ReceiveSignalEventRuleImpl receiveSignalEventRule = new ReceiveSignalEventRuleImpl();
    return receiveSignalEventRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GuardRule createGuardRule()
  {
    GuardRuleImpl guardRule = new GuardRuleImpl();
    return guardRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TGuardRule createTGuardRule()
  {
    TGuardRuleImpl tGuardRule = new TGuardRuleImpl();
    return tGuardRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionPackage getTransitionPackage()
  {
    return (TransitionPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TransitionPackage getPackage()
  {
    return TransitionPackage.eINSTANCE;
  }

} //TransitionFactoryImpl
