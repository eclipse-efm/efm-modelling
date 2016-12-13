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
package org.eclipse.efm.formalml.xtext.ui.labeling

import com.google.inject.Inject
import org.eclipse.efm.ecore.formalml.common.NamedElement
import org.eclipse.efm.ecore.formalml.common.QualifiedName
import org.eclipse.efm.ecore.formalml.common.Type
import org.eclipse.efm.ecore.formalml.datatype.ChoiceType
import org.eclipse.efm.ecore.formalml.datatype.CollectionType
import org.eclipse.efm.ecore.formalml.datatype.DataSupportedType
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
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveType
import org.eclipse.efm.ecore.formalml.datatype.StructureType
import org.eclipse.efm.ecore.formalml.datatype.UnionType
import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression
import org.eclipse.efm.ecore.formalml.expression.AssociativeExpression
import org.eclipse.efm.ecore.formalml.expression.BinaryExpression
import org.eclipse.efm.ecore.formalml.expression.ExpressionAsPort
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPostfixExpression
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPrefixExpression
import org.eclipse.efm.ecore.formalml.expression.InstantiationExpression
import org.eclipse.efm.ecore.formalml.expression.InvokeExpression
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression
import org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression
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
import org.eclipse.efm.ecore.formalml.expression.NewfreshExpression
import org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression
import org.eclipse.efm.ecore.formalml.expression.TupleExpression
import org.eclipse.efm.ecore.formalml.expression.UnaryExpression
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior
import org.eclipse.efm.ecore.formalml.infrastructure.Buffer
import org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind
import org.eclipse.efm.ecore.formalml.infrastructure.ComPoint
import org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol
import org.eclipse.efm.ecore.formalml.infrastructure.Connection
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution
import org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter
import org.eclipse.efm.ecore.formalml.infrastructure.Port
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition
import org.eclipse.efm.ecore.formalml.infrastructure.Route
import org.eclipse.efm.ecore.formalml.infrastructure.Routine
import org.eclipse.efm.ecore.formalml.infrastructure.Signal
import org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty
import org.eclipse.efm.ecore.formalml.infrastructure.System 
import org.eclipse.efm.ecore.formalml.infrastructure.Variable
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
import org.eclipse.efm.ecore.formalml.statement.AssignmentStatement
import org.eclipse.efm.ecore.formalml.statement.BlockStatement
import org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement
import org.eclipse.efm.ecore.formalml.statement.DoWhileStatement
import org.eclipse.efm.ecore.formalml.statement.ExpressionStatement
import org.eclipse.efm.ecore.formalml.statement.ForEachStatement
import org.eclipse.efm.ecore.formalml.statement.ForStatement
import org.eclipse.efm.ecore.formalml.statement.GuardStatement
import org.eclipse.efm.ecore.formalml.statement.IfStatement
import org.eclipse.efm.ecore.formalml.statement.InputComStatement
import org.eclipse.efm.ecore.formalml.statement.InterruptStatement
import org.eclipse.efm.ecore.formalml.statement.OutputComStatement
import org.eclipse.efm.ecore.formalml.statement.Statement
import org.eclipse.efm.ecore.formalml.statement.TimedGuardStatement
import org.eclipse.efm.ecore.formalml.statement.WhileDoStatement
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class FormalMLLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:

//	def text(Greeting ele) {
//		'A greeting to ' + ele.name
//	}
//
//	def image(Greeting ele) {
//		'Greeting.gif'
//	}


	def fqnString(QualifiedName qualifiedname) {
		var path = ""
		var sep = ""
		for( name : qualifiedname.nameBinding ) {
			path += sep + name
			if( sep.isEmpty ) {
				sep = "."
			}
		}
		if( qualifiedname.unqualifiedName != null ) {
			path += sep + qualifiedname.unqualifiedName
		}

		path
	}


	@Inject
	private IQualifiedNameProvider nameProvider;

	def text(NamedElement decl) {
		val fqn = nameProvider.getFullyQualifiedName(decl);

		fqn?.toString ?: "no qfn: " + ( decl.name ?: "<unamed>" )
	}


	def text(PropertyDefinition decl) {
		val fqn = nameProvider.getFullyQualifiedName(decl);

		fqn?.toString ?: "no qfn: " + ( decl.name ?: "<property>" )
	}



	def text(Parameter decl) {
		decl.name ?: "<parameter>"
	}

	def image(Parameter decl) {
		switch( decl.direction ) {
			case IN    : "fml/Parameter_in.gif"
			case OUT   : "fml/Parameter_out.gif"

			case INOUT :  "fml/Parameter_inout.gif"

			case RETURN:  "fml/Parameter_return.gif"

			default: "fml/Port.gif"
		}
	}


	def text(Port decl) {
		val fqn = nameProvider.getFullyQualifiedName(decl);
		if( fqn != null ) {
			fqn.toString();
		}
		else {
	  		"no qfn: " + ( decl.name ?: "<port>" )
		}
	}

	def image(Port port) {
		switch( port.direction ) {
			case INPUT : "fml/InputPin.gif"
			case OUTPUT: "fml/OutputPin.gif"

			case INOUT : "fml/FlowProperty.gif"

			default: "fml/Port.gif"
		}
	}


	def text(Signal decl) {
		val fqn = nameProvider.getFullyQualifiedName(decl);
		if( fqn != null ) {
			fqn.toString();
		}
		else {
	  		"no qfn: " + ( decl.name ?: "<signal>" )
		}
	}

	def image(Signal decl) {
		"fml/Signal.gif"
	}


	def text(Buffer decl) {
		val fqn = nameProvider.getFullyQualifiedName(decl);
		if( fqn != null ) {
			fqn.toString();
		}
		else {
	  		"no qfn: " + ( decl.name ?: "<buffer>" )
		}
	}

	def image(Buffer decl) {
		"fml/Signal.gif"
	}


	def text(Variable decl) {
		val fqn = nameProvider.getFullyQualifiedName(decl);
		if( fqn != null ) {
			fqn.toString();
		}
		else if( (decl.name == null) && (decl.type != null) ) {
	  		text( decl.type )
		}
		else {
	  		"no qfn: " + ( decl.name ?: "<variable>" )
		}
	}

	def image(Variable decl) {
		"fml/Property.gif"
//		"fml/Variable.gif"
	}


	def text(SlotProperty slot) {
		if( slot.xliaProperty != null) {
	  		text( slot.xliaProperty )
		}
//		else if( slot.umlProperty != null) {
//	  		text( slot.umlProperty )
//		}
		else {
	  		"<slot>"
		}
	}

	def image(SlotProperty slot) {
		if( slot.xliaProperty != null ) {
			"fml/QualifierValue.gif"
		}
//		else if( slot.umlProperty != null ) {
//			"fml/QualifierValue.gif"
//		}
		else {
			"fml/Property.gif"
		}
	}


	def text(Type type) {
		val fqn = nameProvider.getFullyQualifiedName(type);
		if( fqn != null ) {
			fqn.toString();
		}
		else {
	  		"no qfn: " + ( type.name ?: "<type>" )
		}
	}


	def text(DataType type) {
		val fqn = nameProvider.getFullyQualifiedName(type);
		if( fqn != null ) {
			fqn.toString();
		}
		else {
	  		"no qfn: " + ( type.name ?: "<datatype>" )
		}
	}


	def String image(DataType type) {
		switch( type ) {
			PrimitiveType  : "fml/PrimitiveType.gif"
			EnumerationType: "fml/Enumeration.gif"
			IntervalType   : "fml/IntervalType.gif"
			StructureType  : "fml/StructureType.gif"
			UnionType      : "fml/UnionType.gif"
			ChoiceType     : "fml/ChoiceType.gif"

			DataTypeReference :  {
				if( type.typeref != null ) {
					type.typeref.image
				}
				else if( type.support != null ) {
					type.support.image
				}
				else {
					"fml/DataType.gif"
				}
			}

			DataSupportedType : type.support.image

			default: "fml/DataType.gif"
		}

	}


	def text(DataTypeReference type) {
		var str =
			if( type.name != null ) {
				if( type.typeref != null ) {
					type.name + " " + text( type.typeref )
				}
				else {
					type.name
				}
			}
			else if( type.typeref != null ) {
				text( type.typeref )
			}
			else if( type.support != null ) {
				text( type.support )
			}
			else {
				"<datatype>"
			}

		if( type.multiplicity != null) {
			str + " [ " + type.multiplicity + " ]"
		}
		else {
			str
		}
	}

	def image(DataTypeReference type) {
		if( type.typeref != null ) {
			image( type.typeref )
		}
		else if( type.support != null ) {
			text( type.support )
		}
		else {
			"fml/DataType.gif"
		}
	}


	def text(EnumerationType type) {
		if( type.name != null ) {
			"enum " + type.name
		}
		else {
			"<enum>"
		}
	}

	def image(EnumerationType type) {
		"fml/Enumeration.gif"
	}


	def text(EnumerationLiteral literal) {
		literal.name
	}

	def image(EnumerationLiteral literal) {
		"fml/EnumerationLiteral.gif"
	}


	def text(CollectionType type) {
		type.container.toString + " " + ( type.name ?: "" ) +
			if( type.unbounded || (type.size < 0) ) {
				" [*]"
			}
			else {
				" [ " + type.size + " ]"
			}
	}

	def image(CollectionType type) {
		image( type.support )
	}


	def text(StructureType type) {
		if( type.name != null ) {
			"struct " + type.name
		}
		else {
			"<struct>"
		}
	}

	def image(StructureType type) {
		"fml/StructureType.gif"
	}


	def text(UnionType type) {
		if( type.name != null ) {
			"union " + type.name
		}
		else {
			"<union>"
		}
	}

	def image(UnionType type) {
		"fml/UnionType.gif"
	}


	def text(ChoiceType type) {
		if( type.name != null ) {
			"choice " + type.name
		}
		else {
			"<choice>"
		}
	}

	def image(ChoiceType type) {
		"fml/ChoiceType.gif"
	}


	def text(PrimitiveBooleanType type) {
		"boolean"
	}

	def text(PrimitiveIntegerType type) {
		"integer"
	}

	def text(PrimitiveRationalType type) {
		"rational"
	}

	def text(PrimitiveFloatType type) {
		"float"
	}

	def text(PrimitiveRealType type) {
		"real"
	}

	def text(PrimitiveTimeType type) {
		if( type.isClock ){
			"clock"
		}
		else {
			"time"
		}
	}

	def text(PrimitiveCharacterType type) {
		"char"
	}

	def text(PrimitiveStringType type) {
		"string"
	}

	def text(PrimitiveInstanceType type) {
		type.expected.toString +
			if( type.model != null ) {
				"< " + type.model.name + " >"
			}
			else {
				""
			}
	}

	def text(IntervalType type) {
		"interval " + ( type.name ?: "" ) +
			( if( type.lopen ) "] " else " [ " ) +
			( if( type.ropen ) "[" else  "]" )
	}

	def image(IntervalType type) {
		"fml/IntervalType.gif"
	}


	def image(PrimitiveType type) {
		"fml/PrimitiveType.gif"
	}



	def text(Behavior behavior) {
		if( behavior == (behavior.eContainer as Machine).main ) {
			"Main Behavior"
		}
		else {
			"Behavior"
		}
	}

	def image(Behavior behavior) {
		if( behavior == (behavior.eContainer as Machine).main ) {
			"fml/BehaviorExecutionSpecification.gif"
		}
		else {
			"fml/BehaviorExecutionSpecification.gif"
		}
	}


	def text(Region region) {
		if( region.name != null ) {
			val str = new StyledString(region.name)

			if( region.unrestrictedName != null ) {
				str.append( new StyledString(
					" " + region.unrestrictedName,
					StyledString::DECORATIONS_STYLER ) )
			}
			else {
				str
			}
		}
		else if( region.eContainer instanceof Statemachine ) {
			"Statemachine Region"
		}
		else {
			"State Region"
		}
	}

	def image(Region region) {
		"fml/Region.gif"
	}


	def text(System system) {
		val str = new StyledString(system.name)

		if( system.unrestrictedName != null ) {
			str.append( new StyledString(
				" " + system.unrestrictedName,
				StyledString::DECORATIONS_STYLER ) )
		}
		else {
			str
		}
	}

	def image(System system) {
		"fml/Block.gif"
	}


	def text(Machine machine) {
		val str = new StyledString(machine.name)

		if( machine.unrestrictedName != null ) {
			str.append( new StyledString(
				" " + machine.unrestrictedName,
				StyledString::DECORATIONS_STYLER ) )
		}
		else {
			str
		}
	}

	def image(Machine machine) {
		"fml/Block.gif"
	}


	def text(InstanceMachine instance) {
		val str = new StyledString(instance.name)

		if( instance.unrestrictedName != null ) {
			str.append( new StyledString(
				" " + instance.unrestrictedName,
				StyledString::DECORATIONS_STYLER ) )
		}
		else if( instance.slot.empty && (instance.model != null) ) {
			str.append( new StyledString(" as ",
				StyledString::DECORATIONS_STYLER ).append(
				 	 new StyledString( instance.model.name,
				 	 	StyledString::QUALIFIER_STYLER ) ) )
		}
		else {
			str
		}
	}

	def image(InstanceMachine machine) {
		"fml/InstanceSpecification.gif"
	}


	def text(Statemachine statemachine) {
//		println( "Statemachine:" )
//		val injector = Guice.createInjector(new XLIARuntimeModule)
//
////		var rs = injector.getInstance(ResourceSet)
////		val uri = URI.createURI("test.xlia")
////		val resource = rs.createResource(uri)
////		resource.contents += statemachine
////
////		var saveOptions = new HashMap();
////		saveOptions.put(XtextResource.OPTION_FORMAT, Boolean.TRUE);
////		resource.save(new FileOutputStream("test.xliab"), saveOptions);
//
//
//		val serializer = injector.getInstance(ISerializer)
//		val result = serializer.serialize(statemachine)
//		println( result )
//		println( "--> end" )


		val str = new StyledString(statemachine.name)

		if( statemachine.unrestrictedName != null ) {
			str.append( new StyledString(
				" " + statemachine.unrestrictedName,
				StyledString::DECORATIONS_STYLER  ) )
		}
		else {
			str
		}
	}

	def image(Statemachine statemachine) {
		"fml/StateMachine.gif"
	}


	def text(State state) {
		val str = new StyledString(state.name)

		if( state.unrestrictedName != null ) {
			str.append( new StyledString(
				" " + state.unrestrictedName,
				StyledString::DECORATIONS_STYLER  ) )
		}
		else {
			str
		}
	}

	def image(State state) {
		if( (state.region != null) ) {
			if( state.region.isEmpty ) {
				"fml/State.gif"
			}
			else if( state.region.size > 1 ) {
				"fml/StateMachine.gif"
			}
			else {
				"fml/StateMachine.gif"
			}
		}
		else {
			"fml/State.gif"
		}
	}

	def image(StartState state) {
		"fml/State_start.gif"
	}

	def image(FinalState state) {
		"fml/FinalState.gif"
	}


	def text(Pseudostate state) {
		val str = new StyledString(state.name)

		if( state.unrestrictedName != null ) {
			str.append( new StyledString(
				" " + state.unrestrictedName,
				StyledString::DECORATIONS_STYLER  ) )
		}
		else {
			str
		}
	}

	def image(Pseudostate state) {
		switch( state.kind ) {
			case INITIAL  : "fml/Pseudostate_initial.gif"
			case TERMINATE: "fml/Pseudostate_terminate.gif"

			case JUNCTION : "fml/Pseudostate_junction.gif"
			case CHOICE   : "fml/Pseudostate_choice.gif"

			case FORK: "fml/Pseudostate_fork.gif"
			case JOIN: "fml/Pseudostate_join.gif"

			case DEEP_HISTORY   : "fml/Pseudostate_deepHistory.gif"
			case SHALLOW_HISTORY: "fml/Pseudostate_shallowHistory.gif"

			default: "fml/State.gif"
		}
	}


	def text(Transition transition) {
		val str = new StyledString( transition.name ?: "<transition>" )

		if( transition.unrestrictedName != null ) {
			str.append(	new StyledString(
				" " + transition.unrestrictedName,
				StyledString::DECORATIONS_STYLER ) ).append(
					" --> " + transition.target?.name )
		}
		else {
			str.append( " --> " + transition.target?.name )
		}
	}

	def image(Transition transition) {
		"fml/Transition_local.gif"
	}

	def text(TransitionMoe moe) {
		var info = "moe< "
		if( moe.moc != TransitionMoc.SIMPLE ) {
			info += "moc: " + moe.moc.toString
		}

		if( moe.isElse ) {
		  if( info != "moe< " ) {
			info += " & "
		  }
		  info += "else"
		}

		if( moe.prior != 0 ) {
		  if( info != "moe< " ) {
			info += " , "
		  }
		  info += "prior: " + moe.prior
		}

		info += " >"

		return info
	}

	def image(TransitionMoe moe) {
		"fml/ExecutionEnvironment.gif"
	}


	def text(ModelOfExecution moe) {
		"Model Of Execution"
	}

	def image(ModelOfExecution moe) {
		"fml/ExecutionEnvironment.gif"
	}


	def text(Routine routine) {
		if( routine.name != null ) {
			val str = new StyledString(routine.name)

			if( routine.unrestrictedName != null ) {
				str.append( new StyledString(
					" " + routine.unrestrictedName,
					StyledString::DECORATIONS_STYLER ) )
			}
			else {
				str
			}
		}
		else if( routine.eContainer instanceof ModelOfExecution ) {
			val moe = routine.eContainer as ModelOfExecution
			switch( routine ) {
				case moe.initRoutine        : "@init"
				case moe.finalRoutine       : "@final"

				case moe.enableRoutine      : "@enable"
				case moe.disableRoutine     : "@disable"

				case moe.irunRoutine        : "@irun"
				case moe.runRoutine         : "@run"

				case moe.concurrencyRoutine : "@concurrency"
				case moe.scheduleRoutine    : "@schedule"

				default: "Unknown Predefined Routine"
			}
		}
		else {
			"Anonymous Routine"
		}
	}

	def image(Routine routine) {
		"fml/StartClassifierBehaviorAction.gif"
	}


	def text(ModelOfInteraction moi) {
		"Model Of Interaction"
	}

	def image(ModelOfInteraction moi) {
		"fml/Diagram_Sequence.gif"
	}


	def text(Connection connection) {
		connection.name ?: "Connection"
	}

	def image(Connection connection) {
		"fml/Connector_assembly.gif"
	}


	def text(Route route) {
		"Route"
	}

	def image(Route route) {
		"fml/Connector_assembly.gif"
	}


	def text(ComPoint comPoint) {
//		val str = ( comPoint.machine?.target.name ?: "this" ) + "->"
//		str + ( comPoint.port.target?.name ?: text( comPoint.port.value ) )

		"<compoint>"
	}

	def image(ComPoint comPoint) {
		switch( comPoint.direction ) {
//			case INPUT : "fml/FlowPort_IN.gif"
//			case OUTPUT: "fml/FlowPort_OUT.gif"

			case INPUT : "fml/InputPin.gif"
			case OUTPUT: "fml/OutputPin.gif"

			case INOUT : "fml/FlowProperty.gif"

			default:     "fml/FlowPort.gif"
		}
	}


	def text( ComCastKind cast ) {
		switch( cast ) {
			case UNICAST  : "unicast"
			case ANYCAST  : "anycast"
			case MULTICAST: "multicast"
			case BROADCAST: "broadcast"
			case NONE: "none"
		}
	}

	def text(ComProtocol com) {
		switch( com.protocol ) {
			case BUFFER: {
				if( com.inner_buffer != null ) {
					"buffer: " + text( com.inner_buffer )
				}
				else if( com.ref_buffer != null ) {
					"buffer: " + text( com.ref_buffer )
				}
				else {
					"buffer"
				}
			}

			case ENV: "env"

			case RDV: "rdv"

			case MULTI_RDV: {
				if( com.cast != ComCastKind.NONE ) {
					"multirdv< " + text( com.cast ) + " >"
				}
				else {
					"multirdv"
				}
			}

			case NONE: text( com.cast )
		}
	}

	def image(ComProtocol com) {
		"fml/Diagram_Communication.gif"
	}


	def text(Statement statement) {
		"Statement"
	}

	def image(Statement statement) {
		"fml/ExecutionEnvironment.gif"
	}


	def text(BlockStatement statement) {
		var strBlock = "Block"

		if( statement.eContainer instanceof IfStatement ) {
			if( statement == (statement.eContainer as IfStatement).bodyBlock ) {
				strBlock = "then"
			}
			else if( statement == (statement.eContainer as IfStatement).elseBlock ) {
				strBlock = "else"
			}
		}

		if( (statement.op != null) && (! statement.op.isEmpty) ) {
			strBlock += " { " + statement.op + " }"
		}

		strBlock
	}

	def image(BlockStatement statement) {
		"fml/Activity.gif"
	}


	def text(ExpressionStatement statement) {
		switch( statement.expression ) {
			AssignmentExpression: "assignment"

			NewfreshExpression  : "newfresh"

			IncrementOrDecrementPrefixExpression : "IncrementOrDecrementPrefix"

			IncrementOrDecrementPostfixExpression: "IncrementOrDecrementPostfix"

			default: "Expression Statement"
		}
	}

	def text(AssignmentStatement statement) {
		"assign " + statement.operator
	}


	def text(GuardStatement statement) {
		"Guard"
	}

	def image(GuardStatement statement) {
		"fml/Constraint.gif"
	}

	def text(TimedGuardStatement statement) {
		"TimedGuard"
	}

	def image(TimedGuardStatement statement) {
		"fml/TimeConstraint.gif"
	}


	def text(InputComStatement statement) {
//		"input " + ( statement.port.target?.name ?: text(statement.port.value) )
		"<input>"
	}

	def image(InputComStatement statement) {
		"fml/InputPin.gif"
	}

	def text(OutputComStatement statement) {
//		"output " + ( statement.port.target?.name ?: text(statement.port.value) )

		"<output>"
	}

	def image(OutputComStatement statement) {
		"fml/OutputPin.gif"
	}


	def text(ActivityStatement statement) {
		statement.op.toString
	}

	def image(ActivityStatement statement) {
		"fml/CallBehaviorAction.gif"
	}


	def text(InterruptStatement statement) {
		statement.kind.toString
	}

	def image(InterruptStatement statement) {
		"fml/CallBehaviorAction.gif"
	}


	def text(IfStatement statement) {
		"if"
	}

	def image(IfStatement statement) {
		"fml/Diagram_Activity.gif"
	}


	def text(ConditionalBlockStatement statement) {
		if( statement.eContainer instanceof IfStatement ) {
			"elseif"
		}
		else {
			"Conditional Block"
		}
	}

	def image(ConditionalBlockStatement statement) {
		if( statement.eContainer instanceof IfStatement ) {
			"fml/Diagram_Activity.gif"
		}
		else {
			"fml/Activity.gif"
		}
	}


	def text(ForStatement statement) {
		"for( ; ; )"
	}

	def image(ForStatement statement) {
		"fml/LoopStatement.gif"
	}


	def text(ForEachStatement statement) {
		"foreach"
	}

	def image(ForEachStatement statement) {
		"fml/LoopStatement.gif"
	}


	def text(WhileDoStatement statement) {
		"while(...) do{...}"
	}

	def image(WhileDoStatement statement) {
		"fml/LoopStatement.gif"
	}


	def text(DoWhileStatement statement) {
		"do{...} while(...)"
	}

	def image(DoWhileStatement statement) {
		"fml/LoopStatement.gif"
	}


	def text(LiteralBooleanExpression expression) {
		"" + expression.value
	}

	def image(LiteralBooleanExpression expression) {
		"fml/LiteralBoolean.gif"
	}


	def text(LiteralIntegerExpression expression) {
		"" + expression.value
	}

	def image(LiteralIntegerExpression expression) {
		"fml/LiteralInteger.gif"
	}


	def text(LiteralRationalExpression expression) {
		"" + expression.numerator + "/" + expression.denominator
	}

	def image(LiteralRationalExpression expression) {
		"fml/LiteralInteger.gif"
	}


	def text(LiteralFloatExpression expression) {
		"" + expression.value
	}

	def image(LiteralFloatExpression expression) {
		"fml/LiteralReal.gif"
	}

	def text(LiteralRealExpression expression) {
		"" + expression.value
	}

	def image(LiteralRealExpression expression) {
		"fml/LiteralReal.gif"
	}


	def text(LiteralCharacterExpression expression) {
		"" + expression.value.toString
	}

	def image(LiteralCharacterExpression expression) {
		"fml/LiteralString.gif"
	}


	def text(LiteralStringExpression expression) {
		"" + expression.value
	}

	def image(LiteralStringExpression expression) {
		"fml/LiteralString.gif"
	}


	def text(LiteralCollectionExpression expression) {
		"<collection>"
	}

	def image(LiteralCollectionExpression expression) {
		"fml/Variable.gif"
	}

	def text(LiteralReferenceElement expression) {
		if( expression.value != null ) {
			val fqn = nameProvider.getFullyQualifiedName(expression.value);

			fqn?.toString ?: "no qfn: " + ( expression.value.name ?: "<reference>" )
		}
		else {
			"<reference>"
		}
	}

	def image(LiteralReferenceElement expression) {
		if( expression.value != null ) {
			image(expression.value)
		}
		else {
			"fml/QualifierValue.gif"
		}
	}


	def text(LiteralThisExpression expression) {
		"$this"
	}

	def image(LiteralThisExpression expression) {
		"fml/QualifierValue.gif"
	}


	def text(LiteralSelfExpression expression) {
		"$self"
	}

	def image(LiteralSelfExpression expression) {
		"fml/QualifierValue.gif"
	}


	def text(LiteralSuperExpression expression) {
		"$super"
	}

	def image(LiteralSuperExpression expression) {
		"fml/QualifierValue.gif"
	}


	def text(LiteralParentExpression expression) {
		"$parent"
	}

	def image(LiteralParentExpression expression) {
		"fml/QualifierValue.gif"
	}


	def text(LiteralSystemExpression expression) {
		"$system"
	}

	def image(LiteralSystemExpression expression) {
		"fml/QualifierValue.gif"
	}

	def text(LiteralEnvExpression expression) {
		"$env"
	}

	def image(LiteralEnvExpression expression) {
		"fml/QualifierValue.gif"
	}


	def text(LiteralNullExpression expression) {
		"null"
	}

	def image(LiteralNullExpression expression) {
		"fml/LiteralNull.gif"
	}


	def text(LeftHandSideExpression expression) {
		"<lvalue>"
	}

	def image(LeftHandSideExpression expression) {
		"fml/Variable.gif"
	}


	def text(InstantiationExpression expression) {
		"Instantiation " + ( expression.instance?.model?.name ?: "<model>" )
	}

	def image(InvokeExpression expression) {
		"fml/Parameter_return.gif"
	}


	def text(TupleExpression expression) {
		if( (expression.eContainer instanceof ValueElementSpecification) &&
			((expression.eContainer as ValueElementSpecification).kind ==
				ValueElementSpecificationKind.INDEX) ) {
			"[i,n,d,e,x]"
		}
		else {
			"(t,u,p,l,e)"
		}
	}

	def image(TupleExpression expression) {
		"fml/Parameter_in.gif"
	}


	def text(UnaryExpression expression) {
		"operator " + expression.operator
	}

	def image(UnaryExpression expression) {
		"fml/Expression.gif"
	}


	def text(IncrementOrDecrementPrefixExpression expression) {
		"operator " + expression.operator + "()"
	}

	def text(IncrementOrDecrementPostfixExpression expression) {
		"operator ()" + expression.operator
	}

	def image(IncrementOrDecrementExpression expression) {
		"fml/Expression.gif"
	}


	def text(BinaryExpression expression) {
		"operator " + expression.operator
	}

	def image(BinaryExpression expression) {
		"fml/Expression.gif"
	}


	def text(RelationalTernaryExpression expression) {
		expression.leftRelation.operator + " operator " + expression.rigthOperator
	}

	def image(RelationalTernaryExpression expression) {
		"fml/Expression.gif"
	}


	def text(AssignmentExpression expression) {
		"operator " + expression.operator
	}

	def text(NewfreshExpression expression) {
		"newfresh"
	}

	def image(AssignmentExpression expression) {
		"fml/Expression.gif"
	}


	def text(AssociativeExpression expression) {
		"operator " + expression.operator
	}

	def image(AssociativeExpression expression) {
		"fml/Expression.gif"
	}


	def text(ValueElementSpecification ves) {
		var str =
			if( ves.element != null ) {
				if( ves.element instanceof NamedElement ) {
					(ves.element as NamedElement).name
				}
				else {
					text( ves.element )
				}
			}
			else {
				"<ves>"
			}

		if( ves.arg != null ) {
			val arg = text( ves.arg ) ?: "<arg>"

			switch( ves.kind ) {
				case INDEX:     str += "[ " + arg + " ]"

				case PARAMETER: str += "( " + arg + " )"

				default: str += " : " + arg
			}
		}

		str
	}

	def image(ValueElementSpecification ves) {
		switch( ves.kind ) {
			case FIELD:     "fml/Property.gif"

			case INDEX:     "fml/Variable.gif"

			case PARAMETER: "fml/Parameter_inout.gif"

			default:         "fml/QualifierValue.gif"
		}
	}


	def text(ExpressionAsPort expression) {
		"<port>"
	}

	def image(ExpressionAsPort expression) {
		"fml/Port.gif"
	}


}
