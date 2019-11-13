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

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.efm.ui.Activator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class ImageResources {

	private static final String PLUGINS_ROOT = "platform:/plugin/";


	public static final String FML_PROFILE_PATH = PLUGINS_ROOT +
			"org.eclipse.efm.formalml/resources/profile/FormalML.profile.uml";


//	public static final String PLUGIN_ID = "org.eclipse.efm.ui";
//
//	private static final String RESOURCES_PLUGIN_PATH = PLUGINS_ROOT + PLUGIN_ID + "/resources/";

	public static final String IMG_ELCL16_ADD = "IMG_ELCL16_ADD";


	public static final String IMG_ELCL16_DELETE = "IMG_ELCL16_DELETE";

	public static final String IMG_DLCL16_DELETE = "IMG_DLCL16_DELETE";


	public static final String IMG_ELCL16_INFO = "IMG_ELCL16_INFO";

	public static final String IMG_ELCL16_QUICKASSIST = "IMG_ELCL16_QUICKASSIST";


	public static final String IMG_ELCL16_LIST_ADD = "IMG_ELCL16_LIST_ADD";

	public static final String IMG_ELCL16_COPY = "IMG_ELCL16_COPY";

	public static final String IMG_ELCL16_LIST_EDIT = "IMG_ELCL16_LIST_EDIT";

	public static final String IMG_ELCL16_LIST_DELETE = "IMG_ELCL16_LIST_DELETE";

	public static final String IMG_ELCL16_LIST_MOVE_DOWN = "IMG_ELCL16_LIST_MOVE_DOWN";

	public static final String IMG_ELCL16_LIST_MOVE_UP = "IMG_ELCL16_LIST_MOVE_UP";


	public static final String IMG_DLCL16_LIST_ADD = "IMG_DLCL16_LIST_ADD";

	public static final String IMG_DLCL16_LIST_EDIT = "IMG_DLCL16_LIST_EDIT";

	public static final String IMG_DLCL16_LIST_DELETE = "IMG_DLCL16_LIST_DELETE";

	public static final String IMG_DLCL16_LIST_MOVE_DOWN = "IMG_DLCL16_LIST_MOVE_DOWN";

	public static final String IMG_DLCL16_LIST_MOVE_UP = "IMG_DLCL16_LIST_MOVE_UP";



	public static final String IMG_ELCL16_CHECKED = "IMG_ELCL16_CHECKED";
	public static final String IMG_ELCL16_UNCHECKED = "IMG_ELCL16_UNCHECKED";


	public static final String IMG_ELCL16_PANE_RIGHT = "IMG_ELCL16_PANE_RIGHT";
	public static final String IMG_DLCL16_PANE_RIGHT = "IMG_DLCL16_PANE_RIGHT";

	public static final String IMG_ELCL16_PANE_UNDER = "IMG_ELCL16_PANE_UNDER";
	public static final String IMG_DLCL16_PANE_UNDER = "IMG_DLCL16_PANE_UNDER";



	public static final String IMG_ELCL16_HELP = "IMG_ELCL16_HELP";

	public static final String IMG_DIVERSITY = "IMG_DIVERSITY";

	public static final String IMG_ELCL16_REVERT = "IMG_ELCL16_REVERT";

	public static final String IMG_ELCL16_PUSH = "IMG_ELCL16_PUSH";


	public static final String IMG_ELCL16_SAVE = "IMG_ELCL16_SAVE";

	public static final String IMG_ELCL16_SAVE_AS = "IMG_ELCL16_SAVE_AS";


	public static final String IMG_ELCL16_DEBUG_EXEC = "IMG_ELCL16_DEBUG_EXEC";

	public static final String IMG_ELCL16_RUN_EXEC = "IMG_ELCL16_RUN_EXEC";


	public static final String IMG_ELCL16_DIAL_DEBUG = "IMG_ELCL16_DIAL_DEBUG";

	public static final String IMG_ELCL16_DIAL_RUN = "IMG_ELCL16_DIAL_RUN";


	public static final String IMG_ELCL16_WARNING = "IMG_ELCL16_WARNING";
	public static final String IMG_ELCL16_ERROR = "IMG_ELCL16_ERROR";

	public static final String IMG_ELCL16_PINNED_OVR = "IMG_ELCL16_PINNED_OVR";


	public static final String IMG_ELCL16_REFRESH = "IMG_ELCL16_REFRESH";

	public static final String IMG_ELCL16_SYNCED = "IMG_ELCL16_SYNCED";

	public static final String IMG_ELCL16_VALIDATE = "IMG_ELCL16_VALIDATE";


	public static final String IMG_ELCL16_PROFILE_EXEC = "IMG_ELCL16_PROFILE_EXEC";
	public static final String IMG_DLCL16_PROFILE_EXEC = "IMG_DLCL16_PROFILE_EXEC";

	public static final String IMG_ELCL16_RESTART = "IMG_ELCL16_RESTART";
	public static final String IMG_DLCL16_RESTART = "IMG_DLCL16_RESTART";

	public static final String IMG_ELCL16_RESUME = "IMG_ELCL16_RESUME";
	public static final String IMG_DLCL16_RESUME = "IMG_DLCL16_RESUME";

	public static final String IMG_ELCL16_RUNLAST = "IMG_ELCL16_RUNLAST";
	public static final String IMG_DLCL16_RUNLAST = "IMG_DLCL16_RUNLAST";

	public static final String IMG_ELCL16_REMOVE = "IMG_ELCL16_REMOVE";
	public static final String IMG_DLCL16_REMOVE = "IMG_DLCL16_REMOVE";

	public static final String IMG_ELCL16_REMOVE_ALL = "IMG_ELCL16_REMOVE_ALL";
	public static final String IMG_DLCL16_REMOVE_ALL = "IMG_DLCL16_REMOVE_ALL";

	public static final String IMG_ELCL16_TERMINATE = "IMG_ELCL16_TERMINATE";
	public static final String IMG_DLCL16_TERMINATE = "IMG_DLCL16_TERMINATE";

	public static final String IMG_ELCL16_TERMINATE_ALL = "IMG_ELCL16_TERMINATE_ALL";
	public static final String IMG_DLCL16_TERMINATE_ALL = "IMG_DLCL16_TERMINATE_ALL";

	public static final String IMG_ELCL16_TERMINATE_RESTART = "IMG_ELCL16_TERMINATE_RESTART";
	public static final String IMG_DLCL16_TERMINATE_RESTART = "IMG_DLCL16_TERMINATE_RESTART";


	/**
	 * The image registry containing <code>Image</code>s and the <code>ImageDescriptor</code>s.
	 */
	private static ImageRegistry imageRegistry;

	/* Declare Common paths */
	private static URL ICON_BASE_URL = null;

	static {
		final String pathSuffix = "resources/icons/"; //$NON-NLS-1$
		ICON_BASE_URL= Activator.getDefault().getBundle().getEntry(pathSuffix);
	}

	// Use IPath and toOSString to build the names to ensure they have the slashes correct
	private final static String DLCL     = "dlcl16/";  //disabled - size 16x16 //$NON-NLS-1$
	private final static String ELCL     = "elcl16/";  //enabled  - size 16x16 //$NON-NLS-1$
	private final static String BASE     = "./";       // others //$NON-NLS-1$

	/**
	 * Declare all images
	 */
	private static void declareImages() {
		// Actions

		//local toolbars

		// base toolbars
		declareRegistryImage(IMG_DIVERSITY , BASE + "diversity_icon.png");

		// disabled local toolbars
		declareRegistryImage(IMG_DLCL16_DELETE, DLCL + "delete.png");

		declareRegistryImage(IMG_DLCL16_LIST_ADD, DLCL + "list-add.gif");
		declareRegistryImage(IMG_DLCL16_LIST_EDIT, DLCL + "list-edit.gif");
		declareRegistryImage(IMG_DLCL16_LIST_DELETE, DLCL + "list-delete.gif");
		declareRegistryImage(IMG_DLCL16_LIST_MOVE_DOWN, DLCL + "list-movedown.gif");
		declareRegistryImage(IMG_DLCL16_LIST_MOVE_UP, DLCL + "list-moveup.gif");

		declareRegistryImage(IMG_DLCL16_PANE_RIGHT, DLCL + "det_pane_right.png");
		declareRegistryImage(IMG_DLCL16_PANE_UNDER, DLCL + "det_pane_under.png");

		declareRegistryImage(IMG_DLCL16_PROFILE_EXEC, DLCL + "profile_exc.png");
		declareRegistryImage(IMG_DLCL16_RESTART, DLCL + "restart_co.png");
		declareRegistryImage(IMG_DLCL16_RESUME, DLCL + "resume_co.png");
		declareRegistryImage(IMG_DLCL16_RUNLAST, DLCL + "runlast_co.png");
		declareRegistryImage(IMG_DLCL16_REMOVE, DLCL + "rem_co.png");
		declareRegistryImage(IMG_DLCL16_REMOVE_ALL, DLCL + "rem_all_co.png");
		declareRegistryImage(IMG_DLCL16_TERMINATE, DLCL + "terminate_co.png");
		declareRegistryImage(IMG_DLCL16_TERMINATE_ALL, DLCL + "terminate_all_co.png");
		declareRegistryImage(IMG_DLCL16_TERMINATE_RESTART, DLCL + "term_restart.png");


		// enabled local toolbars
		declareRegistryImage(IMG_ELCL16_ADD, ELCL + "add.gif");

		declareRegistryImage(IMG_ELCL16_DELETE, ELCL + "delete.png");
		declareRegistryImage(IMG_ELCL16_INFO, ELCL + "info_obj.gif");
		declareRegistryImage(IMG_ELCL16_QUICKASSIST, ELCL + "quickassist_obj.gif");

		declareRegistryImage(IMG_ELCL16_COPY, ELCL + "duplicate.png");

		declareRegistryImage(IMG_ELCL16_LIST_ADD, ELCL + "list-add.gif");
		declareRegistryImage(IMG_ELCL16_LIST_EDIT, ELCL + "list-edit.gif");
		declareRegistryImage(IMG_ELCL16_LIST_DELETE, ELCL + "list-delete.gif");
		declareRegistryImage(IMG_ELCL16_LIST_MOVE_DOWN, ELCL + "list-movedown.gif");
		declareRegistryImage(IMG_ELCL16_LIST_MOVE_UP, ELCL + "list-moveup.gif");

		declareRegistryImage(IMG_ELCL16_CHECKED  , ELCL + "checked.gif");
		declareRegistryImage(IMG_ELCL16_UNCHECKED, ELCL + "unchecked.gif");

		declareRegistryImage(IMG_ELCL16_PANE_RIGHT, ELCL + "det_pane_right.png");
		declareRegistryImage(IMG_ELCL16_PANE_UNDER, ELCL + "det_pane_under.png");

		declareRegistryImage(IMG_ELCL16_PROFILE_EXEC, ELCL + "profile_exc.png");
		declareRegistryImage(IMG_ELCL16_RESTART, ELCL + "restart_co.png");
		declareRegistryImage(IMG_ELCL16_RESUME, ELCL + "resume_co.png");
		declareRegistryImage(IMG_ELCL16_RUNLAST, ELCL + "runlast_co.png");
		declareRegistryImage(IMG_ELCL16_REMOVE, ELCL + "rem_co.png");
		declareRegistryImage(IMG_ELCL16_REMOVE_ALL, ELCL + "rem_all_co.png");
		declareRegistryImage(IMG_ELCL16_TERMINATE, ELCL + "terminate_co.png");
		declareRegistryImage(IMG_ELCL16_TERMINATE_ALL, ELCL + "terminate_all_co.png");
		declareRegistryImage(IMG_ELCL16_TERMINATE_RESTART, ELCL + "term_restart.png");


		declareRegistryImage(IMG_ELCL16_HELP      , ELCL + "help.png");
		declareRegistryImage(IMG_ELCL16_REVERT    , ELCL + "revert.gif");
		declareRegistryImage(IMG_ELCL16_PUSH      , ELCL + "push.png");

		declareRegistryImage(IMG_ELCL16_SAVE      , ELCL + "save.gif");
		declareRegistryImage(IMG_ELCL16_SAVE_AS   , ELCL + "save_as.gis");

		declareRegistryImage(IMG_ELCL16_DEBUG_EXEC, ELCL + "debug_exc.png");
		declareRegistryImage(IMG_ELCL16_RUN_EXEC  , ELCL + "run_exc.png");

		declareRegistryImage(IMG_ELCL16_DIAL_DEBUG, ELCL + "debug_dial.png");
		declareRegistryImage(IMG_ELCL16_DIAL_RUN  , ELCL + "run_dial.png");

		declareRegistryImage(IMG_ELCL16_WARNING   , ELCL + "warning_st_obj.png");
		declareRegistryImage(IMG_ELCL16_ERROR     , ELCL + "error_st_obj.gif");

		declareRegistryImage(IMG_ELCL16_PINNED_OVR, ELCL + "pinned_ovr.gif");

		declareRegistryImage(IMG_ELCL16_REFRESH   , ELCL + "refresh_tab.png");
		declareRegistryImage(IMG_ELCL16_SYNCED    , ELCL + "synced.gif");
		declareRegistryImage(IMG_ELCL16_VALIDATE  , ELCL + "validate.gif");

	}


	/**
	 * Declare an Image in the registry table.
	 * @param key 	The key to use when registering the image
	 * @param path	The path where the image can be found. This path is relative to where
	 *				this plugin class is found (i.e. typically the packages directory)
	 */
	private final static void declareRegistryImage(final String key, final String path) {
		ImageDescriptor desc= ImageDescriptor.getMissingImageDescriptor();
		try {
			desc= ImageDescriptor.createFromURL(makeIconFileURL(path));
		} catch (final MalformedURLException me) {
			Activator.log(me);
		}
		imageRegistry.put(key, desc);
	}

	/**
	 * Returns the ImageRegistry.
	 *
	 * @return the ImageRegistry
	 */
	public static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			initializeImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * Initialize the image registry by declaring all of the required graphics. This
	 * involves creating JFace image descriptors describing how to create/find the
	 * image should it be needed. The image is not actually allocated until
	 * requested.
	 *
	 * <pre>
	 * 	Prefix conventions
	 *		Wizard Banners			WIZBAN_
	 *		Preference Banners		PREF_BAN_
	 *		Property Page Banners	PROPBAN_
	 *		Color toolbar			CTOOL_
	 *		Enable toolbar			ETOOL_
	 *		Disable toolbar			DTOOL_
	 *		Local enabled toolbar	ELCL_
	 *		Local Disable toolbar	DLCL_
	 *		Object large			OBJL_
	 *		Object small			OBJS_
	 *		View 					VIEW_
	 *		Product images			PROD_
	 *		Misc images				MISC_
	 *
	 *	Where are the images?
	 *		The images (typically pngs) are found in the same location as this plugin class.
	 *		This may mean the same package directory as the package holding this class.
	 *		The images are declared using this.getClass() to ensure they are looked up via
	 *		this plugin class.
	 * </pre>
	 *
	 * @return the initialized ImageRegistry
	 * @see org.eclipse.jface.resource.ImageRegistry
	 */
	public static ImageRegistry initializeImageRegistry() {
		imageRegistry = new ImageRegistry(getStandardDisplay());
		declareImages();
		return imageRegistry;
	}

	/**
	 * Returns the workbench display.
	 *
	 * @return the workbench display
	 */
	public static Display getStandardDisplay() {
		return PlatformUI.getWorkbench().getDisplay();
	}

	/**
	 * Returns the <code>Image</code> identified by the given key, or
	 * <code>null</code> if it does not exist.
	 *
	 * @param key the image's key
	 * @return the <code>Image</code> identified by the given key, or
	 *         <code>null</code> if it does not exist
	 */
	public static Image getImage(final String key) {
		return getImageRegistry().get(key);
	}

	/**
	 * Returns the <code>ImageDescriptor</code> identified by the given key, or
	 * <code>null</code> if it does not exist.
	 *
	 * @param key the image's key
	 * @return the <code>ImageDescriptor</code> identified by the given key, or
	 *         <code>null</code> if it does not exist
	 */
	public static ImageDescriptor getImageDescriptor(final String key) {
		return getImageRegistry().getDescriptor(key);
	}

	private static URL makeIconFileURL(final String iconPath) throws MalformedURLException {
		if (ICON_BASE_URL == null) {
			throw new MalformedURLException();
		}

		return new URL(ICON_BASE_URL, iconPath);
	}











}
