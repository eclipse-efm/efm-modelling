/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml.tests;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;

//import org.eclipse.efm.formalml.Activator;

import org.junit.Assert;
import org.junit.Test;


public class EFMStandardLibraryTest {
	
	//public static final String LIBRARY_PATH = Activator.PLUGIN_ID +"/resources/library/FormalML-Standard-Library.uml"; //$NON-NLS-1$
	public static final String LIBRARY_PATH = "org.eclipse.efm.formalml" +"/resources/library/FormalML-Standard-Library.uml"; //$NON-NLS-1$
	
	/**
	 * Validate the model with the rules defined in the meta-model tooling
	 */
	@Test
	public void validatePropertiesModel() {
		URI createPlatformPluginURI = URI.createPlatformPluginURI(LIBRARY_PATH, true);
		Resource resource = new ResourceSetImpl().getResource(createPlatformPluginURI, true);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		Assert.assertEquals("The FormalML-Standard-Library is not valid ", Diagnostic.OK, diagnostic.getSeverity()); //$NON-NLS-1$
	}	
}
