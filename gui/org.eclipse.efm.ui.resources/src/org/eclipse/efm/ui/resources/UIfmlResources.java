/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.ui.resources;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;

public class UIfmlResources {
	
	private static final String PLUGINS_ROOT = "platform:/plugin/";
	
	public static final String RESOURCES_PLUGIN_ID = "org.eclipse.efm.ui.resources";
	
	private static final String RESOURCES_PLUGIN_PATH = PLUGINS_ROOT + RESOURCES_PLUGIN_ID;
	
	public static final String FML_PROFILE_PATH = PLUGINS_ROOT + "org.eclipse.efm.formalml/resources/profile/FormalML.profile.uml";
	
	
	// Icons only below
	public static final String IMAGE__HELP_ICON = RESOURCES_PLUGIN_PATH + "/icons/help.png";
	public static final String IMAGE__DIVERSITY_ICON = RESOURCES_PLUGIN_PATH + "/icons/diversity_icon.png";
	public static final String IMAGE__REVERT_ICON = RESOURCES_PLUGIN_PATH + "/icons/revert.gif";
	public static final String IMAGE__PUSH_ICON = RESOURCES_PLUGIN_PATH + "/icons/push.png";
	public static final String IMAGE__LAUNCHDEBUG_ICON = RESOURCES_PLUGIN_PATH + "/icons/debug_exc.png";
	public static final String IMAGE__LAUNCHRUN_ICON = RESOURCES_PLUGIN_PATH + "/icons/run_exc.png";
	
	public static final String IMAGE__DIALDEBUG_ICON = RESOURCES_PLUGIN_PATH + "/icons/debug_dial.png";
	public static final String IMAGE__DIALRUN_ICON = RESOURCES_PLUGIN_PATH + "/icons/run_dial.png";
	
	// Helper/Util methods only below
	
	public static final ImageDescriptor getImageDescriptor(String imagePath) {
		ImageDescriptor image_descriptor = null;
		try {
			image_descriptor = ImageDescriptor.createFromURL(new URL(imagePath));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(image_descriptor);
	}
}
