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
package org.eclipse.efm.formalml.xtext.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractFormalMLValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efm/FormalML"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efm/FormalML/Common"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efm/FormalML/Infrastructure"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efm/FormalML/Statemachine"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efm/FormalML/Expression"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efm/FormalML/DataType"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efm/FormalML/Statement"));
		return result;
	}
}
