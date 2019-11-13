/*******************************************************************************
 * Copyright (c) 2018 CEA LIST.
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
package org.eclipse.efm.execution.launchconfiguration.job.action;


import org.eclipse.core.resources.IFile;
import org.eclipse.efm.execution.launchconfiguration.handlers.Util;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJobFactory;
import org.eclipse.efm.execution.launchconfiguration.job.console.SymbexSpiderConsolePage;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IUpdate;

public class RunSelectedSymbexWorkflowAction extends Action
		implements IUpdate , ISelectionListener {

	private SymbexSpiderConsolePage fSymbexSpiderConsolePage;

	// use field injection for the service
//	@Inject ESelectionService selectionService;

	private IFile fSelectedSewFile = null;


	public RunSelectedSymbexWorkflowAction(
			final SymbexSpiderConsolePage symbexSpiderConsolePage) {
		super("Run SEW");

		this.fSymbexSpiderConsolePage = symbexSpiderConsolePage;

		updateSelectedFile();
		if( fSelectedSewFile != null) {
			setToolTipText("Run " + fSelectedSewFile.getFullPath());
		}
		else {
			setToolTipText("Run selected Symbex Workflow");
		}

		final ImageDescriptor imageDescriptor =
				ImageResources.getImageDescriptor(
						ImageResources.IMG_ELCL16_RUN_EXEC);

		setImageDescriptor(imageDescriptor);
		setHoverImageDescriptor(imageDescriptor);
		setDisabledImageDescriptor(imageDescriptor);

//		PlatformUI.getWorkbench().getHelpSystem().setHelp(
//				this, IConsoleHelpContextIds.CONSOLE_WORD_WRAP_ACTION);

		update();

		registerOnSelectionService();
	}


	@Override
	public void run() {
		if( fSelectedSewFile != null ) {
			updateSelectedFile();
		}

		if( fSelectedSewFile != null ) {

			if( ! SymbexJobFactory.run(fSelectedSewFile) ) {
				//!!! ERROR
			}
		}
		else {
			fSymbexSpiderConsolePage.restartProcess();
		}
	}

	@Override
	public void update() {
		setEnabled(true);
	}

	@Override
	public String getToolTipText() {
		updateSelectedFile();
		if( fSelectedSewFile != null ) {
			setToolTipText("Run " + fSelectedSewFile.getFullPath());
		}
//		else {
//			return("Run Symbex --> selected Workflow");
//		}

		return super.getToolTipText();
	}

	public void dispose() {
		fSymbexSpiderConsolePage = null;

		unregisterOnSelectionService();
	}


	// Selection Service
	protected void registerOnSelectionService() {
		final IWorkbenchWindow window =
				PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if( window != null ) {
			window.getSelectionService().addSelectionListener(
					IPageLayout.ID_PROJECT_EXPLORER, this);
		}
	}

	protected void unregisterOnSelectionService() {
		final IWorkbenchWindow window =
				PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if( window != null ) {
			window.getSelectionService().removeSelectionListener(
					IPageLayout.ID_PROJECT_EXPLORER, this);
		}
	}

	@Override
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		if( selection instanceof IStructuredSelection ) {
			final Object selObj =
					((IStructuredSelection) selection).getFirstElement();
			if( selObj instanceof IFile ) {
				final IFile sewFile = ((IFile) selObj);

				if( Util.isWorkflowFile(sewFile) )
				{
					fSelectedSewFile = sewFile;
					setToolTipText("Run " + fSelectedSewFile.getFullPath());

				}
			}
		}
	}

	public void updateSelectedFile() {
		final IWorkbenchWindow window =
				PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		ISelection selection = null;
		if( window != null ) {
			selection = window.getSelectionService().getSelection();
			if( ! (selection instanceof IStructuredSelection) ) {
				selection = window.getSelectionService().getSelection(
						IPageLayout.ID_PROJECT_EXPLORER);
			}
		}
		if( selection instanceof IStructuredSelection ) {
			final Object selObj =
					((IStructuredSelection) selection).getFirstElement();
			if( selObj instanceof IFile ) {
				final IFile sewFile = ((IFile) selObj);

				if( Util.isWorkflowFile(sewFile) )
				{
					fSelectedSewFile = sewFile;
				}
			}
		}
	}


}
