/*******************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementationon
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.interaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.efm.modeling.codegen.xlia.statemachine.TransitionHelper;
import org.eclipse.efm.modeling.codegen.xlia.util.PrettyPrintWriter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Transition;

public interface TimeObservationHelper extends NameHelper , TransitionHelper {

	/**
	 * @param UML Interaction
	 * @return create and fill timed observation hash table
	 */
	default void fillMapOfTimedObservation(final Interaction interaction,
			final HashMap<OccurrenceSpecification, TimeObservation> mapOfTObs) {
		EObject eobj = interaction;
		EList<PackageableElement> packElems = null;
		Boolean obsFound = false;

		while (!obsFound && eobj.eContainer() != null) {
			if (eobj.eContainer() instanceof Package){
				packElems = ((Package)eobj.eContainer()).getPackagedElements();

				final Iterator<PackageableElement> iterator2 = packElems.iterator();

				while (iterator2.hasNext() && !obsFound) {
					final PackageableElement packElt = iterator2
						.next();
					if (packElt instanceof TimeObservation) {
						obsFound = true;
					}
				}
			}
			eobj = eobj.eContainer();
		}
		if (packElems != null) {
			final Iterator<PackageableElement> iterator1 = packElems.iterator();
			while (iterator1.hasNext()) {
				final PackageableElement packElt = iterator1
						.next();
				if (packElt instanceof TimeObservation) {
					final TimeObservation tObs =(TimeObservation)packElt ;
					//System.err.println("Ici : "+tObs.getName());
					//System.err.println("Ici : "+((OccurrenceSpecification)tObs.getEvent()).getName());
					//mapOfTObs.put(((OccurrenceSpecification)tObs.getEvent()).getName(), tObs);
					mapOfTObs.put((OccurrenceSpecification)tObs.getEvent(), tObs);
				}
			}
		}
	}


	default void declareTimeObsVariables(final Model model, final PrettyPrintWriter writer) {
		declareTimeObsVariables(model.allOwnedElements(), writer);
	}

	default void declareTimeObsVariables(final Interaction interaction, final PrettyPrintWriter writer) {
		declareTimeObsVariables(interaction.allOwnedElements(), writer);
	}

	default void declareTimeObsVariables(final List< Element > allOwnedElements, final PrettyPrintWriter writer) {
		writer.appendTab2Eol("// Interaction TimeObservations declaration");
		for( final Element eltObs : allOwnedElements ) {
			//declare timeObservation variables
			if( eltObs instanceof TimeObservation ) {
				declareTimeObsTab((TimeObservation) eltObs, writer);
			}
		}
		writer.appendTab2Eol2("// end Interaction TimeObservations declaration");
	}

	default void declareTimeObsTab(final TimeObservation timeObs, final PrettyPrintWriter writer) {
		writer.appendTab2("var ")
	        .append("vector<integer> ")
	        .append(timeObs.getName())
            .appendEol( ";" );

		writer.appendTab2("var ")
	        .append("integer ")
	        .append( nameOfTimeObservationIndex(timeObs) )
	        .appendEol( " = 0;" );
	}


	default String transformTimedConstraint(final String constraintAsString) {
		// processes a timed constraint in order to get a Weak form of a time formula
	    //        to avoid the case where index expressions are out of range

		final ArrayList<String> indexExpressions = new ArrayList<String>();

		String indexExpr = "";
		boolean startIndexExpr = false;

		for (int i = 0; i < constraintAsString.length(); i++) {
			 // Get the char
		    final char ch = constraintAsString.charAt(i);

			if (ch=='[') {
				startIndexExpr = true;
				indexExpr = "(";
			}
			else{
				if (ch==']'){
					startIndexExpr = false;
					indexExpressions.add(indexExpr.concat(">=0)"));
					indexExpr = "";
				}else{
					if (startIndexExpr) indexExpr=indexExpr.concat(Character.toString(ch));
				}
			}
		}

		final String tguardStr = "tguard(" + constraintAsString + ");";

		if (indexExpressions.isEmpty()){
			//case no index expression in the constraint
			return tguardStr;
		}
		else{
			final StringBuilder constraintBuffer = new StringBuilder();

			constraintBuffer.append( "if( " )
				.append( indexExpressions.get(0) );
			for (int i = 1; i < indexExpressions.size(); i++) {
				constraintBuffer.append( " && " )
					.append( indexExpressions.get(i) );
			}

			constraintBuffer.append( " ) {\n" )
				.append("\t").append( tguardStr )
				.append("\n}");

		    return constraintBuffer.toString();
		}
	}

	default void addTimeObservation(final Transition transition,
			final OccurrenceSpecification occurrenceSpecification,
			final HashMap<OccurrenceSpecification, TimeObservation> mapOfTObs)
	{
		final TimeObservation timeObs = mapOfTObs.get(occurrenceSpecification);
		if( timeObs != null ) {
			final StringBuilder timeObsStatement = new StringBuilder();
			timeObsStatement.append(timeObs.getName())
				.append(" <=< $time;");

			addOpaqueBehaviorEffect(transition, timeObsStatement.toString());
		}
	}

	default void incrementTimeObservationIndex(final Transition transition,
			final OccurrenceSpecification occurrenceSpecification,
			final HashMap<OccurrenceSpecification, TimeObservation> mapOfTObs)
	{
		final TimeObservation timeObs = mapOfTObs.get(occurrenceSpecification);
		if( timeObs != null ) {
			final StringBuilder timeObsStatement = new StringBuilder();
			final String index = nameOfTimeObservationIndex(timeObs);
			timeObsStatement.append(index)
				.append(" = ")
				.append(index)
				.append(" + 1;");

			addOpaqueBehaviorEffect(transition, timeObsStatement.toString());
		}
	}

}
