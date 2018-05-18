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
package org.eclipse.efm.ecore.formalml.datatype;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.DataTypeReference#getTyperef <em>Typeref</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.DataTypeReference#getSupport <em>Support</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataTypeReference()
 * @model
 * @generated
 */
public interface DataTypeReference extends DataType {
	/**
	 * Returns the value of the '<em><b>Typeref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typeref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typeref</em>' reference.
	 * @see #setTyperef(DataType)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataTypeReference_Typeref()
	 * @model
	 * @generated
	 */
	DataType getTyperef();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.DataTypeReference#getTyperef <em>Typeref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typeref</em>' reference.
	 * @see #getTyperef()
	 * @generated
	 */
	void setTyperef(DataType value);

	/**
	 * Returns the value of the '<em><b>Support</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Support</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Support</em>' containment reference.
	 * @see #setSupport(DataType)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataTypeReference_Support()
	 * @model containment="true"
	 * @generated
	 */
	DataType getSupport();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.DataTypeReference#getSupport <em>Support</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support</em>' containment reference.
	 * @see #getSupport()
	 * @generated
	 */
	void setSupport(DataType value);

} // DataTypeReference
