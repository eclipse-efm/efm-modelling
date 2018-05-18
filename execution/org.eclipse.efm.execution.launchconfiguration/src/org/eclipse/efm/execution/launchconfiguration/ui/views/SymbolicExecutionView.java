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
package org.eclipse.efm.execution.launchconfiguration.ui.views;


import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.launchconfiguration.Activator;
import org.eclipse.efm.execution.launchconfiguration.ui.views.page.SEWConsoleSpiderPage;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class SymbolicExecutionView extends PageBookView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String SYMBEX_CONSOLE_VIEW_ID =
//			"org.eclipse.efm.execution.launchconfiguration.ui.views.SymbolicExecutionView"
			Activator.PLUGIN_ID + ".ui.views.SymbolicExecutionView";


	private PageRec fSpiderConsolePageRec;
//!Warn	private PageRec fConsolePageRec;

	private SEWConsoleSpiderPage fSpiderConsolePage;
//!Warn	private SymbexSpiderConsolePage fConsolePage;

	boolean fSwitch = false;

//!Warn	private PageRec fPageRec;

	// Testing extends PropertySheet
//	 @Override
//	 protected boolean isImportant(IWorkbenchPart part) {
//		 if (part.getSite().getId().equals(IPageLayout.ID_PROJECT_EXPLORER))
//			 return true;
//		 return false;
//	 }


	public PageRec getSpiderConsolePageRec() {
		return fSpiderConsolePageRec;
	}

	@Override
	protected IPage createDefaultPage(PageBook book) {
//		MessagePage messagePage = new MessagePage();
//		initPage(messagePage);
//		messagePage.setMessage("No interested in this part");
//		messagePage.createControl(book);
//		return messagePage;


//		fConsolePage = new SymbexSpiderConsolePage();
//		initPage(fConsolePage);
//		fConsolePage.createControl(book);
//		fConsolePageRec = new PageRec(null, fConsolePage);


		fSpiderConsolePage = new SEWConsoleSpiderPage();
		initPage(fSpiderConsolePage);
		fSpiderConsolePage.createControl(book);
		fSpiderConsolePageRec = new PageRec(null, fSpiderConsolePage);

		return fSpiderConsolePage;
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
//		MessagePage messagePage = new MessagePage();
//		initPage(messagePage);
//		messagePage.setMessage("Page for "+part.getTitle());
//		messagePage.createControl(getPageBook());
//		return new PageRec(part, messagePage);

		return null;
	}

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		pageRecord.page.dispose();
	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
		if(page != null) {
			// check whether the active part is important to us
			IWorkbenchPart activePart = page.getActivePart();
			return isImportant(activePart)?activePart:null;
		}
		return null;
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
//		return (part != null) &&
//				part.getSite().getPluginId().startsWith("org.eclipse.ui");
		return false;
	}


	public void sewLaunchExecProcess(ILaunchConfiguration configuration,
			String mode, ILaunch launch, IProgressMonitor monitor,
			String[] commandLine, File workingDirectory, String[] envp) {

		fSpiderConsolePage.sewLaunchExecProcess(configuration, mode,
				launch, monitor, commandLine, workingDirectory, envp);

//		fSwitch = (! fSwitch);
//
//		if( fSwitch ) {
//			Display.getDefault().syncExec(new Runnable() {
//				public void run() {
//					showPageRec( fSpiderConsolePageRec );
//				}
//			});
//
//			fSpiderConsolePage.sewLaunchExecProcess(configuration, mode,
//					launch, monitor, commandLine, workingDirectory, envp);
//		}
//		else {
//			Display.getDefault().syncExec(new Runnable() {
//				public void run() {
//					showPageRec( fConsolePageRec );
//				}
//			});
//
//			fConsolePage.sewLaunchExecProcess(configuration, mode,
//					launch, monitor, commandLine, workingDirectory, envp);
//		}
	}
}
