/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.efm.execution.core;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.efm.execution.core"; //$NON-NLS-1$

	private static final String RESOURCE_NAME = PLUGIN_ID + ".messages";


	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		SymbexPreferenceUtil.loadGlobals( getPreferenceStore() );
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}


	/**
	 * Log a status
	 * @param aStatus the status to log
	 */
	public static void log(IStatus aStatus) {
		getDefault().getLog().log(aStatus);
	}


	/**
	 * log an exception
	 * @param aThrowable the exception to log
	 */
	public static void log(Throwable aThrowable) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, Status.OK,
						getMessage("Plugin.internal_error"),
						aThrowable));
	}


	/**
	 * Translate a key to a bundled message
	 * @param aKey the key
	 * @return the message
	 */
	public static String getMessage(String aKey) {
	    String bundleString;
		ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_NAME);
		if (bundle != null) {
			try {
				bundleString = bundle.getString(aKey);
			} catch (MissingResourceException e) {
			    log(e);
				bundleString = "!" + aKey + "!";
			}
		} else {
			bundleString = "!" + aKey + "!";
		}
		return bundleString;
	}


}
