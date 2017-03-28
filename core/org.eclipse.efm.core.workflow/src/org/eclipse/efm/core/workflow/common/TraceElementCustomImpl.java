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

import org.eclipse.efm.core.workflow.common.TraceElementKind;
import org.eclipse.efm.core.workflow.common.impl.TraceElementImpl;
import org.eclipse.efm.core.workflow.util.PrettyPrintWriter;

public class TraceElementCustomImpl extends TraceElementImpl {

	public TraceElementCustomImpl(TraceElementKind nature, Object value) {
		super();

		super.nature = nature;
		super.value = value;
	}


	public static TraceElementCustomImpl create(String element) {
		return( create(element, TraceElementKind.UNDEFINED) );
	}

	public static TraceElementCustomImpl create(
			String element, TraceElementKind defaultNature) {
		TraceElementKind nature = TraceElementKind.UNDEFINED;
		String value = element;

		String kind;
		int pos;

		if ( element.startsWith("//") ) {
			nature = TraceElementKind.UNDEFINED;

			value = element.substring(2).trim();
		}
		else if( (pos = element.indexOf('=')) > 0 ) {
			kind = element.substring(0, pos).trim();
			nature = TraceElementKind.get(kind);

			if( nature != null ) {
				value = element.substring(pos+1).trim();
			}
			else {
				nature = defaultNature;
			}
		}
		else {
			nature = defaultNature;
			value = element.trim();
		}

		return( new TraceElementCustomImpl(nature, value) );
	}


	public void toWriter(PrettyPrintWriter writer) {
		final Object value = getValue();

		if( getNature() == TraceElementKind.UNDEFINED ) {
			writer.commentLine( value );
		}
		else {
			writer.appendTab( getNature().getLiteral() ).append( " = " );
			if( value instanceof String ) {
				final String str = value.toString();
				if( (! str.startsWith("\"")) && (! str.startsWith("'")) ) {
					writer.append( "\"" ).append( str ).appendEol( "\"" );
				}
				else {
					writer.appendEol( str );
				}
			}
			else if( value != null ) {
				writer.appendEol( value.toString() );
			}
			else {
				writer.appendEol( "'<null>'" );

			}
		}
	}

}
