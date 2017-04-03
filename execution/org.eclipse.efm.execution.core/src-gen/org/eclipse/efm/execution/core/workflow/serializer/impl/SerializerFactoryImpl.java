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
package org.eclipse.efm.execution.core.workflow.serializer.impl;

import org.eclipse.efm.execution.core.workflow.serializer.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SerializerFactoryImpl extends EFactoryImpl implements SerializerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SerializerFactory init() {
		try {
			SerializerFactory theSerializerFactory = (SerializerFactory)EPackage.Registry.INSTANCE.getEFactory(SerializerPackage.eNS_URI);
			if (theSerializerFactory != null) {
				return theSerializerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SerializerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SerializerPackage.MODEL_GRAPHVIZ_SERIALIZER_WORKER: return createModelGraphvizSerializerWorker();
			case SerializerPackage.SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER: return createSymbexGraphVizSerializerWorker();
			case SerializerPackage.BASIC_TRACE_SERIALIZER: return createBasicTraceSerializer();
			case SerializerPackage.TTCN_TRACE_SERIALIZER: return createTTCNTraceSerializer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelGraphvizSerializerWorker createModelGraphvizSerializerWorker() {
		ModelGraphvizSerializerWorkerImpl modelGraphvizSerializerWorker = new ModelGraphvizSerializerWorkerImpl();
		return modelGraphvizSerializerWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbexGraphVizSerializerWorker createSymbexGraphVizSerializerWorker() {
		SymbexGraphVizSerializerWorkerImpl symbexGraphVizSerializerWorker = new SymbexGraphVizSerializerWorkerImpl();
		return symbexGraphVizSerializerWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicTraceSerializer createBasicTraceSerializer() {
		BasicTraceSerializerImpl basicTraceSerializer = new BasicTraceSerializerImpl();
		return basicTraceSerializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTCNTraceSerializer createTTCNTraceSerializer() {
		TTCNTraceSerializerImpl ttcnTraceSerializer = new TTCNTraceSerializerImpl();
		return ttcnTraceSerializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializerPackage getSerializerPackage() {
		return (SerializerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SerializerPackage getPackage() {
		return SerializerPackage.eINSTANCE;
	}

} //SerializerFactoryImpl
