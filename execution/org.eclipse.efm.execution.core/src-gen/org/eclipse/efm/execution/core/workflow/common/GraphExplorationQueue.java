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
package org.eclipse.efm.execution.core.workflow.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Exploration Queue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#getStrategy <em>Strategy</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#isHeuristicEnabled <em>Heuristic Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#getWeight <em>Weight</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationQueue()
 * @model
 * @generated
 */
public interface GraphExplorationQueue extends EObject {
	/**
	 * Returns the value of the '<em><b>Strategy</b></em>' attribute.
	 * The default value is <code>"BREADTH_FIRST_SEARCH"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategy</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind
	 * @see #setStrategy(GraphExplorationStrategyKind)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationQueue_Strategy()
	 * @model default="BREADTH_FIRST_SEARCH"
	 * @generated
	 */
	GraphExplorationStrategyKind getStrategy();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#getStrategy <em>Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strategy</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind
	 * @see #getStrategy()
	 * @generated
	 */
	void setStrategy(GraphExplorationStrategyKind value);

	/**
	 * Returns the value of the '<em><b>Heuristic Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heuristic Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heuristic Enabled</em>' attribute.
	 * @see #setHeuristicEnabled(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationQueue_HeuristicEnabled()
	 * @model
	 * @generated
	 */
	boolean isHeuristicEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#isHeuristicEnabled <em>Heuristic Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heuristic Enabled</em>' attribute.
	 * @see #isHeuristicEnabled()
	 * @generated
	 */
	void setHeuristicEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationQueue_Weight()
	 * @model
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

} // GraphExplorationQueue
