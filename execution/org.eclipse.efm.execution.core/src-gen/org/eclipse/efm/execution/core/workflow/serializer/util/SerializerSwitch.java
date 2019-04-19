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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.serializer.SerializerPackage
 * @generated
 */
public class SerializerSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SerializerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializerSwitch() {
		if (modelPackage == null) {
			modelPackage = SerializerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SerializerPackage.MODEL_GRAPHIC_SERIALIZER_WORKER: {
				ModelGraphicSerializerWorker modelGraphicSerializerWorker = (ModelGraphicSerializerWorker)theEObject;
				T result = caseModelGraphicSerializerWorker(modelGraphicSerializerWorker);
				if (result == null) result = caseSerializer(modelGraphicSerializerWorker);
				if (result == null) result = caseWorker(modelGraphicSerializerWorker);
				if (result == null) result = caseNamedObject(modelGraphicSerializerWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SerializerPackage.MODEL_GRAPHVIZ_SERIALIZER_WORKER: {
				ModelGraphvizSerializerWorker modelGraphvizSerializerWorker = (ModelGraphvizSerializerWorker)theEObject;
				T result = caseModelGraphvizSerializerWorker(modelGraphvizSerializerWorker);
				if (result == null) result = caseSerializer(modelGraphvizSerializerWorker);
				if (result == null) result = caseWorker(modelGraphvizSerializerWorker);
				if (result == null) result = caseNamedObject(modelGraphvizSerializerWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SerializerPackage.SYMBEX_GRAPHIC_SERIALIZER_WORKER: {
				SymbexGraphicSerializerWorker symbexGraphicSerializerWorker = (SymbexGraphicSerializerWorker)theEObject;
				T result = caseSymbexGraphicSerializerWorker(symbexGraphicSerializerWorker);
				if (result == null) result = caseSerializer(symbexGraphicSerializerWorker);
				if (result == null) result = caseWorker(symbexGraphicSerializerWorker);
				if (result == null) result = caseNamedObject(symbexGraphicSerializerWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SerializerPackage.SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER: {
				SymbexGraphVizSerializerWorker symbexGraphVizSerializerWorker = (SymbexGraphVizSerializerWorker)theEObject;
				T result = caseSymbexGraphVizSerializerWorker(symbexGraphVizSerializerWorker);
				if (result == null) result = caseSerializer(symbexGraphVizSerializerWorker);
				if (result == null) result = caseWorker(symbexGraphVizSerializerWorker);
				if (result == null) result = caseNamedObject(symbexGraphVizSerializerWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SerializerPackage.BASIC_TRACE_SERIALIZER: {
				BasicTraceSerializer basicTraceSerializer = (BasicTraceSerializer)theEObject;
				T result = caseBasicTraceSerializer(basicTraceSerializer);
				if (result == null) result = caseSerializer(basicTraceSerializer);
				if (result == null) result = caseWorker(basicTraceSerializer);
				if (result == null) result = caseNamedObject(basicTraceSerializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SerializerPackage.TTCN_TRACE_SERIALIZER: {
				TTCNTraceSerializer ttcnTraceSerializer = (TTCNTraceSerializer)theEObject;
				T result = caseTTCNTraceSerializer(ttcnTraceSerializer);
				if (result == null) result = caseSerializer(ttcnTraceSerializer);
				if (result == null) result = caseWorker(ttcnTraceSerializer);
				if (result == null) result = caseNamedObject(ttcnTraceSerializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SerializerPackage.SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER: {
				SymbexSequenceDiagramSerializerWorker symbexSequenceDiagramSerializerWorker = (SymbexSequenceDiagramSerializerWorker)theEObject;
				T result = caseSymbexSequenceDiagramSerializerWorker(symbexSequenceDiagramSerializerWorker);
				if (result == null) result = caseSerializer(symbexSequenceDiagramSerializerWorker);
				if (result == null) result = caseWorker(symbexSequenceDiagramSerializerWorker);
				if (result == null) result = caseNamedObject(symbexSequenceDiagramSerializerWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SerializerPackage.SEQUENCE_DIAGRAM_TRACE_SERIALIZER: {
				SequenceDiagramTraceSerializer sequenceDiagramTraceSerializer = (SequenceDiagramTraceSerializer)theEObject;
				T result = caseSequenceDiagramTraceSerializer(sequenceDiagramTraceSerializer);
				if (result == null) result = caseSerializer(sequenceDiagramTraceSerializer);
				if (result == null) result = caseWorker(sequenceDiagramTraceSerializer);
				if (result == null) result = caseNamedObject(sequenceDiagramTraceSerializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Graphic Serializer Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Graphic Serializer Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelGraphicSerializerWorker(ModelGraphicSerializerWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Graphviz Serializer Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Graphviz Serializer Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelGraphvizSerializerWorker(ModelGraphvizSerializerWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbex Graphic Serializer Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbex Graphic Serializer Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbexGraphicSerializerWorker(SymbexGraphicSerializerWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbex Graph Viz Serializer Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbex Graph Viz Serializer Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbexGraphVizSerializerWorker(SymbexGraphVizSerializerWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Trace Serializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Trace Serializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicTraceSerializer(BasicTraceSerializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTCN Trace Serializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTCN Trace Serializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTTCNTraceSerializer(TTCNTraceSerializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbex Sequence Diagram Serializer Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbex Sequence Diagram Serializer Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbexSequenceDiagramSerializerWorker(SymbexSequenceDiagramSerializerWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Diagram Trace Serializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Diagram Trace Serializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceDiagramTraceSerializer(SequenceDiagramTraceSerializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedObject(NamedObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorker(Worker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Serializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSerializer(Serializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SerializerSwitch
