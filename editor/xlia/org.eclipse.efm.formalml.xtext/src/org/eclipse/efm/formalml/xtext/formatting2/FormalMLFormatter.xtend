/*****************************************************************************
* Copyright (c) 2018 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
*  - Initial API and implementation
*****************************************************************************/
package org.eclipse.efm.formalml.xtext.formatting2

import com.google.inject.Inject
import org.eclipse.efm.ecore.formalml.specification.XliaModel
import org.eclipse.efm.ecore.formalml.specification.XliaObject
import org.eclipse.efm.formalml.xtext.services.FormalMLGrammarAccess
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument

class FormalMLFormatter extends AbstractFormatter2 {
	
	@Inject extension FormalMLGrammarAccess

	def dispatch void format(XliaModel xliaModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		xliaModel.prolog.format
		xliaModel.system.format
	}

	def dispatch void format(XliaObject xliaObject, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (xliaNamedElement : xliaObject.elements) {
			xliaNamedElement.format
		}
	}
	
	// TODO: implement for XliaAttribute, XliaSection, XliaSystem, InstanceMachine, SlotProperty, Machine, PropertyPart, CompositePart, BehaviorPart, Procedure, ModelOfExecution, Behavior, Statemachine, Region, State, StartState, FinalState, Pseudostate, Routine, ModelOfInteraction, Route, ComProtocol, Connector, ConnectorEnd, ValueElementSpecification, LiteralReferenceSpecification, DataTypeReference, BlockStatement, GuardStatement, PrimitiveTimeType, IntervalType, CollectionType, EnumerationType, EnumerationLiteral, StructureType, UnionType, ChoiceType, Function, Variable, ParameterSet, Parameter, Buffer, Port, Signal, Channel, Transition, LogicalAssociativeExpression, TimedGuardStatement, ExpressionStatement, EventGuardStatement, CheckSatGuardStatement, InputComStatement, OutputComStatement, IfStatement, ConditionalBlockStatement, WhileDoStatement, DoWhileStatement, ForStatement, ForEachStatement, InterruptStatement, ActivityStatement, InvokeStatement, ObserverStatement, MetaStatement, AssignmentExpression, LeftHandSideExpression, ConditionalTestExpression, BitwiseAssociativeExpression, EqualityBinaryExpression, RelationalBinaryExpression, RelationalTernaryExpression, ArithmeticAssociativeExpression, IncrementOrDecrementPostfixExpression, IncrementOrDecrementPrefixExpression, NewfreshExpression, CastExpression, ArithmeticUnaryExpression, QuantifiedLogicalExpression, LogicalUnaryExpression, BitwiseUnaryExpression, InvokeExpression, InstantiationExpression, MixTupleExpression, PositionalTupleExpression, NamedExpression, LiteralNullExpression, LiteralAnyValueExpression, LiteralOptionalValueExpression, LiteralNoneValueExpression, LiteralAnyOrNoneValueExpression, LiteralCollectionExpression, LiteralReferenceElement
}
