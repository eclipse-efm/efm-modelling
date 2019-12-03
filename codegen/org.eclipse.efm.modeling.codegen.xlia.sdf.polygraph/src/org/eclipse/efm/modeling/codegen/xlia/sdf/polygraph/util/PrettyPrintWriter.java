/*******************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class PrettyPrintWriter extends PrintWriter {

	public static String DEFAULT_TAB  = "";
	public static String DEFAULT_ITAB = "\t";
	public static String DEFAULT_EOL  = "\n";

	protected Writer writer;

	public String EOL;
	public String EOL2;

	public String iTAB;

	public String TAB1;
	public String TAB2;
	public String TAB3;
	public String TAB4;
	public String TAB5;


	////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	////////////////////////////////////////////////////////////////////////////

	public PrettyPrintWriter(final Writer writer, final String tab, final String itab, final String eol) {
		super( writer );

		this.writer = writer;

		this.TAB1 = tab;
		this.iTAB = itab;

		this.EOL  = eol;
		this.EOL2 = this.EOL + eol;

		this.TAB2 =  this.TAB1 + this.iTAB;
		this.TAB3 =  this.TAB2 + this.iTAB;
		this.TAB4 =  this.TAB3 + this.iTAB;
		this.TAB5 =  this.TAB4 + this.iTAB;
	}

	public PrettyPrintWriter(final String fileName, final String tab, final String itab, final String eol)
			throws FileNotFoundException{
		super( fileName );

		this.TAB1 = tab;
		this.iTAB = itab;

		this.EOL  = eol;
		this.EOL2 = this.EOL + eol;

		this.TAB2 =  this.TAB1 + this.iTAB;
		this.TAB3 =  this.TAB2 + this.iTAB;
		this.TAB4 =  this.TAB3 + this.iTAB;
		this.TAB5 =  this.TAB4 + this.iTAB;
	}


	public PrettyPrintWriter(final Writer writer, final String tab, final String itab) {
		this(writer, tab, itab, DEFAULT_EOL);
	}

	public PrettyPrintWriter(final Writer writer, final String tab) {
		this(writer, tab, DEFAULT_ITAB, DEFAULT_EOL);
	}

	public PrettyPrintWriter(final Writer writer) {
		this(writer, DEFAULT_TAB, DEFAULT_ITAB, DEFAULT_EOL);
	}

	@Override
	public void close() {
		if( this.writer != null ) {
			try {
				this.writer.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String tab(int count) {
		String ntab = TAB1;
		for( ; count > 0 ; --count ) {
			ntab += iTAB;
		}

		return( ntab );
	}

	public void pushTab(int count) {
		if( count > 0 ) {
			super.append( TAB1 );

			for( ; count > 0 ; --count ) {
				super.append( iTAB );
			}
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// INDENTATION
	////////////////////////////////////////////////////////////////////////////

	public PrettyPrintWriter itab(final String tab, final String itab, final String eol) {
		return( new PrettyPrintWriter(this, tab, itab, eol) );
	}

	public PrettyPrintWriter notab() {
		return( new PrettyPrintWriter(this, "", "", "") );
	}

	public PrettyPrintWriter itab2() {
		return( new PrettyPrintWriter(this, TAB2, iTAB, EOL) );
	}

	public PrettyPrintWriter itab2(final String eol) {
		return( new PrettyPrintWriter(this, TAB2, iTAB, eol) );
	}


	public PrettyPrintWriter itab3() {
		return( new PrettyPrintWriter(this, TAB3, iTAB, EOL) );
	}

	public PrettyPrintWriter itab4() {
		return( new PrettyPrintWriter(this, TAB4, iTAB, EOL) );
	}

	public PrettyPrintWriter itab5() {
		return( new PrettyPrintWriter(this, TAB5, iTAB, EOL) );
	}

	public PrettyPrintWriter itab(final int count) {
		return( new PrettyPrintWriter(this, tab(count), iTAB, EOL) );
	}


	////////////////////////////////////////////////////////////////////////////
	// append STRING
	////////////////////////////////////////////////////////////////////////////

	@Override
	public PrettyPrintWriter append(final char c) {
		super.append( c );

		return this;
	}

	public PrettyPrintWriter append(final String str) {
		super.append( str );

		return this;
	}

	public PrettyPrintWriter append(final boolean value) {
		super.print(value);

		return this;
	}

	public PrettyPrintWriter append(final int value) {
		super.print(value);

		return this;
	}

	public PrettyPrintWriter append(final float value) {
		super.print(value);

		return this;
	}

	public PrettyPrintWriter append(final double value) {
		super.print(value);

		return this;
	}


	////////////////////////////////////////////////////////////////////////////
	// append TAB & STRING
	////////////////////////////////////////////////////////////////////////////

	public PrettyPrintWriter appendTab() {
		super.append( TAB1 );

		return this;
	}

	public PrettyPrintWriter appendTab(final String str) {
		super.append( TAB1 ).append( str );

		return this;
	}

	public PrettyPrintWriter appendTabEol(final String str) {
		super.append( TAB1 ).append( str ).append( EOL );

		return this;
	}

	public PrettyPrintWriter appendTabEol(final char c) {
		super.append( TAB1 ).append( c ).append( EOL );

		return this;
	}

	public PrettyPrintWriter appendTabEol2(final String str) {
		super.append( TAB1 ).append( str ).append( EOL2 );

		return this;
	}


	public PrettyPrintWriter appendEol_Eol(final String str) {
		super.append( EOL ).append( str ).append( EOL );

		return this;
	}

	public PrettyPrintWriter appendEol_Eol2(final String str) {
		super.append( EOL ).append( str ).append( EOL2 );

		return this;
	}

	public PrettyPrintWriter appendEolTab(final String str) {
		super.append( EOL ).append( TAB1 ).append( str );

		return this;
	}

	public PrettyPrintWriter appendEolTab2(final String str) {
		super.append( EOL ).append( TAB2 ).append( str );

		return this;
	}

	public PrettyPrintWriter appendEolTab_Eol(final String str) {
		super.append( EOL ).append( TAB1 ).append( str ).append( EOL );

		return this;
	}


	////////////////////////////////////////////////////////////////////////////
	// append TAB & COMMENT LINE
	////////////////////////////////////////////////////////////////////////////

	public PrettyPrintWriter commentLine(final String str) {
		if( str != null ) {
			for( final String line : str.split("\\R") ) {
				this.appendTab( "// " ).appendEol( line );
			}
		}

		return this;
	}

	public PrettyPrintWriter commentLine(final Object object) {
		if( object != null ) {
			for( final String line : object.toString().split("\\R") ) {
				this.appendTab( "// " ).appendEol( line );
			}
		}

		return this;
	}


	////////////////////////////////////////////////////////////////////////////
	// append TAB2 & STRING
	////////////////////////////////////////////////////////////////////////////

	public PrettyPrintWriter appendTab2() {
		super.append( TAB2 );

		return this;
	}

	public PrettyPrintWriter appendTab2(final String str) {
		super.append( TAB2 ).append( str );

		return this;
	}

	public PrettyPrintWriter appendTab2Eol(final String str) {
		super.append( TAB2 ).append( str ).append( EOL );

		return this;
	}

	public PrettyPrintWriter appendTab2Eol(final char c) {
		super.append( TAB2 ).append( c ).append( EOL );

		return this;
	}

	public PrettyPrintWriter appendTab2Eol2(final String str) {
		super.append( TAB2 ).append( str ).append( EOL2 );

		return this;
	}


	////////////////////////////////////////////////////////////////////////////
	// append TAB3 & STRING
	////////////////////////////////////////////////////////////////////////////

	public PrettyPrintWriter appendTab3() {
		super.append( TAB3 );

		return this;
	}

	public PrettyPrintWriter appendTab3(final String str) {
		super.append( TAB3 ).append( str );

		return this;
	}

	public PrettyPrintWriter appendTab3Eol(final String str) {
		super.append( TAB3 ).append( str ).append( EOL );

		return this;
	}

	public PrettyPrintWriter appendTab3Eol2(final String str) {
		super.append( TAB3 ).append( str ).append( EOL2 );

		return this;
	}


	////////////////////////////////////////////////////////////////////////////
	// append STRING & EOL
	////////////////////////////////////////////////////////////////////////////

	public PrettyPrintWriter appendEol() {
		super.append( EOL );

		return this;
	}

	public PrettyPrintWriter appendEol(final String str) {
		super.append( str ).append( EOL );

		return this;
	}

	public PrettyPrintWriter appendEol(final char c) {
		super.print( c );
		super.append( EOL );

		return this;
	}

	public PrettyPrintWriter appendEol(final long value) {
		super.print( value );
		super.append( EOL );

		return this;
	}

	public PrettyPrintWriter appendEol(final boolean value) {
		super.print( value );
		super.append( EOL );

		return this;
	}


	public PrettyPrintWriter appendEol2() {
		super.append( EOL2 );

		return this;
	}

	public PrettyPrintWriter appendEol2(final String str) {
		super.append( str ).append( EOL2 );

		return this;
	}

	public PrettyPrintWriter appendEol2(final char c) {
		super.append( c ).append( EOL2 );

		return this;
	}


}
