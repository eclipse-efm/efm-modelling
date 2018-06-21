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

import org.eclipse.efm.modeling.codegen.xlia.util.XliaConstants;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public interface StatemachineFactory extends XliaConstants{

	///////////////////////////////////////////////////////////////////////////
	// STATEMACHINE
	///////////////////////////////////////////////////////////////////////////

	public default StateMachine createStateMachine(String name) {
		StateMachine statemachine = UMLFactory.eINSTANCE.createStateMachine();

		statemachine.setName(name);

		statemachine.createRegion(name);

		return( statemachine );
	}


	///////////////////////////////////////////////////////////////////////////
	// PSEUDO STATE
	///////////////////////////////////////////////////////////////////////////

	public default Pseudostate createInitialState(Region region, String name) {
		Pseudostate state = (Pseudostate) region.createSubvertex(
				name, UMLPackage.eINSTANCE.getPseudostate());

		state.setKind(PseudostateKind.INITIAL_LITERAL);

		return( state );
	}

	public default Pseudostate createPseudoState(
			Region region, String name, PseudostateKind kind) {

		Pseudostate state = (Pseudostate) region.createSubvertex(
				name, UMLPackage.eINSTANCE.getPseudostate());

		state.setKind(kind);

		return( state );
	}

}
