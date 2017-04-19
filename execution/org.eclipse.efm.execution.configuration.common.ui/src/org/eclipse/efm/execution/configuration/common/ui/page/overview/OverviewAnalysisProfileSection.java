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
package org.eclipse.efm.execution.configuration.common.ui.page.overview;

import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationSection;
import org.eclipse.efm.execution.configuration.common.ui.editors.FieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.util.SWTFactory;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class OverviewAnalysisProfileSection extends AbstractConfigurationSection {
	
	private static final String[] MODEL_COMBO_ITEMS = new String[] {
			ANALYSIS_PROFILE_MODEL_EXPLORATION ,
			ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION ,
			ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR,
			ANALYSIS_PROFILE_TEST_OFFLINE
	};
	
	public OverviewAnalysisProfileSection(
			AbstractConfigurationPage configurationPage,
			ToolBarManager tbm, Composite innertabcompo)
	{
		super(configurationPage, tbm, innertabcompo);
	}
	
	@Override
	public void addComposite(Composite innertabcompo, IToolBarManager tbm) {
		addComposite_internal(innertabcompo, tbm, "&Analysis Profile");
	}

	private FieldEditor[] contentFieldEdit;
	

	public Combo fModelCombo;
	public OverviewTransitionCoverageConfigurationProfile fTransitionCoveragePage;
	public OverviewBehaviorSelectionConfigurationProfile fBehaviorSelectionPage;
	public OverviewTestOfflineConfigurationProfile fTestOfflinePage;
	public Button fTestOfflineButton;
	
	
	@Override
	public void requestLayout() {
		super.requestLayout();
	}
	
	@Override
	protected void addCollapsedContent() {		
		fModelCombo = SWTFactory.createCombo(sectionClient,
				SWT.DROP_DOWN | SWT.READ_ONLY, 1, MODEL_COMBO_ITEMS);
		fModelCombo.setToolTipText(
				  "Choice of the strategy for the symbolic execution of the model\n"
				+ "\t- Exploration: basic symbolic execution of the model\n"
				+ "\t- Transition Coverage: compute a symbolic tree which covers all transitions of the model\n"
				+ "\t- Behavior Selection: compute one or more symbolic path(s) which cover(s)\n"
				+ "\t\t\t   a predefined behavior\n"
				+ "\t- TESTOFFLINE : Test Verdict Computation: Offline testing...\n");
		fModelCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fConfigurationPage.getMasterGUIelement().scheduleUpdateJob();
				requestLayout();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				fConfigurationPage.getMasterGUIelement().scheduleUpdateJob();
				requestLayout();
			}
		});

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage = new OverviewTransitionCoverageConfigurationProfile(this.fConfigurationPage);
		fTransitionCoveragePage.createPageWithToolkit(sectionClient);
		fTransitionCoveragePage.updateLayouts();

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage = new OverviewBehaviorSelectionConfigurationProfile(this.fConfigurationPage);
		fBehaviorSelectionPage.createPageWithToolkit(sectionClient);
		fBehaviorSelectionPage.updateLayouts();
		
		fTestOfflinePage = new OverviewTestOfflineConfigurationProfile(this.fConfigurationPage);
		fTestOfflinePage.createPageWithToolkit(sectionClient);
		fTestOfflinePage.updateLayouts();
	}

	@Override
	public FieldEditor[] getFieldEditors() {
		return contentFieldEdit;
	}
	

}
