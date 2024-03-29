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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationSection;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class OverviewAnalysisProfileSection extends AbstractConfigurationSection {

	protected CTabFolder fTabFolder;

	protected CTabItem fExplorationTabItem;

	protected CTabItem fTransitionCoverageTabItem;
	protected CTabItem fBehaviorSelectionTabItem;

	// Incubations
	protected CTabItem fTestOfflineTabItem;

	protected CTabItem fInferenceTabItem;

	// Extraneous
	protected CTabItem fExtraneousModuleTabItem;

	protected CTabItem fModelAnalysisProfileSelectionTabItem;


	public OverviewExplorationConfigurationProfile fExplorationPage;

	public OverviewTransitionCoverageConfigurationProfile fTransitionCoveragePage;
	public OverviewBehaviorSelectionConfigurationProfile fBehaviorSelectionPage;

	// Incubations
	public OverviewTestOfflineConfigurationProfile fTestOfflinePage;

	public OverviewInferenceConfigurationProfile fInferencePage;

	// Extraneous
	public OverviewExtraneousModuleConfigurationProfile fExtraneouslModulePage;


	/////////////////////////////////////
	// ANALYSIS SELECTION
	/////////////////////////////////////

	private AnalysisProfileKind fModelAnalysisProfile =
			AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE;


	public OverviewAnalysisProfileSection(final AbstractConfigurationPage configurationPage)
	{
		super(configurationPage, true);

		fExplorationPage =
				new OverviewExplorationConfigurationProfile(configurationPage);

		fTransitionCoveragePage =
				new OverviewTransitionCoverageConfigurationProfile(configurationPage, this);

		fBehaviorSelectionPage =
				new OverviewBehaviorSelectionConfigurationProfile(configurationPage);

		// REQUIRED null if its not instantiated
		fTestOfflinePage = null;
		fInferencePage = null;
		fExtraneouslModulePage = null;

		if( getConfigurationPage().isEnabledSymbexIncubationMode() ) {
			fTestOfflinePage =
					new OverviewTestOfflineConfigurationProfile(configurationPage);

			if( getConfigurationPage().isEnabledSymbexDeveloperMode() ) {
				fInferencePage =
						new OverviewInferenceConfigurationProfile(configurationPage);
			}

			fExtraneouslModulePage =
					new OverviewExtraneousModuleConfigurationProfile(configurationPage);
		}
	}


	@Override
	public String getSectionTitle() {
		return "Analysis Profile";
	}

	@Override
	public String getSectionDescription() {
		return "Select the analysis profile of the model by selecting a tab";
	}


	public boolean isTransitionCoverage() {
		return( fModelAnalysisProfile ==
				AnalysisProfileKind.ANALYSIS_TRANSITION_COVERAGE_PROFILE );
	}


	@Override
	protected void createContent(final Composite parent, final IWidgetToolkit widgetToolkit)
	{
		fTabFolder = widgetToolkit.createTabFolder( parent, SWT.TOP );

		fTabFolder.setToolTipText(
				  "Choice of the strategy for the symbolic execution of the model\n"
				+ "\t- Exploration: basic symbolic execution of the model\n"
				+ "\t- Transition Coverage: compute a symbolic tree which covers all transitions of the model\n"
				+ "\t- Behavior Selection: compute one or more symbolic path(s) which cover(s)\n"
				+ "\t\t\t   a predefined behavior\n"
				+ "\t- TESTOFFLINE : Test Verdict Computation: Offline testing...\n"
				+ "\t- INFERENCE : Generate relational properties to be prooved by Frama-C...\n");

		final GridData gd = new GridData(SWT.FILL,SWT.FILL, true, true, 2, 1);
		fTabFolder.setLayoutData(gd);

		createExplorationTabItem(widgetToolkit);
		createTransitionCoverageTabItem(widgetToolkit);
		createBehaviorSelectionTabItem(widgetToolkit);

		// REQUIRED null if its not instantiated
		fTestOfflineTabItem = null;
		fInferenceTabItem = null;
		fExtraneousModuleTabItem = null;

		if( getConfigurationPage().isEnabledSymbexIncubationMode() ) {
			createTestOfflineTabItem(widgetToolkit);

			if( getConfigurationPage().isEnabledSymbexDeveloperMode() ) {
				createInferenceTabItem(widgetToolkit);
			}

			createExtraneousModuleTabItem(widgetToolkit);
		}

		fTabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				handleModelAnalysisProfileSelectionChange();

		        fConfigurationPage.propertyChange(
		        		new PropertyChangeEvent(this,
		        				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
		        				fModelAnalysisProfile, fModelAnalysisProfile) );

				fConfigurationPage.propagateUpdateJobScheduling();
			}
		});
	}


	private void createExplorationTabItem(final IWidgetToolkit widgetToolkit)
	{
		fExplorationTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fExplorationTabItem.setText(
				AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE.getLiteral());

		final ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fExplorationPage.createControl(scrolledComposite, widgetToolkit);

		final Composite control = fExplorationPage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fExplorationTabItem.setControl(scrolledComposite);
		}
	}

	private void createTransitionCoverageTabItem(final IWidgetToolkit widgetToolkit)
	{
		fTransitionCoverageTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fTransitionCoverageTabItem.setText(
				AnalysisProfileKind.ANALYSIS_TRANSITION_COVERAGE_PROFILE.getLiteral());

		final ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fTransitionCoveragePage.createControl(scrolledComposite, widgetToolkit);

		final Composite control = fTransitionCoveragePage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fTransitionCoverageTabItem.setControl(scrolledComposite);
		}
	}

	private void createBehaviorSelectionTabItem(final IWidgetToolkit widgetToolkit)
	{
		fBehaviorSelectionTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fBehaviorSelectionTabItem.setText(
				AnalysisProfileKind.ANALYSIS_BEHAVIOR_SELECTION_PROFILE.getLiteral());


		final ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fBehaviorSelectionPage.createControl(scrolledComposite, widgetToolkit);

		final Composite control = fBehaviorSelectionPage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fBehaviorSelectionTabItem.setControl(scrolledComposite);
		}
	}

	private void createTestOfflineTabItem(final IWidgetToolkit widgetToolkit)
	{
		fTestOfflineTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fTestOfflineTabItem.setText(
				AnalysisProfileKind.ANALYSIS_TEST_OFFLINE_PROFILE.getLiteral());


		final ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fTestOfflinePage.createControl(scrolledComposite, widgetToolkit);

		final Composite control = fTestOfflinePage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fTestOfflineTabItem.setControl(scrolledComposite);
		}
	}

	private void createInferenceTabItem(final IWidgetToolkit widgetToolkit)
	{
		fInferenceTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fInferenceTabItem.setText(
				AnalysisProfileKind.ANALYSIS_ACSL_GENERATION_PROFILE.getLiteral());


		final ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fInferencePage.createControl(scrolledComposite, widgetToolkit);

		final Composite control = fInferencePage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fInferenceTabItem.setControl(scrolledComposite);
		}
	}

	private void createExtraneousModuleTabItem(final IWidgetToolkit widgetToolkit)
	{
		fExtraneousModuleTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fExtraneousModuleTabItem.setText(
				AnalysisProfileKind.ANALYSIS_EXTRANEOUS_PROFILE.getLiteral());

		final ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

		fExtraneouslModulePage.createControl(scrolledComposite, widgetToolkit);

		final Composite control = fExtraneouslModulePage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fExtraneousModuleTabItem.setControl(scrolledComposite);
		}
	}


	public void setVisibleModelAnalysisProfilePage(final AnalysisProfileKind profile) {
		switch ( profile ) {
		case ANALYSIS_TRANSITION_COVERAGE_PROFILE:
			fTabFolder.setSelection( fTransitionCoverageTabItem );
			break;
		case ANALYSIS_BEHAVIOR_SELECTION_PROFILE:
			fTabFolder.setSelection( fBehaviorSelectionTabItem );
			break;

		case ANALYSIS_TEST_OFFLINE_PROFILE:
			fTabFolder.setSelection( (fTestOfflineTabItem != null) ?
					fTestOfflineTabItem : fExplorationTabItem );
			break;

		case ANALYSIS_ACSL_GENERATION_PROFILE:
			fTabFolder.setSelection( (fInferenceTabItem != null) ?
					fInferenceTabItem : fExplorationTabItem );
			break;

		case ANALYSIS_EXTRANEOUS_PROFILE:
			fTabFolder.setSelection( (fExtraneousModuleTabItem != null) ?
					fExtraneousModuleTabItem : fExplorationTabItem );
			break;

		case ANALYSIS_EXPLORATION_PROFILE:
		default:
			fTabFolder.setSelection( fExplorationTabItem );
			break;
		}

		handleModelAnalysisProfileSelectionChange();
	}

	// ======================================================================================
	//                              Miscellaneous handling
	// ======================================================================================
	private void handleModelAnalysisProfileSelectionChange() {
		if( fModelAnalysisProfileSelectionTabItem != null ) {
			fModelAnalysisProfileSelectionTabItem.setImage(null);
		}

		fModelAnalysisProfileSelectionTabItem =
				fTabFolder.getItem( fTabFolder.getSelectionIndex() );
		fModelAnalysisProfile = AnalysisProfileKind.get(
				fModelAnalysisProfileSelectionTabItem.getText());

		fModelAnalysisProfileSelectionTabItem.setImage(
				ImageResources.getImage(ImageResources.IMG_ELCL16_VALIDATE));
	}


	///////////////////////////////////////////////////////////////////////////
	// Fields Editors API
	///////////////////////////////////////////////////////////////////////////

	@Override
	public void setDefaultsImpl(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
				AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE.getLiteral());

		// MODEL EXPLORATION
		fExplorationPage.setDefaults(configuration);

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.setDefaults(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.setDefaults(configuration);

		// TEST OFFLINE // INCUBATION MODE
		if( fTestOfflinePage != null ) {
			fTestOfflinePage.setDefaults(configuration);
		}

		// ACSL PROPERTIES INFERENCE
		if( fInferencePage != null ) {
			fInferencePage.setDefaults(configuration);
		}
	}

	@Override
	public void initializeFromImpl(final ILaunchConfiguration configuration) {
		try {
			final String strModelAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
					AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE.getLiteral());

	        fConfigurationPage.propertyChange(
	        		new PropertyChangeEvent(this,
	        				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
	        				fModelAnalysisProfile, fModelAnalysisProfile) );

			fModelAnalysisProfile = AnalysisProfileKind.get(strModelAnalysisProfile);
		}
		catch (final CoreException e) {
			e.printStackTrace();

			fModelAnalysisProfile = AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE;
		}

		setVisibleModelAnalysisProfilePage( fModelAnalysisProfile );

		fConfigurationPage.propagateGUIupdate();

		// MODEL EXPLORATION
		fExplorationPage.initializeFrom(configuration);

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.initializeFrom(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.initializeFrom(configuration);


		// TEST OFFLINE // INCUBATION MODE
		if( fTestOfflinePage != null ) {
			fTestOfflinePage.initializeFrom(configuration);
		}

		// ACSL PROPERTIES INFERENCE
		if( fInferencePage != null ) {
			fInferencePage.initializeFrom(configuration);
		}

		// USER INCUBATION MODULE // INCUBATION MODE
		if( fExtraneouslModulePage != null ) {
			fExtraneouslModulePage.initializeFrom(configuration);
		}
	}


	@Override
	public void performApplyImpl(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
				fModelAnalysisProfile.getLiteral());
		//System.err.println("+++++" + fModelAnalysisProfile);

		// MODEL EXPLORATION
		fExplorationPage.performApply(configuration);

		// TRANSITION COVERAGE ANALYSIS
		fTransitionCoveragePage.performApply(configuration);

		// BEHAVIOR SELECTION ANALYSIS
		fBehaviorSelectionPage.performApply(configuration);

		// TEST OFFLINE // INCUBATION MODE
		if( fTestOfflinePage != null ) {
			fTestOfflinePage.performApply(configuration);
		}

		// ACSL PROPERTIES INFERENCE
		if( fInferencePage != null ) {
			fInferencePage.performApply(configuration);
		}

		// USER INCUBATION MODULE // INCUBATION MODE
		if( fExtraneouslModulePage != null ) {
			fExtraneouslModulePage.performApply(configuration);
		}
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	protected boolean isValidImpl(final ILaunchConfiguration launchConfig) {
		switch( fModelAnalysisProfile ) {
		case ANALYSIS_EXPLORATION_PROFILE: {
			// MODEL EXPLORATION ANALYSIS
			if( ! fExplorationPage.isValid(launchConfig) )
			{
				return false;
			}

			break;
		}

		case ANALYSIS_BEHAVIOR_SELECTION_PROFILE: {
			// BEHAVIOR SELECTION ANALYSIS
			if( ! fBehaviorSelectionPage.isValid(launchConfig) )
			{
				return false;
			}

			break;
		}
		case ANALYSIS_TRANSITION_COVERAGE_PROFILE: {
			// TRANSITION COVERAGE ANALYSIS
			if( ! fTransitionCoveragePage.isValid(launchConfig) )
			{
				return false;
			}

			break;
		}

		case ANALYSIS_TEST_OFFLINE_PROFILE: {
			// TEST OFFLINE // INCUBATION MODE
			if( fTestOfflinePage != null ) {
				if( ! fTestOfflinePage.isValid(launchConfig) )
				{
					return false;
				}
			}

			break;
		}

		case ANALYSIS_ACSL_GENERATION_PROFILE: {
			// INFERENCE
			if( ! fInferencePage.isValid(launchConfig) )
			{
				return false;
			}

			break;
		}

		case ANALYSIS_EXTRANEOUS_PROFILE: {
			// TEST OFFLINE // INCUBATION MODE
			if( fExtraneouslModulePage!= null ) {
				if( ! fExtraneouslModulePage.isValid(launchConfig) )
				{
					return false;
				}
			}

			break;
		}

		default:
			break;
		}

		return true;
	}


	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	public void handleConfigurationPropertyChange(final PropertyChangeEvent event) {
		fExplorationPage.handleConfigurationPropertyChange(event);

		fTransitionCoveragePage.handleConfigurationPropertyChange(event);

		fBehaviorSelectionPage.handleConfigurationPropertyChange(event);

		if( fTestOfflinePage != null ) {
			fTestOfflinePage.handleConfigurationPropertyChange(event);
		}
	}


}
