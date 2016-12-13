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

import org.eclipse.efm.runconfiguration.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.runconfiguration.workflow.common.DeveloperTuningOption;
import org.eclipse.efm.runconfiguration.workflow.common.Manifest;
import org.eclipse.efm.runconfiguration.workflow.common.ShellMode;
import org.eclipse.efm.runconfiguration.workflow.common.SymbexOption;
import org.eclipse.efm.runconfiguration.workflow.common.Workspace;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getManifest <em>Manifest</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getWorkspace <em>Workspace</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getDirector <em>Director</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getSymbexOption <em>Symbex Option</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getConsole <em>Console</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getShellMode <em>Shell Mode</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getDeveloperTuning <em>Developer Tuning</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorkflow()
 * @model
 * @generated
 */
public interface Workflow extends NamedObject {
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
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorkflow_Manifest()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Manifest getManifest();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getManifest <em>Manifest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest</em>' containment reference.
	 * @see #getManifest()
	 * @generated
	 */
	void setManifest(Manifest value);

	/**
	 * Returns the value of the '<em><b>Workspace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace</em>' containment reference.
	 * @see #setWorkspace(Workspace)
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorkflow_Workspace()
	 * @model containment="true"
	 * @generated
	 */
	Workspace getWorkspace();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getWorkspace <em>Workspace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace</em>' containment reference.
	 * @see #getWorkspace()
	 * @generated
	 */
	void setWorkspace(Workspace value);

	/**
	 * Returns the value of the '<em><b>Director</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.runconfiguration.workflow.Director}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Director</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Director</em>' containment reference list.
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorkflow_Director()
	 * @model containment="true"
	 * @generated
	 */
	EList<Director> getDirector();

	/**
	 * Returns the value of the '<em><b>Symbex Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbex Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbex Option</em>' containment reference.
	 * @see #setSymbexOption(SymbexOption)
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorkflow_SymbexOption()
	 * @model containment="true"
	 * @generated
	 */
	SymbexOption getSymbexOption();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getSymbexOption <em>Symbex Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbex Option</em>' containment reference.
	 * @see #getSymbexOption()
	 * @generated
	 */
	void setSymbexOption(SymbexOption value);

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
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorkflow_Console()
	 * @model containment="true"
	 * @generated
	 */
	ConsoleLogFormat getConsole();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getConsole <em>Console</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Console</em>' containment reference.
	 * @see #getConsole()
	 * @generated
	 */
	void setConsole(ConsoleLogFormat value);

	/**
	 * Returns the value of the '<em><b>Shell Mode</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shell Mode</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shell Mode</em>' containment reference.
	 * @see #setShellMode(ShellMode)
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorkflow_ShellMode()
	 * @model containment="true"
	 * @generated
	 */
	ShellMode getShellMode();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getShellMode <em>Shell Mode</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shell Mode</em>' containment reference.
	 * @see #getShellMode()
	 * @generated
	 */
	void setShellMode(ShellMode value);

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
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorkflow_DeveloperTuning()
	 * @model containment="true"
	 * @generated
	 */
	DeveloperTuningOption getDeveloperTuning();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Workflow#getDeveloperTuning <em>Developer Tuning</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Developer Tuning</em>' containment reference.
	 * @see #getDeveloperTuning()
	 * @generated
	 */
	void setDeveloperTuning(DeveloperTuningOption value);

} // Workflow
