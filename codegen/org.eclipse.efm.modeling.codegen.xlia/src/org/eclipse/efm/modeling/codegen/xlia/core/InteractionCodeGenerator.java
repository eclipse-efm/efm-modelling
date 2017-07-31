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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.TimeObservation;
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

	
	
	
	public void declareSignalMessageType(Signal signal, PrettyPrintWriter writer) {
	    writer.appendTab2("type ")
	        .append(signal.getName())
	        .appendEol(" struct {");
	    
	    for (Property property : signal.getAllAttributes()) {
	        writer.appendTab3("var ")
	            .append( fSupervisor.fDataTypeFactory.typeName(property) )
	            .append(" ")
	            .append(property.getName())
	            .appendEol(";");
	    }

		writer.appendTab2Eol("};");
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
			
			Map<NamedElement, Boolean> declaredSignatures = new HashMap<NamedElement, Boolean>();
			writer.appendEol("@property: ");
			writer.appendTabEol("// message");
			for( Message message : element.getMessages() ) {
				//declare signal structure
				NamedElement signature = message.getSignature();
				if( (signature instanceof Signal) && (declaredSignatures.get(signature) == null) ) {					
					declaredSignatures.put(signature, Boolean.TRUE);

					if( ! ((Signal) signature).getAllAttributes().isEmpty() ) {
						declareSignalMessageType((Signal) signature, writer);
					}
				}
				// declare message
				writer.appendTab2("message ")
					.append(message.getName());
				
				if( (signature instanceof Signal)
					&& (! ((Signal) signature).getAllAttributes().isEmpty()) ) {
					writer.append("( " )
						.append(signature.getName())
						.append(" )");
				}
				
				writer.appendEol(";");
				
				// declare input message occurrence variables (signature instance)
//				writer.appendTab2(signature.getName())
//				.append(" ")
//				.append(message.getName())
//				.append("#in");
//				writer.appendEol(";");
				
			}
			writer.appendTabEol("// end message");
			
			// Extra element needed to respect model semantic
		//	for( Lifeline lifeline : element.getLifelines() ) {
		//		writer.appendTab2("var fifo<integer , 30> " )
//					.append( "sched_").append(lifeline.getName())
//					.appendEol(";");
//			
//			}
//			
//			//
//			for( Lifeline lifeline : element.getLifelines() ) {
//				writer.appendTab2("var fifo<integer , *> " )
//					.append( "fifo_").append(lifeline.getName())
//					.appendEol(";");
//			}
			
			
			writer.appendEol("@composite: ");
			PrettyPrintWriter writer2 = writer.itab2();
			
			lfContext = new StatemachineContext(element);

			for( Lifeline lifeline : element.getLifelines() ) {
				
				transformLifeline(lifeline, new StatemachineContext(lfContext, lifeline), writer2);
			}
			
			writer.appendTab("} // end Interaction ")
				.appendEol2(element.getName());
		}
		else {
			lfContext.initializeConstraintMap(element);

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

 // transform data constraint
	public void transformElementConstraints(
			Element element, Transition transition, StatemachineContext lfContext) {
			
		List<Constraint> constraints = lfContext.getElementConstraints(element);
		if( constraints != null ) {
			for (Constraint constraint : constraints) {
				UmlFactory.setGuard(transition, constraint);
			};
		}
	}
	

	// transform timed constraint
		public void transformElementTimedConstraints(
				Element element, Transition transition, StatemachineContext lfContext) {
				
			List<Constraint> constraints = lfContext.getElementConstraints(element);
			if( constraints != null ) {
				for (Constraint constraint : constraints) {
					UmlFactory.setGuard(transition, constraint);
				};
			}
		}
		
	// transform TimeObservation
	public void transformElementTimeObservation(
			NamedElement element, Transition transition, StatemachineContext lfContext) {
			
		List<TimeObservation> timeObservations = lfContext.getTimeObservation(element);
		if( timeObservations != null ) {
			for (TimeObservation tObs : timeObservations) {
//				UmlFactory.setGuard(transition, tObs);
			};
		}
	}
	

	/**
	 * performTransform a InteractionOperand element
	 * @param element
	 * @param writer
	 */
	private void transformInteractionOperand(InteractionOperand element,
			StatemachineContext lfContext) {
		
		ArrayList<InteractionFragment> fragmentList = new ArrayList<InteractionFragment>();
		
		for( InteractionFragment iFragment : element.getFragments() ) {
			if (iFragment.getCovereds().contains(lfContext.coveredLifeline)) {
				fragmentList.add(iFragment);
			}
		}
		
		if( fragmentList.isEmpty() ) {
			lfContext.performNoCoveredFragment();
		}
		else {
			lfContext.isLastFragmentTransformation = false;
			
			for( InteractionFragment iFragment : fragmentList ){ //element.getFragments() ) {
				
				if (fragmentList.indexOf(iFragment) == fragmentList.size()-1 ) {
					// lfContext.isLastFragmentTransformation 
					lfContext.isLastFragmentTransformation = true;
				}
				transformFragment(iFragment, lfContext);
			}
			
			//Transition tr_final = lfContext.createTransition(
			//		"tr_final", lfContext.currentState, lfContext.finalState);
		}
	}

	/**
	 * performTransform a CombinedFragment element
	 * @param element
	 * @param writer
	 */
	public void transformCombinedFragment(CombinedFragment element,
			StatemachineContext lfContext) {
		
		switch (element.getInteractionOperator()) {
		case LOOP_LITERAL:
			transformCombinedFragmentLoop(element, lfContext);
			break;

		case ALT_LITERAL:
			transformCombinedFragmentAlt(element, lfContext);
			break;

		case OPT_LITERAL:
			transformCombinedFragmentOpt(element, lfContext);
			break;

		case SEQ_LITERAL:
			transformCombinedFragmentSequence(element, lfContext);
			break;

		case STRICT_LITERAL:
			transformCombinedFragmentStrict(element, lfContext);
			break;

		case PAR_LITERAL:
			transformCombinedFragmentParallel(element, lfContext);
			break;

		default:
			break;
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

	
	
////////////////////////////////////// Transform Alt Fragment //////////////////////////////
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


//////////////////////////////////////Transform Sequence Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
// TODO
public void transformCombinedFragmentSequence(
		CombinedFragment element, StatemachineContext lfContext) {

	lfContext.currentState.setName("SeqFragment#" + element.getName());
	State exitSeqState = lfContext.createTargetState("exit_seq#" + element.getName());

	State regionSeqState = lfContext.createTargetState("target_seq#" + element.getName());
	for( InteractionOperand iFragment : element.getOperands()) {

		Constraint regionGuard = iFragment.getGuard();

		Transition entrySeq = lfContext.createTransition(
				"tr_seq_region#" + iFragment.getName(), lfContext.currentState, regionSeqState);
		//	UmlFactory.setGuard(entryStrict, regionGuard);			

		StatemachineContext seqContext = new StatemachineContext(lfContext, iFragment);

		transformInteractionOperand(iFragment, seqContext);

	}

	Transition exitSeq = lfContext.createTransition(
			"tr_seq_quit#" + element.getName(), lfContext.currentState, exitSeqState);
	lfContext.currentState = exitSeqState;
}


//////////////////////////////////////Transform Strict Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

public void transformCombinedFragmentStrict(
		CombinedFragment element, StatemachineContext lfContext) {

	lfContext.currentState.setName("StrictFragment#" + element.getName());
	
	State elseStrictState = null;
	Transition elseStrictTransition = null;
	State operandStrictState = null;

	for( InteractionOperand iFragment : element.getOperands()) {

		if( elseStrictState != null ) {
			elseStrictState.setName("strict#" + iFragment.getName());
			operandStrictState = elseStrictState;
			elseStrictState = null;
		}
		else {
			operandStrictState = lfContext.createNewState("strict#" + iFragment.getName());
		}
		Transition operandStrictTransition = lfContext.createTransition(
				"tr_strict_region#" + iFragment.getName(), lfContext.currentState, operandStrictState);
		
		Constraint regionGuard = iFragment.getGuard();
		if( regionGuard != null ) {
			UmlFactory.setGuard(operandStrictTransition, regionGuard);
			
			// previous else transition
			if( elseStrictTransition != null ) {
				UmlFactory.setGuard(elseStrictTransition, regionGuard);
				
			}
			
			elseStrictState = lfContext.createNewState("else_strict#" + iFragment.getName());
			
			elseStrictTransition = lfContext.createTransition(
					"tr_else_strict_region#" + iFragment.getName(), lfContext.currentState, elseStrictState);
		}
			
		lfContext.currentState = operandStrictState;

		StatemachineContext strictContext = new StatemachineContext(lfContext, iFragment);

		transformInteractionOperand(iFragment, strictContext);
	}

	if( elseStrictState != null ) {
		elseStrictState.setName("exit_strict#" + element.getName());
	}
	else {
		elseStrictState = lfContext.createTargetState("exit_strict#" + element.getName());
	}
	Transition exitStrict = lfContext.createTransition(
			"tr_strict_quit#" + element.getName(), lfContext.currentState, elseStrictState);
	lfContext.currentState = elseStrictState;
}


//////////////////////////////////////Transform Parallel Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
//TODO

public void transformCombinedFragmentParallel(
		CombinedFragment element, StatemachineContext lfContext) {

	lfContext.currentState.setName("ParFragment#" + element.getName());
	State exitParState = lfContext.createTargetState("exit_par#" + element.getName());

	State regionStrictState = lfContext.createTargetState("target_par#" + element.getName());
	for( InteractionOperand iFragment : element.getOperands()) {

		Constraint regionGuard = iFragment.getGuard();
		//	Transition entryStrict = lfContext.createTransition(
		//			"tr_strict_region#" + iFragment.getName(), lfContext.currentState, regionStrictState);
		//	UmlFactory.setGuard(entryStrict, regionGuard);			

		StatemachineContext parContext = new StatemachineContext(lfContext, iFragment);

		transformInteractionOperand(iFragment, parContext);

	}

	Transition exitPar = lfContext.createTransition(
			"tr_par_quit#" + element.getName(), lfContext.currentState, exitParState);
	lfContext.currentState = exitParState;


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
		
		lfContext.toWriter(fSupervisor, writer);
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
		
		transformElementConstraints(element.getStart(), BH_tr, lfContext);
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
				"tr_" + element.getName(), lfContext.currentState, targetState);
			
//		Message message = element.getMessage();
//		if( element.isReceive() ){
//
//			StringBuffer MsgReceiveAction = new StringBuffer("input ");
//			lfContext.inputMessage.add(message);
//
//			MsgReceiveAction.append( message.getName() );//.getSignature().getLabel() )
////			if (! (message.getArguments().isEmpty()) ){
//				boolean isnotFirst = false;
//
//				MsgReceiveAction.append("( { ");
//				
//				if( message.getSignature() instanceof Signal ) {	
//					Signal signal = (Signal) message.getSignature();
//					
//					final String paramPrefix = message.getName() + "#in.";
//					
//					for (Property property : signal.getAllAttributes()) {
//												
//						if( isnotFirst ) {
//							MsgReceiveAction.append(" , ");
//						}
//						else {
//							isnotFirst = true;
//						}
//						MsgReceiveAction.append( paramPrefix)
//							.append(property.getName());
//					}
//
//				}
		
		
		
		Message message = element.getMessage();
		if( element.isReceive() ){

		    StringBuffer MsgReceiveAction = new StringBuffer("input ");
		    lfContext.inputMessage.add(message);

		    MsgReceiveAction.append( message.getName() );
		    if (! (message.getArguments().isEmpty()) ){
		        
		        NamedElement signature = message.getSignature();
		        if( signature instanceof Signal ) {                    
		            lfContext.addLocalVariable(message.getName() + "#params", (Signal) signature);
		        }
		        
		        MsgReceiveAction.append("( ")
		            .append( message.getName() )
		            .append( "#params" );


				//TO DELETE
				//	for (ValueSpecification itArg : message.getArguments()) {
				//	if( isnotFirst ) {
				//	MsgReceiveAction.append(" , ");
				//	}
				//	else {
				//	isnotFirst = true;
				//	}
				//	MsgReceiveAction.append(itArg.stringValue());
				//	}
				
				MsgReceiveAction.append(" )");	
			}
			MsgReceiveAction.append(";");	
			UmlFactory.addOpaqueBehaviorEffect(MsgOcc_tr, MsgReceiveAction.toString());
			
		}
		else if( element.isSend() ) {

			StringBuffer MsgReceiveAction = new StringBuffer("output ");
			lfContext.outputMessage.add(message);
			
			MsgReceiveAction.append( message.getName() );
			
			if (! (message.getArguments().isEmpty()) ){
				MsgReceiveAction.append("( { ");

				boolean isnotFirst = false;
				
				for (ValueSpecification itArg : message.getArguments()) {
					if( isnotFirst ) {
						MsgReceiveAction.append(" , ");
					}
					else {
						isnotFirst = true;
					}
					MsgReceiveAction.append(itArg.stringValue());
				}
				MsgReceiveAction.append(" } )");	
			}
			
			MsgReceiveAction.append(" --> ");
			
			
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
