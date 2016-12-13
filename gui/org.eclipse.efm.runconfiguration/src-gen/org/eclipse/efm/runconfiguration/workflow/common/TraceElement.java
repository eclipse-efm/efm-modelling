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
package org.eclipse.efm.runconfiguration.workflow.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.common.TraceElement#getNature <em>Nature</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.common.TraceElement#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.runconfiguration.workflow.common.CommonPackage#getTraceElement()
 * @model
 * @generated
 */
public interface TraceElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Nature</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.runconfiguration.workflow.common.TraceElementKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nature</em>' attribute.
	 * @see org.eclipse.efm.runconfiguration.workflow.common.TraceElementKind
	 * @see #setNature(TraceElementKind)
	 * @see org.eclipse.efm.runconfiguration.workflow.common.CommonPackage#getTraceElement_Nature()
	 * @model
	 * @generated
	 */
	TraceElementKind getNature();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.common.TraceElement#getNature <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nature</em>' attribute.
	 * @see org.eclipse.efm.runconfiguration.workflow.common.TraceElementKind
	 * @see #getNature()
	 * @generated
	 */
	void setNature(TraceElementKind value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.eclipse.efm.runconfiguration.workflow.common.CommonPackage#getTraceElement_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.runconfiguration.workflow.common.TraceElement#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

} // TraceElement
