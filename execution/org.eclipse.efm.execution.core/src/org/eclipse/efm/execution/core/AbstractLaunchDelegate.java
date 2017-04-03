/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/

package org.eclipse.efm.execution.core;

import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;


public abstract class AbstractLaunchDelegate
		implements ILaunchConfigurationDelegate, IWorkflowConfigurationConstants {

	////////////////////////////////////////////////////////////////////////////
	// DEVELOPER OPTIONS
	////////////////////////////////////////////////////////////////////////////

	public final static boolean ENABLED_SYMBEX_DEVELOPER_MODE_OPTION = true;

	public final static boolean ENABLED_SYMBEX_INCUBATION_MODE_OPTION = true;

	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
}
