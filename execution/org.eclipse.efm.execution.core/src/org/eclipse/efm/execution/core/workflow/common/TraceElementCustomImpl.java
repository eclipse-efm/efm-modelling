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
package org.eclipse.efm.execution.core.workflow.common;

import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.common.impl.TraceElementImpl;

public class TraceElementCustomImpl extends TraceElementImpl {

	private static final String UNSELECTION_MARKER = "//!#";


	public TraceElementCustomImpl(boolean selected, TraceElementKind nature, Object value) {
		super();

		this.selected = selected;
		super.nature  = nature;
		super.value   = value;
	}

	public TraceElementCustomImpl(TraceElementKind nature, Object value) {
		this(true, nature, value);
	}

	public TraceElementCustomImpl(TraceElement model) {
		this(model.isSelected(), model.getNature(), model.getValue());
	}


	public static TraceElementCustomImpl create(String element) {
		return( create(element, TraceElementKind.UNDEFINED) );
	}

	public static TraceElementCustomImpl create(
			String element, TraceElementKind defaultNature) {
		boolean selected = true;
		TraceElementKind nature = TraceElementKind.UNDEFINED;

		String kind;
		int pos;

		while ( element.startsWith(UNSELECTION_MARKER) ) {
			selected = false;

			element = element.substring(UNSELECTION_MARKER.length()).trim();
		}

		String value = element;
		if ( element.startsWith("//") ) {
			nature = TraceElementKind.TIPS;

			value = value.substring(2).trim();
		}
		else if( (pos = element.indexOf('=')) > 0 ) {
			kind = element.substring(0, pos).trim();
			nature = TraceElementKind.get(kind);

			if( nature != null ) {
				value = element.substring(pos+1).trim();
				if( (! value.isEmpty())
					&& (value.charAt(0) == '\'')
					&& (value.charAt(value.length() - 1) == '\'') )
				{
					value = value.substring(1, value.length() - 1);
				}
			}
			else {
				nature = defaultNature;
			}
		}
		else {
			nature = defaultNature;
			value = element.trim();
		}

		return( new TraceElementCustomImpl(selected, nature, value) );
	}


	public String toSEW() {
//		return( (selected ? "+ " : "- " ) + nature + " = " + value );
		StringBuffer strBuffer = new StringBuffer();

		final Object value = getValue();

		if( ! isSelected() ) {
			strBuffer.append( UNSELECTION_MARKER );
		}

		switch( getNature() ) {
			case UNDEFINED: {
				for( String line : value.toString().split(" *\\R") ) {
					strBuffer.append( "// " ).append( line ).append('\n');
				}
				break;
			}
			case TIPS: {
				strBuffer.append("//").append( value.toString() ).append('\n');
				break;
			}
			case RAW_ATTRIBUTE: {
				strBuffer.append( value.toString() ).append('\n');
				break;
			}
			default: {
				strBuffer.append( getNature().getLiteral() ).append( " = " );

				if( value instanceof String ) {
					final String str = value.toString();
					if( (! str.startsWith("\"")) && (! str.startsWith("'"))
						&& ((! str.startsWith("[")) || str.startsWith("[*]")) )
					{
						strBuffer.append( "'" ).append( str ).append( "'" );
					}
					else {
						strBuffer.append( str );
					}
				}
				else if( value != null ) {
					strBuffer.append( value.toString() );
				}
				else {
					strBuffer.append( "'<null>'" );
				}

				strBuffer.append('\n');
				break;
			}
		}

		return strBuffer.toString();
	}

	@Override
	public String toString() {
		return toSEW();
	}


	public void toWriter(PrettyPrintWriter writer) {
		final Object value = getValue();

		writer.appendTab( isSelected() ? "" : UNSELECTION_MARKER );

		switch( getNature() ) {
			case UNDEFINED: {
				writer.commentLine( value );
				break;
			}
			case TIPS: {
				writer.append("//").appendEol( value.toString() );
				break;
			}
			case RAW_ATTRIBUTE: {
				writer.appendEol( value.toString() );
				break;
			}
			default: {
				writer.append( getNature().getLiteral() ).append( " = " );

				if( value instanceof String ) {
					final String str = value.toString();
					if( str.isEmpty() ) {
						writer.appendEol( "\"\"" );
					}
					else if( (! str.startsWith("\"")) && (! str.startsWith("'"))
							&& ((! str.startsWith("[")) || str.startsWith("[*]")) )
					{
						writer.append( "'" ).append( str ).appendEol( "'" );
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
				break;
			}
		}
	}

}
