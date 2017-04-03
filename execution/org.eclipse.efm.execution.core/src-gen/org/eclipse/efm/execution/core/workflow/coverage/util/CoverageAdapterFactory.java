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
package org.eclipse.efm.execution.core.workflow.coverage.util;

import org.eclipse.efm.execution.core.workflow.CoverageWorker;
import org.eclipse.efm.execution.core.workflow.NamedObject;
import org.eclipse.efm.execution.core.workflow.Worker;

import org.eclipse.efm.execution.core.workflow.coverage.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.coverage.CoveragePackage
 * @generated
 */
public class CoverageAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CoveragePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CoveragePackage.eINSTANCE;
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
	protected CoverageSwitch<Adapter> modelSwitch =
		new CoverageSwitch<Adapter>() {
			@Override
			public Adapter caseTransitionCoverageWorker(TransitionCoverageWorker object) {
				return createTransitionCoverageWorkerAdapter();
			}
			@Override
			public Adapter caseInputOutputCoverageWorker(InputOutputCoverageWorker object) {
				return createInputOutputCoverageWorkerAdapter();
			}
			@Override
			public Adapter caseConditionCoverageWorker(ConditionCoverageWorker object) {
				return createConditionCoverageWorkerAdapter();
			}
			@Override
			public Adapter caseDecisionCoverageWorker(DecisionCoverageWorker object) {
				return createDecisionCoverageWorkerAdapter();
			}
			@Override
			public Adapter caseConditionDecisionCoverageWorker(ConditionDecisionCoverageWorker object) {
				return createConditionDecisionCoverageWorkerAdapter();
			}
			@Override
			public Adapter caseModifiedConditionDecisionCoverageWorker(ModifiedConditionDecisionCoverageWorker object) {
				return createModifiedConditionDecisionCoverageWorkerAdapter();
			}
			@Override
			public Adapter caseBehaviorCoverageWorker(BehaviorCoverageWorker object) {
				return createBehaviorCoverageWorkerAdapter();
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
			public Adapter caseCoverageWorker(CoverageWorker object) {
				return createCoverageWorkerAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.coverage.TransitionCoverageWorker <em>Transition Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.coverage.TransitionCoverageWorker
	 * @generated
	 */
	public Adapter createTransitionCoverageWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.coverage.InputOutputCoverageWorker <em>Input Output Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.coverage.InputOutputCoverageWorker
	 * @generated
	 */
	public Adapter createInputOutputCoverageWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.coverage.ConditionCoverageWorker <em>Condition Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.coverage.ConditionCoverageWorker
	 * @generated
	 */
	public Adapter createConditionCoverageWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.coverage.DecisionCoverageWorker <em>Decision Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.coverage.DecisionCoverageWorker
	 * @generated
	 */
	public Adapter createDecisionCoverageWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.coverage.ConditionDecisionCoverageWorker <em>Condition Decision Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.coverage.ConditionDecisionCoverageWorker
	 * @generated
	 */
	public Adapter createConditionDecisionCoverageWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.coverage.ModifiedConditionDecisionCoverageWorker <em>Modified Condition Decision Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.coverage.ModifiedConditionDecisionCoverageWorker
	 * @generated
	 */
	public Adapter createModifiedConditionDecisionCoverageWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.coverage.BehaviorCoverageWorker <em>Behavior Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.coverage.BehaviorCoverageWorker
	 * @generated
	 */
	public Adapter createBehaviorCoverageWorkerAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.execution.core.workflow.CoverageWorker <em>Coverage Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.execution.core.workflow.CoverageWorker
	 * @generated
	 */
	public Adapter createCoverageWorkerAdapter() {
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

} //CoverageAdapterFactory
