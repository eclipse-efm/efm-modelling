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
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.statement;

import org.eclipse.efm.ecore.formalml.common.NamedElement;

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.infrastructure.Channel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Com Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getRoute <em>Route</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAbstractComStatement()
 * @model abstract="true"
 * @generated
 */
public interface AbstractComStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(NamedElement)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAbstractComStatement_Port()
	 * @model
	 * @generated
	 */
	NamedElement getPort();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Route</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Route</em>' reference.
	 * @see #setRoute(Channel)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAbstractComStatement_Route()
	 * @model resolveProxies="false"
	 * @generated
	 */
	Channel getRoute();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getRoute <em>Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route</em>' reference.
	 * @see #getRoute()
	 * @generated
	 */
	void setRoute(Channel value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getAbstractComStatement_Target()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

} // AbstractComStatement
