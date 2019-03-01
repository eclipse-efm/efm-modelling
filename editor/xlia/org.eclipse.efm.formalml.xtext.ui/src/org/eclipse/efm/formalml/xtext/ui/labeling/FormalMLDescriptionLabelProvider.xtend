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
package org.eclipse.efm.formalml.xtext.ui.labeling

import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import org.eclipse.efm.ecore.formalml.common.NamedElement

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class FormalMLDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	// Labels and icons can be computed like this:
	
//	override text(IEObjectDescription ele) {
//		ele.name.toString
//	}
//	 
//	override image(IEObjectDescription ele) {
//		ele.EClass.name + '.gif'
//	}

	@Inject
	IQualifiedNameProvider nameProvider;

	def nameID(NamedElement element, String nullNameID) {
		val fqn = nameProvider.getFullyQualifiedName(element);

		fqn?.toString ?: "no qfn: " + ( element.name ?: nullNameID )
	}

	def nameID(NamedElement element) {
		val fqn = nameProvider.getFullyQualifiedName(element);

		fqn?.toString ?: "no qfn: " + element.name
	}


	def text(NamedElement element) {
		val fqn = nameProvider.getFullyQualifiedName(element);

		fqn?.toString ?: "no qfn: " +
			( element.name ?: ("<unamed-" + element.eClass().getName + ">") )
	}


}
