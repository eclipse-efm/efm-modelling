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
import org.eclipse.efm.execution.ui.views.delegates.LaunchManagerSWVlinker;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.swt.widgets.Combo;

public class UpdateSymbexWorkflowViewListener implements ILaunchConfigurationListener {

	
	private static Map<Integer,UpdateSymbexWorkflowViewListener> listenerTracker = new HashMap<Integer,UpdateSymbexWorkflowViewListener>();
	
	private ILaunchConfigurationGUIelement parentGUIelement;
	
	private ILaunchManager lc_manager;
	private Integer ID;
	private Combo combo;
	
	public static void updateAnySWVcombo(Combo combo) {
		String[] contents = LaunchManagerSWVlinker.getSymbexRunConfigurationNames();
		combo.setItems(contents);
	}
	
	public UpdateSymbexWorkflowViewListener(Combo combo, ILaunchConfigurationGUIelement parentGUIelement) throws Exception {
		int min = 0;
		int max = 999;
		if (UpdateSymbexWorkflowViewListener.listenerTracker.keySet().size() > max) {
			throw new Exception();
		}
		int id_n = 0;
		while(UpdateSymbexWorkflowViewListener.listenerTracker.containsKey(id_n)) {
			id_n = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		this.ID = id_n;
		this.combo = combo;
		this.parentGUIelement = parentGUIelement;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateSWVcombo() {
		updateAnySWVcombo(combo);
	}
	
	@Override
	public void launchConfigurationAdded(ILaunchConfiguration configuration) {
		int cur_index = combo.getSelectionIndex();
		String cur_name = null;
		if (cur_index != -1) {
			cur_name = combo.getItem(cur_index);
		}
		updateSWVcombo();
		String[] contents = LaunchManagerSWVlinker.getSymbexRunConfigurationNames();
		String chg_name = configuration.getName();
		if(Arrays.asList(contents).contains(chg_name)) {
			int new_index = Arrays.asList(contents).indexOf(chg_name);
			combo.select(new_index);
		} else if(cur_name != null && Arrays.asList(contents).contains(cur_name)) {
			int new_index = Arrays.asList(contents).indexOf(cur_name);
			combo.select(new_index);
		} else {
			combo.deselectAll();
		}
		parentGUIelement.updateGUI();
		parentGUIelement.scheduleUpdateJob();
	}

	@Override
	public void launchConfigurationChanged(ILaunchConfiguration configuration) {
		if(configuration.isWorkingCopy()) {
			return;
		}
		String[] contents = LaunchManagerSWVlinker.getSymbexRunConfigurationNames();
		String chg_name = configuration.getName();
		
		if(Arrays.asList(contents).contains(chg_name)) {
			System.err.println("conf changed detected on symbex launch conf " + chg_name);
			int new_index = Arrays.asList(contents).indexOf(chg_name);
			combo.select(new_index);
			parentGUIelement.updateGUI();
			parentGUIelement.scheduleUpdateJob();
		} else {
			combo.deselectAll();
		}
	}

	@Override
	public void launchConfigurationRemoved(ILaunchConfiguration configuration) {
		int cur_index = combo.getSelectionIndex();
		String cur_name = null;
		if (cur_index != -1) {
			System.err.println(cur_index);
			cur_name = combo.getItem(cur_index);
		}
		updateSWVcombo();
		String[] contents = LaunchManagerSWVlinker.getSymbexRunConfigurationNames();
		if(cur_name != null && Arrays.asList(contents).contains(cur_name)) {
			int new_index = Arrays.asList(contents).indexOf(cur_name);
			combo.select(new_index);
		} else {
			combo.deselectAll();
		}
		parentGUIelement.updateGUI();
		parentGUIelement.scheduleUpdateJob();
	}

}
