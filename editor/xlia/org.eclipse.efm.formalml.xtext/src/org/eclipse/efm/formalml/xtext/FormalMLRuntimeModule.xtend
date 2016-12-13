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
package org.eclipse.efm.formalml.xtext

import com.google.inject.Binder
import com.google.inject.name.Names

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class FormalMLRuntimeModule extends AbstractFormalMLRuntimeModule {


//	@Override
//	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
//		return FormalMLQualifiedNameProvider.class;
//	}


	override public void configure(Binder binder) {
	  super.configure(binder);
	  binder.bindConstant().annotatedWith(Names.named(
			  org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}
}
