/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml.util;

import org.eclipse.efm.formalml.Configuration;
import org.eclipse.efm.formalml.DirectedPort;
import org.eclipse.efm.formalml.Block;
import org.eclipse.efm.formalml.Part;
import org.eclipse.efm.formalml.ReceiveAnyEvent;
import org.eclipse.efm.formalml.ReceiveEvent;
import org.eclipse.efm.formalml.ReceiveSignalEvent;
import org.eclipse.efm.formalml.TimedTransition;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

public class StereotypeUtil {

	/////////////////////////////////////
	// Other Constants
	/////////////////////////////////////

	public static final String XLIA_LANGUAGE = "xLIA language"; //$NON-NLS-1$



	/////////////////////////////////////
	// Getters for Configuration (old TestContext)
	/////////////////////////////////////

//	public static Stereotype getAppliedTestContext(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.TEST_CONTEXT );
//	}

	public static Configuration getConfiguration(Element context) {
		return UMLUtil.getStereotypeApplication(context, Configuration.class);
	}


	/////////////////////////////////////
	// Getters for Block (old Block)
	/////////////////////////////////////

//	public static Stereotype getAppliedBlock(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.BLOCK );
//	}

	public static Block getBlock(Element context) {
		return UMLUtil.getStereotypeApplication(context, Block.class);
	}


	/////////////////////////////////////
	// Getters for Part (old BlockInstance)
	/////////////////////////////////////

//	public static Stereotype getAppliedBlockInstance(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.BLOCK_INSTANCE );
//	}

	public static Part getPart(Element context) {
		return UMLUtil.getStereotypeApplication(context, Part.class);
	}


	/////////////////////////////////////
	// Getters for Diversity Port
	/////////////////////////////////////

//	public static Stereotype getAppliedPort(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.PORT );
//	}

	public static DirectedPort getDirectedPort(Element context) {
		return UMLUtil.getStereotypeApplication(context, DirectedPort.class);
	}


	/////////////////////////////////////
	// Getters for Diversity Connector
	/////////////////////////////////////

//	public static Stereotype getAppliedConnector(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.CONNECTOR );
//	}


	/////////////////////////////////////
	// Getters for Diversity Transition
	/////////////////////////////////////

//	public static Stereotype getAppliedTransition(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.TRANSITION );
//	}

	public static TimedTransition getTimedTransition(Element context) {

		return UMLUtil.getStereotypeApplication(context, TimedTransition.class);
	}


	/////////////////////////////////////
	// Getters for Diversity ReceiveEvent
	/////////////////////////////////////

//	public static Stereotype getAppliedReceiveEvent(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.RECEIVE_EVENT );
//	}

	public static ReceiveEvent getReceiveEvent(Element context) {

		return UMLUtil.getStereotypeApplication(context, ReceiveEvent.class);
	}


	/////////////////////////////////////
	// Getters for Diversity ReceiveAnyEvent
	/////////////////////////////////////

//	public static Stereotype getAppliedReceiveEvent(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.RECEIVE_ANY_EVENT );
//	}

	public static ReceiveAnyEvent getReceiveAnyEvent(Element context) {

		return UMLUtil.getStereotypeApplication(context, ReceiveAnyEvent.class);
	}


	/////////////////////////////////////
	// Getters for Diversity ReceiveEvent
	/////////////////////////////////////

//	public static Stereotype getAppliedReceiveEvent(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.RECEIVE_SIGNAL_EVENT );
//	}

	public static ReceiveSignalEvent getReceiveSignalEvent(Element context) {

		return UMLUtil.getStereotypeApplication(context, ReceiveSignalEvent.class);
	}


	/////////////////////////////////////
	// Getters for Diversity Clock
	/////////////////////////////////////

//	public static Stereotype getAppliedClock(Element context) {
//		return context.getAppliedStereotype( DiversityStereotype.CLOCK );
//	}



}
