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
package org.eclipse.efm.formalml.xtext.ui.hover

import com.google.inject.Inject
import org.eclipse.efm.formalml.xtext.ui.labeling.FormalMLHoverLabelProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.internal.text.html.HTMLPrinter
import org.eclipse.jface.text.IRegion
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput
import org.eclipse.efm.ecore.formalml.infrastructure.Variable
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter
import org.eclipse.efm.ecore.formalml.infrastructure.Port
import org.eclipse.efm.ecore.formalml.infrastructure.Signal
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine
import org.eclipse.efm.ecore.formalml.infrastructure.Machine
import org.eclipse.efm.ecore.formalml.infrastructure.Function

class FormalMLEObjectHoverProvider extends DefaultEObjectHoverProvider  {
	
	/** Utility mapping keywords and hovertext. */
	@Inject 
	FormalMLKeywordHovers keywordHovers;

	override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject obj,
			IRegion region, XtextBrowserInformationControlInput prev) {
		if (obj instanceof Keyword) {
			val String html = getHoverInfoAsHtml(obj);
			if (html !== null) {
				var StringBuffer buffer = new StringBuffer(html);
				HTMLPrinter.insertPageProlog(buffer, 0, getStyleSheet());
				HTMLPrinter.addPageEpilog(buffer);
				return new XtextBrowserInformationControlInput(prev, obj, buffer.toString(), labelProvider);
			}
		}
		return super.getHoverInfo(obj, region, prev);
	}

	override protected String getHoverInfoAsHtml(EObject element) {
		if (element instanceof Keyword) {
			val hover = keywordHovers.hoverText(element as Keyword)
			if( hover !== null ) {
				return hover;
			}
		}
		return super.getHoverInfoAsHtml(element);
	}
	
	@Inject
	private FormalMLHoverLabelProvider fqnLabelProvider
	
	override protected ILabelProvider getLabelProvider () {
		return fqnLabelProvider;
	}
	
	
	override protected String getFirstLine(EObject element) {
		val clazz = "<code>" + element.eClass().getName().toLowerCase + "</code> "
		val label = getLabel(element)
		val description =
				" <b>" + ( if( label !== null ) label else "<anonym" ) + "</b>"

		switch( element ) {
		Variable:
			return clazz + element.type.label +  description
			
		Parameter:
			return clazz + element.type.label +  description
			
		Port:
			return clazz + element.direction +  description
			
		Signal:
			return clazz + element.direction +  description
			
		Function: {
			var hover =  clazz +  description + "("
			for( it : element.argument ) {
				hover += " " + it.type.label
			}
			hover += " ) ->"
			for( it : element.result ) {
				hover += " " + it.type.label
			}
			
			return hover
		}
		
		InstanceMachine:
			return "<code>instance</code> " + element.model.label +  description
			
		Statemachine:
			return clazz +  description
			
		Machine:
			return clazz +  description
//			return element.eClass.name + " <--> " + element.name
			
			
		default: return super.getFirstLine(element)
		}
	}
	
}