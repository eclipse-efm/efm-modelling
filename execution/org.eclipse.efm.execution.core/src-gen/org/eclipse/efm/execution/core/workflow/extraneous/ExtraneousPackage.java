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

import org.eclipse.efm.execution.core.workflow.WorkflowPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousFactory
 * @model kind="package"
 * @generated
 */
public interface ExtraneousPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "extraneous";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/Workflow/Extraneous";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Extraneous";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtraneousPackage eINSTANCE = org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousWorkerImpl <em>Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousPackageImpl#getExtraneousWorker()
	 * @generated
	 */
	int EXTRANEOUS_WORKER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER__NAME = WorkflowPackage.WORKER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER__DESCRIPTION = WorkflowPackage.WORKER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER__COMMENT = WorkflowPackage.WORKER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER__MANIFEST = WorkflowPackage.WORKER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER__DIRECTOR = WorkflowPackage.WORKER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER__CONSOLE = WorkflowPackage.WORKER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Extra SEW</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER__EXTRA_SEW = WorkflowPackage.WORKER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Analysis Profile Required</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER__ANALYSIS_PROFILE_REQUIRED = WorkflowPackage.WORKER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER_FEATURE_COUNT = WorkflowPackage.WORKER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRANEOUS_WORKER_OPERATION_COUNT = WorkflowPackage.WORKER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker <em>Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker
	 * @generated
	 */
	EClass getExtraneousWorker();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker#getExtraSEW <em>Extra SEW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extra SEW</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker#getExtraSEW()
	 * @see #getExtraneousWorker()
	 * @generated
	 */
	EAttribute getExtraneousWorker_ExtraSEW();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker#getAnalysisProfileRequired <em>Analysis Profile Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Analysis Profile Required</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker#getAnalysisProfileRequired()
	 * @see #getExtraneousWorker()
	 * @generated
	 */
	EAttribute getExtraneousWorker_AnalysisProfileRequired();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtraneousFactory getExtraneousFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousWorkerImpl <em>Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousPackageImpl#getExtraneousWorker()
		 * @generated
		 */
		EClass EXTRANEOUS_WORKER = eINSTANCE.getExtraneousWorker();

		/**
		 * The meta object literal for the '<em><b>Extra SEW</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTRANEOUS_WORKER__EXTRA_SEW = eINSTANCE.getExtraneousWorker_ExtraSEW();

		/**
		 * The meta object literal for the '<em><b>Analysis Profile Required</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTRANEOUS_WORKER__ANALYSIS_PROFILE_REQUIRED = eINSTANCE.getExtraneousWorker_AnalysisProfileRequired();

	}

} //ExtraneousPackage
