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
package org.eclipse.efm.execution.launchconfiguration.handlers;

import org.eclipse.core.resources.IFile;

public class Util {

	/**
	 * isWorkflowFile
	 * @param aFile
	 * @return
	 */
	public static boolean isWorkflowFile(final IFile aFile) {
		if( aFile != null ) {
			final String extension = aFile.getFileExtension();
			if( extension != null ) {
				return( extension.endsWith("sew")
					|| extension.endsWith("favm") );
			}
		}

		return false;
	}


	/**
	 * isGraphizFile
	 * @param aFile
	 * @return
	 */
	public static boolean isGraphizFile(final IFile aFile) {
		if( aFile != null ) {
			final String extension = aFile.getFileExtension();
			if( extension != null ) {
				return( extension.endsWith("gv") );
			}
		}

		return false;
	}

}
