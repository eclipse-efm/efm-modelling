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
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.common.CommonFactory;
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationLimit;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationQueue;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.RedundancyDetection;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.impl.SupervisorWorkerImpl;

public class SupervisorWorkerCustomImpl extends SupervisorWorkerImpl
		implements IWorkflowConfigurationConstants {

	public SupervisorWorkerCustomImpl() {
		super();
	}


	public static SupervisorWorkerCustomImpl create(
			ILaunchConfiguration configuration) {
		SupervisorWorkerCustomImpl supervisor = new SupervisorWorkerCustomImpl();

		// MANIFEST
//		supervisor.setManifest( ManifestCustomImpl.create(true) );

		// EXPLORATION LIMIT
		GraphExplorationLimit limit =
				CommonFactory.eINSTANCE.createGraphExplorationLimit();

		try {
			limit.setEval( configuration.getAttribute(
					ATTR_SPECIFICATION_STOP_CRITERIA_STEPS, -1) );
		}
		catch (CoreException e) {
			e.printStackTrace();

			limit.setEval( -1 );
		}

		try {
			limit.setNode( configuration.getAttribute(
					ATTR_SPECIFICATION_STOP_CRITERIA_NODE, -1) );
		}
		catch (CoreException e) {
			e.printStackTrace();

			limit.setNode( -1 );
		}

		try {
			limit.setHeight( configuration.getAttribute(
					ATTR_SPECIFICATION_STOP_CRITERIA_HEIGHT, -1) );
		}
		catch (CoreException e) {
			e.printStackTrace();

			limit.setHeight( -1 );
		}

		try {
			limit.setWidth( configuration.getAttribute(
					ATTR_SPECIFICATION_STOP_CRITERIA_WIDTH, -1) );
		} catch (CoreException e) {
			e.printStackTrace();

			limit.setWidth( -1 );
		}

		limit.setReport( -1 );
		limit.setSave( -1 );

		supervisor.setLimit( limit );

		// EXPLORATION QUEUE STRATEGY
		GraphExplorationQueue queue =
				CommonFactory.eINSTANCE.createGraphExplorationQueue();

		GraphExplorationStrategyKind strategy;
		try {
			strategy = GraphExplorationStrategyKind.get(
					configuration.getAttribute(
							ATTR_SPECIFICATION_ANALYZE_STRATEGY,
							GraphExplorationStrategyKind.
									BREADTH_FIRST_SEARCH.getLiteral()) );
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strategy = GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
		}
		queue.setStrategy( (strategy != null) ? strategy :
				GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH );

		supervisor.setQueue( queue );

		// CONSOLE LOG
		ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(
						"\\nstep:%1% , context:%2% , height:%3% , width:%4%",
						"\\nstop:%1% , context:%2% , height:%3% , width:%4%");

		supervisor.setConsole( console );

		return( supervisor );
	}



	public static SupervisorWorkerCustomImpl createSecond(
			ILaunchConfiguration configuration) {
		SupervisorWorkerCustomImpl supervisor = new SupervisorWorkerCustomImpl();

		// MANIFEST
//		supervisor.setManifest( ManifestCustomImpl.create(true) );

		// EXECUTION EXTENDER
		String strObjective;
		try {
			strObjective = configuration.getAttribute(
					ATTR_TRACE_EXTENSION_OBJECTIVE,
					DEFAULT_TRACE_EXTENSION_OBJECTIVE);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strObjective = DEFAULT_TRACE_EXTENSION_OBJECTIVE;
		}
		if( (strObjective == null) || strObjective.isEmpty() ) {
			strObjective = DEFAULT_TRACE_EXTENSION_OBJECTIVE;
		}

		TraceSpecificationCustomImpl extender =
				TraceSpecificationCustomImpl.create("extender", strObjective);

		extender.setDescription(
				"Extension of Traces to reach observables for tests purpose" );
		supervisor.setExtender( extender );


		// EXPLORATION LIMIT
		GraphExplorationLimit limit =
				CommonFactory.eINSTANCE.createGraphExplorationLimit();

		try {
			limit.setEval( configuration.getAttribute(
					ATTR_TRACE_EXTENSION_EVALUATION_STEPS, -1) );
		}
		catch (CoreException e) {
			e.printStackTrace();

			limit.setEval( -1 );
		}

		limit.setNode( -1 );
		limit.setHeight( -1 );
		limit.setWidth( -1 );

		limit.setReport( -1 );
		limit.setSave( -1 );

		supervisor.setLimit( limit );

		// EXPLORATION QUEUE STRATEGY
		GraphExplorationQueue queue =
				CommonFactory.eINSTANCE.createGraphExplorationQueue();

		GraphExplorationStrategyKind strategy;
		try {
			strategy = GraphExplorationStrategyKind.get(
					configuration.getAttribute(
							ATTR_SPECIFICATION_ANALYZE_STRATEGY,
							GraphExplorationStrategyKind.
									BREADTH_FIRST_SEARCH.getLiteral()) );
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strategy = GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
		}
		queue.setStrategy( (strategy != null) ? strategy :
			GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH );
//		queue.setHeuristic(true);

		supervisor.setQueue( queue );


		// CONSOLE LOG
		ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(
						"\\nstep:%1% , context:%2% , height:%3% , width:%4%",
						"\\nstop:%1% , context:%2% , height:%3% , width:%4%");

		supervisor.setConsole( console );

		return( supervisor );
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "supervisor" );

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

		// MANIFEST
		ManifestCustomImpl manifest = (ManifestCustomImpl) getManifest();
		if( manifest != null ) {
			manifest.toWriter(writer2);
		}

		// EXECUTION EXTENDER
		TraceSpecificationCustomImpl extender =
				(TraceSpecificationCustomImpl) getExtender();
		if( extender != null ) {
			extender.toWriter( writer2 );
		}

		// EXPLORATION LIMIT
		GraphExplorationLimit limit = getLimit();

		writer.appendTab2Eol( "limit 'of graph exploration' [" );
//				"limit 'defining the maximum step & size of the graph' [" );

		writer.appendTab3( "step = " ).appendEol( limit.getEval() );

		long value = -1;

		if( (value = limit.getNode()) >= 0 ) {
			writer.appendTab3( "node = " ).appendEol( value );
		}
		if( (value = limit.getHeight()) >= 0 ) {
			writer.appendTab3( "height = " ).appendEol( value );
		}
		if( (value = limit.getWidth()) >= 0 ) {
			writer.appendTab3( "width  = " ).appendEol( value );
		}

		if( (value = limit.getReport()) >= 0 ) {
			writer.appendTab3( "report = " ).appendEol( value );
		}
		if( (value = limit.getSave()) >= 0 ) {
			writer.appendTab3( "save   = " ).appendEol( value );
		}

		writer.appendTab2Eol( "] // end limit" );

		// EXPLORATION QUEUE STRATEGY
		GraphExplorationQueue queue = getQueue();

		writer.appendTab2Eol(
				"queue 'defining the exploration/search strategy' [" );

		final int weight = queue.getWeight();
		final boolean useHeuristic = queue.isHeuristic();

		writer.appendTab3( "strategy = '" );
		if( useHeuristic || (weight > 0) ) {
			writer.append( "WEIGHT#" );
		}
		writer.append( queue.getStrategy().getLiteral() ).appendEol("'");

		if( weight > 0 ) {
			writer.appendTab3( "weight = " ).appendEol( weight );
		}
		if( useHeuristic ) {
			writer.appendTab3Eol( "heuristic = true" );
		}

		writer.appendTab2Eol( "] // end queue" );

		// REDUNDANCY DETECTION
		writer.appendTab2Eol(
				"redundancy 'detection strategy' [" );

		RedundancyDetection redundancy = getRedundancy();
		if( redundancy != null ) {
			if( (str = redundancy.getComparer()) != null ) {
				writer.appendTab3( "comparer = '" ).append( str ).appendEol( "'" );

				if( (str = redundancy.getSolver()) == null ) {
					str = "OMEGA";
				}
				writer.appendTab3( "solver = '" ).append( str ).appendEol( "'" );

				if( (str = redundancy.getPathScope()) == null ) {
					str = "CURRENT";
				}
				writer.appendTab3( "path_scope = '" ).append( str ).appendEol("'");

				if( (str = redundancy.getDataScope()) == null ) {
					str = "ALL";
				}
				writer.appendTab3( "data_scope = '" ).append( str ).appendEol("'");
			}
			else {
				writer.appendTab3( "loop#detection#trivial = " )
						.appendEol( redundancy.isLoopDetetctionTrivial() );
			}
		}
		else {
			writer.appendTab3Eol( "loop#detection#trivial = true" );
		}

		writer.appendTab2Eol( "] // end redundancy" );

		// CONSOLE LOG
		ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer.itab2() );
		}

		writer.appendTabEol( "}" );
	}

}
