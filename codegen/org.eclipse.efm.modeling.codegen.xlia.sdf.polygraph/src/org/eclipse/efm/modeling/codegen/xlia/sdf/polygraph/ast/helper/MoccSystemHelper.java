/*******************************************************************************
 * Copyright (c) 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.helper;

import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;
import org.eclipse.efm.ecore.formalml.infrastructure.XliaSystem;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast.MoccSystem;

public class MoccSystemHelper {

	protected MoccSystem moccSystem;

	protected XliaModel xliaModel;

	protected XliaSystem xliaSystem;

	protected Behavior mainBehavior;

	protected Variable varTick;
	protected Variable varTickInterval;
	protected Variable varTickPeriod;

	protected Routine routineReceiveToken;


	public MoccSystemHelper(final MoccSystem moccSystem,
			final XliaModel xliaModel, final XliaSystem xliaSystem) {
		super();

		this.moccSystem = moccSystem;
		this.xliaModel = xliaModel;
		this.xliaSystem = xliaSystem;

		this.mainBehavior = null;

		this.varTick = null;
		this.varTickInterval = null;
		this.varTickPeriod = null;

		this.routineReceiveToken = null;
	}

}
