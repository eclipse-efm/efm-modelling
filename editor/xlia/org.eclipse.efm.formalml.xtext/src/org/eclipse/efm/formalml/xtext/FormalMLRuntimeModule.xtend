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
import org.eclipse.xtext.naming.IQualifiedNameProvider
//import org.eclipse.xtext.resource.containers.IAllContainersState
import org.eclipse.xtext.validation.CompositeEValidator
import org.eclipse.xtext.parser.IAstFactory

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class FormalMLRuntimeModule extends AbstractFormalMLRuntimeModule {


	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return FormalMLQualifiedNameProvider;
	}


//	override Class<? extends IAllContainersState.Provider> bindIAllContainersState$Provider() {
//		return FormalMLResourceSetBasedAllContainersStateProvider;
//	}
	
	
	override void configure(Binder binder) {
	  super.configure(binder);
	  binder.bindConstant().annotatedWith(Names.named(
			  CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}
	
	
	override Class<? extends IAstFactory> bindIAstFactory() {
		return FormalMLAstFactory;
	}

}
