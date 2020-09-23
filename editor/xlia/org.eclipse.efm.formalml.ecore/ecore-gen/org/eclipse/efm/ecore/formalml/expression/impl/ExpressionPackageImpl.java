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
package org.eclipse.efm.ecore.formalml.expression.impl;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;

import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;

import org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl;

import org.eclipse.efm.ecore.formalml.expression.ArithmeticAssociativeExpression;
import org.eclipse.efm.ecore.formalml.expression.ArithmeticUnaryExpression;
import org.eclipse.efm.ecore.formalml.expression.AssignmentExpression;
import org.eclipse.efm.ecore.formalml.expression.AssociativeExpression;
import org.eclipse.efm.ecore.formalml.expression.BinaryExpression;
import org.eclipse.efm.ecore.formalml.expression.BitwiseAssociativeExpression;
import org.eclipse.efm.ecore.formalml.expression.BitwiseUnaryExpression;
import org.eclipse.efm.ecore.formalml.expression.CastExpression;
import org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression;
import org.eclipse.efm.ecore.formalml.expression.EqualityBinaryExpression;
import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer;
import org.eclipse.efm.ecore.formalml.expression.ExpressionAsChannel;
import org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine;
import org.eclipse.efm.ecore.formalml.expression.ExpressionAsPort;
import org.eclipse.efm.ecore.formalml.expression.ExpressionFactory;
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression;
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPostfixExpression;
import org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPrefixExpression;
import org.eclipse.efm.ecore.formalml.expression.InstantiationExpression;
import org.eclipse.efm.ecore.formalml.expression.InvokeExpression;
import org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralAnyOrNoneValueExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralAnyValueExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralNoneValueExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralOptionalValueExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement;
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification;
import org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralTimeDeltaExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralTimeExpression;
import org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression;
import org.eclipse.efm.ecore.formalml.expression.LogicalUnaryExpression;
import org.eclipse.efm.ecore.formalml.expression.MixTupleExpression;
import org.eclipse.efm.ecore.formalml.expression.NamedExpression;
import org.eclipse.efm.ecore.formalml.expression.NamedTupleExpression;
import org.eclipse.efm.ecore.formalml.expression.NewfreshExpression;
import org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression;
import org.eclipse.efm.ecore.formalml.expression.QuantifiedLogicalExpression;
import org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression;
import org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression;
import org.eclipse.efm.ecore.formalml.expression.TupleExpression;
import org.eclipse.efm.ecore.formalml.expression.UnaryExpression;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme;
import org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter;
import org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression;

import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;

import org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl;

import org.eclipse.efm.ecore.formalml.statement.StatementPackage;

import org.eclipse.efm.ecore.formalml.statement.impl.StatementPackageImpl;

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
public class ExpressionPackageImpl extends EPackageImpl implements ExpressionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueExpressionPrettyPrinterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valuePrintableExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalBooleanExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalIntegerExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalRationalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalFloatExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalRealExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalCharacterExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalStringExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalCollectionExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalNullExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalAnyValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalOptionalValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalNoneValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalAnyOrNoneValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalReferenceExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalReferenceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalThisExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalSelfExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalParentExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalSuperExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalSystemExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEnvExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalTimeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalTimeDeltaExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leftHandSideExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incrementOrDecrementExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incrementOrDecrementPrefixExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incrementOrDecrementPostfixExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newfreshExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bitwiseUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass castExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arithmeticUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalityBinaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalBinaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalTernaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalTestExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arithmeticAssociativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bitwiseAssociativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalAssociativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quantifiedLogicalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mixTupleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedTupleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionalTupleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueElementSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instantiationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionAsBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionAsChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionAsMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionAsPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalReferenceSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum printeR_FIXEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum valueElementSpecificationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum valueElementSpecificationSchemeEEnum = null;

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
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpressionPackageImpl() {
		super(eNS_URI, ExpressionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExpressionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionPackage init() {
		if (isInited) return (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredExpressionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ExpressionPackageImpl theExpressionPackage = registeredExpressionPackage instanceof ExpressionPackageImpl ? (ExpressionPackageImpl)registeredExpressionPackage : new ExpressionPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypePackage.eNS_URI);
		DatatypePackageImpl theDatatypePackage = (DatatypePackageImpl)(registeredPackage instanceof DatatypePackageImpl ? registeredPackage : DatatypePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);
		InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl)(registeredPackage instanceof InfrastructurePackageImpl ? registeredPackage : InfrastructurePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI);
		StatementPackageImpl theStatementPackage = (StatementPackageImpl)(registeredPackage instanceof StatementPackageImpl ? registeredPackage : StatementPackage.eINSTANCE);

		// Create package meta-data objects
		theExpressionPackage.createPackageContents();
		theDatatypePackage.createPackageContents();
		theInfrastructurePackage.createPackageContents();
		theStatementPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionPackage.initializePackageContents();
		theDatatypePackage.initializePackageContents();
		theInfrastructurePackage.initializePackageContents();
		theStatementPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpressionPackage.eNS_URI, theExpressionPackage);
		return theExpressionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValueExpressionPrettyPrinter() {
		return valueExpressionPrettyPrinterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueExpressionPrettyPrinter_Symbol() {
		return (EAttribute)valueExpressionPrettyPrinterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueExpressionPrettyPrinter_Fix() {
		return (EAttribute)valueExpressionPrettyPrinterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueExpressionPrettyPrinter_Specific() {
		return (EAttribute)valueExpressionPrettyPrinterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValuePrintableExpression() {
		return valuePrintableExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValuePrintableExpression_Symbol() {
		return (EAttribute)valuePrintableExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValuePrintableExpression_Printer() {
		return (EReference)valuePrintableExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValuePrintableExpression_Operand() {
		return (EReference)valuePrintableExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralExpression() {
		return literalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralBooleanExpression() {
		return literalBooleanExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralBooleanExpression_Value() {
		return (EAttribute)literalBooleanExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralIntegerExpression() {
		return literalIntegerExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralIntegerExpression_Value() {
		return (EAttribute)literalIntegerExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralRationalExpression() {
		return literalRationalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralRationalExpression_Numerator() {
		return (EAttribute)literalRationalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralRationalExpression_Denominator() {
		return (EAttribute)literalRationalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralFloatExpression() {
		return literalFloatExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralFloatExpression_Value() {
		return (EAttribute)literalFloatExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralRealExpression() {
		return literalRealExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralRealExpression_Value() {
		return (EAttribute)literalRealExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralCharacterExpression() {
		return literalCharacterExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralCharacterExpression_Value() {
		return (EAttribute)literalCharacterExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralStringExpression() {
		return literalStringExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralStringExpression_Value() {
		return (EAttribute)literalStringExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralCollectionExpression() {
		return literalCollectionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralCollectionExpression_Datatype() {
		return (EReference)literalCollectionExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralCollectionExpression_Value() {
		return (EReference)literalCollectionExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralNullExpression() {
		return literalNullExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralNullExpression_Type() {
		return (EReference)literalNullExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralAnyValueExpression() {
		return literalAnyValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralAnyValueExpression_Type() {
		return (EReference)literalAnyValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralOptionalValueExpression() {
		return literalOptionalValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralOptionalValueExpression_Type() {
		return (EReference)literalOptionalValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralNoneValueExpression() {
		return literalNoneValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralNoneValueExpression_Type() {
		return (EReference)literalNoneValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralAnyOrNoneValueExpression() {
		return literalAnyOrNoneValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralAnyOrNoneValueExpression_Type() {
		return (EReference)literalAnyOrNoneValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralReferenceExpression() {
		return literalReferenceExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralReferenceElement() {
		return literalReferenceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralReferenceElement_Kind() {
		return (EAttribute)literalReferenceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralReferenceElement_Element() {
		return (EReference)literalReferenceElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralReferenceElement_Arg() {
		return (EReference)literalReferenceElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralThisExpression() {
		return literalThisExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralSelfExpression() {
		return literalSelfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralSelfExpression_Model() {
		return (EReference)literalSelfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralParentExpression() {
		return literalParentExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralParentExpression_Model() {
		return (EReference)literalParentExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralSuperExpression() {
		return literalSuperExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralSuperExpression_Model() {
		return (EReference)literalSuperExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralSystemExpression() {
		return literalSystemExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralEnvExpression() {
		return literalEnvExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralTimeExpression() {
		return literalTimeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralTimeDeltaExpression() {
		return literalTimeDeltaExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLeftHandSideExpression() {
		return leftHandSideExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLeftHandSideExpression_Lvalue() {
		return (EReference)leftHandSideExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIncrementOrDecrementExpression() {
		return incrementOrDecrementExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIncrementOrDecrementExpression_Operator() {
		return (EAttribute)incrementOrDecrementExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIncrementOrDecrementExpression_LeftHandSide() {
		return (EReference)incrementOrDecrementExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIncrementOrDecrementPrefixExpression() {
		return incrementOrDecrementPrefixExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIncrementOrDecrementPostfixExpression() {
		return incrementOrDecrementPostfixExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssignmentExpression() {
		return assignmentExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssignmentExpression_Operator() {
		return (EAttribute)assignmentExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssignmentExpression_LeftHandSide() {
		return (EReference)assignmentExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssignmentExpression_RightHandSide() {
		return (EReference)assignmentExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNewfreshExpression() {
		return newfreshExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNewfreshExpression_LeftHandSide() {
		return (EReference)newfreshExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnaryExpression_Operator() {
		return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnaryExpression_Operand() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBitwiseUnaryExpression() {
		return bitwiseUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLogicalUnaryExpression() {
		return logicalUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCastExpression() {
		return castExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCastExpression_Datatype() {
		return (EReference)castExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArithmeticUnaryExpression() {
		return arithmeticUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBinaryExpression() {
		return binaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBinaryExpression_Operator() {
		return (EAttribute)binaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryExpression_LeftOperand() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryExpression_RightOperand() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEqualityBinaryExpression() {
		return equalityBinaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationalBinaryExpression() {
		return relationalBinaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationalTernaryExpression() {
		return relationalTernaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationalTernaryExpression_LeftRelation() {
		return (EReference)relationalTernaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationalTernaryExpression_RightOperator() {
		return (EAttribute)relationalTernaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationalTernaryExpression_RightOperand() {
		return (EReference)relationalTernaryExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConditionalTestExpression() {
		return conditionalTestExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionalTestExpression_Condition() {
		return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConditionalTestExpression_Operator() {
		return (EAttribute)conditionalTestExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionalTestExpression_ThenOperand() {
		return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConditionalTestExpression_ElseSeparator() {
		return (EAttribute)conditionalTestExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionalTestExpression_ElseOperand() {
		return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssociativeExpression() {
		return associativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssociativeExpression_Operator() {
		return (EAttribute)associativeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssociativeExpression_Operand() {
		return (EReference)associativeExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArithmeticAssociativeExpression() {
		return arithmeticAssociativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBitwiseAssociativeExpression() {
		return bitwiseAssociativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLogicalAssociativeExpression() {
		return logicalAssociativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQuantifiedLogicalExpression() {
		return quantifiedLogicalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQuantifiedLogicalExpression_Quantifier() {
		return (EAttribute)quantifiedLogicalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQuantifiedLogicalExpression_Variable() {
		return (EReference)quantifiedLogicalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQuantifiedLogicalExpression_Predicate() {
		return (EReference)quantifiedLogicalExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInvokeExpression() {
		return invokeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInvokeExpression_CallProcedure() {
		return (EAttribute)invokeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInvokeExpression_Invokable() {
		return (EReference)invokeExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInvokeExpression_Args() {
		return (EReference)invokeExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInvokeExpression_Rets() {
		return (EReference)invokeExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedExpression() {
		return namedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedExpression_Target() {
		return (EReference)namedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNamedExpression_Name() {
		return (EAttribute)namedExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedExpression_Expression() {
		return (EReference)namedExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTupleExpression() {
		return tupleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMixTupleExpression() {
		return mixTupleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMixTupleExpression_Value() {
		return (EReference)mixTupleExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedTupleExpression() {
		return namedTupleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedTupleExpression_Value() {
		return (EReference)namedTupleExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPositionalTupleExpression() {
		return positionalTupleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPositionalTupleExpression_Value() {
		return (EReference)positionalTupleExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValueElementSpecification() {
		return valueElementSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueElementSpecification_Kind() {
		return (EAttribute)valueElementSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueElementSpecification_Expected() {
		return (EAttribute)valueElementSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValueElementSpecification_Parent() {
		return (EReference)valueElementSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValueElementSpecification_Element() {
		return (EReference)valueElementSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValueElementSpecification_Arg() {
		return (EReference)valueElementSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInstantiationExpression() {
		return instantiationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstantiationExpression_Instance() {
		return (EReference)instantiationExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpressionAsBuffer() {
		return expressionAsBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpressionAsBuffer_Buffer() {
		return (EReference)expressionAsBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpressionAsChannel() {
		return expressionAsChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpressionAsChannel_Channel() {
		return (EReference)expressionAsChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpressionAsMachine() {
		return expressionAsMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpressionAsMachine_Machine() {
		return (EReference)expressionAsMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpressionAsPort() {
		return expressionAsPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpressionAsPort_Port() {
		return (EReference)expressionAsPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralReferenceSpecification() {
		return literalReferenceSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralReferenceSpecification_Expected() {
		return (EAttribute)literalReferenceSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralReferenceSpecification_Parent() {
		return (EReference)literalReferenceSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralReferenceSpecification_Element() {
		return (EReference)literalReferenceSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPRINTER_FIX() {
		return printeR_FIXEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getValueElementSpecificationKind() {
		return valueElementSpecificationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getValueElementSpecificationScheme() {
		return valueElementSpecificationSchemeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionFactory getExpressionFactory() {
		return (ExpressionFactory)getEFactoryInstance();
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
		valueExpressionPrettyPrinterEClass = createEClass(VALUE_EXPRESSION_PRETTY_PRINTER);
		createEAttribute(valueExpressionPrettyPrinterEClass, VALUE_EXPRESSION_PRETTY_PRINTER__SYMBOL);
		createEAttribute(valueExpressionPrettyPrinterEClass, VALUE_EXPRESSION_PRETTY_PRINTER__FIX);
		createEAttribute(valueExpressionPrettyPrinterEClass, VALUE_EXPRESSION_PRETTY_PRINTER__SPECIFIC);

		valuePrintableExpressionEClass = createEClass(VALUE_PRINTABLE_EXPRESSION);
		createEAttribute(valuePrintableExpressionEClass, VALUE_PRINTABLE_EXPRESSION__SYMBOL);
		createEReference(valuePrintableExpressionEClass, VALUE_PRINTABLE_EXPRESSION__PRINTER);
		createEReference(valuePrintableExpressionEClass, VALUE_PRINTABLE_EXPRESSION__OPERAND);

		expressionEClass = createEClass(EXPRESSION);

		literalExpressionEClass = createEClass(LITERAL_EXPRESSION);

		literalBooleanExpressionEClass = createEClass(LITERAL_BOOLEAN_EXPRESSION);
		createEAttribute(literalBooleanExpressionEClass, LITERAL_BOOLEAN_EXPRESSION__VALUE);

		literalIntegerExpressionEClass = createEClass(LITERAL_INTEGER_EXPRESSION);
		createEAttribute(literalIntegerExpressionEClass, LITERAL_INTEGER_EXPRESSION__VALUE);

		literalRationalExpressionEClass = createEClass(LITERAL_RATIONAL_EXPRESSION);
		createEAttribute(literalRationalExpressionEClass, LITERAL_RATIONAL_EXPRESSION__NUMERATOR);
		createEAttribute(literalRationalExpressionEClass, LITERAL_RATIONAL_EXPRESSION__DENOMINATOR);

		literalFloatExpressionEClass = createEClass(LITERAL_FLOAT_EXPRESSION);
		createEAttribute(literalFloatExpressionEClass, LITERAL_FLOAT_EXPRESSION__VALUE);

		literalRealExpressionEClass = createEClass(LITERAL_REAL_EXPRESSION);
		createEAttribute(literalRealExpressionEClass, LITERAL_REAL_EXPRESSION__VALUE);

		literalCharacterExpressionEClass = createEClass(LITERAL_CHARACTER_EXPRESSION);
		createEAttribute(literalCharacterExpressionEClass, LITERAL_CHARACTER_EXPRESSION__VALUE);

		literalStringExpressionEClass = createEClass(LITERAL_STRING_EXPRESSION);
		createEAttribute(literalStringExpressionEClass, LITERAL_STRING_EXPRESSION__VALUE);

		literalCollectionExpressionEClass = createEClass(LITERAL_COLLECTION_EXPRESSION);
		createEReference(literalCollectionExpressionEClass, LITERAL_COLLECTION_EXPRESSION__DATATYPE);
		createEReference(literalCollectionExpressionEClass, LITERAL_COLLECTION_EXPRESSION__VALUE);

		literalNullExpressionEClass = createEClass(LITERAL_NULL_EXPRESSION);
		createEReference(literalNullExpressionEClass, LITERAL_NULL_EXPRESSION__TYPE);

		literalAnyValueExpressionEClass = createEClass(LITERAL_ANY_VALUE_EXPRESSION);
		createEReference(literalAnyValueExpressionEClass, LITERAL_ANY_VALUE_EXPRESSION__TYPE);

		literalOptionalValueExpressionEClass = createEClass(LITERAL_OPTIONAL_VALUE_EXPRESSION);
		createEReference(literalOptionalValueExpressionEClass, LITERAL_OPTIONAL_VALUE_EXPRESSION__TYPE);

		literalNoneValueExpressionEClass = createEClass(LITERAL_NONE_VALUE_EXPRESSION);
		createEReference(literalNoneValueExpressionEClass, LITERAL_NONE_VALUE_EXPRESSION__TYPE);

		literalAnyOrNoneValueExpressionEClass = createEClass(LITERAL_ANY_OR_NONE_VALUE_EXPRESSION);
		createEReference(literalAnyOrNoneValueExpressionEClass, LITERAL_ANY_OR_NONE_VALUE_EXPRESSION__TYPE);

		literalReferenceExpressionEClass = createEClass(LITERAL_REFERENCE_EXPRESSION);

		literalReferenceElementEClass = createEClass(LITERAL_REFERENCE_ELEMENT);
		createEAttribute(literalReferenceElementEClass, LITERAL_REFERENCE_ELEMENT__KIND);
		createEReference(literalReferenceElementEClass, LITERAL_REFERENCE_ELEMENT__ELEMENT);
		createEReference(literalReferenceElementEClass, LITERAL_REFERENCE_ELEMENT__ARG);

		literalThisExpressionEClass = createEClass(LITERAL_THIS_EXPRESSION);

		literalSelfExpressionEClass = createEClass(LITERAL_SELF_EXPRESSION);
		createEReference(literalSelfExpressionEClass, LITERAL_SELF_EXPRESSION__MODEL);

		literalParentExpressionEClass = createEClass(LITERAL_PARENT_EXPRESSION);
		createEReference(literalParentExpressionEClass, LITERAL_PARENT_EXPRESSION__MODEL);

		literalSuperExpressionEClass = createEClass(LITERAL_SUPER_EXPRESSION);
		createEReference(literalSuperExpressionEClass, LITERAL_SUPER_EXPRESSION__MODEL);

		literalSystemExpressionEClass = createEClass(LITERAL_SYSTEM_EXPRESSION);

		literalEnvExpressionEClass = createEClass(LITERAL_ENV_EXPRESSION);

		literalTimeExpressionEClass = createEClass(LITERAL_TIME_EXPRESSION);

		literalTimeDeltaExpressionEClass = createEClass(LITERAL_TIME_DELTA_EXPRESSION);

		leftHandSideExpressionEClass = createEClass(LEFT_HAND_SIDE_EXPRESSION);
		createEReference(leftHandSideExpressionEClass, LEFT_HAND_SIDE_EXPRESSION__LVALUE);

		incrementOrDecrementExpressionEClass = createEClass(INCREMENT_OR_DECREMENT_EXPRESSION);
		createEAttribute(incrementOrDecrementExpressionEClass, INCREMENT_OR_DECREMENT_EXPRESSION__OPERATOR);
		createEReference(incrementOrDecrementExpressionEClass, INCREMENT_OR_DECREMENT_EXPRESSION__LEFT_HAND_SIDE);

		incrementOrDecrementPrefixExpressionEClass = createEClass(INCREMENT_OR_DECREMENT_PREFIX_EXPRESSION);

		incrementOrDecrementPostfixExpressionEClass = createEClass(INCREMENT_OR_DECREMENT_POSTFIX_EXPRESSION);

		assignmentExpressionEClass = createEClass(ASSIGNMENT_EXPRESSION);
		createEAttribute(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__OPERATOR);
		createEReference(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE);
		createEReference(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE);

		newfreshExpressionEClass = createEClass(NEWFRESH_EXPRESSION);
		createEReference(newfreshExpressionEClass, NEWFRESH_EXPRESSION__LEFT_HAND_SIDE);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OPERATOR);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__OPERAND);

		bitwiseUnaryExpressionEClass = createEClass(BITWISE_UNARY_EXPRESSION);

		logicalUnaryExpressionEClass = createEClass(LOGICAL_UNARY_EXPRESSION);

		castExpressionEClass = createEClass(CAST_EXPRESSION);
		createEReference(castExpressionEClass, CAST_EXPRESSION__DATATYPE);

		arithmeticUnaryExpressionEClass = createEClass(ARITHMETIC_UNARY_EXPRESSION);

		binaryExpressionEClass = createEClass(BINARY_EXPRESSION);
		createEAttribute(binaryExpressionEClass, BINARY_EXPRESSION__OPERATOR);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__LEFT_OPERAND);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__RIGHT_OPERAND);

		equalityBinaryExpressionEClass = createEClass(EQUALITY_BINARY_EXPRESSION);

		relationalBinaryExpressionEClass = createEClass(RELATIONAL_BINARY_EXPRESSION);

		relationalTernaryExpressionEClass = createEClass(RELATIONAL_TERNARY_EXPRESSION);
		createEReference(relationalTernaryExpressionEClass, RELATIONAL_TERNARY_EXPRESSION__LEFT_RELATION);
		createEAttribute(relationalTernaryExpressionEClass, RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERATOR);
		createEReference(relationalTernaryExpressionEClass, RELATIONAL_TERNARY_EXPRESSION__RIGHT_OPERAND);

		conditionalTestExpressionEClass = createEClass(CONDITIONAL_TEST_EXPRESSION);
		createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__CONDITION);
		createEAttribute(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__OPERATOR);
		createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__THEN_OPERAND);
		createEAttribute(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__ELSE_SEPARATOR);
		createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__ELSE_OPERAND);

		associativeExpressionEClass = createEClass(ASSOCIATIVE_EXPRESSION);
		createEAttribute(associativeExpressionEClass, ASSOCIATIVE_EXPRESSION__OPERATOR);
		createEReference(associativeExpressionEClass, ASSOCIATIVE_EXPRESSION__OPERAND);

		arithmeticAssociativeExpressionEClass = createEClass(ARITHMETIC_ASSOCIATIVE_EXPRESSION);

		bitwiseAssociativeExpressionEClass = createEClass(BITWISE_ASSOCIATIVE_EXPRESSION);

		logicalAssociativeExpressionEClass = createEClass(LOGICAL_ASSOCIATIVE_EXPRESSION);

		quantifiedLogicalExpressionEClass = createEClass(QUANTIFIED_LOGICAL_EXPRESSION);
		createEAttribute(quantifiedLogicalExpressionEClass, QUANTIFIED_LOGICAL_EXPRESSION__QUANTIFIER);
		createEReference(quantifiedLogicalExpressionEClass, QUANTIFIED_LOGICAL_EXPRESSION__VARIABLE);
		createEReference(quantifiedLogicalExpressionEClass, QUANTIFIED_LOGICAL_EXPRESSION__PREDICATE);

		invokeExpressionEClass = createEClass(INVOKE_EXPRESSION);
		createEAttribute(invokeExpressionEClass, INVOKE_EXPRESSION__CALL_PROCEDURE);
		createEReference(invokeExpressionEClass, INVOKE_EXPRESSION__INVOKABLE);
		createEReference(invokeExpressionEClass, INVOKE_EXPRESSION__ARGS);
		createEReference(invokeExpressionEClass, INVOKE_EXPRESSION__RETS);

		namedExpressionEClass = createEClass(NAMED_EXPRESSION);
		createEReference(namedExpressionEClass, NAMED_EXPRESSION__TARGET);
		createEAttribute(namedExpressionEClass, NAMED_EXPRESSION__NAME);
		createEReference(namedExpressionEClass, NAMED_EXPRESSION__EXPRESSION);

		tupleExpressionEClass = createEClass(TUPLE_EXPRESSION);

		mixTupleExpressionEClass = createEClass(MIX_TUPLE_EXPRESSION);
		createEReference(mixTupleExpressionEClass, MIX_TUPLE_EXPRESSION__VALUE);

		namedTupleExpressionEClass = createEClass(NAMED_TUPLE_EXPRESSION);
		createEReference(namedTupleExpressionEClass, NAMED_TUPLE_EXPRESSION__VALUE);

		positionalTupleExpressionEClass = createEClass(POSITIONAL_TUPLE_EXPRESSION);
		createEReference(positionalTupleExpressionEClass, POSITIONAL_TUPLE_EXPRESSION__VALUE);

		valueElementSpecificationEClass = createEClass(VALUE_ELEMENT_SPECIFICATION);
		createEAttribute(valueElementSpecificationEClass, VALUE_ELEMENT_SPECIFICATION__KIND);
		createEAttribute(valueElementSpecificationEClass, VALUE_ELEMENT_SPECIFICATION__EXPECTED);
		createEReference(valueElementSpecificationEClass, VALUE_ELEMENT_SPECIFICATION__PARENT);
		createEReference(valueElementSpecificationEClass, VALUE_ELEMENT_SPECIFICATION__ELEMENT);
		createEReference(valueElementSpecificationEClass, VALUE_ELEMENT_SPECIFICATION__ARG);

		instantiationExpressionEClass = createEClass(INSTANTIATION_EXPRESSION);
		createEReference(instantiationExpressionEClass, INSTANTIATION_EXPRESSION__INSTANCE);

		expressionAsBufferEClass = createEClass(EXPRESSION_AS_BUFFER);
		createEReference(expressionAsBufferEClass, EXPRESSION_AS_BUFFER__BUFFER);

		expressionAsChannelEClass = createEClass(EXPRESSION_AS_CHANNEL);
		createEReference(expressionAsChannelEClass, EXPRESSION_AS_CHANNEL__CHANNEL);

		expressionAsMachineEClass = createEClass(EXPRESSION_AS_MACHINE);
		createEReference(expressionAsMachineEClass, EXPRESSION_AS_MACHINE__MACHINE);

		expressionAsPortEClass = createEClass(EXPRESSION_AS_PORT);
		createEReference(expressionAsPortEClass, EXPRESSION_AS_PORT__PORT);

		literalReferenceSpecificationEClass = createEClass(LITERAL_REFERENCE_SPECIFICATION);
		createEAttribute(literalReferenceSpecificationEClass, LITERAL_REFERENCE_SPECIFICATION__EXPECTED);
		createEReference(literalReferenceSpecificationEClass, LITERAL_REFERENCE_SPECIFICATION__PARENT);
		createEReference(literalReferenceSpecificationEClass, LITERAL_REFERENCE_SPECIFICATION__ELEMENT);

		// Create enums
		printeR_FIXEEnum = createEEnum(PRINTER_FIX);
		valueElementSpecificationKindEEnum = createEEnum(VALUE_ELEMENT_SPECIFICATION_KIND);
		valueElementSpecificationSchemeEEnum = createEEnum(VALUE_ELEMENT_SPECIFICATION_SCHEME);
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
		DatatypePackage theDatatypePackage = (DatatypePackage)EPackage.Registry.INSTANCE.getEPackage(DatatypePackage.eNS_URI);
		InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		valuePrintableExpressionEClass.getESuperTypes().add(this.getExpression());
		expressionEClass.getESuperTypes().add(theCommonPackage.getAbstractElement());
		literalExpressionEClass.getESuperTypes().add(this.getExpression());
		literalBooleanExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalIntegerExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalRationalExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalFloatExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalRealExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalCharacterExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalStringExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalCollectionExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalNullExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalAnyValueExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalOptionalValueExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalNoneValueExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalAnyOrNoneValueExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalReferenceExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
		literalReferenceElementEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		literalThisExpressionEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		literalSelfExpressionEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		literalParentExpressionEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		literalSuperExpressionEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		literalSystemExpressionEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		literalEnvExpressionEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		literalTimeExpressionEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		literalTimeDeltaExpressionEClass.getESuperTypes().add(this.getLiteralReferenceExpression());
		leftHandSideExpressionEClass.getESuperTypes().add(this.getExpression());
		incrementOrDecrementExpressionEClass.getESuperTypes().add(this.getExpression());
		incrementOrDecrementPrefixExpressionEClass.getESuperTypes().add(this.getIncrementOrDecrementExpression());
		incrementOrDecrementPostfixExpressionEClass.getESuperTypes().add(this.getIncrementOrDecrementExpression());
		assignmentExpressionEClass.getESuperTypes().add(this.getExpression());
		newfreshExpressionEClass.getESuperTypes().add(this.getExpression());
		unaryExpressionEClass.getESuperTypes().add(this.getExpression());
		bitwiseUnaryExpressionEClass.getESuperTypes().add(this.getUnaryExpression());
		logicalUnaryExpressionEClass.getESuperTypes().add(this.getUnaryExpression());
		castExpressionEClass.getESuperTypes().add(this.getUnaryExpression());
		arithmeticUnaryExpressionEClass.getESuperTypes().add(this.getUnaryExpression());
		binaryExpressionEClass.getESuperTypes().add(this.getExpression());
		equalityBinaryExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		relationalBinaryExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		relationalTernaryExpressionEClass.getESuperTypes().add(this.getExpression());
		conditionalTestExpressionEClass.getESuperTypes().add(this.getExpression());
		associativeExpressionEClass.getESuperTypes().add(this.getExpression());
		arithmeticAssociativeExpressionEClass.getESuperTypes().add(this.getAssociativeExpression());
		bitwiseAssociativeExpressionEClass.getESuperTypes().add(this.getAssociativeExpression());
		logicalAssociativeExpressionEClass.getESuperTypes().add(this.getAssociativeExpression());
		quantifiedLogicalExpressionEClass.getESuperTypes().add(this.getExpression());
		invokeExpressionEClass.getESuperTypes().add(this.getExpression());
		namedExpressionEClass.getESuperTypes().add(this.getExpression());
		tupleExpressionEClass.getESuperTypes().add(this.getExpression());
		mixTupleExpressionEClass.getESuperTypes().add(this.getTupleExpression());
		namedTupleExpressionEClass.getESuperTypes().add(this.getTupleExpression());
		positionalTupleExpressionEClass.getESuperTypes().add(this.getTupleExpression());
		valueElementSpecificationEClass.getESuperTypes().add(this.getExpression());
		instantiationExpressionEClass.getESuperTypes().add(this.getExpression());
		expressionAsBufferEClass.getESuperTypes().add(this.getExpression());
		expressionAsChannelEClass.getESuperTypes().add(this.getExpression());
		expressionAsMachineEClass.getESuperTypes().add(this.getExpression());
		expressionAsPortEClass.getESuperTypes().add(this.getExpression());
		literalReferenceSpecificationEClass.getESuperTypes().add(this.getExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(valueExpressionPrettyPrinterEClass, ValueExpressionPrettyPrinter.class, "ValueExpressionPrettyPrinter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueExpressionPrettyPrinter_Symbol(), ecorePackage.getEString(), "symbol", null, 1, 1, ValueExpressionPrettyPrinter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueExpressionPrettyPrinter_Fix(), this.getPRINTER_FIX(), "fix", null, 1, 1, ValueExpressionPrettyPrinter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueExpressionPrettyPrinter_Specific(), ecorePackage.getEString(), "specific", null, 0, -1, ValueExpressionPrettyPrinter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valuePrintableExpressionEClass, ValuePrintableExpression.class, "ValuePrintableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValuePrintableExpression_Symbol(), ecorePackage.getEString(), "symbol", null, 1, 1, ValuePrintableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValuePrintableExpression_Printer(), this.getValueExpressionPrettyPrinter(), null, "printer", null, 0, 1, ValuePrintableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValuePrintableExpression_Operand(), this.getExpression(), null, "operand", null, 0, -1, ValuePrintableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalExpressionEClass, LiteralExpression.class, "LiteralExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalBooleanExpressionEClass, LiteralBooleanExpression.class, "LiteralBooleanExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralBooleanExpression_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, LiteralBooleanExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalIntegerExpressionEClass, LiteralIntegerExpression.class, "LiteralIntegerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralIntegerExpression_Value(), ecorePackage.getELong(), "value", "0", 1, 1, LiteralIntegerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalRationalExpressionEClass, LiteralRationalExpression.class, "LiteralRationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralRationalExpression_Numerator(), ecorePackage.getELong(), "numerator", "0", 1, 1, LiteralRationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiteralRationalExpression_Denominator(), ecorePackage.getELong(), "denominator", "1", 1, 1, LiteralRationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalFloatExpressionEClass, LiteralFloatExpression.class, "LiteralFloatExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralFloatExpression_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, LiteralFloatExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalRealExpressionEClass, LiteralRealExpression.class, "LiteralRealExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralRealExpression_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, LiteralRealExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalCharacterExpressionEClass, LiteralCharacterExpression.class, "LiteralCharacterExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralCharacterExpression_Value(), ecorePackage.getEChar(), "value", "\'\\0\'", 0, 1, LiteralCharacterExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalStringExpressionEClass, LiteralStringExpression.class, "LiteralStringExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralStringExpression_Value(), ecorePackage.getEString(), "value", null, 1, 1, LiteralStringExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalCollectionExpressionEClass, LiteralCollectionExpression.class, "LiteralCollectionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralCollectionExpression_Datatype(), theDatatypePackage.getDataType(), null, "datatype", null, 0, 1, LiteralCollectionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLiteralCollectionExpression_Value(), this.getExpression(), null, "value", null, 0, -1, LiteralCollectionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalNullExpressionEClass, LiteralNullExpression.class, "LiteralNullExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralNullExpression_Type(), theDatatypePackage.getPrimitiveInstanceType(), null, "type", null, 0, 1, LiteralNullExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalAnyValueExpressionEClass, LiteralAnyValueExpression.class, "LiteralAnyValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralAnyValueExpression_Type(), theCommonPackage.getType(), null, "type", null, 0, 1, LiteralAnyValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalOptionalValueExpressionEClass, LiteralOptionalValueExpression.class, "LiteralOptionalValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralOptionalValueExpression_Type(), theCommonPackage.getType(), null, "type", null, 0, 1, LiteralOptionalValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalNoneValueExpressionEClass, LiteralNoneValueExpression.class, "LiteralNoneValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralNoneValueExpression_Type(), theCommonPackage.getType(), null, "type", null, 0, 1, LiteralNoneValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalAnyOrNoneValueExpressionEClass, LiteralAnyOrNoneValueExpression.class, "LiteralAnyOrNoneValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralAnyOrNoneValueExpression_Type(), theCommonPackage.getType(), null, "type", null, 0, 1, LiteralAnyOrNoneValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalReferenceExpressionEClass, LiteralReferenceExpression.class, "LiteralReferenceExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalReferenceElementEClass, LiteralReferenceElement.class, "LiteralReferenceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralReferenceElement_Kind(), this.getValueElementSpecificationKind(), "kind", "field", 1, 1, LiteralReferenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLiteralReferenceElement_Element(), theCommonPackage.getNamedElement(), null, "element", null, 0, 1, LiteralReferenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLiteralReferenceElement_Arg(), this.getExpression(), null, "arg", null, 0, 1, LiteralReferenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalThisExpressionEClass, LiteralThisExpression.class, "LiteralThisExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalSelfExpressionEClass, LiteralSelfExpression.class, "LiteralSelfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralSelfExpression_Model(), theInfrastructurePackage.getMachine(), null, "model", null, 0, 1, LiteralSelfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalParentExpressionEClass, LiteralParentExpression.class, "LiteralParentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralParentExpression_Model(), theInfrastructurePackage.getMachine(), null, "model", null, 0, 1, LiteralParentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalSuperExpressionEClass, LiteralSuperExpression.class, "LiteralSuperExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralSuperExpression_Model(), theInfrastructurePackage.getMachine(), null, "model", null, 0, 1, LiteralSuperExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalSystemExpressionEClass, LiteralSystemExpression.class, "LiteralSystemExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalEnvExpressionEClass, LiteralEnvExpression.class, "LiteralEnvExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalTimeExpressionEClass, LiteralTimeExpression.class, "LiteralTimeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalTimeDeltaExpressionEClass, LiteralTimeDeltaExpression.class, "LiteralTimeDeltaExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(leftHandSideExpressionEClass, LeftHandSideExpression.class, "LeftHandSideExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLeftHandSideExpression_Lvalue(), this.getExpression(), null, "lvalue", null, 0, 1, LeftHandSideExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(incrementOrDecrementExpressionEClass, IncrementOrDecrementExpression.class, "IncrementOrDecrementExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIncrementOrDecrementExpression_Operator(), ecorePackage.getEString(), "operator", null, 1, 1, IncrementOrDecrementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIncrementOrDecrementExpression_LeftHandSide(), this.getLeftHandSideExpression(), null, "leftHandSide", null, 1, 1, IncrementOrDecrementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(incrementOrDecrementPrefixExpressionEClass, IncrementOrDecrementPrefixExpression.class, "IncrementOrDecrementPrefixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(incrementOrDecrementPostfixExpressionEClass, IncrementOrDecrementPostfixExpression.class, "IncrementOrDecrementPostfixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentExpressionEClass, AssignmentExpression.class, "AssignmentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssignmentExpression_Operator(), ecorePackage.getEString(), "operator", null, 1, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignmentExpression_LeftHandSide(), this.getLeftHandSideExpression(), null, "leftHandSide", null, 1, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignmentExpression_RightHandSide(), this.getExpression(), null, "rightHandSide", null, 1, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newfreshExpressionEClass, NewfreshExpression.class, "NewfreshExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewfreshExpression_LeftHandSide(), this.getLeftHandSideExpression(), null, "leftHandSide", null, 1, 1, NewfreshExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryExpression_Operator(), ecorePackage.getEString(), "operator", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryExpression_Operand(), this.getExpression(), null, "operand", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bitwiseUnaryExpressionEClass, BitwiseUnaryExpression.class, "BitwiseUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicalUnaryExpressionEClass, LogicalUnaryExpression.class, "LogicalUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(castExpressionEClass, CastExpression.class, "CastExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCastExpression_Datatype(), theDatatypePackage.getDataType(), null, "datatype", null, 0, 1, CastExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arithmeticUnaryExpressionEClass, ArithmeticUnaryExpression.class, "ArithmeticUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryExpressionEClass, BinaryExpression.class, "BinaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryExpression_Operator(), ecorePackage.getEString(), "operator", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equalityBinaryExpressionEClass, EqualityBinaryExpression.class, "EqualityBinaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationalBinaryExpressionEClass, RelationalBinaryExpression.class, "RelationalBinaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationalTernaryExpressionEClass, RelationalTernaryExpression.class, "RelationalTernaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationalTernaryExpression_LeftRelation(), this.getRelationalBinaryExpression(), null, "leftRelation", null, 1, 1, RelationalTernaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationalTernaryExpression_RightOperator(), ecorePackage.getEString(), "rightOperator", null, 1, 1, RelationalTernaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationalTernaryExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 1, 1, RelationalTernaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalTestExpressionEClass, ConditionalTestExpression.class, "ConditionalTestExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionalTestExpression_Condition(), this.getExpression(), null, "condition", null, 1, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalTestExpression_Operator(), ecorePackage.getEString(), "operator", null, 1, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalTestExpression_ThenOperand(), this.getExpression(), null, "thenOperand", null, 1, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalTestExpression_ElseSeparator(), ecorePackage.getEString(), "elseSeparator", null, 1, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalTestExpression_ElseOperand(), this.getExpression(), null, "elseOperand", null, 1, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associativeExpressionEClass, AssociativeExpression.class, "AssociativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssociativeExpression_Operator(), ecorePackage.getEString(), "operator", null, 1, 1, AssociativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociativeExpression_Operand(), this.getExpression(), null, "operand", null, 0, -1, AssociativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arithmeticAssociativeExpressionEClass, ArithmeticAssociativeExpression.class, "ArithmeticAssociativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bitwiseAssociativeExpressionEClass, BitwiseAssociativeExpression.class, "BitwiseAssociativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicalAssociativeExpressionEClass, LogicalAssociativeExpression.class, "LogicalAssociativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quantifiedLogicalExpressionEClass, QuantifiedLogicalExpression.class, "QuantifiedLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuantifiedLogicalExpression_Quantifier(), ecorePackage.getEString(), "quantifier", "forall", 0, 1, QuantifiedLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuantifiedLogicalExpression_Variable(), theInfrastructurePackage.getVariable(), null, "variable", null, 1, -1, QuantifiedLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuantifiedLogicalExpression_Predicate(), this.getExpression(), null, "predicate", null, 0, 1, QuantifiedLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeExpressionEClass, InvokeExpression.class, "InvokeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvokeExpression_CallProcedure(), ecorePackage.getEBoolean(), "callProcedure", "false", 1, 1, InvokeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvokeExpression_Invokable(), this.getExpression(), null, "invokable", null, 0, 1, InvokeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvokeExpression_Args(), this.getExpression(), null, "args", null, 0, -1, InvokeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvokeExpression_Rets(), this.getExpression(), null, "rets", null, 0, -1, InvokeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedExpressionEClass, NamedExpression.class, "NamedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedExpression_Target(), theCommonPackage.getNamedElement(), null, "target", null, 0, 1, NamedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedExpression_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, NamedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tupleExpressionEClass, TupleExpression.class, "TupleExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mixTupleExpressionEClass, MixTupleExpression.class, "MixTupleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMixTupleExpression_Value(), this.getExpression(), null, "value", null, 0, -1, MixTupleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedTupleExpressionEClass, NamedTupleExpression.class, "NamedTupleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedTupleExpression_Value(), this.getNamedExpression(), null, "value", null, 0, -1, NamedTupleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(positionalTupleExpressionEClass, PositionalTupleExpression.class, "PositionalTupleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPositionalTupleExpression_Value(), this.getExpression(), null, "value", null, 0, -1, PositionalTupleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueElementSpecificationEClass, ValueElementSpecification.class, "ValueElementSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueElementSpecification_Kind(), this.getValueElementSpecificationKind(), "kind", "field", 1, 1, ValueElementSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueElementSpecification_Expected(), this.getValueElementSpecificationScheme(), "expected", "any", 1, 1, ValueElementSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValueElementSpecification_Parent(), this.getExpression(), null, "parent", null, 0, 1, ValueElementSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValueElementSpecification_Element(), theCommonPackage.getNamedElement(), null, "element", null, 0, 1, ValueElementSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValueElementSpecification_Arg(), this.getExpression(), null, "arg", null, 0, 1, ValueElementSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instantiationExpressionEClass, InstantiationExpression.class, "InstantiationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstantiationExpression_Instance(), theInfrastructurePackage.getInstanceMachine(), null, "instance", null, 0, 1, InstantiationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionAsBufferEClass, ExpressionAsBuffer.class, "ExpressionAsBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionAsBuffer_Buffer(), this.getExpression(), null, "buffer", null, 1, 1, ExpressionAsBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionAsChannelEClass, ExpressionAsChannel.class, "ExpressionAsChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionAsChannel_Channel(), this.getExpression(), null, "channel", null, 1, 1, ExpressionAsChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionAsMachineEClass, ExpressionAsMachine.class, "ExpressionAsMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionAsMachine_Machine(), this.getExpression(), null, "machine", null, 1, 1, ExpressionAsMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionAsPortEClass, ExpressionAsPort.class, "ExpressionAsPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionAsPort_Port(), this.getExpression(), null, "port", null, 1, 1, ExpressionAsPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalReferenceSpecificationEClass, LiteralReferenceSpecification.class, "LiteralReferenceSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralReferenceSpecification_Expected(), this.getValueElementSpecificationScheme(), "expected", "any", 1, 1, LiteralReferenceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLiteralReferenceSpecification_Parent(), this.getLiteralReferenceExpression(), null, "parent", null, 0, -1, LiteralReferenceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLiteralReferenceSpecification_Element(), this.getLiteralReferenceExpression(), null, "element", null, 0, 1, LiteralReferenceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(printeR_FIXEEnum, org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX.class, "PRINTER_FIX");
		addEEnumLiteral(printeR_FIXEEnum, org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX.INFIX);
		addEEnumLiteral(printeR_FIXEEnum, org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX.PREFIX);
		addEEnumLiteral(printeR_FIXEEnum, org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX.SUFFIX);
		addEEnumLiteral(printeR_FIXEEnum, org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX.FUNCTIONAL);
		addEEnumLiteral(printeR_FIXEEnum, org.eclipse.efm.ecore.formalml.expression.PRINTER_FIX.SPECIFIC);

		initEEnum(valueElementSpecificationKindEEnum, ValueElementSpecificationKind.class, "ValueElementSpecificationKind");
		addEEnumLiteral(valueElementSpecificationKindEEnum, ValueElementSpecificationKind.FIELD);
		addEEnumLiteral(valueElementSpecificationKindEEnum, ValueElementSpecificationKind.INDEX);
		addEEnumLiteral(valueElementSpecificationKindEEnum, ValueElementSpecificationKind.PARAMETER);
		addEEnumLiteral(valueElementSpecificationKindEEnum, ValueElementSpecificationKind.FUNCTION);

		initEEnum(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.class, "ValueElementSpecificationScheme");
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.ANY);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.VARIABLE);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.CONSTANT);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.TYPEDEF);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.MESSAGE);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.SIGNAL);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.BUFFER);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.CHANNEL);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.PORT);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.FUNCTION);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.COM_POINT);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.INSTANCE);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.MACHINE);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.MODEL);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.PROCEDURE);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.ROUTINE);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.VERTEX);
		addEEnumLiteral(valueElementSpecificationSchemeEEnum, ValueElementSpecificationScheme.COMPOSITE);

		// Create resource
		createResource(eNS_URI);
	}

} //ExpressionPackageImpl
