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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.TriggerRule#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.TriggerRule#getEvent <em>Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getTriggerRule()
 * @model
 * @generated
 */
public interface TriggerRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port</em>' reference.
   * @see #setPort(NamedElement)
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getTriggerRule_Port()
   * @model
   * @generated
   */
  NamedElement getPort();

  /**
   * Sets the value of the '{@link org.eclipse.efm.papyrus.xtext.transition.TriggerRule#getPort <em>Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port</em>' reference.
   * @see #getPort()
   * @generated
   */
  void setPort(NamedElement value);

  /**
   * Returns the value of the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' containment reference.
   * @see #setEvent(EventRule)
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getTriggerRule_Event()
   * @model containment="true"
   * @generated
   */
  EventRule getEvent();

  /**
   * Sets the value of the '{@link org.eclipse.efm.papyrus.xtext.transition.TriggerRule#getEvent <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' containment reference.
   * @see #getEvent()
   * @generated
   */
  void setEvent(EventRule value);

} // TriggerRule
