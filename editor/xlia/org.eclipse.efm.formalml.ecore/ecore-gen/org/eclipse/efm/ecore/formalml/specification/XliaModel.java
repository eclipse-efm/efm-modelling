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
package org.eclipse.efm.ecore.formalml.specification;

import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xlia Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.specification.XliaModel#getProlog <em>Prolog</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.specification.XliaModel#getSystem <em>System</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.specification.SpecificationPackage#getXliaModel()
 * @model
 * @generated
 */
public interface XliaModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Prolog</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prolog</em>' containment reference.
	 * @see #setProlog(XliaObject)
	 * @see org.eclipse.efm.ecore.formalml.specification.SpecificationPackage#getXliaModel_Prolog()
	 * @model containment="true" required="true"
	 * @generated
	 */
	XliaObject getProlog();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.specification.XliaModel#getProlog <em>Prolog</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prolog</em>' containment reference.
	 * @see #getProlog()
	 * @generated
	 */
	void setProlog(XliaObject value);

	/**
	 * Returns the value of the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' containment reference.
	 * @see #setSystem(XliaSystem)
	 * @see org.eclipse.efm.ecore.formalml.specification.SpecificationPackage#getXliaModel_System()
	 * @model containment="true" required="true"
	 * @generated
	 */
	XliaSystem getSystem();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.specification.XliaModel#getSystem <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' containment reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(XliaSystem value);

} // XliaModel
