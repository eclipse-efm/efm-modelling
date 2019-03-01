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
package org.eclipse.efm.ecore.formalml.impl;

import org.eclipse.efm.ecore.formalml.FormalmlFactory;
import org.eclipse.efm.ecore.formalml.FormalmlPackage;
import org.eclipse.efm.ecore.formalml.XliaAttribute;
import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.ecore.formalml.XliaModelKind;
import org.eclipse.efm.ecore.formalml.XliaNamedElement;
import org.eclipse.efm.ecore.formalml.XliaObject;
import org.eclipse.efm.ecore.formalml.XliaSection;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;

import org.eclipse.efm.ecore.formalml.common.impl.CommonPackageImpl;

import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;

import org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl;

import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;

import org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl;

import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;

import org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl;

import org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage;

import org.eclipse.efm.ecore.formalml.statemachine.impl.StatemachinePackageImpl;

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
public class FormalmlPackageImpl extends EPackageImpl implements FormalmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xliaModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xliaNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xliaObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xliaSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xliaAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum xliaModelKindEEnum = null;

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
	 * @see org.eclipse.efm.ecore.formalml.FormalmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FormalmlPackageImpl() {
		super(eNS_URI, FormalmlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FormalmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FormalmlPackage init() {
		if (isInited) return (FormalmlPackage)EPackage.Registry.INSTANCE.getEPackage(FormalmlPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFormalmlPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FormalmlPackageImpl theFormalmlPackage = registeredFormalmlPackage instanceof FormalmlPackageImpl ? (FormalmlPackageImpl)registeredFormalmlPackage : new FormalmlPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(registeredPackage instanceof CommonPackageImpl ? registeredPackage : CommonPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);
		InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl)(registeredPackage instanceof InfrastructurePackageImpl ? registeredPackage : InfrastructurePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypePackage.eNS_URI);
		DatatypePackageImpl theDatatypePackage = (DatatypePackageImpl)(registeredPackage instanceof DatatypePackageImpl ? registeredPackage : DatatypePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(registeredPackage instanceof ExpressionPackageImpl ? registeredPackage : ExpressionPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI);
		StatementPackageImpl theStatementPackage = (StatementPackageImpl)(registeredPackage instanceof StatementPackageImpl ? registeredPackage : StatementPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(StatemachinePackage.eNS_URI);
		StatemachinePackageImpl theStatemachinePackage = (StatemachinePackageImpl)(registeredPackage instanceof StatemachinePackageImpl ? registeredPackage : StatemachinePackage.eINSTANCE);

		// Create package meta-data objects
		theFormalmlPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theInfrastructurePackage.createPackageContents();
		theDatatypePackage.createPackageContents();
		theExpressionPackage.createPackageContents();
		theStatementPackage.createPackageContents();
		theStatemachinePackage.createPackageContents();

		// Initialize created meta-data
		theFormalmlPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theInfrastructurePackage.initializePackageContents();
		theDatatypePackage.initializePackageContents();
		theExpressionPackage.initializePackageContents();
		theStatementPackage.initializePackageContents();
		theStatemachinePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFormalmlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FormalmlPackage.eNS_URI, theFormalmlPackage);
		return theFormalmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXliaModel() {
		return xliaModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXliaModel_Prolog() {
		return (EReference)xliaModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXliaModel_System() {
		return (EReference)xliaModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXliaNamedElement() {
		return xliaNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXliaNamedElement_Name() {
		return (EAttribute)xliaNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXliaObject() {
		return xliaObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXliaObject_Elements() {
		return (EReference)xliaObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXliaSection() {
		return xliaSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXliaSection_Elements() {
		return (EReference)xliaSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXliaAttribute() {
		return xliaAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXliaAttribute_Value() {
		return (EReference)xliaAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getXliaModelKind() {
		return xliaModelKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FormalmlFactory getFormalmlFactory() {
		return (FormalmlFactory)getEFactoryInstance();
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
		xliaModelEClass = createEClass(XLIA_MODEL);
		createEReference(xliaModelEClass, XLIA_MODEL__PROLOG);
		createEReference(xliaModelEClass, XLIA_MODEL__SYSTEM);

		xliaNamedElementEClass = createEClass(XLIA_NAMED_ELEMENT);
		createEAttribute(xliaNamedElementEClass, XLIA_NAMED_ELEMENT__NAME);

		xliaObjectEClass = createEClass(XLIA_OBJECT);
		createEReference(xliaObjectEClass, XLIA_OBJECT__ELEMENTS);

		xliaSectionEClass = createEClass(XLIA_SECTION);
		createEReference(xliaSectionEClass, XLIA_SECTION__ELEMENTS);

		xliaAttributeEClass = createEClass(XLIA_ATTRIBUTE);
		createEReference(xliaAttributeEClass, XLIA_ATTRIBUTE__VALUE);

		// Create enums
		xliaModelKindEEnum = createEEnum(XLIA_MODEL_KIND);
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
		InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);
		DatatypePackage theDatatypePackage = (DatatypePackage)EPackage.Registry.INSTANCE.getEPackage(DatatypePackage.eNS_URI);
		ExpressionPackage theExpressionPackage = (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);
		StatementPackage theStatementPackage = (StatementPackage)EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI);
		StatemachinePackage theStatemachinePackage = (StatemachinePackage)EPackage.Registry.INSTANCE.getEPackage(StatemachinePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCommonPackage);
		getESubpackages().add(theInfrastructurePackage);
		getESubpackages().add(theDatatypePackage);
		getESubpackages().add(theExpressionPackage);
		getESubpackages().add(theStatementPackage);
		getESubpackages().add(theStatemachinePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xliaObjectEClass.getESuperTypes().add(this.getXliaNamedElement());
		xliaSectionEClass.getESuperTypes().add(this.getXliaNamedElement());
		xliaAttributeEClass.getESuperTypes().add(this.getXliaNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(xliaModelEClass, XliaModel.class, "XliaModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXliaModel_Prolog(), this.getXliaObject(), null, "prolog", null, 1, 1, XliaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXliaModel_System(), theInfrastructurePackage.getXliaSystem(), null, "system", null, 1, 1, XliaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xliaNamedElementEClass, XliaNamedElement.class, "XliaNamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXliaNamedElement_Name(), ecorePackage.getEString(), "name", "1.0", 0, 1, XliaNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xliaObjectEClass, XliaObject.class, "XliaObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXliaObject_Elements(), this.getXliaNamedElement(), null, "elements", null, 0, -1, XliaObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xliaSectionEClass, XliaSection.class, "XliaSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXliaSection_Elements(), this.getXliaAttribute(), null, "elements", null, 0, -1, XliaSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xliaAttributeEClass, XliaAttribute.class, "XliaAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXliaAttribute_Value(), theExpressionPackage.getExpression(), null, "value", null, 0, 1, XliaAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(xliaModelKindEEnum, XliaModelKind.class, "XliaModelKind");
		addEEnumLiteral(xliaModelKindEEnum, XliaModelKind.SYSTEM);
		addEEnumLiteral(xliaModelKindEEnum, XliaModelKind.PACKAGE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //FormalmlPackageImpl
