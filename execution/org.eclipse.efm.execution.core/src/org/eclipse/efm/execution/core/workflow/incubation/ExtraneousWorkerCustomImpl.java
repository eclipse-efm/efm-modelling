/**
 * Copyright (c) 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.execution.core.workflow.incubation;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.extraneous.impl.ExtraneousWorkerImpl;

public class ExtraneousWorkerCustomImpl extends ExtraneousWorkerImpl
		implements IWorkflowConfigurationConstants {

	public ExtraneousWorkerCustomImpl(String extraSEW) {
		this.extraSEW = extraSEW;
	}

	public static ExtraneousWorkerCustomImpl create(
			Director director, ILaunchConfiguration configuration) {

		String extraConfig;
		try {
			extraConfig = configuration.getAttribute(
					ATTR_OPAQUE_MODULE_TEXTUAL_CONFIGURATION, "");
		}
		catch( CoreException e ) {
			e.printStackTrace();

			extraConfig = null;
		}
		if( (extraConfig != null) && extraConfig.isEmpty() ) {
			extraConfig = null;
		}

		return( new ExtraneousWorkerCustomImpl(extraConfig) );
	}

	public void toWriter(PrettyPrintWriter writer) {
		final String extraConfiguration = getExtraSEW();

		if( extraConfiguration != null ) {
			final String[] lines = extraConfiguration.split("\n");
			for (String line : lines) {
				writer.appendTabEol(line);
			}
		}
	}

}
