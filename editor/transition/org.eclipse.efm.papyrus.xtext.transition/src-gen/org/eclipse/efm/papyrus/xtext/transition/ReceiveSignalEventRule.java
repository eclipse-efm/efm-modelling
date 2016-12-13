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

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive Signal Event Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.papyrus.xtext.transition.ReceiveSignalEventRule#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getReceiveSignalEventRule()
 * @model
 * @generated
 */
public interface ReceiveSignalEventRule extends EventRule
{
  /**
   * Returns the value of the '<em><b>Parameters</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.uml2.uml.Property}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' reference list.
   * @see org.eclipse.efm.papyrus.xtext.transition.TransitionPackage#getReceiveSignalEventRule_Parameters()
   * @model
   * @generated
   */
  EList<Property> getParameters();

} // ReceiveSignalEventRule
