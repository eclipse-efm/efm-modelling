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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage
 * @generated
 */
public interface StatementFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatementFactory eINSTANCE = org.eclipse.efm.ecore.formalml.statement.impl.StatementFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Statement</em>'.
	 * @generated
	 */
	BlockStatement createBlockStatement();

	/**
	 * Returns a new object of class '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Statement</em>'.
	 * @generated
	 */
	ExpressionStatement createExpressionStatement();

	/**
	 * Returns a new object of class '<em>Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Statement</em>'.
	 * @generated
	 */
	GuardStatement createGuardStatement();

	/**
	 * Returns a new object of class '<em>Timed Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Guard Statement</em>'.
	 * @generated
	 */
	TimedGuardStatement createTimedGuardStatement();

	/**
	 * Returns a new object of class '<em>Event Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Guard Statement</em>'.
	 * @generated
	 */
	EventGuardStatement createEventGuardStatement();

	/**
	 * Returns a new object of class '<em>Check Sat Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Sat Guard Statement</em>'.
	 * @generated
	 */
	CheckSatGuardStatement createCheckSatGuardStatement();

	/**
	 * Returns a new object of class '<em>Input Com Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Com Statement</em>'.
	 * @generated
	 */
	InputComStatement createInputComStatement();

	/**
	 * Returns a new object of class '<em>Output Com Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Com Statement</em>'.
	 * @generated
	 */
	OutputComStatement createOutputComStatement();

	/**
	 * Returns a new object of class '<em>Conditional Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Block Statement</em>'.
	 * @generated
	 */
	ConditionalBlockStatement createConditionalBlockStatement();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>While Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Do Statement</em>'.
	 * @generated
	 */
	WhileDoStatement createWhileDoStatement();

	/**
	 * Returns a new object of class '<em>Do While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Do While Statement</em>'.
	 * @generated
	 */
	DoWhileStatement createDoWhileStatement();

	/**
	 * Returns a new object of class '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Statement</em>'.
	 * @generated
	 */
	ForStatement createForStatement();

	/**
	 * Returns a new object of class '<em>For Each Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Statement</em>'.
	 * @generated
	 */
	ForEachStatement createForEachStatement();

	/**
	 * Returns a new object of class '<em>Interrupt Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interrupt Statement</em>'.
	 * @generated
	 */
	InterruptStatement createInterruptStatement();

	/**
	 * Returns a new object of class '<em>Activity Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Statement</em>'.
	 * @generated
	 */
	ActivityStatement createActivityStatement();

	/**
	 * Returns a new object of class '<em>Invoke Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Statement</em>'.
	 * @generated
	 */
	InvokeStatement createInvokeStatement();

	/**
	 * Returns a new object of class '<em>Observer Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Observer Statement</em>'.
	 * @generated
	 */
	ObserverStatement createObserverStatement();

	/**
	 * Returns a new object of class '<em>Meta Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Statement</em>'.
	 * @generated
	 */
	MetaStatement createMetaStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StatementPackage getStatementPackage();

} //StatementFactory
