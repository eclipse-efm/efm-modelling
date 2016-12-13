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
package org.eclipse.efm.ecore.formalml.expression;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage
 * @generated
 */
public interface ExpressionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionFactory eINSTANCE = org.eclipse.efm.ecore.formalml.expression.impl.ExpressionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Value Printable Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Printable Expression</em>'.
	 * @generated
	 */
	ValuePrintableExpression createValuePrintableExpression();

	/**
	 * Returns a new object of class '<em>Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Expression</em>'.
	 * @generated
	 */
	LiteralExpression createLiteralExpression();

	/**
	 * Returns a new object of class '<em>Literal Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Boolean Expression</em>'.
	 * @generated
	 */
	LiteralBooleanExpression createLiteralBooleanExpression();

	/**
	 * Returns a new object of class '<em>Literal Integer Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Integer Expression</em>'.
	 * @generated
	 */
	LiteralIntegerExpression createLiteralIntegerExpression();

	/**
	 * Returns a new object of class '<em>Literal Rational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Rational Expression</em>'.
	 * @generated
	 */
	LiteralRationalExpression createLiteralRationalExpression();

	/**
	 * Returns a new object of class '<em>Literal Float Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Float Expression</em>'.
	 * @generated
	 */
	LiteralFloatExpression createLiteralFloatExpression();

	/**
	 * Returns a new object of class '<em>Literal Real Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Real Expression</em>'.
	 * @generated
	 */
	LiteralRealExpression createLiteralRealExpression();

	/**
	 * Returns a new object of class '<em>Literal Character Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Character Expression</em>'.
	 * @generated
	 */
	LiteralCharacterExpression createLiteralCharacterExpression();

	/**
	 * Returns a new object of class '<em>Literal String Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal String Expression</em>'.
	 * @generated
	 */
	LiteralStringExpression createLiteralStringExpression();

	/**
	 * Returns a new object of class '<em>Literal Collection Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Collection Expression</em>'.
	 * @generated
	 */
	LiteralCollectionExpression createLiteralCollectionExpression();

	/**
	 * Returns a new object of class '<em>Literal Null Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Null Expression</em>'.
	 * @generated
	 */
	LiteralNullExpression createLiteralNullExpression();

	/**
	 * Returns a new object of class '<em>Literal Reference Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Reference Expression</em>'.
	 * @generated
	 */
	LiteralReferenceExpression createLiteralReferenceExpression();

	/**
	 * Returns a new object of class '<em>Literal Reference Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Reference Element</em>'.
	 * @generated
	 */
	LiteralReferenceElement createLiteralReferenceElement();

	/**
	 * Returns a new object of class '<em>Literal This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal This Expression</em>'.
	 * @generated
	 */
	LiteralThisExpression createLiteralThisExpression();

	/**
	 * Returns a new object of class '<em>Literal Self Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Self Expression</em>'.
	 * @generated
	 */
	LiteralSelfExpression createLiteralSelfExpression();

	/**
	 * Returns a new object of class '<em>Literal Parent Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Parent Expression</em>'.
	 * @generated
	 */
	LiteralParentExpression createLiteralParentExpression();

	/**
	 * Returns a new object of class '<em>Literal Super Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Super Expression</em>'.
	 * @generated
	 */
	LiteralSuperExpression createLiteralSuperExpression();

	/**
	 * Returns a new object of class '<em>Literal System Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal System Expression</em>'.
	 * @generated
	 */
	LiteralSystemExpression createLiteralSystemExpression();

	/**
	 * Returns a new object of class '<em>Literal Env Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Env Expression</em>'.
	 * @generated
	 */
	LiteralEnvExpression createLiteralEnvExpression();

	/**
	 * Returns a new object of class '<em>Literal Time Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Time Expression</em>'.
	 * @generated
	 */
	LiteralTimeExpression createLiteralTimeExpression();

	/**
	 * Returns a new object of class '<em>Literal Time Delta Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Time Delta Expression</em>'.
	 * @generated
	 */
	LiteralTimeDeltaExpression createLiteralTimeDeltaExpression();

	/**
	 * Returns a new object of class '<em>Left Hand Side Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Left Hand Side Expression</em>'.
	 * @generated
	 */
	LeftHandSideExpression createLeftHandSideExpression();

	/**
	 * Returns a new object of class '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Increment Or Decrement Expression</em>'.
	 * @generated
	 */
	IncrementOrDecrementExpression createIncrementOrDecrementExpression();

	/**
	 * Returns a new object of class '<em>Increment Or Decrement Prefix Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Increment Or Decrement Prefix Expression</em>'.
	 * @generated
	 */
	IncrementOrDecrementPrefixExpression createIncrementOrDecrementPrefixExpression();

	/**
	 * Returns a new object of class '<em>Increment Or Decrement Postfix Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Increment Or Decrement Postfix Expression</em>'.
	 * @generated
	 */
	IncrementOrDecrementPostfixExpression createIncrementOrDecrementPostfixExpression();

	/**
	 * Returns a new object of class '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment Expression</em>'.
	 * @generated
	 */
	AssignmentExpression createAssignmentExpression();

	/**
	 * Returns a new object of class '<em>Newfresh Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Newfresh Expression</em>'.
	 * @generated
	 */
	NewfreshExpression createNewfreshExpression();

	/**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
	UnaryExpression createUnaryExpression();

	/**
	 * Returns a new object of class '<em>Bitwise Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bitwise Unary Expression</em>'.
	 * @generated
	 */
	BitwiseUnaryExpression createBitwiseUnaryExpression();

	/**
	 * Returns a new object of class '<em>Logical Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Unary Expression</em>'.
	 * @generated
	 */
	LogicalUnaryExpression createLogicalUnaryExpression();

	/**
	 * Returns a new object of class '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cast Expression</em>'.
	 * @generated
	 */
	CastExpression createCastExpression();

	/**
	 * Returns a new object of class '<em>Arithmetic Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arithmetic Unary Expression</em>'.
	 * @generated
	 */
	ArithmeticUnaryExpression createArithmeticUnaryExpression();

	/**
	 * Returns a new object of class '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Expression</em>'.
	 * @generated
	 */
	BinaryExpression createBinaryExpression();

	/**
	 * Returns a new object of class '<em>Equality Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Binary Expression</em>'.
	 * @generated
	 */
	EqualityBinaryExpression createEqualityBinaryExpression();

	/**
	 * Returns a new object of class '<em>Relational Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Binary Expression</em>'.
	 * @generated
	 */
	RelationalBinaryExpression createRelationalBinaryExpression();

	/**
	 * Returns a new object of class '<em>Relational Ternary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Ternary Expression</em>'.
	 * @generated
	 */
	RelationalTernaryExpression createRelationalTernaryExpression();

	/**
	 * Returns a new object of class '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Test Expression</em>'.
	 * @generated
	 */
	ConditionalTestExpression createConditionalTestExpression();

	/**
	 * Returns a new object of class '<em>Associative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Associative Expression</em>'.
	 * @generated
	 */
	AssociativeExpression createAssociativeExpression();

	/**
	 * Returns a new object of class '<em>Arithmetic Associative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arithmetic Associative Expression</em>'.
	 * @generated
	 */
	ArithmeticAssociativeExpression createArithmeticAssociativeExpression();

	/**
	 * Returns a new object of class '<em>Bitwise Associative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bitwise Associative Expression</em>'.
	 * @generated
	 */
	BitwiseAssociativeExpression createBitwiseAssociativeExpression();

	/**
	 * Returns a new object of class '<em>Logical Associative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Associative Expression</em>'.
	 * @generated
	 */
	LogicalAssociativeExpression createLogicalAssociativeExpression();

	/**
	 * Returns a new object of class '<em>Invoke Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Expression</em>'.
	 * @generated
	 */
	InvokeExpression createInvokeExpression();

	/**
	 * Returns a new object of class '<em>Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Expression</em>'.
	 * @generated
	 */
	NamedExpression createNamedExpression();

	/**
	 * Returns a new object of class '<em>Mix Tuple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mix Tuple Expression</em>'.
	 * @generated
	 */
	MixTupleExpression createMixTupleExpression();

	/**
	 * Returns a new object of class '<em>Named Tuple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Tuple Expression</em>'.
	 * @generated
	 */
	NamedTupleExpression createNamedTupleExpression();

	/**
	 * Returns a new object of class '<em>Positional Tuple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Positional Tuple Expression</em>'.
	 * @generated
	 */
	PositionalTupleExpression createPositionalTupleExpression();

	/**
	 * Returns a new object of class '<em>Value Element Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Element Specification</em>'.
	 * @generated
	 */
	ValueElementSpecification createValueElementSpecification();

	/**
	 * Returns a new object of class '<em>Instantiation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instantiation Expression</em>'.
	 * @generated
	 */
	InstantiationExpression createInstantiationExpression();

	/**
	 * Returns a new object of class '<em>As Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As Buffer</em>'.
	 * @generated
	 */
	ExpressionAsBuffer createExpressionAsBuffer();

	/**
	 * Returns a new object of class '<em>As Channel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As Channel</em>'.
	 * @generated
	 */
	ExpressionAsChannel createExpressionAsChannel();

	/**
	 * Returns a new object of class '<em>As Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As Machine</em>'.
	 * @generated
	 */
	ExpressionAsMachine createExpressionAsMachine();

	/**
	 * Returns a new object of class '<em>As Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As Port</em>'.
	 * @generated
	 */
	ExpressionAsPort createExpressionAsPort();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionPackage getExpressionPackage();

} //ExpressionFactory
