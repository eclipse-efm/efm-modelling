/*******************************************************************************
 * Copyright (c) 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.formalml.ecore.factory;

import java.util.List;

import org.eclipse.efm.ecore.formalml.common.NamedElement;
import org.eclipse.efm.ecore.formalml.datatype.DataType;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression;
import org.eclipse.efm.ecore.formalml.expression.BinaryExpression;
import org.eclipse.efm.ecore.formalml.expression.CastExpression;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.ExpressionFactory;
import org.eclipse.efm.ecore.formalml.expression.InvokeExpression;
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement;
import org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression;
import org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression;
import org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression;
import org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression;
import org.eclipse.efm.ecore.formalml.expression.UnaryExpression;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;

public class XLIA_EXPRESSION {

	public final static String OP_ASSIGN  = "="  ;

	public final static String OP_PUSH    = "<=<";
	public final static String OP_POP     = ">=>";

	public final static String OP_PLUS    = "+" ;
	public final static String OP_MINUS   = "-" ;
	public final static String OP_MULT    = "*" ;
	public final static String OP_DIV     = "/" ;
	public final static String OP_MODULO  = "%" ;

	public final static String OP_GT      = ">" ;
	public final static String OP_GTE     = ">=";

	public final static String OP_LT      = "<" ;
	public final static String OP_LTE     = "<=";

	public final static String OP_EQ      = "==";
	public final static String OP_NOT_EQ  = "!=";

	public final static String OP_SEQ     = "===";
	public final static String OP_NOT_SEQ = "=/=";

	public final static String OP_AND     = "&&";
	public final static String OP_OR      = "||";


	public static final NamedElement SINGLETON = XLIA_INFRA.createFunction("singleton");

	public static final NamedElement POPULATED = XLIA_INFRA.createFunction("populated");

	public static final NamedElement SIZE = XLIA_INFRA.createFunction("size");


	// ExpressionFactory FACTORY
	static ExpressionFactory FACTORY = ExpressionFactory.eINSTANCE;

	// BOOLEAN VALUE
	public static LiteralBooleanExpression createBoolean(final boolean value) {
		final LiteralBooleanExpression expression =
				FACTORY.createLiteralBooleanExpression();

		expression.setValue(value);

		return expression;
	}


	public static LiteralBooleanExpression createExpression(final boolean value) {
		return createBoolean(value);
	}


	public static LiteralBooleanExpression trueValue() {
		return createBoolean(true);
	}

	public static LiteralBooleanExpression falseValue() {
		return createBoolean(false);
	}


	// INTEGER VALUE
	public static LiteralIntegerExpression createInteger(final long value) {
		final LiteralIntegerExpression expression =
				FACTORY.createLiteralIntegerExpression();

		expression.setValue(value);

		return expression;
	}

	public static LiteralIntegerExpression zero() {
		return createInteger(0);
	}

	public static LiteralIntegerExpression createExpression(final long value) {
		return createInteger(value);
	}


	// RATIONAL VALUE
	public static LiteralRationalExpression createRational(
			final long numerator, final long denominator) {
		final LiteralRationalExpression expression =
				FACTORY.createLiteralRationalExpression();

		expression.setNumerator(numerator);
		expression.setDenominator(denominator);

		return expression;
	}

	public static LiteralRationalExpression createExpression(
			final long numerator, final long denominator) {
		return createRational(numerator, denominator);
	}

	// STRING VALUE
	public static LiteralStringExpression createString(final String value) {
		final LiteralStringExpression expression =
				FACTORY.createLiteralStringExpression();

		expression.setValue(value);

		return expression;
	}

	public static LiteralStringExpression createExpression(final String value) {
		return createString(value);
	}

	// ELEMENT REFERENCE
	public static LiteralReferenceElement createExpression(
			final NamedElement element) {
		final LiteralReferenceElement expression =
				FACTORY.createLiteralReferenceElement();

		expression.setElement(element);

		return expression;
	}

	public static ValueElementSpecification createExpression(
			final Machine machine, final NamedElement element) {
		final ValueElementSpecification expression =
				FACTORY.createValueElementSpecification();

		expression.setParent( createExpression(machine) );

		expression.setKind( ValueElementSpecificationKind.FIELD );
		expression.setElement(element);

		return expression;
	}

	// ELEMENT REFERENCE
	public static LiteralReferenceElement createArrayElement(
			final NamedElement element, final NamedElement index) {
		final LiteralReferenceElement expression =
				FACTORY.createLiteralReferenceElement();

		expression.setKind(ValueElementSpecificationKind.INDEX);

		expression.setElement(element);

		expression.setArg(createExpression(index));

		return expression;
	}

	// ELEMENT LVALUE
	public static LeftHandSideExpression createLValue(
			final Expression lvalue) {
		final LeftHandSideExpression expression =
				FACTORY.createLeftHandSideExpression();

		expression.setLvalue( lvalue );

		return expression;
	}

	public static LeftHandSideExpression createLValue(
			final PropertyDefinition element)
	{
		return createLValue( createExpression(element) );
	}

	public static LeftHandSideExpression createLValue(
			final Machine machine, final PropertyDefinition element)
	{
		return createLValue( createExpression(machine, element) );
	}


	// ASSIGNMENT
	public static Expression createAssignment(final String assignOp,
			final LeftHandSideExpression lvalue, final Expression rvalue) {
		final AssignmentExpression expression =
				FACTORY.createAssignmentExpression();

		expression.setOperator(assignOp);

		expression.setLeftHandSide(lvalue);

		expression.setRightHandSide(rvalue);

		return expression;
	}

	public static Expression createAssignment(final String assignOp,
			final PropertyDefinition variable, final Expression rvalue) {

		return createAssignment(assignOp, createLValue(variable), rvalue);
	}

	public static Expression createAssignment(
			final PropertyDefinition variable, final Expression rvalue) {

		return createAssignment(OP_ASSIGN, createLValue(variable), rvalue);
	}

	public static Expression createAssignment(final Machine machine,
			final PropertyDefinition variable, final Expression rvalue) {

		return createAssignment(OP_ASSIGN,
				createLValue(machine, variable), rvalue);
	}

	public static Expression createIncrementation(
			final PropertyDefinition variable, final Expression rvalue) {
		final AssignmentExpression expression =
				FACTORY.createAssignmentExpression();

		expression.setOperator(OP_ASSIGN);

		expression.setLeftHandSide( createLValue(variable) );

		expression.setRightHandSide(
				createExpression(OP_PLUS, variable, rvalue));

		return expression;
	}

	public static Expression createDecrementation(
			final PropertyDefinition variable, final Expression rvalue) {
		final AssignmentExpression expression =
				FACTORY.createAssignmentExpression();

		expression.setOperator(OP_ASSIGN);

		expression.setLeftHandSide( createLValue(variable) );

		expression.setRightHandSide(
				createExpression(OP_MINUS, variable, rvalue));

		return expression;
	}


	// UNARY EXPRESSION
	public static Expression createExpression(
			final String operator, final Expression operand) {
		final UnaryExpression expression = FACTORY.createUnaryExpression();

		expression.setOperator(operator);

		expression.setOperand(operand);

		return expression;
	}

	public static Expression createExpression(
			final String operator, final NamedElement operand) {
		final UnaryExpression expression = FACTORY.createUnaryExpression();

		expression.setOperator(operator);

		expression.setOperand( createExpression(operand ));

		return expression;
	}

	// BINARY EXPRESSION
	public static BinaryExpression createExpression(final String operator,
			final Expression leftOperand, final Expression rightOperand) {
		final BinaryExpression expression = FACTORY.createBinaryExpression();

		expression.setOperator(operator);

		expression.setLeftOperand(leftOperand);

		expression.setRightOperand(rightOperand);

		return expression;
	}

	public static BinaryExpression createExpression(final String operator,
			final NamedElement leftOperand, final NamedElement rightOperand)
	{
		return createExpression(operator,
				createExpression(leftOperand), createExpression(rightOperand));
	}

	public static Expression createExpression(final String operator,
			final NamedElement leftOperand, final Expression rightOperand)
	{
		return createExpression(operator,
				createExpression(leftOperand), rightOperand);
	}

	// RELATIONAL BINARY EXPRESSION
	public static RelationalBinaryExpression createRelational(
			final String operator,
			final Expression leftOperand, final Expression rightOperand) {
		final RelationalBinaryExpression expression =
				FACTORY.createRelationalBinaryExpression();

		expression.setOperator(operator);

		expression.setLeftOperand(leftOperand);

		expression.setRightOperand(rightOperand);

		return expression;
	}

	public static RelationalBinaryExpression createRelational(
			final String operator, final Machine machine,
			final NamedElement leftOperand, final NamedElement rightOperand)
	{
		return createRelational(operator,
				createExpression(machine, leftOperand),
				createExpression(machine, rightOperand));
	}

	public static RelationalBinaryExpression createRelational(
			final String operator,
			final NamedElement leftOperand, final NamedElement rightOperand)
	{
		return createRelational(operator,
				createExpression(leftOperand), createExpression(rightOperand));
	}

	public static RelationalBinaryExpression createRelational(
			final String operator,
			final NamedElement leftOperand, final Expression rightOperand)
	{
		return createRelational(operator,
				createExpression(leftOperand), rightOperand);
	}


	// LOGICAL EXPRESSION
	// LOGICAL EXPRESSION
	public static Expression createLogical(
			final String operator, final List<Expression> conditions)
	{
		if( conditions.isEmpty() ) {
			return XLIA_EXPRESSION.trueValue();
		}
		else if( conditions.size() == 1 ) {
			return( conditions.get(0) );
		}
		else {
			final LogicalAssociativeExpression expression =
					FACTORY.createLogicalAssociativeExpression();
			expression.setOperator(operator);

			expression.getOperand().addAll(conditions);

			return expression;
		}
	}

	public static Expression createAND(final List<Expression> conditions) {
		return( createLogical(OP_AND, conditions) );
	}

	public static Expression createOR(final List<Expression> conditions) {
		return( createLogical(OP_OR, conditions) );
	}

	public static Expression createLogical(
			final String operator, final Expression... conditions)
	{
		if( conditions.length == 0 ) {
			return XLIA_EXPRESSION.trueValue();
		}
		else if( conditions.length == 1 ) {
			return( conditions[0] );
		}
		else {
			final LogicalAssociativeExpression expression =
					FACTORY.createLogicalAssociativeExpression();
			expression.setOperator(operator);

			for (final Expression condition : conditions) {
				if( condition != null ) {
					expression.getOperand().add(condition);
				}
			}

			return expression;
		}
	}

	public static Expression createAND(final Expression... conditions) {
		return( createLogical(OP_AND, conditions) );
	}

	public static Expression createOR(final Expression... conditions) {
		return( createLogical(OP_OR, conditions) );
	}

	// LOGICAL FLAT EXPRESSION
	public static Expression createFlatLogical(
			final String operator, final Expression... conditions)
	{
		if( conditions.length == 0 ) {
			return XLIA_EXPRESSION.trueValue();
		}
		else if( conditions.length == 1 ) {
			return( conditions[0] );
		}
		else {
			final LogicalAssociativeExpression expression =
					FACTORY.createLogicalAssociativeExpression();
			expression.setOperator(operator);

			for (final Expression condition : conditions) {
				if( (condition instanceof LogicalAssociativeExpression)
					&& ((LogicalAssociativeExpression)
							condition).getOperator().equals(operator))
				{
					expression.getOperand().addAll(
							((LogicalAssociativeExpression) condition).getOperand());
				}
				else if( condition != null ) {
					expression.getOperand().add(condition);
				}
			}

			return expression;
		}
	}

	public static Expression createFlatAND(final Expression... conditions) {
		return( createFlatLogical(OP_AND, conditions) );
	}

	public static Expression createFlatOR(final Expression... conditions) {
		return( createFlatLogical(OP_OR, conditions) );
	}


	// INVOKE
	public static Expression createInvoke(final Routine routine) {
		final InvokeExpression expression = FACTORY.createInvokeExpression();

		expression.setInvokable( createExpression(routine) );

		return expression;
	}

	public static Expression createInvoke(
			final Routine routine, final NamedElement... args) {
		final InvokeExpression expression = FACTORY.createInvokeExpression();

		expression.setInvokable( createExpression(routine) );

		for (final NamedElement arg : args) {
			expression.getArgs().add( createExpression(arg) );
		}

		return expression;
	}

	// LITERAL
	public static LiteralThisExpression thisExpression() {
		return FACTORY.createLiteralThisExpression();
	}

	// TUPLE
	public static PositionalTupleExpression tuple(final Expression... values) {
		final PositionalTupleExpression expression =
				FACTORY.createPositionalTupleExpression();

		for (final Expression value : values) {
			expression.getValue().add(value);
		}

		return expression;
	}

	public static PositionalTupleExpression tuple(
			final NamedElement... elements) {
		final PositionalTupleExpression expression =
				FACTORY.createPositionalTupleExpression();

		for (final NamedElement element : elements) {
			expression.getValue().add(
					XLIA_EXPRESSION.createExpression(element) );
		}

		return expression;
	}


	// COLLECTION
	public static LiteralCollectionExpression createCollection(
			final String[] values) {
		final LiteralCollectionExpression expression =
				FACTORY.createLiteralCollectionExpression();

		for (final String value : values) {
			expression.getValue().add( XLIA_EXPRESSION.createString(value) );
		}

		return expression;
	}

	public static LiteralCollectionExpression createCollectionLiterals(
			final EnumerationLiteral[] modeLiterals) {
		final LiteralCollectionExpression expression =
				FACTORY.createLiteralCollectionExpression();

		for (final EnumerationLiteral literal : modeLiterals) {
			expression.getValue().add(
				XLIA_EXPRESSION.createExpression(literal) );
		}

		return expression;
	}

	public static LiteralCollectionExpression createCollection(
			final boolean[] values) {
		final LiteralCollectionExpression expression =
				FACTORY.createLiteralCollectionExpression();

		for (final boolean value : values) {
			expression.getValue().add( XLIA_EXPRESSION.createBoolean(value) );
		}

		return expression;
	}

	// CAST
	public static CastExpression createCast(
			final DataType datatype, final Expression operand) {
		final CastExpression expression = FACTORY.createCastExpression();

		expression.setDatatype(datatype);

		expression.setOperand(operand);

		return expression;
	}

	public static CastExpression createCast(
			final DataType datatype, final NamedElement element) {
		return createCast(datatype, createExpression(element));
	}

	// SIZE of COLLECTION
	public static LiteralReferenceElement createFunction(
			final NamedElement element, final Expression argument) {

		final LiteralReferenceElement expression =
				FACTORY.createLiteralReferenceElement();

		expression.setKind(ValueElementSpecificationKind.FUNCTION);

		expression.setElement(element);

		expression.setArg(argument);

		return expression;
	}

	public static Expression singleton( final NamedElement collection) {
		return createFunction(SINGLETON, createExpression(collection));
	}

	public static Expression populated( final NamedElement collection) {
		return createFunction(POPULATED, createExpression(collection));
	}

	public static Expression size( final NamedElement collection) {
		return createFunction(SIZE, createExpression(collection));
	}

}
