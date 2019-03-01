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
 * A representation of the model object '<em><b>Manifest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.Manifest#isAutoconf <em>Autoconf</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.Manifest#isAutostart <em>Autostart</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getManifest()
 * @model
 * @generated
 */
public interface Manifest extends EObject {
	/**
	 * Returns the value of the '<em><b>Autoconf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autoconf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autoconf</em>' attribute.
	 * @see #setAutoconf(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getManifest_Autoconf()
	 * @model required="true"
	 * @generated
	 */
	boolean isAutoconf();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.Manifest#isAutoconf <em>Autoconf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autoconf</em>' attribute.
	 * @see #isAutoconf()
	 * @generated
	 */
	void setAutoconf(boolean value);

	/**
	 * Returns the value of the '<em><b>Autostart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autostart</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autostart</em>' attribute.
	 * @see #setAutostart(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getManifest_Autostart()
	 * @model required="true"
	 * @generated
	 */
	boolean isAutostart();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.Manifest#isAutostart <em>Autostart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autostart</em>' attribute.
	 * @see #isAutostart()
	 * @generated
	 */
	void setAutostart(boolean value);

} // Manifest
