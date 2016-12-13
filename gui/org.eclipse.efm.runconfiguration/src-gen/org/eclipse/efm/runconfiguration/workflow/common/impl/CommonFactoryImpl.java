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
package org.eclipse.efm.runconfiguration.workflow.common.impl;

import org.eclipse.efm.runconfiguration.workflow.common.*;
import org.eclipse.efm.runconfiguration.workflow.common.CheckingScopeKind;
import org.eclipse.efm.runconfiguration.workflow.common.CommonFactory;
import org.eclipse.efm.runconfiguration.workflow.common.CommonPackage;
import org.eclipse.efm.runconfiguration.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.runconfiguration.workflow.common.ConsoleVerboseKind;
import org.eclipse.efm.runconfiguration.workflow.common.CoverageHeuristic;
import org.eclipse.efm.runconfiguration.workflow.common.CoverageScopeKind;
import org.eclipse.efm.runconfiguration.workflow.common.DebuglevelKind;
import org.eclipse.efm.runconfiguration.workflow.common.DeveloperTuningOption;
import org.eclipse.efm.runconfiguration.workflow.common.GraphExplorationLimit;
import org.eclipse.efm.runconfiguration.workflow.common.GraphExplorationQueue;
import org.eclipse.efm.runconfiguration.workflow.common.GraphExplorationStrategyKind;
import org.eclipse.efm.runconfiguration.workflow.common.HeuristicClassKind;
import org.eclipse.efm.runconfiguration.workflow.common.Location;
import org.eclipse.efm.runconfiguration.workflow.common.Manifest;
import org.eclipse.efm.runconfiguration.workflow.common.Project;
import org.eclipse.efm.runconfiguration.workflow.common.SymbexOption;
import org.eclipse.efm.runconfiguration.workflow.common.TraceElement;
import org.eclipse.efm.runconfiguration.workflow.common.TraceElementKind;
import org.eclipse.efm.runconfiguration.workflow.common.TraceSpecification;
import org.eclipse.efm.runconfiguration.workflow.common.Workspace;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonFactoryImpl extends EFactoryImpl implements CommonFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommonFactory init() {
		try {
			CommonFactory theCommonFactory = (CommonFactory)EPackage.Registry.INSTANCE.getEFactory(CommonPackage.eNS_URI);
			if (theCommonFactory != null) {
				return theCommonFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommonFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CommonPackage.WORKSPACE: return createWorkspace();
			case CommonPackage.LOCATION: return createLocation();
			case CommonPackage.PROJECT: return createProject();
			case CommonPackage.GRAPH_EXPLORATION_LIMIT: return createGraphExplorationLimit();
			case CommonPackage.GRAPH_EXPLORATION_QUEUE: return createGraphExplorationQueue();
			case CommonPackage.CONSOLE_LOG_FORMAT: return createConsoleLogFormat();
			case CommonPackage.TRACE_ELEMENT: return createTraceElement();
			case CommonPackage.TRACE_SPECIFICATION: return createTraceSpecification();
			case CommonPackage.MANIFEST: return createManifest();
			case CommonPackage.SYMBEX_OPTION: return createSymbexOption();
			case CommonPackage.COVERAGE_HEURISTIC: return createCoverageHeuristic();
			case CommonPackage.DEVELOPER_TUNING_OPTION: return createDeveloperTuningOption();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CommonPackage.GRAPH_EXPLORATION_STRATEGY_KIND:
				return createGraphExplorationStrategyKindFromString(eDataType, initialValue);
			case CommonPackage.CONSOLE_VERBOSE_KIND:
				return createConsoleVerboseKindFromString(eDataType, initialValue);
			case CommonPackage.TRACE_ELEMENT_KIND:
				return createTraceElementKindFromString(eDataType, initialValue);
			case CommonPackage.HEURISTIC_CLASS_KIND:
				return createHeuristicClassKindFromString(eDataType, initialValue);
			case CommonPackage.COVERAGE_SCOPE_KIND:
				return createCoverageScopeKindFromString(eDataType, initialValue);
			case CommonPackage.CHECKING_SCOPE_KIND:
				return createCheckingScopeKindFromString(eDataType, initialValue);
			case CommonPackage.DEBUGLEVEL_KIND:
				return createDebuglevelKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CommonPackage.GRAPH_EXPLORATION_STRATEGY_KIND:
				return convertGraphExplorationStrategyKindToString(eDataType, instanceValue);
			case CommonPackage.CONSOLE_VERBOSE_KIND:
				return convertConsoleVerboseKindToString(eDataType, instanceValue);
			case CommonPackage.TRACE_ELEMENT_KIND:
				return convertTraceElementKindToString(eDataType, instanceValue);
			case CommonPackage.HEURISTIC_CLASS_KIND:
				return convertHeuristicClassKindToString(eDataType, instanceValue);
			case CommonPackage.COVERAGE_SCOPE_KIND:
				return convertCoverageScopeKindToString(eDataType, instanceValue);
			case CommonPackage.CHECKING_SCOPE_KIND:
				return convertCheckingScopeKindToString(eDataType, instanceValue);
			case CommonPackage.DEBUGLEVEL_KIND:
				return convertDebuglevelKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace createWorkspace() {
		WorkspaceImpl workspace = new WorkspaceImpl();
		return workspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location createLocation() {
		LocationImpl location = new LocationImpl();
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphExplorationLimit createGraphExplorationLimit() {
		GraphExplorationLimitImpl graphExplorationLimit = new GraphExplorationLimitImpl();
		return graphExplorationLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphExplorationQueue createGraphExplorationQueue() {
		GraphExplorationQueueImpl graphExplorationQueue = new GraphExplorationQueueImpl();
		return graphExplorationQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsoleLogFormat createConsoleLogFormat() {
		ConsoleLogFormatImpl consoleLogFormat = new ConsoleLogFormatImpl();
		return consoleLogFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceElement createTraceElement() {
		TraceElementImpl traceElement = new TraceElementImpl();
		return traceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSpecification createTraceSpecification() {
		TraceSpecificationImpl traceSpecification = new TraceSpecificationImpl();
		return traceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manifest createManifest() {
		ManifestImpl manifest = new ManifestImpl();
		return manifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbexOption createSymbexOption() {
		SymbexOptionImpl symbexOption = new SymbexOptionImpl();
		return symbexOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageHeuristic createCoverageHeuristic() {
		CoverageHeuristicImpl coverageHeuristic = new CoverageHeuristicImpl();
		return coverageHeuristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeveloperTuningOption createDeveloperTuningOption() {
		DeveloperTuningOptionImpl developerTuningOption = new DeveloperTuningOptionImpl();
		return developerTuningOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphExplorationStrategyKind createGraphExplorationStrategyKindFromString(EDataType eDataType, String initialValue) {
		GraphExplorationStrategyKind result = GraphExplorationStrategyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGraphExplorationStrategyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsoleVerboseKind createConsoleVerboseKindFromString(EDataType eDataType, String initialValue) {
		ConsoleVerboseKind result = ConsoleVerboseKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConsoleVerboseKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceElementKind createTraceElementKindFromString(EDataType eDataType, String initialValue) {
		TraceElementKind result = TraceElementKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTraceElementKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeuristicClassKind createHeuristicClassKindFromString(EDataType eDataType, String initialValue) {
		HeuristicClassKind result = HeuristicClassKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHeuristicClassKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageScopeKind createCoverageScopeKindFromString(EDataType eDataType, String initialValue) {
		CoverageScopeKind result = CoverageScopeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCoverageScopeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckingScopeKind createCheckingScopeKindFromString(EDataType eDataType, String initialValue) {
		CheckingScopeKind result = CheckingScopeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCheckingScopeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebuglevelKind createDebuglevelKindFromString(EDataType eDataType, String initialValue) {
		DebuglevelKind result = DebuglevelKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDebuglevelKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonPackage getCommonPackage() {
		return (CommonPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommonPackage getPackage() {
		return CommonPackage.eINSTANCE;
	}

} //CommonFactoryImpl
