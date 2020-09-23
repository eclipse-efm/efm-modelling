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

import org.eclipse.efm.ecore.formalml.datatype.*;

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
public class DatatypeFactoryImpl extends EFactoryImpl implements DatatypeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DatatypeFactory init() {
		try {
			DatatypeFactory theDatatypeFactory = (DatatypeFactory)EPackage.Registry.INSTANCE.getEFactory(DatatypePackage.eNS_URI);
			if (theDatatypeFactory != null) {
				return theDatatypeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DatatypeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeFactoryImpl() {
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
			case DatatypePackage.DATA_TYPE_REFERENCE: return createDataTypeReference();
			case DatatypePackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
			case DatatypePackage.ENUMERATION_TYPE: return createEnumerationType();
			case DatatypePackage.STRUCTURE_TYPE: return createStructureType();
			case DatatypePackage.UNION_TYPE: return createUnionType();
			case DatatypePackage.CHOICE_TYPE: return createChoiceType();
			case DatatypePackage.INTERVAL_TYPE: return createIntervalType();
			case DatatypePackage.COLLECTION_TYPE: return createCollectionType();
			case DatatypePackage.PRIMITIVE_BOOLEAN_TYPE: return createPrimitiveBooleanType();
			case DatatypePackage.PRIMITIVE_INTEGER_TYPE: return createPrimitiveIntegerType();
			case DatatypePackage.PRIMITIVE_RATIONAL_TYPE: return createPrimitiveRationalType();
			case DatatypePackage.PRIMITIVE_FLOAT_TYPE: return createPrimitiveFloatType();
			case DatatypePackage.PRIMITIVE_REAL_TYPE: return createPrimitiveRealType();
			case DatatypePackage.PRIMITIVE_TIME_TYPE: return createPrimitiveTimeType();
			case DatatypePackage.PRIMITIVE_CHARACTER_TYPE: return createPrimitiveCharacterType();
			case DatatypePackage.PRIMITIVE_STRING_TYPE: return createPrimitiveStringType();
			case DatatypePackage.PRIMITIVE_INSTANCE_TYPE: return createPrimitiveInstanceType();
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
			case DatatypePackage.PRIMITIVE_TYPE_KIND:
				return createPrimitiveTypeKindFromString(eDataType, initialValue);
			case DatatypePackage.COLLECTION_KIND:
				return createCollectionKindFromString(eDataType, initialValue);
			case DatatypePackage.PRIMITIVE_NUMBER_SIGN:
				return createPrimitiveNumberSignFromString(eDataType, initialValue);
			case DatatypePackage.PRIMITIVE_INSTANCE_KIND:
				return createPrimitiveInstanceKindFromString(eDataType, initialValue);
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
			case DatatypePackage.PRIMITIVE_TYPE_KIND:
				return convertPrimitiveTypeKindToString(eDataType, instanceValue);
			case DatatypePackage.COLLECTION_KIND:
				return convertCollectionKindToString(eDataType, instanceValue);
			case DatatypePackage.PRIMITIVE_NUMBER_SIGN:
				return convertPrimitiveNumberSignToString(eDataType, instanceValue);
			case DatatypePackage.PRIMITIVE_INSTANCE_KIND:
				return convertPrimitiveInstanceKindToString(eDataType, instanceValue);
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
	public DataTypeReference createDataTypeReference() {
		DataTypeReferenceImpl dataTypeReference = new DataTypeReferenceImpl();
		return dataTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationType createEnumerationType() {
		EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
		return enumerationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructureType createStructureType() {
		StructureTypeImpl structureType = new StructureTypeImpl();
		return structureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnionType createUnionType() {
		UnionTypeImpl unionType = new UnionTypeImpl();
		return unionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ChoiceType createChoiceType() {
		ChoiceTypeImpl choiceType = new ChoiceTypeImpl();
		return choiceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntervalType createIntervalType() {
		IntervalTypeImpl intervalType = new IntervalTypeImpl();
		return intervalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionType createCollectionType() {
		CollectionTypeImpl collectionType = new CollectionTypeImpl();
		return collectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveBooleanType createPrimitiveBooleanType() {
		PrimitiveBooleanTypeImpl primitiveBooleanType = new PrimitiveBooleanTypeImpl();
		return primitiveBooleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveIntegerType createPrimitiveIntegerType() {
		PrimitiveIntegerTypeImpl primitiveIntegerType = new PrimitiveIntegerTypeImpl();
		return primitiveIntegerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveRationalType createPrimitiveRationalType() {
		PrimitiveRationalTypeImpl primitiveRationalType = new PrimitiveRationalTypeImpl();
		return primitiveRationalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveFloatType createPrimitiveFloatType() {
		PrimitiveFloatTypeImpl primitiveFloatType = new PrimitiveFloatTypeImpl();
		return primitiveFloatType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveRealType createPrimitiveRealType() {
		PrimitiveRealTypeImpl primitiveRealType = new PrimitiveRealTypeImpl();
		return primitiveRealType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveTimeType createPrimitiveTimeType() {
		PrimitiveTimeTypeImpl primitiveTimeType = new PrimitiveTimeTypeImpl();
		return primitiveTimeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveCharacterType createPrimitiveCharacterType() {
		PrimitiveCharacterTypeImpl primitiveCharacterType = new PrimitiveCharacterTypeImpl();
		return primitiveCharacterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveStringType createPrimitiveStringType() {
		PrimitiveStringTypeImpl primitiveStringType = new PrimitiveStringTypeImpl();
		return primitiveStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveInstanceType createPrimitiveInstanceType() {
		PrimitiveInstanceTypeImpl primitiveInstanceType = new PrimitiveInstanceTypeImpl();
		return primitiveInstanceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeKind createPrimitiveTypeKindFromString(EDataType eDataType, String initialValue) {
		PrimitiveTypeKind result = PrimitiveTypeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionKind createCollectionKindFromString(EDataType eDataType, String initialValue) {
		CollectionKind result = CollectionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveNumberSign createPrimitiveNumberSignFromString(EDataType eDataType, String initialValue) {
		PrimitiveNumberSign result = PrimitiveNumberSign.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveNumberSignToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveInstanceKind createPrimitiveInstanceKindFromString(EDataType eDataType, String initialValue) {
		PrimitiveInstanceKind result = PrimitiveInstanceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveInstanceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatatypePackage getDatatypePackage() {
		return (DatatypePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DatatypePackage getPackage() {
		return DatatypePackage.eINSTANCE;
	}

} //DatatypeFactoryImpl
