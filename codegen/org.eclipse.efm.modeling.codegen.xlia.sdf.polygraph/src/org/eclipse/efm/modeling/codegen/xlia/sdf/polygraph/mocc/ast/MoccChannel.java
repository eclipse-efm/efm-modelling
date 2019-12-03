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

import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.util.PrettyPrintWriter;

public class MoccChannel {

	protected final MoccSystem system;

	protected String name;

	protected boolean isDeciding;

	protected final MoccPort outputPort;

	protected final MoccMode initialMode;

//	protected final int initialRate;
	public int initialRate;

	protected final int initialRateDenominator;

	protected final MoccPort inputPort;


	public MoccChannel(final MoccSystem system,
			final String name, final boolean isDeciding,
			final MoccPort outputPort, final MoccMode initialMode,
			final int initialRate, final int initialRateDenominator,
			final MoccPort inputPort)
	{
		super();

		assert (system != null) : "Unexpected a null MoccSystem";
		this.system = system;

		this.name = name;

		this.isDeciding = isDeciding;

		this.outputPort = outputPort;

		this.initialMode = initialMode;
		this.initialRate = initialRate;
		this.initialRateDenominator = initialRateDenominator;

		this.inputPort = inputPort;

		this.outputPort.updateOutputChannel(this);
		this.inputPort.updateInputChannel(this);

		system.addChannel( this );
	}

	public MoccChannel(final MoccSystem system,
			final String name, final boolean isDeciding,
			final MoccPort outputPort, final MoccMode initialMode,
			final int initialRate, final MoccPort inputPort)
	{
		this(system, name, isDeciding,
				outputPort, initialMode, initialRate, 1, inputPort);
	}

	public MoccChannel(final MoccSystem system, final String name,
			final boolean isDeciding,
			final MoccPort outputPort, final int initialRate,
			final int initialRateDenominator, final MoccPort inputPort)
	{
		this(system, name, isDeciding, outputPort, system.NOMINAL,
				initialRate, initialRateDenominator, inputPort);
	}

	public MoccChannel(final MoccSystem system, final String name,
			final boolean isDeciding, final MoccPort outputPort,
			final int initialRate, final MoccPort inputPort)
	{
		this(system, name, isDeciding, outputPort,
				system.NOMINAL, initialRate, 1, inputPort);
	}

	public MoccChannel(final MoccSystem system, final String name,
			final boolean isDeciding, final MoccPort outputPort,
			final MoccPort inputPort)
	{
		this(system, name, isDeciding,
				outputPort, system.NOMINAL, 0, 1, inputPort);
	}


	// GETTERS - SETTERS
	public MoccSystem getSystem() {
		return system;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	// Output actor & port
	public MoccPort getOutputPort() {
		return outputPort;
	}

	public MoccActor getOutputActor() {
		return outputPort.getActor();
	}

	// input actor & port
	public MoccPort getInputPort() {
		return inputPort;
	}

	public MoccActor getInputActor() {
		return inputPort.getActor();
	}

	// Initial rate & mode
	public MoccMode getInitialMode() {
		return initialMode;
	}

	public boolean hasInitialMode() {
		return( hasInitialRate()
				&& (initialMode != null)
				&& (outputPort.getActor().isModeProducer()
					|| inputPort.getActor().isModeProcessor()) );
//				&& (! initialMode.equals(system.NOMINAL)) );
	}


	// Initial rate
	public int getInitialRate() {
		return initialRate;
	}

	public int getInitialRateDenominator() {
		return initialRateDenominator;
	}


	public boolean hasInitialRate() {
		return( initialRate != 0 );
	}

	public boolean hasRationalRate() {
		return( (initialRate != 0) && (initialRateDenominator > 1) );
	}


	public boolean hasCycloStaticPort() {
		return( inputPort.hasCycloStaticRate()
			|| outputPort.hasCycloStaticRate() );
	}


	public String strInitialRate() {
		if( hasRationalRate() ) {
			return( initialRate + "/" + initialRateDenominator );
		}
		else {
			return( Integer.toString(initialRate) );
		}
	}


	@Override
	public String toString() {
		final StringWriter buffer = new StringWriter();
		final PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

		toWriter( writer );

		return buffer.toString();
	}

	public PrettyPrintWriter toWriter(final PrettyPrintWriter writer) {
		writer.appendTab("channel").append(' ').append(name).appendEol(" {");

		writer.appendTab2("deciding = ").appendEol(isDeciding);

		writer.appendTab2("output<").append(outputPort.strRate());
		if( outputPort.cycloStaticRate != null ) {
			writer.append(" , ");
			outputPort.strCycloStaticRate(writer);
		}
		writer.append("> ")
			.append(outputPort.getActor().getName())
			.append("->").appendEol(outputPort.getName());

		if( hasInitialRate() ) {
			writer.appendTab2("initial{ rate = ")
				.append(strInitialRate());

			if( hasInitialMode() ) {
				writer.append(" , mode = ").append(initialMode.getLiteral());
			}

			writer.appendEol(" }");
		}

		writer.appendTab2("input<").append(inputPort.strRate());
		if( inputPort.cycloStaticRate != null ) {
			writer.append(" , ");
			inputPort.strCycloStaticRate(writer);
		}
		writer.append("> ")
			.append(inputPort.getActor().getName())
			.append("->").appendEol(inputPort.getName());

		writer.appendTabEol('}');

		writer.flush();

		return writer;
	}



}
