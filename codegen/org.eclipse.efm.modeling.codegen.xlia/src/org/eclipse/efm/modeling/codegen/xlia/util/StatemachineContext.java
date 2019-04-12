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
package org.eclipse.efm.modeling.codegen.xlia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.efm.modeling.codegen.xlia.core.MainCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.statemachine.StatemachineCodeGenerator;
import org.eclipse.efm.modeling.codegen.xlia.statemachine.StatemachineFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

public class StatemachineContext implements StatemachineFactory , UmlFactory {

	public enum CONTEXT { INTERACTION ,  LIFELINE }


	public StatemachineContext parentContext;

	public CONTEXT transfoCtx;


	public Lifeline coveredLifeline;

	protected InteractionFragment interactionFragment;

	public StateMachine statemachine;

	public ArrayList<Message> inputMessage;
	public ArrayList<Message> outputMessage;

	public Map<Element, List<Constraint>> constraintMap;

	public Map<NamedElement, List<TimeObservation>> timeObservationMap;

	public Region region;

	public Pseudostate initialState;
	public State currentState;
	public FinalState finalState;

	public boolean isLastFragmentTransformation;

	public Transition intermediateTransition;

//	public StatemachineContext() {
//		coveredLifeline = null;
//
//		parentContext = null;
//
//		statemachine = UmlFactory.createStateMachine("System");
//
//		region = statemachine.getRegions().get(0);
//
//		initializeState(statemachine.getName());
//
//
//	}
//

	/**
	 * Create a StatemachineContext for the Interaction element which initializes the constraints map
	 * @param interaction
	 */
	public StatemachineContext(final Interaction interaction, final CONTEXT context) {
		parentContext = null;

		transfoCtx = context;

		coveredLifeline = null;

		interactionFragment = null;

		inputMessage = new ArrayList<Message>();
		outputMessage = new ArrayList<Message>();

		constraintMap = new HashMap<Element, List<Constraint>>();
		initializeConstraintMap(interaction);

		timeObservationMap = new HashMap<NamedElement, List<TimeObservation>>();

		statemachine = null;

		region = null;

		isLastFragmentTransformation = false;

		intermediateTransition = null;
	}

	public StatemachineContext(final StatemachineContext parentCtx, final Lifeline lifeline) {
		parentContext = parentCtx;

		transfoCtx = parentCtx.transfoCtx;

		coveredLifeline = lifeline;

		interactionFragment = null;

		inputMessage = parentCtx.inputMessage;
		outputMessage = parentCtx.outputMessage;

		constraintMap = parentCtx.constraintMap;

		timeObservationMap = parentCtx.timeObservationMap;

		statemachine = createStateMachine(lifeline.getName());

		region = statemachine.getRegions().get(0);

		isLastFragmentTransformation = false;

		initializeState(lifeline.getName());

//		Transition transition = UmlFactory.createTransition(region, "t_" + name, initialState, finalState);
//
//		Property varX = UmlFactory.createVariable(statemachine, "X", UmlFactory.fifoIntType(42));

//		Property varX = UmlFactory.createVariable(statemachine, "size_" + lifeline.getName(), UmlFactory.integerType());
//		Property varY = UmlFactory.createVariable(statemachine, "top_" + lifeline.getName(), UmlFactory.integerType());
	}


	public StatemachineContext(final Lifeline lifeline) {
		this(new StatemachineContext(lifeline.getInteraction(), CONTEXT.INTERACTION), lifeline);
	}


	public StatemachineContext(final StatemachineContext parentCtx, final InteractionFragment element) {
		parentContext = parentCtx;

		transfoCtx = parentCtx.transfoCtx;

		coveredLifeline = parentCtx.coveredLifeline;

		interactionFragment = element;

		inputMessage = parentCtx.inputMessage;
		outputMessage = parentCtx.outputMessage;

		constraintMap = parentCtx.constraintMap;

		timeObservationMap = parentCtx.timeObservationMap;

		statemachine = parentCtx.statemachine;

		region = parentCtx.currentState.createRegion(element.getName());

		initializeState(element.getName());
	}


	private void initializeState(final String name) {
		initialState = createInitialState(region, "init_" + name);

		currentState = createTargetState("start_" + name);

		final Transition transition = createTransition(
				"t_init_" + name, initialState, currentState);

		finalState = (FinalState) region.createSubvertex(
				"final_" + name, UMLPackage.eINSTANCE.getFinalState());
	}


	public void performNoCoveredFragment() {
		if( (interactionFragment != null)
			&& (region.getTransitions().size() == 1)
			&& (region.getSubvertices().size() == 3)
			&& (region.getTransitions().get(0).getSource() == initialState)
			&& (region.getTransitions().get(0).getTarget() == currentState) )
		{
			region.getTransitions().get(0).setTarget(finalState);
			region.getSubvertices().remove(currentState);

			currentState = finalState;

			System.out.println("performNoCoveredFragment for lifeline <" +
					coveredLifeline.getName() + "> covered by fragment : " + interactionFragment.getName() );
		}
	}


	///////////////////////////////////////////////////////////////////////////
	// [COMPOSITE] STATE
	///////////////////////////////////////////////////////////////////////////

	public static State createCompositeState(final Region region, final String name) {
		final State state = (State) region.createSubvertex(name, UMLPackage.eINSTANCE.getState());
		state.createRegion(name);

		return( state );
	}

	public State createTargetState(final String name) {
		if( isLastFragmentTransformation ) {
//			finalState.setName(name);

			return finalState;
		}
		else {
			final State state = (State) region.createSubvertex(name, UMLPackage.eINSTANCE.getState());

			return( state );
		}
	}

	public State createExitState(final String name) {
		if( isLastFragmentTransformation ) {
//			finalState.setName(name);

			isLastFragmentTransformation = false;

			return finalState;
		}
		else {
			final State state = (State) region.createSubvertex(name, UMLPackage.eINSTANCE.getState());

			return( state );
		}
	}

	public Pseudostate createNewState(final String name, final PseudostateKind kind) {
		final Pseudostate state = (Pseudostate) region.createSubvertex(name, UMLPackage.eINSTANCE.getPseudostate());
		state.setKind(kind);

		return( state );
	}

	public State createIntermediateState(final String name) {
		final State state = (State) region.createSubvertex(name, UMLPackage.eINSTANCE.getState());
		return( state );
	}

	public State createNewState(final String name) {
		final State state = (State) region.createSubvertex(name, UMLPackage.eINSTANCE.getState());

		return( state );
	}


	///////////////////////////////////////////////////////////////////////////
	// TRANSITION
	///////////////////////////////////////////////////////////////////////////

	public Transition createTransition(
			final String name, final Vertex source, final Vertex target) {
		final Transition transition = region.createTransition(name);

		transition.setSource(source);
		transition.setTarget(target);

		return( transition );
	}



	public Transition createElseTransition(
			final String name, final Vertex source, final Vertex target) {
		final Transition transition = region.createTransition(name);

		transition.setSource(source);
		transition.setTarget(target);

		final Constraint constraint = transition.createGuard("ElseGuardConstraint");
		final Expression guardExpression = UMLFactory.eINSTANCE.createExpression();
		guardExpression.setSymbol(StatemachineCodeGenerator.TRANSITION_GUARD_ELSE);
		constraint.setSpecification(guardExpression);

		return( transition );
	}



	public Transition createFinalTransition(
			final String name, final Vertex source, final Vertex target) {
		final Transition transition = region.createTransition(name);

		transition.setSource(source);
		transition.setTarget(target);

		transition.createTrigger(StatemachineCodeGenerator.TRANSITION_TRIGGER_FINAL);

		return( transition );
	}


	public Transition createFinalElseTransition(
			final String name, final Vertex source, final Vertex target) {
		final Transition transition = region.createTransition(name);

		transition.setSource(source);
		transition.setTarget(target);

		transition.createTrigger(StatemachineCodeGenerator.TRANSITION_TRIGGER_FINAL);

		final Constraint constraint = transition.createGuard("ElseGuardConstraint");
		final Expression guardExpression = UMLFactory.eINSTANCE.createExpression();
		guardExpression.setSymbol(StatemachineCodeGenerator.TRANSITION_GUARD_ELSE);
		constraint.setSpecification(guardExpression);

		return( transition );
	}

	public void addInputMessage(final Message message){
		if( ! inputMessage.contains(message) ) {
			inputMessage.add(message);
		}
	}


	public void addOutputMessage(final Message message){
		if( ! outputMessage.contains(message) ) {
			outputMessage.add(message);
		}
	}

	//data constraints
	public void addElementConstraint(final Element element, final Constraint constraint) {
		List<Constraint> list = constraintMap.get(element);

		if( list == null ) {
			list = new ArrayList<Constraint>();
			constraintMap.put(element, list);
		}

		list.add(constraint);
	}

	public List<Constraint> getElementConstraints(final Element element) {
		return constraintMap.get(element);
	}

	public void initializeConstraintMap(final Interaction interaction) {
		for (final Constraint constraint : interaction.getOwnedRules()) {
			for (final Element element : constraint.getConstrainedElements()) {
				addElementConstraint(element, constraint);
			}
		}
	}

	// TODO time constraints
	public void addElementTimeConstraint(final Element element, final Constraint constraint) {
		List<Constraint> list = constraintMap.get(element);

		if( list == null ) {
			list = new ArrayList<Constraint>();
			constraintMap.put(element, list);
		}

		list.add(constraint);
	}

	public List<Constraint> getElementTimeConstraints(final Element element) {
		return constraintMap.get(element);
	}

	public void initializeTimeConstraintMap(final Interaction interaction) {
		for (final Constraint constraint : interaction.getOwnedRules()) {
			for (final Element element : constraint.getConstrainedElements()) {
				addElementTimeConstraint(element, constraint);
			}
		}
	}

	//TODO time observations
	public void addTimeObservation(final NamedElement element, final TimeObservation timeObservation) {
		List<TimeObservation> list = timeObservationMap.get(element);

		if( list == null ) {
			list = new ArrayList<TimeObservation>();
			timeObservationMap.put(element, list);
		}

		list.add(timeObservation);
	}

	public List<TimeObservation> getTimeObservation(final NamedElement element) {
		return timeObservationMap.get(element);
	}

	public void initializeTimeObservationMap(final Interaction interaction) {
		EObject eobj = interaction.eContainer();

		EList<PackageableElement> packElems = null;
		Boolean obsFound = false;

		for( ; !obsFound && eobj != null ; eobj = eobj.eContainer() ) {
			if (eobj instanceof Package){
				packElems = ((Package)eobj).getPackagedElements();

				for (final PackageableElement packElt : packElems) {
					if (packElt instanceof TimeObservation) {
						obsFound = true;
						break;
					}
				}
			}
		}
		if (packElems != null) {
			for (final PackageableElement packElt : packElems) {
				if (packElt instanceof TimeObservation) {
					final TimeObservation tObs = (TimeObservation) packElt ;
					//System.err.println("Ici : "+tObs.getName());
					//System.err.println("Ici : "+((OccurrenceSpecification)tObs.getEvent()).getName());
					//mapOfTObs.put(((OccurrenceSpecification)tObs.getEvent()).getName(), tObs);
					addTimeObservation(tObs.getEvent(), tObs);

				}
			}
		}
	}


	public void toWriter(final MainCodeGenerator mainCodegen, final PrettyPrintWriter writer) {
		if( (coveredLifeline != null)
			&& (interactionFragment == null)
			&& (coveredLifeline.getRepresents() != null))
		{
			final Type representsType = coveredLifeline.getRepresents().getType();
			if( representsType instanceof org.eclipse.uml2.uml.Class ) {
				final org.eclipse.uml2.uml.Class representsTypeClass = (org.eclipse.uml2.uml.Class) representsType;

				mainCodegen.fClassFactory.transformClassLifelineDefinition(
						representsTypeClass, statemachine, writer);
				return;
			}
		}

		toWriter(mainCodegen.fStatemachineFactory, writer);
	}


	public void toWriter(final StatemachineCodeGenerator statemachineCodegen, final PrettyPrintWriter writer) {
		if( statemachine != null ) {
			statemachineCodegen.transformStatemachine(statemachine, inputMessage, writer);
		}

	}

	public void addLocalVariable(final String varName, final Type varType) {
        createVariable(statemachine, varName, varType);
    }


}

