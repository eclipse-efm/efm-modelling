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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.xlia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.ecore.formalml.common.VisibilityKind;
import org.eclipse.efm.ecore.formalml.datatype.CollectionType;
import org.eclipse.efm.ecore.formalml.datatype.DataType;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression;
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection;
import org.eclipse.efm.ecore.formalml.infrastructure.Connector;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction;
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter;
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet;
import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;
import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem;
import org.eclipse.efm.ecore.formalml.statemachine.Pseudostate;
import org.eclipse.efm.ecore.formalml.statemachine.Region;
import org.eclipse.efm.ecore.formalml.statemachine.State;
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine;
import org.eclipse.efm.ecore.formalml.statemachine.Transition;
import org.eclipse.efm.ecore.formalml.statemachine.Vertex;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement;
import org.eclipse.efm.ecore.formalml.statement.IfStatement;
import org.eclipse.efm.ecore.formalml.statement.MetaStatement;
import org.eclipse.efm.formalml.ecore.factory.XLIA_DATATYPE;
import org.eclipse.efm.formalml.ecore.factory.XLIA_EXPRESSION;
import org.eclipse.efm.formalml.ecore.factory.XLIA_INFRA;
import org.eclipse.efm.formalml.ecore.factory.XLIA_STATEMACHINE;
import org.eclipse.efm.formalml.ecore.factory.XLIA_STATEMENT;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccChannel;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccPort;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccSystem;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.feature.MoccSystemFeature;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.helper.MoccActorHelper;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.helper.MoccPortHelper;

public class MoCC2XLIA {

	protected boolean CONFORMANCE_PURPOSE;

	// For Moka Trace compatibility
	protected boolean ALWAYS_USING_MODE;

	protected Map< MoccActor, MoccActorHelper> actorHelper;

	protected Map< MoccPort , MoccPortHelper > portHelper;

	protected MoccSystem moccSystem;

	public XliaModel xliaModel;

	protected XliaSystem xliaSystem;
	protected Behavior mainBehavior;

	protected Variable varTick;
	protected Variable varTickPeriod;
	protected Variable varTimeDelta;

	protected Variable varTimestamp;

	protected Variable varCanBeActivate;

	public EnumerationType MODE_SET_TYPE;

	public EnumerationLiteral MODE_NOMINAL;
	public EnumerationLiteral MODE_UNDEFINED;

	protected Routine macroReceiveToken;
	protected Routine macroReceiveTokenMode;

	protected Routine macroJsonTraceHeader;
	protected Routine macroJsonTraceBegin;
	protected Routine macroJsonTraceBody1;
	protected Routine macroJsonTraceBody2;
	protected Routine macroJsonTraceEnd;
	protected Routine macroJsonTraceFooter;


	public MoCC2XLIA(final MoccSystem moccSystem, final boolean conformance) {
		this.CONFORMANCE_PURPOSE = conformance;

		this.actorHelper = new HashMap<MoccActor, MoccActorHelper>();

		this.portHelper  = new HashMap<MoccPort , MoccPortHelper >();

		this.moccSystem = moccSystem;

		this.xliaModel = null;

		this.xliaSystem = null;

		this.mainBehavior = null;

		this.varTick         = null;
		this.varTickPeriod   = null;
		this.varTimeDelta = null;

		this.varTimestamp    = null;

		this.varCanBeActivate = null;

		this.MODE_SET_TYPE  = null;
		this.MODE_NOMINAL   = null;
		this.MODE_UNDEFINED = null;

		this.macroReceiveToken     = null;
		this.macroReceiveTokenMode = null;

		this.macroJsonTraceHeader  = null;
		this.macroJsonTraceBegin   = null;
		this.macroJsonTraceBody1   = null;
		this.macroJsonTraceBody2   = null;
		this.macroJsonTraceEnd     = null;
		this.macroJsonTraceFooter  = null;
	}

	public MoCC2XLIA(final MoccSystem moccSystem) {
		this(moccSystem, true);
	}


	protected MoccActorHelper helper(final MoccActor actor) {
		return actorHelper.get(actor);
	}

	protected MoccPortHelper helper(final MoccPort port) {
		return portHelper.get(port);
	}


	public void transform()
	{
		// Basic static analysis feature
		final MoccSystemFeature moccSystemFeature =
				this.moccSystem.computeFeatureStrict();

		assert (moccSystemFeature.consistency) :
				"Unexpected a non-consistency MoCC System : " +
				this.moccSystem.getName();

		if( ! moccSystemFeature.consistency ) {
			this.xliaModel = null;
			this.xliaSystem = null;

			return;
		}


		// For Moka Trace compatibility
		ALWAYS_USING_MODE = true; //moccSystem.FEATURE.hasModeSelector;


		// Transformation to XLIA
		this.xliaModel = XLIA_INFRA.createModel();
		this.xliaSystem = XLIA_INFRA.createSystem(this.moccSystem.getName());
		this.xliaModel.setSystem( this.xliaSystem );

		// MODE SET TYPE
		this.MODE_SET_TYPE = XLIA_DATATYPE.addEnum(xliaSystem,
				"MODE_SET", this.moccSystem.getModeLiterals());

		// VALUE: NOMINAL - UNDEFINED - MODE
		this.MODE_NOMINAL = XLIA_DATATYPE.getEnumLiteral(
				this.MODE_SET_TYPE, this.moccSystem.NOMINAL.getLiteral());

		this.MODE_UNDEFINED =  XLIA_DATATYPE.getEnumLiteral(
				this.MODE_SET_TYPE, this.moccSystem.UNDEFINED.getLiteral());

		// MACRO ROUTINES
		this.macroReceiveToken = createReceiveTokenRoutine(this.xliaSystem);

		this.macroReceiveTokenMode =
				createReceiveTokenModeRoutine(this.xliaSystem);

		// TIME CONFIGURATION
		this.varTimeDelta = XLIA_INFRA.createConstant(
				XLIA_DATATYPE.createInterger(), "TIME_DELTA",
				XLIA_EXPRESSION.createInteger(
						moccSystemFeature.time_interval));
		this.xliaSystem.getVariable().add(this.varTimeDelta);

		this.varTickPeriod = XLIA_INFRA.createConstant(
				XLIA_DATATYPE.createInterger(), "TICK_PERIOD",
				XLIA_EXPRESSION.createInteger(
						moccSystemFeature.tick_period));
		this.xliaSystem.getVariable().add(this.varTickPeriod);

		this.varTick = XLIA_INFRA.createVariable(
				XLIA_DATATYPE.createInterger(),
				"tick", XLIA_EXPRESSION.zero());
		this.xliaSystem.getVariable().add(this.varTick);

		this.varTimestamp = XLIA_INFRA.createVariable(
				XLIA_DATATYPE.createInterger(),
				"timestamp", XLIA_EXPRESSION.zero());
		this.xliaSystem.getVariable().add(this.varTimestamp);


		// GENERAL ENABLED ACTIVATION
		this.varCanBeActivate = XLIA_INFRA.createVariable(
				XLIA_DATATYPE.createBoolean(),
				"canBeActivate", XLIA_EXPRESSION.trueValue());
		this.xliaSystem.getVariable().add(this.varCanBeActivate);

		// MACRO TRACE ROUTINES
		if( ! this.CONFORMANCE_PURPOSE ) {
			createJsonTraceRoutine(this.xliaSystem);
		}

		// ACTOR TRANSFORMATIONS
		for (final MoccActor actor : this.moccSystem.getActor()) {
			this.xliaSystem.getMachine().add(
					transformActor(actor, moccSystemFeature) );
		}


		// MAIN BEHAVIOR
		this.mainBehavior = XLIA_INFRA.createBehavior();
		this.xliaSystem.setMain(this.mainBehavior);

		// MODEL OF INTERACTION
		transformChannel();

		// MODEL OF EXECUTION
		computeScheduler(moccSystemFeature);
	}


	private void createJsonTraceRoutine(final Machine machine) {
		// TRACE BEGIN
		final ParameterSet parameterSetBegin =
				XLIA_INFRA.createParameterSet();

		final Parameter kind = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createString(), "kind");
		parameterSetBegin.getParameter().add(kind);

		final Parameter actor = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createString(), "actor");
		parameterSetBegin.getParameter().add(actor);

		final Parameter nature = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createString(), "nature");
		parameterSetBegin.getParameter().add(nature);


		final BlockStatement blockBegin =
				XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addTrace(blockBegin,
				XLIA_EXPRESSION.createExpression("\n\t\t{"),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\"kind\": \""),
						XLIA_EXPRESSION.createExpression(kind),
						XLIA_EXPRESSION.createExpression("\","),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\"tick\": "),
//						XLIA_EXPRESSION.createExpression(
//								XLIA_EXPRESSION.OP_MULT,
//								this.varTick, this.varTimeDelta),
						XLIA_EXPRESSION.createExpression(this.varTick),
						XLIA_EXPRESSION.createExpression(","),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\"timestamp\": "),
						XLIA_EXPRESSION.createExpression(this.varTimestamp),
						XLIA_EXPRESSION.createExpression(","),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\"actor\": \""),
						XLIA_EXPRESSION.createExpression(actor),
						XLIA_EXPRESSION.createExpression("\","),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\"nature\": "),
						XLIA_EXPRESSION.createExpression(nature),
						XLIA_EXPRESSION.createExpression(","),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\"data\": ["));

		this.macroJsonTraceBegin = XLIA_INFRA.createMacroRoutine(machine,
				"jsonTraceBegin", parameterSetBegin, blockBegin);

		// TRACE BODY [ WITH MODE ]
		this.macroJsonTraceBody1 =
				createJsonTraceBodyRoutine(machine, "jsonTraceBody", "");

		this.macroJsonTraceBody2 =
				createJsonTraceBodyRoutine(machine, "jsonTraceBodyNext", ",");

		// TRACE END
		final BlockStatement blockEnd =
				XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addTrace(blockEnd,
				XLIA_EXPRESSION.createExpression("\n\t\t\t]"),
				XLIA_EXPRESSION.createExpression("\n\t\t},"));
		this.macroJsonTraceEnd = XLIA_INFRA.createMacroRoutine(
				machine, "jsonTraceEnd", null, blockEnd);
	}

	private Routine createJsonTraceBodyRoutine(final Machine machine,
			final String routineName, final String traceSeparator)
	{
		// TRACE BODY [ WITH MODE ]
		final ParameterSet parameterSet =
				XLIA_INFRA.createParameterSet();

		final Parameter channel = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createString(), "aChannel");
		parameterSet.getParameter().add(channel);

		final Parameter tokenCount = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createRational(), "tokenCount");
		parameterSet.getParameter().add(tokenCount);

		final BlockStatement block =
				XLIA_STATEMENT.createBlockStatement();

		final MetaStatement traceStatement = XLIA_STATEMENT.addTrace(block,
				XLIA_EXPRESSION.createExpression(traceSeparator + "\n\t\t\t\t{"),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"channel\": \""),
						XLIA_EXPRESSION.createExpression(channel),
						XLIA_EXPRESSION.createExpression("\","),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"count\": \""),
						XLIA_EXPRESSION.createExpression(tokenCount),
						XLIA_EXPRESSION.createExpression("\","));

		if( ALWAYS_USING_MODE ) {
			final Parameter tokenMode = XLIA_INFRA.createParameter(
					XLIA_DATATYPE.createString(), "tokenMode");
			parameterSet.getParameter().add(tokenMode);

			traceStatement.getOperand().add(
					XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"mode\": \""));
			traceStatement.getOperand().add(
						XLIA_EXPRESSION.createCast(
								XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
								tokenMode) );
			traceStatement.getOperand().add(
						XLIA_EXPRESSION.createExpression("\"") );
		}
		else {
			traceStatement.getOperand().add(
					XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"mode\": \"" +
					this.moccSystem.NOMINAL.getLiteral() + "\"") );
		}

		traceStatement.getOperand().add(
				XLIA_EXPRESSION.createExpression("\n\t\t\t\t}"));

		return XLIA_INFRA.createMacroRoutine(
				machine, routineName, parameterSet, block);
	}


	private void invokeJsonTraceBodyConsumptionMode(final boolean isFirst,
			final BlockStatement block, final MoccPort port)
	{
		if( this.CONFORMANCE_PURPOSE ) {
			return;
		}

		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceBody1
						: this.macroJsonTraceBody2),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				XLIA_EXPRESSION.createExpression(
						helper(port).constTOKEN_RATE),
				XLIA_EXPRESSION.createExpression(
						helper(port).varReceivedMode));
	}

	private void invokeJsonTraceBodyConsumption(final boolean isFirst,
			final BlockStatement block, final MoccPort port)
	{
		if( this.CONFORMANCE_PURPOSE ) {
			return;
		}

		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceBody1
						: this.macroJsonTraceBody2),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				XLIA_EXPRESSION.createExpression(
						helper(port).constTOKEN_RATE));
//				XLIA_EXPRESSION.createExpression(this.MODE_NOMINAL));
	}


	private void invokeJsonTraceBodyProductionMode(
			final boolean isFirst, final BlockStatement block,
			final MoccActor actor, final MoccPort port)
	{
		if( this.CONFORMANCE_PURPOSE ) {
			return;
		}

		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceBody1
						: this.macroJsonTraceBody2),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				XLIA_EXPRESSION.createExpression(
						helper(port).constTOKEN_RATE),
				XLIA_EXPRESSION.createExpression(
						helper(actor).varProcessingMode));
	}

	private void invokeJsonTraceBodyProduction(final boolean isFirst,
			final BlockStatement block, final MoccPort port)
	{
		if( this.CONFORMANCE_PURPOSE ) {
			return;
		}

		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceBody1
						: this.macroJsonTraceBody2),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				XLIA_EXPRESSION.createExpression(
						helper(port).constTOKEN_RATE));
//				XLIA_EXPRESSION.createExpression(this.MODE_NOMINAL));
	}


	protected Routine createReceiveTokenRoutine(final Machine machine) {
		final ParameterSet parameterSet = XLIA_INFRA.createParameterSet();

		final Parameter receivedPort = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInstancePort(), "receivedPort");
		parameterSet.getParameter().add(receivedPort);

		final Parameter receivedToken = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createRational(), "receivedToken");
		parameterSet.getParameter().add(receivedToken);

		final Parameter tokenCount = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createRational(), "tokenCount");
		parameterSet.getParameter().add(tokenCount);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addInputCom(block, receivedPort, receivedToken);

		XLIA_STATEMENT.addIncrementation(block, tokenCount,
				XLIA_EXPRESSION.createExpression(receivedToken));

		return XLIA_INFRA.createMacroRoutine(
				machine, "receiveToken", parameterSet, block);
	}

	protected Routine createReceiveTokenModeRoutine(final Machine machine) {
		final ParameterSet parameterSet = XLIA_INFRA.createParameterSet();

		final Parameter receivedPort = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInstancePort(), "receivedPort");
		parameterSet.getParameter().add(receivedPort);

		final Parameter receivedToken = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createRational(), "receivedToken");
		parameterSet.getParameter().add(receivedToken);

		final Parameter tokenCount = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createRational(), "tokenCount");
		parameterSet.getParameter().add(tokenCount);

		final Parameter modeParam = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), "mode");
		parameterSet.getParameter().add(modeParam);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addInputCom(block,
				receivedPort, receivedToken, modeParam);

		XLIA_STATEMENT.addIncrementation(block, tokenCount,
				XLIA_EXPRESSION.createExpression(receivedToken));

		return XLIA_INFRA.createMacroRoutine(machine,
				"receiveTokenMode", parameterSet, block);
	}


	public Statemachine transformActor(
			final MoccActor actor, final MoccSystemFeature moccSystemFeature)
	{
		// Basic static analysis feature
		final Statemachine xliaActor =
				XLIA_STATEMACHINE.createStatemachine(actor.getName());

		actorHelper.put(actor, new MoccActorHelper(actor, xliaActor));

		final MoccActorHelper actorHELPER = helper(actor);

		// MODE TYPE
		if( ALWAYS_USING_MODE ) {
			modeActorDeclaration(actor, actorHELPER, xliaActor);
		}

		if( actor.FEATURE.isModeSelector ) {
			XLIA_DATATYPE.addEnumLiterals(
					this.MODE_SET_TYPE, actor.getSelectionSetLiterals());

			actorHELPER.modeSelectionSet = modeLiterals(
					this.MODE_SET_TYPE, actor.getSelectionSetLiterals());

			if( actor.FEATURE.isModeProcessor ) {
				selectorProcessorActorDeclaration(actor, xliaActor);
			}
			else {
				selectorActorDeclaration(actor, xliaActor);
			}
		}
		else if( actor.FEATURE.isModeProcessor ) {
			processorActorDeclaration(actor, xliaActor);
		}

		// CONSTANT: FREQUENCY
		if( actor.FEATURE.isTimed ) {
			actorHELPER.constFREQUENCY = XLIA_INFRA.createConstant(
					XLIA_DATATYPE.createInterger(), "FREQUENCY",
					XLIA_EXPRESSION.createInteger(actor.getFrequency()));
			xliaActor.getVariable().add(actorHELPER.constFREQUENCY);

			// For Activation
			actorHELPER.constACTIVATION_TICK =
					XLIA_INFRA.createVariable(
							XLIA_DATATYPE.createBoolean(
									actor.FEATURE.activation.length),
							"ACTIVATION_TICK",
							XLIA_EXPRESSION.createCollection(
									actor.FEATURE.activation));
			xliaActor.getVariable().add(actorHELPER.constACTIVATION_TICK);
		}
		else {
			actorHELPER.constREPETITION = XLIA_INFRA.createPublicConstant(
					XLIA_DATATYPE.createInterger(), "REPETITION",
					XLIA_EXPRESSION.createInteger(actor.FEATURE.repetition));
			xliaActor.getVariable().add(actorHELPER.constREPETITION);

			// For scheduler
			actorHELPER.varActivationCount =
					XLIA_INFRA.createPublicLocaleVariable(
							XLIA_DATATYPE.createInterger(),
							"activationCount", XLIA_EXPRESSION.zero());
			xliaActor.getVariable().add(actorHELPER.varActivationCount);
		}

		// VARIABLE: INTEGER TOKEN
		if( actor.FEATURE.hasIntegerRate ) {
			actorHELPER.varIntToken = XLIA_INFRA.createLocaleVariable(
					XLIA_DATATYPE.createInterger(),
					"intToken", XLIA_EXPRESSION.zero());
			xliaActor.getVariable().add(actorHELPER.varIntToken);
		}

		// VARIABLE: RATIONAL TOKEN
		if( actor.FEATURE.hasRationalRate ) {
			actorHELPER.varRatToken = XLIA_INFRA.createLocaleVariable(
					XLIA_DATATYPE.createRational(),
					"ratToken", XLIA_EXPRESSION.zero());
			xliaActor.getVariable().add(actorHELPER.varRatToken);
		}

		for( final MoccPort moccPort : actor.getInputPort() ) {
			transformInputPort(moccPort, xliaActor);
		}

		for( final MoccPort moccPort : actor.getOutputPort() ) {
			transformOutputPort(moccPort, xliaActor);
		}

		// MACRO ROUTINES
		if( actor.hasInputPort() ) {
			computeInitializationBehavior(actor);

			computeReceptionBehavior(actor);

			computeActivationTestBehavior(actor, moccSystemFeature);

			computeConsumptionBehavior(actor);

			computeConsumptionTraceBehavior(actor);
		}
		else {
			computeActivationTestBehavior(actor, moccSystemFeature);
		}

		if( actor.hasOutputPort() ) {
			computeProductionBehavior(actor);
		}

		if( actor.FEATURE.isModeSelector )
		{
			if( actor.FEATURE.isModeProcessor )
			{
				// Mode Selector & Processor
				transformActor(actor, xliaActor);
			}
			else {
				if( actor.FEATURE.hasInput )
				{
					// Mode Selector
					transformActor(actor, xliaActor);
				}
				else {
					// Mode Selector without input
					transformOutputActor(actor, xliaActor);
				}
			}
		}
		else if( actor.FEATURE.isModeProcessor )
		{
			if( actor.FEATURE.hasInput )
			{
				if( actor.FEATURE.hasOutput )
				{
					// Mode Processor
					transformProcessorActor(actor, xliaActor);
				}
				else {
					// Mode Processor without output
					transformInputActor(actor, xliaActor);
				}
			}
			else {
				// Mode Processor without input
				transformOutputActor(actor, xliaActor);
			}
		}
		else
		{
			if( actor.FEATURE.hasInput )
			{
				if( actor.FEATURE.hasOutput )
				{
					// Regular
					transformActor(actor, xliaActor);
				}
				else {
					// Regular without output
					transformInputActor(actor, xliaActor);
				}
			}
			else {
				// Regular without input
				transformOutputActor(actor, xliaActor);
			}
		}

		return xliaActor;
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
	 */
	public void transformOutputPort(
			final MoccPort moccPort, final Statemachine xliaActor)
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

		final Variable constTokenProductionRate =
				XLIA_INFRA.createConstant(
						varType, "PRODUCTION_TO_" + targetActor, value);
		xliaActor.getVariable().add(constTokenProductionRate);

		// OUTPUT PORT
		final DataType tokenType =
				XLIA_DATATYPE.createRationalOrInteger(moccPort.isRational());

		Port xliaPort = null;
		if( ALWAYS_USING_MODE )
		{
			final DataType modeType =
					XLIA_DATATYPE.createReference(this.MODE_SET_TYPE);

			xliaPort = createPortTokenMode(
					moccPort.getChannel().getName(), moccPort,
					ChannelDirection.OUTPUT, xliaActor, tokenType, modeType);
		}
		else {
			xliaPort = createPortToken(moccPort.getChannel().getName(),
					moccPort, ChannelDirection.OUTPUT, xliaActor, tokenType);
		}

		portHelper.put(moccPort,
				new MoccPortHelper(xliaPort, constTokenProductionRate));
	}

	/**
	 * INPUT PORT -> XLIA
	 * @param moccPort
	 * @param xliaActor
	 */
	public void transformInputPort(
			final MoccPort moccPort, final Statemachine xliaActor)
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

		final Variable constREQ = XLIA_INFRA.createConstant(constType,
				"REQUIRED_FROM_" + sourceActor/*.toUpperCase()*/, value);
		xliaActor.getVariable().add(constREQ);

		// CONSTANT: INITIAL TOKEN COUNT
		Variable tokenInitialRate = null;
		final MoccChannel channel = moccPort.getChannel();
		if( channel.hasInitialRate() ) {
			constType = XLIA_DATATYPE.createRationalOrInteger(
					channel.hasRationalRate());

			value = channel.hasRationalRate() ?
					XLIA_EXPRESSION.createRational(
							channel.getInitialRate(),
							channel.getInitialRateDenominator())
					: XLIA_EXPRESSION.createInteger(channel.getInitialRate());

			tokenInitialRate = XLIA_INFRA.createConstant(constType,
					"INITIAL_FROM_" + sourceActor/*.toUpperCase()*/, value);

			xliaActor.getVariable().add(tokenInitialRate);
		}


		// VARIABLE: TOKEN COUNT
		final DataType tokenCountType =
				XLIA_DATATYPE.createRationalOrInteger(
						moccPort.isRationalTokenCount());

		final Variable varTokenCount = XLIA_INFRA.createVariable(
				tokenCountType, "tokenCount_from_" + sourceActor);
		xliaActor.getVariable().add(varTokenCount);

		// INPUT PORT
		final DataType portTokenType =
				XLIA_DATATYPE.createRationalOrInteger(
						moccPort.isOutputRational());

		final DataType channelTokenType =
				XLIA_DATATYPE.createRationalOrInteger(moccPort.isRational());
//						moccPort.isOutputRational());

		Port xliaPort = null;
		Port xliaChannelPort = null;
		Variable varReceivedMode = null;

		if( ALWAYS_USING_MODE )
		{
			xliaPort = createPortTokenMode(moccPort,
					ChannelDirection.INPUT, xliaActor, portTokenType,
					XLIA_DATATYPE.createReference(this.MODE_SET_TYPE));

			varReceivedMode = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
					"receivedMode_from_" + sourceActor);
			xliaActor.getVariable().add(varReceivedMode);

			xliaChannelPort = createPortTokenMode(
					moccPort.getChannel().getName(), moccPort,
//					ChannelDirection.INPUT, xliaActor, channelTokenType,
					ChannelDirection.OUTPUT, xliaActor, channelTokenType,
					XLIA_DATATYPE.createReference(this.MODE_SET_TYPE));
		}
		else {
			xliaPort = createPortToken(moccPort,
					ChannelDirection.INPUT, xliaActor, portTokenType);

			xliaChannelPort = createPortToken(
					moccPort.getChannel().getName(), moccPort,
//					ChannelDirection.INPUT, xliaActor, channelTokenType);
					ChannelDirection.OUTPUT, xliaActor, channelTokenType);
			}

		// Mapping: MoccPort-->PortHelper
		portHelper.put(moccPort, new MoccPortHelper(xliaPort, xliaChannelPort,
				tokenInitialRate, varTokenCount, varReceivedMode, constREQ));
	}


	/**
	 * CHANNEL -> XLIA
	 */
	public void transformChannel()
	{
		final ModelOfInteraction moInteraction =
				XLIA_INFRA.createMOI(this.mainBehavior);

		if( CONFORMANCE_PURPOSE ) {
			final Connector connectorEnv =
					XLIA_INFRA.createConnectorEnv("channel_env");

			for( final MoccActor actor : this.moccSystem.getActor() ) {
				for( final MoccPort moccPort : actor.getInputPort() ) {
//					XLIA_INFRA.addConnectorEndInputPoint(connectorEnv,
					XLIA_INFRA.addConnectorEndOutputPoint(connectorEnv,
							helper(moccPort.actor).statemachine,
							helper(moccPort).xliaChannelPort );
				}
			}

			if( ! connectorEnv.getConnectorEnd().isEmpty() ) {
				moInteraction.getConnectors().add( connectorEnv );
			}
		}

		for( final MoccChannel channel : this.moccSystem.getChannel() ) {
			final MoccActor outputActor = channel.getOutputActor();

			final Connector connector =
					XLIA_INFRA.createConnectorFifo(channel.getName(),
							outputActor.FEATURE.repetition);

			XLIA_INFRA.addConnectorEndOutputPoint(connector,
					helper(outputActor).statemachine,
					helper(channel.getOutputPort()).xliaPort );

			XLIA_INFRA.addConnectorEndInputPoint(connector,
					helper(channel.getInputActor()).statemachine,
						helper(channel.getInputPort()).xliaPort);

			moInteraction.getConnectors().add( connector );
		}
	}


	public void computeScheduler(final MoccSystemFeature moccSystemFeature)
	{
		final ModelOfExecution moExcecution = XLIA_INFRA.createMOE(this.mainBehavior);

		// MOE: RUN
		final Routine runRoutine =
				XLIA_INFRA.createRoutine(XLIA_STATEMENT.OP_RUN);
		moExcecution.setRunRoutine(runRoutine);

		final BlockStatement blockRun =
				XLIA_STATEMENT.createBlockStatement(runRoutine);

		// Authorized global activation
		XLIA_STATEMENT.addAssignment(blockRun,
				this.varCanBeActivate,
				XLIA_EXPRESSION.trueValue());

		XLIA_STATEMENT.addActivitySchedule(blockRun);

		// Test if a timed actor disable global activation because of
		// timed constraint failure
		if( moccSystemFeature.hasTimed ) {
			XLIA_STATEMENT.addGuard(blockRun,
					XLIA_EXPRESSION.createExpression(this.varCanBeActivate));
		}

		// MOE: SCHEDULE
		final Routine scheduleRoutine =
				XLIA_INFRA.createRoutine(XLIA_STATEMENT.OP_SCHEDULE);
		moExcecution.setScheduleRoutine(scheduleRoutine);

		final BlockStatement blockSchedule =
				XLIA_STATEMENT.createBlockStatement(scheduleRoutine);

		int activationCount = moccSystemFeature.tick_period;

		if( activationCount > 1 ) {
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockSchedule);
			computeSchedulingActor(moccSystemFeature, ifStatement, 0);

			activationCount = activationCount - 1;
			for( int index = 1 ; index < activationCount; index++) {
				computeSchedulingActor(moccSystemFeature,
						XLIA_STATEMENT.addElseIf(ifStatement), index);
			}

			final BlockStatement elseBlock =
					XLIA_STATEMENT.createElseBlockStatement(ifStatement);
			computeSchedulingActor(moccSystemFeature, elseBlock, activationCount);
		}
		else {
			computeSchedulingActor(moccSystemFeature, blockSchedule, 0);
		}

		// MOE: RUN
		XLIA_STATEMENT.addAssignment(blockRun, this.varTimestamp,
				XLIA_EXPRESSION.createExpression(
						XLIA_EXPRESSION.OP_PLUS,
							this.varTimestamp, this.varTimeDelta));

		XLIA_STATEMENT.addAssignment(blockRun, this.varTick,
					XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_PLUS, this.varTick,
							XLIA_EXPRESSION.createInteger(1)));


		// PERIOD RE-INITIALISATION
		final IfStatement ifPeriod = XLIA_STATEMENT.addIf(blockRun,
				XLIA_EXPRESSION.createRelational(
						XLIA_EXPRESSION.OP_EQ,
						this.varTick, this.varTickPeriod));
	
		Expression untimedConditionalReinitialisation = null;

		final BlockStatement blockReinit =
				XLIA_STATEMENT.createBlockStatement(ifPeriod);

		// NEW PERIOD: INTIALISATION
		XLIA_STATEMENT.addAssignment(blockReinit,
				this.varTick, XLIA_EXPRESSION.zero());

		// NEW PERIOD: CXHECKING
		for( final MoccActor actor : moccSystem.getActor() ) {
			if( ! actor.FEATURE.isTimed ) {
				final MoccActorHelper actorHELPER = helper(actor);

				final RelationalBinaryExpression actorRepetitionCond =
						XLIA_EXPRESSION.createRelational(
								XLIA_EXPRESSION.OP_EQ,
								actorHELPER.statemachine,
								actorHELPER.varActivationCount,
									actorHELPER.constREPETITION);

				if( activationCount > 1 ) {
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

				XLIA_STATEMENT.addAssignment(blockReinit,
						actorHELPER.statemachine,
						actorHELPER.varActivationCount,
						XLIA_EXPRESSION.zero());
			}
		}

		// UNTIMED SYSTEM RE-INITIALISATION
		if( untimedConditionalReinitialisation != null ) {
			ifPeriod.setCondition( untimedConditionalReinitialisation );
		}

		// ENABLED ONLY RECEPTION BEFORE RE-INITIALISATION
		final BlockStatement blockReception =
				XLIA_STATEMENT.createBlockStatement(
						blockReinit, XLIA_STATEMENT.OP_SEQUENCE_WEAK);

		XLIA_STATEMENT.addAssignment(blockReception,
				this.varCanBeActivate,
				XLIA_EXPRESSION.falseValue());


		for( final MoccActor actor : moccSystem.getActor() ) {
			if( actor.FEATURE.hasInput ) {
				XLIA_STATEMENT.addActivityRun(blockReception,
						helper(actor).statemachine);
			}
		}
//		else {
//			computeSchedulingActor(moccSystemFeature, blockSchedule, 0);
//
//			// Tick Incrementation
//			XLIA_STATEMENT.addAssignment(blockRun, this.varTick,
//					XLIA_EXPRESSION.createExpression(
//						XLIA_EXPRESSION.OP_MODULO,
//						XLIA_EXPRESSION.createExpression(
//							XLIA_EXPRESSION.OP_PLUS,
//							this.varTick, XLIA_EXPRESSION.createInteger(1)),
//						XLIA_EXPRESSION.createExpression(
//								this.varTickPeriod)));
//		}
	}


	protected void computeSchedulingActor(
			final MoccSystemFeature moccSystemFeature,
			final ConditionalBlockStatement ifBlock, final int activationIndex) {
		final BlockStatement thenBlock =
				XLIA_STATEMENT.createBlockStatement(ifBlock);

		ifBlock.setCondition(XLIA_EXPRESSION.createRelational(
				XLIA_EXPRESSION.OP_EQ, this.varTick,
				XLIA_EXPRESSION.createInteger(activationIndex)));

		computeSchedulingActor(moccSystemFeature, thenBlock, activationIndex);
	}

	protected void computeSchedulingActor(
			final MoccSystemFeature moccSystemFeature,
			final BlockStatement thenBlock, final int activationIndex) {
//		int statementCount = 0;
		for( final MoccActor actor : moccSystem.getActor() ) {
			if( actor.FEATURE.activation[activationIndex] ) {
				final MoccActorHelper actorHELPER = helper(actor);

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


	////////////////////////////////////////////////////////////////////////////
	// Variable Declaration for Mode Selector / Processor Actor
	public void modeActorDeclaration(final MoccActor actor,
			final MoccActorHelper actorSelectorHelper,
			final Statemachine xliaActor)
	{
		final MoccActorHelper actorHELPER = helper(actor);

		// CONSTANT: DEFAULT MODE
		actorHELPER.constDEFAULT_MODE = XLIA_INFRA.createConstant(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
				"DEFAULT_MODE",
				XLIA_EXPRESSION.createExpression(this.MODE_NOMINAL));
		xliaActor.getVariable().add(actorHELPER.constDEFAULT_MODE);

		// VARIABLE: MODE UTILS
//		actorHELPER.varProducingMode = XLIA_INFRA.createVariable(
//				XLIA_DATATYPE.createReference(
//						actorSelectorHelper.MODE_SET_TYPE),
//				"producingMode",
//				XLIA_EXPRESSION.createExpression(actorHELPER.constDEFAULT_MODE));
//		xliaActor.getVariable().add(actorHELPER.varProducingMode);

		actorHELPER.varProcessingMode = XLIA_INFRA.createVariable(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
				"processingMode",
				XLIA_EXPRESSION.createExpression(actorHELPER.constDEFAULT_MODE));
		xliaActor.getVariable().add(actorHELPER.varProcessingMode);

		if( actor.FEATURE.isModeProcessor ) {
			if( actor.getInputPort().size() > 1 ) {
				actorHELPER.varReceivedModeSet = XLIA_INFRA.createVariable(
						XLIA_DATATYPE.createCollectionSet(
								XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), -1),
						"receivedModeSet");
				xliaActor.getVariable().add(actorHELPER.varReceivedModeSet);
			}
		}
	}


	public void selectorActorDeclaration(
			final MoccActor actor, final Statemachine xliaActor)
	{
		final MoccActorHelper actorHELPER = helper(actor);

		// CONSTANT: SELECTION SET
		final CollectionType constType = XLIA_DATATYPE.createCollectionSet(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), -1);

		actorHELPER.constSELECTIONG_SET =
				XLIA_INFRA.createConstant(constType, "SELECTION_SET",
						XLIA_EXPRESSION.createCollectionLiterals(
								actorHELPER.modeSelectionSet));
		xliaActor.getVariable().add(actorHELPER.constSELECTIONG_SET);
	}


	public void processorActorDeclaration (
			final MoccActor actor, final Statemachine xliaActor)
	{
		final MoccActorHelper actorHELPER = helper(actor);

		// VARIABLE: PROCESSING SET
		final CollectionType constType = XLIA_DATATYPE.createCollectionSet(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), -1);

		actorHELPER.modeProcessingSet = modeLiterals(this.MODE_SET_TYPE,
				actor.getProcessingSetLiterals());

		actorHELPER.constPROCESSING_SET =
				XLIA_INFRA.createConstant(constType, "PROCESSING_SET",
						XLIA_EXPRESSION.createCollectionLiterals(
								actorHELPER.modeProcessingSet));
		xliaActor.getVariable().add(actorHELPER.constPROCESSING_SET);
	}

	public void selectorProcessorActorDeclaration(
			final MoccActor actor, final Statemachine xliaActor)
	{
		selectorActorDeclaration(actor, xliaActor);

		final MoccActorHelper actorHELPER = helper(actor);

		// VARIABLE: PROCESSING SET
		final CollectionType constType = XLIA_DATATYPE.createCollectionSet(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), -1);

		actorHELPER.modeProcessingSet = modeLiterals(
				this.MODE_SET_TYPE, actor.getProcessingSetLiterals());

		actorHELPER.constPROCESSING_SET =
				XLIA_INFRA.createConstant(constType, "PROCESSING_SET",
						XLIA_EXPRESSION.createCollectionLiterals(
								actorHELPER.modeProcessingSet));
		xliaActor.getVariable().add(actorHELPER.constPROCESSING_SET);
	}



	////////////////////////////////////////////////////////////////////////////
	// Mode Processor Actor
	public void transformProcessorActor(
			final MoccActor actor, final Statemachine xliaActor)
	{
//		transformRegularActor(actor, xliaActor); // TODO

		final Region region = XLIA_STATEMACHINE.createRegion(xliaActor);

		final Pseudostate s_init = XLIA_STATEMACHINE.createInitialState("s_init");
		region.getVertex().add(s_init);

		final State s_idle = XLIA_STATEMACHINE.createState("idle");
		region.getVertex().add(s_idle);

		final Pseudostate s_activation =
				XLIA_STATEMACHINE.createJunctionState("activation");
		region.getVertex().add(s_activation);

		final BlockStatement blockEnable =
				XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addInvoke(blockEnable,
				helper(actor).macroComputeProcessingMode);

		XLIA_STATEMACHINE.setEnable(s_activation, blockEnable);

		// Initialisation
		computeInitialisationBehavior(actor, s_init, s_idle);

		// Reception & Activation
		computeReceptionActivationBehavior(actor, region, s_idle, s_activation);

		// Processing & Production --> Activation | Passing
		computeProcessingBehavior(actor, region, s_activation, s_idle);
	}


	////////////////////////////////////////////////////////////////////////////
	// Regular Actor
	public void transformOutputActor(
			final MoccActor actor, final Statemachine xliaActor)
	{
		final Region region = XLIA_STATEMACHINE.createRegion(xliaActor);

		final Pseudostate s_init =
				XLIA_STATEMACHINE.createInitialState("s_init");
		region.getVertex().add(s_init);

		final State s_idle = XLIA_STATEMACHINE.createState("idle");
		region.getVertex().add(s_idle);

		final Pseudostate s_activation =
				XLIA_STATEMACHINE.createJunctionState("activation");
		region.getVertex().add(s_activation);

		// Initialisation
		computeInitialisationBehavior(actor, s_init, s_idle);

		//No Reception

		// Activation
		computeActivationBehavior(actor, s_idle, s_activation);

		// Production
		computeProductionBehavior(actor, s_activation, s_idle);
	}

	public void transformInputActor(
			final MoccActor actor, final Statemachine xliaActor)
	{
		final Region region = XLIA_STATEMACHINE.createRegion(xliaActor);

		final Pseudostate s_init =
				XLIA_STATEMACHINE.createInitialState("s_init");
		region.getVertex().add(s_init);

		final State s_idle = XLIA_STATEMACHINE.createState("idle");
		region.getVertex().add(s_idle);

		final Pseudostate s_activation =
				XLIA_STATEMACHINE.createJunctionState("activation");
		region.getVertex().add(s_activation);

		// Initialisation
		computeInitialisationBehavior(actor, s_init, s_idle);

		// Reception & Activation
		computeReceptionActivationBehavior(actor, region, s_idle, s_activation);

		// Zero sProduction
		computeZeroProductionBehavior(actor, s_activation, s_idle);
	}

	public void transformActor(
			final MoccActor actor, final Statemachine xliaActor)
	{
		final Region region = XLIA_STATEMACHINE.createRegion(xliaActor);

		final Pseudostate s_init = XLIA_STATEMACHINE.createInitialState("s_init");
		region.getVertex().add(s_init);

		final State s_idle = XLIA_STATEMACHINE.createState("idle");
		region.getVertex().add(s_idle);

		final Pseudostate s_activation =
				XLIA_STATEMACHINE.createJunctionState("activation");
		region.getVertex().add(s_activation);

		if( ALWAYS_USING_MODE && actor.FEATURE.hasInput ) {
			final BlockStatement blockEnable =
					XLIA_STATEMENT.createBlockStatement();

			XLIA_STATEMENT.addInvoke(blockEnable,
					helper(actor).macroComputeProcessingMode);

			XLIA_STATEMACHINE.setEnable(s_activation, blockEnable);
		}

		// Initialisation
		computeInitialisationBehavior(actor, s_init, s_idle);

		// Reception & Activation
		computeReceptionActivationBehavior(actor, region, s_idle, s_activation);

		// Production
		computeProductionBehavior(actor, s_activation, s_idle);
	}


	/**
	 * Initialisation Behavior
	 * @param actor
	 * @param s_init
	 * @param s_idle
	 */
	protected void computeInitialisationBehavior(
			final MoccActor actor, final Pseudostate s_init, final State s_idle)
	{
		final Transition transition =
				XLIA_STATEMACHINE.createTransition("t_init", s_init, s_idle);

		final MoccActorHelper actorHELPER = helper(actor);

		if( actorHELPER.macroInitialization != null ) {
			final BlockStatement block = XLIA_STATEMENT.createBlockStatement();
			transition.setBehavior(block);

			XLIA_STATEMENT.addInvoke(block, actorHELPER.macroInitialization);
		}
	}


	/**
	 * Reception Activation Behavior
	 * @param actor
	 * @param region
	 * @param s_idle
	 * @param s_activation
	 */
	protected void computeReceptionActivationBehavior(
			final MoccActor actor, final Region region,
			final State s_idle, final Pseudostate s_activation)
	{
		// receiving Pseudostate
		final Pseudostate s_receiving =
				XLIA_STATEMACHINE.createJunctionState("receiving");
		region.getVertex().add(s_receiving);

		// Activation
		computeActivationBehavior(actor, s_idle, s_activation);

		computeActivationBehavior(actor, s_receiving, s_activation);

		// Reception
		computeReceptionTransition(actor,
				-1 /*else*/, s_idle, s_receiving);

		computeReceptionTransition(actor,
				1 /*priority*/, s_receiving, s_receiving);

//		int priority = 0;
//
//		for( final MoccPort moccPort : actor.getInputPort() ) {
//			priority = priority + 1;
//
//			computeReceptionTransition(actor,
//					moccPort, priority, s_idle, s_receiving);
//
//			computeReceptionTransition(actor,
//					moccPort, priority, s_receiving, s_receiving);
//		}

		XLIA_STATEMACHINE.createTransitionElse("t_idle", s_receiving, s_idle);
	}

	protected void computeReceptionTransition(final MoccActor actor,
			final int priority, final Vertex source, final Vertex target)
	{
		final Transition transition = XLIA_STATEMACHINE.createTransition(
				"t_reception", priority, source, target);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addInvoke(block, helper(actor).macroReception);

		transition.setBehavior(block);
	}


//	protected void computeReceptionTransition(
//			final MoccActor actor, final MoccPort moccPort,
//			final int priority, final Vertex source, final Vertex target)
//	{
//		final Transition transition = XLIA_STATEMACHINE.createTransition(
//				"t_receive_" + moccPort.getName(), priority, source, target);
//
//		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();
//
//		final Variable vaReceivedToken = moccPort.isOutputRational() ?
//				helper(actor).varRatToken : helper(actor).varIntToken;
//
//		if( moccPort.isInputMode() ) {
//			XLIA_STATEMENT.addInvoke(block,
//					actor.getSelector().HELPER.macroReceiveTokenMode,
//					helper(moccPort).xliaPort, vaReceivedToken,
//					helper(moccPort).varReceivedModeTokenCount,
//					helper(moccPort).varReceivedMode);
//		}
//		else {
//			XLIA_STATEMENT.addInvoke(block,
//					this.macroReceiveToken, helper(moccPort).xliaPort,
//					vaReceivedToken, helper(moccPort).varReceivedModeTokenCount);
//		}
//
//		transition.setBehavior(block);
//	}


	protected void computeProcessingBehavior(
			final MoccActor actor, final Region region,
			final Pseudostate s_activation, final State s_idle)
	{
		// Processing --> Activation
		final Pseudostate s_processing =
				XLIA_STATEMACHINE.createJunctionState("processing");
		region.getVertex().add(s_processing);

		final Transition t_activate = XLIA_STATEMACHINE.createTransition(
				"t_process", s_activation, s_processing);

		final BlockStatement blockProcess =
				XLIA_STATEMENT.createBlockStatement();
		t_activate.setBehavior(blockProcess);

		XLIA_STATEMENT.addInvoke(blockProcess,
				helper(actor).macroActivationProcessTest);

		// Processing --> Passing
		final Pseudostate s_passing =
				XLIA_STATEMACHINE.createJunctionState("passing");
		region.getVertex().add(s_passing);

		final Transition t_pass = XLIA_STATEMACHINE.createTransitionElse(
				"t_pass", s_activation, s_passing);

		final BlockStatement blockPass = XLIA_STATEMENT.createBlockStatement();
		t_pass.setBehavior(blockPass);

//		XLIA_STATEMENT.addInvoke(blockPass,
//				helper(actor).macroActivationPassTest);

		// Production
		computeProductionBehavior(actor, s_processing, s_idle, "t_running");

		// Passing
		computeProductionBehavior(actor, s_passing, s_idle, "t_passing");

	}



	/**
	 * Activation Behavior
	 * @param actor
	 * @param s_idle
	 * @param s_activation
	 */
	protected void computeActivationBehavior(final MoccActor actor,
			final Vertex s_source, final Pseudostate s_activation)
	{
		final Transition transition = XLIA_STATEMACHINE.createTransition(
				"t_activate", s_source, s_activation);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();
		transition.setBehavior(block);

		XLIA_STATEMENT.addInvoke(block, helper(actor).macroActivationTest);
	}


	/**
	 * Initialization Behavior
	 * @param actor
	 * @param block
	 */
	protected void computeInitializationBehavior(final MoccActor actor)
	{
		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		for( final MoccPort moccPort : actor.getInputPort() ) {

			final Expression value =
					(helper(moccPort).constTOKEN_INITIAL_RATE == null)
						? XLIA_EXPRESSION.zero()
						: XLIA_EXPRESSION.createExpression(
								helper(moccPort).constTOKEN_INITIAL_RATE);

			XLIA_STATEMENT.addAssignment(block,
					helper(moccPort).varReceivedModeTokenCount, value);
		}

		final MoccActorHelper actorHELPER = helper(actor);

		actorHELPER.macroInitialization =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.statemachine, "initialization", block);
	}

	/**
	 * Reception Behavior
	 * @param actor
	 * @param block
	 */
	protected void computeReceptionBehavior(final MoccActor actor)
	{
		final MoccActorHelper actorHELPER = helper(actor);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		int statementCount = 0;
		for( final MoccPort moccPort : actor.getInputPort() ) {
			final Variable vaReceivedToken = moccPort.isOutputRational() ?
					actorHELPER.varRatToken : actorHELPER.varIntToken;

			if( ALWAYS_USING_MODE ) {
				XLIA_STATEMENT.addInvoke(block, this.macroReceiveTokenMode,
						helper(moccPort).xliaPort, vaReceivedToken,
						helper(moccPort).varReceivedModeTokenCount,
						helper(moccPort).varReceivedMode);
			}
			else {
				XLIA_STATEMENT.addInvoke(block, this.macroReceiveToken,
						helper(moccPort).xliaPort, vaReceivedToken,
						helper(moccPort).varReceivedModeTokenCount);
			}

			// Increment statementCount
			++statementCount;
		}

		if( statementCount > 1 ) {
//			block.setOp(XLIA_STATEMENT.OP_INTERLEAVING);
			block.setOp(XLIA_STATEMENT.OP_SEQUENCE_WEAK);
		}

		actorHELPER.macroReception =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.statemachine, "reception", block);
	}


	/**
	 * Activation Test
	 * @param actor
	 * @param block
	 */
	protected void computeActivationTestBehavior(
			final MoccActor actor, final MoccSystemFeature moccSystemFeature)
	{
		final MoccActorHelper actorHELPER = helper(actor);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		// TOKEN RATE CONDITION
		Expression activationRateCondition = null;
		for( final MoccPort moccPort : actor.getInputPort() ) {
			activationRateCondition = XLIA_EXPRESSION.createFlatAND(
					activationRateCondition,
					XLIA_EXPRESSION.createRelational(
							XLIA_EXPRESSION.OP_GTE,
							helper(moccPort).varReceivedModeTokenCount,
							helper(moccPort).constTOKEN_RATE));
		}

		// GLOBAL ACTIVATION FLAG
		Expression activationCondition =
				XLIA_EXPRESSION.createExpression(this.varCanBeActivate);

//		if( moccSystem.FEATURE.hasUntimed ) {
//			activationCondition =
//					XLIA_EXPRESSION.createExpression(this.varCanBeActivate);
//		}

		// REPETITION COUNT / PERIOD CONDITION
		if( actor.FEATURE.isTimed ) {
			activationCondition = XLIA_EXPRESSION.createFlatAND(
					activationCondition,
					XLIA_EXPRESSION.createArrayElement(
							actorHELPER.constACTIVATION_TICK, this.varTick));

			if( activationRateCondition != null ) {
				final IfStatement ifStatement =
						XLIA_STATEMENT.addIf(block, activationCondition );
				final BlockStatement blockThen =
						XLIA_STATEMENT.createBlockStatement(ifStatement);

				XLIA_STATEMENT.addAssignment(blockThen,
						this.varCanBeActivate, activationRateCondition);

				XLIA_STATEMENT.addGuard(blockThen,
						XLIA_EXPRESSION.createExpression(this.varCanBeActivate));

				// Else => guard( false )
				final BlockStatement elseBlock =
						XLIA_STATEMENT.createElseBlockStatement(ifStatement);

				XLIA_STATEMENT.addGuard(elseBlock, XLIA_EXPRESSION.falseValue());
			}
			else {
				XLIA_STATEMENT.addGuard(block, activationCondition);
			}
		}

		else {
			XLIA_STATEMENT.addGuard(block,
					XLIA_EXPRESSION.createFlatAND(
							activationCondition,
							XLIA_EXPRESSION.createRelational(
									XLIA_EXPRESSION.OP_LT,
									actorHELPER.varActivationCount,
									actorHELPER.constREPETITION),
							activationRateCondition));
		}

		actorHELPER.macroActivationTest =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.statemachine, "activationTest", block);

		// Case where actor has some input port
		if( actor.hasInputPort() ) {
			if( actor.FEATURE.isModeProcessor ) {
				computeActivationProcessingTestBehavior(actor);
			}
			else if( ALWAYS_USING_MODE && actor.FEATURE.hasOutput ) {
				computeActivationMode(actor);
			}
		}
	}


//	private void computeActivationPassingMode(final MoccActor actor) {
//		// Processing Mode Computer
//		final BlockStatement blockEnable = XLIA_STATEMENT.createBlockStatement();
//
//		final List< Expression > undefinedMode = new ArrayList<Expression>();
//
//		for( final MoccPort inPort : actor.getInputPort() ) {
//			undefinedMode.add(
//					XLIA_EXPRESSION.createRelational(
//							XLIA_EXPRESSION.OP_EQ,
//							helper(inPort).varReceivedMode,
//							this.MODE_UNDEFINED));
//		}
//
//		if( ! undefinedMode.isEmpty() ) { // Singleton input mode case
//			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockEnable);
//
//			// Undefined Mode Passing
//			ifStatement.setCondition(
//					XLIA_EXPRESSION.createOR(undefinedMode));
//			final BlockStatement thenBlock =
//					XLIA_STATEMENT.createBlockStatement(ifStatement);
//
//			XLIA_STATEMENT.addAssignment(thenBlock,
//					helper(actor).varProcessingMode, this.MODE_UNDEFINED);
//
//			final BlockStatement elseBlock =
//					XLIA_STATEMENT.createElseBlockStatement(ifStatement);
//
//			XLIA_STATEMENT.addAssignment(elseBlock,
//					helper(actor).varProcessingMode, this.MODE_NOMINAL);
//		}
//
//		helper(actor).macroComputeProcessingMode =
//				XLIA_INFRA.createMacroRoutine(
//						helper(actor).statemachine,
//						"computeProcessingMode", blockEnable);
//	}

	private void computeActivationMode(final MoccActor actor) {
		final int count = actor.getInputPort().size();

		if( count > 0 ) {
			if( ! actor.FEATURE.isModeProcessor ) {
				computeActivationWithoutProcessingMode(actor);
			}
			else if( count == 1 ) {
			computeActivationProcessingSingleMode(actor);
		}
		else if( count > 1 ) {
			computeActivationProcessingMultipleMode(actor);
		}
	}
	}


	private void computeActivationWithoutProcessingMode(final MoccActor actor) {
		// Processing Mode Computer
		final BlockStatement blockEnable = XLIA_STATEMENT.createBlockStatement();

		final Variable receivedMode =
				helper(actor.getInputPort().get(0)).varReceivedMode;

		// Undefined Mode Passing
		final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockEnable,
				XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
						receivedMode, this.MODE_UNDEFINED) );

		final BlockStatement thenBlock =
				XLIA_STATEMENT.createBlockStatement(ifStatement);

		final MoccActorHelper actorHELPER = helper(actor);

		XLIA_STATEMENT.addAssignment(thenBlock,
				actorHELPER.varProcessingMode, this.MODE_UNDEFINED);

		// Else Nominal Mode Passing
		final BlockStatement elseBlock =
				XLIA_STATEMENT.createElseBlockStatement(ifStatement);

		XLIA_STATEMENT.addAssignment(elseBlock,
//				actorHELPER.varProcessingMode, actorHELPER.constDEFAULT_MODE);
				actorHELPER.varProcessingMode, this.MODE_NOMINAL);

		actorHELPER.macroComputeProcessingMode =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.statemachine,
						"computeProcessingMode", blockEnable);
	}


	private void computeActivationProcessingSingleMode(final MoccActor actor) {
		// Processing Mode Computer
		final BlockStatement blockEnable = XLIA_STATEMENT.createBlockStatement();

		final Variable receivedMode =
				helper(actor.getInputPort().get(0)).varReceivedMode;

		// Undefined Mode Passing
		final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockEnable,
				XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
						receivedMode, this.MODE_UNDEFINED) );

		final BlockStatement thenBlock =
				XLIA_STATEMENT.createBlockStatement(ifStatement);

		final MoccActorHelper actorHELPER = helper(actor);

		XLIA_STATEMENT.addAssignment(thenBlock,
				actorHELPER.varProcessingMode, this.MODE_UNDEFINED);

		// Else Identical i.e. Singleton
		final BlockStatement elseBlock =
				XLIA_STATEMENT.createElseBlockStatement(ifStatement);

		XLIA_STATEMENT.addAssignment(elseBlock,
				actorHELPER.varProcessingMode, receivedMode);

		actorHELPER.macroComputeProcessingMode =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.statemachine,
						"computeProcessingMode", blockEnable);
	}


	private void computeActivationProcessingMultipleMode(final MoccActor actor) {
		final MoccActorHelper actorHELPER = helper(actor);

		// Processing Mode Computer
		final BlockStatement blockEnable = XLIA_STATEMENT.createBlockStatement();

		final List< Expression > undefinedMode = new ArrayList<Expression>();

		final BlockStatement blockCollectMode =
				XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addInvokeClear(
				blockCollectMode, actorHELPER.varReceivedModeSet);

		for( final MoccPort inPort : actor.getInputPort() ) {
			final MoccPortHelper portHELPER = helper(inPort);

			undefinedMode.add(
					XLIA_EXPRESSION.createRelational(
							XLIA_EXPRESSION.OP_EQ,
							portHELPER.varReceivedMode,
							this.MODE_UNDEFINED));

			final IfStatement ifStatement =
					XLIA_STATEMENT.addIf(blockCollectMode,
							XLIA_EXPRESSION.createRelational(
									XLIA_EXPRESSION.OP_NOT_EQ,
									portHELPER.varReceivedMode,
									this.MODE_NOMINAL));

			final BlockStatement thenBlock =
					XLIA_STATEMENT.createBlockStatement(ifStatement);

			XLIA_STATEMENT.addAssignment(thenBlock, XLIA_EXPRESSION.OP_PUSH,
					actorHELPER.varReceivedModeSet, portHELPER.varReceivedMode);
		}

//		if( actor.isNominalSingletonProcessingSet() ) {
//			XLIA_STATEMENT.addAssignment(blockEnable,
//					actorHELPER.varProcessingMode, this.MODE_NOMINAL);
//		}
//		else {
			// Undefined Mode Passing
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockEnable,
					XLIA_EXPRESSION.createOR(undefinedMode));

			final BlockStatement thenBlock =
					XLIA_STATEMENT.createBlockStatement(ifStatement);

			XLIA_STATEMENT.addAssignment(thenBlock,
					actorHELPER.varProcessingMode, this.MODE_UNDEFINED);

			// Else Mode computing
			ifStatement.setElseBlock(blockCollectMode);

			// if receivedModeSet is a singleton
			final IfStatement ifSingleton = XLIA_STATEMENT.addIf(blockCollectMode,
					XLIA_EXPRESSION.singleton(actorHELPER.varReceivedModeSet));

			final BlockStatement thenBlockSingleton =
					XLIA_STATEMENT.createBlockStatement(ifSingleton);

			XLIA_STATEMENT.addAssignment(thenBlockSingleton, XLIA_EXPRESSION.OP_POP,
					actorHELPER.varReceivedModeSet, actorHELPER.varProcessingMode);

			// if receivedModeSet is multiple
			final ConditionalBlockStatement elseIfStatementMultiple =
					XLIA_STATEMENT.addElseIf(ifSingleton);
			elseIfStatementMultiple.setCondition(
					XLIA_EXPRESSION.populated(actorHELPER.varReceivedModeSet));

			final BlockStatement elseIfBlockMultiple =
					XLIA_STATEMENT.createBlockStatement(elseIfStatementMultiple);

			XLIA_STATEMENT.addAssignment(elseIfBlockMultiple,
					actorHELPER.varProcessingMode, this.MODE_UNDEFINED);

//			// Different Mode passing
//			final ConditionalBlockStatement diffElseIfStatement =
//					XLIA_STATEMENT.addElseIf(ifSingleton);
//			diffElseIfStatement.setCondition(
//					XLIA_EXPRESSION.createOR(differentModes));
//
//			final BlockStatement diffElseIfBlock =
//					XLIA_STATEMENT.createBlockStatement(diffElseIfStatement);
//
//			XLIA_STATEMENT.addAssignment(diffElseIfBlock,
//					actorHELPER.varProcessingMode, this.MODE_UNDEFINED);
//
			// Else Mode passing
//			final BlockStatement elseBlock =
//					XLIA_STATEMENT.createElseBlockStatement(ifSingleton);
//
//			XLIA_STATEMENT.addAssignment(elseBlock,
//					actorHELPER.varProcessingMode, actorHELPER.varProcessingMode);

//		}

		actorHELPER.macroComputeProcessingMode = XLIA_INFRA.createMacroRoutine(
				actorHELPER.statemachine, "computeProcessingMode", blockEnable);
	}


	private void computeActivationProcessingTestBehavior(final MoccActor actor) {
		// Processing Mode Computer
		computeActivationMode(actor);

		// Activation PROCESSING
		final BlockStatement blockProcess = XLIA_STATEMENT.createBlockStatement();

		final MoccActorHelper actorHELPER = helper(actor);

		final List< Expression > processConditions = new ArrayList<Expression>();
		for( final EnumerationLiteral literal : actorHELPER.modeProcessingSet )
		{
			processConditions.add(
					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
							actorHELPER.varProcessingMode, literal));
		}
		XLIA_STATEMENT.addGuard(blockProcess,
				XLIA_EXPRESSION.createOR(processConditions));

		actorHELPER.macroActivationProcessTest =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.statemachine,
						"activationProcessTest", blockProcess);


		// Activation PASSING
		final BlockStatement blockPass = XLIA_STATEMENT.createBlockStatement();

		final List< Expression > passConditions = new ArrayList<Expression>();
		for( final EnumerationLiteral literal : actorHELPER.modeProcessingSet )
		{
			passConditions.add(
					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_NOT_EQ,
							actorHELPER.varProcessingMode, literal));
		}
		XLIA_STATEMENT.addGuard(blockPass,
				XLIA_EXPRESSION.createAND(passConditions));

		actorHELPER.macroActivationPassTest = XLIA_INFRA.createMacroRoutine(
				actorHELPER.statemachine, "activationPassTest", blockPass);
	}


	/**
	 * Consumption Behavior
	 * @param actor
	 * @param block
	 */
	protected void computeConsumptionBehavior(final MoccActor actor)
	{
		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		if( ! this.CONFORMANCE_PURPOSE ) {
			XLIA_STATEMENT.addInvoke(block, macroJsonTraceBegin,
					XLIA_EXPRESSION.createExpression("CONSUMPTION"),
					XLIA_EXPRESSION.createExpression(actor.getName()),
					XLIA_EXPRESSION.createExpression(actor.getNature()));
		}

		boolean isFirst = true;

		for( final MoccPort moccPort : actor.getInputPort() ) {
			XLIA_STATEMENT.addDecrementation(block,
					helper(moccPort).varReceivedModeTokenCount,
					XLIA_EXPRESSION.createExpression(
							helper(moccPort).constTOKEN_RATE));

			if( ALWAYS_USING_MODE )
			{
				assert (helper(moccPort).varReceivedMode != null) :
					"Unexpected a null varReceivedMode for port " +
						moccPort.getName();

				invokeJsonTraceBodyConsumptionMode(isFirst, block, moccPort);
			}
			else {
				invokeJsonTraceBodyConsumption(isFirst, block, moccPort);
			}

			isFirst = false;
		}

		if( ! this.CONFORMANCE_PURPOSE ) {
			XLIA_STATEMENT.addInvoke(block, macroJsonTraceEnd);
		}

		final MoccActorHelper actorHELPER = helper(actor);

		// Increment varActivationCount during consumption for non-timed actor
		if( ! actor.FEATURE.isTimed ) {
			XLIA_STATEMENT.addAssignment(block,
					actorHELPER.varActivationCount,
					XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_PLUS,
							actorHELPER.varActivationCount,
							XLIA_EXPRESSION.createInteger(1)));
		}

		actorHELPER.macroConsumption =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.statemachine, "consumption", block);
	}

	/**
	 * Consumption Behavior for trace conformance purpose
	 * @param actor
	 * @param block
	 */
	protected void computeConsumptionTraceBehavior(final MoccActor actor)
	{
		final MoccActorHelper actorHELPER = helper(actor);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		for( final MoccPort moccPort : actor.getInputPort() ) {
//			final Variable vaReceivedToken = moccPort.isInputRational() ?
//					actorHELPER.varRatToken : actorHELPER.varIntToken;

			if( ALWAYS_USING_MODE )
			{
				assert (helper(moccPort).varReceivedMode != null) :
					"Unexpected a null varReceivedMode for port " +
						moccPort.getName();

				XLIA_STATEMENT.addOutputCom(block,
						helper(moccPort).xliaChannelPort,
						helper(moccPort).constTOKEN_RATE,
						helper(moccPort).varReceivedMode);
			}
			else {
				XLIA_STATEMENT.addOutputCom(block,
						helper(moccPort).xliaChannelPort,
						helper(moccPort).constTOKEN_RATE);
			}

//				XLIA_STATEMENT.addInputCom(block,
//						helper(moccPort).xliaChannelPort,
//						vaReceivedToken, helper(moccPort).varReceivedMode);
//			}
//			else {
//				XLIA_STATEMENT.addInputCom(block,
//						helper(moccPort).xliaChannelPort, vaReceivedToken);
//			}

//			XLIA_STATEMENT.addGuard(block,
//					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
//							vaReceivedToken, helper(moccPort).constTOKEN_RATE));
		}

		actorHELPER.macroConsumptionTrace =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.statemachine, "consumptionTrace", block);
	}

	/**
	 * Production Behavior
	 * @param actor
	 * @param block
	 */
	protected void computeProductionBehavior(final MoccActor actor)
	{
		final MoccActorHelper actorHELPER = helper(actor);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		// Increment varActivationCount during consumption for non-timed actor
		// without input port
		if( (! actor.FEATURE.isTimed)
			&& (actorHELPER.macroConsumption == null) )
		{
			XLIA_STATEMENT.addAssignment(block,
					actorHELPER.varActivationCount,
					XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_PLUS,
							actorHELPER.varActivationCount,
							XLIA_EXPRESSION.createInteger(1)));
		}


		if( ! this.CONFORMANCE_PURPOSE ) {
			XLIA_STATEMENT.addInvoke(block, macroJsonTraceBegin,
					XLIA_EXPRESSION.createExpression("PRODUCTION"),
					XLIA_EXPRESSION.createExpression(actor.getName()),
					XLIA_EXPRESSION.createExpression(actor.getNature()));
		}

		boolean isFirst = true;

		if( actor.FEATURE.isModeSelector ) {
			final BlockStatement prodBlock =
					XLIA_STATEMENT.createBlockStatement(
							block, XLIA_STATEMENT.OP_INTERLEAVING);

			for( final EnumerationLiteral modeLiteral : actorHELPER.modeSelectionSet )
			{
				XLIA_STATEMENT.addAssignment(prodBlock,
						actorHELPER.varProcessingMode, modeLiteral);
			}

			for( final MoccPort moccPort : actor.getOutputPort() ) {
				XLIA_STATEMENT.addOutputCom(block,
						helper(moccPort).xliaPort,
						helper(moccPort).constTOKEN_RATE,
						actorHELPER.varProcessingMode);

				invokeJsonTraceBodyProductionMode(
						isFirst, block, actor, moccPort);

				isFirst = false;
			}
		}
		else {
			for( final MoccPort moccPort : actor.getOutputPort() ) {
				if( ALWAYS_USING_MODE )
				{
					XLIA_STATEMENT.addOutputCom(block,
							helper(moccPort).xliaPort,
							helper(moccPort).constTOKEN_RATE,
							actorHELPER.varProcessingMode);

					invokeJsonTraceBodyProductionMode(
							isFirst, block, actor, moccPort);
				}
				else {
					XLIA_STATEMENT.addOutputCom(block,
							helper(moccPort).xliaPort,
							helper(moccPort).constTOKEN_RATE);

					invokeJsonTraceBodyProduction(isFirst, block, moccPort);
				}

				isFirst = false;
			}
		}

		if( ! this.CONFORMANCE_PURPOSE ) {
			XLIA_STATEMENT.addInvoke(block, macroJsonTraceEnd);
		}

		actorHELPER.macroProduction = XLIA_INFRA.createMacroRoutine(
				actorHELPER.statemachine, "production", block);
	}


	/**
	 * Production Behavior
	 * @param actor
	 * @param s_activation
	 * @param s_idle
	 */
	protected void computeProductionBehavior(
			final MoccActor actor, final Pseudostate s_activation,
			final State s_idle, final String transitionName)
	{
		final Transition transition = XLIA_STATEMACHINE.createTransition(
				transitionName, s_activation, s_idle);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();
		transition.setBehavior(block);

		final MoccActorHelper actorHELPER = helper(actor);

		if( actor.hasInputPort() ) {
			XLIA_STATEMENT.addInvoke(block, actorHELPER.macroConsumption);
			XLIA_STATEMENT.addInvoke(block, actorHELPER.macroConsumptionTrace);
		}
		if( actor.hasOutputPort() ) {
			XLIA_STATEMENT.addInvoke(block, actorHELPER.macroProduction);
		}
	}

	protected void computeProductionBehavior(final MoccActor actor,
			final Pseudostate s_activation, final State s_idle)
	{
		computeProductionBehavior(actor, s_activation, s_idle, "t_running");
	}


	/**
	 * Zero Production Behavior
	 * @param actor
	 * @param s_activation
	 * @param s_idle
	 */
	protected void computeZeroProductionBehavior(final MoccActor actor,
			final Pseudostate s_activation, final State s_idle)
	{
		final Transition transition = XLIA_STATEMACHINE.createTransition(
				"t_running", s_activation, s_idle);

		if( actor.hasInputPort() ) {
			final BlockStatement block = XLIA_STATEMENT.createBlockStatement();
			transition.setBehavior(block);

			final MoccActorHelper actorHELPER = helper(actor);

			XLIA_STATEMENT.addInvoke(block, actorHELPER.macroConsumption);
			XLIA_STATEMENT.addInvoke(block, actorHELPER.macroConsumptionTrace);
		}
	}


}
