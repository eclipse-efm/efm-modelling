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
package org.eclipse.efm.ecore.formalml.statement.util;

import org.eclipse.efm.ecore.formalml.common.AbstractElement;

import org.eclipse.efm.ecore.formalml.statement.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage
 * @generated
 */
public class StatementSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StatementPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementSwitch() {
		if (modelPackage == null) {
			modelPackage = StatementPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StatementPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseAbstractElement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.BLOCK_STATEMENT: {
				BlockStatement blockStatement = (BlockStatement)theEObject;
				T result = caseBlockStatement(blockStatement);
				if (result == null) result = caseStatement(blockStatement);
				if (result == null) result = caseAbstractElement(blockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.EXPRESSION_STATEMENT: {
				ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
				T result = caseExpressionStatement(expressionStatement);
				if (result == null) result = caseStatement(expressionStatement);
				if (result == null) result = caseAbstractElement(expressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.ABSTRACT_GUARD_STATEMENT: {
				AbstractGuardStatement abstractGuardStatement = (AbstractGuardStatement)theEObject;
				T result = caseAbstractGuardStatement(abstractGuardStatement);
				if (result == null) result = caseStatement(abstractGuardStatement);
				if (result == null) result = caseAbstractElement(abstractGuardStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.GUARD_STATEMENT: {
				GuardStatement guardStatement = (GuardStatement)theEObject;
				T result = caseGuardStatement(guardStatement);
				if (result == null) result = caseAbstractGuardStatement(guardStatement);
				if (result == null) result = caseStatement(guardStatement);
				if (result == null) result = caseAbstractElement(guardStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.TIMED_GUARD_STATEMENT: {
				TimedGuardStatement timedGuardStatement = (TimedGuardStatement)theEObject;
				T result = caseTimedGuardStatement(timedGuardStatement);
				if (result == null) result = caseAbstractGuardStatement(timedGuardStatement);
				if (result == null) result = caseStatement(timedGuardStatement);
				if (result == null) result = caseAbstractElement(timedGuardStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.EVENT_GUARD_STATEMENT: {
				EventGuardStatement eventGuardStatement = (EventGuardStatement)theEObject;
				T result = caseEventGuardStatement(eventGuardStatement);
				if (result == null) result = caseAbstractGuardStatement(eventGuardStatement);
				if (result == null) result = caseStatement(eventGuardStatement);
				if (result == null) result = caseAbstractElement(eventGuardStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.CHECK_SAT_GUARD_STATEMENT: {
				CheckSatGuardStatement checkSatGuardStatement = (CheckSatGuardStatement)theEObject;
				T result = caseCheckSatGuardStatement(checkSatGuardStatement);
				if (result == null) result = caseAbstractGuardStatement(checkSatGuardStatement);
				if (result == null) result = caseStatement(checkSatGuardStatement);
				if (result == null) result = caseAbstractElement(checkSatGuardStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.ABSTRACT_COM_STATEMENT: {
				AbstractComStatement abstractComStatement = (AbstractComStatement)theEObject;
				T result = caseAbstractComStatement(abstractComStatement);
				if (result == null) result = caseStatement(abstractComStatement);
				if (result == null) result = caseAbstractElement(abstractComStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.INPUT_COM_STATEMENT: {
				InputComStatement inputComStatement = (InputComStatement)theEObject;
				T result = caseInputComStatement(inputComStatement);
				if (result == null) result = caseAbstractComStatement(inputComStatement);
				if (result == null) result = caseStatement(inputComStatement);
				if (result == null) result = caseAbstractElement(inputComStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.OUTPUT_COM_STATEMENT: {
				OutputComStatement outputComStatement = (OutputComStatement)theEObject;
				T result = caseOutputComStatement(outputComStatement);
				if (result == null) result = caseAbstractComStatement(outputComStatement);
				if (result == null) result = caseStatement(outputComStatement);
				if (result == null) result = caseAbstractElement(outputComStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT: {
				ConditionalBlockStatement conditionalBlockStatement = (ConditionalBlockStatement)theEObject;
				T result = caseConditionalBlockStatement(conditionalBlockStatement);
				if (result == null) result = caseStatement(conditionalBlockStatement);
				if (result == null) result = caseAbstractElement(conditionalBlockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseConditionalBlockStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = caseAbstractElement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.WHILE_DO_STATEMENT: {
				WhileDoStatement whileDoStatement = (WhileDoStatement)theEObject;
				T result = caseWhileDoStatement(whileDoStatement);
				if (result == null) result = caseConditionalBlockStatement(whileDoStatement);
				if (result == null) result = caseStatement(whileDoStatement);
				if (result == null) result = caseAbstractElement(whileDoStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.DO_WHILE_STATEMENT: {
				DoWhileStatement doWhileStatement = (DoWhileStatement)theEObject;
				T result = caseDoWhileStatement(doWhileStatement);
				if (result == null) result = caseConditionalBlockStatement(doWhileStatement);
				if (result == null) result = caseStatement(doWhileStatement);
				if (result == null) result = caseAbstractElement(doWhileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseConditionalBlockStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = caseAbstractElement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.FOR_EACH_STATEMENT: {
				ForEachStatement forEachStatement = (ForEachStatement)theEObject;
				T result = caseForEachStatement(forEachStatement);
				if (result == null) result = caseConditionalBlockStatement(forEachStatement);
				if (result == null) result = caseStatement(forEachStatement);
				if (result == null) result = caseAbstractElement(forEachStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.INTERRUPT_STATEMENT: {
				InterruptStatement interruptStatement = (InterruptStatement)theEObject;
				T result = caseInterruptStatement(interruptStatement);
				if (result == null) result = caseStatement(interruptStatement);
				if (result == null) result = caseAbstractElement(interruptStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.ACTIVITY_STATEMENT: {
				ActivityStatement activityStatement = (ActivityStatement)theEObject;
				T result = caseActivityStatement(activityStatement);
				if (result == null) result = caseStatement(activityStatement);
				if (result == null) result = caseAbstractElement(activityStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.INVOKE_STATEMENT: {
				InvokeStatement invokeStatement = (InvokeStatement)theEObject;
				T result = caseInvokeStatement(invokeStatement);
				if (result == null) result = caseStatement(invokeStatement);
				if (result == null) result = caseAbstractElement(invokeStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockStatement(BlockStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatement(ExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Guard Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractGuardStatement(AbstractGuardStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardStatement(GuardStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timed Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timed Guard Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimedGuardStatement(TimedGuardStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Guard Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventGuardStatement(EventGuardStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check Sat Guard Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check Sat Guard Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckSatGuardStatement(CheckSatGuardStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Com Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Com Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractComStatement(AbstractComStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Com Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Com Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputComStatement(InputComStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Com Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Com Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputComStatement(OutputComStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Block Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalBlockStatement(ConditionalBlockStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Do Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileDoStatement(WhileDoStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Do While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Do While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoWhileStatement(DoWhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachStatement(ForEachStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interrupt Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interrupt Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterruptStatement(InterruptStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityStatement(ActivityStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeStatement(InvokeStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractElement(AbstractElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //StatementSwitch
