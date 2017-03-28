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
package org.eclipse.efm.core.workflow.serializer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.core.workflow.IWorkflowConfigurationConstants;
import org.eclipse.efm.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.core.workflow.Director;
import org.eclipse.efm.core.workflow.serializer.impl.TTCNTraceSerializerImpl;
import org.eclipse.efm.core.workflow.util.PrettyPrintWriter;

public class TTCNTraceSerializerWorkerCustomImpl extends TTCNTraceSerializerImpl
		implements IWorkflowConfigurationConstants {

	public TTCNTraceSerializerWorkerCustomImpl(
			Director director, String name) {
		super();

		setDirector(director);
		setName(name);
	}

	public TTCNTraceSerializerWorkerCustomImpl(
			Director director, String name, String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public static TTCNTraceSerializerWorkerCustomImpl create(
			Director director, ILaunchConfiguration configuration) {

		TTCNTraceSerializerWorkerCustomImpl serializerWorker =
				new TTCNTraceSerializerWorkerCustomImpl(
						director, "TTCN_trace_generator");

//		serializerWorker.setManifest( ManifestCustomImpl.create(true) );


//		TraceSpecificationCustomImpl format =
//				TraceSpecificationCustomImpl.create(
//						"format", DEFAULT_FORMAT_SPECIFICATION);
//
//		serializerWorker.setFormat( format );
//
//
		String specification = DEFAULT_TTCN_TRACE_SPECIFICATION;

//		try {
//			specification = configuration.getAttribute(
//					ATTR_TTCN_TRACE_SPECIFICATION,
//					DEFAULT_TTCN_TRACE_SPECIFICATION);
//		}
//		catch( CoreException e ) {
//			e.printStackTrace();
//
//			specification = DEFAULT_TTCN_TRACE_SPECIFICATION;
//		}

		if( (specification != null) && (! specification.isEmpty()) ) {
			TraceSpecificationCustomImpl trace =
					TraceSpecificationCustomImpl.create("trace", specification);

			serializerWorker.setTrace( trace );
		}


		String str;
		try {
			str = configuration.getAttribute(
					ATTR_TTCN_FOLDER_NAME, DEFAULT_TTCN_FOLDER_NAME);
		} catch( CoreException e ) {
			e.printStackTrace();

			str = DEFAULT_TTCN_FOLDER_NAME;
		}
		serializerWorker.setFolderName( str );

		boolean enabledCustomization;
		try {
			enabledCustomization = configuration.getAttribute(
					ATTR_TTCN_ENABLED_CUSTOMIZATION,
					DEFAULT_TTCN_ENABLED_CUSTOMIZATION);
		} catch( CoreException e ) {
			e.printStackTrace();

			enabledCustomization = DEFAULT_TTCN_ENABLED_CUSTOMIZATION;
		}

		serializerWorker.setEnabledCustomization( enabledCustomization );
		serializerWorker.setEnabledAdapters( enabledCustomization );

		if( enabledCustomization ) {
			// Module Control
			try {
				str = configuration.getAttribute(
						ATTR_TTCN_CONTROL_MODULE_NAME,
						DEFAULT_TTCN_CONTROL_MODULE_NAME);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_CONTROL_MODULE_NAME;
			}
			serializerWorker.setControlModuleName( str );

			// Module Declarations
			try {
				str = configuration.getAttribute(
						ATTR_TTCN_DECLARATIONS_MODULE_NAME,
						DEFAULT_TTCN_DECLARATIONS_MODULE_NAME);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_DECLARATIONS_MODULE_NAME;
			}
			serializerWorker.setDeclarationsModuleName( str );

			// Module Templates
			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TEMPLATES_MODULE_NAME,
						DEFAULT_TTCN_TEMPLATE_MODULE_NAME);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TEMPLATE_MODULE_NAME;
			}
			serializerWorker.setTemplatesModuleName( str );


			// Module Testcases
			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TESTCASES_MODULE_NAME,
						DEFAULT_TTCN_TESTCASES_MODULE_NAME);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TESTCASES_MODULE_NAME;
			}
			serializerWorker.setTestcasesModuleName( str );

			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TESTCASES_STARTING_WRAPPER,
						DEFAULT_TTCN_TESTCASES_STARTING_WRAPPER);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TESTCASES_STARTING_WRAPPER;
			}
			serializerWorker.setTestcasesStartingWrapper( str );

			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TESTCASES_ENDING_WRAPPER,
						DEFAULT_TTCN_TESTCASES_ENDING_WRAPPER);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TESTCASES_ENDING_WRAPPER;
			}
			serializerWorker.setTestcasesEndingWrapper( str );

			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TESTCASES_SENDING_WRAPPER,
						DEFAULT_TTCN_TESTCASES_SENDING_WRAPPER);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TESTCASES_SENDING_WRAPPER;
			}
			serializerWorker.setTestcasesSendingWrapper( str );

			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TESTCASES_RECEIVING_WRAPPER,
						DEFAULT_TTCN_TESTCASES_RECEIVING_WRAPPER);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TESTCASES_RECEIVING_WRAPPER;
			}
			serializerWorker.setTestcasesReceivingWrapper( str );


			// Module Adaptation
			try {
				str = configuration.getAttribute(
						ATTR_TTCN_ADAPTATION_MODULE_NAME,
						DEFAULT_TTCN_ADAPTATION_MODULE_NAME);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_ADAPTATION_MODULE_NAME;
			}
			serializerWorker.setAdaptationModuleName( str );

			try {
				str = configuration.getAttribute(
						ATTR_TTCN_ADAPTATION_UTILS_IMPL,
						DEFAULT_TTCN_ADAPTATION_UTILS_IMPL);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_ADAPTATION_UTILS_IMPL;
			}
			serializerWorker.setAdaptationUtilsImpl( str );

			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TESTCASES_STARTING_ENDING_IMPL,
						DEFAULT_TTCN_TESTCASES_STARTING_ENDING_IMPL);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TESTCASES_STARTING_ENDING_IMPL;
			}
			serializerWorker.setAdaptationStartingEndingImpl( str );

			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TESTCASES_SENDING_IMPL,
						DEFAULT_TTCN_TESTCASES_SENDING_IMPL);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TESTCASES_SENDING_IMPL;
			}
			serializerWorker.setAdaptationSendingImpl( str );

			try {
				str = configuration.getAttribute(
						ATTR_TTCN_TESTCASES_RECEIVING_IMPL,
						DEFAULT_TTCN_TESTCASES_RECEIVING_IMPL);
			} catch( CoreException e ) {
				e.printStackTrace();

				str = DEFAULT_TTCN_TESTCASES_RECEIVING_IMPL;
			}
			serializerWorker.setAdaptationReceivingImpl( str );
		}

		return( serializerWorker );
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab( "serializer#symbex#trace#ttcn" );

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

		if( isEnabledAdapters() ) {
			writer2.appendTab2Eol( "format = 'TTCN#TITAN'" );
		}
		else {
			writer2.appendTab2Eol( "format = 'TTCN#XLIA'" );
		}

//		writer2.appendTab2Eol( "info#selection = 'ALL'" );
//		writer2.appendTab2Eol( "data#selection = 'MODIFIED'" );

		writer2.appendTabEol( "] // end property" );

		writer2.appendTabEol( "format [" );

		if( (str = getControlModuleName()) != null ) {
			writer2.appendTab2( "control#module#name = \"" )
				.append( str ).appendEol( "\"" );
		}

		if( (str = getDeclarationsModuleName()) != null ) {
			writer2.appendTab2( "declarations#module#name = \"" )
				.append( str ).appendEol( "\"" );
		}

		if( (str = getTemplatesModuleName()) != null ) {
			writer2.appendTab2( "templates#module#name = \"" )
				.append( str ).appendEol( "\"" );
		}

		if( (str = getTestcasesModuleName()) != null ) {
			writer2.appendTab2( "testcases#module#name = \"" )
				.append( str ).appendEol( "\"" );
		}

		if( (str = getAdaptationModuleName()) != null ) {
			writer2.appendTab2( "adaptation#module#name = \"" )
				.append( str ).appendEol( "\"" );
		}

		writer2.appendTabEol( "] // end format" );


		writer2.appendTabEol( "wrapper [" );

		if( (str = getTestcasesStartingWrapper()) != null ) {
			writer2.appendTab2( "testcases#starting = \"" )
				.append( str ).appendEol( "\"" );
		}
		if( (str = getTestcasesEndingWrapper()) != null ) {
			writer2.appendTab2( "testcases#ending = \"" )
				.append( str ).appendEol( "\"" );
		}
		if( (str = getTestcasesSendingWrapper()) != null ) {
			writer2.appendTab2( "testcases#sending = \"" )
				.append( str ).appendEol( "\"" );
		}
		if( (str = getTestcasesReceivingWrapper()) != null ) {
			writer2.appendTab2( "testcases#receiving = \"" )
				.append( str ).appendEol( "\"" );
		}

		writer2.appendTabEol( "] // end wrapper" );


		writer2.appendTabEol( "implementation [" );

		if( (str = getAdaptationUtilsImpl()) != null ) {
			writer2.appendTab2( "adaptation#utils = " )
				.append( (str.startsWith("\t") && str.contains("\n")) ?
						"\n\"" : "\"" )
				.append( str ).appendEol( "\"" );
		}

		if( (str = getAdaptationStartingEndingImpl()) != null ) {
			writer2.appendTab2( "adaptation#starting#ending = " )
				.append( (str.startsWith("\t") && str.contains("\n")) ?
					"\n\"" : "\"" )
				.append( str ).appendEol( "\"" );
		}
		if( (str = getAdaptationSendingImpl()) != null ) {
			writer2.appendTab2( "adaptation#sending = " )
				.append( (str.startsWith("\t") && str.contains("\n")) ?
					"\n\"" : "\"" )
				.append( str ).appendEol( "\"" );
		}
		if( (str = getAdaptationReceivingImpl()) != null ) {
			writer2.appendTab2( "adaptation#receiving = " )
				.append( (str.startsWith("\t") && str.contains("\n")) ?
					"\n\"" : "\"" )
				.append( str ).appendEol( "\"" );
		}

		writer2.appendTabEol( "] // end implementation" );


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
		writer2.appendTabEol( "vfs [" );
		if( (str = getFolderName()) != null ) {
			writer2.appendTab2( "folder = \"" )
				.append( str ).appendEol( "\"" );

			justifier = "  ";
		}
		if( (str = getFileName()) != null ) {
			writer2.appendTab2( "file" ).append(justifier)
				.append( " = \"" ).append( str ).appendEol( "\"" );
		}
		writer2.appendTabEol( "] // end vfs" );

		writer.appendTabEol( "}" );
	}

}
