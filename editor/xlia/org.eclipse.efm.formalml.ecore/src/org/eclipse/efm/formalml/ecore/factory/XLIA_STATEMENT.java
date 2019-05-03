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

import org.eclipse.efm.ecore.formalml.common.NamedElement;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.statemachine.Transition;
import org.eclipse.efm.ecore.formalml.statement.ActivityStatement;
import org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement;
import org.eclipse.efm.ecore.formalml.statement.ExpressionStatement;
import org.eclipse.efm.ecore.formalml.statement.GuardStatement;
import org.eclipse.efm.ecore.formalml.statement.IfStatement;
import org.eclipse.efm.ecore.formalml.statement.InputComStatement;
import org.eclipse.efm.ecore.formalml.statement.InvokeStatement;
import org.eclipse.efm.ecore.formalml.statement.MetaStatement;
import org.eclipse.efm.ecore.formalml.statement.MetaStatementKind;
import org.eclipse.efm.ecore.formalml.statement.OutputComStatement;
import org.eclipse.efm.ecore.formalml.statement.Statement;
import org.eclipse.efm.ecore.formalml.statement.StatementFactory;

public class XLIA_STATEMENT {

	public final static String OP_INIT     = "init" ;
	public final static String OP_IRUN     = "irun" ;
	public final static String OP_RUN      = "run" ;
	public final static String OP_SCHEDULE = "schedule" ;

	public final static String OP_SEQUENCE      = "|;|" ;
	public final static String OP_SEQUENCE_WEAK = "|;;|" ;
	public final static String OP_WEAK_SIDE     = "|.|" ;

	public final static String OP_INTERLEAVING = "|i|" ;


	public static final Routine CLEAR = XLIA_INFRA.createRoutine("clear");

	// StatementFactory FACTORY
	static StatementFactory FACTORY = StatementFactory.eINSTANCE;


	// BLOCK
	public static BlockStatement createBlockStatement(final String scheduleOp) {
		final BlockStatement statement = FACTORY.createBlockStatement();

		statement.setOp(scheduleOp);

		return statement;
	}

	public static BlockStatement createBlockStatement() {
		final BlockStatement statement = FACTORY.createBlockStatement();

		return statement;
	}

	public static BlockStatement createBlockStatement(
			final BlockStatement block, final String scheduleOp) {
		final BlockStatement statement = FACTORY.createBlockStatement();
		statement.setOp( scheduleOp );

		block.getStatement().add( statement );

		return statement;
	}

	public static BlockStatement createBlockStatement(
			final ConditionalBlockStatement condBlockStatement) {
		final BlockStatement statement = FACTORY.createBlockStatement();

		condBlockStatement.setBodyBlock(statement);

		return statement;
	}

	public static BlockStatement createBlockStatement(
			final Transition transition) {
		final BlockStatement statement = FACTORY.createBlockStatement();

		transition.setBehavior(statement);

		return statement;
	}

	public static BlockStatement createElseBlockStatement(
			final IfStatement ifStatement) {
		final BlockStatement statement = FACTORY.createBlockStatement();

		ifStatement.setElseBlock(statement);

		return statement;
	}

	public static BlockStatement createBlockStatement(final Routine routine) {
		final BlockStatement statement = FACTORY.createBlockStatement();

		routine.setBodyBlock(statement);

		return statement;
	}


	// ASSIGNMENT
	public static ExpressionStatement createAssignment(
			final PropertyDefinition variable, final Expression rvalue) {
		final ExpressionStatement statement = FACTORY.createExpressionStatement();

		statement.setExpression(
				XLIA_EXPRESSION.createAssignment(variable, rvalue));

		return statement;
	}

	public static void addAssignment(final BlockStatement block,
			final PropertyDefinition variable, final Expression rvalue) {

		block.getStatement().add( createAssignment(variable, rvalue) );
	}

	public static void addAssignment(final BlockStatement block,
			final PropertyDefinition variable, final NamedElement element) {

		addAssignment(block, variable, XLIA_EXPRESSION.createExpression(element));
	}

	public static ExpressionStatement createAssignment(final Machine machine,
			final PropertyDefinition variable, final Expression rvalue) {
		final ExpressionStatement statement = FACTORY.createExpressionStatement();

		statement.setExpression(
				XLIA_EXPRESSION.createAssignment(machine, variable, rvalue));

		return statement;
	}

	public static void addAssignment(
			final BlockStatement block, final Machine machine,
			final PropertyDefinition variable, final Expression rvalue) {

		block.getStatement().add( createAssignment(machine, variable, rvalue) );
	}

	// ASSIGNMENT OPERATOR
	public static ExpressionStatement createAssignment(final String assignOp,
			final PropertyDefinition variable, final Expression rvalue) {
		final ExpressionStatement statement = FACTORY.createExpressionStatement();

		statement.setExpression(
				XLIA_EXPRESSION.createAssignment(assignOp, variable, rvalue));

		return statement;
	}

	public static void addAssignment(
			final BlockStatement block, final String assignOp,
			final PropertyDefinition variable, final Expression rvalue) {

		block.getStatement().add( createAssignment(assignOp, variable, rvalue) );
	}

	public static void addAssignment(
			final BlockStatement block, final String assignOp,
			final PropertyDefinition variable, final NamedElement element) {

		addAssignment(block, assignOp, variable,
				XLIA_EXPRESSION.createExpression(element));
	}


	// INCREMENTATION
	public static Statement createIncrementation(
			final PropertyDefinition variable, final Expression rvalue) {
		final ExpressionStatement statement = FACTORY.createExpressionStatement();

		statement.setExpression(
				XLIA_EXPRESSION.createIncrementation(variable, rvalue));

		return statement;
	}

	public static void addIncrementation(final BlockStatement block,
			final PropertyDefinition variable, final Expression rvalue) {

		block.getStatement().add( createIncrementation(variable, rvalue) );
	}


	// DECREMENTATION
	public static Statement createDecrementation(
			final PropertyDefinition variable, final Expression rvalue) {
		final ExpressionStatement statement = FACTORY.createExpressionStatement();

		statement.setExpression(
				XLIA_EXPRESSION.createDecrementation(variable, rvalue));

		return statement;
	}

	public static void addDecrementation(final BlockStatement block,
			final PropertyDefinition variable, final Expression rvalue) {

		block.getStatement().add( createDecrementation(variable, rvalue) );
	}


	// GUARD
	public static GuardStatement createGuard(final Expression condition) {
		final GuardStatement statement = FACTORY.createGuardStatement();

		statement.setCondition(condition);

		return statement;
	}

	public static void addGuard(
			final BlockStatement block, final Expression condition) {
		block.getStatement().add( createGuard(condition) );
	}


	// OUTPUT COM
	public static OutputComStatement createOutputCom(final PropertyDefinition port) {
		final OutputComStatement statement = FACTORY.createOutputComStatement();

		statement.setPort( XLIA_EXPRESSION.createExpression(port) );

		return statement;
	}

	public static void addOutputCom(
			final BlockStatement block, final PropertyDefinition port) {
		block.getStatement().add( createOutputCom(port) );
	}

	public static void addOutputCom(final BlockStatement block,
			final Port port, final NamedElement... rightValue) {

		final OutputComStatement statement = createOutputCom(port);

		for (final NamedElement rvalue : rightValue) {
			statement.getRightValue().add(
					XLIA_EXPRESSION.createExpression(rvalue));
		}

		block.getStatement().add( statement );
	}

//	public static void addOutputCom(final BlockStatement block,
//			final Port port, final Expression... rightValue) {
//
//		final OutputComStatement statement = createOutputCom(port);
//
//		for (final Expression rvalue : rightValue) {
//			statement.getRightValue().add(rvalue);
//		}
//
//		block.getStatement().add( statement );
//	}


	// INPUT COM
	public static InputComStatement createInputCom(final PropertyDefinition port) {
		final InputComStatement statement = FACTORY.createInputComStatement();

		statement.setPort( XLIA_EXPRESSION.createExpression(port) );

		return statement;
	}

	public static void addInputCom(
			final BlockStatement block, final PropertyDefinition port) {
		block.getStatement().add( createInputCom(port) );
	}

	public static void addInputCom(final BlockStatement block,
		final PropertyDefinition port, final NamedElement... leftValue)
	{
		final InputComStatement statement = createInputCom(port);

		for (final NamedElement lvalue : leftValue) {
			statement.getLeftValue().add(
					XLIA_EXPRESSION.createExpression(lvalue));
		}

		block.getStatement().add( statement );
	}

	// ACTIVITY
	public static ActivityStatement createActivity(
			final ActivityStatementKind kindOp, final Expression machine) {
		final ActivityStatement statement = FACTORY.createActivityStatement();

		statement.setOp(kindOp);
		statement.setMachine( machine );

		return statement;
	}

	public static ActivityStatement createActivity(
			final ActivityStatementKind kindOp, final Machine machine) {
		return createActivity(kindOp,
				XLIA_EXPRESSION.createExpression(machine));
	}

	public static void addActivityRun(
			final BlockStatement block, final Machine machine) {
		block.getStatement().add(
				createActivity(ActivityStatementKind.RUN, machine) );
	}

	public static void addActivityRtc(
			final BlockStatement block, final Machine machine) {
		block.getStatement().add(
				createActivity(ActivityStatementKind.RTC, machine) );
	}

	public static void addActivitySchedule(final BlockStatement block) {
		block.getStatement().add(
				createActivity(ActivityStatementKind.SCHEDULE,
						XLIA_EXPRESSION.thisExpression()) );
	}


	// INVOKE ZERO ARGUMENT
	public static InvokeStatement createInvoke(final Routine routine) {
		final InvokeStatement statement = FACTORY.createInvokeStatement();

		statement.setInvokable(routine);

		return statement;
	}

	public static void addInvoke(final BlockStatement block, final Routine routine) {
		block.getStatement().add( createInvoke(routine) );
	}


	// INVOKE N-ARGUMENTS
	public static InvokeStatement createInvoke(
			final Routine routine, final NamedElement... args) {
		final InvokeStatement statement = createInvoke(routine);

		statement.setArgs( XLIA_EXPRESSION.tuple(args) );

		return statement;
	}

	public static void addInvoke(final BlockStatement block,
			final Routine routine, final NamedElement... args) {
		block.getStatement().add( createInvoke(routine, args) );
	}


	public static InvokeStatement createInvoke(
			final Routine routine, final Expression... args) {
		final InvokeStatement statement = createInvoke(routine);

		statement.setArgs( XLIA_EXPRESSION.tuple(args) );

		return statement;
	}

	public static void addInvoke(final BlockStatement block,
			final Routine routine, final Expression... args) {
		block.getStatement().add( createInvoke(routine, args) );
	}

	public static void addInvokeClear(
			final BlockStatement block, final NamedElement collection) {
		block.getStatement().add(
				createInvoke(CLEAR, collection) );
	}


	// IF
	public static IfStatement createIf() {
		return FACTORY.createIfStatement();
	}

	public static IfStatement addIf(final BlockStatement block) {
		final IfStatement statement = createIf();

		block.getStatement().add(statement);

		return statement;
	}

	// IF CONDTION
	public static IfStatement createIf(final Expression condition) {
		final IfStatement statement = FACTORY.createIfStatement();

		statement.setCondition(condition);

		return statement;
	}

	public static IfStatement addIf(
			final BlockStatement block, final Expression condition) {
		final IfStatement statement = createIf(condition);

		block.getStatement().add(statement);

		return statement;
	}

	// ELSE IF
	public static ConditionalBlockStatement createElseIf() {
		return FACTORY.createConditionalBlockStatement();
	}

	public static ConditionalBlockStatement addElseIf(
			final IfStatement ifStatement) {
		final ConditionalBlockStatement statement = createElseIf();

		ifStatement.getElseifStatement().add(statement);

		return statement;
	}

	// ELSE IF CONDTION
	public static ConditionalBlockStatement createElseIf(
			final Expression condition) {
		final ConditionalBlockStatement  statement =
				FACTORY.createConditionalBlockStatement();

		statement.setCondition(condition);

		return statement;
	}

	public static ConditionalBlockStatement addElseIf(
			final IfStatement ifStatement, final Expression condition) {
		final ConditionalBlockStatement statement = createElseIf(condition);

		ifStatement.getElseifStatement().add(statement);

		return statement;
	}

	public static MetaStatement addTrace(
			final BlockStatement block, final Expression... operands)
	{
		final MetaStatement statement = FACTORY.createMetaStatement();

		statement.setOp(MetaStatementKind.TRACE);

		for (final Expression operand : operands) {
			statement.getOperand().add(operand);
		}

		block.getStatement().add(statement);

		return statement;
	}


}
