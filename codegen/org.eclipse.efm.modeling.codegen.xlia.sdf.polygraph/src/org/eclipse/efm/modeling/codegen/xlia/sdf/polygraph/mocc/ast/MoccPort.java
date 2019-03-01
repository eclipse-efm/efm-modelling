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

public class MoccPort {

	public final MoccActor actor;

	public enum Direction { INPUT , OUTPUT }

	protected final Direction direction;

	protected final String name;

	protected final int rate;

	protected final int rateDenominator;

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

	@Override
	public String toString() {
		final StringBuilder sout = new StringBuilder();

		sout.append(direction.toString().toLowerCase())
			.append(" port< rate = ").append(strRate());

		if( channel.hasInitialRate() ) {
			sout.append(" , initial = ").append(channel.strInitialRate());
		}

		sout.append(" > ").append(name);

		return sout.toString();
	}

}
