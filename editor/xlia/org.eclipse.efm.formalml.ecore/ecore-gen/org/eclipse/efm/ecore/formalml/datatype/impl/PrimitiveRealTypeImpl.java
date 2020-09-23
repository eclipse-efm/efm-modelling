/**
 * Copyright (c) 2020 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html\n\nContributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.datatype.impl;

import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRealType;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Real Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PrimitiveRealTypeImpl extends PrimitiveNumberTypeImpl implements PrimitiveRealType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveRealTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypePackage.Literals.PRIMITIVE_REAL_TYPE;
	}

} //PrimitiveRealTypeImpl