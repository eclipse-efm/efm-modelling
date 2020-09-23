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
package org.eclipse.efm.ecore.formalml.datatype.util;

import org.eclipse.efm.ecore.formalml.common.AbstractElement;
import org.eclipse.efm.ecore.formalml.common.ClassifierDefinition;
import org.eclipse.efm.ecore.formalml.common.NamedElement;
import org.eclipse.efm.ecore.formalml.common.Type;

import org.eclipse.efm.ecore.formalml.datatype.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypePackage
 * @generated
 */
public class DatatypeSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DatatypePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeSwitch() {
		if (modelPackage == null) {
			modelPackage = DatatypePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DatatypePackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = caseClassifierDefinition(dataType);
				if (result == null) result = caseType(dataType);
				if (result == null) result = caseNamedElement(dataType);
				if (result == null) result = caseAbstractElement(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.DATA_TYPE_REFERENCE: {
				DataTypeReference dataTypeReference = (DataTypeReference)theEObject;
				T result = caseDataTypeReference(dataTypeReference);
				if (result == null) result = caseDataType(dataTypeReference);
				if (result == null) result = caseClassifierDefinition(dataTypeReference);
				if (result == null) result = caseType(dataTypeReference);
				if (result == null) result = caseNamedElement(dataTypeReference);
				if (result == null) result = caseAbstractElement(dataTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.ENUMERATION_LITERAL: {
				EnumerationLiteral enumerationLiteral = (EnumerationLiteral)theEObject;
				T result = caseEnumerationLiteral(enumerationLiteral);
				if (result == null) result = caseNamedElement(enumerationLiteral);
				if (result == null) result = caseAbstractElement(enumerationLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.ENUMERATION_TYPE: {
				EnumerationType enumerationType = (EnumerationType)theEObject;
				T result = caseEnumerationType(enumerationType);
				if (result == null) result = caseDataType(enumerationType);
				if (result == null) result = caseClassifierDefinition(enumerationType);
				if (result == null) result = caseType(enumerationType);
				if (result == null) result = caseNamedElement(enumerationType);
				if (result == null) result = caseAbstractElement(enumerationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.DATA_STRUCTURED_TYPE: {
				DataStructuredType dataStructuredType = (DataStructuredType)theEObject;
				T result = caseDataStructuredType(dataStructuredType);
				if (result == null) result = caseDataType(dataStructuredType);
				if (result == null) result = caseClassifierDefinition(dataStructuredType);
				if (result == null) result = caseType(dataStructuredType);
				if (result == null) result = caseNamedElement(dataStructuredType);
				if (result == null) result = caseAbstractElement(dataStructuredType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.STRUCTURE_TYPE: {
				StructureType structureType = (StructureType)theEObject;
				T result = caseStructureType(structureType);
				if (result == null) result = caseDataStructuredType(structureType);
				if (result == null) result = caseDataType(structureType);
				if (result == null) result = caseClassifierDefinition(structureType);
				if (result == null) result = caseType(structureType);
				if (result == null) result = caseNamedElement(structureType);
				if (result == null) result = caseAbstractElement(structureType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.UNION_TYPE: {
				UnionType unionType = (UnionType)theEObject;
				T result = caseUnionType(unionType);
				if (result == null) result = caseDataStructuredType(unionType);
				if (result == null) result = caseDataType(unionType);
				if (result == null) result = caseClassifierDefinition(unionType);
				if (result == null) result = caseType(unionType);
				if (result == null) result = caseNamedElement(unionType);
				if (result == null) result = caseAbstractElement(unionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.CHOICE_TYPE: {
				ChoiceType choiceType = (ChoiceType)theEObject;
				T result = caseChoiceType(choiceType);
				if (result == null) result = caseDataStructuredType(choiceType);
				if (result == null) result = caseDataType(choiceType);
				if (result == null) result = caseClassifierDefinition(choiceType);
				if (result == null) result = caseType(choiceType);
				if (result == null) result = caseNamedElement(choiceType);
				if (result == null) result = caseAbstractElement(choiceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.DATA_SUPPORTED_TYPE: {
				DataSupportedType dataSupportedType = (DataSupportedType)theEObject;
				T result = caseDataSupportedType(dataSupportedType);
				if (result == null) result = caseDataType(dataSupportedType);
				if (result == null) result = caseClassifierDefinition(dataSupportedType);
				if (result == null) result = caseType(dataSupportedType);
				if (result == null) result = caseNamedElement(dataSupportedType);
				if (result == null) result = caseAbstractElement(dataSupportedType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.INTERVAL_TYPE: {
				IntervalType intervalType = (IntervalType)theEObject;
				T result = caseIntervalType(intervalType);
				if (result == null) result = caseDataSupportedType(intervalType);
				if (result == null) result = caseDataType(intervalType);
				if (result == null) result = caseClassifierDefinition(intervalType);
				if (result == null) result = caseType(intervalType);
				if (result == null) result = caseNamedElement(intervalType);
				if (result == null) result = caseAbstractElement(intervalType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.COLLECTION_TYPE: {
				CollectionType collectionType = (CollectionType)theEObject;
				T result = caseCollectionType(collectionType);
				if (result == null) result = caseDataSupportedType(collectionType);
				if (result == null) result = caseDataType(collectionType);
				if (result == null) result = caseClassifierDefinition(collectionType);
				if (result == null) result = caseType(collectionType);
				if (result == null) result = caseNamedElement(collectionType);
				if (result == null) result = caseAbstractElement(collectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseDataType(primitiveType);
				if (result == null) result = caseClassifierDefinition(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = caseNamedElement(primitiveType);
				if (result == null) result = caseAbstractElement(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_BOOLEAN_TYPE: {
				PrimitiveBooleanType primitiveBooleanType = (PrimitiveBooleanType)theEObject;
				T result = casePrimitiveBooleanType(primitiveBooleanType);
				if (result == null) result = casePrimitiveType(primitiveBooleanType);
				if (result == null) result = caseDataType(primitiveBooleanType);
				if (result == null) result = caseClassifierDefinition(primitiveBooleanType);
				if (result == null) result = caseType(primitiveBooleanType);
				if (result == null) result = caseNamedElement(primitiveBooleanType);
				if (result == null) result = caseAbstractElement(primitiveBooleanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_NUMBER_TYPE: {
				PrimitiveNumberType primitiveNumberType = (PrimitiveNumberType)theEObject;
				T result = casePrimitiveNumberType(primitiveNumberType);
				if (result == null) result = casePrimitiveType(primitiveNumberType);
				if (result == null) result = caseDataType(primitiveNumberType);
				if (result == null) result = caseClassifierDefinition(primitiveNumberType);
				if (result == null) result = caseType(primitiveNumberType);
				if (result == null) result = caseNamedElement(primitiveNumberType);
				if (result == null) result = caseAbstractElement(primitiveNumberType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_INTEGER_TYPE: {
				PrimitiveIntegerType primitiveIntegerType = (PrimitiveIntegerType)theEObject;
				T result = casePrimitiveIntegerType(primitiveIntegerType);
				if (result == null) result = casePrimitiveNumberType(primitiveIntegerType);
				if (result == null) result = casePrimitiveType(primitiveIntegerType);
				if (result == null) result = caseDataType(primitiveIntegerType);
				if (result == null) result = caseClassifierDefinition(primitiveIntegerType);
				if (result == null) result = caseType(primitiveIntegerType);
				if (result == null) result = caseNamedElement(primitiveIntegerType);
				if (result == null) result = caseAbstractElement(primitiveIntegerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_RATIONAL_TYPE: {
				PrimitiveRationalType primitiveRationalType = (PrimitiveRationalType)theEObject;
				T result = casePrimitiveRationalType(primitiveRationalType);
				if (result == null) result = casePrimitiveNumberType(primitiveRationalType);
				if (result == null) result = casePrimitiveType(primitiveRationalType);
				if (result == null) result = caseDataType(primitiveRationalType);
				if (result == null) result = caseClassifierDefinition(primitiveRationalType);
				if (result == null) result = caseType(primitiveRationalType);
				if (result == null) result = caseNamedElement(primitiveRationalType);
				if (result == null) result = caseAbstractElement(primitiveRationalType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_FLOAT_TYPE: {
				PrimitiveFloatType primitiveFloatType = (PrimitiveFloatType)theEObject;
				T result = casePrimitiveFloatType(primitiveFloatType);
				if (result == null) result = casePrimitiveNumberType(primitiveFloatType);
				if (result == null) result = casePrimitiveType(primitiveFloatType);
				if (result == null) result = caseDataType(primitiveFloatType);
				if (result == null) result = caseClassifierDefinition(primitiveFloatType);
				if (result == null) result = caseType(primitiveFloatType);
				if (result == null) result = caseNamedElement(primitiveFloatType);
				if (result == null) result = caseAbstractElement(primitiveFloatType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_REAL_TYPE: {
				PrimitiveRealType primitiveRealType = (PrimitiveRealType)theEObject;
				T result = casePrimitiveRealType(primitiveRealType);
				if (result == null) result = casePrimitiveNumberType(primitiveRealType);
				if (result == null) result = casePrimitiveType(primitiveRealType);
				if (result == null) result = caseDataType(primitiveRealType);
				if (result == null) result = caseClassifierDefinition(primitiveRealType);
				if (result == null) result = caseType(primitiveRealType);
				if (result == null) result = caseNamedElement(primitiveRealType);
				if (result == null) result = caseAbstractElement(primitiveRealType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_TIME_TYPE: {
				PrimitiveTimeType primitiveTimeType = (PrimitiveTimeType)theEObject;
				T result = casePrimitiveTimeType(primitiveTimeType);
				if (result == null) result = casePrimitiveNumberType(primitiveTimeType);
				if (result == null) result = casePrimitiveType(primitiveTimeType);
				if (result == null) result = caseDataType(primitiveTimeType);
				if (result == null) result = caseClassifierDefinition(primitiveTimeType);
				if (result == null) result = caseType(primitiveTimeType);
				if (result == null) result = caseNamedElement(primitiveTimeType);
				if (result == null) result = caseAbstractElement(primitiveTimeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_CHARACTER_TYPE: {
				PrimitiveCharacterType primitiveCharacterType = (PrimitiveCharacterType)theEObject;
				T result = casePrimitiveCharacterType(primitiveCharacterType);
				if (result == null) result = casePrimitiveType(primitiveCharacterType);
				if (result == null) result = caseDataType(primitiveCharacterType);
				if (result == null) result = caseClassifierDefinition(primitiveCharacterType);
				if (result == null) result = caseType(primitiveCharacterType);
				if (result == null) result = caseNamedElement(primitiveCharacterType);
				if (result == null) result = caseAbstractElement(primitiveCharacterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_STRING_TYPE: {
				PrimitiveStringType primitiveStringType = (PrimitiveStringType)theEObject;
				T result = casePrimitiveStringType(primitiveStringType);
				if (result == null) result = casePrimitiveType(primitiveStringType);
				if (result == null) result = caseDataType(primitiveStringType);
				if (result == null) result = caseClassifierDefinition(primitiveStringType);
				if (result == null) result = caseType(primitiveStringType);
				if (result == null) result = caseNamedElement(primitiveStringType);
				if (result == null) result = caseAbstractElement(primitiveStringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatatypePackage.PRIMITIVE_INSTANCE_TYPE: {
				PrimitiveInstanceType primitiveInstanceType = (PrimitiveInstanceType)theEObject;
				T result = casePrimitiveInstanceType(primitiveInstanceType);
				if (result == null) result = casePrimitiveType(primitiveInstanceType);
				if (result == null) result = caseDataType(primitiveInstanceType);
				if (result == null) result = caseClassifierDefinition(primitiveInstanceType);
				if (result == null) result = caseType(primitiveInstanceType);
				if (result == null) result = caseNamedElement(primitiveInstanceType);
				if (result == null) result = caseAbstractElement(primitiveInstanceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeReference(DataTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteral(EnumerationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationType(EnumerationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Structured Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Structured Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataStructuredType(DataStructuredType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureType(StructureType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Union Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Union Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnionType(UnionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceType(ChoiceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Supported Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Supported Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSupportedType(DataSupportedType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interval Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interval Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntervalType(IntervalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveBooleanType(PrimitiveBooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Number Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Number Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveNumberType(PrimitiveNumberType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveIntegerType(PrimitiveIntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Rational Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Rational Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveRationalType(PrimitiveRationalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Float Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Float Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveFloatType(PrimitiveFloatType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Real Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Real Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveRealType(PrimitiveRealType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Time Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Time Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTimeType(PrimitiveTimeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Character Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Character Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveCharacterType(PrimitiveCharacterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveStringType(PrimitiveStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Instance Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Instance Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveInstanceType(PrimitiveInstanceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractElement(AbstractElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierDefinition(ClassifierDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DatatypeSwitch
