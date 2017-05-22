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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage
 * @generated
 */
public interface FormalMLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FormalMLFactory eINSTANCE = org.eclipse.efm.modeling.formalml.impl.FormalMLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Part</em>'.
	 * @generated
	 */
	Part createPart();

	/**
	 * Returns a new object of class '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block</em>'.
	 * @generated
	 */
	Block createBlock();

	/**
	 * Returns a new object of class '<em>Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock</em>'.
	 * @generated
	 */
	Clock createClock();

	/**
	 * Returns a new object of class '<em>Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer</em>'.
	 * @generated
	 */
	Buffer createBuffer();

	/**
	 * Returns a new object of class '<em>Directed Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Directed Port</em>'.
	 * @generated
	 */
	DirectedPort createDirectedPort();

	/**
	 * Returns a new object of class '<em>Timed Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Transition</em>'.
	 * @generated
	 */
	TimedTransition createTimedTransition();

	/**
	 * Returns a new object of class '<em>Fifo Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fifo Contract</em>'.
	 * @generated
	 */
	FifoContract createFifoContract();

	/**
	 * Returns a new object of class '<em>Connector Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Contract</em>'.
	 * @generated
	 */
	ConnectorContract createConnectorContract();

	/**
	 * Returns a new object of class '<em>Lifo Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lifo Contract</em>'.
	 * @generated
	 */
	LifoContract createLifoContract();

	/**
	 * Returns a new object of class '<em>Multi Set Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Set Contract</em>'.
	 * @generated
	 */
	MultiSetContract createMultiSetContract();

	/**
	 * Returns a new object of class '<em>Rendez Vous Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rendez Vous Contract</em>'.
	 * @generated
	 */
	RendezVousContract createRendezVousContract();

	/**
	 * Returns a new object of class '<em>Multi Rendez Vous Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Rendez Vous Contract</em>'.
	 * @generated
	 */
	MultiRendezVousContract createMultiRendezVousContract();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FormalMLPackage getFormalMLPackage();

} //FormalMLFactory
