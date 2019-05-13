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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.feature;

import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccPort;

public class MoccActorFeature {

	public final MoccActor actor;

	public final boolean isModeSelector;

	public final boolean isModeProcessor;

	public final boolean isModeProducer;

	public final boolean isTimed;

	public final boolean isRegular;

	public double inferredFrequency;


	public final boolean hasInput;
	public final boolean hasInputMode;
	public final boolean hasIntegerInput;
	public final boolean hasRationalInput;

	public final boolean hasIntegerRate;
	public final boolean hasRationalRate;


	public final boolean hasOutput;
	public final boolean hasRationalOutput;

	public final boolean isPureInteger;

	public final int inputModeCount;
	public final int outputModeCount;


	public boolean consistency;

	public int repetition;

	public boolean activation[];

	public static final int DEFAULT_INITIAL_SCHEDULE = -1;

	public MoccActorFeature(final MoccActor actor) {
		super();

		assert (actor != null) : "Unexpected a null MoccActor";
		this.actor = actor;

		this.isModeSelector  = ( actor.getSelectionSet().length > 0 );

		this.isModeProcessor = ( actor.getProcessingSet().length > 0 );

		this.isModeProducer = (isModeSelector || isModeProcessor);

		this.isTimed = actor.getFrequency() > 0;

		this.inferredFrequency = actor.getFrequency();

		this.isRegular = ! (this.isModeSelector || this.isModeProcessor);

		this.hasInput = ( ! actor.getInputPort().isEmpty() );
		boolean hasIntegerInput = false;
		boolean hasRationalInput = false;
		boolean hasIntegerRate = false;
		boolean hasRationalRate = false;
		int inputModeCount = 0;
		for( final MoccPort moccPort : actor.getInputPort() ) {
			if( moccPort.isRational() ) {
				hasRationalInput = true;

				hasRationalRate = true;
			}
			else {
				hasIntegerInput = true;

				hasIntegerRate = true;
			}

			if( moccPort.isOutputRational() ) {
				hasRationalRate = true;
			}
			else {
				hasIntegerRate = true;
			}

//			if( hasIntegerInput && hasRationalInput
//				&& hasIntegerRate && hasRationalRate)
//			{
//				break;
//			}

			if( moccPort.isInputMode() ) {
				++inputModeCount;
			}
		}
		this.hasInputMode   = (inputModeCount > 0);

		this.hasIntegerInput  = hasIntegerInput;
		this.hasRationalInput = hasRationalInput;
		this.hasIntegerRate   = hasIntegerRate;
		this.hasRationalRate  = hasRationalRate;
		this.inputModeCount   = inputModeCount;

		this.hasOutput = ( ! actor.getOutputPort().isEmpty() );
		boolean hasRationalOutput = false;
		int outputModeCount = 0;
		for( final MoccPort moccPort : actor.getOutputPort() ) {
			if( moccPort.isRational() ) {
				hasRationalOutput = true;
			}
			else {
				hasIntegerInput = true;
			}

//			if( hasIntegerInput && hasRationalOutput ) {
//				break;
//			}

			if( moccPort.isOutputMode() ) {
				++outputModeCount;
			}
		}
		this.hasRationalOutput = hasRationalOutput;
		this.outputModeCount   = outputModeCount;

		this.isPureInteger = ! (this.hasRationalInput || this.hasRationalOutput);

		this.consistency = false;

		this.repetition = -1;

		this.activation = null;
	}


	public void computeActivation(final MoccSystemFeature moccSystemFeature) {
		this.activation = new boolean[ moccSystemFeature.tick_period ];

		if( isTimed && consistency ) {
			final int period = this.activation.length / this.repetition;

			final int phase = this.actor.getPhase();

			for( int tick = 0 ; tick < this.activation.length ; tick++ ) {
				if( phase == (tick % period ) ) {
					this.activation[tick] = true;
				}
				else {
					this.activation[tick] = false;
				}
			}
		}
		else {
			for( int tick = 0 ; tick < this.activation.length ; tick++ ) {
				this.activation[tick] = true;
			}
		}
	}


	public String strActivation() {
		if( activation != null ) {
			final StringBuilder sout = new StringBuilder("[");
			for( int tick = 0 ; tick < activation.length ; tick++ ) {
				sout.append(" ").append( this.activation[tick] ? 1 : 0 );
			}
			sout.append(" ]");

			return sout.toString();
		}
		else {
			return "[null]";
		}
	}
}
