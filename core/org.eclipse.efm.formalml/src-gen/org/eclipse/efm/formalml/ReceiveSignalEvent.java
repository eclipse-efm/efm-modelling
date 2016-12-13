/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml;

import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive Signal Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.formalml.ReceiveSignalEvent#getBase_AnyReceiveEvent <em>Base Any Receive Event</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.ReceiveSignalEvent#getBase_SignalEvent <em>Base Signal Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.formalml.formalmlPackage#getReceiveSignalEvent()
 * @model
 * @generated
 */
public interface ReceiveSignalEvent extends ReceiveEvent {
	/**
	 * Returns the value of the '<em><b>Base Any Receive Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Any Receive Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Any Receive Event</em>' reference.
	 * @see #setBase_AnyReceiveEvent(AnyReceiveEvent)
	 * @see org.eclipse.efm.formalml.formalmlPackage#getReceiveSignalEvent_Base_AnyReceiveEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AnyReceiveEvent getBase_AnyReceiveEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.ReceiveSignalEvent#getBase_AnyReceiveEvent <em>Base Any Receive Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Any Receive Event</em>' reference.
	 * @see #getBase_AnyReceiveEvent()
	 * @generated
	 */
	void setBase_AnyReceiveEvent(AnyReceiveEvent value);

	/**
	 * Returns the value of the '<em><b>Base Signal Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Signal Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Signal Event</em>' reference.
	 * @see #setBase_SignalEvent(SignalEvent)
	 * @see org.eclipse.efm.formalml.formalmlPackage#getReceiveSignalEvent_Base_SignalEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SignalEvent getBase_SignalEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.ReceiveSignalEvent#getBase_SignalEvent <em>Base Signal Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Signal Event</em>' reference.
	 * @see #getBase_SignalEvent()
	 * @generated
	 */
	void setBase_SignalEvent(SignalEvent value);

} // ReceiveSignalEvent
