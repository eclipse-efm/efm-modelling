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
package org.eclipse.efm.sew.xtext.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.efm.sew.xtext.ide.contentassist.antlr.internal.InternalSEWParser;
import org.eclipse.efm.sew.xtext.services.SEWGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

public class SEWParser extends AbstractContentAssistParser {

	@Inject
	private SEWGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalSEWParser createParser() {
		InternalSEWParser result = new InternalSEWParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getWorkflowAccess().getAlternatives_2(), "rule__Workflow__Alternatives_2");
					put(grammarAccess.getWorkflowAccess().getTypeAlternatives_2_0_0_0(), "rule__Workflow__TypeAlternatives_2_0_0_0");
					put(grammarAccess.getWorkflowAccess().getElementAlternatives_2_0_4_0(), "rule__Workflow__ElementAlternatives_2_0_4_0");
					put(grammarAccess.getPrologAccess().getAlternatives_0(), "rule__Prolog__Alternatives_0");
					put(grammarAccess.getPrologAccess().getAlternatives_2(), "rule__Prolog__Alternatives_2");
					put(grammarAccess.getPrologAccess().getAlternatives_4(), "rule__Prolog__Alternatives_4");
					put(grammarAccess.getReservedWordAccess().getAlternatives(), "rule__ReservedWord__Alternatives");
					put(grammarAccess.getXIDAccess().getAlternatives(), "rule__XID__Alternatives");
					put(grammarAccess.getUFIAccess().getAlternatives_1_0(), "rule__UFI__Alternatives_1_0");
					put(grammarAccess.getObjectAccess().getAlternatives(), "rule__Object__Alternatives");
					put(grammarAccess.getObjectAccess().getElementAlternatives_0_5_0(), "rule__Object__ElementAlternatives_0_5_0");
					put(grammarAccess.getObjectAccess().getAlternatives_1_2(), "rule__Object__Alternatives_1_2");
					put(grammarAccess.getObjectAccess().getElementAlternatives_1_5_0(), "rule__Object__ElementAlternatives_1_5_0");
					put(grammarAccess.getPropertyAccess().getAlternatives(), "rule__Property__Alternatives");
					put(grammarAccess.getSectionAccess().getAlternatives_2(), "rule__Section__Alternatives_2");
					put(grammarAccess.getSectionAccess().getElementAlternatives_2_0_1_0(), "rule__Section__ElementAlternatives_2_0_1_0");
					put(grammarAccess.getSectionAccess().getElementAlternatives_2_1_1_0(), "rule__Section__ElementAlternatives_2_1_1_0");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getConditionalOrExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__ConditionalOrExpression__OperatorAlternatives_1_1_0");
					put(grammarAccess.getConditionalOrExpressionAccess().getAlternatives_1_3_0(), "rule__ConditionalOrExpression__Alternatives_1_3_0");
					put(grammarAccess.getConditionalAndExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__ConditionalAndExpression__OperatorAlternatives_1_1_0");
					put(grammarAccess.getConditionalAndExpressionAccess().getAlternatives_1_3_0(), "rule__ConditionalAndExpression__Alternatives_1_3_0");
					put(grammarAccess.getEqualityExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__EqualityExpression__OperatorAlternatives_1_1_0");
					put(grammarAccess.getRelationalExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__RelationalExpression__OperatorAlternatives_1_1_0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getAlternatives_1(), "rule__MultiplicativeExpression__Alternatives_1");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
					put(grammarAccess.getPrimaryExpressionAccess().getOperatorAlternatives_2_1_0_0(), "rule__PrimaryExpression__OperatorAlternatives_2_1_0_0");
					put(grammarAccess.getLiteralExpressionAccess().getAlternatives(), "rule__LiteralExpression__Alternatives");
					put(grammarAccess.getLiteralObjectReferenceAccess().getAlternatives_1(), "rule__LiteralObjectReference__Alternatives_1");
					put(grammarAccess.getLiteralVariableReferenceAccess().getAlternatives(), "rule__LiteralVariableReference__Alternatives");
					put(grammarAccess.getLiteralInstanceReferenceAccess().getAlternatives(), "rule__LiteralInstanceReference__Alternatives");
					put(grammarAccess.getLiteralEnvInstanceAccess().getSymbolAlternatives_1_0(), "rule__LiteralEnvInstance__SymbolAlternatives_1_0");
					put(grammarAccess.getEBooleanAccess().getAlternatives(), "rule__EBoolean__Alternatives");
					put(grammarAccess.getDeprecatedReservedWordAccess().getAlternatives(), "rule__DeprecatedReservedWord__Alternatives");
					put(grammarAccess.getDeprecatedObjectAccess().getAlternatives(), "rule__DeprecatedObject__Alternatives");
					put(grammarAccess.getDeprecatedPropertyAccess().getAlternatives(), "rule__DeprecatedProperty__Alternatives");
					put(grammarAccess.getDeprecatedSectionAccess().getAlternatives(), "rule__DeprecatedSection__Alternatives");
					put(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_0_3_0(), "rule__DeprecatedSection__ElementAlternatives_0_3_0");
					put(grammarAccess.getDeprecatedSectionAccess().getAlternatives_1_2(), "rule__DeprecatedSection__Alternatives_1_2");
					put(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_1_2_0_1_0(), "rule__DeprecatedSection__ElementAlternatives_1_2_0_1_0");
					put(grammarAccess.getDeprecatedSectionAccess().getElementAlternatives_1_2_1_1_0(), "rule__DeprecatedSection__ElementAlternatives_1_2_1_1_0");
					put(grammarAccess.getDeprecatedAttributeIDAccess().getAlternatives(), "rule__DeprecatedAttributeID__Alternatives");
					put(grammarAccess.getDeprecatedExpressionAccess().getOperatorAlternatives_2_0(), "rule__DeprecatedExpression__OperatorAlternatives_2_0");
					put(grammarAccess.getWorkflowAccess().getGroup(), "rule__Workflow__Group__0");
					put(grammarAccess.getWorkflowAccess().getGroup_2_0(), "rule__Workflow__Group_2_0__0");
					put(grammarAccess.getPrologAccess().getGroup(), "rule__Prolog__Group__0");
					put(grammarAccess.getPrologAccess().getGroup_3(), "rule__Prolog__Group_3__0");
					put(grammarAccess.getPrologAccess().getGroup_4_0(), "rule__Prolog__Group_4_0__0");
					put(grammarAccess.getUFIAccess().getGroup(), "rule__UFI__Group__0");
					put(grammarAccess.getUFIAccess().getGroup_1(), "rule__UFI__Group_1__0");
					put(grammarAccess.getObjectAccess().getGroup_0(), "rule__Object__Group_0__0");
					put(grammarAccess.getObjectAccess().getGroup_1(), "rule__Object__Group_1__0");
					put(grammarAccess.getObjectAccess().getGroup_1_3(), "rule__Object__Group_1_3__0");
					put(grammarAccess.getSectionAccess().getGroup(), "rule__Section__Group__0");
					put(grammarAccess.getSectionAccess().getGroup_2_0(), "rule__Section__Group_2_0__0");
					put(grammarAccess.getSectionAccess().getGroup_2_1(), "rule__Section__Group_2_1__0");
					put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
					put(grammarAccess.getConditionalExpressionAccess().getGroup(), "rule__ConditionalExpression__Group__0");
					put(grammarAccess.getConditionalExpressionAccess().getGroup_1(), "rule__ConditionalExpression__Group_1__0");
					put(grammarAccess.getConditionalOrExpressionAccess().getGroup(), "rule__ConditionalOrExpression__Group__0");
					put(grammarAccess.getConditionalOrExpressionAccess().getGroup_1(), "rule__ConditionalOrExpression__Group_1__0");
					put(grammarAccess.getConditionalOrExpressionAccess().getGroup_1_3(), "rule__ConditionalOrExpression__Group_1_3__0");
					put(grammarAccess.getConditionalAndExpressionAccess().getGroup(), "rule__ConditionalAndExpression__Group__0");
					put(grammarAccess.getConditionalAndExpressionAccess().getGroup_1(), "rule__ConditionalAndExpression__Group_1__0");
					put(grammarAccess.getConditionalAndExpressionAccess().getGroup_1_3(), "rule__ConditionalAndExpression__Group_1_3__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup_1(), "rule__EqualityExpression__Group_1__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_1_3(), "rule__AdditiveExpression__Group_1_3__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0(), "rule__MultiplicativeExpression__Group_1_0__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0_3(), "rule__MultiplicativeExpression__Group_1_0_3__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_1(), "rule__MultiplicativeExpression__Group_1_1__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_1_3(), "rule__MultiplicativeExpression__Group_1_1_3__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_2(), "rule__MultiplicativeExpression__Group_1_2__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_2_3(), "rule__MultiplicativeExpression__Group_1_2_3__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_3(), "rule__MultiplicativeExpression__Group_1_3__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_3_3(), "rule__MultiplicativeExpression__Group_1_3_3__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_0(), "rule__PrimaryExpression__Group_0__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_1(), "rule__PrimaryExpression__Group_1__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_1_1(), "rule__PrimaryExpression__Group_1_1__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_2(), "rule__PrimaryExpression__Group_2__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_2_1(), "rule__PrimaryExpression__Group_2_1__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_3(), "rule__PrimaryExpression__Group_3__0");
					put(grammarAccess.getLiteralArrayValueAccess().getGroup(), "rule__LiteralArrayValue__Group__0");
					put(grammarAccess.getLiteralArrayValueAccess().getGroup_2(), "rule__LiteralArrayValue__Group_2__0");
					put(grammarAccess.getLiteralArrayValueAccess().getGroup_2_1(), "rule__LiteralArrayValue__Group_2_1__0");
					put(grammarAccess.getLiteralObjectReferenceAccess().getGroup(), "rule__LiteralObjectReference__Group__0");
					put(grammarAccess.getLiteralRationalValueAccess().getGroup(), "rule__LiteralRationalValue__Group__0");
					put(grammarAccess.getLiteralNullValueAccess().getGroup(), "rule__LiteralNullValue__Group__0");
					put(grammarAccess.getLiteralNullValueAccess().getGroup_2(), "rule__LiteralNullValue__Group_2__0");
					put(grammarAccess.getLiteralTimeVariableAccess().getGroup(), "rule__LiteralTimeVariable__Group__0");
					put(grammarAccess.getLiteralTimeDeltaVariableAccess().getGroup(), "rule__LiteralTimeDeltaVariable__Group__0");
					put(grammarAccess.getLiteralThisInstanceAccess().getGroup(), "rule__LiteralThisInstance__Group__0");
					put(grammarAccess.getLiteralSelfInstanceAccess().getGroup(), "rule__LiteralSelfInstance__Group__0");
					put(grammarAccess.getLiteralParentInstanceAccess().getGroup(), "rule__LiteralParentInstance__Group__0");
					put(grammarAccess.getLiteralSuperInstanceAccess().getGroup(), "rule__LiteralSuperInstance__Group__0");
					put(grammarAccess.getLiteralSystemInstanceAccess().getGroup(), "rule__LiteralSystemInstance__Group__0");
					put(grammarAccess.getLiteralEnvInstanceAccess().getGroup(), "rule__LiteralEnvInstance__Group__0");
					put(grammarAccess.getELongAccess().getGroup(), "rule__ELong__Group__0");
					put(grammarAccess.getEDoubleAccess().getGroup(), "rule__EDouble__Group__0");
					put(grammarAccess.getEBigDecimalAccess().getGroup(), "rule__EBigDecimal__Group__0");
					put(grammarAccess.getDeprecatedObjectAccess().getGroup_0(), "rule__DeprecatedObject__Group_0__0");
					put(grammarAccess.getDeprecatedObjectAccess().getGroup_1(), "rule__DeprecatedObject__Group_1__0");
					put(grammarAccess.getDeprecatedSectionAccess().getGroup_0(), "rule__DeprecatedSection__Group_0__0");
					put(grammarAccess.getDeprecatedSectionAccess().getGroup_1(), "rule__DeprecatedSection__Group_1__0");
					put(grammarAccess.getDeprecatedSectionAccess().getGroup_1_2_0(), "rule__DeprecatedSection__Group_1_2_0__0");
					put(grammarAccess.getDeprecatedSectionAccess().getGroup_1_2_1(), "rule__DeprecatedSection__Group_1_2_1__0");
					put(grammarAccess.getDeprecatedAttributeAccess().getGroup(), "rule__DeprecatedAttribute__Group__0");
					put(grammarAccess.getDeprecatedExpressionAccess().getGroup(), "rule__DeprecatedExpression__Group__0");
					put(grammarAccess.getWorkflowAccess().getTypeAssignment_2_0_0(), "rule__Workflow__TypeAssignment_2_0_0");
					put(grammarAccess.getWorkflowAccess().getNameAssignment_2_0_1(), "rule__Workflow__NameAssignment_2_0_1");
					put(grammarAccess.getWorkflowAccess().getDescriptionAssignment_2_0_2(), "rule__Workflow__DescriptionAssignment_2_0_2");
					put(grammarAccess.getWorkflowAccess().getElementAssignment_2_0_4(), "rule__Workflow__ElementAssignment_2_0_4");
					put(grammarAccess.getWorkflowAccess().getElementAssignment_2_1(), "rule__Workflow__ElementAssignment_2_1");
					put(grammarAccess.getObjectAccess().getTypeAssignment_0_1(), "rule__Object__TypeAssignment_0_1");
					put(grammarAccess.getObjectAccess().getNameAssignment_0_2(), "rule__Object__NameAssignment_0_2");
					put(grammarAccess.getObjectAccess().getDescriptionAssignment_0_3(), "rule__Object__DescriptionAssignment_0_3");
					put(grammarAccess.getObjectAccess().getElementAssignment_0_5(), "rule__Object__ElementAssignment_0_5");
					put(grammarAccess.getObjectAccess().getNameAssignment_1_1(), "rule__Object__NameAssignment_1_1");
					put(grammarAccess.getObjectAccess().getTypeAssignment_1_3_0(), "rule__Object__TypeAssignment_1_3_0");
					put(grammarAccess.getObjectAccess().getDescriptionAssignment_1_3_1(), "rule__Object__DescriptionAssignment_1_3_1");
					put(grammarAccess.getObjectAccess().getElementAssignment_1_5(), "rule__Object__ElementAssignment_1_5");
					put(grammarAccess.getSectionAccess().getNameAssignment_0(), "rule__Section__NameAssignment_0");
					put(grammarAccess.getSectionAccess().getDescriptionAssignment_1(), "rule__Section__DescriptionAssignment_1");
					put(grammarAccess.getSectionAccess().getElementAssignment_2_0_1(), "rule__Section__ElementAssignment_2_0_1");
					put(grammarAccess.getSectionAccess().getElementAssignment_2_1_1(), "rule__Section__ElementAssignment_2_1_1");
					put(grammarAccess.getAttributeAccess().getNameAssignment_1(), "rule__Attribute__NameAssignment_1");
					put(grammarAccess.getAttributeAccess().getValueAssignment_3(), "rule__Attribute__ValueAssignment_3");
					put(grammarAccess.getConditionalExpressionAccess().getOperatorAssignment_1_1(), "rule__ConditionalExpression__OperatorAssignment_1_1");
					put(grammarAccess.getConditionalExpressionAccess().getOperandAssignment_1_2(), "rule__ConditionalExpression__OperandAssignment_1_2");
					put(grammarAccess.getConditionalExpressionAccess().getOperandAssignment_1_4(), "rule__ConditionalExpression__OperandAssignment_1_4");
					put(grammarAccess.getConditionalOrExpressionAccess().getOperatorAssignment_1_1(), "rule__ConditionalOrExpression__OperatorAssignment_1_1");
					put(grammarAccess.getConditionalOrExpressionAccess().getOperandAssignment_1_2(), "rule__ConditionalOrExpression__OperandAssignment_1_2");
					put(grammarAccess.getConditionalOrExpressionAccess().getOperandAssignment_1_3_1(), "rule__ConditionalOrExpression__OperandAssignment_1_3_1");
					put(grammarAccess.getConditionalAndExpressionAccess().getOperatorAssignment_1_1(), "rule__ConditionalAndExpression__OperatorAssignment_1_1");
					put(grammarAccess.getConditionalAndExpressionAccess().getOperandAssignment_1_2(), "rule__ConditionalAndExpression__OperandAssignment_1_2");
					put(grammarAccess.getConditionalAndExpressionAccess().getOperandAssignment_1_3_1(), "rule__ConditionalAndExpression__OperandAssignment_1_3_1");
					put(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_1(), "rule__EqualityExpression__OperatorAssignment_1_1");
					put(grammarAccess.getEqualityExpressionAccess().getOperandAssignment_1_2(), "rule__EqualityExpression__OperandAssignment_1_2");
					put(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_1(), "rule__RelationalExpression__OperatorAssignment_1_1");
					put(grammarAccess.getRelationalExpressionAccess().getOperandAssignment_1_2(), "rule__RelationalExpression__OperandAssignment_1_2");
					put(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_1(), "rule__AdditiveExpression__OperatorAssignment_1_1");
					put(grammarAccess.getAdditiveExpressionAccess().getOperandAssignment_1_2(), "rule__AdditiveExpression__OperandAssignment_1_2");
					put(grammarAccess.getAdditiveExpressionAccess().getOperandAssignment_1_3_1(), "rule__AdditiveExpression__OperandAssignment_1_3_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_0_1(), "rule__MultiplicativeExpression__OperatorAssignment_1_0_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_0_2(), "rule__MultiplicativeExpression__OperandAssignment_1_0_2");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_0_3_1(), "rule__MultiplicativeExpression__OperandAssignment_1_0_3_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_1_1(), "rule__MultiplicativeExpression__OperatorAssignment_1_1_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_1_2(), "rule__MultiplicativeExpression__OperandAssignment_1_1_2");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_1_3_1(), "rule__MultiplicativeExpression__OperandAssignment_1_1_3_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_2_1(), "rule__MultiplicativeExpression__OperatorAssignment_1_2_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_2_2(), "rule__MultiplicativeExpression__OperandAssignment_1_2_2");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_2_3_1(), "rule__MultiplicativeExpression__OperandAssignment_1_2_3_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_3_1(), "rule__MultiplicativeExpression__OperatorAssignment_1_3_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_3_2(), "rule__MultiplicativeExpression__OperandAssignment_1_3_2");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_3_3_1(), "rule__MultiplicativeExpression__OperandAssignment_1_3_3_1");
					put(grammarAccess.getPrimaryExpressionAccess().getOperatorAssignment_1_1_0(), "rule__PrimaryExpression__OperatorAssignment_1_1_0");
					put(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_1_1_1(), "rule__PrimaryExpression__OperandAssignment_1_1_1");
					put(grammarAccess.getPrimaryExpressionAccess().getOperatorAssignment_2_1_0(), "rule__PrimaryExpression__OperatorAssignment_2_1_0");
					put(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_2_1_1(), "rule__PrimaryExpression__OperandAssignment_2_1_1");
					put(grammarAccess.getLiteralArrayValueAccess().getValuesAssignment_2_0(), "rule__LiteralArrayValue__ValuesAssignment_2_0");
					put(grammarAccess.getLiteralArrayValueAccess().getValuesAssignment_2_1_1(), "rule__LiteralArrayValue__ValuesAssignment_2_1_1");
					put(grammarAccess.getLiteralObjectReferenceAccess().getObjectAssignment_1_0(), "rule__LiteralObjectReference__ObjectAssignment_1_0");
					put(grammarAccess.getLiteralObjectReferenceAccess().getSymbolAssignment_1_1(), "rule__LiteralObjectReference__SymbolAssignment_1_1");
					put(grammarAccess.getLiteralBooleanValueAccess().getValueAssignment(), "rule__LiteralBooleanValue__ValueAssignment");
					put(grammarAccess.getLiteralCharacterValueAccess().getValueAssignment(), "rule__LiteralCharacterValue__ValueAssignment");
					put(grammarAccess.getLiteralIntegerValueAccess().getValueAssignment(), "rule__LiteralIntegerValue__ValueAssignment");
					put(grammarAccess.getLiteralRationalValueAccess().getNumeratorAssignment_0(), "rule__LiteralRationalValue__NumeratorAssignment_0");
					put(grammarAccess.getLiteralRationalValueAccess().getDenominatorAssignment_2(), "rule__LiteralRationalValue__DenominatorAssignment_2");
					put(grammarAccess.getLiteralFloatValueAccess().getValueAssignment(), "rule__LiteralFloatValue__ValueAssignment");
					put(grammarAccess.getLiteralRealValueAccess().getValueAssignment(), "rule__LiteralRealValue__ValueAssignment");
					put(grammarAccess.getLiteralStringValueAccess().getValueAssignment(), "rule__LiteralStringValue__ValueAssignment");
					put(grammarAccess.getLiteralNullValueAccess().getTypeAssignment_2_1(), "rule__LiteralNullValue__TypeAssignment_2_1");
					put(grammarAccess.getLiteralTimeVariableAccess().getSymbolAssignment_1(), "rule__LiteralTimeVariable__SymbolAssignment_1");
					put(grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolAssignment_1(), "rule__LiteralTimeDeltaVariable__SymbolAssignment_1");
					put(grammarAccess.getLiteralThisInstanceAccess().getSymbolAssignment_1(), "rule__LiteralThisInstance__SymbolAssignment_1");
					put(grammarAccess.getLiteralSelfInstanceAccess().getSymbolAssignment_1(), "rule__LiteralSelfInstance__SymbolAssignment_1");
					put(grammarAccess.getLiteralParentInstanceAccess().getSymbolAssignment_1(), "rule__LiteralParentInstance__SymbolAssignment_1");
					put(grammarAccess.getLiteralSuperInstanceAccess().getSymbolAssignment_1(), "rule__LiteralSuperInstance__SymbolAssignment_1");
					put(grammarAccess.getLiteralSystemInstanceAccess().getSymbolAssignment_1(), "rule__LiteralSystemInstance__SymbolAssignment_1");
					put(grammarAccess.getLiteralEnvInstanceAccess().getSymbolAssignment_1(), "rule__LiteralEnvInstance__SymbolAssignment_1");
					put(grammarAccess.getDeprecatedObjectAccess().getNameAssignment_0_2(), "rule__DeprecatedObject__NameAssignment_0_2");
					put(grammarAccess.getDeprecatedObjectAccess().getDescriptionAssignment_0_3(), "rule__DeprecatedObject__DescriptionAssignment_0_3");
					put(grammarAccess.getDeprecatedObjectAccess().getTypeAssignment_0_6(), "rule__DeprecatedObject__TypeAssignment_0_6");
					put(grammarAccess.getDeprecatedObjectAccess().getElementAssignment_0_8(), "rule__DeprecatedObject__ElementAssignment_0_8");
					put(grammarAccess.getDeprecatedObjectAccess().getNameAssignment_1_2(), "rule__DeprecatedObject__NameAssignment_1_2");
					put(grammarAccess.getDeprecatedObjectAccess().getDescriptionAssignment_1_3(), "rule__DeprecatedObject__DescriptionAssignment_1_3");
					put(grammarAccess.getDeprecatedObjectAccess().getTypeAssignment_1_6(), "rule__DeprecatedObject__TypeAssignment_1_6");
					put(grammarAccess.getDeprecatedObjectAccess().getElementAssignment_1_8(), "rule__DeprecatedObject__ElementAssignment_1_8");
					put(grammarAccess.getDeprecatedSectionAccess().getNameAssignment_0_2(), "rule__DeprecatedSection__NameAssignment_0_2");
					put(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_0_3(), "rule__DeprecatedSection__ElementAssignment_0_3");
					put(grammarAccess.getDeprecatedSectionAccess().getNameAssignment_1_0(), "rule__DeprecatedSection__NameAssignment_1_0");
					put(grammarAccess.getDeprecatedSectionAccess().getDescriptionAssignment_1_1(), "rule__DeprecatedSection__DescriptionAssignment_1_1");
					put(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_1_2_0_1(), "rule__DeprecatedSection__ElementAssignment_1_2_0_1");
					put(grammarAccess.getDeprecatedSectionAccess().getElementAssignment_1_2_1_1(), "rule__DeprecatedSection__ElementAssignment_1_2_1_1");
					put(grammarAccess.getDeprecatedAttributeAccess().getNameAssignment_1(), "rule__DeprecatedAttribute__NameAssignment_1");
					put(grammarAccess.getDeprecatedAttributeAccess().getValueAssignment_3(), "rule__DeprecatedAttribute__ValueAssignment_3");
					put(grammarAccess.getDeprecatedExpressionAccess().getOperatorAssignment_2(), "rule__DeprecatedExpression__OperatorAssignment_2");
					put(grammarAccess.getDeprecatedExpressionAccess().getOperandAssignment_3(), "rule__DeprecatedExpression__OperandAssignment_3");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalSEWParser typedParser = (InternalSEWParser) parser;
			typedParser.entryRuleWorkflow();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public SEWGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(SEWGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
