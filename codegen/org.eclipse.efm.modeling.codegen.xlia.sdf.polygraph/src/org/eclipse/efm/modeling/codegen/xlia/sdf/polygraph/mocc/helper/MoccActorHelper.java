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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.helper;

import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;

public class MoccActorHelper {

	public final MoccActor actor;

	public final Statemachine statemachine;

	public Variable constFREQUENCY;
	public Variable constREPETITION;

	public Variable constACTIVATION_TICK;

	public Variable varActivationCount;

	public Variable varIntToken;
	public Variable varRatToken;

	public EnumerationLiteral[] modeSelectionSet;
	public EnumerationLiteral[] modeProcessingSet;

	public Variable constSELECTIONG_SET;
	public Variable constPROCESSING_SET;

	public Variable constDEFAULT_MODE;

	public Variable varReceivedModeSet;
	public Variable varProcessingMode;

	public Routine macroInitialization;
	public Routine macroReception;

	public Routine macroConsumption;
	public Routine macroConsumptionTrace;
	public Routine macroProduction;

	public Routine macroActivationTest;
	public Routine macroComputeProcessingMode;
	public Routine macroActivationProcessTest;
	public Routine macroActivationPassTest;



	public MoccActorHelper(
			final MoccActor actor, final Statemachine statemachine) {
		super();
		this.actor = actor;
		this.statemachine = statemachine;

		this.constFREQUENCY  = null;
		this.constREPETITION = null;

		this.constACTIVATION_TICK = null;

		this.varActivationCount  = null;

		this.varIntToken = null;
		this.varRatToken = null;

		this.modeSelectionSet  = null;
		this.modeProcessingSet = null;

		this.constSELECTIONG_SET = null;
		this.constPROCESSING_SET = null;

		this.constDEFAULT_MODE  = null;
		this.varReceivedModeSet = null;
		this.varProcessingMode  = null;


		this.macroInitialization = null;
		this.macroReception      = null;

		this.macroConsumption      = null;
		this.macroConsumptionTrace = null;
		this.macroProduction       = null;

		this.macroActivationTest        = null;
		this.macroComputeProcessingMode = null;
		this.macroActivationProcessTest = null;
		this.macroActivationPassTest    = null;
	}

}
