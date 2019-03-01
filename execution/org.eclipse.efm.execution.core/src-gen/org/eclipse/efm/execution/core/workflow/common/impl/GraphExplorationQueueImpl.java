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
package org.eclipse.efm.execution.core.workflow.common.impl;

import org.eclipse.efm.execution.core.workflow.common.CommonPackage;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Exploration Queue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationQueueImpl#getStrategy <em>Strategy</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationQueueImpl#isHeuristicEnabled <em>Heuristic Enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationQueueImpl#getWeight <em>Weight</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphExplorationQueueImpl extends MinimalEObjectImpl.Container implements GraphExplorationQueue {
	/**
	 * The default value of the '{@link #getStrategy() <em>Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategy()
	 * @generated
	 * @ordered
	 */
	protected static final GraphExplorationStrategyKind STRATEGY_EDEFAULT = GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;

	/**
	 * The cached value of the '{@link #getStrategy() <em>Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategy()
	 * @generated
	 * @ordered
	 */
	protected GraphExplorationStrategyKind strategy = STRATEGY_EDEFAULT;

	/**
	 * The default value of the '{@link #isHeuristicEnabled() <em>Heuristic Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeuristicEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HEURISTIC_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHeuristicEnabled() <em>Heuristic Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeuristicEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean heuristicEnabled = HEURISTIC_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int WEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected int weight = WEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphExplorationQueueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.GRAPH_EXPLORATION_QUEUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphExplorationStrategyKind getStrategy() {
		return strategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStrategy(GraphExplorationStrategyKind newStrategy) {
		GraphExplorationStrategyKind oldStrategy = strategy;
		strategy = newStrategy == null ? STRATEGY_EDEFAULT : newStrategy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_QUEUE__STRATEGY, oldStrategy, strategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHeuristicEnabled() {
		return heuristicEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeuristicEnabled(boolean newHeuristicEnabled) {
		boolean oldHeuristicEnabled = heuristicEnabled;
		heuristicEnabled = newHeuristicEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC_ENABLED, oldHeuristicEnabled, heuristicEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWeight(int newWeight) {
		int oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_QUEUE__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__STRATEGY:
				return getStrategy();
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC_ENABLED:
				return isHeuristicEnabled();
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__WEIGHT:
				return getWeight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__STRATEGY:
				setStrategy((GraphExplorationStrategyKind)newValue);
				return;
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC_ENABLED:
				setHeuristicEnabled((Boolean)newValue);
				return;
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__WEIGHT:
				setWeight((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__STRATEGY:
				setStrategy(STRATEGY_EDEFAULT);
				return;
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC_ENABLED:
				setHeuristicEnabled(HEURISTIC_ENABLED_EDEFAULT);
				return;
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__STRATEGY:
				return strategy != STRATEGY_EDEFAULT;
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC_ENABLED:
				return heuristicEnabled != HEURISTIC_ENABLED_EDEFAULT;
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (strategy: ");
		result.append(strategy);
		result.append(", heuristicEnabled: ");
		result.append(heuristicEnabled);
		result.append(", weight: ");
		result.append(weight);
		result.append(')');
		return result.toString();
	}

} //GraphExplorationQueueImpl
