/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.ecore.sew;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.sew.SewPackage
 * @generated
 */
public interface SewFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SewFactory eINSTANCE = org.eclipse.efm.ecore.sew.impl.SewFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>WNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WNamed Element</em>'.
	 * @generated
	 */
	WNamedElement createWNamedElement();

	/**
	 * Returns a new object of class '<em>SE Workflow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SE Workflow</em>'.
	 * @generated
	 */
	SEWorkflow createSEWorkflow();

	/**
	 * Returns a new object of class '<em>WObject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WObject</em>'.
	 * @generated
	 */
	WObject createWObject();

	/**
	 * Returns a new object of class '<em>WSection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WSection</em>'.
	 * @generated
	 */
	WSection createWSection();

	/**
	 * Returns a new object of class '<em>WAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WAttribute</em>'.
	 * @generated
	 */
	WAttribute createWAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SewPackage getSewPackage();

} //SewFactory
