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

import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.TimeObservation;

public interface NameHelper {

	default String qualifiedNameOf(Lifeline lifeline) {
		StringBuilder buffer = new StringBuilder();

		buffer.append( lifeline.getRepresents().getType().getName() )
			.append( "#" )
			.append(lifeline.getName())
			.append( "." )
			.append(lifeline.getName());

		return buffer.toString();
	}

	default String nameOfMessageParamsVariable(Message message) {
		return message.getName() + "#params";
	}


	default String nameOfSchedulingVariable(
			CombinedFragment combinedFragment)
	{
		StringBuilder buffer = new StringBuilder();

		buffer.append( combinedFragment.getName() )
		.append( "#Schedule" );


		return buffer.toString();
	}

	default String nameOfScheduledRegionVariable(
			CombinedFragment combinedFragment)
	{
		StringBuilder buffer = new StringBuilder();

		buffer.append( combinedFragment.getName() )
			.append( "#current#schedule#region" );

		return buffer.toString();
	}

	default String nameOfEnumRegionsType(CombinedFragment combinedFragment) {
		StringBuilder buffer = new StringBuilder();

		buffer.append( "Enum#")
			.append( combinedFragment.getName() );

		return buffer.toString();
	}


	default String nameOfEnumLiteralRegionOUT(CombinedFragment combinedFragment) {
		StringBuilder buffer = new StringBuilder();
		buffer.append( "Region#")
			.append( combinedFragment.getName() )
			.append("#OUT");

		return buffer.toString();
	}

	default String qualifiedNameOfEnumLiteralRegionOUT(
			CombinedFragment combinedFragment)
	{
		StringBuilder buffer = new StringBuilder();
		buffer.append(nameOfEnumRegionsType(combinedFragment))
			.append( ".Region#")
			.append( combinedFragment.getName() )
			.append("#OUT");

		return buffer.toString();
	}


	default String nameOfEnumLiteralRegion(InteractionOperand interactionOperand) {
		StringBuilder buffer = new StringBuilder();
		buffer.append( "Region#")
			.append( interactionOperand.getName() );

		return buffer.toString();
	}

	default String qualifiedNameOfEnumLiteralRegion(
			InteractionOperand interactionOperand)
	{
		CombinedFragment combinedFragment =
				(CombinedFragment)(interactionOperand.eContainer());

		StringBuilder buffer = new StringBuilder();
		buffer.append(nameOfEnumRegionsType(combinedFragment))
			.append( ".Region#")
			.append( interactionOperand.getName() );

		return buffer.toString();
	}


	default String nameOfEntryTransitionFragment(
			InteractionFragment interactionFragment,
			String interactionOperator, boolean isFirst)
	{
		StringBuilder buffer = new StringBuilder();

		buffer.append("tr_").append(interactionOperator)
			.append(isFirst ?  "first#" : "entry#" )
			.append(interactionFragment.getName());

		return buffer.toString();
	}


	default String nameOfTimeObservationIndex(TimeObservation timeObs) {
		return "i_" + timeObs.getName();
	}


}
