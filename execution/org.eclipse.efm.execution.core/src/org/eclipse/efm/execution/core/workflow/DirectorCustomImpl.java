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
import org.eclipse.efm.execution.core.workflow.serializer.ModelGraphicSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.ModelGraphvizSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.SequenceDiagramTraceSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphicSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphvizSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializerWorkerCustomImpl;
import org.eclipse.efm.execution.core.workflow.test.OfflineTestWorkerCustomImpl;

public class DirectorCustomImpl extends DirectorImpl
		implements IWorkflowConfigurationConstants {

	protected DirectorCustomImpl(final Workflow workflow) {
		super();

		setWorkflow(workflow);
	}

	protected DirectorCustomImpl(final Workflow workflow, final String name) {
		super();

		setWorkflow(workflow);
		setName(name);
	}


	public static DirectorCustomImpl create(final Workflow workflow,
		final ILaunchConfiguration configuration, final IPath projectRootPath, final boolean hasSecond) {

		final DirectorCustomImpl director = new DirectorCustomImpl(workflow);

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
			final ILaunchConfiguration configuration, final IPath projectRootPath) {
		final String modelPath = WorkflowFileUtils.getAbsoluteLocation(
				configuration, ATTR_SPECIFICATION_MODEL_FILE_LOCATION, "");

		if( ! modelPath.isEmpty() ) {
			final Project project = CommonFactory.eINSTANCE.createProject();

			project.setSource(WorkflowFileUtils.makeRelativeParentLocation(
							projectRootPath, modelPath));

			project.setModel( WorkflowFileUtils.filename(modelPath) );

			setProject( project );

			return( true );
		}

		return( false );
	}


	public static boolean isCoverageAnalysisProfile(final AnalysisProfileKind analysisProfile) {
		switch( analysisProfile ) {
		case ANALYSIS_TRANSITION_COVERAGE_PROFILE:
		case ANALYSIS_BEHAVIOR_SELECTION_PROFILE:
		case ANALYSIS_ACSL_GENERATION_PROFILE:
			return true;

		default:
			return false;
		}
	}

	public static boolean isExplorationAnalysisProfile(final AnalysisProfileKind analysisProfile) {
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


	public boolean configureMainWorker(final ILaunchConfiguration configuration) {
		AnalysisProfileKind modelAnalysisProfile = null;
		try {
			final String strAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
					AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE.getLiteral());

			modelAnalysisProfile = AnalysisProfileKind.get(strAnalysisProfile);
		}
		catch (final CoreException e) {
			e.printStackTrace();
		}


		if( modelAnalysisProfile == null ) {
			modelAnalysisProfile = AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE;
		}

		final SupervisorWorkerCustomImpl supervisor = SupervisorWorkerCustomImpl.create(
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
				final TransitionCoverageWorkerCustomImpl worker =
						TransitionCoverageWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				supervisor.getQueue().setHeuristicEnabled(true);

				supervisor.getQueue().setWeight(8);

				isRedundancyDetectionPossible = true;

				break;
			}
			case ANALYSIS_BEHAVIOR_SELECTION_PROFILE: {
				final BehaviorCoverageWorkerCustomImpl worker =
						BehaviorCoverageWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				supervisor.getQueue().setHeuristicEnabled(true);

				break;
			}
			case ANALYSIS_TEST_OFFLINE_PROFILE: {
				final OfflineTestWorkerCustomImpl worker =
						OfflineTestWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				supervisor.getQueue().setHeuristicEnabled(true);

				break;
			}

			case ANALYSIS_ACSL_GENERATION_PROFILE: {
				final InferenceContractWorkerCustomImpl worker =
						InferenceContractWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				break;
			}

			case ANALYSIS_EXTRANEOUS_PROFILE: {
				final ExtraneousWorkerCustomImpl worker =
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
			catch( final CoreException e ) {
				e.printStackTrace();

				couldUsedAsAdditionalModule = false;
			}

			if( couldUsedAsAdditionalModule ) {
				final ExtraneousWorkerCustomImpl worker =
						ExtraneousWorkerCustomImpl.create(this, configuration);

				getWorker().add( worker );
			}
		}

		if( isRedundancyDetectionPossible ) {
			final RedundancyDetection redundancy =
					CommonFactory.eINSTANCE.createRedundancyDetection();
			getSupervisor().setRedundancy(redundancy);

			boolean enabledRedundancyDetection = false;
			try {
				enabledRedundancyDetection = configuration.getAttribute(
						ATTR_ENABLED_REDUNDANCY_DETECTION, false);
			}
			catch( final CoreException e ) {
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
			catch( final CoreException e ) {
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
			catch( final CoreException e1 ) {
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
			catch( final CoreException e1 ) {
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

	public boolean configureSerializerWorker(final ILaunchConfiguration configuration) {

		boolean enabledSerialization;

		// Model [ GraphViz ] serialization
		try {
			enabledSerialization = configuration.getAttribute(
					ATTR_ENABLED_FIRST_PARSED_MODEL_GRAPHVIZ_GENERATION, false);
		}
		catch (final CoreException e) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			// Graphic (PlantUML Statemachne Diagram) serializer
			final ModelGraphicSerializerWorkerCustomImpl graphicSerializer =
					ModelGraphicSerializerWorkerCustomImpl.create(
							this, configuration);

			getWorker().add( graphicSerializer );

			// GraphViz (Dot Statemachne Diagram) serializer
			final ModelGraphvizSerializerWorkerCustomImpl graphvizSerializer =
					ModelGraphvizSerializerWorkerCustomImpl.create(
							this, configuration);

			getWorker().add( graphvizSerializer );
		}

		// Symbex Graph [ GraphViz ] serialization
		try {
			enabledSerialization = configuration.getAttribute(
				ATTR_ENABLED_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION, false);
		}
		catch (final CoreException e) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			// Graphic (PlantUML Sequence Diagram) serializer
//			final SymbexGraphicSerializerWorkerCustomImpl graphicSerializer =
//					SymbexGraphicSerializerWorkerCustomImpl.create(
//							this, configuration);
//
//			getWorker().add( graphicSerializer );

			// GraphViz (Dot Graph) serializer
			final SymbexGraphvizSerializerWorkerCustomImpl graphvizSerializer =
					SymbexGraphvizSerializerWorkerCustomImpl.create(
							this, configuration);

			getWorker().add( graphvizSerializer );
		}


		final DeveloperTuningOptionCustomImpl devTuning =
				DeveloperTuningOptionCustomImpl.createDirector(configuration);

		setDeveloperTuning( devTuning );


		return( true );
	}

	public boolean configureDebugWorker(final ILaunchConfiguration configuration) {

		return( true );
	}


	public boolean configureOtherWorker(final ILaunchConfiguration configuration) {

		return( true );
	}


	public static DirectorCustomImpl createSecond(final Workflow workflow,
			final ILaunchConfiguration configuration) {

		final DirectorCustomImpl director = new DirectorCustomImpl(workflow);

		director.setManifest( ManifestCustomImpl.create(true, true) );


		if( ! director.configureSecondWorker(configuration) ) {
			//!! ERROR
		}

		if( ! director.configureSecondSerializerWorker(configuration, true) ) {
			//!! ERROR
		}

		return( director );
	}

	public boolean configureSecondWorker(final ILaunchConfiguration configuration) {

		final SupervisorWorkerCustomImpl supervisor =
				SupervisorWorkerCustomImpl.createSecond(configuration);

		setDescription( "of graph exploration" );

		setSupervisor( supervisor );

		// Execution completion to next observable (default 'output#env = [*]')
		final BehaviorCoverageWorkerCustomImpl worker =
				BehaviorCoverageWorkerCustomImpl.createSecond(
						this, configuration);

		getWorker().add( worker );

		supervisor.getQueue().setHeuristicEnabled(true);

		return( true );
	}

	public boolean configureSecondSerializerWorker(
			final ILaunchConfiguration configuration, final boolean hasSecond) {

		boolean enabledSerialization;

		// Basic Trace generation
		try {
			enabledSerialization = configuration.getAttribute(
					ATTR_BASIC_TRACE_ENABLED_GENERATION, false);
		} catch( final CoreException e ) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			// Sequence Diagram ( PlantUML format) Trace Serializer
			final SequenceDiagramTraceSerializerWorkerCustomImpl sequenceDiagramSerializer =
					SequenceDiagramTraceSerializerWorkerCustomImpl.create(
							this, configuration);

			this.getWorker().add( sequenceDiagramSerializer );

			// Basic Textual (ad'oc  format) Trace Serializer
			final BasicTraceSerializerWorkerCustomImpl basicSerializer =
					BasicTraceSerializerWorkerCustomImpl.create(
							this, configuration);

			this.getWorker().add( basicSerializer );
		}

		// TTCN3 Trace generation
		try {
			enabledSerialization = configuration.getAttribute(
					ATTR_TTCN_ENABLED_GENERATION, false);
		} catch( final CoreException e ) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			final TTCNTraceSerializerWorkerCustomImpl ttcnSerializer =
					TTCNTraceSerializerWorkerCustomImpl.create(
							this, configuration);

			getWorker().add( ttcnSerializer );
		}

		// Symbex Graph [ GraphViz ] serialization
		try {
			enabledSerialization = configuration.getAttribute(
				ATTR_ENABLED_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_GENERATION, false);
		}
		catch (final CoreException e) {
			e.printStackTrace();

			enabledSerialization = false;
		}
		if( enabledSerialization ) {
			final SymbexGraphvizSerializerWorkerCustomImpl modelSerializer =
					SymbexGraphvizSerializerWorkerCustomImpl.createSecond(
							this, configuration);

			getWorker().add( modelSerializer );
		}

		if( hasSecond ) {
			final DeveloperTuningOptionCustomImpl devTuning =
				DeveloperTuningOptionCustomImpl.createSecondDirector(configuration);

			setDeveloperTuning( devTuning );
		}

		return( true );
	}


	public void toWriter(final PrettyPrintWriter writer) {
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

		final PrettyPrintWriter writer2 = writer.itab2();

		final ManifestCustomImpl manifest = (ManifestCustomImpl) getManifest();
		if( manifest != null ) {
			manifest.toWriter(writer2);
		}

		final Project project = getProject();
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
		final PrettyPrintWriter writer3 = writer.itab3();

		for( final Worker worker : getWorker() ) {
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
			else if( worker instanceof ModelGraphicSerializerWorkerCustomImpl ) {
				((ModelGraphicSerializerWorkerCustomImpl)
						worker).toWriter( writer3 );
			}
			else if( worker instanceof ModelGraphvizSerializerWorkerCustomImpl ) {
				((ModelGraphvizSerializerWorkerCustomImpl)
						worker).toWriter( writer3 );
			}

			else if( worker instanceof SymbexGraphicSerializerWorkerCustomImpl ) {
				((SymbexGraphicSerializerWorkerCustomImpl)
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
			else if( worker instanceof SequenceDiagramTraceSerializerWorkerCustomImpl ) {
				((SequenceDiagramTraceSerializerWorkerCustomImpl)
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

		final ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer2 );
		}

		final DeveloperTuningOptionCustomImpl devTuning =
				(DeveloperTuningOptionCustomImpl) getDeveloperTuning();
		if( devTuning != null ) {
			devTuning.toWriter( writer2 ); // "debug" );
		}

		writer.appendTabEol( "}" );
	}

}
