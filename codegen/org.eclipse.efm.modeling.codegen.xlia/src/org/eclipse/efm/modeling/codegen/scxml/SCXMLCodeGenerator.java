/*******************************************************************************
 * Copyright (c) 2016 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Imen Boudhiba (CEA LIST) imen.boudhiba@cea.fr - initial API and implementation
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.scxml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.modeling.codegen.xlia.core.MainCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.util.PrettyPrintWriter;
import org.eclipse.efm.modeling.codegen.xlia.util.StatemachineContext;
import org.eclipse.efm.modeling.codegen.xlia.util.StatemachineContext.CONTEXT;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Vertex;

public class SCXMLCodeGenerator {

	public static final String XML_HEADER
			= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"; //$NON-NLS-1$

	public static final String SCXML_HEADER
			= "<scxml version=\"1.0\""
			+ " datamodel=\"native\""
			+ " xmlns=\"http://www.w3.org/2005/07/scxml\""
			+ ">"; //$NON-NLS-1$

	public static final String SCXML_FOOTER
			= "</scxml>";

	/**
	 * Constructor
	 */
	public SCXMLCodeGenerator() {
		super();
	}


	/**
	 * performTransform any element to a string
	 * @param element
	 * @return
	 */
	public String performTransform(EObject element) {
		if( element instanceof Element ) {
			StringWriter buffer = new StringWriter();
			PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

			writer.appendEol( XML_HEADER ).appendEol( SCXML_HEADER );

			performTransform((Element)element, writer.itab2());

			writer.appendEol( SCXML_FOOTER );

			writer.close();

			return( buffer.toString() );
		}

		else if( element != null ) {
			return( element.toString() );
		}
		else {
			return null;
		}
	}

	/**
	 * performTransform any element to a file
	 * @param element
	 * @param filePath
	 * @return
	 */
	public boolean performTransform(EObject element, IPath filePath) {
		if( element instanceof Element ) {
			FileWriter buffer;
			try {
				buffer = new FileWriter(filePath.toOSString());

				PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

				performTransform((Element)element, writer);

				writer.close();

				return( true );

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return( false );
	}


	/**
	 * performTransform dispatcher for any element to a writer
	 * @param element
	 * @param writer
	 */
	public void performTransform(Element element, PrettyPrintWriter writer)
	{
		// Statemachine Elements
		if( element instanceof StateMachine ) {
			transformStatemachine((StateMachine)element, writer);
		}

		else if( element instanceof Region ) {
			transformRegion((Region)element, writer);
		}

		else if( element instanceof Vertex )
		{
			if( element instanceof FinalState ) {
				transformFinalState((FinalState)element, writer);
			}

			else if( element instanceof State ) {
				transformState((State)element, writer);
			}

			else if( element instanceof Pseudostate ) {
				transformPseudostate((Pseudostate)element, writer);
			}

			else {
				transformVertex((Vertex)element, writer);
			}
		}

		else if( element instanceof Transition ) {
			transformTransition((Transition)element, writer);
		}

		// This Factory
//		else if( element instanceof OpaqueBehavior ) {
//			transformOpaqueBehavior((OpaqueBehavior)element, writer);
//		}
//
//		// ActivitymachineFactory
//		else if( (element instanceof Activity )
//				|| (element instanceof ActivityNode )
//				|| (element instanceof ActivityEdge ) )
//		{
//			fActivityFactory.performTransformImpl(element, writer);
//		}
//
//
		// Interaction Factory
		else if( element instanceof Interaction )
		{
			performTransformInteraction((Interaction)element, writer);
		}
		else if( element instanceof Lifeline )
		{
			performTransformLifeline((Lifeline)element, writer);
		}
//
//
//		// DataTypeFactory
//		else if( element instanceof Enumeration ) {
//			fDataTypeFactory.transformEnumeration((Enumeration)element, writer);
//		}
//
//		else if( element instanceof EnumerationLiteral ) {
//			fDataTypeFactory.transformEnumerationLiteral(
//					(EnumerationLiteral)element, writer);
//		}
//
//		else if( element instanceof DataType ) {
//			fDataTypeFactory.transformDataType((DataType)element, writer);
//		}
//
//		// This Factory
//		else if( element instanceof Port ) {
//			transformPort((Port)element, writer);
//		}
//		else if( element instanceof Parameter ) {
//			transformParameter((Parameter)element, writer);
//		}
//		else if( element instanceof Property ) {
//			transformProperty((Property)element, writer);
//		}
//
//		else if( element instanceof Operation ) {
//			transformOperation((Operation)element, writer);
//		}
//
//		else if( element instanceof Connector ) {
//			transformConnector((Connector)element, writer);
//		}
//		else if( element instanceof Signal ) {
//			transformSignal((Signal)element, writer);
//		}

		// ClassFactory
//		else if( element instanceof Class ) {
//			transformClassDefinition((Class)element, writer);
//		}
//
//		else if( element instanceof Model ) {
//			transformFormalModel((Model)element, writer);
//		}
//
//		else if( element instanceof Package ) {
//			transformPackageDefinition((Package)element, writer);
//		}

//		else if( element instanceof NamedElement ) {
//			writer.appendTab("named_element");
//			if( ((NamedElement)element).getName() != null ) {
//				writer.append(' ')
//					.append(((NamedElement)element).getName());
//			}
//			writer.appendEol(" { /* TODO */ }");
//		}
//		else {
//			writer.appendTab(element.getClass().getName())
//				.append(' ').append( element instanceof NamedElement ?
//						((NamedElement) element).getName() : element.toString());
//		}
	}


	private String idOf(NamedElement element) {
//		return( element.getQualifiedName() );
		return( element.getName() + "@" + Integer.toHexString(element.hashCode()) );
	}


	private void performTransformInteraction(
			Interaction element, PrettyPrintWriter writer)
	{
		final StatemachineContext lfContext =
				new StatemachineContext(element, CONTEXT.INTERACTION);

		transformInteraction(element, element.getLifelines(), lfContext, writer);
	}

	private void transformInteraction(Interaction element, List<Lifeline> lifelines,
			StatemachineContext lfContext, PrettyPrintWriter writer)
	{
		MainCodeGenerator fXLIACodeGenerator = new MainCodeGenerator();

		for( Lifeline lifeline : lifelines ) {
			lfContext = fXLIACodeGenerator.fInteractionFactory.transformWriteLifeline(lifeline, lfContext);

			transformStatemachine(lfContext.statemachine, writer);
		}
	}


	private void performTransformLifeline(Lifeline element, PrettyPrintWriter writer)
	{
		final StatemachineContext lfContext =
				new StatemachineContext(element.getInteraction(), CONTEXT.LIFELINE);

		transformInteraction(element.getInteraction(),
				Arrays.asList( element ), lfContext, writer);
	}


	private void transformStatemachine(StateMachine element, PrettyPrintWriter writer)
	{
		final EList<Region> listOfRegion = element.getRegions();
		final int regionCount = listOfRegion.size();

		Pseudostate initial = ( regionCount == 1 ) ?
				getInitialState(listOfRegion.get(0)) : null;

		writer.appendTab("<")
			.append( (regionCount < 2) ? "state" : "parallel" )
			.append(" id=\"").append(idOf(element)).append("\"");

		if( initial != null ) {
			writer.append(" initial=\"").append( idOf(initial) ).append("\"");
		}

		writer.appendEol(">");

		transformRegion(element.getRegions(), writer.itab2());

		writer.appendTab("</")
			.append( (regionCount < 2) ? "state" : "parallel" )
			.appendEol(">");
	}


	private Pseudostate getInitialState(Region region) {
		for( Vertex itVertex : region.getSubvertices() ) {
			if( (itVertex instanceof Pseudostate) ) {
				final Pseudostate pseudostate = (Pseudostate)itVertex;
				if( pseudostate.getKind() == PseudostateKind.INITIAL_LITERAL ) {
					return pseudostate;
				}
			}
		}
		return null;
	}


	private void transformRegion(EList<Region> regions, PrettyPrintWriter writer) {
		if( regions.size() == 1 ) {
			transformRegionBody(regions.get(0), writer);
		}
		else {
			for( Region itRegion : regions ) {
				transformRegion(itRegion, writer);
			}
		}
	}


	private void transformRegion(Region element, PrettyPrintWriter writer)
	{
		writer.appendTab("<state id=\"REGION#")
			.append(idOf(element)).appendEol("\">");

		transformRegionBody(element, writer.itab2());

		writer.appendTabEol("</state>");
	}

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
			else {
				transformVertex(itVertex, writer);
			}
		}
	}


	private void transformState(State element, PrettyPrintWriter writer)
	{
		final EList<Region> listOfRegion = element.getRegions();
		final int regionCount = listOfRegion.size();

		Pseudostate initial = ( regionCount == 1 ) ?
				getInitialState(listOfRegion.get(0)) : null;

		writer.appendTab("<")
			.append( (regionCount < 2) ? "state" : "parallel" )
			.append(" id=\"").append(idOf(element)).append("\"");

		if( initial != null ) {
			writer.append(" initial=\"").append( idOf(initial) ).append("\"");
		}

		writer.appendEol(">");

		transformRegion(element.getRegions(), writer.itab2());

		transformVertexTransition(element, writer.itab2());

		writer.appendTab("</")
			.append( (regionCount < 2) ? "state" : "parallel" )
			.appendEol(">");
	}


	private void transformFinalState(FinalState element, PrettyPrintWriter writer)
	{
		writer.appendTab("<final id=\"").append(idOf(element)).appendEol("\">");

		transformVertexTransition(element, writer.itab2());

		writer.appendTabEol("</final>");
	}

	private void transformPseudostate(Pseudostate element, PrettyPrintWriter writer)
	{
		String pseudoStatekind = "state";
		switch( element.getKind() ) {
			case INITIAL_LITERAL :
//				pseudoStatekind = "initial";
				break;
			case DEEP_HISTORY_LITERAL :
			case SHALLOW_HISTORY_LITERAL :
				pseudoStatekind = "history";
				break;
			case JOIN_LITERAL :
			case FORK_LITERAL :
			case JUNCTION_LITERAL :
			case CHOICE_LITERAL :
			case ENTRY_POINT_LITERAL :
			case EXIT_POINT_LITERAL :
			case TERMINATE_LITERAL :
				break;
		}

		writer.appendTab("<").append( pseudoStatekind )
			.append(" id=\"").append(idOf(element)).appendEol("\">");

		transformVertexTransition(element, writer.itab2());

		writer.appendTab("</")
			.append( pseudoStatekind )
			.appendEol(">");
	}


	private void transformVertex(Vertex element, PrettyPrintWriter writer) {
		writer.appendTab("<state id=\"VERTEX#")
			.append(idOf(element)).appendEol("\">");

		transformVertexTransition(element, writer.itab2());

		writer.appendTabEol("</state>");
	}

	private void transformVertexTransition(Vertex element, PrettyPrintWriter writer)
	{
		for( Transition itTransition : element.getOutgoings() ) {
			transformTransition(itTransition, writer);
		}
	}


	private void transformTransition(Transition element, PrettyPrintWriter writer)
	{
		writer.appendTab("<transition");
		final String name = element.getName();
		if( name != null ) {
			writer.append(" event=\"").append( name ).append("\"");
		}
		writer.append(" target=\"")
			.append( idOf(element.getTarget()) ).append("\"");

		final Constraint guard = element.getGuard();
		if( guard != null ) {
			String strGuard = strConstraint(guard);
			strGuard = strGuard.replaceAll("&", "&amp;");
			strGuard = strGuard.replaceAll("\"", "&quot;");
			strGuard = strGuard.replaceAll("'", "&apos;");

			strGuard = strGuard.replaceAll("<", "&lt;");
			strGuard = strGuard.replaceAll(">", "&gt;");

			writer.append(" cond=\"").append( strGuard ).append("\"");
		}

		writer.appendEol(">")
			.appendTabEol("</transition>");
	}



	private String strConstraint(Constraint constraint)
	{
		ValueSpecification valueSpec = constraint.getSpecification();

		if( valueSpec instanceof OpaqueExpression ) {
			StringBuilder buffer = new StringBuilder();

			OpaqueExpression opaqueExpression = (OpaqueExpression) valueSpec;

			boolean requireSeparator = false;
			for( String body : opaqueExpression.getBodies() ) {
				if( requireSeparator ) {
					buffer.append(" && ");
				}
				else {
					requireSeparator = true;
				}
				buffer.append( body );
			}

			return buffer.toString();
		}
		else {
			return strValueSpecification(valueSpec);
		}
	}

	private String strValueSpecification(ValueSpecification valueSpec) {
		StringBuilder buffer = new StringBuilder();

		if( valueSpec instanceof LiteralBoolean ) {
			buffer.append(valueSpec.booleanValue());
		}
		else if( valueSpec instanceof LiteralInteger ) {
			buffer.append(valueSpec.integerValue());
		}
		else if( valueSpec instanceof LiteralReal ) {
			buffer.append(valueSpec.realValue());
		}
		else if( valueSpec instanceof LiteralString ) {
			buffer.append(valueSpec.stringValue());
		}
		else if( valueSpec instanceof LiteralUnlimitedNatural ) {
			buffer.append(valueSpec.unlimitedValue());
		}
		else if( valueSpec instanceof Expression ) {
			buffer.append("(");

			Expression expr = (Expression) valueSpec;

			buffer.append( (expr.getSymbol() != null) ?
					expr.getSymbol() : "<symbol:null>" );

			for(ValueSpecification operand : expr.getOperands() ) {
				buffer.append(" ");
				strValueSpecification(operand);
			}

			buffer.append(")");
		}
		else if(  valueSpec != null ) {
			final String name = valueSpec.getName();
			if( name != null ) {
				buffer.append("ValueSpecification< ")
					.append(name)
					.append(" > ");
			}
			buffer.append(valueSpec.toString());
		}

		return buffer.toString();
	}


}
