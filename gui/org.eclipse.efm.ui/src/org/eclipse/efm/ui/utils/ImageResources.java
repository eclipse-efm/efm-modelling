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
package org.eclipse.efm.ui.utils;

import org.eclipse.efm.ui.Activator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ImageResources {
	
	private static final String PLUGINS_ROOT = "platform:/plugin/";
	
	public static final String PLUGIN_ID = "org.eclipse.efm.ui";
	
	private static final String RESOURCES_PLUGIN_PATH = PLUGINS_ROOT + PLUGIN_ID + "/resources/";
	
	
	public static final String FML_PROFILE_PATH = PLUGINS_ROOT +
			"org.eclipse.efm.formalml/resources/profile/FormalML.profile.uml";
	
	
	// Icons only below
	private static final String ICONS_PLUGIN_PATH = RESOURCES_PLUGIN_PATH + "icons/";
	
	
	public static final String IMAGE__HELP_ICON = ICONS_PLUGIN_PATH + "help.png";
	
	public static final String IMAGE__DIVERSITY_ICON = ICONS_PLUGIN_PATH + "diversity_icon.png";
	
	public static final String IMAGE__REVERT_ICON = ICONS_PLUGIN_PATH + "revert.gif";
	
	public static final String IMAGE__PUSH_ICON = ICONS_PLUGIN_PATH + "push.png";
	
	public static final String IMAGE__LAUNCHDEBUG_ICON = ICONS_PLUGIN_PATH + "debug_exc.png";
	
	public static final String IMAGE__LAUNCHRUN_ICON = ICONS_PLUGIN_PATH + "run_exc.png";
	
	
	
	public static final String IMAGE__DIALDEBUG_ICON = ICONS_PLUGIN_PATH + "debug_dial.png";
	
	public static final String IMAGE__DIALRUN_ICON = ICONS_PLUGIN_PATH + "run_dial.png";
	
	public static final String IMAGE__WARNING_ICON = ICONS_PLUGIN_PATH + "warning_st_obj.png";
	public static final String IMAGE__ERROR_ICON = ICONS_PLUGIN_PATH + "error_st_obj.gif";

	
	public static final String IMAGE__REFRESH_ICON = ICONS_PLUGIN_PATH + "refresh_tab.png";
	
	public static final String IMAGE__SYNCED_ICON = ICONS_PLUGIN_PATH + "synced.gif";

	
	// Helper/Util methods only below
	
	public static final ImageDescriptor getImageDescriptor(String imagePath) {
//		ImageDescriptor image_descriptor = null;
//		try {
//			image_descriptor = ImageDescriptor.createFromURL(new URL(imagePath));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		
//		return(image_descriptor);
		
		return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imagePath);

	}
}
