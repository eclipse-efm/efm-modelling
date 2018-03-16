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
package org.eclipse.efm.execution.core.workflow.coverage;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.common.CommonFactory;
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.CoverageHeuristic;
import org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind;
import org.eclipse.efm.execution.core.workflow.common.HeuristicClassKind;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.coverage.impl.TransitionCoverageWorkerImpl;

public class TransitionCoverageWorkerCustomImpl extends TransitionCoverageWorkerImpl
		implements IWorkflowConfigurationConstants {

	protected TransitionCoverageWorkerCustomImpl(Director director, String name) {
		super();

		setDirector(director);
		setName(name);
	}

	protected TransitionCoverageWorkerCustomImpl(
			Director director, String name, String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static TransitionCoverageWorkerCustomImpl create(
			Director director, ILaunchConfiguration configuration) {

		TransitionCoverageWorkerCustomImpl coverageWorker =
				new TransitionCoverageWorkerCustomImpl(
						director, "transition_coverage");

//		coverageWorker.setManifest( ManifestCustomImpl.create(true) );


		boolean isEnabled;
		try {
			isEnabled = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_STOP, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setStopWhenComplete(isEnabled);

		try {
			isEnabled = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_MINIMIZE, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setMinimizationEnabled(isEnabled);

		try {
			isEnabled = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_SLICE, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setSliceWhenComplete(isEnabled);

		try {
			isEnabled = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_HEURISTIC, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHeuristicEnabled(isEnabled);

		String str;
		try {
			str = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_SCOPE,
					CoverageScopeKind.MODEL.getLiteral());
		}
		catch( CoreException e1 ) {
			e1.printStackTrace();
			str = CoverageScopeKind.MODEL.getLiteral();
		}
		CoverageScopeKind scope = CoverageScopeKind.get(str);
		coverageWorker.setScope(
				(scope != null) ? scope: CoverageScopeKind.MODEL );


		coverageWorker.setHeuristicConfig(  createHeuristic(configuration) );

		boolean enabledTransitionSelection;
		try {
			enabledTransitionSelection = configuration.getAttribute(
					ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false);
		}
		catch( CoreException e1 ) {
			e1.printStackTrace();

			enabledTransitionSelection = false;
		}

		if ( enabledTransitionSelection )
		{
			coverageWorker.setScope( CoverageScopeKind.DETAILS );

			TraceSpecificationCustomImpl trace =
					TraceSpecificationCustomImpl.create(
							"details", configuration,
							ATTR_TRANSITION_COVERAGE_SELECTION,
							TraceElementKind.UNDEFINED);

				coverageWorker.setTrace( trace );
		}

		ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(
						" , coverage: %1% / %2%" );

		coverageWorker.setConsole( console );

		return( coverageWorker );
	}


	public static CoverageHeuristic createHeuristic(
			ILaunchConfiguration configuration) {

		CoverageHeuristic cHeuristic =
				CommonFactory.eINSTANCE.createCoverageHeuristic();

		boolean isEnabled;
		int intValue;
		String str;

		try {
			str = configuration.getAttribute(ATTR_TRANSITION_COVERAGE_HEURISTIC_START, "BASIC");
		}
		catch( CoreException e1 ) {
			e1.printStackTrace();
			str = "BASIC";
		}
		HeuristicClassKind start = HeuristicClassKind.get(str);
		cHeuristic.setHeuristicStart(
				(start != null) ? start: HeuristicClassKind.BASIC );

		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_HEURISTIC_TRIALS, -1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = -1;
		}
		cHeuristic.setHeuristicTrials( intValue );


		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_OBJECTIVE_RATE, 100);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 100;
		}
		cHeuristic.setObjectiveRateGoal( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_OBJECTIVE_REST, 0);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 0;
		}
		cHeuristic.setObjectiveRestGoal( intValue );


		try {
			str = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_HEURISTIC, "SMART");
		}
		catch( CoreException e1 ) {
			e1.printStackTrace();
			str = "SMART";
		}
		HeuristicClassKind directive = HeuristicClassKind.get(str);
		cHeuristic.setDirectiveTraceHeuristic(
				(directive != null) ? directive: HeuristicClassKind.SMART );

		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_COUNT_LIMIT, 7);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 7;
		}
		cHeuristic.setDirectiveTraceCount( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_DIRECTIVE_TRACE_SIZE_LIMIT, 7);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 7;
		}
		cHeuristic.setDirectiveTraceSize( intValue );


		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_LOOKAHEAD_DEPTH, 7);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 7;
		}
		cHeuristic.setLookaheadDepth( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_LOOKAHEAD_WIDTH, 42);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 42;
		}
		cHeuristic.setLookaheadWidth( intValue );


		try {
			isEnabled = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_RANDOM, false);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = false;
		}
		cHeuristic.setHitStronglyRandomEnabled( isEnabled );

		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_HIT_STRONGLY_COUNT, 1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 1;
		}
		cHeuristic.setHitStronglyCount( intValue );


		try {
			isEnabled = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_RANDOM, false);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = false;
		}
		cHeuristic.setHitWeaklyRandomEnabled( isEnabled );

		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_HIT_WEAKLY_COUNT, 1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 1;
		}
		cHeuristic.setHitWeaklyCount( intValue );


		try {
			isEnabled = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_HIT_OTHER_RANDOM, false);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = false;
		}
		cHeuristic.setHitOtherRandomEnabled( isEnabled );

		try {
			intValue = configuration.getAttribute(
					ATTR_TRANSITION_COVERAGE_HIT_OTHER_COUNT, 1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 1;
		}
		cHeuristic.setHitOtherCount( intValue );


		return( cHeuristic );
	}



	public void toWriter(PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "coverage#transition" );

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

		writer.appendTab2Eol( "property [" );

		writer.appendTab3( "stop  = " ).appendEol( isStopWhenComplete() );

		writer.appendTab3( "slice = " ).appendEol( isSliceWhenComplete() );

		writer.appendTab3( "minimize  = " ).appendEol( isMinimizationEnabled() );

		writer.appendTab3( "heuristic = " ).appendEol( isHeuristicEnabled() );

		writer.appendTab3( "scope = '" )
			.append( getScope().getLiteral() )
			.appendEol( "'" );

		writer.appendTab2Eol( "] // end property" );


		CoverageHeuristic cHeuristic = getHeuristicConfig();
		if( isHeuristicEnabled() && (cHeuristic != null) ) {
			writer.appendTab2Eol( "heuristic 'configuration' [" );

			writer.appendTab3( "heuristic#start  = '" )
				.append( cHeuristic.getHeuristicStart().getLiteral() )
				.appendEol( "'" );
			writer.appendTab3( "heuristic#trials = " )
				.appendEol( cHeuristic.getHeuristicTrials() );

			writer.appendTab3( "objective#rate = " )
				.appendEol( cHeuristic.getObjectiveRateGoal() );
			writer.appendTab3( "objective#rest = " )
				.appendEol( cHeuristic.getObjectiveRestGoal() );


			writer.appendTab3( "directive#trace#heuristic   = '" )
				.append( cHeuristic.getDirectiveTraceHeuristic().getLiteral() )
				.appendEol( "'" );
			writer.appendTab3( "directive#trace#count#limit = " )
				.appendEol( cHeuristic.getDirectiveTraceCount() );
			writer.appendTab3( "directive#trace#size#limit  = " )
				.appendEol( cHeuristic.getDirectiveTraceSize() );


			writer.appendTab3( "lookahead#depth = " )
				.appendEol( cHeuristic.getLookaheadDepth() );
			writer.appendTab3( "lookahead#width = " )
				.appendEol( cHeuristic.getLookaheadWidth() );

			writer.appendTab3( "hit#strongly#random = " )
				.appendEol( cHeuristic.isHitStronglyRandomEnabled() );
			writer.appendTab3( "hit#strongly#count  = " )
				.appendEol( cHeuristic.getHitStronglyCount() );

			writer.appendTab3( "hit#weakly#random = " )
				.appendEol( cHeuristic.isHitWeaklyRandomEnabled() );
			writer.appendTab3( "hit#weakly#count  = " )
				.appendEol( cHeuristic.getHitWeaklyCount() );

			writer.appendTab3( "hit#other#random = " )
				.appendEol( cHeuristic.isHitOtherRandomEnabled() );
			writer.appendTab3( "hit#other#count  = " )
				.appendEol( cHeuristic.getHitOtherCount() );

			writer.appendTab2Eol( "] // end heuristic" );
		}

		TraceSpecificationCustomImpl trace =
				(TraceSpecificationCustomImpl) getTrace();
		if( trace != null ) {
			trace.toWriter(writer2);
		}

		ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer2 );
		}

		writer.appendTabEol( "}" );
	}

}
