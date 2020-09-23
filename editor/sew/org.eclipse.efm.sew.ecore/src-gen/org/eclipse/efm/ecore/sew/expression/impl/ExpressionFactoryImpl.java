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
package org.eclipse.efm.ecore.sew.expression.impl;

import org.eclipse.efm.ecore.sew.expression.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionFactoryImpl extends EFactoryImpl implements ExpressionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionFactory init() {
		try {
			ExpressionFactory theExpressionFactory = (ExpressionFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionPackage.eNS_URI);
			if (theExpressionFactory != null) {
				return theExpressionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExpressionPackage.EXPRESSION: return createExpression();
			case ExpressionPackage.LITERAL_EXPRESSION_VALUE: return createLiteralExpressionValue();
			case ExpressionPackage.LITERAL_ARRAY_VALUE: return createLiteralArrayValue();
			case ExpressionPackage.LITERAL_INTEGER_VALUE: return createLiteralIntegerValue();
			case ExpressionPackage.LITERAL_BOOLEAN_VALUE: return createLiteralBooleanValue();
			case ExpressionPackage.LITERAL_CHARACTER_VALUE: return createLiteralCharacterValue();
			case ExpressionPackage.LITERAL_RATIONAL_VALUE: return createLiteralRationalValue();
			case ExpressionPackage.LITERAL_STRING_VALUE: return createLiteralStringValue();
			case ExpressionPackage.LITERAL_NULL_VALUE: return createLiteralNullValue();
			case ExpressionPackage.LITERAL_FLOAT_VALUE: return createLiteralFloatValue();
			case ExpressionPackage.LITERAL_REAL_VALUE: return createLiteralRealValue();
			case ExpressionPackage.LITERAL_REFERENCE_VALUE: return createLiteralReferenceValue();
			case ExpressionPackage.LITERAL_OBJECT_REFERENCE: return createLiteralObjectReference();
			case ExpressionPackage.LITERAL_THIS_INSTANCE: return createLiteralThisInstance();
			case ExpressionPackage.LITERAL_SELF_INSTANCE: return createLiteralSelfInstance();
			case ExpressionPackage.LITERAL_PARENT_INSTANCE: return createLiteralParentInstance();
			case ExpressionPackage.LITERAL_SUPER_INSTANCE: return createLiteralSuperInstance();
			case ExpressionPackage.LITERAL_SYSTEM_INSTANCE: return createLiteralSystemInstance();
			case ExpressionPackage.LITERAL_ENV_INSTANCE: return createLiteralEnvInstance();
			case ExpressionPackage.LITERAL_TIME_VARIABLE: return createLiteralTimeVariable();
			case ExpressionPackage.LITERAL_TIME_DELTA_VARIABLE: return createLiteralTimeDeltaVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralExpressionValue createLiteralExpressionValue() {
		LiteralExpressionValueImpl literalExpressionValue = new LiteralExpressionValueImpl();
		return literalExpressionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralArrayValue createLiteralArrayValue() {
		LiteralArrayValueImpl literalArrayValue = new LiteralArrayValueImpl();
		return literalArrayValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralIntegerValue createLiteralIntegerValue() {
		LiteralIntegerValueImpl literalIntegerValue = new LiteralIntegerValueImpl();
		return literalIntegerValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralBooleanValue createLiteralBooleanValue() {
		LiteralBooleanValueImpl literalBooleanValue = new LiteralBooleanValueImpl();
		return literalBooleanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralCharacterValue createLiteralCharacterValue() {
		LiteralCharacterValueImpl literalCharacterValue = new LiteralCharacterValueImpl();
		return literalCharacterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralRationalValue createLiteralRationalValue() {
		LiteralRationalValueImpl literalRationalValue = new LiteralRationalValueImpl();
		return literalRationalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralStringValue createLiteralStringValue() {
		LiteralStringValueImpl literalStringValue = new LiteralStringValueImpl();
		return literalStringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralNullValue createLiteralNullValue() {
		LiteralNullValueImpl literalNullValue = new LiteralNullValueImpl();
		return literalNullValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralFloatValue createLiteralFloatValue() {
		LiteralFloatValueImpl literalFloatValue = new LiteralFloatValueImpl();
		return literalFloatValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralRealValue createLiteralRealValue() {
		LiteralRealValueImpl literalRealValue = new LiteralRealValueImpl();
		return literalRealValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralReferenceValue createLiteralReferenceValue() {
		LiteralReferenceValueImpl literalReferenceValue = new LiteralReferenceValueImpl();
		return literalReferenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralObjectReference createLiteralObjectReference() {
		LiteralObjectReferenceImpl literalObjectReference = new LiteralObjectReferenceImpl();
		return literalObjectReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralThisInstance createLiteralThisInstance() {
		LiteralThisInstanceImpl literalThisInstance = new LiteralThisInstanceImpl();
		return literalThisInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralSelfInstance createLiteralSelfInstance() {
		LiteralSelfInstanceImpl literalSelfInstance = new LiteralSelfInstanceImpl();
		return literalSelfInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralParentInstance createLiteralParentInstance() {
		LiteralParentInstanceImpl literalParentInstance = new LiteralParentInstanceImpl();
		return literalParentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralSuperInstance createLiteralSuperInstance() {
		LiteralSuperInstanceImpl literalSuperInstance = new LiteralSuperInstanceImpl();
		return literalSuperInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralSystemInstance createLiteralSystemInstance() {
		LiteralSystemInstanceImpl literalSystemInstance = new LiteralSystemInstanceImpl();
		return literalSystemInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralEnvInstance createLiteralEnvInstance() {
		LiteralEnvInstanceImpl literalEnvInstance = new LiteralEnvInstanceImpl();
		return literalEnvInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralTimeVariable createLiteralTimeVariable() {
		LiteralTimeVariableImpl literalTimeVariable = new LiteralTimeVariableImpl();
		return literalTimeVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralTimeDeltaVariable createLiteralTimeDeltaVariable() {
		LiteralTimeDeltaVariableImpl literalTimeDeltaVariable = new LiteralTimeDeltaVariableImpl();
		return literalTimeDeltaVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionPackage getExpressionPackage() {
		return (ExpressionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpressionPackage getPackage() {
		return ExpressionPackage.eINSTANCE;
	}

} //ExpressionFactoryImpl
