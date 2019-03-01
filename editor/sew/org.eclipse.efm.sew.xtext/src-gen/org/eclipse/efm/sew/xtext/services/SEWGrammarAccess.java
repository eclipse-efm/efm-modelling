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
package org.eclipse.efm.sew.xtext.services;

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
public class SEWGrammarAccess extends AbstractGrammarElementFinder {
	
	public class WorkflowElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.Workflow");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSEWorkflowAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cPrologParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_0 = (Assignment)cGroup_2_0.eContents().get(0);
		private final Alternatives cTypeAlternatives_2_0_0_0 = (Alternatives)cTypeAssignment_2_0_0.eContents().get(0);
		private final Keyword cTypeWorkflowKeyword_2_0_0_0_0 = (Keyword)cTypeAlternatives_2_0_0_0.eContents().get(0);
		private final Keyword cTypeSymbexWorkflowKeyword_2_0_0_0_1 = (Keyword)cTypeAlternatives_2_0_0_0.eContents().get(1);
		private final Assignment cNameAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cNameUFIParserRuleCall_2_0_1_0 = (RuleCall)cNameAssignment_2_0_1.eContents().get(0);
		private final Assignment cDescriptionAssignment_2_0_2 = (Assignment)cGroup_2_0.eContents().get(2);
		private final RuleCall cDescriptionEStringParserRuleCall_2_0_2_0 = (RuleCall)cDescriptionAssignment_2_0_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_0_3 = (Keyword)cGroup_2_0.eContents().get(3);
		private final Assignment cElementAssignment_2_0_4 = (Assignment)cGroup_2_0.eContents().get(4);
		private final Alternatives cElementAlternatives_2_0_4_0 = (Alternatives)cElementAssignment_2_0_4.eContents().get(0);
		private final RuleCall cElementObjectParserRuleCall_2_0_4_0_0 = (RuleCall)cElementAlternatives_2_0_4_0.eContents().get(0);
		private final RuleCall cElementPropertyParserRuleCall_2_0_4_0_1 = (RuleCall)cElementAlternatives_2_0_4_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_2_0_5 = (Keyword)cGroup_2_0.eContents().get(5);
		private final Assignment cElementAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final Alternatives cElementAlternatives_2_1_0 = (Alternatives)cElementAssignment_2_1.eContents().get(0);
		private final RuleCall cElementObjectParserRuleCall_2_1_0_0 = (RuleCall)cElementAlternatives_2_1_0.eContents().get(0);
		private final RuleCall cElementPropertyParserRuleCall_2_1_0_1 = (RuleCall)cElementAlternatives_2_1_0.eContents().get(1);
		private final Assignment cElementAssignment_2_2 = (Assignment)cAlternatives_2.eContents().get(2);
		private final RuleCall cElementDeprecatedObjectParserRuleCall_2_2_0 = (RuleCall)cElementAssignment_2_2.eContents().get(0);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Symbolic Execution Workflow Specification
		//////////////////////////////////////////////////////////////////////////////////
		//Workflow sew::SEWorkflow:
		//	{sew::SEWorkflow} Prolog? (type=('workflow' | 'symbex-workflow') name=UFI? description=EString?
		//	'{'
		//	element+=(Object | Property)*
		//	'}'
		//	// for Xtext Embeded Editor
		//	| element+=(Object | Property)*
		//	// Deprecated Object as FAVM Workflow
		//	| element+=DeprecatedObject);
		@Override public ParserRule getRule() { return rule; }
		
		//{sew::SEWorkflow} Prolog? (type=('workflow' | 'symbex-workflow') name=UFI? description=EString? '{' element+=(Object |
		//Property)* '}' // for Xtext Embeded Editor
		//| element+=(Object | Property)* // Deprecated Object as FAVM Workflow
		//| element+=DeprecatedObject)
		public Group getGroup() { return cGroup; }
		
		//{sew::SEWorkflow}
		public Action getSEWorkflowAction_0() { return cSEWorkflowAction_0; }
		
		//Prolog?
		public RuleCall getPrologParserRuleCall_1() { return cPrologParserRuleCall_1; }
		
		//type=('workflow' | 'symbex-workflow') name=UFI? description=EString? '{' element+=(Object | Property)* '}' // for Xtext Embeded Editor
		//| element+=(Object | Property)* // Deprecated Object as FAVM Workflow
		//| element+=DeprecatedObject
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//type=('workflow' | 'symbex-workflow') name=UFI? description=EString? '{' element+=(Object | Property)* '}'
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//type=('workflow' | 'symbex-workflow')
		public Assignment getTypeAssignment_2_0_0() { return cTypeAssignment_2_0_0; }
		
		//('workflow' | 'symbex-workflow')
		public Alternatives getTypeAlternatives_2_0_0_0() { return cTypeAlternatives_2_0_0_0; }
		
		//'workflow'
		public Keyword getTypeWorkflowKeyword_2_0_0_0_0() { return cTypeWorkflowKeyword_2_0_0_0_0; }
		
		//'symbex-workflow'
		public Keyword getTypeSymbexWorkflowKeyword_2_0_0_0_1() { return cTypeSymbexWorkflowKeyword_2_0_0_0_1; }
		
		//name=UFI?
		public Assignment getNameAssignment_2_0_1() { return cNameAssignment_2_0_1; }
		
		//UFI
		public RuleCall getNameUFIParserRuleCall_2_0_1_0() { return cNameUFIParserRuleCall_2_0_1_0; }
		
		//description=EString?
		public Assignment getDescriptionAssignment_2_0_2() { return cDescriptionAssignment_2_0_2; }
		
		//EString
		public RuleCall getDescriptionEStringParserRuleCall_2_0_2_0() { return cDescriptionEStringParserRuleCall_2_0_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0_3() { return cLeftCurlyBracketKeyword_2_0_3; }
		
		//element+=(Object | Property)*
		public Assignment getElementAssignment_2_0_4() { return cElementAssignment_2_0_4; }
		
		//(Object | Property)
		public Alternatives getElementAlternatives_2_0_4_0() { return cElementAlternatives_2_0_4_0; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_2_0_4_0_0() { return cElementObjectParserRuleCall_2_0_4_0_0; }
		
		//Property
		public RuleCall getElementPropertyParserRuleCall_2_0_4_0_1() { return cElementPropertyParserRuleCall_2_0_4_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2_0_5() { return cRightCurlyBracketKeyword_2_0_5; }
		
		//element+=(Object | Property)*
		public Assignment getElementAssignment_2_1() { return cElementAssignment_2_1; }
		
		//(Object | Property)
		public Alternatives getElementAlternatives_2_1_0() { return cElementAlternatives_2_1_0; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_2_1_0_0() { return cElementObjectParserRuleCall_2_1_0_0; }
		
		//Property
		public RuleCall getElementPropertyParserRuleCall_2_1_0_1() { return cElementPropertyParserRuleCall_2_1_0_1; }
		
		//element+=DeprecatedObject
		public Assignment getElementAssignment_2_2() { return cElementAssignment_2_2; }
		
		//DeprecatedObject
		public RuleCall getElementDeprecatedObjectParserRuleCall_2_2_0() { return cElementDeprecatedObjectParserRuleCall_2_2_0; }
	}
	public class PrologElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.Prolog");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cSewKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cFavmKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Keyword cWorkflowKeyword_2_0 = (Keyword)cAlternatives_2.eContents().get(0);
		private final Keyword cSewKeyword_2_1 = (Keyword)cAlternatives_2.eContents().get(1);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cAlternatives_3.eContents().get(0);
		private final Keyword cCommaKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Keyword cVersionKeyword_3_0_1 = (Keyword)cGroup_3_0.eContents().get(1);
		private final RuleCall cEDoubleParserRuleCall_3_0_2 = (RuleCall)cGroup_3_0.eContents().get(2);
		private final RuleCall cUFIParserRuleCall_3_1 = (RuleCall)cAlternatives_3.eContents().get(1);
		private final RuleCall cEStringParserRuleCall_3_2 = (RuleCall)cAlternatives_3.eContents().get(2);
		private final Keyword cGreaterThanSignColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Prolog:
		//	('@sew' | '@favm') '<' ('workflow' | 'sew') (',' 'version:'? EDouble | UFI | EString)? '>:';
		@Override public ParserRule getRule() { return rule; }
		
		//('@sew' | '@favm') '<' ('workflow' | 'sew') (',' 'version:'? EDouble | UFI | EString)? '>:'
		public Group getGroup() { return cGroup; }
		
		//'@sew' | '@favm'
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//'@sew'
		public Keyword getSewKeyword_0_0() { return cSewKeyword_0_0; }
		
		//'@favm'
		public Keyword getFavmKeyword_0_1() { return cFavmKeyword_0_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1() { return cLessThanSignKeyword_1; }
		
		//'workflow' | 'sew'
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//'workflow'
		public Keyword getWorkflowKeyword_2_0() { return cWorkflowKeyword_2_0; }
		
		//'sew'
		public Keyword getSewKeyword_2_1() { return cSewKeyword_2_1; }
		
		//(',' 'version:'? EDouble | UFI | EString)?
		public Alternatives getAlternatives_3() { return cAlternatives_3; }
		
		//',' 'version:'? EDouble
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//','
		public Keyword getCommaKeyword_3_0_0() { return cCommaKeyword_3_0_0; }
		
		//'version:'?
		public Keyword getVersionKeyword_3_0_1() { return cVersionKeyword_3_0_1; }
		
		//EDouble
		public RuleCall getEDoubleParserRuleCall_3_0_2() { return cEDoubleParserRuleCall_3_0_2; }
		
		//UFI
		public RuleCall getUFIParserRuleCall_3_1() { return cUFIParserRuleCall_3_1; }
		
		//EString
		public RuleCall getEStringParserRuleCall_3_2() { return cEStringParserRuleCall_3_2; }
		
		//'>:'
		public Keyword getGreaterThanSignColonKeyword_4() { return cGreaterThanSignColonKeyword_4; }
	}
	public class ReservedWordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.ReservedWord");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cWorkflowKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cSewKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final RuleCall cDeprecatedReservedWordParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// [ Qualified ] Identifier
		//////////////////////////////////////////////////////////////////////////////////
		//ReservedWord:
		//	'workflow' | 'sew'
		//	// Deprecated
		//	| DeprecatedReservedWord;
		@Override public ParserRule getRule() { return rule; }
		
		//'workflow' | 'sew' // Deprecated
		//| DeprecatedReservedWord
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'workflow'
		public Keyword getWorkflowKeyword_0() { return cWorkflowKeyword_0; }
		
		//'sew'
		public Keyword getSewKeyword_1() { return cSewKeyword_1; }
		
		//DeprecatedReservedWord
		public RuleCall getDeprecatedReservedWordParserRuleCall_2() { return cDeprecatedReservedWordParserRuleCall_2; }
	}
	public class XIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.XID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cReservedWordParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cXIDENDIFIERTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//XID:
		//	ReservedWord | XIDENDIFIER;
		@Override public ParserRule getRule() { return rule; }
		
		//ReservedWord | XIDENDIFIER
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ReservedWord
		public RuleCall getReservedWordParserRuleCall_0() { return cReservedWordParserRuleCall_0; }
		
		//XIDENDIFIER
		public RuleCall getXIDENDIFIERTerminalRuleCall_1() { return cXIDENDIFIERTerminalRuleCall_1; }
	}
	public class UFIElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.UFI");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_1_0 = (Alternatives)cGroup_1.eContents().get(0);
		private final Keyword cColonColonKeyword_1_0_0 = (Keyword)cAlternatives_1_0.eContents().get(0);
		private final Keyword cFullStopKeyword_1_0_1 = (Keyword)cAlternatives_1_0.eContents().get(1);
		private final RuleCall cXIDParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//UFI:
		//	XID (('::' | '.') XID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//XID (('::' | '.') XID)*
		public Group getGroup() { return cGroup; }
		
		//XID
		public RuleCall getXIDParserRuleCall_0() { return cXIDParserRuleCall_0; }
		
		//(('::' | '.') XID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'::' | '.'
		public Alternatives getAlternatives_1_0() { return cAlternatives_1_0; }
		
		//'::'
		public Keyword getColonColonKeyword_1_0_0() { return cColonColonKeyword_1_0_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0_1() { return cFullStopKeyword_1_0_1; }
		
		//XID
		public RuleCall getXIDParserRuleCall_1_1() { return cXIDParserRuleCall_1_1; }
	}
	public class ObjectElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.Object");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cWObjectAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cTypeAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cTypeUFIParserRuleCall_0_1_0 = (RuleCall)cTypeAssignment_0_1.eContents().get(0);
		private final Assignment cNameAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cNameUFIParserRuleCall_0_2_0 = (RuleCall)cNameAssignment_0_2.eContents().get(0);
		private final Assignment cDescriptionAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final RuleCall cDescriptionEStringParserRuleCall_0_3_0 = (RuleCall)cDescriptionAssignment_0_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_0_4 = (Keyword)cGroup_0.eContents().get(4);
		private final Assignment cElementAssignment_0_5 = (Assignment)cGroup_0.eContents().get(5);
		private final Alternatives cElementAlternatives_0_5_0 = (Alternatives)cElementAssignment_0_5.eContents().get(0);
		private final RuleCall cElementObjectParserRuleCall_0_5_0_0 = (RuleCall)cElementAlternatives_0_5_0.eContents().get(0);
		private final RuleCall cElementPropertyParserRuleCall_0_5_0_1 = (RuleCall)cElementAlternatives_0_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_0_6 = (Keyword)cGroup_0.eContents().get(6);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cWObjectAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cNameAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cNameUFIParserRuleCall_1_1_0 = (RuleCall)cNameAssignment_1_1.eContents().get(0);
		private final Alternatives cAlternatives_1_2 = (Alternatives)cGroup_1.eContents().get(2);
		private final Keyword cColonEqualsSignKeyword_1_2_0 = (Keyword)cAlternatives_1_2.eContents().get(0);
		private final Keyword cPlusSignColonEqualsSignKeyword_1_2_1 = (Keyword)cAlternatives_1_2.eContents().get(1);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Assignment cTypeAssignment_1_3_0 = (Assignment)cGroup_1_3.eContents().get(0);
		private final RuleCall cTypeUFIParserRuleCall_1_3_0_0 = (RuleCall)cTypeAssignment_1_3_0.eContents().get(0);
		private final Assignment cDescriptionAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final RuleCall cDescriptionEStringParserRuleCall_1_3_1_0 = (RuleCall)cDescriptionAssignment_1_3_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1_4 = (Keyword)cGroup_1.eContents().get(4);
		private final Assignment cElementAssignment_1_5 = (Assignment)cGroup_1.eContents().get(5);
		private final Alternatives cElementAlternatives_1_5_0 = (Alternatives)cElementAssignment_1_5.eContents().get(0);
		private final RuleCall cElementObjectParserRuleCall_1_5_0_0 = (RuleCall)cElementAlternatives_1_5_0.eContents().get(0);
		private final RuleCall cElementPropertyParserRuleCall_1_5_0_1 = (RuleCall)cElementAlternatives_1_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_1_6 = (Keyword)cGroup_1.eContents().get(6);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Object Configuration Specification
		//////////////////////////////////////////////////////////////////////////////////
		//Object sew::WObject:
		//	{sew::WObject} type=UFI name=UFI? description=EString?
		//	'{'
		//	element+=(Object | Property)*
		//	'}'
		//	| {sew::WObject} name=UFI (':=' | '+:=') (type=UFI description=EString?)?
		//	'{'
		//	element+=(Object | Property)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{sew::WObject} type=UFI name=UFI? description=EString? '{' element+=(Object | Property)* '}' | {sew::WObject} name=UFI
		//(':=' | '+:=') (type=UFI description=EString?)? '{' element+=(Object | Property)* '}'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{sew::WObject} type=UFI name=UFI? description=EString? '{' element+=(Object | Property)* '}'
		public Group getGroup_0() { return cGroup_0; }
		
		//{sew::WObject}
		public Action getWObjectAction_0_0() { return cWObjectAction_0_0; }
		
		//type=UFI
		public Assignment getTypeAssignment_0_1() { return cTypeAssignment_0_1; }
		
		//UFI
		public RuleCall getTypeUFIParserRuleCall_0_1_0() { return cTypeUFIParserRuleCall_0_1_0; }
		
		//name=UFI?
		public Assignment getNameAssignment_0_2() { return cNameAssignment_0_2; }
		
		//UFI
		public RuleCall getNameUFIParserRuleCall_0_2_0() { return cNameUFIParserRuleCall_0_2_0; }
		
		//description=EString?
		public Assignment getDescriptionAssignment_0_3() { return cDescriptionAssignment_0_3; }
		
		//EString
		public RuleCall getDescriptionEStringParserRuleCall_0_3_0() { return cDescriptionEStringParserRuleCall_0_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0_4() { return cLeftCurlyBracketKeyword_0_4; }
		
		//element+=(Object | Property)*
		public Assignment getElementAssignment_0_5() { return cElementAssignment_0_5; }
		
		//(Object | Property)
		public Alternatives getElementAlternatives_0_5_0() { return cElementAlternatives_0_5_0; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_0_5_0_0() { return cElementObjectParserRuleCall_0_5_0_0; }
		
		//Property
		public RuleCall getElementPropertyParserRuleCall_0_5_0_1() { return cElementPropertyParserRuleCall_0_5_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_0_6() { return cRightCurlyBracketKeyword_0_6; }
		
		//{sew::WObject} name=UFI (':=' | '+:=') (type=UFI description=EString?)? '{' element+=(Object | Property)* '}'
		public Group getGroup_1() { return cGroup_1; }
		
		//{sew::WObject}
		public Action getWObjectAction_1_0() { return cWObjectAction_1_0; }
		
		//name=UFI
		public Assignment getNameAssignment_1_1() { return cNameAssignment_1_1; }
		
		//UFI
		public RuleCall getNameUFIParserRuleCall_1_1_0() { return cNameUFIParserRuleCall_1_1_0; }
		
		//':=' | '+:='
		public Alternatives getAlternatives_1_2() { return cAlternatives_1_2; }
		
		//':='
		public Keyword getColonEqualsSignKeyword_1_2_0() { return cColonEqualsSignKeyword_1_2_0; }
		
		//'+:='
		public Keyword getPlusSignColonEqualsSignKeyword_1_2_1() { return cPlusSignColonEqualsSignKeyword_1_2_1; }
		
		//(type=UFI description=EString?)?
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//type=UFI
		public Assignment getTypeAssignment_1_3_0() { return cTypeAssignment_1_3_0; }
		
		//UFI
		public RuleCall getTypeUFIParserRuleCall_1_3_0_0() { return cTypeUFIParserRuleCall_1_3_0_0; }
		
		//description=EString?
		public Assignment getDescriptionAssignment_1_3_1() { return cDescriptionAssignment_1_3_1; }
		
		//EString
		public RuleCall getDescriptionEStringParserRuleCall_1_3_1_0() { return cDescriptionEStringParserRuleCall_1_3_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1_4() { return cLeftCurlyBracketKeyword_1_4; }
		
		//element+=(Object | Property)*
		public Assignment getElementAssignment_1_5() { return cElementAssignment_1_5; }
		
		//(Object | Property)
		public Alternatives getElementAlternatives_1_5_0() { return cElementAlternatives_1_5_0; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_1_5_0_0() { return cElementObjectParserRuleCall_1_5_0_0; }
		
		//Property
		public RuleCall getElementPropertyParserRuleCall_1_5_0_1() { return cElementPropertyParserRuleCall_1_5_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_1_6() { return cRightCurlyBracketKeyword_1_6; }
	}
	public class PropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.Property");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSectionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAttributeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Property Specification
		//////////////////////////////////////////////////////////////////////////////////
		//Property sew::WProperty:
		//	Section
		//	| Attribute;
		@Override public ParserRule getRule() { return rule; }
		
		//Section | Attribute
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Section
		public RuleCall getSectionParserRuleCall_0() { return cSectionParserRuleCall_0; }
		
		//Attribute
		public RuleCall getAttributeParserRuleCall_1() { return cAttributeParserRuleCall_1; }
	}
	public class SectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.Section");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameXIDParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Assignment cDescriptionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cDescriptionEStringParserRuleCall_1_0 = (RuleCall)cDescriptionAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_2_0_0 = (Keyword)cGroup_2_0.eContents().get(0);
		private final Assignment cElementAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final Alternatives cElementAlternatives_2_0_1_0 = (Alternatives)cElementAssignment_2_0_1.eContents().get(0);
		private final RuleCall cElementObjectParserRuleCall_2_0_1_0_0 = (RuleCall)cElementAlternatives_2_0_1_0.eContents().get(0);
		private final RuleCall cElementAttributeParserRuleCall_2_0_1_0_1 = (RuleCall)cElementAlternatives_2_0_1_0.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_2_0_2 = (Keyword)cGroup_2_0.eContents().get(2);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Keyword cColonKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cElementAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final Alternatives cElementAlternatives_2_1_1_0 = (Alternatives)cElementAssignment_2_1_1.eContents().get(0);
		private final RuleCall cElementObjectParserRuleCall_2_1_1_0_0 = (RuleCall)cElementAlternatives_2_1_1_0.eContents().get(0);
		private final RuleCall cElementAttributeParserRuleCall_2_1_1_0_1 = (RuleCall)cElementAlternatives_2_1_1_0.eContents().get(1);
		
		//Section sew::WSection:
		//	name=XID description=EString? ('[' element+=(Object | Attribute)* ']'
		//	| ':' element+=(Object | Attribute)*);
		@Override public ParserRule getRule() { return rule; }
		
		//name=XID description=EString? ('[' element+=(Object | Attribute)* ']' | ':' element+=(Object | Attribute)*)
		public Group getGroup() { return cGroup; }
		
		//name=XID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//XID
		public RuleCall getNameXIDParserRuleCall_0_0() { return cNameXIDParserRuleCall_0_0; }
		
		//description=EString?
		public Assignment getDescriptionAssignment_1() { return cDescriptionAssignment_1; }
		
		//EString
		public RuleCall getDescriptionEStringParserRuleCall_1_0() { return cDescriptionEStringParserRuleCall_1_0; }
		
		//'[' element+=(Object | Attribute)* ']' | ':' element+=(Object | Attribute)*
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//'[' element+=(Object | Attribute)* ']'
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_2_0_0() { return cLeftSquareBracketKeyword_2_0_0; }
		
		//element+=(Object | Attribute)*
		public Assignment getElementAssignment_2_0_1() { return cElementAssignment_2_0_1; }
		
		//(Object | Attribute)
		public Alternatives getElementAlternatives_2_0_1_0() { return cElementAlternatives_2_0_1_0; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_2_0_1_0_0() { return cElementObjectParserRuleCall_2_0_1_0_0; }
		
		//Attribute
		public RuleCall getElementAttributeParserRuleCall_2_0_1_0_1() { return cElementAttributeParserRuleCall_2_0_1_0_1; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_2_0_2() { return cRightSquareBracketKeyword_2_0_2; }
		
		//':' element+=(Object | Attribute)*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//':'
		public Keyword getColonKeyword_2_1_0() { return cColonKeyword_2_1_0; }
		
		//element+=(Object | Attribute)*
		public Assignment getElementAssignment_2_1_1() { return cElementAssignment_2_1_1; }
		
		//(Object | Attribute)
		public Alternatives getElementAlternatives_2_1_1_0() { return cElementAlternatives_2_1_1_0; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_2_1_1_0_0() { return cElementObjectParserRuleCall_2_1_1_0_0; }
		
		//Attribute
		public RuleCall getElementAttributeParserRuleCall_2_1_1_0_1() { return cElementAttributeParserRuleCall_2_1_1_0_1; }
	}
	public class AttributeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.Attribute");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cWAttributeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameXIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueValueSpecificationParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Attribute sew::WAttribute:
		//	{sew::WAttribute} name=XID '=' value=ValueSpecification ';'?;
		@Override public ParserRule getRule() { return rule; }
		
		//{sew::WAttribute} name=XID '=' value=ValueSpecification ';'?
		public Group getGroup() { return cGroup; }
		
		//{sew::WAttribute}
		public Action getWAttributeAction_0() { return cWAttributeAction_0; }
		
		//name=XID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//XID
		public RuleCall getNameXIDParserRuleCall_1_0() { return cNameXIDParserRuleCall_1_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//value=ValueSpecification
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//ValueSpecification
		public RuleCall getValueValueSpecificationParserRuleCall_3_0() { return cValueValueSpecificationParserRuleCall_3_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class ValueSpecificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
		private final RuleCall cExpressionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Value Specification
		//////////////////////////////////////////////////////////////////////////////////
		//ValueSpecification sew::WValueSpecification:
		//	Expression;
		@Override public ParserRule getRule() { return rule; }
		
		//Expression
		public RuleCall getExpressionParserRuleCall() { return cExpressionParserRuleCall; }
	}
	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.Expression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cConditionalExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDeprecatedExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Expression Specification
		//////////////////////////////////////////////////////////////////////////////////
		//Expression sew::WValueSpecification:
		//	conditionalExpression
		//	// Deprecated
		//	| DeprecatedExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//conditionalExpression // Deprecated
		//| DeprecatedExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//conditionalExpression
		public RuleCall getConditionalExpressionParserRuleCall_0() { return cConditionalExpressionParserRuleCall_0; }
		
		//DeprecatedExpression
		public RuleCall getDeprecatedExpressionParserRuleCall_1() { return cDeprecatedExpressionParserRuleCall_1; }
	}
	public class ConditionalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.conditionalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cConditionalOrExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExpressionOperandAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOperatorQuestionMarkKeyword_1_1_0 = (Keyword)cOperatorAssignment_1_1.eContents().get(0);
		private final Assignment cOperandAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandAssignment_1_2.eContents().get(0);
		private final Keyword cColonKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Assignment cOperandAssignment_1_4 = (Assignment)cGroup_1.eContents().get(4);
		private final RuleCall cOperandExpressionParserRuleCall_1_4_0 = (RuleCall)cOperandAssignment_1_4.eContents().get(0);
		
		//conditionalExpression sew::WValueSpecification:
		//	conditionalOrExpression ({expression::Expression.operand+=current} operator='?' operand+=Expression ':'
		//	operand+=Expression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//conditionalOrExpression ({expression::Expression.operand+=current} operator='?' operand+=Expression ':'
		//operand+=Expression)?
		public Group getGroup() { return cGroup; }
		
		//conditionalOrExpression
		public RuleCall getConditionalOrExpressionParserRuleCall_0() { return cConditionalOrExpressionParserRuleCall_0; }
		
		//({expression::Expression.operand+=current} operator='?' operand+=Expression ':' operand+=Expression)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_0() { return cExpressionOperandAction_1_0; }
		
		//operator='?'
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//'?'
		public Keyword getOperatorQuestionMarkKeyword_1_1_0() { return cOperatorQuestionMarkKeyword_1_1_0; }
		
		//operand+=Expression
		public Assignment getOperandAssignment_1_2() { return cOperandAssignment_1_2; }
		
		//Expression
		public RuleCall getOperandExpressionParserRuleCall_1_2_0() { return cOperandExpressionParserRuleCall_1_2_0; }
		
		//':'
		public Keyword getColonKeyword_1_3() { return cColonKeyword_1_3; }
		
		//operand+=Expression
		public Assignment getOperandAssignment_1_4() { return cOperandAssignment_1_4; }
		
		//Expression
		public RuleCall getOperandExpressionParserRuleCall_1_4_0() { return cOperandExpressionParserRuleCall_1_4_0; }
	}
	public class ConditionalOrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.conditionalOrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cConditionalAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExpressionOperandAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOperatorAlternatives_1_1_0 = (Alternatives)cOperatorAssignment_1_1.eContents().get(0);
		private final Keyword cOperatorVerticalLineVerticalLineKeyword_1_1_0_0 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOperatorOrKeyword_1_1_0_1 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(1);
		private final Assignment cOperandAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandConditionalAndExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandAssignment_1_2.eContents().get(0);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Alternatives cAlternatives_1_3_0 = (Alternatives)cGroup_1_3.eContents().get(0);
		private final Keyword cVerticalLineVerticalLineKeyword_1_3_0_0 = (Keyword)cAlternatives_1_3_0.eContents().get(0);
		private final Keyword cOrKeyword_1_3_0_1 = (Keyword)cAlternatives_1_3_0.eContents().get(1);
		private final Assignment cOperandAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final RuleCall cOperandConditionalAndExpressionParserRuleCall_1_3_1_0 = (RuleCall)cOperandAssignment_1_3_1.eContents().get(0);
		
		//conditionalOrExpression sew::WValueSpecification:
		//	conditionalAndExpression ({expression::Expression.operand+=current} operator=('||' | 'or')
		//	operand+=conditionalAndExpression (('||' | 'or') operand+=conditionalAndExpression)*)?;
		@Override public ParserRule getRule() { return rule; }
		
		//conditionalAndExpression ({expression::Expression.operand+=current} operator=('||' | 'or')
		//operand+=conditionalAndExpression (('||' | 'or') operand+=conditionalAndExpression)*)?
		public Group getGroup() { return cGroup; }
		
		//conditionalAndExpression
		public RuleCall getConditionalAndExpressionParserRuleCall_0() { return cConditionalAndExpressionParserRuleCall_0; }
		
		//({expression::Expression.operand+=current} operator=('||' | 'or') operand+=conditionalAndExpression (('||' | 'or')
		//operand+=conditionalAndExpression)*)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_0() { return cExpressionOperandAction_1_0; }
		
		//operator=('||' | 'or')
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//('||' | 'or')
		public Alternatives getOperatorAlternatives_1_1_0() { return cOperatorAlternatives_1_1_0; }
		
		//'||'
		public Keyword getOperatorVerticalLineVerticalLineKeyword_1_1_0_0() { return cOperatorVerticalLineVerticalLineKeyword_1_1_0_0; }
		
		//'or'
		public Keyword getOperatorOrKeyword_1_1_0_1() { return cOperatorOrKeyword_1_1_0_1; }
		
		//operand+=conditionalAndExpression
		public Assignment getOperandAssignment_1_2() { return cOperandAssignment_1_2; }
		
		//conditionalAndExpression
		public RuleCall getOperandConditionalAndExpressionParserRuleCall_1_2_0() { return cOperandConditionalAndExpressionParserRuleCall_1_2_0; }
		
		//(('||' | 'or') operand+=conditionalAndExpression)*
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//'||' | 'or'
		public Alternatives getAlternatives_1_3_0() { return cAlternatives_1_3_0; }
		
		//'||'
		public Keyword getVerticalLineVerticalLineKeyword_1_3_0_0() { return cVerticalLineVerticalLineKeyword_1_3_0_0; }
		
		//'or'
		public Keyword getOrKeyword_1_3_0_1() { return cOrKeyword_1_3_0_1; }
		
		//operand+=conditionalAndExpression
		public Assignment getOperandAssignment_1_3_1() { return cOperandAssignment_1_3_1; }
		
		//conditionalAndExpression
		public RuleCall getOperandConditionalAndExpressionParserRuleCall_1_3_1_0() { return cOperandConditionalAndExpressionParserRuleCall_1_3_1_0; }
	}
	public class ConditionalAndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.conditionalAndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cEqualityExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExpressionOperandAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOperatorAlternatives_1_1_0 = (Alternatives)cOperatorAssignment_1_1.eContents().get(0);
		private final Keyword cOperatorAmpersandAmpersandKeyword_1_1_0_0 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOperatorAndKeyword_1_1_0_1 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(1);
		private final Assignment cOperandAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandEqualityExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandAssignment_1_2.eContents().get(0);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Alternatives cAlternatives_1_3_0 = (Alternatives)cGroup_1_3.eContents().get(0);
		private final Keyword cAmpersandAmpersandKeyword_1_3_0_0 = (Keyword)cAlternatives_1_3_0.eContents().get(0);
		private final Keyword cAndKeyword_1_3_0_1 = (Keyword)cAlternatives_1_3_0.eContents().get(1);
		private final Assignment cOperandAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final RuleCall cOperandEqualityExpressionParserRuleCall_1_3_1_0 = (RuleCall)cOperandAssignment_1_3_1.eContents().get(0);
		
		//conditionalAndExpression sew::WValueSpecification:
		//	equalityExpression ({expression::Expression.operand+=current} operator=('&&' | 'and') operand+=equalityExpression
		//	(('&&' | 'and') operand+=equalityExpression)*)?;
		@Override public ParserRule getRule() { return rule; }
		
		//equalityExpression ({expression::Expression.operand+=current} operator=('&&' | 'and') operand+=equalityExpression (('&&'
		//| 'and') operand+=equalityExpression)*)?
		public Group getGroup() { return cGroup; }
		
		//equalityExpression
		public RuleCall getEqualityExpressionParserRuleCall_0() { return cEqualityExpressionParserRuleCall_0; }
		
		//({expression::Expression.operand+=current} operator=('&&' | 'and') operand+=equalityExpression (('&&' | 'and')
		//operand+=equalityExpression)*)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_0() { return cExpressionOperandAction_1_0; }
		
		//operator=('&&' | 'and')
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//('&&' | 'and')
		public Alternatives getOperatorAlternatives_1_1_0() { return cOperatorAlternatives_1_1_0; }
		
		//'&&'
		public Keyword getOperatorAmpersandAmpersandKeyword_1_1_0_0() { return cOperatorAmpersandAmpersandKeyword_1_1_0_0; }
		
		//'and'
		public Keyword getOperatorAndKeyword_1_1_0_1() { return cOperatorAndKeyword_1_1_0_1; }
		
		//operand+=equalityExpression
		public Assignment getOperandAssignment_1_2() { return cOperandAssignment_1_2; }
		
		//equalityExpression
		public RuleCall getOperandEqualityExpressionParserRuleCall_1_2_0() { return cOperandEqualityExpressionParserRuleCall_1_2_0; }
		
		//(('&&' | 'and') operand+=equalityExpression)*
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//'&&' | 'and'
		public Alternatives getAlternatives_1_3_0() { return cAlternatives_1_3_0; }
		
		//'&&'
		public Keyword getAmpersandAmpersandKeyword_1_3_0_0() { return cAmpersandAmpersandKeyword_1_3_0_0; }
		
		//'and'
		public Keyword getAndKeyword_1_3_0_1() { return cAndKeyword_1_3_0_1; }
		
		//operand+=equalityExpression
		public Assignment getOperandAssignment_1_3_1() { return cOperandAssignment_1_3_1; }
		
		//equalityExpression
		public RuleCall getOperandEqualityExpressionParserRuleCall_1_3_1_0() { return cOperandEqualityExpressionParserRuleCall_1_3_1_0; }
	}
	public class EqualityExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.equalityExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cRelationalExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExpressionOperandAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOperatorAlternatives_1_1_0 = (Alternatives)cOperatorAssignment_1_1.eContents().get(0);
		private final Keyword cOperatorEqualsSignEqualsSignKeyword_1_1_0_0 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOperatorExclamationMarkEqualsSignKeyword_1_1_0_1 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(1);
		private final Keyword cOperatorEqualsSignEqualsSignEqualsSignKeyword_1_1_0_2 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(2);
		private final Keyword cOperatorEqualsSignExclamationMarkEqualsSignKeyword_1_1_0_3 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(3);
		private final Keyword cOperatorEqualsSignSolidusEqualsSignKeyword_1_1_0_4 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(4);
		private final Assignment cOperandAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandRelationalExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandAssignment_1_2.eContents().get(0);
		
		//equalityExpression sew::WValueSpecification:
		//	relationalExpression ({expression::Expression.operand+=current} operator=('==' | '!=' | '===' | '=!=' | '=/=')
		//	operand+=relationalExpression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//relationalExpression ({expression::Expression.operand+=current} operator=('==' | '!=' | '===' | '=!=' | '=/=')
		//operand+=relationalExpression)?
		public Group getGroup() { return cGroup; }
		
		//relationalExpression
		public RuleCall getRelationalExpressionParserRuleCall_0() { return cRelationalExpressionParserRuleCall_0; }
		
		//({expression::Expression.operand+=current} operator=('==' | '!=' | '===' | '=!=' | '=/=')
		//operand+=relationalExpression)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_0() { return cExpressionOperandAction_1_0; }
		
		//operator=('==' | '!=' | '===' | '=!=' | '=/=')
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//('==' | '!=' | '===' | '=!=' | '=/=')
		public Alternatives getOperatorAlternatives_1_1_0() { return cOperatorAlternatives_1_1_0; }
		
		//'=='
		public Keyword getOperatorEqualsSignEqualsSignKeyword_1_1_0_0() { return cOperatorEqualsSignEqualsSignKeyword_1_1_0_0; }
		
		//'!='
		public Keyword getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1() { return cOperatorExclamationMarkEqualsSignKeyword_1_1_0_1; }
		
		//'==='
		public Keyword getOperatorEqualsSignEqualsSignEqualsSignKeyword_1_1_0_2() { return cOperatorEqualsSignEqualsSignEqualsSignKeyword_1_1_0_2; }
		
		//'=!='
		public Keyword getOperatorEqualsSignExclamationMarkEqualsSignKeyword_1_1_0_3() { return cOperatorEqualsSignExclamationMarkEqualsSignKeyword_1_1_0_3; }
		
		//'=/='
		public Keyword getOperatorEqualsSignSolidusEqualsSignKeyword_1_1_0_4() { return cOperatorEqualsSignSolidusEqualsSignKeyword_1_1_0_4; }
		
		//operand+=relationalExpression
		public Assignment getOperandAssignment_1_2() { return cOperandAssignment_1_2; }
		
		//relationalExpression
		public RuleCall getOperandRelationalExpressionParserRuleCall_1_2_0() { return cOperandRelationalExpressionParserRuleCall_1_2_0; }
	}
	public class RelationalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.relationalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAdditiveExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExpressionOperandAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOperatorAlternatives_1_1_0 = (Alternatives)cOperatorAssignment_1_1.eContents().get(0);
		private final Keyword cOperatorLessThanSignKeyword_1_1_0_0 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOperatorLessThanSignEqualsSignKeyword_1_1_0_1 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(1);
		private final Keyword cOperatorGreaterThanSignKeyword_1_1_0_2 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(2);
		private final Keyword cOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(3);
		private final Assignment cOperandAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandAdditiveExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandAssignment_1_2.eContents().get(0);
		
		//relationalExpression sew::WValueSpecification:
		//	additiveExpression ({expression::Expression.operand+=current} operator=('<' | '<=' | '>' | '>=')
		//	operand+=additiveExpression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//additiveExpression ({expression::Expression.operand+=current} operator=('<' | '<=' | '>' | '>=')
		//operand+=additiveExpression)?
		public Group getGroup() { return cGroup; }
		
		//additiveExpression
		public RuleCall getAdditiveExpressionParserRuleCall_0() { return cAdditiveExpressionParserRuleCall_0; }
		
		//({expression::Expression.operand+=current} operator=('<' | '<=' | '>' | '>=') operand+=additiveExpression)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_0() { return cExpressionOperandAction_1_0; }
		
		//operator=('<' | '<=' | '>' | '>=')
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//('<' | '<=' | '>' | '>=')
		public Alternatives getOperatorAlternatives_1_1_0() { return cOperatorAlternatives_1_1_0; }
		
		//'<'
		public Keyword getOperatorLessThanSignKeyword_1_1_0_0() { return cOperatorLessThanSignKeyword_1_1_0_0; }
		
		//'<='
		public Keyword getOperatorLessThanSignEqualsSignKeyword_1_1_0_1() { return cOperatorLessThanSignEqualsSignKeyword_1_1_0_1; }
		
		//'>'
		public Keyword getOperatorGreaterThanSignKeyword_1_1_0_2() { return cOperatorGreaterThanSignKeyword_1_1_0_2; }
		
		//'>='
		public Keyword getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3() { return cOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3; }
		
		//operand+=additiveExpression
		public Assignment getOperandAssignment_1_2() { return cOperandAssignment_1_2; }
		
		//additiveExpression
		public RuleCall getOperandAdditiveExpressionParserRuleCall_1_2_0() { return cOperandAdditiveExpressionParserRuleCall_1_2_0; }
	}
	public class AdditiveExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.additiveExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cMultiplicativeExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExpressionOperandAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOperatorPlusSignKeyword_1_1_0 = (Keyword)cOperatorAssignment_1_1.eContents().get(0);
		private final Assignment cOperandAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandMultiplicativeExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandAssignment_1_2.eContents().get(0);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Keyword cPlusSignKeyword_1_3_0 = (Keyword)cGroup_1_3.eContents().get(0);
		private final Assignment cOperandAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final RuleCall cOperandMultiplicativeExpressionParserRuleCall_1_3_1_0 = (RuleCall)cOperandAssignment_1_3_1.eContents().get(0);
		
		//additiveExpression sew::WValueSpecification:
		//	multiplicativeExpression ({expression::Expression.operand+=current} operator='+' operand+=multiplicativeExpression
		//	('+' operand+=multiplicativeExpression)*)?;
		@Override public ParserRule getRule() { return rule; }
		
		//multiplicativeExpression ({expression::Expression.operand+=current} operator='+' operand+=multiplicativeExpression ('+'
		//operand+=multiplicativeExpression)*)?
		public Group getGroup() { return cGroup; }
		
		//multiplicativeExpression
		public RuleCall getMultiplicativeExpressionParserRuleCall_0() { return cMultiplicativeExpressionParserRuleCall_0; }
		
		//({expression::Expression.operand+=current} operator='+' operand+=multiplicativeExpression ('+'
		//operand+=multiplicativeExpression)*)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_0() { return cExpressionOperandAction_1_0; }
		
		//operator='+'
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//'+'
		public Keyword getOperatorPlusSignKeyword_1_1_0() { return cOperatorPlusSignKeyword_1_1_0; }
		
		//operand+=multiplicativeExpression
		public Assignment getOperandAssignment_1_2() { return cOperandAssignment_1_2; }
		
		//multiplicativeExpression
		public RuleCall getOperandMultiplicativeExpressionParserRuleCall_1_2_0() { return cOperandMultiplicativeExpressionParserRuleCall_1_2_0; }
		
		//('+' operand+=multiplicativeExpression)*
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//'+'
		public Keyword getPlusSignKeyword_1_3_0() { return cPlusSignKeyword_1_3_0; }
		
		//operand+=multiplicativeExpression
		public Assignment getOperandAssignment_1_3_1() { return cOperandAssignment_1_3_1; }
		
		//multiplicativeExpression
		public RuleCall getOperandMultiplicativeExpressionParserRuleCall_1_3_1_0() { return cOperandMultiplicativeExpressionParserRuleCall_1_3_1_0; }
	}
	public class MultiplicativeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.multiplicativeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPrimaryExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Action cExpressionOperandAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Keyword cOperatorAsteriskKeyword_1_0_1_0 = (Keyword)cOperatorAssignment_1_0_1.eContents().get(0);
		private final Assignment cOperandAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_0_2_0 = (RuleCall)cOperandAssignment_1_0_2.eContents().get(0);
		private final Group cGroup_1_0_3 = (Group)cGroup_1_0.eContents().get(3);
		private final Keyword cAsteriskKeyword_1_0_3_0 = (Keyword)cGroup_1_0_3.eContents().get(0);
		private final Assignment cOperandAssignment_1_0_3_1 = (Assignment)cGroup_1_0_3.eContents().get(1);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_0_3_1_0 = (RuleCall)cOperandAssignment_1_0_3_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Action cExpressionOperandAction_1_1_0 = (Action)cGroup_1_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final Keyword cOperatorAsteriskAsteriskKeyword_1_1_1_0 = (Keyword)cOperatorAssignment_1_1_1.eContents().get(0);
		private final Assignment cOperandAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_1_2_0 = (RuleCall)cOperandAssignment_1_1_2.eContents().get(0);
		private final Group cGroup_1_1_3 = (Group)cGroup_1_1.eContents().get(3);
		private final Keyword cAsteriskAsteriskKeyword_1_1_3_0 = (Keyword)cGroup_1_1_3.eContents().get(0);
		private final Assignment cOperandAssignment_1_1_3_1 = (Assignment)cGroup_1_1_3.eContents().get(1);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_1_3_1_0 = (RuleCall)cOperandAssignment_1_1_3_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cAlternatives_1.eContents().get(2);
		private final Action cExpressionOperandAction_1_2_0 = (Action)cGroup_1_2.eContents().get(0);
		private final Assignment cOperatorAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final Keyword cOperatorSolidusKeyword_1_2_1_0 = (Keyword)cOperatorAssignment_1_2_1.eContents().get(0);
		private final Assignment cOperandAssignment_1_2_2 = (Assignment)cGroup_1_2.eContents().get(2);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_2_2_0 = (RuleCall)cOperandAssignment_1_2_2.eContents().get(0);
		private final Group cGroup_1_2_3 = (Group)cGroup_1_2.eContents().get(3);
		private final Keyword cSolidusKeyword_1_2_3_0 = (Keyword)cGroup_1_2_3.eContents().get(0);
		private final Assignment cOperandAssignment_1_2_3_1 = (Assignment)cGroup_1_2_3.eContents().get(1);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_2_3_1_0 = (RuleCall)cOperandAssignment_1_2_3_1.eContents().get(0);
		private final Group cGroup_1_3 = (Group)cAlternatives_1.eContents().get(3);
		private final Action cExpressionOperandAction_1_3_0 = (Action)cGroup_1_3.eContents().get(0);
		private final Assignment cOperatorAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final Keyword cOperatorPercentSignKeyword_1_3_1_0 = (Keyword)cOperatorAssignment_1_3_1.eContents().get(0);
		private final Assignment cOperandAssignment_1_3_2 = (Assignment)cGroup_1_3.eContents().get(2);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_3_2_0 = (RuleCall)cOperandAssignment_1_3_2.eContents().get(0);
		private final Group cGroup_1_3_3 = (Group)cGroup_1_3.eContents().get(3);
		private final Keyword cPercentSignKeyword_1_3_3_0 = (Keyword)cGroup_1_3_3.eContents().get(0);
		private final Assignment cOperandAssignment_1_3_3_1 = (Assignment)cGroup_1_3_3.eContents().get(1);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_3_3_1_0 = (RuleCall)cOperandAssignment_1_3_3_1.eContents().get(0);
		
		//multiplicativeExpression sew::WValueSpecification:
		//	primaryExpression ({expression::Expression.operand+=current} operator='*' operand+=primaryExpression ('*'
		//	operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='**' operand+=primaryExpression
		//	('**' operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='/'
		//	operand+=primaryExpression ('/' operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='%'
		//	operand+=primaryExpression ('%' operand+=primaryExpression)*)?;
		@Override public ParserRule getRule() { return rule; }
		
		//primaryExpression ({expression::Expression.operand+=current} operator='*' operand+=primaryExpression ('*'
		//operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='**' operand+=primaryExpression
		//('**' operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='/' operand+=primaryExpression
		//('/' operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='%' operand+=primaryExpression
		//('%' operand+=primaryExpression)*)?
		public Group getGroup() { return cGroup; }
		
		//primaryExpression
		public RuleCall getPrimaryExpressionParserRuleCall_0() { return cPrimaryExpressionParserRuleCall_0; }
		
		//({expression::Expression.operand+=current} operator='*' operand+=primaryExpression ('*' operand+=primaryExpression)* |
		//{expression::Expression.operand+=current} operator='**' operand+=primaryExpression ('**' operand+=primaryExpression)*
		//| {expression::Expression.operand+=current} operator='/' operand+=primaryExpression ('/' operand+=primaryExpression)*
		//| {expression::Expression.operand+=current} operator='%' operand+=primaryExpression ('%'
		//operand+=primaryExpression)*)?
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//{expression::Expression.operand+=current} operator='*' operand+=primaryExpression ('*' operand+=primaryExpression)*
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_0_0() { return cExpressionOperandAction_1_0_0; }
		
		//operator='*'
		public Assignment getOperatorAssignment_1_0_1() { return cOperatorAssignment_1_0_1; }
		
		//'*'
		public Keyword getOperatorAsteriskKeyword_1_0_1_0() { return cOperatorAsteriskKeyword_1_0_1_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_0_2() { return cOperandAssignment_1_0_2; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_0_2_0() { return cOperandPrimaryExpressionParserRuleCall_1_0_2_0; }
		
		//('*' operand+=primaryExpression)*
		public Group getGroup_1_0_3() { return cGroup_1_0_3; }
		
		//'*'
		public Keyword getAsteriskKeyword_1_0_3_0() { return cAsteriskKeyword_1_0_3_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_0_3_1() { return cOperandAssignment_1_0_3_1; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_0_3_1_0() { return cOperandPrimaryExpressionParserRuleCall_1_0_3_1_0; }
		
		//{expression::Expression.operand+=current} operator='**' operand+=primaryExpression ('**' operand+=primaryExpression)*
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_1_0() { return cExpressionOperandAction_1_1_0; }
		
		//operator='**'
		public Assignment getOperatorAssignment_1_1_1() { return cOperatorAssignment_1_1_1; }
		
		//'**'
		public Keyword getOperatorAsteriskAsteriskKeyword_1_1_1_0() { return cOperatorAsteriskAsteriskKeyword_1_1_1_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_1_2() { return cOperandAssignment_1_1_2; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_1_2_0() { return cOperandPrimaryExpressionParserRuleCall_1_1_2_0; }
		
		//('**' operand+=primaryExpression)*
		public Group getGroup_1_1_3() { return cGroup_1_1_3; }
		
		//'**'
		public Keyword getAsteriskAsteriskKeyword_1_1_3_0() { return cAsteriskAsteriskKeyword_1_1_3_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_1_3_1() { return cOperandAssignment_1_1_3_1; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_1_3_1_0() { return cOperandPrimaryExpressionParserRuleCall_1_1_3_1_0; }
		
		//{expression::Expression.operand+=current} operator='/' operand+=primaryExpression ('/' operand+=primaryExpression)*
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_2_0() { return cExpressionOperandAction_1_2_0; }
		
		//operator='/'
		public Assignment getOperatorAssignment_1_2_1() { return cOperatorAssignment_1_2_1; }
		
		//'/'
		public Keyword getOperatorSolidusKeyword_1_2_1_0() { return cOperatorSolidusKeyword_1_2_1_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_2_2() { return cOperandAssignment_1_2_2; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_2_2_0() { return cOperandPrimaryExpressionParserRuleCall_1_2_2_0; }
		
		//('/' operand+=primaryExpression)*
		public Group getGroup_1_2_3() { return cGroup_1_2_3; }
		
		//'/'
		public Keyword getSolidusKeyword_1_2_3_0() { return cSolidusKeyword_1_2_3_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_2_3_1() { return cOperandAssignment_1_2_3_1; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_2_3_1_0() { return cOperandPrimaryExpressionParserRuleCall_1_2_3_1_0; }
		
		//{expression::Expression.operand+=current} operator='%' operand+=primaryExpression ('%' operand+=primaryExpression)*
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//{expression::Expression.operand+=current}
		public Action getExpressionOperandAction_1_3_0() { return cExpressionOperandAction_1_3_0; }
		
		//operator='%'
		public Assignment getOperatorAssignment_1_3_1() { return cOperatorAssignment_1_3_1; }
		
		//'%'
		public Keyword getOperatorPercentSignKeyword_1_3_1_0() { return cOperatorPercentSignKeyword_1_3_1_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_3_2() { return cOperandAssignment_1_3_2; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_3_2_0() { return cOperandPrimaryExpressionParserRuleCall_1_3_2_0; }
		
		//('%' operand+=primaryExpression)*
		public Group getGroup_1_3_3() { return cGroup_1_3_3; }
		
		//'%'
		public Keyword getPercentSignKeyword_1_3_3_0() { return cPercentSignKeyword_1_3_3_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_3_3_1() { return cOperandAssignment_1_3_3_1; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_3_3_1_0() { return cOperandPrimaryExpressionParserRuleCall_1_3_3_1_0; }
	}
	public class PrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.primaryExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final RuleCall cPrimaryExpressionParserRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cExpressionAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Assignment cOperatorAssignment_1_1_0 = (Assignment)cGroup_1_1.eContents().get(0);
		private final Keyword cOperatorHyphenMinusKeyword_1_1_0_0 = (Keyword)cOperatorAssignment_1_1_0.eContents().get(0);
		private final Assignment cOperandAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_1_1_1_0 = (RuleCall)cOperandAssignment_1_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cExpressionAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Assignment cOperatorAssignment_2_1_0 = (Assignment)cGroup_2_1.eContents().get(0);
		private final Alternatives cOperatorAlternatives_2_1_0_0 = (Alternatives)cOperatorAssignment_2_1_0.eContents().get(0);
		private final Keyword cOperatorExclamationMarkKeyword_2_1_0_0_0 = (Keyword)cOperatorAlternatives_2_1_0_0.eContents().get(0);
		private final Keyword cOperatorNotKeyword_2_1_0_0_1 = (Keyword)cOperatorAlternatives_2_1_0_0.eContents().get(1);
		private final Assignment cOperandAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOperandPrimaryExpressionParserRuleCall_2_1_1_0 = (RuleCall)cOperandAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final RuleCall cExpressionParserRuleCall_3_1 = (RuleCall)cGroup_3.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final RuleCall cLiteralExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//primaryExpression sew::WValueSpecification:
		//	'+' primaryExpression
		//	| {expression::Expression} (operator='-' operand+=primaryExpression) | {expression::Expression} (operator=('!' |
		//	'not') operand+=primaryExpression) | '(' Expression ')'
		//	| LiteralExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//'+' primaryExpression | {expression::Expression} (operator='-' operand+=primaryExpression) | {expression::Expression}
		//(operator=('!' | 'not') operand+=primaryExpression) | '(' Expression ')' | LiteralExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'+' primaryExpression
		public Group getGroup_0() { return cGroup_0; }
		
		//'+'
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }
		
		//primaryExpression
		public RuleCall getPrimaryExpressionParserRuleCall_0_1() { return cPrimaryExpressionParserRuleCall_0_1; }
		
		//{expression::Expression} (operator='-' operand+=primaryExpression)
		public Group getGroup_1() { return cGroup_1; }
		
		//{expression::Expression}
		public Action getExpressionAction_1_0() { return cExpressionAction_1_0; }
		
		//operator='-' operand+=primaryExpression
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//operator='-'
		public Assignment getOperatorAssignment_1_1_0() { return cOperatorAssignment_1_1_0; }
		
		//'-'
		public Keyword getOperatorHyphenMinusKeyword_1_1_0_0() { return cOperatorHyphenMinusKeyword_1_1_0_0; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_1_1_1() { return cOperandAssignment_1_1_1; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_1_1_1_0() { return cOperandPrimaryExpressionParserRuleCall_1_1_1_0; }
		
		//{expression::Expression} (operator=('!' | 'not') operand+=primaryExpression)
		public Group getGroup_2() { return cGroup_2; }
		
		//{expression::Expression}
		public Action getExpressionAction_2_0() { return cExpressionAction_2_0; }
		
		//operator=('!' | 'not') operand+=primaryExpression
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//operator=('!' | 'not')
		public Assignment getOperatorAssignment_2_1_0() { return cOperatorAssignment_2_1_0; }
		
		//('!' | 'not')
		public Alternatives getOperatorAlternatives_2_1_0_0() { return cOperatorAlternatives_2_1_0_0; }
		
		//'!'
		public Keyword getOperatorExclamationMarkKeyword_2_1_0_0_0() { return cOperatorExclamationMarkKeyword_2_1_0_0_0; }
		
		//'not'
		public Keyword getOperatorNotKeyword_2_1_0_0_1() { return cOperatorNotKeyword_2_1_0_0_1; }
		
		//operand+=primaryExpression
		public Assignment getOperandAssignment_2_1_1() { return cOperandAssignment_2_1_1; }
		
		//primaryExpression
		public RuleCall getOperandPrimaryExpressionParserRuleCall_2_1_1_0() { return cOperandPrimaryExpressionParserRuleCall_2_1_1_0; }
		
		//'(' Expression ')'
		public Group getGroup_3() { return cGroup_3; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }
		
		//Expression
		public RuleCall getExpressionParserRuleCall_3_1() { return cExpressionParserRuleCall_3_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
		
		//LiteralExpression
		public RuleCall getLiteralExpressionParserRuleCall_4() { return cLiteralExpressionParserRuleCall_4; }
	}
	public class LiteralExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralBooleanValueParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLiteralCharacterValueParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLiteralIntegerValueParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLiteralRationalValueParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cLiteralFloatValueParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cLiteralStringValueParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cLiteralNullValueParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cLiteralArrayValueParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cLiteralObjectReferenceParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cLiteralVariableReferenceParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cLiteralInstanceReferenceParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		
		//LiteralExpression sew::WValueSpecification:
		//	LiteralBooleanValue
		//	| LiteralCharacterValue
		//	| LiteralIntegerValue
		//	| LiteralRationalValue
		//	| LiteralFloatValue
		//	//| LiteralRealValue
		//	| LiteralStringValue
		//	| LiteralNullValue
		//	| LiteralArrayValue
		//	| LiteralObjectReference
		//	| LiteralVariableReference
		//	| LiteralInstanceReference;
		@Override public ParserRule getRule() { return rule; }
		
		//LiteralBooleanValue | LiteralCharacterValue | LiteralIntegerValue | LiteralRationalValue | LiteralFloatValue //| LiteralRealValue
		//| LiteralStringValue | LiteralNullValue | LiteralArrayValue | LiteralObjectReference | LiteralVariableReference |
		//LiteralInstanceReference
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//LiteralBooleanValue
		public RuleCall getLiteralBooleanValueParserRuleCall_0() { return cLiteralBooleanValueParserRuleCall_0; }
		
		//LiteralCharacterValue
		public RuleCall getLiteralCharacterValueParserRuleCall_1() { return cLiteralCharacterValueParserRuleCall_1; }
		
		//LiteralIntegerValue
		public RuleCall getLiteralIntegerValueParserRuleCall_2() { return cLiteralIntegerValueParserRuleCall_2; }
		
		//LiteralRationalValue
		public RuleCall getLiteralRationalValueParserRuleCall_3() { return cLiteralRationalValueParserRuleCall_3; }
		
		//LiteralFloatValue
		public RuleCall getLiteralFloatValueParserRuleCall_4() { return cLiteralFloatValueParserRuleCall_4; }
		
		//LiteralStringValue
		public RuleCall getLiteralStringValueParserRuleCall_5() { return cLiteralStringValueParserRuleCall_5; }
		
		//LiteralNullValue
		public RuleCall getLiteralNullValueParserRuleCall_6() { return cLiteralNullValueParserRuleCall_6; }
		
		//LiteralArrayValue
		public RuleCall getLiteralArrayValueParserRuleCall_7() { return cLiteralArrayValueParserRuleCall_7; }
		
		//LiteralObjectReference
		public RuleCall getLiteralObjectReferenceParserRuleCall_8() { return cLiteralObjectReferenceParserRuleCall_8; }
		
		//LiteralVariableReference
		public RuleCall getLiteralVariableReferenceParserRuleCall_9() { return cLiteralVariableReferenceParserRuleCall_9; }
		
		//LiteralInstanceReference
		public RuleCall getLiteralInstanceReferenceParserRuleCall_10() { return cLiteralInstanceReferenceParserRuleCall_10; }
	}
	public class LiteralArrayValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralArrayValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralArrayValueAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cValuesAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cValuesValueSpecificationParserRuleCall_2_0_0 = (RuleCall)cValuesAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cValuesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cValuesValueSpecificationParserRuleCall_2_1_1_0 = (RuleCall)cValuesAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Array of Literal Specification
		//////////////////////////////////////////////////////////////////////////////////
		//LiteralArrayValue expression::LiteralArrayValue:
		//	{expression::LiteralArrayValue}
		//	'[' (values+=ValueSpecification (',' values+=ValueSpecification)*)?
		//	']';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralArrayValue} '[' (values+=ValueSpecification (',' values+=ValueSpecification)*)? ']'
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralArrayValue}
		public Action getLiteralArrayValueAction_0() { return cLiteralArrayValueAction_0; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }
		
		//(values+=ValueSpecification (',' values+=ValueSpecification)*)?
		public Group getGroup_2() { return cGroup_2; }
		
		//values+=ValueSpecification
		public Assignment getValuesAssignment_2_0() { return cValuesAssignment_2_0; }
		
		//ValueSpecification
		public RuleCall getValuesValueSpecificationParserRuleCall_2_0_0() { return cValuesValueSpecificationParserRuleCall_2_0_0; }
		
		//(',' values+=ValueSpecification)*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }
		
		//values+=ValueSpecification
		public Assignment getValuesAssignment_2_1_1() { return cValuesAssignment_2_1_1; }
		
		//ValueSpecification
		public RuleCall getValuesValueSpecificationParserRuleCall_2_1_1_0() { return cValuesValueSpecificationParserRuleCall_2_1_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}
	public class LiteralObjectReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralObjectReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAmpersandKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cObjectAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final CrossReference cObjectWObjectCrossReference_1_0_0 = (CrossReference)cObjectAssignment_1_0.eContents().get(0);
		private final RuleCall cObjectWObjectUFIParserRuleCall_1_0_0_1 = (RuleCall)cObjectWObjectCrossReference_1_0_0.eContents().get(1);
		private final Assignment cSymbolAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cSymbolUFIParserRuleCall_1_1_0 = (RuleCall)cSymbolAssignment_1_1.eContents().get(0);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Literal Object Reference Specification
		//////////////////////////////////////////////////////////////////////////////////
		//LiteralObjectReference expression::LiteralObjectReference:
		//	'&'? (object=[sew::WObject|UFI] | symbol=UFI);
		@Override public ParserRule getRule() { return rule; }
		
		//'&'? (object=[sew::WObject|UFI] | symbol=UFI)
		public Group getGroup() { return cGroup; }
		
		//'&'?
		public Keyword getAmpersandKeyword_0() { return cAmpersandKeyword_0; }
		
		//object=[sew::WObject|UFI] | symbol=UFI
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//object=[sew::WObject|UFI]
		public Assignment getObjectAssignment_1_0() { return cObjectAssignment_1_0; }
		
		//[sew::WObject|UFI]
		public CrossReference getObjectWObjectCrossReference_1_0_0() { return cObjectWObjectCrossReference_1_0_0; }
		
		//UFI
		public RuleCall getObjectWObjectUFIParserRuleCall_1_0_0_1() { return cObjectWObjectUFIParserRuleCall_1_0_0_1; }
		
		//symbol=UFI
		public Assignment getSymbolAssignment_1_1() { return cSymbolAssignment_1_1; }
		
		//UFI
		public RuleCall getSymbolUFIParserRuleCall_1_1_0() { return cSymbolUFIParserRuleCall_1_1_0; }
	}
	public class LiteralBooleanValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralBooleanValue");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueEBooleanParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Literal Specification
		//////////////////////////////////////////////////////////////////////////////////
		//LiteralBooleanValue expression::LiteralBooleanValue:
		//	value=EBoolean;
		@Override public ParserRule getRule() { return rule; }
		
		//value=EBoolean
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//EBoolean
		public RuleCall getValueEBooleanParserRuleCall_0() { return cValueEBooleanParserRuleCall_0; }
	}
	public class LiteralCharacterValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralCharacterValue");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueECharParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//LiteralCharacterValue expression::LiteralCharacterValue:
		//	value=EChar;
		@Override public ParserRule getRule() { return rule; }
		
		//value=EChar
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//EChar
		public RuleCall getValueECharParserRuleCall_0() { return cValueECharParserRuleCall_0; }
	}
	public class LiteralIntegerValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralIntegerValue");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueELongParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//LiteralIntegerValue expression::LiteralIntegerValue:
		//	value=ELong;
		@Override public ParserRule getRule() { return rule; }
		
		//value=ELong
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//ELong
		public RuleCall getValueELongParserRuleCall_0() { return cValueELongParserRuleCall_0; }
	}
	public class LiteralRationalValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralRationalValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNumeratorAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNumeratorELongParserRuleCall_0_0 = (RuleCall)cNumeratorAssignment_0.eContents().get(0);
		private final Keyword cSolidusKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDenominatorAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDenominatorELongParserRuleCall_2_0 = (RuleCall)cDenominatorAssignment_2.eContents().get(0);
		
		//LiteralRationalValue expression::LiteralRationalValue:
		//	numerator=ELong '/' denominator=ELong;
		@Override public ParserRule getRule() { return rule; }
		
		//numerator=ELong '/' denominator=ELong
		public Group getGroup() { return cGroup; }
		
		//numerator=ELong
		public Assignment getNumeratorAssignment_0() { return cNumeratorAssignment_0; }
		
		//ELong
		public RuleCall getNumeratorELongParserRuleCall_0_0() { return cNumeratorELongParserRuleCall_0_0; }
		
		//'/'
		public Keyword getSolidusKeyword_1() { return cSolidusKeyword_1; }
		
		//denominator=ELong
		public Assignment getDenominatorAssignment_2() { return cDenominatorAssignment_2; }
		
		//ELong
		public RuleCall getDenominatorELongParserRuleCall_2_0() { return cDenominatorELongParserRuleCall_2_0; }
	}
	public class LiteralFloatValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralFloatValue");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueEDoubleParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//LiteralFloatValue expression::LiteralFloatValue:
		//	value=EDouble;
		@Override public ParserRule getRule() { return rule; }
		
		//value=EDouble
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//EDouble
		public RuleCall getValueEDoubleParserRuleCall_0() { return cValueEDoubleParserRuleCall_0; }
	}
	public class LiteralRealValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralRealValue");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueEBigDecimalParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//LiteralRealValue expression::LiteralRealValue:
		//	value=EBigDecimal;
		@Override public ParserRule getRule() { return rule; }
		
		//value=EBigDecimal
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//EBigDecimal
		public RuleCall getValueEBigDecimalParserRuleCall_0() { return cValueEBigDecimalParserRuleCall_0; }
	}
	public class LiteralStringValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralStringValue");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueEStringParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//LiteralStringValue expression::LiteralStringValue:
		//	value=EString;
		@Override public ParserRule getRule() { return rule; }
		
		//value=EString
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//EString
		public RuleCall getValueEStringParserRuleCall_0() { return cValueEStringParserRuleCall_0; }
	}
	public class LiteralNullValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralNullValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralNullValueAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNullKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLessThanSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTypeXIDParserRuleCall_2_1_0 = (RuleCall)cTypeAssignment_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		
		//LiteralNullValue expression::LiteralNullValue:
		//	{expression::LiteralNullValue}
		//	'null' ('<' type=XID '>')?;
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralNullValue} 'null' ('<' type=XID '>')?
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralNullValue}
		public Action getLiteralNullValueAction_0() { return cLiteralNullValueAction_0; }
		
		//'null'
		public Keyword getNullKeyword_1() { return cNullKeyword_1; }
		
		//('<' type=XID '>')?
		public Group getGroup_2() { return cGroup_2; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2_0() { return cLessThanSignKeyword_2_0; }
		
		//type=XID
		public Assignment getTypeAssignment_2_1() { return cTypeAssignment_2_1; }
		
		//XID
		public RuleCall getTypeXIDParserRuleCall_2_1_0() { return cTypeXIDParserRuleCall_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_2() { return cGreaterThanSignKeyword_2_2; }
	}
	public class LiteralVariableReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralVariableReference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralTimeVariableParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLiteralTimeDeltaVariableParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//LiteralVariableReference expression::LiteralReferenceValue:
		//	LiteralTimeVariable
		//	| LiteralTimeDeltaVariable;
		@Override public ParserRule getRule() { return rule; }
		
		//LiteralTimeVariable | LiteralTimeDeltaVariable
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//LiteralTimeVariable
		public RuleCall getLiteralTimeVariableParserRuleCall_0() { return cLiteralTimeVariableParserRuleCall_0; }
		
		//LiteralTimeDeltaVariable
		public RuleCall getLiteralTimeDeltaVariableParserRuleCall_1() { return cLiteralTimeDeltaVariableParserRuleCall_1; }
	}
	public class LiteralTimeVariableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralTimeVariable");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralTimeVariableAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cSymbolTimeKeyword_1_0 = (Keyword)cSymbolAssignment_1.eContents().get(0);
		
		//LiteralTimeVariable expression::LiteralTimeVariable:
		//	{expression::LiteralTimeVariable} symbol='$time';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralTimeVariable} symbol='$time'
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralTimeVariable}
		public Action getLiteralTimeVariableAction_0() { return cLiteralTimeVariableAction_0; }
		
		//symbol='$time'
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }
		
		//'$time'
		public Keyword getSymbolTimeKeyword_1_0() { return cSymbolTimeKeyword_1_0; }
	}
	public class LiteralTimeDeltaVariableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralTimeDeltaVariable");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralTimeDeltaVariableAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cSymbolDeltaKeyword_1_0 = (Keyword)cSymbolAssignment_1.eContents().get(0);
		
		//LiteralTimeDeltaVariable expression::LiteralTimeDeltaVariable:
		//	{expression::LiteralTimeDeltaVariable} symbol='$delta';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralTimeDeltaVariable} symbol='$delta'
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralTimeDeltaVariable}
		public Action getLiteralTimeDeltaVariableAction_0() { return cLiteralTimeDeltaVariableAction_0; }
		
		//symbol='$delta'
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }
		
		//'$delta'
		public Keyword getSymbolDeltaKeyword_1_0() { return cSymbolDeltaKeyword_1_0; }
	}
	public class LiteralInstanceReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralInstanceReference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralThisInstanceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLiteralSelfInstanceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLiteralParentInstanceParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLiteralSuperInstanceParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cLiteralSystemInstanceParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cLiteralEnvInstanceParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//LiteralInstanceReference expression::LiteralReferenceValue:
		//	LiteralThisInstance
		//	| LiteralSelfInstance
		//	| LiteralParentInstance
		//	| LiteralSuperInstance
		//	| LiteralSystemInstance
		//	| LiteralEnvInstance;
		@Override public ParserRule getRule() { return rule; }
		
		//LiteralThisInstance | LiteralSelfInstance | LiteralParentInstance | LiteralSuperInstance | LiteralSystemInstance |
		//LiteralEnvInstance
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//LiteralThisInstance
		public RuleCall getLiteralThisInstanceParserRuleCall_0() { return cLiteralThisInstanceParserRuleCall_0; }
		
		//LiteralSelfInstance
		public RuleCall getLiteralSelfInstanceParserRuleCall_1() { return cLiteralSelfInstanceParserRuleCall_1; }
		
		//LiteralParentInstance
		public RuleCall getLiteralParentInstanceParserRuleCall_2() { return cLiteralParentInstanceParserRuleCall_2; }
		
		//LiteralSuperInstance
		public RuleCall getLiteralSuperInstanceParserRuleCall_3() { return cLiteralSuperInstanceParserRuleCall_3; }
		
		//LiteralSystemInstance
		public RuleCall getLiteralSystemInstanceParserRuleCall_4() { return cLiteralSystemInstanceParserRuleCall_4; }
		
		//LiteralEnvInstance
		public RuleCall getLiteralEnvInstanceParserRuleCall_5() { return cLiteralEnvInstanceParserRuleCall_5; }
	}
	public class LiteralThisInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralThisInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralThisInstanceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cSymbolThisKeyword_1_0 = (Keyword)cSymbolAssignment_1.eContents().get(0);
		
		//LiteralThisInstance expression::LiteralThisInstance:
		//	{expression::LiteralThisInstance} symbol='$this';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralThisInstance} symbol='$this'
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralThisInstance}
		public Action getLiteralThisInstanceAction_0() { return cLiteralThisInstanceAction_0; }
		
		//symbol='$this'
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }
		
		//'$this'
		public Keyword getSymbolThisKeyword_1_0() { return cSymbolThisKeyword_1_0; }
	}
	public class LiteralSelfInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralSelfInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralSelfInstanceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cSymbolSelfKeyword_1_0 = (Keyword)cSymbolAssignment_1.eContents().get(0);
		
		//LiteralSelfInstance expression::LiteralSelfInstance:
		//	{expression::LiteralSelfInstance} symbol='$self';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralSelfInstance} symbol='$self'
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralSelfInstance}
		public Action getLiteralSelfInstanceAction_0() { return cLiteralSelfInstanceAction_0; }
		
		//symbol='$self'
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }
		
		//'$self'
		public Keyword getSymbolSelfKeyword_1_0() { return cSymbolSelfKeyword_1_0; }
	}
	public class LiteralParentInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralParentInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralParentInstanceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cSymbolParentKeyword_1_0 = (Keyword)cSymbolAssignment_1.eContents().get(0);
		
		//LiteralParentInstance expression::LiteralParentInstance:
		//	{expression::LiteralParentInstance} symbol='$parent';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralParentInstance} symbol='$parent'
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralParentInstance}
		public Action getLiteralParentInstanceAction_0() { return cLiteralParentInstanceAction_0; }
		
		//symbol='$parent'
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }
		
		//'$parent'
		public Keyword getSymbolParentKeyword_1_0() { return cSymbolParentKeyword_1_0; }
	}
	public class LiteralSuperInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralSuperInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralSuperInstanceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cSymbolSuperKeyword_1_0 = (Keyword)cSymbolAssignment_1.eContents().get(0);
		
		//LiteralSuperInstance expression::LiteralSuperInstance:
		//	{expression::LiteralSuperInstance} symbol='$super';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralSuperInstance} symbol='$super'
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralSuperInstance}
		public Action getLiteralSuperInstanceAction_0() { return cLiteralSuperInstanceAction_0; }
		
		//symbol='$super'
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }
		
		//'$super'
		public Keyword getSymbolSuperKeyword_1_0() { return cSymbolSuperKeyword_1_0; }
	}
	public class LiteralSystemInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralSystemInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralSystemInstanceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cSymbolSystemKeyword_1_0 = (Keyword)cSymbolAssignment_1.eContents().get(0);
		
		//LiteralSystemInstance expression::LiteralSystemInstance:
		//	{expression::LiteralSystemInstance} symbol='$system';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralSystemInstance} symbol='$system'
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralSystemInstance}
		public Action getLiteralSystemInstanceAction_0() { return cLiteralSystemInstanceAction_0; }
		
		//symbol='$system'
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }
		
		//'$system'
		public Keyword getSymbolSystemKeyword_1_0() { return cSymbolSystemKeyword_1_0; }
	}
	public class LiteralEnvInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.LiteralEnvInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralEnvInstanceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cSymbolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cSymbolAlternatives_1_0 = (Alternatives)cSymbolAssignment_1.eContents().get(0);
		private final Keyword cSymbolEnvKeyword_1_0_0 = (Keyword)cSymbolAlternatives_1_0.eContents().get(0);
		private final Keyword cSymbolEnvKeyword_1_0_1 = (Keyword)cSymbolAlternatives_1_0.eContents().get(1);
		
		//LiteralEnvInstance expression::LiteralEnvInstance:
		//	{expression::LiteralEnvInstance} symbol=('$env' | 'env');
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::LiteralEnvInstance} symbol=('$env' | 'env')
		public Group getGroup() { return cGroup; }
		
		//{expression::LiteralEnvInstance}
		public Action getLiteralEnvInstanceAction_0() { return cLiteralEnvInstanceAction_0; }
		
		//symbol=('$env' | 'env')
		public Assignment getSymbolAssignment_1() { return cSymbolAssignment_1; }
		
		//('$env' | 'env')
		public Alternatives getSymbolAlternatives_1_0() { return cSymbolAlternatives_1_0; }
		
		//'$env'
		public Keyword getSymbolEnvKeyword_1_0_0() { return cSymbolEnvKeyword_1_0_0; }
		
		//'env'
		public Keyword getSymbolEnvKeyword_1_0_1() { return cSymbolEnvKeyword_1_0_1; }
	}
	public class EBooleanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.EBoolean");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cTrueKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cFalseKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// Terminal Rules
		//////////////////////////////////////////////////////////////////////////////////
		//EBoolean ecore::EBoolean:
		//	'true'
		//	| 'false';
		@Override public ParserRule getRule() { return rule; }
		
		//'true' | 'false'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'true'
		public Keyword getTrueKeyword_0() { return cTrueKeyword_0; }
		
		//'false'
		public Keyword getFalseKeyword_1() { return cFalseKeyword_1; }
	}
	public class ECharElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.EChar");
		private final RuleCall cCHARACTERTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//EChar ecore::EChar:
		//	CHARACTER;
		@Override public ParserRule getRule() { return rule; }
		
		//CHARACTER
		public RuleCall getCHARACTERTerminalRuleCall() { return cCHARACTERTerminalRuleCall; }
	}
	public class ELongElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.ELong");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//ELong ecore::ELong:
		//	'-'? INT;
		@Override public ParserRule getRule() { return rule; }
		
		//'-'? INT
		public Group getGroup() { return cGroup; }
		
		//'-'?
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
	}
	public class EDoubleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.EDouble");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cINTTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//EDouble ecore::EDouble:
		//	'-'? INT? '.' INT //(('E'|'e') '-'? INT)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'-'? INT? '.' INT
		public Group getGroup() { return cGroup; }
		
		//'-'?
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }
		
		//INT?
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_3() { return cINTTerminalRuleCall_3; }
	}
	public class EBigDecimalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.EBigDecimal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//EBigDecimal ecore::EBigDecimal:
		//	INT? '.' INT;
		@Override public ParserRule getRule() { return rule; }
		
		//INT? '.' INT
		public Group getGroup() { return cGroup; }
		
		//INT?
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_2() { return cINTTerminalRuleCall_2; }
	}
	public class EStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.EString");
		private final RuleCall cSTRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//EString:
		//	STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall() { return cSTRINGTerminalRuleCall; }
	}
	public class DeprecatedReservedWordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.DeprecatedReservedWord");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cFormKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cEndformKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cPrototypeKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cEndprototypeKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cSectionKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cEndsectionKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		
		//////////////////////////////////////////////////////////////////////////////////
		//// @DEPRECATED Diversity Configuration Specification
		//////////////////////////////////////////////////////////////////////////////////
		//DeprecatedReservedWord:
		//	'form' | 'endform'
		//	| 'prototype' | 'endprototype'
		//	| 'section' | 'endsection';
		@Override public ParserRule getRule() { return rule; }
		
		//'form' | 'endform' | 'prototype' | 'endprototype' | 'section' | 'endsection'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'form'
		public Keyword getFormKeyword_0() { return cFormKeyword_0; }
		
		//'endform'
		public Keyword getEndformKeyword_1() { return cEndformKeyword_1; }
		
		//'prototype'
		public Keyword getPrototypeKeyword_2() { return cPrototypeKeyword_2; }
		
		//'endprototype'
		public Keyword getEndprototypeKeyword_3() { return cEndprototypeKeyword_3; }
		
		//'section'
		public Keyword getSectionKeyword_4() { return cSectionKeyword_4; }
		
		//'endsection'
		public Keyword getEndsectionKeyword_5() { return cEndsectionKeyword_5; }
	}
	public class DeprecatedObjectElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cWObjectAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cFormKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cNameAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cNameUFIParserRuleCall_0_2_0 = (RuleCall)cNameAssignment_0_2.eContents().get(0);
		private final Assignment cDescriptionAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final RuleCall cDescriptionEStringParserRuleCall_0_3_0 = (RuleCall)cDescriptionAssignment_0_3.eContents().get(0);
		private final Keyword cAsKeyword_0_4 = (Keyword)cGroup_0.eContents().get(4);
		private final Keyword cAmpersandKeyword_0_5 = (Keyword)cGroup_0.eContents().get(5);
		private final Assignment cTypeAssignment_0_6 = (Assignment)cGroup_0.eContents().get(6);
		private final RuleCall cTypeUFIParserRuleCall_0_6_0 = (RuleCall)cTypeAssignment_0_6.eContents().get(0);
		private final Keyword cIsKeyword_0_7 = (Keyword)cGroup_0.eContents().get(7);
		private final Assignment cElementAssignment_0_8 = (Assignment)cGroup_0.eContents().get(8);
		private final RuleCall cElementDeprecatedPropertyParserRuleCall_0_8_0 = (RuleCall)cElementAssignment_0_8.eContents().get(0);
		private final Keyword cEndformKeyword_0_9 = (Keyword)cGroup_0.eContents().get(9);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cWObjectAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cPrototypeKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cNameAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cNameUFIParserRuleCall_1_2_0 = (RuleCall)cNameAssignment_1_2.eContents().get(0);
		private final Assignment cDescriptionAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final RuleCall cDescriptionEStringParserRuleCall_1_3_0 = (RuleCall)cDescriptionAssignment_1_3.eContents().get(0);
		private final Keyword cAsKeyword_1_4 = (Keyword)cGroup_1.eContents().get(4);
		private final Keyword cAmpersandKeyword_1_5 = (Keyword)cGroup_1.eContents().get(5);
		private final Assignment cTypeAssignment_1_6 = (Assignment)cGroup_1.eContents().get(6);
		private final RuleCall cTypeUFIParserRuleCall_1_6_0 = (RuleCall)cTypeAssignment_1_6.eContents().get(0);
		private final Keyword cIsKeyword_1_7 = (Keyword)cGroup_1.eContents().get(7);
		private final Assignment cElementAssignment_1_8 = (Assignment)cGroup_1.eContents().get(8);
		private final RuleCall cElementDeprecatedPropertyParserRuleCall_1_8_0 = (RuleCall)cElementAssignment_1_8.eContents().get(0);
		private final Keyword cEndprototypeKeyword_1_9 = (Keyword)cGroup_1.eContents().get(9);
		
		//DeprecatedObject sew::WObject:
		//	{sew::WObject}
		//	'form'
		//	name=UFI description=EString? 'as' '&'? type=UFI 'is'
		//	element+=DeprecatedProperty*
		//	'endform'
		//	| {sew::WObject}
		//	'prototype'
		//	name=UFI description=EString? 'as' '&'? type=UFI 'is'
		//	element+=DeprecatedProperty*
		//	'endprototype';
		@Override public ParserRule getRule() { return rule; }
		
		//{sew::WObject} 'form' name=UFI description=EString? 'as' '&'? type=UFI 'is' element+=DeprecatedProperty* 'endform' |
		//{sew::WObject} 'prototype' name=UFI description=EString? 'as' '&'? type=UFI 'is' element+=DeprecatedProperty*
		//'endprototype'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{sew::WObject} 'form' name=UFI description=EString? 'as' '&'? type=UFI 'is' element+=DeprecatedProperty* 'endform'
		public Group getGroup_0() { return cGroup_0; }
		
		//{sew::WObject}
		public Action getWObjectAction_0_0() { return cWObjectAction_0_0; }
		
		//'form'
		public Keyword getFormKeyword_0_1() { return cFormKeyword_0_1; }
		
		//name=UFI
		public Assignment getNameAssignment_0_2() { return cNameAssignment_0_2; }
		
		//UFI
		public RuleCall getNameUFIParserRuleCall_0_2_0() { return cNameUFIParserRuleCall_0_2_0; }
		
		//description=EString?
		public Assignment getDescriptionAssignment_0_3() { return cDescriptionAssignment_0_3; }
		
		//EString
		public RuleCall getDescriptionEStringParserRuleCall_0_3_0() { return cDescriptionEStringParserRuleCall_0_3_0; }
		
		//'as'
		public Keyword getAsKeyword_0_4() { return cAsKeyword_0_4; }
		
		//'&'?
		public Keyword getAmpersandKeyword_0_5() { return cAmpersandKeyword_0_5; }
		
		//type=UFI
		public Assignment getTypeAssignment_0_6() { return cTypeAssignment_0_6; }
		
		//UFI
		public RuleCall getTypeUFIParserRuleCall_0_6_0() { return cTypeUFIParserRuleCall_0_6_0; }
		
		//'is'
		public Keyword getIsKeyword_0_7() { return cIsKeyword_0_7; }
		
		//element+=DeprecatedProperty*
		public Assignment getElementAssignment_0_8() { return cElementAssignment_0_8; }
		
		//DeprecatedProperty
		public RuleCall getElementDeprecatedPropertyParserRuleCall_0_8_0() { return cElementDeprecatedPropertyParserRuleCall_0_8_0; }
		
		//'endform'
		public Keyword getEndformKeyword_0_9() { return cEndformKeyword_0_9; }
		
		//{sew::WObject} 'prototype' name=UFI description=EString? 'as' '&'? type=UFI 'is' element+=DeprecatedProperty*
		//'endprototype'
		public Group getGroup_1() { return cGroup_1; }
		
		//{sew::WObject}
		public Action getWObjectAction_1_0() { return cWObjectAction_1_0; }
		
		//'prototype'
		public Keyword getPrototypeKeyword_1_1() { return cPrototypeKeyword_1_1; }
		
		//name=UFI
		public Assignment getNameAssignment_1_2() { return cNameAssignment_1_2; }
		
		//UFI
		public RuleCall getNameUFIParserRuleCall_1_2_0() { return cNameUFIParserRuleCall_1_2_0; }
		
		//description=EString?
		public Assignment getDescriptionAssignment_1_3() { return cDescriptionAssignment_1_3; }
		
		//EString
		public RuleCall getDescriptionEStringParserRuleCall_1_3_0() { return cDescriptionEStringParserRuleCall_1_3_0; }
		
		//'as'
		public Keyword getAsKeyword_1_4() { return cAsKeyword_1_4; }
		
		//'&'?
		public Keyword getAmpersandKeyword_1_5() { return cAmpersandKeyword_1_5; }
		
		//type=UFI
		public Assignment getTypeAssignment_1_6() { return cTypeAssignment_1_6; }
		
		//UFI
		public RuleCall getTypeUFIParserRuleCall_1_6_0() { return cTypeUFIParserRuleCall_1_6_0; }
		
		//'is'
		public Keyword getIsKeyword_1_7() { return cIsKeyword_1_7; }
		
		//element+=DeprecatedProperty*
		public Assignment getElementAssignment_1_8() { return cElementAssignment_1_8; }
		
		//DeprecatedProperty
		public RuleCall getElementDeprecatedPropertyParserRuleCall_1_8_0() { return cElementDeprecatedPropertyParserRuleCall_1_8_0; }
		
		//'endprototype'
		public Keyword getEndprototypeKeyword_1_9() { return cEndprototypeKeyword_1_9; }
	}
	public class DeprecatedPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.DeprecatedProperty");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cDeprecatedSectionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDeprecatedAttributeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//DeprecatedProperty sew::WProperty:
		//	DeprecatedSection
		//	| DeprecatedAttribute;
		@Override public ParserRule getRule() { return rule; }
		
		//DeprecatedSection | DeprecatedAttribute
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//DeprecatedSection
		public RuleCall getDeprecatedSectionParserRuleCall_0() { return cDeprecatedSectionParserRuleCall_0; }
		
		//DeprecatedAttribute
		public RuleCall getDeprecatedAttributeParserRuleCall_1() { return cDeprecatedAttributeParserRuleCall_1; }
	}
	public class DeprecatedSectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.DeprecatedSection");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cWSectionAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cSectionKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cNameAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cNameXIDParserRuleCall_0_2_0 = (RuleCall)cNameAssignment_0_2.eContents().get(0);
		private final Assignment cElementAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final Alternatives cElementAlternatives_0_3_0 = (Alternatives)cElementAssignment_0_3.eContents().get(0);
		private final RuleCall cElementDeprecatedAttributeParserRuleCall_0_3_0_0 = (RuleCall)cElementAlternatives_0_3_0.eContents().get(0);
		private final RuleCall cElementDeprecatedObjectParserRuleCall_0_3_0_1 = (RuleCall)cElementAlternatives_0_3_0.eContents().get(1);
		private final RuleCall cElementObjectParserRuleCall_0_3_0_2 = (RuleCall)cElementAlternatives_0_3_0.eContents().get(2);
		private final Keyword cEndsectionKeyword_0_4 = (Keyword)cGroup_0.eContents().get(4);
		private final RuleCall cXIDParserRuleCall_0_5 = (RuleCall)cGroup_0.eContents().get(5);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameXIDParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Assignment cDescriptionAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cDescriptionEStringParserRuleCall_1_1_0 = (RuleCall)cDescriptionAssignment_1_1.eContents().get(0);
		private final Alternatives cAlternatives_1_2 = (Alternatives)cGroup_1.eContents().get(2);
		private final Group cGroup_1_2_0 = (Group)cAlternatives_1_2.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1_2_0_0 = (Keyword)cGroup_1_2_0.eContents().get(0);
		private final Assignment cElementAssignment_1_2_0_1 = (Assignment)cGroup_1_2_0.eContents().get(1);
		private final Alternatives cElementAlternatives_1_2_0_1_0 = (Alternatives)cElementAssignment_1_2_0_1.eContents().get(0);
		private final RuleCall cElementDeprecatedAttributeParserRuleCall_1_2_0_1_0_0 = (RuleCall)cElementAlternatives_1_2_0_1_0.eContents().get(0);
		private final RuleCall cElementDeprecatedObjectParserRuleCall_1_2_0_1_0_1 = (RuleCall)cElementAlternatives_1_2_0_1_0.eContents().get(1);
		private final RuleCall cElementObjectParserRuleCall_1_2_0_1_0_2 = (RuleCall)cElementAlternatives_1_2_0_1_0.eContents().get(2);
		private final Keyword cRightSquareBracketKeyword_1_2_0_2 = (Keyword)cGroup_1_2_0.eContents().get(2);
		private final Group cGroup_1_2_1 = (Group)cAlternatives_1_2.eContents().get(1);
		private final Keyword cColonKeyword_1_2_1_0 = (Keyword)cGroup_1_2_1.eContents().get(0);
		private final Assignment cElementAssignment_1_2_1_1 = (Assignment)cGroup_1_2_1.eContents().get(1);
		private final Alternatives cElementAlternatives_1_2_1_1_0 = (Alternatives)cElementAssignment_1_2_1_1.eContents().get(0);
		private final RuleCall cElementDeprecatedAttributeParserRuleCall_1_2_1_1_0_0 = (RuleCall)cElementAlternatives_1_2_1_1_0.eContents().get(0);
		private final RuleCall cElementDeprecatedObjectParserRuleCall_1_2_1_1_0_1 = (RuleCall)cElementAlternatives_1_2_1_1_0.eContents().get(1);
		private final RuleCall cElementObjectParserRuleCall_1_2_1_1_0_2 = (RuleCall)cElementAlternatives_1_2_1_1_0.eContents().get(2);
		
		//DeprecatedSection sew::WSection:
		//	{sew::WSection}
		//	'section' name=XID
		//	//		( element+=( Object | Attribute  ) )*
		//	element+=(DeprecatedAttribute | DeprecatedObject | Object)*
		//	'endsection' XID?
		//	| name=XID description=EString? ('[' element+=(DeprecatedAttribute | DeprecatedObject | Object)* ']'
		//	| ':' element+=(DeprecatedAttribute | DeprecatedObject | Object)*);
		@Override public ParserRule getRule() { return rule; }
		
		//{sew::WSection} 'section' name=XID //		( element+=( Object | Attribute  ) )*
		//element+=(DeprecatedAttribute | DeprecatedObject | Object)* 'endsection' XID? | name=XID description=EString? ('['
		//element+=(DeprecatedAttribute | DeprecatedObject | Object)* ']' | ':' element+=(DeprecatedAttribute | DeprecatedObject
		//| Object)*)
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{sew::WSection} 'section' name=XID //		( element+=( Object | Attribute  ) )*
		//element+=(DeprecatedAttribute | DeprecatedObject | Object)* 'endsection' XID?
		public Group getGroup_0() { return cGroup_0; }
		
		//{sew::WSection}
		public Action getWSectionAction_0_0() { return cWSectionAction_0_0; }
		
		//'section'
		public Keyword getSectionKeyword_0_1() { return cSectionKeyword_0_1; }
		
		//name=XID
		public Assignment getNameAssignment_0_2() { return cNameAssignment_0_2; }
		
		//XID
		public RuleCall getNameXIDParserRuleCall_0_2_0() { return cNameXIDParserRuleCall_0_2_0; }
		
		////		( element+=( Object | Attribute  ) )*
		//element+=(DeprecatedAttribute | DeprecatedObject | Object)*
		public Assignment getElementAssignment_0_3() { return cElementAssignment_0_3; }
		
		//(DeprecatedAttribute | DeprecatedObject | Object)
		public Alternatives getElementAlternatives_0_3_0() { return cElementAlternatives_0_3_0; }
		
		//DeprecatedAttribute
		public RuleCall getElementDeprecatedAttributeParserRuleCall_0_3_0_0() { return cElementDeprecatedAttributeParserRuleCall_0_3_0_0; }
		
		//DeprecatedObject
		public RuleCall getElementDeprecatedObjectParserRuleCall_0_3_0_1() { return cElementDeprecatedObjectParserRuleCall_0_3_0_1; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_0_3_0_2() { return cElementObjectParserRuleCall_0_3_0_2; }
		
		//'endsection'
		public Keyword getEndsectionKeyword_0_4() { return cEndsectionKeyword_0_4; }
		
		//XID?
		public RuleCall getXIDParserRuleCall_0_5() { return cXIDParserRuleCall_0_5; }
		
		//name=XID description=EString? ('[' element+=(DeprecatedAttribute | DeprecatedObject | Object)* ']' | ':'
		//element+=(DeprecatedAttribute | DeprecatedObject | Object)*)
		public Group getGroup_1() { return cGroup_1; }
		
		//name=XID
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }
		
		//XID
		public RuleCall getNameXIDParserRuleCall_1_0_0() { return cNameXIDParserRuleCall_1_0_0; }
		
		//description=EString?
		public Assignment getDescriptionAssignment_1_1() { return cDescriptionAssignment_1_1; }
		
		//EString
		public RuleCall getDescriptionEStringParserRuleCall_1_1_0() { return cDescriptionEStringParserRuleCall_1_1_0; }
		
		//'[' element+=(DeprecatedAttribute | DeprecatedObject | Object)* ']' | ':' element+=(DeprecatedAttribute |
		//DeprecatedObject | Object)*
		public Alternatives getAlternatives_1_2() { return cAlternatives_1_2; }
		
		//'[' element+=(DeprecatedAttribute | DeprecatedObject | Object)* ']'
		public Group getGroup_1_2_0() { return cGroup_1_2_0; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_1_2_0_0() { return cLeftSquareBracketKeyword_1_2_0_0; }
		
		//element+=(DeprecatedAttribute | DeprecatedObject | Object)*
		public Assignment getElementAssignment_1_2_0_1() { return cElementAssignment_1_2_0_1; }
		
		//(DeprecatedAttribute | DeprecatedObject | Object)
		public Alternatives getElementAlternatives_1_2_0_1_0() { return cElementAlternatives_1_2_0_1_0; }
		
		//DeprecatedAttribute
		public RuleCall getElementDeprecatedAttributeParserRuleCall_1_2_0_1_0_0() { return cElementDeprecatedAttributeParserRuleCall_1_2_0_1_0_0; }
		
		//DeprecatedObject
		public RuleCall getElementDeprecatedObjectParserRuleCall_1_2_0_1_0_1() { return cElementDeprecatedObjectParserRuleCall_1_2_0_1_0_1; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_1_2_0_1_0_2() { return cElementObjectParserRuleCall_1_2_0_1_0_2; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_1_2_0_2() { return cRightSquareBracketKeyword_1_2_0_2; }
		
		//':' element+=(DeprecatedAttribute | DeprecatedObject | Object)*
		public Group getGroup_1_2_1() { return cGroup_1_2_1; }
		
		//':'
		public Keyword getColonKeyword_1_2_1_0() { return cColonKeyword_1_2_1_0; }
		
		//element+=(DeprecatedAttribute | DeprecatedObject | Object)*
		public Assignment getElementAssignment_1_2_1_1() { return cElementAssignment_1_2_1_1; }
		
		//(DeprecatedAttribute | DeprecatedObject | Object)
		public Alternatives getElementAlternatives_1_2_1_1_0() { return cElementAlternatives_1_2_1_1_0; }
		
		//DeprecatedAttribute
		public RuleCall getElementDeprecatedAttributeParserRuleCall_1_2_1_1_0_0() { return cElementDeprecatedAttributeParserRuleCall_1_2_1_1_0_0; }
		
		//DeprecatedObject
		public RuleCall getElementDeprecatedObjectParserRuleCall_1_2_1_1_0_1() { return cElementDeprecatedObjectParserRuleCall_1_2_1_1_0_1; }
		
		//Object
		public RuleCall getElementObjectParserRuleCall_1_2_1_1_0_2() { return cElementObjectParserRuleCall_1_2_1_1_0_2; }
	}
	public class DeprecatedAttributeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.DeprecatedAttribute");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cWAttributeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameDeprecatedAttributeIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueValueSpecificationParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//DeprecatedAttribute sew::WAttribute:
		//	{sew::WAttribute} name=DeprecatedAttributeID '=' value=ValueSpecification ';'?;
		@Override public ParserRule getRule() { return rule; }
		
		//{sew::WAttribute} name=DeprecatedAttributeID '=' value=ValueSpecification ';'?
		public Group getGroup() { return cGroup; }
		
		//{sew::WAttribute}
		public Action getWAttributeAction_0() { return cWAttributeAction_0; }
		
		//name=DeprecatedAttributeID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//DeprecatedAttributeID
		public RuleCall getNameDeprecatedAttributeIDParserRuleCall_1_0() { return cNameDeprecatedAttributeIDParserRuleCall_1_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//value=ValueSpecification
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//ValueSpecification
		public RuleCall getValueValueSpecificationParserRuleCall_3_0() { return cValueValueSpecificationParserRuleCall_3_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class DeprecatedAttributeIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.DeprecatedAttributeID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cXIDParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAT_IDENTIFIERTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//DeprecatedAttributeID:
		//	XID
		//	| AT_IDENTIFIER;
		@Override public ParserRule getRule() { return rule; }
		
		//XID | AT_IDENTIFIER
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//XID
		public RuleCall getXIDParserRuleCall_0() { return cXIDParserRuleCall_0; }
		
		//AT_IDENTIFIER
		public RuleCall getAT_IDENTIFIERTerminalRuleCall_1() { return cAT_IDENTIFIERTerminalRuleCall_1; }
	}
	public class DeprecatedExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.DeprecatedExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cDollarSignLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOperatorAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cOperatorAlternatives_2_0 = (Alternatives)cOperatorAssignment_2.eContents().get(0);
		private final Keyword cOperatorVerticalLineSemicolonVerticalLineKeyword_2_0_0 = (Keyword)cOperatorAlternatives_2_0.eContents().get(0);
		private final Keyword cOperatorIKeyword_2_0_1 = (Keyword)cOperatorAlternatives_2_0.eContents().get(1);
		private final Assignment cOperandAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOperandValueSpecificationParserRuleCall_3_0 = (RuleCall)cOperandAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//DeprecatedExpression sew::WValueSpecification:
		//	{expression::Expression}
		//	'${'
		//	operator=('|;|' | '|i|') operand+=ValueSpecification*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{expression::Expression} '${' operator=('|;|' | '|i|') operand+=ValueSpecification* '}'
		public Group getGroup() { return cGroup; }
		
		//{expression::Expression}
		public Action getExpressionAction_0() { return cExpressionAction_0; }
		
		//'${'
		public Keyword getDollarSignLeftCurlyBracketKeyword_1() { return cDollarSignLeftCurlyBracketKeyword_1; }
		
		//operator=('|;|' | '|i|')
		public Assignment getOperatorAssignment_2() { return cOperatorAssignment_2; }
		
		//('|;|' | '|i|')
		public Alternatives getOperatorAlternatives_2_0() { return cOperatorAlternatives_2_0; }
		
		//'|;|'
		public Keyword getOperatorVerticalLineSemicolonVerticalLineKeyword_2_0_0() { return cOperatorVerticalLineSemicolonVerticalLineKeyword_2_0_0; }
		
		//'|i|'
		public Keyword getOperatorIKeyword_2_0_1() { return cOperatorIKeyword_2_0_1; }
		
		//operand+=ValueSpecification*
		public Assignment getOperandAssignment_3() { return cOperandAssignment_3; }
		
		//ValueSpecification
		public RuleCall getOperandValueSpecificationParserRuleCall_3_0() { return cOperandValueSpecificationParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	
	
	private final WorkflowElements pWorkflow;
	private final PrologElements pProlog;
	private final ReservedWordElements pReservedWord;
	private final TerminalRule tXIDENDIFIER;
	private final TerminalRule tAT_IDENTIFIER;
	private final XIDElements pXID;
	private final UFIElements pUFI;
	private final ObjectElements pObject;
	private final PropertyElements pProperty;
	private final SectionElements pSection;
	private final AttributeElements pAttribute;
	private final ValueSpecificationElements pValueSpecification;
	private final ExpressionElements pExpression;
	private final ConditionalExpressionElements pConditionalExpression;
	private final ConditionalOrExpressionElements pConditionalOrExpression;
	private final ConditionalAndExpressionElements pConditionalAndExpression;
	private final EqualityExpressionElements pEqualityExpression;
	private final RelationalExpressionElements pRelationalExpression;
	private final AdditiveExpressionElements pAdditiveExpression;
	private final MultiplicativeExpressionElements pMultiplicativeExpression;
	private final PrimaryExpressionElements pPrimaryExpression;
	private final LiteralExpressionElements pLiteralExpression;
	private final LiteralArrayValueElements pLiteralArrayValue;
	private final LiteralObjectReferenceElements pLiteralObjectReference;
	private final LiteralBooleanValueElements pLiteralBooleanValue;
	private final LiteralCharacterValueElements pLiteralCharacterValue;
	private final LiteralIntegerValueElements pLiteralIntegerValue;
	private final LiteralRationalValueElements pLiteralRationalValue;
	private final LiteralFloatValueElements pLiteralFloatValue;
	private final LiteralRealValueElements pLiteralRealValue;
	private final LiteralStringValueElements pLiteralStringValue;
	private final LiteralNullValueElements pLiteralNullValue;
	private final LiteralVariableReferenceElements pLiteralVariableReference;
	private final LiteralTimeVariableElements pLiteralTimeVariable;
	private final LiteralTimeDeltaVariableElements pLiteralTimeDeltaVariable;
	private final LiteralInstanceReferenceElements pLiteralInstanceReference;
	private final LiteralThisInstanceElements pLiteralThisInstance;
	private final LiteralSelfInstanceElements pLiteralSelfInstance;
	private final LiteralParentInstanceElements pLiteralParentInstance;
	private final LiteralSuperInstanceElements pLiteralSuperInstance;
	private final LiteralSystemInstanceElements pLiteralSystemInstance;
	private final LiteralEnvInstanceElements pLiteralEnvInstance;
	private final EBooleanElements pEBoolean;
	private final TerminalRule tCHARACTER;
	private final ECharElements pEChar;
	private final ELongElements pELong;
	private final EDoubleElements pEDouble;
	private final EBigDecimalElements pEBigDecimal;
	private final EStringElements pEString;
	private final DeprecatedReservedWordElements pDeprecatedReservedWord;
	private final DeprecatedObjectElements pDeprecatedObject;
	private final DeprecatedPropertyElements pDeprecatedProperty;
	private final DeprecatedSectionElements pDeprecatedSection;
	private final DeprecatedAttributeElements pDeprecatedAttribute;
	private final DeprecatedAttributeIDElements pDeprecatedAttributeID;
	private final DeprecatedExpressionElements pDeprecatedExpression;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public SEWGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pWorkflow = new WorkflowElements();
		this.pProlog = new PrologElements();
		this.pReservedWord = new ReservedWordElements();
		this.tXIDENDIFIER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.XIDENDIFIER");
		this.tAT_IDENTIFIER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.AT_IDENTIFIER");
		this.pXID = new XIDElements();
		this.pUFI = new UFIElements();
		this.pObject = new ObjectElements();
		this.pProperty = new PropertyElements();
		this.pSection = new SectionElements();
		this.pAttribute = new AttributeElements();
		this.pValueSpecification = new ValueSpecificationElements();
		this.pExpression = new ExpressionElements();
		this.pConditionalExpression = new ConditionalExpressionElements();
		this.pConditionalOrExpression = new ConditionalOrExpressionElements();
		this.pConditionalAndExpression = new ConditionalAndExpressionElements();
		this.pEqualityExpression = new EqualityExpressionElements();
		this.pRelationalExpression = new RelationalExpressionElements();
		this.pAdditiveExpression = new AdditiveExpressionElements();
		this.pMultiplicativeExpression = new MultiplicativeExpressionElements();
		this.pPrimaryExpression = new PrimaryExpressionElements();
		this.pLiteralExpression = new LiteralExpressionElements();
		this.pLiteralArrayValue = new LiteralArrayValueElements();
		this.pLiteralObjectReference = new LiteralObjectReferenceElements();
		this.pLiteralBooleanValue = new LiteralBooleanValueElements();
		this.pLiteralCharacterValue = new LiteralCharacterValueElements();
		this.pLiteralIntegerValue = new LiteralIntegerValueElements();
		this.pLiteralRationalValue = new LiteralRationalValueElements();
		this.pLiteralFloatValue = new LiteralFloatValueElements();
		this.pLiteralRealValue = new LiteralRealValueElements();
		this.pLiteralStringValue = new LiteralStringValueElements();
		this.pLiteralNullValue = new LiteralNullValueElements();
		this.pLiteralVariableReference = new LiteralVariableReferenceElements();
		this.pLiteralTimeVariable = new LiteralTimeVariableElements();
		this.pLiteralTimeDeltaVariable = new LiteralTimeDeltaVariableElements();
		this.pLiteralInstanceReference = new LiteralInstanceReferenceElements();
		this.pLiteralThisInstance = new LiteralThisInstanceElements();
		this.pLiteralSelfInstance = new LiteralSelfInstanceElements();
		this.pLiteralParentInstance = new LiteralParentInstanceElements();
		this.pLiteralSuperInstance = new LiteralSuperInstanceElements();
		this.pLiteralSystemInstance = new LiteralSystemInstanceElements();
		this.pLiteralEnvInstance = new LiteralEnvInstanceElements();
		this.pEBoolean = new EBooleanElements();
		this.tCHARACTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.efm.sew.xtext.SEW.CHARACTER");
		this.pEChar = new ECharElements();
		this.pELong = new ELongElements();
		this.pEDouble = new EDoubleElements();
		this.pEBigDecimal = new EBigDecimalElements();
		this.pEString = new EStringElements();
		this.pDeprecatedReservedWord = new DeprecatedReservedWordElements();
		this.pDeprecatedObject = new DeprecatedObjectElements();
		this.pDeprecatedProperty = new DeprecatedPropertyElements();
		this.pDeprecatedSection = new DeprecatedSectionElements();
		this.pDeprecatedAttribute = new DeprecatedAttributeElements();
		this.pDeprecatedAttributeID = new DeprecatedAttributeIDElements();
		this.pDeprecatedExpression = new DeprecatedExpressionElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.efm.sew.xtext.SEW".equals(grammar.getName())) {
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

	
	//////////////////////////////////////////////////////////////////////////////////
	//// Symbolic Execution Workflow Specification
	//////////////////////////////////////////////////////////////////////////////////
	//Workflow sew::SEWorkflow:
	//	{sew::SEWorkflow} Prolog? (type=('workflow' | 'symbex-workflow') name=UFI? description=EString?
	//	'{'
	//	element+=(Object | Property)*
	//	'}'
	//	// for Xtext Embeded Editor
	//	| element+=(Object | Property)*
	//	// Deprecated Object as FAVM Workflow
	//	| element+=DeprecatedObject);
	public WorkflowElements getWorkflowAccess() {
		return pWorkflow;
	}
	
	public ParserRule getWorkflowRule() {
		return getWorkflowAccess().getRule();
	}
	
	//Prolog:
	//	('@sew' | '@favm') '<' ('workflow' | 'sew') (',' 'version:'? EDouble | UFI | EString)? '>:';
	public PrologElements getPrologAccess() {
		return pProlog;
	}
	
	public ParserRule getPrologRule() {
		return getPrologAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// [ Qualified ] Identifier
	//////////////////////////////////////////////////////////////////////////////////
	//ReservedWord:
	//	'workflow' | 'sew'
	//	// Deprecated
	//	| DeprecatedReservedWord;
	public ReservedWordElements getReservedWordAccess() {
		return pReservedWord;
	}
	
	public ParserRule getReservedWordRule() {
		return getReservedWordAccess().getRule();
	}
	
	//terminal XIDENDIFIER:
	//	('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '#')*;
	public TerminalRule getXIDENDIFIERRule() {
		return tXIDENDIFIER;
	}
	
	//terminal AT_IDENTIFIER:
	//	'@' XIDENDIFIER;
	public TerminalRule getAT_IDENTIFIERRule() {
		return tAT_IDENTIFIER;
	}
	
	//XID:
	//	ReservedWord | XIDENDIFIER;
	public XIDElements getXIDAccess() {
		return pXID;
	}
	
	public ParserRule getXIDRule() {
		return getXIDAccess().getRule();
	}
	
	//UFI:
	//	XID (('::' | '.') XID)*;
	public UFIElements getUFIAccess() {
		return pUFI;
	}
	
	public ParserRule getUFIRule() {
		return getUFIAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Object Configuration Specification
	//////////////////////////////////////////////////////////////////////////////////
	//Object sew::WObject:
	//	{sew::WObject} type=UFI name=UFI? description=EString?
	//	'{'
	//	element+=(Object | Property)*
	//	'}'
	//	| {sew::WObject} name=UFI (':=' | '+:=') (type=UFI description=EString?)?
	//	'{'
	//	element+=(Object | Property)*
	//	'}';
	public ObjectElements getObjectAccess() {
		return pObject;
	}
	
	public ParserRule getObjectRule() {
		return getObjectAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Property Specification
	//////////////////////////////////////////////////////////////////////////////////
	//Property sew::WProperty:
	//	Section
	//	| Attribute;
	public PropertyElements getPropertyAccess() {
		return pProperty;
	}
	
	public ParserRule getPropertyRule() {
		return getPropertyAccess().getRule();
	}
	
	//Section sew::WSection:
	//	name=XID description=EString? ('[' element+=(Object | Attribute)* ']'
	//	| ':' element+=(Object | Attribute)*);
	public SectionElements getSectionAccess() {
		return pSection;
	}
	
	public ParserRule getSectionRule() {
		return getSectionAccess().getRule();
	}
	
	//Attribute sew::WAttribute:
	//	{sew::WAttribute} name=XID '=' value=ValueSpecification ';'?;
	public AttributeElements getAttributeAccess() {
		return pAttribute;
	}
	
	public ParserRule getAttributeRule() {
		return getAttributeAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Value Specification
	//////////////////////////////////////////////////////////////////////////////////
	//ValueSpecification sew::WValueSpecification:
	//	Expression;
	public ValueSpecificationElements getValueSpecificationAccess() {
		return pValueSpecification;
	}
	
	public ParserRule getValueSpecificationRule() {
		return getValueSpecificationAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Expression Specification
	//////////////////////////////////////////////////////////////////////////////////
	//Expression sew::WValueSpecification:
	//	conditionalExpression
	//	// Deprecated
	//	| DeprecatedExpression;
	public ExpressionElements getExpressionAccess() {
		return pExpression;
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}
	
	//conditionalExpression sew::WValueSpecification:
	//	conditionalOrExpression ({expression::Expression.operand+=current} operator='?' operand+=Expression ':'
	//	operand+=Expression)?;
	public ConditionalExpressionElements getConditionalExpressionAccess() {
		return pConditionalExpression;
	}
	
	public ParserRule getConditionalExpressionRule() {
		return getConditionalExpressionAccess().getRule();
	}
	
	//conditionalOrExpression sew::WValueSpecification:
	//	conditionalAndExpression ({expression::Expression.operand+=current} operator=('||' | 'or')
	//	operand+=conditionalAndExpression (('||' | 'or') operand+=conditionalAndExpression)*)?;
	public ConditionalOrExpressionElements getConditionalOrExpressionAccess() {
		return pConditionalOrExpression;
	}
	
	public ParserRule getConditionalOrExpressionRule() {
		return getConditionalOrExpressionAccess().getRule();
	}
	
	//conditionalAndExpression sew::WValueSpecification:
	//	equalityExpression ({expression::Expression.operand+=current} operator=('&&' | 'and') operand+=equalityExpression
	//	(('&&' | 'and') operand+=equalityExpression)*)?;
	public ConditionalAndExpressionElements getConditionalAndExpressionAccess() {
		return pConditionalAndExpression;
	}
	
	public ParserRule getConditionalAndExpressionRule() {
		return getConditionalAndExpressionAccess().getRule();
	}
	
	//equalityExpression sew::WValueSpecification:
	//	relationalExpression ({expression::Expression.operand+=current} operator=('==' | '!=' | '===' | '=!=' | '=/=')
	//	operand+=relationalExpression)?;
	public EqualityExpressionElements getEqualityExpressionAccess() {
		return pEqualityExpression;
	}
	
	public ParserRule getEqualityExpressionRule() {
		return getEqualityExpressionAccess().getRule();
	}
	
	//relationalExpression sew::WValueSpecification:
	//	additiveExpression ({expression::Expression.operand+=current} operator=('<' | '<=' | '>' | '>=')
	//	operand+=additiveExpression)?;
	public RelationalExpressionElements getRelationalExpressionAccess() {
		return pRelationalExpression;
	}
	
	public ParserRule getRelationalExpressionRule() {
		return getRelationalExpressionAccess().getRule();
	}
	
	//additiveExpression sew::WValueSpecification:
	//	multiplicativeExpression ({expression::Expression.operand+=current} operator='+' operand+=multiplicativeExpression
	//	('+' operand+=multiplicativeExpression)*)?;
	public AdditiveExpressionElements getAdditiveExpressionAccess() {
		return pAdditiveExpression;
	}
	
	public ParserRule getAdditiveExpressionRule() {
		return getAdditiveExpressionAccess().getRule();
	}
	
	//multiplicativeExpression sew::WValueSpecification:
	//	primaryExpression ({expression::Expression.operand+=current} operator='*' operand+=primaryExpression ('*'
	//	operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='**' operand+=primaryExpression
	//	('**' operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='/'
	//	operand+=primaryExpression ('/' operand+=primaryExpression)* | {expression::Expression.operand+=current} operator='%'
	//	operand+=primaryExpression ('%' operand+=primaryExpression)*)?;
	public MultiplicativeExpressionElements getMultiplicativeExpressionAccess() {
		return pMultiplicativeExpression;
	}
	
	public ParserRule getMultiplicativeExpressionRule() {
		return getMultiplicativeExpressionAccess().getRule();
	}
	
	//primaryExpression sew::WValueSpecification:
	//	'+' primaryExpression
	//	| {expression::Expression} (operator='-' operand+=primaryExpression) | {expression::Expression} (operator=('!' |
	//	'not') operand+=primaryExpression) | '(' Expression ')'
	//	| LiteralExpression;
	public PrimaryExpressionElements getPrimaryExpressionAccess() {
		return pPrimaryExpression;
	}
	
	public ParserRule getPrimaryExpressionRule() {
		return getPrimaryExpressionAccess().getRule();
	}
	
	//LiteralExpression sew::WValueSpecification:
	//	LiteralBooleanValue
	//	| LiteralCharacterValue
	//	| LiteralIntegerValue
	//	| LiteralRationalValue
	//	| LiteralFloatValue
	//	//| LiteralRealValue
	//	| LiteralStringValue
	//	| LiteralNullValue
	//	| LiteralArrayValue
	//	| LiteralObjectReference
	//	| LiteralVariableReference
	//	| LiteralInstanceReference;
	public LiteralExpressionElements getLiteralExpressionAccess() {
		return pLiteralExpression;
	}
	
	public ParserRule getLiteralExpressionRule() {
		return getLiteralExpressionAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Array of Literal Specification
	//////////////////////////////////////////////////////////////////////////////////
	//LiteralArrayValue expression::LiteralArrayValue:
	//	{expression::LiteralArrayValue}
	//	'[' (values+=ValueSpecification (',' values+=ValueSpecification)*)?
	//	']';
	public LiteralArrayValueElements getLiteralArrayValueAccess() {
		return pLiteralArrayValue;
	}
	
	public ParserRule getLiteralArrayValueRule() {
		return getLiteralArrayValueAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Literal Object Reference Specification
	//////////////////////////////////////////////////////////////////////////////////
	//LiteralObjectReference expression::LiteralObjectReference:
	//	'&'? (object=[sew::WObject|UFI] | symbol=UFI);
	public LiteralObjectReferenceElements getLiteralObjectReferenceAccess() {
		return pLiteralObjectReference;
	}
	
	public ParserRule getLiteralObjectReferenceRule() {
		return getLiteralObjectReferenceAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Literal Specification
	//////////////////////////////////////////////////////////////////////////////////
	//LiteralBooleanValue expression::LiteralBooleanValue:
	//	value=EBoolean;
	public LiteralBooleanValueElements getLiteralBooleanValueAccess() {
		return pLiteralBooleanValue;
	}
	
	public ParserRule getLiteralBooleanValueRule() {
		return getLiteralBooleanValueAccess().getRule();
	}
	
	//LiteralCharacterValue expression::LiteralCharacterValue:
	//	value=EChar;
	public LiteralCharacterValueElements getLiteralCharacterValueAccess() {
		return pLiteralCharacterValue;
	}
	
	public ParserRule getLiteralCharacterValueRule() {
		return getLiteralCharacterValueAccess().getRule();
	}
	
	//LiteralIntegerValue expression::LiteralIntegerValue:
	//	value=ELong;
	public LiteralIntegerValueElements getLiteralIntegerValueAccess() {
		return pLiteralIntegerValue;
	}
	
	public ParserRule getLiteralIntegerValueRule() {
		return getLiteralIntegerValueAccess().getRule();
	}
	
	//LiteralRationalValue expression::LiteralRationalValue:
	//	numerator=ELong '/' denominator=ELong;
	public LiteralRationalValueElements getLiteralRationalValueAccess() {
		return pLiteralRationalValue;
	}
	
	public ParserRule getLiteralRationalValueRule() {
		return getLiteralRationalValueAccess().getRule();
	}
	
	//LiteralFloatValue expression::LiteralFloatValue:
	//	value=EDouble;
	public LiteralFloatValueElements getLiteralFloatValueAccess() {
		return pLiteralFloatValue;
	}
	
	public ParserRule getLiteralFloatValueRule() {
		return getLiteralFloatValueAccess().getRule();
	}
	
	//LiteralRealValue expression::LiteralRealValue:
	//	value=EBigDecimal;
	public LiteralRealValueElements getLiteralRealValueAccess() {
		return pLiteralRealValue;
	}
	
	public ParserRule getLiteralRealValueRule() {
		return getLiteralRealValueAccess().getRule();
	}
	
	//LiteralStringValue expression::LiteralStringValue:
	//	value=EString;
	public LiteralStringValueElements getLiteralStringValueAccess() {
		return pLiteralStringValue;
	}
	
	public ParserRule getLiteralStringValueRule() {
		return getLiteralStringValueAccess().getRule();
	}
	
	//LiteralNullValue expression::LiteralNullValue:
	//	{expression::LiteralNullValue}
	//	'null' ('<' type=XID '>')?;
	public LiteralNullValueElements getLiteralNullValueAccess() {
		return pLiteralNullValue;
	}
	
	public ParserRule getLiteralNullValueRule() {
		return getLiteralNullValueAccess().getRule();
	}
	
	//LiteralVariableReference expression::LiteralReferenceValue:
	//	LiteralTimeVariable
	//	| LiteralTimeDeltaVariable;
	public LiteralVariableReferenceElements getLiteralVariableReferenceAccess() {
		return pLiteralVariableReference;
	}
	
	public ParserRule getLiteralVariableReferenceRule() {
		return getLiteralVariableReferenceAccess().getRule();
	}
	
	//LiteralTimeVariable expression::LiteralTimeVariable:
	//	{expression::LiteralTimeVariable} symbol='$time';
	public LiteralTimeVariableElements getLiteralTimeVariableAccess() {
		return pLiteralTimeVariable;
	}
	
	public ParserRule getLiteralTimeVariableRule() {
		return getLiteralTimeVariableAccess().getRule();
	}
	
	//LiteralTimeDeltaVariable expression::LiteralTimeDeltaVariable:
	//	{expression::LiteralTimeDeltaVariable} symbol='$delta';
	public LiteralTimeDeltaVariableElements getLiteralTimeDeltaVariableAccess() {
		return pLiteralTimeDeltaVariable;
	}
	
	public ParserRule getLiteralTimeDeltaVariableRule() {
		return getLiteralTimeDeltaVariableAccess().getRule();
	}
	
	//LiteralInstanceReference expression::LiteralReferenceValue:
	//	LiteralThisInstance
	//	| LiteralSelfInstance
	//	| LiteralParentInstance
	//	| LiteralSuperInstance
	//	| LiteralSystemInstance
	//	| LiteralEnvInstance;
	public LiteralInstanceReferenceElements getLiteralInstanceReferenceAccess() {
		return pLiteralInstanceReference;
	}
	
	public ParserRule getLiteralInstanceReferenceRule() {
		return getLiteralInstanceReferenceAccess().getRule();
	}
	
	//LiteralThisInstance expression::LiteralThisInstance:
	//	{expression::LiteralThisInstance} symbol='$this';
	public LiteralThisInstanceElements getLiteralThisInstanceAccess() {
		return pLiteralThisInstance;
	}
	
	public ParserRule getLiteralThisInstanceRule() {
		return getLiteralThisInstanceAccess().getRule();
	}
	
	//LiteralSelfInstance expression::LiteralSelfInstance:
	//	{expression::LiteralSelfInstance} symbol='$self';
	public LiteralSelfInstanceElements getLiteralSelfInstanceAccess() {
		return pLiteralSelfInstance;
	}
	
	public ParserRule getLiteralSelfInstanceRule() {
		return getLiteralSelfInstanceAccess().getRule();
	}
	
	//LiteralParentInstance expression::LiteralParentInstance:
	//	{expression::LiteralParentInstance} symbol='$parent';
	public LiteralParentInstanceElements getLiteralParentInstanceAccess() {
		return pLiteralParentInstance;
	}
	
	public ParserRule getLiteralParentInstanceRule() {
		return getLiteralParentInstanceAccess().getRule();
	}
	
	//LiteralSuperInstance expression::LiteralSuperInstance:
	//	{expression::LiteralSuperInstance} symbol='$super';
	public LiteralSuperInstanceElements getLiteralSuperInstanceAccess() {
		return pLiteralSuperInstance;
	}
	
	public ParserRule getLiteralSuperInstanceRule() {
		return getLiteralSuperInstanceAccess().getRule();
	}
	
	//LiteralSystemInstance expression::LiteralSystemInstance:
	//	{expression::LiteralSystemInstance} symbol='$system';
	public LiteralSystemInstanceElements getLiteralSystemInstanceAccess() {
		return pLiteralSystemInstance;
	}
	
	public ParserRule getLiteralSystemInstanceRule() {
		return getLiteralSystemInstanceAccess().getRule();
	}
	
	//LiteralEnvInstance expression::LiteralEnvInstance:
	//	{expression::LiteralEnvInstance} symbol=('$env' | 'env');
	public LiteralEnvInstanceElements getLiteralEnvInstanceAccess() {
		return pLiteralEnvInstance;
	}
	
	public ParserRule getLiteralEnvInstanceRule() {
		return getLiteralEnvInstanceAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Terminal Rules
	//////////////////////////////////////////////////////////////////////////////////
	//EBoolean ecore::EBoolean:
	//	'true'
	//	| 'false';
	public EBooleanElements getEBooleanAccess() {
		return pEBoolean;
	}
	
	public ParserRule getEBooleanRule() {
		return getEBooleanAccess().getRule();
	}
	
	//terminal CHARACTER:
	//	"'" . "'";
	public TerminalRule getCHARACTERRule() {
		return tCHARACTER;
	}
	
	//EChar ecore::EChar:
	//	CHARACTER;
	public ECharElements getECharAccess() {
		return pEChar;
	}
	
	public ParserRule getECharRule() {
		return getECharAccess().getRule();
	}
	
	//ELong ecore::ELong:
	//	'-'? INT;
	public ELongElements getELongAccess() {
		return pELong;
	}
	
	public ParserRule getELongRule() {
		return getELongAccess().getRule();
	}
	
	//EDouble ecore::EDouble:
	//	'-'? INT? '.' INT //(('E'|'e') '-'? INT)?
	//;
	public EDoubleElements getEDoubleAccess() {
		return pEDouble;
	}
	
	public ParserRule getEDoubleRule() {
		return getEDoubleAccess().getRule();
	}
	
	//EBigDecimal ecore::EBigDecimal:
	//	INT? '.' INT;
	public EBigDecimalElements getEBigDecimalAccess() {
		return pEBigDecimal;
	}
	
	public ParserRule getEBigDecimalRule() {
		return getEBigDecimalAccess().getRule();
	}
	
	//EString:
	//	STRING;
	public EStringElements getEStringAccess() {
		return pEString;
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//// @DEPRECATED Diversity Configuration Specification
	//////////////////////////////////////////////////////////////////////////////////
	//DeprecatedReservedWord:
	//	'form' | 'endform'
	//	| 'prototype' | 'endprototype'
	//	| 'section' | 'endsection';
	public DeprecatedReservedWordElements getDeprecatedReservedWordAccess() {
		return pDeprecatedReservedWord;
	}
	
	public ParserRule getDeprecatedReservedWordRule() {
		return getDeprecatedReservedWordAccess().getRule();
	}
	
	//DeprecatedObject sew::WObject:
	//	{sew::WObject}
	//	'form'
	//	name=UFI description=EString? 'as' '&'? type=UFI 'is'
	//	element+=DeprecatedProperty*
	//	'endform'
	//	| {sew::WObject}
	//	'prototype'
	//	name=UFI description=EString? 'as' '&'? type=UFI 'is'
	//	element+=DeprecatedProperty*
	//	'endprototype';
	public DeprecatedObjectElements getDeprecatedObjectAccess() {
		return pDeprecatedObject;
	}
	
	public ParserRule getDeprecatedObjectRule() {
		return getDeprecatedObjectAccess().getRule();
	}
	
	//DeprecatedProperty sew::WProperty:
	//	DeprecatedSection
	//	| DeprecatedAttribute;
	public DeprecatedPropertyElements getDeprecatedPropertyAccess() {
		return pDeprecatedProperty;
	}
	
	public ParserRule getDeprecatedPropertyRule() {
		return getDeprecatedPropertyAccess().getRule();
	}
	
	//DeprecatedSection sew::WSection:
	//	{sew::WSection}
	//	'section' name=XID
	//	//		( element+=( Object | Attribute  ) )*
	//	element+=(DeprecatedAttribute | DeprecatedObject | Object)*
	//	'endsection' XID?
	//	| name=XID description=EString? ('[' element+=(DeprecatedAttribute | DeprecatedObject | Object)* ']'
	//	| ':' element+=(DeprecatedAttribute | DeprecatedObject | Object)*);
	public DeprecatedSectionElements getDeprecatedSectionAccess() {
		return pDeprecatedSection;
	}
	
	public ParserRule getDeprecatedSectionRule() {
		return getDeprecatedSectionAccess().getRule();
	}
	
	//DeprecatedAttribute sew::WAttribute:
	//	{sew::WAttribute} name=DeprecatedAttributeID '=' value=ValueSpecification ';'?;
	public DeprecatedAttributeElements getDeprecatedAttributeAccess() {
		return pDeprecatedAttribute;
	}
	
	public ParserRule getDeprecatedAttributeRule() {
		return getDeprecatedAttributeAccess().getRule();
	}
	
	//DeprecatedAttributeID:
	//	XID
	//	| AT_IDENTIFIER;
	public DeprecatedAttributeIDElements getDeprecatedAttributeIDAccess() {
		return pDeprecatedAttributeID;
	}
	
	public ParserRule getDeprecatedAttributeIDRule() {
		return getDeprecatedAttributeIDAccess().getRule();
	}
	
	//DeprecatedExpression sew::WValueSpecification:
	//	{expression::Expression}
	//	'${'
	//	operator=('|;|' | '|i|') operand+=ValueSpecification*
	//	'}';
	public DeprecatedExpressionElements getDeprecatedExpressionAccess() {
		return pDeprecatedExpression;
	}
	
	public ParserRule getDeprecatedExpressionRule() {
		return getDeprecatedExpressionAccess().getRule();
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
	//	'/*'->'*/';
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
