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
package org.eclipse.efm.runconfiguration.workflow.common;

import org.eclipse.efm.runconfiguration.workflow.common.impl.TraceSpecificationImpl;
import org.eclipse.efm.runconfiguration.workflow.util.PrettyPrintWriter;
import org.eclipse.emf.common.util.EList;

public class TraceSpecificationCustomImpl extends TraceSpecificationImpl {



	public TraceSpecificationCustomImpl(String name) {
		super();

		setName(name);
	}

	public static TraceSpecificationCustomImpl create(String name) {
		return( new TraceSpecificationCustomImpl(name) ) ;
	}

	public static TraceSpecificationCustomImpl create(
			String name, String specification) {

		TraceSpecificationCustomImpl trace =
				new TraceSpecificationCustomImpl(name);

		trace.parseAll( specification );

		return( trace );
	}


	public void parseAll(String specification) {
		parseAll(specification, TraceElementKind.UNDEFINED);
	}

	public void parseAll(String specification,
			TraceElementKind defaultNature) {

		if( specification == null ) {
			return;
		}
		else {
			specification = specification.trim();

			if( specification.isEmpty() ) {
				return;
			}
		}

		String[] tabString = specification.split("\\R|;");

		EList< TraceElement > elements = getElement();

		TraceElementCustomImpl traceElt;

		for (String eltString : tabString) {
			eltString = eltString.trim();

			if ( eltString.length() == 0 ) {
			}
			else  {
				traceElt = TraceElementCustomImpl.create(
						eltString, defaultNature);
				if( traceElt != null ) {
					elements.add( traceElt );
				}
			}
		}
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.commentLine( getComment() );

		writer.appendTab();

		String name = getName();
		if( name == null ) {
			name = "trace";
		}
		writer.append( name );

		String str = getDescription();
		if( str != null ) {
			writer.append( " \'" ).append( str ).append( "\'" );
		}
		writer.appendEol(" [");

		PrettyPrintWriter writer2 = writer.itab2();

		for( TraceElement element : getElement() ) {
			if( element instanceof TraceElementCustomImpl ) {
				((TraceElementCustomImpl)element).toWriter(writer2);
			}
			else {
				writer.appendTab2( element.getNature().getLiteral() )
					.append( " = " )
					.appendEol( (element.getValue() != null) ?
							element.getValue().toString() : "'<null>'" );
			}
		}

		writer.appendTab( "] // end ").appendEol(name);
	}

}
