/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.ecore.sew.expression;

import org.eclipse.efm.ecore.sew.WValueSpecification;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Array Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.sew.expression.LiteralArrayValue#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.sew.expression.ExpressionPackage#getLiteralArrayValue()
 * @model
 * @generated
 */
public interface LiteralArrayValue extends LiteralExpressionValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.sew.WValueSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.sew.expression.ExpressionPackage#getLiteralArrayValue_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<WValueSpecification> getValues();

} // LiteralArrayValue
