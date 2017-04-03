/*****************************************************************************
 * Copyright (c) 2015, 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   J�r�mie Tatibouet (CEA LIST)
 *
 *****************************************************************************/

package org.eclipse.efm.papyrus.view.property.concretesyntax.sheet.tooling.listeners;

import org.eclipse.efm.papyrus.view.property.concretesyntax.sheet.EditingPropertySection;
//import org.eclipse.papyrus.uml.alf.transaction.commit.ScenarioFactory;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
//import org.eclipse.uml2.uml.NamedElement;

public class EditorFocusListener extends FocusAdapter {


//	private XliaEditionPropertySection section;

	public EditorFocusListener(EditingPropertySection section) {
//		this.section = section;
	}

	/**
	 * When the ALF editor looses the focus, this triggers the execution of a backup sequence.
	 * This backup sequence saves the current state of the textual definition of the current model element.
	 * Modifications introduced in text are not propagated in the current model element.
	 */
	@Override
	public void focusLost(FocusEvent event) {
		/* 1. Retrieve the alf editor */
		StyledText xliaEditor = null;
		if (event.getSource() instanceof StyledText) {
			xliaEditor = (StyledText) event.getSource();
		}
		/* 2. Save the textual representation */
		if (xliaEditor != null) {
//			ScenarioFactory.getInstance().createSaveScenario().
//					execute((NamedElement) this.section.getContextObject(), xliaEditor.getText());
		}

	}
}
