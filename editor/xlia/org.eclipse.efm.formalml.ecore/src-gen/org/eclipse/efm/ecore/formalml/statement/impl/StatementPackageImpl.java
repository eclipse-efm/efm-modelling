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
package org.eclipse.efm.ecore.formalml.statement.impl;

import org.eclipse.efm.ecore.formalml.FormalmlPackage;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;

import org.eclipse.efm.ecore.formalml.common.impl.CommonPackageImpl;

import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;

import org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl;

import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;

import org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl;

import org.eclipse.efm.ecore.formalml.impl.FormalmlPackageImpl;

import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;

import org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl;

import org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage;

import org.eclipse.efm.ecore.formalml.statemachine.impl.StatemachinePackageImpl;

import org.eclipse.efm.ecore.formalml.statement.AbstractComStatement;
import org.eclipse.efm.ecore.formalml.statement.AbstractGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.ActivityStatement;
import org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind;
import org.eclipse.efm.ecore.formalml.statement.AssignmentStatementkind;
import org.eclipse.efm.ecore.formalml.statement.BlockStatement;
import org.eclipse.efm.ecore.formalml.statement.CheckSatGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.ConditionalBlockStatement;
import org.eclipse.efm.ecore.formalml.statement.DoWhileStatement;
import org.eclipse.efm.ecore.formalml.statement.EventGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.ExpressionStatement;
import org.eclipse.efm.ecore.formalml.statement.ForEachStatement;
import org.eclipse.efm.ecore.formalml.statement.ForStatement;
import org.eclipse.efm.ecore.formalml.statement.GuardStatement;
import org.eclipse.efm.ecore.formalml.statement.IfStatement;
import org.eclipse.efm.ecore.formalml.statement.InputComStatement;
import org.eclipse.efm.ecore.formalml.statement.InterruptStatement;
import org.eclipse.efm.ecore.formalml.statement.InterruptStatementKind;
import org.eclipse.efm.ecore.formalml.statement.InvokeStatement;
import org.eclipse.efm.ecore.formalml.statement.OutputComStatement;
import org.eclipse.efm.ecore.formalml.statement.Statement;
import org.eclipse.efm.ecore.formalml.statement.StatementFactory;
import org.eclipse.efm.ecore.formalml.statement.StatementPackage;
import org.eclipse.efm.ecore.formalml.statement.TimedGuardStatement;
import org.eclipse.efm.ecore.formalml.statement.WhileDoStatement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatementPackageImpl extends EPackageImpl implements StatementPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractGuardStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedGuardStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventGuardStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkSatGuardStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractComStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputComStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputComStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalBlockStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileDoStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doWhileStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interruptStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum interruptStatementKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum activityStatementKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum assignmentStatementkindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StatementPackageImpl() {
		super(eNS_URI, StatementFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link StatementPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StatementPackage init() {
		if (isInited) return (StatementPackage)EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI);

		// Obtain or create and register package
		StatementPackageImpl theStatementPackage = (StatementPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StatementPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StatementPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		FormalmlPackageImpl theFormalmlPackage = (FormalmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FormalmlPackage.eNS_URI) instanceof FormalmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FormalmlPackage.eNS_URI) : FormalmlPackage.eINSTANCE);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI) : InfrastructurePackage.eINSTANCE);
		DatatypePackageImpl theDatatypePackage = (DatatypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DatatypePackage.eNS_URI) instanceof DatatypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DatatypePackage.eNS_URI) : DatatypePackage.eINSTANCE);
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) instanceof ExpressionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) : ExpressionPackage.eINSTANCE);
		StatemachinePackageImpl theStatemachinePackage = (StatemachinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatemachinePackage.eNS_URI) instanceof StatemachinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatemachinePackage.eNS_URI) : StatemachinePackage.eINSTANCE);

		// Create package meta-data objects
		theStatementPackage.createPackageContents();
		theFormalmlPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theInfrastructurePackage.createPackageContents();
		theDatatypePackage.createPackageContents();
		theExpressionPackage.createPackageContents();
		theStatemachinePackage.createPackageContents();

		// Initialize created meta-data
		theStatementPackage.initializePackageContents();
		theFormalmlPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theInfrastructurePackage.initializePackageContents();
		theDatatypePackage.initializePackageContents();
		theExpressionPackage.initializePackageContents();
		theStatemachinePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStatementPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StatementPackage.eNS_URI, theStatementPackage);
		return theStatementPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockStatement() {
		return blockStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockStatement_Op() {
		return (EAttribute)blockStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockStatement_Statement() {
		return (EReference)blockStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionStatement() {
		return expressionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionStatement_Expression() {
		return (EReference)expressionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractGuardStatement() {
		return abstractGuardStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractGuardStatement_Condition() {
		return (EReference)abstractGuardStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuardStatement() {
		return guardStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedGuardStatement() {
		return timedGuardStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventGuardStatement() {
		return eventGuardStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckSatGuardStatement() {
		return checkSatGuardStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckSatGuardStatement_Solver() {
		return (EAttribute)checkSatGuardStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractComStatement() {
		return abstractComStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractComStatement_Port() {
		return (EReference)abstractComStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractComStatement_Route() {
		return (EReference)abstractComStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractComStatement_Target() {
		return (EReference)abstractComStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputComStatement() {
		return inputComStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputComStatement_LeftValue() {
		return (EReference)inputComStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputComStatement() {
		return outputComStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputComStatement_RigthValue() {
		return (EReference)outputComStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalBlockStatement() {
		return conditionalBlockStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalBlockStatement_Condition() {
		return (EReference)conditionalBlockStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalBlockStatement_BodyBlock() {
		return (EReference)conditionalBlockStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfStatement() {
		return ifStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_ElseifStatement() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_ElseBlock() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileDoStatement() {
		return whileDoStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoWhileStatement() {
		return doWhileStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForStatement() {
		return forStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Init() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Iterate() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEachStatement() {
		return forEachStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_Iterator() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_Enumeration() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterruptStatement() {
		return interruptStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterruptStatement_Kind() {
		return (EAttribute)interruptStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterruptStatement_Expr() {
		return (EReference)interruptStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityStatement() {
		return activityStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityStatement_Op() {
		return (EAttribute)activityStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityStatement_Machine() {
		return (EReference)activityStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityStatement_Tuple() {
		return (EReference)activityStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeStatement() {
		return invokeStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeStatement_CallProcedure() {
		return (EAttribute)invokeStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeStatement_ExecRoutine() {
		return (EAttribute)invokeStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvokeStatement_Invokable() {
		return (EReference)invokeStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvokeStatement_Args() {
		return (EReference)invokeStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvokeStatement_Rets() {
		return (EReference)invokeStatementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvokeStatement_Expression() {
		return (EReference)invokeStatementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInterruptStatementKind() {
		return interruptStatementKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActivityStatementKind() {
		return activityStatementKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAssignmentStatementkind() {
		return assignmentStatementkindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementFactory getStatementFactory() {
		return (StatementFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		statementEClass = createEClass(STATEMENT);

		blockStatementEClass = createEClass(BLOCK_STATEMENT);
		createEAttribute(blockStatementEClass, BLOCK_STATEMENT__OP);
		createEReference(blockStatementEClass, BLOCK_STATEMENT__STATEMENT);

		expressionStatementEClass = createEClass(EXPRESSION_STATEMENT);
		createEReference(expressionStatementEClass, EXPRESSION_STATEMENT__EXPRESSION);

		abstractGuardStatementEClass = createEClass(ABSTRACT_GUARD_STATEMENT);
		createEReference(abstractGuardStatementEClass, ABSTRACT_GUARD_STATEMENT__CONDITION);

		guardStatementEClass = createEClass(GUARD_STATEMENT);

		timedGuardStatementEClass = createEClass(TIMED_GUARD_STATEMENT);

		eventGuardStatementEClass = createEClass(EVENT_GUARD_STATEMENT);

		checkSatGuardStatementEClass = createEClass(CHECK_SAT_GUARD_STATEMENT);
		createEAttribute(checkSatGuardStatementEClass, CHECK_SAT_GUARD_STATEMENT__SOLVER);

		abstractComStatementEClass = createEClass(ABSTRACT_COM_STATEMENT);
		createEReference(abstractComStatementEClass, ABSTRACT_COM_STATEMENT__PORT);
		createEReference(abstractComStatementEClass, ABSTRACT_COM_STATEMENT__ROUTE);
		createEReference(abstractComStatementEClass, ABSTRACT_COM_STATEMENT__TARGET);

		inputComStatementEClass = createEClass(INPUT_COM_STATEMENT);
		createEReference(inputComStatementEClass, INPUT_COM_STATEMENT__LEFT_VALUE);

		outputComStatementEClass = createEClass(OUTPUT_COM_STATEMENT);
		createEReference(outputComStatementEClass, OUTPUT_COM_STATEMENT__RIGTH_VALUE);

		conditionalBlockStatementEClass = createEClass(CONDITIONAL_BLOCK_STATEMENT);
		createEReference(conditionalBlockStatementEClass, CONDITIONAL_BLOCK_STATEMENT__CONDITION);
		createEReference(conditionalBlockStatementEClass, CONDITIONAL_BLOCK_STATEMENT__BODY_BLOCK);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__ELSEIF_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__ELSE_BLOCK);

		whileDoStatementEClass = createEClass(WHILE_DO_STATEMENT);

		doWhileStatementEClass = createEClass(DO_WHILE_STATEMENT);

		forStatementEClass = createEClass(FOR_STATEMENT);
		createEReference(forStatementEClass, FOR_STATEMENT__INIT);
		createEReference(forStatementEClass, FOR_STATEMENT__ITERATE);

		forEachStatementEClass = createEClass(FOR_EACH_STATEMENT);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__ITERATOR);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__ENUMERATION);

		interruptStatementEClass = createEClass(INTERRUPT_STATEMENT);
		createEAttribute(interruptStatementEClass, INTERRUPT_STATEMENT__KIND);
		createEReference(interruptStatementEClass, INTERRUPT_STATEMENT__EXPR);

		activityStatementEClass = createEClass(ACTIVITY_STATEMENT);
		createEAttribute(activityStatementEClass, ACTIVITY_STATEMENT__OP);
		createEReference(activityStatementEClass, ACTIVITY_STATEMENT__MACHINE);
		createEReference(activityStatementEClass, ACTIVITY_STATEMENT__TUPLE);

		invokeStatementEClass = createEClass(INVOKE_STATEMENT);
		createEAttribute(invokeStatementEClass, INVOKE_STATEMENT__CALL_PROCEDURE);
		createEAttribute(invokeStatementEClass, INVOKE_STATEMENT__EXEC_ROUTINE);
		createEReference(invokeStatementEClass, INVOKE_STATEMENT__INVOKABLE);
		createEReference(invokeStatementEClass, INVOKE_STATEMENT__ARGS);
		createEReference(invokeStatementEClass, INVOKE_STATEMENT__RETS);
		createEReference(invokeStatementEClass, INVOKE_STATEMENT__EXPRESSION);

		// Create enums
		interruptStatementKindEEnum = createEEnum(INTERRUPT_STATEMENT_KIND);
		activityStatementKindEEnum = createEEnum(ACTIVITY_STATEMENT_KIND);
		assignmentStatementkindEEnum = createEEnum(ASSIGNMENT_STATEMENTKIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		ExpressionPackage theExpressionPackage = (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);
		InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		statementEClass.getESuperTypes().add(theCommonPackage.getAbstractElement());
		blockStatementEClass.getESuperTypes().add(this.getStatement());
		expressionStatementEClass.getESuperTypes().add(this.getStatement());
		abstractGuardStatementEClass.getESuperTypes().add(this.getStatement());
		guardStatementEClass.getESuperTypes().add(this.getAbstractGuardStatement());
		timedGuardStatementEClass.getESuperTypes().add(this.getAbstractGuardStatement());
		eventGuardStatementEClass.getESuperTypes().add(this.getAbstractGuardStatement());
		checkSatGuardStatementEClass.getESuperTypes().add(this.getAbstractGuardStatement());
		abstractComStatementEClass.getESuperTypes().add(this.getStatement());
		inputComStatementEClass.getESuperTypes().add(this.getAbstractComStatement());
		outputComStatementEClass.getESuperTypes().add(this.getAbstractComStatement());
		conditionalBlockStatementEClass.getESuperTypes().add(this.getStatement());
		ifStatementEClass.getESuperTypes().add(this.getConditionalBlockStatement());
		whileDoStatementEClass.getESuperTypes().add(this.getConditionalBlockStatement());
		doWhileStatementEClass.getESuperTypes().add(this.getConditionalBlockStatement());
		forStatementEClass.getESuperTypes().add(this.getConditionalBlockStatement());
		forEachStatementEClass.getESuperTypes().add(this.getConditionalBlockStatement());
		interruptStatementEClass.getESuperTypes().add(this.getStatement());
		activityStatementEClass.getESuperTypes().add(this.getStatement());
		invokeStatementEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes, features, and operations; add parameters
		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockStatementEClass, BlockStatement.class, "BlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlockStatement_Op(), ecorePackage.getEString(), "op", null, 0, 1, BlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockStatement_Statement(), this.getStatement(), null, "statement", null, 0, -1, BlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionStatementEClass, ExpressionStatement.class, "ExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionStatement_Expression(), theExpressionPackage.getExpression(), null, "expression", null, 0, 1, ExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractGuardStatementEClass, AbstractGuardStatement.class, "AbstractGuardStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractGuardStatement_Condition(), theExpressionPackage.getExpression(), null, "condition", null, 1, 1, AbstractGuardStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardStatementEClass, GuardStatement.class, "GuardStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timedGuardStatementEClass, TimedGuardStatement.class, "TimedGuardStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventGuardStatementEClass, EventGuardStatement.class, "EventGuardStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(checkSatGuardStatementEClass, CheckSatGuardStatement.class, "CheckSatGuardStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCheckSatGuardStatement_Solver(), ecorePackage.getEString(), "solver", null, 0, 1, CheckSatGuardStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractComStatementEClass, AbstractComStatement.class, "AbstractComStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractComStatement_Port(), theCommonPackage.getNamedElement(), null, "port", null, 0, 1, AbstractComStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractComStatement_Route(), theInfrastructurePackage.getChannel(), null, "route", null, 0, 1, AbstractComStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractComStatement_Target(), theExpressionPackage.getExpression(), null, "target", null, 0, 1, AbstractComStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputComStatementEClass, InputComStatement.class, "InputComStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputComStatement_LeftValue(), theExpressionPackage.getExpression(), null, "leftValue", null, 0, -1, InputComStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputComStatementEClass, OutputComStatement.class, "OutputComStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputComStatement_RigthValue(), theExpressionPackage.getExpression(), null, "rigthValue", null, 0, -1, OutputComStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalBlockStatementEClass, ConditionalBlockStatement.class, "ConditionalBlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionalBlockStatement_Condition(), theExpressionPackage.getExpression(), null, "condition", null, 1, 1, ConditionalBlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalBlockStatement_BodyBlock(), this.getBlockStatement(), null, "bodyBlock", null, 1, 1, ConditionalBlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfStatement_ElseifStatement(), this.getConditionalBlockStatement(), null, "elseifStatement", null, 0, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_ElseBlock(), this.getBlockStatement(), null, "elseBlock", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileDoStatementEClass, WhileDoStatement.class, "WhileDoStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(doWhileStatementEClass, DoWhileStatement.class, "DoWhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForStatement_Init(), theExpressionPackage.getExpression(), null, "init", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Iterate(), theExpressionPackage.getExpression(), null, "iterate", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forEachStatementEClass, ForEachStatement.class, "ForEachStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForEachStatement_Iterator(), theExpressionPackage.getLeftHandSideExpression(), null, "iterator", null, 1, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachStatement_Enumeration(), theExpressionPackage.getExpression(), null, "enumeration", null, 1, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interruptStatementEClass, InterruptStatement.class, "InterruptStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterruptStatement_Kind(), this.getInterruptStatementKind(), "kind", null, 0, 1, InterruptStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterruptStatement_Expr(), theExpressionPackage.getExpression(), null, "expr", null, 0, -1, InterruptStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activityStatementEClass, ActivityStatement.class, "ActivityStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivityStatement_Op(), this.getActivityStatementKind(), "op", null, 1, 1, ActivityStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivityStatement_Machine(), theExpressionPackage.getExpression(), null, "machine", null, 1, 1, ActivityStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivityStatement_Tuple(), theExpressionPackage.getTupleExpression(), null, "tuple", null, 0, 1, ActivityStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeStatementEClass, InvokeStatement.class, "InvokeStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvokeStatement_CallProcedure(), ecorePackage.getEBoolean(), "callProcedure", "false", 1, 1, InvokeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvokeStatement_ExecRoutine(), ecorePackage.getEBoolean(), "execRoutine", "false", 1, 1, InvokeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvokeStatement_Invokable(), theCommonPackage.getNamedElement(), null, "invokable", null, 0, 1, InvokeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvokeStatement_Args(), theExpressionPackage.getTupleExpression(), null, "args", null, 0, 1, InvokeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvokeStatement_Rets(), theInfrastructurePackage.getVariable(), null, "rets", null, 0, -1, InvokeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvokeStatement_Expression(), theExpressionPackage.getExpression(), null, "expression", null, 0, 1, InvokeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(interruptStatementKindEEnum, InterruptStatementKind.class, "InterruptStatementKind");
		addEEnumLiteral(interruptStatementKindEEnum, InterruptStatementKind.BREAK);
		addEEnumLiteral(interruptStatementKindEEnum, InterruptStatementKind.CONTINUE);
		addEEnumLiteral(interruptStatementKindEEnum, InterruptStatementKind.RETURN);
		addEEnumLiteral(interruptStatementKindEEnum, InterruptStatementKind.EXIT);

		initEEnum(activityStatementKindEEnum, ActivityStatementKind.class, "ActivityStatementKind");
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.INIT);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.FINAL);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.DESTROY);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.START);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.STOP);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.RESTART);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.SUSPEND);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.RESUME);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.WAIT);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.ABORT);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.DISABLE);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.ENABLE);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.IRUN);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.RUN);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.RTC);
		addEEnumLiteral(activityStatementKindEEnum, ActivityStatementKind.SCHEDULE);

		initEEnum(assignmentStatementkindEEnum, AssignmentStatementkind.class, "AssignmentStatementkind");
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.ASSIGN_REF);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.ASSIGN_MACRO);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.PLUS_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.PLUS_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.MINUS_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.MINUS_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.STAR_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.STAR_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.DIV_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.DIV_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.MOD_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.MOD_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.LAND_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.LAND_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.LOR_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.LOR_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.BAND_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.BAND_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.BOR_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.BOR_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.BXOR_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.BXOR_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.LSHIFT_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.LSHIFT_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.RSHIFT_ASSIGN_AFTER);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.RSHIFT_ASSIGN);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.OP_PUSH);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.OP_ASSIGN_TOP);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.OP_POP);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.INCR);
		addEEnumLiteral(assignmentStatementkindEEnum, AssignmentStatementkind.DECR);
	}

} //StatementPackageImpl
