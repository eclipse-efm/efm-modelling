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
import org.eclipse.efm.modeling.codegen.xlia.core.StatemachineCodeGenerator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

public class StatemachineContext {
	
	public StatemachineContext parentContext;
	
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
	public StatemachineContext(Interaction interaction) {
		parentContext = null;
		
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
	}	
	
	public StatemachineContext(StatemachineContext parentCtx, Lifeline lifeline) {
		parentContext = parentCtx;
		
		coveredLifeline = lifeline;
		
		interactionFragment = null;
		
		inputMessage = parentCtx.inputMessage;
		outputMessage = parentCtx.outputMessage;

		constraintMap = parentCtx.constraintMap;
		
		timeObservationMap = parentCtx.timeObservationMap;
		
		statemachine = UmlFactory.createStateMachine(lifeline.getName());

		region = statemachine.getRegions().get(0);
		
		isLastFragmentTransformation = false;
		
		initializeState(lifeline.getName());

//		Transition transition = UmlFactory.createTransition(region, "t_" + name, initialState, finalState);
//		
//		Property varX = UmlFactory.createVariable(statemachine, "X", UmlFactory.fifoIntType(42));
		
//		Property varX = UmlFactory.createVariable(statemachine, "size_" + lifeline.getName(), UmlFactory.integerType());
//		Property varY = UmlFactory.createVariable(statemachine, "top_" + lifeline.getName(), UmlFactory.integerType());
	}	
	
	
	public StatemachineContext(Lifeline lifeline) {
		this(new StatemachineContext(lifeline.getInteraction()), lifeline);
	}

	
	public StatemachineContext(StatemachineContext parentCtx, InteractionFragment element) {
		parentContext = parentCtx;
		
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
	
	
	private void initializeState(String name) {
		initialState = UmlFactory.createInitialState(region, "init_" + name);
		
		currentState = createTargetState("start_" + name);
		
		Transition transition = createTransition(
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
	
	public static State createCompositeState(Region region, String name) {		
		State state = (State) region.createSubvertex(name, UMLPackage.eINSTANCE.getState());
		state.createRegion(name);
		
		return( state );
	}

	public State createTargetState(String name) {
		if( isLastFragmentTransformation ) {
//			finalState.setName(name);
			
			return finalState;
		}
		else {
			State state = (State) region.createSubvertex(name, UMLPackage.eINSTANCE.getState());
			
			return( state );
		}
	}

	
	public State createNewState(String name) {
		State state = (State) region.createSubvertex(name, UMLPackage.eINSTANCE.getState());
		
		return( state );
	}

	
	///////////////////////////////////////////////////////////////////////////
	// TRANSITION
	///////////////////////////////////////////////////////////////////////////
	
	public Transition createTransition(
			String name, Vertex source, Vertex target) {		
		Transition transition = region.createTransition(name);
		
		transition.setSource(source);
		transition.setTarget(target);
		
		return( transition );
	}
	
	public Transition createElseTransition(
			String name, Vertex source, Vertex target) {		
		Transition transition = region.createTransition(name);
		
		transition.setSource(source);
		transition.setTarget(target);
		
		Constraint constraint = transition.createGuard("ElseGuardConstraint");
		Expression guardExpression = UMLFactory.eINSTANCE.createExpression();
		guardExpression.setSymbol(StatemachineCodeGenerator.TRANSITION_GUARD_ELSE);
		constraint.setSpecification(guardExpression);
		
		return( transition );
	}

	
	public void addInputMessage(Message message){
		if( ! inputMessage.contains(message) ) {
			inputMessage.add(message);
		}
	}
	
	
	public void addOutputMessage(Message message){
		if( ! outputMessage.contains(message) ) {
			outputMessage.add(message);
		}
	}
	
	//data constraints
	public void addElementConstraint(Element element, Constraint constraint) {
		List<Constraint> list = constraintMap.get(element);
		
		if( list == null ) {
			list = new ArrayList<Constraint>();	
			constraintMap.put(element, list);
		}
		
		list.add(constraint);
	}
	
	public List<Constraint> getElementConstraints(Element element) {
		return constraintMap.get(element);
	}
	
	public void initializeConstraintMap(Interaction interaction) {
		for (Constraint constraint : interaction.getOwnedRules()) {
			for (Element element : constraint.getConstrainedElements()) {
				addElementConstraint(element, constraint);
			}
		}
	}

	// TODO time constraints
	public void addElementTimeConstraint(Element element, Constraint constraint) {
		List<Constraint> list = constraintMap.get(element);
		
		if( list == null ) {
			list = new ArrayList<Constraint>();	
			constraintMap.put(element, list);
		}
		
		list.add(constraint);
	}
	
	public List<Constraint> getElementTimeConstraints(Element element) {
		return constraintMap.get(element);
	}
	
	public void initializeTimeConstraintMap(Interaction interaction) {
		for (Constraint constraint : interaction.getOwnedRules()) {
			for (Element element : constraint.getConstrainedElements()) {
				addElementTimeConstraint(element, constraint);
			}
		}
	}
	
	//TODO time observations
	public void addTimeObservation(NamedElement element, TimeObservation timeObservation) {
		List<TimeObservation> list = timeObservationMap.get(element);
		
		if( list == null ) {
			list = new ArrayList<TimeObservation>();	
			timeObservationMap.put(element, list);
		}
		
		list.add(timeObservation);
	}
	
	public List<TimeObservation> getTimeObservation(NamedElement element) {
		return timeObservationMap.get(element);
	}
	
	public void initializeTimeObservationMap(Interaction interaction) {
		EObject eobj = interaction.eContainer();
		
		EList<PackageableElement> packElems = null;
		Boolean obsFound = false;

		for( ; !obsFound && eobj != null ; eobj = eobj.eContainer() ) {	
			if (eobj instanceof Package){
				packElems = ((Package)eobj).getPackagedElements();
			
				for (PackageableElement packElt : packElems) {
					if (packElt instanceof TimeObservation) {
						obsFound = true;
						break;
					}		
				}
			}
		}
		if (packElems != null) {
			for (PackageableElement packElt : packElems) {
				if (packElt instanceof TimeObservation) {
					TimeObservation tObs = (TimeObservation) packElt ; 
					//System.err.println("Ici : "+tObs.getName());
					//System.err.println("Ici : "+((OccurrenceSpecification)tObs.getEvent()).getName());
					//mapOfTObs.put(((OccurrenceSpecification)tObs.getEvent()).getName(), tObs); 
					addTimeObservation(tObs.getEvent(), tObs);
									
				}		
			}
		}
	}


	public void toWriter(MainCodeGenerator mainCodegen, PrettyPrintWriter writer) {
		if( (coveredLifeline != null) && (interactionFragment == null) ) {
			Type representsType = coveredLifeline.getRepresents().getType();
			if( representsType instanceof org.eclipse.uml2.uml.Class ) {
				org.eclipse.uml2.uml.Class representsTypeClass = (org.eclipse.uml2.uml.Class) representsType;
				
				mainCodegen.fClassFactory.transformClassLifelineDefinition(
						representsTypeClass, statemachine, writer);
				return;
			}
		}

		toWriter(mainCodegen.fStatemachineFactory, writer);
	}

	
	public void toWriter(StatemachineCodeGenerator statemachineCodegen, PrettyPrintWriter writer) {
		statemachineCodegen.transformStatemachine(
				statemachine, inputMessage, writer);

	}
	
	public void addLocalVariable(String varName, Type varType) {
        UmlFactory.createVariable(statemachine, varName, varType);
    }


}

