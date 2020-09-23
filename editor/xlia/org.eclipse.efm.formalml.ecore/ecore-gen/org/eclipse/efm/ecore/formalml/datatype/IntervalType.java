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
package org.eclipse.efm.ecore.formalml.datatype;

import org.eclipse.efm.ecore.formalml.expression.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#isLopen <em>Lopen</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#isRopen <em>Ropen</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#getInfimum <em>Infimum</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#getSupremum <em>Supremum</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getIntervalType()
 * @model
 * @generated
 */
public interface IntervalType extends DataSupportedType {
	/**
	 * Returns the value of the '<em><b>Lopen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lopen</em>' attribute.
	 * @see #setLopen(boolean)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getIntervalType_Lopen()
	 * @model required="true"
	 * @generated
	 */
	boolean isLopen();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#isLopen <em>Lopen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lopen</em>' attribute.
	 * @see #isLopen()
	 * @generated
	 */
	void setLopen(boolean value);

	/**
	 * Returns the value of the '<em><b>Ropen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ropen</em>' attribute.
	 * @see #setRopen(boolean)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getIntervalType_Ropen()
	 * @model required="true"
	 * @generated
	 */
	boolean isRopen();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#isRopen <em>Ropen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ropen</em>' attribute.
	 * @see #isRopen()
	 * @generated
	 */
	void setRopen(boolean value);

	/**
	 * Returns the value of the '<em><b>Infimum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infimum</em>' containment reference.
	 * @see #setInfimum(Expression)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getIntervalType_Infimum()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getInfimum();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#getInfimum <em>Infimum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infimum</em>' containment reference.
	 * @see #getInfimum()
	 * @generated
	 */
	void setInfimum(Expression value);

	/**
	 * Returns the value of the '<em><b>Supremum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supremum</em>' containment reference.
	 * @see #setSupremum(Expression)
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#getIntervalType_Supremum()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getSupremum();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#getSupremum <em>Supremum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supremum</em>' containment reference.
	 * @see #getSupremum()
	 * @generated
	 */
	void setSupremum(Expression value);

} // IntervalType
