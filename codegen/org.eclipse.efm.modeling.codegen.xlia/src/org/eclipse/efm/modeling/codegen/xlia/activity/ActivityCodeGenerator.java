/*******************************************************************************
 * Copyright (c) 2016 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.activity;

import org.eclipse.efm.modeling.codegen.xlia.core.AbstractCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.core.MainCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.util.PrettyPrintWriter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CentralBufferNode;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.ControlNode;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.ValuePin;

public class ActivityCodeGenerator extends AbstractCodeGenerator {

	public static final String TRANSITION_GUARD_ELSE = "else";

	public static final String TRANSITION_TRIGGER_FINAL = "final";

	/**
	 * Constructor
	 */
	public ActivityCodeGenerator(MainCodeGenerator supervisor) {
		super(supervisor);
	}


	/**
	 * performTransform dispatcher for any element to a writer
	 * @param element
	 * @param writer
	 */
	public void performTransformImpl(Element element, PrettyPrintWriter writer) {
		if( element instanceof Activity ) {
			transformActivity((Activity)element, writer);
		}

		// ActivityNodes
		else if( element instanceof ActivityNode )
		{
			// ActivityNodes as ControlNode
			if( element instanceof ControlNode )
			{
				// ActivityNodes as ControlNode as InitialNode
				if( element instanceof InitialNode ) {
					transformInitialNode((InitialNode)element, writer);
				}

				// ActivityNodes as ControlNode as FinalNodes
				else if( element instanceof FinalNode )
				{
					if( element instanceof FlowFinalNode ) {
						transformFlowFinalNode((FlowFinalNode)element, writer);
					}
					else if( element instanceof ActivityFinalNode ) {
						transformActivityFinalNode(
								(ActivityFinalNode)element, writer);
					}

					else {
						transformFinalNode((FinalNode)element, writer);
					}
				}

				// ActivityNodes as ControlNode as Controls Flow
				else if( element instanceof ForkNode ) {
					transformForkNode((ForkNode)element, writer);
				}
				else if( element instanceof JoinNode ) {
					transformJoinNode((JoinNode)element, writer);
				}

				else if( element instanceof MergeNode ) {
					transformMergeNode((MergeNode)element, writer);
				}
				else if( element instanceof DecisionNode ) {
					transformDecisionNode((DecisionNode)element, writer);
				}

				else //if( element instanceof ControlNode )
				{
					transformControlNode((ControlNode)element, writer);
				}
			}

			// ActivityNodes as ExecutableNode
			else if( element instanceof ExecutableNode )
			{
				// ActivityNodes as ExecutableNode
				if( element instanceof Action )
				{
					if( element instanceof OpaqueAction ) {
						transformOpaqueAction((OpaqueAction)element, writer);
					}

					if( element instanceof StructuredActivityNode )
					{
						if( element instanceof ConditionalNode ) {
							transformConditionalNode(
									(ConditionalNode)element, writer);
						}
						else if( element instanceof ExpansionRegion ) {
							transformExpansionRegion(
									(ExpansionRegion)element, writer);
						}
						else if( element instanceof LoopNode ) {
							transformLoopNode(
									(LoopNode)element, writer);
						}
						else if( element instanceof SequenceNode ) {
							transformSequenceNode(
									(SequenceNode)element, writer);
						}

						else {
							transformStructuredActivityNode(
								(StructuredActivityNode)element, writer);
						}
					}

					else //if( element instanceof Action )
					{
						transformAction((Action)element, writer);
					}
				}

				else //if( element instanceof ExecutableNode )
				{
					transformExecutableNode((ExecutableNode)element, writer);
				}
			}

			// ActivityNodes as ObjectNode
			else if( element instanceof ObjectNode )
			{
				if( element instanceof Pin )
				{
					// ActivityNodes as ObjectNode as InpuPins
					if( element instanceof InputPin )
					{
						if( element instanceof ActionInputPin )
						{
							// ActivityNodes as ObjectNode as InpuPins
							if( element instanceof ActionInputPin ) {
								transformActionInputPin(
										(ActionInputPin)element, writer);
							}

							else if( element instanceof ValuePin ) {
								transformValuePin((ValuePin)element, writer);
							}

							else //if( element instanceof InputPin )
							{
								transformInputPin((InputPin)element, writer);
							}
						}

						// ActivityNodes as ObjectNode as OutputPin
						else if( element instanceof OutputPin ) {
							transformOutputPin((OutputPin)element, writer);
						}
					}

					else //if( element instanceof Pin )
					{
						transformPin((Pin)element, writer);
					}
				}

				// ActivityNodes as ObjectNode as ActivityParameterNode
				else if( element instanceof ActivityParameterNode ) {
					transformActivityParameterNode(
							(ActivityParameterNode)element, writer);
				}

				// ActivityNodes as ObjectNode as CentralBufferNode
				else if( element instanceof CentralBufferNode )
				{
					if( element instanceof DataStoreNode ) {
						transformDataStoreNode((DataStoreNode)element, writer);
					}

					else //if( element instanceof CentralBufferNode )
					{
						transformCentralBufferNode(
								(CentralBufferNode)element, writer);
					}
				}
				else if( element instanceof ExpansionNode ) {
					transformExpansionNode((ExpansionNode)element, writer);
				}

				else //if( element instanceof ObjectNode )
				{
					transformObjectNode((ObjectNode)element, writer);
				}
			}

			else //if( element instanceof ActivityNode )
			{
				transformActivityNode((ActivityNode)element, writer);
			}
		}

		// ActivityEdges
		else if( element instanceof ActivityEdge )
		{
			if( element instanceof ControlFlow ) {
				transformControlFlow((ControlFlow)element, writer);
			}
			else if( element instanceof ObjectFlow ) {
				transformObjectFlow((ObjectFlow)element, writer);
			}
			else //if( element instanceof ActivityEdge )
			{
				transformActivityEdge((ActivityEdge)element, writer);
			}
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
	public void transformActivity(
			Activity element, PrettyPrintWriter writer) {
		final EList<ActivityNode> listOfNodes = element.getNodes();

		writer.appendTab("activity statemachine< ")
			.append( (listOfNodes.size() > 1) ? "and" : "or" )
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

		transformActivityNodes(listOfNodes, writer);

		writer.appendTab("} // end of activity statemachine ")
			.appendEol2(element.getName());
	}


	/**
	 * performTransform a Region List element to a writer
	 * @param listOfNodes
	 * @param writer
	 */
	public void transformActivityNodes(
			EList<ActivityNode> listOfNodes, PrettyPrintWriter writer) {
		writer.appendTabEol("@region:");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		for( ActivityNode itNode : listOfNodes ) {
			performTransformImpl(itNode, writer2);
		}

		writer.appendTabEol("// end of @region of ActivityNodes");
	}



	/**
	 * performTransform a ActivityNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformActivityNode(ActivityNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ActivityNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of machine< ActivityNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a OpaqueAction element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformOpaqueAction(OpaqueAction element, PrettyPrintWriter writer) {
		writer.appendTab("machine< OpaqueAction > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		transformInputPins(element.getInputs(), writer2);

		transformInputValues(element.getInputValues(), writer2);

		transformOutputPins(element.getOutputs(), writer2);

		transformOutputValues(element.getOutputValues(), writer2);

		transformActivityNodeEdges(element, writer2);

		writer.appendTab("} // end of machine< OpaqueAction > ")
			.appendEol2(element.getName());
	}


	/**
	 * performTransform a ConditionalNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformConditionalNode(
			StructuredActivityNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ConditionalNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2

		writer.appendTab("} // end of machine< ConditionalNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a ExpansionRegion element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformExpansionRegion(
			ExpansionRegion element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ExpansionRegion > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2

		writer.appendTab("} // end of machine< ExpansionRegion > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a LoopNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformLoopNode(
			LoopNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< LoopNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2

		writer.appendTab("} // end of machine< LoopNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a SequenceNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformSequenceNode(
			SequenceNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< SequenceNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2

		writer.appendTab("} // end of machine< SequenceNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a StructuredActivityNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transform(
			StructuredActivityNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< StructuredActivityNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2

		writer.appendTab("} // end of machine< StructuredActivityNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a StructuredActivityNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformStructuredActivityNode(
			StructuredActivityNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< StructuredActivityNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2

		writer.appendTab("} // end of machine< StructuredActivityNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a Action element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformAction(Action element, PrettyPrintWriter writer) {
		writer.appendTab("machine< Action > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		transformInputPins(element.getInputs(), writer2);

		transformOutputPins(element.getOutputs(), writer2);

		transformActivityNodeEdges(element, writer2);

		writer.appendTab("} // end of machine< Action > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a ExecutableNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformExecutableNode(ExecutableNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ExecutableNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of machine< ExecutableNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a ActivityParameterNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformActivityParameterNode(
			ActivityParameterNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ActivityParameterNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of machine< ActivityParameterNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a DataStoreNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformDataStoreNode(
			DataStoreNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< DataStoreNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of machine< DataStoreNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a CentralBufferNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformCentralBufferNode(
			CentralBufferNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< CentralBufferNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of machine< CentralBufferNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a ExpansionNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformExpansionNode(ExpansionNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ExpansionNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of machine< ExpansionNode > ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a ObjectNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformObjectNode(ObjectNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ObjectNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of machine< ObjectNode > ")
			.appendEol2(element.getName());
	}


	/**
	 * performTransform a ControlNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformControlNode(ControlNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ControlNode > ")
			.append(element.getName())
			.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of machine< ControlNode >")
			.appendEol2(element.getName());
	}


	/**
	 * performTransform a InitialNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformInitialNode(
			InitialNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< InitialNode > ")
			.append(element.getName())
			.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of InitialNode ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a FlowFinalNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformFlowFinalNode(
			FlowFinalNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< FlowFinalNode > ")
			.append(element.getName())
			.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of FlowFinalNode ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a ActivityFinalNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformActivityFinalNode(
			ActivityFinalNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ActivityFinalNode > ")
			.append(element.getName())
			.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of ActivityFinalNode ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a FinalNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformFinalNode(
			FinalNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< FinalNode > ")
			.append(element.getName())
			.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of FinalNode ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a ForkNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformForkNode(
			ForkNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< ForkNode > ")
			.append(element.getName())
			.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of ForkNode ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a JoinNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformJoinNode(
			JoinNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< JoinNode > ")
			.append(element.getName())
			.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of JoinNode ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a MergeNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformMergeNode(
			MergeNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< MergeNode > ")
			.append(element.getName())
			.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of MergeNode ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform a DecisionNode element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformDecisionNode(
			DecisionNode element, PrettyPrintWriter writer) {
		writer.appendTab("machine< DecisionNode > ")
			.append(element.getName())
			.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of DecisionNode ")
			.appendEol2(element.getName());
	}


	/**
	 * performTransform a Vertex Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformNodeActivity(
			ActivityNode element, PrettyPrintWriter writer) {

		// A writer indenting with TAB + iTAB -> TAB2
//		PrettyPrintWriter writer2 = writer.itab2();
//
//		transformStateActivityBody("enable", element.getEntry(), writer2);
//
//		transformStateActivityBody("irun", element.getDoActivity(), writer2);
//
//		transformStateActivityBody("disable", element.getExit(), writer2);
	}

	public void transformStateActivityBody(
			String name, Behavior activity, PrettyPrintWriter writer) {
		if( activity != null ) {
			writer.appendTab("@")
				.append(name)
				.appendEol("{");

			fSupervisor.transformBehaviorBody(activity, writer.itab2());

			writer.appendTab("} // end of @")
				.appendEol(name);
		}
	}


	/**
	 * performTransform a ActivityNodeEdges Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformActivityNodeEdges(
			ActivityNode element, PrettyPrintWriter writer) {
		// A writer indenting with TAB + iTAB -> TAB2
		for( ActivityEdge itEdge : element.getOutgoings() ) {
			transformActivityEdge(itEdge, writer);
			// Si ce n'est pas la dernière transition sortante,
			// Ajout d'un saut de ligne supplémentaire
			if( element.getOutgoings().indexOf(itEdge) !=
					(element.getOutgoings().size() - 1) ) {
				writer.appendEol();
			}
		}
	}


	/**
	 * performTransform a InputPins Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformInputPins(
			EList<InputPin> inputPins, PrettyPrintWriter writer) {
		if( (inputPins == null) || inputPins.isEmpty() ) {
			return;
		}

		for( InputPin itPin : inputPins ) {
			transformInputPin(itPin, writer);
		}
	}

	public void transformInputValues(
			EList<InputPin> inputValues, PrettyPrintWriter writer) {
		if( (inputValues == null) || inputValues.isEmpty() ) {
			return;
		}

//		for( InputPin itPin : inputValues ) {
//			transformInputPin(itPin, writer);
//		}
	}

	/**
	 * performTransform a ActionInputPin Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformActionInputPin(
			ActionInputPin element, PrettyPrintWriter writer) {

		writer.appendTab("action input pin ");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of action input pin ")
			.appendEol(element.getName());
	}

	/**
	 * performTransform a ValuePin Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformValuePin(
			ValuePin element, PrettyPrintWriter writer) {

		writer.appendTab("value pin ");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of value pin ")
			.appendEol(element.getName());
	}

	/**
	 * performTransform a InputPin Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformInputPin(
			InputPin element, PrettyPrintWriter writer) {

		writer.appendTab("input pin ");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of input pin ")
			.appendEol(element.getName());
	}


	/**
	 * performTransform a OutputPins Content element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformOutputPins(
			EList<OutputPin> outputPins, PrettyPrintWriter writer) {
		if( (outputPins == null) || outputPins.isEmpty() ) {
			return;
		}

		for( OutputPin itPin : outputPins ) {
			transformOutputPin(itPin, writer);
		}
	}

	public void transformOutputValues(
			EList<OutputPin> outputValues, PrettyPrintWriter writer) {
		if( (outputValues == null) || outputValues.isEmpty() ) {
			return;
		}

//		for( OutputPin itPin : outputValues ) {
//			transformOutputPin(itPin, writer);
//		}
	}

	/**
	 * performTransform a OutputPin element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformOutputPin(
			OutputPin element, PrettyPrintWriter writer) {

		writer.appendTab("output pin ");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of output pin ")
			.appendEol(element.getName());
	}


	/**
	 * performTransform a Pin element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformPin(
			Pin element, PrettyPrintWriter writer) {

		writer.appendTab("pin ");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		transformActivityNodeEdges(element, writer.itab2());

		writer.appendTab("} // end of pin ")
			.appendEol(element.getName());
	}


	/**
	 * performTransform a ControlFlow element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformControlFlow(ControlFlow element, PrettyPrintWriter writer) {
		writer.appendTab("transition< ControlFlow > ");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		writer.appendTab("} --> ")
		.append(element.getTarget().getName())
		.appendEol(";");
	}

	/**
	 * performTransform a ObjectFlow element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformObjectFlow(ObjectFlow element, PrettyPrintWriter writer) {
		writer.appendTab("transition< ObjectFlow > ");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		writer.appendTab("} --> ")
		.append(element.getTarget().getName())
		.appendEol(";");
	}

	/**
	 * performTransform a Transition element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformActivityEdge(ActivityEdge element, PrettyPrintWriter writer) {
		writer.appendTab("transition< ActivityEdge > ");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" {");

		writer.appendTab("} --> ")
		.append(element.getTarget().getName())
		.appendEol(";");
	}

}
