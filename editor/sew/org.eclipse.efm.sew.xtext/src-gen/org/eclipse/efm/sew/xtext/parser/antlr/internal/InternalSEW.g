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
	superClass=AbstractInternalAntlrParser;
	backtrack=true;
}

@lexer::header {
package org.eclipse.efm.sew.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.efm.sew.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.efm.sew.xtext.services.SEWGrammarAccess;

}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/

 	private SEWGrammarAccess grammarAccess;

    public InternalSEWParser(TokenStream input, SEWGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Workflow";
   	}

   	@Override
   	protected SEWGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleWorkflow
entryRuleWorkflow returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWorkflowRule()); }
	iv_ruleWorkflow=ruleWorkflow
	{ $current=$iv_ruleWorkflow.current; }
	EOF;

// Rule Workflow
ruleWorkflow returns [EObject current=null]
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
					grammarAccess.getWorkflowAccess().getSEWorkflowAction_0(),
					$current);
			}
		)
		(
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getWorkflowAccess().getPrologParserRuleCall_1());
			}
			ruleProlog
			{
				afterParserOrEnumRuleCall();
			}
		)?
		(
			(
				(
					(
						(
							lv_type_2_1='workflow'
							{
								newLeafNode(lv_type_2_1, grammarAccess.getWorkflowAccess().getTypeWorkflowKeyword_2_0_0_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getWorkflowRule());
								}
								setWithLastConsumed($current, "type", lv_type_2_1, null);
							}
							    |
							lv_type_2_2='symbex-workflow'
							{
								newLeafNode(lv_type_2_2, grammarAccess.getWorkflowAccess().getTypeSymbexWorkflowKeyword_2_0_0_0_1());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getWorkflowRule());
								}
								setWithLastConsumed($current, "type", lv_type_2_2, null);
							}
						)
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getWorkflowAccess().getNameUFIParserRuleCall_2_0_1_0());
						}
						lv_name_3_0=ruleUFI
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getWorkflowRule());
							}
							set(
								$current,
								"name",
								lv_name_3_0,
								"org.eclipse.efm.sew.xtext.SEW.UFI");
							afterParserOrEnumRuleCall();
						}
					)
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getWorkflowAccess().getDescriptionEStringParserRuleCall_2_0_2_0());
						}
						lv_description_4_0=ruleEString
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getWorkflowRule());
							}
							set(
								$current,
								"description",
								lv_description_4_0,
								"org.eclipse.efm.sew.xtext.SEW.EString");
							afterParserOrEnumRuleCall();
						}
					)
				)?
				otherlv_5='{'
				{
					newLeafNode(otherlv_5, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_2_0_3());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getWorkflowAccess().getElementObjectParserRuleCall_2_0_4_0_0());
							}
							lv_element_6_1=ruleObject
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getWorkflowRule());
								}
								add(
									$current,
									"element",
									lv_element_6_1,
									"org.eclipse.efm.sew.xtext.SEW.Object");
								afterParserOrEnumRuleCall();
							}
							    |
							{
								newCompositeNode(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_0_4_0_1());
							}
							lv_element_6_2=ruleProperty
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getWorkflowRule());
								}
								add(
									$current,
									"element",
									lv_element_6_2,
									"org.eclipse.efm.sew.xtext.SEW.Property");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_7='}'
				{
					newLeafNode(otherlv_7, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_2_0_5());
				}
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getWorkflowAccess().getElementObjectParserRuleCall_2_1_0_0());
						}
						lv_element_8_1=ruleObject
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getWorkflowRule());
							}
							add(
								$current,
								"element",
								lv_element_8_1,
								"org.eclipse.efm.sew.xtext.SEW.Object");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_1_0_1());
						}
						lv_element_8_2=ruleProperty
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getWorkflowRule());
							}
							add(
								$current,
								"element",
								lv_element_8_2,
								"org.eclipse.efm.sew.xtext.SEW.Property");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getWorkflowAccess().getElementDeprecatedObjectParserRuleCall_2_2_0());
					}
					lv_element_9_0=ruleDeprecatedObject
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getWorkflowRule());
						}
						add(
							$current,
							"element",
							lv_element_9_0,
							"org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleProlog
entryRuleProlog returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPrologRule()); }
	iv_ruleProlog=ruleProlog
	{ $current=$iv_ruleProlog.current.getText(); }
	EOF;

// Rule Prolog
ruleProlog returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='@sew'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getPrologAccess().getSewKeyword_0_0());
			}
			    |
			kw='@favm'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getPrologAccess().getFavmKeyword_0_1());
			}
		)
		kw='<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrologAccess().getLessThanSignKeyword_1());
		}
		(
			kw='workflow'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getPrologAccess().getWorkflowKeyword_2_0());
			}
			    |
			kw='sew'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getPrologAccess().getSewKeyword_2_1());
			}
		)
		(
			kw=','
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getPrologAccess().getCommaKeyword_3_0());
			}
			{
				newCompositeNode(grammarAccess.getPrologAccess().getEDoubleParserRuleCall_3_1());
			}
			this_EDouble_6=ruleEDouble
			{
				$current.merge(this_EDouble_6);
			}
			{
				afterParserOrEnumRuleCall();
			}
		)?
		(
			(
				kw=','
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getPrologAccess().getCommaKeyword_4_0_0());
				}
				{
					newCompositeNode(grammarAccess.getPrologAccess().getUFIParserRuleCall_4_0_1());
				}
				this_UFI_8=ruleUFI
				{
					$current.merge(this_UFI_8);
				}
				{
					afterParserOrEnumRuleCall();
				}
			)
			    |
			{
				newCompositeNode(grammarAccess.getPrologAccess().getEStringParserRuleCall_4_1());
			}
			this_EString_9=ruleEString
			{
				$current.merge(this_EString_9);
			}
			{
				afterParserOrEnumRuleCall();
			}
		)?
		kw='>:'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPrologAccess().getGreaterThanSignColonKeyword_5());
		}
	)
;

// Entry rule entryRuleReservedWord
entryRuleReservedWord returns [String current=null]:
	{ newCompositeNode(grammarAccess.getReservedWordRule()); }
	iv_ruleReservedWord=ruleReservedWord
	{ $current=$iv_ruleReservedWord.current.getText(); }
	EOF;

// Rule ReservedWord
ruleReservedWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='workflow'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getReservedWordAccess().getWorkflowKeyword_0());
		}
		    |
		kw='sew'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getReservedWordAccess().getSewKeyword_1());
		}
		    |
		{
			newCompositeNode(grammarAccess.getReservedWordAccess().getDeprecatedReservedWordParserRuleCall_2());
		}
		this_DeprecatedReservedWord_2=ruleDeprecatedReservedWord
		{
			$current.merge(this_DeprecatedReservedWord_2);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleXID
entryRuleXID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getXIDRule()); }
	iv_ruleXID=ruleXID
	{ $current=$iv_ruleXID.current.getText(); }
	EOF;

// Rule XID
ruleXID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getXIDAccess().getReservedWordParserRuleCall_0());
		}
		this_ReservedWord_0=ruleReservedWord
		{
			$current.merge(this_ReservedWord_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		this_XIDENDIFIER_1=RULE_XIDENDIFIER
		{
			$current.merge(this_XIDENDIFIER_1);
		}
		{
			newLeafNode(this_XIDENDIFIER_1, grammarAccess.getXIDAccess().getXIDENDIFIERTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleUFI
entryRuleUFI returns [String current=null]:
	{ newCompositeNode(grammarAccess.getUFIRule()); }
	iv_ruleUFI=ruleUFI
	{ $current=$iv_ruleUFI.current.getText(); }
	EOF;

// Rule UFI
ruleUFI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getUFIAccess().getXIDParserRuleCall_0());
		}
		this_XID_0=ruleXID
		{
			$current.merge(this_XID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		(
			(
				kw='::'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getUFIAccess().getColonColonKeyword_1_0_0());
				}
				    |
				kw='.'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getUFIAccess().getFullStopKeyword_1_0_1());
				}
			)
			{
				newCompositeNode(grammarAccess.getUFIAccess().getXIDParserRuleCall_1_1());
			}
			this_XID_3=ruleXID
			{
				$current.merge(this_XID_3);
			}
			{
				afterParserOrEnumRuleCall();
			}
		)*
	)
;

// Entry rule entryRuleObject
entryRuleObject returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getObjectRule()); }
	iv_ruleObject=ruleObject
	{ $current=$iv_ruleObject.current; }
	EOF;

// Rule Object
ruleObject returns [EObject current=null]
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
						grammarAccess.getObjectAccess().getWObjectAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getObjectAccess().getTypeUFIParserRuleCall_0_1_0());
					}
					lv_type_1_0=ruleUFI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getObjectRule());
						}
						set(
							$current,
							"type",
							lv_type_1_0,
							"org.eclipse.efm.sew.xtext.SEW.UFI");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_0_2_0());
					}
					lv_name_2_0=ruleUFI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getObjectRule());
						}
						set(
							$current,
							"name",
							lv_name_2_0,
							"org.eclipse.efm.sew.xtext.SEW.UFI");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			(
				(
					{
						newCompositeNode(grammarAccess.getObjectAccess().getDescriptionEStringParserRuleCall_0_3_0());
					}
					lv_description_3_0=ruleEString
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getObjectRule());
						}
						set(
							$current,
							"description",
							lv_description_3_0,
							"org.eclipse.efm.sew.xtext.SEW.EString");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_4='{'
			{
				newLeafNode(otherlv_4, grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_0_4());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getObjectAccess().getElementObjectParserRuleCall_0_5_0_0());
						}
						lv_element_5_1=ruleObject
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getObjectRule());
							}
							add(
								$current,
								"element",
								lv_element_5_1,
								"org.eclipse.efm.sew.xtext.SEW.Object");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getObjectAccess().getElementPropertyParserRuleCall_0_5_0_1());
						}
						lv_element_5_2=ruleProperty
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getObjectRule());
							}
							add(
								$current,
								"element",
								lv_element_5_2,
								"org.eclipse.efm.sew.xtext.SEW.Property");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_6='}'
			{
				newLeafNode(otherlv_6, grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_0_6());
			}
		)
		    |
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getObjectAccess().getWObjectAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_1_1_0());
					}
					lv_name_8_0=ruleUFI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getObjectRule());
						}
						set(
							$current,
							"name",
							lv_name_8_0,
							"org.eclipse.efm.sew.xtext.SEW.UFI");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_9=':='
				{
					newLeafNode(otherlv_9, grammarAccess.getObjectAccess().getColonEqualsSignKeyword_1_2_0());
				}
				    |
				otherlv_10='+:='
				{
					newLeafNode(otherlv_10, grammarAccess.getObjectAccess().getPlusSignColonEqualsSignKeyword_1_2_1());
				}
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getObjectAccess().getTypeUFIParserRuleCall_1_3_0_0());
						}
						lv_type_11_0=ruleUFI
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getObjectRule());
							}
							set(
								$current,
								"type",
								lv_type_11_0,
								"org.eclipse.efm.sew.xtext.SEW.UFI");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getObjectAccess().getDescriptionEStringParserRuleCall_1_3_1_0());
						}
						lv_description_12_0=ruleEString
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getObjectRule());
							}
							set(
								$current,
								"description",
								lv_description_12_0,
								"org.eclipse.efm.sew.xtext.SEW.EString");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)?
			otherlv_13='{'
			{
				newLeafNode(otherlv_13, grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_1_4());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getObjectAccess().getElementObjectParserRuleCall_1_5_0_0());
						}
						lv_element_14_1=ruleObject
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getObjectRule());
							}
							add(
								$current,
								"element",
								lv_element_14_1,
								"org.eclipse.efm.sew.xtext.SEW.Object");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getObjectAccess().getElementPropertyParserRuleCall_1_5_0_1());
						}
						lv_element_14_2=ruleProperty
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getObjectRule());
							}
							add(
								$current,
								"element",
								lv_element_14_2,
								"org.eclipse.efm.sew.xtext.SEW.Property");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_15='}'
			{
				newLeafNode(otherlv_15, grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_1_6());
			}
		)
	)
;

// Entry rule entryRuleProperty
entryRuleProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyRule()); }
	iv_ruleProperty=ruleProperty
	{ $current=$iv_ruleProperty.current; }
	EOF;

// Rule Property
ruleProperty returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getPropertyAccess().getSectionParserRuleCall_0());
		}
		this_Section_0=ruleSection
		{
			$current = $this_Section_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPropertyAccess().getAttributeParserRuleCall_1());
		}
		this_Attribute_1=ruleAttribute
		{
			$current = $this_Attribute_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSection
entryRuleSection returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSectionRule()); }
	iv_ruleSection=ruleSection
	{ $current=$iv_ruleSection.current; }
	EOF;

// Rule Section
ruleSection returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getSectionAccess().getNameXIDParserRuleCall_0_0());
				}
				lv_name_0_0=ruleXID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSectionRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.efm.sew.xtext.SEW.XID");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSectionAccess().getDescriptionEStringParserRuleCall_1_0());
				}
				lv_description_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSectionRule());
					}
					set(
						$current,
						"description",
						lv_description_1_0,
						"org.eclipse.efm.sew.xtext.SEW.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				otherlv_2='['
				{
					newLeafNode(otherlv_2, grammarAccess.getSectionAccess().getLeftSquareBracketKeyword_2_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_0_1_0_0());
							}
							lv_element_3_1=ruleObject
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSectionRule());
								}
								add(
									$current,
									"element",
									lv_element_3_1,
									"org.eclipse.efm.sew.xtext.SEW.Object");
								afterParserOrEnumRuleCall();
							}
							    |
							{
								newCompositeNode(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_0_1_0_1());
							}
							lv_element_3_2=ruleAttribute
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSectionRule());
								}
								add(
									$current,
									"element",
									lv_element_3_2,
									"org.eclipse.efm.sew.xtext.SEW.Attribute");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_4=']'
				{
					newLeafNode(otherlv_4, grammarAccess.getSectionAccess().getRightSquareBracketKeyword_2_0_2());
				}
			)
			    |
			(
				otherlv_5=':'
				{
					newLeafNode(otherlv_5, grammarAccess.getSectionAccess().getColonKeyword_2_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_1_1_0_0());
							}
							lv_element_6_1=ruleObject
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSectionRule());
								}
								add(
									$current,
									"element",
									lv_element_6_1,
									"org.eclipse.efm.sew.xtext.SEW.Object");
								afterParserOrEnumRuleCall();
							}
							    |
							{
								newCompositeNode(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_1_1_0_1());
							}
							lv_element_6_2=ruleAttribute
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSectionRule());
								}
								add(
									$current,
									"element",
									lv_element_6_2,
									"org.eclipse.efm.sew.xtext.SEW.Attribute");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)
	)
;

// Entry rule entryRuleAttribute
entryRuleAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAttributeRule()); }
	iv_ruleAttribute=ruleAttribute
	{ $current=$iv_ruleAttribute.current; }
	EOF;

// Rule Attribute
ruleAttribute returns [EObject current=null]
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
					grammarAccess.getAttributeAccess().getWAttributeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getAttributeAccess().getNameXIDParserRuleCall_1_0());
				}
				lv_name_1_0=ruleXID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAttributeRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.sew.xtext.SEW.XID");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAttributeAccess().getValueValueSpecificationParserRuleCall_3_0());
				}
				lv_value_3_0=ruleValueSpecification
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAttributeRule());
					}
					set(
						$current,
						"value",
						lv_value_3_0,
						"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=';'
			{
				newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getSemicolonKeyword_4());
			}
		)?
	)
;

// Entry rule entryRuleValueSpecification
entryRuleValueSpecification returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getValueSpecificationRule()); }
	iv_ruleValueSpecification=ruleValueSpecification
	{ $current=$iv_ruleValueSpecification.current; }
	EOF;

// Rule ValueSpecification
ruleValueSpecification returns [EObject current=null]
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
		newCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall());
	}
	this_Expression_0=ruleExpression
	{
		$current = $this_Expression_0.current;
		afterParserOrEnumRuleCall();
	}
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
			newCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0());
		}
		this_conditionalExpression_0=ruleconditionalExpression
		{
			$current = $this_conditionalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getDeprecatedExpressionParserRuleCall_1());
		}
		this_DeprecatedExpression_1=ruleDeprecatedExpression
		{
			$current = $this_DeprecatedExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleconditionalExpression
entryRuleconditionalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionalExpressionRule()); }
	iv_ruleconditionalExpression=ruleconditionalExpression
	{ $current=$iv_ruleconditionalExpression.current; }
	EOF;

// Rule conditionalExpression
ruleconditionalExpression returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConditionalOrExpressionParserRuleCall_0());
		}
		this_conditionalOrExpression_0=ruleconditionalOrExpression
		{
			$current = $this_conditionalOrExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getConditionalExpressionAccess().getExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_operator_2_0='?'
					{
						newLeafNode(lv_operator_2_0, grammarAccess.getConditionalExpressionAccess().getOperatorQuestionMarkKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getConditionalExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_0, "?");
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperandExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.sew.xtext.SEW.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4=':'
			{
				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperandExpressionParserRuleCall_1_4_0());
					}
					lv_operand_5_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_5_0,
							"org.eclipse.efm.sew.xtext.SEW.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleconditionalOrExpression
entryRuleconditionalOrExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionalOrExpressionRule()); }
	iv_ruleconditionalOrExpression=ruleconditionalOrExpression
	{ $current=$iv_ruleconditionalOrExpression.current; }
	EOF;

// Rule conditionalOrExpression
ruleconditionalOrExpression returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getConditionalAndExpressionParserRuleCall_0());
		}
		this_conditionalAndExpression_0=ruleconditionalAndExpression
		{
			$current = $this_conditionalAndExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getConditionalOrExpressionAccess().getExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_operator_2_1='||'
						{
							newLeafNode(lv_operator_2_1, grammarAccess.getConditionalOrExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getConditionalOrExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_1, null);
						}
						    |
						lv_operator_2_2='or'
						{
							newLeafNode(lv_operator_2_2, grammarAccess.getConditionalOrExpressionAccess().getOperatorOrKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getConditionalOrExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_2, null);
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getOperandConditionalAndExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleconditionalAndExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.sew.xtext.SEW.conditionalAndExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					otherlv_4='||'
					{
						newLeafNode(otherlv_4, grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_3_0_0());
					}
					    |
					otherlv_5='or'
					{
						newLeafNode(otherlv_5, grammarAccess.getConditionalOrExpressionAccess().getOrKeyword_1_3_0_1());
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getOperandConditionalAndExpressionParserRuleCall_1_3_1_0());
						}
						lv_operand_6_0=ruleconditionalAndExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_6_0,
								"org.eclipse.efm.sew.xtext.SEW.conditionalAndExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleconditionalAndExpression
entryRuleconditionalAndExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionalAndExpressionRule()); }
	iv_ruleconditionalAndExpression=ruleconditionalAndExpression
	{ $current=$iv_ruleconditionalAndExpression.current; }
	EOF;

// Rule conditionalAndExpression
ruleconditionalAndExpression returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
		}
		this_equalityExpression_0=ruleequalityExpression
		{
			$current = $this_equalityExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getConditionalAndExpressionAccess().getExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_operator_2_1='&&'
						{
							newLeafNode(lv_operator_2_1, grammarAccess.getConditionalAndExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getConditionalAndExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_1, null);
						}
						    |
						lv_operator_2_2='and'
						{
							newLeafNode(lv_operator_2_2, grammarAccess.getConditionalAndExpressionAccess().getOperatorAndKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getConditionalAndExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_2, null);
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleequalityExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.sew.xtext.SEW.equalityExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					otherlv_4='&&'
					{
						newLeafNode(otherlv_4, grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_3_0_0());
					}
					    |
					otherlv_5='and'
					{
						newLeafNode(otherlv_5, grammarAccess.getConditionalAndExpressionAccess().getAndKeyword_1_3_0_1());
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_3_1_0());
						}
						lv_operand_6_0=ruleequalityExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_6_0,
								"org.eclipse.efm.sew.xtext.SEW.equalityExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleequalityExpression
entryRuleequalityExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEqualityExpressionRule()); }
	iv_ruleequalityExpression=ruleequalityExpression
	{ $current=$iv_ruleequalityExpression.current; }
	EOF;

// Rule equalityExpression
ruleequalityExpression returns [EObject current=null]
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
		this_relationalExpression_0=rulerelationalExpression
		{
			$current = $this_relationalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getEqualityExpressionAccess().getExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_operator_2_1='=='
						{
							newLeafNode(lv_operator_2_1, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEqualityExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_1, null);
						}
						    |
						lv_operator_2_2='!='
						{
							newLeafNode(lv_operator_2_2, grammarAccess.getEqualityExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEqualityExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_2, null);
						}
						    |
						lv_operator_2_3='==='
						{
							newLeafNode(lv_operator_2_3, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignEqualsSignKeyword_1_1_0_2());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEqualityExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_3, null);
						}
						    |
						lv_operator_2_4='=!='
						{
							newLeafNode(lv_operator_2_4, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignExclamationMarkEqualsSignKeyword_1_1_0_3());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEqualityExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_4, null);
						}
						    |
						lv_operator_2_5='=/='
						{
							newLeafNode(lv_operator_2_5, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignSolidusEqualsSignKeyword_1_1_0_4());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEqualityExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_5, null);
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=rulerelationalExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.sew.xtext.SEW.relationalExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRulerelationalExpression
entryRulerelationalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRelationalExpressionRule()); }
	iv_rulerelationalExpression=rulerelationalExpression
	{ $current=$iv_rulerelationalExpression.current; }
	EOF;

// Rule relationalExpression
rulerelationalExpression returns [EObject current=null]
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
		this_additiveExpression_0=ruleadditiveExpression
		{
			$current = $this_additiveExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getRelationalExpressionAccess().getExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_operator_2_1='<'
						{
							newLeafNode(lv_operator_2_1, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getRelationalExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_1, null);
						}
						    |
						lv_operator_2_2='<='
						{
							newLeafNode(lv_operator_2_2, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getRelationalExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_2, null);
						}
						    |
						lv_operator_2_3='>'
						{
							newLeafNode(lv_operator_2_3, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_2());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getRelationalExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_3, null);
						}
						    |
						lv_operator_2_4='>='
						{
							newLeafNode(lv_operator_2_4, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getRelationalExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_4, null);
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperandAdditiveExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleadditiveExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.sew.xtext.SEW.additiveExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleadditiveExpression
entryRuleadditiveExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAdditiveExpressionRule()); }
	iv_ruleadditiveExpression=ruleadditiveExpression
	{ $current=$iv_ruleadditiveExpression.current; }
	EOF;

// Rule additiveExpression
ruleadditiveExpression returns [EObject current=null]
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
		this_multiplicativeExpression_0=rulemultiplicativeExpression
		{
			$current = $this_multiplicativeExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getAdditiveExpressionAccess().getExpressionOperandAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_operator_2_0='+'
					{
						newLeafNode(lv_operator_2_0, grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0());
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
						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=rulemultiplicativeExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
						}
						add(
							$current,
							"operand",
							lv_operand_3_0,
							"org.eclipse.efm.sew.xtext.SEW.multiplicativeExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4='+'
				{
					newLeafNode(otherlv_4, grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_3_1_0());
						}
						lv_operand_5_0=rulemultiplicativeExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_5_0,
								"org.eclipse.efm.sew.xtext.SEW.multiplicativeExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRulemultiplicativeExpression
entryRulemultiplicativeExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); }
	iv_rulemultiplicativeExpression=rulemultiplicativeExpression
	{ $current=$iv_rulemultiplicativeExpression.current; }
	EOF;

// Rule multiplicativeExpression
rulemultiplicativeExpression returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getPrimaryExpressionParserRuleCall_0());
		}
		this_primaryExpression_0=ruleprimaryExpression
		{
			$current = $this_primaryExpression_0.current;
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
							grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_0_0(),
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
							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0_2_0());
						}
						lv_operand_3_0=ruleprimaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_3_0,
								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
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
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0_3_1_0());
							}
							lv_operand_5_0=ruleprimaryExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_5_0,
									"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
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
							grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_1_0(),
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
							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_2_0());
						}
						lv_operand_8_0=ruleprimaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_8_0,
								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
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
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_3_1_0());
							}
							lv_operand_10_0=ruleprimaryExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_10_0,
									"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
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
							grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_2_0(),
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
							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_2_0());
						}
						lv_operand_13_0=ruleprimaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_13_0,
								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
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
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_3_1_0());
							}
							lv_operand_15_0=ruleprimaryExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_15_0,
									"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
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
							grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_3_0(),
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
							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_3_2_0());
						}
						lv_operand_18_0=ruleprimaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_18_0,
								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
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
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_3_3_1_0());
							}
							lv_operand_20_0=ruleprimaryExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								add(
									$current,
									"operand",
									lv_operand_20_0,
									"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)?
	)
;

// Entry rule entryRuleprimaryExpression
entryRuleprimaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryExpressionRule()); }
	iv_ruleprimaryExpression=ruleprimaryExpression
	{ $current=$iv_ruleprimaryExpression.current; }
	EOF;

// Rule primaryExpression
ruleprimaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='+'
			{
				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getPlusSignKeyword_0_0());
			}
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionParserRuleCall_0_1());
			}
			this_primaryExpression_1=ruleprimaryExpression
			{
				$current = $this_primaryExpression_1.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getPrimaryExpressionAccess().getExpressionAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_operator_3_0='-'
						{
							newLeafNode(lv_operator_3_0, grammarAccess.getPrimaryExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getPrimaryExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_3_0, "-");
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_1_0());
						}
						lv_operand_4_0=ruleprimaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_4_0,
								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
							afterParserOrEnumRuleCall();
						}
					)
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
						grammarAccess.getPrimaryExpressionAccess().getExpressionAction_2_0(),
						$current);
				}
			)
			(
				(
					(
						(
							lv_operator_6_1='!'
							{
								newLeafNode(lv_operator_6_1, grammarAccess.getPrimaryExpressionAccess().getOperatorExclamationMarkKeyword_2_1_0_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getPrimaryExpressionRule());
								}
								setWithLastConsumed($current, "operator", lv_operator_6_1, null);
							}
							    |
							lv_operator_6_2='not'
							{
								newLeafNode(lv_operator_6_2, grammarAccess.getPrimaryExpressionAccess().getOperatorNotKeyword_2_1_0_0_1());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getPrimaryExpressionRule());
								}
								setWithLastConsumed($current, "operator", lv_operator_6_2, null);
							}
						)
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_2_1_1_0());
						}
						lv_operand_7_0=ruleprimaryExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
							}
							add(
								$current,
								"operand",
								lv_operand_7_0,
								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)
		    |
		(
			otherlv_8='('
			{
				newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
			}
			{
				/* */
			}
			{
				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_3_1());
			}
			this_Expression_9=ruleExpression
			{
				$current = $this_Expression_9.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_10=')'
			{
				newLeafNode(otherlv_10, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2());
			}
		)
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_4());
		}
		this_LiteralExpression_11=ruleLiteralExpression
		{
			$current = $this_LiteralExpression_11.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralExpression
entryRuleLiteralExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralExpressionRule()); }
	iv_ruleLiteralExpression=ruleLiteralExpression
	{ $current=$iv_ruleLiteralExpression.current; }
	EOF;

// Rule LiteralExpression
ruleLiteralExpression returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralBooleanValueParserRuleCall_0());
		}
		this_LiteralBooleanValue_0=ruleLiteralBooleanValue
		{
			$current = $this_LiteralBooleanValue_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralCharacterValueParserRuleCall_1());
		}
		this_LiteralCharacterValue_1=ruleLiteralCharacterValue
		{
			$current = $this_LiteralCharacterValue_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralIntegerValueParserRuleCall_2());
		}
		this_LiteralIntegerValue_2=ruleLiteralIntegerValue
		{
			$current = $this_LiteralIntegerValue_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralRationalValueParserRuleCall_3());
		}
		this_LiteralRationalValue_3=ruleLiteralRationalValue
		{
			$current = $this_LiteralRationalValue_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralFloatValueParserRuleCall_4());
		}
		this_LiteralFloatValue_4=ruleLiteralFloatValue
		{
			$current = $this_LiteralFloatValue_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralStringValueParserRuleCall_5());
		}
		this_LiteralStringValue_5=ruleLiteralStringValue
		{
			$current = $this_LiteralStringValue_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralNullValueParserRuleCall_6());
		}
		this_LiteralNullValue_6=ruleLiteralNullValue
		{
			$current = $this_LiteralNullValue_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralArrayValueParserRuleCall_7());
		}
		this_LiteralArrayValue_7=ruleLiteralArrayValue
		{
			$current = $this_LiteralArrayValue_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralObjectReferenceParserRuleCall_8());
		}
		this_LiteralObjectReference_8=ruleLiteralObjectReference
		{
			$current = $this_LiteralObjectReference_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralVariableReferenceParserRuleCall_9());
		}
		this_LiteralVariableReference_9=ruleLiteralVariableReference
		{
			$current = $this_LiteralVariableReference_9.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralInstanceReferenceParserRuleCall_10());
		}
		this_LiteralInstanceReference_10=ruleLiteralInstanceReference
		{
			$current = $this_LiteralInstanceReference_10.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralArrayValue
entryRuleLiteralArrayValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralArrayValueRule()); }
	iv_ruleLiteralArrayValue=ruleLiteralArrayValue
	{ $current=$iv_ruleLiteralArrayValue.current; }
	EOF;

// Rule LiteralArrayValue
ruleLiteralArrayValue returns [EObject current=null]
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
					grammarAccess.getLiteralArrayValueAccess().getLiteralArrayValueAction_0(),
					$current);
			}
		)
		otherlv_1='['
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralArrayValueAccess().getLeftSquareBracketKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralArrayValueAccess().getValuesValueSpecificationParserRuleCall_2_0_0());
					}
					lv_values_2_0=ruleValueSpecification
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralArrayValueRule());
						}
						add(
							$current,
							"values",
							lv_values_2_0,
							"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getLiteralArrayValueAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getLiteralArrayValueAccess().getValuesValueSpecificationParserRuleCall_2_1_1_0());
						}
						lv_values_4_0=ruleValueSpecification
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getLiteralArrayValueRule());
							}
							add(
								$current,
								"values",
								lv_values_4_0,
								"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5=']'
		{
			newLeafNode(otherlv_5, grammarAccess.getLiteralArrayValueAccess().getRightSquareBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleLiteralObjectReference
entryRuleLiteralObjectReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralObjectReferenceRule()); }
	iv_ruleLiteralObjectReference=ruleLiteralObjectReference
	{ $current=$iv_ruleLiteralObjectReference.current; }
	EOF;

// Rule LiteralObjectReference
ruleLiteralObjectReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='&'
			{
				newLeafNode(otherlv_0, grammarAccess.getLiteralObjectReferenceAccess().getAmpersandKeyword_0());
			}
		)?
		(
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralObjectReferenceRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getLiteralObjectReferenceAccess().getObjectWObjectCrossReference_1_0_0());
					}
					ruleUFI
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralObjectReferenceAccess().getSymbolUFIParserRuleCall_1_1_0());
					}
					lv_symbol_2_0=ruleUFI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralObjectReferenceRule());
						}
						set(
							$current,
							"symbol",
							lv_symbol_2_0,
							"org.eclipse.efm.sew.xtext.SEW.UFI");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleLiteralBooleanValue
entryRuleLiteralBooleanValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralBooleanValueRule()); }
	iv_ruleLiteralBooleanValue=ruleLiteralBooleanValue
	{ $current=$iv_ruleLiteralBooleanValue.current; }
	EOF;

// Rule LiteralBooleanValue
ruleLiteralBooleanValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getLiteralBooleanValueAccess().getValueEBooleanParserRuleCall_0());
			}
			lv_value_0_0=ruleEBoolean
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getLiteralBooleanValueRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.efm.sew.xtext.SEW.EBoolean");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleLiteralCharacterValue
entryRuleLiteralCharacterValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralCharacterValueRule()); }
	iv_ruleLiteralCharacterValue=ruleLiteralCharacterValue
	{ $current=$iv_ruleLiteralCharacterValue.current; }
	EOF;

// Rule LiteralCharacterValue
ruleLiteralCharacterValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getLiteralCharacterValueAccess().getValueECharParserRuleCall_0());
			}
			lv_value_0_0=ruleEChar
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getLiteralCharacterValueRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.efm.sew.xtext.SEW.EChar");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleLiteralIntegerValue
entryRuleLiteralIntegerValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralIntegerValueRule()); }
	iv_ruleLiteralIntegerValue=ruleLiteralIntegerValue
	{ $current=$iv_ruleLiteralIntegerValue.current; }
	EOF;

// Rule LiteralIntegerValue
ruleLiteralIntegerValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getLiteralIntegerValueAccess().getValueELongParserRuleCall_0());
			}
			lv_value_0_0=ruleELong
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getLiteralIntegerValueRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.efm.sew.xtext.SEW.ELong");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleLiteralRationalValue
entryRuleLiteralRationalValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralRationalValueRule()); }
	iv_ruleLiteralRationalValue=ruleLiteralRationalValue
	{ $current=$iv_ruleLiteralRationalValue.current; }
	EOF;

// Rule LiteralRationalValue
ruleLiteralRationalValue returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getLiteralRationalValueAccess().getNumeratorELongParserRuleCall_0_0());
				}
				lv_numerator_0_0=ruleELong
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralRationalValueRule());
					}
					set(
						$current,
						"numerator",
						lv_numerator_0_0,
						"org.eclipse.efm.sew.xtext.SEW.ELong");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='/'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralRationalValueAccess().getSolidusKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralRationalValueAccess().getDenominatorELongParserRuleCall_2_0());
				}
				lv_denominator_2_0=ruleELong
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralRationalValueRule());
					}
					set(
						$current,
						"denominator",
						lv_denominator_2_0,
						"org.eclipse.efm.sew.xtext.SEW.ELong");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralFloatValue
entryRuleLiteralFloatValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralFloatValueRule()); }
	iv_ruleLiteralFloatValue=ruleLiteralFloatValue
	{ $current=$iv_ruleLiteralFloatValue.current; }
	EOF;

// Rule LiteralFloatValue
ruleLiteralFloatValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getLiteralFloatValueAccess().getValueEDoubleParserRuleCall_0());
			}
			lv_value_0_0=ruleEDouble
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getLiteralFloatValueRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.efm.sew.xtext.SEW.EDouble");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleLiteralStringValue
entryRuleLiteralStringValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralStringValueRule()); }
	iv_ruleLiteralStringValue=ruleLiteralStringValue
	{ $current=$iv_ruleLiteralStringValue.current; }
	EOF;

// Rule LiteralStringValue
ruleLiteralStringValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getLiteralStringValueAccess().getValueEStringParserRuleCall_0());
			}
			lv_value_0_0=ruleEString
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getLiteralStringValueRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.efm.sew.xtext.SEW.EString");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleLiteralNullValue
entryRuleLiteralNullValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralNullValueRule()); }
	iv_ruleLiteralNullValue=ruleLiteralNullValue
	{ $current=$iv_ruleLiteralNullValue.current; }
	EOF;

// Rule LiteralNullValue
ruleLiteralNullValue returns [EObject current=null]
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
					grammarAccess.getLiteralNullValueAccess().getLiteralNullValueAction_0(),
					$current);
			}
		)
		otherlv_1='null'
		{
			newLeafNode(otherlv_1, grammarAccess.getLiteralNullValueAccess().getNullKeyword_1());
		}
		(
			otherlv_2='<'
			{
				newLeafNode(otherlv_2, grammarAccess.getLiteralNullValueAccess().getLessThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLiteralNullValueAccess().getTypeXIDParserRuleCall_2_1_0());
					}
					lv_type_3_0=ruleXID
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLiteralNullValueRule());
						}
						set(
							$current,
							"type",
							lv_type_3_0,
							"org.eclipse.efm.sew.xtext.SEW.XID");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4='>'
			{
				newLeafNode(otherlv_4, grammarAccess.getLiteralNullValueAccess().getGreaterThanSignKeyword_2_2());
			}
		)?
	)
;

// Entry rule entryRuleLiteralVariableReference
entryRuleLiteralVariableReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralVariableReferenceRule()); }
	iv_ruleLiteralVariableReference=ruleLiteralVariableReference
	{ $current=$iv_ruleLiteralVariableReference.current; }
	EOF;

// Rule LiteralVariableReference
ruleLiteralVariableReference returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getLiteralVariableReferenceAccess().getLiteralTimeVariableParserRuleCall_0());
		}
		this_LiteralTimeVariable_0=ruleLiteralTimeVariable
		{
			$current = $this_LiteralTimeVariable_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralVariableReferenceAccess().getLiteralTimeDeltaVariableParserRuleCall_1());
		}
		this_LiteralTimeDeltaVariable_1=ruleLiteralTimeDeltaVariable
		{
			$current = $this_LiteralTimeDeltaVariable_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralTimeVariable
entryRuleLiteralTimeVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralTimeVariableRule()); }
	iv_ruleLiteralTimeVariable=ruleLiteralTimeVariable
	{ $current=$iv_ruleLiteralTimeVariable.current; }
	EOF;

// Rule LiteralTimeVariable
ruleLiteralTimeVariable returns [EObject current=null]
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
					grammarAccess.getLiteralTimeVariableAccess().getLiteralTimeVariableAction_0(),
					$current);
			}
		)
		(
			(
				lv_symbol_1_0='$time'
				{
					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralTimeVariableAccess().getSymbolTimeKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralTimeVariableRule());
					}
					setWithLastConsumed($current, "symbol", lv_symbol_1_0, "\$time");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralTimeDeltaVariable
entryRuleLiteralTimeDeltaVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralTimeDeltaVariableRule()); }
	iv_ruleLiteralTimeDeltaVariable=ruleLiteralTimeDeltaVariable
	{ $current=$iv_ruleLiteralTimeDeltaVariable.current; }
	EOF;

// Rule LiteralTimeDeltaVariable
ruleLiteralTimeDeltaVariable returns [EObject current=null]
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
					grammarAccess.getLiteralTimeDeltaVariableAccess().getLiteralTimeDeltaVariableAction_0(),
					$current);
			}
		)
		(
			(
				lv_symbol_1_0='$delta'
				{
					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolDeltaKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralTimeDeltaVariableRule());
					}
					setWithLastConsumed($current, "symbol", lv_symbol_1_0, "\$delta");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralInstanceReference
entryRuleLiteralInstanceReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralInstanceReferenceRule()); }
	iv_ruleLiteralInstanceReference=ruleLiteralInstanceReference
	{ $current=$iv_ruleLiteralInstanceReference.current; }
	EOF;

// Rule LiteralInstanceReference
ruleLiteralInstanceReference returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralThisInstanceParserRuleCall_0());
		}
		this_LiteralThisInstance_0=ruleLiteralThisInstance
		{
			$current = $this_LiteralThisInstance_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSelfInstanceParserRuleCall_1());
		}
		this_LiteralSelfInstance_1=ruleLiteralSelfInstance
		{
			$current = $this_LiteralSelfInstance_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralParentInstanceParserRuleCall_2());
		}
		this_LiteralParentInstance_2=ruleLiteralParentInstance
		{
			$current = $this_LiteralParentInstance_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSuperInstanceParserRuleCall_3());
		}
		this_LiteralSuperInstance_3=ruleLiteralSuperInstance
		{
			$current = $this_LiteralSuperInstance_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSystemInstanceParserRuleCall_4());
		}
		this_LiteralSystemInstance_4=ruleLiteralSystemInstance
		{
			$current = $this_LiteralSystemInstance_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralEnvInstanceParserRuleCall_5());
		}
		this_LiteralEnvInstance_5=ruleLiteralEnvInstance
		{
			$current = $this_LiteralEnvInstance_5.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralThisInstance
entryRuleLiteralThisInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralThisInstanceRule()); }
	iv_ruleLiteralThisInstance=ruleLiteralThisInstance
	{ $current=$iv_ruleLiteralThisInstance.current; }
	EOF;

// Rule LiteralThisInstance
ruleLiteralThisInstance returns [EObject current=null]
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
					grammarAccess.getLiteralThisInstanceAccess().getLiteralThisInstanceAction_0(),
					$current);
			}
		)
		(
			(
				lv_symbol_1_0='$this'
				{
					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralThisInstanceAccess().getSymbolThisKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralThisInstanceRule());
					}
					setWithLastConsumed($current, "symbol", lv_symbol_1_0, "\$this");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralSelfInstance
entryRuleLiteralSelfInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralSelfInstanceRule()); }
	iv_ruleLiteralSelfInstance=ruleLiteralSelfInstance
	{ $current=$iv_ruleLiteralSelfInstance.current; }
	EOF;

// Rule LiteralSelfInstance
ruleLiteralSelfInstance returns [EObject current=null]
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
					grammarAccess.getLiteralSelfInstanceAccess().getLiteralSelfInstanceAction_0(),
					$current);
			}
		)
		(
			(
				lv_symbol_1_0='$self'
				{
					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralSelfInstanceAccess().getSymbolSelfKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralSelfInstanceRule());
					}
					setWithLastConsumed($current, "symbol", lv_symbol_1_0, "\$self");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralParentInstance
entryRuleLiteralParentInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralParentInstanceRule()); }
	iv_ruleLiteralParentInstance=ruleLiteralParentInstance
	{ $current=$iv_ruleLiteralParentInstance.current; }
	EOF;

// Rule LiteralParentInstance
ruleLiteralParentInstance returns [EObject current=null]
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
					grammarAccess.getLiteralParentInstanceAccess().getLiteralParentInstanceAction_0(),
					$current);
			}
		)
		(
			(
				lv_symbol_1_0='$parent'
				{
					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralParentInstanceAccess().getSymbolParentKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralParentInstanceRule());
					}
					setWithLastConsumed($current, "symbol", lv_symbol_1_0, "\$parent");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralSuperInstance
entryRuleLiteralSuperInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralSuperInstanceRule()); }
	iv_ruleLiteralSuperInstance=ruleLiteralSuperInstance
	{ $current=$iv_ruleLiteralSuperInstance.current; }
	EOF;

// Rule LiteralSuperInstance
ruleLiteralSuperInstance returns [EObject current=null]
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
					grammarAccess.getLiteralSuperInstanceAccess().getLiteralSuperInstanceAction_0(),
					$current);
			}
		)
		(
			(
				lv_symbol_1_0='$super'
				{
					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralSuperInstanceAccess().getSymbolSuperKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralSuperInstanceRule());
					}
					setWithLastConsumed($current, "symbol", lv_symbol_1_0, "\$super");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralSystemInstance
entryRuleLiteralSystemInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralSystemInstanceRule()); }
	iv_ruleLiteralSystemInstance=ruleLiteralSystemInstance
	{ $current=$iv_ruleLiteralSystemInstance.current; }
	EOF;

// Rule LiteralSystemInstance
ruleLiteralSystemInstance returns [EObject current=null]
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
					grammarAccess.getLiteralSystemInstanceAccess().getLiteralSystemInstanceAction_0(),
					$current);
			}
		)
		(
			(
				lv_symbol_1_0='$system'
				{
					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralSystemInstanceAccess().getSymbolSystemKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralSystemInstanceRule());
					}
					setWithLastConsumed($current, "symbol", lv_symbol_1_0, "\$system");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralEnvInstance
entryRuleLiteralEnvInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralEnvInstanceRule()); }
	iv_ruleLiteralEnvInstance=ruleLiteralEnvInstance
	{ $current=$iv_ruleLiteralEnvInstance.current; }
	EOF;

// Rule LiteralEnvInstance
ruleLiteralEnvInstance returns [EObject current=null]
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
					grammarAccess.getLiteralEnvInstanceAccess().getLiteralEnvInstanceAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_symbol_1_1='$env'
					{
						newLeafNode(lv_symbol_1_1, grammarAccess.getLiteralEnvInstanceAccess().getSymbolEnvKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralEnvInstanceRule());
						}
						setWithLastConsumed($current, "symbol", lv_symbol_1_1, null);
					}
					    |
					lv_symbol_1_2='env'
					{
						newLeafNode(lv_symbol_1_2, grammarAccess.getLiteralEnvInstanceAccess().getSymbolEnvKeyword_1_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralEnvInstanceRule());
						}
						setWithLastConsumed($current, "symbol", lv_symbol_1_2, null);
					}
				)
			)
		)
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

// Entry rule entryRuleEChar
entryRuleEChar returns [String current=null]:
	{ newCompositeNode(grammarAccess.getECharRule()); }
	iv_ruleEChar=ruleEChar
	{ $current=$iv_ruleEChar.current.getText(); }
	EOF;

// Rule EChar
ruleEChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
		newLeafNode(this_CHARACTER_0, grammarAccess.getECharAccess().getCHARACTERTerminalRuleCall());
	}
;

// Entry rule entryRuleELong
entryRuleELong returns [String current=null]:
	{ newCompositeNode(grammarAccess.getELongRule()); }
	iv_ruleELong=ruleELong
	{ $current=$iv_ruleELong.current.getText(); }
	EOF;

// Rule ELong
ruleELong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
				newLeafNode(kw, grammarAccess.getELongAccess().getHyphenMinusKeyword_0());
			}
		)?
		this_INT_1=RULE_INT
		{
			$current.merge(this_INT_1);
		}
		{
			newLeafNode(this_INT_1, grammarAccess.getELongAccess().getINTTerminalRuleCall_1());
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

// Entry rule entryRuleEBigDecimal
entryRuleEBigDecimal returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEBigDecimalRule()); }
	iv_ruleEBigDecimal=ruleEBigDecimal
	{ $current=$iv_ruleEBigDecimal.current.getText(); }
	EOF;

// Rule EBigDecimal
ruleEBigDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			this_INT_0=RULE_INT
			{
				$current.merge(this_INT_0);
			}
			{
				newLeafNode(this_INT_0, grammarAccess.getEBigDecimalAccess().getINTTerminalRuleCall_0());
			}
		)?
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEBigDecimalAccess().getFullStopKeyword_1());
		}
		this_INT_2=RULE_INT
		{
			$current.merge(this_INT_2);
		}
		{
			newLeafNode(this_INT_2, grammarAccess.getEBigDecimalAccess().getINTTerminalRuleCall_2());
		}
	)
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

// Entry rule entryRuleDeprecatedReservedWord
entryRuleDeprecatedReservedWord returns [String current=null]:
	{ newCompositeNode(grammarAccess.getDeprecatedReservedWordRule()); }
	iv_ruleDeprecatedReservedWord=ruleDeprecatedReservedWord
	{ $current=$iv_ruleDeprecatedReservedWord.current.getText(); }
	EOF;

// Rule DeprecatedReservedWord
ruleDeprecatedReservedWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='form'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getFormKeyword_0());
		}
		    |
		kw='endform'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getEndformKeyword_1());
		}
		    |
		kw='prototype'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getPrototypeKeyword_2());
		}
		    |
		kw='endprototype'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getEndprototypeKeyword_3());
		}
		    |
		kw='section'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getSectionKeyword_4());
		}
		    |
		kw='endsection'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getEndsectionKeyword_5());
		}
	)
;

// Entry rule entryRuleDeprecatedObject
entryRuleDeprecatedObject returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeprecatedObjectRule()); }
	iv_ruleDeprecatedObject=ruleDeprecatedObject
	{ $current=$iv_ruleDeprecatedObject.current; }
	EOF;

// Rule DeprecatedObject
ruleDeprecatedObject returns [EObject current=null]
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
						grammarAccess.getDeprecatedObjectAccess().getWObjectAction_0_0(),
						$current);
				}
			)
			otherlv_1='form'
			{
				newLeafNode(otherlv_1, grammarAccess.getDeprecatedObjectAccess().getFormKeyword_0_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getNameUFIParserRuleCall_0_2_0());
					}
					lv_name_2_0=ruleUFI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
						}
						set(
							$current,
							"name",
							lv_name_2_0,
							"org.eclipse.efm.sew.xtext.SEW.UFI");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getDescriptionEStringParserRuleCall_0_3_0());
					}
					lv_description_3_0=ruleEString
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
						}
						set(
							$current,
							"description",
							lv_description_3_0,
							"org.eclipse.efm.sew.xtext.SEW.EString");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_4='as'
			{
				newLeafNode(otherlv_4, grammarAccess.getDeprecatedObjectAccess().getAsKeyword_0_4());
			}
			(
				otherlv_5='&'
				{
					newLeafNode(otherlv_5, grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_0_5());
				}
			)?
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getTypeUFIParserRuleCall_0_6_0());
					}
					lv_type_6_0=ruleUFI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
						}
						set(
							$current,
							"type",
							lv_type_6_0,
							"org.eclipse.efm.sew.xtext.SEW.UFI");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_7='is'
			{
				newLeafNode(otherlv_7, grammarAccess.getDeprecatedObjectAccess().getIsKeyword_0_7());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getElementDeprecatedPropertyParserRuleCall_0_8_0());
					}
					lv_element_8_0=ruleDeprecatedProperty
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
						}
						add(
							$current,
							"element",
							lv_element_8_0,
							"org.eclipse.efm.sew.xtext.SEW.DeprecatedProperty");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_9='endform'
			{
				newLeafNode(otherlv_9, grammarAccess.getDeprecatedObjectAccess().getEndformKeyword_0_9());
			}
		)
		    |
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getDeprecatedObjectAccess().getWObjectAction_1_0(),
						$current);
				}
			)
			otherlv_11='prototype'
			{
				newLeafNode(otherlv_11, grammarAccess.getDeprecatedObjectAccess().getPrototypeKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getNameUFIParserRuleCall_1_2_0());
					}
					lv_name_12_0=ruleUFI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
						}
						set(
							$current,
							"name",
							lv_name_12_0,
							"org.eclipse.efm.sew.xtext.SEW.UFI");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getDescriptionEStringParserRuleCall_1_3_0());
					}
					lv_description_13_0=ruleEString
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
						}
						set(
							$current,
							"description",
							lv_description_13_0,
							"org.eclipse.efm.sew.xtext.SEW.EString");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_14='as'
			{
				newLeafNode(otherlv_14, grammarAccess.getDeprecatedObjectAccess().getAsKeyword_1_4());
			}
			(
				otherlv_15='&'
				{
					newLeafNode(otherlv_15, grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_1_5());
				}
			)?
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getTypeUFIParserRuleCall_1_6_0());
					}
					lv_type_16_0=ruleUFI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
						}
						set(
							$current,
							"type",
							lv_type_16_0,
							"org.eclipse.efm.sew.xtext.SEW.UFI");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_17='is'
			{
				newLeafNode(otherlv_17, grammarAccess.getDeprecatedObjectAccess().getIsKeyword_1_7());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getElementDeprecatedPropertyParserRuleCall_1_8_0());
					}
					lv_element_18_0=ruleDeprecatedProperty
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
						}
						add(
							$current,
							"element",
							lv_element_18_0,
							"org.eclipse.efm.sew.xtext.SEW.DeprecatedProperty");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_19='endprototype'
			{
				newLeafNode(otherlv_19, grammarAccess.getDeprecatedObjectAccess().getEndprototypeKeyword_1_9());
			}
		)
	)
;

// Entry rule entryRuleDeprecatedProperty
entryRuleDeprecatedProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeprecatedPropertyRule()); }
	iv_ruleDeprecatedProperty=ruleDeprecatedProperty
	{ $current=$iv_ruleDeprecatedProperty.current; }
	EOF;

// Rule DeprecatedProperty
ruleDeprecatedProperty returns [EObject current=null]
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
			newCompositeNode(grammarAccess.getDeprecatedPropertyAccess().getDeprecatedSectionParserRuleCall_0());
		}
		this_DeprecatedSection_0=ruleDeprecatedSection
		{
			$current = $this_DeprecatedSection_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getDeprecatedPropertyAccess().getDeprecatedAttributeParserRuleCall_1());
		}
		this_DeprecatedAttribute_1=ruleDeprecatedAttribute
		{
			$current = $this_DeprecatedAttribute_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleDeprecatedSection
entryRuleDeprecatedSection returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeprecatedSectionRule()); }
	iv_ruleDeprecatedSection=ruleDeprecatedSection
	{ $current=$iv_ruleDeprecatedSection.current; }
	EOF;

// Rule DeprecatedSection
ruleDeprecatedSection returns [EObject current=null]
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
						grammarAccess.getDeprecatedSectionAccess().getWSectionAction_0_0(),
						$current);
				}
			)
			otherlv_1='section'
			{
				newLeafNode(otherlv_1, grammarAccess.getDeprecatedSectionAccess().getSectionKeyword_0_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_0_2_0());
					}
					lv_name_2_0=ruleXID
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
						}
						set(
							$current,
							"name",
							lv_name_2_0,
							"org.eclipse.efm.sew.xtext.SEW.XID");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_0_3_0_0());
						}
						lv_element_3_1=ruleDeprecatedAttribute
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
							}
							add(
								$current,
								"element",
								lv_element_3_1,
								"org.eclipse.efm.sew.xtext.SEW.DeprecatedAttribute");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_0_3_0_1());
						}
						lv_element_3_2=ruleDeprecatedObject
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
							}
							add(
								$current,
								"element",
								lv_element_3_2,
								"org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_0_3_0_2());
						}
						lv_element_3_3=ruleObject
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
							}
							add(
								$current,
								"element",
								lv_element_3_3,
								"org.eclipse.efm.sew.xtext.SEW.Object");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_4='endsection'
			{
				newLeafNode(otherlv_4, grammarAccess.getDeprecatedSectionAccess().getEndsectionKeyword_0_4());
			}
			(
				{
					/* */
				}
				{
					newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getXIDParserRuleCall_0_5());
				}
				ruleXID
				{
					afterParserOrEnumRuleCall();
				}
			)?
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_1_0_0());
					}
					lv_name_6_0=ruleXID
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
						}
						set(
							$current,
							"name",
							lv_name_6_0,
							"org.eclipse.efm.sew.xtext.SEW.XID");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getDescriptionEStringParserRuleCall_1_1_0());
					}
					lv_description_7_0=ruleEString
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
						}
						set(
							$current,
							"description",
							lv_description_7_0,
							"org.eclipse.efm.sew.xtext.SEW.EString");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			(
				(
					otherlv_8='['
					{
						newLeafNode(otherlv_8, grammarAccess.getDeprecatedSectionAccess().getLeftSquareBracketKeyword_1_2_0_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_1_2_0_1_0_0());
								}
								lv_element_9_1=ruleDeprecatedAttribute
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
									}
									add(
										$current,
										"element",
										lv_element_9_1,
										"org.eclipse.efm.sew.xtext.SEW.DeprecatedAttribute");
									afterParserOrEnumRuleCall();
								}
								    |
								{
									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_1_2_0_1_0_1());
								}
								lv_element_9_2=ruleDeprecatedObject
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
									}
									add(
										$current,
										"element",
										lv_element_9_2,
										"org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
									afterParserOrEnumRuleCall();
								}
								    |
								{
									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_0_1_0_2());
								}
								lv_element_9_3=ruleObject
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
									}
									add(
										$current,
										"element",
										lv_element_9_3,
										"org.eclipse.efm.sew.xtext.SEW.Object");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_10=']'
					{
						newLeafNode(otherlv_10, grammarAccess.getDeprecatedSectionAccess().getRightSquareBracketKeyword_1_2_0_2());
					}
				)
				    |
				(
					otherlv_11=':'
					{
						newLeafNode(otherlv_11, grammarAccess.getDeprecatedSectionAccess().getColonKeyword_1_2_1_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_1_2_1_1_0_0());
								}
								lv_element_12_1=ruleDeprecatedAttribute
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
									}
									add(
										$current,
										"element",
										lv_element_12_1,
										"org.eclipse.efm.sew.xtext.SEW.DeprecatedAttribute");
									afterParserOrEnumRuleCall();
								}
								    |
								{
									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_1_2_1_1_0_1());
								}
								lv_element_12_2=ruleDeprecatedObject
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
									}
									add(
										$current,
										"element",
										lv_element_12_2,
										"org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
									afterParserOrEnumRuleCall();
								}
								    |
								{
									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_1_1_0_2());
								}
								lv_element_12_3=ruleObject
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
									}
									add(
										$current,
										"element",
										lv_element_12_3,
										"org.eclipse.efm.sew.xtext.SEW.Object");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
				)
			)
		)
	)
;

// Entry rule entryRuleDeprecatedAttribute
entryRuleDeprecatedAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeprecatedAttributeRule()); }
	iv_ruleDeprecatedAttribute=ruleDeprecatedAttribute
	{ $current=$iv_ruleDeprecatedAttribute.current; }
	EOF;

// Rule DeprecatedAttribute
ruleDeprecatedAttribute returns [EObject current=null]
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
					grammarAccess.getDeprecatedAttributeAccess().getWAttributeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getDeprecatedAttributeAccess().getNameDeprecatedAttributeIDParserRuleCall_1_0());
				}
				lv_name_1_0=ruleDeprecatedAttributeID
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeprecatedAttributeRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.efm.sew.xtext.SEW.DeprecatedAttributeID");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getDeprecatedAttributeAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDeprecatedAttributeAccess().getValueValueSpecificationParserRuleCall_3_0());
				}
				lv_value_3_0=ruleValueSpecification
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeprecatedAttributeRule());
					}
					set(
						$current,
						"value",
						lv_value_3_0,
						"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=';'
			{
				newLeafNode(otherlv_4, grammarAccess.getDeprecatedAttributeAccess().getSemicolonKeyword_4());
			}
		)?
	)
;

// Entry rule entryRuleDeprecatedAttributeID
entryRuleDeprecatedAttributeID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getDeprecatedAttributeIDRule()); }
	iv_ruleDeprecatedAttributeID=ruleDeprecatedAttributeID
	{ $current=$iv_ruleDeprecatedAttributeID.current.getText(); }
	EOF;

// Rule DeprecatedAttributeID
ruleDeprecatedAttributeID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getDeprecatedAttributeIDAccess().getXIDParserRuleCall_0());
		}
		this_XID_0=ruleXID
		{
			$current.merge(this_XID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		this_AT_IDENTIFIER_1=RULE_AT_IDENTIFIER
		{
			$current.merge(this_AT_IDENTIFIER_1);
		}
		{
			newLeafNode(this_AT_IDENTIFIER_1, grammarAccess.getDeprecatedAttributeIDAccess().getAT_IDENTIFIERTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleDeprecatedExpression
entryRuleDeprecatedExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeprecatedExpressionRule()); }
	iv_ruleDeprecatedExpression=ruleDeprecatedExpression
	{ $current=$iv_ruleDeprecatedExpression.current; }
	EOF;

// Rule DeprecatedExpression
ruleDeprecatedExpression returns [EObject current=null]
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
					grammarAccess.getDeprecatedExpressionAccess().getExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='${'
		{
			newLeafNode(otherlv_1, grammarAccess.getDeprecatedExpressionAccess().getDollarSignLeftCurlyBracketKeyword_1());
		}
		(
			(
				(
					lv_operator_2_1='|;|'
					{
						newLeafNode(lv_operator_2_1, grammarAccess.getDeprecatedExpressionAccess().getOperatorVerticalLineSemicolonVerticalLineKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getDeprecatedExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_1, null);
					}
					    |
					lv_operator_2_2='|i|'
					{
						newLeafNode(lv_operator_2_2, grammarAccess.getDeprecatedExpressionAccess().getOperatorIKeyword_2_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getDeprecatedExpressionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_2, null);
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getDeprecatedExpressionAccess().getOperandValueSpecificationParserRuleCall_3_0());
				}
				lv_operand_3_0=ruleValueSpecification
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeprecatedExpressionRule());
					}
					add(
						$current,
						"operand",
						lv_operand_3_0,
						"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getDeprecatedExpressionAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

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
