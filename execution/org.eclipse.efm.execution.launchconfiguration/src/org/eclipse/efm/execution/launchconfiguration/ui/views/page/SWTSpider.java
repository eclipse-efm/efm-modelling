/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl - v10.html
 *
 * Contributors:
 *     Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.execution.launchconfiguration.ui.views.page;

import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;
import org.eclipse.efm.execution.launchconfiguration.LaunchDelegate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;


public class SWTSpider extends Canvas  implements PaintListener ,
		IWorkflowConfigurationConstants , IWorkflowSpiderConfigurationUtils {

	private boolean fRedrawBySystem;

	private boolean fResetFlag = false;

	public enum SPIDER_GEOMETRY {
		/*TRIGON ,*/  TETRAGON , PENTAGON /*, HEXAGON*/
	}

	private SPIDER_GEOMETRY fSpidertype = SPIDER_GEOMETRY.TETRAGON;

	private String spiderTitle;

	private String symbexVerdict;
	boolean enabledVerdictPrinting;

	private int rayon;

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

	public SWTSpider(final ScrolledComposite parent,
			final int style, final String title)
	{
		super(parent, style);

		fRedrawBySystem = true;
		spiderTitle = title;

		symbexVerdict = "";
		enabledVerdictPrinting = false;


		createContent(parent);
	}

	private void createContent(final ScrolledComposite parent) {
//		parent.setLayout(new BorderLayout() );

		this.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TRANSPARENT));
		addPaintListener(this);
	}

	protected void syncRedraw() {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				if( ! isDisposed() ) {
					redraw();
				}
			}
		});
	}

	@Override
	public void paintControl(final PaintEvent e) {

		if( fRedrawBySystem || fResetFlag ) {
			fillRectangle(e);

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

		if( enabledVerdictPrinting ) {
			drawVerdict(e);
		}
	}


	public void resetSpider(final String title, final SPIDER_GEOMETRY geometry) {
		fResetFlag = true;

		spiderTitle = title;
		fSpidertype = geometry;

		enabledVerdictPrinting = false;

		syncRedraw();
	}


	private static final int SPIDER_RECTANGLE_MIN_WIDTH  = 200;

	private static final int SPIDER_RECTANGLE_MIN_HEIGHT = 150;

	private static final int SPIDER_MIN_RAYON = 50;


	protected void fillRectangle(final PaintEvent pe) {
		final Point paintArea = this.getSize();

		final int width  = Math.max(SPIDER_RECTANGLE_MIN_WIDTH , paintArea.x);
		final int height = Math.max(SPIDER_RECTANGLE_MIN_HEIGHT, paintArea.y);

		pe.gc.fillRectangle(0, 0, width, height);

		rayon = Math.max(Math.min(width, height) / 2 - 100 , SPIDER_MIN_RAYON);

		xCentre = paintArea.x / 2;
		yCentre = paintArea.y / 2;

//		final int xOffset = 10;
//		pe.gc.drawString("cadre: " + paintArea.x + " - " + paintArea.y, xOffset, 30);
//		pe.gc.drawString("centr: " + xCentre     + " - " + yCentre    , xOffset, 50);
//		pe.gc.drawString("rayon: " + rayon                            , xOffset, 70);
	}


	Font TITLE_FONT = null;
	Font  SAVE_FONT = null;

	private void drawTitle(final PaintEvent pe) {
		if( (TITLE_FONT == null)   || TITLE_FONT.isDisposed()
			|| (SAVE_FONT == null) || SAVE_FONT.isDisposed() )
		{
			final Device device = Display.getCurrent();

			SAVE_FONT = pe.gc.getFont();
			final FontData[] saveFontData = SAVE_FONT.getFontData();

			final FontData[] fontData16 = new FontData[saveFontData.length];
			for(int i = 0; i < saveFontData.length; ++ i)
				fontData16[i] = new FontData(
						saveFontData[i].getName(), 18, saveFontData[i].getStyle());
			TITLE_FONT = new Font(device, fontData16);
		}

		pe.gc.setFont(TITLE_FONT);

		final Point textSize = pe.gc.textExtent(spiderTitle);

        pe.gc.drawText(spiderTitle, (this.getSize().x - textSize.x)/2, 10);

        // Restore original font size
		pe.gc.setFont(SAVE_FONT);
	}

//	private void drawTitle(final PaintEvent pe, final int color) {
//		final Device device = Display.getCurrent();
//
//		pe.gc.setForeground(device.getSystemColor(color));
//
//		final Point textSize = pe.gc.textExtent(spiderTitle);
//
//		pe.gc.drawText(spiderTitle, (this.getSize().x - textSize.x)/2, 10);
//
////		pe.gc.drawString(spiderTitle, 160, 10);
//	}

	private void initSpider4Segments(final PaintEvent e) {
		// Print Title
		drawTitle(e);

		// Point central
		final int rayonCentre = 2;
		e.gc.fillOval(xCentre - rayonCentre, yCentre - rayonCentre, 2*rayonCentre, 2*rayonCentre);

		// 4 Rayons
		e.gc.drawLine(xCentre, yCentre, xCentre, yCentre - rayon);
		e.gc.drawString("step", (this.getSize().x - e.gc.textExtent("step").x)/2,
				yCentre - rayon - 50);
		final String step = currentStep + " / " + maxStep;
        final Point stepSize = e.gc.textExtent(step);
		e.gc.drawString(step, (this.getSize().x - stepSize.x)/2, yCentre - rayon - 30);

		e.gc.drawLine(xCentre, yCentre, xCentre + rayon, yCentre);
		e.gc.drawString("depth", xCentre + rayon + 10, yCentre - 20);
		e.gc.drawString(currentDepth + " / " + maxDepth,
				xCentre + rayon + 10, yCentre);


		e.gc.drawLine(xCentre, yCentre, xCentre, yCentre + rayon);
		e.gc.drawString("context", (this.getSize().x - e.gc.textExtent("context").x)/2,
				yCentre + rayon + 10);
		final String context = currentContext + " / " + maxContext;
        final Point contextSize = e.gc.textExtent(context);
		e.gc.drawString(context, (this.getSize().x - contextSize.x)/2, yCentre + rayon + 30);

		e.gc.drawLine(xCentre, yCentre, xCentre - rayon, yCentre);
		e.gc.drawString("width", xCentre - rayon - e.gc.textExtent("width").x - 10, yCentre - 20);
		final String width = currentWidth + " / " + maxWidth;
        final Point widthSize = e.gc.textExtent(width);
		e.gc.drawString(width, xCentre - rayon - widthSize.x - 10, yCentre);

		// Segments
		draw4RegularSegments(e, rayon / 4);
		draw4RegularSegments(e, rayon / 2);
		draw4RegularSegments(e, (rayon / 4) * 3);
		draw4RegularSegments(e, rayon);
	}

	public void draw4RegularSegments(final PaintEvent pe, final int lg) {
		pe.gc.drawLine(xCentre, yCentre - lg, xCentre + lg, yCentre);
		pe.gc.drawLine(xCentre + lg, yCentre, xCentre, yCentre + lg);
		pe.gc.drawLine(xCentre, yCentre + lg, xCentre - lg, yCentre);
		pe.gc.drawLine(xCentre - lg, yCentre, xCentre, yCentre - lg);
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
				// Pb de rafraichissement des variables en multi - threading
				// qui peut provoquer une division par zéro
				//
				return;
			}

		int lgPoint = rayon * cStep / mStep;
		final int xP1 = xCentre;
		final int yP1 = yCentre - lgPoint;

		lgPoint = rayon * cDepth / mDepth;
		final int xP2 = xCentre + lgPoint;
		final int yP2 = yCentre;

		lgPoint = rayon * cContext / mContext;
		final int xP3 = xCentre;
		final int yP3 = yCentre + lgPoint;

		lgPoint = rayon * cWidth / mWidth;
		final int xP4 = xCentre - lgPoint;
		final int yP4 = yCentre;

		final Device device = Display.getCurrent();
		pe.gc.setForeground(device.getSystemColor(SWT.COLOR_GREEN));

		pe.gc.setLineWidth(3);
		pe.gc.drawLine(xP1, yP1, xP2, yP2);
		pe.gc.drawLine(xP2, yP2, xP3, yP3);
		pe.gc.drawLine(xP3, yP3, xP4, yP4);
		pe.gc.drawLine(xP4, yP4, xP1, yP1);
	}


	private void initSpider5Segments(final PaintEvent e) {
		// Print Title
		drawTitle(e);

		// Point central
		final int rayonCentre = 2;
		e.gc.fillOval(xCentre - rayonCentre,
				yCentre - rayonCentre, 2*rayonCentre, 2*rayonCentre);

		// 5 Rayons
//		e.gc.setBackground(device.getSystemColor(SWT.COLOR_TRANSPARENT));
		e.gc.drawLine(xCentre, yCentre, xCentre, yCentre - rayon);
		e.gc.drawString("coverage", (this.getSize().x - e.gc.textExtent("coverage").x)/2,
				yCentre - rayon - 50);
		final String coverage = currentCoverage + " / " + maxCoverage;
        final Point coverageSize = e.gc.textExtent(coverage);
		e.gc.drawString(coverage, (this.getSize().x - coverageSize.x)/2,
				yCentre - rayon - 30);

		final int xVariation1 = (int) (rayon * 0.951); // sinus(72)
		final int yVariation1 = (int) (rayon * 0.309); // cosinus(72)

		e.gc.drawLine(xCentre, yCentre, xCentre - xVariation1, yCentre - yVariation1);
		e.gc.drawString("context", xCentre - xVariation1 - 50, yCentre - yVariation1 - 20);
		final String context = currentContext + " / " + maxContext;
        final Point contextSize = e.gc.textExtent(context);
		e.gc.drawString(context, xCentre - xVariation1 - contextSize.x - 10, yCentre - yVariation1);

		e.gc.drawLine(xCentre, yCentre, xCentre + xVariation1, yCentre - yVariation1);
		e.gc.drawString("step", xCentre + xVariation1 + 10, yCentre - yVariation1 - 20);
		e.gc.drawString(currentStep + " / " + maxStep,
				xCentre + xVariation1 + 10, yCentre - yVariation1);

		final int xVariation2 = (int) (rayon * 0.588); // sinus(72/2)
		final int yVariation2 = (int) (rayon * 0.809); // cosinus(72/2)
		e.gc.drawLine(xCentre, yCentre, xCentre - xVariation2, yCentre + yVariation2);
		e.gc.drawString("depth", xCentre - xVariation2 - 20, yCentre + yVariation2 + 10);
		e.gc.drawString(currentDepth + " / " + maxDepth,
				xCentre - xVariation2 - 20, yCentre + yVariation2 + 30);

		e.gc.drawLine(xCentre, yCentre, xCentre + xVariation2, yCentre + yVariation2);
		e.gc.drawString("width", xCentre + xVariation2 - 20, yCentre + yVariation2 + 10);
		e.gc.drawString(currentWidth + " / " + maxWidth,
				xCentre + xVariation2 - 20, yCentre + yVariation2 + 30);

		// Segments
		draw5RegularSegments(e, rayon / 4);
		draw5RegularSegments(e, rayon / 2);
		draw5RegularSegments(e, (rayon / 4) * 3);
		draw5RegularSegments(e, rayon);
	}

	public void draw5RegularSegments(final PaintEvent pe, final int lg) {
		final int xVariation1 = (int) (lg * 0.951); // sinus(72)
		final int yVariation1 = (int) (lg  * 0.309); // cosinus(72)
		pe.gc.drawLine(xCentre, yCentre - lg, xCentre - xVariation1, yCentre - yVariation1);
		pe.gc.drawLine(xCentre, yCentre - lg, xCentre + xVariation1, yCentre - yVariation1);

		final int xVariation2 = (int) (lg * 0.588); // sinus(72/2)
		final int yVariation2 = (int) (lg * 0.809); // cosinus(72/2)
		pe.gc.drawLine( xCentre - xVariation1, yCentre - yVariation1,
						xCentre - xVariation2, yCentre + yVariation2 );
		pe.gc.drawLine( xCentre + xVariation1, yCentre - yVariation1,
						xCentre + xVariation2, yCentre + yVariation2 );
		pe.gc.drawLine( xCentre - xVariation2, yCentre + yVariation2,
						xCentre + xVariation2, yCentre + yVariation2 );
	}

	public void draw5CurrentSegments(final PaintEvent pe,
			final int cCoverage, final int mCoverage,
			final int cStep, final int mStep,
			final int cWidth, final int mWidth,
			final int cDepth, final int mDepth,
			final int cContext, final int mContext) {

		if ( mCoverage == 0 || mContext == 0 ||
			 mDepth    == 0 || mWidth   == 0 || mStep == 0 )
		{
			// Pb de rafraichissement des variables en multi - threading
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
		final int xP2 = xCentre - xVariation;
		final int yP2 = yCentre - yVariation;

		lgPoint = rayon * cDepth / mDepth;
		xVariation = (int) (lgPoint * 0.588); // sinus(72/2)
		yVariation = (int) (lgPoint * 0.809); // cosinus(72/2)
		final int xP3 = xCentre - xVariation;
		final int yP3 = yCentre + yVariation;

		lgPoint = rayon * cWidth / mWidth;
		xVariation = (int) (lgPoint * 0.588); // sinus(72/2)
		yVariation = (int) (lgPoint * 0.809); // cosinus(72/2)
		final int xP4 = xCentre + xVariation;
		final int yP4 = yCentre + yVariation;

		lgPoint = rayon * cStep / mStep;
		xVariation = (int) (lgPoint * 0.951); // sinus(72)
		yVariation = (int) (lgPoint  * 0.309); // cosinus(72)
		final int xP5 = xCentre + xVariation;
		final int yP5 = yCentre - yVariation;

		final Device device = Display.getCurrent();

		if ( cCoverage < mCoverage)	{
			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_RED));
		}
		else {
			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_DARK_GREEN));
			drawTitle(pe);
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
			drawTitle(pe);
//			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_DARK_GREEN));
		}
		else {
			pe.gc.setForeground(device.getSystemColor(SWT.COLOR_DARK_GREEN));
			drawTitle(pe);
		}

		pe.gc.drawString("Trace extension:", 350, 10);
		pe.gc.drawString("- step = "    + currentStep2   , 350, 30);
		pe.gc.drawString("- context = " + currentContext2, 350, 50);
		pe.gc.drawString("- depth = "   + currentDepth2  , 350, 70);
		pe.gc.drawString("- width = "   + currentWidth2  , 350, 90);
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

		syncRedraw();

		fRedrawBySystem = true;
	}


	public void showSymbexVerdict(final String strVerdict) {
		symbexVerdict = strVerdict;

		enabledVerdictPrinting = true;

		fRedrawBySystem = false;

		syncRedraw();

		fRedrawBySystem = true;
	}


	Font VERDICT_FONT = null;

	private void drawVerdict(final PaintEvent pe) {
		final Device device = Display.getCurrent();

		if( (VERDICT_FONT == null) || VERDICT_FONT.isDisposed() ) {
			final FontData[] fontData = pe.gc.getFont().getFontData();
			for(int i = 0; i < fontData.length; ++ i)
				fontData[i].setHeight(64);

			VERDICT_FONT = new Font(device, fontData);
		}

		pe.gc.setFont(VERDICT_FONT);

		pe.gc.setForeground(device.getSystemColor(
				symbexVerdict.contains(SYMBEX_VERDICT_FAIL) ?
						SWT.COLOR_RED : SWT.COLOR_BLUE));

		final Point textSize = pe.gc.textExtent(symbexVerdict);

		pe.gc.drawText(symbexVerdict,
				(this.getSize().x - textSize.x)/2,
				(this.getSize().y - textSize.y)/2, true);
	}


}
