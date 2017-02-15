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
package org.eclipse.efm.runconfiguration.workflow;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.runconfiguration.workflow.common.CommonFactory;
import org.eclipse.efm.runconfiguration.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.common.DeveloperTuningOptionCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.common.Project;
import org.eclipse.efm.runconfiguration.workflow.coverage.BehaviorCoverageWorkerCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.coverage.TransitionCoverageWorkerCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.impl.DirectorImpl;
import org.eclipse.efm.runconfiguration.workflow.serializer.BasicTraceSerializerWorkerCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.serializer.ModelGraphvizSerializerWorkerCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.serializer.SymbexGraphvizSerializerWorkerCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.serializer.TTCNTraceSerializerWorkerCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.test.OfflineTestWorkerCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.util.PrettyPrintWriter;

public class DirectorCustomImpl extends DirectorImpl
		implements IWorkflowConfigurationConstants {

	public DirectorCustomImpl(Workflow workflow) {
		super();

		setWorkflow(workflow);
	}

	public DirectorCustomImpl(Workflow workflow, String name) {
		super();

		setWorkflow(workflow);
		setName(name);
	}


	public static DirectorCustomImpl create(Workflow workflow,
			ILaunchConfiguration configuration, boolean hasSecond) {

		DirectorCustomImpl director = new DirectorCustomImpl(workflow);

		director.setManifest( ManifestCustomImpl.create(true, true) );


		if( ! director.configureProject(configuration) ) {
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


	public boolean configureProject(ILaunchConfiguration configuration) {
		String modelPath;
		try {
			modelPath = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_FILE_LOCATION, "");
		}
		catch (CoreException e) {
			e.printStackTrace();

			modelPath = null;
		}

		if( (modelPath != null) && (! modelPath.isEmpty()) ) {
			Project project = CommonFactory.eINSTANCE.createProject();

			int pos = modelPath.lastIndexOf(IPath.SEPARATOR);
			if( pos > 0 ) {
				project.setSource( modelPath.substring(0, pos) );
				modelPath = modelPath.substring(pos+1);
			}
			project.setModel( modelPath );

			setProject( project );

			return( true );
		}

		return( false );
	}

	public boolean configureMainWorker(ILaunchConfiguration configuration) {

		SupervisorWorkerCustomImpl supervisor =
				SupervisorWorkerCustomImpl.create(configuration);

		setDescription( "of graph exploration" );

		setSupervisor( supervisor );

		String analysisProfile;
		try {
			analysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_ANALYSIS_PROFILE,
					ANALYSIS_PROFILE_MODEL);
		}
		catch (CoreException e) {
			e.printStackTrace();

			analysisProfile = ANALYSIS_PROFILE_MODEL;
		}

		String modelAnalysis;
		try {
			modelAnalysis = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS,
					ANALYSIS_PROFILE_MODEL_EXPLORATION);
		}
		catch (CoreException e) {
			e.printStackTrace();

			modelAnalysis = ANALYSIS_PROFILE_MODEL_EXPLORATION;
		}

		boolean isRedundancyDetectionPossible = false;

		switch ( analysisProfile ) {
			case ANALYSIS_PROFILE_MODEL: {
				switch ( modelAnalysis ) {
					case ANALYSIS_PROFILE_MODEL_EXPLORATION: {
						//!! NOTHING to do...
						// --> only need a Supervisor worker for Model Exploration

						isRedundancyDetectionPossible = true;

						break;
					}
					case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION: {
						TransitionCoverageWorkerCustomImpl worker =
								TransitionCoverageWorkerCustomImpl.create(
										this, configuration);

						getWorker().add( worker );

						supervisor.getQueue().setHeuristic(true);

						supervisor.getQueue().setWeight(8);

						isRedundancyDetectionPossible = true;

						break;
					}
					case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR: {
						BehaviorCoverageWorkerCustomImpl worker =
								BehaviorCoverageWorkerCustomImpl.create(
										this, configuration);

						getWorker().add( worker );

						supervisor.getQueue().setHeuristic(true);

						break;
					}
					default: {
						break;
					}
				}
				break;
			}
			case ANALYSIS_PROFILE_TEST_OFFLINE: {
				OfflineTestWorkerCustomImpl worker =
						OfflineTestWorkerCustomImpl.create(
								this, configuration);

				getWorker().add( worker );

				supervisor.getQueue().setHeuristic(true);

				break;
			}
			default: {
				break;
			}
		}

		if( isRedundancyDetectionPossible ) {
			boolean enabledRedundancyDetection = false;
			try {
				enabledRedundancyDetection = configuration.getAttribute(
						ATTR_ENABLED_INCLUSION_CRITERION, false);
			}
			catch( CoreException e ) {
				e.printStackTrace();

				enabledRedundancyDetection = false;
			}

			if( enabledRedundancyDetection ) {
				getSupervisor().setRedundancy(
						CommonFactory.eINSTANCE.createRedundancyDetection());
			}
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

		supervisor.getQueue().setHeuristic(true);

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
