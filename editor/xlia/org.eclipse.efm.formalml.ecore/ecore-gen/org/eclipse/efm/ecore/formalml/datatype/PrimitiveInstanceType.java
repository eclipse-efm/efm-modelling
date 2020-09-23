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

import org.eclipse.efm.ecore.formalml.common.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Instance Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType#getExpected <em>Expected</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveInstanceType()
 * @model
 * @generated
 */
public interface PrimitiveInstanceType extends PrimitiveType {
	/**
	 * Returns the value of the '<em><b>Expected</b></em>' attribute.
	 * The default value is <code>"machine"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind
	 * @see #setExpected(PrimitiveInstanceKind)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveInstanceType_Expected()
	 * @model default="machine"
	 * @generated
	 */
	PrimitiveInstanceKind getExpected();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType#getExpected <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind
	 * @see #getExpected()
	 * @generated
	 */
	void setExpected(PrimitiveInstanceKind value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(NamedElement)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getPrimitiveInstanceType_Model()
	 * @model
	 * @generated
	 */
	NamedElement getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(NamedElement value);

} // PrimitiveInstanceType
