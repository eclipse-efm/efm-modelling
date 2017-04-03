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
package org.eclipse.efm.execution.core.workflow.coverage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.coverage.CoveragePackage
 * @generated
 */
public interface CoverageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoverageFactory eINSTANCE = org.eclipse.efm.execution.core.workflow.coverage.impl.CoverageFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transition Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Coverage Worker</em>'.
	 * @generated
	 */
	TransitionCoverageWorker createTransitionCoverageWorker();

	/**
	 * Returns a new object of class '<em>Input Output Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Output Coverage Worker</em>'.
	 * @generated
	 */
	InputOutputCoverageWorker createInputOutputCoverageWorker();

	/**
	 * Returns a new object of class '<em>Condition Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Coverage Worker</em>'.
	 * @generated
	 */
	ConditionCoverageWorker createConditionCoverageWorker();

	/**
	 * Returns a new object of class '<em>Decision Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decision Coverage Worker</em>'.
	 * @generated
	 */
	DecisionCoverageWorker createDecisionCoverageWorker();

	/**
	 * Returns a new object of class '<em>Condition Decision Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Decision Coverage Worker</em>'.
	 * @generated
	 */
	ConditionDecisionCoverageWorker createConditionDecisionCoverageWorker();

	/**
	 * Returns a new object of class '<em>Modified Condition Decision Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modified Condition Decision Coverage Worker</em>'.
	 * @generated
	 */
	ModifiedConditionDecisionCoverageWorker createModifiedConditionDecisionCoverageWorker();

	/**
	 * Returns a new object of class '<em>Behavior Coverage Worker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Coverage Worker</em>'.
	 * @generated
	 */
	BehaviorCoverageWorker createBehaviorCoverageWorker();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CoveragePackage getCoveragePackage();

} //CoverageFactory
