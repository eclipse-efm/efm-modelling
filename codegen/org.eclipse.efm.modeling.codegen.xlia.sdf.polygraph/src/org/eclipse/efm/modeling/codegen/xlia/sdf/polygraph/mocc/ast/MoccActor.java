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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccPort.Direction;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.feature.MoccActorFeature;

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
	public MoccPort addInputPort(final String name, final int rate) {
		return( new MoccPort(this, Direction.INPUT, name, rate) );
	}

	public MoccPort addInputPort(
			final String name, final int rate, final int rateDenominator) {
		return( new MoccPort(this,
				Direction.INPUT, name, rate, rateDenominator) );
	}

	// OUTPUT PORT
	public MoccPort addOutputPort(final String name, final int rate) {
		return( new MoccPort(this, Direction.OUTPUT, name, rate) );
	}

	public MoccPort addOutputPort(
			final String name, final int rate, final int rateDenominator) {
		return( new MoccPort(this,
				Direction.OUTPUT, name, rate, rateDenominator) );
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
		final StringBuilder sout = new StringBuilder();

		sout.append("actor ").append(name).append(" {").append('\n');

		sout.append('\t').append("frequency = " ).append(frequency)
			.append('\n')
			.append('\t').append("phase = "     ).append(phase)
			.append('\n')
			.append('\t').append("moe {")
			.append('\n')
			.append("\t\t").append("schedule = ")
			.append(schedule).append('\n');

		if( FEATURE != null ) {
			sout.append("\t\t").append("repetition = ")
					.append(FEATURE.repetition).append('\n')
				.append("\t\t").append("activation = ")
					.append(FEATURE.strActivation()).append('\n');
		}
		sout.append('\t').append('}')
			.append('\n');

		if( selector != null ) {
			sout.append('\t').append("selector = " )
				.append(selector.getName()).append('\n');
		}
		if( selectionSet.length > 0 ) {
			sout.append('\t').append("selectionSet = [ " );
			for( final MoccMode mode : selectionSet ) {
				sout.append(mode.getLiteral()).append(' ');
			}
			sout.append(']').append('\n');
		}
		if( processingSet.length > 0 ) {
			sout.append('\t').append("processingSet = [ " );
			for( final MoccMode mode : processingSet ) {
				sout.append(mode.getLiteral()).append(' ');
			}
			sout.append(']').append('\n');
		}


		if( ! predecessorActor.isEmpty() ) {
			sout.append('\t').append("predecessor = [ " );
			for( final MoccActor actor : predecessorActor ) {
				sout.append(actor.getName()).append(' ');
			}
			sout.append(']').append('\n');
		}
		if( ! successorActor.isEmpty() ) {
			sout.append('\t').append("successor = [ " );
			for( final MoccActor actor : successorActor ) {
				sout.append(actor.getName()).append(' ');
			}
			sout.append(']').append('\n');
		}

		for( final MoccPort port : getInputPort() ) {
			sout.append('\t').append(port.toString()).append('\n');
		}

		for( final MoccPort port : getOutputPort() ) {
			sout.append('\t').append(port.toString()).append('\n');
		}

		sout.append('}');

		return sout.toString();
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
