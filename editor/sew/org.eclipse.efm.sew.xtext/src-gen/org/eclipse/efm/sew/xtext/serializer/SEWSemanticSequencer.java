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
package org.eclipse.efm.sew.xtext.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.efm.ecore.sew.SEWorkflow;
import org.eclipse.efm.ecore.sew.SewPackage;
import org.eclipse.efm.ecore.sew.WAttribute;
import org.eclipse.efm.ecore.sew.WObject;
import org.eclipse.efm.ecore.sew.WSection;
import org.eclipse.efm.ecore.sew.expression.Expression;
import org.eclipse.efm.ecore.sew.expression.ExpressionPackage;
import org.eclipse.efm.ecore.sew.expression.LiteralArrayValue;
import org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue;
import org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue;
import org.eclipse.efm.ecore.sew.expression.LiteralEnvInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralFloatValue;
import org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue;
import org.eclipse.efm.ecore.sew.expression.LiteralNullValue;
import org.eclipse.efm.ecore.sew.expression.LiteralObjectReference;
import org.eclipse.efm.ecore.sew.expression.LiteralParentInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralRationalValue;
import org.eclipse.efm.ecore.sew.expression.LiteralRealValue;
import org.eclipse.efm.ecore.sew.expression.LiteralSelfInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralStringValue;
import org.eclipse.efm.ecore.sew.expression.LiteralSuperInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralSystemInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralThisInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralTimeDeltaVariable;
import org.eclipse.efm.ecore.sew.expression.LiteralTimeVariable;
import org.eclipse.efm.sew.xtext.services.SEWGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class SEWSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private SEWGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ExpressionPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ExpressionPackage.EXPRESSION:
				if (rule == grammarAccess.getDeprecatedExpressionRule()) {
					sequence_DeprecatedExpression(context, (Expression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getValueSpecificationRule()
						|| rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getConditionalExpressionRule()
						|| action == grammarAccess.getConditionalExpressionAccess().getExpressionOperandAction_1_0()
						|| rule == grammarAccess.getConditionalOrExpressionRule()
						|| action == grammarAccess.getConditionalOrExpressionAccess().getExpressionOperandAction_1_0()
						|| rule == grammarAccess.getConditionalAndExpressionRule()
						|| action == grammarAccess.getConditionalAndExpressionAccess().getExpressionOperandAction_1_0()
						|| rule == grammarAccess.getEqualityExpressionRule()
						|| action == grammarAccess.getEqualityExpressionAccess().getExpressionOperandAction_1_0()
						|| rule == grammarAccess.getRelationalExpressionRule()
						|| action == grammarAccess.getRelationalExpressionAccess().getExpressionOperandAction_1_0()
						|| rule == grammarAccess.getAdditiveExpressionRule()
						|| action == grammarAccess.getAdditiveExpressionAccess().getExpressionOperandAction_1_0()
						|| rule == grammarAccess.getMultiplicativeExpressionRule()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_1_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_2_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_3_0()
						|| rule == grammarAccess.getPrimaryExpressionRule()) {
					sequence_DeprecatedExpression_additiveExpression_conditionalAndExpression_conditionalExpression_conditionalOrExpression_equalityExpression_multiplicativeExpression_primaryExpression_relationalExpression(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionPackage.LITERAL_ARRAY_VALUE:
				sequence_LiteralArrayValue(context, (LiteralArrayValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_BOOLEAN_VALUE:
				sequence_LiteralBooleanValue(context, (LiteralBooleanValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_CHARACTER_VALUE:
				sequence_LiteralCharacterValue(context, (LiteralCharacterValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_ENV_INSTANCE:
				sequence_LiteralEnvInstance(context, (LiteralEnvInstance) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_FLOAT_VALUE:
				sequence_LiteralFloatValue(context, (LiteralFloatValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_INTEGER_VALUE:
				sequence_LiteralIntegerValue(context, (LiteralIntegerValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_NULL_VALUE:
				sequence_LiteralNullValue(context, (LiteralNullValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_OBJECT_REFERENCE:
				sequence_LiteralObjectReference(context, (LiteralObjectReference) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_PARENT_INSTANCE:
				sequence_LiteralParentInstance(context, (LiteralParentInstance) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_RATIONAL_VALUE:
				sequence_LiteralRationalValue(context, (LiteralRationalValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_REAL_VALUE:
				sequence_LiteralRealValue(context, (LiteralRealValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_SELF_INSTANCE:
				sequence_LiteralSelfInstance(context, (LiteralSelfInstance) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_STRING_VALUE:
				sequence_LiteralStringValue(context, (LiteralStringValue) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_SUPER_INSTANCE:
				sequence_LiteralSuperInstance(context, (LiteralSuperInstance) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_SYSTEM_INSTANCE:
				sequence_LiteralSystemInstance(context, (LiteralSystemInstance) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_THIS_INSTANCE:
				sequence_LiteralThisInstance(context, (LiteralThisInstance) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_TIME_DELTA_VARIABLE:
				sequence_LiteralTimeDeltaVariable(context, (LiteralTimeDeltaVariable) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_TIME_VARIABLE:
				sequence_LiteralTimeVariable(context, (LiteralTimeVariable) semanticObject); 
				return; 
			}
		else if (epackage == SewPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case SewPackage.SE_WORKFLOW:
				sequence_Workflow(context, (SEWorkflow) semanticObject); 
				return; 
			case SewPackage.WATTRIBUTE:
				if (rule == grammarAccess.getPropertyRule()
						|| rule == grammarAccess.getAttributeRule()) {
					sequence_Attribute(context, (WAttribute) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDeprecatedPropertyRule()
						|| rule == grammarAccess.getDeprecatedAttributeRule()) {
					sequence_DeprecatedAttribute(context, (WAttribute) semanticObject); 
					return; 
				}
				else break;
			case SewPackage.WOBJECT:
				if (rule == grammarAccess.getDeprecatedObjectRule()) {
					sequence_DeprecatedObject(context, (WObject) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getObjectRule()) {
					sequence_Object(context, (WObject) semanticObject); 
					return; 
				}
				else break;
			case SewPackage.WSECTION:
				if (rule == grammarAccess.getDeprecatedPropertyRule()
						|| rule == grammarAccess.getDeprecatedSectionRule()) {
					sequence_DeprecatedSection(context, (WSection) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyRule()
						|| rule == grammarAccess.getSectionRule()) {
					sequence_Section(context, (WSection) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Property returns WAttribute
	 *     Attribute returns WAttribute
	 *
	 * Constraint:
	 *     (name=XID value=ValueSpecification)
	 */
	protected void sequence_Attribute(ISerializationContext context, WAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SewPackage.Literals.WNAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SewPackage.Literals.WNAMED_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, SewPackage.Literals.WATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SewPackage.Literals.WATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAttributeAccess().getNameXIDParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAttributeAccess().getValueValueSpecificationParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DeprecatedProperty returns WAttribute
	 *     DeprecatedAttribute returns WAttribute
	 *
	 * Constraint:
	 *     (name=DeprecatedAttributeID value=ValueSpecification)
	 */
	protected void sequence_DeprecatedAttribute(ISerializationContext context, WAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SewPackage.Literals.WNAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SewPackage.Literals.WNAMED_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, SewPackage.Literals.WATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SewPackage.Literals.WATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDeprecatedAttributeAccess().getNameDeprecatedAttributeIDParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getDeprecatedAttributeAccess().getValueValueSpecificationParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DeprecatedExpression returns Expression
	 *
	 * Constraint:
	 *     ((operator='|;|' | operator='|i|') operand+=ValueSpecification*)
	 */
	protected void sequence_DeprecatedExpression(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns Expression
	 *     Expression returns Expression
	 *     conditionalExpression returns Expression
	 *     conditionalExpression.Expression_1_0 returns Expression
	 *     conditionalOrExpression returns Expression
	 *     conditionalOrExpression.Expression_1_0 returns Expression
	 *     conditionalAndExpression returns Expression
	 *     conditionalAndExpression.Expression_1_0 returns Expression
	 *     equalityExpression returns Expression
	 *     equalityExpression.Expression_1_0 returns Expression
	 *     relationalExpression returns Expression
	 *     relationalExpression.Expression_1_0 returns Expression
	 *     additiveExpression returns Expression
	 *     additiveExpression.Expression_1_0 returns Expression
	 *     multiplicativeExpression returns Expression
	 *     multiplicativeExpression.Expression_1_0_0 returns Expression
	 *     multiplicativeExpression.Expression_1_1_0 returns Expression
	 *     multiplicativeExpression.Expression_1_2_0 returns Expression
	 *     multiplicativeExpression.Expression_1_3_0 returns Expression
	 *     primaryExpression returns Expression
	 *
	 * Constraint:
	 *     (
	 *         (operand+=conditionalExpression_Expression_1_0 operator='?' operand+=Expression operand+=Expression) | 
	 *         (
	 *             operand+=conditionalOrExpression_Expression_1_0 
	 *             (operator='||' | operator='or') 
	 *             operand+=conditionalAndExpression 
	 *             operand+=conditionalAndExpression*
	 *         ) | 
	 *         (operand+=conditionalAndExpression_Expression_1_0 (operator='&&' | operator='and') operand+=equalityExpression operand+=equalityExpression*) | 
	 *         (
	 *             operand+=equalityExpression_Expression_1_0 
	 *             (operator='==' | operator='!=' | operator='===' | operator='=!=' | operator='=/=') 
	 *             operand+=relationalExpression
	 *         ) | 
	 *         (operand+=relationalExpression_Expression_1_0 (operator='<' | operator='<=' | operator='>' | operator='>=') operand+=additiveExpression) | 
	 *         (operand+=additiveExpression_Expression_1_0 operator='+' operand+=multiplicativeExpression operand+=multiplicativeExpression*) | 
	 *         (operand+=multiplicativeExpression_Expression_1_0_0 operator='*' operand+=primaryExpression operand+=primaryExpression*) | 
	 *         (operand+=multiplicativeExpression_Expression_1_1_0 operator='**' operand+=primaryExpression operand+=primaryExpression*) | 
	 *         (operand+=multiplicativeExpression_Expression_1_2_0 operator='/' operand+=primaryExpression operand+=primaryExpression*) | 
	 *         (operand+=multiplicativeExpression_Expression_1_3_0 operator='%' operand+=primaryExpression operand+=primaryExpression*) | 
	 *         (operator='-' operand+=primaryExpression) | 
	 *         ((operator='!' | operator='not') operand+=primaryExpression) | 
	 *         ((operator='|;|' | operator='|i|') operand+=ValueSpecification*)
	 *     )
	 */
	protected void sequence_DeprecatedExpression_additiveExpression_conditionalAndExpression_conditionalExpression_conditionalOrExpression_equalityExpression_multiplicativeExpression_primaryExpression_relationalExpression(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DeprecatedObject returns WObject
	 *
	 * Constraint:
	 *     ((name=UFI description=EString? type=UFI element+=DeprecatedProperty*) | (name=UFI description=EString? type=UFI element+=DeprecatedProperty*))
	 */
	protected void sequence_DeprecatedObject(ISerializationContext context, WObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DeprecatedProperty returns WSection
	 *     DeprecatedSection returns WSection
	 *
	 * Constraint:
	 *     (
	 *         (name=XID (element+=DeprecatedAttribute | element+=DeprecatedObject | element+=Object)*) | 
	 *         (
	 *             name=XID 
	 *             description=EString? 
	 *             (
	 *                 (element+=DeprecatedAttribute | element+=DeprecatedObject | element+=Object)+ | 
	 *                 (element+=DeprecatedAttribute | element+=DeprecatedObject | element+=Object)+
	 *             )?
	 *         )
	 *     )
	 */
	protected void sequence_DeprecatedSection(ISerializationContext context, WSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralArrayValue
	 *     Expression returns LiteralArrayValue
	 *     conditionalExpression returns LiteralArrayValue
	 *     conditionalExpression.Expression_1_0 returns LiteralArrayValue
	 *     conditionalOrExpression returns LiteralArrayValue
	 *     conditionalOrExpression.Expression_1_0 returns LiteralArrayValue
	 *     conditionalAndExpression returns LiteralArrayValue
	 *     conditionalAndExpression.Expression_1_0 returns LiteralArrayValue
	 *     equalityExpression returns LiteralArrayValue
	 *     equalityExpression.Expression_1_0 returns LiteralArrayValue
	 *     relationalExpression returns LiteralArrayValue
	 *     relationalExpression.Expression_1_0 returns LiteralArrayValue
	 *     additiveExpression returns LiteralArrayValue
	 *     additiveExpression.Expression_1_0 returns LiteralArrayValue
	 *     multiplicativeExpression returns LiteralArrayValue
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralArrayValue
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralArrayValue
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralArrayValue
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralArrayValue
	 *     primaryExpression returns LiteralArrayValue
	 *     LiteralExpression returns LiteralArrayValue
	 *     LiteralArrayValue returns LiteralArrayValue
	 *
	 * Constraint:
	 *     (values+=ValueSpecification values+=ValueSpecification*)?
	 */
	protected void sequence_LiteralArrayValue(ISerializationContext context, LiteralArrayValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralBooleanValue
	 *     Expression returns LiteralBooleanValue
	 *     conditionalExpression returns LiteralBooleanValue
	 *     conditionalExpression.Expression_1_0 returns LiteralBooleanValue
	 *     conditionalOrExpression returns LiteralBooleanValue
	 *     conditionalOrExpression.Expression_1_0 returns LiteralBooleanValue
	 *     conditionalAndExpression returns LiteralBooleanValue
	 *     conditionalAndExpression.Expression_1_0 returns LiteralBooleanValue
	 *     equalityExpression returns LiteralBooleanValue
	 *     equalityExpression.Expression_1_0 returns LiteralBooleanValue
	 *     relationalExpression returns LiteralBooleanValue
	 *     relationalExpression.Expression_1_0 returns LiteralBooleanValue
	 *     additiveExpression returns LiteralBooleanValue
	 *     additiveExpression.Expression_1_0 returns LiteralBooleanValue
	 *     multiplicativeExpression returns LiteralBooleanValue
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralBooleanValue
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralBooleanValue
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralBooleanValue
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralBooleanValue
	 *     primaryExpression returns LiteralBooleanValue
	 *     LiteralExpression returns LiteralBooleanValue
	 *     LiteralBooleanValue returns LiteralBooleanValue
	 *
	 * Constraint:
	 *     value=EBoolean
	 */
	protected void sequence_LiteralBooleanValue(ISerializationContext context, LiteralBooleanValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_BOOLEAN_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_BOOLEAN_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralBooleanValueAccess().getValueEBooleanParserRuleCall_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralCharacterValue
	 *     Expression returns LiteralCharacterValue
	 *     conditionalExpression returns LiteralCharacterValue
	 *     conditionalExpression.Expression_1_0 returns LiteralCharacterValue
	 *     conditionalOrExpression returns LiteralCharacterValue
	 *     conditionalOrExpression.Expression_1_0 returns LiteralCharacterValue
	 *     conditionalAndExpression returns LiteralCharacterValue
	 *     conditionalAndExpression.Expression_1_0 returns LiteralCharacterValue
	 *     equalityExpression returns LiteralCharacterValue
	 *     equalityExpression.Expression_1_0 returns LiteralCharacterValue
	 *     relationalExpression returns LiteralCharacterValue
	 *     relationalExpression.Expression_1_0 returns LiteralCharacterValue
	 *     additiveExpression returns LiteralCharacterValue
	 *     additiveExpression.Expression_1_0 returns LiteralCharacterValue
	 *     multiplicativeExpression returns LiteralCharacterValue
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralCharacterValue
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralCharacterValue
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralCharacterValue
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralCharacterValue
	 *     primaryExpression returns LiteralCharacterValue
	 *     LiteralExpression returns LiteralCharacterValue
	 *     LiteralCharacterValue returns LiteralCharacterValue
	 *
	 * Constraint:
	 *     value=EChar
	 */
	protected void sequence_LiteralCharacterValue(ISerializationContext context, LiteralCharacterValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_CHARACTER_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_CHARACTER_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralCharacterValueAccess().getValueECharParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralEnvInstance
	 *     Expression returns LiteralEnvInstance
	 *     conditionalExpression returns LiteralEnvInstance
	 *     conditionalExpression.Expression_1_0 returns LiteralEnvInstance
	 *     conditionalOrExpression returns LiteralEnvInstance
	 *     conditionalOrExpression.Expression_1_0 returns LiteralEnvInstance
	 *     conditionalAndExpression returns LiteralEnvInstance
	 *     conditionalAndExpression.Expression_1_0 returns LiteralEnvInstance
	 *     equalityExpression returns LiteralEnvInstance
	 *     equalityExpression.Expression_1_0 returns LiteralEnvInstance
	 *     relationalExpression returns LiteralEnvInstance
	 *     relationalExpression.Expression_1_0 returns LiteralEnvInstance
	 *     additiveExpression returns LiteralEnvInstance
	 *     additiveExpression.Expression_1_0 returns LiteralEnvInstance
	 *     multiplicativeExpression returns LiteralEnvInstance
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralEnvInstance
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralEnvInstance
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralEnvInstance
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralEnvInstance
	 *     primaryExpression returns LiteralEnvInstance
	 *     LiteralExpression returns LiteralEnvInstance
	 *     LiteralInstanceReference returns LiteralEnvInstance
	 *     LiteralEnvInstance returns LiteralEnvInstance
	 *
	 * Constraint:
	 *     (symbol='$env' | symbol='env')
	 */
	protected void sequence_LiteralEnvInstance(ISerializationContext context, LiteralEnvInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralFloatValue
	 *     Expression returns LiteralFloatValue
	 *     conditionalExpression returns LiteralFloatValue
	 *     conditionalExpression.Expression_1_0 returns LiteralFloatValue
	 *     conditionalOrExpression returns LiteralFloatValue
	 *     conditionalOrExpression.Expression_1_0 returns LiteralFloatValue
	 *     conditionalAndExpression returns LiteralFloatValue
	 *     conditionalAndExpression.Expression_1_0 returns LiteralFloatValue
	 *     equalityExpression returns LiteralFloatValue
	 *     equalityExpression.Expression_1_0 returns LiteralFloatValue
	 *     relationalExpression returns LiteralFloatValue
	 *     relationalExpression.Expression_1_0 returns LiteralFloatValue
	 *     additiveExpression returns LiteralFloatValue
	 *     additiveExpression.Expression_1_0 returns LiteralFloatValue
	 *     multiplicativeExpression returns LiteralFloatValue
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralFloatValue
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralFloatValue
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralFloatValue
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralFloatValue
	 *     primaryExpression returns LiteralFloatValue
	 *     LiteralExpression returns LiteralFloatValue
	 *     LiteralFloatValue returns LiteralFloatValue
	 *
	 * Constraint:
	 *     value=EDouble
	 */
	protected void sequence_LiteralFloatValue(ISerializationContext context, LiteralFloatValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_FLOAT_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_FLOAT_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralFloatValueAccess().getValueEDoubleParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralIntegerValue
	 *     Expression returns LiteralIntegerValue
	 *     conditionalExpression returns LiteralIntegerValue
	 *     conditionalExpression.Expression_1_0 returns LiteralIntegerValue
	 *     conditionalOrExpression returns LiteralIntegerValue
	 *     conditionalOrExpression.Expression_1_0 returns LiteralIntegerValue
	 *     conditionalAndExpression returns LiteralIntegerValue
	 *     conditionalAndExpression.Expression_1_0 returns LiteralIntegerValue
	 *     equalityExpression returns LiteralIntegerValue
	 *     equalityExpression.Expression_1_0 returns LiteralIntegerValue
	 *     relationalExpression returns LiteralIntegerValue
	 *     relationalExpression.Expression_1_0 returns LiteralIntegerValue
	 *     additiveExpression returns LiteralIntegerValue
	 *     additiveExpression.Expression_1_0 returns LiteralIntegerValue
	 *     multiplicativeExpression returns LiteralIntegerValue
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralIntegerValue
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralIntegerValue
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralIntegerValue
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralIntegerValue
	 *     primaryExpression returns LiteralIntegerValue
	 *     LiteralExpression returns LiteralIntegerValue
	 *     LiteralIntegerValue returns LiteralIntegerValue
	 *
	 * Constraint:
	 *     value=ELong
	 */
	protected void sequence_LiteralIntegerValue(ISerializationContext context, LiteralIntegerValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_INTEGER_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_INTEGER_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralIntegerValueAccess().getValueELongParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralNullValue
	 *     Expression returns LiteralNullValue
	 *     conditionalExpression returns LiteralNullValue
	 *     conditionalExpression.Expression_1_0 returns LiteralNullValue
	 *     conditionalOrExpression returns LiteralNullValue
	 *     conditionalOrExpression.Expression_1_0 returns LiteralNullValue
	 *     conditionalAndExpression returns LiteralNullValue
	 *     conditionalAndExpression.Expression_1_0 returns LiteralNullValue
	 *     equalityExpression returns LiteralNullValue
	 *     equalityExpression.Expression_1_0 returns LiteralNullValue
	 *     relationalExpression returns LiteralNullValue
	 *     relationalExpression.Expression_1_0 returns LiteralNullValue
	 *     additiveExpression returns LiteralNullValue
	 *     additiveExpression.Expression_1_0 returns LiteralNullValue
	 *     multiplicativeExpression returns LiteralNullValue
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralNullValue
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralNullValue
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralNullValue
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralNullValue
	 *     primaryExpression returns LiteralNullValue
	 *     LiteralExpression returns LiteralNullValue
	 *     LiteralNullValue returns LiteralNullValue
	 *
	 * Constraint:
	 *     type=XID?
	 */
	protected void sequence_LiteralNullValue(ISerializationContext context, LiteralNullValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralObjectReference
	 *     Expression returns LiteralObjectReference
	 *     conditionalExpression returns LiteralObjectReference
	 *     conditionalExpression.Expression_1_0 returns LiteralObjectReference
	 *     conditionalOrExpression returns LiteralObjectReference
	 *     conditionalOrExpression.Expression_1_0 returns LiteralObjectReference
	 *     conditionalAndExpression returns LiteralObjectReference
	 *     conditionalAndExpression.Expression_1_0 returns LiteralObjectReference
	 *     equalityExpression returns LiteralObjectReference
	 *     equalityExpression.Expression_1_0 returns LiteralObjectReference
	 *     relationalExpression returns LiteralObjectReference
	 *     relationalExpression.Expression_1_0 returns LiteralObjectReference
	 *     additiveExpression returns LiteralObjectReference
	 *     additiveExpression.Expression_1_0 returns LiteralObjectReference
	 *     multiplicativeExpression returns LiteralObjectReference
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralObjectReference
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralObjectReference
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralObjectReference
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralObjectReference
	 *     primaryExpression returns LiteralObjectReference
	 *     LiteralExpression returns LiteralObjectReference
	 *     LiteralObjectReference returns LiteralObjectReference
	 *
	 * Constraint:
	 *     (object=[WObject|UFI] | symbol=UFI)
	 */
	protected void sequence_LiteralObjectReference(ISerializationContext context, LiteralObjectReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralParentInstance
	 *     Expression returns LiteralParentInstance
	 *     conditionalExpression returns LiteralParentInstance
	 *     conditionalExpression.Expression_1_0 returns LiteralParentInstance
	 *     conditionalOrExpression returns LiteralParentInstance
	 *     conditionalOrExpression.Expression_1_0 returns LiteralParentInstance
	 *     conditionalAndExpression returns LiteralParentInstance
	 *     conditionalAndExpression.Expression_1_0 returns LiteralParentInstance
	 *     equalityExpression returns LiteralParentInstance
	 *     equalityExpression.Expression_1_0 returns LiteralParentInstance
	 *     relationalExpression returns LiteralParentInstance
	 *     relationalExpression.Expression_1_0 returns LiteralParentInstance
	 *     additiveExpression returns LiteralParentInstance
	 *     additiveExpression.Expression_1_0 returns LiteralParentInstance
	 *     multiplicativeExpression returns LiteralParentInstance
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralParentInstance
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralParentInstance
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralParentInstance
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralParentInstance
	 *     primaryExpression returns LiteralParentInstance
	 *     LiteralExpression returns LiteralParentInstance
	 *     LiteralInstanceReference returns LiteralParentInstance
	 *     LiteralParentInstance returns LiteralParentInstance
	 *
	 * Constraint:
	 *     symbol='$parent'
	 */
	protected void sequence_LiteralParentInstance(ISerializationContext context, LiteralParentInstance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralParentInstanceAccess().getSymbolParentKeyword_1_0(), semanticObject.getSymbol());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralRationalValue
	 *     Expression returns LiteralRationalValue
	 *     conditionalExpression returns LiteralRationalValue
	 *     conditionalExpression.Expression_1_0 returns LiteralRationalValue
	 *     conditionalOrExpression returns LiteralRationalValue
	 *     conditionalOrExpression.Expression_1_0 returns LiteralRationalValue
	 *     conditionalAndExpression returns LiteralRationalValue
	 *     conditionalAndExpression.Expression_1_0 returns LiteralRationalValue
	 *     equalityExpression returns LiteralRationalValue
	 *     equalityExpression.Expression_1_0 returns LiteralRationalValue
	 *     relationalExpression returns LiteralRationalValue
	 *     relationalExpression.Expression_1_0 returns LiteralRationalValue
	 *     additiveExpression returns LiteralRationalValue
	 *     additiveExpression.Expression_1_0 returns LiteralRationalValue
	 *     multiplicativeExpression returns LiteralRationalValue
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralRationalValue
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralRationalValue
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralRationalValue
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralRationalValue
	 *     primaryExpression returns LiteralRationalValue
	 *     LiteralExpression returns LiteralRationalValue
	 *     LiteralRationalValue returns LiteralRationalValue
	 *
	 * Constraint:
	 *     (numerator=ELong denominator=ELong)
	 */
	protected void sequence_LiteralRationalValue(ISerializationContext context, LiteralRationalValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_RATIONAL_VALUE__NUMERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_RATIONAL_VALUE__NUMERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_RATIONAL_VALUE__DENOMINATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_RATIONAL_VALUE__DENOMINATOR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralRationalValueAccess().getNumeratorELongParserRuleCall_0_0(), semanticObject.getNumerator());
		feeder.accept(grammarAccess.getLiteralRationalValueAccess().getDenominatorELongParserRuleCall_2_0(), semanticObject.getDenominator());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralRealValue returns LiteralRealValue
	 *
	 * Constraint:
	 *     value=EBigDecimal
	 */
	protected void sequence_LiteralRealValue(ISerializationContext context, LiteralRealValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REAL_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REAL_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralRealValueAccess().getValueEBigDecimalParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralSelfInstance
	 *     Expression returns LiteralSelfInstance
	 *     conditionalExpression returns LiteralSelfInstance
	 *     conditionalExpression.Expression_1_0 returns LiteralSelfInstance
	 *     conditionalOrExpression returns LiteralSelfInstance
	 *     conditionalOrExpression.Expression_1_0 returns LiteralSelfInstance
	 *     conditionalAndExpression returns LiteralSelfInstance
	 *     conditionalAndExpression.Expression_1_0 returns LiteralSelfInstance
	 *     equalityExpression returns LiteralSelfInstance
	 *     equalityExpression.Expression_1_0 returns LiteralSelfInstance
	 *     relationalExpression returns LiteralSelfInstance
	 *     relationalExpression.Expression_1_0 returns LiteralSelfInstance
	 *     additiveExpression returns LiteralSelfInstance
	 *     additiveExpression.Expression_1_0 returns LiteralSelfInstance
	 *     multiplicativeExpression returns LiteralSelfInstance
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralSelfInstance
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralSelfInstance
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralSelfInstance
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralSelfInstance
	 *     primaryExpression returns LiteralSelfInstance
	 *     LiteralExpression returns LiteralSelfInstance
	 *     LiteralInstanceReference returns LiteralSelfInstance
	 *     LiteralSelfInstance returns LiteralSelfInstance
	 *
	 * Constraint:
	 *     symbol='$self'
	 */
	protected void sequence_LiteralSelfInstance(ISerializationContext context, LiteralSelfInstance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralSelfInstanceAccess().getSymbolSelfKeyword_1_0(), semanticObject.getSymbol());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralStringValue
	 *     Expression returns LiteralStringValue
	 *     conditionalExpression returns LiteralStringValue
	 *     conditionalExpression.Expression_1_0 returns LiteralStringValue
	 *     conditionalOrExpression returns LiteralStringValue
	 *     conditionalOrExpression.Expression_1_0 returns LiteralStringValue
	 *     conditionalAndExpression returns LiteralStringValue
	 *     conditionalAndExpression.Expression_1_0 returns LiteralStringValue
	 *     equalityExpression returns LiteralStringValue
	 *     equalityExpression.Expression_1_0 returns LiteralStringValue
	 *     relationalExpression returns LiteralStringValue
	 *     relationalExpression.Expression_1_0 returns LiteralStringValue
	 *     additiveExpression returns LiteralStringValue
	 *     additiveExpression.Expression_1_0 returns LiteralStringValue
	 *     multiplicativeExpression returns LiteralStringValue
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralStringValue
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralStringValue
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralStringValue
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralStringValue
	 *     primaryExpression returns LiteralStringValue
	 *     LiteralExpression returns LiteralStringValue
	 *     LiteralStringValue returns LiteralStringValue
	 *
	 * Constraint:
	 *     value=EString
	 */
	protected void sequence_LiteralStringValue(ISerializationContext context, LiteralStringValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_STRING_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_STRING_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralStringValueAccess().getValueEStringParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralSuperInstance
	 *     Expression returns LiteralSuperInstance
	 *     conditionalExpression returns LiteralSuperInstance
	 *     conditionalExpression.Expression_1_0 returns LiteralSuperInstance
	 *     conditionalOrExpression returns LiteralSuperInstance
	 *     conditionalOrExpression.Expression_1_0 returns LiteralSuperInstance
	 *     conditionalAndExpression returns LiteralSuperInstance
	 *     conditionalAndExpression.Expression_1_0 returns LiteralSuperInstance
	 *     equalityExpression returns LiteralSuperInstance
	 *     equalityExpression.Expression_1_0 returns LiteralSuperInstance
	 *     relationalExpression returns LiteralSuperInstance
	 *     relationalExpression.Expression_1_0 returns LiteralSuperInstance
	 *     additiveExpression returns LiteralSuperInstance
	 *     additiveExpression.Expression_1_0 returns LiteralSuperInstance
	 *     multiplicativeExpression returns LiteralSuperInstance
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralSuperInstance
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralSuperInstance
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralSuperInstance
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralSuperInstance
	 *     primaryExpression returns LiteralSuperInstance
	 *     LiteralExpression returns LiteralSuperInstance
	 *     LiteralInstanceReference returns LiteralSuperInstance
	 *     LiteralSuperInstance returns LiteralSuperInstance
	 *
	 * Constraint:
	 *     symbol='$super'
	 */
	protected void sequence_LiteralSuperInstance(ISerializationContext context, LiteralSuperInstance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralSuperInstanceAccess().getSymbolSuperKeyword_1_0(), semanticObject.getSymbol());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralSystemInstance
	 *     Expression returns LiteralSystemInstance
	 *     conditionalExpression returns LiteralSystemInstance
	 *     conditionalExpression.Expression_1_0 returns LiteralSystemInstance
	 *     conditionalOrExpression returns LiteralSystemInstance
	 *     conditionalOrExpression.Expression_1_0 returns LiteralSystemInstance
	 *     conditionalAndExpression returns LiteralSystemInstance
	 *     conditionalAndExpression.Expression_1_0 returns LiteralSystemInstance
	 *     equalityExpression returns LiteralSystemInstance
	 *     equalityExpression.Expression_1_0 returns LiteralSystemInstance
	 *     relationalExpression returns LiteralSystemInstance
	 *     relationalExpression.Expression_1_0 returns LiteralSystemInstance
	 *     additiveExpression returns LiteralSystemInstance
	 *     additiveExpression.Expression_1_0 returns LiteralSystemInstance
	 *     multiplicativeExpression returns LiteralSystemInstance
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralSystemInstance
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralSystemInstance
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralSystemInstance
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralSystemInstance
	 *     primaryExpression returns LiteralSystemInstance
	 *     LiteralExpression returns LiteralSystemInstance
	 *     LiteralInstanceReference returns LiteralSystemInstance
	 *     LiteralSystemInstance returns LiteralSystemInstance
	 *
	 * Constraint:
	 *     symbol='$system'
	 */
	protected void sequence_LiteralSystemInstance(ISerializationContext context, LiteralSystemInstance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralSystemInstanceAccess().getSymbolSystemKeyword_1_0(), semanticObject.getSymbol());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralThisInstance
	 *     Expression returns LiteralThisInstance
	 *     conditionalExpression returns LiteralThisInstance
	 *     conditionalExpression.Expression_1_0 returns LiteralThisInstance
	 *     conditionalOrExpression returns LiteralThisInstance
	 *     conditionalOrExpression.Expression_1_0 returns LiteralThisInstance
	 *     conditionalAndExpression returns LiteralThisInstance
	 *     conditionalAndExpression.Expression_1_0 returns LiteralThisInstance
	 *     equalityExpression returns LiteralThisInstance
	 *     equalityExpression.Expression_1_0 returns LiteralThisInstance
	 *     relationalExpression returns LiteralThisInstance
	 *     relationalExpression.Expression_1_0 returns LiteralThisInstance
	 *     additiveExpression returns LiteralThisInstance
	 *     additiveExpression.Expression_1_0 returns LiteralThisInstance
	 *     multiplicativeExpression returns LiteralThisInstance
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralThisInstance
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralThisInstance
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralThisInstance
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralThisInstance
	 *     primaryExpression returns LiteralThisInstance
	 *     LiteralExpression returns LiteralThisInstance
	 *     LiteralInstanceReference returns LiteralThisInstance
	 *     LiteralThisInstance returns LiteralThisInstance
	 *
	 * Constraint:
	 *     symbol='$this'
	 */
	protected void sequence_LiteralThisInstance(ISerializationContext context, LiteralThisInstance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralThisInstanceAccess().getSymbolThisKeyword_1_0(), semanticObject.getSymbol());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralTimeDeltaVariable
	 *     Expression returns LiteralTimeDeltaVariable
	 *     conditionalExpression returns LiteralTimeDeltaVariable
	 *     conditionalExpression.Expression_1_0 returns LiteralTimeDeltaVariable
	 *     conditionalOrExpression returns LiteralTimeDeltaVariable
	 *     conditionalOrExpression.Expression_1_0 returns LiteralTimeDeltaVariable
	 *     conditionalAndExpression returns LiteralTimeDeltaVariable
	 *     conditionalAndExpression.Expression_1_0 returns LiteralTimeDeltaVariable
	 *     equalityExpression returns LiteralTimeDeltaVariable
	 *     equalityExpression.Expression_1_0 returns LiteralTimeDeltaVariable
	 *     relationalExpression returns LiteralTimeDeltaVariable
	 *     relationalExpression.Expression_1_0 returns LiteralTimeDeltaVariable
	 *     additiveExpression returns LiteralTimeDeltaVariable
	 *     additiveExpression.Expression_1_0 returns LiteralTimeDeltaVariable
	 *     multiplicativeExpression returns LiteralTimeDeltaVariable
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralTimeDeltaVariable
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralTimeDeltaVariable
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralTimeDeltaVariable
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralTimeDeltaVariable
	 *     primaryExpression returns LiteralTimeDeltaVariable
	 *     LiteralExpression returns LiteralTimeDeltaVariable
	 *     LiteralVariableReference returns LiteralTimeDeltaVariable
	 *     LiteralTimeDeltaVariable returns LiteralTimeDeltaVariable
	 *
	 * Constraint:
	 *     symbol='$delta'
	 */
	protected void sequence_LiteralTimeDeltaVariable(ISerializationContext context, LiteralTimeDeltaVariable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolDeltaKeyword_1_0(), semanticObject.getSymbol());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ValueSpecification returns LiteralTimeVariable
	 *     Expression returns LiteralTimeVariable
	 *     conditionalExpression returns LiteralTimeVariable
	 *     conditionalExpression.Expression_1_0 returns LiteralTimeVariable
	 *     conditionalOrExpression returns LiteralTimeVariable
	 *     conditionalOrExpression.Expression_1_0 returns LiteralTimeVariable
	 *     conditionalAndExpression returns LiteralTimeVariable
	 *     conditionalAndExpression.Expression_1_0 returns LiteralTimeVariable
	 *     equalityExpression returns LiteralTimeVariable
	 *     equalityExpression.Expression_1_0 returns LiteralTimeVariable
	 *     relationalExpression returns LiteralTimeVariable
	 *     relationalExpression.Expression_1_0 returns LiteralTimeVariable
	 *     additiveExpression returns LiteralTimeVariable
	 *     additiveExpression.Expression_1_0 returns LiteralTimeVariable
	 *     multiplicativeExpression returns LiteralTimeVariable
	 *     multiplicativeExpression.Expression_1_0_0 returns LiteralTimeVariable
	 *     multiplicativeExpression.Expression_1_1_0 returns LiteralTimeVariable
	 *     multiplicativeExpression.Expression_1_2_0 returns LiteralTimeVariable
	 *     multiplicativeExpression.Expression_1_3_0 returns LiteralTimeVariable
	 *     primaryExpression returns LiteralTimeVariable
	 *     LiteralExpression returns LiteralTimeVariable
	 *     LiteralVariableReference returns LiteralTimeVariable
	 *     LiteralTimeVariable returns LiteralTimeVariable
	 *
	 * Constraint:
	 *     symbol='$time'
	 */
	protected void sequence_LiteralTimeVariable(ISerializationContext context, LiteralTimeVariable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_VALUE__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralTimeVariableAccess().getSymbolTimeKeyword_1_0(), semanticObject.getSymbol());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Object returns WObject
	 *
	 * Constraint:
	 *     (
	 *         (type=UFI name=UFI? description=EString? (element+=Object | element+=Property)*) | 
	 *         (name=UFI (type=UFI description=EString?)? (element+=Object | element+=Property)*)
	 *     )
	 */
	protected void sequence_Object(ISerializationContext context, WObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Property returns WSection
	 *     Section returns WSection
	 *
	 * Constraint:
	 *     (name=XID description=EString? ((element+=Object | element+=Attribute)+ | (element+=Object | element+=Attribute)+)?)
	 */
	protected void sequence_Section(ISerializationContext context, WSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Workflow returns SEWorkflow
	 *
	 * Constraint:
	 *     (
	 *         ((type='workflow' | type='symbex-workflow') name=UFI? description=EString? element+=Object? (element+=Property? element+=Object?)*) | 
	 *         (element+=Object | element+=Property)+ | 
	 *         element+=DeprecatedObject
	 *     )?
	 */
	protected void sequence_Workflow(ISerializationContext context, SEWorkflow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
