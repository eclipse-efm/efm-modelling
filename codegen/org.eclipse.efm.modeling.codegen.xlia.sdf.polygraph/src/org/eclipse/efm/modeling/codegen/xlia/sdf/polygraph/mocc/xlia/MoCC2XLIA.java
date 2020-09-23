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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.efm.ecore.formalml.specification.XliaModel;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.Connector;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction;
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter;
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet;
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

	protected boolean IS_ROOT_SYSTEM;

	protected boolean CONFORMANCE_PURPOSE;

	protected boolean TRACE_GENERATION_PURPOSE;

	// For Moka Trace compatibility
	public boolean ALWAYS_USING_MODE;

	public static boolean PRODUCE_SYMBOLIC_MODE = true;

	public Map< MoccActor, MoccActorHelper> actorHelper;

	public Map< MoccPort , MoccPortHelper > portHelper;

	public Machine xliaMainMachine;

	public Variable constPeriod; // defined if period =/= hyperperiod
	public Variable constHyperPeriod;

	public Variable constTickFrequency;
	public Variable constTickStep;

	public Variable varTick;
	public Variable varTimestamp;

	public Variable varCanBeActivate;

	public EnumerationType MODE_SET_TYPE;

	public EnumerationLiteral MODE_NOMINAL;
	public EnumerationLiteral MODE_UNDEFINED;

	public Routine macroReceiveToken;
	public Routine macroReceiveTokenMode;
	public Routine macroReceiveTokenDecidingMode;

//	public Routine macroJsonTraceHeader;
	public Routine macroJsonTraceBegin;

	public Routine macroJsonTraceTokenBodyHead;
	public Routine macroJsonTraceTokenBodyTail;

	public Routine macroJsonTraceTokenModeBodyHead;
	public Routine macroJsonTraceTokenModeBodyTail;

	public Routine macroJsonTraceEnd;
//	public Routine macroJsonTraceFooter;


	protected MoCC2XLIASchedule schedulerGenerator;


	public MoCC2XLIA(final boolean conformance, final boolean traceGeneration)
	{
		this.IS_ROOT_SYSTEM = true;

		this.CONFORMANCE_PURPOSE = conformance;

		this.TRACE_GENERATION_PURPOSE = traceGeneration;

		MoCC2XLIA.PRODUCE_SYMBOLIC_MODE = (! this.CONFORMANCE_PURPOSE);

		this.ALWAYS_USING_MODE = true;

		this.actorHelper = new HashMap<MoccActor, MoccActorHelper>();

		this.portHelper  = new HashMap<MoccPort , MoccPortHelper >();

		this.xliaMainMachine = null;

		this.constPeriod = null;
		this.constHyperPeriod = null;

		this.constTickFrequency = null;
		this.constTickStep = null;

		this.varTick         = null;
		this.varTimestamp    = null;

		this.varCanBeActivate = null;

		this.MODE_SET_TYPE  = null;
		this.MODE_NOMINAL   = null;
		this.MODE_UNDEFINED = null;

		this.macroReceiveToken     = null;
		this.macroReceiveTokenMode = null;
		this.macroReceiveTokenDecidingMode = null;

//		this.macroJsonTraceHeader  = null;
		this.macroJsonTraceBegin   = null;

		this.macroJsonTraceTokenBodyHead     = null;
		this.macroJsonTraceTokenBodyTail     = null;
		this.macroJsonTraceTokenModeBodyHead = null;
		this.macroJsonTraceTokenModeBodyTail = null;

		this.macroJsonTraceEnd     = null;
//		this.macroJsonTraceFooter = null;

		schedulerGenerator = null;
	}

	public MoCC2XLIA(final MoCC2XLIA mocc2xlia)
	{
		this.IS_ROOT_SYSTEM = false;

		this.CONFORMANCE_PURPOSE = mocc2xlia.CONFORMANCE_PURPOSE;

		this.TRACE_GENERATION_PURPOSE = mocc2xlia.TRACE_GENERATION_PURPOSE;

//		PRODUCE_SYMBOLIC_MODE = mocc2xlia.PRODUCE_SYMBOLIC_MODE; // static property

		this.ALWAYS_USING_MODE = true;

		this.actorHelper = new HashMap<MoccActor, MoccActorHelper>();

		this.portHelper  = new HashMap<MoccPort , MoccPortHelper >();

		this.xliaMainMachine = null;

		this.constPeriod = null;
		this.constHyperPeriod = null;

		this.constTickFrequency = null;
		this.constTickStep = null;

		this.varTick       = null;
		this.varTimestamp  = null;


		this.varCanBeActivate = null;

		this.MODE_SET_TYPE  = mocc2xlia.MODE_SET_TYPE;
		this.MODE_NOMINAL   = mocc2xlia.MODE_NOMINAL;
		this.MODE_UNDEFINED = mocc2xlia.MODE_UNDEFINED;

		this.macroReceiveToken     = mocc2xlia.macroReceiveToken;
		this.macroReceiveTokenMode = mocc2xlia.macroReceiveTokenMode;
		this.macroReceiveTokenDecidingMode = mocc2xlia.macroReceiveTokenDecidingMode;

//		this.macroJsonTraceHeader  = mocc2xlia.macroJsonTraceHeader;
		this.macroJsonTraceBegin   = mocc2xlia.macroJsonTraceBegin;

		this.macroJsonTraceTokenBodyHead     = mocc2xlia.macroJsonTraceTokenBodyHead;
		this.macroJsonTraceTokenBodyTail     = mocc2xlia.macroJsonTraceTokenBodyTail;
		this.macroJsonTraceTokenModeBodyHead = mocc2xlia.macroJsonTraceTokenModeBodyHead;
		this.macroJsonTraceTokenModeBodyTail = mocc2xlia.macroJsonTraceTokenModeBodyTail;

		this.macroJsonTraceEnd    = mocc2xlia.macroJsonTraceEnd;
//		this.macroJsonTraceFooter = mocc2xlia.macroJsonTraceFooter;

		schedulerGenerator = null;
	}


	public MoccActorHelper helper(final MoccActor actor) {
		return actorHelper.get(actor);
	}

	protected MoccPortHelper helper(final MoccPort port) {
		return portHelper.get(port);
	}


	public XliaModel transformSystem(final MoccSystem moccSystem)
	{
		// Basic static analysis feature
		final MoccSystemFeature moccSystemFeature =
				moccSystem.computeFeatureStrict();

		assert (moccSystemFeature.consistency) :
				"Unexpected a non-consistency MoCC System : " +
				moccSystem.getName();

		if( moccSystemFeature.consistency ) {
			// For Moka Trace compatibility
			ALWAYS_USING_MODE = true;//moccSystem.FEATURE.hasModeSelector;

			// Transformation to XLIA
			final XliaModel xliaModel = XLIA_INFRA.createModel();

			final XliaSystem xliaSystem =
					XLIA_INFRA.createSystem(moccSystem.getName());

			xliaModel.setSystem( xliaSystem );

			this.xliaMainMachine = xliaSystem;

			transform(moccSystem, moccSystemFeature);

			return xliaModel;
		}
		else {
			return null;
		}
	}

	public void transformSubSystem(
			final MoccActor moccActor, final Machine xliaActor)
	{
		final MoccSystem subSystem = moccActor.getSubSystem();
		if( subSystem != null ) {
			// Basic static analysis feature
			final MoccSystemFeature moccSystemFeature =
					subSystem.computeFeatureStrict();

			assert (moccSystemFeature.consistency) :
					"Unexpected a non-consistency MoCC System : " +
					subSystem.getName();

			if( moccSystemFeature.consistency ) {
				// For Moka Trace compatibility
				ALWAYS_USING_MODE = true;//moccSystem.FEATURE.hasModeSelector;

				// Transformation to XLIA
				this.xliaMainMachine = xliaActor;

				transform(subSystem, moccSystemFeature);
			}
		}
	}

	protected void transform(final MoccSystem moccSystem,
			final MoccSystemFeature moccSystemFeature)
	{
		// For Moka Trace compatibility
		ALWAYS_USING_MODE = true;//moccSystem.FEATURE.hasModeSelector;

		if( (ALWAYS_USING_MODE || moccSystemFeature.hasModeProcessor)
			&& (this.MODE_SET_TYPE == null) )
		{
			// MODE SET TYPE
			this.MODE_SET_TYPE = XLIA_DATATYPE.addEnum(this.xliaMainMachine,
					"MODE_SET", moccSystem.getModeLiterals());

			// VALUE: NOMINAL - UNDEFINED - MODE
			this.MODE_NOMINAL = XLIA_DATATYPE.getEnumLiteral(
					this.MODE_SET_TYPE, moccSystem.NOMINAL.getLiteral());

			this.MODE_UNDEFINED =  XLIA_DATATYPE.getEnumLiteral(
					this.MODE_SET_TYPE, moccSystem.UNDEFINED.getLiteral());

			// MACRO ROUTINES
			this.macroReceiveTokenMode =
					createReceiveTokenModeRoutine(this.xliaMainMachine);

			this.macroReceiveTokenDecidingMode =
					createReceiveTokenDecidingModeRoutine(this.xliaMainMachine);
		}

		// MACRO ROUTINES
		if( this.IS_ROOT_SYSTEM ) {
			this.macroReceiveToken = createReceiveTokenRoutine(this.xliaMainMachine);
		}


		// TIME CONFIGURATION
		this.constTickFrequency = XLIA_INFRA.createConstant(
				XLIA_DATATYPE.createInteger(), "TICK_FREQUENCY",
				XLIA_EXPRESSION.createInteger(
						moccSystemFeature.tick_frequency));
		this.xliaMainMachine.getVariable().add(this.constTickFrequency);

		this.constTickStep = XLIA_INFRA.createConstant(
				XLIA_DATATYPE.createInteger(), "TICK_STEP",
				XLIA_EXPRESSION.createInteger(
						moccSystemFeature.tick_step));
		this.xliaMainMachine.getVariable().add(this.constTickStep);

		if( moccSystemFeature.period != moccSystemFeature.hyperperiod ) {
			this.constPeriod = XLIA_INFRA.createConstant(
					XLIA_DATATYPE.createInteger(), "PERIOD",
					XLIA_EXPRESSION.createInteger(
							moccSystemFeature.period));
			this.xliaMainMachine.getVariable().add(this.constPeriod);
		}

		this.constHyperPeriod = XLIA_INFRA.createConstant(
				XLIA_DATATYPE.createInteger(), "HYPERPERIOD",
				XLIA_EXPRESSION.createInteger(
						moccSystemFeature.hyperperiod));
		this.xliaMainMachine.getVariable().add(this.constHyperPeriod);

		this.varTick = XLIA_INFRA.createLocaleVariable(
				XLIA_DATATYPE.createInteger(),
				"tick", XLIA_EXPRESSION.zero());
		this.xliaMainMachine.getVariable().add(this.varTick);

		this.varTimestamp = XLIA_INFRA.createLocaleVariable(
				XLIA_DATATYPE.createInteger(),
				"timestamp", XLIA_EXPRESSION.zero());
		this.xliaMainMachine.getVariable().add(this.varTimestamp);


		// GENERAL ENABLED ACTIVATION
		this.varCanBeActivate = XLIA_INFRA.createLocaleVariable(
				XLIA_DATATYPE.createBoolean(),
				"canBeActivate", XLIA_EXPRESSION.trueValue());
		this.xliaMainMachine.getVariable().add(this.varCanBeActivate);

		// MACRO TRACE ROUTINES
		if( this.TRACE_GENERATION_PURPOSE && this.IS_ROOT_SYSTEM) {
			createJsonTraceRoutine(this.xliaMainMachine, moccSystemFeature);
		}

		// ACTOR TRANSFORMATIONS
		for (final MoccActor actor : moccSystem.getActor()) {
			this.xliaMainMachine.getMachine().add(
					transformActor(actor, moccSystemFeature) );
		}


		// MAIN BEHAVIOR
		final Behavior mainBehavior = XLIA_INFRA.createBehavior();
		this.xliaMainMachine.setMain(mainBehavior);

		// MODEL OF INTERACTION
		transformChannel(moccSystem, mainBehavior);

		// MODEL OF EXECUTION

		schedulerGenerator =
				new MoCC2XLIASchedule(this, moccSystem, this.xliaMainMachine);

		schedulerGenerator.compute(moccSystemFeature);
	}


	private void createJsonTraceRoutine(final Machine machine,
			final MoccSystemFeature moccSystemFeature) {
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
//								this.varTick, this.constTickStep),
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
		if( ALWAYS_USING_MODE ) {
			this.macroJsonTraceTokenModeBodyHead =
					createJsonTraceBodyRoutine(
							machine, "jsonTraceTokenModeBodyHead", "", true);

			this.macroJsonTraceTokenModeBodyTail =
					createJsonTraceBodyRoutine(
							machine, "jsonTraceTokenModeBodyTail", ",", true);
		}
		else {
			this.macroJsonTraceTokenBodyHead = createJsonTraceBodyRoutine(
					machine, "jsonTraceTokenBodyHead", "", false);

			this.macroJsonTraceTokenBodyTail = createJsonTraceBodyRoutine(
					machine, "jsonTraceTokenBodyTail", ",", false);

			if( moccSystemFeature.hasModeProcessor ) {
				this.macroJsonTraceTokenModeBodyHead = createJsonTraceBodyRoutine(
						machine, "jsonTraceTokenModeBodyHead", "", true);

				this.macroJsonTraceTokenModeBodyTail = createJsonTraceBodyRoutine(
						machine, "jsonTraceTokenModeBodyTail", ",", true);
			}
		}
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
			final String routineName, final String traceSeparator,
			final boolean usingMode)
	{
		// TRACE BODY [ WITH MODE ]
		final ParameterSet parameterSet =
				XLIA_INFRA.createParameterSet();

		final Parameter channel = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createString(), "aChannel");
		parameterSet.getParameter().add(channel);

		final Parameter tokenCount = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInteger(), "tokenCount");
		parameterSet.getParameter().add(tokenCount);

		final BlockStatement block =
				XLIA_STATEMENT.createBlockStatement();

		final IfStatement ifStatement = XLIA_STATEMENT.addIf(block,
				XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_GT,
						tokenCount, XLIA_EXPRESSION.zero()));

		final BlockStatement thenBlock =
				XLIA_STATEMENT.createBlockStatement(ifStatement);

		final MetaStatement traceStatement = XLIA_STATEMENT.addTrace(thenBlock,
				XLIA_EXPRESSION.createExpression(traceSeparator + "\n\t\t\t\t{"),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"channel\": \""),
						XLIA_EXPRESSION.createExpression(channel),
						XLIA_EXPRESSION.createExpression("\","),
				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"count\": \""),
						XLIA_EXPRESSION.createExpression(tokenCount),
						XLIA_EXPRESSION.createExpression("\""));

		if( usingMode ) {
			final Parameter tokenMode = XLIA_INFRA.createParameter(
					XLIA_DATATYPE.createString(), "tokenMode");
			parameterSet.getParameter().add(tokenMode);

			traceStatement.getOperand().add(
					XLIA_EXPRESSION.createExpression(",\n\t\t\t\t\t\"mode\": \""));

			traceStatement.getOperand().add(
					XLIA_EXPRESSION.createCast(
							XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
							tokenMode) );

			traceStatement.getOperand().add(
						XLIA_EXPRESSION.createExpression("\"") );
		}
//		else {
//			traceStatement.getOperand().add(
//					XLIA_EXPRESSION.createExpression(",\n\t\t\t\t\t\"mode\": \"" +
//					this.moccSystem.NOMINAL.getLiteral() + "\"") );
//		}

		traceStatement.getOperand().add(
				XLIA_EXPRESSION.createExpression("\n\t\t\t\t}"));


		final BlockStatement elseBlock =
				XLIA_STATEMENT.createElseBlockStatement(ifStatement);

		XLIA_STATEMENT.addTrace(elseBlock,
				XLIA_EXPRESSION.createExpression(traceSeparator + "\n\t\t\t\t{}") );

		return XLIA_INFRA.createMacroRoutine(
				machine, routineName, parameterSet, block);
	}


	private void invokeJsonTraceBodyConsumptionTokenMode(final boolean isFirst,
			final BlockStatement block, final MoccPort port)
	{
		if( ! this.TRACE_GENERATION_PURPOSE ) {
			return;
		}

		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceTokenModeBodyHead
						: this.macroJsonTraceTokenModeBodyTail),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				helper(port).rateExpression(),
				XLIA_EXPRESSION.createExpression(
						helper(port).varReceivedMode));
	}

	private void invokeJsonTraceBodyConsumptionToken(final boolean isFirst,
			final BlockStatement block, final MoccPort port)
	{
		if( ! this.TRACE_GENERATION_PURPOSE ) {
			return;
		}

		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceTokenBodyHead
						: this.macroJsonTraceTokenBodyTail),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				helper(port).rateExpression());
//				XLIA_EXPRESSION.createExpression(this.MODE_NOMINAL));
	}


	private void invokeJsonTraceBodyProductionTokenMode(
			final boolean isFirst, final BlockStatement block,
			final MoccActor actor, final MoccPort port)
	{
		if( ! this.TRACE_GENERATION_PURPOSE ) {
			return;
		}

		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceTokenModeBodyHead
						: this.macroJsonTraceTokenModeBodyTail),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				helper(port).rateExpression(),
				XLIA_EXPRESSION.createExpression(
						actor.isModeSelector()
								? helper(actor).varProducingMode
								: helper(actor).varProcessingMode));
	}

	private void invokeJsonTraceBodyProductionToken(final boolean isFirst,
			final BlockStatement block, final MoccPort port)
	{
		if( ! this.TRACE_GENERATION_PURPOSE ) {
			return;
		}

		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceTokenBodyHead
						: this.macroJsonTraceTokenBodyTail),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				helper(port).rateExpression());
//				XLIA_EXPRESSION.createExpression(this.MODE_NOMINAL));
	}


	protected Routine createReceiveTokenRoutine(final Machine machine) {
		final ParameterSet parameterSet = XLIA_INFRA.createParameterSet();

		final Parameter receivedPort = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInstancePort(), "receivedPort");
		parameterSet.getParameter().add(receivedPort);

//!@! CSDF : XLIA_DATATYPE.createRational() ==> XLIA_DATATYPE.createInteger()

		final Parameter receivedToken = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInteger(), "receivedToken");
		parameterSet.getParameter().add(receivedToken);

		final Parameter tokenCount = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInteger(), "tokenCount");
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
				XLIA_DATATYPE.createInteger(), "receivedToken");
		parameterSet.getParameter().add(receivedToken);

		final Parameter tokenCount = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInteger(), "tokenCount");
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


	protected Routine createReceiveTokenDecidingModeRoutine(final Machine machine) {
		final ParameterSet parameterSet = XLIA_INFRA.createParameterSet();

		final Parameter channelName = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createString(), "channelName");
		parameterSet.getParameter().add(channelName);

		final Parameter receivedPort = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInstancePort(), "receivedPort");
		parameterSet.getParameter().add(receivedPort);

		final Parameter receivedToken = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInteger(), "receivedToken");
		parameterSet.getParameter().add(receivedToken);

		final Parameter tokenCount = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createInteger(), "tokenCount");
		parameterSet.getParameter().add(tokenCount);

		final Parameter tokenRate = XLIA_INFRA.createParameter(
				XLIA_DATATYPE.createRational(), "tokenRate");
		parameterSet.getParameter().add(tokenRate);

		final Parameter receivedDecidingMode =
				XLIA_INFRA.createParameter(
						XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
						"receivedDecidingMode");
		parameterSet.getParameter().add(receivedDecidingMode);

		final Parameter currentDecidingMode =
				XLIA_INFRA.createParameter(
						XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
						"currentDecidingMode");
		parameterSet.getParameter().add(currentDecidingMode);

		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addGuard(block,
				XLIA_EXPRESSION.createRelational(
						XLIA_EXPRESSION.OP_GT, tokenRate, tokenCount) );

		XLIA_STATEMENT.addInputCom(block,
				receivedPort, receivedToken, receivedDecidingMode);

		// IF UNDIFINED CONDITION
		final IfStatement ifStatement =
				XLIA_STATEMENT.addIf(block,
						XLIA_EXPRESSION.createAND(
								XLIA_EXPRESSION.createRelational(
										XLIA_EXPRESSION.OP_GTE, tokenCount,
										XLIA_EXPRESSION.createInteger(1)),
								XLIA_EXPRESSION.createRelational(
										XLIA_EXPRESSION.OP_NOT_SEQ,
										receivedDecidingMode,
										currentDecidingMode) ) );

		final BlockStatement blockThen =
				XLIA_STATEMENT.createBlockStatement(ifStatement);

		XLIA_STATEMENT.addIncrementation(blockThen, tokenCount,
				XLIA_EXPRESSION.createExpression(receivedToken));

		XLIA_STATEMENT.addAssignment(blockThen,
				currentDecidingMode, this.MODE_UNDEFINED);

		XLIA_STATEMENT.addInvokeExit(blockThen,
				XLIA_EXPRESSION.createPLUS(
						XLIA_EXPRESSION.createExpression("Channel< "),
						XLIA_EXPRESSION.createExpression(channelName),
						XLIA_EXPRESSION.createExpression(" >::MODE<UNDEFINED>")));

		// ELSE => not UNDIFINED
		final BlockStatement elseBlock =
				XLIA_STATEMENT.createElseBlockStatement(ifStatement);

		XLIA_STATEMENT.addIncrementation(elseBlock, tokenCount,
				XLIA_EXPRESSION.createExpression(receivedToken));

		XLIA_STATEMENT.addAssignment(elseBlock,
				currentDecidingMode, receivedDecidingMode);


		return XLIA_INFRA.createMacroRoutine(machine,
				"receiveTokenDecidingMode", parameterSet, block);
	}



	public Machine transformActor(
			final MoccActor actor, final MoccSystemFeature moccSystemFeature)
	{
		if( actor.isComposite() ) {
			final Machine xliaActor =
					XLIA_INFRA.createMachine(actor.getName());

			actorHelper.put(actor, new MoccActorHelper(actor, xliaActor));

			final MoccActorHelper actorHELPER = helper(actor);

			// CONSTANTS & VARIABLES
			actorHELPER.declareConstantsVariables(xliaActor,
					MODE_SET_TYPE, this.MODE_NOMINAL, ALWAYS_USING_MODE);

			for( final MoccPort moccPort : actor.getInputPort() ) {
				transformInputPort(moccPort, xliaActor);
			}

			for( final MoccPort moccPort : actor.getOutputPort() ) {
				transformOutputPort(moccPort, xliaActor);
			}

			// Transform MoCC AST to xLIA Model
			final MoCC2XLIA mocc2xlia = new MoCC2XLIA(this);

			mocc2xlia.transformSubSystem(actor, xliaActor);

			return xliaActor;
		}
		else {
			// Basic static analysis feature
			final Statemachine xliaActor =
					XLIA_STATEMACHINE.createStatemachine(actor.getName());

			actorHelper.put(actor, new MoccActorHelper(actor, xliaActor));

			final MoccActorHelper actorHELPER = helper(actor);

			// CONSTANTS & VARIABLES
			actorHELPER.declareConstantsVariables(xliaActor,
					MODE_SET_TYPE, this.MODE_NOMINAL, ALWAYS_USING_MODE);

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

				if( this.CONFORMANCE_PURPOSE || this.TRACE_GENERATION_PURPOSE ) {
					computeConsumptionTraceBehavior(actor);
				}
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
					transformInputOutoutActor(actor, xliaActor);
				}
				else if( actor.FEATURE.hasInput )
				{
					// Mode Selector with Input
					transformInputOutoutActor(actor, xliaActor);
				}
				else {
					// Mode Selector without input
					transformOutputActor(actor, xliaActor);
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
						// Regular i.e. with Input & Ouput
						transformInputOutoutActor(actor, xliaActor);
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
	 * OUTPUT PORT -> XLIA
	 * @param moccPort
	 * @param xliaActor
	 */
	public void transformOutputPort(
			final MoccPort moccPort, final Machine xliaActor)
	{
		final MoccPortHelper helperPort =
				new MoccPortHelper(helper(moccPort.actor), moccPort);

		helperPort.createOutputPort(xliaActor,
				this.MODE_SET_TYPE, ALWAYS_USING_MODE);

		// Mapping: MoccPort-->PortHelper
		portHelper.put(moccPort, helperPort);
	}

	/**
	 * INPUT PORT -> XLIA
	 * @param moccPort
	 * @param xliaActor
	 */
	public void transformInputPort(
			final MoccPort moccPort, final Machine xliaActor)
	{
		final MoccPortHelper helperPort =
				new MoccPortHelper(helper(moccPort.actor), moccPort);

		helperPort.createInputPort(xliaActor,
				this.MODE_SET_TYPE, this.ALWAYS_USING_MODE,
				this.CONFORMANCE_PURPOSE || this.TRACE_GENERATION_PURPOSE);

		// Mapping: MoccPort-->PortHelper
		portHelper.put(moccPort, helperPort);
	}


	/**
	 * CHANNEL -> XLIA
	 */
	public void transformChannel(
			final MoccSystem moccSystem, final Behavior xliaBehavior)
	{
		final ModelOfInteraction moInteraction =
				XLIA_INFRA.createMOI(xliaBehavior);

		if( CONFORMANCE_PURPOSE ) {
			final Connector connectorEnv =
					XLIA_INFRA.createConnectorEnv("channel_env");

			for( final MoccActor actor : moccSystem.getActor() ) {
				for( final MoccPort moccPort : actor.getInputPort() ) {
//					XLIA_INFRA.addConnectorEndInputPoint(connectorEnv,
					XLIA_INFRA.addConnectorEndOutputPoint(connectorEnv,
							helper(moccPort.actor).machine,
							helper(moccPort).xliaChannelPort );
				}
			}

			if( ! connectorEnv.getConnectorEnd().isEmpty() ) {
				moInteraction.getConnectors().add( connectorEnv );
			}
		}

		for( final MoccChannel channel : moccSystem.getChannel() ) {
			final MoccActor outputActor = channel.getOutputActor();

			final Connector connector =
					XLIA_INFRA.createConnectorFifo(channel.getName(),
							outputActor.FEATURE.repetition);

			XLIA_INFRA.addConnectorEndOutputPoint(connector,
					helper(outputActor).machine,
					helper(channel.getOutputPort()).xliaPort );

			XLIA_INFRA.addConnectorEndInputPoint(connector,
					helper(channel.getInputActor()).machine,
						helper(channel.getInputPort()).xliaPort);

			moInteraction.getConnectors().add( connector );
		}
	}


//	/**
//	 * XLIA SYSTEM SCHEDULER
//	 * @param moccSystemFeature
//	 */
//	public void computeScheduler(final MoccSystemFeature moccSystemFeature)
//	{
//		final ModelOfExecution moExcecution = XLIA_INFRA.createMOE(this.mainBehavior);
//
//		// MOE: RUN
//		final Routine runRoutine =
//				XLIA_INFRA.createRoutine(XLIA_STATEMENT.OP_RUN);
//		moExcecution.setRunRoutine(runRoutine);
//
//		final BlockStatement blockRun =
//				XLIA_STATEMENT.createBlockStatement(runRoutine);
//
//		// Authorized global activation
//		XLIA_STATEMENT.addAssignment(blockRun,
//				this.varCanBeActivate,
//				XLIA_EXPRESSION.trueValue());
//
//		XLIA_STATEMENT.addActivitySchedule(blockRun);
//
//		// Test if a timed actor disable global activation because of
//		// timed constraint failure
//		if( moccSystemFeature.hasTimed ) {
//			XLIA_STATEMENT.addGuard(blockRun,
//					XLIA_EXPRESSION.createExpression(this.varCanBeActivate));
//		}
//
//		// MOE: SCHEDULE
//		final Routine scheduleRoutine =
//				XLIA_INFRA.createRoutine(XLIA_STATEMENT.OP_SCHEDULE);
//		moExcecution.setScheduleRoutine(scheduleRoutine);
//
//		final BlockStatement blockSchedule =
//				XLIA_STATEMENT.createBlockStatement(scheduleRoutine);
//
//		final int activationCount = moccSystemFeature.tick_period - 1;
//
//		if( moccSystemFeature.hasTimed ) {
//			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockSchedule);
//
//			computeSchedulingActor(moccSystemFeature, ifStatement, 0);
//
//			for( int index = 1 ; index < activationCount; index++) {
//				computeSchedulingActor(moccSystemFeature,
//						XLIA_STATEMENT.addElseIf(ifStatement), index);
//			}
//
//			final BlockStatement elseBlock =
//					XLIA_STATEMENT.createElseBlockStatement(ifStatement);
//			computeSchedulingActor(moccSystemFeature, elseBlock, activationCount);
//		}
//		else if( moccSystemFeature.tick_period > 1 ) {
//			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockSchedule);
//
//			computeStagingActor(moccSystemFeature, ifStatement, 0);
//
//			for( int stage = 1 ; stage < activationCount; stage++) {
//				computeStagingActor(moccSystemFeature,
//						XLIA_STATEMENT.addElseIf(ifStatement), stage);
//			}
//
//			final BlockStatement elseBlock =
//					XLIA_STATEMENT.createElseBlockStatement(ifStatement);
//			computeStagingActor(moccSystemFeature, elseBlock, activationCount);
//		}
//		else {
//			computeSchedulingActor(moccSystemFeature, blockSchedule, 0);
//		}
//
//		// MOE: RUN
//		XLIA_STATEMENT.addAssignment(blockRun, this.varTimestamp,
//				XLIA_EXPRESSION.createExpression(
//						XLIA_EXPRESSION.OP_PLUS,
//							this.varTimestamp, this.varTimeDelta));
//
//		XLIA_STATEMENT.addAssignment(blockRun, this.varTick,
//					XLIA_EXPRESSION.createExpression(
//							XLIA_EXPRESSION.OP_PLUS, this.varTick,
//							XLIA_EXPRESSION.createInteger(1)));
//
//
//		// PERIOD & RE-INITIALISATION
//		final IfStatement ifPeriod = XLIA_STATEMENT.addIf(blockRun,
//				XLIA_EXPRESSION.createRelational(
//						XLIA_EXPRESSION.OP_EQ,
//						this.varTick, this.varTickPeriod));
//
//		final BlockStatement blockPeriod =
//				XLIA_STATEMENT.createBlockStatement(ifPeriod);
//
//		// NEW PERIOD: INTIALISATION
//		XLIA_STATEMENT.addAssignment(blockPeriod,
//				this.varTick, XLIA_EXPRESSION.zero());
//
//		BlockStatement blockReinit = blockPeriod;
//
//		IfStatement ifReinit = null;
//		if( ! moccSystemFeature.hasTimed ) {
//			ifReinit = XLIA_STATEMENT.addIf(blockPeriod);
//			blockReinit = XLIA_STATEMENT.createBlockStatement(ifReinit);
//		}
//
//		Expression untimedConditionalReinitialisation = null;
//
//		// NEW PERIOD: CHECKING
//		for( final MoccActor actor : this.moccSystem.getActor() ) {
//			final MoccActorHelper actorHELPER = helper(actor);
//
////			if( ! actor.FEATURE.isTimed )
//			{
//				final RelationalBinaryExpression actorRepetitionCond =
//						XLIA_EXPRESSION.createRelational(
//								XLIA_EXPRESSION.OP_EQ,
//								actorHELPER.machine,
//								actorHELPER.varActivationCount,
//									actorHELPER.constREPETITION);
//
//				if( moccSystemFeature.hasTimed ) {
//					XLIA_STATEMENT.addGuard(blockReinit, actorRepetitionCond);
//				}
//				else if( untimedConditionalReinitialisation == null ) {
//					untimedConditionalReinitialisation = actorRepetitionCond;
//				}
//				else {
//					untimedConditionalReinitialisation =
//							XLIA_EXPRESSION.createFlatAND(
//									untimedConditionalReinitialisation,
//									actorRepetitionCond);
//				}
//			}
//
////!@! CSDF
//			XLIA_STATEMENT.addAssignment(blockReinit,
//					actorHELPER.machine,
//					actorHELPER.varActivationCount,
//					XLIA_EXPRESSION.zero());
//		}
//
//		// UNTIMED SYSTEM RE-INITIALISATION
//		if( untimedConditionalReinitialisation != null ) {
//			ifReinit.setCondition(untimedConditionalReinitialisation);
//		}
//
//		// ENABLED ONLY RECEPTION BEFORE RE-INITIALISATION
//		final BlockStatement blockReception =
//				XLIA_STATEMENT.createBlockStatement(
//						blockReinit, XLIA_STATEMENT.OP_SEQUENCE_WEAK);
//
//		XLIA_STATEMENT.addAssignment(blockReception,
//				this.varCanBeActivate,
//				XLIA_EXPRESSION.falseValue());
//
//
//		for( final MoccActor actor : this.moccSystem.getActor() ) {
//			if( actor.FEATURE.hasInput ) {
//				XLIA_STATEMENT.addActivityRun(blockReception,
//						helper(actor).machine);
//			}
//		}
//	}
//
//
//	protected void computeSchedulingActor(
//			final MoccSystemFeature moccSystemFeature,
//			final ConditionalBlockStatement ifBlock, final int activationIndex) {
//		final BlockStatement thenBlock =
//				XLIA_STATEMENT.createBlockStatement(ifBlock);
//
//		ifBlock.setCondition(XLIA_EXPRESSION.createRelational(
//				XLIA_EXPRESSION.OP_EQ, this.varTick,
//				XLIA_EXPRESSION.createInteger(activationIndex)));
//
//		computeSchedulingActor(moccSystemFeature, thenBlock, activationIndex);
//	}
//
//	protected void computeSchedulingActor(
//			final MoccSystemFeature moccSystemFeature,
//			final BlockStatement thenBlock, final int activationIndex) {
////		int statementCount = 0;
//		for( final MoccActor actor : this.moccSystem.getActor() ) {
//			if( actor.FEATURE.activation[activationIndex] ) {
//				final MoccActorHelper actorHELPER = helper(actor);
//
//				if( actor.FEATURE.isTimed ) {
//					XLIA_STATEMENT.addActivityRun(thenBlock,
//							actorHELPER.machine);
//				}
//				else {
//					XLIA_STATEMENT.addActivityRtc(thenBlock,
//							actorHELPER.machine);
//				}
//
//				// Increment statementCount
////				++statementCount;
//			}
//		}
//
////		if( (statementCount > 1) /*&& (! moccSystemFeature.hasTimed)*/ ) {
////			thenBlock.setOp( XLIA_STATEMENT.OP_SEQUENCE_WEAK );
////		}
//	}
//
//
//	protected void computeStagingActor(
//			final MoccSystemFeature moccSystemFeature,
//			final ConditionalBlockStatement ifBlock, final int stageIndex) {
//		final BlockStatement thenBlock =
//				XLIA_STATEMENT.createBlockStatement(ifBlock);
//
//		ifBlock.setCondition(XLIA_EXPRESSION.createRelational(
//				XLIA_EXPRESSION.OP_EQ, this.varTick,
//				XLIA_EXPRESSION.createInteger(stageIndex)));
//
//		computeStagingActor(moccSystemFeature, thenBlock, stageIndex);
//	}
//
//	protected void computeStagingActor(
//			final MoccSystemFeature moccSystemFeature,
//			final BlockStatement thenBlock, final int stageIndex) {
////		int statementCount = 0;
//		for( final MoccActor actor : this.moccSystem.getActor() ) {
//			if( actor.schedule == stageIndex ) {
//				final MoccActorHelper actorHELPER = helper(actor);
//
//				XLIA_STATEMENT.addActivityRtc(thenBlock, actorHELPER.machine);
//
//				// Increment statementCount
////				++statementCount;
//			}
//		}
//
////		if( (statementCount > 1) /*&& (! moccSystemFeature.hasTimed)*/ ) {
////			thenBlock.setOp( XLIA_STATEMENT.OP_SEQUENCE_WEAK );
////		}
//	}



	////////////////////////////////////////////////////////////////////////////
	// Variable Declaration for Mode Selector / Processor Actor
	public void modeActorDeclaration(final MoccActor actor,
			final Machine xliaActor)
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

		if( actor.FEATURE.requiresModeProcessor ) {
			actorHELPER.varReceivedModeSet = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createCollectionSet(
							XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), -1),
					"receivedModeSet");
			xliaActor.getVariable().add(actorHELPER.varReceivedModeSet);
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// Mode Processor Actor
	public void transformProcessorActor(
			final MoccActor actor, final Statemachine xliaActor)
	{
		final Region region = XLIA_STATEMACHINE.createRegion(xliaActor);

		final Pseudostate s_init =
				XLIA_STATEMACHINE.createInitialState(region, "s_init");

		final State s_idle = XLIA_STATEMACHINE.createState(region, "idle");

		final Pseudostate s_activation =
				XLIA_STATEMACHINE.createJunctionState(region, "activation");


		// Activation --> (Consumption ; Production) : Processing | Passing
		if( actor.FEATURE.hasInputDecidingMode ) {
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

		// Activation --> (Consumption ; Production) : Processing | Passing
//		computeProcessingBehavior(actor, region, s_activation, s_idle);

		// Activation --> (Consumption ; Production) : Computing
		computeProductionBehavior(actor, s_activation, s_idle);
	}


	////////////////////////////////////////////////////////////////////////////
	// Regular Actor
	public void transformOutputActor(
			final MoccActor actor, final Statemachine xliaActor)
	{
		final Region region = XLIA_STATEMACHINE.createRegion(xliaActor);

		final Pseudostate s_init =
				XLIA_STATEMACHINE.createInitialState(region, "s_init");

		final State s_idle = XLIA_STATEMACHINE.createState(region, "idle");

		final Pseudostate s_activation =
				XLIA_STATEMACHINE.createJunctionState(region, "activation");

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
				XLIA_STATEMACHINE.createInitialState(region, "s_init");

		final State s_idle = XLIA_STATEMACHINE.createState(region, "idle");

		final Pseudostate s_activation =
				XLIA_STATEMACHINE.createJunctionState(region, "activation");

		// Initialisation
		computeInitialisationBehavior(actor, s_init, s_idle);

		// Reception & Activation
		computeReceptionActivationBehavior(actor, region, s_idle, s_activation);

		// Zero sProduction
		computeZeroProductionBehavior(actor, s_activation, s_idle);
	}

	public void transformInputOutoutActor(
			final MoccActor actor, final Statemachine xliaActor)
	{
		final Region region = XLIA_STATEMACHINE.createRegion(xliaActor);

		final Pseudostate s_init =
				XLIA_STATEMACHINE.createInitialState(region, "s_init");

		final State s_idle = XLIA_STATEMACHINE.createState(region, "idle");

		final Pseudostate s_activation =
				XLIA_STATEMACHINE.createJunctionState(region, "activation");

		final MoccActorHelper actorHELPER = helper(actor);

		if( actor.FEATURE.requiresModeProcessor ) {
			final BlockStatement blockEnable =
					XLIA_STATEMENT.createBlockStatement();

			XLIA_STATEMENT.addInvoke(blockEnable,
					actorHELPER.macroComputeProcessingMode);

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
				XLIA_STATEMACHINE.createJunctionState(region, "receiving");

		// Activation
		computeActivationBehavior(actor, s_idle, s_activation);

		computeActivationBehavior(actor, s_receiving, s_activation);

		// Reception
		computeReceptionTransition(actor,
				-1 /*else*/, s_idle, s_receiving);

		computeReceptionTransition(actor,
				1 /*priority*/, s_receiving, s_receiving);

		final Transition transition =
				XLIA_STATEMACHINE.createTransitionElse(
						"t_idle", s_receiving, s_idle);
		if( actor.FEATURE.isTimed ) {
			final BlockStatement block = XLIA_STATEMENT.createBlockStatement();
			final MoccActorHelper actorHELPER = helper(actor);

			final IfStatement ifStatement = XLIA_STATEMENT.addIf(block,
					XLIA_EXPRESSION.createAND(
							XLIA_EXPRESSION.createExpression(
									this.varCanBeActivate),
							XLIA_EXPRESSION.createArrayElement(
									actorHELPER.constACTIVATION_TICK,
									this.varTick)));

			final BlockStatement blockThen =
					XLIA_STATEMENT.createBlockStatement(ifStatement);

			XLIA_STATEMENT.addInvokeExit(blockThen,
					"MoCC::FIRING: Not enough token to fire the timed actor "
					+ actor.getName());

			transition.setBehavior(block);
		}
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

			final MoccPortHelper helperPort = helper(moccPort);

			XLIA_STATEMENT.addAssignment(block,
					helperPort.varReceivedTokenCount,
					helperPort.initialRateExpression());

//			if( helperPort.constMODE_INITIAL != null ) {
//				XLIA_STATEMENT.addAssignment(block,
//						helperPort.varReceivedMode, helperPort.constMODE_INITIAL);
//			}
		}

		final MoccActorHelper actorHELPER = helper(actor);

		actorHELPER.macroInitialization =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.machine, "initialization", block);
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
//!@! CSDF : vaReceivedToken === actorHELPER.varIntToken
//			final Variable vaReceivedToken = moccPort.isOutputRational() ?
//					actorHELPER.varRatToken : actorHELPER.varIntToken;

			final MoccPortHelper helperPort = helper(moccPort);

			if( ALWAYS_USING_MODE || moccPort.isInputMode() )
			{
				if( moccPort.isDecidingInputMode() )
				{
					XLIA_STATEMENT.addInvoke(block,
							this.macroReceiveTokenDecidingMode,
							XLIA_EXPRESSION.createExpression(
									moccPort.getChannel().getName()),
							XLIA_EXPRESSION.createExpression(helperPort.xliaPort),
							XLIA_EXPRESSION.createExpression(actorHELPER.varIntToken),
							XLIA_EXPRESSION.createExpression(helperPort.varReceivedTokenCount),
							XLIA_EXPRESSION.createExpression(helperPort.constTOKEN_RATE),
							XLIA_EXPRESSION.createExpression(actorHELPER.varDecidingMode),
							XLIA_EXPRESSION.createExpression(helperPort.varReceivedMode));
				}
				else {
					XLIA_STATEMENT.addInvoke(block,
							this.macroReceiveTokenMode,
							helperPort.xliaPort,
							actorHELPER.varIntToken,
							helperPort.varReceivedTokenCount,
							helperPort.varReceivedMode);
				}
			}
			else {
				XLIA_STATEMENT.addInvoke(block,
						this.macroReceiveToken,
						helperPort.xliaPort, actorHELPER.varIntToken,
						helperPort.varReceivedTokenCount);
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
						actorHELPER.machine, "reception", block);
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
			final MoccPortHelper helperPort = helper(moccPort);

			activationRateCondition = XLIA_EXPRESSION.createFlatAND(
					activationRateCondition,
					XLIA_EXPRESSION.createRelational(
							XLIA_EXPRESSION.OP_GTE,
							helperPort.varReceivedTokenCount,
							helperPort.rateExpression()));
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
						actorHELPER.machine, "activationTest", block);

		// Case where actor has some input port
		computeActivationMode(actor);
	}


	private void computeActivationMode(final MoccActor actor) {
		if( actor.FEATURE.requiresModeProcessor ) {
			if( actor.FEATURE.inputDecidingModeCount == 1 ) {
				computeActivationProcessingSingleMode(actor);
			}
			else if( actor.FEATURE.inputDecidingModeCount > 1 ) {
				computeActivationProcessingMultipleMode(actor);
			}
			else {
				//!! NOTHING TO DO
			}
		}
		else {
			//!! NOTHING TO DO
		}
	}


	private void computeActivationProcessingSingleMode(final MoccActor actor) {
		// Processing Mode Computer
		final BlockStatement blockEnable = XLIA_STATEMENT.createBlockStatement();

		MoccPort decidingPort = null;
		for( final MoccPort inPort : actor.getInputPort() ) {
			if( inPort.isDecidingInputMode() ) {
				decidingPort = inPort;
				break;
			}
		}

		final MoccPortHelper helperPort = helper(decidingPort);

		final Variable receivedMode = helperPort.varReceivedMode;

		final MoccActorHelper actorHELPER = helper(actor);

		XLIA_STATEMENT.addAssignment(blockEnable, //elseBlock,
				actorHELPER.varProcessingMode, receivedMode);

		actorHELPER.macroComputeProcessingMode =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.machine,
						"computeProcessingMode", blockEnable);
	}


	private void computeActivationProcessingMultipleMode(final MoccActor actor) {
		final MoccActorHelper actorHELPER = helper(actor);

		// Processing Mode Computer
		final BlockStatement blockEnable = XLIA_STATEMENT.createBlockStatement();

		final BlockStatement blockCollectMode = blockEnable;

		XLIA_STATEMENT.addInvokeClear(
				blockCollectMode, actorHELPER.varReceivedModeSet);

		Variable oneDecidingMode = null;
		for( final MoccPort inPort : actor.getInputPort() ) {
			if( inPort.isDecidingInputMode() ) {
				final MoccPortHelper helperPort = helper(inPort);

				XLIA_STATEMENT.addAssignment(
						helperPort.testIfHasCycloRate(blockCollectMode),
						XLIA_EXPRESSION.OP_PUSH,
						actorHELPER.varReceivedModeSet,
						helperPort.varReceivedMode);

				if( ! inPort.hasCycloStaticRate() ) {
					oneDecidingMode = helperPort.varReceivedMode;
				}
			}
		}

			// if receivedModeSet is a singleton
			final IfStatement ifSingleton = XLIA_STATEMENT.addIf(blockCollectMode,
					XLIA_EXPRESSION.singleton(actorHELPER.varReceivedModeSet));

			final BlockStatement thenBlockSingleton =
					XLIA_STATEMENT.createBlockStatement(ifSingleton);

		if( oneDecidingMode != null ) {
			XLIA_STATEMENT.addAssignment(thenBlockSingleton,
					actorHELPER.varProcessingMode, oneDecidingMode);
		}
		else {
			XLIA_STATEMENT.addAssignment(thenBlockSingleton, XLIA_EXPRESSION.OP_POP,
					actorHELPER.varReceivedModeSet, actorHELPER.varProcessingMode);
		}

		// if receivedModeSet is multiple
		final ConditionalBlockStatement elseIfStatementMultiple =
				XLIA_STATEMENT.addElseIf(ifSingleton);
		elseIfStatementMultiple.setCondition(
				XLIA_EXPRESSION.populated(actorHELPER.varReceivedModeSet));

		final BlockStatement elseIfBlockMultiple =
				XLIA_STATEMENT.createBlockStatement(elseIfStatementMultiple);

		XLIA_STATEMENT.addAssignment(elseIfBlockMultiple,
				actorHELPER.varProcessingMode, this.MODE_UNDEFINED);

		XLIA_STATEMENT.addInvokeExit(elseIfBlockMultiple,
				"Actor< " + actor.getName() + " >::MODE<UNDEFINED>");

		actorHELPER.macroComputeProcessingMode = XLIA_INFRA.createMacroRoutine(
				actorHELPER.machine, "computeProcessingMode", blockEnable);
	}


	/**
	 * Consumption Behavior
	 * @param actor
	 * @param block
	 */
	protected void computeConsumptionBehavior(final MoccActor actor)
	{
		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		if( this.TRACE_GENERATION_PURPOSE ) {
			XLIA_STATEMENT.addInvoke(block, macroJsonTraceBegin,
					XLIA_EXPRESSION.createExpression("CONSUMPTION"),
					XLIA_EXPRESSION.createExpression(actor.getName()),
					XLIA_EXPRESSION.createExpression(actor.getNature()));
		}

		boolean isFirst = true;

		for( final MoccPort moccPort : actor.getInputPort() ) {
			final MoccPortHelper helperPort = helper(moccPort);

			XLIA_STATEMENT.addDecrementation(block,
					helperPort.varReceivedTokenCount,
					helperPort.rateExpression());

			if( (ALWAYS_USING_MODE || moccPort.isDeciding())
				&& (helperPort.varReceivedMode != null) )
			{
				assert (helperPort.varReceivedMode != null) :
					"Unexpected a null varReceivedMode for port " +
						moccPort.getName();

				invokeJsonTraceBodyConsumptionTokenMode(isFirst, block, moccPort);
			}
			else {
				invokeJsonTraceBodyConsumptionToken(isFirst, block, moccPort);
			}

			isFirst = false;
		}

		if( this.TRACE_GENERATION_PURPOSE ) {
			XLIA_STATEMENT.addInvoke(block, macroJsonTraceEnd);
		}

		final MoccActorHelper actorHELPER = helper(actor);

		// Increment varActivationCount during consumption for non-timed actor
		// without input port
		if( //(! actor.FEATURE.isTimed) &&
				(! actor.hasOutputPort()) )
		{
				XLIA_STATEMENT.addAssignment(block,
						actorHELPER.varActivationCount,
						XLIA_EXPRESSION.createExpression(
								XLIA_EXPRESSION.OP_PLUS,
								actorHELPER.varActivationCount,
								XLIA_EXPRESSION.createInteger(1)));
			}

		actorHELPER.macroConsumption =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.machine, "consumption", block);
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

			final MoccPortHelper helperPort = helper(moccPort);

			if( (ALWAYS_USING_MODE || moccPort.isDeciding())
				&& (helperPort.varReceivedMode != null) )
			{
				assert (helperPort.varReceivedMode != null) :
					"Unexpected a null varReceivedMode for port " +
						moccPort.getName();

				XLIA_STATEMENT.addOutputCom(
						helperPort.testIfHasCycloRate(block),
						helperPort.xliaChannelPort,
						helperPort.rateExpression(),
						helperPort.varReceivedMode);
			}
			else {
				XLIA_STATEMENT.addOutputCom(
						helperPort.testIfHasCycloRate(block),
						helperPort.xliaChannelPort,
						helperPort.rateExpression());
			}

//				XLIA_STATEMENT.addInputCom(block,
//						helperPort.xliaChannelPort,
//						vaReceivedToken, helperPort.varReceivedMode);
//			}
//			else {
//				XLIA_STATEMENT.addInputCom(block,
//						helperPort.xliaChannelPort, vaReceivedToken);
//			}

//			XLIA_STATEMENT.addGuard(block,
//					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
//							vaReceivedToken, helperPort.rateExpression()));
		}

		actorHELPER.macroConsumptionTrace =
				XLIA_INFRA.createMacroRoutine(
						actorHELPER.machine, "consumptionTrace", block);
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

		if( this.TRACE_GENERATION_PURPOSE ) {
			XLIA_STATEMENT.addInvoke(block, macroJsonTraceBegin,
					XLIA_EXPRESSION.createExpression("PRODUCTION"),
					XLIA_EXPRESSION.createExpression(actor.getName()),
					XLIA_EXPRESSION.createExpression(actor.getNature()));
		}

		boolean isFirst = true;

		if( actor.FEATURE.isModeSelector ) {
			if( PRODUCE_SYMBOLIC_MODE ) {
				// Symbolic MODE selection
				XLIA_STATEMENT.addNewfresh(block, actorHELPER.varProducingMode);
			}
			else {
				// Exhaustive MODE selection
				final BlockStatement prodBlock =
						XLIA_STATEMENT.createBlockStatement(
								block, XLIA_STATEMENT.OP_INTERLEAVING);

				for( final EnumerationLiteral modeLiteral : actorHELPER.modeSelectionSet )
				{
					XLIA_STATEMENT.addAssignment(prodBlock,
							actorHELPER.varProducingMode, modeLiteral);
				}
				// end of Exhaustive MODE selection
			}

			for( final MoccPort moccPort : actor.getOutputPort() ) {
				final MoccPortHelper helperPort = helper(moccPort);

				XLIA_STATEMENT.addOutputCom(
						helperPort.testIfHasCycloRate(block),
						helperPort.xliaPort,
						helperPort.rateExpression(),
						actorHELPER.varProducingMode);

				invokeJsonTraceBodyProductionTokenMode(
						isFirst, block, actor, moccPort);

				isFirst = false;
			}
		}
		else {
			for( final MoccPort moccPort : actor.getOutputPort() ) {
				final MoccPortHelper helperPort = helper(moccPort);

				if( (ALWAYS_USING_MODE || moccPort.isDeciding())
					&& (actorHELPER.varProcessingMode != null) )
				{
					XLIA_STATEMENT.addOutputCom(
							helperPort.testIfHasCycloRate(block),
							helperPort.xliaPort,
							helperPort.rateExpression(),
							actorHELPER.varProcessingMode);

					invokeJsonTraceBodyProductionTokenMode(
							isFirst, block, actor, moccPort);
				}
				else {
					XLIA_STATEMENT.addOutputCom(
							helperPort.testIfHasCycloRate(block),
							helperPort.xliaPort,
							helperPort.rateExpression());

					invokeJsonTraceBodyProductionToken(isFirst, block, moccPort);
				}

				isFirst = false;
			}
		}

		if( this.TRACE_GENERATION_PURPOSE ) {
			XLIA_STATEMENT.addInvoke(block, macroJsonTraceEnd);
		}

		// Increment varActivationCount during consumption for non-timed actor
//!@! CSDF
//		if( ! actor.FEATURE.isTimed ) {
			XLIA_STATEMENT.addAssignment(block,
					actorHELPER.varActivationCount,
					XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_PLUS,
							actorHELPER.varActivationCount,
							XLIA_EXPRESSION.createInteger(1)));
//		}

			actorHELPER.macroProduction = XLIA_INFRA.createMacroRoutine(
				actorHELPER.machine, "production", block);
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

			if( this.CONFORMANCE_PURPOSE || this.TRACE_GENERATION_PURPOSE ) {
				XLIA_STATEMENT.addInvoke(block, actorHELPER.macroConsumptionTrace);
			}
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

			if( this.CONFORMANCE_PURPOSE || this.TRACE_GENERATION_PURPOSE ) {
				XLIA_STATEMENT.addInvoke(block, actorHELPER.macroConsumptionTrace);
			}
		}
	}


}
