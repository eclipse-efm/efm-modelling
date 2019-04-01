/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.execution.launchconfiguration.ui.views.page;

import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.launchconfiguration.LaunchDelegate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;

public class SWTSpider extends Canvas
		implements PaintListener , IWorkflowConfigurationConstants {

	private boolean fRedrawBySystem;

	private boolean fResetFlag = false;

	public static enum SPIDER_GEOMETRY {
		/*TRIGON ,*/  TETRAGON , PENTAGON /*, HEXAGON*/
	}

	private SPIDER_GEOMETRY fSpidertype = SPIDER_GEOMETRY.TETRAGON;

	private String spiderTitle;
	private int xDecalage;
	private int yDecalage;
	private int rayon;

//	private int xDecalage = 150;
//	private int yDecalage = 150;
//	private int rayon = 60;

	private int xCentre;
	private int yCentre;

	private int executionNumber = 0;

	private int maxCoverage = 1;
	private int currentCoverage = 0;
	private int maxStep = 1;
	private int currentStep = 0;
	private int maxWidth = 1;
	private int currentWidth = 0;
	private int maxDepth = 1;
	private int currentDepth = 0;
	private int maxContext = 1;
	private int currentContext = 0;

	private int currentStep2 = 0;
	private int currentWidth2 = 0;
	private int currentDepth2 = 0;
	private int currentContext2 = 0;

	public SWTSpider(final ScrolledComposite parent, final int style,
			final int x, final int y, final int r, final String title)
	{
		super(parent, style);

		xDecalage = x;
		yDecalage = y;
		rayon = r;

		fRedrawBySystem = true;
		spiderTitle = title;

		createContent(parent);
	}

	private void createContent(final ScrolledComposite parent) {
//		parent.setLayout(new BorderLayout() );

		this.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TRANSPARENT));
		addPaintListener(this);

	}

	@Override
	public void paintControl(final PaintEvent e) {

		if( fRedrawBySystem || fResetFlag ) {
// 			System.out.println("fRedrawBySystem:>" + fRedrawBySystem);
			xCentre = xDecalage + rayon;
			yCentre = yDecalage + rayon;

//			Device device = Display.getCurrent();

			switch( fSpidertype ) {
			case TETRAGON:
				initSpider4Segments(e);
				break;
			case PENTAGON:
				initSpider5Segments(e);
				break;
			default:
				// error !
			}
		}

		switch( fSpidertype ) {
		case TETRAGON:
			draw4CurrentSegments(e, currentStep, maxStep,
	 								currentDepth, maxDepth,
	 								currentContext, maxContext,
	 								currentWidth, maxWidth);
			break;
		case PENTAGON:
			draw5CurrentSegments(e, currentCoverage, maxCoverage,
					 				currentStep, maxStep,
					 				currentWidth, maxWidth,
					 				currentDepth, maxDepth,
					 				currentContext, maxContext);
			break;
		default:
			draw4CurrentSegments(e, currentStep, maxStep,
									currentDepth, maxDepth,
									currentContext, maxContext,
									currentWidth, maxWidth);
		}

		if (LaunchDelegate.fEnableTraceExtension && executionNumber > 1 ){
			drawExe2(e);
		}
	}

	public void resetSpider(final SPIDER_GEOMETRY geometry) {
		fResetFlag = true;

		fSpidertype = geometry;

		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				redraw();
			}
		});
	}

	private void initSpider4Segments(final PaintEvent e) {
		e.gc.fillRectangle(0, 0, SPIDER_RECTANGLE_WIDTH, SPIDER_RECTANGLE_HEIGHT);

		e.gc.drawString(spiderTitle, xDecalage + 60, yDecalage - 80);

		// Point central
		final int rayonCentre = 2;
		e.gc.fillOval(xCentre-rayonCentre, yCentre-rayonCentre, 2*rayonCentre, 2*rayonCentre);

		// 4 Rayons
		e.gc.drawLine(xCentre, yCentre, xCentre, yCentre-rayon);
		e.gc.drawString("step", xCentre-15, yCentre-rayon-50);
		e.gc.drawString(Integer.toString(currentStep)+"/"+Integer.toString(maxStep),
						xCentre-20, yCentre-rayon-30);

		e.gc.drawLine(xCentre, yCentre, xCentre+rayon, yCentre);
		e.gc.drawString("depth", xCentre+rayon+20, yCentre-20);
		e.gc.drawString(Integer.toString(currentDepth)+"/"+Integer.toString(maxDepth),
				xCentre+rayon+20, yCentre);

		e.gc.drawLine(xCentre, yCentre, xCentre, yCentre+rayon);
		e.gc.drawString("context", xCentre-20, yCentre+rayon+10);
		e.gc.drawString(Integer.toString(currentContext)+"/"+Integer.toString(maxContext),
				xCentre-20, yCentre+rayon+30);

		e.gc.drawLine(xCentre, yCentre, xCentre-rayon, yCentre);
		e.gc.drawString("width", xCentre-rayon-50, yCentre-20);
		e.gc.drawString(Integer.toString(currentWidth)+"/"+Integer.toString(maxWidth),
				xCentre-rayon-50, yCentre);

		// Segments
		draw4RegularSegments(e, rayon / 4);
		draw4RegularSegments(e, rayon / 2);
		draw4RegularSegments(e, (rayon / 4) * 3);
		draw4RegularSegments(e, rayon);
	}

	public void draw4RegularSegments(final PaintEvent pe, final int lg) {
		pe.gc.drawLine(xCentre, yCentre - lg, xCentre+lg, yCentre);
		pe.gc.drawLine(xCentre+lg, yCentre, xCentre, yCentre+lg);
		pe.gc.drawLine(xCentre, yCentre+lg, xCentre-lg, yCentre);
		pe.gc.drawLine(xCentre-lg, yCentre, xCentre, yCentre - lg);
	}

	public void draw4CurrentSegments(final PaintEvent pe,
			final int cStep, final int mStep,
			final int cDepth, final int mDepth,
			final int cContext, final int mContext,
			final int cWidth, final int mWidth) {

		if ( mStep == 0 ||
			 mDepth == 0 ||
			 mContext == 0 ||
			 mWidth == 0 )
			{
				// Pb de rafraichissement des variables en multi-threading
				// qui peut provoquer une division par zéro
				//
				return;
			}

		int lgPoint = rayon * cStep / mStep;
		final int xP1 = xCentre;
		final int yP1 = yCentre - lgPoint;

		lgPoint = rayon * cDepth / mDepth;
		final int xP2 = xCentre+lgPoint;
		final int yP2 = yCentre;

		lgPoint = rayon * cContext / mContext;
		final int xP3 = xCentre;
		final int yP3 = yCentre+lgPoint;

		lgPoint = rayon * cWidth / mWidth;
		final int xP4 = xCentre-lgPoint;
		final int yP4 = yCentre;

		final Device device = Display.getCurrent();
		pe.gc.setForeground(device.getSystemColor(SWT.COLOR_GREEN));

		pe.gc.setLineWidth(3);
		pe.gc.drawLine(xP1, yP1, xP2, yP2);
		pe.gc.drawLine(xP2, yP2, xP3, yP3);
		pe.gc.drawLine(xP3, yP3, xP4, yP4);
		pe.gc.drawLine(xP4, yP4, xP1, yP1);
	}


	private static final int SPIDER_RECTANGLE_WIDTH = 600;

	private static final int SPIDER_RECTANGLE_HEIGHT = 300;


	private void initSpider5Segments(final PaintEvent e) {
		e.gc.fillRectangle(0, 0, SPIDER_RECTANGLE_WIDTH, SPIDER_RECTANGLE_HEIGHT);

		e.gc.drawString(spiderTitle, xDecalage + 60, yDecalage - 80);

		// Point central
		final int rayonCentre = 2;
		e.gc.fillOval(xCentre-rayonCentre, yCentre-rayonCentre, 2*rayonCentre, 2*rayonCentre);

		// 5 Rayons
//		e.gc.setBackground(device.getSystemColor(SWT.COLOR_TRANSPARENT));
		e.gc.drawLine(xCentre, yCentre, xCentre, yCentre-rayon);
		e.gc.drawString("coverage", xCentre-30, yCentre-rayon-50);
		e.gc.drawString(Integer.toString(currentCoverage)+"/"+Integer.toString(maxCoverage),
						xCentre-20, yCentre-rayon-30);

		final int xVariation1 = (int) (rayon * 0.951); // sinus(72)
		final int yVariation1 = (int) (rayon * 0.309); // cosinus(72)
		e.gc.drawLine(xCentre, yCentre, xCentre-xVariation1, yCentre-yVariation1);
		e.gc.drawString("context", xCentre-xVariation1-80, yCentre-yVariation1-20);
		e.gc.drawString(Integer.toString(currentContext)+"/"+Integer.toString(maxContext),
				xCentre-xVariation1-80, yCentre-yVariation1);

		e.gc.drawLine(xCentre, yCentre, xCentre+xVariation1, yCentre-yVariation1);
		e.gc.drawString("step", xCentre+xVariation1+10, yCentre-yVariation1-20);
		e.gc.drawString(Integer.toString(currentStep)+"/"+Integer.toString(maxStep),
				xCentre+xVariation1+10, yCentre-yVariation1);

		final int xVariation2 = (int) (rayon * 0.588); // sinus(72/2)
		final int yVariation2 = (int) (rayon * 0.809); // cosinus(72/2)
		e.gc.drawLine(xCentre, yCentre, xCentre-xVariation2, yCentre+yVariation2);
		e.gc.drawString("depth", xCentre-xVariation2-20, yCentre+yVariation2+10);
		e.gc.drawString(Integer.toString(currentDepth)+"/"+Integer.toString(maxDepth),
				xCentre-xVariation2-20, yCentre+yVariation2+30);

		e.gc.drawLine(xCentre, yCentre, xCentre+xVariation2, yCentre+yVariation2);
		e.gc.drawString("width", xCentre+xVariation2-20, yCentre+yVariation2+10);
		e.gc.drawString(Integer.toString(currentWidth)+"/"+Integer.toString(maxWidth),
				xCentre+xVariation2-20, yCentre+yVariation2+30);

		// Segments
		draw5RegularSegments(e, rayon / 4);
		draw5RegularSegments(e, rayon / 2);
		draw5RegularSegments(e, (rayon / 4) * 3);
		draw5RegularSegments(e, rayon);
	}

	public void draw5RegularSegments(final PaintEvent pe, final int lg) {
		final int xVariation1 = (int) (lg * 0.951); // sinus(72)
		final int yVariation1 = (int) (lg  * 0.309); // cosinus(72)
		pe.gc.drawLine(xCentre, yCentre - lg, xCentre-xVariation1, yCentre-yVariation1);
		pe.gc.drawLine(xCentre, yCentre - lg, xCentre+xVariation1, yCentre-yVariation1);
		final int xVariation2 = (int) (lg * 0.588); // sinus(72/2)
		final int yVariation2 = (int) (lg * 0.809); // cosinus(72/2)
		pe.gc.drawLine(xCentre-xVariation1, yCentre-yVariation1, xCentre-xVariation2, yCentre+yVariation2);
		pe.gc.drawLine(xCentre+xVariation1, yCentre-yVariation1, xCentre+xVariation2, yCentre+yVariation2);
		pe.gc.drawLine(xCentre-xVariation2, yCentre+yVariation2, xCentre+xVariation2, yCentre+yVariation2);
	}

	public void draw5CurrentSegments(final PaintEvent pe,
								final int cCoverage, final int mCoverage,
								final int cStep, final int mStep,
								final int cWidth, final int mWidth,
								final int cDepth, final int mDepth,
								final int cContext, final int mContext) {

		if ( mCoverage == 0 ||
			 mContext == 0 ||
			 mDepth == 0 ||
			 mWidth == 0 ||
			 mStep == 0 )
		{
			// Pb de rafraichissement des variables en multi-threading
			// qui peut provoquer une division par zéro
			//
			return;
		}

		int lgPoint = rayon * cCoverage / mCoverage;
		final int xP1 = xCentre;
		final int yP1 = yCentre - lgPoint;

		lgPoint = rayon * cContext / mContext;
		int xVariation = (int) (lgPoint * 0.951); // sinus(72)
		int yVariation = (int) (lgPoint  * 0.309); // cosinus(72)
		final int xP2 = xCentre-xVariation;
		final int yP2 = yCentre-yVariation;

		lgPoint = rayon * cDepth / mDepth;
		xVariation = (int) (lgPoint * 0.588); // sinus(72/2)
		yVariation = (int) (lgPoint * 0.809); // cosinus(72/2)
		final int xP3 = xCentre-xVariation;
		final int yP3 = yCentre+yVariation;

		lgPoint = rayon * cWidth / mWidth;
		xVariation = (int) (lgPoint * 0.588); // sinus(72/2)
		yVariation = (int) (lgPoint * 0.809); // cosinus(72/2)
		final int xP4 = xCentre+xVariation;
		final int yP4 = yCentre+yVariation;

		lgPoint = rayon * cStep / mStep;
		xVariation = (int) (lgPoint * 0.951); // sinus(72)
		yVariation = (int) (lgPoint  * 0.309); // cosinus(72)
		final int xP5 = xCentre+xVariation;
		final int yP5 = yCentre-yVariation;

		final Device device = Display.getCurrent();

		if ( cCoverage < mCoverage)	{
			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_RED));
		}
		else {
			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_DARK_GREEN));
			pe.gc.drawString(spiderTitle, xDecalage + 60, yDecalage - 80);
			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_GREEN));
		}

		pe.gc.setLineWidth(3);
		pe.gc.drawLine(xP1, yP1, xP2, yP2);
		pe.gc.drawLine(xP2, yP2, xP3, yP3);
		pe.gc.drawLine(xP3, yP3, xP4, yP4);
		pe.gc.drawLine(xP4, yP4, xP5, yP5);
		pe.gc.drawLine(xP5, yP5, xP1, yP1);
	}

	private void drawExe2(final PaintEvent pe) {
		final Device device = Display.getCurrent();
		if ( currentCoverage < maxCoverage)	{
			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_RED));
			pe.gc.drawString(spiderTitle, xDecalage + 60, yDecalage - 80);
//			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_DARK_GREEN));
		}
		else {
			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_DARK_GREEN));
			pe.gc.drawString(spiderTitle, xDecalage + 60, yDecalage - 80);
		}

		pe.gc.drawString("Trace extension:", xDecalage + 250, yDecalage - 80);
		pe.gc.drawString("- step = " + currentStep2, xDecalage + 250, yDecalage - 60);
		pe.gc.drawString("- context = " + currentContext2, xDecalage + 250, yDecalage - 40);
		pe.gc.drawString("- depth = " + currentDepth2, xDecalage + 250, yDecalage - 20);
		pe.gc.drawString("- width = " + currentWidth2, xDecalage + 250, yDecalage);
	}


	public void updateSpider(final int exeNumber, final int cStep, final int mStep,
			final int cContext, final int mContext, final int cDepth, final int mDepth,
			final int cWidth, final int mWidth, final int cCoverage, final int mCoverage) {

		executionNumber = exeNumber;

		if ( exeNumber == 1 ) {
			currentStep = cStep;
			maxStep = mStep;
			currentContext = cContext;
			maxContext = mContext;
			currentDepth = cDepth;
			maxDepth = mDepth;
			currentWidth = cWidth;
			maxWidth = mWidth;
			currentCoverage = cCoverage;
			maxCoverage = mCoverage;
		}
		else if ( LaunchDelegate.fEnableTraceExtension && exeNumber > 1 ) {
			currentStep2 = cStep;
			currentContext2 = cContext;
			currentDepth2 = cDepth;
			currentWidth2 = cWidth;
		}

		fRedrawBySystem = false;

		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				redraw();
			}
		});

		fRedrawBySystem = true;
	}


}
