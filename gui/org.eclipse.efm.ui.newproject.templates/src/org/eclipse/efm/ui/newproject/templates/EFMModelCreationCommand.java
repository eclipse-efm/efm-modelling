/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.ui.newproject.templates;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.efm.ui.resources.UIfmlResources;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;


public class EFMModelCreationCommand extends ModelCreationCommandBase {

	/**
	 * @see org.eclipse.papyrus.infra.core.extension.commands.ModelCreationCommandBase#createRootElement()
	 *
	 * @return
	 */

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}



	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		Package packageOwner = (Package) owner;
		Profile fmlProfile = (Profile) PackageUtil.loadPackage(URI.createURI(UIfmlResources.FML_PROFILE_PATH), owner.eResource().getResourceSet());
		if (fmlProfile != null) {
			PackageUtil.applyProfile(packageOwner, fmlProfile, true);
		}
	}

}
