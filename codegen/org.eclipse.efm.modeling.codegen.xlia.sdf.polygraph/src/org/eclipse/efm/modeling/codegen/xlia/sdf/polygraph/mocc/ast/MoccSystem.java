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

import java.util.Arrays;
import java.util.Vector;

import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.feature.MoccSystemFeature;

public class MoccSystem {

	protected String name;

	public final Vector< MoccMode > MODE_SET;

	public final MoccMode UNDEFINED;

	public final MoccMode NOMINAL;


	protected final Vector< MoccActor > actors;

	protected final Vector< MoccChannel > channels;


	public MoccSystemFeature FEATURE;


	public MoccSystem(final String name,
			final String nameModeUndefined, final String literalModeUndefined,
			final String nameModeNominal, final String literalModeNominal) {
		this.name = name;

		this.actors = new Vector<MoccActor>();

		this.channels = new Vector<MoccChannel>();

		MODE_SET = new Vector<MoccMode>();

		this.UNDEFINED = newMode(nameModeUndefined, literalModeUndefined);
		this.NOMINAL   = newMode(nameModeNominal  , literalModeNominal  );

		this.FEATURE = null;
	}

	public MoccSystem(final String name) {
		this(name, "undefined", "UNDEFINED", "nominal"  , "NOMINAL");
	}

	// GETTERS - SETTERS
	public String getName() {
		return name;
	}


	// MODE
	public int uniqModeValue = 0;

	public MoccMode newMode(final String name, final String literal) {
		for (final MoccMode moccMode : MODE_SET) {
			if( moccMode.getLiteral().equals(literal) )
			{
				return moccMode;
			}
		}

		final MoccMode mode = new MoccMode(uniqModeValue++, name, literal);

		MODE_SET.add( mode );

		return mode;
	}

	public String[] getModeLiterals() {
		final String[] literals = new String[MODE_SET.size()];
		for (int index = 0; index < literals.length; index++) {
			literals[index] = MODE_SET.elementAt(index).getLiteral();
		}

		return literals;
	}



	// Actors
	public Vector<MoccActor> getActor() {
		return actors;
	}

	public void addActor(final MoccActor actor) {
		actors.add(actor);
	}

	// Channels
	public Vector<MoccChannel> getChannel() {
		return channels;
	}

	public void addChannel(final MoccChannel channel) {
		channels.add(channel);
	}

	public MoccChannel addChannel(final String name,
			final MoccPort outputPort, final int initialRate,
			final int initialRateDenominator, final MoccPort inputPort)
	{
		return new MoccChannel(this, name, outputPort,
				initialRate, initialRateDenominator, inputPort);
	}

	public MoccChannel addChannel(final String name, final MoccPort outputPort,
			final int initialRate, final MoccPort inputPort)
	{
		return new MoccChannel(this, name, outputPort, initialRate, inputPort);
	}

//	public MoccChannel addChannel(
//			final MoccActor outputActor, final String outPortName, final int outRate,
//			final MoccActor inputActor, final String inPortName, final int inRate)
//	{
//		final MoccPort outPort = outputActor.addOutputPort(outPortName, outRate);
//
//		final MoccPort inPort  = inputActor.addInputPort(inPortName, inRate);
//
//		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
//				outPort, 0, inPort);
//	}
//
//	public MoccChannel addChannel(final MoccActor outputActor,
//			final String outPortName, final int outRate, final int outRateDenom,
//			final MoccActor inputActor, final String inPortName, final int inRate)
//	{
//		final MoccPort outPort =
//				outputActor.addOutputPort(outPortName, outRate, outRateDenom);
//
//		final MoccPort inPort  = inputActor.addInputPort(inPortName, inRate);
//
//		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
//				outPort, 0, inPort);
//	}
//
//	public MoccChannel addChannel(
//			final MoccActor outputActor, final String outPortName,
//			final int outRate, final MoccActor inputActor,
//			final String inPortName, final int inRate, final int inRateDenom)
//	{
//		final MoccPort outPort = outputActor.addOutputPort(outPortName, outRate);
//
//		final MoccPort inPort =
//				inputActor.addInputPort(inPortName, inRate, inRateDenom);
//
//		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
//				outPort, 0, inPort);
//	}
//
//
//	public MoccChannel addChannel(
//			final int initialRate, final int initialRateDenominator,
//			final MoccActor outputActor, final String outPortName,
//			final int outRate, final int outRateDenominator,
//			final MoccActor inputActor, final String inPortName, final int inRate)
//	{
//		final MoccPort outPort = outputActor.addOutputPort(
//				outPortName, outRate, outRateDenominator);
//
//		final MoccPort inPort  = inputActor.addInputPort(inPortName, inRate);
//
//		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
//				outPort, initialRate, initialRateDenominator, inPort);
//	}
//
//	public MoccChannel addChannel(final int initialRate,
//			final MoccActor outputActor, final String outPortName,
//			final int outRate, final MoccActor inputActor,
//			final String inPortName, final int inRate)
//	{
//		return addChannel(initialRate, 1, outputActor, outPortName,
//				outRate, 1, inputActor, inPortName, inRate);
//	}

	public MoccChannel addChannel(
			final MoccActor outputActor, final int outRate,
			final MoccActor inputActor, final int inRate)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), outRate);

		final MoccPort inPort  = inputActor.addInputPort(
				"from" + outputActor.getName(), inRate);

		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
				outPort, 0, inPort);
	}

	public MoccChannel addChannel(final MoccActor outputActor,
			final int outRate, final int outRateDenom,
			final MoccActor inputActor, final int inRate)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), outRate, outRateDenom);

		final MoccPort inPort  = inputActor.addInputPort(
				"from" + outputActor.getName(), inRate);

		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
				outPort, 0, inPort);
	}

	public MoccChannel addChannel(
			final MoccActor outputActor, final String outPortName,
			final int outRate, final MoccActor inputActor,
			final String inPortName, final int inRate, final int inRateDenom)
	{
		final MoccPort outPort = outputActor.addOutputPort(outPortName, outRate);

		final MoccPort inPort =
				inputActor.addInputPort(inPortName, inRate, inRateDenom);

		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
				outPort, 0, inPort);
	}


	public MoccChannel addChannel(
			final MoccActor outputActor, final int outRate,
			final MoccActor inputActor, final int inRate, final int inRateDenom)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), outRate);

		final MoccPort inPort = inputActor.addInputPort(
				"from" + outputActor.getName(), inRate, inRateDenom);

		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
				outPort, 0, inPort);
	}


	public MoccChannel addChannel(
			final int initialRate, final int initialRateDenominator,
			final MoccActor outputActor, final int outRate,
			final MoccActor inputActor, final int inRate, final int inRateDenom)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), outRate);

		final MoccPort inPort = inputActor.addInputPort(
				"from" + outputActor.getName(), inRate, inRateDenom);

		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
				outPort, initialRate, initialRateDenominator, inPort);
	}


	public MoccChannel addChannel(final int initialRate,
			final int initialRateDenominator, final MoccActor outputActor,
			final int outRate, final int outRateDenominator,
			final MoccActor inputActor, final int inRate)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), outRate, outRateDenominator);

		final MoccPort inPort  = inputActor.addInputPort(
				"from" + outputActor.getName(), inRate);

		return addChannel(outputActor.getName() + "_" + inputActor.getName(),
				outPort, initialRate, initialRateDenominator, inPort);
	}

	public MoccChannel addChannel(
			final int initialRate, final MoccActor outputActor,
			final int outRate, final MoccActor inputActor, final int inRate)
	{
		return addChannel(initialRate, 1,
				outputActor, outRate, 1, inputActor, inRate);
	}


	// MoccActorFeature
	public MoccSystemFeature computeFeature() {
		FEATURE = new MoccSystemFeature(this, false);

		return FEATURE;
	}

	public MoccSystemFeature computeFeatureStrict() {
		FEATURE = new MoccSystemFeature(this, true);

		return FEATURE;
	}

//	public MoccSystemFeature getFeature() {
//		assert (FEATURE != null) : "Unexpected a null MoccSystemFeature";
//
//		return FEATURE;
//	}


	@Override
	public String toString() {
		final StringBuilder sout = new StringBuilder();

		sout.append("// The MOCC system graph\n\n");

		sout.append("system ").append(name).append(" {").append("\n\n");

		for( final MoccActor actor : getActor() ) {
			sout.append(actor.toString()).append('\n');
		}

		sout.append('\n');

		for( final MoccChannel channel : getChannel() ) {
			sout.append(channel.toString()).append('\n');
		}

		sout.append('\n').append("moe {").append('\n');

		if( FEATURE != null ) {
			sout.append('\t').append("consistency = ")
				.append(FEATURE.consistency).append('\n');

			sout.append('\t').append("// Causality partial order").append('\n');
			sout.append('\t').append("root = [ " );
			for( final MoccActor actor : this.FEATURE.rootActor ) {
				sout.append(actor.getName()).append(' ');
			}
			sout.append(']').append('\n');

			sout.append('\t').append("leaf = [ " );
			for( final MoccActor actor : this.FEATURE.leafActor ) {
				sout.append(actor.getName()).append(' ');
			}
			sout.append(']').append('\n');

			sout.append('\t').append("order = [ " );
			for( final MoccActor actor : this.actors ) {
				sout.append(actor.schedule).append(':')
					.append(actor.getName()).append(' ');
			}
			sout.append(']').append('\n');

			int schedule = 0;
			sout.append('\t').append("stage = 0:[ " );
			for( final MoccActor actor : this.actors ) {
				if( actor.schedule == schedule ) {
					sout.append(actor.getName()).append(' ');
				}
				else {
					schedule = actor.schedule;

					sout.append(']').append('\n')
						.append('\t').append("stage = ").append(schedule)
						.append(":[ " ).append(actor.getName()).append(' ');
				}
			}
			sout.append(']').append('\n');

			sout.append('\n')
				.append('\t').append("frequencies = " )
					.append(Arrays.toString(FEATURE.frequencies)).append('\n')
				.append('\t').append("time        = +" )
					.append(FEATURE.time_interval).append('\n')
				.append('\t').append("period = " )
					.append(FEATURE.time_period).append('\n')
				.append('\t').append("repetition = " )
					.append(Arrays.toString(FEATURE.repetitions))
					.append('\n')
				.append('\n');

			for( final MoccActor actor : getActor() ) {
				sout.append('\t').append(actor.FEATURE.strActivation())
					.append(' ').append(actor.getName())
					.append( actor.isTimed() ? "*" : "" )
					.append('\n');
			}
			sout.append('\n');
		}

		sout.append('\t').append("schedule {").append('\n');

		sout.append('\t').append('}').append('\n');

		sout.append('}').append('\n');

		sout.append('\n').append('}');

		return sout.toString();
	}

}
