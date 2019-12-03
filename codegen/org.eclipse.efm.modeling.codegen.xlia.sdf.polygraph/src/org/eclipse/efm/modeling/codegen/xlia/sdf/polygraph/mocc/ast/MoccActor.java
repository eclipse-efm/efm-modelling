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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccPort.Direction;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.feature.MoccActorFeature;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.util.PrettyPrintWriter;

public class MoccActor {

	protected final MoccSystem system;

	protected final String name;

//	protected final int frequency;
	public int frequency;

//	protected final int phase;
	public int phase;

	public static final int DEFAULT_INITIAL_SCHEDULE = -1;

	public int schedule;

	public int index;

	protected final List< MoccPort    > inputPort;
	protected final List< MoccPort    > outputPort;


	protected MoccActor selector;

	public final static MoccMode[] NO_MODE = new MoccMode[0];

	protected MoccMode[] selectionSet;
	protected MoccMode[] processingSet;


	protected final List< MoccActor > predecessorActor;
	protected final List< MoccActor > successorActor;


	// Composite purpose
	protected MoccSystem subSystem;

	// system.channel  ---> subsystem.actor
	protected Map<MoccChannel, MoccActor> inputGateway;
	// subsystem.actor ---> system.channel
	protected Map<MoccActor, MoccChannel> outputGateway;

	// Analysis Purpose
	public MoccActorFeature FEATURE;

	// Timed & Phase - Selector & Processor Mode - Actor
	public MoccActor(final MoccSystem system,
			final String name, final int frequency,
			final int phase, final MoccMode[] selectionSet,
			final MoccActor selector, final MoccMode[] processingSet) {
		super();

		assert (system != null) : "Unexpected a null MoccSystem";
		this.system = system;

		this.name = name;

		this.frequency = frequency;

		this.phase = phase;

		this.schedule = DEFAULT_INITIAL_SCHEDULE;

		this.inputPort = new ArrayList<MoccPort>();
		this.outputPort = new ArrayList<MoccPort>();

		this.selector = selector;

		this.selectionSet  = (selectionSet  != null) ? selectionSet  : NO_MODE;
		this.processingSet = (processingSet != null) ? processingSet : NO_MODE;

		this.predecessorActor = new ArrayList<MoccActor>();
		this.successorActor = new ArrayList<MoccActor>();

		this.subSystem = null;
		this.inputGateway  = null;
		this.outputGateway = null;

		this.FEATURE = null;

		system.addActor( this );
	}

	// Timed & Phase - Selector Mode - Actor
	public MoccActor(final MoccSystem system,
			final String name, final int frequency,
			final int phase, final MoccMode[] selectionSet) {
		super();

		assert (system != null) : "Unexpected a null MoccSystem";
		this.system = system;

		this.name = name;

		this.frequency = frequency;

		this.phase = phase;

		this.schedule = DEFAULT_INITIAL_SCHEDULE;

		this.inputPort = new ArrayList<MoccPort>();
		this.outputPort = new ArrayList<MoccPort>();

		this.selector = this;

		this.selectionSet  = (selectionSet != null) ? selectionSet : NO_MODE;
		this.processingSet = NO_MODE;

		this.predecessorActor = new ArrayList<MoccActor>();
		this.successorActor = new ArrayList<MoccActor>();

		this.subSystem     = null;
		this.inputGateway  = null;
		this.outputGateway = null;

		this.FEATURE = null;

		system.addActor( this );
	}

	// Timed & Phase - Processor Mode - Actor
	public MoccActor(final MoccSystem system,
			final String name, final int frequency, final int phase,
			final MoccActor selector, final MoccMode[] processingSet) {
		this(system, name, frequency, phase,
				NO_MODE, selector, processingSet);
	}

	// Timed & Phase - Actor
	public MoccActor(final MoccSystem system,
			final String name, final int frequency, final int phase) {
		this(system, name, frequency, phase,
				NO_MODE, null, NO_MODE);
	}


	// Timed - Selector & Processor Mode - Actor
	public MoccActor(final MoccSystem system, final String name,
			final int frequency, final MoccMode[] selectionSet,
			final MoccActor selector, final MoccMode[] processingSet) {
		this(system, name, frequency, 0, selectionSet, selector, processingSet);
	}

	// Timed - Selector Mode - Actor
	public MoccActor(final MoccSystem system, final String name,
			final int frequency, final MoccMode[] selectionSet) {
		this(system, name, frequency, 0, selectionSet);
	}

	// Timed - Processor Mode - Actor
	public MoccActor(final MoccSystem system,
			final String name, final int frequency,
			final MoccActor selector, final MoccMode[] processingSet) {
		this(system, name, frequency, 0,
				NO_MODE, selector, processingSet);
	}

	// Timed Actor
	public MoccActor(final MoccSystem system,
			final String name, final int frequency) {
		this(system, name, frequency, 0, NO_MODE, null, NO_MODE);
	}


	// Basic - Selector & Processor Mode - Actor
	public MoccActor(final MoccSystem system,
			final String name, final MoccMode[] selectionSet,
			final MoccActor selector, final MoccMode[] processingSet) {
		this(system, name, -1, 0, selectionSet, selector, processingSet);
	}

	// Basic - Selector Mode - Actor
	public MoccActor(final MoccSystem system,
			final String name, final MoccMode[] selectionSet) {
		this(system, name, -1, 0, selectionSet);
	}

	// Basic - Processor Mode - Actor
	public MoccActor(final MoccSystem system, final String name,
			final MoccActor selector, final MoccMode[] processingSet) {
		this(system, name, -1, 0, NO_MODE, selector, processingSet);
	}

	// Basic Actor
	public MoccActor(final MoccSystem system, final String name) {
		this(system, name, -1, 0, NO_MODE, null, NO_MODE);
	}


	// GETTERS - SETTERS
	public MoccSystem getSystem() {
		return system;
	}

	public String getName() {
		return name;
	}

	public int getFrequency() {
		return frequency;
	}

	public boolean isTimed() {
		return( frequency > 0 );
	}

	public int getPhase() {
		return phase;
	}

	public String getNature() {
		if(  isTimed() ) {
			if(  hasSelectionSet() ) {
				return( "[ \"TIME\" , \"MODE\" ]" );
	}
			else {
				return( "[ \"TIME\" ]" );
			}
		}
		else if(  hasSelectionSet() ) {
			return( "[ \"MODE\" ]" );
		}
		else {
			return( "[ \"REGULAR\" ]" );
		}
	}



	// Port
	public List<MoccPort> getInputPort() {
		return inputPort;
	}

//	public int decidingPortCount() {
//		int count = 0;
//
//		for (final MoccPort inPort : inputPort) {
//			if( inPort.isDeciding() ) {
//				count += 1;
//			}
//		}
//		return count;
//	}

	public boolean hasInputPort() {
		return( ! inputPort.isEmpty() );
	}

	public List<MoccPort> getOutputPort() {
		return outputPort;
	}

	public boolean hasOutputPort() {
		return( ! outputPort.isEmpty() );
	}

	// Mode
	public MoccActor getSelector() {
		return selector;
	}

	public void setSelector(final MoccActor selector) {
		this.selector = selector;
	}

	public MoccMode[] getSelectionSet() {
		return selectionSet;
	}

	public void setSelectionSet(final MoccMode[] selectionSet) {
		this.selectionSet = selectionSet;
	}

	public String[] getSelectionSetLiterals() {
		final String[] literals = new String[selectionSet.length];
		for (int index = 0; index < literals.length; index++) {
			literals[index] = selectionSet[index].getLiteral();
		}

		return literals;
	}

	public boolean hasSelectionSet() {
		return( selectionSet.length > 0 );
	}



	public MoccMode[] getProcessingSet() {
		return processingSet;
	}

	public void setProcessingSet(final MoccMode[] processingSet) {
		this.processingSet = processingSet;
	}

	public String[] getProcessingSetLiterals() {
		final String[] literals = new String[processingSet.length];
		for (int index = 0; index < literals.length; index++) {
			literals[index] = processingSet[index].getLiteral();
		}

		return literals;
	}

	public boolean isNominalSingletonProcessingSet() {
		return( /*(selector != null)
				&&*/ (processingSet.length == 1)
				&& processingSet[0].equals(system.NOMINAL));
	}

	public boolean isModeProcessor() {
		return( /*(selector != null) &&*/ (processingSet.length > 0) );
	}

	public boolean isModeSelector() {
		return( selectionSet.length > 0 );
	}

	public boolean isModeProducer() {
		return( isModeSelector() || isModeProcessor() );
	}



	// DIRECTED PORT
	public void addPort(final MoccPort port) {
		if( port.isInput() ) {
			inputPort.add( port );
		}
		else {
			outputPort.add( port );
		}
	}


	// INPUT PORT
	public MoccPort addInputPort(final String name,
			final boolean isDeciding, final int rate)
	{
		return( new MoccPort(this, Direction.INPUT, name, isDeciding, rate) );
	}

	public MoccPort addInputPort(
			final String name, final boolean isDeciding,
			final int rate, final int rateDenominator)
	{
		return( new MoccPort(this,
				Direction.INPUT, name, isDeciding, rate, rateDenominator) );
	}

	// OUTPUT PORT
	public MoccPort addOutputPort(final String name,
			final boolean isDeciding, final int rate)
	{
		return( new MoccPort(this, Direction.OUTPUT, name, isDeciding, rate) );
	}

	public MoccPort addOutputPort(
			final String name, final boolean isDeciding,
			final int rate, final int rateDenominator)
	{
		return( new MoccPort(this, Direction.OUTPUT,
				name, isDeciding, rate, rateDenominator) );
	}

	// PREDECESSOR /SUCCESSOR
	public List< MoccActor > getPredecessor() {
		return predecessorActor;
	}

	public List< MoccActor > getSuccessor() {
		return successorActor;
	}

	// Channel
	public void updateInputChannel(final MoccChannel channel) {
		predecessorActor.add( channel.getOutputPort().getActor() );
	}

	public void updateOutputChannel(final MoccChannel channel) {
		successorActor.add( channel.getInputPort().getActor() );
	}


	// COMPOSITE ACTOR INPUT GATEWAY
	public Map<MoccChannel, MoccActor> getInputGateway() {
		return this.inputGateway;
	}

	public boolean hasInputGateway() {
		return( this.inputGateway != null );
	}

	public void addInputGateway(final MoccChannel channel, final MoccActor actor) {
		if( this.inputGateway == null ) {
			this.inputGateway = new HashMap<MoccChannel, MoccActor>();
		}
		this.inputGateway.put(channel, actor);
	}

	public void addInputGateway(final MoccChannel channel) {
		if( this.inputGateway == null ) {
			this.inputGateway = new HashMap<MoccChannel, MoccActor>();
		}
		this.inputGateway.put(channel, this);

//		addProxyPort(channel, Direction.INPUT);
	}


	// COMPOSITE ACTOR OUTPUT GATEWAY
	public Map<MoccActor, MoccChannel> getOutputGateway() {
		return this.outputGateway;
	}

	public boolean hasOutputGateway() {
		return( this.outputGateway != null );
	}

	public void addOutputGateway(final MoccActor actor, final MoccChannel channel) {
		if( this.outputGateway == null ) {
			this.outputGateway = new HashMap<MoccActor, MoccChannel>();
		}
		this.outputGateway.put(actor, channel);
	}

	public void addOutputGateway(final MoccChannel channel) {
		if( this.outputGateway == null ) {
			this.outputGateway = new HashMap<MoccActor, MoccChannel>();
		}
		this.outputGateway.put(this, channel);

//		addProxyPort(channel, Direction.OUTPUT);
	}


	// COMPOSITE ACTOR SUB-SYSTEM
	public MoccSystem getSubSystem() {
		return this.subSystem;
	}

	public boolean isComposite() {
		return( (this.subSystem != null)
				&& (! this.subSystem.getActor().isEmpty()) );
	}

	public void setSubSystem(final MoccSystem moccSystem) {
		this.subSystem = moccSystem;
	}


	// MoccActorFeature
	public void computeFeature() {
		FEATURE = new MoccActorFeature(this);
	}

//	public MoccActorFeature getFeature() {
//		assert (FEATURE != null) : "Unexpected a null MoccActorFeature";
//
//		return FEATURE;
//	}


	@Override
	public String toString() {
		final StringWriter buffer = new StringWriter();
		final PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

		toWriter( writer );

		return buffer.toString();
	}

	public PrettyPrintWriter toWriter(final PrettyPrintWriter writer) {
		writer.appendTab("actor ").append(name).appendEol(" {");

		writer.appendTab2("frequency = ").appendEol(frequency)
			.appendTab2("phase = "      ).appendEol(phase)
			.appendTab2Eol("moe {")
			.appendTab3("schedule = "  ).appendEol(schedule);

		if( FEATURE != null ) {
			writer.appendTab3("omega_freq = ")
					.appendEol(FEATURE.omegaFrequency)
				.appendTab3("executable = ")
					.appendEol(FEATURE.isExecutable)
				.appendTab3("repetition = ")
					.appendEol(FEATURE.repetition)
				.appendTab3("activation = ")
					.appendEol(FEATURE.strActivation());
		}
		writer.appendTab2Eol('}');

		if( selector != null ) {
			writer.appendTab2("selector = ").appendEol(selector.getName());
		}
		if( selectionSet.length > 0 ) {
			writer.appendTab2("selectionSet = [");
			for( final MoccMode mode : selectionSet ) {
				writer.append(mode.getLiteral()).append(' ');
			}
			writer.appendEol(']');
		}
		if( processingSet.length > 0 ) {
			writer.appendTab2("processingSet = [");
			for( final MoccMode mode : processingSet ) {
				writer.append(mode.getLiteral()).append(' ');
			}
			writer.appendEol(']');
		}


		if( ! predecessorActor.isEmpty() ) {
			writer.appendTab2("predecessor = [");
			for( final MoccActor actor : predecessorActor ) {
				writer.append(actor.getName()).append(' ');
			}
			writer.appendEol(']');
		}
		if( ! successorActor.isEmpty() ) {
			writer.appendTab2("successor = [");
			for( final MoccActor actor : successorActor ) {
				writer.append(actor.getName()).append(' ');
			}
			writer.appendEol(']');
		}


		final PrettyPrintWriter writer2 = writer.itab2();

		for( final MoccPort port : getInputPort() ) {
			port.toWriter(writer2);
		}

		for( final MoccPort port : getOutputPort() ) {
			port.toWriter(writer2);
		}


		if( this.inputGateway != null ) {
			writer.appendEol();

			writer.appendTab2Eol("input gateway {");

			for( final  Entry<MoccChannel, MoccActor> bridge
					: this.inputGateway.entrySet() )
			{
				final MoccChannel channel = bridge.getKey();
				final MoccActor proxyActor = bridge.getValue();

				writer.appendTab3(channel.getOutputActor().getName())
					.append("->")
					.append(channel.getName())
					.append( " ==> this" );
				if( this != proxyActor ) {
					writer.append('.').appendEol(proxyActor.name);
				}
				else {
					writer.appendEol();
				}
			}

			writer.appendTab2Eol('}');
		}

		if( this.outputGateway != null ) {
			writer.appendEol();

			writer.appendTab2Eol("output gateway {");

			for( final  Entry<MoccActor, MoccChannel> bridge
					: this.outputGateway.entrySet() )
			{
				final MoccChannel channel = bridge.getValue();
				final MoccActor proxyActor = bridge.getKey();

				writer.appendTab3("this");
				if( this != proxyActor ) {
					writer.append('.').append(proxyActor.name);
				}
				writer.append( " ==> " )
					.append(channel.getName())
					.append("->")
					.appendEol(channel.getInputActor().getName());
			}

			writer.appendTab2Eol('}');
		}

		if( this.subSystem != null ) {
			writer2.appendEol();
			this.subSystem.toWriter(writer2);
		}

		writer.appendTabEol('}');

		writer.flush();

		return writer;
	}

	public boolean hasEnoughInitialRate(final MoccActor sourceActor) {
		for( final MoccPort port : getInputPort() ) {
			if( port.hasEnoughInitialRate(sourceActor) ) {
				return true;
			}
		}
		return false;
	}

}
