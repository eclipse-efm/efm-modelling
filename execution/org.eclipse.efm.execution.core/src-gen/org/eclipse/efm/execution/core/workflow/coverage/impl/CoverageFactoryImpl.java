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
package org.eclipse.efm.execution.core.workflow.coverage.impl;

import org.eclipse.efm.execution.core.workflow.coverage.*;

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
public class CoverageFactoryImpl extends EFactoryImpl implements CoverageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoverageFactory init() {
		try {
			CoverageFactory theCoverageFactory = (CoverageFactory)EPackage.Registry.INSTANCE.getEFactory(CoveragePackage.eNS_URI);
			if (theCoverageFactory != null) {
				return theCoverageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CoverageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageFactoryImpl() {
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
			case CoveragePackage.TRANSITION_COVERAGE_WORKER: return createTransitionCoverageWorker();
			case CoveragePackage.INPUT_OUTPUT_COVERAGE_WORKER: return createInputOutputCoverageWorker();
			case CoveragePackage.CONDITION_COVERAGE_WORKER: return createConditionCoverageWorker();
			case CoveragePackage.DECISION_COVERAGE_WORKER: return createDecisionCoverageWorker();
			case CoveragePackage.CONDITION_DECISION_COVERAGE_WORKER: return createConditionDecisionCoverageWorker();
			case CoveragePackage.MODIFIED_CONDITION_DECISION_COVERAGE_WORKER: return createModifiedConditionDecisionCoverageWorker();
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER: return createBehaviorCoverageWorker();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionCoverageWorker createTransitionCoverageWorker() {
		TransitionCoverageWorkerImpl transitionCoverageWorker = new TransitionCoverageWorkerImpl();
		return transitionCoverageWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputOutputCoverageWorker createInputOutputCoverageWorker() {
		InputOutputCoverageWorkerImpl inputOutputCoverageWorker = new InputOutputCoverageWorkerImpl();
		return inputOutputCoverageWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionCoverageWorker createConditionCoverageWorker() {
		ConditionCoverageWorkerImpl conditionCoverageWorker = new ConditionCoverageWorkerImpl();
		return conditionCoverageWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionCoverageWorker createDecisionCoverageWorker() {
		DecisionCoverageWorkerImpl decisionCoverageWorker = new DecisionCoverageWorkerImpl();
		return decisionCoverageWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionDecisionCoverageWorker createConditionDecisionCoverageWorker() {
		ConditionDecisionCoverageWorkerImpl conditionDecisionCoverageWorker = new ConditionDecisionCoverageWorkerImpl();
		return conditionDecisionCoverageWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedConditionDecisionCoverageWorker createModifiedConditionDecisionCoverageWorker() {
		ModifiedConditionDecisionCoverageWorkerImpl modifiedConditionDecisionCoverageWorker = new ModifiedConditionDecisionCoverageWorkerImpl();
		return modifiedConditionDecisionCoverageWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorCoverageWorker createBehaviorCoverageWorker() {
		BehaviorCoverageWorkerImpl behaviorCoverageWorker = new BehaviorCoverageWorkerImpl();
		return behaviorCoverageWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoveragePackage getCoveragePackage() {
		return (CoveragePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CoveragePackage getPackage() {
		return CoveragePackage.eINSTANCE;
	}

} //CoverageFactoryImpl
