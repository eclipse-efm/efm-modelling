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

import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Control;

public interface ILaunchConfigurationEditorComposite {
	
	public void propagateMessage(String message);

	public void propagateWarningMessage(String warningmessage);
	
	public void propagateErrorMessage(String errormessage);
	
	public void propagateGUIupdate();
	
	public void propagateVisibility(Control smp, boolean isVisible);
	
	public void propagateUpdateJobScheduling();
	
	public Map<String, Action> getRunnableActions();
}
