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
package org.eclipse.efm.execution.ui.views.launchconfigurations.components.sections;

import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.ui.views.delegates.LaunchManagerSWVlinker;
import org.eclipse.efm.execution.ui.views.editors.FieldEditor;
import org.eclipse.efm.execution.ui.views.editors.impls.StringFieldEditor;
import org.eclipse.efm.execution.ui.views.utils.GenericCompositeCreator;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationEditorComposite;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.ui.views.utils.SWTFactory;
import org.eclipse.efm.execution.ui.views.viewparts.swv.SymbexWorkflowView;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages.MainTabBehaviorSelectionPage;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages.MainTabTestOfflinePage;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages.MainTabTransitionCoveragePage;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.sections.AbstractSectionCreator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class AnalysisProfile1SectionCreator extends AbstractSectionCreator {
	
	private static final String[] MODEL_COMBO_ITEMS = new String[] {
			ANALYSIS_PROFILE_MODEL_EXPLORATION ,
			ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION ,
			ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR,
			ANALYSIS_PROFILE_TEST_OFFLINE
	};
	
	public AnalysisProfile1SectionCreator(ILaunchConfigurationGUIelement guielt,
			ILaunchConfigurationEditorComposite fLaunchConfCommInt, ToolBarManager tbm, Composite innertabcompo) {
		super(guielt, fLaunchConfCommInt, tbm, innertabcompo);
	}
	
	@Override
	public void addComposite(Composite innertabcompo, IToolBarManager tbm) {
		addComposite_internal(innertabcompo, tbm, "&Analysis Profile");
	}

	private FieldEditor[] contentFieldEdit;
	

	public Combo fModelCombo;
	public MainTabTransitionCoveragePage fTransitionCoveragePage;
	public MainTabBehaviorSelectionPage fBehaviorSelectionPage;
	public MainTabTestOfflinePage fTestOfflinePage;
	public Button fTestOfflineButton;
	
	@Override
	protected void addCollapsedContent(FormToolkit toolkit) {		
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
				section.layout();
				guielt.scheduleUpdateJob();
				section.layout();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				section.layout();
				guielt.scheduleUpdateJob();
				section.layout();
			}
		});

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage = new MainTabTransitionCoveragePage(this.fLaunchConfCommInt);
		fTransitionCoveragePage.createPageWithToolkit(sectionClient, toolkit);
		fTransitionCoveragePage.updateLayouts();

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage = new MainTabBehaviorSelectionPage(this.fLaunchConfCommInt);
		fBehaviorSelectionPage.createPageWithToolkit(sectionClient, toolkit);
		fBehaviorSelectionPage.updateLayouts();
		
		fTestOfflinePage = new MainTabTestOfflinePage(this.fLaunchConfCommInt);
		fTestOfflinePage.createPageWithToolkit(sectionClient, toolkit);
		fTestOfflinePage.updateLayouts();
	}

	@Override
	public FieldEditor[] getFieldEditors() {
		return contentFieldEdit;
	}
	

}
