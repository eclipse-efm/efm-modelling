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
package org.eclipse.efm.ecore.formalml.infrastructure;

import org.eclipse.efm.ecore.formalml.common.NamedElement;

import org.eclipse.efm.ecore.formalml.statement.BlockStatement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Routine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#isMacro <em>Macro</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getParameterSet <em>Parameter Set</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getBodyBlock <em>Body Block</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getRoutine()
 * @model
 * @generated
 */
public interface Routine extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Macro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Macro</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Macro</em>' attribute.
	 * @see #setMacro(boolean)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getRoutine_Macro()
	 * @model required="true"
	 * @generated
	 */
	boolean isMacro();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#isMacro <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Macro</em>' attribute.
	 * @see #isMacro()
	 * @generated
	 */
	void setMacro(boolean value);

	/**
	 * Returns the value of the '<em><b>Parameter Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Set</em>' containment reference.
	 * @see #setParameterSet(ParameterSet)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getRoutine_ParameterSet()
	 * @model containment="true"
	 * @generated
	 */
	ParameterSet getParameterSet();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getParameterSet <em>Parameter Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Set</em>' containment reference.
	 * @see #getParameterSet()
	 * @generated
	 */
	void setParameterSet(ParameterSet value);

	/**
	 * Returns the value of the '<em><b>Result Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Set</em>' containment reference.
	 * @see #setResultSet(ParameterSet)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getRoutine_ResultSet()
	 * @model containment="true"
	 * @generated
	 */
	ParameterSet getResultSet();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getResultSet <em>Result Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Set</em>' containment reference.
	 * @see #getResultSet()
	 * @generated
	 */
	void setResultSet(ParameterSet value);

	/**
	 * Returns the value of the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Block</em>' containment reference.
	 * @see #setBodyBlock(BlockStatement)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getRoutine_BodyBlock()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BlockStatement getBodyBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getBodyBlock <em>Body Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Block</em>' containment reference.
	 * @see #getBodyBlock()
	 * @generated
	 */
	void setBodyBlock(BlockStatement value);

} // Routine
