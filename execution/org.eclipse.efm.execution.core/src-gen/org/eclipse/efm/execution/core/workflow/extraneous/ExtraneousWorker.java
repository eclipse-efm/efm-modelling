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
package org.eclipse.efm.execution.core.workflow.extraneous;

import java.util.List;

import org.eclipse.efm.execution.core.workflow.Worker;

import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker#getExtraSEW <em>Extra SEW</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker#getAnalysisProfileRequired <em>Analysis Profile Required</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousPackage#getExtraneousWorker()
 * @model abstract="true"
 * @generated
 */
public interface ExtraneousWorker extends Worker {
	/**
	 * Returns the value of the '<em><b>Extra SEW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extra SEW</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extra SEW</em>' attribute.
	 * @see #setExtraSEW(String)
	 * @see org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousPackage#getExtraneousWorker_ExtraSEW()
	 * @model
	 * @generated
	 */
	String getExtraSEW();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker#getExtraSEW <em>Extra SEW</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extra SEW</em>' attribute.
	 * @see #getExtraSEW()
	 * @generated
	 */
	void setExtraSEW(String value);

	/**
	 * Returns the value of the '<em><b>Analysis Profile Required</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind}.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Profile Required</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Profile Required</em>' attribute list.
	 * @see org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind
	 * @see org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousPackage#getExtraneousWorker_AnalysisProfileRequired()
	 * @model default="Exploration"
	 * @generated
	 */
	List<AnalysisProfileKind> getAnalysisProfileRequired();

} // ExtraneousWorker
