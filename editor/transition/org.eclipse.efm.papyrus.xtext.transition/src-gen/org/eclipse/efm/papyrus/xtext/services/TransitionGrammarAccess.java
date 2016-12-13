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
package org.eclipse.efm.papyrus.xtext.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class TransitionGrammarAccess extends AbstractGrammarElementFinder {
	
	public class TransitionRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.papyrus.xtext.Transition.TransitionRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cTriggersAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cTriggersTriggerRuleParserRuleCall_0_0_0 = (RuleCall)cTriggersAssignment_0_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Keyword cCommaKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Assignment cTriggersAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cTriggersTriggerRuleParserRuleCall_0_1_1_0 = (RuleCall)cTriggersAssignment_0_1_1.eContents().get(0);
		private final Assignment cGuardAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cGuardGuardRuleParserRuleCall_1_0 = (RuleCall)cGuardAssignment_1.eContents().get(0);
		private final Assignment cTguardAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTguardTGuardRuleParserRuleCall_2_0 = (RuleCall)cTguardAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cSolidusKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cEffectBodyAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cEffectBodySTRINGTerminalRuleCall_3_1_0 = (RuleCall)cEffectBodyAssignment_3_1.eContents().get(0);
		
		////Model:
		////	greetings+=Greeting*;
		////	
		////Greeting:
		////	'Hello' name=ID '!';
		/////////////////////////
		//// Transition Rule
		/////////////////////////
		//TransitionRule:
		//	(triggers+=TriggerRule (',' triggers+=TriggerRule)*)?
		//	guard=GuardRule?
		//	tguard=TGuardRule? ('/' effectBody=STRING)?;
		@Override public ParserRule getRule() { return rule; }
		
		//(triggers+=TriggerRule (',' triggers+=TriggerRule)*)? guard=GuardRule? tguard=TGuardRule? ('/' effectBody=STRING)?
		public Group getGroup() { return cGroup; }
		
		//(triggers+=TriggerRule (',' triggers+=TriggerRule)*)?
		public Group getGroup_0() { return cGroup_0; }
		
		//triggers+=TriggerRule
		public Assignment getTriggersAssignment_0_0() { return cTriggersAssignment_0_0; }
		
		//TriggerRule
		public RuleCall getTriggersTriggerRuleParserRuleCall_0_0_0() { return cTriggersTriggerRuleParserRuleCall_0_0_0; }
		
		//(',' triggers+=TriggerRule)*
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//','
		public Keyword getCommaKeyword_0_1_0() { return cCommaKeyword_0_1_0; }
		
		//triggers+=TriggerRule
		public Assignment getTriggersAssignment_0_1_1() { return cTriggersAssignment_0_1_1; }
		
		//TriggerRule
		public RuleCall getTriggersTriggerRuleParserRuleCall_0_1_1_0() { return cTriggersTriggerRuleParserRuleCall_0_1_1_0; }
		
		//guard=GuardRule?
		public Assignment getGuardAssignment_1() { return cGuardAssignment_1; }
		
		//GuardRule
		public RuleCall getGuardGuardRuleParserRuleCall_1_0() { return cGuardGuardRuleParserRuleCall_1_0; }
		
		//tguard=TGuardRule?
		public Assignment getTguardAssignment_2() { return cTguardAssignment_2; }
		
		//TGuardRule
		public RuleCall getTguardTGuardRuleParserRuleCall_2_0() { return cTguardTGuardRuleParserRuleCall_2_0; }
		
		//('/' effectBody=STRING)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'/'
		public Keyword getSolidusKeyword_3_0() { return cSolidusKeyword_3_0; }
		
		//effectBody=STRING
		public Assignment getEffectBodyAssignment_3_1() { return cEffectBodyAssignment_3_1; }
		
		//STRING
		public RuleCall getEffectBodySTRINGTerminalRuleCall_3_1_0() { return cEffectBodySTRINGTerminalRuleCall_3_1_0; }
	}
	public class FQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.papyrus.xtext.Transition.FQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_1_0 = (Alternatives)cGroup_1.eContents().get(0);
		private final Keyword cFullStopKeyword_1_0_0 = (Keyword)cAlternatives_1_0.eContents().get(0);
		private final Keyword cColonColonKeyword_1_0_1 = (Keyword)cAlternatives_1_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		/////////////////////////
		//// [ Fully  [ Qualified ] ] Name
		/////////////////////////
		//FQN:
		//	ID (('.' | '::') ID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ID (('.' | '::') ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//(('.' | '::') ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//('.' | '::')
		public Alternatives getAlternatives_1_0() { return cAlternatives_1_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0_0() { return cFullStopKeyword_1_0_0; }
		
		//'::'
		public Keyword getColonColonKeyword_1_0_1() { return cColonColonKeyword_1_0_1; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	public class TriggerRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.papyrus.xtext.Transition.TriggerRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInputKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPortAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cPortNamedElementCrossReference_1_0 = (CrossReference)cPortAssignment_1.eContents().get(0);
		private final RuleCall cPortNamedElementFQNParserRuleCall_1_0_1 = (RuleCall)cPortNamedElementCrossReference_1_0.eContents().get(1);
		private final Assignment cEventAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cEventEventRuleParserRuleCall_2_0 = (RuleCall)cEventAssignment_2.eContents().get(0);
		
		////////////////////////
		//// EVENTS
		////////////////////////
		//TriggerRule:
		//	"input" / *(path=QualifiedName)?* / port=[uml::NamedElement|FQN] event=EventRule?;
		@Override public ParserRule getRule() { return rule; }
		
		//"input" / *(path=QualifiedName)?* / port=[uml::NamedElement|FQN] event=EventRule?
		public Group getGroup() { return cGroup; }
		
		//"input"
		public Keyword getInputKeyword_0() { return cInputKeyword_0; }
		
		/// *(path=QualifiedName)?* / port=[uml::NamedElement|FQN]
		public Assignment getPortAssignment_1() { return cPortAssignment_1; }
		
		//[uml::NamedElement|FQN]
		public CrossReference getPortNamedElementCrossReference_1_0() { return cPortNamedElementCrossReference_1_0; }
		
		//FQN
		public RuleCall getPortNamedElementFQNParserRuleCall_1_0_1() { return cPortNamedElementFQNParserRuleCall_1_0_1; }
		
		//event=EventRule?
		public Assignment getEventAssignment_2() { return cEventAssignment_2; }
		
		//EventRule
		public RuleCall getEventEventRuleParserRuleCall_2_0() { return cEventEventRuleParserRuleCall_2_0; }
	}
	public class EventRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.papyrus.xtext.Transition.EventRule");
		private final RuleCall cReceiveSignalEventRuleParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//EventRule:
		//	ReceiveSignalEventRule
		//	//	|CallOrSignalEventRule
		//	//	| AnyReceiveEventRule
		//	//	| TimeEventRule
		//	//	| ChangeEventRule
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ReceiveSignalEventRule
		public RuleCall getReceiveSignalEventRuleParserRuleCall() { return cReceiveSignalEventRuleParserRuleCall; }
	}
	public class ReceiveSignalEventRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.papyrus.xtext.Transition.ReceiveSignalEventRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cReceiveSignalEventRuleAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cParametersAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final CrossReference cParametersPropertyCrossReference_2_0_0 = (CrossReference)cParametersAssignment_2_0.eContents().get(0);
		private final RuleCall cParametersPropertyFQNParserRuleCall_2_0_0_1 = (RuleCall)cParametersPropertyCrossReference_2_0_0.eContents().get(1);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cParametersAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final CrossReference cParametersPropertyCrossReference_2_1_1_0 = (CrossReference)cParametersAssignment_2_1_1.eContents().get(0);
		private final RuleCall cParametersPropertyFQNParserRuleCall_2_1_1_0_1 = (RuleCall)cParametersPropertyCrossReference_2_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ReceiveSignalEventRule:
		//	{ReceiveSignalEventRule}
		//	'(' (parameters+=[uml::Property|FQN] (',' parameters+=[uml::Property|FQN])*)? ')';
		@Override public ParserRule getRule() { return rule; }
		
		//{ReceiveSignalEventRule} '(' (parameters+=[uml::Property|FQN] (',' parameters+=[uml::Property|FQN])*)? ')'
		public Group getGroup() { return cGroup; }
		
		//{ReceiveSignalEventRule}
		public Action getReceiveSignalEventRuleAction_0() { return cReceiveSignalEventRuleAction_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//(parameters+=[uml::Property|FQN] (',' parameters+=[uml::Property|FQN])*)?
		public Group getGroup_2() { return cGroup_2; }
		
		//parameters+=[uml::Property|FQN]
		public Assignment getParametersAssignment_2_0() { return cParametersAssignment_2_0; }
		
		//[uml::Property|FQN]
		public CrossReference getParametersPropertyCrossReference_2_0_0() { return cParametersPropertyCrossReference_2_0_0; }
		
		//FQN
		public RuleCall getParametersPropertyFQNParserRuleCall_2_0_0_1() { return cParametersPropertyFQNParserRuleCall_2_0_0_1; }
		
		//(',' parameters+=[uml::Property|FQN])*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }
		
		//parameters+=[uml::Property|FQN]
		public Assignment getParametersAssignment_2_1_1() { return cParametersAssignment_2_1_1; }
		
		//[uml::Property|FQN]
		public CrossReference getParametersPropertyCrossReference_2_1_1_0() { return cParametersPropertyCrossReference_2_1_1_0; }
		
		//FQN
		public RuleCall getParametersPropertyFQNParserRuleCall_2_1_1_0_1() { return cParametersPropertyFQNParserRuleCall_2_1_1_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}
	public class GuardRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.papyrus.xtext.Transition.GuardRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cConstraintAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cConstraintSTRINGTerminalRuleCall_1_0 = (RuleCall)cConstraintAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		/// *QualifiedName :
		//	path=[uml::Namespace]'::' (remaining=QualifiedName)? ; * / ///////////////////////
		//// GUARD
		/////////////////////////
		//GuardRule:
		//	'[' constraint=STRING ']';
		@Override public ParserRule getRule() { return rule; }
		
		//'[' constraint=STRING ']'
		public Group getGroup() { return cGroup; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }
		
		//constraint=STRING
		public Assignment getConstraintAssignment_1() { return cConstraintAssignment_1; }
		
		//STRING
		public RuleCall getConstraintSTRINGTerminalRuleCall_1_0() { return cConstraintSTRINGTerminalRuleCall_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}
	public class TGuardRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.papyrus.xtext.Transition.TGuardRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cConstraintAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cConstraintSTRINGTerminalRuleCall_1_0 = (RuleCall)cConstraintAssignment_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		/////////////////////////
		//// TGUARD
		/////////////////////////
		//TGuardRule:
		//	'{' constraint=STRING '}';
		@Override public ParserRule getRule() { return rule; }
		
		//'{' constraint=STRING '}'
		public Group getGroup() { return cGroup; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }
		
		//constraint=STRING
		public Assignment getConstraintAssignment_1() { return cConstraintAssignment_1; }
		
		//STRING
		public RuleCall getConstraintSTRINGTerminalRuleCall_1_0() { return cConstraintSTRINGTerminalRuleCall_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2() { return cRightCurlyBracketKeyword_2; }
	}
	
	
	private final TransitionRuleElements pTransitionRule;
	private final FQNElements pFQN;
	private final TriggerRuleElements pTriggerRule;
	private final EventRuleElements pEventRule;
	private final ReceiveSignalEventRuleElements pReceiveSignalEventRule;
	private final GuardRuleElements pGuardRule;
	private final TGuardRuleElements pTGuardRule;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public TransitionGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pTransitionRule = new TransitionRuleElements();
		this.pFQN = new FQNElements();
		this.pTriggerRule = new TriggerRuleElements();
		this.pEventRule = new EventRuleElements();
		this.pReceiveSignalEventRule = new ReceiveSignalEventRuleElements();
		this.pGuardRule = new GuardRuleElements();
		this.pTGuardRule = new TGuardRuleElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.efm.papyrus.xtext.Transition".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	////Model:
	////	greetings+=Greeting*;
	////	
	////Greeting:
	////	'Hello' name=ID '!';
	/////////////////////////
	//// Transition Rule
	/////////////////////////
	//TransitionRule:
	//	(triggers+=TriggerRule (',' triggers+=TriggerRule)*)?
	//	guard=GuardRule?
	//	tguard=TGuardRule? ('/' effectBody=STRING)?;
	public TransitionRuleElements getTransitionRuleAccess() {
		return pTransitionRule;
	}
	
	public ParserRule getTransitionRuleRule() {
		return getTransitionRuleAccess().getRule();
	}
	
	/////////////////////////
	//// [ Fully  [ Qualified ] ] Name
	/////////////////////////
	//FQN:
	//	ID (('.' | '::') ID)*;
	public FQNElements getFQNAccess() {
		return pFQN;
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}
	
	////////////////////////
	//// EVENTS
	////////////////////////
	//TriggerRule:
	//	"input" / *(path=QualifiedName)?* / port=[uml::NamedElement|FQN] event=EventRule?;
	public TriggerRuleElements getTriggerRuleAccess() {
		return pTriggerRule;
	}
	
	public ParserRule getTriggerRuleRule() {
		return getTriggerRuleAccess().getRule();
	}
	
	//EventRule:
	//	ReceiveSignalEventRule
	//	//	|CallOrSignalEventRule
	//	//	| AnyReceiveEventRule
	//	//	| TimeEventRule
	//	//	| ChangeEventRule
	//;
	public EventRuleElements getEventRuleAccess() {
		return pEventRule;
	}
	
	public ParserRule getEventRuleRule() {
		return getEventRuleAccess().getRule();
	}
	
	//ReceiveSignalEventRule:
	//	{ReceiveSignalEventRule}
	//	'(' (parameters+=[uml::Property|FQN] (',' parameters+=[uml::Property|FQN])*)? ')';
	public ReceiveSignalEventRuleElements getReceiveSignalEventRuleAccess() {
		return pReceiveSignalEventRule;
	}
	
	public ParserRule getReceiveSignalEventRuleRule() {
		return getReceiveSignalEventRuleAccess().getRule();
	}
	
	/// *QualifiedName :
	//	path=[uml::Namespace]'::' (remaining=QualifiedName)? ; * / ///////////////////////
	//// GUARD
	/////////////////////////
	//GuardRule:
	//	'[' constraint=STRING ']';
	public GuardRuleElements getGuardRuleAccess() {
		return pGuardRule;
	}
	
	public ParserRule getGuardRuleRule() {
		return getGuardRuleAccess().getRule();
	}
	
	/////////////////////////
	//// TGUARD
	/////////////////////////
	//TGuardRule:
	//	'{' constraint=STRING '}';
	public TGuardRuleElements getTGuardRuleAccess() {
		return pTGuardRule;
	}
	
	public ParserRule getTGuardRuleRule() {
		return getTGuardRuleAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/ *'->'* /';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
