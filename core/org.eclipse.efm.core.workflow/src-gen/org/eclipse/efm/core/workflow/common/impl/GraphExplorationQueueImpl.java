/**
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.efm.core.workflow.common.impl;

import org.eclipse.efm.core.workflow.common.CommonPackage;
import org.eclipse.efm.core.workflow.common.GraphExplorationQueue;
import org.eclipse.efm.core.workflow.common.GraphExplorationStrategyKind;

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
 *   <li>{@link org.eclipse.efm.core.workflow.common.impl.GraphExplorationQueueImpl#getStrategy <em>Strategy</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.impl.GraphExplorationQueueImpl#isHeuristic <em>Heuristic</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.impl.GraphExplorationQueueImpl#getWeight <em>Weight</em>}</li>
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
	 * The default value of the '{@link #isHeuristic() <em>Heuristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeuristic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HEURISTIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHeuristic() <em>Heuristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeuristic()
	 * @generated
	 * @ordered
	 */
	protected boolean heuristic = HEURISTIC_EDEFAULT;

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
	public GraphExplorationStrategyKind getStrategy() {
		return strategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public boolean isHeuristic() {
		return heuristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeuristic(boolean newHeuristic) {
		boolean oldHeuristic = heuristic;
		heuristic = newHeuristic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC, oldHeuristic, heuristic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC:
				return isHeuristic();
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
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC:
				setHeuristic((Boolean)newValue);
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
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC:
				setHeuristic(HEURISTIC_EDEFAULT);
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
			case CommonPackage.GRAPH_EXPLORATION_QUEUE__HEURISTIC:
				return heuristic != HEURISTIC_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (strategy: ");
		result.append(strategy);
		result.append(", heuristic: ");
		result.append(heuristic);
		result.append(", weight: ");
		result.append(weight);
		result.append(')');
		return result.toString();
	}

} //GraphExplorationQueueImpl
