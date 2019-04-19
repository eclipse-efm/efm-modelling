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
			final StatemachineContext lfContext, final CombinedFragment element) {

		final String enumRegionTypeName = nameOfEnumRegionsType(element);
		final Type fifoScheduleType = DataTypeFactory.fifoType(enumRegionTypeName);//, -1);

		final Property schedulingVariable = lfContext.statemachine.createOwnedAttribute(
				nameOfSchedulingVariable(element), fifoScheduleType);

		//To-Do declare enumRegionTypeName
		final Type enumRegionType = DataTypeFactory.enumAliasType(enumRegionTypeName);
		final Property currentRegionVariable = lfContext.statemachine.createOwnedAttribute(
				nameOfScheduledRegionVariable(element), enumRegionType);//enumRegionTypeName);

		return( schedulingVariable );
	}


	default void addGuardForFirstRegionEntry(
			final Transition transition, final Property regionScheduleVariable) {

		final StringBuilder guard = new StringBuilder();
		guard.append("//guard empty( ")
			.append(regionScheduleVariable.getName())
			.append(" );");

		addOpaqueBehaviorEffect(transition, guard.toString());
	}


	default void addGuardForNotFirstRegionEntry(
			final Transition transition, final Property regionScheduleVariable,
			final CombinedFragment element) {

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

	default void addEffectGuard(final StatemachineContext lfContext,
			final Element element, final Transition transition, final Constraint guard) {

		final StringBuilder valueBuffer = new StringBuilder();
		final StringBuilder valueBuffer1 = new StringBuilder();
		//Transition BH_tr = null;

		if( guard != null ) {
			final ValueSpecification valueSpec = guard.getSpecification();
			if( valueSpec instanceof OpaqueExpression ) {
				final OpaqueExpression opaqExpr = (OpaqueExpression)valueSpec;
				final String[] bodies = opaqExpr.getBodies().toArray(new String[opaqExpr.getBodies().size()]);
				final String[] languages = opaqExpr.getLanguages().toArray(new String[opaqExpr.getLanguages().size()]);
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

						 final EList<Element> constrainedElements = guard.getConstrainedElements();
						 if( ! constrainedElements.isEmpty() ) {
							 final Element constrainedElement = constrainedElements.get(0);
							 if( constrainedElement instanceof ExecutionOccurrenceSpecification ) {
								final ExecutionOccurrenceSpecification eos = (ExecutionOccurrenceSpecification) constrainedElement;

								if( eos.getExecution() instanceof BehaviorExecutionSpecification ) {
									final BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) eos.getExecution();

									if(bes.getFinish() == eos){
										if( bes.getBehavior() instanceof FunctionBehavior ) {
											final FunctionBehavior fb = (FunctionBehavior) bes.getBehavior();
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
							final State targetState = lfContext.createTargetState("targetBhExec#1" + transition.getName());

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
						addOpaqueBehaviorEffect(transition, valueBuffer.toString());
//						setGuard(transition, guard);
					}
				}
			}
			else if( valueSpec instanceof Expression ) {
				final Expression valueExpr = (Expression) valueSpec;
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
			final ValueSpecification value, final StringBuilder stringVar) {
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

			final Expression expr = (Expression) value;

			stringVar.append( (expr.getSymbol() != null) ?
					expr.getSymbol() : "<symbol:null>" );

			for(final ValueSpecification vs : expr.getOperands() ) {
				stringVar.append(" ");
				valueSpecificationToString(vs, stringVar);
			}

			stringVar.append(")");
		}

		else if( value instanceof OpaqueExpression ) {
			final OpaqueExpression expr = (OpaqueExpression) value;
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


	default void setGuard(final Transition transition,
			final InteractionConstraint interactionGuard, final Property indexVar) {
		if( interactionGuard != null ) {
			final Constraint constraint = transition.createGuard("guardConstraint");
			final ValueSpecification valueSpec = interactionGuard.getSpecification();

			final String loopIndexConstraint = toIndexConstraint(interactionGuard, indexVar);

			if( valueSpec instanceof OpaqueExpression ) {
				final OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardSpecification.getLanguages().addAll(((OpaqueExpression)valueSpec).getLanguages());
				guardSpecification.getBodies().addAll(((OpaqueExpression)valueSpec).getBodies());

				if( loopIndexConstraint.length() > 0 ) {
					guardSpecification.getLanguages().add(LANGUAGE_X_LIA);
					guardSpecification.getBodies().add(loopIndexConstraint.toString());
				}

				constraint.setSpecification(guardSpecification);
			}
			else {
				final OpaqueExpression guardExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
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

	default String toIndexConstraint(final InteractionConstraint interactionGuard, final Property indexVar) {
		if( interactionGuard != null ) {
			final StringBuilder loopIndexConstraint = new StringBuilder();
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


	default List< CombinedFragment > listOfCombinedFragment(final Interaction interaction) {
		final ArrayList<CombinedFragment> combinedFragments= new ArrayList<CombinedFragment>();

		for(final InteractionFragment fragment : interaction.getFragments() ) {
			if(fragment instanceof CombinedFragment){
				final CombinedFragment combinedFragment = (CombinedFragment) fragment;
				combinedFragments.add(combinedFragment);

				listOfCombinedFragment(combinedFragment, combinedFragments);
			}
		}

		return combinedFragments;
	}

	default void listOfCombinedFragment(
			final CombinedFragment combinedFragment, final List< CombinedFragment > combinedFragments) {
		for(final InteractionOperand operand : combinedFragment.getOperands() ) {
			for(final InteractionFragment fragment : operand.getFragments() ) {
				if(fragment instanceof CombinedFragment){
					final CombinedFragment combFragment = (CombinedFragment) fragment;
					combinedFragments.add(combFragment);

					listOfCombinedFragment(combFragment, combinedFragments);
				}
			}
		}
	}

}
