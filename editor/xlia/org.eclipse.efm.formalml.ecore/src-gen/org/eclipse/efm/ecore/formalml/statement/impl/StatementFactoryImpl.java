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
package org.eclipse.efm.ecore.formalml.statement.impl;

import org.eclipse.efm.ecore.formalml.statement.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class StatementFactoryImpl extends EFactoryImpl implements StatementFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatementFactory init() {
		try {
			StatementFactory theStatementFactory = (StatementFactory)EPackage.Registry.INSTANCE.getEFactory(StatementPackage.eNS_URI);
			if (theStatementFactory != null) {
				return theStatementFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StatementFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementFactoryImpl() {
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
			case StatementPackage.BLOCK_STATEMENT: return createBlockStatement();
			case StatementPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
			case StatementPackage.GUARD_STATEMENT: return createGuardStatement();
			case StatementPackage.TIMED_GUARD_STATEMENT: return createTimedGuardStatement();
			case StatementPackage.EVENT_GUARD_STATEMENT: return createEventGuardStatement();
			case StatementPackage.CHECK_SAT_GUARD_STATEMENT: return createCheckSatGuardStatement();
			case StatementPackage.INPUT_COM_STATEMENT: return createInputComStatement();
			case StatementPackage.OUTPUT_COM_STATEMENT: return createOutputComStatement();
			case StatementPackage.CONDITIONAL_BLOCK_STATEMENT: return createConditionalBlockStatement();
			case StatementPackage.IF_STATEMENT: return createIfStatement();
			case StatementPackage.WHILE_DO_STATEMENT: return createWhileDoStatement();
			case StatementPackage.DO_WHILE_STATEMENT: return createDoWhileStatement();
			case StatementPackage.FOR_STATEMENT: return createForStatement();
			case StatementPackage.FOR_EACH_STATEMENT: return createForEachStatement();
			case StatementPackage.INTERRUPT_STATEMENT: return createInterruptStatement();
			case StatementPackage.ACTIVITY_STATEMENT: return createActivityStatement();
			case StatementPackage.INVOKE_STATEMENT: return createInvokeStatement();
			case StatementPackage.OBSERVER_STATEMENT: return createObserverStatement();
			case StatementPackage.META_STATEMENT: return createMetaStatement();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StatementPackage.INTERRUPT_STATEMENT_KIND:
				return createInterruptStatementKindFromString(eDataType, initialValue);
			case StatementPackage.ACTIVITY_STATEMENT_KIND:
				return createActivityStatementKindFromString(eDataType, initialValue);
			case StatementPackage.ASSIGNMENT_STATEMENTKIND:
				return createAssignmentStatementkindFromString(eDataType, initialValue);
			case StatementPackage.META_STATEMENT_KIND:
				return createMetaStatementKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StatementPackage.INTERRUPT_STATEMENT_KIND:
				return convertInterruptStatementKindToString(eDataType, instanceValue);
			case StatementPackage.ACTIVITY_STATEMENT_KIND:
				return convertActivityStatementKindToString(eDataType, instanceValue);
			case StatementPackage.ASSIGNMENT_STATEMENTKIND:
				return convertAssignmentStatementkindToString(eDataType, instanceValue);
			case StatementPackage.META_STATEMENT_KIND:
				return convertMetaStatementKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockStatement createBlockStatement() {
		BlockStatementImpl blockStatement = new BlockStatementImpl();
		return blockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GuardStatement createGuardStatement() {
		GuardStatementImpl guardStatement = new GuardStatementImpl();
		return guardStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimedGuardStatement createTimedGuardStatement() {
		TimedGuardStatementImpl timedGuardStatement = new TimedGuardStatementImpl();
		return timedGuardStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventGuardStatement createEventGuardStatement() {
		EventGuardStatementImpl eventGuardStatement = new EventGuardStatementImpl();
		return eventGuardStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CheckSatGuardStatement createCheckSatGuardStatement() {
		CheckSatGuardStatementImpl checkSatGuardStatement = new CheckSatGuardStatementImpl();
		return checkSatGuardStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputComStatement createInputComStatement() {
		InputComStatementImpl inputComStatement = new InputComStatementImpl();
		return inputComStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutputComStatement createOutputComStatement() {
		OutputComStatementImpl outputComStatement = new OutputComStatementImpl();
		return outputComStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConditionalBlockStatement createConditionalBlockStatement() {
		ConditionalBlockStatementImpl conditionalBlockStatement = new ConditionalBlockStatementImpl();
		return conditionalBlockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WhileDoStatement createWhileDoStatement() {
		WhileDoStatementImpl whileDoStatement = new WhileDoStatementImpl();
		return whileDoStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoWhileStatement createDoWhileStatement() {
		DoWhileStatementImpl doWhileStatement = new DoWhileStatementImpl();
		return doWhileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForEachStatement createForEachStatement() {
		ForEachStatementImpl forEachStatement = new ForEachStatementImpl();
		return forEachStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterruptStatement createInterruptStatement() {
		InterruptStatementImpl interruptStatement = new InterruptStatementImpl();
		return interruptStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActivityStatement createActivityStatement() {
		ActivityStatementImpl activityStatement = new ActivityStatementImpl();
		return activityStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InvokeStatement createInvokeStatement() {
		InvokeStatementImpl invokeStatement = new InvokeStatementImpl();
		return invokeStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObserverStatement createObserverStatement() {
		ObserverStatementImpl observerStatement = new ObserverStatementImpl();
		return observerStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaStatement createMetaStatement() {
		MetaStatementImpl metaStatement = new MetaStatementImpl();
		return metaStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterruptStatementKind createInterruptStatementKindFromString(EDataType eDataType, String initialValue) {
		InterruptStatementKind result = InterruptStatementKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInterruptStatementKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityStatementKind createActivityStatementKindFromString(EDataType eDataType, String initialValue) {
		ActivityStatementKind result = ActivityStatementKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActivityStatementKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentStatementkind createAssignmentStatementkindFromString(EDataType eDataType, String initialValue) {
		AssignmentStatementkind result = AssignmentStatementkind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssignmentStatementkindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaStatementKind createMetaStatementKindFromString(EDataType eDataType, String initialValue) {
		MetaStatementKind result = MetaStatementKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetaStatementKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatementPackage getStatementPackage() {
		return (StatementPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StatementPackage getPackage() {
		return StatementPackage.eINSTANCE;
	}

} //StatementFactoryImpl
