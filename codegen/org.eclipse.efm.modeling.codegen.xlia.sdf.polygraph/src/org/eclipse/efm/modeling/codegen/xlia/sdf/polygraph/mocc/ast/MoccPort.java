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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast;

import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.util.Rational;

public class MoccPort {

	public final MoccActor actor;

	public enum Direction { INPUT , OUTPUT }

	protected final Direction direction;

	protected final String name;

	public int rate;

	protected final int rateDenominator;

	protected int[] cycloStaticRate;

	protected MoccChannel channel;

	public MoccPort(final MoccActor actor, final Direction direction,
			final String name, final int rate, final int rateDenominator) {
		super();

		assert (actor != null) : "Unexpected a null MoccActor";
		this.actor = actor;

		this.direction = direction;
		this.name = name;

		this.rate = rate;
		this.rateDenominator = rateDenominator;
		cycloStaticRate = null;

		this.channel = null;

		actor.addPort( this );
	}

	public MoccPort(final MoccActor actor,
			final Direction direction, final String name, final int rate) {
		this(actor, direction, name, rate, 1);
	}


	// GETTERS - SETTERS
	public MoccActor getActor() {
		return actor;
	}

	public boolean isInput() {
		return( direction == Direction.INPUT );
	}

	public boolean isInputMode() {
		return( (direction == Direction.INPUT)
				&& (channel.getOutputActor().isModeProducer()) );
	}

	public MoccActor getModeSelector() {
		if( direction == Direction.INPUT ) {
			if( channel.getOutputActor().isModeProducer() ) {
				return channel.getOutputActor().getSelector();
			}
		}
		else if( this.actor.isModeProducer() ) {
			return this.actor.getSelector();
		}

		return null;
	}

	public boolean isOutput() {
		return( direction == Direction.OUTPUT );
	}

	public boolean isOutputMode() {
		return( (direction == Direction.OUTPUT) && (actor.isModeProducer()) );
	}

	public String getName() {
		return name;
	}

	public int getRate() {
		return rate;
	}

	public int getRateDenominator() {
		return rateDenominator;
	}

	public boolean isRational() {
		return( rateDenominator > 1 );
	}

	public int[] getCycloStaticRate() {
		return cycloStaticRate;
	}

	public boolean hasCycloStaticRate() {
		return( cycloStaticRate != null );
	}


	public boolean isInputRational() {
		return( (channel != null) && channel.getInputPort().isRational() );
	}

	public boolean hasEnoughInitialRate() {
		assert (channel != null) :
			"Unexpected a null MoccChannel in updateInputChannel";

		return( ((channel.getInitialRate() * rateDenominator)
					>= (rate * channel.getInitialRateDenominator())) );
	}

	public boolean hasEnoughInitialRate(final MoccActor sourceActor) {
		assert (channel != null) :
			"Unexpected a null MoccChannel in updateInputChannel";

		return( (channel.getOutputPort().getActor() == sourceActor)
				&& hasEnoughInitialRate() );
	}

	public boolean hasInitialRate() {
		return( (channel != null) && channel.hasInitialRate() );
	}


	public boolean isOutputRational() {
		return( (channel != null) && channel.getOutputPort().isRational() );
	}


	public boolean isRationalTokenCount() {
		return( isRational() || isOutputRational() );
	}


/*
	def csdf_sequence(rate, rate_initial):
	    s = []
	    for i in range(rate.denominator):
	        r = rate_initial + rate
	        s += [abs(floor(r)-floor(rate_initial))]
	        rate_initial = r
	    return s
*/
	public static int[] computeRateCSDF(final Rational rate, Rational initial ) {
		final int[] cycloStaticRate = new int[rate.getDenominator()];

		for (int i = 0; i < cycloStaticRate.length; i++) {
			final Rational sum = (new Rational(initial)).add(rate);
			cycloStaticRate[i] = Math.abs(sum.floor() - initial.floor());
			initial = sum;
		}

		return cycloStaticRate;
	}


	public static void printRate(final int[] rate) {
		System.out.print('[');
		for (final int r : rate) {
			System.out.print(' ');
			System.out.print(r);
		}
		System.out.println(" ]");
	}


/*
	for den in range(5):
	    for num in range(1,den):
	        rate = Fraction(num,den)
	        for ps in range(den):
	            rate_initial = Fraction(ps,den)
	            print("case:",rate,"-",rate_initial,"->",2)
	            print("csdf production:",csdf_sequence(rate,rate_initial))
	            print("csdf consumption:",csdf_sequence(-2,rate_initial))
	            print("case:",2,"-",rate_initial,"->",rate)
	            print("csdf production:",csdf_sequence(2,rate_initial))
	            print("csdf consumption:",csdf_sequence(-rate,rate_initial))
	            print()
	        print()
	    print()
*/
	public static void main(final String[] args) {
		final Rational deux = new Rational(2,  1);
		final Rational neg_deux = new Rational(-2,  1);

		for (int den = 0; den < 5; den++) {
			for (int num = 1; num < den; num++) {
				final Rational rate = new Rational(num,den);
				for (int ps = 0; ps < den; ps++) {
					final Rational rate_initial = new Rational(ps,den);
					System.out.println("case: " + rate + " -- " + rate_initial + " --> " + 2);
					System.out.print("csdf production : "); printRate(computeRateCSDF(rate , rate_initial));
					System.out.print("csdf consumption: "); printRate(computeRateCSDF(neg_deux , rate_initial));

					System.out.println("case: " + 2 + " -- " + rate_initial + " --> " + rate);
					System.out.print("csdf production : "); printRate(computeRateCSDF(deux , rate_initial));
					System.out.print("csdf consumption: "); printRate(computeRateCSDF(rate.negate() , rate_initial));
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}

		final Rational prod = new Rational(4, 3);
		final Rational init = new Rational(0, 1);
		final Rational conso = new Rational(-1, 1);
		System.out.println("case: 4/3 -- 0 --> 1");
		System.out.print("csdf prod : "); printRate(computeRateCSDF(prod , init));
		System.out.print("csdf conso: "); printRate(computeRateCSDF(conso , init));
		System.out.println();
	}

	public void computeCycloStaticInputRate() {
		cycloStaticRate = computeRateCSDF(
				new Rational(-rate, rateDenominator),
				new Rational(channel.initialRate, channel.initialRateDenominator));

//		cycloStaticRate = new int[rateDenominator];
//		int intTokenCount = 0;
//		float floatTokenCount = 0;
//		for (int i = 0; i < cycloStaticRate.length; i++) {
//			floatTokenCount += ((float)rate) / rateDenominator;
//			if( ((int) floatTokenCount) <= (rate - 1) ) {
//				cycloStaticRate[i] = ((int) floatTokenCount ) + 1 - intTokenCount;
//
//				intTokenCount += cycloStaticRate[i];
//			}
//			else {
//				cycloStaticRate[i] = 0;
//			}
//		}
	}

	public void computeCycloStaticOutputRate() {
		cycloStaticRate = computeRateCSDF(
				new Rational(rate, rateDenominator),
				new Rational(0, 1));
//				new Rational(channel.initialRate, channel.initialRateDenominator));



//		cycloStaticRate = new int[rateDenominator];
//		int intTokenCount = 0;
//		float floatTokenCount = 0;
//		for (int i = 0; i < cycloStaticRate.length; i++) {
//			floatTokenCount += rate;
//			cycloStaticRate[i] = ((int) (floatTokenCount / rateDenominator)) - intTokenCount;
//			intTokenCount += cycloStaticRate[i];
//		}
	}



	public MoccChannel getChannel() {
		return channel;
	}

	public void updateInputChannel(final MoccChannel channel) {
		assert (channel != null) :
			"Unexpected a null MoccChannel in updateInputChannel";

		this.channel = channel;

		this.actor.updateInputChannel(this.channel);
	}

	public void updateOutputChannel(final MoccChannel channel) {
		assert (channel != null) :
			"Unexpected a null MoccChannel in updateOutputChannel";

		this.channel = channel;

		this.actor.updateOutputChannel(this.channel);
	}

	public String strRate() {
		if( isRational() ) {
			return( "" + rate + "/" + rateDenominator );
		}
		else {
			return( "" + rate );
		}
	}

	public void strCycloStaticRate(final StringBuilder sout) {
		sout.append('[');
		for (final int rate : cycloStaticRate) {
			sout.append(' ').append(rate);
		}
		sout.append(" ]");
	}



	@Override
	public String toString() {
		final StringBuilder sout = new StringBuilder();

		sout.append(direction.toString().toLowerCase())
			.append(" port< rate = ").append(strRate());

		if( cycloStaticRate != null ) {
			sout.append(" , cyclo = ");
			strCycloStaticRate(sout);
		}

		if( channel.hasInitialRate() ) {
			sout.append(" , initial = ").append(channel.strInitialRate());
		}
		if( channel.hasInitialMode() ) {
			sout.append(" , mode = ")
				.append(channel.getInitialMode().getLiteral());
		}

		sout.append(" > ").append(name);

		return sout.toString();
	}

}
