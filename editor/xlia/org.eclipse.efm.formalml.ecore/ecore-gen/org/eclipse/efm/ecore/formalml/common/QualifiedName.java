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
package org.eclipse.efm.ecore.formalml.common;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.common.QualifiedName#getIsAmbiguous <em>Is Ambiguous</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.common.QualifiedName#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.common.QualifiedName#getNameBinding <em>Name Binding</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.common.QualifiedName#getUnqualifiedName <em>Unqualified Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.common.CommonPackage#getQualifiedName()
 * @model
 * @generated
 */
public interface QualifiedName extends AbstractElement {
	/**
	 * Returns the value of the '<em><b>Is Ambiguous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ambiguous</em>' attribute.
	 * @see #setIsAmbiguous(Boolean)
	 * @see org.eclipse.efm.ecore.formalml.common.CommonPackage#getQualifiedName_IsAmbiguous()
	 * @model
	 * @generated
	 */
	Boolean getIsAmbiguous();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.common.QualifiedName#getIsAmbiguous <em>Is Ambiguous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ambiguous</em>' attribute.
	 * @see #getIsAmbiguous()
	 * @generated
	 */
	void setIsAmbiguous(Boolean value);

	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' attribute.
	 * @see #setPathName(String)
	 * @see org.eclipse.efm.ecore.formalml.common.CommonPackage#getQualifiedName_PathName()
	 * @model
	 * @generated
	 */
	String getPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.common.QualifiedName#getPathName <em>Path Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' attribute.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(String value);

	/**
	 * Returns the value of the '<em><b>Name Binding</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Binding</em>' attribute list.
	 * @see org.eclipse.efm.ecore.formalml.common.CommonPackage#getQualifiedName_NameBinding()
	 * @model
	 * @generated
	 */
	EList<String> getNameBinding();

	/**
	 * Returns the value of the '<em><b>Unqualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unqualified Name</em>' attribute.
	 * @see #setUnqualifiedName(String)
	 * @see org.eclipse.efm.ecore.formalml.common.CommonPackage#getQualifiedName_UnqualifiedName()
	 * @model
	 * @generated
	 */
	String getUnqualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.common.QualifiedName#getUnqualifiedName <em>Unqualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unqualified Name</em>' attribute.
	 * @see #getUnqualifiedName()
	 * @generated
	 */
	void setUnqualifiedName(String value);

} // QualifiedName
