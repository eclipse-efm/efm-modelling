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
import org.eclipse.efm.execution.core.workflow.common.SolverKind;
import org.eclipse.efm.execution.core.workflow.common.TraceElementCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.impl.SequenceDiagramTraceSerializerImpl;

public class SequenceDiagramTraceSerializerWorkerCustomImpl
		extends SequenceDiagramTraceSerializerImpl
		implements IWorkflowConfigurationConstants {

	protected SequenceDiagramTraceSerializerWorkerCustomImpl(
			final Director director, final String name) {
		super();

		setDirector(director);
		setName(name);
	}

	protected SequenceDiagramTraceSerializerWorkerCustomImpl(
			final Director director, final String name, final String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static SequenceDiagramTraceSerializerWorkerCustomImpl create(
			final Director director, final ILaunchConfiguration configuration) {

		final SequenceDiagramTraceSerializerWorkerCustomImpl serializerWorker =
				new SequenceDiagramTraceSerializerWorkerCustomImpl(
						director, "sequence_diagram_trace_generator");

//		serializerWorker.setManifest( ManifestCustomImpl.create(true) );

		// Global Constraint Solver
		SolverKind constraintSolver = SolverKind.CVC4;
		try {
			constraintSolver = SolverKind.get(
					configuration.getAttribute(
							ATTR_SYMBEX_OPTION_CONSTRAINT_SOLVER,
							SolverKind.CVC4.getLiteral()) );
		}
		catch (final CoreException e) {
			e.printStackTrace();
		}

		if( constraintSolver == null ) {
			constraintSolver = SolverKind.CVC4;
		}
		serializerWorker.setSolver(constraintSolver);


		boolean enabled;

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ENABLED_NORMALIZATION, false);
		}
		catch( final CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		serializerWorker.setEnabledNormalization( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_ENABLED_NUMERIZATION, false);
		}
		catch( final CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		serializerWorker.setEnabledNumerization( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_INITIAL_VALUES_ENABLED_PRINTING, false);
		}
		catch( final CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		serializerWorker.setEnabledInitialValuesPrinting( enabled );

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_LIFELINES_ENABLED_PRINTING, false);
		}
		catch( final CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		serializerWorker.setEnabledLifelinesPrinting( enabled );

		final TraceSpecificationCustomImpl format =
				TraceSpecificationCustomImpl.create(
						"format", configuration,
						ATTR_SEQUENCE_DIAGRAM_TRACE_FORMAT_ELEMENT_LIST,
						DEFAULT_SEQUENCE_DIAGRAM_TRACE_FORMAT_ELEMENT_LIST,
						TraceElementKind.UNDEFINED);

		serializerWorker.setFormat( format );


		final TraceSpecificationCustomImpl trace = configureTrace(configuration);

		serializerWorker.setTrace( trace );


		String path;
		try {
			path = configuration.getAttribute(
					ATTR_BASIC_TRACE_FOLDER_NAME,
					DEFAULT_BASIC_TRACE_FOLDER_NAME);
		} catch( final CoreException e ) {
			e.printStackTrace();

			path = "basic";
		}
		serializerWorker.setFolderName( path );

		try {
			path = configuration.getAttribute(
					ATTR_BASIC_TRACE_FILE_NAME,
					DEFAULT_BASIC_TRACE_FILE_NAME);
			path = "sd_trace.puml";
		} catch( final CoreException e ) {
			e.printStackTrace();

			path = "sd_trace.puml";
		}
		serializerWorker.setFileName( path );

		return( serializerWorker );
	}


	private static TraceSpecificationCustomImpl configureTrace(
			final ILaunchConfiguration configuration) {

//		TraceSpecificationCustomImpl trace =
//				TraceSpecificationCustomImpl.create(
//						"trace", SYNTAX_TRACE_SPECIFICATION_LINK);

		final TraceSpecificationCustomImpl trace =
				TraceSpecificationCustomImpl.create(
						"trace", configuration,
						ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST,
						TraceElementKind.UNDEFINED);

		boolean enabled;

		try {
			enabled = configuration.getAttribute(
					ATTR_BASIC_TRACE_TIME_SELECTION, false);
		}
		catch( final CoreException e2 ) {
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
		catch( final CoreException e2 ) {
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
		catch( final CoreException e2 ) {
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
		catch( final CoreException e2 ) {
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
		catch( final CoreException e2 ) {
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
		catch( final CoreException e2 ) {
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
		catch( final CoreException e2 ) {
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
		catch( final CoreException e2 ) {
			e2.printStackTrace();

			enabled = false;
		}
		if( enabled ) {
			trace.getElement().add(
					new TraceElementCustomImpl(
							TraceElementKind.STATE, "[*]"));
		}

		return trace;
	}


	public void toWriter(final PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "serializer#symbex#trace#sequencediagram" );

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

		writer2.appendTab2( "solver = '" )
			.append(getSolver().getLiteral()).appendEol( "'" );
		writer2.appendTab2Eol( "format = 'SEQUENCE_DIAGRAM'" );
		writer2.appendTab2Eol( "info#selection = 'ALL'" );
		writer2.appendTab2Eol( "data#selection = 'MODIFIED'" );

		writer2.appendTab2( "numerizer = " ) // ~ | NONE | NEWFRESH
			.appendEol( isEnabledNumerization() ? "'SOLVER'" : "'NONE '" );

		writer2.appendTab2( "normalize = " )
			.appendEol( isEnabledNormalization() );

		writer2.appendTab2( "print#initial#values = " )
		.appendEol( isEnabledInitialValuesPrinting() );

		writer2.appendTab2( "print#lifelines = " )
		.appendEol( isEnabledLifelinesPrinting() );

		writer2.appendTab2Eol( "trace#count = 42" );
		writer2.appendTab2Eol( "one#trace#per#file = false" );
		writer2.appendTabEol( "] // end property" );

		final TraceSpecificationCustomImpl trace =
				(TraceSpecificationCustomImpl) getTrace();
		if( trace != null ) {
			trace.toWriter(writer2);
		}

		final TraceSpecificationCustomImpl format =
				(TraceSpecificationCustomImpl) getFormat();
		if( format != null ) {
			format.toWriter( writer2 );
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
