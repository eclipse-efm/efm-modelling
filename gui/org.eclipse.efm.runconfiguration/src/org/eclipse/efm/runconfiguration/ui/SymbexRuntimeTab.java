/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.runconfiguration.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.StringVariableSelectionDialog;
import org.eclipse.efm.runconfiguration.Activator;
import org.eclipse.efm.runconfiguration.ToolConstants;
import org.eclipse.efm.runconfiguration.ui.internal.SWTFactory;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

/**
 * @author lapitre_is148245
 * inspired by org.eclipse.ui.externaltools.internal.launchConfigurations.ExternalToolsMainTab
 */
public class SymbexRuntimeTab extends AbstractLaunchConfigurationTab
		implements ToolConstants {

	public final static String FIRST_EDIT = "editedByDiversityAvmTab"; //$NON-NLS-1$

	// Arguments
	protected Text fArgumentField;
	protected Button fArgumentVariablesButton;


	// Working Directory
	private Button fWorkingDirectoryWorkspaceButton;
	private Button fWorkingDirectoryFileSystemButton;
	private Button fWorkingDirectoryVariablesButton;

	private Button fWorkingDirectoryUseDefaultButton = null;
	private Text fWorkingDirectoryText = null;


	// AVM Location
	private Button fAvmLocationWorkspaceButton;
	private Button fAvmLocationFileSystemButton;
	private Button fAvmLocationVariablesButton;

	private Button fAvmLocationUseDefaultButton = null;
	private Button fAvmLocationUseOtherButton = null;
	private Text fAvmLocationDefaultText = null;
	private Combo fSelectedAvmLocationCombo = null;

	private boolean fUsedDefaultAvmLocation = true;
	private ArrayList<String> fAvmLocations = null;

	String fGlobalPrefLocation = null;

	/**
	 * The last launch configuration this tab was initialized from
	 */
	private ILaunchConfiguration fLaunchConfiguration;

	protected boolean fInitializing = false;
	private boolean userEdited = false;


	class WidgetListener extends SelectionAdapter implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			if ( ! fInitializing ) {
				setDirty(true);
				userEdited = true;

				updateLaunchConfigurationDialog();
			}

			scheduleUpdateJob();
		}

		public void widgetSelected(SelectionEvent e) {
			setDirty(true);

			Object source = e.getSource();

			// Project
			if (source == fArgumentVariablesButton) {
				handleArgumentVariablesButtonSelected(fArgumentField);
			}

			// Working Directory
			else if (source == fWorkingDirectoryWorkspaceButton) {
				handleWorkingDirectoryWorkspaceBrowseButtonSelected();
			}
			else if (source == fWorkingDirectoryFileSystemButton) {
				handleWorkingDirectoryFileBrowseButtonSelected();
			}
			else if (source == fWorkingDirectoryVariablesButton) {
				handleWorkingDirectoryVariablesButtonSelected();
			}
			else if(source == fWorkingDirectoryUseDefaultButton) {
				//only perform the action if this is the button that was selected
				handleWorkingDirectoryUseDefaultButtonSelected();
			}

			// Avm Location
			else if (e.getSource() == fSelectedAvmLocationCombo) {
				handleAvmLocationSelectionChange();
			}
			else if (source == fAvmLocationWorkspaceButton) {
				handleAvmLocationWorkspaceBrowseButtonSelected();
			}
			else if (source == fAvmLocationFileSystemButton) {
				handleAvmLocationBrowseButtonSelected();
			}
			else if (source == fAvmLocationVariablesButton) {
				handleAvmLocationVariablesButtonSelected();
			}
			else if(source == fAvmLocationUseDefaultButton) {
				//only perform the action if this is the button that was selected

				fUsedDefaultAvmLocation =
						fAvmLocationUseDefaultButton.getSelection();

				if( fUsedDefaultAvmLocation ) {
					setAvmLocationDefaultText();
				}
			}
			else if(source == fAvmLocationUseOtherButton) {
				//only perform the action if this is the button that was selected
				if(fAvmLocationUseOtherButton.getSelection()) {
					handleAvmLocationUseOtherButtonSelected(true);

					fUsedDefaultAvmLocation = false;
				}
				else {
					fUsedDefaultAvmLocation = true;
				}
			}
		}
	}

	private WidgetListener fListener = new WidgetListener();




	public SymbexRuntimeTab() {
		fGlobalPrefLocation = Activator.strDiversityAvmExecLocation();

//		System.out.println( Activator.strDiversityAvmExecLocation() );

		fAvmLocations = new ArrayList<>();
	}


	@Override
	public String getName() {
		return "&Symbex-Runtime";
	}


//	@Override
//	public Image getImage() {
//		return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_LIBRARY);
//	}


	////////////////////////////////////////////////////////////////////////////
	// Argument
	////////////////////////////////////////////////////////////////////////////
	private void handleArgumentVariablesButtonSelected(Text textField) {
		String variable = getVariable();
		if (variable != null) {
			textField.insert(variable);
		}
	}

	private String getVariable() {
		StringVariableSelectionDialog dialog =
				new StringVariableSelectionDialog(getShell());
		dialog.open();
		return dialog.getVariableExpression();
	}


	////////////////////////////////////////////////////////////////////////////
	// WorkingDirectory
	////////////////////////////////////////////////////////////////////////////
	/**
	 * Show a dialog that lets the user select a working directory
	 */
	private void handleWorkingDirectoryFileBrowseButtonSelected() {
		DirectoryDialog dialog = new DirectoryDialog(getShell());
		dialog.setMessage("Select a working directory for the launch configuration:");
		String currentWorkingDir = getWorkingDirectoryText();
		if (!currentWorkingDir.trim().equals("")) { //$NON-NLS-1$
			File path = new File(currentWorkingDir);
			if (path.exists()) {
				dialog.setFilterPath(currentWorkingDir);
			}
		}
		String selectedDirectory = dialog.open();
		if (selectedDirectory != null) {
			fWorkingDirectoryText.setText(selectedDirectory);
		}
	}

	/**
	 * Show a dialog that lets the user select a working directory from
	 * the workspace
	 */
	private void handleWorkingDirectoryWorkspaceBrowseButtonSelected() {
	    IContainer currentContainer= getContainer();
		if (currentContainer == null) {
		    currentContainer = ResourcesPlugin.getWorkspace().getRoot();
		}
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(),
				currentContainer, false,
				"Select a working directory for the launch configuration:");
		dialog.showClosedProjects(false);
		dialog.open();
		Object[] results = dialog.getResult();
		if ((results != null) && (results.length > 0) && (results[0] instanceof IPath)) {
			IPath path = (IPath)results[0];
			String containerName = path.makeRelative().toString();

			setWorkingDirectoryText("${workspace_loc:" + containerName + "}"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Returns the selected workspace container or <code>null</code>
	 * @return the selected workspace container or <code>null</code>
	 */
	protected IContainer getContainer() {
		String path = getWorkingDirectoryText();
		if (path.length() > 0) {
		    IResource res = null;
		    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		    if (path.startsWith("${workspace_loc:")) { //$NON-NLS-1$
		        IStringVariableManager manager =
		        		VariablesPlugin.getDefault().getStringVariableManager();
			    try {
                    path = manager.performStringSubstitution(path, false);
                    IPath uriPath = new Path(path).makeAbsolute();
                    IContainer[] containers =
                    		root.findContainersForLocationURI(URIUtil.toURI(uriPath));
                    if (containers.length > 0) {
                        res = containers[0];
                    }
                }
			    catch (CoreException e) {
					e.printStackTrace();
			    }
			}
		    else {
				res = root.findMember(path);
			}
			if (res instanceof IContainer) {
				return (IContainer)res;
			}
		}
		return null;
	}

	/**
	 * The default working dir radio button has been selected.
	 */
	private void handleWorkingDirectoryUseDefaultButtonSelected() {
		if( fWorkingDirectoryUseDefaultButton.getSelection() ) {
			setWorkingDirectoryDefaultText();

			setEnabledWorkingDirectoryComponent( false );
		}
		else {
			setEnabledWorkingDirectoryComponent( true );
		}
	}

	private void setEnabledWorkingDirectoryComponent(boolean enabledFlag) {
		fWorkingDirectoryText.setEnabled(enabledFlag);

		fWorkingDirectoryWorkspaceButton.setEnabled(enabledFlag);
		fWorkingDirectoryVariablesButton.setEnabled(enabledFlag);
		fWorkingDirectoryFileSystemButton.setEnabled(enabledFlag);
	}

	/**
	 * The working dir variables button has been selected
	 */
	private void handleWorkingDirectoryVariablesButtonSelected() {
		StringVariableSelectionDialog dialog =
				new StringVariableSelectionDialog(getShell());
		dialog.open();
		String variableText = dialog.getVariableExpression();
		if (variableText != null) {
			fWorkingDirectoryText.insert(variableText);
		}
	}

	/**
	 * Sets the default working directory.
	 */
	protected void initializeWorkingDirectoryComponent(String dir) {
		if (dir == null) {
			setWorkingDirectoryDefaultText();
		}
		else {
			setWorkingDirectoryText(dir);
		}

		fWorkingDirectoryUseDefaultButton.setSelection(dir == null);

		setEnabledWorkingDirectoryComponent(dir != null);
	}

	protected void setWorkingDirectoryDefaultText() {
// TODO getSelectedProject()
//		if (fLaunchConfiguration != null) {
//			IProject project = getSelectedProject();
//			if (project != null) {
//				setWorkingDirectoryText("${workspace_loc:"
//						+ project.getFullPath().makeRelative().toOSString() + "}");  //$NON-NLS-1$//$NON-NLS-2$
//				return;
//			}
//		}
		setWorkingDirectoryText(System.getProperty("user.dir")); //$NON-NLS-1$
	}

	protected void setWorkingDirectoryText(String dir) {
		if(dir != null) {
			fWorkingDirectoryText.setText(dir);
		}
	}

	void updateWorkingDirectoryDefaultText() {
		if( fWorkingDirectoryUseDefaultButton.getSelection() ) {
			setWorkingDirectoryDefaultText();
		}
	}


	protected final String getWorkingDirectoryText() {
		return fWorkingDirectoryText.getText().trim();
	}

	protected boolean isValidWorkingDirectory() {
		setErrorMessage(null);
		setMessage(null);
		// if variables are present, we cannot resolve the directory
		String workingDirPath = getWorkingDirectoryText();
		if (workingDirPath.indexOf("${") >= 0) { //$NON-NLS-1$
			IStringVariableManager manager =
					VariablesPlugin.getDefault().getStringVariableManager();
			try {
				manager.validateStringVariables(workingDirPath);
			}
			catch (CoreException e) {
				setErrorMessage(e.getMessage());
				return false;
			}
		}
		else if (workingDirPath.length() > 0) {
			IContainer container = getContainer();
			if (container == null) {
				File dir = new File(workingDirPath);
				if (dir.isDirectory()) {
					return true;
				}
				setErrorMessage("Working directory does not exist");
				return false;
			}
		} else if (workingDirPath.length() == 0) {
			setErrorMessage("Working directory not specified");
			return false;
		}
		return true;
	}


	////////////////////////////////////////////////////////////////////////////
	// Avm Location
	////////////////////////////////////////////////////////////////////////////

	String[] getAvmLocationItems()
	{
		return( fAvmLocations.toArray( new String[fAvmLocations.size()] ) );
	}

	String[] addAvmLocationItems(String addLocation)
	{
		IPath pathDefault = new Path(addLocation);

		ArrayList<String> avmLocations = new ArrayList<>();
		avmLocations.add(addLocation);

		for( String location : fAvmLocations ) {
			IPath pathOther = new Path(location);
			if( ! pathDefault.equals(pathOther) ) {
				avmLocations.add(pathOther.toOSString());
			}
		}

		fAvmLocations.clear();
		fAvmLocations.addAll(avmLocations);

		return( fAvmLocations.toArray(
				new String[fAvmLocations.size()]) );
	}

	String[] resetOtheAvmLocationItems(List<?> locations)
	{
		IPath pathDefault = new Path(fGlobalPrefLocation);
//				fAvmLocationDefaultText.getText());

		fAvmLocations.clear();

		for( Object location : locations ) {
			IPath pathOther = new Path(location.toString());
			if( ! pathDefault.equals(pathOther) ) {
				fAvmLocations.add(pathOther.toOSString());
			}
		}

		return( fAvmLocations.toArray(
				new String[fAvmLocations.size()]) );
	}

	/**
	 * The other AVM location selection change
	 */
	private void handleAvmLocationSelectionChange() {
		addAvmLocationItems( fSelectedAvmLocationCombo.getText() );

		try {
			performApplyAvmLocation(fLaunchConfiguration.getWorkingCopy());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Show a dialog that lets the user select an AVM Location
	 */
	private void handleAvmLocationBrowseButtonSelected() {
		FileDialog fileDialog = new FileDialog(getShell(), SWT.NONE);
		String location = fSelectedAvmLocationCombo.getText();
		if( (location == null) || location.isEmpty() ) {
			location = fGlobalPrefLocation;
		}
		fileDialog.setFileName( location );
		fileDialog.setFilterExtensions(new String[] {"*.exe" , "*.*"});
		String text= fileDialog.open();
		if (text != null) {
			fSelectedAvmLocationCombo.setItems( addAvmLocationItems(text) );
			if( ! fAvmLocations.isEmpty() ) {
				fSelectedAvmLocationCombo.select(0);
			}
		}
	}

	/**
	 * Show a dialog that lets the user select an AVM Location from
	 * the workspace
	 */
	private void handleAvmLocationWorkspaceBrowseButtonSelected() {
		ResourceSelectionDialog dialog =
				new ResourceSelectionDialog(getShell(),
						ResourcesPlugin.getWorkspace().getRoot(),
						"Select a &Symbex tool relative working location:");

        if (dialog.open() == Window.OK) {
    		Object[] results = dialog.getResult();
    		if (results == null || results.length < 1) {
    			return;
    		}
    		else if( results[0] instanceof IPath ) {
				IPath path = (IPath)results[0];
				String containerName = path.makeRelative().toString();
				setAvmLocationText("${workspace_loc:" + containerName + "}"); //$NON-NLS-1$ //$NON-NLS-2$
    		}
        }
	}

	/**
	 * The default AVM location radio button has been selected.
	 */
	private void handleAvmLocationUseOtherButtonSelected(boolean isEnabled) {
		fSelectedAvmLocationCombo.setEnabled(isEnabled);
		fAvmLocationWorkspaceButton.setEnabled(isEnabled);
		fAvmLocationVariablesButton.setEnabled(isEnabled);
		fAvmLocationFileSystemButton.setEnabled(isEnabled);

		if( isEnabled ) {
			updateLaunchConfigurationDialog();
		}
	}

	/**
	 * The AVM location variables button has been selected
	 */
	private void handleAvmLocationVariablesButtonSelected() {
		StringVariableSelectionDialog dialog =
				new StringVariableSelectionDialog(getShell());
		dialog.open();
		String variableText = dialog.getVariableExpression();
		if (variableText != null) {
			fSelectedAvmLocationCombo.setText(
					fSelectedAvmLocationCombo.getText() + variableText);
		}
	}

	/**
	 * Sets the default working directory.
	 */
	protected void setAvmLocationDefaultText() {
		fAvmLocationDefaultText.setText( fGlobalPrefLocation );
		handleAvmLocationUseOtherButtonSelected(false);
	}


	/**
	 * Retrieves the path from the text box that has been selected.
	 * @return the AVM location the user wishes to use
	 */
	protected final String getAvmLocationText() {
		if( fUsedDefaultAvmLocation ) {
			return fGlobalPrefLocation;//fAvmLocationDefaultText.getText().trim();
		}
		return fSelectedAvmLocationCombo.getText().trim();
	}


	/**
	 * Sets the location of the other AVM location to be used.
	 * @param location the directory to set the widget to
	 */
	protected final void setAvmLocationText(String location) {
		if(location != null) {
			IPath pathDefault = new Path(fSelectedAvmLocationCombo.getText());
			IPath pathOther = new Path(location);
			if( pathDefault.equals(pathOther) ) {
				return;
			}

			fSelectedAvmLocationCombo.setItems(
					addAvmLocationItems(location) );
			if( ! fAvmLocations.isEmpty() ) {
				fSelectedAvmLocationCombo.select(0);
			}

			handleAvmLocationUseOtherButtonSelected(true);
		}
	}

	protected final void setAvmLocationItems(List<?> locations) {
		if(locations != null) {
			fSelectedAvmLocationCombo.setItems(
					resetOtheAvmLocationItems(locations) );
			if( ! fAvmLocations.isEmpty() ) {
				fSelectedAvmLocationCombo.select(0);
			}

			handleAvmLocationUseOtherButtonSelected(true);
		}
	}


	public boolean isValidAvmLocation() {
		setErrorMessage(null);
		setMessage(null);
		// if variables are present, we cannot resolve the directory
		String avmLocationPath = getAvmLocationText();
		if (avmLocationPath.indexOf("${") >= 0) { //$NON-NLS-1$
			IStringVariableManager manager =
					VariablesPlugin.getDefault().getStringVariableManager();
			try {
				manager.validateStringVariables(avmLocationPath);
			}
			catch (CoreException e) {
				setErrorMessage(e.getMessage());
				return false;
			}
		}
		else if (avmLocationPath.length() > 0) {
			File location = new File(avmLocationPath);
			if (location.isFile()) {
				return true;
			}
			setErrorMessage("Symbex executable location does not exist");
			return false;
		} else if (avmLocationPath.length() == 0) {
			setErrorMessage("ymbex executable location not specified");
			return false;
		}
		return true;
	}


	/**
	 * createControl
	 */
	@Override
	public void createControl(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		setControl(mainComposite);
		mainComposite.setFont(parent.getFont());
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		mainComposite.setLayout(layout);
		mainComposite.setLayoutData(gridData);

		createAvmLocationComponent(mainComposite);
//		createSelectedProjectComponent(mainComposite);
//		createConfigurationComponent(mainComposite);
		createWorkingDirectoryComponent(mainComposite);
		createArgumentComponent(mainComposite);

		setControl(mainComposite);
	}


	////////////////////////////////////////////////////////////////////////////
	// Argument
	////////////////////////////////////////////////////////////////////////////
	protected void createArgumentComponent(Composite parent) {
		Group group = SWTFactory.createGroup(
				parent, "&Arguments:", 1, 1, GridData.FILL_BOTH);

		fArgumentField = new Text(group,
				SWT.MULTI | SWT.WRAP | SWT.BORDER | SWT.V_SCROLL);
		fArgumentField.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent event) {
				if (event.detail == SWT.TRAVERSE_RETURN &&
						(event.stateMask & SWT.MODIFIER_MASK) != 0) {
					event.doit= true;
				}
			}
		});

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		gridData.heightHint = 30;
		fArgumentField.setLayoutData(gridData);
		fArgumentField.addModifyListener(fListener);
		addControlAccessibleListener(fArgumentField, group.getText());

		Composite buttonComposite = SWTFactory.createComposite(group,
				parent.getFont(), 1, 1, GridData.HORIZONTAL_ALIGN_END, 0, 0);

		fArgumentVariablesButton= createPushButton(
				buttonComposite, "Variable&s...", null);
		fArgumentVariablesButton.addSelectionListener(fListener);
		addControlAccessibleListener( // need to strip the mnemonic from buttons
				fArgumentVariablesButton, fArgumentVariablesButton.getText());

		Label instruction = new Label(group, SWT.NONE);
		instruction.setText("Note: Enclose an argument "
				+ "containing spaces using double-quotes (\").");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		instruction.setLayoutData(gridData);
	}

	public void addControlAccessibleListener(Control control, String controlName) {
		//strip mnemonic (&)
		String[] strs = controlName.split("&"); //$NON-NLS-1$
		StringBuffer stripped = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			stripped.append(strs[i]);
		}
		control.getAccessible().addAccessibleListener(
				new ControlAccessibleListener(stripped.toString()));
	}

	private class ControlAccessibleListener extends AccessibleAdapter {
		private String controlName;
		ControlAccessibleListener(String name) {
			controlName = name;
		}
		public void getName(AccessibleEvent e) {
			e.result = controlName;
		}

	}

	////////////////////////////////////////////////////////////////////////////
	// Working Directory
	////////////////////////////////////////////////////////////////////////////
	protected void createWorkingDirectoryComponent(Composite parent) {
		Group group = SWTFactory.createGroup(
				parent, "&Working directory:", 2, 1, GridData.FILL_HORIZONTAL);

		Font font = parent.getFont();

		//default choice
		Composite comp = SWTFactory.createComposite(
				group, font, 2, 2, GridData.FILL_BOTH, 0, 0);
		fWorkingDirectoryUseDefaultButton = createCheckButton(comp, "Defa&ult:");
		fWorkingDirectoryUseDefaultButton.addSelectionListener(fListener);
		fWorkingDirectoryText = SWTFactory.createSingleText(comp, 1);
		fWorkingDirectoryText.addModifyListener(fListener);

		//buttons
		Composite buttonComp = SWTFactory.createComposite(
				comp, font, 3, 2, GridData.HORIZONTAL_ALIGN_END);
		GridLayout ld = (GridLayout)buttonComp.getLayout();
		ld.marginHeight = 1;
		ld.marginWidth = 0;
		fWorkingDirectoryWorkspaceButton =
				createPushButton(buttonComp, "W&orkspace...", null);
		fWorkingDirectoryWorkspaceButton.addSelectionListener(fListener);

		fWorkingDirectoryFileSystemButton =
				createPushButton(buttonComp, "&File System...", null);
		fWorkingDirectoryFileSystemButton.addSelectionListener(fListener);

		fWorkingDirectoryVariablesButton =
				createPushButton(buttonComp, "Variabl&es...", null);
		fWorkingDirectoryVariablesButton.addSelectionListener(fListener);
	}

	////////////////////////////////////////////////////////////////////////////
	// Avm Location
	////////////////////////////////////////////////////////////////////////////
	protected void createAvmLocationComponent(Composite parent) {
		Group group = SWTFactory.createGroup(parent,
				"&Symbex Executable Location:", 2, 1, GridData.FILL_HORIZONTAL);

		Font font = parent.getFont();

		//default choice
		Composite comp = SWTFactory.createComposite(
				group, font, 2, 2, GridData.FILL_BOTH, 0, 0);

		fAvmLocationUseDefaultButton =
				SWTFactory.createRadioButton(comp, "Defa&ult:");
		fAvmLocationUseDefaultButton.addSelectionListener(fListener);

		fAvmLocationDefaultText = SWTFactory.createSingleText(comp, 1);
		fAvmLocationDefaultText.addModifyListener(fListener);
		fAvmLocationDefaultText.setEnabled(false);

		//user enter choice
		fAvmLocationUseOtherButton =
				SWTFactory.createRadioButton(comp, "Ot&her:");
		fAvmLocationUseOtherButton.addSelectionListener(fListener);

		fSelectedAvmLocationCombo = SWTFactory.createCombo(
				comp, SWT.DROP_DOWN, 1, getAvmLocationItems());
		fSelectedAvmLocationCombo.addSelectionListener(fListener);
		fSelectedAvmLocationCombo.addModifyListener(fListener);

		//buttons
		Composite buttonComp = SWTFactory.createComposite(
				comp, font, 3, 2, GridData.HORIZONTAL_ALIGN_END);
		GridLayout ld = (GridLayout)buttonComp.getLayout();
		ld.marginHeight = 1;
		ld.marginWidth = 0;
		fAvmLocationWorkspaceButton =
				createPushButton(buttonComp, "W&orkspace...", null);
		fAvmLocationWorkspaceButton.addSelectionListener(fListener);

		fAvmLocationFileSystemButton =
				createPushButton(buttonComp, "&File System...", null);
		fAvmLocationFileSystemButton.addSelectionListener(fListener);

		fAvmLocationVariablesButton =
				createPushButton(buttonComp, "Variabl&es...", null);
		fAvmLocationVariablesButton.addSelectionListener(fListener);
	}


	/**
	 * initializeFrom
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		fInitializing = true;

		fLaunchConfiguration = configuration;

		initializeFromArgument(configuration);
		initializeFromWorkingDirectory(configuration);
		initializeFromAvmLocation(configuration);

		fInitializing = false;
		setDirty(false);
	}


	////////////////////////////////////////////////////////////////////////////
	// Argument
	////////////////////////////////////////////////////////////////////////////
	public void initializeFromArgument(ILaunchConfiguration configuration) {
		String arguments= EMPTY_STRING;
		try {
			arguments= configuration.getAttribute(
					ATTR_TOOL_ARGUMENTS, EMPTY_STRING);
		}
		catch (CoreException e) {
			setErrorMessage("Exception occurred reading << Argument >> configuration:"
					+ e.getStatus().getMessage());
		}

		fArgumentField.setText(arguments);
	}


	////////////////////////////////////////////////////////////////////////////
	// Working Directory
	////////////////////////////////////////////////////////////////////////////
	public void initializeFromWorkingDirectory(ILaunchConfiguration configuration) {
		try {
			initializeWorkingDirectoryComponent(configuration.getAttribute(
					ATTR_WORKING_DIRECTORY, (String)null));
		}
		catch (CoreException e) {
			setErrorMessage("Exception occurred reading "
					+ "<< Working Directory >> configuration:"
					+ e.getStatus().getMessage());
		}
	}

	////////////////////////////////////////////////////////////////////////////
	// Avm Location
	////////////////////////////////////////////////////////////////////////////
	public void initializeFromAvmLocation(ILaunchConfiguration configuration) {
		List<?> avmLocation = null;
		try {
			avmLocation = configuration.getAttribute(
					ATTR_LAUNCH_AVM_LOCATION_HISTORY, (List<String>)null);
		} catch (CoreException e) {
			//!! NOTHING
		}

		if( avmLocation == null ) {
			try {
				String strLocation = configuration.getAttribute(
						ATTR_LAUNCH_AVM_LOCATION_HISTORY, (String)null);

				if( strLocation != null ) {
					avmLocation = Arrays.asList(strLocation);

					this.setDirty(true);
				}
			} catch (CoreException e) {
				//!! NOTHING
			}
		}

		setAvmLocationItems(avmLocation);

		try {
			fUsedDefaultAvmLocation = configuration.getAttribute(
					ATTR_LAUNCH_AVM_LOCATION_USED_DEFAULT, true);
		} catch (CoreException e) {
			//!! NOTHING
		}

		if( fUsedDefaultAvmLocation ) {
			setAvmLocationDefaultText();

			try {
				String location = configuration.getAttribute(
						ATTR_LAUNCH_AVM_LOCATION, (String)null);
				if( ! fGlobalPrefLocation.equals(location) ) {
					setWarningMessage("Global Preference "
							+ "< Symbex Executable Location > has changed !");
				}
			} catch (CoreException e) {
				//!! NOTHING
			}

		}
		else {
			fAvmLocationDefaultText.setText(fGlobalPrefLocation);
		}
		fAvmLocationUseDefaultButton.setSelection(fUsedDefaultAvmLocation);
		fAvmLocationUseOtherButton.setSelection(! fUsedDefaultAvmLocation);
	}



	/**
	 * performApply
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		performApplyArgument(configuration);
		performApplyWorkingDirectory(configuration);
		performApplyAvmLocation(configuration);

		if(userEdited) {
			configuration.setAttribute(SymbexRuntimeTab.FIRST_EDIT, (String)null);
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// Argument
	////////////////////////////////////////////////////////////////////////////
	public void performApplyArgument(ILaunchConfigurationWorkingCopy configuration) {
		String arguments= fArgumentField.getText().trim();
		if (arguments.length() == 0) {
			configuration.setAttribute(ATTR_TOOL_ARGUMENTS, (String)null);
		} else {
			configuration.setAttribute(ATTR_TOOL_ARGUMENTS, arguments);
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// WorkingDirectory
	////////////////////////////////////////////////////////////////////////////
	public void performApplyWorkingDirectory(
			ILaunchConfigurationWorkingCopy configuration) {
		if(fWorkingDirectoryUseDefaultButton.getSelection()) {
			configuration.setAttribute(ATTR_WORKING_DIRECTORY, (String)null);
		}
		else {
			configuration.setAttribute(
					ATTR_WORKING_DIRECTORY, getWorkingDirectoryText());
		}
	}

	////////////////////////////////////////////////////////////////////////////
	// Avm Location
	////////////////////////////////////////////////////////////////////////////
	public void performApplyAvmLocation(
			ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_LAUNCH_AVM_LOCATION_HISTORY, fAvmLocations);

		String location = null;
		fUsedDefaultAvmLocation = fAvmLocationUseDefaultButton.getSelection();
		if( fUsedDefaultAvmLocation ) {
			location = fGlobalPrefLocation;//fAvmLocationDefaultText.getText().trim();

			if( ! location.equals(fGlobalPrefLocation) ) {
				fAvmLocationDefaultText.setText( location = fGlobalPrefLocation );
			}
		}
		else {
			location = fSelectedAvmLocationCombo.getText().trim();
		}
		if( (location == null) || location.isEmpty() ) {
			location = fGlobalPrefLocation;
		}

		configuration.setAttribute(
				ATTR_LAUNCH_AVM_LOCATION_USED_DEFAULT, fUsedDefaultAvmLocation);

		configuration.setAttribute(ATTR_LAUNCH_AVM_LOCATION, location);
	}



	/**
	 * setDefaults
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		setDefaultsArgument(configuration);
		setDefaultsWorkingDirectory(configuration);
		setDefaultsAvmLocation(configuration);
	}


	////////////////////////////////////////////////////////////////////////////
	// Argument
	////////////////////////////////////////////////////////////////////////////
	public void setDefaultsArgument(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ATTR_TOOL_ARGUMENTS, (String)null);
	}


	////////////////////////////////////////////////////////////////////////////
	// Working Directory
	////////////////////////////////////////////////////////////////////////////
	public void setDefaultsWorkingDirectory(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ATTR_WORKING_DIRECTORY, (String)null);
	}

	////////////////////////////////////////////////////////////////////////////
	// Avm Location
	////////////////////////////////////////////////////////////////////////////
	public void setDefaultsAvmLocation(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_LAUNCH_AVM_LOCATION_USED_DEFAULT, true);

		configuration.setAttribute(
				ATTR_LAUNCH_AVM_LOCATION, fGlobalPrefLocation);
	}



	public void updateLaunchConfigurationDialog() {
		validateTab();

		super.updateLaunchConfigurationDialog();
	}

	public void validateTab() {
		if( isValidWorkingDirectory() ) {
		}

		if( isValidAvmLocation() ) {
		}

//		String error = fDataBlock.validate();
//
//		setErrorMessage(error);
	}



}
