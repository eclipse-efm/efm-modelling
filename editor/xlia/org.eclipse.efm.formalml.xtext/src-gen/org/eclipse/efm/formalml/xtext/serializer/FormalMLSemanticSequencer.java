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
package org.eclipse.efm.formalml.xtext.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.efm.ecore.formalml.FormalmlPackage;
import org.eclipse.efm.ecore.formalml.XliaAttribute;
import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.ecore.formalml.XliaObject;
import org.eclipse.efm.ecore.formalml.XliaSection;
import org.eclipse.efm.ecore.formalml.common.CommonPackage;
import org.eclipse.efm.ecore.formalml.common.QualifiedName;
import org.eclipse.efm.ecore.formalml.datatype.ChoiceType;
import org.eclipse.efm.ecore.formalml.datatype.CollectionType;
import org.eclipse.efm.ecore.formalml.datatype.DataTypeReference;
import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType;
import org.eclipse.efm.ecore.formalml.datatype.IntervalType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveBooleanType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveCharacterType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveFloatType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveIntegerType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRationalType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRealType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType;
import org.eclipse.efm.ecore.formalml.datatype.StructureType;
import org.eclipse.efm.ecore.formalml.datatype.UnionType;
import org.eclipse.efm.ecore.formalml.expression.ArithmeticAssociativeExpression;
import org.eclipse.efm.ecore.formalml.expression.ArithmeticUnaryExpression;
import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression;
import org.eclipse.efm.ecore.formalml.expression.BitwiseAssociativeExpression;
import org.eclipse.efm.ecore.formalml.expression.BitwiseUnaryExpression;
import org.eclipse.efm.ecore.formalml.expression.CastExpression;
import org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression;
import org.eclipse.efm.ecore.formalml.expression.EqualityBinaryExpression;
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPostfixExpression;
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPrefixExpression;
import org.eclipse.efm.ecore.formalml.expression.InstantiationExpression;
import org.eclipse.efm.ecore.formalml.expression.InvokeExpression;
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralAnyOrNoneValueExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralAnyValueExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralNoneValueExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralOptionalValueExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement;
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification;
import org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralTimeDeltaExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralTimeExpression;
import org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression;
import org.eclipse.efm.ecore.formalml.expression.LogicalUnaryExpression;
import org.eclipse.efm.ecore.formalml.expression.MixTupleExpression;
import org.eclipse.efm.ecore.formalml.expression.NamedExpression;
import org.eclipse.efm.ecore.formalml.expression.NewfreshExpression;
import org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression;
import org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression;
import org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression;
import org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification;
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.BehaviorPart;
import org.eclipse.efm.ecore.formalml.infrastructure.Buffer;
import org.eclipse.efm.ecore.formalml.infrastructure.Channel;
import org.eclipse.efm.ecore.formalml.infrastructure.ComPoint;
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol;
import org.eclipse.efm.ecore.formalml.infrastructure.CompositePart;
import org.eclipse.efm.ecore.formalml.infrastructure.Connector;
import org.eclipse.efm.ecore.formalml.infrastructure.ConnectorEnd;
import org.eclipse.efm.ecore.formalml.infrastructure.Function;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfComputation;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction;
import org.eclipse.efm.ecore.formalml.infrastructure.Modifier;
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet;
import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.Procedure;
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart;
import org.eclipse.efm.ecore.formalml.infrastructure.Route;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.infrastructure.Signal;
import org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;
import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem;
import org.eclipse.efm.ecore.formalml.statemachine.FinalState;
import org.eclipse.efm.ecore.formalml.statemachine.Pseudostate;
import org.eclipse.efm.ecore.formalml.statemachine.Region;
import org.eclipse.efm.ecore.formalml.statemachine.StartState;
import org.eclipse.efm.ecore.formalml.statemachine.State;
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine;
import org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage;
import org.eclipse.efm.ecore.formalml.statemachine.Transition;
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe;
import org.eclipse.efm.ecore.formalml.statement.ActivityStatement;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement;
import org.eclipse.efm.ecore.formalml.statement.DoWhileStatement;
import org.eclipse.efm.ecore.formalml.statement.EventGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.ExpressionStatement;
import org.eclipse.efm.ecore.formalml.statement.ForEachStatement;
import org.eclipse.efm.ecore.formalml.statement.ForStatement;
import org.eclipse.efm.ecore.formalml.statement.GuardStatement;
import org.eclipse.efm.ecore.formalml.statement.IfStatement;
import org.eclipse.efm.ecore.formalml.statement.InputComStatement;
import org.eclipse.efm.ecore.formalml.statement.InterruptStatement;
import org.eclipse.efm.ecore.formalml.statement.InvokeStatement;
import org.eclipse.efm.ecore.formalml.statement.MetaStatement;
import org.eclipse.efm.ecore.formalml.statement.ObserverStatement;
import org.eclipse.efm.ecore.formalml.statement.OutputComStatement;
import org.eclipse.efm.ecore.formalml.statement.StatementPackage;
import org.eclipse.efm.ecore.formalml.statement.TimedGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.WhileDoStatement;
import org.eclipse.efm.formalml.xtext.services.FormalMLGrammarAccess;
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
public class FormalMLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private FormalMLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == CommonPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case CommonPackage.QUALIFIED_NAME:
				if (rule == grammarAccess.getColonQualifiedNameRule()) {
					sequence_ColonQualifiedName_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDotQualifiedNameRule()) {
					sequence_DotQualifiedName_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPotentiallyAmbiguousQualifiedNameRule()) {
					sequence_PotentiallyAmbiguousQualifiedName_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnqualifiedNameRule()) {
					sequence_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			}
		else if (epackage == DatatypePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case DatatypePackage.CHOICE_TYPE:
				if (rule == grammarAccess.getChoiceTypeDefinitionImplRule()) {
					sequence_ChoiceTypeDefinitionImpl(context, (ChoiceType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeDefinitionRule()
						|| rule == grammarAccess.getChoiceTypeDefinitionRule()) {
					sequence_ChoiceTypeDefinition(context, (ChoiceType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeRule()
						|| rule == grammarAccess.getStructuredDataTypeRule()
						|| rule == grammarAccess.getChoiceTypeRule()) {
					sequence_ChoiceType(context, (ChoiceType) semanticObject); 
					return; 
				}
				else break;
			case DatatypePackage.COLLECTION_TYPE:
				if (rule == grammarAccess.getBufferContainerTypeRule()) {
					sequence_BufferContainerType(context, (CollectionType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getCollectionTypeDefinitionImplRule()) {
					sequence_CollectionTypeDefinitionImpl(context, (CollectionType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeDefinitionRule()
						|| rule == grammarAccess.getCollectionTypeDefinitionRule()) {
					sequence_CollectionTypeDefinition(context, (CollectionType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeReferenceRule()
						|| action == grammarAccess.getDataTypeReferenceAccess().getDataTypeReferenceSupportAction_0_1_0()
						|| rule == grammarAccess.getDataTypeRule()
						|| rule == grammarAccess.getSimpleDataTypeRule()
						|| rule == grammarAccess.getCollectionTypeRule()
						|| rule == grammarAccess.getAnyDataTypeReferenceRule()
						|| action == grammarAccess.getAnyDataTypeReferenceAccess().getDataTypeReferenceSupportAction_0_1_0()) {
					sequence_CollectionType(context, (CollectionType) semanticObject); 
					return; 
				}
				else break;
			case DatatypePackage.DATA_TYPE_REFERENCE:
				if (rule == grammarAccess.getAnyDataTypeReferenceRule()) {
					sequence_AnyDataTypeReference(context, (DataTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeReferenceRule()
						|| rule == grammarAccess.getDataTypeRule()) {
					sequence_DataTypeReference(context, (DataTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeDefinitionRule()
						|| rule == grammarAccess.getOtherDataTypeDefinitionRule()) {
					sequence_OtherDataTypeDefinition(context, (DataTypeReference) semanticObject); 
					return; 
				}
				else break;
			case DatatypePackage.ENUMERATION_LITERAL:
				sequence_EnumerationLiteral(context, (EnumerationLiteral) semanticObject); 
				return; 
			case DatatypePackage.ENUMERATION_TYPE:
				if (rule == grammarAccess.getEnumerationTypeDefinitionImplRule()) {
					sequence_EnumerationTypeDefinitionImpl(context, (EnumerationType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeDefinitionRule()
						|| rule == grammarAccess.getEnumerationTypeDefinitionRule()) {
					sequence_EnumerationTypeDefinition(context, (EnumerationType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeRule()
						|| rule == grammarAccess.getStructuredDataTypeRule()
						|| rule == grammarAccess.getEnumerationTypeRule()) {
					sequence_EnumerationType(context, (EnumerationType) semanticObject); 
					return; 
				}
				else break;
			case DatatypePackage.INTERVAL_TYPE:
				if (rule == grammarAccess.getIntervalTypeDefinitionImplRule()) {
					sequence_IntervalTypeDefinitionImpl(context, (IntervalType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeDefinitionRule()
						|| rule == grammarAccess.getIntervalTypeDefinitionRule()) {
					sequence_IntervalTypeDefinition(context, (IntervalType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeReferenceRule()
						|| action == grammarAccess.getDataTypeReferenceAccess().getDataTypeReferenceSupportAction_0_1_0()
						|| rule == grammarAccess.getDataTypeRule()
						|| rule == grammarAccess.getSimpleDataTypeRule()
						|| rule == grammarAccess.getIntervalTypeRule()
						|| rule == grammarAccess.getAnyDataTypeReferenceRule()
						|| action == grammarAccess.getAnyDataTypeReferenceAccess().getDataTypeReferenceSupportAction_0_1_0()) {
					sequence_IntervalType(context, (IntervalType) semanticObject); 
					return; 
				}
				else break;
			case DatatypePackage.PRIMITIVE_BOOLEAN_TYPE:
				sequence_PrimitiveBooleanType(context, (PrimitiveBooleanType) semanticObject); 
				return; 
			case DatatypePackage.PRIMITIVE_CHARACTER_TYPE:
				sequence_PrimitiveCharacterType(context, (PrimitiveCharacterType) semanticObject); 
				return; 
			case DatatypePackage.PRIMITIVE_FLOAT_TYPE:
				sequence_PrimitiveFloatType(context, (PrimitiveFloatType) semanticObject); 
				return; 
			case DatatypePackage.PRIMITIVE_INSTANCE_TYPE:
				if (rule == grammarAccess.getAnyNullPrimitiveInstanceTypeRule()) {
					sequence_AnyNullPrimitiveInstanceType(context, (PrimitiveInstanceType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNullPrimitiveInstanceTypeRule()) {
					sequence_NullPrimitiveInstanceType(context, (PrimitiveInstanceType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeReferenceRule()
						|| action == grammarAccess.getDataTypeReferenceAccess().getDataTypeReferenceSupportAction_0_1_0()
						|| rule == grammarAccess.getDataTypeRule()
						|| rule == grammarAccess.getSimpleDataTypeRule()
						|| rule == grammarAccess.getPrimitiveTypeRule()
						|| rule == grammarAccess.getOtherPrimitiveTypeRule()
						|| rule == grammarAccess.getPrimitiveInstanceTypeRule()
						|| rule == grammarAccess.getAnyDataTypeReferenceRule()
						|| action == grammarAccess.getAnyDataTypeReferenceAccess().getDataTypeReferenceSupportAction_0_1_0()) {
					sequence_PrimitiveInstanceType(context, (PrimitiveInstanceType) semanticObject); 
					return; 
				}
				else break;
			case DatatypePackage.PRIMITIVE_INTEGER_TYPE:
				sequence_PrimitiveIntegerType(context, (PrimitiveIntegerType) semanticObject); 
				return; 
			case DatatypePackage.PRIMITIVE_RATIONAL_TYPE:
				sequence_PrimitiveRationalType(context, (PrimitiveRationalType) semanticObject); 
				return; 
			case DatatypePackage.PRIMITIVE_REAL_TYPE:
				sequence_PrimitiveRealType(context, (PrimitiveRealType) semanticObject); 
				return; 
			case DatatypePackage.PRIMITIVE_STRING_TYPE:
				sequence_PrimitiveStringType(context, (PrimitiveStringType) semanticObject); 
				return; 
			case DatatypePackage.PRIMITIVE_TIME_TYPE:
				sequence_PrimitiveTimeType(context, (PrimitiveTimeType) semanticObject); 
				return; 
			case DatatypePackage.STRUCTURE_TYPE:
				if (rule == grammarAccess.getStructureTypeDefinitionImplRule()) {
					sequence_StructureTypeDefinitionImpl(context, (StructureType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeDefinitionRule()
						|| rule == grammarAccess.getStructureTypeDefinitionRule()) {
					sequence_StructureTypeDefinition(context, (StructureType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeRule()
						|| rule == grammarAccess.getStructuredDataTypeRule()
						|| rule == grammarAccess.getStructureTypeRule()) {
					sequence_StructureType(context, (StructureType) semanticObject); 
					return; 
				}
				else break;
			case DatatypePackage.UNION_TYPE:
				if (rule == grammarAccess.getUnionTypeDefinitionImplRule()) {
					sequence_UnionTypeDefinitionImpl(context, (UnionType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeDefinitionRule()
						|| rule == grammarAccess.getUnionTypeDefinitionRule()) {
					sequence_UnionTypeDefinition(context, (UnionType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeRule()
						|| rule == grammarAccess.getStructuredDataTypeRule()
						|| rule == grammarAccess.getUnionTypeRule()) {
					sequence_UnionType(context, (UnionType) semanticObject); 
					return; 
				}
				else break;
			}
		else if (epackage == ExpressionPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ExpressionPackage.ARITHMETIC_ASSOCIATIVE_EXPRESSION:
				sequence_AdditiveExpression_MultiplicativeExpression(context, (ArithmeticAssociativeExpression) semanticObject); 
				return; 
			case ExpressionPackage.ARITHMETIC_UNARY_EXPRESSION:
				sequence_ArithmeticUnaryExpression(context, (ArithmeticUnaryExpression) semanticObject); 
				return; 
			case ExpressionPackage.ASSIGNMENT_EXPRESSION:
				sequence_AssignmentExpression(context, (AssignmentExpression) semanticObject); 
				return; 
			case ExpressionPackage.BITWISE_ASSOCIATIVE_EXPRESSION:
				sequence_BitwiseAndExpression_BitwiseOrExpression_BitwiseXorExpression(context, (BitwiseAssociativeExpression) semanticObject); 
				return; 
			case ExpressionPackage.BITWISE_UNARY_EXPRESSION:
				sequence_BitwiseUnaryExpression(context, (BitwiseUnaryExpression) semanticObject); 
				return; 
			case ExpressionPackage.CAST_EXPRESSION:
				sequence_CastExpression(context, (CastExpression) semanticObject); 
				return; 
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION:
				sequence_ConditionalTestExpression(context, (ConditionalTestExpression) semanticObject); 
				return; 
			case ExpressionPackage.EQUALITY_BINARY_EXPRESSION:
				sequence_EqualityExpression(context, (EqualityBinaryExpression) semanticObject); 
				return; 
			case ExpressionPackage.INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION:
				sequence_IncrementOrDecrementPostfixExpression(context, (IncrementOrDecrementPostfixExpression) semanticObject); 
				return; 
			case ExpressionPackage.INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION:
				sequence_IncrementOrDecrementPrefixExpression(context, (IncrementOrDecrementPrefixExpression) semanticObject); 
				return; 
			case ExpressionPackage.INSTANTIATION_EXPRESSION:
				sequence_InstantiationExpression(context, (InstantiationExpression) semanticObject); 
				return; 
			case ExpressionPackage.INVOKE_EXPRESSION:
				if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getConditionalTestExpressionRule()
						|| action == grammarAccess.getConditionalTestExpressionAccess().getConditionalTestExpressionConditionAction_1_0()
						|| rule == grammarAccess.getLogicalOrExpressionRule()
						|| action == grammarAccess.getLogicalOrExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getLogicalAndExpressionRule()
						|| action == grammarAccess.getLogicalAndExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseOrExpressionRule()
						|| action == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseXorExpressionRule()
						|| action == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseAndExpressionRule()
						|| action == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getEqualityExpressionRule()
						|| action == grammarAccess.getEqualityExpressionAccess().getEqualityBinaryExpressionLeftOperandAction_1_0()
						|| rule == grammarAccess.getRelationalExpressionRule()
						|| action == grammarAccess.getRelationalExpressionAccess().getRelationalBinaryExpressionLeftOperandAction_1_0()
						|| rule == grammarAccess.getAdditiveExpressionRule()
						|| action == grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0()
						|| rule == grammarAccess.getMultiplicativeExpressionRule()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_2_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_3_0()
						|| rule == grammarAccess.getUnaryExpressionRule()
						|| rule == grammarAccess.getCollectionFunctionExpressionRule()
						|| rule == grammarAccess.getPrimaryExpressionRule()
						|| action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_1_0()
						|| action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_2_0()
						|| rule == grammarAccess.getBaseExpressionRule()
						|| rule == grammarAccess.getInvokeExpressionDeprecatedRule()) {
					sequence_InvokeExpressionDeprecated(context, (InvokeExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getInvokeExpressionRule()) {
					sequence_InvokeExpression(context, (InvokeExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION:
				sequence_LeftHandSideExpression(context, (LeftHandSideExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_ANY_OR_NONE_VALUE_EXPRESSION:
				sequence_LiteralAnyOrNoneValueExpression(context, (LiteralAnyOrNoneValueExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_ANY_VALUE_EXPRESSION:
				sequence_LiteralAnyValueExpression(context, (LiteralAnyValueExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_BOOLEAN_EXPRESSION:
				sequence_LiteralBooleanExpression(context, (LiteralBooleanExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_CHARACTER_EXPRESSION:
				sequence_LiteralCharacterExpression(context, (LiteralCharacterExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_COLLECTION_EXPRESSION:
				sequence_LiteralCollectionExpression(context, (LiteralCollectionExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_ENV_EXPRESSION:
				sequence_LiteralEnvExpression(context, (LiteralEnvExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_FLOAT_EXPRESSION:
				sequence_LiteralFloatExpression(context, (LiteralFloatExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_INTEGER_EXPRESSION:
				sequence_LiteralIntegerExpression(context, (LiteralIntegerExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_NONE_VALUE_EXPRESSION:
				sequence_LiteralNoneValueExpression(context, (LiteralNoneValueExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_NULL_EXPRESSION:
				sequence_LiteralNullExpression(context, (LiteralNullExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_OPTIONAL_VALUE_EXPRESSION:
				sequence_LiteralOptionalValueExpression(context, (LiteralOptionalValueExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_PARENT_EXPRESSION:
				sequence_LiteralParentExpression(context, (LiteralParentExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_RATIONAL_EXPRESSION:
				sequence_LiteralRationalExpression(context, (LiteralRationalExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_REFERENCE_ELEMENT:
				if (rule == grammarAccess.getBufferReferenceElementRule()) {
					sequence_BufferReferenceElement(context, (LiteralReferenceElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getLiteralPureReferenceElementRule()
						|| rule == grammarAccess.getLiteralPureReferenceExpressionRule()
						|| rule == grammarAccess.getValuePureNamedMachineExpressionRule()
						|| action == grammarAccess.getValuePureNamedMachineExpressionAccess().getValueElementSpecificationParentAction_1_0()) {
					sequence_LiteralPureReferenceElement(context, (LiteralReferenceElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getLiteralPureReferenceMachineRule()) {
					sequence_LiteralPureReferenceMachine(context, (LiteralReferenceElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDataTypeMultiplicityRule()
						|| rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getConditionalTestExpressionRule()
						|| action == grammarAccess.getConditionalTestExpressionAccess().getConditionalTestExpressionConditionAction_1_0()
						|| rule == grammarAccess.getLogicalOrExpressionRule()
						|| action == grammarAccess.getLogicalOrExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getLogicalAndExpressionRule()
						|| action == grammarAccess.getLogicalAndExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseOrExpressionRule()
						|| action == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseXorExpressionRule()
						|| action == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseAndExpressionRule()
						|| action == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getEqualityExpressionRule()
						|| action == grammarAccess.getEqualityExpressionAccess().getEqualityBinaryExpressionLeftOperandAction_1_0()
						|| rule == grammarAccess.getRelationalExpressionRule()
						|| action == grammarAccess.getRelationalExpressionAccess().getRelationalBinaryExpressionLeftOperandAction_1_0()
						|| rule == grammarAccess.getAdditiveExpressionRule()
						|| action == grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0()
						|| rule == grammarAccess.getMultiplicativeExpressionRule()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_2_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_3_0()
						|| rule == grammarAccess.getUnaryExpressionRule()
						|| rule == grammarAccess.getCollectionFunctionExpressionRule()
						|| rule == grammarAccess.getPrimaryExpressionRule()
						|| action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_1_0()
						|| action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_2_0()
						|| rule == grammarAccess.getBaseExpressionRule()
						|| rule == grammarAccess.getLiteralExpressionRule()
						|| rule == grammarAccess.getLiteralReferenceableExpressionRule()
						|| rule == grammarAccess.getLiteralReferenceExpressionRule()
						|| rule == grammarAccess.getLiteralReferenceElementRule()
						|| rule == grammarAccess.getValueSelectionExpressionRule()
						|| action == grammarAccess.getValueSelectionExpressionAccess().getValueElementSpecificationParentAction_1_0()
						|| action == grammarAccess.getValueSelectionExpressionAccess().getValueElementSpecificationParentAction_2_0()) {
					sequence_LiteralReferenceElement(context, (LiteralReferenceElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getLitteralComElementRule()) {
					sequence_LitteralComElement(context, (LiteralReferenceElement) semanticObject); 
					return; 
				}
				else break;
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION:
				if (rule == grammarAccess.getComBufferRefRule()) {
					sequence_ComBufferRef(context, (LiteralReferenceSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getLiteralReferenceSpecificationRule()) {
					sequence_LiteralReferenceSpecification(context, (LiteralReferenceSpecification) semanticObject); 
					return; 
				}
				else break;
			case ExpressionPackage.LITERAL_SELF_EXPRESSION:
				sequence_LiteralSelfExpression(context, (LiteralSelfExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_STRING_EXPRESSION:
				sequence_LiteralStringExpression(context, (LiteralStringExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_SUPER_EXPRESSION:
				sequence_LiteralSuperExpression(context, (LiteralSuperExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_SYSTEM_EXPRESSION:
				sequence_LiteralSystemExpression(context, (LiteralSystemExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_THIS_EXPRESSION:
				sequence_LiteralThisExpression(context, (LiteralThisExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_TIME_DELTA_EXPRESSION:
				sequence_LiteralTimeDeltaExpression_LiteralTimeDeltaInitialExpression(context, (LiteralTimeDeltaExpression) semanticObject); 
				return; 
			case ExpressionPackage.LITERAL_TIME_EXPRESSION:
				sequence_LiteralTimeExpression_LiteralTimeInitialExpression(context, (LiteralTimeExpression) semanticObject); 
				return; 
			case ExpressionPackage.LOGICAL_ASSOCIATIVE_EXPRESSION:
				if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getConditionalTestExpressionRule()
						|| action == grammarAccess.getConditionalTestExpressionAccess().getConditionalTestExpressionConditionAction_1_0()
						|| rule == grammarAccess.getLogicalOrExpressionRule()
						|| action == grammarAccess.getLogicalOrExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getLogicalAndExpressionRule()
						|| action == grammarAccess.getLogicalAndExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseOrExpressionRule()
						|| action == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseXorExpressionRule()
						|| action == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseAndExpressionRule()
						|| action == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getEqualityExpressionRule()
						|| action == grammarAccess.getEqualityExpressionAccess().getEqualityBinaryExpressionLeftOperandAction_1_0()
						|| rule == grammarAccess.getRelationalExpressionRule()
						|| action == grammarAccess.getRelationalExpressionAccess().getRelationalBinaryExpressionLeftOperandAction_1_0()
						|| rule == grammarAccess.getAdditiveExpressionRule()
						|| action == grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0()
						|| rule == grammarAccess.getMultiplicativeExpressionRule()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_2_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_3_0()
						|| rule == grammarAccess.getUnaryExpressionRule()
						|| rule == grammarAccess.getCollectionFunctionExpressionRule()
						|| rule == grammarAccess.getPrimaryExpressionRule()
						|| action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_1_0()
						|| action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_2_0()
						|| rule == grammarAccess.getBaseExpressionRule()) {
					sequence_LogicalAndExpression_LogicalOrExpression(context, (LogicalAssociativeExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTransitionGuardExpressionRule()) {
					sequence_TransitionGuardExpression(context, (LogicalAssociativeExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionPackage.LOGICAL_UNARY_EXPRESSION:
				sequence_LogicalUnaryExpression(context, (LogicalUnaryExpression) semanticObject); 
				return; 
			case ExpressionPackage.MIX_TUPLE_EXPRESSION:
				sequence_MixTupleExpressionList(context, (MixTupleExpression) semanticObject); 
				return; 
			case ExpressionPackage.NAMED_EXPRESSION:
				sequence_NamedExpression(context, (NamedExpression) semanticObject); 
				return; 
			case ExpressionPackage.NEWFRESH_EXPRESSION:
				sequence_NewfreshExpression(context, (NewfreshExpression) semanticObject); 
				return; 
			case ExpressionPackage.POSITIONAL_TUPLE_EXPRESSION:
				sequence_PositionalTupleExpressionList(context, (PositionalTupleExpression) semanticObject); 
				return; 
			case ExpressionPackage.QUANTIFIED_LOGICAL_EXPRESSION:
				sequence_QuantifiedLogicalExpression(context, (QuantifiedLogicalExpression) semanticObject); 
				return; 
			case ExpressionPackage.RELATIONAL_BINARY_EXPRESSION:
				sequence_RelationalExpression(context, (RelationalBinaryExpression) semanticObject); 
				return; 
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION:
				sequence_RelationalExpression(context, (RelationalTernaryExpression) semanticObject); 
				return; 
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION:
				if (rule == grammarAccess.getComBufferRule()) {
					sequence_ComBuffer(context, (ValueElementSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getObsComElementRule()) {
					sequence_ObsComElement(context, (ValueElementSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getConditionalTestExpressionRule()
						|| action == grammarAccess.getConditionalTestExpressionAccess().getConditionalTestExpressionConditionAction_1_0()
						|| rule == grammarAccess.getLogicalOrExpressionRule()
						|| action == grammarAccess.getLogicalOrExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getLogicalAndExpressionRule()
						|| action == grammarAccess.getLogicalAndExpressionAccess().getLogicalAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseOrExpressionRule()
						|| action == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseXorExpressionRule()
						|| action == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getBitwiseAndExpressionRule()
						|| action == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAssociativeExpressionOperandAction_1_0()
						|| rule == grammarAccess.getEqualityExpressionRule()
						|| action == grammarAccess.getEqualityExpressionAccess().getEqualityBinaryExpressionLeftOperandAction_1_0()
						|| rule == grammarAccess.getRelationalExpressionRule()
						|| action == grammarAccess.getRelationalExpressionAccess().getRelationalBinaryExpressionLeftOperandAction_1_0()
						|| rule == grammarAccess.getAdditiveExpressionRule()
						|| action == grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getAdditiveExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0()
						|| rule == grammarAccess.getMultiplicativeExpressionRule()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_0_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_1_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_2_0()
						|| action == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticAssociativeExpressionOperandAction_1_3_0()
						|| rule == grammarAccess.getUnaryExpressionRule()
						|| rule == grammarAccess.getCollectionFunctionExpressionRule()
						|| rule == grammarAccess.getPrimaryExpressionRule()
						|| action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_1_0()
						|| action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_2_0()
						|| rule == grammarAccess.getBaseExpressionRule()) {
					sequence_PrimaryExpression(context, (ValueElementSpecification) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getPrimaryExpressionAccess().getValueElementSpecificationParentAction_2_4_0()) {
					sequence_PrimaryExpression_ValueElementSpecification_2_4_0(context, (ValueElementSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getValuePureNamedMachineExpressionRule()
						|| action == grammarAccess.getValuePureNamedMachineExpressionAccess().getValueElementSpecificationParentAction_1_0()) {
					sequence_ValuePureNamedMachineExpression(context, (ValueElementSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getValueSelectionExpressionRule()) {
					sequence_ValueSelectionExpression(context, (ValueElementSpecification) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getValueSelectionExpressionAccess().getValueElementSpecificationParentAction_1_0()
						|| action == grammarAccess.getValueSelectionExpressionAccess().getValueElementSpecificationParentAction_2_0()) {
					sequence_ValueSelectionExpression_ValueElementSpecification_1_0_ValueElementSpecification_2_0(context, (ValueElementSpecification) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getValueSelectionExpressionAccess().getValueElementSpecificationParentAction_2_4_0()) {
					sequence_ValueSelectionExpression_ValueElementSpecification_2_4_0(context, (ValueElementSpecification) semanticObject); 
					return; 
				}
				else break;
			}
		else if (epackage == FormalmlPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case FormalmlPackage.XLIA_ATTRIBUTE:
				if (rule == grammarAccess.getXliaNamedElementRule()
						|| rule == grammarAccess.getXliaAttributeRule()) {
					sequence_XliaAttribute(context, (XliaAttribute) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXliaPrologAttributeRule()) {
					sequence_XliaPrologAttribute(context, (XliaAttribute) semanticObject); 
					return; 
				}
				else break;
			case FormalmlPackage.XLIA_MODEL:
				sequence_Xlia(context, (XliaModel) semanticObject); 
				return; 
			case FormalmlPackage.XLIA_OBJECT:
				if (rule == grammarAccess.getXliaNamedElementRule()
						|| rule == grammarAccess.getXliaObjectRule()) {
					sequence_XliaObject(context, (XliaObject) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXliaOptionObjectRule()) {
					sequence_XliaOptionObject(context, (XliaObject) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXliaPrologObjectRule()) {
					sequence_XliaPrologObject(context, (XliaObject) semanticObject); 
					return; 
				}
				else break;
			case FormalmlPackage.XLIA_SECTION:
				sequence_XliaSection(context, (XliaSection) semanticObject); 
				return; 
			}
		else if (epackage == InfrastructurePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case InfrastructurePackage.BEHAVIOR:
				sequence_MoeBehavior(context, (Behavior) semanticObject); 
				return; 
			case InfrastructurePackage.BEHAVIOR_PART:
				sequence_BehaviorPart(context, (BehaviorPart) semanticObject); 
				return; 
			case InfrastructurePackage.BUFFER:
				if (rule == grammarAccess.getBufferImplRule()
						|| rule == grammarAccess.getBufferPublicRule()
						|| rule == grammarAccess.getBufferProtectedRule()
						|| rule == grammarAccess.getBufferPrivateRule()) {
					sequence_BufferImpl(context, (Buffer) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getBufferRule()) {
					sequence_Buffer(context, (Buffer) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.CHANNEL:
				if (rule == grammarAccess.getChannelRule()) {
					sequence_Channel(context, (Channel) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getChannelimplRule()
						|| rule == grammarAccess.getChannelPublicRule()
						|| rule == grammarAccess.getChannelProtectedRule()
						|| rule == grammarAccess.getChannelPrivateRule()) {
					sequence_Channelimpl(context, (Channel) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.COM_POINT:
				sequence_ComPoint(context, (ComPoint) semanticObject); 
				return; 
			case InfrastructurePackage.COM_PROTOCOL:
				if (rule == grammarAccess.getComPointProtocolRule()) {
					sequence_ComPointProtocol(context, (ComProtocol) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getComProtocolRule()) {
					sequence_ComProtocol(context, (ComProtocol) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getComRouteProtocolRule()) {
					sequence_ComRouteProtocol(context, (ComProtocol) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.COMPOSITE_PART:
				sequence_CompositePart(context, (CompositePart) semanticObject); 
				return; 
			case InfrastructurePackage.CONNECTOR:
				sequence_Connector(context, (Connector) semanticObject); 
				return; 
			case InfrastructurePackage.CONNECTOR_END:
				sequence_ConnectorEnd(context, (ConnectorEnd) semanticObject); 
				return; 
			case InfrastructurePackage.FUNCTION:
				if (rule == grammarAccess.getFunctionImplRule()
						|| rule == grammarAccess.getFunctionPublicRule()
						|| rule == grammarAccess.getFunctionProtectedRule()
						|| rule == grammarAccess.getFunctionPrivateRule()) {
					sequence_FunctionImpl(context, (Function) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.INSTANCE_MACHINE:
				if (rule == grammarAccess.getDynamicInstanceSpecificationRule()) {
					sequence_DynamicInstanceSpecification(context, (InstanceMachine) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getInstanceMachineRule()) {
					sequence_InstanceMachine(context, (InstanceMachine) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.MACHINE:
				sequence_MachineBlock(context, (Machine) semanticObject); 
				return; 
			case InfrastructurePackage.MODEL_OF_COMPUTATION:
				sequence_ModelOfComputation(context, (ModelOfComputation) semanticObject); 
				return; 
			case InfrastructurePackage.MODEL_OF_EXECUTION:
				if (rule == grammarAccess.getModelOfExecutionRule()) {
					sequence_ModelOfExecution(context, (ModelOfExecution) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getProcedureExecutionRule()) {
					sequence_ProcedureExecution(context, (ModelOfExecution) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMoeCompositeStateRoutinesRule()) {
					sequence_moeCompositeStateRoutines(context, (ModelOfExecution) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMoeFinalStateRoutinesRule()) {
					sequence_moeFinalStateRoutines(context, (ModelOfExecution) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMoePseudotateRoutinesRule()) {
					sequence_moePseudotateRoutines(context, (ModelOfExecution) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMoeSimpleStateRoutinesRule()) {
					sequence_moeSimpleStateRoutines(context, (ModelOfExecution) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMoeStartStateRoutinesRule()) {
					sequence_moeStartStateRoutines(context, (ModelOfExecution) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.MODEL_OF_INTERACTION:
				sequence_ModelOfInteraction(context, (ModelOfInteraction) semanticObject); 
				return; 
			case InfrastructurePackage.MODIFIER:
				if (rule == grammarAccess.getModifierVarRule()) {
					sequence_ModifierVar(context, (Modifier) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getModifierRule()) {
					sequence_Modifier(context, (Modifier) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.PARAMETER:
				if (rule == grammarAccess.getFormalParameterRule()) {
					sequence_FormalParameter(context, (org.eclipse.efm.ecore.formalml.infrastructure.Parameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFunctionalParameterRule()) {
					sequence_FunctionalParameter(context, (org.eclipse.efm.ecore.formalml.infrastructure.Parameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getParameterImplRule()
						|| rule == grammarAccess.getParameterInputRule()
						|| rule == grammarAccess.getParameterInoutRule()
						|| rule == grammarAccess.getParameterOutputRule()
						|| rule == grammarAccess.getParameterReturnRule()) {
					sequence_ParameterImpl(context, (org.eclipse.efm.ecore.formalml.infrastructure.Parameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (org.eclipse.efm.ecore.formalml.infrastructure.Parameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVariableRoutineParameterRule()) {
					sequence_VariableRoutineParameter(context, (org.eclipse.efm.ecore.formalml.infrastructure.Parameter) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.PARAMETER_SET:
				if (rule == grammarAccess.getBlockParameterSetRule()) {
					sequence_BlockParameterSet(context, (ParameterSet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFormalParameterSetRule()) {
					sequence_FormalParameterSet(context, (ParameterSet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFunctionalParameterSetRule()) {
					sequence_FunctionalParameterSet(context, (ParameterSet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVariableRoutineParameterSetRule()) {
					sequence_VariableRoutineParameterSet(context, (ParameterSet) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.PORT:
				if (rule == grammarAccess.getPortImplRule()
						|| rule == grammarAccess.getPortPublicRule()
						|| rule == grammarAccess.getPortProtectedRule()
						|| rule == grammarAccess.getPortPrivateRule()) {
					sequence_PortImpl(context, (Port) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPortRule()) {
					sequence_Port(context, (Port) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.PROCEDURE:
				sequence_Procedure(context, (Procedure) semanticObject); 
				return; 
			case InfrastructurePackage.PROPERTY_PART:
				sequence_PropertyPart(context, (PropertyPart) semanticObject); 
				return; 
			case InfrastructurePackage.ROUTE:
				sequence_Route(context, (Route) semanticObject); 
				return; 
			case InfrastructurePackage.ROUTINE:
				if (rule == grammarAccess.getOnWriteRoutineRule()) {
					sequence_OnWriteRoutine(context, (Routine) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRoutineRule()) {
					sequence_Routine(context, (Routine) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeConstraintRoutineRule()) {
					sequence_TypeConstraintRoutine(context, (Routine) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMoeRoutineRule()) {
					sequence_moeRoutine(context, (Routine) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.SIGNAL:
				if (rule == grammarAccess.getSignalImplRule()
						|| rule == grammarAccess.getSignalPublicRule()
						|| rule == grammarAccess.getSignalProtectedRule()
						|| rule == grammarAccess.getSignalPrivateRule()) {
					sequence_SignalImpl(context, (Signal) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSignalReferenceRule()) {
					sequence_SignalReference(context, (Signal) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSignalRule()) {
					sequence_Signal(context, (Signal) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.SLOT_PROPERTY:
				if (rule == grammarAccess.getSlotParameterRule()) {
					sequence_SlotParameter(context, (SlotProperty) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSlotPropertyRule()) {
					sequence_SlotProperty(context, (SlotProperty) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.VARIABLE:
				if (rule == grammarAccess.getBoundVariableRule()) {
					sequence_BoundVariable(context, (Variable) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVariableImplRule()
						|| rule == grammarAccess.getVariablePublicRule()
						|| rule == grammarAccess.getVariableProtectedRule()
						|| rule == grammarAccess.getVariablePrivateRule()) {
					sequence_VariableImpl(context, (Variable) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVariableRule()) {
					sequence_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.XLIA_SYSTEM:
				sequence_XliaSystem(context, (XliaSystem) semanticObject); 
				return; 
			}
		else if (epackage == StatemachinePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case StatemachinePackage.FINAL_STATE:
				sequence_FinalState(context, (FinalState) semanticObject); 
				return; 
			case StatemachinePackage.PSEUDOSTATE:
				if (rule == grammarAccess.getPseudostateRule()) {
					sequence_EndingPseudostate_OtherPseudostate_PseudostateInitial(context, (Pseudostate) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getEndingPseudostateRule()) {
					sequence_EndingPseudostate(context, (Pseudostate) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOtherPseudostateRule()) {
					sequence_OtherPseudostate(context, (Pseudostate) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPseudostateInitialRule()) {
					sequence_PseudostateInitial(context, (Pseudostate) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.REGION:
				if (rule == grammarAccess.getStatemachineNamedRegionRule()) {
					sequence_StatemachineNamedRegion(context, (Region) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getStatemachineRegionLiteRule()) {
					sequence_StatemachineRegionLite(context, (Region) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getStatemachineRegionRule()) {
					sequence_StatemachineRegion(context, (Region) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.START_STATE:
				sequence_StartState(context, (StartState) semanticObject); 
				return; 
			case StatemachinePackage.STATE:
				if (rule == grammarAccess.getStateRule()) {
					sequence_CompositeState_SimpleState(context, (State) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getCompositeStateRule()) {
					sequence_CompositeState(context, (State) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSimpleStateRule()) {
					sequence_SimpleState(context, (State) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.STATEMACHINE:
				sequence_Statemachine(context, (Statemachine) semanticObject); 
				return; 
			case StatemachinePackage.TRANSITION:
				sequence_Transition(context, (Transition) semanticObject); 
				return; 
			case StatemachinePackage.TRANSITION_MOE:
				sequence_TransitionMoe(context, (TransitionMoe) semanticObject); 
				return; 
			}
		else if (epackage == StatementPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case StatementPackage.ACTIVITY_STATEMENT:
				sequence_ActivityStatement(context, (ActivityStatement) semanticObject); 
				return; 
			case StatementPackage.BLOCK_STATEMENT:
				if (rule == grammarAccess.getStatementRule()
						|| rule == grammarAccess.getBlockStatementRule()) {
					sequence_BlockStatement(context, (BlockStatement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getConditionalBlockStatementRule()) {
					sequence_ConditionalBlockStatement(context, (BlockStatement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTransitionBehaviorRule()) {
					sequence_TransitionBehavior(context, (BlockStatement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTransitionEffectRule()
						|| action == grammarAccess.getTransitionEffectAccess().getBlockStatementStatementAction_1_0()) {
					sequence_TransitionEffect(context, (BlockStatement) semanticObject); 
					return; 
				}
				else break;
			case StatementPackage.CHECK_SAT_GUARD_STATEMENT:
				sequence_CheckSatGuardStatement(context, (CheckSatGuardStatement) semanticObject); 
				return; 
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT:
				sequence_ElseIfStatement(context, (ConditionalBlockStatement) semanticObject); 
				return; 
			case StatementPackage.DO_WHILE_STATEMENT:
				sequence_DoWhileStatement(context, (DoWhileStatement) semanticObject); 
				return; 
			case StatementPackage.EVENT_GUARD_STATEMENT:
				sequence_EventGuardStatement(context, (EventGuardStatement) semanticObject); 
				return; 
			case StatementPackage.EXPRESSION_STATEMENT:
				sequence_ExpressionStatement(context, (ExpressionStatement) semanticObject); 
				return; 
			case StatementPackage.FOR_EACH_STATEMENT:
				sequence_ForEachStatement(context, (ForEachStatement) semanticObject); 
				return; 
			case StatementPackage.FOR_STATEMENT:
				sequence_ForStatement(context, (ForStatement) semanticObject); 
				return; 
			case StatementPackage.GUARD_STATEMENT:
				if (rule == grammarAccess.getStatementRule()
						|| rule == grammarAccess.getGuardStatementRule()) {
					sequence_GuardStatement(context, (GuardStatement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTransitionGuardRule()) {
					sequence_GuardStatement_TransitionGuard(context, (GuardStatement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getGuardTestExpressionRule()) {
					sequence_GuardTestExpression(context, (GuardStatement) semanticObject); 
					return; 
				}
				else break;
			case StatementPackage.IF_STATEMENT:
				sequence_IfStatement(context, (IfStatement) semanticObject); 
				return; 
			case StatementPackage.INPUT_COM_STATEMENT:
				if (rule == grammarAccess.getTransitionTriggerRule()
						|| rule == grammarAccess.getStatementRule()
						|| rule == grammarAccess.getInputComStatementRule()) {
					sequence_InputComStatement(context, (InputComStatement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getObservableStatementRule()
						|| rule == grammarAccess.getObsInputComStatementRule()) {
					sequence_ObsInputComStatement(context, (InputComStatement) semanticObject); 
					return; 
				}
				else break;
			case StatementPackage.INTERRUPT_STATEMENT:
				sequence_InterruptStatement(context, (InterruptStatement) semanticObject); 
				return; 
			case StatementPackage.INVOKE_STATEMENT:
				sequence_InvokeStatement(context, (InvokeStatement) semanticObject); 
				return; 
			case StatementPackage.META_STATEMENT:
				sequence_MetaStatement(context, (MetaStatement) semanticObject); 
				return; 
			case StatementPackage.OBSERVER_STATEMENT:
				sequence_ObserverStatement(context, (ObserverStatement) semanticObject); 
				return; 
			case StatementPackage.OUTPUT_COM_STATEMENT:
				if (rule == grammarAccess.getObservableStatementRule()
						|| rule == grammarAccess.getObsOutputComStatementRule()) {
					sequence_ObsOutputComStatement(context, (OutputComStatement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTransitionEffectRule()
						|| action == grammarAccess.getTransitionEffectAccess().getBlockStatementStatementAction_1_0()
						|| rule == grammarAccess.getTransitionEffectStatementRule()
						|| rule == grammarAccess.getStatementRule()
						|| rule == grammarAccess.getOutputComStatementRule()) {
					sequence_OutputComStatement(context, (OutputComStatement) semanticObject); 
					return; 
				}
				else break;
			case StatementPackage.TIMED_GUARD_STATEMENT:
				if (rule == grammarAccess.getStatementRule()
						|| rule == grammarAccess.getTimedGuardStatementRule()) {
					sequence_TimedGuardStatement(context, (TimedGuardStatement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTransitionTimedGuardRule()) {
					sequence_TimedGuardStatement_TransitionTimedGuard(context, (TimedGuardStatement) semanticObject); 
					return; 
				}
				else break;
			case StatementPackage.WHILE_DO_STATEMENT:
				sequence_WhileDoStatement(context, (WhileDoStatement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     TransitionEffect returns ActivityStatement
	 *     TransitionEffect.BlockStatement_1_0 returns ActivityStatement
	 *     TransitionEffectStatement returns ActivityStatement
	 *     Statement returns ActivityStatement
	 *     ActivityStatement returns ActivityStatement
	 *
	 * Constraint:
	 *     (op=OPERATOR_ACTIVITY (machine=ValuePureNamedMachineExpression tuple=TupleParameterExpression?)?)
	 */
	protected void sequence_ActivityStatement(ISerializationContext context, ActivityStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ArithmeticAssociativeExpression
	 *     ConditionalTestExpression returns ArithmeticAssociativeExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns ArithmeticAssociativeExpression
	 *     LogicalOrExpression returns ArithmeticAssociativeExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns ArithmeticAssociativeExpression
	 *     LogicalAndExpression returns ArithmeticAssociativeExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns ArithmeticAssociativeExpression
	 *     BitwiseOrExpression returns ArithmeticAssociativeExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns ArithmeticAssociativeExpression
	 *     BitwiseXorExpression returns ArithmeticAssociativeExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns ArithmeticAssociativeExpression
	 *     BitwiseAndExpression returns ArithmeticAssociativeExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns ArithmeticAssociativeExpression
	 *     EqualityExpression returns ArithmeticAssociativeExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns ArithmeticAssociativeExpression
	 *     RelationalExpression returns ArithmeticAssociativeExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns ArithmeticAssociativeExpression
	 *     AdditiveExpression returns ArithmeticAssociativeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns ArithmeticAssociativeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns ArithmeticAssociativeExpression
	 *     MultiplicativeExpression returns ArithmeticAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns ArithmeticAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns ArithmeticAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns ArithmeticAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns ArithmeticAssociativeExpression
	 *     UnaryExpression returns ArithmeticAssociativeExpression
	 *     CollectionFunctionExpression returns ArithmeticAssociativeExpression
	 *     PrimaryExpression returns ArithmeticAssociativeExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns ArithmeticAssociativeExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns ArithmeticAssociativeExpression
	 *     BaseExpression returns ArithmeticAssociativeExpression
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             operand+=AdditiveExpression_ArithmeticAssociativeExpression_1_0_0 
	 *             operator='+' 
	 *             operand+=MultiplicativeExpression 
	 *             operand+=MultiplicativeExpression*
	 *         ) | 
	 *         (
	 *             operand+=AdditiveExpression_ArithmeticAssociativeExpression_1_1_0 
	 *             operator='-' 
	 *             operand+=MultiplicativeExpression 
	 *             operand+=MultiplicativeExpression*
	 *         ) | 
	 *         (operand+=MultiplicativeExpression_ArithmeticAssociativeExpression_1_0_0 operator='*' operand+=UnaryExpression operand+=UnaryExpression*) | 
	 *         (operand+=MultiplicativeExpression_ArithmeticAssociativeExpression_1_1_0 operator='**' operand+=UnaryExpression operand+=UnaryExpression*) | 
	 *         (operand+=MultiplicativeExpression_ArithmeticAssociativeExpression_1_2_0 operator='/' operand+=UnaryExpression operand+=UnaryExpression*) | 
	 *         (operand+=MultiplicativeExpression_ArithmeticAssociativeExpression_1_3_0 operator='%' operand+=UnaryExpression operand+=UnaryExpression*)
	 *     )
	 */
	protected void sequence_AdditiveExpression_MultiplicativeExpression(ISerializationContext context, ArithmeticAssociativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AnyDataTypeReference returns DataTypeReference
	 *
	 * Constraint:
	 *     (
	 *         (support=AnyDataTypeReference_DataTypeReference_0_1_0 multiplicity=DataTypeMultiplicity) | 
	 *         (typeref=[DataType|ESUfid] multiplicity=DataTypeMultiplicity?)
	 *     )
	 */
	protected void sequence_AnyDataTypeReference(ISerializationContext context, DataTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AnyNullPrimitiveInstanceType returns PrimitiveInstanceType
	 *
	 * Constraint:
	 *     expected=AnyPrimitiveInstanceKind
	 */
	protected void sequence_AnyNullPrimitiveInstanceType(ISerializationContext context, PrimitiveInstanceType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DatatypePackage.Literals.PRIMITIVE_INSTANCE_TYPE__EXPECTED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DatatypePackage.Literals.PRIMITIVE_INSTANCE_TYPE__EXPECTED));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAnyNullPrimitiveInstanceTypeAccess().getExpectedAnyPrimitiveInstanceKindEnumRuleCall_1_0(), semanticObject.getExpected());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ArithmeticUnaryExpression
	 *     ConditionalTestExpression returns ArithmeticUnaryExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns ArithmeticUnaryExpression
	 *     LogicalOrExpression returns ArithmeticUnaryExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns ArithmeticUnaryExpression
	 *     LogicalAndExpression returns ArithmeticUnaryExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns ArithmeticUnaryExpression
	 *     BitwiseOrExpression returns ArithmeticUnaryExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns ArithmeticUnaryExpression
	 *     BitwiseXorExpression returns ArithmeticUnaryExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns ArithmeticUnaryExpression
	 *     BitwiseAndExpression returns ArithmeticUnaryExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns ArithmeticUnaryExpression
	 *     EqualityExpression returns ArithmeticUnaryExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns ArithmeticUnaryExpression
	 *     RelationalExpression returns ArithmeticUnaryExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns ArithmeticUnaryExpression
	 *     AdditiveExpression returns ArithmeticUnaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns ArithmeticUnaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns ArithmeticUnaryExpression
	 *     MultiplicativeExpression returns ArithmeticUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns ArithmeticUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns ArithmeticUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns ArithmeticUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns ArithmeticUnaryExpression
	 *     UnaryExpression returns ArithmeticUnaryExpression
	 *     CollectionFunctionExpression returns ArithmeticUnaryExpression
	 *     ArithmeticUnaryExpression returns ArithmeticUnaryExpression
	 *     PrimaryExpression returns ArithmeticUnaryExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns ArithmeticUnaryExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns ArithmeticUnaryExpression
	 *     BaseExpression returns ArithmeticUnaryExpression
	 *
	 * Constraint:
	 *     (operator=ArithmeticUnaryOperator operand=UnaryExpression)
	 */
	protected void sequence_ArithmeticUnaryExpression(ISerializationContext context, ArithmeticUnaryExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getArithmeticUnaryExpressionAccess().getOperatorArithmeticUnaryOperatorParserRuleCall_0_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getArithmeticUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ForAssignmentExpression returns AssignmentExpression
	 *     Expression returns AssignmentExpression
	 *     AssignmentExpression returns AssignmentExpression
	 *     ConditionalTestExpression returns AssignmentExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns AssignmentExpression
	 *     LogicalOrExpression returns AssignmentExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns AssignmentExpression
	 *     LogicalAndExpression returns AssignmentExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns AssignmentExpression
	 *     BitwiseOrExpression returns AssignmentExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns AssignmentExpression
	 *     BitwiseXorExpression returns AssignmentExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns AssignmentExpression
	 *     BitwiseAndExpression returns AssignmentExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns AssignmentExpression
	 *     EqualityExpression returns AssignmentExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns AssignmentExpression
	 *     RelationalExpression returns AssignmentExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns AssignmentExpression
	 *     AdditiveExpression returns AssignmentExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns AssignmentExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns AssignmentExpression
	 *     MultiplicativeExpression returns AssignmentExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns AssignmentExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns AssignmentExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns AssignmentExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns AssignmentExpression
	 *     UnaryExpression returns AssignmentExpression
	 *     CollectionFunctionExpression returns AssignmentExpression
	 *     PrimaryExpression returns AssignmentExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns AssignmentExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns AssignmentExpression
	 *     BaseExpression returns AssignmentExpression
	 *
	 * Constraint:
	 *     (leftHandSide=LeftHandSideExpression operator=AssignmentOperator rightHandSide=Expression)
	 */
	protected void sequence_AssignmentExpression(ISerializationContext context, AssignmentExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getLeftHandSideLeftHandSideExpressionParserRuleCall_0_0(), semanticObject.getLeftHandSide());
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorParserRuleCall_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getRightHandSideExpressionParserRuleCall_2_0(), semanticObject.getRightHandSide());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     BehaviorPart returns BehaviorPart
	 *
	 * Constraint:
	 *     ((behavior+=Behavior | behavior+=Statemachine)* main=MoeBehavior)
	 */
	protected void sequence_BehaviorPart(ISerializationContext context, BehaviorPart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns BitwiseAssociativeExpression
	 *     ConditionalTestExpression returns BitwiseAssociativeExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns BitwiseAssociativeExpression
	 *     LogicalOrExpression returns BitwiseAssociativeExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns BitwiseAssociativeExpression
	 *     LogicalAndExpression returns BitwiseAssociativeExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns BitwiseAssociativeExpression
	 *     BitwiseOrExpression returns BitwiseAssociativeExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns BitwiseAssociativeExpression
	 *     BitwiseXorExpression returns BitwiseAssociativeExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns BitwiseAssociativeExpression
	 *     BitwiseAndExpression returns BitwiseAssociativeExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns BitwiseAssociativeExpression
	 *     EqualityExpression returns BitwiseAssociativeExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns BitwiseAssociativeExpression
	 *     RelationalExpression returns BitwiseAssociativeExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns BitwiseAssociativeExpression
	 *     AdditiveExpression returns BitwiseAssociativeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns BitwiseAssociativeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns BitwiseAssociativeExpression
	 *     MultiplicativeExpression returns BitwiseAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns BitwiseAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns BitwiseAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns BitwiseAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns BitwiseAssociativeExpression
	 *     UnaryExpression returns BitwiseAssociativeExpression
	 *     CollectionFunctionExpression returns BitwiseAssociativeExpression
	 *     PrimaryExpression returns BitwiseAssociativeExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns BitwiseAssociativeExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns BitwiseAssociativeExpression
	 *     BaseExpression returns BitwiseAssociativeExpression
	 *
	 * Constraint:
	 *     (
	 *         (operand+=BitwiseOrExpression_BitwiseAssociativeExpression_1_0 operator='|' operand+=BitwiseXorExpression operand+=BitwiseXorExpression*) | 
	 *         (operand+=BitwiseXorExpression_BitwiseAssociativeExpression_1_0 operator='^' operand+=BitwiseAndExpression operand+=BitwiseAndExpression*) | 
	 *         (operand+=BitwiseAndExpression_BitwiseAssociativeExpression_1_0 operator='&' operand+=EqualityExpression operand+=EqualityExpression*)
	 *     )
	 */
	protected void sequence_BitwiseAndExpression_BitwiseOrExpression_BitwiseXorExpression(ISerializationContext context, BitwiseAssociativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns BitwiseUnaryExpression
	 *     ConditionalTestExpression returns BitwiseUnaryExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns BitwiseUnaryExpression
	 *     LogicalOrExpression returns BitwiseUnaryExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns BitwiseUnaryExpression
	 *     LogicalAndExpression returns BitwiseUnaryExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns BitwiseUnaryExpression
	 *     BitwiseOrExpression returns BitwiseUnaryExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns BitwiseUnaryExpression
	 *     BitwiseXorExpression returns BitwiseUnaryExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns BitwiseUnaryExpression
	 *     BitwiseAndExpression returns BitwiseUnaryExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns BitwiseUnaryExpression
	 *     EqualityExpression returns BitwiseUnaryExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns BitwiseUnaryExpression
	 *     RelationalExpression returns BitwiseUnaryExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns BitwiseUnaryExpression
	 *     AdditiveExpression returns BitwiseUnaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns BitwiseUnaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns BitwiseUnaryExpression
	 *     MultiplicativeExpression returns BitwiseUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns BitwiseUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns BitwiseUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns BitwiseUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns BitwiseUnaryExpression
	 *     UnaryExpression returns BitwiseUnaryExpression
	 *     CollectionFunctionExpression returns BitwiseUnaryExpression
	 *     BitwiseUnaryExpression returns BitwiseUnaryExpression
	 *     PrimaryExpression returns BitwiseUnaryExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns BitwiseUnaryExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns BitwiseUnaryExpression
	 *     BaseExpression returns BitwiseUnaryExpression
	 *
	 * Constraint:
	 *     (operator='~' operand=UnaryExpression)
	 */
	protected void sequence_BitwiseUnaryExpression(ISerializationContext context, BitwiseUnaryExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBitwiseUnaryExpressionAccess().getOperatorTildeKeyword_0_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getBitwiseUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     BlockParameterSet returns ParameterSet
	 *
	 * Constraint:
	 *     (
	 *         parameter+=ParameterInput | 
	 *         parameter+=ParameterInput | 
	 *         parameter+=ParameterInout | 
	 *         parameter+=ParameterInout | 
	 *         parameter+=ParameterOutput | 
	 *         parameter+=ParameterOutput | 
	 *         parameter+=ParameterReturn | 
	 *         parameter+=ParameterReturn
	 *     )*
	 */
	protected void sequence_BlockParameterSet(ISerializationContext context, ParameterSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns BlockStatement
	 *     BlockStatement returns BlockStatement
	 *
	 * Constraint:
	 *     (op=BlockStatementScheduler? statement+=Statement*)
	 */
	protected void sequence_BlockStatement(ISerializationContext context, BlockStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BoundVariable returns Variable
	 *
	 * Constraint:
	 *     (name=ESIdentifier type=DataType)
	 */
	protected void sequence_BoundVariable(ISerializationContext context, Variable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.NAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.NAMED_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.TYPED_ELEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.TYPED_ELEMENT__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBoundVariableAccess().getNameESIdentifierParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getBoundVariableAccess().getTypeDataTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     BufferContainerType returns CollectionType
	 *
	 * Constraint:
	 *     (container=BufferContainerKind (size=EInt | unbounded?='*' | size=EInt | unbounded?='*')?)
	 */
	protected void sequence_BufferContainerType(ISerializationContext context, CollectionType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BufferImpl returns Buffer
	 *     BufferPublic returns Buffer
	 *     BufferProtected returns Buffer
	 *     BufferPrivate returns Buffer
	 *
	 * Constraint:
	 *     (modifier=Modifier? type=BufferContainerType name=ESIdentifier unrestrictedName=UnrestrictedName?)
	 */
	protected void sequence_BufferImpl(ISerializationContext context, Buffer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BufferReferenceElement returns LiteralReferenceElement
	 *
	 * Constraint:
	 *     element=[Buffer|ESIdentifier]
	 */
	protected void sequence_BufferReferenceElement(ISerializationContext context, LiteralReferenceElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBufferReferenceElementAccess().getElementBufferESIdentifierParserRuleCall_1_0_1(), semanticObject.eGet(ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Buffer returns Buffer
	 *
	 * Constraint:
	 *     ((visibility=VisibilityKind | modifier=Modifier)* type=BufferContainerType name=ESIdentifier unrestrictedName=UnrestrictedName?)
	 */
	protected void sequence_Buffer(ISerializationContext context, Buffer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns CastExpression
	 *     ConditionalTestExpression returns CastExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns CastExpression
	 *     LogicalOrExpression returns CastExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns CastExpression
	 *     LogicalAndExpression returns CastExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns CastExpression
	 *     BitwiseOrExpression returns CastExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns CastExpression
	 *     BitwiseXorExpression returns CastExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns CastExpression
	 *     BitwiseAndExpression returns CastExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns CastExpression
	 *     EqualityExpression returns CastExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns CastExpression
	 *     RelationalExpression returns CastExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns CastExpression
	 *     AdditiveExpression returns CastExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns CastExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns CastExpression
	 *     MultiplicativeExpression returns CastExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns CastExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns CastExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns CastExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns CastExpression
	 *     UnaryExpression returns CastExpression
	 *     CastExpression returns CastExpression
	 *     CollectionFunctionExpression returns CastExpression
	 *     PrimaryExpression returns CastExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns CastExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns CastExpression
	 *     BaseExpression returns CastExpression
	 *
	 * Constraint:
	 *     (datatype=[DataType|ESUfid] operand=Expression)
	 */
	protected void sequence_CastExpression(ISerializationContext context, CastExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.CAST_EXPRESSION__DATATYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.CAST_EXPRESSION__DATATYPE));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.UNARY_EXPRESSION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCastExpressionAccess().getDatatypeDataTypeESUfidParserRuleCall_2_0_1(), semanticObject.eGet(ExpressionPackage.Literals.CAST_EXPRESSION__DATATYPE, false));
		feeder.accept(grammarAccess.getCastExpressionAccess().getOperandExpressionParserRuleCall_5_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Channel returns Channel
	 *
	 * Constraint:
	 *     ((visibility=VisibilityKind | modifier=Modifier)* name=ESIdentifier unrestrictedName=UnrestrictedName? signal+=SignalReference+)
	 */
	protected void sequence_Channel(ISerializationContext context, Channel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Channelimpl returns Channel
	 *     ChannelPublic returns Channel
	 *     ChannelProtected returns Channel
	 *     ChannelPrivate returns Channel
	 *
	 * Constraint:
	 *     (modifier=Modifier? name=ESIdentifier unrestrictedName=UnrestrictedName? signal+=SignalReference+)
	 */
	protected void sequence_Channelimpl(ISerializationContext context, Channel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionGuard returns CheckSatGuardStatement
	 *     Statement returns CheckSatGuardStatement
	 *     CheckSatGuardStatement returns CheckSatGuardStatement
	 *
	 * Constraint:
	 *     (solver=ESIdentifier condition=Expression)
	 */
	protected void sequence_CheckSatGuardStatement(ISerializationContext context, CheckSatGuardStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.CHECK_SAT_GUARD_STATEMENT__SOLVER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.CHECK_SAT_GUARD_STATEMENT__SOLVER));
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCheckSatGuardStatementAccess().getSolverESIdentifierParserRuleCall_2_0(), semanticObject.getSolver());
		feeder.accept(grammarAccess.getCheckSatGuardStatementAccess().getConditionExpressionParserRuleCall_4_0(), semanticObject.getCondition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ChoiceTypeDefinitionImpl returns ChoiceType
	 *
	 * Constraint:
	 *     (name=ESIdentifier unrestrictedName=UnrestrictedName? typedef?='choice' property+=Variable+)
	 */
	protected void sequence_ChoiceTypeDefinitionImpl(ISerializationContext context, ChoiceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeDefinition returns ChoiceType
	 *     ChoiceTypeDefinition returns ChoiceType
	 *
	 * Constraint:
	 *     (visibility=VisibilityKind? typedef?='type' name=ESIdentifier unrestrictedName=UnrestrictedName? property+=Variable+)
	 */
	protected void sequence_ChoiceTypeDefinition(ISerializationContext context, ChoiceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataType returns ChoiceType
	 *     StructuredDataType returns ChoiceType
	 *     ChoiceType returns ChoiceType
	 *
	 * Constraint:
	 *     property+=Variable+
	 */
	protected void sequence_ChoiceType(ISerializationContext context, ChoiceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     CollectionTypeDefinitionImpl returns CollectionType
	 *
	 * Constraint:
	 *     (name=ESIdentifier unrestrictedName=UnrestrictedName? container=CollectionKind support=DataType (size=EInt | unbounded?='*')?)
	 */
	protected void sequence_CollectionTypeDefinitionImpl(ISerializationContext context, CollectionType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeDefinition returns CollectionType
	 *     CollectionTypeDefinition returns CollectionType
	 *
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         container=CollectionKind 
	 *         support=DataType 
	 *         (size=EInt | unbounded?='*')?
	 *     )
	 */
	protected void sequence_CollectionTypeDefinition(ISerializationContext context, CollectionType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns CollectionType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns CollectionType
	 *     DataType returns CollectionType
	 *     SimpleDataType returns CollectionType
	 *     CollectionType returns CollectionType
	 *     AnyDataTypeReference returns CollectionType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns CollectionType
	 *
	 * Constraint:
	 *     (container=CollectionKind (support=DataType (size=EInt | unbounded?='*')?)?)
	 */
	protected void sequence_CollectionType(ISerializationContext context, CollectionType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ColonQualifiedName returns QualifiedName
	 *
	 * Constraint:
	 *     (nameBinding+=NameBinding nameBinding+=NameBinding+)
	 */
	protected void sequence_ColonQualifiedName_UnqualifiedName(ISerializationContext context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComBufferRef returns LiteralReferenceSpecification
	 *
	 * Constraint:
	 *     (parent+=LiteralReferenceExpression* element=BufferReferenceElement)
	 */
	protected void sequence_ComBufferRef(ISerializationContext context, LiteralReferenceSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComBuffer returns ValueElementSpecification
	 *
	 * Constraint:
	 *     ((parent=LiteralPureReferenceMachine (kind=ValueDotFieldExpressionKind | kind=ValueArrowFieldExpressionKind))? element=[Buffer|ESIdentifier])
	 */
	protected void sequence_ComBuffer(ISerializationContext context, ValueElementSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComPointProtocol returns ComProtocol
	 *
	 * Constraint:
	 *     (
	 *         (protocol=BufferProtocolKind (inner_buffer=BufferContainerType | buffer=ComBuffer | inner_buffer=BufferContainerType | buffer=ComBuffer)?) | 
	 *         inner_buffer=BufferContainerType | 
	 *         bufferRef=ComBufferRef
	 *     )
	 */
	protected void sequence_ComPointProtocol(ISerializationContext context, ComProtocol semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComPoint returns ComPoint
	 *
	 * Constraint:
	 *     (machine=[NamedElement|ESIdentifier]? port=[Port|ESIdentifier])
	 */
	protected void sequence_ComPoint(ISerializationContext context, ComPoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComProtocol returns ComProtocol
	 *
	 * Constraint:
	 *     (
	 *         protocol=ComEnvRdvProtocolKind | 
	 *         (protocol=ComMultiRdvProtocolKind cast=ComCastKing?) | 
	 *         (protocol=BufferProtocolKind (inner_buffer=BufferContainerType | buffer=ComBuffer | inner_buffer=BufferContainerType | buffer=ComBuffer)?) | 
	 *         inner_buffer=BufferContainerType | 
	 *         buffer=ComBuffer | 
	 *         cast=ComCastKing
	 *     )
	 */
	protected void sequence_ComProtocol(ISerializationContext context, ComProtocol semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComRouteProtocol returns ComProtocol
	 *
	 * Constraint:
	 *     (
	 *         protocol=ComProtocolKind | 
	 *         (protocol=BufferProtocolKind (inner_buffer=BufferContainerType | buffer=ComBuffer | inner_buffer=BufferContainerType | buffer=ComBuffer)?) | 
	 *         inner_buffer=BufferContainerType | 
	 *         buffer=ComBuffer
	 *     )
	 */
	protected void sequence_ComRouteProtocol(ISerializationContext context, ComProtocol semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     CompositePart returns CompositePart
	 *
	 * Constraint:
	 *     (
	 *         ((routine+=Routine | procedure+=Procedure)+ | (routine+=Routine | procedure+=Procedure)+)? 
	 *         machine+=AnyMachineBlock? 
	 *         ((instance+=InstanceMachine | machine+=AnyMachineBlock | machine+=AnyMachineBlock | instance+=InstanceMachine)? machine+=AnyMachineBlock?)*
	 *     )
	 */
	protected void sequence_CompositePart(ISerializationContext context, CompositePart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     State returns State
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             composite?='state' 
	 *             orthogonal?='and'? 
	 *             name=ESIdentifier 
	 *             unrestrictedName=UnrestrictedName? 
	 *             (
	 *                 (region+=StatemachineRegion | region+=StatemachineNamedRegion | moe=moeCompositeStateRoutines | transition+=Transition)+ | 
	 *                 (region+=StatemachineRegionLite | moe=moeCompositeStateRoutines | transition+=Transition)+
	 *             )?
	 *         ) | 
	 *         (simple?='state' name=ESIdentifier unrestrictedName=UnrestrictedName? (transition+=Transition | moe=moeSimpleStateRoutines)*)
	 *     )
	 */
	protected void sequence_CompositeState_SimpleState(ISerializationContext context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     CompositeState returns State
	 *
	 * Constraint:
	 *     (
	 *         composite?='state' 
	 *         orthogonal?='and'? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         (
	 *             (region+=StatemachineRegion | region+=StatemachineNamedRegion | moe=moeCompositeStateRoutines | transition+=Transition)+ | 
	 *             (region+=StatemachineRegionLite | moe=moeCompositeStateRoutines | transition+=Transition)+
	 *         )?
	 *     )
	 */
	protected void sequence_CompositeState(ISerializationContext context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConditionalBlockStatement returns BlockStatement
	 *
	 * Constraint:
	 *     statement+=GuardTestExpression
	 */
	protected void sequence_ConditionalBlockStatement(ISerializationContext context, BlockStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ConditionalTestExpression
	 *     ConditionalTestExpression returns ConditionalTestExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns ConditionalTestExpression
	 *     LogicalOrExpression returns ConditionalTestExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns ConditionalTestExpression
	 *     LogicalAndExpression returns ConditionalTestExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns ConditionalTestExpression
	 *     BitwiseOrExpression returns ConditionalTestExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns ConditionalTestExpression
	 *     BitwiseXorExpression returns ConditionalTestExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns ConditionalTestExpression
	 *     BitwiseAndExpression returns ConditionalTestExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns ConditionalTestExpression
	 *     EqualityExpression returns ConditionalTestExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns ConditionalTestExpression
	 *     RelationalExpression returns ConditionalTestExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns ConditionalTestExpression
	 *     AdditiveExpression returns ConditionalTestExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns ConditionalTestExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns ConditionalTestExpression
	 *     MultiplicativeExpression returns ConditionalTestExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns ConditionalTestExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns ConditionalTestExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns ConditionalTestExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns ConditionalTestExpression
	 *     UnaryExpression returns ConditionalTestExpression
	 *     CollectionFunctionExpression returns ConditionalTestExpression
	 *     PrimaryExpression returns ConditionalTestExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns ConditionalTestExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns ConditionalTestExpression
	 *     BaseExpression returns ConditionalTestExpression
	 *
	 * Constraint:
	 *     (condition=ConditionalTestExpression_ConditionalTestExpression_1_0 operator='?' thenOperand=Expression elseSeparator=':' elseOperand=Expression)
	 */
	protected void sequence_ConditionalTestExpression(ISerializationContext context, ConditionalTestExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__CONDITION));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConditionalTestExpressionAccess().getConditionalTestExpressionConditionAction_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getConditionalTestExpressionAccess().getOperatorQuestionMarkKeyword_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getConditionalTestExpressionAccess().getThenOperandExpressionParserRuleCall_1_2_0(), semanticObject.getThenOperand());
		feeder.accept(grammarAccess.getConditionalTestExpressionAccess().getElseSeparatorColonKeyword_1_3_0(), semanticObject.getElseSeparator());
		feeder.accept(grammarAccess.getConditionalTestExpressionAccess().getElseOperandExpressionParserRuleCall_1_4_0(), semanticObject.getElseOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConnectorEnd returns ConnectorEnd
	 *
	 * Constraint:
	 *     (direction=ChannelDirection protocol=ComPointProtocol? (points+=ComPoint | (points+=ComPoint points+=ComPoint*) | points+=ComPoint+))
	 */
	protected void sequence_ConnectorEnd(ISerializationContext context, ConnectorEnd semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Connector returns Connector
	 *
	 * Constraint:
	 *     (protocol=ComProtocol name=ESIdentifier? unrestrictedName=UnrestrictedName? connectorEnd+=ConnectorEnd+)
	 */
	protected void sequence_Connector(ISerializationContext context, Connector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns DataTypeReference
	 *     DataType returns DataTypeReference
	 *
	 * Constraint:
	 *     (
	 *         (support=DataTypeReference_DataTypeReference_0_1_0 multiplicity=DataTypeMultiplicity) | 
	 *         (typeref=[DataType|ESUfid] multiplicity=DataTypeMultiplicity?)
	 *     )
	 */
	protected void sequence_DataTypeReference(ISerializationContext context, DataTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns DoWhileStatement
	 *     TransitionEffect.BlockStatement_1_0 returns DoWhileStatement
	 *     TransitionEffectStatement returns DoWhileStatement
	 *     Statement returns DoWhileStatement
	 *     DoWhileStatement returns DoWhileStatement
	 *
	 * Constraint:
	 *     (bodyBlock=BlockStatement condition=Expression)
	 */
	protected void sequence_DoWhileStatement(ISerializationContext context, DoWhileStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK));
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__CONDITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDoWhileStatementAccess().getBodyBlockBlockStatementParserRuleCall_1_0(), semanticObject.getBodyBlock());
		feeder.accept(grammarAccess.getDoWhileStatementAccess().getConditionExpressionParserRuleCall_3_0(), semanticObject.getCondition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DotQualifiedName returns QualifiedName
	 *
	 * Constraint:
	 *     (nameBinding+=NameBinding nameBinding+=NameBinding+)
	 */
	protected void sequence_DotQualifiedName_UnqualifiedName(ISerializationContext context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DynamicInstanceSpecification returns InstanceMachine
	 *
	 * Constraint:
	 *     (model=[Machine|ESIdentifier] (slot+=SlotParameter slot+=SlotParameter*)? slot+=SlotProperty*)
	 */
	protected void sequence_DynamicInstanceSpecification(ISerializationContext context, InstanceMachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ElseIfStatement returns ConditionalBlockStatement
	 *
	 * Constraint:
	 *     (condition=Expression bodyBlock=BlockStatement)
	 */
	protected void sequence_ElseIfStatement(ISerializationContext context, ConditionalBlockStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__CONDITION));
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getElseIfStatementAccess().getConditionExpressionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getElseIfStatementAccess().getBodyBlockBlockStatementParserRuleCall_2_0(), semanticObject.getBodyBlock());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Pseudostate returns Pseudostate
	 *
	 * Constraint:
	 *     (
	 *         (kind=PseudostateKind name=ESIdentifier unrestrictedName=UnrestrictedName? (transition+=Transition | moe=moePseudotateRoutines)*) | 
	 *         (
	 *             ((kind=PseudostateInitialKind (name=ESIdentifier | name='#initial' | name='#init')) | name='#initial' | name='#init') 
	 *             unrestrictedName=UnrestrictedName? 
	 *             transition+=Transition*
	 *         ) | 
	 *         (kind=EndingPseudostateKind name=ESIdentifier unrestrictedName=UnrestrictedName? moe=moeFinalStateRoutines?)
	 *     )
	 */
	protected void sequence_EndingPseudostate_OtherPseudostate_PseudostateInitial(ISerializationContext context, Pseudostate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EndingPseudostate returns Pseudostate
	 *
	 * Constraint:
	 *     (kind=EndingPseudostateKind name=ESIdentifier unrestrictedName=UnrestrictedName? moe=moeFinalStateRoutines?)
	 */
	protected void sequence_EndingPseudostate(ISerializationContext context, Pseudostate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EnumerationLiteral returns EnumerationLiteral
	 *
	 * Constraint:
	 *     (name=ESIdentifier unrestrictedName=UnrestrictedName? value=LiteralTerminalExpression?)
	 */
	protected void sequence_EnumerationLiteral(ISerializationContext context, EnumerationLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EnumerationTypeDefinitionImpl returns EnumerationType
	 *
	 * Constraint:
	 *     (
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         typedef?='enum' 
	 *         superType=[EnumerationType|ESUfid]? 
	 *         literal+=EnumerationLiteral 
	 *         literal+=EnumerationLiteral*
	 *     )
	 */
	protected void sequence_EnumerationTypeDefinitionImpl(ISerializationContext context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeDefinition returns EnumerationType
	 *     EnumerationTypeDefinition returns EnumerationType
	 *
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind? 
	 *         typedef?='type' 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         superType=[EnumerationType|ESUfid]? 
	 *         literal+=EnumerationLiteral 
	 *         literal+=EnumerationLiteral*
	 *     )
	 */
	protected void sequence_EnumerationTypeDefinition(ISerializationContext context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataType returns EnumerationType
	 *     StructuredDataType returns EnumerationType
	 *     EnumerationType returns EnumerationType
	 *
	 * Constraint:
	 *     (superType=[EnumerationType|ESUfid]? literal+=EnumerationLiteral literal+=EnumerationLiteral*)
	 */
	protected void sequence_EnumerationType(ISerializationContext context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns EqualityBinaryExpression
	 *     ConditionalTestExpression returns EqualityBinaryExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns EqualityBinaryExpression
	 *     LogicalOrExpression returns EqualityBinaryExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns EqualityBinaryExpression
	 *     LogicalAndExpression returns EqualityBinaryExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns EqualityBinaryExpression
	 *     BitwiseOrExpression returns EqualityBinaryExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns EqualityBinaryExpression
	 *     BitwiseXorExpression returns EqualityBinaryExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns EqualityBinaryExpression
	 *     BitwiseAndExpression returns EqualityBinaryExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns EqualityBinaryExpression
	 *     EqualityExpression returns EqualityBinaryExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns EqualityBinaryExpression
	 *     RelationalExpression returns EqualityBinaryExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns EqualityBinaryExpression
	 *     AdditiveExpression returns EqualityBinaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns EqualityBinaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns EqualityBinaryExpression
	 *     MultiplicativeExpression returns EqualityBinaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns EqualityBinaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns EqualityBinaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns EqualityBinaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns EqualityBinaryExpression
	 *     UnaryExpression returns EqualityBinaryExpression
	 *     CollectionFunctionExpression returns EqualityBinaryExpression
	 *     PrimaryExpression returns EqualityBinaryExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns EqualityBinaryExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns EqualityBinaryExpression
	 *     BaseExpression returns EqualityBinaryExpression
	 *
	 * Constraint:
	 *     (leftOperand=EqualityExpression_EqualityBinaryExpression_1_0 operator=EqualityOperator rightOperand=RelationalExpression)
	 */
	protected void sequence_EqualityExpression(ISerializationContext context, EqualityBinaryExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__LEFT_OPERAND));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__RIGHT_OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEqualityExpressionAccess().getEqualityBinaryExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getEqualityExpressionAccess().getOperatorEqualityOperatorParserRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getEqualityExpressionAccess().getRightOperandRelationalExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionGuard returns EventGuardStatement
	 *     Statement returns EventGuardStatement
	 *     EventGuardStatement returns EventGuardStatement
	 *
	 * Constraint:
	 *     condition=Expression
	 */
	protected void sequence_EventGuardStatement(ISerializationContext context, EventGuardStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEventGuardStatementAccess().getConditionExpressionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns ExpressionStatement
	 *     TransitionEffect.BlockStatement_1_0 returns ExpressionStatement
	 *     TransitionEffectStatement returns ExpressionStatement
	 *     Statement returns ExpressionStatement
	 *     ExpressionStatement returns ExpressionStatement
	 *
	 * Constraint:
	 *     (
	 *         expression=AssignmentExpression | 
	 *         expression=NewfreshExpression | 
	 *         expression=IncrementOrDecrementPrefixExpression | 
	 *         expression=IncrementOrDecrementPostfixExpression
	 *     )
	 */
	protected void sequence_ExpressionStatement(ISerializationContext context, ExpressionStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     State returns FinalState
	 *     FinalState returns FinalState
	 *
	 * Constraint:
	 *     (((simple?='state' name=ESIdentifier) | simple?='#final') unrestrictedName=UnrestrictedName? moe=moeFinalStateRoutines?)
	 */
	protected void sequence_FinalState(ISerializationContext context, FinalState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns ForEachStatement
	 *     TransitionEffect.BlockStatement_1_0 returns ForEachStatement
	 *     TransitionEffectStatement returns ForEachStatement
	 *     Statement returns ForEachStatement
	 *     ForEachStatement returns ForEachStatement
	 *
	 * Constraint:
	 *     (
	 *         (iterator=LeftHandSideExpression enumeration=Expression bodyBlock=BlockStatement) | 
	 *         (iterator=LeftHandSideExpression enumeration=Expression bodyBlock=BlockStatement)
	 *     )
	 */
	protected void sequence_ForEachStatement(ISerializationContext context, ForEachStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns ForStatement
	 *     TransitionEffect.BlockStatement_1_0 returns ForStatement
	 *     TransitionEffectStatement returns ForStatement
	 *     Statement returns ForStatement
	 *     ForStatement returns ForStatement
	 *
	 * Constraint:
	 *     (
	 *         (init=ForAssignmentExpression? condition=Expression iterate=ForAssignmentExpression? bodyBlock=BlockStatement) | 
	 *         (init=ForAssignmentExpression? condition=Expression iterate=ForAssignmentExpression? bodyBlock=BlockStatement)
	 *     )
	 */
	protected void sequence_ForStatement(ISerializationContext context, ForStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FormalParameterSet returns ParameterSet
	 *
	 * Constraint:
	 *     (parameter+=FormalParameter parameter+=FormalParameter*)
	 */
	protected void sequence_FormalParameterSet(ISerializationContext context, ParameterSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FormalParameter returns Parameter
	 *
	 * Constraint:
	 *     (direction=ParameterDirectionKind? modifier=Modifier? type=DataType name=ESIdentifier? defaultValue=Expression?)
	 */
	protected void sequence_FormalParameter(ISerializationContext context, org.eclipse.efm.ecore.formalml.infrastructure.Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionImpl returns Function
	 *     FunctionPublic returns Function
	 *     FunctionProtected returns Function
	 *     FunctionPrivate returns Function
	 *
	 * Constraint:
	 *     (
	 *         modifier=Modifier? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         parameterSet=FormalParameterSet? 
	 *         (resultSet=FormalParameterSet | resultSet=FormalParameterSet)
	 *     )
	 */
	protected void sequence_FunctionImpl(ISerializationContext context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Function returns Function
	 *
	 * Constraint:
	 *     (
	 *         (visibility=VisibilityKind | modifier=Modifier)* 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         parameterSet=FormalParameterSet? 
	 *         (resultSet=FormalParameterSet | resultSet=FormalParameterSet)
	 *     )
	 */
	protected void sequence_Function(ISerializationContext context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionalParameterSet returns ParameterSet
	 *
	 * Constraint:
	 *     (parameter+=FunctionalParameter parameter+=FunctionalParameter*)
	 */
	protected void sequence_FunctionalParameterSet(ISerializationContext context, ParameterSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionalParameter returns Parameter
	 *
	 * Constraint:
	 *     (direction=ParameterDirectionKind? type=DataType name=ESIdentifier defaultValue=Expression?)
	 */
	protected void sequence_FunctionalParameter(ISerializationContext context, org.eclipse.efm.ecore.formalml.infrastructure.Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns GuardStatement
	 *     GuardStatement returns GuardStatement
	 *
	 * Constraint:
	 *     condition=Expression
	 */
	protected void sequence_GuardStatement(ISerializationContext context, GuardStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGuardStatementAccess().getConditionExpressionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionGuard returns GuardStatement
	 *
	 * Constraint:
	 *     (condition=TransitionGuardExpression | condition=Expression | condition=Expression | condition=Expression)
	 */
	protected void sequence_GuardStatement_TransitionGuard(ISerializationContext context, GuardStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GuardTestExpression returns GuardStatement
	 *
	 * Constraint:
	 *     condition=Expression
	 */
	protected void sequence_GuardTestExpression(ISerializationContext context, GuardStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGuardTestExpressionAccess().getConditionExpressionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns IfStatement
	 *     TransitionEffect.BlockStatement_1_0 returns IfStatement
	 *     TransitionEffectStatement returns IfStatement
	 *     Statement returns IfStatement
	 *     IfStatement returns IfStatement
	 *
	 * Constraint:
	 *     (condition=Expression bodyBlock=BlockStatement elseifStatement+=ElseIfStatement* elseBlock=BlockStatement?)
	 */
	protected void sequence_IfStatement(ISerializationContext context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ForAssignmentExpression returns IncrementOrDecrementPostfixExpression
	 *     Expression returns IncrementOrDecrementPostfixExpression
	 *     ConditionalTestExpression returns IncrementOrDecrementPostfixExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns IncrementOrDecrementPostfixExpression
	 *     LogicalOrExpression returns IncrementOrDecrementPostfixExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns IncrementOrDecrementPostfixExpression
	 *     LogicalAndExpression returns IncrementOrDecrementPostfixExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns IncrementOrDecrementPostfixExpression
	 *     BitwiseOrExpression returns IncrementOrDecrementPostfixExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns IncrementOrDecrementPostfixExpression
	 *     BitwiseXorExpression returns IncrementOrDecrementPostfixExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns IncrementOrDecrementPostfixExpression
	 *     BitwiseAndExpression returns IncrementOrDecrementPostfixExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns IncrementOrDecrementPostfixExpression
	 *     EqualityExpression returns IncrementOrDecrementPostfixExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns IncrementOrDecrementPostfixExpression
	 *     RelationalExpression returns IncrementOrDecrementPostfixExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns IncrementOrDecrementPostfixExpression
	 *     AdditiveExpression returns IncrementOrDecrementPostfixExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns IncrementOrDecrementPostfixExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns IncrementOrDecrementPostfixExpression
	 *     MultiplicativeExpression returns IncrementOrDecrementPostfixExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns IncrementOrDecrementPostfixExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns IncrementOrDecrementPostfixExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns IncrementOrDecrementPostfixExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns IncrementOrDecrementPostfixExpression
	 *     UnaryExpression returns IncrementOrDecrementPostfixExpression
	 *     PostfixUnaryExpression returns IncrementOrDecrementPostfixExpression
	 *     IncrementOrDecrementPostfixExpression returns IncrementOrDecrementPostfixExpression
	 *     CollectionFunctionExpression returns IncrementOrDecrementPostfixExpression
	 *     PrimaryExpression returns IncrementOrDecrementPostfixExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns IncrementOrDecrementPostfixExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns IncrementOrDecrementPostfixExpression
	 *     BaseExpression returns IncrementOrDecrementPostfixExpression
	 *
	 * Constraint:
	 *     (leftHandSide=LeftHandSideExpression operator=AffixOperator)
	 */
	protected void sequence_IncrementOrDecrementPostfixExpression(ISerializationContext context, IncrementOrDecrementPostfixExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIncrementOrDecrementPostfixExpressionAccess().getLeftHandSideLeftHandSideExpressionParserRuleCall_0_0(), semanticObject.getLeftHandSide());
		feeder.accept(grammarAccess.getIncrementOrDecrementPostfixExpressionAccess().getOperatorAffixOperatorParserRuleCall_1_0(), semanticObject.getOperator());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ForAssignmentExpression returns IncrementOrDecrementPrefixExpression
	 *     Expression returns IncrementOrDecrementPrefixExpression
	 *     ConditionalTestExpression returns IncrementOrDecrementPrefixExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns IncrementOrDecrementPrefixExpression
	 *     LogicalOrExpression returns IncrementOrDecrementPrefixExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns IncrementOrDecrementPrefixExpression
	 *     LogicalAndExpression returns IncrementOrDecrementPrefixExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns IncrementOrDecrementPrefixExpression
	 *     BitwiseOrExpression returns IncrementOrDecrementPrefixExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns IncrementOrDecrementPrefixExpression
	 *     BitwiseXorExpression returns IncrementOrDecrementPrefixExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns IncrementOrDecrementPrefixExpression
	 *     BitwiseAndExpression returns IncrementOrDecrementPrefixExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns IncrementOrDecrementPrefixExpression
	 *     EqualityExpression returns IncrementOrDecrementPrefixExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns IncrementOrDecrementPrefixExpression
	 *     RelationalExpression returns IncrementOrDecrementPrefixExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns IncrementOrDecrementPrefixExpression
	 *     AdditiveExpression returns IncrementOrDecrementPrefixExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns IncrementOrDecrementPrefixExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns IncrementOrDecrementPrefixExpression
	 *     MultiplicativeExpression returns IncrementOrDecrementPrefixExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns IncrementOrDecrementPrefixExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns IncrementOrDecrementPrefixExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns IncrementOrDecrementPrefixExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns IncrementOrDecrementPrefixExpression
	 *     UnaryExpression returns IncrementOrDecrementPrefixExpression
	 *     PrefixUnaryExpression returns IncrementOrDecrementPrefixExpression
	 *     IncrementOrDecrementPrefixExpression returns IncrementOrDecrementPrefixExpression
	 *     CollectionFunctionExpression returns IncrementOrDecrementPrefixExpression
	 *     PrimaryExpression returns IncrementOrDecrementPrefixExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns IncrementOrDecrementPrefixExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns IncrementOrDecrementPrefixExpression
	 *     BaseExpression returns IncrementOrDecrementPrefixExpression
	 *
	 * Constraint:
	 *     (operator=AffixOperator leftHandSide=LeftHandSideExpression)
	 */
	protected void sequence_IncrementOrDecrementPrefixExpression(ISerializationContext context, IncrementOrDecrementPrefixExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIncrementOrDecrementPrefixExpressionAccess().getOperatorAffixOperatorParserRuleCall_0_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getIncrementOrDecrementPrefixExpressionAccess().getLeftHandSideLeftHandSideExpressionParserRuleCall_1_0(), semanticObject.getLeftHandSide());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionTrigger returns InputComStatement
	 *     Statement returns InputComStatement
	 *     InputComStatement returns InputComStatement
	 *
	 * Constraint:
	 *     (port=LitteralComElement (leftValue+=Expression leftValue+=Expression*)? (target=LiteralPureReferenceExpression | route=[Channel|ESUfid])*)
	 */
	protected void sequence_InputComStatement(ISerializationContext context, InputComStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     InstanceMachine returns InstanceMachine
	 *
	 * Constraint:
	 *     (model=[Machine|ESUfid] name=ESIdentifier unrestrictedName=UnrestrictedName? (slot+=SlotParameter slot+=SlotParameter*)? slot+=SlotProperty*)
	 */
	protected void sequence_InstanceMachine(ISerializationContext context, InstanceMachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns InstantiationExpression
	 *     ConditionalTestExpression returns InstantiationExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns InstantiationExpression
	 *     LogicalOrExpression returns InstantiationExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns InstantiationExpression
	 *     LogicalAndExpression returns InstantiationExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns InstantiationExpression
	 *     BitwiseOrExpression returns InstantiationExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns InstantiationExpression
	 *     BitwiseXorExpression returns InstantiationExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns InstantiationExpression
	 *     BitwiseAndExpression returns InstantiationExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns InstantiationExpression
	 *     EqualityExpression returns InstantiationExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns InstantiationExpression
	 *     RelationalExpression returns InstantiationExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns InstantiationExpression
	 *     AdditiveExpression returns InstantiationExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns InstantiationExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns InstantiationExpression
	 *     MultiplicativeExpression returns InstantiationExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns InstantiationExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns InstantiationExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns InstantiationExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns InstantiationExpression
	 *     UnaryExpression returns InstantiationExpression
	 *     CollectionFunctionExpression returns InstantiationExpression
	 *     PrimaryExpression returns InstantiationExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns InstantiationExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns InstantiationExpression
	 *     BaseExpression returns InstantiationExpression
	 *     InstantiationExpression returns InstantiationExpression
	 *
	 * Constraint:
	 *     instance=DynamicInstanceSpecification
	 */
	protected void sequence_InstantiationExpression(ISerializationContext context, InstantiationExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.INSTANTIATION_EXPRESSION__INSTANCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.INSTANTIATION_EXPRESSION__INSTANCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getInstantiationExpressionAccess().getInstanceDynamicInstanceSpecificationParserRuleCall_1_0(), semanticObject.getInstance());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns InterruptStatement
	 *     TransitionEffect.BlockStatement_1_0 returns InterruptStatement
	 *     TransitionEffectStatement returns InterruptStatement
	 *     Statement returns InterruptStatement
	 *     InterruptStatement returns InterruptStatement
	 *
	 * Constraint:
	 *     (kind=InterruptStatementKind (expr+=Expression | (expr+=Expression expr+=Expression*))?)
	 */
	protected void sequence_InterruptStatement(ISerializationContext context, InterruptStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     IntervalTypeDefinitionImpl returns IntervalType
	 *
	 * Constraint:
	 *     (
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         support=PrimitiveNumberType 
	 *         lopen?=']'? 
	 *         infimum=Expression 
	 *         supremum=Expression 
	 *         ropen?='['?
	 *     )
	 */
	protected void sequence_IntervalTypeDefinitionImpl(ISerializationContext context, IntervalType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeDefinition returns IntervalType
	 *     IntervalTypeDefinition returns IntervalType
	 *
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         support=PrimitiveNumberType 
	 *         lopen?=']'? 
	 *         infimum=Expression 
	 *         supremum=Expression 
	 *         ropen?='['?
	 *     )
	 */
	protected void sequence_IntervalTypeDefinition(ISerializationContext context, IntervalType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns IntervalType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns IntervalType
	 *     DataType returns IntervalType
	 *     SimpleDataType returns IntervalType
	 *     IntervalType returns IntervalType
	 *     AnyDataTypeReference returns IntervalType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns IntervalType
	 *
	 * Constraint:
	 *     (
	 *         name='interval' 
	 *         support=PrimitiveNumberType 
	 *         lopen?=']'? 
	 *         infimum=Expression 
	 *         supremum=Expression 
	 *         ropen?='['?
	 *     )
	 */
	protected void sequence_IntervalType(ISerializationContext context, IntervalType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns InvokeExpression
	 *     ConditionalTestExpression returns InvokeExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns InvokeExpression
	 *     LogicalOrExpression returns InvokeExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns InvokeExpression
	 *     LogicalAndExpression returns InvokeExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns InvokeExpression
	 *     BitwiseOrExpression returns InvokeExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns InvokeExpression
	 *     BitwiseXorExpression returns InvokeExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns InvokeExpression
	 *     BitwiseAndExpression returns InvokeExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns InvokeExpression
	 *     EqualityExpression returns InvokeExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns InvokeExpression
	 *     RelationalExpression returns InvokeExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns InvokeExpression
	 *     AdditiveExpression returns InvokeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns InvokeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns InvokeExpression
	 *     MultiplicativeExpression returns InvokeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns InvokeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns InvokeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns InvokeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns InvokeExpression
	 *     UnaryExpression returns InvokeExpression
	 *     CollectionFunctionExpression returns InvokeExpression
	 *     PrimaryExpression returns InvokeExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns InvokeExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns InvokeExpression
	 *     BaseExpression returns InvokeExpression
	 *     InvokeExpressionDeprecated returns InvokeExpression
	 *
	 * Constraint:
	 *     (args+=Expression invokable=LiteralReferenceElement args+=Expression*)
	 */
	protected void sequence_InvokeExpressionDeprecated(ISerializationContext context, InvokeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     InvokeExpression returns InvokeExpression
	 *
	 * Constraint:
	 *     invokable=ValueSelectionExpression
	 */
	protected void sequence_InvokeExpression(ISerializationContext context, InvokeExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.INVOKE_EXPRESSION__INVOKABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.INVOKE_EXPRESSION__INVOKABLE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getInvokeExpressionAccess().getInvokableValueSelectionExpressionParserRuleCall_1_0(), semanticObject.getInvokable());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns InvokeStatement
	 *     TransitionEffect.BlockStatement_1_0 returns InvokeStatement
	 *     TransitionEffectStatement returns InvokeStatement
	 *     Statement returns InvokeStatement
	 *     InvokeStatement returns InvokeStatement
	 *
	 * Constraint:
	 *     (
	 *         expression=InvokeExpressionDeprecated | 
	 *         (
	 *             invokable=[NamedElement|ESUfid] 
	 *             execRoutine?='(' 
	 *             args=MixTupleExpressionList? 
	 *             ((rets+=[Variable|ID] rets+=[Variable|ID]*) | (rets+=[Variable|ID] rets+=[Variable|ID]*))?
	 *         ) | 
	 *         (
	 *             execRoutine?='exec' 
	 *             invokable=[NamedElement|ESUfid] 
	 *             args=MixTupleExpressionList? 
	 *             ((rets+=[Variable|ID] rets+=[Variable|ID]*) | (rets+=[Variable|ID] rets+=[Variable|ID]*))?
	 *         ) | 
	 *         (
	 *             callProcedure?='call' 
	 *             invokable=[NamedElement|ESUfid] 
	 *             args=MixTupleExpressionList? 
	 *             ((rets+=[Variable|ID] rets+=[Variable|ID]*) | (rets+=[Variable|ID] rets+=[Variable|ID]*))?
	 *         )
	 *     )
	 */
	protected void sequence_InvokeStatement(ISerializationContext context, InvokeStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LeftHandSideExpression returns LeftHandSideExpression
	 *
	 * Constraint:
	 *     (lvalue=ValueSelectionExpression | lvalue=ValueSelectionExpression)
	 */
	protected void sequence_LeftHandSideExpression(ISerializationContext context, LeftHandSideExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralAnyOrNoneValueExpression
	 *     ConditionalTestExpression returns LiteralAnyOrNoneValueExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralAnyOrNoneValueExpression
	 *     LogicalOrExpression returns LiteralAnyOrNoneValueExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralAnyOrNoneValueExpression
	 *     LogicalAndExpression returns LiteralAnyOrNoneValueExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralAnyOrNoneValueExpression
	 *     BitwiseOrExpression returns LiteralAnyOrNoneValueExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralAnyOrNoneValueExpression
	 *     BitwiseXorExpression returns LiteralAnyOrNoneValueExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralAnyOrNoneValueExpression
	 *     BitwiseAndExpression returns LiteralAnyOrNoneValueExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralAnyOrNoneValueExpression
	 *     EqualityExpression returns LiteralAnyOrNoneValueExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralAnyOrNoneValueExpression
	 *     RelationalExpression returns LiteralAnyOrNoneValueExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralAnyOrNoneValueExpression
	 *     AdditiveExpression returns LiteralAnyOrNoneValueExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralAnyOrNoneValueExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralAnyOrNoneValueExpression
	 *     MultiplicativeExpression returns LiteralAnyOrNoneValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralAnyOrNoneValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralAnyOrNoneValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralAnyOrNoneValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralAnyOrNoneValueExpression
	 *     UnaryExpression returns LiteralAnyOrNoneValueExpression
	 *     CollectionFunctionExpression returns LiteralAnyOrNoneValueExpression
	 *     PrimaryExpression returns LiteralAnyOrNoneValueExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralAnyOrNoneValueExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralAnyOrNoneValueExpression
	 *     BaseExpression returns LiteralAnyOrNoneValueExpression
	 *     LiteralExpression returns LiteralAnyOrNoneValueExpression
	 *     LiteralTerminalExpression returns LiteralAnyOrNoneValueExpression
	 *     LiteralAnyOrNoneValueExpression returns LiteralAnyOrNoneValueExpression
	 *
	 * Constraint:
	 *     type=AnyDataTypeReference?
	 */
	protected void sequence_LiteralAnyOrNoneValueExpression(ISerializationContext context, LiteralAnyOrNoneValueExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralAnyValueExpression
	 *     ConditionalTestExpression returns LiteralAnyValueExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralAnyValueExpression
	 *     LogicalOrExpression returns LiteralAnyValueExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralAnyValueExpression
	 *     LogicalAndExpression returns LiteralAnyValueExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralAnyValueExpression
	 *     BitwiseOrExpression returns LiteralAnyValueExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralAnyValueExpression
	 *     BitwiseXorExpression returns LiteralAnyValueExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralAnyValueExpression
	 *     BitwiseAndExpression returns LiteralAnyValueExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralAnyValueExpression
	 *     EqualityExpression returns LiteralAnyValueExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralAnyValueExpression
	 *     RelationalExpression returns LiteralAnyValueExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralAnyValueExpression
	 *     AdditiveExpression returns LiteralAnyValueExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralAnyValueExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralAnyValueExpression
	 *     MultiplicativeExpression returns LiteralAnyValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralAnyValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralAnyValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralAnyValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralAnyValueExpression
	 *     UnaryExpression returns LiteralAnyValueExpression
	 *     CollectionFunctionExpression returns LiteralAnyValueExpression
	 *     PrimaryExpression returns LiteralAnyValueExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralAnyValueExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralAnyValueExpression
	 *     BaseExpression returns LiteralAnyValueExpression
	 *     LiteralExpression returns LiteralAnyValueExpression
	 *     LiteralTerminalExpression returns LiteralAnyValueExpression
	 *     LiteralAnyValueExpression returns LiteralAnyValueExpression
	 *
	 * Constraint:
	 *     type=AnyDataTypeReference?
	 */
	protected void sequence_LiteralAnyValueExpression(ISerializationContext context, LiteralAnyValueExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralBooleanExpression
	 *     ConditionalTestExpression returns LiteralBooleanExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralBooleanExpression
	 *     LogicalOrExpression returns LiteralBooleanExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralBooleanExpression
	 *     LogicalAndExpression returns LiteralBooleanExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralBooleanExpression
	 *     BitwiseOrExpression returns LiteralBooleanExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralBooleanExpression
	 *     BitwiseXorExpression returns LiteralBooleanExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralBooleanExpression
	 *     BitwiseAndExpression returns LiteralBooleanExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralBooleanExpression
	 *     EqualityExpression returns LiteralBooleanExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralBooleanExpression
	 *     RelationalExpression returns LiteralBooleanExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralBooleanExpression
	 *     AdditiveExpression returns LiteralBooleanExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralBooleanExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralBooleanExpression
	 *     MultiplicativeExpression returns LiteralBooleanExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralBooleanExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralBooleanExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralBooleanExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralBooleanExpression
	 *     UnaryExpression returns LiteralBooleanExpression
	 *     CollectionFunctionExpression returns LiteralBooleanExpression
	 *     PrimaryExpression returns LiteralBooleanExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralBooleanExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralBooleanExpression
	 *     BaseExpression returns LiteralBooleanExpression
	 *     LiteralExpression returns LiteralBooleanExpression
	 *     LiteralTerminalExpression returns LiteralBooleanExpression
	 *     LiteralBooleanExpression returns LiteralBooleanExpression
	 *
	 * Constraint:
	 *     value=EBoolean
	 */
	protected void sequence_LiteralBooleanExpression(ISerializationContext context, LiteralBooleanExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_BOOLEAN_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_BOOLEAN_EXPRESSION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralBooleanExpressionAccess().getValueEBooleanParserRuleCall_1_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralCharacterExpression
	 *     ConditionalTestExpression returns LiteralCharacterExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralCharacterExpression
	 *     LogicalOrExpression returns LiteralCharacterExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralCharacterExpression
	 *     LogicalAndExpression returns LiteralCharacterExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralCharacterExpression
	 *     BitwiseOrExpression returns LiteralCharacterExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralCharacterExpression
	 *     BitwiseXorExpression returns LiteralCharacterExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralCharacterExpression
	 *     BitwiseAndExpression returns LiteralCharacterExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralCharacterExpression
	 *     EqualityExpression returns LiteralCharacterExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralCharacterExpression
	 *     RelationalExpression returns LiteralCharacterExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralCharacterExpression
	 *     AdditiveExpression returns LiteralCharacterExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralCharacterExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralCharacterExpression
	 *     MultiplicativeExpression returns LiteralCharacterExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralCharacterExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralCharacterExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralCharacterExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralCharacterExpression
	 *     UnaryExpression returns LiteralCharacterExpression
	 *     CollectionFunctionExpression returns LiteralCharacterExpression
	 *     PrimaryExpression returns LiteralCharacterExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralCharacterExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralCharacterExpression
	 *     BaseExpression returns LiteralCharacterExpression
	 *     LiteralExpression returns LiteralCharacterExpression
	 *     LiteralTerminalExpression returns LiteralCharacterExpression
	 *     LiteralCharacterExpression returns LiteralCharacterExpression
	 *
	 * Constraint:
	 *     value=ECharacter
	 */
	protected void sequence_LiteralCharacterExpression(ISerializationContext context, LiteralCharacterExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_CHARACTER_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_CHARACTER_EXPRESSION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralCharacterExpressionAccess().getValueECharacterParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralCollectionExpression
	 *     ConditionalTestExpression returns LiteralCollectionExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralCollectionExpression
	 *     LogicalOrExpression returns LiteralCollectionExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralCollectionExpression
	 *     LogicalAndExpression returns LiteralCollectionExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralCollectionExpression
	 *     BitwiseOrExpression returns LiteralCollectionExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralCollectionExpression
	 *     BitwiseXorExpression returns LiteralCollectionExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralCollectionExpression
	 *     BitwiseAndExpression returns LiteralCollectionExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralCollectionExpression
	 *     EqualityExpression returns LiteralCollectionExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralCollectionExpression
	 *     RelationalExpression returns LiteralCollectionExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralCollectionExpression
	 *     AdditiveExpression returns LiteralCollectionExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralCollectionExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralCollectionExpression
	 *     MultiplicativeExpression returns LiteralCollectionExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralCollectionExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralCollectionExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralCollectionExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralCollectionExpression
	 *     UnaryExpression returns LiteralCollectionExpression
	 *     CollectionFunctionExpression returns LiteralCollectionExpression
	 *     PrimaryExpression returns LiteralCollectionExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralCollectionExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralCollectionExpression
	 *     BaseExpression returns LiteralCollectionExpression
	 *     LiteralExpression returns LiteralCollectionExpression
	 *     LiteralReferenceableExpression returns LiteralCollectionExpression
	 *     LiteralCollectionExpression returns LiteralCollectionExpression
	 *
	 * Constraint:
	 *     (datatype=DataType? ((value+=Expression | value+=NamedExpression) value+=NamedExpression? (value+=Expression? value+=NamedExpression?)*)?)
	 */
	protected void sequence_LiteralCollectionExpression(ISerializationContext context, LiteralCollectionExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralPureReferenceMachine returns LiteralEnvExpression
	 *     Expression returns LiteralEnvExpression
	 *     ConditionalTestExpression returns LiteralEnvExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralEnvExpression
	 *     LogicalOrExpression returns LiteralEnvExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralEnvExpression
	 *     LogicalAndExpression returns LiteralEnvExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralEnvExpression
	 *     BitwiseOrExpression returns LiteralEnvExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralEnvExpression
	 *     BitwiseXorExpression returns LiteralEnvExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralEnvExpression
	 *     BitwiseAndExpression returns LiteralEnvExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralEnvExpression
	 *     EqualityExpression returns LiteralEnvExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralEnvExpression
	 *     RelationalExpression returns LiteralEnvExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralEnvExpression
	 *     AdditiveExpression returns LiteralEnvExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralEnvExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralEnvExpression
	 *     MultiplicativeExpression returns LiteralEnvExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralEnvExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralEnvExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralEnvExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralEnvExpression
	 *     UnaryExpression returns LiteralEnvExpression
	 *     CollectionFunctionExpression returns LiteralEnvExpression
	 *     PrimaryExpression returns LiteralEnvExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralEnvExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralEnvExpression
	 *     BaseExpression returns LiteralEnvExpression
	 *     LiteralExpression returns LiteralEnvExpression
	 *     LiteralReferenceableExpression returns LiteralEnvExpression
	 *     LiteralReferenceExpression returns LiteralEnvExpression
	 *     LiteralReferenceMachineContext returns LiteralEnvExpression
	 *     LiteralEnvExpression returns LiteralEnvExpression
	 *     LiteralPureReferenceExpression returns LiteralEnvExpression
	 *     ValueSelectionExpression returns LiteralEnvExpression
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralEnvExpression
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralEnvExpression
	 *     ValuePureNamedMachineExpression returns LiteralEnvExpression
	 *     ValuePureNamedMachineExpression.ValueElementSpecification_1_0 returns LiteralEnvExpression
	 *
	 * Constraint:
	 *     {LiteralEnvExpression}
	 */
	protected void sequence_LiteralEnvExpression(ISerializationContext context, LiteralEnvExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralFloatExpression
	 *     ConditionalTestExpression returns LiteralFloatExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralFloatExpression
	 *     LogicalOrExpression returns LiteralFloatExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralFloatExpression
	 *     LogicalAndExpression returns LiteralFloatExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralFloatExpression
	 *     BitwiseOrExpression returns LiteralFloatExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralFloatExpression
	 *     BitwiseXorExpression returns LiteralFloatExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralFloatExpression
	 *     BitwiseAndExpression returns LiteralFloatExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralFloatExpression
	 *     EqualityExpression returns LiteralFloatExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralFloatExpression
	 *     RelationalExpression returns LiteralFloatExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralFloatExpression
	 *     AdditiveExpression returns LiteralFloatExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralFloatExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralFloatExpression
	 *     MultiplicativeExpression returns LiteralFloatExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralFloatExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralFloatExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralFloatExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralFloatExpression
	 *     UnaryExpression returns LiteralFloatExpression
	 *     CollectionFunctionExpression returns LiteralFloatExpression
	 *     PrimaryExpression returns LiteralFloatExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralFloatExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralFloatExpression
	 *     BaseExpression returns LiteralFloatExpression
	 *     LiteralExpression returns LiteralFloatExpression
	 *     LiteralTerminalExpression returns LiteralFloatExpression
	 *     LiteralFloatExpression returns LiteralFloatExpression
	 *
	 * Constraint:
	 *     value=EDouble
	 */
	protected void sequence_LiteralFloatExpression(ISerializationContext context, LiteralFloatExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_FLOAT_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_FLOAT_EXPRESSION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralFloatExpressionAccess().getValueEDoubleParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeMultiplicity returns LiteralIntegerExpression
	 *     Expression returns LiteralIntegerExpression
	 *     ConditionalTestExpression returns LiteralIntegerExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralIntegerExpression
	 *     LogicalOrExpression returns LiteralIntegerExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralIntegerExpression
	 *     LogicalAndExpression returns LiteralIntegerExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralIntegerExpression
	 *     BitwiseOrExpression returns LiteralIntegerExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralIntegerExpression
	 *     BitwiseXorExpression returns LiteralIntegerExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralIntegerExpression
	 *     BitwiseAndExpression returns LiteralIntegerExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralIntegerExpression
	 *     EqualityExpression returns LiteralIntegerExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralIntegerExpression
	 *     RelationalExpression returns LiteralIntegerExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralIntegerExpression
	 *     AdditiveExpression returns LiteralIntegerExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralIntegerExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralIntegerExpression
	 *     MultiplicativeExpression returns LiteralIntegerExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralIntegerExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralIntegerExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralIntegerExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralIntegerExpression
	 *     UnaryExpression returns LiteralIntegerExpression
	 *     CollectionFunctionExpression returns LiteralIntegerExpression
	 *     PrimaryExpression returns LiteralIntegerExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralIntegerExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralIntegerExpression
	 *     BaseExpression returns LiteralIntegerExpression
	 *     LiteralExpression returns LiteralIntegerExpression
	 *     LiteralTerminalExpression returns LiteralIntegerExpression
	 *     LiteralIntegerExpression returns LiteralIntegerExpression
	 *
	 * Constraint:
	 *     value=EInteger
	 */
	protected void sequence_LiteralIntegerExpression(ISerializationContext context, LiteralIntegerExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_INTEGER_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_INTEGER_EXPRESSION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralIntegerExpressionAccess().getValueEIntegerParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralNoneValueExpression
	 *     ConditionalTestExpression returns LiteralNoneValueExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralNoneValueExpression
	 *     LogicalOrExpression returns LiteralNoneValueExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralNoneValueExpression
	 *     LogicalAndExpression returns LiteralNoneValueExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralNoneValueExpression
	 *     BitwiseOrExpression returns LiteralNoneValueExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralNoneValueExpression
	 *     BitwiseXorExpression returns LiteralNoneValueExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralNoneValueExpression
	 *     BitwiseAndExpression returns LiteralNoneValueExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralNoneValueExpression
	 *     EqualityExpression returns LiteralNoneValueExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralNoneValueExpression
	 *     RelationalExpression returns LiteralNoneValueExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralNoneValueExpression
	 *     AdditiveExpression returns LiteralNoneValueExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralNoneValueExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralNoneValueExpression
	 *     MultiplicativeExpression returns LiteralNoneValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralNoneValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralNoneValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralNoneValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralNoneValueExpression
	 *     UnaryExpression returns LiteralNoneValueExpression
	 *     CollectionFunctionExpression returns LiteralNoneValueExpression
	 *     PrimaryExpression returns LiteralNoneValueExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralNoneValueExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralNoneValueExpression
	 *     BaseExpression returns LiteralNoneValueExpression
	 *     LiteralExpression returns LiteralNoneValueExpression
	 *     LiteralTerminalExpression returns LiteralNoneValueExpression
	 *     LiteralNoneValueExpression returns LiteralNoneValueExpression
	 *
	 * Constraint:
	 *     type=AnyDataTypeReference?
	 */
	protected void sequence_LiteralNoneValueExpression(ISerializationContext context, LiteralNoneValueExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralNullExpression
	 *     ConditionalTestExpression returns LiteralNullExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralNullExpression
	 *     LogicalOrExpression returns LiteralNullExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralNullExpression
	 *     LogicalAndExpression returns LiteralNullExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralNullExpression
	 *     BitwiseOrExpression returns LiteralNullExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralNullExpression
	 *     BitwiseXorExpression returns LiteralNullExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralNullExpression
	 *     BitwiseAndExpression returns LiteralNullExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralNullExpression
	 *     EqualityExpression returns LiteralNullExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralNullExpression
	 *     RelationalExpression returns LiteralNullExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralNullExpression
	 *     AdditiveExpression returns LiteralNullExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralNullExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralNullExpression
	 *     MultiplicativeExpression returns LiteralNullExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralNullExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralNullExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralNullExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralNullExpression
	 *     UnaryExpression returns LiteralNullExpression
	 *     CollectionFunctionExpression returns LiteralNullExpression
	 *     PrimaryExpression returns LiteralNullExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralNullExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralNullExpression
	 *     BaseExpression returns LiteralNullExpression
	 *     LiteralExpression returns LiteralNullExpression
	 *     LiteralTerminalExpression returns LiteralNullExpression
	 *     LiteralNullExpression returns LiteralNullExpression
	 *
	 * Constraint:
	 *     type=NullPrimitiveInstanceType?
	 */
	protected void sequence_LiteralNullExpression(ISerializationContext context, LiteralNullExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralOptionalValueExpression
	 *     ConditionalTestExpression returns LiteralOptionalValueExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralOptionalValueExpression
	 *     LogicalOrExpression returns LiteralOptionalValueExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralOptionalValueExpression
	 *     LogicalAndExpression returns LiteralOptionalValueExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralOptionalValueExpression
	 *     BitwiseOrExpression returns LiteralOptionalValueExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralOptionalValueExpression
	 *     BitwiseXorExpression returns LiteralOptionalValueExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralOptionalValueExpression
	 *     BitwiseAndExpression returns LiteralOptionalValueExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralOptionalValueExpression
	 *     EqualityExpression returns LiteralOptionalValueExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralOptionalValueExpression
	 *     RelationalExpression returns LiteralOptionalValueExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralOptionalValueExpression
	 *     AdditiveExpression returns LiteralOptionalValueExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralOptionalValueExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralOptionalValueExpression
	 *     MultiplicativeExpression returns LiteralOptionalValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralOptionalValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralOptionalValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralOptionalValueExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralOptionalValueExpression
	 *     UnaryExpression returns LiteralOptionalValueExpression
	 *     CollectionFunctionExpression returns LiteralOptionalValueExpression
	 *     PrimaryExpression returns LiteralOptionalValueExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralOptionalValueExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralOptionalValueExpression
	 *     BaseExpression returns LiteralOptionalValueExpression
	 *     LiteralExpression returns LiteralOptionalValueExpression
	 *     LiteralTerminalExpression returns LiteralOptionalValueExpression
	 *     LiteralOptionalValueExpression returns LiteralOptionalValueExpression
	 *
	 * Constraint:
	 *     type=AnyDataTypeReference?
	 */
	protected void sequence_LiteralOptionalValueExpression(ISerializationContext context, LiteralOptionalValueExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralPureReferenceMachine returns LiteralParentExpression
	 *     Expression returns LiteralParentExpression
	 *     ConditionalTestExpression returns LiteralParentExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralParentExpression
	 *     LogicalOrExpression returns LiteralParentExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralParentExpression
	 *     LogicalAndExpression returns LiteralParentExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralParentExpression
	 *     BitwiseOrExpression returns LiteralParentExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralParentExpression
	 *     BitwiseXorExpression returns LiteralParentExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralParentExpression
	 *     BitwiseAndExpression returns LiteralParentExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralParentExpression
	 *     EqualityExpression returns LiteralParentExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralParentExpression
	 *     RelationalExpression returns LiteralParentExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralParentExpression
	 *     AdditiveExpression returns LiteralParentExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralParentExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralParentExpression
	 *     MultiplicativeExpression returns LiteralParentExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralParentExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralParentExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralParentExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralParentExpression
	 *     UnaryExpression returns LiteralParentExpression
	 *     CollectionFunctionExpression returns LiteralParentExpression
	 *     PrimaryExpression returns LiteralParentExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralParentExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralParentExpression
	 *     BaseExpression returns LiteralParentExpression
	 *     LiteralExpression returns LiteralParentExpression
	 *     LiteralReferenceableExpression returns LiteralParentExpression
	 *     LiteralReferenceExpression returns LiteralParentExpression
	 *     LiteralReferenceMachineContext returns LiteralParentExpression
	 *     LiteralParentExpression returns LiteralParentExpression
	 *     LiteralPureReferenceExpression returns LiteralParentExpression
	 *     ValueSelectionExpression returns LiteralParentExpression
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralParentExpression
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralParentExpression
	 *     ValuePureNamedMachineExpression returns LiteralParentExpression
	 *     ValuePureNamedMachineExpression.ValueElementSpecification_1_0 returns LiteralParentExpression
	 *
	 * Constraint:
	 *     model=[Machine|ESUfid]?
	 */
	protected void sequence_LiteralParentExpression(ISerializationContext context, LiteralParentExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralPureReferenceElement returns LiteralReferenceElement
	 *     LiteralPureReferenceExpression returns LiteralReferenceElement
	 *     ValuePureNamedMachineExpression returns LiteralReferenceElement
	 *     ValuePureNamedMachineExpression.ValueElementSpecification_1_0 returns LiteralReferenceElement
	 *
	 * Constraint:
	 *     element=[NamedElement|ESIdentifier]
	 */
	protected void sequence_LiteralPureReferenceElement(ISerializationContext context, LiteralReferenceElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralPureReferenceElementAccess().getElementNamedElementESIdentifierParserRuleCall_2_0_1(), semanticObject.eGet(ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralPureReferenceMachine returns LiteralReferenceElement
	 *
	 * Constraint:
	 *     element=[Machine|ESIdentifier]
	 */
	protected void sequence_LiteralPureReferenceMachine(ISerializationContext context, LiteralReferenceElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralPureReferenceMachineAccess().getElementMachineESIdentifierParserRuleCall_0_1_0_1(), semanticObject.eGet(ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralRationalExpression
	 *     ConditionalTestExpression returns LiteralRationalExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralRationalExpression
	 *     LogicalOrExpression returns LiteralRationalExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralRationalExpression
	 *     LogicalAndExpression returns LiteralRationalExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralRationalExpression
	 *     BitwiseOrExpression returns LiteralRationalExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralRationalExpression
	 *     BitwiseXorExpression returns LiteralRationalExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralRationalExpression
	 *     BitwiseAndExpression returns LiteralRationalExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralRationalExpression
	 *     EqualityExpression returns LiteralRationalExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralRationalExpression
	 *     RelationalExpression returns LiteralRationalExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralRationalExpression
	 *     AdditiveExpression returns LiteralRationalExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralRationalExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralRationalExpression
	 *     MultiplicativeExpression returns LiteralRationalExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralRationalExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralRationalExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralRationalExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralRationalExpression
	 *     UnaryExpression returns LiteralRationalExpression
	 *     CollectionFunctionExpression returns LiteralRationalExpression
	 *     PrimaryExpression returns LiteralRationalExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralRationalExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralRationalExpression
	 *     BaseExpression returns LiteralRationalExpression
	 *     LiteralExpression returns LiteralRationalExpression
	 *     LiteralTerminalExpression returns LiteralRationalExpression
	 *     LiteralRationalExpression returns LiteralRationalExpression
	 *
	 * Constraint:
	 *     (numerator=EInteger denominator=EInteger)
	 */
	protected void sequence_LiteralRationalExpression(ISerializationContext context, LiteralRationalExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_RATIONAL_EXPRESSION__NUMERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_RATIONAL_EXPRESSION__NUMERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_RATIONAL_EXPRESSION__DENOMINATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_RATIONAL_EXPRESSION__DENOMINATOR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralRationalExpressionAccess().getNumeratorEIntegerParserRuleCall_1_0(), semanticObject.getNumerator());
		feeder.accept(grammarAccess.getLiteralRationalExpressionAccess().getDenominatorEIntegerParserRuleCall_3_0(), semanticObject.getDenominator());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeMultiplicity returns LiteralReferenceElement
	 *     Expression returns LiteralReferenceElement
	 *     ConditionalTestExpression returns LiteralReferenceElement
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralReferenceElement
	 *     LogicalOrExpression returns LiteralReferenceElement
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralReferenceElement
	 *     LogicalAndExpression returns LiteralReferenceElement
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralReferenceElement
	 *     BitwiseOrExpression returns LiteralReferenceElement
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralReferenceElement
	 *     BitwiseXorExpression returns LiteralReferenceElement
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralReferenceElement
	 *     BitwiseAndExpression returns LiteralReferenceElement
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralReferenceElement
	 *     EqualityExpression returns LiteralReferenceElement
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralReferenceElement
	 *     RelationalExpression returns LiteralReferenceElement
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralReferenceElement
	 *     AdditiveExpression returns LiteralReferenceElement
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralReferenceElement
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralReferenceElement
	 *     MultiplicativeExpression returns LiteralReferenceElement
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralReferenceElement
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralReferenceElement
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralReferenceElement
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralReferenceElement
	 *     UnaryExpression returns LiteralReferenceElement
	 *     CollectionFunctionExpression returns LiteralReferenceElement
	 *     PrimaryExpression returns LiteralReferenceElement
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralReferenceElement
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralReferenceElement
	 *     BaseExpression returns LiteralReferenceElement
	 *     LiteralExpression returns LiteralReferenceElement
	 *     LiteralReferenceableExpression returns LiteralReferenceElement
	 *     LiteralReferenceExpression returns LiteralReferenceElement
	 *     LiteralReferenceElement returns LiteralReferenceElement
	 *     ValueSelectionExpression returns LiteralReferenceElement
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralReferenceElement
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralReferenceElement
	 *
	 * Constraint:
	 *     (
	 *         element=[NamedElement|ESIdentifier] 
	 *         ((kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList) | (kind=ValueParameterExpressionKind arg=MixTupleExpressionList))?
	 *     )
	 */
	protected void sequence_LiteralReferenceElement(ISerializationContext context, LiteralReferenceElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralReferenceSpecification returns LiteralReferenceSpecification
	 *
	 * Constraint:
	 *     (parent+=LiteralReferenceExpression* element=LiteralReferenceExpression)
	 */
	protected void sequence_LiteralReferenceSpecification(ISerializationContext context, LiteralReferenceSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralPureReferenceMachine returns LiteralSelfExpression
	 *     Expression returns LiteralSelfExpression
	 *     ConditionalTestExpression returns LiteralSelfExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralSelfExpression
	 *     LogicalOrExpression returns LiteralSelfExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralSelfExpression
	 *     LogicalAndExpression returns LiteralSelfExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralSelfExpression
	 *     BitwiseOrExpression returns LiteralSelfExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralSelfExpression
	 *     BitwiseXorExpression returns LiteralSelfExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralSelfExpression
	 *     BitwiseAndExpression returns LiteralSelfExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralSelfExpression
	 *     EqualityExpression returns LiteralSelfExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralSelfExpression
	 *     RelationalExpression returns LiteralSelfExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralSelfExpression
	 *     AdditiveExpression returns LiteralSelfExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralSelfExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralSelfExpression
	 *     MultiplicativeExpression returns LiteralSelfExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralSelfExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralSelfExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralSelfExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralSelfExpression
	 *     UnaryExpression returns LiteralSelfExpression
	 *     CollectionFunctionExpression returns LiteralSelfExpression
	 *     PrimaryExpression returns LiteralSelfExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralSelfExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralSelfExpression
	 *     BaseExpression returns LiteralSelfExpression
	 *     LiteralExpression returns LiteralSelfExpression
	 *     LiteralReferenceableExpression returns LiteralSelfExpression
	 *     LiteralReferenceExpression returns LiteralSelfExpression
	 *     LiteralReferenceMachineContext returns LiteralSelfExpression
	 *     LiteralSelfExpression returns LiteralSelfExpression
	 *     LiteralPureReferenceExpression returns LiteralSelfExpression
	 *     ValueSelectionExpression returns LiteralSelfExpression
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralSelfExpression
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralSelfExpression
	 *     ValuePureNamedMachineExpression returns LiteralSelfExpression
	 *     ValuePureNamedMachineExpression.ValueElementSpecification_1_0 returns LiteralSelfExpression
	 *
	 * Constraint:
	 *     model=[Machine|ESUfid]?
	 */
	protected void sequence_LiteralSelfExpression(ISerializationContext context, LiteralSelfExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralStringExpression
	 *     ConditionalTestExpression returns LiteralStringExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralStringExpression
	 *     LogicalOrExpression returns LiteralStringExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralStringExpression
	 *     LogicalAndExpression returns LiteralStringExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralStringExpression
	 *     BitwiseOrExpression returns LiteralStringExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralStringExpression
	 *     BitwiseXorExpression returns LiteralStringExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralStringExpression
	 *     BitwiseAndExpression returns LiteralStringExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralStringExpression
	 *     EqualityExpression returns LiteralStringExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralStringExpression
	 *     RelationalExpression returns LiteralStringExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralStringExpression
	 *     AdditiveExpression returns LiteralStringExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralStringExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralStringExpression
	 *     MultiplicativeExpression returns LiteralStringExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralStringExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralStringExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralStringExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralStringExpression
	 *     UnaryExpression returns LiteralStringExpression
	 *     CollectionFunctionExpression returns LiteralStringExpression
	 *     PrimaryExpression returns LiteralStringExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralStringExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralStringExpression
	 *     BaseExpression returns LiteralStringExpression
	 *     LiteralExpression returns LiteralStringExpression
	 *     LiteralTerminalExpression returns LiteralStringExpression
	 *     LiteralStringExpression returns LiteralStringExpression
	 *
	 * Constraint:
	 *     value=EString
	 */
	protected void sequence_LiteralStringExpression(ISerializationContext context, LiteralStringExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_STRING_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_STRING_EXPRESSION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralStringExpressionAccess().getValueEStringParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralPureReferenceMachine returns LiteralSuperExpression
	 *     Expression returns LiteralSuperExpression
	 *     ConditionalTestExpression returns LiteralSuperExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralSuperExpression
	 *     LogicalOrExpression returns LiteralSuperExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralSuperExpression
	 *     LogicalAndExpression returns LiteralSuperExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralSuperExpression
	 *     BitwiseOrExpression returns LiteralSuperExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralSuperExpression
	 *     BitwiseXorExpression returns LiteralSuperExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralSuperExpression
	 *     BitwiseAndExpression returns LiteralSuperExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralSuperExpression
	 *     EqualityExpression returns LiteralSuperExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralSuperExpression
	 *     RelationalExpression returns LiteralSuperExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralSuperExpression
	 *     AdditiveExpression returns LiteralSuperExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralSuperExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralSuperExpression
	 *     MultiplicativeExpression returns LiteralSuperExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralSuperExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralSuperExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralSuperExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralSuperExpression
	 *     UnaryExpression returns LiteralSuperExpression
	 *     CollectionFunctionExpression returns LiteralSuperExpression
	 *     PrimaryExpression returns LiteralSuperExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralSuperExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralSuperExpression
	 *     BaseExpression returns LiteralSuperExpression
	 *     LiteralExpression returns LiteralSuperExpression
	 *     LiteralReferenceableExpression returns LiteralSuperExpression
	 *     LiteralReferenceExpression returns LiteralSuperExpression
	 *     LiteralReferenceMachineContext returns LiteralSuperExpression
	 *     LiteralSuperExpression returns LiteralSuperExpression
	 *     LiteralPureReferenceExpression returns LiteralSuperExpression
	 *     ValueSelectionExpression returns LiteralSuperExpression
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralSuperExpression
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralSuperExpression
	 *     ValuePureNamedMachineExpression returns LiteralSuperExpression
	 *     ValuePureNamedMachineExpression.ValueElementSpecification_1_0 returns LiteralSuperExpression
	 *
	 * Constraint:
	 *     model=[Machine|ESUfid]?
	 */
	protected void sequence_LiteralSuperExpression(ISerializationContext context, LiteralSuperExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralPureReferenceMachine returns LiteralSystemExpression
	 *     Expression returns LiteralSystemExpression
	 *     ConditionalTestExpression returns LiteralSystemExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralSystemExpression
	 *     LogicalOrExpression returns LiteralSystemExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralSystemExpression
	 *     LogicalAndExpression returns LiteralSystemExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralSystemExpression
	 *     BitwiseOrExpression returns LiteralSystemExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralSystemExpression
	 *     BitwiseXorExpression returns LiteralSystemExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralSystemExpression
	 *     BitwiseAndExpression returns LiteralSystemExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralSystemExpression
	 *     EqualityExpression returns LiteralSystemExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralSystemExpression
	 *     RelationalExpression returns LiteralSystemExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralSystemExpression
	 *     AdditiveExpression returns LiteralSystemExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralSystemExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralSystemExpression
	 *     MultiplicativeExpression returns LiteralSystemExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralSystemExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralSystemExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralSystemExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralSystemExpression
	 *     UnaryExpression returns LiteralSystemExpression
	 *     CollectionFunctionExpression returns LiteralSystemExpression
	 *     PrimaryExpression returns LiteralSystemExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralSystemExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralSystemExpression
	 *     BaseExpression returns LiteralSystemExpression
	 *     LiteralExpression returns LiteralSystemExpression
	 *     LiteralReferenceableExpression returns LiteralSystemExpression
	 *     LiteralReferenceExpression returns LiteralSystemExpression
	 *     LiteralReferenceMachineContext returns LiteralSystemExpression
	 *     LiteralSystemExpression returns LiteralSystemExpression
	 *     LiteralPureReferenceExpression returns LiteralSystemExpression
	 *     ValueSelectionExpression returns LiteralSystemExpression
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralSystemExpression
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralSystemExpression
	 *     ValuePureNamedMachineExpression returns LiteralSystemExpression
	 *     ValuePureNamedMachineExpression.ValueElementSpecification_1_0 returns LiteralSystemExpression
	 *
	 * Constraint:
	 *     {LiteralSystemExpression}
	 */
	protected void sequence_LiteralSystemExpression(ISerializationContext context, LiteralSystemExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralPureReferenceMachine returns LiteralThisExpression
	 *     Expression returns LiteralThisExpression
	 *     ConditionalTestExpression returns LiteralThisExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralThisExpression
	 *     LogicalOrExpression returns LiteralThisExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralThisExpression
	 *     LogicalAndExpression returns LiteralThisExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralThisExpression
	 *     BitwiseOrExpression returns LiteralThisExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralThisExpression
	 *     BitwiseXorExpression returns LiteralThisExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralThisExpression
	 *     BitwiseAndExpression returns LiteralThisExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralThisExpression
	 *     EqualityExpression returns LiteralThisExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralThisExpression
	 *     RelationalExpression returns LiteralThisExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralThisExpression
	 *     AdditiveExpression returns LiteralThisExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralThisExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralThisExpression
	 *     MultiplicativeExpression returns LiteralThisExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralThisExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralThisExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralThisExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralThisExpression
	 *     UnaryExpression returns LiteralThisExpression
	 *     CollectionFunctionExpression returns LiteralThisExpression
	 *     PrimaryExpression returns LiteralThisExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralThisExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralThisExpression
	 *     BaseExpression returns LiteralThisExpression
	 *     LiteralExpression returns LiteralThisExpression
	 *     LiteralReferenceableExpression returns LiteralThisExpression
	 *     LiteralReferenceExpression returns LiteralThisExpression
	 *     LiteralReferenceMachineContext returns LiteralThisExpression
	 *     LiteralThisExpression returns LiteralThisExpression
	 *     LiteralPureReferenceExpression returns LiteralThisExpression
	 *     ValueSelectionExpression returns LiteralThisExpression
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralThisExpression
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralThisExpression
	 *     ValuePureNamedMachineExpression returns LiteralThisExpression
	 *     ValuePureNamedMachineExpression.ValueElementSpecification_1_0 returns LiteralThisExpression
	 *
	 * Constraint:
	 *     {LiteralThisExpression}
	 */
	protected void sequence_LiteralThisExpression(ISerializationContext context, LiteralThisExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralTimeDeltaExpression
	 *     ConditionalTestExpression returns LiteralTimeDeltaExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralTimeDeltaExpression
	 *     LogicalOrExpression returns LiteralTimeDeltaExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralTimeDeltaExpression
	 *     LogicalAndExpression returns LiteralTimeDeltaExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralTimeDeltaExpression
	 *     BitwiseOrExpression returns LiteralTimeDeltaExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralTimeDeltaExpression
	 *     BitwiseXorExpression returns LiteralTimeDeltaExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralTimeDeltaExpression
	 *     BitwiseAndExpression returns LiteralTimeDeltaExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralTimeDeltaExpression
	 *     EqualityExpression returns LiteralTimeDeltaExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralTimeDeltaExpression
	 *     RelationalExpression returns LiteralTimeDeltaExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralTimeDeltaExpression
	 *     AdditiveExpression returns LiteralTimeDeltaExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralTimeDeltaExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralTimeDeltaExpression
	 *     MultiplicativeExpression returns LiteralTimeDeltaExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralTimeDeltaExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralTimeDeltaExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralTimeDeltaExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralTimeDeltaExpression
	 *     UnaryExpression returns LiteralTimeDeltaExpression
	 *     CollectionFunctionExpression returns LiteralTimeDeltaExpression
	 *     PrimaryExpression returns LiteralTimeDeltaExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralTimeDeltaExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralTimeDeltaExpression
	 *     BaseExpression returns LiteralTimeDeltaExpression
	 *     LiteralExpression returns LiteralTimeDeltaExpression
	 *     LiteralReferenceableExpression returns LiteralTimeDeltaExpression
	 *     LiteralReferenceExpression returns LiteralTimeDeltaExpression
	 *     LiteralReferenceVariableContext returns LiteralTimeDeltaExpression
	 *     LiteralTimeDeltaExpression returns LiteralTimeDeltaExpression
	 *     LiteralTimeDeltaInitialExpression returns LiteralTimeDeltaExpression
	 *     ValueSelectionExpression returns LiteralTimeDeltaExpression
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralTimeDeltaExpression
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralTimeDeltaExpression
	 *
	 * Constraint:
	 *     {LiteralTimeDeltaExpression}
	 */
	protected void sequence_LiteralTimeDeltaExpression_LiteralTimeDeltaInitialExpression(ISerializationContext context, LiteralTimeDeltaExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralTimeExpression
	 *     ConditionalTestExpression returns LiteralTimeExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LiteralTimeExpression
	 *     LogicalOrExpression returns LiteralTimeExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LiteralTimeExpression
	 *     LogicalAndExpression returns LiteralTimeExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LiteralTimeExpression
	 *     BitwiseOrExpression returns LiteralTimeExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LiteralTimeExpression
	 *     BitwiseXorExpression returns LiteralTimeExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LiteralTimeExpression
	 *     BitwiseAndExpression returns LiteralTimeExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LiteralTimeExpression
	 *     EqualityExpression returns LiteralTimeExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LiteralTimeExpression
	 *     RelationalExpression returns LiteralTimeExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LiteralTimeExpression
	 *     AdditiveExpression returns LiteralTimeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralTimeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralTimeExpression
	 *     MultiplicativeExpression returns LiteralTimeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LiteralTimeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LiteralTimeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LiteralTimeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LiteralTimeExpression
	 *     UnaryExpression returns LiteralTimeExpression
	 *     CollectionFunctionExpression returns LiteralTimeExpression
	 *     PrimaryExpression returns LiteralTimeExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LiteralTimeExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LiteralTimeExpression
	 *     BaseExpression returns LiteralTimeExpression
	 *     LiteralExpression returns LiteralTimeExpression
	 *     LiteralReferenceableExpression returns LiteralTimeExpression
	 *     LiteralReferenceExpression returns LiteralTimeExpression
	 *     LiteralReferenceVariableContext returns LiteralTimeExpression
	 *     LiteralTimeExpression returns LiteralTimeExpression
	 *     LiteralTimeInitialExpression returns LiteralTimeExpression
	 *     ValueSelectionExpression returns LiteralTimeExpression
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns LiteralTimeExpression
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns LiteralTimeExpression
	 *
	 * Constraint:
	 *     {LiteralTimeExpression}
	 */
	protected void sequence_LiteralTimeExpression_LiteralTimeInitialExpression(ISerializationContext context, LiteralTimeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LitteralComElement returns LiteralReferenceElement
	 *
	 * Constraint:
	 *     element=[NamedElement|ESIdentifier]
	 */
	protected void sequence_LitteralComElement(ISerializationContext context, LiteralReferenceElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLitteralComElementAccess().getElementNamedElementESIdentifierParserRuleCall_0_1(), semanticObject.eGet(ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LogicalAssociativeExpression
	 *     ConditionalTestExpression returns LogicalAssociativeExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LogicalAssociativeExpression
	 *     LogicalOrExpression returns LogicalAssociativeExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LogicalAssociativeExpression
	 *     LogicalAndExpression returns LogicalAssociativeExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LogicalAssociativeExpression
	 *     BitwiseOrExpression returns LogicalAssociativeExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LogicalAssociativeExpression
	 *     BitwiseXorExpression returns LogicalAssociativeExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LogicalAssociativeExpression
	 *     BitwiseAndExpression returns LogicalAssociativeExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LogicalAssociativeExpression
	 *     EqualityExpression returns LogicalAssociativeExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LogicalAssociativeExpression
	 *     RelationalExpression returns LogicalAssociativeExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LogicalAssociativeExpression
	 *     AdditiveExpression returns LogicalAssociativeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LogicalAssociativeExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LogicalAssociativeExpression
	 *     MultiplicativeExpression returns LogicalAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LogicalAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LogicalAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LogicalAssociativeExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LogicalAssociativeExpression
	 *     UnaryExpression returns LogicalAssociativeExpression
	 *     CollectionFunctionExpression returns LogicalAssociativeExpression
	 *     PrimaryExpression returns LogicalAssociativeExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LogicalAssociativeExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LogicalAssociativeExpression
	 *     BaseExpression returns LogicalAssociativeExpression
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             operand+=LogicalOrExpression_LogicalAssociativeExpression_1_0 
	 *             (operator='||' | operator='or') 
	 *             operand+=LogicalAndExpression 
	 *             operand+=LogicalAndExpression*
	 *         ) | 
	 *         (
	 *             operand+=LogicalAndExpression_LogicalAssociativeExpression_1_0 
	 *             (operator='&&' | operator='and') 
	 *             operand+=BitwiseOrExpression 
	 *             operand+=BitwiseOrExpression*
	 *         )
	 *     )
	 */
	protected void sequence_LogicalAndExpression_LogicalOrExpression(ISerializationContext context, LogicalAssociativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LogicalUnaryExpression
	 *     ConditionalTestExpression returns LogicalUnaryExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns LogicalUnaryExpression
	 *     LogicalOrExpression returns LogicalUnaryExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns LogicalUnaryExpression
	 *     LogicalAndExpression returns LogicalUnaryExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns LogicalUnaryExpression
	 *     BitwiseOrExpression returns LogicalUnaryExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns LogicalUnaryExpression
	 *     BitwiseXorExpression returns LogicalUnaryExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns LogicalUnaryExpression
	 *     BitwiseAndExpression returns LogicalUnaryExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns LogicalUnaryExpression
	 *     EqualityExpression returns LogicalUnaryExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns LogicalUnaryExpression
	 *     RelationalExpression returns LogicalUnaryExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns LogicalUnaryExpression
	 *     AdditiveExpression returns LogicalUnaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns LogicalUnaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns LogicalUnaryExpression
	 *     MultiplicativeExpression returns LogicalUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns LogicalUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns LogicalUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns LogicalUnaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns LogicalUnaryExpression
	 *     UnaryExpression returns LogicalUnaryExpression
	 *     CollectionFunctionExpression returns LogicalUnaryExpression
	 *     LogicalUnaryExpression returns LogicalUnaryExpression
	 *     PrimaryExpression returns LogicalUnaryExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns LogicalUnaryExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns LogicalUnaryExpression
	 *     BaseExpression returns LogicalUnaryExpression
	 *
	 * Constraint:
	 *     ((operator='!' | operator='not') operand=UnaryExpression)
	 */
	protected void sequence_LogicalUnaryExpression(ISerializationContext context, LogicalUnaryExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AnyMachineBlock returns Machine
	 *     MachineBlock returns Machine
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             visibility=VisibilityKind | 
	 *             timed?='timed' | 
	 *             dense_timed?='timed#dense' | 
	 *             discrete_timed?='timed#discrete' | 
	 *             input_enabled?='input_enabled' | 
	 *             lifeline?='lifeline' | 
	 *             design=DesignKind
	 *         )* 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         (
	 *             port+=Port | 
	 *             signal+=Signal | 
	 *             buffer+=Buffer | 
	 *             channel+=Channel | 
	 *             typedef+=TypeDefinition | 
	 *             function+=Function | 
	 *             variable+=Variable
	 *         )* 
	 *         buffer+=BufferPrivate? 
	 *         (
	 *             (
	 *                 port+=Port | 
	 *                 signal+=Signal | 
	 *                 buffer+=Buffer | 
	 *                 channel+=Channel | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=Function | 
	 *                 variable+=Variable | 
	 *                 port+=PortPublic | 
	 *                 signal+=SignalPublic | 
	 *                 buffer+=BufferPublic | 
	 *                 channel+=ChannelPublic | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPublic | 
	 *                 variable+=VariablePublic | 
	 *                 port+=PortProtected | 
	 *                 signal+=SignalProtected | 
	 *                 buffer+=BufferProtected | 
	 *                 channel+=ChannelProtected | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionProtected | 
	 *                 variable+=VariableProtected | 
	 *                 port+=PortPrivate | 
	 *                 signal+=SignalPrivate | 
	 *                 channel+=ChannelPrivate | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPrivate | 
	 *                 variable+=VariablePrivate
	 *             )? 
	 *             buffer+=BufferPrivate?
	 *         )* 
	 *         ((procedure+=Procedure? (routine+=Routine? procedure+=Procedure?)*) | (routine+=Routine? (procedure+=Procedure? routine+=Routine?)*)) 
	 *         machine+=AnyMachineBlock? 
	 *         ((machine+=AnyMachineBlock | instance+=InstanceMachine | machine+=AnyMachineBlock | instance+=InstanceMachine)? machine+=AnyMachineBlock?)* 
	 *         behavior+=Statemachine? 
	 *         (behavior+=Behavior? behavior+=Statemachine?)* 
	 *         main=MoeBehavior
	 *     )
	 */
	protected void sequence_MachineBlock(ISerializationContext context, Machine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns MetaStatement
	 *     MetaStatement returns MetaStatement
	 *
	 * Constraint:
	 *     (op=OPERATOR_META (operand+=Statement+ | operand+=Expression+ | operand+=Expression+))
	 */
	protected void sequence_MetaStatement(ISerializationContext context, MetaStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TupleParameterExpression returns MixTupleExpression
	 *     MixTupleExpressionList returns MixTupleExpression
	 *
	 * Constraint:
	 *     ((value+=Expression | value+=NamedExpression) value+=Expression? (value+=NamedExpression? value+=Expression?)*)
	 */
	protected void sequence_MixTupleExpressionList(ISerializationContext context, MixTupleExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ModelOfComputation returns ModelOfComputation
	 *
	 * Constraint:
	 *     {ModelOfComputation}
	 */
	protected void sequence_ModelOfComputation(ISerializationContext context, ModelOfComputation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ModelOfExecution returns ModelOfExecution
	 *
	 * Constraint:
	 *     (
	 *         routine+=Routine* 
	 *         (
	 *             createRoutine=moeRoutine | 
	 *             initRoutine=moeRoutine | 
	 *             finalRoutine=moeRoutine | 
	 *             enableRoutine=moeRoutine | 
	 *             disableRoutine=moeRoutine | 
	 *             concurrencyRoutine=moeRoutine | 
	 *             scheduleRoutine=moeRoutine | 
	 *             irunRoutine=moeRoutine | 
	 *             runRoutine=moeRoutine
	 *         )* 
	 *         routine+=Routine*
	 *     )
	 */
	protected void sequence_ModelOfExecution(ISerializationContext context, ModelOfExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ModelOfInteraction returns ModelOfInteraction
	 *
	 * Constraint:
	 *     (routes+=Route | connectors+=Connector)*
	 */
	protected void sequence_ModelOfInteraction(ISerializationContext context, ModelOfInteraction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ModifierVar returns Modifier
	 *
	 * Constraint:
	 *     (static?='static' | final?='final' | final?='const' | volatile?='volatile' | transient?='transient')*
	 */
	protected void sequence_ModifierVar(ISerializationContext context, Modifier semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Modifier returns Modifier
	 *
	 * Constraint:
	 *     (static?='static' | final?='final' | volatile?='volatile' | transient?='transient' | optional?='optional')*
	 */
	protected void sequence_Modifier(ISerializationContext context, Modifier semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MoeBehavior returns Behavior
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             port+=PortPrivate | 
	 *             signal+=SignalPrivate | 
	 *             buffer+=BufferPrivate | 
	 *             channel+=ChannelPrivate | 
	 *             typedef+=TypeDefinition | 
	 *             function+=FunctionPrivate | 
	 *             variable+=VariablePrivate
	 *         )* 
	 *         execution=ModelOfExecution? 
	 *         (interaction=ModelOfInteraction? execution=ModelOfExecution?)*
	 *     )
	 */
	protected void sequence_MoeBehavior(ISerializationContext context, Behavior semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedExpression returns NamedExpression
	 *
	 * Constraint:
	 *     (name=XLIA_ID expression=Expression)
	 */
	protected void sequence_NamedExpression(ISerializationContext context, NamedExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.NAMED_EXPRESSION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.NAMED_EXPRESSION__NAME));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.NAMED_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.NAMED_EXPRESSION__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNamedExpressionAccess().getNameXLIA_IDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getNamedExpressionAccess().getExpressionExpressionParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns NewfreshExpression
	 *     ConditionalTestExpression returns NewfreshExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns NewfreshExpression
	 *     LogicalOrExpression returns NewfreshExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns NewfreshExpression
	 *     LogicalAndExpression returns NewfreshExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns NewfreshExpression
	 *     BitwiseOrExpression returns NewfreshExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns NewfreshExpression
	 *     BitwiseXorExpression returns NewfreshExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns NewfreshExpression
	 *     BitwiseAndExpression returns NewfreshExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns NewfreshExpression
	 *     EqualityExpression returns NewfreshExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns NewfreshExpression
	 *     RelationalExpression returns NewfreshExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns NewfreshExpression
	 *     AdditiveExpression returns NewfreshExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns NewfreshExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns NewfreshExpression
	 *     MultiplicativeExpression returns NewfreshExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns NewfreshExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns NewfreshExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns NewfreshExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns NewfreshExpression
	 *     UnaryExpression returns NewfreshExpression
	 *     NewfreshExpression returns NewfreshExpression
	 *     CollectionFunctionExpression returns NewfreshExpression
	 *     PrimaryExpression returns NewfreshExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns NewfreshExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns NewfreshExpression
	 *     BaseExpression returns NewfreshExpression
	 *
	 * Constraint:
	 *     (leftHandSide=LeftHandSideExpression | leftHandSide=LeftHandSideExpression)
	 */
	protected void sequence_NewfreshExpression(ISerializationContext context, NewfreshExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NullPrimitiveInstanceType returns PrimitiveInstanceType
	 *
	 * Constraint:
	 *     (expected=PrimitiveInstanceKind | model=[NamedElement|ESIdentifier])
	 */
	protected void sequence_NullPrimitiveInstanceType(ISerializationContext context, PrimitiveInstanceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ObsComElement returns ValueElementSpecification
	 *
	 * Constraint:
	 *     (parent=LiteralPureReferenceExpression? element=[NamedElement|ESIdentifier])
	 */
	protected void sequence_ObsComElement(ISerializationContext context, ValueElementSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ObservableStatement returns InputComStatement
	 *     ObsInputComStatement returns InputComStatement
	 *
	 * Constraint:
	 *     (port=ObsComElement (leftValue+=Expression leftValue+=Expression*)? (target=ValuePureNamedMachineExpression | route=[Channel|ESUfid])*)
	 */
	protected void sequence_ObsInputComStatement(ISerializationContext context, InputComStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ObservableStatement returns OutputComStatement
	 *     ObsOutputComStatement returns OutputComStatement
	 *
	 * Constraint:
	 *     (port=ObsComElement (rightValue+=Expression rightValue+=Expression*)? (target=ValuePureNamedMachineExpression | route=[Channel|ESUfid])*)
	 */
	protected void sequence_ObsOutputComStatement(ISerializationContext context, OutputComStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ObserverStatement returns ObserverStatement
	 *
	 * Constraint:
	 *     (context=ValuePureNamedMachineExpression? statement=ObservableStatement (postCondition=Expression | postCondition=Expression)?)
	 */
	protected void sequence_ObserverStatement(ISerializationContext context, ObserverStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OnWriteRoutine returns Routine
	 *
	 * Constraint:
	 *     (parameterSet=VariableRoutineParameterSet? bodyBlock=BlockStatement)
	 */
	protected void sequence_OnWriteRoutine(ISerializationContext context, Routine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeDefinition returns DataTypeReference
	 *     OtherDataTypeDefinition returns DataTypeReference
	 *
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind? 
	 *         typedef?='type' 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         ((support=PrimitiveType multiplicity=DataTypeMultiplicity?) | (typeref=[DataType|ESUfid] multiplicity=DataTypeMultiplicity?)) 
	 *         constraint=TypeConstraintRoutine?
	 *     )
	 */
	protected void sequence_OtherDataTypeDefinition(ISerializationContext context, DataTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OtherPseudostate returns Pseudostate
	 *
	 * Constraint:
	 *     (kind=PseudostateKind name=ESIdentifier unrestrictedName=UnrestrictedName? (transition+=Transition | moe=moePseudotateRoutines)*)
	 */
	protected void sequence_OtherPseudostate(ISerializationContext context, Pseudostate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns OutputComStatement
	 *     TransitionEffect.BlockStatement_1_0 returns OutputComStatement
	 *     TransitionEffectStatement returns OutputComStatement
	 *     Statement returns OutputComStatement
	 *     OutputComStatement returns OutputComStatement
	 *
	 * Constraint:
	 *     (port=LitteralComElement (rightValue+=Expression rightValue+=Expression*)? (target=LiteralPureReferenceExpression | route=[Channel|ESUfid])*)
	 */
	protected void sequence_OutputComStatement(ISerializationContext context, OutputComStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ParameterImpl returns Parameter
	 *     ParameterInput returns Parameter
	 *     ParameterInout returns Parameter
	 *     ParameterOutput returns Parameter
	 *     ParameterReturn returns Parameter
	 *
	 * Constraint:
	 *     (type=DataType name=ESIdentifier unrestrictedName=UnrestrictedName? defaultValue=Expression?)
	 */
	protected void sequence_ParameterImpl(ISerializationContext context, org.eclipse.efm.ecore.formalml.infrastructure.Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns Parameter
	 *
	 * Constraint:
	 *     (direction=ParameterDirectionKind type=DataType name=ESIdentifier unrestrictedName=UnrestrictedName? defaultValue=Expression?)
	 */
	protected void sequence_Parameter(ISerializationContext context, org.eclipse.efm.ecore.formalml.infrastructure.Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PortImpl returns Port
	 *     PortPublic returns Port
	 *     PortProtected returns Port
	 *     PortPrivate returns Port
	 *
	 * Constraint:
	 *     (
	 *         modifier=Modifier? 
	 *         (direction=ChannelDirection | direction=ChannelDirection)? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         parameterSet=FormalParameterSet?
	 *     )
	 */
	protected void sequence_PortImpl(ISerializationContext context, Port semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Port returns Port
	 *
	 * Constraint:
	 *     (
	 *         (visibility=VisibilityKind | modifier=Modifier)* 
	 *         (direction=ChannelDirection | direction=ChannelDirection)? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         parameterSet=FormalParameterSet?
	 *     )
	 */
	protected void sequence_Port(ISerializationContext context, Port semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PositionalTupleExpressionList returns PositionalTupleExpression
	 *
	 * Constraint:
	 *     (value+=Expression value+=Expression*)
	 */
	protected void sequence_PositionalTupleExpressionList(ISerializationContext context, PositionalTupleExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PotentiallyAmbiguousQualifiedName returns QualifiedName
	 *
	 * Constraint:
	 *     (nameBinding+=NameBinding nameBinding+=NameBinding* (isAmbiguous?='.' nameBinding+=NameBinding nameBinding+=NameBinding*)?)
	 */
	protected void sequence_PotentiallyAmbiguousQualifiedName_UnqualifiedName(ISerializationContext context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ValueElementSpecification
	 *     ConditionalTestExpression returns ValueElementSpecification
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns ValueElementSpecification
	 *     LogicalOrExpression returns ValueElementSpecification
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns ValueElementSpecification
	 *     LogicalAndExpression returns ValueElementSpecification
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns ValueElementSpecification
	 *     BitwiseOrExpression returns ValueElementSpecification
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns ValueElementSpecification
	 *     BitwiseXorExpression returns ValueElementSpecification
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns ValueElementSpecification
	 *     BitwiseAndExpression returns ValueElementSpecification
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns ValueElementSpecification
	 *     EqualityExpression returns ValueElementSpecification
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns ValueElementSpecification
	 *     RelationalExpression returns ValueElementSpecification
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns ValueElementSpecification
	 *     AdditiveExpression returns ValueElementSpecification
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns ValueElementSpecification
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns ValueElementSpecification
	 *     MultiplicativeExpression returns ValueElementSpecification
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns ValueElementSpecification
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns ValueElementSpecification
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns ValueElementSpecification
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns ValueElementSpecification
	 *     UnaryExpression returns ValueElementSpecification
	 *     CollectionFunctionExpression returns ValueElementSpecification
	 *     PrimaryExpression returns ValueElementSpecification
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns ValueElementSpecification
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns ValueElementSpecification
	 *     BaseExpression returns ValueElementSpecification
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             parent=PrimaryExpression_ValueElementSpecification_1_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             ((kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList) | (kind=ValueParameterExpressionKind arg=MixTupleExpressionList))?
	 *         ) | 
	 *         (
	 *             parent=PrimaryExpression_ValueElementSpecification_2_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             ((kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList) | (kind=ValueParameterExpressionKind arg=MixTupleExpressionList))?
	 *         ) | 
	 *         (
	 *             parent=PrimaryExpression_ValueElementSpecification_2_4_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             ((kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList) | (kind=ValueParameterExpressionKind arg=MixTupleExpressionList))?
	 *         )
	 *     )
	 */
	protected void sequence_PrimaryExpression(ISerializationContext context, ValueElementSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimaryExpression.ValueElementSpecification_2_4_0 returns ValueElementSpecification
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             parent=PrimaryExpression_ValueElementSpecification_2_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             ((kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList) | (kind=ValueParameterExpressionKind arg=MixTupleExpressionList))?
	 *         ) | 
	 *         (
	 *             parent=PrimaryExpression_ValueElementSpecification_2_4_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             ((kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList) | (kind=ValueParameterExpressionKind arg=MixTupleExpressionList))?
	 *         )
	 *     )
	 */
	protected void sequence_PrimaryExpression_ValueElementSpecification_2_4_0(ISerializationContext context, ValueElementSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveBooleanType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveBooleanType
	 *     DataType returns PrimitiveBooleanType
	 *     SimpleDataType returns PrimitiveBooleanType
	 *     PrimitiveType returns PrimitiveBooleanType
	 *     OtherPrimitiveType returns PrimitiveBooleanType
	 *     PrimitiveBooleanType returns PrimitiveBooleanType
	 *     AnyDataTypeReference returns PrimitiveBooleanType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveBooleanType
	 *
	 * Constraint:
	 *     (name='boolean' | name='bool')
	 */
	protected void sequence_PrimitiveBooleanType(ISerializationContext context, PrimitiveBooleanType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveCharacterType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveCharacterType
	 *     DataType returns PrimitiveCharacterType
	 *     SimpleDataType returns PrimitiveCharacterType
	 *     PrimitiveType returns PrimitiveCharacterType
	 *     OtherPrimitiveType returns PrimitiveCharacterType
	 *     PrimitiveCharacterType returns PrimitiveCharacterType
	 *     AnyDataTypeReference returns PrimitiveCharacterType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveCharacterType
	 *
	 * Constraint:
	 *     {PrimitiveCharacterType}
	 */
	protected void sequence_PrimitiveCharacterType(ISerializationContext context, PrimitiveCharacterType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveFloatType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveFloatType
	 *     DataType returns PrimitiveFloatType
	 *     SimpleDataType returns PrimitiveFloatType
	 *     PrimitiveType returns PrimitiveFloatType
	 *     PrimitiveNumberType returns PrimitiveFloatType
	 *     PrimitiveFloatType returns PrimitiveFloatType
	 *     PrimitiveTimeNumberType returns PrimitiveFloatType
	 *     AnyDataTypeReference returns PrimitiveFloatType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveFloatType
	 *
	 * Constraint:
	 *     (sign=PrimitiveNumberSign? (name='float' | name='ufloat' | name='pos_float' | name='double' | name='udouble') (size=EInt | size=EInt)?)
	 */
	protected void sequence_PrimitiveFloatType(ISerializationContext context, PrimitiveFloatType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveInstanceType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveInstanceType
	 *     DataType returns PrimitiveInstanceType
	 *     SimpleDataType returns PrimitiveInstanceType
	 *     PrimitiveType returns PrimitiveInstanceType
	 *     OtherPrimitiveType returns PrimitiveInstanceType
	 *     PrimitiveInstanceType returns PrimitiveInstanceType
	 *     AnyDataTypeReference returns PrimitiveInstanceType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveInstanceType
	 *
	 * Constraint:
	 *     (expected=PrimitiveInstanceKind model=[NamedElement|ESIdentifier]?)
	 */
	protected void sequence_PrimitiveInstanceType(ISerializationContext context, PrimitiveInstanceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveIntegerType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveIntegerType
	 *     DataType returns PrimitiveIntegerType
	 *     SimpleDataType returns PrimitiveIntegerType
	 *     PrimitiveType returns PrimitiveIntegerType
	 *     PrimitiveNumberType returns PrimitiveIntegerType
	 *     PrimitiveIntegerType returns PrimitiveIntegerType
	 *     PrimitiveTimeNumberType returns PrimitiveIntegerType
	 *     AnyDataTypeReference returns PrimitiveIntegerType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveIntegerType
	 *
	 * Constraint:
	 *     (sign=PrimitiveNumberSign? (name='integer' | name='uinteger' | name='pos_integer' | name='int' | name='uint') (size=EInt | size=EInt)?)
	 */
	protected void sequence_PrimitiveIntegerType(ISerializationContext context, PrimitiveIntegerType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveRationalType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveRationalType
	 *     DataType returns PrimitiveRationalType
	 *     SimpleDataType returns PrimitiveRationalType
	 *     PrimitiveType returns PrimitiveRationalType
	 *     PrimitiveNumberType returns PrimitiveRationalType
	 *     PrimitiveRationalType returns PrimitiveRationalType
	 *     PrimitiveTimeNumberType returns PrimitiveRationalType
	 *     AnyDataTypeReference returns PrimitiveRationalType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveRationalType
	 *
	 * Constraint:
	 *     (sign=PrimitiveNumberSign? (name='rational' | name='urational' | name='pos_rational' | name='rat' | name='urat') (size=EInt | size=EInt)?)
	 */
	protected void sequence_PrimitiveRationalType(ISerializationContext context, PrimitiveRationalType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveRealType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveRealType
	 *     DataType returns PrimitiveRealType
	 *     SimpleDataType returns PrimitiveRealType
	 *     PrimitiveType returns PrimitiveRealType
	 *     PrimitiveNumberType returns PrimitiveRealType
	 *     PrimitiveRealType returns PrimitiveRealType
	 *     PrimitiveTimeNumberType returns PrimitiveRealType
	 *     AnyDataTypeReference returns PrimitiveRealType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveRealType
	 *
	 * Constraint:
	 *     (sign=PrimitiveNumberSign? (name='real' | name='ureal' | name='pos_real') (size=EInt | size=EInt)?)
	 */
	protected void sequence_PrimitiveRealType(ISerializationContext context, PrimitiveRealType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveStringType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveStringType
	 *     DataType returns PrimitiveStringType
	 *     SimpleDataType returns PrimitiveStringType
	 *     PrimitiveType returns PrimitiveStringType
	 *     OtherPrimitiveType returns PrimitiveStringType
	 *     PrimitiveStringType returns PrimitiveStringType
	 *     AnyDataTypeReference returns PrimitiveStringType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveStringType
	 *
	 * Constraint:
	 *     (name='string' (size=EInt | size=EInt)?)
	 */
	protected void sequence_PrimitiveStringType(ISerializationContext context, PrimitiveStringType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeReference returns PrimitiveTimeType
	 *     DataTypeReference.DataTypeReference_0_1_0 returns PrimitiveTimeType
	 *     DataType returns PrimitiveTimeType
	 *     SimpleDataType returns PrimitiveTimeType
	 *     PrimitiveType returns PrimitiveTimeType
	 *     PrimitiveNumberType returns PrimitiveTimeType
	 *     PrimitiveTimeType returns PrimitiveTimeType
	 *     AnyDataTypeReference returns PrimitiveTimeType
	 *     AnyDataTypeReference.DataTypeReference_0_1_0 returns PrimitiveTimeType
	 *
	 * Constraint:
	 *     (
	 *         support=PrimitiveTimeNumberType | 
	 *         support=PrimitiveTimeNumberType | 
	 *         (clock?='clock' (support=PrimitiveTimeNumberType | support=PrimitiveTimeNumberType)?)
	 *     )?
	 */
	protected void sequence_PrimitiveTimeType(ISerializationContext context, PrimitiveTimeType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ProcedureExecution returns ModelOfExecution
	 *
	 * Constraint:
	 *     (scheduleRoutine=moeRoutine | runRoutine=moeRoutine)*
	 */
	protected void sequence_ProcedureExecution(ISerializationContext context, ModelOfExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Procedure returns Procedure
	 *
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         (parameter+=FunctionalParameter parameter+=FunctionalParameter*)? 
	 *         (parameter+=FormalParameter | (parameter+=FormalParameter parameter+=FormalParameter*))? 
	 *         (
	 *             (
	 *                 parameter+=ParameterInput | 
	 *                 parameter+=ParameterInput | 
	 *                 parameter+=ParameterInout | 
	 *                 parameter+=ParameterInout | 
	 *                 parameter+=ParameterOutput | 
	 *                 parameter+=ParameterOutput | 
	 *                 parameter+=ParameterReturn | 
	 *                 parameter+=ParameterReturn
	 *             )+ | 
	 *             (
	 *                 port+=Port | 
	 *                 signal+=Signal | 
	 *                 buffer+=Buffer | 
	 *                 channel+=Channel | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=Function | 
	 *                 variable+=Variable
	 *             )+
	 *         )? 
	 *         parameter+=ParameterInput? 
	 *         ((parameter+=ParameterInout | parameter+=ParameterOutput | parameter+=ParameterReturn)? parameter+=ParameterInput?)* 
	 *         port+=Port? 
	 *         (
	 *             (
	 *                 signal+=Signal | 
	 *                 buffer+=Buffer | 
	 *                 channel+=Channel | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=Function | 
	 *                 variable+=Variable | 
	 *                 port+=PortPublic | 
	 *                 signal+=SignalPublic | 
	 *                 buffer+=BufferPublic | 
	 *                 channel+=ChannelPublic | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPublic | 
	 *                 variable+=VariablePublic | 
	 *                 port+=PortProtected | 
	 *                 signal+=SignalProtected | 
	 *                 buffer+=BufferProtected | 
	 *                 channel+=ChannelProtected | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionProtected | 
	 *                 variable+=VariableProtected | 
	 *                 port+=PortPrivate | 
	 *                 signal+=SignalPrivate | 
	 *                 buffer+=BufferPrivate | 
	 *                 channel+=ChannelPrivate | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPrivate | 
	 *                 variable+=VariablePrivate
	 *             )? 
	 *             port+=Port?
	 *         )* 
	 *         ((routine+=Routine? (procedure+=Procedure? routine+=Routine?)*) | (routine+=Routine? (procedure+=Procedure? routine+=Routine?)*)) 
	 *         (region+=StatemachineRegion | region+=StatemachineNamedRegion+ | region+=StatemachineRegionLite)? 
	 *         execution=ProcedureExecution?
	 *     )
	 */
	protected void sequence_Procedure(ISerializationContext context, Procedure semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyPart returns PropertyPart
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 parameter+=ParameterInput | 
	 *                 parameter+=ParameterInput | 
	 *                 parameter+=ParameterInout | 
	 *                 parameter+=ParameterInout | 
	 *                 parameter+=ParameterOutput | 
	 *                 parameter+=ParameterOutput | 
	 *                 parameter+=ParameterReturn | 
	 *                 parameter+=ParameterReturn
	 *             )+ | 
	 *             (
	 *                 port+=Port | 
	 *                 signal+=Signal | 
	 *                 buffer+=Buffer | 
	 *                 channel+=Channel | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=Function | 
	 *                 variable+=Variable
	 *             )+
	 *         )? 
	 *         parameter+=ParameterInput? 
	 *         ((parameter+=ParameterInout | parameter+=ParameterOutput | parameter+=ParameterReturn)? parameter+=ParameterInput?)* 
	 *         port+=Port? 
	 *         (
	 *             (
	 *                 signal+=Signal | 
	 *                 buffer+=Buffer | 
	 *                 channel+=Channel | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=Function | 
	 *                 variable+=Variable | 
	 *                 port+=PortPublic | 
	 *                 signal+=SignalPublic | 
	 *                 buffer+=BufferPublic | 
	 *                 channel+=ChannelPublic | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPublic | 
	 *                 variable+=VariablePublic | 
	 *                 port+=PortProtected | 
	 *                 signal+=SignalProtected | 
	 *                 buffer+=BufferProtected | 
	 *                 channel+=ChannelProtected | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionProtected | 
	 *                 variable+=VariableProtected | 
	 *                 port+=PortPrivate | 
	 *                 signal+=SignalPrivate | 
	 *                 buffer+=BufferPrivate | 
	 *                 channel+=ChannelPrivate | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPrivate | 
	 *                 variable+=VariablePrivate
	 *             )? 
	 *             port+=Port?
	 *         )*
	 *     )
	 */
	protected void sequence_PropertyPart(ISerializationContext context, PropertyPart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PseudostateInitial returns Pseudostate
	 *
	 * Constraint:
	 *     (
	 *         ((kind=PseudostateInitialKind (name=ESIdentifier | name='#initial' | name='#init')) | name='#initial' | name='#init') 
	 *         unrestrictedName=UnrestrictedName? 
	 *         transition+=Transition*
	 *     )
	 */
	protected void sequence_PseudostateInitial(ISerializationContext context, Pseudostate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     QualifiedName returns QualifiedName
	 *
	 * Constraint:
	 *     (nameBinding+=NameBinding nameBinding+=NameBinding* nameBinding+=NameBinding*)
	 */
	protected void sequence_QualifiedName_UnqualifiedName(ISerializationContext context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns QuantifiedLogicalExpression
	 *     ConditionalTestExpression returns QuantifiedLogicalExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns QuantifiedLogicalExpression
	 *     LogicalOrExpression returns QuantifiedLogicalExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns QuantifiedLogicalExpression
	 *     LogicalAndExpression returns QuantifiedLogicalExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns QuantifiedLogicalExpression
	 *     BitwiseOrExpression returns QuantifiedLogicalExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns QuantifiedLogicalExpression
	 *     BitwiseXorExpression returns QuantifiedLogicalExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns QuantifiedLogicalExpression
	 *     BitwiseAndExpression returns QuantifiedLogicalExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns QuantifiedLogicalExpression
	 *     EqualityExpression returns QuantifiedLogicalExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns QuantifiedLogicalExpression
	 *     RelationalExpression returns QuantifiedLogicalExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns QuantifiedLogicalExpression
	 *     AdditiveExpression returns QuantifiedLogicalExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns QuantifiedLogicalExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns QuantifiedLogicalExpression
	 *     MultiplicativeExpression returns QuantifiedLogicalExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns QuantifiedLogicalExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns QuantifiedLogicalExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns QuantifiedLogicalExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns QuantifiedLogicalExpression
	 *     UnaryExpression returns QuantifiedLogicalExpression
	 *     CollectionFunctionExpression returns QuantifiedLogicalExpression
	 *     QuantifiedLogicalExpression returns QuantifiedLogicalExpression
	 *     PrimaryExpression returns QuantifiedLogicalExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns QuantifiedLogicalExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns QuantifiedLogicalExpression
	 *     BaseExpression returns QuantifiedLogicalExpression
	 *
	 * Constraint:
	 *     ((quantifier='forall' | quantifier='exists') variable+=BoundVariable variable+=BoundVariable* predicate=Expression)
	 */
	protected void sequence_QuantifiedLogicalExpression(ISerializationContext context, QuantifiedLogicalExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns RelationalBinaryExpression
	 *     ConditionalTestExpression returns RelationalBinaryExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns RelationalBinaryExpression
	 *     LogicalOrExpression returns RelationalBinaryExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns RelationalBinaryExpression
	 *     LogicalAndExpression returns RelationalBinaryExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns RelationalBinaryExpression
	 *     BitwiseOrExpression returns RelationalBinaryExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns RelationalBinaryExpression
	 *     BitwiseXorExpression returns RelationalBinaryExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns RelationalBinaryExpression
	 *     BitwiseAndExpression returns RelationalBinaryExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns RelationalBinaryExpression
	 *     EqualityExpression returns RelationalBinaryExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns RelationalBinaryExpression
	 *     RelationalExpression returns RelationalBinaryExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns RelationalBinaryExpression
	 *     RelationalExpression.RelationalTernaryExpression_1_3_0 returns RelationalBinaryExpression
	 *     AdditiveExpression returns RelationalBinaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns RelationalBinaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns RelationalBinaryExpression
	 *     MultiplicativeExpression returns RelationalBinaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns RelationalBinaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns RelationalBinaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns RelationalBinaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns RelationalBinaryExpression
	 *     UnaryExpression returns RelationalBinaryExpression
	 *     CollectionFunctionExpression returns RelationalBinaryExpression
	 *     PrimaryExpression returns RelationalBinaryExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns RelationalBinaryExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns RelationalBinaryExpression
	 *     BaseExpression returns RelationalBinaryExpression
	 *
	 * Constraint:
	 *     (leftOperand=RelationalExpression_RelationalBinaryExpression_1_0 operator=RelationalOperator rightOperand=AdditiveExpression)
	 */
	protected void sequence_RelationalExpression(ISerializationContext context, RelationalBinaryExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__LEFT_OPERAND));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.BINARY_EXPRESSION__RIGHT_OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getRelationalBinaryExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorParserRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getRightOperandAdditiveExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns RelationalTernaryExpression
	 *     ConditionalTestExpression returns RelationalTernaryExpression
	 *     ConditionalTestExpression.ConditionalTestExpression_1_0 returns RelationalTernaryExpression
	 *     LogicalOrExpression returns RelationalTernaryExpression
	 *     LogicalOrExpression.LogicalAssociativeExpression_1_0 returns RelationalTernaryExpression
	 *     LogicalAndExpression returns RelationalTernaryExpression
	 *     LogicalAndExpression.LogicalAssociativeExpression_1_0 returns RelationalTernaryExpression
	 *     BitwiseOrExpression returns RelationalTernaryExpression
	 *     BitwiseOrExpression.BitwiseAssociativeExpression_1_0 returns RelationalTernaryExpression
	 *     BitwiseXorExpression returns RelationalTernaryExpression
	 *     BitwiseXorExpression.BitwiseAssociativeExpression_1_0 returns RelationalTernaryExpression
	 *     BitwiseAndExpression returns RelationalTernaryExpression
	 *     BitwiseAndExpression.BitwiseAssociativeExpression_1_0 returns RelationalTernaryExpression
	 *     EqualityExpression returns RelationalTernaryExpression
	 *     EqualityExpression.EqualityBinaryExpression_1_0 returns RelationalTernaryExpression
	 *     RelationalExpression returns RelationalTernaryExpression
	 *     RelationalExpression.RelationalBinaryExpression_1_0 returns RelationalTernaryExpression
	 *     AdditiveExpression returns RelationalTernaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_0_0 returns RelationalTernaryExpression
	 *     AdditiveExpression.ArithmeticAssociativeExpression_1_1_0 returns RelationalTernaryExpression
	 *     MultiplicativeExpression returns RelationalTernaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_0_0 returns RelationalTernaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_1_0 returns RelationalTernaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_2_0 returns RelationalTernaryExpression
	 *     MultiplicativeExpression.ArithmeticAssociativeExpression_1_3_0 returns RelationalTernaryExpression
	 *     UnaryExpression returns RelationalTernaryExpression
	 *     CollectionFunctionExpression returns RelationalTernaryExpression
	 *     PrimaryExpression returns RelationalTernaryExpression
	 *     PrimaryExpression.ValueElementSpecification_1_0 returns RelationalTernaryExpression
	 *     PrimaryExpression.ValueElementSpecification_2_0 returns RelationalTernaryExpression
	 *     BaseExpression returns RelationalTernaryExpression
	 *
	 * Constraint:
	 *     (leftRelation=RelationalExpression_RelationalTernaryExpression_1_3_0 rightOperator=RelationalOperator rightOperand=AdditiveExpression)
	 */
	protected void sequence_RelationalExpression(ISerializationContext context, RelationalTernaryExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExpressionPackage.Literals.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionPackage.Literals.RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getRelationalTernaryExpressionLeftRelationAction_1_3_0(), semanticObject.getLeftRelation());
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getRightOperatorRelationalOperatorParserRuleCall_1_3_1_0(), semanticObject.getRightOperator());
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getRightOperandAdditiveExpressionParserRuleCall_1_3_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Route returns Route
	 *
	 * Constraint:
	 *     (protocol=ComRouteProtocol (name=ESIdentifier unrestrictedName=UnrestrictedName?)? (signals+=[Signal|ESUfid] signals+=[Signal|ESUfid]*)?)
	 */
	protected void sequence_Route(ISerializationContext context, Route semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Routine returns Routine
	 *
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind? 
	 *         macro?='macro'? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         parameterSet=FormalParameterSet? 
	 *         (resultSet=FormalParameterSet | resultSet=FormalParameterSet)? 
	 *         bodyBlock=BlockStatement
	 *     )
	 */
	protected void sequence_Routine(ISerializationContext context, Routine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SignalImpl returns Signal
	 *     SignalPublic returns Signal
	 *     SignalProtected returns Signal
	 *     SignalPrivate returns Signal
	 *
	 * Constraint:
	 *     (
	 *         (direction=ChannelDirection | direction=ChannelDirection)? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         parameterSet=FormalParameterSet?
	 *     )
	 */
	protected void sequence_SignalImpl(ISerializationContext context, Signal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SignalReference returns Signal
	 *
	 * Constraint:
	 *     (direction=ChannelDirection? name=ESIdentifier)
	 */
	protected void sequence_SignalReference(ISerializationContext context, Signal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Signal returns Signal
	 *
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind? 
	 *         (direction=ChannelDirection | direction=ChannelDirection)? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         parameterSet=FormalParameterSet?
	 *     )
	 */
	protected void sequence_Signal(ISerializationContext context, Signal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SimpleState returns State
	 *
	 * Constraint:
	 *     (simple?='state' name=ESIdentifier unrestrictedName=UnrestrictedName? (transition+=Transition | moe=moeSimpleStateRoutines)*)
	 */
	protected void sequence_SimpleState(ISerializationContext context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SlotParameter returns SlotProperty
	 *
	 * Constraint:
	 *     (xliaProperty=[PropertyDefinition|ESIdentifier] value=Expression)
	 */
	protected void sequence_SlotParameter(ISerializationContext context, SlotProperty semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, InfrastructurePackage.Literals.SLOT_PROPERTY__XLIA_PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, InfrastructurePackage.Literals.SLOT_PROPERTY__XLIA_PROPERTY));
			if (transientValues.isValueTransient(semanticObject, InfrastructurePackage.Literals.SLOT_PROPERTY__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, InfrastructurePackage.Literals.SLOT_PROPERTY__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSlotParameterAccess().getXliaPropertyPropertyDefinitionESIdentifierParserRuleCall_0_0_1(), semanticObject.eGet(InfrastructurePackage.Literals.SLOT_PROPERTY__XLIA_PROPERTY, false));
		feeder.accept(grammarAccess.getSlotParameterAccess().getValueExpressionParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SlotProperty returns SlotProperty
	 *
	 * Constraint:
	 *     (xliaProperty=[PropertyDefinition|ESIdentifier] value=Expression)
	 */
	protected void sequence_SlotProperty(ISerializationContext context, SlotProperty semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, InfrastructurePackage.Literals.SLOT_PROPERTY__XLIA_PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, InfrastructurePackage.Literals.SLOT_PROPERTY__XLIA_PROPERTY));
			if (transientValues.isValueTransient(semanticObject, InfrastructurePackage.Literals.SLOT_PROPERTY__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, InfrastructurePackage.Literals.SLOT_PROPERTY__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSlotPropertyAccess().getXliaPropertyPropertyDefinitionESIdentifierParserRuleCall_0_0_1(), semanticObject.eGet(InfrastructurePackage.Literals.SLOT_PROPERTY__XLIA_PROPERTY, false));
		feeder.accept(grammarAccess.getSlotPropertyAccess().getValueExpressionParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     State returns StartState
	 *     StartState returns StartState
	 *
	 * Constraint:
	 *     (
	 *         ((simple?='state' name=ESIdentifier) | simple?='#start') 
	 *         unrestrictedName=UnrestrictedName? 
	 *         (transition+=Transition | moe=moeStartStateRoutines)*
	 *     )
	 */
	protected void sequence_StartState(ISerializationContext context, StartState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     StatemachineNamedRegion returns Region
	 *
	 * Constraint:
	 *     (name=ESIdentifier unrestrictedName=UnrestrictedName? (vertex+=State | vertex+=Pseudostate)+)
	 */
	protected void sequence_StatemachineNamedRegion(ISerializationContext context, Region semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     StatemachineRegionLite returns Region
	 *
	 * Constraint:
	 *     (vertex+=State | vertex+=Pseudostate)+
	 */
	protected void sequence_StatemachineRegionLite(ISerializationContext context, Region semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     StatemachineRegion returns Region
	 *
	 * Constraint:
	 *     (vertex+=State | vertex+=Pseudostate)+
	 */
	protected void sequence_StatemachineRegion(ISerializationContext context, Region semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AnyMachineBlock returns Statemachine
	 *     Behavior returns Statemachine
	 *     Statemachine returns Statemachine
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             visibility=VisibilityKind | 
	 *             timed?='timed' | 
	 *             dense_timed?='timed#dense' | 
	 *             discrete_timed?='timed#discrete' | 
	 *             input_enabled?='input_enabled' | 
	 *             lifeline?='lifeline' | 
	 *             design=DesignKind
	 *         )* 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         (
	 *             (
	 *                 parameter+=ParameterInout? 
	 *                 (
	 *                     (
	 *                         parameter+=ParameterInput | 
	 *                         parameter+=ParameterInput | 
	 *                         parameter+=ParameterInout | 
	 *                         parameter+=ParameterOutput | 
	 *                         parameter+=ParameterOutput | 
	 *                         parameter+=ParameterReturn | 
	 *                         parameter+=ParameterReturn
	 *                     )? 
	 *                     parameter+=ParameterInout?
	 *                 )*
	 *             ) | 
	 *             (
	 *                 buffer+=Buffer? 
	 *                 (
	 *                     (
	 *                         port+=Port | 
	 *                         signal+=Signal | 
	 *                         channel+=Channel | 
	 *                         typedef+=TypeDefinition | 
	 *                         function+=Function | 
	 *                         variable+=Variable
	 *                     )? 
	 *                     buffer+=Buffer?
	 *                 )*
	 *             )
	 *         ) 
	 *         parameter+=ParameterInput? 
	 *         ((parameter+=ParameterInout | parameter+=ParameterOutput | parameter+=ParameterReturn)? parameter+=ParameterInput?)* 
	 *         (
	 *             signal+=Signal? 
	 *             (
	 *                 port+=Port | 
	 *                 buffer+=Buffer | 
	 *                 channel+=Channel | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=Function | 
	 *                 variable+=Variable | 
	 *                 port+=PortPublic | 
	 *                 signal+=SignalPublic | 
	 *                 buffer+=BufferPublic | 
	 *                 channel+=ChannelPublic | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPublic | 
	 *                 variable+=VariablePublic | 
	 *                 port+=PortProtected | 
	 *                 signal+=SignalProtected | 
	 *                 buffer+=BufferProtected | 
	 *                 channel+=ChannelProtected | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionProtected | 
	 *                 variable+=VariableProtected | 
	 *                 port+=PortPrivate | 
	 *                 signal+=SignalPrivate | 
	 *                 buffer+=BufferPrivate | 
	 *                 channel+=ChannelPrivate | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPrivate | 
	 *                 variable+=VariablePrivate
	 *             )?
	 *         )* 
	 *         (
	 *             (
	 *                 signal+=Signal? 
	 *                 (routine+=Routine? procedure+=Procedure?)* 
	 *                 routine+=Routine? 
	 *                 (region+=StatemachineRegion | region+=StatemachineNamedRegion+ | region+=StatemachineRegionLite)?
	 *             ) | 
	 *             (
	 *                 signal+=Signal? 
	 *                 (routine+=Routine? procedure+=Procedure?)* 
	 *                 routine+=Routine? 
	 *                 (region+=StatemachineRegion | region+=StatemachineNamedRegion+ | region+=StatemachineRegionLite)?
	 *             ) | 
	 *             (
	 *                 (
	 *                     (signal+=Signal? (routine+=Routine? procedure+=Procedure?)* routine+=Routine? machine+=AnyMachineBlock?) | 
	 *                     (signal+=Signal? (routine+=Routine? procedure+=Procedure?)* routine+=Routine? machine+=AnyMachineBlock?)
	 *                 ) 
	 *                 ((machine+=Statemachine | machine+=AnyMachineBlock | machine+=AnyMachineBlock | instance+=InstanceMachine)? machine+=AnyMachineBlock?)*
	 *             )
	 *         ) 
	 *         (execution=ModelOfExecution | interaction=ModelOfInteraction)*
	 *     )
	 */
	protected void sequence_Statemachine(ISerializationContext context, Statemachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     StructureTypeDefinitionImpl returns StructureType
	 *
	 * Constraint:
	 *     (name=ESIdentifier unrestrictedName=UnrestrictedName? typedef?='struct' property+=Variable+)
	 */
	protected void sequence_StructureTypeDefinitionImpl(ISerializationContext context, StructureType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeDefinition returns StructureType
	 *     StructureTypeDefinition returns StructureType
	 *
	 * Constraint:
	 *     (visibility=VisibilityKind? typedef?='type' name=ESIdentifier unrestrictedName=UnrestrictedName? property+=Variable+)
	 */
	protected void sequence_StructureTypeDefinition(ISerializationContext context, StructureType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataType returns StructureType
	 *     StructuredDataType returns StructureType
	 *     StructureType returns StructureType
	 *
	 * Constraint:
	 *     property+=Variable+
	 */
	protected void sequence_StructureType(ISerializationContext context, StructureType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns TimedGuardStatement
	 *     TimedGuardStatement returns TimedGuardStatement
	 *
	 * Constraint:
	 *     condition=Expression
	 */
	protected void sequence_TimedGuardStatement(ISerializationContext context, TimedGuardStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.ABSTRACT_GUARD_STATEMENT__CONDITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTimedGuardStatementAccess().getConditionExpressionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionTimedGuard returns TimedGuardStatement
	 *
	 * Constraint:
	 *     (condition=TransitionGuardExpression | condition=Expression | condition=Expression | condition=Expression)
	 */
	protected void sequence_TimedGuardStatement_TransitionTimedGuard(ISerializationContext context, TimedGuardStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionBehavior returns BlockStatement
	 *
	 * Constraint:
	 *     (op=BlockStatementScheduler? statement+=Statement*)
	 */
	protected void sequence_TransitionBehavior(ISerializationContext context, BlockStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns BlockStatement
	 *     TransitionEffect.BlockStatement_1_0 returns BlockStatement
	 *
	 * Constraint:
	 *     (statement+=TransitionEffect_BlockStatement_1_0 statement+=TransitionEffectStatement)
	 */
	protected void sequence_TransitionEffect(ISerializationContext context, BlockStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionGuardExpression returns LogicalAssociativeExpression
	 *
	 * Constraint:
	 *     ((operator='&&' | operator='and' | operator='||' | operator='or') operand+=BitwiseOrExpression+)
	 */
	protected void sequence_TransitionGuardExpression(ISerializationContext context, LogicalAssociativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionMoe returns TransitionMoe
	 *
	 * Constraint:
	 *     ((((moc=TransitionMoc isElse?='else'?) | isElse?='else') priority=EInt?) | priority=EInt)
	 */
	protected void sequence_TransitionMoe(ISerializationContext context, TransitionMoe semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Transition returns Transition
	 *
	 * Constraint:
	 *     (
	 *         transient?='transient'? 
	 *         moe=TransitionMoe? 
	 *         name=ESIdentifier? 
	 *         unrestrictedName=UnrestrictedName? 
	 *         (
	 *             (
	 *                 ((trigger+=TransitionTrigger* guard=TransitionGuard? tguard=TransitionTimedGuard? effect=TransitionEffect?) | behavior=TransitionBehavior)? 
	 *                 (target=[Vertex|ESUfid] | targetExpression=ValuePureNamedMachineExpression)?
	 *             ) | 
	 *             (
	 *                 (target=[Vertex|ESUfid] | targetExpression=ValuePureNamedMachineExpression) 
	 *                 ((trigger+=TransitionTrigger* guard=TransitionGuard? tguard=TransitionTimedGuard? effect=TransitionEffect?) | behavior=TransitionBehavior)?
	 *             )
	 *         )
	 *     )
	 */
	protected void sequence_Transition(ISerializationContext context, Transition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeConstraintRoutine returns Routine
	 *
	 * Constraint:
	 *     (parameterSet=VariableRoutineParameterSet? (bodyBlock=BlockStatement | bodyBlock=ConditionalBlockStatement))
	 */
	protected void sequence_TypeConstraintRoutine(ISerializationContext context, Routine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnionTypeDefinitionImpl returns UnionType
	 *
	 * Constraint:
	 *     (name=ESIdentifier unrestrictedName=UnrestrictedName? typedef?='union' property+=Variable+)
	 */
	protected void sequence_UnionTypeDefinitionImpl(ISerializationContext context, UnionType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeDefinition returns UnionType
	 *     UnionTypeDefinition returns UnionType
	 *
	 * Constraint:
	 *     (visibility=VisibilityKind? typedef?='type' name=ESIdentifier unrestrictedName=UnrestrictedName? property+=Variable+)
	 */
	protected void sequence_UnionTypeDefinition(ISerializationContext context, UnionType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataType returns UnionType
	 *     StructuredDataType returns UnionType
	 *     UnionType returns UnionType
	 *
	 * Constraint:
	 *     property+=Variable+
	 */
	protected void sequence_UnionType(ISerializationContext context, UnionType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnqualifiedName returns QualifiedName
	 *
	 * Constraint:
	 *     nameBinding+=NameBinding
	 */
	protected void sequence_UnqualifiedName(ISerializationContext context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValuePureNamedMachineExpression returns ValueElementSpecification
	 *     ValuePureNamedMachineExpression.ValueElementSpecification_1_0 returns ValueElementSpecification
	 *
	 * Constraint:
	 *     (
	 *         parent=ValuePureNamedMachineExpression_ValueElementSpecification_1_0 
	 *         (kind=ValueDotFieldExpressionKind | kind=ValueArrowFieldExpressionKind) 
	 *         element=[NamedElement|ESIdentifier]
	 *     )
	 */
	protected void sequence_ValuePureNamedMachineExpression(ISerializationContext context, ValueElementSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSelectionExpression returns ValueElementSpecification
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             parent=ValueSelectionExpression_ValueElementSpecification_1_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             (kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList)?
	 *         ) | 
	 *         (
	 *             parent=ValueSelectionExpression_ValueElementSpecification_2_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             (kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList)?
	 *         ) | 
	 *         (
	 *             parent=ValueSelectionExpression_ValueElementSpecification_2_4_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             (kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList)?
	 *         )
	 *     )
	 */
	protected void sequence_ValueSelectionExpression(ISerializationContext context, ValueElementSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSelectionExpression.ValueElementSpecification_1_0 returns ValueElementSpecification
	 *     ValueSelectionExpression.ValueElementSpecification_2_0 returns ValueElementSpecification
	 *
	 * Constraint:
	 *     (
	 *         parent=ValueSelectionExpression_ValueElementSpecification_1_0 
	 *         element=[NamedElement|ESIdentifier] 
	 *         (kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList)?
	 *     )
	 */
	protected void sequence_ValueSelectionExpression_ValueElementSpecification_1_0_ValueElementSpecification_2_0(ISerializationContext context, ValueElementSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValueSelectionExpression.ValueElementSpecification_2_4_0 returns ValueElementSpecification
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             parent=ValueSelectionExpression_ValueElementSpecification_2_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             (kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList)?
	 *         ) | 
	 *         (
	 *             parent=ValueSelectionExpression_ValueElementSpecification_2_4_0 
	 *             element=[NamedElement|ESIdentifier] 
	 *             (kind=ValueIndexExpressionKind arg=PositionalTupleExpressionList)?
	 *         )
	 *     )
	 */
	protected void sequence_ValueSelectionExpression_ValueElementSpecification_2_4_0(ISerializationContext context, ValueElementSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VariableImpl returns Variable
	 *     VariablePublic returns Variable
	 *     VariableProtected returns Variable
	 *     VariablePrivate returns Variable
	 *
	 * Constraint:
	 *     (
	 *         modifier=Modifier? 
	 *         (const?='val' | (const?='const' macro?='macro'?) | (macro?='macro' const?='val'?))? 
	 *         type=DataType 
	 *         reference?='&'? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         defaultValue=Expression? 
	 *         onWriteAction=OnWriteRoutine?
	 *     )
	 */
	protected void sequence_VariableImpl(ISerializationContext context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VariableRoutineParameterSet returns ParameterSet
	 *
	 * Constraint:
	 *     parameter+=VariableRoutineParameter
	 */
	protected void sequence_VariableRoutineParameterSet(ISerializationContext context, ParameterSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VariableRoutineParameter returns Parameter
	 *
	 * Constraint:
	 *     (direction=ParameterDirectionKind? type=DataType? name=ESIdentifier defaultValue=Expression?)
	 */
	protected void sequence_VariableRoutineParameter(ISerializationContext context, org.eclipse.efm.ecore.formalml.infrastructure.Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Variable returns Variable
	 *
	 * Constraint:
	 *     (
	 *         (visibility=VisibilityKind | modifier=Modifier)* 
	 *         (const?='val' | ((const?='const' | const?='final') macro?='macro'?) | (macro?='macro' const?='val'?))? 
	 *         type=DataType 
	 *         reference?='&'? 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         defaultValue=Expression? 
	 *         onWriteAction=OnWriteRoutine?
	 *     )
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TransitionEffect returns WhileDoStatement
	 *     TransitionEffect.BlockStatement_1_0 returns WhileDoStatement
	 *     TransitionEffectStatement returns WhileDoStatement
	 *     Statement returns WhileDoStatement
	 *     WhileDoStatement returns WhileDoStatement
	 *
	 * Constraint:
	 *     (condition=Expression bodyBlock=BlockStatement)
	 */
	protected void sequence_WhileDoStatement(ISerializationContext context, WhileDoStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__CONDITION));
			if (transientValues.isValueTransient(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatementPackage.Literals.CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getWhileDoStatementAccess().getConditionExpressionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getWhileDoStatementAccess().getBodyBlockBlockStatementParserRuleCall_2_0(), semanticObject.getBodyBlock());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XliaNamedElement returns XliaAttribute
	 *     XliaAttribute returns XliaAttribute
	 *
	 * Constraint:
	 *     (name=XLIA_ID value=Expression)
	 */
	protected void sequence_XliaAttribute(ISerializationContext context, XliaAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FormalmlPackage.Literals.XLIA_NAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormalmlPackage.Literals.XLIA_NAMED_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, FormalmlPackage.Literals.XLIA_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormalmlPackage.Literals.XLIA_ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXliaAttributeAccess().getNameXLIA_IDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXliaAttributeAccess().getValueExpressionParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XliaNamedElement returns XliaObject
	 *     XliaObject returns XliaObject
	 *
	 * Constraint:
	 *     (name=XLIA_ID elements+=XliaNamedElement*)
	 */
	protected void sequence_XliaObject(ISerializationContext context, XliaObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XliaOptionObject returns XliaObject
	 *
	 * Constraint:
	 *     (name='@option' elements+=XliaNamedElement*)
	 */
	protected void sequence_XliaOptionObject(ISerializationContext context, XliaObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XliaPrologAttribute returns XliaAttribute
	 *
	 * Constraint:
	 *     ((name='system' | name='package') (value=LiteralFloatExpression | value=LiteralStringExpression)?)
	 */
	protected void sequence_XliaPrologAttribute(ISerializationContext context, XliaAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XliaPrologObject returns XliaObject
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             name='@FormalML' | 
	 *             name='@xfml' | 
	 *             name='@fml' | 
	 *             name='@xlia' | 
	 *             name='@xfsp' | 
	 *             name='@diversity'
	 *         ) 
	 *         elements+=XliaPrologAttribute 
	 *         elements+=XliaOptionObject?
	 *     )
	 */
	protected void sequence_XliaPrologObject(ISerializationContext context, XliaObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XliaNamedElement returns XliaSection
	 *     XliaSection returns XliaSection
	 *
	 * Constraint:
	 *     (name=XLIA_ID elements+=XliaAttribute*)
	 */
	protected void sequence_XliaSection(ISerializationContext context, XliaSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XliaSystem returns XliaSystem
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             visibility=VisibilityKind | 
	 *             timed?='timed' | 
	 *             dense_timed?='timed#dense' | 
	 *             discrete_timed?='timed#discrete' | 
	 *             input_enabled?='input_enabled' | 
	 *             unsafe?='unsafe'
	 *         )* 
	 *         name=ESIdentifier 
	 *         unrestrictedName=UnrestrictedName? 
	 *         (
	 *             port+=Port | 
	 *             signal+=Signal | 
	 *             buffer+=Buffer | 
	 *             channel+=Channel | 
	 *             typedef+=TypeDefinition | 
	 *             function+=Function | 
	 *             variable+=Variable
	 *         )* 
	 *         port+=Port? 
	 *         (
	 *             (
	 *                 signal+=Signal | 
	 *                 buffer+=Buffer | 
	 *                 channel+=Channel | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=Function | 
	 *                 variable+=Variable | 
	 *                 port+=PortPublic | 
	 *                 signal+=SignalPublic | 
	 *                 buffer+=BufferPublic | 
	 *                 channel+=ChannelPublic | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPublic | 
	 *                 variable+=VariablePublic | 
	 *                 port+=PortProtected | 
	 *                 signal+=SignalProtected | 
	 *                 buffer+=BufferProtected | 
	 *                 channel+=ChannelProtected | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionProtected | 
	 *                 variable+=VariableProtected | 
	 *                 port+=PortPrivate | 
	 *                 signal+=SignalPrivate | 
	 *                 buffer+=BufferPrivate | 
	 *                 channel+=ChannelPrivate | 
	 *                 typedef+=TypeDefinition | 
	 *                 function+=FunctionPrivate | 
	 *                 variable+=VariablePrivate
	 *             )? 
	 *             port+=Port?
	 *         )* 
	 *         ((routine+=Routine? (procedure+=Procedure? routine+=Routine?)*) | (routine+=Routine? (procedure+=Procedure? routine+=Routine?)*)) 
	 *         machine+=AnyMachineBlock? 
	 *         ((instance+=InstanceMachine | machine+=AnyMachineBlock | machine+=AnyMachineBlock | instance+=InstanceMachine)? machine+=AnyMachineBlock?)* 
	 *         behavior+=Behavior? 
	 *         (behavior+=Statemachine? behavior+=Behavior?)* 
	 *         main=MoeBehavior
	 *     )
	 */
	protected void sequence_XliaSystem(ISerializationContext context, XliaSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Xlia returns XliaModel
	 *
	 * Constraint:
	 *     (prolog=XliaPrologObject system=XliaSystem)
	 */
	protected void sequence_Xlia(ISerializationContext context, XliaModel semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FormalmlPackage.Literals.XLIA_MODEL__PROLOG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormalmlPackage.Literals.XLIA_MODEL__PROLOG));
			if (transientValues.isValueTransient(semanticObject, FormalmlPackage.Literals.XLIA_MODEL__SYSTEM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormalmlPackage.Literals.XLIA_MODEL__SYSTEM));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXliaAccess().getPrologXliaPrologObjectParserRuleCall_0_0(), semanticObject.getProlog());
		feeder.accept(grammarAccess.getXliaAccess().getSystemXliaSystemParserRuleCall_1_0(), semanticObject.getSystem());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     moeCompositeStateRoutines returns ModelOfExecution
	 *
	 * Constraint:
	 *     (
	 *         createRoutine=moeRoutine | 
	 *         initRoutine=moeRoutine | 
	 *         finalRoutine=moeRoutine | 
	 *         enableRoutine=moeRoutine | 
	 *         disableRoutine=moeRoutine | 
	 *         concurrencyRoutine=moeRoutine | 
	 *         scheduleRoutine=moeRoutine | 
	 *         irunRoutine=moeRoutine | 
	 *         runRoutine=moeRoutine
	 *     )*
	 */
	protected void sequence_moeCompositeStateRoutines(ISerializationContext context, ModelOfExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     moeFinalStateRoutines returns ModelOfExecution
	 *
	 * Constraint:
	 *     (enableRoutine=moeRoutine | finalRoutine=moeRoutine)*
	 */
	protected void sequence_moeFinalStateRoutines(ISerializationContext context, ModelOfExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     moePseudotateRoutines returns ModelOfExecution
	 *
	 * Constraint:
	 *     (enableRoutine=moeRoutine | disableRoutine=moeRoutine)*
	 */
	protected void sequence_moePseudotateRoutines(ISerializationContext context, ModelOfExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     moeRoutine returns Routine
	 *
	 * Constraint:
	 *     (parameterSet=FormalParameterSet? (resultSet=FormalParameterSet | resultSet=FormalParameterSet)? bodyBlock=BlockStatement)
	 */
	protected void sequence_moeRoutine(ISerializationContext context, Routine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     moeSimpleStateRoutines returns ModelOfExecution
	 *
	 * Constraint:
	 *     (enableRoutine=moeRoutine | disableRoutine=moeRoutine | irunRoutine=moeRoutine)*
	 */
	protected void sequence_moeSimpleStateRoutines(ISerializationContext context, ModelOfExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     moeStartStateRoutines returns ModelOfExecution
	 *
	 * Constraint:
	 *     (
	 *         createRoutine=moeRoutine | 
	 *         initRoutine=moeRoutine | 
	 *         finalRoutine=moeRoutine | 
	 *         enableRoutine=moeRoutine | 
	 *         disableRoutine=moeRoutine | 
	 *         irunRoutine=moeRoutine
	 *     )*
	 */
	protected void sequence_moeStartStateRoutines(ISerializationContext context, ModelOfExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
