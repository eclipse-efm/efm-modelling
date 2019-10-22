/**
 * Copyright (c) 2018 CEA LIST.
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
package org.eclipse.efm.ecore.formalml.datatype;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.EnumerationType#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.EnumerationType#getSuperType <em>Super Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getEnumerationType()
 * @model
 * @generated
 */
public interface EnumerationType extends DataType {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getEnumerationType_Literal()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumerationLiteral> getLiteral();

	/**
	 * Returns the value of the '<em><b>Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Type</em>' reference.
	 * @see #setSuperType(EnumerationType)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getEnumerationType_SuperType()
	 * @model
	 * @generated
	 */
	EnumerationType getSuperType();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.EnumerationType#getSuperType <em>Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Type</em>' reference.
	 * @see #getSuperType()
	 * @generated
	 */
	void setSuperType(EnumerationType value);

} // EnumerationType
