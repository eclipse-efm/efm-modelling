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
import org.eclipse.efm.ecore.formalml.common.AbstractElement
import org.eclipse.efm.ecore.formalml.common.NamedElement
import org.eclipse.efm.ecore.formalml.common.TypedElement
import org.eclipse.efm.ecore.formalml.common.VisibilityKind
import org.eclipse.efm.ecore.formalml.datatype.DataStructuredType
import org.eclipse.efm.ecore.formalml.datatype.DataSupportedType
import org.eclipse.efm.ecore.formalml.datatype.DataType
import org.eclipse.efm.ecore.formalml.datatype.DataTypeReference
import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType
import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression
import org.eclipse.efm.ecore.formalml.expression.CastExpression
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage
import org.eclipse.efm.ecore.formalml.expression.InvokeExpression
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression
import org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression
import org.eclipse.efm.ecore.formalml.expression.TupleExpression
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior
import org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection
import org.eclipse.efm.ecore.formalml.infrastructure.ComPoint
import org.eclipse.efm.ecore.formalml.infrastructure.ConnectorEnd
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter
import org.eclipse.efm.ecore.formalml.infrastructure.Port
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition
import org.eclipse.efm.ecore.formalml.infrastructure.Route
import org.eclipse.efm.ecore.formalml.infrastructure.Routine
import org.eclipse.efm.ecore.formalml.infrastructure.Signal
import org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty
import org.eclipse.efm.ecore.formalml.infrastructure.Variable
import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem
import org.eclipse.efm.ecore.formalml.statemachine.Region
import org.eclipse.efm.ecore.formalml.statemachine.State
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine
import org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage
import org.eclipse.efm.ecore.formalml.statemachine.Transition
import org.eclipse.efm.ecore.formalml.statemachine.Vertex
import org.eclipse.efm.ecore.formalml.statement.AbstractComStatement
import org.eclipse.efm.ecore.formalml.statement.ActivityStatement
import org.eclipse.efm.ecore.formalml.statement.InputComStatement
import org.eclipse.efm.ecore.formalml.statement.InvokeStatement
import org.eclipse.efm.ecore.formalml.statement.OutputComStatement
import org.eclipse.efm.ecore.formalml.statement.Statement
import org.eclipse.efm.ecore.formalml.statement.StatementPackage
import org.eclipse.efm.formalml.xtext.typing.FormalMLTypeProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class FormalMLScopeProvider extends AbstractFormalMLScopeProvider {

	@Inject extension FormalMLTypeProvider
	
	
	////////////////////////////////////////////////////////////////////////////
	// GET SCOPE
	////////////////////////////////////////////////////////////////////////////
		
	////////////////////////////////////////////////////////////////////////////
	// get Trace
	//
	
//	@Inject
//	IQualifiedNameProvider nameProvider;
//	
//	def String str(IScope scope) {
//		var parentString = if( scope instanceof SimpleScope ) 
//			try {
//				scope.parent.str
//			} catch (Throwable t) {
//				t.getClass().getSimpleName() + " : " + t.getMessage();
//			}
//			else scope.toString
//			
//		var strScope =  "Context " + scope.class.simpleName + "[ "
//		
//		for( it : scope.getAllElements() ) {
//			strScope += nameProvider.getFullyQualifiedName(it.EObjectOrProxy) + " ; "
//		}
//		
//		strScope + "] -> " + parentString
//	}

	
//	def scopingTrace(EObject context, EReference reference)
//	{
//		var requiredScoping = "scope_" + reference.EContainingClass.name
//			 + "_" + reference.name + "(" + context.eContainer?.eClass.name
//			 + "." + context.eClass.name + " context, EReference reference)"
//			 
//		var container = context.eContainer
//		
//		var contextHierarchy = ""
//		for( ; ! (container instanceof NamedElement) ; container = container.eContainer ) {
//			contextHierarchy = "-->" + container.eClass.name + contextHierarchy
//		}
//		
//		container.eClass.name + " "
////				+ nameProvider.getFullyQualifiedName(container as NamedElement)
//				+ (container as NamedElement).name
//				+ " " + contextHierarchy
//				+ "\n\tScope" + "-->" + requiredScoping
//	}
//	
//	
//	int scopeID = 0
//	
//	////////////////////////////////////////////////////////////////////////////
//	// get Scope
//	//
//	override getScope(EObject context, EReference reference)
//	{
//		// For scope debugging
//		val traceID = "[" + (scopeID++) + "] "
//		val requiredScoping = scopingTrace(context, reference)			 
//		print(traceID)
//		println( requiredScoping )
//		
//		val scope = getScopeImpl(context, reference, requiredScoping)
//	
//		if( scope === IScope::NULLSCOPE )
//		{
////			println( requiredScoping )
//			print( traceID )
//			println( "Found: -> NULLSCOPE" )
//		}
//		else
//		{
////			println( requiredScoping )
//			print( traceID )
//			print( "Found -> " )
//			println( scope )
////			println( scope.str )
//		}
//		
//		scope
//	}
//	
//	def getScopeImpl(EObject context,
//			EReference reference, String requiredScoping)
	override getScope(EObject context, EReference reference)
	{
//		println( scopingTrace(context, reference) )
		
		switch( reference )
		{
			case ExpressionPackage.Literals.LITERAL_REFERENCE_ELEMENT__ELEMENT:
			{
				return scope_LiteralReferenceElement_element(
					context as LiteralReferenceElement, reference)
			}
			
			case ExpressionPackage.Literals.VALUE_ELEMENT_SPECIFICATION__ELEMENT:
			{
				return scope_ValueElementSpecification_element(
					context as ValueElementSpecification, reference)
			}
			
			case StatementPackage.Literals.ABSTRACT_COM_STATEMENT__PORT:
			{
				return scope_AbstractComStatement_port(
					context as AbstractComStatement, reference)
			}
			
			case StatementPackage.Literals.INVOKE_STATEMENT__INVOKABLE:
			{
				return scope_InvokeStatement_invokable(
					context as InvokeStatement, reference)
			}
			
			case StatemachinePackage.Literals.TRANSITION__TARGET:
			{
				return scope_Transition_target(context as Transition, reference)
			}
			
			case StatemachinePackage.Literals.TRANSITION__TARGET_EXPRESSION:
			{
				return scope_Transition_target(context as Transition, reference)
			}
			
			case DatatypePackage.Literals.DATA_TYPE_REFERENCE__TYPEREF:
			{
				return scope_DataTypeReference_typeref(
					context as DataTypeReference, reference)
			}
			
			case InfrastructurePackage.Literals.INSTANCE_MACHINE__MODEL:
			{
				return scope_InstanceMachine_model(
					context as InstanceMachine, reference)
			}
			
			
			case InfrastructurePackage.Literals.ROUTE__SIGNALS:
			{
				return scope_Route_signals(context as Route, reference)
			}
			
			case InfrastructurePackage.Literals.COM_POINT__MACHINE:
			{
				return scope_ComPoint_machine(context as ComPoint, reference)
			}
			
			case InfrastructurePackage.Literals.COM_POINT__PORT:
			{
				return scope_ComPoint_port(context as ComPoint, reference)
			}
			

			case InfrastructurePackage.Literals.SLOT_PROPERTY__XLIA_PROPERTY:
			{
				return scope_SlotProperty_xliaProperty(
					context as SlotProperty, reference
				)
			}
			
			case DatatypePackage.Literals.PRIMITIVE_INSTANCE_TYPE__MODEL:
			{
				return scope_PrimitiveInstanceType_model(
					context as PrimitiveInstanceType, reference)
			}
			
			case ExpressionPackage.Literals.CAST_EXPRESSION__DATATYPE:
			{
				return scope_CastExpression_datatype(
					context as CastExpression, reference)
			}
			
			default: {
//				print( "TO DO case: " )
//				println( requiredScoping )
//		
//				val scope = super.getScope(context, reference)
//				
//				print( "\tdefault::IScope: ")
//				println( scope )
//				
//				return scope

				return super.getScope(context, reference)
			}
		}
	}
	
	
	def scopeForElements(
		Iterable< ? extends NamedElement > elements, IScope parentScope)
	{
		if( elements.empty ) parentScope
		else Scopes::scopeFor(elements, parentScope)
	}
	
	
	////////////////////////////////////////////////////////////////////////////
	// scope_Transition_target
	////////////////////////////////////////////////////////////////////////////
	
	def scope_Transition_target(Transition context, EReference reference)
	{
		val parentScope = IScope::NULLSCOPE

		val region = EcoreUtil2.getContainerOfType(context, typeof(Region))

		var thisMachine = EcoreUtil2.getContainerOfType(region, typeof(Machine))

		scopeForElements(region.vertex,
			scopeForElements(thisMachine.variable.selectTypedElement(
				PrimitiveInstanceKind.VERTEX), parentScope))
	}
		
	////////////////////////////////////////////////////////////////////////////
	// scope_AbstractComStatement_port
	////////////////////////////////////////////////////////////////////////////
	
	def scope_AbstractComStatement_port(
		AbstractComStatement context, EReference reference)
	{
		switch( context ) {
			OutputComStatement: {
				return context.scopeForComElement(
					PrimitiveInstanceKind.COM_POINT, ChannelDirection.OUTPUT)
			}
			InputComStatement: {
				return context.scopeForComElement(
					PrimitiveInstanceKind.COM_POINT, ChannelDirection.INPUT)
			}
			default: {
				val parentScope = IScope::NULLSCOPE

				return parentScope
			}
		}
	}
	
	
	def Iterable< Port > selectPort(
		Iterable< Port > elements, ChannelDirection dir)
	{

		if( dir === ChannelDirection.INOUT ) {
			elements
		}
		else {
			elements.filter[ (direction === dir) ||
				(direction === ChannelDirection.INOUT) ]
		}
	}

	def Iterable< Signal > selectSignal(
		Iterable< Signal > elements, ChannelDirection dir)
	{
		if( dir === ChannelDirection.INOUT ) {
			elements
		}
		else {
			elements.filter[ (direction === dir) ||
				(direction === ChannelDirection.INOUT) ]
		}
	}
	
	def scopeForComElement(AbstractElement context,
		PrimitiveInstanceKind expected, ChannelDirection direction)
	{
		for( var EObject it = context ; it !== null; it = it.eContainer())
		{
			switch( it ) {
				Routine: return it.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.COM_POINT)

//				InstanceMachine:
//					return scopeForComElement(it.model, expected, direction)

				Machine: {
					var thisMachine =
						EcoreUtil2.getContainerOfType(context, typeof(Machine))
			
					while( (thisMachine !== null)
						 && thisMachine.port.empty && thisMachine.signal.empty)
					{
						thisMachine = EcoreUtil2.getContainerOfType(
							thisMachine.eContainer, typeof(Machine) )
					}
			
					var parentScope = IScope::NULLSCOPE
					if( thisMachine !== null ) {
						parentScope =
							scopeForElements(
								thisMachine.variable.selectTypedElement(expected),
								scopeForElements(
									thisMachine.signal.selectSignal(direction),
									scopeForElements(
										thisMachine.port.selectPort(direction),
										parentScope)))
					}
			
					return parentScope
				}
			}
		}

		IScope::NULLSCOPE
	}
	
	
	////////////////////////////////////////////////////////////////////////////
	// scope_LiteralReferenceElement_element
	////////////////////////////////////////////////////////////////////////////
	
	def scope_LiteralReferenceElement_element(
		LiteralReferenceElement context, EReference reference)
	{
		var parentScope = IScope::NULLSCOPE

		var container = context.eContainer

		for( ; container !== null ; container = container.eContainer )
		{
			switch( container )
			{
//				ValueElementSpecification : 
//						return container.scopeForThis(context)

				LeftHandSideExpression : return container.scopeForThis(context)

				AssignmentExpression : return container.scopeForThis(context)

				TupleExpression : return container.scopeForThis(context)
				
				QuantifiedLogicalExpression : return container.scopeForThis(context)

				InvokeExpression : return container.scopeForThis(context)

				InputComStatement : return container.scopeForThis(context)
				OutputComStatement: return container.scopeForThis(context)

				ActivityStatement : return container.scopeForThis(context)

				Statement : return container.scopeForThis(context)

				Transition : return container.scopeForThis(context)

				ComPoint: return container.scopeForThis(context)

				ComProtocol: return container.scopeForThis(context)

				Routine : return container.scopeForAnyElement(context)

				Machine : return container.scopeForAnyElement(context)

				PrimitiveInstanceType :
						return container.scopeForAnyModelElement(context)

				DataTypeReference : return container.scopeForThis(context)
			}
		}
		
		parentScope
	}
		
	
	////////////////////////////////////////////////////////////////////////////
	// scope_ValueElementSpecification_element
	////////////////////////////////////////////////////////////////////////////
	
	def NamedElement parentOf(ValueElementSpecification context) {
		val parent = context.parent
		
		if( parent === null ) {
			for( var container = context.eContainer ; container !== null ; )
			{
				switch( container ) {
					Vertex : return container
					
					XliaSystem  : return container
					Statemachine: return container
	
					Behavior: return( container.eContainer as NamedElement )
	
					Machine : return container
	
					default : {
						container = container.eContainer
					}
				}
			}
			return null
		}
		
		switch( parent ) {
			LiteralReferenceElement: {
				val element = parent.element
				switch( element ) {
					PropertyDefinition : {
						switch( parent.kind ) {
							case INDEX:
								return( element.type.typeOfCollectionElement )
							
							case PARAMETER: return element.type
							
							case FIELD: return element.type
							
							default: return element.type
						}
					}
					
					EnumerationType : return element

					InstanceMachine : return element.model

					Vertex : return element

					XliaSystem  : return element
					Statemachine: return element
					
					Behavior: return( element.eContainer as NamedElement )

					Machine : return element

					default : return null
				}
			}

			ValueElementSpecification : {
				val element = parent.element

				switch( element ) {
					PropertyDefinition : return element.type

					InstanceMachine : return element.model

					Vertex : return element

					XliaSystem  : return element
					Statemachine: return element
					
					Behavior : return( element.eContainer as NamedElement )

					Machine: return element

					default: return null
				}

			}

			LiteralThisExpression: {
				val thisElement =
					EcoreUtil2.getContainerOfType(parent, typeof(NamedElement))

				switch( thisElement ) {
					Vertex : return thisElement
					
					XliaSystem  : return thisElement
					Statemachine: return thisElement
					
					Behavior: return thisElement.eContainer as NamedElement

					Machine : return thisElement

					default : return thisElement
				}
			}

			LiteralSelfExpression: {
				val selfElement =
					EcoreUtil2.getContainerOfType(parent, typeof(NamedElement))

				switch( selfElement ) {
					Vertex : return selfElement
					
					XliaSystem  : return selfElement
					Statemachine: return selfElement

					Behavior: return( selfElement.eContainer as NamedElement )

					Machine : return selfElement

					default : return selfElement
				}
			}

			LiteralParentExpression: {
				val thisElement =
					EcoreUtil2.getContainerOfType(parent, typeof(NamedElement))

				switch( thisElement ) {
					Vertex : //     $this . Region   . Vertex or Statemachine         
						return thisElement.eContainer.eContainer as NamedElement
					
					XliaSystem : return if( parent != thisElement )
							{ thisElement } else { null }

					Statemachine : return thisElement.eContainer as NamedElement

					Behavior : return EcoreUtil2.getContainerOfType(
							thisElement.eContainer, typeof(Machine) )

					Machine : return thisElement.eContainer as NamedElement

					default: return thisElement
				}
			}

			LiteralSuperExpression: {
				val thisElement =
					EcoreUtil2.getContainerOfType(parent, typeof(NamedElement))

				switch( thisElement ) {
					Vertex : //     $this . Region   . Vertex or Statemachine         
						return thisElement.eContainer.eContainer as NamedElement

					XliaSystem : return if( parent != thisElement )
							{ thisElement } else { null }

					Statemachine : return thisElement.eContainer as NamedElement

					Behavior : return EcoreUtil2.getContainerOfType(
							thisElement.eContainer, typeof(Machine) )

					Machine : return thisElement.eContainer as NamedElement

					default: return thisElement
				}
			}

			LiteralSystemExpression:
				return( EcoreUtil2.getContainerOfType(parent, typeof(XliaSystem)) )

			LiteralEnvExpression:
				return( EcoreUtil2.getContainerOfType(parent, typeof(XliaSystem)) )

			LiteralNullExpression : return null
			
			default: return null
		}
	}

	
	def scope_ValueElementSpecification_element(
		ValueElementSpecification context, EReference reference)
	{
		var parentScope = IScope::NULLSCOPE

		var parentElement = context.parentOf
//			?: EcoreUtil2.getContainerOfType(context, typeof(Machine))

//		if( parentElement === null )
//		{
//			return parentScope
//		}

		var container = context.eContainer
		
		switch( context.expected )
		{
			case ANY: {
				switch( container )
				{
					Transition:
						if( (container.target === context) 
							|| (container.targetExpression === context) )
						{
							context.expected =
								ValueElementSpecificationScheme.VERTEX
						}
					InputComStatement , OutputComStatement:
						if( container.port === context ) {
							context.expected =
								ValueElementSpecificationScheme.COM_POINT
						}
						else if( container.target === context ) {
							context.expected =
								ValueElementSpecificationScheme.MACHINE
						}
						else if( container.route === context ) {
							context.expected =
								ValueElementSpecificationScheme.CHANNEL
						}
						
					AssignmentExpression:
						if( container.leftHandSide === context ) {
							context.expected =
								ValueElementSpecificationScheme.VARIABLE
						}
						else if( container.rightHandSide === context ) {
							context.expected =
								ValueElementSpecificationScheme.ANY
						}
	
					ComPoint:
						if( container.machine === context ) {
							context.expected =
								ValueElementSpecificationScheme.MACHINE
						}
						else if( container.port === context ) {
							context.expected =
								ValueElementSpecificationScheme.COM_POINT
						}
	
					ValueElementSpecification: {
						container = container.eContainer
						for( var retry = true ; retry ; )
						{
							switch( container )
							{
								Transition: {
									context.expected =
										ValueElementSpecificationScheme.COMPOSITE
									retry = false
								}
								InputComStatement , OutputComStatement: {
									context.expected =
										ValueElementSpecificationScheme.COM_POINT
									retry = false
								}
								
								ComPoint: {
									context.expected =
										ValueElementSpecificationScheme.COM_POINT
									retry = false
								}
								
								ValueElementSpecification: {
									container = container.eContainer
								}
								default: retry = false
							}
						}
					}
				}
			}
			default: {
				//!! NOTHING
			}
			
		}
		
		switch( parentElement ) 
		{
			State: {
				switch( context.expected )
				{
					case VERTEX:
						return parentElement.scopeForVertexElement
		
					case COMPOSITE:
						return parentElement.scopeForCompositeElement
		
					default: {
						parentElement = EcoreUtil2.getContainerOfType(
							parentElement, typeof(Machine))
					}
				}
			}
		
			Statemachine: {
				switch( context.expected )
				{
					case VERTEX:
						return parentElement.scopeForVertexElement
		
					case COMPOSITE:
						return parentElement.scopeForCompositeElement
		
					default: {
					}
				}
			}
			
			DataType: {
				return scopeForElements(
					parentElement.selectElements(context), parentScope)
			}
		}
		
		val typeMachine = 
			if( parentElement instanceof Machine ) {
				parentElement
			}
			else {
				EcoreUtil2.getContainerOfType(parentElement, typeof(Machine))
			}

		switch( context.expected )
		{
			case VARIABLE, case MACHINE, case CHANNEL:
				return typeMachine.scopeForRigthElement(context.expected)

			case VERTEX , case COMPOSITE:
				return typeMachine.scopeForCompositeElement

			case BUFFER:
				return typeMachine.scopeForRigthElement(context.expected)

			case COM_POINT: {
				switch( container )
				{
					ConnectorEnd:
						return typeMachine.scopeForSelfMachineComPoint(
							container.direction)

					ComPoint:
						return typeMachine.scopeForSelfMachineComPoint(
							(container.eContainer as ConnectorEnd).direction)

					InputComStatement :
						return typeMachine.scopeForHierarchicLeftElement(
							context.expected)

					OutputComStatement:
						return typeMachine.scopeForHierarchicRigthElement(
							context.expected)
							
					default: return parentScope
				}
			}
			
			default: {
				if( (context.parent instanceof LiteralReferenceExpression)
				&& (! (context.parent instanceof LiteralReferenceElement)) )
				{
					return scopeForElements(
						typeMachine.selectLeftElements(context),
						parentScope)
				}
				else if( typeMachine.isAncestorOf(context) )
				{
					for( machine : typeMachine.reverseMachineHierarchy )
					{
						parentScope = scopeForElements(
							machine.selectLeftElements(context),
							parentScope)
					}
	
					return scopeForElements(
						typeMachine.selectLeftElements(context),
						parentScope)
				}
				else {
					for( machine : typeMachine.reverseMachineHierarchy )
					{
						parentScope = scopeForElements(
							machine.selectPublicLeftElements(context),
							parentScope)
					}
	
					return scopeForElements(
						typeMachine.selectPublicLeftElements(context),
						parentScope)
				}
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////
	// scope_CastExpression_datatype
	////////////////////////////////////////////////////////////////////////////
	
	def scope_CastExpression_datatype(
		CastExpression context, EReference reference)
	{
		return super.getScope(context, reference)
	}

	////////////////////////////////////////////////////////////////////////////
	// scope_InvokeStatement_invokable
	////////////////////////////////////////////////////////////////////////////
	
	def scope_InvokeStatement_invokable(
		InvokeStatement context, EReference reference)
	{
		var parentScope = IScope::NULLSCOPE
		
		var thisMachine = EcoreUtil2.getContainerOfType(context, typeof(Machine))
		
		if( context.isExecRoutine )
		{
			while( (thisMachine !== null) && thisMachine.routine.empty )
			{
				thisMachine = EcoreUtil2.getContainerOfType(
					thisMachine.eContainer, typeof(Machine) )
			}
	
			if( thisMachine !== null )
			{
				val machineHasRoutine = [ Machine m | ! m.routine.empty ]
				
				for( machine :
					thisMachine.reverseMachineHierarchy(machineHasRoutine) )
				{
					if( ! machine.routine.empty )
					{
						parentScope = scopeForElements(
							machine.routine.selectNonPrivate, parentScope)
					}
				}
						
				parentScope = scopeForElements(thisMachine.routine, parentScope)
			}
		}
		else if( context.callProcedure )
		{
			while( (thisMachine !== null) && thisMachine.procedure.empty )
			{
				thisMachine = EcoreUtil2.getContainerOfType(
					thisMachine.eContainer, typeof(Machine) )
			}
	
			if( thisMachine !== null )
			{
				val machineHasProcedure = [ Machine m | (! m.procedure.empty) ]
				
				for( machine :
					thisMachine.reverseMachineHierarchy(machineHasProcedure) )
				{
					if( ! machine.procedure.empty )
					{
						parentScope = scopeForElements(
							machine.procedure.selectNonPrivate, parentScope)
					}
				}
						
				parentScope =scopeForElements(thisMachine.procedure, parentScope)
			}
		}
		
		parentScope
	}

	////////////////////////////////////////////////////////////////////////////
	// scope_DataTypeReference_typeref
	////////////////////////////////////////////////////////////////////////////
	
	def scope_DataTypeReference_typeref(
		DataTypeReference context, EReference reference)
	{
//		var parentScope = IScope::NULLSCOPE
//
//		val container = context.eContainer
//
//		switch( container )
//		{
//			LiteralReferenceElement: {
//				context.scopeForThis(container)
//			}
//			
//			Variable: {
//				
//			}
//			
//			Parameter: {
//				
//			}
//			
//			CollectionType: {
//				
//			}
//			
//			LiteralCollectionExpression: {
//				
//			}
//			
//			default: {
//			}
//		}
//				
//		parentScope
		
		val thisMachine = EcoreUtil2.getContainerOfType(context, typeof(Machine))

		thisMachine.scopeForHierarchicRigthElement(
			ValueElementSpecificationScheme.TYPEDEF)
	}

	////////////////////////////////////////////////////////////////////////////
	// scope_InstanceMachine_model
	////////////////////////////////////////////////////////////////////////////
	
	def scope_InstanceMachine_model(InstanceMachine context, EReference reference)
	{
		context.scopeForHierarchicLeftElement(
			ValueElementSpecificationScheme.MODEL)
	}

	////////////////////////////////////////////////////////////////////////////
	// scope_Route_signals
	////////////////////////////////////////////////////////////////////////////
	
	def scope_Route_signals(Route context, EReference reference)
	{
		context.scopeForComElement(
			PrimitiveInstanceKind.SIGNAL, ChannelDirection.INPUT)
	}
	
	////////////////////////////////////////////////////////////////////////////
	// scope_ComPoint_machine / scope_ComPoint_port
	////////////////////////////////////////////////////////////////////////////
	
	def scope_ComPoint_machine(ComPoint context, EReference reference)
	{
		context.scopeForHierarchicLeftElement(
			ValueElementSpecificationScheme.MACHINE)
	}
	
	def scope_ComPoint_port(ComPoint context, EReference reference)
	{
		if( context.machine instanceof InstanceMachine ) {
			(context.machine as InstanceMachine).model.scopeForComElement(
				 PrimitiveInstanceKind.PORT,
				 (context.eContainer as ConnectorEnd).direction )
		}
		else if( context.machine !== null ) {
			context.machine.scopeForComElement( PrimitiveInstanceKind.PORT,
				 (context.eContainer as ConnectorEnd).direction )
		 }
		 else {
			context.scopeForComElement( PrimitiveInstanceKind.PORT,
				 (context.eContainer as ConnectorEnd).direction )
		 }
	}

	////////////////////////////////////////////////////////////////////////////
	// scope_SlotProperty_xliaProperty
	////////////////////////////////////////////////////////////////////////////
	
	def scope_SlotProperty_xliaProperty(
		SlotProperty context, EReference reference)
	{
		val instance = EcoreUtil2.getContainerOfType(
			context, typeof(InstanceMachine) )
		
		val model = instance.model

		var parentScope = scopeForElements(
				model.variable.selectNonFinalNorConst,
					scopeForElements(model.buffer, IScope::NULLSCOPE))
			
		if( model instanceof Behavior )
		{
			parentScope = scopeForElements(model.parameter, parentScope)
		}
		
		parentScope
	}


	////////////////////////////////////////////////////////////////////////////
	// scope_PrimitiveInstanceType_model
	////////////////////////////////////////////////////////////////////////////
	
	def scope_PrimitiveInstanceType_model(
		PrimitiveInstanceType context, EReference reference)
	{
		context.scopeForAnyModelElement(context)
	}

	////////////////////////////////////////////////////////////////////////////
	// Tools / Utils
	////////////////////////////////////////////////////////////////////////////

	// Select PropertyElement by VISIBILITY
	def Iterable< ? extends NamedElement> selectPublic(
		Iterable< ? extends NamedElement> elements)
	{
		elements.filter[ visibility === VisibilityKind.PUBLIC ]
	}

	def Iterable< ? extends NamedElement> selectNonPublic(
		Iterable< ? extends NamedElement> elements)
	{
		elements.filter[ visibility != VisibilityKind.PUBLIC ]
	}

	def Iterable< ? extends NamedElement> selectNonPrivate(
		Iterable< ? extends NamedElement> elements)
	{
		elements.filter[ visibility != VisibilityKind.PRIVATE ]
	}

	// Select PropertyElement by MODIFIER
	def Iterable< ? extends Variable > selectFinalOrConst(
		Iterable< ? extends Variable > elements) 
	{
		val finalOrConstPredicate = [ Variable P |
			(P.modifier.final || (P as Variable).const) ]

		elements.filter( finalOrConstPredicate )
	}

	def Iterable< ? extends PropertyDefinition > selectNonFinalNorConst(
		Iterable< ? extends PropertyDefinition > elements)
	{
		val nonFinalNorConstPredicate = [ PropertyDefinition P |
			(P.modifier.final === false) &&
			((! (P instanceof Variable)) || ((P as Variable).const === false)) ]

		elements.filter( nonFinalNorConstPredicate )
	}


	// Select Composite State in vertexes
	def Iterable< State > selectCompositeState(
		Iterable< ? extends Vertex > elements)
	{
			
//		elements.filter[ vertex |
//			(vertex instanceof State) && (vertex as State).composite
//		]

		val compositeStates = < State >newArrayList()
		
		for( it : elements ) {
			if( (it instanceof State) && (it as State).composite ) {
				compositeStates += (it as State)
			}
		}
		
		compositeStates
	}



	def isAncestorOf(EObject container, EObject element)
	{
		var ancestor = element.eContainer

		while( (ancestor !== null) && (ancestor != container) )
		{
			ancestor = ancestor.eContainer
		}

		( ancestor !== null )
	}


	// select Element by Type
	def Iterable< ? extends TypedElement > selectTypedElement(
		Iterable< ? extends TypedElement > elements,
		PrimitiveInstanceKind expected)
	{

		val typePredicate = [ TypedElement element |
			(element.type instanceof PrimitiveInstanceType)
			 && ((element.type as PrimitiveInstanceType).expected === expected) ]

		elements.filter( typePredicate )
	}

	// Machine Hierarcy -- Reverse View List
	def reverseMachineHierarchy(Machine machine)
	{
		val hierarchy = < Machine >newArrayList()

		var container = EcoreUtil2.getContainerOfType(
				machine.eContainer, typeof(Machine))

		while( container !== null ) {
			hierarchy.add( container )

			container = EcoreUtil2.getContainerOfType(
				container.eContainer, typeof(Machine))
		}

		hierarchy.reverseView
	}

	def reverseMachineHierarchy(
		Machine machine, Function1<Machine, Boolean> predicate)
	{
		val hierarchy = < Machine >newArrayList()

		var container = EcoreUtil2.getContainerOfType(
				machine.eContainer, typeof(Machine))

		while( (container !== null) && predicate.apply(container) )
		{
			hierarchy.add( container )

			container = EcoreUtil2.getContainerOfType(
				container.eContainer, typeof(Machine))
		}

		hierarchy.reverseView
	}


	////////////////////////////////////////////////////////////////////////////
	// select MACHINE Elements
	////////////////////////////////////////////////////////////////////////////

	def selectLeftElements(Machine machine, ValueElementSpecification ves)
	{
		if( ves.kind === ValueElementSpecificationKind.PARAMETER )
		{
			machine.routine + machine.procedure + machine.function
		}
		else
		{
			selectLeftElements(machine, ves.expected)
		}
	}

	def selectPublicLeftElements(Machine machine, ValueElementSpecification ves)
	{
		if( ves.kind === ValueElementSpecificationKind.PARAMETER )
		{
			machine.routine + machine.procedure + machine.function
		}
		else
		{
			selectPublicLeftElements(machine, ves.expected)
		}
	}


	def selectRigthElements(Machine machine, ValueElementSpecification ves)
	{
		if( ves.kind === ValueElementSpecificationKind.PARAMETER )
		{
			machine.routine + machine.procedure + machine.function
		}
		else
		{
			selectRigthElements(machine, ves.expected)
		}
	}

	def Iterable< ? extends NamedElement> selectElements(
		DataType type, ValueElementSpecification ves)
	{
		if( ves.kind != ValueElementSpecificationKind.PARAMETER )
		{
			switch( type )
			{
				EnumerationType: type.literal

				DataStructuredType: type.property

				DataSupportedType : type.support.selectElements(ves)

				DataTypeReference :
				{
					if( type.typeref !== null )
					{
						type.typeref.selectElements(ves)
					}
					else if( type.support !== null )
					{
						type.support.selectElements(ves)
					}
				}
			}
		}
	}
	

	////////////////////////////////////////////////////////////////////////////
	// select MACHINE Left Elements
	////////////////////////////////////////////////////////////////////////////

	def scopeForSelectedLeftElements(Machine block,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		scopeForElements(block.selectLeftElements(expected), parentScope)
	}
	

	def selectLeftElements(
		Machine block, ValueElementSpecificationScheme expected)
	{
		switch( expected )
		{
			case ANY : block.variable +
				block.channel + block.buffer + block.port + block.signal +
				block.machine + block.instance + block.behavior +
				block.routine + block.procedure + block.typedef +
				block.enumLiterals + block.function

			case VARIABLE : block.variable

			case CONSTANT: {
			}

			case TYPEDEF  : block.typedef
			
			case PORT     : block.port
			case SIGNAL   : block.signal
			case MESSAGE  : block.port + block.signal
			
			case COM_POINT: block.port + block.signal +
							block.machine + block.instance + block.behavior

			case INSTANCE : block.instance
			case MACHINE  : block.machine + block.instance + block.behavior
			case MODEL    : block.machine + block.behavior

			case BUFFER   : block.buffer

			case CHANNEL  : block.channel

			case FUNCTION : block.function

			case VERTEX , case COMPOSITE: {
			}

			case PROCEDURE: block.procedure
			case ROUTINE  : block.routine
		}
	}
	

	def selectPublicLeftElements(
		Machine block, ValueElementSpecificationScheme expected)
	{
		selectLeftElements(block, expected).selectPublic
	}

//!@?UNUSED
//	def selectNonPublicLeftElements(
//		Machine block, ValueElementSpecificationScheme expected)
//	{
//		selectLeftElements(block, expected).selectNonPublic
//	}


	////////////////////////////////////////////////////////////////////////////
	// select MACHINE Rigth Elements
	////////////////////////////////////////////////////////////////////////////

	def scopeForSelectedRigthElements(Machine block,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		scopeForElements(block.selectRigthElements(expected), parentScope)
	}
	
	
	def selectRigthElements(
		Machine block, ValueElementSpecificationScheme expected)
	{
		switch( expected )
		{
			case ANY : block.variable +
				block.channel + block.buffer + block.port + block.signal +
				block.machine + block.instance + block.behavior +
				block.routine + block.procedure +
				block.typedef + block.enumLiterals +
				block.function

			case VARIABLE : block.variable

			case CONSTANT: block.variable.selectFinalOrConst

			case TYPEDEF  : block.typedef

			case PORT     : block.port +
							block.variable.selectProperty(expected)

			case SIGNAL   : block.signal +
							block.variable.selectProperty(expected)

			case MESSAGE  : block.port + block.signal +
							block.variable.selectProperty(expected)

			case COM_POINT: block.port + block.signal +
							block.machine + block.instance + block.behavior +
							block.variable.selectProperty(expected)

			case INSTANCE : block.instance +
							block.variable.selectProperty(expected)

			case MACHINE  : block.machine + block.instance + block.behavior +
							block.variable.selectProperty(expected)

			case MODEL    : block.machine + block.behavior

			case BUFFER   : block.buffer +
							block.variable.selectProperty(expected)

			case CHANNEL  : block.channel +
							block.variable.selectProperty(expected)

			case FUNCTION : block.function

			case VERTEX   : block.variable.selectProperty(expected)
			
			case COMPOSITE: block.machine +
							block.instance + block.behavior +
							block.variable.selectProperty(expected)

			case PROCEDURE: block.procedure
			case ROUTINE  : block.routine
		}
	}
	

	def selectPublicRigthElements(
		Machine block, ValueElementSpecificationScheme expected)
	{
		selectRigthElements(block, expected).selectPublic
	}

	def selectNonPublicRigthElements(
		Machine block, ValueElementSpecificationScheme expected)
	{
		selectRigthElements(block, expected).selectNonPublic
	}


	def enumLiterals(Machine machine)
	{
		val literals = < EnumerationLiteral >newArrayList()

		for( it : machine.typedef )
		{
			val type = it.typeSpecifier
			switch( type )
			{
				EnumerationType: literals += type.literal
			}
		}

		literals
	}


	////////////////////////////////////////////////////////////////////////////
	// select MACHINE Structured Elements
	////////////////////////////////////////////////////////////////////////////

	def scopeForSelectedStructuredElements(Machine block,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		val selectedElements = < NamedElement >newArrayList()

		switch( expected )
		{
			case ANY : {
				for( it : block.variable )
				{
					if( it.type.isStructured )
					{
						selectedElements += it
					}
				}
				for( it : block.typedef )
				{
					if( it instanceof EnumerationType )
					{
						selectedElements += it
					}
				}
				selectedElements += block.machine + block.instance + block.behavior
			}

			case VARIABLE : {
				for( it : block.variable )
				{
					if( it.type.isStructured )
					{
						selectedElements += it
					}
				}
			}

			case INSTANCE : selectedElements += block.instance +
							block.variable.selectProperty(expected)

			case MACHINE  : selectedElements += block.machine +
							block.instance + block.behavior +
							block.variable.selectProperty(expected)

			case MODEL    : selectedElements += block.machine + block.behavior

			default: {
			}
		}

		scopeForElements(selectedElements, parentScope)
	}


	////////////////////////////////////////////////////////////////////////////
	// select BEHAVIOR Left Elements
	////////////////////////////////////////////////////////////////////////////

	def scopeForSelectedLeftElements(Behavior block, 
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		var selectedElements = (block as Machine).selectLeftElements(expected)

		switch( expected )
		{
			case ANY , case VARIABLE :
				selectedElements = selectedElements + block.parameter

			default: {
			}
		}
		
		scopeForElements(selectedElements, parentScope)
	}


	def scopeForSelectedLeftElements(Statemachine block, 
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		val behaviorScope = (block as Behavior).scopeForSelectedLeftElements(
			expected, parentScope)
			
		switch( expected )
		{
			case VERTEX : {
				var Iterable< Vertex > selectedElements = < Vertex >newArrayList()
				
				for( it : block.region ) {
					selectedElements = it.vertex + selectedElements
				}
				
				scopeForElements(selectedElements, behaviorScope)
			}
			
			case COMPOSITE : {
				var Iterable< Vertex > selectedElements = < Vertex >newArrayList()
				
				for( it : block.region ) {
					selectedElements = it.vertex + selectedElements
				}
				
				scopeForElements(
					selectedElements.selectCompositeState, behaviorScope
				)
			}
			
			default: behaviorScope
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// select BEHAVIOR Rigth Elements
	////////////////////////////////////////////////////////////////////////////

	def scopeForSelectedRigthElements(Behavior block,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		var selectedElements = (block as Machine).selectRigthElements(expected)

		switch( expected )
		{
			case ANY :
				selectedElements = selectedElements + block.parameter

			case VARIABLE :
				selectedElements = selectedElements + block.parameter
				
			default: {
			}
		}
		
		scopeForElements(selectedElements, parentScope)
	}


	def scopeForSelectedRigthElements(Statemachine block,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		val behaviorScope = (block as Behavior).scopeForSelectedRigthElements(
			expected, parentScope)

		switch( expected )
		{
			case VERTEX : {
				var Iterable< Vertex > selectedElements = < Vertex >newArrayList()
				
				for( it : block.region ) {
					selectedElements = it.vertex + selectedElements
				}
				
				scopeForElements(selectedElements, behaviorScope)
			}
			
			case COMPOSITE : {
				var Iterable< Vertex > selectedElements = < Vertex >newArrayList()
				
				for( it : block.region ) {
					selectedElements = it.vertex + selectedElements
				}
				
				scopeForElements(
					selectedElements.selectCompositeState, behaviorScope
				)
			}
			
			default: behaviorScope
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// select SYSTEM Elements
	////////////////////////////////////////////////////////////////////////////

	def scopeForSelectedLeftElements(XliaSystem block,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		switch( expected )
		{
			case ANY,			
			case MACHINE,	
			case COMPOSITE,	
			case COM_POINT :
				(block as Machine).scopeForSelectedLeftElements(expected,
					Scopes::scopeFor(newArrayList( block ), parentScope))
	
			default:
				(block as Machine).scopeForSelectedLeftElements(
					expected, parentScope)
		}
	}

	def scopeForSelectedRigthElements(XliaSystem block,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		switch( expected )
		{
			case ANY,
			case MACHINE,
			case COMPOSITE,
			case COM_POINT :
				(block as Machine).scopeForSelectedRigthElements(expected,
					Scopes::scopeFor(newArrayList( block ), parentScope))

			default:
				(block as Machine).scopeForSelectedRigthElements(
					expected, parentScope)
		}
	}


	def scopeForSelectedStructuredElements(XliaSystem block,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		switch( expected )
		{
			case ANY,			
			case MACHINE,	
			case COMPOSITE,	
			case COM_POINT :
				(block as Machine).scopeForSelectedStructuredElements(expected,
					Scopes::scopeFor(newArrayList( block ), parentScope))

			default:
				(block as Machine).scopeForSelectedStructuredElements(
					expected, parentScope)
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// select OTHER Elements
	////////////////////////////////////////////////////////////////////////////

	def selectProperty(
		Iterable< ? extends PropertyDefinition > properties,
		ValueElementSpecificationScheme expected)
	{
		switch( expected ) {
			case ANY : properties

			case VARIABLE: properties

			case CONSTANT: properties

			default: {
				val selection = < PropertyDefinition >newArrayList()

				for( it : properties ) {
					val type = it.type.typeSpecifier
					switch( type ) {
						PrimitiveInstanceType : {
							switch( expected ) {
								case PORT: {
									if( type.expected ==
										PrimitiveInstanceKind.PORT )
									{ selection += it }
								}
								case SIGNAL: {
									if( type.expected ==
										PrimitiveInstanceKind.SIGNAL )
									{ selection += it }
								}
								case MESSAGE: {
									if( type.expected ==
										PrimitiveInstanceKind.MESSAGE )
									{ selection += it }
								}
								case COM_POINT: {
									if( (type.expected ==
											PrimitiveInstanceKind.PORT)
									|| (type.expected ==
											PrimitiveInstanceKind.SIGNAL)
									|| (type.expected ==
											PrimitiveInstanceKind.MACHINE)
									|| (type.expected ==
											PrimitiveInstanceKind.COM_POINT) )
									{ selection += it }
								}
								case INSTANCE: {
									if( type.expected ==
										PrimitiveInstanceKind.MACHINE )
									{ selection += it }
								}
								case MACHINE: {
									if( type.expected ==
										PrimitiveInstanceKind.MACHINE )
									{ selection += it }
								}

								case BUFFER: {
									if( type.expected ==
										PrimitiveInstanceKind.BUFFER )
									{ selection += it }
								}
								case CHANNEL: {
									if( type.expected ==
										PrimitiveInstanceKind.CHANNEL )
									{ selection += it }
								}

								case FUNCTION: {
									if( type.expected ==
										PrimitiveInstanceKind.FUNCTION )
									{ selection += it }
								}

								case VERTEX: {
									if( type.expected ==
										PrimitiveInstanceKind.VERTEX )
									{ selection += it }
								}
								case COMPOSITE: {
									if( (type.expected ==
										PrimitiveInstanceKind.COMPOSITE)
									|| (type.expected ==
											PrimitiveInstanceKind.MACHINE) )
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

	////////////////////////////////////////////////////////////////////////////
	// select ROUTINE Elements
	////////////////////////////////////////////////////////////////////////////

	def scopeForSelectedLeftElements(Routine routine,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		switch( expected )
		{
			case ANY     :
			{
				var lvalue = < Parameter >newArrayList()
				if( routine.parameterSet !== null )
				{
					lvalue += routine.parameterSet.parameter
				}
				if( routine.resultSet !== null )
				{
					lvalue += routine.resultSet.parameter
				}

				scopeForElements(lvalue, parentScope)
			}

			case VARIABLE: {
				var lvalue = < Parameter >newArrayList()
				if( routine.parameterSet !== null )
				{
					lvalue += routine.parameterSet.parameter
				}
				if( routine.resultSet !== null )
				{
					lvalue += routine.resultSet.parameter
				}

				scopeForElements(lvalue, parentScope)
			}

			case MACHINE: {
				val thisMachine =
						EcoreUtil2.getContainerOfType(routine, typeof(Machine))
				
				val lvalue = thisMachine.machine + thisMachine.instance

				scopeForElements(lvalue, parentScope)
			}

			default: {
				var Iterable< PropertyDefinition > lvalue = < PropertyDefinition >newArrayList()
				if( routine.parameterSet !== null )
				{
					lvalue = lvalue +
						routine.parameterSet.parameter.selectProperty(expected)
				}
				if( routine.resultSet !== null )
				{
					lvalue = lvalue +
						routine.resultSet.parameter.selectProperty(expected)
				}

				scopeForElements(lvalue, parentScope)
			}
		}
	}

	def scopeForSelectedRigthElements(Routine routine,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		var Iterable< PropertyDefinition > properties = < PropertyDefinition >newArrayList()

		if( routine.parameterSet !== null )
		{
			properties = properties +
				routine.parameterSet.parameter.selectProperty(expected)
		}
		if( routine.resultSet !== null )
		{
			properties = properties +
				routine.resultSet.parameter.selectProperty(expected)
		}

		scopeForElements(properties, parentScope)
	}


	def scopeForSelectedStructuredElements(Routine routine,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		val selectedElements = < PropertyDefinition >newArrayList()

		if( routine.parameterSet !== null )
		{
			for( it : routine.parameterSet.parameter )
			{
				if( it.type.isStructured ) {
					selectedElements += it
				}
			}
		}
		if( routine.resultSet !== null )
		{
			for( it : routine.resultSet.parameter )
			{
				if( it.type.isStructured )
				{
					selectedElements += it
				}
			}
		}

		scopeForElements(selectedElements, parentScope)
	}

	////////////////////////////////////////////////////////////////////////////
	// ComPoint --> NamedElement
	////////////////////////////////////////////////////////////////////////////

	def scopeForSelfMachineInstance(Machine thisMachine, IScope outer)
	{
		val selfMachine =
			if( (thisMachine.name === null) &&
				(thisMachine.eContainer instanceof Machine) )
			{
				thisMachine.eContainer as Machine
			}
			else
			{
				thisMachine
			}

		scopeForElements(selfMachine.instance,
			scopeForElements(selfMachine.machine,
				scopeForElements(selfMachine.behavior, outer)))
	}


	def scopeForSelfMachineComPoint(
		Machine thisMachine, ChannelDirection direction)
	{
		var parentScope = scopeForElements(
			thisMachine.port.selectPort(direction),
			scopeForElements(
				thisMachine.signal.selectSignal(direction),
				IScope::NULLSCOPE))

		if( (thisMachine.name === null) &&
			(thisMachine.eContainer instanceof Machine) )
		{
			val selfMachine = thisMachine.eContainer as Machine

			if( selfMachine.main === thisMachine )
			{
				parentScope = scopeForElements(
					selfMachine.port.selectPort(direction),
					scopeForElements(
						selfMachine.signal.selectSignal(direction),
						parentScope) )
			}
		}

		parentScope
	}

	////////////////////////////////////////////////////////////////////////////
	// scopeForThis
	////////////////////////////////////////////////////////////////////////////

	def scopeForThis(
		LeftHandSideExpression container, LiteralReferenceElement context)
	{
		container.scopeForHierarchicLeftElement(
			ValueElementSpecificationScheme.VARIABLE,
			container.scopeForHierarchicLeftElement(
			 	ValueElementSpecificationScheme.MACHINE, IScope::NULLSCOPE))
	}

	def scopeForThis(
		AssignmentExpression container, LiteralReferenceElement context)
	{
		container.scopeForHierarchicLeftElement(
			ValueElementSpecificationScheme.ANY)
	}

	def scopeForThis(Statement container, LiteralReferenceElement context)
	{
		container.scopeForHierarchicLeftElement(
			ValueElementSpecificationScheme.ANY)
	}


	def scopeForThis(
		InputComStatement container, LiteralReferenceElement context)
	{
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
					ValueElementSpecificationScheme.ANY)
		}
	}


	def scopeForThis(
		OutputComStatement container, LiteralReferenceElement context)
	{
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
		ActivityStatement container, LiteralReferenceElement context)
	{
		if( context === container.machine )
		{
			container.scopeForHierarchicLeftElement(
				ValueElementSpecificationScheme.MACHINE)
		}
		else
		{
			container.scopeForHierarchicLeftElement(
				ValueElementSpecificationScheme.ANY)
		}
	}


	def scopeForThis(Transition container, LiteralReferenceElement context)
	{
		val thisRegion =
			EcoreUtil2.getContainerOfType(container, typeof(Region))

		if( context === container.target ) {
			thisRegion.scopeForVertexElement
		}
		else {
			thisRegion.scopeForCompositeElement
		}
	}

//	def scopeForThis(Transition container, ValueElementSpecification context)
//	{
//		val thisRegion =
//			EcoreUtil2.getContainerOfType(container, typeof(Region))
//
//		if( context === container.target ) {
//			thisRegion.scopeForVertexElement
//		}
//		else {
//			thisRegion.scopeForCompositeElement(
//				ValueElementSpecificationScheme.COMPOSITE)
//		}
//	}

	def Machine lastParentOf(LiteralReferenceSpecification context) {
		if( ! context.parent.empty ) {
			val parent = context.parent.last
//			for( parent : context.parent.reverse )
			switch( parent ) {
				LiteralReferenceElement: {
					if( parent.element instanceof Machine ) {
						return( parent.element as Machine )
					}
					else if( parent.element instanceof InstanceMachine ) {
						return( (parent.element as InstanceMachine).model )
					}
				}
				
			}
		}
		
		return EcoreUtil2.getContainerOfType(context, typeof(Machine));
	}


	def scopeForThis(ComProtocol container, LiteralReferenceElement context)
	{
		val thisMachine =
			EcoreUtil2.getContainerOfType(container, typeof(Machine))

		val ctxContainer = context.eContainer
		
		if( ctxContainer instanceof LiteralReferenceSpecification ) {
			if( ctxContainer.element === context ) {
				if( ! ctxContainer.parent.empty ) {					
					return ctxContainer.lastParentOf.scopeForHierarchicLeftElement(
						ValueElementSpecificationScheme.BUFFER)
				}
				
				return thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.BUFFER)
			}
//			if( ! ctxContainer.parent.empty ) {					
//				return ctxContainer.lastParentOf.scopeForHierarchicLeftElement(
//					ValueElementSpecificationScheme.MACHINE)
//			}
		}
		
		return thisMachine.scopeForHierarchicLeftElement(
			ValueElementSpecificationScheme.MACHINE)
	}

	def scopeForThis(ComPoint container, LiteralReferenceElement context)
	{
		val thisMachine =
			EcoreUtil2.getContainerOfType(container, typeof(Machine))

		thisMachine.scopeForHierarchicLeftElement(
			ValueElementSpecificationScheme.COM_POINT)
	}


	def scopeForThis(
		DataTypeReference thisType, LiteralReferenceElement context)
	{
		val thisMachine =
			EcoreUtil2.getContainerOfType(thisType, typeof(Machine))

		if( thisType.multiplicity === context ) {
			thisMachine.scopeForHierarchicRigthElement(
				ValueElementSpecificationScheme.CONSTANT)
		}
		else {
			thisMachine.scopeForHierarchicRigthElement(
				ValueElementSpecificationScheme.TYPEDEF)
		}
	}


//	def scopeForThis(
//		ValueElementSpecification thisElement, LiteralReferenceElement context)
//	{
//		for( var EObject it = thisElement ; it !== null; it = it.eContainer()) {
//			switch( it ) {
//				Transition: return it.scopeForThis(context)
//
//				Routine: return it.scopeForHierarchicStructuredElement(
//					ValueElementSpecificationScheme.ANY)
//
//				Machine: return it.scopeForHierarchicStructuredElement(
//					ValueElementSpecificationScheme.ANY)
//			}
//		}
//
//		IScope::NULLSCOPE
//	}


	def scopeForThis(
		TupleExpression thisTuple, LiteralReferenceElement context)
	{
		thisTuple.scopeForHierarchicRigthElement(
			ValueElementSpecificationScheme.ANY)
	}

	def scopeForThis(
		QuantifiedLogicalExpression thisQExpression,
		LiteralReferenceElement context)
	{
		scopeForElements(thisQExpression.variable,
			thisQExpression.scopeForHierarchicRigthElement(
				ValueElementSpecificationScheme.ANY) )
	}


	def scopeForThis(
		InvokeExpression thisInvoke, LiteralReferenceElement context)
	{
		if( (context.eContainer === thisInvoke) &&
			(context.kind === ValueElementSpecificationKind.PARAMETER) )
		{
				if( thisInvoke.callProcedure )
				{
					thisInvoke.scopeForHierarchicRigthElement(
						ValueElementSpecificationScheme.PROCEDURE)
				}
				else
				{
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

	def scopeForAnyElement(Routine thisRoutine, LiteralReferenceElement context)
	{
		thisRoutine.scopeForHierarchicRigthElement(
			ValueElementSpecificationScheme.ANY)
	}

	def scopeForAnyElement(Machine thisBlock, LiteralReferenceElement context)
	{
		thisBlock.scopeForHierarchicRigthElement(
			ValueElementSpecificationScheme.ANY)
	}


	def scopeForAnyModelElement(
		PrimitiveInstanceType thisType, AbstractElement context)
	{
		val thisMachine =
				EcoreUtil2.getContainerOfType(thisType, typeof(Machine))
				
		if( context.eContainer instanceof LiteralNullExpression )
		{
			thisMachine.scopeForHierarchicLeftElement(
				ValueElementSpecificationScheme.MODEL)
		}
		else switch( thisType.expected )
		{
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

			case FUNCTION   : {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.FUNCTION)
			}
			
			case VERTEX   : {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.VERTEX)
			}
			
			default: {
				thisMachine.scopeForHierarchicLeftElement(
					ValueElementSpecificationScheme.ANY)
			}
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// scopeFor Vertex Element
	////////////////////////////////////////////////////////////////////////////

	def scopeForVertexElement(Statemachine statemachine)
	{			
		var IScope parentScope = IScope::NULLSCOPE
		
		var Iterable< Vertex > vertexes = < Vertex >newArrayList()
		for( it : statemachine.region ) {
			vertexes = it.vertex + vertexes
		}
					
		scopeForElements(vertexes, parentScope)
	}

	def scopeForVertexElement(State state)
	{			
		var IScope parentScope = IScope::NULLSCOPE
		
		var Iterable< Vertex > vertexes = < Vertex >newArrayList()
		for( it : state.region ) {
			vertexes = it.vertex + vertexes
		}
					
		scopeForElements(vertexes, parentScope)
	}


	def scopeForVertexElement(Region thisRegion)
	{			
		val regions = < Iterable<Region> >newArrayList()

		for( var container = thisRegion.eContainer ; container !== null ; )
		{
			switch( container )
			{
				State: {
					regions.add( container.region )
					container = container.eContainer
				}
				Statemachine: {
					regions.add( container.region )
					container = null
				}
				default: {
					container = container.eContainer
				}
			}
		}

		var IScope parentScope = IScope::NULLSCOPE
		
		for( region : regions.reverseView )
		{
			var Iterable< Vertex > vertexes = < Vertex >newArrayList()
			for( it : region ) {
				if( it !== thisRegion ) {
					vertexes = it.vertex + vertexes
				}
			}
			
			parentScope = scopeForElements(vertexes, parentScope)
		}
		
		scopeForElements(thisRegion.vertex, parentScope)
	}

	////////////////////////////////////////////////////////////////////////////
	// scopeFor Composite[State | Machine] Element
	////////////////////////////////////////////////////////////////////////////

	def scopeForCompositeElement(Machine machine)
	{			
		var IScope parentScope = IScope::NULLSCOPE
		
		val composite = machine.machine + machine.instance + machine.behavior
				+ machine.variable.selectProperty(
						ValueElementSpecificationScheme.COMPOSITE)
		
		scopeForElements(composite, parentScope)
	}

	def scopeForCompositeElement(Statemachine statemachine)
	{			
		var IScope parentScope = IScope::NULLSCOPE
		
		val composite = statemachine.machine
				+ statemachine.instance + statemachine.behavior
				+ statemachine.variable.selectProperty(
						ValueElementSpecificationScheme.COMPOSITE)
		
		var Iterable< Vertex > vertexes = < Vertex >newArrayList()
		for( it : statemachine.region ) {
			vertexes = it.vertex + vertexes
		}
					
		scopeForElements(vertexes.selectCompositeState,
			scopeForElements(composite, parentScope) )
	}

	def scopeForCompositeElement(State state)
	{			
		var IScope parentScope = IScope::NULLSCOPE
		
		var Iterable< Vertex > vertexes = < Vertex >newArrayList()
		for( it : state.region ) {
			vertexes = it.vertex + vertexes
		}
					
		scopeForElements(vertexes.selectCompositeState, parentScope)
	}


	def scopeForCompositeElement(Region thisRegion)
	{
		var parentScope = IScope::NULLSCOPE

		var hierarchicalContainer = < NamedElement >newArrayList()
		var container = thisRegion.eContainer
		for( ; container !== null ; container = container.eContainer )
		{
			switch( container ) {
				State: {
				}
				Region: {
					val compositeStates = container.vertex.selectCompositeState
					
					parentScope = scopeForElements(compositeStates, parentScope)
				}
				Statemachine: {
					hierarchicalContainer.add( container )
				}
				Machine: {
					hierarchicalContainer.add( container )
				}
				default: {
				}
			}
		}
		
		val compositeStates = thisRegion.vertex.selectCompositeState
		
		parentScope = scopeForElements(hierarchicalContainer,
			scopeForElements(compositeStates, parentScope)
		)
	}


	def scopeForCompositeElement(Iterable< State > compositeStates)
	{
		
	}

	////////////////////////////////////////////////////////////////////////////
	// Machine: scopeForLeftElement / scopeForRigthElement
	////////////////////////////////////////////////////////////////////////////
//!@?UNUSED
//	def scopeForLeftElement(
//		Machine thisMachine, ValueElementSpecificationScheme expected)
//	{
//		var parentScope = IScope::NULLSCOPE
//
//		if( (thisMachine.name === null) &&
//			(thisMachine.eContainer instanceof Machine) )
//		{
//			val selfMachine = thisMachine.eContainer as Machine
//
//			if( selfMachine.main === thisMachine )
//			{
//				parentScope = scopeForElements(
//					selfMachine.selectLeftElements(expected), parentScope)
//			}
//		}
//
//		scopeForElements(thisMachine.selectLeftElements(expected), parentScope)
//	}

	def scopeForRigthElement(
		Machine thisMachine, ValueElementSpecificationScheme expected)
	{
		var parentScope = IScope::NULLSCOPE

		if( (thisMachine.name === null) &&
			(thisMachine.eContainer instanceof Machine) )
		{
			val selfMachine = thisMachine.eContainer as Machine

			if( selfMachine.main === thisMachine )
			{
				parentScope = selfMachine.scopeForSelectedRigthElements(
					expected, parentScope)
			}
		}

		thisMachine.scopeForSelectedRigthElements(expected, parentScope)
	}


	def scopeForHierarchicLeftElement(Machine thisMachine,
		ValueElementSpecificationScheme expected, IScope xParentScope)
	{
		var parentScope = xParentScope
		
		for( block : thisMachine.reverseMachineHierarchy )
		{
			switch( block )
			{
				Statemachine: parentScope = 
					block.scopeForSelectedLeftElements(expected, parentScope)

				Behavior: parentScope =
					block.scopeForSelectedLeftElements(expected, parentScope)

				XliaSystem: parentScope =
					block.scopeForSelectedLeftElements(expected, parentScope)

				default: parentScope =
					block.scopeForSelectedLeftElements(expected, parentScope)
			}
		}

		switch( thisMachine )
		{
			Statemachine:
				thisMachine.scopeForSelectedLeftElements(expected, parentScope)

			Behavior:
				thisMachine.scopeForSelectedLeftElements(expected, parentScope)

			XliaSystem:
				thisMachine.scopeForSelectedLeftElements(expected, parentScope)

			default:
				thisMachine.scopeForSelectedLeftElements(expected, parentScope)
		}
	}

	////////////////////////////////////////////////////////////////////////////
	// Machine: scopeForHierarchicLeftElement / scopeForHierarchicRigthElement
	////////////////////////////////////////////////////////////////////////////

	def scopeForHierarchicRigthElement(
		Machine thisMachine, ValueElementSpecificationScheme expected)
	{
		var parentScope = IScope::NULLSCOPE

		for( block : thisMachine.reverseMachineHierarchy )
		{
			switch( block )
			{
				Statemachine: parentScope = 
					block.scopeForSelectedRigthElements(expected, parentScope)

				Behavior: parentScope =
					block.scopeForSelectedRigthElements(expected, parentScope)

				XliaSystem: parentScope =
					block.scopeForSelectedRigthElements(expected, parentScope)

				default: parentScope =
					block.scopeForSelectedRigthElements(expected, parentScope)
			}
		}

		switch( thisMachine )
		{
			Statemachine:
				thisMachine.scopeForSelectedRigthElements(expected, parentScope)

			Behavior:
				thisMachine.scopeForSelectedRigthElements(expected, parentScope)

			XliaSystem: parentScope =
				thisMachine.scopeForSelectedRigthElements(expected, parentScope)

			default:
				thisMachine.scopeForSelectedRigthElements(expected, parentScope)
		}
	}


	def scopeForHierarchicStructuredElement(
		Machine thisMachine, ValueElementSpecificationScheme expected)
	{
		var parentScope = IScope::NULLSCOPE

		for( machine : thisMachine.reverseMachineHierarchy )
		{
			switch( machine )
			{
				Behavior: parentScope =
					machine.scopeForSelectedStructuredElements(
						expected, parentScope)

				XliaSystem: parentScope =
					machine.scopeForSelectedStructuredElements(
						expected, parentScope)

				default: parentScope =
					machine.scopeForSelectedStructuredElements(
						expected, parentScope)
			}
		}

		switch( thisMachine )
		{
			Behavior:
				thisMachine.scopeForSelectedStructuredElements(
					expected, parentScope)

			XliaSystem:
				thisMachine.scopeForSelectedStructuredElements(
					expected, parentScope)

			default:
				thisMachine.scopeForSelectedStructuredElements(
					expected, parentScope)
		}
	}
	

	////////////////////////////////////////////////////////////////////////////
	// Routine: scopeForHierarchicLeftElement / scopeForHierarchicRigthElement
	////////////////////////////////////////////////////////////////////////////

	def scopeForHierarchicStructuredElement(
		Routine thisRoutine, ValueElementSpecificationScheme expected)
	{
		val thisMachine =
			EcoreUtil2.getContainerOfType(thisRoutine, typeof(Machine))

		thisRoutine.scopeForSelectedStructuredElements(expected,
			scopeForHierarchicStructuredElement(thisMachine, expected))
	}


	def scopeForHierarchicLeftElement(Routine thisRoutine,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		val thisMachine =
			EcoreUtil2.getContainerOfType(thisRoutine, typeof(Machine))

		thisRoutine.scopeForSelectedLeftElements(expected,
			scopeForHierarchicLeftElement(thisMachine, expected, parentScope))
	}

	def scopeForHierarchicRigthElement(
		Routine thisRoutine, ValueElementSpecificationScheme expected)
	{
		val thisMachine =
			EcoreUtil2.getContainerOfType(thisRoutine, typeof(Machine))

		thisRoutine.scopeForSelectedRigthElements(expected,
			scopeForHierarchicRigthElement(thisMachine, expected))
	}


	////////////////////////////////////////////////////////////////////////////
	// EObject: scopeForHierarchicLeftElement / scopeForHierarchicRigthElement
	////////////////////////////////////////////////////////////////////////////

	def scopeForHierarchicLeftElement(EObject context,
		ValueElementSpecificationScheme expected, IScope parentScope)
	{
		for( var it = context ; it !== null; it = it.eContainer() )
		{
			switch( it )
			{
				Routine: return it.scopeForHierarchicLeftElement(
					expected, parentScope)

				Machine: return it.scopeForHierarchicLeftElement(
					expected, parentScope)
			}
		}

		parentScope
	}

	def scopeForHierarchicLeftElement(
		EObject context, ValueElementSpecificationScheme expected)
	{
		for( var it = context ; it !== null; it = it.eContainer() )
		{
			switch( it )
			{
//				State: return it.scopeForHierarchicLeftElement(
//					expected, IScope::NULLSCOPE)
//
//				Vertex: return it.scopeForHierarchicLeftElement(
//					expected, IScope::NULLSCOPE)

				Routine: return it.scopeForHierarchicLeftElement(
					expected, IScope::NULLSCOPE)

				Machine: return it.scopeForHierarchicLeftElement(
					expected, IScope::NULLSCOPE)
			}
		}

		IScope::NULLSCOPE
	}

	def scopeForHierarchicRigthElement(
		EObject context, ValueElementSpecificationScheme expected)
	{
		for( var it = context ; it !== null; it = it.eContainer() )
		{
			switch( it )
			{
//				State: return it.scopeForHierarchicRigthElement(expected)
//
//				Vertex: return it.scopeForHierarchicRigthElement(expected)

				Routine: return it.scopeForHierarchicRigthElement(expected)

				Machine: return it.scopeForHierarchicRigthElement(expected)
			}
		}

		IScope::NULLSCOPE
	}

}
