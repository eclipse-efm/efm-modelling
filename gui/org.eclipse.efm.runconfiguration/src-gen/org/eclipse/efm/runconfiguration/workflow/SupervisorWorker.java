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
package org.eclipse.efm.runconfiguration.workflow;

import org.eclipse.efm.runconfiguration.workflow.common.GraphExplorationLimit;
import org.eclipse.efm.runconfiguration.workflow.common.GraphExplorationQueue;
import org.eclipse.efm.runconfiguration.workflow.common.TraceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supervisor Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.SupervisorWorker#getLimit <em>Limit</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.SupervisorWorker#getQueue <em>Queue</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.SupervisorWorker#getExtender <em>Extender</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getSupervisorWorker()
 * @model
 * @generated
 */
public interface SupervisorWorker extends Worker {
	/**
	 * Returns the value of the '<em><b>Limit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Limit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit</em>' containment reference.
	 * @see #setLimit(GraphExplorationLimit)
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getSupervisorWorker_Limit()
	 * @model containment="true"
	 * @generated
	 */
	GraphExplorationLimit getLimit();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.SupervisorWorker#getLimit <em>Limit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit</em>' containment reference.
	 * @see #getLimit()
	 * @generated
	 */
	void setLimit(GraphExplorationLimit value);

	/**
	 * Returns the value of the '<em><b>Queue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue</em>' containment reference.
	 * @see #setQueue(GraphExplorationQueue)
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getSupervisorWorker_Queue()
	 * @model containment="true"
	 * @generated
	 */
	GraphExplorationQueue getQueue();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.SupervisorWorker#getQueue <em>Queue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue</em>' containment reference.
	 * @see #getQueue()
	 * @generated
	 */
	void setQueue(GraphExplorationQueue value);

	/**
	 * Returns the value of the '<em><b>Extender</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extender</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extender</em>' containment reference.
	 * @see #setExtender(TraceSpecification)
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getSupervisorWorker_Extender()
	 * @model containment="true"
	 * @generated
	 */
	TraceSpecification getExtender();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.SupervisorWorker#getExtender <em>Extender</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extender</em>' containment reference.
	 * @see #getExtender()
	 * @generated
	 */
	void setExtender(TraceSpecification value);

} // SupervisorWorker
