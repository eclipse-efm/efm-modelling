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

import org.eclipse.efm.ecore.formalml.common.VisibilityKind;
import org.eclipse.efm.ecore.formalml.datatype.DataType;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection;
import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.IfStatement;
import org.eclipse.efm.formalml.ecore.factory.XLIA_DATATYPE;
import org.eclipse.efm.formalml.ecore.factory.XLIA_EXPRESSION;
import org.eclipse.efm.formalml.ecore.factory.XLIA_INFRA;
import org.eclipse.efm.formalml.ecore.factory.XLIA_STATEMENT;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccChannel;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccPort;

public class MoccPortHelper {

	protected final MoccActorHelper moccActorHelper;

	protected final MoccPort moccPort;


	public Port xliaPort;
	public Port xliaChannelPort;

	public Variable constTOKEN_INITIAL_RATE;
	public Variable varReceivedTokenCount;

	public Variable constMODE_INITIAL;
	public Variable varReceivedMode;

	public Variable constTOKEN_RATE;

	public Variable constTOKEN_RATE_CSDF;

	public MoccPortHelper(final MoccActorHelper moccActorHelper, final MoccPort moccPort) {
		super();

		this.moccActorHelper = moccActorHelper;
		this.moccPort  = moccPort;

		this.xliaPort = null;
		this.xliaChannelPort = null;

		this.constTOKEN_INITIAL_RATE = null;
		this.varReceivedTokenCount = null;

		this.constMODE_INITIAL = null;
		this.varReceivedMode = null;

		this.constTOKEN_RATE = null;

		this.constTOKEN_RATE_CSDF = null;
	}


	/**
	 * Getter initial rate
	 * @param moccPort
	 * @return
	 */
	public Expression initialRateExpression() {
		return ((constTOKEN_INITIAL_RATE == null))
//				|| moccPort.hasCycloStaticChannel())
				? XLIA_EXPRESSION.zero()
				: XLIA_EXPRESSION.createExpression(constTOKEN_INITIAL_RATE);
	}

	/**
	 * Getter for current cyclostatic rate of a port
	 * @param moccPort
	 * @return
	 */
	public Expression cycloStaticRateExpression() {
		assert( moccPort.hasCycloStaticRate()
				&& (constTOKEN_RATE_CSDF != null) );

		return XLIA_EXPRESSION.createArrayElement(
				constTOKEN_RATE_CSDF,
				XLIA_EXPRESSION.createExpression(XLIA_EXPRESSION.OP_MODULO,
						this.moccActorHelper.varActivationCount,
						XLIA_EXPRESSION.createExpression(
								moccPort.getCycloStaticRate().length)));
	}


	/**
	 * Getter using cyclo-static Rate
	 * @param moccPort
	 * @return
	 */
	public Expression rateExpression() {
		if( moccPort.hasCycloStaticRate() ) {
			return cycloStaticRateExpression();
		}
		else {
			return XLIA_EXPRESSION.createExpression(constTOKEN_RATE);
		}
	}


	/**
	 * addingNonZeroCycloRateCondition
	 * @param moccPort
	 * @param condition
	 * @return
	 */
	public Expression isUndefinedModeCondition(
			final EnumerationLiteral MODE_UNDEFINED)
	{
		final Expression condition =
				XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
						varReceivedMode, MODE_UNDEFINED);

		if( moccPort.hasCycloStaticRate() ) {
			return XLIA_EXPRESSION.createAND(condition,
					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_GT,
							cycloStaticRateExpression(), XLIA_EXPRESSION.zero()) );
		}
		else {
			return condition;
		}
	}


	/**
	 * nonZeroCycloRate condition
	 * @param moccPort
	 * @return
	 */
	public Expression nonZeroCycloRateCondition() {
		return XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_GT,
				cycloStaticRateExpression(), XLIA_EXPRESSION.zero() );
	}

	/**
	 * Adding if-condition for non-zero cyclo-static rate
	 * @param blockContainer
	 * @param moccPort
	 * @return
	 */
	public BlockStatement testIfHasCycloRate(final BlockStatement blockContainer)
	{
		if( moccPort.hasCycloStaticRate() ) {
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(
					blockContainer, nonZeroCycloRateCondition() );
			// theBlock
			return XLIA_STATEMENT.createBlockStatement(ifStatement);
		}

		return blockContainer;

	}



	/**
	 * create xLIA Port for Token
	 * @param moccPort
	 * @param direction
	 * @param xliaActor
	 * @param tokenType
	 * @return
	 */
	public Port createPortToken(final String name,
			final MoccPort moccPort, final ChannelDirection direction,
			final Statemachine xliaActor, final DataType tokenType)
	{
		final String prefix =
				(direction == ChannelDirection.INPUT) ? "received": "sent";

		final Port xliaPort =
				XLIA_INFRA.createPort(name, tokenType, prefix + "Token");

		xliaPort.setVisibility(VisibilityKind.PUBLIC);

		xliaPort.setDirection(direction);

		xliaActor.getPort().add( xliaPort );

		return xliaPort;
	}

	public Port createPortToken(
			final MoccPort moccPort, final ChannelDirection direction,
			final Statemachine xliaActor, final DataType tokenType)
	{
		return createPortToken(moccPort.getName(),
				moccPort, direction, xliaActor, tokenType);
	}

	/**
	 * create xLIA Port for Token and Mode
	 * @param moccPort
	 * @param direction
	 * @param xliaActor
	 * @param tokenType
	 * @param modeType
	 * @return
	 */
	public Port createPortTokenMode(final String name, final MoccPort moccPort,
			final ChannelDirection direction, final Statemachine xliaActor,
			final DataType tokenType, final DataType modeType)
	{
		final String prefix =
				(direction == ChannelDirection.INPUT) ? "received": "sent";

		final Port xliaPort = XLIA_INFRA.createPort(name,
				tokenType, prefix + "Token", modeType, prefix + "Mode");

		xliaPort.setVisibility(VisibilityKind.PUBLIC);

		xliaPort.setDirection(direction);

		xliaActor.getPort().add( xliaPort );

		return xliaPort;
	}

	public Port createPortTokenMode(final MoccPort moccPort,
			final ChannelDirection direction, final Statemachine xliaActor,
			final DataType tokenType, final DataType modeType)
	{
		return createPortTokenMode(moccPort.getName(),
				moccPort, direction, xliaActor, tokenType, modeType);
	}




	/**
	 * OUTPUT PORT -> XLIA
	 * @param moccPort
	 * @param xliaActor
	 * @param aLWAYS_USING_MODE
	 */
	public void createOutputPort(final Statemachine xliaActor,
			final EnumerationType MODE_SET_TYPE, final boolean ALWAYS_USING_MODE)
	{
		// CONSTANT: TOKEN PRODUCTION
		final DataType varType =
				XLIA_DATATYPE.createRationalOrInteger(moccPort.isRational());

		final String targetActor =
				moccPort.getChannel().getInputActor().getName();//.toUpperCase();

		final Expression value = moccPort.isRational() ?
				XLIA_EXPRESSION.createRational(
						moccPort.getRate(), moccPort.getRateDenominator())
				: XLIA_EXPRESSION.createInteger(moccPort.getRate());

		this.constTOKEN_RATE = XLIA_INFRA.createConstant(
				varType, "PRODUCTION_TO_" + targetActor, value);
		xliaActor.getVariable().add(this.constTOKEN_RATE);


		if( moccPort.hasCycloStaticRate() ) {
			final int[] cycloStaticRate = moccPort.getCycloStaticRate();
			this.constTOKEN_RATE_CSDF = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createInteger(cycloStaticRate.length),
					"CSDF_PRODUCTION_TO_" + targetActor,
					XLIA_EXPRESSION.createCollection(cycloStaticRate));
			xliaActor.getVariable().add(constTOKEN_RATE_CSDF);
		}

		// OUTPUT PORT
//!@! CSDF : createRationalOrInteger(moccPort.isRational() ==> createInteger()
		final DataType tokenType = XLIA_DATATYPE.createInteger();

		if( ALWAYS_USING_MODE || moccPort.isOutputMode()  )
		{
			final DataType modeType =
					XLIA_DATATYPE.createReference(MODE_SET_TYPE);

			this.xliaPort = createPortTokenMode("out#" + 
					moccPort.getChannel().getName(), moccPort,
					ChannelDirection.OUTPUT, xliaActor, tokenType, modeType);
		}
		else {
			this.xliaPort = createPortToken("out#" + 
					moccPort.getChannel().getName(),
					moccPort, ChannelDirection.OUTPUT, xliaActor, tokenType);
		}
	}


	/**
	 * INPUT PORT -> XLIA
	 * @param moccPort
	 * @param xliaActor
	 * @param aLWAYS_USING_MODE
	 */
	public void createInputPort(final Statemachine xliaActor,
			final EnumerationType MODE_SET_TYPE, final boolean ALWAYS_USING_MODE,
			final boolean generatedChannelPort)
	{
		// CONSTANT: REQUIRED TOKENS RATE
		DataType constType =
				XLIA_DATATYPE.createRationalOrInteger(moccPort.isRational());

		final String sourceActor =
				moccPort.getChannel().getOutputActor().getName();

		Expression value = moccPort.isInputRational() ?
				XLIA_EXPRESSION.createRational(
						moccPort.getRate(), moccPort.getRateDenominator())
				: XLIA_EXPRESSION.createInteger(moccPort.getRate());

		this.constTOKEN_RATE = XLIA_INFRA.createConstant(constType,
				"REQUIRED_FROM_" + sourceActor/*.toUpperCase()*/, value);
		xliaActor.getVariable().add(this.constTOKEN_RATE);

		if( moccPort.hasCycloStaticRate() ) {
			final int[] cycloStaticRate = moccPort.getCycloStaticRate();
			this.constTOKEN_RATE_CSDF = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createInteger(cycloStaticRate.length),
					"CSDF_REQUIRED_FROM_" + sourceActor,
					XLIA_EXPRESSION.createCollection(cycloStaticRate));
			xliaActor.getVariable().add(this.constTOKEN_RATE_CSDF);
		}

		// CONSTANT: INITIAL TOKEN COUNT
		final MoccChannel channel = moccPort.getChannel();
		if( channel.hasInitialRate() ) {
			constType = XLIA_DATATYPE.createRationalOrInteger(
					channel.hasRationalRate());

			value = channel.hasRationalRate() ?
					XLIA_EXPRESSION.createRational(
							channel.getInitialRate(),
							channel.getInitialRateDenominator())
					: XLIA_EXPRESSION.createInteger(channel.getInitialRate());

			this.constTOKEN_INITIAL_RATE = XLIA_INFRA.createConstant(constType,
					"INITIAL_TOKEN_FROM_" + sourceActor/*.toUpperCase()*/, value);

			xliaActor.getVariable().add(this.constTOKEN_INITIAL_RATE);

			if( channel.hasInitialMode() ) {
				constType = XLIA_DATATYPE.createReference(MODE_SET_TYPE);

				this.constMODE_INITIAL = XLIA_INFRA.createConstant(constType,
						"INITIAL_MODE_FROM_" + sourceActor/*.toUpperCase()*/,
						XLIA_EXPRESSION.createExpression(
								XLIA_DATATYPE.getEnumLiteral(MODE_SET_TYPE,
										channel.getInitialMode().getLiteral())));

				xliaActor.getVariable().add(this.constMODE_INITIAL);
			}
		}


		// VARIABLE: TOKEN COUNT
//!@! CSDF : createRationalOrInteger(moccPort.isRationalTokenCount() ==> createInteger()
		final DataType tokenCountType = //XLIA_DATATYPE.createInteger();
				XLIA_DATATYPE.createRationalOrInteger(channel.hasRationalRate());

		this.varReceivedTokenCount = XLIA_INFRA.createVariable(
				tokenCountType, "tokenCount_from_" + sourceActor);
		xliaActor.getVariable().add(this.varReceivedTokenCount);

		// INPUT PORT
//!@! CSDF : createRationalOrInteger(moccPort.isOutputRational() ==> createInteger()
		final DataType portTokenType = XLIA_DATATYPE.createInteger();

//!@! CSDF : createRationalOrInteger(moccPort.isRational() ==> createInteger()
//						moccPort.isOutputRational());
		final DataType channelTokenType = XLIA_DATATYPE.createInteger();

		if( ALWAYS_USING_MODE || moccPort.isInputMode() )
		{
			this.xliaPort = createPortTokenMode(moccPort,
					ChannelDirection.INPUT, xliaActor, portTokenType,
					XLIA_DATATYPE.createReference(MODE_SET_TYPE));

			this.varReceivedMode = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createReference(MODE_SET_TYPE),
					"receivedMode_from_" + sourceActor);//,
//					XLIA_EXPRESSION.createExpression(
//							this.moccActorHelper.constDEFAULT_MODE));
			xliaActor.getVariable().add(this.varReceivedMode);

			if( generatedChannelPort ) {
				this.xliaChannelPort = createPortTokenMode("in#" +
						moccPort.getChannel().getName(), moccPort,
//						ChannelDirection.INPUT, xliaActor, channelTokenType,
						ChannelDirection.OUTPUT, xliaActor, channelTokenType,
						XLIA_DATATYPE.createReference(MODE_SET_TYPE));
			}
		}
		else {
			this.xliaPort = createPortToken(moccPort,
					ChannelDirection.INPUT, xliaActor, portTokenType);

			if( generatedChannelPort ) {
				this.xliaChannelPort = createPortToken("in#" + 
						moccPort.getChannel().getName(), moccPort,
//						ChannelDirection.INPUT, xliaActor, channelTokenType);
						ChannelDirection.OUTPUT, xliaActor, channelTokenType);
			}
		}
	}


}
