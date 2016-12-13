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
package org.eclipse.efm.ecore.formalml.infrastructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#isConst <em>Const</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#isMacro <em>Macro</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#getOnWriteAction <em>On Write Action</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends PropertyDefinition {
	/**
	 * Returns the value of the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const</em>' attribute.
	 * @see #setConst(boolean)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getVariable_Const()
	 * @model required="true"
	 * @generated
	 */
	boolean isConst();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#isConst <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const</em>' attribute.
	 * @see #isConst()
	 * @generated
	 */
	void setConst(boolean value);

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
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getVariable_Macro()
	 * @model required="true"
	 * @generated
	 */
	boolean isMacro();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#isMacro <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Macro</em>' attribute.
	 * @see #isMacro()
	 * @generated
	 */
	void setMacro(boolean value);

	/**
	 * Returns the value of the '<em><b>On Write Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Write Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Write Action</em>' containment reference.
	 * @see #setOnWriteAction(Routine)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getVariable_OnWriteAction()
	 * @model containment="true"
	 * @generated
	 */
	Routine getOnWriteAction();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#getOnWriteAction <em>On Write Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Write Action</em>' containment reference.
	 * @see #getOnWriteAction()
	 * @generated
	 */
	void setOnWriteAction(Routine value);

} // Variable
