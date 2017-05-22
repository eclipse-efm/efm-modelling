/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.modeling.formalml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.modeling.formalml.Configuration#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.Configuration#isTimed <em>Is Timed</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.Configuration#isInputEnabled <em>Is Input Enabled</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends FormalBlock {
	/**
	 * Returns the value of the '<em><b>Environment</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environment</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment</em>' reference list.
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getConfiguration_Environment()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Property> getEnvironment();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>Environment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 * @see #getEnvironment()
	 * @generated
	 */
	Property getEnvironment(String name, Type type);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>Environment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 * @see #getEnvironment()
	 * @generated
	 */
	Property getEnvironment(String name, Type type, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Is Timed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Timed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Timed</em>' attribute.
	 * @see #setIsTimed(boolean)
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getConfiguration_IsTimed()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isTimed();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.modeling.formalml.Configuration#isTimed <em>Is Timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Timed</em>' attribute.
	 * @see #isTimed()
	 * @generated
	 */
	void setIsTimed(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Input Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>isInputEnabled : est-ce le bon terme</p>
	 * 
	 * <p>&nbsp;</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Input Enabled</em>' attribute.
	 * @see #setIsInputEnabled(boolean)
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#getConfiguration_IsInputEnabled()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isInputEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.modeling.formalml.Configuration#isInputEnabled <em>Is Input Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Input Enabled</em>' attribute.
	 * @see #isInputEnabled()
	 * @generated
	 */
	void setIsInputEnabled(boolean value);

} // Configuration
