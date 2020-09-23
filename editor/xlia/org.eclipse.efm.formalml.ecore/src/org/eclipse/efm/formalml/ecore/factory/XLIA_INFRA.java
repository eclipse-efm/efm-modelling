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

import org.eclipse.efm.ecore.formalml.common.VisibilityKind;
import org.eclipse.efm.ecore.formalml.datatype.DataType;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection;
import org.eclipse.efm.ecore.formalml.infrastructure.ComPoint;
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol;
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind;
import org.eclipse.efm.ecore.formalml.infrastructure.Connector;
import org.eclipse.efm.ecore.formalml.infrastructure.ConnectorEnd;
import org.eclipse.efm.ecore.formalml.infrastructure.Function;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructureFactory;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution;
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction;
import org.eclipse.efm.ecore.formalml.infrastructure.Modifier;
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter;
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet;
import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;
import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem;
import org.eclipse.efm.ecore.formalml.specification.SpecificationFactory;
import org.eclipse.efm.ecore.formalml.specification.XliaModel;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;

public class XLIA_INFRA {

	// InfrastructureFactory FACTORY
	static InfrastructureFactory FACTORY = InfrastructureFactory.eINSTANCE;

	// MODEL
	public static XliaModel createModel() {
		return SpecificationFactory.eINSTANCE.createXliaModel();
	}

	// SYSTEM
	public static XliaSystem createSystem(final String name) {
		final XliaSystem system = FACTORY.createXliaSystem();
		system.setName(name);

		return system;
	}

	// MACHINE
	public static Machine createMachine(final String name) {
		final Machine machine = FACTORY.createMachine();
		machine.setName(name);

		return machine;
	}

	// PARAMETER
	public static Parameter createParameter(
			final DataType type, final String name) {
		final Parameter parameter = FACTORY.createParameter();
		parameter.setName(name);

		parameter.setType(type);

		return parameter;
	}

	public static Parameter createParameterInteger(final String name) {
		return createParameter(XLIA_DATATYPE.createInteger(), name);
	}

	public static Parameter createParameterRational(final String name) {
		return createParameter(XLIA_DATATYPE.createRational(), name);
	}

	// VARIABLE
	public static Variable createVariable(final DataType type, final String name) {
		final Variable variable = FACTORY.createVariable();
		variable.setName(name);

		variable.setType(type);

		return variable;
	}

	public static Variable createVariable(
			final DataType type, final String name, final Expression value) {
		final Variable variable = createVariable(type, name);

		variable.setDefaultValue(value);

		return variable;
	}

	public static Variable createPublicVariable(
			final DataType type, final String name, final Expression value) {
		final Variable variable = createVariable(type, name, value);

		variable.setVisibility(VisibilityKind.PUBLIC);

		return variable;
	}

	// VARIABLE LOCALE
	public static Variable createLocaleVariable(
			final DataType type, final String name, final Expression value) {
		final Variable variable = createVariable(type, name, value);

		final Modifier modifier = FACTORY.createModifier();
		modifier.setTransient(true);
		variable.setModifier(modifier);

		return variable;
	}

	public static Variable createPublicLocaleVariable(
			final DataType type, final String name, final Expression value) {
		final Variable variable = createLocaleVariable(type, name, value);

		variable.setVisibility(VisibilityKind.PUBLIC);

		return variable;
	}

	// CONSTANT
	public static Variable createConstant(
			final DataType type, final String name, final Expression value) {
		final Variable constant = createVariable(type, name, value);

		constant.setConst(true);

		final Modifier modifier = FACTORY.createModifier();
		modifier.setFinal(true);
		constant.setModifier(modifier);

		return constant;
	}

	public static Variable createPublicConstant(
			final DataType type, final String name, final Expression value) {
		final Variable constant = createConstant(type, name, value);

		constant.setVisibility(VisibilityKind.PUBLIC);

		return constant;
	}

	// PORT
	public static Port createPort(final String name) {
		final Port port = FACTORY.createPort();
		port.setName(name);

		return port;
	}

	public static Port createPort(final String name,
			final DataType paramType, final String paramName) {
		final Port port = createPort(name);

		final ParameterSet parammeters = FACTORY.createParameterSet();
		port.setParameterSet(parammeters);

		parammeters.getParameter().add(
				createParameter(paramType, paramName) );

		return port;
	}

	public static Port createPort(final String name,
			final DataType paramTypeA, final String paramNameA,
			final DataType paramTypeB, final String paramNameB) {
		final Port port = createPort(name);

		final ParameterSet parammeters = FACTORY.createParameterSet();
		port.setParameterSet(parammeters);

		parammeters.getParameter().add(
				createParameter(paramTypeA, paramNameA) );

		parammeters.getParameter().add(
				createParameter(paramTypeB, paramNameB) );

		return port;
	}


	// BEHAVIOR
	public static Behavior createBehavior() {
		return FACTORY.createBehavior();
	}

	// PARAMETER SET
	public static ParameterSet createParameterSet() {
		return FACTORY.createParameterSet();
	}

	// ROUTINE
	public static Routine createRoutine(final String name) {
		final Routine routine = FACTORY.createRoutine();
		routine.setName(name);

		return routine;
	}

	// MACRO ROUTINE
	public static Routine createMacroRoutine(
			final Machine machine, final String name,
			final ParameterSet parameterSet, final BlockStatement block) {
		final Routine routine = createRoutine(name);

		routine.setMacro(true);

		routine.setParameterSet(parameterSet);

		routine.setBodyBlock(block);

		machine.getRoutine().add(routine);

		return routine;
	}

	public static Routine createMacroRoutine(
			final Machine machine, final String name, final BlockStatement block) {
		return createMacroRoutine(machine, name, null, block);
	}

	// FUNCTION
	// ROUTINE
	public static Function createFunction(final String name) {
		final Function function = FACTORY.createFunction();
		function.setName(name);

		return function;

//		return createRoutine(name);
	}


	// MODEL OF INTERACTION
	public static ModelOfInteraction createMOI(final Behavior behavior) {
		final ModelOfInteraction moInteraction =
				FACTORY.createModelOfInteraction();

		behavior.setInteraction(moInteraction);

		return moInteraction;
	}

	// MODEL OF EXECUTION
	public static ModelOfExecution createMOE() {
		return FACTORY.createModelOfExecution();
	}

	public static ModelOfExecution createMOE(final Behavior behavior) {
		final ModelOfExecution moExcecution = FACTORY.createModelOfExecution();

		behavior.setExecution(moExcecution);

		return moExcecution;
	}


	// COMMUNICATION PROTOCOL
	public static ComProtocol createProtocol() {
		return FACTORY.createComProtocol();
	}

	public static ComProtocol createProtocolEnv() {
		final ComProtocol protocol = FACTORY.createComProtocol();

		protocol.setProtocol(ComProtocolKind.ENV);

		return protocol;
	}

	public static ComProtocol createProtocolFifo(final int size) {
		final ComProtocol protocol = FACTORY.createComProtocol();

		protocol.setProtocol(ComProtocolKind.BUFFER);
		protocol.setInner_buffer(XLIA_DATATYPE.createCollectionFifo(size));

		return protocol;
	}

	// CONNECTOR
	public static Connector createConnector(final String name) {
		final Connector connector = FACTORY.createConnector();
		connector.setName(name);

		return connector;
	}

	public static Connector createConnectorEnv(final String name) {
		final Connector connector = XLIA_INFRA.createConnector(name);

		connector.setProtocol( createProtocolEnv() );

		return connector;
	}

	public static Connector createConnectorFifo(
			final String name, final int size) {
		final Connector connector = XLIA_INFRA.createConnector(name);

		connector.setProtocol( createProtocolFifo(size) );

		return connector;
	}


	// CONNECTOR END
	public static ConnectorEnd createConnectorEnd(
			final Connector connector, final ChannelDirection direction) {
		final ConnectorEnd connectorEnd = FACTORY.createConnectorEnd();

		connectorEnd.setDirection( direction );

		connector.getConnectorEnd().add(connectorEnd);

		return connectorEnd;
	}

	public static ConnectorEnd createConnectorEndOutput(
			final Connector connector) {
		return createConnectorEnd(connector, ChannelDirection.OUTPUT);
	}

	public static ConnectorEnd createConnectorEndInput(
			final Connector connector) {
		return createConnectorEnd(connector, ChannelDirection.INPUT);
	}


	// COMMUNICATION POINT
	public static void addComPoint(
			final ConnectorEnd connectorEnd,
			final Machine machine, final Port port) {
		final ComPoint comPoint = FACTORY.createComPoint();

		comPoint.setMachine(machine);
		comPoint.setPort(port);

		connectorEnd.getPoints().add(comPoint);
	}


	// COMMUNICATION CONNECTOR END POINT
	public static void addConnectorEndPoint(
			final Connector connector, final ChannelDirection direction,
			final Machine machine, final Port port) {
		final ConnectorEnd connectorEnd = createConnectorEnd(connector, direction);

		addComPoint(connectorEnd, machine, port);
	}

	public static void addConnectorEndOutputPoint(
			final Connector connector, final Machine machine, final Port port) {
		addConnectorEndPoint(connector, ChannelDirection.OUTPUT, machine, port);
	}

	public static void addConnectorEndInputPoint(
			final Connector connector, final Machine machine, final Port port) {
		addConnectorEndPoint(connector, ChannelDirection.INPUT, machine, port);
	}

}
