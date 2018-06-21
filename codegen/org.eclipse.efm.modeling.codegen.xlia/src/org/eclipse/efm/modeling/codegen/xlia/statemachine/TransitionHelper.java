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
package org.eclipse.efm.modeling.codegen.xlia.statemachine;

import org.eclipse.efm.modeling.codegen.xlia.util.UmlFactory;
import org.eclipse.efm.modeling.codegen.xlia.util.XliaConstants;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public interface TransitionHelper extends UmlFactory , XliaConstants{

	///////////////////////////////////////////////////////////////////////////
	// TRANSITION
	///////////////////////////////////////////////////////////////////////////

	public default void addOpaqueExpressionGuard(Transition transition, String opaqExpression) {
		Constraint constraint = transition.createGuard("guard");
		OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
		guardSpecification.getLanguages().add(LANGUAGE_X_LIA);
		guardSpecification.getBodies().add(opaqExpression);
		constraint.setSpecification(guardSpecification);
	}

	public default void addOpaqueBehaviorEffect(Transition transition, Behavior behavior) {
		if( behavior instanceof OpaqueBehavior ) {
			addOpaqueBehaviorEffect(transition, (OpaqueBehavior) behavior);
		}
		else if( behavior != null ) {
			OpaqueBehavior effectBehavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
			effectBehavior.getLanguages().add(LANGUAGE_X_LIA);
			effectBehavior.getBodies().add("TODO translate Behavior " + behavior.getName());
			effectBehavior.setName("effect");

			transition.setEffect(effectBehavior);
		}
		else {
			// TODO why null
		}
	}

	public default void addOpaqueBehaviorEffect(Transition transition, OpaqueBehavior opaqBehavior) {
		Behavior behavior = transition.getEffect();

		OpaqueBehavior effectBehavior = null;
		if(behavior instanceof OpaqueBehavior) {
			effectBehavior = (OpaqueBehavior) behavior;
		}

		if( effectBehavior == null ) {
			effectBehavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
			effectBehavior.setName("effect");
			transition.setEffect(effectBehavior);

		}

		effectBehavior.getLanguages().addAll(opaqBehavior.getLanguages());
		effectBehavior.getBodies().addAll(opaqBehavior.getBodies());
	}

	public default void addOpaqueBehaviorEffect(Transition transition, String opaqBehavior) {
		Behavior behavior = transition.getEffect();

		OpaqueBehavior effectBehavior = null;
		if(behavior instanceof OpaqueBehavior) {
			effectBehavior = (OpaqueBehavior) behavior;
		}

		if( effectBehavior == null ) {
			effectBehavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
			effectBehavior.setName("effect");
			transition.setEffect(effectBehavior);
		}

		effectBehavior.getLanguages().add(LANGUAGE_X_LIA);
		effectBehavior.getBodies().add(opaqBehavior);
	}

	public default void setGuard(Transition transition, Constraint guard) {
		if( guard != null ) {
			Constraint constraint = transition.createGuard("guardConstraint");
			ValueSpecification valueSpec = guard.getSpecification();
			if( valueSpec instanceof OpaqueExpression ) {
				OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardSpecification.getLanguages().addAll(((OpaqueExpression)valueSpec).getLanguages());
				guardSpecification.getBodies().addAll(((OpaqueExpression)valueSpec).getBodies());
				constraint.setSpecification(guardSpecification);
			}
			else if( valueSpec instanceof Expression ) {
				Expression valueExpr = (Expression) valueSpec;
				Expression guardExpression = UMLFactory.eINSTANCE.createExpression();

				guardExpression.setSymbol(valueExpr.getSymbol());
				for(ValueSpecification vs : valueExpr.getOperands() ) {
					guardExpression.getOperands().add(vs);
				}

				constraint.setSpecification(guardExpression);
			}
			else {
				StringBuilder valueBuffer = new StringBuilder();
				stringOfValueSpecification(valueSpec, valueBuffer);

				OpaqueExpression guardExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardExpression.getLanguages().add(LANGUAGE_X_LIA);
				guardExpression.getBodies().add(valueBuffer.toString());
				guardExpression.setName("guardExpression");

				constraint.setSpecification(guardExpression);
			}
		}
	}

	public default void setGuard(Transition transition, String guard) {
		OpaqueExpression guardExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
		guardExpression.getLanguages().add(LANGUAGE_X_LIA);
		guardExpression.getBodies().add(guard);
		guardExpression.setName("guardExpression");

		Constraint constraint = transition.createGuard("guardConstraint");
		constraint.setSpecification(guardExpression);
	}

}
