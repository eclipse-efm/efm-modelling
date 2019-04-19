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
package org.eclipse.efm.execution.core.workflow.serializer.util;

import org.eclipse.efm.execution.core.workflow.NamedObject;
import org.eclipse.efm.execution.core.workflow.Serializer;
import org.eclipse.efm.execution.core.workflow.Worker;

import org.eclipse.efm.execution.core.workflow.serializer.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.serializer.SerializerPackage
 * @generated
 */
public class SerializerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SerializerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SerializerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SerializerSwitch<Adapter> modelSwitch =
		new SerializerSwitch<Adapter>() {
			@Override
			public Adapter caseModelGraphicSerializerWorker(ModelGraphicSerializerWorker object) {
				return createModelGraphicSerializerWorkerAdapter();
			}
			@Override
			public Adapter caseModelGraphvizSerializerWorker(ModelGraphvizSerializerWorker object) {
				return createModelGraphvizSerializerWorkerAdapter();
			}
			@Override
			public Adapter caseSymbexGraphicSerializerWorker(SymbexGraphicSerializerWorker object) {
				return createSymbexGraphicSerializerWorkerAdapter();
			}
			@Override
			public Adapter caseSymbexGraphVizSerializerWorker(SymbexGraphVizSerializerWorker object) {
				return createSymbexGraphVizSerializerWorkerAdapter();
			}
			@Override
			public Adapter caseBasicTraceSerializer(BasicTraceSerializer object) {
				return createBasicTraceSerializerAdapter();
			}
			@Override
			public Adapter caseTTCNTraceSerializer(TTCNTraceSerializer object) {
				return createTTCNTraceSerializerAdapter();
			}
			@Override
			public Adapter caseSymbexSequenceDiagramSerializerWorker(SymbexSequenceDiagramSerializerWorker object) {
				return createSymbexSequenceDiagramSerializerWorkerAdapter();
			}
			@Override
			public Adapter caseSequenceDiagramTraceSerializer(SequenceDiagramTraceSerializer object) {
				return createSequenceDiagramTraceSerializerAdapter();
			}
			@Override
			public Adapter caseNamedObject(NamedObject object) {
				return createNamedObjectAdapter();
			}
			@Override
			public Adapter caseWorker(Worker object) {
				return createWorkerAdapter();
			}
			@Override
			public Adapter caseSerializer(Serializer object) {
				return createSerializerAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.serializer.ModelGraphicSerializerWorker <em>Model Graphic Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.ModelGraphicSerializerWorker
	 * @generated
	 */
	public Adapter createModelGraphicSerializerWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.serializer.ModelGraphvizSerializerWorker <em>Model Graphviz Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.ModelGraphvizSerializerWorker
	 * @generated
	 */
	public Adapter createModelGraphvizSerializerWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphicSerializerWorker <em>Symbex Graphic Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphicSerializerWorker
	 * @generated
	 */
	public Adapter createSymbexGraphicSerializerWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphVizSerializerWorker <em>Symbex Graph Viz Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphVizSerializerWorker
	 * @generated
	 */
	public Adapter createSymbexGraphVizSerializerWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.serializer.BasicTraceSerializer <em>Basic Trace Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.BasicTraceSerializer
	 * @generated
	 */
	public Adapter createBasicTraceSerializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer <em>TTCN Trace Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer
	 * @generated
	 */
	public Adapter createTTCNTraceSerializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.serializer.SymbexSequenceDiagramSerializerWorker <em>Symbex Sequence Diagram Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.SymbexSequenceDiagramSerializerWorker
	 * @generated
	 */
	public Adapter createSymbexSequenceDiagramSerializerWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.serializer.SequenceDiagramTraceSerializer <em>Sequence Diagram Trace Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.SequenceDiagramTraceSerializer
	 * @generated
	 */
	public Adapter createSequenceDiagramTraceSerializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.NamedObject <em>Named Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.NamedObject
	 * @generated
	 */
	public Adapter createNamedObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.Worker <em>Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.Worker
	 * @generated
	 */
	public Adapter createWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.Serializer <em>Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.Serializer
	 * @generated
	 */
	public Adapter createSerializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SerializerAdapterFactory
