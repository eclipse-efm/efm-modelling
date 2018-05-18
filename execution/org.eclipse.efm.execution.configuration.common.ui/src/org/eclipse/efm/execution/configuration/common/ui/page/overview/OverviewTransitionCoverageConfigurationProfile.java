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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableConfigProvider;
import org.eclipse.efm.execution.configuration.common.ui.editors.table.TraceElementTableViewer;
import org.eclipse.efm.execution.core.util.FormalMLXtextUtil;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.efm.execution.core.workflow.common.CoverageScopeKind;
import org.eclipse.efm.execution.core.workflow.common.TraceElement;
import org.eclipse.efm.execution.core.workflow.common.TraceElementCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class OverviewTransitionCoverageConfigurationProfile
		extends AbstractConfigurationProfile {

	public static final String[] SCOPE_COMBO_ITEMS = new String[] {
			CoverageScopeKind.MODEL.getLiteral() ,
			CoverageScopeKind.INSTANCE.getLiteral() ,
			CoverageScopeKind.DETAILS.getLiteral()
	};

	private CoverageScopeKind fCoverageScope = CoverageScopeKind.MODEL;

	private Combo fCoverageScopeCombo = null;


	private TraceElementTableViewer fTransitionTraceElementTableViewer;

	private final static TraceElement[] NO_TRANSITION = new TraceElement[0];

	private TraceElement[] fAllTransitionCoverageElements;

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

		fAllTransitionCoverageElements = NO_TRANSITION;

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
		fCoverageScopeCombo = widgetToolkit.createLabelledCombo(parent,
				"&Scope : ", SWT.DROP_DOWN | SWT.READ_ONLY, 1, SCOPE_COMBO_ITEMS);
		fCoverageScopeCombo.addSelectionListener( new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleCoverageScopeSelectionChange();
			}
		});

// ==================================================================================

		fTransitionTraceElementTableViewer =
			new TraceElementTableViewer(this, parent, 1, widgetToolkit,
				TraceElementTableConfigProvider.getTransitionCoverage(
						parent.getFont()));
		// DONT UNCOMMENT THAT CODE
//		addTableViewer(fTransitionTraceElementTableViewer);
	}


	private void handleCoverageScopeSelectionChange() {
		fCoverageScope = CoverageScopeKind.get( fCoverageScopeCombo.getText() );

		boolean enableTransitionSelectionViewer = false;
		String toolTipText;

		switch ( fCoverageScope ) {
		case DETAILS:
			enableTransitionSelectionViewer = true;
			initTransitionTable();

			toolTipText = "Try to cover the selected transitions";
			break;

		case MODEL:
			toolTipText = "Try to cover once each model transition";
			break;

		case INSTANCE:
			toolTipText = "Try to cover once each model transition for each of its instances";
			break;

		default:
			toolTipText = "Try to cover transitions";
			break;
		}

		fConfigurationPage.propagateVisibility(
				fTransitionTraceElementTableViewer.getControl(),
				enableTransitionSelectionViewer);

		fCoverageScopeCombo.setToolTipText(toolTipText);

		fConfigurationPage.propagateGUIupdate();
	}


	private void initTransitionTable() {
		loadTransitionListToBeSelected();

 		fTransitionTraceElementTableViewer.removeAll();

		fTransitionTraceElementTableViewer.setInput(fAllTransitionCoverageElements);
	}

	public void handleModelFilePathChanged(String modelFilePath) {
		fModelFilePath = modelFilePath;

		// Force Re-initialization
		fAllTransitionCoverageElements = NO_TRANSITION;

		if( fOverviewAnalysisProfileSection.isTransitionCoverage()
			&& (fCoverageScope == CoverageScopeKind.DETAILS) )
		{
			updateTransitionTables();
		}
	}

	public void updateTransitionTables() {
		fTransitionTraceElementTableViewer.removeAll();

		if( fAllTransitionCoverageElements.length == 0 )
		{
			initTransitionTable();
		}
	}

	private void setAllTransition(List<TraceElement> allTransitionCoverageElements) {
		if( (allTransitionCoverageElements != null)
			&& (! allTransitionCoverageElements.isEmpty()) ) {

			fAllTransitionCoverageElements = allTransitionCoverageElements.toArray(
					new TraceElement[allTransitionCoverageElements.size()]);
		}
		else {
			fAllTransitionCoverageElements = NO_TRANSITION;
		}
	}

	private void loadTransitionListToBeSelected() {
		FormalMLXtextUtil xtextUtil = new FormalMLXtextUtil(fModelFilePath);

		if( xtextUtil.parser() ) {
			setAllTransition( xtextUtil.getAllTransitionCoverageElements());

			return;
		}
		else {
			fAllTransitionCoverageElements = NO_TRANSITION;
		}

		File modelFile =
				((fModelFilePath == null) || fModelFilePath.isEmpty()) ?
						null : new File( fModelFilePath );

		try {
			if( (modelFile != null) && modelFile.isFile() ) {
				List<TraceElement> allTransitions = new ArrayList<TraceElement>();

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
							allTransitions.add(new TraceElementCustomImpl(
									true, TraceElementKind.TRANSITION, transitionName));
							maxSizetransitionName = Math.max(
									maxSizetransitionName, transitionName.length() );
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
							allTransitions.add(new TraceElementCustomImpl(
									true, TraceElementKind.TRANSITION, transitionName));
							maxSizetransitionName = Math.max(
									maxSizetransitionName, transitionName.length() );
						}
					}
				}
				br.close();

				setAllTransition( allTransitions );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SCOPE,
				CoverageScopeKind.MODEL.getLiteral());

		configuration.setAttribute(ATTR_TRANSITION_COVERAGE_SELECTION, "");
	}

	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration)
	{
		fModelFilePath = WorkflowFileUtils.getAbsoluteLocation(
				configuration, ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
				DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);

		try {
			fCoverageScope = CoverageScopeKind.get(
					configuration.getAttribute(
							ATTR_TRANSITION_COVERAGE_SCOPE,
							CoverageScopeKind.MODEL.getLiteral()));
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		if( fCoverageScope == null ) {
			fCoverageScope = CoverageScopeKind.MODEL;
		}

		switch( fCoverageScope ) {
		case MODEL:
			fCoverageScopeCombo.select(0);
			break;
		case INSTANCE:
			fCoverageScopeCombo.select(1);
			break;
		case DETAILS:
			fCoverageScopeCombo.select(2);
			break;
		default:
			fCoverageScope = CoverageScopeKind.MODEL;
			fCoverageScopeCombo.select(0);
			break;
		}

		handleCoverageScopeSelectionChange();

		// DONT UNCOMMENT THAT CODE
//		fTransitionTraceElementTableViewer.initializeFrom(configuration);
	}


	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		fTransitionTraceElementTableViewer.performApply(configuration);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SCOPE, fCoverageScope.getLiteral());

		if( fOverviewAnalysisProfileSection.isTransitionCoverage() )
		{
			configuration.setAttribute(
					ATTR_SPECIFICATION_ANALYZE_STRATEGY, "WEIGHT_BFS");
		}
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		if( fCoverageScope == CoverageScopeKind.DETAILS )
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
		case ATTR_SPECIFICATION_MODEL_FILE_LOCATION:
			handleModelFilePathChanged( event.getNewValue().toString() );
			break;

		case ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE:
			switch ( (AnalysisProfileKind) event.getNewValue() ) {
			case ANALYSIS_TRANSITION_COVERAGE_PROFILE:
				if( fCoverageScope == CoverageScopeKind.DETAILS ) {
					initTransitionTable();
				}
				break;
			default:
				break;
			}
			break;

		default:
			break;
		}
	}

}
