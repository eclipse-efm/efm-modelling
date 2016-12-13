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
import org.eclipse.efm.papyrus.xtext.transition.TransitionPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EventRuleImpl extends MinimalEObjectImpl.Container implements EventRule
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventRuleImpl()
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
    return TransitionPackage.Literals.EVENT_RULE;
  }

} //EventRuleImpl
