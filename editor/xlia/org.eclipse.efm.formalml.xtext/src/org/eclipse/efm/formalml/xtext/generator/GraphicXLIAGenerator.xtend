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
package org.eclipse.efm.formalml.xtext.generator

import org.eclipse.efm.ecore.formalml.common.NamedElement
import org.eclipse.efm.ecore.formalml.common.Type
import org.eclipse.efm.ecore.formalml.common.VisibilityKind
import org.eclipse.efm.ecore.formalml.datatype.ChoiceType
import org.eclipse.efm.ecore.formalml.datatype.CollectionType
import org.eclipse.efm.ecore.formalml.datatype.DataStructuredType
import org.eclipse.efm.ecore.formalml.datatype.DataType
import org.eclipse.efm.ecore.formalml.datatype.DataTypeReference
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType
import org.eclipse.efm.ecore.formalml.datatype.IntervalType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveBooleanType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveCharacterType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveFloatType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveIntegerType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRationalType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRealType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType
import org.eclipse.efm.ecore.formalml.datatype.StructureType
import org.eclipse.efm.ecore.formalml.datatype.UnionType
import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression
import org.eclipse.efm.ecore.formalml.expression.AssociativeExpression
import org.eclipse.efm.ecore.formalml.expression.BinaryExpression
import org.eclipse.efm.ecore.formalml.expression.CastExpression
import org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression
import org.eclipse.efm.ecore.formalml.expression.Expression
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPostfixExpression
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPrefixExpression
import org.eclipse.efm.ecore.formalml.expression.InstantiationExpression
import org.eclipse.efm.ecore.formalml.expression.InvokeExpression
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralAnyOrNoneValueExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralAnyValueExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralNoneValueExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralOptionalValueExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement
import org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralTimeDeltaExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralTimeExpression
import org.eclipse.efm.ecore.formalml.expression.MixTupleExpression
import org.eclipse.efm.ecore.formalml.expression.NamedExpression
import org.eclipse.efm.ecore.formalml.expression.NamedTupleExpression
import org.eclipse.efm.ecore.formalml.expression.NewfreshExpression
import org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression
import org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression
import org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression
import org.eclipse.efm.ecore.formalml.expression.UnaryExpression
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior
import org.eclipse.efm.ecore.formalml.infrastructure.Buffer
import org.eclipse.efm.ecore.formalml.infrastructure.Channel
import org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind
import org.eclipse.efm.ecore.formalml.infrastructure.ComPoint
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind
import org.eclipse.efm.ecore.formalml.infrastructure.Connector
import org.eclipse.efm.ecore.formalml.infrastructure.ConnectorEnd
import org.eclipse.efm.ecore.formalml.infrastructure.DesignKind
import org.eclipse.efm.ecore.formalml.infrastructure.Function
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfComputation
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction
import org.eclipse.efm.ecore.formalml.infrastructure.Modifier
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet
import org.eclipse.efm.ecore.formalml.infrastructure.Port
import org.eclipse.efm.ecore.formalml.infrastructure.Procedure
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition
import org.eclipse.efm.ecore.formalml.infrastructure.Route
import org.eclipse.efm.ecore.formalml.infrastructure.Routine
import org.eclipse.efm.ecore.formalml.infrastructure.Signal
import org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty
import org.eclipse.efm.ecore.formalml.infrastructure.Variable
import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem
import org.eclipse.efm.ecore.formalml.specification.XliaModel
import org.eclipse.efm.ecore.formalml.statemachine.FinalState
import org.eclipse.efm.ecore.formalml.statemachine.Pseudostate
import org.eclipse.efm.ecore.formalml.statemachine.Region
import org.eclipse.efm.ecore.formalml.statemachine.StartState
import org.eclipse.efm.ecore.formalml.statemachine.State
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine
import org.eclipse.efm.ecore.formalml.statemachine.Transition
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoc
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe
import org.eclipse.efm.ecore.formalml.statement.ActivityStatement
import org.eclipse.efm.ecore.formalml.statement.BlockStatement
import org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement
import org.eclipse.efm.ecore.formalml.statement.DoWhileStatement
import org.eclipse.efm.ecore.formalml.statement.EventGuardStatement
import org.eclipse.efm.ecore.formalml.statement.ExpressionStatement
import org.eclipse.efm.ecore.formalml.statement.ForEachStatement
import org.eclipse.efm.ecore.formalml.statement.ForStatement
import org.eclipse.efm.ecore.formalml.statement.GuardStatement
import org.eclipse.efm.ecore.formalml.statement.IfStatement
import org.eclipse.efm.ecore.formalml.statement.InputComStatement
import org.eclipse.efm.ecore.formalml.statement.InterruptStatement
import org.eclipse.efm.ecore.formalml.statement.InvokeStatement
import org.eclipse.efm.ecore.formalml.statement.MetaStatement
import org.eclipse.efm.ecore.formalml.statement.OutputComStatement
import org.eclipse.efm.ecore.formalml.statement.Statement
import org.eclipse.efm.ecore.formalml.statement.TimedGuardStatement
import org.eclipse.efm.ecore.formalml.statement.WhileDoStatement
import org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType

class GraphicXLIAGenerator {
	
//	def static testSerializer() {
//		val xliaModel = FormalmlFactory.eINSTANCE.createXliaModel();
//
//		val system = InfrastructureFactory.eINSTANCE.createXliaSystem();
//		system.setName("MySystem");
//
//		xliaModel.setSystem(system);
//		
//		println( generateModel(xliaModel) )
//	}

	
//	def static serializeXlia(IPath filePath, XliaModel xliaModel) {
//		XliaModel xliaModel = FormalmlFactory.eINSTANCE.createXliaModel();
//
//		XliaSystem system = InfrastructureFactory.eINSTANCE.createXliaSystem();
//		system.setName("MySystem");
//
//		xliaModel.setSystem(system);
//		
////		FormalMLGenerator fmlGen = new FormalMLGenerator();
////		fmlGen.doGenerate(xliaModel, fsa, context);
//
//		// Code Generator
//		Injector injector = new FormalMLStandaloneSetup().createInjectorAndDoEMFRegistration();
//		
//		// obtain a resourceset from the injector
//		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
//
//		URI uriFile = URI.createFileURI("my_model.xlia");
//		resourceSet.getResource(uriFile, true);
//
//		//val injector = Guice.createInjector(new  FormalMLRuntimeModule())
//		//val serializer = injector.getInstance(typeof(Serializer))
//		//val s = serializer.serialize(model)
//		//println(s)			
//
//		GeneratorDelegate generator = injector.getInstance(GeneratorDelegate.class);
//		InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
//		generator.doGenerate(xliaModel.getSystem().eResource(), fsa);
//		
//		for (Entry<String, CharSequence> file : fsa.getTextFiles().entrySet()) {
//		  java.lang.System.out.println("Generated file path : " + file.getKey());
//		  java.lang.System.out.println("Generated file contents : " + file.getValue());
//		}
//	}

	
	
	///////////////////////////////////////////////////////////////////////////
	// Utils
	///////////////////////////////////////////////////////////////////////////
	
	def static namesOf(NamedElement element)
	'''«element.name»«IF element.unrestrictedName !== null» «element.unrestrictedName»«ENDIF»'''
	
	def static keyword(String kwd)
	'''**<color blue>«kwd»</color>**'''
	
	///////////////////////////////////////////////////////////////////////////
	// XliaModel
	///////////////////////////////////////////////////////////////////////////
	
	def static generateModel(XliaModel xliaModel)
	'''
		@fml< system , 1.0 >:
		
		«IF xliaModel.system !== null»«generateSystem(xliaModel.system)»«ENDIF»
	'''


	def static generateSystem(XliaSystem xliaSystem)
	'''
		system «namesOf(xliaSystem)» {
			«generateBody(xliaSystem)»
		}
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Machine / Behavior Body
	///////////////////////////////////////////////////////////////////////////
	
	def static CharSequence generateBody(Machine machine)
	'''
	@property:
		«FOR it : machine.typedef»
			«generateProperty(it)»
		«ENDFOR»
		«FOR it : machine.channel»
			«generateProperty(it)»
		«ENDFOR»
		«FOR it : machine.port»
			«generateProperty(it)»
		«ENDFOR»
		«FOR it : machine.signal»
			«generateProperty(it)»
		«ENDFOR»
		«FOR it : machine.buffer»
			«generateProperty(it)»
		«ENDFOR»
		«FOR it : machine.function»
			«generateProperty(it)»
		«ENDFOR»
		«FOR it : machine.variable»
			«generateProperty(it)»
		«ENDFOR»
	«IF ! machine.routine.empty»
	@routine:
		«FOR it : machine.routine»
			«generateRoutine(it)»
		«ENDFOR»
	«ENDIF»
	«IF ! machine.procedure.empty»
	@procedure:
		«FOR it : machine.procedure»
			«generateProcedure(it)»
		«ENDFOR»
	«ENDIF»
	«IF ! machine.machine.empty»
	@composite:
		«FOR it : machine.machine»
			«generate(it)»

		«ENDFOR»
	«ENDIF»
	«IF ! machine.instance.empty»
	@instance:
		«FOR it : machine.instance»
			«generateInstance(it)»
		«ENDFOR»
	
	«ENDIF»
	«IF ! machine.behavior.empty»
	@behavior:
		«FOR it : machine.behavior»
			«generate(it)»
		«ENDFOR»
	«ENDIF»
	«IF machine.main !== null»
		«generateMainBehavior(machine.main)»
	«ENDIF»
	'''
	
	def static generateBody(Behavior behavior)
	'''
	«IF ! behavior.parameter.empty»@parameter:
		«FOR it : behavior.parameter»
			«generateProperty(it)»
		«ENDFOR»
	«ENDIF»
	«generateBody(behavior as Machine)»
	'''
	
	def static generateMainBehavior(Behavior behavior)
	'''
		«generateBehaviorMOC(behavior.computation)»
		«generateBehaviorMOI(behavior.interaction)»
		«generateBehaviorMOE(behavior.execution)»
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Machine DataType attributes
	///////////////////////////////////////////////////////////////////////////
	
	def static dispatch typeID(Type type)
	'''«IF (type !== null)»«IF type.name !== null»«type.name»«ELSE»«strOfAnonym(type)»«ENDIF»«ELSE»type<null>«ENDIF»'''
	
	def static dispatch CharSequence typeID(DataType type)
	'''«IF (type !== null)»«IF type.name !== null»«type.name»«ELSE»«strOfAnonym(type)»«multiplicityOf(type)»«ENDIF»«ELSE»datatype<null>"«ENDIF»'''
	
	
	def static dispatch strOfAnonym(Type type)
	'''anonym#type< «type» >'''
	
	def static multiplicityOf(DataType type)
	'''«IF type.multiplicity !== null»[«generateExpression(type.multiplicity)»]«ENDIF»'''
	

	def static dispatch strOfAnonym(PrimitiveBooleanType type)
	'''boolean'''
	
	
	def static strOfAnonym(PrimitiveNumberType type, String fullname, String quickname)
	'''«IF type.sign.value > 0»u«ENDIF»«IF type.size > 0»«quickname»:«type.size»«ELSEIF type.name !== null»«type.name»«ELSE»«fullname»«ENDIF»'''
	
	def static dispatch strOfAnonym(PrimitiveIntegerType type)
	'''«strOfAnonym(type, "int", "integer")»'''
	
	def static dispatch strOfAnonym(PrimitiveRationalType type)
	'''«strOfAnonym(type, "rat", "rational")»'''
	
	
	def static strOfAnonym(PrimitiveNumberType type, String name)
	'''«IF type.sign.value > 0»u«ENDIF»«name»«IF type.size > 0»:«type.size»«ENDIF»'''
	
	def static dispatch strOfAnonym(PrimitiveFloatType type)
	'''«strOfAnonym(type, "float")»'''
	
	def static dispatch strOfAnonym(PrimitiveRealType type)
	'''«strOfAnonym(type, "real")»'''
	
	def static dispatch strOfAnonym(PrimitiveTimeType type)
	'''«IF type.clock»clock«ELSE»time«ENDIF»«IF type.support !== null»< «typeID(type.support)» >«ENDIF»'''
	

	def static dispatch strOfAnonym(PrimitiveCharacterType type)
	'''char'''
	
	def static dispatch strOfAnonym(PrimitiveStringType type)
	'''string«IF type.size > 0»<size: «type.size»>«ENDIF»'''
	
	
	def static dispatch strOfAnonym(DataTypeReference type)
	'''«IF type.typeref !== null»«typeID(type.typeref)»«ELSEIF type.support !== null»«typeID(type.support)»«ENDIF»«multiplicityOf(type)»'''
	
	def static dispatch strOfAnonym(CollectionType type)
	'''«type.container»<«IF type.support !== null»«typeID(type.support)»«IF type.size >= 0», «ENDIF»«ENDIF»«IF type.size >= 0»size: «type.size»«ENDIF»>'''
	
	
	def static dispatch strOfAnonym(PrimitiveInstanceType type)
	'''«type.expected.literal»«IF type.model !== null»<model: «type.model.name»>«ENDIF»'''
	
	///////////////////////////////////////////////////////////////////////////
	// DataType Definition	
	def static dispatch generateProperty(DataTypeReference type)
	'''
		type «namesOf(type)» «IF type.support !== null»«typeID(type.support)»«ELSEIF type.typeref !== null»«typeID(type.typeref)»«ENDIF»«multiplicityOf(type)»;
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// DataType EnumerationType	
	def static dispatch generateProperty(EnumerationType enumerationType)
	'''
		type «namesOf(enumerationType)» enum {
			«FOR it : enumerationType.literal SEPARATOR ","»
				«generateLiteral(it)»
			«ENDFOR»
		}
	''' 
	
	def static generateLiteral(EnumerationLiteral literal)
	'''«namesOf(literal)»«IF literal.value !== null» = value«ENDIF»''' 
	
	///////////////////////////////////////////////////////////////////////////
	// DataType Structured Type	
	def static generateDataStructuredType(DataStructuredType dataStructuredType, String kwType)
	'''
		«generateVisibility(dataStructuredType)»type «namesOf(dataStructuredType)» «kwType» {
			«FOR it : dataStructuredType.property»
				«generateProperty(it)»
			«ENDFOR»
		}
	''' 
	
	def static generateTypeProperty(PropertyDefinition property)
	'''«namesOf(property)»«IF property.defaultValue !== null» = «generateExpression(property.defaultValue)»«ENDIF»''' 
	
		
	def static dispatch generateProperty(StructureType type)
	'''
		«generateDataStructuredType(type, "struct")»
	'''
	
	def static dispatch generateProperty(UnionType type)
	'''
		«generateDataStructuredType(type, "union")»
	'''
	
	def static dispatch CharSequence generateProperty(ChoiceType type)
	'''
		«generateDataStructuredType(type, "choice")»
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// visibility
	def static generateVisibility(NamedElement element)
	'''«IF element.visibility !== VisibilityKind.PROTECTED»«element.visibility.literal» «ENDIF»'''
	
	///////////////////////////////////////////////////////////////////////////
	// modifier
	def static generateModifier(Modifier modifier)
	'''«IF modifier !== null»«IF modifier.static»static «ENDIF»«IF modifier.final»final «ENDIF»«IF modifier.reference »ref «ENDIF»«IF modifier.volatile»volatile «ENDIF»«IF modifier.transient»transient «ENDIF»«IF modifier.optional»optional «ENDIF»«ENDIF»'''
		
	///////////////////////////////////////////////////////////////////////////
	// Machine : modifier / specifier / feature / design
	def static generateSpecifier(Machine machine)
	'''«IF machine.input_enabled»input_enabled «ENDIF»«IF machine.timed»timed «ENDIF»«IF machine.dense_timed »dense_timed «ENDIF»«IF machine.discrete_timed»discrete_timed «ENDIF»«IF machine.unsafe»unsafe «ENDIF»«IF machine.lifeline»lifeline «ENDIF»«IF machine.design !== DesignKind.PROTOTYPE»«machine.design.literal» «ENDIF»'''
		
	
	///////////////////////////////////////////////////////////////////////////
	// DataType	Collection Type
	def static dispatch generateProperty(CollectionType type)
	'''
		CollectionType
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// DataType	Interval Type
	def static dispatch generateProperty(IntervalType type)
	'''
		IntervalType
	'''
	
	
	///////////////////////////////////////////////////////////////////////////
	// DataType	Instance Type
	def static dispatch generateProperty(PrimitiveInstanceType type)
	'''
		«generateVisibility(type)»type «namesOf(type)» «type.expected.literal»«IF type.model !== null»<model: «type.model.name»>«ENDIF»;
	'''
	
	
	///////////////////////////////////////////////////////////////////////////
	// Machine Parameter / Variable attributes
	///////////////////////////////////////////////////////////////////////////
	def static generateParameter(Parameter parameter)
	'''«typeID(parameter.type)»«IF parameter.name !== null» «parameter.name»«ENDIF»«IF parameter.defaultValue !== null» = «generateExpression(parameter.defaultValue)»«ENDIF»'''
	
	
	def static dispatch generateProperty(Parameter parameter)
	'''
		«generateVisibility(parameter)»«parameter.direction.literal» parameter «typeID(parameter.type)» «namesOf(parameter)»;
	'''
	
	def static dispatch generateProperty(Variable variable)
	'''
		«generateVisibility(variable)»«generateModifier(variable.modifier)»var «typeID(variable.type)» «namesOf(variable)»«IF variable.defaultValue !== null» = «generateExpression(variable.defaultValue)»«ENDIF»;
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Machine Communication attributes
	///////////////////////////////////////////////////////////////////////////
	
	def static dispatch generateProperty(Channel channel)
	'''
		«generateVisibility(channel)»channel «typeID(channel.type)» «namesOf(channel)»;
	'''
	
	def static dispatch generateProperty(Port port)
	'''
		«generateVisibility(port)»port «port.direction.literal» «namesOf(port)»«generateParameterSet(port.parameterSet)»;
	'''
	
	def static dispatch generateProperty(Signal signal)
	'''
		«generateVisibility(signal)»signal «namesOf(signal)»«generateParameterSet(signal.parameterSet)»;
	'''
	
	def static dispatch generateProperty(Buffer buffer)
	'''
		«generateVisibility(buffer)»buffer «typeID(buffer.type)» «namesOf(buffer)»;
	'''
	
	// UTILS
	def static generateParameterSet(ParameterSet parameterSet)
	'''«IF (parameterSet !== null) && (! parameterSet.parameter.empty)»(«FOR it : parameterSet.parameter SEPARATOR ", "»«generateParameter(it)»«ENDFOR»)«ENDIF»'''
	
	
	
	///////////////////////////////////////////////////////////////////////////
	// Machine Function attributes
	///////////////////////////////////////////////////////////////////////////
	
	def static dispatch generateProperty(Function function)
	'''
		«generateVisibility(function)»function «namesOf(function)»«generateParameterSet(function.parameterSet)»->«generateParameterSet(function.resultSet)»;
	'''
	
	
	///////////////////////////////////////////////////////////////////////////
	// Machine composite Routine
	///////////////////////////////////////////////////////////////////////////

	def static generateRoutine(Routine routine)
	'''
		«generateVisibility(routine)»«IF routine.macro»macro «ENDIF»routine «namesOf(routine)»«generateParameterSet(routine.parameterSet)» «generateBlockStatement(routine.bodyBlock)»
		}
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Machine composite Procedure
	///////////////////////////////////////////////////////////////////////////

	def static generateProcedure(Procedure procedure)
	'''
		«generateVisibility(procedure)»«generateSpecifier(procedure)»procedure «namesOf(procedure)» {
		}
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Machine composite Instance
	///////////////////////////////////////////////////////////////////////////

	def static generateInstance(InstanceMachine instance)
	'''
		«generateVisibility(instance)»«generateModifier(instance.modifier)»instance< «instance.model.name» > «namesOf(instance)» {
			«FOR it : instance.slot»
				«it.xliaProperty.name» = «generateExpression(it.value)»;
			«ENDFOR»
		}
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Machine composite Machine+
	///////////////////////////////////////////////////////////////////////////

	def static dispatch generate(Machine machine)
	'''
		«generateVisibility(machine)»«generateSpecifier(machine)»machine «namesOf(machine)» {
			«generateBody(machine)»
		}
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Machine composite Statemachine
	///////////////////////////////////////////////////////////////////////////

	def static dispatch generate(Statemachine statemachine)
	'''
		«generateVisibility(statemachine)»«generateSpecifier(statemachine)»statemachine «namesOf(statemachine)» {
			«generateBody(statemachine)»
			«FOR it : statemachine.region»
				«generateRegion(it)»
			«ENDFOR»
		}
	'''
	
	def static CharSequence generateRegion(Region region)
	'''
«««		@state:
		@region:
			«FOR it : region.vertex»
				«generateState(it)»
			«ENDFOR»
	'''
	
	def static dispatch generateState(State state)
	'''
		state «namesOf(state)» {
			«generateStateMOE(state.moe)»
			«FOR it : state.region»
				«generateRegion(it)»
			«ENDFOR»
			«FOR it : state.transition»
				«generateTransition(it)»
			«ENDFOR»
		}
	'''
	
	def static dispatch generateState(FinalState state)
	'''
		state< final > «namesOf(state)» {
			«generateStateMOE(state.moe)»
			«FOR it : state.transition»
				«generateTransition(it)»
			«ENDFOR»
		}
	'''
	
	def static dispatch generateState(StartState state)
	'''
		state< start > «namesOf(state)» {
			«generateStateMOE(state.moe)»
			«FOR it : state.transition»
				«generateTransition(it)»
			«ENDFOR»
		}
	'''
	
	def static dispatch generateState(Pseudostate state)
	'''
		state< «state.kind.literal» > «namesOf(state)» {
			«generateStateMOE(state.moe)»
			«FOR it : state.transition»
				«generateTransition(it)»
			«ENDFOR»
		}
	'''
	
	def static generateStateMOE(ModelOfExecution moe)
	'''
		«IF moe !== null»
			«generateActivityRoutine(moe.createRoutine, "create")»
			«generateActivityRoutine(moe.initRoutine, "init")»
			«generateActivityRoutine(moe.finalRoutine, "final")»
			«generateActivityRoutine(moe.enableRoutine, "enable")»
			«generateActivityRoutine(moe.disableRoutine, "disable")»
			«generateActivityRoutine(moe.concurrencyRoutine, "concurrency")»
			«generateActivityRoutine(moe.scheduleRoutine, "schedule")»
			«generateActivityRoutine(moe.irunRoutine, "irun")»
			«generateActivityRoutine(moe.runRoutine, "run")»
			«FOR it : moe.routine»«generateRoutine(it)»«ENDFOR»
		«ENDIF»
	'''
	
	def static generateTransition(Transition transition)
	'''
		«generateTransitionModifier(transition)»transition«generateTransitionMoe(transition.moe)» «namesOf(transition)»«IF transition.target !== null» --> «transition.target.name»«ELSEIF transition.targetExpression !== null» --> «generateExpression(transition.targetExpression)»«ENDIF» «generateBlockStatement(transition.behavior)»
		}
	'''
	
	def static generateTransitionModifier(Transition transition)
	'''«IF transition.isTransient»transient «ENDIF»'''
	
	def static generateTransitionMoe(TransitionMoe moe)
	'''«IF moe !== null»<«IF moe.moc !== TransitionMoc.SIMPLE» «moe.moc.literal»«ENDIF»«IF moe.isIsElse» else«ENDIF»«IF moe.priority > 0» prior: «moe.priority»«ENDIF» >«ENDIF»'''
	
	
	///////////////////////////////////////////////////////////////////////////
	// Machine composite Behavior
	///////////////////////////////////////////////////////////////////////////

	def static dispatch generate(Behavior behavior)
	'''
		behavior «namesOf(behavior)» {
			«generateBody(behavior)»
		}
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Behavior ModelOfInteraction
	///////////////////////////////////////////////////////////////////////////

	def static generateBehaviorMOI(ModelOfInteraction moi)
	'''
		«IF moi !== null»
		@com:
			«FOR it : moi.routes»
				«generateRoute(it)»
			«ENDFOR»
			«FOR it : moi.connectors»
				«generateConnector(it)»
			«ENDFOR»
		«ENDIF»
	'''
	
	def static generateRoute(Route route)
	'''
		route«generateComProtocolIf(route.protocol)» «namesOf(route)» [«FOR it : route.signals SEPARATOR ", "»«generateComSignal(it)»«ENDFOR»];'''
	
	def static generateComSignal(Signal signal)
	'''«signal.name»'''
		
	def static generateConnector(Connector connector)
	'''
		connector«generateComProtocolIf(connector.protocol)» «namesOf(connector)» {
			«FOR it : connector.connectorEnd»
				«generateConnectorEnd(it)»
			«ENDFOR»
		}
	'''
	
	def static generateConnectorEnd(ConnectorEnd connectorEnd)
	'''
		«connectorEnd.direction.literal»«generateComProtocolIf(connectorEnd.protocol)» «IF connectorEnd.points.size == 1»«generateComPoint(connectorEnd.points.get(0))»;«ELSE»[«FOR it : connectorEnd.points SEPARATOR ", "»«generateComPoint(it)»«ENDFOR»]«ENDIF»
	'''	
	
	def static generateComPoint(ComPoint comPoint)
	'''«IF comPoint.machine !== null»«comPoint.machine.name»->«ENDIF»«IF comPoint.port !== null»«comPoint.port.name»«ELSE»port<null>«ENDIF»'''	
	
	def static generateComProtocolIf(ComProtocol comProtocol)
	'''«IF comProtocol !== null»«generateComProtocol(comProtocol)»«ENDIF»'''
	
	def static generateComProtocol(ComProtocol comProtocol)
	'''«IF comProtocol.protocol !== ComProtocolKind.NONE»< «comProtocol.protocol.literal»«IF comProtocol.protocol === ComProtocolKind.BUFFER»: «generateComBuffer(comProtocol)»«ENDIF»«IF comProtocol.cast !== ComCastKind.NONE» , «comProtocol.cast.literal»«ENDIF» >«ELSEIF comProtocol.cast !== ComCastKind.NONE»< «comProtocol.cast.literal» >«ELSEIF comProtocol.inner_buffer !== null»< «generateComBuffer(comProtocol)» >«ENDIF»'''
	
	def static generateComBuffer(ComProtocol comProtocol)
	'''«IF comProtocol.buffer !== null»«generateExpression(comProtocol.buffer)»«ELSEIF comProtocol.inner_buffer !== null»«typeID(comProtocol.inner_buffer)»«ENDIF»'''
	
	
	
	///////////////////////////////////////////////////////////////////////////
	// Behavior v
	///////////////////////////////////////////////////////////////////////////

	def static generateBehaviorMOC(ModelOfComputation moc)
	'''
		«IF moc !== null»
		@moc:
		«ENDIF»
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Behavior ModelOfExecution
	///////////////////////////////////////////////////////////////////////////

	def static generateBehaviorMOE(ModelOfExecution moe)
	'''
		«IF moe !== null»
		@moe:
			«generateActivityRoutine(moe.createRoutine, "create")»
			«generateActivityRoutine(moe.initRoutine, "init")»
			«generateActivityRoutine(moe.finalRoutine, "final")»
			«generateActivityRoutine(moe.enableRoutine, "enable")»
			«generateActivityRoutine(moe.disableRoutine, "disable")»
			«generateActivityRoutine(moe.concurrencyRoutine, "concurrency")»
			«generateActivityRoutine(moe.scheduleRoutine, "schedule")»
			«generateActivityRoutine(moe.irunRoutine, "irun")»
			«generateActivityRoutine(moe.runRoutine, "run")»
			«FOR it : moe.routine»«generateRoutine(it)»«ENDFOR»
		«ENDIF»
	'''
	
	def static generateActivityRoutine(Routine routine, String name)
	'''
		«IF routine !== null»
		@«name»«generateParameterSet(routine.parameterSet)» «generateBlockStatement(routine.bodyBlock)»
		}
		«ENDIF»
	'''
	
	///////////////////////////////////////////////////////////////////////////
	// Statement
	///////////////////////////////////////////////////////////////////////////

	def static dispatch generateStatement(Statement statement)
	'''«keyword("Statement<")» «statement» «keyword(">;")»'''
	
	
	def static dispatch generateStatement(ExpressionStatement statement)
	'''
		«generateStatementExpression(statement.expression)»
	'''
	
	def static dispatch generateStatementExpression(Expression expression)
	'''
		«generateExpression(expression)»;
	'''
	
	def static dispatch generateStatementExpression(AssignmentExpression expression)
	'''«generateExpression(expression.leftHandSide)» «keyword(expression.operator)» «generateExpression(expression.rightHandSide)»«keyword(";")»'''
	
	
	def static CharSequence generateBlockStatement(BlockStatement block)
	'''«IF block !== null»«IF block.op !== null»«keyword("{")»«keyword(block.op)»«ELSE»«keyword("{")»«ENDIF»
	«FOR it : block.statement»
	«generateStatement(it)»
	«ENDFOR»
	«ELSE»«keyword("{")»«ENDIF»
	'''
	
	def static dispatch generateStatement(BlockStatement block)
	'''
		«IF block.op !== null»«keyword("{")»«keyword(block.op)»«ELSE»«keyword("{")»«ENDIF»
			«FOR it : block.statement»
				«generateStatement(it)»
			«ENDFOR»
		«keyword("}")»
	'''
	
	def static dispatch generateStatement(GuardStatement statement)
	'''
		«keyword("guard")» «generateExpression(statement.condition)»«keyword(";")»
	'''
	
	def static dispatch generateStatement(TimedGuardStatement statement)
	'''
		«keyword("tguard")» «generateExpression(statement.condition)»«keyword(";")»
	'''
	
	def static dispatch generateStatement(EventGuardStatement statement)
	'''
		«keyword("event")» «generateExpression(statement.condition)»«keyword(";")»
	'''
	
	def static dispatch CharSequence generateStatement(CheckSatGuardStatement statement)
	'''
		«keyword("checksat<")» «statement.solver» «keyword(">")» «generateExpression(statement.condition)»«keyword(";")»
	'''
	
	
	def static dispatch generateStatement(InputComStatement statement)
	'''
		«keyword("input")» «generateExpression(statement.port)»«IF ! statement.leftValue.empty»(«FOR it : statement.leftValue SEPARATOR ", "»«generateExpression(it)»«ENDFOR»)«ENDIF»«generateExpressionIf(" <-- ", statement.target)»«IF statement.route !== null» <== «statement.route.name»«ENDIF»«keyword(";")»
	'''
	
	def static dispatch generateStatement(OutputComStatement statement)
	'''
		«keyword("output")» «generateExpression(statement.port)»«IF ! statement.rightValue.empty»(«FOR it : statement.rightValue SEPARATOR ", "»«generateExpression(it)»«ENDFOR»)«ENDIF»«generateExpressionIf(" --> ", statement.target)»«IF statement.route !== null» ==> «statement.route.name»«ENDIF»«keyword(";")»
	'''
	
	
	def static dispatch generateStatement(IfStatement statement)
	'''
		«keyword("if")» «generateExpression(statement.condition)» «generateBlockStatement(statement.bodyBlock)»
		«keyword("}")»
		«FOR it : statement.elseifStatement»
		«keyword("elseif")» «generateExpression(it.condition)» «generateBlockStatement(it.bodyBlock)»
		«keyword("}")»
		«ENDFOR»
		«IF statement.elseBlock !== null»
		«keyword("else")» «generateBlockStatement(statement.elseBlock)»
		«keyword("}")» «ENDIF»
	'''
	
	def static dispatch generateStatement(WhileDoStatement statement)
	'''
		«keyword("while")» «generateExpression(statement.condition)» «generateBlockStatement(statement.bodyBlock)»
		«keyword("}")»
	'''
	
	def static dispatch generateStatement(DoWhileStatement statement)
	'''
		«keyword("do")» «generateBlockStatement(statement.bodyBlock)»
		«keyword("}")» «keyword("while")» «generateExpression(statement.condition)»;
	'''
	
	def static dispatch generateStatement(ForStatement statement)
	'''
		«keyword("for(")» «generateExpression(statement.init)» ; «generateExpression(statement.condition)» «keyword(";")» «generateExpression(statement.iterate)» «keyword(")")» «generateBlockStatement(statement.bodyBlock)»
		«keyword("}")»
	'''
	
	def static dispatch generateStatement(ForEachStatement statement)
	'''
		«keyword("for(")» «generateExpression(statement.iterator)» :  «generateExpression(statement.enumeration)» «keyword(")")» «generateBlockStatement(statement.bodyBlock)»
		«keyword("}")»
	'''
	
	def static dispatch generateStatement(InterruptStatement statement)
	'''
		«statement.kind.literal»«IF ! statement.expr.empty»«FOR it : statement.expr SEPARATOR " , "»«generateExpression(it)»«ENDFOR»«ENDIF»«keyword(";")»
	'''
	
	def static dispatch generateStatement(ActivityStatement statement)
	'''
		«keyword(statement.op.literal)»«IF statement.machine !== null» «generateExpression(statement.machine)»«ENDIF»«IF statement.tuple !== null»«keyword("(")» «generateExpression(statement.tuple)» «keyword(")")»«ENDIF»«keyword(";")»
	'''
	
	
	def static dispatch generateStatement(InvokeStatement statement)
	'''
		«IF statement.expression !== null»«generateExpression(statement.expression)»;
		«ELSE»
			«IF statement.callProcedure»«keyword("call")» «ENDIF»«statement.invokable.name»«keyword("(")»«IF statement.args !== null»«generateExpression(statement.args)»«ENDIF»«keyword(")")»«IF ! statement.rets.empty» «keyword("-->")» «FOR it : statement.rets SEPARATOR ", "»«it.name»«ENDFOR»)«ENDIF»;
		«ENDIF»
	'''
	
	
	def static dispatch generateStatement(MetaStatement statement)
	'''
		@«statement.op» {
			«FOR it : statement.operand»
				«IF it instanceof Statement»«generateStatement(it)»
				«ELSEIF it instanceof Expression»«generateExpression(it as Expression)»
				«ELSE»«keyword("MetaStatement< operand:")» «it» «keyword(">;")»«ENDIF»
			«ENDFOR»
		}
	'''
	

	///////////////////////////////////////////////////////////////////////////
	// Expression
	///////////////////////////////////////////////////////////////////////////

	def static generateExpressionIf(String prefix, Expression expression)
	'''«IF expression !== null»«prefix»«generateExpression(expression)»«ENDIF»'''

	def static generateExpressionIf(Expression expression, String suffix)
	'''«IF expression !== null»«generateExpression(expression)»«suffix»«ENDIF»'''

	def static generateExpressionIf(Expression expression)
	'''«IF expression !== null»«generateExpression(expression)»«ENDIF»'''


	def static dispatch generateExpression(Expression expression)
	'''Expression< «expression» >'''
	
	def static dispatch generateExpression(LiteralBooleanExpression expression)
	'''«expression.value»'''
	
	def static dispatch generateExpression(LiteralIntegerExpression expression)
	'''«expression.value»'''
	
	def static dispatch generateExpression(LiteralRationalExpression expression)
	'''«expression.numerator»«IF expression.denominator !== 1»/«expression.denominator»«ENDIF»'''
	
	def static dispatch generateExpression(LiteralFloatExpression expression)
	'''«expression.value»'''
	
	def static dispatch generateExpression(LiteralRealExpression expression)
	'''«expression.value»'''
	
	
	def static dispatch generateExpression(LiteralCharacterExpression expression)
	'''"«expression.value»"'''
	
	def static dispatch generateExpression(LiteralStringExpression expression)
	'''"«expression.value.replace("\n", "\\n").replace("\t", "\\t").replace("\"", "\\\"")»"'''
	
	
	def static dispatch generateExpression(LiteralCollectionExpression expression)
	'''«IF expression.datatype !== null»<«typeID(expression.datatype)»>«ENDIF»{ «FOR it : expression.value SEPARATOR ", "»«generateExpression(it)»«ENDFOR» }'''
	
	
	def static dispatch generateExpression(LiteralNullExpression expression)
	'''«keyword("$null")»<«typeID(expression.type)»>'''
	
	def static dispatch generateExpression(LiteralAnyValueExpression expression)
	'''«keyword("$any")»<«typeID(expression.type)»>'''
	
	def static dispatch generateExpression(LiteralOptionalValueExpression expression)
	'''«keyword("$optional<")»«typeID(expression.type)»«keyword(">")»'''
	
	def static dispatch generateExpression(LiteralNoneValueExpression expression)
	'''«keyword("$none<")»«typeID(expression.type)»«keyword(">")»'''
	
	def static dispatch generateExpression(LiteralAnyOrNoneValueExpression expression)
	'''«keyword("$any$none<")»«typeID(expression.type)»«keyword(">")»'''
	
	
	def static dispatch generateExpression(LiteralThisExpression expression)
	'''«keyword("$this")»'''
	
	def static dispatch generateExpression(LiteralSelfExpression expression)
	'''«keyword("$self")»«IF expression.model !== null»«keyword("<")»«expression.model.name»«keyword(">")»«ENDIF»'''
	
	def static dispatch generateExpression(LiteralParentExpression expression)
	'''«keyword("$parent")»«IF expression.model !== null»«keyword("<")»«expression.model.name»«keyword(">")»«ENDIF»'''
	
	def static dispatch generateExpression(LiteralSuperExpression expression)
	'''«keyword("$super")»«IF expression.model !== null»«keyword("<")»«expression.model.name»«keyword(">")»«ENDIF»'''
	
	
	def static dispatch generateExpression(LiteralSystemExpression expression)
	'''«keyword("$system")»'''
	
	def static dispatch CharSequence generateExpression(LiteralEnvExpression expression)
	'''«keyword("$env")»'''
	
	def static dispatch generateExpression(LiteralTimeExpression expression)
	'''«keyword("$time")»'''
	
	def static dispatch generateExpression(LiteralTimeDeltaExpression expression)
	''''«keyword("$delta")»'''
	
	
	def static dispatch generateExpression(LeftHandSideExpression expression)
	'''«generateExpression(expression.lvalue)»'''
	
	def static dispatch generateExpression(IncrementOrDecrementPrefixExpression expression)
	'''«keyword(expression.operator)»«generateExpression(expression.leftHandSide)»'''
	
	def static dispatch generateExpression(IncrementOrDecrementPostfixExpression expression)
	'''«generateExpression(expression.leftHandSide)»«keyword(expression.operator)»'''
	
	
	def static dispatch generateExpression(AssignmentExpression expression)
	'''(«generateExpression(expression.leftHandSide)» «keyword(expression.operator)» «generateExpression(expression.rightHandSide)»)'''
	
	def static dispatch generateExpression(NewfreshExpression expression)
	'''«keyword("newfresh(")» «generateExpression(expression.leftHandSide)» «keyword(")")»'''
	
	
	def static dispatch generateExpression(UnaryExpression expression)
	'''(«keyword(expression.operator)» «generateExpression(expression.operand)»)'''
	
	def static dispatch generateExpression(CastExpression expression)
	'''«keyword("ctor<")»«typeID(expression.datatype)»«keyword(">(")»«generateExpression(expression.operand)»«keyword(")")»'''
	
	
	def static dispatch generateExpression(BinaryExpression expression)
	'''(«generateExpression(expression.leftOperand)» «keyword(expression.operator)» «generateExpression(expression.rightOperand)»)'''
	
	
	def static dispatch generateExpression(RelationalTernaryExpression expression)
	'''(«generateExpression(expression.leftRelation)» «expression.rightOperator» «generateExpression(expression.rightOperand)»)'''
	
	
	def static dispatch generateExpression(ConditionalTestExpression expression)
	'''(«generateExpression(expression.condition)» «keyword(expression.operator)» «generateExpression(expression.thenOperand)» «expression.elseSeparator» «generateExpression(expression.elseOperand)»)'''
	
	
	def static dispatch generateExpression(AssociativeExpression expression)
	'''(«FOR it : expression.operand SEPARATOR " " + keyword(expression.operator) + " "»«generateExpression(it)»«ENDFOR»)'''
	
	def static dispatch generateExpression(LogicalAssociativeExpression expression)
	'''(«FOR it : expression.operand SEPARATOR "\n\t" + keyword(expression.operator) + " "»«generateExpression(it)»«ENDFOR»)'''
	
	
	def static dispatch generateExpression(QuantifiedLogicalExpression expression)
	'''(«expression.quantifier»<«FOR it : expression.variable SEPARATOR ", "»«it.name» : «typeID(it.type)»«ENDFOR»>«generateExpression(expression.predicate)»)'''
	
	
	def static dispatch generateExpression(InvokeExpression expression)
	'''«generateExpression(expression.invokable)»(«FOR it : expression.args SEPARATOR ", "»«generateExpression(it)»«ENDFOR»)«IF ! expression.rets.empty»-->«FOR it : expression.rets SEPARATOR ", "»«generateExpression(it)»«ENDFOR»«ENDIF»'''
	
	
	def static dispatch generateExpression(NamedExpression expression)
	'''«expression.name» : «generateExpression(expression.expression)»)'''
	
	
	def static dispatch generateExpression(MixTupleExpression expression)
	'''«FOR it : expression.value SEPARATOR ", "»«generateExpression(it)»«ENDFOR»'''
	
	def static dispatch generateExpression(NamedTupleExpression expression)
	'''«FOR it : expression.value SEPARATOR ", "»«generateExpression(it)»«ENDFOR»'''
	
	def static dispatch generateExpression(PositionalTupleExpression expression)
	'''«FOR it : expression.value SEPARATOR ", "»«generateExpression(it)»«ENDFOR»'''
	
	
	def static dispatch generateExpression(LiteralReferenceElement expression)
	'''«IF expression.element !== null»«expression.element.name»«ELSE»null<LiteralReferenceElement.element>«ENDIF»«IF expression.arg !== null»«IF expression.kind === ValueElementSpecificationKind.FIELD».«generateExpression(expression.arg)»«ELSEIF expression.kind === ValueElementSpecificationKind.INDEX»[«generateExpression(expression.arg)»]«ELSE»(«generateExpression(expression.arg)»)«ENDIF»«ENDIF»'''
	
	
	def static dispatch generateExpression(ValueElementSpecification expression)
	'''«IF expression.parent !== null»«generateExpression(expression.parent)»«IF expression.kind === ValueElementSpecificationKind.FIELD».«expression.element.name»«ELSEIF expression.kind === ValueElementSpecificationKind.INDEX»[«generateExpression(expression.arg)»]«ELSE»(«generateExpression(expression.arg)»)«ENDIF»«ELSE»«expression.element.name»«IF expression.kind === ValueElementSpecificationKind.FIELD»«ELSEIF expression.kind === ValueElementSpecificationKind.INDEX»[«generateExpression(expression.arg)»]«ELSE»(«generateExpression(expression.arg)»)«ENDIF»«ENDIF»'''
	
	
	def static dispatch generateExpression(InstantiationExpression expression)
	''''«keyword("new")» «namesOf(expression.instance.model)»«generateSlot(expression.instance)»'«keyword(".")»'''
	
	def static generateSlot(InstanceMachine instance)
	'''«IF ! instance.slot.empty»(«FOR it : instance.slot SEPARATOR ", "»«generateSlot(it)»«ENDFOR»)«ENDIF»'''
		
	def static generateSlot(SlotProperty slot)
	'''«typeID(slot.xliaProperty.type)» «slot.xliaProperty.name»«IF slot.value !== null» = «generateExpression(slot.value)»«ENDIF»'''
		
}