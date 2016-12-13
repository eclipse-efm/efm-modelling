/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.runconfiguration.job;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.IWorkbenchWindow;

public class RunSewFactory {

	public static boolean run(IWorkbenchWindow window, String jobName,
			IFile sewFile, IResource selectedResource) {
		if( sewFile != null ) {
			try {
				SewJob job = new SewJob(window, jobName,
						sewFile, selectedResource);

				job.setUser(true);
				job.schedule();

				return( true );
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		return( false );
	}

	public static boolean run(IWorkbenchWindow window, IFile sewFile) {
		return run(window, "Symbolic Execution Workflow job", sewFile, sewFile);
	}
}
