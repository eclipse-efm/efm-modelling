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
package org.eclipse.efm.ecore.formalml.statement;

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
 * @see org.eclipse.efm.ecore.formalml.statement.StatementFactory
 * @model kind="package"
 * @generated
 */
public interface StatementPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "statement";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/FormalML/Statement";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Statement";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatementPackage eINSTANCE = org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 0;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.BlockStatementImpl <em>Block Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.BlockStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getBlockStatement()
	 * @generated
	 */
	int BLOCK_STATEMENT = 1;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__OP = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__STATEMENT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.ExpressionStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getExpressionStatement()
	 * @generated
	 */
	int EXPRESSION_STATEMENT = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.AssignmentStatementImpl <em>Assignment Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.AssignmentStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getAssignmentStatement()
	 * @generated
	 */
	int ASSIGNMENT_STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__OPERATOR = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rigth Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Assignment Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Assignment Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.NewfreshStatementImpl <em>Newfresh Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.NewfreshStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getNewfreshStatement()
	 * @generated
	 */
	int NEWFRESH_STATEMENT = 4;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWFRESH_STATEMENT__LEFT_VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Newfresh Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWFRESH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Newfresh Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWFRESH_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.AbstractGuardStatementImpl <em>Abstract Guard Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.AbstractGuardStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getAbstractGuardStatement()
	 * @generated
	 */
	int ABSTRACT_GUARD_STATEMENT = 5;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GUARD_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GUARD_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GUARD_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.GuardStatementImpl <em>Guard Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.GuardStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getGuardStatement()
	 * @generated
	 */
	int GUARD_STATEMENT = 6;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_STATEMENT__CONDITION = ABSTRACT_GUARD_STATEMENT__CONDITION;

	/**
	 * The number of structural features of the '<em>Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_STATEMENT_FEATURE_COUNT = ABSTRACT_GUARD_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_STATEMENT_OPERATION_COUNT = ABSTRACT_GUARD_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.TimedGuardStatementImpl <em>Timed Guard Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.TimedGuardStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getTimedGuardStatement()
	 * @generated
	 */
	int TIMED_GUARD_STATEMENT = 7;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_GUARD_STATEMENT__CONDITION = ABSTRACT_GUARD_STATEMENT__CONDITION;

	/**
	 * The number of structural features of the '<em>Timed Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_GUARD_STATEMENT_FEATURE_COUNT = ABSTRACT_GUARD_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Timed Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_GUARD_STATEMENT_OPERATION_COUNT = ABSTRACT_GUARD_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.EventGuardStatementImpl <em>Event Guard Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.EventGuardStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getEventGuardStatement()
	 * @generated
	 */
	int EVENT_GUARD_STATEMENT = 8;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD_STATEMENT__CONDITION = ABSTRACT_GUARD_STATEMENT__CONDITION;

	/**
	 * The number of structural features of the '<em>Event Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD_STATEMENT_FEATURE_COUNT = ABSTRACT_GUARD_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Event Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD_STATEMENT_OPERATION_COUNT = ABSTRACT_GUARD_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.CheckSatGuardStatementImpl <em>Check Sat Guard Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.CheckSatGuardStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getCheckSatGuardStatement()
	 * @generated
	 */
	int CHECK_SAT_GUARD_STATEMENT = 9;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_SAT_GUARD_STATEMENT__CONDITION = ABSTRACT_GUARD_STATEMENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Solver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_SAT_GUARD_STATEMENT__SOLVER = ABSTRACT_GUARD_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check Sat Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_SAT_GUARD_STATEMENT_FEATURE_COUNT = ABSTRACT_GUARD_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Check Sat Guard Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_SAT_GUARD_STATEMENT_OPERATION_COUNT = ABSTRACT_GUARD_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.AbstractComStatementImpl <em>Abstract Com Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.AbstractComStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getAbstractComStatement()
	 * @generated
	 */
	int ABSTRACT_COM_STATEMENT = 10;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COM_STATEMENT__PORT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COM_STATEMENT__ROUTE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COM_STATEMENT__TARGET = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Com Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COM_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Abstract Com Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COM_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.InputComStatementImpl <em>Input Com Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.InputComStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getInputComStatement()
	 * @generated
	 */
	int INPUT_COM_STATEMENT = 11;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_COM_STATEMENT__PORT = ABSTRACT_COM_STATEMENT__PORT;

	/**
	 * The feature id for the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_COM_STATEMENT__ROUTE = ABSTRACT_COM_STATEMENT__ROUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_COM_STATEMENT__TARGET = ABSTRACT_COM_STATEMENT__TARGET;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_COM_STATEMENT__LEFT_VALUE = ABSTRACT_COM_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Com Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_COM_STATEMENT_FEATURE_COUNT = ABSTRACT_COM_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Input Com Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_COM_STATEMENT_OPERATION_COUNT = ABSTRACT_COM_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.OutputComStatementImpl <em>Output Com Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.OutputComStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getOutputComStatement()
	 * @generated
	 */
	int OUTPUT_COM_STATEMENT = 12;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_COM_STATEMENT__PORT = ABSTRACT_COM_STATEMENT__PORT;

	/**
	 * The feature id for the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_COM_STATEMENT__ROUTE = ABSTRACT_COM_STATEMENT__ROUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_COM_STATEMENT__TARGET = ABSTRACT_COM_STATEMENT__TARGET;

	/**
	 * The feature id for the '<em><b>Rigth Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_COM_STATEMENT__RIGTH_VALUE = ABSTRACT_COM_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Com Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_COM_STATEMENT_FEATURE_COUNT = ABSTRACT_COM_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Output Com Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_COM_STATEMENT_OPERATION_COUNT = ABSTRACT_COM_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ConditionalBlockStatementImpl <em>Conditional Block Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.ConditionalBlockStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getConditionalBlockStatement()
	 * @generated
	 */
	int CONDITIONAL_BLOCK_STATEMENT = 13;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Conditional Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Conditional Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.IfStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 14;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONDITION = CONDITIONAL_BLOCK_STATEMENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__BODY_BLOCK = CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK;

	/**
	 * The feature id for the '<em><b>Elseif Statement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ELSEIF_STATEMENT = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ELSE_BLOCK = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_OPERATION_COUNT = CONDITIONAL_BLOCK_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.WhileDoStatementImpl <em>While Do Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.WhileDoStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getWhileDoStatement()
	 * @generated
	 */
	int WHILE_DO_STATEMENT = 15;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_DO_STATEMENT__CONDITION = CONDITIONAL_BLOCK_STATEMENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_DO_STATEMENT__BODY_BLOCK = CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK;

	/**
	 * The number of structural features of the '<em>While Do Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_DO_STATEMENT_FEATURE_COUNT = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>While Do Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_DO_STATEMENT_OPERATION_COUNT = CONDITIONAL_BLOCK_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.DoWhileStatementImpl <em>Do While Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.DoWhileStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getDoWhileStatement()
	 * @generated
	 */
	int DO_WHILE_STATEMENT = 16;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_WHILE_STATEMENT__CONDITION = CONDITIONAL_BLOCK_STATEMENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_WHILE_STATEMENT__BODY_BLOCK = CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK;

	/**
	 * The number of structural features of the '<em>Do While Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_WHILE_STATEMENT_FEATURE_COUNT = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Do While Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_WHILE_STATEMENT_OPERATION_COUNT = CONDITIONAL_BLOCK_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.ForStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 17;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__CONDITION = CONDITIONAL_BLOCK_STATEMENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__BODY_BLOCK = CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__INIT = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__ITERATE = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_OPERATION_COUNT = CONDITIONAL_BLOCK_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ForEachStatementImpl <em>For Each Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.ForEachStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getForEachStatement()
	 * @generated
	 */
	int FOR_EACH_STATEMENT = 18;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__CONDITION = CONDITIONAL_BLOCK_STATEMENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__BODY_BLOCK = CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__ITERATOR = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__ENUMERATION = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For Each Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT_FEATURE_COUNT = CONDITIONAL_BLOCK_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>For Each Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT_OPERATION_COUNT = CONDITIONAL_BLOCK_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.InterruptStatementImpl <em>Interrupt Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.InterruptStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getInterruptStatement()
	 * @generated
	 */
	int INTERRUPT_STATEMENT = 19;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_STATEMENT__KIND = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_STATEMENT__EXPR = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interrupt Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Interrupt Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ActivityStatementImpl <em>Activity Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.ActivityStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getActivityStatement()
	 * @generated
	 */
	int ACTIVITY_STATEMENT = 20;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_STATEMENT__OP = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_STATEMENT__MACHINE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tuple</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_STATEMENT__TUPLE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Activity Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Activity Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl <em>Invoke Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getInvokeStatement()
	 * @generated
	 */
	int INVOKE_STATEMENT = 21;

	/**
	 * The feature id for the '<em><b>Call Procedure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATEMENT__CALL_PROCEDURE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exec Routine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATEMENT__EXEC_ROUTINE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invokable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATEMENT__INVOKABLE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATEMENT__ARGS = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATEMENT__RETS = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Invoke Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Invoke Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind <em>Interrupt Statement Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getInterruptStatementKind()
	 * @generated
	 */
	int INTERRUPT_STATEMENT_KIND = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind <em>Activity Statement Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getActivityStatementKind()
	 * @generated
	 */
	int ACTIVITY_STATEMENT_KIND = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatementkind <em>Assignment Statementkind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.statement.AssignmentStatementkind
	 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getAssignmentStatementkind()
	 * @generated
	 */
	int ASSIGNMENT_STATEMENTKIND = 24;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.BlockStatement <em>Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.BlockStatement
	 * @generated
	 */
	EClass getBlockStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.statement.BlockStatement#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.BlockStatement#getOp()
	 * @see #getBlockStatement()
	 * @generated
	 */
	EAttribute getBlockStatement_Op();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.statement.BlockStatement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.BlockStatement#getStatement()
	 * @see #getBlockStatement()
	 * @generated
	 */
	EReference getBlockStatement_Statement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.ExpressionStatement <em>Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ExpressionStatement
	 * @generated
	 */
	EClass getExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ExpressionStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ExpressionStatement#getExpression()
	 * @see #getExpressionStatement()
	 * @generated
	 */
	EReference getExpressionStatement_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement <em>Assignment Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AssignmentStatement
	 * @generated
	 */
	EClass getAssignmentStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getExpression()
	 * @see #getAssignmentStatement()
	 * @generated
	 */
	EReference getAssignmentStatement_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getOperator()
	 * @see #getAssignmentStatement()
	 * @generated
	 */
	EAttribute getAssignmentStatement_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Hand Side</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getLeftHandSide()
	 * @see #getAssignmentStatement()
	 * @generated
	 */
	EReference getAssignmentStatement_LeftHandSide();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getRigthHandSide <em>Rigth Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rigth Hand Side</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AssignmentStatement#getRigthHandSide()
	 * @see #getAssignmentStatement()
	 * @generated
	 */
	EReference getAssignmentStatement_RigthHandSide();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.NewfreshStatement <em>Newfresh Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Newfresh Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.NewfreshStatement
	 * @generated
	 */
	EClass getNewfreshStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.NewfreshStatement#getLeftValue <em>Left Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.NewfreshStatement#getLeftValue()
	 * @see #getNewfreshStatement()
	 * @generated
	 */
	EReference getNewfreshStatement_LeftValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement <em>Abstract Guard Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Guard Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement
	 * @generated
	 */
	EClass getAbstractGuardStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement#getCondition()
	 * @see #getAbstractGuardStatement()
	 * @generated
	 */
	EReference getAbstractGuardStatement_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.GuardStatement <em>Guard Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.GuardStatement
	 * @generated
	 */
	EClass getGuardStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.TimedGuardStatement <em>Timed Guard Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Guard Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.TimedGuardStatement
	 * @generated
	 */
	EClass getTimedGuardStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.EventGuardStatement <em>Event Guard Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Guard Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.EventGuardStatement
	 * @generated
	 */
	EClass getEventGuardStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement <em>Check Sat Guard Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Sat Guard Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement
	 * @generated
	 */
	EClass getCheckSatGuardStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement#getSolver <em>Solver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solver</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement#getSolver()
	 * @see #getCheckSatGuardStatement()
	 * @generated
	 */
	EAttribute getCheckSatGuardStatement_Solver();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement <em>Abstract Com Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Com Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AbstractComStatement
	 * @generated
	 */
	EClass getAbstractComStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getPort()
	 * @see #getAbstractComStatement()
	 * @generated
	 */
	EReference getAbstractComStatement_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getRoute <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Route</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getRoute()
	 * @see #getAbstractComStatement()
	 * @generated
	 */
	EReference getAbstractComStatement_Route();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AbstractComStatement#getTarget()
	 * @see #getAbstractComStatement()
	 * @generated
	 */
	EReference getAbstractComStatement_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.InputComStatement <em>Input Com Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Com Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InputComStatement
	 * @generated
	 */
	EClass getInputComStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.statement.InputComStatement#getLeftValue <em>Left Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Left Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InputComStatement#getLeftValue()
	 * @see #getInputComStatement()
	 * @generated
	 */
	EReference getInputComStatement_LeftValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.OutputComStatement <em>Output Com Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Com Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.OutputComStatement
	 * @generated
	 */
	EClass getOutputComStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.statement.OutputComStatement#getRigthValue <em>Rigth Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rigth Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.OutputComStatement#getRigthValue()
	 * @see #getOutputComStatement()
	 * @generated
	 */
	EReference getOutputComStatement_RigthValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement <em>Conditional Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Block Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement
	 * @generated
	 */
	EClass getConditionalBlockStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement#getCondition()
	 * @see #getConditionalBlockStatement()
	 * @generated
	 */
	EReference getConditionalBlockStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement#getBodyBlock <em>Body Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Block</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement#getBodyBlock()
	 * @see #getConditionalBlockStatement()
	 * @generated
	 */
	EReference getConditionalBlockStatement_BodyBlock();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.statement.IfStatement#getElseifStatement <em>Elseif Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elseif Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.IfStatement#getElseifStatement()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ElseifStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.IfStatement#getElseBlock <em>Else Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Block</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.IfStatement#getElseBlock()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ElseBlock();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.WhileDoStatement <em>While Do Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Do Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.WhileDoStatement
	 * @generated
	 */
	EClass getWhileDoStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.DoWhileStatement <em>Do While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Do While Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.DoWhileStatement
	 * @generated
	 */
	EClass getDoWhileStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ForStatement#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ForStatement#getInit()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Init();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ForStatement#getIterate <em>Iterate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterate</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ForStatement#getIterate()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Iterate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.ForEachStatement <em>For Each Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Each Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ForEachStatement
	 * @generated
	 */
	EClass getForEachStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ForEachStatement#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ForEachStatement#getIterator()
	 * @see #getForEachStatement()
	 * @generated
	 */
	EReference getForEachStatement_Iterator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ForEachStatement#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enumeration</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ForEachStatement#getEnumeration()
	 * @see #getForEachStatement()
	 * @generated
	 */
	EReference getForEachStatement_Enumeration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatement <em>Interrupt Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interrupt Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InterruptStatement
	 * @generated
	 */
	EClass getInterruptStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatement#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InterruptStatement#getKind()
	 * @see #getInterruptStatement()
	 * @generated
	 */
	EAttribute getInterruptStatement_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatement#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expr</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InterruptStatement#getExpr()
	 * @see #getInterruptStatement()
	 * @generated
	 */
	EReference getInterruptStatement_Expr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement <em>Activity Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatement
	 * @generated
	 */
	EClass getActivityStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getOp()
	 * @see #getActivityStatement()
	 * @generated
	 */
	EAttribute getActivityStatement_Op();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Machine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getMachine()
	 * @see #getActivityStatement()
	 * @generated
	 */
	EReference getActivityStatement_Machine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getTuple <em>Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tuple</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getTuple()
	 * @see #getActivityStatement()
	 * @generated
	 */
	EReference getActivityStatement_Tuple();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement <em>Invoke Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Statement</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InvokeStatement
	 * @generated
	 */
	EClass getInvokeStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#isCallProcedure <em>Call Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call Procedure</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InvokeStatement#isCallProcedure()
	 * @see #getInvokeStatement()
	 * @generated
	 */
	EAttribute getInvokeStatement_CallProcedure();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#isExecRoutine <em>Exec Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exec Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InvokeStatement#isExecRoutine()
	 * @see #getInvokeStatement()
	 * @generated
	 */
	EAttribute getInvokeStatement_ExecRoutine();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getInvokable <em>Invokable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Invokable</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getInvokable()
	 * @see #getInvokeStatement()
	 * @generated
	 */
	EReference getInvokeStatement_Invokable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Args</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getArgs()
	 * @see #getInvokeStatement()
	 * @generated
	 */
	EReference getInvokeStatement_Args();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getRets <em>Rets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rets</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getRets()
	 * @see #getInvokeStatement()
	 * @generated
	 */
	EReference getInvokeStatement_Rets();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InvokeStatement#getExpression()
	 * @see #getInvokeStatement()
	 * @generated
	 */
	EReference getInvokeStatement_Expression();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind <em>Interrupt Statement Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interrupt Statement Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind
	 * @generated
	 */
	EEnum getInterruptStatementKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind <em>Activity Statement Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Activity Statement Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind
	 * @generated
	 */
	EEnum getActivityStatementKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatementkind <em>Assignment Statementkind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assignment Statementkind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.statement.AssignmentStatementkind
	 * @generated
	 */
	EEnum getAssignmentStatementkind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatementFactory getStatementFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.BlockStatementImpl <em>Block Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.BlockStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getBlockStatement()
		 * @generated
		 */
		EClass BLOCK_STATEMENT = eINSTANCE.getBlockStatement();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_STATEMENT__OP = eINSTANCE.getBlockStatement_Op();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_STATEMENT__STATEMENT = eINSTANCE.getBlockStatement_Statement();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.ExpressionStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getExpressionStatement()
		 * @generated
		 */
		EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getExpressionStatement_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.AssignmentStatementImpl <em>Assignment Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.AssignmentStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getAssignmentStatement()
		 * @generated
		 */
		EClass ASSIGNMENT_STATEMENT = eINSTANCE.getAssignmentStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_STATEMENT__EXPRESSION = eINSTANCE.getAssignmentStatement_Expression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT_STATEMENT__OPERATOR = eINSTANCE.getAssignmentStatement_Operator();

		/**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_STATEMENT__LEFT_HAND_SIDE = eINSTANCE.getAssignmentStatement_LeftHandSide();

		/**
		 * The meta object literal for the '<em><b>Rigth Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_STATEMENT__RIGTH_HAND_SIDE = eINSTANCE.getAssignmentStatement_RigthHandSide();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.NewfreshStatementImpl <em>Newfresh Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.NewfreshStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getNewfreshStatement()
		 * @generated
		 */
		EClass NEWFRESH_STATEMENT = eINSTANCE.getNewfreshStatement();

		/**
		 * The meta object literal for the '<em><b>Left Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEWFRESH_STATEMENT__LEFT_VALUE = eINSTANCE.getNewfreshStatement_LeftValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.AbstractGuardStatementImpl <em>Abstract Guard Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.AbstractGuardStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getAbstractGuardStatement()
		 * @generated
		 */
		EClass ABSTRACT_GUARD_STATEMENT = eINSTANCE.getAbstractGuardStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GUARD_STATEMENT__CONDITION = eINSTANCE.getAbstractGuardStatement_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.GuardStatementImpl <em>Guard Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.GuardStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getGuardStatement()
		 * @generated
		 */
		EClass GUARD_STATEMENT = eINSTANCE.getGuardStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.TimedGuardStatementImpl <em>Timed Guard Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.TimedGuardStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getTimedGuardStatement()
		 * @generated
		 */
		EClass TIMED_GUARD_STATEMENT = eINSTANCE.getTimedGuardStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.EventGuardStatementImpl <em>Event Guard Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.EventGuardStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getEventGuardStatement()
		 * @generated
		 */
		EClass EVENT_GUARD_STATEMENT = eINSTANCE.getEventGuardStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.CheckSatGuardStatementImpl <em>Check Sat Guard Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.CheckSatGuardStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getCheckSatGuardStatement()
		 * @generated
		 */
		EClass CHECK_SAT_GUARD_STATEMENT = eINSTANCE.getCheckSatGuardStatement();

		/**
		 * The meta object literal for the '<em><b>Solver</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_SAT_GUARD_STATEMENT__SOLVER = eINSTANCE.getCheckSatGuardStatement_Solver();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.AbstractComStatementImpl <em>Abstract Com Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.AbstractComStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getAbstractComStatement()
		 * @generated
		 */
		EClass ABSTRACT_COM_STATEMENT = eINSTANCE.getAbstractComStatement();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COM_STATEMENT__PORT = eINSTANCE.getAbstractComStatement_Port();

		/**
		 * The meta object literal for the '<em><b>Route</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COM_STATEMENT__ROUTE = eINSTANCE.getAbstractComStatement_Route();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COM_STATEMENT__TARGET = eINSTANCE.getAbstractComStatement_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.InputComStatementImpl <em>Input Com Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.InputComStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getInputComStatement()
		 * @generated
		 */
		EClass INPUT_COM_STATEMENT = eINSTANCE.getInputComStatement();

		/**
		 * The meta object literal for the '<em><b>Left Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_COM_STATEMENT__LEFT_VALUE = eINSTANCE.getInputComStatement_LeftValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.OutputComStatementImpl <em>Output Com Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.OutputComStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getOutputComStatement()
		 * @generated
		 */
		EClass OUTPUT_COM_STATEMENT = eINSTANCE.getOutputComStatement();

		/**
		 * The meta object literal for the '<em><b>Rigth Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_COM_STATEMENT__RIGTH_VALUE = eINSTANCE.getOutputComStatement_RigthValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ConditionalBlockStatementImpl <em>Conditional Block Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.ConditionalBlockStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getConditionalBlockStatement()
		 * @generated
		 */
		EClass CONDITIONAL_BLOCK_STATEMENT = eINSTANCE.getConditionalBlockStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_BLOCK_STATEMENT__CONDITION = eINSTANCE.getConditionalBlockStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Body Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK = eINSTANCE.getConditionalBlockStatement_BodyBlock();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.IfStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
		 * The meta object literal for the '<em><b>Elseif Statement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__ELSEIF_STATEMENT = eINSTANCE.getIfStatement_ElseifStatement();

		/**
		 * The meta object literal for the '<em><b>Else Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__ELSE_BLOCK = eINSTANCE.getIfStatement_ElseBlock();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.WhileDoStatementImpl <em>While Do Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.WhileDoStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getWhileDoStatement()
		 * @generated
		 */
		EClass WHILE_DO_STATEMENT = eINSTANCE.getWhileDoStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.DoWhileStatementImpl <em>Do While Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.DoWhileStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getDoWhileStatement()
		 * @generated
		 */
		EClass DO_WHILE_STATEMENT = eINSTANCE.getDoWhileStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.ForStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__INIT = eINSTANCE.getForStatement_Init();

		/**
		 * The meta object literal for the '<em><b>Iterate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__ITERATE = eINSTANCE.getForStatement_Iterate();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ForEachStatementImpl <em>For Each Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.ForEachStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getForEachStatement()
		 * @generated
		 */
		EClass FOR_EACH_STATEMENT = eINSTANCE.getForEachStatement();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH_STATEMENT__ITERATOR = eINSTANCE.getForEachStatement_Iterator();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH_STATEMENT__ENUMERATION = eINSTANCE.getForEachStatement_Enumeration();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.InterruptStatementImpl <em>Interrupt Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.InterruptStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getInterruptStatement()
		 * @generated
		 */
		EClass INTERRUPT_STATEMENT = eINSTANCE.getInterruptStatement();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERRUPT_STATEMENT__KIND = eINSTANCE.getInterruptStatement_Kind();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERRUPT_STATEMENT__EXPR = eINSTANCE.getInterruptStatement_Expr();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.ActivityStatementImpl <em>Activity Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.ActivityStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getActivityStatement()
		 * @generated
		 */
		EClass ACTIVITY_STATEMENT = eINSTANCE.getActivityStatement();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_STATEMENT__OP = eINSTANCE.getActivityStatement_Op();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_STATEMENT__MACHINE = eINSTANCE.getActivityStatement_Machine();

		/**
		 * The meta object literal for the '<em><b>Tuple</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_STATEMENT__TUPLE = eINSTANCE.getActivityStatement_Tuple();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl <em>Invoke Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.InvokeStatementImpl
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getInvokeStatement()
		 * @generated
		 */
		EClass INVOKE_STATEMENT = eINSTANCE.getInvokeStatement();

		/**
		 * The meta object literal for the '<em><b>Call Procedure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE_STATEMENT__CALL_PROCEDURE = eINSTANCE.getInvokeStatement_CallProcedure();

		/**
		 * The meta object literal for the '<em><b>Exec Routine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE_STATEMENT__EXEC_ROUTINE = eINSTANCE.getInvokeStatement_ExecRoutine();

		/**
		 * The meta object literal for the '<em><b>Invokable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOKE_STATEMENT__INVOKABLE = eINSTANCE.getInvokeStatement_Invokable();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOKE_STATEMENT__ARGS = eINSTANCE.getInvokeStatement_Args();

		/**
		 * The meta object literal for the '<em><b>Rets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOKE_STATEMENT__RETS = eINSTANCE.getInvokeStatement_Rets();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOKE_STATEMENT__EXPRESSION = eINSTANCE.getInvokeStatement_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind <em>Interrupt Statement Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getInterruptStatementKind()
		 * @generated
		 */
		EEnum INTERRUPT_STATEMENT_KIND = eINSTANCE.getInterruptStatementKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind <em>Activity Statement Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getActivityStatementKind()
		 * @generated
		 */
		EEnum ACTIVITY_STATEMENT_KIND = eINSTANCE.getActivityStatementKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.statement.AssignmentStatementkind <em>Assignment Statementkind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.statement.AssignmentStatementkind
		 * @see org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl#getAssignmentStatementkind()
		 * @generated
		 */
		EEnum ASSIGNMENT_STATEMENTKIND = eINSTANCE.getAssignmentStatementkind();

	}

} //StatementPackage
