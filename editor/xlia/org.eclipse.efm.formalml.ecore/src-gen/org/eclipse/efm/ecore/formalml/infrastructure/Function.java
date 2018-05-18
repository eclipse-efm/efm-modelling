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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Function#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Function#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends PropertyDefinition {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getFunction_Argument()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getArgument();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getFunction_Result()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getResult();

} // Function
