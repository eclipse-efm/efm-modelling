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

import org.eclipse.efm.ecore.formalml.common.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Reference Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getArg <em>Arg</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralReferenceElement()
 * @model
 * @generated
 */
public interface LiteralReferenceElement extends LiteralReferenceExpression {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"field"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
	 * @see #setKind(ValueElementSpecificationKind)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralReferenceElement_Kind()
	 * @model default="field" required="true"
	 * @generated
	 */
	ValueElementSpecificationKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ValueElementSpecificationKind value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(NamedElement)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralReferenceElement_Element()
	 * @model
	 * @generated
	 */
	NamedElement getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Arg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arg</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arg</em>' containment reference.
	 * @see #setArg(Expression)
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#getLiteralReferenceElement_Arg()
	 * @model containment="true"
	 * @generated
	 */
	Expression getArg();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getArg <em>Arg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arg</em>' containment reference.
	 * @see #getArg()
	 * @generated
	 */
	void setArg(Expression value);

} // LiteralReferenceElement
