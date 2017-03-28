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
package org.eclipse.efm.core.workflow.common.impl;

import org.eclipse.efm.core.workflow.WorkflowPackage;

import org.eclipse.efm.core.workflow.common.CheckingScopeKind;
import org.eclipse.efm.core.workflow.common.CommonFactory;
import org.eclipse.efm.core.workflow.common.CommonPackage;
import org.eclipse.efm.core.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.core.workflow.common.ConsoleVerbosityKind;
import org.eclipse.efm.core.workflow.common.CoverageHeuristic;
import org.eclipse.efm.core.workflow.common.CoverageScopeKind;
import org.eclipse.efm.core.workflow.common.DebuglevelKind;
import org.eclipse.efm.core.workflow.common.DeveloperTuningOption;
import org.eclipse.efm.core.workflow.common.GraphExplorationLimit;
import org.eclipse.efm.core.workflow.common.GraphExplorationQueue;
import org.eclipse.efm.core.workflow.common.GraphExplorationStrategyKind;
import org.eclipse.efm.core.workflow.common.HeuristicClassKind;
import org.eclipse.efm.core.workflow.common.Location;
import org.eclipse.efm.core.workflow.common.Manifest;
import org.eclipse.efm.core.workflow.common.Project;
import org.eclipse.efm.core.workflow.common.RedundancyDetection;
import org.eclipse.efm.core.workflow.common.ShellMode;
import org.eclipse.efm.core.workflow.common.SymbexOption;
import org.eclipse.efm.core.workflow.common.TraceElement;
import org.eclipse.efm.core.workflow.common.TraceElementKind;
import org.eclipse.efm.core.workflow.common.TraceSpecification;
import org.eclipse.efm.core.workflow.common.Workspace;

import org.eclipse.efm.core.workflow.coverage.CoveragePackage;

import org.eclipse.efm.core.workflow.coverage.impl.CoveragePackageImpl;

import org.eclipse.efm.core.workflow.impl.WorkflowPackageImpl;

import org.eclipse.efm.core.workflow.serializer.SerializerPackage;

import org.eclipse.efm.core.workflow.serializer.impl.SerializerPackageImpl;

import org.eclipse.efm.core.workflow.test.TestPackage;

import org.eclipse.efm.core.workflow.test.impl.TestPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphExplorationLimitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphExplorationQueueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consoleLogFormatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass manifestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbexOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shellModeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coverageHeuristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass developerTuningOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redundancyDetectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum graphExplorationStrategyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum consoleVerbosityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum traceElementKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum heuristicClassKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum coverageScopeKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum checkingScopeKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum debuglevelKindEEnum = null;

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
	 * @see org.eclipse.efm.core.workflow.common.CommonPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommonPackageImpl() {
		super(eNS_URI, CommonFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CommonPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommonPackage init() {
		if (isInited) return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Obtain or create and register package
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommonPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		WorkflowPackageImpl theWorkflowPackage = (WorkflowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI) instanceof WorkflowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI) : WorkflowPackage.eINSTANCE);
		CoveragePackageImpl theCoveragePackage = (CoveragePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CoveragePackage.eNS_URI) instanceof CoveragePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CoveragePackage.eNS_URI) : CoveragePackage.eINSTANCE);
		TestPackageImpl theTestPackage = (TestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI) instanceof TestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI) : TestPackage.eINSTANCE);
		SerializerPackageImpl theSerializerPackage = (SerializerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SerializerPackage.eNS_URI) instanceof SerializerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SerializerPackage.eNS_URI) : SerializerPackage.eINSTANCE);

		// Create package meta-data objects
		theCommonPackage.createPackageContents();
		theWorkflowPackage.createPackageContents();
		theCoveragePackage.createPackageContents();
		theTestPackage.createPackageContents();
		theSerializerPackage.createPackageContents();

		// Initialize created meta-data
		theCommonPackage.initializePackageContents();
		theWorkflowPackage.initializePackageContents();
		theCoveragePackage.initializePackageContents();
		theTestPackage.initializePackageContents();
		theSerializerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommonPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommonPackage.eNS_URI, theCommonPackage);
		return theCommonPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspace() {
		return workspaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspace_Location() {
		return (EReference)workspaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspace_Project() {
		return (EReference)workspaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocation() {
		return locationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocation_Root() {
		return (EAttribute)locationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocation_Output() {
		return (EAttribute)locationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocation_Log() {
		return (EAttribute)locationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocation_Debug() {
		return (EAttribute)locationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Source() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Model() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphExplorationLimit() {
		return graphExplorationLimitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationLimit_Eval() {
		return (EAttribute)graphExplorationLimitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationLimit_Node() {
		return (EAttribute)graphExplorationLimitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationLimit_Height() {
		return (EAttribute)graphExplorationLimitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationLimit_Width() {
		return (EAttribute)graphExplorationLimitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationLimit_Report() {
		return (EAttribute)graphExplorationLimitEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationLimit_Save() {
		return (EAttribute)graphExplorationLimitEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphExplorationQueue() {
		return graphExplorationQueueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationQueue_Strategy() {
		return (EAttribute)graphExplorationQueueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationQueue_Heuristic() {
		return (EAttribute)graphExplorationQueueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphExplorationQueue_Weight() {
		return (EAttribute)graphExplorationQueueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConsoleLogFormat() {
		return consoleLogFormatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsoleLogFormat_Format() {
		return (EAttribute)consoleLogFormatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsoleLogFormat_Bound() {
		return (EAttribute)consoleLogFormatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsoleLogFormat_Step() {
		return (EAttribute)consoleLogFormatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsoleLogFormat_Result() {
		return (EAttribute)consoleLogFormatEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsoleLogFormat_Report() {
		return (EAttribute)consoleLogFormatEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsoleLogFormat_Verbosity() {
		return (EAttribute)consoleLogFormatEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceElement() {
		return traceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceElement_Nature() {
		return (EAttribute)traceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceElement_Value() {
		return (EAttribute)traceElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceSpecification() {
		return traceSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceSpecification_Element() {
		return (EReference)traceSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManifest() {
		return manifestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManifest_Autoconf() {
		return (EAttribute)manifestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManifest_Autostart() {
		return (EAttribute)manifestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSymbexOption() {
		return symbexOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShellMode() {
		return shellModeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShellMode_Stop() {
		return (EAttribute)shellModeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoverageHeuristic() {
		return coverageHeuristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_HeuristicTrials() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_ObjectiveRateGoal() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_ObjectiveRestGoal() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_HeuristicStart() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_DirectiveTraceCount() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_DirectiveTraceSize() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_DirectiveTraceHeuristic() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_LookaheadDepth() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_LookaheadWidth() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_HitStronglyRandomEnabled() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_HitStronglyCount() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_HitWeaklyRandomEnabled() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_HitWeaklyCount() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_HitOtherRandomEnabled() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageHeuristic_HitOtherCount() {
		return (EAttribute)coverageHeuristicEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeveloperTuningOption() {
		return developerTuningOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_LogTraceFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_DebugTraceFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_DebugLevel() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_DebugFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_OutputFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_SpecificationFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_ExecutableFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_SymbexGraphFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_ParsedModelFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_CompiledModelFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_SymbexTraceFilename() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledParsing() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledConfiguring() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledCompiling() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledLoading() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledComputing() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledReporting() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledSolver() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledProfiling() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledAllProcessStage() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledPreProcessing() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledPostProcessing() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledProcessing() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledPreFiltering() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledPostFiltering() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledFiltering() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledQueue() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledProgram() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledStatement() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledStatementAssignment() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledStatementCommunication() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledStatementTestDecision() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledBytecode() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledData() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledTrace() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledVariable() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledBuffer() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledPort() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledSignal() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledConnexion() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledTime() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledExecutable() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledActivity() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledRoutine() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledTransition() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledMachine() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledStatemachine() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledNameId() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledQualifiedNameId() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledFullyQualifiedNameId() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledRedundance() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledReferenceCounting() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledNothing() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeveloperTuningOption_EnabledGodMode() {
		return (EAttribute)developerTuningOptionEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedundancyDetection() {
		return redundancyDetectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedundancyDetection_Comparer() {
		return (EAttribute)redundancyDetectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedundancyDetection_Solver() {
		return (EAttribute)redundancyDetectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedundancyDetection_PathScope() {
		return (EAttribute)redundancyDetectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedundancyDetection_DataScope() {
		return (EAttribute)redundancyDetectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGraphExplorationStrategyKind() {
		return graphExplorationStrategyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConsoleVerbosityKind() {
		return consoleVerbosityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTraceElementKind() {
		return traceElementKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHeuristicClassKind() {
		return heuristicClassKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCoverageScopeKind() {
		return coverageScopeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCheckingScopeKind() {
		return checkingScopeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDebuglevelKind() {
		return debuglevelKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonFactory getCommonFactory() {
		return (CommonFactory)getEFactoryInstance();
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
		workspaceEClass = createEClass(WORKSPACE);
		createEReference(workspaceEClass, WORKSPACE__LOCATION);
		createEReference(workspaceEClass, WORKSPACE__PROJECT);

		locationEClass = createEClass(LOCATION);
		createEAttribute(locationEClass, LOCATION__ROOT);
		createEAttribute(locationEClass, LOCATION__OUTPUT);
		createEAttribute(locationEClass, LOCATION__LOG);
		createEAttribute(locationEClass, LOCATION__DEBUG);

		projectEClass = createEClass(PROJECT);
		createEAttribute(projectEClass, PROJECT__SOURCE);
		createEAttribute(projectEClass, PROJECT__MODEL);

		graphExplorationLimitEClass = createEClass(GRAPH_EXPLORATION_LIMIT);
		createEAttribute(graphExplorationLimitEClass, GRAPH_EXPLORATION_LIMIT__EVAL);
		createEAttribute(graphExplorationLimitEClass, GRAPH_EXPLORATION_LIMIT__NODE);
		createEAttribute(graphExplorationLimitEClass, GRAPH_EXPLORATION_LIMIT__HEIGHT);
		createEAttribute(graphExplorationLimitEClass, GRAPH_EXPLORATION_LIMIT__WIDTH);
		createEAttribute(graphExplorationLimitEClass, GRAPH_EXPLORATION_LIMIT__REPORT);
		createEAttribute(graphExplorationLimitEClass, GRAPH_EXPLORATION_LIMIT__SAVE);

		graphExplorationQueueEClass = createEClass(GRAPH_EXPLORATION_QUEUE);
		createEAttribute(graphExplorationQueueEClass, GRAPH_EXPLORATION_QUEUE__STRATEGY);
		createEAttribute(graphExplorationQueueEClass, GRAPH_EXPLORATION_QUEUE__HEURISTIC);
		createEAttribute(graphExplorationQueueEClass, GRAPH_EXPLORATION_QUEUE__WEIGHT);

		consoleLogFormatEClass = createEClass(CONSOLE_LOG_FORMAT);
		createEAttribute(consoleLogFormatEClass, CONSOLE_LOG_FORMAT__FORMAT);
		createEAttribute(consoleLogFormatEClass, CONSOLE_LOG_FORMAT__BOUND);
		createEAttribute(consoleLogFormatEClass, CONSOLE_LOG_FORMAT__STEP);
		createEAttribute(consoleLogFormatEClass, CONSOLE_LOG_FORMAT__RESULT);
		createEAttribute(consoleLogFormatEClass, CONSOLE_LOG_FORMAT__REPORT);
		createEAttribute(consoleLogFormatEClass, CONSOLE_LOG_FORMAT__VERBOSITY);

		traceElementEClass = createEClass(TRACE_ELEMENT);
		createEAttribute(traceElementEClass, TRACE_ELEMENT__NATURE);
		createEAttribute(traceElementEClass, TRACE_ELEMENT__VALUE);

		traceSpecificationEClass = createEClass(TRACE_SPECIFICATION);
		createEReference(traceSpecificationEClass, TRACE_SPECIFICATION__ELEMENT);

		manifestEClass = createEClass(MANIFEST);
		createEAttribute(manifestEClass, MANIFEST__AUTOCONF);
		createEAttribute(manifestEClass, MANIFEST__AUTOSTART);

		symbexOptionEClass = createEClass(SYMBEX_OPTION);

		shellModeEClass = createEClass(SHELL_MODE);
		createEAttribute(shellModeEClass, SHELL_MODE__STOP);

		coverageHeuristicEClass = createEClass(COVERAGE_HEURISTIC);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__HEURISTIC_TRIALS);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__OBJECTIVE_RATE_GOAL);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__OBJECTIVE_REST_GOAL);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__HEURISTIC_START);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__DIRECTIVE_TRACE_COUNT);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__DIRECTIVE_TRACE_SIZE);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__DIRECTIVE_TRACE_HEURISTIC);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__LOOKAHEAD_DEPTH);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__LOOKAHEAD_WIDTH);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__HIT_STRONGLY_RANDOM_ENABLED);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__HIT_STRONGLY_COUNT);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__HIT_WEAKLY_RANDOM_ENABLED);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__HIT_WEAKLY_COUNT);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__HIT_OTHER_RANDOM_ENABLED);
		createEAttribute(coverageHeuristicEClass, COVERAGE_HEURISTIC__HIT_OTHER_COUNT);

		developerTuningOptionEClass = createEClass(DEVELOPER_TUNING_OPTION);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__LOG_TRACE_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__DEBUG_TRACE_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__DEBUG_LEVEL);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__DEBUG_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__OUTPUT_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__SPECIFICATION_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__EXECUTABLE_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__SYMBEX_GRAPH_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__PARSED_MODEL_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__COMPILED_MODEL_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__SYMBEX_TRACE_FILENAME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_PARSING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_CONFIGURING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_COMPILING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_LOADING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_COMPUTING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_REPORTING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_SOLVER);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_PROFILING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_ALL_PROCESS_STAGE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_PRE_PROCESSING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_POST_PROCESSING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_PROCESSING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_PRE_FILTERING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_POST_FILTERING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_FILTERING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_QUEUE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_PROGRAM);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_ASSIGNMENT);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_COMMUNICATION);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_STATEMENT_TEST_DECISION);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_BYTECODE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_DATA);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_TRACE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_VARIABLE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_BUFFER);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_PORT);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_SIGNAL);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_CONNEXION);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_TIME);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_EXECUTABLE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_ACTIVITY);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_ROUTINE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_TRANSITION);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_MACHINE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_STATEMACHINE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_NAME_ID);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_QUALIFIED_NAME_ID);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_FULLY_QUALIFIED_NAME_ID);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_REDUNDANCE);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_REFERENCE_COUNTING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_NOTHING);
		createEAttribute(developerTuningOptionEClass, DEVELOPER_TUNING_OPTION__ENABLED_GOD_MODE);

		redundancyDetectionEClass = createEClass(REDUNDANCY_DETECTION);
		createEAttribute(redundancyDetectionEClass, REDUNDANCY_DETECTION__COMPARER);
		createEAttribute(redundancyDetectionEClass, REDUNDANCY_DETECTION__SOLVER);
		createEAttribute(redundancyDetectionEClass, REDUNDANCY_DETECTION__PATH_SCOPE);
		createEAttribute(redundancyDetectionEClass, REDUNDANCY_DETECTION__DATA_SCOPE);

		// Create enums
		graphExplorationStrategyKindEEnum = createEEnum(GRAPH_EXPLORATION_STRATEGY_KIND);
		consoleVerbosityKindEEnum = createEEnum(CONSOLE_VERBOSITY_KIND);
		traceElementKindEEnum = createEEnum(TRACE_ELEMENT_KIND);
		heuristicClassKindEEnum = createEEnum(HEURISTIC_CLASS_KIND);
		coverageScopeKindEEnum = createEEnum(COVERAGE_SCOPE_KIND);
		checkingScopeKindEEnum = createEEnum(CHECKING_SCOPE_KIND);
		debuglevelKindEEnum = createEEnum(DEBUGLEVEL_KIND);
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
		traceSpecificationEClass.getESuperTypes().add(theWorkflowPackage.getNamedObject());

		// Initialize classes, features, and operations; add parameters
		initEClass(workspaceEClass, Workspace.class, "Workspace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspace_Location(), this.getLocation(), null, "location", null, 0, 1, Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkspace_Project(), this.getProject(), null, "project", null, 0, 1, Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(locationEClass, Location.class, "Location", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocation_Root(), ecorePackage.getEString(), "root", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocation_Output(), ecorePackage.getEString(), "output", "output", 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocation_Log(), ecorePackage.getEString(), "log", "log", 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocation_Debug(), ecorePackage.getEString(), "debug", "debug", 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProject_Source(), ecorePackage.getEString(), "source", ".", 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_Model(), ecorePackage.getEString(), "model", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphExplorationLimitEClass, GraphExplorationLimit.class, "GraphExplorationLimit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphExplorationLimit_Eval(), ecorePackage.getELong(), "eval", null, 0, 1, GraphExplorationLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphExplorationLimit_Node(), ecorePackage.getELong(), "node", null, 0, 1, GraphExplorationLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphExplorationLimit_Height(), ecorePackage.getELong(), "height", null, 0, 1, GraphExplorationLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphExplorationLimit_Width(), ecorePackage.getELong(), "width", null, 0, 1, GraphExplorationLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphExplorationLimit_Report(), ecorePackage.getELong(), "report", null, 0, 1, GraphExplorationLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphExplorationLimit_Save(), ecorePackage.getELong(), "save", null, 0, 1, GraphExplorationLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphExplorationQueueEClass, GraphExplorationQueue.class, "GraphExplorationQueue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphExplorationQueue_Strategy(), this.getGraphExplorationStrategyKind(), "strategy", "BREADTH_FIRST_SEARCH", 0, 1, GraphExplorationQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphExplorationQueue_Heuristic(), ecorePackage.getEBoolean(), "heuristic", null, 0, 1, GraphExplorationQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphExplorationQueue_Weight(), ecorePackage.getEInt(), "weight", null, 0, 1, GraphExplorationQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consoleLogFormatEClass, ConsoleLogFormat.class, "ConsoleLogFormat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConsoleLogFormat_Format(), ecorePackage.getEString(), "format", null, 0, 1, ConsoleLogFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConsoleLogFormat_Bound(), ecorePackage.getEString(), "bound", null, 0, 1, ConsoleLogFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConsoleLogFormat_Step(), ecorePackage.getEString(), "step", null, 0, 1, ConsoleLogFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConsoleLogFormat_Result(), ecorePackage.getEString(), "result", null, 0, 1, ConsoleLogFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConsoleLogFormat_Report(), ecorePackage.getEString(), "report", null, 0, 1, ConsoleLogFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConsoleLogFormat_Verbosity(), this.getConsoleVerbosityKind(), "verbosity", "UNDEFINED", 0, 1, ConsoleLogFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceElementEClass, TraceElement.class, "TraceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceElement_Nature(), this.getTraceElementKind(), "nature", null, 0, 1, TraceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceElement_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, TraceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceSpecificationEClass, TraceSpecification.class, "TraceSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceSpecification_Element(), this.getTraceElement(), null, "element", null, 0, -1, TraceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(manifestEClass, Manifest.class, "Manifest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getManifest_Autoconf(), ecorePackage.getEBoolean(), "autoconf", null, 0, 1, Manifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getManifest_Autostart(), ecorePackage.getEBoolean(), "autostart", null, 0, 1, Manifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(symbexOptionEClass, SymbexOption.class, "SymbexOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shellModeEClass, ShellMode.class, "ShellMode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShellMode_Stop(), ecorePackage.getEString(), "stop", "\"stop.symbex\"", 0, 1, ShellMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coverageHeuristicEClass, CoverageHeuristic.class, "CoverageHeuristic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoverageHeuristic_HeuristicTrials(), ecorePackage.getEInt(), "heuristicTrials", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_ObjectiveRateGoal(), ecorePackage.getEInt(), "objectiveRateGoal", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_ObjectiveRestGoal(), ecorePackage.getEInt(), "objectiveRestGoal", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_HeuristicStart(), this.getHeuristicClassKind(), "heuristicStart", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_DirectiveTraceCount(), ecorePackage.getEInt(), "directiveTraceCount", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_DirectiveTraceSize(), ecorePackage.getEInt(), "directiveTraceSize", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_DirectiveTraceHeuristic(), this.getHeuristicClassKind(), "directiveTraceHeuristic", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_LookaheadDepth(), ecorePackage.getEInt(), "lookaheadDepth", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_LookaheadWidth(), ecorePackage.getEInt(), "lookaheadWidth", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_HitStronglyRandomEnabled(), ecorePackage.getEBoolean(), "hitStronglyRandomEnabled", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_HitStronglyCount(), ecorePackage.getEInt(), "hitStronglyCount", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_HitWeaklyRandomEnabled(), ecorePackage.getEBoolean(), "hitWeaklyRandomEnabled", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_HitWeaklyCount(), ecorePackage.getEInt(), "hitWeaklyCount", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_HitOtherRandomEnabled(), ecorePackage.getEBoolean(), "hitOtherRandomEnabled", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoverageHeuristic_HitOtherCount(), ecorePackage.getEInt(), "hitOtherCount", null, 0, 1, CoverageHeuristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(developerTuningOptionEClass, DeveloperTuningOption.class, "DeveloperTuningOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeveloperTuningOption_LogTraceFilename(), ecorePackage.getEString(), "logTraceFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_DebugTraceFilename(), ecorePackage.getEString(), "debugTraceFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_DebugLevel(), this.getDebuglevelKind(), "debugLevel", "ZERO", 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_DebugFilename(), ecorePackage.getEString(), "debugFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_OutputFilename(), ecorePackage.getEString(), "outputFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_SpecificationFilename(), ecorePackage.getEString(), "specificationFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_ExecutableFilename(), ecorePackage.getEString(), "executableFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_SymbexGraphFilename(), ecorePackage.getEString(), "symbexGraphFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_ParsedModelFilename(), ecorePackage.getEString(), "parsedModelFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_CompiledModelFilename(), ecorePackage.getEString(), "compiledModelFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_SymbexTraceFilename(), ecorePackage.getEString(), "symbexTraceFilename", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledParsing(), ecorePackage.getEBoolean(), "enabledParsing", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledConfiguring(), ecorePackage.getEBoolean(), "enabledConfiguring", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledCompiling(), ecorePackage.getEBoolean(), "enabledCompiling", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledLoading(), ecorePackage.getEBoolean(), "enabledLoading", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledComputing(), ecorePackage.getEBoolean(), "enabledComputing", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledReporting(), ecorePackage.getEBoolean(), "enabledReporting", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledSolver(), ecorePackage.getEBoolean(), "enabledSolver", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledProfiling(), ecorePackage.getEBoolean(), "enabledProfiling", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledAllProcessStage(), ecorePackage.getEBoolean(), "enabledAllProcessStage", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledPreProcessing(), ecorePackage.getEBoolean(), "enabledPreProcessing", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledPostProcessing(), ecorePackage.getEBoolean(), "enabledPostProcessing", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledProcessing(), ecorePackage.getEBoolean(), "enabledProcessing", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledPreFiltering(), ecorePackage.getEBoolean(), "enabledPreFiltering", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledPostFiltering(), ecorePackage.getEBoolean(), "enabledPostFiltering", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledFiltering(), ecorePackage.getEBoolean(), "enabledFiltering", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledQueue(), ecorePackage.getEBoolean(), "enabledQueue", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledProgram(), ecorePackage.getEBoolean(), "enabledProgram", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledStatement(), ecorePackage.getEBoolean(), "enabledStatement", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledStatementAssignment(), ecorePackage.getEBoolean(), "enabledStatementAssignment", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledStatementCommunication(), ecorePackage.getEBoolean(), "enabledStatementCommunication", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledStatementTestDecision(), ecorePackage.getEBoolean(), "enabledStatementTestDecision", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledBytecode(), ecorePackage.getEBoolean(), "enabledBytecode", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledData(), ecorePackage.getEBoolean(), "enabledData", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledTrace(), ecorePackage.getEBoolean(), "enabledTrace", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledVariable(), ecorePackage.getEBoolean(), "enabledVariable", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledBuffer(), ecorePackage.getEBoolean(), "enabledBuffer", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledPort(), ecorePackage.getEBoolean(), "enabledPort", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledSignal(), ecorePackage.getEBoolean(), "enabledSignal", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledConnexion(), ecorePackage.getEBoolean(), "enabledConnexion", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledTime(), ecorePackage.getEBoolean(), "enabledTime", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledExecutable(), ecorePackage.getEBoolean(), "enabledExecutable", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledActivity(), ecorePackage.getEBoolean(), "enabledActivity", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledRoutine(), ecorePackage.getEBoolean(), "enabledRoutine", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledTransition(), ecorePackage.getEBoolean(), "enabledTransition", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledMachine(), ecorePackage.getEBoolean(), "enabledMachine", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledStatemachine(), ecorePackage.getEBoolean(), "enabledStatemachine", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledNameId(), ecorePackage.getEBoolean(), "enabledNameId", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledQualifiedNameId(), ecorePackage.getEBoolean(), "enabledQualifiedNameId", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledFullyQualifiedNameId(), ecorePackage.getEBoolean(), "enabledFullyQualifiedNameId", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledRedundance(), ecorePackage.getEBoolean(), "enabledRedundance", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledReferenceCounting(), ecorePackage.getEBoolean(), "enabledReferenceCounting", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledNothing(), ecorePackage.getEBoolean(), "enabledNothing", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeveloperTuningOption_EnabledGodMode(), ecorePackage.getEBoolean(), "enabledGodMode", null, 0, 1, DeveloperTuningOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(redundancyDetectionEClass, RedundancyDetection.class, "RedundancyDetection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRedundancyDetection_Comparer(), ecorePackage.getEString(), "comparer", "INCLUSION", 0, 1, RedundancyDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRedundancyDetection_Solver(), ecorePackage.getEString(), "solver", "OMEGA", 0, 1, RedundancyDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRedundancyDetection_PathScope(), ecorePackage.getEString(), "pathScope", "CURRENT", 0, 1, RedundancyDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRedundancyDetection_DataScope(), ecorePackage.getEString(), "dataScope", "ALL", 0, 1, RedundancyDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.class, "GraphExplorationStrategyKind");
		addEEnumLiteral(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.BEST_FIRST_SEARCH);
		addEEnumLiteral(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH);
		addEEnumLiteral(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.DEPTH_FIRST_SEARCH);
		addEEnumLiteral(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.RANDOM_FIRST_SEARCH);
		addEEnumLiteral(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.XFS);
		addEEnumLiteral(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.FIRST);
		addEEnumLiteral(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.LAST);
		addEEnumLiteral(graphExplorationStrategyKindEEnum, GraphExplorationStrategyKind.ALL);

		initEEnum(consoleVerbosityKindEEnum, ConsoleVerbosityKind.class, "ConsoleVerbosityKind");
		addEEnumLiteral(consoleVerbosityKindEEnum, ConsoleVerbosityKind.UNDEFINED);
		addEEnumLiteral(consoleVerbosityKindEEnum, ConsoleVerbosityKind.SILENT);
		addEEnumLiteral(consoleVerbosityKindEEnum, ConsoleVerbosityKind.MINIMUM);
		addEEnumLiteral(consoleVerbosityKindEEnum, ConsoleVerbosityKind.MEDIUM);
		addEEnumLiteral(consoleVerbosityKindEEnum, ConsoleVerbosityKind.MAXIMUM);

		initEEnum(traceElementKindEEnum, TraceElementKind.class, "TraceElementKind");
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.UNDEFINED);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.CONDITION);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.DECISION);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.FORMULA);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.PATH_CONDITION);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.PATH_CONDITION_LEAF);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.PATH_TIMED_CONDITION);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.PATH_TIMED_CONDITION_LEAF);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.NODE_CONDITION);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.NODE_CONDITION_LEAF);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.NODE_TIMED_CONDITION);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.NODE_TIMED_CONDITION_LEAF);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.ASSIGN);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.DELTA);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.TIME);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.VARIABLE);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.NEWFRESH);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.COM);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INOUT);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INPUT);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.OUTPUT);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INPUT_ENV);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.OUTPUT_ENV);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INPUT_RDV);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.OUTPUT_RDV);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INPUT_BUFFER);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.OUTPUT_BUFFER);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INPUT_VAR);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.OUTPUT_VAR);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.PORT);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.SIGNAL);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.MESSAGE);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.CHANNEL);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.BUFFER);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.RUNNABLE);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.ROUTINE);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.TRANSITION);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.MACHINE);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.STATE);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.STATEMACHINE);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.SYSTEM);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.FILE_HEADER);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.FILE_BEGIN);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.FILE_END);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.TESTCASE_HEADER);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.TESTCASE_BEGIN);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.TESTCASE_END);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INIT_HEADER);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INIT_BEGIN);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.INIT_END);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.STEP_HEADER);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.STEP_BEGIN);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.STEP_END);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.COMMENT);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.SEPARATOR);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.NEWLINE);
		addEEnumLiteral(traceElementKindEEnum, TraceElementKind.NEXT);

		initEEnum(heuristicClassKindEEnum, HeuristicClassKind.class, "HeuristicClassKind");
		addEEnumLiteral(heuristicClassKindEEnum, HeuristicClassKind.BASIC);
		addEEnumLiteral(heuristicClassKindEEnum, HeuristicClassKind.NAIVE);
		addEEnumLiteral(heuristicClassKindEEnum, HeuristicClassKind.SMART);
		addEEnumLiteral(heuristicClassKindEEnum, HeuristicClassKind.AGRESSIVE);
		addEEnumLiteral(heuristicClassKindEEnum, HeuristicClassKind.NOTHING_ELSE);

		initEEnum(coverageScopeKindEEnum, CoverageScopeKind.class, "CoverageScopeKind");
		addEEnumLiteral(coverageScopeKindEEnum, CoverageScopeKind.MODEL);
		addEEnumLiteral(coverageScopeKindEEnum, CoverageScopeKind.INSTANCE);
		addEEnumLiteral(coverageScopeKindEEnum, CoverageScopeKind.DETAILS);

		initEEnum(checkingScopeKindEEnum, CheckingScopeKind.class, "CheckingScopeKind");
		addEEnumLiteral(checkingScopeKindEEnum, CheckingScopeKind.GLOBALLY);
		addEEnumLiteral(checkingScopeKindEEnum, CheckingScopeKind.LOCALLY);

		initEEnum(debuglevelKindEEnum, DebuglevelKind.class, "DebuglevelKind");
		addEEnumLiteral(debuglevelKindEEnum, DebuglevelKind.NONE);
		addEEnumLiteral(debuglevelKindEEnum, DebuglevelKind.ZERO);
		addEEnumLiteral(debuglevelKindEEnum, DebuglevelKind.LOW);
		addEEnumLiteral(debuglevelKindEEnum, DebuglevelKind.MEDIUM);
		addEEnumLiteral(debuglevelKindEEnum, DebuglevelKind.HIGH);
		addEEnumLiteral(debuglevelKindEEnum, DebuglevelKind.ULTRA);
		addEEnumLiteral(debuglevelKindEEnum, DebuglevelKind.GOD_MODE);
	}

} //CommonPackageImpl
