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

import org.eclipse.efm.ecore.sew.SewPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.sew.expression.ExpressionFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expression";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/SEW/Expression";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expression";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionPackage eINSTANCE = org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__OPERATOR = SewPackage.WVALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__OPERAND = SewPackage.WVALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = SewPackage.WVALUE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = SewPackage.WVALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralExpressionValueImpl <em>Literal Expression Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralExpressionValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralExpressionValue()
	 * @generated
	 */
	int LITERAL_EXPRESSION_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Literal Expression Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION_VALUE_FEATURE_COUNT = SewPackage.WVALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Expression Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION_VALUE_OPERATION_COUNT = SewPackage.WVALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralArrayValueImpl <em>Literal Array Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralArrayValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralArrayValue()
	 * @generated
	 */
	int LITERAL_ARRAY_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ARRAY_VALUE__VALUES = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Array Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ARRAY_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Array Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ARRAY_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralIntegerValueImpl <em>Literal Integer Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralIntegerValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralIntegerValue()
	 * @generated
	 */
	int LITERAL_INTEGER_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_VALUE__VALUE = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Integer Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Integer Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralBooleanValueImpl <em>Literal Boolean Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralBooleanValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralBooleanValue()
	 * @generated
	 */
	int LITERAL_BOOLEAN_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_VALUE__VALUE = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralCharacterValueImpl <em>Literal Character Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralCharacterValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralCharacterValue()
	 * @generated
	 */
	int LITERAL_CHARACTER_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_CHARACTER_VALUE__VALUE = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Character Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_CHARACTER_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Character Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_CHARACTER_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralRationalValueImpl <em>Literal Rational Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralRationalValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralRationalValue()
	 * @generated
	 */
	int LITERAL_RATIONAL_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Numerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_VALUE__NUMERATOR = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Denominator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_VALUE__DENOMINATOR = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Literal Rational Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Literal Rational Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralStringValueImpl <em>Literal String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralStringValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralStringValue()
	 * @generated
	 */
	int LITERAL_STRING_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_VALUE__VALUE = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralNullValueImpl <em>Literal Null Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralNullValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralNullValue()
	 * @generated
	 */
	int LITERAL_NULL_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NULL_VALUE__TYPE = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Null Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NULL_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Null Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NULL_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralFloatValueImpl <em>Literal Float Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralFloatValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralFloatValue()
	 * @generated
	 */
	int LITERAL_FLOAT_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT_VALUE__VALUE = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Float Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Float Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralRealValueImpl <em>Literal Real Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralRealValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralRealValue()
	 * @generated
	 */
	int LITERAL_REAL_VALUE = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_VALUE__VALUE = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralReferenceValueImpl <em>Literal Reference Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralReferenceValueImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralReferenceValue()
	 * @generated
	 */
	int LITERAL_REFERENCE_VALUE = 11;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_VALUE__SYMBOL = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Reference Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_VALUE_FEATURE_COUNT = LITERAL_EXPRESSION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Reference Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_VALUE_OPERATION_COUNT = LITERAL_EXPRESSION_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralObjectReferenceImpl <em>Literal Object Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralObjectReferenceImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralObjectReference()
	 * @generated
	 */
	int LITERAL_OBJECT_REFERENCE = 12;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OBJECT_REFERENCE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OBJECT_REFERENCE__OBJECT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OBJECT_REFERENCE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OBJECT_REFERENCE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralThisInstanceImpl <em>Literal This Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralThisInstanceImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralThisInstance()
	 * @generated
	 */
	int LITERAL_THIS_INSTANCE = 13;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_THIS_INSTANCE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The number of structural features of the '<em>Literal This Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_THIS_INSTANCE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal This Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_THIS_INSTANCE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralSelfInstanceImpl <em>Literal Self Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralSelfInstanceImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralSelfInstance()
	 * @generated
	 */
	int LITERAL_SELF_INSTANCE = 14;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SELF_INSTANCE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The number of structural features of the '<em>Literal Self Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SELF_INSTANCE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Self Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SELF_INSTANCE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralParentInstanceImpl <em>Literal Parent Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralParentInstanceImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralParentInstance()
	 * @generated
	 */
	int LITERAL_PARENT_INSTANCE = 15;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARENT_INSTANCE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The number of structural features of the '<em>Literal Parent Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARENT_INSTANCE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Parent Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARENT_INSTANCE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralSuperInstanceImpl <em>Literal Super Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralSuperInstanceImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralSuperInstance()
	 * @generated
	 */
	int LITERAL_SUPER_INSTANCE = 16;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SUPER_INSTANCE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The number of structural features of the '<em>Literal Super Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SUPER_INSTANCE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Super Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SUPER_INSTANCE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralSystemInstanceImpl <em>Literal System Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralSystemInstanceImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralSystemInstance()
	 * @generated
	 */
	int LITERAL_SYSTEM_INSTANCE = 17;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SYSTEM_INSTANCE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The number of structural features of the '<em>Literal System Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SYSTEM_INSTANCE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal System Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SYSTEM_INSTANCE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralEnvInstanceImpl <em>Literal Env Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralEnvInstanceImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralEnvInstance()
	 * @generated
	 */
	int LITERAL_ENV_INSTANCE = 18;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENV_INSTANCE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The number of structural features of the '<em>Literal Env Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENV_INSTANCE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Env Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENV_INSTANCE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralTimeVariableImpl <em>Literal Time Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralTimeVariableImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralTimeVariable()
	 * @generated
	 */
	int LITERAL_TIME_VARIABLE = 19;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_VARIABLE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The number of structural features of the '<em>Literal Time Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_VARIABLE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Time Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_VARIABLE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralTimeDeltaVariableImpl <em>Literal Time Delta Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralTimeDeltaVariableImpl
	 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralTimeDeltaVariable()
	 * @generated
	 */
	int LITERAL_TIME_DELTA_VARIABLE = 20;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_DELTA_VARIABLE__SYMBOL = LITERAL_REFERENCE_VALUE__SYMBOL;

	/**
	 * The number of structural features of the '<em>Literal Time Delta Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_DELTA_VARIABLE_FEATURE_COUNT = LITERAL_REFERENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Time Delta Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_DELTA_VARIABLE_OPERATION_COUNT = LITERAL_REFERENCE_VALUE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.Expression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.Expression#getOperator()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Operator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.sew.expression.Expression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operand</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.Expression#getOperand()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralExpressionValue <em>Literal Expression Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Expression Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralExpressionValue
	 * @generated
	 */
	EClass getLiteralExpressionValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralArrayValue <em>Literal Array Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Array Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralArrayValue
	 * @generated
	 */
	EClass getLiteralArrayValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.sew.expression.LiteralArrayValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralArrayValue#getValues()
	 * @see #getLiteralArrayValue()
	 * @generated
	 */
	EReference getLiteralArrayValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue <em>Literal Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Integer Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue
	 * @generated
	 */
	EClass getLiteralIntegerValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue#getValue()
	 * @see #getLiteralIntegerValue()
	 * @generated
	 */
	EAttribute getLiteralIntegerValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue <em>Literal Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Boolean Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue
	 * @generated
	 */
	EClass getLiteralBooleanValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue#isValue()
	 * @see #getLiteralBooleanValue()
	 * @generated
	 */
	EAttribute getLiteralBooleanValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue <em>Literal Character Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Character Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue
	 * @generated
	 */
	EClass getLiteralCharacterValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue#getValue()
	 * @see #getLiteralCharacterValue()
	 * @generated
	 */
	EAttribute getLiteralCharacterValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralRationalValue <em>Literal Rational Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Rational Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralRationalValue
	 * @generated
	 */
	EClass getLiteralRationalValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralRationalValue#getNumerator <em>Numerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numerator</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralRationalValue#getNumerator()
	 * @see #getLiteralRationalValue()
	 * @generated
	 */
	EAttribute getLiteralRationalValue_Numerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralRationalValue#getDenominator <em>Denominator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Denominator</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralRationalValue#getDenominator()
	 * @see #getLiteralRationalValue()
	 * @generated
	 */
	EAttribute getLiteralRationalValue_Denominator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralStringValue <em>Literal String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal String Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralStringValue
	 * @generated
	 */
	EClass getLiteralStringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralStringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralStringValue#getValue()
	 * @see #getLiteralStringValue()
	 * @generated
	 */
	EAttribute getLiteralStringValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralNullValue <em>Literal Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Null Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralNullValue
	 * @generated
	 */
	EClass getLiteralNullValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralNullValue#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralNullValue#getType()
	 * @see #getLiteralNullValue()
	 * @generated
	 */
	EAttribute getLiteralNullValue_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralFloatValue <em>Literal Float Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Float Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralFloatValue
	 * @generated
	 */
	EClass getLiteralFloatValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralFloatValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralFloatValue#getValue()
	 * @see #getLiteralFloatValue()
	 * @generated
	 */
	EAttribute getLiteralFloatValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralRealValue <em>Literal Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Real Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralRealValue
	 * @generated
	 */
	EClass getLiteralRealValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralRealValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralRealValue#getValue()
	 * @see #getLiteralRealValue()
	 * @generated
	 */
	EAttribute getLiteralRealValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralReferenceValue <em>Literal Reference Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Reference Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralReferenceValue
	 * @generated
	 */
	EClass getLiteralReferenceValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.expression.LiteralReferenceValue#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralReferenceValue#getSymbol()
	 * @see #getLiteralReferenceValue()
	 * @generated
	 */
	EAttribute getLiteralReferenceValue_Symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralObjectReference <em>Literal Object Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Object Reference</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralObjectReference
	 * @generated
	 */
	EClass getLiteralObjectReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.sew.expression.LiteralObjectReference#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralObjectReference#getObject()
	 * @see #getLiteralObjectReference()
	 * @generated
	 */
	EReference getLiteralObjectReference_Object();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralThisInstance <em>Literal This Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal This Instance</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralThisInstance
	 * @generated
	 */
	EClass getLiteralThisInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralSelfInstance <em>Literal Self Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Self Instance</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralSelfInstance
	 * @generated
	 */
	EClass getLiteralSelfInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralParentInstance <em>Literal Parent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Parent Instance</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralParentInstance
	 * @generated
	 */
	EClass getLiteralParentInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralSuperInstance <em>Literal Super Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Super Instance</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralSuperInstance
	 * @generated
	 */
	EClass getLiteralSuperInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralSystemInstance <em>Literal System Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal System Instance</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralSystemInstance
	 * @generated
	 */
	EClass getLiteralSystemInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralEnvInstance <em>Literal Env Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Env Instance</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralEnvInstance
	 * @generated
	 */
	EClass getLiteralEnvInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralTimeVariable <em>Literal Time Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Time Variable</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralTimeVariable
	 * @generated
	 */
	EClass getLiteralTimeVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.expression.LiteralTimeDeltaVariable <em>Literal Time Delta Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Time Delta Variable</em>'.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralTimeDeltaVariable
	 * @generated
	 */
	EClass getLiteralTimeDeltaVariable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionFactory getExpressionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__OPERATOR = eINSTANCE.getExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__OPERAND = eINSTANCE.getExpression_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralExpressionValueImpl <em>Literal Expression Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralExpressionValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralExpressionValue()
		 * @generated
		 */
		EClass LITERAL_EXPRESSION_VALUE = eINSTANCE.getLiteralExpressionValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralArrayValueImpl <em>Literal Array Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralArrayValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralArrayValue()
		 * @generated
		 */
		EClass LITERAL_ARRAY_VALUE = eINSTANCE.getLiteralArrayValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_ARRAY_VALUE__VALUES = eINSTANCE.getLiteralArrayValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralIntegerValueImpl <em>Literal Integer Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralIntegerValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralIntegerValue()
		 * @generated
		 */
		EClass LITERAL_INTEGER_VALUE = eINSTANCE.getLiteralIntegerValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_INTEGER_VALUE__VALUE = eINSTANCE.getLiteralIntegerValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralBooleanValueImpl <em>Literal Boolean Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralBooleanValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralBooleanValue()
		 * @generated
		 */
		EClass LITERAL_BOOLEAN_VALUE = eINSTANCE.getLiteralBooleanValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_BOOLEAN_VALUE__VALUE = eINSTANCE.getLiteralBooleanValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralCharacterValueImpl <em>Literal Character Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralCharacterValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralCharacterValue()
		 * @generated
		 */
		EClass LITERAL_CHARACTER_VALUE = eINSTANCE.getLiteralCharacterValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_CHARACTER_VALUE__VALUE = eINSTANCE.getLiteralCharacterValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralRationalValueImpl <em>Literal Rational Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralRationalValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralRationalValue()
		 * @generated
		 */
		EClass LITERAL_RATIONAL_VALUE = eINSTANCE.getLiteralRationalValue();

		/**
		 * The meta object literal for the '<em><b>Numerator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_RATIONAL_VALUE__NUMERATOR = eINSTANCE.getLiteralRationalValue_Numerator();

		/**
		 * The meta object literal for the '<em><b>Denominator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_RATIONAL_VALUE__DENOMINATOR = eINSTANCE.getLiteralRationalValue_Denominator();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralStringValueImpl <em>Literal String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralStringValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralStringValue()
		 * @generated
		 */
		EClass LITERAL_STRING_VALUE = eINSTANCE.getLiteralStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_STRING_VALUE__VALUE = eINSTANCE.getLiteralStringValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralNullValueImpl <em>Literal Null Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralNullValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralNullValue()
		 * @generated
		 */
		EClass LITERAL_NULL_VALUE = eINSTANCE.getLiteralNullValue();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_NULL_VALUE__TYPE = eINSTANCE.getLiteralNullValue_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralFloatValueImpl <em>Literal Float Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralFloatValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralFloatValue()
		 * @generated
		 */
		EClass LITERAL_FLOAT_VALUE = eINSTANCE.getLiteralFloatValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_FLOAT_VALUE__VALUE = eINSTANCE.getLiteralFloatValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralRealValueImpl <em>Literal Real Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralRealValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralRealValue()
		 * @generated
		 */
		EClass LITERAL_REAL_VALUE = eINSTANCE.getLiteralRealValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_REAL_VALUE__VALUE = eINSTANCE.getLiteralRealValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralReferenceValueImpl <em>Literal Reference Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralReferenceValueImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralReferenceValue()
		 * @generated
		 */
		EClass LITERAL_REFERENCE_VALUE = eINSTANCE.getLiteralReferenceValue();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_REFERENCE_VALUE__SYMBOL = eINSTANCE.getLiteralReferenceValue_Symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralObjectReferenceImpl <em>Literal Object Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralObjectReferenceImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralObjectReference()
		 * @generated
		 */
		EClass LITERAL_OBJECT_REFERENCE = eINSTANCE.getLiteralObjectReference();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_OBJECT_REFERENCE__OBJECT = eINSTANCE.getLiteralObjectReference_Object();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralThisInstanceImpl <em>Literal This Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralThisInstanceImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralThisInstance()
		 * @generated
		 */
		EClass LITERAL_THIS_INSTANCE = eINSTANCE.getLiteralThisInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralSelfInstanceImpl <em>Literal Self Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralSelfInstanceImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralSelfInstance()
		 * @generated
		 */
		EClass LITERAL_SELF_INSTANCE = eINSTANCE.getLiteralSelfInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralParentInstanceImpl <em>Literal Parent Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralParentInstanceImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralParentInstance()
		 * @generated
		 */
		EClass LITERAL_PARENT_INSTANCE = eINSTANCE.getLiteralParentInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralSuperInstanceImpl <em>Literal Super Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralSuperInstanceImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralSuperInstance()
		 * @generated
		 */
		EClass LITERAL_SUPER_INSTANCE = eINSTANCE.getLiteralSuperInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralSystemInstanceImpl <em>Literal System Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralSystemInstanceImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralSystemInstance()
		 * @generated
		 */
		EClass LITERAL_SYSTEM_INSTANCE = eINSTANCE.getLiteralSystemInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralEnvInstanceImpl <em>Literal Env Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralEnvInstanceImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralEnvInstance()
		 * @generated
		 */
		EClass LITERAL_ENV_INSTANCE = eINSTANCE.getLiteralEnvInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralTimeVariableImpl <em>Literal Time Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralTimeVariableImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralTimeVariable()
		 * @generated
		 */
		EClass LITERAL_TIME_VARIABLE = eINSTANCE.getLiteralTimeVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.expression.impl.LiteralTimeDeltaVariableImpl <em>Literal Time Delta Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.expression.impl.LiteralTimeDeltaVariableImpl
		 * @see org.eclipse.efm.ecore.sew.expression.impl.ExpressionPackageImpl#getLiteralTimeDeltaVariable()
		 * @generated
		 */
		EClass LITERAL_TIME_DELTA_VARIABLE = eINSTANCE.getLiteralTimeDeltaVariable();

	}

} //ExpressionPackage
