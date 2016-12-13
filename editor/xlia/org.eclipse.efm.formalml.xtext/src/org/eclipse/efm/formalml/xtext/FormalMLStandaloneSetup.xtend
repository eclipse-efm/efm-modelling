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


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class FormalMLStandaloneSetup extends FormalMLStandaloneSetupGenerated {

	def static void doSetup() {
		new FormalMLStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
