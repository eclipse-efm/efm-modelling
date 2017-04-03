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
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Exploration Limit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl#getEval <em>Eval</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl#getReport <em>Report</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.impl.GraphExplorationLimitImpl#getSave <em>Save</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphExplorationLimitImpl extends MinimalEObjectImpl.Container implements GraphExplorationLimit {
	/**
	 * The default value of the '{@link #getEval() <em>Eval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEval()
	 * @generated
	 * @ordered
	 */
	protected static final long EVAL_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEval() <em>Eval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEval()
	 * @generated
	 * @ordered
	 */
	protected long eval = EVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getNode() <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected static final long NODE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected long node = NODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final long HEIGHT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected long height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final long WIDTH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected long width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getReport() <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReport()
	 * @generated
	 * @ordered
	 */
	protected static final long REPORT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getReport() <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReport()
	 * @generated
	 * @ordered
	 */
	protected long report = REPORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSave() <em>Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSave()
	 * @generated
	 * @ordered
	 */
	protected static final long SAVE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSave() <em>Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSave()
	 * @generated
	 * @ordered
	 */
	protected long save = SAVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphExplorationLimitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.GRAPH_EXPLORATION_LIMIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEval() {
		return eval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEval(long newEval) {
		long oldEval = eval;
		eval = newEval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_LIMIT__EVAL, oldEval, eval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(long newNode) {
		long oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_LIMIT__NODE, oldNode, node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(long newHeight) {
		long oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_LIMIT__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(long newWidth) {
		long oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_LIMIT__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getReport() {
		return report;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReport(long newReport) {
		long oldReport = report;
		report = newReport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_LIMIT__REPORT, oldReport, report));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSave() {
		return save;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSave(long newSave) {
		long oldSave = save;
		save = newSave;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.GRAPH_EXPLORATION_LIMIT__SAVE, oldSave, save));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__EVAL:
				return getEval();
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__NODE:
				return getNode();
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__HEIGHT:
				return getHeight();
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__WIDTH:
				return getWidth();
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__REPORT:
				return getReport();
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__SAVE:
				return getSave();
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
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__EVAL:
				setEval((Long)newValue);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__NODE:
				setNode((Long)newValue);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__HEIGHT:
				setHeight((Long)newValue);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__WIDTH:
				setWidth((Long)newValue);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__REPORT:
				setReport((Long)newValue);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__SAVE:
				setSave((Long)newValue);
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
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__EVAL:
				setEval(EVAL_EDEFAULT);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__NODE:
				setNode(NODE_EDEFAULT);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__REPORT:
				setReport(REPORT_EDEFAULT);
				return;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__SAVE:
				setSave(SAVE_EDEFAULT);
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
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__EVAL:
				return eval != EVAL_EDEFAULT;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__NODE:
				return node != NODE_EDEFAULT;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__WIDTH:
				return width != WIDTH_EDEFAULT;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__REPORT:
				return report != REPORT_EDEFAULT;
			case CommonPackage.GRAPH_EXPLORATION_LIMIT__SAVE:
				return save != SAVE_EDEFAULT;
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
		result.append(" (eval: ");
		result.append(eval);
		result.append(", node: ");
		result.append(node);
		result.append(", height: ");
		result.append(height);
		result.append(", width: ");
		result.append(width);
		result.append(", report: ");
		result.append(report);
		result.append(", save: ");
		result.append(save);
		result.append(')');
		return result.toString();
	}

} //GraphExplorationLimitImpl
