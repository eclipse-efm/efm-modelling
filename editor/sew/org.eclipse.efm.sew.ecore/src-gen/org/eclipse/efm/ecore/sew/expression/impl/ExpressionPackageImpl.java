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

import org.eclipse.efm.ecore.sew.SewPackage;

import org.eclipse.efm.ecore.sew.expression.Expression;
import org.eclipse.efm.ecore.sew.expression.ExpressionFactory;
import org.eclipse.efm.ecore.sew.expression.ExpressionPackage;
import org.eclipse.efm.ecore.sew.expression.LiteralArrayValue;
import org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue;
import org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue;
import org.eclipse.efm.ecore.sew.expression.LiteralEnvInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralExpressionValue;
import org.eclipse.efm.ecore.sew.expression.LiteralFloatValue;
import org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue;
import org.eclipse.efm.ecore.sew.expression.LiteralNullValue;
import org.eclipse.efm.ecore.sew.expression.LiteralObjectReference;
import org.eclipse.efm.ecore.sew.expression.LiteralParentInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralRationalValue;
import org.eclipse.efm.ecore.sew.expression.LiteralRealValue;
import org.eclipse.efm.ecore.sew.expression.LiteralReferenceValue;
import org.eclipse.efm.ecore.sew.expression.LiteralSelfInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralStringValue;
import org.eclipse.efm.ecore.sew.expression.LiteralSuperInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralSystemInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralThisInstance;
import org.eclipse.efm.ecore.sew.expression.LiteralTimeDeltaVariable;
import org.eclipse.efm.ecore.sew.expression.LiteralTimeVariable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpressionValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalArrayValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalIntegerValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalBooleanValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalCharacterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalRationalValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalStringValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalNullValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalFloatValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalRealValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalReferenceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalObjectReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalThisInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalSelfInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalParentInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalSuperInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalSystemInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEnvInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalTimeVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalTimeDeltaVariableEClass = null;

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
	 * @see org.eclipse.efm.ecore.sew.expression.ExpressionPackage#eNS_URI
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
		SewPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExpressionPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionPackage.initializePackageContents();

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
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExpression_Operator() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpression_Operand() {
		return (EReference)expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralExpressionValue() {
		return literalExpressionValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralArrayValue() {
		return literalArrayValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralArrayValue_Values() {
		return (EReference)literalArrayValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralIntegerValue() {
		return literalIntegerValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralIntegerValue_Value() {
		return (EAttribute)literalIntegerValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralBooleanValue() {
		return literalBooleanValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralBooleanValue_Value() {
		return (EAttribute)literalBooleanValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralCharacterValue() {
		return literalCharacterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralCharacterValue_Value() {
		return (EAttribute)literalCharacterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralRationalValue() {
		return literalRationalValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralRationalValue_Numerator() {
		return (EAttribute)literalRationalValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralRationalValue_Denominator() {
		return (EAttribute)literalRationalValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralStringValue() {
		return literalStringValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralStringValue_Value() {
		return (EAttribute)literalStringValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralNullValue() {
		return literalNullValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralNullValue_Type() {
		return (EAttribute)literalNullValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralFloatValue() {
		return literalFloatValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralFloatValue_Value() {
		return (EAttribute)literalFloatValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralRealValue() {
		return literalRealValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralRealValue_Value() {
		return (EAttribute)literalRealValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralReferenceValue() {
		return literalReferenceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralReferenceValue_Symbol() {
		return (EAttribute)literalReferenceValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralObjectReference() {
		return literalObjectReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralObjectReference_Object() {
		return (EReference)literalObjectReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralThisInstance() {
		return literalThisInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralSelfInstance() {
		return literalSelfInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralParentInstance() {
		return literalParentInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralSuperInstance() {
		return literalSuperInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralSystemInstance() {
		return literalSystemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralEnvInstance() {
		return literalEnvInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralTimeVariable() {
		return literalTimeVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralTimeDeltaVariable() {
		return literalTimeDeltaVariableEClass;
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
		expressionEClass = createEClass(EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__OPERATOR);
		createEReference(expressionEClass, EXPRESSION__OPERAND);

		literalExpressionValueEClass = createEClass(LITERAL_EXPRESSION_VALUE);

		literalArrayValueEClass = createEClass(LITERAL_ARRAY_VALUE);
		createEReference(literalArrayValueEClass, LITERAL_ARRAY_VALUE__VALUES);

		literalIntegerValueEClass = createEClass(LITERAL_INTEGER_VALUE);
		createEAttribute(literalIntegerValueEClass, LITERAL_INTEGER_VALUE__VALUE);

		literalBooleanValueEClass = createEClass(LITERAL_BOOLEAN_VALUE);
		createEAttribute(literalBooleanValueEClass, LITERAL_BOOLEAN_VALUE__VALUE);

		literalCharacterValueEClass = createEClass(LITERAL_CHARACTER_VALUE);
		createEAttribute(literalCharacterValueEClass, LITERAL_CHARACTER_VALUE__VALUE);

		literalRationalValueEClass = createEClass(LITERAL_RATIONAL_VALUE);
		createEAttribute(literalRationalValueEClass, LITERAL_RATIONAL_VALUE__NUMERATOR);
		createEAttribute(literalRationalValueEClass, LITERAL_RATIONAL_VALUE__DENOMINATOR);

		literalStringValueEClass = createEClass(LITERAL_STRING_VALUE);
		createEAttribute(literalStringValueEClass, LITERAL_STRING_VALUE__VALUE);

		literalNullValueEClass = createEClass(LITERAL_NULL_VALUE);
		createEAttribute(literalNullValueEClass, LITERAL_NULL_VALUE__TYPE);

		literalFloatValueEClass = createEClass(LITERAL_FLOAT_VALUE);
		createEAttribute(literalFloatValueEClass, LITERAL_FLOAT_VALUE__VALUE);

		literalRealValueEClass = createEClass(LITERAL_REAL_VALUE);
		createEAttribute(literalRealValueEClass, LITERAL_REAL_VALUE__VALUE);

		literalReferenceValueEClass = createEClass(LITERAL_REFERENCE_VALUE);
		createEAttribute(literalReferenceValueEClass, LITERAL_REFERENCE_VALUE__SYMBOL);

		literalObjectReferenceEClass = createEClass(LITERAL_OBJECT_REFERENCE);
		createEReference(literalObjectReferenceEClass, LITERAL_OBJECT_REFERENCE__OBJECT);

		literalThisInstanceEClass = createEClass(LITERAL_THIS_INSTANCE);

		literalSelfInstanceEClass = createEClass(LITERAL_SELF_INSTANCE);

		literalParentInstanceEClass = createEClass(LITERAL_PARENT_INSTANCE);

		literalSuperInstanceEClass = createEClass(LITERAL_SUPER_INSTANCE);

		literalSystemInstanceEClass = createEClass(LITERAL_SYSTEM_INSTANCE);

		literalEnvInstanceEClass = createEClass(LITERAL_ENV_INSTANCE);

		literalTimeVariableEClass = createEClass(LITERAL_TIME_VARIABLE);

		literalTimeDeltaVariableEClass = createEClass(LITERAL_TIME_DELTA_VARIABLE);
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
		SewPackage theSewPackage = (SewPackage)EPackage.Registry.INSTANCE.getEPackage(SewPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		expressionEClass.getESuperTypes().add(theSewPackage.getWValueSpecification());
		literalExpressionValueEClass.getESuperTypes().add(theSewPackage.getWValueSpecification());
		literalArrayValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalIntegerValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalBooleanValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalCharacterValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalRationalValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalStringValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalNullValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalFloatValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalRealValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalReferenceValueEClass.getESuperTypes().add(this.getLiteralExpressionValue());
		literalObjectReferenceEClass.getESuperTypes().add(this.getLiteralReferenceValue());
		literalThisInstanceEClass.getESuperTypes().add(this.getLiteralReferenceValue());
		literalSelfInstanceEClass.getESuperTypes().add(this.getLiteralReferenceValue());
		literalParentInstanceEClass.getESuperTypes().add(this.getLiteralReferenceValue());
		literalSuperInstanceEClass.getESuperTypes().add(this.getLiteralReferenceValue());
		literalSystemInstanceEClass.getESuperTypes().add(this.getLiteralReferenceValue());
		literalEnvInstanceEClass.getESuperTypes().add(this.getLiteralReferenceValue());
		literalTimeVariableEClass.getESuperTypes().add(this.getLiteralReferenceValue());
		literalTimeDeltaVariableEClass.getESuperTypes().add(this.getLiteralReferenceValue());

		// Initialize classes, features, and operations; add parameters
		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpression_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpression_Operand(), theSewPackage.getWValueSpecification(), null, "operand", null, 0, -1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalExpressionValueEClass, LiteralExpressionValue.class, "LiteralExpressionValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalArrayValueEClass, LiteralArrayValue.class, "LiteralArrayValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralArrayValue_Values(), theSewPackage.getWValueSpecification(), null, "values", null, 0, -1, LiteralArrayValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalIntegerValueEClass, LiteralIntegerValue.class, "LiteralIntegerValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralIntegerValue_Value(), ecorePackage.getELong(), "value", "0", 1, 1, LiteralIntegerValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalBooleanValueEClass, LiteralBooleanValue.class, "LiteralBooleanValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralBooleanValue_Value(), ecorePackage.getEBoolean(), "value", "false", 1, 1, LiteralBooleanValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalCharacterValueEClass, LiteralCharacterValue.class, "LiteralCharacterValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralCharacterValue_Value(), ecorePackage.getEChar(), "value", "0", 1, 1, LiteralCharacterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalRationalValueEClass, LiteralRationalValue.class, "LiteralRationalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralRationalValue_Numerator(), ecorePackage.getELong(), "numerator", "0", 1, 1, LiteralRationalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiteralRationalValue_Denominator(), ecorePackage.getELong(), "denominator", "1", 1, 1, LiteralRationalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalStringValueEClass, LiteralStringValue.class, "LiteralStringValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralStringValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, LiteralStringValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalNullValueEClass, LiteralNullValue.class, "LiteralNullValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralNullValue_Type(), ecorePackage.getEString(), "type", null, 0, 1, LiteralNullValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalFloatValueEClass, LiteralFloatValue.class, "LiteralFloatValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralFloatValue_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, LiteralFloatValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalRealValueEClass, LiteralRealValue.class, "LiteralRealValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralRealValue_Value(), ecorePackage.getEBigDecimal(), "value", null, 1, 1, LiteralRealValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalReferenceValueEClass, LiteralReferenceValue.class, "LiteralReferenceValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralReferenceValue_Symbol(), ecorePackage.getEString(), "symbol", null, 0, 1, LiteralReferenceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalObjectReferenceEClass, LiteralObjectReference.class, "LiteralObjectReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralObjectReference_Object(), theSewPackage.getWObject(), null, "object", null, 0, 1, LiteralObjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalThisInstanceEClass, LiteralThisInstance.class, "LiteralThisInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalSelfInstanceEClass, LiteralSelfInstance.class, "LiteralSelfInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalParentInstanceEClass, LiteralParentInstance.class, "LiteralParentInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalSuperInstanceEClass, LiteralSuperInstance.class, "LiteralSuperInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalSystemInstanceEClass, LiteralSystemInstance.class, "LiteralSystemInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalEnvInstanceEClass, LiteralEnvInstance.class, "LiteralEnvInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalTimeVariableEClass, LiteralTimeVariable.class, "LiteralTimeVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalTimeDeltaVariableEClass, LiteralTimeDeltaVariable.class, "LiteralTimeDeltaVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ExpressionPackageImpl
