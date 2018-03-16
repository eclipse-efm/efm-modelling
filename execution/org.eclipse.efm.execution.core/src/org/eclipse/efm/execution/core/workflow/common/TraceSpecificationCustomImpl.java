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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.common.impl.TraceSpecificationImpl;

public class TraceSpecificationCustomImpl extends TraceSpecificationImpl {

	public static final String TRACE_SEPARATOR = "\\R|;";


	protected TraceSpecificationCustomImpl(String name) {
		super();

		setName(name);
	}

	public TraceSpecificationCustomImpl(List<TraceElement> traceElements) {
		getElement().addAll(traceElements);
	}


	public static TraceSpecificationCustomImpl create(String name) {
		return( new TraceSpecificationCustomImpl(name) ) ;
	}

	public static TraceSpecificationCustomImpl create(String name,
			ILaunchConfiguration configuration, String storeKey,
			List<String> defaultValue, TraceElementKind defaultNature) {
		List<String> traceElementList = new ArrayList<String>();
		try {
			traceElementList.addAll(
					configuration.getAttribute(storeKey, defaultValue) );
		}
		catch( DebugException de) {
			// For Compatibility
			try {
				String specification =
						configuration.getAttribute(storeKey, "");

				if( specification != null ) {
					specification = specification.trim();

					if( ! specification.isEmpty() ) {
						String[] tabString = specification.split(
								TraceSpecificationCustomImpl.TRACE_SEPARATOR);

						traceElementList.addAll( Arrays.asList(tabString) );
					}
				}
			}
			catch( CoreException ce ) {
				ce.printStackTrace();
			}
		}
		catch( CoreException ce ) {
			ce.printStackTrace();
		}

		return create(name, traceElementList, defaultNature);
	}


	public static TraceSpecificationCustomImpl create(
			String name, ILaunchConfiguration configuration,
			String storeKey, TraceElementKind defaultNature)
	{
		return create(name, configuration, storeKey,
				new ArrayList<String>(), defaultNature);
	}


	public static TraceSpecificationCustomImpl create(String name,
			Collection<String> traceElementList, TraceElementKind defaultNature) {
		TraceSpecificationCustomImpl traceSpecification =
				new TraceSpecificationCustomImpl(name);

		if( (traceElementList != null) && (! traceElementList.isEmpty()) ) {

			traceSpecification.parseAll(traceElementList, defaultNature);

			return traceSpecification;
		}

		return traceSpecification;
	}


//	public static TraceSpecificationCustomImpl create(
//			String name, String specification, TraceElementKind defaultNature) {
//
//		TraceSpecificationCustomImpl trace =
//				new TraceSpecificationCustomImpl(name);
//
//		trace.parseAll( specification , defaultNature );
//
//		return( trace );
//	}
//
//
//	public void parseAll(String specification) {
//		parseAll(specification, TraceElementKind.UNDEFINED);
//	}

	public void parseAll(Collection<String> specification,
			TraceElementKind defaultNature) {

		if( (specification == null) || specification.isEmpty() ) {
			return;
		}

		List< TraceElement > elements = getElement();

		TraceElementCustomImpl traceElt;

		for (String eltString : specification) {
			eltString = eltString.trim();

			if ( eltString.length() > 0 ) {
				traceElt = TraceElementCustomImpl.create(
						eltString, defaultNature);
				if( traceElt != null ) {
					elements.add( traceElt );
				}
			}
		}
	}


	public String toSEW() {
		StringBuffer strBuffer = new StringBuffer();

		for( TraceElement element : getElement() ) {
			if( element instanceof TraceElementCustomImpl ) {
				strBuffer.append( ((TraceElementCustomImpl)element).toSEW() );
			}
			else {
				strBuffer.append( new TraceElementCustomImpl(element.isSelected(),
						element.getNature(), element.getValue()).toSEW() );
			}
		}

		return strBuffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer strBuffer = new StringBuffer();

		String name = getName();
		if( name == null ) {
			name = "trace";
		}

		strBuffer.append( name ).append(" [\n");

		for( TraceElement element : getElement() ) {
			strBuffer.append('\t');

			if( element instanceof TraceElementCustomImpl ) {
				strBuffer.append( ((TraceElementCustomImpl)element).toString() );
			}
			else {
				strBuffer.append( new TraceElementCustomImpl(element.isSelected(),
						element.getNature(), element.getValue()).toString() );
			}
		}

		strBuffer.append( "] // end ").append(name).append('\n');

		return strBuffer.toString();
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
				TraceElementCustomImpl customElement =
						new TraceElementCustomImpl(element.isSelected(),
								element.getNature(), element.getValue() );
				customElement.toWriter(writer2);
			}
		}

		writer.appendTab( "] // end ").appendEol(name);
	}

}
