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
package org.eclipse.efm.execution.core.workflow;

import java.util.List;

import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption;
import org.eclipse.efm.execution.core.workflow.common.Manifest;
import org.eclipse.efm.execution.core.workflow.common.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Director</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Director#getManifest <em>Manifest</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Director#getWorkflow <em>Workflow</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Director#getProject <em>Project</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Director#getSupervisor <em>Supervisor</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Director#getWorker <em>Worker</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Director#getConsole <em>Console</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Director#getDeveloperTuning <em>Developer Tuning</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getDirector()
 * @model
 * @generated
 */
public interface Director extends NamedObject {
	/**
	 * Returns the value of the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manifest</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manifest</em>' containment reference.
	 * @see #setManifest(Manifest)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getDirector_Manifest()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Manifest getManifest();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Director#getManifest <em>Manifest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest</em>' containment reference.
	 * @see #getManifest()
	 * @generated
	 */
	void setManifest(Manifest value);

	/**
	 * Returns the value of the '<em><b>Workflow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workflow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workflow</em>' reference.
	 * @see #setWorkflow(Workflow)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getDirector_Workflow()
	 * @model
	 * @generated
	 */
	Workflow getWorkflow();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Director#getWorkflow <em>Workflow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workflow</em>' reference.
	 * @see #getWorkflow()
	 * @generated
	 */
	void setWorkflow(Workflow value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(Project)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getDirector_Project()
	 * @model containment="true"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Director#getProject <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Supervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supervisor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supervisor</em>' containment reference.
	 * @see #setSupervisor(SupervisorWorker)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getDirector_Supervisor()
	 * @model containment="true"
	 * @generated
	 */
	SupervisorWorker getSupervisor();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Director#getSupervisor <em>Supervisor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supervisor</em>' containment reference.
	 * @see #getSupervisor()
	 * @generated
	 */
	void setSupervisor(SupervisorWorker value);

	/**
	 * Returns the value of the '<em><b>Worker</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.execution.core.workflow.Worker}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Worker</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Worker</em>' containment reference list.
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getDirector_Worker()
	 * @model containment="true"
	 * @generated
	 */
	List<Worker> getWorker();

	/**
	 * Returns the value of the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Console</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Console</em>' containment reference.
	 * @see #setConsole(ConsoleLogFormat)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getDirector_Console()
	 * @model containment="true"
	 * @generated
	 */
	ConsoleLogFormat getConsole();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Director#getConsole <em>Console</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Console</em>' containment reference.
	 * @see #getConsole()
	 * @generated
	 */
	void setConsole(ConsoleLogFormat value);

	/**
	 * Returns the value of the '<em><b>Developer Tuning</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Developer Tuning</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Developer Tuning</em>' containment reference.
	 * @see #setDeveloperTuning(DeveloperTuningOption)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getDirector_DeveloperTuning()
	 * @model containment="true"
	 * @generated
	 */
	DeveloperTuningOption getDeveloperTuning();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Director#getDeveloperTuning <em>Developer Tuning</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Developer Tuning</em>' containment reference.
	 * @see #getDeveloperTuning()
	 * @generated
	 */
	void setDeveloperTuning(DeveloperTuningOption value);

} // Director
