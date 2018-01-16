/*******************************************************************************
 * Copyright (c) 2016 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Imen Boudhiba (CEA LIST) imen.boudhiba@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.core;

import java.util.ArrayList;

import org.eclipse.efm.modeling.codegen.xlia.util.PrettyPrintWriter;
//import org.eclipse.efm.modeling.formalml.ReceiveEvent;
import org.eclipse.efm.modeling.formalml.TimedTransition;
import org.eclipse.efm.modeling.formalml.helpers.StereotypeUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Vertex;

public class StatemachineCodeGenerator extends AbstractCodeGenerator {

	public static final String TRANSITION_GUARD_ELSE = "else";
	
	public static final String TRANSITION_TRIGGER_FINAL = "final";

	/**
	 * Constructor
	 */
	public StatemachineCodeGenerator(MainCodeGenerator supervisor) {
		super(supervisor);
	}


	/**
	 * performTransform dispatcher for any element to a writer
	 * @param element
	 * @param writer
	 */
	public void performTransformImpl(Element element, PrettyPrintWriter writer) {
		if( element instanceof StateMachine ) {
			transformStatemachine((StateMachine)element, writer);
		}

		else if( element instanceof Region ) {
			transformRegion((Region)element, writer);
		}

		else if( element instanceof Pseudostate ) {
			transformPseudostate((Pseudostate)element, writer);
		}
		else if( element instanceof FinalState ) {
			transformFinalState((FinalState)element, writer);
		}
		else if( element instanceof State ) {
			transformState((State)element, writer);
		}
		else if( element instanceof Vertex ) {
			transformVertexTransition((Vertex)element, writer);
		}
		else if( element instanceof Transition ) {
			transformTransition((Transition)element, writer);
		}

		else {
			performTransformError(this, element);
		}
	}

	/**
	 * performTransform a StateMachine element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformStatemachine(
			StateMachine element, PrettyPrintWriter writer) {
		final EList<Region> listOfRegion = element.getRegions();

		writer.appendTab("statemachine< ")
			.append( (listOfRegion.size() > 1) ? "and" : "or" )
			.append(" > ")
			.append(element.getName())
			.appendEol(" {");

		EList<Property> properties = element.getOwnedAttributes();
		if( (properties != null) && (! properties.isEmpty()) ) {
			// Section property
			//
			writer.appendTabEol("@property:");
			
			// A writer indenting with TAB + iTAB -> TAB2
			PrettyPrintWriter writer2 = writer.itab2();
			for( Element property : properties ) {
				fSupervisor.performTransform(property, writer2);
			}
		}
		
		transformRegion(listOfRegion, writer);

		writer.appendTab("} // end statemachine ")
			.appendEol2(element.getName());
	}


	public void transformStatemachine(StateMachine element,
			ArrayList<Message> inputMessage, PrettyPrintWriter writer) {
		final EList<Region> listOfRegion = element.getRegions();

		writer.appendTab("statemachine< ")
			.append( (listOfRegion.size() > 1) ? "and" : "or" )
			.append(" > ")
			.append(element.getName())
			.appendEol(" {");

		EList<Property> properties = element.getOwnedAttributes();
		if( (properties != null) && (! properties.isEmpty())
			|| ((inputMessage != null) && (! inputMessage.isEmpty())) ) {
			// Section property
			//
			writer.appendTabEol("@property:");
			
			// A writer indenting with TAB + iTAB -> TAB2
			PrettyPrintWriter writer2 = writer.itab2();

			writer2.appendTabEol("// message");
			
			// TODO declarer les variables necessaires pour l'input
			for (Message message : inputMessage) {
				if( message.getSignature() instanceof Signal ) {	
					writer2.appendTab(((Signal) message.getSignature()).getName())
						.append(" ")
						.appendEol(message.getName() + "#in;");
				}
			}
						
			writer2.appendTabEol("// end message");

			for( Element property : properties ) {
				fSupervisor.performTransform(property, writer2);
			}
		}
		
		transformRegion(listOfRegion, writer);

		writer.appendTab("} // end statemachine ")
			.appendEol2(element.getName());
	}


	/**
	 * performTransform a Region List element to a writer
	 * @param listOfRegion
	 * @param writer
	 */
	public void transformRegion(
			EList<Region> listOfRegion, PrettyPrintWriter writer) {
		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		int regionCount = listOfRegion.size();
		if( regionCount == 1 ) {
			Region uniqRegion = listOfRegion.get(0);

			writer.appendTab("@region: // name: ")
				.appendEol(uniqRegion.getName());

			transformRegionBody(uniqRegion, writer2);

			writer.appendTab("// end @region: ")
				.appendEol(uniqRegion.getName());
		}
		else if( regionCount >= 2 ) {
			writer.appendTabEol("@composite:"/*"@region:"*/);

			// A writer indenting with TAB2 + TAB -> TAB2
			PrettyPrintWriter writer3 = writer2.itab2();

			for( Region itRegion : listOfRegion ) {
				writer2.appendTab("state< or > ")
					.append( itRegion.getName() )
					.appendEol(" {");

				writer2.appendTabEol("@region:");
				transformRegionBody(itRegion, writer3);

				writer2.appendTab("} // end region ")
					.appendEol2(itRegion.getName());
			}
		}
	}


	/**
	 * performTransform a Region element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformRegion(Region element, PrettyPrintWriter writer) {
		writer.appendTab("region ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformRegionBody(element, writer.itab2());

		writer.appendTab("} // end region ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a Region element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformRegionBody(Region element, PrettyPrintWriter writer) {
		for( Vertex itVertex : element.getSubvertices() ) {
			if( itVertex instanceof Pseudostate ) {
				transformPseudostate((Pseudostate)itVertex, writer);
			}
			else if( itVertex instanceof FinalState ) {
				transformFinalState((FinalState)itVertex, writer);
			}
			else if( itVertex instanceof State ) {
				transformState((State)itVertex, writer);
			}
			else if( itVertex instanceof Vertex ) {
				transformVertex(itVertex, writer);
			}
		}
	}

	/**
	 * performTransform a Pseudostate element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformPseudostate(
			Pseudostate element, PrettyPrintWriter writer) {
		writer.appendTab("state< ")
			.append(element.getKind().toString())
			.append(" > ")
			.append(element.getName())
			.appendEol(" {");

		transformVertexTransition(element, writer);

		writer.appendTab("} // end pseudo-state ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a FinalState element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformFinalState(
			FinalState element, PrettyPrintWriter writer) {
		writer.appendTab("state< final > ")
			.append(element.getName())
			.appendEol(" {");

		transformVertexTransition(element, writer);

		writer.appendTab("} // end final-state ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a State element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformState(State element, PrettyPrintWriter writer) {
		writer.appendTab("state");
		if( element.isOrthogonal() ) {
			writer.append("< and >");
		}
		else if( element.isComposite() ) {
			writer.append("< or >");
		}
		writer.append(' ')
			.append(element.getName())
			.appendEol(" {");

		if( ! element.isComposite() ) {
			transformStateActivity(element, writer);
		}

		transformConnectionPoint(element, writer);

		transformRegion(element.getRegions(), writer);

		if( element.isComposite() ) {
			writer.appendTabEol("@transition:");
		}
		transformVertexTransition(element, writer);
		
		if( element.isComposite() ) {
			writer.appendTabEol("@moe:");
			transformStateActivity(element, writer);
		}
		
		writer.appendTab("} // end state ")
			.appendEol2(element.getName());
	}
	
	
	public void transformConnectionPoint(State element, PrettyPrintWriter writer) {
		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		for( Pseudostate itPoint : element.getConnectionPoints() ) {
			transformPseudostate(itPoint, writer2);
		}
	}


	/**
	 * performTransform a Vertex Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformStateActivity(
			State element, PrettyPrintWriter writer) {
		
		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		transformStateActivityBody("enable", element.getEntry(), writer2);

		transformStateActivityBody("irun", element.getDoActivity(), writer2);

		transformStateActivityBody("disable", element.getExit(), writer2);
	}

	public void transformStateActivityBody(
			String name, Behavior activity, PrettyPrintWriter writer) {
		if( activity != null ) {
			writer.appendTab("@")
				.append(name)
				.appendEol("{");
	
			fSupervisor.transformBehaviorBody(activity, writer.itab2());

			writer.appendTab("} // end ")
				.appendEol(name);
		}
	}

	/**
	 * performTransform a Vertex element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformVertex(Vertex element, PrettyPrintWriter writer) {
		writer.appendTab("vertex ")
			.append(element.getName())
			.appendEol(" {");

		transformVertexTransition(element, writer);

		writer.appendTab("} // end vertex ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a Vertex Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformVertexTransition(
			Vertex element, PrettyPrintWriter writer) {
		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		for( Transition itTransition : element.getOutgoings() ) {
			transformTransition(itTransition, writer2);
			// Si ce n'est pas la dernière transition sortante,
			// Ajout d'un saut de ligne supplémentaire
			if( element.getOutgoings().indexOf(itTransition) !=
					(element.getOutgoings().size() - 1) ) {
				writer.appendEol();
			}
		}
	}

	/**
	 * performTransform a Transition element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformTransition(Transition element, PrettyPrintWriter writer) {
		TimedTransition timedTransition =
				StereotypeUtil.getTimedTransition(element);
		
		//completion transition
		boolean isFinalTrigger = ( element.getTrigger(
				TRANSITION_TRIGGER_FINAL) != null );
		
		boolean isElseGuard = fSupervisor.isConstraintSymbol(
				element.getGuard(), TRANSITION_GUARD_ELSE);

		boolean isElseTransition = isElseGuard && (timedTransition == null);
		
		writer.appendTab("transition");
		if( isFinalTrigger ) {
			writer.append("< final ");
			if( isElseTransition ) {
				writer.append("& else >");
			}
			else {
				writer.append(">");
			}
		}
		else if( isElseTransition ) {
			writer.append("< else >");
		}
			

		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		// Triggers
		//
		if( fSupervisor.showTransitionSection ) {
			writer.appendTabEol("@trigger:");
		}
		for( Trigger itTrigger : element.getTriggers() ) {
			transformTrigger(itTrigger, writer);
		}

		// Guard
		//
		if( ! isElseGuard ) {
			if( fSupervisor.showTransitionSection ) {
				writer.appendTabEol("@guard:");
			}
			Constraint guard = element.getGuard();
			if( guard != null ) {
				ValueSpecification vsGuard = guard.getSpecification();
				if( vsGuard instanceof OpaqueExpression ) {
					OpaqueExpression exprGuard = (OpaqueExpression) vsGuard;
					for( String body : exprGuard.getBodies() ) {
						if( fSupervisor.showTransitionSection ) {
							writer.appendTab2Eol( body );
						}
						else {
							writer.appendTab2Eol("guard( " + body + " );");
						}
					}
				}
				else {
					writer.appendTab2();
					fSupervisor.transformValueSpecification(vsGuard, writer);
					writer.appendEol();
				}
			}
		}

		// Timed Guard
		//
		if( fSupervisor.showTransitionSection ) {
			writer.appendTabEol("@tguard:");
		}
		if( timedTransition != null ) {
			Constraint constraint = timedTransition.getTguard();
			if( constraint != null ) {
				ValueSpecification vsTGuard = constraint.getSpecification();
				if( vsTGuard instanceof OpaqueExpression ) {
					OpaqueExpression exprTGuard = (OpaqueExpression) vsTGuard;
					for( String body : exprTGuard.getBodies() ) {
						if( fSupervisor.showTransitionSection ) {
							writer.appendTab2Eol( body );
						}
						else {
							writer.appendTab2Eol("tguard( " + body + " );");
						}
					}
				}
				else {
					writer.appendTab2();
					fSupervisor.transformValueSpecification(vsTGuard, writer);
					writer.appendEol();
				}
			}
		}

		// Behavior
		//
		if( fSupervisor.showTransitionSection ) {
			writer.appendTabEol("@effect:");
		}
		
		fSupervisor.transformBehaviorBody(
				element.getEffect(), writer.itab2());

		writer.appendTab("} --> ")
				.append(element.getTarget().getName())
				.appendEol(";");
	}


	/**
	 * performTransform a Trigger element to a writer
	 * @param trigger
	 * @param writer
	 */
	public void transformTrigger(Trigger trigger, PrettyPrintWriter writer) {
		if( TRANSITION_TRIGGER_FINAL.equals(trigger.getName()) ) {
			return;
		}

		writer.appendTab2("input ");

		int portCount = trigger.getPorts().size();

		if( portCount == 1 ) {
			writer.append( trigger.getPorts().get(0).getName() );
		}
		else if( portCount > 1 ) {
			writer.append("[");
			boolean isnotFirst = false;
			for( Port port : trigger.getPorts() ) {
				if( isnotFirst ) {
					writer.append( " , " );
				}
				else {
					isnotFirst = true;
				}
				writer.append( port.getName() );
			}
			writer.append("]");
		}

		final Event event = trigger.getEvent();
		if( event != null ) {
//			writer.append("/* event: ").append(event.getName()).append(" */");
			if( event instanceof SignalEvent ) {
				if( portCount > 0 ) {
					writer.append(' ');
				}
				writer.append(((SignalEvent) event).getSignal().getName());
			}

//			ReceiveEvent inputEvent = StereotypeUtil.getReceiveEvent(event);
//			if( (inputEvent!=null) && (! inputEvent.getParameters().isEmpty()) ) {
//				writer.append('(');
//				boolean isnotFirst = false;
//				for( Property param : inputEvent.getParameters() ) {
//					if( isnotFirst ) {
//						writer.append(", ");
//					}
//					else {
//						isnotFirst = true;
//					}
//					writer.append(param.getName());
//				}
//				writer.append(")");
//			}
		}

		writer.appendEol(";");
	}

}
