/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml.diagram.statemachine.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.efm.formalml.util.PrintingUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.uml.textedit.transition.xtext.ui.contributions.TransitionEditorConfigurationContribution;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Transition;

public class TransitionParser implements IParser{
	static TransitionEditorConfigurationContribution configuration = new TransitionEditorConfigurationContribution();
	
	@Override
	public String getEditString(IAdaptable element, int flags) {
		if(element instanceof EObjectAdapter)
			return configuration.getTextToEdit(((EObjectAdapter) element).getRealObject()).trim();
		else return "org.eclipse.efm.papyrus.xtext.transition : function getEditString, not a EObjectAdapter";
	}

	@Override
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		IParser ip = ((DefaultXtextDirectEditorConfiguration)configuration).createParser((EObject) element);
		return ip.getParseCommand(element, newString, flags);
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {
		if(element instanceof EObjectAdapter)
//			return configuration.getTextToEdit(((EObjectAdapter) element).getRealObject());
			return printTransition((Transition)((EObjectAdapter) element).getRealObject());
		else return "org.eclipse.efm.papyrus.xtext.transition : function getEditString, not a EObjectAdapter";
	}

	public String printTransition(Transition realObject) {
		return PrintingUtil.print((Element) realObject);
	}

	@Override
	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
