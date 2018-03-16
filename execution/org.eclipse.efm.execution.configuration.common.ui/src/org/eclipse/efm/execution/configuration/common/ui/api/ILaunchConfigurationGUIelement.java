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

package org.eclipse.efm.execution.configuration.common.ui.api;

import org.eclipse.jface.util.PropertyChangeEvent;

public interface ILaunchConfigurationGUIelement {

	///////////////////////////////////////////////////////////////////////////
	// Widget Toolkit
	///////////////////////////////////////////////////////////////////////////

	public IWidgetToolkit getWidgetToolkit();

	public AbstractConfigurationPage[] getConfigurationPages();


	///////////////////////////////////////////////////////////////////////////
	// Message API
	///////////////////////////////////////////////////////////////////////////

	public void setMessage(String message);

	public void setWarningMessage(String warningmessage);

	public void setErrorMessage(String errormessage);

	public void clearErrorMessage();

	public void updateGUI();

	public void scheduleUpdateJob();

	///////////////////////////////////////////////////////////////////////////
	// Property Change
	public void handleConfigurationPropertyChange(PropertyChangeEvent event);



}
