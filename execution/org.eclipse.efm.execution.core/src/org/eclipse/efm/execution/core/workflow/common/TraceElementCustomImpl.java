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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.common.impl.TraceElementImpl;

public class TraceElementCustomImpl extends TraceElementImpl {

	private static final String ATTRIBUTE_VALUE_GRAMMAR = "(\\S+)[=\\s]+(\\S.+)";

	private static final String UNSELECTION_MARKER = "//!#";

	public static final String ELEMENT_SEPARATOR = "\\R|;";


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


	public static TraceElementCustomImpl create(
			String element, TraceElementKind defaultNature) {
		boolean selected = true;
		TraceElementKind nature = TraceElementKind.UNDEFINED;

		while ( element.startsWith(UNSELECTION_MARKER) ) {
			selected = false;

			element = element.substring(UNSELECTION_MARKER.length()).trim();
		}

		String value = element;
		if ( element.startsWith("//") ) {
			nature = TraceElementKind.TIPS;

			value = value.substring(2).trim();
		}
		else {
			Pattern pattern = Pattern.compile(ATTRIBUTE_VALUE_GRAMMAR);
			Matcher matcher = pattern.matcher(element);

			if( matcher.find() ) {
				String kind = matcher.group(1).trim();
				nature = TraceElementKind.get(kind);

				if( nature != null ) {
					value = matcher.group(2).trim();
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
			case CONDITION:
			case DECISION:
			case FORMULA: {
				strBuffer.append( getNature().getLiteral() ).append( " = " );

				if( value instanceof String ) {
					final String str = value.toString();
					if( str.startsWith("(") ) {
						strBuffer.append( value.toString() );
					}
					else {
						strBuffer.append('(').append( value.toString() ).append(')');
					}
				}
				else {
					strBuffer.append( value.toString() );
				}

				strBuffer.append('\n');
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

			case CONDITION:
			case DECISION:
			case FORMULA: {
				writer.append( getNature().getLiteral() ).append( " = " );

				if( value instanceof String ) {
					final String str = value.toString();
					if( str.startsWith("(") ) {
						writer.appendEol( value.toString() );
					}
					else {
						writer.append('(').append( value.toString() ).appendEol(')');
					}
				}
				else {
					writer.appendEol( value.toString() );
				}
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
