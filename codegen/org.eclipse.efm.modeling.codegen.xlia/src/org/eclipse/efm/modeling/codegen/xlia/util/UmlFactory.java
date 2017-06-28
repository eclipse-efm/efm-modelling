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
package org.eclipse.efm.modeling.codegen.xlia.util;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class UmlFactory {
	private static final String LANGUAGE_X_LIA = "xLIA";
	

	///////////////////////////////////////////////////////////////////////////
	// STATEMACHINE
	///////////////////////////////////////////////////////////////////////////
	
	public static StateMachine createStateMachine(String name) {
		StateMachine statemachine = UMLFactory.eINSTANCE.createStateMachine();
		statemachine.setName(name);
		
		statemachine.createRegion(name);
		
		return( statemachine );
	}
	
	///////////////////////////////////////////////////////////////////////////
	// TYPE
	///////////////////////////////////////////////////////////////////////////
	
	private static Type intType = null;
	public static Type integerType() {
		if( intType == null ) {
			intType = UMLFactory.eINSTANCE.createPrimitiveType();
			intType.setName("int");
		}
		
		return( intType );
	}
	
	private static Type boolType = null;
	public static Type booleanType() {
		if( boolType == null ) {
			boolType = UMLFactory.eINSTANCE.createPrimitiveType();
			boolType.setName("bool");
		}
		
		return( boolType );
	}
	
	private static Type stringType = null;
	public static Type stringType() {
		if( stringType == null ) {
			stringType = UMLFactory.eINSTANCE.createPrimitiveType();
			stringType.setName("string");
		}
		
		return( stringType );
	}
	
	
	private static Type fifoIntType = null;
	public static Type fifoIntType() {
		if( fifoIntType == null ) {
			fifoIntType = UMLFactory.eINSTANCE.createPrimitiveType();
			fifoIntType.setName("fifo<integer , *>");
		}
		
		return( fifoIntType );
	}
	
	public static Type fifoIntType(int size) {
		Type fifoIntType = UMLFactory.eINSTANCE.createPrimitiveType();
		fifoIntType.setName("fifo<integer , " + size + " >");
		
		return( fifoIntType );
	}
	

	///////////////////////////////////////////////////////////////////////////
	// PROPERTY
	///////////////////////////////////////////////////////////////////////////
	
	public static Property createVariable(
			StateMachine statemachine, String name, Type type) {
		Property variable = statemachine.createOwnedAttribute(name, type);
		
		return( variable );
	}
	
	///////////////////////////////////////////////////////////////////////////
	// PSEUDO STATE
	///////////////////////////////////////////////////////////////////////////
	
	public static Pseudostate createInitialState(Region region, String name) {		
		Pseudostate state = (Pseudostate) region.createSubvertex(
				name, UMLPackage.eINSTANCE.getPseudostate());
		
		state.setKind(PseudostateKind.INITIAL_LITERAL);
		
		return( state );
	}

	public static Pseudostate createPseudoState(
			Region region, String name, PseudostateKind kind) {
		
		Pseudostate state = (Pseudostate) region.createSubvertex(
				name, UMLPackage.eINSTANCE.getPseudostate());
		
		state.setKind(kind);
		
		return( state );
	}

	///////////////////////////////////////////////////////////////////////////
	// TRANSITION
	///////////////////////////////////////////////////////////////////////////
		
	public static void addOpaqueExpressionGuard(Transition transition, String opaqExpression) {
		Constraint constraint = transition.createGuard("guard");
		OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
		guardSpecification.getLanguages().add(LANGUAGE_X_LIA);
		guardSpecification.getBodies().add(opaqExpression);
		constraint.setSpecification(guardSpecification);
	}
	
	public static void addOpaqueBehaviorEffect(Transition transition, Behavior behavior) {
		if( behavior instanceof OpaqueBehavior ) {
			UmlFactory.addOpaqueBehaviorEffect(transition, (OpaqueBehavior) behavior);
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
	
	public static void addOpaqueBehaviorEffect(Transition transition, OpaqueBehavior opaqBehavior) {
		OpaqueBehavior effectBehavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
		effectBehavior.getLanguages().addAll(opaqBehavior.getLanguages());
		effectBehavior.getBodies().addAll(opaqBehavior.getBodies());
		effectBehavior.setName("effect");

		transition.setEffect(effectBehavior);
	}
	
	public static void addOpaqueBehaviorEffect(Transition transition, String opaqBehavior) {
		OpaqueBehavior effectBehavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
		effectBehavior.getLanguages().add(LANGUAGE_X_LIA);
		effectBehavior.getBodies().add(opaqBehavior);
		effectBehavior.setName("effect");

		transition.setEffect(effectBehavior);
	}

	public static void setGuard(Transition transition, Constraint guard) {
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
				StringBuffer valueBuffer = new StringBuffer();
				valueSpecificationToString(valueSpec, valueBuffer);

				OpaqueExpression guardExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardExpression.getLanguages().add(LANGUAGE_X_LIA);	
				guardExpression.getBodies().add(valueBuffer.toString());
				guardExpression.setName("guardExpression");
				
				constraint.setSpecification(guardExpression);
			}
		}
	}
	
	
	public static void valueSpecificationToString(
			ValueSpecification value, StringBuffer stringVar) {
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


	public static void setGuard(Transition transition,
			InteractionConstraint interactionGuard, Property indexVar) {
		if( interactionGuard != null ) {
			Constraint constraint = transition.createGuard("guardConstraint");
			ValueSpecification valueSpec = interactionGuard.getSpecification();
			
			StringBuffer loopIndexConstraint = new StringBuffer();
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
	
	
}
