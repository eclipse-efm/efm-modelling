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
package org.eclipse.efm.sew.xtext.converter;

import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

public class AtIdentifierValueConverter extends Ecore2XtextTerminalConverters {

	@ValueConverter(rule = "AT_IDENTIFIER")
	public IValueConverter<String> PROPERTY_ID() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			public String internalToValue(String string, INode  node)  {
				if( string.charAt(0) == '@' ) {
					return( string.substring(1) );
				} else {
					return( string );
				}
			}
			@Override
			public String internalToString(String value) {
				if( (value != null) && (value.charAt(0) != '@') ) {
					return( "@" + value );
				} else {
					return( value );
				}
			}
		};
	}
}
