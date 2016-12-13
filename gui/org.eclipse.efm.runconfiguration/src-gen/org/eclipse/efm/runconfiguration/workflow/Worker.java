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
import org.eclipse.efm.runconfiguration.workflow.common.Manifest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Worker#getManifest <em>Manifest</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Worker#getDirector <em>Director</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.Worker#getConsole <em>Console</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorker()
 * @model
 * @generated
 */
public interface Worker extends NamedObject {
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
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorker_Manifest()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Manifest getManifest();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Worker#getManifest <em>Manifest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest</em>' containment reference.
	 * @see #getManifest()
	 * @generated
	 */
	void setManifest(Manifest value);

	/**
	 * Returns the value of the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Director</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Director</em>' reference.
	 * @see #setDirector(Director)
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorker_Director()
	 * @model
	 * @generated
	 */
	Director getDirector();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Worker#getDirector <em>Director</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Director</em>' reference.
	 * @see #getDirector()
	 * @generated
	 */
	void setDirector(Director value);

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
	 * @see org.eclipse.efm.runconfiguration.workflow.WorkflowPackage#getWorker_Console()
	 * @model containment="true"
	 * @generated
	 */
	ConsoleLogFormat getConsole();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.Worker#getConsole <em>Console</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Console</em>' containment reference.
	 * @see #getConsole()
	 * @generated
	 */
	void setConsole(ConsoleLogFormat value);

} // Worker
