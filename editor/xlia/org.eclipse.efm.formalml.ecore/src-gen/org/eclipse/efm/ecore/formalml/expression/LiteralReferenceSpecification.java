/**
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
 */
package org.eclipse.efm.ecore.formalml.expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Reference Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getExpected <em>Expected</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralReferenceSpecification()
 * @model
 * @generated
 */
public interface LiteralReferenceSpecification extends Expression {
	/**
	 * Returns the value of the '<em><b>Expected</b></em>' attribute.
	 * The default value is <code>"any"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme
	 * @see #setExpected(ValueElementSpecificationScheme)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralReferenceSpecification_Expected()
	 * @model default="any" required="true"
	 * @generated
	 */
	ValueElementSpecificationScheme getExpected();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getExpected <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme
	 * @see #getExpected()
	 * @generated
	 */
	void setExpected(ValueElementSpecificationScheme value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralReferenceSpecification_Parent()
	 * @model containment="true"
	 * @generated
	 */
	EList<LiteralReferenceExpression> getParent();

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference.
	 * @see #setElement(LiteralReferenceExpression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralReferenceSpecification_Element()
	 * @model containment="true"
	 * @generated
	 */
	LiteralReferenceExpression getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(LiteralReferenceExpression value);

} // LiteralReferenceSpecification
