/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial Implementation (tab-based, inserted in Run Configurations dialog)
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - New API (free-composite-based, no type assumptions on parent) 
 *******************************************************************************/

package org.eclipse.efm.execution.ui.views.launchconfigurations.components;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.core.Activator;
import org.eclipse.efm.execution.ui.views.editors.impls.BooleanFieldEditor;
import org.eclipse.efm.execution.ui.views.launchconfigurations.components.AbstractTabItemContentCreator.FieldValidationReturn;
import org.eclipse.efm.execution.ui.views.utils.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.ui.views.utils.SWTFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class NonRegressionTabItemContentCreator extends AbstractTabItemContentCreator {

	public static final String ATTR_ENABLED_NON_REGRESSION =
			Activator.PLUGIN_ID + ".ATTR_ENABLED_NON_REGRESSION"; //$NON-NLS-1$

	public static final String ATTR_SPECIFICATION_PROJECT_NAME =
			Activator.PLUGIN_ID + ".ATTR_SPECIFICATION_PROJECT_NAME"; //$NON-NLS-1$

	public static final String ATTR_SPECIFICATION_MODEL_FILE_LOCATION =
			Activator.PLUGIN_ID + ".ATTR_SPECIFICATION_MODEL_FILE_LOCATION"; //$NON-NLS-1$

	public static final String ATTR_BASIC_TRANSITION_BUTTON =
			Activator.PLUGIN_ID + ".ATTR_BASIC_TRANSITION_BUTTON"; //$NON-NLS-1$

	public static final String ATTR_SELECTED_TRANSITIONS =
			Activator.PLUGIN_ID + ".ATTR_SELECTED_TRANSITIONS"; //$NON-NLS-1$


    private BooleanFieldEditor fNonRegressionBooleanField;

    private String fProjectName;
    private Text fModelPathText;
    private String currentModelPath = "";
    private Button fModelWorkspaceBrowse;

    private String specMainFileLocation = "<model file location>";

	private Composite compNonRegressionCaseButton;

	private Composite compNonRegressionCaseCoverage;
//	private ScrolledComposite scrolledComposite1;
//	private ScrolledComposite scrolledComposite2;

	private Button fAllNonRegressionCaseButton = null;
	private Button fDetailsNonRegressionCaseButton = null;
	private String fNonRegressionCaseButton = "All";

	private Table fNonRegressionCaseTable1;
	private TableColumn colonne1;
	private Table fNonRegressionCaseTable2;
	private TableColumn colonne2;

//	private Table transitionsToBeSelectedTable;
//	private Table selectedTransitionsTable;
	private List< String > transitionsToBeSelected;
	private List< String > selectedTransitions;

	public NonRegressionTabItemContentCreator(ILaunchConfigurationGUIelement masterGUIelement, Composite parentComposite) {
		super(masterGUIelement, parentComposite);
	}
	
	private class TabListener extends SelectionAdapter implements ModifyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		@Override
		public void modifyText(ModifyEvent e) {
			propagateGUIupdate();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			Object source = e.getSource();

			if(source == fAllNonRegressionCaseButton) {
				handleAllTransitionButtonSelected();
			}
			else if(source == fDetailsNonRegressionCaseButton) {
				handleDetailedTransitionSelected();
			}
		}
	}

	private TabListener fListener = new TabListener();

	// ======================================================================================
	//                              Miscellaneous handling
	// ======================================================================================	
	
	public void handleSelectedTransition() {

		boolean refresh = false;
        for(int i = 0; i < transitionsToBeSelected.size(); i++) {
        	if( fNonRegressionCaseTable1.getItem(i).getChecked() ) {
        		if( ! selectedTransitions.contains( transitionsToBeSelected.get(i) ) ) {
        			selectedTransitions.add( transitionsToBeSelected.get(i) );
        			refresh = true;
        		}
        	}
        	else if( selectedTransitions.contains( transitionsToBeSelected.get(i) ) ) {
        		selectedTransitions.remove( transitionsToBeSelected.get(i) );
        		refresh = true;
        	}
        }
        if( refresh ) {
            selectedTransitions.sort(null);
    		updateTransitionTable2();
        }

        propagateGUIupdate();
	}

	public void handleAllTransitionButtonSelected() {
		if( fAllNonRegressionCaseButton.getSelection() ) {
			fNonRegressionCaseButton = "All";
			propagateVisibility(compNonRegressionCaseCoverage,false);
		}
		propagateGUIupdate();
	}

	public void handleDetailedTransitionSelected() {
		if( fDetailsNonRegressionCaseButton.getSelection() ) {
			fNonRegressionCaseButton = "Details";
			propagateVisibility(compNonRegressionCaseCoverage,true);
		}
		propagateGUIupdate();
	}

	/**
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent evt) {
			propagateUpdateJobScheduling();
		}
	};	
	
	
	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================
	
	@Override
	public void createTabItemContent() {
//		inner_main_composite = SWTFactory.createComposite(parent,
//				parent.getFont(), 1, 1, GridData.FILL_HORIZONTAL, 0, 0);
		createNonRegressionSelectionComponent(getParentComposite());
		createModelFileSelectionComponent(getParentComposite());
		createAnalyseProfileComponent(getParentComposite());
	}


	private void createNonRegressionSelectionComponent(Composite parent) {
        Group group = SWTFactory.createGroup(parent,
        		"Non Regression", 1, 1, GridData.FILL_HORIZONTAL);

        Composite comp = SWTFactory.createComposite(
        		group, 1, 1, GridData.FILL_HORIZONTAL);

        fNonRegressionBooleanField = new BooleanFieldEditor(this,
        		ATTR_ENABLED_NON_REGRESSION,
        		"&Non Regression Execution", comp, false);
	}

	private void createModelFileSelectionComponent(Composite parent) {
		Group group = SWTFactory.createGroup(
				parent, "Non Regression Folder Selection",
				5, 1, GridData.FILL_HORIZONTAL);
		Composite comp = SWTFactory.createComposite(
				group, group.getFont(), 5, 5, GridData.FILL_BOTH, 0, 0);

		fModelPathText = SWTFactory.createSingleText(comp, 4);
		fModelPathText.getAccessible().addAccessibleListener(
				new AccessibleAdapter() {
					@Override
					public void getName(AccessibleEvent e) {
						e.result = "Non Regression Folder";
					}
				});
		fModelPathText.addModifyListener(fBasicModifyListener);

		Composite bcomp = SWTFactory.createComposite(comp,
				3, 5, GridData.HORIZONTAL_ALIGN_END);
		GridLayout ld = (GridLayout)bcomp.getLayout();
		ld.marginHeight = 1;
		ld.marginWidth = 0;

		fModelWorkspaceBrowse = SWTFactory.createPushButton(bcomp, "&Workspace...", null);	
		fModelWorkspaceBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementTreeSelectionDialog dialog =
						new ElementTreeSelectionDialog(parent.getShell(),
								new WorkbenchLabelProvider(),
								new WorkbenchContentProvider());
				dialog.setTitle("Select a &Diversity Specification:");
				dialog.setMessage("Select a resource to redirect output to:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.setComparator(
						new ResourceComparator(ResourceComparator.NAME));
//				dialog.setDialogBoundsSettings(
//						getDialogBoundsSettings(WORKSPACE_SELECTION_DIALOG),
//						Dialog.DIALOG_PERSISTSIZE);

				if(dialog.open() == Window.OK) {
					IResource resource = (IResource) dialog.getFirstResult();
					if(resource != null) {
						fProjectName = resource.getProject().getName();

						String specFile = resource.getLocation().toString();
						fModelPathText.setText(specFile);
					}
				}

//				org.eclipse.ui.dialogs.ResourceSelectionDialog dialog =
//						new ResourceSelectionDialog(getShell(),
//								ResourcesPlugin.getWorkspace().getRoot(),
//								"Select a &Diversity Specification:");
//
//				if(dialog.open() == Window.OK) {
//					Object[] results = dialog.getResult();
//					if(results == null || results.length < 1) {
//						return;
//					}
//					else if( results[0] instanceof IPath ) {
//						IPath path = (IPath)results[0];
//						String specFile = path.toString();
//						fModelPathText.setText(specFile);
//					}
//				}
			}
		});

//		fFileBrowse = createPushButton(bcomp, "File &System...", null);
//		fFileBrowse.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				String filePath = fModelPathText.getText();
//				org.eclipse.swt.widgets.FileDialog dialog =
//						new FileDialog(getShell(), SWT.SAVE);
//				filePath = dialog.open();
//				if(filePath != null) {
//					fModelPathText.setText(filePath);
//				}
//			}
//		});
//		fVariables = createPushButton(bcomp, "Variables...", null);
//		fVariables.addSelectionListener(new SelectionListener() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				StringVariableSelectionDialog dialog =
//						new StringVariableSelectionDialog(getShell());
//				dialog.open();
//				String variable = dialog.getVariableExpression();
//				if(variable != null) {
//					fModelPathText.insert(variable);
//				}
//			}
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {}
//		});

	}

	protected void createAnalyseProfileComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"&Non Regression Profile", 2, 1, GridData.FILL_HORIZONTAL);

		Composite comp = SWTFactory.createComposite(
				group, 1, 2, GridData.FILL_HORIZONTAL);

		createNonRegressionListComponent(comp);

	}

	private void createNonRegressionListComponent(Composite parent) {
		compNonRegressionCaseButton = SWTFactory.createComposite(parent, 1, 1,
				GridData.FILL_HORIZONTAL);
		GridData gridData1 = new GridData();
		gridData1.horizontalIndent = 50;
		compNonRegressionCaseButton.setLayoutData(gridData1);

		SWTFactory.createLabel(compNonRegressionCaseButton,
				"&Non Regression Case To Be Covered", 1);

		Composite comp = SWTFactory.createComposite(
				compNonRegressionCaseButton, 2, 1, GridData.FILL_HORIZONTAL);
		fAllNonRegressionCaseButton =
				SWTFactory.createRadioButton(comp, "&All");
		fAllNonRegressionCaseButton.addSelectionListener(fListener);
		fAllNonRegressionCaseButton.setToolTipText(
				"All transitions must be covered");

		fDetailsNonRegressionCaseButton =
				SWTFactory.createRadioButton(comp, "&Details");
		fDetailsNonRegressionCaseButton.addSelectionListener(fListener);
		fDetailsNonRegressionCaseButton.setToolTipText(
				"Select a detailed list of transitions to be covered");

		fAllNonRegressionCaseButton.setSelection(false);
		fDetailsNonRegressionCaseButton.setSelection(false);




// ==================================================================================


		compNonRegressionCaseCoverage = SWTFactory.createComposite(parent, 2, 1,
				GridData.FILL_HORIZONTAL);

		fNonRegressionCaseTable1 = new Table(compNonRegressionCaseCoverage,
				SWT.CHECK | SWT.BORDER);
		colonne1 = new TableColumn (fNonRegressionCaseTable1,
				SWT.NONE);
		colonne1.setText("Transitions to be selected");
		fNonRegressionCaseTable1.setHeaderVisible(true);

		fNonRegressionCaseTable2 = new Table(compNonRegressionCaseCoverage,
				SWT.BORDER);
		colonne2 = new TableColumn(fNonRegressionCaseTable2,
				SWT.NONE);
		colonne2.setText("Selected transitions");
		fNonRegressionCaseTable2.setHeaderVisible(true);


// ==================================================================================
/*
		compTransitionCoverage = SWTFactory.createComposite(parent, 2, 1,
				GridData.FILL_HORIZONTAL);

		scrolledComposite1 = new ScrolledComposite(compTransitionCoverage,
				SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite1.setLayout(new GridLayout());
        scrolledComposite1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        fTransitionTable1 = new Table(scrolledComposite1,
        		SWT.CHECK | SWT.BORDER);
        fTransitionTable1.setHeaderVisible(true);

        scrolledComposite1.setContent(fTransitionTable1);
        scrolledComposite1.setExpandHorizontal(true);
        scrolledComposite1.setExpandVertical(true);
        scrolledComposite1.setMinSize(fTransitionTable1.computeSize(SWT.DEFAULT, SWT.DEFAULT));


        scrolledComposite2 = new ScrolledComposite(compTransitionCoverage,
        		SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite2.setLayout(new GridLayout());
        scrolledComposite2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        fTransitionTable2 = new Table(scrolledComposite2,
        		SWT.BORDER);
        fTransitionTable2.setHeaderVisible(true);

        scrolledComposite2.setContent(fTransitionTable2);
        scrolledComposite2.setExpandHorizontal(true);
        scrolledComposite2.setExpandVertical(true);
        scrolledComposite2.setMinSize(fTransitionTable2.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        colonne1 = new TableColumn(fTransitionTable1, SWT.NONE);
        colonne1.setText("Transitions to be selected");
        colonne1.setWidth(10);

        colonne2 = new TableColumn(fTransitionTable2, SWT.NONE);
        colonne2.setText("Selected transitions");
        colonne2.setWidth(10);

*/

// ==================================================================================





		int listHeight = fNonRegressionCaseTable1.getItemHeight() * 10;
		Rectangle trim = fNonRegressionCaseTable1.computeTrim(0, 0, 0, listHeight);

		GridData gridDataLeft = new GridData();
		gridDataLeft.heightHint = trim.height;
		gridDataLeft.horizontalIndent = 0;
		gridDataLeft.verticalIndent = 10;
		fNonRegressionCaseTable1.setLayoutData(gridDataLeft);

		GridData gridDataRight = new GridData();
		gridDataRight.heightHint = trim.height;
		gridDataRight.horizontalIndent = 0;
		gridDataRight.verticalIndent = 10;
		fNonRegressionCaseTable2.setLayoutData(gridDataRight);

		fNonRegressionCaseTable1.addSelectionListener( new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		  		boolean refresh = false;
		        for(int i = 0; i < transitionsToBeSelected.size(); i++) {
		        	if( fNonRegressionCaseTable1.getItem(i).getChecked() ) {
		        		if( ! selectedTransitions.contains( transitionsToBeSelected.get(i) ) ) {
		        			selectedTransitions.add( transitionsToBeSelected.get(i) );
		        			refresh = true;
		        		}
		        	}
		        	else if( selectedTransitions.contains( transitionsToBeSelected.get(i) ) ) {
		        		selectedTransitions.remove( transitionsToBeSelected.get(i) );
		        		refresh = true;
		        	}
		        }
		        if( refresh ) {
		            selectedTransitions.sort(null);
		    		updateTransitionTable2();
		        }
		        propagateGUIupdate();
		      }

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				propagateGUIupdate();
			}
		});
	}

	private void initTransitionTable() {
		createTransitionToBeSelectedList();

		fNonRegressionCaseTable1.removeAll();

		for(int i = 0; i < transitionsToBeSelected.size(); i++) {
	    	TableItem item = new TableItem(fNonRegressionCaseTable1, SWT.NONE);
		    item.setChecked(false);
//		    item.setText(transitionNameList.get(i));
		    item.setText(new String[] {transitionsToBeSelected.get(i),""});
        }
	}

	private void updateTransitionTable2() {
		fNonRegressionCaseTable2.removeAll();

		for(int i = 0; i < transitionsToBeSelected.size(); i++) {
	    	TableItem item = new TableItem(fNonRegressionCaseTable2, SWT.NONE);

		    if(i < selectedTransitions.size() ) {
			    item.setText(new String[] {selectedTransitions.get(i)});
		    }
		    else {
			    item.setText(new String[] {""});
		    }
        }
	}

	private void createTransitionToBeSelectedList() {

		String pathFile = fModelPathText.getText();

		transitionsToBeSelected = new ArrayList<String>();
//		selectedTransitions = new ArrayList<String>();

		try {
			if( (! pathFile.equals("<model file location>")) &&
				 (! pathFile.equals("")) ) {
				InputStream ips;
					ips = new FileInputStream(pathFile);
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);

				String ligne;
				String transitionName = "";
				int maxSizetransitionName = 0;
				while ((ligne=br.readLine())!=null){
					// Case
					// 		transition <prior:x> transitionName { ...
					// 		transition transitionName --> stateName { ...
					//
					if( ligne.contains("transition ") ) {
						ligne = ligne.replaceAll("\t", "");
						ligne = ligne.replaceAll("transition ", "");
						ligne = ligne.replaceAll("<prior:1> ", "");
						ligne = ligne.replaceAll("<prior:1 > ", "");
						ligne = ligne.replaceAll("<prior:3> ", "");
						ligne = ligne.replaceAll("<prior:3 > ", "");
						if( ligne.contains("-->") ) {
							ligne = ligne.substring(0, ligne.indexOf("-->"));
						}
						else if( ligne.contains("{") ) {
							ligne = ligne.substring(0, ligne.indexOf("{"));
						}
						else {
							transitionName = "transition_name_not_found";
						}
						transitionName = ligne.replaceAll(" ", "");

						if( transitionName.length() == 0 ) {
							// transition_name_empty
						}
						else {
							transitionsToBeSelected.add(transitionName);
							maxSizetransitionName = Math.max(
								maxSizetransitionName, transitionName.length() );
						}
					}
					// Other Case
					// 		transitionName --> stateName { ...
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
							transitionsToBeSelected.add(transitionName);
							maxSizetransitionName = Math.max(
								maxSizetransitionName, transitionName.length() );
						}
					}
				}
				br.close();
				transitionsToBeSelected.sort(null);

				if( maxSizetransitionName <= 30 ) {
					colonne1.setWidth(200);
					colonne2.setWidth(200);
				}
//				else if( maxSizetransitionName <= 60 ) {
//					colonne1.setWidth(maxSizetransitionName * 9 + 30);
//					colonne2.setWidth(maxSizetransitionName * 9 + 10);
//				}
//				else {
//					colonne1.setWidth(700);
//					colonne2.setWidth(700);
//				}
				else {
					colonne1.setWidth(maxSizetransitionName * 9 + 30);
					colonne2.setWidth(maxSizetransitionName * 9 + 10);
				}
}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================	
	
	@Override
	public void setDefaultFieldValues(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, "<project location>");

		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION, "<model file location>");

		configuration.setAttribute(
				ATTR_BASIC_TRANSITION_BUTTON, "All");

		configuration.setAttribute(
				ATTR_SELECTED_TRANSITIONS, new ArrayList<String>());
	}

	@Override
	public void initializeFieldValuesFrom(ILaunchConfiguration configuration) {
		try {
			fNonRegressionBooleanField.initializeFrom(configuration);

			fProjectName = configuration.getAttribute(
					ATTR_SPECIFICATION_PROJECT_NAME, "");

			specMainFileLocation = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_FILE_LOCATION,
					"<model file location>");
			fModelPathText.setText(specMainFileLocation);
			if( ! fModelPathText.getText().equals(currentModelPath) ) {
				currentModelPath = fModelPathText.getText();
				initTransitionTable();
			}

			fNonRegressionCaseButton = configuration.getAttribute(
					ATTR_BASIC_TRANSITION_BUTTON, "All");
			initializeTransitionOption(configuration);

			selectedTransitions = new ArrayList<String>();
			selectedTransitions.addAll( configuration.getAttribute(
					ATTR_SELECTED_TRANSITIONS, new ArrayList<String>()) );
			updateTransitionTable2();

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initializeTransitionOption(ILaunchConfiguration configuration) {
		switch ( fNonRegressionCaseButton ) {
		case "All":
			fAllNonRegressionCaseButton.setSelection(true);
			fDetailsNonRegressionCaseButton.setSelection(false);
			propagateVisibility(compNonRegressionCaseCoverage,false);
			break;
		case "Details":
			fAllNonRegressionCaseButton.setSelection(false);
			fDetailsNonRegressionCaseButton.setSelection(true);
			propagateVisibility(compNonRegressionCaseCoverage,true);
			break;
		default:
			// Error !!!
			break;
		}
	}

	@Override
	public void applyUpdatesOnFieldValuesFrom(ILaunchConfigurationWorkingCopy configuration) {
		fNonRegressionBooleanField.performApply(configuration);

		configuration.setAttribute(
				ATTR_SPECIFICATION_PROJECT_NAME, fProjectName);

		configuration.setAttribute(
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION, fModelPathText.getText());
		if( ! fModelPathText.getText().equals(currentModelPath) ) {
			currentModelPath = fModelPathText.getText();
			initTransitionTable();
		}

		configuration.setAttribute(
				ATTR_BASIC_TRANSITION_BUTTON, fNonRegressionCaseButton);

		configuration.setAttribute(
				ATTR_SELECTED_TRANSITIONS, selectedTransitions);
	}
	
	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================
	
	@Override
	public FieldValidationReturn areFieldsValid(ILaunchConfiguration launchConfig) {
		if( fNonRegressionCaseButton.equals("Details") &&
			 ( selectedTransitions.size() == 0 ) ) {
			return new FieldValidationReturn(false, "You must select at least one transition");
		}
		return new FieldValidationReturn(true, null);
	}
}
