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

import org.eclipse.uml2.uml.UMLPlugin;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.efm.formalml.formalmlPackage;

/**
 * Basic test for EFM profile
 * 
 * @author Mahe Erwan (adapted from Benoit Maggi's SysML1.4 code)
 */
public class formalMLProfileTest {

	/**
	 * Check that we have a profile registered
	 */
	@Test
	public void testProfilRegistration() {
		Assert.assertNotNull(
				UMLPlugin.getEPackageNsURIToProfileLocationMap().get(formalmlPackage.eNS_URI));
	}

}
