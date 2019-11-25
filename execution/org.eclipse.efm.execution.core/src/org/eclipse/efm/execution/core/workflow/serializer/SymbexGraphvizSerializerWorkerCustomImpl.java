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
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphVizSerializerWorkerImpl;

public class SymbexGraphvizSerializerWorkerCustomImpl
		extends SymbexGraphVizSerializerWorkerImpl
		implements IWorkflowConfigurationConstants {

	protected SymbexGraphvizSerializerWorkerCustomImpl(
			final Director director, final String name) {
		super();

		setDirector(director);
		setName(name);
	}

	protected SymbexGraphvizSerializerWorkerCustomImpl(
			final Director director, final String name, final String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static SymbexGraphvizSerializerWorkerCustomImpl create(
			final Director director, final ILaunchConfiguration configuration) {

		final SymbexGraphvizSerializerWorkerCustomImpl serializerWorker =
				new SymbexGraphvizSerializerWorkerCustomImpl(
						director, "symbex2graphviz");

//		serializerWorker.setManifest( ManifestCustomImpl.create(true) );

		boolean enabled;
		try {
			enabled = configuration.getAttribute(
					ATTR_SYMBEX_OUTPUT_GRAPHVIZ_ENABLED_MODIFIED_DATA_SELECTION, true);
		}
		catch( final CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		serializerWorker.setEnabledModifiedDataSelection( enabled );



		final TraceSpecificationCustomImpl trace =
				TraceSpecificationCustomImpl.create(
						"trace", configuration,
						ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
						DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
						TraceElementKind.UNDEFINED);

		serializerWorker.setTrace( trace );


		final TraceSpecificationCustomImpl format =
				TraceSpecificationCustomImpl.create(
						"format", configuration,
						ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
						DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
						TraceElementKind.RAW_ATTRIBUTE);

		serializerWorker.setFormat( format );


		final TraceSpecificationCustomImpl css =
				TraceSpecificationCustomImpl.create(
						"css", configuration,
						ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_CSS_SPEC,
						DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_CSS_SPEC,
						TraceElementKind.RAW_ATTRIBUTE);

		serializerWorker.setCSS( css );


		String strFilename;
		try {
			strFilename = configuration.getAttribute(
					ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME,
					DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME);
		}
		catch( final CoreException e ) {
			e.printStackTrace();

			strFilename = DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME;
		}
		serializerWorker.setFileName( strFilename );

		return( serializerWorker );
	}


	public static SymbexGraphvizSerializerWorkerCustomImpl createSecond(
			final Director director, final ILaunchConfiguration configuration) {

		final SymbexGraphvizSerializerWorkerCustomImpl serializerWorker =
				new SymbexGraphvizSerializerWorkerCustomImpl(
						director, "symbex2graphiz#extension");

//		serializerWorker.setManifest( ManifestCustomImpl.create(true) );

		final TraceSpecificationCustomImpl trace =
				TraceSpecificationCustomImpl.create(
						"trace", configuration,
						ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
						DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
						TraceElementKind.UNDEFINED);

		serializerWorker.setTrace( trace );


		final TraceSpecificationCustomImpl format =
				TraceSpecificationCustomImpl.create(
						"format", configuration,
						ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
						DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
						TraceElementKind.RAW_ATTRIBUTE);

		serializerWorker.setFormat( format );

		final TraceSpecificationCustomImpl css =
				TraceSpecificationCustomImpl.create(
						"css", configuration,
						ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_CSS_SPEC,
						DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_CSS_SPEC,
						TraceElementKind.RAW_ATTRIBUTE);

		serializerWorker.setCSS( css );


		String strFilename;
		try {
			strFilename = configuration.getAttribute(
					ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME,
					DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME);
		}
		catch( final CoreException e ) {
			e.printStackTrace();

			strFilename = DEFAULT_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FILENAME;
		}
		serializerWorker.setFileName( strFilename );

		return( serializerWorker );
	}



	public void toWriter(final PrettyPrintWriter writer) {
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

		final PrettyPrintWriter writer2 = writer.itab2();

		final ManifestCustomImpl manifest = (ManifestCustomImpl) getManifest();
		if( manifest != null ) {
			manifest.toWriter(writer2);
		}

		writer2.appendTabEol( "property [" );
		writer2.appendTab2Eol( "info#selection = 'ALL'" );
		writer2.appendTab2( "data#selection = " )
			.appendEol( isEnabledModifiedDataSelection() ? "'MODIFIED'" : "'ALL'" );
		writer2.appendTabEol( "] // end property" );

		// Trace element selected
		final TraceSpecificationCustomImpl trace =
				(TraceSpecificationCustomImpl) getTrace();
		if( trace != null ) {
			trace.toWriter(writer2);
		}

		// Trace element formatter
		final TraceSpecificationCustomImpl format =
				(TraceSpecificationCustomImpl) getFormat();
		if( format != null ) {
			format.toWriter( writer2 );
		}

		// Graphviz node shape, color, ...
		final TraceSpecificationCustomImpl css =
				(TraceSpecificationCustomImpl) getCSS();
		if( css != null ) {
			css.toWriter( writer2 );
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
