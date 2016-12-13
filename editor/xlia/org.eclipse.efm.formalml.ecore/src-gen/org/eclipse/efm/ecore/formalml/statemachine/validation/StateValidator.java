/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
/**
 *
 * $Id$
 */
package org.eclipse.efm.ecore.formalml.statemachine.validation;

import org.eclipse.efm.ecore.formalml.infrastructure.Routine;

import org.eclipse.efm.ecore.formalml.statemachine.Region;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link org.eclipse.efm.ecore.formalml.statemachine.State}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface StateValidator {
	boolean validate();

	boolean validateSimple(boolean value);
	boolean validateComposite(boolean value);
	boolean validateOrthogonal(boolean value);
	boolean validateRegion(EList<Region> value);
	boolean validateMoe(EList<Routine> value);
}
