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
package org.eclipse.efm.formalml.xtext.validation

import com.google.inject.Inject
import org.eclipse.efm.ecore.formalml.common.CommonPackage
import org.eclipse.efm.ecore.formalml.common.NamedElement
import org.eclipse.efm.ecore.formalml.common.Type
import org.eclipse.efm.ecore.formalml.datatype.CollectionType
import org.eclipse.efm.ecore.formalml.datatype.DataType
import org.eclipse.efm.ecore.formalml.expression.ArithmeticAssociativeExpression
import org.eclipse.efm.ecore.formalml.expression.ArithmeticUnaryExpression
import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression
import org.eclipse.efm.ecore.formalml.expression.BinaryExpression
import org.eclipse.efm.ecore.formalml.expression.BitwiseAssociativeExpression
import org.eclipse.efm.ecore.formalml.expression.BitwiseUnaryExpression
import org.eclipse.efm.ecore.formalml.expression.Expression
import org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression
import org.eclipse.efm.ecore.formalml.expression.LogicalUnaryExpression
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior
import org.eclipse.efm.ecore.formalml.infrastructure.Buffer
import org.eclipse.efm.ecore.formalml.infrastructure.Channel
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet
import org.eclipse.efm.ecore.formalml.infrastructure.Port
import org.eclipse.efm.ecore.formalml.infrastructure.Procedure
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition
import org.eclipse.efm.ecore.formalml.infrastructure.Routine
import org.eclipse.efm.ecore.formalml.infrastructure.Signal
import org.eclipse.efm.ecore.formalml.infrastructure.Variable
import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem
import org.eclipse.efm.formalml.xtext.typing.FormalMLTypeProvider
import org.eclipse.xtext.validation.Check

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class FormalMLValidator extends AbstractFormalMLValidator {

	@Inject extension FormalMLTypeProvider

//	@Inject extension IQualifiedNameProvider

//  public static val INVALID_NAME = 'invalidName'
//
//	@Check
//	def checkGreetingStartsWithCapital(Greeting greeting) {
//		if( ! Character.isUpperCase(greeting.name.charAt(0)) ) {
//			warning('Name should start with a capital',
//					MyDslPackage.Literals.GREETING__NAME,
//					INVALID_NAME)
//		}
//	}


	public static val DUPLICATE_DECLARATION =
		"org.eclipse.efm.formalml.xtext.DuplicateDeclaration"

	public static val INCOMPATIBLE_TYPES =
		 "org.eclipse.efm.formalml.xtext.IncompatibleTypes"


	public static val NAME_NULL = "org.example.system.name";


	def checkNoDuplicateDeclarationInBlock(NamedElement decl,
		Iterable<? extends NamedElement> collection, String clazz) {
//		val declName = decl.fullyQualifiedName

		if( (decl.name !== null)
			&& collection.exists[ it != decl && (it.name == decl.name) ] )
		{
			error("Duplicate " + clazz + " '" + decl.name + "'",
				CommonPackage::eINSTANCE.namedElement_Name,
				 DUPLICATE_DECLARATION)
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(Machine decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).machine, "machine")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(DataType decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).typedef, "typedef")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(PropertyDefinition decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).variable, "variable")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(Channel decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).channel, "channel")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(Port decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).port, "port")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(Signal decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).signal, "signal")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(Buffer decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).buffer, "buffer")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(Routine decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).routine, "routine")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(Procedure decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).procedure, "procedure")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(InstanceMachine decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).instance, "instance")
		}
	}

	@Check
	def checkNoDuplicateDeclarationInMachine(Behavior decl) {
		if( decl.eContainer instanceof Machine ) {
			checkNoDuplicateDeclarationInBlock(decl,
				(decl.eContainer as Machine).behavior, "behavior")
		}
	}


	@Check
	def checkNoDuplicateDeclarationInBehavior(Parameter decl) {
		val container = decl.eContainer
		switch( container ) {
			Behavior: checkNoDuplicateDeclarationInBlock(decl,
				container.parameter, "parameter")

			ParameterSet: checkNoDuplicateDeclarationInBlock(decl,
				container.parameter, "parameter")
		}
	}




	@Check
	def checkClassHierarchy(XliaSystem system) {
		if ( system.name === null) {
			error("system.name === null",
				CommonPackage::eINSTANCE.namedElement_Name,
				NAME_NULL, system.name)
		}
	}


//	@Check
//	def checkNoDuplicateDeclarationInBehavior(Connection connection) {
//		val container = decl.eContainer
//		switch( container ) {
//			Behavior: checkNoDuplicateDeclarationInBlock(decl,
//				container.parameter, "parameter")
//
//			Routine: checkNoDuplicateDeclarationInBlock(decl,
//				container.parameter, "parameter")
//
//			ParameterSet: checkNoDuplicateDeclarationInBlock(decl,
//				container.parameter, "parameter")
//		}
//	}



////////////////////////////////////////////////////////////////////////////////
// check Compatible Types in Binary Expression
////////////////////////////////////////////////////////////////////////////////

	@Check
	def void checkCompatibleTypes(BinaryExpression exp) {
		val leftType = exp.leftOperand.typeClassFor
		val rightType = exp.rightOperand.typeClassFor
		if( (leftType === null) || (rightType === null) ) {
			return; // nothing to check
		}
		else if( ! rightType.isConformant(leftType) ) {
			if( (exp.operator == "in") && (rightType instanceof CollectionType) )
			{
				val rightTypeSupport = (rightType as CollectionType).support
				
				if( ! rightTypeSupport.isConformant(leftType) )
				{
					error("<BinaryExpression> Incompatible types. Expected '"
							+ leftType.name + "' but was '" + rightTypeSupport.name + "'",
							null, INCOMPATIBLE_TYPES);
				}
			}
			else {
				error("<BinaryExpression> Incompatible types. Expected '"
						+ leftType.name + "' but was '" + rightType.name + "'",
						null, INCOMPATIBLE_TYPES);
			}
		}
	}


////////////////////////////////////////////////////////////////////////////////
// check Compatible Types in Logical Expression
////////////////////////////////////////////////////////////////////////////////

	@Check
	def void checkCompatibleTypes(LogicalUnaryExpression exp) {
		val operandType = exp.operand.typeClassFor
		if( operandType !== null ) {
			if( ! operandType.isConformant(FormalMLTypeProvider.booleanType) ) {
				error("<LogicalUnaryExpression> Incompatible types. Expected '"
						+ FormalMLTypeProvider.booleanType.name
						+ "' but was '" + operandType.name + "'",
						null, INCOMPATIBLE_TYPES);
			}
		}
	}

	@Check
	def void checkCompatibleTypes(LogicalAssociativeExpression exp) {
		for( operand : exp.operand ) {
			val operandType = operand.typeClassFor
			if( operandType !== null ) {
				if( ! operandType.isConformant(FormalMLTypeProvider.booleanType) ) {
					error("<LogicalAssociativeExpression> "
							+ "Incompatible types. Expected '"
							+ FormalMLTypeProvider.booleanType.name
							+ "' but was '" + operandType.name + "'",
							null, INCOMPATIBLE_TYPES);
				}
			}
		}
	}


////////////////////////////////////////////////////////////////////////////////
// check Compatible Types in Arithmetic Expression
////////////////////////////////////////////////////////////////////////////////

	@Check
	def void checkCompatibleTypes(ArithmeticUnaryExpression exp) {
		val operandType = exp.operand.typeClassFor
		if( operandType !== null ) {
			if( ! operandType.isConformant(FormalMLTypeProvider.realType) ) {
				error("<ArithmeticUnaryExpression> "
						+ "Incompatible types. Expected '"
						+ FormalMLTypeProvider.realType.name
						+ "' but was '" + operandType.name + "'",
						null, INCOMPATIBLE_TYPES);
			}
		}
	}

	@Check
	def void checkCompatibleTypes(ArithmeticAssociativeExpression exp) {
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
						// operandType < prevType 
						//!! NOTHING
					}
					else {
						error("Incompatible types between '"
								+ prevType.name + "' and '"
								+ operandType.name + "'",
								null, INCOMPATIBLE_TYPES);
					}
				}
				else {
					prevType = operandType
				}
			}
		}
	}


////////////////////////////////////////////////////////////////////////////////
// check Compatible Types in Bitwise Expression
////////////////////////////////////////////////////////////////////////////////

	@Check
	def void checkCompatibleTypes(BitwiseUnaryExpression exp) {
		val operandType = exp.operand.typeClassFor
		if( operandType !== null ) {
			if( ! operandType.isConformant(FormalMLTypeProvider.integerType) ) {
				error("<BitwiseUnaryExpression> Incompatible types. Expected '"
						+ FormalMLTypeProvider.integerType.name
						+ "' but was '" + operandType.name + "'",
						null, INCOMPATIBLE_TYPES);
			}
		}
	}

	@Check
	def void checkCompatibleTypes(BitwiseAssociativeExpression exp) {
		for( operand : exp.operand ) {
			val operandType = operand.typeClassFor
			if( operandType !== null ) {
				if( ! operandType.isConformant(FormalMLTypeProvider.integerType) ) {
					error("<BitwiseAssociativeExpression> "
							+ "Incompatible types. Expected '"
							+ FormalMLTypeProvider.integerType.name
							+ "' but was '" + operandType.name + "'",
							null, INCOMPATIBLE_TYPES);
				}
			}
		}
	}


////////////////////////////////////////////////////////////////////////////////
// check Compatible Types in Expression
////////////////////////////////////////////////////////////////////////////////

	@Check
	def void checkCompatibleTypes(Expression exp) {
		val actualType = exp.typeClassFor
		val expectedType = exp.expectedTypeClass
		
		if( (expectedType === null) || (actualType === null) ) {
			return; // nothing to check
		}
		else if( ! actualType.isConformant(expectedType) ) {
			var isnotConformant = true
			
			val eC = exp.eContainer
			if( (eC instanceof AssignmentExpression)
				|| (eC instanceof Variable) )
			{
				val expectedElementType = expectedType.typeOfCollectionElement
					
				isnotConformant = ( (expectedElementType === null)
					|| (expectedElementType == expectedType) 
					|| (! actualType.isConformant(expectedElementType) ) )
			}
			
			if( isnotConformant ) {
				error("<Expression> Incompatible types. Expected '" 
						+ expectedType.name
						+ "' but was '" + actualType.name + "'",
						null, INCOMPATIBLE_TYPES);
			}
		}
	}



//	@Check
//	def void checkMethodInvocationArguments(Routine sel) {
//		if (sel.member !== null && sel.member instanceof SJMethod) {
//			val method = sel.member as SJMethod
//			if (method.params.size != sel.args.size) {
//				error(
//					"Invalid number of arguments. The method " + method.memberAsStringWithType +
//					" is not applicable for the arguments " + sel.argsTypesAsStrings,
//					SmallJavaPackage::eINSTANCE.SJMemberSelection_Member,
//					INVALID_ARGS
//				)
//			}
//		}
//	}



}
