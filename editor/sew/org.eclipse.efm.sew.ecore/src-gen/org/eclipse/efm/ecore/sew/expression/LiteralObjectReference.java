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

import org.eclipse.efm.ecore.sew.WObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Object Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.sew.expression.LiteralObjectReference#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.sew.expression.ExpressionPackage#getLiteralObjectReference()
 * @model
 * @generated
 */
public interface LiteralObjectReference extends LiteralReferenceValue {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(WObject)
	 * @see org.eclipse.efm.ecore.sew.expression.ExpressionPackage#getLiteralObjectReference_Object()
	 * @model
	 * @generated
	 */
	WObject getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.sew.expression.LiteralObjectReference#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(WObject value);

} // LiteralObjectReference
