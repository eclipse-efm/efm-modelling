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
package org.eclipse.efm.formalml.xtext.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.efm.ecore.formalml.XliaModel
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine
import org.eclipse.efm.ecore.formalml.statemachine.Region
import org.eclipse.efm.ecore.formalml.statemachine.State
import org.eclipse.efm.ecore.formalml.statemachine.Pseudostate
import org.eclipse.efm.ecore.formalml.statemachine.Vertex
import org.eclipse.efm.ecore.formalml.statemachine.StartState
import org.eclipse.efm.ecore.formalml.statemachine.FinalState
import org.eclipse.efm.ecore.formalml.statemachine.Transition
import org.eclipse.emf.common.util.EList
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement
import org.eclipse.efm.ecore.formalml.common.NamedElement
import org.eclipse.efm.ecore.formalml.statemachine.StatemachineFactory
import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem
import org.eclipse.efm.ecore.formalml.statement.BlockStatement
import org.eclipse.efm.ecore.formalml.infrastructure.Routine
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoe
import org.eclipse.efm.ecore.formalml.statemachine.TransitionMoc
import org.eclipse.efm.ecore.formalml.statement.InvokeStatement
import org.eclipse.efm.ecore.formalml.statement.ExpressionStatement
import org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement
import org.eclipse.efm.ecore.formalml.statement.AbstractComStatement
import org.eclipse.efm.ecore.formalml.statement.ActivityStatement
import org.eclipse.efm.ecore.formalml.statement.InterruptStatement
import org.eclipse.efm.ecore.formalml.statement.Statement
import org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression
import org.eclipse.core.runtime.IPath

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class FormalMLGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val model = resource.contents.filter(XliaModel).head
		if (model !== null) {
			
//val injector = Guice.finalInjector(new  FormalMLRuntimeModule())
//val serializer = injector.getInstance(typeof(Serializer))
//val s = serializer.serialize(model)
//println(s)			
			
			val filename = 
				if( (resource.URI !== null) && (! resource.URI.segments.isEmpty) )
					'/' + resource.URI.segments.last + '.puml'
				else '/statemachine_' + resource.hashCode + '.puml'

			fsa.generateFile(filename, generateModelGraphic(model))

//			val xliaFilename = 
//				if( (resource.URI !== null) && (! resource.URI.segments.isEmpty) )
//					'/' + resource.URI.segments.last + '.xlia'
//				else '/statemachine_' + resource.hashCode + '.xlia'
//
//			fsa.generateFile(xliaFilename, XLIAGenerator.generateModel(model))
			
//			fsa.generateFile('/hidden.txt', '''This is an additional generator artifact.''')
		}
	}
	
	
	def generateModelGraphic(XliaModel model)
	'''
		@startuml
		
		skinparam backgroundColor White
		
		skinparam state {
			StartColor Green
			EndColor Red
		
			'Attribut pour les transitions
			ArrowColor Black
			ArrowColor<< Else >> Orange
		
			'Attribut par défaut pour les états
			BorderColor Gray
			BackgroundColor Wheat
		
			'Attribut pour les états composites
			BackgroundColor<< System       >> Turquoise
			BackgroundColor<< Statemachine >> DodgerBlue
			BackgroundColor<< Machine      >> SpringGreen
			BackgroundColor<< Instance     >> Orchid
			BackgroundColor<< Composite    >> SpringGreen
		
			'Attribut pour les états simples
			BackgroundColor<< simple_hierarchic >> PaleTurquoise
			BackgroundColor<< simple >> PaleTurquoise
			BackgroundColor<< start  >> Green
			BackgroundColor<< final >> Red
			BackgroundColor<< sync   >> Aqua
		
			'Attribut pour les pseudo-états
			BackgroundColor<< pseudostate >> Lavender
			BackgroundColor<< initial     >> GreenYellow
			BackgroundColor<< junction    >> GreenYellow
			BackgroundColor<< choice      >> Orange
			BackgroundColor<< fork        >> SpringGreen
			BackgroundColor<< junction    >> SpringGreen
			BackgroundColor<< dhistory    >> SpringGreen
			BackgroundColor<< shistory    >> SpringGreen
			BackgroundColor<< return      >> OrangeRed
			BackgroundColor<< terminal    >> Red
		
			FontColor Black
			FontName Times
			FontSize 14
		}
			
		«generateMachineGraphic(model.system)»
			
		@enduml
	'''
	
	def modifier(Machine machine)
	'''«IF machine.input_enabled»input_enabled «ENDIF»«IF machine.dense_timed»dense_timed «ELSEIF machine.discrete_timed»discrete_timed «ELSEIF machine.timed»timed «ENDIF»'''
	
	
	def dispatch generateMachineGraphic(XliaSystem system)
	'''	
		«generateMachineRoutineGraphic(system)»
		state "**«modifier(system)»system** «system.nameOf»" as «system.nameIdOf» << System >> {
			«generateMachineContentGraphic(system)»
		}
	'''
	
	def CharSequence generateMachineContentGraphic(Machine machine)
	'''	
		«FOR itMachine : machine.machine»
			«generateMachineGraphic(itMachine)»
			--
		«ENDFOR»
		«FOR itBehavior : machine.behavior»
			«generateMachineGraphic(itBehavior)»
			--
		«ENDFOR»
		«FOR itInstance : machine.instance»
			«generateInstanceGraphic(itInstance)»
			--
		«ENDFOR»
		«IF machine.main !== null»«generateBehaviorGraphic(machine.main)»«ENDIF»
	'''
	
	def generateMachineRoutineGraphic(Machine machine)
	'''	
		«IF (! machine.routine.empty)»
		note top of «machine.nameIdOf»
		«FOR it : machine.routine»
			«generateRoutineGraphic(it)»
		«ENDFOR»
		end note
		
		«ENDIF»
	'''

	def generateRoutineGraphic(Routine routine)
	'''	
		**«routine.name»«generateRoutineParameterSet(routine.parameterSet)»:** «IF (routine.bodyBlock !== null) && (! routine.bodyBlock.statement.empty)»«IF routine.bodyBlock.op !== null»«routine.bodyBlock.op»«ENDIF»
		«FOR it : routine.bodyBlock.statement»
			«XLIAGenerator.generateStatement(it)»
		«ENDFOR»
		«ENDIF»
	'''

	def static generateRoutineParameterSet(ParameterSet parameterSet)
	'''«IF (parameterSet !== null) && (! parameterSet.parameter.empty)»(«FOR it : parameterSet.parameter SEPARATOR ", "»«it.name»«ENDFOR»)«ENDIF»'''

	def generateBehaviorGraphic(Behavior behavior)
	'''	
		«generateMoeGraphic(behavior, behavior.execution)»
		«IF behavior.hasCompositeBehavior»
		state "main behavior" as «behavior.nameIdOf» {
			«generateMachineContentGraphic(behavior)»
		}
		«ENDIF»
		
«««		«IF behavior instanceof Statemachine»«generateGraphic(behavior as Statemachine)»
«««		«ELSE»state "Behavior «behavior.nameOf»" as «behavior.nameIdOf» {
«««			«generateBodyGraphic(behavior)»
«««		}
«««		«ENDIF»
	'''
	
	def hasCompositeBehavior(Behavior behavior) {
		return( (! behavior.machine.empty ) || (! behavior.behavior.empty)
			 || (! behavior.instance.empty) || (behavior.main !== null) )
	}
	
	def generateMoeGraphic(NamedElement container, ModelOfExecution moe)
	'''	
		«IF moe.hasPrimitive»
			note top of «container.nameIdOf»
				«generateActivityRoutine(moe.createRoutine, "create")»
				«generateActivityRoutine(moe.initRoutine, "init")»
				«generateActivityRoutine(moe.finalRoutine, "final")»
				«generateActivityRoutine(moe.enableRoutine, "enable")»
				«generateActivityRoutine(moe.disableRoutine, "disable")»
				«generateActivityRoutine(moe.concurrencyRoutine, "concurrency")»
				«generateActivityRoutine(moe.scheduleRoutine, "schedule")»
				«generateActivityRoutine(moe.irunRoutine, "irun")»
				«generateActivityRoutine(moe.runRoutine, "run")»
			end note
		«ENDIF»
	'''

	def hasPrimitive(ModelOfExecution moe) {
		return( (moe !== null)
			 && (  (moe.runRoutine !== null)
				|| (moe.irunRoutine !== null)
				|| (moe.scheduleRoutine !== null)
				|| (moe.enableRoutine !== null)
				|| (moe.disableRoutine !== null)
				|| (moe.initRoutine !== null)
				|| (moe.finalRoutine !== null)
				|| (moe.createRoutine !== null)
				|| (moe.concurrencyRoutine !== null)) )
	}


	def hasStatement(Routine routine) {
		return( (routine !== null) && (routine.bodyBlock !== null)
			&& (routine.bodyBlock.statement !== null)
			&& (! routine.bodyBlock.statement.empty) )
	}
	
	def generateActivityRoutine(Routine routine, String name)
	'''
		«IF routine.hasStatement»
		**«name»:**
		«FOR it : routine.bodyBlock.statement»
			«XLIAGenerator.generateStatement(it)»
		«ENDFOR»
		«ENDIF»
	'''
	
//	def isSingleLineActivityRoutine(Routine routine) {
//		return( (routine !== null) && (routine.bodyBlock !== null)
//			&& (routine.bodyBlock.statement.size == 1)
//			&& isSingleLineStatement( routine.bodyBlock.statement.get(0) ) )
//	}
//	
//	def isSingleLineStatement(Statement statement) {
//		switch( statement ) {
//			ExpressionStatement : return true
//			
//			AbstractGuardStatement: return
//				(! (statement.condition instanceof LogicalAssociativeExpression))
//				
//			AbstractComStatement: return true
//			ActivityStatement   : return true
//			InvokeStatement     : return true
//			InterruptStatement  : return true
//			
//			default : return false
//		}
//	}
//	
//	def generateSingleLineRoutine(
//		NamedElement container, Routine routine, String name)
//	'''
//		«nameIdOf(container)»: **@«name»:**
//		«nameIdOf(container)»: «XLIAGenerator.generateStatement(routine.bodyBlock.statement.get(0))»
//		
//	'''
//
//	def generateActivityRoutine(Routine routine, String name)
//	'''
//		**«name»:** «IF (routine.bodyBlock !== null) && (! routine.bodyBlock.statement.empty)»«IF routine.bodyBlock.op !== null»«routine.bodyBlock.op»«ENDIF»
//		«FOR it : routine.bodyBlock.statement»
//			«XLIAGenerator.generateStatement(it)»
//		«ENDFOR»
//		«ENDIF»
//	'''
	

	def generateInstanceGraphic(InstanceMachine instance)
	'''
		state "**«modifier(instance.model)»instance< «instance.model.name» >** «instance.nameOf»" as «instance.nameIdOf» << Instance >> {
		«FOR it : instance.slot»
			«instance.nameIdOf»: «it.xliaProperty.name» = «XLIAGenerator.generateExpression(it.value)»
		«ENDFOR»
		}
	'''	
	
	def dispatch generateMachineGraphic(Statemachine statemachine)
	'''	
		«generateMachineRoutineGraphic(statemachine)»
		state "**«modifier(statemachine)»statemachine** «statemachine.nameOf»" as «statemachine.nameIdOf» << Statemachine >> {
			«generateMachineContentGraphic(statemachine)»
			«generateRegionsGraphic(statemachine.region)»
		}
	'''
	
	def dispatch generateMachineGraphic(Machine machine)
	'''	
		«generateMachineRoutineGraphic(machine)»
		state "**«modifier(machine)»machine** «machine.nameOf»" as «machine.nameIdOf» << Machine >> {
			«generateMachineContentGraphic(machine)»
		}
	'''
	

	def CharSequence generateRegionsGraphic(EList<Region> regions)
	'''	
		«IF regions.size == 1 »
			«FOR itVertex : regions.head.vertex»
				«generateVertexGraphic(itVertex)»
			«ENDFOR»
		«ELSE»
		«FOR itRegion : regions»
			«generateRegionGraphic(itRegion)»
			--
		«ENDFOR»
		«ENDIF»
	'''	
	
	def generateRegionGraphic(Region region)
	'''	
		state "«IF region.name !== null»«region.name»«ELSE»anonym region"«ENDIF» as «region.nameIdOf» {
			«FOR itVertex : region.vertex»
				«generateVertexGraphic(itVertex)»
			«ENDFOR»
		}
	'''
	
	def dispatch generateVertexGraphic(Vertex vertex)
	'''	
		«generateMoeGraphic(vertex, vertex.moe)»
		state "Vertex «vertex.nameOf»" as «vertex.nameIdOf»
«««		«IF vertex instanceof StartState»
«««			«generateGraphic(vertex as StartState)»
«««		«ELSE»«IF vertex instanceof FinalState»
«««			«generateGraphic(vertex as FinalState)»
«««		«ELSE»«IF vertex instanceof State»
«««			«generateGraphic(vertex as State)»
«««		«ELSE»«IF vertex instanceof Pseudostate»
«««			«generateGraphic(vertex as Pseudostate)»
«««		«ELSE»
«««			state "Vertex «vertex.nameOf»" as «vertex.nameIdOf»
«««		«ENDIF»
«««		«ENDIF»
«««		«ENDIF»
«««		«ENDIF»
		«FOR itTransition : vertex.transition»
			«generateTransitionGraphic(itTransition)»
		«ENDFOR»
		
	'''
	
	def dispatch generateVertexGraphic(StartState state)
	'''	
		«generateMoeGraphic(state, state.moe)»
		state "«state.nameOf»" as «state.nameIdOf» << start >>
		«FOR itTransition : state.transition»
			«generateTransitionGraphic(itTransition)»
		«ENDFOR»
		
	'''
	
	def dispatch generateVertexGraphic(FinalState state)
	'''	
		«generateMoeGraphic(state, state.moe)»
		state "«state.nameOf»" as «state.nameIdOf» << final >>
		«FOR itTransition : state.transition»
			«generateTransitionGraphic(itTransition)»
		«ENDFOR»
		
	'''
	
	def dispatch generateVertexGraphic(State state)
	'''	
		«generateMoeGraphic(state, state.moe)»
		state "«state.nameOf»" as «state.nameIdOf» «IF state.region.empty»<< simple >>«ELSE»<< Composite >> {«ENDIF»
		«IF ! state.region.empty»
			«generateRegionsGraphic(state.region)»
		}
		«ENDIF»
		«FOR itTransition : state.transition»
			«generateTransitionGraphic(itTransition)»
		«ENDFOR»
		
	'''
	
	def dispatch generateVertexGraphic(Pseudostate pseudostate)
	'''	
		«generateMoeGraphic(pseudostate, pseudostate.moe)»
		state "«pseudostate.nameOf»" as «pseudostate.nameIdOf» << «pseudostate.kind.literal» >>
		«FOR itTransition : pseudostate.transition»
			«generateTransitionGraphic(itTransition)»
		«ENDFOR»
		
	'''
	
	def generateTransitionGraphic(Transition transition)
	'''	
		 «(transition.eContainer as Vertex).nameIdOf» --> «transition.targetVertex.nameIdOf»
		 note on link #white
		 	**«generateTransitionModifier(transition)»«transition.name»«generateTransitionMoe(transition.moe)»** «IF (transition.behavior !== null) && (! transition.behavior.statement.empty)»«IF transition.behavior.op !== null»«transition.behavior.op»«ENDIF»
	«FOR it : transition.behavior.statement»
	«XLIAGenerator.generateStatement(it)»
	«ENDFOR»
	«ELSE»

	«ENDIF»
		 end note
	'''
	
	def generateTransitionModifier(Transition transition)
	'''«IF transition.isTransient»transient «ENDIF»'''
	
	def generateTransitionMoe(TransitionMoe moe)
	'''«IF moe !== null»< «IF moe.moc !== TransitionMoc.SIMPLE»«moe.moc.literal» «ENDIF»«IF moe.isIsElse»else «ELSEIF moe.priority > 0»prior:«moe.priority» «ENDIF»«IF moe.probability < 1»proba:«moe.probability» «ENDIF»>«ENDIF»'''
	
	def static generateBlockStatement(BlockStatement block)
	'''«IF (block !== null) && (! block.statement.empty)»«IF block.op !== null»«block.op»«ELSE»|;|«ENDIF»
	«FOR it : block.statement»
	«XLIAGenerator.generateStatement(it)»
	«ENDFOR»
	«ENDIF»
	'''
	
	
	def targetVertex(Transition transition) {
		if( transition.target !== null ) {
		 	return( transition.target )
		}
		else if( transition.targetExpression instanceof LiteralReferenceElement ) {
		 	return (transition.targetExpression as LiteralReferenceElement).element
		}
		 
		val vertex = StatemachineFactory.eINSTANCE.createVertex()
		vertex.name =  "targetOf_" + transition.name
		return vertex
	}
	
	
	def nameOf(NamedElement element) {
		if( (element.unrestrictedName !== null) && (! element.unrestrictedName.empty) )
			element.unrestrictedName.substring(1, element.unrestrictedName.length-1)
		else if( (element.name !== null) && (! element.name.empty) ) element.name
		else "<<anonym>>"
	}
	
	def nameIdOf(NamedElement element)
	'''«IF (element.name === null)»«element.class.simpleName»«ELSE»«element.name.replaceAll('#', '_')»«ENDIF»_«element.hashCode»'''
	
	
}
