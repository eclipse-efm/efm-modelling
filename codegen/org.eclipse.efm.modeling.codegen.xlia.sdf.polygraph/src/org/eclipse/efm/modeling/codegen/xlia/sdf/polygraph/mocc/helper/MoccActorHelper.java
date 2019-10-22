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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.helper;

import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine;
import org.eclipse.efm.formalml.ecore.factory.XLIA_DATATYPE;
import org.eclipse.efm.formalml.ecore.factory.XLIA_EXPRESSION;
import org.eclipse.efm.formalml.ecore.factory.XLIA_INFRA;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;

public class MoccActorHelper {

	public final MoccActor actor;

	public final Statemachine statemachine;

	public Variable constFREQUENCY;
	public Variable constREPETITION;

	public Variable constACTIVATION_TICK;

	public Variable varActivationCount;

	public Variable varIntToken;
//!@! CSDF
//	public Variable varRatToken;

	public Variable varDecidingMode;


	public EnumerationLiteral[] modeSelectionSet;
	public EnumerationLiteral[] modeProcessingSet;

	public EnumerationType enumSELECTIONG_SET;
	public EnumerationType enumPROCESSING_SET;

	public Variable constDEFAULT_MODE;

	public Variable varReceivedModeSet;
	public Variable varProcessingMode;
	public Variable varProducingMode;

	public Routine macroInitialization;
	public Routine macroReception;

	public Routine macroConsumption;
	public Routine macroConsumptionTrace;
	public Routine macroProduction;

	public Routine macroActivationTest;
	public Routine macroComputeProcessingMode;

//!@! DELETE 20190702
//	public Routine macroActivationProcessTest;
//	public Routine macroActivationPassTest;



	public MoccActorHelper(
			final MoccActor actor, final Statemachine statemachine) {
		super();
		this.actor = actor;
		this.statemachine = statemachine;

		this.constFREQUENCY  = null;
		this.constREPETITION = null;

		this.constACTIVATION_TICK = null;

		this.varActivationCount  = null;

		this.varIntToken       = null;
		this.varDecidingMode   = null;

		this.modeSelectionSet  = null;
		this.modeProcessingSet = null;

		this.enumSELECTIONG_SET = null;
		this.enumPROCESSING_SET = null;

		this.constDEFAULT_MODE  = null;
		this.varReceivedModeSet = null;
		this.varProcessingMode  = null;
		this.varProducingMode  = null;


		this.macroInitialization = null;
		this.macroReception      = null;

		this.macroConsumption      = null;
		this.macroConsumptionTrace = null;
		this.macroProduction       = null;

		this.macroActivationTest        = null;
		this.macroComputeProcessingMode = null;

//!@! DELETE 20190702
//		this.macroActivationProcessTest = null;
//		this.macroActivationPassTest    = null;
	}


	public static EnumerationLiteral[] modeLiterals(
			final EnumerationType enumeration, final String[] values)
	{
		final EnumerationLiteral[] literals =
				new EnumerationLiteral[values.length];

		for (int offset = 0; offset < values.length; offset++) {
			literals[offset] =
					XLIA_DATATYPE.getEnumLiteral(enumeration, values[offset]);
		}

		return literals;
	}


	public void declareConstantsVariables(
			final Statemachine xliaActor,
			final EnumerationType MODE_SET_TYPE,
			final EnumerationLiteral MODE_NOMINAL,
			final boolean ALWAYS_USING_MODE)
	{
		// MODE TYPE
		if( actor.FEATURE.isModeSelector ) {
			XLIA_DATATYPE.addEnumLiterals(
					MODE_SET_TYPE, actor.getSelectionSetLiterals());

			selectorActorDeclaration(xliaActor, MODE_SET_TYPE);
		}

		if( actor.FEATURE.isModeProcessor ) {
			processorActorDeclaration(xliaActor, MODE_SET_TYPE);
		}

		// MODE VARIABLES
		modeActorDeclaration(xliaActor,
				MODE_SET_TYPE, MODE_NOMINAL, ALWAYS_USING_MODE);

		// CONSTANT: FREQUENCY
		if( actor.FEATURE.isTimed ) {
			this.constFREQUENCY = XLIA_INFRA.createConstant(
					XLIA_DATATYPE.createInteger(), "FREQUENCY",
					XLIA_EXPRESSION.createInteger(actor.getFrequency()));
			xliaActor.getVariable().add(this.constFREQUENCY);

			// For Activation
			this.constACTIVATION_TICK =
					XLIA_INFRA.createLocaleVariable(
							XLIA_DATATYPE.createBoolean(
									actor.FEATURE.activation.length),
							"ACTIVATION_TICK",
							XLIA_EXPRESSION.createCollection(
									actor.FEATURE.activation));
			xliaActor.getVariable().add(this.constACTIVATION_TICK);
		}
//!@! CSDF
//		else {
			this.constREPETITION = XLIA_INFRA.createPublicConstant(
					XLIA_DATATYPE.createInteger(), "REPETITION",
					XLIA_EXPRESSION.createInteger(actor.FEATURE.repetition));
			xliaActor.getVariable().add(this.constREPETITION);

			// For scheduler
			this.varActivationCount =
					XLIA_INFRA.createPublicVariable(
							XLIA_DATATYPE.createInteger(),
							"activationCount", XLIA_EXPRESSION.zero());
			xliaActor.getVariable().add(this.varActivationCount);
//		}

		// VARIABLE: INTEGER TOKEN
//!@! CSDF
//		if( actor.FEATURE.hasIntegerRate ) {
			this.varIntToken = XLIA_INFRA.createLocaleVariable(
					XLIA_DATATYPE.createInteger(),
					"intToken", XLIA_EXPRESSION.zero());
			xliaActor.getVariable().add(this.varIntToken);
//		}

//!@! CSDF
		// VARIABLE: RATIONAL TOKEN
//		if( actor.FEATURE.hasRationalRate ) {
//			this.varRatToken = XLIA_INFRA.createLocaleVariable(
//					XLIA_DATATYPE.createRational(),
//					"ratToken", XLIA_EXPRESSION.zero());
//			xliaActor.getVariable().add(this.varRatToken);
//		}

			if( actor.FEATURE.hasInputDecidingMode ) {
				this.varDecidingMode = XLIA_INFRA.createVariable(
						XLIA_DATATYPE.createReference(MODE_SET_TYPE),
						"decidingMode");
				xliaActor.getVariable().add(this.varDecidingMode);
			}
	}


	////////////////////////////////////////////////////////////////////////////
	// Variable Declaration for Mode Selector / Processor Actor
	protected void modeActorDeclaration(
			final Statemachine xliaActor,
			final EnumerationType MODE_SET_TYPE,
			final EnumerationLiteral MODE_NOMINAL,
			final boolean ALWAYS_USING_MODE)
	{
		// CONSTANT: DEFAULT MODE
		if( ALWAYS_USING_MODE || actor.FEATURE.isModeProducer ) {
			this.constDEFAULT_MODE = XLIA_INFRA.createConstant(
					XLIA_DATATYPE.createReference(MODE_SET_TYPE),
					"DEFAULT_MODE",
					XLIA_EXPRESSION.createExpression(MODE_NOMINAL));
			xliaActor.getVariable().add(this.constDEFAULT_MODE);
		}

		// VARIABLE: MODE UTILS
//		if( ALWAYS_USING_MODE || actor.FEATURE.isModeProducer ) {
//			this.varProducingMode = XLIA_INFRA.createVariable(
//					XLIA_DATATYPE.createReference(
//							actorSelectorHelper.MODE_SET_TYPE),
//					"producingMode",
//					XLIA_EXPRESSION.createExpression(this.constDEFAULT_MODE));
//			xliaActor.getVariable().add(this.varProducingMode);
//		}

		if( actor.FEATURE.isModeSelector ) {
			this.varProducingMode = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createReference(enumSELECTIONG_SET),
					"producingMode");
			xliaActor.getVariable().add(this.varProducingMode);
		}

		if( actor.FEATURE.requiresModeProcessor
			|| (actor.FEATURE.hasOutput && ALWAYS_USING_MODE) ) {
			this.varProcessingMode = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createReference(MODE_SET_TYPE),
					"processingMode",
					XLIA_EXPRESSION.createExpression(this.constDEFAULT_MODE));
			xliaActor.getVariable().add(this.varProcessingMode);
		}

		if( actor.FEATURE.isModeProcessor ) {
			if( actor.getInputPort().size() > 1 ) {
				this.varReceivedModeSet = XLIA_INFRA.createVariable(
						XLIA_DATATYPE.createCollectionSet(
								XLIA_DATATYPE.createReference(MODE_SET_TYPE), -1),
						"receivedModeSet");
				xliaActor.getVariable().add(this.varReceivedModeSet);
			}
		}
	}


	protected void selectorActorDeclaration(
			final Statemachine xliaActor, final EnumerationType MODE_SET_TYPE)
	{
		// CONSTANT - TYPE : SELECTION SET
		this.modeSelectionSet = modeLiterals(
				MODE_SET_TYPE, actor.getSelectionSetLiterals());

		this.enumSELECTIONG_SET = XLIA_DATATYPE.addSubEnum(xliaActor,
				MODE_SET_TYPE, "SELECTION_SET", this.modeSelectionSet);
		xliaActor.getTypedef().add(this.enumSELECTIONG_SET);
	}

	protected void processorActorDeclaration(
			final Statemachine xliaActor, final EnumerationType MODE_SET_TYPE)
	{
		// CONSTANT - TYPE : PROCESSING SET
		this.modeProcessingSet = modeLiterals(MODE_SET_TYPE,
				actor.getProcessingSetLiterals());

		this.enumPROCESSING_SET =XLIA_DATATYPE.addSubEnum(xliaActor,
				MODE_SET_TYPE, "PROCESSING_SET", this.modeProcessingSet);
		xliaActor.getTypedef().add(this.enumPROCESSING_SET);
	}


//!@! DELETE 20190702
//	public void createProcessingPassTestRoutine() {
//		// Activation PROCESSING
//		final BlockStatement blockProcess = XLIA_STATEMENT.createBlockStatement();
//
//		final List< Expression > processConditions = new ArrayList<Expression>();
//		for( final EnumerationLiteral literal : modeProcessingSet )
//		{
//			processConditions.add(
//					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
//							varProcessingMode, literal));
//		}
//		XLIA_STATEMENT.addGuard(blockProcess,
//				XLIA_EXPRESSION.createOR(processConditions));
//
//		this.macroActivationProcessTest =
//				XLIA_INFRA.createMacroRoutine(statemachine,
//						"activationProcessTest", blockProcess);
//
//
//		// Activation PASSING
//		final BlockStatement blockPass = XLIA_STATEMENT.createBlockStatement();
//
//		final List< Expression > passConditions = new ArrayList<Expression>();
//		for( final EnumerationLiteral literal : modeProcessingSet )
//		{
//			passConditions.add(
//					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_NOT_EQ,
//							varProcessingMode, literal));
//		}
//		XLIA_STATEMENT.addGuard(blockPass,
//				XLIA_EXPRESSION.createAND(passConditions));
//
//		this.macroActivationPassTest = XLIA_INFRA.createMacroRoutine(
//				statemachine, "activationPassTest", blockPass);
//	}

}
