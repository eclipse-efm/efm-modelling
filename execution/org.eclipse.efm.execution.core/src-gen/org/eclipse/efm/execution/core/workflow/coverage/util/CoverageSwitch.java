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
 * @see org.eclipse.efm.execution.core.workflow.coverage.CoveragePackage
 * @generated
 */
public class CoverageSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CoveragePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageSwitch() {
		if (modelPackage == null) {
			modelPackage = CoveragePackage.eINSTANCE;
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
			case CoveragePackage.TRANSITION_COVERAGE_WORKER: {
				TransitionCoverageWorker transitionCoverageWorker = (TransitionCoverageWorker)theEObject;
				T result = caseTransitionCoverageWorker(transitionCoverageWorker);
				if (result == null) result = caseCoverageWorker(transitionCoverageWorker);
				if (result == null) result = caseWorker(transitionCoverageWorker);
				if (result == null) result = caseNamedObject(transitionCoverageWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoveragePackage.INPUT_OUTPUT_COVERAGE_WORKER: {
				InputOutputCoverageWorker inputOutputCoverageWorker = (InputOutputCoverageWorker)theEObject;
				T result = caseInputOutputCoverageWorker(inputOutputCoverageWorker);
				if (result == null) result = caseCoverageWorker(inputOutputCoverageWorker);
				if (result == null) result = caseWorker(inputOutputCoverageWorker);
				if (result == null) result = caseNamedObject(inputOutputCoverageWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoveragePackage.CONDITION_COVERAGE_WORKER: {
				ConditionCoverageWorker conditionCoverageWorker = (ConditionCoverageWorker)theEObject;
				T result = caseConditionCoverageWorker(conditionCoverageWorker);
				if (result == null) result = caseCoverageWorker(conditionCoverageWorker);
				if (result == null) result = caseWorker(conditionCoverageWorker);
				if (result == null) result = caseNamedObject(conditionCoverageWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoveragePackage.DECISION_COVERAGE_WORKER: {
				DecisionCoverageWorker decisionCoverageWorker = (DecisionCoverageWorker)theEObject;
				T result = caseDecisionCoverageWorker(decisionCoverageWorker);
				if (result == null) result = caseCoverageWorker(decisionCoverageWorker);
				if (result == null) result = caseWorker(decisionCoverageWorker);
				if (result == null) result = caseNamedObject(decisionCoverageWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoveragePackage.CONDITION_DECISION_COVERAGE_WORKER: {
				ConditionDecisionCoverageWorker conditionDecisionCoverageWorker = (ConditionDecisionCoverageWorker)theEObject;
				T result = caseConditionDecisionCoverageWorker(conditionDecisionCoverageWorker);
				if (result == null) result = caseCoverageWorker(conditionDecisionCoverageWorker);
				if (result == null) result = caseWorker(conditionDecisionCoverageWorker);
				if (result == null) result = caseNamedObject(conditionDecisionCoverageWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoveragePackage.MODIFIED_CONDITION_DECISION_COVERAGE_WORKER: {
				ModifiedConditionDecisionCoverageWorker modifiedConditionDecisionCoverageWorker = (ModifiedConditionDecisionCoverageWorker)theEObject;
				T result = caseModifiedConditionDecisionCoverageWorker(modifiedConditionDecisionCoverageWorker);
				if (result == null) result = caseCoverageWorker(modifiedConditionDecisionCoverageWorker);
				if (result == null) result = caseWorker(modifiedConditionDecisionCoverageWorker);
				if (result == null) result = caseNamedObject(modifiedConditionDecisionCoverageWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoveragePackage.BEHAVIOR_COVERAGE_WORKER: {
				BehaviorCoverageWorker behaviorCoverageWorker = (BehaviorCoverageWorker)theEObject;
				T result = caseBehaviorCoverageWorker(behaviorCoverageWorker);
				if (result == null) result = caseCoverageWorker(behaviorCoverageWorker);
				if (result == null) result = caseWorker(behaviorCoverageWorker);
				if (result == null) result = caseNamedObject(behaviorCoverageWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Coverage Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionCoverageWorker(TransitionCoverageWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Output Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Output Coverage Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputOutputCoverageWorker(InputOutputCoverageWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Coverage Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionCoverageWorker(ConditionCoverageWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decision Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decision Coverage Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecisionCoverageWorker(DecisionCoverageWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Decision Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Decision Coverage Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionDecisionCoverageWorker(ConditionDecisionCoverageWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modified Condition Decision Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modified Condition Decision Coverage Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifiedConditionDecisionCoverageWorker(ModifiedConditionDecisionCoverageWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Coverage Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorCoverageWorker(BehaviorCoverageWorker object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Coverage Worker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoverageWorker(CoverageWorker object) {
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

} //CoverageSwitch
