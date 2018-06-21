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

import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

public interface UmlFactory {

	///////////////////////////////////////////////////////////////////////////
	// PROPERTY
	///////////////////////////////////////////////////////////////////////////

	public default Property createVariable(
			StateMachine statemachine, String name, Type type) {
		Property variable = statemachine.createOwnedAttribute(name, type);

		return( variable );
	}


	///////////////////////////////////////////////////////////////////////////
	// UTILS FOR SCHEDULE REGION IN COMBINED FRAGMENT
	///////////////////////////////////////////////////////////////////////////

	public default void stringOfValueSpecification(
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
				stringOfValueSpecification(vs, stringVar);
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

}
