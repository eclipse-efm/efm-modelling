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
package org.eclipse.efm.ecore.formalml.infrastructure;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty#getXliaProperty <em>Xlia Property</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getSlotProperty()
 * @model
 * @generated
 */
public interface SlotProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Xlia Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xlia Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xlia Property</em>' reference.
	 * @see #setXliaProperty(PropertyDefinition)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getSlotProperty_XliaProperty()
	 * @model
	 * @generated
	 */
	PropertyDefinition getXliaProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty#getXliaProperty <em>Xlia Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xlia Property</em>' reference.
	 * @see #getXliaProperty()
	 * @generated
	 */
	void setXliaProperty(PropertyDefinition value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getSlotProperty_Value()
	 * @model containment="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // SlotProperty
