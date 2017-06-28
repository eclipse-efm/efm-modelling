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

import org.eclipse.efm.modeling.codegen.xlia.core.StatemachineCodeGenerator;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

public class StatemachineContext {
	
	public Lifeline coveredLifeline;

	public StatemachineContext parentContext;
	
	public StateMachine statemachine;
	
	public ArrayList<Message> inputMessage;
	public ArrayList<Message> outputMessage;
	
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
	
	
	
	
	public StatemachineContext(Lifeline lifeline) {
		coveredLifeline = lifeline;
		
		inputMessage = new ArrayList<Message>();
		outputMessage = new ArrayList<Message>();
		
		parentContext = null;
		
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
	
	public StatemachineContext(StatemachineContext parentCtx, NamedElement element) {
		coveredLifeline = parentCtx.coveredLifeline;
		
		inputMessage = parentCtx.inputMessage;
		outputMessage = parentCtx.outputMessage;

		parentContext = parentCtx;
		
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
	

		
	
	public void toWriter(StatemachineCodeGenerator statemachineCodegen, PrettyPrintWriter writer) {
		statemachineCodegen.transformStatemachine(
				statemachine, inputMessage, writer);
	}
}

