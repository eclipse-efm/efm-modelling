/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
*  - Initial API and implementation
*****************************************************************************/
grammar InternalTransition;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package org.eclipse.efm.papyrus.xtext.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.efm.papyrus.xtext.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.efm.papyrus.xtext.services.TransitionGrammarAccess;

}
@parser::members {
	private TransitionGrammarAccess grammarAccess;

	public void setGrammarAccess(TransitionGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleTransitionRule
entryRuleTransitionRule
:
{ before(grammarAccess.getTransitionRuleRule()); }
	 ruleTransitionRule
{ after(grammarAccess.getTransitionRuleRule()); } 
	 EOF 
;

// Rule TransitionRule
ruleTransitionRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTransitionRuleAccess().getGroup()); }
		(rule__TransitionRule__Group__0)
		{ after(grammarAccess.getTransitionRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFQN
entryRuleFQN
:
{ before(grammarAccess.getFQNRule()); }
	 ruleFQN
{ after(grammarAccess.getFQNRule()); } 
	 EOF 
;

// Rule FQN
ruleFQN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFQNAccess().getGroup()); }
		(rule__FQN__Group__0)
		{ after(grammarAccess.getFQNAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTriggerRule
entryRuleTriggerRule
:
{ before(grammarAccess.getTriggerRuleRule()); }
	 ruleTriggerRule
{ after(grammarAccess.getTriggerRuleRule()); } 
	 EOF 
;

// Rule TriggerRule
ruleTriggerRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTriggerRuleAccess().getGroup()); }
		(rule__TriggerRule__Group__0)
		{ after(grammarAccess.getTriggerRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEventRule
entryRuleEventRule
:
{ before(grammarAccess.getEventRuleRule()); }
	 ruleEventRule
{ after(grammarAccess.getEventRuleRule()); } 
	 EOF 
;

// Rule EventRule
ruleEventRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEventRuleAccess().getReceiveSignalEventRuleParserRuleCall()); }
		ruleReceiveSignalEventRule
		{ after(grammarAccess.getEventRuleAccess().getReceiveSignalEventRuleParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReceiveSignalEventRule
entryRuleReceiveSignalEventRule
:
{ before(grammarAccess.getReceiveSignalEventRuleRule()); }
	 ruleReceiveSignalEventRule
{ after(grammarAccess.getReceiveSignalEventRuleRule()); } 
	 EOF 
;

// Rule ReceiveSignalEventRule
ruleReceiveSignalEventRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReceiveSignalEventRuleAccess().getGroup()); }
		(rule__ReceiveSignalEventRule__Group__0)
		{ after(grammarAccess.getReceiveSignalEventRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleGuardRule
entryRuleGuardRule
:
{ before(grammarAccess.getGuardRuleRule()); }
	 ruleGuardRule
{ after(grammarAccess.getGuardRuleRule()); } 
	 EOF 
;

// Rule GuardRule
ruleGuardRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getGuardRuleAccess().getGroup()); }
		(rule__GuardRule__Group__0)
		{ after(grammarAccess.getGuardRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTGuardRule
entryRuleTGuardRule
:
{ before(grammarAccess.getTGuardRuleRule()); }
	 ruleTGuardRule
{ after(grammarAccess.getTGuardRuleRule()); } 
	 EOF 
;

// Rule TGuardRule
ruleTGuardRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTGuardRuleAccess().getGroup()); }
		(rule__TGuardRule__Group__0)
		{ after(grammarAccess.getTGuardRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Alternatives_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0_0()); }
		'.'
		{ after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getFQNAccess().getColonColonKeyword_1_0_1()); }
		'::'
		{ after(grammarAccess.getFQNAccess().getColonColonKeyword_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group__0__Impl
	rule__TransitionRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getGroup_0()); }
	(rule__TransitionRule__Group_0__0)?
	{ after(grammarAccess.getTransitionRuleAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group__1__Impl
	rule__TransitionRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getGuardAssignment_1()); }
	(rule__TransitionRule__GuardAssignment_1)?
	{ after(grammarAccess.getTransitionRuleAccess().getGuardAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group__2__Impl
	rule__TransitionRule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getTguardAssignment_2()); }
	(rule__TransitionRule__TguardAssignment_2)?
	{ after(grammarAccess.getTransitionRuleAccess().getTguardAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getGroup_3()); }
	(rule__TransitionRule__Group_3__0)?
	{ after(grammarAccess.getTransitionRuleAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionRule__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group_0__0__Impl
	rule__TransitionRule__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_0()); }
	(rule__TransitionRule__TriggersAssignment_0_0)
	{ after(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getGroup_0_1()); }
	(rule__TransitionRule__Group_0_1__0)*
	{ after(grammarAccess.getTransitionRuleAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionRule__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group_0_1__0__Impl
	rule__TransitionRule__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0()); }
	','
	{ after(grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_1_1()); }
	(rule__TransitionRule__TriggersAssignment_0_1_1)
	{ after(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionRule__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group_3__0__Impl
	rule__TransitionRule__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getSolidusKeyword_3_0()); }
	'/'
	{ after(grammarAccess.getTransitionRuleAccess().getSolidusKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TransitionRule__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransitionRuleAccess().getEffectBodyAssignment_3_1()); }
	(rule__TransitionRule__EffectBodyAssignment_3_1)
	{ after(grammarAccess.getTransitionRuleAccess().getEffectBodyAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FQN__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FQN__Group__0__Impl
	rule__FQN__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
	{ after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FQN__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFQNAccess().getGroup_1()); }
	(rule__FQN__Group_1__0)*
	{ after(grammarAccess.getFQNAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FQN__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FQN__Group_1__0__Impl
	rule__FQN__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFQNAccess().getAlternatives_1_0()); }
	(rule__FQN__Alternatives_1_0)
	{ after(grammarAccess.getFQNAccess().getAlternatives_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FQN__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
	{ after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TriggerRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TriggerRule__Group__0__Impl
	rule__TriggerRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TriggerRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriggerRuleAccess().getInputKeyword_0()); }
	'input'
	{ after(grammarAccess.getTriggerRuleAccess().getInputKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TriggerRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TriggerRule__Group__1__Impl
	rule__TriggerRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TriggerRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriggerRuleAccess().getPortAssignment_1()); }
	(rule__TriggerRule__PortAssignment_1)
	{ after(grammarAccess.getTriggerRuleAccess().getPortAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TriggerRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TriggerRule__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TriggerRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriggerRuleAccess().getEventAssignment_2()); }
	(rule__TriggerRule__EventAssignment_2)?
	{ after(grammarAccess.getTriggerRuleAccess().getEventAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReceiveSignalEventRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReceiveSignalEventRule__Group__0__Impl
	rule__ReceiveSignalEventRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReceiveSignalEventRuleAccess().getReceiveSignalEventRuleAction_0()); }
	()
	{ after(grammarAccess.getReceiveSignalEventRuleAccess().getReceiveSignalEventRuleAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReceiveSignalEventRule__Group__1__Impl
	rule__ReceiveSignalEventRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReceiveSignalEventRuleAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getReceiveSignalEventRuleAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReceiveSignalEventRule__Group__2__Impl
	rule__ReceiveSignalEventRule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReceiveSignalEventRuleAccess().getGroup_2()); }
	(rule__ReceiveSignalEventRule__Group_2__0)?
	{ after(grammarAccess.getReceiveSignalEventRuleAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReceiveSignalEventRule__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReceiveSignalEventRuleAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getReceiveSignalEventRuleAccess().getRightParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReceiveSignalEventRule__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReceiveSignalEventRule__Group_2__0__Impl
	rule__ReceiveSignalEventRule__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReceiveSignalEventRuleAccess().getParametersAssignment_2_0()); }
	(rule__ReceiveSignalEventRule__ParametersAssignment_2_0)
	{ after(grammarAccess.getReceiveSignalEventRuleAccess().getParametersAssignment_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReceiveSignalEventRule__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReceiveSignalEventRuleAccess().getGroup_2_1()); }
	(rule__ReceiveSignalEventRule__Group_2_1__0)*
	{ after(grammarAccess.getReceiveSignalEventRuleAccess().getGroup_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReceiveSignalEventRule__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReceiveSignalEventRule__Group_2_1__0__Impl
	rule__ReceiveSignalEventRule__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReceiveSignalEventRuleAccess().getCommaKeyword_2_1_0()); }
	','
	{ after(grammarAccess.getReceiveSignalEventRuleAccess().getCommaKeyword_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReceiveSignalEventRule__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReceiveSignalEventRuleAccess().getParametersAssignment_2_1_1()); }
	(rule__ReceiveSignalEventRule__ParametersAssignment_2_1_1)
	{ after(grammarAccess.getReceiveSignalEventRuleAccess().getParametersAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__GuardRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GuardRule__Group__0__Impl
	rule__GuardRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0()); }
	'['
	{ after(grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GuardRule__Group__1__Impl
	rule__GuardRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGuardRuleAccess().getConstraintAssignment_1()); }
	(rule__GuardRule__ConstraintAssignment_1)
	{ after(grammarAccess.getGuardRuleAccess().getConstraintAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GuardRule__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2()); }
	']'
	{ after(grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TGuardRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TGuardRule__Group__0__Impl
	rule__TGuardRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TGuardRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTGuardRuleAccess().getLeftCurlyBracketKeyword_0()); }
	'{'
	{ after(grammarAccess.getTGuardRuleAccess().getLeftCurlyBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TGuardRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TGuardRule__Group__1__Impl
	rule__TGuardRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TGuardRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTGuardRuleAccess().getConstraintAssignment_1()); }
	(rule__TGuardRule__ConstraintAssignment_1)
	{ after(grammarAccess.getTGuardRuleAccess().getConstraintAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TGuardRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TGuardRule__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TGuardRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTGuardRuleAccess().getRightCurlyBracketKeyword_2()); }
	'}'
	{ after(grammarAccess.getTGuardRuleAccess().getRightCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionRule__TriggersAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransitionRuleAccess().getTriggersTriggerRuleParserRuleCall_0_0_0()); }
		ruleTriggerRule
		{ after(grammarAccess.getTransitionRuleAccess().getTriggersTriggerRuleParserRuleCall_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__TriggersAssignment_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransitionRuleAccess().getTriggersTriggerRuleParserRuleCall_0_1_1_0()); }
		ruleTriggerRule
		{ after(grammarAccess.getTransitionRuleAccess().getTriggersTriggerRuleParserRuleCall_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__GuardAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0()); }
		ruleGuardRule
		{ after(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__TguardAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransitionRuleAccess().getTguardTGuardRuleParserRuleCall_2_0()); }
		ruleTGuardRule
		{ after(grammarAccess.getTransitionRuleAccess().getTguardTGuardRuleParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRule__EffectBodyAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransitionRuleAccess().getEffectBodySTRINGTerminalRuleCall_3_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getTransitionRuleAccess().getEffectBodySTRINGTerminalRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TriggerRule__PortAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTriggerRuleAccess().getPortNamedElementCrossReference_1_0()); }
		(
			{ before(grammarAccess.getTriggerRuleAccess().getPortNamedElementFQNParserRuleCall_1_0_1()); }
			ruleFQN
			{ after(grammarAccess.getTriggerRuleAccess().getPortNamedElementFQNParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getTriggerRuleAccess().getPortNamedElementCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TriggerRule__EventAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTriggerRuleAccess().getEventEventRuleParserRuleCall_2_0()); }
		ruleEventRule
		{ after(grammarAccess.getTriggerRuleAccess().getEventEventRuleParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__ParametersAssignment_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyCrossReference_2_0_0()); }
		(
			{ before(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyFQNParserRuleCall_2_0_0_1()); }
			ruleFQN
			{ after(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyFQNParserRuleCall_2_0_0_1()); }
		)
		{ after(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyCrossReference_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReceiveSignalEventRule__ParametersAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyCrossReference_2_1_1_0()); }
		(
			{ before(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyFQNParserRuleCall_2_1_1_0_1()); }
			ruleFQN
			{ after(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyFQNParserRuleCall_2_1_1_0_1()); }
		)
		{ after(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyCrossReference_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardRule__ConstraintAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TGuardRule__ConstraintAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getTGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
