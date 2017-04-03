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
import org.eclipse.efm.ecore.formalml.statemachine.State
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

class FormalMLTypeProvider {

	val exprPack = ExpressionPackage::eINSTANCE

	val infraPack = InfrastructurePackage::eINSTANCE

	val stmntPack = StatementPackage::eINSTANCE


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
		DatatypeFactory::eINSTANCE.createPrimitiveStringType
		=> [name = 'AnyNullType']



	def Type typeClass(Type type) {
		switch( type ) {
			PrimitiveBooleanType   : booleanType
			PrimitiveIntegerType   : integerType
			PrimitiveRationalType  : rationalType
			PrimitiveFloatType     : floatType
			PrimitiveRealType      : realType
			PrimitiveCharacterType : characterType
			PrimitiveStringType    : stringType

			PrimitiveTimeType      : {
				type.support?.typeClass ?: timeType
			}

			IntervalType      : {
				type.support?.typeClass ?: type
			}

			DataTypeReference : {
				if( type.multiplicity === null ) {
					if( type.support !== null ) {
						type.support.typeClass
					}
					else if( type.typeref !== null ) {
						type.typeref.typeClass
					}
					else {
						type
					}
				}
				else {
					type
				}
			}

			default: type
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
			LiteralBooleanExpression     : booleanType
			LogicalUnaryExpression       : booleanType
			EqualityBinaryExpression     : booleanType
			RelationalBinaryExpression   : booleanType
			LogicalAssociativeExpression : booleanType

			LiteralIntegerExpression : integerType
			LiteralRationalExpression: rationalType

			LiteralFloatExpression: floatType
			LiteralRealExpression : realType

			LiteralCharacterExpression : characterType

			LiteralStringExpression : stringType


			LiteralReferenceElement: {
				val element = e.value
				switch( element ) {
					PropertyDefinition : {
						switch( e.kind ) {
							case INDEX:  element.type.typeOfCollectionElement
							
							case PARAMETER: element.type
							
							case FIELD: element.type
							
							default: element.type
						}
					}
					
					EnumerationType : element

					InstanceMachine : element.model

					System : element
					Statemachine : element
					State : EcoreUtil2.getContainerOfType(
						element, typeof(Statemachine) )

					Behavior : element.eContainer as Type
					Machine : element

					default: null
				}
			}


			ValueElementSpecification : {
				val element = e.element

				switch( element ) {
					PropertyDefinition : element.type

					InstanceMachine : element.model

					System : element

					Statemachine : element

					State : EcoreUtil2.getContainerOfType(
						element, typeof(Statemachine) )

					Behavior : element.eContainer as Type

					Machine : element

					default: null
				}

			}

			LeftHandSideExpression : {
				e.lvalue.typeFor
			}


			LiteralThisExpression: {
				val machine = EcoreUtil2.getContainerOfType(e, typeof(Machine))

				switch( machine ) {
					System : machine

					Statemachine : machine

					Behavior : machine.eContainer as Type

					Machine : machine

					default: machine
				}
			}

			LiteralSelfExpression: {
				val machine = EcoreUtil2.getContainerOfType(e, typeof(Machine))

				switch( machine ) {
					System : machine

					Statemachine : machine

					Behavior : machine.eContainer as Type

					Machine : machine

					default: machine
				}
			}

			LiteralParentExpression: {
				val machine = EcoreUtil2.getContainerOfType(e, typeof(Machine))

				switch( machine ) {
					System : if( e != machine ) { machine } else { null }

					Statemachine : machine.eContainer as Type

					Behavior : machine.eContainer as Type

					Machine : machine.eContainer as Type

					default: machine
				}
			}

			LiteralSuperExpression: {
				val machine = EcoreUtil2.getContainerOfType(e, typeof(Machine))

				switch( machine ) {
					System : if( e != machine ) { machine } else { null }

					Statemachine : machine.eContainer as Type

					Behavior : machine.eContainer as Type

					Machine : machine.eContainer as Type

					default: machine
				}
			}

			LiteralSystemExpression: {
				EcoreUtil2.getContainerOfType(e, typeof(System))
			}

			LiteralEnvExpression: {
				EcoreUtil2.getContainerOfType(e, typeof(System))
			}

			LiteralNullExpression : anyNullType
			
			ArithmeticUnaryExpression: e.operand.typeFor
			
			ArithmeticAssociativeExpression: e.typeFor

			default: null
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
			Machine : false

			EnumerationType   : type.literal.empty

			DataSupportedType : type.support.isPrimitive

			DataStructuredType: type.property.empty

			DataTypeReference :  {
				if( type.typeref !== null ) {
					type.typeref.isPrimitive
				}
				else if( type.support !== null ) {
					type.support.isPrimitive
				}
				else {
					true
				}
			}

			default: true
		}
	}


	def Type expectedType(Expression e) {
		val eC = e.eContainer
		val eCF = e.eContainingFeature

		switch( eC ) {
			AssignmentExpression
			case eCF == exprPack.assignmentExpression_RigthHandSide :
				eC.leftHandSide.typeFor

			Variable
			case eCF == infraPack.propertyDefinition_DefaultValue :
				eC.type

			SlotProperty
			case eCF == infraPack.slotProperty_Value :
				eC.xliaProperty.type

			AbstractGuardStatement
			case eCF == stmntPack.abstractGuardStatement_Condition :
				booleanType

			ConditionalBlockStatement
			case eCF == stmntPack.conditionalBlockStatement_Condition :
				booleanType

			// TODO implementation
//			InvokeStatement case eCF == stmntPack.invokeStatement_Args : {
//				// assume that it refers to a routine/procedure and that there
//				// is a parameter corresponding to the argument
//				try {
//					val argIdx = (eC.args as MixTupleExpression).value.indexOf(e)
//					switch( eC.invokable ) {
//						case Routine: {
//							null
//						}
//						case Procedure: {
//							null
//						}
//						default: {
//							null
//						}
//					}
//				}
//				catch (Throwable t) {
//					null // otherwise there is no specific expected type
//				}
//			}
//			InvokeStatement case eCF == stmntPack.invokeStatement_Rets: {
//				// assume that it refers to a routine/procedure and that there
//				// is a parameter corresponding to the argument
//				try {
//					val argIdx = eC.rets.indexOf(e)
//					switch( eC.invokable ) {
//						case Routine: {
//							null
//						}
//						case Procedure: {
//							null
//						}
//						default: {
//							null
//						}
//					}
//				}
//				catch (Throwable t) {
//					null // otherwise there is no specific expected type
//				}
//			}
		}
	}


	def isConformant(Type actualType, Type expectedType) {
		if( actualType == expectedType ) {
			true
		}
		else if( actualType.class == expectedType.class ) {
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