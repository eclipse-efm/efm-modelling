/**
 * Copyright (c) 2020 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html\n\nContributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.statement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Assignment Statementkind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAssignmentStatementkind()
 * @model
 * @generated
 */
public enum AssignmentStatementkind implements Enumerator {
	/**
	 * The '<em><b>Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	ASSIGN(0, "assign", "assign"),

	/**
	 * The '<em><b>Assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	ASSIGN_AFTER(1, "assign_after", "assign_after"),

	/**
	 * The '<em><b>Assign ref</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_REF_VALUE
	 * @generated
	 * @ordered
	 */
	ASSIGN_REF(2, "assign_ref", "assign_ref"),

	/**
	 * The '<em><b>Assign macro</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_MACRO_VALUE
	 * @generated
	 * @ordered
	 */
	ASSIGN_MACRO(3, "assign_macro", "assign_macro"),

	/**
	 * The '<em><b>Plus assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLUS_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	PLUS_ASSIGN(4, "plus_assign", "plus_assign"),

	/**
	 * The '<em><b>Plus assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLUS_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	PLUS_ASSIGN_AFTER(5, "plus_assign_after", "plus_assign_after"),

	/**
	 * The '<em><b>Minus assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUS_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	MINUS_ASSIGN(6, "minus_assign", "minus_assign"),

	/**
	 * The '<em><b>Minus assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUS_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	MINUS_ASSIGN_AFTER(7, "minus_assign_after", "minus_assign_after"),

	/**
	 * The '<em><b>Star assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STAR_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	STAR_ASSIGN(8, "star_assign", "star_assign"),

	/**
	 * The '<em><b>Star assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STAR_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	STAR_ASSIGN_AFTER(9, "star_assign_after", "star_assign_after"),

	/**
	 * The '<em><b>Div assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIV_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	DIV_ASSIGN_AFTER(10, "div_assign_after", "div_assign_after"),

	/**
	 * The '<em><b>Div assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIV_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	DIV_ASSIGN(11, "div_assign", "div_assign"),

	/**
	 * The '<em><b>Mod assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOD_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	MOD_ASSIGN_AFTER(12, "mod_assign_after", "mod_assign_after"),

	/**
	 * The '<em><b>Mod assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOD_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	MOD_ASSIGN(13, "mod_assign", "mod_assign"),

	/**
	 * The '<em><b>Land assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAND_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	LAND_ASSIGN_AFTER(14, "land_assign_after", "land_assign_after"),

	/**
	 * The '<em><b>Land assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAND_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	LAND_ASSIGN(15, "land_assign", "land_assign"),

	/**
	 * The '<em><b>Lor assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOR_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	LOR_ASSIGN_AFTER(16, "lor_assign_after", "lor_assign_after"),

	/**
	 * The '<em><b>Lor assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOR_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	LOR_ASSIGN(17, "lor_assign", "lor_assign"),

	/**
	 * The '<em><b>Band assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BAND_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	BAND_ASSIGN_AFTER(18, "band_assign_after", "band_assign_after"),

	/**
	 * The '<em><b>Band assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BAND_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	BAND_ASSIGN(19, "band_assign", "band_assign"),

	/**
	 * The '<em><b>Bor assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOR_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	BOR_ASSIGN_AFTER(20, "bor_assign_after", "bor_assign_after"),

	/**
	 * The '<em><b>Bor assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOR_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	BOR_ASSIGN(21, "bor_assign", "bor_assign"),

	/**
	 * The '<em><b>Bxor assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BXOR_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	BXOR_ASSIGN_AFTER(22, "bxor_assign_after", "bxor_assign_after"),

	/**
	 * The '<em><b>Bxor assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BXOR_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	BXOR_ASSIGN(23, "bxor_assign", "bxor_assign"),

	/**
	 * The '<em><b>Lshift assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LSHIFT_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	LSHIFT_ASSIGN_AFTER(24, "lshift_assign_after", "lshift_assign_after"),

	/**
	 * The '<em><b>Lshift assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LSHIFT_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	LSHIFT_ASSIGN(25, "lshift_assign", "lshift_assign"),

	/**
	 * The '<em><b>Rshift assign after</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RSHIFT_ASSIGN_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
	RSHIFT_ASSIGN_AFTER(26, "rshift_assign_after", "rshift_assign_after"),

	/**
	 * The '<em><b>Rshift assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RSHIFT_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	RSHIFT_ASSIGN(27, "rshift_assign", "rshift_assign"),

	/**
	 * The '<em><b>Op push</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_PUSH_VALUE
	 * @generated
	 * @ordered
	 */
	OP_PUSH(28, "op_push", "op_push"),

	/**
	 * The '<em><b>Op assign top</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_ASSIGN_TOP_VALUE
	 * @generated
	 * @ordered
	 */
	OP_ASSIGN_TOP(29, "op_assign_top", "op_assign_top"),

	/**
	 * The '<em><b>Op pop</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_POP_VALUE
	 * @generated
	 * @ordered
	 */
	OP_POP(30, "op_pop", "op_pop"),

	/**
	 * The '<em><b>Incr</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCR_VALUE
	 * @generated
	 * @ordered
	 */
	INCR(31, "incr", "incr"),

	/**
	 * The '<em><b>Decr</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECR_VALUE
	 * @generated
	 * @ordered
	 */
	DECR(32, "decr", "decr");

	/**
	 * The '<em><b>Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN
	 * @model name="assign"
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGN_VALUE = 0;

	/**
	 * The '<em><b>Assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_AFTER
	 * @model name="assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGN_AFTER_VALUE = 1;

	/**
	 * The '<em><b>Assign ref</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_REF
	 * @model name="assign_ref"
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGN_REF_VALUE = 2;

	/**
	 * The '<em><b>Assign macro</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_MACRO
	 * @model name="assign_macro"
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGN_MACRO_VALUE = 3;

	/**
	 * The '<em><b>Plus assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLUS_ASSIGN
	 * @model name="plus_assign"
	 * @generated
	 * @ordered
	 */
	public static final int PLUS_ASSIGN_VALUE = 4;

	/**
	 * The '<em><b>Plus assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLUS_ASSIGN_AFTER
	 * @model name="plus_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int PLUS_ASSIGN_AFTER_VALUE = 5;

	/**
	 * The '<em><b>Minus assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUS_ASSIGN
	 * @model name="minus_assign"
	 * @generated
	 * @ordered
	 */
	public static final int MINUS_ASSIGN_VALUE = 6;

	/**
	 * The '<em><b>Minus assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUS_ASSIGN_AFTER
	 * @model name="minus_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int MINUS_ASSIGN_AFTER_VALUE = 7;

	/**
	 * The '<em><b>Star assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STAR_ASSIGN
	 * @model name="star_assign"
	 * @generated
	 * @ordered
	 */
	public static final int STAR_ASSIGN_VALUE = 8;

	/**
	 * The '<em><b>Star assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STAR_ASSIGN_AFTER
	 * @model name="star_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int STAR_ASSIGN_AFTER_VALUE = 9;

	/**
	 * The '<em><b>Div assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIV_ASSIGN_AFTER
	 * @model name="div_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int DIV_ASSIGN_AFTER_VALUE = 10;

	/**
	 * The '<em><b>Div assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIV_ASSIGN
	 * @model name="div_assign"
	 * @generated
	 * @ordered
	 */
	public static final int DIV_ASSIGN_VALUE = 11;

	/**
	 * The '<em><b>Mod assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOD_ASSIGN_AFTER
	 * @model name="mod_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int MOD_ASSIGN_AFTER_VALUE = 12;

	/**
	 * The '<em><b>Mod assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOD_ASSIGN
	 * @model name="mod_assign"
	 * @generated
	 * @ordered
	 */
	public static final int MOD_ASSIGN_VALUE = 13;

	/**
	 * The '<em><b>Land assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAND_ASSIGN_AFTER
	 * @model name="land_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int LAND_ASSIGN_AFTER_VALUE = 14;

	/**
	 * The '<em><b>Land assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAND_ASSIGN
	 * @model name="land_assign"
	 * @generated
	 * @ordered
	 */
	public static final int LAND_ASSIGN_VALUE = 15;

	/**
	 * The '<em><b>Lor assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOR_ASSIGN_AFTER
	 * @model name="lor_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int LOR_ASSIGN_AFTER_VALUE = 16;

	/**
	 * The '<em><b>Lor assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOR_ASSIGN
	 * @model name="lor_assign"
	 * @generated
	 * @ordered
	 */
	public static final int LOR_ASSIGN_VALUE = 17;

	/**
	 * The '<em><b>Band assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BAND_ASSIGN_AFTER
	 * @model name="band_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int BAND_ASSIGN_AFTER_VALUE = 18;

	/**
	 * The '<em><b>Band assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BAND_ASSIGN
	 * @model name="band_assign"
	 * @generated
	 * @ordered
	 */
	public static final int BAND_ASSIGN_VALUE = 19;

	/**
	 * The '<em><b>Bor assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOR_ASSIGN_AFTER
	 * @model name="bor_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int BOR_ASSIGN_AFTER_VALUE = 20;

	/**
	 * The '<em><b>Bor assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOR_ASSIGN
	 * @model name="bor_assign"
	 * @generated
	 * @ordered
	 */
	public static final int BOR_ASSIGN_VALUE = 21;

	/**
	 * The '<em><b>Bxor assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BXOR_ASSIGN_AFTER
	 * @model name="bxor_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int BXOR_ASSIGN_AFTER_VALUE = 22;

	/**
	 * The '<em><b>Bxor assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BXOR_ASSIGN
	 * @model name="bxor_assign"
	 * @generated
	 * @ordered
	 */
	public static final int BXOR_ASSIGN_VALUE = 23;

	/**
	 * The '<em><b>Lshift assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LSHIFT_ASSIGN_AFTER
	 * @model name="lshift_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int LSHIFT_ASSIGN_AFTER_VALUE = 24;

	/**
	 * The '<em><b>Lshift assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LSHIFT_ASSIGN
	 * @model name="lshift_assign"
	 * @generated
	 * @ordered
	 */
	public static final int LSHIFT_ASSIGN_VALUE = 25;

	/**
	 * The '<em><b>Rshift assign after</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RSHIFT_ASSIGN_AFTER
	 * @model name="rshift_assign_after"
	 * @generated
	 * @ordered
	 */
	public static final int RSHIFT_ASSIGN_AFTER_VALUE = 26;

	/**
	 * The '<em><b>Rshift assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RSHIFT_ASSIGN
	 * @model name="rshift_assign"
	 * @generated
	 * @ordered
	 */
	public static final int RSHIFT_ASSIGN_VALUE = 27;

	/**
	 * The '<em><b>Op push</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_PUSH
	 * @model name="op_push"
	 * @generated
	 * @ordered
	 */
	public static final int OP_PUSH_VALUE = 28;

	/**
	 * The '<em><b>Op assign top</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_ASSIGN_TOP
	 * @model name="op_assign_top"
	 * @generated
	 * @ordered
	 */
	public static final int OP_ASSIGN_TOP_VALUE = 29;

	/**
	 * The '<em><b>Op pop</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_POP
	 * @model name="op_pop"
	 * @generated
	 * @ordered
	 */
	public static final int OP_POP_VALUE = 30;

	/**
	 * The '<em><b>Incr</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCR
	 * @model name="incr"
	 * @generated
	 * @ordered
	 */
	public static final int INCR_VALUE = 31;

	/**
	 * The '<em><b>Decr</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECR
	 * @model name="decr"
	 * @generated
	 * @ordered
	 */
	public static final int DECR_VALUE = 32;

	/**
	 * An array of all the '<em><b>Assignment Statementkind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AssignmentStatementkind[] VALUES_ARRAY =
		new AssignmentStatementkind[] {
			ASSIGN,
			ASSIGN_AFTER,
			ASSIGN_REF,
			ASSIGN_MACRO,
			PLUS_ASSIGN,
			PLUS_ASSIGN_AFTER,
			MINUS_ASSIGN,
			MINUS_ASSIGN_AFTER,
			STAR_ASSIGN,
			STAR_ASSIGN_AFTER,
			DIV_ASSIGN_AFTER,
			DIV_ASSIGN,
			MOD_ASSIGN_AFTER,
			MOD_ASSIGN,
			LAND_ASSIGN_AFTER,
			LAND_ASSIGN,
			LOR_ASSIGN_AFTER,
			LOR_ASSIGN,
			BAND_ASSIGN_AFTER,
			BAND_ASSIGN,
			BOR_ASSIGN_AFTER,
			BOR_ASSIGN,
			BXOR_ASSIGN_AFTER,
			BXOR_ASSIGN,
			LSHIFT_ASSIGN_AFTER,
			LSHIFT_ASSIGN,
			RSHIFT_ASSIGN_AFTER,
			RSHIFT_ASSIGN,
			OP_PUSH,
			OP_ASSIGN_TOP,
			OP_POP,
			INCR,
			DECR,
		};

	/**
	 * A public read-only list of all the '<em><b>Assignment Statementkind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AssignmentStatementkind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Assignment Statementkind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssignmentStatementkind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssignmentStatementkind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assignment Statementkind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssignmentStatementkind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssignmentStatementkind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assignment Statementkind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssignmentStatementkind get(int value) {
		switch (value) {
			case ASSIGN_VALUE: return ASSIGN;
			case ASSIGN_AFTER_VALUE: return ASSIGN_AFTER;
			case ASSIGN_REF_VALUE: return ASSIGN_REF;
			case ASSIGN_MACRO_VALUE: return ASSIGN_MACRO;
			case PLUS_ASSIGN_VALUE: return PLUS_ASSIGN;
			case PLUS_ASSIGN_AFTER_VALUE: return PLUS_ASSIGN_AFTER;
			case MINUS_ASSIGN_VALUE: return MINUS_ASSIGN;
			case MINUS_ASSIGN_AFTER_VALUE: return MINUS_ASSIGN_AFTER;
			case STAR_ASSIGN_VALUE: return STAR_ASSIGN;
			case STAR_ASSIGN_AFTER_VALUE: return STAR_ASSIGN_AFTER;
			case DIV_ASSIGN_AFTER_VALUE: return DIV_ASSIGN_AFTER;
			case DIV_ASSIGN_VALUE: return DIV_ASSIGN;
			case MOD_ASSIGN_AFTER_VALUE: return MOD_ASSIGN_AFTER;
			case MOD_ASSIGN_VALUE: return MOD_ASSIGN;
			case LAND_ASSIGN_AFTER_VALUE: return LAND_ASSIGN_AFTER;
			case LAND_ASSIGN_VALUE: return LAND_ASSIGN;
			case LOR_ASSIGN_AFTER_VALUE: return LOR_ASSIGN_AFTER;
			case LOR_ASSIGN_VALUE: return LOR_ASSIGN;
			case BAND_ASSIGN_AFTER_VALUE: return BAND_ASSIGN_AFTER;
			case BAND_ASSIGN_VALUE: return BAND_ASSIGN;
			case BOR_ASSIGN_AFTER_VALUE: return BOR_ASSIGN_AFTER;
			case BOR_ASSIGN_VALUE: return BOR_ASSIGN;
			case BXOR_ASSIGN_AFTER_VALUE: return BXOR_ASSIGN_AFTER;
			case BXOR_ASSIGN_VALUE: return BXOR_ASSIGN;
			case LSHIFT_ASSIGN_AFTER_VALUE: return LSHIFT_ASSIGN_AFTER;
			case LSHIFT_ASSIGN_VALUE: return LSHIFT_ASSIGN;
			case RSHIFT_ASSIGN_AFTER_VALUE: return RSHIFT_ASSIGN_AFTER;
			case RSHIFT_ASSIGN_VALUE: return RSHIFT_ASSIGN;
			case OP_PUSH_VALUE: return OP_PUSH;
			case OP_ASSIGN_TOP_VALUE: return OP_ASSIGN_TOP;
			case OP_POP_VALUE: return OP_POP;
			case INCR_VALUE: return INCR;
			case DECR_VALUE: return DECR;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AssignmentStatementkind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //AssignmentStatementkind
