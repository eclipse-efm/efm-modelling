/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
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
package org.eclipse.efm.formalml.xtext.scoping

import com.google.inject.Inject
import org.eclipse.efm.ecore.formalml.common.NamedElement
import org.eclipse.efm.ecore.formalml.common.TypedElement
import org.eclipse.efm.ecore.formalml.common.VisibilityKind
import org.eclipse.efm.ecore.formalml.datatype.DataStructuredType
import org.eclipse.efm.ecore.formalml.datatype.DataSupportedType
import org.eclipse.efm.ecore.formalml.datatype.DataType
import org.eclipse.efm.ecore.formalml.datatype.DataTypeReference
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType
import org.eclipse.efm.ecore.formalml.expression.InvokeExpression
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression
import org.eclipse.efm.ecore.formalml.expression.TupleExpression
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior
import org.eclipse.efm.ecore.formalml.infrastructure.Channel
import org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection
import org.eclipse.efm.ecore.formalml.infrastructure.ComPoint
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.infrastructure.Port
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition
import org.eclipse.efm.ecore.formalml.infrastructure.Routine
import org.eclipse.efm.ecore.formalml.infrastructure.Signal
import org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty
import org.eclipse.efm.ecore.formalml.infrastructure.Variable
import org.eclipse.efm.ecore.formalml.statemachine.Region
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine
import org.eclipse.efm.ecore.formalml.statemachine.Transition
import org.eclipse.efm.ecore.formalml.statement.AbstractComStatement
import org.eclipse.efm.ecore.formalml.statement.ActivityStatement
import org.eclipse.efm.ecore.formalml.statement.InputComStatement
import org.eclipse.efm.ecore.formalml.statement.OutputComStatement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.efm.formalml.xtext.typing.FormalMLTypeProvider

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class FormalMLScopeProvider extends AbstractFormalMLScopeProvider {

	@Inject extension FormalMLTypeProvider

	////////////////////////////////////////////////////////////////////////////
	// Tools / Utils
	////////////////////////////////////////////////////////////////////////////

	def Iterable< ? extends NamedElement> selectPublic(
		Iterable< ? extends NamedElement> elements) {

		elements.filter[ visibility == VisibilityKind.PUBLIC ]
	}

	def Iterable< ? extends NamedElement> selectNonPublic(
		Iterable< ? extends NamedElement> elements) {

		elements.filter[ visibility != VisibilityKind.PUBLIC ]
	}


	def Iterable< ? extends PropertyDefinition > selectNonFinalNorConst(
		Iterable< ? extends PropertyDefinition > elements) {
		val nonFinalNorConstPredicate = [ PropertyDefinition P |
			(P.modifier.final == false) &&
			((! (P instanceof Variable)) || ((P as Variable).const == false)) ]

		elements.filter( nonFinalNorConstPredicate )
	}


	def isAncestorOf(EObject container, EObject element) {
		var ancestor = element.eContainer

		while( (ancestor != null) && (ancestor != container) ) {
			ancestor = ancestor.eContainer
		}

		( ancestor != null )
	}


//	def Iterable< ? extends TypedElement > selectTypedElement(
//		Iterable< ? extends TypedElement > elements,
//		PrimitiveInstanceKind expected1, PrimitiveInstanceKind expected2) {
//
//		val typePredicate = [ TypedElement element |
//			(element.type instanceof PrimitiveInstanceType) && (
//				((element.type as PrimitiveInstanceType).expected == expected1) ||
//				((element.type as PrimitiveInstanceType).expected == expected2) ) ]
//
//		elements.filter( typePredicate )
//	}


	def Iterable< ? extends TypedElement > selectTypedElement(
		Iterable< ? extends TypedElement > elements, PrimitiveInstanceKind expected) {

		val typePredicate = [ TypedElement element |
			(element.type instanceof PrimitiveInstanceType) &&
				((element.type as PrimitiveInstanceType).expected == expected) ]

		elements.filter( typePredicate )
	}


	////////////////////////////////////////////////////////////////////////////
	// ComStatement --> Port
	////////////////////////////////////////////////////////////////////////////

//	def scope_NamedElement(InputComStatement context, EReference r) {
//		context.scopeForHierarchicRigthElement(ValueElementSpecificationScheme.COM_POINT)
//	}
//
//	def scope_NamedElement(OutputComStatement context, EReference r) {
//		context.scopeForHierarchicRigthElement(ValueElementSpecificationScheme.COM_POINT)
//	}
//
//	def scope_NamedElement(ExpressionAsComPoint context, EReference r) {
//		context.scopeForHierarchicLeftElement(ValueElementSpecificationScheme.COM_POINT)
//	}


	def scope_Port(InputComStatement context, EReference r) {
		context.scopeForComPoint(ChannelDirection.INPUT)
	}

	def scope_InputComStatement_port(InputComStatement context, EReference r) {
		context.scopeForComPoint(ChannelDirection.INPUT)
	}


	def scope_Port(OutputComStatement context, EReference r) {
		context.scopeForComPoint(ChannelDirection.OUTPUT)
	}

	def scope_OutputComStatement_port(OutputComStatement context, EReference r) {
		context.scopeForComPoint(ChannelDirection.OUTPUT)
	}



	def scopeForComPoint(AbstractComStatement context, ChannelDirection direction) {
		var thisMachine = EcoreUtil2.getContainerOfType(context, typeof(Machine))

		while( (thisMachine != null) && thisMachine.port.empty ) {
			thisMachine = EcoreUtil2.getContainerOfType(
				thisMachine.eContainer, typeof(Machine) )
		}

		var parentScope = IScope::NULLSCOPE
		if( thisMachine != null ) {
			parentScope =
				Scopes::scopeFor(thisMachine.property.selectTypedElement(
						PrimitiveInstanceKind.COM_POINT),
					Scopes::scopeFor(thisMachine.signal.selectSignal(direction),
						Scopes::scopeFor(thisMachine.port.selectPort(direction),
							parentScope)))
		}

		parentScope
	}

	def Iterable< Port > selectPort(
		Iterable< Port > elements, ChannelDirection dir) {

		if( dir == ChannelDirection.INOUT ) {
			elements
		}
		else {
			elements.filter[ (direction == dir) ||
				(direction == ChannelDirection.INOUT) ]
		}
	}

	def Iterable< Signal > selectSignal(
		Iterable< Signal > elements, ChannelDirection dir) {

		if( dir == ChannelDirection.INOUT ) {
			elements
		}
		else {
			elements.filter[ (direction == dir) ||
				(direction == ChannelDirection.INOUT) ]
		}
	}


	def Iterable< PropertyDefinition > selectTypedComPoint(
		Iterable< PropertyDefinition > elements) {

		val typedComPointPredicate = [ PropertyDefinition property |
			(property instanceof Variable) &&
			(property.type instanceof PrimitiveInstanceType) && (
					((property.type as PrimitiveInstanceType).expected ==
						PrimitiveInstanceKind.PORT) ||
					((property.type as PrimitiveInstanceType).expected ==
						PrimitiveInstanceKind.SIGNAL) ||
					((property.type as PrimitiveInstanceType).expected ==
						PrimitiveInstanceKind.COM_POINT) ) ]

		elements.filter( typedComPointPredicate )
	}


	////////////////////////////////////////////////////////////////////////////
	// ComStatement --> Channel
	////////////////////////////////////////////////////////////////////////////

	def scope_AbstractComStatement_channel(AbstractComStatement context, EReference r) {
		context.scopeForChannel(context.port, ChannelDirection.INPUT)
	}

	def scope_InputComStatement_channel(InputComStatement context, EReference r) {
		context.scopeForChannel(context.port, ChannelDirection.INPUT)
	}

	def scope_OutputComStatement_channel(OutputComStatement context, EReference r) {
		context.scopeForChannel(context.port, ChannelDirection.OUTPUT)
	}


	def scopeForChannel(AbstractComStatement context,
		NamedElement comElement, ChannelDirection direction) {
		var thisMachine = EcoreUtil2.getContainerOfType(context, typeof(Machine))

		while( (thisMachine != null) && thisMachine.port.empty ) {
			thisMachine = EcoreUtil2.getContainerOfType(
				thisMachine.eContainer, typeof(Machine) )
		}

		var parentScope = IScope::NULLSCOPE
		if( thisMachine != null ) {
			parentScope = Scopes::scopeFor(
				thisMachine.channel.selectChannel(comElement, direction),
				parentScope)
		}

		parentScope
	}

	def Iterable< Channel > selectChannel(
		Iterable< Channel > elements, NamedElement comElement, ChannelDirection dir) {

		elements.filter[ ((direction == dir) ||
			(direction == ChannelDirection.INOUT)) && port.contains(comElement) ]
	}



	////////////////////////////////////////////////////////////////////////////
	// Transition --> Vertex
	////////////////////////////////////////////////////////////////////////////

	def scope_Transition_target(Transition context, EReference r) {
		val parentScope = IScope::NULLSCOPE

		val region = EcoreUtil2.getContainerOfType(context, typeof(Region))

		var thisMachine = EcoreUtil2.getContainerOfType(region, typeof(Machine))

		Scopes::scopeFor(thisMachine.property.selectTypedElement(
				PrimitiveInstanceKind.VERTEX),
			Scopes::scopeFor(region.vertex, parentScope))
	}


	////////////////////////////////////////////////////////////////////////////
	// InstanceMachine --> SlotProperty
	////////////////////////////////////////////////////////////////////////////

	def scope_SlotParameter_xliaProperty(SlotProperty context, EReference r) {
		val model = ( context.eContainer as InstanceMachine ).model

		Scopes::scopeFor(model.property.selectNonFinalNorConst,
			Scopes::scopeFor(model.buffer, IScope::NULLSCOPE))
	}

	def scope_SlotProperty_xliaProperty(SlotProperty context, EReference r) {
		val model = ( context.eContainer as InstanceMachine ).model

		Scopes::scopeFor(model.property.selectNonFinalNorConst,
			Scopes::scopeFor(model.buffer, IScope::NULLSCOPE))
	}

	def scope_PropertyDefinition(InstanceMachine context, EReference r) {
		val parentScope = IScope::NULLSCOPE

		val model = context.model

		Scopes::scopeFor(model.property.selectNonFinalNorConst,
			Scopes::scopeFor(model.buffer, parentScope))
	}


	////////////////////////////////////////////////////////////////////////////
	// InstanceMachine --> Model
	////////////////////////////////////////////////////////////////////////////

	def scope_InstanceMachine_model(InstanceMachine context, EReference r) {
		context.scopeForHierarchicLeftElement(ValueElementSpecificationScheme.MODEL)
	}

	def scope_DynamicInstanceSpecification_model(InstanceMachine context, EReference r) {
		context.scopeForHierarchicLeftElement(ValueElementSpecificationScheme.MODEL)
	}

	def scope_Machine(InstanceMachine context, EReference r) {
		context.scopeForHierarchicLeftElement(ValueElementSpecificationScheme.MODEL)
	}


	////////////////////////////////////////////////////////////////////////////
	// LiteralReferenceElement --> NamedElement
	////////////////////////////////////////////////////////////////////////////

	def scope_NamedElement(LiteralReferenceElement context, EReference r) {
		var container = context.eContainer

		for( ; container != null ; container = container.eContainer ) {
			switch( container ) {
				ValueElementSpecification :
						return container.scopeForThis(context)

				LeftHandSideExpression : return container.scopeForThis(context)

				TupleExpression : return container.scopeForThis(context)

				InvokeExpression : return container.scopeForThis(context)

				InputComStatement : return container.scopeForThis(context)
				OutputComStatement: return container.scopeForThis(context)

				ActivityStatement : return container.scopeForThis(context)

				Transition : return container.scopeForThis(context)

				ComPoint: return container.scopeForThis(context)

				Routine : return container.scopeForAnyElement(context)

				Machine : return container.scopeForAnyElement(context)

				PrimitiveInstanceType :
						return container.scopeForAnyModelElement(context)

				DataTypeReference : return container.scopeForThis(context)
			}
		}

		IScope.NULLSCOPE
	}


	////////////////////////////////////////////////////////////////////////////
	// ValueElementSpecification --> NamedElement
	////////////////////////////////////////////////////////////////////////////

	def scope_NamedElement(ValueElementSpecification context, EReference r) {
		var parentScope = IScope::NULLSCOPE

		val type = context.target.typeFor

		if( (type == null) || type.isPrimitive ) {
			return parentScope
		}

		if( context.expected == ValueElementSpecificationScheme.ANY ) {
			val container = context.eContainer

			switch( container ) {
				ComPoint:
					context.expected = ValueElementSpecificationScheme.COM_POINT

				InputComStatement :
					context.expected = ValueElementSpecificationScheme.COM_POINT

				OutputComStatement:
					context.expected = ValueElementSpecificationScheme.COM_POINT
			}
		}

		if( type instanceof Machine ) {
			if( context.expected == ValueElementSpecificationScheme.COM_POINT ) {
				val container = context.eContainer

				switch( container ) {
					ComPoint: scopeForSelfMachineComPoint(type,
						(context.eContainer as ComPoint).direction)

					InputComStatement : Scopes::scopeFor(
						type.selectLeftElements(context), parentScope)

					OutputComStatement: Scopes::scopeFor(
						type.selectRigthElements(context), parentScope)
				}
			}
			else if( (context.target instanceof LiteralReferenceExpression) &&
					(! (context.target instanceof LiteralReferenceElement)) ) {
				Scopes::scopeFor(
					type.selectLeftElements(context), parentScope)
			}
			else if( type.isAncestorOf(context) ) {
				for( block : type.blockHierarchy.reverseView ) {
					parentScope = Scopes::scopeFor(
						block.selectLeftElements(context), parentScope)
				}

				Scopes::scopeFor(
					type.selectLeftElements(context), parentScope)
			}
			else {
				for( block : type.blockHierarchy.reverseView ) {
					parentScope = Scopes::scopeFor(
						block.selectPublicLeftElements(context), parentScope)
				}

				Scopes::scopeFor(
					type.selectPublicLeftElements(context), parentScope)
			}
		}
		else if( type instanceof DataType ) {
			Scopes::scopeFor(type.selectElements(context), parentScope)
		}
		else {
			parentScope
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// Tools / Utils
	////////////////////////////////////////////////////////////////////////////

	def blockHierarchy(Machine block) {
		val hierarchy = <Machine>newArrayList()

		var current = EcoreUtil2.getContainerOfType(
				block.eContainer, typeof(Machine))

		while( current != null ) {
			hierarchy.add( current )

			current = EcoreUtil2.getContainerOfType(
				current.eContainer, typeof(Machine))
		}

		hierarchy
	}


	def selectLeftElements(Machine machine, ValueElementSpecification ves) {
		if( ves.kind == ValueElementSpecificationKind.PARAMETER ) {
			machine.routine + machine.procedure
		}
		else {
			selectLeftElements(machine, ves.expected)
		}
	}

	def selectPublicLeftElements(Machine machine, ValueElementSpecification ves) {
		if( ves.kind == ValueElementSpecificationKind.PARAMETER ) {
			machine.routine + machine.procedure
		}
		else {
			selectPublicLeftElements(machine, ves.expected)
		}
	}


	def selectRigthElements(Machine machine, ValueElementSpecification ves) {
		if( ves.kind == ValueElementSpecificationKind.PARAMETER ) {
			machine.routine + machine.procedure
		}
		else {
			selectLeftElements(machine, ves.expected)
		}
	}

	def Iterable< ? extends NamedElement> selectElements(
		DataType type, ValueElementSpecification ves) {
		if( ves.kind != ValueElementSpecificationKind.PARAMETER ) {
			switch( type ) {
				EnumerationType: type.literal

				DataStructuredType: type.property

				DataSupportedType : type.support.selectElements(ves)

				DataTypeReference : {
					if( type.typeref != null ) {
						type.typeref.selectElements(ves)
					}
					else if( type.support != null ) {
						type.support.selectElements(ves)
					}
				}
			}
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// select MACHINE Elements
	////////////////////////////////////////////////////////////////////////////

	def selectLeftElements(Machine block, ValueElementSpecificationScheme expected) {
		switch( expected ) {
			case ANY : block.property +
				block.channel + block.buffer + block.port + block.signal +
				block.machine + block.instance + block.behavior +
				block.routine + block.procedure + block.typedef

			case VARIABLE : block.property

			case PORT     : block.port
			case SIGNAL   : block.signal
			case MESSAGE  : block.port + block.signal
			case COM_POINT: block.port + block.signal

			case INSTANCE : block.instance
			case MACHINE  : block.machine + block.instance + block.behavior
			case MODEL    : block.machine + block.behavior

			case BUFFER   : block.buffer

			case CHANNEL  : block.channel

			case VERTEX   : {
			}

			case PROCEDURE: block.procedure
			case ROUTINE  : block.routine
		}
	}

	def selectPublicLeftElements(
		Machine block, ValueElementSpecificationScheme expected) {
		selectLeftElements(block, expected).selectPublic
	}

	def selectNonPublicLeftElements(
		Machine block, ValueElementSpecificationScheme expected) {
		selectLeftElements(block, expected).selectNonPublic
	}


	def selectRigthElements(
		Machine block, ValueElementSpecificationScheme expected) {
		switch( expected ) {
			case ANY : block.property + block.enumLiterals +
				block.channel + block.buffer + block.port + block.signal +
				block.machine + block.instance + block.behavior +
				block.routine + block.procedure + block.typedef

			case VARIABLE : block.property

			case PORT     : block.port +
							block.property.selectProperty(expected)

			case SIGNAL   : block.signal +
							block.property.selectProperty(expected)

			case MESSAGE  : block.port + block.signal +
							block.property.selectProperty(expected)

			case COM_POINT: block.port + block.signal +
							block.property.selectProperty(expected)

			case INSTANCE : block.instance +
							block.property.selectProperty(expected)

			case MACHINE  : block.machine + block.instance + block.behavior +
							block.property.selectProperty(expected)

			case MODEL    : block.machine + block.behavior

			case BUFFER   : block.buffer +
							block.property.selectProperty(expected)

			case CHANNEL  : block.channel +
							block.property.selectProperty(expected)

			case VERTEX   : block.property.selectProperty(expected)

			case PROCEDURE: block.procedure
			case ROUTINE  : block.routine
		}
	}

	def selectPublicRigthElements(
		Machine block, ValueElementSpecificationScheme expected) {
		selectRigthElements(block, expected).selectPublic
	}

	def selectNonPublicRigthElements(
		Machine block, ValueElementSpecificationScheme expected) {
		selectRigthElements(block, expected).selectNonPublic
	}



	def enumLiterals(Machine machine) {
		val literals = <EnumerationLiteral>newArrayList()

		for( it : machine.typedef ) {
			val type = it.typeSpecifier
			switch( type ) {
				EnumerationType: literals += type.literal
			}
		}

		literals
	}


	def selectStructuredElements(
		Machine block, ValueElementSpecificationScheme expected) {
		val roots = <NamedElement>newArrayList()

		switch( expected ) {
			case ANY : {
				for( it : block.property ) {
					if( it.type.isStructured ) {
						roots += it
					}
				}
				for( it : block.typedef ) {
					if( it instanceof EnumerationType ) {
						roots += it
					}
				}
				roots += block.machine + block.instance + block.behavior
			}

			case VARIABLE : {
				for( it : block.property ) {
					if( it.type.isStructured ) {
						roots += it
					}
				}
			}

			case INSTANCE : roots += block.instance +
							block.property.selectProperty(expected)

			case MACHINE  : roots += block.machine + block.instance +
							block.behavior +
							block.property.selectProperty(expected)

			case MODEL    : roots += block.machine + block.behavior

			default: {
			}
		}

		roots
	}


	////////////////////////////////////////////////////////////////////////////
	// select BEHAVIOR Elements
	////////////////////////////////////////////////////////////////////////////

	def selectLeftElements(Behavior block, ValueElementSpecificationScheme expected) {
//		val elements = (block as Machine).selectLeftElements(expected)
//
//		switch( expected ) {
//			case ANY : elements + block.parameter
//
//			case VARIABLE : elements + block.parameter
//
//			default: elements
//		}

		switch( expected ) {
			case ANY : block.property + block.parameter +
				block.channel + block.buffer + block.port + block.signal +
				block.machine + block.instance + block.behavior +
				block.routine + block.procedure + block.typedef

			case VARIABLE : block.property + block.parameter

			case PORT     : block.port
			case SIGNAL   : block.signal
			case MESSAGE  : block.port + block.signal
			case COM_POINT: block.port + block.signal

			case INSTANCE : block.instance
			case MACHINE  : block.machine + block.instance + block.behavior
			case MODEL    : block.machine + block.behavior

			case BUFFER   : block.buffer

			case CHANNEL  : block.channel

			case VERTEX   : {

			}

			case PROCEDURE: block.procedure
			case ROUTINE  : block.routine
		}
	}

	def selectRigthElements(Behavior block, ValueElementSpecificationScheme expected) {
		switch( expected ) {
			case ANY : block.property + block.parameter + block.enumLiterals +
				block.channel + block.buffer + block.port + block.signal +
				block.machine + block.instance + block.behavior +
				block.routine + block.procedure + block.typedef

			case VARIABLE : block.property + block.parameter

			case PORT     : block.port +
							block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case SIGNAL   : block.signal +
							block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case MESSAGE  : block.port + block.signal +
							block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case COM_POINT: block.port + block.signal +
							block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case INSTANCE : block.instance +
							block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case MACHINE  : block.machine  + block.instance + block.behavior +
							block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case MODEL    : block.machine + block.behavior

			case BUFFER   : block.buffer +
							block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case CHANNEL  : block.channel +
							block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case VERTEX   : block.property.selectProperty(expected) +
							block.parameter.selectProperty(expected)

			case PROCEDURE: block.procedure
			case ROUTINE  : block.routine
		}
	}


	def selectProperty(Iterable< ? extends PropertyDefinition> properties,
		ValueElementSpecificationScheme expected) {

		switch( expected ) {
			case ANY : properties

			case VARIABLE: properties

			default: {
				val selection = <PropertyDefinition>newArrayList()

				for( it : properties ) {
					val type = it.type.typeSpecifier
					switch( type ) {
						PrimitiveInstanceType : {
							switch( expected ) {
								case PORT: {
									if( type.expected ==
										PrimitiveInstanceKind.PORT)
									{ selection += it }
								}
								case SIGNAL: {
									if( type.expected ==
										PrimitiveInstanceKind.SIGNAL)
									{ selection += it }
								}
								case MESSAGE: {
									if( type.expected ==
										PrimitiveInstanceKind.MESSAGE)
									{ selection += it }
								}
								case COM_POINT: {
									if( (type.expected ==
											PrimitiveInstanceKind.PORT) ||
										(type.expected ==
											PrimitiveInstanceKind.SIGNAL) ||
										(type.expected ==
											PrimitiveInstanceKind.COM_POINT) )
									{ selection += it }
								}
								case INSTANCE: {
									if( type.expected ==
										PrimitiveInstanceKind.MACHINE)
									{ selection += it }
								}
								case MACHINE: {
									if( type.expected ==
										PrimitiveInstanceKind.MACHINE)
									{ selection += it }
								}

								case BUFFER: {
									if( type.expected ==
										PrimitiveInstanceKind.BUFFER)
									{ selection += it }
								}
								case CHANNEL: {
									if( type.expected ==
										PrimitiveInstanceKind.CHANNEL)
									{ selection += it }
								}

								case VERTEX: {
									if( type.expected ==
										PrimitiveInstanceKind.VERTEX)
									{ selection += it }
								}

								default: {
								}
							}
						}
					}
				}

				selection
			}
		}
	}



	def selectStructuredElements(
		Behavior block, ValueElementSpecificationScheme expected) {
		val roots = <NamedElement>newArrayList()

		switch( expected ) {
			case ANY : {
				for( it : block.property ) {
					if( it.type.isStructured ) {
						roots += it
					}
				}
				for( it : block.parameter ) {
					if( it.type.isStructured ) {
						roots += it
					}
				}
				for( it : block.typedef ) {
					if( it instanceof EnumerationType ) {
						roots += it
					}
				}

				roots += block.machine + block.instance + block.behavior
			}

			case VARIABLE : {
				for( it : block.property ) {
					if( it.type.isStructured ) {
						roots += it
					}
				}
				for( it : block.parameter ) {
					if( it.type.isStructured ) {
						roots += it
					}
				}
			}

			case INSTANCE : roots += block.instance + block.property

			case MACHINE  : roots += block.machine + block.instance +
							block.behavior

			case MODEL    : roots += block.machine + block.behavior

			default: {
			}
		}

		roots
	}


	////////////////////////////////////////////////////////////////////////////
	// select ROUTINE Elements
	////////////////////////////////////////////////////////////////////////////

	def selectLeftElements(
		Routine routine, ValueElementSpecificationScheme expected) {
		switch( expected ) {
			case ANY     : {
				var lvalue = routine.parameter
				if( routine.domain != null ) {
					lvalue += routine.domain.parameter
				}
				if( routine.codomain != null ) {
					lvalue += routine.codomain.parameter
				}

				lvalue
			}

			case VARIABLE: {
				var lvalue = routine.parameter
				if( routine.domain != null ) {
					lvalue += routine.domain.parameter
				}
				if( routine.codomain != null ) {
					lvalue += routine.codomain.parameter
				}

				lvalue
			}

			default: null
		}
	}

	def selectRigthElements(
		Routine routine, ValueElementSpecificationScheme expected) {
		var properties = routine.parameter.selectProperty(expected)

		if( routine.domain != null ) {
			properties = properties +
				routine.domain.parameter.selectProperty(expected)
		}
		if( routine.codomain != null ) {
			properties = properties +
				routine.codomain.parameter.selectProperty(expected)
		}

		properties
	}

	def selectStructuredElements(
		Routine routine, ValueElementSpecificationScheme expected) {
		val roots = <PropertyDefinition>newArrayList()

		for( it : routine.parameter ) {
			if( it.type.isStructured ) {
				roots += it
			}
		}

		if( routine.domain != null ) {
			for( it : routine.domain.parameter ) {
				if( it.type.isStructured ) {
					roots += it
				}
			}
		}
		if( routine.codomain != null ) {
			for( it : routine.codomain.parameter ) {
				if( it.type.isStructured ) {
					roots += it
				}
			}
		}

		roots
	}


	////////////////////////////////////////////////////////////////////////////
	// ComPoint --> NamedElement
	////////////////////////////////////////////////////////////////////////////

	def scope_NamedElement(ComPoint context, EReference r) {
		if( ! context.points.empty ) {
			val type = context.points.get(0).typeFor

			if( type instanceof Machine ) {
				return scopeForSelfMachineComPoint(type, context.direction)
			}
		}

		val thisMachine = EcoreUtil2.getContainerOfType(context, typeof(Machine))

			scopeForSelfMachineInstance(thisMachine,
			scopeForSelfMachineComPoint(thisMachine, context.direction))
	}


	def scopeForSelfMachineInstance(Machine thisMachine, IScope outer) {
		val selfMachine =
			if( (thisMachine.name == null) &&
				(thisMachine.eContainer instanceof Machine) ) {
				thisMachine.eContainer as Machine
			}
			else {
				thisMachine
			}

		Scopes::scopeFor(selfMachine.instance,
			Scopes::scopeFor(selfMachine.machine,
				Scopes::scopeFor(selfMachine.behavior,
					outer)))
	}


	def scopeForSelfMachineComPoint(
		Machine thisMachine, ChannelDirection direction) {
		var parentScope = Scopes::scopeFor(
			thisMachine.port.selectPort(direction),
			Scopes::scopeFor(
				thisMachine.signal.selectSignal(direction),
				IScope::NULLSCOPE))

		if( (thisMachine.name == null) &&
			(thisMachine.eContainer instanceof Machine) ) {
			val selfMachine = thisMachine.eContainer as Machine

			if( selfMachine.main == thisMachine ) {
				parentScope = Scopes::scopeFor(
					selfMachine.port.selectPort(direction),
					Scopes::scopeFor(
						selfMachine.signal.selectSignal(direction),
						parentScope))
			}
		}

		parentScope
	}

	////////////////////////////////////////////////////////////////////////////
	// scopeForThis
	////////////////////////////////////////////////////////////////////////////

	def scopeForThis(
		LeftHandSideExpression container, LiteralReferenceElement context) {
		for( var EObject it = container ; it != null; it = it.eContainer()) {
			switch( it ) {
				Routine: return it.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.VARIABLE)

				Machine: return it.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.VARIABLE)
			}
		}

		IScope::NULLSCOPE
	}


	def scopeForThis(
		InputComStatement container, LiteralReferenceElement context) {
		switch( context ) {
			case container.port:
				container.scopeForHierarchicRigthElement(
					ValueElementSpecificationScheme.COM_POINT)

			case container.route :
				container.scopeForHierarchicRigthElement(
					ValueElementSpecificationScheme.CHANNEL)

			case container.target:
				container.scopeForHierarchicRigthElement(
					ValueElementSpecificationScheme.MACHINE)

			default:
				container.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.VARIABLE)
		}
	}


	def scopeForThis(
		OutputComStatement container, LiteralReferenceElement context) {
		switch( context ) {
			case container.port:
				container.scopeForHierarchicRigthElement(
					ValueElementSpecificationScheme.COM_POINT)

			case container.route :
				container.scopeForHierarchicRigthElement(
					ValueElementSpecificationScheme.CHANNEL)

			case container.target:
				container.scopeForHierarchicRigthElement(
					ValueElementSpecificationScheme.MACHINE)

			default:
				container.scopeForHierarchicRigthElement(
					ValueElementSpecificationScheme.ANY)
		}
	}


	def scopeForThis(
		ActivityStatement container, LiteralReferenceElement context) {
		if( context == container.machine ) {
			container.scopeForHierarchicLeftElement(
				ValueElementSpecificationScheme.MACHINE)
		}
		else {
			container.scopeForHierarchicLeftElement(
				ValueElementSpecificationScheme.ANY)
		}
	}


	def scopeForThis(Transition container, LiteralReferenceElement context) {
		val thisRegion = EcoreUtil2.getContainerOfType(container, typeof(Region))

		if( context == container.target ) {
			thisRegion.scopeForRigthElement(
				ValueElementSpecificationScheme.VERTEX)
		}
		else {
			val thisMachine =
				EcoreUtil2.getContainerOfType(thisRegion, typeof(Machine))

			thisMachine.scopeForHierarchicRigthElement(
				ValueElementSpecificationScheme.ANY)
		}
	}

	def scopeForThis(ComPoint container, LiteralReferenceElement context) {
		val thisMachine = EcoreUtil2.getContainerOfType(container, typeof(Machine))

		thisMachine.scopeForHierarchicLeftElement(
			ValueElementSpecificationScheme.COM_POINT)
	}


	def scopeForThis(DataTypeReference thisType, LiteralReferenceElement context) {
		val thisMachine = EcoreUtil2.getContainerOfType(thisType, typeof(Machine))

		if( thisType.multiplicity == context ) {
			thisMachine.scopeForHierarchicRigthElement(
				ValueElementSpecificationScheme.ANY)
		}
		else {
			thisMachine.scopeForHierarchicRigthElement(
				ValueElementSpecificationScheme.ANY)
		}
	}


	def scopeForThis(
		ValueElementSpecification thisElement, LiteralReferenceElement context) {
		for( var EObject it = context ; it != null; it = it.eContainer()) {
			switch( it ) {
				Routine: return it.scopeForHierarchicStructuredElement(
					ValueElementSpecificationScheme.ANY)

				Machine: return it.scopeForHierarchicStructuredElement(
					ValueElementSpecificationScheme.ANY)
			}
		}

		IScope::NULLSCOPE
	}

	def scopeForThis(TupleExpression thisTuple, LiteralReferenceElement context) {
		thisTuple.scopeForHierarchicRigthElement(ValueElementSpecificationScheme.ANY)
	}


	def scopeForThis(InvokeExpression thisInvoke, LiteralReferenceElement context) {
		if( (context.eContainer == thisInvoke) &&
			(context.kind == ValueElementSpecificationKind.PARAMETER) ) {
				if( thisInvoke.callProcedure ) {
					thisInvoke.scopeForHierarchicRigthElement(
						ValueElementSpecificationScheme.PROCEDURE)
				}
				else {
					thisInvoke.scopeForHierarchicRigthElement(
						ValueElementSpecificationScheme.ROUTINE)
				}
		}
		else {
			thisInvoke.scopeForHierarchicRigthElement(
				ValueElementSpecificationScheme.ANY)
		}
	}

//	def scopeForThis(Expression container, LiteralReferenceElement context) {
//		container.scopeForHierarchicRigthElement(ValueElementSpecificationScheme.ANY)
//	}


	////////////////////////////////////////////////////////////////////////////
	// scopeForAnyElement
	////////////////////////////////////////////////////////////////////////////

	def scopeForAnyElement(Routine thisRoutine, LiteralReferenceElement context) {
		thisRoutine.scopeForHierarchicRigthElement(
			ValueElementSpecificationScheme.ANY)
	}

	def scopeForAnyElement(Machine thisBlock, LiteralReferenceElement context) {
		thisBlock.scopeForHierarchicRigthElement(
			ValueElementSpecificationScheme.ANY)
	}


	def scopeForAnyModelElement(
		PrimitiveInstanceType thisType, LiteralReferenceElement context) {
		val thisMachine = EcoreUtil2.getContainerOfType(thisType, typeof(Machine))

		switch( thisType.expected ) {
			case PORT: {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.PORT)
			}
			case SIGNAL: {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.SIGNAL)
			}
			case MESSAGE: {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.MESSAGE)
			}
			case COM_POINT: {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.COM_POINT)
			}

			case MACHINE: {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.MODEL)
			}

			case BUFFER: {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.BUFFER)
			}
			case CHANNEL: {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.CHANNEL)
			}

			case VERTEX   : {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.VERTEX)
			}
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// scopeForAnyElement
	////////////////////////////////////////////////////////////////////////////

	def scopeForLeftElement(
		Region thisRegion, ValueElementSpecificationScheme expected) {
		if( expected == ValueElementSpecificationScheme.VERTEX ) {
			Scopes::scopeFor(thisRegion.vertex, IScope::NULLSCOPE)
		}

		IScope::NULLSCOPE
	}

	def scopeForRigthElement(
		Region thisRegion, ValueElementSpecificationScheme expected) {
		if( expected == ValueElementSpecificationScheme.VERTEX ) {
			val thisStatemachine =
				EcoreUtil2.getContainerOfType(thisRegion, typeof(Statemachine))

			Scopes::scopeFor(thisRegion.vertex,
				Scopes::scopeFor(thisStatemachine.selectRigthElements(expected),
					IScope::NULLSCOPE))
		}

		IScope::NULLSCOPE
	}


	////////////////////////////////////////////////////////////////////////////
	// scopeForLeftElement / scopeForRigthElement
	////////////////////////////////////////////////////////////////////////////

	def scopeForLeftElement(
		Machine thisMachine, ValueElementSpecificationScheme expected) {
		var parentScope = IScope::NULLSCOPE

		if( (thisMachine.name == null) &&
			(thisMachine.eContainer instanceof Machine) ) {
			val selfMachine = thisMachine.eContainer as Machine

			if( selfMachine.main == thisMachine ) {
				parentScope = Scopes::scopeFor(
					selfMachine.selectLeftElements(expected), parentScope)
			}
		}

		Scopes::scopeFor(thisMachine.selectLeftElements(expected), parentScope)
	}

	def scopeForRigthElement(
		Machine thisMachine, ValueElementSpecificationScheme expected) {
		var parentScope = IScope::NULLSCOPE

		if( (thisMachine.name == null) &&
			(thisMachine.eContainer instanceof Machine) ) {
			val selfMachine = thisMachine.eContainer as Machine

			if( selfMachine.main == thisMachine ) {
				parentScope = Scopes::scopeFor(
					selfMachine.selectRigthElements(expected), parentScope)
			}
		}

		Scopes::scopeFor(thisMachine.selectRigthElements(expected), parentScope)
	}


	def scopeForHierarchicLeftElement(
		Machine thisMachine, ValueElementSpecificationScheme expected) {
		var parentScope = IScope::NULLSCOPE

		for( block : thisMachine.blockHierarchy.reverseView ) {
			switch( block  ) {
				Behavior: parentScope = Scopes::scopeFor(
					block.selectLeftElements(expected), parentScope)

				default: parentScope = Scopes::scopeFor(
					block.selectLeftElements(expected), parentScope)
			}
		}

		switch( thisMachine  ) {
			Behavior: Scopes::scopeFor(
				thisMachine.selectLeftElements(expected), parentScope)

			default: Scopes::scopeFor(
				thisMachine.selectLeftElements(expected), parentScope)
		}
	}

	////////////////////////////////////////////////////////////////////////////
	// scopeForHierarchicLeftElement / scopeForHierarchicRigthElement
	////////////////////////////////////////////////////////////////////////////

	def scopeForHierarchicRigthElement(
		Machine thisMachine, ValueElementSpecificationScheme expected) {
		var parentScope = IScope::NULLSCOPE

		for( block : thisMachine.blockHierarchy.reverseView ) {
			switch( block  ) {
				Behavior: parentScope = Scopes::scopeFor(
					block.selectRigthElements(expected), parentScope)

				default: parentScope = Scopes::scopeFor(
					block.selectRigthElements(expected), parentScope)
			}
		}

		switch( thisMachine  ) {
			Behavior: Scopes::scopeFor(
				thisMachine.selectRigthElements(expected), parentScope)

			default: Scopes::scopeFor(
				thisMachine.selectRigthElements(expected), parentScope)
		}
	}


	def scopeForHierarchicStructuredElement(
		Machine thisMachine, ValueElementSpecificationScheme expected) {
		var parentScope = IScope::NULLSCOPE

		for( block : thisMachine.blockHierarchy.reverseView ) {
			switch( block  ) {
				Behavior: parentScope = Scopes::scopeFor(
					block.selectStructuredElements(expected), parentScope)

				default: parentScope = Scopes::scopeFor(
					block.selectStructuredElements(expected), parentScope)
			}
		}

		switch( thisMachine  ) {
			Behavior: Scopes::scopeFor(
				thisMachine.selectStructuredElements(expected), parentScope)

			default: Scopes::scopeFor(
				thisMachine.selectStructuredElements(expected), parentScope)
		}
	}


	def scopeForHierarchicStructuredElement(
		Routine thisRoutine, ValueElementSpecificationScheme expected) {
		val thisMachine =
			EcoreUtil2.getContainerOfType(thisRoutine, typeof(Machine))

		Scopes::scopeFor(thisRoutine.selectStructuredElements(expected),
			scopeForHierarchicStructuredElement(thisMachine, expected))
	}



	def scopeForHierarchicLeftElement(
		Routine thisRoutine, ValueElementSpecificationScheme expected) {
		val thisMachine =
			EcoreUtil2.getContainerOfType(thisRoutine, typeof(Machine))

		Scopes::scopeFor(thisRoutine.selectLeftElements(expected),
			scopeForHierarchicLeftElement(thisMachine, expected))
	}

	def scopeForHierarchicRigthElement(
		Routine thisRoutine, ValueElementSpecificationScheme expected) {
		val thisMachine =
			EcoreUtil2.getContainerOfType(thisRoutine, typeof(Machine))

		Scopes::scopeFor(thisRoutine.selectRigthElements(expected),
			scopeForHierarchicRigthElement(thisMachine, expected))
	}



	def scopeForHierarchicLeftElement(
		EObject context, ValueElementSpecificationScheme expected) {
		for( var it = context ; it != null; it = it.eContainer() ) {
			switch( it ) {
				Routine: return it.scopeForHierarchicLeftElement(expected)

				Machine: return it.scopeForHierarchicLeftElement(expected)
			}
		}

		IScope::NULLSCOPE
	}

	def scopeForHierarchicRigthElement(
		EObject context, ValueElementSpecificationScheme expected) {
		for( var it = context ; it != null; it = it.eContainer() ) {
			switch( it ) {
				Routine: return it.scopeForHierarchicRigthElement(expected)

				Machine: return it.scopeForHierarchicRigthElement(expected)
			}
		}

		IScope::NULLSCOPE
	}


}
