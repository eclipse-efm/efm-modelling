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
package org.eclipse.efm.execution.launchconfiguration.ui.views.page;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;
import org.eclipse.efm.execution.core.util.WorkflowFileUtils;
import org.eclipse.efm.execution.launchconfiguration.HelpContextIdConstants;
import org.eclipse.efm.execution.launchconfiguration.LaunchDelegate;
import org.eclipse.efm.execution.launchconfiguration.job.SymbexJob;
import org.eclipse.efm.execution.launchconfiguration.ui.views.page.SWTSpider.SPIDER_GEOMETRY;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.part.Page;

public class SEWConsoleSpiderPage extends Page
		implements IWorkflowSpiderConfigurationUtils {

//	public SymbexSpiderConsolePage(TextConsole console, IConsoleView view) {
//		super(console, view);
//	}

	private Composite fMainPageControl;

//	private Composite compSpider;
	private ScrolledComposite compSpider;

	protected SEWConsoleViewer fConsoleViewer;
	private IOConsole fSEWDashbordConsole;

	private SashForm fSashForm;

	private SWTSpider fSpider;


	@Override
	public void createControl(final Composite parent) {
		fMainPageControl = new Composite(parent, SWT.RESIZE | SWT.BORDER);
		fMainPageControl.setLayout( new GridLayout(1, true) );

		PlatformUI.getWorkbench().getHelpSystem().setHelp(fMainPageControl, HelpContextIdConstants.sew_view_SymbexConsoleSpider);

		// Create the SashForm that contains the selection area on the left,
		// and the edit area on the right
		fSashForm = new SashForm(fMainPageControl, SWT.SMOOTH);
		fSashForm.setOrientation(SWT.HORIZONTAL);
		final GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		fSashForm.setLayoutData(gd);
		fSashForm.setFont(parent.getFont());
		fSashForm.setVisible(true);

		fSpider = createSpider(fSashForm, 100, 90, 150,
				LaunchDelegate.fModelAnalysisProfile.getLiteral().toUpperCase());

		createConsoleViewer(fSashForm);

		fSashForm.setWeights(new int[] {40, 60});
	}

	private void createConsoleViewer(final Composite parent) {
		final Composite comp = new Composite(parent, SWT.BORDER | SWT.RESIZE);

		fSEWDashbordConsole = new IOConsole("SEW-Console", null);

		final GridData dataRight = new GridData();
		dataRight.horizontalSpan = 2;
        dataRight.grabExcessHorizontalSpace = true;
        dataRight.grabExcessVerticalSpace = true;
        dataRight.horizontalAlignment = SWT.FILL;
        dataRight.verticalAlignment = SWT.FILL;

		fConsoleViewer = new SEWConsoleViewer(comp, fSEWDashbordConsole);

		comp.setLayout(new FillLayout());
		comp.setLayoutData(dataRight);
	}

	private SWTSpider createSpider(final Composite parent,
			final int x, final int y, final int r, final String title)
	{
//		Group group = SWTFactory.createGroup(parent, "", 1, 1, GridData.FILL_BOTH);
//		group.setText("MODEL ANALYSIS");

		compSpider = new ScrolledComposite (parent,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.RESIZE);

		fSpider = new SWTSpider(compSpider, SWT.NULL, x, y, r, title);
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
	///////////////////////////////////////////////////////////////////////////
	// AVM PROCESS MANAGER
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	// for COMPATIBILITY
	private int nbExecution;

	private boolean disabledSpiderTrace = true;

	private boolean enablePrintEmptyLine = true;


	private final static String UNKNOWN_LAUNCH_OPTION = "Unknown AVM launch option";

	private boolean enableLegacyDiversity = false;


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


	public void sewLaunchExecProcess(final ILaunchConfiguration configuration,
			final String mode, final ILaunch launch, final IProgressMonitor monitor,
			final String[] commandLine, final File workingDirectory, final String[] envp) {

		if( startSymbexProcess(commandLine, workingDirectory, envp) ) {
			fSEWDashbordConsole.clearConsole();

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


	private Process fSymbexProcess;

	private BufferedWriter fConsoleBufferedWriter;
	private BufferedReader fProcessBufferedReader;

	// LOCALS
	private String traceLine = null;


	private boolean startSymbexProcess(
			final String[] commandLine, final File workingDirectory, final String[] envp) {
		final OutputStream outputStream = fSEWDashbordConsole.newOutputStream();
		final OutputStreamWriter outputStreamWriter =
				new OutputStreamWriter(outputStream);

		fConsoleBufferedWriter = new BufferedWriter(outputStreamWriter);

		ProcessBuilder processBuilder = new ProcessBuilder(commandLine);
		processBuilder = processBuilder.redirectErrorStream(true);
		processBuilder.directory(workingDirectory);

		try {
			fSymbexProcess = processBuilder.start();
		} catch (final IOException e1) {
			e1.printStackTrace();
		}

//		try {
//			fSymbexProcess = DebugPlugin.exec(commandLine, workingDirectory, envp);
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

							if( traceLine.lastIndexOf(
									SymbexJob.SYMBEX_LAUNCH_OPTION_ENABLE_PRINT_SPIDER_POSITIONS) > 0 ) {

								enableLegacyDiversity = true;

								continue;
							}
						}
						else if( traceLine.startsWith(SPIDER_TRACE_INIT_PREFIX) )
						{
							final int[] bounds = spiderPositions(traceLine);
//							System.out.print( traceLine );
//							System.out.println( Arrays.toString(bounds) );

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
//							System.out.print(traceLine + " --> ");
//							System.out.println(
//									Arrays.toString(spiderPositions(traceLine)) );

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
//							System.out.print( traceLine );
//							System.out.println(
//									Arrays.toString(spiderPositions(traceLine)) );

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

//								majSpider(traceLine);
								updateSpider( spiderPositions(traceLine) );
							}

							enablePrintEmptyLine = false;
						}
						else if( traceLine.startsWith(SYMBEX_TRACE_STOP_PREFIX) )
						{
							if( disabledSpiderTrace ) {
//								System.out.print(traceLine + " --> ");
//								System.out.println(
//										Arrays.toString(spiderPositions(traceLine)) );

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

	private static final int INT_INIFINITE = 0;

	private static final String CONSOLE_INIFINITE_SYMBOL = "+oo";
	private static final String CONSOLE_CONTEXT_SYMBOL   = "context:";
	private static final String CONSOLE_COVERAGE_SYMBOL  = "coverage:";

	private static final String CONSOLE_STEP_SYMBOL      = "step:";
	private static final String CONSOLE_HEIGHT_SYMBOL    = "height:";
	private static final String CONSOLE_WIDTH_SYMBOL     = "width:";


	private void initMaxAndResize(final int[] bounds) {
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

	// DEPRECATED for COMPATIBILITY
	private void initSpider(final String traceLine) {
		final String tmpString = traceLine.replaceAll(" ", "");
		initVar();
		initMaxAndResize( tmpString );
	}


	private void initMaxAndResize(final String aString) {
		String s = aString.substring(CONSOLE_STEP_SYMBOL.length(),
				aString.indexOf(CONSOLE_CONTEXT_SYMBOL) - 1);

		resizeStep = s.equals(CONSOLE_INIFINITE_SYMBOL);
		maxStep = resizeStep ? DEFAULT_PERIOD_VALUE : Integer.parseInt(s);

		s = aString.substring(
				aString.indexOf(CONSOLE_CONTEXT_SYMBOL) +
						CONSOLE_CONTEXT_SYMBOL.length(),
				aString.indexOf(CONSOLE_HEIGHT_SYMBOL) - 1);

		resizeContext = s.equals(CONSOLE_INIFINITE_SYMBOL);
		maxContext = resizeContext ? DEFAULT_PERIOD_VALUE : Integer.parseInt(s);

		s = aString.substring(
				aString.indexOf(CONSOLE_HEIGHT_SYMBOL) +
						CONSOLE_HEIGHT_SYMBOL.length(),
				aString.indexOf(CONSOLE_WIDTH_SYMBOL)-1);

		resizeHeight = s.equals(CONSOLE_INIFINITE_SYMBOL);
		maxHeight = resizeHeight ? DEFAULT_PERIOD_VALUE : Integer.parseInt(s);


		if ( ( nbExecution == 1 )
			&& LaunchDelegate.isLaunchExplorationProfileFamily() ) {

			s = aString.substring(
					aString.indexOf(CONSOLE_WIDTH_SYMBOL) +
							CONSOLE_WIDTH_SYMBOL.length(),
					aString.length());

			resizeWidth = s.equals(CONSOLE_INIFINITE_SYMBOL);
			maxWidth = resizeWidth ? DEFAULT_PERIOD_VALUE : Integer.parseInt(s);
		}
		else if( (nbExecution == 1)
				|| LaunchDelegate.isLaunchCoverageProfileFamily() ) {
			s = aString.substring(
					aString.indexOf(CONSOLE_WIDTH_SYMBOL) +
							CONSOLE_WIDTH_SYMBOL.length(),
					aString.indexOf(CONSOLE_COVERAGE_SYMBOL)-1);

			resizeWidth = s.equals(CONSOLE_INIFINITE_SYMBOL);
			maxWidth = resizeWidth ? DEFAULT_PERIOD_VALUE : Integer.parseInt(s);

			s = aString.substring(aString.indexOf("/")+1);
			maxCoverage = Integer.parseInt(s);
		}
	}

	private void majSpider(final String traceLine) {
		final String tmpString = traceLine.replaceAll(" ", "");

		majDisplayedData( tmpString , nbExecution);

		majStepAndMax();

		fSpider.updateSpider(nbExecution, nbStep, maxStep, nbContext, maxContext,
				nbHeight, maxHeight, nbWidth, maxWidth, nbCoverage, maxCoverage);
	}



	private void majDisplayedData(final String aString, final int nbExe) {
		int beginIndex;
		int endIndex;
		int currentIndex;

		beginIndex = CONSOLE_STEP_SYMBOL.length();
		currentIndex = aString.indexOf(CONSOLE_CONTEXT_SYMBOL);
		endIndex = currentIndex - 1;
		nbStep = Integer.parseInt(aString.substring(beginIndex, endIndex));

		beginIndex = currentIndex + CONSOLE_CONTEXT_SYMBOL.length();
		currentIndex = aString.indexOf(CONSOLE_HEIGHT_SYMBOL);
		endIndex = currentIndex - 1;
		final String number = aString.substring(beginIndex, endIndex);
		nbContext = CONSOLE_INIFINITE_SYMBOL.equals(number) ?
				/*Integer.MAX_VALUE*/ -1 : Integer.parseInt(number);

		beginIndex = currentIndex + CONSOLE_HEIGHT_SYMBOL.length();
		currentIndex = aString.indexOf(CONSOLE_WIDTH_SYMBOL);
		endIndex = currentIndex - 1;

//		nbHeight = Integer.parseInt(aString.substring(beginIndex, endIndex));
		currentNbHeight = Integer.parseInt(
				aString.substring(beginIndex, endIndex));

		nbHeight = ( currentNbHeight > oldNbHeight ) ?
				currentNbHeight : oldNbHeight;

		if ( ( nbExe == 1 ) && LaunchDelegate.isLaunchExplorationProfileFamily() ) {
			beginIndex = currentIndex + 6;
			endIndex = aString.length();

//			nbWidth = Integer.parseInt(aString.substring(beginIndex, endIndex));
			for( endIndex = beginIndex + 1 ; endIndex < aString.length() ; ++endIndex ) {
				if( Character.isJavaIdentifierStart(aString.charAt(endIndex)) ) {
					break;
				}
			}
			currentNbWidth = Integer.parseInt(
					aString.substring(beginIndex, endIndex));

			nbWidth = ( currentNbWidth > oldNbWidth ) ?
					currentNbWidth : oldNbWidth;
		}
		else if ( ( nbExe == 1 ) || LaunchDelegate.isLaunchCoverageProfileFamily() ) {
			beginIndex = currentIndex + CONSOLE_WIDTH_SYMBOL.length();
			currentIndex = aString.indexOf(CONSOLE_COVERAGE_SYMBOL);
			endIndex = currentIndex - 1;

//			nbWidth = Integer.parseInt(aString.substring(beginIndex, endIndex));
			currentNbWidth = Integer.parseInt(
					aString.substring(beginIndex, endIndex));
			nbWidth = ( currentNbWidth > oldNbWidth ) ?
					currentNbWidth : oldNbWidth;

			beginIndex = currentIndex + CONSOLE_COVERAGE_SYMBOL.length();
			endIndex = aString.indexOf("/");
			nbCoverage = Integer.parseInt(
					aString.substring(beginIndex, endIndex));
		}
	}


}
