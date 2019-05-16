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
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;
import org.eclipse.efm.execution.core.preferences.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.preferences.SymbexPreferenceUtil;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.launchconfiguration.HelpContextIdConstants;
import org.eclipse.efm.execution.launchconfiguration.LaunchDelegate;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJob;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJobFactory;
import org.eclipse.efm.execution.launchconfiguration.job.action.ChangeSashFormOrientationAction;
import org.eclipse.efm.execution.launchconfiguration.job.action.CloseAllConsoleAction;
import org.eclipse.efm.execution.launchconfiguration.job.action.CloseConsoleAction;
import org.eclipse.efm.execution.launchconfiguration.job.action.RestartAction;
import org.eclipse.efm.execution.launchconfiguration.job.action.RunSelectedSymbexWorkflowAction;
import org.eclipse.efm.execution.launchconfiguration.job.action.TerminateAction;
import org.eclipse.efm.execution.launchconfiguration.job.action.TerminateAllAction;
import org.eclipse.efm.execution.launchconfiguration.job.action.TerminateRestartAction;
import org.eclipse.efm.execution.launchconfiguration.ui.views.page.SWTSpider;
import org.eclipse.efm.execution.launchconfiguration.ui.views.page.SWTSpider.SPIDER_GEOMETRY;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.internal.console.IOConsolePage;
import org.osgi.service.prefs.BackingStoreException;

@SuppressWarnings("restriction")
public class SymbexSpiderConsolePage extends IOConsolePage
		implements IWorkflowConfigurationConstants,
		IWorkflowPreferenceConstants , IWorkflowSpiderConfigurationUtils {

	private Composite fMainPageControl;
	private final SymbexSpiderConsole fMessageConsole;

	private SashForm fSashForm;

	private SWTSpider fSpider;

	public final static String LAYOUT_GROUP  = "layoutGroup"; //$NON-NLS-1$

	public final static String RUN_SEW_GROUP = "runSEWGroup"; //$NON-NLS-1$

	public final static String RESTART_GROUP = "restartGroup"; //$NON-NLS-1$


	private ChangeSashFormOrientationAction fChangeSashFormOrientationAction;

	private RunSelectedSymbexWorkflowAction fRunSelectedSymbexWorkflowAction;

	private RestartAction fRestartAction;

	private TerminateRestartAction fTerminateRestartAction;

	private TerminateAction fTerminateAction;

	private CloseConsoleAction fCloseConsoleAction;

	private CloseAllConsoleAction fCloseAllConsoleAction;

	private TerminateAllAction fTerminateAllAction;


	public SymbexSpiderConsolePage(
			final SymbexSpiderConsole console, final IConsoleView view)
	{
		super(console, view);

		fMessageConsole = console;
	}

	public MessageConsole getMessageConsole() {
		return fMessageConsole;
	}


	public void changeSashFormOrientation() {
		if( fSashForm.getOrientation() == SWT.VERTICAL ) {
			fSashForm.setOrientation(SWT.HORIZONTAL);
		}
		else {
			fSashForm.setOrientation(SWT.VERTICAL);
		}
	}


    @Override
	public void createControl(final Composite parent) {
		// Create the SashForm that contains the selection area on the left,
		// and the edit area on the right
    	fMainPageControl = fSashForm = new SashForm(parent, SWT.SMOOTH);
		final GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		fSashForm.setLayoutData(gd);
		fSashForm.setFont(parent.getFont());
		fSashForm.setVisible(true);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(fSashForm,
				HelpContextIdConstants.sew_view_SymbexConsoleSpider);

		fSpider = createSpider(fSashForm,
				LaunchDelegate.fModelAnalysisProfile.getLiteral().toUpperCase());

		super.createControl(fSashForm);

		// Sash: restore/save orientation & weights
		restoreSashConfiguration();

		fSashForm.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(final DisposeEvent e) {
				saveSashConfiguration();
			}
		});
    }

    private void restoreSashConfiguration() {

    	final IEclipsePreferences prefs = SymbexPreferenceUtil.getPreference();

		// SASH ORIENTATION
		final int orientation = prefs.getInt(
				PREF_SYMBEX_CONSOLE_SASH_ORIENTATION, SWT.HORIZONTAL);
		fSashForm.setOrientation(orientation);

		// SASH _WEIGHTS
		fSashForm.setWeights( new int[] {
				prefs.getInt(PREF_SYMBEX_CONSOLE_SASH_WEIGHT_CHILD_0, 40),
				prefs.getInt(PREF_SYMBEX_CONSOLE_SASH_WEIGHT_CHILD_1, 60) } );
   }

    private void saveSashConfiguration() {
    	final IEclipsePreferences prefs = SymbexPreferenceUtil.getPreference();

		// SASH ORIENTATION
    	prefs.putInt(
				PREF_SYMBEX_CONSOLE_SASH_ORIENTATION,
				fSashForm.getOrientation());


		// SASH _WEIGHTS
		final int[] weights = fSashForm.getWeights();
		prefs.putInt(PREF_SYMBEX_CONSOLE_SASH_WEIGHT_CHILD_0, weights[0]);
		prefs.putInt(PREF_SYMBEX_CONSOLE_SASH_WEIGHT_CHILD_1, weights[1]);

		try {
			prefs.flush();
		}
		catch (final BackingStoreException e) {
			e.printStackTrace();
		}
    }

	private SWTSpider createSpider(final Composite parent, final String title)
	{
		final ScrolledComposite compSpider = new ScrolledComposite (parent,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.RESIZE);

		fSpider = new SWTSpider(compSpider, SWT.NULL, title);
		compSpider.setContent(fSpider);
		compSpider.setExpandHorizontal(true);
		compSpider.setExpandVertical(true);
		compSpider.setMinSize(480, 420);

		final GridData dataLeft = new GridData();
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

		fChangeSashFormOrientationAction = new ChangeSashFormOrientationAction(this);

		fRunSelectedSymbexWorkflowAction = new RunSelectedSymbexWorkflowAction(this);

		fRestartAction = new RestartAction(this);

		fTerminateRestartAction = new TerminateRestartAction(this);

		fTerminateAction = new TerminateAction(this);

		fCloseConsoleAction = new CloseConsoleAction(this);

		fCloseAllConsoleAction = new CloseAllConsoleAction();

		fTerminateAllAction = new TerminateAllAction();
	}


	@Override
	protected void contextMenuAboutToShow(final IMenuManager menuManager) {
		super.contextMenuAboutToShow(menuManager);

		menuManager.add(fChangeSashFormOrientationAction);

		menuManager.add(fRunSelectedSymbexWorkflowAction);

		menuManager.add(fRestartAction);
		menuManager.add(fTerminateRestartAction);

		menuManager.add(fTerminateAction);
		menuManager.add(fCloseConsoleAction);

		menuManager.add(fCloseAllConsoleAction);
		menuManager.add(fTerminateAllAction);
	}


	@Override
	protected void configureToolBar(final IToolBarManager mgr) {
        super.configureToolBar(mgr);

        mgr.insertBefore(IConsoleConstants.LAUNCH_GROUP, new Separator(LAYOUT_GROUP));
        mgr.insertBefore(IConsoleConstants.LAUNCH_GROUP, new GroupMarker(LAYOUT_GROUP));

        mgr.insertBefore(IConsoleConstants.LAUNCH_GROUP, new Separator(RUN_SEW_GROUP));
        mgr.insertBefore(IConsoleConstants.LAUNCH_GROUP, new GroupMarker(RUN_SEW_GROUP));

        mgr.insertBefore(IConsoleConstants.LAUNCH_GROUP, new Separator(RESTART_GROUP));
        mgr.insertBefore(IConsoleConstants.LAUNCH_GROUP, new GroupMarker(RESTART_GROUP));

        mgr.appendToGroup(LAYOUT_GROUP, fChangeSashFormOrientationAction);

        mgr.appendToGroup(RUN_SEW_GROUP, fRunSelectedSymbexWorkflowAction);

        mgr.appendToGroup(RESTART_GROUP, fRestartAction);
        mgr.appendToGroup(RESTART_GROUP, fTerminateRestartAction);

        mgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fTerminateAction);
        mgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fCloseConsoleAction);
        mgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fCloseAllConsoleAction);
        mgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, fTerminateAllAction);
    }


	public void disposeAction() {
        if (fChangeSashFormOrientationAction != null) {
        	fChangeSashFormOrientationAction.dispose();
        	fChangeSashFormOrientationAction = null;
        }

        if (fRunSelectedSymbexWorkflowAction != null) {
        	fRunSelectedSymbexWorkflowAction.dispose();
        	fRunSelectedSymbexWorkflowAction = null;
        }

        if (fRestartAction != null) {
        	fRestartAction.dispose();
        	fRestartAction = null;
        }

        if (fTerminateRestartAction != null) {
        	fTerminateRestartAction.dispose();
        	fTerminateRestartAction = null;
        }

        if (fTerminateAction != null) {
        	fTerminateAction.dispose();
        	fTerminateAction = null;
        }

        if (fCloseConsoleAction != null) {
        	fCloseConsoleAction.dispose();
        	fCloseConsoleAction = null;
        }
    }



    @Override
	public void dispose() {
    	disposeAction();

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

//	private boolean enableLegacyDiversity = false;


	private void doRefresh(final String[] commandLine, final File workingDirectory) {
		IResource symbexWorkflowResource = null;
		if( (commandLine != null) && (commandLine.length > 1) )
		{
			final IPath symbexWorkflowPath = new Path(commandLine[1]);

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
		catch(final CoreException e) {
			e.printStackTrace();
		}
	}


	public void sewLaunchExecProcess(final String mode,
			final IProgressMonitor monitor, final String[] commandLine,
			final IPath workingDirectory, final String[] envp)
	{
		fMode = mode;
		fMonitor = monitor;
		fCommandLine = commandLine;
		fWorkingDirectory = workingDirectory;
		fEnvp = envp;

		if( startSymbexProcess(commandLine, workingDirectory, envp) ) {
			fMessageConsole.clearConsole();

			if ( fSpider != null ) {
				fSpider.resetSpider(
						LaunchDelegate.fModelAnalysisProfile.getLiteral().toUpperCase(),
						SPIDER_GEOMETRY.TETRAGON);
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

			doRefresh(commandLine, workingDirectory.toFile());

			updateActionEndingProcess();
		}
	}


	private Process fSymbexProcess;

	private BufferedWriter fConsoleBufferedWriter;
	private BufferedReader fProcessBufferedReader;

	// LOCALS
	private String traceLine = null;


	private boolean startSymbexProcess(final String[] commandLine,
			final IPath workingDirectory, final String[] envp)
	{
		if( ! isAutoScroll() ) {
			setAutoScroll(true);
		}

		final OutputStream outputStream = fMessageConsole.newOutputStream();
		final OutputStreamWriter outputStreamWriter =
				new OutputStreamWriter(outputStream);

		fConsoleBufferedWriter = new BufferedWriter(outputStreamWriter);

		ProcessBuilder processBuilder = new ProcessBuilder(commandLine);
		processBuilder = processBuilder.redirectErrorStream(true);
		processBuilder.directory(workingDirectory.toFile());

		try {
			fSymbexProcess = processBuilder.start();

			updateActionBeginningProcess();

		} catch (final IOException e1) {
			e1.printStackTrace();
		}

//		try {
//			fSymbexProcess = DebugPlugin.exec(commandLine, workingDirectory, envp);
//
//			updateActionBeginningProcess();
//		} catch (CoreException e1) {
//			e1.printStackTrace();
//			fSymbexProcess = null;
//		}

		if( fSymbexProcess != null ) {

			final InputStream inputStream = fSymbexProcess.getInputStream();
			final InputStreamReader inputStreamReader =
					new InputStreamReader(inputStream);

			fProcessBufferedReader = new BufferedReader(inputStreamReader);

			return true;
		}

		return false;
	}


	public String getProcessName() {
		if( fConfiguration != null ) {
			return fConfiguration.getName();
		}
		else if( (fCommandLine != null) && (fCommandLine.length > 1) ) {
			final IPath sewPath = new Path(fCommandLine[1]);
			return sewPath.lastSegment();
		}

		return "Process";
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
			} catch (final IOException e) {
				e.printStackTrace();
			}

	        updateActionEndingProcess();
		}
	}

	private void updateActionBeginningProcess() {
		if (fRestartAction != null) {
			fRestartAction.setEnabled(false);
		}
		if (fTerminateAction != null) {
			fTerminateAction.setEnabled(true);
		}
		if (fTerminateRestartAction != null) {
			fTerminateRestartAction.setEnabled(true);
		}
		if (fCloseConsoleAction != null) {
			fCloseConsoleAction.setEnabled(false);
		}

		if (fCloseAllConsoleAction != null) {
			fCloseAllConsoleAction.update();
		}
		if (fTerminateAllAction != null) {
			fTerminateAllAction.update();
		}
	}

	private void updateActionEndingProcess() {
		if (fRestartAction != null) {
			fRestartAction.setEnabled(true);
		}
		if (fTerminateAction != null) {
			fTerminateAction.setEnabled(false);
		}
		if (fTerminateRestartAction != null) {
			fTerminateRestartAction.setEnabled(false);
		}
		if (fCloseConsoleAction != null) {
			fCloseConsoleAction.setEnabled(true);
		}


		if (fCloseAllConsoleAction != null) {
			fCloseAllConsoleAction.update();
		}
		if (fTerminateAllAction != null) {
			fTerminateAllAction.update();
		}
	}


	public void closePage() {
		terminateProcess();

		SymbexJob.removeConsole(fMessageConsole);
	}


	private ILaunchConfiguration fConfiguration;
	private String fMode;
	private ILaunch fLaunch;
	IProgressMonitor fMonitor;
	private String[] fCommandLine;
	private IPath fWorkingDirectory;
	private String[] fEnvp;

	public void restartProcess() {
		if( (fConfiguration != null) && (fLaunch != null) ) {
			SymbexJobFactory.run(fConfiguration, fMode, fLaunch, //fMonitor,
					fCommandLine, fWorkingDirectory, fEnvp);
		}
		else {
			SymbexJobFactory.run(fMode, //fMonitor,
					fCommandLine, fWorkingDirectory, fEnvp);
		}
	}

	public void TerminateRestartProcess() {
		terminateProcess();

		restartProcess();
	}


	///////////////////////////////////////////////////////////////////////////
	// SYMBEX PROCESS LAUCHER
	///////////////////////////////////////////////////////////////////////////

	public void sewLaunchExecProcess(final ILaunchConfiguration configuration,
			final String mode, final ILaunch launch,
			final IProgressMonitor monitor, final String[] commandLine,
			final IPath workingDirectory, final String[] envp)
	{
		fConfiguration = configuration;
		fMode = mode;
		fLaunch = launch;
		fMonitor = monitor;
		fCommandLine = commandLine;
		fWorkingDirectory = workingDirectory;
		fEnvp = envp;

		if( startSymbexProcess(commandLine, workingDirectory, envp) ) {
			fMessageConsole.clearConsole();

			if ( fSpider != null ) {
				fSpider.resetSpider(
						LaunchDelegate.fModelAnalysisProfile.getLiteral().toUpperCase(),
						SPIDER_GEOMETRY.TETRAGON);
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

			doRefresh(commandLine, workingDirectory.toFile());
		}
	}


	private boolean readSymbexInitLog(final IProgressMonitor monitor) {
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

							if( traceLine.lastIndexOf(SymbexJob.
								SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS) > 0 )
							{
//								enableLegacyDiversity = true;

								continue;
							}
						}
						else if( traceLine.startsWith(SPIDER_TRACE_INIT_PREFIX) )
						{
							final int[] bounds = spiderPositions(traceLine);
							System.out.print( traceLine );
							System.out.println( Arrays.toString(bounds) );

							fSpider.resetSpider(
									LaunchDelegate.fModelAnalysisProfile.getLiteral().toUpperCase(),
									(bounds.length == 6)
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
					catch( final IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ){
					terminateProcess();

					return false;
				}
			}
		}
		catch(final IOException e){
			e.printStackTrace();
		}

		return true;
	}

	private boolean readSymbexStepLog(final IProgressMonitor monitor) {
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
//							System.out.print( traceLine );
//							System.out.println(
//									Arrays.toString(spiderPositions(traceLine)) );

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
//								System.out.print(traceLine + " --> ");
//								System.out.println(
//										Arrays.toString(spiderPositions(traceLine)) );

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
					catch( final IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ){
					terminateProcess();

					return false;
				}
			}
		}
		catch(final IOException e){
			e.printStackTrace();
		}

		return true;
	}

	private boolean readSymbexReportLog(final IProgressMonitor monitor) {
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

							int startExit = traceLine.indexOf(SYMBEX_EXIT_TAG);
							if( startExit > 0 ) {
								startExit += SYMBEX_EXIT_TAG.length() + 2;
								int startPos = traceLine.indexOf(
										SYMBEX_VERDICT_TAG, startExit);
								if( startPos > 0 ) {
									startPos += SYMBEX_VERDICT_TAG.length() + 1;
									final int endPos =
											traceLine.indexOf(" >", startPos);
									if( endPos > 0 ) {
										final String strVerdict =
												traceLine.substring(startPos, endPos);

										showSymbexVerdict(strVerdict);

//										if( strVerdict.contains(SYMBEX_VERDICT_PASS) )
//										{
//											showSymbexVerdict(SYMBEX_VERDICT_PASS);
//
//	//										openDialog("The Trace is CONFORM !", true);
//										}
//										else if( strVerdict.contains(SYMBEX_VERDICT_FAIL) )
//										{
//											showSymbexVerdict(SYMBEX_VERDICT_FAIL);
//
//	//										openDialog("The Trace is NOT CONFORM !!!", false);
//										}
									}
								}
								else if( (startPos = traceLine.indexOf(
										SYMBEX_COVERAGE_TAG, startExit)) > 0 )
								{
									startPos += SYMBEX_COVERAGE_TAG.length() + 1;

									final int endPos = traceLine.indexOf(" >", startPos);

									if( endPos > 0 ) {
										final String strVerdict =
												traceLine.substring(startPos, endPos);

										if( strVerdict.contains(SYMBEX_GOAL_ACHIEVED) )
										{
											showSymbexVerdict("100%");

	//										openDialog("The Objective is ACHIEVED !!!", false);
										}
									}
								}
							}
						}
					}
				}
				else {
					try {
						fSymbexProcess.exitValue();
						break;
					}
					catch( final IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ){
					terminateProcess();

					return false;
				}
			}
		}
		catch(final IOException e){
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


	private void initSpider(final int[] bounds) {
		initVar();
		initMaxAndResize( bounds );
	}

	private void updateSpider(final int[] bounds) {
		majDisplayedData( bounds );

		majStepAndMax();

		fSpider.updateSpider(nbExecution, nbStep, maxStep, nbContext, maxContext,
				nbHeight, maxHeight, nbWidth, maxWidth, nbCoverage, maxCoverage);
	}


	private void showSymbexVerdict(final String strVerdict) {
		fSpider.showSymbexVerdict(strVerdict);
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

	private void initMaxAndResize(final int[] bounds) {
		resizeStep = (bounds[0] == INT_INIFINITE);
		maxStep = resizeStep ? DEFAULT_PERIOD_VALUE : bounds[0];

		resizeContext = (bounds[1] == INT_INIFINITE);
		maxContext = resizeContext ? DEFAULT_PERIOD_VALUE : bounds[1];

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


	private void majDisplayedData(final int[] positions) {
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
		if ( resizeStep || (resizeStep = (nbStep >= maxStep)) ) {
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
		if ( resizeContext || (resizeContext = (nbContext >= maxContext)) ) {
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
		if ( resizeHeight || (resizeHeight = (nbHeight >= maxHeight)) ) {
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
		if ( resizeWidth || (resizeWidth = (nbWidth >= maxWidth)) ) {
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


	protected void openDialog(final String strMessage, final boolean isInfo)
	{
		Display display = PlatformUI.getWorkbench().getDisplay();
		if( display == null ) {
			display = Display.getDefault();
		}
		final Display finalDisplay = display;

		finalDisplay.syncExec(new Runnable() {
		    @Override
			public void run() {
		    	if( isInfo ) {
					MessageDialog.openInformation(finalDisplay.getActiveShell(),
							"Diversity Conformance Checking" , strMessage);
		    	}
		    	else {
					MessageDialog.openError(finalDisplay.getActiveShell(),
							"Diversity Conformance Checking" , strMessage);
		    	}
		    }
		});
	}

}
