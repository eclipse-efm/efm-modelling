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
package org.eclipse.efm.ecore.sew.expression.util;

import org.eclipse.efm.ecore.sew.WValueSpecification;

import org.eclipse.efm.ecore.sew.expression.*;

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
 * @see org.eclipse.efm.ecore.sew.expression.ExpressionPackage
 * @generated
 */
public class ExpressionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionPackage.eINSTANCE;
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
			case ExpressionPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseWValueSpecification(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_EXPRESSION_VALUE: {
				LiteralExpressionValue literalExpressionValue = (LiteralExpressionValue)theEObject;
				T result = caseLiteralExpressionValue(literalExpressionValue);
				if (result == null) result = caseWValueSpecification(literalExpressionValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_ARRAY_VALUE: {
				LiteralArrayValue literalArrayValue = (LiteralArrayValue)theEObject;
				T result = caseLiteralArrayValue(literalArrayValue);
				if (result == null) result = caseLiteralExpressionValue(literalArrayValue);
				if (result == null) result = caseWValueSpecification(literalArrayValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_INTEGER_VALUE: {
				LiteralIntegerValue literalIntegerValue = (LiteralIntegerValue)theEObject;
				T result = caseLiteralIntegerValue(literalIntegerValue);
				if (result == null) result = caseLiteralExpressionValue(literalIntegerValue);
				if (result == null) result = caseWValueSpecification(literalIntegerValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_BOOLEAN_VALUE: {
				LiteralBooleanValue literalBooleanValue = (LiteralBooleanValue)theEObject;
				T result = caseLiteralBooleanValue(literalBooleanValue);
				if (result == null) result = caseLiteralExpressionValue(literalBooleanValue);
				if (result == null) result = caseWValueSpecification(literalBooleanValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_CHARACTER_VALUE: {
				LiteralCharacterValue literalCharacterValue = (LiteralCharacterValue)theEObject;
				T result = caseLiteralCharacterValue(literalCharacterValue);
				if (result == null) result = caseLiteralExpressionValue(literalCharacterValue);
				if (result == null) result = caseWValueSpecification(literalCharacterValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_RATIONAL_VALUE: {
				LiteralRationalValue literalRationalValue = (LiteralRationalValue)theEObject;
				T result = caseLiteralRationalValue(literalRationalValue);
				if (result == null) result = caseLiteralExpressionValue(literalRationalValue);
				if (result == null) result = caseWValueSpecification(literalRationalValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_STRING_VALUE: {
				LiteralStringValue literalStringValue = (LiteralStringValue)theEObject;
				T result = caseLiteralStringValue(literalStringValue);
				if (result == null) result = caseLiteralExpressionValue(literalStringValue);
				if (result == null) result = caseWValueSpecification(literalStringValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_NULL_VALUE: {
				LiteralNullValue literalNullValue = (LiteralNullValue)theEObject;
				T result = caseLiteralNullValue(literalNullValue);
				if (result == null) result = caseLiteralExpressionValue(literalNullValue);
				if (result == null) result = caseWValueSpecification(literalNullValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_FLOAT_VALUE: {
				LiteralFloatValue literalFloatValue = (LiteralFloatValue)theEObject;
				T result = caseLiteralFloatValue(literalFloatValue);
				if (result == null) result = caseLiteralExpressionValue(literalFloatValue);
				if (result == null) result = caseWValueSpecification(literalFloatValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_REAL_VALUE: {
				LiteralRealValue literalRealValue = (LiteralRealValue)theEObject;
				T result = caseLiteralRealValue(literalRealValue);
				if (result == null) result = caseLiteralExpressionValue(literalRealValue);
				if (result == null) result = caseWValueSpecification(literalRealValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_REFERENCE_VALUE: {
				LiteralReferenceValue literalReferenceValue = (LiteralReferenceValue)theEObject;
				T result = caseLiteralReferenceValue(literalReferenceValue);
				if (result == null) result = caseLiteralExpressionValue(literalReferenceValue);
				if (result == null) result = caseWValueSpecification(literalReferenceValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_OBJECT_REFERENCE: {
				LiteralObjectReference literalObjectReference = (LiteralObjectReference)theEObject;
				T result = caseLiteralObjectReference(literalObjectReference);
				if (result == null) result = caseLiteralReferenceValue(literalObjectReference);
				if (result == null) result = caseLiteralExpressionValue(literalObjectReference);
				if (result == null) result = caseWValueSpecification(literalObjectReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_THIS_INSTANCE: {
				LiteralThisInstance literalThisInstance = (LiteralThisInstance)theEObject;
				T result = caseLiteralThisInstance(literalThisInstance);
				if (result == null) result = caseLiteralReferenceValue(literalThisInstance);
				if (result == null) result = caseLiteralExpressionValue(literalThisInstance);
				if (result == null) result = caseWValueSpecification(literalThisInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_SELF_INSTANCE: {
				LiteralSelfInstance literalSelfInstance = (LiteralSelfInstance)theEObject;
				T result = caseLiteralSelfInstance(literalSelfInstance);
				if (result == null) result = caseLiteralReferenceValue(literalSelfInstance);
				if (result == null) result = caseLiteralExpressionValue(literalSelfInstance);
				if (result == null) result = caseWValueSpecification(literalSelfInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_PARENT_INSTANCE: {
				LiteralParentInstance literalParentInstance = (LiteralParentInstance)theEObject;
				T result = caseLiteralParentInstance(literalParentInstance);
				if (result == null) result = caseLiteralReferenceValue(literalParentInstance);
				if (result == null) result = caseLiteralExpressionValue(literalParentInstance);
				if (result == null) result = caseWValueSpecification(literalParentInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_SUPER_INSTANCE: {
				LiteralSuperInstance literalSuperInstance = (LiteralSuperInstance)theEObject;
				T result = caseLiteralSuperInstance(literalSuperInstance);
				if (result == null) result = caseLiteralReferenceValue(literalSuperInstance);
				if (result == null) result = caseLiteralExpressionValue(literalSuperInstance);
				if (result == null) result = caseWValueSpecification(literalSuperInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_SYSTEM_INSTANCE: {
				LiteralSystemInstance literalSystemInstance = (LiteralSystemInstance)theEObject;
				T result = caseLiteralSystemInstance(literalSystemInstance);
				if (result == null) result = caseLiteralReferenceValue(literalSystemInstance);
				if (result == null) result = caseLiteralExpressionValue(literalSystemInstance);
				if (result == null) result = caseWValueSpecification(literalSystemInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_ENV_INSTANCE: {
				LiteralEnvInstance literalEnvInstance = (LiteralEnvInstance)theEObject;
				T result = caseLiteralEnvInstance(literalEnvInstance);
				if (result == null) result = caseLiteralReferenceValue(literalEnvInstance);
				if (result == null) result = caseLiteralExpressionValue(literalEnvInstance);
				if (result == null) result = caseWValueSpecification(literalEnvInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_TIME_VARIABLE: {
				LiteralTimeVariable literalTimeVariable = (LiteralTimeVariable)theEObject;
				T result = caseLiteralTimeVariable(literalTimeVariable);
				if (result == null) result = caseLiteralReferenceValue(literalTimeVariable);
				if (result == null) result = caseLiteralExpressionValue(literalTimeVariable);
				if (result == null) result = caseWValueSpecification(literalTimeVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LITERAL_TIME_DELTA_VARIABLE: {
				LiteralTimeDeltaVariable literalTimeDeltaVariable = (LiteralTimeDeltaVariable)theEObject;
				T result = caseLiteralTimeDeltaVariable(literalTimeDeltaVariable);
				if (result == null) result = caseLiteralReferenceValue(literalTimeDeltaVariable);
				if (result == null) result = caseLiteralExpressionValue(literalTimeDeltaVariable);
				if (result == null) result = caseWValueSpecification(literalTimeDeltaVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Expression Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Expression Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpressionValue(LiteralExpressionValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Array Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Array Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralArrayValue(LiteralArrayValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Integer Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Integer Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralIntegerValue(LiteralIntegerValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Boolean Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Boolean Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralBooleanValue(LiteralBooleanValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Character Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Character Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralCharacterValue(LiteralCharacterValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Rational Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Rational Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralRationalValue(LiteralRationalValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal String Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal String Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralStringValue(LiteralStringValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Null Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Null Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralNullValue(LiteralNullValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Float Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Float Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralFloatValue(LiteralFloatValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Real Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Real Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralRealValue(LiteralRealValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Reference Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Reference Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralReferenceValue(LiteralReferenceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Object Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Object Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralObjectReference(LiteralObjectReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal This Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal This Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralThisInstance(LiteralThisInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Self Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Self Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralSelfInstance(LiteralSelfInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Parent Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Parent Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralParentInstance(LiteralParentInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Super Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Super Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralSuperInstance(LiteralSuperInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal System Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal System Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralSystemInstance(LiteralSystemInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Env Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Env Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralEnvInstance(LiteralEnvInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Time Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Time Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralTimeVariable(LiteralTimeVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Time Delta Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Time Delta Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralTimeDeltaVariable(LiteralTimeDeltaVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WValue Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WValue Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWValueSpecification(WValueSpecification object) {
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

} //ExpressionSwitch
