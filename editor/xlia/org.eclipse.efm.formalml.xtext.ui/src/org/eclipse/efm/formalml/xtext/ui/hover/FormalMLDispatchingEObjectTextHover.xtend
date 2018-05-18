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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.util.Pair;

class FormalMLDispatchingEObjectTextHover extends DispatchingEObjectTextHover {
	
	@Inject
	FormalMLKeywordAtOffsetHelper keywordAtOffsetHelper;

	@Inject
	IEObjectHoverProvider hoverProvider;

	var IInformationControlCreatorProvider lastCreatorProvider = null;

	override public Object getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
		if (first instanceof Keyword) {
			lastCreatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
			return if (lastCreatorProvider === null) null else  lastCreatorProvider.getInfo();
		}
		
		lastCreatorProvider = null;
		
		return super.getHoverInfo(first, textViewer, hoverRegion);
	}

	override public IInformationControlCreator getHoverControlCreator() {
		return if(this.lastCreatorProvider === null)
				super.getHoverControlCreator()
				else lastCreatorProvider.getHoverControlCreator();
	}

	override protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		var Pair<EObject, IRegion> result = super.getXtextElementAt(resource, offset);
		if (result === null) {
			result = keywordAtOffsetHelper.resolveKeywordAt(resource, offset);
		}
		return result;
	}
}