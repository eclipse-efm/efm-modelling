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
package org.eclipse.efm.execution.core.workflow.test;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.test.impl.OfflineTestWorkerImpl;

public class OfflineTestWorkerCustomImpl extends OfflineTestWorkerImpl
		implements IWorkflowConfigurationConstants, IWorkflowSpiderConfigurationUtils {

	protected OfflineTestWorkerCustomImpl(final Director director, final String name) {
		super();

		setDirector(director);
		setName(name);
	}

	protected OfflineTestWorkerCustomImpl(
			final Director director, final String name, final String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static OfflineTestWorkerCustomImpl create(final Director director,
			final ILaunchConfiguration configuration, final IPath projectRootPath) {

		final OfflineTestWorkerCustomImpl testWorker =
				new OfflineTestWorkerCustomImpl(
						director, "offline_test");

//		testWorker.setManifest( ManifestCustomImpl.create(true) );

		String path = WorkflowFileUtils.getAbsoluteLocation(configuration,
				ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
				DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION);
		if( (path != null) && (! path.isEmpty())
			&& (! DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION.equals(path)) )
		{
			testWorker.setMergedTraceFile(
			WorkflowFileUtils.makeRelativeLocation(projectRootPath, path) );
		}

		path = WorkflowFileUtils.getAbsoluteLocation(configuration,
				ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
				DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION);

		if( (path != null) && (! path.isEmpty())
			&& (! path.endsWith(DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION)) )
		{
			testWorker.setTestPurposeFile(
					WorkflowFileUtils.makeRelativeLocation(projectRootPath, path) );
		}



		boolean enabledObservableControllable;
		try {
			enabledObservableControllable = configuration.getAttribute(
					ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION,
					false);
		}
		catch( final CoreException e ) {
			e.printStackTrace();

			enabledObservableControllable = false;
		}

		if( enabledObservableControllable ) {
			testWorker.setObservable(
					TraceSpecificationCustomImpl.create(
							"observable", configuration,
							ATTR_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
							DEFAULT_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
							TraceElementKind.UNDEFINED) );

			testWorker.setControllable(
					TraceSpecificationCustomImpl.create(
							"controllable", configuration,
							ATTR_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
							DEFAULT_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
						TraceElementKind.UNDEFINED) );
		}
		else {
			testWorker.setObservable( null );

			testWorker.setControllable( null );
		}


		final ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(
						DEFAULT_COVERAGE_FORMAT,
						DEFAULT_COVERAGE_SPIDER_INIT_POSITION_FORMAT,
						DEFAULT_COVERAGE_SPIDER_STEP_POSITION_FORMAT,
						DEFAULT_COVERAGE_SPIDER_STOP_POSITION_FORMAT);

		testWorker.setConsole( console );

		return( testWorker );
	}


	public void toWriter(final PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "test#offline" );

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

		writer.appendTab2Eol( "property [" )
			.appendTab3Eol( "format = \"BASIC#XLIA\"" )
			.appendTab3Eol( "slice  = true" )
			.appendTab3Eol( "trace#folding  = true" )
			.appendTab3Eol( "step#scheduler = '|i|'" )
			.appendTab3Eol( "trace#reporting#size = 7" )
			.appendTab3Eol( "slice = true" )
			.appendTab2Eol( "] // end property" );

		writer.appendTab2Eol( "merged_trace [" );

		if( (str = getMergedTraceFile()) != null ) {
			writer.appendTab3( "mergedTraceFile = \"" )
				.append( str ).appendEol("\"");
		}
		else {
			writer.appendTab3( "mergedTraceFile = \"" )
				.append( DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION )
				.appendEol( "\"" );
		}

		if( (str = getTestPurposeFile()) != null ) {
			writer.appendTab3( "testPurposeFile = \"" )
				.append( str ).appendEol("\"");
		}
		else {
			writer.appendTab3( "//testPurposeFile = \"" )
				.append( DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION )
				.appendEol( "\"" );
		}

		writer.appendTab2Eol( "] // end merged_trace" );


		final TraceSpecificationCustomImpl observable =
				(TraceSpecificationCustomImpl) getObservable();
		if( observable != null ) {
			observable.toWriter(writer2);
		}

		final TraceSpecificationCustomImpl controllable =
				(TraceSpecificationCustomImpl) getControllable();
		if( controllable != null ) {
			controllable.toWriter(writer2);
		}

		final ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer2 );
		}

		writer.appendTabEol( "}" );
	}

}
