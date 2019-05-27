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

import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;

public class MoccPortHelper {

	public Port xliaPort;
	public Port xliaChannelPort;

	public Variable constTOKEN_INITIAL_RATE;
	public Variable varReceivedModeTokenCount;

	public Variable constMODE_INITIAL;
	public Variable varReceivedMode;

	public Variable constTOKEN_RATE;

	public Variable constTOKEN_RATE_CSDF;


	public MoccPortHelper(final Port xliaPort,
			final Port xliaChannelPort,
			final Variable constTokenInitialRate,
			final Variable varReceivedModeTokenCount,
			final Variable constModeInitial,
			final Variable varReceivedMode,
			final Variable constTokenRate,
			final Variable constTokenRateCSDF) {
		super();

		this.xliaPort = xliaPort;
		this.xliaChannelPort = xliaChannelPort;

		this.constTOKEN_INITIAL_RATE = constTokenInitialRate;
		this.varReceivedModeTokenCount = varReceivedModeTokenCount;

		constMODE_INITIAL = constModeInitial;
		this.varReceivedMode = varReceivedMode;

		this.constTOKEN_RATE = constTokenRate;

		this.constTOKEN_RATE_CSDF = constTokenRateCSDF;
	}

//	public MoccPortHelper(final Port xliaPort, final Variable constTokenRate) {
//		this(xliaPort, xliaPort, null, null, null, null, constTokenRate, null);
//	}

	public MoccPortHelper(final Port xliaPort,
			final Variable constTokenRate, final Variable constTokenRateCSDF) {
		this(xliaPort, xliaPort, null, null, null, null,
				constTokenRate, constTokenRateCSDF);
	}

}
