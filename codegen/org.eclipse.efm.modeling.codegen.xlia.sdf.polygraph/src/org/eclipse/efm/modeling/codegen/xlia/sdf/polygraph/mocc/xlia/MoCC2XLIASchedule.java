/*******************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.xlia;

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression;
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.statemachine.Pseudostate;
import org.eclipse.efm.ecore.formalml.statemachine.Region;
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine;
import org.eclipse.efm.ecore.formalml.statemachine.Transition;
import org.eclipse.efm.ecore.formalml.statemachine.Vertex;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement;
import org.eclipse.efm.ecore.formalml.statement.IfStatement;
import org.eclipse.efm.formalml.ecore.factory.XLIA_EXPRESSION;
import org.eclipse.efm.formalml.ecore.factory.XLIA_INFRA;
import org.eclipse.efm.formalml.ecore.factory.XLIA_STATEMACHINE;
import org.eclipse.efm.formalml.ecore.factory.XLIA_STATEMENT;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.feature.MoccSystemFeature;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.helper.MoccActorHelper;

public class MoCC2XLIASchedule {

	protected MoCC2XLIA mainGenerator;

	public MoCC2XLIASchedule(final MoCC2XLIA mainGenerator) {
		super();
		this.mainGenerator = mainGenerator;
	}


	/**
	 * XLIA SYSTEM SCHEDULING
	 * @param moccSystemFeature
	 */
	public void compute(final MoccSystemFeature moccSystemFeature)
	{
//		computeScheduler(moccSystemFeature);

		computeBehavior(moccSystemFeature);
	}

	/**
	 * XLIA SYSTEM SCHEDULER
	 * @param moccSystemFeature
	 */
	public void computeScheduler(final MoccSystemFeature moccSystemFeature)
	{
		final ModelOfExecution moExcecution = XLIA_INFRA.createMOE(mainGenerator.mainBehavior);

		// MOE: RUN
		final Routine runRoutine =
				XLIA_INFRA.createRoutine(XLIA_STATEMENT.OP_RUN);
		moExcecution.setRunRoutine(runRoutine);

		final BlockStatement blockRun =
				XLIA_STATEMENT.createBlockStatement(runRoutine);

		// Authorized global activation
		XLIA_STATEMENT.addAssignment(blockRun,
				mainGenerator.varCanBeActivate,
				XLIA_EXPRESSION.trueValue());

		XLIA_STATEMENT.addActivitySchedule(blockRun);

		// Test if a timed actor disable global activation because of
		// timed constraint failure
		if( moccSystemFeature.hasTimed ) {
			XLIA_STATEMENT.addGuard(blockRun,
					XLIA_EXPRESSION.createExpression(mainGenerator.varCanBeActivate));
		}

		// MOE: SCHEDULE
		final Routine scheduleRoutine =
				XLIA_INFRA.createRoutine(XLIA_STATEMENT.OP_SCHEDULE);
		moExcecution.setScheduleRoutine(scheduleRoutine);

		final BlockStatement blockSchedule =
				XLIA_STATEMENT.createBlockStatement(scheduleRoutine);

		final int activationCount = moccSystemFeature.tick_period - 1;

		if( moccSystemFeature.hasTimed ) {
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockSchedule);

			computeSchedulingActor(moccSystemFeature, ifStatement, 0);

			for( int index = 1 ; index < activationCount; index++) {
				computeSchedulingActor(moccSystemFeature,
						XLIA_STATEMENT.addElseIf(ifStatement), index);
			}

			final BlockStatement elseBlock =
					XLIA_STATEMENT.createElseBlockStatement(ifStatement);
			computeSchedulingActor(moccSystemFeature, elseBlock, activationCount);
		}
		else if( moccSystemFeature.tick_period > 1 ) {
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockSchedule);

			computeStagingActor(moccSystemFeature, ifStatement, 0);

			for( int stage = 1 ; stage < activationCount; stage++) {
				computeStagingActor(moccSystemFeature,
						XLIA_STATEMENT.addElseIf(ifStatement), stage);
			}

			final BlockStatement elseBlock =
					XLIA_STATEMENT.createElseBlockStatement(ifStatement);
			computeStagingActor(moccSystemFeature, elseBlock, activationCount);
		}
		else {
			computeSchedulingActor(moccSystemFeature, blockSchedule, 0);
		}

		// MOE: RUN
		XLIA_STATEMENT.addAssignment(blockRun, mainGenerator.varTimestamp,
				XLIA_EXPRESSION.createExpression(
						XLIA_EXPRESSION.OP_PLUS,
							mainGenerator.varTimestamp, mainGenerator.varTimeDelta));

		XLIA_STATEMENT.addAssignment(blockRun, mainGenerator.varTick,
					XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_PLUS, mainGenerator.varTick,
							XLIA_EXPRESSION.createInteger(1)));


		// PERIOD & RE-INITIALISATION
		final IfStatement ifPeriod = XLIA_STATEMENT.addIf(blockRun,
				XLIA_EXPRESSION.createRelational(
						XLIA_EXPRESSION.OP_EQ,
						mainGenerator.varTick, mainGenerator.varTickPeriod));

		final BlockStatement blockPeriod =
				XLIA_STATEMENT.createBlockStatement(ifPeriod);

		// NEW PERIOD: INTIALISATION
		XLIA_STATEMENT.addAssignment(blockPeriod,
				mainGenerator.varTick, XLIA_EXPRESSION.zero());


		computeScheduleReinitialisation(moccSystemFeature, blockPeriod);
	}


	protected void computeSchedulingActor(
			final MoccSystemFeature moccSystemFeature,
			final ConditionalBlockStatement ifBlock, final int activationIndex) {
		final BlockStatement thenBlock =
				XLIA_STATEMENT.createBlockStatement(ifBlock);

		ifBlock.setCondition(XLIA_EXPRESSION.createRelational(
				XLIA_EXPRESSION.OP_EQ, mainGenerator.varTick,
				XLIA_EXPRESSION.createInteger(activationIndex)));

		computeSchedulingActor(moccSystemFeature, thenBlock, activationIndex);
	}

	protected void computeSchedulingActor(
			final MoccSystemFeature moccSystemFeature,
			final BlockStatement thenBlock, final int activationIndex) {
//		int statementCount = 0;
		for( final MoccActor actor : mainGenerator.moccSystem.getActor() ) {
			if( actor.FEATURE.activation[activationIndex] ) {
				final MoccActorHelper actorHELPER = mainGenerator.helper(actor);

				if( actor.FEATURE.isTimed ) {
					XLIA_STATEMENT.addActivityRun(thenBlock,
							actorHELPER.statemachine);
				}
				else {
					XLIA_STATEMENT.addActivityRtc(thenBlock,
							actorHELPER.statemachine);
				}

				// Increment statementCount
//				++statementCount;
			}
		}

//		if( (statementCount > 1) /*&& (! moccSystemFeature.hasTimed)*/ ) {
//			thenBlock.setOp( XLIA_STATEMENT.OP_SEQUENCE_WEAK );
//		}
	}


	protected void computeStagingActor(
			final MoccSystemFeature moccSystemFeature,
			final ConditionalBlockStatement ifBlock, final int stageIndex) {
		final BlockStatement thenBlock =
				XLIA_STATEMENT.createBlockStatement(ifBlock);

		ifBlock.setCondition(XLIA_EXPRESSION.createRelational(
				XLIA_EXPRESSION.OP_EQ, mainGenerator.varTick,
				XLIA_EXPRESSION.createInteger(stageIndex)));

		computeStagingActor(moccSystemFeature, thenBlock, stageIndex);
	}

	protected void computeStagingActor(
			final MoccSystemFeature moccSystemFeature,
			final BlockStatement thenBlock, final int stageIndex) {
//		int statementCount = 0;
		for( final MoccActor actor : mainGenerator.moccSystem.getActor() ) {
			if( (actor.schedule == stageIndex) && actor.FEATURE.isExecutable ) {
				final MoccActorHelper actorHELPER = mainGenerator.helper(actor);

				XLIA_STATEMENT.addActivityRtc(thenBlock, actorHELPER.statemachine);

				// Increment statementCount
//				++statementCount;
			}
		}

//		if( (statementCount > 1) /*&& (! moccSystemFeature.hasTimed)*/ ) {
//			thenBlock.setOp( XLIA_STATEMENT.OP_SEQUENCE_WEAK );
//		}
	}



	protected void computeScheduleReinitialisation(
			final MoccSystemFeature moccSystemFeature,
			final BlockStatement blockPeriod)
	{
		BlockStatement blockReinit = blockPeriod;

//		XLIA_STATEMENT.addAssignment(blockReinit,
//				mainGenerator.varTick, XLIA_EXPRESSION.zero());

		IfStatement ifReinit = null;
		if( ! moccSystemFeature.hasTimed ) {
			ifReinit = XLIA_STATEMENT.addIf(blockReinit);
			blockReinit = XLIA_STATEMENT.createBlockStatement(ifReinit);
		}

		Expression untimedConditionalReinitialisation = null;

		// NEW PERIOD: CHECKING
		for( final MoccActor actor : mainGenerator.moccSystem.getActor() ) {
			final MoccActorHelper actorHELPER = mainGenerator.helper(actor);

			if( actor.FEATURE.isExecutable ) // && (! actor.FEATURE.isTimed) )
			{
				final RelationalBinaryExpression actorRepetitionCond =
						XLIA_EXPRESSION.createRelational(
								XLIA_EXPRESSION.OP_EQ,
								actorHELPER.statemachine,
								actorHELPER.varActivationCount,
									actorHELPER.constREPETITION);

				if( moccSystemFeature.hasTimed ) {
					XLIA_STATEMENT.addGuard(blockReinit, actorRepetitionCond);
				}
				else if( untimedConditionalReinitialisation == null ) {
					untimedConditionalReinitialisation = actorRepetitionCond;
				}
				else {
					untimedConditionalReinitialisation =
							XLIA_EXPRESSION.createFlatAND(
									untimedConditionalReinitialisation,
									actorRepetitionCond);
				}

//!@! CSDF
				XLIA_STATEMENT.addAssignment(blockReinit,
						actorHELPER.statemachine,
						actorHELPER.varActivationCount,
						XLIA_EXPRESSION.zero());
			}
		}

		// UNTIMED SYSTEM RE-INITIALISATION
		if( untimedConditionalReinitialisation != null ) {
			ifReinit.setCondition(untimedConditionalReinitialisation);
		}

		// ENABLED ONLY RECEPTION BEFORE RE-INITIALISATION
		final BlockStatement blockReception =
				XLIA_STATEMENT.createBlockStatement(
						blockReinit, XLIA_STATEMENT.OP_SEQUENCE_WEAK);

		XLIA_STATEMENT.addAssignment(blockReception,
				mainGenerator.varCanBeActivate,
				XLIA_EXPRESSION.falseValue());

		for( final MoccActor actor : mainGenerator.moccSystem.getActor() ) {
			if( actor.FEATURE.hasInput &&  actor.FEATURE.isExecutable ) {
				XLIA_STATEMENT.addActivityRun(blockReception,
						mainGenerator.helper(actor).statemachine);
			}
		}

		XLIA_STATEMENT.addAssignment(blockReception,
				mainGenerator.varCanBeActivate,
				XLIA_EXPRESSION.trueValue());
	}



	/**
	 * XLIA SYSTEM SCHEDULER
	 * @param moccSystemFeature
	 */
	public void computeBehavior(final MoccSystemFeature moccSystemFeature) {
		final Statemachine xliaScheduler =
				XLIA_STATEMACHINE.createStatemachine("scheduler");

		mainGenerator.xliaSystem.getBehavior().add(xliaScheduler);

		final Region region = XLIA_STATEMACHINE.createRegion(xliaScheduler);

		final Pseudostate s_init =
				XLIA_STATEMACHINE.createInitialState(region, "s_init");

		final Pseudostate s_tick_period =
				XLIA_STATEMACHINE.createJunctionState(region, "tick_period");

		Vertex s_tick = XLIA_STATEMACHINE.createState(region, "tick_0");

		final Transition t_init = XLIA_STATEMACHINE.createTransition(
				"t_init", s_init, s_tick);

		final Transition t_period = XLIA_STATEMACHINE.createTransition(
				"t_period", s_tick_period, s_tick);

		Vertex next_tick = (moccSystemFeature.tick_period > 1) ?
				XLIA_STATEMACHINE.createState(region, "tick_1") : s_tick_period;

		Transition t_tick = XLIA_STATEMACHINE.createTransition(
				"t_tick_0", s_tick, next_tick);

		final int activationCount = moccSystemFeature.tick_period - 1;

		if( moccSystemFeature.hasTimed ) {
			computeRunninActorTickAcivity(moccSystemFeature, t_tick, 0);

			if( activationCount > 0 ) {
				for( int index = 1 ; index < activationCount; index++) {
					s_tick = next_tick;

					next_tick = XLIA_STATEMACHINE.createState(
							region, "tick_" + (index + 1));

					t_tick = XLIA_STATEMACHINE.createTransition(
							"t_tick_" + index, s_tick, next_tick);

					computeRunninActorTickAcivity(
							moccSystemFeature, t_tick, index);
				}

				t_tick = XLIA_STATEMACHINE.createTransition(
						"t_tick_" + activationCount, next_tick, s_tick_period);

				computeRunninActorTickAcivity(
						moccSystemFeature, t_tick, activationCount);
			}
		}
		else if( moccSystemFeature.tick_period > 1 ) {
			computeStaginActorTickAcivity(moccSystemFeature, t_tick, 0);

			for( int index = 1 ; index < activationCount; index++) {
				s_tick = next_tick;

				next_tick = XLIA_STATEMACHINE.createState(
						region, "tick_" + (index + 1));

				t_tick = XLIA_STATEMACHINE.createTransition(
						"t_tick_" + index, s_tick, next_tick);

				computeStaginActorTickAcivity(moccSystemFeature, t_tick, index);
			}

			t_tick = XLIA_STATEMACHINE.createTransition(
					"t_tick_" + activationCount, next_tick, s_tick_period);

			computeStaginActorTickAcivity(
					moccSystemFeature, t_tick, activationCount);
		}
		else if( moccSystemFeature.tick_period == 0 ) {

		}

		computeReinitialisationAcivity(
				moccSystemFeature, t_period, activationCount);

		computeBehaviorMoe(moccSystemFeature, xliaScheduler);
	}


	protected void computeRunninActorTickAcivity(
			final MoccSystemFeature moccSystemFeature,
			final Transition transition, final int activationIndex)
	{
		final BlockStatement block =
				XLIA_STATEMENT.createBlockStatement(transition);

//		ifBlock.setCondition(XLIA_EXPRESSION.createRelational(
//				XLIA_EXPRESSION.OP_EQ, mainGenerator.varTick,
//				XLIA_EXPRESSION.createInteger(activationIndex)));

		XLIA_STATEMENT.addAssignment(block, mainGenerator.varTick,
				XLIA_EXPRESSION.createInteger(activationIndex));

		computeSchedulingActor(moccSystemFeature, block, activationIndex);

//		XLIA_STATEMENT.addAssignment(block, mainGenerator.varTick,
//				XLIA_EXPRESSION.createInteger(activationIndex + 1));
	}


	protected void computeStaginActorTickAcivity(
			final MoccSystemFeature moccSystemFeature,
			final Transition transition, final int stageIndex)
	{
		final BlockStatement block =
				XLIA_STATEMENT.createBlockStatement(transition);

//		ifBlock.setCondition(XLIA_EXPRESSION.createRelational(
//				XLIA_EXPRESSION.OP_EQ, mainGenerator.varTick,
//				XLIA_EXPRESSION.createInteger(activationIndex)));

		computeStagingActor(moccSystemFeature, block, stageIndex);

		XLIA_STATEMENT.addAssignment(block, mainGenerator.varTick,
				XLIA_EXPRESSION.createInteger(stageIndex + 1));
	}


	protected void computeReinitialisationAcivity(
			final MoccSystemFeature moccSystemFeature,
			final Transition transition, final int activationIndex)
	{
		final BlockStatement blockPeriod =
				XLIA_STATEMENT.createBlockStatement(transition);

//		XLIA_STATEMENT.addAssignment(blockPeriod,
//				mainGenerator.varTick, XLIA_EXPRESSION.zero());

		// Test if a timed actor disable global activation because of
		// timed constraint failure
		if( moccSystemFeature.hasTimed ) {
			XLIA_STATEMENT.addGuard(blockPeriod,
					XLIA_EXPRESSION.createExpression(mainGenerator.varCanBeActivate));
		}

		computeScheduleReinitialisation(moccSystemFeature, blockPeriod);
	}


	private void computeBehaviorMoe(
			final MoccSystemFeature moccSystemFeature, final Statemachine xliaScheduler) {

		final Behavior moeBehavior = XLIA_INFRA.createBehavior();
		xliaScheduler.setMain(moeBehavior);

		final ModelOfExecution moExcecution = XLIA_INFRA.createMOE(moeBehavior);

		// MOE: RUN
		final Routine runRoutine =
				XLIA_INFRA.createRoutine(XLIA_STATEMENT.OP_RUN);
		moExcecution.setRunRoutine(runRoutine);

		final BlockStatement blockRun =
				XLIA_STATEMENT.createBlockStatement(runRoutine);

		// Authorized global activation
		XLIA_STATEMENT.addAssignment(blockRun,
				mainGenerator.varCanBeActivate,
				XLIA_EXPRESSION.trueValue());

		XLIA_STATEMENT.addActivitySchedule(blockRun);

		// Test if a timed actor disable global activation because of
		// timed constraint failure
		if( moccSystemFeature.hasTimed ) {
			XLIA_STATEMENT.addGuard(blockRun,
					XLIA_EXPRESSION.createExpression(mainGenerator.varCanBeActivate));
		}

		XLIA_STATEMENT.addAssignment(blockRun, mainGenerator.varTimestamp,
				XLIA_EXPRESSION.createExpression(
						XLIA_EXPRESSION.OP_PLUS,
							mainGenerator.varTimestamp, mainGenerator.varTimeDelta));
	}


}
