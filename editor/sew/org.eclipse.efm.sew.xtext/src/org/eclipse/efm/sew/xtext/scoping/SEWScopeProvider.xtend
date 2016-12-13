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
package org.eclipse.efm.sew.xtext.scoping

import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.efm.ecore.sew.WObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.efm.ecore.sew.expression.LiteralObjectReference
import org.eclipse.efm.ecore.sew.WSection

/**
 * This class contains custom scoping description.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class SEWScopeProvider extends AbstractSEWScopeProvider {

	def scope_LiteralObject_object(LiteralObjectReference context, EReference r) {
		val contextObject = EcoreUtil2.getContainerOfType(
			context.eContainer, typeof(WObject) )

		var parentScope = IScope::NULLSCOPE

		for( object : contextObject.objectHierarchy.reverseView ) {
			for( property : object.element.filter( typeof(WSection) )) {
				parentScope = Scopes::scopeFor(
					property.element.filter( typeof(WObject) ), parentScope)
			}
		}

		parentScope
	}


	def objectHierarchy(WObject object) {
		val hierarchy = <WObject>newArrayList()

		var container = EcoreUtil2.getContainerOfType(
			object.eContainer, typeof(WObject) )

		while( container != null ) {
			hierarchy.add( container )

			container = EcoreUtil2.getContainerOfType(
				container.eContainer, typeof(WObject) )
		}

		hierarchy
	}

}
