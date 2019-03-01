/*******************************************************************************
 * Copyright (c) 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.formalml.ecore.factory;

import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.statemachine.Pseudostate;
import org.eclipse.efm.ecore.formalml.statemachine.PseudostateKind;
import org.eclipse.efm.ecore.formalml.statemachine.Region;
import org.eclipse.efm.ecore.formalml.statemachine.State;
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine;
import org.eclipse.efm.ecore.formalml.statemachine.StatemachineFactory;
import org.eclipse.efm.ecore.formalml.statemachine.Transition;
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe;
import org.eclipse.efm.ecore.formalml.statemachine.Vertex;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;

public class XLIA_STATEMACHINE {

	// StatementFactory FACTORY
	static StatemachineFactory FACTORY = StatemachineFactory.eINSTANCE;


	// STATEMACHINE
	public static Statemachine createStatemachine(final String name) {
		final Statemachine statemachine = FACTORY.createStatemachine();
		statemachine.setName(name);

		return statemachine;
	}

	// REGION
	public static Region createRegion(final Statemachine statemachine) {
		final Region region = FACTORY.createRegion();
		statemachine.getRegion().add(region);

		return region;
	}

	// PSEUDO STATE
	public static Pseudostate createPseudotate(
			final String name, final PseudostateKind kind) {
		final Pseudostate state = FACTORY.createPseudostate();
		state.setName(name);
		state.setKind(kind);

		return state;
	}

	public static Pseudostate createInitialState(final String name) {
		return createPseudotate(name, PseudostateKind.INITIAL);
	}

	public static Pseudostate createJunctionState(final String name) {
		return createPseudotate(name, PseudostateKind.JUNCTION);
	}

	public static Pseudostate createChoiceState(final String name) {
		return createPseudotate(name, PseudostateKind.CHOICE);
	}


	// STATE
	public static State createState(final String name) {
		final State state = FACTORY.createState();
		state.setName(name);

		return state;
	}

	// TRANSITION
	public static Transition createTransition(
			final String name, final Vertex source, final Vertex target) {
		final Transition transition = FACTORY.createTransition();
		transition.setName(name);

		source.getTransition().add(transition);
		transition.setTarget(target);

		return transition;
	}

	/**
	 * Create a Transition
	 * @param name
	 * @param priority if negative create an <b>else transition</b>
	 * @param source
	 * @param target
	 * @return
	 */
	public static Transition createTransition(final String name,
			final int priority, final Vertex source, final Vertex target) {
		final Transition transition = FACTORY.createTransition();
		transition.setName(name);

		final TransitionMoe moe = FACTORY.createTransitionMoe();
		if( priority >=0 ) {
			moe.setPriority(priority);
		}
		else {
			moe.setIsElse(true);
		}
		transition.setMoe(moe);

		source.getTransition().add(transition);
		transition.setTarget(target);

		return transition;
	}

	public static Transition createTransitionElse(
			final String name, final Vertex source, final Vertex target) {
		final Transition transition = FACTORY.createTransition();
		transition.setName(name);

		final TransitionMoe moe = FACTORY.createTransitionMoe();
		moe.setIsElse(true);
		transition.setMoe(moe);

		source.getTransition().add(transition);
		transition.setTarget(target);

		return transition;
	}

	// ModelOfExecution
	public static void setEnable(
			final Vertex vertex, final BlockStatement blockEnable) {
		ModelOfExecution moe = vertex.getMoe();
		if( moe == null ) {
			vertex.setMoe( moe = XLIA_INFRA.createMOE() );
		}

		final Routine routineEnable = XLIA_INFRA.createRoutine("@enable");
		routineEnable.setBodyBlock(blockEnable);

		moe.setEnableRoutine(routineEnable);
	}

}
