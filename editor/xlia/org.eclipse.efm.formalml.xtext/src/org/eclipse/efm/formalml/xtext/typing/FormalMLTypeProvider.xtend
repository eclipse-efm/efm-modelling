package org.eclipse.efm.formalml.xtext.typing

import org.eclipse.efm.ecore.formalml.common.Type
import org.eclipse.efm.ecore.formalml.datatype.DataStructuredType
import org.eclipse.efm.ecore.formalml.datatype.DataSupportedType
import org.eclipse.efm.ecore.formalml.datatype.DataTypeReference
import org.eclipse.efm.ecore.formalml.datatype.DatatypeFactory
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType
import org.eclipse.efm.ecore.formalml.datatype.IntervalType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveBooleanType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveCharacterType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveFloatType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveIntegerType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRationalType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRealType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType
import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression
import org.eclipse.efm.ecore.formalml.expression.EqualityBinaryExpression
import org.eclipse.efm.ecore.formalml.expression.Expression
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement
import org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression
import org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression
import org.eclipse.efm.ecore.formalml.expression.LogicalUnaryExpression
import org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition
import org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty
import org.eclipse.efm.ecore.formalml.infrastructure.System
import org.eclipse.efm.ecore.formalml.infrastructure.Variable
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine
import org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement
import org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement
import org.eclipse.efm.ecore.formalml.statement.StatementPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType
import org.eclipse.efm.ecore.formalml.datatype.CollectionType
import org.eclipse.efm.ecore.formalml.expression.ArithmeticUnaryExpression
import org.eclipse.efm.ecore.formalml.expression.ArithmeticAssociativeExpression
import org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression
import org.eclipse.efm.ecore.formalml.statemachine.Vertex

class FormalMLTypeProvider {

	static val exprPack = ExpressionPackage::eINSTANCE

	static val infraPack = InfrastructurePackage::eINSTANCE

	static val stmntPack = StatementPackage::eINSTANCE


	public static val booleanType =
		DatatypeFactory::eINSTANCE.createPrimitiveBooleanType
		=> [name = 'BooleanType']

	public static val integerType =
		DatatypeFactory::eINSTANCE.createPrimitiveIntegerType
		=> [name = 'IntegerType']

	public static val rationalType =
		DatatypeFactory::eINSTANCE.createPrimitiveRationalType
		=> [name = 'RationalType']

	public static val floatType =
		DatatypeFactory::eINSTANCE.createPrimitiveFloatType
		=> [name = 'FloatType']

	public static val realType =
		DatatypeFactory::eINSTANCE.createPrimitiveRealType
		=> [name = 'RealType']

	public static val timeType =
		DatatypeFactory::eINSTANCE.createPrimitiveTimeType
		=> [name = 'TimeType']

	public static val characterType =
		DatatypeFactory::eINSTANCE.createPrimitiveCharacterType
		=> [name = 'CharacterType']

	public static val stringType =
		DatatypeFactory::eINSTANCE.createPrimitiveStringType
		=> [name = 'StringType']

	public static val machineType =
		DatatypeFactory::eINSTANCE.createPrimitiveInstanceType
		=> [name = 'MachineType' ; expected = PrimitiveInstanceKind.MACHINE]

	public static val anyNullType =
		DatatypeFactory::eINSTANCE.createPrimitiveInstanceType
		=> [name = '$null' ; expected = PrimitiveInstanceKind.ANY]



	def Type typeClass(Type type) {
		switch( type ) {
			PrimitiveBooleanType   : return booleanType
			PrimitiveIntegerType   : return integerType
			PrimitiveRationalType  : return rationalType
			PrimitiveFloatType     : return floatType
			PrimitiveRealType      : return realType
			PrimitiveCharacterType : return characterType
			PrimitiveStringType    : return stringType

			PrimitiveTimeType : return( type.support?.typeClass ?: timeType )

			IntervalType      : return( type.support?.typeClass ?: type )

			DataTypeReference : {
				if( type.multiplicity === null ) {
					if( type.support !== null ) {
						return( type.support.typeClass )
					}
					else if( type.typeref !== null ) {
						return( type.typeref.typeClass )
					}
					else {
						return type
					}
				}
				else {
					return type
				}
			}

			default: return type
		}
	}


	def Type typeClassFor(Expression e) {
		e.typeFor.typeClass
	}

	def Type expectedTypeClass(Expression e) {
		e.expectedType.typeClass
	}


	def Type typeFor(Expression e) {
		switch( e ) {
			LiteralBooleanExpression     : return booleanType
			LogicalUnaryExpression       : return booleanType
			EqualityBinaryExpression     : return booleanType
			RelationalBinaryExpression   : return booleanType
			LogicalAssociativeExpression : return booleanType
			QuantifiedLogicalExpression  : return booleanType

			LiteralIntegerExpression : return integerType
			LiteralRationalExpression: return rationalType

			LiteralFloatExpression: return floatType
			LiteralRealExpression : return realType

			LiteralCharacterExpression : return characterType

			LiteralStringExpression : return stringType

			LiteralReferenceElement: {
				val element = e.value
				switch( element ) {
					PropertyDefinition : {
						switch( e.kind ) {
							case INDEX:
								return( element.type.typeOfCollectionElement )
							
							case PARAMETER: return element.type
							
							case FIELD: return element.type
							
							default: return element.type
						}
					}
					
					EnumerationType : return element

					InstanceMachine : return element.model

					Vertex : return( EcoreUtil2.getContainerOfType(
						element, typeof(Statemachine) ))

					System      : return element
					Statemachine: return element
					
					Behavior: return element.eContainer as Type
					
					Machine : return element

					default : return null
				}
			}

			ValueElementSpecification : {
				val element = e.element

				switch( element ) {
					PropertyDefinition : return element.type

					InstanceMachine : return element.model

					Vertex : return( EcoreUtil2.getContainerOfType(
						element, typeof(Statemachine) ))

					System      : return element
					Statemachine: return element

					Behavior: return( element.eContainer as Type )

					Machine : return element

					default : return null
				}

			}

			LeftHandSideExpression : return( e.lvalue.typeFor )

			LiteralThisExpression: {
				val machine = EcoreUtil2.getContainerOfType(e, typeof(Machine))

				switch( machine ) {
					System      : return machine
					Statemachine: return machine

					Behavior: return( machine.eContainer as Type )

					Machine : return machine

					default : return machine
				}
			}

			LiteralSelfExpression: {
				val machine = EcoreUtil2.getContainerOfType(e, typeof(Machine))

				switch( machine ) {
					System      : return machine
					Statemachine: return machine

					Behavior: return( machine.eContainer as Type )

					Machine : return machine

					default : return machine
				}
			}

			LiteralParentExpression: {
				val machine = EcoreUtil2.getContainerOfType(e, typeof(Machine))

				switch( machine ) {
					System : return if( e != machine ) { machine } else { null }

//					Statemachine: return machine.eContainer as Type
//					Behavior    : return machine.eContainer as Type

					Machine: return machine.eContainer as Type

					default: return machine
				}
			}

			LiteralSuperExpression: {
				val machine = EcoreUtil2.getContainerOfType(e, typeof(Machine))

				switch( machine ) {
					System : return if( e != machine ) { machine } else { null }

//					Statemachine: return( machine.eContainer as Type )
//					Behavior    : return( machine.eContainer as Type )

					Machine: return( machine.eContainer as Type )

					default: return machine
				}
			}

			LiteralSystemExpression:
				return( EcoreUtil2.getContainerOfType(e, typeof(System)) )

			LiteralEnvExpression:
				return( EcoreUtil2.getContainerOfType(e, typeof(System)) )

			LiteralNullExpression : return( e.type ?: anyNullType )
			
			ArithmeticUnaryExpression: return( e.operand.typeFor )
			
			ArithmeticAssociativeExpression: return( e.typeFor )

			default: return null
		}
	}

	def Type typeFor(ArithmeticAssociativeExpression exp) {
		var Type prevType = null

		for( operand : exp.operand ) {
			val operandType = operand.typeClassFor
			if( operandType !== null ) {
				if( prevType !== null ) {
					if( prevType.isConformant(operandType) ) {
						// prevType < operandType 
						prevType = operandType
					}
					else if( operandType.isConformant(prevType) ) {
						//!! NOTHING because operandType < prevType 
					}
					else {
						return null
					}
				}
				else {
					prevType = operandType
				}
			}
		}
		
		prevType
	}
	
	def Type typeFor(LeftHandSideExpression exp, String operator) {
		switch( operator ) {
			case "<=<": {
				exp.lvalue.typeFor?.typeOfCollectionElement
			}
			case "^=<": {
				exp.lvalue.typeFor?.typeOfCollectionElement
			}
			case "^=>": {
				exp.lvalue.typeFor?.typeOfCollectionElement
			}
			case ">=>": {
				exp.lvalue.typeFor?.typeOfCollectionElement
			}
			
			default: {
				exp.lvalue.typeFor
			}
		}
	}


	def containerOfTypes(EObject context,
		Class< ? extends EObject > type, Class< ? extends EObject > typeElse) {

		for( var it = context ; it !== null; it = it.eContainer()) {
			if( type.isInstance(it) || typeElse.isInstance(it) ) {
				return it
			}
		}

		return null;
	}



	def Type typeSpecifier(Type type) {
		switch( type ) {
			DataSupportedType : type.support.typeSpecifier

			DataTypeReference :  {
				if( type.typeref !== null ) {
					type.typeref.typeSpecifier
				}
				else if( type.support !== null ) {
					type.support.typeSpecifier
				}
				else {
					type
				}
			}

			default: type
		}
	}

	def Type typeOfCollectionElement(Type type) {
		switch( type ) {
			CollectionType : type.support

			DataTypeReference :  {
				if( type.multiplicity !== null ) {
					if( type.typeref !== null ) {
						type.typeref
					}
					else if( type.support !== null ) {
						type.support
					}
					else {
						type
					}
				}
				else if( type.typeref !== null ) {
					type.typeref.typeOfCollectionElement
				}
				else if( type.support !== null ) {
					type.support.typeOfCollectionElement
				}
				else {
					type
				}
			}

			default: type
		}
	}



	def boolean isStructured(Type type) {
		( type.typeSpecifier instanceof DataStructuredType )
	}

	def boolean isEnumeration(Type type) {
		( type.typeSpecifier instanceof EnumerationType )
	}


	def boolean isPrimitive(Type type) {
		switch( type ) {
			Machine : return false

			EnumerationType   : return( type.literal.empty )

			DataSupportedType : return( type.support.isPrimitive )

			DataStructuredType: return( type.property.empty )

			DataTypeReference :  {
				if( type.typeref !== null ) {
					return( type.typeref.isPrimitive )
				}
				else if( type.support !== null ) {
					return( type.support.isPrimitive )
				}
				else {
					return true
				}
			}

			default: return true
		}
	}


	def Type expectedType(Expression e) {
		val eC = e.eContainer
		val eCF = e.eContainingFeature

		switch( eC ) {
			AssignmentExpression
			case eCF == exprPack.assignmentExpression_RigthHandSide :
				return( eC.leftHandSide.typeFor(eC.operator) )

			Variable
			case eCF == infraPack.propertyDefinition_DefaultValue :
				return( eC.type )

			SlotProperty
			case eCF == infraPack.slotProperty_Value :
				return( eC.xliaProperty.type )

			AbstractGuardStatement
			case eCF == stmntPack.abstractGuardStatement_Condition :
				return booleanType

			ConditionalBlockStatement
			case eCF == stmntPack.conditionalBlockStatement_Condition :
				return booleanType

			// TODO implementation
//			InvokeStatement case eCF == stmntPack.invokeStatement_Args : {
//				// assume that it refers to a routine/procedure and that there
//				// is a parameter corresponding to the argument
//				try {
//					val argIdx = (eC.args as MixTupleExpression).value.indexOf(e)
//					switch( eC.invokable ) {
//						case Routine: {
//							return null
//						}
//						case Procedure: {
//							return null
//						}
//						default: {
//							return null
//						}
//					}
//				}
//				catch (Throwable t) {
//					return null // otherwise there is no specific expected type
//				}
//			}
//			InvokeStatement case eCF == stmntPack.invokeStatement_Rets: {
//				// assume that it refers to a routine/procedure and that there
//				// is a parameter corresponding to the argument
//				try {
//					val argIdx = eC.rets.indexOf(e)
//					switch( eC.invokable ) {
//						case Routine: {
//							return null
//						}
//						case Procedure: {
//							return null
//						}
//						default: {
//							return null
//						}
//					}
//				}
//				catch (Throwable t) {
//					return null // otherwise there is no specific expected type
//				}
//			}
		}
	}


	def isConformant(Type actualType, Type expectedType) {
		if( actualType == expectedType ) {
			true
		}
		else if( actualType.class == expectedType.class )
		{
			if( actualType instanceof PrimitiveInstanceType ) {
				val expectedPIT = expectedType as PrimitiveInstanceType
				
				if( actualType.expected == expectedPIT.expected ) {
					(actualType.model == expectedPIT.model)
					|| (actualType.model === null)
					|| (expectedPIT.model === null)
				}
				else {
					(expectedPIT.expected == PrimitiveInstanceKind.ANY)
					|| (actualType.expected == PrimitiveInstanceKind.ANY)
				}
			}
			else {
				true
			}
		}
		else if( expectedType == stringType )
		{
			true
		}
		else switch( expectedType ) {
			case rationalType:
				(actualType == integerType)

			case floatType:
				(actualType == integerType ) ||
				(actualType == rationalType)

			case realType:
				(actualType == integerType ) ||
				(actualType == rationalType) ||
				(actualType == floatType)

			case timeType:
				(actualType == integerType ) ||
				(actualType == rationalType) ||
				(actualType == floatType)

			PrimitiveInstanceType: {
				switch( expectedType.expected ) {
					case MACHINE: {
						(actualType instanceof Machine)
					}
					default: {
						false
					}
				}
			}
			
			default : false
		}
	}


}