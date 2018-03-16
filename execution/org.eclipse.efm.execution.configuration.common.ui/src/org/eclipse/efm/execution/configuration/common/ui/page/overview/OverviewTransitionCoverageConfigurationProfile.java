/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.efm.execution.configuration.common.ui.page.overview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableConfigProvider;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableViewer;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.core.workflow.common.TraceElement;
import org.eclipse.efm.execution.core.workflow.common.TraceElementCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;

public class OverviewTransitionCoverageConfigurationProfile extends AbstractConfigurationProfile {

	public BooleanFieldEditor fEnabledDetailedSelectionBooleanField;

	private TraceElementTableViewer fTransitionTraceElementTableViewer;

	private TraceElementTableConfigProvider getTableConfig(Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_TRANSITION_COVERAGE_SELECTION, BEHAVIOR_INITIAL_SAMPLE,
				"&Transition selection", BEHAVIOR_DESCRIPTION, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				TraceElementTableConfigProvider.TRANSITION_TRACE_ELEMENT,
				TraceElementKind.TRANSITION);
	}



	private List< String > fAllTransitionsList;

	private String fModelFilePath;

	private OverviewAnalysisProfileSection fOverviewAnalysisProfileSection;

	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewTransitionCoverageConfigurationProfile(
			AbstractConfigurationPage configurationPage,
			OverviewAnalysisProfileSection overviewAnalysisProfileSection) {
		super(configurationPage);

		this.fOverviewAnalysisProfileSection = overviewAnalysisProfileSection;

		fModelFilePath = null;
	}


	@Override
	public String getSectionTitle() {
		return "Transition Coverage";
	}

	@Override
	public String getSectionDescription() {
		return "Transition Coverage, configuration section";
	}


	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		fEnabledDetailedSelectionBooleanField =
				new BooleanFieldEditor(fConfigurationPage,
						ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION,
						"&Enable Transitions Selection", parent, false);
		addFieldEditor(fEnabledDetailedSelectionBooleanField);

		fEnabledDetailedSelectionBooleanField.
				setPropertyChangeListener(fConfigurationPage);

		fEnabledDetailedSelectionBooleanField.addSelectionListener(
			new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					handleEnablingDetailedSelection();
				}
			});

// ==================================================================================

		fTransitionTraceElementTableViewer = new TraceElementTableViewer(this,
				parent, 1, widgetToolkit, getTableConfig(parent.getFont()));
	}


	private void handleEnablingDetailedSelection() {
		fConfigurationPage.propagateVisibility(
				fTransitionTraceElementTableViewer.getControl(),
				fEnabledDetailedSelectionBooleanField.getBooleanValue());
	}


	private void initTransitionTable() {
		loadTransitionListToBeSelected();

		fTransitionTraceElementTableViewer.removeAll();

		TraceElement[] transitionsTrace =
				new TraceElement[fAllTransitionsList.size()];
		int offset = -1;
		for( String transition : fAllTransitionsList ) {
			transitionsTrace[ ++offset ] = new TraceElementCustomImpl(
					true, TraceElementKind.TRANSITION, transition);
		}

		fTransitionTraceElementTableViewer.setInput(transitionsTrace);
	}

	public void handleModelFilePathChanged(String modelFilePath) {
		fModelFilePath = modelFilePath;

		// Force Re-initialization
		fAllTransitionsList = null;

		updateTransitionTables();
	}

	public void updateTransitionTables() {
		fTransitionTraceElementTableViewer.removeAll();

		if( (fAllTransitionsList == null)
			|| fAllTransitionsList.isEmpty() )
		{
			initTransitionTable();
		}
	}

	private void loadTransitionListToBeSelected() {

		if( fAllTransitionsList == null ) {
			fAllTransitionsList = new ArrayList<String>();
		}
		else {
			fAllTransitionsList.clear();
		}

		File modelFile =
				((fModelFilePath == null) || fModelFilePath.isEmpty()) ?
						null : new File( fModelFilePath );

		try {
			if( (modelFile != null) && modelFile.isFile() ) {
				InputStream ips;
					ips = new FileInputStream( modelFile );
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);

				String ligne;
				String transitionName = "";
				int maxSizetransitionName = 0;
				int pos;
				while ((ligne=br.readLine())!=null){
					// Classic Case:
					// 	'transition' ( < ( 'else' | 'prior:'\d )*> )?
					//	transitionName ( --> stateName )? { ...
					//
					if( (pos = ligne.indexOf("transition")) >= 0 ) {
						ligne = ligne.substring( pos + "transition".length() );
						transitionName = ligne.replaceAll(
								"\\s*(<[^>]*>\\s*)?([^\\s-{]*).*", "$2");

						if( transitionName.isEmpty() ) {
							// transition_name_empty
						}
						else {
							fAllTransitionsList.add(transitionName);
							maxSizetransitionName =
									Math.max(maxSizetransitionName,
											transitionName.length() );
						}
					}
					// Other Case:
					// 	transitionName --> stateName { ...
					//
					else if( ligne.contains("-->") &&
							  !ligne.contains("}") &&
							  !ligne.contains("output ") &&
							  !ligne.contains("procedure ") &&
							  !ligne.contains("call ") ) {
						ligne = ligne.replaceAll("\t", "");
						ligne = ligne.substring(0, ligne.indexOf("-->"));
						ligne = ligne.replaceAll(" ", "");
						transitionName = ligne.replaceFirst("@", "");

						if( transitionName.length() == 0 ) {
							// transition_name_empty
						}
						else {
							fAllTransitionsList.add(transitionName);
							maxSizetransitionName =
									Math.max(maxSizetransitionName,
											transitionName.length() );
						}
					}
				}
				br.close();
				fAllTransitionsList.sort(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false);

		configuration.setAttribute(ATTR_TRANSITION_COVERAGE_SELECTION, "");
	}

	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration)
	{
		fModelFilePath = WorkflowFileUtils.getAbsoluteLocation(
				configuration, ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
				DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);

		handleEnablingDetailedSelection();

		fTransitionTraceElementTableViewer.initializeFrom(configuration);
	}


	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		fTransitionTraceElementTableViewer.performApply(configuration);

		if( fOverviewAnalysisProfileSection.isTransitionCoverage() )
		{
			configuration.setAttribute(ATTR_SPECIFICATION_ANALYZE_STRATEGY, "WEIGHT_BFS");
		}
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		if( fEnabledDetailedSelectionBooleanField.getBooleanValue() )
		{
			return fTransitionTraceElementTableViewer.isValid(launchConfig);
		}

		return true;
	}


	///////////////////////////////////////////////////////////////////////////
	// Property Change
	//
	@Override
	public void handleConfigurationPropertyChange(PropertyChangeEvent event) {
		switch( event.getProperty() ) {
		case ATTR_SPECIFICATION_MODEL_FILE_LOCATION: {
			handleModelFilePathChanged( event.getNewValue().toString() );

			break;
		}
		default:
			break;
		}
	}

}
