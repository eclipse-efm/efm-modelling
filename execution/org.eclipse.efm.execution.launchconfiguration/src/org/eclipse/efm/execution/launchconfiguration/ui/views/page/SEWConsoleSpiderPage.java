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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.IWorkflowPreferenceConstants;
import org.eclipse.efm.execution.core.SymbexPreferenceUtil;
import org.eclipse.efm.execution.launchconfiguration.HelpContextIdConstants;
import org.eclipse.efm.execution.launchconfiguration.LaunchDelegate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.part.Page;

@SuppressWarnings("unused")
public class SEWConsoleSpiderPage extends Page
		implements IWorkflowConfigurationConstants, IWorkflowPreferenceConstants {

	private Composite fMainPageControl;

//    private Composite compSpider;
    private ScrolledComposite compSpider;

    private boolean consoleView;
    private boolean spiderView;

    private int nbExecution;
    private boolean firstLine;
    private boolean lastLine;

	private ProcessBuilder avmProcessBuilder;
	private Process avmProcess;

	private SEWConsoleViewer fConsoleViewer;
    private IOConsole fSEWDashbordConsole;

    private SWTSpider fSpider;


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

	@Override
	public void createControl(Composite parent) {
        fMainPageControl = new Composite(parent, SWT.RESIZE | SWT.BORDER);

        PlatformUI.getWorkbench().getHelpSystem().setHelp(fMainPageControl, HelpContextIdConstants.sew_view_SymbexConsoleSpider);

        consoleView = SymbexPreferenceUtil.getBooleanPreference(PREF_CONSOLE_VIEW);
        spiderView = SymbexPreferenceUtil.getBooleanPreference(PREF_SPIDER_VIEW);

        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        layout.makeColumnsEqualWidth = true;
        fMainPageControl.setLayout(layout);

        fSpider = createSpider(fMainPageControl, 100, 90, 150);

        createConsoleViewer(fMainPageControl);
	}

	private void createConsoleViewer(Composite parent) {
		Composite comp = new Composite(parent, SWT.BORDER | SWT.RESIZE);

		fSEWDashbordConsole = new IOConsole("SEW-Console", null);

		GridData dataRight = new GridData();

		dataRight.horizontalSpan = 2;
        dataRight.grabExcessHorizontalSpace = true;
        dataRight.grabExcessVerticalSpace = true;
        dataRight.horizontalAlignment = SWT.FILL;
        dataRight.verticalAlignment = SWT.FILL;

		fConsoleViewer = new SEWConsoleViewer(comp, fSEWDashbordConsole);

		comp.setLayout(new FillLayout());
		comp.setLayoutData(dataRight);
	}

	private SWTSpider createSpider(Composite parent, int x, int y, int r) {
//        Group group = SWTFactory.createGroup(parent, "", 1, 1, GridData.FILL_BOTH);
//        group.setText("MODEL ANALYSIS");

        compSpider = new ScrolledComposite (parent,
        		SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.RESIZE);

        fSpider = new SWTSpider(compSpider, SWT.NULL, x, y, r);
        compSpider.setContent(fSpider);
        compSpider.setExpandHorizontal(true);
        compSpider.setExpandVertical(true);
        compSpider.setMinSize(480, 420);

        GridData dataLeft = new GridData();
		dataLeft.heightHint = 200;

//        dataR.horizontalSpan = 1;

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

	public void sewLaunchExecProcess(ILaunchConfiguration configuration,
			String mode, ILaunch launch, IProgressMonitor monitor,
			String[] cmdLine, File workingDir, String[] envp) {

        consoleView = SymbexPreferenceUtil.getBooleanPreference(PREF_CONSOLE_VIEW);
//        spiderView = prefs.getBoolean(P_SPIDER_VIEW);

        try {
			OutputStream outputStream2 = null;
			OutputStreamWriter outputStreamWriter2 = null;
			BufferedWriter bufferedWriter2 = null;
	        if ( consoleView ) {
//				InputStream inputStream2 = fSEWDashbordConsole.getInputStream();
//				InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream2);
//				BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);

				outputStream2 = fSEWDashbordConsole.newOutputStream();
				outputStreamWriter2 = new OutputStreamWriter(outputStream2);
				bufferedWriter2 = new BufferedWriter(outputStreamWriter2);
	        }

			fSEWDashbordConsole.clearConsole();

	        if ( fSpider != null ) {
				fSpider.resetSpider();
			}

			avmProcessBuilder = new ProcessBuilder(cmdLine);
			avmProcessBuilder = avmProcessBuilder.redirectErrorStream(true);
			avmProcessBuilder.directory(workingDir);

			try {
				avmProcess = avmProcessBuilder.start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if( avmProcess == null ) {
				return;
			}

			InputStream inputStream1 = avmProcess.getInputStream();
			InputStreamReader inputStreamReader1 = new InputStreamReader(inputStream1);
			BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);

			firstLine = true;
			lastLine = false;

			String traceLine = null;

			nbExecution = 0;

			while( true ) {
				// Tempo
//				try {
//					Thread.sleep(20);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

				if( bufferedReader1.ready() ) {
					if( (traceLine = bufferedReader1.readLine()) != null ) {

//				        if ( spiderView ) {
				        	majSpider(traceLine);
//				        }

				        if ( consoleView ) {
							bufferedWriter2.append(traceLine).append("\n");
							bufferedWriter2.flush();
				        }
					}
				}
				else {
					try {
						avmProcess.exitValue();
						break;
					}
					catch( IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ){
					avmProcess.destroy();
			        if ( consoleView ) {
						bufferedWriter2.append("\n***********************\n" +
							   	  				"* EXECUTION ABORTED ! *\n" +
							   	  				"***********************");
						bufferedWriter2.flush();
			        }
					return;
				}
			}
			return;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			if( avmProcess != null ) {
				avmProcess.destroy();
			}
			monitor.done();
		}
		return;
	}

	private void majSpider(String traceLine) {
		String tmpString = null;

		if ( traceLine.startsWith("step:") ||
				traceLine.startsWith("stop:") ) {
			tmpString = traceLine.replaceAll(" ", "");
			if ( firstLine ) {
				firstLine = false;
				nbExecution = nbExecution + 1;

				if ( nbExecution == 1 ) {
					initVar();
					initMaxAndResize( tmpString, nbExecution );
				}
			}
			else if ( ! lastLine ){
				majDisplayedData( tmpString , nbExecution);

				majStepAndMax();

				fSpider.updateSpider(nbExecution,
									 nbStep, maxStep,
									 nbContext, maxContext,
									 nbHeight, maxHeight,
									 nbWidth, maxWidth,
									 nbCoverage, maxCoverage);

				if ( traceLine.startsWith("stop:") ) {
//					lastLine = true;
					if ( nbExecution == 1 ) {
						firstLine = true;
					}
					else {
						lastLine = true;
					}
				}
			}
		}
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


    private static final String CONSOLE_INIFINITE_SYMBOL = "+oo";
    private static final String CONSOLE_CONTEXT_SYMBOL   = "context:";
    private static final String CONSOLE_COVERAGE_SYMBOL  = "coverage:";

    private static final String CONSOLE_STEP_SYMBOL      = "step:";
    private static final String CONSOLE_HEIGHT_SYMBOL    = "height:";
    private static final String CONSOLE_WIDTH_SYMBOL     = "width:";


    private void initMaxAndResize(String aString, int nbExe) {
		String s = aString.substring(CONSOLE_STEP_SYMBOL.length(),
				aString.indexOf(CONSOLE_CONTEXT_SYMBOL) - 1);

		maxStep = s.equals(CONSOLE_INIFINITE_SYMBOL) ?
				DEFAULT_PERIOD_VALUE : Integer.parseInt(s);

		resizeStep = s.equals(CONSOLE_INIFINITE_SYMBOL);

		s = aString.substring(
				aString.indexOf(CONSOLE_CONTEXT_SYMBOL) +
						CONSOLE_CONTEXT_SYMBOL.length(),
				aString.indexOf(CONSOLE_HEIGHT_SYMBOL) - 1);

		maxContext = s.equals(CONSOLE_INIFINITE_SYMBOL) ?
				DEFAULT_PERIOD_VALUE : Integer.parseInt(s);

		resizeContext = s.equals(CONSOLE_INIFINITE_SYMBOL);

		s = aString.substring(
				aString.indexOf(CONSOLE_HEIGHT_SYMBOL) +
						CONSOLE_HEIGHT_SYMBOL.length(),
				aString.indexOf(CONSOLE_WIDTH_SYMBOL)-1);

		maxHeight = s.equals(CONSOLE_INIFINITE_SYMBOL) ?
				DEFAULT_PERIOD_VALUE : Integer.parseInt(s);

		resizeHeight = s.equals(CONSOLE_INIFINITE_SYMBOL);

		if ( ( nbExe == 1 ) &&
			 ( LaunchDelegate.fModelAnalysisProfile.equals(
					 ANALYSIS_PROFILE_MODEL_EXPLORATION)
			|| LaunchDelegate.fModelAnalysisProfile.equals(
					 ANALYSIS_PROFILE_MODEL_UNDEFINED)) ) {

			s = aString.substring(
					aString.indexOf(CONSOLE_WIDTH_SYMBOL) +
							CONSOLE_WIDTH_SYMBOL.length(),
					aString.length());

			maxWidth = s.equals(CONSOLE_INIFINITE_SYMBOL) ?
					DEFAULT_PERIOD_VALUE : Integer.parseInt(s);

			resizeWidth = s.equals(CONSOLE_INIFINITE_SYMBOL);
		}
		else if ( ( nbExe == 1 ) || LaunchDelegate.fEnableTraceExtension ) {
			s = aString.substring(
					aString.indexOf(CONSOLE_WIDTH_SYMBOL) +
							CONSOLE_WIDTH_SYMBOL.length(),
					aString.indexOf(CONSOLE_COVERAGE_SYMBOL)-1);

			maxWidth = s.equals(CONSOLE_INIFINITE_SYMBOL) ?
					DEFAULT_PERIOD_VALUE : Integer.parseInt(s);

			resizeWidth = s.equals(CONSOLE_INIFINITE_SYMBOL);

			s = aString.substring(aString.indexOf("/")+1);
			maxCoverage = Integer.parseInt(s);
		}
	}

	private void majDisplayedData(String aString, int nbExe) {
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
		nbContext = Integer.parseInt(aString.substring(beginIndex, endIndex));

		beginIndex = currentIndex + CONSOLE_HEIGHT_SYMBOL.length();
		currentIndex = aString.indexOf(CONSOLE_WIDTH_SYMBOL);
		endIndex = currentIndex - 1;

//		nbHeight = Integer.parseInt(aString.substring(beginIndex, endIndex));
		currentNbHeight = Integer.parseInt(
				aString.substring(beginIndex, endIndex));

		nbHeight = ( currentNbHeight > oldNbHeight ) ?
				currentNbHeight : oldNbHeight;

		if ( ( nbExe == 1 ) &&
			 ( LaunchDelegate.fModelAnalysisProfile.equals(
					 ANALYSIS_PROFILE_MODEL_EXPLORATION)
			|| LaunchDelegate.fModelAnalysisProfile.equals(
					ANALYSIS_PROFILE_MODEL_UNDEFINED) ) ) {
			beginIndex = currentIndex + 6;
			endIndex = aString.length();

//			nbWidth = Integer.parseInt(aString.substring(beginIndex, endIndex));
			currentNbWidth = Integer.parseInt(
					aString.substring(beginIndex, endIndex));

			nbWidth = ( currentNbWidth > oldNbWidth ) ?
					currentNbWidth : oldNbWidth;
		}
		else if ( ( nbExe == 1 ) || LaunchDelegate.fEnableTraceExtension ) {
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
