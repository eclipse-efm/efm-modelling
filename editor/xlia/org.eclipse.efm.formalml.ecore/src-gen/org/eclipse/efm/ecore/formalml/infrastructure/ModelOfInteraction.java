/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.infrastructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Of Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction#getRoutes <em>Routes</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction#getConnections <em>Connections</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfInteraction()
 * @model
 * @generated
 */
public interface ModelOfInteraction extends EObject {
	/**
	 * Returns the value of the '<em><b>Routes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Route}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routes</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfInteraction_Routes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Route> getRoutes();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Connector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getModelOfInteraction_Connections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Connector> getConnections();

} // ModelOfInteraction
