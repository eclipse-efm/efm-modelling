/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.modeling.formalml;

import org.eclipse.uml2.uml.AnyReceiveEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive Any Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.modeling.formalml.ReceiveAnyEvent#getBaseAnyReceiveEvent <em>Base Any Receive Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getReceiveAnyEvent()
 * @model
 * @generated
 */
public interface ReceiveAnyEvent extends ReceiveEvent {
	/**
	 * Returns the value of the '<em><b>Base Any Receive Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Any Receive Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Any Receive Event</em>' reference.
	 * @see #setBaseAnyReceiveEvent(AnyReceiveEvent)
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getReceiveAnyEvent_BaseAnyReceiveEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AnyReceiveEvent getBaseAnyReceiveEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.modeling.formalml.ReceiveAnyEvent#getBaseAnyReceiveEvent <em>Base Any Receive Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Any Receive Event</em>' reference.
	 * @see #getBaseAnyReceiveEvent()
	 * @generated
	 */
	void setBaseAnyReceiveEvent(AnyReceiveEvent value);

} // ReceiveAnyEvent
