/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.expression.impl;

import org.eclipse.efm.ecore.formalml.expression.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionFactoryImpl extends EFactoryImpl implements ExpressionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionFactory init() {
		try {
			ExpressionFactory theExpressionFactory = (ExpressionFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionPackage.eNS_URI);
			if (theExpressionFactory != null) {
				return theExpressionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION: return createValuePrintableExpression();
			case ExpressionPackage.LITERAL_EXPRESSION: return createLiteralExpression();
			case ExpressionPackage.LITERAL_BOOLEAN_EXPRESSION: return createLiteralBooleanExpression();
			case ExpressionPackage.LITERAL_INTEGER_EXPRESSION: return createLiteralIntegerExpression();
			case ExpressionPackage.LITERAL_RATIONAL_EXPRESSION: return createLiteralRationalExpression();
			case ExpressionPackage.LITERAL_FLOAT_EXPRESSION: return createLiteralFloatExpression();
			case ExpressionPackage.LITERAL_REAL_EXPRESSION: return createLiteralRealExpression();
			case ExpressionPackage.LITERAL_CHARACTER_EXPRESSION: return createLiteralCharacterExpression();
			case ExpressionPackage.LITERAL_STRING_EXPRESSION: return createLiteralStringExpression();
			case ExpressionPackage.LITERAL_COLLECTION_EXPRESSION: return createLiteralCollectionExpression();
			case ExpressionPackage.LITERAL_NULL_EXPRESSION: return createLiteralNullExpression();
			case ExpressionPackage.LITERAL_REFERENCE_EXPRESSION: return createLiteralReferenceExpression();
			case ExpressionPackage.LITERAL_REFERENCE_ELEMENT: return createLiteralReferenceElement();
			case ExpressionPackage.LITERAL_THIS_EXPRESSION: return createLiteralThisExpression();
			case ExpressionPackage.LITERAL_SELF_EXPRESSION: return createLiteralSelfExpression();
			case ExpressionPackage.LITERAL_PARENT_EXPRESSION: return createLiteralParentExpression();
			case ExpressionPackage.LITERAL_SUPER_EXPRESSION: return createLiteralSuperExpression();
			case ExpressionPackage.LITERAL_SYSTEM_EXPRESSION: return createLiteralSystemExpression();
			case ExpressionPackage.LITERAL_ENV_EXPRESSION: return createLiteralEnvExpression();
			case ExpressionPackage.LITERAL_TIME_EXPRESSION: return createLiteralTimeExpression();
			case ExpressionPackage.LITERAL_TIME_DELTA_EXPRESSION: return createLiteralTimeDeltaExpression();
			case ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION: return createLeftHandSideExpression();
			case ExpressionPackage.INCREMENT_OR_DECREMENT_EXPRESSION: return createIncrementOrDecrementExpression();
			case ExpressionPackage.INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION: return createIncrementOrDecrementPrefixExpression();
			case ExpressionPackage.INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION: return createIncrementOrDecrementPostfixExpression();
			case ExpressionPackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
			case ExpressionPackage.NEWFRESH_EXPRESSION: return createNewfreshExpression();
			case ExpressionPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case ExpressionPackage.BITWISE_UNARY_EXPRESSION: return createBitwiseUnaryExpression();
			case ExpressionPackage.LOGICAL_UNARY_EXPRESSION: return createLogicalUnaryExpression();
			case ExpressionPackage.CAST_EXPRESSION: return createCastExpression();
			case ExpressionPackage.ARITHMETIC_UNARY_EXPRESSION: return createArithmeticUnaryExpression();
			case ExpressionPackage.BINARY_EXPRESSION: return createBinaryExpression();
			case ExpressionPackage.EQUALITY_BINARY_EXPRESSION: return createEqualityBinaryExpression();
			case ExpressionPackage.RELATIONAL_BINARY_EXPRESSION: return createRelationalBinaryExpression();
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION: return createRelationalTernaryExpression();
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION: return createConditionalTestExpression();
			case ExpressionPackage.ASSOCIATIVE_EXPRESSION: return createAssociativeExpression();
			case ExpressionPackage.ARITHMETIC_ASSOCIATIVE_EXPRESSION: return createArithmeticAssociativeExpression();
			case ExpressionPackage.BITWISE_ASSOCIATIVE_EXPRESSION: return createBitwiseAssociativeExpression();
			case ExpressionPackage.LOGICAL_ASSOCIATIVE_EXPRESSION: return createLogicalAssociativeExpression();
			case ExpressionPackage.QUANTIFIED_LOGICAL_EXPRESSION: return createQuantifiedLogicalExpression();
			case ExpressionPackage.INVOKE_EXPRESSION: return createInvokeExpression();
			case ExpressionPackage.NAMED_EXPRESSION: return createNamedExpression();
			case ExpressionPackage.MIX_TUPLE_EXPRESSION: return createMixTupleExpression();
			case ExpressionPackage.NAMED_TUPLE_EXPRESSION: return createNamedTupleExpression();
			case ExpressionPackage.POSITIONAL_TUPLE_EXPRESSION: return createPositionalTupleExpression();
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION: return createValueElementSpecification();
			case ExpressionPackage.INSTANTIATION_EXPRESSION: return createInstantiationExpression();
			case ExpressionPackage.EXPRESSION_AS_BUFFER: return createExpressionAsBuffer();
			case ExpressionPackage.EXPRESSION_AS_CHANNEL: return createExpressionAsChannel();
			case ExpressionPackage.EXPRESSION_AS_MACHINE: return createExpressionAsMachine();
			case ExpressionPackage.EXPRESSION_AS_PORT: return createExpressionAsPort();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionPackage.PRINTER_FIX:
				return createPRINTER_FIXFromString(eDataType, initialValue);
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION_KIND:
				return createValueElementSpecificationKindFromString(eDataType, initialValue);
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION_SCHEME:
				return createValueElementSpecificationSchemeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionPackage.PRINTER_FIX:
				return convertPRINTER_FIXToString(eDataType, instanceValue);
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION_KIND:
				return convertValueElementSpecificationKindToString(eDataType, instanceValue);
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION_SCHEME:
				return convertValueElementSpecificationSchemeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValuePrintableExpression createValuePrintableExpression() {
		ValuePrintableExpressionImpl valuePrintableExpression = new ValuePrintableExpressionImpl();
		return valuePrintableExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralExpression createLiteralExpression() {
		LiteralExpressionImpl literalExpression = new LiteralExpressionImpl();
		return literalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralBooleanExpression createLiteralBooleanExpression() {
		LiteralBooleanExpressionImpl literalBooleanExpression = new LiteralBooleanExpressionImpl();
		return literalBooleanExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralIntegerExpression createLiteralIntegerExpression() {
		LiteralIntegerExpressionImpl literalIntegerExpression = new LiteralIntegerExpressionImpl();
		return literalIntegerExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralRationalExpression createLiteralRationalExpression() {
		LiteralRationalExpressionImpl literalRationalExpression = new LiteralRationalExpressionImpl();
		return literalRationalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralFloatExpression createLiteralFloatExpression() {
		LiteralFloatExpressionImpl literalFloatExpression = new LiteralFloatExpressionImpl();
		return literalFloatExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralRealExpression createLiteralRealExpression() {
		LiteralRealExpressionImpl literalRealExpression = new LiteralRealExpressionImpl();
		return literalRealExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralCharacterExpression createLiteralCharacterExpression() {
		LiteralCharacterExpressionImpl literalCharacterExpression = new LiteralCharacterExpressionImpl();
		return literalCharacterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralStringExpression createLiteralStringExpression() {
		LiteralStringExpressionImpl literalStringExpression = new LiteralStringExpressionImpl();
		return literalStringExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralCollectionExpression createLiteralCollectionExpression() {
		LiteralCollectionExpressionImpl literalCollectionExpression = new LiteralCollectionExpressionImpl();
		return literalCollectionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralNullExpression createLiteralNullExpression() {
		LiteralNullExpressionImpl literalNullExpression = new LiteralNullExpressionImpl();
		return literalNullExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralReferenceExpression createLiteralReferenceExpression() {
		LiteralReferenceExpressionImpl literalReferenceExpression = new LiteralReferenceExpressionImpl();
		return literalReferenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralReferenceElement createLiteralReferenceElement() {
		LiteralReferenceElementImpl literalReferenceElement = new LiteralReferenceElementImpl();
		return literalReferenceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralThisExpression createLiteralThisExpression() {
		LiteralThisExpressionImpl literalThisExpression = new LiteralThisExpressionImpl();
		return literalThisExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralSelfExpression createLiteralSelfExpression() {
		LiteralSelfExpressionImpl literalSelfExpression = new LiteralSelfExpressionImpl();
		return literalSelfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralParentExpression createLiteralParentExpression() {
		LiteralParentExpressionImpl literalParentExpression = new LiteralParentExpressionImpl();
		return literalParentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralSuperExpression createLiteralSuperExpression() {
		LiteralSuperExpressionImpl literalSuperExpression = new LiteralSuperExpressionImpl();
		return literalSuperExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralSystemExpression createLiteralSystemExpression() {
		LiteralSystemExpressionImpl literalSystemExpression = new LiteralSystemExpressionImpl();
		return literalSystemExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralEnvExpression createLiteralEnvExpression() {
		LiteralEnvExpressionImpl literalEnvExpression = new LiteralEnvExpressionImpl();
		return literalEnvExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralTimeExpression createLiteralTimeExpression() {
		LiteralTimeExpressionImpl literalTimeExpression = new LiteralTimeExpressionImpl();
		return literalTimeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralTimeDeltaExpression createLiteralTimeDeltaExpression() {
		LiteralTimeDeltaExpressionImpl literalTimeDeltaExpression = new LiteralTimeDeltaExpressionImpl();
		return literalTimeDeltaExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftHandSideExpression createLeftHandSideExpression() {
		LeftHandSideExpressionImpl leftHandSideExpression = new LeftHandSideExpressionImpl();
		return leftHandSideExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementOrDecrementExpression createIncrementOrDecrementExpression() {
		IncrementOrDecrementExpressionImpl incrementOrDecrementExpression = new IncrementOrDecrementExpressionImpl();
		return incrementOrDecrementExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementOrDecrementPrefixExpression createIncrementOrDecrementPrefixExpression() {
		IncrementOrDecrementPrefixExpressionImpl incrementOrDecrementPrefixExpression = new IncrementOrDecrementPrefixExpressionImpl();
		return incrementOrDecrementPrefixExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementOrDecrementPostfixExpression createIncrementOrDecrementPostfixExpression() {
		IncrementOrDecrementPostfixExpressionImpl incrementOrDecrementPostfixExpression = new IncrementOrDecrementPostfixExpressionImpl();
		return incrementOrDecrementPostfixExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentExpression createAssignmentExpression() {
		AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
		return assignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewfreshExpression createNewfreshExpression() {
		NewfreshExpressionImpl newfreshExpression = new NewfreshExpressionImpl();
		return newfreshExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitwiseUnaryExpression createBitwiseUnaryExpression() {
		BitwiseUnaryExpressionImpl bitwiseUnaryExpression = new BitwiseUnaryExpressionImpl();
		return bitwiseUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalUnaryExpression createLogicalUnaryExpression() {
		LogicalUnaryExpressionImpl logicalUnaryExpression = new LogicalUnaryExpressionImpl();
		return logicalUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CastExpression createCastExpression() {
		CastExpressionImpl castExpression = new CastExpressionImpl();
		return castExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithmeticUnaryExpression createArithmeticUnaryExpression() {
		ArithmeticUnaryExpressionImpl arithmeticUnaryExpression = new ArithmeticUnaryExpressionImpl();
		return arithmeticUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryExpression createBinaryExpression() {
		BinaryExpressionImpl binaryExpression = new BinaryExpressionImpl();
		return binaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityBinaryExpression createEqualityBinaryExpression() {
		EqualityBinaryExpressionImpl equalityBinaryExpression = new EqualityBinaryExpressionImpl();
		return equalityBinaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalBinaryExpression createRelationalBinaryExpression() {
		RelationalBinaryExpressionImpl relationalBinaryExpression = new RelationalBinaryExpressionImpl();
		return relationalBinaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTernaryExpression createRelationalTernaryExpression() {
		RelationalTernaryExpressionImpl relationalTernaryExpression = new RelationalTernaryExpressionImpl();
		return relationalTernaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalTestExpression createConditionalTestExpression() {
		ConditionalTestExpressionImpl conditionalTestExpression = new ConditionalTestExpressionImpl();
		return conditionalTestExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociativeExpression createAssociativeExpression() {
		AssociativeExpressionImpl associativeExpression = new AssociativeExpressionImpl();
		return associativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithmeticAssociativeExpression createArithmeticAssociativeExpression() {
		ArithmeticAssociativeExpressionImpl arithmeticAssociativeExpression = new ArithmeticAssociativeExpressionImpl();
		return arithmeticAssociativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitwiseAssociativeExpression createBitwiseAssociativeExpression() {
		BitwiseAssociativeExpressionImpl bitwiseAssociativeExpression = new BitwiseAssociativeExpressionImpl();
		return bitwiseAssociativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalAssociativeExpression createLogicalAssociativeExpression() {
		LogicalAssociativeExpressionImpl logicalAssociativeExpression = new LogicalAssociativeExpressionImpl();
		return logicalAssociativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuantifiedLogicalExpression createQuantifiedLogicalExpression() {
		QuantifiedLogicalExpressionImpl quantifiedLogicalExpression = new QuantifiedLogicalExpressionImpl();
		return quantifiedLogicalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeExpression createInvokeExpression() {
		InvokeExpressionImpl invokeExpression = new InvokeExpressionImpl();
		return invokeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedExpression createNamedExpression() {
		NamedExpressionImpl namedExpression = new NamedExpressionImpl();
		return namedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MixTupleExpression createMixTupleExpression() {
		MixTupleExpressionImpl mixTupleExpression = new MixTupleExpressionImpl();
		return mixTupleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedTupleExpression createNamedTupleExpression() {
		NamedTupleExpressionImpl namedTupleExpression = new NamedTupleExpressionImpl();
		return namedTupleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionalTupleExpression createPositionalTupleExpression() {
		PositionalTupleExpressionImpl positionalTupleExpression = new PositionalTupleExpressionImpl();
		return positionalTupleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueElementSpecification createValueElementSpecification() {
		ValueElementSpecificationImpl valueElementSpecification = new ValueElementSpecificationImpl();
		return valueElementSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiationExpression createInstantiationExpression() {
		InstantiationExpressionImpl instantiationExpression = new InstantiationExpressionImpl();
		return instantiationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAsBuffer createExpressionAsBuffer() {
		ExpressionAsBufferImpl expressionAsBuffer = new ExpressionAsBufferImpl();
		return expressionAsBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAsChannel createExpressionAsChannel() {
		ExpressionAsChannelImpl expressionAsChannel = new ExpressionAsChannelImpl();
		return expressionAsChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAsMachine createExpressionAsMachine() {
		ExpressionAsMachineImpl expressionAsMachine = new ExpressionAsMachineImpl();
		return expressionAsMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAsPort createExpressionAsPort() {
		ExpressionAsPortImpl expressionAsPort = new ExpressionAsPortImpl();
		return expressionAsPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRINTER_FIX createPRINTER_FIXFromString(EDataType eDataType, String initialValue) {
		PRINTER_FIX result = PRINTER_FIX.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPRINTER_FIXToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueElementSpecificationKind createValueElementSpecificationKindFromString(EDataType eDataType, String initialValue) {
		ValueElementSpecificationKind result = ValueElementSpecificationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueElementSpecificationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueElementSpecificationScheme createValueElementSpecificationSchemeFromString(EDataType eDataType, String initialValue) {
		ValueElementSpecificationScheme result = ValueElementSpecificationScheme.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueElementSpecificationSchemeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionPackage getExpressionPackage() {
		return (ExpressionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpressionPackage getPackage() {
		return ExpressionPackage.eINSTANCE;
	}

} //ExpressionFactoryImpl
