/**
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.efm.execution.core.workflow.coverage.impl;

import org.eclipse.efm.execution.core.workflow.coverage.ConditionCoverageWorker;
import org.eclipse.efm.execution.core.workflow.coverage.CoveragePackage;

import org.eclipse.efm.execution.core.workflow.impl.CoverageWorkerImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Coverage Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ConditionCoverageWorkerImpl extends CoverageWorkerImpl implements ConditionCoverageWorker {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionCoverageWorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CoveragePackage.Literals.CONDITION_COVERAGE_WORKER;
	}

} //ConditionCoverageWorkerImpl
