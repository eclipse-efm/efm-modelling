/**
 * Copyright (c) 2018 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.formalml.xtext.ui.hover

import com.google.inject.Inject
import org.eclipse.efm.formalml.xtext.services.FormalMLGrammarAccess
import org.eclipse.xtext.Keyword

// This is Xtend , not Java
class FormalMLKeywordHovers {
	
	@Inject FormalMLGrammarAccess grammarAccess;
	
	protected val KEYWORD_SAMPLE = '''
			A system represents real component objects. It <ul>
			<li>can <code>extend</code> another entity, 
				i.e. inherit the features of another entity.</li>
			<li>has attributes, specification syntax 
				<code><name> : <type></code></li>
			<li>has operations, specification syntax <code>op <name> 
				(<List of Parameters>)) : <Returntype></code></li>
			</ul>
			'''
	val KEYWORD_SYSTEM = '''
			The main <code>machine</code> representing the system.
			'''
	
	val KEYWORD_MACHINE = '''
			A <code>machine</code> models symbolic behavior 
			of as a component of the system.
			'''
			
	val KEYWORD_INSTANCE = '''
			A <code>instance</code> models symbolic behavior 
			of as a component of the system.
			'''
			
	val KEYWORD_STATEMACHINE = '''
			A <code>statemachine</code> models 
			<b>symbolic state-transition machine</b> or, 
			more generally, <b>Symbolic Transition Systems a.k.a. STS</b>.
			'''
			
	val KEYWORD_AT_REGION = '''
			A <code>region</code> denotes a behavior fragment. 
			it contains a graph (possibly hierarchical) of states 
			interconnected by arcs representing transitions labelled 
			by statements.
			'''

	val KEYWORD_COMPOSITE_STATE = '''
			A <code>composite state</code> models a hierarchical component 
			where behaviors are describe with regions.
			'''
	val KEYWORD_START_STATE = '''
			A <code>start state</code> models an atomic component 
			where behaviors are describe with transition and 
			also enable and disable primitives.
			'''

	val KEYWORD_SIMPLE_STATE = '''
			A <code>state</code> models an atomic component 
			where behaviors are describe with transition and 
			also enable and disable primitives.
			'''

	val KEYWORD_FINAL_STATE = '''
			A <code>final state</code> models an atomic component 
			where behaviors are describe with transition and 
			also enable and disable primitives.
			'''

	val KEYWORD_PSEUDO_STATE = '''
			A <code>pseudo state</code> models an atomic component 
			where behaviors are describe with transition and 
			also enable and disable primitives.
			'''

	val KEYWORD_PSEUDO_INITIAL_STATE = '''
			An <code>initial state</code> models an atomic component 
			where behaviors are describe with transition and 
			also enable and disable primitives.
			'''

	val KEYWORD_PSEUDO_ENDING_STATE = '''
			An <code>ending state</code> models an atomic component 
			where behaviors are describe with transition and 
			also enable and disable primitives.
			'''

	val KEYWORD_AT_TRANSITION = '''
			This section section contains the list of transitions.
			'''

	val KEYWORD_TRANSITION = '''
			A <code>transition</code> models the reaction of a state[machine] 
			using statements, trigerred by input instructions or provided 
			by guard, with effects like assignment or or output instruction, ...
			'''

	val KEYWORD_BUFFER = '''
			A <code>buffer</code> ...
			'''

	val KEYWORD_PORT = '''
			A <code>port</code> ...
			'''

	val KEYWORD_INPUT_PORT = '''
			A <code>input port</code> ...
			'''

	val KEYWORD_OUTPU_PORT = '''
			A <code>output port</code> ...
			'''
	val KEYWORD_CONNECTOR = '''
			A <code>connector</code> ...
			'''
	val KEYWORD_CONNECT = '''
			A <code>connector</code> ...
			'''

	// Et d'autres encore


	def hoverText(Keyword k) {
		val result = switch (k) {
		case grammarAccess.systemAccess.systemKeyword_1:
			KEYWORD_SAMPLE//KEYWORD_SYSTEM
			
		case grammarAccess.machineBlockAccess.machineKeyword_1:
			KEYWORD_MACHINE
//		case grammarAccess.machineBlockAccess.machineKeyword_1d_9_0_0_1:
//			KEYWORD_MACHINE
			
		case grammarAccess.instanceMachineAccess.instanceKeyword_0:
			KEYWORD_INSTANCE
			
		case grammarAccess.statemachineAccess.statemachineKeyword_2:
			KEYWORD_STATEMACHINE
			
		case grammarAccess.statemachineRegionAccess.regionKeyword_1_0:
			KEYWORD_AT_REGION
		case grammarAccess.statemachineRegionAccess.regionKeyword_1_1_0:
			KEYWORD_AT_REGION
			
		case grammarAccess.compositeStateAccess.compositeStateKeyword_1_0:
			KEYWORD_COMPOSITE_STATE
		case grammarAccess.startStateAccess.simpleStateKeyword_1_0_0_0:
			KEYWORD_START_STATE
		case grammarAccess.finalStateAccess.simpleStateKeyword_1_0_0_0:
			KEYWORD_FINAL_STATE
		case grammarAccess.simpleStateAccess.simpleStateKeyword_1_0:
			KEYWORD_SIMPLE_STATE
			
		case grammarAccess.otherPseudostateAccess.stateKeyword_1_0:
			KEYWORD_PSEUDO_STATE
		case grammarAccess.pseudostateInitialAccess.stateKeyword_1_0_0_0:
			KEYWORD_PSEUDO_INITIAL_STATE
		case grammarAccess.endingPseudostateAccess.stateKeyword_1_0:
			KEYWORD_PSEUDO_ENDING_STATE
			
		case grammarAccess.compositeStateAccess.transitionKeyword_8_0_1_0_2_0:
			KEYWORD_AT_TRANSITION
			
		case grammarAccess.transitionAccess.transitionKeyword_2:
			KEYWORD_TRANSITION
			
//		default: "Keyword: " + k.value
		}
		result?.toString ?: null;
	}
}

