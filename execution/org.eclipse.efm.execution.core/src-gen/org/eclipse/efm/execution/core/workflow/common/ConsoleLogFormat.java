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
 * A representation of the model object '<em><b>Console Log Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getBound <em>Bound</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getStep <em>Step</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getReport <em>Report</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getVerbosity <em>Verbosity</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getSpiderInit <em>Spider Init</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getSpiderStep <em>Spider Step</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getSpiderStop <em>Spider Stop</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat()
 * @model
 * @generated
 */
public interface ConsoleLogFormat extends EObject {
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_Format()
	 * @model
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound</em>' attribute.
	 * @see #setBound(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_Bound()
	 * @model
	 * @generated
	 */
	String getBound();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getBound <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound</em>' attribute.
	 * @see #getBound()
	 * @generated
	 */
	void setBound(String value);

	/**
	 * Returns the value of the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' attribute.
	 * @see #setStep(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_Step()
	 * @model
	 * @generated
	 */
	String getStep();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getStep <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step</em>' attribute.
	 * @see #getStep()
	 * @generated
	 */
	void setStep(String value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_Result()
	 * @model
	 * @generated
	 */
	String getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(String value);

	/**
	 * Returns the value of the '<em><b>Report</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Report</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Report</em>' attribute.
	 * @see #setReport(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_Report()
	 * @model
	 * @generated
	 */
	String getReport();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getReport <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Report</em>' attribute.
	 * @see #getReport()
	 * @generated
	 */
	void setReport(String value);

	/**
	 * Returns the value of the '<em><b>Verbosity</b></em>' attribute.
	 * The default value is <code>"UNDEFINED"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verbosity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verbosity</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind
	 * @see #setVerbosity(ConsoleVerbosityKind)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_Verbosity()
	 * @model default="UNDEFINED"
	 * @generated
	 */
	ConsoleVerbosityKind getVerbosity();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getVerbosity <em>Verbosity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verbosity</em>' attribute.
	 * @see org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind
	 * @see #getVerbosity()
	 * @generated
	 */
	void setVerbosity(ConsoleVerbosityKind value);

	/**
	 * Returns the value of the '<em><b>Spider Init</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spider Init</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spider Init</em>' attribute.
	 * @see #setSpiderInit(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_SpiderInit()
	 * @model
	 * @generated
	 */
	String getSpiderInit();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getSpiderInit <em>Spider Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spider Init</em>' attribute.
	 * @see #getSpiderInit()
	 * @generated
	 */
	void setSpiderInit(String value);

	/**
	 * Returns the value of the '<em><b>Spider Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spider Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spider Step</em>' attribute.
	 * @see #setSpiderStep(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_SpiderStep()
	 * @model
	 * @generated
	 */
	String getSpiderStep();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getSpiderStep <em>Spider Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spider Step</em>' attribute.
	 * @see #getSpiderStep()
	 * @generated
	 */
	void setSpiderStep(String value);

	/**
	 * Returns the value of the '<em><b>Spider Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spider Stop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spider Stop</em>' attribute.
	 * @see #setSpiderStop(String)
	 * @see org.eclipse.efm.execution.core.workflow.common.CommonPackage#getConsoleLogFormat_SpiderStop()
	 * @model
	 * @generated
	 */
	String getSpiderStop();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat#getSpiderStop <em>Spider Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spider Stop</em>' attribute.
	 * @see #getSpiderStop()
	 * @generated
	 */
	void setSpiderStop(String value);

} // ConsoleLogFormat
