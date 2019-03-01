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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Time Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType#isClock <em>Clock</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType#getSupport <em>Support</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveTimeType()
 * @model
 * @generated
 */
public interface PrimitiveTimeType extends PrimitiveNumberType {
	/**
	 * Returns the value of the '<em><b>Clock</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock</em>' attribute.
	 * @see #setClock(boolean)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveTimeType_Clock()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isClock();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType#isClock <em>Clock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock</em>' attribute.
	 * @see #isClock()
	 * @generated
	 */
	void setClock(boolean value);

	/**
	 * Returns the value of the '<em><b>Support</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Support</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Support</em>' containment reference.
	 * @see #setSupport(PrimitiveNumberType)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveTimeType_Support()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveNumberType getSupport();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType#getSupport <em>Support</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support</em>' containment reference.
	 * @see #getSupport()
	 * @generated
	 */
	void setSupport(PrimitiveNumberType value);

} // PrimitiveTimeType
