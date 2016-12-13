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
package org.eclipse.efm.papyrus.xtext.ui;

import com.google.inject.Injector;
import org.eclipse.efm.papyrus.xtext.transition.ui.internal.TransitionActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TransitionExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return TransitionActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return TransitionActivator.getInstance().getInjector(TransitionActivator.ORG_ECLIPSE_EFM_PAPYRUS_XTEXT_TRANSITION);
	}
	
}
