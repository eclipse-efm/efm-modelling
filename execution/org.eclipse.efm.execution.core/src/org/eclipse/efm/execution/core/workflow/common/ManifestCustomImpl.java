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
import org.eclipse.efm.execution.core.workflow.common.impl.ManifestImpl;

public class ManifestCustomImpl extends ManifestImpl {

	public ManifestCustomImpl(boolean autoconf, boolean autostart) {
		super();

		setAutoconf(autoconf);
		setAutostart(autostart);
	}

	public ManifestCustomImpl(boolean autostart) {
		super();

		setAutostart(autostart);
	}


	public static ManifestCustomImpl create(boolean autoconf, boolean autostart) {
		ManifestCustomImpl manifest =
				new ManifestCustomImpl(autoconf, autostart);

		return( manifest );
	}

	public static ManifestCustomImpl create(boolean autostart) {
		ManifestCustomImpl manifest = new ManifestCustomImpl(autostart);

		return( manifest );
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.appendTabEol("manifest [");

		if( isAutoconf() ) {
			writer.appendTab2Eol( "autoconf  = true" );
		}
		if( isAutostart() ) {
			writer.appendTab2Eol( "autostart = true" );
		}

		writer.appendTabEol( "] // end manifest" );
	}

}
