/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - Initial API and implementation
 *******************************************************************************/

package org.eclipse.efm.execution.ui.views.utils;

import org.eclipse.ui.forms.widgets.FormToolkit;

public abstract class AbstractLaunchConfigurationGUIelement implements ILaunchConfigurationGUIelement {
	
	protected FormToolkit toolkit;
	
	@Override
	public FormToolkit getFormToolkit() {
		return toolkit;
	}	
	
}
