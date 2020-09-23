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
package org.eclipse.efm.modeling.codegen.xlia.interaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.efm.modeling.codegen.xlia.core.AbstractCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.core.ClassCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.core.MainCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.datatype.DataTypeFactory;

//import org.eclipse.efm.modeling.codegen.xlia.core.DataTypeCodeGenerator;

import org.eclipse.efm.modeling.codegen.xlia.util.PrettyPrintWriter;
import org.eclipse.efm.modeling.codegen.xlia.util.StatemachineContext;
import org.eclipse.efm.modeling.codegen.xlia.util.StatemachineContext.CONTEXT;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.ValueSpecification;

//import com.cea.aide.core.factory.Creator;
//import com.cea.aide.core.form.Verbatim;


public class InteractionCodeGenerator extends AbstractCodeGenerator
		implements NameHelper, InteractionHelper, TimeObservationHelper {

	private static final String PACKAGE_NAME_INFERENCE_UTILS = "InferenceUtils";

	HashMap<OccurrenceSpecification, TimeObservation> fMapOfOccSpecTimeObs;

	/**
	 * Constructor
	 */
	public InteractionCodeGenerator(final MainCodeGenerator supervisor) {
		super(supervisor);

		fMapOfOccSpecTimeObs = new HashMap<OccurrenceSpecification, TimeObservation>();
	}


	/**
	 * performTransform dispatcher for any element to a writer
	 * @param element
	 * @param writer
	 */
	public void performTransformImpl(final Element element, final PrettyPrintWriter writer) {
		if( element instanceof Interaction ) {
			transformInteraction((Interaction)element, writer);
		}

		else if( element instanceof Lifeline ) {
			transformLifeline((Lifeline)element, writer);
		}

		else if( element instanceof InteractionFragment )
		{
			if( element instanceof InteractionOperand ) {
				transformFragment((InteractionOperand)element, writer);
			}

			else if( element instanceof CombinedFragment ) {
				transformFragment((CombinedFragment)element, writer);
			}

//			else if( element instanceof ExecutionSpecification )
//			{
				if( element instanceof BehaviorExecutionSpecification ) {
					transformFragment(
							(BehaviorExecutionSpecification)element, writer);
				}
//			}

//			else if( element instanceof OccurrenceSpecification )
//			{
				if( element instanceof MessageOccurrenceSpecification ) {
					transformFragment(
							(MessageOccurrenceSpecification)element, writer);
				}
//			}
		}

		else if( element instanceof Message ) {
			transformMessage((Message)element, null, writer);
		}

		else {
			performTransformError(this, element);
		}
	}




	public void declareSignalMessageType(final Signal signal, final PrettyPrintWriter writer) {
	    if( signal.getAllAttributes().isEmpty() ) {
	    	writer.appendTab2("type ")
		    	.append(signal.getName())
		    	.append(" ")
		    	.append( messagesSignatureEnumTypeName() )
		    	.appendEol( ";" );
	    }
	    else {
	    	writer.appendTab2("type ")
		    	.append(signal.getName())
		    	.appendEol(" struct {")
		    	.appendTab3("var ")
		    	.append( messagesSignatureEnumTypeName() )
		    	.appendEol( " signature;" );

	    	for (final Property property : signal.getAllAttributes()) {
	    		writer.appendTab3("var ")
		    		.append( fSupervisor.fDataTypeFactory.typeName(property) )
		    		.append(" ")
		    		.append(property.getName())
		    		.appendEol(";");
	    	}

	    	writer.appendTab2Eol("}");
	    }
	}


	/**
	 * Lifeline Projection of dedicated Fragment Util
	 * @param lifeline
	 * @param fragments
	 * @return
	 */
	private ArrayList<InteractionFragment> coveredFragments(
			final Lifeline lifeline, final List<InteractionFragment> fragments) {
		final ArrayList<InteractionFragment> coveredFragmentList = new ArrayList<InteractionFragment>();

		for( final InteractionFragment iFragment : fragments ) {
			if (iFragment.getCovereds().contains(lifeline)) {
				if( !( iFragment instanceof ExecutionOccurrenceSpecification) ) {
					coveredFragmentList.add(iFragment);
				}
			}
		}

		return coveredFragmentList;
	}


	/**
	 * performTransform an Interaction element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformInteraction(final Interaction element, final Collection<Lifeline> lifelines,
			final StatemachineContext lfContext, final PrettyPrintWriter writer) {

		fillMapOfTimedObservation(element, fMapOfOccSpecTimeObs);

		final boolean isInferenceContext =
				fSupervisor.fClassFactory.hasPackage(element.getModel(), PACKAGE_NAME_INFERENCE_UTILS);

		writer.appendTabEol2(ClassCodeGenerator.XLIA_SYSTEM_1_0);

		final String modifier = ( fMapOfOccSpecTimeObs.isEmpty() ? "" : "timed#dense " );

		writer.appendTab(modifier)
			.append("system< and > ")
			.append(element.getName())
			.appendEol(" {");




		final ArrayList<DataType> datatypes = new ArrayList<DataType>();
		final ArrayList<Signal> signals = new ArrayList<Signal>();
		fSupervisor.fClassFactory.collectGlobalElement(element, datatypes, signals);

		final PrettyPrintWriter writer2 = writer.itab2();

		final Map<NamedElement, Boolean> declaredSignatures = new HashMap<NamedElement, Boolean>();
		writer.appendEol("@property: ");
		writer.appendTabEol2("// GLOBAL DECLARATIONS");

		for (final DataType datatype : datatypes) {
			fSupervisor.fDataTypeFactory.performTransformImpl(datatype, writer2);
		}

		//If inference Context
		writer.appendTab2Eol("//Declarations for the formal inference module");
		if(isInferenceContext){
			//function signatures vector
			writer.appendTab2Eol("// Function signatures vector");

			writer.appendTab2Eol("public var vector<FonctionSignature> AllSignatures = {");
			for( final Lifeline lifeline : lifelines ) {
				final ConnectableElement representedClass = lifeline.getRepresents();
				if( representedClass instanceof Property ) {
					final Class clazz = (Class) (((Property)representedClass).getType());

					for (int j = 0; j < clazz.getOperations().size(); j++ ) {
						final Operation operation = clazz.getOperations().get(j);
						writer.appendTab3("{ \"").append(operation.getName()).append("\" , \"")
						.append(fSupervisor.fDataTypeFactory.typeName( operation.getReturnResult().getType()))
						.append(" ").append(operation.getName()).append("(");

						for(int i = 0; i < operation.getOwnedParameters().size()-1; i++){
							final Parameter param = operation.getOwnedParameters().get(i);
							writer.append( fSupervisor.fDataTypeFactory.typeName(param.getType()) //param.getType().getName() //
									).append(" ").append(param.getName());
							if(i < operation.getOwnedParameters().size()-2 ){
								writer.append(", ");
							}
						}

						writer.append(")\" }");
						if(j < clazz.getOperations().size()-1 ){
							writer.appendEol(", ");
						}
					}
				}
			}

			writer.appendTab2Eol("};");
			writer.appendTab2Eol2("// end Function signatures vector");

			//function calls vectors
			writer.appendTab2Eol("// function calls vectors");

			writer.appendTab2Eol("var integer callIndex = -1;");
			writer.appendTab2Eol("public var vector<CallData> AllCallsStack;");
			writer.appendTab2Eol("public var CallData currentCall;");

			writer.appendTab2Eol("public var vector EMPTY_VECTOR;");
			writer.appendTab2Eol("public const CallData EMPTY_CALL = { \"\" , \"\" , EMPTY_VECTOR , \"\" , \"\" };");

			writer.appendTab2Eol2("// end function calls vectors");
		}
		writer.appendTab2Eol2("//end Declarations for the formal inference module");

		writer.appendTab2Eol("//  Interaction diagram elements ");
		writer.appendTab2Eol("//  TypeEnum declarations for Combined Fragment region's scheduling");

		final List< CombinedFragment > combinedFragments = listOfCombinedFragment(element);
		for(final InteractionFragment fragment : combinedFragments ) {
			if(fragment instanceof CombinedFragment){
				final CombinedFragment combinedFragment = (CombinedFragment) fragment;

				writer.appendTab2("type ")
					.append(nameOfEnumRegionsType(combinedFragment))
					.appendEol(" enum { " );
				for( final InteractionOperand iFragment : combinedFragment.getOperands() ) {
					writer.appendTab3(nameOfEnumLiteralRegion(iFragment))
					.appendEol(",");
				}
				writer.appendTab3(nameOfEnumLiteralRegionOUT(combinedFragment))
				.appendEol();
				writer.appendTab2Eol("}");

			}
		}
		writer.appendTab2Eol2("// end TypeEnum declarations for Combined Fragment region's scheduling");



		writer.appendTab2Eol("// Interaction messages declaration");

		writer.appendTab2("type ")
			.append( messagesSignatureEnumTypeName() )
			.appendEol(" enum {");
		boolean isnotFirst = false;
		for(  final Message message : element.getMessages() ) {
			if( isnotFirst ) {
				writer.appendEol( ", " );
			}
			else {
				isnotFirst = true;
			}
			writer.appendTab3( nameOfMessageSignature(message) );
		}
		writer.appendEol()
			.appendTab2Eol("}");

		for( final Message message : element.getMessages() ) {
			//declare signal structure
			final NamedElement signature = message.getSignature();
			if( (signature instanceof Signal) && (declaredSignatures.get(signature) == null) ) {
				declaredSignatures.put(signature, Boolean.TRUE);

				declareSignalMessageType((Signal) signature, writer);
			}
			// declare message
			//writer.appendTab2("message ") // TODO modif until Diversity support
			writer.appendTab2("signal ")
				.append(message.getName());

			if( signature instanceof Signal ) {
				writer.append("( " )
					.append(signature.getName())
					.append(" )");
			}

			writer.appendEol(";");
		}
		writer.appendTab2Eol2("// end Interaction messages declaration");



		// Interaction TimeObservations declaration
		declareTimeObsVariables(element.getModel(), writer);

		writer.appendTab2Eol2("// end Interaction diagram elements");



		writer.appendEol("@composite: ");

		for( final Lifeline alifeline : lifelines ) {

			transformWriteLifeline(alifeline, lfContext, writer2);
		}


		if( isInferenceContext ) {
			// Section moe
			//
			writer.appendEolTab_Eol("@moe:");
			// Section irun

			writer.appendTab2Eol("@irun{");
			writer.appendTab3Eol("currentCall = EMPTY_CALL;");
			writer.appendTab2Eol2("}");
		}

		//route fifo | env messages

		final String routeProtocol = (lifelines.size() < 2) ? "env" : "fifo";

		writer.appendEol("@com: ");
		writer.appendTabEol("// route: message fifo");
		for( final Message message : element.getMessages() ) {
			//declare message fifo
			if(message.getSendEvent() instanceof Gate){
				writer.appendTab2("route<")
				.append("env");
			}
			else
			{
			writer.appendTab2("route<")
				.append(routeProtocol);
			}
			writer.append("> [ ")
				.append(message.getName());

			writer.appendEol("];");

		}
		writer.appendTabEol("// end route");


		writer.appendTab("} // end Interaction ")
			.appendEol2(element.getName());

//!@?DERADCODE: TO DELETE
//	if( lfContext == null ) {
//	}
//	else {
//		lfContext.initializeConstraintMap(element);
//
//		// A writer indenting with TAB + iTAB -> TAB2
//		PrettyPrintWriter writer2 = writer.itab2();
//
//		writer2.appendTab("////////////////////////////////////////////////////////////////////////////// Lifeline ")
//			.append(lfContext.coveredLifeline.getName())
//			.appendEol(" //////////////////////////////////////////////////////////////////////////////");
//
//		ArrayList<InteractionFragment> coveredFragmentList =
//				coveredFragments(lfContext.coveredLifeline, element.getFragments());
//
//		lfContext.isLastFragmentTransformation = false;
//		int coveredFragmentListCount = coveredFragmentList.size()-1;
//		for( InteractionFragment iFragment : coveredFragmentList ) {
//			if(coveredFragmentList.indexOf(iFragment) == coveredFragmentListCount){
//				//Transition tr_final = lfContext.createTransition(
//				//"tr_final", lfContext.currentState, lfContext.finalState);
//				lfContext.isLastFragmentTransformation = true;
//
////					lfContext.currentState = lfContext.finalState;
//			}
//
//			transformFragment(iFragment, lfContext, writer2);
//		}
//
//		//TODO DELETE Transition tr_final
////			Transition tr_final = lfContext.createTransition(
////					"tr_final", lfContext.currentState, lfContext.finalState);
//	}

//		writer.appendEol("****************************** TEST XLIA MODEL ******************************");
//		fSupervisor.xliaModel.performTransform(writer);
//		writer.appendEol("****************************** TEST XLIA MODEL ******************************");

	}


//	public String typeName(Type element) {
//		String typeString = element.getName();
//
//		if( element instanceof PrimitiveType ) {
//			typeString = typeString.toLowerCase();
//		}
//		else if( element instanceof Class ){
//			typeString = "machine" + "/*< " + typeString + " >*/";
//		}
//
//		return typeString;
//	}
//


	public void transformInteraction(final Interaction element,  final PrettyPrintWriter writer)
	{
		final StatemachineContext lfContext = new StatemachineContext(element, CONTEXT.INTERACTION);

		transformInteraction(element, element.getLifelines(), lfContext, writer);
	}


	/**
	 * performTransform a Fragment element to a writer
	 * @param element
	 * @param writer
	 */

	private void transformFragment(final InteractionFragment element, final PrettyPrintWriter writer)
	{
		for (final Lifeline lifeline : element.getCovereds()) {
			final StatemachineContext lfContext = new StatemachineContext(lifeline);

			transformFragment(element, lfContext);

			lfContext.toWriter(fSupervisor.fStatemachineFactory, writer);
		}
	}

	private void transformFragment(final InteractionFragment iFragment,
			final StatemachineContext lfContext) {
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

		else if( iFragment instanceof ExecutionOccurrenceSpecification ) {
			transformExecutionOccurrenceSpecification(
					(ExecutionOccurrenceSpecification)iFragment, lfContext);
		}

		else {
			performTransformError(this, iFragment);
		}
	}


 // transform data constraint
	public void transformElementConstraints(
			final Element element, final Transition transition, final StatemachineContext lfContext) {

		final List<Constraint> constraints = lfContext.getElementConstraints(element);
		if( constraints != null ) {
			for (final Constraint constraint : constraints) {
				addEffectGuard(lfContext, element ,transition, constraint);
			}
		}
	}


//!UNUSED!
//	// transform timed constraint
//		public void transformElementTimedConstraints(
//				Element element, Transition transition, StatemachineContext lfContext) {
//
//			List<Constraint> constraints = lfContext.getElementConstraints(element);
//			if( constraints != null ) {
//				for (Constraint constraint : constraints) {
//					TransitionHelper.setGuard(transition, constraint);
//				};
//			}
//		}
//
//	// transform TimeObservation
//	public void transformElementTimeObservation(
//			NamedElement element, Transition transition, StatemachineContext lfContext) {
//
//		List<TimeObservation> timeObservations = lfContext.getTimeObservation(element);
//		if( timeObservations != null ) {
//			for (TimeObservation tObs : timeObservations) {
////				TransitionHelper.setGuard(transition, tObs);
//			};
//		}
//	}


	/**
	 * performTransform a InteractionOperand element
	 * @param element
	 * @param writer
	 */
	private void transformInteractionOperand(final InteractionOperand element,
			final StatemachineContext lfContext) {

		lfContext.initialState.setName("init#" + element.getName());
		lfContext.finalState.setName("final#" + element.getName());

		final ArrayList<InteractionFragment> coveredFragmentList =
				coveredFragments(lfContext.coveredLifeline, element.getFragments());

		if( coveredFragmentList.isEmpty() ) {
			lfContext.performNoCoveredFragment();
		}
		else {
			lfContext.isLastFragmentTransformation = false;

			final InteractionFragment lastFragment =
					coveredFragmentList.get( coveredFragmentList.size() - 1 );

			for( final InteractionFragment itFragment : coveredFragmentList ) {
				if( itFragment == lastFragment ) {
					lfContext.isLastFragmentTransformation = true;

//					lfContext.currentState = lfContext.finalState;
				}
				transformFragment(itFragment, lfContext);
			}

//			Transition tr_final = lfContext.createTransition(
//					"tr_final", lfContext.currentState, lfContext.finalState);
		}
	}

	/**
	 * performTransform a CombinedFragment element
	 * @param element
	 * @param writer
	 */
	public void transformCombinedFragment(final CombinedFragment element,
			final StatemachineContext lfContext) {

		switch (element.getInteractionOperator()) {
		case LOOP_LITERAL:
			transformCombinedFragmentLoop(element, lfContext);
			break;

		case ALT_LITERAL:
			transformCombinedFragmentGeneric(element, lfContext);
//			transformCombinedFragmentAlt(element, lfContext);
			break;

		case OPT_LITERAL:
			transformCombinedFragmentGeneric(element, lfContext);
//			transformCombinedFragmentOpt(element, lfContext);
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


	public void transformCombinedFragmentScheduling(final CombinedFragment element,
			final StatemachineContext lfContext, final ArrayList<State> regionStates) {

		// Choice State for Fragment State Entry Scheduling Region value as Guard
		final Pseudostate choiceNotFirstState = lfContext.createNewState(
				"choice#schedule#" + element.getName() + "#Region",
				PseudostateKind.CHOICE_LITERAL);

		Transition transition = lfContext.createElseTransition(
				"tr_not_first#" + element.getName(),
				lfContext.currentState, choiceNotFirstState);

		addOpaqueBehaviorEffect(transition,
				nameOfSchedulingVariable(element) + " >=> " +
				nameOfScheduledRegionVariable(element) + ";");

		final StringBuilder buffer = new StringBuilder();

		int offset = 0;
		State regionState;

		for( final InteractionOperand iFragment : element.getOperands()) {
			regionState = regionStates.get(offset++);

			transition = lfContext.createTransition(
					"tr_" + regionState.getName(),
					choiceNotFirstState, regionState);

			buffer.append( nameOfScheduledRegionVariable(element) )
				.append(" == ")
				.append( qualifiedNameOfEnumLiteralRegion(iFragment) );

			setGuard(transition, buffer.toString());

			buffer.delete(0, buffer.length());
		}

		regionState = regionStates.get(offset);
		transition = lfContext.createTransition(
				"tr_" + regionState.getName(),
				choiceNotFirstState, regionState);

		buffer.append(element.getName())
			.append("#current#schedule#region")
			.append(" == ")
			.append( qualifiedNameOfEnumLiteralRegionOUT(element) );

		setGuard(transition, buffer.toString());
	}


	public void transformCombinedFragmentGeneric(final CombinedFragment element,
			final StatemachineContext lfContext) {
		final String interactionOperator = element.getInteractionOperator().getLiteral();

		final StringBuilder buffer = new StringBuilder();

		boolean hasElseOrTrueGuard = false;

		// Unique Exit State
		final State exitState = lfContext.createExitState(
				"exit_" + interactionOperator + "#" + element.getName());

		// transformation Context
		final boolean isInteractionCtx = (element.getCovereds().size() >= 2)
				&& (lfContext.transfoCtx == CONTEXT.INTERACTION);

		// Variables need in Interaction Context
		Property regionScheduleVariable = null;
		Pseudostate choiceNotFirstState = null;

		// Choice State for Fragment State Entry Constraint as Guard
		final Pseudostate choiceFirstState = lfContext.createNewState(
				"choice#constraint#" + element.getName() + "#Region",
				PseudostateKind.CHOICE_LITERAL);

		Transition transition = lfContext.createTransition(
				nameOfEntryTransitionFragment(element,
						interactionOperator, isInteractionCtx),
				lfContext.currentState, choiceFirstState);

		// Transition for First Entry constraint i.e. no region in fifo scheduler
		if( isInteractionCtx ) {
			regionScheduleVariable = createCombinedRegionScheduleVariable(lfContext, element);

			final StringBuilder guard = new StringBuilder();
			guard.append("empty( ")
				.append(regionScheduleVariable.getName())
				.append(" )");

			setGuard(transition, guard.toString());

			// Choice State for Fragment State Entry Scheduling Region value as Guard
			choiceNotFirstState = lfContext.createNewState(
					"choice#schedule#" + element.getName() + "#Region",
					PseudostateKind.CHOICE_LITERAL);

			transition = lfContext.createElseTransition(
					"tr_not_first#" + element.getName(),
					lfContext.currentState, choiceNotFirstState);

			addOpaqueBehaviorEffect(transition,
					nameOfSchedulingVariable(element) + " >=> " +
					nameOfScheduledRegionVariable(element) + ";");

		}

		// InteractionOperand i.e. Region transformation
		for( final InteractionOperand iFragment : element.getOperands() ) {

			final State regionState = lfContext.createNewState(
					"region_" + interactionOperator + "#" + iFragment.getName());

			transition = lfContext.createTransition(
					nameOfEntryTransitionFragment(iFragment,
							interactionOperator, isInteractionCtx),
					choiceFirstState, regionState);

			setGuard(transition, iFragment.getGuard());

			hasElseOrTrueGuard = fSupervisor.isConstraintElseOrTrue(transition.getGuard());

			if( isInteractionCtx ) {
				// Set Scheduling for other LifeLine per Combined Fragment
				for( final Lifeline lf : element.getCovereds() ) {
					if( lf != lfContext.coveredLifeline ) {
						buffer.delete(0, buffer.length());

						buffer.append( qualifiedNameOf(lf) )
							.append( "." )
							.append( regionScheduleVariable.getName() )
							.append( " <=< " )
							.append( qualifiedNameOfEnumLiteralRegion(iFragment) )
							.append( ";" );

						addOpaqueBehaviorEffect(transition, buffer.toString());
					}
				}

				// Transition for Scheduling Region in not first case
				transition = lfContext.createTransition(
						"tr_" + regionState.getName(),
						choiceNotFirstState, regionState);

				buffer.delete(0, buffer.length());

				buffer.append( nameOfScheduledRegionVariable(element) )
					.append(" == ")
					.append( qualifiedNameOfEnumLiteralRegion(iFragment) );

				setGuard(transition, buffer.toString());
			}

			lfContext.currentState = regionState;

			final StatemachineContext regionContext = new StatemachineContext(lfContext, element);

			transformInteractionOperand(iFragment, regionContext);

			transition = lfContext.createFinalTransition(
					"tr_" + interactionOperator + "_quit#" + iFragment.getName(),
					regionState, exitState);
		}

		if( ! hasElseOrTrueGuard ) {
			transition = lfContext.createElseTransition(
					"tr_" + interactionOperator + "_else#" + element.getName(),
					choiceFirstState, exitState);

			if( isInteractionCtx ) {
				// Set Scheduling: entry none region
				for( final Lifeline lf : element.getCovereds() ) {
					if( lf != lfContext.coveredLifeline ) {
						buffer.delete(0, buffer.length());

						buffer.append( qualifiedNameOf(lf) )
							.append( "." )
							.append( regionScheduleVariable.getName() )
							.append( " <=< " )
							.append( qualifiedNameOfEnumLiteralRegionOUT(element) )
							.append( ";" );

						addOpaqueBehaviorEffect(transition, buffer.toString());
					}
				}
			}
		}

		if( isInteractionCtx && (! hasElseOrTrueGuard) ) {
			transition = lfContext.createTransition(
					"tr_" + exitState.getName(),
					choiceNotFirstState, exitState);

			buffer.delete(0, buffer.length());

			buffer.append(element.getName())
				.append("#current#schedule#region")
				.append(" == ")
				.append( nameOfEnumLiteralRegionOUT(element) );

			setGuard(transition, buffer.toString());
		}

		lfContext.currentState = exitState;
	}


	////////////////////////////////////// Transform Loop Fragment //////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////


	public void transformCombinedFragmentLoop(
			final CombinedFragment element, final StatemachineContext lfContext)
	{
		final String interactionOperator = element.getInteractionOperator().getLiteral();

		final StringBuilder buffer = new StringBuilder();

		// Unique Exit State
		final State exitState = lfContext.createExitState(
				"exit_" + interactionOperator + "#" + element.getName());

		// transformation Context
		final boolean isInteractionCtx =
				element.getCovereds().size() >= 2 && lfContext.transfoCtx == CONTEXT.INTERACTION;

		// Variables need in Interaction Context
		Property regionScheduleVariable = null;
		Pseudostate choiceNotFirstState = null;

		// Choice State for Fragment State Entry Constraint as Guard
		final Pseudostate choiceFirstState = lfContext.createNewState(
				"choice#constraint#" + element.getName() + "#Region",
				PseudostateKind.CHOICE_LITERAL);

		buffer.append("tr_").append(interactionOperator)
			.append(isInteractionCtx ?  "first#" : "entry#" )
			.append(element.getName());
		Transition transition = lfContext.createTransition(
				buffer.toString(), lfContext.currentState, choiceFirstState);

		// Transition for First Entry constraint i.e. no region in fifo scheduler
		if( isInteractionCtx ) {
			regionScheduleVariable = createCombinedRegionScheduleVariable(lfContext, element);

			final StringBuilder guard = new StringBuilder();
			guard.append("empty( ")
				.append(regionScheduleVariable.getName())
				.append(" )");

			setGuard(transition, guard.toString());

			// Choice State for Fragment State Entry Scheduling Region value as Guard
			choiceNotFirstState = lfContext.createNewState(
					"choice#schedule#" + element.getName() + "#Region",
					PseudostateKind.CHOICE_LITERAL);

			transition = lfContext.createElseTransition(
					"tr_not_first#" + element.getName(),
					lfContext.currentState, choiceNotFirstState);

			addOpaqueBehaviorEffect(transition,
					nameOfSchedulingVariable(element) + " >=> " +
					nameOfScheduledRegionVariable(element) + ";");

		}

		// InteractionOperand i.e. Region transformation
		final InteractionOperand contentFragment = element.getOperands().get(0);

		final Constraint loopGuard = contentFragment.getGuard();

		final State regionState = lfContext.createNewState(
				"region_" + interactionOperator + "#" + contentFragment.getName());

		buffer.delete(0, buffer.length());

		buffer.append("tr_").append(interactionOperator)
			.append(isInteractionCtx ?  "first#" : "entry#" )
			.append(contentFragment.getName());

		transition = lfContext.createTransition(
				buffer.toString(), choiceFirstState, regionState);
		setGuard(transition, loopGuard);

		boolean hasTrueGuard = fSupervisor.isConstraintElseOrTrue(transition.getGuard());

		if( isInteractionCtx ) {
			// Set Scheduling for other LifeLine per Combined Fragment
			for( final Lifeline lf : element.getCovereds() ) {
				if( lf != lfContext.coveredLifeline ) {
					buffer.delete(0, buffer.length());

					buffer.append( qualifiedNameOf(lf) )
						.append( "." )
						.append( regionScheduleVariable.getName() )
						.append( " <=< " )
						.append( qualifiedNameOfEnumLiteralRegion(contentFragment) )
						.append( ";" );

					addOpaqueBehaviorEffect(transition, buffer.toString());
				}
			}

			// Transition for Scheduling Region in not first case
			transition = lfContext.createTransition(
					"tr_" + regionState.getName(),
					choiceNotFirstState, regionState);

			buffer.delete(0, buffer.length());

			buffer.append( nameOfScheduledRegionVariable(element) )
				.append(" == ")
				.append( qualifiedNameOfEnumLiteralRegion(contentFragment) );

			setGuard(transition, buffer.toString());
		}

		lfContext.currentState = regionState;

		final StatemachineContext regionContext = new StatemachineContext(lfContext, element);

		transformInteractionOperand(contentFragment, regionContext);

		transition = lfContext.createFinalElseTransition(
				"tr_" + interactionOperator + "_quit#" + contentFragment.getName(),
				regionState, exitState);


		// loop boucle with min/max index constraint
		final Transition trLoop = lfContext.createFinalTransition(
				"tr_loop", regionState, regionState);

		if( loopGuard instanceof InteractionConstraint ) {
			final InteractionConstraint interactionMinMax = (InteractionConstraint) loopGuard;

			hasTrueGuard = hasTrueGuard
					&& fSupervisor.isExpressionSymbol(interactionMinMax.getMinint(), 0)
					&& fSupervisor.isExpressionUnlimited(interactionMinMax.getMaxint());


			if( hasTrueGuard )
			{
				// UNLIMITED LOOP ?!?
			}
			else {
				final Property varLoopIndex = createVariable(lfContext.statemachine,
						//"loopIndex_"
						"count#" + element.getName(), DataTypeFactory.integerType());

				// Add effect behavior
				//increment loopIndex
				addOpaqueBehaviorEffect(trLoop, varLoopIndex.getName() + " += 1;");

				setGuard(trLoop, interactionMinMax, varLoopIndex);
			}
		}
		else {
			setGuard(trLoop, loopGuard);
		}

		if( ! hasTrueGuard ) {
			transition = lfContext.createElseTransition(
					"tr_" + interactionOperator + "_quit#" + element.getName(),
					choiceFirstState, exitState);

			if( isInteractionCtx ) {
				// Set Scheduling: entry none region
				for( final Lifeline lf : element.getCovereds() ) {
					if( lf != lfContext.coveredLifeline ) {
						buffer.delete(0, buffer.length());

						buffer.append( qualifiedNameOf(lf) )
							.append( "." )
							.append( regionScheduleVariable.getName() )
							.append( " <=< " )
							.append( qualifiedNameOfEnumLiteralRegionOUT(element) )
							.append( ";" );

						addOpaqueBehaviorEffect(transition, buffer.toString());
					}
				}
			}
		}

		if( isInteractionCtx && (! hasTrueGuard) ) {
			transition = lfContext.createTransition(
					"tr_" + exitState.getName(),
					choiceNotFirstState, exitState);
			buffer.delete(0, buffer.length());
			buffer.append(element.getName())
				.append("#current#schedule#region")
				.append(" == ")
				.append( nameOfEnumLiteralRegionOUT(element) );

			setGuard(transition, buffer.toString());
		}

		lfContext.currentState = exitState;
	}

	public void transformCombinedFragmentLoopOLD(final CombinedFragment element,
			final StatemachineContext lfContext) {

		lfContext.currentState.setName("LoopFragment#" + element.getName());
		final Constraint loopGuard = element.getOperands().get(0).getGuard();
		final State loopState = lfContext.createNewState("loop#" + element.getName());

		if( element.getCovereds().size() < 2 || lfContext.transfoCtx == CONTEXT.LIFELINE ) {

			final Transition entryLoop = lfContext.createTransition(
					"tr_loop_entry", lfContext.currentState, loopState);
			setGuard(entryLoop, loopGuard);
		}
		else {
			final Property regionScheduleVariable =
					createCombinedRegionScheduleVariable(lfContext, element);

			Transition entryLoop = lfContext.createTransition(
					"tr_loop_first", lfContext.currentState, loopState);
			setGuard(entryLoop, loopGuard);

			addGuardForFirstRegionEntry(entryLoop, regionScheduleVariable);

			//for(Lifeline lf :element.getCovereds()){
				//if(lf != lfContext.coveredLifeline){
					addOpaqueBehaviorEffect(entryLoop,
							regionScheduleVariable.getName() + " <=< " +
								qualifiedNameOfEnumLiteralRegion(
										element.getOperands().get(0)) + ";");
				//}
			//}

			entryLoop= lfContext.createTransition(
					"tr_loop_not_first", lfContext.currentState, loopState);
			setGuard(entryLoop, loopGuard);

			addGuardForNotFirstRegionEntry(entryLoop, regionScheduleVariable, element);

			addOpaqueBehaviorEffect(entryLoop,
					regionScheduleVariable.getName() + " >=> " +
							qualifiedNameOfEnumLiteralRegion(
									element.getOperands().get(0)) + ";");
		}

		lfContext.currentState = loopState;

		// loop boucle with min/max index constraint
		final Transition trLoop = lfContext.createFinalTransition(
				"tr_loop", loopState, loopState);
		final Property varLoopIndex = createVariable(lfContext.statemachine,
				//"loopIndex_"
				"count#" + element.getName(), DataTypeFactory.integerType());

		// Add effect behavior
		//increment loopIndex
		addOpaqueBehaviorEffect(trLoop, varLoopIndex.getName() + " += 1;");


		if( loopGuard instanceof InteractionConstraint ) {

			setGuard(trLoop, (InteractionConstraint) loopGuard, varLoopIndex);
		}
		else {
			setGuard(trLoop, loopGuard);
		}


		final StatemachineContext loopContext = new StatemachineContext(lfContext, element);

		for( final InteractionOperand iFragment : element.getOperands() ) {
			transformInteractionOperand(iFragment, loopContext);
		}

		// quit loop transition
		final State quitloopState = lfContext.createExitState("quit_loop#" + element.getName());
		final Transition quitLoop = lfContext.createFinalElseTransition(
				"final#tr_quit_loop", loopState, quitloopState);

		lfContext.currentState = quitloopState;
	}



////////////////////////////////////// Transform Alt Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

public void transformCombinedFragmentAlt(final CombinedFragment element, final StatemachineContext lfContext) {

	// Save Current State for transformCombinedFragmentScheduling()
	final State sourceAltState = lfContext.currentState;

	// Unique Exit State
	final State exitAltState = lfContext.createExitState("exit_alt#" + element.getName());

	// transformation Context
	final boolean isInteractionCtx =
			element.getCovereds().size() >= 2 && lfContext.transfoCtx == CONTEXT.INTERACTION;

	Property regionScheduleVariable = null;
	ArrayList<State> regionStates = null ;

	// Choice State for Fragment State Entry Constraint as Guard
	final Pseudostate choiceFirstState = lfContext.createNewState(
			"choice#constraint#" + element.getName() + "#Region",
			PseudostateKind.CHOICE_LITERAL);

	final Transition transitionAlt = lfContext.createTransition(
			(isInteractionCtx ?  "tr_alt_first#" : "tr_alt_entry#" ) + element.getName(),
			lfContext.currentState, choiceFirstState);

	// Transition for First Entry constraint i.e. no region in fifo scheduler
	if( isInteractionCtx ) {
		regionScheduleVariable = createCombinedRegionScheduleVariable(lfContext, element);

		final StringBuilder guard = new StringBuilder();
		guard.append("empty( ")
			.append(regionScheduleVariable.getName())
			.append(" )");

		setGuard(transitionAlt, guard.toString());

		regionStates = new ArrayList<State>();
	}

	// InteractionOperand i.e. Region transformation
	for( final InteractionOperand iFragment : element.getOperands() ) {

		final State regionAltState = lfContext.createNewState("region_alt#" + iFragment.getName());

		final Transition entryAltFirst = lfContext.createTransition(
				(isInteractionCtx ? "tr_alt_first#" : "tr_alt_entry#" ) + iFragment.getName(),
				choiceFirstState, regionAltState);
		setGuard(entryAltFirst, iFragment.getGuard());

		if( isInteractionCtx ) {
			regionStates.add(regionAltState);

			// Set Scheduling for other LifeLine per Combined Fragment
			for( final Lifeline lf : element.getCovereds() ) {
				if( lf != lfContext.coveredLifeline ) {
					final StringBuilder buffer = new StringBuilder();
					buffer.append( qualifiedNameOf(lf) )
						.append( "." )
						.append( regionScheduleVariable.getName() )
						.append( " <=< " )
						.append( qualifiedNameOfEnumLiteralRegion(iFragment) )
						.append( ";" );

					addOpaqueBehaviorEffect(entryAltFirst, buffer.toString());
				}
			}
		}

		lfContext.currentState = regionAltState;

		final StatemachineContext altContext = new StatemachineContext(lfContext, element);

		transformInteractionOperand(iFragment, altContext);

		final Transition exitRegionAlt = lfContext.createFinalTransition(
				"tr_alt_quit#" + iFragment.getName(), regionAltState, exitAltState);
	}

	final Transition elseAltFirst = lfContext.createElseTransition(
			"tr_alt_else#" + element.getName(), choiceFirstState, exitAltState);

	if( isInteractionCtx ) {
		// Set Scheduling: entry none region
		for( final Lifeline lf : element.getCovereds() ) {
			if( lf != lfContext.coveredLifeline ) {
				final StringBuilder buffer = new StringBuilder();
				buffer.append( qualifiedNameOf(lf) )
					.append( "." )
					.append( regionScheduleVariable.getName() )
					.append( " <=< " )
					.append( qualifiedNameOfEnumLiteralRegionOUT(element) )
					.append( ";" );

				addOpaqueBehaviorEffect(elseAltFirst, buffer.toString());
			}
		}

		regionStates.add(exitAltState);

		lfContext.currentState = sourceAltState;
		transformCombinedFragmentScheduling(element, lfContext, regionStates);
	}

	lfContext.currentState = exitAltState;
}


//////////////////////////////////////Transform Sequence Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
// TODO
public void transformCombinedFragmentSequence(
		final CombinedFragment element, final StatemachineContext lfContext) {

	lfContext.currentState.setName("SeqFragment#" + element.getName());
	final State exitSeqState = lfContext.createExitState("exit_seq#" + element.getName());

	final State regionSeqState = lfContext.createNewState("target_seq#" + element.getName());
	for( final InteractionOperand iFragment : element.getOperands()) {

		final Constraint regionGuard = iFragment.getGuard();

		final Transition entrySeq = lfContext.createTransition(
				"tr_seq_region#" + iFragment.getName(), lfContext.currentState, regionSeqState);
		//	setGuard(entryStrict, regionGuard);

		final StatemachineContext seqContext = new StatemachineContext(lfContext, iFragment);

		transformInteractionOperand(iFragment, seqContext);

	}

	final Transition exitSeq = lfContext.createFinalTransition(
			"tr_seq_quit#" + element.getName(), lfContext.currentState, exitSeqState);
	lfContext.currentState = exitSeqState;
}


//////////////////////////////////////Transform Strict Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

public void transformCombinedFragmentStrict(
		final CombinedFragment element, final StatemachineContext lfContext) {

	lfContext.currentState.setName("StrictFragment#" + element.getName());

	State elseStrictState = null;
	Transition elseStrictTransition = null;
	State operandStrictState = null;

	final InteractionFragment lastFragment =
			element.getOperands().get( element.getOperands().size() - 1 );

	for( final InteractionOperand iFragment : element.getOperands() ) {

		if( elseStrictState != null ) {
			elseStrictState.setName("strict#" + iFragment.getName());
			operandStrictState = elseStrictState;
			elseStrictState = null;
		}
		else {
			operandStrictState = lfContext.createNewState("strict#" + iFragment.getName());
		}
		final Transition operandStrictTransition = lfContext.createTransition(
				"tr_strict_region#" + iFragment.getName(), lfContext.currentState, operandStrictState);

		final Constraint regionGuard = iFragment.getGuard();
		if( regionGuard != null ) {
			setGuard(operandStrictTransition, regionGuard);

			// previous else transition
			if( elseStrictTransition != null ) {
				setGuard(elseStrictTransition, regionGuard);
			}

			if( iFragment != lastFragment ) {
				elseStrictState = lfContext.createNewState("else_strict#" + iFragment.getName());
			}
			else {
				elseStrictState = lfContext.createExitState("else_strict#" + iFragment.getName());
			}

			elseStrictTransition = lfContext.createTransition(
					"tr_else_strict_region#" + iFragment.getName(), lfContext.currentState, elseStrictState);
		}

		lfContext.currentState = operandStrictState;

		final StatemachineContext strictContext = new StatemachineContext(lfContext, iFragment);

		transformInteractionOperand(iFragment, strictContext);
	}

	if( elseStrictState != null ) {
		elseStrictState.setName("exit_strict#" + element.getName());
	}
	else {
		elseStrictState = lfContext.createExitState("exit_strict#" + element.getName());
	}
	final Transition exitStrict = lfContext.createTransition(
			"tr_strict_quit#" + element.getName(), lfContext.currentState, elseStrictState);
	lfContext.currentState = elseStrictState;
}


//////////////////////////////////////Transform Parallel Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
//TODO

public void transformCombinedFragmentParallel(
		final CombinedFragment element, final StatemachineContext lfContext) {

	lfContext.currentState.setName("ParFragment#" + element.getName());
	final State exitParState = lfContext.createExitState("exit_par#" + element.getName());

	final State regionStrictState = lfContext.createNewState("target_par#" + element.getName());
	for( final InteractionOperand iFragment : element.getOperands()) {

		final Constraint regionGuard = iFragment.getGuard();
		//	Transition entryStrict = lfContext.createTransition(
		//			"tr_strict_region#" + iFragment.getName(), lfContext.currentState, regionStrictState);
		//	setGuard(entryStrict, regionGuard);

		final StatemachineContext parContext = new StatemachineContext(lfContext, iFragment);

		transformInteractionOperand(iFragment, parContext);

	}

	final Transition exitPar = lfContext.createTransition(
			"tr_par_quit#" + element.getName(), lfContext.currentState, exitParState);
	lfContext.currentState = exitParState;


}



//////////////////////////////////////Transform Opt Fragment //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

public void transformCombinedFragmentOpt(final CombinedFragment element,
		final StatemachineContext lfContext) {

	transformCombinedFragmentAlt( element, lfContext);

//	// Save Current State for transformCombinedFragmentScheduling()
//		State sourceOptState = lfContext.currentState;
//
//		// Unique Exit State
//		State exitOptState = lfContext.createExitState("exit_opt#" + element.getName());
//
//		// transformation Context
//		boolean isInteractionCtx =
//				element.getCovereds().size() >= 2 && lfContext.transfoCtx == CONTEXT.INTERACTION;
//
//		Property regionScheduleVariable = null;
//		ArrayList<State> regionStates = null ;
//
//		// Choice State for Fragment State Entry Constraint as Guard
//		Pseudostate choiceFirstState = lfContext.createNewState(
//				"choice#constraint#" + element.getName() + "#Region",
//				PseudostateKind.CHOICE_LITERAL);
//
//		Transition transitionAlt = lfContext.createTransition(
//				(isInteractionCtx ?  "tr_opt_first#" : "tr_opt_entry#" ) + element.getName(),
//				lfContext.currentState, choiceFirstState);
//
//		// Transition for First Entry constraint i.e. no region in fifo scheduler
//		if( isInteractionCtx ) {
//			regionScheduleVariable = createCombinedRegionScheduleVariable(lfContext, element);
//
//			StringBuilder guard = new StringBuilder();
//			guard.append("empty( ")
//				.append(regionScheduleVariable.getName())
//				.append(" )");
//
//			setGuard(transitionAlt, guard.toString());
//
//			regionStates = new ArrayList<State>();
//		}
//
//		// Operand i.e. Region transformation
//		for( InteractionOperand iFragment : element.getOperands() ) {
//
//			State regionAltState = lfContext.createNewState("region_opt#" + iFragment.getName());
//
//			Transition entryAltFirst = lfContext.createTransition(
//					(isInteractionCtx ? "tr_opt_first#" : "tr_opt_entry#" ) + iFragment.getName(),
//					choiceFirstState, regionAltState);
//			setGuard(entryAltFirst, iFragment.getGuard());
//
//			if( isInteractionCtx ) {
//				regionStates.add(regionAltState);
//
//				// Set Scheduling for other LifeLine per Combined Fragment
//				for( Lifeline lf : element.getCovereds() ) {
//					if( lf != lfContext.coveredLifeline ) {
//						StringBuilder buffer = new StringBuilder();
//						buffer.append( qualifiedNameOf(lf) )
//							.append( "." )
//							.append( regionScheduleVariable.getName() )
//							.append( " <=< Region#" )
//							.append( iFragment.getName() )
//							.append( ";" );
//
//						addOpaqueBehaviorEffect(entryAltFirst, buffer.toString());
//					}
//				}
//			}
//
//			lfContext.currentState = regionAltState;
//
//			StatemachineContext altContext = new StatemachineContext(lfContext, element);
//
//			transformInteractionOperand(iFragment, altContext);
//
//			Transition exitRegionOpt = lfContext.createFinalTransition(
//					"tr_opt_quit#" + iFragment.getName(), regionAltState, exitOptState);
//		}
//
//		if( isInteractionCtx ) {
//			regionStates.add(exitOptState);
//
//			lfContext.currentState = sourceOptState;
//			transformCombinedFragmentScheduling(element, lfContext, regionStates);
//		}
//
//		lfContext.currentState = exitOptState;

}




	/**
	 * performTransform a ExecutionOccurrence element to a writer
	 * @param element
	 */
	public void transformExecutionOccurrenceSpecification(
			final ExecutionOccurrenceSpecification element, final StatemachineContext lfContext) {

		final State execOccState = lfContext.createTargetState("execOcc#" + element.getName());

		final Transition execOccTrqns = lfContext.createTransition(
				"tr_execOcc", lfContext.currentState, execOccState);


		lfContext.currentState = execOccState;
	}


	/**
	 * performTransform a Lifeline element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformLifeline(final Lifeline element, final PrettyPrintWriter writer)
	{
		final StatemachineContext lfContext =
				new StatemachineContext(element.getInteraction(), CONTEXT.LIFELINE);

		transformInteraction(element.getInteraction(),
				Arrays.asList( element ), lfContext, writer);
	}

	public void transformWriteLifeline(final Lifeline element,
			StatemachineContext lfContext, final PrettyPrintWriter writer) {

		lfContext = transformWriteLifeline(element, lfContext);

		lfContext.toWriter(fSupervisor, writer);
	}


	public StatemachineContext transformWriteLifeline(
			final Lifeline element, StatemachineContext lfContext) {

		final Interaction interaction = element.getInteraction();

		if( interaction != null ) {
			lfContext = new StatemachineContext(lfContext, element);

			final ArrayList<InteractionFragment> coveredFragmentList =
					coveredFragments(element, interaction.getFragments());

			lfContext.isLastFragmentTransformation = false;

			final InteractionFragment lastFragment =
					coveredFragmentList.get( coveredFragmentList.size() - 1 );

			for (final InteractionFragment itFragment : coveredFragmentList) {
				if( itFragment == lastFragment ) {
					lfContext.isLastFragmentTransformation = true;

					//Transition tr_final = lfContext.createTransition(
					//"tr_final", lfContext.currentState, lfContext.finalState);

//					lfContext.currentState = lfContext.finalState;
				}

				transformFragment(itFragment, lfContext);
			}
		}

		return lfContext;
	}




	/**
	 * performTransform a BehaviorExecutionSpecification element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformBehaviorExecutionSpecification(
			final BehaviorExecutionSpecification element,
			final StatemachineContext lfContext) {
		if(element.getStart() instanceof ExecutionOccurrenceSpecification){
			final BehaviorExecutionSpecification act = element;

			final State targetState = needIntermediateState(element, lfContext)
					? lfContext.createIntermediateState("targetBhExec#" + element.getName())
					: lfContext.createTargetState("targetBhExec#" + element.getName());

			lfContext.currentState.setName("BhExec#" + element.getName());
			final Transition BH_tr= lfContext.createTransition(
					act.getName(), lfContext.currentState, targetState);

			transformElementConstraints(element.getStart(), BH_tr, lfContext);

			addOpaqueBehaviorEffect(BH_tr, act.getBehavior());

			lfContext.currentState = targetState;
			//add constraint of finishOccurrence to the transition
			if(element.getFinish() instanceof ExecutionOccurrenceSpecification ){

				final List<Constraint> constraints = lfContext.getElementConstraints(element.getFinish());
				if( constraints != null ){
					lfContext.intermediateTransition = null;

					for (final Constraint constraint : constraints) {
						addEffectGuard(lfContext, element, BH_tr, constraint);
					}

					if(lfContext.intermediateTransition != null){
						lfContext.currentState = (State) lfContext.intermediateTransition.getTarget();
						lfContext.intermediateTransition = null;
					}

					if(element.getBehavior() instanceof FunctionBehavior){
						addOpaqueBehaviorEffect(BH_tr, "AllCallsStack <=< currentCall;");
					}
				}
				else {
					if(element.getBehavior() instanceof FunctionBehavior){
						addOpaqueBehaviorEffect(BH_tr, "AllCallsStack <=< currentCall;");
					}
				}
			}
			//lfContext.currentState = targetState;

		}
	}

	private boolean needIntermediateState(
			final BehaviorExecutionSpecification element,
			final StatemachineContext lfContext) {
		if( lfContext.isLastFragmentTransformation
			&& (element.getFinish() instanceof ExecutionOccurrenceSpecification) ){

			final List<Constraint> constraints = lfContext.getElementConstraints(element.getFinish());
			if( constraints != null ){
				for (final Constraint constraint : constraints)
				{
					final ValueSpecification valueSpec = constraint.getSpecification();
					if( valueSpec instanceof OpaqueExpression ) {
						final OpaqueExpression opaqExpr = (OpaqueExpression)valueSpec;
						for (final String language : opaqExpr.getLanguages()) {
							if(language.contains("xLIA")){
								{
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * performTransform a MessageOccurrenceSpecification element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformMessageOccurrenceSpecification(
			final MessageOccurrenceSpecification element,
			final StatemachineContext lfContext) {


		lfContext.currentState.setName("MsgOcc#" + element.getName());
		final State targetState = lfContext.createTargetState("targetMsgOcc#" + element.getName());
		final Transition MsgOcc_tr= lfContext.createTransition(
				"tr_" + element.getName(), lfContext.currentState, targetState);

		// Set time observation point, if need
		addTimeObservation(MsgOcc_tr, element, fMapOfOccSpecTimeObs);

//		Message message = element.getMessage();
//		if( element.isReceive() ){
//
//			StringBuilder MsgReceiveAction = new StringBuilder("input ");
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



		final Message message = element.getMessage();
		if( element.isReceive() ){

			//translate constraints
			transformElementConstraints(element, MsgOcc_tr, lfContext);

		    final StringBuilder MsgReceiveAction = new StringBuilder("input ");
		    lfContext.inputMessage.add(message);

		    MsgReceiveAction.append( message.getName() );


		//    if (! (message.getArguments().isEmpty()) ){
		    	// check if there is a behaviorExecution that specifies the variables on which we receive the message
				final EList<InteractionFragment> fragments = lfContext.coveredLifeline.getCoveredBys();
				Boolean isStartExecBehavExecution = false;
				BehaviorExecutionSpecification behavExecSpecOfComAct = null;
				for (final Iterator<InteractionFragment> iterator = fragments.iterator(); iterator.hasNext();) {
					final InteractionFragment interactionFragment = iterator.next();
					if (interactionFragment instanceof BehaviorExecutionSpecification){

						behavExecSpecOfComAct = (BehaviorExecutionSpecification) interactionFragment;
						if (behavExecSpecOfComAct.getStart() == element){
							isStartExecBehavExecution = true;
							break;
						}
					}
				}

				MsgReceiveAction.append("( ")
				.append(nameOfMessageParamsVariable(message)).append( " );\n" );//append("#").append(message.getSignature().getName()).append(");\n");

				if (isStartExecBehavExecution){
					final Behavior behavior = behavExecSpecOfComAct.getBehavior();
					if (behavior instanceof OpaqueBehavior){
						final OpaqueBehavior opaqueBehavior = (OpaqueBehavior) behavior;
						if (opaqueBehavior.getBodies().size() > 0){
							String strinBehavior = opaqueBehavior.getBodies().get(0).trim();
							if( strinBehavior.startsWith("in ") ) {
								strinBehavior = strinBehavior.substring(3, strinBehavior.length()-1);
								final String[] inVars = strinBehavior.split(" *, *");

								final Signal signal = (Signal) message.getSignature();
								for (int i = 0; i < inVars.length; i++) {
									MsgReceiveAction.append(inVars[i])
									.append(" = ")
									.append(nameOfMessageParamsVariable(message))
									.append( ".")//append("#").append(message.getSignature().getName()).append(".")
									.append(signal.getAllAttributes().get(i).getName())
									.append(";\n");
								}
							}
							else {
								//TO DO error message
							}
						}
					}
				}

		        //ancien
		        final NamedElement signature = message.getSignature();
		        if( signature instanceof Signal ) {
		            lfContext.addLocalVariable(
		            		nameOfMessageParamsVariable(message)//"#" + message.getSignature().getName()
		            		, (Signal) signature);
		        }

				addOpaqueBehaviorEffect(MsgOcc_tr, MsgReceiveAction.toString());
	//	    }
		}
		else if( element.isSend() ) {

			//translate constraints
			transformElementConstraints(element, MsgOcc_tr, lfContext);

			//translate output action
			final StringBuilder MsgReceiveAction = new StringBuilder("output ");
			lfContext.outputMessage.add(message);

			if( message.getArguments().isEmpty() ) {
				MsgReceiveAction.append( message.getName() )
					.append("( ")
					.append( nameOfMessageSignature(message) )
					.append(" )");
			}
			else {
				MsgReceiveAction.append( message.getName() )
					.append("( { ")
					.append( nameOfMessageSignature(message) )
					.append(", ");

				boolean isnotFirst = false;

				for (final ValueSpecification itArg : message.getArguments()) {
					if( isnotFirst ) {
						MsgReceiveAction.append(", ");
					}
					else {
						isnotFirst = true;
					}
					MsgReceiveAction.append(itArg.stringValue());
				}
				//MsgReceiveAction.append(" } )");
				MsgReceiveAction.append(" } )");
			}
			MsgReceiveAction.append(" --> ");


			if (message.getReceiveEvent() instanceof MessageOccurrenceSpecification){

				if( lfContext.transfoCtx == CONTEXT.INTERACTION )
				{
					final MessageOccurrenceSpecification target = (MessageOccurrenceSpecification) message.getReceiveEvent();
					try {
						MsgReceiveAction
//							.append(target.getCovered().getRepresents().getType().getName())
//							.append('#')
							.append(target.getCovered().getName());
					}
					catch (final NullPointerException e) {
						if( target.getCovered() == null ) {
							MessageDialog.openError(
									Display.getCurrent().getActiveShell(),
									"EFM Sequence Diagramm transformation"
									+ "< MessageOccurrenceSpecification >",
									"==> " + target.getName()
									+ " has null Covered Lifeline <==");
						}
						else if( target.getCovered().getRepresents() == null ) {
							MessageDialog.openError(
									Display.getCurrent().getActiveShell(),
									"EFM Sequence Diagramm transformation"
									+ "< MessageOccurrenceSpecification >",
									"==> " + target.getName() + "< covered lifeline: "
									+ target.getCovered().getName()
									+ " > has null Represents <==");
						}
					}
				}
				else {
					MsgReceiveAction.append("$env");
				}
			}

			if (message.getReceiveEvent() instanceof Gate){

				//Gate target = (Gate) message.getReceiveEvent();

				MsgReceiveAction.append("$env");
			}
			MsgReceiveAction.append(";");

			addOpaqueBehaviorEffect(MsgOcc_tr, MsgReceiveAction.toString());
	   }
		lfContext.currentState = targetState;

		// update time observation index, if need
		incrementTimeObservationIndex(MsgOcc_tr, element, fMapOfOccSpecTimeObs);
	}



	/**
	 * performTransform a Message element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformMessage(final Message element,
			final StatemachineContext lfContext,  final PrettyPrintWriter writer) {
		writer.appendTab("message ").append(element.getName())
			.appendEol(" {");


		writer.appendTab("} // end message ")
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
