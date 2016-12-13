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
package org.eclipse.efm.ecore.formalml.expression.validation;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InvokeExpressionValidator {
	boolean validate();

	boolean validateCallProcedure(boolean value);
	boolean validateInvoke(Expression value);
	boolean validateArgs(EList<Expression> value);
	boolean validateRets(EList<Expression> value);
}
