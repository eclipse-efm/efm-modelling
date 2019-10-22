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
					newCompositeNode(grammarAccess.getXliaAccess().getSystemXliaSystemParserRuleCall_1_0());
				}
				lv_system_1_0=ruleXliaSystem
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaRule());
					}
					set(
						$current,
						"system",
						lv_system_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.XliaSystem");
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
				otherlv_2='version:'
				{
					newLeafNode(otherlv_2, grammarAccess.getXliaPrologAttributeAccess().getVersionKeyword_1_1());
				}
			)?
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getXliaPrologAttributeAccess().getValueLiteralFloatExpressionParserRuleCall_1_2_0_0());
						}
						lv_value_3_1=ruleLiteralFloatExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaPrologAttributeRule());
							}
							set(
								$current,
								"value",
								lv_value_3_1,
								"org.eclipse.efm.formalml.xtext.FormalML.LiteralFloatExpression");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getXliaPrologAttributeAccess().getValueLiteralStringExpressionParserRuleCall_1_2_0_1());
						}
						lv_value_3_2=ruleLiteralStringExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaPrologAttributeRule());
							}
							set(
								$current,
								"value",
								lv_value_3_2,
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

// Entry rule entryRuleEOffset
entryRuleEOffset returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEOffsetRule()); }
	iv_ruleEOffset=ruleEOffset
	{ $current=$iv_ruleEOffset.current.getText(); }
	EOF;

// Rule EOffset
ruleEOffset returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_OFFSET_0=RULE_OFFSET
	{
		$current.merge(this_OFFSET_0);
	}
	{
		newLeafNode(this_OFFSET_0, grammarAccess.getEOffsetAccess().getOFFSETTerminalRuleCall());
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
		(
			kw='spec::'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getESUfidAccess().getSpecKeyword_0_0());
			}
			    |
			kw='::'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getESUfidAccess().getColonColonKeyword_0_1());
			}
		)?
		this_XLIA_ID_2=RULE_XLIA_ID
		{
			$current.merge(this_XLIA_ID_2);
		}
		{
			newLeafNode(this_XLIA_ID_2, grammarAccess.getESUfidAccess().getXLIA_IDTerminalRuleCall_1());
		}
		(
			(
				kw='.'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getESUfidAccess().getFullStopKeyword_2_0_0());
				}
				    |
				kw=':'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getESUfidAccess().getColonKeyword_2_0_1());
				}
			)
			this_XLIA_ID_5=RULE_XLIA_ID
			{
				$current.merge(this_XLIA_ID_5);
			}
			{
				newLeafNode(this_XLIA_ID_5, grammarAccess.getESUfidAccess().getXLIA_IDTerminalRuleCall_2_1());
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

// Entry rule entryRuleModelOfComputationKing
entryRuleModelOfComputationKing returns [String current=null]:
	{ newCompositeNode(grammarAccess.getModelOfComputationKingRule()); }
	iv_ruleModelOfComputationKing=ruleModelOfComputationKing
	{ $current=$iv_ruleModelOfComputationKing.current.getText(); }
	EOF;

// Rule ModelOfComputationKing
ruleModelOfComputationKing returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='and'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getAndKeyword_0());
		}
		    |
		kw='or'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getOrKeyword_1());
		}
		    |
		kw='#STF'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getSTFKeyword_2());
		}
		    |
		kw='#STS'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getSTSKeyword_3());
		}
		    |
		kw='#DF'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getDFKeyword_4());
		}
		    |
		kw='#alt'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getAltKeyword_5());
		}
		    |
		kw='#opt'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getOptKeyword_6());
		}
		    |
		kw='#loop'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getLoopKeyword_7());
		}
		    |
		kw='#break'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getBreakKeyword_8());
		}
		    |
		kw='#par'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getParKeyword_9());
		}
		    |
		kw='#strict'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getStrictKeyword_10());
		}
		    |
		kw='#weak'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getWeakKeyword_11());
		}
		    |
		kw='#seq'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getSeqKeyword_12());
		}
		    |
		kw='#critical'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getCriticalKeyword_13());
		}
		    |
		kw='#ignore'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getIgnoreKeyword_14());
		}
		    |
		kw='#consider'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getConsiderKeyword_15());
		}
		    |
		kw='#assert'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getAssertKeyword_16());
		}
		    |
		kw='#neg'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelOfComputationKingAccess().getNegKeyword_17());
		}
	)
;

// Entry rule entryRuleDesignDebugTrace
entryRuleDesignDebugTrace returns [String current=null]:
	{ newCompositeNode(grammarAccess.getDesignDebugTraceRule()); }
	iv_ruleDesignDebugTrace=ruleDesignDebugTrace
	{ $current=$iv_ruleDesignDebugTrace.current.getText(); }
	EOF;

// Rule DesignDebugTrace
ruleDesignDebugTrace returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='#model'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getModelKeyword_0());
		}
		    |
		kw='#instance'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getInstanceKeyword_1());
		}
		    |
		kw='#static'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getStaticKeyword_2());
		}
		    |
		kw='#dynamic'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getDynamicKeyword_3());
		}
		    |
		kw='#runtime'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getRuntimeKeyword_4());
		}
		    |
		kw='#static#instance'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getStaticInstanceKeyword_5());
		}
		    |
		kw='#dynamic#instance'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getDynamicInstanceKeyword_6());
		}
		    |
		kw='#prototype'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getPrototypeKeyword_7());
		}
		    |
		kw='#dynamic#prototype'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDesignDebugTraceAccess().getDynamicPrototypeKeyword_8());
		}
	)
;

// Entry rule entryRuleXliaSystem
entryRuleXliaSystem returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getXliaSystemAccess().getUnorderedGroup_0()
	);
}:
	{ newCompositeNode(grammarAccess.getXliaSystemRule()); }
	iv_ruleXliaSystem=ruleXliaSystem
	{ $current=$iv_ruleXliaSystem.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule XliaSystem
ruleXliaSystem returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getXliaSystemAccess().getUnorderedGroup_0()
	);
}
@after {
	leaveRule();
}:
	(
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 0);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getXliaSystemAccess().getVisibilityVisibilityKindEnumRuleCall_0_0_0());
									}
									lv_visibility_1_0=ruleVisibilityKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 1);
					}
								({true}?=>((
									lv_timed_2_0='timed'
									{
										newLeafNode(lv_timed_2_0, grammarAccess.getXliaSystemAccess().getTimedTimedKeyword_0_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getXliaSystemRule());
										}
										setWithLastConsumed($current, "timed", true, "timed");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 2);
					}
								({true}?=>((
									lv_dense_timed_3_0='timed#dense'
									{
										newLeafNode(lv_dense_timed_3_0, grammarAccess.getXliaSystemAccess().getDense_timedTimedDenseKeyword_0_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getXliaSystemRule());
										}
										setWithLastConsumed($current, "dense_timed", true, "timed#dense");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 3);
					}
								({true}?=>((
									lv_discrete_timed_4_0='timed#discrete'
									{
										newLeafNode(lv_discrete_timed_4_0, grammarAccess.getXliaSystemAccess().getDiscrete_timedTimedDiscreteKeyword_0_3_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getXliaSystemRule());
										}
										setWithLastConsumed($current, "discrete_timed", true, "timed#discrete");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 4);
					}
								({true}?=>((
									lv_input_enabled_5_0='input_enabled'
									{
										newLeafNode(lv_input_enabled_5_0, grammarAccess.getXliaSystemAccess().getInput_enabledInput_enabledKeyword_0_4_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getXliaSystemRule());
										}
										setWithLastConsumed($current, "input_enabled", true, "input_enabled");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0(), 5);
					}
								({true}?=>((
									lv_unsafe_6_0='unsafe'
									{
										newLeafNode(lv_unsafe_6_0, grammarAccess.getXliaSystemAccess().getUnsafeUnsafeKeyword_0_5_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getXliaSystemRule());
										}
										setWithLastConsumed($current, "unsafe", true, "unsafe");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getXliaSystemAccess().getUnorderedGroup_0());
				}
		)
		otherlv_7='system'
		{
			newLeafNode(otherlv_7, grammarAccess.getXliaSystemAccess().getSystemKeyword_1());
		}
		(
			otherlv_8='<'
			{
				newLeafNode(otherlv_8, grammarAccess.getXliaSystemAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_9='moc:'
				{
					newLeafNode(otherlv_9, grammarAccess.getXliaSystemAccess().getMocKeyword_2_1());
				}
			)?
			(
				otherlv_10='and'
				{
					newLeafNode(otherlv_10, grammarAccess.getXliaSystemAccess().getAndKeyword_2_2_0());
				}
				    |
				otherlv_11='or'
				{
					newLeafNode(otherlv_11, grammarAccess.getXliaSystemAccess().getOrKeyword_2_2_1());
				}
			)
			otherlv_12='>'
			{
				newLeafNode(otherlv_12, grammarAccess.getXliaSystemAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getXliaSystemAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_13_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newCompositeNode(grammarAccess.getXliaSystemAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_14_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
			newLeafNode(otherlv_15, grammarAccess.getXliaSystemAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getXliaSystemAccess().getPortPortParserRuleCall_6_0_0());
					}
					lv_port_16_0=rulePort
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						newCompositeNode(grammarAccess.getXliaSystemAccess().getSignalSignalParserRuleCall_6_1_0());
					}
					lv_signal_17_0=ruleSignal
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						newCompositeNode(grammarAccess.getXliaSystemAccess().getBufferBufferParserRuleCall_6_2_0());
					}
					lv_buffer_18_0=ruleBuffer
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						newCompositeNode(grammarAccess.getXliaSystemAccess().getChannelChannelParserRuleCall_6_3_0());
					}
					lv_channel_19_0=ruleChannel
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						newCompositeNode(grammarAccess.getXliaSystemAccess().getTypedefTypeDefinitionParserRuleCall_6_4_0());
					}
					lv_typedef_20_0=ruleTypeDefinition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						newCompositeNode(grammarAccess.getXliaSystemAccess().getFunctionFunctionParserRuleCall_6_5_0());
					}
					lv_function_21_0=ruleFunction
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						newCompositeNode(grammarAccess.getXliaSystemAccess().getVariableVariableParserRuleCall_6_6_0());
					}
					lv_variable_22_0=ruleVariable
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_23, grammarAccess.getXliaSystemAccess().getPropertyKeyword_7_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXliaSystemAccess().getPortPortParserRuleCall_7_0_1_0_0());
							}
							lv_port_24_0=rulePort
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getSignalSignalParserRuleCall_7_0_1_1_0());
							}
							lv_signal_25_0=ruleSignal
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getBufferBufferParserRuleCall_7_0_1_2_0());
							}
							lv_buffer_26_0=ruleBuffer
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getChannelChannelParserRuleCall_7_0_1_3_0());
							}
							lv_channel_27_0=ruleChannel
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getTypedefTypeDefinitionParserRuleCall_7_0_1_4_0());
							}
							lv_typedef_28_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getFunctionFunctionParserRuleCall_7_0_1_5_0());
							}
							lv_function_29_0=ruleFunction
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getVariableVariableParserRuleCall_7_0_1_6_0());
							}
							lv_variable_30_0=ruleVariable
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_31, grammarAccess.getXliaSystemAccess().getPublicKeyword_7_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXliaSystemAccess().getPortPortPublicParserRuleCall_7_1_1_0_0());
							}
							lv_port_32_0=rulePortPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getSignalSignalPublicParserRuleCall_7_1_1_1_0());
							}
							lv_signal_33_0=ruleSignalPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getBufferBufferPublicParserRuleCall_7_1_1_2_0());
							}
							lv_buffer_34_0=ruleBufferPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getChannelChannelPublicParserRuleCall_7_1_1_3_0());
							}
							lv_channel_35_0=ruleChannelPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getTypedefTypeDefinitionParserRuleCall_7_1_1_4_0());
							}
							lv_typedef_36_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getFunctionFunctionPublicParserRuleCall_7_1_1_5_0());
							}
							lv_function_37_0=ruleFunctionPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getVariableVariablePublicParserRuleCall_7_1_1_6_0());
							}
							lv_variable_38_0=ruleVariablePublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_39, grammarAccess.getXliaSystemAccess().getProtectedKeyword_7_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXliaSystemAccess().getPortPortProtectedParserRuleCall_7_2_1_0_0());
							}
							lv_port_40_0=rulePortProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getSignalSignalProtectedParserRuleCall_7_2_1_1_0());
							}
							lv_signal_41_0=ruleSignalProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getBufferBufferProtectedParserRuleCall_7_2_1_2_0());
							}
							lv_buffer_42_0=ruleBufferProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getChannelChannelProtectedParserRuleCall_7_2_1_3_0());
							}
							lv_channel_43_0=ruleChannelProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getTypedefTypeDefinitionParserRuleCall_7_2_1_4_0());
							}
							lv_typedef_44_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getFunctionFunctionProtectedParserRuleCall_7_2_1_5_0());
							}
							lv_function_45_0=ruleFunctionProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getVariableVariableProtectedParserRuleCall_7_2_1_6_0());
							}
							lv_variable_46_0=ruleVariableProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_47, grammarAccess.getXliaSystemAccess().getPrivateKeyword_7_3_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXliaSystemAccess().getPortPortPrivateParserRuleCall_7_3_1_0_0());
							}
							lv_port_48_0=rulePortPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getSignalSignalPrivateParserRuleCall_7_3_1_1_0());
							}
							lv_signal_49_0=ruleSignalPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getBufferBufferPrivateParserRuleCall_7_3_1_2_0());
							}
							lv_buffer_50_0=ruleBufferPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getChannelChannelPrivateParserRuleCall_7_3_1_3_0());
							}
							lv_channel_51_0=ruleChannelPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getTypedefTypeDefinitionParserRuleCall_7_3_1_4_0());
							}
							lv_typedef_52_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getFunctionFunctionPrivateParserRuleCall_7_3_1_5_0());
							}
							lv_function_53_0=ruleFunctionPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getVariableVariablePrivateParserRuleCall_7_3_1_6_0());
							}
							lv_variable_54_0=ruleVariablePrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
							newLeafNode(otherlv_55, grammarAccess.getXliaSystemAccess().getRoutineKeyword_8_0_0_0_0());
						}
						    |
						otherlv_56='@macro:'
						{
							newLeafNode(otherlv_56, grammarAccess.getXliaSystemAccess().getMacroKeyword_8_0_0_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getXliaSystemAccess().getRoutineRoutineParserRuleCall_8_0_0_1_0());
							}
							lv_routine_57_0=ruleRoutine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						newLeafNode(otherlv_58, grammarAccess.getXliaSystemAccess().getProcedureKeyword_8_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXliaSystemAccess().getProcedureProcedureParserRuleCall_8_0_1_1_0());
							}
							lv_procedure_59_0=ruleProcedure
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
							newCompositeNode(grammarAccess.getXliaSystemAccess().getRoutineRoutineParserRuleCall_8_1_0_0());
						}
						lv_routine_60_0=ruleRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
							newCompositeNode(grammarAccess.getXliaSystemAccess().getProcedureProcedureParserRuleCall_8_1_1_0());
						}
						lv_procedure_61_0=ruleProcedure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
						newLeafNode(otherlv_62, grammarAccess.getXliaSystemAccess().getCompositeKeyword_9_0_0_0());
					}
					    |
					otherlv_63='@machine:'
					{
						newLeafNode(otherlv_63, grammarAccess.getXliaSystemAccess().getMachineKeyword_9_0_0_1());
					}
				)
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getXliaSystemAccess().getMachineAnyMachineBlockParserRuleCall_9_0_1_0_0());
							}
							lv_machine_64_0=ruleAnyMachineBlock
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
								newCompositeNode(grammarAccess.getXliaSystemAccess().getInstanceInstanceMachineParserRuleCall_9_0_1_1_0());
							}
							lv_instance_65_0=ruleInstanceMachine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_66, grammarAccess.getXliaSystemAccess().getModelKeyword_9_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXliaSystemAccess().getMachineAnyMachineBlockParserRuleCall_9_1_1_0());
						}
						lv_machine_67_0=ruleAnyMachineBlock
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_68, grammarAccess.getXliaSystemAccess().getPrototypeKeyword_9_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXliaSystemAccess().getMachineAnyMachineBlockParserRuleCall_9_2_1_0());
						}
						lv_machine_69_0=ruleAnyMachineBlock
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_70, grammarAccess.getXliaSystemAccess().getInstanceKeyword_9_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXliaSystemAccess().getInstanceInstanceMachineParserRuleCall_9_3_1_0());
						}
						lv_instance_71_0=ruleInstanceMachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_72, grammarAccess.getXliaSystemAccess().getBehaviorKeyword_10_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXliaSystemAccess().getBehaviorBehaviorParserRuleCall_10_0_1_0());
						}
						lv_behavior_73_0=ruleBehavior
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newLeafNode(otherlv_74, grammarAccess.getXliaSystemAccess().getStatemachineKeyword_10_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getXliaSystemAccess().getBehaviorStatemachineParserRuleCall_10_1_1_0());
						}
						lv_behavior_75_0=ruleStatemachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
					newCompositeNode(grammarAccess.getXliaSystemAccess().getMainMoeBehaviorParserRuleCall_11_0());
				}
				lv_main_76_0=ruleMoeBehavior
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXliaSystemRule());
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
			newLeafNode(otherlv_77, grammarAccess.getXliaSystemAccess().getRightCurlyBracketKeyword_12());
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
			otherlv_9='('
			{
				newLeafNode(otherlv_9, grammarAccess.getInstanceMachineAccess().getLeftParenthesisKeyword_8_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getInstanceMachineAccess().getSlotSlotParameterParserRuleCall_8_1_0_0());
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
						newLeafNode(otherlv_11, grammarAccess.getInstanceMachineAccess().getCommaKeyword_8_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getInstanceMachineAccess().getSlotSlotParameterParserRuleCall_8_1_1_1_0());
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
				newLeafNode(otherlv_13, grammarAccess.getInstanceMachineAccess().getRightParenthesisKeyword_8_2());
			}
		)?
		(
			(
				otherlv_14='{'
				{
					newLeafNode(otherlv_14, grammarAccess.getInstanceMachineAccess().getLeftCurlyBracketKeyword_9_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getInstanceMachineAccess().getSlotSlotPropertyParserRuleCall_9_0_1_0_0());
							}
							lv_slot_15_0=ruleSlotProperty
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getInstanceMachineRule());
								}
								add(
									$current,
									"slot",
									lv_slot_15_0,
									"org.eclipse.efm.formalml.xtext.FormalML.SlotProperty");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_16=';'
					{
						newLeafNode(otherlv_16, grammarAccess.getInstanceMachineAccess().getSemicolonKeyword_9_0_1_1());
					}
				)*
				otherlv_17='}'
				{
					newLeafNode(otherlv_17, grammarAccess.getInstanceMachineAccess().getRightCurlyBracketKeyword_9_0_2());
				}
			)
			    |
			otherlv_18=';'
			{
				newLeafNode(otherlv_18, grammarAccess.getInstanceMachineAccess().getSemicolonKeyword_9_1());
			}
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
									lv_dense_timed_3_0='timed#dense'
									{
										newLeafNode(lv_dense_timed_3_0, grammarAccess.getMachineBlockAccess().getDense_timedTimedDenseKeyword_0_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getMachineBlockRule());
										}
										setWithLastConsumed($current, "dense_timed", true, "timed#dense");
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
									lv_discrete_timed_4_0='timed#discrete'
									{
										newLeafNode(lv_discrete_timed_4_0, grammarAccess.getMachineBlockAccess().getDiscrete_timedTimedDiscreteKeyword_0_3_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getMachineBlockRule());
										}
										setWithLastConsumed($current, "discrete_timed", true, "timed#discrete");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 4);
					}
								({true}?=>((
									lv_input_enabled_5_0='input_enabled'
									{
										newLeafNode(lv_input_enabled_5_0, grammarAccess.getMachineBlockAccess().getInput_enabledInput_enabledKeyword_0_4_0());
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 5);
					}
								({true}?=>((
									lv_lifeline_6_0='lifeline'
									{
										newLeafNode(lv_lifeline_6_0, grammarAccess.getMachineBlockAccess().getLifelineLifelineKeyword_0_5_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getMachineBlockRule());
										}
										setWithLastConsumed($current, "lifeline", true, "lifeline");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 6)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMachineBlockAccess().getUnorderedGroup_0(), 6);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getMachineBlockAccess().getDesignDesignKindEnumRuleCall_0_6_0());
									}
									lv_design_7_0=ruleDesignKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
										}
										set(
											$current,
											"design",
											lv_design_7_0,
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
		(
			otherlv_8='machine'
			{
				newLeafNode(otherlv_8, grammarAccess.getMachineBlockAccess().getMachineKeyword_1_0());
			}
			    |
			otherlv_9='executable'
			{
				newLeafNode(otherlv_9, grammarAccess.getMachineBlockAccess().getExecutableKeyword_1_1());
			}
		)
		(
			otherlv_10='<'
			{
				newLeafNode(otherlv_10, grammarAccess.getMachineBlockAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					otherlv_11='moc:'
					{
						newLeafNode(otherlv_11, grammarAccess.getMachineBlockAccess().getMocKeyword_2_1_0());
					}
				)?
				{
					/* */
				}
				{
					newCompositeNode(grammarAccess.getMachineBlockAccess().getModelOfComputationKingParserRuleCall_2_1_1());
				}
				ruleModelOfComputationKing
				{
					afterParserOrEnumRuleCall();
				}
			)?
			(
				otherlv_13='instance:'
				{
					newLeafNode(otherlv_13, grammarAccess.getMachineBlockAccess().getInstanceKeyword_2_2_0());
				}
				otherlv_14='['
				{
					newLeafNode(otherlv_14, grammarAccess.getMachineBlockAccess().getLeftSquareBracketKeyword_2_2_1());
				}
				(
					otherlv_15='+'
					{
						newLeafNode(otherlv_15, grammarAccess.getMachineBlockAccess().getPlusSignKeyword_2_2_2_0());
					}
					    |
					otherlv_16='*'
					{
						newLeafNode(otherlv_16, grammarAccess.getMachineBlockAccess().getAsteriskKeyword_2_2_2_1());
					}
					    |
					(
						otherlv_17='init:'
						{
							newLeafNode(otherlv_17, grammarAccess.getMachineBlockAccess().getInitKeyword_2_2_2_2_0());
						}
						{
							/* */
						}
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getEIntegerParserRuleCall_2_2_2_2_1());
						}
						ruleEInteger
						{
							afterParserOrEnumRuleCall();
						}
						otherlv_19='max:'
						{
							newLeafNode(otherlv_19, grammarAccess.getMachineBlockAccess().getMaxKeyword_2_2_2_2_2());
						}
						{
							/* */
						}
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getEIntegerParserRuleCall_2_2_2_2_3());
						}
						ruleEInteger
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_21=']'
				{
					newLeafNode(otherlv_21, grammarAccess.getMachineBlockAccess().getRightSquareBracketKeyword_2_2_3());
				}
			)?
			otherlv_22='>'
			{
				newLeafNode(otherlv_22, grammarAccess.getMachineBlockAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getMachineBlockAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_23_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
					}
					set(
						$current,
						"name",
						lv_name_23_0,
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
				lv_unrestrictedName_24_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
					}
					set(
						$current,
						"unrestrictedName",
						lv_unrestrictedName_24_0,
						"org.eclipse.efm.formalml.xtext.FormalML.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_25='{'
		{
			newLeafNode(otherlv_25, grammarAccess.getMachineBlockAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortParserRuleCall_6_0_0());
					}
					lv_port_26_0=rulePort
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"port",
							lv_port_26_0,
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
					lv_signal_27_0=ruleSignal
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"signal",
							lv_signal_27_0,
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
					lv_buffer_28_0=ruleBuffer
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"buffer",
							lv_buffer_28_0,
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
					lv_channel_29_0=ruleChannel
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"channel",
							lv_channel_29_0,
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
					lv_typedef_30_0=ruleTypeDefinition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"typedef",
							lv_typedef_30_0,
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
					lv_function_31_0=ruleFunction
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"function",
							lv_function_31_0,
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
					lv_variable_32_0=ruleVariable
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
						}
						add(
							$current,
							"variable",
							lv_variable_32_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Variable");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			(
				otherlv_33='@property:'
				{
					newLeafNode(otherlv_33, grammarAccess.getMachineBlockAccess().getPropertyKeyword_7_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortParserRuleCall_7_0_1_0_0());
							}
							lv_port_34_0=rulePort
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"port",
									lv_port_34_0,
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
							lv_signal_35_0=ruleSignal
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"signal",
									lv_signal_35_0,
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
							lv_buffer_36_0=ruleBuffer
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_36_0,
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
							lv_channel_37_0=ruleChannel
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"channel",
									lv_channel_37_0,
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
							lv_typedef_38_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_38_0,
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
							lv_function_39_0=ruleFunction
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"function",
									lv_function_39_0,
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
							lv_variable_40_0=ruleVariable
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"variable",
									lv_variable_40_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Variable");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_41='@public:'
				{
					newLeafNode(otherlv_41, grammarAccess.getMachineBlockAccess().getPublicKeyword_7_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortPublicParserRuleCall_7_1_1_0_0());
							}
							lv_port_42_0=rulePortPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"port",
									lv_port_42_0,
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
							lv_signal_43_0=ruleSignalPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"signal",
									lv_signal_43_0,
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
							lv_buffer_44_0=ruleBufferPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_44_0,
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
							lv_channel_45_0=ruleChannelPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"channel",
									lv_channel_45_0,
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
							lv_typedef_46_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_46_0,
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
							lv_function_47_0=ruleFunctionPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"function",
									lv_function_47_0,
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
							lv_variable_48_0=ruleVariablePublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"variable",
									lv_variable_48_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_49='@protected:'
				{
					newLeafNode(otherlv_49, grammarAccess.getMachineBlockAccess().getProtectedKeyword_7_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortProtectedParserRuleCall_7_2_1_0_0());
							}
							lv_port_50_0=rulePortProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"port",
									lv_port_50_0,
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
							lv_signal_51_0=ruleSignalProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"signal",
									lv_signal_51_0,
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
							lv_buffer_52_0=ruleBufferProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_52_0,
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
							lv_channel_53_0=ruleChannelProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"channel",
									lv_channel_53_0,
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
							lv_typedef_54_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_54_0,
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
							lv_function_55_0=ruleFunctionProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"function",
									lv_function_55_0,
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
							lv_variable_56_0=ruleVariableProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"variable",
									lv_variable_56_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariableProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_57='@private:'
				{
					newLeafNode(otherlv_57, grammarAccess.getMachineBlockAccess().getPrivateKeyword_7_3_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getPortPortPrivateParserRuleCall_7_3_1_0_0());
							}
							lv_port_58_0=rulePortPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"port",
									lv_port_58_0,
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
							lv_signal_59_0=ruleSignalPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"signal",
									lv_signal_59_0,
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
							lv_buffer_60_0=ruleBufferPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_60_0,
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
							lv_channel_61_0=ruleChannelPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"channel",
									lv_channel_61_0,
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
							lv_typedef_62_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_62_0,
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
							lv_function_63_0=ruleFunctionPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"function",
									lv_function_63_0,
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
							lv_variable_64_0=ruleVariablePrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"variable",
									lv_variable_64_0,
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
						otherlv_65='@routine:'
						{
							newLeafNode(otherlv_65, grammarAccess.getMachineBlockAccess().getRoutineKeyword_8_0_0_0_0());
						}
						    |
						otherlv_66='@macro:'
						{
							newLeafNode(otherlv_66, grammarAccess.getMachineBlockAccess().getMacroKeyword_8_0_0_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getRoutineRoutineParserRuleCall_8_0_0_1_0());
							}
							lv_routine_67_0=ruleRoutine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"routine",
									lv_routine_67_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Routine");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
				    |
				(
					otherlv_68='@procedure:'
					{
						newLeafNode(otherlv_68, grammarAccess.getMachineBlockAccess().getProcedureKeyword_8_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getProcedureProcedureParserRuleCall_8_0_1_1_0());
							}
							lv_procedure_69_0=ruleProcedure
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"procedure",
									lv_procedure_69_0,
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
						lv_routine_70_0=ruleRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"routine",
								lv_routine_70_0,
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
						lv_procedure_71_0=ruleProcedure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"procedure",
								lv_procedure_71_0,
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
					otherlv_72='@composite:'
					{
						newLeafNode(otherlv_72, grammarAccess.getMachineBlockAccess().getCompositeKeyword_9_0_0_0());
					}
					    |
					otherlv_73='@machine:'
					{
						newLeafNode(otherlv_73, grammarAccess.getMachineBlockAccess().getMachineKeyword_9_0_0_1());
					}
				)
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMachineBlockAccess().getMachineAnyMachineBlockParserRuleCall_9_0_1_0_0());
							}
							lv_machine_74_0=ruleAnyMachineBlock
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"machine",
									lv_machine_74_0,
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
							lv_instance_75_0=ruleInstanceMachine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
								}
								add(
									$current,
									"instance",
									lv_instance_75_0,
									"org.eclipse.efm.formalml.xtext.FormalML.InstanceMachine");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)+
			)
			    |
			(
				otherlv_76='@model:'
				{
					newLeafNode(otherlv_76, grammarAccess.getMachineBlockAccess().getModelKeyword_9_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getMachineAnyMachineBlockParserRuleCall_9_1_1_0());
						}
						lv_machine_77_0=ruleAnyMachineBlock
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"machine",
								lv_machine_77_0,
								"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_78='@prototype:'
				{
					newLeafNode(otherlv_78, grammarAccess.getMachineBlockAccess().getPrototypeKeyword_9_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getMachineAnyMachineBlockParserRuleCall_9_2_1_0());
						}
						lv_machine_79_0=ruleAnyMachineBlock
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"machine",
								lv_machine_79_0,
								"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_80='@instance:'
				{
					newLeafNode(otherlv_80, grammarAccess.getMachineBlockAccess().getInstanceKeyword_9_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getInstanceInstanceMachineParserRuleCall_9_3_1_0());
						}
						lv_instance_81_0=ruleInstanceMachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"instance",
								lv_instance_81_0,
								"org.eclipse.efm.formalml.xtext.FormalML.InstanceMachine");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)*
		(
			(
				otherlv_82='@behavior:'
				{
					newLeafNode(otherlv_82, grammarAccess.getMachineBlockAccess().getBehaviorKeyword_10_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getBehaviorBehaviorParserRuleCall_10_0_1_0());
						}
						lv_behavior_83_0=ruleBehavior
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"behavior",
								lv_behavior_83_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Behavior");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)
			    |
			(
				otherlv_84='@statemachine:'
				{
					newLeafNode(otherlv_84, grammarAccess.getMachineBlockAccess().getStatemachineKeyword_10_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMachineBlockAccess().getBehaviorStatemachineParserRuleCall_10_1_1_0());
						}
						lv_behavior_85_0=ruleStatemachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
							}
							add(
								$current,
								"behavior",
								lv_behavior_85_0,
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
				lv_main_86_0=ruleMoeBehavior
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMachineBlockRule());
					}
					set(
						$current,
						"main",
						lv_main_86_0,
						"org.eclipse.efm.formalml.xtext.FormalML.MoeBehavior");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_87='}'
		{
			newLeafNode(otherlv_87, grammarAccess.getMachineBlockAccess().getRightCurlyBracketKeyword_12());
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
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getProcedureAccess().getRegionStatemachineNamedRegionParserRuleCall_11_1_0());
					}
					lv_region_98_0=ruleStatemachineNamedRegion
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProcedureRule());
						}
						add(
							$current,
							"region",
							lv_region_98_0,
							"org.eclipse.efm.formalml.xtext.FormalML.StatemachineNamedRegion");
						afterParserOrEnumRuleCall();
					}
				)
			)+
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getProcedureAccess().getRegionStatemachineRegionLiteParserRuleCall_11_2_0());
					}
					lv_region_99_0=ruleStatemachineRegionLite
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProcedureRule());
						}
						add(
							$current,
							"region",
							lv_region_99_0,
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
				lv_execution_100_0=ruleProcedureExecution
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getProcedureRule());
					}
					set(
						$current,
						"execution",
						lv_execution_100_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ProcedureExecution");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_101='}'
		{
			newLeafNode(otherlv_101, grammarAccess.getProcedureAccess().getRightCurlyBracketKeyword_13());
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
								({true}?=>((
									otherlv_3='@schedule'
									{
										newLeafNode(otherlv_3, grammarAccess.getProcedureExecutionAccess().getScheduleKeyword_2_0_0_0());
									}
									    |
									otherlv_4='@xschedule'
									{
										newLeafNode(otherlv_4, grammarAccess.getProcedureExecutionAccess().getXscheduleKeyword_2_0_0_1());
									}
								)
								(
									(
										{
											newCompositeNode(grammarAccess.getProcedureExecutionAccess().getScheduleRoutineMoeRoutineParserRuleCall_2_0_1_0());
										}
										lv_scheduleRoutine_5_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getProcedureExecutionRule());
											}
											set(
												$current,
												"scheduleRoutine",
												lv_scheduleRoutine_5_0,
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
								({true}?=>(otherlv_6='@run'
								{
									newLeafNode(otherlv_6, grammarAccess.getProcedureExecutionAccess().getRunKeyword_2_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getProcedureExecutionAccess().getRunRoutineMoeRoutineParserRuleCall_2_1_1_0());
										}
										lv_runRoutine_7_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getProcedureExecutionRule());
											}
											set(
												$current,
												"runRoutine",
												lv_runRoutine_7_0,
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
									lv_dense_timed_4_0='timed#dense'
									{
										newLeafNode(lv_dense_timed_4_0, grammarAccess.getStatemachineAccess().getDense_timedTimedDenseKeyword_1_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getStatemachineRule());
										}
										setWithLastConsumed($current, "dense_timed", true, "timed#dense");
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
									lv_discrete_timed_5_0='timed#discrete'
									{
										newLeafNode(lv_discrete_timed_5_0, grammarAccess.getStatemachineAccess().getDiscrete_timedTimedDiscreteKeyword_1_3_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getStatemachineRule());
										}
										setWithLastConsumed($current, "discrete_timed", true, "timed#discrete");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStatemachineAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 4);
					}
								({true}?=>((
									lv_input_enabled_6_0='input_enabled'
									{
										newLeafNode(lv_input_enabled_6_0, grammarAccess.getStatemachineAccess().getInput_enabledInput_enabledKeyword_1_4_0());
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 5);
					}
								({true}?=>((
									lv_lifeline_7_0='lifeline'
									{
										newLeafNode(lv_lifeline_7_0, grammarAccess.getStatemachineAccess().getLifelineLifelineKeyword_1_5_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getStatemachineRule());
										}
										setWithLastConsumed($current, "lifeline", true, "lifeline");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStatemachineAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 6)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStatemachineAccess().getUnorderedGroup_1(), 6);
					}
								({true}?=>((
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getDesignDesignKindEnumRuleCall_1_6_0());
									}
									lv_design_8_0=ruleDesignKind
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										set(
											$current,
											"design",
											lv_design_8_0,
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
		otherlv_9='statemachine'
		{
			newLeafNode(otherlv_9, grammarAccess.getStatemachineAccess().getStatemachineKeyword_2());
		}
		(
			otherlv_10='<'
			{
				newLeafNode(otherlv_10, grammarAccess.getStatemachineAccess().getLessThanSignKeyword_3_0());
			}
			(
				otherlv_11='moc:'
				{
					newLeafNode(otherlv_11, grammarAccess.getStatemachineAccess().getMocKeyword_3_1());
				}
			)?
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getStatemachineAccess().getModelOfComputationKingParserRuleCall_3_2());
			}
			ruleModelOfComputationKing
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_13='>'
			{
				newLeafNode(otherlv_13, grammarAccess.getStatemachineAccess().getGreaterThanSignKeyword_3_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getStatemachineAccess().getNameESIdentifierParserRuleCall_4_0());
				}
				lv_name_14_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineRule());
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
					newCompositeNode(grammarAccess.getStatemachineAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_unrestrictedName_15_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineRule());
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
		otherlv_16='{'
		{
			newLeafNode(otherlv_16, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				otherlv_17='@parameter:'
				{
					newLeafNode(otherlv_17, grammarAccess.getStatemachineAccess().getParameterKeyword_7_0_0());
				}
				(
					(
						otherlv_18='input'
						{
							newLeafNode(otherlv_18, grammarAccess.getStatemachineAccess().getInputKeyword_7_0_1_0_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInputParserRuleCall_7_0_1_0_1_0_0());
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
							)
							    |
							(
								otherlv_20='{'
								{
									newLeafNode(otherlv_20, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_7_0_1_0_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInputParserRuleCall_7_0_1_0_1_1_1_0());
										}
										lv_parameter_21_0=ruleParameterInput
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStatemachineRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_21_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterInput");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_22='}'
								{
									newLeafNode(otherlv_22, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_7_0_1_0_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_23='inout'
						{
							newLeafNode(otherlv_23, grammarAccess.getStatemachineAccess().getInoutKeyword_7_0_1_1_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInoutParserRuleCall_7_0_1_1_1_0_0());
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
							)
							    |
							(
								otherlv_25='{'
								{
									newLeafNode(otherlv_25, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_7_0_1_1_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInoutParserRuleCall_7_0_1_1_1_1_1_0());
										}
										lv_parameter_26_0=ruleParameterInout
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStatemachineRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_26_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterInout");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_27='}'
								{
									newLeafNode(otherlv_27, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_7_0_1_1_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_28='output'
						{
							newLeafNode(otherlv_28, grammarAccess.getStatemachineAccess().getOutputKeyword_7_0_1_2_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterOutputParserRuleCall_7_0_1_2_1_0_0());
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
							)
							    |
							(
								otherlv_30='{'
								{
									newLeafNode(otherlv_30, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_7_0_1_2_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterOutputParserRuleCall_7_0_1_2_1_1_1_0());
										}
										lv_parameter_31_0=ruleParameterOutput
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStatemachineRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_31_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterOutput");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_32='}'
								{
									newLeafNode(otherlv_32, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_7_0_1_2_1_1_2());
								}
							)
						)
					)
					    |
					(
						otherlv_33='return'
						{
							newLeafNode(otherlv_33, grammarAccess.getStatemachineAccess().getReturnKeyword_7_0_1_3_0());
						}
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterReturnParserRuleCall_7_0_1_3_1_0_0());
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
							)
							    |
							(
								otherlv_35='{'
								{
									newLeafNode(otherlv_35, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_7_0_1_3_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterReturnParserRuleCall_7_0_1_3_1_1_1_0());
										}
										lv_parameter_36_0=ruleParameterReturn
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStatemachineRule());
											}
											add(
												$current,
												"parameter",
												lv_parameter_36_0,
												"org.eclipse.efm.formalml.xtext.FormalML.ParameterReturn");
											afterParserOrEnumRuleCall();
										}
									)
								)+
								otherlv_37='}'
								{
									newLeafNode(otherlv_37, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_7_0_1_3_1_1_2());
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
						lv_port_38_0=rulePort
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"port",
								lv_port_38_0,
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
						lv_signal_39_0=ruleSignal
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"signal",
								lv_signal_39_0,
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
						lv_buffer_40_0=ruleBuffer
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"buffer",
								lv_buffer_40_0,
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
						lv_channel_41_0=ruleChannel
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"channel",
								lv_channel_41_0,
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
						lv_typedef_42_0=ruleTypeDefinition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
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
							newCompositeNode(grammarAccess.getStatemachineAccess().getFunctionFunctionParserRuleCall_7_1_5_0());
						}
						lv_function_43_0=ruleFunction
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"function",
								lv_function_43_0,
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
						lv_variable_44_0=ruleVariable
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"variable",
								lv_variable_44_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Variable");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			(
				otherlv_45='@input:'
				{
					newLeafNode(otherlv_45, grammarAccess.getStatemachineAccess().getInputKeyword_8_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInputParserRuleCall_8_0_1_0());
						}
						lv_parameter_46_0=ruleParameterInput
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_46_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterInput");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_47='@inout:'
				{
					newLeafNode(otherlv_47, grammarAccess.getStatemachineAccess().getInoutKeyword_8_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterInoutParserRuleCall_8_1_1_0());
						}
						lv_parameter_48_0=ruleParameterInout
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_48_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterInout");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_49='@output:'
				{
					newLeafNode(otherlv_49, grammarAccess.getStatemachineAccess().getOutputKeyword_8_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterOutputParserRuleCall_8_2_1_0());
						}
						lv_parameter_50_0=ruleParameterOutput
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_50_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterOutput");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				otherlv_51='@return:'
				{
					newLeafNode(otherlv_51, grammarAccess.getStatemachineAccess().getReturnKeyword_8_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStatemachineAccess().getParameterParameterReturnParserRuleCall_8_3_1_0());
						}
						lv_parameter_52_0=ruleParameterReturn
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"parameter",
								lv_parameter_52_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ParameterReturn");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)*
		(
			(
				otherlv_53='@property:'
				{
					newLeafNode(otherlv_53, grammarAccess.getStatemachineAccess().getPropertyKeyword_9_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortParserRuleCall_9_0_1_0_0());
							}
							lv_port_54_0=rulePort
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"port",
									lv_port_54_0,
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
							lv_signal_55_0=ruleSignal
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"signal",
									lv_signal_55_0,
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
							lv_buffer_56_0=ruleBuffer
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_56_0,
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
							lv_channel_57_0=ruleChannel
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"channel",
									lv_channel_57_0,
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
							lv_typedef_58_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_58_0,
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
							lv_function_59_0=ruleFunction
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"function",
									lv_function_59_0,
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
							lv_variable_60_0=ruleVariable
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"variable",
									lv_variable_60_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Variable");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_61='@public:'
				{
					newLeafNode(otherlv_61, grammarAccess.getStatemachineAccess().getPublicKeyword_9_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortPublicParserRuleCall_9_1_1_0_0());
							}
							lv_port_62_0=rulePortPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"port",
									lv_port_62_0,
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
							lv_signal_63_0=ruleSignalPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"signal",
									lv_signal_63_0,
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
							lv_buffer_64_0=ruleBufferPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_64_0,
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
							lv_channel_65_0=ruleChannelPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"channel",
									lv_channel_65_0,
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
							lv_typedef_66_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_66_0,
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
							lv_function_67_0=ruleFunctionPublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"function",
									lv_function_67_0,
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
							lv_variable_68_0=ruleVariablePublic
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"variable",
									lv_variable_68_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariablePublic");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_69='@protected:'
				{
					newLeafNode(otherlv_69, grammarAccess.getStatemachineAccess().getProtectedKeyword_9_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortProtectedParserRuleCall_9_2_1_0_0());
							}
							lv_port_70_0=rulePortProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"port",
									lv_port_70_0,
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
							lv_signal_71_0=ruleSignalProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"signal",
									lv_signal_71_0,
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
							lv_buffer_72_0=ruleBufferProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_72_0,
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
							lv_channel_73_0=ruleChannelProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"channel",
									lv_channel_73_0,
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
							lv_typedef_74_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_74_0,
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
							lv_function_75_0=ruleFunctionProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"function",
									lv_function_75_0,
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
							lv_variable_76_0=ruleVariableProtected
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"variable",
									lv_variable_76_0,
									"org.eclipse.efm.formalml.xtext.FormalML.VariableProtected");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
			    |
			(
				otherlv_77='@private:'
				{
					newLeafNode(otherlv_77, grammarAccess.getStatemachineAccess().getPrivateKeyword_9_3_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getPortPortPrivateParserRuleCall_9_3_1_0_0());
							}
							lv_port_78_0=rulePortPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"port",
									lv_port_78_0,
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
							lv_signal_79_0=ruleSignalPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"signal",
									lv_signal_79_0,
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
							lv_buffer_80_0=ruleBufferPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"buffer",
									lv_buffer_80_0,
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
							lv_channel_81_0=ruleChannelPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"channel",
									lv_channel_81_0,
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
							lv_typedef_82_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"typedef",
									lv_typedef_82_0,
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
							lv_function_83_0=ruleFunctionPrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"function",
									lv_function_83_0,
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
							lv_variable_84_0=ruleVariablePrivate
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"variable",
									lv_variable_84_0,
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
						otherlv_85='@routine:'
						{
							newLeafNode(otherlv_85, grammarAccess.getStatemachineAccess().getRoutineKeyword_10_0_0_0_0());
						}
						    |
						otherlv_86='@macro:'
						{
							newLeafNode(otherlv_86, grammarAccess.getStatemachineAccess().getMacroKeyword_10_0_0_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getRoutineRoutineParserRuleCall_10_0_0_1_0());
							}
							lv_routine_87_0=ruleRoutine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"routine",
									lv_routine_87_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Routine");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
				    |
				(
					otherlv_88='@procedure:'
					{
						newLeafNode(otherlv_88, grammarAccess.getStatemachineAccess().getProcedureKeyword_10_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getProcedureProcedureParserRuleCall_10_0_1_1_0());
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
						lv_routine_90_0=ruleRoutine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"routine",
								lv_routine_90_0,
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
						lv_procedure_91_0=ruleProcedure
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStatemachineRule());
							}
							add(
								$current,
								"procedure",
								lv_procedure_91_0,
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
					otherlv_92='@statemachine:'
					{
						newLeafNode(otherlv_92, grammarAccess.getStatemachineAccess().getStatemachineKeyword_11_0_0_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getMachineStatemachineParserRuleCall_11_0_0_1_0());
							}
							lv_machine_93_0=ruleStatemachine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"machine",
									lv_machine_93_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Statemachine");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
				    |
				(
					otherlv_94='@composite:'
					{
						newLeafNode(otherlv_94, grammarAccess.getStatemachineAccess().getCompositeKeyword_11_0_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getMachineAnyMachineBlockParserRuleCall_11_0_1_1_0());
							}
							lv_machine_95_0=ruleAnyMachineBlock
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"machine",
									lv_machine_95_0,
									"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
								afterParserOrEnumRuleCall();
							}
						)
					)*
				)
				    |
				(
					otherlv_96='@model:'
					{
						newLeafNode(otherlv_96, grammarAccess.getStatemachineAccess().getModelKeyword_11_0_2_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getMachineAnyMachineBlockParserRuleCall_11_0_2_1_0());
							}
							lv_machine_97_0=ruleAnyMachineBlock
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"machine",
									lv_machine_97_0,
									"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
								afterParserOrEnumRuleCall();
							}
						)
					)*
				)
				    |
				(
					otherlv_98='@prototype:'
					{
						newLeafNode(otherlv_98, grammarAccess.getStatemachineAccess().getPrototypeKeyword_11_0_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getMachineAnyMachineBlockParserRuleCall_11_0_3_1_0());
							}
							lv_machine_99_0=ruleAnyMachineBlock
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"machine",
									lv_machine_99_0,
									"org.eclipse.efm.formalml.xtext.FormalML.AnyMachineBlock");
								afterParserOrEnumRuleCall();
							}
						)
					)*
				)
				    |
				(
					otherlv_100='@instance:'
					{
						newLeafNode(otherlv_100, grammarAccess.getStatemachineAccess().getInstanceKeyword_11_0_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getStatemachineAccess().getInstanceInstanceMachineParserRuleCall_11_0_4_1_0());
							}
							lv_instance_101_0=ruleInstanceMachine
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStatemachineRule());
								}
								add(
									$current,
									"instance",
									lv_instance_101_0,
									"org.eclipse.efm.formalml.xtext.FormalML.InstanceMachine");
								afterParserOrEnumRuleCall();
							}
						)
					)*
				)
			)+
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineAccess().getRegionStatemachineRegionParserRuleCall_11_1_0());
					}
					lv_region_102_0=ruleStatemachineRegion
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRule());
						}
						add(
							$current,
							"region",
							lv_region_102_0,
							"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegion");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineAccess().getRegionStatemachineNamedRegionParserRuleCall_11_2_0());
					}
					lv_region_103_0=ruleStatemachineNamedRegion
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRule());
						}
						add(
							$current,
							"region",
							lv_region_103_0,
							"org.eclipse.efm.formalml.xtext.FormalML.StatemachineNamedRegion");
						afterParserOrEnumRuleCall();
					}
				)
			)+
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineAccess().getRegionStatemachineRegionLiteParserRuleCall_11_3_0());
					}
					lv_region_104_0=ruleStatemachineRegionLite
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRule());
						}
						add(
							$current,
							"region",
							lv_region_104_0,
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
									lv_execution_106_0=ruleModelOfExecution
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										set(
											$current,
											"execution",
											lv_execution_106_0,
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
									lv_interaction_107_0=ruleModelOfInteraction
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getStatemachineRule());
										}
										set(
											$current,
											"interaction",
											lv_interaction_107_0,
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
		otherlv_108='}'
		{
			newLeafNode(otherlv_108, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_13());
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
			otherlv_1='@state:'
			{
				newLeafNode(otherlv_1, grammarAccess.getStatemachineRegionAccess().getStateKeyword_1_0());
			}
			    |
			otherlv_2='@region:'
			{
				newLeafNode(otherlv_2, grammarAccess.getStatemachineRegionAccess().getRegionKeyword_1_1());
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineRegionAccess().getVertexStateParserRuleCall_2_0_0());
					}
					lv_vertex_3_0=ruleState
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRegionRule());
						}
						add(
							$current,
							"vertex",
							lv_vertex_3_0,
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
					lv_vertex_4_0=rulePseudostate
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineRegionRule());
						}
						add(
							$current,
							"vertex",
							lv_vertex_4_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Pseudostate");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)+
	)
;

// Entry rule entryRuleStatemachineNamedRegion
entryRuleStatemachineNamedRegion returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStatemachineNamedRegionRule()); }
	iv_ruleStatemachineNamedRegion=ruleStatemachineNamedRegion
	{ $current=$iv_ruleStatemachineNamedRegion.current; }
	EOF;

// Rule StatemachineNamedRegion
ruleStatemachineNamedRegion returns [EObject current=null]
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
					grammarAccess.getStatemachineNamedRegionAccess().getRegionAction_0(),
					$current);
			}
		)
		otherlv_1='@region('
		{
			newLeafNode(otherlv_1, grammarAccess.getStatemachineNamedRegionAccess().getRegionKeyword_1());
		}
		(
			otherlv_2='id:'
			{
				newLeafNode(otherlv_2, grammarAccess.getStatemachineNamedRegionAccess().getIdKeyword_2_0());
			}
			    |
			otherlv_3='name:'
			{
				newLeafNode(otherlv_3, grammarAccess.getStatemachineNamedRegionAccess().getNameKeyword_2_1());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getStatemachineNamedRegionAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_4_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineNamedRegionRule());
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
					newCompositeNode(grammarAccess.getStatemachineNamedRegionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_unrestrictedName_5_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStatemachineNamedRegionRule());
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
		otherlv_6='):'
		{
			newLeafNode(otherlv_6, grammarAccess.getStatemachineNamedRegionAccess().getRightParenthesisColonKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineNamedRegionAccess().getVertexStateParserRuleCall_6_0_0());
					}
					lv_vertex_7_0=ruleState
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineNamedRegionRule());
						}
						add(
							$current,
							"vertex",
							lv_vertex_7_0,
							"org.eclipse.efm.formalml.xtext.FormalML.State");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStatemachineNamedRegionAccess().getVertexPseudostateParserRuleCall_6_1_0());
					}
					lv_vertex_8_0=rulePseudostate
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStatemachineNamedRegionRule());
						}
						add(
							$current,
							"vertex",
							lv_vertex_8_0,
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
entryRuleCompositeState returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0(), 
	grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1()
	);
}:
	{ newCompositeNode(grammarAccess.getCompositeStateRule()); }
	iv_ruleCompositeState=ruleCompositeState
	{ $current=$iv_ruleCompositeState.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule CompositeState
ruleCompositeState returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0(), 
	grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1()
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
							{ 
							  getUnorderedGroupHelper().enter(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0());
							}
							(
								(
						(
							{getUnorderedGroupHelper().canSelect(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0(), 0)}?=>(
								{
									getUnorderedGroupHelper().select(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0(), 0);
								}
											({true}?=>((
												(
													{
														newCompositeNode(grammarAccess.getCompositeStateAccess().getRegionStatemachineRegionParserRuleCall_8_0_1_0_0_0_0());
													}
													lv_region_11_0=ruleStatemachineRegion
													{
														if ($current==null) {
															$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
														}
														add(
															$current,
															"region",
															lv_region_11_0,
															"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegion");
														afterParserOrEnumRuleCall();
													}
												)
											)
											    |
											(
												(
													{
														newCompositeNode(grammarAccess.getCompositeStateAccess().getRegionStatemachineNamedRegionParserRuleCall_8_0_1_0_0_1_0());
													}
													lv_region_12_0=ruleStatemachineNamedRegion
													{
														if ($current==null) {
															$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
														}
														add(
															$current,
															"region",
															lv_region_12_0,
															"org.eclipse.efm.formalml.xtext.FormalML.StatemachineNamedRegion");
														afterParserOrEnumRuleCall();
													}
												)
											)+
											))
								{ 
									getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0());
								}
							)
						)|
						(
							{getUnorderedGroupHelper().canSelect(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0(), 1)}?=>(
								{
									getUnorderedGroupHelper().select(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0(), 1);
								}
											({true}?=>(otherlv_13='@moe:'
											{
												newLeafNode(otherlv_13, grammarAccess.getCompositeStateAccess().getMoeKeyword_8_0_1_0_1_0());
											}
											(
												(
													{
														newCompositeNode(grammarAccess.getCompositeStateAccess().getMoeMoeCompositeStateRoutinesParserRuleCall_8_0_1_0_1_1_0());
													}
													lv_moe_14_0=rulemoeCompositeStateRoutines
													{
														if ($current==null) {
															$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
														}
														set(
															$current,
															"moe",
															lv_moe_14_0,
															"org.eclipse.efm.formalml.xtext.FormalML.moeCompositeStateRoutines");
														afterParserOrEnumRuleCall();
													}
												)
											)
											))
								{ 
									getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0());
								}
							)
						)|
						(
							{getUnorderedGroupHelper().canSelect(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0(), 2)}?=>(
								{
									getUnorderedGroupHelper().select(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0(), 2);
								}
											({true}?=>(otherlv_15='@transition:'
											{
												newLeafNode(otherlv_15, grammarAccess.getCompositeStateAccess().getTransitionKeyword_8_0_1_0_2_0());
											}
											(
												(
													{
														newCompositeNode(grammarAccess.getCompositeStateAccess().getTransitionTransitionParserRuleCall_8_0_1_0_2_1_0());
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
											)*
											))
								{ 
									getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0());
								}
							)
						)
								)+
								{getUnorderedGroupHelper().canLeave(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0())}?
							)
						)
							{ 
							  getUnorderedGroupHelper().leave(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_0());
							}
					)
					    |
					(
						(
							{ 
							  getUnorderedGroupHelper().enter(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1());
							}
							(
								(
						(
							{getUnorderedGroupHelper().canSelect(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1(), 0)}?=>(
								{
									getUnorderedGroupHelper().select(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1(), 0);
								}
											({true}?=>((
												{
													newCompositeNode(grammarAccess.getCompositeStateAccess().getRegionStatemachineRegionLiteParserRuleCall_8_0_1_1_0_0());
												}
												lv_region_18_0=ruleStatemachineRegionLite
												{
													if ($current==null) {
														$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
													}
													add(
														$current,
														"region",
														lv_region_18_0,
														"org.eclipse.efm.formalml.xtext.FormalML.StatemachineRegionLite");
													afterParserOrEnumRuleCall();
												}
											)
											))+
								{ 
									getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1());
								}
							)
						)|
						(
							{getUnorderedGroupHelper().canSelect(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1(), 1)}?=>(
								{
									getUnorderedGroupHelper().select(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1(), 1);
								}
											({true}?=>((
												{
													newCompositeNode(grammarAccess.getCompositeStateAccess().getMoeMoeCompositeStateRoutinesParserRuleCall_8_0_1_1_1_0());
												}
												lv_moe_19_0=rulemoeCompositeStateRoutines
												{
													if ($current==null) {
														$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
													}
													set(
														$current,
														"moe",
														lv_moe_19_0,
														"org.eclipse.efm.formalml.xtext.FormalML.moeCompositeStateRoutines");
													afterParserOrEnumRuleCall();
												}
											)
											))
								{ 
									getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1());
								}
							)
						)|
						(
							{getUnorderedGroupHelper().canSelect(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1(), 2)}?=>(
								{
									getUnorderedGroupHelper().select(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1(), 2);
								}
											({true}?=>((
												{
													newCompositeNode(grammarAccess.getCompositeStateAccess().getTransitionTransitionParserRuleCall_8_0_1_1_2_0());
												}
												lv_transition_20_0=ruleTransition
												{
													if ($current==null) {
														$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
													}
													add(
														$current,
														"transition",
														lv_transition_20_0,
														"org.eclipse.efm.formalml.xtext.FormalML.Transition");
													afterParserOrEnumRuleCall();
												}
											)
											))+
								{ 
									getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1());
								}
							)
						)
								)*
							)
						)
							{ 
							  getUnorderedGroupHelper().leave(grammarAccess.getCompositeStateAccess().getUnorderedGroup_8_0_1_1());
							}
					)
				)
				otherlv_21='}'
				{
					newLeafNode(otherlv_21, grammarAccess.getCompositeStateAccess().getRightCurlyBracketKeyword_8_0_2());
				}
			)
			    |
			otherlv_22=';'
			{
				newLeafNode(otherlv_22, grammarAccess.getCompositeStateAccess().getSemicolonKeyword_8_1());
			}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRulemoeCompositeStateRoutines
entryRulemoeCompositeStateRoutines returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesRule()); }
	iv_rulemoeCompositeStateRoutines=rulemoeCompositeStateRoutines
	{ $current=$iv_rulemoeCompositeStateRoutines.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule moeCompositeStateRoutines
rulemoeCompositeStateRoutines returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1()
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
					grammarAccess.getMoeCompositeStateRoutinesAccess().getModelOfExecutionAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>(otherlv_2='@create'
								{
									newLeafNode(otherlv_2, grammarAccess.getMoeCompositeStateRoutinesAccess().getCreateKeyword_1_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getCreateRoutineMoeRoutineParserRuleCall_1_0_1_0());
										}
										lv_createRoutine_3_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
											}
											set(
												$current,
												"createRoutine",
												lv_createRoutine_3_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>(otherlv_4='@init'
								{
									newLeafNode(otherlv_4, grammarAccess.getMoeCompositeStateRoutinesAccess().getInitKeyword_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getInitRoutineMoeRoutineParserRuleCall_1_1_1_0());
										}
										lv_initRoutine_5_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 2);
					}
								({true}?=>(otherlv_6='@final'
								{
									newLeafNode(otherlv_6, grammarAccess.getMoeCompositeStateRoutinesAccess().getFinalKeyword_1_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getFinalRoutineMoeRoutineParserRuleCall_1_2_1_0());
										}
										lv_finalRoutine_7_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 3);
					}
								({true}?=>(otherlv_8='@enable'
								{
									newLeafNode(otherlv_8, grammarAccess.getMoeCompositeStateRoutinesAccess().getEnableKeyword_1_3_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getEnableRoutineMoeRoutineParserRuleCall_1_3_1_0());
										}
										lv_enableRoutine_9_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 4);
					}
								({true}?=>(otherlv_10='@disable'
								{
									newLeafNode(otherlv_10, grammarAccess.getMoeCompositeStateRoutinesAccess().getDisableKeyword_1_4_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getDisableRoutineMoeRoutineParserRuleCall_1_4_1_0());
										}
										lv_disableRoutine_11_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 5);
					}
								({true}?=>(otherlv_12='@concurrency'
								{
									newLeafNode(otherlv_12, grammarAccess.getMoeCompositeStateRoutinesAccess().getConcurrencyKeyword_1_5_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getConcurrencyRoutineMoeRoutineParserRuleCall_1_5_1_0());
										}
										lv_concurrencyRoutine_13_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 6)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 6);
					}
								({true}?=>((
									otherlv_14='@schedule'
									{
										newLeafNode(otherlv_14, grammarAccess.getMoeCompositeStateRoutinesAccess().getScheduleKeyword_1_6_0_0());
									}
									    |
									otherlv_15='@xschedule'
									{
										newLeafNode(otherlv_15, grammarAccess.getMoeCompositeStateRoutinesAccess().getXscheduleKeyword_1_6_0_1());
									}
								)
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getScheduleRoutineMoeRoutineParserRuleCall_1_6_1_0());
										}
										lv_scheduleRoutine_16_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
											}
											set(
												$current,
												"scheduleRoutine",
												lv_scheduleRoutine_16_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 7)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 7);
					}
								({true}?=>(otherlv_17='@irun'
								{
									newLeafNode(otherlv_17, grammarAccess.getMoeCompositeStateRoutinesAccess().getIrunKeyword_1_7_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getIrunRoutineMoeRoutineParserRuleCall_1_7_1_0());
										}
										lv_irunRoutine_18_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
											}
											set(
												$current,
												"irunRoutine",
												lv_irunRoutine_18_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 8)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1(), 8);
					}
								({true}?=>(otherlv_19='@run'
								{
									newLeafNode(otherlv_19, grammarAccess.getMoeCompositeStateRoutinesAccess().getRunKeyword_1_8_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeCompositeStateRoutinesAccess().getRunRoutineMoeRoutineParserRuleCall_1_8_1_0());
										}
										lv_runRoutine_20_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeCompositeStateRoutinesRule());
											}
											set(
												$current,
												"runRoutine",
												lv_runRoutine_20_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getMoeCompositeStateRoutinesAccess().getUnorderedGroup_1());
				}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleSimpleState
entryRuleSimpleState returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1()
	);
}:
	{ newCompositeNode(grammarAccess.getSimpleStateRule()); }
	iv_ruleSimpleState=ruleSimpleState
	{ $current=$iv_ruleSimpleState.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule SimpleState
ruleSimpleState returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1()
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
						{ 
						  getUnorderedGroupHelper().enter(grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1());
						}
						(
							(
					(
						{getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1(), 0)}?=>(
							{
								getUnorderedGroupHelper().select(grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1(), 0);
							}
										({true}?=>((
											{
												newCompositeNode(grammarAccess.getSimpleStateAccess().getTransitionTransitionParserRuleCall_5_0_1_0_0());
											}
											lv_transition_10_0=ruleTransition
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getSimpleStateRule());
												}
												add(
													$current,
													"transition",
													lv_transition_10_0,
													"org.eclipse.efm.formalml.xtext.FormalML.Transition");
												afterParserOrEnumRuleCall();
											}
										)
										))+
							{ 
								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1());
							}
						)
					)|
					(
						{getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1(), 1)}?=>(
							{
								getUnorderedGroupHelper().select(grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1(), 1);
							}
										({true}?=>((
											{
												newCompositeNode(grammarAccess.getSimpleStateAccess().getMoeMoeSimpleStateRoutinesParserRuleCall_5_0_1_1_0());
											}
											lv_moe_11_0=rulemoeSimpleStateRoutines
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getSimpleStateRule());
												}
												set(
													$current,
													"moe",
													lv_moe_11_0,
													"org.eclipse.efm.formalml.xtext.FormalML.moeSimpleStateRoutines");
												afterParserOrEnumRuleCall();
											}
										)
										))
							{ 
								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1());
							}
						)
					)
							)*
						)
					)
						{ 
						  getUnorderedGroupHelper().leave(grammarAccess.getSimpleStateAccess().getUnorderedGroup_5_0_1());
						}
				)
				otherlv_12='}'
				{
					newLeafNode(otherlv_12, grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_5_0_2());
				}
			)
			    |
			otherlv_13=';'
			{
				newLeafNode(otherlv_13, grammarAccess.getSimpleStateAccess().getSemicolonKeyword_5_1());
			}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRulemoeSimpleStateRoutines
entryRulemoeSimpleStateRoutines returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getMoeSimpleStateRoutinesRule()); }
	iv_rulemoeSimpleStateRoutines=rulemoeSimpleStateRoutines
	{ $current=$iv_rulemoeSimpleStateRoutines.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule moeSimpleStateRoutines
rulemoeSimpleStateRoutines returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1()
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
					grammarAccess.getMoeSimpleStateRoutinesAccess().getModelOfExecutionAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>(otherlv_2='@enable'
								{
									newLeafNode(otherlv_2, grammarAccess.getMoeSimpleStateRoutinesAccess().getEnableKeyword_1_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeSimpleStateRoutinesAccess().getEnableRoutineMoeRoutineParserRuleCall_1_0_1_0());
										}
										lv_enableRoutine_3_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeSimpleStateRoutinesRule());
											}
											set(
												$current,
												"enableRoutine",
												lv_enableRoutine_3_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>(otherlv_4='@disable'
								{
									newLeafNode(otherlv_4, grammarAccess.getMoeSimpleStateRoutinesAccess().getDisableKeyword_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeSimpleStateRoutinesAccess().getDisableRoutineMoeRoutineParserRuleCall_1_1_1_0());
										}
										lv_disableRoutine_5_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeSimpleStateRoutinesRule());
											}
											set(
												$current,
												"disableRoutine",
												lv_disableRoutine_5_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1(), 2);
					}
								({true}?=>(otherlv_6='@irun'
								{
									newLeafNode(otherlv_6, grammarAccess.getMoeSimpleStateRoutinesAccess().getIrunKeyword_1_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeSimpleStateRoutinesAccess().getIrunRoutineMoeRoutineParserRuleCall_1_2_1_0());
										}
										lv_irunRoutine_7_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeSimpleStateRoutinesRule());
											}
											set(
												$current,
												"irunRoutine",
												lv_irunRoutine_7_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getMoeSimpleStateRoutinesAccess().getUnorderedGroup_1());
				}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleStartState
entryRuleStartState returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1()
	);
}:
	{ newCompositeNode(grammarAccess.getStartStateRule()); }
	iv_ruleStartState=ruleStartState
	{ $current=$iv_ruleStartState.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule StartState
ruleStartState returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1()
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
						{ 
						  getUnorderedGroupHelper().enter(grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1());
						}
						(
							(
					(
						{getUnorderedGroupHelper().canSelect(grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1(), 0)}?=>(
							{
								getUnorderedGroupHelper().select(grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1(), 0);
							}
										({true}?=>((
											{
												newCompositeNode(grammarAccess.getStartStateAccess().getTransitionTransitionParserRuleCall_3_0_1_0_0());
											}
											lv_transition_11_0=ruleTransition
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getStartStateRule());
												}
												add(
													$current,
													"transition",
													lv_transition_11_0,
													"org.eclipse.efm.formalml.xtext.FormalML.Transition");
												afterParserOrEnumRuleCall();
											}
										)
										))+
							{ 
								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1());
							}
						)
					)|
					(
						{getUnorderedGroupHelper().canSelect(grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1(), 1)}?=>(
							{
								getUnorderedGroupHelper().select(grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1(), 1);
							}
										({true}?=>((
											{
												newCompositeNode(grammarAccess.getStartStateAccess().getMoeMoeStartStateRoutinesParserRuleCall_3_0_1_1_0());
											}
											lv_moe_12_0=rulemoeStartStateRoutines
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getStartStateRule());
												}
												set(
													$current,
													"moe",
													lv_moe_12_0,
													"org.eclipse.efm.formalml.xtext.FormalML.moeStartStateRoutines");
												afterParserOrEnumRuleCall();
											}
										)
										))
							{ 
								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1());
							}
						)
					)
							)*
						)
					)
						{ 
						  getUnorderedGroupHelper().leave(grammarAccess.getStartStateAccess().getUnorderedGroup_3_0_1());
						}
				)
				otherlv_13='}'
				{
					newLeafNode(otherlv_13, grammarAccess.getStartStateAccess().getRightCurlyBracketKeyword_3_0_2());
				}
			)
			    |
			otherlv_14=';'
			{
				newLeafNode(otherlv_14, grammarAccess.getStartStateAccess().getSemicolonKeyword_3_1());
			}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRulemoeStartStateRoutines
entryRulemoeStartStateRoutines returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getMoeStartStateRoutinesRule()); }
	iv_rulemoeStartStateRoutines=rulemoeStartStateRoutines
	{ $current=$iv_rulemoeStartStateRoutines.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule moeStartStateRoutines
rulemoeStartStateRoutines returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1()
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
					grammarAccess.getMoeStartStateRoutinesAccess().getModelOfExecutionAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>(otherlv_2='@create'
								{
									newLeafNode(otherlv_2, grammarAccess.getMoeStartStateRoutinesAccess().getCreateKeyword_1_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeStartStateRoutinesAccess().getCreateRoutineMoeRoutineParserRuleCall_1_0_1_0());
										}
										lv_createRoutine_3_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeStartStateRoutinesRule());
											}
											set(
												$current,
												"createRoutine",
												lv_createRoutine_3_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>(otherlv_4='@init'
								{
									newLeafNode(otherlv_4, grammarAccess.getMoeStartStateRoutinesAccess().getInitKeyword_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeStartStateRoutinesAccess().getInitRoutineMoeRoutineParserRuleCall_1_1_1_0());
										}
										lv_initRoutine_5_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeStartStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 2);
					}
								({true}?=>(otherlv_6='@final'
								{
									newLeafNode(otherlv_6, grammarAccess.getMoeStartStateRoutinesAccess().getFinalKeyword_1_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeStartStateRoutinesAccess().getFinalRoutineMoeRoutineParserRuleCall_1_2_1_0());
										}
										lv_finalRoutine_7_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeStartStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 3);
					}
								({true}?=>(otherlv_8='@enable'
								{
									newLeafNode(otherlv_8, grammarAccess.getMoeStartStateRoutinesAccess().getEnableKeyword_1_3_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeStartStateRoutinesAccess().getEnableRoutineMoeRoutineParserRuleCall_1_3_1_0());
										}
										lv_enableRoutine_9_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeStartStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 4);
					}
								({true}?=>(otherlv_10='@disable'
								{
									newLeafNode(otherlv_10, grammarAccess.getMoeStartStateRoutinesAccess().getDisableKeyword_1_4_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeStartStateRoutinesAccess().getDisableRoutineMoeRoutineParserRuleCall_1_4_1_0());
										}
										lv_disableRoutine_11_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeStartStateRoutinesRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1(), 5);
					}
								({true}?=>(otherlv_12='@irun'
								{
									newLeafNode(otherlv_12, grammarAccess.getMoeStartStateRoutinesAccess().getIrunKeyword_1_5_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeStartStateRoutinesAccess().getIrunRoutineMoeRoutineParserRuleCall_1_5_1_0());
										}
										lv_irunRoutine_13_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeStartStateRoutinesRule());
											}
											set(
												$current,
												"irunRoutine",
												lv_irunRoutine_13_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getMoeStartStateRoutinesAccess().getUnorderedGroup_1());
				}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

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
						otherlv_10='@moe:'
						{
							newLeafNode(otherlv_10, grammarAccess.getFinalStateAccess().getMoeKeyword_3_0_1_0());
						}
					)?
					(
						(
							{
								newCompositeNode(grammarAccess.getFinalStateAccess().getMoeMoeFinalStateRoutinesParserRuleCall_3_0_1_1_0());
							}
							lv_moe_11_0=rulemoeFinalStateRoutines
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getFinalStateRule());
								}
								set(
									$current,
									"moe",
									lv_moe_11_0,
									"org.eclipse.efm.formalml.xtext.FormalML.moeFinalStateRoutines");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				otherlv_12='}'
				{
					newLeafNode(otherlv_12, grammarAccess.getFinalStateAccess().getRightCurlyBracketKeyword_3_0_2());
				}
			)
			    |
			otherlv_13=';'
			{
				newLeafNode(otherlv_13, grammarAccess.getFinalStateAccess().getSemicolonKeyword_3_1());
			}
		)
	)
;

// Entry rule entryRulemoeFinalStateRoutines
entryRulemoeFinalStateRoutines returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getMoeFinalStateRoutinesRule()); }
	iv_rulemoeFinalStateRoutines=rulemoeFinalStateRoutines
	{ $current=$iv_rulemoeFinalStateRoutines.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule moeFinalStateRoutines
rulemoeFinalStateRoutines returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1()
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
					grammarAccess.getMoeFinalStateRoutinesAccess().getModelOfExecutionAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>(otherlv_2='@enable'
								{
									newLeafNode(otherlv_2, grammarAccess.getMoeFinalStateRoutinesAccess().getEnableKeyword_1_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeFinalStateRoutinesAccess().getEnableRoutineMoeRoutineParserRuleCall_1_0_1_0());
										}
										lv_enableRoutine_3_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeFinalStateRoutinesRule());
											}
											set(
												$current,
												"enableRoutine",
												lv_enableRoutine_3_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>(otherlv_4='@final'
								{
									newLeafNode(otherlv_4, grammarAccess.getMoeFinalStateRoutinesAccess().getFinalKeyword_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoeFinalStateRoutinesAccess().getFinalRoutineMoeRoutineParserRuleCall_1_1_1_0());
										}
										lv_finalRoutine_5_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoeFinalStateRoutinesRule());
											}
											set(
												$current,
												"finalRoutine",
												lv_finalRoutine_5_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getMoeFinalStateRoutinesAccess().getUnorderedGroup_1());
				}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

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
entryRuleOtherPseudostate returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1()
	);
}:
	{ newCompositeNode(grammarAccess.getOtherPseudostateRule()); }
	iv_ruleOtherPseudostate=ruleOtherPseudostate
	{ $current=$iv_ruleOtherPseudostate.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule OtherPseudostate
ruleOtherPseudostate returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1()
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
						  getUnorderedGroupHelper().enter(grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1());
						}
						(
							(
					(
						{getUnorderedGroupHelper().canSelect(grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1(), 0)}?=>(
							{
								getUnorderedGroupHelper().select(grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1(), 0);
							}
										({true}?=>((
											{
												newCompositeNode(grammarAccess.getOtherPseudostateAccess().getTransitionTransitionParserRuleCall_8_0_1_0_0());
											}
											lv_transition_11_0=ruleTransition
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getOtherPseudostateRule());
												}
												add(
													$current,
													"transition",
													lv_transition_11_0,
													"org.eclipse.efm.formalml.xtext.FormalML.Transition");
												afterParserOrEnumRuleCall();
											}
										)
										))+
							{ 
								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1());
							}
						)
					)|
					(
						{getUnorderedGroupHelper().canSelect(grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1(), 1)}?=>(
							{
								getUnorderedGroupHelper().select(grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1(), 1);
							}
										({true}?=>((
											{
												newCompositeNode(grammarAccess.getOtherPseudostateAccess().getMoeMoePseudotateRoutinesParserRuleCall_8_0_1_1_0());
											}
											lv_moe_12_0=rulemoePseudotateRoutines
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getOtherPseudostateRule());
												}
												set(
													$current,
													"moe",
													lv_moe_12_0,
													"org.eclipse.efm.formalml.xtext.FormalML.moePseudotateRoutines");
												afterParserOrEnumRuleCall();
											}
										)
										))
							{ 
								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1());
							}
						)
					)
							)*
						)
					)
						{ 
						  getUnorderedGroupHelper().leave(grammarAccess.getOtherPseudostateAccess().getUnorderedGroup_8_0_1());
						}
				)
				otherlv_13='}'
				{
					newLeafNode(otherlv_13, grammarAccess.getOtherPseudostateAccess().getRightCurlyBracketKeyword_8_0_2());
				}
			)
			    |
			otherlv_14=';'
			{
				newLeafNode(otherlv_14, grammarAccess.getOtherPseudostateAccess().getSemicolonKeyword_8_1());
			}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRulemoePseudotateRoutines
entryRulemoePseudotateRoutines returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1()
	);
}:
	{ newCompositeNode(grammarAccess.getMoePseudotateRoutinesRule()); }
	iv_rulemoePseudotateRoutines=rulemoePseudotateRoutines
	{ $current=$iv_rulemoePseudotateRoutines.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule moePseudotateRoutines
rulemoePseudotateRoutines returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1()
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
					grammarAccess.getMoePseudotateRoutinesAccess().getModelOfExecutionAction_0(),
					$current);
			}
		)
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1(), 0);
					}
								({true}?=>(otherlv_2='@enable'
								{
									newLeafNode(otherlv_2, grammarAccess.getMoePseudotateRoutinesAccess().getEnableKeyword_1_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoePseudotateRoutinesAccess().getEnableRoutineMoeRoutineParserRuleCall_1_0_1_0());
										}
										lv_enableRoutine_3_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoePseudotateRoutinesRule());
											}
											set(
												$current,
												"enableRoutine",
												lv_enableRoutine_3_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1(), 1);
					}
								({true}?=>(otherlv_4='@disable'
								{
									newLeafNode(otherlv_4, grammarAccess.getMoePseudotateRoutinesAccess().getDisableKeyword_1_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getMoePseudotateRoutinesAccess().getDisableRoutineMoeRoutineParserRuleCall_1_1_1_0());
										}
										lv_disableRoutine_5_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getMoePseudotateRoutinesRule());
											}
											set(
												$current,
												"disableRoutine",
												lv_disableRoutine_5_0,
												"org.eclipse.efm.formalml.xtext.FormalML.moeRoutine");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getMoePseudotateRoutinesAccess().getUnorderedGroup_1());
				}
		)
	)
;
finally {
	myUnorderedGroupState.restore();
}

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
						otherlv_11='@transition:'
						{
							newLeafNode(otherlv_11, grammarAccess.getPseudostateInitialAccess().getTransitionKeyword_3_0_1_0());
						}
					)?
					(
						(
							{
								newCompositeNode(grammarAccess.getPseudostateInitialAccess().getTransitionTransitionParserRuleCall_3_0_1_1_0());
							}
							lv_transition_12_0=ruleTransition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getPseudostateInitialRule());
								}
								add(
									$current,
									"transition",
									lv_transition_12_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Transition");
								afterParserOrEnumRuleCall();
							}
						)
					)*
				)?
				otherlv_13='}'
				{
					newLeafNode(otherlv_13, grammarAccess.getPseudostateInitialAccess().getRightCurlyBracketKeyword_3_0_2());
				}
			)
			    |
			otherlv_14=';'
			{
				newLeafNode(otherlv_14, grammarAccess.getPseudostateInitialAccess().getSemicolonKeyword_3_1());
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
						otherlv_10='@moe:'
						{
							newLeafNode(otherlv_10, grammarAccess.getEndingPseudostateAccess().getMoeKeyword_8_0_1_0());
						}
					)?
					(
						(
							{
								newCompositeNode(grammarAccess.getEndingPseudostateAccess().getMoeMoeFinalStateRoutinesParserRuleCall_8_0_1_1_0());
							}
							lv_moe_11_0=rulemoeFinalStateRoutines
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getEndingPseudostateRule());
								}
								set(
									$current,
									"moe",
									lv_moe_11_0,
									"org.eclipse.efm.formalml.xtext.FormalML.moeFinalStateRoutines");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				otherlv_12='}'
				{
					newLeafNode(otherlv_12, grammarAccess.getEndingPseudostateAccess().getRightCurlyBracketKeyword_8_0_2());
				}
			)
			    |
			otherlv_13=';'
			{
				newLeafNode(otherlv_13, grammarAccess.getEndingPseudostateAccess().getSemicolonKeyword_8_1());
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
								({true}?=>(otherlv_4='@create'
								{
									newLeafNode(otherlv_4, grammarAccess.getModelOfExecutionAccess().getCreateKeyword_3_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getCreateRoutineMoeRoutineParserRuleCall_3_0_1_0());
										}
										lv_createRoutine_5_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"createRoutine",
												lv_createRoutine_5_0,
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
								({true}?=>(otherlv_6='@init'
								{
									newLeafNode(otherlv_6, grammarAccess.getModelOfExecutionAccess().getInitKeyword_3_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getInitRoutineMoeRoutineParserRuleCall_3_1_1_0());
										}
										lv_initRoutine_7_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"initRoutine",
												lv_initRoutine_7_0,
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
								({true}?=>(otherlv_8='@final'
								{
									newLeafNode(otherlv_8, grammarAccess.getModelOfExecutionAccess().getFinalKeyword_3_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getFinalRoutineMoeRoutineParserRuleCall_3_2_1_0());
										}
										lv_finalRoutine_9_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"finalRoutine",
												lv_finalRoutine_9_0,
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
								({true}?=>(otherlv_10='@enable'
								{
									newLeafNode(otherlv_10, grammarAccess.getModelOfExecutionAccess().getEnableKeyword_3_3_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getEnableRoutineMoeRoutineParserRuleCall_3_3_1_0());
										}
										lv_enableRoutine_11_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"enableRoutine",
												lv_enableRoutine_11_0,
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
								({true}?=>(otherlv_12='@disable'
								{
									newLeafNode(otherlv_12, grammarAccess.getModelOfExecutionAccess().getDisableKeyword_3_4_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getDisableRoutineMoeRoutineParserRuleCall_3_4_1_0());
										}
										lv_disableRoutine_13_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"disableRoutine",
												lv_disableRoutine_13_0,
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
								({true}?=>(otherlv_14='@concurrency'
								{
									newLeafNode(otherlv_14, grammarAccess.getModelOfExecutionAccess().getConcurrencyKeyword_3_5_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getConcurrencyRoutineMoeRoutineParserRuleCall_3_5_1_0());
										}
										lv_concurrencyRoutine_15_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"concurrencyRoutine",
												lv_concurrencyRoutine_15_0,
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
								({true}?=>((
									otherlv_16='@schedule'
									{
										newLeafNode(otherlv_16, grammarAccess.getModelOfExecutionAccess().getScheduleKeyword_3_6_0_0());
									}
									    |
									otherlv_17='@xschedule'
									{
										newLeafNode(otherlv_17, grammarAccess.getModelOfExecutionAccess().getXscheduleKeyword_3_6_0_1());
									}
								)
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getScheduleRoutineMoeRoutineParserRuleCall_3_6_1_0());
										}
										lv_scheduleRoutine_18_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"scheduleRoutine",
												lv_scheduleRoutine_18_0,
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
								({true}?=>(otherlv_19='@irun'
								{
									newLeafNode(otherlv_19, grammarAccess.getModelOfExecutionAccess().getIrunKeyword_3_7_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getIrunRoutineMoeRoutineParserRuleCall_3_7_1_0());
										}
										lv_irunRoutine_20_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"irunRoutine",
												lv_irunRoutine_20_0,
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 8)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModelOfExecutionAccess().getUnorderedGroup_3(), 8);
					}
								({true}?=>(otherlv_21='@run'
								{
									newLeafNode(otherlv_21, grammarAccess.getModelOfExecutionAccess().getRunKeyword_3_8_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getModelOfExecutionAccess().getRunRoutineMoeRoutineParserRuleCall_3_8_1_0());
										}
										lv_runRoutine_22_0=rulemoeRoutine
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
											}
											set(
												$current,
												"runRoutine",
												lv_runRoutine_22_0,
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
				lv_routine_23_0=ruleRoutine
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelOfExecutionRule());
					}
					add(
						$current,
						"routine",
						lv_routine_23_0,
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
						newCompositeNode(grammarAccess.getMoeRoutineAccess().getParameterSetFormalParameterSetParserRuleCall_1_1_0());
					}
					lv_parameterSet_2_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMoeRoutineRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_2_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
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
					(
						{
							newCompositeNode(grammarAccess.getMoeRoutineAccess().getResultSetFormalParameterSetParserRuleCall_2_1_0_0());
						}
						lv_resultSet_5_0=ruleFormalParameterSet
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMoeRoutineRule());
							}
							set(
								$current,
								"resultSet",
								lv_resultSet_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					otherlv_6='('
					{
						newLeafNode(otherlv_6, grammarAccess.getMoeRoutineAccess().getLeftParenthesisKeyword_2_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getMoeRoutineAccess().getResultSetFormalParameterSetParserRuleCall_2_1_1_1_0());
							}
							lv_resultSet_7_0=ruleFormalParameterSet
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMoeRoutineRule());
								}
								set(
									$current,
									"resultSet",
									lv_resultSet_7_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_8=')'
					{
						newLeafNode(otherlv_8, grammarAccess.getMoeRoutineAccess().getRightParenthesisKeyword_2_1_1_2());
					}
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
			(
				lv_macro_1_0='macro'
				{
					newLeafNode(lv_macro_1_0, grammarAccess.getRoutineAccess().getMacroMacroKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRoutineRule());
					}
					setWithLastConsumed($current, "macro", true, "macro");
				}
			)
		)?
		(
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getRoutineAccess().getDesignDebugTraceParserRuleCall_2());
			}
			ruleDesignDebugTrace
			{
				afterParserOrEnumRuleCall();
			}
		)*
		otherlv_3='routine'
		{
			newLeafNode(otherlv_3, grammarAccess.getRoutineAccess().getRoutineKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRoutineAccess().getNameESIdentifierParserRuleCall_4_0());
				}
				lv_name_4_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoutineRule());
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
					newCompositeNode(grammarAccess.getRoutineAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_unrestrictedName_5_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoutineRule());
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
		(
			otherlv_6='('
			{
				newLeafNode(otherlv_6, grammarAccess.getRoutineAccess().getLeftParenthesisKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRoutineAccess().getParameterSetFormalParameterSetParserRuleCall_6_1_0());
					}
					lv_parameterSet_7_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRoutineRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_7_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_8=')'
			{
				newLeafNode(otherlv_8, grammarAccess.getRoutineAccess().getRightParenthesisKeyword_6_2());
			}
		)?
		(
			otherlv_9='-->'
			{
				newLeafNode(otherlv_9, grammarAccess.getRoutineAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_7_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getRoutineAccess().getResultSetFormalParameterSetParserRuleCall_7_1_0_0());
						}
						lv_resultSet_10_0=ruleFormalParameterSet
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRoutineRule());
							}
							set(
								$current,
								"resultSet",
								lv_resultSet_10_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					otherlv_11='('
					{
						newLeafNode(otherlv_11, grammarAccess.getRoutineAccess().getLeftParenthesisKeyword_7_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getRoutineAccess().getResultSetFormalParameterSetParserRuleCall_7_1_1_1_0());
							}
							lv_resultSet_12_0=ruleFormalParameterSet
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getRoutineRule());
								}
								set(
									$current,
									"resultSet",
									lv_resultSet_12_0,
									"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_13=')'
					{
						newLeafNode(otherlv_13, grammarAccess.getRoutineAccess().getRightParenthesisKeyword_7_1_1_2());
					}
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getRoutineAccess().getBodyBlockBlockStatementParserRuleCall_8_0());
				}
				lv_bodyBlock_14_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoutineRule());
					}
					set(
						$current,
						"bodyBlock",
						lv_bodyBlock_14_0,
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
						newCompositeNode(grammarAccess.getModelOfInteractionAccess().getConnectorsConnectorParserRuleCall_2_1_0());
					}
					lv_connectors_3_0=ruleConnector
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getModelOfInteractionRule());
						}
						add(
							$current,
							"connectors",
							lv_connectors_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Connector");
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

// Entry rule entryRuleConnector
entryRuleConnector returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConnectorRule()); }
	iv_ruleConnector=ruleConnector
	{ $current=$iv_ruleConnector.current; }
	EOF;

// Rule Connector
ruleConnector returns [EObject current=null]
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
				newLeafNode(otherlv_0, grammarAccess.getConnectorAccess().getConnectorKeyword_0_0());
			}
			    |
			otherlv_1='connect'
			{
				newLeafNode(otherlv_1, grammarAccess.getConnectorAccess().getConnectKeyword_0_1());
			}
		)
		otherlv_2='<'
		{
			newLeafNode(otherlv_2, grammarAccess.getConnectorAccess().getLessThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConnectorAccess().getProtocolComProtocolParserRuleCall_2_0());
				}
				lv_protocol_3_0=ruleComProtocol
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConnectorRule());
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
			newLeafNode(otherlv_4, grammarAccess.getConnectorAccess().getGreaterThanSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConnectorAccess().getNameESIdentifierParserRuleCall_4_0());
				}
				lv_name_5_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConnectorRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getConnectorAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_unrestrictedName_6_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConnectorRule());
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
			newLeafNode(otherlv_7, grammarAccess.getConnectorAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConnectorAccess().getConnectorEndConnectorEndParserRuleCall_7_0());
				}
				lv_connectorEnd_8_0=ruleConnectorEnd
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConnectorRule());
					}
					add(
						$current,
						"connectorEnd",
						lv_connectorEnd_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ConnectorEnd");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getConnectorAccess().getRightCurlyBracketKeyword_8());
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

// Entry rule entryRuleConnectorEnd
entryRuleConnectorEnd returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConnectorEndRule()); }
	iv_ruleConnectorEnd=ruleConnectorEnd
	{ $current=$iv_ruleConnectorEnd.current; }
	EOF;

// Rule ConnectorEnd
ruleConnectorEnd returns [EObject current=null]
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
					grammarAccess.getConnectorEndAccess().getConnectorEndAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getConnectorEndAccess().getDirectionChannelDirectionEnumRuleCall_1_0());
				}
				lv_direction_1_0=ruleChannelDirection
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConnectorEndRule());
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
				newLeafNode(otherlv_2, grammarAccess.getConnectorEndAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getConnectorEndAccess().getProtocolComPointProtocolParserRuleCall_2_1_0());
					}
					lv_protocol_3_0=ruleComPointProtocol
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConnectorEndRule());
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
				newLeafNode(otherlv_4, grammarAccess.getConnectorEndAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getConnectorEndAccess().getPointsComPointParserRuleCall_3_0_0_0());
						}
						lv_points_5_0=ruleComPoint
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getConnectorEndRule());
							}
							add(
								$current,
								"points",
								lv_points_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ComPoint");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_6=';'
				{
					newLeafNode(otherlv_6, grammarAccess.getConnectorEndAccess().getSemicolonKeyword_3_0_1());
				}
			)
			    |
			(
				otherlv_7='['
				{
					newLeafNode(otherlv_7, grammarAccess.getConnectorEndAccess().getLeftSquareBracketKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getConnectorEndAccess().getPointsComPointParserRuleCall_3_1_1_0());
						}
						lv_points_8_0=ruleComPoint
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getConnectorEndRule());
							}
							add(
								$current,
								"points",
								lv_points_8_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ComPoint");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_9=','
					{
						newLeafNode(otherlv_9, grammarAccess.getConnectorEndAccess().getCommaKeyword_3_1_2_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getConnectorEndAccess().getPointsComPointParserRuleCall_3_1_2_1_0());
							}
							lv_points_10_0=ruleComPoint
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getConnectorEndRule());
								}
								add(
									$current,
									"points",
									lv_points_10_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ComPoint");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_11=']'
				{
					newLeafNode(otherlv_11, grammarAccess.getConnectorEndAccess().getRightSquareBracketKeyword_3_1_3());
				}
				otherlv_12=';'
				{
					newLeafNode(otherlv_12, grammarAccess.getConnectorEndAccess().getSemicolonKeyword_3_1_4());
				}
			)
			    |
			(
				otherlv_13='{'
				{
					newLeafNode(otherlv_13, grammarAccess.getConnectorEndAccess().getLeftCurlyBracketKeyword_3_2_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getConnectorEndAccess().getPointsComPointParserRuleCall_3_2_1_0_0());
							}
							lv_points_14_0=ruleComPoint
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getConnectorEndRule());
								}
								add(
									$current,
									"points",
									lv_points_14_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ComPoint");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_15=';'
					{
						newLeafNode(otherlv_15, grammarAccess.getConnectorEndAccess().getSemicolonKeyword_3_2_1_1());
					}
				)+
				otherlv_16='}'
				{
					newLeafNode(otherlv_16, grammarAccess.getConnectorEndAccess().getRightCurlyBracketKeyword_3_2_2());
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
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getComPointRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getComPointAccess().getMachineNamedElementCrossReference_1_0_0());
					}
					ruleESIdentifier
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2='->'
				{
					newLeafNode(otherlv_2, grammarAccess.getComPointAccess().getHyphenMinusGreaterThanSignKeyword_1_1_0());
				}
				    |
				otherlv_3='.'
				{
					newLeafNode(otherlv_3, grammarAccess.getComPointAccess().getFullStopKeyword_1_1_1());
				}
			)
		)?
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComPointRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getComPointAccess().getPortPortCrossReference_2_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
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
					newCompositeNode(grammarAccess.getComPointProtocolAccess().getBufferRefComBufferRefParserRuleCall_2_0());
				}
				lv_bufferRef_9_0=ruleComBufferRef
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComPointProtocolRule());
					}
					set(
						$current,
						"bufferRef",
						lv_bufferRef_9_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ComBufferRef");
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

// Entry rule entryRuleComBufferRef
entryRuleComBufferRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComBufferRefRule()); }
	iv_ruleComBufferRef=ruleComBufferRef
	{ $current=$iv_ruleComBufferRef.current; }
	EOF;

// Rule ComBufferRef
ruleComBufferRef returns [EObject current=null]
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
					grammarAccess.getComBufferRefAccess().getLiteralReferenceSpecificationAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getComBufferRefAccess().getParentLiteralReferenceExpressionParserRuleCall_1_0_0());
					}
					lv_parent_1_0=ruleLiteralReferenceExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComBufferRefRule());
						}
						add(
							$current,
							"parent",
							lv_parent_1_0,
							"org.eclipse.efm.formalml.xtext.FormalML.LiteralReferenceExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2='.'
				{
					newLeafNode(otherlv_2, grammarAccess.getComBufferRefAccess().getFullStopKeyword_1_1_0());
				}
				    |
				otherlv_3='->'
				{
					newLeafNode(otherlv_3, grammarAccess.getComBufferRefAccess().getHyphenMinusGreaterThanSignKeyword_1_1_1());
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getComBufferRefAccess().getElementBufferReferenceElementParserRuleCall_2_0());
				}
				lv_element_4_0=ruleBufferReferenceElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComBufferRefRule());
					}
					set(
						$current,
						"element",
						lv_element_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.BufferReferenceElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBufferReferenceElement
entryRuleBufferReferenceElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBufferReferenceElementRule()); }
	iv_ruleBufferReferenceElement=ruleBufferReferenceElement
	{ $current=$iv_ruleBufferReferenceElement.current; }
	EOF;

// Rule BufferReferenceElement
ruleBufferReferenceElement returns [EObject current=null]
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
					grammarAccess.getBufferReferenceElementAccess().getLiteralReferenceElementAction_0(),
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
						$current = createModelElement(grammarAccess.getBufferReferenceElementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getBufferReferenceElementAccess().getElementBufferCrossReference_1_0());
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
						newCompositeNode(grammarAccess.getLiteralPureReferenceMachineAccess().getElementMachineCrossReference_0_1_0());
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
		(
			(
				lv_typedef_2_0='type'
				{
					newLeafNode(lv_typedef_2_0, grammarAccess.getOtherDataTypeDefinitionAccess().getTypedefTypeKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOtherDataTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "type");
				}
			)
		)
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
				(
					{
						newCompositeNode(grammarAccess.getOtherDataTypeDefinitionAccess().getConstraintTypeConstraintRoutineParserRuleCall_6_0_0());
					}
					lv_constraint_13_0=ruleTypeConstraintRoutine
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOtherDataTypeDefinitionRule());
						}
						set(
							$current,
							"constraint",
							lv_constraint_13_0,
							"org.eclipse.efm.formalml.xtext.FormalML.TypeConstraintRoutine");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			otherlv_14=';'
			{
				newLeafNode(otherlv_14, grammarAccess.getOtherDataTypeDefinitionAccess().getSemicolonKeyword_6_1());
			}
		)
	)
;

// Entry rule entryRuleTypeConstraintRoutine
entryRuleTypeConstraintRoutine returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeConstraintRoutineRule()); }
	iv_ruleTypeConstraintRoutine=ruleTypeConstraintRoutine
	{ $current=$iv_ruleTypeConstraintRoutine.current; }
	EOF;

// Rule TypeConstraintRoutine
ruleTypeConstraintRoutine returns [EObject current=null]
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
					grammarAccess.getTypeConstraintRoutineAccess().getRoutineAction_0(),
					$current);
			}
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getTypeConstraintRoutineAccess().getLeftCurlyBracketKeyword_1());
		}
		otherlv_2='@constraint'
		{
			newLeafNode(otherlv_2, grammarAccess.getTypeConstraintRoutineAccess().getConstraintKeyword_2());
		}
		(
			otherlv_3='('
			{
				newLeafNode(otherlv_3, grammarAccess.getTypeConstraintRoutineAccess().getLeftParenthesisKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTypeConstraintRoutineAccess().getParameterSetVariableRoutineParameterSetParserRuleCall_3_1_0());
					}
					lv_parameterSet_4_0=ruleVariableRoutineParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTypeConstraintRoutineRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_4_0,
							"org.eclipse.efm.formalml.xtext.FormalML.VariableRoutineParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5=')'
			{
				newLeafNode(otherlv_5, grammarAccess.getTypeConstraintRoutineAccess().getRightParenthesisKeyword_3_2());
			}
		)?
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTypeConstraintRoutineAccess().getBodyBlockBlockStatementParserRuleCall_4_0_0());
					}
					lv_bodyBlock_6_0=ruleBlockStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTypeConstraintRoutineRule());
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
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeConstraintRoutineAccess().getBodyBlockConditionalBlockStatementParserRuleCall_4_1_0_0());
						}
						lv_bodyBlock_7_0=ruleConditionalBlockStatement
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeConstraintRoutineRule());
							}
							set(
								$current,
								"bodyBlock",
								lv_bodyBlock_7_0,
								"org.eclipse.efm.formalml.xtext.FormalML.ConditionalBlockStatement");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_8=';'
				{
					newLeafNode(otherlv_8, grammarAccess.getTypeConstraintRoutineAccess().getSemicolonKeyword_4_1_1());
				}
			)
		)
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getTypeConstraintRoutineAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleConditionalBlockStatement
entryRuleConditionalBlockStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionalBlockStatementRule()); }
	iv_ruleConditionalBlockStatement=ruleConditionalBlockStatement
	{ $current=$iv_ruleConditionalBlockStatement.current; }
	EOF;

// Rule ConditionalBlockStatement
ruleConditionalBlockStatement returns [EObject current=null]
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
					grammarAccess.getConditionalBlockStatementAccess().getBlockStatementAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getConditionalBlockStatementAccess().getStatementGuardTestExpressionParserRuleCall_1_0());
				}
				lv_statement_1_0=ruleGuardTestExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConditionalBlockStatementRule());
					}
					add(
						$current,
						"statement",
						lv_statement_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.GuardTestExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleGuardTestExpression
entryRuleGuardTestExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGuardTestExpressionRule()); }
	iv_ruleGuardTestExpression=ruleGuardTestExpression
	{ $current=$iv_ruleGuardTestExpression.current; }
	EOF;

// Rule GuardTestExpression
ruleGuardTestExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='|=>'
		{
			newLeafNode(otherlv_0, grammarAccess.getGuardTestExpressionAccess().getVerticalLineEqualsSignGreaterThanSignKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getGuardTestExpressionAccess().getConditionExpressionParserRuleCall_1_0());
				}
				lv_condition_1_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGuardTestExpressionRule());
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
			(
				(
					lv_name_2_1='integer'
					{
						newLeafNode(lv_name_2_1, grammarAccess.getPrimitiveIntegerTypeAccess().getNameIntegerKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveIntegerTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_1, null);
					}
					    |
					lv_name_2_2='uinteger'
					{
						newLeafNode(lv_name_2_2, grammarAccess.getPrimitiveIntegerTypeAccess().getNameUintegerKeyword_2_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveIntegerTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_2, null);
					}
					    |
					lv_name_2_3='pos_integer'
					{
						newLeafNode(lv_name_2_3, grammarAccess.getPrimitiveIntegerTypeAccess().getNamePos_integerKeyword_2_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveIntegerTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_3, null);
					}
					    |
					lv_name_2_4='int'
					{
						newLeafNode(lv_name_2_4, grammarAccess.getPrimitiveIntegerTypeAccess().getNameIntKeyword_2_0_3());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveIntegerTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_4, null);
					}
					    |
					lv_name_2_5='uint'
					{
						newLeafNode(lv_name_2_5, grammarAccess.getPrimitiveIntegerTypeAccess().getNameUintKeyword_2_0_4());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveIntegerTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_5, null);
					}
				)
			)
		)
		(
			(
				otherlv_3=':'
				{
					newLeafNode(otherlv_3, grammarAccess.getPrimitiveIntegerTypeAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveIntegerTypeAccess().getSizeEIntParserRuleCall_3_0_1_0());
						}
						lv_size_4_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveIntegerTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_5='<'
				{
					newLeafNode(otherlv_5, grammarAccess.getPrimitiveIntegerTypeAccess().getLessThanSignKeyword_3_1_0());
				}
				(
					otherlv_6='size:'
					{
						newLeafNode(otherlv_6, grammarAccess.getPrimitiveIntegerTypeAccess().getSizeKeyword_3_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveIntegerTypeAccess().getSizeEIntParserRuleCall_3_1_2_0());
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
				otherlv_8='>'
				{
					newLeafNode(otherlv_8, grammarAccess.getPrimitiveIntegerTypeAccess().getGreaterThanSignKeyword_3_1_3());
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
			(
				(
					lv_name_2_1='rational'
					{
						newLeafNode(lv_name_2_1, grammarAccess.getPrimitiveRationalTypeAccess().getNameRationalKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveRationalTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_1, null);
					}
					    |
					lv_name_2_2='urational'
					{
						newLeafNode(lv_name_2_2, grammarAccess.getPrimitiveRationalTypeAccess().getNameUrationalKeyword_2_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveRationalTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_2, null);
					}
					    |
					lv_name_2_3='pos_rational'
					{
						newLeafNode(lv_name_2_3, grammarAccess.getPrimitiveRationalTypeAccess().getNamePos_rationalKeyword_2_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveRationalTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_3, null);
					}
					    |
					lv_name_2_4='rat'
					{
						newLeafNode(lv_name_2_4, grammarAccess.getPrimitiveRationalTypeAccess().getNameRatKeyword_2_0_3());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveRationalTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_4, null);
					}
					    |
					lv_name_2_5='urat'
					{
						newLeafNode(lv_name_2_5, grammarAccess.getPrimitiveRationalTypeAccess().getNameUratKeyword_2_0_4());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveRationalTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_5, null);
					}
				)
			)
		)
		(
			(
				otherlv_3=':'
				{
					newLeafNode(otherlv_3, grammarAccess.getPrimitiveRationalTypeAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveRationalTypeAccess().getSizeEIntParserRuleCall_3_0_1_0());
						}
						lv_size_4_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveRationalTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_5='<'
				{
					newLeafNode(otherlv_5, grammarAccess.getPrimitiveRationalTypeAccess().getLessThanSignKeyword_3_1_0());
				}
				(
					otherlv_6='size:'
					{
						newLeafNode(otherlv_6, grammarAccess.getPrimitiveRationalTypeAccess().getSizeKeyword_3_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveRationalTypeAccess().getSizeEIntParserRuleCall_3_1_2_0());
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
				otherlv_8='>'
				{
					newLeafNode(otherlv_8, grammarAccess.getPrimitiveRationalTypeAccess().getGreaterThanSignKeyword_3_1_3());
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
			(
				(
					lv_name_2_1='float'
					{
						newLeafNode(lv_name_2_1, grammarAccess.getPrimitiveFloatTypeAccess().getNameFloatKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveFloatTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_1, null);
					}
					    |
					lv_name_2_2='ufloat'
					{
						newLeafNode(lv_name_2_2, grammarAccess.getPrimitiveFloatTypeAccess().getNameUfloatKeyword_2_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveFloatTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_2, null);
					}
					    |
					lv_name_2_3='pos_float'
					{
						newLeafNode(lv_name_2_3, grammarAccess.getPrimitiveFloatTypeAccess().getNamePos_floatKeyword_2_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveFloatTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_3, null);
					}
					    |
					lv_name_2_4='double'
					{
						newLeafNode(lv_name_2_4, grammarAccess.getPrimitiveFloatTypeAccess().getNameDoubleKeyword_2_0_3());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveFloatTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_4, null);
					}
					    |
					lv_name_2_5='udouble'
					{
						newLeafNode(lv_name_2_5, grammarAccess.getPrimitiveFloatTypeAccess().getNameUdoubleKeyword_2_0_4());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveFloatTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_5, null);
					}
				)
			)
		)
		(
			(
				otherlv_3=':'
				{
					newLeafNode(otherlv_3, grammarAccess.getPrimitiveFloatTypeAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveFloatTypeAccess().getSizeEIntParserRuleCall_3_0_1_0());
						}
						lv_size_4_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveFloatTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_5='<'
				{
					newLeafNode(otherlv_5, grammarAccess.getPrimitiveFloatTypeAccess().getLessThanSignKeyword_3_1_0());
				}
				(
					otherlv_6='size:'
					{
						newLeafNode(otherlv_6, grammarAccess.getPrimitiveFloatTypeAccess().getSizeKeyword_3_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveFloatTypeAccess().getSizeEIntParserRuleCall_3_1_2_0());
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
				otherlv_8='>'
				{
					newLeafNode(otherlv_8, grammarAccess.getPrimitiveFloatTypeAccess().getGreaterThanSignKeyword_3_1_3());
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
			(
				(
					lv_name_2_1='real'
					{
						newLeafNode(lv_name_2_1, grammarAccess.getPrimitiveRealTypeAccess().getNameRealKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveRealTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_1, null);
					}
					    |
					lv_name_2_2='ureal'
					{
						newLeafNode(lv_name_2_2, grammarAccess.getPrimitiveRealTypeAccess().getNameUrealKeyword_2_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveRealTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_2, null);
					}
					    |
					lv_name_2_3='pos_real'
					{
						newLeafNode(lv_name_2_3, grammarAccess.getPrimitiveRealTypeAccess().getNamePos_realKeyword_2_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveRealTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_2_3, null);
					}
				)
			)
		)
		(
			(
				otherlv_3=':'
				{
					newLeafNode(otherlv_3, grammarAccess.getPrimitiveRealTypeAccess().getColonKeyword_3_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveRealTypeAccess().getSizeEIntParserRuleCall_3_0_1_0());
						}
						lv_size_4_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveRealTypeRule());
							}
							set(
								$current,
								"size",
								lv_size_4_0,
								"org.eclipse.efm.formalml.xtext.FormalML.EInt");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_5='<'
				{
					newLeafNode(otherlv_5, grammarAccess.getPrimitiveRealTypeAccess().getLessThanSignKeyword_3_1_0());
				}
				(
					otherlv_6='size:'
					{
						newLeafNode(otherlv_6, grammarAccess.getPrimitiveRealTypeAccess().getSizeKeyword_3_1_1());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimitiveRealTypeAccess().getSizeEIntParserRuleCall_3_1_2_0());
						}
						lv_size_7_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimitiveRealTypeRule());
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
				otherlv_8='>'
				{
					newLeafNode(otherlv_8, grammarAccess.getPrimitiveRealTypeAccess().getGreaterThanSignKeyword_3_1_3());
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
			(
				(
					lv_name_1_1='boolean'
					{
						newLeafNode(lv_name_1_1, grammarAccess.getPrimitiveBooleanTypeAccess().getNameBooleanKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveBooleanTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_1, null);
					}
					    |
					lv_name_1_2='bool'
					{
						newLeafNode(lv_name_1_2, grammarAccess.getPrimitiveBooleanTypeAccess().getNameBoolKeyword_1_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPrimitiveBooleanTypeRule());
						}
						setWithLastConsumed($current, "name", lv_name_1_2, null);
					}
				)
			)
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
		(
			(
				lv_name_1_0='string'
				{
					newLeafNode(lv_name_1_0, grammarAccess.getPrimitiveStringTypeAccess().getNameStringKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPrimitiveStringTypeRule());
					}
					setWithLastConsumed($current, "name", lv_name_1_0, "string");
				}
			)
		)
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
		(
			(
				lv_name_1_0='interval'
				{
					newLeafNode(lv_name_1_0, grammarAccess.getIntervalTypeAccess().getNameIntervalKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIntervalTypeRule());
					}
					setWithLastConsumed($current, "name", lv_name_1_0, "interval");
				}
			)
		)
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
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getEnumerationTypeAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_3='super:'
				{
					newLeafNode(otherlv_3, grammarAccess.getEnumerationTypeAccess().getSuperKeyword_2_1());
				}
			)?
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEnumerationTypeRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEnumerationTypeAccess().getSuperTypeEnumerationTypeCrossReference_2_2_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5='>'
			{
				newLeafNode(otherlv_5, grammarAccess.getEnumerationTypeAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getEnumerationTypeAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralEnumerationLiteralParserRuleCall_4_0());
				}
				lv_literal_7_0=ruleEnumerationLiteral
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
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
				newLeafNode(otherlv_8, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralEnumerationLiteralParserRuleCall_5_1_0());
					}
					lv_literal_9_0=ruleEnumerationLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
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
			newLeafNode(otherlv_10, grammarAccess.getEnumerationTypeAccess().getRightCurlyBracketKeyword_6());
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
		(
			(
				lv_typedef_2_0='type'
				{
					newLeafNode(lv_typedef_2_0, grammarAccess.getEnumerationTypeDefinitionAccess().getTypedefTypeKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEnumerationTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "type");
				}
			)
		)
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
		otherlv_5='enum'
		{
			newLeafNode(otherlv_5, grammarAccess.getEnumerationTypeDefinitionAccess().getEnumKeyword_5());
		}
		(
			otherlv_6='<'
			{
				newLeafNode(otherlv_6, grammarAccess.getEnumerationTypeDefinitionAccess().getLessThanSignKeyword_6_0());
			}
			(
				otherlv_7='super:'
				{
					newLeafNode(otherlv_7, grammarAccess.getEnumerationTypeDefinitionAccess().getSuperKeyword_6_1());
				}
			)?
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEnumerationTypeDefinitionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEnumerationTypeDefinitionAccess().getSuperTypeEnumerationTypeCrossReference_6_2_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_9='>'
			{
				newLeafNode(otherlv_9, grammarAccess.getEnumerationTypeDefinitionAccess().getGreaterThanSignKeyword_6_3());
			}
		)?
		otherlv_10='{'
		{
			newLeafNode(otherlv_10, grammarAccess.getEnumerationTypeDefinitionAccess().getLeftCurlyBracketKeyword_7());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationTypeDefinitionAccess().getLiteralEnumerationLiteralParserRuleCall_8_0());
				}
				lv_literal_11_0=ruleEnumerationLiteral
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionRule());
					}
					add(
						$current,
						"literal",
						lv_literal_11_0,
						"org.eclipse.efm.formalml.xtext.FormalML.EnumerationLiteral");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_12=','
			{
				newLeafNode(otherlv_12, grammarAccess.getEnumerationTypeDefinitionAccess().getCommaKeyword_9_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumerationTypeDefinitionAccess().getLiteralEnumerationLiteralParserRuleCall_9_1_0());
					}
					lv_literal_13_0=ruleEnumerationLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumerationTypeDefinitionRule());
						}
						add(
							$current,
							"literal",
							lv_literal_13_0,
							"org.eclipse.efm.formalml.xtext.FormalML.EnumerationLiteral");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_14='}'
		{
			newLeafNode(otherlv_14, grammarAccess.getEnumerationTypeDefinitionAccess().getRightCurlyBracketKeyword_10());
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
			otherlv_3='@property:'
			{
				newLeafNode(otherlv_3, grammarAccess.getStructureTypeAccess().getPropertyKeyword_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeAccess().getPropertyVariableParserRuleCall_4_0());
				}
				lv_property_4_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeRule());
					}
					add(
						$current,
						"property",
						lv_property_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getStructureTypeAccess().getRightCurlyBracketKeyword_5());
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
		(
			(
				lv_typedef_2_0='type'
				{
					newLeafNode(lv_typedef_2_0, grammarAccess.getStructureTypeDefinitionAccess().getTypedefTypeKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructureTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "type");
				}
			)
		)
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
		otherlv_5='struct'
		{
			newLeafNode(otherlv_5, grammarAccess.getStructureTypeDefinitionAccess().getStructKeyword_5());
		}
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getStructureTypeDefinitionAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			otherlv_7='@property:'
			{
				newLeafNode(otherlv_7, grammarAccess.getStructureTypeDefinitionAccess().getPropertyKeyword_7());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureTypeDefinitionAccess().getPropertyVariableParserRuleCall_8_0());
				}
				lv_property_8_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureTypeDefinitionRule());
					}
					add(
						$current,
						"property",
						lv_property_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getStructureTypeDefinitionAccess().getRightCurlyBracketKeyword_9());
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
			otherlv_3='@property:'
			{
				newLeafNode(otherlv_3, grammarAccess.getUnionTypeAccess().getPropertyKeyword_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeAccess().getPropertyVariableParserRuleCall_4_0());
				}
				lv_property_4_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeRule());
					}
					add(
						$current,
						"property",
						lv_property_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_5());
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
		(
			(
				lv_typedef_2_0='type'
				{
					newLeafNode(lv_typedef_2_0, grammarAccess.getUnionTypeDefinitionAccess().getTypedefTypeKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnionTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "type");
				}
			)
		)
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
		otherlv_5='union'
		{
			newLeafNode(otherlv_5, grammarAccess.getUnionTypeDefinitionAccess().getUnionKeyword_5());
		}
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getUnionTypeDefinitionAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			otherlv_7='@property:'
			{
				newLeafNode(otherlv_7, grammarAccess.getUnionTypeDefinitionAccess().getPropertyKeyword_7());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionTypeDefinitionAccess().getPropertyVariableParserRuleCall_8_0());
				}
				lv_property_8_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionTypeDefinitionRule());
					}
					add(
						$current,
						"property",
						lv_property_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getUnionTypeDefinitionAccess().getRightCurlyBracketKeyword_9());
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
			otherlv_3='@property:'
			{
				newLeafNode(otherlv_3, grammarAccess.getChoiceTypeAccess().getPropertyKeyword_3());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeAccess().getPropertyVariableParserRuleCall_4_0());
				}
				lv_property_4_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeRule());
					}
					add(
						$current,
						"property",
						lv_property_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getChoiceTypeAccess().getRightCurlyBracketKeyword_5());
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
		(
			(
				lv_typedef_2_0='type'
				{
					newLeafNode(lv_typedef_2_0, grammarAccess.getChoiceTypeDefinitionAccess().getTypedefTypeKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getChoiceTypeDefinitionRule());
					}
					setWithLastConsumed($current, "typedef", true, "type");
				}
			)
		)
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
		otherlv_5='choice'
		{
			newLeafNode(otherlv_5, grammarAccess.getChoiceTypeDefinitionAccess().getChoiceKeyword_5());
		}
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getChoiceTypeDefinitionAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			otherlv_7='@property:'
			{
				newLeafNode(otherlv_7, grammarAccess.getChoiceTypeDefinitionAccess().getPropertyKeyword_7());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getChoiceTypeDefinitionAccess().getPropertyVariableParserRuleCall_8_0());
				}
				lv_property_8_0=ruleVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChoiceTypeDefinitionRule());
					}
					add(
						$current,
						"property",
						lv_property_8_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Variable");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getChoiceTypeDefinitionAccess().getRightCurlyBracketKeyword_9());
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
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getModifierAccess().getUnorderedGroup_1(), 4);
					}
								({true}?=>((
									lv_optional_6_0='optional'
									{
										newLeafNode(lv_optional_6_0, grammarAccess.getModifierAccess().getOptionalOptionalKeyword_1_4_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getModifierRule());
										}
										setWithLastConsumed($current, "optional", true, "optional");
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
						newCompositeNode(grammarAccess.getFunctionAccess().getParameterSetFormalParameterSetParserRuleCall_5_1_0());
					}
					lv_parameterSet_8_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFunctionRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_8_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_9=')'
			{
				newLeafNode(otherlv_9, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5_2());
			}
		)?
		otherlv_10='->'
		{
			newLeafNode(otherlv_10, grammarAccess.getFunctionAccess().getHyphenMinusGreaterThanSignKeyword_6());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getFunctionAccess().getResultSetFormalParameterSetParserRuleCall_7_0_0());
					}
					lv_resultSet_11_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFunctionRule());
						}
						set(
							$current,
							"resultSet",
							lv_resultSet_11_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				otherlv_12='('
				{
					newLeafNode(otherlv_12, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_7_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getFunctionAccess().getResultSetFormalParameterSetParserRuleCall_7_1_1_0());
						}
						lv_resultSet_13_0=ruleFormalParameterSet
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunctionRule());
							}
							set(
								$current,
								"resultSet",
								lv_resultSet_13_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_14=')'
				{
					newLeafNode(otherlv_14, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_7_1_2());
				}
			)
		)
		otherlv_15=';'
		{
			newLeafNode(otherlv_15, grammarAccess.getFunctionAccess().getSemicolonKeyword_8());
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
						newCompositeNode(grammarAccess.getFunctionImplAccess().getParameterSetFormalParameterSetParserRuleCall_5_1_0());
					}
					lv_parameterSet_6_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_6_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_7=')'
			{
				newLeafNode(otherlv_7, grammarAccess.getFunctionImplAccess().getRightParenthesisKeyword_5_2());
			}
		)?
		otherlv_8='->'
		{
			newLeafNode(otherlv_8, grammarAccess.getFunctionImplAccess().getHyphenMinusGreaterThanSignKeyword_6());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getFunctionImplAccess().getResultSetFormalParameterSetParserRuleCall_7_0_0());
					}
					lv_resultSet_9_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
						}
						set(
							$current,
							"resultSet",
							lv_resultSet_9_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				otherlv_10='('
				{
					newLeafNode(otherlv_10, grammarAccess.getFunctionImplAccess().getLeftParenthesisKeyword_7_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getFunctionImplAccess().getResultSetFormalParameterSetParserRuleCall_7_1_1_0());
						}
						lv_resultSet_11_0=ruleFormalParameterSet
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunctionImplRule());
							}
							set(
								$current,
								"resultSet",
								lv_resultSet_11_0,
								"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_12=')'
				{
					newLeafNode(otherlv_12, grammarAccess.getFunctionImplAccess().getRightParenthesisKeyword_7_1_2());
				}
			)
		)
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getFunctionImplAccess().getSemicolonKeyword_8());
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
		(
			otherlv_1='@write'
			{
				newLeafNode(otherlv_1, grammarAccess.getOnWriteRoutineAccess().getWriteKeyword_1_0());
			}
			    |
			otherlv_2='@on_write'
			{
				newLeafNode(otherlv_2, grammarAccess.getOnWriteRoutineAccess().getOn_writeKeyword_1_1());
			}
		)
		(
			otherlv_3='('
			{
				newLeafNode(otherlv_3, grammarAccess.getOnWriteRoutineAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOnWriteRoutineAccess().getParameterSetVariableRoutineParameterSetParserRuleCall_2_1_0());
					}
					lv_parameterSet_4_0=ruleVariableRoutineParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOnWriteRoutineRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_4_0,
							"org.eclipse.efm.formalml.xtext.FormalML.VariableRoutineParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5=')'
			{
				newLeafNode(otherlv_5, grammarAccess.getOnWriteRoutineAccess().getRightParenthesisKeyword_2_2());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getOnWriteRoutineAccess().getBodyBlockBlockStatementParserRuleCall_3_0());
				}
				lv_bodyBlock_6_0=ruleBlockStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOnWriteRoutineRule());
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
;

// Entry rule entryRuleVariableRoutineParameterSet
entryRuleVariableRoutineParameterSet returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableRoutineParameterSetRule()); }
	iv_ruleVariableRoutineParameterSet=ruleVariableRoutineParameterSet
	{ $current=$iv_ruleVariableRoutineParameterSet.current; }
	EOF;

// Rule VariableRoutineParameterSet
ruleVariableRoutineParameterSet returns [EObject current=null]
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
					grammarAccess.getVariableRoutineParameterSetAccess().getParameterSetAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableRoutineParameterSetAccess().getParameterVariableRoutineParameterParserRuleCall_1_0());
				}
				lv_parameter_1_0=ruleVariableRoutineParameter
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRoutineParameterSetRule());
					}
					add(
						$current,
						"parameter",
						lv_parameter_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.VariableRoutineParameter");
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
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getVariableRoutineParameterAccess().getFormalParameterOffsetParserRuleCall_0());
			}
			ruleFormalParameterOffset
			{
				afterParserOrEnumRuleCall();
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableRoutineParameterAccess().getDirectionParameterDirectionKindEnumRuleCall_1_0());
				}
				lv_direction_1_0=ruleParameterDirectionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRoutineParameterRule());
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
					newCompositeNode(grammarAccess.getVariableRoutineParameterAccess().getTypeDataTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRoutineParameterRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getVariableRoutineParameterAccess().getNameESIdentifierParserRuleCall_3_0());
				}
				lv_name_3_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVariableRoutineParameterRule());
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
				newLeafNode(otherlv_4, grammarAccess.getVariableRoutineParameterAccess().getEqualsSignKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getVariableRoutineParameterAccess().getDefaultValueExpressionParserRuleCall_4_1_0());
					}
					lv_defaultValue_5_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getVariableRoutineParameterRule());
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
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getFormalParameterAccess().getFormalParameterOffsetParserRuleCall_1());
			}
			ruleFormalParameterOffset
			{
				afterParserOrEnumRuleCall();
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getFormalParameterAccess().getDirectionParameterDirectionKindEnumRuleCall_2_0());
				}
				lv_direction_2_0=ruleParameterDirectionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
					}
					set(
						$current,
						"direction",
						lv_direction_2_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ParameterDirectionKind");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getFormalParameterAccess().getModifierModifierParserRuleCall_3_0());
				}
				lv_modifier_3_0=ruleModifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
					}
					set(
						$current,
						"modifier",
						lv_modifier_3_0,
						"org.eclipse.efm.formalml.xtext.FormalML.Modifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getFormalParameterAccess().getTypeDataTypeParserRuleCall_4_0());
				}
				lv_type_4_0=ruleDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
					}
					set(
						$current,
						"type",
						lv_type_4_0,
						"org.eclipse.efm.formalml.xtext.FormalML.DataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getFormalParameterAccess().getNameESIdentifierParserRuleCall_5_0());
				}
				lv_name_5_0=ruleESIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ESIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_6='='
			{
				newLeafNode(otherlv_6, grammarAccess.getFormalParameterAccess().getEqualsSignKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFormalParameterAccess().getDefaultValueExpressionParserRuleCall_6_1_0());
					}
					lv_defaultValue_7_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFormalParameterRule());
						}
						set(
							$current,
							"defaultValue",
							lv_defaultValue_7_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleFormalParameterOffset
entryRuleFormalParameterOffset returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFormalParameterOffsetRule()); }
	iv_ruleFormalParameterOffset=ruleFormalParameterOffset
	{ $current=$iv_ruleFormalParameterOffset.current.getText(); }
	EOF;

// Rule FormalParameterOffset
ruleFormalParameterOffset returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getFormalParameterOffsetAccess().getEOffsetParserRuleCall());
	}
	this_EOffset_0=ruleEOffset
	{
		$current.merge(this_EOffset_0);
	}
	{
		afterParserOrEnumRuleCall();
	}
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
							otherlv_3='size:'
							{
								newLeafNode(otherlv_3, grammarAccess.getBufferContainerTypeAccess().getSizeKeyword_2_0_1_0_0());
							}
						)?
						(
							(
								{
									newCompositeNode(grammarAccess.getBufferContainerTypeAccess().getSizeEIntParserRuleCall_2_0_1_0_1_0());
								}
								lv_size_4_0=ruleEInt
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getBufferContainerTypeRule());
									}
									set(
										$current,
										"size",
										lv_size_4_0,
										"org.eclipse.efm.formalml.xtext.FormalML.EInt");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
					    |
					(
						(
							lv_unbounded_5_0='*'
							{
								newLeafNode(lv_unbounded_5_0, grammarAccess.getBufferContainerTypeAccess().getUnboundedAsteriskKeyword_2_0_1_1_0());
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
				otherlv_6='>'
				{
					newLeafNode(otherlv_6, grammarAccess.getBufferContainerTypeAccess().getGreaterThanSignKeyword_2_0_2());
				}
			)
			    |
			(
				otherlv_7='['
				{
					newLeafNode(otherlv_7, grammarAccess.getBufferContainerTypeAccess().getLeftSquareBracketKeyword_2_1_0());
				}
				(
					(
						(
							otherlv_8='size:'
							{
								newLeafNode(otherlv_8, grammarAccess.getBufferContainerTypeAccess().getSizeKeyword_2_1_1_0_0());
							}
						)?
						(
							(
								{
									newCompositeNode(grammarAccess.getBufferContainerTypeAccess().getSizeEIntParserRuleCall_2_1_1_0_1_0());
								}
								lv_size_9_0=ruleEInt
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getBufferContainerTypeRule());
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
					)
					    |
					(
						(
							lv_unbounded_10_0='*'
							{
								newLeafNode(lv_unbounded_10_0, grammarAccess.getBufferContainerTypeAccess().getUnboundedAsteriskKeyword_2_1_1_1_0());
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
				otherlv_11=']'
				{
					newLeafNode(otherlv_11, grammarAccess.getBufferContainerTypeAccess().getRightSquareBracketKeyword_2_1_2());
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
						newCompositeNode(grammarAccess.getPortAccess().getParameterSetFormalParameterSetParserRuleCall_5_1_0());
					}
					lv_parameterSet_11_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPortRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_11_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_12=')'
			{
				newLeafNode(otherlv_12, grammarAccess.getPortAccess().getRightParenthesisKeyword_5_2());
			}
		)?
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getPortAccess().getSemicolonKeyword_6());
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
						newCompositeNode(grammarAccess.getPortImplAccess().getParameterSetFormalParameterSetParserRuleCall_5_1_0());
					}
					lv_parameterSet_9_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPortImplRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_9_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_10=')'
			{
				newLeafNode(otherlv_10, grammarAccess.getPortImplAccess().getRightParenthesisKeyword_5_2());
			}
		)?
		otherlv_11=';'
		{
			newLeafNode(otherlv_11, grammarAccess.getPortImplAccess().getSemicolonKeyword_6());
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
						newCompositeNode(grammarAccess.getSignalAccess().getParameterSetFormalParameterSetParserRuleCall_5_1_0());
					}
					lv_parameterSet_9_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSignalRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_9_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_10=')'
			{
				newLeafNode(otherlv_10, grammarAccess.getSignalAccess().getRightParenthesisKeyword_5_2());
			}
		)?
		otherlv_11=';'
		{
			newLeafNode(otherlv_11, grammarAccess.getSignalAccess().getSemicolonKeyword_6());
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
						newCompositeNode(grammarAccess.getSignalImplAccess().getParameterSetFormalParameterSetParserRuleCall_4_1_0());
					}
					lv_parameterSet_8_0=ruleFormalParameterSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSignalImplRule());
						}
						set(
							$current,
							"parameterSet",
							lv_parameterSet_8_0,
							"org.eclipse.efm.formalml.xtext.FormalML.FormalParameterSet");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_9=')'
			{
				newLeafNode(otherlv_9, grammarAccess.getSignalImplAccess().getRightParenthesisKeyword_4_2());
			}
		)?
		otherlv_10=';'
		{
			newLeafNode(otherlv_10, grammarAccess.getSignalImplAccess().getSemicolonKeyword_5());
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
				{
					newCompositeNode(grammarAccess.getTransitionAccess().getNameESIdentifierParserRuleCall_4_0());
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
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionAccess().getUnrestrictedNameUnrestrictedNameParserRuleCall_5_0());
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
		(
			(
				otherlv_6='{'
				{
					newLeafNode(otherlv_6, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_6_0_0());
				}
				(
					(
						(
							otherlv_7='@trigger:'
							{
								newLeafNode(otherlv_7, grammarAccess.getTransitionAccess().getTriggerKeyword_6_0_1_0_0_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getTransitionAccess().getTriggerTransitionTriggerParserRuleCall_6_0_1_0_0_1_0());
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
										newCompositeNode(grammarAccess.getTransitionAccess().getGuardTransitionGuardParserRuleCall_6_0_1_0_1_0_0());
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
								newLeafNode(otherlv_10, grammarAccess.getTransitionAccess().getGuardKeyword_6_0_1_0_1_1());
							}
						)?
						(
							(
								(
									{
										newCompositeNode(grammarAccess.getTransitionAccess().getTguardTransitionTimedGuardParserRuleCall_6_0_1_0_2_0_0());
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
								newLeafNode(otherlv_12, grammarAccess.getTransitionAccess().getTguardKeyword_6_0_1_0_2_1());
							}
						)?
						otherlv_13='@effect:'
						{
							newLeafNode(otherlv_13, grammarAccess.getTransitionAccess().getEffectKeyword_6_0_1_0_3());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getTransitionAccess().getEffectTransitionEffectParserRuleCall_6_0_1_0_4_0());
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
								newCompositeNode(grammarAccess.getTransitionAccess().getBehaviorTransitionBehaviorParserRuleCall_6_0_1_1_0());
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
					newLeafNode(otherlv_16, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_6_0_2());
				}
				(
					otherlv_17='-->'
					{
						newLeafNode(otherlv_17, grammarAccess.getTransitionAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_6_0_3_0());
					}
					(
						(
							(
								{
									/* */
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getTransitionRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getTransitionAccess().getTargetVertexCrossReference_6_0_3_1_0_0());
								}
								ruleESUfid
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getTransitionAccess().getTargetExpressionValuePureNamedMachineExpressionParserRuleCall_6_0_3_1_1_0());
								}
								lv_targetExpression_19_0=ruleValuePureNamedMachineExpression
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getTransitionRule());
									}
									set(
										$current,
										"targetExpression",
										lv_targetExpression_19_0,
										"org.eclipse.efm.formalml.xtext.FormalML.ValuePureNamedMachineExpression");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
					otherlv_20=';'
					{
						newLeafNode(otherlv_20, grammarAccess.getTransitionAccess().getSemicolonKeyword_6_0_3_2());
					}
				)?
			)
			    |
			(
				otherlv_21='-->'
				{
					newLeafNode(otherlv_21, grammarAccess.getTransitionAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_6_1_0());
				}
				(
					(
						(
							{
								/* */
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getTransitionRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getTransitionAccess().getTargetVertexCrossReference_6_1_1_0_0());
							}
							ruleESUfid
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getTransitionAccess().getTargetExpressionValuePureNamedMachineExpressionParserRuleCall_6_1_1_1_0());
							}
							lv_targetExpression_23_0=ruleValuePureNamedMachineExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTransitionRule());
								}
								set(
									$current,
									"targetExpression",
									lv_targetExpression_23_0,
									"org.eclipse.efm.formalml.xtext.FormalML.ValuePureNamedMachineExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
				(
					(
						otherlv_24='{'
						{
							newLeafNode(otherlv_24, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_6_1_2_0_0());
						}
						(
							(
								(
									otherlv_25='@trigger:'
									{
										newLeafNode(otherlv_25, grammarAccess.getTransitionAccess().getTriggerKeyword_6_1_2_0_1_0_0_0());
									}
									(
										(
											{
												newCompositeNode(grammarAccess.getTransitionAccess().getTriggerTransitionTriggerParserRuleCall_6_1_2_0_1_0_0_1_0());
											}
											lv_trigger_26_0=ruleTransitionTrigger
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getTransitionRule());
												}
												add(
													$current,
													"trigger",
													lv_trigger_26_0,
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
												newCompositeNode(grammarAccess.getTransitionAccess().getGuardTransitionGuardParserRuleCall_6_1_2_0_1_0_1_0_0());
											}
											lv_guard_27_0=ruleTransitionGuard
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getTransitionRule());
												}
												set(
													$current,
													"guard",
													lv_guard_27_0,
													"org.eclipse.efm.formalml.xtext.FormalML.TransitionGuard");
												afterParserOrEnumRuleCall();
											}
										)
									)
									    |
									otherlv_28='@guard:'
									{
										newLeafNode(otherlv_28, grammarAccess.getTransitionAccess().getGuardKeyword_6_1_2_0_1_0_1_1());
									}
								)?
								(
									(
										(
											{
												newCompositeNode(grammarAccess.getTransitionAccess().getTguardTransitionTimedGuardParserRuleCall_6_1_2_0_1_0_2_0_0());
											}
											lv_tguard_29_0=ruleTransitionTimedGuard
											{
												if ($current==null) {
													$current = createModelElementForParent(grammarAccess.getTransitionRule());
												}
												set(
													$current,
													"tguard",
													lv_tguard_29_0,
													"org.eclipse.efm.formalml.xtext.FormalML.TransitionTimedGuard");
												afterParserOrEnumRuleCall();
											}
										)
									)
									    |
									otherlv_30='@tguard:'
									{
										newLeafNode(otherlv_30, grammarAccess.getTransitionAccess().getTguardKeyword_6_1_2_0_1_0_2_1());
									}
								)?
								otherlv_31='@effect:'
								{
									newLeafNode(otherlv_31, grammarAccess.getTransitionAccess().getEffectKeyword_6_1_2_0_1_0_3());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getTransitionAccess().getEffectTransitionEffectParserRuleCall_6_1_2_0_1_0_4_0());
										}
										lv_effect_32_0=ruleTransitionEffect
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getTransitionRule());
											}
											set(
												$current,
												"effect",
												lv_effect_32_0,
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
										newCompositeNode(grammarAccess.getTransitionAccess().getBehaviorTransitionBehaviorParserRuleCall_6_1_2_0_1_1_0());
									}
									lv_behavior_33_0=ruleTransitionBehavior
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getTransitionRule());
										}
										set(
											$current,
											"behavior",
											lv_behavior_33_0,
											"org.eclipse.efm.formalml.xtext.FormalML.TransitionBehavior");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)?
						otherlv_34='}'
						{
							newLeafNode(otherlv_34, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_6_1_2_0_2());
						}
					)
					    |
					otherlv_35=';'
					{
						newLeafNode(otherlv_35, grammarAccess.getTransitionAccess().getSemicolonKeyword_6_1_2_1());
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
								newCompositeNode(grammarAccess.getTransitionMoeAccess().getPriorityEIntParserRuleCall_1_0_2_2_0());
							}
							lv_priority_8_0=ruleEInt
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTransitionMoeRule());
								}
								set(
									$current,
									"priority",
									lv_priority_8_0,
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
							newCompositeNode(grammarAccess.getTransitionMoeAccess().getPriorityEIntParserRuleCall_1_1_1_0());
						}
						lv_priority_10_0=ruleEInt
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTransitionMoeRule());
							}
							set(
								$current,
								"priority",
								lv_priority_10_0,
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
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStatementAccess().getMetaStatementParserRuleCall_16());
		}
		this_MetaStatement_16=ruleMetaStatement
		{
			$current = $this_MetaStatement_16.current;
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
					newCompositeNode(grammarAccess.getInputComStatementAccess().getPortLitteralComElementParserRuleCall_1_0());
				}
				lv_port_1_0=ruleLitteralComElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInputComStatementRule());
					}
					set(
						$current,
						"port",
						lv_port_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.LitteralComElement");
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
											newCompositeNode(grammarAccess.getInputComStatementAccess().getTargetLiteralPureReferenceExpressionParserRuleCall_3_0_1_0());
										}
										lv_target_9_0=ruleLiteralPureReferenceExpression
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getInputComStatementRule());
											}
											set(
												$current,
												"target",
												lv_target_9_0,
												"org.eclipse.efm.formalml.xtext.FormalML.LiteralPureReferenceExpression");
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
					newCompositeNode(grammarAccess.getOutputComStatementAccess().getPortLitteralComElementParserRuleCall_1_0());
				}
				lv_port_1_0=ruleLitteralComElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOutputComStatementRule());
					}
					set(
						$current,
						"port",
						lv_port_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.LitteralComElement");
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
						newCompositeNode(grammarAccess.getOutputComStatementAccess().getRightValueExpressionParserRuleCall_2_1_0());
					}
					lv_rightValue_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOutputComStatementRule());
						}
						add(
							$current,
							"rightValue",
							lv_rightValue_3_0,
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
							newCompositeNode(grammarAccess.getOutputComStatementAccess().getRightValueExpressionParserRuleCall_2_2_1_0());
						}
						lv_rightValue_5_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOutputComStatementRule());
							}
							add(
								$current,
								"rightValue",
								lv_rightValue_5_0,
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
											newCompositeNode(grammarAccess.getOutputComStatementAccess().getTargetLiteralPureReferenceExpressionParserRuleCall_3_0_1_0());
										}
										lv_target_9_0=ruleLiteralPureReferenceExpression
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getOutputComStatementRule());
											}
											set(
												$current,
												"target",
												lv_target_9_0,
												"org.eclipse.efm.formalml.xtext.FormalML.LiteralPureReferenceExpression");
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

// Entry rule entryRuleLitteralComElement
entryRuleLitteralComElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLitteralComElementRule()); }
	iv_ruleLitteralComElement=ruleLitteralComElement
	{ $current=$iv_ruleLitteralComElement.current; }
	EOF;

// Rule LitteralComElement
ruleLitteralComElement returns [EObject current=null]
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
				if ($current==null) {
					$current = createModelElement(grammarAccess.getLitteralComElementRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getLitteralComElementAccess().getElementNamedElementCrossReference_0());
			}
			ruleESIdentifier
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

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

// Entry rule entryRuleObservableStatement
entryRuleObservableStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getObservableStatementRule()); }
	iv_ruleObservableStatement=ruleObservableStatement
	{ $current=$iv_ruleObservableStatement.current; }
	EOF;

// Rule ObservableStatement
ruleObservableStatement returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getObservableStatementAccess().getObsInputComStatementParserRuleCall_0());
		}
		this_ObsInputComStatement_0=ruleObsInputComStatement
		{
			$current = $this_ObsInputComStatement_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getObservableStatementAccess().getObsOutputComStatementParserRuleCall_1());
		}
		this_ObsOutputComStatement_1=ruleObsOutputComStatement
		{
			$current = $this_ObsOutputComStatement_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleObsInputComStatement
entryRuleObsInputComStatement returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3()
	);
}:
	{ newCompositeNode(grammarAccess.getObsInputComStatementRule()); }
	iv_ruleObsInputComStatement=ruleObsInputComStatement
	{ $current=$iv_ruleObsInputComStatement.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule ObsInputComStatement
ruleObsInputComStatement returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3()
	);
}
@after {
	leaveRule();
}:
	(
		otherlv_0='input'
		{
			newLeafNode(otherlv_0, grammarAccess.getObsInputComStatementAccess().getInputKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getObsInputComStatementAccess().getPortObsComElementParserRuleCall_1_0());
				}
				lv_port_1_0=ruleObsComElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getObsInputComStatementRule());
					}
					set(
						$current,
						"port",
						lv_port_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ObsComElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getObsInputComStatementAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getObsInputComStatementAccess().getLeftValueExpressionParserRuleCall_2_1_0());
					}
					lv_leftValue_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getObsInputComStatementRule());
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
					newLeafNode(otherlv_4, grammarAccess.getObsInputComStatementAccess().getCommaKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getObsInputComStatementAccess().getLeftValueExpressionParserRuleCall_2_2_1_0());
						}
						lv_leftValue_5_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getObsInputComStatementRule());
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
				newLeafNode(otherlv_6, grammarAccess.getObsInputComStatementAccess().getRightParenthesisKeyword_2_3());
			}
		)?
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_8='<--'
								{
									newLeafNode(otherlv_8, grammarAccess.getObsInputComStatementAccess().getLessThanSignHyphenMinusHyphenMinusKeyword_3_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getObsInputComStatementAccess().getTargetValuePureNamedMachineExpressionParserRuleCall_3_0_1_0());
										}
										lv_target_9_0=ruleValuePureNamedMachineExpression
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getObsInputComStatementRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>((
									otherlv_10='<=='
									{
										newLeafNode(otherlv_10, grammarAccess.getObsInputComStatementAccess().getLessThanSignEqualsSignEqualsSignKeyword_3_1_0_0());
									}
									    |
									otherlv_11='via'
									{
										newLeafNode(otherlv_11, grammarAccess.getObsInputComStatementAccess().getViaKeyword_3_1_0_1());
									}
								)
								(
									(
										{
											/* */
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getObsInputComStatementRule());
											}
										}
										{
											newCompositeNode(grammarAccess.getObsInputComStatementAccess().getRouteChannelCrossReference_3_1_1_0());
										}
										ruleESUfid
										{
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getObsInputComStatementAccess().getUnorderedGroup_3());
				}
		)
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getObsInputComStatementAccess().getSemicolonKeyword_4());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleObsOutputComStatement
entryRuleObsOutputComStatement returns [EObject current=null]@init {
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3()
	);
}:
	{ newCompositeNode(grammarAccess.getObsOutputComStatementRule()); }
	iv_ruleObsOutputComStatement=ruleObsOutputComStatement
	{ $current=$iv_ruleObsOutputComStatement.current; }
	EOF;
finally {
	myUnorderedGroupState.restore();
}

// Rule ObsOutputComStatement
ruleObsOutputComStatement returns [EObject current=null]
@init {
	enterRule();
	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
	grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3()
	);
}
@after {
	leaveRule();
}:
	(
		otherlv_0='output'
		{
			newLeafNode(otherlv_0, grammarAccess.getObsOutputComStatementAccess().getOutputKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getObsOutputComStatementAccess().getPortObsComElementParserRuleCall_1_0());
				}
				lv_port_1_0=ruleObsComElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getObsOutputComStatementRule());
					}
					set(
						$current,
						"port",
						lv_port_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.ObsComElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getObsOutputComStatementAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getObsOutputComStatementAccess().getRightValueExpressionParserRuleCall_2_1_0());
					}
					lv_rightValue_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getObsOutputComStatementRule());
						}
						add(
							$current,
							"rightValue",
							lv_rightValue_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getObsOutputComStatementAccess().getCommaKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getObsOutputComStatementAccess().getRightValueExpressionParserRuleCall_2_2_1_0());
						}
						lv_rightValue_5_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getObsOutputComStatementRule());
							}
							add(
								$current,
								"rightValue",
								lv_rightValue_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_6=')'
			{
				newLeafNode(otherlv_6, grammarAccess.getObsOutputComStatementAccess().getRightParenthesisKeyword_2_3());
			}
		)?
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_8='-->'
								{
									newLeafNode(otherlv_8, grammarAccess.getObsOutputComStatementAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_3_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getObsOutputComStatementAccess().getTargetValuePureNamedMachineExpressionParserRuleCall_3_0_1_0());
										}
										lv_target_9_0=ruleValuePureNamedMachineExpression
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getObsOutputComStatementRule());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>((
									otherlv_10='==>'
									{
										newLeafNode(otherlv_10, grammarAccess.getObsOutputComStatementAccess().getEqualsSignEqualsSignGreaterThanSignKeyword_3_1_0_0());
									}
									    |
									otherlv_11='via'
									{
										newLeafNode(otherlv_11, grammarAccess.getObsOutputComStatementAccess().getViaKeyword_3_1_0_1());
									}
								)
								(
									(
										{
											/* */
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getObsOutputComStatementRule());
											}
										}
										{
											newCompositeNode(grammarAccess.getObsOutputComStatementAccess().getRouteChannelCrossReference_3_1_1_0());
										}
										ruleESUfid
										{
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getObsOutputComStatementAccess().getUnorderedGroup_3());
				}
		)
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getObsOutputComStatementAccess().getSemicolonKeyword_4());
		}
	)
;
finally {
	myUnorderedGroupState.restore();
}

// Entry rule entryRuleObsComElement
entryRuleObsComElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getObsComElementRule()); }
	iv_ruleObsComElement=ruleObsComElement
	{ $current=$iv_ruleObsComElement.current; }
	EOF;

// Rule ObsComElement
ruleObsComElement returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getObsComElementAccess().getParentLiteralPureReferenceExpressionParserRuleCall_0_0());
				}
				lv_parent_0_0=ruleLiteralPureReferenceExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getObsComElementRule());
					}
					set(
						$current,
						"parent",
						lv_parent_0_0,
						"org.eclipse.efm.formalml.xtext.FormalML.LiteralPureReferenceExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getObsComElementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getObsComElementAccess().getElementNamedElementCrossReference_1_0());
				}
				ruleESIdentifier
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleMetaStatement
entryRuleMetaStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMetaStatementRule()); }
	iv_ruleMetaStatement=ruleMetaStatement
	{ $current=$iv_ruleMetaStatement.current; }
	EOF;

// Rule MetaStatement
ruleMetaStatement returns [EObject current=null]
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
					grammarAccess.getMetaStatementAccess().getMetaStatementAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMetaStatementAccess().getOpOPERATOR_METAEnumRuleCall_1_0());
				}
				lv_op_1_0=ruleOPERATOR_META
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMetaStatementRule());
					}
					set(
						$current,
						"op",
						lv_op_1_0,
						"org.eclipse.efm.formalml.xtext.FormalML.OPERATOR_META");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				otherlv_2='{'
				{
					newLeafNode(otherlv_2, grammarAccess.getMetaStatementAccess().getLeftCurlyBracketKeyword_2_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getMetaStatementAccess().getOperandStatementParserRuleCall_2_0_1_0_0());
							}
							lv_operand_3_0=ruleStatement
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMetaStatementRule());
								}
								add(
									$current,
									"operand",
									lv_operand_3_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Statement");
								afterParserOrEnumRuleCall();
							}
						)
					)+
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getMetaStatementAccess().getOperandExpressionParserRuleCall_2_0_1_1_0());
							}
							lv_operand_4_0=ruleExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMetaStatementRule());
								}
								add(
									$current,
									"operand",
									lv_operand_4_0,
									"org.eclipse.efm.formalml.xtext.FormalML.Expression");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)
				otherlv_5='}'
				{
					newLeafNode(otherlv_5, grammarAccess.getMetaStatementAccess().getRightCurlyBracketKeyword_2_0_2());
				}
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getMetaStatementAccess().getOperandExpressionParserRuleCall_2_1_0_0());
						}
						lv_operand_6_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMetaStatementRule());
							}
							add(
								$current,
								"operand",
								lv_operand_6_0,
								"org.eclipse.efm.formalml.xtext.FormalML.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)+
				otherlv_7=';'
				{
					newLeafNode(otherlv_7, grammarAccess.getMetaStatementAccess().getSemicolonKeyword_2_1_1());
				}
			)
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
					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightHandSideExpressionParserRuleCall_2_0());
				}
				lv_rightHandSide_2_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
					}
					set(
						$current,
						"rightHandSide",
						lv_rightHandSide_2_0,
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
			(
				(
					lv_elseSeparator_4_0=':'
					{
						newLeafNode(lv_elseSeparator_4_0, grammarAccess.getConditionalTestExpressionAccess().getElseSeparatorColonKeyword_1_3_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getConditionalTestExpressionRule());
						}
						setWithLastConsumed($current, "elseSeparator", lv_elseSeparator_4_0, ":");
					}
				)
			)
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
						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightOperandRelationalExpressionParserRuleCall_1_2_0());
					}
					lv_rightOperand_3_0=ruleRelationalExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
						}
						set(
							$current,
							"rightOperand",
							lv_rightOperand_3_0,
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
		kw='!=='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3());
		}
		    |
		kw='=!='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignExclamationMarkEqualsSignKeyword_4());
		}
		    |
		kw='=/='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignSolidusEqualsSignKeyword_5());
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
						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightOperandAdditiveExpressionParserRuleCall_1_2_0());
					}
					lv_rightOperand_3_0=ruleAdditiveExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
						}
						set(
							$current,
							"rightOperand",
							lv_rightOperand_3_0,
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
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightOperatorRelationalOperatorParserRuleCall_1_3_1_0());
						}
						lv_rightOperator_5_0=ruleRelationalOperator
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"rightOperator",
								lv_rightOperator_5_0,
								"org.eclipse.efm.formalml.xtext.FormalML.RelationalOperator");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightOperandAdditiveExpressionParserRuleCall_1_3_2_0());
						}
						lv_rightOperand_6_0=ruleAdditiveExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
							}
							set(
								$current,
								"rightOperand",
								lv_rightOperand_6_0,
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
		    |
		kw='in'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getInKeyword_4());
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
					newCompositeNode(grammarAccess.getInvokeExpressionDeprecatedAccess().getInvokableLiteralReferenceElementParserRuleCall_3_0());
				}
				lv_invokable_3_0=ruleLiteralReferenceElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInvokeExpressionDeprecatedRule());
					}
					set(
						$current,
						"invokable",
						lv_invokable_3_0,
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
			otherlv_3='('
			{
				newLeafNode(otherlv_3, grammarAccess.getDynamicInstanceSpecificationAccess().getLeftParenthesisKeyword_3_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getDynamicInstanceSpecificationAccess().getSlotSlotParameterParserRuleCall_3_1_0_0());
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
						newLeafNode(otherlv_5, grammarAccess.getDynamicInstanceSpecificationAccess().getCommaKeyword_3_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getDynamicInstanceSpecificationAccess().getSlotSlotParameterParserRuleCall_3_1_1_1_0());
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
				newLeafNode(otherlv_7, grammarAccess.getDynamicInstanceSpecificationAccess().getRightParenthesisKeyword_3_2());
			}
		)?
		(
			otherlv_8='{'
			{
				newLeafNode(otherlv_8, grammarAccess.getDynamicInstanceSpecificationAccess().getLeftCurlyBracketKeyword_4_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getDynamicInstanceSpecificationAccess().getSlotSlotPropertyParserRuleCall_4_1_0_0());
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
					newLeafNode(otherlv_10, grammarAccess.getDynamicInstanceSpecificationAccess().getSemicolonKeyword_4_1_1());
				}
			)*
			otherlv_11='}'
			{
				newLeafNode(otherlv_11, grammarAccess.getDynamicInstanceSpecificationAccess().getRightCurlyBracketKeyword_4_2());
			}
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
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralAnyValueExpressionParserRuleCall_7());
		}
		this_LiteralAnyValueExpression_7=ruleLiteralAnyValueExpression
		{
			$current = $this_LiteralAnyValueExpression_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralOptionalValueExpressionParserRuleCall_8());
		}
		this_LiteralOptionalValueExpression_8=ruleLiteralOptionalValueExpression
		{
			$current = $this_LiteralOptionalValueExpression_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralNoneValueExpressionParserRuleCall_9());
		}
		this_LiteralNoneValueExpression_9=ruleLiteralNoneValueExpression
		{
			$current = $this_LiteralNoneValueExpression_9.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralTerminalExpressionAccess().getLiteralAnyOrNoneValueExpressionParserRuleCall_10());
		}
		this_LiteralAnyOrNoneValueExpression_10=ruleLiteralAnyOrNoneValueExpression
		{
			$current = $this_LiteralAnyOrNoneValueExpression_10.current;
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

// Entry rule entryRuleAnyDataTypeReference
entryRuleAnyDataTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnyDataTypeReferenceRule()); }
	iv_ruleAnyDataTypeReference=ruleAnyDataTypeReference
	{ $current=$iv_ruleAnyDataTypeReference.current; }
	EOF;

// Rule AnyDataTypeReference
ruleAnyDataTypeReference returns [EObject current=null]
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
				newCompositeNode(grammarAccess.getAnyDataTypeReferenceAccess().getSimpleDataTypeParserRuleCall_0_0());
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
							grammarAccess.getAnyDataTypeReferenceAccess().getDataTypeReferenceSupportAction_0_1_0(),
							$current);
					}
				)
				otherlv_2='['
				{
					newLeafNode(otherlv_2, grammarAccess.getAnyDataTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_1());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnyDataTypeReferenceAccess().getMultiplicityDataTypeMultiplicityParserRuleCall_0_1_2_0());
						}
						lv_multiplicity_3_0=ruleDataTypeMultiplicity
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnyDataTypeReferenceRule());
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
					newLeafNode(otherlv_4, grammarAccess.getAnyDataTypeReferenceAccess().getRightSquareBracketKeyword_0_1_3());
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
						grammarAccess.getAnyDataTypeReferenceAccess().getDataTypeReferenceAction_1_0(),
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
							$current = createModelElement(grammarAccess.getAnyDataTypeReferenceRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getAnyDataTypeReferenceAccess().getTyperefDataTypeCrossReference_1_1_0());
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
					newLeafNode(otherlv_7, grammarAccess.getAnyDataTypeReferenceAccess().getLeftSquareBracketKeyword_1_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnyDataTypeReferenceAccess().getMultiplicityDataTypeMultiplicityParserRuleCall_1_2_1_0());
						}
						lv_multiplicity_8_0=ruleDataTypeMultiplicity
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnyDataTypeReferenceRule());
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
					newLeafNode(otherlv_9, grammarAccess.getAnyDataTypeReferenceAccess().getRightSquareBracketKeyword_1_2_2());
				}
			)?
		)
	)
;

// Entry rule entryRuleLiteralAnyValueExpression
entryRuleLiteralAnyValueExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralAnyValueExpressionRule()); }
	iv_ruleLiteralAnyValueExpression=ruleLiteralAnyValueExpression
	{ $current=$iv_ruleLiteralAnyValueExpression.current; }
	EOF;

// Rule LiteralAnyValueExpression
ruleLiteralAnyValueExpression returns [EObject current=null]
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
					grammarAccess.getLiteralAnyValueExpressionAccess().getLiteralAnyValueExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$any'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralAnyValueExpressionAccess().getAnyKeyword_1());
		}
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralAnyValueExpressionAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralAnyValueExpressionAccess().getTypeAnyDataTypeReferenceParserRuleCall_2_1_0());
					}
					lv_type_3_0=ruleAnyDataTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralAnyValueExpressionRule());
						}
						set(
							$current,
							"type",
							lv_type_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.AnyDataTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='>'
			{
				newLeafNode(otherlv_4, grammarAccess.getLiteralAnyValueExpressionAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
	)
;

// Entry rule entryRuleLiteralOptionalValueExpression
entryRuleLiteralOptionalValueExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralOptionalValueExpressionRule()); }
	iv_ruleLiteralOptionalValueExpression=ruleLiteralOptionalValueExpression
	{ $current=$iv_ruleLiteralOptionalValueExpression.current; }
	EOF;

// Rule LiteralOptionalValueExpression
ruleLiteralOptionalValueExpression returns [EObject current=null]
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
					grammarAccess.getLiteralOptionalValueExpressionAccess().getLiteralOptionalValueExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$optional'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralOptionalValueExpressionAccess().getOptionalKeyword_1());
		}
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralOptionalValueExpressionAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralOptionalValueExpressionAccess().getTypeAnyDataTypeReferenceParserRuleCall_2_1_0());
					}
					lv_type_3_0=ruleAnyDataTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralOptionalValueExpressionRule());
						}
						set(
							$current,
							"type",
							lv_type_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.AnyDataTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='>'
			{
				newLeafNode(otherlv_4, grammarAccess.getLiteralOptionalValueExpressionAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
	)
;

// Entry rule entryRuleLiteralNoneValueExpression
entryRuleLiteralNoneValueExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralNoneValueExpressionRule()); }
	iv_ruleLiteralNoneValueExpression=ruleLiteralNoneValueExpression
	{ $current=$iv_ruleLiteralNoneValueExpression.current; }
	EOF;

// Rule LiteralNoneValueExpression
ruleLiteralNoneValueExpression returns [EObject current=null]
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
					grammarAccess.getLiteralNoneValueExpressionAccess().getLiteralNoneValueExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$none'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralNoneValueExpressionAccess().getNoneKeyword_1());
		}
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralNoneValueExpressionAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralNoneValueExpressionAccess().getTypeAnyDataTypeReferenceParserRuleCall_2_1_0());
					}
					lv_type_3_0=ruleAnyDataTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralNoneValueExpressionRule());
						}
						set(
							$current,
							"type",
							lv_type_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.AnyDataTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='>'
			{
				newLeafNode(otherlv_4, grammarAccess.getLiteralNoneValueExpressionAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
	)
;

// Entry rule entryRuleLiteralAnyOrNoneValueExpression
entryRuleLiteralAnyOrNoneValueExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralAnyOrNoneValueExpressionRule()); }
	iv_ruleLiteralAnyOrNoneValueExpression=ruleLiteralAnyOrNoneValueExpression
	{ $current=$iv_ruleLiteralAnyOrNoneValueExpression.current; }
	EOF;

// Rule LiteralAnyOrNoneValueExpression
ruleLiteralAnyOrNoneValueExpression returns [EObject current=null]
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
					grammarAccess.getLiteralAnyOrNoneValueExpressionAccess().getLiteralAnyOrNoneValueExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$any$none'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralAnyOrNoneValueExpressionAccess().getAnyNoneKeyword_1());
		}
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralAnyOrNoneValueExpressionAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralAnyOrNoneValueExpressionAccess().getTypeAnyDataTypeReferenceParserRuleCall_2_1_0());
					}
					lv_type_3_0=ruleAnyDataTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralAnyOrNoneValueExpressionRule());
						}
						set(
							$current,
							"type",
							lv_type_3_0,
							"org.eclipse.efm.formalml.xtext.FormalML.AnyDataTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='>'
			{
				newLeafNode(otherlv_4, grammarAccess.getLiteralAnyOrNoneValueExpressionAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
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
			otherlv_1='spec::'
			{
				newLeafNode(otherlv_1, grammarAccess.getLiteralReferenceElementAccess().getSpecKeyword_1_0());
			}
			    |
			otherlv_2='::'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralReferenceElementAccess().getColonColonKeyword_1_1());
			}
		)?
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
					newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getElementNamedElementCrossReference_2_0());
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
							newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getKindValueIndexExpressionKindEnumRuleCall_3_0_0_0());
						}
						lv_kind_4_0=ruleValueIndexExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralReferenceElementRule());
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
							newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getArgPositionalTupleExpressionListParserRuleCall_3_0_1_0());
						}
						lv_arg_5_0=rulePositionalTupleExpressionList
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralReferenceElementRule());
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
					newLeafNode(otherlv_6, grammarAccess.getLiteralReferenceElementAccess().getRightSquareBracketKeyword_3_0_2());
				}
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getKindValueParameterExpressionKindEnumRuleCall_3_1_0_0());
						}
						lv_kind_7_0=ruleValueParameterExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralReferenceElementRule());
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
							newCompositeNode(grammarAccess.getLiteralReferenceElementAccess().getArgMixTupleExpressionListParserRuleCall_3_1_1_0());
						}
						lv_arg_8_0=ruleMixTupleExpressionList
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralReferenceElementRule());
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
					newLeafNode(otherlv_9, grammarAccess.getLiteralReferenceElementAccess().getRightParenthesisKeyword_3_1_2());
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
			otherlv_1='spec::'
			{
				newLeafNode(otherlv_1, grammarAccess.getLiteralPureReferenceElementAccess().getSpecKeyword_1_0());
			}
			    |
			otherlv_2='::'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralPureReferenceElementAccess().getColonColonKeyword_1_1());
			}
		)?
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
					newCompositeNode(grammarAccess.getLiteralPureReferenceElementAccess().getElementNamedElementCrossReference_2_0());
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
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceVariableContextAccess().getLiteralTimeInitialExpressionParserRuleCall_2());
		}
		this_LiteralTimeInitialExpression_2=ruleLiteralTimeInitialExpression
		{
			$current = $this_LiteralTimeInitialExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralReferenceVariableContextAccess().getLiteralTimeDeltaInitialExpressionParserRuleCall_3());
		}
		this_LiteralTimeDeltaInitialExpression_3=ruleLiteralTimeDeltaInitialExpression
		{
			$current = $this_LiteralTimeDeltaInitialExpression_3.current;
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

// Entry rule entryRuleLiteralTimeInitialExpression
entryRuleLiteralTimeInitialExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralTimeInitialExpressionRule()); }
	iv_ruleLiteralTimeInitialExpression=ruleLiteralTimeInitialExpression
	{ $current=$iv_ruleLiteralTimeInitialExpression.current; }
	EOF;

// Rule LiteralTimeInitialExpression
ruleLiteralTimeInitialExpression returns [EObject current=null]
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
					grammarAccess.getLiteralTimeInitialExpressionAccess().getLiteralTimeExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$time#initial'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralTimeInitialExpressionAccess().getTimeInitialKeyword_1());
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

// Entry rule entryRuleLiteralTimeDeltaInitialExpression
entryRuleLiteralTimeDeltaInitialExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralTimeDeltaInitialExpressionRule()); }
	iv_ruleLiteralTimeDeltaInitialExpression=ruleLiteralTimeDeltaInitialExpression
	{ $current=$iv_ruleLiteralTimeDeltaInitialExpression.current; }
	EOF;

// Rule LiteralTimeDeltaInitialExpression
ruleLiteralTimeDeltaInitialExpression returns [EObject current=null]
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
					grammarAccess.getLiteralTimeDeltaInitialExpressionAccess().getLiteralTimeDeltaExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='$delta#initial'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralTimeDeltaInitialExpressionAccess().getDeltaInitialKeyword_1());
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
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralSelfExpressionAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_3='model:'
				{
					newLeafNode(otherlv_3, grammarAccess.getLiteralSelfExpressionAccess().getModelKeyword_2_1());
				}
			)?
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralSelfExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getLiteralSelfExpressionAccess().getModelMachineCrossReference_2_2_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5='>'
			{
				newLeafNode(otherlv_5, grammarAccess.getLiteralSelfExpressionAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
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
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralParentExpressionAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_3='model:'
				{
					newLeafNode(otherlv_3, grammarAccess.getLiteralParentExpressionAccess().getModelKeyword_2_1());
				}
			)?
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralParentExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getLiteralParentExpressionAccess().getModelMachineCrossReference_2_2_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5='>'
			{
				newLeafNode(otherlv_5, grammarAccess.getLiteralParentExpressionAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
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
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralSuperExpressionAccess().getLessThanSignKeyword_2_0());
			}
			(
				otherlv_3='model:'
				{
					newLeafNode(otherlv_3, grammarAccess.getLiteralSuperExpressionAccess().getModelKeyword_2_1());
				}
			)?
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralSuperExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getLiteralSuperExpressionAccess().getModelMachineCrossReference_2_2_0());
					}
					ruleESUfid
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5='>'
			{
				newLeafNode(otherlv_5, grammarAccess.getLiteralSuperExpressionAccess().getGreaterThanSignKeyword_2_3());
			}
		)?
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
					(
						{
							newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getKindValueDotFieldExpressionKindEnumRuleCall_1_1_0_0());
						}
						lv_kind_2_1=ruleValueDotFieldExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getValuePureNamedMachineExpressionRule());
							}
							set(
								$current,
								"kind",
								lv_kind_2_1,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueDotFieldExpressionKind");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getValuePureNamedMachineExpressionAccess().getKindValueArrowFieldExpressionKindEnumRuleCall_1_1_0_1());
						}
						lv_kind_2_2=ruleValueArrowFieldExpressionKind
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getValuePureNamedMachineExpressionRule());
							}
							set(
								$current,
								"kind",
								lv_kind_2_2,
								"org.eclipse.efm.formalml.xtext.FormalML.ValueArrowFieldExpressionKind");
							afterParserOrEnumRuleCall();
						}
					)
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
		    |
		(
			enumLiteral_2='#model'
			{
				$current = grammarAccess.getDesignKindAccess().getModelEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getDesignKindAccess().getModelEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='#prototype'
			{
				$current = grammarAccess.getDesignKindAccess().getPrototypeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getDesignKindAccess().getPrototypeEnumLiteralDeclaration_3());
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
				$current = grammarAccess.getPseudostateKindAccess().getEntryPointEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getPseudostateKindAccess().getEntryPointEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='exitPoint'
			{
				$current = grammarAccess.getPseudostateKindAccess().getExitPointEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getPseudostateKindAccess().getExitPointEnumLiteralDeclaration_3());
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
				$current = grammarAccess.getEndingPseudostateKindAccess().getTerminalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getEndingPseudostateKindAccess().getTerminalEnumLiteralDeclaration_0());
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
			enumLiteral_2='multirdv'
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
		enumLiteral_0='multirdv'
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
			enumLiteral_1='input'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getInEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getParameterDirectionKindAccess().getInEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='inout'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getInoutEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getParameterDirectionKindAccess().getInoutEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='out'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getOutEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getParameterDirectionKindAccess().getOutEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4='output'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getOutEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getParameterDirectionKindAccess().getOutEnumLiteralDeclaration_4());
			}
		)
		    |
		(
			enumLiteral_5='return'
			{
				$current = grammarAccess.getParameterDirectionKindAccess().getReturnEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_5, grammarAccess.getParameterDirectionKindAccess().getReturnEnumLiteralDeclaration_5());
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

// Rule OPERATOR_META
ruleOPERATOR_META returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='@informal'
			{
				$current = grammarAccess.getOPERATOR_METAAccess().getInformalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getOPERATOR_METAAccess().getInformalEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='@trace'
			{
				$current = grammarAccess.getOPERATOR_METAAccess().getTraceEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getOPERATOR_METAAccess().getTraceEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='@debug'
			{
				$current = grammarAccess.getOPERATOR_METAAccess().getDebugEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getOPERATOR_METAAccess().getDebugEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='@comment'
			{
				$current = grammarAccess.getOPERATOR_METAAccess().getCommentEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getOPERATOR_METAAccess().getCommentEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4='@quote'
			{
				$current = grammarAccess.getOPERATOR_METAAccess().getQuoteEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getOPERATOR_METAAccess().getQuoteEnumLiteralDeclaration_4());
			}
		)
		    |
		(
			enumLiteral_5='@eval'
			{
				$current = grammarAccess.getOPERATOR_METAAccess().getEvalEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_5, grammarAccess.getOPERATOR_METAAccess().getEvalEnumLiteralDeclaration_5());
			}
		)
		    |
		(
			enumLiteral_6='@run'
			{
				$current = grammarAccess.getOPERATOR_METAAccess().getRunEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_6, grammarAccess.getOPERATOR_METAAccess().getRunEnumLiteralDeclaration_6());
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

RULE_OFFSET : '$' RULE_INT? ':';

RULE_XLIA_ID : ('a'..'z'|'A'..'Z'|'_'|'#') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'#')*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
