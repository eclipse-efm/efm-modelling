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

import org.eclipse.efm.execution.core.workflow.common.TraceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Serializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Serializer#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Serializer#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Serializer#getFolderName <em>Folder Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Serializer#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledNormalization <em>Enabled Normalization</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledInitialValuesPrinting <em>Enabled Initial Values Printing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledLifelinesPrinting <em>Enabled Lifelines Printing</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getSerializer()
 * @model abstract="true"
 * @generated
 */
public interface Serializer extends Worker {
	/**
	 * Returns the value of the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' containment reference.
	 * @see #setFormat(TraceSpecification)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getSerializer_Format()
	 * @model containment="true"
	 * @generated
	 */
	TraceSpecification getFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Serializer#getFormat <em>Format</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' containment reference.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(TraceSpecification value);

	/**
	 * Returns the value of the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' containment reference.
	 * @see #setTrace(TraceSpecification)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getSerializer_Trace()
	 * @model containment="true"
	 * @generated
	 */
	TraceSpecification getTrace();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Serializer#getTrace <em>Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' containment reference.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(TraceSpecification value);

	/**
	 * Returns the value of the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folder Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folder Name</em>' attribute.
	 * @see #setFolderName(String)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getSerializer_FolderName()
	 * @model
	 * @generated
	 */
	String getFolderName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Serializer#getFolderName <em>Folder Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folder Name</em>' attribute.
	 * @see #getFolderName()
	 * @generated
	 */
	void setFolderName(String value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getSerializer_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Serializer#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Normalization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Normalization</em>' attribute.
	 * @see #setEnabledNormalization(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getSerializer_EnabledNormalization()
	 * @model
	 * @generated
	 */
	boolean isEnabledNormalization();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledNormalization <em>Enabled Normalization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Normalization</em>' attribute.
	 * @see #isEnabledNormalization()
	 * @generated
	 */
	void setEnabledNormalization(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Initial Values Printing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Initial Values Printing</em>' attribute.
	 * @see #setEnabledInitialValuesPrinting(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getSerializer_EnabledInitialValuesPrinting()
	 * @model default="false"
	 * @generated
	 */
	boolean isEnabledInitialValuesPrinting();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledInitialValuesPrinting <em>Enabled Initial Values Printing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Initial Values Printing</em>' attribute.
	 * @see #isEnabledInitialValuesPrinting()
	 * @generated
	 */
	void setEnabledInitialValuesPrinting(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Lifelines Printing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Lifelines Printing</em>' attribute.
	 * @see #setEnabledLifelinesPrinting(boolean)
	 * @see org.eclipse.efm.execution.core.workflow.WorkflowPackage#getSerializer_EnabledLifelinesPrinting()
	 * @model default="false"
	 * @generated
	 */
	boolean isEnabledLifelinesPrinting();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.execution.core.workflow.Serializer#isEnabledLifelinesPrinting <em>Enabled Lifelines Printing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Lifelines Printing</em>' attribute.
	 * @see #isEnabledLifelinesPrinting()
	 * @generated
	 */
	void setEnabledLifelinesPrinting(boolean value);

} // Serializer
