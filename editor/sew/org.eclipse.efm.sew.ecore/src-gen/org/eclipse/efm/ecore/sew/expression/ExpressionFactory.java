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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.sew.expression.ExpressionPackage
 * @generated
 */
public interface ExpressionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionFactory eINSTANCE = org.eclipse.efm.ecore.sew.expression.impl.ExpressionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>Literal Expression Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Expression Value</em>'.
	 * @generated
	 */
	LiteralExpressionValue createLiteralExpressionValue();

	/**
	 * Returns a new object of class '<em>Literal Array Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Array Value</em>'.
	 * @generated
	 */
	LiteralArrayValue createLiteralArrayValue();

	/**
	 * Returns a new object of class '<em>Literal Integer Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Integer Value</em>'.
	 * @generated
	 */
	LiteralIntegerValue createLiteralIntegerValue();

	/**
	 * Returns a new object of class '<em>Literal Boolean Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Boolean Value</em>'.
	 * @generated
	 */
	LiteralBooleanValue createLiteralBooleanValue();

	/**
	 * Returns a new object of class '<em>Literal Character Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Character Value</em>'.
	 * @generated
	 */
	LiteralCharacterValue createLiteralCharacterValue();

	/**
	 * Returns a new object of class '<em>Literal Rational Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Rational Value</em>'.
	 * @generated
	 */
	LiteralRationalValue createLiteralRationalValue();

	/**
	 * Returns a new object of class '<em>Literal String Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal String Value</em>'.
	 * @generated
	 */
	LiteralStringValue createLiteralStringValue();

	/**
	 * Returns a new object of class '<em>Literal Null Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Null Value</em>'.
	 * @generated
	 */
	LiteralNullValue createLiteralNullValue();

	/**
	 * Returns a new object of class '<em>Literal Float Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Float Value</em>'.
	 * @generated
	 */
	LiteralFloatValue createLiteralFloatValue();

	/**
	 * Returns a new object of class '<em>Literal Real Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Real Value</em>'.
	 * @generated
	 */
	LiteralRealValue createLiteralRealValue();

	/**
	 * Returns a new object of class '<em>Literal Reference Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Reference Value</em>'.
	 * @generated
	 */
	LiteralReferenceValue createLiteralReferenceValue();

	/**
	 * Returns a new object of class '<em>Literal Object Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Object Reference</em>'.
	 * @generated
	 */
	LiteralObjectReference createLiteralObjectReference();

	/**
	 * Returns a new object of class '<em>Literal This Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal This Instance</em>'.
	 * @generated
	 */
	LiteralThisInstance createLiteralThisInstance();

	/**
	 * Returns a new object of class '<em>Literal Self Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Self Instance</em>'.
	 * @generated
	 */
	LiteralSelfInstance createLiteralSelfInstance();

	/**
	 * Returns a new object of class '<em>Literal Parent Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Parent Instance</em>'.
	 * @generated
	 */
	LiteralParentInstance createLiteralParentInstance();

	/**
	 * Returns a new object of class '<em>Literal Super Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Super Instance</em>'.
	 * @generated
	 */
	LiteralSuperInstance createLiteralSuperInstance();

	/**
	 * Returns a new object of class '<em>Literal System Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal System Instance</em>'.
	 * @generated
	 */
	LiteralSystemInstance createLiteralSystemInstance();

	/**
	 * Returns a new object of class '<em>Literal Env Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Env Instance</em>'.
	 * @generated
	 */
	LiteralEnvInstance createLiteralEnvInstance();

	/**
	 * Returns a new object of class '<em>Literal Time Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Time Variable</em>'.
	 * @generated
	 */
	LiteralTimeVariable createLiteralTimeVariable();

	/**
	 * Returns a new object of class '<em>Literal Time Delta Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Time Delta Variable</em>'.
	 * @generated
	 */
	LiteralTimeDeltaVariable createLiteralTimeDeltaVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionPackage getExpressionPackage();

} //ExpressionFactory
