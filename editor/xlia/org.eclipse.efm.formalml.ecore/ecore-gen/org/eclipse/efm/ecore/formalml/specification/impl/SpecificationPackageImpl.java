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
package org.eclipse.efm.ecore.formalml.specification.impl;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;
import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.specification.SpecificationFactory;
import org.eclipse.efm.ecore.formalml.specification.SpecificationPackage;
import org.eclipse.efm.ecore.formalml.specification.XliaAttribute;
import org.eclipse.efm.ecore.formalml.specification.XliaModel;
import org.eclipse.efm.ecore.formalml.specification.XliaModelKind;
import org.eclipse.efm.ecore.formalml.specification.XliaNamedElement;
import org.eclipse.efm.ecore.formalml.specification.XliaObject;
import org.eclipse.efm.ecore.formalml.specification.XliaSection;
import org.eclipse.efm.ecore.formalml.statement.StatementPackage;
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
public class SpecificationPackageImpl extends EPackageImpl implements SpecificationPackage {
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
	 * @see org.eclipse.efm.ecore.formalml.specification.SpecificationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpecificationPackageImpl() {
		super(eNS_URI, SpecificationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SpecificationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SpecificationPackage init() {
		if (isInited) return (SpecificationPackage)EPackage.Registry.INSTANCE.getEPackage(SpecificationPackage.eNS_URI);

		// Obtain or create and register package
		final Object registeredSpecificationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		final SpecificationPackageImpl theSpecificationPackage = registeredSpecificationPackage instanceof SpecificationPackageImpl ? (SpecificationPackageImpl)registeredSpecificationPackage : new SpecificationPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		DatatypePackage.eINSTANCE.eClass();
		ExpressionPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		StatementPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSpecificationPackage.createPackageContents();

		// Initialize created meta-data
		theSpecificationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpecificationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SpecificationPackage.eNS_URI, theSpecificationPackage);
		return theSpecificationPackage;
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
	public SpecificationFactory getSpecificationFactory() {
		return (SpecificationFactory)getEFactoryInstance();
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
		final InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);
		final ExpressionPackage theExpressionPackage = (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);

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
		initEReference(getXliaAttribute_Value(), theExpressionPackage.getExpression(), null, "value", null, 1, 1, XliaAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(xliaModelKindEEnum, XliaModelKind.class, "XliaModelKind");
		addEEnumLiteral(xliaModelKindEEnum, XliaModelKind.SYSTEM);
		addEEnumLiteral(xliaModelKindEEnum, XliaModelKind.PACKAGE);

		// Create resource
		createResource(eNS_URI);
	}

} //SpecificationPackageImpl
