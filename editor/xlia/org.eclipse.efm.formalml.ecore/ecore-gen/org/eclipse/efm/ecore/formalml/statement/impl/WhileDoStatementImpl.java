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
package org.eclipse.efm.ecore.formalml.statement.impl;

import org.eclipse.efm.ecore.formalml.statement.StatementPackage;
import org.eclipse.efm.ecore.formalml.statement.WhileDoStatement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Do Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class WhileDoStatementImpl extends ConditionalBlockStatementImpl implements WhileDoStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileDoStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.WHILE_DO_STATEMENT;
	}

} //WhileDoStatementImpl
