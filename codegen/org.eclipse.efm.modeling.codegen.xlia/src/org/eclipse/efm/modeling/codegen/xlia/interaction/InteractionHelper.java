/*******************************************************************************
 * Copyright (c) 2017 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Imen BOUDHIBA (CEA LIST) imen.boudhiba@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.interaction;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.efm.modeling.codegen.xlia.datatype.DataTypeFactory;
import org.eclipse.efm.modeling.codegen.xlia.statemachine.TransitionHelper;
import org.eclipse.efm.modeling.codegen.xlia.util.StatemachineContext;
import org.eclipse.efm.modeling.codegen.xlia.util.XliaConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public interface InteractionHelper extends NameHelper,
		TimeObservationHelper , TransitionHelper, XliaConstants {

	///////////////////////////////////////////////////////////////////////////
	// UTILS FOR SCHEDULE REGION IN COMBINED FRAGMENT
	///////////////////////////////////////////////////////////////////////////

	default Property createCombinedRegionScheduleVariable(
			StatemachineContext lfContext, CombinedFragment element) {

		String enumRegionTypeName = nameOfEnumRegionsType(element);
		Type fifoScheduleType = DataTypeFactory.fifoType(enumRegionTypeName);//, -1);

		Property schedulingVariable = lfContext.statemachine.createOwnedAttribute(
				nameOfSchedulingVariable(element), fifoScheduleType);

		//To-Do declare enumRegionTypeName
		Type enumRegionType = DataTypeFactory.enumAliasType(enumRegionTypeName);
		Property currentRegionVariable = lfContext.statemachine.createOwnedAttribute(
				nameOfScheduledRegionVariable(element), enumRegionType);//enumRegionTypeName);

		return( schedulingVariable );
	}


	default void addGuardForFirstRegionEntry(
			Transition transition, Property regionScheduleVariable) {

		StringBuilder guard = new StringBuilder();
		guard.append("//guard empty( ")
			.append(regionScheduleVariable.getName())
			.append(" );");

		addOpaqueBehaviorEffect(transition, guard.toString());
	}


	default void addGuardForNotFirstRegionEntry(
			Transition transition, Property regionScheduleVariable,
			CombinedFragment element) {

		StringBuilder guard = new StringBuilder();
		guard.append("//guard notempty( ")
			.append(regionScheduleVariable.getName())
			.append(" );");

		addOpaqueBehaviorEffect(transition, guard.toString());

		guard = new StringBuilder();
		guard.append("guard( ")
			.append(regionScheduleVariable.getName())
			.append(".top !=" + "Region#"+ element.getName() + "#OUT );");
		addOpaqueBehaviorEffect(transition, guard.toString());
	}


	///////////////////////////////////////////////////////////////////////////
	// TRANSITION
	///////////////////////////////////////////////////////////////////////////

	default void addEffectGuard(StatemachineContext lfContext,
			Element element, Transition transition, Constraint guard) {

		StringBuilder valueBuffer = new StringBuilder();
		StringBuilder valueBuffer1 = new StringBuilder();
		//Transition BH_tr = null;

		if( guard != null ) {
			ValueSpecification valueSpec = guard.getSpecification();
			if( valueSpec instanceof OpaqueExpression ) {
				OpaqueExpression opaqExpr = (OpaqueExpression)valueSpec;
				String[] bodies = opaqExpr.getBodies().toArray(new String[opaqExpr.getBodies().size()]);
				String[] languages = opaqExpr.getLanguages().toArray(new String[opaqExpr.getLanguages().size()]);
				for (int i = 0; i < languages.length; i++) {
					if(languages[i].contains("Assertion")){
						valueBuffer.append("globalAssertion <=< ");
						valueBuffer.append(bodies[i]).append(";");
						addOpaqueBehaviorEffect(transition, valueBuffer.toString());
					}
					else if(languages[i].contains("xLIAstringPre")){
						valueBuffer.append("currentCall.PRE = ");
						valueBuffer.append(bodies[i]).append(";");
						addOpaqueBehaviorEffect(transition, valueBuffer.toString());
					}
					else if(languages[i].contains("xLIAstringPost")){
						valueBuffer.append("currentCall.POST = ");
						valueBuffer.append(bodies[i]).append(";");
						addOpaqueBehaviorEffect(transition, valueBuffer.toString());
					}
					else if(languages[i].contains("VSL")){
						valueBuffer.append( transformTimedConstraint(bodies[i]) );

//						valueBuffer.append("tguard( ");
//						valueBuffer.append(bodies[i]).append(" );");

						addOpaqueBehaviorEffect(transition, valueBuffer.toString());
					}
					else if(languages[i].contains("OCL")){
						valueBuffer.append("globalAssertion <=< ");
						valueBuffer.append(bodies[i]).append(";");

						 EList<Element> constrainedElements = guard.getConstrainedElements();
						 if( ! constrainedElements.isEmpty() ) {
							 Element constrainedElement = constrainedElements.get(0);
							 if( constrainedElement instanceof ExecutionOccurrenceSpecification ) {
								ExecutionOccurrenceSpecification eos = (ExecutionOccurrenceSpecification) constrainedElement;

								if( eos.getExecution() instanceof BehaviorExecutionSpecification ) {
									BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) eos.getExecution();

									if(bes.getFinish() == eos){
										if( bes.getBehavior() instanceof FunctionBehavior ) {
											FunctionBehavior fb = (FunctionBehavior) bes.getBehavior();
											valueBuffer.append(" // fun.behavior: ").append(fb.getBodies());
										}

									}
								}
							 }
							 addOpaqueBehaviorEffect(transition, valueBuffer.toString());
						 }

					}
					else  if(element instanceof BehaviorExecutionSpecification )
					{
						if( lfContext.intermediateTransition == null )
						{
							State targetState = lfContext.createTargetState("targetBhExec#1" + transition.getName());

							lfContext.currentState.setName("BhExec#" + transition.getName()+"_1");
							lfContext.intermediateTransition = lfContext.createTransition(
									transition.getName()+"_1", lfContext.currentState, targetState);
							//StringBuilder valueBuffer1 = new StringBuilder();
							valueBuffer1.append("guard( ");
							valueBuffer1.append(bodies[i]).append(" );");
							addOpaqueBehaviorEffect(lfContext.intermediateTransition, valueBuffer1.toString());
							//lfContext.currentState = targetState;
						}
						else
						{
							valueBuffer1.append("guard( ");
							valueBuffer1.append(bodies[i]).append(" );");
							addOpaqueBehaviorEffect(lfContext.intermediateTransition, valueBuffer1.toString());

							//lfContext.currentState = (State) lfContext.bh_tr.getTarget();
						}

					}
					else if(element instanceof ExecutionOccurrenceSpecification )
					{
						valueBuffer.append("guard( ");
						valueBuffer.append(bodies[i]).append(" );");
						addOpaqueBehaviorEffect(transition, valueBuffer.toString());
					}

					else if(element instanceof MessageOccurrenceSpecification )
					{
						valueBuffer.append("guard( ");
						valueBuffer.append(bodies[i]).append(" );");
						//addOpaqueBehaviorEffect(transition, valueBuffer.toString());
						setGuard(transition, guard);
					}
				}
			}
			else if( valueSpec instanceof Expression ) {
				Expression valueExpr = (Expression) valueSpec;
				valueBuffer.append(valueExpr); //TODO expression to string
				addOpaqueBehaviorEffect(transition, valueBuffer.toString());
			}
			else {
				valueSpecificationToString(valueSpec, valueBuffer);
				addOpaqueBehaviorEffect(transition, valueBuffer.toString());
			}
		}
	}


	default void valueSpecificationToString(
			ValueSpecification value, StringBuilder stringVar) {
		if( value instanceof LiteralBoolean ) {
			stringVar.append(value.booleanValue());
		}
		else if( value instanceof LiteralInteger ) {
			stringVar.append(value.integerValue());
		}
		else if( value instanceof LiteralReal ) {
			stringVar.append(value.realValue());
		}
		else if( value instanceof LiteralString ) {
			stringVar.append(value.stringValue());
		}
		else if( value instanceof LiteralUnlimitedNatural ) {
			stringVar.append(value.unlimitedValue());
		}
		else if( value instanceof Expression ) {
			stringVar.append("(");

			Expression expr = (Expression) value;

			stringVar.append( (expr.getSymbol() != null) ?
					expr.getSymbol() : "<symbol:null>" );

			for(ValueSpecification vs : expr.getOperands() ) {
				stringVar.append(" ");
				valueSpecificationToString(vs, stringVar);
			}

			stringVar.append(")");
		}

		else if( value instanceof OpaqueExpression ) {
			OpaqueExpression expr = (OpaqueExpression) value;
			stringVar.append(expr.getBodies().get(0).toString());
		}

		else if(  value != null ) {
			final String name = value.getName();
			if( name != null ) {
				stringVar.append("ValueSpecification< ")
					.append(name)
					.append(" > ");
			}
			stringVar.append(value.toString());
		}
	}


	default void setGuard(Transition transition,
			InteractionConstraint interactionGuard, Property indexVar) {
		if( interactionGuard != null ) {
			Constraint constraint = transition.createGuard("guardConstraint");
			ValueSpecification valueSpec = interactionGuard.getSpecification();

			String loopIndexConstraint = toIndexConstraint(interactionGuard, indexVar);

			if( valueSpec instanceof OpaqueExpression ) {
				OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardSpecification.getLanguages().addAll(((OpaqueExpression)valueSpec).getLanguages());
				guardSpecification.getBodies().addAll(((OpaqueExpression)valueSpec).getBodies());

				if( loopIndexConstraint.length() > 0 ) {
					guardSpecification.getLanguages().add(LANGUAGE_X_LIA);
					guardSpecification.getBodies().add(loopIndexConstraint.toString());
				}

				constraint.setSpecification(guardSpecification);
			}
			else {
				OpaqueExpression guardExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardExpression.setName("guardExpression");

				guardExpression.getLanguages().add(LANGUAGE_X_LIA);
				guardExpression.getBodies().add(valueSpec.toString());

				if( loopIndexConstraint.length() > 0 ) {
					guardExpression.getLanguages().add(LANGUAGE_X_LIA);
					guardExpression.getBodies().add(loopIndexConstraint.toString());
				}
			}
		}
	}

	default String toIndexConstraint(InteractionConstraint interactionGuard, Property indexVar) {
		if( interactionGuard != null ) {
			StringBuilder loopIndexConstraint = new StringBuilder();
			if( interactionGuard.getMinint() != null ) {
				loopIndexConstraint.append(indexVar.getName()).append(" >= ");
				valueSpecificationToString(interactionGuard.getMinint(), loopIndexConstraint);

			}
			if( interactionGuard.getMaxint() != null ) {
				if( loopIndexConstraint.length() > 0 ) {
					loopIndexConstraint.append(" && ");
				}
				loopIndexConstraint.append(indexVar.getName()).append(" <= ");
				valueSpecificationToString(interactionGuard.getMaxint(), loopIndexConstraint);
			}

			return loopIndexConstraint.toString();
		}

		return "true";
	}


	default List< CombinedFragment > listOfCombinedFragment(Interaction interaction) {
		ArrayList<CombinedFragment> combinedFragments= new ArrayList<CombinedFragment>();

		for(InteractionFragment fragment : interaction.getFragments() ) {
			if(fragment instanceof CombinedFragment){
				CombinedFragment combinedFragment = (CombinedFragment) fragment;
				combinedFragments.add(combinedFragment);

				listOfCombinedFragment(combinedFragment, combinedFragments);
			}
		}

		return combinedFragments;
	}

	default void listOfCombinedFragment(
			CombinedFragment combinedFragment, List< CombinedFragment > combinedFragments) {
		for(InteractionOperand operand : combinedFragment.getOperands() ) {
			for(InteractionFragment fragment : operand.getFragments() ) {
				if(fragment instanceof CombinedFragment){
					CombinedFragment combFragment = (CombinedFragment) fragment;
					combinedFragments.add(combFragment);

					listOfCombinedFragment(combFragment, combinedFragments);
				}
			}
		}
	}

}
