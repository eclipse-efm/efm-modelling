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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.efm.execution.core.workflow.common.GraphExplorationStrategyKind;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class OverviewExplorationConfigurationProfile extends AbstractConfigurationProfile {

	private Group groupAnalyzeStrategy;

	private Button fBFSButton = null;
	private Button fDFSButton = null;
	private Button fRFSButton = null;

	private GraphExplorationStrategyKind fAnalyzeStrategy =
		GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;

	private Group groupInclusionCriterion;

	
	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewExplorationConfigurationProfile(AbstractConfigurationPage configurationPage) {
		super(configurationPage);
	}


	@Override
	public String getSectionTitle() {
		return "Model Exploration";
	}

	@Override
	public String getSectionDescription() {
		return "Choose an exploration strategy and "
				+ "set a limitation in Supervisor Tab";
	}

	
	
	private final class TabListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			Object source = e.getSource();

			// Use case Analysis
			if (source == fBFSButton) {
				handleBFSButtonSelected();
			}
			else if (source == fDFSButton) {
				handleDFSButtonSelected();
			}
			else if (source == fRFSButton) {
				handleRFSButtonSelected();
			}
		}
	}

	private TabListener fListener= new TabListener();


	// ======================================================================================
	//                              Buttons handling
	// ======================================================================================

	public void handleBFSButtonSelected() {
		if( fBFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
		}
		fConfigurationPage.propagateGUIupdate();
	}

	public void handleDFSButtonSelected() {
		if( fDFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.DEPTH_FIRST_SEARCH;
		}
		fConfigurationPage.propagateGUIupdate();
	}

	public void handleRFSButtonSelected() {
		if( fRFSButton.getSelection() ) {
			fAnalyzeStrategy = GraphExplorationStrategyKind.RANDOM_FIRST_SEARCH;
		}
		fConfigurationPage.propagateGUIupdate();
	}


		
	@Override
	protected void createContent(Composite parent, IWidgetToolkit widgetToolkit)
	{
		createAnalyzeStrategy(parent, widgetToolkit);
		createControlInclusionCriterion(parent, widgetToolkit);
	}

	private void createControlInclusionCriterion(Composite parent, IWidgetToolkit widgetToolkit) {
        groupInclusionCriterion = widgetToolkit.createGroup(parent,
        		"Inclusion Criterion", 5, 2, GridData.FILL_HORIZONTAL);

        Composite comp = widgetToolkit.createComposite(
        		groupInclusionCriterion, 1, 1, GridData.FILL_HORIZONTAL);

        BooleanFieldEditor applyInclusionBooleanField =
        		new BooleanFieldEditor(this.fConfigurationPage,
        		ATTR_ENABLED_INCLUSION_CRITERION, "&Apply Inclusion", comp, false);
        addField(applyInclusionBooleanField);
	}


	protected void createAnalyzeStrategy(Composite parent, IWidgetToolkit widgetToolkit) {
		groupAnalyzeStrategy = widgetToolkit.createGroup(
				parent, "&Analyze Strategy", 3, 1, GridData.FILL_HORIZONTAL);

		fBFSButton = widgetToolkit.createRadioButton(groupAnalyzeStrategy, "&BFS");
		fBFSButton.addSelectionListener(fListener);
		fBFSButton.setToolTipText("Breadth First Search");

		fDFSButton = widgetToolkit.createRadioButton(groupAnalyzeStrategy, "&DFS");
		fDFSButton.addSelectionListener(fListener);
		fDFSButton.setToolTipText("Depth First Search");

		fRFSButton = widgetToolkit.createRadioButton(groupAnalyzeStrategy, "&RFS");
		fRFSButton.addSelectionListener(fListener);
		fRFSButton.setToolTipText("Random First Search");
	}


	@Override
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(ATTR_SPECIFICATION_ANALYZE_STRATEGY, "BFS");

		configuration.setAttribute(ATTR_ENABLED_INCLUSION_CRITERION, false);
	}

	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration)
	{
		// Case Analyze Strategy
		//
		try {
			fAnalyzeStrategy = GraphExplorationStrategyKind.get(
					configuration.getAttribute(
							ATTR_SPECIFICATION_ANALYZE_STRATEGY,
							GraphExplorationStrategyKind.
									BREADTH_FIRST_SEARCH.getLiteral()) );
		} catch (CoreException e) {
			e.printStackTrace();
		}
		finally {
			if( fAnalyzeStrategy == null ) {
				fAnalyzeStrategy = GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
			}
		}

		initializeAnalyzeStrategy();
	}

	
	private void initializeAnalyzeStrategy() {
		fBFSButton.setSelection(false);
		fDFSButton.setSelection(false);
		fRFSButton.setSelection(false);

		switch( fAnalyzeStrategy ) {
		case BREADTH_FIRST_SEARCH:
			fBFSButton.setSelection(true);
			break;
		case DEPTH_FIRST_SEARCH:
			fDFSButton.setSelection(true);
			break;
		case RANDOM_FIRST_SEARCH:
			fRFSButton.setSelection(true);
			break;
		default:
			fBFSButton.setSelection(true);
			
			fAnalyzeStrategy =
					GraphExplorationStrategyKind.BREADTH_FIRST_SEARCH;
			break;
		}
	}



	@Override
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_SPECIFICATION_ANALYZE_STRATEGY,
				fAnalyzeStrategy.getLiteral());
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		return true;
	}

}
