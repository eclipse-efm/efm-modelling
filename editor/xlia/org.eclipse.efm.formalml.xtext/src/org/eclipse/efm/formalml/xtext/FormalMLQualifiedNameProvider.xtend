/*****************************************************************************
* Copyright (c) 2012 CEA LIST.
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
package org.eclipse.efm.formalml.xtext;

import org.eclipse.efm.ecore.formalml.common.NamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import java.util.LinkedList

class FormalMLQualifiedNameProvider
		extends DefaultDeclarativeQualifiedNameProvider {

	override QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof NamedElement) {
			getFullyQualifiedName(obj as NamedElement)
		} else {
			super.getFullyQualifiedName(obj)
		}
	}

	def QualifiedName getFullyQualifiedName(NamedElement form) {
		val FQN = new LinkedList<String>()
		var name = form.getName()
		if (name !== null) {
			FQN.add(name)
		} 
		else {
//    		return QualifiedName.EMPTY;
			return null
		}

		var container = form.eContainer();
		while (container !== null) {
			if (container instanceof NamedElement) {
				name = container.getName();
				if (name !== null) {
					FQN.addFirst(name)
				}
			}
			container = container.eContainer()
		}
		
		QualifiedName.create(FQN)
	}

	def QualifiedName qualifiedName(NamedElement form) {
		var container = form.eContainer();
		while( (container !== null)
			&& (! (container instanceof NamedElement)) )
		{
			container = container.eContainer()
		}
		
		if (container !== null) {
			QualifiedName.create(
				(container as NamedElement).getName(), form.getName())
		} 
		else {
			QualifiedName.create(form.getName())
		}
	}

}

