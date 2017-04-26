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

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationSection;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class OverviewAnalysisProfileSection extends AbstractConfigurationSection {

	public OverviewAnalysisProfileSection(AbstractConfigurationPage configurationPage)
	{
		super(configurationPage);
	}

	private FieldEditor[] contentFieldEdit;

	protected CTabFolder fTabFolder;

	protected CTabItem fExplorationTabItem;

	protected CTabItem fTransitionCoverageTabItem;
	protected CTabItem fBehaviorSelectionTabItem;
	protected CTabItem fTestOfflineTabItem;

	public OverviewTransitionCoverageConfigurationProfile fTransitionCoveragePage;
	public OverviewBehaviorSelectionConfigurationProfile fBehaviorSelectionPage;
	public OverviewTestOfflineConfigurationProfile fTestOfflinePage;

	/////////////////////////////////////
	// ANALYSIS SELECTION
	/////////////////////////////////////

	private String fModelAnalysisProfile = ANALYSIS_PROFILE_MODEL_EXPLORATION;


	@Override
	public String getSectionTitle() {
		return "Analysis Profile";
	}

	@Override
	public String getSectionDescription() {
		return "Select and configure one profile for model analysis";
	}


	@Override
	public void requestLayout() {
		super.requestLayout();
	}

	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		fTabFolder = widgetToolkit.createTabFolder( parent, SWT.TOP );

		fTabFolder.setToolTipText(
				  "Choice of the strategy for the symbolic execution of the model\n"
				+ "\t- Exploration: basic symbolic execution of the model\n"
				+ "\t- Transition Coverage: compute a symbolic tree which covers all transitions of the model\n"
				+ "\t- Behavior Selection: compute one or more symbolic path(s) which cover(s)\n"
				+ "\t\t\t   a predefined behavior\n"
				+ "\t- TESTOFFLINE : Test Verdict Computation: Offline testing...\n");

		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true, 2, 1);
		fTabFolder.setLayoutData(gd);

		createExplorationTabItem(widgetToolkit);
		createTransitionCoverageTabItem(widgetToolkit);
		createBehaviorSelectionTabItem(widgetToolkit);

		if( getConfigurationPage().isEnabledSymbexIncubationMode() ) {
			createTestOfflineTabItem(widgetToolkit);
		} else {
			fTestOfflineTabItem = null;
		}

		fTabFolder.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleModelSelectionChange();

				fConfigurationPage.propagateUpdateJobScheduling();
				requestLayout();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				fConfigurationPage.propagateUpdateJobScheduling();
				requestLayout();
			}
		});
	}


	private void createExplorationTabItem(IWidgetToolkit widgetToolkit)
	{
		fExplorationTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fExplorationTabItem.setText(ANALYSIS_PROFILE_MODEL_EXPLORATION);

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);
		
		scrolledComposite.setContent(
				widgetToolkit.createLabel(scrolledComposite,
				"Configure Exploration limitation in Supervisor Tab", 2) );

		fExplorationTabItem.setControl(scrolledComposite);
	}

	private void createTransitionCoverageTabItem(IWidgetToolkit widgetToolkit)
	{
		fTransitionCoverageTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fTransitionCoverageTabItem.setText(ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION);

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fTransitionCoveragePage =
				new OverviewTransitionCoverageConfigurationProfile(this.fConfigurationPage);

		fTransitionCoveragePage.createControl(scrolledComposite, widgetToolkit);

		Composite control = fTransitionCoveragePage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fTransitionCoverageTabItem.setControl(scrolledComposite);
		}
	}

	private void createBehaviorSelectionTabItem(IWidgetToolkit widgetToolkit)
	{
		fBehaviorSelectionTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fBehaviorSelectionTabItem.setText(ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR);


		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fBehaviorSelectionPage =
				new OverviewBehaviorSelectionConfigurationProfile(this.fConfigurationPage);

		fBehaviorSelectionPage.createControl(scrolledComposite, widgetToolkit);

		Composite control = fBehaviorSelectionPage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fBehaviorSelectionTabItem.setControl(scrolledComposite);
		}
	}

	private void createTestOfflineTabItem(IWidgetToolkit widgetToolkit)
	{
		fTestOfflineTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fTestOfflineTabItem.setText(ANALYSIS_PROFILE_MODEL_TEST_OFFLINE);


		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fTestOfflinePage =
				new OverviewTestOfflineConfigurationProfile(this.fConfigurationPage);

		fTestOfflinePage.createControl(scrolledComposite, widgetToolkit);

		Composite control = fTestOfflinePage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fTestOfflineTabItem.setControl(scrolledComposite);
		}
	}


	public void setVisibleProfilePage(String profile) {
		switch ( profile ) {
		case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION:
			fTabFolder.setSelection( fTransitionCoverageTabItem );
			break;
		case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR:
			fTabFolder.setSelection( fBehaviorSelectionTabItem );
			break;
		case ANALYSIS_PROFILE_MODEL_TEST_OFFLINE:
			fTabFolder.setSelection( (fTestOfflineTabItem != null) ?
					fTestOfflineTabItem : fExplorationTabItem );
			break;

		case ANALYSIS_PROFILE_MODEL_EXPLORATION:
		default:
			fTabFolder.setSelection( fExplorationTabItem );
			break;
		}
	}

	// ======================================================================================
	//                              Miscellaneous handling
	// ======================================================================================
	public void handleModelFileChange() {
		if( fModelAnalysisProfile.equals(ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION) )
		{
			fTransitionCoveragePage.handleModelFilePathChanged(
					((OverviewConfigurationPage) fConfigurationPage).getModelPathText());
		}
	}

	private void handleModelSelectionChange() {
		CTabItem selectionTabItem = fTabFolder.getItem( fTabFolder.getSelectionIndex() );
		fModelAnalysisProfile = selectionTabItem.getText();

		for( AbstractConfigurationPage confPage : getConfigurationPages() ) {
			confPage.handleModelAnalysisProfileSelectionChanged(fModelAnalysisProfile);
		}
		
//		getConfigurationPage().propagateGUIupdate();
	}

	@Override
	public FieldEditor[] getFieldEditors() {
		return contentFieldEdit;
	}


	// ======================================================================================
	//                              Fields Value Update
	// ======================================================================================

	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
				ANALYSIS_PROFILE_MODEL_EXPLORATION);

		// TRANSITION COVERAGE ANALYSIS
//		fTransitionCoveragePage.setDefaults(configuration);

		configuration.setAttribute(
				ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SELECTION, new ArrayList<String>());

		// BEHAVIOR SELECTION ANALYSIS
//		fBehaviorSelectionPage.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST,
				BEHAVIOR_INITIAL_SAMPLE);

		// TEST OFFLINE // INCUBATION MODE
		if( getConfigurationPage().isEnabledSymbexIncubationMode() ) {
//			fTestOfflinePage.setDefaults(configuration);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_TRACE_FILE_LOCATION,
					DEFAULT_TEST_OFFLINE_TRACE_FILE_LOCATION);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_PURPOSE_FILE_LOCATION,
					DEFAULT_TEST_OFFLINE_PURPOSE_FILE_LOCATION);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_ENABLED_TRACE_CONFIGURATION, false);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
					DEFAULT_TEST_OFFLINE_OBSERVABLE_SPECIFICATION);

			configuration.setAttribute(
					ATTR_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
					DEFAULT_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION);
		}
	}

	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		try {
			fModelAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
					ANALYSIS_PROFILE_MODEL_EXPLORATION);

			setVisibleProfilePage(fModelAnalysisProfile);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}

		setVisibleProfilePage( fModelAnalysisProfile );

		fConfigurationPage.propagateGUIupdate();

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.initializeFrom(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.initializeFrom(configuration);


		// TEST OFFLINE // INCUBATION MODE
		if( getConfigurationPage().isEnabledSymbexIncubationMode() ) {
			fTestOfflinePage.initializeFrom(configuration);
		}
	}


	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, fModelAnalysisProfile);
		//System.err.println("+++++" + fModelAnalysisProfile);
		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.performApply(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.performApply(configuration);

		// TEST OFFLINE // INCUBATION MODE
		if( getConfigurationPage().isEnabledSymbexIncubationMode() ) {
			fTestOfflinePage.performApply(configuration);
		}
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	public boolean areFieldsValid(ILaunchConfiguration launchConfig) {
		switch( fModelAnalysisProfile ) {
		case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR: {
			// BEHAVIOR SELECTION ANALYSIS
			if( ! fBehaviorSelectionPage.isValid(launchConfig) )
			{
				return false;
			}

			break;
		}
		case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION: {
			// TRANSITION COVERAGE ANALYSIS
			if( ! fTransitionCoveragePage.isValid(launchConfig) )
			{
				return false;
			}

			break;
		}

		case ANALYSIS_PROFILE_MODEL_TEST_OFFLINE: {
			// TEST OFFLINE // INCUBATION MODE
			if( getConfigurationPage().isEnabledSymbexIncubationMode() ) {
				if( ! fTestOfflinePage.isValid(launchConfig) )
				{
					return false;
				}
			}

			break;
		}

		case ANALYSIS_PROFILE_MODEL_EXPLORATION:
		default:
			break;
		}

		return true;
	}

}
