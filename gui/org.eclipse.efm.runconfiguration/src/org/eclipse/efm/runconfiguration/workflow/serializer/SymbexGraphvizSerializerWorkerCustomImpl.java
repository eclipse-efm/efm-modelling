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
package org.eclipse.efm.runconfiguration.workflow.serializer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.runconfiguration.workflow.Director;
import org.eclipse.efm.runconfiguration.workflow.IWorkflowConfigurationConstants;
import org.eclipse.efm.runconfiguration.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.runconfiguration.workflow.serializer.impl.ModelGraphvizSerializerWorkerImpl;
import org.eclipse.efm.runconfiguration.workflow.util.PrettyPrintWriter;

public class SymbexGraphvizSerializerWorkerCustomImpl extends ModelGraphvizSerializerWorkerImpl
		implements IWorkflowConfigurationConstants {

	public SymbexGraphvizSerializerWorkerCustomImpl(
			Director director, String name) {
		super();

		setDirector(director);
		setName(name);
	}

	public SymbexGraphvizSerializerWorkerCustomImpl(
			Director director, String name, String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static SymbexGraphvizSerializerWorkerCustomImpl create(
			Director director, ILaunchConfiguration configuration) {

		SymbexGraphvizSerializerWorkerCustomImpl serializerWorker =
				new SymbexGraphvizSerializerWorkerCustomImpl(
						director, "symbex2graphiz");

//		serializerWorker.setManifest( ManifestCustomImpl.create(true) );


		String strFormat;
		try {
			strFormat = configuration.getAttribute(
					ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
					DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strFormat = DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC;
		}
		if( (strFormat != null) && (! strFormat.isEmpty()) ) {
			TraceSpecificationCustomImpl format =
					TraceSpecificationCustomImpl.create("format", strFormat);

			serializerWorker.setFormat( format );
		}

		String strTrace;
		try {
			strTrace = configuration.getAttribute(
					ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
					DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strTrace = DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC;
		}
		if( (strTrace != null) && (! strTrace.isEmpty()) ) {
			TraceSpecificationCustomImpl trace =
					TraceSpecificationCustomImpl.create("trace", strTrace);

			serializerWorker.setTrace( trace );
		}

		String strFilename;
		try {
			strFilename = configuration.getAttribute(
					ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME,
					DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strFilename = DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME;
		}
		serializerWorker.setFileName( strFilename );

		return( serializerWorker );
	}


	public static SymbexGraphvizSerializerWorkerCustomImpl createSecond(
			Director director, ILaunchConfiguration configuration) {

		SymbexGraphvizSerializerWorkerCustomImpl serializerWorker =
				new SymbexGraphvizSerializerWorkerCustomImpl(
						director, "symbex2graphiz#extension");

//		serializerWorker.setManifest( ManifestCustomImpl.create(true) );

		String strFormat;
		try {
			strFormat = configuration.getAttribute(
					ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
					DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strFormat = DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC;
		}
		if( (strFormat != null) && (! strFormat.isEmpty()) ) {
			TraceSpecificationCustomImpl format =
					TraceSpecificationCustomImpl.create("format", strFormat);

			serializerWorker.setFormat( format );
		}

		String strTrace;
		try {
			strTrace = configuration.getAttribute(
					ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
					DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strTrace = DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC;
		}
		if( (strTrace != null) && (! strTrace.isEmpty()) ) {
			TraceSpecificationCustomImpl trace =
					TraceSpecificationCustomImpl.create("trace", strTrace);

			serializerWorker.setTrace( trace );
		}

		String strFilename;
		try {
			strFilename = configuration.getAttribute(
					ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME,
					DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			strFilename = DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME;
		}
		serializerWorker.setFileName( strFilename );

		return( serializerWorker );
	}



	public void toWriter(PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "serializer#symbex#graphviz" );

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
		writer2.appendTab2Eol( "info#selection = 'ALL'" );
		writer2.appendTab2Eol( "data#selection = 'MODIFIED'" );
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
