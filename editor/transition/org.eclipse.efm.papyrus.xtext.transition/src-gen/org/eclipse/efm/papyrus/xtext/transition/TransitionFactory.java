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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage
 * @generated
 */
public interface TransitionFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TransitionFactory eINSTANCE = org.eclipse.efm.papyrus.xtext.transition.impl.TransitionFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule</em>'.
   * @generated
   */
  TransitionRule createTransitionRule();

  /**
   * Returns a new object of class '<em>Trigger Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger Rule</em>'.
   * @generated
   */
  TriggerRule createTriggerRule();

  /**
   * Returns a new object of class '<em>Event Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Rule</em>'.
   * @generated
   */
  EventRule createEventRule();

  /**
   * Returns a new object of class '<em>Receive Signal Event Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Receive Signal Event Rule</em>'.
   * @generated
   */
  ReceiveSignalEventRule createReceiveSignalEventRule();

  /**
   * Returns a new object of class '<em>Guard Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard Rule</em>'.
   * @generated
   */
  GuardRule createGuardRule();

  /**
   * Returns a new object of class '<em>TGuard Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TGuard Rule</em>'.
   * @generated
   */
  TGuardRule createTGuardRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TransitionPackage getTransitionPackage();

} //TransitionFactory
