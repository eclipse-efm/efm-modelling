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
	default void fillMapOfTimedObservation(Interaction interaction,
			HashMap<OccurrenceSpecification, TimeObservation> mapOfTObs) {
		EObject eobj = interaction;
		EList<PackageableElement> packElems = null;
		Boolean obsFound = false;

		while (!obsFound && eobj.eContainer() != null) {
			if (eobj.eContainer() instanceof Package){
				packElems = ((Package)eobj.eContainer()).getPackagedElements();

				Iterator<PackageableElement> iterator2 = packElems.iterator();

				while (iterator2.hasNext() && !obsFound) {
					PackageableElement packElt = iterator2
						.next();
					if (packElt instanceof TimeObservation) {
						obsFound = true;
					}
				}
			}
			eobj = eobj.eContainer();
		}
		if (packElems != null) {
			Iterator<PackageableElement> iterator1 = packElems.iterator();
			while (iterator1.hasNext()) {
				PackageableElement packElt = iterator1
						.next();
				if (packElt instanceof TimeObservation) {
					TimeObservation tObs =(TimeObservation)packElt ;
					//System.err.println("Ici : "+tObs.getName());
					//System.err.println("Ici : "+((OccurrenceSpecification)tObs.getEvent()).getName());
					//mapOfTObs.put(((OccurrenceSpecification)tObs.getEvent()).getName(), tObs);
					mapOfTObs.put((OccurrenceSpecification)tObs.getEvent(), tObs);
				}
			}
		}
	}


	default void declareTimeObsVariables(Model model, PrettyPrintWriter writer) {
		declareTimeObsVariables(model.allOwnedElements(), writer);
	}

	default void declareTimeObsVariables(Interaction interaction, PrettyPrintWriter writer) {
		declareTimeObsVariables(interaction.allOwnedElements(), writer);
	}

	default void declareTimeObsVariables(List< Element > allOwnedElements, PrettyPrintWriter writer) {
		writer.appendTab2Eol("// Interaction TimeObservations declaration");
		for( Element eltObs : allOwnedElements ) {
			//declare timeObservation variables
			if( eltObs instanceof TimeObservation ) {
				declareTimeObsTab((TimeObservation) eltObs, writer);
			}
		}
		writer.appendTab2Eol2("// end Interaction TimeObservations declaration");
	}

	default void declareTimeObsTab(TimeObservation timeObs, PrettyPrintWriter writer) {
		writer.appendTab2("var ")
	        .append("vector<integer> ")
	        .append(timeObs.getName())
            .appendEol( ";" );

		writer.appendTab2("var ")
	        .append("integer ")
	        .append( nameOfTimeObservationIndex(timeObs) )
	        .appendEol( " = 0;" );
	}


	default String transformTimedConstraint(String constraintAsString) {
		// processes a timed constraint in order to get a Weak form of a time formula
	    //        to avoid the case where index expressions are out of range

		ArrayList<String> indexExpressions = new ArrayList<String>();

		String indexExpr = "";
		boolean startIndexExpr = false;

		for (int i = 0; i < constraintAsString.length(); i++) {
			 // Get the char
		    char ch = constraintAsString.charAt(i);

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

		String tguardStr = "tguard(" + constraintAsString + ")";

		if (indexExpressions.isEmpty()){
			//case no index expression in the constraint
			return tguardStr;
		}
		else{
			StringBuilder constraintBuffer = new StringBuilder();

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

	default void addTimeObservation(Transition transition,
			OccurrenceSpecification occurrenceSpecification,
			HashMap<OccurrenceSpecification, TimeObservation> mapOfTObs)
	{
		TimeObservation timeObs = mapOfTObs.get(occurrenceSpecification);
		if( timeObs != null ) {
			StringBuilder timeObsStatement = new StringBuilder();
			timeObsStatement.append(timeObs.getName())
				.append(" <=< $time;");

			addOpaqueBehaviorEffect(transition, timeObsStatement.toString());
		}
	}

	default void incrementTimeObservationIndex(Transition transition,
			OccurrenceSpecification occurrenceSpecification,
			HashMap<OccurrenceSpecification, TimeObservation> mapOfTObs)
	{
		TimeObservation timeObs = mapOfTObs.get(occurrenceSpecification);
		if( timeObs != null ) {
			StringBuilder timeObsStatement = new StringBuilder();
			final String index = nameOfTimeObservationIndex(timeObs);
			timeObsStatement.append(index)
				.append(" = ")
				.append(index)
				.append(" + 1;");

			addOpaqueBehaviorEffect(transition, timeObsStatement.toString());
		}
	}

}
