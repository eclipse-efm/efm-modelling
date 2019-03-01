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
package org.eclipse.efm.formalml.xtext.ui.outline

import com.google.inject.Inject
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.ui.IImageHelper
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
class FormalMLOutlineTreeProvider extends DefaultOutlineTreeProvider {

	@Inject
	IImageHelper imageHelper

	@Inject
	IQualifiedNameProvider nameProvider;


//	def _createChildren(DocumentRootNode parentNode, XliaModel xliaModel) {
//		// show a virtual node for the XLIA SYSTEM MODEL
////		createEStructuralFeatureNode(parentNode, xliaModel,
////			XliaPackage.Literals.XLIA_MODEL__SYSTEM,
////			imageHelper.getImage("fml/Package.gif"),
////			"XLIA SYSTEM MODEL", true);
//
//  		createNode(parentNode, xliaModel.system);
//	}


	def createNodeProperty(IOutlineNode parentNode, Machine machine) {
		if( ! machine.typedef.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__TYPEDEF,
				imageHelper.getImage("fml/DataType.gif"),
				"Typedefs", false);
		}

		if( ! machine.port.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__PORT,
				imageHelper.getImage("fml/Port.gif"),
				"Ports", false);
		}

		if( ! machine.signal.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__SIGNAL,
				imageHelper.getImage("fml/Signal.gif"),
				"Signals", false);
		}

		if( ! machine.channel.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__CHANNEL,
				imageHelper.getImage("fml/Signal.gif"),
				"Channels", false);
		}

		if( ! machine.buffer.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__BUFFER,
				imageHelper.getImage("fml/Property.gif"),
				"Buffers", false);
		}

		if( ! machine.variable.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__VARIABLE,
				imageHelper.getImage("fml/Variable.gif"),
				"Variables", false);
		}


		if( ! machine.routine.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__ROUTINE,
				imageHelper.getImage("fml/FunctionBehavior.gif"),
				"Routines", false);
		}

		if( ! machine.procedure.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__PROCEDURE,
				imageHelper.getImage("fml/FunctionBehavior.gif"),
				"Procedures", false);
		}


		if( ! machine.machine.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__MACHINE,
				imageHelper.getImage("fml/Diagram_CompositeStructure.gif"),
				"Submachines", false);
		}

		if( ! machine.instance.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__INSTANCE,
				imageHelper.getImage("fml/InstanceSpecification.gif"),
				"Instances", false);
		}
	}


	def createNodeProperty(IOutlineNode parentNode, InstanceMachine instance) {
		if( instance.model !== null ) {
			createEStructuralFeatureNode(parentNode, instance,
				InfrastructurePackage.Literals.INSTANCE_MACHINE__MODEL,
				imageHelper.getImage("fml/Model.gif"),
				"model: " + nameProvider.getFullyQualifiedName(instance.model), false);
		}
	}


	def createNodeProperty(IOutlineNode parentNode, Behavior behavior) {
		if( ! behavior.parameter.empty ) {
			createEStructuralFeatureNode(parentNode, behavior,
				InfrastructurePackage.Literals.BEHAVIOR__PARAMETER,
				imageHelper.getImage("fml/ParameterSet.gif"),
				"Parameters", false);
		}

		createNodeProperty(parentNode, behavior as Machine)
	}


	def createNodeBehavior(IOutlineNode parentNode, Machine machine) {
		if( ! machine.behavior.empty ) {
			createEStructuralFeatureNode(parentNode, machine,
				InfrastructurePackage.Literals.MACHINE__BEHAVIOR,
				imageHelper.getImage("fml/BehaviorExecutionSpecification.gif"),
				"Behaviors", false);
		}

		if( machine.main !== null ) {
			createNode(parentNode, machine.main);
		}
	}


	def createNodeBehavior(IOutlineNode parentNode, Behavior behavior) {
		if( ! behavior.behavior.empty ) {
			createEStructuralFeatureNode(parentNode, behavior,
				InfrastructurePackage.Literals.MACHINE__BEHAVIOR,
				imageHelper.getImage("fml/BehaviorExecutionSpecification.gif"),
				"Behaviors", false);
		}

		if( behavior.main !== null ) {
			createNode(parentNode, behavior.main);
		}


		if( behavior.computation !== null ) {
			createNode(parentNode, behavior.computation);
		}

		if( behavior.execution !== null ) {
			createNode(parentNode, behavior.execution);
		}

		if( behavior.interaction !== null ) {
			createNode(parentNode, behavior.interaction);
		}


		if( behavior.main !== null ) {
			createNode(parentNode, behavior.main);
		}
	}



	def _createChildren(IOutlineNode parentNode, Machine machine) {
//  		val machineNode = createEObjectNode(parentNode, machine);

		createNodeProperty(parentNode, machine);

		createNodeBehavior(parentNode, machine);
	}

//	def _createNode(IOutlineNode parentNode, Machine machine) {
//  		val machineNode = createEObjectNode(parentNode, machine);
//
//		createNodeProperty(machineNode, machine);
//
//		createNodeBehavior(machineNode, machine);
//
//		machineNode
//	}


	def _createChildren(IOutlineNode parentNode, Behavior behavior) {
		createNodeProperty(parentNode, behavior);

		createNodeBehavior(parentNode, behavior);
	}


	def _createChildren(IOutlineNode parentNode, Statemachine statemachine) {
//  		val statemachineNode = createEObjectNode(parentNode, statemachine);

		createNodeProperty(parentNode, statemachine);

  		for( region : statemachine.region ) {
			createNode(parentNode, region);
  		}

		createNodeBehavior(parentNode, statemachine);
	}

//	def _createNode(IOutlineNode parentNode, Statemachine statemachine) {
//  		val statemachineNode = createEObjectNode(parentNode, statemachine);
//
//		createNodeProperty(statemachineNode, statemachine);
//
//  	for( region : statemachine.region ) {
//			createNode(statemachineNode, region);
//  	}
//
//		createNodeBehavior(statemachineNode, statemachine);
//
//		statemachineNode
//	}


//	def _createChildren(IOutlineNode parentNode, State state) {
//  		for( region : state.region ) {
//			createNode(parentNode, region);
//  		}
//
//  		for( transition : state.transition ) {
//			createNode(parentNode, transition);
//  		}
//
//		if( state.execution !== null ) {
//			createNode(parentNode, state.execution);
//		}
//	}

//	def _createNode(IOutlineNode parentNode, State state) {
//  	val stateNode = createEObjectNode(parentNode, state);
//
//		createNodeProperty(stateNode, state);
//
//  		for( region : state.region ) {
//			createNode(stateNode, region);
//  		}
//
//		createNodeBehavior(stateNode, state);
//
//		stateNode
//	}




//protected void _createChildren(DocumentRootNode parentNode,XtendFile xtendFile){
//  if (xtendFile.getPackage() !== null)
//     createEStructuralFeatureNode(parentNode,xtendFile,
//     	XtendPackage.Literals.XTEND_FILE__PACKAGE,
//		images.forPackage(),xtendFile.getPackage(),true
//     );
//
//  if (!xtendFile.getImports().isEmpty())
//     createEStructuralFeatureNode(parentNode,xtendFile,
//     	XtendPackage.Literals.XTEND_FILE__IMPORTS,
//		images.forImportContainer(),"import declarations",false
//     );
//  for (  XtendTypeDeclaration xtendType : xtendFile.getXtendTypes()) {
//    EObjectNode classNode=createEObjectNode(parentNode,xtendType);
//    createFeatureNodes(classNode,xtendType);
//  }
//}


//	def _isLeaf(DataType datatype) {
//		true
//	}
//
//	def _isLeaf(Signal signal) {
//		true
//	}
//
//	def _isLeaf(PropertyDefinition propertyDef) {
//		true
//	}
//
////	def _isLeaf(Port port) {
////		true
////	}
////
////	def _isLeaf(Buffer buffer) {
////		true
////	}
////
////	def _isLeaf(Variable variable) {
////		true
////	}
////
////	def _isLeaf(Channel channel) {
////		true
////	}
//
//
//	def _isLeaf(Transition transition) {
//		true
//	}
//
//	def _isLeaf(Routine routine) {
//		(routine.name === null)
//	}

}
