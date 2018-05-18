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
grammar InternalFormalML;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;
}

@lexer::header {
package org.eclipse.efm.formalml.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.efm.formalml.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.efm.formalml.xtext.services.FormalMLGrammarAccess;

}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/

 	private FormalMLGrammarAccess grammarAccess;

    public InternalFormalMLParser(TokenStream input, FormalMLGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Xlia";
   	}

   	@Override
   	protected FormalMLGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleXlia
entryRuleXlia returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXliaRule()); }
	iv_ruleXlia=ruleXlia
	{ $current=$iv_ruleXlia.current; }
	EOF;

// Rule Xlia
ruleXlia returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaAccess().getPrologXliaPrologObjectParserRuleCall_0_0());
				}
				lv_prolog_0_0=ruleXliaPrologObject
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaRule());
					}
					set(
						$current,
						"prolog",
						lv_prolog_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XliaPrologObject");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaAccess().getSystemSystemParserRuleCall_1_0());
				}
				lv_system_1_0=ruleSystem
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaRule());
					}
					set(
						$current,
						"system",
						lv_system_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.System");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleXliaPrologObject
entryRuleXliaPrologObject returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXliaPrologObjectRule()); }
	iv_ruleXliaPrologObject=ruleXliaPrologObject
	{ $current=$iv_ruleXliaPrologObject.current; }
	EOF;

// Rule XliaPrologObject
ruleXliaPrologObject returns [EObject current=null]
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
					lv_name_0_1='@FormalML'
					{
						newLeafNode(lv_name_0_1, grammarAccess.getXliaPrologObjectAccess().getNameFormalMLKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXliaPrologObjectRule());
						}
						setWithLastConsumed($current, "name", lv_name_0_1, null);
					}
					    |
					lv_name_0_2='@xfml'
					{
						newLeafNode(lv_name_0_2, grammarAccess.getXliaPrologObjectAccess().getNameXfmlKeyword_0_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXliaPrologObjectRule());
						}
						setWithLastConsumed($current, "name", lv_name_0_2, null);
					}
					    |
					lv_name_0_3='@fml'
					{
						newLeafNode(lv_name_0_3, grammarAccess.getXliaPrologObjectAccess().getNameFmlKeyword_0_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXliaPrologObjectRule());
						}
						setWithLastConsumed($current, "name", lv_name_0_3, null);
					}
					    |
					lv_name_0_4='@xlia'
					{
						newLeafNode(lv_name_0_4, grammarAccess.getXliaPrologObjectAccess().getNameXliaKeyword_0_0_3());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXliaPrologObjectRule());
						}
						setWithLastConsumed($current, "name", lv_name_0_4, null);
					}
					    |
					lv_name_0_5='@xfsp'
					{
						newLeafNode(lv_name_0_5, grammarAccess.getXliaPrologObjectAccess().getNameXfspKeyword_0_0_4());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXliaPrologObjectRule());
						}
						setWithLastConsumed($current, "name", lv_name_0_5, null);
					}
					    |
					lv_name_0_6='@diversity'
					{
						newLeafNode(lv_name_0_6, grammarAccess.getXliaPrologObjectAccess().getNameDiversityKeyword_0_0_5());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXliaPrologObjectRule());
						}
						setWithLastConsumed($current, "name", lv_name_0_6, null);
					}
				)
			)
		)
		otherlv_1='<'
		{
			newLeafNode(otherlv_1, grammarAccess.getXliaPrologObjectAccess().getLessThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaPrologObjectAccess().getElementsXliaPrologAttributeParserRuleCall_2_0());
				}
				lv_elements_2_0=ruleXliaPrologAttribute
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaPrologObjectRule());
					}
					add(
						$current,
						"elements",
						lv_elements_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XliaPrologAttribute");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='>:'
		{
			newLeafNode(otherlv_3, grammarAccess.getXliaPrologObjectAccess().getGreaterThanSignColonKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaPrologObjectAccess().getElementsXliaOptionObjectParserRuleCall_4_0());
				}
				lv_elements_4_0=ruleXliaOptionObject
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaPrologObjectRule());
					}
					add(
						$current,
						"elements",
						lv_elements_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XliaOptionObject");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleXliaPrologAttribute
entryRuleXliaPrologAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXliaPrologAttributeRule()); }
	iv_ruleXliaPrologAttribute=ruleXliaPrologAttribute
	{ $current=$iv_ruleXliaPrologAttribute.current; }
	EOF;

// Rule XliaPrologAttribute
ruleXliaPrologAttribute returns [EObject current=null]
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
					lv_name_0_1='system'
					{
						newLeafNode(lv_name_0_1, grammarAccess.getXliaPrologAttributeAccess().getNameSystemKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXliaPrologAttributeRule());
						}
						setWithLastConsumed($current, "name", lv_name_0_1, null);
					}
					    |
					lv_name_0_2='package'
					{
						newLeafNode(lv_name_0_2, grammarAccess.getXliaPrologAttributeAccess().getNamePackageKeyword_0_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXliaPrologAttributeRule());
						}
						setWithLastConsumed($current, "name", lv_name_0_2, null);
					}
				)
			)
		)
		(
			otherlv_1=','
			{
				newLeafNode(otherlv_1, grammarAccess.getXliaPrologAttributeAccess().getCommaKeyword_1_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getXliaPrologAttributeAccess().getValueLiteralFloatExpressionParserRuleCall_1_1_0_0());
						}
						lv_value_2_1=ruleLiteralFloatExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaPrologAttributeRule());
							}
							set(
								$current,
								"value",
								lv_value_2_1,
								"org.eclipse.efm.formalml.xtext.FormalML.LiteralFloatExpression");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getXliaPrologAttributeAccess().getValueLiteralStringExpressionParserRuleCall_1_1_0_1());
						}
						lv_value_2_2=ruleLiteralStringExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaPrologAttributeRule());
							}
							set(
								$current,
								"value",
								lv_value_2_2,
								"org.eclipse.efm.formalml.xtext.FormalML.LiteralStringExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
	)
;

// Entry rule entryRuleXliaOptionObject
entryRuleXliaOptionObject returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXliaOptionObjectRule()); }
	iv_ruleXliaOptionObject=ruleXliaOptionObject
	{ $current=$iv_ruleXliaOptionObject.current; }
	EOF;

// Rule XliaOptionObject
ruleXliaOptionObject returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0='@option'
				{
					newLeafNode(lv_name_0_0, grammarAccess.getXliaOptionObjectAccess().getNameOptionKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXliaOptionObjectRule());
					}
					setWithLastConsumed($current, "name", lv_name_0_0, "@option");
				}
			)
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getXliaOptionObjectAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaOptionObjectAccess().getElementsXliaNamedElementParserRuleCall_2_0());
				}
				lv_elements_2_0=ruleXliaNamedElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaOptionObjectRule());
					}
					add(
						$current,
						"elements",
						lv_elements_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XliaNamedElement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_3='}'
		{
			newLeafNode(otherlv_3, grammarAccess.getXliaOptionObjectAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleXliaNamedElement
entryRuleXliaNamedElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXliaNamedElementRule()); }
	iv_ruleXliaNamedElement=ruleXliaNamedElement
	{ $current=$iv_ruleXliaNamedElement.current; }
	EOF;

// Rule XliaNamedElement
ruleXliaNamedElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getXliaNamedElementAccess().getXliaObjectParserRuleCall_0());
		}
		this_XliaObject_0=ruleXliaObject
		{
			$current = $this_XliaObject_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getXliaNamedElementAccess().getXliaSectionParserRuleCall_1());
		}
		this_XliaSection_1=ruleXliaSection
		{
			$current = $this_XliaSection_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getXliaNamedElementAccess().getXliaAttributeParserRuleCall_2());
		}
		this_XliaAttribute_2=ruleXliaAttribute
		{
			$current = $this_XliaAttribute_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXliaObject
entryRuleXliaObject returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXliaObjectRule()); }
	iv_ruleXliaObject=ruleXliaObject
	{ $current=$iv_ruleXliaObject.current; }
	EOF;

// Rule XliaObject
ruleXliaObject returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_XLIA_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getXliaObjectAccess().getNameXLIA_IDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXliaObjectRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XLIA_ID");
				}
			)
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getXliaObjectAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaObjectAccess().getElementsXliaNamedElementParserRuleCall_2_0());
				}
				lv_elements_2_0=ruleXliaNamedElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaObjectRule());
					}
					add(
						$current,
						"elements",
						lv_elements_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XliaNamedElement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_3='}'
		{
			newLeafNode(otherlv_3, grammarAccess.getXliaObjectAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleXliaSection
entryRuleXliaSection returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXliaSectionRule()); }
	iv_ruleXliaSection=ruleXliaSection
	{ $current=$iv_ruleXliaSection.current; }
	EOF;

// Rule XliaSection
ruleXliaSection returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_XLIA_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getXliaSectionAccess().getNameXLIA_IDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXliaSectionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XLIA_ID");
				}
			)
		)
		otherlv_1='['
		{
			newLeafNode(otherlv_1, grammarAccess.getXliaSectionAccess().getLeftSquareBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaSectionAccess().getElementsXliaAttributeParserRuleCall_2_0());
				}
				lv_elements_2_0=ruleXliaAttribute
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaSectionRule());
					}
					add(
						$current,
						"elements",
						lv_elements_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XliaAttribute");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_3=']'
		{
			newLeafNode(otherlv_3, grammarAccess.getXliaSectionAccess().getRightSquareBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleXliaAttribute
entryRuleXliaAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXliaAttributeRule()); }
	iv_ruleXliaAttribute=ruleXliaAttribute
	{ $current=$iv_ruleXliaAttribute.current; }
	EOF;

// Rule XliaAttribute
ruleXliaAttribute returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_XLIA_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getXliaAttributeAccess().getNameXLIA_IDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getXliaAttributeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XLIA_ID");
				}
			)
		)
		otherlv_1='='
		{
			newLeafNode(otherlv_1, grammarAccess.getXliaAttributeAccess().getEqualsSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaAttributeAccess().getValueExpressionParserRuleCall_2_0());
				}
				lv_value_2_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaAttributeRule());
					}
					set(
						$current,
						"value",
						lv_value_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=';'
		{
			newLeafNode(otherlv_3, grammarAccess.getXliaAttributeAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleEBoolean
entryRuleEBoolean returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEBooleanRule()); }
	iv_ruleEBoolean=ruleEBoolean
	{ $current=$iv_ruleEBoolean.current.getText(); }
	EOF;

// Rule EBoolean
ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='true'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
		}
		    |
		kw='false'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
		}
	)
;

// Entry rule entryRuleEInt
entryRuleEInt returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEIntRule()); }
	iv_ruleEInt=ruleEInt
	{ $current=$iv_ruleEInt.current.getText(); }
	EOF;

// Rule EInt
ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
			}
		)?
		this_INT_1=RULE_INT
		{
			$current.merge(this_INT_1);
		}
		{
			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleEInteger
entryRuleEInteger returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEIntegerRule()); }
	iv_ruleEInteger=ruleEInteger
	{ $current=$iv_ruleEInteger.current.getText(); }
	EOF;

// Rule EInteger
ruleEInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getEIntegerAccess().getHyphenMinusKeyword_0());
			}
		)?
		this_INT_1=RULE_INT
		{
			$current.merge(this_INT_1);
		}
		{
			newLeafNode(this_INT_1, grammarAccess.getEIntegerAccess().getINTTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleEDouble
entryRuleEDouble returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEDoubleRule()); }
	iv_ruleEDouble=ruleEDouble
	{ $current=$iv_ruleEDouble.current.getText(); }
	EOF;

// Rule EDouble
ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
			}
		)?
		(
			this_INT_1=RULE_INT
			{
				$current.merge(this_INT_1);
			}
			{
				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
			}
		)?
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
		}
		this_INT_3=RULE_INT
		{
			$current.merge(this_INT_3);
		}
		{
			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
		}
	)
;

// Entry rule entryRuleECharacter
entryRuleECharacter returns [String current=null]:
	{ newCompositeNode(grammarAccess.getECharacterRule()); }
	iv_ruleECharacter=ruleECharacter
	{ $current=$iv_ruleECharacter.current.getText(); }
	EOF;

// Rule ECharacter
ruleECharacter returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_CHARACTER_0=RULE_CHARACTER
	{
		$current.merge(this_CHARACTER_0);
	}
	{
		newLeafNode(this_CHARACTER_0, grammarAccess.getECharacterAccess().getCHARACTERTerminalRuleCall());
	}
;

// Entry rule entryRuleEString
entryRuleEString returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEStringRule()); }
	iv_ruleEString=ruleEString
	{ $current=$iv_ruleEString.current.getText(); }
	EOF;

// Rule EString
ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_STRING_0=RULE_STRING
	{
		$current.merge(this_STRING_0);
	}
	{
		newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall());
	}
;

// Entry rule entryRuleESIdentifier
entryRuleESIdentifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getESIdentifierRule()); }
	iv_ruleESIdentifier=ruleESIdentifier
	{ $current=$iv_ruleESIdentifier.current.getText(); }
	EOF;

// Rule ESIdentifier
ruleESIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_XLIA_ID_0=RULE_XLIA_ID
	{
		$current.merge(this_XLIA_ID_0);
	}
	{
		newLeafNode(this_XLIA_ID_0, grammarAccess.getESIdentifierAccess().getXLIA_IDTerminalRuleCall());
	}
;

// Entry rule entryRuleESUfid
entryRuleESUfid returns [String current=null]:
	{ newCompositeNode(grammarAccess.getESUfidRule()); }
	iv_ruleESUfid=ruleESUfid
	{ $current=$iv_ruleESUfid.current.getText(); }
	EOF;

// Rule ESUfid
ruleESUfid returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_XLIA_ID_0=RULE_XLIA_ID
		{
			$current.merge(this_XLIA_ID_0);
		}
		{
			newLeafNode(this_XLIA_ID_0, grammarAccess.getESUfidAccess().getXLIA_IDTerminalRuleCall_0());
		}
		(
			(
				kw='.'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getESUfidAccess().getFullStopKeyword_1_0_0());
				}
				    |
				kw=':'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getESUfidAccess().getColonKeyword_1_0_1());
				}
				    |
				kw='::'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getESUfidAccess().getColonColonKeyword_1_0_2());
				}
			)
			this_XLIA_ID_4=RULE_XLIA_ID
			{
				$current.merge(this_XLIA_ID_4);
			}
			{
				newLeafNode(this_XLIA_ID_4, grammarAccess.getESUfidAccess().getXLIA_IDTerminalRuleCall_1_1());
			}
		)*
	)
;

// Entry rule entryRuleUnrestrictedName
entryRuleUnrestrictedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getUnrestrictedNameRule()); }
	iv_ruleUnrestrictedName=ruleUnrestrictedName
	{ $current=$iv_ruleUnrestrictedName.current.getText(); }
	EOF;

// Rule UnrestrictedName
ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_STRING_0=RULE_STRING
	{
		$current.merge(this_STRING_0);
	}
	{
		newLeafNode(this_STRING_0, grammarAccess.getUnrestrictedNameAccess().getSTRINGTerminalRuleCall());
	}
;

// Entry rule entryRuleUnqualifiedName
entryRuleUnqualifiedName returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnqualifiedNameRule()); }
	iv_ruleUnqualifiedName=ruleUnqualifiedName
	{ $current=$iv_ruleUnqualifiedName.current; }
	EOF;

// Rule UnqualifiedName
ruleUnqualifiedName returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getUnqualifiedNameAccess().getNameBindingNameBindingParserRuleCall_0());
			}
			lv_nameBinding_0_0=ruleNameBinding
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getUnqualifiedNameRule());
				}
				add(
					$current,
					"nameBinding",
					lv_nameBinding_0_0,
					"org.eclipse.efm.formalml.xtext.FormalML.NameBinding");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleNameBinding
entryRuleNameBinding returns [String current=null]:
	{ newCompositeNode(grammarAccess.getNameBindingRule()); }
	iv_ruleNameBinding=ruleNameBinding
	{ $current=$iv_ruleNameBinding.current.getText(); }
	EOF;

// Rule NameBinding
ruleNameBinding returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_XLIA_ID_0=RULE_XLIA_ID
	{
		$current.merge(this_XLIA_ID_0);
	}
	{
		newLeafNode(this_XLIA_ID_0, grammarAccess.getNameBindingAccess().getXLIA_IDTerminalRuleCall());
	}
;

// Entry rule entryRuleSystem
entryRuleSystem returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getSystemAccess().getUnorderedGroup_0()
	);
}:
	{ newCompositeNode(grammarAccess.getSystemRule()); }
	iv_ruleSystem=ruleSystem
	{ $current=$iv_ruleSystem.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule System
ruleSystem returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getSystemAccess().getUnorderedGroup_0()
	);
}
@after {
	leaveRule();
}:
	(
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getSystemAccess().getUnorderedGroup_0());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getSystemAccess().getVisibilityVisibilityKindEnumRuleCall_0_0_0());
									}
									lv_visibility_1_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getSystemRule());
										}
										set(
											$current,
											"visibility",
											lv_visibility_1_0,
											"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 1);
					}
								({true}?=>((
									lv_timed_2_0='timed'
									{
										newLeafNode(lv_timed_2_0, grammarAccess.getSystemAccess().getTimedTimedKeyword_0_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getSystemRule());
										}
										setWithLastConsumed($current, "timed", true, "timed");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 2);
					}
								({true}?=>((
									lv_dense_timed_3_0='dense_timed'
									{
										newLeafNode(lv_dense_timed_3_0, grammarAccess.getSystemAccess().getDense_timedDense_timedKeyword_0_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getSystemRule());
										}
										setWithLastConsumed($current, "dense_timed", true, "dense_timed");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 3);
					}
								({true}?=>((
									lv_discrete_timed_4_0='discrete_timed'
									{
										newLeafNode(lv_discrete_timed_4_0, grammarAccess.getSystemAccess().getDiscrete_timedDiscrete_timedKeyword_0_3_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getSystemRule());
										}
										setWithLastConsumed($current, "discrete_timed", true, "discrete_timed");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 4);
					}
								({true}?=>((
									lv_input_enabled_5_0='input_enabled'
									{
										newLeafNode(lv_input_enabled_5_0, grammarAccess.getSystemAccess().getInput_enabledInput_enabledKeyword_0_4_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getSystemRule());
										}
										setWithLastConsumed($current, "input_enabled", true, "input_enabled");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getSystemAccess().getUnorderedGroup_0(), 5);
					}
								({true}?=>((
									lv_unsafe_6_0='unsafe'
									{
										newLeafNode(lv_unsafe_6_0, grammarAccess.getSystemAccess().getUnsafeUnsafeKeyword_0_5_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getSystemRule());
										}
										setWithLastConsumed($current, "unsafe", true, "unsafe");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemAccess().getUnorderedGroup_0());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getSystemAccess().getUnorderedGroup_0());
				}
		)
		otherlv_7='system'
		{
			newLeafNode(otherlv_7, grammarAccess.getSystemAccess().getSystemKeyword_1());
		}
		(
			otherlv_8='<'
			{
				newLeafNode(otherlv_8, grammarAccess.getSystemAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_9='moc:'
				{
					newLeafNode(otherlv_9, grammarAccess.getSystemAccess().getMocKeyword_2_1());
				}
			)?
			(
				otherlv_10='and'
				{
					newLeafNode(otherlv_10, grammarAccess.getSystemAccess().getAndKeyword_2_2_0());
				}
				    |
				otherlv_11='or'
				{
					newLeafNode(otherlv_11, grammarAccess.getSystemAccess().getOrKeyword_2_2_1());
				}
			)
			otherlv_12='>'
			{
				newLeafNode(otherlv_12, grammarAccess.getSystemAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getSystemAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_13_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSystemRule());
					}
					set(
						$current,
						"name",
						lv_name_13_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSystemAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_14_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSystemRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_14_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_15='{'
		{
			newLeafNode(otherlv_15, grammarAccess.getSystemAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getPortPortParserRuleCall_6_0_0());
					}
					lv_port_16_0=rulePort
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						add(
							$current,
							"port",
							lv_port_16_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Port");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getSignalSignalParserRuleCall_6_1_0());
					}
					lv_signal_17_0=ruleSignal
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						add(
							$current,
							"signal",
							lv_signal_17_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Signal");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getBufferBufferParserRuleCall_6_2_0());
					}
					lv_buffer_18_0=ruleBuffer
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						add(
							$current,
							"buffer",
							lv_buffer_18_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Buffer");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getChannelChannelParserRuleCall_6_3_0());
					}
					lv_channel_19_0=ruleChannel
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						add(
							$current,
							"channel",
							lv_channel_19_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Channel");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getTypedefTypeDefinitionParserRuleCall_6_4_0());
					}
					lv_typedef_20_0=ruleTypeDefinition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						add(
							$current,
							"typedef",
							lv_typedef_20_0,
							"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getFunctionFunctionParserRuleCall_6_5_0());
					}
					lv_function_21_0=ruleFunction
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						add(
							$current,
							"function",
							lv_function_21_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Function");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getVariableVariableParserRuleCall_6_6_0());
					}
					lv_variable_22_0=ruleVariable
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						add(
							$current,
							"variable",
							lv_variable_22_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Variable");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			(
				otherlv_23='@property:'
				{
					newLeafNode(otherlv_23, grammarAccess.getSystemAccess().getPropertyKeyword_7_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getPortPortParserRuleCall_7_0_1_0_0());
							}
							lv_port_24_0=rulePort
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"port",
									lv_port_24_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Port");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getSignalSignalParserRuleCall_7_0_1_1_0());
							}
							lv_signal_25_0=ruleSignal
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"signal",
									lv_signal_25_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Signal");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getBufferBufferParserRuleCall_7_0_1_2_0());
							}
							lv_buffer_26_0=ruleBuffer
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_26_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Buffer");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getChannelChannelParserRuleCall_7_0_1_3_0());
							}
							lv_channel_27_0=ruleChannel
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"channel",
									lv_channel_27_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Channel");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getTypedefTypeDefinitionParserRuleCall_7_0_1_4_0());
							}
							lv_typedef_28_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_28_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getFunctionFunctionParserRuleCall_7_0_1_5_0());
							}
							lv_function_29_0=ruleFunction
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"function",
									lv_function_29_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Function");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getVariableVariableParserRuleCall_7_0_1_6_0());
							}
							lv_variable_30_0=ruleVariable
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"variable",
									lv_variable_30_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Variable");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_31='@public:'
				{
					newLeafNode(otherlv_31, grammarAccess.getSystemAccess().getPublicKeyword_7_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getPortPortPublicParserRuleCall_7_1_1_0_0());
							}
							lv_port_32_0=rulePortPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"port",
									lv_port_32_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getSignalSignalPublicParserRuleCall_7_1_1_1_0());
							}
							lv_signal_33_0=ruleSignalPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"signal",
									lv_signal_33_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getBufferBufferPublicParserRuleCall_7_1_1_2_0());
							}
							lv_buffer_34_0=ruleBufferPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_34_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getChannelChannelPublicParserRuleCall_7_1_1_3_0());
							}
							lv_channel_35_0=ruleChannelPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"channel",
									lv_channel_35_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getTypedefTypeDefinitionParserRuleCall_7_1_1_4_0());
							}
							lv_typedef_36_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_36_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getFunctionFunctionPublicParserRuleCall_7_1_1_5_0());
							}
							lv_function_37_0=ruleFunctionPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"function",
									lv_function_37_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getVariableVariablePublicParserRuleCall_7_1_1_6_0());
							}
							lv_variable_38_0=ruleVariablePublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"variable",
									lv_variable_38_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_39='@protected:'
				{
					newLeafNode(otherlv_39, grammarAccess.getSystemAccess().getProtectedKeyword_7_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getPortPortProtectedParserRuleCall_7_2_1_0_0());
							}
							lv_port_40_0=rulePortProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"port",
									lv_port_40_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getSignalSignalProtectedParserRuleCall_7_2_1_1_0());
							}
							lv_signal_41_0=ruleSignalProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"signal",
									lv_signal_41_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getBufferBufferProtectedParserRuleCall_7_2_1_2_0());
							}
							lv_buffer_42_0=ruleBufferProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_42_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getChannelChannelProtectedParserRuleCall_7_2_1_3_0());
							}
							lv_channel_43_0=ruleChannelProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"channel",
									lv_channel_43_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getTypedefTypeDefinitionParserRuleCall_7_2_1_4_0());
							}
							lv_typedef_44_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_44_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getFunctionFunctionProtectedParserRuleCall_7_2_1_5_0());
							}
							lv_function_45_0=ruleFunctionProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"function",
									lv_function_45_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getVariableVariableProtectedParserRuleCall_7_2_1_6_0());
							}
							lv_variable_46_0=ruleVariableProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"variable",
									lv_variable_46_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariableProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_47='@private:'
				{
					newLeafNode(otherlv_47, grammarAccess.getSystemAccess().getPrivateKeyword_7_3_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getPortPortPrivateParserRuleCall_7_3_1_0_0());
							}
							lv_port_48_0=rulePortPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"port",
									lv_port_48_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getSignalSignalPrivateParserRuleCall_7_3_1_1_0());
							}
							lv_signal_49_0=ruleSignalPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"signal",
									lv_signal_49_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getBufferBufferPrivateParserRuleCall_7_3_1_2_0());
							}
							lv_buffer_50_0=ruleBufferPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_50_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getChannelChannelPrivateParserRuleCall_7_3_1_3_0());
							}
							lv_channel_51_0=ruleChannelPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"channel",
									lv_channel_51_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getTypedefTypeDefinitionParserRuleCall_7_3_1_4_0());
							}
							lv_typedef_52_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_52_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getFunctionFunctionPrivateParserRuleCall_7_3_1_5_0());
							}
							lv_function_53_0=ruleFunctionPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"function",
									lv_function_53_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getVariableVariablePrivateParserRuleCall_7_3_1_6_0());
							}
							lv_variable_54_0=ruleVariablePrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"variable",
									lv_variable_54_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)*
		(
			(
				(
					(
						otherlv_55='@routine:'
						{
							newLeafNode(otherlv_55, grammarAccess.getSystemAccess().getRoutineKeyword_8_0_0_0_0());
						}
						    |
						otherlv_56='@macro:'
						{
							newLeafNode(otherlv_56, grammarAccess.getSystemAccess().getMacroKeyword_8_0_0_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getRoutineRoutineParserRuleCall_8_0_0_1_0());
							}
							lv_routine_57_0=ruleRoutine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"routine",
									lv_routine_57_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Routine");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
				    |
				(
					otherlv_58='@procedure:'
					{
						newLeafNode(otherlv_58, grammarAccess.getSystemAccess().getProcedureKeyword_8_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getProcedureProcedureParserRuleCall_8_0_1_1_0());
							}
							lv_procedure_59_0=ruleProcedure
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"procedure",
									lv_procedure_59_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Procedure");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
			)*
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getSystemAccess().getRoutineRoutineParserRuleCall_8_1_0_0());
						}
						lv_routine_60_0=ruleRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSystemRule());
							}
							add(
								$current,
								"routine",
								lv_routine_60_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Routine");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getSystemAccess().getProcedureProcedureParserRuleCall_8_1_1_0());
						}
						lv_procedure_61_0=ruleProcedure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSystemRule());
							}
							add(
								$current,
								"procedure",
								lv_procedure_61_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Procedure");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)+
		)
		(
			(
				(
					otherlv_62='@composite:'
					{
						newLeafNode(otherlv_62, grammarAccess.getSystemAccess().getCompositeKeyword_9_0_0_0());
					}
					    |
					otherlv_63='@machine:'
					{
						newLeafNode(otherlv_63, grammarAccess.getSystemAccess().getMachineKeyword_9_0_0_1());
					}
				)
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getMachineAnyMachineBlockParserRuleCall_9_0_1_0_0());
							}
							lv_machine_64_0=ruleAnyMachineBlock
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"machine",
									lv_machine_64_0,
									"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSystemAccess().getInstanceInstanceMachineParserRuleCall_9_0_1_1_0());
							}
							lv_instance_65_0=ruleInstanceMachine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSystemRule());
								}
								add(
									$current,
									"instance",
									lv_instance_65_0,
									"org.eclipse.efm.formalml.xtext.FormalML.InstanceMachine");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)+
			)
			    |
			(
				otherlv_66='@model:'
				{
					newLeafNode(otherlv_66, grammarAccess.getSystemAccess().getModelKeyword_9_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSystemAccess().getMachineAnyMachineBlockParserRuleCall_9_1_1_0());
						}
						lv_machine_67_0=ruleAnyMachineBlock
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSystemRule());
							}
							add(
								$current,
								"machine",
								lv_machine_67_0,
								"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_68='@prototype:'
				{
					newLeafNode(otherlv_68, grammarAccess.getSystemAccess().getPrototypeKeyword_9_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSystemAccess().getMachineAnyMachineBlockParserRuleCall_9_2_1_0());
						}
						lv_machine_69_0=ruleAnyMachineBlock
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSystemRule());
							}
							add(
								$current,
								"machine",
								lv_machine_69_0,
								"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_70='@instance:'
				{
					newLeafNode(otherlv_70, grammarAccess.getSystemAccess().getInstanceKeyword_9_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSystemAccess().getInstanceInstanceMachineParserRuleCall_9_3_1_0());
						}
						lv_instance_71_0=ruleInstanceMachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSystemRule());
							}
							add(
								$current,
								"instance",
								lv_instance_71_0,
								"org.eclipse.efm.formalml.xtext.FormalML.InstanceMachine");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)*
		(
			(
				otherlv_72='@behavior:'
				{
					newLeafNode(otherlv_72, grammarAccess.getSystemAccess().getBehaviorKeyword_10_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSystemAccess().getBehaviorBehaviorParserRuleCall_10_0_1_0());
						}
						lv_behavior_73_0=ruleBehavior
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSystemRule());
							}
							add(
								$current,
								"behavior",
								lv_behavior_73_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Behavior");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)
			    |
			(
				otherlv_74='@statemachine:'
				{
					newLeafNode(otherlv_74, grammarAccess.getSystemAccess().getStatemachineKeyword_10_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSystemAccess().getBehaviorStatemachineParserRuleCall_10_1_1_0());
						}
						lv_behavior_75_0=ruleStatemachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSystemRule());
							}
							add(
								$current,
								"behavior",
								lv_behavior_75_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Statemachine");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getSystemAccess().getMainMoeBehaviorParserRuleCall_11_0());
				}
				lv_main_76_0=ruleMoeBehavior
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSystemRule());
					}
					set(
						$current,
						"main",
						lv_main_76_0,
						"org.eclipse.efm.formalml.xtext.FormalML.MoeBehavior");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_77='}'
		{
			newLeafNode(otherlv_77, grammarAccess.getSystemAccess().getRightCurlyBracketKeyword_12());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleAnyMachineBlock
entryRuleAnyMachineBlock returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnyMachineBlockRule()); }
	iv_ruleAnyMachineBlock=ruleAnyMachineBlock
	{ $current=$iv_ruleAnyMachineBlock.current; }
	EOF;

// Rule AnyMachineBlock
ruleAnyMachineBlock returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getAnyMachineBlockAccess().getMachineBlockParserRuleCall_0());
		}
		this_MachineBlock_0=ruleMachineBlock
		{
			$current = $this_MachineBlock_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getAnyMachineBlockAccess().getStatemachineParserRuleCall_1());
		}
		this_Statemachine_1=ruleStatemachine
		{
			$current = $this_Statemachine_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleInstanceMachine
entryRuleInstanceMachine returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInstanceMachineRule()); }
	iv_ruleInstanceMachine=ruleInstanceMachine
	{ $current=$iv_ruleInstanceMachine.current; }
	EOF;

// Rule InstanceMachine
ruleInstanceMachine returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='instance'
		{
			newLeafNode(otherlv_0, grammarAccess.getInstanceMachineAccess().getInstanceKeyword_0());
		}
		(
			otherlv_1='machine'
			{
				newLeafNode(otherlv_1, grammarAccess.getInstanceMachineAccess().getMachineKeyword_1_0());
			}
			    |
			otherlv_2='statemachine'
			{
				newLeafNode(otherlv_2, grammarAccess.getInstanceMachineAccess().getStatemachineKeyword_1_1());
			}
		)?
		otherlv_3='<'
		{
			newLeafNode(otherlv_3, grammarAccess.getInstanceMachineAccess().getLessThanSignKeyword_2());
		}
		(
			otherlv_4='model:'
			{
				newLeafNode(otherlv_4, grammarAccess.getInstanceMachineAccess().getModelKeyword_3());
			}
		)?
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getInstanceMachineRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getInstanceMachineAccess().getModelMachineCrossReference_4_0());
				}
				ruleESUfid
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='>'
		{
			newLeafNode(otherlv_6, grammarAccess.getInstanceMachineAccess().getGreaterThanSignKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getInstanceMachineAccess().getNameESIdentifierParserRuleCall_6_0());
				}
				lv_name_7_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInstanceMachineRule());
					}
					set(
						$current,
						"name",
						lv_name_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getInstanceMachineAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_7_0());
				}
				lv_unrestrictedName_8_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInstanceMachineRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					otherlv_9='('
					{
						newLeafNode(otherlv_9, grammarAccess.getInstanceMachineAccess().getLeftParenthesisKeyword_8_0_0_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getInstanceMachineAccess().getSlotSlotParameterParserRuleCall_8_0_0_1_0_0());
								}
								lv_slot_10_0=ruleSlotParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getInstanceMachineRule());
									}
									add(
										$current,
										"slot",
										lv_slot_10_0,
										"org.eclipse.efm.formalml.xtext.FormalML.SlotParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							otherlv_11=','
							{
								newLeafNode(otherlv_11, grammarAccess.getInstanceMachineAccess().getCommaKeyword_8_0_0_1_1_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getInstanceMachineAccess().getSlotSlotParameterParserRuleCall_8_0_0_1_1_1_0());
									}
									lv_slot_12_0=ruleSlotParameter
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getInstanceMachineRule());
										}
										add(
											$current,
											"slot",
											lv_slot_12_0,
											"org.eclipse.efm.formalml.xtext.FormalML.SlotParameter");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)*
					)?
					otherlv_13=')'
					{
						newLeafNode(otherlv_13, grammarAccess.getInstanceMachineAccess().getRightParenthesisKeyword_8_0_0_2());
					}
				)?
				otherlv_14=';'
				{
					newLeafNode(otherlv_14, grammarAccess.getInstanceMachineAccess().getSemicolonKeyword_8_0_1());
				}
			)
			    |
			(
				otherlv_15='{'
				{
					newLeafNode(otherlv_15, grammarAccess.getInstanceMachineAccess().getLeftCurlyBracketKeyword_8_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getInstanceMachineAccess().getSlotSlotPropertyParserRuleCall_8_1_1_0_0());
							}
							lv_slot_16_0=ruleSlotProperty
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getInstanceMachineRule());
								}
								add(
									$current,
									"slot",
									lv_slot_16_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SlotProperty");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_17=';'
					{
						newLeafNode(otherlv_17, grammarAccess.getInstanceMachineAccess().getSemicolonKeyword_8_1_1_1());
					}
				)*
				otherlv_18='}'
				{
					newLeafNode(otherlv_18, grammarAccess.getInstanceMachineAccess().getRightCurlyBracketKeyword_8_1_2());
				}
			)
		)
	)
;

// Entry rule entryRuleSlotParameter
entryRuleSlotParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSlotParameterRule()); }
	iv_ruleSlotParameter=ruleSlotParameter
	{ $current=$iv_ruleSlotParameter.current; }
	EOF;

// Rule SlotParameter
ruleSlotParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSlotParameterRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSlotParameterAccess().getXliaPropertyPropertyDefinitionCrossReference_0_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=':'
			{
				newLeafNode(otherlv_1, grammarAccess.getSlotParameterAccess().getColonKeyword_1_0());
			}
			    |
			otherlv_2='='
			{
				newLeafNode(otherlv_2, grammarAccess.getSlotParameterAccess().getEqualsSignKeyword_1_1());
			}
			    |
			otherlv_3=':='
			{
				newLeafNode(otherlv_3, grammarAccess.getSlotParameterAccess().getColonEqualsSignKeyword_1_2());
			}
			    |
			otherlv_4='::='
			{
				newLeafNode(otherlv_4, grammarAccess.getSlotParameterAccess().getColonColonEqualsSignKeyword_1_3());
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSlotParameterAccess().getValueExpressionParserRuleCall_2_0());
				}
				lv_value_5_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSlotParameterRule());
					}
					set(
						$current,
						"value",
						lv_value_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleSlotProperty
entryRuleSlotProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSlotPropertyRule()); }
	iv_ruleSlotProperty=ruleSlotProperty
	{ $current=$iv_ruleSlotProperty.current; }
	EOF;

// Rule SlotProperty
ruleSlotProperty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSlotPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSlotPropertyAccess().getXliaPropertyPropertyDefinitionCrossReference_0_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='='
			{
				newLeafNode(otherlv_1, grammarAccess.getSlotPropertyAccess().getEqualsSignKeyword_1_0());
			}
			    |
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getSlotPropertyAccess().getColonKeyword_1_1());
			}
			    |
			otherlv_3=':='
			{
				newLeafNode(otherlv_3, grammarAccess.getSlotPropertyAccess().getColonEqualsSignKeyword_1_2());
			}
			    |
			otherlv_4='::='
			{
				newLeafNode(otherlv_4, grammarAccess.getSlotPropertyAccess().getColonColonEqualsSignKeyword_1_3());
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSlotPropertyAccess().getValueExpressionParserRuleCall_2_0());
				}
				lv_value_5_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSlotPropertyRule());
					}
					set(
						$current,
						"value",
						lv_value_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleMachineBlock
entryRuleMachineBlock returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMachineBlockAccess().getUnorderedGroup_0()
	);
}:
	{ newCompositeNode(grammarAccess.getMachineBlockRule()); }
	iv_ruleMachineBlock=ruleMachineBlock
	{ $current=$iv_ruleMachineBlock.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule MachineBlock
ruleMachineBlock returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMachineBlockAccess().getUnorderedGroup_0()
	);
}
@after {
	leaveRule();
}:
	(
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getMachineBlockAccess().getVisibilityVisibilityKindEnumRuleCall_0_0_0());
									}
									lv_visibility_1_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
										}
										set(
											$current,
											"visibility",
											lv_visibility_1_0,
											"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 1);
					}
								({true}?=>((
									lv_timed_2_0='timed'
									{
										newLeafNode(lv_timed_2_0, grammarAccess.getMachineBlockAccess().getTimedTimedKeyword_0_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getMachineBlockRule());
										}
										setWithLastConsumed($current, "timed", true, "timed");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 2);
					}
								({true}?=>((
									lv_input_enabled_3_0='input_enabled'
									{
										newLeafNode(lv_input_enabled_3_0, grammarAccess.getMachineBlockAccess().getInput_enabledInput_enabledKeyword_0_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getMachineBlockRule());
										}
										setWithLastConsumed($current, "input_enabled", true, "input_enabled");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 3);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getMachineBlockAccess().getDesignDesignKindEnumRuleCall_0_3_0());
									}
									lv_design_4_0=ruleDesignKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
										}
										set(
											$current,
											"design",
											lv_design_4_0,
											"org.eclipse.efm.formalml.xtext.FormalML.DesignKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0());
				}
		)
		otherlv_5='machine'
		{
			newLeafNode(otherlv_5, grammarAccess.getMachineBlockAccess().getMachineKeyword_1());
		}
		(
			otherlv_6='<'
			{
				newLeafNode(otherlv_6, grammarAccess.getMachineBlockAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_7='moc:'
				{
					newLeafNode(otherlv_7, grammarAccess.getMachineBlockAccess().getMocKeyword_2_1());
				}
			)?
			(
				otherlv_8='and'
				{
					newLeafNode(otherlv_8, grammarAccess.getMachineBlockAccess().getAndKeyword_2_2_0());
				}
				    |
				otherlv_9='or'
				{
					newLeafNode(otherlv_9, grammarAccess.getMachineBlockAccess().getOrKeyword_2_2_1());
				}
			)
			otherlv_10='>'
			{
				newLeafNode(otherlv_10, grammarAccess.getMachineBlockAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getMachineBlockAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_11_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
					}
					set(
						$current,
						"name",
						lv_name_11_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMachineBlockAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_12_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_12_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_13='{'
		{
			newLeafNode(otherlv_13, grammarAccess.getMachineBlockAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortParserRuleCall_6_0_0());
					}
					lv_port_14_0=rulePort
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"port",
							lv_port_14_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Port");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getMachineBlockAccess().getSignalSignalParserRuleCall_6_1_0());
					}
					lv_signal_15_0=ruleSignal
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"signal",
							lv_signal_15_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Signal");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getMachineBlockAccess().getBufferBufferParserRuleCall_6_2_0());
					}
					lv_buffer_16_0=ruleBuffer
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"buffer",
							lv_buffer_16_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Buffer");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getMachineBlockAccess().getChannelChannelParserRuleCall_6_3_0());
					}
					lv_channel_17_0=ruleChannel
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"channel",
							lv_channel_17_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Channel");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getMachineBlockAccess().getTypedefTypeDefinitionParserRuleCall_6_4_0());
					}
					lv_typedef_18_0=ruleTypeDefinition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"typedef",
							lv_typedef_18_0,
							"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getMachineBlockAccess().getFunctionFunctionParserRuleCall_6_5_0());
					}
					lv_function_19_0=ruleFunction
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"function",
							lv_function_19_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Function");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getMachineBlockAccess().getVariableVariableParserRuleCall_6_6_0());
					}
					lv_variable_20_0=ruleVariable
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"variable",
							lv_variable_20_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Variable");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			(
				otherlv_21='@property:'
				{
					newLeafNode(otherlv_21, grammarAccess.getMachineBlockAccess().getPropertyKeyword_7_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortParserRuleCall_7_0_1_0_0());
							}
							lv_port_22_0=rulePort
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"port",
									lv_port_22_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Port");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getSignalSignalParserRuleCall_7_0_1_1_0());
							}
							lv_signal_23_0=ruleSignal
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"signal",
									lv_signal_23_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Signal");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getBufferBufferParserRuleCall_7_0_1_2_0());
							}
							lv_buffer_24_0=ruleBuffer
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_24_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Buffer");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getChannelChannelParserRuleCall_7_0_1_3_0());
							}
							lv_channel_25_0=ruleChannel
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"channel",
									lv_channel_25_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Channel");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getTypedefTypeDefinitionParserRuleCall_7_0_1_4_0());
							}
							lv_typedef_26_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_26_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getFunctionFunctionParserRuleCall_7_0_1_5_0());
							}
							lv_function_27_0=ruleFunction
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"function",
									lv_function_27_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Function");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getVariableVariableParserRuleCall_7_0_1_6_0());
							}
							lv_variable_28_0=ruleVariable
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"variable",
									lv_variable_28_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Variable");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_29='@public:'
				{
					newLeafNode(otherlv_29, grammarAccess.getMachineBlockAccess().getPublicKeyword_7_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortPublicParserRuleCall_7_1_1_0_0());
							}
							lv_port_30_0=rulePortPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"port",
									lv_port_30_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getSignalSignalPublicParserRuleCall_7_1_1_1_0());
							}
							lv_signal_31_0=ruleSignalPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"signal",
									lv_signal_31_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getBufferBufferPublicParserRuleCall_7_1_1_2_0());
							}
							lv_buffer_32_0=ruleBufferPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_32_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getChannelChannelPublicParserRuleCall_7_1_1_3_0());
							}
							lv_channel_33_0=ruleChannelPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"channel",
									lv_channel_33_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getTypedefTypeDefinitionParserRuleCall_7_1_1_4_0());
							}
							lv_typedef_34_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_34_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getFunctionFunctionPublicParserRuleCall_7_1_1_5_0());
							}
							lv_function_35_0=ruleFunctionPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"function",
									lv_function_35_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getVariableVariablePublicParserRuleCall_7_1_1_6_0());
							}
							lv_variable_36_0=ruleVariablePublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"variable",
									lv_variable_36_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_37='@protected:'
				{
					newLeafNode(otherlv_37, grammarAccess.getMachineBlockAccess().getProtectedKeyword_7_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortProtectedParserRuleCall_7_2_1_0_0());
							}
							lv_port_38_0=rulePortProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"port",
									lv_port_38_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getSignalSignalProtectedParserRuleCall_7_2_1_1_0());
							}
							lv_signal_39_0=ruleSignalProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"signal",
									lv_signal_39_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getBufferBufferProtectedParserRuleCall_7_2_1_2_0());
							}
							lv_buffer_40_0=ruleBufferProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_40_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getChannelChannelProtectedParserRuleCall_7_2_1_3_0());
							}
							lv_channel_41_0=ruleChannelProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"channel",
									lv_channel_41_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getTypedefTypeDefinitionParserRuleCall_7_2_1_4_0());
							}
							lv_typedef_42_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_42_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getFunctionFunctionProtectedParserRuleCall_7_2_1_5_0());
							}
							lv_function_43_0=ruleFunctionProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"function",
									lv_function_43_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getVariableVariableProtectedParserRuleCall_7_2_1_6_0());
							}
							lv_variable_44_0=ruleVariableProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"variable",
									lv_variable_44_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariableProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_45='@private:'
				{
					newLeafNode(otherlv_45, grammarAccess.getMachineBlockAccess().getPrivateKeyword_7_3_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortPrivateParserRuleCall_7_3_1_0_0());
							}
							lv_port_46_0=rulePortPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"port",
									lv_port_46_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getSignalSignalPrivateParserRuleCall_7_3_1_1_0());
							}
							lv_signal_47_0=ruleSignalPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"signal",
									lv_signal_47_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getBufferBufferPrivateParserRuleCall_7_3_1_2_0());
							}
							lv_buffer_48_0=ruleBufferPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_48_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getChannelChannelPrivateParserRuleCall_7_3_1_3_0());
							}
							lv_channel_49_0=ruleChannelPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"channel",
									lv_channel_49_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getTypedefTypeDefinitionParserRuleCall_7_3_1_4_0());
							}
							lv_typedef_50_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_50_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getFunctionFunctionPrivateParserRuleCall_7_3_1_5_0());
							}
							lv_function_51_0=ruleFunctionPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"function",
									lv_function_51_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getVariableVariablePrivateParserRuleCall_7_3_1_6_0());
							}
							lv_variable_52_0=ruleVariablePrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"variable",
									lv_variable_52_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)*
		(
			(
				(
					(
						otherlv_53='@routine:'
						{
							newLeafNode(otherlv_53, grammarAccess.getMachineBlockAccess().getRoutineKeyword_8_0_0_0_0());
						}
						    |
						otherlv_54='@macro:'
						{
							newLeafNode(otherlv_54, grammarAccess.getMachineBlockAccess().getMacroKeyword_8_0_0_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getRoutineRoutineParserRuleCall_8_0_0_1_0());
							}
							lv_routine_55_0=ruleRoutine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"routine",
									lv_routine_55_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Routine");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
				    |
				(
					otherlv_56='@procedure:'
					{
						newLeafNode(otherlv_56, grammarAccess.getMachineBlockAccess().getProcedureKeyword_8_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getProcedureProcedureParserRuleCall_8_0_1_1_0());
							}
							lv_procedure_57_0=ruleProcedure
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"procedure",
									lv_procedure_57_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Procedure");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
			)*
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getRoutineRoutineParserRuleCall_8_1_0_0());
						}
						lv_routine_58_0=ruleRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"routine",
								lv_routine_58_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Routine");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getProcedureProcedureParserRuleCall_8_1_1_0());
						}
						lv_procedure_59_0=ruleProcedure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"procedure",
								lv_procedure_59_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Procedure");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)+
		)
		(
			(
				(
					otherlv_60='@composite:'
					{
						newLeafNode(otherlv_60, grammarAccess.getMachineBlockAccess().getCompositeKeyword_9_0_0_0());
					}
					    |
					otherlv_61='@machine:'
					{
						newLeafNode(otherlv_61, grammarAccess.getMachineBlockAccess().getMachineKeyword_9_0_0_1());
					}
				)
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getMachineAnyMachineBlockParserRuleCall_9_0_1_0_0());
							}
							lv_machine_62_0=ruleAnyMachineBlock
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"machine",
									lv_machine_62_0,
									"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getInstanceInstanceMachineParserRuleCall_9_0_1_1_0());
							}
							lv_instance_63_0=ruleInstanceMachine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"instance",
									lv_instance_63_0,
									"org.eclipse.efm.formalml.xtext.FormalML.InstanceMachine");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)+
			)
			    |
			(
				otherlv_64='@model:'
				{
					newLeafNode(otherlv_64, grammarAccess.getMachineBlockAccess().getModelKeyword_9_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getMachineAnyMachineBlockParserRuleCall_9_1_1_0());
						}
						lv_machine_65_0=ruleAnyMachineBlock
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"machine",
								lv_machine_65_0,
								"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_66='@prototype:'
				{
					newLeafNode(otherlv_66, grammarAccess.getMachineBlockAccess().getPrototypeKeyword_9_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getMachineAnyMachineBlockParserRuleCall_9_2_1_0());
						}
						lv_machine_67_0=ruleAnyMachineBlock
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"machine",
								lv_machine_67_0,
								"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_68='@instance:'
				{
					newLeafNode(otherlv_68, grammarAccess.getMachineBlockAccess().getInstanceKeyword_9_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getInstanceInstanceMachineParserRuleCall_9_3_1_0());
						}
						lv_instance_69_0=ruleInstanceMachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"instance",
								lv_instance_69_0,
								"org.eclipse.efm.formalml.xtext.FormalML.InstanceMachine");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)*
		(
			(
				otherlv_70='@behavior:'
				{
					newLeafNode(otherlv_70, grammarAccess.getMachineBlockAccess().getBehaviorKeyword_10_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getBehaviorBehaviorParserRuleCall_10_0_1_0());
						}
						lv_behavior_71_0=ruleBehavior
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"behavior",
								lv_behavior_71_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Behavior");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)
			    |
			(
				otherlv_72='@statemachine:'
				{
					newLeafNode(otherlv_72, grammarAccess.getMachineBlockAccess().getStatemachineKeyword_10_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getBehaviorStatemachineParserRuleCall_10_1_1_0());
						}
						lv_behavior_73_0=ruleStatemachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"behavior",
								lv_behavior_73_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Statemachine");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getMachineBlockAccess().getMainMoeBehaviorParserRuleCall_11_0());
				}
				lv_main_74_0=ruleMoeBehavior
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
					}
					set(
						$current,
						"main",
						lv_main_74_0,
						"org.eclipse.efm.formalml.xtext.FormalML.MoeBehavior");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_75='}'
		{
			newLeafNode(otherlv_75, grammarAccess.getMachineBlockAccess().getRightCurlyBracketKeyword_12());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleProcedure
entryRuleProcedure returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getProcedureRule()); }
	iv_ruleProcedure=ruleProcedure
	{ $current=$iv_ruleProcedure.current; }
	EOF;

// Rule Procedure
ruleProcedure returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getProcedureAccess().getVisibilityVisibilityKindEnumRuleCall_0_0());
				}
				lv_visibility_0_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getProcedureRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1='procedure'
		{
			newLeafNode(otherlv_1, grammarAccess.getProcedureAccess().getProcedureKeyword_1());
		}
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getProcedureAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_3='moc:'
				{
					newLeafNode(otherlv_3, grammarAccess.getProcedureAccess().getMocKeyword_2_1());
				}
			)?
			(
				otherlv_4='and'
				{
					newLeafNode(otherlv_4, grammarAccess.getProcedureAccess().getAndKeyword_2_2_0());
				}
				    |
				otherlv_5='or'
				{
					newLeafNode(otherlv_5, grammarAccess.getProcedureAccess().getOrKeyword_2_2_1());
				}
			)
			otherlv_6='>'
			{
				newLeafNode(otherlv_6, grammarAccess.getProcedureAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getProcedureAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_7_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getProcedureRule());
					}
					set(
						$current,
						"name",
						lv_name_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getProcedureAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_8_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getProcedureRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_9='('
				{
					newLeafNode(otherlv_9, grammarAccess.getProcedureAccess().getLeftParenthesisKeyword_5_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getParameterFunctionalParameterParserRuleCall_5_0_1_0_0());
							}
							lv_parameter_10_0=ruleFunctionalParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"parameter",
									lv_parameter_10_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_11=','
						{
							newLeafNode(otherlv_11, grammarAccess.getProcedureAccess().getCommaKeyword_5_0_1_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getProcedureAccess().getParameterFunctionalParameterParserRuleCall_5_0_1_1_1_0());
								}
								lv_parameter_12_0=ruleFunctionalParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getProcedureRule());
									}
									add(
										$current,
										"parameter",
										lv_parameter_12_0,
										"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_13=')'
				{
					newLeafNode(otherlv_13, grammarAccess.getProcedureAccess().getRightParenthesisKeyword_5_0_2());
				}
			)?
			(
				otherlv_14='-->'
				{
					newLeafNode(otherlv_14, grammarAccess.getProcedureAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_5_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getParameterFormalParameterParserRuleCall_5_1_1_0_0());
							}
							lv_parameter_15_0=ruleFormalParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"parameter",
									lv_parameter_15_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						otherlv_16='('
						{
							newLeafNode(otherlv_16, grammarAccess.getProcedureAccess().getLeftParenthesisKeyword_5_1_1_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getProcedureAccess().getParameterFormalParameterParserRuleCall_5_1_1_1_1_0());
								}
								lv_parameter_17_0=ruleFormalParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getProcedureRule());
									}
									add(
										$current,
										"parameter",
										lv_parameter_17_0,
										"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							otherlv_18=','
							{
								newLeafNode(otherlv_18, grammarAccess.getProcedureAccess().getCommaKeyword_5_1_1_1_2_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getProcedureAccess().getParameterFormalParameterParserRuleCall_5_1_1_1_2_1_0());
									}
									lv_parameter_19_0=ruleFormalParameter
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getProcedureRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_19_0,
											"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)*
						otherlv_20=')'
						{
							newLeafNode(otherlv_20, grammarAccess.getProcedureAccess().getRightParenthesisKeyword_5_1_1_1_3());
						}
					)
				)
			)?
		)?
		otherlv_21='{'
		{
			newLeafNode(otherlv_21, grammarAccess.getProcedureAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				otherlv_22='@parameter:'
				{
					newLeafNode(otherlv_22, grammarAccess.getProcedureAccess().getParameterKeyword_7_0_0());
				}
				(
					(
						otherlv_23='input'
						{
							newLeafNode(otherlv_23, grammarAccess.getProcedureAccess().getInputKeyword_7_0_1_0_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterInputParserRuleCall_7_0_1_0_1_0_0());
									}
									lv_parameter_24_0=ruleParameterInput
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getProcedureRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_24_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ParameterInput");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								otherlv_25='{'
								{
									newLeafNode(otherlv_25, grammarAccess.getProcedureAccess().getLeftCurlyBracketKeyword_7_0_1_0_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterInputParserRuleCall_7_0_1_0_1_1_1_0());
										}
										lv_parameter_26_0=ruleParameterInput
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getProcedureRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_26_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterInput");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_27='}'
								{
									newLeafNode(otherlv_27, grammarAccess.getProcedureAccess().getRightCurlyBracketKeyword_7_0_1_0_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_28='inout'
						{
							newLeafNode(otherlv_28, grammarAccess.getProcedureAccess().getInoutKeyword_7_0_1_1_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterInoutParserRuleCall_7_0_1_1_1_0_0());
									}
									lv_parameter_29_0=ruleParameterInout
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getProcedureRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_29_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ParameterInout");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								otherlv_30='{'
								{
									newLeafNode(otherlv_30, grammarAccess.getProcedureAccess().getLeftCurlyBracketKeyword_7_0_1_1_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterInoutParserRuleCall_7_0_1_1_1_1_1_0());
										}
										lv_parameter_31_0=ruleParameterInout
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getProcedureRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_31_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterInout");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_32='}'
								{
									newLeafNode(otherlv_32, grammarAccess.getProcedureAccess().getRightCurlyBracketKeyword_7_0_1_1_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_33='output'
						{
							newLeafNode(otherlv_33, grammarAccess.getProcedureAccess().getOutputKeyword_7_0_1_2_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterOutputParserRuleCall_7_0_1_2_1_0_0());
									}
									lv_parameter_34_0=ruleParameterOutput
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getProcedureRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_34_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ParameterOutput");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								otherlv_35='{'
								{
									newLeafNode(otherlv_35, grammarAccess.getProcedureAccess().getLeftCurlyBracketKeyword_7_0_1_2_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterOutputParserRuleCall_7_0_1_2_1_1_1_0());
										}
										lv_parameter_36_0=ruleParameterOutput
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getProcedureRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_36_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterOutput");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_37='}'
								{
									newLeafNode(otherlv_37, grammarAccess.getProcedureAccess().getRightCurlyBracketKeyword_7_0_1_2_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_38='return'
						{
							newLeafNode(otherlv_38, grammarAccess.getProcedureAccess().getReturnKeyword_7_0_1_3_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterReturnParserRuleCall_7_0_1_3_1_0_0());
									}
									lv_parameter_39_0=ruleParameterReturn
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getProcedureRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_39_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ParameterReturn");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								otherlv_40='{'
								{
									newLeafNode(otherlv_40, grammarAccess.getProcedureAccess().getLeftCurlyBracketKeyword_7_0_1_3_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterReturnParserRuleCall_7_0_1_3_1_1_1_0());
										}
										lv_parameter_41_0=ruleParameterReturn
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getProcedureRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_41_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterReturn");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_42='}'
								{
									newLeafNode(otherlv_42, grammarAccess.getProcedureAccess().getRightCurlyBracketKeyword_7_0_1_3_1_1_2());
								}
							)
						)
					)
				)*
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getPortPortParserRuleCall_7_1_0_0());
						}
						lv_port_43_0=rulePort
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"port",
								lv_port_43_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Port");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getSignalSignalParserRuleCall_7_1_1_0());
						}
						lv_signal_44_0=ruleSignal
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"signal",
								lv_signal_44_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Signal");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getBufferBufferParserRuleCall_7_1_2_0());
						}
						lv_buffer_45_0=ruleBuffer
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"buffer",
								lv_buffer_45_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Buffer");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getChannelChannelParserRuleCall_7_1_3_0());
						}
						lv_channel_46_0=ruleChannel
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"channel",
								lv_channel_46_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Channel");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getTypedefTypeDefinitionParserRuleCall_7_1_4_0());
						}
						lv_typedef_47_0=ruleTypeDefinition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"typedef",
								lv_typedef_47_0,
								"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getFunctionFunctionParserRuleCall_7_1_5_0());
						}
						lv_function_48_0=ruleFunction
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"function",
								lv_function_48_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Function");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getVariableVariableParserRuleCall_7_1_6_0());
						}
						lv_variable_49_0=ruleVariable
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"variable",
								lv_variable_49_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Variable");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			(
				otherlv_50='@input:'
				{
					newLeafNode(otherlv_50, grammarAccess.getProcedureAccess().getInputKeyword_8_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterInputParserRuleCall_8_0_1_0());
						}
						lv_parameter_51_0=ruleParameterInput
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_51_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterInput");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_52='@inout:'
				{
					newLeafNode(otherlv_52, grammarAccess.getProcedureAccess().getInoutKeyword_8_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterInoutParserRuleCall_8_1_1_0());
						}
						lv_parameter_53_0=ruleParameterInout
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_53_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterInout");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_54='@output:'
				{
					newLeafNode(otherlv_54, grammarAccess.getProcedureAccess().getOutputKeyword_8_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterOutputParserRuleCall_8_2_1_0());
						}
						lv_parameter_55_0=ruleParameterOutput
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_55_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterOutput");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_56='@return:'
				{
					newLeafNode(otherlv_56, grammarAccess.getProcedureAccess().getReturnKeyword_8_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getParameterParameterReturnParserRuleCall_8_3_1_0());
						}
						lv_parameter_57_0=ruleParameterReturn
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_57_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterReturn");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)*
		(
			(
				otherlv_58='@property:'
				{
					newLeafNode(otherlv_58, grammarAccess.getProcedureAccess().getPropertyKeyword_9_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getPortPortParserRuleCall_9_0_1_0_0());
							}
							lv_port_59_0=rulePort
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"port",
									lv_port_59_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Port");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getSignalSignalParserRuleCall_9_0_1_1_0());
							}
							lv_signal_60_0=ruleSignal
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"signal",
									lv_signal_60_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Signal");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getBufferBufferParserRuleCall_9_0_1_2_0());
							}
							lv_buffer_61_0=ruleBuffer
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_61_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Buffer");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getChannelChannelParserRuleCall_9_0_1_3_0());
							}
							lv_channel_62_0=ruleChannel
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"channel",
									lv_channel_62_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Channel");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getTypedefTypeDefinitionParserRuleCall_9_0_1_4_0());
							}
							lv_typedef_63_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_63_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getFunctionFunctionParserRuleCall_9_0_1_5_0());
							}
							lv_function_64_0=ruleFunction
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"function",
									lv_function_64_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Function");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getVariableVariableParserRuleCall_9_0_1_6_0());
							}
							lv_variable_65_0=ruleVariable
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"variable",
									lv_variable_65_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Variable");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_66='@public:'
				{
					newLeafNode(otherlv_66, grammarAccess.getProcedureAccess().getPublicKeyword_9_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getPortPortPublicParserRuleCall_9_1_1_0_0());
							}
							lv_port_67_0=rulePortPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"port",
									lv_port_67_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getSignalSignalPublicParserRuleCall_9_1_1_1_0());
							}
							lv_signal_68_0=ruleSignalPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"signal",
									lv_signal_68_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getBufferBufferPublicParserRuleCall_9_1_1_2_0());
							}
							lv_buffer_69_0=ruleBufferPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_69_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getChannelChannelPublicParserRuleCall_9_1_1_3_0());
							}
							lv_channel_70_0=ruleChannelPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"channel",
									lv_channel_70_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getTypedefTypeDefinitionParserRuleCall_9_1_1_4_0());
							}
							lv_typedef_71_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_71_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getFunctionFunctionPublicParserRuleCall_9_1_1_5_0());
							}
							lv_function_72_0=ruleFunctionPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"function",
									lv_function_72_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getVariableVariablePublicParserRuleCall_9_1_1_6_0());
							}
							lv_variable_73_0=ruleVariablePublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"variable",
									lv_variable_73_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_74='@protected:'
				{
					newLeafNode(otherlv_74, grammarAccess.getProcedureAccess().getProtectedKeyword_9_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getPortPortProtectedParserRuleCall_9_2_1_0_0());
							}
							lv_port_75_0=rulePortProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"port",
									lv_port_75_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getSignalSignalProtectedParserRuleCall_9_2_1_1_0());
							}
							lv_signal_76_0=ruleSignalProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"signal",
									lv_signal_76_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getBufferBufferProtectedParserRuleCall_9_2_1_2_0());
							}
							lv_buffer_77_0=ruleBufferProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_77_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getChannelChannelProtectedParserRuleCall_9_2_1_3_0());
							}
							lv_channel_78_0=ruleChannelProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"channel",
									lv_channel_78_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getTypedefTypeDefinitionParserRuleCall_9_2_1_4_0());
							}
							lv_typedef_79_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_79_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getFunctionFunctionProtectedParserRuleCall_9_2_1_5_0());
							}
							lv_function_80_0=ruleFunctionProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"function",
									lv_function_80_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getVariableVariableProtectedParserRuleCall_9_2_1_6_0());
							}
							lv_variable_81_0=ruleVariableProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"variable",
									lv_variable_81_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariableProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_82='@private:'
				{
					newLeafNode(otherlv_82, grammarAccess.getProcedureAccess().getPrivateKeyword_9_3_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getPortPortPrivateParserRuleCall_9_3_1_0_0());
							}
							lv_port_83_0=rulePortPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"port",
									lv_port_83_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getSignalSignalPrivateParserRuleCall_9_3_1_1_0());
							}
							lv_signal_84_0=ruleSignalPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"signal",
									lv_signal_84_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getBufferBufferPrivateParserRuleCall_9_3_1_2_0());
							}
							lv_buffer_85_0=ruleBufferPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_85_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getChannelChannelPrivateParserRuleCall_9_3_1_3_0());
							}
							lv_channel_86_0=ruleChannelPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"channel",
									lv_channel_86_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getTypedefTypeDefinitionParserRuleCall_9_3_1_4_0());
							}
							lv_typedef_87_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_87_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getFunctionFunctionPrivateParserRuleCall_9_3_1_5_0());
							}
							lv_function_88_0=ruleFunctionPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"function",
									lv_function_88_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getVariableVariablePrivateParserRuleCall_9_3_1_6_0());
							}
							lv_variable_89_0=ruleVariablePrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"variable",
									lv_variable_89_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)*
		(
			(
				(
					(
						otherlv_90='@routine:'
						{
							newLeafNode(otherlv_90, grammarAccess.getProcedureAccess().getRoutineKeyword_10_0_0_0_0());
						}
						    |
						otherlv_91='@macro:'
						{
							newLeafNode(otherlv_91, grammarAccess.getProcedureAccess().getMacroKeyword_10_0_0_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getRoutineRoutineParserRuleCall_10_0_0_1_0());
							}
							lv_routine_92_0=ruleRoutine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"routine",
									lv_routine_92_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Routine");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
				    |
				(
					otherlv_93='@procedure:'
					{
						newLeafNode(otherlv_93, grammarAccess.getProcedureAccess().getProcedureKeyword_10_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getProcedureAccess().getProcedureProcedureParserRuleCall_10_0_1_1_0());
							}
							lv_procedure_94_0=ruleProcedure
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getProcedureRule());
								}
								add(
									$current,
									"procedure",
									lv_procedure_94_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Procedure");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
			)*
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getRoutineRoutineParserRuleCall_10_1_0_0());
						}
						lv_routine_95_0=ruleRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"routine",
								lv_routine_95_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Routine");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getProcedureAccess().getProcedureProcedureParserRuleCall_10_1_1_0());
						}
						lv_procedure_96_0=ruleProcedure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getProcedureRule());
							}
							add(
								$current,
								"procedure",
								lv_procedure_96_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Procedure");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)+
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getProcedureAccess().getRegionStatemachineRegionParserRuleCall_11_0_0());
					}
					lv_region_97_0=ruleStatemachineRegion
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProcedureRule());
						}
						add(
							$current,
							"region",
							lv_region_97_0,
							"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegion");
						afterParserOrEnumRuleCall();
					}
				)
			)+
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getProcedureAccess().getRegionStatemachineRegionLiteParserRuleCall_11_1_0());
					}
					lv_region_98_0=ruleStatemachineRegionLite
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProcedureRule());
						}
						add(
							$current,
							"region",
							lv_region_98_0,
							"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegionLite");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getProcedureAccess().getExecutionProcedureExecutionParserRuleCall_12_0());
				}
				lv_execution_99_0=ruleProcedureExecution
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getProcedureRule());
					}
					set(
						$current,
						"execution",
						lv_execution_99_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ProcedureExecution");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_100='}'
		{
			newLeafNode(otherlv_100, grammarAccess.getProcedureAccess().getRightCurlyBracketKeyword_13());
		}
	)
;

// Entry rule entryRuleProcedureExecution
entryRuleProcedureExecution returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2()
	);
}:
	{ newCompositeNode(grammarAccess.getProcedureExecutionRule()); }
	iv_ruleProcedureExecution=ruleProcedureExecution
	{ $current=$iv_ruleProcedureExecution.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule ProcedureExecution
ruleProcedureExecution returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getProcedureExecutionAccess().getModelOfExecutionAction_0(),
					$current);
			}
		)
		(
			otherlv_1='@moe:'
			{
				newLeafNode(otherlv_1, grammarAccess.getProcedureExecutionAccess().getMoeKeyword_1());
			}
		)?
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2(), 0);
					}
								({true}?=>(otherlv_3='@schedule'
								{
									newLeafNode(otherlv_3, grammarAccess.getProcedureExecutionAccess().getScheduleKeyword_2_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getProcedureExecutionAccess().getScheduleRoutineMoeRoutineParserRuleCall_2_0_1_0());
										}
										lv_scheduleRoutine_4_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getProcedureExecutionRule());
											}
											set(
												$current,
												"scheduleRoutine",
												lv_scheduleRoutine_4_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2(), 1);
					}
								({true}?=>(otherlv_5='@run'
								{
									newLeafNode(otherlv_5, grammarAccess.getProcedureExecutionAccess().getRunKeyword_2_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getProcedureExecutionAccess().getRunRoutineMoeRoutineParserRuleCall_2_1_1_0());
										}
										lv_runRoutine_6_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getProcedureExecutionRule());
											}
											set(
												$current,
												"runRoutine",
												lv_runRoutine_6_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getProcedureExecutionAccess().getUnorderedGroup_2());
				}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleBehavior
entryRuleBehavior returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBehaviorRule()); }
	iv_ruleBehavior=ruleBehavior
	{ $current=$iv_ruleBehavior.current; }
	EOF;

// Rule Behavior
ruleBehavior returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getBehaviorAccess().getStatemachineParserRuleCall());
	}
	this_Statemachine_0=ruleStatemachine
	{
		$current = $this_Statemachine_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleMoeBehavior
entryRuleMoeBehavior returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2()
	);
}:
	{ newCompositeNode(grammarAccess.getMoeBehaviorRule()); }
	iv_ruleMoeBehavior=ruleMoeBehavior
	{ $current=$iv_ruleMoeBehavior.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule MoeBehavior
ruleMoeBehavior returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMoeBehaviorAccess().getBehaviorAction_0(),
					$current);
			}
		)
		(
			otherlv_1='@local:'
			{
				newLeafNode(otherlv_1, grammarAccess.getMoeBehaviorAccess().getLocalKeyword_1_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getMoeBehaviorAccess().getPortPortPrivateParserRuleCall_1_1_0_0());
						}
						lv_port_2_0=rulePortPrivate
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
							}
							add(
								$current,
								"port",
								lv_port_2_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PortPrivate");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getMoeBehaviorAccess().getSignalSignalPrivateParserRuleCall_1_1_1_0());
						}
						lv_signal_3_0=ruleSignalPrivate
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
							}
							add(
								$current,
								"signal",
								lv_signal_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.SignalPrivate");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getMoeBehaviorAccess().getBufferBufferPrivateParserRuleCall_1_1_2_0());
						}
						lv_buffer_4_0=ruleBufferPrivate
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
							}
							add(
								$current,
								"buffer",
								lv_buffer_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.BufferPrivate");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getMoeBehaviorAccess().getChannelChannelPrivateParserRuleCall_1_1_3_0());
						}
						lv_channel_5_0=ruleChannelPrivate
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
							}
							add(
								$current,
								"channel",
								lv_channel_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelPrivate");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getMoeBehaviorAccess().getTypedefTypeDefinitionParserRuleCall_1_1_4_0());
						}
						lv_typedef_6_0=ruleTypeDefinition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
							}
							add(
								$current,
								"typedef",
								lv_typedef_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getMoeBehaviorAccess().getFunctionFunctionPrivateParserRuleCall_1_1_5_0());
						}
						lv_function_7_0=ruleFunctionPrivate
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
							}
							add(
								$current,
								"function",
								lv_function_7_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FunctionPrivate");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getMoeBehaviorAccess().getVariableVariablePrivateParserRuleCall_1_1_6_0());
						}
						lv_variable_8_0=ruleVariablePrivate
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
							}
							add(
								$current,
								"variable",
								lv_variable_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.VariablePrivate");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getMoeBehaviorAccess().getExecutionModelOfExecutionParserRuleCall_2_0_0());
									}
									lv_execution_10_0=ruleModelOfExecution
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
										}
										set(
											$current,
											"execution",
											lv_execution_10_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ModelOfExecution");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2(), 1);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getMoeBehaviorAccess().getInteractionModelOfInteractionParserRuleCall_2_1_0());
									}
									lv_interaction_11_0=ruleModelOfInteraction
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMoeBehaviorRule());
										}
										set(
											$current,
											"interaction",
											lv_interaction_11_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ModelOfInteraction");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getMoeBehaviorAccess().getUnorderedGroup_2());
				}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleStatemachine
entryRuleStatemachine returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 
	grammarAccess.getStatemachineAccess().getUnorderedGroup_12()
	);
}:
	{ newCompositeNode(grammarAccess.getStatemachineRule()); }
	iv_ruleStatemachine=ruleStatemachine
	{ $current=$iv_ruleStatemachine.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule Statemachine
ruleStatemachine returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 
	grammarAccess.getStatemachineAccess().getUnorderedGroup_12()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getStatemachineAccess().getStatemachineAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getStatemachineAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getVisibilityVisibilityKindEnumRuleCall_1_0_0());
									}
									lv_visibility_2_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										set(
											$current,
											"visibility",
											lv_visibility_2_0,
											"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStatemachineAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>((
									lv_timed_3_0='timed'
									{
										newLeafNode(lv_timed_3_0, grammarAccess.getStatemachineAccess().getTimedTimedKeyword_1_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getStatemachineRule());
										}
										setWithLastConsumed($current, "timed", true, "timed");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStatemachineAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 2);
					}
								({true}?=>((
									lv_input_enabled_4_0='input_enabled'
									{
										newLeafNode(lv_input_enabled_4_0, grammarAccess.getStatemachineAccess().getInput_enabledInput_enabledKeyword_1_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getStatemachineRule());
										}
										setWithLastConsumed($current, "input_enabled", true, "input_enabled");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStatemachineAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 3);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getDesignDesignKindEnumRuleCall_1_3_0());
									}
									lv_design_5_0=ruleDesignKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										set(
											$current,
											"design",
											lv_design_5_0,
											"org.eclipse.efm.formalml.xtext.FormalML.DesignKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStatemachineAccess().getUnorderedGroup_1());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getStatemachineAccess().getUnorderedGroup_1());
				}
		)
		otherlv_6='statemachine'
		{
			newLeafNode(otherlv_6, grammarAccess.getStatemachineAccess().getStatemachineKeyword_2());
		}
		(
			otherlv_7='<'
			{
				newLeafNode(otherlv_7, grammarAccess.getStatemachineAccess().getLessThanSignKeyword_3_0());
			}
			(
				otherlv_8='moc:'
				{
					newLeafNode(otherlv_8, grammarAccess.getStatemachineAccess().getMocKeyword_3_1());
				}
			)?
			(
				otherlv_9='or'
				{
					newLeafNode(otherlv_9, grammarAccess.getStatemachineAccess().getOrKeyword_3_2_0());
				}
				    |
				otherlv_10='and'
				{
					newLeafNode(otherlv_10, grammarAccess.getStatemachineAccess().getAndKeyword_3_2_1());
				}
			)
			otherlv_11='>'
			{
				newLeafNode(otherlv_11, grammarAccess.getStatemachineAccess().getGreaterThanSignKeyword_3_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getStatemachineAccess().getNameESIdentifierParserRuleCall_4_0());
				}
				lv_name_12_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineRule());
					}
					set(
						$current,
						"name",
						lv_name_12_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStatemachineAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_unrestrictedName_13_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_13_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_14='{'
		{
			newLeafNode(otherlv_14, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				otherlv_15='@parameter:'
				{
					newLeafNode(otherlv_15, grammarAccess.getStatemachineAccess().getParameterKeyword_7_0_0());
				}
				(
					(
						otherlv_16='input'
						{
							newLeafNode(otherlv_16, grammarAccess.getStatemachineAccess().getInputKeyword_7_0_1_0_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInputParserRuleCall_7_0_1_0_1_0_0());
									}
									lv_parameter_17_0=ruleParameterInput
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_17_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ParameterInput");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								otherlv_18='{'
								{
									newLeafNode(otherlv_18, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_7_0_1_0_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInputParserRuleCall_7_0_1_0_1_1_1_0());
										}
										lv_parameter_19_0=ruleParameterInput
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStatemachineRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_19_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterInput");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_20='}'
								{
									newLeafNode(otherlv_20, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_7_0_1_0_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_21='inout'
						{
							newLeafNode(otherlv_21, grammarAccess.getStatemachineAccess().getInoutKeyword_7_0_1_1_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInoutParserRuleCall_7_0_1_1_1_0_0());
									}
									lv_parameter_22_0=ruleParameterInout
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_22_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ParameterInout");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								otherlv_23='{'
								{
									newLeafNode(otherlv_23, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_7_0_1_1_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInoutParserRuleCall_7_0_1_1_1_1_1_0());
										}
										lv_parameter_24_0=ruleParameterInout
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStatemachineRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_24_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterInout");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_25='}'
								{
									newLeafNode(otherlv_25, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_7_0_1_1_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_26='output'
						{
							newLeafNode(otherlv_26, grammarAccess.getStatemachineAccess().getOutputKeyword_7_0_1_2_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterOutputParserRuleCall_7_0_1_2_1_0_0());
									}
									lv_parameter_27_0=ruleParameterOutput
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_27_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ParameterOutput");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								otherlv_28='{'
								{
									newLeafNode(otherlv_28, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_7_0_1_2_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterOutputParserRuleCall_7_0_1_2_1_1_1_0());
										}
										lv_parameter_29_0=ruleParameterOutput
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStatemachineRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_29_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterOutput");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_30='}'
								{
									newLeafNode(otherlv_30, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_7_0_1_2_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_31='return'
						{
							newLeafNode(otherlv_31, grammarAccess.getStatemachineAccess().getReturnKeyword_7_0_1_3_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterReturnParserRuleCall_7_0_1_3_1_0_0());
									}
									lv_parameter_32_0=ruleParameterReturn
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										add(
											$current,
											"parameter",
											lv_parameter_32_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ParameterReturn");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								otherlv_33='{'
								{
									newLeafNode(otherlv_33, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_7_0_1_3_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterReturnParserRuleCall_7_0_1_3_1_1_1_0());
										}
										lv_parameter_34_0=ruleParameterReturn
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStatemachineRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_34_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterReturn");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_35='}'
								{
									newLeafNode(otherlv_35, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_7_0_1_3_1_1_2());
								}
							)
						)
					)
				)*
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortParserRuleCall_7_1_0_0());
						}
						lv_port_36_0=rulePort
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"port",
								lv_port_36_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Port");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getSignalSignalParserRuleCall_7_1_1_0());
						}
						lv_signal_37_0=ruleSignal
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"signal",
								lv_signal_37_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Signal");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getBufferBufferParserRuleCall_7_1_2_0());
						}
						lv_buffer_38_0=ruleBuffer
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"buffer",
								lv_buffer_38_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Buffer");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getChannelChannelParserRuleCall_7_1_3_0());
						}
						lv_channel_39_0=ruleChannel
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"channel",
								lv_channel_39_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Channel");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getTypedefTypeDefinitionParserRuleCall_7_1_4_0());
						}
						lv_typedef_40_0=ruleTypeDefinition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"typedef",
								lv_typedef_40_0,
								"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getFunctionFunctionParserRuleCall_7_1_5_0());
						}
						lv_function_41_0=ruleFunction
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"function",
								lv_function_41_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Function");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getVariableVariableParserRuleCall_7_1_6_0());
						}
						lv_variable_42_0=ruleVariable
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"variable",
								lv_variable_42_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Variable");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			(
				otherlv_43='@input:'
				{
					newLeafNode(otherlv_43, grammarAccess.getStatemachineAccess().getInputKeyword_8_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInputParserRuleCall_8_0_1_0());
						}
						lv_parameter_44_0=ruleParameterInput
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_44_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterInput");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_45='@inout:'
				{
					newLeafNode(otherlv_45, grammarAccess.getStatemachineAccess().getInoutKeyword_8_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInoutParserRuleCall_8_1_1_0());
						}
						lv_parameter_46_0=ruleParameterInout
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_46_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterInout");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_47='@output:'
				{
					newLeafNode(otherlv_47, grammarAccess.getStatemachineAccess().getOutputKeyword_8_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterOutputParserRuleCall_8_2_1_0());
						}
						lv_parameter_48_0=ruleParameterOutput
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_48_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterOutput");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_49='@return:'
				{
					newLeafNode(otherlv_49, grammarAccess.getStatemachineAccess().getReturnKeyword_8_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterReturnParserRuleCall_8_3_1_0());
						}
						lv_parameter_50_0=ruleParameterReturn
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_50_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterReturn");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)*
		(
			(
				otherlv_51='@property:'
				{
					newLeafNode(otherlv_51, grammarAccess.getStatemachineAccess().getPropertyKeyword_9_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortParserRuleCall_9_0_1_0_0());
							}
							lv_port_52_0=rulePort
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"port",
									lv_port_52_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Port");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getSignalSignalParserRuleCall_9_0_1_1_0());
							}
							lv_signal_53_0=ruleSignal
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"signal",
									lv_signal_53_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Signal");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getBufferBufferParserRuleCall_9_0_1_2_0());
							}
							lv_buffer_54_0=ruleBuffer
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_54_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Buffer");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getChannelChannelParserRuleCall_9_0_1_3_0());
							}
							lv_channel_55_0=ruleChannel
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"channel",
									lv_channel_55_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Channel");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getTypedefTypeDefinitionParserRuleCall_9_0_1_4_0());
							}
							lv_typedef_56_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_56_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getFunctionFunctionParserRuleCall_9_0_1_5_0());
							}
							lv_function_57_0=ruleFunction
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"function",
									lv_function_57_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Function");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getVariableVariableParserRuleCall_9_0_1_6_0());
							}
							lv_variable_58_0=ruleVariable
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"variable",
									lv_variable_58_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Variable");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_59='@public:'
				{
					newLeafNode(otherlv_59, grammarAccess.getStatemachineAccess().getPublicKeyword_9_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortPublicParserRuleCall_9_1_1_0_0());
							}
							lv_port_60_0=rulePortPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"port",
									lv_port_60_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getSignalSignalPublicParserRuleCall_9_1_1_1_0());
							}
							lv_signal_61_0=ruleSignalPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"signal",
									lv_signal_61_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getBufferBufferPublicParserRuleCall_9_1_1_2_0());
							}
							lv_buffer_62_0=ruleBufferPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_62_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getChannelChannelPublicParserRuleCall_9_1_1_3_0());
							}
							lv_channel_63_0=ruleChannelPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"channel",
									lv_channel_63_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getTypedefTypeDefinitionParserRuleCall_9_1_1_4_0());
							}
							lv_typedef_64_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_64_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getFunctionFunctionPublicParserRuleCall_9_1_1_5_0());
							}
							lv_function_65_0=ruleFunctionPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"function",
									lv_function_65_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionPublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getVariableVariablePublicParserRuleCall_9_1_1_6_0());
							}
							lv_variable_66_0=ruleVariablePublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"variable",
									lv_variable_66_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_67='@protected:'
				{
					newLeafNode(otherlv_67, grammarAccess.getStatemachineAccess().getProtectedKeyword_9_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortProtectedParserRuleCall_9_2_1_0_0());
							}
							lv_port_68_0=rulePortProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"port",
									lv_port_68_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getSignalSignalProtectedParserRuleCall_9_2_1_1_0());
							}
							lv_signal_69_0=ruleSignalProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"signal",
									lv_signal_69_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getBufferBufferProtectedParserRuleCall_9_2_1_2_0());
							}
							lv_buffer_70_0=ruleBufferProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_70_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getChannelChannelProtectedParserRuleCall_9_2_1_3_0());
							}
							lv_channel_71_0=ruleChannelProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"channel",
									lv_channel_71_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getTypedefTypeDefinitionParserRuleCall_9_2_1_4_0());
							}
							lv_typedef_72_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_72_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getFunctionFunctionProtectedParserRuleCall_9_2_1_5_0());
							}
							lv_function_73_0=ruleFunctionProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"function",
									lv_function_73_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getVariableVariableProtectedParserRuleCall_9_2_1_6_0());
							}
							lv_variable_74_0=ruleVariableProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"variable",
									lv_variable_74_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariableProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_75='@private:'
				{
					newLeafNode(otherlv_75, grammarAccess.getStatemachineAccess().getPrivateKeyword_9_3_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortPrivateParserRuleCall_9_3_1_0_0());
							}
							lv_port_76_0=rulePortPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"port",
									lv_port_76_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PortPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getSignalSignalPrivateParserRuleCall_9_3_1_1_0());
							}
							lv_signal_77_0=ruleSignalPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"signal",
									lv_signal_77_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SignalPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getBufferBufferPrivateParserRuleCall_9_3_1_2_0());
							}
							lv_buffer_78_0=ruleBufferPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_78_0,
									"org.eclipse.efm.formalml.xtext.FormalML.BufferPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getChannelChannelPrivateParserRuleCall_9_3_1_3_0());
							}
							lv_channel_79_0=ruleChannelPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"channel",
									lv_channel_79_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ChannelPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getTypedefTypeDefinitionParserRuleCall_9_3_1_4_0());
							}
							lv_typedef_80_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_80_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getFunctionFunctionPrivateParserRuleCall_9_3_1_5_0());
							}
							lv_function_81_0=ruleFunctionPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"function",
									lv_function_81_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionPrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getVariableVariablePrivateParserRuleCall_9_3_1_6_0());
							}
							lv_variable_82_0=ruleVariablePrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"variable",
									lv_variable_82_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePrivate");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)*
		(
			(
				(
					(
						otherlv_83='@routine:'
						{
							newLeafNode(otherlv_83, grammarAccess.getStatemachineAccess().getRoutineKeyword_10_0_0_0_0());
						}
						    |
						otherlv_84='@macro:'
						{
							newLeafNode(otherlv_84, grammarAccess.getStatemachineAccess().getMacroKeyword_10_0_0_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getRoutineRoutineParserRuleCall_10_0_0_1_0());
							}
							lv_routine_85_0=ruleRoutine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"routine",
									lv_routine_85_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Routine");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
				    |
				(
					otherlv_86='@procedure:'
					{
						newLeafNode(otherlv_86, grammarAccess.getStatemachineAccess().getProcedureKeyword_10_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getProcedureProcedureParserRuleCall_10_0_1_1_0());
							}
							lv_procedure_87_0=ruleProcedure
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"procedure",
									lv_procedure_87_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Procedure");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
			)*
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getRoutineRoutineParserRuleCall_10_1_0_0());
						}
						lv_routine_88_0=ruleRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"routine",
								lv_routine_88_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Routine");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getProcedureProcedureParserRuleCall_10_1_1_0());
						}
						lv_procedure_89_0=ruleProcedure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"procedure",
								lv_procedure_89_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Procedure");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)+
		)
		(
			(
				(
					otherlv_90='@composite:'
					{
						newLeafNode(otherlv_90, grammarAccess.getStatemachineAccess().getCompositeKeyword_11_0_0_0());
					}
					    |
					otherlv_91='@statemachine:'
					{
						newLeafNode(otherlv_91, grammarAccess.getStatemachineAccess().getStatemachineKeyword_11_0_0_1());
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getMachineStatemachineParserRuleCall_11_0_1_0());
						}
						lv_machine_92_0=ruleStatemachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"machine",
								lv_machine_92_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Statemachine");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineAccess().getRegionStatemachineRegionParserRuleCall_11_1_0());
					}
					lv_region_93_0=ruleStatemachineRegion
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRule());
						}
						add(
							$current,
							"region",
							lv_region_93_0,
							"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegion");
						afterParserOrEnumRuleCall();
					}
				)
			)+
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineAccess().getRegionStatemachineRegionLiteParserRuleCall_11_2_0());
					}
					lv_region_94_0=ruleStatemachineRegionLite
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRule());
						}
						add(
							$current,
							"region",
							lv_region_94_0,
							"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegionLite");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getStatemachineAccess().getUnorderedGroup_12());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_12(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_12(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getExecutionModelOfExecutionParserRuleCall_12_0_0());
									}
									lv_execution_96_0=ruleModelOfExecution
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										set(
											$current,
											"execution",
											lv_execution_96_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ModelOfExecution");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStatemachineAccess().getUnorderedGroup_12());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_12(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_12(), 1);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getInteractionModelOfInteractionParserRuleCall_12_1_0());
									}
									lv_interaction_97_0=ruleModelOfInteraction
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										set(
											$current,
											"interaction",
											lv_interaction_97_0,
											"org.eclipse.efm.formalml.xtext.FormalML.ModelOfInteraction");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStatemachineAccess().getUnorderedGroup_12());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getStatemachineAccess().getUnorderedGroup_12());
				}
		)
		otherlv_98='}'
		{
			newLeafNode(otherlv_98, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_13());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleStatemachineRegion
entryRuleStatemachineRegion returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStatemachineRegionRule()); }
	iv_ruleStatemachineRegion=ruleStatemachineRegion
	{ $current=$iv_ruleStatemachineRegion.current; }
	EOF;

// Rule StatemachineRegion
ruleStatemachineRegion returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getStatemachineRegionAccess().getRegionAction_0(),
					$current);
			}
		)
		(
			otherlv_1='@region:'
			{
				newLeafNode(otherlv_1, grammarAccess.getStatemachineRegionAccess().getRegionKeyword_1_0());
			}
			    |
			(
				otherlv_2='@region<'
				{
					newLeafNode(otherlv_2, grammarAccess.getStatemachineRegionAccess().getRegionKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineRegionAccess().getNameESIdentifierParserRuleCall_1_1_1_0());
						}
						lv_name_3_0=ruleESIdentifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRegionRule());
							}
							set(
								$current,
								"name",
								lv_name_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineRegionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_1_1_2_0());
						}
						lv_unrestrictedName_4_0=ruleUnrestrictedName
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRegionRule());
							}
							set(
								$current,
								"unrestrictedName",
								lv_unrestrictedName_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
							afterParserOrEnumRuleCall();
						}
					)
				)?
				otherlv_5='>:'
				{
					newLeafNode(otherlv_5, grammarAccess.getStatemachineRegionAccess().getGreaterThanSignColonKeyword_1_1_3());
				}
			)
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineRegionAccess().getVertexStateParserRuleCall_2_0_0());
					}
					lv_vertex_6_0=ruleState
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRegionRule());
						}
						add(
							$current,
							"vertex",
							lv_vertex_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.State");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineRegionAccess().getVertexPseudostateParserRuleCall_2_1_0());
					}
					lv_vertex_7_0=rulePseudostate
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRegionRule());
						}
						add(
							$current,
							"vertex",
							lv_vertex_7_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Pseudostate");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)+
	)
;

// Entry rule entryRuleStatemachineRegionLite
entryRuleStatemachineRegionLite returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStatemachineRegionLiteRule()); }
	iv_ruleStatemachineRegionLite=ruleStatemachineRegionLite
	{ $current=$iv_ruleStatemachineRegionLite.current; }
	EOF;

// Rule StatemachineRegionLite
ruleStatemachineRegionLite returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getStatemachineRegionLiteAccess().getVertexStateParserRuleCall_0_0());
				}
				lv_vertex_0_0=ruleState
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineRegionLiteRule());
					}
					add(
						$current,
						"vertex",
						lv_vertex_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.State");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getStatemachineRegionLiteAccess().getVertexPseudostateParserRuleCall_1_0());
				}
				lv_vertex_1_0=rulePseudostate
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineRegionLiteRule());
					}
					add(
						$current,
						"vertex",
						lv_vertex_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Pseudostate");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)+
;

// Entry rule entryRuleState
entryRuleState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStateRule()); }
	iv_ruleState=ruleState
	{ $current=$iv_ruleState.current; }
	EOF;

// Rule State
ruleState returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStateAccess().getCompositeStateParserRuleCall_0());
		}
		this_CompositeState_0=ruleCompositeState
		{
			$current = $this_CompositeState_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStateAccess().getStartStateParserRuleCall_1());
		}
		this_StartState_1=ruleStartState
		{
			$current = $this_StartState_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_2());
		}
		this_SimpleState_2=ruleSimpleState
		{
			$current = $this_SimpleState_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStateAccess().getFinalStateParserRuleCall_3());
		}
		this_FinalState_3=ruleFinalState
		{
			$current = $this_FinalState_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleCompositeState
entryRuleCompositeState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCompositeStateRule()); }
	iv_ruleCompositeState=ruleCompositeState
	{ $current=$iv_ruleCompositeState.current; }
	EOF;

// Rule CompositeState
ruleCompositeState returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getCompositeStateAccess().getStateAction_0(),
					$current);
			}
		)
		(
			(
				lv_composite_1_0='state'
				{
					newLeafNode(lv_composite_1_0, grammarAccess.getCompositeStateAccess().getCompositeStateKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCompositeStateRule());
					}
					setWithLastConsumed($current, "composite", true, "state");
				}
			)
		)
		otherlv_2='<'
		{
			newLeafNode(otherlv_2, grammarAccess.getCompositeStateAccess().getLessThanSignKeyword_2());
		}
		(
			otherlv_3='moc:'
			{
				newLeafNode(otherlv_3, grammarAccess.getCompositeStateAccess().getMocKeyword_3());
			}
		)?
		(
			otherlv_4='or'
			{
				newLeafNode(otherlv_4, grammarAccess.getCompositeStateAccess().getOrKeyword_4_0());
			}
			    |
			(
				(
					lv_orthogonal_5_0='and'
					{
						newLeafNode(lv_orthogonal_5_0, grammarAccess.getCompositeStateAccess().getOrthogonalAndKeyword_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getCompositeStateRule());
						}
						setWithLastConsumed($current, "orthogonal", true, "and");
					}
				)
			)
		)
		otherlv_6='>'
		{
			newLeafNode(otherlv_6, grammarAccess.getCompositeStateAccess().getGreaterThanSignKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCompositeStateAccess().getNameESIdentifierParserRuleCall_6_0());
				}
				lv_name_7_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
					}
					set(
						$current,
						"name",
						lv_name_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getCompositeStateAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_7_0());
				}
				lv_unrestrictedName_8_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_9='{'
				{
					newLeafNode(otherlv_9, grammarAccess.getCompositeStateAccess().getLeftCurlyBracketKeyword_8_0_0());
				}
				(
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getCompositeStateAccess().getRegionStatemachineRegionParserRuleCall_8_0_1_0_0_0());
								}
								lv_region_10_0=ruleStatemachineRegion
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
									}
									add(
										$current,
										"region",
										lv_region_10_0,
										"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegion");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							otherlv_11='@moe:'
							{
								newLeafNode(otherlv_11, grammarAccess.getCompositeStateAccess().getMoeKeyword_8_0_1_0_1_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getCompositeStateAccess().getMoeMoeCompositeStateRoutinesParserRuleCall_8_0_1_0_1_1_0());
									}
									lv_moe_12_0=rulemoeCompositeStateRoutines
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
										}
										add(
											$current,
											"moe",
											lv_moe_12_0,
											"org.eclipse.efm.formalml.xtext.FormalML.moeCompositeStateRoutines");
										afterParserOrEnumRuleCall();
									}
								)
							)*
						)
						    |
						(
							otherlv_13='@transition:'
							{
								newLeafNode(otherlv_13, grammarAccess.getCompositeStateAccess().getTransitionKeyword_8_0_1_0_2_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getCompositeStateAccess().getTransitionTransitionParserRuleCall_8_0_1_0_2_1_0());
									}
									lv_transition_14_0=ruleTransition
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
										}
										add(
											$current,
											"transition",
											lv_transition_14_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Transition");
										afterParserOrEnumRuleCall();
									}
								)
							)*
						)
					)+
					    |
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getCompositeStateAccess().getRegionStatemachineRegionLiteParserRuleCall_8_0_1_1_0_0());
								}
								lv_region_15_0=ruleStatemachineRegionLite
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
									}
									add(
										$current,
										"region",
										lv_region_15_0,
										"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegionLite");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getCompositeStateAccess().getTransitionTransitionParserRuleCall_8_0_1_1_1_0_0());
									}
									lv_transition_16_0=ruleTransition
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
										}
										add(
											$current,
											"transition",
											lv_transition_16_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Transition");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							(
								(
									{
										newCompositeNode(grammarAccess.getCompositeStateAccess().getMoeMoeCompositeStateRoutinesParserRuleCall_8_0_1_1_1_1_0());
									}
									lv_moe_17_0=rulemoeCompositeStateRoutines
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
										}
										add(
											$current,
											"moe",
											lv_moe_17_0,
											"org.eclipse.efm.formalml.xtext.FormalML.moeCompositeStateRoutines");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)*
					)
				)
				otherlv_18='}'
				{
					newLeafNode(otherlv_18, grammarAccess.getCompositeStateAccess().getRightCurlyBracketKeyword_8_0_2());
				}
			)
			    |
			otherlv_19=';'
			{
				newLeafNode(otherlv_19, grammarAccess.getCompositeStateAccess().getSemicolonKeyword_8_1());
			}
		)
	)
;

// Entry rule entryRulemoeCompositeStateRoutines
entryRulemoeCompositeStateRoutines returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesRule()); }
	iv_rulemoeCompositeStateRoutines=rulemoeCompositeStateRoutines
	{ $current=$iv_rulemoeCompositeStateRoutines.current; }
	EOF;

// Rule moeCompositeStateRoutines
rulemoeCompositeStateRoutines returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMoeCompositeStateRoutinesAccess().getRoutineAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_name_1_1='@init'
					{
						newLeafNode(lv_name_1_1, grammarAccess.getMoeCompositeStateRoutinesAccess().getNameInitKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeCompositeStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_1, null);
					}
					    |
					lv_name_1_2='@final'
					{
						newLeafNode(lv_name_1_2, grammarAccess.getMoeCompositeStateRoutinesAccess().getNameFinalKeyword_1_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeCompositeStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_2, null);
					}
					    |
					lv_name_1_3='@enable'
					{
						newLeafNode(lv_name_1_3, grammarAccess.getMoeCompositeStateRoutinesAccess().getNameEnableKeyword_1_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeCompositeStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_3, null);
					}
					    |
					lv_name_1_4='@disable'
					{
						newLeafNode(lv_name_1_4, grammarAccess.getMoeCompositeStateRoutinesAccess().getNameDisableKeyword_1_0_3());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeCompositeStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_4, null);
					}
					    |
					lv_name_1_5='@concurrency'
					{
						newLeafNode(lv_name_1_5, grammarAccess.getMoeCompositeStateRoutinesAccess().getNameConcurrencyKeyword_1_0_4());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeCompositeStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_5, null);
					}
					    |
					lv_name_1_6='@schedule'
					{
						newLeafNode(lv_name_1_6, grammarAccess.getMoeCompositeStateRoutinesAccess().getNameScheduleKeyword_1_0_5());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeCompositeStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_6, null);
					}
					    |
					lv_name_1_7='@irun'
					{
						newLeafNode(lv_name_1_7, grammarAccess.getMoeCompositeStateRoutinesAccess().getNameIrunKeyword_1_0_6());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeCompositeStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_7, null);
					}
					    |
					lv_name_1_8='@run'
					{
						newLeafNode(lv_name_1_8, grammarAccess.getMoeCompositeStateRoutinesAccess().getNameRunKeyword_1_0_7());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeCompositeStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_8, null);
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getBodyBlockBlockStatementParserRuleCall_2_0());
				}
				lv_bodyBlock_2_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleSimpleState
entryRuleSimpleState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSimpleStateRule()); }
	iv_ruleSimpleState=ruleSimpleState
	{ $current=$iv_ruleSimpleState.current; }
	EOF;

// Rule SimpleState
ruleSimpleState returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getSimpleStateAccess().getStateAction_0(),
					$current);
			}
		)
		(
			(
				lv_simple_1_0='state'
				{
					newLeafNode(lv_simple_1_0, grammarAccess.getSimpleStateAccess().getSimpleStateKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSimpleStateRule());
					}
					setWithLastConsumed($current, "simple", true, "state");
				}
			)
		)
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getSimpleStateAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_3='moc:'
				{
					newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getMocKeyword_2_1());
				}
			)?
			otherlv_4='simple'
			{
				newLeafNode(otherlv_4, grammarAccess.getSimpleStateAccess().getSimpleKeyword_2_2());
			}
			otherlv_5='>'
			{
				newLeafNode(otherlv_5, grammarAccess.getSimpleStateAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getSimpleStateAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_6_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSimpleStateRule());
					}
					set(
						$current,
						"name",
						lv_name_6_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSimpleStateAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_7_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSimpleStateRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_8='{'
				{
					newLeafNode(otherlv_8, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_5_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSimpleStateAccess().getTransitionTransitionParserRuleCall_5_0_1_0_0());
							}
							lv_transition_9_0=ruleTransition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSimpleStateRule());
								}
								add(
									$current,
									"transition",
									lv_transition_9_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Transition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getSimpleStateAccess().getMoeMoeSimpleStateRoutinesParserRuleCall_5_0_1_1_0());
							}
							lv_moe_10_0=rulemoeSimpleStateRoutines
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSimpleStateRule());
								}
								add(
									$current,
									"moe",
									lv_moe_10_0,
									"org.eclipse.efm.formalml.xtext.FormalML.moeSimpleStateRoutines");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_11='}'
				{
					newLeafNode(otherlv_11, grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_5_0_2());
				}
			)
			    |
			otherlv_12=';'
			{
				newLeafNode(otherlv_12, grammarAccess.getSimpleStateAccess().getSemicolonKeyword_5_1());
			}
		)
	)
;

// Entry rule entryRulemoeSimpleStateRoutines
entryRulemoeSimpleStateRoutines returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMoeSimpleStateRoutinesRule()); }
	iv_rulemoeSimpleStateRoutines=rulemoeSimpleStateRoutines
	{ $current=$iv_rulemoeSimpleStateRoutines.current; }
	EOF;

// Rule moeSimpleStateRoutines
rulemoeSimpleStateRoutines returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMoeSimpleStateRoutinesAccess().getRoutineAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_name_1_1='@enable'
					{
						newLeafNode(lv_name_1_1, grammarAccess.getMoeSimpleStateRoutinesAccess().getNameEnableKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeSimpleStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_1, null);
					}
					    |
					lv_name_1_2='@disable'
					{
						newLeafNode(lv_name_1_2, grammarAccess.getMoeSimpleStateRoutinesAccess().getNameDisableKeyword_1_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeSimpleStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_2, null);
					}
					    |
					lv_name_1_3='@irun'
					{
						newLeafNode(lv_name_1_3, grammarAccess.getMoeSimpleStateRoutinesAccess().getNameIrunKeyword_1_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeSimpleStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_3, null);
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMoeSimpleStateRoutinesAccess().getBodyBlockBlockStatementParserRuleCall_2_0());
				}
				lv_bodyBlock_2_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMoeSimpleStateRoutinesRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleStartState
entryRuleStartState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStartStateRule()); }
	iv_ruleStartState=ruleStartState
	{ $current=$iv_ruleStartState.current; }
	EOF;

// Rule StartState
ruleStartState returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getStartStateAccess().getStartStateAction_0(),
					$current);
			}
		)
		(
			(
				(
					(
						lv_simple_1_0='state'
						{
							newLeafNode(lv_simple_1_0, grammarAccess.getStartStateAccess().getSimpleStateKeyword_1_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getStartStateRule());
							}
							setWithLastConsumed($current, "simple", true, "state");
						}
					)
				)
				otherlv_2='<'
				{
					newLeafNode(otherlv_2, grammarAccess.getStartStateAccess().getLessThanSignKeyword_1_0_1());
				}
				(
					otherlv_3='moc:'
					{
						newLeafNode(otherlv_3, grammarAccess.getStartStateAccess().getMocKeyword_1_0_2());
					}
				)?
				otherlv_4='start'
				{
					newLeafNode(otherlv_4, grammarAccess.getStartStateAccess().getStartKeyword_1_0_3());
				}
				otherlv_5='>'
				{
					newLeafNode(otherlv_5, grammarAccess.getStartStateAccess().getGreaterThanSignKeyword_1_0_4());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStartStateAccess().getNameESIdentifierParserRuleCall_1_0_5_0());
						}
						lv_name_6_0=ruleESIdentifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStartStateRule());
							}
							set(
								$current,
								"name",
								lv_name_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					lv_simple_7_0='#start'
					{
						newLeafNode(lv_simple_7_0, grammarAccess.getStartStateAccess().getSimpleStartKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getStartStateRule());
						}
						setWithLastConsumed($current, "simple", true, "#start");
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStartStateAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_8_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStartStateRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_9='{'
				{
					newLeafNode(otherlv_9, grammarAccess.getStartStateAccess().getLeftCurlyBracketKeyword_3_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStartStateAccess().getTransitionTransitionParserRuleCall_3_0_1_0_0());
							}
							lv_transition_10_0=ruleTransition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStartStateRule());
								}
								add(
									$current,
									"transition",
									lv_transition_10_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Transition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStartStateAccess().getMoeMoeStartStateRoutinesParserRuleCall_3_0_1_1_0());
							}
							lv_moe_11_0=rulemoeStartStateRoutines
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStartStateRule());
								}
								add(
									$current,
									"moe",
									lv_moe_11_0,
									"org.eclipse.efm.formalml.xtext.FormalML.moeStartStateRoutines");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_12='}'
				{
					newLeafNode(otherlv_12, grammarAccess.getStartStateAccess().getRightCurlyBracketKeyword_3_0_2());
				}
			)
			    |
			otherlv_13=';'
			{
				newLeafNode(otherlv_13, grammarAccess.getStartStateAccess().getSemicolonKeyword_3_1());
			}
		)
	)
;

// Entry rule entryRulemoeStartStateRoutines
entryRulemoeStartStateRoutines returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMoeStartStateRoutinesRule()); }
	iv_rulemoeStartStateRoutines=rulemoeStartStateRoutines
	{ $current=$iv_rulemoeStartStateRoutines.current; }
	EOF;

// Rule moeStartStateRoutines
rulemoeStartStateRoutines returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMoeStartStateRoutinesAccess().getRoutineAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_name_1_1='@init'
					{
						newLeafNode(lv_name_1_1, grammarAccess.getMoeStartStateRoutinesAccess().getNameInitKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeStartStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_1, null);
					}
					    |
					lv_name_1_2='@enable'
					{
						newLeafNode(lv_name_1_2, grammarAccess.getMoeStartStateRoutinesAccess().getNameEnableKeyword_1_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeStartStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_2, null);
					}
					    |
					lv_name_1_3='@disable'
					{
						newLeafNode(lv_name_1_3, grammarAccess.getMoeStartStateRoutinesAccess().getNameDisableKeyword_1_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeStartStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_3, null);
					}
					    |
					lv_name_1_4='@irun'
					{
						newLeafNode(lv_name_1_4, grammarAccess.getMoeStartStateRoutinesAccess().getNameIrunKeyword_1_0_3());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeStartStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_4, null);
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMoeStartStateRoutinesAccess().getBodyBlockBlockStatementParserRuleCall_2_0());
				}
				lv_bodyBlock_2_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMoeStartStateRoutinesRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleFinalState
entryRuleFinalState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFinalStateRule()); }
	iv_ruleFinalState=ruleFinalState
	{ $current=$iv_ruleFinalState.current; }
	EOF;

// Rule FinalState
ruleFinalState returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getFinalStateAccess().getFinalStateAction_0(),
					$current);
			}
		)
		(
			(
				(
					(
						lv_simple_1_0='state'
						{
							newLeafNode(lv_simple_1_0, grammarAccess.getFinalStateAccess().getSimpleStateKeyword_1_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getFinalStateRule());
							}
							setWithLastConsumed($current, "simple", true, "state");
						}
					)
				)
				otherlv_2='<'
				{
					newLeafNode(otherlv_2, grammarAccess.getFinalStateAccess().getLessThanSignKeyword_1_0_1());
				}
				(
					otherlv_3='moc:'
					{
						newLeafNode(otherlv_3, grammarAccess.getFinalStateAccess().getMocKeyword_1_0_2());
					}
				)?
				otherlv_4='final'
				{
					newLeafNode(otherlv_4, grammarAccess.getFinalStateAccess().getFinalKeyword_1_0_3());
				}
				otherlv_5='>'
				{
					newLeafNode(otherlv_5, grammarAccess.getFinalStateAccess().getGreaterThanSignKeyword_1_0_4());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getFinalStateAccess().getNameESIdentifierParserRuleCall_1_0_5_0());
						}
						lv_name_6_0=ruleESIdentifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFinalStateRule());
							}
							set(
								$current,
								"name",
								lv_name_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					lv_simple_7_0='#final'
					{
						newLeafNode(lv_simple_7_0, grammarAccess.getFinalStateAccess().getSimpleFinalKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getFinalStateRule());
						}
						setWithLastConsumed($current, "simple", true, "#final");
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFinalStateAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_8_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFinalStateRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_9='{'
				{
					newLeafNode(otherlv_9, grammarAccess.getFinalStateAccess().getLeftCurlyBracketKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getFinalStateAccess().getMoeMoeFinalStateRoutinesParserRuleCall_3_0_1_0());
						}
						lv_moe_10_0=rulemoeFinalStateRoutines
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFinalStateRule());
							}
							add(
								$current,
								"moe",
								lv_moe_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.moeFinalStateRoutines");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_11='}'
				{
					newLeafNode(otherlv_11, grammarAccess.getFinalStateAccess().getRightCurlyBracketKeyword_3_0_2());
				}
			)
			    |
			otherlv_12=';'
			{
				newLeafNode(otherlv_12, grammarAccess.getFinalStateAccess().getSemicolonKeyword_3_1());
			}
		)
	)
;

// Entry rule entryRulemoeFinalStateRoutines
entryRulemoeFinalStateRoutines returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMoeFinalStateRoutinesRule()); }
	iv_rulemoeFinalStateRoutines=rulemoeFinalStateRoutines
	{ $current=$iv_rulemoeFinalStateRoutines.current; }
	EOF;

// Rule moeFinalStateRoutines
rulemoeFinalStateRoutines returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMoeFinalStateRoutinesAccess().getRoutineAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_name_1_1='@enable'
					{
						newLeafNode(lv_name_1_1, grammarAccess.getMoeFinalStateRoutinesAccess().getNameEnableKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeFinalStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_1, null);
					}
					    |
					lv_name_1_2='@final'
					{
						newLeafNode(lv_name_1_2, grammarAccess.getMoeFinalStateRoutinesAccess().getNameFinalKeyword_1_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMoeFinalStateRoutinesRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_2, null);
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMoeFinalStateRoutinesAccess().getBodyBlockBlockStatementParserRuleCall_2_0());
				}
				lv_bodyBlock_2_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMoeFinalStateRoutinesRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRulePseudostate
entryRulePseudostate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPseudostateRule()); }
	iv_rulePseudostate=rulePseudostate
	{ $current=$iv_rulePseudostate.current; }
	EOF;

// Rule Pseudostate
rulePseudostate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPseudostateAccess().getPseudostateInitialParserRuleCall_0());
		}
		this_PseudostateInitial_0=rulePseudostateInitial
		{
			$current = $this_PseudostateInitial_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPseudostateAccess().getEndingPseudostateParserRuleCall_1());
		}
		this_EndingPseudostate_1=ruleEndingPseudostate
		{
			$current = $this_EndingPseudostate_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPseudostateAccess().getOtherPseudostateParserRuleCall_2());
		}
		this_OtherPseudostate_2=ruleOtherPseudostate
		{
			$current = $this_OtherPseudostate_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleOtherPseudostate
entryRuleOtherPseudostate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOtherPseudostateRule()); }
	iv_ruleOtherPseudostate=ruleOtherPseudostate
	{ $current=$iv_ruleOtherPseudostate.current; }
	EOF;

// Rule OtherPseudostate
ruleOtherPseudostate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getOtherPseudostateAccess().getPseudostateAction_0(),
					$current);
			}
		)
		(
			otherlv_1='state'
			{
				newLeafNode(otherlv_1, grammarAccess.getOtherPseudostateAccess().getStateKeyword_1_0());
			}
			    |
			otherlv_2='pseudostate'
			{
				newLeafNode(otherlv_2, grammarAccess.getOtherPseudostateAccess().getPseudostateKeyword_1_1());
			}
		)
		otherlv_3='<'
		{
			newLeafNode(otherlv_3, grammarAccess.getOtherPseudostateAccess().getLessThanSignKeyword_2());
		}
		(
			otherlv_4='moc:'
			{
				newLeafNode(otherlv_4, grammarAccess.getOtherPseudostateAccess().getMocKeyword_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherPseudostateAccess().getKindPseudostateKindEnumRuleCall_4_0());
				}
				lv_kind_5_0=rulePseudostateKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherPseudostateRule());
					}
					set(
						$current,
						"kind",
						lv_kind_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PseudostateKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='>'
		{
			newLeafNode(otherlv_6, grammarAccess.getOtherPseudostateAccess().getGreaterThanSignKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherPseudostateAccess().getNameESIdentifierParserRuleCall_6_0());
				}
				lv_name_7_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherPseudostateRule());
					}
					set(
						$current,
						"name",
						lv_name_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherPseudostateAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_7_0());
				}
				lv_unrestrictedName_8_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherPseudostateRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_9='{'
				{
					newLeafNode(otherlv_9, grammarAccess.getOtherPseudostateAccess().getLeftCurlyBracketKeyword_8_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getOtherPseudostateAccess().getTransitionTransitionParserRuleCall_8_0_1_0());
						}
						lv_transition_10_0=ruleTransition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOtherPseudostateRule());
							}
							add(
								$current,
								"transition",
								lv_transition_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Transition");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_11='}'
				{
					newLeafNode(otherlv_11, grammarAccess.getOtherPseudostateAccess().getRightCurlyBracketKeyword_8_0_2());
				}
			)
			    |
			otherlv_12=';'
			{
				newLeafNode(otherlv_12, grammarAccess.getOtherPseudostateAccess().getSemicolonKeyword_8_1());
			}
		)
	)
;

// Entry rule entryRulePseudostateInitial
entryRulePseudostateInitial returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPseudostateInitialRule()); }
	iv_rulePseudostateInitial=rulePseudostateInitial
	{ $current=$iv_rulePseudostateInitial.current; }
	EOF;

// Rule PseudostateInitial
rulePseudostateInitial returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPseudostateInitialAccess().getPseudostateAction_0(),
					$current);
			}
		)
		(
			(
				(
					otherlv_1='state'
					{
						newLeafNode(otherlv_1, grammarAccess.getPseudostateInitialAccess().getStateKeyword_1_0_0_0());
					}
					    |
					otherlv_2='pseudostate'
					{
						newLeafNode(otherlv_2, grammarAccess.getPseudostateInitialAccess().getPseudostateKeyword_1_0_0_1());
					}
				)
				otherlv_3='<'
				{
					newLeafNode(otherlv_3, grammarAccess.getPseudostateInitialAccess().getLessThanSignKeyword_1_0_1());
				}
				(
					otherlv_4='moc:'
					{
						newLeafNode(otherlv_4, grammarAccess.getPseudostateInitialAccess().getMocKeyword_1_0_2());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPseudostateInitialAccess().getKindPseudostateInitialKindEnumRuleCall_1_0_3_0());
						}
						lv_kind_5_0=rulePseudostateInitialKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPseudostateInitialRule());
							}
							set(
								$current,
								"kind",
								lv_kind_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PseudostateInitialKind");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_6='>'
				{
					newLeafNode(otherlv_6, grammarAccess.getPseudostateInitialAccess().getGreaterThanSignKeyword_1_0_4());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getPseudostateInitialAccess().getNameESIdentifierParserRuleCall_1_0_5_0_0());
							}
							lv_name_7_1=ruleESIdentifier
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPseudostateInitialRule());
								}
								set(
									$current,
									"name",
									lv_name_7_1,
									"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
								afterParserOrEnumRuleCall();
							}
							    |
							lv_name_7_2='#initial'
							{
								newLeafNode(lv_name_7_2, grammarAccess.getPseudostateInitialAccess().getNameInitialKeyword_1_0_5_0_1());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getPseudostateInitialRule());
								}
								setWithLastConsumed($current, "name", lv_name_7_2, null);
							}
							    |
							lv_name_7_3='#init'
							{
								newLeafNode(lv_name_7_3, grammarAccess.getPseudostateInitialAccess().getNameInitKeyword_1_0_5_0_2());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getPseudostateInitialRule());
								}
								setWithLastConsumed($current, "name", lv_name_7_3, null);
							}
						)
					)
				)
			)
			    |
			(
				(
					(
						lv_name_8_1='#initial'
						{
							newLeafNode(lv_name_8_1, grammarAccess.getPseudostateInitialAccess().getNameInitialKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getPseudostateInitialRule());
							}
							setWithLastConsumed($current, "name", lv_name_8_1, null);
						}
						    |
						lv_name_8_2='#init'
						{
							newLeafNode(lv_name_8_2, grammarAccess.getPseudostateInitialAccess().getNameInitKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getPseudostateInitialRule());
							}
							setWithLastConsumed($current, "name", lv_name_8_2, null);
						}
					)
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPseudostateInitialAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_9_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPseudostateInitialRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_9_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_10='{'
				{
					newLeafNode(otherlv_10, grammarAccess.getPseudostateInitialAccess().getLeftCurlyBracketKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPseudostateInitialAccess().getTransitionTransitionParserRuleCall_3_0_1_0());
						}
						lv_transition_11_0=ruleTransition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPseudostateInitialRule());
							}
							add(
								$current,
								"transition",
								lv_transition_11_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Transition");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_12='}'
				{
					newLeafNode(otherlv_12, grammarAccess.getPseudostateInitialAccess().getRightCurlyBracketKeyword_3_0_2());
				}
			)
			    |
			otherlv_13=';'
			{
				newLeafNode(otherlv_13, grammarAccess.getPseudostateInitialAccess().getSemicolonKeyword_3_1());
			}
		)
	)
;

// Entry rule entryRuleEndingPseudostate
entryRuleEndingPseudostate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEndingPseudostateRule()); }
	iv_ruleEndingPseudostate=ruleEndingPseudostate
	{ $current=$iv_ruleEndingPseudostate.current; }
	EOF;

// Rule EndingPseudostate
ruleEndingPseudostate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getEndingPseudostateAccess().getPseudostateAction_0(),
					$current);
			}
		)
		(
			otherlv_1='state'
			{
				newLeafNode(otherlv_1, grammarAccess.getEndingPseudostateAccess().getStateKeyword_1_0());
			}
			    |
			otherlv_2='pseudostate'
			{
				newLeafNode(otherlv_2, grammarAccess.getEndingPseudostateAccess().getPseudostateKeyword_1_1());
			}
		)
		otherlv_3='<'
		{
			newLeafNode(otherlv_3, grammarAccess.getEndingPseudostateAccess().getLessThanSignKeyword_2());
		}
		(
			otherlv_4='moc:'
			{
				newLeafNode(otherlv_4, grammarAccess.getEndingPseudostateAccess().getMocKeyword_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getEndingPseudostateAccess().getKindEndingPseudostateKindEnumRuleCall_4_0());
				}
				lv_kind_5_0=ruleEndingPseudostateKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEndingPseudostateRule());
					}
					set(
						$current,
						"kind",
						lv_kind_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EndingPseudostateKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='>'
		{
			newLeafNode(otherlv_6, grammarAccess.getEndingPseudostateAccess().getGreaterThanSignKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEndingPseudostateAccess().getNameESIdentifierParserRuleCall_6_0());
				}
				lv_name_7_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEndingPseudostateRule());
					}
					set(
						$current,
						"name",
						lv_name_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEndingPseudostateAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_7_0());
				}
				lv_unrestrictedName_8_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEndingPseudostateRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_9='{'
				{
					newLeafNode(otherlv_9, grammarAccess.getEndingPseudostateAccess().getLeftCurlyBracketKeyword_8_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEndingPseudostateAccess().getMoeMoeFinalStateRoutinesParserRuleCall_8_0_1_0());
						}
						lv_moe_10_0=rulemoeFinalStateRoutines
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEndingPseudostateRule());
							}
							add(
								$current,
								"moe",
								lv_moe_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.moeFinalStateRoutines");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_11='}'
				{
					newLeafNode(otherlv_11, grammarAccess.getEndingPseudostateAccess().getRightCurlyBracketKeyword_8_0_2());
				}
			)
			    |
			otherlv_12=';'
			{
				newLeafNode(otherlv_12, grammarAccess.getEndingPseudostateAccess().getSemicolonKeyword_8_1());
			}
		)
	)
;

// Entry rule entryRuleModelOfExecution
entryRuleModelOfExecution returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3()
	);
}:
	{ newCompositeNode(grammarAccess.getModelOfExecutionRule()); }
	iv_ruleModelOfExecution=ruleModelOfExecution
	{ $current=$iv_ruleModelOfExecution.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule ModelOfExecution
ruleModelOfExecution returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getModelOfExecutionAccess().getModelOfExecutionAction_0(),
					$current);
			}
		)
		otherlv_1='@moe:'
		{
			newLeafNode(otherlv_1, grammarAccess.getModelOfExecutionAccess().getMoeKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelOfExecutionAccess().getRoutineRoutineParserRuleCall_2_0());
				}
				lv_routine_2_0=ruleRoutine
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
					}
					add(
						$current,
						"routine",
						lv_routine_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Routine");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_4='@init'
								{
									newLeafNode(otherlv_4, grammarAccess.getModelOfExecutionAccess().getInitKeyword_3_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getInitRoutineMoeRoutineParserRuleCall_3_0_1_0());
										}
										lv_initRoutine_5_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"initRoutine",
												lv_initRoutine_5_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>(otherlv_6='@final'
								{
									newLeafNode(otherlv_6, grammarAccess.getModelOfExecutionAccess().getFinalKeyword_3_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getFinalRoutineMoeRoutineParserRuleCall_3_1_1_0());
										}
										lv_finalRoutine_7_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"finalRoutine",
												lv_finalRoutine_7_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>(otherlv_8='@enable'
								{
									newLeafNode(otherlv_8, grammarAccess.getModelOfExecutionAccess().getEnableKeyword_3_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getEnableRoutineMoeRoutineParserRuleCall_3_2_1_0());
										}
										lv_enableRoutine_9_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"enableRoutine",
												lv_enableRoutine_9_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 3);
					}
								({true}?=>(otherlv_10='@disable'
								{
									newLeafNode(otherlv_10, grammarAccess.getModelOfExecutionAccess().getDisableKeyword_3_3_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getDisableRoutineMoeRoutineParserRuleCall_3_3_1_0());
										}
										lv_disableRoutine_11_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"disableRoutine",
												lv_disableRoutine_11_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 4);
					}
								({true}?=>(otherlv_12='@concurrency'
								{
									newLeafNode(otherlv_12, grammarAccess.getModelOfExecutionAccess().getConcurrencyKeyword_3_4_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getConcurrencyRoutineMoeRoutineParserRuleCall_3_4_1_0());
										}
										lv_concurrencyRoutine_13_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"concurrencyRoutine",
												lv_concurrencyRoutine_13_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 5);
					}
								({true}?=>(otherlv_14='@schedule'
								{
									newLeafNode(otherlv_14, grammarAccess.getModelOfExecutionAccess().getScheduleKeyword_3_5_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getScheduleRoutineMoeRoutineParserRuleCall_3_5_1_0());
										}
										lv_scheduleRoutine_15_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"scheduleRoutine",
												lv_scheduleRoutine_15_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 6)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 6);
					}
								({true}?=>(otherlv_16='@irun'
								{
									newLeafNode(otherlv_16, grammarAccess.getModelOfExecutionAccess().getIrunKeyword_3_6_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getIrunRoutineMoeRoutineParserRuleCall_3_6_1_0());
										}
										lv_irunRoutine_17_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"irunRoutine",
												lv_irunRoutine_17_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 7)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 7);
					}
								({true}?=>(otherlv_18='@run'
								{
									newLeafNode(otherlv_18, grammarAccess.getModelOfExecutionAccess().getRunKeyword_3_7_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getRunRoutineMoeRoutineParserRuleCall_3_7_1_0());
										}
										lv_runRoutine_19_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"runRoutine",
												lv_runRoutine_19_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3());
				}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getModelOfExecutionAccess().getRoutineRoutineParserRuleCall_4_0());
				}
				lv_routine_20_0=ruleRoutine
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
					}
					add(
						$current,
						"routine",
						lv_routine_20_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Routine");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRulemoeRoutine
entryRulemoeRoutine returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMoeRoutineRule()); }
	iv_rulemoeRoutine=rulemoeRoutine
	{ $current=$iv_rulemoeRoutine.current; }
	EOF;

// Rule moeRoutine
rulemoeRoutine returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMoeRoutineAccess().getRoutineAction_0(),
					$current);
			}
		)
		(
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getMoeRoutineAccess().getLeftParenthesisKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getMoeRoutineAccess().getDomainFunctionalParameterSetParserRuleCall_1_1_0());
					}
					lv_domain_2_0=ruleFunctionalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMoeRoutineRule());
						}
						set(
							$current,
							"domain",
							lv_domain_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_3=')'
			{
				newLeafNode(otherlv_3, grammarAccess.getMoeRoutineAccess().getRightParenthesisKeyword_1_2());
			}
		)?
		(
			otherlv_4='->'
			{
				newLeafNode(otherlv_4, grammarAccess.getMoeRoutineAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
			}
			(
				(
					otherlv_5='('
					{
						newLeafNode(otherlv_5, grammarAccess.getMoeRoutineAccess().getLeftParenthesisKeyword_2_1_0_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMoeRoutineAccess().getCodomainFunctionalParameterSetParserRuleCall_2_1_0_1_0());
							}
							lv_codomain_6_0=ruleFunctionalParameterSet
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMoeRoutineRule());
								}
								set(
									$current,
									"codomain",
									lv_codomain_6_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameterSet");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_7=')'
					{
						newLeafNode(otherlv_7, grammarAccess.getMoeRoutineAccess().getRightParenthesisKeyword_2_1_0_2());
					}
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getMoeRoutineAccess().getCodomainFunctionalParameterSetParserRuleCall_2_1_1_0());
						}
						lv_codomain_8_0=ruleFunctionalParameterSet
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeRoutineRule());
							}
							set(
								$current,
								"codomain",
								lv_codomain_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameterSet");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getMoeRoutineAccess().getBodyBlockBlockStatementParserRuleCall_3_0());
				}
				lv_bodyBlock_9_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMoeRoutineRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_9_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleRoutine
entryRuleRoutine returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRoutineRule()); }
	iv_ruleRoutine=ruleRoutine
	{ $current=$iv_ruleRoutine.current; }
	EOF;

// Rule Routine
ruleRoutine returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRoutineAccess().getVisibilityVisibilityKindEnumRuleCall_0_0());
				}
				lv_visibility_0_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoutineRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_1='macro'
			{
				newLeafNode(otherlv_1, grammarAccess.getRoutineAccess().getMacroKeyword_1());
			}
		)?
		otherlv_2='routine'
		{
			newLeafNode(otherlv_2, grammarAccess.getRoutineAccess().getRoutineKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRoutineAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoutineRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getRoutineAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoutineRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_5='('
			{
				newLeafNode(otherlv_5, grammarAccess.getRoutineAccess().getLeftParenthesisKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRoutineAccess().getDomainFunctionalParameterSetParserRuleCall_5_1_0());
					}
					lv_domain_6_0=ruleFunctionalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRoutineRule());
						}
						set(
							$current,
							"domain",
							lv_domain_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_7=')'
			{
				newLeafNode(otherlv_7, grammarAccess.getRoutineAccess().getRightParenthesisKeyword_5_2());
			}
		)?
		(
			otherlv_8='-->'
			{
				newLeafNode(otherlv_8, grammarAccess.getRoutineAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_6_0());
			}
			(
				(
					otherlv_9='('
					{
						newLeafNode(otherlv_9, grammarAccess.getRoutineAccess().getLeftParenthesisKeyword_6_1_0_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getRoutineAccess().getCodomainFunctionalParameterSetParserRuleCall_6_1_0_1_0());
							}
							lv_codomain_10_0=ruleFunctionalParameterSet
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getRoutineRule());
								}
								set(
									$current,
									"codomain",
									lv_codomain_10_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameterSet");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_11=')'
					{
						newLeafNode(otherlv_11, grammarAccess.getRoutineAccess().getRightParenthesisKeyword_6_1_0_2());
					}
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getRoutineAccess().getCodomainFormalParameterSetParserRuleCall_6_1_1_0());
						}
						lv_codomain_12_0=ruleFormalParameterSet
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRoutineRule());
							}
							set(
								$current,
								"codomain",
								lv_codomain_12_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getRoutineAccess().getBodyBlockBlockStatementParserRuleCall_7_0());
				}
				lv_bodyBlock_13_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoutineRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_13_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleModelOfInteraction
entryRuleModelOfInteraction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelOfInteractionRule()); }
	iv_ruleModelOfInteraction=ruleModelOfInteraction
	{ $current=$iv_ruleModelOfInteraction.current; }
	EOF;

// Rule ModelOfInteraction
ruleModelOfInteraction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getModelOfInteractionAccess().getModelOfInteractionAction_0(),
					$current);
			}
		)
		otherlv_1='@com:'
		{
			newLeafNode(otherlv_1, grammarAccess.getModelOfInteractionAccess().getComKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getModelOfInteractionAccess().getRoutesRouteParserRuleCall_2_0_0());
					}
					lv_routes_2_0=ruleRoute
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getModelOfInteractionRule());
						}
						add(
							$current,
							"routes",
							lv_routes_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Route");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getModelOfInteractionAccess().getConnectionsConnectionParserRuleCall_2_1_0());
					}
					lv_connections_3_0=ruleConnection
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getModelOfInteractionRule());
						}
						add(
							$current,
							"connections",
							lv_connections_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Connection");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleRoute
entryRuleRoute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRouteRule()); }
	iv_ruleRoute=ruleRoute
	{ $current=$iv_ruleRoute.current; }
	EOF;

// Rule Route
ruleRoute returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getRouteAccess().getRouteAction_0(),
					$current);
			}
		)
		otherlv_1='route'
		{
			newLeafNode(otherlv_1, grammarAccess.getRouteAccess().getRouteKeyword_1());
		}
		otherlv_2='<'
		{
			newLeafNode(otherlv_2, grammarAccess.getRouteAccess().getLessThanSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRouteAccess().getProtocolComRouteProtocolParserRuleCall_3_0());
				}
				lv_protocol_3_0=ruleComRouteProtocol
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRouteRule());
					}
					set(
						$current,
						"protocol",
						lv_protocol_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComRouteProtocol");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='>'
		{
			newLeafNode(otherlv_4, grammarAccess.getRouteAccess().getGreaterThanSignKeyword_4());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getRouteAccess().getNameESIdentifierParserRuleCall_5_0_0());
					}
					lv_name_5_0=ruleESIdentifier
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRouteRule());
						}
						set(
							$current,
							"name",
							lv_name_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getRouteAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_1_0());
					}
					lv_unrestrictedName_6_0=ruleUnrestrictedName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRouteRule());
						}
						set(
							$current,
							"unrestrictedName",
							lv_unrestrictedName_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
						afterParserOrEnumRuleCall();
					}
				)
			)?
		)?
		otherlv_7='['
		{
			newLeafNode(otherlv_7, grammarAccess.getRouteAccess().getLeftSquareBracketKeyword_6());
		}
		(
			otherlv_8='*'
			{
				newLeafNode(otherlv_8, grammarAccess.getRouteAccess().getAsteriskKeyword_7_0());
			}
			    |
			(
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getRouteRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getRouteAccess().getSignalsSignalCrossReference_7_1_0_0());
						}
						ruleESUfid
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_10=','
					{
						newLeafNode(otherlv_10, grammarAccess.getRouteAccess().getCommaKeyword_7_1_1_0());
					}
					(
						(
							{
								/* */
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getRouteRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getRouteAccess().getSignalsSignalCrossReference_7_1_1_1_0());
							}
							ruleESUfid
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)
		otherlv_12=']'
		{
			newLeafNode(otherlv_12, grammarAccess.getRouteAccess().getRightSquareBracketKeyword_8());
		}
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getRouteAccess().getSemicolonKeyword_9());
		}
	)
;

// Entry rule entryRuleComRouteProtocol
entryRuleComRouteProtocol returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComRouteProtocolRule()); }
	iv_ruleComRouteProtocol=ruleComRouteProtocol
	{ $current=$iv_ruleComRouteProtocol.current; }
	EOF;

// Rule ComRouteProtocol
ruleComRouteProtocol returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getComRouteProtocolAccess().getProtocolComProtocolKindEnumRuleCall_0_0());
				}
				lv_protocol_0_0=ruleComProtocolKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComRouteProtocolRule());
					}
					set(
						$current,
						"protocol",
						lv_protocol_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComProtocolKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getComRouteProtocolAccess().getProtocolBufferProtocolKindEnumRuleCall_1_0_0());
					}
					lv_protocol_1_0=ruleBufferProtocolKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComRouteProtocolRule());
						}
						set(
							$current,
							"protocol",
							lv_protocol_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BufferProtocolKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					otherlv_2=':'
					{
						newLeafNode(otherlv_2, grammarAccess.getComRouteProtocolAccess().getColonKeyword_1_1_0_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getComRouteProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_1_1_0_1_0_0());
								}
								lv_inner_buffer_3_0=ruleBufferContainerType
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComRouteProtocolRule());
									}
									set(
										$current,
										"inner_buffer",
										lv_inner_buffer_3_0,
										"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getComRouteProtocolAccess().getBufferComBufferParserRuleCall_1_1_0_1_1_0());
								}
								lv_buffer_4_0=ruleComBuffer
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComRouteProtocolRule());
									}
									set(
										$current,
										"buffer",
										lv_buffer_4_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				    |
				(
					otherlv_5='<'
					{
						newLeafNode(otherlv_5, grammarAccess.getComRouteProtocolAccess().getLessThanSignKeyword_1_1_1_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getComRouteProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_1_1_1_1_0_0());
								}
								lv_inner_buffer_6_0=ruleBufferContainerType
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComRouteProtocolRule());
									}
									set(
										$current,
										"inner_buffer",
										lv_inner_buffer_6_0,
										"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getComRouteProtocolAccess().getBufferComBufferParserRuleCall_1_1_1_1_1_0());
								}
								lv_buffer_7_0=ruleComBuffer
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComRouteProtocolRule());
									}
									set(
										$current,
										"buffer",
										lv_buffer_7_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
					otherlv_8='>'
					{
						newLeafNode(otherlv_8, grammarAccess.getComRouteProtocolAccess().getGreaterThanSignKeyword_1_1_1_2());
					}
				)
			)?
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getComRouteProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_2_0());
				}
				lv_inner_buffer_9_0=ruleBufferContainerType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComRouteProtocolRule());
					}
					set(
						$current,
						"inner_buffer",
						lv_inner_buffer_9_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getComRouteProtocolAccess().getBufferComBufferParserRuleCall_3_0());
				}
				lv_buffer_10_0=ruleComBuffer
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComRouteProtocolRule());
					}
					set(
						$current,
						"buffer",
						lv_buffer_10_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleConnection
entryRuleConnection returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConnectionRule()); }
	iv_ruleConnection=ruleConnection
	{ $current=$iv_ruleConnection.current; }
	EOF;

// Rule Connection
ruleConnection returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='connector'
			{
				newLeafNode(otherlv_0, grammarAccess.getConnectionAccess().getConnectorKeyword_0_0());
			}
			    |
			otherlv_1='connect'
			{
				newLeafNode(otherlv_1, grammarAccess.getConnectionAccess().getConnectKeyword_0_1());
			}
		)
		otherlv_2='<'
		{
			newLeafNode(otherlv_2, grammarAccess.getConnectionAccess().getLessThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConnectionAccess().getProtocolComProtocolParserRuleCall_2_0());
				}
				lv_protocol_3_0=ruleComProtocol
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConnectionRule());
					}
					set(
						$current,
						"protocol",
						lv_protocol_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComProtocol");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='>'
		{
			newLeafNode(otherlv_4, grammarAccess.getConnectionAccess().getGreaterThanSignKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getConnectionAccess().getNameESIdentifierParserRuleCall_4_0_0());
					}
					lv_name_5_0=ruleESIdentifier
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConnectionRule());
						}
						set(
							$current,
							"name",
							lv_name_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getConnectionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_1_0());
					}
					lv_unrestrictedName_6_0=ruleUnrestrictedName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConnectionRule());
						}
						set(
							$current,
							"unrestrictedName",
							lv_unrestrictedName_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
						afterParserOrEnumRuleCall();
					}
				)
			)?
		)?
		otherlv_7='{'
		{
			newLeafNode(otherlv_7, grammarAccess.getConnectionAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConnectionAccess().getComPointsComPointParserRuleCall_6_0());
				}
				lv_comPoints_8_0=ruleComPoint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConnectionRule());
					}
					add(
						$current,
						"comPoints",
						lv_comPoints_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComPoint");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getConnectionAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleComProtocol
entryRuleComProtocol returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComProtocolRule()); }
	iv_ruleComProtocol=ruleComProtocol
	{ $current=$iv_ruleComProtocol.current; }
	EOF;

// Rule ComProtocol
ruleComProtocol returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getComProtocolAccess().getProtocolComEnvRdvProtocolKindEnumRuleCall_0_0());
				}
				lv_protocol_0_0=ruleComEnvRdvProtocolKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComProtocolRule());
					}
					set(
						$current,
						"protocol",
						lv_protocol_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComEnvRdvProtocolKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getComProtocolAccess().getProtocolComMultiRdvProtocolKindEnumRuleCall_1_0_0());
					}
					lv_protocol_1_0=ruleComMultiRdvProtocolKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComProtocolRule());
						}
						set(
							$current,
							"protocol",
							lv_protocol_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ComMultiRdvProtocolKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2='<'
				{
					newLeafNode(otherlv_2, grammarAccess.getComProtocolAccess().getLessThanSignKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getComProtocolAccess().getCastComCastKingEnumRuleCall_1_1_1_0());
						}
						lv_cast_3_0=ruleComCastKing
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getComProtocolRule());
							}
							set(
								$current,
								"cast",
								lv_cast_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ComCastKing");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_4='>'
				{
					newLeafNode(otherlv_4, grammarAccess.getComProtocolAccess().getGreaterThanSignKeyword_1_1_2());
				}
			)?
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getComProtocolAccess().getProtocolBufferProtocolKindEnumRuleCall_2_0_0());
					}
					lv_protocol_5_0=ruleBufferProtocolKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComProtocolRule());
						}
						set(
							$current,
							"protocol",
							lv_protocol_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BufferProtocolKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					otherlv_6=':'
					{
						newLeafNode(otherlv_6, grammarAccess.getComProtocolAccess().getColonKeyword_2_1_0_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getComProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_2_1_0_1_0_0());
								}
								lv_inner_buffer_7_0=ruleBufferContainerType
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComProtocolRule());
									}
									set(
										$current,
										"inner_buffer",
										lv_inner_buffer_7_0,
										"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getComProtocolAccess().getBufferComBufferParserRuleCall_2_1_0_1_1_0());
								}
								lv_buffer_8_0=ruleComBuffer
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComProtocolRule());
									}
									set(
										$current,
										"buffer",
										lv_buffer_8_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				    |
				(
					otherlv_9='<'
					{
						newLeafNode(otherlv_9, grammarAccess.getComProtocolAccess().getLessThanSignKeyword_2_1_1_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getComProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_2_1_1_1_0_0());
								}
								lv_inner_buffer_10_0=ruleBufferContainerType
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComProtocolRule());
									}
									set(
										$current,
										"inner_buffer",
										lv_inner_buffer_10_0,
										"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getComProtocolAccess().getBufferComBufferParserRuleCall_2_1_1_1_1_0());
								}
								lv_buffer_11_0=ruleComBuffer
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComProtocolRule());
									}
									set(
										$current,
										"buffer",
										lv_buffer_11_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
					otherlv_12='>'
					{
						newLeafNode(otherlv_12, grammarAccess.getComProtocolAccess().getGreaterThanSignKeyword_2_1_1_2());
					}
				)
			)?
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getComProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_3_0());
				}
				lv_inner_buffer_13_0=ruleBufferContainerType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComProtocolRule());
					}
					set(
						$current,
						"inner_buffer",
						lv_inner_buffer_13_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getComProtocolAccess().getBufferComBufferParserRuleCall_4_0());
				}
				lv_buffer_14_0=ruleComBuffer
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComProtocolRule());
					}
					set(
						$current,
						"buffer",
						lv_buffer_14_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getComProtocolAccess().getCastComCastKingEnumRuleCall_5_0());
				}
				lv_cast_15_0=ruleComCastKing
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComProtocolRule());
					}
					set(
						$current,
						"cast",
						lv_cast_15_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComCastKing");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleComPoint
entryRuleComPoint returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComPointRule()); }
	iv_ruleComPoint=ruleComPoint
	{ $current=$iv_ruleComPoint.current; }
	EOF;

// Rule ComPoint
ruleComPoint returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getComPointAccess().getComPointAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getComPointAccess().getDirectionChannelDirectionEnumRuleCall_1_0());
				}
				lv_direction_1_0=ruleChannelDirection
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComPointRule());
					}
					set(
						$current,
						"direction",
						lv_direction_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getComPointAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getComPointAccess().getProtocolComPointProtocolParserRuleCall_2_1_0());
					}
					lv_protocol_3_0=ruleComPointProtocol
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComPointRule());
						}
						set(
							$current,
							"protocol",
							lv_protocol_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ComPointProtocol");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='>'
			{
				newLeafNode(otherlv_4, grammarAccess.getComPointAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getComPointAccess().getPointComElementParserRuleCall_3_0_0_0());
						}
						lv_point_5_0=ruleComElement
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getComPointRule());
							}
							set(
								$current,
								"point",
								lv_point_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ComElement");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_6=';'
				{
					newLeafNode(otherlv_6, grammarAccess.getComPointAccess().getSemicolonKeyword_3_0_1());
				}
			)
			    |
			(
				otherlv_7='{'
				{
					newLeafNode(otherlv_7, grammarAccess.getComPointAccess().getLeftCurlyBracketKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getComPointAccess().getPointsComElementParserRuleCall_3_1_1_0());
						}
						lv_points_8_0=ruleComElement
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getComPointRule());
							}
							add(
								$current,
								"points",
								lv_points_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ComElement");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_9='}'
				{
					newLeafNode(otherlv_9, grammarAccess.getComPointAccess().getRightCurlyBracketKeyword_3_1_2());
				}
			)
		)
	)
;

// Entry rule entryRuleComPointProtocol
entryRuleComPointProtocol returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComPointProtocolRule()); }
	iv_ruleComPointProtocol=ruleComPointProtocol
	{ $current=$iv_ruleComPointProtocol.current; }
	EOF;

// Rule ComPointProtocol
ruleComPointProtocol returns [EObject current=null]
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
						newCompositeNode(grammarAccess.getComPointProtocolAccess().getProtocolBufferProtocolKindEnumRuleCall_0_0_0());
					}
					lv_protocol_0_0=ruleBufferProtocolKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComPointProtocolRule());
						}
						set(
							$current,
							"protocol",
							lv_protocol_0_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BufferProtocolKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					otherlv_1=':'
					{
						newLeafNode(otherlv_1, grammarAccess.getComPointProtocolAccess().getColonKeyword_0_1_0_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getComPointProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_0_1_0_1_0_0());
								}
								lv_inner_buffer_2_0=ruleBufferContainerType
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComPointProtocolRule());
									}
									set(
										$current,
										"inner_buffer",
										lv_inner_buffer_2_0,
										"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getComPointProtocolAccess().getBufferComBufferParserRuleCall_0_1_0_1_1_0());
								}
								lv_buffer_3_0=ruleComBuffer
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComPointProtocolRule());
									}
									set(
										$current,
										"buffer",
										lv_buffer_3_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				    |
				(
					otherlv_4='<'
					{
						newLeafNode(otherlv_4, grammarAccess.getComPointProtocolAccess().getLessThanSignKeyword_0_1_1_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getComPointProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_0_1_1_1_0_0());
								}
								lv_inner_buffer_5_0=ruleBufferContainerType
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComPointProtocolRule());
									}
									set(
										$current,
										"inner_buffer",
										lv_inner_buffer_5_0,
										"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getComPointProtocolAccess().getBufferComBufferParserRuleCall_0_1_1_1_1_0());
								}
								lv_buffer_6_0=ruleComBuffer
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getComPointProtocolRule());
									}
									set(
										$current,
										"buffer",
										lv_buffer_6_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
					otherlv_7='>'
					{
						newLeafNode(otherlv_7, grammarAccess.getComPointProtocolAccess().getGreaterThanSignKeyword_0_1_1_2());
					}
				)
			)?
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getComPointProtocolAccess().getInner_bufferBufferContainerTypeParserRuleCall_1_0());
				}
				lv_inner_buffer_8_0=ruleBufferContainerType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComPointProtocolRule());
					}
					set(
						$current,
						"inner_buffer",
						lv_inner_buffer_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getComPointProtocolAccess().getBufferComBufferParserRuleCall_2_0());
				}
				lv_buffer_9_0=ruleComBuffer
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComPointProtocolRule());
					}
					set(
						$current,
						"buffer",
						lv_buffer_9_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComBuffer");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleComBuffer
entryRuleComBuffer returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComBufferRule()); }
	iv_ruleComBuffer=ruleComBuffer
	{ $current=$iv_ruleComBuffer.current; }
	EOF;

// Rule ComBuffer
ruleComBuffer returns [EObject current=null]
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
						newCompositeNode(grammarAccess.getComBufferAccess().getParentLiteralPureReferenceMachineParserRuleCall_0_0_0());
					}
					lv_parent_0_0=ruleLiteralPureReferenceMachine
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComBufferRule());
						}
						set(
							$current,
							"parent",
							lv_parent_0_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LiteralPureReferenceMachine");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getComBufferAccess().getKindValueDotFieldExpressionKindEnumRuleCall_0_1_0_0());
						}
						lv_kind_1_1=ruleValueDotFieldExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getComBufferRule());
							}
							set(
								$current,
								"kind",
								lv_kind_1_1,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueDotFieldExpressionKind");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getComBufferAccess().getKindValueArrowFieldExpressionKindEnumRuleCall_0_1_0_1());
						}
						lv_kind_1_2=ruleValueArrowFieldExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getComBufferRule());
							}
							set(
								$current,
								"kind",
								lv_kind_1_2,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueArrowFieldExpressionKind");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComBufferRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getComBufferAccess().getElementBufferCrossReference_1_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleComElement
entryRuleComElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComElementRule()); }
	iv_ruleComElement=ruleComElement
	{ $current=$iv_ruleComElement.current; }
	EOF;

// Rule ComElement
ruleComElement returns [EObject current=null]
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
						newCompositeNode(grammarAccess.getComElementAccess().getParentLiteralPureReferenceMachineParserRuleCall_0_0_0());
					}
					lv_parent_0_0=ruleLiteralPureReferenceMachine
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComElementRule());
						}
						set(
							$current,
							"parent",
							lv_parent_0_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LiteralPureReferenceMachine");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getComElementAccess().getKindValueDotFieldExpressionKindEnumRuleCall_0_1_0_0());
						}
						lv_kind_1_1=ruleValueDotFieldExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getComElementRule());
							}
							set(
								$current,
								"kind",
								lv_kind_1_1,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueDotFieldExpressionKind");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getComElementAccess().getKindValueArrowFieldExpressionKindEnumRuleCall_0_1_0_1());
						}
						lv_kind_1_2=ruleValueArrowFieldExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getComElementRule());
							}
							set(
								$current,
								"kind",
								lv_kind_1_2,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueArrowFieldExpressionKind");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComElementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getComElementAccess().getElementPortCrossReference_1_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralPureReferenceMachine
entryRuleLiteralPureReferenceMachine returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralPureReferenceMachineRule()); }
	iv_ruleLiteralPureReferenceMachine=ruleLiteralPureReferenceMachine
	{ $current=$iv_ruleLiteralPureReferenceMachine.current; }
	EOF;

// Rule LiteralPureReferenceMachine
ruleLiteralPureReferenceMachine returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getLiteralPureReferenceMachineAccess().getLiteralReferenceElementAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralPureReferenceMachineRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getLiteralPureReferenceMachineAccess().getValueMachineCrossReference_0_1_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralPureReferenceMachineAccess().getLiteralReferenceMachineContextParserRuleCall_1());
		}
		this_LiteralReferenceMachineContext_2=ruleLiteralReferenceMachineContext
		{
			$current = $this_LiteralReferenceMachineContext_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTypeDefinition
entryRuleTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeDefinitionRule()); }
	iv_ruleTypeDefinition=ruleTypeDefinition
	{ $current=$iv_ruleTypeDefinition.current; }
	EOF;

// Rule TypeDefinition
ruleTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getEnumerationTypeDefinitionParserRuleCall_0());
		}
		this_EnumerationTypeDefinition_0=ruleEnumerationTypeDefinition
		{
			$current = $this_EnumerationTypeDefinition_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getStructureTypeDefinitionParserRuleCall_1());
		}
		this_StructureTypeDefinition_1=ruleStructureTypeDefinition
		{
			$current = $this_StructureTypeDefinition_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getUnionTypeDefinitionParserRuleCall_2());
		}
		this_UnionTypeDefinition_2=ruleUnionTypeDefinition
		{
			$current = $this_UnionTypeDefinition_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getChoiceTypeDefinitionParserRuleCall_3());
		}
		this_ChoiceTypeDefinition_3=ruleChoiceTypeDefinition
		{
			$current = $this_ChoiceTypeDefinition_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getIntervalTypeDefinitionParserRuleCall_4());
		}
		this_IntervalTypeDefinition_4=ruleIntervalTypeDefinition
		{
			$current = $this_IntervalTypeDefinition_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getCollectionTypeDefinitionParserRuleCall_5());
		}
		this_CollectionTypeDefinition_5=ruleCollectionTypeDefinition
		{
			$current = $this_CollectionTypeDefinition_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getOtherDataTypeDefinitionParserRuleCall_6());
		}
		this_OtherDataTypeDefinition_6=ruleOtherDataTypeDefinition
		{
			$current = $this_OtherDataTypeDefinition_6.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleDataTypeMultiplicity
entryRuleDataTypeMultiplicity returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDataTypeMultiplicityRule()); }
	iv_ruleDataTypeMultiplicity=ruleDataTypeMultiplicity
	{ $current=$iv_ruleDataTypeMultiplicity.current; }
	EOF;

// Rule DataTypeMultiplicity
ruleDataTypeMultiplicity returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getDataTypeMultiplicityAccess().getLiteralIntegerExpressionParserRuleCall_0());
		}
		this_LiteralIntegerExpression_0=ruleLiteralIntegerExpression
		{
			$current = $this_LiteralIntegerExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getDataTypeMultiplicityAccess().getLiteralReferenceElementParserRuleCall_1());
		}
		this_LiteralReferenceElement_1=ruleLiteralReferenceElement
		{
			$current = $this_LiteralReferenceElement_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleDataTypeReference
entryRuleDataTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDataTypeReferenceRule()); }
	iv_ruleDataTypeReference=ruleDataTypeReference
	{ $current=$iv_ruleDataTypeReference.current; }
	EOF;

// Rule DataTypeReference
ruleDataTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getDataTypeReferenceAccess().getSimpleDataTypeParserRuleCall_0_0());
			}
			this_SimpleDataType_0=ruleSimpleDataType
			{
				$current = $this_SimpleDataType_0.current;
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getDataTypeReferenceAccess().getDataTypeReferenceSupportAction_0_1_0(),
							$current);
					}
				)
				otherlv_2='['
				{
					newLeafNode(otherlv_2, grammarAccess.getDataTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_1());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getDataTypeReferenceAccess().getMultiplicityDataTypeMultiplicityParserRuleCall_0_1_2_0());
						}
						lv_multiplicity_3_0=ruleDataTypeMultiplicity
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getDataTypeReferenceRule());
							}
							set(
								$current,
								"multiplicity",
								lv_multiplicity_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.DataTypeMultiplicity");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_4=']'
				{
					newLeafNode(otherlv_4, grammarAccess.getDataTypeReferenceAccess().getRightSquareBracketKeyword_0_1_3());
				}
			)?
		)
		    |
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getDataTypeReferenceAccess().getDataTypeReferenceAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getDataTypeReferenceRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getDataTypeReferenceAccess().getTyperefDataTypeCrossReference_1_1_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_7='['
				{
					newLeafNode(otherlv_7, grammarAccess.getDataTypeReferenceAccess().getLeftSquareBracketKeyword_1_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getDataTypeReferenceAccess().getMultiplicityDataTypeMultiplicityParserRuleCall_1_2_1_0());
						}
						lv_multiplicity_8_0=ruleDataTypeMultiplicity
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getDataTypeReferenceRule());
							}
							set(
								$current,
								"multiplicity",
								lv_multiplicity_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.DataTypeMultiplicity");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_9=']'
				{
					newLeafNode(otherlv_9, grammarAccess.getDataTypeReferenceAccess().getRightSquareBracketKeyword_1_2_2());
				}
			)?
		)
	)
;

// Entry rule entryRuleOtherDataTypeDefinition
entryRuleOtherDataTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOtherDataTypeDefinitionRule()); }
	iv_ruleOtherDataTypeDefinition=ruleOtherDataTypeDefinition
	{ $current=$iv_ruleOtherDataTypeDefinition.current; }
	EOF;

// Rule OtherDataTypeDefinition
ruleOtherDataTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getOtherDataTypeDefinitionAccess().getDataTypeReferenceAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherDataTypeDefinitionAccess().getVisibilityVisibilityKindEnumRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='type'
		{
			newLeafNode(otherlv_2, grammarAccess.getOtherDataTypeDefinitionAccess().getTypeKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherDataTypeDefinitionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherDataTypeDefinitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getOtherDataTypeDefinitionAccess().getSupportPrimitiveTypeParserRuleCall_5_0_0_0());
						}
						lv_support_5_0=rulePrimitiveType
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionRule());
							}
							set(
								$current,
								"support",
								lv_support_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveType");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_6='['
					{
						newLeafNode(otherlv_6, grammarAccess.getOtherDataTypeDefinitionAccess().getLeftSquareBracketKeyword_5_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getOtherDataTypeDefinitionAccess().getMultiplicityDataTypeMultiplicityParserRuleCall_5_0_1_1_0());
							}
							lv_multiplicity_7_0=ruleDataTypeMultiplicity
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionRule());
								}
								set(
									$current,
									"multiplicity",
									lv_multiplicity_7_0,
									"org.eclipse.efm.formalml.xtext.FormalML.DataTypeMultiplicity");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_8=']'
					{
						newLeafNode(otherlv_8, grammarAccess.getOtherDataTypeDefinitionAccess().getRightSquareBracketKeyword_5_0_1_2());
					}
				)?
			)
			    |
			(
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOtherDataTypeDefinitionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getOtherDataTypeDefinitionAccess().getTyperefDataTypeCrossReference_5_1_0_0());
						}
						ruleESUfid
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_10='['
					{
						newLeafNode(otherlv_10, grammarAccess.getOtherDataTypeDefinitionAccess().getLeftSquareBracketKeyword_5_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getOtherDataTypeDefinitionAccess().getMultiplicityDataTypeMultiplicityParserRuleCall_5_1_1_1_0());
							}
							lv_multiplicity_11_0=ruleDataTypeMultiplicity
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionRule());
								}
								set(
									$current,
									"multiplicity",
									lv_multiplicity_11_0,
									"org.eclipse.efm.formalml.xtext.FormalML.DataTypeMultiplicity");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_12=']'
					{
						newLeafNode(otherlv_12, grammarAccess.getOtherDataTypeDefinitionAccess().getRightSquareBracketKeyword_5_1_1_2());
					}
				)?
			)
		)
		(
			(
				lv_typedef_13_0=';'
				{
					newLeafNode(lv_typedef_13_0, grammarAccess.getOtherDataTypeDefinitionAccess().getTypedefSemicolonKeyword_6_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOtherDataTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, ";");
				}
			)
		)
	)
;

// Entry rule entryRuleOtherDataTypeDefinitionImpl
entryRuleOtherDataTypeDefinitionImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOtherDataTypeDefinitionImplRule()); }
	iv_ruleOtherDataTypeDefinitionImpl=ruleOtherDataTypeDefinitionImpl
	{ $current=$iv_ruleOtherDataTypeDefinitionImpl.current; }
	EOF;

// Rule OtherDataTypeDefinitionImpl
ruleOtherDataTypeDefinitionImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getOtherDataTypeDefinitionImplAccess().getDataTypeReferenceAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherDataTypeDefinitionImplAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionImplRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherDataTypeDefinitionImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getOtherDataTypeDefinitionImplAccess().getSupportPrimitiveTypeParserRuleCall_3_0_0_0());
						}
						lv_support_3_0=rulePrimitiveType
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionImplRule());
							}
							set(
								$current,
								"support",
								lv_support_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveType");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4='['
					{
						newLeafNode(otherlv_4, grammarAccess.getOtherDataTypeDefinitionImplAccess().getLeftSquareBracketKeyword_3_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getOtherDataTypeDefinitionImplAccess().getMultiplicityDataTypeMultiplicityParserRuleCall_3_0_1_1_0());
							}
							lv_multiplicity_5_0=ruleDataTypeMultiplicity
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionImplRule());
								}
								set(
									$current,
									"multiplicity",
									lv_multiplicity_5_0,
									"org.eclipse.efm.formalml.xtext.FormalML.DataTypeMultiplicity");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_6=']'
					{
						newLeafNode(otherlv_6, grammarAccess.getOtherDataTypeDefinitionImplAccess().getRightSquareBracketKeyword_3_0_1_2());
					}
				)?
			)
			    |
			(
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOtherDataTypeDefinitionImplRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getOtherDataTypeDefinitionImplAccess().getTyperefDataTypeCrossReference_3_1_0_0());
						}
						ruleESUfid
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_8='['
					{
						newLeafNode(otherlv_8, grammarAccess.getOtherDataTypeDefinitionImplAccess().getLeftSquareBracketKeyword_3_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getOtherDataTypeDefinitionImplAccess().getMultiplicityDataTypeMultiplicityParserRuleCall_3_1_1_1_0());
							}
							lv_multiplicity_9_0=ruleDataTypeMultiplicity
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionImplRule());
								}
								set(
									$current,
									"multiplicity",
									lv_multiplicity_9_0,
									"org.eclipse.efm.formalml.xtext.FormalML.DataTypeMultiplicity");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_10=']'
					{
						newLeafNode(otherlv_10, grammarAccess.getOtherDataTypeDefinitionImplAccess().getRightSquareBracketKeyword_3_1_1_2());
					}
				)?
			)
		)
		(
			(
				lv_typedef_11_0=';'
				{
					newLeafNode(lv_typedef_11_0, grammarAccess.getOtherDataTypeDefinitionImplAccess().getTypedefSemicolonKeyword_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOtherDataTypeDefinitionImplRule());
					}
					setWithLastConsumed($current, "typedef", true, ";");
				}
			)
		)
	)
;

// Entry rule entryRuleDataType
entryRuleDataType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDataTypeRule()); }
	iv_ruleDataType=ruleDataType
	{ $current=$iv_ruleDataType.current; }
	EOF;

// Rule DataType
ruleDataType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getDataTypeAccess().getDataTypeReferenceParserRuleCall_0());
		}
		this_DataTypeReference_0=ruleDataTypeReference
		{
			$current = $this_DataTypeReference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getDataTypeAccess().getStructuredDataTypeParserRuleCall_1());
		}
		this_StructuredDataType_1=ruleStructuredDataType
		{
			$current = $this_StructuredDataType_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSimpleDataType
entryRuleSimpleDataType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSimpleDataTypeRule()); }
	iv_ruleSimpleDataType=ruleSimpleDataType
	{ $current=$iv_ruleSimpleDataType.current; }
	EOF;

// Rule SimpleDataType
ruleSimpleDataType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getSimpleDataTypeAccess().getPrimitiveTypeParserRuleCall_0());
		}
		this_PrimitiveType_0=rulePrimitiveType
		{
			$current = $this_PrimitiveType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getSimpleDataTypeAccess().getIntervalTypeParserRuleCall_1());
		}
		this_IntervalType_1=ruleIntervalType
		{
			$current = $this_IntervalType_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getSimpleDataTypeAccess().getCollectionTypeParserRuleCall_2());
		}
		this_CollectionType_2=ruleCollectionType
		{
			$current = $this_CollectionType_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleStructuredDataType
entryRuleStructuredDataType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructuredDataTypeRule()); }
	iv_ruleStructuredDataType=ruleStructuredDataType
	{ $current=$iv_ruleStructuredDataType.current; }
	EOF;

// Rule StructuredDataType
ruleStructuredDataType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStructuredDataTypeAccess().getEnumerationTypeParserRuleCall_0());
		}
		this_EnumerationType_0=ruleEnumerationType
		{
			$current = $this_EnumerationType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStructuredDataTypeAccess().getStructureTypeParserRuleCall_1());
		}
		this_StructureType_1=ruleStructureType
		{
			$current = $this_StructureType_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStructuredDataTypeAccess().getUnionTypeParserRuleCall_2());
		}
		this_UnionType_2=ruleUnionType
		{
			$current = $this_UnionType_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStructuredDataTypeAccess().getChoiceTypeParserRuleCall_3());
		}
		this_ChoiceType_3=ruleChoiceType
		{
			$current = $this_ChoiceType_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePrimitiveType
entryRulePrimitiveType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeRule()); }
	iv_rulePrimitiveType=rulePrimitiveType
	{ $current=$iv_rulePrimitiveType.current; }
	EOF;

// Rule PrimitiveType
rulePrimitiveType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getPrimitiveNumberTypeParserRuleCall_0());
		}
		this_PrimitiveNumberType_0=rulePrimitiveNumberType
		{
			$current = $this_PrimitiveNumberType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getOtherPrimitiveTypeParserRuleCall_1());
		}
		this_OtherPrimitiveType_1=ruleOtherPrimitiveType
		{
			$current = $this_OtherPrimitiveType_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePrimitiveNumberType
entryRulePrimitiveNumberType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveNumberTypeRule()); }
	iv_rulePrimitiveNumberType=rulePrimitiveNumberType
	{ $current=$iv_rulePrimitiveNumberType.current; }
	EOF;

// Rule PrimitiveNumberType
rulePrimitiveNumberType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveNumberTypeAccess().getPrimitiveIntegerTypeParserRuleCall_0());
		}
		this_PrimitiveIntegerType_0=rulePrimitiveIntegerType
		{
			$current = $this_PrimitiveIntegerType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveNumberTypeAccess().getPrimitiveRationalTypeParserRuleCall_1());
		}
		this_PrimitiveRationalType_1=rulePrimitiveRationalType
		{
			$current = $this_PrimitiveRationalType_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveNumberTypeAccess().getPrimitiveFloatTypeParserRuleCall_2());
		}
		this_PrimitiveFloatType_2=rulePrimitiveFloatType
		{
			$current = $this_PrimitiveFloatType_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveNumberTypeAccess().getPrimitiveRealTypeParserRuleCall_3());
		}
		this_PrimitiveRealType_3=rulePrimitiveRealType
		{
			$current = $this_PrimitiveRealType_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveNumberTypeAccess().getPrimitiveTimeTypeParserRuleCall_4());
		}
		this_PrimitiveTimeType_4=rulePrimitiveTimeType
		{
			$current = $this_PrimitiveTimeType_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePrimitiveIntegerType
entryRulePrimitiveIntegerType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveIntegerTypeRule()); }
	iv_rulePrimitiveIntegerType=rulePrimitiveIntegerType
	{ $current=$iv_rulePrimitiveIntegerType.current; }
	EOF;

// Rule PrimitiveIntegerType
rulePrimitiveIntegerType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrimitiveIntegerTypeAccess().getPrimitiveIntegerTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPrimitiveIntegerTypeAccess().getSignPrimitiveNumberSignEnumRuleCall_1_0());
				}
				lv_sign_1_0=rulePrimitiveNumberSign
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPrimitiveIntegerTypeRule());
					}
					set(
						$current,
						"sign",
						lv_sign_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveNumberSign");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_2='integer'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimitiveIntegerTypeAccess().getIntegerKeyword_2_0());
			}
			    |
			otherlv_3='uinteger'
			{
				newLeafNode(otherlv_3, grammarAccess.getPrimitiveIntegerTypeAccess().getUintegerKeyword_2_1());
			}
			    |
			otherlv_4='int'
			{
				newLeafNode(otherlv_4, grammarAccess.getPrimitiveIntegerTypeAccess().getIntKeyword_2_2());
			}
			    |
			otherlv_5='uint'
			{
				newLeafNode(otherlv_5, grammarAccess.getPrimitiveIntegerTypeAccess().getUintKeyword_2_3());
			}
		)
		(
			(
				otherlv_6=':'
				{
					newLeafNode(otherlv_6, grammarAccess.getPrimitiveIntegerTypeAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveIntegerTypeAccess().getSizeEIntParserRuleCall_3_0_1_0());
						}
						lv_size_7_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveIntegerTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_7_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_8='<'
				{
					newLeafNode(otherlv_8, grammarAccess.getPrimitiveIntegerTypeAccess().getLessThanSignKeyword_3_1_0());
				}
				(
					otherlv_9='size:'
					{
						newLeafNode(otherlv_9, grammarAccess.getPrimitiveIntegerTypeAccess().getSizeKeyword_3_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveIntegerTypeAccess().getSizeEIntParserRuleCall_3_1_2_0());
						}
						lv_size_10_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveIntegerTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_11='>'
				{
					newLeafNode(otherlv_11, grammarAccess.getPrimitiveIntegerTypeAccess().getGreaterThanSignKeyword_3_1_3());
				}
			)
		)?
	)
;

// Entry rule entryRulePrimitiveRationalType
entryRulePrimitiveRationalType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveRationalTypeRule()); }
	iv_rulePrimitiveRationalType=rulePrimitiveRationalType
	{ $current=$iv_rulePrimitiveRationalType.current; }
	EOF;

// Rule PrimitiveRationalType
rulePrimitiveRationalType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrimitiveRationalTypeAccess().getPrimitiveRationalTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPrimitiveRationalTypeAccess().getSignPrimitiveNumberSignEnumRuleCall_1_0());
				}
				lv_sign_1_0=rulePrimitiveNumberSign
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPrimitiveRationalTypeRule());
					}
					set(
						$current,
						"sign",
						lv_sign_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveNumberSign");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_2='rational'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimitiveRationalTypeAccess().getRationalKeyword_2_0());
			}
			    |
			otherlv_3='urational'
			{
				newLeafNode(otherlv_3, grammarAccess.getPrimitiveRationalTypeAccess().getUrationalKeyword_2_1());
			}
			    |
			otherlv_4='rat'
			{
				newLeafNode(otherlv_4, grammarAccess.getPrimitiveRationalTypeAccess().getRatKeyword_2_2());
			}
			    |
			otherlv_5='urat'
			{
				newLeafNode(otherlv_5, grammarAccess.getPrimitiveRationalTypeAccess().getUratKeyword_2_3());
			}
		)
		(
			(
				otherlv_6=':'
				{
					newLeafNode(otherlv_6, grammarAccess.getPrimitiveRationalTypeAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveRationalTypeAccess().getSizeEIntParserRuleCall_3_0_1_0());
						}
						lv_size_7_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveRationalTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_7_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_8='<'
				{
					newLeafNode(otherlv_8, grammarAccess.getPrimitiveRationalTypeAccess().getLessThanSignKeyword_3_1_0());
				}
				(
					otherlv_9='size:'
					{
						newLeafNode(otherlv_9, grammarAccess.getPrimitiveRationalTypeAccess().getSizeKeyword_3_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveRationalTypeAccess().getSizeEIntParserRuleCall_3_1_2_0());
						}
						lv_size_10_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveRationalTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_11='>'
				{
					newLeafNode(otherlv_11, grammarAccess.getPrimitiveRationalTypeAccess().getGreaterThanSignKeyword_3_1_3());
				}
			)
		)?
	)
;

// Entry rule entryRulePrimitiveFloatType
entryRulePrimitiveFloatType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveFloatTypeRule()); }
	iv_rulePrimitiveFloatType=rulePrimitiveFloatType
	{ $current=$iv_rulePrimitiveFloatType.current; }
	EOF;

// Rule PrimitiveFloatType
rulePrimitiveFloatType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrimitiveFloatTypeAccess().getPrimitiveFloatTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPrimitiveFloatTypeAccess().getSignPrimitiveNumberSignEnumRuleCall_1_0());
				}
				lv_sign_1_0=rulePrimitiveNumberSign
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPrimitiveFloatTypeRule());
					}
					set(
						$current,
						"sign",
						lv_sign_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveNumberSign");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_2='float'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimitiveFloatTypeAccess().getFloatKeyword_2_0());
			}
			    |
			otherlv_3='ufloat'
			{
				newLeafNode(otherlv_3, grammarAccess.getPrimitiveFloatTypeAccess().getUfloatKeyword_2_1());
			}
			    |
			otherlv_4='double'
			{
				newLeafNode(otherlv_4, grammarAccess.getPrimitiveFloatTypeAccess().getDoubleKeyword_2_2());
			}
			    |
			otherlv_5='udouble'
			{
				newLeafNode(otherlv_5, grammarAccess.getPrimitiveFloatTypeAccess().getUdoubleKeyword_2_3());
			}
		)
		(
			(
				otherlv_6=':'
				{
					newLeafNode(otherlv_6, grammarAccess.getPrimitiveFloatTypeAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveFloatTypeAccess().getSizeEIntParserRuleCall_3_0_1_0());
						}
						lv_size_7_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveFloatTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_7_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_8='<'
				{
					newLeafNode(otherlv_8, grammarAccess.getPrimitiveFloatTypeAccess().getLessThanSignKeyword_3_1_0());
				}
				(
					otherlv_9='size:'
					{
						newLeafNode(otherlv_9, grammarAccess.getPrimitiveFloatTypeAccess().getSizeKeyword_3_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveFloatTypeAccess().getSizeEIntParserRuleCall_3_1_2_0());
						}
						lv_size_10_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveFloatTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_11='>'
				{
					newLeafNode(otherlv_11, grammarAccess.getPrimitiveFloatTypeAccess().getGreaterThanSignKeyword_3_1_3());
				}
			)
		)?
	)
;

// Entry rule entryRulePrimitiveRealType
entryRulePrimitiveRealType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveRealTypeRule()); }
	iv_rulePrimitiveRealType=rulePrimitiveRealType
	{ $current=$iv_rulePrimitiveRealType.current; }
	EOF;

// Rule PrimitiveRealType
rulePrimitiveRealType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrimitiveRealTypeAccess().getPrimitiveRealTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPrimitiveRealTypeAccess().getSignPrimitiveNumberSignEnumRuleCall_1_0());
				}
				lv_sign_1_0=rulePrimitiveNumberSign
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPrimitiveRealTypeRule());
					}
					set(
						$current,
						"sign",
						lv_sign_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveNumberSign");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_2='real'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimitiveRealTypeAccess().getRealKeyword_2_0());
			}
			    |
			otherlv_3='ureal'
			{
				newLeafNode(otherlv_3, grammarAccess.getPrimitiveRealTypeAccess().getUrealKeyword_2_1());
			}
		)
		(
			(
				otherlv_4=':'
				{
					newLeafNode(otherlv_4, grammarAccess.getPrimitiveRealTypeAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveRealTypeAccess().getSizeEIntParserRuleCall_3_0_1_0());
						}
						lv_size_5_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveRealTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_6='<'
				{
					newLeafNode(otherlv_6, grammarAccess.getPrimitiveRealTypeAccess().getLessThanSignKeyword_3_1_0());
				}
				(
					otherlv_7='size:'
					{
						newLeafNode(otherlv_7, grammarAccess.getPrimitiveRealTypeAccess().getSizeKeyword_3_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveRealTypeAccess().getSizeEIntParserRuleCall_3_1_2_0());
						}
						lv_size_8_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveRealTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_9='>'
				{
					newLeafNode(otherlv_9, grammarAccess.getPrimitiveRealTypeAccess().getGreaterThanSignKeyword_3_1_3());
				}
			)
		)?
	)
;

// Entry rule entryRulePrimitiveTimeType
entryRulePrimitiveTimeType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveTimeTypeRule()); }
	iv_rulePrimitiveTimeType=rulePrimitiveTimeType
	{ $current=$iv_rulePrimitiveTimeType.current; }
	EOF;

// Rule PrimitiveTimeType
rulePrimitiveTimeType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getPrimitiveTimeTypeAccess().getPrimitiveTimeTypeAction_0_0(),
						$current);
				}
			)
			otherlv_1='time'
			{
				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTimeTypeAccess().getTimeKeyword_0_1());
			}
			(
				(
					otherlv_2='<'
					{
						newLeafNode(otherlv_2, grammarAccess.getPrimitiveTimeTypeAccess().getLessThanSignKeyword_0_2_0_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimitiveTimeTypeAccess().getSupportPrimitiveTimeNumberTypeParserRuleCall_0_2_0_1_0());
							}
							lv_support_3_0=rulePrimitiveTimeNumberType
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimitiveTimeTypeRule());
								}
								set(
									$current,
									"support",
									lv_support_3_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveTimeNumberType");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_4='>'
					{
						newLeafNode(otherlv_4, grammarAccess.getPrimitiveTimeTypeAccess().getGreaterThanSignKeyword_0_2_0_2());
					}
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveTimeTypeAccess().getSupportPrimitiveTimeNumberTypeParserRuleCall_0_2_1_0());
						}
						lv_support_5_0=rulePrimitiveTimeNumberType
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveTimeTypeRule());
							}
							set(
								$current,
								"support",
								lv_support_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveTimeNumberType");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
		    |
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getPrimitiveTimeTypeAccess().getPrimitiveTimeTypeAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_clock_7_0='clock'
					{
						newLeafNode(lv_clock_7_0, grammarAccess.getPrimitiveTimeTypeAccess().getClockClockKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveTimeTypeRule());
						}
						setWithLastConsumed($current, "clock", true, "clock");
					}
				)
			)
			(
				(
					otherlv_8='<'
					{
						newLeafNode(otherlv_8, grammarAccess.getPrimitiveTimeTypeAccess().getLessThanSignKeyword_1_2_0_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimitiveTimeTypeAccess().getSupportPrimitiveTimeNumberTypeParserRuleCall_1_2_0_1_0());
							}
							lv_support_9_0=rulePrimitiveTimeNumberType
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimitiveTimeTypeRule());
								}
								set(
									$current,
									"support",
									lv_support_9_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveTimeNumberType");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_10='>'
					{
						newLeafNode(otherlv_10, grammarAccess.getPrimitiveTimeTypeAccess().getGreaterThanSignKeyword_1_2_0_2());
					}
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveTimeTypeAccess().getSupportPrimitiveTimeNumberTypeParserRuleCall_1_2_1_0());
						}
						lv_support_11_0=rulePrimitiveTimeNumberType
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveTimeTypeRule());
							}
							set(
								$current,
								"support",
								lv_support_11_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveTimeNumberType");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
	)
;

// Entry rule entryRulePrimitiveTimeNumberType
entryRulePrimitiveTimeNumberType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveTimeNumberTypeRule()); }
	iv_rulePrimitiveTimeNumberType=rulePrimitiveTimeNumberType
	{ $current=$iv_rulePrimitiveTimeNumberType.current; }
	EOF;

// Rule PrimitiveTimeNumberType
rulePrimitiveTimeNumberType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveTimeNumberTypeAccess().getPrimitiveIntegerTypeParserRuleCall_0());
		}
		this_PrimitiveIntegerType_0=rulePrimitiveIntegerType
		{
			$current = $this_PrimitiveIntegerType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveTimeNumberTypeAccess().getPrimitiveRationalTypeParserRuleCall_1());
		}
		this_PrimitiveRationalType_1=rulePrimitiveRationalType
		{
			$current = $this_PrimitiveRationalType_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveTimeNumberTypeAccess().getPrimitiveFloatTypeParserRuleCall_2());
		}
		this_PrimitiveFloatType_2=rulePrimitiveFloatType
		{
			$current = $this_PrimitiveFloatType_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimitiveTimeNumberTypeAccess().getPrimitiveRealTypeParserRuleCall_3());
		}
		this_PrimitiveRealType_3=rulePrimitiveRealType
		{
			$current = $this_PrimitiveRealType_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleOtherPrimitiveType
entryRuleOtherPrimitiveType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOtherPrimitiveTypeRule()); }
	iv_ruleOtherPrimitiveType=ruleOtherPrimitiveType
	{ $current=$iv_ruleOtherPrimitiveType.current; }
	EOF;

// Rule OtherPrimitiveType
ruleOtherPrimitiveType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getOtherPrimitiveTypeAccess().getPrimitiveBooleanTypeParserRuleCall_0());
		}
		this_PrimitiveBooleanType_0=rulePrimitiveBooleanType
		{
			$current = $this_PrimitiveBooleanType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getOtherPrimitiveTypeAccess().getPrimitiveCharacterTypeParserRuleCall_1());
		}
		this_PrimitiveCharacterType_1=rulePrimitiveCharacterType
		{
			$current = $this_PrimitiveCharacterType_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getOtherPrimitiveTypeAccess().getPrimitiveStringTypeParserRuleCall_2());
		}
		this_PrimitiveStringType_2=rulePrimitiveStringType
		{
			$current = $this_PrimitiveStringType_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getOtherPrimitiveTypeAccess().getPrimitiveInstanceTypeParserRuleCall_3());
		}
		this_PrimitiveInstanceType_3=rulePrimitiveInstanceType
		{
			$current = $this_PrimitiveInstanceType_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePrimitiveBooleanType
entryRulePrimitiveBooleanType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveBooleanTypeRule()); }
	iv_rulePrimitiveBooleanType=rulePrimitiveBooleanType
	{ $current=$iv_rulePrimitiveBooleanType.current; }
	EOF;

// Rule PrimitiveBooleanType
rulePrimitiveBooleanType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrimitiveBooleanTypeAccess().getPrimitiveBooleanTypeAction_0(),
					$current);
			}
		)
		(
			otherlv_1='boolean'
			{
				newLeafNode(otherlv_1, grammarAccess.getPrimitiveBooleanTypeAccess().getBooleanKeyword_1_0());
			}
			    |
			otherlv_2='bool'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimitiveBooleanTypeAccess().getBoolKeyword_1_1());
			}
		)
	)
;

// Entry rule entryRulePrimitiveCharacterType
entryRulePrimitiveCharacterType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveCharacterTypeRule()); }
	iv_rulePrimitiveCharacterType=rulePrimitiveCharacterType
	{ $current=$iv_rulePrimitiveCharacterType.current; }
	EOF;

// Rule PrimitiveCharacterType
rulePrimitiveCharacterType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrimitiveCharacterTypeAccess().getPrimitiveCharacterTypeAction_0(),
					$current);
			}
		)
		otherlv_1='char'
		{
			newLeafNode(otherlv_1, grammarAccess.getPrimitiveCharacterTypeAccess().getCharKeyword_1());
		}
	)
;

// Entry rule entryRulePrimitiveStringType
entryRulePrimitiveStringType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveStringTypeRule()); }
	iv_rulePrimitiveStringType=rulePrimitiveStringType
	{ $current=$iv_rulePrimitiveStringType.current; }
	EOF;

// Rule PrimitiveStringType
rulePrimitiveStringType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrimitiveStringTypeAccess().getPrimitiveStringTypeAction_0(),
					$current);
			}
		)
		otherlv_1='string'
		{
			newLeafNode(otherlv_1, grammarAccess.getPrimitiveStringTypeAccess().getStringKeyword_1());
		}
		(
			(
				otherlv_2=':'
				{
					newLeafNode(otherlv_2, grammarAccess.getPrimitiveStringTypeAccess().getColonKeyword_2_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveStringTypeAccess().getSizeEIntParserRuleCall_2_0_1_0());
						}
						lv_size_3_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveStringTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_4='<'
				{
					newLeafNode(otherlv_4, grammarAccess.getPrimitiveStringTypeAccess().getLessThanSignKeyword_2_1_0());
				}
				(
					otherlv_5='size:'
					{
						newLeafNode(otherlv_5, grammarAccess.getPrimitiveStringTypeAccess().getSizeKeyword_2_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveStringTypeAccess().getSizeEIntParserRuleCall_2_1_2_0());
						}
						lv_size_6_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveStringTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_7='>'
				{
					newLeafNode(otherlv_7, grammarAccess.getPrimitiveStringTypeAccess().getGreaterThanSignKeyword_2_1_3());
				}
			)
		)?
	)
;

// Entry rule entryRulePrimitiveInstanceType
entryRulePrimitiveInstanceType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveInstanceTypeRule()); }
	iv_rulePrimitiveInstanceType=rulePrimitiveInstanceType
	{ $current=$iv_rulePrimitiveInstanceType.current; }
	EOF;

// Rule PrimitiveInstanceType
rulePrimitiveInstanceType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrimitiveInstanceTypeAccess().getPrimitiveInstanceTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPrimitiveInstanceTypeAccess().getExpectedPrimitiveInstanceKindEnumRuleCall_1_0());
				}
				lv_expected_1_0=rulePrimitiveInstanceKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPrimitiveInstanceTypeRule());
					}
					set(
						$current,
						"expected",
						lv_expected_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveInstanceKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimitiveInstanceTypeAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveInstanceTypeRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getPrimitiveInstanceTypeAccess().getModelNamedElementCrossReference_2_1_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='>'
			{
				newLeafNode(otherlv_4, grammarAccess.getPrimitiveInstanceTypeAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
	)
;

// Entry rule entryRuleIntervalType
entryRuleIntervalType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntervalTypeRule()); }
	iv_ruleIntervalType=ruleIntervalType
	{ $current=$iv_ruleIntervalType.current; }
	EOF;

// Rule IntervalType
ruleIntervalType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getIntervalTypeAccess().getIntervalTypeAction_0(),
					$current);
			}
		)
		otherlv_1='interval'
		{
			newLeafNode(otherlv_1, grammarAccess.getIntervalTypeAccess().getIntervalKeyword_1());
		}
		otherlv_2='<'
		{
			newLeafNode(otherlv_2, grammarAccess.getIntervalTypeAccess().getLessThanSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeAccess().getSupportPrimitiveNumberTypeParserRuleCall_3_0());
				}
				lv_support_3_0=rulePrimitiveNumberType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeRule());
					}
					set(
						$current,
						"support",
						lv_support_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveNumberType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					lv_lopen_4_0=']'
					{
						newLeafNode(lv_lopen_4_0, grammarAccess.getIntervalTypeAccess().getLopenRightSquareBracketKeyword_4_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getIntervalTypeRule());
						}
						setWithLastConsumed($current, "lopen", true, "]");
					}
				)
			)
			    |
			otherlv_5='['
			{
				newLeafNode(otherlv_5, grammarAccess.getIntervalTypeAccess().getLeftSquareBracketKeyword_4_1());
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeAccess().getInfimumExpressionParserRuleCall_5_0());
				}
				lv_infimum_6_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeRule());
					}
					set(
						$current,
						"infimum",
						lv_infimum_6_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7=','
		{
			newLeafNode(otherlv_7, grammarAccess.getIntervalTypeAccess().getCommaKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeAccess().getSupremumExpressionParserRuleCall_7_0());
				}
				lv_supremum_8_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeRule());
					}
					set(
						$current,
						"supremum",
						lv_supremum_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_9=']'
			{
				newLeafNode(otherlv_9, grammarAccess.getIntervalTypeAccess().getRightSquareBracketKeyword_8_0());
			}
			    |
			(
				(
					lv_ropen_10_0='['
					{
						newLeafNode(lv_ropen_10_0, grammarAccess.getIntervalTypeAccess().getRopenLeftSquareBracketKeyword_8_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getIntervalTypeRule());
						}
						setWithLastConsumed($current, "ropen", true, "[");
					}
				)
			)
		)
		otherlv_11='>'
		{
			newLeafNode(otherlv_11, grammarAccess.getIntervalTypeAccess().getGreaterThanSignKeyword_9());
		}
	)
;

// Entry rule entryRuleIntervalTypeDefinition
entryRuleIntervalTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntervalTypeDefinitionRule()); }
	iv_ruleIntervalTypeDefinition=ruleIntervalTypeDefinition
	{ $current=$iv_ruleIntervalTypeDefinition.current; }
	EOF;

// Rule IntervalTypeDefinition
ruleIntervalTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getIntervalTypeDefinitionAccess().getIntervalTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionAccess().getVisibilityVisibilityKindEnumRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='type'
		{
			newLeafNode(otherlv_2, grammarAccess.getIntervalTypeDefinitionAccess().getTypeKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_5='interval'
		{
			newLeafNode(otherlv_5, grammarAccess.getIntervalTypeDefinitionAccess().getIntervalKeyword_5());
		}
		otherlv_6='<'
		{
			newLeafNode(otherlv_6, grammarAccess.getIntervalTypeDefinitionAccess().getLessThanSignKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionAccess().getSupportPrimitiveNumberTypeParserRuleCall_7_0());
				}
				lv_support_7_0=rulePrimitiveNumberType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionRule());
					}
					set(
						$current,
						"support",
						lv_support_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveNumberType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					lv_lopen_8_0=']'
					{
						newLeafNode(lv_lopen_8_0, grammarAccess.getIntervalTypeDefinitionAccess().getLopenRightSquareBracketKeyword_8_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getIntervalTypeDefinitionRule());
						}
						setWithLastConsumed($current, "lopen", true, "]");
					}
				)
			)
			    |
			otherlv_9='['
			{
				newLeafNode(otherlv_9, grammarAccess.getIntervalTypeDefinitionAccess().getLeftSquareBracketKeyword_8_1());
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionAccess().getInfimumExpressionParserRuleCall_9_0());
				}
				lv_infimum_10_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionRule());
					}
					set(
						$current,
						"infimum",
						lv_infimum_10_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_11=','
		{
			newLeafNode(otherlv_11, grammarAccess.getIntervalTypeDefinitionAccess().getCommaKeyword_10());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionAccess().getSupremumExpressionParserRuleCall_11_0());
				}
				lv_supremum_12_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionRule());
					}
					set(
						$current,
						"supremum",
						lv_supremum_12_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_13=']'
			{
				newLeafNode(otherlv_13, grammarAccess.getIntervalTypeDefinitionAccess().getRightSquareBracketKeyword_12_0());
			}
			    |
			(
				(
					lv_ropen_14_0='['
					{
						newLeafNode(lv_ropen_14_0, grammarAccess.getIntervalTypeDefinitionAccess().getRopenLeftSquareBracketKeyword_12_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getIntervalTypeDefinitionRule());
						}
						setWithLastConsumed($current, "ropen", true, "[");
					}
				)
			)
		)
		otherlv_15='>'
		{
			newLeafNode(otherlv_15, grammarAccess.getIntervalTypeDefinitionAccess().getGreaterThanSignKeyword_13());
		}
		otherlv_16=';'
		{
			newLeafNode(otherlv_16, grammarAccess.getIntervalTypeDefinitionAccess().getSemicolonKeyword_14());
		}
	)
;

// Entry rule entryRuleIntervalTypeDefinitionImpl
entryRuleIntervalTypeDefinitionImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntervalTypeDefinitionImplRule()); }
	iv_ruleIntervalTypeDefinitionImpl=ruleIntervalTypeDefinitionImpl
	{ $current=$iv_ruleIntervalTypeDefinitionImpl.current; }
	EOF;

// Rule IntervalTypeDefinitionImpl
ruleIntervalTypeDefinitionImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getIntervalTypeDefinitionImplAccess().getIntervalTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionImplAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionImplRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_3='interval'
		{
			newLeafNode(otherlv_3, grammarAccess.getIntervalTypeDefinitionImplAccess().getIntervalKeyword_3());
		}
		otherlv_4='<'
		{
			newLeafNode(otherlv_4, grammarAccess.getIntervalTypeDefinitionImplAccess().getLessThanSignKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionImplAccess().getSupportPrimitiveNumberTypeParserRuleCall_5_0());
				}
				lv_support_5_0=rulePrimitiveNumberType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionImplRule());
					}
					set(
						$current,
						"support",
						lv_support_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveNumberType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					lv_lopen_6_0=']'
					{
						newLeafNode(lv_lopen_6_0, grammarAccess.getIntervalTypeDefinitionImplAccess().getLopenRightSquareBracketKeyword_6_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getIntervalTypeDefinitionImplRule());
						}
						setWithLastConsumed($current, "lopen", true, "]");
					}
				)
			)
			    |
			otherlv_7='['
			{
				newLeafNode(otherlv_7, grammarAccess.getIntervalTypeDefinitionImplAccess().getLeftSquareBracketKeyword_6_1());
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionImplAccess().getInfimumExpressionParserRuleCall_7_0());
				}
				lv_infimum_8_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionImplRule());
					}
					set(
						$current,
						"infimum",
						lv_infimum_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_9=','
		{
			newLeafNode(otherlv_9, grammarAccess.getIntervalTypeDefinitionImplAccess().getCommaKeyword_8());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalTypeDefinitionImplAccess().getSupremumExpressionParserRuleCall_9_0());
				}
				lv_supremum_10_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalTypeDefinitionImplRule());
					}
					set(
						$current,
						"supremum",
						lv_supremum_10_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_11=']'
			{
				newLeafNode(otherlv_11, grammarAccess.getIntervalTypeDefinitionImplAccess().getRightSquareBracketKeyword_10_0());
			}
			    |
			(
				(
					lv_ropen_12_0='['
					{
						newLeafNode(lv_ropen_12_0, grammarAccess.getIntervalTypeDefinitionImplAccess().getRopenLeftSquareBracketKeyword_10_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getIntervalTypeDefinitionImplRule());
						}
						setWithLastConsumed($current, "ropen", true, "[");
					}
				)
			)
		)
		otherlv_13='>'
		{
			newLeafNode(otherlv_13, grammarAccess.getIntervalTypeDefinitionImplAccess().getGreaterThanSignKeyword_11());
		}
		otherlv_14=';'
		{
			newLeafNode(otherlv_14, grammarAccess.getIntervalTypeDefinitionImplAccess().getSemicolonKeyword_12());
		}
	)
;

// Entry rule entryRuleCollectionType
entryRuleCollectionType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCollectionTypeRule()); }
	iv_ruleCollectionType=ruleCollectionType
	{ $current=$iv_ruleCollectionType.current; }
	EOF;

// Rule CollectionType
ruleCollectionType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getCollectionTypeAccess().getCollectionTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeAccess().getContainerCollectionKindEnumRuleCall_1_0());
				}
				lv_container_1_0=ruleCollectionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeRule());
					}
					set(
						$current,
						"container",
						lv_container_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.CollectionKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getCollectionTypeAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getCollectionTypeAccess().getSupportDataTypeParserRuleCall_2_1_0());
					}
					lv_support_3_0=ruleDataType
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCollectionTypeRule());
						}
						set(
							$current,
							"support",
							lv_support_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.DataType");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getCollectionTypeAccess().getCommaKeyword_2_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getCollectionTypeAccess().getSizeEIntParserRuleCall_2_2_1_0_0());
							}
							lv_size_5_0=ruleEInt
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getCollectionTypeRule());
								}
								set(
									$current,
									"size",
									lv_size_5_0,
									"org.eclipse.efm.formalml.xtext.FormalML.EInt");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							lv_unbounded_6_0='*'
							{
								newLeafNode(lv_unbounded_6_0, grammarAccess.getCollectionTypeAccess().getUnboundedAsteriskKeyword_2_2_1_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getCollectionTypeRule());
								}
								setWithLastConsumed($current, "unbounded", true, "*");
							}
						)
					)
				)
			)?
			otherlv_7='>'
			{
				newLeafNode(otherlv_7, grammarAccess.getCollectionTypeAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
	)
;

// Entry rule entryRuleCollectionTypeDefinition
entryRuleCollectionTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCollectionTypeDefinitionRule()); }
	iv_ruleCollectionTypeDefinition=ruleCollectionTypeDefinition
	{ $current=$iv_ruleCollectionTypeDefinition.current; }
	EOF;

// Rule CollectionTypeDefinition
ruleCollectionTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getCollectionTypeDefinitionAccess().getCollectionTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionAccess().getVisibilityVisibilityKindEnumRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='type'
		{
			newLeafNode(otherlv_2, grammarAccess.getCollectionTypeDefinitionAccess().getTypeKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionAccess().getContainerCollectionKindEnumRuleCall_5_0());
				}
				lv_container_5_0=ruleCollectionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionRule());
					}
					set(
						$current,
						"container",
						lv_container_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.CollectionKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='<'
		{
			newLeafNode(otherlv_6, grammarAccess.getCollectionTypeDefinitionAccess().getLessThanSignKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionAccess().getSupportDataTypeParserRuleCall_7_0());
				}
				lv_support_7_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionRule());
					}
					set(
						$current,
						"support",
						lv_support_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_8=','
			{
				newLeafNode(otherlv_8, grammarAccess.getCollectionTypeDefinitionAccess().getCommaKeyword_8_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getCollectionTypeDefinitionAccess().getSizeEIntParserRuleCall_8_1_0_0());
						}
						lv_size_9_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionRule());
							}
							set(
								$current,
								"size",
								lv_size_9_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						lv_unbounded_10_0='*'
						{
							newLeafNode(lv_unbounded_10_0, grammarAccess.getCollectionTypeDefinitionAccess().getUnboundedAsteriskKeyword_8_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getCollectionTypeDefinitionRule());
							}
							setWithLastConsumed($current, "unbounded", true, "*");
						}
					)
				)
			)
		)?
		otherlv_11='>'
		{
			newLeafNode(otherlv_11, grammarAccess.getCollectionTypeDefinitionAccess().getGreaterThanSignKeyword_9());
		}
		otherlv_12=';'
		{
			newLeafNode(otherlv_12, grammarAccess.getCollectionTypeDefinitionAccess().getSemicolonKeyword_10());
		}
	)
;

// Entry rule entryRuleCollectionTypeDefinitionImpl
entryRuleCollectionTypeDefinitionImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCollectionTypeDefinitionImplRule()); }
	iv_ruleCollectionTypeDefinitionImpl=ruleCollectionTypeDefinitionImpl
	{ $current=$iv_ruleCollectionTypeDefinitionImpl.current; }
	EOF;

// Rule CollectionTypeDefinitionImpl
ruleCollectionTypeDefinitionImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getCollectionTypeDefinitionImplAccess().getCollectionTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionImplAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionImplRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionImplAccess().getContainerCollectionKindEnumRuleCall_3_0());
				}
				lv_container_3_0=ruleCollectionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionImplRule());
					}
					set(
						$current,
						"container",
						lv_container_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.CollectionKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='<'
		{
			newLeafNode(otherlv_4, grammarAccess.getCollectionTypeDefinitionImplAccess().getLessThanSignKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeDefinitionImplAccess().getSupportDataTypeParserRuleCall_5_0());
				}
				lv_support_5_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionImplRule());
					}
					set(
						$current,
						"support",
						lv_support_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6=','
			{
				newLeafNode(otherlv_6, grammarAccess.getCollectionTypeDefinitionImplAccess().getCommaKeyword_6_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getCollectionTypeDefinitionImplAccess().getSizeEIntParserRuleCall_6_1_0_0());
						}
						lv_size_7_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCollectionTypeDefinitionImplRule());
							}
							set(
								$current,
								"size",
								lv_size_7_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						lv_unbounded_8_0='*'
						{
							newLeafNode(lv_unbounded_8_0, grammarAccess.getCollectionTypeDefinitionImplAccess().getUnboundedAsteriskKeyword_6_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getCollectionTypeDefinitionImplRule());
							}
							setWithLastConsumed($current, "unbounded", true, "*");
						}
					)
				)
			)
		)?
		otherlv_9='>'
		{
			newLeafNode(otherlv_9, grammarAccess.getCollectionTypeDefinitionImplAccess().getGreaterThanSignKeyword_7());
		}
		otherlv_10=';'
		{
			newLeafNode(otherlv_10, grammarAccess.getCollectionTypeDefinitionImplAccess().getSemicolonKeyword_8());
		}
	)
;

// Entry rule entryRuleEnumerationType
entryRuleEnumerationType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumerationTypeRule()); }
	iv_ruleEnumerationType=ruleEnumerationType
	{ $current=$iv_ruleEnumerationType.current; }
	EOF;

// Rule EnumerationType
ruleEnumerationType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getEnumerationTypeAccess().getEnumerationTypeAction_0(),
					$current);
			}
		)
		otherlv_1='enum'
		{
			newLeafNode(otherlv_1, grammarAccess.getEnumerationTypeAccess().getEnumKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getEnumerationTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralEnumerationLiteralParserRuleCall_3_0());
				}
				lv_literal_3_0=ruleEnumerationLiteral
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
					}
					add(
						$current,
						"literal",
						lv_literal_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EnumerationLiteral");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=','
			{
				newLeafNode(otherlv_4, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralEnumerationLiteralParserRuleCall_4_1_0());
					}
					lv_literal_5_0=ruleEnumerationLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
						}
						add(
							$current,
							"literal",
							lv_literal_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.EnumerationLiteral");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getEnumerationTypeAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleEnumerationTypeDefinition
entryRuleEnumerationTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumerationTypeDefinitionRule()); }
	iv_ruleEnumerationTypeDefinition=ruleEnumerationTypeDefinition
	{ $current=$iv_ruleEnumerationTypeDefinition.current; }
	EOF;

// Rule EnumerationTypeDefinition
ruleEnumerationTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getEnumerationTypeDefinitionAccess().getEnumerationTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeDefinitionAccess().getVisibilityVisibilityKindEnumRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='type'
		{
			newLeafNode(otherlv_2, grammarAccess.getEnumerationTypeDefinitionAccess().getTypeKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeDefinitionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeDefinitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_typedef_5_0='enum'
				{
					newLeafNode(lv_typedef_5_0, grammarAccess.getEnumerationTypeDefinitionAccess().getTypedefEnumKeyword_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEnumerationTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "enum");
				}
			)
		)
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getEnumerationTypeDefinitionAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeDefinitionAccess().getLiteralEnumerationLiteralParserRuleCall_7_0());
				}
				lv_literal_7_0=ruleEnumerationLiteral
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionRule());
					}
					add(
						$current,
						"literal",
						lv_literal_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EnumerationLiteral");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_8=','
			{
				newLeafNode(otherlv_8, grammarAccess.getEnumerationTypeDefinitionAccess().getCommaKeyword_8_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumerationTypeDefinitionAccess().getLiteralEnumerationLiteralParserRuleCall_8_1_0());
					}
					lv_literal_9_0=ruleEnumerationLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionRule());
						}
						add(
							$current,
							"literal",
							lv_literal_9_0,
							"org.eclipse.efm.formalml.xtext.FormalML.EnumerationLiteral");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_10='}'
		{
			newLeafNode(otherlv_10, grammarAccess.getEnumerationTypeDefinitionAccess().getRightCurlyBracketKeyword_9());
		}
	)
;

// Entry rule entryRuleEnumerationTypeDefinitionImpl
entryRuleEnumerationTypeDefinitionImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumerationTypeDefinitionImplRule()); }
	iv_ruleEnumerationTypeDefinitionImpl=ruleEnumerationTypeDefinitionImpl
	{ $current=$iv_ruleEnumerationTypeDefinitionImpl.current; }
	EOF;

// Rule EnumerationTypeDefinitionImpl
ruleEnumerationTypeDefinitionImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getEnumerationTypeDefinitionImplAccess().getEnumerationTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeDefinitionImplAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionImplRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeDefinitionImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_typedef_3_0='enum'
				{
					newLeafNode(lv_typedef_3_0, grammarAccess.getEnumerationTypeDefinitionImplAccess().getTypedefEnumKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEnumerationTypeDefinitionImplRule());
					}
					setWithLastConsumed($current, "typedef", true, "enum");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getEnumerationTypeDefinitionImplAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeDefinitionImplAccess().getLiteralEnumerationLiteralParserRuleCall_5_0());
				}
				lv_literal_5_0=ruleEnumerationLiteral
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionImplRule());
					}
					add(
						$current,
						"literal",
						lv_literal_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EnumerationLiteral");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6=','
			{
				newLeafNode(otherlv_6, grammarAccess.getEnumerationTypeDefinitionImplAccess().getCommaKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumerationTypeDefinitionImplAccess().getLiteralEnumerationLiteralParserRuleCall_6_1_0());
					}
					lv_literal_7_0=ruleEnumerationLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionImplRule());
						}
						add(
							$current,
							"literal",
							lv_literal_7_0,
							"org.eclipse.efm.formalml.xtext.FormalML.EnumerationLiteral");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getEnumerationTypeDefinitionImplAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleEnumerationLiteral
entryRuleEnumerationLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumerationLiteralRule()); }
	iv_ruleEnumerationLiteral=ruleEnumerationLiteral
	{ $current=$iv_ruleEnumerationLiteral.current; }
	EOF;

// Rule EnumerationLiteral
ruleEnumerationLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationLiteralAccess().getNameESIdentifierParserRuleCall_0_0());
				}
				lv_name_0_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationLiteralRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationLiteralAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_1_0());
				}
				lv_unrestrictedName_1_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationLiteralRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_2='='
			{
				newLeafNode(otherlv_2, grammarAccess.getEnumerationLiteralAccess().getEqualsSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumerationLiteralAccess().getValueLiteralTerminalExpressionParserRuleCall_2_1_0());
					}
					lv_value_3_0=ruleLiteralTerminalExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumerationLiteralRule());
						}
						set(
							$current,
							"value",
							lv_value_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LiteralTerminalExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleStructureType
entryRuleStructureType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructureTypeRule()); }
	iv_ruleStructureType=ruleStructureType
	{ $current=$iv_ruleStructureType.current; }
	EOF;

// Rule StructureType
ruleStructureType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getStructureTypeAccess().getStructureTypeAction_0(),
					$current);
			}
		)
		otherlv_1='struct'
		{
			newLeafNode(otherlv_1, grammarAccess.getStructureTypeAccess().getStructKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getStructureTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeAccess().getPropertyVariableParserRuleCall_3_0());
				}
				lv_property_3_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeRule());
					}
					add(
						$current,
						"property",
						lv_property_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getStructureTypeAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleStructureTypeDefinition
entryRuleStructureTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructureTypeDefinitionRule()); }
	iv_ruleStructureTypeDefinition=ruleStructureTypeDefinition
	{ $current=$iv_ruleStructureTypeDefinition.current; }
	EOF;

// Rule StructureTypeDefinition
ruleStructureTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getStructureTypeDefinitionAccess().getStructureTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeDefinitionAccess().getVisibilityVisibilityKindEnumRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='type'
		{
			newLeafNode(otherlv_2, grammarAccess.getStructureTypeDefinitionAccess().getTypeKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeDefinitionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeDefinitionRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeDefinitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeDefinitionRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_typedef_5_0='struct'
				{
					newLeafNode(lv_typedef_5_0, grammarAccess.getStructureTypeDefinitionAccess().getTypedefStructKeyword_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructureTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "struct");
				}
			)
		)
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getStructureTypeDefinitionAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeDefinitionAccess().getPropertyVariableParserRuleCall_7_0());
				}
				lv_property_7_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeDefinitionRule());
					}
					add(
						$current,
						"property",
						lv_property_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getStructureTypeDefinitionAccess().getRightCurlyBracketKeyword_8());
		}
	)
;

// Entry rule entryRuleStructureTypeDefinitionImpl
entryRuleStructureTypeDefinitionImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructureTypeDefinitionImplRule()); }
	iv_ruleStructureTypeDefinitionImpl=ruleStructureTypeDefinitionImpl
	{ $current=$iv_ruleStructureTypeDefinitionImpl.current; }
	EOF;

// Rule StructureTypeDefinitionImpl
ruleStructureTypeDefinitionImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getStructureTypeDefinitionImplAccess().getStructureTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeDefinitionImplAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeDefinitionImplRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeDefinitionImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeDefinitionImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_typedef_3_0='struct'
				{
					newLeafNode(lv_typedef_3_0, grammarAccess.getStructureTypeDefinitionImplAccess().getTypedefStructKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructureTypeDefinitionImplRule());
					}
					setWithLastConsumed($current, "typedef", true, "struct");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getStructureTypeDefinitionImplAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeDefinitionImplAccess().getPropertyVariableParserRuleCall_5_0());
				}
				lv_property_5_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeDefinitionImplRule());
					}
					add(
						$current,
						"property",
						lv_property_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getStructureTypeDefinitionImplAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleUnionType
entryRuleUnionType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnionTypeRule()); }
	iv_ruleUnionType=ruleUnionType
	{ $current=$iv_ruleUnionType.current; }
	EOF;

// Rule UnionType
ruleUnionType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getUnionTypeAccess().getUnionTypeAction_0(),
					$current);
			}
		)
		otherlv_1='union'
		{
			newLeafNode(otherlv_1, grammarAccess.getUnionTypeAccess().getUnionKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getUnionTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeAccess().getPropertyVariableParserRuleCall_3_0());
				}
				lv_property_3_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeRule());
					}
					add(
						$current,
						"property",
						lv_property_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleUnionTypeDefinition
entryRuleUnionTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnionTypeDefinitionRule()); }
	iv_ruleUnionTypeDefinition=ruleUnionTypeDefinition
	{ $current=$iv_ruleUnionTypeDefinition.current; }
	EOF;

// Rule UnionTypeDefinition
ruleUnionTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getUnionTypeDefinitionAccess().getUnionTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeDefinitionAccess().getVisibilityVisibilityKindEnumRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='type'
		{
			newLeafNode(otherlv_2, grammarAccess.getUnionTypeDefinitionAccess().getTypeKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeDefinitionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeDefinitionRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeDefinitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeDefinitionRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_typedef_5_0='union'
				{
					newLeafNode(lv_typedef_5_0, grammarAccess.getUnionTypeDefinitionAccess().getTypedefUnionKeyword_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnionTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "union");
				}
			)
		)
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getUnionTypeDefinitionAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeDefinitionAccess().getPropertyVariableParserRuleCall_7_0());
				}
				lv_property_7_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeDefinitionRule());
					}
					add(
						$current,
						"property",
						lv_property_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getUnionTypeDefinitionAccess().getRightCurlyBracketKeyword_8());
		}
	)
;

// Entry rule entryRuleUnionTypeDefinitionImpl
entryRuleUnionTypeDefinitionImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnionTypeDefinitionImplRule()); }
	iv_ruleUnionTypeDefinitionImpl=ruleUnionTypeDefinitionImpl
	{ $current=$iv_ruleUnionTypeDefinitionImpl.current; }
	EOF;

// Rule UnionTypeDefinitionImpl
ruleUnionTypeDefinitionImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getUnionTypeDefinitionImplAccess().getUnionTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeDefinitionImplAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeDefinitionImplRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeDefinitionImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeDefinitionImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_typedef_3_0='union'
				{
					newLeafNode(lv_typedef_3_0, grammarAccess.getUnionTypeDefinitionImplAccess().getTypedefUnionKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnionTypeDefinitionImplRule());
					}
					setWithLastConsumed($current, "typedef", true, "union");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getUnionTypeDefinitionImplAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeDefinitionImplAccess().getPropertyVariableParserRuleCall_5_0());
				}
				lv_property_5_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeDefinitionImplRule());
					}
					add(
						$current,
						"property",
						lv_property_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getUnionTypeDefinitionImplAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleChoiceType
entryRuleChoiceType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChoiceTypeRule()); }
	iv_ruleChoiceType=ruleChoiceType
	{ $current=$iv_ruleChoiceType.current; }
	EOF;

// Rule ChoiceType
ruleChoiceType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getChoiceTypeAccess().getChoiceTypeAction_0(),
					$current);
			}
		)
		otherlv_1='choice'
		{
			newLeafNode(otherlv_1, grammarAccess.getChoiceTypeAccess().getChoiceKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getChoiceTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeAccess().getPropertyVariableParserRuleCall_3_0());
				}
				lv_property_3_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeRule());
					}
					add(
						$current,
						"property",
						lv_property_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getChoiceTypeAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleChoiceTypeDefinition
entryRuleChoiceTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChoiceTypeDefinitionRule()); }
	iv_ruleChoiceTypeDefinition=ruleChoiceTypeDefinition
	{ $current=$iv_ruleChoiceTypeDefinition.current; }
	EOF;

// Rule ChoiceTypeDefinition
ruleChoiceTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getChoiceTypeDefinitionAccess().getChoiceTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeDefinitionAccess().getVisibilityVisibilityKindEnumRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeDefinitionRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='type'
		{
			newLeafNode(otherlv_2, grammarAccess.getChoiceTypeDefinitionAccess().getTypeKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeDefinitionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeDefinitionRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeDefinitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeDefinitionRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_typedef_5_0='choice'
				{
					newLeafNode(lv_typedef_5_0, grammarAccess.getChoiceTypeDefinitionAccess().getTypedefChoiceKeyword_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getChoiceTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "choice");
				}
			)
		)
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getChoiceTypeDefinitionAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeDefinitionAccess().getPropertyVariableParserRuleCall_7_0());
				}
				lv_property_7_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeDefinitionRule());
					}
					add(
						$current,
						"property",
						lv_property_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getChoiceTypeDefinitionAccess().getRightCurlyBracketKeyword_8());
		}
	)
;

// Entry rule entryRuleChoiceTypeDefinitionImpl
entryRuleChoiceTypeDefinitionImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChoiceTypeDefinitionImplRule()); }
	iv_ruleChoiceTypeDefinitionImpl=ruleChoiceTypeDefinitionImpl
	{ $current=$iv_ruleChoiceTypeDefinitionImpl.current; }
	EOF;

// Rule ChoiceTypeDefinitionImpl
ruleChoiceTypeDefinitionImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getChoiceTypeDefinitionImplAccess().getChoiceTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeDefinitionImplAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeDefinitionImplRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeDefinitionImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_unrestrictedName_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeDefinitionImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_typedef_3_0='choice'
				{
					newLeafNode(lv_typedef_3_0, grammarAccess.getChoiceTypeDefinitionImplAccess().getTypedefChoiceKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getChoiceTypeDefinitionImplRule());
					}
					setWithLastConsumed($current, "typedef", true, "choice");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getChoiceTypeDefinitionImplAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeDefinitionImplAccess().getPropertyVariableParserRuleCall_5_0());
				}
				lv_property_5_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeDefinitionImplRule());
					}
					add(
						$current,
						"property",
						lv_property_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getChoiceTypeDefinitionImplAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleModifier
entryRuleModifier returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getModifierAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getModifierRule()); }
	iv_ruleModifier=ruleModifier
	{ $current=$iv_ruleModifier.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule Modifier
ruleModifier returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getModifierAccess().getUnorderedGroup_1()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getModifierAccess().getModifierAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getModifierAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>((
									lv_static_2_0='static'
									{
										newLeafNode(lv_static_2_0, grammarAccess.getModifierAccess().getStaticStaticKeyword_1_0_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getModifierRule());
										}
										setWithLastConsumed($current, "static", true, "static");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModifierAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>((
									lv_final_3_0='final'
									{
										newLeafNode(lv_final_3_0, grammarAccess.getModifierAccess().getFinalFinalKeyword_1_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getModifierRule());
										}
										setWithLastConsumed($current, "final", true, "final");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModifierAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 2);
					}
								({true}?=>((
									lv_volatile_4_0='volatile'
									{
										newLeafNode(lv_volatile_4_0, grammarAccess.getModifierAccess().getVolatileVolatileKeyword_1_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getModifierRule());
										}
										setWithLastConsumed($current, "volatile", true, "volatile");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModifierAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 3);
					}
								({true}?=>((
									lv_transient_5_0='transient'
									{
										newLeafNode(lv_transient_5_0, grammarAccess.getModifierAccess().getTransientTransientKeyword_1_3_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getModifierRule());
										}
										setWithLastConsumed($current, "transient", true, "transient");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModifierAccess().getUnorderedGroup_1());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getModifierAccess().getUnorderedGroup_1());
				}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleFunction
entryRuleFunction returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getFunctionAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getFunctionRule()); }
	iv_ruleFunction=ruleFunction
	{ $current=$iv_ruleFunction.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule Function
ruleFunction returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getFunctionAccess().getUnorderedGroup_1()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getFunctionAccess().getFunctionAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getFunctionAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getFunctionAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getFunctionAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getFunctionAccess().getVisibilityVisibilityKindEnumRuleCall_1_0_0());
									}
									lv_visibility_2_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getFunctionRule());
										}
										set(
											$current,
											"visibility",
											lv_visibility_2_0,
											"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFunctionAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getFunctionAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getFunctionAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getFunctionAccess().getModifierModifierParserRuleCall_1_1_0());
									}
									lv_modifier_3_0=ruleModifier
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getFunctionRule());
										}
										set(
											$current,
											"modifier",
											lv_modifier_3_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFunctionAccess().getUnorderedGroup_1());
					}
				)
			)
					)+
					{getUnorderedGroupHelper().canLeave(grammarAccess.getFunctionAccess().getUnorderedGroup_1())}?
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getFunctionAccess().getUnorderedGroup_1());
				}
		)?
		otherlv_4='fun'
		{
			newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getFunKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_5_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_6_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_6_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_7='('
			{
				newLeafNode(otherlv_7, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFunctionAccess().getArgumentFormalParameterParserRuleCall_5_1_0());
					}
					lv_argument_8_0=ruleFormalParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFunctionRule());
						}
						add(
							$current,
							"argument",
							lv_argument_8_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_9=','
				{
					newLeafNode(otherlv_9, grammarAccess.getFunctionAccess().getCommaKeyword_5_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getFunctionAccess().getArgumentFormalParameterParserRuleCall_5_2_1_0());
						}
						lv_argument_10_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunctionRule());
							}
							add(
								$current,
								"argument",
								lv_argument_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_11=')'
			{
				newLeafNode(otherlv_11, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5_3());
			}
		)?
		otherlv_12='->'
		{
			newLeafNode(otherlv_12, grammarAccess.getFunctionAccess().getHyphenMinusGreaterThanSignKeyword_6());
		}
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getFunctionAccess().getResultFormalParameterParserRuleCall_7_0_0_0());
						}
						lv_result_13_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunctionRule());
							}
							add(
								$current,
								"result",
								lv_result_13_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_14=','
					{
						newLeafNode(otherlv_14, grammarAccess.getFunctionAccess().getCommaKeyword_7_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getFunctionAccess().getResultFormalParameterParserRuleCall_7_0_1_1_0());
							}
							lv_result_15_0=ruleFormalParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getFunctionRule());
								}
								add(
									$current,
									"result",
									lv_result_15_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_16='('
				{
					newLeafNode(otherlv_16, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_7_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getFunctionAccess().getResultFormalParameterParserRuleCall_7_1_1_0());
						}
						lv_result_17_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunctionRule());
							}
							add(
								$current,
								"result",
								lv_result_17_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_18=','
					{
						newLeafNode(otherlv_18, grammarAccess.getFunctionAccess().getCommaKeyword_7_1_2_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getFunctionAccess().getResultFormalParameterParserRuleCall_7_1_2_1_0());
							}
							lv_result_19_0=ruleFormalParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getFunctionRule());
								}
								add(
									$current,
									"result",
									lv_result_19_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_20=')'
				{
					newLeafNode(otherlv_20, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_7_1_3());
				}
			)
		)
		otherlv_21=';'
		{
			newLeafNode(otherlv_21, grammarAccess.getFunctionAccess().getSemicolonKeyword_8());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleFunctionImpl
entryRuleFunctionImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionImplRule()); }
	iv_ruleFunctionImpl=ruleFunctionImpl
	{ $current=$iv_ruleFunctionImpl.current; }
	EOF;

// Rule FunctionImpl
ruleFunctionImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getFunctionImplAccess().getFunctionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionImplAccess().getModifierModifierParserRuleCall_1_0());
				}
				lv_modifier_1_0=ruleModifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
					}
					set(
						$current,
						"modifier",
						lv_modifier_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='fun'
		{
			newLeafNode(otherlv_2, grammarAccess.getFunctionImplAccess().getFunKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionImplAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_5='('
			{
				newLeafNode(otherlv_5, grammarAccess.getFunctionImplAccess().getLeftParenthesisKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFunctionImplAccess().getArgumentFormalParameterParserRuleCall_5_1_0());
					}
					lv_argument_6_0=ruleFormalParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
						}
						add(
							$current,
							"argument",
							lv_argument_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_7=','
				{
					newLeafNode(otherlv_7, grammarAccess.getFunctionImplAccess().getCommaKeyword_5_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getFunctionImplAccess().getArgumentFormalParameterParserRuleCall_5_2_1_0());
						}
						lv_argument_8_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
							}
							add(
								$current,
								"argument",
								lv_argument_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_9=')'
			{
				newLeafNode(otherlv_9, grammarAccess.getFunctionImplAccess().getRightParenthesisKeyword_5_3());
			}
		)?
		otherlv_10='->'
		{
			newLeafNode(otherlv_10, grammarAccess.getFunctionImplAccess().getHyphenMinusGreaterThanSignKeyword_6());
		}
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getFunctionImplAccess().getResultFormalParameterParserRuleCall_7_0_0_0());
						}
						lv_result_11_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
							}
							add(
								$current,
								"result",
								lv_result_11_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_12=','
					{
						newLeafNode(otherlv_12, grammarAccess.getFunctionImplAccess().getCommaKeyword_7_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getFunctionImplAccess().getResultFormalParameterParserRuleCall_7_0_1_1_0());
							}
							lv_result_13_0=ruleFormalParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
								}
								add(
									$current,
									"result",
									lv_result_13_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_14='('
				{
					newLeafNode(otherlv_14, grammarAccess.getFunctionImplAccess().getLeftParenthesisKeyword_7_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getFunctionImplAccess().getResultFormalParameterParserRuleCall_7_1_1_0());
						}
						lv_result_15_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
							}
							add(
								$current,
								"result",
								lv_result_15_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_16=','
					{
						newLeafNode(otherlv_16, grammarAccess.getFunctionImplAccess().getCommaKeyword_7_1_2_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getFunctionImplAccess().getResultFormalParameterParserRuleCall_7_1_2_1_0());
							}
							lv_result_17_0=ruleFormalParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
								}
								add(
									$current,
									"result",
									lv_result_17_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_18=')'
				{
					newLeafNode(otherlv_18, grammarAccess.getFunctionImplAccess().getRightParenthesisKeyword_7_1_3());
				}
			)
		)
		otherlv_19=';'
		{
			newLeafNode(otherlv_19, grammarAccess.getFunctionImplAccess().getSemicolonKeyword_8());
		}
	)
;

// Entry rule entryRuleFunctionPublic
entryRuleFunctionPublic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionPublicRule()); }
	iv_ruleFunctionPublic=ruleFunctionPublic
	{ $current=$iv_ruleFunctionPublic.current; }
	EOF;

// Rule FunctionPublic
ruleFunctionPublic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getFunctionPublicAccess().getFunctionImplParserRuleCall());
	}
	this_FunctionImpl_0=ruleFunctionImpl
	{
		$current = $this_FunctionImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleFunctionProtected
entryRuleFunctionProtected returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionProtectedRule()); }
	iv_ruleFunctionProtected=ruleFunctionProtected
	{ $current=$iv_ruleFunctionProtected.current; }
	EOF;

// Rule FunctionProtected
ruleFunctionProtected returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getFunctionProtectedAccess().getFunctionImplParserRuleCall());
	}
	this_FunctionImpl_0=ruleFunctionImpl
	{
		$current = $this_FunctionImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleFunctionPrivate
entryRuleFunctionPrivate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionPrivateRule()); }
	iv_ruleFunctionPrivate=ruleFunctionPrivate
	{ $current=$iv_ruleFunctionPrivate.current; }
	EOF;

// Rule FunctionPrivate
ruleFunctionPrivate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getFunctionPrivateAccess().getFunctionImplParserRuleCall());
	}
	this_FunctionImpl_0=ruleFunctionImpl
	{
		$current = $this_FunctionImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleVariable
entryRuleVariable returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getVariableAccess().getUnorderedGroup_0()
	);
}:
	{ newCompositeNode(grammarAccess.getVariableRule()); }
	iv_ruleVariable=ruleVariable
	{ $current=$iv_ruleVariable.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule Variable
ruleVariable returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getVariableAccess().getUnorderedGroup_0()
	);
}
@after {
	leaveRule();
}:
	(
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getVariableAccess().getUnorderedGroup_0());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVariableAccess().getUnorderedGroup_0(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getVariableAccess().getUnorderedGroup_0(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getVariableAccess().getVisibilityVisibilityKindEnumRuleCall_0_0_0());
									}
									lv_visibility_1_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getVariableRule());
										}
										set(
											$current,
											"visibility",
											lv_visibility_1_0,
											"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVariableAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVariableAccess().getUnorderedGroup_0(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getVariableAccess().getUnorderedGroup_0(), 1);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getVariableAccess().getModifierModifierParserRuleCall_0_1_0());
									}
									lv_modifier_2_0=ruleModifier
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getVariableRule());
										}
										set(
											$current,
											"modifier",
											lv_modifier_2_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVariableAccess().getUnorderedGroup_0());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getVariableAccess().getUnorderedGroup_0());
				}
		)
		(
			otherlv_3='var'
			{
				newLeafNode(otherlv_3, grammarAccess.getVariableAccess().getVarKeyword_1_0());
			}
			    |
			(
				(
					lv_const_4_0='val'
					{
						newLeafNode(lv_const_4_0, grammarAccess.getVariableAccess().getConstValKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getVariableRule());
						}
						setWithLastConsumed($current, "const", true, "val");
					}
				)
			)
			    |
			(
				(
					(
						(
							lv_const_5_0='const'
							{
								newLeafNode(lv_const_5_0, grammarAccess.getVariableAccess().getConstConstKeyword_1_2_0_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getVariableRule());
								}
								setWithLastConsumed($current, "const", true, "const");
							}
						)
					)
					    |
					(
						(
							lv_const_6_0='final'
							{
								newLeafNode(lv_const_6_0, grammarAccess.getVariableAccess().getConstFinalKeyword_1_2_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getVariableRule());
								}
								setWithLastConsumed($current, "const", true, "final");
							}
						)
					)
				)
				(
					(
						lv_macro_7_0='macro'
						{
							newLeafNode(lv_macro_7_0, grammarAccess.getVariableAccess().getMacroMacroKeyword_1_2_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getVariableRule());
							}
							setWithLastConsumed($current, "macro", true, "macro");
						}
					)
				)?
				(
					otherlv_8='var'
					{
						newLeafNode(otherlv_8, grammarAccess.getVariableAccess().getVarKeyword_1_2_2());
					}
				)?
			)
			    |
			(
				(
					(
						lv_macro_9_0='macro'
						{
							newLeafNode(lv_macro_9_0, grammarAccess.getVariableAccess().getMacroMacroKeyword_1_3_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getVariableRule());
							}
							setWithLastConsumed($current, "macro", true, "macro");
						}
					)
				)
				(
					otherlv_10='var'
					{
						newLeafNode(otherlv_10, grammarAccess.getVariableAccess().getVarKeyword_1_3_1_0());
					}
					    |
					(
						(
							lv_const_11_0='val'
							{
								newLeafNode(lv_const_11_0, grammarAccess.getVariableAccess().getConstValKeyword_1_3_1_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getVariableRule());
								}
								setWithLastConsumed($current, "const", true, "val");
							}
						)
					)
				)?
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableAccess().getTypeDataTypeParserRuleCall_2_0());
				}
				lv_type_12_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRule());
					}
					set(
						$current,
						"type",
						lv_type_12_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				lv_reference_13_0='&'
				{
					newLeafNode(lv_reference_13_0, grammarAccess.getVariableAccess().getReferenceAmpersandKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getVariableRule());
					}
					setWithLastConsumed($current, "reference", true, "&");
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableAccess().getNameESIdentifierParserRuleCall_4_0());
				}
				lv_name_14_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRule());
					}
					set(
						$current,
						"name",
						lv_name_14_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_unrestrictedName_15_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_15_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_16='='
			{
				newLeafNode(otherlv_16, grammarAccess.getVariableAccess().getEqualsSignKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getVariableAccess().getDefaultValueExpressionParserRuleCall_6_1_0());
					}
					lv_defaultValue_17_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getVariableRule());
						}
						set(
							$current,
							"defaultValue",
							lv_defaultValue_17_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				otherlv_18='{'
				{
					newLeafNode(otherlv_18, grammarAccess.getVariableAccess().getLeftCurlyBracketKeyword_7_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getVariableAccess().getOnWriteActionOnWriteRoutineParserRuleCall_7_0_1_0());
						}
						lv_onWriteAction_19_0=ruleOnWriteRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getVariableRule());
							}
							set(
								$current,
								"onWriteAction",
								lv_onWriteAction_19_0,
								"org.eclipse.efm.formalml.xtext.FormalML.OnWriteRoutine");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_20='}'
				{
					newLeafNode(otherlv_20, grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_7_0_2());
				}
			)
			    |
			otherlv_21=';'
			{
				newLeafNode(otherlv_21, grammarAccess.getVariableAccess().getSemicolonKeyword_7_1());
			}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleVariableImpl
entryRuleVariableImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableImplRule()); }
	iv_ruleVariableImpl=ruleVariableImpl
	{ $current=$iv_ruleVariableImpl.current; }
	EOF;

// Rule VariableImpl
ruleVariableImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableImplAccess().getModifierModifierParserRuleCall_0_0());
				}
				lv_modifier_0_0=ruleModifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableImplRule());
					}
					set(
						$current,
						"modifier",
						lv_modifier_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_1='var'
			{
				newLeafNode(otherlv_1, grammarAccess.getVariableImplAccess().getVarKeyword_1_0());
			}
			    |
			(
				(
					lv_const_2_0='val'
					{
						newLeafNode(lv_const_2_0, grammarAccess.getVariableImplAccess().getConstValKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getVariableImplRule());
						}
						setWithLastConsumed($current, "const", true, "val");
					}
				)
			)
			    |
			(
				(
					(
						lv_const_3_0='const'
						{
							newLeafNode(lv_const_3_0, grammarAccess.getVariableImplAccess().getConstConstKeyword_1_2_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getVariableImplRule());
							}
							setWithLastConsumed($current, "const", true, "const");
						}
					)
				)
				(
					(
						lv_macro_4_0='macro'
						{
							newLeafNode(lv_macro_4_0, grammarAccess.getVariableImplAccess().getMacroMacroKeyword_1_2_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getVariableImplRule());
							}
							setWithLastConsumed($current, "macro", true, "macro");
						}
					)
				)?
				(
					otherlv_5='var'
					{
						newLeafNode(otherlv_5, grammarAccess.getVariableImplAccess().getVarKeyword_1_2_2());
					}
				)?
			)
			    |
			(
				(
					(
						lv_macro_6_0='macro'
						{
							newLeafNode(lv_macro_6_0, grammarAccess.getVariableImplAccess().getMacroMacroKeyword_1_3_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getVariableImplRule());
							}
							setWithLastConsumed($current, "macro", true, "macro");
						}
					)
				)
				(
					otherlv_7='var'
					{
						newLeafNode(otherlv_7, grammarAccess.getVariableImplAccess().getVarKeyword_1_3_1_0());
					}
					    |
					(
						(
							lv_const_8_0='val'
							{
								newLeafNode(lv_const_8_0, grammarAccess.getVariableImplAccess().getConstValKeyword_1_3_1_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getVariableImplRule());
								}
								setWithLastConsumed($current, "const", true, "val");
							}
						)
					)
				)?
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableImplAccess().getTypeDataTypeParserRuleCall_2_0());
				}
				lv_type_9_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableImplRule());
					}
					set(
						$current,
						"type",
						lv_type_9_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				lv_reference_10_0='&'
				{
					newLeafNode(lv_reference_10_0, grammarAccess.getVariableImplAccess().getReferenceAmpersandKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getVariableImplRule());
					}
					setWithLastConsumed($current, "reference", true, "&");
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableImplAccess().getNameESIdentifierParserRuleCall_4_0());
				}
				lv_name_11_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableImplRule());
					}
					set(
						$current,
						"name",
						lv_name_11_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_unrestrictedName_12_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_12_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_13='='
			{
				newLeafNode(otherlv_13, grammarAccess.getVariableImplAccess().getEqualsSignKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getVariableImplAccess().getDefaultValueExpressionParserRuleCall_6_1_0());
					}
					lv_defaultValue_14_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getVariableImplRule());
						}
						set(
							$current,
							"defaultValue",
							lv_defaultValue_14_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				otherlv_15='{'
				{
					newLeafNode(otherlv_15, grammarAccess.getVariableImplAccess().getLeftCurlyBracketKeyword_7_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getVariableImplAccess().getOnWriteActionOnWriteRoutineParserRuleCall_7_0_1_0());
						}
						lv_onWriteAction_16_0=ruleOnWriteRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getVariableImplRule());
							}
							set(
								$current,
								"onWriteAction",
								lv_onWriteAction_16_0,
								"org.eclipse.efm.formalml.xtext.FormalML.OnWriteRoutine");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_17='}'
				{
					newLeafNode(otherlv_17, grammarAccess.getVariableImplAccess().getRightCurlyBracketKeyword_7_0_2());
				}
			)
			    |
			otherlv_18=';'
			{
				newLeafNode(otherlv_18, grammarAccess.getVariableImplAccess().getSemicolonKeyword_7_1());
			}
		)
	)
;

// Entry rule entryRuleOnWriteRoutine
entryRuleOnWriteRoutine returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOnWriteRoutineRule()); }
	iv_ruleOnWriteRoutine=ruleOnWriteRoutine
	{ $current=$iv_ruleOnWriteRoutine.current; }
	EOF;

// Rule OnWriteRoutine
ruleOnWriteRoutine returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getOnWriteRoutineAccess().getRoutineAction_0(),
					$current);
			}
		)
		otherlv_1='@on_write'
		{
			newLeafNode(otherlv_1, grammarAccess.getOnWriteRoutineAccess().getOn_writeKeyword_1());
		}
		(
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getOnWriteRoutineAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOnWriteRoutineAccess().getParameterVariableRoutineParameterParserRuleCall_2_1_0());
					}
					lv_parameter_3_0=ruleVariableRoutineParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOnWriteRoutineRule());
						}
						add(
							$current,
							"parameter",
							lv_parameter_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.VariableRoutineParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4=')'
			{
				newLeafNode(otherlv_4, grammarAccess.getOnWriteRoutineAccess().getRightParenthesisKeyword_2_2());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getOnWriteRoutineAccess().getBodyBlockBlockStatementParserRuleCall_3_0());
				}
				lv_bodyBlock_5_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOnWriteRoutineRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleVariableRoutineParameter
entryRuleVariableRoutineParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableRoutineParameterRule()); }
	iv_ruleVariableRoutineParameter=ruleVariableRoutineParameter
	{ $current=$iv_ruleVariableRoutineParameter.current; }
	EOF;

// Rule VariableRoutineParameter
ruleVariableRoutineParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableRoutineParameterAccess().getTypeDataTypeParserRuleCall_0_0());
				}
				lv_type_0_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRoutineParameterRule());
					}
					set(
						$current,
						"type",
						lv_type_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableRoutineParameterAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRoutineParameterRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='='
			{
				newLeafNode(otherlv_2, grammarAccess.getVariableRoutineParameterAccess().getEqualsSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getVariableRoutineParameterAccess().getDefaultValueExpressionParserRuleCall_2_1_0());
					}
					lv_defaultValue_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getVariableRoutineParameterRule());
						}
						set(
							$current,
							"defaultValue",
							lv_defaultValue_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleVariablePublic
entryRuleVariablePublic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariablePublicRule()); }
	iv_ruleVariablePublic=ruleVariablePublic
	{ $current=$iv_ruleVariablePublic.current; }
	EOF;

// Rule VariablePublic
ruleVariablePublic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getVariablePublicAccess().getVariableImplParserRuleCall());
	}
	this_VariableImpl_0=ruleVariableImpl
	{
		$current = $this_VariableImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleVariableProtected
entryRuleVariableProtected returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableProtectedRule()); }
	iv_ruleVariableProtected=ruleVariableProtected
	{ $current=$iv_ruleVariableProtected.current; }
	EOF;

// Rule VariableProtected
ruleVariableProtected returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getVariableProtectedAccess().getVariableImplParserRuleCall());
	}
	this_VariableImpl_0=ruleVariableImpl
	{
		$current = $this_VariableImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleVariablePrivate
entryRuleVariablePrivate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariablePrivateRule()); }
	iv_ruleVariablePrivate=ruleVariablePrivate
	{ $current=$iv_ruleVariablePrivate.current; }
	EOF;

// Rule VariablePrivate
ruleVariablePrivate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getVariablePrivateAccess().getVariableImplParserRuleCall());
	}
	this_VariableImpl_0=ruleVariableImpl
	{
		$current = $this_VariableImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleFunctionalParameterSet
entryRuleFunctionalParameterSet returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionalParameterSetRule()); }
	iv_ruleFunctionalParameterSet=ruleFunctionalParameterSet
	{ $current=$iv_ruleFunctionalParameterSet.current; }
	EOF;

// Rule FunctionalParameterSet
ruleFunctionalParameterSet returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getFunctionalParameterSetAccess().getParameterSetAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionalParameterSetAccess().getParameterFunctionalParameterParserRuleCall_1_0());
				}
				lv_parameter_1_0=ruleFunctionalParameter
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionalParameterSetRule());
					}
					add(
						$current,
						"parameter",
						lv_parameter_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameter");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getFunctionalParameterSetAccess().getCommaKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFunctionalParameterSetAccess().getParameterFunctionalParameterParserRuleCall_2_1_0());
					}
					lv_parameter_3_0=ruleFunctionalParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFunctionalParameterSetRule());
						}
						add(
							$current,
							"parameter",
							lv_parameter_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FunctionalParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleFunctionalParameter
entryRuleFunctionalParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionalParameterRule()); }
	iv_ruleFunctionalParameter=ruleFunctionalParameter
	{ $current=$iv_ruleFunctionalParameter.current; }
	EOF;

// Rule FunctionalParameter
ruleFunctionalParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getFunctionalParameterAccess().getParameterAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionalParameterAccess().getDirectionParameterDirectionKindEnumRuleCall_1_0());
				}
				lv_direction_1_0=ruleParameterDirectionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionalParameterRule());
					}
					set(
						$current,
						"direction",
						lv_direction_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ParameterDirectionKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionalParameterAccess().getTypeDataTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionalParameterRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFunctionalParameterAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunctionalParameterRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4='='
			{
				newLeafNode(otherlv_4, grammarAccess.getFunctionalParameterAccess().getEqualsSignKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFunctionalParameterAccess().getDefaultValueExpressionParserRuleCall_4_1_0());
					}
					lv_defaultValue_5_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFunctionalParameterRule());
						}
						set(
							$current,
							"defaultValue",
							lv_defaultValue_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleFormalParameterSet
entryRuleFormalParameterSet returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFormalParameterSetRule()); }
	iv_ruleFormalParameterSet=ruleFormalParameterSet
	{ $current=$iv_ruleFormalParameterSet.current; }
	EOF;

// Rule FormalParameterSet
ruleFormalParameterSet returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getFormalParameterSetAccess().getParameterSetAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFormalParameterSetAccess().getParameterFormalParameterParserRuleCall_1_0());
				}
				lv_parameter_1_0=ruleFormalParameter
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFormalParameterSetRule());
					}
					add(
						$current,
						"parameter",
						lv_parameter_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getFormalParameterSetAccess().getCommaKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFormalParameterSetAccess().getParameterFormalParameterParserRuleCall_2_1_0());
					}
					lv_parameter_3_0=ruleFormalParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFormalParameterSetRule());
						}
						add(
							$current,
							"parameter",
							lv_parameter_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleFormalParameter
entryRuleFormalParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFormalParameterRule()); }
	iv_ruleFormalParameter=ruleFormalParameter
	{ $current=$iv_ruleFormalParameter.current; }
	EOF;

// Rule FormalParameter
ruleFormalParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getFormalParameterAccess().getParameterAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFormalParameterAccess().getDirectionParameterDirectionKindEnumRuleCall_1_0());
				}
				lv_direction_1_0=ruleParameterDirectionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
					}
					set(
						$current,
						"direction",
						lv_direction_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ParameterDirectionKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getFormalParameterAccess().getTypeDataTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFormalParameterAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_4='='
			{
				newLeafNode(otherlv_4, grammarAccess.getFormalParameterAccess().getEqualsSignKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFormalParameterAccess().getDefaultValueExpressionParserRuleCall_4_1_0());
					}
					lv_defaultValue_5_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
						}
						set(
							$current,
							"defaultValue",
							lv_defaultValue_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleParameterImpl
entryRuleParameterImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterImplRule()); }
	iv_ruleParameterImpl=ruleParameterImpl
	{ $current=$iv_ruleParameterImpl.current; }
	EOF;

// Rule ParameterImpl
ruleParameterImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getParameterImplAccess().getParameterAction_0(),
					$current);
			}
		)
		otherlv_1='var'
		{
			newLeafNode(otherlv_1, grammarAccess.getParameterImplAccess().getVarKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterImplAccess().getTypeDataTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterImplRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterImplAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterImplRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_5='='
			{
				newLeafNode(otherlv_5, grammarAccess.getParameterImplAccess().getEqualsSignKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getParameterImplAccess().getDefaultValueExpressionParserRuleCall_5_1_0());
					}
					lv_defaultValue_6_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getParameterImplRule());
						}
						set(
							$current,
							"defaultValue",
							lv_defaultValue_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_7=';'
		{
			newLeafNode(otherlv_7, grammarAccess.getParameterImplAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleParameterInput
entryRuleParameterInput returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterInputRule()); }
	iv_ruleParameterInput=ruleParameterInput
	{ $current=$iv_ruleParameterInput.current; }
	EOF;

// Rule ParameterInput
ruleParameterInput returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getParameterInputAccess().getParameterImplParserRuleCall());
	}
	this_ParameterImpl_0=ruleParameterImpl
	{
		$current = $this_ParameterImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleParameterInout
entryRuleParameterInout returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterInoutRule()); }
	iv_ruleParameterInout=ruleParameterInout
	{ $current=$iv_ruleParameterInout.current; }
	EOF;

// Rule ParameterInout
ruleParameterInout returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getParameterInoutAccess().getParameterImplParserRuleCall());
	}
	this_ParameterImpl_0=ruleParameterImpl
	{
		$current = $this_ParameterImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleParameterOutput
entryRuleParameterOutput returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterOutputRule()); }
	iv_ruleParameterOutput=ruleParameterOutput
	{ $current=$iv_ruleParameterOutput.current; }
	EOF;

// Rule ParameterOutput
ruleParameterOutput returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getParameterOutputAccess().getParameterImplParserRuleCall());
	}
	this_ParameterImpl_0=ruleParameterImpl
	{
		$current = $this_ParameterImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleParameterReturn
entryRuleParameterReturn returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterReturnRule()); }
	iv_ruleParameterReturn=ruleParameterReturn
	{ $current=$iv_ruleParameterReturn.current; }
	EOF;

// Rule ParameterReturn
ruleParameterReturn returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getParameterReturnAccess().getParameterImplParserRuleCall());
	}
	this_ParameterImpl_0=ruleParameterImpl
	{
		$current = $this_ParameterImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleBufferContainerType
entryRuleBufferContainerType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBufferContainerTypeRule()); }
	iv_ruleBufferContainerType=ruleBufferContainerType
	{ $current=$iv_ruleBufferContainerType.current; }
	EOF;

// Rule BufferContainerType
ruleBufferContainerType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getBufferContainerTypeAccess().getCollectionTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferContainerTypeAccess().getContainerBufferContainerKindEnumRuleCall_1_0());
				}
				lv_container_1_0=ruleBufferContainerKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferContainerTypeRule());
					}
					set(
						$current,
						"container",
						lv_container_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				otherlv_2='<'
				{
					newLeafNode(otherlv_2, grammarAccess.getBufferContainerTypeAccess().getLessThanSignKeyword_2_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getBufferContainerTypeAccess().getSizeEIntParserRuleCall_2_0_1_0_0());
							}
							lv_size_3_0=ruleEInt
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getBufferContainerTypeRule());
								}
								set(
									$current,
									"size",
									lv_size_3_0,
									"org.eclipse.efm.formalml.xtext.FormalML.EInt");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							lv_unbounded_4_0='*'
							{
								newLeafNode(lv_unbounded_4_0, grammarAccess.getBufferContainerTypeAccess().getUnboundedAsteriskKeyword_2_0_1_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getBufferContainerTypeRule());
								}
								setWithLastConsumed($current, "unbounded", true, "*");
							}
						)
					)
				)?
				otherlv_5='>'
				{
					newLeafNode(otherlv_5, grammarAccess.getBufferContainerTypeAccess().getGreaterThanSignKeyword_2_0_2());
				}
			)
			    |
			(
				otherlv_6='['
				{
					newLeafNode(otherlv_6, grammarAccess.getBufferContainerTypeAccess().getLeftSquareBracketKeyword_2_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getBufferContainerTypeAccess().getSizeEIntParserRuleCall_2_1_1_0_0());
							}
							lv_size_7_0=ruleEInt
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getBufferContainerTypeRule());
								}
								set(
									$current,
									"size",
									lv_size_7_0,
									"org.eclipse.efm.formalml.xtext.FormalML.EInt");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							lv_unbounded_8_0='*'
							{
								newLeafNode(lv_unbounded_8_0, grammarAccess.getBufferContainerTypeAccess().getUnboundedAsteriskKeyword_2_1_1_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getBufferContainerTypeRule());
								}
								setWithLastConsumed($current, "unbounded", true, "*");
							}
						)
					)
				)?
				otherlv_9=']'
				{
					newLeafNode(otherlv_9, grammarAccess.getBufferContainerTypeAccess().getRightSquareBracketKeyword_2_1_2());
				}
			)
		)?
	)
;

// Entry rule entryRuleBuffer
entryRuleBuffer returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getBufferAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getBufferRule()); }
	iv_ruleBuffer=ruleBuffer
	{ $current=$iv_ruleBuffer.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule Buffer
ruleBuffer returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getBufferAccess().getUnorderedGroup_1()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getBufferAccess().getBufferAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getBufferAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getBufferAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getBufferAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getBufferAccess().getVisibilityVisibilityKindEnumRuleCall_1_0_0());
									}
									lv_visibility_2_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getBufferRule());
										}
										set(
											$current,
											"visibility",
											lv_visibility_2_0,
											"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBufferAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getBufferAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getBufferAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getBufferAccess().getModifierModifierParserRuleCall_1_1_0());
									}
									lv_modifier_3_0=ruleModifier
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getBufferRule());
										}
										set(
											$current,
											"modifier",
											lv_modifier_3_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBufferAccess().getUnorderedGroup_1());
					}
				)
			)
					)+
					{getUnorderedGroupHelper().canLeave(grammarAccess.getBufferAccess().getUnorderedGroup_1())}?
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getBufferAccess().getUnorderedGroup_1());
				}
		)?
		otherlv_4='buffer'
		{
			newLeafNode(otherlv_4, grammarAccess.getBufferAccess().getBufferKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferAccess().getTypeBufferContainerTypeParserRuleCall_3_0());
				}
				lv_type_5_0=ruleBufferContainerType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferRule());
					}
					set(
						$current,
						"type",
						lv_type_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferAccess().getNameESIdentifierParserRuleCall_4_0());
				}
				lv_name_6_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferRule());
					}
					set(
						$current,
						"name",
						lv_name_6_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_unrestrictedName_7_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_8=';'
		{
			newLeafNode(otherlv_8, grammarAccess.getBufferAccess().getSemicolonKeyword_6());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleBufferImpl
entryRuleBufferImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBufferImplRule()); }
	iv_ruleBufferImpl=ruleBufferImpl
	{ $current=$iv_ruleBufferImpl.current; }
	EOF;

// Rule BufferImpl
ruleBufferImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getBufferImplAccess().getBufferAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferImplAccess().getModifierModifierParserRuleCall_1_0());
				}
				lv_modifier_1_0=ruleModifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferImplRule());
					}
					set(
						$current,
						"modifier",
						lv_modifier_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='buffer'
		{
			newLeafNode(otherlv_2, grammarAccess.getBufferImplAccess().getBufferKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferImplAccess().getTypeBufferContainerTypeParserRuleCall_3_0());
				}
				lv_type_3_0=ruleBufferContainerType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferImplRule());
					}
					set(
						$current,
						"type",
						lv_type_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BufferContainerType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferImplAccess().getNameESIdentifierParserRuleCall_4_0());
				}
				lv_name_4_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferImplRule());
					}
					set(
						$current,
						"name",
						lv_name_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_unrestrictedName_5_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_6=';'
		{
			newLeafNode(otherlv_6, grammarAccess.getBufferImplAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleBufferPublic
entryRuleBufferPublic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBufferPublicRule()); }
	iv_ruleBufferPublic=ruleBufferPublic
	{ $current=$iv_ruleBufferPublic.current; }
	EOF;

// Rule BufferPublic
ruleBufferPublic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getBufferPublicAccess().getBufferImplParserRuleCall());
	}
	this_BufferImpl_0=ruleBufferImpl
	{
		$current = $this_BufferImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleBufferProtected
entryRuleBufferProtected returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBufferProtectedRule()); }
	iv_ruleBufferProtected=ruleBufferProtected
	{ $current=$iv_ruleBufferProtected.current; }
	EOF;

// Rule BufferProtected
ruleBufferProtected returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getBufferProtectedAccess().getBufferImplParserRuleCall());
	}
	this_BufferImpl_0=ruleBufferImpl
	{
		$current = $this_BufferImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleBufferPrivate
entryRuleBufferPrivate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBufferPrivateRule()); }
	iv_ruleBufferPrivate=ruleBufferPrivate
	{ $current=$iv_ruleBufferPrivate.current; }
	EOF;

// Rule BufferPrivate
ruleBufferPrivate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getBufferPrivateAccess().getBufferImplParserRuleCall());
	}
	this_BufferImpl_0=ruleBufferImpl
	{
		$current = $this_BufferImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRulePort
entryRulePort returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getPortAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getPortRule()); }
	iv_rulePort=rulePort
	{ $current=$iv_rulePort.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule Port
rulePort returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getPortAccess().getUnorderedGroup_1()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPortAccess().getPortAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getPortAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPortAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPortAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getPortAccess().getVisibilityVisibilityKindEnumRuleCall_1_0_0());
									}
									lv_visibility_2_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getPortRule());
										}
										set(
											$current,
											"visibility",
											lv_visibility_2_0,
											"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPortAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPortAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPortAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getPortAccess().getModifierModifierParserRuleCall_1_1_0());
									}
									lv_modifier_3_0=ruleModifier
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getPortRule());
										}
										set(
											$current,
											"modifier",
											lv_modifier_3_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPortAccess().getUnorderedGroup_1());
					}
				)
			)
					)+
					{getUnorderedGroupHelper().canLeave(grammarAccess.getPortAccess().getUnorderedGroup_1())}?
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getPortAccess().getUnorderedGroup_1());
				}
		)?
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getPortAccess().getDirectionChannelDirectionEnumRuleCall_2_0_0_0());
						}
						lv_direction_4_0=ruleChannelDirection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPortRule());
							}
							set(
								$current,
								"direction",
								lv_direction_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_5='port'
				{
					newLeafNode(otherlv_5, grammarAccess.getPortAccess().getPortKeyword_2_0_1());
				}
			)
			    |
			(
				otherlv_6='port'
				{
					newLeafNode(otherlv_6, grammarAccess.getPortAccess().getPortKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPortAccess().getDirectionChannelDirectionEnumRuleCall_2_1_1_0());
						}
						lv_direction_7_0=ruleChannelDirection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPortRule());
							}
							set(
								$current,
								"direction",
								lv_direction_7_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPortAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_8_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPortRule());
					}
					set(
						$current,
						"name",
						lv_name_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPortAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_9_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPortRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_9_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_10='('
			{
				newLeafNode(otherlv_10, grammarAccess.getPortAccess().getLeftParenthesisKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getPortAccess().getParameterFormalParameterParserRuleCall_5_1_0());
					}
					lv_parameter_11_0=ruleFormalParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPortRule());
						}
						add(
							$current,
							"parameter",
							lv_parameter_11_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_12=','
				{
					newLeafNode(otherlv_12, grammarAccess.getPortAccess().getCommaKeyword_5_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPortAccess().getParameterFormalParameterParserRuleCall_5_2_1_0());
						}
						lv_parameter_13_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPortRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_13_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_14=')'
			{
				newLeafNode(otherlv_14, grammarAccess.getPortAccess().getRightParenthesisKeyword_5_3());
			}
		)?
		otherlv_15=';'
		{
			newLeafNode(otherlv_15, grammarAccess.getPortAccess().getSemicolonKeyword_6());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRulePortImpl
entryRulePortImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPortImplRule()); }
	iv_rulePortImpl=rulePortImpl
	{ $current=$iv_rulePortImpl.current; }
	EOF;

// Rule PortImpl
rulePortImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getPortImplAccess().getPortAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPortImplAccess().getModifierModifierParserRuleCall_1_0());
				}
				lv_modifier_1_0=ruleModifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPortImplRule());
					}
					set(
						$current,
						"modifier",
						lv_modifier_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getPortImplAccess().getDirectionChannelDirectionEnumRuleCall_2_0_0_0());
						}
						lv_direction_2_0=ruleChannelDirection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPortImplRule());
							}
							set(
								$current,
								"direction",
								lv_direction_2_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_3='port'
				{
					newLeafNode(otherlv_3, grammarAccess.getPortImplAccess().getPortKeyword_2_0_1());
				}
			)
			    |
			(
				otherlv_4='port'
				{
					newLeafNode(otherlv_4, grammarAccess.getPortImplAccess().getPortKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPortImplAccess().getDirectionChannelDirectionEnumRuleCall_2_1_1_0());
						}
						lv_direction_5_0=ruleChannelDirection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPortImplRule());
							}
							set(
								$current,
								"direction",
								lv_direction_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPortImplAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_6_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPortImplRule());
					}
					set(
						$current,
						"name",
						lv_name_6_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPortImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_7_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPortImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_8='('
			{
				newLeafNode(otherlv_8, grammarAccess.getPortImplAccess().getLeftParenthesisKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getPortImplAccess().getParameterFormalParameterParserRuleCall_5_1_0());
					}
					lv_parameter_9_0=ruleFormalParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPortImplRule());
						}
						add(
							$current,
							"parameter",
							lv_parameter_9_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_10=','
				{
					newLeafNode(otherlv_10, grammarAccess.getPortImplAccess().getCommaKeyword_5_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPortImplAccess().getParameterFormalParameterParserRuleCall_5_2_1_0());
						}
						lv_parameter_11_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPortImplRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_11_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_12=')'
			{
				newLeafNode(otherlv_12, grammarAccess.getPortImplAccess().getRightParenthesisKeyword_5_3());
			}
		)?
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getPortImplAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRulePortPublic
entryRulePortPublic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPortPublicRule()); }
	iv_rulePortPublic=rulePortPublic
	{ $current=$iv_rulePortPublic.current; }
	EOF;

// Rule PortPublic
rulePortPublic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getPortPublicAccess().getPortImplParserRuleCall());
	}
	this_PortImpl_0=rulePortImpl
	{
		$current = $this_PortImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRulePortProtected
entryRulePortProtected returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPortProtectedRule()); }
	iv_rulePortProtected=rulePortProtected
	{ $current=$iv_rulePortProtected.current; }
	EOF;

// Rule PortProtected
rulePortProtected returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getPortProtectedAccess().getPortImplParserRuleCall());
	}
	this_PortImpl_0=rulePortImpl
	{
		$current = $this_PortImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRulePortPrivate
entryRulePortPrivate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPortPrivateRule()); }
	iv_rulePortPrivate=rulePortPrivate
	{ $current=$iv_rulePortPrivate.current; }
	EOF;

// Rule PortPrivate
rulePortPrivate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getPortPrivateAccess().getPortImplParserRuleCall());
	}
	this_PortImpl_0=rulePortImpl
	{
		$current = $this_PortImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleSignal
entryRuleSignal returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignalRule()); }
	iv_ruleSignal=ruleSignal
	{ $current=$iv_ruleSignal.current; }
	EOF;

// Rule Signal
ruleSignal returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getSignalAccess().getSignalAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSignalAccess().getVisibilityVisibilityKindEnumRuleCall_1_0());
				}
				lv_visibility_1_0=ruleVisibilityKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignalRule());
					}
					set(
						$current,
						"visibility",
						lv_visibility_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getSignalAccess().getDirectionChannelDirectionEnumRuleCall_2_0_0_0());
						}
						lv_direction_2_0=ruleChannelDirection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSignalRule());
							}
							set(
								$current,
								"direction",
								lv_direction_2_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_3='signal'
				{
					newLeafNode(otherlv_3, grammarAccess.getSignalAccess().getSignalKeyword_2_0_1());
				}
			)
			    |
			(
				otherlv_4='signal'
				{
					newLeafNode(otherlv_4, grammarAccess.getSignalAccess().getSignalKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSignalAccess().getDirectionChannelDirectionEnumRuleCall_2_1_1_0());
						}
						lv_direction_5_0=ruleChannelDirection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSignalRule());
							}
							set(
								$current,
								"direction",
								lv_direction_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSignalAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_6_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignalRule());
					}
					set(
						$current,
						"name",
						lv_name_6_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSignalAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_7_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignalRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_8='('
			{
				newLeafNode(otherlv_8, grammarAccess.getSignalAccess().getLeftParenthesisKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSignalAccess().getParameterFormalParameterParserRuleCall_5_1_0());
					}
					lv_parameter_9_0=ruleFormalParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSignalRule());
						}
						add(
							$current,
							"parameter",
							lv_parameter_9_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_10=','
				{
					newLeafNode(otherlv_10, grammarAccess.getSignalAccess().getCommaKeyword_5_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSignalAccess().getParameterFormalParameterParserRuleCall_5_2_1_0());
						}
						lv_parameter_11_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSignalRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_11_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_12=')'
			{
				newLeafNode(otherlv_12, grammarAccess.getSignalAccess().getRightParenthesisKeyword_5_3());
			}
		)?
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getSignalAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleSignalImpl
entryRuleSignalImpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignalImplRule()); }
	iv_ruleSignalImpl=ruleSignalImpl
	{ $current=$iv_ruleSignalImpl.current; }
	EOF;

// Rule SignalImpl
ruleSignalImpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getSignalImplAccess().getSignalAction_0(),
					$current);
			}
		)
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getSignalImplAccess().getDirectionChannelDirectionEnumRuleCall_1_0_0_0());
						}
						lv_direction_1_0=ruleChannelDirection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSignalImplRule());
							}
							set(
								$current,
								"direction",
								lv_direction_1_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_2='signal'
				{
					newLeafNode(otherlv_2, grammarAccess.getSignalImplAccess().getSignalKeyword_1_0_1());
				}
			)
			    |
			(
				otherlv_3='signal'
				{
					newLeafNode(otherlv_3, grammarAccess.getSignalImplAccess().getSignalKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSignalImplAccess().getDirectionChannelDirectionEnumRuleCall_1_1_1_0());
						}
						lv_direction_4_0=ruleChannelDirection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSignalImplRule());
							}
							set(
								$current,
								"direction",
								lv_direction_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSignalImplAccess().getNameESIdentifierParserRuleCall_2_0());
				}
				lv_name_5_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignalImplRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSignalImplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_3_0());
				}
				lv_unrestrictedName_6_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignalImplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_6_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_7='('
			{
				newLeafNode(otherlv_7, grammarAccess.getSignalImplAccess().getLeftParenthesisKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSignalImplAccess().getParameterFormalParameterParserRuleCall_4_1_0());
					}
					lv_parameter_8_0=ruleFormalParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSignalImplRule());
						}
						add(
							$current,
							"parameter",
							lv_parameter_8_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_9=','
				{
					newLeafNode(otherlv_9, grammarAccess.getSignalImplAccess().getCommaKeyword_4_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSignalImplAccess().getParameterFormalParameterParserRuleCall_4_2_1_0());
						}
						lv_parameter_10_0=ruleFormalParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSignalImplRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_11=')'
			{
				newLeafNode(otherlv_11, grammarAccess.getSignalImplAccess().getRightParenthesisKeyword_4_3());
			}
		)?
		otherlv_12=';'
		{
			newLeafNode(otherlv_12, grammarAccess.getSignalImplAccess().getSemicolonKeyword_5());
		}
	)
;

// Entry rule entryRuleSignalPublic
entryRuleSignalPublic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignalPublicRule()); }
	iv_ruleSignalPublic=ruleSignalPublic
	{ $current=$iv_ruleSignalPublic.current; }
	EOF;

// Rule SignalPublic
ruleSignalPublic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getSignalPublicAccess().getSignalImplParserRuleCall());
	}
	this_SignalImpl_0=ruleSignalImpl
	{
		$current = $this_SignalImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleSignalProtected
entryRuleSignalProtected returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignalProtectedRule()); }
	iv_ruleSignalProtected=ruleSignalProtected
	{ $current=$iv_ruleSignalProtected.current; }
	EOF;

// Rule SignalProtected
ruleSignalProtected returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getSignalProtectedAccess().getSignalImplParserRuleCall());
	}
	this_SignalImpl_0=ruleSignalImpl
	{
		$current = $this_SignalImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleSignalPrivate
entryRuleSignalPrivate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignalPrivateRule()); }
	iv_ruleSignalPrivate=ruleSignalPrivate
	{ $current=$iv_ruleSignalPrivate.current; }
	EOF;

// Rule SignalPrivate
ruleSignalPrivate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getSignalPrivateAccess().getSignalImplParserRuleCall());
	}
	this_SignalImpl_0=ruleSignalImpl
	{
		$current = $this_SignalImpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleChannel
entryRuleChannel returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getChannelAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getChannelRule()); }
	iv_ruleChannel=ruleChannel
	{ $current=$iv_ruleChannel.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule Channel
ruleChannel returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getChannelAccess().getUnorderedGroup_1()
	);
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getChannelAccess().getChannelAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getChannelAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getChannelAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getChannelAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getChannelAccess().getVisibilityVisibilityKindEnumRuleCall_1_0_0());
									}
									lv_visibility_2_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getChannelRule());
										}
										set(
											$current,
											"visibility",
											lv_visibility_2_0,
											"org.eclipse.efm.formalml.xtext.FormalML.VisibilityKind");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getChannelAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getChannelAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getChannelAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getChannelAccess().getModifierModifierParserRuleCall_1_1_0());
									}
									lv_modifier_3_0=ruleModifier
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getChannelRule());
										}
										set(
											$current,
											"modifier",
											lv_modifier_3_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
										afterParserOrEnumRuleCall();
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getChannelAccess().getUnorderedGroup_1());
					}
				)
			)
					)+
					{getUnorderedGroupHelper().canLeave(grammarAccess.getChannelAccess().getUnorderedGroup_1())}?
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getChannelAccess().getUnorderedGroup_1());
				}
		)?
		otherlv_4='channel'
		{
			newLeafNode(otherlv_4, grammarAccess.getChannelAccess().getChannelKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChannelAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_5_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChannelRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getChannelAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_6_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChannelRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_6_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_7='{'
		{
			newLeafNode(otherlv_7, grammarAccess.getChannelAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getChannelAccess().getSignalSignalReferenceParserRuleCall_6_0_0());
					}
					lv_signal_8_0=ruleSignalReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getChannelRule());
						}
						add(
							$current,
							"signal",
							lv_signal_8_0,
							"org.eclipse.efm.formalml.xtext.FormalML.SignalReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_9=';'
			{
				newLeafNode(otherlv_9, grammarAccess.getChannelAccess().getSemicolonKeyword_6_1());
			}
		)+
		otherlv_10='}'
		{
			newLeafNode(otherlv_10, grammarAccess.getChannelAccess().getRightCurlyBracketKeyword_7());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleSignalReference
entryRuleSignalReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignalReferenceRule()); }
	iv_ruleSignalReference=ruleSignalReference
	{ $current=$iv_ruleSignalReference.current; }
	EOF;

// Rule SignalReference
ruleSignalReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSignalReferenceAccess().getDirectionChannelDirectionEnumRuleCall_0_0());
				}
				lv_direction_0_0=ruleChannelDirection
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignalReferenceRule());
					}
					set(
						$current,
						"direction",
						lv_direction_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ChannelDirection");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getSignalReferenceAccess().getNameESIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignalReferenceRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleChannelimpl
entryRuleChannelimpl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChannelimplRule()); }
	iv_ruleChannelimpl=ruleChannelimpl
	{ $current=$iv_ruleChannelimpl.current; }
	EOF;

// Rule Channelimpl
ruleChannelimpl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getChannelimplAccess().getChannelAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getChannelimplAccess().getModifierModifierParserRuleCall_1_0());
				}
				lv_modifier_1_0=ruleModifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChannelimplRule());
					}
					set(
						$current,
						"modifier",
						lv_modifier_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2='channel'
		{
			newLeafNode(otherlv_2, grammarAccess.getChannelimplAccess().getChannelKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChannelimplAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChannelimplRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getChannelimplAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_4_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChannelimplRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getChannelimplAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getChannelimplAccess().getSignalSignalReferenceParserRuleCall_6_0_0());
					}
					lv_signal_6_0=ruleSignalReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getChannelimplRule());
						}
						add(
							$current,
							"signal",
							lv_signal_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.SignalReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_7=';'
			{
				newLeafNode(otherlv_7, grammarAccess.getChannelimplAccess().getSemicolonKeyword_6_1());
			}
		)+
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getChannelimplAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleChannelPublic
entryRuleChannelPublic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChannelPublicRule()); }
	iv_ruleChannelPublic=ruleChannelPublic
	{ $current=$iv_ruleChannelPublic.current; }
	EOF;

// Rule ChannelPublic
ruleChannelPublic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getChannelPublicAccess().getChannelimplParserRuleCall());
	}
	this_Channelimpl_0=ruleChannelimpl
	{
		$current = $this_Channelimpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleChannelProtected
entryRuleChannelProtected returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChannelProtectedRule()); }
	iv_ruleChannelProtected=ruleChannelProtected
	{ $current=$iv_ruleChannelProtected.current; }
	EOF;

// Rule ChannelProtected
ruleChannelProtected returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getChannelProtectedAccess().getChannelimplParserRuleCall());
	}
	this_Channelimpl_0=ruleChannelimpl
	{
		$current = $this_Channelimpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleChannelPrivate
entryRuleChannelPrivate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChannelPrivateRule()); }
	iv_ruleChannelPrivate=ruleChannelPrivate
	{ $current=$iv_ruleChannelPrivate.current; }
	EOF;

// Rule ChannelPrivate
ruleChannelPrivate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getChannelPrivateAccess().getChannelimplParserRuleCall());
	}
	this_Channelimpl_0=ruleChannelimpl
	{
		$current = $this_Channelimpl_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleTransition
entryRuleTransition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionRule()); }
	iv_ruleTransition=ruleTransition
	{ $current=$iv_ruleTransition.current; }
	EOF;

// Rule Transition
ruleTransition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getTransitionAccess().getTransitionAction_0(),
					$current);
			}
		)
		(
			(
				lv_transient_1_0='transient'
				{
					newLeafNode(lv_transient_1_0, grammarAccess.getTransitionAccess().getTransientTransientKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTransitionRule());
					}
					setWithLastConsumed($current, "transient", true, "transient");
				}
			)
		)?
		otherlv_2='transition'
		{
			newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getTransitionKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionAccess().getMoeTransitionMoeParserRuleCall_3_0());
				}
				lv_moe_3_0=ruleTransitionMoe
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransitionRule());
					}
					set(
						$current,
						"moe",
						lv_moe_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.TransitionMoe");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTransitionAccess().getNameESIdentifierParserRuleCall_4_0_0());
					}
					lv_name_4_0=ruleESIdentifier
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransitionRule());
						}
						set(
							$current,
							"name",
							lv_name_4_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getTransitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_1_0());
					}
					lv_unrestrictedName_5_0=ruleUnrestrictedName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransitionRule());
						}
						set(
							$current,
							"unrestrictedName",
							lv_unrestrictedName_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
						afterParserOrEnumRuleCall();
					}
				)
			)?
		)?
		(
			(
				otherlv_6='{'
				{
					newLeafNode(otherlv_6, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_5_0_0());
				}
				(
					(
						(
							otherlv_7='@trigger:'
							{
								newLeafNode(otherlv_7, grammarAccess.getTransitionAccess().getTriggerKeyword_5_0_1_0_0_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getTransitionAccess().getTriggerTransitionTriggerParserRuleCall_5_0_1_0_0_1_0());
									}
									lv_trigger_8_0=ruleTransitionTrigger
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getTransitionRule());
										}
										add(
											$current,
											"trigger",
											lv_trigger_8_0,
											"org.eclipse.efm.formalml.xtext.FormalML.TransitionTrigger");
										afterParserOrEnumRuleCall();
									}
								)
							)*
						)?
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getTransitionAccess().getGuardTransitionGuardParserRuleCall_5_0_1_0_1_0_0());
									}
									lv_guard_9_0=ruleTransitionGuard
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getTransitionRule());
										}
										set(
											$current,
											"guard",
											lv_guard_9_0,
											"org.eclipse.efm.formalml.xtext.FormalML.TransitionGuard");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							otherlv_10='@guard:'
							{
								newLeafNode(otherlv_10, grammarAccess.getTransitionAccess().getGuardKeyword_5_0_1_0_1_1());
							}
						)?
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getTransitionAccess().getTguardTransitionTimedGuardParserRuleCall_5_0_1_0_2_0_0());
									}
									lv_tguard_11_0=ruleTransitionTimedGuard
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getTransitionRule());
										}
										set(
											$current,
											"tguard",
											lv_tguard_11_0,
											"org.eclipse.efm.formalml.xtext.FormalML.TransitionTimedGuard");
										afterParserOrEnumRuleCall();
									}
								)
							)
							    |
							otherlv_12='@tguard:'
							{
								newLeafNode(otherlv_12, grammarAccess.getTransitionAccess().getTguardKeyword_5_0_1_0_2_1());
							}
						)?
						otherlv_13='@effect:'
						{
							newLeafNode(otherlv_13, grammarAccess.getTransitionAccess().getEffectKeyword_5_0_1_0_3());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getTransitionAccess().getEffectTransitionEffectParserRuleCall_5_0_1_0_4_0());
								}
								lv_effect_14_0=ruleTransitionEffect
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTransitionRule());
									}
									set(
										$current,
										"effect",
										lv_effect_14_0,
										"org.eclipse.efm.formalml.xtext.FormalML.TransitionEffect");
									afterParserOrEnumRuleCall();
								}
							)
						)?
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getTransitionAccess().getBehaviorTransitionBehaviorParserRuleCall_5_0_1_1_0());
							}
							lv_behavior_15_0=ruleTransitionBehavior
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTransitionRule());
								}
								set(
									$current,
									"behavior",
									lv_behavior_15_0,
									"org.eclipse.efm.formalml.xtext.FormalML.TransitionBehavior");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				otherlv_16='}'
				{
					newLeafNode(otherlv_16, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_5_0_2());
				}
				(
					otherlv_17='-->'
					{
						newLeafNode(otherlv_17, grammarAccess.getTransitionAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_5_0_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTransitionAccess().getTargetValuePureNamedMachineExpressionParserRuleCall_5_0_3_1_0());
							}
							lv_target_18_0=ruleValuePureNamedMachineExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTransitionRule());
								}
								set(
									$current,
									"target",
									lv_target_18_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ValuePureNamedMachineExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_19=';'
					{
						newLeafNode(otherlv_19, grammarAccess.getTransitionAccess().getSemicolonKeyword_5_0_3_2());
					}
				)?
			)
			    |
			(
				otherlv_20='-->'
				{
					newLeafNode(otherlv_20, grammarAccess.getTransitionAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_5_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTransitionAccess().getTargetValuePureNamedMachineExpressionParserRuleCall_5_1_1_0());
						}
						lv_target_21_0=ruleValuePureNamedMachineExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTransitionRule());
							}
							set(
								$current,
								"target",
								lv_target_21_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ValuePureNamedMachineExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						otherlv_22='{'
						{
							newLeafNode(otherlv_22, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_5_1_2_0_0());
						}
						(
							(
								(
									otherlv_23='@trigger:'
									{
										newLeafNode(otherlv_23, grammarAccess.getTransitionAccess().getTriggerKeyword_5_1_2_0_1_0_0_0());
									}
									(
										(
											{
												newCompositeNode(grammarAccess.getTransitionAccess().getTriggerTransitionTriggerParserRuleCall_5_1_2_0_1_0_0_1_0());
											}
											lv_trigger_24_0=ruleTransitionTrigger
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getTransitionRule());
												}
												add(
													$current,
													"trigger",
													lv_trigger_24_0,
													"org.eclipse.efm.formalml.xtext.FormalML.TransitionTrigger");
												afterParserOrEnumRuleCall();
											}
										)
									)*
								)?
								(
									(
										(
											{
												newCompositeNode(grammarAccess.getTransitionAccess().getGuardTransitionGuardParserRuleCall_5_1_2_0_1_0_1_0_0());
											}
											lv_guard_25_0=ruleTransitionGuard
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getTransitionRule());
												}
												set(
													$current,
													"guard",
													lv_guard_25_0,
													"org.eclipse.efm.formalml.xtext.FormalML.TransitionGuard");
												afterParserOrEnumRuleCall();
											}
										)
									)
									    |
									otherlv_26='@guard:'
									{
										newLeafNode(otherlv_26, grammarAccess.getTransitionAccess().getGuardKeyword_5_1_2_0_1_0_1_1());
									}
								)?
								(
									(
										(
											{
												newCompositeNode(grammarAccess.getTransitionAccess().getTguardTransitionTimedGuardParserRuleCall_5_1_2_0_1_0_2_0_0());
											}
											lv_tguard_27_0=ruleTransitionTimedGuard
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getTransitionRule());
												}
												set(
													$current,
													"tguard",
													lv_tguard_27_0,
													"org.eclipse.efm.formalml.xtext.FormalML.TransitionTimedGuard");
												afterParserOrEnumRuleCall();
											}
										)
									)
									    |
									otherlv_28='@tguard:'
									{
										newLeafNode(otherlv_28, grammarAccess.getTransitionAccess().getTguardKeyword_5_1_2_0_1_0_2_1());
									}
								)?
								otherlv_29='@effect:'
								{
									newLeafNode(otherlv_29, grammarAccess.getTransitionAccess().getEffectKeyword_5_1_2_0_1_0_3());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getTransitionAccess().getEffectTransitionEffectParserRuleCall_5_1_2_0_1_0_4_0());
										}
										lv_effect_30_0=ruleTransitionEffect
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getTransitionRule());
											}
											set(
												$current,
												"effect",
												lv_effect_30_0,
												"org.eclipse.efm.formalml.xtext.FormalML.TransitionEffect");
											afterParserOrEnumRuleCall();
										}
									)
								)?
							)
							    |
							(
								(
									{
										newCompositeNode(grammarAccess.getTransitionAccess().getBehaviorTransitionBehaviorParserRuleCall_5_1_2_0_1_1_0());
									}
									lv_behavior_31_0=ruleTransitionBehavior
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getTransitionRule());
										}
										set(
											$current,
											"behavior",
											lv_behavior_31_0,
											"org.eclipse.efm.formalml.xtext.FormalML.TransitionBehavior");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)?
						otherlv_32='}'
						{
							newLeafNode(otherlv_32, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_5_1_2_0_2());
						}
					)
					    |
					otherlv_33=';'
					{
						newLeafNode(otherlv_33, grammarAccess.getTransitionAccess().getSemicolonKeyword_5_1_2_1());
					}
				)
			)
		)
	)
;

// Entry rule entryRuleTransitionMoe
entryRuleTransitionMoe returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionMoeRule()); }
	iv_ruleTransitionMoe=ruleTransitionMoe
	{ $current=$iv_ruleTransitionMoe.current; }
	EOF;

// Rule TransitionMoe
ruleTransitionMoe returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='<'
		{
			newLeafNode(otherlv_0, grammarAccess.getTransitionMoeAccess().getLessThanSignKeyword_0());
		}
		(
			(
				(
					otherlv_1='moc:'
					{
						newLeafNode(otherlv_1, grammarAccess.getTransitionMoeAccess().getMocKeyword_1_0_0());
					}
				)?
				(
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getTransitionMoeAccess().getMocTransitionMocEnumRuleCall_1_0_1_0_0_0());
								}
								lv_moc_2_0=ruleTransitionMoc
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTransitionMoeRule());
									}
									set(
										$current,
										"moc",
										lv_moc_2_0,
										"org.eclipse.efm.formalml.xtext.FormalML.TransitionMoc");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							otherlv_3='&'
							{
								newLeafNode(otherlv_3, grammarAccess.getTransitionMoeAccess().getAmpersandKeyword_1_0_1_0_1_0());
							}
							(
								(
									lv_isElse_4_0='else'
									{
										newLeafNode(lv_isElse_4_0, grammarAccess.getTransitionMoeAccess().getIsElseElseKeyword_1_0_1_0_1_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getTransitionMoeRule());
										}
										setWithLastConsumed($current, "isElse", true, "else");
									}
								)
							)
						)?
					)
					    |
					(
						(
							lv_isElse_5_0='else'
							{
								newLeafNode(lv_isElse_5_0, grammarAccess.getTransitionMoeAccess().getIsElseElseKeyword_1_0_1_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getTransitionMoeRule());
								}
								setWithLastConsumed($current, "isElse", true, "else");
							}
						)
					)
				)
				(
					otherlv_6=','
					{
						newLeafNode(otherlv_6, grammarAccess.getTransitionMoeAccess().getCommaKeyword_1_0_2_0());
					}
					(
						otherlv_7='prior:'
						{
							newLeafNode(otherlv_7, grammarAccess.getTransitionMoeAccess().getPriorKeyword_1_0_2_1());
						}
					)?
					(
						(
							{
								newCompositeNode(grammarAccess.getTransitionMoeAccess().getPriorEIntParserRuleCall_1_0_2_2_0());
							}
							lv_prior_8_0=ruleEInt
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTransitionMoeRule());
								}
								set(
									$current,
									"prior",
									lv_prior_8_0,
									"org.eclipse.efm.formalml.xtext.FormalML.EInt");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
			)
			    |
			(
				(
					otherlv_9='prior:'
					{
						newLeafNode(otherlv_9, grammarAccess.getTransitionMoeAccess().getPriorKeyword_1_1_0());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getTransitionMoeAccess().getPriorEIntParserRuleCall_1_1_1_0());
						}
						lv_prior_10_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTransitionMoeRule());
							}
							set(
								$current,
								"prior",
								lv_prior_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)
		otherlv_11='>'
		{
			newLeafNode(otherlv_11, grammarAccess.getTransitionMoeAccess().getGreaterThanSignKeyword_2());
		}
	)
;

// Entry rule entryRuleTransitionBehavior
entryRuleTransitionBehavior returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionBehaviorRule()); }
	iv_ruleTransitionBehavior=ruleTransitionBehavior
	{ $current=$iv_ruleTransitionBehavior.current; }
	EOF;

// Rule TransitionBehavior
ruleTransitionBehavior returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getTransitionBehaviorAccess().getBlockStatementAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionBehaviorAccess().getOpBlockStatementSchedulerParserRuleCall_1_0());
				}
				lv_op_1_0=ruleBlockStatementScheduler
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransitionBehaviorRule());
					}
					set(
						$current,
						"op",
						lv_op_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatementScheduler");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionBehaviorAccess().getStatementStatementParserRuleCall_2_0());
				}
				lv_statement_2_0=ruleStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransitionBehaviorRule());
					}
					add(
						$current,
						"statement",
						lv_statement_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Statement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleTransitionTrigger
entryRuleTransitionTrigger returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionTriggerRule()); }
	iv_ruleTransitionTrigger=ruleTransitionTrigger
	{ $current=$iv_ruleTransitionTrigger.current; }
	EOF;

// Rule TransitionTrigger
ruleTransitionTrigger returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getTransitionTriggerAccess().getInputComStatementParserRuleCall());
	}
	this_InputComStatement_0=ruleInputComStatement
	{
		$current = $this_InputComStatement_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleTransitionGuard
entryRuleTransitionGuard returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionGuardRule()); }
	iv_ruleTransitionGuard=ruleTransitionGuard
	{ $current=$iv_ruleTransitionGuard.current; }
	EOF;

// Rule TransitionGuard
ruleTransitionGuard returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getTransitionGuardAccess().getGuardStatementAction_0_0(),
						$current);
				}
			)
			otherlv_1='@guard<'
			{
				newLeafNode(otherlv_1, grammarAccess.getTransitionGuardAccess().getGuardKeyword_0_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTransitionGuardAccess().getConditionTransitionGuardExpressionParserRuleCall_0_2_0());
					}
					lv_condition_2_0=ruleTransitionGuardExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransitionGuardRule());
						}
						set(
							$current,
							"condition",
							lv_condition_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.TransitionGuardExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			otherlv_3='@guard:'
			{
				newLeafNode(otherlv_3, grammarAccess.getTransitionGuardAccess().getGuardKeyword_1_0());
			}
			(
				(
					(
						{
							/* */
						}
						{
							$current = forceCreateModelElement(
								grammarAccess.getTransitionGuardAccess().getGuardStatementAction_1_1_0_0(),
								$current);
						}
					)
					(
						(
							otherlv_5='['
							{
								newLeafNode(otherlv_5, grammarAccess.getTransitionGuardAccess().getLeftSquareBracketKeyword_1_1_0_1_0_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getTransitionGuardAccess().getConditionExpressionParserRuleCall_1_1_0_1_0_1_0());
									}
									lv_condition_6_0=ruleExpression
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getTransitionGuardRule());
										}
										set(
											$current,
											"condition",
											lv_condition_6_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Expression");
										afterParserOrEnumRuleCall();
									}
								)
							)
							otherlv_7=']'
							{
								newLeafNode(otherlv_7, grammarAccess.getTransitionGuardAccess().getRightSquareBracketKeyword_1_1_0_1_0_2());
							}
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getTransitionGuardAccess().getConditionExpressionParserRuleCall_1_1_0_1_1_0());
								}
								lv_condition_8_0=ruleExpression
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTransitionGuardRule());
									}
									set(
										$current,
										"condition",
										lv_condition_8_0,
										"org.eclipse.efm.formalml.xtext.FormalML.Expression");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				    |
				{
					/* */
				}
				{
					newCompositeNode(grammarAccess.getTransitionGuardAccess().getGuardStatementParserRuleCall_1_1_1());
				}
				this_GuardStatement_9=ruleGuardStatement
				{
					$current = $this_GuardStatement_9.current;
					afterParserOrEnumRuleCall();
				}
				    |
				{
					/* */
				}
				{
					newCompositeNode(grammarAccess.getTransitionGuardAccess().getEventGuardStatementParserRuleCall_1_1_2());
				}
				this_EventGuardStatement_10=ruleEventGuardStatement
				{
					$current = $this_EventGuardStatement_10.current;
					afterParserOrEnumRuleCall();
				}
				    |
				{
					/* */
				}
				{
					newCompositeNode(grammarAccess.getTransitionGuardAccess().getCheckSatGuardStatementParserRuleCall_1_1_3());
				}
				this_CheckSatGuardStatement_11=ruleCheckSatGuardStatement
				{
					$current = $this_CheckSatGuardStatement_11.current;
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleTransitionGuardExpression
entryRuleTransitionGuardExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionGuardExpressionRule()); }
	iv_ruleTransitionGuardExpression=ruleTransitionGuardExpression
	{ $current=$iv_ruleTransitionGuardExpression.current; }
	EOF;

// Rule TransitionGuardExpression
ruleTransitionGuardExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getTransitionGuardExpressionAccess().getLogicalAssociativeExpressionAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_operator_1_1='&&'
					{
						newLeafNode(lv_operator_1_1, grammarAccess.getTransitionGuardExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTransitionGuardExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_1_1, null);
					}
					    |
					lv_operator_1_2='and'
					{
						newLeafNode(lv_operator_1_2, grammarAccess.getTransitionGuardExpressionAccess().getOperatorAndKeyword_1_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTransitionGuardExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_1_2, null);
					}
					    |
					lv_operator_1_3='||'
					{
						newLeafNode(lv_operator_1_3, grammarAccess.getTransitionGuardExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTransitionGuardExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_1_3, null);
					}
					    |
					lv_operator_1_4='or'
					{
						newLeafNode(lv_operator_1_4, grammarAccess.getTransitionGuardExpressionAccess().getOperatorOrKeyword_1_0_3());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTransitionGuardExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_1_4, null);
					}
				)
			)
		)
		otherlv_2='>:'
		{
			newLeafNode(otherlv_2, grammarAccess.getTransitionGuardExpressionAccess().getGreaterThanSignColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionGuardExpressionAccess().getOperandBitwiseOrExpressionParserRuleCall_3_0());
				}
				lv_operand_3_0=ruleBitwiseOrExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransitionGuardExpressionRule());
					}
					add(
						$current,
						"operand",
						lv_operand_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BitwiseOrExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)+
	)
;

// Entry rule entryRuleTransitionTimedGuard
entryRuleTransitionTimedGuard returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionTimedGuardRule()); }
	iv_ruleTransitionTimedGuard=ruleTransitionTimedGuard
	{ $current=$iv_ruleTransitionTimedGuard.current; }
	EOF;

// Rule TransitionTimedGuard
ruleTransitionTimedGuard returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getTransitionTimedGuardAccess().getTimedGuardStatementAction_0_0(),
						$current);
				}
			)
			otherlv_1='@tguard<'
			{
				newLeafNode(otherlv_1, grammarAccess.getTransitionTimedGuardAccess().getTguardKeyword_0_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTransitionTimedGuardAccess().getConditionTransitionGuardExpressionParserRuleCall_0_2_0());
					}
					lv_condition_2_0=ruleTransitionGuardExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransitionTimedGuardRule());
						}
						set(
							$current,
							"condition",
							lv_condition_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.TransitionGuardExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			otherlv_3='@tguard:'
			{
				newLeafNode(otherlv_3, grammarAccess.getTransitionTimedGuardAccess().getTguardKeyword_1_0());
			}
			(
				(
					(
						{
							/* */
						}
						{
							$current = forceCreateModelElement(
								grammarAccess.getTransitionTimedGuardAccess().getTimedGuardStatementAction_1_1_0_0(),
								$current);
						}
					)
					(
						(
							otherlv_5='{'
							{
								newLeafNode(otherlv_5, grammarAccess.getTransitionTimedGuardAccess().getLeftCurlyBracketKeyword_1_1_0_1_0_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getTransitionTimedGuardAccess().getConditionExpressionParserRuleCall_1_1_0_1_0_1_0());
									}
									lv_condition_6_0=ruleExpression
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getTransitionTimedGuardRule());
										}
										set(
											$current,
											"condition",
											lv_condition_6_0,
											"org.eclipse.efm.formalml.xtext.FormalML.Expression");
										afterParserOrEnumRuleCall();
									}
								)
							)
							otherlv_7='}'
							{
								newLeafNode(otherlv_7, grammarAccess.getTransitionTimedGuardAccess().getRightCurlyBracketKeyword_1_1_0_1_0_2());
							}
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getTransitionTimedGuardAccess().getConditionExpressionParserRuleCall_1_1_0_1_1_0());
								}
								lv_condition_8_0=ruleExpression
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTransitionTimedGuardRule());
									}
									set(
										$current,
										"condition",
										lv_condition_8_0,
										"org.eclipse.efm.formalml.xtext.FormalML.Expression");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)
				    |
				{
					/* */
				}
				{
					newCompositeNode(grammarAccess.getTransitionTimedGuardAccess().getTimedGuardStatementParserRuleCall_1_1_1());
				}
				this_TimedGuardStatement_9=ruleTimedGuardStatement
				{
					$current = $this_TimedGuardStatement_9.current;
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleTransitionEffect
entryRuleTransitionEffect returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionEffectRule()); }
	iv_ruleTransitionEffect=ruleTransitionEffect
	{ $current=$iv_ruleTransitionEffect.current; }
	EOF;

// Rule TransitionEffect
ruleTransitionEffect returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectAccess().getTransitionEffectStatementParserRuleCall_0());
		}
		this_TransitionEffectStatement_0=ruleTransitionEffectStatement
		{
			$current = $this_TransitionEffectStatement_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getTransitionEffectAccess().getBlockStatementStatementAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getTransitionEffectAccess().getStatementTransitionEffectStatementParserRuleCall_1_1_0());
					}
					lv_statement_2_0=ruleTransitionEffectStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransitionEffectRule());
						}
						add(
							$current,
							"statement",
							lv_statement_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.TransitionEffectStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleTransitionEffectStatement
entryRuleTransitionEffectStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionEffectStatementRule()); }
	iv_ruleTransitionEffectStatement=ruleTransitionEffectStatement
	{ $current=$iv_ruleTransitionEffectStatement.current; }
	EOF;

// Rule TransitionEffectStatement
ruleTransitionEffectStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getExpressionStatementParserRuleCall_0());
		}
		this_ExpressionStatement_0=ruleExpressionStatement
		{
			$current = $this_ExpressionStatement_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getOutputComStatementParserRuleCall_1());
		}
		this_OutputComStatement_1=ruleOutputComStatement
		{
			$current = $this_OutputComStatement_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getIfStatementParserRuleCall_2());
		}
		this_IfStatement_2=ruleIfStatement
		{
			$current = $this_IfStatement_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getWhileDoStatementParserRuleCall_3());
		}
		this_WhileDoStatement_3=ruleWhileDoStatement
		{
			$current = $this_WhileDoStatement_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getDoWhileStatementParserRuleCall_4());
		}
		this_DoWhileStatement_4=ruleDoWhileStatement
		{
			$current = $this_DoWhileStatement_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getForStatementParserRuleCall_5());
		}
		this_ForStatement_5=ruleForStatement
		{
			$current = $this_ForStatement_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getForEachStatementParserRuleCall_6());
		}
		this_ForEachStatement_6=ruleForEachStatement
		{
			$current = $this_ForEachStatement_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getInterruptStatementParserRuleCall_7());
		}
		this_InterruptStatement_7=ruleInterruptStatement
		{
			$current = $this_InterruptStatement_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getActivityStatementParserRuleCall_8());
		}
		this_ActivityStatement_8=ruleActivityStatement
		{
			$current = $this_ActivityStatement_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTransitionEffectStatementAccess().getInvokeStatementParserRuleCall_9());
		}
		this_InvokeStatement_9=ruleInvokeStatement
		{
			$current = $this_InvokeStatement_9.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleStatement
entryRuleStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStatementRule()); }
	iv_ruleStatement=ruleStatement
	{ $current=$iv_ruleStatement.current; }
	EOF;

// Rule Statement
ruleStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getBlockStatementParserRuleCall_0());
		}
		this_BlockStatement_0=ruleBlockStatement
		{
			$current = $this_BlockStatement_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getExpressionStatementParserRuleCall_1());
		}
		this_ExpressionStatement_1=ruleExpressionStatement
		{
			$current = $this_ExpressionStatement_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getGuardStatementParserRuleCall_2());
		}
		this_GuardStatement_2=ruleGuardStatement
		{
			$current = $this_GuardStatement_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getTimedGuardStatementParserRuleCall_3());
		}
		this_TimedGuardStatement_3=ruleTimedGuardStatement
		{
			$current = $this_TimedGuardStatement_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getEventGuardStatementParserRuleCall_4());
		}
		this_EventGuardStatement_4=ruleEventGuardStatement
		{
			$current = $this_EventGuardStatement_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getCheckSatGuardStatementParserRuleCall_5());
		}
		this_CheckSatGuardStatement_5=ruleCheckSatGuardStatement
		{
			$current = $this_CheckSatGuardStatement_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getInputComStatementParserRuleCall_6());
		}
		this_InputComStatement_6=ruleInputComStatement
		{
			$current = $this_InputComStatement_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getOutputComStatementParserRuleCall_7());
		}
		this_OutputComStatement_7=ruleOutputComStatement
		{
			$current = $this_OutputComStatement_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_8());
		}
		this_IfStatement_8=ruleIfStatement
		{
			$current = $this_IfStatement_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getWhileDoStatementParserRuleCall_9());
		}
		this_WhileDoStatement_9=ruleWhileDoStatement
		{
			$current = $this_WhileDoStatement_9.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getDoWhileStatementParserRuleCall_10());
		}
		this_DoWhileStatement_10=ruleDoWhileStatement
		{
			$current = $this_DoWhileStatement_10.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getForStatementParserRuleCall_11());
		}
		this_ForStatement_11=ruleForStatement
		{
			$current = $this_ForStatement_11.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getForEachStatementParserRuleCall_12());
		}
		this_ForEachStatement_12=ruleForEachStatement
		{
			$current = $this_ForEachStatement_12.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getInterruptStatementParserRuleCall_13());
		}
		this_InterruptStatement_13=ruleInterruptStatement
		{
			$current = $this_InterruptStatement_13.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getActivityStatementParserRuleCall_14());
		}
		this_ActivityStatement_14=ruleActivityStatement
		{
			$current = $this_ActivityStatement_14.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getInvokeStatementParserRuleCall_15());
		}
		this_InvokeStatement_15=ruleInvokeStatement
		{
			$current = $this_InvokeStatement_15.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleBlockStatement
entryRuleBlockStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBlockStatementRule()); }
	iv_ruleBlockStatement=ruleBlockStatement
	{ $current=$iv_ruleBlockStatement.current; }
	EOF;

// Rule BlockStatement
ruleBlockStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getBlockStatementAccess().getBlockStatementAction_0(),
					$current);
			}
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getBlockStatementAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getBlockStatementAccess().getOpBlockStatementSchedulerParserRuleCall_2_0());
				}
				lv_op_2_0=ruleBlockStatementScheduler
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBlockStatementRule());
					}
					set(
						$current,
						"op",
						lv_op_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatementScheduler");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getBlockStatementAccess().getStatementStatementParserRuleCall_3_0());
				}
				lv_statement_3_0=ruleStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBlockStatementRule());
					}
					add(
						$current,
						"statement",
						lv_statement_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Statement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getBlockStatementAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleBlockStatementScheduler
entryRuleBlockStatementScheduler returns [String current=null]:
	{ newCompositeNode(grammarAccess.getBlockStatementSchedulerRule()); }
	iv_ruleBlockStatementScheduler=ruleBlockStatementScheduler
	{ $current=$iv_ruleBlockStatementScheduler.current.getText(); }
	EOF;

// Rule BlockStatementScheduler
ruleBlockStatementScheduler returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='|;|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getVerticalLineSemicolonVerticalLineKeyword_0());
		}
		    |
		kw='|\u00A7|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getVerticalLineSectionSignVerticalLineKeyword_1());
		}
		    |
		kw='|;;|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getVerticalLineSemicolonSemicolonVerticalLineKeyword_2());
		}
		    |
		kw='|.|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getVerticalLineFullStopVerticalLineKeyword_3());
		}
		    |
		kw='|/;|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getVerticalLineSolidusSemicolonVerticalLineKeyword_4());
		}
		    |
		kw='|i|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getIKeyword_5());
		}
		    |
		kw='|interleaving|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getInterleavingKeyword_6());
		}
		    |
		kw='|~|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getVerticalLineTildeVerticalLineKeyword_7());
		}
		    |
		kw='|partial-order|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getPartialOrderKeyword_8());
		}
		    |
		kw='|,|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getVerticalLineCommaVerticalLineKeyword_9());
		}
		    |
		kw='|parallel|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getParallelKeyword_10());
		}
		    |
		kw='|a|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getAKeyword_11());
		}
		    |
		kw='|async|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getAsyncKeyword_12());
		}
		    |
		kw='|partial-order|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getPartialOrderKeyword_13());
		}
		    |
		kw='|and|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getAndKeyword_14());
		}
		    |
		kw='|or|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getOrKeyword_15());
		}
		    |
		kw='|and#then|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getAndThenKeyword_16());
		}
		    |
		kw='|or#else|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getOrElseKeyword_17());
		}
		    |
		kw='|indet|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getIndetKeyword_18());
		}
		    |
		kw='|/\\|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getVerticalLineSolidusReverseSolidusVerticalLineKeyword_19());
		}
		    |
		kw='|fork|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getForkKeyword_20());
		}
		    |
		kw='|join|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBlockStatementSchedulerAccess().getJoinKeyword_21());
		}
	)
;

// Entry rule entryRuleExpressionStatement
entryRuleExpressionStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpressionStatementRule()); }
	iv_ruleExpressionStatement=ruleExpressionStatement
	{ $current=$iv_ruleExpressionStatement.current; }
	EOF;

// Rule ExpressionStatement
ruleExpressionStatement returns [EObject current=null]
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
						newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionAssignmentExpressionParserRuleCall_0_0_0());
					}
					lv_expression_0_0=ruleAssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
						}
						set(
							$current,
							"expression",
							lv_expression_0_0,
							"org.eclipse.efm.formalml.xtext.FormalML.AssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_1=';'
			{
				newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_0_1());
			}
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionNewfreshExpressionParserRuleCall_1_0_0());
					}
					lv_expression_2_0=ruleNewfreshExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
						}
						set(
							$current,
							"expression",
							lv_expression_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.NewfreshExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=';'
			{
				newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1_1());
			}
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionIncrementOrDecrementPrefixExpressionParserRuleCall_2_0_0());
					}
					lv_expression_4_0=ruleIncrementOrDecrementPrefixExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
						}
						set(
							$current,
							"expression",
							lv_expression_4_0,
							"org.eclipse.efm.formalml.xtext.FormalML.IncrementOrDecrementPrefixExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5=';'
			{
				newLeafNode(otherlv_5, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_2_1());
			}
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionIncrementOrDecrementPostfixExpressionParserRuleCall_3_0_0());
					}
					lv_expression_6_0=ruleIncrementOrDecrementPostfixExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
						}
						set(
							$current,
							"expression",
							lv_expression_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.IncrementOrDecrementPostfixExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_7=';'
			{
				newLeafNode(otherlv_7, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_3_1());
			}
		)
	)
;

// Entry rule entryRuleGuardStatement
entryRuleGuardStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGuardStatementRule()); }
	iv_ruleGuardStatement=ruleGuardStatement
	{ $current=$iv_ruleGuardStatement.current; }
	EOF;

// Rule GuardStatement
ruleGuardStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='guard'
		{
			newLeafNode(otherlv_0, grammarAccess.getGuardStatementAccess().getGuardKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getGuardStatementAccess().getConditionExpressionParserRuleCall_1_0());
				}
				lv_condition_1_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGuardStatementRule());
					}
					set(
						$current,
						"condition",
						lv_condition_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=';'
		{
			newLeafNode(otherlv_2, grammarAccess.getGuardStatementAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleTimedGuardStatement
entryRuleTimedGuardStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTimedGuardStatementRule()); }
	iv_ruleTimedGuardStatement=ruleTimedGuardStatement
	{ $current=$iv_ruleTimedGuardStatement.current; }
	EOF;

// Rule TimedGuardStatement
ruleTimedGuardStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='tguard'
		{
			newLeafNode(otherlv_0, grammarAccess.getTimedGuardStatementAccess().getTguardKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTimedGuardStatementAccess().getConditionExpressionParserRuleCall_1_0());
				}
				lv_condition_1_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTimedGuardStatementRule());
					}
					set(
						$current,
						"condition",
						lv_condition_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=';'
		{
			newLeafNode(otherlv_2, grammarAccess.getTimedGuardStatementAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleEventGuardStatement
entryRuleEventGuardStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventGuardStatementRule()); }
	iv_ruleEventGuardStatement=ruleEventGuardStatement
	{ $current=$iv_ruleEventGuardStatement.current; }
	EOF;

// Rule EventGuardStatement
ruleEventGuardStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='event'
		{
			newLeafNode(otherlv_0, grammarAccess.getEventGuardStatementAccess().getEventKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEventGuardStatementAccess().getConditionExpressionParserRuleCall_1_0());
				}
				lv_condition_1_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEventGuardStatementRule());
					}
					set(
						$current,
						"condition",
						lv_condition_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=';'
		{
			newLeafNode(otherlv_2, grammarAccess.getEventGuardStatementAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleCheckSatGuardStatement
entryRuleCheckSatGuardStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCheckSatGuardStatementRule()); }
	iv_ruleCheckSatGuardStatement=ruleCheckSatGuardStatement
	{ $current=$iv_ruleCheckSatGuardStatement.current; }
	EOF;

// Rule CheckSatGuardStatement
ruleCheckSatGuardStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='checksat'
		{
			newLeafNode(otherlv_0, grammarAccess.getCheckSatGuardStatementAccess().getChecksatKeyword_0());
		}
		otherlv_1='<'
		{
			newLeafNode(otherlv_1, grammarAccess.getCheckSatGuardStatementAccess().getLessThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCheckSatGuardStatementAccess().getSolverESIdentifierParserRuleCall_2_0());
				}
				lv_solver_2_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCheckSatGuardStatementRule());
					}
					set(
						$current,
						"solver",
						lv_solver_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='>'
		{
			newLeafNode(otherlv_3, grammarAccess.getCheckSatGuardStatementAccess().getGreaterThanSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCheckSatGuardStatementAccess().getConditionExpressionParserRuleCall_4_0());
				}
				lv_condition_4_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCheckSatGuardStatementRule());
					}
					set(
						$current,
						"condition",
						lv_condition_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=';'
		{
			newLeafNode(otherlv_5, grammarAccess.getCheckSatGuardStatementAccess().getSemicolonKeyword_5());
		}
	)
;

// Entry rule entryRuleInputComStatement
entryRuleInputComStatement returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getInputComStatementAccess().getUnorderedGroup_3()
	);
}:
	{ newCompositeNode(grammarAccess.getInputComStatementRule()); }
	iv_ruleInputComStatement=ruleInputComStatement
	{ $current=$iv_ruleInputComStatement.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule InputComStatement
ruleInputComStatement returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getInputComStatementAccess().getUnorderedGroup_3()
	);
}
@after {
	leaveRule();
}:
	(
		otherlv_0='input'
		{
			newLeafNode(otherlv_0, grammarAccess.getInputComStatementAccess().getInputKeyword_0());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getInputComStatementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getInputComStatementAccess().getPortNamedElementCrossReference_1_0());
				}
				ruleESUfid
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getInputComStatementAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getInputComStatementAccess().getLeftValueExpressionParserRuleCall_2_1_0());
					}
					lv_leftValue_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getInputComStatementRule());
						}
						add(
							$current,
							"leftValue",
							lv_leftValue_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getInputComStatementAccess().getCommaKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getInputComStatementAccess().getLeftValueExpressionParserRuleCall_2_2_1_0());
						}
						lv_leftValue_5_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getInputComStatementRule());
							}
							add(
								$current,
								"leftValue",
								lv_leftValue_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_6=')'
			{
				newLeafNode(otherlv_6, grammarAccess.getInputComStatementAccess().getRightParenthesisKeyword_2_3());
			}
		)?
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getInputComStatementAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getInputComStatementAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getInputComStatementAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_8='<--'
								{
									newLeafNode(otherlv_8, grammarAccess.getInputComStatementAccess().getLessThanSignHyphenMinusHyphenMinusKeyword_3_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getInputComStatementAccess().getTargetValuePureNamedMachineExpressionParserRuleCall_3_0_1_0());
										}
										lv_target_9_0=ruleValuePureNamedMachineExpression
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getInputComStatementRule());
											}
											set(
												$current,
												"target",
												lv_target_9_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ValuePureNamedMachineExpression");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getInputComStatementAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getInputComStatementAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getInputComStatementAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>((
									otherlv_10='<=='
									{
										newLeafNode(otherlv_10, grammarAccess.getInputComStatementAccess().getLessThanSignEqualsSignEqualsSignKeyword_3_1_0_0());
									}
									    |
									otherlv_11='via'
									{
										newLeafNode(otherlv_11, grammarAccess.getInputComStatementAccess().getViaKeyword_3_1_0_1());
									}
								)
								(
									(
										{
											/* */
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getInputComStatementRule());
											}
										}
										{
											newCompositeNode(grammarAccess.getInputComStatementAccess().getRouteChannelCrossReference_3_1_1_0());
										}
										ruleESUfid
										{
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getInputComStatementAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getInputComStatementAccess().getUnorderedGroup_3());
				}
		)
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getInputComStatementAccess().getSemicolonKeyword_4());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleOutputComStatement
entryRuleOutputComStatement returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3()
	);
}:
	{ newCompositeNode(grammarAccess.getOutputComStatementRule()); }
	iv_ruleOutputComStatement=ruleOutputComStatement
	{ $current=$iv_ruleOutputComStatement.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule OutputComStatement
ruleOutputComStatement returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3()
	);
}
@after {
	leaveRule();
}:
	(
		otherlv_0='output'
		{
			newLeafNode(otherlv_0, grammarAccess.getOutputComStatementAccess().getOutputKeyword_0());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOutputComStatementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getOutputComStatementAccess().getPortNamedElementCrossReference_1_0());
				}
				ruleESUfid
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getOutputComStatementAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOutputComStatementAccess().getRigthValueExpressionParserRuleCall_2_1_0());
					}
					lv_rigthValue_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOutputComStatementRule());
						}
						add(
							$current,
							"rigthValue",
							lv_rigthValue_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getOutputComStatementAccess().getCommaKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getOutputComStatementAccess().getRigthValueExpressionParserRuleCall_2_2_1_0());
						}
						lv_rigthValue_5_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOutputComStatementRule());
							}
							add(
								$current,
								"rigthValue",
								lv_rigthValue_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_6=')'
			{
				newLeafNode(otherlv_6, grammarAccess.getOutputComStatementAccess().getRightParenthesisKeyword_2_3());
			}
		)?
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_8='-->'
								{
									newLeafNode(otherlv_8, grammarAccess.getOutputComStatementAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_3_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getOutputComStatementAccess().getTargetValuePureNamedMachineExpressionParserRuleCall_3_0_1_0());
										}
										lv_target_9_0=ruleValuePureNamedMachineExpression
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getOutputComStatementRule());
											}
											set(
												$current,
												"target",
												lv_target_9_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ValuePureNamedMachineExpression");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>((
									otherlv_10='==>'
									{
										newLeafNode(otherlv_10, grammarAccess.getOutputComStatementAccess().getEqualsSignEqualsSignGreaterThanSignKeyword_3_1_0_0());
									}
									    |
									otherlv_11='via'
									{
										newLeafNode(otherlv_11, grammarAccess.getOutputComStatementAccess().getViaKeyword_3_1_0_1());
									}
								)
								(
									(
										{
											/* */
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getOutputComStatementRule());
											}
										}
										{
											newCompositeNode(grammarAccess.getOutputComStatementAccess().getRouteChannelCrossReference_3_1_1_0());
										}
										ruleESUfid
										{
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getOutputComStatementAccess().getUnorderedGroup_3());
				}
		)
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getOutputComStatementAccess().getSemicolonKeyword_4());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleIfStatement
entryRuleIfStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIfStatementRule()); }
	iv_ruleIfStatement=ruleIfStatement
	{ $current=$iv_ruleIfStatement.current; }
	EOF;

// Rule IfStatement
ruleIfStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='if'
		{
			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIfStatementAccess().getConditionExpressionParserRuleCall_1_0());
				}
				lv_condition_1_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfStatementRule());
					}
					set(
						$current,
						"condition",
						lv_condition_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIfStatementAccess().getBodyBlockBlockStatementParserRuleCall_2_0());
				}
				lv_bodyBlock_2_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfStatementRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIfStatementAccess().getElseifStatementElseIfStatementParserRuleCall_3_0());
				}
				lv_elseifStatement_3_0=ruleElseIfStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfStatementRule());
					}
					add(
						$current,
						"elseifStatement",
						lv_elseifStatement_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ElseIfStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			otherlv_4='else'
			{
				newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getElseKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getIfStatementAccess().getElseBlockBlockStatementParserRuleCall_4_1_0());
					}
					lv_elseBlock_5_0=ruleBlockStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIfStatementRule());
						}
						set(
							$current,
							"elseBlock",
							lv_elseBlock_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleElseIfStatement
entryRuleElseIfStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getElseIfStatementRule()); }
	iv_ruleElseIfStatement=ruleElseIfStatement
	{ $current=$iv_ruleElseIfStatement.current; }
	EOF;

// Rule ElseIfStatement
ruleElseIfStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='elseif'
			{
				newLeafNode(otherlv_0, grammarAccess.getElseIfStatementAccess().getElseifKeyword_0_0());
			}
			    |
			(
				otherlv_1='else'
				{
					newLeafNode(otherlv_1, grammarAccess.getElseIfStatementAccess().getElseKeyword_0_1_0());
				}
				otherlv_2='if'
				{
					newLeafNode(otherlv_2, grammarAccess.getElseIfStatementAccess().getIfKeyword_0_1_1());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getElseIfStatementAccess().getConditionExpressionParserRuleCall_1_0());
				}
				lv_condition_3_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getElseIfStatementRule());
					}
					set(
						$current,
						"condition",
						lv_condition_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getElseIfStatementAccess().getBodyBlockBlockStatementParserRuleCall_2_0());
				}
				lv_bodyBlock_4_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getElseIfStatementRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleWhileDoStatement
entryRuleWhileDoStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWhileDoStatementRule()); }
	iv_ruleWhileDoStatement=ruleWhileDoStatement
	{ $current=$iv_ruleWhileDoStatement.current; }
	EOF;

// Rule WhileDoStatement
ruleWhileDoStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='while'
		{
			newLeafNode(otherlv_0, grammarAccess.getWhileDoStatementAccess().getWhileKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getWhileDoStatementAccess().getConditionExpressionParserRuleCall_1_0());
				}
				lv_condition_1_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getWhileDoStatementRule());
					}
					set(
						$current,
						"condition",
						lv_condition_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getWhileDoStatementAccess().getBodyBlockBlockStatementParserRuleCall_2_0());
				}
				lv_bodyBlock_2_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getWhileDoStatementRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleDoWhileStatement
entryRuleDoWhileStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDoWhileStatementRule()); }
	iv_ruleDoWhileStatement=ruleDoWhileStatement
	{ $current=$iv_ruleDoWhileStatement.current; }
	EOF;

// Rule DoWhileStatement
ruleDoWhileStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='do'
		{
			newLeafNode(otherlv_0, grammarAccess.getDoWhileStatementAccess().getDoKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDoWhileStatementAccess().getBodyBlockBlockStatementParserRuleCall_1_0());
				}
				lv_bodyBlock_1_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDoWhileStatementRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='while'
		{
			newLeafNode(otherlv_2, grammarAccess.getDoWhileStatementAccess().getWhileKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDoWhileStatementAccess().getConditionExpressionParserRuleCall_3_0());
				}
				lv_condition_3_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDoWhileStatementRule());
					}
					set(
						$current,
						"condition",
						lv_condition_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getDoWhileStatementAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleForStatement
entryRuleForStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getForStatementRule()); }
	iv_ruleForStatement=ruleForStatement
	{ $current=$iv_ruleForStatement.current; }
	EOF;

// Rule ForStatement
ruleForStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='for'
			{
				newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForStatementAccess().getInitForAssignmentExpressionParserRuleCall_0_1_0());
					}
					lv_init_1_0=ruleForAssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForStatementRule());
						}
						set(
							$current,
							"init",
							lv_init_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ForAssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_2=';'
			{
				newLeafNode(otherlv_2, grammarAccess.getForStatementAccess().getSemicolonKeyword_0_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForStatementAccess().getConditionExpressionParserRuleCall_0_3_0());
					}
					lv_condition_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForStatementRule());
						}
						set(
							$current,
							"condition",
							lv_condition_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4=';'
			{
				newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getSemicolonKeyword_0_4());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForStatementAccess().getIterateForAssignmentExpressionParserRuleCall_0_5_0());
					}
					lv_iterate_5_0=ruleForAssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForStatementRule());
						}
						set(
							$current,
							"iterate",
							lv_iterate_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ForAssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			(
				(
					{
						newCompositeNode(grammarAccess.getForStatementAccess().getBodyBlockBlockStatementParserRuleCall_0_6_0());
					}
					lv_bodyBlock_6_0=ruleBlockStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForStatementRule());
						}
						set(
							$current,
							"bodyBlock",
							lv_bodyBlock_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			otherlv_7='for'
			{
				newLeafNode(otherlv_7, grammarAccess.getForStatementAccess().getForKeyword_1_0());
			}
			otherlv_8='('
			{
				newLeafNode(otherlv_8, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForStatementAccess().getInitForAssignmentExpressionParserRuleCall_1_2_0());
					}
					lv_init_9_0=ruleForAssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForStatementRule());
						}
						set(
							$current,
							"init",
							lv_init_9_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ForAssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_10=';'
			{
				newLeafNode(otherlv_10, grammarAccess.getForStatementAccess().getSemicolonKeyword_1_3());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForStatementAccess().getConditionExpressionParserRuleCall_1_4_0());
					}
					lv_condition_11_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForStatementRule());
						}
						set(
							$current,
							"condition",
							lv_condition_11_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_12=';'
			{
				newLeafNode(otherlv_12, grammarAccess.getForStatementAccess().getSemicolonKeyword_1_5());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForStatementAccess().getIterateForAssignmentExpressionParserRuleCall_1_6_0());
					}
					lv_iterate_13_0=ruleForAssignmentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForStatementRule());
						}
						set(
							$current,
							"iterate",
							lv_iterate_13_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ForAssignmentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_14=')'
			{
				newLeafNode(otherlv_14, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_1_7());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForStatementAccess().getBodyBlockBlockStatementParserRuleCall_1_8_0());
					}
					lv_bodyBlock_15_0=ruleBlockStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForStatementRule());
						}
						set(
							$current,
							"bodyBlock",
							lv_bodyBlock_15_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleForAssignmentExpression
entryRuleForAssignmentExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getForAssignmentExpressionRule()); }
	iv_ruleForAssignmentExpression=ruleForAssignmentExpression
	{ $current=$iv_ruleForAssignmentExpression.current; }
	EOF;

// Rule ForAssignmentExpression
ruleForAssignmentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getForAssignmentExpressionAccess().getAssignmentExpressionParserRuleCall_0());
		}
		this_AssignmentExpression_0=ruleAssignmentExpression
		{
			$current = $this_AssignmentExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getForAssignmentExpressionAccess().getIncrementOrDecrementPrefixExpressionParserRuleCall_1());
		}
		this_IncrementOrDecrementPrefixExpression_1=ruleIncrementOrDecrementPrefixExpression
		{
			$current = $this_IncrementOrDecrementPrefixExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getForAssignmentExpressionAccess().getIncrementOrDecrementPostfixExpressionParserRuleCall_2());
		}
		this_IncrementOrDecrementPostfixExpression_2=ruleIncrementOrDecrementPostfixExpression
		{
			$current = $this_IncrementOrDecrementPostfixExpression_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleForEachStatement
entryRuleForEachStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getForEachStatementRule()); }
	iv_ruleForEachStatement=ruleForEachStatement
	{ $current=$iv_ruleForEachStatement.current; }
	EOF;

// Rule ForEachStatement
ruleForEachStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='for'
			{
				newLeafNode(otherlv_0, grammarAccess.getForEachStatementAccess().getForKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForEachStatementAccess().getIteratorLeftHandSideExpressionParserRuleCall_0_1_0());
					}
					lv_iterator_1_0=ruleLeftHandSideExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForEachStatementRule());
						}
						set(
							$current,
							"iterator",
							lv_iterator_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LeftHandSideExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getForEachStatementAccess().getColonKeyword_0_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForEachStatementAccess().getEnumerationExpressionParserRuleCall_0_3_0());
					}
					lv_enumeration_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForEachStatementRule());
						}
						set(
							$current,
							"enumeration",
							lv_enumeration_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getForEachStatementAccess().getBodyBlockBlockStatementParserRuleCall_0_4_0());
					}
					lv_bodyBlock_4_0=ruleBlockStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForEachStatementRule());
						}
						set(
							$current,
							"bodyBlock",
							lv_bodyBlock_4_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			otherlv_5='for'
			{
				newLeafNode(otherlv_5, grammarAccess.getForEachStatementAccess().getForKeyword_1_0());
			}
			otherlv_6='('
			{
				newLeafNode(otherlv_6, grammarAccess.getForEachStatementAccess().getLeftParenthesisKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForEachStatementAccess().getIteratorLeftHandSideExpressionParserRuleCall_1_2_0());
					}
					lv_iterator_7_0=ruleLeftHandSideExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForEachStatementRule());
						}
						set(
							$current,
							"iterator",
							lv_iterator_7_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LeftHandSideExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_8=':'
			{
				newLeafNode(otherlv_8, grammarAccess.getForEachStatementAccess().getColonKeyword_1_3());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForEachStatementAccess().getEnumerationExpressionParserRuleCall_1_4_0());
					}
					lv_enumeration_9_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForEachStatementRule());
						}
						set(
							$current,
							"enumeration",
							lv_enumeration_9_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_10=')'
			{
				newLeafNode(otherlv_10, grammarAccess.getForEachStatementAccess().getRightParenthesisKeyword_1_5());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForEachStatementAccess().getBodyBlockBlockStatementParserRuleCall_1_6_0());
					}
					lv_bodyBlock_11_0=ruleBlockStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForEachStatementRule());
						}
						set(
							$current,
							"bodyBlock",
							lv_bodyBlock_11_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BlockStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleInterruptStatement
entryRuleInterruptStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInterruptStatementRule()); }
	iv_ruleInterruptStatement=ruleInterruptStatement
	{ $current=$iv_ruleInterruptStatement.current; }
	EOF;

// Rule InterruptStatement
ruleInterruptStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getInterruptStatementAccess().getKindInterruptStatementKindEnumRuleCall_0_0());
				}
				lv_kind_0_0=ruleInterruptStatementKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInterruptStatementRule());
					}
					set(
						$current,
						"kind",
						lv_kind_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.InterruptStatementKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getInterruptStatementAccess().getExprExpressionParserRuleCall_1_0_0());
					}
					lv_expr_1_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getInterruptStatementRule());
						}
						add(
							$current,
							"expr",
							lv_expr_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				otherlv_2='('
				{
					newLeafNode(otherlv_2, grammarAccess.getInterruptStatementAccess().getLeftParenthesisKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getInterruptStatementAccess().getExprExpressionParserRuleCall_1_1_1_0());
						}
						lv_expr_3_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getInterruptStatementRule());
							}
							add(
								$current,
								"expr",
								lv_expr_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4=','
					{
						newLeafNode(otherlv_4, grammarAccess.getInterruptStatementAccess().getCommaKeyword_1_1_2_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getInterruptStatementAccess().getExprExpressionParserRuleCall_1_1_2_1_0());
							}
							lv_expr_5_0=ruleExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getInterruptStatementRule());
								}
								add(
									$current,
									"expr",
									lv_expr_5_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Expression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_6=')'
				{
					newLeafNode(otherlv_6, grammarAccess.getInterruptStatementAccess().getRightParenthesisKeyword_1_1_3());
				}
			)
		)?
		otherlv_7=';'
		{
			newLeafNode(otherlv_7, grammarAccess.getInterruptStatementAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleActivityStatement
entryRuleActivityStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getActivityStatementRule()); }
	iv_ruleActivityStatement=ruleActivityStatement
	{ $current=$iv_ruleActivityStatement.current; }
	EOF;

// Rule ActivityStatement
ruleActivityStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getActivityStatementAccess().getActivityStatementAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getActivityStatementAccess().getOpOPERATOR_ACTIVITYEnumRuleCall_1_0());
				}
				lv_op_1_0=ruleOPERATOR_ACTIVITY
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getActivityStatementRule());
					}
					set(
						$current,
						"op",
						lv_op_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.OPERATOR_ACTIVITY");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getActivityStatementAccess().getMachineValuePureNamedMachineExpressionParserRuleCall_2_0_0());
					}
					lv_machine_2_0=ruleValuePureNamedMachineExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getActivityStatementRule());
						}
						set(
							$current,
							"machine",
							lv_machine_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ValuePureNamedMachineExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getActivityStatementAccess().getTupleTupleParameterExpressionParserRuleCall_2_1_0());
					}
					lv_tuple_3_0=ruleTupleParameterExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getActivityStatementRule());
						}
						set(
							$current,
							"tuple",
							lv_tuple_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.TupleParameterExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)?
		)?
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getActivityStatementAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleInvokeStatement
entryRuleInvokeStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInvokeStatementRule()); }
	iv_ruleInvokeStatement=ruleInvokeStatement
	{ $current=$iv_ruleInvokeStatement.current; }
	EOF;

// Rule InvokeStatement
ruleInvokeStatement returns [EObject current=null]
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
						newCompositeNode(grammarAccess.getInvokeStatementAccess().getExpressionInvokeExpressionDeprecatedParserRuleCall_0_0_0());
					}
					lv_expression_0_0=ruleInvokeExpressionDeprecated
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getInvokeStatementRule());
						}
						set(
							$current,
							"expression",
							lv_expression_0_0,
							"org.eclipse.efm.formalml.xtext.FormalML.InvokeExpressionDeprecated");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_1=';'
			{
				newLeafNode(otherlv_1, grammarAccess.getInvokeStatementAccess().getSemicolonKeyword_0_1());
			}
		)
		    |
		(
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getInvokeStatementRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getInvokeStatementAccess().getInvokableNamedElementCrossReference_1_0_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					lv_execRoutine_3_0='('
					{
						newLeafNode(lv_execRoutine_3_0, grammarAccess.getInvokeStatementAccess().getExecRoutineLeftParenthesisKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getInvokeStatementRule());
						}
						setWithLastConsumed($current, "execRoutine", true, "(");
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getInvokeStatementAccess().getArgsMixTupleExpressionListParserRuleCall_1_2_0());
					}
					lv_args_4_0=ruleMixTupleExpressionList
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getInvokeStatementRule());
						}
						set(
							$current,
							"args",
							lv_args_4_0,
							"org.eclipse.efm.formalml.xtext.FormalML.MixTupleExpressionList");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_5=')'
			{
				newLeafNode(otherlv_5, grammarAccess.getInvokeStatementAccess().getRightParenthesisKeyword_1_3());
			}
			(
				otherlv_6='-->'
				{
					newLeafNode(otherlv_6, grammarAccess.getInvokeStatementAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_1_4_0());
				}
				(
					(
						(
							(
								{
									/* */
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getInvokeStatementRule());
									}
								}
								otherlv_7=RULE_ID
								{
									newLeafNode(otherlv_7, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_1_4_1_0_0_0());
								}
							)
						)
						(
							otherlv_8=','
							{
								newLeafNode(otherlv_8, grammarAccess.getInvokeStatementAccess().getCommaKeyword_1_4_1_0_1_0());
							}
							(
								(
									{
										/* */
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getInvokeStatementRule());
										}
									}
									otherlv_9=RULE_ID
									{
										newLeafNode(otherlv_9, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_1_4_1_0_1_1_0());
									}
								)
							)
						)*
					)
					    |
					(
						otherlv_10='('
						{
							newLeafNode(otherlv_10, grammarAccess.getInvokeStatementAccess().getLeftParenthesisKeyword_1_4_1_1_0());
						}
						(
							(
								{
									/* */
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getInvokeStatementRule());
									}
								}
								otherlv_11=RULE_ID
								{
									newLeafNode(otherlv_11, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_1_4_1_1_1_0());
								}
							)
						)
						(
							otherlv_12=','
							{
								newLeafNode(otherlv_12, grammarAccess.getInvokeStatementAccess().getCommaKeyword_1_4_1_1_2_0());
							}
							(
								(
									{
										/* */
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getInvokeStatementRule());
										}
									}
									otherlv_13=RULE_ID
									{
										newLeafNode(otherlv_13, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_1_4_1_1_2_1_0());
									}
								)
							)
						)*
						otherlv_14=')'
						{
							newLeafNode(otherlv_14, grammarAccess.getInvokeStatementAccess().getRightParenthesisKeyword_1_4_1_1_3());
						}
					)
				)
			)?
			otherlv_15=';'
			{
				newLeafNode(otherlv_15, grammarAccess.getInvokeStatementAccess().getSemicolonKeyword_1_5());
			}
		)
		    |
		(
			(
				(
					lv_execRoutine_16_0='exec'
					{
						newLeafNode(lv_execRoutine_16_0, grammarAccess.getInvokeStatementAccess().getExecRoutineExecKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getInvokeStatementRule());
						}
						setWithLastConsumed($current, "execRoutine", true, "exec");
					}
				)
			)
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getInvokeStatementRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getInvokeStatementAccess().getInvokableNamedElementCrossReference_2_1_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_18='('
			{
				newLeafNode(otherlv_18, grammarAccess.getInvokeStatementAccess().getLeftParenthesisKeyword_2_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getInvokeStatementAccess().getArgsMixTupleExpressionListParserRuleCall_2_3_0());
					}
					lv_args_19_0=ruleMixTupleExpressionList
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getInvokeStatementRule());
						}
						set(
							$current,
							"args",
							lv_args_19_0,
							"org.eclipse.efm.formalml.xtext.FormalML.MixTupleExpressionList");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_20=')'
			{
				newLeafNode(otherlv_20, grammarAccess.getInvokeStatementAccess().getRightParenthesisKeyword_2_4());
			}
			(
				otherlv_21='-->'
				{
					newLeafNode(otherlv_21, grammarAccess.getInvokeStatementAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_2_5_0());
				}
				(
					(
						(
							(
								{
									/* */
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getInvokeStatementRule());
									}
								}
								otherlv_22=RULE_ID
								{
									newLeafNode(otherlv_22, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_2_5_1_0_0_0());
								}
							)
						)
						(
							otherlv_23=','
							{
								newLeafNode(otherlv_23, grammarAccess.getInvokeStatementAccess().getCommaKeyword_2_5_1_0_1_0());
							}
							(
								(
									{
										/* */
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getInvokeStatementRule());
										}
									}
									otherlv_24=RULE_ID
									{
										newLeafNode(otherlv_24, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_2_5_1_0_1_1_0());
									}
								)
							)
						)*
					)
					    |
					(
						otherlv_25='('
						{
							newLeafNode(otherlv_25, grammarAccess.getInvokeStatementAccess().getLeftParenthesisKeyword_2_5_1_1_0());
						}
						(
							(
								{
									/* */
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getInvokeStatementRule());
									}
								}
								otherlv_26=RULE_ID
								{
									newLeafNode(otherlv_26, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_2_5_1_1_1_0());
								}
							)
						)
						(
							otherlv_27=','
							{
								newLeafNode(otherlv_27, grammarAccess.getInvokeStatementAccess().getCommaKeyword_2_5_1_1_2_0());
							}
							(
								(
									{
										/* */
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getInvokeStatementRule());
										}
									}
									otherlv_28=RULE_ID
									{
										newLeafNode(otherlv_28, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_2_5_1_1_2_1_0());
									}
								)
							)
						)*
						otherlv_29=')'
						{
							newLeafNode(otherlv_29, grammarAccess.getInvokeStatementAccess().getRightParenthesisKeyword_2_5_1_1_3());
						}
					)
				)
			)?
			otherlv_30=';'
			{
				newLeafNode(otherlv_30, grammarAccess.getInvokeStatementAccess().getSemicolonKeyword_2_6());
			}
		)
		    |
		(
			(
				(
					lv_callProcedure_31_0='call'
					{
						newLeafNode(lv_callProcedure_31_0, grammarAccess.getInvokeStatementAccess().getCallProcedureCallKeyword_3_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getInvokeStatementRule());
						}
						setWithLastConsumed($current, "callProcedure", true, "call");
					}
				)
			)
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getInvokeStatementRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getInvokeStatementAccess().getInvokableNamedElementCrossReference_3_1_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getInvokeStatementAccess().getArgsMixTupleExpressionListParserRuleCall_3_2_0());
					}
					lv_args_33_0=ruleMixTupleExpressionList
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getInvokeStatementRule());
						}
						set(
							$current,
							"args",
							lv_args_33_0,
							"org.eclipse.efm.formalml.xtext.FormalML.MixTupleExpressionList");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			(
				otherlv_34='-->'
				{
					newLeafNode(otherlv_34, grammarAccess.getInvokeStatementAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_3_3_0());
				}
				(
					(
						(
							(
								{
									/* */
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getInvokeStatementRule());
									}
								}
								otherlv_35=RULE_ID
								{
									newLeafNode(otherlv_35, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_3_3_1_0_0_0());
								}
							)
						)
						(
							otherlv_36=','
							{
								newLeafNode(otherlv_36, grammarAccess.getInvokeStatementAccess().getCommaKeyword_3_3_1_0_1_0());
							}
							(
								(
									{
										/* */
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getInvokeStatementRule());
										}
									}
									otherlv_37=RULE_ID
									{
										newLeafNode(otherlv_37, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_3_3_1_0_1_1_0());
									}
								)
							)
						)*
					)
					    |
					(
						otherlv_38='('
						{
							newLeafNode(otherlv_38, grammarAccess.getInvokeStatementAccess().getLeftParenthesisKeyword_3_3_1_1_0());
						}
						(
							(
								{
									/* */
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getInvokeStatementRule());
									}
								}
								otherlv_39=RULE_ID
								{
									newLeafNode(otherlv_39, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_3_3_1_1_1_0());
								}
							)
						)
						(
							otherlv_40=','
							{
								newLeafNode(otherlv_40, grammarAccess.getInvokeStatementAccess().getCommaKeyword_3_3_1_1_2_0());
							}
							(
								(
									{
										/* */
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getInvokeStatementRule());
										}
									}
									otherlv_41=RULE_ID
									{
										newLeafNode(otherlv_41, grammarAccess.getInvokeStatementAccess().getRetsVariableCrossReference_3_3_1_1_2_1_0());
									}
								)
							)
						)*
						otherlv_42=')'
						{
							newLeafNode(otherlv_42, grammarAccess.getInvokeStatementAccess().getRightParenthesisKeyword_3_3_1_1_3());
						}
					)
				)
			)?
			otherlv_43=';'
			{
				newLeafNode(otherlv_43, grammarAccess.getInvokeStatementAccess().getSemicolonKeyword_3_4());
			}
		)
	)
;

// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	iv_ruleExpression=ruleExpression
	{ $current=$iv_ruleExpression.current; }
	EOF;

// Rule Expression
ruleExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0());
		}
		this_AssignmentExpression_0=ruleAssignmentExpression
		{
			$current = $this_AssignmentExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getConditionalTestExpressionParserRuleCall_1());
		}
		this_ConditionalTestExpression_1=ruleConditionalTestExpression
		{
			$current = $this_ConditionalTestExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAssignmentExpression
entryRuleAssignmentExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssignmentExpressionRule()); }
	iv_ruleAssignmentExpression=ruleAssignmentExpression
	{ $current=$iv_ruleAssignmentExpression.current; }
	EOF;

// Rule AssignmentExpression
ruleAssignmentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLeftHandSideLeftHandSideExpressionParserRuleCall_0_0());
				}
				lv_leftHandSide_0_0=ruleLeftHandSideExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
					}
					set(
						$current,
						"leftHandSide",
						lv_leftHandSide_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.LeftHandSideExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorParserRuleCall_1_0());
				}
				lv_operator_1_0=ruleAssignmentOperator
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
					}
					set(
						$current,
						"operator",
						lv_operator_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.AssignmentOperator");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRigthHandSideExpressionParserRuleCall_2_0());
				}
				lv_rigthHandSide_2_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
					}
					set(
						$current,
						"rigthHandSide",
						lv_rigthHandSide_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleAssignmentOperator
entryRuleAssignmentOperator returns [String current=null]:
	{ newCompositeNode(grammarAccess.getAssignmentOperatorRule()); }
	iv_ruleAssignmentOperator=ruleAssignmentOperator
	{ $current=$iv_ruleAssignmentOperator.current.getText(); }
	EOF;

// Rule AssignmentOperator
ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword_0());
		}
		    |
		kw=':='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getColonEqualsSignKeyword_1());
		}
		    |
		kw='::='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getColonColonEqualsSignKeyword_2());
		}
		    |
		kw='+='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPlusSignEqualsSignKeyword_3());
		}
		    |
		kw='-='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getHyphenMinusEqualsSignKeyword_4());
		}
		    |
		kw='*='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getAsteriskEqualsSignKeyword_5());
		}
		    |
		kw='/='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getSolidusEqualsSignKeyword_6());
		}
		    |
		kw='%='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPercentSignEqualsSignKeyword_7());
		}
		    |
		kw='&&='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_8());
		}
		    |
		kw='||='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_9());
		}
		    |
		kw='&='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getAmpersandEqualsSignKeyword_10());
		}
		    |
		kw='|='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getVerticalLineEqualsSignKeyword_11());
		}
		    |
		kw='^='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getCircumflexAccentEqualsSignKeyword_12());
		}
		    |
		kw='<<='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_13());
		}
		    |
		kw='>>='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_14());
		}
		    |
		kw='>>>='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getGreaterThanSignGreaterThanSignGreaterThanSignEqualsSignKeyword_15());
		}
		    |
		kw='<=<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getLessThanSignEqualsSignLessThanSignKeyword_16());
		}
		    |
		kw='^=<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getCircumflexAccentEqualsSignLessThanSignKeyword_17());
		}
		    |
		kw='^=>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getCircumflexAccentEqualsSignGreaterThanSignKeyword_18());
		}
		    |
		kw='>=>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getGreaterThanSignEqualsSignGreaterThanSignKeyword_19());
		}
	)
;

// Entry rule entryRuleLeftHandSideExpression
entryRuleLeftHandSideExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLeftHandSideExpressionRule()); }
	iv_ruleLeftHandSideExpression=ruleLeftHandSideExpression
	{ $current=$iv_ruleLeftHandSideExpression.current; }
	EOF;

// Rule LeftHandSideExpression
ruleLeftHandSideExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLeftHandSideExpressionAccess().getLeftHandSideExpressionAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getLeftHandSideExpressionAccess().getLvalueValueSelectionExpressionParserRuleCall_1_0_0());
					}
					lv_lvalue_1_0=ruleValueSelectionExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLeftHandSideExpressionRule());
						}
						set(
							$current,
							"lvalue",
							lv_lvalue_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ValueSelectionExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				otherlv_2='('
				{
					newLeafNode(otherlv_2, grammarAccess.getLeftHandSideExpressionAccess().getLeftParenthesisKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getLeftHandSideExpressionAccess().getLvalueValueSelectionExpressionParserRuleCall_1_1_1_0());
						}
						lv_lvalue_3_0=ruleValueSelectionExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLeftHandSideExpressionRule());
							}
							set(
								$current,
								"lvalue",
								lv_lvalue_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueSelectionExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_4=')'
				{
					newLeafNode(otherlv_4, grammarAccess.getLeftHandSideExpressionAccess().getRightParenthesisKeyword_1_1_2());
				}
			)
		)
	)
;

// Entry rule entryRuleConditionalTestExpression
entryRuleConditionalTestExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionalTestExpressionRule()); }
	iv_ruleConditionalTestExpression=ruleConditionalTestExpression
	{ $current=$iv_ruleConditionalTestExpression.current; }
	EOF;

// Rule ConditionalTestExpression
ruleConditionalTestExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getConditionalTestExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
		}
		this_LogicalOrExpression_0=ruleLogicalOrExpression
		{
			$current = $this_LogicalOrExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getConditionalTestExpressionAccess().getConditionalTestExpressionConditionAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_operator_2_0='?'
					{
						newLeafNode(lv_operator_2_0, grammarAccess.getConditionalTestExpressionAccess().getOperatorQuestionMarkKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getConditionalTestExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_0, "?");
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionalTestExpressionAccess().getThenOperandExpressionParserRuleCall_1_2_0());
					}
					lv_thenOperand_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionalTestExpressionRule());
						}
						set(
							$current,
							"thenOperand",
							lv_thenOperand_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4=':'
			{
				newLeafNode(otherlv_4, grammarAccess.getConditionalTestExpressionAccess().getColonKeyword_1_3());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionalTestExpressionAccess().getElseOperandExpressionParserRuleCall_1_4_0());
					}
					lv_elseOperand_5_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionalTestExpressionRule());
						}
						set(
							$current,
							"elseOperand",
							lv_elseOperand_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleLogicalOrExpression
entryRuleLogicalOrExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); }
	iv_ruleLogicalOrExpression=ruleLogicalOrExpression
	{ $current=$iv_ruleLogicalOrExpression.current; }
	EOF;

// Rule LogicalOrExpression
ruleLogicalOrExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
		}
		this_LogicalAndExpression_0=ruleLogicalAndExpression
		{
			$current = $this_LogicalAndExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getLogicalOrExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_operator_2_1='||'
						{
							newLeafNode(lv_operator_2_1, grammarAccess.getLogicalOrExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getLogicalOrExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_1, null);
						}
						    |
						lv_operator_2_2='or'
						{
							newLeafNode(lv_operator_2_2, grammarAccess.getLogicalOrExpressionAccess().getOperatorOrKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getLogicalOrExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_2, null);
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandLogicalAndExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleLogicalAndExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LogicalAndExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					otherlv_4='||'
					{
						newLeafNode(otherlv_4, grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_3_0_0());
					}
					    |
					otherlv_5='or'
					{
						newLeafNode(otherlv_5, grammarAccess.getLogicalOrExpressionAccess().getOrKeyword_1_3_0_1());
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandLogicalAndExpressionParserRuleCall_1_3_1_0());
						}
						lv_operand_6_0=ruleLogicalAndExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.LogicalAndExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleLogicalAndExpression
entryRuleLogicalAndExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); }
	iv_ruleLogicalAndExpression=ruleLogicalAndExpression
	{ $current=$iv_ruleLogicalAndExpression.current; }
	EOF;

// Rule LogicalAndExpression
ruleLogicalAndExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getBitwiseOrExpressionParserRuleCall_0());
		}
		this_BitwiseOrExpression_0=ruleBitwiseOrExpression
		{
			$current = $this_BitwiseOrExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getLogicalAndExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_operator_2_1='&&'
						{
							newLeafNode(lv_operator_2_1, grammarAccess.getLogicalAndExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getLogicalAndExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_1, null);
						}
						    |
						lv_operator_2_2='and'
						{
							newLeafNode(lv_operator_2_2, grammarAccess.getLogicalAndExpressionAccess().getOperatorAndKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getLogicalAndExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_2, null);
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandBitwiseOrExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleBitwiseOrExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BitwiseOrExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					otherlv_4='&&'
					{
						newLeafNode(otherlv_4, grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_3_0_0());
					}
					    |
					otherlv_5='and'
					{
						newLeafNode(otherlv_5, grammarAccess.getLogicalAndExpressionAccess().getAndKeyword_1_3_0_1());
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandBitwiseOrExpressionParserRuleCall_1_3_1_0());
						}
						lv_operand_6_0=ruleBitwiseOrExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.BitwiseOrExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleBitwiseOrExpression
entryRuleBitwiseOrExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBitwiseOrExpressionRule()); }
	iv_ruleBitwiseOrExpression=ruleBitwiseOrExpression
	{ $current=$iv_ruleBitwiseOrExpression.current; }
	EOF;

// Rule BitwiseOrExpression
ruleBitwiseOrExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseXorExpressionParserRuleCall_0());
		}
		this_BitwiseXorExpression_0=ruleBitwiseXorExpression
		{
			$current = $this_BitwiseXorExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_operator_2_0='|'
					{
						newLeafNode(lv_operator_2_0, grammarAccess.getBitwiseOrExpressionAccess().getOperatorVerticalLineKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBitwiseOrExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_0, "|");
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleBitwiseXorExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBitwiseOrExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BitwiseXorExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4='|'
				{
					newLeafNode(otherlv_4, grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_3_1_0());
						}
						lv_operand_5_0=ruleBitwiseXorExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getBitwiseOrExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.BitwiseXorExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleBitwiseXorExpression
entryRuleBitwiseXorExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBitwiseXorExpressionRule()); }
	iv_ruleBitwiseXorExpression=ruleBitwiseXorExpression
	{ $current=$iv_ruleBitwiseXorExpression.current; }
	EOF;

// Rule BitwiseXorExpression
ruleBitwiseXorExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseAndExpressionParserRuleCall_0());
		}
		this_BitwiseAndExpression_0=ruleBitwiseAndExpression
		{
			$current = $this_BitwiseAndExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getBitwiseXorExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_operator_2_0='^'
					{
						newLeafNode(lv_operator_2_0, grammarAccess.getBitwiseXorExpressionAccess().getOperatorCircumflexAccentKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBitwiseXorExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_0, "^");
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getOperandBitwiseAndExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleBitwiseAndExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBitwiseXorExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BitwiseAndExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4='^'
				{
					newLeafNode(otherlv_4, grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getOperandBitwiseAndExpressionParserRuleCall_1_3_1_0());
						}
						lv_operand_5_0=ruleBitwiseAndExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getBitwiseXorExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.BitwiseAndExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleBitwiseAndExpression
entryRuleBitwiseAndExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBitwiseAndExpressionRule()); }
	iv_ruleBitwiseAndExpression=ruleBitwiseAndExpression
	{ $current=$iv_ruleBitwiseAndExpression.current; }
	EOF;

// Rule BitwiseAndExpression
ruleBitwiseAndExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
		}
		this_EqualityExpression_0=ruleEqualityExpression
		{
			$current = $this_EqualityExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_operator_2_0='&'
					{
						newLeafNode(lv_operator_2_0, grammarAccess.getBitwiseAndExpressionAccess().getOperatorAmpersandKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBitwiseAndExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_0, "&");
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleEqualityExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBitwiseAndExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.EqualityExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4='&'
				{
					newLeafNode(otherlv_4, grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_3_1_0());
						}
						lv_operand_5_0=ruleEqualityExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getBitwiseAndExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EqualityExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleEqualityExpression
entryRuleEqualityExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEqualityExpressionRule()); }
	iv_ruleEqualityExpression=ruleEqualityExpression
	{ $current=$iv_ruleEqualityExpression.current; }
	EOF;

// Rule EqualityExpression
ruleEqualityExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
		}
		this_RelationalExpression_0=ruleRelationalExpression
		{
			$current = $this_RelationalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getEqualityExpressionAccess().getEqualityBinaryExpressionLeftOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorEqualityOperatorParserRuleCall_1_1_0());
					}
					lv_operator_2_0=ruleEqualityOperator
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
						}
						set(
							$current,
							"operator",
							lv_operator_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.EqualityOperator");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRigthOperandRelationalExpressionParserRuleCall_1_2_0());
					}
					lv_rigthOperand_3_0=ruleRelationalExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
						}
						set(
							$current,
							"rigthOperand",
							lv_rigthOperand_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.RelationalExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleEqualityOperator
entryRuleEqualityOperator returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEqualityOperatorRule()); }
	iv_ruleEqualityOperator=ruleEqualityOperator
	{ $current=$iv_ruleEqualityOperator.current.getText(); }
	EOF;

// Rule EqualityOperator
ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='=='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0());
		}
		    |
		kw='!='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getExclamationMarkEqualsSignKeyword_1());
		}
		    |
		kw='==='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
		}
		    |
		kw='=!='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignExclamationMarkEqualsSignKeyword_3());
		}
		    |
		kw='=/='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignSolidusEqualsSignKeyword_4());
		}
	)
;

// Entry rule entryRuleRelationalExpression
entryRuleRelationalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRelationalExpressionRule()); }
	iv_ruleRelationalExpression=ruleRelationalExpression
	{ $current=$iv_ruleRelationalExpression.current; }
	EOF;

// Rule RelationalExpression
ruleRelationalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
		}
		this_AdditiveExpression_0=ruleAdditiveExpression
		{
			$current = $this_AdditiveExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getRelationalExpressionAccess().getRelationalBinaryExpressionLeftOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorParserRuleCall_1_1_0());
					}
					lv_operator_2_0=ruleRelationalOperator
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
						}
						set(
							$current,
							"operator",
							lv_operator_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.RelationalOperator");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRigthOperandAdditiveExpressionParserRuleCall_1_2_0());
					}
					lv_rigthOperand_3_0=ruleAdditiveExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
						}
						set(
							$current,
							"rigthOperand",
							lv_rigthOperand_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.AdditiveExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getRelationalExpressionAccess().getRelationalTernaryExpressionLeftRelationAction_1_3_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRigthOperatorRelationalOperatorParserRuleCall_1_3_1_0());
						}
						lv_rigthOperator_5_0=ruleRelationalOperator
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"rigthOperator",
								lv_rigthOperator_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.RelationalOperator");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRigthOperandAdditiveExpressionParserRuleCall_1_3_2_0());
						}
						lv_rigthOperand_6_0=ruleAdditiveExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"rigthOperand",
								lv_rigthOperand_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.AdditiveExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)?
	)
;

// Entry rule entryRuleRelationalOperator
entryRuleRelationalOperator returns [String current=null]:
	{ newCompositeNode(grammarAccess.getRelationalOperatorRule()); }
	iv_ruleRelationalOperator=ruleRelationalOperator
	{ $current=$iv_ruleRelationalOperator.current.getText(); }
	EOF;

// Rule RelationalOperator
ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0());
		}
		    |
		kw='>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1());
		}
		    |
		kw='<='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2());
		}
		    |
		kw='>='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3());
		}
	)
;

// Entry rule entryRuleAdditiveExpression
entryRuleAdditiveExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAdditiveExpressionRule()); }
	iv_ruleAdditiveExpression=ruleAdditiveExpression
	{ $current=$iv_ruleAdditiveExpression.current; }
	EOF;

// Rule AdditiveExpression
ruleAdditiveExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
		}
		this_MultiplicativeExpression_0=ruleMultiplicativeExpression
		{
			$current = $this_MultiplicativeExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndAdd(
							grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0(),
							$current);
					}
				)
				(
					(
						lv_operator_2_0='+'
						{
							newLeafNode(lv_operator_2_0, grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getAdditiveExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_0, "+");
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_0_2_0());
						}
						lv_operand_3_0=ruleMultiplicativeExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.MultiplicativeExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4='+'
					{
						newLeafNode(otherlv_4, grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_0_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_0_3_1_0());
							}
							lv_operand_5_0=ruleMultiplicativeExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_5_0,
									"org.eclipse.efm.formalml.xtext.FormalML.MultiplicativeExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndAdd(
							grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0(),
							$current);
					}
				)
				(
					(
						lv_operator_7_0='-'
						{
							newLeafNode(lv_operator_7_0, grammarAccess.getAdditiveExpressionAccess().getOperatorHyphenMinusKeyword_1_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getAdditiveExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_7_0, "-");
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_1_2_0());
						}
						lv_operand_8_0=ruleMultiplicativeExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.MultiplicativeExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_9='-'
					{
						newLeafNode(otherlv_9, grammarAccess.getAdditiveExpressionAccess().getHyphenMinusKeyword_1_1_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_1_3_1_0());
							}
							lv_operand_10_0=ruleMultiplicativeExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_10_0,
									"org.eclipse.efm.formalml.xtext.FormalML.MultiplicativeExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)*
	)
;

// Entry rule entryRuleMultiplicativeExpression
entryRuleMultiplicativeExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); }
	iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression
	{ $current=$iv_ruleMultiplicativeExpression.current; }
	EOF;

// Rule MultiplicativeExpression
ruleMultiplicativeExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryExpressionParserRuleCall_0());
		}
		this_UnaryExpression_0=ruleUnaryExpression
		{
			$current = $this_UnaryExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndAdd(
							grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0(),
							$current);
					}
				)
				(
					(
						lv_operator_2_0='*'
						{
							newLeafNode(lv_operator_2_0, grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_0, "*");
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0_2_0());
						}
						lv_operand_3_0=ruleUnaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4='*'
					{
						newLeafNode(otherlv_4, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0_3_1_0());
							}
							lv_operand_5_0=ruleUnaryExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_5_0,
									"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndAdd(
							grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0(),
							$current);
					}
				)
				(
					(
						lv_operator_7_0='**'
						{
							newLeafNode(lv_operator_7_0, grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskAsteriskKeyword_1_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_7_0, "**");
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_1_2_0());
						}
						lv_operand_8_0=ruleUnaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_9='**'
					{
						newLeafNode(otherlv_9, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskAsteriskKeyword_1_1_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_1_3_1_0());
							}
							lv_operand_10_0=ruleUnaryExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_10_0,
									"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndAdd(
							grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_2_0(),
							$current);
					}
				)
				(
					(
						lv_operator_12_0='/'
						{
							newLeafNode(lv_operator_12_0, grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_2_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_12_0, "/");
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_2_2_0());
						}
						lv_operand_13_0=ruleUnaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_13_0,
								"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_14='/'
					{
						newLeafNode(otherlv_14, grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_2_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_2_3_1_0());
							}
							lv_operand_15_0=ruleUnaryExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_15_0,
									"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndAdd(
							grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_3_0(),
							$current);
					}
				)
				(
					(
						lv_operator_17_0='%'
						{
							newLeafNode(lv_operator_17_0, grammarAccess.getMultiplicativeExpressionAccess().getOperatorPercentSignKeyword_1_3_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_17_0, "\%");
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_3_2_0());
						}
						lv_operand_18_0=ruleUnaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_18_0,
								"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_19='%'
					{
						newLeafNode(otherlv_19, grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_3_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_3_3_1_0());
							}
							lv_operand_20_0=ruleUnaryExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_20_0,
									"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)*
	)
;

// Entry rule entryRuleUnaryExpression
entryRuleUnaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnaryExpressionRule()); }
	iv_ruleUnaryExpression=ruleUnaryExpression
	{ $current=$iv_ruleUnaryExpression.current; }
	EOF;

// Rule UnaryExpression
ruleUnaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getLiteralTerminalExpressionParserRuleCall_0());
		}
		this_LiteralTerminalExpression_0=ruleLiteralTerminalExpression
		{
			$current = $this_LiteralTerminalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getArithmeticUnaryExpressionParserRuleCall_1());
		}
		this_ArithmeticUnaryExpression_1=ruleArithmeticUnaryExpression
		{
			$current = $this_ArithmeticUnaryExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getLogicalUnaryExpressionParserRuleCall_2());
		}
		this_LogicalUnaryExpression_2=ruleLogicalUnaryExpression
		{
			$current = $this_LogicalUnaryExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getQuantifiedLogicalExpressionParserRuleCall_3());
		}
		this_QuantifiedLogicalExpression_3=ruleQuantifiedLogicalExpression
		{
			$current = $this_QuantifiedLogicalExpression_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getBitwiseUnaryExpressionParserRuleCall_4());
		}
		this_BitwiseUnaryExpression_4=ruleBitwiseUnaryExpression
		{
			$current = $this_BitwiseUnaryExpression_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getNewfreshExpressionParserRuleCall_5());
		}
		this_NewfreshExpression_5=ruleNewfreshExpression
		{
			$current = $this_NewfreshExpression_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getCastExpressionParserRuleCall_6());
		}
		this_CastExpression_6=ruleCastExpression
		{
			$current = $this_CastExpression_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrefixUnaryExpressionParserRuleCall_7());
		}
		this_PrefixUnaryExpression_7=rulePrefixUnaryExpression
		{
			$current = $this_PrefixUnaryExpression_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixUnaryExpressionParserRuleCall_8());
		}
		this_PostfixUnaryExpression_8=rulePostfixUnaryExpression
		{
			$current = $this_PostfixUnaryExpression_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_9());
		}
		this_PrimaryExpression_9=rulePrimaryExpression
		{
			$current = $this_PrimaryExpression_9.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePostfixUnaryExpression
entryRulePostfixUnaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPostfixUnaryExpressionRule()); }
	iv_rulePostfixUnaryExpression=rulePostfixUnaryExpression
	{ $current=$iv_rulePostfixUnaryExpression.current; }
	EOF;

// Rule PostfixUnaryExpression
rulePostfixUnaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getPostfixUnaryExpressionAccess().getIncrementOrDecrementPostfixExpressionParserRuleCall());
	}
	this_IncrementOrDecrementPostfixExpression_0=ruleIncrementOrDecrementPostfixExpression
	{
		$current = $this_IncrementOrDecrementPostfixExpression_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleIncrementOrDecrementPostfixExpression
entryRuleIncrementOrDecrementPostfixExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIncrementOrDecrementPostfixExpressionRule()); }
	iv_ruleIncrementOrDecrementPostfixExpression=ruleIncrementOrDecrementPostfixExpression
	{ $current=$iv_ruleIncrementOrDecrementPostfixExpression.current; }
	EOF;

// Rule IncrementOrDecrementPostfixExpression
ruleIncrementOrDecrementPostfixExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getIncrementOrDecrementPostfixExpressionAccess().getLeftHandSideLeftHandSideExpressionParserRuleCall_0_0());
				}
				lv_leftHandSide_0_0=ruleLeftHandSideExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIncrementOrDecrementPostfixExpressionRule());
					}
					set(
						$current,
						"leftHandSide",
						lv_leftHandSide_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.LeftHandSideExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIncrementOrDecrementPostfixExpressionAccess().getOperatorAffixOperatorParserRuleCall_1_0());
				}
				lv_operator_1_0=ruleAffixOperator
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIncrementOrDecrementPostfixExpressionRule());
					}
					set(
						$current,
						"operator",
						lv_operator_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.AffixOperator");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRulePrefixUnaryExpression
entryRulePrefixUnaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrefixUnaryExpressionRule()); }
	iv_rulePrefixUnaryExpression=rulePrefixUnaryExpression
	{ $current=$iv_rulePrefixUnaryExpression.current; }
	EOF;

// Rule PrefixUnaryExpression
rulePrefixUnaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		/* */
	}
	{
		newCompositeNode(grammarAccess.getPrefixUnaryExpressionAccess().getIncrementOrDecrementPrefixExpressionParserRuleCall());
	}
	this_IncrementOrDecrementPrefixExpression_0=ruleIncrementOrDecrementPrefixExpression
	{
		$current = $this_IncrementOrDecrementPrefixExpression_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleIncrementOrDecrementPrefixExpression
entryRuleIncrementOrDecrementPrefixExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIncrementOrDecrementPrefixExpressionRule()); }
	iv_ruleIncrementOrDecrementPrefixExpression=ruleIncrementOrDecrementPrefixExpression
	{ $current=$iv_ruleIncrementOrDecrementPrefixExpression.current; }
	EOF;

// Rule IncrementOrDecrementPrefixExpression
ruleIncrementOrDecrementPrefixExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getIncrementOrDecrementPrefixExpressionAccess().getOperatorAffixOperatorParserRuleCall_0_0());
				}
				lv_operator_0_0=ruleAffixOperator
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIncrementOrDecrementPrefixExpressionRule());
					}
					set(
						$current,
						"operator",
						lv_operator_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.AffixOperator");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIncrementOrDecrementPrefixExpressionAccess().getLeftHandSideLeftHandSideExpressionParserRuleCall_1_0());
				}
				lv_leftHandSide_1_0=ruleLeftHandSideExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIncrementOrDecrementPrefixExpressionRule());
					}
					set(
						$current,
						"leftHandSide",
						lv_leftHandSide_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.LeftHandSideExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleAffixOperator
entryRuleAffixOperator returns [String current=null]:
	{ newCompositeNode(grammarAccess.getAffixOperatorRule()); }
	iv_ruleAffixOperator=ruleAffixOperator
	{ $current=$iv_ruleAffixOperator.current.getText(); }
	EOF;

// Rule AffixOperator
ruleAffixOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='++'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAffixOperatorAccess().getPlusSignPlusSignKeyword_0());
		}
		    |
		kw='--'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAffixOperatorAccess().getHyphenMinusHyphenMinusKeyword_1());
		}
	)
;

// Entry rule entryRuleNewfreshExpression
entryRuleNewfreshExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNewfreshExpressionRule()); }
	iv_ruleNewfreshExpression=ruleNewfreshExpression
	{ $current=$iv_ruleNewfreshExpression.current; }
	EOF;

// Rule NewfreshExpression
ruleNewfreshExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='newfresh'
			{
				newLeafNode(otherlv_0, grammarAccess.getNewfreshExpressionAccess().getNewfreshKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNewfreshExpressionAccess().getLeftHandSideLeftHandSideExpressionParserRuleCall_0_1_0());
					}
					lv_leftHandSide_1_0=ruleLeftHandSideExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNewfreshExpressionRule());
						}
						set(
							$current,
							"leftHandSide",
							lv_leftHandSide_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LeftHandSideExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			otherlv_2='(:'
			{
				newLeafNode(otherlv_2, grammarAccess.getNewfreshExpressionAccess().getLeftParenthesisColonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNewfreshExpressionAccess().getLeftHandSideLeftHandSideExpressionParserRuleCall_1_1_0());
					}
					lv_leftHandSide_3_0=ruleLeftHandSideExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNewfreshExpressionRule());
						}
						set(
							$current,
							"leftHandSide",
							lv_leftHandSide_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LeftHandSideExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='newfresh'
			{
				newLeafNode(otherlv_4, grammarAccess.getNewfreshExpressionAccess().getNewfreshKeyword_1_2());
			}
			otherlv_5=')'
			{
				newLeafNode(otherlv_5, grammarAccess.getNewfreshExpressionAccess().getRightParenthesisKeyword_1_3());
			}
		)
	)
;

// Entry rule entryRuleCastExpression
entryRuleCastExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCastExpressionRule()); }
	iv_ruleCastExpression=ruleCastExpression
	{ $current=$iv_ruleCastExpression.current; }
	EOF;

// Rule CastExpression
ruleCastExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='ctor'
		{
			newLeafNode(otherlv_0, grammarAccess.getCastExpressionAccess().getCtorKeyword_0());
		}
		otherlv_1='<'
		{
			newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLessThanSignKeyword_1());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCastExpressionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getCastExpressionAccess().getDatatypeDataTypeCrossReference_2_0());
				}
				ruleESUfid
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='>'
		{
			newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getGreaterThanSignKeyword_3());
		}
		otherlv_4='('
		{
			newLeafNode(otherlv_4, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCastExpressionAccess().getOperandExpressionParserRuleCall_5_0());
				}
				lv_operand_5_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCastExpressionRule());
					}
					set(
						$current,
						"operand",
						lv_operand_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=')'
		{
			newLeafNode(otherlv_6, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_6());
		}
	)
;

// Entry rule entryRuleArithmeticUnaryExpression
entryRuleArithmeticUnaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArithmeticUnaryExpressionRule()); }
	iv_ruleArithmeticUnaryExpression=ruleArithmeticUnaryExpression
	{ $current=$iv_ruleArithmeticUnaryExpression.current; }
	EOF;

// Rule ArithmeticUnaryExpression
ruleArithmeticUnaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getArithmeticUnaryExpressionAccess().getOperatorArithmeticUnaryOperatorParserRuleCall_0_0());
				}
				lv_operator_0_0=ruleArithmeticUnaryOperator
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getArithmeticUnaryExpressionRule());
					}
					set(
						$current,
						"operator",
						lv_operator_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ArithmeticUnaryOperator");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getArithmeticUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0());
				}
				lv_operand_1_0=ruleUnaryExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getArithmeticUnaryExpressionRule());
					}
					set(
						$current,
						"operand",
						lv_operand_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleArithmeticUnaryOperator
entryRuleArithmeticUnaryOperator returns [String current=null]:
	{ newCompositeNode(grammarAccess.getArithmeticUnaryOperatorRule()); }
	iv_ruleArithmeticUnaryOperator=ruleArithmeticUnaryOperator
	{ $current=$iv_ruleArithmeticUnaryOperator.current.getText(); }
	EOF;

// Rule ArithmeticUnaryOperator
ruleArithmeticUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='+'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArithmeticUnaryOperatorAccess().getPlusSignKeyword_0());
		}
		    |
		kw='-'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArithmeticUnaryOperatorAccess().getHyphenMinusKeyword_1());
		}
	)
;

// Entry rule entryRuleQuantifiedLogicalExpression
entryRuleQuantifiedLogicalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQuantifiedLogicalExpressionRule()); }
	iv_ruleQuantifiedLogicalExpression=ruleQuantifiedLogicalExpression
	{ $current=$iv_ruleQuantifiedLogicalExpression.current; }
	EOF;

// Rule QuantifiedLogicalExpression
ruleQuantifiedLogicalExpression returns [EObject current=null]
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
					lv_quantifier_0_1='forall'
					{
						newLeafNode(lv_quantifier_0_1, grammarAccess.getQuantifiedLogicalExpressionAccess().getQuantifierForallKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getQuantifiedLogicalExpressionRule());
						}
						setWithLastConsumed($current, "quantifier", lv_quantifier_0_1, null);
					}
					    |
					lv_quantifier_0_2='exists'
					{
						newLeafNode(lv_quantifier_0_2, grammarAccess.getQuantifiedLogicalExpressionAccess().getQuantifierExistsKeyword_0_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getQuantifiedLogicalExpressionRule());
						}
						setWithLastConsumed($current, "quantifier", lv_quantifier_0_2, null);
					}
				)
			)
		)
		otherlv_1='<'
		{
			newLeafNode(otherlv_1, grammarAccess.getQuantifiedLogicalExpressionAccess().getLessThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getQuantifiedLogicalExpressionAccess().getVariableBoundVariableParserRuleCall_2_0());
				}
				lv_variable_2_0=ruleBoundVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQuantifiedLogicalExpressionRule());
					}
					add(
						$current,
						"variable",
						lv_variable_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BoundVariable");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=','
			{
				newLeafNode(otherlv_3, grammarAccess.getQuantifiedLogicalExpressionAccess().getCommaKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getQuantifiedLogicalExpressionAccess().getVariableBoundVariableParserRuleCall_3_1_0());
					}
					lv_variable_4_0=ruleBoundVariable
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQuantifiedLogicalExpressionRule());
						}
						add(
							$current,
							"variable",
							lv_variable_4_0,
							"org.eclipse.efm.formalml.xtext.FormalML.BoundVariable");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_5='>'
		{
			newLeafNode(otherlv_5, grammarAccess.getQuantifiedLogicalExpressionAccess().getGreaterThanSignKeyword_4());
		}
		otherlv_6='('
		{
			newLeafNode(otherlv_6, grammarAccess.getQuantifiedLogicalExpressionAccess().getLeftParenthesisKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getQuantifiedLogicalExpressionAccess().getPredicateExpressionParserRuleCall_6_0());
				}
				lv_predicate_7_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQuantifiedLogicalExpressionRule());
					}
					set(
						$current,
						"predicate",
						lv_predicate_7_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8=')'
		{
			newLeafNode(otherlv_8, grammarAccess.getQuantifiedLogicalExpressionAccess().getRightParenthesisKeyword_7());
		}
	)
;

// Entry rule entryRuleBoundVariable
entryRuleBoundVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBoundVariableRule()); }
	iv_ruleBoundVariable=ruleBoundVariable
	{ $current=$iv_ruleBoundVariable.current; }
	EOF;

// Rule BoundVariable
ruleBoundVariable returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getBoundVariableAccess().getNameESIdentifierParserRuleCall_0_0());
				}
				lv_name_0_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBoundVariableRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getBoundVariableAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getBoundVariableAccess().getTypeDataTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBoundVariableRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLogicalUnaryExpression
entryRuleLogicalUnaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLogicalUnaryExpressionRule()); }
	iv_ruleLogicalUnaryExpression=ruleLogicalUnaryExpression
	{ $current=$iv_ruleLogicalUnaryExpression.current; }
	EOF;

// Rule LogicalUnaryExpression
ruleLogicalUnaryExpression returns [EObject current=null]
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
					lv_operator_0_1='!'
					{
						newLeafNode(lv_operator_0_1, grammarAccess.getLogicalUnaryExpressionAccess().getOperatorExclamationMarkKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLogicalUnaryExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_0_1, null);
					}
					    |
					lv_operator_0_2='not'
					{
						newLeafNode(lv_operator_0_2, grammarAccess.getLogicalUnaryExpressionAccess().getOperatorNotKeyword_0_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLogicalUnaryExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_0_2, null);
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLogicalUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0());
				}
				lv_operand_1_0=ruleUnaryExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLogicalUnaryExpressionRule());
					}
					set(
						$current,
						"operand",
						lv_operand_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBitwiseUnaryExpression
entryRuleBitwiseUnaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBitwiseUnaryExpressionRule()); }
	iv_ruleBitwiseUnaryExpression=ruleBitwiseUnaryExpression
	{ $current=$iv_ruleBitwiseUnaryExpression.current; }
	EOF;

// Rule BitwiseUnaryExpression
ruleBitwiseUnaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_operator_0_0='~'
				{
					newLeafNode(lv_operator_0_0, grammarAccess.getBitwiseUnaryExpressionAccess().getOperatorTildeKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBitwiseUnaryExpressionRule());
					}
					setWithLastConsumed($current, "operator", lv_operator_0_0, "~");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBitwiseUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0());
				}
				lv_operand_1_0=ruleUnaryExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBitwiseUnaryExpressionRule());
					}
					set(
						$current,
						"operand",
						lv_operand_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnaryExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRulePrimaryExpression
entryRulePrimaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryExpressionRule()); }
	iv_rulePrimaryExpression=rulePrimaryExpression
	{ $current=$iv_rulePrimaryExpression.current; }
	EOF;

// Rule PrimaryExpression
rulePrimaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBaseExpressionParserRuleCall_0());
		}
		this_BaseExpression_0=ruleBaseExpression
		{
			$current = $this_BaseExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_1_0(),
						$current);
				}
			)
			otherlv_2='.'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_1());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimaryExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getElementNamedElementCrossReference_1_2_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getKindValueIndexExpressionKindEnumRuleCall_1_3_0_0_0());
							}
							lv_kind_4_0=ruleValueIndexExpressionKind
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
								}
								set(
									$current,
									"kind",
									lv_kind_4_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ValueIndexExpressionKind");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgPositionalTupleExpressionListParserRuleCall_1_3_0_1_0());
							}
							lv_arg_5_0=rulePositionalTupleExpressionList
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
								}
								set(
									$current,
									"arg",
									lv_arg_5_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PositionalTupleExpressionList");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_6=']'
					{
						newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getRightSquareBracketKeyword_1_3_0_2());
					}
				)
				    |
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getKindValueParameterExpressionKindEnumRuleCall_1_3_1_0_0());
							}
							lv_kind_7_0=ruleValueParameterExpressionKind
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
								}
								set(
									$current,
									"kind",
									lv_kind_7_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ValueParameterExpressionKind");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgMixTupleExpressionListParserRuleCall_1_3_1_1_0());
							}
							lv_arg_8_0=ruleMixTupleExpressionList
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
								}
								set(
									$current,
									"arg",
									lv_arg_8_0,
									"org.eclipse.efm.formalml.xtext.FormalML.MixTupleExpressionList");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_9=')'
					{
						newLeafNode(otherlv_9, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_3_1_2());
					}
				)
			)?
		)*
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_2_0(),
						$current);
				}
			)
			otherlv_11='->'
			{
				newLeafNode(otherlv_11, grammarAccess.getPrimaryExpressionAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimaryExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getElementNamedElementCrossReference_2_2_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getKindValueIndexExpressionKindEnumRuleCall_2_3_0_0_0());
							}
							lv_kind_13_0=ruleValueIndexExpressionKind
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
								}
								set(
									$current,
									"kind",
									lv_kind_13_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ValueIndexExpressionKind");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgPositionalTupleExpressionListParserRuleCall_2_3_0_1_0());
							}
							lv_arg_14_0=rulePositionalTupleExpressionList
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
								}
								set(
									$current,
									"arg",
									lv_arg_14_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PositionalTupleExpressionList");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_15=']'
					{
						newLeafNode(otherlv_15, grammarAccess.getPrimaryExpressionAccess().getRightSquareBracketKeyword_2_3_0_2());
					}
				)
				    |
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getKindValueParameterExpressionKindEnumRuleCall_2_3_1_0_0());
							}
							lv_kind_16_0=ruleValueParameterExpressionKind
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
								}
								set(
									$current,
									"kind",
									lv_kind_16_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ValueParameterExpressionKind");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgMixTupleExpressionListParserRuleCall_2_3_1_1_0());
							}
							lv_arg_17_0=ruleMixTupleExpressionList
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
								}
								set(
									$current,
									"arg",
									lv_arg_17_0,
									"org.eclipse.efm.formalml.xtext.FormalML.MixTupleExpressionList");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_18=')'
					{
						newLeafNode(otherlv_18, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_3_1_2());
					}
				)
			)?
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_2_4_0(),
							$current);
					}
				)
				otherlv_20='.'
				{
					newLeafNode(otherlv_20, grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_2_4_1());
				}
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getPrimaryExpressionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getElementNamedElementCrossReference_2_4_2_0());
						}
						ruleESIdentifier
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getKindValueIndexExpressionKindEnumRuleCall_2_4_3_0_0_0());
								}
								lv_kind_22_0=ruleValueIndexExpressionKind
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
									}
									set(
										$current,
										"kind",
										lv_kind_22_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ValueIndexExpressionKind");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgPositionalTupleExpressionListParserRuleCall_2_4_3_0_1_0());
								}
								lv_arg_23_0=rulePositionalTupleExpressionList
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
									}
									set(
										$current,
										"arg",
										lv_arg_23_0,
										"org.eclipse.efm.formalml.xtext.FormalML.PositionalTupleExpressionList");
									afterParserOrEnumRuleCall();
								}
							)
						)
						otherlv_24=']'
						{
							newLeafNode(otherlv_24, grammarAccess.getPrimaryExpressionAccess().getRightSquareBracketKeyword_2_4_3_0_2());
						}
					)
					    |
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getKindValueParameterExpressionKindEnumRuleCall_2_4_3_1_0_0());
								}
								lv_kind_25_0=ruleValueParameterExpressionKind
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
									}
									set(
										$current,
										"kind",
										lv_kind_25_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ValueParameterExpressionKind");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgMixTupleExpressionListParserRuleCall_2_4_3_1_1_0());
								}
								lv_arg_26_0=ruleMixTupleExpressionList
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
									}
									set(
										$current,
										"arg",
										lv_arg_26_0,
										"org.eclipse.efm.formalml.xtext.FormalML.MixTupleExpressionList");
									afterParserOrEnumRuleCall();
								}
							)
						)
						otherlv_27=')'
						{
							newLeafNode(otherlv_27, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_4_3_1_2());
						}
					)
				)?
			)*
		)?
	)
;

// Entry rule entryRuleBaseExpression
entryRuleBaseExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBaseExpressionRule()); }
	iv_ruleBaseExpression=ruleBaseExpression
	{ $current=$iv_ruleBaseExpression.current; }
	EOF;

// Rule BaseExpression
ruleBaseExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getBaseExpressionAccess().getLiteralReferenceableExpressionParserRuleCall_0());
		}
		this_LiteralReferenceableExpression_0=ruleLiteralReferenceableExpression
		{
			$current = $this_LiteralReferenceableExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getBaseExpressionAccess().getLeftParenthesisKeyword_1_0());
			}
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getBaseExpressionAccess().getExpressionParserRuleCall_1_1());
			}
			this_Expression_2=ruleExpression
			{
				$current = $this_Expression_2.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_3=')'
			{
				newLeafNode(otherlv_3, grammarAccess.getBaseExpressionAccess().getRightParenthesisKeyword_1_2());
			}
		)
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getBaseExpressionAccess().getInvokeExpressionDeprecatedParserRuleCall_2());
		}
		this_InvokeExpressionDeprecated_4=ruleInvokeExpressionDeprecated
		{
			$current = $this_InvokeExpressionDeprecated_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getBaseExpressionAccess().getInstantiationExpressionParserRuleCall_3());
		}
		this_InstantiationExpression_5=ruleInstantiationExpression
		{
			$current = $this_InstantiationExpression_5.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleInvokeExpressionDeprecated
entryRuleInvokeExpressionDeprecated returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInvokeExpressionDeprecatedRule()); }
	iv_ruleInvokeExpressionDeprecated=ruleInvokeExpressionDeprecated
	{ $current=$iv_ruleInvokeExpressionDeprecated.current; }
	EOF;

// Rule InvokeExpressionDeprecated
ruleInvokeExpressionDeprecated returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getInvokeExpressionDeprecatedAccess().getInvokeExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='(:'
		{
			newLeafNode(otherlv_1, grammarAccess.getInvokeExpressionDeprecatedAccess().getLeftParenthesisColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getInvokeExpressionDeprecatedAccess().getArgsExpressionParserRuleCall_2_0());
				}
				lv_args_2_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInvokeExpressionDeprecatedRule());
					}
					add(
						$current,
						"args",
						lv_args_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getInvokeExpressionDeprecatedAccess().getInvokeLiteralReferenceElementParserRuleCall_3_0());
				}
				lv_invoke_3_0=ruleLiteralReferenceElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInvokeExpressionDeprecatedRule());
					}
					set(
						$current,
						"invoke",
						lv_invoke_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.LiteralReferenceElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getInvokeExpressionDeprecatedAccess().getArgsExpressionParserRuleCall_4_0());
				}
				lv_args_4_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInvokeExpressionDeprecatedRule());
					}
					add(
						$current,
						"args",
						lv_args_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getInvokeExpressionDeprecatedAccess().getRightParenthesisKeyword_5());
		}
	)
;

// Entry rule entryRuleInstantiationExpression
entryRuleInstantiationExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInstantiationExpressionRule()); }
	iv_ruleInstantiationExpression=ruleInstantiationExpression
	{ $current=$iv_ruleInstantiationExpression.current; }
	EOF;

// Rule InstantiationExpression
ruleInstantiationExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getInstantiationExpressionAccess().getInstantiationExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getInstantiationExpressionAccess().getInstanceDynamicInstanceSpecificationParserRuleCall_1_0());
				}
				lv_instance_1_0=ruleDynamicInstanceSpecification
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInstantiationExpressionRule());
					}
					set(
						$current,
						"instance",
						lv_instance_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DynamicInstanceSpecification");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=';'
		{
			newLeafNode(otherlv_2, grammarAccess.getInstantiationExpressionAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleDynamicInstanceSpecification
entryRuleDynamicInstanceSpecification returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDynamicInstanceSpecificationRule()); }
	iv_ruleDynamicInstanceSpecification=ruleDynamicInstanceSpecification
	{ $current=$iv_ruleDynamicInstanceSpecification.current; }
	EOF;

// Rule DynamicInstanceSpecification
ruleDynamicInstanceSpecification returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getDynamicInstanceSpecificationAccess().getInstanceMachineAction_0(),
					$current);
			}
		)
		otherlv_1='new'
		{
			newLeafNode(otherlv_1, grammarAccess.getDynamicInstanceSpecificationAccess().getNewKeyword_1());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDynamicInstanceSpecificationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getDynamicInstanceSpecificationAccess().getModelMachineCrossReference_2_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				otherlv_3='('
				{
					newLeafNode(otherlv_3, grammarAccess.getDynamicInstanceSpecificationAccess().getLeftParenthesisKeyword_3_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getDynamicInstanceSpecificationAccess().getSlotSlotParameterParserRuleCall_3_0_1_0_0());
							}
							lv_slot_4_0=ruleSlotParameter
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getDynamicInstanceSpecificationRule());
								}
								add(
									$current,
									"slot",
									lv_slot_4_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SlotParameter");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_5=','
						{
							newLeafNode(otherlv_5, grammarAccess.getDynamicInstanceSpecificationAccess().getCommaKeyword_3_0_1_1_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getDynamicInstanceSpecificationAccess().getSlotSlotParameterParserRuleCall_3_0_1_1_1_0());
								}
								lv_slot_6_0=ruleSlotParameter
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getDynamicInstanceSpecificationRule());
									}
									add(
										$current,
										"slot",
										lv_slot_6_0,
										"org.eclipse.efm.formalml.xtext.FormalML.SlotParameter");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)?
				otherlv_7=')'
				{
					newLeafNode(otherlv_7, grammarAccess.getDynamicInstanceSpecificationAccess().getRightParenthesisKeyword_3_0_2());
				}
			)
			    |
			(
				otherlv_8='{'
				{
					newLeafNode(otherlv_8, grammarAccess.getDynamicInstanceSpecificationAccess().getLeftCurlyBracketKeyword_3_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getDynamicInstanceSpecificationAccess().getSlotSlotPropertyParserRuleCall_3_1_1_0_0());
							}
							lv_slot_9_0=ruleSlotProperty
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getDynamicInstanceSpecificationRule());
								}
								add(
									$current,
									"slot",
									lv_slot_9_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SlotProperty");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_10=';'
					{
						newLeafNode(otherlv_10, grammarAccess.getDynamicInstanceSpecificationAccess().getSemicolonKeyword_3_1_1_1());
					}
				)*
				otherlv_11='}'
				{
					newLeafNode(otherlv_11, grammarAccess.getDynamicInstanceSpecificationAccess().getRightCurlyBracketKeyword_3_1_2());
				}
			)
		)?
	)
;

// Entry rule entryRuleTupleParameterExpression
entryRuleTupleParameterExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTupleParameterExpressionRule()); }
	iv_ruleTupleParameterExpression=ruleTupleParameterExpression
	{ $current=$iv_ruleTupleParameterExpression.current; }
	EOF;

// Rule TupleParameterExpression
ruleTupleParameterExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getTupleParameterExpressionAccess().getLeftParenthesisKeyword_0());
		}
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTupleParameterExpressionAccess().getMixTupleExpressionListParserRuleCall_1());
		}
		this_MixTupleExpressionList_1=ruleMixTupleExpressionList
		{
			$current = $this_MixTupleExpressionList_1.current;
			afterParserOrEnumRuleCall();
		}
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getTupleParameterExpressionAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleMixTupleExpressionList
entryRuleMixTupleExpressionList returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMixTupleExpressionListRule()); }
	iv_ruleMixTupleExpressionList=ruleMixTupleExpressionList
	{ $current=$iv_ruleMixTupleExpressionList.current; }
	EOF;

// Rule MixTupleExpressionList
ruleMixTupleExpressionList returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMixTupleExpressionListAccess().getMixTupleExpressionAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getMixTupleExpressionListAccess().getValueExpressionParserRuleCall_1_0_0());
					}
					lv_value_1_1=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMixTupleExpressionListRule());
						}
						add(
							$current,
							"value",
							lv_value_1_1,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
					    |
					{
						newCompositeNode(grammarAccess.getMixTupleExpressionListAccess().getValueNamedExpressionParserRuleCall_1_0_1());
					}
					lv_value_1_2=ruleNamedExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMixTupleExpressionListRule());
						}
						add(
							$current,
							"value",
							lv_value_1_2,
							"org.eclipse.efm.formalml.xtext.FormalML.NamedExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getMixTupleExpressionListAccess().getCommaKeyword_2_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getMixTupleExpressionListAccess().getValueExpressionParserRuleCall_2_1_0_0());
						}
						lv_value_3_1=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMixTupleExpressionListRule());
							}
							add(
								$current,
								"value",
								lv_value_3_1,
								"org.eclipse.efm.formalml.xtext.FormalML.Expression");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getMixTupleExpressionListAccess().getValueNamedExpressionParserRuleCall_2_1_0_1());
						}
						lv_value_3_2=ruleNamedExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMixTupleExpressionListRule());
							}
							add(
								$current,
								"value",
								lv_value_3_2,
								"org.eclipse.efm.formalml.xtext.FormalML.NamedExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;

// Entry rule entryRulePositionalTupleExpressionList
entryRulePositionalTupleExpressionList returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPositionalTupleExpressionListRule()); }
	iv_rulePositionalTupleExpressionList=rulePositionalTupleExpressionList
	{ $current=$iv_rulePositionalTupleExpressionList.current; }
	EOF;

// Rule PositionalTupleExpressionList
rulePositionalTupleExpressionList returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getPositionalTupleExpressionListAccess().getValueExpressionParserRuleCall_0_0());
				}
				lv_value_0_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPositionalTupleExpressionListRule());
					}
					add(
						$current,
						"value",
						lv_value_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=','
			{
				newLeafNode(otherlv_1, grammarAccess.getPositionalTupleExpressionListAccess().getCommaKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getPositionalTupleExpressionListAccess().getValueExpressionParserRuleCall_1_1_0());
					}
					lv_value_2_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPositionalTupleExpressionListRule());
						}
						add(
							$current,
							"value",
							lv_value_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleNamedExpression
entryRuleNamedExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNamedExpressionRule()); }
	iv_ruleNamedExpression=ruleNamedExpression
	{ $current=$iv_ruleNamedExpression.current; }
	EOF;

// Rule NamedExpression
ruleNamedExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_XLIA_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getNamedExpressionAccess().getNameXLIA_IDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNamedExpressionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XLIA_ID");
				}
			)
		)
		(
			otherlv_1=':'
			{
				newLeafNode(otherlv_1, grammarAccess.getNamedExpressionAccess().getColonKeyword_1_0());
			}
			    |
			otherlv_2='=>'
			{
				newLeafNode(otherlv_2, grammarAccess.getNamedExpressionAccess().getEqualsSignGreaterThanSignKeyword_1_1());
			}
			    |
			otherlv_3='<-'
			{
				newLeafNode(otherlv_3, grammarAccess.getNamedExpressionAccess().getLessThanSignHyphenMinusKeyword_1_2());
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getNamedExpressionAccess().getExpressionExpressionParserRuleCall_2_0());
				}
				lv_expression_4_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNamedExpressionRule());
					}
					set(
						$current,
						"expression",
						lv_expression_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralReferenceableExpression
entryRuleLiteralReferenceableExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralReferenceableExpressionRule()); }
	iv_ruleLiteralReferenceableExpression=ruleLiteralReferenceableExpression
	{ $current=$iv_ruleLiteralReferenceableExpression.current; }
	EOF;

// Rule LiteralReferenceableExpression
ruleLiteralReferenceableExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceableExpressionAccess().getLiteralCollectionExpressionParserRuleCall_0());
		}
		this_LiteralCollectionExpression_0=ruleLiteralCollectionExpression
		{
			$current = $this_LiteralCollectionExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceableExpressionAccess().getLiteralReferenceExpressionParserRuleCall_1());
		}
		this_LiteralReferenceExpression_1=ruleLiteralReferenceExpression
		{
			$current = $this_LiteralReferenceExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralTerminalExpression
entryRuleLiteralTerminalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralTerminalExpressionRule()); }
	iv_ruleLiteralTerminalExpression=ruleLiteralTerminalExpression
	{ $current=$iv_ruleLiteralTerminalExpression.current; }
	EOF;

// Rule LiteralTerminalExpression
ruleLiteralTerminalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralBooleanExpressionParserRuleCall_0());
		}
		this_LiteralBooleanExpression_0=ruleLiteralBooleanExpression
		{
			$current = $this_LiteralBooleanExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralIntegerExpressionParserRuleCall_1());
		}
		this_LiteralIntegerExpression_1=ruleLiteralIntegerExpression
		{
			$current = $this_LiteralIntegerExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralRationalExpressionParserRuleCall_2());
		}
		this_LiteralRationalExpression_2=ruleLiteralRationalExpression
		{
			$current = $this_LiteralRationalExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralFloatExpressionParserRuleCall_3());
		}
		this_LiteralFloatExpression_3=ruleLiteralFloatExpression
		{
			$current = $this_LiteralFloatExpression_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralCharacterExpressionParserRuleCall_4());
		}
		this_LiteralCharacterExpression_4=ruleLiteralCharacterExpression
		{
			$current = $this_LiteralCharacterExpression_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralStringExpressionParserRuleCall_5());
		}
		this_LiteralStringExpression_5=ruleLiteralStringExpression
		{
			$current = $this_LiteralStringExpression_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralNullExpressionParserRuleCall_6());
		}
		this_LiteralNullExpression_6=ruleLiteralNullExpression
		{
			$current = $this_LiteralNullExpression_6.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralBooleanExpression
entryRuleLiteralBooleanExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralBooleanExpressionRule()); }
	iv_ruleLiteralBooleanExpression=ruleLiteralBooleanExpression
	{ $current=$iv_ruleLiteralBooleanExpression.current; }
	EOF;

// Rule LiteralBooleanExpression
ruleLiteralBooleanExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralBooleanExpressionAccess().getLiteralBooleanExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralBooleanExpressionAccess().getValueEBooleanParserRuleCall_1_0());
				}
				lv_value_1_0=ruleEBoolean
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralBooleanExpressionRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EBoolean");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralIntegerExpression
entryRuleLiteralIntegerExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralIntegerExpressionRule()); }
	iv_ruleLiteralIntegerExpression=ruleLiteralIntegerExpression
	{ $current=$iv_ruleLiteralIntegerExpression.current; }
	EOF;

// Rule LiteralIntegerExpression
ruleLiteralIntegerExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralIntegerExpressionAccess().getLiteralIntegerExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralIntegerExpressionAccess().getValueEIntegerParserRuleCall_1_0());
				}
				lv_value_1_0=ruleEInteger
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralIntegerExpressionRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EInteger");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralRationalExpression
entryRuleLiteralRationalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralRationalExpressionRule()); }
	iv_ruleLiteralRationalExpression=ruleLiteralRationalExpression
	{ $current=$iv_ruleLiteralRationalExpression.current; }
	EOF;

// Rule LiteralRationalExpression
ruleLiteralRationalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralRationalExpressionAccess().getLiteralRationalExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralRationalExpressionAccess().getNumeratorEIntegerParserRuleCall_1_0());
				}
				lv_numerator_1_0=ruleEInteger
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralRationalExpressionRule());
					}
					set(
						$current,
						"numerator",
						lv_numerator_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EInteger");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='/'
		{
			newLeafNode(otherlv_2, grammarAccess.getLiteralRationalExpressionAccess().getSolidusKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralRationalExpressionAccess().getDenominatorEIntegerParserRuleCall_3_0());
				}
				lv_denominator_3_0=ruleEInteger
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralRationalExpressionRule());
					}
					set(
						$current,
						"denominator",
						lv_denominator_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EInteger");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralFloatExpression
entryRuleLiteralFloatExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralFloatExpressionRule()); }
	iv_ruleLiteralFloatExpression=ruleLiteralFloatExpression
	{ $current=$iv_ruleLiteralFloatExpression.current; }
	EOF;

// Rule LiteralFloatExpression
ruleLiteralFloatExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralFloatExpressionAccess().getLiteralFloatExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralFloatExpressionAccess().getValueEDoubleParserRuleCall_1_0());
				}
				lv_value_1_0=ruleEDouble
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralFloatExpressionRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EDouble");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralCharacterExpression
entryRuleLiteralCharacterExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralCharacterExpressionRule()); }
	iv_ruleLiteralCharacterExpression=ruleLiteralCharacterExpression
	{ $current=$iv_ruleLiteralCharacterExpression.current; }
	EOF;

// Rule LiteralCharacterExpression
ruleLiteralCharacterExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralCharacterExpressionAccess().getLiteralCharacterExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralCharacterExpressionAccess().getValueECharacterParserRuleCall_1_0());
				}
				lv_value_1_0=ruleECharacter
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralCharacterExpressionRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ECharacter");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralStringExpression
entryRuleLiteralStringExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralStringExpressionRule()); }
	iv_ruleLiteralStringExpression=ruleLiteralStringExpression
	{ $current=$iv_ruleLiteralStringExpression.current; }
	EOF;

// Rule LiteralStringExpression
ruleLiteralStringExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralStringExpressionAccess().getLiteralStringExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralStringExpressionAccess().getValueEStringParserRuleCall_1_0());
				}
				lv_value_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralStringExpressionRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralNullExpression
entryRuleLiteralNullExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralNullExpressionRule()); }
	iv_ruleLiteralNullExpression=ruleLiteralNullExpression
	{ $current=$iv_ruleLiteralNullExpression.current; }
	EOF;

// Rule LiteralNullExpression
ruleLiteralNullExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralNullExpressionAccess().getLiteralNullExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$null'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralNullExpressionAccess().getNullKeyword_1());
		}
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralNullExpressionAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralNullExpressionAccess().getTypeNullPrimitiveInstanceTypeParserRuleCall_2_1_0());
					}
					lv_type_3_0=ruleNullPrimitiveInstanceType
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralNullExpressionRule());
						}
						set(
							$current,
							"type",
							lv_type_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.NullPrimitiveInstanceType");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='>'
			{
				newLeafNode(otherlv_4, grammarAccess.getLiteralNullExpressionAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
	)
;

// Entry rule entryRuleNullPrimitiveInstanceType
entryRuleNullPrimitiveInstanceType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNullPrimitiveInstanceTypeRule()); }
	iv_ruleNullPrimitiveInstanceType=ruleNullPrimitiveInstanceType
	{ $current=$iv_ruleNullPrimitiveInstanceType.current; }
	EOF;

// Rule NullPrimitiveInstanceType
ruleNullPrimitiveInstanceType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getNullPrimitiveInstanceTypeAccess().getPrimitiveInstanceTypeAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getNullPrimitiveInstanceTypeAccess().getExpectedPrimitiveInstanceKindEnumRuleCall_0_1_0());
					}
					lv_expected_1_0=rulePrimitiveInstanceKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNullPrimitiveInstanceTypeRule());
						}
						set(
							$current,
							"expected",
							lv_expected_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.PrimitiveInstanceKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getNullPrimitiveInstanceTypeAccess().getPrimitiveInstanceTypeAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getNullPrimitiveInstanceTypeRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getNullPrimitiveInstanceTypeAccess().getModelNamedElementCrossReference_1_1_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleLiteralCollectionExpression
entryRuleLiteralCollectionExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralCollectionExpressionRule()); }
	iv_ruleLiteralCollectionExpression=ruleLiteralCollectionExpression
	{ $current=$iv_ruleLiteralCollectionExpression.current; }
	EOF;

// Rule LiteralCollectionExpression
ruleLiteralCollectionExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralCollectionExpressionAccess().getLiteralCollectionExpressionAction_0(),
					$current);
			}
		)
		(
			otherlv_1='<'
			{
				newLeafNode(otherlv_1, grammarAccess.getLiteralCollectionExpressionAccess().getLessThanSignKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralCollectionExpressionAccess().getDatatypeDataTypeParserRuleCall_1_1_0());
					}
					lv_datatype_2_0=ruleDataType
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralCollectionExpressionRule());
						}
						set(
							$current,
							"datatype",
							lv_datatype_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.DataType");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3='>'
			{
				newLeafNode(otherlv_3, grammarAccess.getLiteralCollectionExpressionAccess().getGreaterThanSignKeyword_1_2());
			}
		)?
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getLiteralCollectionExpressionAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getLiteralCollectionExpressionAccess().getValueExpressionParserRuleCall_3_0_0_0());
						}
						lv_value_5_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralCollectionExpressionRule());
							}
							add(
								$current,
								"value",
								lv_value_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getLiteralCollectionExpressionAccess().getValueNamedExpressionParserRuleCall_3_0_1_0());
						}
						lv_value_6_0=ruleNamedExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralCollectionExpressionRule());
							}
							add(
								$current,
								"value",
								lv_value_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.NamedExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			(
				otherlv_7=','
				{
					newLeafNode(otherlv_7, grammarAccess.getLiteralCollectionExpressionAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getLiteralCollectionExpressionAccess().getValueExpressionParserRuleCall_3_1_1_0_0());
							}
							lv_value_8_0=ruleExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getLiteralCollectionExpressionRule());
								}
								add(
									$current,
									"value",
									lv_value_8_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Expression");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getLiteralCollectionExpressionAccess().getValueNamedExpressionParserRuleCall_3_1_1_1_0());
							}
							lv_value_9_0=ruleNamedExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getLiteralCollectionExpressionRule());
								}
								add(
									$current,
									"value",
									lv_value_9_0,
									"org.eclipse.efm.formalml.xtext.FormalML.NamedExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)*
		)?
		otherlv_10='}'
		{
			newLeafNode(otherlv_10, grammarAccess.getLiteralCollectionExpressionAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleLiteralReferenceExpression
entryRuleLiteralReferenceExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralReferenceExpressionRule()); }
	iv_ruleLiteralReferenceExpression=ruleLiteralReferenceExpression
	{ $current=$iv_ruleLiteralReferenceExpression.current; }
	EOF;

// Rule LiteralReferenceExpression
ruleLiteralReferenceExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceExpressionAccess().getLiteralReferenceElementParserRuleCall_0());
		}
		this_LiteralReferenceElement_0=ruleLiteralReferenceElement
		{
			$current = $this_LiteralReferenceElement_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceExpressionAccess().getLiteralReferenceVariableContextParserRuleCall_1());
		}
		this_LiteralReferenceVariableContext_1=ruleLiteralReferenceVariableContext
		{
			$current = $this_LiteralReferenceVariableContext_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceExpressionAccess().getLiteralReferenceMachineContextParserRuleCall_2());
		}
		this_LiteralReferenceMachineContext_2=ruleLiteralReferenceMachineContext
		{
			$current = $this_LiteralReferenceMachineContext_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceExpressionAccess().getLiteralEnvExpressionParserRuleCall_3());
		}
		this_LiteralEnvExpression_3=ruleLiteralEnvExpression
		{
			$current = $this_LiteralEnvExpression_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralReferenceElement
entryRuleLiteralReferenceElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralReferenceElementRule()); }
	iv_ruleLiteralReferenceElement=ruleLiteralReferenceElement
	{ $current=$iv_ruleLiteralReferenceElement.current; }
	EOF;

// Rule LiteralReferenceElement
ruleLiteralReferenceElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralReferenceElementAccess().getLiteralReferenceElementAction_0(),
					$current);
			}
		)
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralReferenceElementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getValueNamedElementCrossReference_1_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getKindValueIndexExpressionKindEnumRuleCall_2_0_0_0());
						}
						lv_kind_2_0=ruleValueIndexExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralReferenceElementRule());
							}
							set(
								$current,
								"kind",
								lv_kind_2_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueIndexExpressionKind");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getArgPositionalTupleExpressionListParserRuleCall_2_0_1_0());
						}
						lv_arg_3_0=rulePositionalTupleExpressionList
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralReferenceElementRule());
							}
							set(
								$current,
								"arg",
								lv_arg_3_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PositionalTupleExpressionList");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_4=']'
				{
					newLeafNode(otherlv_4, grammarAccess.getLiteralReferenceElementAccess().getRightSquareBracketKeyword_2_0_2());
				}
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getKindValueParameterExpressionKindEnumRuleCall_2_1_0_0());
						}
						lv_kind_5_0=ruleValueParameterExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralReferenceElementRule());
							}
							set(
								$current,
								"kind",
								lv_kind_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueParameterExpressionKind");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getArgMixTupleExpressionListParserRuleCall_2_1_1_0());
						}
						lv_arg_6_0=ruleMixTupleExpressionList
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralReferenceElementRule());
							}
							set(
								$current,
								"arg",
								lv_arg_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.MixTupleExpressionList");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_7=')'
				{
					newLeafNode(otherlv_7, grammarAccess.getLiteralReferenceElementAccess().getRightParenthesisKeyword_2_1_2());
				}
			)
		)?
	)
;

// Entry rule entryRuleLiteralPureReferenceElement
entryRuleLiteralPureReferenceElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralPureReferenceElementRule()); }
	iv_ruleLiteralPureReferenceElement=ruleLiteralPureReferenceElement
	{ $current=$iv_ruleLiteralPureReferenceElement.current; }
	EOF;

// Rule LiteralPureReferenceElement
ruleLiteralPureReferenceElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralPureReferenceElementAccess().getLiteralReferenceElementAction_0(),
					$current);
			}
		)
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralPureReferenceElementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getLiteralPureReferenceElementAccess().getValueNamedElementCrossReference_1_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralReferenceVariableContext
entryRuleLiteralReferenceVariableContext returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralReferenceVariableContextRule()); }
	iv_ruleLiteralReferenceVariableContext=ruleLiteralReferenceVariableContext
	{ $current=$iv_ruleLiteralReferenceVariableContext.current; }
	EOF;

// Rule LiteralReferenceVariableContext
ruleLiteralReferenceVariableContext returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceVariableContextAccess().getLiteralTimeExpressionParserRuleCall_0());
		}
		this_LiteralTimeExpression_0=ruleLiteralTimeExpression
		{
			$current = $this_LiteralTimeExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceVariableContextAccess().getLiteralTimeDeltaExpressionParserRuleCall_1());
		}
		this_LiteralTimeDeltaExpression_1=ruleLiteralTimeDeltaExpression
		{
			$current = $this_LiteralTimeDeltaExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralTimeExpression
entryRuleLiteralTimeExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralTimeExpressionRule()); }
	iv_ruleLiteralTimeExpression=ruleLiteralTimeExpression
	{ $current=$iv_ruleLiteralTimeExpression.current; }
	EOF;

// Rule LiteralTimeExpression
ruleLiteralTimeExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralTimeExpressionAccess().getLiteralTimeExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$time'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralTimeExpressionAccess().getTimeKeyword_1());
		}
	)
;

// Entry rule entryRuleLiteralTimeDeltaExpression
entryRuleLiteralTimeDeltaExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralTimeDeltaExpressionRule()); }
	iv_ruleLiteralTimeDeltaExpression=ruleLiteralTimeDeltaExpression
	{ $current=$iv_ruleLiteralTimeDeltaExpression.current; }
	EOF;

// Rule LiteralTimeDeltaExpression
ruleLiteralTimeDeltaExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralTimeDeltaExpressionAccess().getLiteralTimeDeltaExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$delta'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralTimeDeltaExpressionAccess().getDeltaKeyword_1());
		}
	)
;

// Entry rule entryRuleLiteralReferenceMachineContext
entryRuleLiteralReferenceMachineContext returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralReferenceMachineContextRule()); }
	iv_ruleLiteralReferenceMachineContext=ruleLiteralReferenceMachineContext
	{ $current=$iv_ruleLiteralReferenceMachineContext.current; }
	EOF;

// Rule LiteralReferenceMachineContext
ruleLiteralReferenceMachineContext returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceMachineContextAccess().getLiteralThisExpressionParserRuleCall_0());
		}
		this_LiteralThisExpression_0=ruleLiteralThisExpression
		{
			$current = $this_LiteralThisExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceMachineContextAccess().getLiteralSelfExpressionParserRuleCall_1());
		}
		this_LiteralSelfExpression_1=ruleLiteralSelfExpression
		{
			$current = $this_LiteralSelfExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceMachineContextAccess().getLiteralParentExpressionParserRuleCall_2());
		}
		this_LiteralParentExpression_2=ruleLiteralParentExpression
		{
			$current = $this_LiteralParentExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceMachineContextAccess().getLiteralSuperExpressionParserRuleCall_3());
		}
		this_LiteralSuperExpression_3=ruleLiteralSuperExpression
		{
			$current = $this_LiteralSuperExpression_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceMachineContextAccess().getLiteralSystemExpressionParserRuleCall_4());
		}
		this_LiteralSystemExpression_4=ruleLiteralSystemExpression
		{
			$current = $this_LiteralSystemExpression_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceMachineContextAccess().getLiteralEnvExpressionParserRuleCall_5());
		}
		this_LiteralEnvExpression_5=ruleLiteralEnvExpression
		{
			$current = $this_LiteralEnvExpression_5.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralThisExpression
entryRuleLiteralThisExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralThisExpressionRule()); }
	iv_ruleLiteralThisExpression=ruleLiteralThisExpression
	{ $current=$iv_ruleLiteralThisExpression.current; }
	EOF;

// Rule LiteralThisExpression
ruleLiteralThisExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralThisExpressionAccess().getLiteralThisExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$this'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralThisExpressionAccess().getThisKeyword_1());
		}
	)
;

// Entry rule entryRuleLiteralSelfExpression
entryRuleLiteralSelfExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralSelfExpressionRule()); }
	iv_ruleLiteralSelfExpression=ruleLiteralSelfExpression
	{ $current=$iv_ruleLiteralSelfExpression.current; }
	EOF;

// Rule LiteralSelfExpression
ruleLiteralSelfExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralSelfExpressionAccess().getLiteralSelfExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$self'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralSelfExpressionAccess().getSelfKeyword_1());
		}
	)
;

// Entry rule entryRuleLiteralParentExpression
entryRuleLiteralParentExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralParentExpressionRule()); }
	iv_ruleLiteralParentExpression=ruleLiteralParentExpression
	{ $current=$iv_ruleLiteralParentExpression.current; }
	EOF;

// Rule LiteralParentExpression
ruleLiteralParentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralParentExpressionAccess().getLiteralParentExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$parent'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralParentExpressionAccess().getParentKeyword_1());
		}
	)
;

// Entry rule entryRuleLiteralSuperExpression
entryRuleLiteralSuperExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralSuperExpressionRule()); }
	iv_ruleLiteralSuperExpression=ruleLiteralSuperExpression
	{ $current=$iv_ruleLiteralSuperExpression.current; }
	EOF;

// Rule LiteralSuperExpression
ruleLiteralSuperExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralSuperExpressionAccess().getLiteralSuperExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$super'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralSuperExpressionAccess().getSuperKeyword_1());
		}
	)
;

// Entry rule entryRuleLiteralSystemExpression
entryRuleLiteralSystemExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralSystemExpressionRule()); }
	iv_ruleLiteralSystemExpression=ruleLiteralSystemExpression
	{ $current=$iv_ruleLiteralSystemExpression.current; }
	EOF;

// Rule LiteralSystemExpression
ruleLiteralSystemExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralSystemExpressionAccess().getLiteralSystemExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$system'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralSystemExpressionAccess().getSystemKeyword_1());
		}
	)
;

// Entry rule entryRuleLiteralEnvExpression
entryRuleLiteralEnvExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralEnvExpressionRule()); }
	iv_ruleLiteralEnvExpression=ruleLiteralEnvExpression
	{ $current=$iv_ruleLiteralEnvExpression.current; }
	EOF;

// Rule LiteralEnvExpression
ruleLiteralEnvExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralEnvExpressionAccess().getLiteralEnvExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$env'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralEnvExpressionAccess().getEnvKeyword_1());
		}
	)
;

// Entry rule entryRuleLiteralPureReferenceExpression
entryRuleLiteralPureReferenceExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralPureReferenceExpressionRule()); }
	iv_ruleLiteralPureReferenceExpression=ruleLiteralPureReferenceExpression
	{ $current=$iv_ruleLiteralPureReferenceExpression.current; }
	EOF;

// Rule LiteralPureReferenceExpression
ruleLiteralPureReferenceExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralPureReferenceExpressionAccess().getLiteralPureReferenceElementParserRuleCall_0());
		}
		this_LiteralPureReferenceElement_0=ruleLiteralPureReferenceElement
		{
			$current = $this_LiteralPureReferenceElement_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralPureReferenceExpressionAccess().getLiteralReferenceMachineContextParserRuleCall_1());
		}
		this_LiteralReferenceMachineContext_1=ruleLiteralReferenceMachineContext
		{
			$current = $this_LiteralReferenceMachineContext_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleValueSelectionExpression
entryRuleValueSelectionExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getValueSelectionExpressionRule()); }
	iv_ruleValueSelectionExpression=ruleValueSelectionExpression
	{ $current=$iv_ruleValueSelectionExpression.current; }
	EOF;

// Rule ValueSelectionExpression
ruleValueSelectionExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getLiteralReferenceExpressionParserRuleCall_0());
		}
		this_LiteralReferenceExpression_0=ruleLiteralReferenceExpression
		{
			$current = $this_LiteralReferenceExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getValueSelectionExpressionAccess().getValueElementSpecificationParentAction_1_0(),
						$current);
				}
			)
			otherlv_2='.'
			{
				newLeafNode(otherlv_2, grammarAccess.getValueSelectionExpressionAccess().getFullStopKeyword_1_1());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValueSelectionExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getElementNamedElementCrossReference_1_2_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getKindValueIndexExpressionKindEnumRuleCall_1_3_0_0());
						}
						lv_kind_4_0=ruleValueIndexExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getValueSelectionExpressionRule());
							}
							set(
								$current,
								"kind",
								lv_kind_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueIndexExpressionKind");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getArgPositionalTupleExpressionListParserRuleCall_1_3_1_0());
						}
						lv_arg_5_0=rulePositionalTupleExpressionList
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getValueSelectionExpressionRule());
							}
							set(
								$current,
								"arg",
								lv_arg_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PositionalTupleExpressionList");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_6=']'
				{
					newLeafNode(otherlv_6, grammarAccess.getValueSelectionExpressionAccess().getRightSquareBracketKeyword_1_3_2());
				}
			)?
		)*
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getValueSelectionExpressionAccess().getValueElementSpecificationParentAction_2_0(),
						$current);
				}
			)
			otherlv_8='->'
			{
				newLeafNode(otherlv_8, grammarAccess.getValueSelectionExpressionAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValueSelectionExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getElementNamedElementCrossReference_2_2_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getKindValueIndexExpressionKindEnumRuleCall_2_3_0_0());
						}
						lv_kind_10_0=ruleValueIndexExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getValueSelectionExpressionRule());
							}
							set(
								$current,
								"kind",
								lv_kind_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueIndexExpressionKind");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getArgPositionalTupleExpressionListParserRuleCall_2_3_1_0());
						}
						lv_arg_11_0=rulePositionalTupleExpressionList
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getValueSelectionExpressionRule());
							}
							set(
								$current,
								"arg",
								lv_arg_11_0,
								"org.eclipse.efm.formalml.xtext.FormalML.PositionalTupleExpressionList");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_12=']'
				{
					newLeafNode(otherlv_12, grammarAccess.getValueSelectionExpressionAccess().getRightSquareBracketKeyword_2_3_2());
				}
			)?
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getValueSelectionExpressionAccess().getValueElementSpecificationParentAction_2_4_0(),
							$current);
					}
				)
				otherlv_14='.'
				{
					newLeafNode(otherlv_14, grammarAccess.getValueSelectionExpressionAccess().getFullStopKeyword_2_4_1());
				}
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getValueSelectionExpressionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getElementNamedElementCrossReference_2_4_2_0());
						}
						ruleESIdentifier
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getKindValueIndexExpressionKindEnumRuleCall_2_4_3_0_0());
							}
							lv_kind_16_0=ruleValueIndexExpressionKind
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getValueSelectionExpressionRule());
								}
								set(
									$current,
									"kind",
									lv_kind_16_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ValueIndexExpressionKind");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getValueSelectionExpressionAccess().getArgPositionalTupleExpressionListParserRuleCall_2_4_3_1_0());
							}
							lv_arg_17_0=rulePositionalTupleExpressionList
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getValueSelectionExpressionRule());
								}
								set(
									$current,
									"arg",
									lv_arg_17_0,
									"org.eclipse.efm.formalml.xtext.FormalML.PositionalTupleExpressionList");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_18=']'
					{
						newLeafNode(otherlv_18, grammarAccess.getValueSelectionExpressionAccess().getRightSquareBracketKeyword_2_4_3_2());
					}
				)?
			)*
		)?
	)
;

// Entry rule entryRuleValuePureNamedMachineExpression
entryRuleValuePureNamedMachineExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionRule()); }
	iv_ruleValuePureNamedMachineExpression=ruleValuePureNamedMachineExpression
	{ $current=$iv_ruleValuePureNamedMachineExpression.current; }
	EOF;

// Rule ValuePureNamedMachineExpression
ruleValuePureNamedMachineExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getLiteralPureReferenceExpressionParserRuleCall_0());
		}
		this_LiteralPureReferenceExpression_0=ruleLiteralPureReferenceExpression
		{
			$current = $this_LiteralPureReferenceExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getValuePureNamedMachineExpressionAccess().getValueElementSpecificationParentAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getKindValueDotFieldExpressionKindEnumRuleCall_1_1_0());
					}
					lv_kind_2_0=ruleValueDotFieldExpressionKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getValuePureNamedMachineExpressionRule());
						}
						set(
							$current,
							"kind",
							lv_kind_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ValueDotFieldExpressionKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValuePureNamedMachineExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getElementNamedElementCrossReference_1_2_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getValuePureNamedMachineExpressionAccess().getValueElementSpecificationParentAction_2_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getKindValueArrowFieldExpressionKindEnumRuleCall_2_1_0());
					}
					lv_kind_5_0=ruleValueArrowFieldExpressionKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getValuePureNamedMachineExpressionRule());
						}
						set(
							$current,
							"kind",
							lv_kind_5_0,
							"org.eclipse.efm.formalml.xtext.FormalML.ValueArrowFieldExpressionKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValuePureNamedMachineExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getElementNamedElementCrossReference_2_2_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getValuePureNamedMachineExpressionAccess().getValueElementSpecificationParentAction_2_3_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getKindValueDotFieldExpressionKindEnumRuleCall_2_3_1_0());
						}
						lv_kind_8_0=ruleValueDotFieldExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getValuePureNamedMachineExpressionRule());
							}
							set(
								$current,
								"kind",
								lv_kind_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueDotFieldExpressionKind");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getValuePureNamedMachineExpressionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getElementNamedElementCrossReference_2_3_2_0());
						}
						ruleESIdentifier
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Rule VisibilityKind
ruleVisibilityKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='public'
			{
				$current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='private'
			{
				$current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='protected'
			{
				$current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='package'
			{
				$current = grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3());
			}
		)
	)
;

// Rule DesignKind
ruleDesignKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='model'
			{
				$current = grammarAccess.getDesignKindAccess().getModelEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getDesignKindAccess().getModelEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='prototype'
			{
				$current = grammarAccess.getDesignKindAccess().getPrototypeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getDesignKindAccess().getPrototypeEnumLiteralDeclaration_1());
			}
		)
	)
;

// Rule PseudostateKind
rulePseudostateKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='junction'
			{
				$current = grammarAccess.getPseudostateKindAccess().getJunctionEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getPseudostateKindAccess().getJunctionEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='choice'
			{
				$current = grammarAccess.getPseudostateKindAccess().getChoiceEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getPseudostateKindAccess().getChoiceEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='entryPoint'
			{
				$current = grammarAccess.getPseudostateKindAccess().getJunctionEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getPseudostateKindAccess().getJunctionEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='exitPoint'
			{
				$current = grammarAccess.getPseudostateKindAccess().getChoiceEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getPseudostateKindAccess().getChoiceEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4='fork'
			{
				$current = grammarAccess.getPseudostateKindAccess().getForkEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getPseudostateKindAccess().getForkEnumLiteralDeclaration_4());
			}
		)
		    |
		(
			enumLiteral_5='join'
			{
				$current = grammarAccess.getPseudostateKindAccess().getJoinEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_5, grammarAccess.getPseudostateKindAccess().getJoinEnumLiteralDeclaration_5());
			}
		)
		    |
		(
			enumLiteral_6='dhistory'
			{
				$current = grammarAccess.getPseudostateKindAccess().getDeepHistoryEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_6, grammarAccess.getPseudostateKindAccess().getDeepHistoryEnumLiteralDeclaration_6());
			}
		)
		    |
		(
			enumLiteral_7='shistory'
			{
				$current = grammarAccess.getPseudostateKindAccess().getShallowHistoryEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_7, grammarAccess.getPseudostateKindAccess().getShallowHistoryEnumLiteralDeclaration_7());
			}
		)
	)
;

// Rule PseudostateInitialKind
rulePseudostateInitialKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='initial'
		{
			$current = grammarAccess.getPseudostateInitialKindAccess().getInitialEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getPseudostateInitialKindAccess().getInitialEnumLiteralDeclaration());
		}
	)
;

// Rule EndingPseudostateKind
ruleEndingPseudostateKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='terminal'
			{
				$current = grammarAccess.getEndingPseudostateKindAccess().getTerminateEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getEndingPseudostateKindAccess().getTerminateEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='return'
			{
				$current = grammarAccess.getEndingPseudostateKindAccess().getReturnEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getEndingPseudostateKindAccess().getReturnEnumLiteralDeclaration_1());
			}
		)
	)
;

// Rule ComProtocolKind
ruleComProtocolKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='env'
			{
				$current = grammarAccess.getComProtocolKindAccess().getEnvEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getComProtocolKindAccess().getEnvEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='rdv'
			{
				$current = grammarAccess.getComProtocolKindAccess().getRdvEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getComProtocolKindAccess().getRdvEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='multi_rdv'
			{
				$current = grammarAccess.getComProtocolKindAccess().getMulti_rdvEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getComProtocolKindAccess().getMulti_rdvEnumLiteralDeclaration_2());
			}
		)
	)
;

// Rule ComEnvRdvProtocolKind
ruleComEnvRdvProtocolKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='env'
			{
				$current = grammarAccess.getComEnvRdvProtocolKindAccess().getEnvEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getComEnvRdvProtocolKindAccess().getEnvEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='rdv'
			{
				$current = grammarAccess.getComEnvRdvProtocolKindAccess().getRdvEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getComEnvRdvProtocolKindAccess().getRdvEnumLiteralDeclaration_1());
			}
		)
	)
;

// Rule ComMultiRdvProtocolKind
ruleComMultiRdvProtocolKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='multi_rdv'
		{
			$current = grammarAccess.getComMultiRdvProtocolKindAccess().getMulti_rdvEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getComMultiRdvProtocolKindAccess().getMulti_rdvEnumLiteralDeclaration());
		}
	)
;

// Rule BufferProtocolKind
ruleBufferProtocolKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='buffer'
		{
			$current = grammarAccess.getBufferProtocolKindAccess().getBufferEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getBufferProtocolKindAccess().getBufferEnumLiteralDeclaration());
		}
	)
;

// Rule ComCastKing
ruleComCastKing returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='unicast'
			{
				$current = grammarAccess.getComCastKingAccess().getUnicastEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getComCastKingAccess().getUnicastEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='anycast'
			{
				$current = grammarAccess.getComCastKingAccess().getAnycastEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getComCastKingAccess().getAnycastEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='multicast'
			{
				$current = grammarAccess.getComCastKingAccess().getMulticastEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getComCastKingAccess().getMulticastEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='broadcast'
			{
				$current = grammarAccess.getComCastKingAccess().getBroadcastEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getComCastKingAccess().getBroadcastEnumLiteralDeclaration_3());
			}
		)
	)
;

// Rule PrimitiveNumberSign
rulePrimitiveNumberSign returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='+'
			{
				$current = grammarAccess.getPrimitiveNumberSignAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getPrimitiveNumberSignAccess().getPositiveEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='++'
			{
				$current = grammarAccess.getPrimitiveNumberSignAccess().getPositive_strictEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getPrimitiveNumberSignAccess().getPositive_strictEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='-'
			{
				$current = grammarAccess.getPrimitiveNumberSignAccess().getNegativeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getPrimitiveNumberSignAccess().getNegativeEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='--'
			{
				$current = grammarAccess.getPrimitiveNumberSignAccess().getNegative_strictEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getPrimitiveNumberSignAccess().getNegative_strictEnumLiteralDeclaration_3());
			}
		)
	)
;

// Rule PrimitiveInstanceKind
rulePrimitiveInstanceKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='buffer'
			{
				$current = grammarAccess.getPrimitiveInstanceKindAccess().getBufferEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getPrimitiveInstanceKindAccess().getBufferEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='message'
			{
				$current = grammarAccess.getPrimitiveInstanceKindAccess().getMessageEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getPrimitiveInstanceKindAccess().getMessageEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='port'
			{
				$current = grammarAccess.getPrimitiveInstanceKindAccess().getPortEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getPrimitiveInstanceKindAccess().getPortEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='signal'
			{
				$current = grammarAccess.getPrimitiveInstanceKindAccess().getSignalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getPrimitiveInstanceKindAccess().getSignalEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4='machine'
			{
				$current = grammarAccess.getPrimitiveInstanceKindAccess().getMachineEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getPrimitiveInstanceKindAccess().getMachineEnumLiteralDeclaration_4());
			}
		)
		    |
		(
			enumLiteral_5='vertex'
			{
				$current = grammarAccess.getPrimitiveInstanceKindAccess().getVertexEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_5, grammarAccess.getPrimitiveInstanceKindAccess().getVertexEnumLiteralDeclaration_5());
			}
		)
	)
;

// Rule CollectionKind
ruleCollectionKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='vector'
			{
				$current = grammarAccess.getCollectionKindAccess().getVectorEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getCollectionKindAccess().getVectorEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='rvector'
			{
				$current = grammarAccess.getCollectionKindAccess().getRvectorEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getCollectionKindAccess().getRvectorEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='list'
			{
				$current = grammarAccess.getCollectionKindAccess().getListEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getCollectionKindAccess().getListEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='set'
			{
				$current = grammarAccess.getCollectionKindAccess().getSetEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getCollectionKindAccess().getSetEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4='bag'
			{
				$current = grammarAccess.getCollectionKindAccess().getBagEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getCollectionKindAccess().getBagEnumLiteralDeclaration_4());
			}
		)
		    |
		(
			enumLiteral_5='fifo'
			{
				$current = grammarAccess.getCollectionKindAccess().getFifoEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_5, grammarAccess.getCollectionKindAccess().getFifoEnumLiteralDeclaration_5());
			}
		)
		    |
		(
			enumLiteral_6='lifo'
			{
				$current = grammarAccess.getCollectionKindAccess().getLifoEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_6, grammarAccess.getCollectionKindAccess().getLifoEnumLiteralDeclaration_6());
			}
		)
	)
;

// Rule ParameterDirectionKind
ruleParameterDirectionKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='in'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getInEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getParameterDirectionKindAccess().getInEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='inout'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getInoutEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getParameterDirectionKindAccess().getInoutEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='out'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getOutEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getParameterDirectionKindAccess().getOutEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='return'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getReturnEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getParameterDirectionKindAccess().getReturnEnumLiteralDeclaration_3());
			}
		)
	)
;

// Rule BufferContainerKind
ruleBufferContainerKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='set'
			{
				$current = grammarAccess.getBufferContainerKindAccess().getSetEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getBufferContainerKindAccess().getSetEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='bag'
			{
				$current = grammarAccess.getBufferContainerKindAccess().getBagEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getBufferContainerKindAccess().getBagEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='fifo'
			{
				$current = grammarAccess.getBufferContainerKindAccess().getFifoEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getBufferContainerKindAccess().getFifoEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='lifo'
			{
				$current = grammarAccess.getBufferContainerKindAccess().getLifoEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getBufferContainerKindAccess().getLifoEnumLiteralDeclaration_3());
			}
		)
	)
;

// Rule ChannelDirection
ruleChannelDirection returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='input'
			{
				$current = grammarAccess.getChannelDirectionAccess().getInputEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getChannelDirectionAccess().getInputEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='inout'
			{
				$current = grammarAccess.getChannelDirectionAccess().getInoutEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getChannelDirectionAccess().getInoutEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='output'
			{
				$current = grammarAccess.getChannelDirectionAccess().getOutputEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getChannelDirectionAccess().getOutputEnumLiteralDeclaration_2());
			}
		)
	)
;

// Rule TransitionMoc
ruleTransitionMoc returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='simple'
			{
				$current = grammarAccess.getTransitionMocAccess().getSimpleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getTransitionMocAccess().getSimpleEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='abort'
			{
				$current = grammarAccess.getTransitionMocAccess().getAbortEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getTransitionMocAccess().getAbortEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='final'
			{
				$current = grammarAccess.getTransitionMocAccess().getFinalEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getTransitionMocAccess().getFinalEnumLiteralDeclaration_2());
			}
		)
	)
;

// Rule InterruptStatementKind
ruleInterruptStatementKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='break'
			{
				$current = grammarAccess.getInterruptStatementKindAccess().getBreakEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getInterruptStatementKindAccess().getBreakEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='continue'
			{
				$current = grammarAccess.getInterruptStatementKindAccess().getContinueEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getInterruptStatementKindAccess().getContinueEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='return'
			{
				$current = grammarAccess.getInterruptStatementKindAccess().getReturnEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getInterruptStatementKindAccess().getReturnEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='exit'
			{
				$current = grammarAccess.getInterruptStatementKindAccess().getExitEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getInterruptStatementKindAccess().getExitEnumLiteralDeclaration_3());
			}
		)
	)
;

// Rule OPERATOR_ACTIVITY
ruleOPERATOR_ACTIVITY returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='init'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getInitEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getOPERATOR_ACTIVITYAccess().getInitEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='final'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getFinalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getOPERATOR_ACTIVITYAccess().getFinalEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='destroy'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getDestroyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getOPERATOR_ACTIVITYAccess().getDestroyEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='start'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getStartEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getOPERATOR_ACTIVITYAccess().getStartEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4='stop'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getStopEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getOPERATOR_ACTIVITYAccess().getStopEnumLiteralDeclaration_4());
			}
		)
		    |
		(
			enumLiteral_5='restart'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getRestartEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_5, grammarAccess.getOPERATOR_ACTIVITYAccess().getRestartEnumLiteralDeclaration_5());
			}
		)
		    |
		(
			enumLiteral_6='suspend'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getSuspendEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_6, grammarAccess.getOPERATOR_ACTIVITYAccess().getSuspendEnumLiteralDeclaration_6());
			}
		)
		    |
		(
			enumLiteral_7='resume'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getResumeEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_7, grammarAccess.getOPERATOR_ACTIVITYAccess().getResumeEnumLiteralDeclaration_7());
			}
		)
		    |
		(
			enumLiteral_8='wait'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getWaitEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_8, grammarAccess.getOPERATOR_ACTIVITYAccess().getWaitEnumLiteralDeclaration_8());
			}
		)
		    |
		(
			enumLiteral_9='disable'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getDisableEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_9, grammarAccess.getOPERATOR_ACTIVITYAccess().getDisableEnumLiteralDeclaration_9());
			}
		)
		    |
		(
			enumLiteral_10='enable'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getEnableEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_10, grammarAccess.getOPERATOR_ACTIVITYAccess().getEnableEnumLiteralDeclaration_10());
			}
		)
		    |
		(
			enumLiteral_11='abort'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getAbortEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_11, grammarAccess.getOPERATOR_ACTIVITYAccess().getAbortEnumLiteralDeclaration_11());
			}
		)
		    |
		(
			enumLiteral_12='schedule'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getScheduleEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_12, grammarAccess.getOPERATOR_ACTIVITYAccess().getScheduleEnumLiteralDeclaration_12());
			}
		)
		    |
		(
			enumLiteral_13='irun'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getIrunEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_13, grammarAccess.getOPERATOR_ACTIVITYAccess().getIrunEnumLiteralDeclaration_13());
			}
		)
		    |
		(
			enumLiteral_14='run'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getRunEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_14, grammarAccess.getOPERATOR_ACTIVITYAccess().getRunEnumLiteralDeclaration_14());
			}
		)
		    |
		(
			enumLiteral_15='rtc'
			{
				$current = grammarAccess.getOPERATOR_ACTIVITYAccess().getRtcEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_15, grammarAccess.getOPERATOR_ACTIVITYAccess().getRtcEnumLiteralDeclaration_15());
			}
		)
	)
;

// Rule AnyPrimitiveInstanceKind
ruleAnyPrimitiveInstanceKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='$null'
		{
			$current = grammarAccess.getAnyPrimitiveInstanceKindAccess().getAnyEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getAnyPrimitiveInstanceKindAccess().getAnyEnumLiteralDeclaration());
		}
	)
;

// Rule ValueDotFieldExpressionKind
ruleValueDotFieldExpressionKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='.'
		{
			$current = grammarAccess.getValueDotFieldExpressionKindAccess().getFieldEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getValueDotFieldExpressionKindAccess().getFieldEnumLiteralDeclaration());
		}
	)
;

// Rule ValueArrowFieldExpressionKind
ruleValueArrowFieldExpressionKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='->'
		{
			$current = grammarAccess.getValueArrowFieldExpressionKindAccess().getFieldEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getValueArrowFieldExpressionKindAccess().getFieldEnumLiteralDeclaration());
		}
	)
;

// Rule ValueIndexExpressionKind
ruleValueIndexExpressionKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='['
		{
			$current = grammarAccess.getValueIndexExpressionKindAccess().getIndexEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getValueIndexExpressionKindAccess().getIndexEnumLiteralDeclaration());
		}
	)
;

// Rule ValueParameterExpressionKind
ruleValueParameterExpressionKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='('
		{
			$current = grammarAccess.getValueParameterExpressionKindAccess().getParameterEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getValueParameterExpressionKindAccess().getParameterEnumLiteralDeclaration());
		}
	)
;

RULE_INT : ('0'..'9')+;

RULE_CHARACTER : '\'' . '\'';

RULE_XLIA_ID : ('a'..'z'|'A'..'Z'|'_'|'#') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'#')*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
