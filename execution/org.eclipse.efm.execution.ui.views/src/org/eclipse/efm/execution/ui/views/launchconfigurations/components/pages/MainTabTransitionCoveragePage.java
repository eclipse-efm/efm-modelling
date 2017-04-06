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
package org.eclipse.efm.execution.ui.views.launchconfigurations.components.pages;

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
import org.eclipse.efm.execution.ui.views.editors.impls.BooleanFieldEditor;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationEditorComposite;
import org.eclipse.efm.execution.ui.views.utils.SWTFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class MainTabTransitionCoveragePage extends AbstractTabComponentPage {

	public BooleanFieldEditor fEnabledDetailedSelectionBooleanField;

	public Composite fCompDetailedSelection;

	private Table fAllTransitionsListTable;
	private TableColumn fAllTransitionsListTableColumn;

	private Table fSelectedTransitionsTable;
	private TableColumn fSelectedTransitionsTableColumn;

	private List< String > fAllTransitionsList;
	private List< String > fSelectedTransitionsList;

	private String fModelFilePath;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public MainTabTransitionCoveragePage(
			ILaunchConfigurationEditorComposite parentTab) {
		super(parentTab);

		fModelFilePath = null;
	}


	@Override
	public void createPageWithToolkit(Composite parentComposite, FormToolkit toolkit) {
		createExpandableFrameWithToolkit(parentComposite, toolkit, "Transition Coverage Page");
				
//				SWTFactory.createGroup(
//				fCompositeParent,
//				"&Selection of Transitions (default: all)",
//				1, 1, GridData.FILL_HORIZONTAL );

//		Composite comp = SWTFactory.createComposite(
//				fCompositeControl, 1, 1, GridData.FILL_HORIZONTAL);

		fEnabledDetailedSelectionBooleanField =
				new BooleanFieldEditor(fParentTab,
						ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION,
						"&Enable Transitions Selection", fCompositeControl, false);

// ==================================================================================

		fCompDetailedSelection = SWTFactory.createComposite(
				fCompositeControl, 2, 1,  GridData.FILL_HORIZONTAL);

//		IntegerFieldEditor test = new IntegerFieldEditor(this,
//				TestGenerationTab.ATTR_PROLONGATION_EVALUATION_STEPS,
//				"&Evaluation Steps:", fCompDetailedSelection, -1);
//		test = new IntegerFieldEditor(this,
//				TestGenerationTab.ATTR_PROLONGATION_EVALUATION_STEPS,
//				"&Evaluation Steps:", fCompDetailedSelection, -1);

		fAllTransitionsListTable = new Table(
				fCompDetailedSelection, SWT.CHECK | SWT.BORDER);
		fAllTransitionsListTableColumn =
				new TableColumn (fAllTransitionsListTable, SWT.NONE);
		fAllTransitionsListTableColumn.setText("Transitions List");
		fAllTransitionsListTable.setHeaderVisible(true);

		fSelectedTransitionsTable =
				new Table(fCompDetailedSelection, SWT.BORDER);
		fSelectedTransitionsTableColumn =
				new TableColumn(fSelectedTransitionsTable, SWT.NONE);
		fSelectedTransitionsTableColumn.setText("Selected transitions");
		fSelectedTransitionsTable.setHeaderVisible(true);

// ==================================================================================
/*
		fCompDetailedSelection = SWTFactory.createComposite(
				parent, 2, 1, GridData.FILL_HORIZONTAL);

		ScrolledComposite scrolledComposite1 = new ScrolledComposite(
				fCompDetailedSelection, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite1.setLayout(new GridLayout());
		scrolledComposite1.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		fAllTransitionsListTable = new Table(scrolledComposite1,
				SWT.CHECK | SWT.BORDER);
		fAllTransitionsListTable.setHeaderVisible(true);

		scrolledComposite1.setContent(fAllTransitionsListTable);
		scrolledComposite1.setExpandHorizontal(true);
		scrolledComposite1.setExpandVertical(true);
		scrolledComposite1.setMinSize(
				fAllTransitionsListTable.computeSize(SWT.DEFAULT, SWT.DEFAULT));


		ScrolledComposite scrolledComposite2 = new ScrolledComposite(
				fCompDetailedSelection, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite2.setLayout(new GridLayout());
		scrolledComposite2.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		fSelectedTransitionsTable = new Table(scrolledComposite2, SWT.BORDER);
		fSelectedTransitionsTable.setHeaderVisible(true);

		scrolledComposite2.setContent(fSelectedTransitionsTable);
		scrolledComposite2.setExpandHorizontal(true);
		scrolledComposite2.setExpandVertical(true);
		scrolledComposite2.setMinSize(
				fSelectedTransitionsTable.computeSize(
						SWT.DEFAULT, SWT.DEFAULT));

		fAllTransitionsListTableColumn =
		 		new TableColumn(fAllTransitionsListTable, SWT.NONE);
		fAllTransitionsListTableColumn.setText("Transitions to be selected");
		fAllTransitionsListTableColumn.setWidth(10);

		fSelectedTransitionsTableColumn =
				new TableColumn(fSelectedTransitionsTable, SWT.NONE);
		fSelectedTransitionsTableColumn.setText("Selected transitions");
		fSelectedTransitionsTableColumn.setWidth(10);

*/

// ==================================================================================

		int listHeight = fAllTransitionsListTable.getItemHeight() * 10;
		Rectangle trim =
				fAllTransitionsListTable.computeTrim(0, 0, 0, listHeight);

		GridData gridDataLeft = new GridData();
		gridDataLeft.heightHint = trim.height;
		gridDataLeft.horizontalIndent = 0;
		gridDataLeft.verticalIndent = 10;
		fAllTransitionsListTable.setLayoutData(gridDataLeft);

		GridData gridDataRight = new GridData();
		gridDataRight.heightHint = trim.height;
		gridDataRight.horizontalIndent = 0;
		gridDataRight.verticalIndent = 10;
		fSelectedTransitionsTable.setLayoutData(gridDataRight);

		fAllTransitionsListTable.addSelectionListener(
			new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					boolean refresh = false;

					if( e.item instanceof TableItem )
					{
						TableItem selectedItem = (TableItem)( e.item );

						String strItem = selectedItem.getText();

						if( selectedItem.getChecked() )
						{
							if( ! fSelectedTransitionsList.contains(strItem) )
							{
								fSelectedTransitionsList.add(strItem);
								refresh = true;
							}
						}
						else if( fSelectedTransitionsList.contains(strItem) )
						{
							fSelectedTransitionsList.remove(strItem);
							refresh = true;
						}
					}

					if( refresh ) {
						fSelectedTransitionsList.sort(null);

						fSelectedTransitionsTable.removeAll();

						for(int i = 0; i < fSelectedTransitionsList.size(); i++)
						{
							TableItem item = new TableItem(
									fSelectedTransitionsTable, SWT.NONE);

							item.setText( fSelectedTransitionsList.get(i) );
						}
					}

					fParentTab.propagateGUIupdate();
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
			    	  fParentTab.propagateGUIupdate();
				}
			});

		fSelectedTransitionsTable.addMouseListener( new MouseListener() {
			@Override
			public void mouseUp(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				String strItem2;
				for( int index : fSelectedTransitionsTable.getSelectionIndices() )
				{
					strItem2 = fSelectedTransitionsTable.getItem(index).getText();

					for( TableItem tableItem1 : fAllTransitionsListTable.getItems() )
					{
						if( tableItem1.getText().equals(strItem2) )
						{
							fSelectedTransitionsList.remove(strItem2);

							tableItem1.setChecked(false);

							fSelectedTransitionsTable.remove(index);

							fParentTab.propagateGUIupdate();

							break;
						}
					}
				}
			}
		});
	}


//	@Override
//	public void setVisible(boolean visible) {
//		fParentTab.propagateVisibility(fCompositeControl,visible);
//
//		if( visible ) {
//			if( fEnabledDetailedSelectionBooleanField.getBooleanValue() )
//			{
//				fParentTab.propagateVisibility(fCompDetailedSelection, true);
//			}
//			else {
//				fParentTab.propagateVisibility(fCompDetailedSelection, false);
//			}
//		}
//	}

	private void initTransitionTable() {
		loadTransitionListToBeSelected();

		fAllTransitionsListTable.removeAll();

		for(int i = 0; i < fAllTransitionsList.size(); i++) {
			TableItem item = new TableItem(fAllTransitionsListTable, SWT.NONE);
			item.setChecked(false);
			item.setText( fAllTransitionsList.get(i) );
		}
	}

	public void handleModelFilePathChanged(String modelFilePath) {
		fModelFilePath = modelFilePath;

		// Force Re-initialization
		fAllTransitionsList = null;

		updateTransitionTables();
	}

	public void updateTransitionTables() {
		fSelectedTransitionsTable.removeAll();

		if( (fAllTransitionsList == null)
			|| fAllTransitionsList.isEmpty() )
		{
			initTransitionTable();
		}

		if( (fAllTransitionsList != null)
			&& (! fAllTransitionsList.isEmpty())
			&& (! fSelectedTransitionsList.isEmpty()) )
		{
			for(int i = 0; i < fSelectedTransitionsList.size(); i++)
			{
	    		TableItem item = new TableItem(
	    				fSelectedTransitionsTable, SWT.NONE);

	    		item.setText( fSelectedTransitionsList.get(i) );
			}


			for(int i = 0; i < fAllTransitionsList.size(); i++)
			{
				if( fSelectedTransitionsList.contains(
						fAllTransitionsList.get(i)) )
				{
					fAllTransitionsListTable.getItem( i ).setChecked(true);
				}
			}
		}
		else {
//			fSelectedTransitionsList.clear();
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

				if( maxSizetransitionName <= 30 ) {
					fAllTransitionsListTableColumn.setWidth(200);
					fSelectedTransitionsTableColumn.setWidth(200);
				}
//				else if( maxSizetransitionName <= 60 ) {
//					fAllTransitionsListTableColumn.setWidth(
//							maxSizetransitionName * 9 + 30);
//					fSelectedTransitionsTableColumn.setWidth(
//							maxSizetransitionName * 9 + 10);
//				}
				else {
//					fAllTransitionsListTableColumn.setWidth(700);
					fAllTransitionsListTableColumn.setWidth(
							maxSizetransitionName * 9 + 30);

//					fSelectedTransitionsTableColumn.setWidth(700);
					fSelectedTransitionsTableColumn.setWidth(
							maxSizetransitionName * 9 + 10);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration)
	{
//		fEnabledDetailedSelectionBooleanField.setDefaults(configuration);
		configuration.setAttribute(
				ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SELECTION, new ArrayList<String>());

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration)
	{
		try {
			fModelFilePath = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
					DEFAULT_SPECIFICATION_MODEL_FILE_LOCATION);
		}
		catch( CoreException e2 ) {
			fModelFilePath = null;
			e2.printStackTrace();
		}

		fEnabledDetailedSelectionBooleanField.initializeFrom(configuration);

		fParentTab.propagateVisibility(fCompDetailedSelection,
				fEnabledDetailedSelectionBooleanField.getBooleanValue());

		try {
			fSelectedTransitionsList = new ArrayList<String>();

			fSelectedTransitionsList.addAll(
					configuration.getAttribute(
							ATTR_TRANSITION_COVERAGE_SELECTION,
							new ArrayList<String>()) );
		}
		catch( CoreException e ) {
			e.printStackTrace();

			fSelectedTransitionsList = new ArrayList<String>();
		}

		updateTransitionTables();
	}


	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration)
	{
		fEnabledDetailedSelectionBooleanField.performApply(configuration);

		fParentTab.propagateVisibility(fCompDetailedSelection,
				fEnabledDetailedSelectionBooleanField.getBooleanValue());


		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SELECTION, fSelectedTransitionsList);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if( fEnabledDetailedSelectionBooleanField.getBooleanValue()
			&& ( fSelectedTransitionsList.size() == 0 ) )
		{
			setErrorMessage("You must select at least one transition");

			return false;
		}

		return true;
	}

}
