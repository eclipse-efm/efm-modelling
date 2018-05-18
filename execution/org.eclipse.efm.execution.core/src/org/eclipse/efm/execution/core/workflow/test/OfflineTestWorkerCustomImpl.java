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
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.test.impl.OfflineTestWorkerImpl;

public class OfflineTestWorkerCustomImpl extends OfflineTestWorkerImpl
		implements IWorkflowConfigurationConstants {

	protected OfflineTestWorkerCustomImpl(Director director, String name) {
		super();

		setDirector(director);
		setName(name);
	}

	protected OfflineTestWorkerCustomImpl(
			Director director, String name, String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static OfflineTestWorkerCustomImpl create(
			Director director, ILaunchConfiguration configuration) {

		OfflineTestWorkerCustomImpl testWorker =
				new OfflineTestWorkerCustomImpl(
						director, "offline_test");

//		testWorker.setManifest( ManifestCustomImpl.create(true) );


		String path;
		try {
			path = configuration.getAttribute(
					ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
					DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			path = DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION;
		}
		if( (path != null) && (! path.isEmpty())
			&& (! DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION.equals(path)) ) {
			testWorker.setMergedTraceFile(path);
		}

		try {
			path = configuration.getAttribute(
					ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
					DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			path = DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION;
		}

		if( (path != null) && (! path.isEmpty())
			&& (! DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION.equals(path)) ) {
			testWorker.setTestPurposeFile(path);
		}



		boolean enabledObservableControllable;
		try {
			enabledObservableControllable = configuration.getAttribute(
					ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION,
					false);
		}
		catch( CoreException e ) {
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


//		ConsoleLogFormatCustomImpl console =
//				ConsoleLogFormatCustomImpl.create(
//						" , test: %1% / %2%" );
//
//		testWorker.setConsole( console );

		return( testWorker );
	}


	public void toWriter(PrettyPrintWriter writer) {
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

		PrettyPrintWriter writer2 = writer.itab2();

		ManifestCustomImpl manifest = (ManifestCustomImpl) getManifest();
		if( manifest != null ) {
			manifest.toWriter(writer2);
		}


		writer.appendTab2Eol( "property [" )
			.appendTab3Eol( "format = \"BASIC#XLIA\"" )
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

		writer.appendTab2Eol( "] // end queue" );


		TraceSpecificationCustomImpl observable =
				(TraceSpecificationCustomImpl) getObservable();
		if( observable != null ) {
			observable.toWriter(writer2);
		}

		TraceSpecificationCustomImpl controllable =
				(TraceSpecificationCustomImpl) getControllable();
		if( controllable != null ) {
			controllable.toWriter(writer2);
		}

		ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer2 );
		}

		writer.appendTabEol( "}" );
	}

}
