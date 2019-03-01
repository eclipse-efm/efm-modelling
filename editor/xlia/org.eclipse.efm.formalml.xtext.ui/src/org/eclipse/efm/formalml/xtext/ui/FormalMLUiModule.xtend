/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
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
package org.eclipse.efm.formalml.xtext.ui

import org.eclipse.efm.formalml.xtext.ui.hover.FormalMLDispatchingEObjectTextHover;
import org.eclipse.efm.formalml.xtext.ui.hover.FormalMLEObjectDocumentationProvider;
import org.eclipse.efm.formalml.xtext.ui.hover.FormalMLEObjectHoverProvider;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.ui.editor.hover.IEObjectHover

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class FormalMLUiModule extends AbstractFormalMLUiModule {
	
	override Class<? extends IEObjectHover> bindIEObjectHover() {
		return FormalMLDispatchingEObjectTextHover;
	}
	 
	def Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return FormalMLEObjectHoverProvider;
	}
	 
	def Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
		return FormalMLEObjectDocumentationProvider;
	}
	
}
