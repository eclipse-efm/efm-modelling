/*****************************************************************************
 * Copyright (c) 2016 CEA LIST
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Patrick Tessier CEA LIST-implementation
 *
 *****************************************************************************/
package plugin2analyse;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This class is to display a info like camembert, bar or histogramme
 * <BR>
 * <img src="camembert.png">
 * <BR>
 * <h3>How to use:</h3>
 * <BR>
 * <code>
 *  int[] pourcent = { 30, 20, 10, 40 };<BR>
 *   String[] labels = { "Added", "Modified", "Deleted", "Stable" };<BR>
 *   Device device = Display.getCurrent();<BR>
 *   org.eclipse.swt.graphics.Color[] colors = { device.getSystemColor(SWT.COLOR_GREEN), device.getSystemColor(SWT.COLOR_CYAN),<BR>
 *   device.getSystemColor(SWT.COLOR_RED), device.getSystemColor(SWT.COLOR_YELLOW) };<BR>
 *   SWTQualitativeInfo canva = new SWTQualitativeInfo(shell, SWT.NULL, pourcent, labels, colors, HISTOGRAMME);<BR>
 * </code>
 **/
public class SWTQualitativeInfo extends Canvas {

	public static int DISK = 0;

	public static int HISTOGRAMME = 1;

	public static int BAR = 2;

	public static int SPIDER = 3;

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        the composite owner
	 * @param style
	 *        SWT style
	 * @param pourcent
	 *        list of pourcent
	 * @param labels
	 *        list of label that represent pourcent
	 * @param colors
	 *        list of color for each pourcent
	 * @param type
	 *        type of diagram DISK, HISTOGRAMME, BAR
	 */
	public SWTQualitativeInfo(Composite parent, int style, int[] pourcent,
							String[] labels, org.eclipse.swt.graphics.Color[] colors, int type) {
		super(parent, style);
		this.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_WHITE));
				e.gc.fillRectangle(0, 0, 600, 300);

				if(type == BAR) {
					e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
					e.gc.fillRectangle(29, 29, 102, 202);
					int x = 30;
					int y = 30;
					for(int i = 0; i < pourcent.length; i++) {
						e.gc.setBackground(colors[i]);
						e.gc.fillRectangle(x, y, 100, pourcent[i] * 2);
						e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_WHITE));
						e.gc.setForeground(e.gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
						e.gc.drawString(labels[i] + " " + pourcent[i] + "%", x + 110, y + 10);

						y = y + pourcent[i] * 2;
					}

				} else if(type == DISK) {
					e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
					//e.gc.fillOval(28, 28, 203, 203);
					int startAngle = 0;
					int arcAngle = 0;

					int x = 30; // abcisse texte
					int y = 240; // ordonnée texte

					for(int i = 0; i < pourcent.length; i++) {
						e.gc.setBackground(colors[i]);
						arcAngle = (int)(pourcent[i] * 3.6);
						e.gc.fillArc(30, 30, 200, 200, startAngle, arcAngle);
						e.gc.fillRectangle(x, y, 10, 10);
						e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_WHITE));
						e.gc.setForeground(e.gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
						e.gc.drawString(labels[i] + " " + pourcent[i] + "%", x + 20, y - 2);
						y = y + 20;
						startAngle = startAngle + arcAngle;
					}

				} else if(type == SPIDER) {
					Device device = Display.getCurrent();

					// Cercle de centre (xDecalage+rayon, yDecalage+rayon)
					//
					int xDecalage = 100;
					int yDecalage = 100;
					int rayon = 150;

					int xCentre = xDecalage + rayon;
					int yCentre = yDecalage + rayon;

					// Disque englobant
//					e.gc.setBackground(device.getSystemColor(SWT.COLOR_CYAN));
//					e.gc.fillOval(xDecalage, xDecalage, 2*rayon,  2*rayon);

					// Point central
					int rayonCentre = 2;
					e.gc.setBackground(device.getSystemColor(SWT.COLOR_BLACK));
					e.gc.fillOval(xCentre-rayonCentre, yCentre-rayonCentre, 2*rayonCentre, 2*rayonCentre);

					// Cercle extérieur
//					e.gc.drawArc(xDecalage, yDecalage, 2*rayon, 2*rayon, 0, 360);

					// 5 Rayons
					e.gc.setBackground(device.getSystemColor(SWT.COLOR_TRANSPARENT));
					e.gc.drawLine(xCentre, yCentre, xCentre, yCentre-rayon);
					e.gc.drawString("coverage", xCentre-30, yCentre-rayon-30);

					int xVariation1 = (int) (rayon * 0.951); // sinus(72)
					int yVariation1 = (int) (rayon * 0.309); // cosinus(72)
					e.gc.drawLine(xCentre, yCentre, xCentre-xVariation1, yCentre-yVariation1);
					e.gc.drawString("width", xCentre-xVariation1-40, yCentre-yVariation1-10);

					e.gc.drawLine(xCentre, yCentre, xCentre+xVariation1, yCentre-yVariation1);
					e.gc.drawString("context", xCentre+xVariation1+10, yCentre-yVariation1-10);

					int xVariation2 = (int) (rayon * 0.588); // sinus(72/2)
					int yVariation2 = (int) (rayon * 0.809); // cosinus(72/2)
					e.gc.drawLine(xCentre, yCentre, xCentre-xVariation2, yCentre+yVariation2);
					e.gc.drawString("depth", xCentre-xVariation2-20, yCentre+yVariation2+10);

					e.gc.drawLine(xCentre, yCentre, xCentre+xVariation2, yCentre+yVariation2);
					e.gc.drawString("step", xCentre+xVariation2-20, yCentre+yVariation2+10);

					e.gc.setBackground(device.getSystemColor(SWT.COLOR_GREEN));
					// Segments
					draw5Segments(e, rayon / 4, xCentre, yCentre);
					draw5Segments(e, rayon / 2, xCentre, yCentre);
					draw5Segments(e, (rayon / 4) * 3, xCentre, yCentre);
					draw5Segments(e, rayon, xCentre, yCentre);


					draw5SegmentsBis(e, xCentre, yCentre, rayon,
							50, 25,
							90, 30,
							20, 20,
							56, 12,
							24, 16);

				} else {
					e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
					e.gc.fillRectangle(35, 29, labels.length * 30, 200);
					e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
					e.gc.fillRectangle(29, 29, 5, 2);
					e.gc.fillRectangle(29, 77, 5, 2);
					e.gc.fillRectangle(29, 127, 5, 2);
					e.gc.fillRectangle(29, 177, 5, 2);
					e.gc.fillRectangle(29, 227, 5, 2);
					e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_WHITE));
					e.gc.setForeground(e.gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
					e.gc.drawString("100%", 2, 19);
					e.gc.drawString("75%", 2, 67);
					e.gc.drawString("50%", 2, 117);
					e.gc.drawString("25%", 2, 167);
					e.gc.drawString("0%", 2, 217);
					int x = 39;
					int y = 30;
					for(int i = 0; i < pourcent.length; i++) {
						e.gc.setBackground(colors[i]);
						e.gc.fillRectangle(x, (100 - pourcent[i]) * 2 + 29, 20, pourcent[i] * 2);
						e.gc.fillRectangle(labels.length * 30 + 40, y + 10, 10, 10);
						e.gc.setBackground(e.gc.getDevice().getSystemColor(SWT.COLOR_WHITE));
						e.gc.setForeground(e.gc.getDevice().getSystemColor(SWT.COLOR_BLACK));
						e.gc.drawString(labels[i] + " " + pourcent[i] + "%", labels.length * 30 + 50, y + 10);
						y = y + 20;
						x = x + 30;
					}
				}
			}
		});
	}

	public void draw5Segments(PaintEvent pe, int lg, int xCentre, int yCentre) {
		int xVariation1 = (int) (lg * 0.951); // sinus(72)
		int yVariation1 = (int) (lg  * 0.309); // cosinus(72)
		pe.gc.drawLine(xCentre, yCentre - lg, xCentre-xVariation1, yCentre-yVariation1);
		pe.gc.drawLine(xCentre, yCentre - lg, xCentre+xVariation1, yCentre-yVariation1);
		int xVariation2 = (int) (lg * 0.588); // sinus(72/2)
		int yVariation2 = (int) (lg * 0.809); // cosinus(72/2)
		pe.gc.drawLine(xCentre-xVariation1, yCentre-yVariation1, xCentre-xVariation2, yCentre+yVariation2);
		pe.gc.drawLine(xCentre+xVariation1, yCentre-yVariation1, xCentre+xVariation2, yCentre+yVariation2);
		pe.gc.drawLine(xCentre-xVariation2, yCentre+yVariation2, xCentre+xVariation2, yCentre+yVariation2);
	}

	public void draw5SegmentsBis(PaintEvent pe, int xCentre, int yCentre, int rayon,
								int maxCoverage, int currentCoverage,
								int maxWidth, int currentWidth,
								int maxDepth, int currentDepth,
								int maxStep, int currentStep,
								int maxContext, int currentContext) {

		int lgPoint = rayon * currentCoverage / maxCoverage;
		int xP1 = xCentre;
		int yP1 = yCentre - lgPoint;

		lgPoint = rayon * currentWidth / maxWidth;
		int xVariation = (int) (lgPoint * 0.951); // sinus(72)
		int yVariation = (int) (lgPoint  * 0.309); // cosinus(72)
		int xP2 = xCentre-xVariation;
		int yP2 = yCentre-yVariation;

		lgPoint = rayon * currentDepth / maxDepth;
		xVariation = (int) (lgPoint * 0.588); // sinus(72/2)
		yVariation = (int) (lgPoint * 0.809); // cosinus(72/2)
		int xP3 = xCentre-xVariation;
		int yP3 = yCentre+yVariation;

		lgPoint = rayon * currentStep / maxStep;
		xVariation = (int) (lgPoint * 0.588); // sinus(72/2)
		yVariation = (int) (lgPoint * 0.809); // cosinus(72/2)
		int xP4 = xCentre+xVariation;
		int yP4 = yCentre+yVariation;

		lgPoint = rayon * currentContext / maxContext;
		xVariation = (int) (lgPoint * 0.951); // sinus(72)
		yVariation = (int) (lgPoint  * 0.309); // cosinus(72)
		int xP5 = xCentre+xVariation;
		int yP5 = yCentre-yVariation;
		Device device = Display.getCurrent();
		pe.gc.setBackground(device.getSystemColor(SWT.COLOR_RED));
		pe.gc.setForeground(device.getSystemColor(SWT.COLOR_RED));
		pe.gc.setLineWidth(3);
		pe.gc.drawLine(xP1, yP1, xP2, yP2);
		pe.gc.drawLine(xP2, yP2, xP3, yP3);
		pe.gc.drawLine(xP3, yP3, xP4, yP4);
		pe.gc.drawLine(xP4, yP4, xP5, yP5);
		pe.gc.drawLine(xP5, yP5, xP1, yP1);
	}


	public static SWTQualitativeInfo createSpider(Composite parent) {
		int[] pourcent = { 30, 20, 10, 40 };
		String[] labels = { "Added", "Modified", "Deleted", "Stable" };
		Device device = Display.getCurrent();
		org.eclipse.swt.graphics.Color[] colors = { device.getSystemColor(SWT.COLOR_GREEN),
				device.getSystemColor(SWT.COLOR_CYAN),
				device.getSystemColor(SWT.COLOR_RED),
				device.getSystemColor(SWT.COLOR_YELLOW) };

//		SWTQualitativeInfo canva = new SWTQualitativeInfo(shell, SWT.NULL, pourcent, labels, colors, DISK);
		SWTQualitativeInfo canva = new SWTQualitativeInfo(parent, SWT.NULL,
				pourcent, labels, colors, SPIDER);

		return canva;
	}

	/**
	 * static main to execute the example
	 *
	 * @param a
	 */
	public static void main(String[] a) {
		// Pour le lancer avec cliq droit : run as java application
		final Display display = new Display();

		// Pour le lancer depuis un code java
		//Display.getDefault();


		final Shell shell = new Shell(display);
		int[] pourcent = { 30, 20, 10, 40 };
		String[] labels = { "Added", "Modified", "Deleted", "Stable" };
		Device device = Display.getCurrent();
		org.eclipse.swt.graphics.Color[] colors = { device.getSystemColor(SWT.COLOR_GREEN),
				device.getSystemColor(SWT.COLOR_CYAN),
				device.getSystemColor(SWT.COLOR_RED),
				device.getSystemColor(SWT.COLOR_YELLOW) };

		@SuppressWarnings("unused")
//		SWTQualitativeInfo canva = new SWTQualitativeInfo(shell, SWT.NULL, pourcent, labels, colors, DISK);
		SWTQualitativeInfo canva = new SWTQualitativeInfo(shell, SWT.NULL, pourcent, labels, colors, SPIDER);

		shell.setLayout(new FillLayout());
		shell.pack();
		shell.setSize(500, 500); // largeur et hauteur de la fenêtre

		shell.setText("Repartition");
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
	}
}
