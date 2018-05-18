/**
 * Copyright (c) 2018 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.formalml.xtext.ui.labeling

import org.eclipse.efm.formalml.xtext.ui.labeling.FormalMLLabelProvider
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.efm.ecore.formalml.common.NamedElement
import com.google.inject.Inject
import org.eclipse.efm.ecore.formalml.statemachine.State
import org.eclipse.efm.ecore.formalml.statemachine.Pseudostate
import org.eclipse.efm.ecore.formalml.statemachine.Transition
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine
import org.eclipse.jface.viewers.StyledString
import org.eclipse.efm.ecore.formalml.infrastructure.Machine

class FormalMLHoverLabelProvider extends FormalMLLabelProvider {
	
	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}
	
	override nameID(NamedElement element, String nullNameID) {
		element.fqnNameID(nullNameID)
	}

	override nameID(NamedElement element) {
		element.fqnNameID
	}

	override text(Pseudostate state) {
		new StyledString( state.fqnNameID( "<pseudostate>" ) )
	}

	override text(State state) {
		new StyledString( state.fqnNameID( "<state>" ) )
	}
	
	override text(Statemachine statemachine) {
		new StyledString( statemachine.fqnNameID( "<statemachine>" ) )
	}
	
	override text(Transition transition) {
		new StyledString( transition.fqnNameID( "<transition>" ) )
	}
	
	override text(Machine machine) {
		new StyledString( machine.fqnNameID( "<machine>" ) )
	}
	
	
}