/*******************************************************************************
 * Copyright (c) 2017 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Imen BOUDHIBA (CEA LIST) imen.boudhiba@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.core;

import org.eclipse.efm.modeling.codegen.xlia.util.PrettyPrintWriter;
import org.eclipse.efm.modeling.codegen.xlia.util.StatemachineContext;
import org.eclipse.efm.modeling.codegen.xlia.util.UmlFactory;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.ValueSpecification;


public class InteractionCodeGenerator extends AbstractCodeGenerator {

	/**
	 * Constructor
	 */
	public InteractionCodeGenerator(MainCodeGenerator supervisor) {
		super(supervisor);
	}


	/**
	 * performTransform dispatcher for any element to a writer
	 * @param element
	 * @param writer
	 */
	public void performTransformImpl(Element element, PrettyPrintWriter writer) {
		if( element instanceof Interaction ) {
			transformInteraction((Interaction)element, null, writer);
		}

		else if( element instanceof Lifeline ) {
			transformLifeline((Lifeline)element, null, writer);
		}
		
		else if( element instanceof InteractionOperand ) {
			transformFragment(
					(InteractionOperand)element, null, writer);
		}
		
		else if( element instanceof CombinedFragment ) {
			transformFragment((CombinedFragment)element, null, writer);
		}
		
		else if( element instanceof Message ) {
			transformMessage((Message)element, null, writer);
		}
		else if( element instanceof MessageOccurrenceSpecification ) {
			transformFragment(
					(MessageOccurrenceSpecification)element, null, writer);
		}
		
		else if( element instanceof BehaviorExecutionSpecification ) {
			transformFragment((BehaviorExecutionSpecification)element, null, writer);
		}

		else {
			performTransformError(this, element);
		}
	}

	/**
	 * performTransform an Interaction element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformInteraction(Interaction element,
			StatemachineContext lfContext, PrettyPrintWriter writer) {
		if( lfContext == null ) {
			writer.appendTabEol2(ClassCodeGenerator.XLIA_SYSTEM_1_0);

			writer.appendTab("system< and > ")
				.append(element.getName())
				.appendEol(" {");
			
			writer.appendEol("@property: ");
			writer.appendTabEol("// message");
			for( Message message : element.getMessages() ) {
				writer.appendTab2("message " )
					.append(message.getName())
					.appendEol(";");
			}
			writer.appendTabEol("// end message");
			
			// Extra element needed to respect model semantic
			for( Lifeline lifeline : element.getLifelines() ) {
				writer.appendTab2("var fifo<integer , 30> " )
					.append( "sched_").append(lifeline.getName())
					.appendEol(";");
			
			}
			
			//
			for( Lifeline lifeline : element.getLifelines() ) {
				writer.appendTab2("var fifo<integer , *> " )
					.append( "fifo_").append(lifeline.getName())
					.appendEol(";");
			}
			
			
			writer.appendEol("@composite: ");
			PrettyPrintWriter writer2 = writer.itab2();
			
			for( Lifeline lifeline : element.getLifelines() ) {
				
				transformLifeline(lifeline, new StatemachineContext(lifeline), writer2);
			}
			
			writer.appendTab("} // end Interaction ")
				.appendEol2(element.getName());
		}
		else {
			// A writer indenting with TAB + iTAB -> TAB2
			PrettyPrintWriter writer2 = writer.itab2();
			
			writer2.appendTab("////////////////////////////////////////////////////////////////////////////// Lifeline ")
				.append(lfContext.coveredLifeline.getName())
				.appendEol(" //////////////////////////////////////////////////////////////////////////////");
			
			for( InteractionFragment iFragment : element.getFragments() ) {
				
				if( iFragment.getCovereds().contains(lfContext.coveredLifeline)) {
					// TODO lfContext.isLastFragmentTransformation ???
					lfContext.isLastFragmentTransformation = false;
					transformFragment(iFragment, lfContext, writer2);
				}
			}
			
			//TODO DELETE Transition tr_final
			Transition tr_final = lfContext.createTransition(
					"tr_final", lfContext.currentState, lfContext.finalState);
		}		
	}


	/**
	 * performTransform a Fragment element to a writer
	 * @param element
	 * @param writer
	 */
	
	private void transformFragment(InteractionFragment element,
			StatemachineContext lfContext, PrettyPrintWriter writer) {
		
		if( lfContext == null ) {
			for (Lifeline lifeline : element.getCovereds()) {
				lfContext = new StatemachineContext(lifeline);
				
				// TODO lfContext.isLastFragmentTransformation ???
				lfContext.isLastFragmentTransformation = false;
				transformFragment(element, lfContext);
				
				lfContext.toWriter(fSupervisor.fStatemachineFactory, writer);
			}
		}
		else {
			transformFragment(element, lfContext);
			
			lfContext.toWriter(fSupervisor.fStatemachineFactory, writer);
		}
	}

	
	private void transformFragment(InteractionFragment iFragment,
			StatemachineContext lfContext) {
		if( lfContext == null ) {
			
		} else {
			
		}

		if( iFragment instanceof CombinedFragment ) {
			transformCombinedFragment(
					(CombinedFragment)iFragment, lfContext);
		}

		else if( iFragment instanceof InteractionOperand ) {
			transformInteractionOperand(
					(InteractionOperand)iFragment, lfContext);
		}
		 
		else if( iFragment instanceof MessageOccurrenceSpecification ) {
			transformMessageOccurrenceSpecification(
					(MessageOccurrenceSpecification)iFragment, lfContext);
		}

		else if( iFragment instanceof BehaviorExecutionSpecification ) {
			transformBehaviorExecutionSpecification(
					(BehaviorExecutionSpecification)iFragment, lfContext);
		}

		//else if( iFragment instanceof ExecutionOccurrenceSpecification ) {
		//	transformExecutionOccurrenceSpecification(
		//			(ExecutionOccurrenceSpecification)iFragment, lfContext);
		//}

		else {
			performTransformError(this, iFragment);
		}
	}


	
	/**
	 * performTransform a InteractionOperand element
	 * @param element
	 * @param writer
	 */
	private void transformInteractionOperand(InteractionOperand element,
			StatemachineContext lfContext) {

		for( InteractionFragment iFragment : element.getFragments() ) {
			
			if (iFragment.getCovereds().contains(lfContext.coveredLifeline)) {
				// TODO lfContext.isLastFragmentTransformation ???
				lfContext.isLastFragmentTransformation = false;
				transformFragment(iFragment, lfContext);
			}
		}
		
		Transition tr_final = lfContext.createTransition(
				"tr_final", lfContext.currentState, lfContext.finalState);
	}

	/**
	 * performTransform a CombinedFragment element
	 * @param element
	 * @param writer
	 */
	public void transformCombinedFragment(CombinedFragment element,
			StatemachineContext lfContext) {

		if (element.getInteractionOperator() == InteractionOperatorKind.LOOP_LITERAL) {
			transformCombinedFragmentLoop(element, lfContext);
		}
		
		else if (element.getInteractionOperator()== InteractionOperatorKind.ALT_LITERAL) {
			transformCombinedFragmentAlt(element, lfContext);
		}
		
		else if (element.getInteractionOperator()== InteractionOperatorKind.OPT_LITERAL) {
			transformCombinedFragmentOpt(element, lfContext);
		}
		
		else if (element.getInteractionOperator()== InteractionOperatorKind.STRICT_LITERAL) {
			transformCombinedFragmentStrict(element, lfContext);
		}
	}

	
	////////////////////////////////////// Transform Loop Fragment //////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	
	public void transformCombinedFragmentLoop(CombinedFragment element,
			StatemachineContext lfContext) {
		
		lfContext.currentState.setName("LoopFragment#" + element.getName());
		Constraint loopGuard = element.getOperands().get(0).getGuard();
		State loopState = lfContext.createTargetState("loop_" + element.getName());
		
		Transition entryLoop = lfContext.createTransition(
				"tr_loop_first", lfContext.currentState, loopState);
		UmlFactory.setGuard(entryLoop, loopGuard);
		// TODO Add effect behavior
		
		entryLoop= lfContext.createTransition(
				"tr_loop_not_first", lfContext.currentState, loopState);
		UmlFactory.setGuard(entryLoop, loopGuard);
		// TODO Add effect behavior

		lfContext.currentState = loopState;
		
		// loop boucle with min/max index constraint
		Transition trLoop = lfContext.createTransition(
				"tr_loop", loopState, loopState);
		if( loopGuard instanceof InteractionConstraint ) {
			Property loopIndex = UmlFactory.createVariable(lfContext.statemachine,
					"loopIndex_" + element.getName(), UmlFactory.integerType());

			UmlFactory.setGuard(trLoop, (InteractionConstraint) loopGuard, loopIndex);
		} 
		else {
			UmlFactory.setGuard(trLoop, loopGuard);
		}
		
		// quit loop transition
		State quitloopState = lfContext.createTargetState("quit_loop_" + element.getName());
		Transition quitLoop = lfContext.createElseTransition(
				"tr_quit_loop", loopState, quitloopState);
		lfContext.currentState = quitloopState;
		
		
		StatemachineContext loopContext = new StatemachineContext(lfContext, element);
		
		for( InteractionOperand iFragment : element.getOperands()) {
			transformInteractionOperand(iFragment, loopContext);
		}
	}

	
	
//////////////////////////////////////Transform Alt Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

public void transformCombinedFragmentAlt(CombinedFragment element,
		StatemachineContext lfContext) {
	
	State exitAltState = lfContext.createTargetState("exit_alt#" + element.getName());
	
	State sourceAltStates = lfContext.currentState;
	
	for( InteractionOperand iFragment : element.getOperands()) {
		
		State regionAltState = lfContext.createTargetState("region_alt#" + iFragment.getName());
		
		Constraint regionGuard = iFragment.getGuard();
		
		Transition entryAltFirst = lfContext.createTransition(
				"tr_alt_first#" + iFragment.getName(), sourceAltStates, regionAltState);
		UmlFactory.setGuard(entryAltFirst, regionGuard);

		Transition entryAltNotFirst = lfContext.createTransition(
				"tr_alt_not_first#" + iFragment.getName(), sourceAltStates, regionAltState);
		UmlFactory.setGuard(entryAltNotFirst, regionGuard);

		lfContext.currentState = regionAltState;
		StatemachineContext altContext = new StatemachineContext(lfContext, element);
		
		transformInteractionOperand(iFragment, altContext);
		
		Transition exitRegionAlt = lfContext.createTransition(
				"tr_alt_quit#" + iFragment.getName(), regionAltState, exitAltState);
	}
	
	lfContext.currentState = exitAltState;


}


//////////////////////////////////////Transform Strict Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

public void transformCombinedFragmentStrict(CombinedFragment element,
StatemachineContext lfContext) {

	lfContext.currentState.setName("StrictFragment#" + element.getName());
	State exitStrictState = lfContext.createTargetState("exit_strict#" + element.getName());
	
	State regionStrictState = lfContext.createTargetState("target_strict#" + element.getName());
	for( InteractionOperand iFragment : element.getOperands()) {
		
			Constraint regionGuard = iFragment.getGuard();
			Transition entryStrict = lfContext.createTransition(
					"tr_strict_region#" + iFragment.getName(), lfContext.currentState, regionStrictState);
			UmlFactory.setGuard(entryStrict, regionGuard);
			StatemachineContext strictContext = new StatemachineContext(lfContext, element);
			
			transformInteractionOperand(iFragment, strictContext);
			
		}
		
	Transition exitStrict = lfContext.createTransition(
			"tr_strict_quit#" + element.getName(), regionStrictState, exitStrictState);
		lfContext.currentState = exitStrictState;


}




//////////////////////////////////////Transform Opt Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

public void transformCombinedFragmentOpt(CombinedFragment element,
		StatemachineContext lfContext) {

	State optState = lfContext.createTargetState("opt#" + element.getName());

	Transition entryOpt = lfContext.createTransition(
			"tr_opt_first", lfContext.currentState, optState);
	////TODO Add effect behavior

	entryOpt= lfContext.createTransition(
			"tr_opt_not_first", lfContext.currentState, optState);
	////TODO Add effect behavior

	lfContext.currentState = optState;
	//
	//
	StatemachineContext optContext = new StatemachineContext(lfContext, element);
	for( InteractionOperand iFragment : element.getOperands()) {
		transformInteractionOperand(iFragment, optContext);
	}

}




	/**
	 * performTransform a ExecutionOccurrence element to a writer
	 * @param element
	 */
//	public void transformExecutionOccurrenceSpecification(
//			ExecutionOccurrenceSpecification element, StatemachineContext lfContext) {
		//
//	}

	
	/**
	 * performTransform a Lifeline element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformLifeline(Lifeline element,
			StatemachineContext lfContext, PrettyPrintWriter writer) {
		
		if( lfContext == null ) {
			lfContext = new StatemachineContext(element);
		}
		
		transformLifeline(element, lfContext);
		
		lfContext.toWriter(fSupervisor.fStatemachineFactory, writer);
	}

	public void transformLifeline(Lifeline element,
			StatemachineContext lfContext) {
		
		if( lfContext == null ) {
			lfContext = new StatemachineContext(element);
		}
		
		Interaction interaction = element.getInteraction();
		
		if( interaction != null ) {
			for (InteractionFragment itFrag : interaction.getFragments()) {
				if( itFrag.getCovereds().contains(element) ) {
					// TODO lfContext.isLastFragmentTransformation ???
					lfContext.isLastFragmentTransformation = false;
					transformFragment(itFrag, lfContext);
				}
			}
		}
	}


	

	/**
	 * performTransform a BehaviorExecutionSpecification element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformBehaviorExecutionSpecification(
			BehaviorExecutionSpecification element,
			StatemachineContext lfContext) {
	
		BehaviorExecutionSpecification act = (BehaviorExecutionSpecification) element;
		State targetState = lfContext.createTargetState("targetBhExec#" + element.getName());
		lfContext.currentState.setName("BhExec#" + element.getName());
		Transition BH_tr= lfContext.createTransition(
				act.getName(), lfContext.currentState, targetState);
		lfContext.currentState = targetState;
		//String effect = act.getBehavior().toString().concat(";");
		
		UmlFactory.addOpaqueBehaviorEffect(BH_tr, act.getBehavior());
	}
	
	
	
	/**
	 * performTransform a MessageOccurrenceSpecification element to a writer
	 * @param element
	 * @param writer
	 */	
	public void transformMessageOccurrenceSpecification(
			MessageOccurrenceSpecification element,
			StatemachineContext lfContext) {
		
		
		lfContext.currentState.setName("MsgOcc#" + element.getName());
		State targetState = lfContext.createTargetState("targetMsgOcc#" + element.getName());
		Transition MsgOcc_tr= lfContext.createTransition(
				element.getName(), lfContext.currentState, targetState);
			
		Message message = element.getMessage();
		if( element.isReceive() ){

			StringBuffer MsgReceiveAction = new StringBuffer("input ");
			lfContext.inputMessage.add(message);

			MsgReceiveAction
				.append(message.getReceiveEvent().getLabel());//.getSignature().getLabel() )
			if (! (message.getArguments().isEmpty()) ){
				boolean isnotFirst = false;

				MsgReceiveAction.append("(");
				
				for (ValueSpecification itArg : message.getArguments()) {
					if( isnotFirst ) {
						MsgReceiveAction.append(", ");
					}
					else {
						isnotFirst = true;
					}
					MsgReceiveAction.append(itArg.stringValue());
				}
				MsgReceiveAction.append(" )");	
			}
			MsgReceiveAction.append(";");	
			UmlFactory.addOpaqueBehaviorEffect(MsgOcc_tr, MsgReceiveAction.toString());
			
		}
		else if( element.isSend() ) {

			StringBuffer MsgReceiveAction = new StringBuffer("output ");
			lfContext.outputMessage.add(message);
			
			MsgReceiveAction.append(message.getSignature().getLabel() );
			
			if (! (message.getArguments().isEmpty()) ){
				MsgReceiveAction.append("(");

				boolean isnotFirst = false;
				
				for (ValueSpecification itArg : message.getArguments()) {
					if( isnotFirst ) {
						MsgReceiveAction.append(", ");
					}
					else {
						isnotFirst = true;
					}
					MsgReceiveAction.append(itArg.stringValue());
				}
				MsgReceiveAction.append(" )");	
			}
			
			MsgReceiveAction.append(" to ");
			
			
			if (message.getReceiveEvent() instanceof MessageOccurrenceSpecification){
				
				MessageOccurrenceSpecification target = (MessageOccurrenceSpecification) message.getReceiveEvent();
				
				MsgReceiveAction.append(target.getCovered().getName());
			}
			
			if (message.getReceiveEvent() instanceof Gate){
							
				//Gate target = (Gate) message.getReceiveEvent();
				
				MsgReceiveAction.append("env");
			}
			MsgReceiveAction.append(";");

			UmlFactory.addOpaqueBehaviorEffect(MsgOcc_tr, MsgReceiveAction.toString());
	   }
		lfContext.currentState = targetState;
	}
	
	
	
	/**
	 * performTransform a Message element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformMessage(Message element,
			StatemachineContext lfContext,  PrettyPrintWriter writer) {
		writer.appendTab("Message ")
			.appendEol(" {");


		writer.appendTab("} // end Message ")
			.appendEol2(element.getName());
	}

	
//	/**
//	 * performTransform a Region List element to a writer
//	 * @param listOfRegion
//	 * @param writer
//	 */
//	private void transformGate(Gate element,
//			StatemachineContext lfContext, PrettyPrintWriter writer) {
//		
//		writer.appendTab("Gate ")
//		.append(element.getName())
//		.appendEol(" {");
//		
//		writer.appendTab("} // end Gate ")
//		.appendEol2(element.getName());
//	}


//	private void transformPartDecomposition(PartDecomposition element,
//			StatemachineContext lfContext, PrettyPrintWriter writer) {
//		writer.appendTab("PartDecomposition ")
//			.append(element.getName())
//			.appendEol(" {");
//
//	writer.appendTab("} // end PartDecomposition ")
//		.appendEol2(element.getName());
//	}

}
