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
 * A representation of the model object '<em><b>Primitive Number Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType#getSign <em>Sign</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveNumberType()
 * @model abstract="true"
 * @generated
 */
public interface PrimitiveNumberType extends PrimitiveType {
	/**
	 * Returns the value of the '<em><b>Sign</b></em>' attribute.
	 * The default value is <code>"any"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sign</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sign</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign
	 * @see #setSign(PrimitiveNumberSign)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveNumberType_Sign()
	 * @model default="any"
	 * @generated
	 */
	PrimitiveNumberSign getSign();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType#getSign <em>Sign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sign</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign
	 * @see #getSign()
	 * @generated
	 */
	void setSign(PrimitiveNumberSign value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveNumberType_Size()
	 * @model required="true"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

} // PrimitiveNumberType
