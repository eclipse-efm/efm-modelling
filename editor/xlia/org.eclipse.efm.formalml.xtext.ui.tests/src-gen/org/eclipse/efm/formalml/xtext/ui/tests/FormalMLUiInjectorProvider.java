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
package org.eclipse.efm.formalml.xtext.ui.tests;

import com.google.inject.Injector;
import org.eclipse.efm.formalml.xtext.ui.internal.XtextActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class FormalMLUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return XtextActivator.getInstance().getInjector("org.eclipse.efm.formalml.xtext.FormalML");
	}

}
