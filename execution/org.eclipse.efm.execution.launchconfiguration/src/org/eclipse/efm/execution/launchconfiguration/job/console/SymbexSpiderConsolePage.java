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
package org.eclipse.efm.execution.launchconfiguration.job.console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;
import org.eclipse.efm.execution.core.preferences.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.launchconfiguration.HelpContextIdConstants;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJob;
import org.eclipse.efm.execution.launchconfiguration.job.action.TerminateAction;
import org.eclipse.efm.execution.launchconfiguration.ui.views.page.SWTSpider;
import org.eclipse.efm.execution.launchconfiguration.ui.views.page.SWTSpider.SPIDER_GEOMETRY;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.internal.console.IOConsolePage;

@SuppressWarnings("restriction")
public class SymbexSpiderConsolePage extends IOConsolePage
		implements IWorkflowConfigurationConstants,
		IWorkflowPreferenceConstants , IWorkflowSpiderConfigurationUtils {

	private Composite fMainPageControl;
	private MessageConsole fMessageConsoleConsole;

	private SashForm fSashForm;

	private SWTSpider fSpider;

	private TerminateAction fTerminateAction;


	public SymbexSpiderConsolePage(MessageConsole console, IConsoleView view) {
		super(console, view);

		fMessageConsoleConsole = console;
	}

    @Override
	public void createControl(Composite parent) {
		// Create the SashForm that contains the selection area on the left,
		// and the edit area on the right
    	fMainPageControl = fSashForm = new SashForm(parent, SWT.SMOOTH);
		fSashForm.setOrientation(SWT.HORIZONTAL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		fSashForm.setLayoutData(gd);
		fSashForm.setFont(parent.getFont());
		fSashForm.setVisible(true);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(fSashForm,
				HelpContextIdConstants.sew_view_SymbexConsoleSpider);

		fSpider = createSpider(fSashForm, 100, 90, 150);

		super.createControl(fSashForm);

		fSashForm.setWeights(new int[] {40, 60});
    }

	private SWTSpider createSpider(Composite parent, int x, int y, int r) {
		ScrolledComposite compSpider = new ScrolledComposite (parent,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.RESIZE);

		fSpider = new SWTSpider(compSpider, SWT.NULL, x, y, r);
		compSpider.setContent(fSpider);
		compSpider.setExpandHorizontal(true);
		compSpider.setExpandVertical(true);
		compSpider.setMinSize(480, 420);

		GridData dataLeft = new GridData();
		dataLeft.heightHint = 200;
//		dataR.horizontalSpan = 1;
		dataLeft.grabExcessHorizontalSpace = true;
		dataLeft.grabExcessVerticalSpace = true;
		dataLeft.horizontalAlignment = SWT.FILL;
		dataLeft.verticalAlignment = SWT.FILL;

		compSpider.setLayout(new FillLayout());

		compSpider.setLayoutData(dataLeft);

		return fSpider;
	}


	@Override
	public Control getControl() {
		return fMainPageControl;
	}

	@Override
	public void setFocus() {
		// important to give focus to the composite rather than the label
		// as the composite will actually take focus (though hidden),
		// but setFocus on a Label is a no-op
		fMainPageControl.setFocus();
	}

	///////////////////////////////////////////////////////////////////////////
	// ACTION MANAGER
	///////////////////////////////////////////////////////////////////////////

	@Override
	protected void createActions() {
		super.createActions();

		fTerminateAction = new TerminateAction(this);
	}

	@Override
	protected void contextMenuAboutToShow(IMenuManager menuManager) {
		super.contextMenuAboutToShow(menuManager);

		menuManager.add(fTerminateAction);
	}

	@Override
	protected void configureToolBar(IToolBarManager mgr) {
        super.configureToolBar(mgr);
        mgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fTerminateAction);
    }

    @Override
	public void dispose() {
        if (fTerminateAction != null) {
        	fTerminateAction.dispose();
        	fTerminateAction = null;
        }

        super.dispose();
    }




	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	// SYMBEX PROCESS MANAGER
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	// for COMPATIBILITY
	private int nbExecution;

	private boolean disabledSpiderTrace = true;

	private boolean enablePrintEmptyLine = true;


	private final static String UNKNOWN_LAUNCH_OPTION = "Unknown AVM launch option";

	private boolean enableLegacyDiversity = false;


	private void doRefresh(String[] commandLine, File workingDirectory) {
		IResource symbexWorkflowResource = null;
		if( (commandLine != null) && (commandLine.length > 1) )
		{
			IPath symbexWorkflowPath = new Path(commandLine[1]);

			symbexWorkflowResource = WorkflowFileUtils.find(symbexWorkflowPath);
		}

		try {
			if( symbexWorkflowResource != null ) {
				symbexWorkflowResource.getProject().refreshLocal(
						IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
			else {
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(
						IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
		}
		catch(CoreException e) {
			e.printStackTrace();
		}
	}


	public void sewLaunchExecProcess(String mode, IProgressMonitor monitor,
			String[] commandLine, File workingDirectory, String[] envp) {

		if( startSymbexProcess(commandLine, workingDirectory, envp) ) {
			fMessageConsoleConsole.clearConsole();

			if ( fSpider != null ) {
				fSpider.resetSpider(SPIDER_GEOMETRY.TETRAGON);
			}

			nbExecution = 1;

			disabledSpiderTrace = true;

			enablePrintEmptyLine = true;

			if( readSymbexInitLog(monitor) ) {
				if( readSymbexStepLog(monitor) ) {
					if( readSymbexReportLog(monitor) ) {
						//!! THAT'S END
					}
				}
			}

			doRefresh(commandLine, workingDirectory);

			fTerminateAction.setEnabled(false);
		}
	}


	private Process fSymbexProcess;

	private BufferedWriter fConsoleBufferedWriter;
	private BufferedReader fProcessBufferedReader;

	// LOCALS
	private String traceLine = null;


	private boolean startSymbexProcess(
			String[] commandLine, File workingDirectory, String[] envp) {
		OutputStream outputStream =
				fMessageConsoleConsole.newOutputStream();
		OutputStreamWriter outputStreamWriter =
				new OutputStreamWriter(outputStream);

		fConsoleBufferedWriter = new BufferedWriter(outputStreamWriter);

		ProcessBuilder processBuilder = new ProcessBuilder(commandLine);
		processBuilder = processBuilder.redirectErrorStream(true);
		processBuilder.directory(workingDirectory);

		try {
			fSymbexProcess = processBuilder.start();

	        if (fTerminateAction != null) {
	        	fTerminateAction.setEnabled(true);
	        }

		} catch (IOException e1) {
			e1.printStackTrace();
		}

//		try {
//			fSymbexProcess = DebugPlugin.exec(commandLine, workingDirectory, envp);
//
//			fTerminateAction.setEnabled(true);
//		} catch (CoreException e1) {
//			e1.printStackTrace();
//			fSymbexProcess = null;
//		}

		if( fSymbexProcess != null ) {

			InputStream inputStream = fSymbexProcess.getInputStream();
			InputStreamReader inputStreamReader =
					new InputStreamReader(inputStream);

			fProcessBufferedReader = new BufferedReader(inputStreamReader);

			return true;
		}

		return false;
	}


	public boolean isProcessRunning() {
		return( (fSymbexProcess != null) && fSymbexProcess.isAlive() );
	}

	public void terminateProcess() {
		if( fSymbexProcess != null ) {
			fSymbexProcess.destroy();

			try {
				fConsoleBufferedWriter.append(
						"\n***********************" +
						"\n* EXECUTION ABORTED ! *" +
						"\n***********************");
				fConsoleBufferedWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

	        if (fTerminateAction != null) {
	        	fTerminateAction.setEnabled(false);
	        }
		}
	}


	public void sewLaunchExecProcess(ILaunchConfiguration configuration,
			String mode, ILaunch launch, IProgressMonitor monitor,
			String[] commandLine, File workingDirectory, String[] envp) {

		if( startSymbexProcess(commandLine, workingDirectory, envp) ) {
			fMessageConsoleConsole.clearConsole();

			if ( fSpider != null ) {
				fSpider.resetSpider(SPIDER_GEOMETRY.TETRAGON);
			}

			nbExecution = 1;

			disabledSpiderTrace = true;

			enablePrintEmptyLine = true;

			if( readSymbexInitLog(monitor) ) {
				if( readSymbexStepLog(monitor) ) {
					if( readSymbexReportLog(monitor) ) {
						//!! THAT'S END
					}
				}
			}

			doRefresh(commandLine, workingDirectory);
		}
	}


	private boolean readSymbexInitLog(IProgressMonitor monitor) {
		try {
			while( true ) {
				if( fProcessBufferedReader.ready() ) {
					if( (traceLine = fProcessBufferedReader.readLine()) != null )
					{
						if( traceLine.isEmpty() ) {
							if( enablePrintEmptyLine ) {
								fConsoleBufferedWriter.append('\n');
							}
							else {
								enablePrintEmptyLine = true;
							}

							continue;
						}
						else if( traceLine.startsWith(UNKNOWN_LAUNCH_OPTION) ) {
							// PROBABLY
							// Unknown AVM launch option:
							// << --enable-print-spider-positions >> !!!

							if( traceLine.lastIndexOf(
									SymbexJob.SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS) > 0 ) {

								enableLegacyDiversity = true;

								continue;
							}
						}
						else if( traceLine.startsWith(SPIDER_TRACE_INIT_PREFIX) )
						{
							final int[] bounds = spiderPositions(traceLine);
							System.out.print( traceLine );
							System.out.println( Arrays.toString(bounds) );

							fSpider.resetSpider( (bounds.length == 6)
									? SPIDER_GEOMETRY.PENTAGON
									: SPIDER_GEOMETRY.TETRAGON );

							initSpider( spiderPositions(traceLine) );

							disabledSpiderTrace = false;

							enablePrintEmptyLine = false;

							return true;
						}
						else if( traceLine.startsWith(SYMBEX_TRACE_BOUND_PREFIX) )
						{
							System.out.print(traceLine + " --> ");
							System.out.println(
									Arrays.toString(spiderPositions(traceLine)) );

//							initSpider(traceLine);
							initSpider( spiderPositions(traceLine) );

							enablePrintEmptyLine = false;

							fConsoleBufferedWriter.append(traceLine).append('\n');
							fConsoleBufferedWriter.flush();

							return true;
						}
						else {
							enablePrintEmptyLine = true;
						}

						fConsoleBufferedWriter.append(traceLine).append('\n');
						fConsoleBufferedWriter.flush();
					}
				}
				else {
					try {
						fSymbexProcess.exitValue();
						break;
					}
					catch( IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ){
					terminateProcess();

					return false;
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return true;
	}

	private boolean readSymbexStepLog(IProgressMonitor monitor) {
		try {
			while( true ) {
				if( fProcessBufferedReader.ready() ) {
					if( (traceLine = fProcessBufferedReader.readLine()) != null )
					{
						if( traceLine.isEmpty() ) {
							if( enablePrintEmptyLine ) {
								fConsoleBufferedWriter.append('\n');
							}
							else {
								enablePrintEmptyLine = true;
							}

							continue;
						}
						else if( traceLine.startsWith(SPIDER_TRACE_STEP_PREFIX) )
						{
							System.out.print( traceLine );
							System.out.println(
									Arrays.toString(spiderPositions(traceLine)) );

							updateSpider( spiderPositions(traceLine) );

							enablePrintEmptyLine = false;

							continue;
						}
						else if( traceLine.startsWith(SPIDER_TRACE_STOP_PREFIX) )
						{
							System.out.print( traceLine );
							System.out.println(
									Arrays.toString(spiderPositions(traceLine)) );

							updateSpider( spiderPositions(traceLine) );

							enablePrintEmptyLine = false;

							return true;
						}
						else if( traceLine.startsWith(SYMBEX_TRACE_STEP_PREFIX) )
						{
							if( disabledSpiderTrace ) {
								System.out.print(traceLine + " --> ");
								System.out.println(
										Arrays.toString(spiderPositions(traceLine)) );

								updateSpider( spiderPositions(traceLine) );
							}

							enablePrintEmptyLine = false;
						}
						else if( traceLine.startsWith(SYMBEX_TRACE_STOP_PREFIX) )
						{
							if( disabledSpiderTrace ) {
								System.out.print(traceLine + " --> ");
								System.out.println(
										Arrays.toString(spiderPositions(traceLine)) );

//								majSpider(traceLine);
								updateSpider( spiderPositions(traceLine) );
							}

							enablePrintEmptyLine = false;

							return true;
						}
						else {
							enablePrintEmptyLine = true;
						}

						fConsoleBufferedWriter.append(traceLine).append('\n');
						fConsoleBufferedWriter.flush();
					}
				}
				else {
					try {
						fSymbexProcess.exitValue();
						break;
					}
					catch( IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ){
					terminateProcess();

					return false;
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return true;
	}

	private boolean readSymbexReportLog(IProgressMonitor monitor) {
		try {
			while( true ) {
				if( fProcessBufferedReader.ready() ) {
					if( (traceLine = fProcessBufferedReader.readLine()) != null )
					{
						if( traceLine.isEmpty() ) {
							if( enablePrintEmptyLine ) {
								fConsoleBufferedWriter.append('\n');
							}
							else {
								enablePrintEmptyLine = true;
							}

							continue;
						}
						else {
							fConsoleBufferedWriter.append(traceLine).append('\n');
							fConsoleBufferedWriter.flush();
						}
					}
				}
				else {
					try {
						fSymbexProcess.exitValue();
						break;
					}
					catch( IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ){
					terminateProcess();

					return false;
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			if( fSymbexProcess != null ) {
				fSymbexProcess.destroy();
			}
			monitor.done();
		}

		return true;
	}


	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	// SPIDER SECTION
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	private static final int INT_INIFINITE = 0;

	private static final int DEFAULT_PERIOD_VALUE = 10;

	private int nbStep;
	private int maxStep = 0;
	private boolean resizeStep = false;
	private int stepStep = DEFAULT_PERIOD_VALUE;

	private int nbContext;
	private int maxContext = 0;
	private boolean resizeContext = false;
	private int stepContext = DEFAULT_PERIOD_VALUE;

	private int nbHeight;
	private int maxHeight = 0;
	private int oldNbHeight = 0;
	private int currentNbHeight = 0;
	private boolean resizeHeight = false;
	private int stepHeight = DEFAULT_PERIOD_VALUE;

	private int nbWidth;
	private int maxWidth = 0;
	private int oldNbWidth = 0;
	private int currentNbWidth = 0;
	private boolean resizeWidth = false;
	private int stepWidth = DEFAULT_PERIOD_VALUE;

	private int nbCoverage;
	private int maxCoverage = 0;


	private void initSpider(int[] bounds) {
		initVar();
		initMaxAndResize( bounds );
	}

	private void updateSpider(int[] bounds) {
		majDisplayedData( bounds );

		majStepAndMax();

		fSpider.updateSpider(nbExecution, nbStep, maxStep, nbContext, maxContext,
				nbHeight, maxHeight, nbWidth, maxWidth, nbCoverage, maxCoverage);
	}


	private void initVar() {
		maxStep = 0;
		resizeStep = false;
		stepStep = DEFAULT_PERIOD_VALUE;

		maxContext = 0;
		resizeContext = false;
		stepContext = DEFAULT_PERIOD_VALUE;

		maxHeight = 0;
		oldNbHeight = 0;
		currentNbHeight = 0;
		resizeHeight = false;
		stepHeight = DEFAULT_PERIOD_VALUE;

		maxWidth = 0;
		oldNbWidth = 0;
		currentNbWidth = 0;
		resizeWidth = false;
		stepWidth = DEFAULT_PERIOD_VALUE;

		maxCoverage = 0;
	}

	private void initMaxAndResize(int[] bounds) {
		resizeStep = (bounds[0] == INT_INIFINITE);
		maxStep = resizeStep ? DEFAULT_PERIOD_VALUE : bounds[0];

		resizeContext = (bounds[1] == INT_INIFINITE);
		maxContext = resizeContext ? DEFAULT_PERIOD_VALUE : bounds[1];;

		resizeHeight = (bounds[2] == INT_INIFINITE);
		maxHeight = resizeHeight ? DEFAULT_PERIOD_VALUE : bounds[2];

		resizeWidth = (bounds[3] == INT_INIFINITE);
		maxWidth = resizeWidth ? DEFAULT_PERIOD_VALUE : bounds[3];

		if ( bounds.length > 5 ) {
			resizeWidth = (bounds[3] == INT_INIFINITE);
			maxWidth = resizeWidth ? DEFAULT_PERIOD_VALUE : bounds[3];

			maxCoverage = (bounds[5] == INT_INIFINITE) ? DEFAULT_PERIOD_VALUE : bounds[5];
		}
	}


	private void majDisplayedData(int[] positions) {
		nbStep = positions[0];

		nbContext = positions[1];

		currentNbHeight = positions[2];

		nbHeight = ( currentNbHeight > oldNbHeight ) ?
				currentNbHeight : oldNbHeight;

		currentNbWidth = positions[3];

		nbWidth = ( currentNbWidth > oldNbWidth ) ?
				currentNbWidth : oldNbWidth;

		if ( positions.length > 4 ) {
			nbCoverage = positions[4];
		}
	}


	private void majStepAndMax() {
		if ( resizeStep ) {
			while ( nbStep >= maxStep ) {
				if ( maxStep/stepStep <= 9 ) {
					maxStep = maxStep + stepStep;
				}
				else {
					stepStep = stepStep * DEFAULT_PERIOD_VALUE;
					maxStep = stepStep;
				}
			}
		}
		if ( resizeContext ) {
			while ( nbContext >= maxContext ) {
				if ( maxContext/stepContext <= 9 ) {
					maxContext = maxContext + stepContext;
				}
				else {
					stepContext = stepContext * DEFAULT_PERIOD_VALUE;
					maxContext = stepContext;
				}
			}
		}
		if ( resizeHeight ) {
			while ( nbHeight >= maxHeight ) {
				if ( maxHeight/stepHeight <= 9 ) {
					maxHeight = maxHeight + stepHeight;
				}
				else {
					stepHeight = stepHeight * DEFAULT_PERIOD_VALUE;
					maxHeight = stepHeight;
				}
			}
		}
		if ( resizeWidth ) {
			while ( nbWidth >= maxWidth ) {
				if ( maxWidth/stepWidth <= 9 ) {
					maxWidth = maxWidth + stepWidth;
				}
				else {
					stepWidth = stepWidth * DEFAULT_PERIOD_VALUE;
					maxWidth = stepWidth;
				}
			}
		}
	}

}
