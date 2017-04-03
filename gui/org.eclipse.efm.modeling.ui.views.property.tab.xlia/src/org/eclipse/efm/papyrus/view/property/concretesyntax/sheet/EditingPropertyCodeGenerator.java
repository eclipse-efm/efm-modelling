/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*****************************************************************************/
package org.eclipse.efm.papyrus.view.property.concretesyntax.sheet;

import java.io.StringWriter;

import org.eclipse.efm.modeling.codegen.xlia.core.MainCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.util.PrettyPrintWriter;
import org.eclipse.efm.modeling.formalml.TimedTransition;
import org.eclipse.efm.modeling.formalml.helpers.StereotypeUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Vertex;

public class EditingPropertyCodeGenerator extends MainCodeGenerator {

	/**
	 * Constructor
	 */
	public EditingPropertyCodeGenerator() {
		super();
	}

	public String performTransform(EObject element) {
		if( element instanceof Element ) {
			StringWriter buffer = new StringWriter();
			PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

			if( element instanceof Transition ){
				transformTransition((Transition) element, writer);
			}
			else if( element instanceof Operation ){
				transformOperation((Operation) element, writer);
			}
			else {
				super.performTransform((Element)element, writer);
			}

			return( buffer.toString() );
		}

		else if( element != null ) {
			return( element.toString() );
		}
		else {
			return null;
		}
	}


	public void transformOperation(Operation element, PrettyPrintWriter writer) {
		writer.appendTab("macro routine ");
		if( element.getName() != null ) {
			writer.append( element.getName() );
		}
		else  {
			writer.append( "null<name>" );
		}

		super.transformOperationParameters(
				element.getOwnedParameters(), writer);

		writer.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		for( Behavior method : element.getMethods() ) {
			if( method instanceof OpaqueBehavior ) {
				writer.appendTab2("//begin xlia::behavior method ")
					.appendEol( method.getName() );

				transformOpaqueBehavior((OpaqueBehavior)method, writer2);

				writer.appendTab2("//end xlia::behavior method ")
					.appendEol( method.getName() );
			}
			else if( method instanceof Activity ) {
				writer.appendTab2("uml::activity ")
					.appendEol(method.getName());
			}
			else if( method instanceof Interaction ) {
				writer.appendTab2("uml::interaction ")
					.appendEol(method.getName());
			}
			else if( method instanceof StateMachine ) {
				writer.appendTab2("uml::statemachine ")
					.appendEol(method.getName());
			}
			else if( method != null ) {
				writer.appendTab2("uml::")
					.append(method.getClass().getSimpleName())
					.append(" ")
					.appendEol(method.getName());
			}
		}

		writer.appendTabEol("}");
	}


	public void transformStateMachine(StateMachine element, PrettyPrintWriter writer) {
		writer.appendTab("model statemachine< or > ")
			.append(element.getName())
			.appendEol(" {");

		for(Region itRegion : element.getRegions() ) {
			writer.appendEol();
			transformRegion(itRegion, writer);
		}

		writer.appendTab("} // end statemachine ")
			.appendEol2(element.getName());
	}


	public void transformRegion(Region element, PrettyPrintWriter writer) {
		writer.appendTabEol("@region:");

		// A writer indenting with TAB + iTAB -> TAB2
		super.fStatemachineFactory.transformRegionBody(element, writer.itab2());
}


	public void transformPseudostate(Pseudostate element, PrettyPrintWriter writer) {
		writer.appendTab("state< ")
			.append(element.getKind().toString())
			.append(" > ")
			.append(element.getName())
			.appendEol(" {");

		transformVertexContent(element, writer);

		writer.appendTab("} // end pseudo-state ")
			.appendEol2(element.getName());
	}

	public void transformFinalState(FinalState element, PrettyPrintWriter writer) {
		writer.appendTab("state< final > ")
			.append(element.getName())
			.appendEol(" {");

		transformVertexContent(element, writer);

		writer.appendTab("} // end final-state ")
			.appendEol2(element.getName());
	}

	public void transformState(State element, PrettyPrintWriter writer) {
		writer.appendTab("state");
		if( element.isOrthogonal() ) {
			writer.append("< and >");
		}
		else if( element.isComposite() ) {
			writer.append("< or >");
		}
		writer.append(" ")
			.append(element.getName())
			.appendEol(" {");

		super.fStatemachineFactory.transformStateActivity(element, writer);

		transformVertexContent(element, writer);

		super.fStatemachineFactory.transformConnectionPoint(element, writer);

		for(Region itRegion : element.getRegions() ) {
			writer.appendEol();
			transformRegion(itRegion, writer);
		}

		writer.appendTab("} // end state ")
			.appendEol2(element.getName());
	}

	public void transformVertex(Vertex element, PrettyPrintWriter writer) {
		writer.appendTab("vertex ")
			.append(element.getName())
			.appendEol(" {");

		transformVertexContent(element, writer);

		writer.appendTab("} // end vertex ")
			.appendEol2(element.getName());
	}

	public void transformVertexContent(Vertex element, PrettyPrintWriter writer) {
		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		for(Transition itTransition : element.getOutgoings() ) {
			transformTransition(itTransition, writer2);
			// Si ce n'est pas la dernière transition sortante,
			// Ajout d'un saut de ligne supplémentaire
			if( element.getOutgoings().indexOf(itTransition) !=
					element.getOutgoings().size()-1) {
				writer.appendEol();
			}
		}
	}


	public void transformTransition(Transition element, PrettyPrintWriter writer) {
		TimedTransition timedTransition =
				StereotypeUtil.getTimedTransition(element);
		
		boolean isElseGuard =
				super.isConstraintSymbol(element.getGuard(), "else");

		boolean isElseTransition = isElseGuard && (timedTransition == null);
		
		writer.appendTab("transition");
		if( isElseTransition ) {
			writer.append("< else >");
		}
		
		if( element.getName() != null ) {
			writer.append(" ")
				.append(element.getName());
		}
		writer.appendEol(" {");

		// Triggers
		//
		writer.appendTabEol("@trigger:");
		for(Trigger itTrigger : element.getTriggers() ) {
			super.fStatemachineFactory.transformTrigger(itTrigger, writer);
		}

		// Guard
		//
		writer.appendTabEol("@guard:");
		if( ! isElseGuard ) {
			Constraint guard = element.getGuard();
			if ( guard != null) {
				ValueSpecification vsGuard = guard.getSpecification();
				if( vsGuard instanceof OpaqueExpression ) {
					OpaqueExpression exprGuard = (OpaqueExpression) vsGuard;
					for( String body : exprGuard.getBodies() ) {
//						writer.appendTab2Eol("guard( " + body + " );");
						writer.appendTab2Eol( body );
					}
				}
				else {
					writer.appendTab2();
					super.transformValueSpecification(vsGuard, writer);
					writer.appendEol();
				}
			}
		}
		
		// Timed Guard
		//
		writer.appendTabEol("@tguard:");
		if( timedTransition != null ) {
			Constraint constraint = timedTransition.getTguard();

			if( constraint != null ) {
				ValueSpecification vsTGuard = constraint.getSpecification();
				if( vsTGuard instanceof OpaqueExpression ) {
					OpaqueExpression exprTGuard = (OpaqueExpression) vsTGuard;
					for( String body : exprTGuard.getBodies() ) {
//						writer.appendTab2Eol("tguard( " + body + " );");
						writer.appendTab2Eol( body );
					}
				}
				else {
					writer.appendTab2();
					super.transformValueSpecification(vsTGuard, writer);
					writer.appendEol();
				}
			}
		}

		// Behavior
		//
		writer.appendTabEol("@effect:");
		Behavior behavior = element.getEffect();
		if( behavior instanceof OpaqueBehavior ) {
			transformOpaqueBehavior((OpaqueBehavior)behavior, writer.itab2());
		}
		else if( behavior instanceof Activity ) {
			writer.appendTab2("// exec uml::activity ")
				.appendEol(behavior.getName());
		}
		else if( behavior instanceof Interaction ) {
			writer.appendTab2("// exec uml::interaction ")
				.appendEol(behavior.getName());
		}
		else if( behavior instanceof StateMachine ) {
			writer.appendTab2("// exec uml::statemachine ")
				.appendEol(behavior.getName());
		}
		else if( behavior != null ) {
			writer.appendTab2("// exec uml::")
				.append(behavior.getClass().getSimpleName())
				.append(" ")
				.appendEol(behavior.getName());
		}

		writer.appendTab("} --> ")
				.append(element.getTarget().getName())
				.appendEol(";");
	}


	public void transformOpaqueBehavior(
			OpaqueBehavior behavior, PrettyPrintWriter writer) {
		for( String body : behavior.getBodies() ) {
			if( body.startsWith(writer.iTAB) ) {
				body = body.trim().replaceAll(
						"\n" /*System.lineSeparator()*/ + writer.iTAB,
						writer.EOL + writer.TAB1);
				writer.appendTab2Eol(body);
			}
			else {
				body = body.replaceAll(
						"\n" /*System.lineSeparator()*/,
						writer.EOL + writer.TAB1);
				writer.appendTabEol(body);
			}
		}
	}

}
