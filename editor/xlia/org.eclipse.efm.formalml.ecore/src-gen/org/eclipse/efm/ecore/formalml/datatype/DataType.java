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

import org.eclipse.efm.ecore.formalml.common.ClassifierDefinition;

import org.eclipse.efm.ecore.formalml.expression.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.DataType#isTypedef <em>Typedef</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataType()
 * @model abstract="true"
 * @generated
 */
public interface DataType extends ClassifierDefinition {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind
	 * @see #setKind(PrimitiveTypeKind)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataType_Kind()
	 * @model
	 * @generated
	 */
	PrimitiveTypeKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(PrimitiveTypeKind value);

	/**
	 * Returns the value of the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typedef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typedef</em>' attribute.
	 * @see #setTypedef(boolean)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataType_Typedef()
	 * @model required="true"
	 * @generated
	 */
	boolean isTypedef();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#isTypedef <em>Typedef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typedef</em>' attribute.
	 * @see #isTypedef()
	 * @generated
	 */
	void setTypedef(boolean value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' containment reference.
	 * @see #setMultiplicity(Expression)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataType_Multiplicity()
	 * @model containment="true"
	 * @generated
	 */
	Expression getMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(Expression value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(Expression)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getDataType_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	Expression getDefaultValue();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(Expression value);

} // DataType
