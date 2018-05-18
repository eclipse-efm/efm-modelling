/*******************************************************************************
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
 *******************************************************************************/
package org.eclipse.efm.execution.core.workflow;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.efm.execution.core.workflow.common.CommonFactory;
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOptionCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.Project;
import org.eclipse.efm.execution.core.workflow.common.RedundancyComparerOperation;
import org.eclipse.efm.execution.core.workflow.common.RedundancyDetection;
import org.eclipse.efm.execution.core.workflow.common.RedundancyPathScope;
import org.eclipse.efm.execution.core.workflow.common.SolverKind;
import org.eclipse.efm.execution.core.workflow.coverage.BehaviorCoverageWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.coverage.TransitionCoverageWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.impl.DirectorImpl;
import org.eclipse.efm.execution.core.workflow.incubation.ExtraneousWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.inference.InferenceContractWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.BasicTraceSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.ModelGraphvizSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphvizSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.test.OfflineTestWorkerCustomImpl;

public class DirectorCustomImpl extends DirectorImpl
		implements IWorkflowConfigurationConstants {

	protected DirectorCustomImpl(Workflow workflow) {
		super();

		setWorkflow(workflow);
	}

	protected DirectorCustomImpl(Workflow workflow, String name) {
		super();

		setWorkflow(workflow);
		setName(name);
	}


	public static DirectorCustomImpl create(Workflow workflow,
		ILaunchConfiguration configuration, IPath projectRootPath, boolean hasSecond) {

		DirectorCustomImpl director = new DirectorCustomImpl(workflow);

		director.setManifest( ManifestCustomImpl.create(true, true) );


		if( ! director.configureProject(configuration, projectRootPath) ) {
			//!! ERROR
		}

		if( ! director.configureMainWorker(configuration) ) {
			//!! ERROR
		}

		if( ! director.configureSerializerWorker(configuration) ) {
			//!! ERROR
		}

		if( ! hasSecond ) {
			if( ! director.configureSecondSerializerWorker(
					configuration, hasSecond) ) {
				//!! ERROR
			}
		}

		if( ! director.configureDebugWorker(configuration) ) {
			//!! ERROR
		}

		return( director );
	}


	public boolean configureProject(
			ILaunchConfiguration configuration, IPath projectRootPath) {
		String modelPath = WorkflowFileUtils.getAbsoluteLocation(
				configuration, ATTR_SPECIFICATION_MODEL_FILE_LOCATION, "");

		if( ! modelPath.isEmpty() ) {
			Project project = CommonFactory.eINSTANCE.createProject();

			project.setSource(WorkflowFileUtils.makeRelativeParentLocation(
							projectRootPath, modelPath));

			project.setModel( WorkflowFileUtils.filename(modelPath) );

			setProject( project );

			return( true );
		}

		return( false );
	}


	public static boolean isCoverageAnalysisProfile(AnalysisProfileKind analysisProfile) {
		switch( analysisProfile ) {
		case ANALYSIS_TRANSITION_COVERAGE_PROFILE:
		case ANALYSIS_BEHAVIOR_SELECTION_PROFILE:
		case ANALYSIS_ACSL_GENERATION_PROFILE:
			return true;

		default:
			return false;
		}
	}

	public static boolean isExplorationAnalysisProfile(AnalysisProfileKind analysisProfile) {
		switch( analysisProfile ) {
		case ANALYSIS_TRANSITION_COVERAGE_PROFILE:
		case ANALYSIS_BEHAVIOR_SELECTION_PROFILE:
		case ANALYSIS_ACSL_GENERATION_PROFILE:
			return false;

		case ANALYSIS_EXPLORATION_PROFILE:
		case ANALYSIS_TEST_OFFLINE_PROFILE:
		case ANALYSIS_EXTRANEOUS_PROFILE:
		case ANALYSIS_UNDEFINED_PROFILE:
		default:
			return true;
		}
	}


	public boolean configureMainWorker(ILaunchConfiguration configuration) {
		AnalysisProfileKind modelAnalysisProfile = null;
		try {
			final String strAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
					AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE.getLiteral());

			modelAnalysisProfile = AnalysisProfileKind.get(strAnalysisProfile);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}


		if( modelAnalysisProfile == null ) {
			modelAnalysisProfile = AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE;
		}

		SupervisorWorkerCustomImpl supervisor = SupervisorWorkerCustomImpl.create(
				configuration, isCoverageAnalysisProfile(modelAnalysisProfile));

		setDescription( "of graph exploration" );

		setSupervisor( supervisor );

		boolean isRedundancyDetectionPossible = false;

		boolean couldUsedAsAdditionalModule = true;

		switch ( modelAnalysisProfile ) {
			case ANALYSIS_EXPLORATION_PROFILE: {
				//!! NOTHING to do...
				// --> only need a Supervisor worker for Model Exploration

				isRedundancyDetectionPossible = true;

				break;
			}
			case ANALYSIS_TRANSITION_COVERAGE_PROFILE: {
				TransitionCoverageWorkerCustomImpl worker =
						TransitionCoverageWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				supervisor.getQueue().setHeuristicEnabled(true);

				supervisor.getQueue().setWeight(8);

				isRedundancyDetectionPossible = true;

				break;
			}
			case ANALYSIS_BEHAVIOR_SELECTION_PROFILE: {
				BehaviorCoverageWorkerCustomImpl worker =
						BehaviorCoverageWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				supervisor.getQueue().setHeuristicEnabled(true);

				break;
			}
			case ANALYSIS_TEST_OFFLINE_PROFILE: {
				OfflineTestWorkerCustomImpl worker =
						OfflineTestWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				supervisor.getQueue().setHeuristicEnabled(true);

				break;
			}

			case ANALYSIS_ACSL_GENERATION_PROFILE: {
				InferenceContractWorkerCustomImpl worker =
						InferenceContractWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				break;
			}

			case ANALYSIS_EXTRANEOUS_PROFILE: {
				ExtraneousWorkerCustomImpl worker =
						ExtraneousWorkerCustomImpl.create(this, configuration);

				getWorker().add( worker );

				supervisor.getQueue().setHeuristicEnabled(false);

				couldUsedAsAdditionalModule = false;

				break;
			}

			default: {
				break;
			}
		}

		if( couldUsedAsAdditionalModule ) {
			try {
				couldUsedAsAdditionalModule = configuration.getAttribute(
						ATTR_OPAQUE_MODULE_ENABLED_AS_ADDITIONAL_WORKER,
						DEFAULT_OPAQUE_MODULE_ENABLED_AS_ADDITIONAL_WORKER);
			}
			catch( CoreException e ) {
				e.printStackTrace();

				couldUsedAsAdditionalModule = false;
			}

			if( couldUsedAsAdditionalModule ) {
				ExtraneousWorkerCustomImpl worker =
						ExtraneousWorkerCustomImpl.create(this, configuration);

				getWorker().add( worker );
			}
		}

		if( isRedundancyDetectionPossible ) {
			RedundancyDetection redundancy =
					CommonFactory.eINSTANCE.createRedundancyDetection();
			getSupervisor().setRedundancy(redundancy);

			boolean enabledRedundancyDetection = false;
			try {
				enabledRedundancyDetection = configuration.getAttribute(
						ATTR_ENABLED_REDUNDANCY_DETECTION, false);
			}
			catch( CoreException e ) {
				e.printStackTrace();

				enabledRedundancyDetection = false;
			}
			redundancy.setEnabledDetetction( enabledRedundancyDetection );
			//
			// OR EXCLUSIVE
			//
			try {
				enabledRedundancyDetection = configuration.getAttribute(
						ATTR_ENABLED_REDUNDANCY_TRIVIAL_LOOP_DETECTION, false);
			}
			catch( CoreException e ) {
				e.printStackTrace();

				enabledRedundancyDetection = false;
			}
			redundancy.setEnabledTrivialLoopDetetction(enabledRedundancyDetection);

			// REDUNDANCY CONFIGURATION : Path Scope & Comparer Operation
			RedundancyPathScope scope = RedundancyPathScope.CURRENT;
			try {
				scope = RedundancyPathScope.get(
						configuration.getAttribute(ATTR_REDUNDANCY_PATH_SCOPE,
								RedundancyPathScope.CURRENT.getLiteral()));
			}
			catch( CoreException e1 ) {
				e1.printStackTrace();
			}
			if( scope == null ) {
				scope = RedundancyPathScope.CURRENT;
			}
			redundancy.setPathScope( scope );

			RedundancyComparerOperation comparer = RedundancyComparerOperation.INCLUSION;
			try {
				comparer = RedundancyComparerOperation.get(
						configuration.getAttribute(ATTR_REDUNDANCY_COMPARER_OPERATION,
								RedundancyComparerOperation.INCLUSION.getLiteral()));
			}
			catch( CoreException e1 ) {
				e1.printStackTrace();
			}
			if( comparer == null ) {
				comparer = RedundancyComparerOperation.INCLUSION;
			}
			redundancy.setComparerOperation( comparer );

			redundancy.setSolverChoice( SolverKind.OMEGA );

		}

		return( true );
	}

	public boolean configureSerializerWorker(ILaunchConfiguration configuration) {

		boolean enabledSerialization;

		// Model [ GraphViz ] serialization
		try {
			enabledSerialization = configuration.getAttribute(
					ATTR_ENABLED_FIRST_PARSED_MODEL_GRAPHVIZ_GENERATION, false);
		}
		catch (CoreException e) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			ModelGraphvizSerializerWorkerCustomImpl modelSerializer =
					ModelGraphvizSerializerWorkerCustomImpl.create(
							this, configuration);

			getWorker().add( modelSerializer );
		}

		// Symbex Graph [ GraphViz ] serialization
		try {
			enabledSerialization = configuration.getAttribute(
				ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION, false);
		}
		catch (CoreException e) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			SymbexGraphvizSerializerWorkerCustomImpl modelSerializer =
					SymbexGraphvizSerializerWorkerCustomImpl.create(
							this, configuration);

			getWorker().add( modelSerializer );
		}


		DeveloperTuningOptionCustomImpl devTuning =
				DeveloperTuningOptionCustomImpl.createDirector(configuration);

		setDeveloperTuning( devTuning );


		return( true );
	}

	public boolean configureDebugWorker(ILaunchConfiguration configuration) {

		return( true );
	}


	public boolean configureOtherWorker(ILaunchConfiguration configuration) {

		return( true );
	}


	public static DirectorCustomImpl createSecond(Workflow workflow,
			ILaunchConfiguration configuration) {

		DirectorCustomImpl director = new DirectorCustomImpl(workflow);

		director.setManifest( ManifestCustomImpl.create(true, true) );


		if( ! director.configureSecondWorker(configuration) ) {
			//!! ERROR
		}

		if( ! director.configureSecondSerializerWorker(configuration, true) ) {
			//!! ERROR
		}

		return( director );
	}

	public boolean configureSecondWorker(ILaunchConfiguration configuration) {

		SupervisorWorkerCustomImpl supervisor =
				SupervisorWorkerCustomImpl.createSecond(configuration);

		setDescription( "of graph exploration" );

		setSupervisor( supervisor );

		// Execution completion to next observable (default 'output#env = [*]')
		BehaviorCoverageWorkerCustomImpl worker =
				BehaviorCoverageWorkerCustomImpl.createSecond(
						this, configuration);

		getWorker().add( worker );

		supervisor.getQueue().setHeuristicEnabled(true);

		return( true );
	}

	public boolean configureSecondSerializerWorker(
			ILaunchConfiguration configuration, boolean hasSecond) {

		boolean enabledSerialization;

		// Basic Trace generation
		try {
			enabledSerialization = configuration.getAttribute(
					ATTR_BASIC_TRACE_ENABLED_GENERATION, false);
		} catch( CoreException e ) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			BasicTraceSerializerWorkerCustomImpl basicSerializer =
					BasicTraceSerializerWorkerCustomImpl.create(
							this, configuration);

			this.getWorker().add( basicSerializer );
		}

		// TTCN3 Trace generation
		try {
			enabledSerialization = configuration.getAttribute(
					ATTR_TTCN_ENABLED_GENERATION, false);
		} catch( CoreException e ) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			TTCNTraceSerializerWorkerCustomImpl ttcnSerializer =
					TTCNTraceSerializerWorkerCustomImpl.create(
							this, configuration);

			getWorker().add( ttcnSerializer );
		}

		// Symbex Graph [ GraphViz ] serialization
		try {
			enabledSerialization = configuration.getAttribute(
				ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION, false);
		}
		catch (CoreException e) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			SymbexGraphvizSerializerWorkerCustomImpl modelSerializer =
					SymbexGraphvizSerializerWorkerCustomImpl.createSecond(
							this, configuration);

			getWorker().add( modelSerializer );
		}

		if( hasSecond ) {
			DeveloperTuningOptionCustomImpl devTuning =
				DeveloperTuningOptionCustomImpl.createSecondDirector(configuration);

			setDeveloperTuning( devTuning );
		}

		return( true );
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "director" );

		String str = getName();
		if( str != null ) {
			writer.append( ' ' ).append( str );
		}
		str = getDescription();
		if( str != null ) {
			writer.append( " \'" ).append( str ).append( "\'" );
		}

		writer.appendEol( " {" );

		PrettyPrintWriter writer2 = writer.itab2();

		ManifestCustomImpl manifest = (ManifestCustomImpl) getManifest();
		if( manifest != null ) {
			manifest.toWriter(writer2);
		}

		Project project = getProject();
		if( project != null ) {
			writer2.appendTabEol( "project 'path of input model' [" );
			writer2.appendTab2( "source = \"" )
				.append( project.getSource() ).appendEol( "\"" );
			writer2.appendTab2( "model  = \"" )
				.append( project.getModel() ).appendEol( "\"" );
			writer2.appendTabEol( "] // end project" );
		}

		((SupervisorWorkerCustomImpl) getSupervisor()).toWriter( writer2 );

		writer2.appendTabEol( "worker [" );
		PrettyPrintWriter writer3 = writer.itab3();

		for( Worker worker : getWorker() ) {
			// Coverage Worker
			if( worker instanceof BehaviorCoverageWorkerCustomImpl ) {
				((BehaviorCoverageWorkerCustomImpl)
						worker).toWriter( writer3 );
			}
			else if( worker instanceof TransitionCoverageWorkerCustomImpl ) {
				((TransitionCoverageWorkerCustomImpl)
						worker).toWriter( writer3 );
			}

			// Serializer Worker
			else if( worker instanceof ModelGraphvizSerializerWorkerCustomImpl ) {
				((ModelGraphvizSerializerWorkerCustomImpl)
						worker).toWriter( writer3 );
			}
			else if( worker instanceof SymbexGraphvizSerializerWorkerCustomImpl ) {
				((SymbexGraphvizSerializerWorkerCustomImpl)
						worker).toWriter( writer3 );
			}

			else if( worker instanceof BasicTraceSerializerWorkerCustomImpl ) {
				((BasicTraceSerializerWorkerCustomImpl)
						worker).toWriter( writer3 );
			}
			else if( worker instanceof TTCNTraceSerializerWorkerCustomImpl ) {
				((TTCNTraceSerializerWorkerCustomImpl)
						worker).toWriter( writer3 );
			}

			else if( worker instanceof OfflineTestWorkerCustomImpl ) {
				((OfflineTestWorkerCustomImpl) worker).toWriter( writer3 );
			}

			else if( worker instanceof InferenceContractWorkerCustomImpl ) {
				((InferenceContractWorkerCustomImpl) worker).toWriter( writer3 );
			}
			else if( worker instanceof ExtraneousWorkerCustomImpl ) {
				((ExtraneousWorkerCustomImpl) worker).toWriter( writer3 );
			}

			// Other Worker
			else {
				writer3.commentLine( worker.getComment() );

				writer3.appendTab();

				str = worker.getName();
				if( str != null ) {
					writer3.append( str ).append( ' ' );
				}
				str = worker.getDescription();
				if( str != null ) {
					writer3.append( "\'" ).append( str ).append( "\' " );
				}

				writer3.appendEol( "{" );

				writer3.appendTabEol( "}" );
			}
		}

		writer.appendTab2Eol( "] // end worker" );

		ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer2 );
		}

		DeveloperTuningOptionCustomImpl devTuning =
				(DeveloperTuningOptionCustomImpl) getDeveloperTuning();
		if( devTuning != null ) {
			devTuning.toWriter( writer2 ); // "debug" );
		}

		writer.appendTabEol( "}" );
	}

}
