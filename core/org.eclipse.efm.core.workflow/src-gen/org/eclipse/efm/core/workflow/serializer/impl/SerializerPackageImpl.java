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
package org.eclipse.efm.core.workflow.serializer.impl;

import org.eclipse.efm.core.workflow.WorkflowPackage;

import org.eclipse.efm.core.workflow.common.CommonPackage;

import org.eclipse.efm.core.workflow.common.impl.CommonPackageImpl;

import org.eclipse.efm.core.workflow.coverage.CoveragePackage;

import org.eclipse.efm.core.workflow.coverage.impl.CoveragePackageImpl;

import org.eclipse.efm.core.workflow.impl.WorkflowPackageImpl;

import org.eclipse.efm.core.workflow.serializer.BasicTraceSerializer;
import org.eclipse.efm.core.workflow.serializer.ModelGraphvizSerializerWorker;
import org.eclipse.efm.core.workflow.serializer.SerializerFactory;
import org.eclipse.efm.core.workflow.serializer.SerializerPackage;
import org.eclipse.efm.core.workflow.serializer.SymbexGraphVizSerializerWorker;
import org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer;

import org.eclipse.efm.core.workflow.test.TestPackage;

import org.eclipse.efm.core.workflow.test.impl.TestPackageImpl;

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
public class SerializerPackageImpl extends EPackageImpl implements SerializerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelGraphvizSerializerWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbexGraphVizSerializerWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicTraceSerializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ttcnTraceSerializerEClass = null;

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
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SerializerPackageImpl() {
		super(eNS_URI, SerializerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SerializerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SerializerPackage init() {
		if (isInited) return (SerializerPackage)EPackage.Registry.INSTANCE.getEPackage(SerializerPackage.eNS_URI);

		// Obtain or create and register package
		SerializerPackageImpl theSerializerPackage = (SerializerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SerializerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SerializerPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		WorkflowPackageImpl theWorkflowPackage = (WorkflowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI) instanceof WorkflowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI) : WorkflowPackage.eINSTANCE);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		CoveragePackageImpl theCoveragePackage = (CoveragePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CoveragePackage.eNS_URI) instanceof CoveragePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CoveragePackage.eNS_URI) : CoveragePackage.eINSTANCE);
		TestPackageImpl theTestPackage = (TestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI) instanceof TestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI) : TestPackage.eINSTANCE);

		// Create package meta-data objects
		theSerializerPackage.createPackageContents();
		theWorkflowPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theCoveragePackage.createPackageContents();
		theTestPackage.createPackageContents();

		// Initialize created meta-data
		theSerializerPackage.initializePackageContents();
		theWorkflowPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theCoveragePackage.initializePackageContents();
		theTestPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSerializerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SerializerPackage.eNS_URI, theSerializerPackage);
		return theSerializerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelGraphvizSerializerWorker() {
		return modelGraphvizSerializerWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSymbexGraphVizSerializerWorker() {
		return symbexGraphVizSerializerWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicTraceSerializer() {
		return basicTraceSerializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTCNTraceSerializer() {
		return ttcnTraceSerializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_EnabledCustomization() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_EnabledAdapters() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_ControlModuleName() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_DeclarationsModuleName() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_TemplatesModuleName() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_TestcasesModuleName() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_TestcasesStartingWrapper() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_TestcasesEndingWrapper() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_TestcasesSendingWrapper() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_TestcasesReceivingWrapper() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_AdaptationModuleName() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_AdaptationUtilsImpl() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_AdaptationStartingEndingImpl() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_AdaptationSendingImpl() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTCNTraceSerializer_AdaptationReceivingImpl() {
		return (EAttribute)ttcnTraceSerializerEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializerFactory getSerializerFactory() {
		return (SerializerFactory)getEFactoryInstance();
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
		modelGraphvizSerializerWorkerEClass = createEClass(MODEL_GRAPHVIZ_SERIALIZER_WORKER);

		symbexGraphVizSerializerWorkerEClass = createEClass(SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER);

		basicTraceSerializerEClass = createEClass(BASIC_TRACE_SERIALIZER);

		ttcnTraceSerializerEClass = createEClass(TTCN_TRACE_SERIALIZER);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__ENABLED_CUSTOMIZATION);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__ENABLED_ADAPTERS);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__CONTROL_MODULE_NAME);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__DECLARATIONS_MODULE_NAME);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__TEMPLATES_MODULE_NAME);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__TESTCASES_MODULE_NAME);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__TESTCASES_STARTING_WRAPPER);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__TESTCASES_ENDING_WRAPPER);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__TESTCASES_SENDING_WRAPPER);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__TESTCASES_RECEIVING_WRAPPER);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__ADAPTATION_MODULE_NAME);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__ADAPTATION_UTILS_IMPL);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__ADAPTATION_STARTING_ENDING_IMPL);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__ADAPTATION_SENDING_IMPL);
		createEAttribute(ttcnTraceSerializerEClass, TTCN_TRACE_SERIALIZER__ADAPTATION_RECEIVING_IMPL);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelGraphvizSerializerWorkerEClass.getESuperTypes().add(theWorkflowPackage.getSerializer());
		symbexGraphVizSerializerWorkerEClass.getESuperTypes().add(theWorkflowPackage.getSerializer());
		basicTraceSerializerEClass.getESuperTypes().add(theWorkflowPackage.getSerializer());
		ttcnTraceSerializerEClass.getESuperTypes().add(theWorkflowPackage.getSerializer());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelGraphvizSerializerWorkerEClass, ModelGraphvizSerializerWorker.class, "ModelGraphvizSerializerWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(symbexGraphVizSerializerWorkerEClass, SymbexGraphVizSerializerWorker.class, "SymbexGraphVizSerializerWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicTraceSerializerEClass, BasicTraceSerializer.class, "BasicTraceSerializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ttcnTraceSerializerEClass, TTCNTraceSerializer.class, "TTCNTraceSerializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTTCNTraceSerializer_EnabledCustomization(), ecorePackage.getEBoolean(), "enabledCustomization", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_EnabledAdapters(), ecorePackage.getEBoolean(), "enabledAdapters", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_ControlModuleName(), ecorePackage.getEString(), "controlModuleName", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_DeclarationsModuleName(), ecorePackage.getEString(), "declarationsModuleName", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_TemplatesModuleName(), ecorePackage.getEString(), "templatesModuleName", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_TestcasesModuleName(), ecorePackage.getEString(), "testcasesModuleName", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_TestcasesStartingWrapper(), ecorePackage.getEString(), "testcasesStartingWrapper", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_TestcasesEndingWrapper(), ecorePackage.getEString(), "testcasesEndingWrapper", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_TestcasesSendingWrapper(), ecorePackage.getEString(), "testcasesSendingWrapper", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_TestcasesReceivingWrapper(), ecorePackage.getEString(), "testcasesReceivingWrapper", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_AdaptationModuleName(), ecorePackage.getEString(), "adaptationModuleName", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_AdaptationUtilsImpl(), ecorePackage.getEString(), "adaptationUtilsImpl", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_AdaptationStartingEndingImpl(), ecorePackage.getEString(), "adaptationStartingEndingImpl", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_AdaptationSendingImpl(), ecorePackage.getEString(), "adaptationSendingImpl", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTCNTraceSerializer_AdaptationReceivingImpl(), ecorePackage.getEString(), "adaptationReceivingImpl", null, 0, 1, TTCNTraceSerializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //SerializerPackageImpl
