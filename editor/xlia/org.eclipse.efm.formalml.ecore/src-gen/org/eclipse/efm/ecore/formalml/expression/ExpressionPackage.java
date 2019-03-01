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
package org.eclipse.efm.ecore.formalml.expression;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionFactory
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
	String eNS_URI = "http://www.eclipse.org/efm/FormalML/Expression";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Expression";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionPackage eINSTANCE = org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueExpressionPrettyPrinterImpl <em>Value Expression Pretty Printer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ValueExpressionPrettyPrinterImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValueExpressionPrettyPrinter()
	 * @generated
	 */
	int VALUE_EXPRESSION_PRETTY_PRINTER = 0;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION_PRETTY_PRINTER__SYMBOL = 0;

	/**
	 * The feature id for the '<em><b>Fix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION_PRETTY_PRINTER__FIX = 1;

	/**
	 * The feature id for the '<em><b>Specific</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION_PRETTY_PRINTER__SPECIFIC = 2;

	/**
	 * The number of structural features of the '<em>Value Expression Pretty Printer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION_PRETTY_PRINTER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Value Expression Pretty Printer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION_PRETTY_PRINTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = CommonPackage.ABSTRACT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ValuePrintableExpressionImpl <em>Value Printable Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ValuePrintableExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValuePrintableExpression()
	 * @generated
	 */
	int VALUE_PRINTABLE_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PRINTABLE_EXPRESSION__SYMBOL = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Printer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PRINTABLE_EXPRESSION__PRINTER = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PRINTABLE_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Value Printable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PRINTABLE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Value Printable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PRINTABLE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralExpression()
	 * @generated
	 */
	int LITERAL_EXPRESSION = 3;

	/**
	 * The number of structural features of the '<em>Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralBooleanExpressionImpl <em>Literal Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralBooleanExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralBooleanExpression()
	 * @generated
	 */
	int LITERAL_BOOLEAN_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_EXPRESSION__VALUE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralIntegerExpressionImpl <em>Literal Integer Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralIntegerExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralIntegerExpression()
	 * @generated
	 */
	int LITERAL_INTEGER_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_EXPRESSION__VALUE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Integer Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Integer Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralRationalExpressionImpl <em>Literal Rational Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralRationalExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralRationalExpression()
	 * @generated
	 */
	int LITERAL_RATIONAL_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Numerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_EXPRESSION__NUMERATOR = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Denominator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_EXPRESSION__DENOMINATOR = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Literal Rational Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Literal Rational Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralFloatExpressionImpl <em>Literal Float Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralFloatExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralFloatExpression()
	 * @generated
	 */
	int LITERAL_FLOAT_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT_EXPRESSION__VALUE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Float Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Float Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralRealExpressionImpl <em>Literal Real Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralRealExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralRealExpression()
	 * @generated
	 */
	int LITERAL_REAL_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_EXPRESSION__VALUE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Real Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Real Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralCharacterExpressionImpl <em>Literal Character Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralCharacterExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralCharacterExpression()
	 * @generated
	 */
	int LITERAL_CHARACTER_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_CHARACTER_EXPRESSION__VALUE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Character Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_CHARACTER_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Character Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_CHARACTER_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralStringExpressionImpl <em>Literal String Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralStringExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralStringExpression()
	 * @generated
	 */
	int LITERAL_STRING_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_EXPRESSION__VALUE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal String Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal String Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralCollectionExpressionImpl <em>Literal Collection Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralCollectionExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralCollectionExpression()
	 * @generated
	 */
	int LITERAL_COLLECTION_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_COLLECTION_EXPRESSION__DATATYPE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_COLLECTION_EXPRESSION__VALUE = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Literal Collection Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_COLLECTION_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Literal Collection Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_COLLECTION_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralNullExpressionImpl <em>Literal Null Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralNullExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralNullExpression()
	 * @generated
	 */
	int LITERAL_NULL_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NULL_EXPRESSION__TYPE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Null Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NULL_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Null Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NULL_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralAnyValueExpressionImpl <em>Literal Any Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralAnyValueExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralAnyValueExpression()
	 * @generated
	 */
	int LITERAL_ANY_VALUE_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ANY_VALUE_EXPRESSION__TYPE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Any Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ANY_VALUE_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Any Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ANY_VALUE_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralOptionalValueExpressionImpl <em>Literal Optional Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralOptionalValueExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralOptionalValueExpression()
	 * @generated
	 */
	int LITERAL_OPTIONAL_VALUE_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPTIONAL_VALUE_EXPRESSION__TYPE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Optional Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPTIONAL_VALUE_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Optional Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPTIONAL_VALUE_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralNoneValueExpressionImpl <em>Literal None Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralNoneValueExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralNoneValueExpression()
	 * @generated
	 */
	int LITERAL_NONE_VALUE_EXPRESSION = 15;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NONE_VALUE_EXPRESSION__TYPE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal None Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NONE_VALUE_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal None Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NONE_VALUE_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralAnyOrNoneValueExpressionImpl <em>Literal Any Or None Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralAnyOrNoneValueExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralAnyOrNoneValueExpression()
	 * @generated
	 */
	int LITERAL_ANY_OR_NONE_VALUE_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ANY_OR_NONE_VALUE_EXPRESSION__TYPE = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Any Or None Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ANY_OR_NONE_VALUE_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Any Or None Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ANY_OR_NONE_VALUE_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceExpressionImpl <em>Literal Reference Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralReferenceExpression()
	 * @generated
	 */
	int LITERAL_REFERENCE_EXPRESSION = 17;

	/**
	 * The number of structural features of the '<em>Literal Reference Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Reference Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT = LITERAL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceElementImpl <em>Literal Reference Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceElementImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralReferenceElement()
	 * @generated
	 */
	int LITERAL_REFERENCE_ELEMENT = 18;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_ELEMENT__KIND = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_ELEMENT__ELEMENT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_ELEMENT__ARG = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Literal Reference Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_ELEMENT_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Literal Reference Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_ELEMENT_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralThisExpressionImpl <em>Literal This Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralThisExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralThisExpression()
	 * @generated
	 */
	int LITERAL_THIS_EXPRESSION = 19;

	/**
	 * The number of structural features of the '<em>Literal This Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_THIS_EXPRESSION_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal This Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_THIS_EXPRESSION_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralSelfExpressionImpl <em>Literal Self Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralSelfExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralSelfExpression()
	 * @generated
	 */
	int LITERAL_SELF_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SELF_EXPRESSION__MODEL = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Self Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SELF_EXPRESSION_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Self Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SELF_EXPRESSION_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralParentExpressionImpl <em>Literal Parent Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralParentExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralParentExpression()
	 * @generated
	 */
	int LITERAL_PARENT_EXPRESSION = 21;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARENT_EXPRESSION__MODEL = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Parent Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARENT_EXPRESSION_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Parent Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARENT_EXPRESSION_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralSuperExpressionImpl <em>Literal Super Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralSuperExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralSuperExpression()
	 * @generated
	 */
	int LITERAL_SUPER_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SUPER_EXPRESSION__MODEL = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Super Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SUPER_EXPRESSION_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Super Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SUPER_EXPRESSION_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralSystemExpressionImpl <em>Literal System Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralSystemExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralSystemExpression()
	 * @generated
	 */
	int LITERAL_SYSTEM_EXPRESSION = 23;

	/**
	 * The number of structural features of the '<em>Literal System Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SYSTEM_EXPRESSION_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal System Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_SYSTEM_EXPRESSION_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralEnvExpressionImpl <em>Literal Env Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralEnvExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralEnvExpression()
	 * @generated
	 */
	int LITERAL_ENV_EXPRESSION = 24;

	/**
	 * The number of structural features of the '<em>Literal Env Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENV_EXPRESSION_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Env Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENV_EXPRESSION_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralTimeExpressionImpl <em>Literal Time Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralTimeExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralTimeExpression()
	 * @generated
	 */
	int LITERAL_TIME_EXPRESSION = 25;

	/**
	 * The number of structural features of the '<em>Literal Time Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_EXPRESSION_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Time Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_EXPRESSION_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralTimeDeltaExpressionImpl <em>Literal Time Delta Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralTimeDeltaExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralTimeDeltaExpression()
	 * @generated
	 */
	int LITERAL_TIME_DELTA_EXPRESSION = 26;

	/**
	 * The number of structural features of the '<em>Literal Time Delta Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_DELTA_EXPRESSION_FEATURE_COUNT = LITERAL_REFERENCE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Time Delta Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TIME_DELTA_EXPRESSION_OPERATION_COUNT = LITERAL_REFERENCE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LeftHandSideExpressionImpl <em>Left Hand Side Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LeftHandSideExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLeftHandSideExpression()
	 * @generated
	 */
	int LEFT_HAND_SIDE_EXPRESSION = 27;

	/**
	 * The feature id for the '<em><b>Lvalue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_HAND_SIDE_EXPRESSION__LVALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Left Hand Side Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_HAND_SIDE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Left Hand Side Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_HAND_SIDE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementExpressionImpl <em>Increment Or Decrement Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getIncrementOrDecrementExpression()
	 * @generated
	 */
	int INCREMENT_OR_DECREMENT_EXPRESSION = 28;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Increment Or Decrement Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Increment Or Decrement Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementPrefixExpressionImpl <em>Increment Or Decrement Prefix Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementPrefixExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getIncrementOrDecrementPrefixExpression()
	 * @generated
	 */
	int INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION = 29;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION__OPERATOR = INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION__LEFT_HAND_SIDE = INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE;

	/**
	 * The number of structural features of the '<em>Increment Or Decrement Prefix Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION_FEATURE_COUNT = INCREMENT_OR_DECREMENT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Increment Or Decrement Prefix Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION_OPERATION_COUNT = INCREMENT_OR_DECREMENT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementPostfixExpressionImpl <em>Increment Or Decrement Postfix Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementPostfixExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getIncrementOrDecrementPostfixExpression()
	 * @generated
	 */
	int INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION__OPERATOR = INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION__LEFT_HAND_SIDE = INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE;

	/**
	 * The number of structural features of the '<em>Increment Or Decrement Postfix Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION_FEATURE_COUNT = INCREMENT_OR_DECREMENT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Increment Or Decrement Postfix Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION_OPERATION_COUNT = INCREMENT_OR_DECREMENT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.AssignmentExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getAssignmentExpression()
	 * @generated
	 */
	int ASSIGNMENT_EXPRESSION = 31;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Assignment Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.NewfreshExpressionImpl <em>Newfresh Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.NewfreshExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getNewfreshExpression()
	 * @generated
	 */
	int NEWFRESH_EXPRESSION = 32;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWFRESH_EXPRESSION__LEFT_HAND_SIDE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Newfresh Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWFRESH_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Newfresh Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWFRESH_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.UnaryExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 33;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.BitwiseUnaryExpressionImpl <em>Bitwise Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.BitwiseUnaryExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getBitwiseUnaryExpression()
	 * @generated
	 */
	int BITWISE_UNARY_EXPRESSION = 34;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_UNARY_EXPRESSION__OPERATOR = UNARY_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_UNARY_EXPRESSION__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Bitwise Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_UNARY_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bitwise Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_UNARY_EXPRESSION_OPERATION_COUNT = UNARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LogicalUnaryExpressionImpl <em>Logical Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LogicalUnaryExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLogicalUnaryExpression()
	 * @generated
	 */
	int LOGICAL_UNARY_EXPRESSION = 35;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_UNARY_EXPRESSION__OPERATOR = UNARY_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_UNARY_EXPRESSION__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Logical Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_UNARY_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Logical Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_UNARY_EXPRESSION_OPERATION_COUNT = UNARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.CastExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getCastExpression()
	 * @generated
	 */
	int CAST_EXPRESSION = 36;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPRESSION__OPERATOR = UNARY_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPRESSION__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPRESSION__DATATYPE = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cast Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cast Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPRESSION_OPERATION_COUNT = UNARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ArithmeticUnaryExpressionImpl <em>Arithmetic Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ArithmeticUnaryExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getArithmeticUnaryExpression()
	 * @generated
	 */
	int ARITHMETIC_UNARY_EXPRESSION = 37;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_UNARY_EXPRESSION__OPERATOR = UNARY_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_UNARY_EXPRESSION__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Arithmetic Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_UNARY_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arithmetic Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_UNARY_EXPRESSION_OPERATION_COUNT = UNARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.BinaryExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getBinaryExpression()
	 * @generated
	 */
	int BINARY_EXPRESSION = 38;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.EqualityBinaryExpressionImpl <em>Equality Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.EqualityBinaryExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getEqualityBinaryExpression()
	 * @generated
	 */
	int EQUALITY_BINARY_EXPRESSION = 39;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_BINARY_EXPRESSION__OPERATOR = BINARY_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_BINARY_EXPRESSION__LEFT_OPERAND = BINARY_EXPRESSION__LEFT_OPERAND;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_BINARY_EXPRESSION__RIGHT_OPERAND = BINARY_EXPRESSION__RIGHT_OPERAND;

	/**
	 * The number of structural features of the '<em>Equality Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_BINARY_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Equality Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_BINARY_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalBinaryExpressionImpl <em>Relational Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.RelationalBinaryExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getRelationalBinaryExpression()
	 * @generated
	 */
	int RELATIONAL_BINARY_EXPRESSION = 40;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_BINARY_EXPRESSION__OPERATOR = BINARY_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_BINARY_EXPRESSION__LEFT_OPERAND = BINARY_EXPRESSION__LEFT_OPERAND;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_BINARY_EXPRESSION__RIGHT_OPERAND = BINARY_EXPRESSION__RIGHT_OPERAND;

	/**
	 * The number of structural features of the '<em>Relational Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_BINARY_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relational Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_BINARY_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl <em>Relational Ternary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getRelationalTernaryExpression()
	 * @generated
	 */
	int RELATIONAL_TERNARY_EXPRESSION = 41;

	/**
	 * The feature id for the '<em><b>Left Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relational Ternary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TERNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Relational Ternary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TERNARY_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl <em>Conditional Test Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getConditionalTestExpression()
	 * @generated
	 */
	int CONDITIONAL_TEST_EXPRESSION = 42;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TEST_EXPRESSION__CONDITION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TEST_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Then Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Else Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Else Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Conditional Test Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TEST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Conditional Test Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TEST_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.AssociativeExpressionImpl <em>Associative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.AssociativeExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getAssociativeExpression()
	 * @generated
	 */
	int ASSOCIATIVE_EXPRESSION = 43;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATIVE_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATIVE_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Associative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Associative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATIVE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ArithmeticAssociativeExpressionImpl <em>Arithmetic Associative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ArithmeticAssociativeExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getArithmeticAssociativeExpression()
	 * @generated
	 */
	int ARITHMETIC_ASSOCIATIVE_EXPRESSION = 44;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_ASSOCIATIVE_EXPRESSION__OPERATOR = ASSOCIATIVE_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_ASSOCIATIVE_EXPRESSION__OPERAND = ASSOCIATIVE_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Arithmetic Associative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_ASSOCIATIVE_EXPRESSION_FEATURE_COUNT = ASSOCIATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arithmetic Associative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_ASSOCIATIVE_EXPRESSION_OPERATION_COUNT = ASSOCIATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.BitwiseAssociativeExpressionImpl <em>Bitwise Associative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.BitwiseAssociativeExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getBitwiseAssociativeExpression()
	 * @generated
	 */
	int BITWISE_ASSOCIATIVE_EXPRESSION = 45;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_ASSOCIATIVE_EXPRESSION__OPERATOR = ASSOCIATIVE_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_ASSOCIATIVE_EXPRESSION__OPERAND = ASSOCIATIVE_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Bitwise Associative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_ASSOCIATIVE_EXPRESSION_FEATURE_COUNT = ASSOCIATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bitwise Associative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_ASSOCIATIVE_EXPRESSION_OPERATION_COUNT = ASSOCIATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LogicalAssociativeExpressionImpl <em>Logical Associative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LogicalAssociativeExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLogicalAssociativeExpression()
	 * @generated
	 */
	int LOGICAL_ASSOCIATIVE_EXPRESSION = 46;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ASSOCIATIVE_EXPRESSION__OPERATOR = ASSOCIATIVE_EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ASSOCIATIVE_EXPRESSION__OPERAND = ASSOCIATIVE_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Logical Associative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ASSOCIATIVE_EXPRESSION_FEATURE_COUNT = ASSOCIATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Logical Associative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ASSOCIATIVE_EXPRESSION_OPERATION_COUNT = ASSOCIATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.QuantifiedLogicalExpressionImpl <em>Quantified Logical Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.QuantifiedLogicalExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getQuantifiedLogicalExpression()
	 * @generated
	 */
	int QUANTIFIED_LOGICAL_EXPRESSION = 47;

	/**
	 * The feature id for the '<em><b>Quantifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_LOGICAL_EXPRESSION__QUANTIFIER = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_LOGICAL_EXPRESSION__VARIABLE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_LOGICAL_EXPRESSION__PREDICATE = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Quantified Logical Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_LOGICAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Quantified Logical Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_LOGICAL_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.InvokeExpressionImpl <em>Invoke Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.InvokeExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getInvokeExpression()
	 * @generated
	 */
	int INVOKE_EXPRESSION = 48;

	/**
	 * The feature id for the '<em><b>Call Procedure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_EXPRESSION__CALL_PROCEDURE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Invokable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_EXPRESSION__INVOKABLE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_EXPRESSION__ARGS = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_EXPRESSION__RETS = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Invoke Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Invoke Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.NamedExpressionImpl <em>Named Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.NamedExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getNamedExpression()
	 * @generated
	 */
	int NAMED_EXPRESSION = 49;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXPRESSION__TARGET = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXPRESSION__NAME = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Named Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Named Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.TupleExpressionImpl <em>Tuple Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.TupleExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getTupleExpression()
	 * @generated
	 */
	int TUPLE_EXPRESSION = 50;

	/**
	 * The number of structural features of the '<em>Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.MixTupleExpressionImpl <em>Mix Tuple Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.MixTupleExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getMixTupleExpression()
	 * @generated
	 */
	int MIX_TUPLE_EXPRESSION = 51;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_TUPLE_EXPRESSION__VALUE = TUPLE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mix Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_TUPLE_EXPRESSION_FEATURE_COUNT = TUPLE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mix Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_TUPLE_EXPRESSION_OPERATION_COUNT = TUPLE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.NamedTupleExpressionImpl <em>Named Tuple Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.NamedTupleExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getNamedTupleExpression()
	 * @generated
	 */
	int NAMED_TUPLE_EXPRESSION = 52;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_TUPLE_EXPRESSION__VALUE = TUPLE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_TUPLE_EXPRESSION_FEATURE_COUNT = TUPLE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_TUPLE_EXPRESSION_OPERATION_COUNT = TUPLE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.PositionalTupleExpressionImpl <em>Positional Tuple Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.PositionalTupleExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getPositionalTupleExpression()
	 * @generated
	 */
	int POSITIONAL_TUPLE_EXPRESSION = 53;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONAL_TUPLE_EXPRESSION__VALUE = TUPLE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Positional Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONAL_TUPLE_EXPRESSION_FEATURE_COUNT = TUPLE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Positional Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONAL_TUPLE_EXPRESSION_OPERATION_COUNT = TUPLE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl <em>Value Element Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValueElementSpecification()
	 * @generated
	 */
	int VALUE_ELEMENT_SPECIFICATION = 54;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ELEMENT_SPECIFICATION__KIND = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ELEMENT_SPECIFICATION__EXPECTED = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ELEMENT_SPECIFICATION__PARENT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ELEMENT_SPECIFICATION__ELEMENT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Arg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ELEMENT_SPECIFICATION__ARG = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Value Element Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ELEMENT_SPECIFICATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Value Element Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ELEMENT_SPECIFICATION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.InstantiationExpressionImpl <em>Instantiation Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.InstantiationExpressionImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getInstantiationExpression()
	 * @generated
	 */
	int INSTANTIATION_EXPRESSION = 55;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXPRESSION__INSTANCE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Instantiation Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Instantiation Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsBufferImpl <em>As Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsBufferImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpressionAsBuffer()
	 * @generated
	 */
	int EXPRESSION_AS_BUFFER = 56;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_BUFFER__BUFFER = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>As Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_BUFFER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>As Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_BUFFER_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsChannelImpl <em>As Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsChannelImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpressionAsChannel()
	 * @generated
	 */
	int EXPRESSION_AS_CHANNEL = 57;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_CHANNEL__CHANNEL = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>As Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_CHANNEL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>As Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_CHANNEL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsMachineImpl <em>As Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsMachineImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpressionAsMachine()
	 * @generated
	 */
	int EXPRESSION_AS_MACHINE = 58;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_MACHINE__MACHINE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>As Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_MACHINE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>As Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_MACHINE_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsPortImpl <em>As Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsPortImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpressionAsPort()
	 * @generated
	 */
	int EXPRESSION_AS_PORT = 59;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_PORT__PORT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>As Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_PORT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>As Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_AS_PORT_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceSpecificationImpl <em>Literal Reference Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceSpecificationImpl
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralReferenceSpecification()
	 * @generated
	 */
	int LITERAL_REFERENCE_SPECIFICATION = 60;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_SPECIFICATION__EXPECTED = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_SPECIFICATION__PARENT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_SPECIFICATION__ELEMENT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Literal Reference Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_SPECIFICATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Literal Reference Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REFERENCE_SPECIFICATION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX <em>PRINTER FIX</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getPRINTER_FIX()
	 * @generated
	 */
	int PRINTER_FIX = 61;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind <em>Value Element Specification Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValueElementSpecificationKind()
	 * @generated
	 */
	int VALUE_ELEMENT_SPECIFICATION_KIND = 62;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme <em>Value Element Specification Scheme</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme
	 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValueElementSpecificationScheme()
	 * @generated
	 */
	int VALUE_ELEMENT_SPECIFICATION_SCHEME = 63;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter <em>Value Expression Pretty Printer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Expression Pretty Printer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter
	 * @generated
	 */
	EClass getValueExpressionPrettyPrinter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getSymbol()
	 * @see #getValueExpressionPrettyPrinter()
	 * @generated
	 */
	EAttribute getValueExpressionPrettyPrinter_Symbol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getFix <em>Fix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fix</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getFix()
	 * @see #getValueExpressionPrettyPrinter()
	 * @generated
	 */
	EAttribute getValueExpressionPrettyPrinter_Fix();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getSpecific <em>Specific</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Specific</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter#getSpecific()
	 * @see #getValueExpressionPrettyPrinter()
	 * @generated
	 */
	EAttribute getValueExpressionPrettyPrinter_Specific();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression <em>Value Printable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Printable Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression
	 * @generated
	 */
	EClass getValuePrintableExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getSymbol()
	 * @see #getValuePrintableExpression()
	 * @generated
	 */
	EAttribute getValuePrintableExpression_Symbol();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getPrinter <em>Printer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Printer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getPrinter()
	 * @see #getValuePrintableExpression()
	 * @generated
	 */
	EReference getValuePrintableExpression_Printer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operand</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression#getOperand()
	 * @see #getValuePrintableExpression()
	 * @generated
	 */
	EReference getValuePrintableExpression_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralExpression <em>Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralExpression
	 * @generated
	 */
	EClass getLiteralExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression <em>Literal Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Boolean Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression
	 * @generated
	 */
	EClass getLiteralBooleanExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression#isValue()
	 * @see #getLiteralBooleanExpression()
	 * @generated
	 */
	EAttribute getLiteralBooleanExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression <em>Literal Integer Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Integer Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression
	 * @generated
	 */
	EClass getLiteralIntegerExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression#getValue()
	 * @see #getLiteralIntegerExpression()
	 * @generated
	 */
	EAttribute getLiteralIntegerExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression <em>Literal Rational Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Rational Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression
	 * @generated
	 */
	EClass getLiteralRationalExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression#getNumerator <em>Numerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numerator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression#getNumerator()
	 * @see #getLiteralRationalExpression()
	 * @generated
	 */
	EAttribute getLiteralRationalExpression_Numerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression#getDenominator <em>Denominator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Denominator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression#getDenominator()
	 * @see #getLiteralRationalExpression()
	 * @generated
	 */
	EAttribute getLiteralRationalExpression_Denominator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression <em>Literal Float Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Float Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression
	 * @generated
	 */
	EClass getLiteralFloatExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression#getValue()
	 * @see #getLiteralFloatExpression()
	 * @generated
	 */
	EAttribute getLiteralFloatExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression <em>Literal Real Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Real Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression
	 * @generated
	 */
	EClass getLiteralRealExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression#getValue()
	 * @see #getLiteralRealExpression()
	 * @generated
	 */
	EAttribute getLiteralRealExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression <em>Literal Character Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Character Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression
	 * @generated
	 */
	EClass getLiteralCharacterExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression#getValue()
	 * @see #getLiteralCharacterExpression()
	 * @generated
	 */
	EAttribute getLiteralCharacterExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression <em>Literal String Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal String Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression
	 * @generated
	 */
	EClass getLiteralStringExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression#getValue()
	 * @see #getLiteralStringExpression()
	 * @generated
	 */
	EAttribute getLiteralStringExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression <em>Literal Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Collection Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression
	 * @generated
	 */
	EClass getLiteralCollectionExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Datatype</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression#getDatatype()
	 * @see #getLiteralCollectionExpression()
	 * @generated
	 */
	EReference getLiteralCollectionExpression_Datatype();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression#getValue()
	 * @see #getLiteralCollectionExpression()
	 * @generated
	 */
	EReference getLiteralCollectionExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression <em>Literal Null Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Null Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression
	 * @generated
	 */
	EClass getLiteralNullExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression#getType()
	 * @see #getLiteralNullExpression()
	 * @generated
	 */
	EReference getLiteralNullExpression_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralAnyValueExpression <em>Literal Any Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Any Value Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralAnyValueExpression
	 * @generated
	 */
	EClass getLiteralAnyValueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralAnyValueExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralAnyValueExpression#getType()
	 * @see #getLiteralAnyValueExpression()
	 * @generated
	 */
	EReference getLiteralAnyValueExpression_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralOptionalValueExpression <em>Literal Optional Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Optional Value Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralOptionalValueExpression
	 * @generated
	 */
	EClass getLiteralOptionalValueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralOptionalValueExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralOptionalValueExpression#getType()
	 * @see #getLiteralOptionalValueExpression()
	 * @generated
	 */
	EReference getLiteralOptionalValueExpression_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralNoneValueExpression <em>Literal None Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal None Value Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralNoneValueExpression
	 * @generated
	 */
	EClass getLiteralNoneValueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralNoneValueExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralNoneValueExpression#getType()
	 * @see #getLiteralNoneValueExpression()
	 * @generated
	 */
	EReference getLiteralNoneValueExpression_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralAnyOrNoneValueExpression <em>Literal Any Or None Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Any Or None Value Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralAnyOrNoneValueExpression
	 * @generated
	 */
	EClass getLiteralAnyOrNoneValueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralAnyOrNoneValueExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralAnyOrNoneValueExpression#getType()
	 * @see #getLiteralAnyOrNoneValueExpression()
	 * @generated
	 */
	EReference getLiteralAnyOrNoneValueExpression_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression <em>Literal Reference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Reference Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression
	 * @generated
	 */
	EClass getLiteralReferenceExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement <em>Literal Reference Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Reference Element</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement
	 * @generated
	 */
	EClass getLiteralReferenceElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getKind()
	 * @see #getLiteralReferenceElement()
	 * @generated
	 */
	EAttribute getLiteralReferenceElement_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getElement()
	 * @see #getLiteralReferenceElement()
	 * @generated
	 */
	EReference getLiteralReferenceElement_Element();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getArg <em>Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Arg</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement#getArg()
	 * @see #getLiteralReferenceElement()
	 * @generated
	 */
	EReference getLiteralReferenceElement_Arg();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression <em>Literal This Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal This Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression
	 * @generated
	 */
	EClass getLiteralThisExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression <em>Literal Self Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Self Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression
	 * @generated
	 */
	EClass getLiteralSelfExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression#getModel()
	 * @see #getLiteralSelfExpression()
	 * @generated
	 */
	EReference getLiteralSelfExpression_Model();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression <em>Literal Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Parent Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression
	 * @generated
	 */
	EClass getLiteralParentExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression#getModel()
	 * @see #getLiteralParentExpression()
	 * @generated
	 */
	EReference getLiteralParentExpression_Model();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression <em>Literal Super Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Super Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression
	 * @generated
	 */
	EClass getLiteralSuperExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression#getModel()
	 * @see #getLiteralSuperExpression()
	 * @generated
	 */
	EReference getLiteralSuperExpression_Model();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression <em>Literal System Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal System Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression
	 * @generated
	 */
	EClass getLiteralSystemExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression <em>Literal Env Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Env Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression
	 * @generated
	 */
	EClass getLiteralEnvExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralTimeExpression <em>Literal Time Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Time Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralTimeExpression
	 * @generated
	 */
	EClass getLiteralTimeExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralTimeDeltaExpression <em>Literal Time Delta Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Time Delta Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralTimeDeltaExpression
	 * @generated
	 */
	EClass getLiteralTimeDeltaExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression <em>Left Hand Side Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Left Hand Side Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression
	 * @generated
	 */
	EClass getLeftHandSideExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression#getLvalue <em>Lvalue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lvalue</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression#getLvalue()
	 * @see #getLeftHandSideExpression()
	 * @generated
	 */
	EReference getLeftHandSideExpression_Lvalue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression <em>Increment Or Decrement Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Increment Or Decrement Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression
	 * @generated
	 */
	EClass getIncrementOrDecrementExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression#getOperator()
	 * @see #getIncrementOrDecrementExpression()
	 * @generated
	 */
	EAttribute getIncrementOrDecrementExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Hand Side</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression#getLeftHandSide()
	 * @see #getIncrementOrDecrementExpression()
	 * @generated
	 */
	EReference getIncrementOrDecrementExpression_LeftHandSide();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPrefixExpression <em>Increment Or Decrement Prefix Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Increment Or Decrement Prefix Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPrefixExpression
	 * @generated
	 */
	EClass getIncrementOrDecrementPrefixExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPostfixExpression <em>Increment Or Decrement Postfix Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Increment Or Decrement Postfix Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPostfixExpression
	 * @generated
	 */
	EClass getIncrementOrDecrementPostfixExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.AssignmentExpression <em>Assignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssignmentExpression
	 * @generated
	 */
	EClass getAssignmentExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.AssignmentExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssignmentExpression#getOperator()
	 * @see #getAssignmentExpression()
	 * @generated
	 */
	EAttribute getAssignmentExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.AssignmentExpression#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Hand Side</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssignmentExpression#getLeftHandSide()
	 * @see #getAssignmentExpression()
	 * @generated
	 */
	EReference getAssignmentExpression_LeftHandSide();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.AssignmentExpression#getRightHandSide <em>Right Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Hand Side</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssignmentExpression#getRightHandSide()
	 * @see #getAssignmentExpression()
	 * @generated
	 */
	EReference getAssignmentExpression_RightHandSide();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.NewfreshExpression <em>Newfresh Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Newfresh Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.NewfreshExpression
	 * @generated
	 */
	EClass getNewfreshExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.NewfreshExpression#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Hand Side</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.NewfreshExpression#getLeftHandSide()
	 * @see #getNewfreshExpression()
	 * @generated
	 */
	EReference getNewfreshExpression_LeftHandSide();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.UnaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.UnaryExpression#getOperator()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EAttribute getUnaryExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.UnaryExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.UnaryExpression#getOperand()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.BitwiseUnaryExpression <em>Bitwise Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bitwise Unary Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.BitwiseUnaryExpression
	 * @generated
	 */
	EClass getBitwiseUnaryExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LogicalUnaryExpression <em>Logical Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Unary Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LogicalUnaryExpression
	 * @generated
	 */
	EClass getLogicalUnaryExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.CastExpression <em>Cast Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cast Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.CastExpression
	 * @generated
	 */
	EClass getCastExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.expression.CastExpression#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Datatype</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.CastExpression#getDatatype()
	 * @see #getCastExpression()
	 * @generated
	 */
	EReference getCastExpression_Datatype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ArithmeticUnaryExpression <em>Arithmetic Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arithmetic Unary Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ArithmeticUnaryExpression
	 * @generated
	 */
	EClass getArithmeticUnaryExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.BinaryExpression
	 * @generated
	 */
	EClass getBinaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.BinaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.BinaryExpression#getOperator()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EAttribute getBinaryExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.BinaryExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.BinaryExpression#getLeftOperand()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.BinaryExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.BinaryExpression#getRightOperand()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.EqualityBinaryExpression <em>Equality Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equality Binary Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.EqualityBinaryExpression
	 * @generated
	 */
	EClass getEqualityBinaryExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression <em>Relational Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Binary Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression
	 * @generated
	 */
	EClass getRelationalBinaryExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression <em>Relational Ternary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Ternary Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression
	 * @generated
	 */
	EClass getRelationalTernaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getLeftRelation <em>Left Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Relation</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getLeftRelation()
	 * @see #getRelationalTernaryExpression()
	 * @generated
	 */
	EReference getRelationalTernaryExpression_LeftRelation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRightOperator <em>Right Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Operator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRightOperator()
	 * @see #getRelationalTernaryExpression()
	 * @generated
	 */
	EAttribute getRelationalTernaryExpression_RightOperator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression#getRightOperand()
	 * @see #getRelationalTernaryExpression()
	 * @generated
	 */
	EReference getRelationalTernaryExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression <em>Conditional Test Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Test Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression
	 * @generated
	 */
	EClass getConditionalTestExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getCondition()
	 * @see #getConditionalTestExpression()
	 * @generated
	 */
	EReference getConditionalTestExpression_Condition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getOperator()
	 * @see #getConditionalTestExpression()
	 * @generated
	 */
	EAttribute getConditionalTestExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getThenOperand <em>Then Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Operand</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getThenOperand()
	 * @see #getConditionalTestExpression()
	 * @generated
	 */
	EReference getConditionalTestExpression_ThenOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getElseSeparator <em>Else Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Else Separator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getElseSeparator()
	 * @see #getConditionalTestExpression()
	 * @generated
	 */
	EAttribute getConditionalTestExpression_ElseSeparator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getElseOperand <em>Else Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Operand</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression#getElseOperand()
	 * @see #getConditionalTestExpression()
	 * @generated
	 */
	EReference getConditionalTestExpression_ElseOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.AssociativeExpression <em>Associative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Associative Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssociativeExpression
	 * @generated
	 */
	EClass getAssociativeExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.AssociativeExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssociativeExpression#getOperator()
	 * @see #getAssociativeExpression()
	 * @generated
	 */
	EAttribute getAssociativeExpression_Operator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.AssociativeExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operand</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssociativeExpression#getOperand()
	 * @see #getAssociativeExpression()
	 * @generated
	 */
	EReference getAssociativeExpression_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ArithmeticAssociativeExpression <em>Arithmetic Associative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arithmetic Associative Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ArithmeticAssociativeExpression
	 * @generated
	 */
	EClass getArithmeticAssociativeExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.BitwiseAssociativeExpression <em>Bitwise Associative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bitwise Associative Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.BitwiseAssociativeExpression
	 * @generated
	 */
	EClass getBitwiseAssociativeExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression <em>Logical Associative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Associative Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression
	 * @generated
	 */
	EClass getLogicalAssociativeExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression <em>Quantified Logical Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantified Logical Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression
	 * @generated
	 */
	EClass getQuantifiedLogicalExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getQuantifier <em>Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantifier</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getQuantifier()
	 * @see #getQuantifiedLogicalExpression()
	 * @generated
	 */
	EAttribute getQuantifiedLogicalExpression_Quantifier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getVariable()
	 * @see #getQuantifiedLogicalExpression()
	 * @generated
	 */
	EReference getQuantifiedLogicalExpression_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression#getPredicate()
	 * @see #getQuantifiedLogicalExpression()
	 * @generated
	 */
	EReference getQuantifiedLogicalExpression_Predicate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression <em>Invoke Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.InvokeExpression
	 * @generated
	 */
	EClass getInvokeExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#isCallProcedure <em>Call Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call Procedure</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.InvokeExpression#isCallProcedure()
	 * @see #getInvokeExpression()
	 * @generated
	 */
	EAttribute getInvokeExpression_CallProcedure();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getInvokable <em>Invokable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invokable</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getInvokable()
	 * @see #getInvokeExpression()
	 * @generated
	 */
	EReference getInvokeExpression_Invokable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Args</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getArgs()
	 * @see #getInvokeExpression()
	 * @generated
	 */
	EReference getInvokeExpression_Args();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getRets <em>Rets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rets</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.InvokeExpression#getRets()
	 * @see #getInvokeExpression()
	 * @generated
	 */
	EReference getInvokeExpression_Rets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.NamedExpression <em>Named Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.NamedExpression
	 * @generated
	 */
	EClass getNamedExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.expression.NamedExpression#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.NamedExpression#getTarget()
	 * @see #getNamedExpression()
	 * @generated
	 */
	EReference getNamedExpression_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.NamedExpression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.NamedExpression#getName()
	 * @see #getNamedExpression()
	 * @generated
	 */
	EAttribute getNamedExpression_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.NamedExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.NamedExpression#getExpression()
	 * @see #getNamedExpression()
	 * @generated
	 */
	EReference getNamedExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.TupleExpression <em>Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.TupleExpression
	 * @generated
	 */
	EClass getTupleExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.MixTupleExpression <em>Mix Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mix Tuple Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.MixTupleExpression
	 * @generated
	 */
	EClass getMixTupleExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.MixTupleExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.MixTupleExpression#getValue()
	 * @see #getMixTupleExpression()
	 * @generated
	 */
	EReference getMixTupleExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.NamedTupleExpression <em>Named Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Tuple Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.NamedTupleExpression
	 * @generated
	 */
	EClass getNamedTupleExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.NamedTupleExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.NamedTupleExpression#getValue()
	 * @see #getNamedTupleExpression()
	 * @generated
	 */
	EReference getNamedTupleExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression <em>Positional Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Positional Tuple Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression
	 * @generated
	 */
	EClass getPositionalTupleExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression#getValue()
	 * @see #getPositionalTupleExpression()
	 * @generated
	 */
	EReference getPositionalTupleExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification <em>Value Element Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Element Specification</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification
	 * @generated
	 */
	EClass getValueElementSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getKind()
	 * @see #getValueElementSpecification()
	 * @generated
	 */
	EAttribute getValueElementSpecification_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getExpected <em>Expected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getExpected()
	 * @see #getValueElementSpecification()
	 * @generated
	 */
	EAttribute getValueElementSpecification_Expected();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parent</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getParent()
	 * @see #getValueElementSpecification()
	 * @generated
	 */
	EReference getValueElementSpecification_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getElement()
	 * @see #getValueElementSpecification()
	 * @generated
	 */
	EReference getValueElementSpecification_Element();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getArg <em>Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Arg</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification#getArg()
	 * @see #getValueElementSpecification()
	 * @generated
	 */
	EReference getValueElementSpecification_Arg();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.InstantiationExpression <em>Instantiation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiation Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.InstantiationExpression
	 * @generated
	 */
	EClass getInstantiationExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.InstantiationExpression#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instance</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.InstantiationExpression#getInstance()
	 * @see #getInstantiationExpression()
	 * @generated
	 */
	EReference getInstantiationExpression_Instance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer <em>As Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As Buffer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer
	 * @generated
	 */
	EClass getExpressionAsBuffer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer#getBuffer()
	 * @see #getExpressionAsBuffer()
	 * @generated
	 */
	EReference getExpressionAsBuffer_Buffer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsChannel <em>As Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As Channel</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsChannel
	 * @generated
	 */
	EClass getExpressionAsChannel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsChannel#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsChannel#getChannel()
	 * @see #getExpressionAsChannel()
	 * @generated
	 */
	EReference getExpressionAsChannel_Channel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine <em>As Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As Machine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine
	 * @generated
	 */
	EClass getExpressionAsMachine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Machine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine#getMachine()
	 * @see #getExpressionAsMachine()
	 * @generated
	 */
	EReference getExpressionAsMachine_Machine();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsPort <em>As Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As Port</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsPort
	 * @generated
	 */
	EClass getExpressionAsPort();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsPort#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Port</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsPort#getPort()
	 * @see #getExpressionAsPort()
	 * @generated
	 */
	EReference getExpressionAsPort_Port();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification <em>Literal Reference Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Reference Specification</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification
	 * @generated
	 */
	EClass getLiteralReferenceSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getExpected <em>Expected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getExpected()
	 * @see #getLiteralReferenceSpecification()
	 * @generated
	 */
	EAttribute getLiteralReferenceSpecification_Expected();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parent</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getParent()
	 * @see #getLiteralReferenceSpecification()
	 * @generated
	 */
	EReference getLiteralReferenceSpecification_Parent();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification#getElement()
	 * @see #getLiteralReferenceSpecification()
	 * @generated
	 */
	EReference getLiteralReferenceSpecification_Element();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX <em>PRINTER FIX</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>PRINTER FIX</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX
	 * @generated
	 */
	EEnum getPRINTER_FIX();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind <em>Value Element Specification Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Value Element Specification Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
	 * @generated
	 */
	EEnum getValueElementSpecificationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme <em>Value Element Specification Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Value Element Specification Scheme</em>'.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme
	 * @generated
	 */
	EEnum getValueElementSpecificationScheme();

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
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueExpressionPrettyPrinterImpl <em>Value Expression Pretty Printer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ValueExpressionPrettyPrinterImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValueExpressionPrettyPrinter()
		 * @generated
		 */
		EClass VALUE_EXPRESSION_PRETTY_PRINTER = eINSTANCE.getValueExpressionPrettyPrinter();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_EXPRESSION_PRETTY_PRINTER__SYMBOL = eINSTANCE.getValueExpressionPrettyPrinter_Symbol();

		/**
		 * The meta object literal for the '<em><b>Fix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_EXPRESSION_PRETTY_PRINTER__FIX = eINSTANCE.getValueExpressionPrettyPrinter_Fix();

		/**
		 * The meta object literal for the '<em><b>Specific</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_EXPRESSION_PRETTY_PRINTER__SPECIFIC = eINSTANCE.getValueExpressionPrettyPrinter_Specific();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ValuePrintableExpressionImpl <em>Value Printable Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ValuePrintableExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValuePrintableExpression()
		 * @generated
		 */
		EClass VALUE_PRINTABLE_EXPRESSION = eINSTANCE.getValuePrintableExpression();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_PRINTABLE_EXPRESSION__SYMBOL = eINSTANCE.getValuePrintableExpression_Symbol();

		/**
		 * The meta object literal for the '<em><b>Printer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_PRINTABLE_EXPRESSION__PRINTER = eINSTANCE.getValuePrintableExpression_Printer();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_PRINTABLE_EXPRESSION__OPERAND = eINSTANCE.getValuePrintableExpression_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralExpression()
		 * @generated
		 */
		EClass LITERAL_EXPRESSION = eINSTANCE.getLiteralExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralBooleanExpressionImpl <em>Literal Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralBooleanExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralBooleanExpression()
		 * @generated
		 */
		EClass LITERAL_BOOLEAN_EXPRESSION = eINSTANCE.getLiteralBooleanExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_BOOLEAN_EXPRESSION__VALUE = eINSTANCE.getLiteralBooleanExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralIntegerExpressionImpl <em>Literal Integer Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralIntegerExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralIntegerExpression()
		 * @generated
		 */
		EClass LITERAL_INTEGER_EXPRESSION = eINSTANCE.getLiteralIntegerExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_INTEGER_EXPRESSION__VALUE = eINSTANCE.getLiteralIntegerExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralRationalExpressionImpl <em>Literal Rational Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralRationalExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralRationalExpression()
		 * @generated
		 */
		EClass LITERAL_RATIONAL_EXPRESSION = eINSTANCE.getLiteralRationalExpression();

		/**
		 * The meta object literal for the '<em><b>Numerator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_RATIONAL_EXPRESSION__NUMERATOR = eINSTANCE.getLiteralRationalExpression_Numerator();

		/**
		 * The meta object literal for the '<em><b>Denominator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_RATIONAL_EXPRESSION__DENOMINATOR = eINSTANCE.getLiteralRationalExpression_Denominator();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralFloatExpressionImpl <em>Literal Float Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralFloatExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralFloatExpression()
		 * @generated
		 */
		EClass LITERAL_FLOAT_EXPRESSION = eINSTANCE.getLiteralFloatExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_FLOAT_EXPRESSION__VALUE = eINSTANCE.getLiteralFloatExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralRealExpressionImpl <em>Literal Real Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralRealExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralRealExpression()
		 * @generated
		 */
		EClass LITERAL_REAL_EXPRESSION = eINSTANCE.getLiteralRealExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_REAL_EXPRESSION__VALUE = eINSTANCE.getLiteralRealExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralCharacterExpressionImpl <em>Literal Character Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralCharacterExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralCharacterExpression()
		 * @generated
		 */
		EClass LITERAL_CHARACTER_EXPRESSION = eINSTANCE.getLiteralCharacterExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_CHARACTER_EXPRESSION__VALUE = eINSTANCE.getLiteralCharacterExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralStringExpressionImpl <em>Literal String Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralStringExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralStringExpression()
		 * @generated
		 */
		EClass LITERAL_STRING_EXPRESSION = eINSTANCE.getLiteralStringExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_STRING_EXPRESSION__VALUE = eINSTANCE.getLiteralStringExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralCollectionExpressionImpl <em>Literal Collection Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralCollectionExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralCollectionExpression()
		 * @generated
		 */
		EClass LITERAL_COLLECTION_EXPRESSION = eINSTANCE.getLiteralCollectionExpression();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_COLLECTION_EXPRESSION__DATATYPE = eINSTANCE.getLiteralCollectionExpression_Datatype();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_COLLECTION_EXPRESSION__VALUE = eINSTANCE.getLiteralCollectionExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralNullExpressionImpl <em>Literal Null Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralNullExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralNullExpression()
		 * @generated
		 */
		EClass LITERAL_NULL_EXPRESSION = eINSTANCE.getLiteralNullExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_NULL_EXPRESSION__TYPE = eINSTANCE.getLiteralNullExpression_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralAnyValueExpressionImpl <em>Literal Any Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralAnyValueExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralAnyValueExpression()
		 * @generated
		 */
		EClass LITERAL_ANY_VALUE_EXPRESSION = eINSTANCE.getLiteralAnyValueExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_ANY_VALUE_EXPRESSION__TYPE = eINSTANCE.getLiteralAnyValueExpression_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralOptionalValueExpressionImpl <em>Literal Optional Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralOptionalValueExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralOptionalValueExpression()
		 * @generated
		 */
		EClass LITERAL_OPTIONAL_VALUE_EXPRESSION = eINSTANCE.getLiteralOptionalValueExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_OPTIONAL_VALUE_EXPRESSION__TYPE = eINSTANCE.getLiteralOptionalValueExpression_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralNoneValueExpressionImpl <em>Literal None Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralNoneValueExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralNoneValueExpression()
		 * @generated
		 */
		EClass LITERAL_NONE_VALUE_EXPRESSION = eINSTANCE.getLiteralNoneValueExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_NONE_VALUE_EXPRESSION__TYPE = eINSTANCE.getLiteralNoneValueExpression_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralAnyOrNoneValueExpressionImpl <em>Literal Any Or None Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralAnyOrNoneValueExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralAnyOrNoneValueExpression()
		 * @generated
		 */
		EClass LITERAL_ANY_OR_NONE_VALUE_EXPRESSION = eINSTANCE.getLiteralAnyOrNoneValueExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_ANY_OR_NONE_VALUE_EXPRESSION__TYPE = eINSTANCE.getLiteralAnyOrNoneValueExpression_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceExpressionImpl <em>Literal Reference Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralReferenceExpression()
		 * @generated
		 */
		EClass LITERAL_REFERENCE_EXPRESSION = eINSTANCE.getLiteralReferenceExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceElementImpl <em>Literal Reference Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceElementImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralReferenceElement()
		 * @generated
		 */
		EClass LITERAL_REFERENCE_ELEMENT = eINSTANCE.getLiteralReferenceElement();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_REFERENCE_ELEMENT__KIND = eINSTANCE.getLiteralReferenceElement_Kind();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_REFERENCE_ELEMENT__ELEMENT = eINSTANCE.getLiteralReferenceElement_Element();

		/**
		 * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_REFERENCE_ELEMENT__ARG = eINSTANCE.getLiteralReferenceElement_Arg();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralThisExpressionImpl <em>Literal This Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralThisExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralThisExpression()
		 * @generated
		 */
		EClass LITERAL_THIS_EXPRESSION = eINSTANCE.getLiteralThisExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralSelfExpressionImpl <em>Literal Self Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralSelfExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralSelfExpression()
		 * @generated
		 */
		EClass LITERAL_SELF_EXPRESSION = eINSTANCE.getLiteralSelfExpression();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_SELF_EXPRESSION__MODEL = eINSTANCE.getLiteralSelfExpression_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralParentExpressionImpl <em>Literal Parent Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralParentExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralParentExpression()
		 * @generated
		 */
		EClass LITERAL_PARENT_EXPRESSION = eINSTANCE.getLiteralParentExpression();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_PARENT_EXPRESSION__MODEL = eINSTANCE.getLiteralParentExpression_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralSuperExpressionImpl <em>Literal Super Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralSuperExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralSuperExpression()
		 * @generated
		 */
		EClass LITERAL_SUPER_EXPRESSION = eINSTANCE.getLiteralSuperExpression();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_SUPER_EXPRESSION__MODEL = eINSTANCE.getLiteralSuperExpression_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralSystemExpressionImpl <em>Literal System Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralSystemExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralSystemExpression()
		 * @generated
		 */
		EClass LITERAL_SYSTEM_EXPRESSION = eINSTANCE.getLiteralSystemExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralEnvExpressionImpl <em>Literal Env Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralEnvExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralEnvExpression()
		 * @generated
		 */
		EClass LITERAL_ENV_EXPRESSION = eINSTANCE.getLiteralEnvExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralTimeExpressionImpl <em>Literal Time Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralTimeExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralTimeExpression()
		 * @generated
		 */
		EClass LITERAL_TIME_EXPRESSION = eINSTANCE.getLiteralTimeExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralTimeDeltaExpressionImpl <em>Literal Time Delta Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralTimeDeltaExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralTimeDeltaExpression()
		 * @generated
		 */
		EClass LITERAL_TIME_DELTA_EXPRESSION = eINSTANCE.getLiteralTimeDeltaExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LeftHandSideExpressionImpl <em>Left Hand Side Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LeftHandSideExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLeftHandSideExpression()
		 * @generated
		 */
		EClass LEFT_HAND_SIDE_EXPRESSION = eINSTANCE.getLeftHandSideExpression();

		/**
		 * The meta object literal for the '<em><b>Lvalue</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEFT_HAND_SIDE_EXPRESSION__LVALUE = eINSTANCE.getLeftHandSideExpression_Lvalue();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementExpressionImpl <em>Increment Or Decrement Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getIncrementOrDecrementExpression()
		 * @generated
		 */
		EClass INCREMENT_OR_DECREMENT_EXPRESSION = eINSTANCE.getIncrementOrDecrementExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR = eINSTANCE.getIncrementOrDecrementExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE = eINSTANCE.getIncrementOrDecrementExpression_LeftHandSide();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementPrefixExpressionImpl <em>Increment Or Decrement Prefix Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementPrefixExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getIncrementOrDecrementPrefixExpression()
		 * @generated
		 */
		EClass INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION = eINSTANCE.getIncrementOrDecrementPrefixExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementPostfixExpressionImpl <em>Increment Or Decrement Postfix Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.IncrementOrDecrementPostfixExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getIncrementOrDecrementPostfixExpression()
		 * @generated
		 */
		EClass INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION = eINSTANCE.getIncrementOrDecrementPostfixExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.AssignmentExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getAssignmentExpression()
		 * @generated
		 */
		EClass ASSIGNMENT_EXPRESSION = eINSTANCE.getAssignmentExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT_EXPRESSION__OPERATOR = eINSTANCE.getAssignmentExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE = eINSTANCE.getAssignmentExpression_LeftHandSide();

		/**
		 * The meta object literal for the '<em><b>Right Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE = eINSTANCE.getAssignmentExpression_RightHandSide();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.NewfreshExpressionImpl <em>Newfresh Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.NewfreshExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getNewfreshExpression()
		 * @generated
		 */
		EClass NEWFRESH_EXPRESSION = eINSTANCE.getNewfreshExpression();

		/**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEWFRESH_EXPRESSION__LEFT_HAND_SIDE = eINSTANCE.getNewfreshExpression_LeftHandSide();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.UnaryExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXPRESSION__OPERATOR = eINSTANCE.getUnaryExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__OPERAND = eINSTANCE.getUnaryExpression_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.BitwiseUnaryExpressionImpl <em>Bitwise Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.BitwiseUnaryExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getBitwiseUnaryExpression()
		 * @generated
		 */
		EClass BITWISE_UNARY_EXPRESSION = eINSTANCE.getBitwiseUnaryExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LogicalUnaryExpressionImpl <em>Logical Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LogicalUnaryExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLogicalUnaryExpression()
		 * @generated
		 */
		EClass LOGICAL_UNARY_EXPRESSION = eINSTANCE.getLogicalUnaryExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.CastExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getCastExpression()
		 * @generated
		 */
		EClass CAST_EXPRESSION = eINSTANCE.getCastExpression();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAST_EXPRESSION__DATATYPE = eINSTANCE.getCastExpression_Datatype();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ArithmeticUnaryExpressionImpl <em>Arithmetic Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ArithmeticUnaryExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getArithmeticUnaryExpression()
		 * @generated
		 */
		EClass ARITHMETIC_UNARY_EXPRESSION = eINSTANCE.getArithmeticUnaryExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.BinaryExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getBinaryExpression()
		 * @generated
		 */
		EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_EXPRESSION__OPERATOR = eINSTANCE.getBinaryExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__LEFT_OPERAND = eINSTANCE.getBinaryExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getBinaryExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.EqualityBinaryExpressionImpl <em>Equality Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.EqualityBinaryExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getEqualityBinaryExpression()
		 * @generated
		 */
		EClass EQUALITY_BINARY_EXPRESSION = eINSTANCE.getEqualityBinaryExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalBinaryExpressionImpl <em>Relational Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.RelationalBinaryExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getRelationalBinaryExpression()
		 * @generated
		 */
		EClass RELATIONAL_BINARY_EXPRESSION = eINSTANCE.getRelationalBinaryExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl <em>Relational Ternary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.RelationalTernaryExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getRelationalTernaryExpression()
		 * @generated
		 */
		EClass RELATIONAL_TERNARY_EXPRESSION = eINSTANCE.getRelationalTernaryExpression();

		/**
		 * The meta object literal for the '<em><b>Left Relation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION = eINSTANCE.getRelationalTernaryExpression_LeftRelation();

		/**
		 * The meta object literal for the '<em><b>Right Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR = eINSTANCE.getRelationalTernaryExpression_RightOperator();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getRelationalTernaryExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl <em>Conditional Test Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ConditionalTestExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getConditionalTestExpression()
		 * @generated
		 */
		EClass CONDITIONAL_TEST_EXPRESSION = eINSTANCE.getConditionalTestExpression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_TEST_EXPRESSION__CONDITION = eINSTANCE.getConditionalTestExpression_Condition();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_TEST_EXPRESSION__OPERATOR = eINSTANCE.getConditionalTestExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Then Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND = eINSTANCE.getConditionalTestExpression_ThenOperand();

		/**
		 * The meta object literal for the '<em><b>Else Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR = eINSTANCE.getConditionalTestExpression_ElseSeparator();

		/**
		 * The meta object literal for the '<em><b>Else Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND = eINSTANCE.getConditionalTestExpression_ElseOperand();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.AssociativeExpressionImpl <em>Associative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.AssociativeExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getAssociativeExpression()
		 * @generated
		 */
		EClass ASSOCIATIVE_EXPRESSION = eINSTANCE.getAssociativeExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATIVE_EXPRESSION__OPERATOR = eINSTANCE.getAssociativeExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATIVE_EXPRESSION__OPERAND = eINSTANCE.getAssociativeExpression_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ArithmeticAssociativeExpressionImpl <em>Arithmetic Associative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ArithmeticAssociativeExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getArithmeticAssociativeExpression()
		 * @generated
		 */
		EClass ARITHMETIC_ASSOCIATIVE_EXPRESSION = eINSTANCE.getArithmeticAssociativeExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.BitwiseAssociativeExpressionImpl <em>Bitwise Associative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.BitwiseAssociativeExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getBitwiseAssociativeExpression()
		 * @generated
		 */
		EClass BITWISE_ASSOCIATIVE_EXPRESSION = eINSTANCE.getBitwiseAssociativeExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LogicalAssociativeExpressionImpl <em>Logical Associative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LogicalAssociativeExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLogicalAssociativeExpression()
		 * @generated
		 */
		EClass LOGICAL_ASSOCIATIVE_EXPRESSION = eINSTANCE.getLogicalAssociativeExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.QuantifiedLogicalExpressionImpl <em>Quantified Logical Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.QuantifiedLogicalExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getQuantifiedLogicalExpression()
		 * @generated
		 */
		EClass QUANTIFIED_LOGICAL_EXPRESSION = eINSTANCE.getQuantifiedLogicalExpression();

		/**
		 * The meta object literal for the '<em><b>Quantifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUANTIFIED_LOGICAL_EXPRESSION__QUANTIFIER = eINSTANCE.getQuantifiedLogicalExpression_Quantifier();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUANTIFIED_LOGICAL_EXPRESSION__VARIABLE = eINSTANCE.getQuantifiedLogicalExpression_Variable();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUANTIFIED_LOGICAL_EXPRESSION__PREDICATE = eINSTANCE.getQuantifiedLogicalExpression_Predicate();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.InvokeExpressionImpl <em>Invoke Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.InvokeExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getInvokeExpression()
		 * @generated
		 */
		EClass INVOKE_EXPRESSION = eINSTANCE.getInvokeExpression();

		/**
		 * The meta object literal for the '<em><b>Call Procedure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE_EXPRESSION__CALL_PROCEDURE = eINSTANCE.getInvokeExpression_CallProcedure();

		/**
		 * The meta object literal for the '<em><b>Invokable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOKE_EXPRESSION__INVOKABLE = eINSTANCE.getInvokeExpression_Invokable();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOKE_EXPRESSION__ARGS = eINSTANCE.getInvokeExpression_Args();

		/**
		 * The meta object literal for the '<em><b>Rets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOKE_EXPRESSION__RETS = eINSTANCE.getInvokeExpression_Rets();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.NamedExpressionImpl <em>Named Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.NamedExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getNamedExpression()
		 * @generated
		 */
		EClass NAMED_EXPRESSION = eINSTANCE.getNamedExpression();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_EXPRESSION__TARGET = eINSTANCE.getNamedExpression_Target();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_EXPRESSION__NAME = eINSTANCE.getNamedExpression_Name();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_EXPRESSION__EXPRESSION = eINSTANCE.getNamedExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.TupleExpressionImpl <em>Tuple Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.TupleExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getTupleExpression()
		 * @generated
		 */
		EClass TUPLE_EXPRESSION = eINSTANCE.getTupleExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.MixTupleExpressionImpl <em>Mix Tuple Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.MixTupleExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getMixTupleExpression()
		 * @generated
		 */
		EClass MIX_TUPLE_EXPRESSION = eINSTANCE.getMixTupleExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIX_TUPLE_EXPRESSION__VALUE = eINSTANCE.getMixTupleExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.NamedTupleExpressionImpl <em>Named Tuple Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.NamedTupleExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getNamedTupleExpression()
		 * @generated
		 */
		EClass NAMED_TUPLE_EXPRESSION = eINSTANCE.getNamedTupleExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_TUPLE_EXPRESSION__VALUE = eINSTANCE.getNamedTupleExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.PositionalTupleExpressionImpl <em>Positional Tuple Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.PositionalTupleExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getPositionalTupleExpression()
		 * @generated
		 */
		EClass POSITIONAL_TUPLE_EXPRESSION = eINSTANCE.getPositionalTupleExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSITIONAL_TUPLE_EXPRESSION__VALUE = eINSTANCE.getPositionalTupleExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl <em>Value Element Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValueElementSpecification()
		 * @generated
		 */
		EClass VALUE_ELEMENT_SPECIFICATION = eINSTANCE.getValueElementSpecification();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_ELEMENT_SPECIFICATION__KIND = eINSTANCE.getValueElementSpecification_Kind();

		/**
		 * The meta object literal for the '<em><b>Expected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_ELEMENT_SPECIFICATION__EXPECTED = eINSTANCE.getValueElementSpecification_Expected();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_ELEMENT_SPECIFICATION__PARENT = eINSTANCE.getValueElementSpecification_Parent();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_ELEMENT_SPECIFICATION__ELEMENT = eINSTANCE.getValueElementSpecification_Element();

		/**
		 * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_ELEMENT_SPECIFICATION__ARG = eINSTANCE.getValueElementSpecification_Arg();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.InstantiationExpressionImpl <em>Instantiation Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.InstantiationExpressionImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getInstantiationExpression()
		 * @generated
		 */
		EClass INSTANTIATION_EXPRESSION = eINSTANCE.getInstantiationExpression();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXPRESSION__INSTANCE = eINSTANCE.getInstantiationExpression_Instance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsBufferImpl <em>As Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsBufferImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpressionAsBuffer()
		 * @generated
		 */
		EClass EXPRESSION_AS_BUFFER = eINSTANCE.getExpressionAsBuffer();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_AS_BUFFER__BUFFER = eINSTANCE.getExpressionAsBuffer_Buffer();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsChannelImpl <em>As Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsChannelImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpressionAsChannel()
		 * @generated
		 */
		EClass EXPRESSION_AS_CHANNEL = eINSTANCE.getExpressionAsChannel();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_AS_CHANNEL__CHANNEL = eINSTANCE.getExpressionAsChannel_Channel();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsMachineImpl <em>As Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsMachineImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpressionAsMachine()
		 * @generated
		 */
		EClass EXPRESSION_AS_MACHINE = eINSTANCE.getExpressionAsMachine();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_AS_MACHINE__MACHINE = eINSTANCE.getExpressionAsMachine_Machine();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsPortImpl <em>As Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionAsPortImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getExpressionAsPort()
		 * @generated
		 */
		EClass EXPRESSION_AS_PORT = eINSTANCE.getExpressionAsPort();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_AS_PORT__PORT = eINSTANCE.getExpressionAsPort_Port();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceSpecificationImpl <em>Literal Reference Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceSpecificationImpl
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getLiteralReferenceSpecification()
		 * @generated
		 */
		EClass LITERAL_REFERENCE_SPECIFICATION = eINSTANCE.getLiteralReferenceSpecification();

		/**
		 * The meta object literal for the '<em><b>Expected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_REFERENCE_SPECIFICATION__EXPECTED = eINSTANCE.getLiteralReferenceSpecification_Expected();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_REFERENCE_SPECIFICATION__PARENT = eINSTANCE.getLiteralReferenceSpecification_Parent();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_REFERENCE_SPECIFICATION__ELEMENT = eINSTANCE.getLiteralReferenceSpecification_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX <em>PRINTER FIX</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getPRINTER_FIX()
		 * @generated
		 */
		EEnum PRINTER_FIX = eINSTANCE.getPRINTER_FIX();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind <em>Value Element Specification Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValueElementSpecificationKind()
		 * @generated
		 */
		EEnum VALUE_ELEMENT_SPECIFICATION_KIND = eINSTANCE.getValueElementSpecificationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme <em>Value Element Specification Scheme</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme
		 * @see org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl#getValueElementSpecificationScheme()
		 * @generated
		 */
		EEnum VALUE_ELEMENT_SPECIFICATION_SCHEME = eINSTANCE.getValueElementSpecificationScheme();

	}

} //ExpressionPackage
