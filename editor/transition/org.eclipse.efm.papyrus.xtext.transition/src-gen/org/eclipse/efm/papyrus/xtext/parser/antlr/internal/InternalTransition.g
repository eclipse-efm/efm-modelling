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
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.efm.papyrus.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.efm.papyrus.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.efm.papyrus.xtext.services.TransitionGrammarAccess;

}

@parser::members {

 	private TransitionGrammarAccess grammarAccess;

    public InternalTransitionParser(TokenStream input, TransitionGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "TransitionRule";
   	}

   	@Override
   	protected TransitionGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleTransitionRule
entryRuleTransitionRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionRuleRule()); }
	iv_ruleTransitionRule=ruleTransitionRule
	{ $current=$iv_ruleTransitionRule.current; }
	EOF;

// Rule TransitionRule
ruleTransitionRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersTriggerRuleParserRuleCall_0_0_0());
					}
					lv_triggers_0_0=ruleTriggerRule
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
						}
						add(
							$current,
							"triggers",
							lv_triggers_0_0,
							"org.eclipse.efm.papyrus.xtext.Transition.TriggerRule");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_1=','
				{
					newLeafNode(otherlv_1, grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersTriggerRuleParserRuleCall_0_1_1_0());
						}
						lv_triggers_2_0=ruleTriggerRule
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
							}
							add(
								$current,
								"triggers",
								lv_triggers_2_0,
								"org.eclipse.efm.papyrus.xtext.Transition.TriggerRule");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0());
				}
				lv_guard_3_0=ruleGuardRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
					}
					set(
						$current,
						"guard",
						lv_guard_3_0,
						"org.eclipse.efm.papyrus.xtext.Transition.GuardRule");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionRuleAccess().getTguardTGuardRuleParserRuleCall_2_0());
				}
				lv_tguard_4_0=ruleTGuardRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
					}
					set(
						$current,
						"tguard",
						lv_tguard_4_0,
						"org.eclipse.efm.papyrus.xtext.Transition.TGuardRule");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_5='/'
			{
				newLeafNode(otherlv_5, grammarAccess.getTransitionRuleAccess().getSolidusKeyword_3_0());
			}
			(
				(
					lv_effectBody_6_0=RULE_STRING
					{
						newLeafNode(lv_effectBody_6_0, grammarAccess.getTransitionRuleAccess().getEffectBodySTRINGTerminalRuleCall_3_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTransitionRuleRule());
						}
						setWithLastConsumed(
							$current,
							"effectBody",
							lv_effectBody_6_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleFQN
entryRuleFQN returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFQNRule()); }
	iv_ruleFQN=ruleFQN
	{ $current=$iv_ruleFQN.current.getText(); }
	EOF;

// Rule FQN
ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
		}
		(
			(
				kw='.'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0_0());
				}
				    |
				kw='::'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getFQNAccess().getColonColonKeyword_1_0_1());
				}
			)
			this_ID_3=RULE_ID
			{
				$current.merge(this_ID_3);
			}
			{
				newLeafNode(this_ID_3, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

// Entry rule entryRuleTriggerRule
entryRuleTriggerRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTriggerRuleRule()); }
	iv_ruleTriggerRule=ruleTriggerRule
	{ $current=$iv_ruleTriggerRule.current; }
	EOF;

// Rule TriggerRule
ruleTriggerRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='input'
		{
			newLeafNode(otherlv_0, grammarAccess.getTriggerRuleAccess().getInputKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTriggerRuleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTriggerRuleAccess().getPortNamedElementCrossReference_1_0());
				}
				ruleFQN
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getTriggerRuleAccess().getEventEventRuleParserRuleCall_2_0());
				}
				lv_event_2_0=ruleEventRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTriggerRuleRule());
					}
					set(
						$current,
						"event",
						lv_event_2_0,
						"org.eclipse.efm.papyrus.xtext.Transition.EventRule");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleEventRule
entryRuleEventRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventRuleRule()); }
	iv_ruleEventRule=ruleEventRule
	{ $current=$iv_ruleEventRule.current; }
	EOF;

// Rule EventRule
ruleEventRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getEventRuleAccess().getReceiveSignalEventRuleParserRuleCall());
	}
	this_ReceiveSignalEventRule_0=ruleReceiveSignalEventRule
	{
		$current = $this_ReceiveSignalEventRule_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleReceiveSignalEventRule
entryRuleReceiveSignalEventRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReceiveSignalEventRuleRule()); }
	iv_ruleReceiveSignalEventRule=ruleReceiveSignalEventRule
	{ $current=$iv_ruleReceiveSignalEventRule.current; }
	EOF;

// Rule ReceiveSignalEventRule
ruleReceiveSignalEventRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getReceiveSignalEventRuleAccess().getReceiveSignalEventRuleAction_0(),
					$current);
			}
		)
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getReceiveSignalEventRuleAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReceiveSignalEventRuleRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyCrossReference_2_0_0());
					}
					ruleFQN
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getReceiveSignalEventRuleAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getReceiveSignalEventRuleRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyCrossReference_2_1_1_0());
						}
						ruleFQN
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getReceiveSignalEventRuleAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleGuardRule
entryRuleGuardRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGuardRuleRule()); }
	iv_ruleGuardRule=ruleGuardRule
	{ $current=$iv_ruleGuardRule.current; }
	EOF;

// Rule GuardRule
ruleGuardRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
		{
			newLeafNode(otherlv_0, grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0());
		}
		(
			(
				lv_constraint_1_0=RULE_STRING
				{
					newLeafNode(lv_constraint_1_0, grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getGuardRuleRule());
					}
					setWithLastConsumed(
						$current,
						"constraint",
						lv_constraint_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_2=']'
		{
			newLeafNode(otherlv_2, grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2());
		}
	)
;

// Entry rule entryRuleTGuardRule
entryRuleTGuardRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTGuardRuleRule()); }
	iv_ruleTGuardRule=ruleTGuardRule
	{ $current=$iv_ruleTGuardRule.current; }
	EOF;

// Rule TGuardRule
ruleTGuardRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='{'
		{
			newLeafNode(otherlv_0, grammarAccess.getTGuardRuleAccess().getLeftCurlyBracketKeyword_0());
		}
		(
			(
				lv_constraint_1_0=RULE_STRING
				{
					newLeafNode(lv_constraint_1_0, grammarAccess.getTGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTGuardRuleRule());
					}
					setWithLastConsumed(
						$current,
						"constraint",
						lv_constraint_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_2='}'
		{
			newLeafNode(otherlv_2, grammarAccess.getTGuardRuleAccess().getRightCurlyBracketKeyword_2());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
