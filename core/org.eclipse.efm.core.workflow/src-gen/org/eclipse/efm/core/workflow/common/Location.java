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
package org.eclipse.efm.core.workflow.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.core.workflow.common.Location#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.Location#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.Location#getLog <em>Log</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.Location#getDebug <em>Debug</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' attribute.
	 * @see #setRoot(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getLocation_Root()
	 * @model
	 * @generated
	 */
	String getRoot();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.Location#getRoot <em>Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' attribute.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(String value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * The default value is <code>"output"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getLocation_Output()
	 * @model default="output"
	 * @generated
	 */
	String getOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.Location#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(String value);

	/**
	 * Returns the value of the '<em><b>Log</b></em>' attribute.
	 * The default value is <code>"log"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log</em>' attribute.
	 * @see #setLog(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getLocation_Log()
	 * @model default="log"
	 * @generated
	 */
	String getLog();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.Location#getLog <em>Log</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log</em>' attribute.
	 * @see #getLog()
	 * @generated
	 */
	void setLog(String value);

	/**
	 * Returns the value of the '<em><b>Debug</b></em>' attribute.
	 * The default value is <code>"debug"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug</em>' attribute.
	 * @see #setDebug(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getLocation_Debug()
	 * @model default="debug"
	 * @generated
	 */
	String getDebug();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.Location#getDebug <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug</em>' attribute.
	 * @see #getDebug()
	 * @generated
	 */
	void setDebug(String value);

} // Location
