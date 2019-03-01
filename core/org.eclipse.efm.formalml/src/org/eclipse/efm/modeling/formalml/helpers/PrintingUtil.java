/**
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package org.eclipse.efm.modeling.formalml.helpers;

//import org.eclipse.efm.modeling.formalml.ReceiveEvent;
import org.eclipse.efm.modeling.formalml.TimedTransition;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.ValueSpecification;

public class PrintingUtil {

	public static String print(Element e){
		if(e instanceof org.eclipse.uml2.uml.Transition) {
			return printTransition((org.eclipse.uml2.uml.Transition) e);
		}

		return( (e != null) ? e.toString() : "" );
	}


	public static String printTrigger(Trigger trig) {
		StringBuilder res = new StringBuilder();

		res.append("input ");
		if( ! trig.getPorts().isEmpty() ) {
			for(Port p : trig.getPorts()) {
				res.append( PrintEvent(p, trig.getEvent()) );
			}
		}
		else {
			res.append( PrintEvent(trig.getEvent()) );
		}

		return res.toString();
	}


	public static String printNamedElement(NamedElement e) {
		return e.getName();
	}


	public static String PrintEvent(Port port, Event event) {
		StringBuilder res = new StringBuilder();

		res.append(printNamedElement(port))
			.append(' ')
			.append( PrintEvent(event) );

		return res.toString();
	}

	public static String PrintEvent(Event event) {
		StringBuilder res = new StringBuilder();

		if(event != null) {
			if( event instanceof SignalEvent ) {
				res.append(((SignalEvent) event).getSignal().getName());
			}

//			ReceiveEvent receiveEvent =
//					StereotypeUtil.getReceiveEvent(event);
//			if( (receiveEvent!=null) &&
//				(! receiveEvent.getParameters().isEmpty()) ) {
//				res.append('(');
//
//				boolean hasAPropertyBefore = false;
//
//				for(Property p : receiveEvent.getParameters()){
//					if(hasAPropertyBefore){
//						res.append(',');
//					}
//					else {
//						hasAPropertyBefore=true;
//					}
//					res.append(printNamedElement(p));
//				}
//				res.append(')');
//			}
		}

		return res.toString();
	}


	public static String printEffect(Behavior effect) {
		StringBuilder res = new StringBuilder();

		if(effect instanceof OpaqueBehavior) {
			if( ! ((OpaqueBehavior)effect).getBodies().isEmpty() ) {
				res.append("/<opaq>")
					.append( "\"" )
					.append( ((OpaqueBehavior)effect).getBodies().get(0) )
					.append( "\"" );
			}
			else {
				res.append("/<name>")
					.append( effect.getName() );
			}
		}
		else if( effect != null ) {
			res.append("/<unknown>")
				.append( effect.getName() );
		}

		return res.toString();
	}


	public static String printTGuard(Constraint tguard) {
		StringBuilder res = new StringBuilder();

		if(tguard != null) {
			ValueSpecification specification = tguard.getSpecification();
			if(specification instanceof OpaqueExpression) {
				res.append("{\"")
					.append( ((OpaqueExpression)specification).getBodies().get(0) )
					.append("\"}");
			}
			else if(specification != null) {
				res.append("{")
				.append( specification.getName() )
				.append("}");
			}
		}

		return res.toString();
	}


	public static String printGuard(Constraint guard) {
		StringBuilder res = new StringBuilder();

		if(guard != null) {
			ValueSpecification specification = guard.getSpecification();
			if(specification instanceof OpaqueExpression) {
				res.append("[\"")
					.append( ((OpaqueExpression)specification).getBodies().get(0) )
					.append("\"]");
			}
			else if(specification != null) {
				res.append("[")
					.append( specification.getName() )
					.append("]");
			}
		}

		return res.toString();
	}


	public static String printTransition(org.eclipse.uml2.uml.Transition t) {
		StringBuilder res = new StringBuilder();

		for(Trigger trig : t.getTriggers())
			res.append(res).append(printTrigger(trig));

		res.append(' ')
			.append(printGuard(t.getGuard()));
		TimedTransition dt = StereotypeUtil.getTimedTransition(t);
		if(dt != null) {
			res.append(' ')
				.append(printTGuard(dt.getTguard()));
		}
		res.append(' ')
			.append(printEffect(t.getEffect()))
			.append(' ');

		return res.toString();
	}
}
