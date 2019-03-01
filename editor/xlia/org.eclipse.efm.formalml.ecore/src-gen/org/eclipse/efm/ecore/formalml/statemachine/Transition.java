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
package org.eclipse.efm.ecore.formalml.statemachine;

import org.eclipse.efm.ecore.formalml.common.NamedElement;

import org.eclipse.efm.ecore.formalml.expression.Expression;

import org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.InputComStatement;
import org.eclipse.efm.ecore.formalml.statement.Statement;
import org.eclipse.efm.ecore.formalml.statement.TimedGuardStatement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getMoe <em>Moe</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getTguard <em>Tguard</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getEffect <em>Effect</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getTargetExpression <em>Target Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient</em>' attribute.
	 * @see #setTransient(boolean)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_Transient()
	 * @model required="true"
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#isTransient <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Moe</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moe</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moe</em>' containment reference.
	 * @see #setMoe(TransitionMoe)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_Moe()
	 * @model containment="true"
	 * @generated
	 */
	TransitionMoe getMoe();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getMoe <em>Moe</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moe</em>' containment reference.
	 * @see #getMoe()
	 * @generated
	 */
	void setMoe(TransitionMoe value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Vertex)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_Target()
	 * @model resolveProxies="false"
	 * @generated
	 */
	Vertex getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Vertex value);

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference.
	 * @see #setBehavior(BlockStatement)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_Behavior()
	 * @model containment="true"
	 * @generated
	 */
	BlockStatement getBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getBehavior <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' containment reference.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(BlockStatement value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.statement.InputComStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_Trigger()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputComStatement> getTrigger();

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(AbstractGuardStatement)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_Guard()
	 * @model containment="true"
	 * @generated
	 */
	AbstractGuardStatement getGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(AbstractGuardStatement value);

	/**
	 * Returns the value of the '<em><b>Tguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tguard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tguard</em>' containment reference.
	 * @see #setTguard(TimedGuardStatement)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_Tguard()
	 * @model containment="true"
	 * @generated
	 */
	TimedGuardStatement getTguard();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getTguard <em>Tguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tguard</em>' containment reference.
	 * @see #getTguard()
	 * @generated
	 */
	void setTguard(TimedGuardStatement value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect</em>' containment reference.
	 * @see #setEffect(Statement)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_Effect()
	 * @model containment="true"
	 * @generated
	 */
	Statement getEffect();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getEffect <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' containment reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(Statement value);

	/**
	 * Returns the value of the '<em><b>Target Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Expression</em>' containment reference.
	 * @see #setTargetExpression(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage#getTransition_TargetExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTargetExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statemachine.Transition#getTargetExpression <em>Target Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Expression</em>' containment reference.
	 * @see #getTargetExpression()
	 * @generated
	 */
	void setTargetExpression(Expression value);

} // Transition
