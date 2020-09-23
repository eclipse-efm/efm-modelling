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

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Vector;

import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.feature.MoccSystemFeature;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.util.PrettyPrintWriter;

public class MoccSystem {

	protected String name;

	public final Vector< MoccMode > MODE_SET;

	public final MoccMode UNDEFINED;

	public final MoccMode NOMINAL;


	protected final Vector< MoccActor > actors;

	protected final Vector< MoccChannel > channels;
	protected boolean channelWellFormedness;


	public MoccSystemFeature FEATURE;


	public MoccSystem(final String name,
			final String nameModeUndefined, final String literalModeUndefined,
			final String nameModeNominal, final String literalModeNominal) {
		this.name = name;

		this.actors = new Vector<MoccActor>();

		this.channels = new Vector<MoccChannel>();
		this.channelWellFormedness = true;

		this.MODE_SET = new Vector<MoccMode>();

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

		this.MODE_SET.add( mode );

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
		// Check if there is only one channel between 2 actors

		if( this.channelWellFormedness ) {
			for( final MoccChannel itChannel : channels ) {
				if( (itChannel.getInputPort() == channel.getInputPort())
				&& (itChannel.getOutputPort() == channel.getOutputPort()) )
				{
					this.channelWellFormedness = false;

					break;
				}
				else if( itChannel.getInputPort().getName().equals(channel.getInputPort().getName())
						&& itChannel.getOutputPort().getName().equals(channel.getOutputPort().getName()) )
				{
					this.channelWellFormedness = false;

					break;
				}
			}
		}

		channels.add(channel);
	}

	public boolean isChannelConsistent() {
		return channelWellFormedness;
	}

	public boolean isWellFormed() {
		return channelWellFormedness;
	}



	public MoccChannel addChannel(final boolean isDeciding,
			final String name, final MoccPort outputPort,
			final int initialRate, final int initialRateDenominator,
			final MoccMode initialMode, final MoccPort inputPort)
	{
		return new MoccChannel(this, name, isDeciding, outputPort,
				initialMode, initialRate, initialRateDenominator, inputPort);
	}

	public MoccChannel addChannel(final boolean isDeciding, final String name,
			final MoccPort outputPort, final int initialRate,
			final int initialRateDenominator, final MoccPort inputPort)
	{
		return new MoccChannel(this, name, isDeciding, outputPort,
				initialRate, initialRateDenominator, inputPort);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final String name, final MoccPort outputPort,
			final int initialRate, final MoccPort inputPort)
	{
		return new MoccChannel(this, name,
				isDeciding, outputPort, initialRate, inputPort);
	}

//	public MoccChannel addChannel(final boolean isDeciding,
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
//	public MoccChannel addChannel(final boolean isDeciding, final MoccActor outputActor,
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
//	public MoccChannel addChannel(final boolean isDeciding,
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
//	public MoccChannel addChannel(final boolean isDeciding,
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
//	public MoccChannel addChannel(final boolean isDeciding, final int initialRate,
//			final MoccActor outputActor, final String outPortName,
//			final int outRate, final MoccActor inputActor,
//			final String inPortName, final int inRate)
//	{
//		return addChannel(initialRate, 1, outputActor, outPortName,
//				outRate, 1, inputActor, inPortName, inRate);
//	}

	public MoccChannel addChannel(final boolean isDeciding,
			final MoccActor outputActor, final int outRate,
			final MoccActor inputActor, final int inRate)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), isDeciding, outRate);

		final MoccPort inPort  = inputActor.addInputPort(
				"from" + outputActor.getName(), isDeciding, inRate);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, 0, inPort);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final MoccActor outputActor,
			final int outRate, final int outRateDenom,
			final MoccActor inputActor, final int inRate)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), isDeciding, outRate, outRateDenom);

		final MoccPort inPort  = inputActor.addInputPort(
				"from" + outputActor.getName(), isDeciding, inRate);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, 0, inPort);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final MoccActor outputActor, final String outPortName,
			final int outRate, final MoccActor inputActor,
			final String inPortName, final int inRate, final int inRateDenom)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				outPortName, isDeciding, outRate);

		final MoccPort inPort = inputActor.addInputPort(
				inPortName, isDeciding, inRate, inRateDenom);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, 0, inPort);
	}


	public MoccChannel addChannel(final boolean isDeciding,
			final MoccActor outputActor, final int outRate,
			final MoccActor inputActor, final int inRate, final int inRateDenom)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), isDeciding, outRate);

		final MoccPort inPort = inputActor.addInputPort(
				"from" + outputActor.getName(), isDeciding, inRate, inRateDenom);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, 0, inPort);
	}


	public MoccChannel addChannel(final boolean isDeciding,
			final int initialRate, final int initialRateDenominator,
			final MoccActor outputActor, final int outRate, final int outRateDenom,
			final MoccActor inputActor, final int inRate, final int inRateDenom)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), isDeciding, outRate, outRateDenom);

		final MoccPort inPort = inputActor.addInputPort(
				"from" + outputActor.getName(), isDeciding, inRate, inRateDenom);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, initialRate, initialRateDenominator, inPort);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final int initialRate, final int initialRateDenominator,
			final MoccMode initialMode,
			final MoccActor outputActor, final int outRate,
			final MoccActor inputActor, final int inRate, final int inRateDenom)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), isDeciding, outRate);

		final MoccPort inPort = inputActor.addInputPort(
				"from" + outputActor.getName(), isDeciding, inRate, inRateDenom);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, initialRate, initialRateDenominator, initialMode, inPort);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final int initialRate, final int initialRateDenominator,
			final MoccActor outputActor, final int outRate,
			final MoccActor inputActor, final int inRate, final int inRateDenom)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(), isDeciding, outRate);

		final MoccPort inPort = inputActor.addInputPort(
				"from" + outputActor.getName(), isDeciding, inRate, inRateDenom);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, initialRate, initialRateDenominator, inPort);
	}


	public MoccChannel addChannel(final boolean isDeciding,
			final int initialRate, final int initialRateDenominator,
			final MoccMode initialMode, final MoccActor outputActor,
			final int outRate, final int outRateDenominator,
			final MoccActor inputActor, final int inRate)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(),
				isDeciding, outRate, outRateDenominator);

		final MoccPort inPort  = inputActor.addInputPort(
				"from" + outputActor.getName(), isDeciding, inRate);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, initialRate, initialRateDenominator, initialMode, inPort);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final int initialRate, final int initialRateDenominator,
			final MoccActor outputActor,
			final int outRate, final int outRateDenominator,
			final MoccActor inputActor, final int inRate)
	{
		final MoccPort outPort = outputActor.addOutputPort(
				"to" + inputActor.getName(),
				isDeciding, outRate, outRateDenominator);

		final MoccPort inPort  = inputActor.addInputPort(
				"from" + outputActor.getName(), isDeciding, inRate);

		return addChannel(isDeciding,
				outputActor.getName() + "_" + inputActor.getName(),
				outPort, initialRate, initialRateDenominator, inPort);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final int initialRate, final MoccActor outputActor,
			final int outRate, final MoccActor inputActor, final int inRate)
	{
		return addChannel(isDeciding, initialRate, 1,
				outputActor, outRate, 1, inputActor, inRate);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final int initialRate, final MoccActor outputActor,
			final int outRate, final int outRateDenominator,
			final MoccActor inputActor, final int inRate)
	{
		return addChannel(isDeciding, initialRate, 1,
				outputActor, outRate, outRateDenominator, inputActor, inRate);
	}

	public MoccChannel addChannel(final boolean isDeciding,
			final int initialRate, final MoccMode initialMode,
			final MoccActor outputActor, final int outRate,
			final MoccActor inputActor, final int inRate)
	{
		return addChannel(isDeciding, initialRate, 1, initialMode,
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


	public String toAbstract() {
		final StringWriter buffer = new StringWriter();
		final PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

		toAbstract( writer );

		return buffer.toString();
	}

	public PrettyPrintWriter toAbstract(final PrettyPrintWriter writer) {
		writer.appendTabEol("// The Polygraph System Graph Abstract");

		writer.appendTab("system ").append(name).appendEol(" {");

		writer
			.appendTab2("well-formed = ").appendEol(isWellFormed())
			.appendTab2("actor       = ").appendEol(getActor().size())
			.appendTab2("channel     = ").append(getChannel().size())
			.appendTab2("channel OK? = ").appendEol(isChannelConsistent());

		if( FEATURE != null ) {
			writer
				.appendTab2("timed       = ").appendEol(FEATURE.timedActorCount)
				.appendTab2("phase       = ").appendEol(FEATURE.phaseActorCount)
				.appendTab2("consistency = ").appendEol(FEATURE.consistency);

			if( FEATURE.consistency ) {
				writer
					.appendTab2("repetition  = " )
						.appendEol(Arrays.toString(FEATURE.repetitions))
					.appendTab2("firings     = " ).appendEol(FEATURE.firings)

					.appendTab2("frequencies = " ).appendEol(FEATURE.strFrequencies())

					.appendTab2("tick_frequency = ").appendEol(FEATURE.tick_frequency)
					.appendTab2("tick_step      = +").appendEol(FEATURE.tick_step)

					.appendTab2("period         = " ).appendEol(FEATURE.period)       // time resolution
					.appendTab2("hyperperiod    = " ).appendEol(FEATURE.hyperperiod); // live resolution


				writer.appendEol();

				for( final MoccActor actor : getActor() ) {
					writer.appendTab2(actor.FEATURE.strActivation())
						.append(' ').append(actor.getName())
						.appendEol( actor.isTimed() ? "*" : "" );
				}
			}
		}

		writer.appendTabEol('}');

		return writer;
	}


	@Override
	public String toString() {
		final StringWriter buffer = new StringWriter();
		final PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

		toWriter( writer );

		return buffer.toString();
	}

	public PrettyPrintWriter toWriter(final PrettyPrintWriter writer) {
		writer.appendTabEol("// The MOCC system graph");

		writer.appendTab("system ").append(name).appendEol2(" {");

		final PrettyPrintWriter writer2 = writer.itab2();

		for( final MoccActor actor : getActor() ) {
			actor.toWriter(writer2);
		}

		writer.appendEol();

		for( final MoccChannel channel : getChannel() ) {
			channel.toWriter(writer2);
		}

		writer.appendEol();

		writer.appendTab2Eol("moe {");

		if( FEATURE != null ) {
			writer.appendTab3("consistency = ").appendEol(FEATURE.consistency);

			writer.appendTab3Eol("// Causality partial order");
			writer.appendTab3("root = [ " );
			for( final MoccActor actor : this.FEATURE.rootActor ) {
				writer.append(actor.getName()).append(' ');
			}
			writer.appendEol(']');

			writer.appendTab3("leaf = [ " );
			for( final MoccActor actor : this.FEATURE.leafActor ) {
				writer.append(actor.getName()).append(' ');
			}
			writer.appendEol(']');

			writer.appendTab3("order = [ " );
			for( final MoccActor actor : this.actors ) {
				writer.append(actor.schedule).append(':')
					.append(actor.getName()).append(' ');
			}
			writer.appendEol(']');

			int schedule = 0;
			writer.appendTab3("stage = 0:[ " );
			for( final MoccActor actor : this.actors ) {
				if( actor.schedule == schedule ) {
					writer.append(actor.getName()).append(' ');
				}
				else {
					schedule = actor.schedule;

					writer.appendEol(']')
						.appendTab3("stage = ").append(schedule)
						.append(":[ " ).append(actor.getName()).append(' ');
				}
			}
			writer.appendEol(']');

			writer.appendEol();

			writer.appendTab3("timed_actor = " )
					.append(FEATURE.timedActorCount).append(" / ")
					.appendEol(actors.size())

				.appendTab3("phase       = ")
					.append(FEATURE.phaseActorCount).append(" / ")
					.appendEol(actors.size())

				.appendTab3("frequencies    = " )
					.appendEol(FEATURE.strFrequencies())

				.appendTab3("tick_frequency = ").appendEol(FEATURE.tick_frequency)
				.appendTab3("tick_step      = +").appendEol(FEATURE.tick_step)
				.appendTab3("period         = " ).appendEol(FEATURE.period)      // time resolution
				.appendTab3("hyperperiod    = " ).appendEol(FEATURE.hyperperiod) // live resolution

				.appendTab3("repetition     = " )
					.appendEol(Arrays.toString(FEATURE.repetitions))
				.appendTab3("firings     = "  ).appendEol(FEATURE.firings);

			writer.appendEol();

			for( final MoccActor actor : getActor() ) {
				writer.appendTab3(actor.FEATURE.strActivation())
					.append(' ').append(actor.getName())
					.appendEol( actor.isTimed() ? "*" : "" );
			}
		}

		writer.appendTab2Eol('}');

//		sout.appendTab2Eol("schedule {");
//
//		sout.appendTab2Eol('}');

		writer.appendTabEol('}');

		writer.flush();

		return writer;
	}

}
