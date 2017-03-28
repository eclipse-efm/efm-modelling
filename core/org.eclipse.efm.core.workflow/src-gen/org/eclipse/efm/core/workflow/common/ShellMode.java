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
 * A representation of the model object '<em><b>Shell Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.core.workflow.common.ShellMode#getStop <em>Stop</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getShellMode()
 * @model abstract="true"
 * @generated
 */
public interface ShellMode extends EObject {
	/**
	 * Returns the value of the '<em><b>Stop</b></em>' attribute.
	 * The default value is <code>"\"stop.symbex\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop</em>' attribute.
	 * @see #setStop(String)
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#getShellMode_Stop()
	 * @model default="\"stop.symbex\""
	 * @generated
	 */
	String getStop();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.common.ShellMode#getStop <em>Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop</em>' attribute.
	 * @see #getStop()
	 * @generated
	 */
	void setStop(String value);

} // ShellMode
