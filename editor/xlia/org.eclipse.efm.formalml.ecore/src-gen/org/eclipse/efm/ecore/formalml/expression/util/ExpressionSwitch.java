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
package org.eclipse.efm.ecore.formalml.expression.util;

import org.eclipse.efm.ecore.formalml.common.AbstractElement;

import org.eclipse.efm.ecore.formalml.expression.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage
 * @generated
 */
public class ExpressionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionPackage.VALUE_EXPRESSION_PRETTY_PRINTER: {
				ValueExpressionPrettyPrinter valueExpressionPrettyPrinter = (ValueExpressionPrettyPrinter)theEObject;
				T result = caseValueExpressionPrettyPrinter(valueExpressionPrettyPrinter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.VALUE_PRINTABLE_EXPRESSION: {
				ValuePrintableExpression valuePrintableExpression = (ValuePrintableExpression)theEObject;
				T result = caseValuePrintableExpression(valuePrintableExpression);
				if (result == null) result = caseExpression(valuePrintableExpression);
				if (result == null) result = caseAbstractElement(valuePrintableExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseAbstractElement(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_EXPRESSION: {
				LiteralExpression literalExpression = (LiteralExpression)theEObject;
				T result = caseLiteralExpression(literalExpression);
				if (result == null) result = caseExpression(literalExpression);
				if (result == null) result = caseAbstractElement(literalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_BOOLEAN_EXPRESSION: {
				LiteralBooleanExpression literalBooleanExpression = (LiteralBooleanExpression)theEObject;
				T result = caseLiteralBooleanExpression(literalBooleanExpression);
				if (result == null) result = caseLiteralExpression(literalBooleanExpression);
				if (result == null) result = caseExpression(literalBooleanExpression);
				if (result == null) result = caseAbstractElement(literalBooleanExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_INTEGER_EXPRESSION: {
				LiteralIntegerExpression literalIntegerExpression = (LiteralIntegerExpression)theEObject;
				T result = caseLiteralIntegerExpression(literalIntegerExpression);
				if (result == null) result = caseLiteralExpression(literalIntegerExpression);
				if (result == null) result = caseExpression(literalIntegerExpression);
				if (result == null) result = caseAbstractElement(literalIntegerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_RATIONAL_EXPRESSION: {
				LiteralRationalExpression literalRationalExpression = (LiteralRationalExpression)theEObject;
				T result = caseLiteralRationalExpression(literalRationalExpression);
				if (result == null) result = caseLiteralExpression(literalRationalExpression);
				if (result == null) result = caseExpression(literalRationalExpression);
				if (result == null) result = caseAbstractElement(literalRationalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_FLOAT_EXPRESSION: {
				LiteralFloatExpression literalFloatExpression = (LiteralFloatExpression)theEObject;
				T result = caseLiteralFloatExpression(literalFloatExpression);
				if (result == null) result = caseLiteralExpression(literalFloatExpression);
				if (result == null) result = caseExpression(literalFloatExpression);
				if (result == null) result = caseAbstractElement(literalFloatExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_REAL_EXPRESSION: {
				LiteralRealExpression literalRealExpression = (LiteralRealExpression)theEObject;
				T result = caseLiteralRealExpression(literalRealExpression);
				if (result == null) result = caseLiteralExpression(literalRealExpression);
				if (result == null) result = caseExpression(literalRealExpression);
				if (result == null) result = caseAbstractElement(literalRealExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_CHARACTER_EXPRESSION: {
				LiteralCharacterExpression literalCharacterExpression = (LiteralCharacterExpression)theEObject;
				T result = caseLiteralCharacterExpression(literalCharacterExpression);
				if (result == null) result = caseLiteralExpression(literalCharacterExpression);
				if (result == null) result = caseExpression(literalCharacterExpression);
				if (result == null) result = caseAbstractElement(literalCharacterExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_STRING_EXPRESSION: {
				LiteralStringExpression literalStringExpression = (LiteralStringExpression)theEObject;
				T result = caseLiteralStringExpression(literalStringExpression);
				if (result == null) result = caseLiteralExpression(literalStringExpression);
				if (result == null) result = caseExpression(literalStringExpression);
				if (result == null) result = caseAbstractElement(literalStringExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_COLLECTION_EXPRESSION: {
				LiteralCollectionExpression literalCollectionExpression = (LiteralCollectionExpression)theEObject;
				T result = caseLiteralCollectionExpression(literalCollectionExpression);
				if (result == null) result = caseLiteralExpression(literalCollectionExpression);
				if (result == null) result = caseExpression(literalCollectionExpression);
				if (result == null) result = caseAbstractElement(literalCollectionExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_NULL_EXPRESSION: {
				LiteralNullExpression literalNullExpression = (LiteralNullExpression)theEObject;
				T result = caseLiteralNullExpression(literalNullExpression);
				if (result == null) result = caseLiteralExpression(literalNullExpression);
				if (result == null) result = caseExpression(literalNullExpression);
				if (result == null) result = caseAbstractElement(literalNullExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_REFERENCE_EXPRESSION: {
				LiteralReferenceExpression literalReferenceExpression = (LiteralReferenceExpression)theEObject;
				T result = caseLiteralReferenceExpression(literalReferenceExpression);
				if (result == null) result = caseLiteralExpression(literalReferenceExpression);
				if (result == null) result = caseExpression(literalReferenceExpression);
				if (result == null) result = caseAbstractElement(literalReferenceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_REFERENCE_ELEMENT: {
				LiteralReferenceElement literalReferenceElement = (LiteralReferenceElement)theEObject;
				T result = caseLiteralReferenceElement(literalReferenceElement);
				if (result == null) result = caseLiteralReferenceExpression(literalReferenceElement);
				if (result == null) result = caseLiteralExpression(literalReferenceElement);
				if (result == null) result = caseExpression(literalReferenceElement);
				if (result == null) result = caseAbstractElement(literalReferenceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_THIS_EXPRESSION: {
				LiteralThisExpression literalThisExpression = (LiteralThisExpression)theEObject;
				T result = caseLiteralThisExpression(literalThisExpression);
				if (result == null) result = caseLiteralReferenceExpression(literalThisExpression);
				if (result == null) result = caseLiteralExpression(literalThisExpression);
				if (result == null) result = caseExpression(literalThisExpression);
				if (result == null) result = caseAbstractElement(literalThisExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_SELF_EXPRESSION: {
				LiteralSelfExpression literalSelfExpression = (LiteralSelfExpression)theEObject;
				T result = caseLiteralSelfExpression(literalSelfExpression);
				if (result == null) result = caseLiteralReferenceExpression(literalSelfExpression);
				if (result == null) result = caseLiteralExpression(literalSelfExpression);
				if (result == null) result = caseExpression(literalSelfExpression);
				if (result == null) result = caseAbstractElement(literalSelfExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_PARENT_EXPRESSION: {
				LiteralParentExpression literalParentExpression = (LiteralParentExpression)theEObject;
				T result = caseLiteralParentExpression(literalParentExpression);
				if (result == null) result = caseLiteralReferenceExpression(literalParentExpression);
				if (result == null) result = caseLiteralExpression(literalParentExpression);
				if (result == null) result = caseExpression(literalParentExpression);
				if (result == null) result = caseAbstractElement(literalParentExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_SUPER_EXPRESSION: {
				LiteralSuperExpression literalSuperExpression = (LiteralSuperExpression)theEObject;
				T result = caseLiteralSuperExpression(literalSuperExpression);
				if (result == null) result = caseLiteralReferenceExpression(literalSuperExpression);
				if (result == null) result = caseLiteralExpression(literalSuperExpression);
				if (result == null) result = caseExpression(literalSuperExpression);
				if (result == null) result = caseAbstractElement(literalSuperExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_SYSTEM_EXPRESSION: {
				LiteralSystemExpression literalSystemExpression = (LiteralSystemExpression)theEObject;
				T result = caseLiteralSystemExpression(literalSystemExpression);
				if (result == null) result = caseLiteralReferenceExpression(literalSystemExpression);
				if (result == null) result = caseLiteralExpression(literalSystemExpression);
				if (result == null) result = caseExpression(literalSystemExpression);
				if (result == null) result = caseAbstractElement(literalSystemExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_ENV_EXPRESSION: {
				LiteralEnvExpression literalEnvExpression = (LiteralEnvExpression)theEObject;
				T result = caseLiteralEnvExpression(literalEnvExpression);
				if (result == null) result = caseLiteralReferenceExpression(literalEnvExpression);
				if (result == null) result = caseLiteralExpression(literalEnvExpression);
				if (result == null) result = caseExpression(literalEnvExpression);
				if (result == null) result = caseAbstractElement(literalEnvExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_TIME_EXPRESSION: {
				LiteralTimeExpression literalTimeExpression = (LiteralTimeExpression)theEObject;
				T result = caseLiteralTimeExpression(literalTimeExpression);
				if (result == null) result = caseLiteralReferenceExpression(literalTimeExpression);
				if (result == null) result = caseLiteralExpression(literalTimeExpression);
				if (result == null) result = caseExpression(literalTimeExpression);
				if (result == null) result = caseAbstractElement(literalTimeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_TIME_DELTA_EXPRESSION: {
				LiteralTimeDeltaExpression literalTimeDeltaExpression = (LiteralTimeDeltaExpression)theEObject;
				T result = caseLiteralTimeDeltaExpression(literalTimeDeltaExpression);
				if (result == null) result = caseLiteralReferenceExpression(literalTimeDeltaExpression);
				if (result == null) result = caseLiteralExpression(literalTimeDeltaExpression);
				if (result == null) result = caseExpression(literalTimeDeltaExpression);
				if (result == null) result = caseAbstractElement(literalTimeDeltaExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LEFT_HAND_SIDE_EXPRESSION: {
				LeftHandSideExpression leftHandSideExpression = (LeftHandSideExpression)theEObject;
				T result = caseLeftHandSideExpression(leftHandSideExpression);
				if (result == null) result = caseExpression(leftHandSideExpression);
				if (result == null) result = caseAbstractElement(leftHandSideExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.INCREMENT_OR_DECREMENT_EXPRESSION: {
				IncrementOrDecrementExpression incrementOrDecrementExpression = (IncrementOrDecrementExpression)theEObject;
				T result = caseIncrementOrDecrementExpression(incrementOrDecrementExpression);
				if (result == null) result = caseExpression(incrementOrDecrementExpression);
				if (result == null) result = caseAbstractElement(incrementOrDecrementExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION: {
				IncrementOrDecrementPrefixExpression incrementOrDecrementPrefixExpression = (IncrementOrDecrementPrefixExpression)theEObject;
				T result = caseIncrementOrDecrementPrefixExpression(incrementOrDecrementPrefixExpression);
				if (result == null) result = caseIncrementOrDecrementExpression(incrementOrDecrementPrefixExpression);
				if (result == null) result = caseExpression(incrementOrDecrementPrefixExpression);
				if (result == null) result = caseAbstractElement(incrementOrDecrementPrefixExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION: {
				IncrementOrDecrementPostfixExpression incrementOrDecrementPostfixExpression = (IncrementOrDecrementPostfixExpression)theEObject;
				T result = caseIncrementOrDecrementPostfixExpression(incrementOrDecrementPostfixExpression);
				if (result == null) result = caseIncrementOrDecrementExpression(incrementOrDecrementPostfixExpression);
				if (result == null) result = caseExpression(incrementOrDecrementPostfixExpression);
				if (result == null) result = caseAbstractElement(incrementOrDecrementPostfixExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ASSIGNMENT_EXPRESSION: {
				AssignmentExpression assignmentExpression = (AssignmentExpression)theEObject;
				T result = caseAssignmentExpression(assignmentExpression);
				if (result == null) result = caseExpression(assignmentExpression);
				if (result == null) result = caseAbstractElement(assignmentExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.NEWFRESH_EXPRESSION: {
				NewfreshExpression newfreshExpression = (NewfreshExpression)theEObject;
				T result = caseNewfreshExpression(newfreshExpression);
				if (result == null) result = caseExpression(newfreshExpression);
				if (result == null) result = caseAbstractElement(newfreshExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = caseAbstractElement(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.BITWISE_UNARY_EXPRESSION: {
				BitwiseUnaryExpression bitwiseUnaryExpression = (BitwiseUnaryExpression)theEObject;
				T result = caseBitwiseUnaryExpression(bitwiseUnaryExpression);
				if (result == null) result = caseUnaryExpression(bitwiseUnaryExpression);
				if (result == null) result = caseExpression(bitwiseUnaryExpression);
				if (result == null) result = caseAbstractElement(bitwiseUnaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LOGICAL_UNARY_EXPRESSION: {
				LogicalUnaryExpression logicalUnaryExpression = (LogicalUnaryExpression)theEObject;
				T result = caseLogicalUnaryExpression(logicalUnaryExpression);
				if (result == null) result = caseUnaryExpression(logicalUnaryExpression);
				if (result == null) result = caseExpression(logicalUnaryExpression);
				if (result == null) result = caseAbstractElement(logicalUnaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.CAST_EXPRESSION: {
				CastExpression castExpression = (CastExpression)theEObject;
				T result = caseCastExpression(castExpression);
				if (result == null) result = caseUnaryExpression(castExpression);
				if (result == null) result = caseExpression(castExpression);
				if (result == null) result = caseAbstractElement(castExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ARITHMETIC_UNARY_EXPRESSION: {
				ArithmeticUnaryExpression arithmeticUnaryExpression = (ArithmeticUnaryExpression)theEObject;
				T result = caseArithmeticUnaryExpression(arithmeticUnaryExpression);
				if (result == null) result = caseUnaryExpression(arithmeticUnaryExpression);
				if (result == null) result = caseExpression(arithmeticUnaryExpression);
				if (result == null) result = caseAbstractElement(arithmeticUnaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.BINARY_EXPRESSION: {
				BinaryExpression binaryExpression = (BinaryExpression)theEObject;
				T result = caseBinaryExpression(binaryExpression);
				if (result == null) result = caseExpression(binaryExpression);
				if (result == null) result = caseAbstractElement(binaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.EQUALITY_BINARY_EXPRESSION: {
				EqualityBinaryExpression equalityBinaryExpression = (EqualityBinaryExpression)theEObject;
				T result = caseEqualityBinaryExpression(equalityBinaryExpression);
				if (result == null) result = caseBinaryExpression(equalityBinaryExpression);
				if (result == null) result = caseExpression(equalityBinaryExpression);
				if (result == null) result = caseAbstractElement(equalityBinaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.RELATIONAL_BINARY_EXPRESSION: {
				RelationalBinaryExpression relationalBinaryExpression = (RelationalBinaryExpression)theEObject;
				T result = caseRelationalBinaryExpression(relationalBinaryExpression);
				if (result == null) result = caseBinaryExpression(relationalBinaryExpression);
				if (result == null) result = caseExpression(relationalBinaryExpression);
				if (result == null) result = caseAbstractElement(relationalBinaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.RELATIONAL_TERNARY_EXPRESSION: {
				RelationalTernaryExpression relationalTernaryExpression = (RelationalTernaryExpression)theEObject;
				T result = caseRelationalTernaryExpression(relationalTernaryExpression);
				if (result == null) result = caseExpression(relationalTernaryExpression);
				if (result == null) result = caseAbstractElement(relationalTernaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.CONDITIONAL_TEST_EXPRESSION: {
				ConditionalTestExpression conditionalTestExpression = (ConditionalTestExpression)theEObject;
				T result = caseConditionalTestExpression(conditionalTestExpression);
				if (result == null) result = caseExpression(conditionalTestExpression);
				if (result == null) result = caseAbstractElement(conditionalTestExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ASSOCIATIVE_EXPRESSION: {
				AssociativeExpression associativeExpression = (AssociativeExpression)theEObject;
				T result = caseAssociativeExpression(associativeExpression);
				if (result == null) result = caseExpression(associativeExpression);
				if (result == null) result = caseAbstractElement(associativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ARITHMETIC_ASSOCIATIVE_EXPRESSION: {
				ArithmeticAssociativeExpression arithmeticAssociativeExpression = (ArithmeticAssociativeExpression)theEObject;
				T result = caseArithmeticAssociativeExpression(arithmeticAssociativeExpression);
				if (result == null) result = caseAssociativeExpression(arithmeticAssociativeExpression);
				if (result == null) result = caseExpression(arithmeticAssociativeExpression);
				if (result == null) result = caseAbstractElement(arithmeticAssociativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.BITWISE_ASSOCIATIVE_EXPRESSION: {
				BitwiseAssociativeExpression bitwiseAssociativeExpression = (BitwiseAssociativeExpression)theEObject;
				T result = caseBitwiseAssociativeExpression(bitwiseAssociativeExpression);
				if (result == null) result = caseAssociativeExpression(bitwiseAssociativeExpression);
				if (result == null) result = caseExpression(bitwiseAssociativeExpression);
				if (result == null) result = caseAbstractElement(bitwiseAssociativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LOGICAL_ASSOCIATIVE_EXPRESSION: {
				LogicalAssociativeExpression logicalAssociativeExpression = (LogicalAssociativeExpression)theEObject;
				T result = caseLogicalAssociativeExpression(logicalAssociativeExpression);
				if (result == null) result = caseAssociativeExpression(logicalAssociativeExpression);
				if (result == null) result = caseExpression(logicalAssociativeExpression);
				if (result == null) result = caseAbstractElement(logicalAssociativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.INVOKE_EXPRESSION: {
				InvokeExpression invokeExpression = (InvokeExpression)theEObject;
				T result = caseInvokeExpression(invokeExpression);
				if (result == null) result = caseExpression(invokeExpression);
				if (result == null) result = caseAbstractElement(invokeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.NAMED_EXPRESSION: {
				NamedExpression namedExpression = (NamedExpression)theEObject;
				T result = caseNamedExpression(namedExpression);
				if (result == null) result = caseExpression(namedExpression);
				if (result == null) result = caseAbstractElement(namedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.TUPLE_EXPRESSION: {
				TupleExpression tupleExpression = (TupleExpression)theEObject;
				T result = caseTupleExpression(tupleExpression);
				if (result == null) result = caseExpression(tupleExpression);
				if (result == null) result = caseAbstractElement(tupleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.MIX_TUPLE_EXPRESSION: {
				MixTupleExpression mixTupleExpression = (MixTupleExpression)theEObject;
				T result = caseMixTupleExpression(mixTupleExpression);
				if (result == null) result = caseTupleExpression(mixTupleExpression);
				if (result == null) result = caseExpression(mixTupleExpression);
				if (result == null) result = caseAbstractElement(mixTupleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.NAMED_TUPLE_EXPRESSION: {
				NamedTupleExpression namedTupleExpression = (NamedTupleExpression)theEObject;
				T result = caseNamedTupleExpression(namedTupleExpression);
				if (result == null) result = caseTupleExpression(namedTupleExpression);
				if (result == null) result = caseExpression(namedTupleExpression);
				if (result == null) result = caseAbstractElement(namedTupleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.POSITIONAL_TUPLE_EXPRESSION: {
				PositionalTupleExpression positionalTupleExpression = (PositionalTupleExpression)theEObject;
				T result = casePositionalTupleExpression(positionalTupleExpression);
				if (result == null) result = caseTupleExpression(positionalTupleExpression);
				if (result == null) result = caseExpression(positionalTupleExpression);
				if (result == null) result = caseAbstractElement(positionalTupleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION: {
				ValueElementSpecification valueElementSpecification = (ValueElementSpecification)theEObject;
				T result = caseValueElementSpecification(valueElementSpecification);
				if (result == null) result = caseExpression(valueElementSpecification);
				if (result == null) result = caseAbstractElement(valueElementSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.INSTANTIATION_EXPRESSION: {
				InstantiationExpression instantiationExpression = (InstantiationExpression)theEObject;
				T result = caseInstantiationExpression(instantiationExpression);
				if (result == null) result = caseExpression(instantiationExpression);
				if (result == null) result = caseAbstractElement(instantiationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.EXPRESSION_AS_BUFFER: {
				ExpressionAsBuffer expressionAsBuffer = (ExpressionAsBuffer)theEObject;
				T result = caseExpressionAsBuffer(expressionAsBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.EXPRESSION_AS_CHANNEL: {
				ExpressionAsChannel expressionAsChannel = (ExpressionAsChannel)theEObject;
				T result = caseExpressionAsChannel(expressionAsChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.EXPRESSION_AS_MACHINE: {
				ExpressionAsMachine expressionAsMachine = (ExpressionAsMachine)theEObject;
				T result = caseExpressionAsMachine(expressionAsMachine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.EXPRESSION_AS_PORT: {
				ExpressionAsPort expressionAsPort = (ExpressionAsPort)theEObject;
				T result = caseExpressionAsPort(expressionAsPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Expression Pretty Printer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Expression Pretty Printer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueExpressionPrettyPrinter(ValueExpressionPrettyPrinter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Printable Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Printable Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValuePrintableExpression(ValuePrintableExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpression(LiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralBooleanExpression(LiteralBooleanExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Integer Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Integer Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralIntegerExpression(LiteralIntegerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Rational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Rational Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralRationalExpression(LiteralRationalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Float Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Float Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralFloatExpression(LiteralFloatExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Real Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Real Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralRealExpression(LiteralRealExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Character Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Character Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralCharacterExpression(LiteralCharacterExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal String Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal String Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralStringExpression(LiteralStringExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Collection Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Collection Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralCollectionExpression(LiteralCollectionExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Null Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Null Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralNullExpression(LiteralNullExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Reference Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Reference Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralReferenceExpression(LiteralReferenceExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Reference Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Reference Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralReferenceElement(LiteralReferenceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal This Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralThisExpression(LiteralThisExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Self Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Self Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralSelfExpression(LiteralSelfExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Parent Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Parent Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralParentExpression(LiteralParentExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Super Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Super Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralSuperExpression(LiteralSuperExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal System Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal System Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralSystemExpression(LiteralSystemExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Env Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Env Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralEnvExpression(LiteralEnvExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Time Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Time Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralTimeExpression(LiteralTimeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Time Delta Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Time Delta Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralTimeDeltaExpression(LiteralTimeDeltaExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Left Hand Side Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Left Hand Side Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeftHandSideExpression(LeftHandSideExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Increment Or Decrement Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncrementOrDecrementExpression(IncrementOrDecrementExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Increment Or Decrement Prefix Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Increment Or Decrement Prefix Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncrementOrDecrementPrefixExpression(IncrementOrDecrementPrefixExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Increment Or Decrement Postfix Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Increment Or Decrement Postfix Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncrementOrDecrementPostfixExpression(IncrementOrDecrementPostfixExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignmentExpression(AssignmentExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Newfresh Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Newfresh Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewfreshExpression(NewfreshExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bitwise Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bitwise Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBitwiseUnaryExpression(BitwiseUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalUnaryExpression(LogicalUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cast Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCastExpression(CastExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arithmetic Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arithmetic Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArithmeticUnaryExpression(ArithmeticUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryExpression(BinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equality Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equality Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualityBinaryExpression(EqualityBinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalBinaryExpression(RelationalBinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Ternary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Ternary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalTernaryExpression(RelationalTernaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Test Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalTestExpression(ConditionalTestExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Associative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Associative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociativeExpression(AssociativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arithmetic Associative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arithmetic Associative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArithmeticAssociativeExpression(ArithmeticAssociativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bitwise Associative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bitwise Associative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBitwiseAssociativeExpression(BitwiseAssociativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Associative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Associative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalAssociativeExpression(LogicalAssociativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeExpression(InvokeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedExpression(NamedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleExpression(TupleExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mix Tuple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mix Tuple Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMixTupleExpression(MixTupleExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Tuple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Tuple Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedTupleExpression(NamedTupleExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Positional Tuple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Positional Tuple Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePositionalTupleExpression(PositionalTupleExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Element Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Element Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueElementSpecification(ValueElementSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstantiationExpression(InstantiationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>As Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>As Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionAsBuffer(ExpressionAsBuffer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>As Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>As Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionAsChannel(ExpressionAsChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>As Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>As Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionAsMachine(ExpressionAsMachine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>As Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>As Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionAsPort(ExpressionAsPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractElement(AbstractElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ExpressionSwitch
