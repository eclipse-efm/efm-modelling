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

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.common.impl.ShellModeImpl;

public class ShellModeCustomImpl extends ShellModeImpl {

	protected ShellModeCustomImpl() {
		super();
	}


	public static ShellModeCustomImpl create(ILaunchConfiguration configuration) {
		ShellModeCustomImpl shellMode = new ShellModeCustomImpl();

		shellMode.setStop( "symbex.stop" );

		return( shellMode );
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.appendTabEol("shell [");

		String str;

		// The Default formatter...
		if( (str = getStop()) != null ) {
			writer.appendTab2Eol( "// Stop stop the current execution "
					+ "if it detects the creation of the above file !" );
			writer.appendTab2( "stop = \"" ).append( str ).appendEol( "\"" );
		}

		writer.appendTabEol( "] // end shell" );
	}

}
