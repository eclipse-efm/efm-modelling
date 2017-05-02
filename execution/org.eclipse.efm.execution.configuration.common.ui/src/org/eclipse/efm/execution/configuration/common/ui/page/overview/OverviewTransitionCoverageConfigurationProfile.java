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
import org.eclipse.efm.execution.configuration.common.ui.editors.BooleanFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class OverviewTransitionCoverageConfigurationProfile extends AbstractConfigurationProfile {

	public BooleanFieldEditor fEnabledDetailedSelectionBooleanField;

	public Composite fCompDetailedSelection;

	private Table fModelTransitionsTable;
	private TableColumn fModelTransitionsTableColumn;

	private Table fSelectedTransitionsTable;
	private TableColumn fSelectedTransitionsTableColumn;

	private List< String > fAllTransitionsList;
	private List< String > fSelectedTransitionsList;

	private String fModelFilePath;


	/**
	 * Constructor
	 * @param parentTab
	 */
	public OverviewTransitionCoverageConfigurationProfile(AbstractConfigurationPage configurationPage) {
		super(configurationPage);

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
		addField(fEnabledDetailedSelectionBooleanField);

		fEnabledDetailedSelectionBooleanField.addSelectionListener(
			new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					handleEnablingDetailedSelection();
				}
			});

// ==================================================================================

		fCompDetailedSelection = widgetToolkit.createComposite(
				parent, 2, 1,  GridData.FILL_HORIZONTAL);

		fModelTransitionsTable = new Table(
				fCompDetailedSelection, SWT.CHECK | SWT.BORDER);
		fModelTransitionsTableColumn =
				new TableColumn (fModelTransitionsTable, SWT.NONE);
		fModelTransitionsTableColumn.setText("Model Transitions");
		fModelTransitionsTable.setHeaderVisible(true);
		
		fSelectedTransitionsTable =
				new Table(fCompDetailedSelection, SWT.BORDER);
		fSelectedTransitionsTableColumn =
				new TableColumn(fSelectedTransitionsTable, SWT.NONE);
		fSelectedTransitionsTableColumn.setText("Selected transitions");
		fSelectedTransitionsTable.setHeaderVisible(true);

		int listHeight = fModelTransitionsTable.getItemHeight() * 10;
		Rectangle trim = fModelTransitionsTable.computeTrim(0, 0, 0, listHeight);

		GridData gridDataLeft = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridDataLeft.heightHint = trim.height;
		gridDataLeft.horizontalIndent = 0;
		gridDataLeft.verticalIndent = 10;
		fModelTransitionsTable.setLayoutData(gridDataLeft);

		GridData gridDataRight = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridDataRight.heightHint = trim.height;
		gridDataRight.horizontalIndent = 0;
		gridDataRight.verticalIndent = 10;
		fSelectedTransitionsTable.setLayoutData(gridDataRight);

		fModelTransitionsTable.addSelectionListener(
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

					fConfigurationPage.propagateGUIupdate();
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
			    	  fConfigurationPage.propagateGUIupdate();
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

					for( TableItem tableItem1 : fModelTransitionsTable.getItems() )
					{
						if( tableItem1.getText().equals(strItem2) )
						{
							fSelectedTransitionsList.remove(strItem2);

							tableItem1.setChecked(false);

							fSelectedTransitionsTable.remove(index);

							fConfigurationPage.propagateGUIupdate();

							break;
						}
					}
				}
			}
		});
	}


	private void handleEnablingDetailedSelection() {
		fConfigurationPage.propagateVisibility(fCompDetailedSelection,
				fEnabledDetailedSelectionBooleanField.getBooleanValue());
	}


	private void initTransitionTable() {
		loadTransitionListToBeSelected();

		fModelTransitionsTable.removeAll();

		for(int i = 0; i < fAllTransitionsList.size(); i++) {
			TableItem item = new TableItem(fModelTransitionsTable, SWT.NONE);
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
			&& (fSelectedTransitionsList != null)
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
					fModelTransitionsTable.getItem( i ).setChecked(true);
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
					fModelTransitionsTableColumn.setWidth(200);
					fSelectedTransitionsTableColumn.setWidth(200);
				}
//				else if( maxSizetransitionName <= 60 ) {
//					fModelTransitionsTableColumn.setWidth(
//							maxSizetransitionName * 9 + 30);
//					fSelectedTransitionsTableColumn.setWidth(
//							maxSizetransitionName * 9 + 10);
//				}
				else {
//					fModelTransitionsTableColumn.setWidth(700);
					fModelTransitionsTableColumn.setWidth(
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
	protected void setDefaultsImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_ENABLED_TRANSITION_COVERAGE_DETAILS_SELECTION, false);

		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SELECTION, new ArrayList<String>());
	}

	@Override
	protected void initializeFromImpl(ILaunchConfiguration configuration)
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

		handleEnablingDetailedSelection();

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
	protected void performApplyImpl(ILaunchConfigurationWorkingCopy configuration)
	{
		configuration.setAttribute(
				ATTR_TRANSITION_COVERAGE_SELECTION, fSelectedTransitionsList);
	}

	@Override
	protected boolean isValidImpl(ILaunchConfiguration launchConfig) {
		if( fEnabledDetailedSelectionBooleanField.getBooleanValue()
			&& ( fSelectedTransitionsList.size() == 0 ) )
		{
			setErrorMessage("You must select at least one transition");

			return false;
		}

		return true;
	}

}
