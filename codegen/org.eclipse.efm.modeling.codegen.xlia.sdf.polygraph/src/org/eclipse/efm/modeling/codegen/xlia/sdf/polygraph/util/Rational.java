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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.util;

public class Rational implements Comparable<Rational> {
//	private static Rational zero = new Rational(0, 1);

	public static int gcd(int m, int n) {
		if (0 == n) {
			return m;
		} else {
			return gcd(n, m % n);
		}
	}

	public static int lcm(int m, int n) {
		return m * (n / gcd(m, n));
	}

	private int denominator;

	private int numerator;

	public Rational(int numerator, int denominator) {

		int g = gcd(numerator, denominator);
		this.numerator = numerator / g;
		this.denominator = denominator / g;
		if (this.denominator < 0) {
			this.denominator = -this.denominator;
			this.numerator = -this.numerator;
		}
	}

	public int getDenominator() {
		return denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	@Override
	public int compareTo(Rational b) {
		Rational a = this;
		int lhs = a.numerator * b.denominator;
		int rhs = a.denominator * b.numerator;
		if (lhs < rhs)
			return -1;
		if (lhs > rhs)
			return +1;
		return 0;
	}

	@Override
	public boolean equals(Object y) {
		if (y == null)
			return false;
		if (y.getClass() != this.getClass())
			return false;
		Rational b = (Rational) y;
		return compareTo(b) == 0;
	}

//	// return a / b
//	public Rational div(Rational b) {
//		return this.mul(b.reciprocal());
//	}
//
//	// return a - b
//	public Rational sub(Rational b) {
//		return this.add(b.negate());
//	}
//
//	// return -a
//	public Rational negate() {
//		return new Rational(-numerator, denominator);
//	}
//
//	public Rational add(Rational b) {
//		if (this.compareTo(zero) == 0) {
//			return b;
//		}
//		if (b.compareTo(zero) == 0) {
//			return this;
//		}
//
//		// Find gcd of numerators and denominators
//		int f = gcd(numerator, b.numerator);
//		int g = gcd(denominator, b.denominator);
//
//		// add cross-product terms for numerator
//		Rational s = new Rational((numerator / f) * (b.denominator / g)
//				+ (b.numerator / f) * (denominator / g), lcm(denominator,
//				b.denominator));
//
//		// multiply back in
//		s.numerator *= f;
//		return s;
//	}
//
//	public Rational reciprocal() {
//		return new Rational(denominator, numerator);
//	}
//
	public Rational mul(Rational b) {
		Rational c = new Rational(numerator, b.denominator);
		Rational d = new Rational(b.numerator, denominator);
		return new Rational(c.numerator * d.numerator, c.denominator
				* d.denominator);
	}

//	public double toDouble() {
//		return (double) numerator / denominator;
//	}

	@Override
	public String toString() {
		if (denominator == 1)
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}
}
