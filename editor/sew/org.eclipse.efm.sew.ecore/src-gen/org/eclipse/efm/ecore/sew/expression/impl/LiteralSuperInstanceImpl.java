/**
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
 */
package org.eclipse.efm.ecore.sew.expression.impl;

import org.eclipse.efm.ecore.sew.expression.ExpressionPackage;
import org.eclipse.efm.ecore.sew.expression.LiteralSuperInstance;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Super Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LiteralSuperInstanceImpl extends LiteralReferenceValueImpl implements LiteralSuperInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralSuperInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.LITERAL_SUPER_INSTANCE;
	}

} //LiteralSuperInstanceImpl
