/*****************************************************************************
* Copyright (c) 2018 CEA LIST.
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
grammar InternalSEW;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

@lexer::header {
package org.eclipse.efm.sew.xtext.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.efm.sew.xtext.ide.contentassist.antlr.internal;

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
import org.eclipse.efm.sew.xtext.services.SEWGrammarAccess;

}
@parser::members {
	private SEWGrammarAccess grammarAccess;

	public void setGrammarAccess(SEWGrammarAccess grammarAccess) {
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

// Entry rule entryRuleWorkflow
entryRuleWorkflow
:
{ before(grammarAccess.getWorkflowRule()); }
	 ruleWorkflow
{ after(grammarAccess.getWorkflowRule()); } 
	 EOF 
;

// Rule Workflow
ruleWorkflow 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getWorkflowAccess().getGroup()); }
		(rule__Workflow__Group__0)
		{ after(grammarAccess.getWorkflowAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleProlog
entryRuleProlog
:
{ before(grammarAccess.getPrologRule()); }
	 ruleProlog
{ after(grammarAccess.getPrologRule()); } 
	 EOF 
;

// Rule Prolog
ruleProlog 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPrologAccess().getGroup()); }
		(rule__Prolog__Group__0)
		{ after(grammarAccess.getPrologAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReservedWord
entryRuleReservedWord
:
{ before(grammarAccess.getReservedWordRule()); }
	 ruleReservedWord
{ after(grammarAccess.getReservedWordRule()); } 
	 EOF 
;

// Rule ReservedWord
ruleReservedWord 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReservedWordAccess().getAlternatives()); }
		(rule__ReservedWord__Alternatives)
		{ after(grammarAccess.getReservedWordAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXID
entryRuleXID
:
{ before(grammarAccess.getXIDRule()); }
	 ruleXID
{ after(grammarAccess.getXIDRule()); } 
	 EOF 
;

// Rule XID
ruleXID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXIDAccess().getAlternatives()); }
		(rule__XID__Alternatives)
		{ after(grammarAccess.getXIDAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUFI
entryRuleUFI
:
{ before(grammarAccess.getUFIRule()); }
	 ruleUFI
{ after(grammarAccess.getUFIRule()); } 
	 EOF 
;

// Rule UFI
ruleUFI 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUFIAccess().getGroup()); }
		(rule__UFI__Group__0)
		{ after(grammarAccess.getUFIAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleObject
entryRuleObject
:
{ before(grammarAccess.getObjectRule()); }
	 ruleObject
{ after(grammarAccess.getObjectRule()); } 
	 EOF 
;

// Rule Object
ruleObject 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getObjectAccess().getAlternatives()); }
		(rule__Object__Alternatives)
		{ after(grammarAccess.getObjectAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleProperty
entryRuleProperty
:
{ before(grammarAccess.getPropertyRule()); }
	 ruleProperty
{ after(grammarAccess.getPropertyRule()); } 
	 EOF 
;

// Rule Property
ruleProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPropertyAccess().getAlternatives()); }
		(rule__Property__Alternatives)
		{ after(grammarAccess.getPropertyAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSection
entryRuleSection
:
{ before(grammarAccess.getSectionRule()); }
	 ruleSection
{ after(grammarAccess.getSectionRule()); } 
	 EOF 
;

// Rule Section
ruleSection 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSectionAccess().getGroup()); }
		(rule__Section__Group__0)
		{ after(grammarAccess.getSectionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAttribute
entryRuleAttribute
:
{ before(grammarAccess.getAttributeRule()); }
	 ruleAttribute
{ after(grammarAccess.getAttributeRule()); } 
	 EOF 
;

// Rule Attribute
ruleAttribute 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAttributeAccess().getGroup()); }
		(rule__Attribute__Group__0)
		{ after(grammarAccess.getAttributeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleValueSpecification
entryRuleValueSpecification
:
{ before(grammarAccess.getValueSpecificationRule()); }
	 ruleValueSpecification
{ after(grammarAccess.getValueSpecificationRule()); } 
	 EOF 
;

// Rule ValueSpecification
ruleValueSpecification 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall()); }
		ruleExpression
		{ after(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExpression
entryRuleExpression
:
{ before(grammarAccess.getExpressionRule()); }
	 ruleExpression
{ after(grammarAccess.getExpressionRule()); } 
	 EOF 
;

// Rule Expression
ruleExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpressionAccess().getAlternatives()); }
		(rule__Expression__Alternatives)
		{ after(grammarAccess.getExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleconditionalExpression
entryRuleconditionalExpression
:
{ before(grammarAccess.getConditionalExpressionRule()); }
	 ruleconditionalExpression
{ after(grammarAccess.getConditionalExpressionRule()); } 
	 EOF 
;

// Rule conditionalExpression
ruleconditionalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConditionalExpressionAccess().getGroup()); }
		(rule__ConditionalExpression__Group__0)
		{ after(grammarAccess.getConditionalExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleconditionalOrExpression
entryRuleconditionalOrExpression
:
{ before(grammarAccess.getConditionalOrExpressionRule()); }
	 ruleconditionalOrExpression
{ after(grammarAccess.getConditionalOrExpressionRule()); } 
	 EOF 
;

// Rule conditionalOrExpression
ruleconditionalOrExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConditionalOrExpressionAccess().getGroup()); }
		(rule__ConditionalOrExpression__Group__0)
		{ after(grammarAccess.getConditionalOrExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleconditionalAndExpression
entryRuleconditionalAndExpression
:
{ before(grammarAccess.getConditionalAndExpressionRule()); }
	 ruleconditionalAndExpression
{ after(grammarAccess.getConditionalAndExpressionRule()); } 
	 EOF 
;

// Rule conditionalAndExpression
ruleconditionalAndExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConditionalAndExpressionAccess().getGroup()); }
		(rule__ConditionalAndExpression__Group__0)
		{ after(grammarAccess.getConditionalAndExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleequalityExpression
entryRuleequalityExpression
:
{ before(grammarAccess.getEqualityExpressionRule()); }
	 ruleequalityExpression
{ after(grammarAccess.getEqualityExpressionRule()); } 
	 EOF 
;

// Rule equalityExpression
ruleequalityExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEqualityExpressionAccess().getGroup()); }
		(rule__EqualityExpression__Group__0)
		{ after(grammarAccess.getEqualityExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulerelationalExpression
entryRulerelationalExpression
:
{ before(grammarAccess.getRelationalExpressionRule()); }
	 rulerelationalExpression
{ after(grammarAccess.getRelationalExpressionRule()); } 
	 EOF 
;

// Rule relationalExpression
rulerelationalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getGroup()); }
		(rule__RelationalExpression__Group__0)
		{ after(grammarAccess.getRelationalExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleadditiveExpression
entryRuleadditiveExpression
:
{ before(grammarAccess.getAdditiveExpressionRule()); }
	 ruleadditiveExpression
{ after(grammarAccess.getAdditiveExpressionRule()); } 
	 EOF 
;

// Rule additiveExpression
ruleadditiveExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAdditiveExpressionAccess().getGroup()); }
		(rule__AdditiveExpression__Group__0)
		{ after(grammarAccess.getAdditiveExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulemultiplicativeExpression
entryRulemultiplicativeExpression
:
{ before(grammarAccess.getMultiplicativeExpressionRule()); }
	 rulemultiplicativeExpression
{ after(grammarAccess.getMultiplicativeExpressionRule()); } 
	 EOF 
;

// Rule multiplicativeExpression
rulemultiplicativeExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); }
		(rule__MultiplicativeExpression__Group__0)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleprimaryExpression
entryRuleprimaryExpression
:
{ before(grammarAccess.getPrimaryExpressionRule()); }
	 ruleprimaryExpression
{ after(grammarAccess.getPrimaryExpressionRule()); } 
	 EOF 
;

// Rule primaryExpression
ruleprimaryExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); }
		(rule__PrimaryExpression__Alternatives)
		{ after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralExpression
entryRuleLiteralExpression
:
{ before(grammarAccess.getLiteralExpressionRule()); }
	 ruleLiteralExpression
{ after(grammarAccess.getLiteralExpressionRule()); } 
	 EOF 
;

// Rule LiteralExpression
ruleLiteralExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getAlternatives()); }
		(rule__LiteralExpression__Alternatives)
		{ after(grammarAccess.getLiteralExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralArrayValue
entryRuleLiteralArrayValue
:
{ before(grammarAccess.getLiteralArrayValueRule()); }
	 ruleLiteralArrayValue
{ after(grammarAccess.getLiteralArrayValueRule()); } 
	 EOF 
;

// Rule LiteralArrayValue
ruleLiteralArrayValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralArrayValueAccess().getGroup()); }
		(rule__LiteralArrayValue__Group__0)
		{ after(grammarAccess.getLiteralArrayValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralObjectReference
entryRuleLiteralObjectReference
:
{ before(grammarAccess.getLiteralObjectReferenceRule()); }
	 ruleLiteralObjectReference
{ after(grammarAccess.getLiteralObjectReferenceRule()); } 
	 EOF 
;

// Rule LiteralObjectReference
ruleLiteralObjectReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralObjectReferenceAccess().getGroup()); }
		(rule__LiteralObjectReference__Group__0)
		{ after(grammarAccess.getLiteralObjectReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralBooleanValue
entryRuleLiteralBooleanValue
:
{ before(grammarAccess.getLiteralBooleanValueRule()); }
	 ruleLiteralBooleanValue
{ after(grammarAccess.getLiteralBooleanValueRule()); } 
	 EOF 
;

// Rule LiteralBooleanValue
ruleLiteralBooleanValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralBooleanValueAccess().getValueAssignment()); }
		(rule__LiteralBooleanValue__ValueAssignment)
		{ after(grammarAccess.getLiteralBooleanValueAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralCharacterValue
entryRuleLiteralCharacterValue
:
{ before(grammarAccess.getLiteralCharacterValueRule()); }
	 ruleLiteralCharacterValue
{ after(grammarAccess.getLiteralCharacterValueRule()); } 
	 EOF 
;

// Rule LiteralCharacterValue
ruleLiteralCharacterValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralCharacterValueAccess().getValueAssignment()); }
		(rule__LiteralCharacterValue__ValueAssignment)
		{ after(grammarAccess.getLiteralCharacterValueAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralIntegerValue
entryRuleLiteralIntegerValue
:
{ before(grammarAccess.getLiteralIntegerValueRule()); }
	 ruleLiteralIntegerValue
{ after(grammarAccess.getLiteralIntegerValueRule()); } 
	 EOF 
;

// Rule LiteralIntegerValue
ruleLiteralIntegerValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralIntegerValueAccess().getValueAssignment()); }
		(rule__LiteralIntegerValue__ValueAssignment)
		{ after(grammarAccess.getLiteralIntegerValueAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralRationalValue
entryRuleLiteralRationalValue
:
{ before(grammarAccess.getLiteralRationalValueRule()); }
	 ruleLiteralRationalValue
{ after(grammarAccess.getLiteralRationalValueRule()); } 
	 EOF 
;

// Rule LiteralRationalValue
ruleLiteralRationalValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralRationalValueAccess().getGroup()); }
		(rule__LiteralRationalValue__Group__0)
		{ after(grammarAccess.getLiteralRationalValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralFloatValue
entryRuleLiteralFloatValue
:
{ before(grammarAccess.getLiteralFloatValueRule()); }
	 ruleLiteralFloatValue
{ after(grammarAccess.getLiteralFloatValueRule()); } 
	 EOF 
;

// Rule LiteralFloatValue
ruleLiteralFloatValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralFloatValueAccess().getValueAssignment()); }
		(rule__LiteralFloatValue__ValueAssignment)
		{ after(grammarAccess.getLiteralFloatValueAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralStringValue
entryRuleLiteralStringValue
:
{ before(grammarAccess.getLiteralStringValueRule()); }
	 ruleLiteralStringValue
{ after(grammarAccess.getLiteralStringValueRule()); } 
	 EOF 
;

// Rule LiteralStringValue
ruleLiteralStringValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralStringValueAccess().getValueAssignment()); }
		(rule__LiteralStringValue__ValueAssignment)
		{ after(grammarAccess.getLiteralStringValueAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralNullValue
entryRuleLiteralNullValue
:
{ before(grammarAccess.getLiteralNullValueRule()); }
	 ruleLiteralNullValue
{ after(grammarAccess.getLiteralNullValueRule()); } 
	 EOF 
;

// Rule LiteralNullValue
ruleLiteralNullValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralNullValueAccess().getGroup()); }
		(rule__LiteralNullValue__Group__0)
		{ after(grammarAccess.getLiteralNullValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralVariableReference
entryRuleLiteralVariableReference
:
{ before(grammarAccess.getLiteralVariableReferenceRule()); }
	 ruleLiteralVariableReference
{ after(grammarAccess.getLiteralVariableReferenceRule()); } 
	 EOF 
;

// Rule LiteralVariableReference
ruleLiteralVariableReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralVariableReferenceAccess().getAlternatives()); }
		(rule__LiteralVariableReference__Alternatives)
		{ after(grammarAccess.getLiteralVariableReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralTimeVariable
entryRuleLiteralTimeVariable
:
{ before(grammarAccess.getLiteralTimeVariableRule()); }
	 ruleLiteralTimeVariable
{ after(grammarAccess.getLiteralTimeVariableRule()); } 
	 EOF 
;

// Rule LiteralTimeVariable
ruleLiteralTimeVariable 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralTimeVariableAccess().getGroup()); }
		(rule__LiteralTimeVariable__Group__0)
		{ after(grammarAccess.getLiteralTimeVariableAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralTimeDeltaVariable
entryRuleLiteralTimeDeltaVariable
:
{ before(grammarAccess.getLiteralTimeDeltaVariableRule()); }
	 ruleLiteralTimeDeltaVariable
{ after(grammarAccess.getLiteralTimeDeltaVariableRule()); } 
	 EOF 
;

// Rule LiteralTimeDeltaVariable
ruleLiteralTimeDeltaVariable 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralTimeDeltaVariableAccess().getGroup()); }
		(rule__LiteralTimeDeltaVariable__Group__0)
		{ after(grammarAccess.getLiteralTimeDeltaVariableAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralInstanceReference
entryRuleLiteralInstanceReference
:
{ before(grammarAccess.getLiteralInstanceReferenceRule()); }
	 ruleLiteralInstanceReference
{ after(grammarAccess.getLiteralInstanceReferenceRule()); } 
	 EOF 
;

// Rule LiteralInstanceReference
ruleLiteralInstanceReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralInstanceReferenceAccess().getAlternatives()); }
		(rule__LiteralInstanceReference__Alternatives)
		{ after(grammarAccess.getLiteralInstanceReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralThisInstance
entryRuleLiteralThisInstance
:
{ before(grammarAccess.getLiteralThisInstanceRule()); }
	 ruleLiteralThisInstance
{ after(grammarAccess.getLiteralThisInstanceRule()); } 
	 EOF 
;

// Rule LiteralThisInstance
ruleLiteralThisInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralThisInstanceAccess().getGroup()); }
		(rule__LiteralThisInstance__Group__0)
		{ after(grammarAccess.getLiteralThisInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralSelfInstance
entryRuleLiteralSelfInstance
:
{ before(grammarAccess.getLiteralSelfInstanceRule()); }
	 ruleLiteralSelfInstance
{ after(grammarAccess.getLiteralSelfInstanceRule()); } 
	 EOF 
;

// Rule LiteralSelfInstance
ruleLiteralSelfInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralSelfInstanceAccess().getGroup()); }
		(rule__LiteralSelfInstance__Group__0)
		{ after(grammarAccess.getLiteralSelfInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralParentInstance
entryRuleLiteralParentInstance
:
{ before(grammarAccess.getLiteralParentInstanceRule()); }
	 ruleLiteralParentInstance
{ after(grammarAccess.getLiteralParentInstanceRule()); } 
	 EOF 
;

// Rule LiteralParentInstance
ruleLiteralParentInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralParentInstanceAccess().getGroup()); }
		(rule__LiteralParentInstance__Group__0)
		{ after(grammarAccess.getLiteralParentInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralSuperInstance
entryRuleLiteralSuperInstance
:
{ before(grammarAccess.getLiteralSuperInstanceRule()); }
	 ruleLiteralSuperInstance
{ after(grammarAccess.getLiteralSuperInstanceRule()); } 
	 EOF 
;

// Rule LiteralSuperInstance
ruleLiteralSuperInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralSuperInstanceAccess().getGroup()); }
		(rule__LiteralSuperInstance__Group__0)
		{ after(grammarAccess.getLiteralSuperInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralSystemInstance
entryRuleLiteralSystemInstance
:
{ before(grammarAccess.getLiteralSystemInstanceRule()); }
	 ruleLiteralSystemInstance
{ after(grammarAccess.getLiteralSystemInstanceRule()); } 
	 EOF 
;

// Rule LiteralSystemInstance
ruleLiteralSystemInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralSystemInstanceAccess().getGroup()); }
		(rule__LiteralSystemInstance__Group__0)
		{ after(grammarAccess.getLiteralSystemInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralEnvInstance
entryRuleLiteralEnvInstance
:
{ before(grammarAccess.getLiteralEnvInstanceRule()); }
	 ruleLiteralEnvInstance
{ after(grammarAccess.getLiteralEnvInstanceRule()); } 
	 EOF 
;

// Rule LiteralEnvInstance
ruleLiteralEnvInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralEnvInstanceAccess().getGroup()); }
		(rule__LiteralEnvInstance__Group__0)
		{ after(grammarAccess.getLiteralEnvInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEBoolean
entryRuleEBoolean
:
{ before(grammarAccess.getEBooleanRule()); }
	 ruleEBoolean
{ after(grammarAccess.getEBooleanRule()); } 
	 EOF 
;

// Rule EBoolean
ruleEBoolean 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEBooleanAccess().getAlternatives()); }
		(rule__EBoolean__Alternatives)
		{ after(grammarAccess.getEBooleanAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEChar
entryRuleEChar
:
{ before(grammarAccess.getECharRule()); }
	 ruleEChar
{ after(grammarAccess.getECharRule()); } 
	 EOF 
;

// Rule EChar
ruleEChar 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getECharAccess().getCHARACTERTerminalRuleCall()); }
		RULE_CHARACTER
		{ after(grammarAccess.getECharAccess().getCHARACTERTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleELong
entryRuleELong
:
{ before(grammarAccess.getELongRule()); }
	 ruleELong
{ after(grammarAccess.getELongRule()); } 
	 EOF 
;

// Rule ELong
ruleELong 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getELongAccess().getGroup()); }
		(rule__ELong__Group__0)
		{ after(grammarAccess.getELongAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEDouble
entryRuleEDouble
:
{ before(grammarAccess.getEDoubleRule()); }
	 ruleEDouble
{ after(grammarAccess.getEDoubleRule()); } 
	 EOF 
;

// Rule EDouble
ruleEDouble 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEDoubleAccess().getGroup()); }
		(rule__EDouble__Group__0)
		{ after(grammarAccess.getEDoubleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEBigDecimal
entryRuleEBigDecimal
:
{ before(grammarAccess.getEBigDecimalRule()); }
	 ruleEBigDecimal
{ after(grammarAccess.getEBigDecimalRule()); } 
	 EOF 
;

// Rule EBigDecimal
ruleEBigDecimal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEBigDecimalAccess().getGroup()); }
		(rule__EBigDecimal__Group__0)
		{ after(grammarAccess.getEBigDecimalAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEString
entryRuleEString
:
{ before(grammarAccess.getEStringRule()); }
	 ruleEString
{ after(grammarAccess.getEStringRule()); } 
	 EOF 
;

// Rule EString
ruleEString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall()); }
		RULE_STRING
		{ after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDeprecatedReservedWord
entryRuleDeprecatedReservedWord
:
{ before(grammarAccess.getDeprecatedReservedWordRule()); }
	 ruleDeprecatedReservedWord
{ after(grammarAccess.getDeprecatedReservedWordRule()); } 
	 EOF 
;

// Rule DeprecatedReservedWord
ruleDeprecatedReservedWord 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDeprecatedReservedWordAccess().getAlternatives()); }
		(rule__DeprecatedReservedWord__Alternatives)
		{ after(grammarAccess.getDeprecatedReservedWordAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDeprecatedObject
entryRuleDeprecatedObject
:
{ before(grammarAccess.getDeprecatedObjectRule()); }
	 ruleDeprecatedObject
{ after(grammarAccess.getDeprecatedObjectRule()); } 
	 EOF 
;

// Rule DeprecatedObject
ruleDeprecatedObject 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getAlternatives()); }
		(rule__DeprecatedObject__Alternatives)
		{ after(grammarAccess.getDeprecatedObjectAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDeprecatedProperty
entryRuleDeprecatedProperty
:
{ before(grammarAccess.getDeprecatedPropertyRule()); }
	 ruleDeprecatedProperty
{ after(grammarAccess.getDeprecatedPropertyRule()); } 
	 EOF 
;

// Rule DeprecatedProperty
ruleDeprecatedProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDeprecatedPropertyAccess().getAlternatives()); }
		(rule__DeprecatedProperty__Alternatives)
		{ after(grammarAccess.getDeprecatedPropertyAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDeprecatedSection
entryRuleDeprecatedSection
:
{ before(grammarAccess.getDeprecatedSectionRule()); }
	 ruleDeprecatedSection
{ after(grammarAccess.getDeprecatedSectionRule()); } 
	 EOF 
;

// Rule DeprecatedSection
ruleDeprecatedSection 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getAlternatives()); }
		(rule__DeprecatedSection__Alternatives)
		{ after(grammarAccess.getDeprecatedSectionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDeprecatedAttribute
entryRuleDeprecatedAttribute
:
{ before(grammarAccess.getDeprecatedAttributeRule()); }
	 ruleDeprecatedAttribute
{ after(grammarAccess.getDeprecatedAttributeRule()); } 
	 EOF 
;

// Rule DeprecatedAttribute
ruleDeprecatedAttribute 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDeprecatedAttributeAccess().getGroup()); }
		(rule__DeprecatedAttribute__Group__0)
		{ after(grammarAccess.getDeprecatedAttributeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDeprecatedAttributeID
entryRuleDeprecatedAttributeID
:
{ before(grammarAccess.getDeprecatedAttributeIDRule()); }
	 ruleDeprecatedAttributeID
{ after(grammarAccess.getDeprecatedAttributeIDRule()); } 
	 EOF 
;

// Rule DeprecatedAttributeID
ruleDeprecatedAttributeID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDeprecatedAttributeIDAccess().getAlternatives()); }
		(rule__DeprecatedAttributeID__Alternatives)
		{ after(grammarAccess.getDeprecatedAttributeIDAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDeprecatedExpression
entryRuleDeprecatedExpression
:
{ before(grammarAccess.getDeprecatedExpressionRule()); }
	 ruleDeprecatedExpression
{ after(grammarAccess.getDeprecatedExpressionRule()); } 
	 EOF 
;

// Rule DeprecatedExpression
ruleDeprecatedExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDeprecatedExpressionAccess().getGroup()); }
		(rule__DeprecatedExpression__Group__0)
		{ after(grammarAccess.getDeprecatedExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getGroup_2_0()); }
		(rule__Workflow__Group_2_0__0)
		{ after(grammarAccess.getWorkflowAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getWorkflowAccess().getElementAssignment_2_1()); }
		(rule__Workflow__ElementAssignment_2_1)*
		{ after(grammarAccess.getWorkflowAccess().getElementAssignment_2_1()); }
	)
	|
	(
		{ before(grammarAccess.getWorkflowAccess().getElementAssignment_2_2()); }
		(rule__Workflow__ElementAssignment_2_2)
		{ after(grammarAccess.getWorkflowAccess().getElementAssignment_2_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__TypeAlternatives_2_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getTypeWorkflowKeyword_2_0_0_0_0()); }
		'workflow'
		{ after(grammarAccess.getWorkflowAccess().getTypeWorkflowKeyword_2_0_0_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getWorkflowAccess().getTypeSymbexWorkflowKeyword_2_0_0_0_1()); }
		'symbex-workflow'
		{ after(grammarAccess.getWorkflowAccess().getTypeSymbexWorkflowKeyword_2_0_0_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__ElementAlternatives_2_0_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getElementObjectParserRuleCall_2_0_4_0_0()); }
		ruleObject
		{ after(grammarAccess.getWorkflowAccess().getElementObjectParserRuleCall_2_0_4_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_0_4_0_1()); }
		ruleProperty
		{ after(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_0_4_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__ElementAlternatives_2_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getElementObjectParserRuleCall_2_1_0_0()); }
		ruleObject
		{ after(grammarAccess.getWorkflowAccess().getElementObjectParserRuleCall_2_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_1_0_1()); }
		ruleProperty
		{ after(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrologAccess().getSewKeyword_0_0()); }
		'@sew'
		{ after(grammarAccess.getPrologAccess().getSewKeyword_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getPrologAccess().getFavmKeyword_0_1()); }
		'@favm'
		{ after(grammarAccess.getPrologAccess().getFavmKeyword_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrologAccess().getWorkflowKeyword_2_0()); }
		'workflow'
		{ after(grammarAccess.getPrologAccess().getWorkflowKeyword_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getPrologAccess().getSewKeyword_2_1()); }
		'sew'
		{ after(grammarAccess.getPrologAccess().getSewKeyword_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Alternatives_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrologAccess().getGroup_4_0()); }
		(rule__Prolog__Group_4_0__0)
		{ after(grammarAccess.getPrologAccess().getGroup_4_0()); }
	)
	|
	(
		{ before(grammarAccess.getPrologAccess().getEStringParserRuleCall_4_1()); }
		ruleEString
		{ after(grammarAccess.getPrologAccess().getEStringParserRuleCall_4_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReservedWord__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReservedWordAccess().getWorkflowKeyword_0()); }
		'workflow'
		{ after(grammarAccess.getReservedWordAccess().getWorkflowKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getReservedWordAccess().getSewKeyword_1()); }
		'sew'
		{ after(grammarAccess.getReservedWordAccess().getSewKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getReservedWordAccess().getDeprecatedReservedWordParserRuleCall_2()); }
		ruleDeprecatedReservedWord
		{ after(grammarAccess.getReservedWordAccess().getDeprecatedReservedWordParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XID__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXIDAccess().getReservedWordParserRuleCall_0()); }
		ruleReservedWord
		{ after(grammarAccess.getXIDAccess().getReservedWordParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getXIDAccess().getXIDENDIFIERTerminalRuleCall_1()); }
		RULE_XIDENDIFIER
		{ after(grammarAccess.getXIDAccess().getXIDENDIFIERTerminalRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UFI__Alternatives_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUFIAccess().getColonColonKeyword_1_0_0()); }
		'::'
		{ after(grammarAccess.getUFIAccess().getColonColonKeyword_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getUFIAccess().getFullStopKeyword_1_0_1()); }
		'.'
		{ after(grammarAccess.getUFIAccess().getFullStopKeyword_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getGroup_0()); }
		(rule__Object__Group_0__0)
		{ after(grammarAccess.getObjectAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getObjectAccess().getGroup_1()); }
		(rule__Object__Group_1__0)
		{ after(grammarAccess.getObjectAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__ElementAlternatives_0_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getElementObjectParserRuleCall_0_5_0_0()); }
		ruleObject
		{ after(grammarAccess.getObjectAccess().getElementObjectParserRuleCall_0_5_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getObjectAccess().getElementPropertyParserRuleCall_0_5_0_1()); }
		ruleProperty
		{ after(grammarAccess.getObjectAccess().getElementPropertyParserRuleCall_0_5_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Alternatives_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getColonEqualsSignKeyword_1_2_0()); }
		':='
		{ after(grammarAccess.getObjectAccess().getColonEqualsSignKeyword_1_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getObjectAccess().getPlusSignColonEqualsSignKeyword_1_2_1()); }
		'+:='
		{ after(grammarAccess.getObjectAccess().getPlusSignColonEqualsSignKeyword_1_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__ElementAlternatives_1_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getElementObjectParserRuleCall_1_5_0_0()); }
		ruleObject
		{ after(grammarAccess.getObjectAccess().getElementObjectParserRuleCall_1_5_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getObjectAccess().getElementPropertyParserRuleCall_1_5_0_1()); }
		ruleProperty
		{ after(grammarAccess.getObjectAccess().getElementPropertyParserRuleCall_1_5_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Property__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPropertyAccess().getSectionParserRuleCall_0()); }
		ruleSection
		{ after(grammarAccess.getPropertyAccess().getSectionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyAccess().getAttributeParserRuleCall_1()); }
		ruleAttribute
		{ after(grammarAccess.getPropertyAccess().getAttributeParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSectionAccess().getGroup_2_0()); }
		(rule__Section__Group_2_0__0)
		{ after(grammarAccess.getSectionAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getSectionAccess().getGroup_2_1()); }
		(rule__Section__Group_2_1__0)
		{ after(grammarAccess.getSectionAccess().getGroup_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__ElementAlternatives_2_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_0_1_0_0()); }
		ruleObject
		{ after(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_0_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_0_1_0_1()); }
		ruleAttribute
		{ after(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_0_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__ElementAlternatives_2_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_1_1_0_0()); }
		ruleObject
		{ after(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_1_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_1_1_0_1()); }
		ruleAttribute
		{ after(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_1_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0()); }
		ruleconditionalExpression
		{ after(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getExpressionAccess().getDeprecatedExpressionParserRuleCall_1()); }
		ruleDeprecatedExpression
		{ after(grammarAccess.getExpressionAccess().getDeprecatedExpressionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__OperatorAlternatives_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalOrExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_1_0_0()); }
		'||'
		{ after(grammarAccess.getConditionalOrExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getConditionalOrExpressionAccess().getOperatorOrKeyword_1_1_0_1()); }
		'or'
		{ after(grammarAccess.getConditionalOrExpressionAccess().getOperatorOrKeyword_1_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Alternatives_1_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_3_0_0()); }
		'||'
		{ after(grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_3_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getConditionalOrExpressionAccess().getOrKeyword_1_3_0_1()); }
		'or'
		{ after(grammarAccess.getConditionalOrExpressionAccess().getOrKeyword_1_3_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__OperatorAlternatives_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalAndExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_1_0_0()); }
		'&&'
		{ after(grammarAccess.getConditionalAndExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getConditionalAndExpressionAccess().getOperatorAndKeyword_1_1_0_1()); }
		'and'
		{ after(grammarAccess.getConditionalAndExpressionAccess().getOperatorAndKeyword_1_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Alternatives_1_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_3_0_0()); }
		'&&'
		{ after(grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_3_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getConditionalAndExpressionAccess().getAndKeyword_1_3_0_1()); }
		'and'
		{ after(grammarAccess.getConditionalAndExpressionAccess().getAndKeyword_1_3_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__OperatorAlternatives_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0()); }
		'=='
		{ after(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getEqualityExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1()); }
		'!='
		{ after(grammarAccess.getEqualityExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignEqualsSignKeyword_1_1_0_2()); }
		'==='
		{ after(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignEqualsSignKeyword_1_1_0_2()); }
	)
	|
	(
		{ before(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignExclamationMarkEqualsSignKeyword_1_1_0_3()); }
		'=!='
		{ after(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignExclamationMarkEqualsSignKeyword_1_1_0_3()); }
	)
	|
	(
		{ before(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignSolidusEqualsSignKeyword_1_1_0_4()); }
		'=/='
		{ after(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignSolidusEqualsSignKeyword_1_1_0_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__OperatorAlternatives_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0()); }
		'<'
		{ after(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1()); }
		'<='
		{ after(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_2()); }
		'>'
		{ after(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_2()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3()); }
		'>='
		{ after(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0()); }
		(rule__MultiplicativeExpression__Group_1_0__0)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_1()); }
		(rule__MultiplicativeExpression__Group_1_1__0)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_1()); }
	)
	|
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_2()); }
		(rule__MultiplicativeExpression__Group_1_2__0)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_2()); }
	)
	|
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_3()); }
		(rule__MultiplicativeExpression__Group_1_3__0)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); }
		(rule__PrimaryExpression__Group_0__0)
		{ after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); }
		(rule__PrimaryExpression__Group_1__0)
		{ after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getGroup_2()); }
		(rule__PrimaryExpression__Group_2__0)
		{ after(grammarAccess.getPrimaryExpressionAccess().getGroup_2()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getGroup_3()); }
		(rule__PrimaryExpression__Group_3__0)
		{ after(grammarAccess.getPrimaryExpressionAccess().getGroup_3()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_4()); }
		ruleLiteralExpression
		{ after(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__OperatorAlternatives_2_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getOperatorExclamationMarkKeyword_2_1_0_0_0()); }
		'!'
		{ after(grammarAccess.getPrimaryExpressionAccess().getOperatorExclamationMarkKeyword_2_1_0_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getOperatorNotKeyword_2_1_0_0_1()); }
		'not'
		{ after(grammarAccess.getPrimaryExpressionAccess().getOperatorNotKeyword_2_1_0_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralBooleanValueParserRuleCall_0()); }
		ruleLiteralBooleanValue
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralBooleanValueParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralCharacterValueParserRuleCall_1()); }
		ruleLiteralCharacterValue
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralCharacterValueParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralIntegerValueParserRuleCall_2()); }
		ruleLiteralIntegerValue
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralIntegerValueParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralRationalValueParserRuleCall_3()); }
		ruleLiteralRationalValue
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralRationalValueParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralFloatValueParserRuleCall_4()); }
		ruleLiteralFloatValue
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralFloatValueParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralStringValueParserRuleCall_5()); }
		ruleLiteralStringValue
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralStringValueParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralNullValueParserRuleCall_6()); }
		ruleLiteralNullValue
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralNullValueParserRuleCall_6()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralArrayValueParserRuleCall_7()); }
		ruleLiteralArrayValue
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralArrayValueParserRuleCall_7()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralObjectReferenceParserRuleCall_8()); }
		ruleLiteralObjectReference
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralObjectReferenceParserRuleCall_8()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralVariableReferenceParserRuleCall_9()); }
		ruleLiteralVariableReference
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralVariableReferenceParserRuleCall_9()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralExpressionAccess().getLiteralInstanceReferenceParserRuleCall_10()); }
		ruleLiteralInstanceReference
		{ after(grammarAccess.getLiteralExpressionAccess().getLiteralInstanceReferenceParserRuleCall_10()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralObjectReference__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralObjectReferenceAccess().getObjectAssignment_1_0()); }
		(rule__LiteralObjectReference__ObjectAssignment_1_0)
		{ after(grammarAccess.getLiteralObjectReferenceAccess().getObjectAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralObjectReferenceAccess().getSymbolAssignment_1_1()); }
		(rule__LiteralObjectReference__SymbolAssignment_1_1)
		{ after(grammarAccess.getLiteralObjectReferenceAccess().getSymbolAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralVariableReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralVariableReferenceAccess().getLiteralTimeVariableParserRuleCall_0()); }
		ruleLiteralTimeVariable
		{ after(grammarAccess.getLiteralVariableReferenceAccess().getLiteralTimeVariableParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralVariableReferenceAccess().getLiteralTimeDeltaVariableParserRuleCall_1()); }
		ruleLiteralTimeDeltaVariable
		{ after(grammarAccess.getLiteralVariableReferenceAccess().getLiteralTimeDeltaVariableParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralInstanceReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralThisInstanceParserRuleCall_0()); }
		ruleLiteralThisInstance
		{ after(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralThisInstanceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSelfInstanceParserRuleCall_1()); }
		ruleLiteralSelfInstance
		{ after(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSelfInstanceParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralParentInstanceParserRuleCall_2()); }
		ruleLiteralParentInstance
		{ after(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralParentInstanceParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSuperInstanceParserRuleCall_3()); }
		ruleLiteralSuperInstance
		{ after(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSuperInstanceParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSystemInstanceParserRuleCall_4()); }
		ruleLiteralSystemInstance
		{ after(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSystemInstanceParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralEnvInstanceParserRuleCall_5()); }
		ruleLiteralEnvInstance
		{ after(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralEnvInstanceParserRuleCall_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralEnvInstance__SymbolAlternatives_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralEnvInstanceAccess().getSymbolEnvKeyword_1_0_0()); }
		'$env'
		{ after(grammarAccess.getLiteralEnvInstanceAccess().getSymbolEnvKeyword_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralEnvInstanceAccess().getSymbolEnvKeyword_1_0_1()); }
		'env'
		{ after(grammarAccess.getLiteralEnvInstanceAccess().getSymbolEnvKeyword_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EBoolean__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); }
		'true'
		{ after(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); }
		'false'
		{ after(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedReservedWord__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedReservedWordAccess().getFormKeyword_0()); }
		'form'
		{ after(grammarAccess.getDeprecatedReservedWordAccess().getFormKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedReservedWordAccess().getEndformKeyword_1()); }
		'endform'
		{ after(grammarAccess.getDeprecatedReservedWordAccess().getEndformKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedReservedWordAccess().getPrototypeKeyword_2()); }
		'prototype'
		{ after(grammarAccess.getDeprecatedReservedWordAccess().getPrototypeKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedReservedWordAccess().getEndprototypeKeyword_3()); }
		'endprototype'
		{ after(grammarAccess.getDeprecatedReservedWordAccess().getEndprototypeKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedReservedWordAccess().getSectionKeyword_4()); }
		'section'
		{ after(grammarAccess.getDeprecatedReservedWordAccess().getSectionKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedReservedWordAccess().getEndsectionKeyword_5()); }
		'endsection'
		{ after(grammarAccess.getDeprecatedReservedWordAccess().getEndsectionKeyword_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getGroup_0()); }
		(rule__DeprecatedObject__Group_0__0)
		{ after(grammarAccess.getDeprecatedObjectAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getGroup_1()); }
		(rule__DeprecatedObject__Group_1__0)
		{ after(grammarAccess.getDeprecatedObjectAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedProperty__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedPropertyAccess().getDeprecatedSectionParserRuleCall_0()); }
		ruleDeprecatedSection
		{ after(grammarAccess.getDeprecatedPropertyAccess().getDeprecatedSectionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedPropertyAccess().getDeprecatedAttributeParserRuleCall_1()); }
		ruleDeprecatedAttribute
		{ after(grammarAccess.getDeprecatedPropertyAccess().getDeprecatedAttributeParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getGroup_0()); }
		(rule__DeprecatedSection__Group_0__0)
		{ after(grammarAccess.getDeprecatedSectionAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getGroup_1()); }
		(rule__DeprecatedSection__Group_1__0)
		{ after(grammarAccess.getDeprecatedSectionAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__ElementAlternatives_0_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_0_3_0_0()); }
		ruleDeprecatedAttribute
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_0_3_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_0_3_0_1()); }
		ruleDeprecatedObject
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_0_3_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_0_3_0_2()); }
		ruleObject
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_0_3_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Alternatives_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getGroup_1_2_0()); }
		(rule__DeprecatedSection__Group_1_2_0__0)
		{ after(grammarAccess.getDeprecatedSectionAccess().getGroup_1_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getGroup_1_2_1()); }
		(rule__DeprecatedSection__Group_1_2_1__0)
		{ after(grammarAccess.getDeprecatedSectionAccess().getGroup_1_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__ElementAlternatives_1_2_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_1_2_0_1_0_0()); }
		ruleDeprecatedAttribute
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_1_2_0_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_1_2_0_1_0_1()); }
		ruleDeprecatedObject
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_1_2_0_1_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_0_1_0_2()); }
		ruleObject
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_0_1_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__ElementAlternatives_1_2_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_1_2_1_1_0_0()); }
		ruleDeprecatedAttribute
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_1_2_1_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_1_2_1_1_0_1()); }
		ruleDeprecatedObject
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_1_2_1_1_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_1_1_0_2()); }
		ruleObject
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_1_1_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttributeID__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedAttributeIDAccess().getXIDParserRuleCall_0()); }
		ruleXID
		{ after(grammarAccess.getDeprecatedAttributeIDAccess().getXIDParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedAttributeIDAccess().getAT_IDENTIFIERTerminalRuleCall_1()); }
		RULE_AT_IDENTIFIER
		{ after(grammarAccess.getDeprecatedAttributeIDAccess().getAT_IDENTIFIERTerminalRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__OperatorAlternatives_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedExpressionAccess().getOperatorVerticalLineSemicolonVerticalLineKeyword_2_0_0()); }
		'|;|'
		{ after(grammarAccess.getDeprecatedExpressionAccess().getOperatorVerticalLineSemicolonVerticalLineKeyword_2_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getDeprecatedExpressionAccess().getOperatorIKeyword_2_0_1()); }
		'|i|'
		{ after(grammarAccess.getDeprecatedExpressionAccess().getOperatorIKeyword_2_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group__0__Impl
	rule__Workflow__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getSEWorkflowAction_0()); }
	()
	{ after(grammarAccess.getWorkflowAccess().getSEWorkflowAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group__1__Impl
	rule__Workflow__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getPrologParserRuleCall_1()); }
	(ruleProlog)?
	{ after(grammarAccess.getWorkflowAccess().getPrologParserRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getAlternatives_2()); }
	(rule__Workflow__Alternatives_2)
	{ after(grammarAccess.getWorkflowAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Workflow__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group_2_0__0__Impl
	rule__Workflow__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getTypeAssignment_2_0_0()); }
	(rule__Workflow__TypeAssignment_2_0_0)
	{ after(grammarAccess.getWorkflowAccess().getTypeAssignment_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group_2_0__1__Impl
	rule__Workflow__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getNameAssignment_2_0_1()); }
	(rule__Workflow__NameAssignment_2_0_1)?
	{ after(grammarAccess.getWorkflowAccess().getNameAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group_2_0__2__Impl
	rule__Workflow__Group_2_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getDescriptionAssignment_2_0_2()); }
	(rule__Workflow__DescriptionAssignment_2_0_2)?
	{ after(grammarAccess.getWorkflowAccess().getDescriptionAssignment_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group_2_0__3__Impl
	rule__Workflow__Group_2_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_2_0_3()); }
	'{'
	{ after(grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_2_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group_2_0__4__Impl
	rule__Workflow__Group_2_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getElementAssignment_2_0_4()); }
	(rule__Workflow__ElementAssignment_2_0_4)*
	{ after(grammarAccess.getWorkflowAccess().getElementAssignment_2_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Workflow__Group_2_0__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__Group_2_0__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_2_0_5()); }
	'}'
	{ after(grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_2_0_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Prolog__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group__0__Impl
	rule__Prolog__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getAlternatives_0()); }
	(rule__Prolog__Alternatives_0)
	{ after(grammarAccess.getPrologAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group__1__Impl
	rule__Prolog__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getLessThanSignKeyword_1()); }
	'<'
	{ after(grammarAccess.getPrologAccess().getLessThanSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group__2__Impl
	rule__Prolog__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getAlternatives_2()); }
	(rule__Prolog__Alternatives_2)
	{ after(grammarAccess.getPrologAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group__3__Impl
	rule__Prolog__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getGroup_3()); }
	(rule__Prolog__Group_3__0)?
	{ after(grammarAccess.getPrologAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group__4__Impl
	rule__Prolog__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getAlternatives_4()); }
	(rule__Prolog__Alternatives_4)?
	{ after(grammarAccess.getPrologAccess().getAlternatives_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getGreaterThanSignColonKeyword_5()); }
	'>:'
	{ after(grammarAccess.getPrologAccess().getGreaterThanSignColonKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Prolog__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group_3__0__Impl
	rule__Prolog__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getCommaKeyword_3_0()); }
	','
	{ after(grammarAccess.getPrologAccess().getCommaKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getEDoubleParserRuleCall_3_1()); }
	ruleEDouble
	{ after(grammarAccess.getPrologAccess().getEDoubleParserRuleCall_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Prolog__Group_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group_4_0__0__Impl
	rule__Prolog__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getCommaKeyword_4_0_0()); }
	','
	{ after(grammarAccess.getPrologAccess().getCommaKeyword_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group_4_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Prolog__Group_4_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Prolog__Group_4_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrologAccess().getUFIParserRuleCall_4_0_1()); }
	ruleUFI
	{ after(grammarAccess.getPrologAccess().getUFIParserRuleCall_4_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UFI__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UFI__Group__0__Impl
	rule__UFI__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UFI__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUFIAccess().getXIDParserRuleCall_0()); }
	ruleXID
	{ after(grammarAccess.getUFIAccess().getXIDParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UFI__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UFI__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UFI__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUFIAccess().getGroup_1()); }
	(rule__UFI__Group_1__0)*
	{ after(grammarAccess.getUFIAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UFI__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UFI__Group_1__0__Impl
	rule__UFI__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UFI__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUFIAccess().getAlternatives_1_0()); }
	(rule__UFI__Alternatives_1_0)
	{ after(grammarAccess.getUFIAccess().getAlternatives_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UFI__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UFI__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UFI__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUFIAccess().getXIDParserRuleCall_1_1()); }
	ruleXID
	{ after(grammarAccess.getUFIAccess().getXIDParserRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Object__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_0__0__Impl
	rule__Object__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getWObjectAction_0_0()); }
	()
	{ after(grammarAccess.getObjectAccess().getWObjectAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_0__1__Impl
	rule__Object__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getTypeAssignment_0_1()); }
	(rule__Object__TypeAssignment_0_1)
	{ after(grammarAccess.getObjectAccess().getTypeAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_0__2__Impl
	rule__Object__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getNameAssignment_0_2()); }
	(rule__Object__NameAssignment_0_2)?
	{ after(grammarAccess.getObjectAccess().getNameAssignment_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_0__3__Impl
	rule__Object__Group_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getDescriptionAssignment_0_3()); }
	(rule__Object__DescriptionAssignment_0_3)?
	{ after(grammarAccess.getObjectAccess().getDescriptionAssignment_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_0__4__Impl
	rule__Object__Group_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_0_4()); }
	'{'
	{ after(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_0__5__Impl
	rule__Object__Group_0__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getElementAssignment_0_5()); }
	(rule__Object__ElementAssignment_0_5)*
	{ after(grammarAccess.getObjectAccess().getElementAssignment_0_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_0__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_0__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_0_6()); }
	'}'
	{ after(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_0_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Object__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1__0__Impl
	rule__Object__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getWObjectAction_1_0()); }
	()
	{ after(grammarAccess.getObjectAccess().getWObjectAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1__1__Impl
	rule__Object__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getNameAssignment_1_1()); }
	(rule__Object__NameAssignment_1_1)
	{ after(grammarAccess.getObjectAccess().getNameAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1__2__Impl
	rule__Object__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getAlternatives_1_2()); }
	(rule__Object__Alternatives_1_2)
	{ after(grammarAccess.getObjectAccess().getAlternatives_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1__3__Impl
	rule__Object__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getGroup_1_3()); }
	(rule__Object__Group_1_3__0)?
	{ after(grammarAccess.getObjectAccess().getGroup_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1__4__Impl
	rule__Object__Group_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_1_4()); }
	'{'
	{ after(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1__5__Impl
	rule__Object__Group_1__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getElementAssignment_1_5()); }
	(rule__Object__ElementAssignment_1_5)*
	{ after(grammarAccess.getObjectAccess().getElementAssignment_1_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_1_6()); }
	'}'
	{ after(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_1_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Object__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1_3__0__Impl
	rule__Object__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getTypeAssignment_1_3_0()); }
	(rule__Object__TypeAssignment_1_3_0)
	{ after(grammarAccess.getObjectAccess().getTypeAssignment_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Object__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getObjectAccess().getDescriptionAssignment_1_3_1()); }
	(rule__Object__DescriptionAssignment_1_3_1)?
	{ after(grammarAccess.getObjectAccess().getDescriptionAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Section__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Section__Group__0__Impl
	rule__Section__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSectionAccess().getNameAssignment_0()); }
	(rule__Section__NameAssignment_0)
	{ after(grammarAccess.getSectionAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Section__Group__1__Impl
	rule__Section__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSectionAccess().getDescriptionAssignment_1()); }
	(rule__Section__DescriptionAssignment_1)?
	{ after(grammarAccess.getSectionAccess().getDescriptionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Section__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSectionAccess().getAlternatives_2()); }
	(rule__Section__Alternatives_2)
	{ after(grammarAccess.getSectionAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Section__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Section__Group_2_0__0__Impl
	rule__Section__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSectionAccess().getLeftSquareBracketKeyword_2_0_0()); }
	'['
	{ after(grammarAccess.getSectionAccess().getLeftSquareBracketKeyword_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Section__Group_2_0__1__Impl
	rule__Section__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSectionAccess().getElementAssignment_2_0_1()); }
	(rule__Section__ElementAssignment_2_0_1)*
	{ after(grammarAccess.getSectionAccess().getElementAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Section__Group_2_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSectionAccess().getRightSquareBracketKeyword_2_0_2()); }
	']'
	{ after(grammarAccess.getSectionAccess().getRightSquareBracketKeyword_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Section__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Section__Group_2_1__0__Impl
	rule__Section__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSectionAccess().getColonKeyword_2_1_0()); }
	':'
	{ after(grammarAccess.getSectionAccess().getColonKeyword_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Section__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSectionAccess().getElementAssignment_2_1_1()); }
	(rule__Section__ElementAssignment_2_1_1)*
	{ after(grammarAccess.getSectionAccess().getElementAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Attribute__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Attribute__Group__0__Impl
	rule__Attribute__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAttributeAccess().getWAttributeAction_0()); }
	()
	{ after(grammarAccess.getAttributeAccess().getWAttributeAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Attribute__Group__1__Impl
	rule__Attribute__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAttributeAccess().getNameAssignment_1()); }
	(rule__Attribute__NameAssignment_1)
	{ after(grammarAccess.getAttributeAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Attribute__Group__2__Impl
	rule__Attribute__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAttributeAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getAttributeAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Attribute__Group__3__Impl
	rule__Attribute__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAttributeAccess().getValueAssignment_3()); }
	(rule__Attribute__ValueAssignment_3)
	{ after(grammarAccess.getAttributeAccess().getValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Attribute__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAttributeAccess().getSemicolonKeyword_4()); }
	(';')?
	{ after(grammarAccess.getAttributeAccess().getSemicolonKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalExpression__Group__0__Impl
	rule__ConditionalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalExpressionAccess().getConditionalOrExpressionParserRuleCall_0()); }
	ruleconditionalOrExpression
	{ after(grammarAccess.getConditionalExpressionAccess().getConditionalOrExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalExpressionAccess().getGroup_1()); }
	(rule__ConditionalExpression__Group_1__0)?
	{ after(grammarAccess.getConditionalExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalExpression__Group_1__0__Impl
	rule__ConditionalExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalExpressionAccess().getExpressionOperandAction_1_0()); }
	()
	{ after(grammarAccess.getConditionalExpressionAccess().getExpressionOperandAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalExpression__Group_1__1__Impl
	rule__ConditionalExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalExpressionAccess().getOperatorAssignment_1_1()); }
	(rule__ConditionalExpression__OperatorAssignment_1_1)
	{ after(grammarAccess.getConditionalExpressionAccess().getOperatorAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalExpression__Group_1__2__Impl
	rule__ConditionalExpression__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalExpressionAccess().getOperandAssignment_1_2()); }
	(rule__ConditionalExpression__OperandAssignment_1_2)
	{ after(grammarAccess.getConditionalExpressionAccess().getOperandAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalExpression__Group_1__3__Impl
	rule__ConditionalExpression__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3()); }
	':'
	{ after(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalExpression__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalExpressionAccess().getOperandAssignment_1_4()); }
	(rule__ConditionalExpression__OperandAssignment_1_4)
	{ after(grammarAccess.getConditionalExpressionAccess().getOperandAssignment_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalOrExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalOrExpression__Group__0__Impl
	rule__ConditionalOrExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalOrExpressionAccess().getConditionalAndExpressionParserRuleCall_0()); }
	ruleconditionalAndExpression
	{ after(grammarAccess.getConditionalOrExpressionAccess().getConditionalAndExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalOrExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalOrExpressionAccess().getGroup_1()); }
	(rule__ConditionalOrExpression__Group_1__0)?
	{ after(grammarAccess.getConditionalOrExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalOrExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalOrExpression__Group_1__0__Impl
	rule__ConditionalOrExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalOrExpressionAccess().getExpressionOperandAction_1_0()); }
	()
	{ after(grammarAccess.getConditionalOrExpressionAccess().getExpressionOperandAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalOrExpression__Group_1__1__Impl
	rule__ConditionalOrExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalOrExpressionAccess().getOperatorAssignment_1_1()); }
	(rule__ConditionalOrExpression__OperatorAssignment_1_1)
	{ after(grammarAccess.getConditionalOrExpressionAccess().getOperatorAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalOrExpression__Group_1__2__Impl
	rule__ConditionalOrExpression__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalOrExpressionAccess().getOperandAssignment_1_2()); }
	(rule__ConditionalOrExpression__OperandAssignment_1_2)
	{ after(grammarAccess.getConditionalOrExpressionAccess().getOperandAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalOrExpression__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalOrExpressionAccess().getGroup_1_3()); }
	(rule__ConditionalOrExpression__Group_1_3__0)*
	{ after(grammarAccess.getConditionalOrExpressionAccess().getGroup_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalOrExpression__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalOrExpression__Group_1_3__0__Impl
	rule__ConditionalOrExpression__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalOrExpressionAccess().getAlternatives_1_3_0()); }
	(rule__ConditionalOrExpression__Alternatives_1_3_0)
	{ after(grammarAccess.getConditionalOrExpressionAccess().getAlternatives_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalOrExpression__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalOrExpressionAccess().getOperandAssignment_1_3_1()); }
	(rule__ConditionalOrExpression__OperandAssignment_1_3_1)
	{ after(grammarAccess.getConditionalOrExpressionAccess().getOperandAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalAndExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalAndExpression__Group__0__Impl
	rule__ConditionalAndExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); }
	ruleequalityExpression
	{ after(grammarAccess.getConditionalAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalAndExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalAndExpressionAccess().getGroup_1()); }
	(rule__ConditionalAndExpression__Group_1__0)?
	{ after(grammarAccess.getConditionalAndExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalAndExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalAndExpression__Group_1__0__Impl
	rule__ConditionalAndExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalAndExpressionAccess().getExpressionOperandAction_1_0()); }
	()
	{ after(grammarAccess.getConditionalAndExpressionAccess().getExpressionOperandAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalAndExpression__Group_1__1__Impl
	rule__ConditionalAndExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalAndExpressionAccess().getOperatorAssignment_1_1()); }
	(rule__ConditionalAndExpression__OperatorAssignment_1_1)
	{ after(grammarAccess.getConditionalAndExpressionAccess().getOperatorAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalAndExpression__Group_1__2__Impl
	rule__ConditionalAndExpression__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalAndExpressionAccess().getOperandAssignment_1_2()); }
	(rule__ConditionalAndExpression__OperandAssignment_1_2)
	{ after(grammarAccess.getConditionalAndExpressionAccess().getOperandAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalAndExpression__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalAndExpressionAccess().getGroup_1_3()); }
	(rule__ConditionalAndExpression__Group_1_3__0)*
	{ after(grammarAccess.getConditionalAndExpressionAccess().getGroup_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalAndExpression__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalAndExpression__Group_1_3__0__Impl
	rule__ConditionalAndExpression__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalAndExpressionAccess().getAlternatives_1_3_0()); }
	(rule__ConditionalAndExpression__Alternatives_1_3_0)
	{ after(grammarAccess.getConditionalAndExpressionAccess().getAlternatives_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalAndExpression__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalAndExpressionAccess().getOperandAssignment_1_3_1()); }
	(rule__ConditionalAndExpression__OperandAssignment_1_3_1)
	{ after(grammarAccess.getConditionalAndExpressionAccess().getOperandAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EqualityExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EqualityExpression__Group__0__Impl
	rule__EqualityExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); }
	rulerelationalExpression
	{ after(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EqualityExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEqualityExpressionAccess().getGroup_1()); }
	(rule__EqualityExpression__Group_1__0)?
	{ after(grammarAccess.getEqualityExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EqualityExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EqualityExpression__Group_1__0__Impl
	rule__EqualityExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEqualityExpressionAccess().getExpressionOperandAction_1_0()); }
	()
	{ after(grammarAccess.getEqualityExpressionAccess().getExpressionOperandAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EqualityExpression__Group_1__1__Impl
	rule__EqualityExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_1()); }
	(rule__EqualityExpression__OperatorAssignment_1_1)
	{ after(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EqualityExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEqualityExpressionAccess().getOperandAssignment_1_2()); }
	(rule__EqualityExpression__OperandAssignment_1_2)
	{ after(grammarAccess.getEqualityExpressionAccess().getOperandAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group__0__Impl
	rule__RelationalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0()); }
	ruleadditiveExpression
	{ after(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
	(rule__RelationalExpression__Group_1__0)?
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationalExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group_1__0__Impl
	rule__RelationalExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getExpressionOperandAction_1_0()); }
	()
	{ after(grammarAccess.getRelationalExpressionAccess().getExpressionOperandAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group_1__1__Impl
	rule__RelationalExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_1()); }
	(rule__RelationalExpression__OperatorAssignment_1_1)
	{ after(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getOperandAssignment_1_2()); }
	(rule__RelationalExpression__OperandAssignment_1_2)
	{ after(grammarAccess.getRelationalExpressionAccess().getOperandAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AdditiveExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AdditiveExpression__Group__0__Impl
	rule__AdditiveExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); }
	rulemultiplicativeExpression
	{ after(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AdditiveExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); }
	(rule__AdditiveExpression__Group_1__0)?
	{ after(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AdditiveExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AdditiveExpression__Group_1__0__Impl
	rule__AdditiveExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAdditiveExpressionAccess().getExpressionOperandAction_1_0()); }
	()
	{ after(grammarAccess.getAdditiveExpressionAccess().getExpressionOperandAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AdditiveExpression__Group_1__1__Impl
	rule__AdditiveExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_1()); }
	(rule__AdditiveExpression__OperatorAssignment_1_1)
	{ after(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AdditiveExpression__Group_1__2__Impl
	rule__AdditiveExpression__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAdditiveExpressionAccess().getOperandAssignment_1_2()); }
	(rule__AdditiveExpression__OperandAssignment_1_2)
	{ after(grammarAccess.getAdditiveExpressionAccess().getOperandAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AdditiveExpression__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAdditiveExpressionAccess().getGroup_1_3()); }
	(rule__AdditiveExpression__Group_1_3__0)*
	{ after(grammarAccess.getAdditiveExpressionAccess().getGroup_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AdditiveExpression__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AdditiveExpression__Group_1_3__0__Impl
	rule__AdditiveExpression__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_3_0()); }
	'+'
	{ after(grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AdditiveExpression__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAdditiveExpressionAccess().getOperandAssignment_1_3_1()); }
	(rule__AdditiveExpression__OperandAssignment_1_3_1)
	{ after(grammarAccess.getAdditiveExpressionAccess().getOperandAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group__0__Impl
	rule__MultiplicativeExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getPrimaryExpressionParserRuleCall_0()); }
	ruleprimaryExpression
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getPrimaryExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getAlternatives_1()); }
	(rule__MultiplicativeExpression__Alternatives_1)?
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_0__0__Impl
	rule__MultiplicativeExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_0_0()); }
	()
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_0__1__Impl
	rule__MultiplicativeExpression__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_0_1()); }
	(rule__MultiplicativeExpression__OperatorAssignment_1_0_1)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_0__2__Impl
	rule__MultiplicativeExpression__Group_1_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_0_2()); }
	(rule__MultiplicativeExpression__OperandAssignment_1_0_2)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0_3()); }
	(rule__MultiplicativeExpression__Group_1_0_3__0)*
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group_1_0_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_0_3__0__Impl
	rule__MultiplicativeExpression__Group_1_0_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_3_0()); }
	'*'
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_0_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_0_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_0_3_1()); }
	(rule__MultiplicativeExpression__OperandAssignment_1_0_3_1)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_0_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_1__0__Impl
	rule__MultiplicativeExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_1_0()); }
	()
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_1__1__Impl
	rule__MultiplicativeExpression__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_1_1()); }
	(rule__MultiplicativeExpression__OperatorAssignment_1_1_1)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_1__2__Impl
	rule__MultiplicativeExpression__Group_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_1_2()); }
	(rule__MultiplicativeExpression__OperandAssignment_1_1_2)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_1_3()); }
	(rule__MultiplicativeExpression__Group_1_1_3__0)*
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group_1_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_1_3__0__Impl
	rule__MultiplicativeExpression__Group_1_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getAsteriskAsteriskKeyword_1_1_3_0()); }
	'**'
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getAsteriskAsteriskKeyword_1_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_1_3_1()); }
	(rule__MultiplicativeExpression__OperandAssignment_1_1_3_1)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_2__0__Impl
	rule__MultiplicativeExpression__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_2_0()); }
	()
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_2__1__Impl
	rule__MultiplicativeExpression__Group_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_2_1()); }
	(rule__MultiplicativeExpression__OperatorAssignment_1_2_1)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_2__2__Impl
	rule__MultiplicativeExpression__Group_1_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_2_2()); }
	(rule__MultiplicativeExpression__OperandAssignment_1_2_2)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_2_3()); }
	(rule__MultiplicativeExpression__Group_1_2_3__0)*
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group_1_2_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_2_3__0__Impl
	rule__MultiplicativeExpression__Group_1_2_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_2_3_0()); }
	'/'
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_2_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_2_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_2_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_2_3_1()); }
	(rule__MultiplicativeExpression__OperandAssignment_1_2_3_1)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_2_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_3__0__Impl
	rule__MultiplicativeExpression__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_3_0()); }
	()
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_3__1__Impl
	rule__MultiplicativeExpression__Group_1_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_3_1()); }
	(rule__MultiplicativeExpression__OperatorAssignment_1_3_1)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_3__2__Impl
	rule__MultiplicativeExpression__Group_1_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_3_2()); }
	(rule__MultiplicativeExpression__OperandAssignment_1_3_2)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_3_3()); }
	(rule__MultiplicativeExpression__Group_1_3_3__0)*
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicativeExpression__Group_1_3_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_3_3__0__Impl
	rule__MultiplicativeExpression__Group_1_3_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_3_3_0()); }
	'%'
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_3_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiplicativeExpression__Group_1_3_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__Group_1_3_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_3_3_1()); }
	(rule__MultiplicativeExpression__OperandAssignment_1_3_3_1)
	{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_3_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_0__0__Impl
	rule__PrimaryExpression__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getPlusSignKeyword_0_0()); }
	'+'
	{ after(grammarAccess.getPrimaryExpressionAccess().getPlusSignKeyword_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionParserRuleCall_0_1()); }
	ruleprimaryExpression
	{ after(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionParserRuleCall_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_1__0__Impl
	rule__PrimaryExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getExpressionAction_1_0()); }
	()
	{ after(grammarAccess.getPrimaryExpressionAccess().getExpressionAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getGroup_1_1()); }
	(rule__PrimaryExpression__Group_1_1__0)
	{ after(grammarAccess.getPrimaryExpressionAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_1_1__0__Impl
	rule__PrimaryExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getOperatorAssignment_1_1_0()); }
	(rule__PrimaryExpression__OperatorAssignment_1_1_0)
	{ after(grammarAccess.getPrimaryExpressionAccess().getOperatorAssignment_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_1_1_1()); }
	(rule__PrimaryExpression__OperandAssignment_1_1_1)
	{ after(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_2__0__Impl
	rule__PrimaryExpression__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getExpressionAction_2_0()); }
	()
	{ after(grammarAccess.getPrimaryExpressionAccess().getExpressionAction_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getGroup_2_1()); }
	(rule__PrimaryExpression__Group_2_1__0)
	{ after(grammarAccess.getPrimaryExpressionAccess().getGroup_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_2_1__0__Impl
	rule__PrimaryExpression__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getOperatorAssignment_2_1_0()); }
	(rule__PrimaryExpression__OperatorAssignment_2_1_0)
	{ after(grammarAccess.getPrimaryExpressionAccess().getOperatorAssignment_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_2_1_1()); }
	(rule__PrimaryExpression__OperandAssignment_2_1_1)
	{ after(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PrimaryExpression__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_3__0__Impl
	rule__PrimaryExpression__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0()); }
	'('
	{ after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_3__1__Impl
	rule__PrimaryExpression__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_3_1()); }
	ruleExpression
	{ after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PrimaryExpression__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2()); }
	')'
	{ after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralArrayValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralArrayValue__Group__0__Impl
	rule__LiteralArrayValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralArrayValueAccess().getLiteralArrayValueAction_0()); }
	()
	{ after(grammarAccess.getLiteralArrayValueAccess().getLiteralArrayValueAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralArrayValue__Group__1__Impl
	rule__LiteralArrayValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralArrayValueAccess().getLeftSquareBracketKeyword_1()); }
	'['
	{ after(grammarAccess.getLiteralArrayValueAccess().getLeftSquareBracketKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralArrayValue__Group__2__Impl
	rule__LiteralArrayValue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralArrayValueAccess().getGroup_2()); }
	(rule__LiteralArrayValue__Group_2__0)?
	{ after(grammarAccess.getLiteralArrayValueAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralArrayValue__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralArrayValueAccess().getRightSquareBracketKeyword_3()); }
	']'
	{ after(grammarAccess.getLiteralArrayValueAccess().getRightSquareBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralArrayValue__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralArrayValue__Group_2__0__Impl
	rule__LiteralArrayValue__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralArrayValueAccess().getValuesAssignment_2_0()); }
	(rule__LiteralArrayValue__ValuesAssignment_2_0)
	{ after(grammarAccess.getLiteralArrayValueAccess().getValuesAssignment_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralArrayValue__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralArrayValueAccess().getGroup_2_1()); }
	(rule__LiteralArrayValue__Group_2_1__0)*
	{ after(grammarAccess.getLiteralArrayValueAccess().getGroup_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralArrayValue__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralArrayValue__Group_2_1__0__Impl
	rule__LiteralArrayValue__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralArrayValueAccess().getCommaKeyword_2_1_0()); }
	','
	{ after(grammarAccess.getLiteralArrayValueAccess().getCommaKeyword_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralArrayValue__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralArrayValueAccess().getValuesAssignment_2_1_1()); }
	(rule__LiteralArrayValue__ValuesAssignment_2_1_1)
	{ after(grammarAccess.getLiteralArrayValueAccess().getValuesAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralObjectReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralObjectReference__Group__0__Impl
	rule__LiteralObjectReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralObjectReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralObjectReferenceAccess().getAmpersandKeyword_0()); }
	('&')?
	{ after(grammarAccess.getLiteralObjectReferenceAccess().getAmpersandKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralObjectReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralObjectReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralObjectReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralObjectReferenceAccess().getAlternatives_1()); }
	(rule__LiteralObjectReference__Alternatives_1)
	{ after(grammarAccess.getLiteralObjectReferenceAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralRationalValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralRationalValue__Group__0__Impl
	rule__LiteralRationalValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRationalValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRationalValueAccess().getNumeratorAssignment_0()); }
	(rule__LiteralRationalValue__NumeratorAssignment_0)
	{ after(grammarAccess.getLiteralRationalValueAccess().getNumeratorAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRationalValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralRationalValue__Group__1__Impl
	rule__LiteralRationalValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRationalValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRationalValueAccess().getSolidusKeyword_1()); }
	'/'
	{ after(grammarAccess.getLiteralRationalValueAccess().getSolidusKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRationalValue__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralRationalValue__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRationalValue__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRationalValueAccess().getDenominatorAssignment_2()); }
	(rule__LiteralRationalValue__DenominatorAssignment_2)
	{ after(grammarAccess.getLiteralRationalValueAccess().getDenominatorAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralNullValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralNullValue__Group__0__Impl
	rule__LiteralNullValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralNullValueAccess().getLiteralNullValueAction_0()); }
	()
	{ after(grammarAccess.getLiteralNullValueAccess().getLiteralNullValueAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralNullValue__Group__1__Impl
	rule__LiteralNullValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralNullValueAccess().getNullKeyword_1()); }
	'null'
	{ after(grammarAccess.getLiteralNullValueAccess().getNullKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralNullValue__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralNullValueAccess().getGroup_2()); }
	(rule__LiteralNullValue__Group_2__0)?
	{ after(grammarAccess.getLiteralNullValueAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralNullValue__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralNullValue__Group_2__0__Impl
	rule__LiteralNullValue__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralNullValueAccess().getLessThanSignKeyword_2_0()); }
	'<'
	{ after(grammarAccess.getLiteralNullValueAccess().getLessThanSignKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralNullValue__Group_2__1__Impl
	rule__LiteralNullValue__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralNullValueAccess().getTypeAssignment_2_1()); }
	(rule__LiteralNullValue__TypeAssignment_2_1)
	{ after(grammarAccess.getLiteralNullValueAccess().getTypeAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralNullValue__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralNullValueAccess().getGreaterThanSignKeyword_2_2()); }
	'>'
	{ after(grammarAccess.getLiteralNullValueAccess().getGreaterThanSignKeyword_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralTimeVariable__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralTimeVariable__Group__0__Impl
	rule__LiteralTimeVariable__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralTimeVariable__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralTimeVariableAccess().getLiteralTimeVariableAction_0()); }
	()
	{ after(grammarAccess.getLiteralTimeVariableAccess().getLiteralTimeVariableAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralTimeVariable__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralTimeVariable__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralTimeVariable__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralTimeVariableAccess().getSymbolAssignment_1()); }
	(rule__LiteralTimeVariable__SymbolAssignment_1)
	{ after(grammarAccess.getLiteralTimeVariableAccess().getSymbolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralTimeDeltaVariable__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralTimeDeltaVariable__Group__0__Impl
	rule__LiteralTimeDeltaVariable__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralTimeDeltaVariable__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralTimeDeltaVariableAccess().getLiteralTimeDeltaVariableAction_0()); }
	()
	{ after(grammarAccess.getLiteralTimeDeltaVariableAccess().getLiteralTimeDeltaVariableAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralTimeDeltaVariable__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralTimeDeltaVariable__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralTimeDeltaVariable__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolAssignment_1()); }
	(rule__LiteralTimeDeltaVariable__SymbolAssignment_1)
	{ after(grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralThisInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralThisInstance__Group__0__Impl
	rule__LiteralThisInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralThisInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralThisInstanceAccess().getLiteralThisInstanceAction_0()); }
	()
	{ after(grammarAccess.getLiteralThisInstanceAccess().getLiteralThisInstanceAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralThisInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralThisInstance__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralThisInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralThisInstanceAccess().getSymbolAssignment_1()); }
	(rule__LiteralThisInstance__SymbolAssignment_1)
	{ after(grammarAccess.getLiteralThisInstanceAccess().getSymbolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralSelfInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralSelfInstance__Group__0__Impl
	rule__LiteralSelfInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSelfInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralSelfInstanceAccess().getLiteralSelfInstanceAction_0()); }
	()
	{ after(grammarAccess.getLiteralSelfInstanceAccess().getLiteralSelfInstanceAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSelfInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralSelfInstance__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSelfInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralSelfInstanceAccess().getSymbolAssignment_1()); }
	(rule__LiteralSelfInstance__SymbolAssignment_1)
	{ after(grammarAccess.getLiteralSelfInstanceAccess().getSymbolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralParentInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralParentInstance__Group__0__Impl
	rule__LiteralParentInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralParentInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralParentInstanceAccess().getLiteralParentInstanceAction_0()); }
	()
	{ after(grammarAccess.getLiteralParentInstanceAccess().getLiteralParentInstanceAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralParentInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralParentInstance__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralParentInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralParentInstanceAccess().getSymbolAssignment_1()); }
	(rule__LiteralParentInstance__SymbolAssignment_1)
	{ after(grammarAccess.getLiteralParentInstanceAccess().getSymbolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralSuperInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralSuperInstance__Group__0__Impl
	rule__LiteralSuperInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSuperInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralSuperInstanceAccess().getLiteralSuperInstanceAction_0()); }
	()
	{ after(grammarAccess.getLiteralSuperInstanceAccess().getLiteralSuperInstanceAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSuperInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralSuperInstance__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSuperInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralSuperInstanceAccess().getSymbolAssignment_1()); }
	(rule__LiteralSuperInstance__SymbolAssignment_1)
	{ after(grammarAccess.getLiteralSuperInstanceAccess().getSymbolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralSystemInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralSystemInstance__Group__0__Impl
	rule__LiteralSystemInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSystemInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralSystemInstanceAccess().getLiteralSystemInstanceAction_0()); }
	()
	{ after(grammarAccess.getLiteralSystemInstanceAccess().getLiteralSystemInstanceAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSystemInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralSystemInstance__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSystemInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralSystemInstanceAccess().getSymbolAssignment_1()); }
	(rule__LiteralSystemInstance__SymbolAssignment_1)
	{ after(grammarAccess.getLiteralSystemInstanceAccess().getSymbolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralEnvInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralEnvInstance__Group__0__Impl
	rule__LiteralEnvInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralEnvInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralEnvInstanceAccess().getLiteralEnvInstanceAction_0()); }
	()
	{ after(grammarAccess.getLiteralEnvInstanceAccess().getLiteralEnvInstanceAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralEnvInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralEnvInstance__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralEnvInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralEnvInstanceAccess().getSymbolAssignment_1()); }
	(rule__LiteralEnvInstance__SymbolAssignment_1)
	{ after(grammarAccess.getLiteralEnvInstanceAccess().getSymbolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ELong__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ELong__Group__0__Impl
	rule__ELong__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ELong__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getELongAccess().getHyphenMinusKeyword_0()); }
	('-')?
	{ after(grammarAccess.getELongAccess().getHyphenMinusKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ELong__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ELong__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ELong__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getELongAccess().getINTTerminalRuleCall_1()); }
	RULE_INT
	{ after(grammarAccess.getELongAccess().getINTTerminalRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EDouble__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__0__Impl
	rule__EDouble__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); }
	('-')?
	{ after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__1__Impl
	rule__EDouble__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); }
	(RULE_INT)?
	{ after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__2__Impl
	rule__EDouble__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); }
	RULE_INT
	{ after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EBigDecimal__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EBigDecimal__Group__0__Impl
	rule__EBigDecimal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EBigDecimal__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEBigDecimalAccess().getINTTerminalRuleCall_0()); }
	(RULE_INT)?
	{ after(grammarAccess.getEBigDecimalAccess().getINTTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EBigDecimal__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EBigDecimal__Group__1__Impl
	rule__EBigDecimal__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EBigDecimal__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEBigDecimalAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getEBigDecimalAccess().getFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EBigDecimal__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EBigDecimal__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EBigDecimal__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEBigDecimalAccess().getINTTerminalRuleCall_2()); }
	RULE_INT
	{ after(grammarAccess.getEBigDecimalAccess().getINTTerminalRuleCall_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DeprecatedObject__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__0__Impl
	rule__DeprecatedObject__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getWObjectAction_0_0()); }
	()
	{ after(grammarAccess.getDeprecatedObjectAccess().getWObjectAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__1__Impl
	rule__DeprecatedObject__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getFormKeyword_0_1()); }
	'form'
	{ after(grammarAccess.getDeprecatedObjectAccess().getFormKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__2__Impl
	rule__DeprecatedObject__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getNameAssignment_0_2()); }
	(rule__DeprecatedObject__NameAssignment_0_2)
	{ after(grammarAccess.getDeprecatedObjectAccess().getNameAssignment_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__3__Impl
	rule__DeprecatedObject__Group_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getDescriptionAssignment_0_3()); }
	(rule__DeprecatedObject__DescriptionAssignment_0_3)?
	{ after(grammarAccess.getDeprecatedObjectAccess().getDescriptionAssignment_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__4__Impl
	rule__DeprecatedObject__Group_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getAsKeyword_0_4()); }
	'as'
	{ after(grammarAccess.getDeprecatedObjectAccess().getAsKeyword_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__5__Impl
	rule__DeprecatedObject__Group_0__6
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_0_5()); }
	('&')?
	{ after(grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_0_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__6__Impl
	rule__DeprecatedObject__Group_0__7
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getTypeAssignment_0_6()); }
	(rule__DeprecatedObject__TypeAssignment_0_6)
	{ after(grammarAccess.getDeprecatedObjectAccess().getTypeAssignment_0_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__7__Impl
	rule__DeprecatedObject__Group_0__8
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getIsKeyword_0_7()); }
	'is'
	{ after(grammarAccess.getDeprecatedObjectAccess().getIsKeyword_0_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__8__Impl
	rule__DeprecatedObject__Group_0__9
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getElementAssignment_0_8()); }
	(rule__DeprecatedObject__ElementAssignment_0_8)*
	{ after(grammarAccess.getDeprecatedObjectAccess().getElementAssignment_0_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_0__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_0__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getEndformKeyword_0_9()); }
	'endform'
	{ after(grammarAccess.getDeprecatedObjectAccess().getEndformKeyword_0_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DeprecatedObject__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__0__Impl
	rule__DeprecatedObject__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getWObjectAction_1_0()); }
	()
	{ after(grammarAccess.getDeprecatedObjectAccess().getWObjectAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__1__Impl
	rule__DeprecatedObject__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getPrototypeKeyword_1_1()); }
	'prototype'
	{ after(grammarAccess.getDeprecatedObjectAccess().getPrototypeKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__2__Impl
	rule__DeprecatedObject__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getNameAssignment_1_2()); }
	(rule__DeprecatedObject__NameAssignment_1_2)
	{ after(grammarAccess.getDeprecatedObjectAccess().getNameAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__3__Impl
	rule__DeprecatedObject__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getDescriptionAssignment_1_3()); }
	(rule__DeprecatedObject__DescriptionAssignment_1_3)?
	{ after(grammarAccess.getDeprecatedObjectAccess().getDescriptionAssignment_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__4__Impl
	rule__DeprecatedObject__Group_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getAsKeyword_1_4()); }
	'as'
	{ after(grammarAccess.getDeprecatedObjectAccess().getAsKeyword_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__5__Impl
	rule__DeprecatedObject__Group_1__6
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_1_5()); }
	('&')?
	{ after(grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_1_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__6__Impl
	rule__DeprecatedObject__Group_1__7
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getTypeAssignment_1_6()); }
	(rule__DeprecatedObject__TypeAssignment_1_6)
	{ after(grammarAccess.getDeprecatedObjectAccess().getTypeAssignment_1_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__7__Impl
	rule__DeprecatedObject__Group_1__8
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getIsKeyword_1_7()); }
	'is'
	{ after(grammarAccess.getDeprecatedObjectAccess().getIsKeyword_1_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__8__Impl
	rule__DeprecatedObject__Group_1__9
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getElementAssignment_1_8()); }
	(rule__DeprecatedObject__ElementAssignment_1_8)*
	{ after(grammarAccess.getDeprecatedObjectAccess().getElementAssignment_1_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedObject__Group_1__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__Group_1__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedObjectAccess().getEndprototypeKeyword_1_9()); }
	'endprototype'
	{ after(grammarAccess.getDeprecatedObjectAccess().getEndprototypeKeyword_1_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DeprecatedSection__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_0__0__Impl
	rule__DeprecatedSection__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getWSectionAction_0_0()); }
	()
	{ after(grammarAccess.getDeprecatedSectionAccess().getWSectionAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_0__1__Impl
	rule__DeprecatedSection__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getSectionKeyword_0_1()); }
	'section'
	{ after(grammarAccess.getDeprecatedSectionAccess().getSectionKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_0__2__Impl
	rule__DeprecatedSection__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getNameAssignment_0_2()); }
	(rule__DeprecatedSection__NameAssignment_0_2)
	{ after(grammarAccess.getDeprecatedSectionAccess().getNameAssignment_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_0__3__Impl
	rule__DeprecatedSection__Group_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_0_3()); }
	(rule__DeprecatedSection__ElementAssignment_0_3)*
	{ after(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_0__4__Impl
	rule__DeprecatedSection__Group_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getEndsectionKeyword_0_4()); }
	'endsection'
	{ after(grammarAccess.getDeprecatedSectionAccess().getEndsectionKeyword_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_0__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_0__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getXIDParserRuleCall_0_5()); }
	(ruleXID)?
	{ after(grammarAccess.getDeprecatedSectionAccess().getXIDParserRuleCall_0_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DeprecatedSection__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_1__0__Impl
	rule__DeprecatedSection__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getNameAssignment_1_0()); }
	(rule__DeprecatedSection__NameAssignment_1_0)
	{ after(grammarAccess.getDeprecatedSectionAccess().getNameAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_1__1__Impl
	rule__DeprecatedSection__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getDescriptionAssignment_1_1()); }
	(rule__DeprecatedSection__DescriptionAssignment_1_1)?
	{ after(grammarAccess.getDeprecatedSectionAccess().getDescriptionAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getAlternatives_1_2()); }
	(rule__DeprecatedSection__Alternatives_1_2)
	{ after(grammarAccess.getDeprecatedSectionAccess().getAlternatives_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DeprecatedSection__Group_1_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_1_2_0__0__Impl
	rule__DeprecatedSection__Group_1_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getLeftSquareBracketKeyword_1_2_0_0()); }
	'['
	{ after(grammarAccess.getDeprecatedSectionAccess().getLeftSquareBracketKeyword_1_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_1_2_0__1__Impl
	rule__DeprecatedSection__Group_1_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_1_2_0_1()); }
	(rule__DeprecatedSection__ElementAssignment_1_2_0_1)*
	{ after(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_1_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_1_2_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getRightSquareBracketKeyword_1_2_0_2()); }
	']'
	{ after(grammarAccess.getDeprecatedSectionAccess().getRightSquareBracketKeyword_1_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DeprecatedSection__Group_1_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_1_2_1__0__Impl
	rule__DeprecatedSection__Group_1_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getColonKeyword_1_2_1_0()); }
	':'
	{ after(grammarAccess.getDeprecatedSectionAccess().getColonKeyword_1_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedSection__Group_1_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__Group_1_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_1_2_1_1()); }
	(rule__DeprecatedSection__ElementAssignment_1_2_1_1)*
	{ after(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_1_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DeprecatedAttribute__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedAttribute__Group__0__Impl
	rule__DeprecatedAttribute__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedAttributeAccess().getWAttributeAction_0()); }
	()
	{ after(grammarAccess.getDeprecatedAttributeAccess().getWAttributeAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedAttribute__Group__1__Impl
	rule__DeprecatedAttribute__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedAttributeAccess().getNameAssignment_1()); }
	(rule__DeprecatedAttribute__NameAssignment_1)
	{ after(grammarAccess.getDeprecatedAttributeAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedAttribute__Group__2__Impl
	rule__DeprecatedAttribute__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedAttributeAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getDeprecatedAttributeAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedAttribute__Group__3__Impl
	rule__DeprecatedAttribute__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedAttributeAccess().getValueAssignment_3()); }
	(rule__DeprecatedAttribute__ValueAssignment_3)
	{ after(grammarAccess.getDeprecatedAttributeAccess().getValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedAttribute__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedAttributeAccess().getSemicolonKeyword_4()); }
	(';')?
	{ after(grammarAccess.getDeprecatedAttributeAccess().getSemicolonKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DeprecatedExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedExpression__Group__0__Impl
	rule__DeprecatedExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedExpressionAccess().getExpressionAction_0()); }
	()
	{ after(grammarAccess.getDeprecatedExpressionAccess().getExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedExpression__Group__1__Impl
	rule__DeprecatedExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedExpressionAccess().getDollarSignLeftCurlyBracketKeyword_1()); }
	'${'
	{ after(grammarAccess.getDeprecatedExpressionAccess().getDollarSignLeftCurlyBracketKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedExpression__Group__2__Impl
	rule__DeprecatedExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedExpressionAccess().getOperatorAssignment_2()); }
	(rule__DeprecatedExpression__OperatorAssignment_2)
	{ after(grammarAccess.getDeprecatedExpressionAccess().getOperatorAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedExpression__Group__3__Impl
	rule__DeprecatedExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedExpressionAccess().getOperandAssignment_3()); }
	(rule__DeprecatedExpression__OperandAssignment_3)*
	{ after(grammarAccess.getDeprecatedExpressionAccess().getOperandAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DeprecatedExpression__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDeprecatedExpressionAccess().getRightCurlyBracketKeyword_4()); }
	'}'
	{ after(grammarAccess.getDeprecatedExpressionAccess().getRightCurlyBracketKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Workflow__TypeAssignment_2_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getTypeAlternatives_2_0_0_0()); }
		(rule__Workflow__TypeAlternatives_2_0_0_0)
		{ after(grammarAccess.getWorkflowAccess().getTypeAlternatives_2_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__NameAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getNameUFIParserRuleCall_2_0_1_0()); }
		ruleUFI
		{ after(grammarAccess.getWorkflowAccess().getNameUFIParserRuleCall_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__DescriptionAssignment_2_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getDescriptionEStringParserRuleCall_2_0_2_0()); }
		ruleEString
		{ after(grammarAccess.getWorkflowAccess().getDescriptionEStringParserRuleCall_2_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__ElementAssignment_2_0_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getElementAlternatives_2_0_4_0()); }
		(rule__Workflow__ElementAlternatives_2_0_4_0)
		{ after(grammarAccess.getWorkflowAccess().getElementAlternatives_2_0_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__ElementAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getElementAlternatives_2_1_0()); }
		(rule__Workflow__ElementAlternatives_2_1_0)
		{ after(grammarAccess.getWorkflowAccess().getElementAlternatives_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Workflow__ElementAssignment_2_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorkflowAccess().getElementDeprecatedObjectParserRuleCall_2_2_0()); }
		ruleDeprecatedObject
		{ after(grammarAccess.getWorkflowAccess().getElementDeprecatedObjectParserRuleCall_2_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__TypeAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getTypeUFIParserRuleCall_0_1_0()); }
		ruleUFI
		{ after(grammarAccess.getObjectAccess().getTypeUFIParserRuleCall_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__NameAssignment_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_0_2_0()); }
		ruleUFI
		{ after(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__DescriptionAssignment_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getDescriptionEStringParserRuleCall_0_3_0()); }
		ruleEString
		{ after(grammarAccess.getObjectAccess().getDescriptionEStringParserRuleCall_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__ElementAssignment_0_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getElementAlternatives_0_5_0()); }
		(rule__Object__ElementAlternatives_0_5_0)
		{ after(grammarAccess.getObjectAccess().getElementAlternatives_0_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__NameAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_1_1_0()); }
		ruleUFI
		{ after(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__TypeAssignment_1_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getTypeUFIParserRuleCall_1_3_0_0()); }
		ruleUFI
		{ after(grammarAccess.getObjectAccess().getTypeUFIParserRuleCall_1_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__DescriptionAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getDescriptionEStringParserRuleCall_1_3_1_0()); }
		ruleEString
		{ after(grammarAccess.getObjectAccess().getDescriptionEStringParserRuleCall_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Object__ElementAssignment_1_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getObjectAccess().getElementAlternatives_1_5_0()); }
		(rule__Object__ElementAlternatives_1_5_0)
		{ after(grammarAccess.getObjectAccess().getElementAlternatives_1_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSectionAccess().getNameXIDParserRuleCall_0_0()); }
		ruleXID
		{ after(grammarAccess.getSectionAccess().getNameXIDParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__DescriptionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSectionAccess().getDescriptionEStringParserRuleCall_1_0()); }
		ruleEString
		{ after(grammarAccess.getSectionAccess().getDescriptionEStringParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__ElementAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSectionAccess().getElementAlternatives_2_0_1_0()); }
		(rule__Section__ElementAlternatives_2_0_1_0)
		{ after(grammarAccess.getSectionAccess().getElementAlternatives_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Section__ElementAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSectionAccess().getElementAlternatives_2_1_1_0()); }
		(rule__Section__ElementAlternatives_2_1_1_0)
		{ after(grammarAccess.getSectionAccess().getElementAlternatives_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAttributeAccess().getNameXIDParserRuleCall_1_0()); }
		ruleXID
		{ after(grammarAccess.getAttributeAccess().getNameXIDParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAttributeAccess().getValueValueSpecificationParserRuleCall_3_0()); }
		ruleValueSpecification
		{ after(grammarAccess.getAttributeAccess().getValueValueSpecificationParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__OperatorAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalExpressionAccess().getOperatorQuestionMarkKeyword_1_1_0()); }
		(
			{ before(grammarAccess.getConditionalExpressionAccess().getOperatorQuestionMarkKeyword_1_1_0()); }
			'?'
			{ after(grammarAccess.getConditionalExpressionAccess().getOperatorQuestionMarkKeyword_1_1_0()); }
		)
		{ after(grammarAccess.getConditionalExpressionAccess().getOperatorQuestionMarkKeyword_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__OperandAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalExpressionAccess().getOperandExpressionParserRuleCall_1_2_0()); }
		ruleExpression
		{ after(grammarAccess.getConditionalExpressionAccess().getOperandExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalExpression__OperandAssignment_1_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalExpressionAccess().getOperandExpressionParserRuleCall_1_4_0()); }
		ruleExpression
		{ after(grammarAccess.getConditionalExpressionAccess().getOperandExpressionParserRuleCall_1_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__OperatorAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalOrExpressionAccess().getOperatorAlternatives_1_1_0()); }
		(rule__ConditionalOrExpression__OperatorAlternatives_1_1_0)
		{ after(grammarAccess.getConditionalOrExpressionAccess().getOperatorAlternatives_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__OperandAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalOrExpressionAccess().getOperandConditionalAndExpressionParserRuleCall_1_2_0()); }
		ruleconditionalAndExpression
		{ after(grammarAccess.getConditionalOrExpressionAccess().getOperandConditionalAndExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalOrExpression__OperandAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalOrExpressionAccess().getOperandConditionalAndExpressionParserRuleCall_1_3_1_0()); }
		ruleconditionalAndExpression
		{ after(grammarAccess.getConditionalOrExpressionAccess().getOperandConditionalAndExpressionParserRuleCall_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__OperatorAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalAndExpressionAccess().getOperatorAlternatives_1_1_0()); }
		(rule__ConditionalAndExpression__OperatorAlternatives_1_1_0)
		{ after(grammarAccess.getConditionalAndExpressionAccess().getOperatorAlternatives_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__OperandAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_2_0()); }
		ruleequalityExpression
		{ after(grammarAccess.getConditionalAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalAndExpression__OperandAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_3_1_0()); }
		ruleequalityExpression
		{ after(grammarAccess.getConditionalAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__OperatorAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEqualityExpressionAccess().getOperatorAlternatives_1_1_0()); }
		(rule__EqualityExpression__OperatorAlternatives_1_1_0)
		{ after(grammarAccess.getEqualityExpressionAccess().getOperatorAlternatives_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EqualityExpression__OperandAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEqualityExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0()); }
		rulerelationalExpression
		{ after(grammarAccess.getEqualityExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__OperatorAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOperatorAlternatives_1_1_0()); }
		(rule__RelationalExpression__OperatorAlternatives_1_1_0)
		{ after(grammarAccess.getRelationalExpressionAccess().getOperatorAlternatives_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__OperandAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOperandAdditiveExpressionParserRuleCall_1_2_0()); }
		ruleadditiveExpression
		{ after(grammarAccess.getRelationalExpressionAccess().getOperandAdditiveExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__OperatorAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0()); }
		(
			{ before(grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0()); }
			'+'
			{ after(grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0()); }
		)
		{ after(grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__OperandAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_2_0()); }
		rulemultiplicativeExpression
		{ after(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AdditiveExpression__OperandAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_3_1_0()); }
		rulemultiplicativeExpression
		{ after(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperatorAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_0_1_0()); }
		(
			{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_0_1_0()); }
			'*'
			{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_0_1_0()); }
		)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperandAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0_2_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperandAssignment_1_0_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0_3_1_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperatorAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskAsteriskKeyword_1_1_1_0()); }
		(
			{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskAsteriskKeyword_1_1_1_0()); }
			'**'
			{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskAsteriskKeyword_1_1_1_0()); }
		)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskAsteriskKeyword_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperandAssignment_1_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_2_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperandAssignment_1_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_3_1_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperatorAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_2_1_0()); }
		(
			{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_2_1_0()); }
			'/'
			{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_2_1_0()); }
		)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperandAssignment_1_2_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_2_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperandAssignment_1_2_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_3_1_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperatorAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorPercentSignKeyword_1_3_1_0()); }
		(
			{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorPercentSignKeyword_1_3_1_0()); }
			'%'
			{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorPercentSignKeyword_1_3_1_0()); }
		)
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorPercentSignKeyword_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperandAssignment_1_3_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_3_2_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_3_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicativeExpression__OperandAssignment_1_3_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_3_3_1_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_3_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__OperatorAssignment_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_0()); }
		(
			{ before(grammarAccess.getPrimaryExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_0()); }
			'-'
			{ after(grammarAccess.getPrimaryExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_0()); }
		)
		{ after(grammarAccess.getPrimaryExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__OperandAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_1_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__OperatorAssignment_2_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getOperatorAlternatives_2_1_0_0()); }
		(rule__PrimaryExpression__OperatorAlternatives_2_1_0_0)
		{ after(grammarAccess.getPrimaryExpressionAccess().getOperatorAlternatives_2_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpression__OperandAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_2_1_1_0()); }
		ruleprimaryExpression
		{ after(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__ValuesAssignment_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralArrayValueAccess().getValuesValueSpecificationParserRuleCall_2_0_0()); }
		ruleValueSpecification
		{ after(grammarAccess.getLiteralArrayValueAccess().getValuesValueSpecificationParserRuleCall_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralArrayValue__ValuesAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralArrayValueAccess().getValuesValueSpecificationParserRuleCall_2_1_1_0()); }
		ruleValueSpecification
		{ after(grammarAccess.getLiteralArrayValueAccess().getValuesValueSpecificationParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralObjectReference__ObjectAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralObjectReferenceAccess().getObjectWObjectCrossReference_1_0_0()); }
		(
			{ before(grammarAccess.getLiteralObjectReferenceAccess().getObjectWObjectUFIParserRuleCall_1_0_0_1()); }
			ruleUFI
			{ after(grammarAccess.getLiteralObjectReferenceAccess().getObjectWObjectUFIParserRuleCall_1_0_0_1()); }
		)
		{ after(grammarAccess.getLiteralObjectReferenceAccess().getObjectWObjectCrossReference_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralObjectReference__SymbolAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralObjectReferenceAccess().getSymbolUFIParserRuleCall_1_1_0()); }
		ruleUFI
		{ after(grammarAccess.getLiteralObjectReferenceAccess().getSymbolUFIParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralBooleanValue__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralBooleanValueAccess().getValueEBooleanParserRuleCall_0()); }
		ruleEBoolean
		{ after(grammarAccess.getLiteralBooleanValueAccess().getValueEBooleanParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralCharacterValue__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralCharacterValueAccess().getValueECharParserRuleCall_0()); }
		ruleEChar
		{ after(grammarAccess.getLiteralCharacterValueAccess().getValueECharParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralIntegerValue__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralIntegerValueAccess().getValueELongParserRuleCall_0()); }
		ruleELong
		{ after(grammarAccess.getLiteralIntegerValueAccess().getValueELongParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRationalValue__NumeratorAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralRationalValueAccess().getNumeratorELongParserRuleCall_0_0()); }
		ruleELong
		{ after(grammarAccess.getLiteralRationalValueAccess().getNumeratorELongParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRationalValue__DenominatorAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralRationalValueAccess().getDenominatorELongParserRuleCall_2_0()); }
		ruleELong
		{ after(grammarAccess.getLiteralRationalValueAccess().getDenominatorELongParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralFloatValue__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralFloatValueAccess().getValueEDoubleParserRuleCall_0()); }
		ruleEDouble
		{ after(grammarAccess.getLiteralFloatValueAccess().getValueEDoubleParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralStringValue__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralStringValueAccess().getValueEStringParserRuleCall_0()); }
		ruleEString
		{ after(grammarAccess.getLiteralStringValueAccess().getValueEStringParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNullValue__TypeAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralNullValueAccess().getTypeXIDParserRuleCall_2_1_0()); }
		ruleXID
		{ after(grammarAccess.getLiteralNullValueAccess().getTypeXIDParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralTimeVariable__SymbolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralTimeVariableAccess().getSymbolTimeKeyword_1_0()); }
		(
			{ before(grammarAccess.getLiteralTimeVariableAccess().getSymbolTimeKeyword_1_0()); }
			'$time'
			{ after(grammarAccess.getLiteralTimeVariableAccess().getSymbolTimeKeyword_1_0()); }
		)
		{ after(grammarAccess.getLiteralTimeVariableAccess().getSymbolTimeKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralTimeDeltaVariable__SymbolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolDeltaKeyword_1_0()); }
		(
			{ before(grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolDeltaKeyword_1_0()); }
			'$delta'
			{ after(grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolDeltaKeyword_1_0()); }
		)
		{ after(grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolDeltaKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralThisInstance__SymbolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralThisInstanceAccess().getSymbolThisKeyword_1_0()); }
		(
			{ before(grammarAccess.getLiteralThisInstanceAccess().getSymbolThisKeyword_1_0()); }
			'$this'
			{ after(grammarAccess.getLiteralThisInstanceAccess().getSymbolThisKeyword_1_0()); }
		)
		{ after(grammarAccess.getLiteralThisInstanceAccess().getSymbolThisKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSelfInstance__SymbolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralSelfInstanceAccess().getSymbolSelfKeyword_1_0()); }
		(
			{ before(grammarAccess.getLiteralSelfInstanceAccess().getSymbolSelfKeyword_1_0()); }
			'$self'
			{ after(grammarAccess.getLiteralSelfInstanceAccess().getSymbolSelfKeyword_1_0()); }
		)
		{ after(grammarAccess.getLiteralSelfInstanceAccess().getSymbolSelfKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralParentInstance__SymbolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralParentInstanceAccess().getSymbolParentKeyword_1_0()); }
		(
			{ before(grammarAccess.getLiteralParentInstanceAccess().getSymbolParentKeyword_1_0()); }
			'$parent'
			{ after(grammarAccess.getLiteralParentInstanceAccess().getSymbolParentKeyword_1_0()); }
		)
		{ after(grammarAccess.getLiteralParentInstanceAccess().getSymbolParentKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSuperInstance__SymbolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralSuperInstanceAccess().getSymbolSuperKeyword_1_0()); }
		(
			{ before(grammarAccess.getLiteralSuperInstanceAccess().getSymbolSuperKeyword_1_0()); }
			'$super'
			{ after(grammarAccess.getLiteralSuperInstanceAccess().getSymbolSuperKeyword_1_0()); }
		)
		{ after(grammarAccess.getLiteralSuperInstanceAccess().getSymbolSuperKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralSystemInstance__SymbolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralSystemInstanceAccess().getSymbolSystemKeyword_1_0()); }
		(
			{ before(grammarAccess.getLiteralSystemInstanceAccess().getSymbolSystemKeyword_1_0()); }
			'$system'
			{ after(grammarAccess.getLiteralSystemInstanceAccess().getSymbolSystemKeyword_1_0()); }
		)
		{ after(grammarAccess.getLiteralSystemInstanceAccess().getSymbolSystemKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralEnvInstance__SymbolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralEnvInstanceAccess().getSymbolAlternatives_1_0()); }
		(rule__LiteralEnvInstance__SymbolAlternatives_1_0)
		{ after(grammarAccess.getLiteralEnvInstanceAccess().getSymbolAlternatives_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__NameAssignment_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getNameUFIParserRuleCall_0_2_0()); }
		ruleUFI
		{ after(grammarAccess.getDeprecatedObjectAccess().getNameUFIParserRuleCall_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__DescriptionAssignment_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getDescriptionEStringParserRuleCall_0_3_0()); }
		ruleEString
		{ after(grammarAccess.getDeprecatedObjectAccess().getDescriptionEStringParserRuleCall_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__TypeAssignment_0_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getTypeUFIParserRuleCall_0_6_0()); }
		ruleUFI
		{ after(grammarAccess.getDeprecatedObjectAccess().getTypeUFIParserRuleCall_0_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__ElementAssignment_0_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getElementDeprecatedPropertyParserRuleCall_0_8_0()); }
		ruleDeprecatedProperty
		{ after(grammarAccess.getDeprecatedObjectAccess().getElementDeprecatedPropertyParserRuleCall_0_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__NameAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getNameUFIParserRuleCall_1_2_0()); }
		ruleUFI
		{ after(grammarAccess.getDeprecatedObjectAccess().getNameUFIParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__DescriptionAssignment_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getDescriptionEStringParserRuleCall_1_3_0()); }
		ruleEString
		{ after(grammarAccess.getDeprecatedObjectAccess().getDescriptionEStringParserRuleCall_1_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__TypeAssignment_1_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getTypeUFIParserRuleCall_1_6_0()); }
		ruleUFI
		{ after(grammarAccess.getDeprecatedObjectAccess().getTypeUFIParserRuleCall_1_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedObject__ElementAssignment_1_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedObjectAccess().getElementDeprecatedPropertyParserRuleCall_1_8_0()); }
		ruleDeprecatedProperty
		{ after(grammarAccess.getDeprecatedObjectAccess().getElementDeprecatedPropertyParserRuleCall_1_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__NameAssignment_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_0_2_0()); }
		ruleXID
		{ after(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__ElementAssignment_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_0_3_0()); }
		(rule__DeprecatedSection__ElementAlternatives_0_3_0)
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__NameAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_1_0_0()); }
		ruleXID
		{ after(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__DescriptionAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getDescriptionEStringParserRuleCall_1_1_0()); }
		ruleEString
		{ after(grammarAccess.getDeprecatedSectionAccess().getDescriptionEStringParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__ElementAssignment_1_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_1_2_0_1_0()); }
		(rule__DeprecatedSection__ElementAlternatives_1_2_0_1_0)
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_1_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedSection__ElementAssignment_1_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_1_2_1_1_0()); }
		(rule__DeprecatedSection__ElementAlternatives_1_2_1_1_0)
		{ after(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_1_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedAttributeAccess().getNameDeprecatedAttributeIDParserRuleCall_1_0()); }
		ruleDeprecatedAttributeID
		{ after(grammarAccess.getDeprecatedAttributeAccess().getNameDeprecatedAttributeIDParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedAttribute__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedAttributeAccess().getValueValueSpecificationParserRuleCall_3_0()); }
		ruleValueSpecification
		{ after(grammarAccess.getDeprecatedAttributeAccess().getValueValueSpecificationParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__OperatorAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedExpressionAccess().getOperatorAlternatives_2_0()); }
		(rule__DeprecatedExpression__OperatorAlternatives_2_0)
		{ after(grammarAccess.getDeprecatedExpressionAccess().getOperatorAlternatives_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DeprecatedExpression__OperandAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDeprecatedExpressionAccess().getOperandValueSpecificationParserRuleCall_3_0()); }
		ruleValueSpecification
		{ after(grammarAccess.getDeprecatedExpressionAccess().getOperandValueSpecificationParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_XIDENDIFIER : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'#')*;

RULE_AT_IDENTIFIER : '@' RULE_XIDENDIFIER;

RULE_CHARACTER : '\'' . '\'';

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
