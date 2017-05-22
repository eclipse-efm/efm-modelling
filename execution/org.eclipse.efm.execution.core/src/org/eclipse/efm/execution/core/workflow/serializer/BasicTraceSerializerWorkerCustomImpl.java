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
package org.eclipse.efm.execution.core.workflow.serializer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.impl.BasicTraceSerializerImpl;

public class BasicTraceSerializerWorkerCustomImpl extends BasicTraceSerializerImpl
		implements IWorkflowConfigurationConstants {

	public BasicTraceSerializerWorkerCustomImpl(
			Director director, String name) {
		super();

		setDirector(director);
		setName(name);
	}

	public BasicTraceSerializerWorkerCustomImpl(
			Director director, String name, String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static BasicTraceSerializerWorkerCustomImpl create(
			Director director, ILaunchConfiguration configuration) {

		BasicTraceSerializerWorkerCustomImpl serializerWorker =
				new BasicTraceSerializerWorkerCustomImpl(
						director, "basic_trace_generator");

//		serializerWorker.setManifest( ManifestCustomImpl.create(true) );

		String traceFormat;
		boolean enabled;

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ENABLED_NORMALIZATION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		serializerWorker.setEnabledNormalization( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_INITIAL_VALUES_ENABLED_PRINTING, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		serializerWorker.setEnabledInitialValuesPrinting( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_LIFELINES_ENABLED_PRINTING, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		serializerWorker.setEnabledLifelinesPrinting( enabled );


		try {
			traceFormat = configuration.getAttribute(
					ATTR_BASIC_TRACE_FORMAT_ELEMENT_LIST,
					DEFAULT_BASIC_TRACE_FORMAT_ELEMENT_LIST);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			traceFormat = DEFAULT_BASIC_TRACE_FORMAT_ELEMENT_LIST;
		}
		if( (traceFormat == null) || (traceFormat.trim().isEmpty()) ) {
			traceFormat = DEFAULT_BASIC_TRACE_FORMAT_ELEMENT_LIST;
		}

		TraceSpecificationCustomImpl format =
				TraceSpecificationCustomImpl.create("format", traceFormat);

		serializerWorker.setFormat( format );


		TraceSpecificationCustomImpl trace =
				TraceSpecificationCustomImpl.create(
						"trace", SYNTAX_TRACE_SPECIFICATION_LINK);

		configureTrace( trace , configuration );

		serializerWorker.setTrace( trace );


		String path;
		try {
			path = configuration.getAttribute(
					ATTR_BASIC_TRACE_FOLDER_NAME,
					DEFAULT_BASIC_TRACE_FOLDER_NAME);
		} catch( CoreException e ) {
			e.printStackTrace();

			path = "basic";
		}
		serializerWorker.setFolderName( path );

		try {
			path = configuration.getAttribute(
					ATTR_BASIC_TRACE_FILE_NAME,
					DEFAULT_BASIC_TRACE_FILE_NAME);
		} catch( CoreException e ) {
			e.printStackTrace();

			path = "tests.txt";
		}
		serializerWorker.setFileName( path );

		return( serializerWorker );
	}


	private static void configureTrace(
			TraceSpecificationCustomImpl trace,
			ILaunchConfiguration configuration) {
		boolean enabled;

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_TIME_SELECTION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.TIME, "[*]"));
		}

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ALL_EXTERNAL_INPUT_COM_SELECTION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.INPUT_ENV, "[*]"));
		}

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ALL_EXTERNAL_OUTPUT_COM_SELECTION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.OUTPUT_ENV, "[*]"));
		}

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ALL_INPUT_COM_SELECTION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.INPUT, "[*]"));
		}

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ALL_OUTPUT_COM_SELECTION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.OUTPUT, "[*]"));
		}

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ALL_VARIABLE_SELECTION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.VARIABLE, "[*]"));
		}

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ALL_TRANSITION_SELECTION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.TRANSITION, "[*]"));
		}

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ALL_STATE_SELECTION, false);
		}
		catch( CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.STATE, "[*]"));
		}


		String detailsTrace;
		try {
			detailsTrace = configuration.getAttribute(
					ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST, "");
		}
		catch( CoreException e ) {
			e.printStackTrace();

			detailsTrace = null;
		}

		trace.parseAll( detailsTrace );

	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "serializer#symbex#trace#basic" );

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

		writer2.appendTabEol( "property [" );

		writer2.appendTab2Eol( "solver = 'CVC4'" );
		writer2.appendTab2Eol( "format = 'BASIC'" );
		writer2.appendTab2Eol( "info#selection = 'ALL'" );
		writer2.appendTab2Eol( "data#selection = 'MODIFIED'" );

		writer2.appendTab2( "normalize = " )
			.appendEol( isEnabledNormalization() );

		writer2.appendTab2( "print#initial#values = " )
		.appendEol( isEnabledInitialValuesPrinting() );

		writer2.appendTab2( "print#lifelines = " )
		.appendEol( isEnabledLifelinesPrinting() );

		writer2.appendTabEol( "] // end property" );

		TraceSpecificationCustomImpl format =
				(TraceSpecificationCustomImpl) getFormat();
		if( format != null ) {
			format.toWriter( writer2 );
		}

		TraceSpecificationCustomImpl trace =
				(TraceSpecificationCustomImpl) getTrace();
		if( trace != null ) {
			trace.toWriter(writer2);
		}


		String justifier = "";
		String path;
		writer2.appendTabEol( "vfs [" );
		if( (path = getFolderName()) != null ) {
			writer2.appendTab2( "folder = \"" )
				.append( path ).appendEol( "\"" );

			justifier = "  ";
		}
		if( (path = getFileName()) != null ) {
			writer2.appendTab2( "file" ).append(justifier)
				.append( " = \"" ).append( path ).appendEol( "\"" );
		}
		writer2.appendTabEol( "] // end vfs" );

		writer.appendTabEol( "}" );
	}

}
