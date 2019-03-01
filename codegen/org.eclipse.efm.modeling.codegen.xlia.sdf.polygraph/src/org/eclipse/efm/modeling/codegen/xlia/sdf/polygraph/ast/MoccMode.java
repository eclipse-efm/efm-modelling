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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.ast;

//public enum MoccMode implements Enumerator {
//
//	NOMINAL(0, "nominal" , "nominal"),
//
//	UNDEFINED(0, "undefined" , "undefined");
//
//	private MoccMode(final int value, final String name, final String literal) {
//		this.value = value;
//		this.name = name;
//		this.literal = literal;
//	}
//
//	private final String name;
//	private final int value;
//	private final String literal;
//
//	@Override
//	public String getName() {
//		return name;
//	}
//
//	@Override
//	public int getValue() {
//		return value;
//	}
//
//	@Override
//	public String getLiteral() {
//		return literal;
//	}
//
//	@Override
//	public String toString() {
//		return literal;
//	}
//
//}

public class MoccMode {

	private final String name;
	private final int value;
	private final String literal;

	protected MoccMode(final int value, final String name, final String literal) {
		this.value   = value;
		this.name    = name;
		this.literal = literal;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public String getLiteral() {
		return literal;
	}

	@Override
	public String toString() {
		return literal;
	}

}
