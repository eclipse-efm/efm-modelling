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
package org.eclipse.efm.ecore.formalml.datatype.impl;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;

import org.eclipse.efm.ecore.formalml.datatype.ChoiceType;
import org.eclipse.efm.ecore.formalml.datatype.CollectionKind;
import org.eclipse.efm.ecore.formalml.datatype.CollectionType;
import org.eclipse.efm.ecore.formalml.datatype.DataStructuredType;
import org.eclipse.efm.ecore.formalml.datatype.DataSupportedType;
import org.eclipse.efm.ecore.formalml.datatype.DataType;
import org.eclipse.efm.ecore.formalml.datatype.DataTypeReference;
import org.eclipse.efm.ecore.formalml.datatype.DatatypeFactory;
import org.eclipse.efm.ecore.formalml.datatype.DatatypePackage;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType;
import org.eclipse.efm.ecore.formalml.datatype.IntervalType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveBooleanType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveCharacterType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveFloatType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveIntegerType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRationalType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRealType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind;
import org.eclipse.efm.ecore.formalml.datatype.StructureType;
import org.eclipse.efm.ecore.formalml.datatype.UnionType;

import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;

import org.eclipse.efm.ecore.formalml.expression.impl.ExpressionPackageImpl;

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
public class DatatypePackageImpl extends EPackageImpl implements DatatypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStructuredTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSupportedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveBooleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveNumberTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveIntegerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveRationalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveFloatTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveRealTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTimeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveCharacterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveInstanceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveTypeKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum collectionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveNumberSignEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveInstanceKindEEnum = null;

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
	 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatatypePackageImpl() {
		super(eNS_URI, DatatypeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DatatypePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatatypePackage init() {
		if (isInited) return (DatatypePackage)EPackage.Registry.INSTANCE.getEPackage(DatatypePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDatatypePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DatatypePackageImpl theDatatypePackage = registeredDatatypePackage instanceof DatatypePackageImpl ? (DatatypePackageImpl)registeredDatatypePackage : new DatatypePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(registeredPackage instanceof ExpressionPackageImpl ? registeredPackage : ExpressionPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);
		InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl)(registeredPackage instanceof InfrastructurePackageImpl ? registeredPackage : InfrastructurePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI);
		StatementPackageImpl theStatementPackage = (StatementPackageImpl)(registeredPackage instanceof StatementPackageImpl ? registeredPackage : StatementPackage.eINSTANCE);

		// Create package meta-data objects
		theDatatypePackage.createPackageContents();
		theExpressionPackage.createPackageContents();
		theInfrastructurePackage.createPackageContents();
		theStatementPackage.createPackageContents();

		// Initialize created meta-data
		theDatatypePackage.initializePackageContents();
		theExpressionPackage.initializePackageContents();
		theInfrastructurePackage.initializePackageContents();
		theStatementPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDatatypePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatatypePackage.eNS_URI, theDatatypePackage);
		return theDatatypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataType_Kind() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataType_Typedef() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataType_Multiplicity() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataType_DefaultValue() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataType_Constraint() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataTypeReference() {
		return dataTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataTypeReference_Typeref() {
		return (EReference)dataTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataTypeReference_Support() {
		return (EReference)dataTypeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumerationLiteral() {
		return enumerationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumerationLiteral_Value() {
		return (EReference)enumerationLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumerationType() {
		return enumerationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumerationType_Literal() {
		return (EReference)enumerationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumerationType_SuperType() {
		return (EReference)enumerationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataStructuredType() {
		return dataStructuredTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataStructuredType_Property() {
		return (EReference)dataStructuredTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructureType() {
		return structureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnionType() {
		return unionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChoiceType() {
		return choiceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataSupportedType() {
		return dataSupportedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSupportedType_Support() {
		return (EReference)dataSupportedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntervalType() {
		return intervalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntervalType_Lopen() {
		return (EAttribute)intervalTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntervalType_Ropen() {
		return (EAttribute)intervalTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntervalType_Infimum() {
		return (EReference)intervalTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntervalType_Supremum() {
		return (EReference)intervalTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionType() {
		return collectionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollectionType_Container() {
		return (EAttribute)collectionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollectionType_Size() {
		return (EAttribute)collectionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollectionType_Unbounded() {
		return (EAttribute)collectionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveBooleanType() {
		return primitiveBooleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveNumberType() {
		return primitiveNumberTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrimitiveNumberType_Sign() {
		return (EAttribute)primitiveNumberTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrimitiveNumberType_Size() {
		return (EAttribute)primitiveNumberTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveIntegerType() {
		return primitiveIntegerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveRationalType() {
		return primitiveRationalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveFloatType() {
		return primitiveFloatTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveRealType() {
		return primitiveRealTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveTimeType() {
		return primitiveTimeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrimitiveTimeType_Clock() {
		return (EAttribute)primitiveTimeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrimitiveTimeType_Support() {
		return (EReference)primitiveTimeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveCharacterType() {
		return primitiveCharacterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveStringType() {
		return primitiveStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrimitiveStringType_Size() {
		return (EAttribute)primitiveStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveInstanceType() {
		return primitiveInstanceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrimitiveInstanceType_Expected() {
		return (EAttribute)primitiveInstanceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrimitiveInstanceType_Model() {
		return (EReference)primitiveInstanceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPrimitiveTypeKind() {
		return primitiveTypeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCollectionKind() {
		return collectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPrimitiveNumberSign() {
		return primitiveNumberSignEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPrimitiveInstanceKind() {
		return primitiveInstanceKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatatypeFactory getDatatypeFactory() {
		return (DatatypeFactory)getEFactoryInstance();
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
		dataTypeEClass = createEClass(DATA_TYPE);
		createEAttribute(dataTypeEClass, DATA_TYPE__KIND);
		createEAttribute(dataTypeEClass, DATA_TYPE__TYPEDEF);
		createEReference(dataTypeEClass, DATA_TYPE__MULTIPLICITY);
		createEReference(dataTypeEClass, DATA_TYPE__DEFAULT_VALUE);
		createEReference(dataTypeEClass, DATA_TYPE__CONSTRAINT);

		dataTypeReferenceEClass = createEClass(DATA_TYPE_REFERENCE);
		createEReference(dataTypeReferenceEClass, DATA_TYPE_REFERENCE__TYPEREF);
		createEReference(dataTypeReferenceEClass, DATA_TYPE_REFERENCE__SUPPORT);

		enumerationLiteralEClass = createEClass(ENUMERATION_LITERAL);
		createEReference(enumerationLiteralEClass, ENUMERATION_LITERAL__VALUE);

		enumerationTypeEClass = createEClass(ENUMERATION_TYPE);
		createEReference(enumerationTypeEClass, ENUMERATION_TYPE__LITERAL);
		createEReference(enumerationTypeEClass, ENUMERATION_TYPE__SUPER_TYPE);

		dataStructuredTypeEClass = createEClass(DATA_STRUCTURED_TYPE);
		createEReference(dataStructuredTypeEClass, DATA_STRUCTURED_TYPE__PROPERTY);

		structureTypeEClass = createEClass(STRUCTURE_TYPE);

		unionTypeEClass = createEClass(UNION_TYPE);

		choiceTypeEClass = createEClass(CHOICE_TYPE);

		dataSupportedTypeEClass = createEClass(DATA_SUPPORTED_TYPE);
		createEReference(dataSupportedTypeEClass, DATA_SUPPORTED_TYPE__SUPPORT);

		intervalTypeEClass = createEClass(INTERVAL_TYPE);
		createEAttribute(intervalTypeEClass, INTERVAL_TYPE__LOPEN);
		createEAttribute(intervalTypeEClass, INTERVAL_TYPE__ROPEN);
		createEReference(intervalTypeEClass, INTERVAL_TYPE__INFIMUM);
		createEReference(intervalTypeEClass, INTERVAL_TYPE__SUPREMUM);

		collectionTypeEClass = createEClass(COLLECTION_TYPE);
		createEAttribute(collectionTypeEClass, COLLECTION_TYPE__CONTAINER);
		createEAttribute(collectionTypeEClass, COLLECTION_TYPE__SIZE);
		createEAttribute(collectionTypeEClass, COLLECTION_TYPE__UNBOUNDED);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		primitiveBooleanTypeEClass = createEClass(PRIMITIVE_BOOLEAN_TYPE);

		primitiveNumberTypeEClass = createEClass(PRIMITIVE_NUMBER_TYPE);
		createEAttribute(primitiveNumberTypeEClass, PRIMITIVE_NUMBER_TYPE__SIGN);
		createEAttribute(primitiveNumberTypeEClass, PRIMITIVE_NUMBER_TYPE__SIZE);

		primitiveIntegerTypeEClass = createEClass(PRIMITIVE_INTEGER_TYPE);

		primitiveRationalTypeEClass = createEClass(PRIMITIVE_RATIONAL_TYPE);

		primitiveFloatTypeEClass = createEClass(PRIMITIVE_FLOAT_TYPE);

		primitiveRealTypeEClass = createEClass(PRIMITIVE_REAL_TYPE);

		primitiveTimeTypeEClass = createEClass(PRIMITIVE_TIME_TYPE);
		createEAttribute(primitiveTimeTypeEClass, PRIMITIVE_TIME_TYPE__CLOCK);
		createEReference(primitiveTimeTypeEClass, PRIMITIVE_TIME_TYPE__SUPPORT);

		primitiveCharacterTypeEClass = createEClass(PRIMITIVE_CHARACTER_TYPE);

		primitiveStringTypeEClass = createEClass(PRIMITIVE_STRING_TYPE);
		createEAttribute(primitiveStringTypeEClass, PRIMITIVE_STRING_TYPE__SIZE);

		primitiveInstanceTypeEClass = createEClass(PRIMITIVE_INSTANCE_TYPE);
		createEAttribute(primitiveInstanceTypeEClass, PRIMITIVE_INSTANCE_TYPE__EXPECTED);
		createEReference(primitiveInstanceTypeEClass, PRIMITIVE_INSTANCE_TYPE__MODEL);

		// Create enums
		primitiveTypeKindEEnum = createEEnum(PRIMITIVE_TYPE_KIND);
		collectionKindEEnum = createEEnum(COLLECTION_KIND);
		primitiveNumberSignEEnum = createEEnum(PRIMITIVE_NUMBER_SIGN);
		primitiveInstanceKindEEnum = createEEnum(PRIMITIVE_INSTANCE_KIND);
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
		dataTypeEClass.getESuperTypes().add(theCommonPackage.getClassifierDefinition());
		dataTypeReferenceEClass.getESuperTypes().add(this.getDataType());
		enumerationLiteralEClass.getESuperTypes().add(theCommonPackage.getNamedElement());
		enumerationTypeEClass.getESuperTypes().add(this.getDataType());
		dataStructuredTypeEClass.getESuperTypes().add(this.getDataType());
		structureTypeEClass.getESuperTypes().add(this.getDataStructuredType());
		unionTypeEClass.getESuperTypes().add(this.getDataStructuredType());
		choiceTypeEClass.getESuperTypes().add(this.getDataStructuredType());
		dataSupportedTypeEClass.getESuperTypes().add(this.getDataType());
		intervalTypeEClass.getESuperTypes().add(this.getDataSupportedType());
		collectionTypeEClass.getESuperTypes().add(this.getDataSupportedType());
		primitiveTypeEClass.getESuperTypes().add(this.getDataType());
		primitiveBooleanTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		primitiveNumberTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		primitiveIntegerTypeEClass.getESuperTypes().add(this.getPrimitiveNumberType());
		primitiveRationalTypeEClass.getESuperTypes().add(this.getPrimitiveNumberType());
		primitiveFloatTypeEClass.getESuperTypes().add(this.getPrimitiveNumberType());
		primitiveRealTypeEClass.getESuperTypes().add(this.getPrimitiveNumberType());
		primitiveTimeTypeEClass.getESuperTypes().add(this.getPrimitiveNumberType());
		primitiveCharacterTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		primitiveStringTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		primitiveInstanceTypeEClass.getESuperTypes().add(this.getPrimitiveType());

		// Initialize classes, features, and operations; add parameters
		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataType_Kind(), this.getPrimitiveTypeKind(), "kind", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_Typedef(), ecorePackage.getEBoolean(), "typedef", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_Multiplicity(), theExpressionPackage.getExpression(), null, "multiplicity", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_DefaultValue(), theExpressionPackage.getExpression(), null, "defaultValue", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_Constraint(), theInfrastructurePackage.getRoutine(), null, "constraint", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeReferenceEClass, DataTypeReference.class, "DataTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataTypeReference_Typeref(), this.getDataType(), null, "typeref", null, 0, 1, DataTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataTypeReference_Support(), this.getDataType(), null, "support", null, 0, 1, DataTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationLiteralEClass, EnumerationLiteral.class, "EnumerationLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationLiteral_Value(), theExpressionPackage.getLiteralExpression(), null, "value", null, 0, 1, EnumerationLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationTypeEClass, EnumerationType.class, "EnumerationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationType_Literal(), this.getEnumerationLiteral(), null, "literal", null, 0, -1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumerationType_SuperType(), this.getEnumerationType(), null, "superType", null, 0, 1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataStructuredTypeEClass, DataStructuredType.class, "DataStructuredType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataStructuredType_Property(), theInfrastructurePackage.getPropertyDefinition(), null, "property", null, 0, -1, DataStructuredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureTypeEClass, StructureType.class, "StructureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unionTypeEClass, UnionType.class, "UnionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(choiceTypeEClass, ChoiceType.class, "ChoiceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataSupportedTypeEClass, DataSupportedType.class, "DataSupportedType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSupportedType_Support(), this.getDataType(), null, "support", null, 0, 1, DataSupportedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intervalTypeEClass, IntervalType.class, "IntervalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntervalType_Lopen(), ecorePackage.getEBoolean(), "lopen", null, 1, 1, IntervalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntervalType_Ropen(), ecorePackage.getEBoolean(), "ropen", null, 1, 1, IntervalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntervalType_Infimum(), theExpressionPackage.getExpression(), null, "infimum", null, 1, 1, IntervalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntervalType_Supremum(), theExpressionPackage.getExpression(), null, "supremum", null, 1, 1, IntervalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionType_Container(), this.getCollectionKind(), "container", "list", 0, 1, CollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionType_Size(), ecorePackage.getEInt(), "size", "-1", 1, 1, CollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionType_Unbounded(), ecorePackage.getEBoolean(), "unbounded", null, 1, 1, CollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveBooleanTypeEClass, PrimitiveBooleanType.class, "PrimitiveBooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveNumberTypeEClass, PrimitiveNumberType.class, "PrimitiveNumberType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveNumberType_Sign(), this.getPrimitiveNumberSign(), "sign", "any", 0, 1, PrimitiveNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveNumberType_Size(), ecorePackage.getEInt(), "size", null, 1, 1, PrimitiveNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveIntegerTypeEClass, PrimitiveIntegerType.class, "PrimitiveIntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveRationalTypeEClass, PrimitiveRationalType.class, "PrimitiveRationalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveFloatTypeEClass, PrimitiveFloatType.class, "PrimitiveFloatType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveRealTypeEClass, PrimitiveRealType.class, "PrimitiveRealType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveTimeTypeEClass, PrimitiveTimeType.class, "PrimitiveTimeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveTimeType_Clock(), ecorePackage.getEBoolean(), "clock", "false", 1, 1, PrimitiveTimeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimitiveTimeType_Support(), this.getPrimitiveNumberType(), null, "support", null, 0, 1, PrimitiveTimeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveCharacterTypeEClass, PrimitiveCharacterType.class, "PrimitiveCharacterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveStringTypeEClass, PrimitiveStringType.class, "PrimitiveStringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveStringType_Size(), ecorePackage.getEInt(), "size", null, 1, 1, PrimitiveStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveInstanceTypeEClass, PrimitiveInstanceType.class, "PrimitiveInstanceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveInstanceType_Expected(), this.getPrimitiveInstanceKind(), "expected", "machine", 0, 1, PrimitiveInstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimitiveInstanceType_Model(), theCommonPackage.getNamedElement(), null, "model", null, 0, 1, PrimitiveInstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(primitiveTypeKindEEnum, PrimitiveTypeKind.class, "PrimitiveTypeKind");
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.BOOLEAN);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.INT);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.INTEGER);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.RAT);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.RATIONAL);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.FLOAT);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.DOUBLE);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.REAL);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.TIME);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.UINT);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.UINTEGER);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.URAT);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.URATIONAL);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.UFLOAT);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.UDOUBLE);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.UREAL);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.CHAR);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.STRING);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.BUFFER);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.MESSAGE);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.PORT);
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.MACHINE);

		initEEnum(collectionKindEEnum, CollectionKind.class, "CollectionKind");
		addEEnumLiteral(collectionKindEEnum, CollectionKind.VECTOR);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.RVECTOR);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.LIST);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.SET);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.BAG);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.FIFO);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.LIFO);

		initEEnum(primitiveNumberSignEEnum, PrimitiveNumberSign.class, "PrimitiveNumberSign");
		addEEnumLiteral(primitiveNumberSignEEnum, PrimitiveNumberSign.ANY);
		addEEnumLiteral(primitiveNumberSignEEnum, PrimitiveNumberSign.NEGATIVE);
		addEEnumLiteral(primitiveNumberSignEEnum, PrimitiveNumberSign.NEGATIVE_STRICT);
		addEEnumLiteral(primitiveNumberSignEEnum, PrimitiveNumberSign.POSITIVE);
		addEEnumLiteral(primitiveNumberSignEEnum, PrimitiveNumberSign.POSITIVE_STRICT);

		initEEnum(primitiveInstanceKindEEnum, PrimitiveInstanceKind.class, "PrimitiveInstanceKind");
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.ANY);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.BUFFER);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.MESSAGE);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.PORT);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.SIGNAL);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.FUNCTION);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.COM_POINT);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.CHANNEL);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.VERTEX);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.COMPOSITE);
		addEEnumLiteral(primitiveInstanceKindEEnum, PrimitiveInstanceKind.MACHINE);

		// Create resource
		createResource(eNS_URI);
	}

} //DatatypePackageImpl
