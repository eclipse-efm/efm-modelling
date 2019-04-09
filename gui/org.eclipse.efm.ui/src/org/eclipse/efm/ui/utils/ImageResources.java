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
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ImageResources {

	private static final String PLUGINS_ROOT = "platform:/plugin/";

	public static final String PLUGIN_ID = "org.eclipse.efm.ui";

	private static final String RESOURCES_PLUGIN_PATH = PLUGINS_ROOT + PLUGIN_ID + "/resources/";


	public static final String FML_PROFILE_PATH = PLUGINS_ROOT +
			"org.eclipse.efm.formalml/resources/profile/FormalML.profile.uml";


	// Icons only below
	private static final String ICONS_PLUGIN_PATH = RESOURCES_PLUGIN_PATH + "icons/";

	private static final String ICONS_ELCL16_PLUGIN_PATH = RESOURCES_PLUGIN_PATH + "icons/elcl16/";

	private static final String ICONS_DLCL16_PLUGIN_PATH = RESOURCES_PLUGIN_PATH + "icons/dlcl16/";


	public static final String IMAGE__ADD_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "add.gif";


	public static final String IMAGE__DELETE_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "delete.png";

	public static final String IMAGE__DELETE_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "delete.png";


	public static final String IMAGE__INFO_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "info_obj.gif";

	public static final String IMAGE__QUICKASSIST_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "quickassist_obj.gif";


	public static final String IMAGE__LIST_ADD_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "list-add.gif";

	public static final String IMAGE__COPY_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "duplicate.png";

	public static final String IMAGE__LIST_EDIT_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "list-edit.gif";

	public static final String IMAGE__LIST_DELETE_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "list-delete.gif";

	public static final String IMAGE__LIST_MOVE_DOWN_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "list-movedown.gif";

	public static final String IMAGE__LIST_MOVE_UP_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "list-moveup.gif";


	public static final String IMAGE__LIST_ADD_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "list-add.gif";

	public static final String IMAGE__LIST_EDIT_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "list-edit.gif";

	public static final String IMAGE__LIST_DELETE_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "list-delete.gif";

	public static final String IMAGE__LIST_MOVE_DOWN_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "list-movedown.gif";

	public static final String IMAGE__LIST_MOVE_UP_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "list-moveup.gif";



	public static final String IMAGE__CHECKED_ICON = ICONS_ELCL16_PLUGIN_PATH + "checked.gif";

	public static final String IMAGE__UNCHECKED_ICON = ICONS_ELCL16_PLUGIN_PATH + "unchecked.gif";



	public static final String IMAGE__HELP_ICON = ICONS_PLUGIN_PATH + "help.png";

	public static final String IMAGE__DIVERSITY_ICON = ICONS_PLUGIN_PATH + "diversity_icon.png";

	public static final String IMAGE__REVERT_ICON = ICONS_PLUGIN_PATH + "revert.gif";

	public static final String IMAGE__PUSH_ICON = ICONS_PLUGIN_PATH + "push.png";


	public static final String IMAGE__SAVE_ICON = ICONS_PLUGIN_PATH + "save.gif";

	public static final String IMAGE__SAVE_AS_ICON = ICONS_PLUGIN_PATH + "save_as.gis";


	public static final String IMAGE__DEBUG_EXEC_ICON = ICONS_PLUGIN_PATH + "debug_exc.png";

	public static final String IMAGE__RUN_EXEC_ICON = ICONS_PLUGIN_PATH + "run_exc.png";


	public static final String IMAGE__DIALDEBUG_ICON = ICONS_PLUGIN_PATH + "debug_dial.png";

	public static final String IMAGE__DIALRUN_ICON = ICONS_PLUGIN_PATH + "run_dial.png";


	public static final String IMAGE__WARNING_ICON = ICONS_PLUGIN_PATH + "warning_st_obj.png";
	public static final String IMAGE__ERROR_ICON = ICONS_PLUGIN_PATH + "error_st_obj.gif";

	public static final String IMAGE__PINNED_OVR_ICON = ICONS_PLUGIN_PATH + "pinned_ovr.gif";


	public static final String IMAGE__REFRESH_ICON = ICONS_PLUGIN_PATH + "refresh_tab.png";

	public static final String IMAGE__SYNCED_ICON = ICONS_PLUGIN_PATH + "synced.gif";

	public static final String IMAGE__VALIDATE_ICON = ICONS_PLUGIN_PATH + "validate.gif";


	public static final String IMAGE__RESTART_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "restart_co.png";
	public static final String IMAGE__RESTART_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "restart_co.png";

	public static final String IMAGE__RESUME_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "resume_co.png";
	public static final String IMAGE__RESUME_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "resume_co.png";

	public static final String IMAGE__RUNLAST_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "runlast_co.png";
	public static final String IMAGE__RUNLAST_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "runlast_co.png";

	public static final String IMAGE__REMOVE_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "rem_co.png";
	public static final String IMAGE__REMOVE_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "rem_co.png";

	public static final String IMAGE__REMOVE_ALL_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "rem_all_co.png";
	public static final String IMAGE__REMOVE_ALL_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "rem_all_co.png";

	public static final String IMAGE__TERMINATE_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "terminate_co.png";
	public static final String IMAGE__TERMINATE_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "terminate_co.png";

	public static final String IMAGE__TERMINATE_ALL_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "terminate_all_co.png";
	public static final String IMAGE__TERMINATE_ALL_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "terminate_all_co.png";

	public static final String IMAGE__TERMINATE_RESTART_ELCL16_ICON = ICONS_ELCL16_PLUGIN_PATH + "term_restart.png";
	public static final String IMAGE__TERMINATE_RESTART_DLCL16_ICON = ICONS_DLCL16_PLUGIN_PATH + "term_restart.png";




	// Helper/Util methods only below

	public static final ImageDescriptor getImageDescriptor(final String imagePath) {
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

	public static final Image getImage(final String imagePath) {
		return getImageDescriptor(imagePath).createImage();
	}

}
