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
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.common.CheckingScopeKind;
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl;

public class BehaviorCoverageWorkerCustomImpl extends BehaviorCoverageWorkerImpl
		implements IWorkflowConfigurationConstants, IWorkflowSpiderConfigurationUtils {

	protected BehaviorCoverageWorkerCustomImpl(Director director, String name) {
		super();

		setDirector(director);
		setName(name);
	}

	protected BehaviorCoverageWorkerCustomImpl(
			Director director, String name, String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static BehaviorCoverageWorkerCustomImpl create(
			Director director, ILaunchConfiguration configuration) {

		BehaviorCoverageWorkerCustomImpl coverageWorker =
				new BehaviorCoverageWorkerCustomImpl(
						director, "behavior_coverage");

//		coverageWorker.setManifest( ManifestCustomImpl.create(true) );

		boolean isEnabled;

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_STOP, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setStopWhenComplete(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_SLICE, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setSliceWhenComplete(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HEURISTIC, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHeuristicEnabled(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_SEARCH_SCOPE_LOCALLY, false);
		}
		catch( CoreException e1 ) {
			e1.printStackTrace();
			isEnabled = false;
		}
		coverageWorker.setCheckingScope( isEnabled ?
				CheckingScopeKind.LOCALLY : CheckingScopeKind.GLOBALLY );

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setOrderedTrace( isEnabled );

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHitConsecutive(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_FOLDING, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHitFolding(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_LUCKY, false);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = false;
		}
		coverageWorker.setHitLucky(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_MAX, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHitMax(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_SLICE, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setJumpSlice(isEnabled);


		coverageWorker.setHeuristicConfiguration(configuration);


		TraceSpecificationCustomImpl trace =
				TraceSpecificationCustomImpl.create(
						"trace", configuration,
						ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST,
						TraceElementKind.UNDEFINED);

		coverageWorker.setTrace( trace );

		ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(
						DEFAULT_COVERAGE_FORMAT,
						DEFAULT_COVERAGE_SPIDER_INIT_POSITION_FORMAT,
						DEFAULT_COVERAGE_SPIDER_STEP_POSITION_FORMAT,
						DEFAULT_COVERAGE_SPIDER_STOP_POSITION_FORMAT);


		coverageWorker.setConsole( console );

		return( coverageWorker );
	}


	public void setHeuristicConfiguration(
			ILaunchConfiguration configuration) {
		int intValue;

		try {
			intValue = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT,
					DEFAULT_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 6;
		}
		setJumpHeight( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT, -1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = -1;
		}
		setJumpTrialsLimit( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT, 1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 1;
		}
		setHitCount( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT, 1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 1;
		}
		setJumpCount( intValue );
	}


	public static BehaviorCoverageWorkerCustomImpl createSecond(
			Director director, ILaunchConfiguration configuration) {

		BehaviorCoverageWorkerCustomImpl coverageWorker =
				new BehaviorCoverageWorkerCustomImpl(
						director, "behavior_coverage");

//		coverageWorker.setManifest( ManifestCustomImpl.create(true) );

		coverageWorker.setStopWhenComplete(true);
		coverageWorker.setSliceWhenComplete(true);
		coverageWorker.setHeuristicEnabled(true);
		coverageWorker.setCheckingScope( CheckingScopeKind.LOCALLY );
		coverageWorker.setOrderedTrace(true);
		coverageWorker.setHitConsecutive(false);
		coverageWorker.setHitFolding(true);
		coverageWorker.setHitLucky(false);
		coverageWorker.setHitMax(false);
		coverageWorker.setJumpSlice(false);

		coverageWorker.setJumpHeight(5);
		coverageWorker.setJumpTrialsLimit(2);
		coverageWorker.setHitCount(1);
		coverageWorker.setJumpCount(-1);

		TraceSpecificationCustomImpl trace =
				TraceSpecificationCustomImpl.create(
						"trace", configuration,
						ATTR_TRACE_EXTENSION_OBJECTIVE,
						DEFAULT_TRACE_EXTENSION_OBJECTIVE,
						TraceElementKind.UNDEFINED);

		coverageWorker.setTrace( trace );


		ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(
						DEFAULT_COVERAGE_FORMAT,
						DEFAULT_COVERAGE_SPIDER_INIT_POSITION_FORMAT,
						DEFAULT_COVERAGE_SPIDER_STEP_POSITION_FORMAT,
						DEFAULT_COVERAGE_SPIDER_STOP_POSITION_FORMAT);

		coverageWorker.setConsole( console );

		return( coverageWorker );
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "coverage#behavior" );

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

		writer.appendTab3( "heuristic = " ).appendEol( isHeuristicEnabled() );

		writer.appendTab3( "scope = '" )
			.append( getCheckingScope().getLiteral() )
			.appendEol( "'" );

		writer.appendTab3( "scheduler = " )
			.appendEol( isOrderedTrace() ? "'|;|'" : "'|i|'" );

		writer.appendTab2Eol( "] // end property" );

		// Trace Sequence to cover
		TraceSpecificationCustomImpl trace =
				(TraceSpecificationCustomImpl) getTrace();
		if( trace != null ) {
			trace.toWriter(writer2);
		}

		// Heuristic for trace exploration
		writer.appendTab2Eol( "heuristic [" );

		if( isOrderedTrace() ) {
			writer.appendTab3( "hit#consecutive = " )
				.appendEol( isHitConsecutive() );
		}

		writer.appendTab3( "hit#folding = " ).appendEol( isHitFolding() );

		writer.appendTab3( "hit#lucky   = " ).appendEol( isHitLucky() );

		writer.appendTab3( "hit#max     = " ).appendEol( isHitMax() );

		writer.appendTab3( "hit#final   = " ).appendEol( isHitFinal() );

		writer.appendTab3( "jump#slice  = " ).appendEol( isJumpSlice() );

		writer.appendTab3( "jump#height = " ).appendEol( getJumpHeight() );

		writer.appendTab3( "jump#trials#limit = " )
			.appendEol( getJumpTrialsLimit() );

		writer.appendTab3( "hit#count  = " ).appendEol( getHitCount() );

		writer.appendTab3( "jump#count = " ).appendEol( getJumpCount() );

		writer.appendTab2Eol( "] // end heuristic" );

		// Console configuration
		ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer2 );
		}

		writer.appendTabEol( "}" );
	}

}
