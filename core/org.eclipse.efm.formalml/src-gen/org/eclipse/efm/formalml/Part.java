/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.formalml.Part#getBaseProperty <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.Part#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.formalml.formalmlPackage#getPart()
 * @model
 * @generated
 */
public interface Part extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBaseProperty(Property)
	 * @see org.eclipse.efm.formalml.formalmlPackage#getPart_BaseProperty()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='base_Property'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='extension_BlockPart'"
	 * @generated
	 */
	Property getBaseProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.formalml.Part#getBaseProperty <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBaseProperty()
	 * @generated
	 */
	void setBaseProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.InstanceSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' reference list.
	 * @see org.eclipse.efm.formalml.formalmlPackage#getPart_Instance()
	 * @model ordered="false"
	 * @generated
	 */
	EList<InstanceSpecification> getInstance();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.InstanceSpecification} with the specified '<em><b>Name</b></em>' from the '<em><b>Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.InstanceSpecification} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.InstanceSpecification} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getInstance()
	 * @generated
	 */
	InstanceSpecification getInstance(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.InstanceSpecification} with the specified '<em><b>Name</b></em>' from the '<em><b>Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.InstanceSpecification} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.InstanceSpecification} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.InstanceSpecification} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getInstance()
	 * @generated
	 */
	InstanceSpecification getInstance(String name, boolean ignoreCase, EClass eClass);

} // Part
