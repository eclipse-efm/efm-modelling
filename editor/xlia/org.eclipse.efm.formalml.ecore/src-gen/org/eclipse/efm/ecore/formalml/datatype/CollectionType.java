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
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#isUnbounded <em>Unbounded</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getCollectionType()
 * @model
 * @generated
 */
public interface CollectionType extends DataSupportedType {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * The default value is <code>"list"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.datatype.CollectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionKind
	 * @see #setContainer(CollectionKind)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getCollectionType_Container()
	 * @model default="list"
	 * @generated
	 */
	CollectionKind getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#getContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionKind
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(CollectionKind value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getCollectionType_Size()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unbounded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unbounded</em>' attribute.
	 * @see #setUnbounded(boolean)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getCollectionType_Unbounded()
	 * @model required="true"
	 * @generated
	 */
	boolean isUnbounded();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#isUnbounded <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unbounded</em>' attribute.
	 * @see #isUnbounded()
	 * @generated
	 */
	void setUnbounded(boolean value);

} // CollectionType
