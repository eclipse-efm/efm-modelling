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
	
	protected CTabItem fTestOfflineTabItem;

	protected CTabItem fModelAnalysisProfileSelectionTabItem;
	

	public OverviewExplorationConfigurationProfile fExplorationPage;

	public OverviewTransitionCoverageConfigurationProfile fTransitionCoveragePage;
	public OverviewBehaviorSelectionConfigurationProfile fBehaviorSelectionPage;
	
	public OverviewTestOfflineConfigurationProfile fTestOfflinePage;

	/////////////////////////////////////
	// ANALYSIS SELECTION
	/////////////////////////////////////

	private String fModelAnalysisProfile = ANALYSIS_PROFILE_MODEL_EXPLORATION;


	public OverviewAnalysisProfileSection(AbstractConfigurationPage configurationPage)
	{
		super(configurationPage);
		
		fExplorationPage =
				new OverviewExplorationConfigurationProfile(configurationPage);
		
		fTransitionCoveragePage =
				new OverviewTransitionCoverageConfigurationProfile(configurationPage);

		fBehaviorSelectionPage =
				new OverviewBehaviorSelectionConfigurationProfile(configurationPage);

		if( getConfigurationPage().isEnabledSymbexIncubationMode() ) {
			fTestOfflinePage =
					new OverviewTestOfflineConfigurationProfile(configurationPage);

		} else {
			fTestOfflinePage = null;
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

		fTabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleModelAnalysisProfileSelectionChange();
				
		        fConfigurationPage.propertyChange(
		        		new PropertyChangeEvent(this,
		        				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
		        				fModelAnalysisProfile, fModelAnalysisProfile) );

				fConfigurationPage.propagateUpdateJobScheduling();
			}
		});
	}


	private void createExplorationTabItem(IWidgetToolkit widgetToolkit)
	{
		fExplorationTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fExplorationTabItem.setText(ANALYSIS_PROFILE_MODEL_EXPLORATION);

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);
		
		fExplorationPage.createControl(scrolledComposite, widgetToolkit);

		Composite control = fExplorationPage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fExplorationTabItem.setControl(scrolledComposite);
		}
	}

	private void createTransitionCoverageTabItem(IWidgetToolkit widgetToolkit)
	{
		fTransitionCoverageTabItem = new CTabItem(fTabFolder, SWT.NONE );
		fTransitionCoverageTabItem.setText(ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION);

		ScrolledComposite scrolledComposite =
				widgetToolkit.createScrolledComposite(fTabFolder);

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

		fTestOfflinePage.createControl(scrolledComposite, widgetToolkit);

		Composite control = fTestOfflinePage.getControl();
		if (control != null) {
			scrolledComposite.setContent(control);
//			scrolledComposite.setMinSize(
//					control.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			fTestOfflineTabItem.setControl(scrolledComposite);
		}
	}


	public void setVisibleModelAnalysisProfilePage(String profile) {
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
		fModelAnalysisProfile = fModelAnalysisProfileSelectionTabItem.getText();
		
		fModelAnalysisProfileSelectionTabItem.setImage(
				ImageResources.getImageDescriptor(
						ImageResources.IMAGE__VALIDATE_ICON).createImage());
	}


	///////////////////////////////////////////////////////////////////////////
	// Fields Editors API
	///////////////////////////////////////////////////////////////////////////
	
	public void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
				ANALYSIS_PROFILE_MODEL_EXPLORATION);

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
	}

	public void initializeFromImpl(ILaunchConfiguration configuration) {
		try {
			fModelAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
					ANALYSIS_PROFILE_MODEL_EXPLORATION);
		}
		catch (CoreException e) {
			e.printStackTrace();
			
			fModelAnalysisProfile = ANALYSIS_PROFILE_MODEL_EXPLORATION;
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
	}


	public void performApplyImpl(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE, fModelAnalysisProfile);
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
	}

	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		switch( fModelAnalysisProfile ) {
		case ANALYSIS_PROFILE_MODEL_EXPLORATION: {
			// MODEL EXPLORATION ANALYSIS
			if( ! fExplorationPage.isValid(launchConfig) )
			{
				return false;
			}

			break;
		}

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
			if( fTestOfflinePage != null ) {
				if( ! fTestOfflinePage.isValid(launchConfig) )
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
	public void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		fExplorationPage.handleConfigurationPropertyChange(event); 
		
		fTransitionCoveragePage.handleConfigurationPropertyChange(event); 
		
		fBehaviorSelectionPage.handleConfigurationPropertyChange(event); 
		
		if( fTestOfflinePage != null ) {
			fTestOfflinePage.handleConfigurationPropertyChange(event); 
		}
	}

}
