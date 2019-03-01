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
 * A representation of the model object '<em><b>Graph Exploration Limit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getStep <em>Step</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getEval <em>Eval</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getReport <em>Report</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getSave <em>Save</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationLimit()
 * @model
 * @generated
 */
public interface GraphExplorationLimit extends EObject {
	/**
	 * Returns the value of the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' attribute.
	 * @see #setStep(long)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationLimit_Step()
	 * @model required="true"
	 * @generated
	 */
	long getStep();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getStep <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step</em>' attribute.
	 * @see #getStep()
	 * @generated
	 */
	void setStep(long value);

	/**
	 * Returns the value of the '<em><b>Eval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eval</em>' attribute.
	 * @see #setEval(long)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationLimit_Eval()
	 * @model required="true"
	 * @generated
	 */
	long getEval();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getEval <em>Eval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eval</em>' attribute.
	 * @see #getEval()
	 * @generated
	 */
	void setEval(long value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' attribute.
	 * @see #setNode(long)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationLimit_Node()
	 * @model required="true"
	 * @generated
	 */
	long getNode();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getNode <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' attribute.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(long value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(long)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationLimit_Height()
	 * @model required="true"
	 * @generated
	 */
	long getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(long value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(long)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationLimit_Width()
	 * @model required="true"
	 * @generated
	 */
	long getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(long value);

	/**
	 * Returns the value of the '<em><b>Report</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Report</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Report</em>' attribute.
	 * @see #setReport(long)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationLimit_Report()
	 * @model required="true"
	 * @generated
	 */
	long getReport();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getReport <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Report</em>' attribute.
	 * @see #getReport()
	 * @generated
	 */
	void setReport(long value);

	/**
	 * Returns the value of the '<em><b>Save</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Save</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Save</em>' attribute.
	 * @see #setSave(long)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getGraphExplorationLimit_Save()
	 * @model required="true"
	 * @generated
	 */
	long getSave();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit#getSave <em>Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Save</em>' attribute.
	 * @see #getSave()
	 * @generated
	 */
	void setSave(long value);

} // GraphExplorationLimit
