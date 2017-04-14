/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.ui.views.viewparts.swv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationListener;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.swt.widgets.Combo;

public class UpdateSymbexWorkflowViewListener implements ILaunchConfigurationListener {


	private static Map<Integer, UpdateSymbexWorkflowViewListener> listenerTracker = new HashMap<>();

	private SymbexWorkflowView symbexWorkflowView;

	private ILaunchManager lc_manager;
	private Integer ID;
	private Combo combo;


	public UpdateSymbexWorkflowViewListener(Combo combo,
			SymbexWorkflowView symbexWorkflowView) throws Exception
	{
		final int min = 0;
		final int max = 999;

		if( UpdateSymbexWorkflowViewListener.listenerTracker.keySet().size() > max )
		{
			throw new Exception();
		}
		int id_n = 0;
		while( UpdateSymbexWorkflowViewListener.listenerTracker.containsKey(id_n) )
		{
			id_n = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		this.ID = id_n;
		this.combo = combo;
		this.symbexWorkflowView = symbexWorkflowView;
		lc_manager = DebugPlugin.getDefault().getLaunchManager();
		lc_manager.addLaunchConfigurationListener(this);
	}


	public void selfKill() {
		lc_manager = DebugPlugin.getDefault().getLaunchManager();
		lc_manager.removeLaunchConfigurationListener(this);
		UpdateSymbexWorkflowViewListener.listenerTracker.remove(ID);
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void launchConfigurationAdded(ILaunchConfiguration configuration) {
		symbexWorkflowView.refreshLaunchConfigurationsGUI();
	}

	@Override
	public void launchConfigurationChanged(ILaunchConfiguration configuration) {
		if(configuration.isWorkingCopy()) {
			return;
		}
		String[] contents = symbexWorkflowView.getLaunchConfigurationNames();
		String chg_name = configuration.getName();

		if(Arrays.asList(contents).contains(chg_name)) {
			System.err.println("conf changed detected on symbex launch conf " + chg_name);
			int new_index = Arrays.asList(contents).indexOf(chg_name);
			combo.select(new_index);
			symbexWorkflowView.updateGUI();
			symbexWorkflowView.scheduleUpdateJob();
		} else {
			combo.deselectAll();
		}
	}

	@Override
	public void launchConfigurationRemoved(ILaunchConfiguration configuration) {
		symbexWorkflowView.refreshLaunchConfigurationsGUI();
	}

}
