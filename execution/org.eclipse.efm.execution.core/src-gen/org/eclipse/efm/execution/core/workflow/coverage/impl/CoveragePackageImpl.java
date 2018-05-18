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
package org.eclipse.efm.execution.core.workflow.coverage.impl;

import org.eclipse.efm.execution.core.workflow.WorkflowPackage;

import org.eclipse.efm.execution.core.workflow.common.CommonPackage;

import org.eclipse.efm.execution.core.workflow.common.impl.CommonPackageImpl;

import org.eclipse.efm.execution.core.workflow.coverage.BehaviorCoverageWorker;
import org.eclipse.efm.execution.core.workflow.coverage.ConditionCoverageWorker;
import org.eclipse.efm.execution.core.workflow.coverage.ConditionDecisionCoverageWorker;
import org.eclipse.efm.execution.core.workflow.coverage.CoverageFactory;
import org.eclipse.efm.execution.core.workflow.coverage.CoveragePackage;
import org.eclipse.efm.execution.core.workflow.coverage.DecisionCoverageWorker;
import org.eclipse.efm.execution.core.workflow.coverage.InputOutputCoverageWorker;
import org.eclipse.efm.execution.core.workflow.coverage.ModifiedConditionDecisionCoverageWorker;
import org.eclipse.efm.execution.core.workflow.coverage.TransitionCoverageWorker;

import org.eclipse.efm.execution.core.workflow.extraneous.ExtraneousPackage;

import org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousPackageImpl;

import org.eclipse.efm.execution.core.workflow.impl.WorkflowPackageImpl;

import org.eclipse.efm.execution.core.workflow.serializer.SerializerPackage;

import org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl;

import org.eclipse.efm.execution.core.workflow.test.TestPackage;

import org.eclipse.efm.execution.core.workflow.test.impl.TestPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoveragePackageImpl extends EPackageImpl implements CoveragePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionCoverageWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputOutputCoverageWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionCoverageWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionCoverageWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionDecisionCoverageWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiedConditionDecisionCoverageWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorCoverageWorkerEClass = null;

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
	 * @see org.eclipse.efm.execution.core.workflow.coverage.CoveragePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CoveragePackageImpl() {
		super(eNS_URI, CoverageFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CoveragePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CoveragePackage init() {
		if (isInited) return (CoveragePackage)EPackage.Registry.INSTANCE.getEPackage(CoveragePackage.eNS_URI);

		// Obtain or create and register package
		CoveragePackageImpl theCoveragePackage = (CoveragePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CoveragePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CoveragePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		WorkflowPackageImpl theWorkflowPackage = (WorkflowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI) instanceof WorkflowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI) : WorkflowPackage.eINSTANCE);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		ExtraneousPackageImpl theExtraneousPackage = (ExtraneousPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtraneousPackage.eNS_URI) instanceof ExtraneousPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtraneousPackage.eNS_URI) : ExtraneousPackage.eINSTANCE);
		TestPackageImpl theTestPackage = (TestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI) instanceof TestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI) : TestPackage.eINSTANCE);
		SerializerPackageImpl theSerializerPackage = (SerializerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SerializerPackage.eNS_URI) instanceof SerializerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SerializerPackage.eNS_URI) : SerializerPackage.eINSTANCE);

		// Create package meta-data objects
		theCoveragePackage.createPackageContents();
		theWorkflowPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theExtraneousPackage.createPackageContents();
		theTestPackage.createPackageContents();
		theSerializerPackage.createPackageContents();

		// Initialize created meta-data
		theCoveragePackage.initializePackageContents();
		theWorkflowPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theExtraneousPackage.initializePackageContents();
		theTestPackage.initializePackageContents();
		theSerializerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCoveragePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CoveragePackage.eNS_URI, theCoveragePackage);
		return theCoveragePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionCoverageWorker() {
		return transitionCoverageWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputOutputCoverageWorker() {
		return inputOutputCoverageWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionCoverageWorker() {
		return conditionCoverageWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecisionCoverageWorker() {
		return decisionCoverageWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionDecisionCoverageWorker() {
		return conditionDecisionCoverageWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiedConditionDecisionCoverageWorker() {
		return modifiedConditionDecisionCoverageWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorCoverageWorker() {
		return behaviorCoverageWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_CheckingScope() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_OrderedTrace() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_HitConsecutive() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_HitFolding() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_HitLucky() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_HitMax() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_HitFinal() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_JumpHeight() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_JumpTrialsLimit() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_HitCount() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_JumpCount() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorCoverageWorker_JumpSlice() {
		return (EAttribute)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorCoverageWorker_Behavior() {
		return (EReference)behaviorCoverageWorkerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageFactory getCoverageFactory() {
		return (CoverageFactory)getEFactoryInstance();
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
		transitionCoverageWorkerEClass = createEClass(TRANSITION_COVERAGE_WORKER);

		inputOutputCoverageWorkerEClass = createEClass(INPUT_OUTPUT_COVERAGE_WORKER);

		conditionCoverageWorkerEClass = createEClass(CONDITION_COVERAGE_WORKER);

		decisionCoverageWorkerEClass = createEClass(DECISION_COVERAGE_WORKER);

		conditionDecisionCoverageWorkerEClass = createEClass(CONDITION_DECISION_COVERAGE_WORKER);

		modifiedConditionDecisionCoverageWorkerEClass = createEClass(MODIFIED_CONDITION_DECISION_COVERAGE_WORKER);

		behaviorCoverageWorkerEClass = createEClass(BEHAVIOR_COVERAGE_WORKER);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__CHECKING_SCOPE);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__ORDERED_TRACE);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__HIT_CONSECUTIVE);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__HIT_FOLDING);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__HIT_LUCKY);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__HIT_MAX);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__HIT_FINAL);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__JUMP_HEIGHT);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__JUMP_TRIALS_LIMIT);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__HIT_COUNT);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__JUMP_COUNT);
		createEAttribute(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__JUMP_SLICE);
		createEReference(behaviorCoverageWorkerEClass, BEHAVIOR_COVERAGE_WORKER__BEHAVIOR);
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
		transitionCoverageWorkerEClass.getESuperTypes().add(theWorkflowPackage.getCoverageWorker());
		inputOutputCoverageWorkerEClass.getESuperTypes().add(theWorkflowPackage.getCoverageWorker());
		conditionCoverageWorkerEClass.getESuperTypes().add(theWorkflowPackage.getCoverageWorker());
		decisionCoverageWorkerEClass.getESuperTypes().add(theWorkflowPackage.getCoverageWorker());
		conditionDecisionCoverageWorkerEClass.getESuperTypes().add(theWorkflowPackage.getCoverageWorker());
		modifiedConditionDecisionCoverageWorkerEClass.getESuperTypes().add(theWorkflowPackage.getCoverageWorker());
		behaviorCoverageWorkerEClass.getESuperTypes().add(theWorkflowPackage.getCoverageWorker());

		// Initialize classes, features, and operations; add parameters
		initEClass(transitionCoverageWorkerEClass, TransitionCoverageWorker.class, "TransitionCoverageWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputOutputCoverageWorkerEClass, InputOutputCoverageWorker.class, "InputOutputCoverageWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionCoverageWorkerEClass, ConditionCoverageWorker.class, "ConditionCoverageWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(decisionCoverageWorkerEClass, DecisionCoverageWorker.class, "DecisionCoverageWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionDecisionCoverageWorkerEClass, ConditionDecisionCoverageWorker.class, "ConditionDecisionCoverageWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modifiedConditionDecisionCoverageWorkerEClass, ModifiedConditionDecisionCoverageWorker.class, "ModifiedConditionDecisionCoverageWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorCoverageWorkerEClass, BehaviorCoverageWorker.class, "BehaviorCoverageWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBehaviorCoverageWorker_CheckingScope(), theCommonPackage.getCheckingScopeKind(), "checkingScope", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_OrderedTrace(), ecorePackage.getEBoolean(), "orderedTrace", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_HitConsecutive(), ecorePackage.getEBoolean(), "hitConsecutive", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_HitFolding(), ecorePackage.getEBoolean(), "hitFolding", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_HitLucky(), ecorePackage.getEBoolean(), "hitLucky", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_HitMax(), ecorePackage.getEBoolean(), "hitMax", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_HitFinal(), ecorePackage.getEBoolean(), "hitFinal", "true", 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_JumpHeight(), ecorePackage.getEInt(), "jumpHeight", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_JumpTrialsLimit(), ecorePackage.getEInt(), "jumpTrialsLimit", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_HitCount(), ecorePackage.getEInt(), "hitCount", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_JumpCount(), ecorePackage.getEInt(), "jumpCount", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorCoverageWorker_JumpSlice(), ecorePackage.getEBoolean(), "jumpSlice", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorCoverageWorker_Behavior(), theCommonPackage.getTraceSpecification(), null, "behavior", null, 0, 1, BehaviorCoverageWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //CoveragePackageImpl
