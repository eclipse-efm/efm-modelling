/*****************************************************************************
* Copyright (c) 2021 CEA LIST.
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
package org.eclipse.efm.formalml.plantuml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.specification.XliaModel;
import org.eclipse.efm.formalml.xtext.generator.FormalMLGenerator;
import org.eclipse.emf.ecore.EObject;

import net.sourceforge.plantuml.eclipse.utils.PlantumlConstants;

public class FML2PlantUMLText {

	public final static String DEFAULT_PUML_TEXT =
			PlantumlConstants.START_UML + "\n"
					+ "\nIViewPart -> FML2PUML: FML Diagram Text Request"
					+ "\nFML2PUML --> IViewPart: FML Diagram Text Response"
					+ "\n\n" + PlantumlConstants.END_UML;


	public final static String DEFAULT_PUML_FML_STYLE_HEADER = ""
			+ "\n\tskinparam backgroundColor White"

			+ "\n\tskinparam state {"
			+ "\n\t\tStartColor Green"
			+ "\n\t\tEndColor Red"

			+ "\n\t\t'Attribut pour les transitions"
			+ "\n\t\tArrowColor Black"
			+ "\n\t\tArrowColor<< Else >> Orange"

			+ "\n\t\t'Attribut par défaut pour les états"
			+ "\n\t\tBorderColor Gray"
			+ "\n\t\tBackgroundColor Wheat"

			+ "\n\t\t'Attribut pour les états composites"
			+ "\n\t\tBackgroundColor<< System       >> Turquoise"
			+ "\n\t\tBackgroundColor<< Statemachine >> DodgerBlue"
			+ "\n\t\tBackgroundColor<< Machine      >> SpringGreen"
			+ "\n\t\tBackgroundColor<< Instance     >> Orchid"
			+ "\n\t\tBackgroundColor<< Composite    >> SpringGreen"

			+ "\n\t\t'Attribut pour les états simples"
			+ "\n\t\tBackgroundColor<< simple_hierarchic >> PaleTurquoise"
			+ "\n\t\tBackgroundColor<< simple >> PaleTurquoise"
			+ "\n\t\tBackgroundColor<< start  >> Green"
			+ "\n\t\tBackgroundColor<< final >> Red"
			+ "\n\t\tBackgroundColor<< sync   >> Aqua"

			+ "\n\t\t'Attribut pour les pseudo-états"
			+ "\n\t\tBackgroundColor<< pseudostate >> Lavender"
			+ "\n\t\tBackgroundColor<< initial     >> GreenYellow"
			+ "\n\t\tBackgroundColor<< junction    >> GreenYellow"
			+ "\n\t\tBackgroundColor<< choice      >> Orange"
			+ "\n\t\tBackgroundColor<< fork        >> SpringGreen"
			+ "\n\t\tBackgroundColor<< junction    >> SpringGreen"
			+ "\n\t\tBackgroundColor<< dhistory    >> SpringGreen"
			+ "\n\t\tBackgroundColor<< shistory    >> SpringGreen"
			+ "\n\t\tBackgroundColor<< return      >> OrangeRed"
			+ "\n\t\tBackgroundColor<< terminal    >> Red"

			+ "\n\t\tFontColor Black"
			+ "\n\t\tFontName Times"
			+ "\n\t\tFontSize 14"
			+"\n\t}\n\n";



	protected void addStyleHeader(final StringBuilder buffer) {
		buffer.append(DEFAULT_PUML_FML_STYLE_HEADER);
	}

	public String FML2PUML(final List<? extends EObject> eObjs) {

		final FormalMLGenerator fmlGen = new FormalMLGenerator();

		final StringBuilder buffer = new StringBuilder(PlantumlConstants.START_UML + "\n\n");


//		initStyle();
//		Visitor v = initVisitor();
//		v.setSysML2PlantUMLText(this);
//
		addStyleHeader(buffer);
//
//		initIdMap();
//
		for (final EObject eObj : eObjs) {
			if (eObj instanceof Machine) {
				buffer.append( fmlGen.generateMachineGraphic((Machine) eObj) );
			}
			else if (eObj instanceof XliaModel) {
				buffer.append( fmlGen.generateMachineGraphic(((XliaModel) eObj).getSystem()) );
			}
		}


//		buffer.append(v.getString());
//		return buffer.toString();

		if( buffer.length() > PlantumlConstants.START_UML.length() + 7) {
			buffer.append("\n\n" + PlantumlConstants.END_UML);

			return buffer.toString();
		}

		return DEFAULT_PUML_TEXT;
	}


	public List<? extends EObject> setupVisualizationEObjects(final EObject eObj) {
		if (eObj != null) {
			EObject eObjParent = eObj;
			while (eObjParent != null && !((eObjParent instanceof Machine) || (eObjParent instanceof XliaModel))) {
				eObjParent = eObjParent.eContainer();
			}
			if (eObjParent != null) {
				final List<EObject> eObjs = new ArrayList<EObject>(1);
				eObjs.add(eObjParent);

				return eObjs;
			}

		}
		return null;
	}

}
