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
package org.eclipse.efm.execution.core.workflow.extraneous.impl;

import org.eclipse.efm.execution.core.workflow.WorkflowPackage;

import org.eclipse.efm.execution.core.workflow.common.CommonPackage;

import org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl;

import org.eclipse.efm.execution.core.workflow.coverage.CoveragePackage;

import org.eclipse.efm.execution.core.workflow.coverage.impl.CoveragePackageImpl;

import org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousFactory;
import org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousPackage;
import org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousWorker;

import org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl;

import org.eclipse.efm.execution.core.workflow.serializer.SerializerPackage;

import org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl;

import org.eclipse.efm.execution.core.workflow.test.TestPackage;

import org.eclipse.efm.execution.core.workflow.test.impl.TestPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtraneousPackageImpl extends EPackageImpl implements ExtraneousPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extraneousWorkerEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExtraneousPackageImpl() {
		super(eNS_URI, ExtraneousFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ExtraneousPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExtraneousPackage init() {
		if (isInited) return (ExtraneousPackage)EPackage.Registry.INSTANCE.getEPackage(ExtraneousPackage.eNS_URI);

		// Obtain or create and register package
		ExtraneousPackageImpl theExtraneousPackage = (ExtraneousPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExtraneousPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExtraneousPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		WorkflowPackageImpl theWorkflowPackage = (WorkflowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI) instanceof WorkflowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI) : WorkflowPackage.eINSTANCE);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		CoveragePackageImpl theCoveragePackage = (CoveragePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CoveragePackage.eNS_URI) instanceof CoveragePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CoveragePackage.eNS_URI) : CoveragePackage.eINSTANCE);
		TestPackageImpl theTestPackage = (TestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI) instanceof TestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI) : TestPackage.eINSTANCE);
		SerializerPackageImpl theSerializerPackage = (SerializerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SerializerPackage.eNS_URI) instanceof SerializerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SerializerPackage.eNS_URI) : SerializerPackage.eINSTANCE);

		// Create package meta-data objects
		theExtraneousPackage.createPackageContents();
		theWorkflowPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theCoveragePackage.createPackageContents();
		theTestPackage.createPackageContents();
		theSerializerPackage.createPackageContents();

		// Initialize created meta-data
		theExtraneousPackage.initializePackageContents();
		theWorkflowPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theCoveragePackage.initializePackageContents();
		theTestPackage.initializePackageContents();
		theSerializerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExtraneousPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExtraneousPackage.eNS_URI, theExtraneousPackage);
		return theExtraneousPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtraneousWorker() {
		return extraneousWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtraneousWorker_ExtraSEW() {
		return (EAttribute)extraneousWorkerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtraneousWorker_AnalysisProfileRequired() {
		return (EAttribute)extraneousWorkerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtraneousFactory getExtraneousFactory() {
		return (ExtraneousFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		extraneousWorkerEClass = createEClass(EXTRANEOUS_WORKER);
		createEAttribute(extraneousWorkerEClass, EXTRANEOUS_WORKER__EXTRA_SEW);
		createEAttribute(extraneousWorkerEClass, EXTRANEOUS_WORKER__ANALYSIS_PROFILE_REQUIRED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		WorkflowPackage theWorkflowPackage = (WorkflowPackage)EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI);
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extraneousWorkerEClass.getESuperTypes().add(theWorkflowPackage.getWorker());

		// Initialize classes, features, and operations; add parameters
		initEClass(extraneousWorkerEClass, ExtraneousWorker.class, "ExtraneousWorker", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtraneousWorker_ExtraSEW(), ecorePackage.getEString(), "extraSEW", null, 0, 1, ExtraneousWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtraneousWorker_AnalysisProfileRequired(), theCommonPackage.getAnalysisProfileKind(), "AnalysisProfileRequired", "Exploration", 0, -1, ExtraneousWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //ExtraneousPackageImpl
