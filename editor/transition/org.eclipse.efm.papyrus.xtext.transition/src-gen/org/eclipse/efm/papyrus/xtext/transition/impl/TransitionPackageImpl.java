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

import org.eclipse.efm.papyrus.xtext.transition.EventRule;
import org.eclipse.efm.papyrus.xtext.transition.GuardRule;
import org.eclipse.efm.papyrus.xtext.transition.ReceiveSignalEventRule;
import org.eclipse.efm.papyrus.xtext.transition.TGuardRule;
import org.eclipse.efm.papyrus.xtext.transition.TransitionFactory;
import org.eclipse.efm.papyrus.xtext.transition.TransitionPackage;
import org.eclipse.efm.papyrus.xtext.transition.TransitionRule;
import org.eclipse.efm.papyrus.xtext.transition.TriggerRule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransitionPackageImpl extends EPackageImpl implements TransitionPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggerRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass receiveSignalEventRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tGuardRuleEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TransitionPackageImpl()
  {
    super(eNS_URI, TransitionFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link TransitionPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TransitionPackage init()
  {
    if (isInited) return (TransitionPackage)EPackage.Registry.INSTANCE.getEPackage(TransitionPackage.eNS_URI);

    // Obtain or create and register package
    TransitionPackageImpl theTransitionPackage = (TransitionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TransitionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TransitionPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    UMLPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTransitionPackage.createPackageContents();

    // Initialize created meta-data
    theTransitionPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTransitionPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TransitionPackage.eNS_URI, theTransitionPackage);
    return theTransitionPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionRule()
  {
    return transitionRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionRule_Triggers()
  {
    return (EReference)transitionRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionRule_Guard()
  {
    return (EReference)transitionRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionRule_Tguard()
  {
    return (EReference)transitionRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionRule_EffectBody()
  {
    return (EAttribute)transitionRuleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTriggerRule()
  {
    return triggerRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTriggerRule_Port()
  {
    return (EReference)triggerRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTriggerRule_Event()
  {
    return (EReference)triggerRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventRule()
  {
    return eventRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReceiveSignalEventRule()
  {
    return receiveSignalEventRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReceiveSignalEventRule_Parameters()
  {
    return (EReference)receiveSignalEventRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuardRule()
  {
    return guardRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGuardRule_Constraint()
  {
    return (EAttribute)guardRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTGuardRule()
  {
    return tGuardRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTGuardRule_Constraint()
  {
    return (EAttribute)tGuardRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionFactory getTransitionFactory()
  {
    return (TransitionFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    transitionRuleEClass = createEClass(TRANSITION_RULE);
    createEReference(transitionRuleEClass, TRANSITION_RULE__TRIGGERS);
    createEReference(transitionRuleEClass, TRANSITION_RULE__GUARD);
    createEReference(transitionRuleEClass, TRANSITION_RULE__TGUARD);
    createEAttribute(transitionRuleEClass, TRANSITION_RULE__EFFECT_BODY);

    triggerRuleEClass = createEClass(TRIGGER_RULE);
    createEReference(triggerRuleEClass, TRIGGER_RULE__PORT);
    createEReference(triggerRuleEClass, TRIGGER_RULE__EVENT);

    eventRuleEClass = createEClass(EVENT_RULE);

    receiveSignalEventRuleEClass = createEClass(RECEIVE_SIGNAL_EVENT_RULE);
    createEReference(receiveSignalEventRuleEClass, RECEIVE_SIGNAL_EVENT_RULE__PARAMETERS);

    guardRuleEClass = createEClass(GUARD_RULE);
    createEAttribute(guardRuleEClass, GUARD_RULE__CONSTRAINT);

    tGuardRuleEClass = createEClass(TGUARD_RULE);
    createEAttribute(tGuardRuleEClass, TGUARD_RULE__CONSTRAINT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    receiveSignalEventRuleEClass.getESuperTypes().add(this.getEventRule());

    // Initialize classes and features; add operations and parameters
    initEClass(transitionRuleEClass, TransitionRule.class, "TransitionRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionRule_Triggers(), this.getTriggerRule(), null, "triggers", null, 0, -1, TransitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionRule_Guard(), this.getGuardRule(), null, "guard", null, 0, 1, TransitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionRule_Tguard(), this.getTGuardRule(), null, "tguard", null, 0, 1, TransitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransitionRule_EffectBody(), theEcorePackage.getEString(), "effectBody", null, 0, 1, TransitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(triggerRuleEClass, TriggerRule.class, "TriggerRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTriggerRule_Port(), theUMLPackage.getNamedElement(), null, "port", null, 0, 1, TriggerRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTriggerRule_Event(), this.getEventRule(), null, "event", null, 0, 1, TriggerRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventRuleEClass, EventRule.class, "EventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(receiveSignalEventRuleEClass, ReceiveSignalEventRule.class, "ReceiveSignalEventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReceiveSignalEventRule_Parameters(), theUMLPackage.getProperty(), null, "parameters", null, 0, -1, ReceiveSignalEventRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardRuleEClass, GuardRule.class, "GuardRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGuardRule_Constraint(), theEcorePackage.getEString(), "constraint", null, 0, 1, GuardRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tGuardRuleEClass, TGuardRule.class, "TGuardRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTGuardRule_Constraint(), theEcorePackage.getEString(), "constraint", null, 0, 1, TGuardRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TransitionPackageImpl
