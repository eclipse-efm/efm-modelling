/**
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.efm.execution.core.workflow.serializer;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.serializer.SerializerPackage
 * @generated
 */
public interface SerializerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SerializerFactory eINSTANCE = org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Graphviz Serializer Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Graphviz Serializer Worker</em>'.
	 * @generated
	 */
	ModelGraphvizSerializerWorker createModelGraphvizSerializerWorker();

	/**
	 * Returns a new object of class '<em>Symbex Graph Viz Serializer Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbex Graph Viz Serializer Worker</em>'.
	 * @generated
	 */
	SymbexGraphVizSerializerWorker createSymbexGraphVizSerializerWorker();

	/**
	 * Returns a new object of class '<em>Basic Trace Serializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Trace Serializer</em>'.
	 * @generated
	 */
	BasicTraceSerializer createBasicTraceSerializer();

	/**
	 * Returns a new object of class '<em>TTCN Trace Serializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TTCN Trace Serializer</em>'.
	 * @generated
	 */
	TTCNTraceSerializer createTTCNTraceSerializer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SerializerPackage getSerializerPackage();

} //SerializerFactory
