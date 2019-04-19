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

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphicSerializerWorkerImpl;

public class ModelGraphicSerializerWorkerCustomImpl
		extends ModelGraphicSerializerWorkerImpl
		implements IWorkflowConfigurationConstants {

	protected ModelGraphicSerializerWorkerCustomImpl(
			final Director director, final String name) {
		super();

		setDirector(director);
		setName(name);
	}

	protected ModelGraphicSerializerWorkerCustomImpl(
			final Director director, final String name, final String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static ModelGraphicSerializerWorkerCustomImpl create(
			final Director director, final ILaunchConfiguration configuration) {

		final ModelGraphicSerializerWorkerCustomImpl serializerWorker =
				new ModelGraphicSerializerWorkerCustomImpl(
						director, "model2graphic");

//		serializerWorker.setManifest( ManifestCustomImpl.create(true) );


//		TraceSpecificationCustomImpl format =
//				TraceSpecificationCustomImpl.create("format");
//
//		serializerWorker.setFormat( format );

		final String modelFilename = WorkflowFileUtils.getModelBasename(configuration);

		serializerWorker.setFileName(modelFilename + ".puml");

		return( serializerWorker );
	}


	public void toWriter(final PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "serializer#model#graphic" );

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

		writer2.appendTabEol( "statemachine [" );
		writer2.appendTab2Eol( "transition = true" );
		writer2.appendTabEol( "] // end property" );

		writer2.appendTabEol( "transition [" );
		writer2.appendTab2Eol( "statement = true" );
		writer2.appendTabEol( "] // end property" );

		writer2.appendTabEol( "statement [" );
		writer2.appendTab2Eol( "statement = true" );
		writer2.appendTabEol( "] // end property" );


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
