/*****************************************************************************
* Copyright (c) 2018 CEA LIST.
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
package org.eclipse.efm.formalml.xtext.ide

import com.google.inject.Guice
import org.eclipse.efm.formalml.xtext.FormalMLRuntimeModule
import org.eclipse.efm.formalml.xtext.FormalMLStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class FormalMLIdeSetup extends FormalMLStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new FormalMLRuntimeModule, new FormalMLIdeModule))
	}
	
}
