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

package org.eclipse.efm.execution.launchconfiguration;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchListener;
import org.eclipse.efm.execution.launchconfiguration.job.console.SymbexProcessConsoleManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin implements ILaunchListener {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.efm.execution.launchconfiguration"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	// The singleton SymbexProcessConsoleManager instance.
	private SymbexProcessConsoleManager fSymbexProcessConsoleManager;

	/**
	 * The constructor
	 */
	public Activator() {
		//!! NOTHING
	}


	/**
	 * Returns the process console manager. The manager will be created lazily on
	 * the first access.
	 *
	 * @return ProcessConsoleManager
	 */
	public SymbexProcessConsoleManager getSymbexProcessConsoleManager() {
		if (fSymbexProcessConsoleManager == null) {
			fSymbexProcessConsoleManager = new SymbexProcessConsoleManager();
		}
		return fSymbexProcessConsoleManager;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;

        if (fSymbexProcessConsoleManager != null) {
        	fSymbexProcessConsoleManager.shutdown();
        }

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
	 * When the first launch is added, instantiate launch processors,
	 * and stop listening to launch notifications.
	 *
	 * @see org.eclipse.debug.core.ILaunchListener#launchAdded(org.eclipse.debug.core.ILaunch)
	 */
	@Override
	public void launchAdded(final ILaunch launch) {
		DebugPlugin.getDefault().getLaunchManager().removeLaunchListener(this);

		// Creates/starts launch listeners after a launch has been added.
		getSymbexProcessConsoleManager().startup();
	}

	/**
	 * @see org.eclipse.debug.core.ILaunchListener#launchChanged(org.eclipse.debug.core.ILaunch)
	 */
	@Override
	public void launchChanged(final ILaunch launch) {
		//!! NOTHING
	}

	/**
	 * @see org.eclipse.debug.core.ILaunchListener#launchRemoved(org.eclipse.debug.core.ILaunch)
	 */
	@Override
	public void launchRemoved(final ILaunch launch) {
		//!! NOTHING
	}



}
