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
package org.eclipse.efm.core.workflow.common;

import org.eclipse.efm.core.workflow.common.ConsoleVerbosityKind;
import org.eclipse.efm.core.workflow.common.impl.ConsoleLogFormatImpl;
import org.eclipse.efm.core.workflow.util.PrettyPrintWriter;

public class ConsoleLogFormatCustomImpl extends ConsoleLogFormatImpl {

	public ConsoleLogFormatCustomImpl() {
		super();
	}


	public static ConsoleLogFormatCustomImpl create(String format) {
		ConsoleLogFormatCustomImpl console = new ConsoleLogFormatCustomImpl();

		// The Default formatter...
		console.setFormat( format );

		return( console );
	}

	public static ConsoleLogFormatCustomImpl create(String format, String report) {
		ConsoleLogFormatCustomImpl console = new ConsoleLogFormatCustomImpl();

		// The Default formatter...
		console.setFormat( format );
		console.setReport( report );

		return( console );
	}

//	public static ConsoleLogFormatCustomImpl create(
//			String bound, String step, String result, String report) {
//
//		ConsoleLogFormatCustomImpl console = new ConsoleLogFormatCustomImpl();
//
//		console.setBound ( bound );
//		console.setStep  ( step );
//		console.setResult( result );
//		console.setReport( report );
//
//		return( console );
//	}

	public static ConsoleLogFormatCustomImpl create(ConsoleVerbosityKind verbosity) {

		ConsoleLogFormatCustomImpl console = new ConsoleLogFormatCustomImpl();

		console.setVerbosity( verbosity );

		return( console );
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.appendTabEol("console [");

		String str;

		// The Default formatter...
		if( (str = getFormat()) != null ) {
			writer.appendTab2( "format = \"" ).append( str ).appendEol( "\"" );
		}

		if( (str = getBound()) != null ) {
			writer.appendTab2( "bound  = \"" ).append( str ).appendEol( "\"" );
		}
		if( (str = getStep()) != null ) {
			writer.appendTab2( "step   = \"" ).append( str ).appendEol( "\"" );
		}
		if( (str = getResult()) != null ) {
			writer.appendTab2( "result = \"" ).append( str ).appendEol( "\"" );
		}
		if( (str = getReport()) != null ) {
			writer.appendTab2( "report = \"" ).append( str ).appendEol( "\"" );
		}

		ConsoleVerbosityKind verbose = getVerbosity();
		if( (verbose != null) && (verbose != ConsoleVerbosityKind.UNDEFINED) ) {
			writer.appendTab2( "verbose = \'" )
				.append( verbose.getLiteral() ).appendEol( "\'" );
		}

		writer.appendTabEol( "] // end console" );
	}

}
