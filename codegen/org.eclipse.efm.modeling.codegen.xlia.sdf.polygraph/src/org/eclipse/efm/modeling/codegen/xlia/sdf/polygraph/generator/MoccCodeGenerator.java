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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.ecore.formalml.common.VisibilityKind;
import org.eclipse.efm.ecore.formalml.datatype.CollectionType;
import org.eclipse.efm.ecore.formalml.datatype.DataType;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType;
import org.eclipse.efm.ecore.formalml.expression.Expression;
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
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.MoccChannel;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.MoccPort;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.MoccSystem;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.feature.MoccSystemFeature;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.helper.MoccActorHelper;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.helper.MoccPortHelper;

public class MoccCodeGenerator {

	protected boolean CONFORMANCE_PURPOSE;

	protected MoccSystem moccSystem;

	protected XliaModel xliaModel;

	protected XliaSystem xliaSystem;
	protected Behavior mainBehavior;

	protected Variable varTick;
	protected Variable varTickInterval;
	protected Variable varTickPeriod;

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


	public MoccCodeGenerator(final MoccSystem moccSystem, final boolean conformance) {
		this.CONFORMANCE_PURPOSE = conformance;

		this.moccSystem = moccSystem;

		this.xliaModel = null;

		this.xliaSystem = null;

		this.mainBehavior = null;

		this.varTick         = null;
		this.varTickInterval = null;
		this.varTickPeriod   = null;

		this.varTimestamp    = null;

		this.varCanBeActivate  = null;

		this.MODE_SET_TYPE  = null;
		this.MODE_NOMINAL   = null;
		this.MODE_UNDEFINED = null;

		this.macroReceiveToken     = null;
		this.macroReceiveTokenMode = null;

		this.macroJsonTraceHeader  = null;
		this.macroJsonTraceBegin   = null;
		this.macroJsonTraceBody1    = null;
		this.macroJsonTraceBody2    = null;
		this.macroJsonTraceEnd     = null;
		this.macroJsonTraceFooter  = null;
	}

	public MoccCodeGenerator(final MoccSystem moccSystem) {
		this(moccSystem, true);
	}


	public XliaModel transformModel()
	{
		// Basic static analysis feature
		final MoccSystemFeature moccSystemFeature = this.moccSystem.computeFeature();

		if( ! moccSystemFeature.consistency ) {
			return null;
		}

		// Transformation to XLIA
		this.xliaModel = XLIA_INFRA.createModel();
		this.xliaSystem = XLIA_INFRA.createSystem(this.moccSystem.getName());
		this.xliaModel.setSystem( this.xliaSystem );

		// MODE SET TYPE
		this.MODE_SET_TYPE = XLIA_DATATYPE.addEnum(xliaSystem,
				"MODE_SET", new String[] {
						this.moccSystem.UNDEFINED.getLiteral(),
						this.moccSystem.NOMINAL.getLiteral() });

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
		this.varTickInterval = XLIA_INFRA.createConstant(
				XLIA_DATATYPE.createInterger(), "TICK_INTERVAL",
				XLIA_EXPRESSION.createInteger(
						moccSystemFeature.tick_interval));
		this.xliaSystem.getVariable().add(this.varTickInterval);

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
		if( moccSystemFeature.hasUntimed ) {
			this.varCanBeActivate = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createBoolean(),
					"canBeActivate", XLIA_EXPRESSION.trueValue());
			this.xliaSystem.getVariable().add(this.varCanBeActivate);
		}

		// MACRO TRACE ROUTINES
		createJsonTraceRoutine(this.xliaSystem);

		// ACTOR TRANSFORMATIONS
		for (final MoccActor actor : this.moccSystem.getActor()) {
			this.xliaSystem.getMachine().add( transformActor(actor) );
		}


		// MAIN BEHAVIOR
		this.mainBehavior = XLIA_INFRA.createBehavior();
		this.xliaSystem.setMain(this.mainBehavior);

		// MODEL OF INTERACTION
		transformChannel();

		// MODEL OF EXECUTION
		computeScheduler(moccSystemFeature);

		return this.xliaModel;
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
			final String routineName, final String traceSeparator) {
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

		if( moccSystem.FEATURE.hasModeSelector ) {
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
			final BlockStatement block, final MoccPort port) {
		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceBody1
						: this.macroJsonTraceBody2),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				XLIA_EXPRESSION.createExpression(
						port.HELPER.constTOKEN_RATE),
				XLIA_EXPRESSION.createExpression(
						port.HELPER.varReceivedMode));
	}

	private void invokeJsonTraceBodyConsumption(final boolean isFirst,
			final BlockStatement block, final MoccPort port) {
		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceBody1
						: this.macroJsonTraceBody2),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				XLIA_EXPRESSION.createExpression(
						port.HELPER.constTOKEN_RATE));
//				XLIA_EXPRESSION.createExpression(this.MODE_NOMINAL));
	}


	private void invokeJsonTraceBodyProductionMode(
			final boolean isFirst, final BlockStatement block,
			final MoccActor actor, final MoccPort port) {
		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceBody1
						: this.macroJsonTraceBody2),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				XLIA_EXPRESSION.createExpression(
						port.HELPER.constTOKEN_RATE),
				XLIA_EXPRESSION.createExpression(
						actor.HELPER.varProcessingMode));
	}

	private void invokeJsonTraceBodyProduction(final boolean isFirst,
			final BlockStatement block, final MoccPort port) {
		XLIA_STATEMENT.addInvoke(block,
				(isFirst ? this.macroJsonTraceBody1
						: this.macroJsonTraceBody2),
				XLIA_EXPRESSION.createExpression(
						port.getChannel().getName()),
				XLIA_EXPRESSION.createExpression(
						port.HELPER.constTOKEN_RATE));
//				XLIA_EXPRESSION.createExpression(this.MODE_NOMINAL));
	}

//	private void createJsonTraceRoutine(final Machine machine) {
//		// TRACE BEGIN
//		final ParameterSet parameterSetBegin =
//				XLIA_INFRA.createParameterSet();
//
//		final Parameter kind = XLIA_INFRA.createParameter(
//				XLIA_DATATYPE.createString(), "kind");
//		parameterSetBegin.getParameter().add(kind);
//
//		final Parameter actor = XLIA_INFRA.createParameter(
//				XLIA_DATATYPE.createString(), "actor");
//		parameterSetBegin.getParameter().add(actor);
//
//		final Parameter nature = XLIA_INFRA.createParameter(
//				XLIA_DATATYPE.createString(), "nature");
//		parameterSetBegin.getParameter().add(nature);
//
//
//		final BlockStatement blockBegin =
//				XLIA_STATEMENT.createBlockStatement();
//
//		XLIA_STATEMENT.addTrace(blockBegin,
//				XLIA_EXPRESSION.createExpression("\n\t\t{"),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\"kind\": \""),
//						XLIA_EXPRESSION.createExpression(kind),
//						XLIA_EXPRESSION.createExpression("\","),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\"tick\": "),
//						XLIA_EXPRESSION.createExpression(this.varTick),
//						XLIA_EXPRESSION.createExpression(","),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\"timestamp\": "),
//						XLIA_EXPRESSION.createExpression(this.varTimestamp),
//						XLIA_EXPRESSION.createExpression(","),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\"actor\": \""),
//						XLIA_EXPRESSION.createExpression(actor),
//						XLIA_EXPRESSION.createExpression("\","),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\"nature\": "),
//						XLIA_EXPRESSION.createExpression(nature),
//						XLIA_EXPRESSION.createExpression(","),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\"data\": ["));
//
//		this.macroJsonTraceBegin = XLIA_INFRA.createMacroRoutine(machine,
//				"jsonTraceBegin", parameterSetBegin, blockBegin);
//
//		// TRACE BODY [ WITH MODE ]
//		final ParameterSet parameterSet =
//				XLIA_INFRA.createParameterSet();
//
//		final Parameter separator = XLIA_INFRA.createParameter(
//				XLIA_DATATYPE.createString(), "separator");
//		parameterSet.getParameter().add(separator);
//
//		final Parameter channel = XLIA_INFRA.createParameter(
//				XLIA_DATATYPE.createString(), "aChannel");
//		parameterSet.getParameter().add(channel);
//
//		final Parameter tokenCount = XLIA_INFRA.createParameter(
//				XLIA_DATATYPE.createRational(), "tokenCount");
//		parameterSet.getParameter().add(tokenCount);
//
//		final BlockStatement block =
//				XLIA_STATEMENT.createBlockStatement();
//
//		final MetaStatement traceStatement = XLIA_STATEMENT.addTrace(block,
//				XLIA_EXPRESSION.createExpression(separator),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\t{"),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"channel\": \""),
//						XLIA_EXPRESSION.createExpression(channel),
//						XLIA_EXPRESSION.createExpression("\","),
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"count\": \""),
//						XLIA_EXPRESSION.createExpression(tokenCount),
//						XLIA_EXPRESSION.createExpression("\","));
//
////				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"mode\": \""),
////						XLIA_EXPRESSION.createCast(
////								XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
////								tokenMode),
////						XLIA_EXPRESSION.createExpression("\""),
////				XLIA_EXPRESSION.createExpression("\n\t\t\t\t}"));
//
//		if( moccSystem.FEATURE.hasModeSelector ) {
//			final Parameter tokenMode = XLIA_INFRA.createParameter(
//					XLIA_DATATYPE.createString(), "tokenMode");
//			parameterSet.getParameter().add(tokenMode);
//
//			traceStatement.getOperand().add(
//					XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"mode\": \""));
//			traceStatement.getOperand().add(
//						XLIA_EXPRESSION.createCast(
//								XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
//								tokenMode) );
//			traceStatement.getOperand().add(
//						XLIA_EXPRESSION.createExpression("\"") );
//		}
//		else {
//			traceStatement.getOperand().add(
//					XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"mode\": \"" +
//					this.moccSystem.NOMINAL.getLiteral() + "\"") );
//		}
//
//		traceStatement.getOperand().add(
//				XLIA_EXPRESSION.createExpression("\n\t\t\t\t}"));
//
//		this.macroJsonTraceBody = XLIA_INFRA.createMacroRoutine(
//				machine, "jsonTraceBody", parameterSet, block);
//
////		// TRACE BODY WITH DEFAULT NOMINAL MODE
////		final ParameterSet parameterSetNominal =
////				XLIA_INFRA.createParameterSet();
////
////		final Parameter separatorNominal = XLIA_INFRA.createParameter(
////				XLIA_DATATYPE.createString(), "separator");
////		parameterSetNominal.getParameter().add(separatorNominal);
////
////		final Parameter channelNominal = XLIA_INFRA.createParameter(
////				XLIA_DATATYPE.createString(), "aChannel");
////		parameterSetNominal.getParameter().add(channelNominal);
////
////		final Parameter tokenCountNominal = XLIA_INFRA.createParameter(
////				XLIA_DATATYPE.createRational(), "tokenCount");
////		parameterSetNominal.getParameter().add(tokenCountNominal);
////
////		final BlockStatement blockNominal =
////				XLIA_STATEMENT.createBlockStatement();
////
////		XLIA_STATEMENT.addTrace(blockNominal,
////				XLIA_EXPRESSION.createExpression(separatorNominal),
////				XLIA_EXPRESSION.createExpression("\n\t\t\t\t{"),
////				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"channel\": \""),
////						XLIA_EXPRESSION.createExpression(channelNominal),
////						XLIA_EXPRESSION.createExpression("\","),
////				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"count\": \""),
////						XLIA_EXPRESSION.createExpression(tokenCountNominal),
////						XLIA_EXPRESSION.createExpression("\","),
////				XLIA_EXPRESSION.createExpression("\n\t\t\t\t\t\"mode\": \"" +
////						this.moccSystem.NOMINAL.getLiteral() + "\""),
////				XLIA_EXPRESSION.createExpression("\n\t\t\t\t}"));
////
////		this.macroJsonTraceBodyNominal = XLIA_INFRA.createMacroRoutine(machine,
////				"jsonTraceBodyNominal", parameterSetNominal, blockNominal);
//
//		// TRACE END
//		final BlockStatement blockEnd =
//				XLIA_STATEMENT.createBlockStatement();
//
//		XLIA_STATEMENT.addTrace(blockEnd,
//				XLIA_EXPRESSION.createExpression("\n\t\t\t]"),
//				XLIA_EXPRESSION.createExpression("\n\t\t},"));
//		this.macroJsonTraceEnd = XLIA_INFRA.createMacroRoutine(
//				machine, "jsonTraceEnd", null, blockEnd);
//	}


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


	public Statemachine transformActor(final MoccActor actor)
	{
		// Basic static analysis feature
		final Statemachine xliaActor =
				XLIA_STATEMACHINE.createStatemachine(actor.getName());

		actor.HELPER = new MoccActorHelper(actor, xliaActor);

		// MODE TYPE
		if( moccSystem.FEATURE.hasModeSelector ) {
			modeActorDeclaration(actor, actor.HELPER, xliaActor);
		}

		if( actor.FEATURE.isModeSelector ) {
			XLIA_DATATYPE.addEnumLiterals(
					this.MODE_SET_TYPE, actor.getSelectionSetLiterals());

			actor.HELPER.modeSelectionSet = modeLiterals(
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
			actor.HELPER.constFREQUENCY = XLIA_INFRA.createConstant(
					XLIA_DATATYPE.createInterger(), "FREQUENCY",
					XLIA_EXPRESSION.createInteger(actor.getFrequency()));
			xliaActor.getVariable().add(actor.HELPER.constFREQUENCY);
		}
		else {
			actor.HELPER.constREPETITION = XLIA_INFRA.createPublicConstant(
					XLIA_DATATYPE.createInterger(), "REPETITION",
					XLIA_EXPRESSION.createInteger(actor.FEATURE.repetition));
			xliaActor.getVariable().add(actor.HELPER.constREPETITION);

			// For scheduler
			actor.HELPER.varActivationCount =
					XLIA_INFRA.createPublicLocaleVariable(
							XLIA_DATATYPE.createInterger(),
							"activationCount", XLIA_EXPRESSION.zero());
			xliaActor.getVariable().add(actor.HELPER.varActivationCount);
		}

		// VARIABLE: INTEGER TOKEN
		if( actor.FEATURE.hasIntegerRate ) {
			actor.HELPER.varIntToken = XLIA_INFRA.createLocaleVariable(
					XLIA_DATATYPE.createInterger(),
					"intToken", XLIA_EXPRESSION.zero());
			xliaActor.getVariable().add(actor.HELPER.varIntToken);
		}

		// VARIABLE: RATIONAL TOKEN
		if( actor.FEATURE.hasRationalRate ) {
			actor.HELPER.varRatToken = XLIA_INFRA.createLocaleVariable(
					XLIA_DATATYPE.createRational(),
					"ratToken", XLIA_EXPRESSION.zero());
			xliaActor.getVariable().add(actor.HELPER.varRatToken);
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

			computeActivationTestBehavior(actor);

			computeConsumptionBehavior(actor);

			computeConsumptionTraceBehavior(actor);
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
		if( moccSystem.FEATURE.hasModeSelector )
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

		moccPort.HELPER =
				new MoccPortHelper(xliaPort, constTokenProductionRate);
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

		if( moccSystem.FEATURE.hasModeSelector )
		{
			xliaPort = createPortTokenMode(moccPort,
					ChannelDirection.INPUT, xliaActor, portTokenType,
					XLIA_DATATYPE.createReference(this.MODE_SET_TYPE));

			varReceivedMode = XLIA_INFRA.createVariable(
					XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
					"receivedMode_from_" + sourceActor);
			xliaActor.getVariable().add(varReceivedMode);

			if( CONFORMANCE_PURPOSE ) {
				xliaChannelPort = createPortTokenMode(
						moccPort.getChannel().getName(), moccPort,
//						ChannelDirection.INPUT, xliaActor, channelTokenType,
						ChannelDirection.OUTPUT, xliaActor, channelTokenType,
						XLIA_DATATYPE.createReference(this.MODE_SET_TYPE));
			}
		}
		else {
			xliaPort = createPortToken(moccPort,
					ChannelDirection.INPUT, xliaActor, portTokenType);

			if( CONFORMANCE_PURPOSE ) {
				xliaChannelPort = createPortToken(
						moccPort.getChannel().getName(), moccPort,
//						ChannelDirection.INPUT, xliaActor, channelTokenType);
						ChannelDirection.OUTPUT, xliaActor, channelTokenType);
			}
		}

		// Mapping: MoccPort-->PortHelper
		moccPort.HELPER = new MoccPortHelper(xliaPort, xliaChannelPort,
				tokenInitialRate, varTokenCount, varReceivedMode, constREQ);
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
							moccPort.actor.HELPER.statemachine,
							moccPort.HELPER.xliaChannelPort );
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
					outputActor.HELPER.statemachine,
					channel.getOutputPort().HELPER.xliaPort );

			XLIA_INFRA.addConnectorEndInputPoint(connector,
					channel.getInputActor().HELPER.statemachine,
					channel.getInputPort().HELPER.xliaPort);

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

		final BlockStatement blockRun = XLIA_STATEMENT.createBlockStatement();
		runRoutine.setBodyBlock(blockRun);

		XLIA_STATEMENT.addActivitySchedule(blockRun);

		// MOE: SCHEDULE
		final Routine scheduleRoutine =
				XLIA_INFRA.createRoutine(XLIA_STATEMENT.OP_SCHEDULE);
		moExcecution.setScheduleRoutine(scheduleRoutine);

		final BlockStatement blockSchedule =
				XLIA_STATEMENT.createBlockStatement();
		scheduleRoutine.setBodyBlock(blockSchedule);

		int activationCount =
				moccSystemFeature.tick_period / moccSystemFeature.tick_interval;

		if( activationCount > 1 ) {
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockSchedule);
			computeSchedulingActor(moccSystemFeature, ifStatement, 0);

			activationCount = activationCount - 1;
			for( int index = 1 ; index < activationCount; index++) {
				computeSchedulingActor(moccSystemFeature,
						XLIA_STATEMENT.addElseIf(ifStatement), index);
			}

			final BlockStatement elseBlock =
					XLIA_STATEMENT.createBlockStatement();
			ifStatement.setElseBlock(elseBlock);
			computeSchedulingActor(moccSystemFeature, elseBlock, activationCount);

			// MOE: RUN
			XLIA_STATEMENT.addAssignment(blockRun, this.varTimestamp,
					XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_PLUS,
							this.varTimestamp, this.varTickInterval));

			if( moccSystemFeature.hasUntimed ) {
				XLIA_STATEMENT.addAssignment(blockRun, this.varTick,
						XLIA_EXPRESSION.createExpression(
								XLIA_EXPRESSION.OP_PLUS,
								this.varTick, this.varTickInterval));

				// PERIOD RE-INITIALISATION
				final IfStatement ifPeriod = XLIA_STATEMENT.addIf(blockRun);
				ifPeriod.setCondition(XLIA_EXPRESSION.createRelational(
						XLIA_EXPRESSION.OP_EQ,
						this.varTick, this.varTickPeriod));

				final BlockStatement blockReinit =
						XLIA_STATEMENT.createBlockStatement();
				ifPeriod.setBodyBlock(blockReinit);

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
								actor.HELPER.statemachine);
					}
				}

				XLIA_STATEMENT.addAssignment(blockReception,
						this.varCanBeActivate,
						XLIA_EXPRESSION.trueValue());

				// NEW PERIO INTIALISATION
				XLIA_STATEMENT.addAssignment(blockReinit,
						this.varTick, XLIA_EXPRESSION.zero());

				for( final MoccActor actor : moccSystem.getActor() ) {
					if( ! actor.FEATURE.isTimed ) {
						XLIA_STATEMENT.addGuard(blockReinit,
								XLIA_EXPRESSION.createRelational(
										XLIA_EXPRESSION.OP_EQ,
										actor.HELPER.statemachine,
										actor.HELPER.varActivationCount,
										actor.HELPER.constREPETITION));

						XLIA_STATEMENT.addAssignment(blockReinit,
								actor.HELPER.statemachine,
								actor.HELPER.varActivationCount,
								XLIA_EXPRESSION.zero());
					}
				}
			}
			else {
				// Tick Incrementation
				XLIA_STATEMENT.addAssignment(blockRun, this.varTick,
						XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_MODULO,
							XLIA_EXPRESSION.createExpression(
								XLIA_EXPRESSION.OP_PLUS,
								this.varTick, this.varTickInterval),
							XLIA_EXPRESSION.createExpression(
									this.varTickPeriod)));
			}
		}
		else {
			computeSchedulingActor(moccSystemFeature, blockSchedule, 0);
		}
	}


	protected void computeSchedulingActor(
			final MoccSystemFeature moccSystemFeature,
			final ConditionalBlockStatement ifBlock, final int activationIndex) {
		final BlockStatement thenBlock = XLIA_STATEMENT.createBlockStatement();
		ifBlock.setBodyBlock(thenBlock);

		ifBlock.setCondition(XLIA_EXPRESSION.createRelational(
				XLIA_EXPRESSION.OP_EQ,
				this.varTick,
				XLIA_EXPRESSION.createInteger(
					activationIndex * moccSystemFeature.tick_interval)));

		computeSchedulingActor(moccSystemFeature, thenBlock, activationIndex);
	}

	protected void computeSchedulingActor(
			final MoccSystemFeature moccSystemFeature,
			final BlockStatement thenBlock, final int activationIndex) {
//		int statementCount = 0;
		for( final MoccActor actor : moccSystem.getActor() ) {
			if( actor.FEATURE.activation[activationIndex] ) {
				if( actor.FEATURE.isTimed ) {
					XLIA_STATEMENT.addActivityRun(thenBlock,
							actor.HELPER.statemachine);
				}
				else {
					XLIA_STATEMENT.addActivityRtc(thenBlock,
							actor.HELPER.statemachine);
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
		// CONSTANT: DEFAULT MODE
		actor.HELPER.constDEFAULT_MODE = XLIA_INFRA.createConstant(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
				"DEFAULT_MODE",
				XLIA_EXPRESSION.createExpression(this.MODE_NOMINAL));
		xliaActor.getVariable().add(actor.HELPER.constDEFAULT_MODE);

		// VARIABLE: MODE UTILS
//		actor.HELPER.varProducingMode = XLIA_INFRA.createVariable(
//				XLIA_DATATYPE.createReference(
//						actorSelectorHelper.MODE_SET_TYPE),
//				"producingMode",
//				XLIA_EXPRESSION.createExpression(actor.HELPER.constDEFAULT_MODE));
//		xliaActor.getVariable().add(actor.HELPER.varProducingMode);

		actor.HELPER.varProcessingMode = XLIA_INFRA.createVariable(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE),
				"processingMode",
				XLIA_EXPRESSION.createExpression(actor.HELPER.constDEFAULT_MODE));
		xliaActor.getVariable().add(actor.HELPER.varProcessingMode);
	}


	public void selectorActorDeclaration(
			final MoccActor actor, final Statemachine xliaActor)
	{
		// CONSTANT: SELECTION SET
		final CollectionType constType = XLIA_DATATYPE.createCollectionList(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), -1);

		actor.HELPER.constSELECTIONG_SET =
				XLIA_INFRA.createConstant(constType, "SELECTION_SET",
						XLIA_EXPRESSION.createCollectionLiterals(
								actor.HELPER.modeSelectionSet));
		xliaActor.getVariable().add(actor.HELPER.constSELECTIONG_SET);
	}


	public void processorActorDeclaration (
			final MoccActor actor, final Statemachine xliaActor)
	{
		// VARIABLE: PROCESSING SET
		final CollectionType constType = XLIA_DATATYPE.createCollectionList(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), -1);

		actor.HELPER.modeProcessingSet = modeLiterals(this.MODE_SET_TYPE,
				actor.getProcessingSetLiterals());

		actor.HELPER.constPROCESSING_SET =
				XLIA_INFRA.createConstant(constType, "PROCESSING_SET",
						XLIA_EXPRESSION.createCollectionLiterals(
								actor.HELPER.modeProcessingSet));
		xliaActor.getVariable().add(actor.HELPER.constPROCESSING_SET);
	}

	public void selectorProcessorActorDeclaration(
			final MoccActor actor, final Statemachine xliaActor)
	{
		selectorActorDeclaration(actor, xliaActor);

		// VARIABLE: PROCESSING SET
		final CollectionType constType = XLIA_DATATYPE.createCollectionList(
				XLIA_DATATYPE.createReference(this.MODE_SET_TYPE), -1);

		actor.HELPER.modeProcessingSet = modeLiterals(
				this.MODE_SET_TYPE, actor.getProcessingSetLiterals());

		actor.HELPER.constPROCESSING_SET =
				XLIA_INFRA.createConstant(constType, "PROCESSING_SET",
						XLIA_EXPRESSION.createCollectionLiterals(
								actor.HELPER.modeProcessingSet));
		xliaActor.getVariable().add(actor.HELPER.constPROCESSING_SET);
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
				actor.HELPER.macroComputeProcessingMode);

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
		XLIA_STATEMACHINE.createTransition("t_activate", s_idle, s_activation);

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

		if( moccSystem.FEATURE.hasModeSelector && actor.FEATURE.hasInput ) {
			final BlockStatement blockEnable =
					XLIA_STATEMENT.createBlockStatement();

			XLIA_STATEMENT.addInvoke(blockEnable,
					actor.HELPER.macroComputeProcessingMode);

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

		if( actor.HELPER.macroInitialization != null ) {
			final BlockStatement block = XLIA_STATEMENT.createBlockStatement();
			transition.setBehavior(block);

			XLIA_STATEMENT.addInvoke(block, actor.HELPER.macroInitialization);
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

		XLIA_STATEMENT.addInvoke(block, actor.HELPER.macroReception);

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
//				actor.HELPER.varRatToken : actor.HELPER.varIntToken;
//
//		if( moccPort.isInputMode() ) {
//			XLIA_STATEMENT.addInvoke(block,
//					actor.getSelector().HELPER.macroReceiveTokenMode,
//					moccPort.HELPER.xliaPort, vaReceivedToken,
//					moccPort.HELPER.varReceivedModeTokenCount,
//					moccPort.HELPER.varReceivedMode);
//		}
//		else {
//			XLIA_STATEMENT.addInvoke(block,
//					this.macroReceiveToken, moccPort.HELPER.xliaPort,
//					vaReceivedToken, moccPort.HELPER.varReceivedModeTokenCount);
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
				actor.HELPER.macroActivationProcessTest);

		// Processing --> Passing
		final Pseudostate s_passing =
				XLIA_STATEMACHINE.createJunctionState("passing");
		region.getVertex().add(s_passing);

		final Transition t_pass = XLIA_STATEMACHINE.createTransitionElse(
				"t_pass", s_activation, s_passing);

		final BlockStatement blockPass = XLIA_STATEMENT.createBlockStatement();
		t_pass.setBehavior(blockPass);

//		XLIA_STATEMENT.addInvoke(blockPass,
//				actor.HELPER.macroActivationPassTest);

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

		XLIA_STATEMENT.addInvoke(block, actor.HELPER.macroActivationTest);
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
					(moccPort.HELPER.constTOKEN_INITIAL_RATE == null)
						? XLIA_EXPRESSION.zero()
						: XLIA_EXPRESSION.createExpression(
								moccPort.HELPER.constTOKEN_INITIAL_RATE);

			XLIA_STATEMENT.addAssignment(block,
					moccPort.HELPER.varReceivedModeTokenCount, value);
		}

		actor.HELPER.macroInitialization =
				XLIA_INFRA.createMacroRoutine(
						actor.HELPER.statemachine, "initialization", block);
	}

	/**
	 * Reception Behavior
	 * @param actor
	 * @param block
	 */
	protected void computeReceptionBehavior(final MoccActor actor)
	{
		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		int statementCount = 0;
		for( final MoccPort moccPort : actor.getInputPort() ) {
			final Variable vaReceivedToken = moccPort.isOutputRational() ?
					actor.HELPER.varRatToken : actor.HELPER.varIntToken;

			if( moccSystem.FEATURE.hasModeSelector ) {
				XLIA_STATEMENT.addInvoke(block, this.macroReceiveTokenMode,
						moccPort.HELPER.xliaPort, vaReceivedToken,
						moccPort.HELPER.varReceivedModeTokenCount,
						moccPort.HELPER.varReceivedMode);
			}
			else {
				XLIA_STATEMENT.addInvoke(block, this.macroReceiveToken,
						moccPort.HELPER.xliaPort, vaReceivedToken,
						moccPort.HELPER.varReceivedModeTokenCount);
			}

			// Increment statementCount
			++statementCount;
		}

		if( statementCount > 1 ) {
//			block.setOp(XLIA_STATEMENT.OP_INTERLEAVING);
			block.setOp(XLIA_STATEMENT.OP_SEQUENCE_WEAK);
		}

		actor.HELPER.macroReception =
				XLIA_INFRA.createMacroRoutine(
						actor.HELPER.statemachine, "reception", block);
	}


	/**
	 * Activation Test
	 * @param actor
	 * @param block
	 */
	protected void computeActivationTestBehavior(final MoccActor actor)
	{
		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		// GENERAL ACTIVATION FLAG
		if( moccSystem.FEATURE.hasUntimed ) {
			XLIA_STATEMENT.addGuard(block,
					XLIA_EXPRESSION.createExpression(this.varCanBeActivate));
		}

		// REPETITION COUNT / PERIOD CONDITION
		if( ! actor.FEATURE.isTimed ) {
			XLIA_STATEMENT.addGuard(block,
					XLIA_EXPRESSION.createRelational(
							XLIA_EXPRESSION.OP_LT,
							actor.HELPER.varActivationCount,
							actor.HELPER.constREPETITION));
		}

		// TOKEN RATE CONDITION
		for( final MoccPort moccPort : actor.getInputPort() ) {
			XLIA_STATEMENT.addGuard(block,
					XLIA_EXPRESSION.createRelational(
							XLIA_EXPRESSION.OP_GTE,
							moccPort.HELPER.varReceivedModeTokenCount,
							moccPort.HELPER.constTOKEN_RATE));
		}

		actor.HELPER.macroActivationTest =
				XLIA_INFRA.createMacroRoutine(
						actor.HELPER.statemachine, "activationTest", block);

		if( actor.FEATURE.isModeProcessor ) {
			computeActivationProcessingTestBehavior(actor);
		}
		else if( moccSystem.FEATURE.hasModeSelector
				&& actor.FEATURE.hasOutput ) {
			computeActivationPassingMode(actor);
		}
	}


	private void computeActivationPassingMode(final MoccActor actor) {
		// Processing Mode Computer
		final BlockStatement blockEnable = XLIA_STATEMENT.createBlockStatement();

		final List< Expression > undefinedMode = new ArrayList<Expression>();

		for( final MoccPort inPort : actor.getInputPort() ) {
			undefinedMode.add(
					XLIA_EXPRESSION.createRelational(
							XLIA_EXPRESSION.OP_EQ,
							inPort.HELPER.varReceivedMode,
							this.MODE_UNDEFINED));
		}

		if( ! undefinedMode.isEmpty() ) { // Singleton input mode case
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockEnable);

			// Undefined Mode Passing
			ifStatement.setCondition(
					XLIA_EXPRESSION.createOR(undefinedMode));
			final BlockStatement thenBlock =
					XLIA_STATEMENT.createBlockStatement();
			ifStatement.setBodyBlock(thenBlock);

			XLIA_STATEMENT.addAssignment(thenBlock,
					actor.HELPER.varProcessingMode, this.MODE_UNDEFINED);

			final BlockStatement elseBlock =
					XLIA_STATEMENT.createBlockStatement();
			ifStatement.setElseBlock(elseBlock);

			XLIA_STATEMENT.addAssignment(elseBlock,
					actor.HELPER.varProcessingMode, this.MODE_NOMINAL);
		}

		actor.HELPER.macroComputeProcessingMode =
				XLIA_INFRA.createMacroRoutine(
						actor.HELPER.statemachine,
						"computeProcessingMode", blockEnable);
	}


	private void computeActivationProcessingMode(final MoccActor actor) {
		// Processing Mode Computer
		final BlockStatement blockEnable = XLIA_STATEMENT.createBlockStatement();

		final List< Expression > identicalModes = new ArrayList<Expression>();
		final List< Expression > undefinedMode = new ArrayList<Expression>();
		final List< Expression > differentModes = new ArrayList<Expression>();

		Variable firstInputMode = null;
		for( final MoccPort inPort : actor.getInputPort() ) {
			if( inPort.isInputMode() ) {
				if( firstInputMode == null ) {
					firstInputMode = inPort.HELPER.varReceivedMode;
				}
				else {
					identicalModes.add(
							XLIA_EXPRESSION.createRelational(
									XLIA_EXPRESSION.OP_EQ, firstInputMode,
									inPort.HELPER.varReceivedMode));

					differentModes.add(
							XLIA_EXPRESSION.createRelational(
									XLIA_EXPRESSION.OP_NOT_EQ, firstInputMode,
									inPort.HELPER.varReceivedMode));
				}
			}

			undefinedMode.add(
					XLIA_EXPRESSION.createRelational(
							XLIA_EXPRESSION.OP_EQ,
							inPort.HELPER.varReceivedMode,
							this.MODE_UNDEFINED));
		}

		if( firstInputMode == null ) {
			// NO INPUT MODE
		}
		else if( identicalModes.isEmpty() ) { // Singleton input mode case
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockEnable);

			// Undefined Mode Passing
			ifStatement.setCondition(
					XLIA_EXPRESSION.createOR(undefinedMode));

			final BlockStatement thenBlock =
					XLIA_STATEMENT.createBlockStatement();
			ifStatement.setBodyBlock(thenBlock);

			XLIA_STATEMENT.addAssignment(thenBlock,
					actor.HELPER.varProcessingMode, this.MODE_UNDEFINED);

			// Else Identical i.e. Singleton
			final BlockStatement elseBlock =
					XLIA_STATEMENT.createBlockStatement();
			ifStatement.setElseBlock(elseBlock);

			XLIA_STATEMENT.addAssignment(elseBlock,
					actor.HELPER.varProcessingMode, firstInputMode);
		}
		else if( actor.isNominalSingletonProcessingSet() ) {
			XLIA_STATEMENT.addAssignment(blockEnable,
					actor.HELPER.varProcessingMode, this.MODE_NOMINAL);
		}
		else {
			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockEnable);

			// Identical Mode Processing
			ifStatement.setCondition(
					XLIA_EXPRESSION.createAND(identicalModes));

			final BlockStatement thenBlock =
					XLIA_STATEMENT.createBlockStatement();
			ifStatement.setBodyBlock(thenBlock);

			XLIA_STATEMENT.addAssignment(thenBlock,
					actor.HELPER.varProcessingMode, firstInputMode);

			// Undefined Mode Passing
			final ConditionalBlockStatement undefElseIfStatement =
					XLIA_STATEMENT.addElseIf(ifStatement);
			undefElseIfStatement.setCondition(
					XLIA_EXPRESSION.createOR(undefinedMode));

			final BlockStatement undefElseIfBlock =
					XLIA_STATEMENT.createBlockStatement();
			undefElseIfStatement.setBodyBlock(undefElseIfBlock);

			XLIA_STATEMENT.addAssignment(undefElseIfBlock,
					actor.HELPER.varProcessingMode, this.MODE_UNDEFINED);

			// Different Mode passing
			final ConditionalBlockStatement diffElseIfStatement =
					XLIA_STATEMENT.addElseIf(ifStatement);
			diffElseIfStatement.setCondition(
					XLIA_EXPRESSION.createOR(differentModes));

			final BlockStatement diffElseIfBlock =
					XLIA_STATEMENT.createBlockStatement();
			diffElseIfStatement.setBodyBlock(diffElseIfBlock);

			XLIA_STATEMENT.addAssignment(diffElseIfBlock,
					actor.HELPER.varProcessingMode, this.MODE_UNDEFINED);

			// Else Mode passing
			final BlockStatement elseBlock =
					XLIA_STATEMENT.createBlockStatement();
			ifStatement.setElseBlock(elseBlock);

			XLIA_STATEMENT.addAssignment(elseBlock,
					actor.HELPER.varProcessingMode, this.MODE_UNDEFINED);
		}

		actor.HELPER.macroComputeProcessingMode =
				XLIA_INFRA.createMacroRoutine(
						actor.HELPER.statemachine,
						"computeProcessingMode", blockEnable);
	}


	private void computeActivationProcessingTestBehavior(final MoccActor actor) {
		// Processing Mode Computer
		computeActivationProcessingMode(actor);

		// Activation PROCESSING
		final BlockStatement blockProcess = XLIA_STATEMENT.createBlockStatement();

		final List< Expression > processConditions = new ArrayList<Expression>();
		for( final EnumerationLiteral literal : actor.HELPER.modeProcessingSet )
		{
			processConditions.add(
					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
							actor.HELPER.varProcessingMode, literal));
		}
		XLIA_STATEMENT.addGuard(blockProcess,
				XLIA_EXPRESSION.createOR(processConditions));

		actor.HELPER.macroActivationProcessTest =
				XLIA_INFRA.createMacroRoutine(
						actor.HELPER.statemachine,
						"activationProcessTest", blockProcess);


		// Activation PASSING
		final BlockStatement blockPass = XLIA_STATEMENT.createBlockStatement();

		final List< Expression > passConditions = new ArrayList<Expression>();
		for( final EnumerationLiteral literal : actor.HELPER.modeProcessingSet )
		{
			passConditions.add(
					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_NOT_EQ,
							actor.HELPER.varProcessingMode, literal));
		}
		XLIA_STATEMENT.addGuard(blockPass,
				XLIA_EXPRESSION.createAND(passConditions));

		actor.HELPER.macroActivationPassTest = XLIA_INFRA.createMacroRoutine(
				actor.HELPER.statemachine, "activationPassTest", blockPass);
	}


	/**
	 * Consumption Behavior
	 * @param actor
	 * @param block
	 */
	protected void computeConsumptionBehavior(final MoccActor actor)
	{
		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		XLIA_STATEMENT.addInvoke(block, macroJsonTraceBegin,
				XLIA_EXPRESSION.createExpression("CONSUMPTION"),
				XLIA_EXPRESSION.createExpression(actor.getName()),
				XLIA_EXPRESSION.createExpression(actor.getNature()));

		boolean isFirst = true;

		for( final MoccPort moccPort : actor.getInputPort() ) {
			XLIA_STATEMENT.addDecrementation(block,
					moccPort.HELPER.varReceivedModeTokenCount,
					XLIA_EXPRESSION.createExpression(
							moccPort.HELPER.constTOKEN_RATE));

			if( moccSystem.FEATURE.hasModeSelector )
			{
				assert (moccPort.HELPER.varReceivedMode != null) :
					"Unexpected a null varReceivedMode for port " +
						moccPort.getName();

				invokeJsonTraceBodyConsumptionMode(isFirst, block, moccPort);
			}
			else {
				invokeJsonTraceBodyConsumption(isFirst, block, moccPort);
			}

			isFirst = false;
		}

		XLIA_STATEMENT.addInvoke(block, macroJsonTraceEnd);

		// Increment varActivationCount during consumption for non-timed actor
		if( ! actor.FEATURE.isTimed ) {
			XLIA_STATEMENT.addAssignment(block,
					actor.HELPER.varActivationCount,
					XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_PLUS,
							actor.HELPER.varActivationCount,
							XLIA_EXPRESSION.createInteger(1)));
		}

		actor.HELPER.macroConsumption =
				XLIA_INFRA.createMacroRoutine(
						actor.HELPER.statemachine, "consumption", block);
	}

	/**
	 * Consumption Behavior for trace conformance purpose
	 * @param actor
	 * @param block
	 */
	protected void computeConsumptionTraceBehavior(final MoccActor actor)
	{
		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		for( final MoccPort moccPort : actor.getInputPort() ) {
//			final Variable vaReceivedToken = moccPort.isInputRational() ?
//					actor.HELPER.varRatToken : actor.HELPER.varIntToken;

			if( moccSystem.FEATURE.hasModeSelector )
			{
				assert (moccPort.HELPER.varReceivedMode != null) :
					"Unexpected a null varReceivedMode for port " +
						moccPort.getName();

				XLIA_STATEMENT.addOutputCom(block,
						moccPort.HELPER.xliaChannelPort,
						moccPort.HELPER.constTOKEN_RATE,
						moccPort.HELPER.varReceivedMode);
			}
			else {
				XLIA_STATEMENT.addOutputCom(block,
						moccPort.HELPER.xliaChannelPort,
						moccPort.HELPER.constTOKEN_RATE);
			}

//				XLIA_STATEMENT.addInputCom(block,
//						moccPort.HELPER.xliaChannelPort,
//						vaReceivedToken, moccPort.HELPER.varReceivedMode);
//			}
//			else {
//				XLIA_STATEMENT.addInputCom(block,
//						moccPort.HELPER.xliaChannelPort, vaReceivedToken);
//			}

//			XLIA_STATEMENT.addGuard(block,
//					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_EQ,
//							vaReceivedToken, moccPort.HELPER.constTOKEN_RATE));
		}

		actor.HELPER.macroConsumptionTrace =
				XLIA_INFRA.createMacroRoutine(
						actor.HELPER.statemachine, "consumptionTrace", block);
	}

	/**
	 * Production Behavior
	 * @param actor
	 * @param block
	 */
	protected void computeProductionBehavior(final MoccActor actor)
	{
		final BlockStatement block = XLIA_STATEMENT.createBlockStatement();

		// Increment varActivationCount during consumption for non-timed actor
		// without input port
		if( (! actor.FEATURE.isTimed)
			&& (actor.HELPER.macroConsumption == null) )
		{
			XLIA_STATEMENT.addAssignment(block,
					actor.HELPER.varActivationCount,
					XLIA_EXPRESSION.createExpression(
							XLIA_EXPRESSION.OP_PLUS,
							actor.HELPER.varActivationCount,
							XLIA_EXPRESSION.createInteger(1)));
		}


		XLIA_STATEMENT.addInvoke(block, macroJsonTraceBegin,
				XLIA_EXPRESSION.createExpression("PRODUCTION"),
				XLIA_EXPRESSION.createExpression(actor.getName()),
				XLIA_EXPRESSION.createExpression(actor.getNature()));

		boolean isFirst = true;

		if( actor.FEATURE.isModeSelector ) {
			final BlockStatement prodBlock =
					XLIA_STATEMENT.createBlockStatement(
							block, XLIA_STATEMENT.OP_INTERLEAVING);

			for( final EnumerationLiteral modeLiteral :
				actor.HELPER.modeSelectionSet )
			{
				XLIA_STATEMENT.addAssignment(prodBlock,
						actor.HELPER.varProcessingMode, modeLiteral);
			}

			for( final MoccPort moccPort : actor.getOutputPort() ) {
				XLIA_STATEMENT.addOutputCom(block,
						moccPort.HELPER.xliaPort,
						moccPort.HELPER.constTOKEN_RATE,
						actor.HELPER.varProcessingMode);

				invokeJsonTraceBodyProductionMode(
						isFirst, block, actor, moccPort);

				isFirst = false;
			}
		}
		else {
			for( final MoccPort moccPort : actor.getOutputPort() ) {
				if( moccSystem.FEATURE.hasModeSelector )
				{
					XLIA_STATEMENT.addOutputCom(block,
							moccPort.HELPER.xliaPort,
							moccPort.HELPER.constTOKEN_RATE,
							actor.HELPER.varProcessingMode);

					invokeJsonTraceBodyProductionMode(
							isFirst, block, actor, moccPort);
				}
				else {
					XLIA_STATEMENT.addOutputCom(block,
							moccPort.HELPER.xliaPort,
							moccPort.HELPER.constTOKEN_RATE);

					invokeJsonTraceBodyProduction(isFirst, block, moccPort);
				}

				isFirst = false;
			}
		}

		XLIA_STATEMENT.addInvoke(block, macroJsonTraceEnd);

		actor.HELPER.macroProduction = XLIA_INFRA.createMacroRoutine(
				actor.HELPER.statemachine, "production", block);
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

		if( actor.hasInputPort() ) {
			XLIA_STATEMENT.addInvoke(block, actor.HELPER.macroConsumption);
			XLIA_STATEMENT.addInvoke(block, actor.HELPER.macroConsumptionTrace);
		}
		if( actor.hasOutputPort() ) {
			XLIA_STATEMENT.addInvoke(block, actor.HELPER.macroProduction);
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

			XLIA_STATEMENT.addInvoke(block, actor.HELPER.macroConsumption);
			XLIA_STATEMENT.addInvoke(block, actor.HELPER.macroConsumptionTrace);
		}
	}


}
