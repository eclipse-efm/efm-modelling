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
package org.eclipse.efm.ecore.formalml.datatype;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Supported Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.DataSupportedType#getSupport <em>Support</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataSupportedType()
 * @model abstract="true"
 * @generated
 */
public interface DataSupportedType extends DataType {
	/**
	 * Returns the value of the '<em><b>Support</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Support</em>' containment reference.
	 * @see #setSupport(DataType)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataSupportedType_Support()
	 * @model containment="true"
	 * @generated
	 */
	DataType getSupport();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.DataSupportedType#getSupport <em>Support</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support</em>' containment reference.
	 * @see #getSupport()
	 * @generated
	 */
	void setSupport(DataType value);

} // DataSupportedType
