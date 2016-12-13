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
package org.eclipse.efm.sew.xtext.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.efm.sew.xtext.services.SEWGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SEWSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SEWGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Attribute_SemicolonKeyword_4_q;
	protected AbstractElementAlias match_DeprecatedAttribute_SemicolonKeyword_4_q;
	protected AbstractElementAlias match_DeprecatedObject_AmpersandKeyword_0_5_q;
	protected AbstractElementAlias match_DeprecatedObject_AmpersandKeyword_1_5_q;
	protected AbstractElementAlias match_DeprecatedSection_ColonKeyword_1_2_1_0_or___LeftSquareBracketKeyword_1_2_0_0_RightSquareBracketKeyword_1_2_0_2__;
	protected AbstractElementAlias match_DeprecatedSection_XIDParserRuleCall_0_5_q;
	protected AbstractElementAlias match_LiteralObjectReference_AmpersandKeyword_0_q;
	protected AbstractElementAlias match_Object_ColonEqualsSignKeyword_1_2_0_or_PlusSignColonEqualsSignKeyword_1_2_1;
	protected AbstractElementAlias match_Section_ColonKeyword_2_1_0_or___LeftSquareBracketKeyword_2_0_0_RightSquareBracketKeyword_2_0_2__;
	protected AbstractElementAlias match_Workflow_PrologParserRuleCall_1_q;
	protected AbstractElementAlias match_conditionalAndExpression_AmpersandAmpersandKeyword_1_3_0_0_or_AndKeyword_1_3_0_1;
	protected AbstractElementAlias match_conditionalOrExpression_OrKeyword_1_3_0_1_or_VerticalLineVerticalLineKeyword_1_3_0_0;
	protected AbstractElementAlias match_primaryExpression___LeftParenthesisKeyword_3_0_or_PlusSignKeyword_0_0__a;
	protected AbstractElementAlias match_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__a;
	protected AbstractElementAlias match_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SEWGrammarAccess) access;
		match_Attribute_SemicolonKeyword_4_q = new TokenAlias(false, true, grammarAccess.getAttributeAccess().getSemicolonKeyword_4());
		match_DeprecatedAttribute_SemicolonKeyword_4_q = new TokenAlias(false, true, grammarAccess.getDeprecatedAttributeAccess().getSemicolonKeyword_4());
		match_DeprecatedObject_AmpersandKeyword_0_5_q = new TokenAlias(false, true, grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_0_5());
		match_DeprecatedObject_AmpersandKeyword_1_5_q = new TokenAlias(false, true, grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_1_5());
		match_DeprecatedSection_ColonKeyword_1_2_1_0_or___LeftSquareBracketKeyword_1_2_0_0_RightSquareBracketKeyword_1_2_0_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getDeprecatedSectionAccess().getLeftSquareBracketKeyword_1_2_0_0()), new TokenAlias(false, false, grammarAccess.getDeprecatedSectionAccess().getRightSquareBracketKeyword_1_2_0_2())), new TokenAlias(false, false, grammarAccess.getDeprecatedSectionAccess().getColonKeyword_1_2_1_0()));
		match_DeprecatedSection_XIDParserRuleCall_0_5_q = new TokenAlias(false, true, grammarAccess.getDeprecatedSectionAccess().getXIDParserRuleCall_0_5());
		match_LiteralObjectReference_AmpersandKeyword_0_q = new TokenAlias(false, true, grammarAccess.getLiteralObjectReferenceAccess().getAmpersandKeyword_0());
		match_Object_ColonEqualsSignKeyword_1_2_0_or_PlusSignColonEqualsSignKeyword_1_2_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getObjectAccess().getColonEqualsSignKeyword_1_2_0()), new TokenAlias(false, false, grammarAccess.getObjectAccess().getPlusSignColonEqualsSignKeyword_1_2_1()));
		match_Section_ColonKeyword_2_1_0_or___LeftSquareBracketKeyword_2_0_0_RightSquareBracketKeyword_2_0_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getSectionAccess().getLeftSquareBracketKeyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getSectionAccess().getRightSquareBracketKeyword_2_0_2())), new TokenAlias(false, false, grammarAccess.getSectionAccess().getColonKeyword_2_1_0()));
		match_Workflow_PrologParserRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getWorkflowAccess().getPrologParserRuleCall_1());
		match_conditionalAndExpression_AmpersandAmpersandKeyword_1_3_0_0_or_AndKeyword_1_3_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_3_0_0()), new TokenAlias(false, false, grammarAccess.getConditionalAndExpressionAccess().getAndKeyword_1_3_0_1()));
		match_conditionalOrExpression_OrKeyword_1_3_0_1_or_VerticalLineVerticalLineKeyword_1_3_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getConditionalOrExpressionAccess().getOrKeyword_1_3_0_1()), new TokenAlias(false, false, grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_3_0_0()));
		match_primaryExpression___LeftParenthesisKeyword_3_0_or_PlusSignKeyword_0_0__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getPrimaryExpressionAccess().getPlusSignKeyword_0_0()));
		match_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__a = new GroupAlias(true, true, new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getPlusSignKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0()));
		match_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__p = new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getPlusSignKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getPrologRule())
			return getPrologToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getXIDRule())
			return getXIDToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * Prolog
	 * : ( '@sew' | '@favm' ) '<'
	 * 	( 'workflow' | 'sew' )
	 * 	( ',' EDouble )? ( ',' UFI | EString )? '>:'
	 * ;
	 */
	protected String getPrologToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "@sew<workflow>:";
	}
	
	/**
	 * XID returns ecore::EString
	 * : ReservedWord | XIDENDIFIER
	 * ;
	 */
	protected String getXIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "workflow";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Attribute_SemicolonKeyword_4_q.equals(syntax))
				emit_Attribute_SemicolonKeyword_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DeprecatedAttribute_SemicolonKeyword_4_q.equals(syntax))
				emit_DeprecatedAttribute_SemicolonKeyword_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DeprecatedObject_AmpersandKeyword_0_5_q.equals(syntax))
				emit_DeprecatedObject_AmpersandKeyword_0_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DeprecatedObject_AmpersandKeyword_1_5_q.equals(syntax))
				emit_DeprecatedObject_AmpersandKeyword_1_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DeprecatedSection_ColonKeyword_1_2_1_0_or___LeftSquareBracketKeyword_1_2_0_0_RightSquareBracketKeyword_1_2_0_2__.equals(syntax))
				emit_DeprecatedSection_ColonKeyword_1_2_1_0_or___LeftSquareBracketKeyword_1_2_0_0_RightSquareBracketKeyword_1_2_0_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DeprecatedSection_XIDParserRuleCall_0_5_q.equals(syntax))
				emit_DeprecatedSection_XIDParserRuleCall_0_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_LiteralObjectReference_AmpersandKeyword_0_q.equals(syntax))
				emit_LiteralObjectReference_AmpersandKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Object_ColonEqualsSignKeyword_1_2_0_or_PlusSignColonEqualsSignKeyword_1_2_1.equals(syntax))
				emit_Object_ColonEqualsSignKeyword_1_2_0_or_PlusSignColonEqualsSignKeyword_1_2_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Section_ColonKeyword_2_1_0_or___LeftSquareBracketKeyword_2_0_0_RightSquareBracketKeyword_2_0_2__.equals(syntax))
				emit_Section_ColonKeyword_2_1_0_or___LeftSquareBracketKeyword_2_0_0_RightSquareBracketKeyword_2_0_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Workflow_PrologParserRuleCall_1_q.equals(syntax))
				emit_Workflow_PrologParserRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_conditionalAndExpression_AmpersandAmpersandKeyword_1_3_0_0_or_AndKeyword_1_3_0_1.equals(syntax))
				emit_conditionalAndExpression_AmpersandAmpersandKeyword_1_3_0_0_or_AndKeyword_1_3_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_conditionalOrExpression_OrKeyword_1_3_0_1_or_VerticalLineVerticalLineKeyword_1_3_0_0.equals(syntax))
				emit_conditionalOrExpression_OrKeyword_1_3_0_1_or_VerticalLineVerticalLineKeyword_1_3_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_primaryExpression___LeftParenthesisKeyword_3_0_or_PlusSignKeyword_0_0__a.equals(syntax))
				emit_primaryExpression___LeftParenthesisKeyword_3_0_or_PlusSignKeyword_0_0__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__a.equals(syntax))
				emit_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__p.equals(syntax))
				emit_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     value=ValueSpecification (ambiguity) (rule end)
	 */
	protected void emit_Attribute_SemicolonKeyword_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     value=ValueSpecification (ambiguity) (rule end)
	 */
	protected void emit_DeprecatedAttribute_SemicolonKeyword_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '&'?
	 *
	 * This ambiguous syntax occurs at:
	 *     description=EString 'as' (ambiguity) type=UFI
	 *     name=UFI 'as' (ambiguity) type=UFI
	 */
	protected void emit_DeprecatedObject_AmpersandKeyword_0_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '&'?
	 *
	 * This ambiguous syntax occurs at:
	 *     description=EString 'as' (ambiguity) type=UFI
	 *     name=UFI 'as' (ambiguity) type=UFI
	 */
	protected void emit_DeprecatedObject_AmpersandKeyword_1_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ':' | ('[' ']')
	 *
	 * This ambiguous syntax occurs at:
	 *     description=EString (ambiguity) (rule end)
	 *     name=XID (ambiguity) (rule end)
	 */
	protected void emit_DeprecatedSection_ColonKeyword_1_2_1_0_or___LeftSquareBracketKeyword_1_2_0_0_RightSquareBracketKeyword_1_2_0_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     XID?
	 *
	 * This ambiguous syntax occurs at:
	 *     element+=DeprecatedAttribute 'endsection' (ambiguity) (rule end)
	 *     element+=DeprecatedObject 'endsection' (ambiguity) (rule end)
	 *     element+=Object 'endsection' (ambiguity) (rule end)
	 *     name=XID 'endsection' (ambiguity) (rule end)
	 */
	protected void emit_DeprecatedSection_XIDParserRuleCall_0_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '&'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) ('(' | '+')* (ambiguity) object=[WObject|UFI]
	 *     (rule start) ('(' | '+')* (ambiguity) symbol=UFI
	 *     (rule start) ('+' | '(')* (ambiguity) object=[WObject|UFI]
	 *     (rule start) ('+' | '(')* (ambiguity) symbol=UFI
	 *     (rule start) (ambiguity) object=[WObject|UFI]
	 *     (rule start) (ambiguity) symbol=UFI
	 */
	protected void emit_LiteralObjectReference_AmpersandKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ':=' | '+:='
	 *
	 * This ambiguous syntax occurs at:
	 *     name=UFI (ambiguity) '{' '}' (rule end)
	 *     name=UFI (ambiguity) '{' element+=Object
	 *     name=UFI (ambiguity) '{' element+=Property
	 *     name=UFI (ambiguity) type=UFI
	 */
	protected void emit_Object_ColonEqualsSignKeyword_1_2_0_or_PlusSignColonEqualsSignKeyword_1_2_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ':' | ('[' ']')
	 *
	 * This ambiguous syntax occurs at:
	 *     description=EString (ambiguity) (rule end)
	 *     name=XID (ambiguity) (rule end)
	 */
	protected void emit_Section_ColonKeyword_2_1_0_or___LeftSquareBracketKeyword_2_0_0_RightSquareBracketKeyword_2_0_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     Prolog?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) element+=DeprecatedObject
	 *     (rule start) (ambiguity) type='symbex-workflow'
	 *     (rule start) (ambiguity) type='workflow'
	 */
	protected void emit_Workflow_PrologParserRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'and' | '&&'
	 *
	 * This ambiguous syntax occurs at:
	 *     operand+=equalityExpression (ambiguity) operand+=equalityExpression
	 */
	protected void emit_conditionalAndExpression_AmpersandAmpersandKeyword_1_3_0_0_or_AndKeyword_1_3_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'or' | '||'
	 *
	 * This ambiguous syntax occurs at:
	 *     operand+=conditionalAndExpression (ambiguity) operand+=conditionalAndExpression
	 */
	protected void emit_conditionalOrExpression_OrKeyword_1_3_0_1_or_VerticalLineVerticalLineKeyword_1_3_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' | '+')*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '&'? object=[WObject|UFI]
	 *     (rule start) (ambiguity) '&'? symbol=UFI
	 *     (rule start) (ambiguity) '[' ']' (rule start)
	 *     (rule start) (ambiguity) '[' values+=ValueSpecification
	 *     (rule start) (ambiguity) 'null' '<' type=XID
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) numerator=ELong
	 *     (rule start) (ambiguity) operator='!'
	 *     (rule start) (ambiguity) operator='-'
	 *     (rule start) (ambiguity) operator='not'
	 *     (rule start) (ambiguity) symbol='$delta'
	 *     (rule start) (ambiguity) symbol='$env'
	 *     (rule start) (ambiguity) symbol='$parent'
	 *     (rule start) (ambiguity) symbol='$self'
	 *     (rule start) (ambiguity) symbol='$super'
	 *     (rule start) (ambiguity) symbol='$system'
	 *     (rule start) (ambiguity) symbol='$this'
	 *     (rule start) (ambiguity) symbol='$time'
	 *     (rule start) (ambiguity) symbol='env'
	 *     (rule start) (ambiguity) value=EBoolean
	 *     (rule start) (ambiguity) value=EChar
	 *     (rule start) (ambiguity) value=EDouble
	 *     (rule start) (ambiguity) value=ELong
	 *     (rule start) (ambiguity) value=EString
	 */
	protected void emit_primaryExpression___LeftParenthesisKeyword_3_0_or_PlusSignKeyword_0_0__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('+'* '(')*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '${' operator='|;|'
	 *     (rule start) (ambiguity) '${' operator='|i|'
	 *     (rule start) (ambiguity) {Expression.operand+=}
	 */
	protected void emit_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('+'* '(')+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '${' operator='|;|'
	 *     (rule start) (ambiguity) '${' operator='|i|'
	 *     (rule start) (ambiguity) {Expression.operand+=}
	 */
	protected void emit_primaryExpression___PlusSignKeyword_0_0_a_LeftParenthesisKeyword_3_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
