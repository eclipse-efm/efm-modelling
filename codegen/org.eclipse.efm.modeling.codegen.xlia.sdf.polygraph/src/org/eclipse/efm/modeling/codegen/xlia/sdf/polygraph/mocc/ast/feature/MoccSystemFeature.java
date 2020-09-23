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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.IntStream;

import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccChannel;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccPort;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccSystem;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.util.Rational;


public class MoccSystemFeature {

	public final MoccSystem system;

	public final boolean hasModeSelector;

	public final boolean hasModeProcessor;

	public final boolean hasRegular;

	public final boolean hasRationalInput;

	public final boolean hasRationalOutput;

	public final boolean isPureInteger;

	public final int timedActorCount;
	public final int phaseActorCount;

	public final int executableActorCount;

	public final boolean hasTimed;
	public final boolean hasUntimed;

	public int[] repetitions;

	public int firings;

	public final int[] allFrequencies;
	public final int[] exeFrequencies;

	// Normalized Frequencies s.t. gcd( all frequencies ) == 1
	public final int[] exeOmagaFrequencies;


	public final int tick_frequency; // gcd( Executable Actor Frequencies )

//	public final int time_period;    // lcm( Executable Actor Frequencies )

	public final int period;         // lcm( Executable Actor Omega_Frequencies )
	public final int hyperperiod;    // minimal multiple of period for liveness

	public final int tick_step;
//	public final int tick_period;

	private int scheduledStageCount;


	public final boolean consistency;

	public final List< MoccActor > rootActor;
	public final List< MoccActor > leafActor;


	public MoccSystemFeature(
			final MoccSystem system, final boolean isStrict) {
		super();

		assert (system != null) : "Unexpected a null MoccSystem";
		this.system = system;

		this.rootActor = new ArrayList<MoccActor>();
		this.leafActor = new ArrayList<MoccActor>();

		boolean hasModeSelector  = false;
		boolean hasModeProcessor = false;
		boolean hasRegular = false;
		boolean hasRationalInput  = false;
		boolean hasRationalOutput = false;

		int timedActorCount = 0;
		int phaseActorCount = 0;
		int executableActorCount = 0;

		final Set< Integer > allFrequencies = new HashSet<Integer>();
		final Set< Integer > exeFrequencies = new HashSet<Integer>();

		boolean hasIsolatedTimedActor = false;

		assert (! system.getActor().isEmpty()) :
			"Unexpected a MoccSystem without actor";

		// Basic static analysis feature
		for( final MoccActor actor : system.getActor() ) {
			if( isStrict ) {
				if( actor.phase < 0 ) {
					actor.phase = 0;
				}
			}

			if( actor.phase > 0 ) {
				phaseActorCount = phaseActorCount + 1;
			}

			actor.computeFeature();

			if( actor.FEATURE.hasInteraction ) {
				executableActorCount = executableActorCount + 1;
			}

			// Basic static analysis feature
			hasModeSelector  = hasModeSelector  || actor.FEATURE.isModeSelector;
			hasModeProcessor = hasModeProcessor || actor.FEATURE.isModeProcessor;

			if( actor.FEATURE.isTimed ) {
				timedActorCount = timedActorCount + 1;
			}

			if( actor.FEATURE.isTimed ) {
				allFrequencies.add(actor.getFrequency());

				if( actor.FEATURE.hasInteraction ) {
					exeFrequencies.add(actor.getFrequency());
				}
				else {
					hasIsolatedTimedActor = true;
				}
			}

			hasRegular = hasRegular || actor.FEATURE.isRegular;

			hasRationalInput  =
					hasRationalInput  || actor.FEATURE.hasRationalInput;
			hasRationalOutput =
					hasRationalOutput || actor.FEATURE.hasRationalOutput;

			if( ! actor.FEATURE.hasInput ) {
				rootActor.add(actor);
			}
			else if( actor.getPhase() == 0 ) {
				boolean isRoot = true;
				for( final MoccPort port : actor.getInputPort() ) {
					if( ! port.hasEnoughInitialRate() ) {
						isRoot = false;
						break;
					}
				}
				if( isRoot ) {
					rootActor.add(actor);
				}
			}

			if( ! actor.FEATURE.hasOutput ) {
				leafActor.add(actor);
			}
		}

		this.hasModeSelector  = hasModeSelector;
		this.hasModeProcessor = hasModeProcessor;

		this.hasRegular = hasRegular;

		this.hasRationalInput  = hasRationalInput;
		this.hasRationalOutput = hasRationalOutput;

		this.isPureInteger = ! (this.hasRationalInput || this.hasRationalOutput);

		this.timedActorCount = timedActorCount;
		this.phaseActorCount = phaseActorCount;

		this.executableActorCount = executableActorCount;

		this.hasTimed = (timedActorCount > 0);

		this.hasUntimed = (timedActorCount < system.getActor().size());


		// Order Actor by causality
		this.scheduledStageCount = 0;
		computeScheduleOrder();

		Collections.sort(this.system.getActor(), new Comparator<MoccActor>() {
	        @Override
	        public int compare(final MoccActor actorA, final MoccActor actorB)
	        {
	        	final int scheduleA = actorA.schedule;
	        	final int scheduleB = actorB.schedule;

	            return (scheduleA < scheduleB) ? -1 :
	            			((scheduleA == scheduleB) ? 0 : 1);
	        }
	    });

		int index = 0;
		for( final MoccActor actor : system.getActor() ) {
			actor.index = index++;
		}

//		computeReptetition2();

		this.repetitions = computeReptetition();

		this.firings = IntStream.of( this.repetitions ).sum();

		this.allFrequencies = new int[allFrequencies.size()];
		int offset = 0;
		for( final Integer frequency : allFrequencies ) {
			this.allFrequencies[offset++] = frequency;
		}

		if( hasIsolatedTimedActor ) {
			this.exeFrequencies = new int[exeFrequencies.size()];
			offset = 0;
			for( final Integer frequency : exeFrequencies ) {
				this.exeFrequencies[offset++] = frequency;
			}
		}
		else {
			this.exeFrequencies = this.allFrequencies;
		}

		// Minimize ime unit for all executable frequencies
		final int gcdExecFrequencies = gcd( this.exeFrequencies );
		if( gcdExecFrequencies > 1 ) {
			this.exeOmagaFrequencies = new int[ this.exeFrequencies.length ];

			offset = 0;
			for( final int frequency : this.exeFrequencies ) {
				this.exeOmagaFrequencies[offset++] =
						(frequency / gcdExecFrequencies);
			}

			for( final MoccActor actor : system.getActor() ) {
				if( actor.FEATURE.isTimed && actor.FEATURE.hasInteraction )
				{
					actor.FEATURE.omegaFrequency =
							actor.frequency / gcdExecFrequencies;
				}
				else {
					actor.FEATURE.omegaFrequency = -1;
				}
			}
		}
		else {
			this.exeOmagaFrequencies = this.exeFrequencies;
		}

		this.tick_step   = 1;

		if( this.exeFrequencies.length > 1 ) {
			this.tick_frequency = gcdExecFrequencies;

			this.period      = lcm( this.exeOmagaFrequencies );
			this.hyperperiod = computeHyperperiod();  // i.e. ratio * period
		}
		else if( this.exeFrequencies.length == 1 ) {
			this.tick_frequency = this.exeFrequencies[0];

			this.period      = 1;
			this.hyperperiod = 1;
		}
		else {
			this.tick_frequency = 1;

			this.period = this.scheduledStageCount + 1;

			this.hyperperiod = this.period;

//			IntStream.of( this.repetitions ).sum() + 1 - system.getActor().size();
		}

		// For non-conex graph
		for( final MoccActor actor : system.getActor() ) {
			if( this.repetitions[actor.index] == 0 ) {
				this.repetitions[actor.index] = actor.FEATURE.repetition = -1;
			}
		}

		this.consistency = checkConsistency();

		for( final MoccActor actor : system.getActor() ) {
			actor.FEATURE.computeCycloStaticRate();
			actor.FEATURE.computeActivation(this);
		}
	}


	public String strFrequencies() {
		final StringBuilder sout = new StringBuilder(
				Arrays.toString(exeFrequencies));

		if( this.exeFrequencies != this.exeOmagaFrequencies ) {
			sout.append( " - MINIMIZED - " )
				.append( Arrays.toString(exeOmagaFrequencies) );
		}

		if( this.exeFrequencies != this.allFrequencies ) {
			final HashSet<Integer> execFreq = new HashSet<Integer>();
			for (final Integer freq : this.exeFrequencies) {
				execFreq.add(freq);
			}

			sout.append(" -- OTHER -- {");
			for (final Integer freq : this.allFrequencies) {
				if( ! execFreq.contains(freq) ) {
					sout.append(" ").append(freq);
				}
			}
			sout.append(" }");
		}

		return sout.toString();
	}


	private static int gcd(final int x, final int y) {
	    return (y == 0) ? x : gcd(y, x % y);
	}

	public static int gcd(final int... numbers) {
	    return Arrays.stream(numbers).reduce(0, (x, y) -> gcd(x, y));
	}

	public static int lcm(final int... numbers) {
	    return Arrays.stream(numbers).reduce(1, (x, y) -> x * (y / gcd(x, y)));
	}


	private void computeScheduleOrder() {
		for( final MoccActor actor : this.rootActor ) {
			actor.schedule = 0;
		}

		for( final MoccActor actor : this.rootActor ) {
			propagateScheduleOrder(actor);
		}
	}

	private final static int PENDING_SCHEDULE_MARK = -42;

	private void computeScheduleOrder(final MoccActor actor) {
		actor.schedule = PENDING_SCHEDULE_MARK;
		int schedule = 0;
		for( final MoccActor sourceActor : actor.getPredecessor() ) {
			if( (sourceActor.schedule
					== MoccActorFeature.DEFAULT_INITIAL_SCHEDULE)
				&& (sourceActor.getPhase() <= actor.getPhase())
				&& (! actor.hasEnoughInitialRate(sourceActor)) )
			{
				computeScheduleOrder(sourceActor);
			}

			schedule = Math.max(schedule, sourceActor.schedule);
		}

		this.scheduledStageCount = actor.schedule = schedule + 1;
	}

	private void propagateScheduleOrder(final MoccActor actor) {
		for( final MoccActor targetActor : actor.getSuccessor() ) {
			if( targetActor.schedule < 0 ) {
				computeScheduleOrder(targetActor);

				propagateScheduleOrder(targetActor);
			}
		}
	}


	public void computeReptetition2() {
		boolean isOK = true;

		final Vector<Integer> repetitionVector =
				new Vector<Integer>(system.getActor().size());
		for( int index = 0 ; index < system.getActor().size() ; index++ ) {
			repetitionVector.add(1);
		}

		for (final MoccChannel channel : this.system.getChannel()) {
			System.out.println( channel );

			final MoccPort portA = channel.getOutputPort();
			final int indexActorA = portA.getActor().index;
			final int repeatA = repetitionVector.get(indexActorA);

			final MoccPort portB = channel.getInputPort();
			final int indexActorB = portB.getActor().index;
			final int repeatB = repetitionVector.get(indexActorB);

			final int rateA = portA.getRate() * portB.getRateDenominator();
			final int rateB = portB.getRate() * portA.getRateDenominator();

			boolean consistency = (rateA * repeatA == rateB * repeatB);

			int newRepeatA;
			int newRepeatB;

//			if( ! vectorA.equals(vectorB) )
			{
				if( ! consistency ) {
					final int multiple = lcm(rateA, rateB);
					int divisor  = gcd(repeatA, repeatB);

					newRepeatA = (multiple/rateA)*(repeatB /divisor);
					newRepeatB = (multiple/rateB )*(repeatA/divisor);

					divisor = gcd(newRepeatA, newRepeatB);

					newRepeatA /= divisor;
					newRepeatB /= divisor;

				}
				else {
					newRepeatA = newRepeatB = 1;
				}

				repetitionVector.set(indexActorA,
						newRepeatA * repetitionVector.get(indexActorA));

				repetitionVector.set(indexActorB,
						newRepeatB * repetitionVector.get(indexActorB));

				System.out.print("Repetition Vector : ");
				System.out.println( repetitionVector );

				consistency = true;
			}

			isOK &= consistency;
		}

		if( isOK ) {
			System.out.print("Final Repetition Vector: ");
			System.out.println( repetitionVector );
		}
	}



	private final Map<MoccActor, Rational> rationals = new HashMap<MoccActor, Rational>();

	private int[] computeReptetition() {
		for( final MoccActor actor : system.getActor() ) {
			if( actor.FEATURE.hasInteraction )
			{
				if( ! rationals.containsKey(actor) ) {
					calculateRate(actor, new Rational(1, 1));
				}
			}
			else {
				rationals.put(actor, new Rational(0, 1));
			}
		}

		// get least common denominator
		int lcm = 1;
		for( final Rational rat : rationals.values() ) {
			lcm = Rational.lcm(lcm, rat.getDenominator());
		}

		final int[] repetions = new int[system.getActor().size()];

		for( final MoccActor actor : rationals.keySet() ) {
			final Rational rat = rationals.get(actor);

			repetions[actor.index] = actor.FEATURE.repetition
						= rat.getNumerator() * (lcm / rat.getDenominator());
		}

		return( repetions );
	}

	private void calculateRate(final MoccActor actor, final Rational rate) {
		rationals.put(actor, rate);

		for( final MoccPort outputPort : actor.getOutputPort() ) {
			final MoccPort inputPort = outputPort.getChannel().getInputPort();
			final MoccActor inputActor = inputPort.getActor();
			if( ! rationals.containsKey(inputActor) ) {
				final int prod = outputPort.getRate() *  inputPort.getRateDenominator();
				final int conso = inputPort.getRate() * outputPort.getRateDenominator();

				calculateRate(inputActor, rate.mul(new Rational(prod, conso)));
			}
		}

		for( final MoccPort inputPort : actor.getInputPort() ) {
			final MoccPort outputPort = inputPort.getChannel().getOutputPort();
			final MoccActor outputActor = outputPort.getActor();
			if( ! rationals.containsKey(outputActor) ) {
				final int prod = outputPort.getRate() *  inputPort.getRateDenominator();
				final int conso = inputPort.getRate() * outputPort.getRateDenominator();

				calculateRate(outputActor, rate.mul(new Rational(conso, prod)));
			}
		}
	}


	private int computeHyperperiod() {
		for( final MoccActor actor : rationals.keySet() ) {
			if( actor.FEATURE.isTimed && actor.FEATURE.hasInteraction
				&& (actor.FEATURE.repetition != actor.FEATURE.omegaFrequency) )
//						(actor.getFrequency() / this.tick_frequency)) )
			{
				return( (this.period * actor.FEATURE.repetition)
						/ actor.FEATURE.omegaFrequency );
			}
		}

		return this.period;
	}


//	public boolean checkTimeConsistency(final MoccActor actor) {
//
//		return (! actor.FEATURE.isTimed)
//				|| ((actor.FEATURE.repetition * this.period) !=
//					(actor.FEATURE.omegaFrequency * this.hyperperiod));
//	}
//
//	public boolean checkPhaseConsistency(final MoccActor actor) {
//
//		return (! actor.FEATURE.isTimed)
//				|| (actor.getPhase() < (this.period / actor.FEATURE.omegaFrequency));
//	}

	public String inconsistencyReason(final MoccActor actor) {
		if( actor.FEATURE.isTimed ) {
			final int ratio = (this.hyperperiod / this.period);

			if( actor.FEATURE.repetition != (actor.FEATURE.omegaFrequency * ratio) )
			{
				return "inconsistent< repetition:" + actor.FEATURE.repetition
						+ " != (frequency:" + actor.getFrequency()
						+ " / tick_freq:" + this.tick_frequency + "): "
						+ actor.FEATURE.omegaFrequency + " >";
			}
			else if( actor.getPhase() >= (this.hyperperiod / actor.getFrequency()) )
			{
				return "inconsistent< phase:" + actor.getPhase()
						+ " >= (hyperperiod:" + (this.hyperperiod * this.tick_frequency)
						+ " / frequency:" + actor.getFrequency() + "): "
						+ this.period / actor.FEATURE.omegaFrequency + " >";
			}
			else if( actor.getPhase() < (this.hyperperiod / actor.FEATURE.omegaFrequency) )
			{
				return "inconsistent< phase:" + actor.getPhase()
						+ " >= (hyperperiod / omegaFrequency:" + (this.hyperperiod / actor.FEATURE.omegaFrequency) + "): "
						+ this.period / actor.FEATURE.omegaFrequency + " >";
			}
		}

		return "inconsistent< ? >";
	}

	private boolean checkConsistency() {
		boolean consistency = true;

		final int ratio = (this.hyperperiod / this.period);
		for( final MoccActor actor : rationals.keySet() ) {
			actor.FEATURE.consistency = (! actor.FEATURE.isTimed)
				|| (! actor.FEATURE.hasInteraction)
				|| ( ( actor.FEATURE.repetition ==
							(actor.FEATURE.omegaFrequency * ratio) )
					&& (actor.getPhase() <
						(this.hyperperiod / actor.FEATURE.omegaFrequency)));

			consistency &= actor.FEATURE.consistency;
		}

		for( final MoccChannel channel : system.getChannel() ) {
			final MoccPort outputPort = channel.getOutputPort();
			final MoccPort inputPort  = channel.getInputPort();

			final int outputRate = outputPort.getActor().FEATURE.repetition;
			final int inputRate  =  inputPort.getActor().FEATURE.repetition;

			final int prod = outputPort.getRate() *  inputPort.getRateDenominator();
			final int conso = inputPort.getRate() * outputPort.getRateDenominator();

			if (outputRate * prod != inputRate * conso) {
				consistency = false;

				outputPort.actor.FEATURE.consistency = false;
				inputPort.actor.FEATURE.consistency = false;
			}
		}

		return consistency;
	}

}
