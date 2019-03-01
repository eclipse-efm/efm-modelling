/*******************************************************************************
 * Copyright (c) 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.launchconfiguration.job.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchListener;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.console.ConsoleColorProvider;
import org.eclipse.debug.ui.console.IConsoleColorProvider;
import org.eclipse.efm.execution.launchconfiguration.Activator;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;

public class SymbexProcessConsoleManager implements ILaunchListener {

	public static final String PROCESS_TYPE = "diversity";

	/**
	 * Map of processes for a launch to compute removed processes
	 */
	private Map<ILaunch, IProcess[]> fProcesses;

    /**
     * The default color provider. Used if no color provider is contributed
     * for the given process type.
     */
    private IConsoleColorProvider fDefaultColorProvider;

    /**
	 * Map of Console
     */
	public Map<IPath, SymbexSpiderConsole> fTableOfConsole;


	public SymbexProcessConsoleManager() {
		//!! NOTHING
	}

	public static SymbexProcessConsoleManager getDefault() {
		return Activator.getDefault().getSymbexProcessConsoleManager();
	}


	private boolean isSymbexProcessType(final IProcess process) {
		return (process != null) && PROCESS_TYPE.equals(
				process.getAttribute(IProcess.ATTR_PROCESS_TYPE));
	}

	@Override
	public void launchRemoved(final ILaunch launch) {
		removeLaunch(launch);
	}

	protected void removeLaunch(final ILaunch launch) {
		for( final IProcess iProcess : launch.getProcesses() ) {
			removeProcess(iProcess);
		}
		if (fProcesses != null) {
			fProcesses.remove(launch);
		}
	}

	/**
	 * Removes the console and document associated with the given process.
	 *
	 * @param iProcess process to clean up
	 */
	private void removeProcess(final IProcess iProcess) {
		final IConsole console = getConsole(iProcess);

		if (console != null) {
			final IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
			manager.removeConsoles(new IConsole[]{console});
		}
	}

	/**
	 * Returns the console for the given process, or <code>null</code> if none.
	 *
	 * @param process
	 * @return the console for the given process, or <code>null</code> if none
	 */
	public IConsole getConsole(final IProcess process) {
		final IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
		for( final IConsole console : manager.getConsoles() ) {
			if (console instanceof SymbexSpiderConsole) {
				final SymbexSpiderConsole spiderConsole = (SymbexSpiderConsole)console;
				if (spiderConsole.getProcess().equals(process)) {
					return spiderConsole;
				}
			}
		}
		return null;
	}


	@Override
	public void launchAdded(final ILaunch launch) {
		launchChanged(launch);
	}

	@Override
	public void launchChanged(final ILaunch launch) {
		for( final IProcess process : launch.getProcesses() ) {
			if( isSymbexProcessType(process) ) {
				continue;
			}
			else if (getConsoleDocument(process) == null) {
				if (process.getStreamsProxy() == null) {
					continue;
				}

				//create a new console.
				final IConsoleColorProvider colorProvider = getColorProvider(
						process.getAttribute(IProcess.ATTR_PROCESS_TYPE));
				final String encoding =
						launch.getAttribute(DebugPlugin.ATTR_CONSOLE_ENCODING);

				final SymbexSpiderConsole spiderConsole =
						new SymbexSpiderConsole(process, colorProvider, encoding);

				spiderConsole.setAttribute(
						IDebugUIConstants.ATTR_CONSOLE_PROCESS, process);

				//add new console to console manager.
				final IConsoleManager consoleManager =
						ConsolePlugin.getDefault().getConsoleManager();

				consoleManager.addConsoles(new IConsole[]{ spiderConsole });
			}
		}
		final List<IProcess> removed = getRemovedProcesses(launch);
		if (removed != null) {
			for (final IProcess p : removed) {
				removeProcess(p);
			}
		}
	}

	/**
	 * Returns the document for the process, or <code>null</code>
	 * if none.
	 */
	public IDocument getConsoleDocument(final IProcess process) {
		final SymbexSpiderConsole console = (SymbexSpiderConsole) getConsole(process);
		return (console != null ? console.getDocument() : null);
	}

	/**
	 * Called by the debug ui plug-in on startup.
	 * The console document manager starts listening for
	 * launches to be registered and initializes if any launches
	 * already exist.
	 */
	public void startup() {
		final ILaunchManager launchManager =
				DebugPlugin.getDefault().getLaunchManager();
		launchManager.addLaunchListener(this);

		//set up the docs for launches already registered
		for( final ILaunch launch : launchManager.getLaunches() ) {
			launchAdded(launch);
		}
	}

	/**
	 * Called by the debug ui plug-in on shutdown.
	 * The console document manager de-registers as a
	 * launch listener and kills all existing console documents.
	 */
	public void shutdown() {
		final ILaunchManager launchManager =
				DebugPlugin.getDefault().getLaunchManager();
		for( final ILaunch launch : launchManager.getLaunches() ) {
			removeLaunch(launch);
		}
		launchManager.removeLaunchListener(this);

		if (fProcesses != null) {
			fProcesses.clear();
		}

		if (fTableOfConsole != null) {
			fTableOfConsole.clear();
		}
	}

	/**
	 * Returns a new console document color provider extension for the given
	 * process type, or <code>null</code> if none.
	 *
	 * @param type corresponds to <code>IProcess.ATTR_PROCESS_TYPE</code>
	 * @return IConsoleColorProvider
	 */
	public IConsoleColorProvider getColorProvider(final String type) {
		//no color provider found of specified type, return default color provider.
		if (fDefaultColorProvider == null) {
			fDefaultColorProvider = new ConsoleColorProvider();
		}
		return fDefaultColorProvider;
	}

	/**
	 * Returns the processes that have been removed from the given
	 * launch, or <code>null</code> if none.
	 *
	 * @param launch launch that has changed
	 * @return removed processes or <code>null</code>
	 */
	private List<IProcess> getRemovedProcesses(final ILaunch launch) {
		List<IProcess> removed = null;
		if (fProcesses == null) {
			fProcesses = new HashMap<ILaunch, IProcess[]>();
		}
		final IProcess[] old = fProcesses.get(launch);
		final IProcess[] curr = launch.getProcesses();
		if (old != null) {
			for( final IProcess process : old ) {
				if (!contains(curr, process)) {
					if (removed == null) {
						removed = new ArrayList<IProcess>();
					}
					removed.add(process);
				}
			}
		}
		// update cache with current processes
		fProcesses.put(launch, curr);

		return removed;
	}

	/**
	 * Returns whether the given object is contained in the list.
	 *
	 * @param list list to search
	 * @param object object to search for
	 * @return whether the given object is contained in the list
	 */
	private boolean contains(final Object[] list, final Object object) {
		for( final Object object2 : list ) {
			if (object2.equals(object)) {
				return true;
			}
		}
		return false;
	}

}
