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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.specification.SpecificationPackage
 * @generated
 */
public interface SpecificationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpecificationFactory eINSTANCE = org.eclipse.efm.ecore.formalml.specification.impl.SpecificationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Xlia Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xlia Model</em>'.
	 * @generated
	 */
	XliaModel createXliaModel();

	/**
	 * Returns a new object of class '<em>Xlia Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xlia Named Element</em>'.
	 * @generated
	 */
	XliaNamedElement createXliaNamedElement();

	/**
	 * Returns a new object of class '<em>Xlia Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xlia Object</em>'.
	 * @generated
	 */
	XliaObject createXliaObject();

	/**
	 * Returns a new object of class '<em>Xlia Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xlia Section</em>'.
	 * @generated
	 */
	XliaSection createXliaSection();

	/**
	 * Returns a new object of class '<em>Xlia Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xlia Attribute</em>'.
	 * @generated
	 */
	XliaAttribute createXliaAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SpecificationPackage getSpecificationPackage();

} //SpecificationFactory
