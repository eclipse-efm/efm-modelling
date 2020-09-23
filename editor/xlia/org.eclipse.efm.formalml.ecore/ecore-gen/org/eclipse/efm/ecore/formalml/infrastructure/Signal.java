/**
 * Copyright (c) 2020 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html\n\nContributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.infrastructure;

import org.eclipse.efm.ecore.formalml.common.ClassifierDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Signal#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Signal#getParameterSet <em>Parameter Set</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getSignal()
 * @model
 * @generated
 */
public interface Signal extends ClassifierDefinition {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The default value is <code>"inout"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection
	 * @see #setDirection(ChannelDirection)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getSignal_Direction()
	 * @model default="inout"
	 * @generated
	 */
	ChannelDirection getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Signal#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(ChannelDirection value);

	/**
	 * Returns the value of the '<em><b>Parameter Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Set</em>' containment reference.
	 * @see #setParameterSet(ParameterSet)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getSignal_ParameterSet()
	 * @model containment="true"
	 * @generated
	 */
	ParameterSet getParameterSet();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Signal#getParameterSet <em>Parameter Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Set</em>' containment reference.
	 * @see #getParameterSet()
	 * @generated
	 */
	void setParameterSet(ParameterSet value);

} // Signal
