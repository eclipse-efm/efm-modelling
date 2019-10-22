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
package org.eclipse.efm.ecore.formalml.datatype;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;

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
 * @see org.eclipse.efm.ecore.formalml.datatype.DatatypeFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "datatype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/FormalML/DataType";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DataType";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatatypePackage eINSTANCE = org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = CommonPackage.CLASSIFIER_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__UNRESTRICTED_NAME = CommonPackage.CLASSIFIER_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__QUALIFIED_NAME = CommonPackage.CLASSIFIER_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__VISIBILITY = CommonPackage.CLASSIFIER_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__KIND = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__TYPEDEF = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__MULTIPLICITY = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DEFAULT_VALUE = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__CONSTRAINT = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = CommonPackage.CLASSIFIER_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeReferenceImpl <em>Data Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeReferenceImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getDataTypeReference()
	 * @generated
	 */
	int DATA_TYPE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__UNRESTRICTED_NAME = DATA_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__QUALIFIED_NAME = DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__VISIBILITY = DATA_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__KIND = DATA_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__TYPEDEF = DATA_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__MULTIPLICITY = DATA_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__DEFAULT_VALUE = DATA_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__CONSTRAINT = DATA_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Typeref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__TYPEREF = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Support</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE__SUPPORT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REFERENCE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.EnumerationLiteralImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = CommonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__UNRESTRICTED_NAME = CommonPackage.NAMED_ELEMENT__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__QUALIFIED_NAME = CommonPackage.NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__VISIBILITY = CommonPackage.NAMED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__VALUE = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_OPERATION_COUNT = CommonPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.EnumerationTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getEnumerationType()
	 * @generated
	 */
	int ENUMERATION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__UNRESTRICTED_NAME = DATA_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__QUALIFIED_NAME = DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__VISIBILITY = DATA_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__KIND = DATA_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__TYPEDEF = DATA_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__MULTIPLICITY = DATA_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__DEFAULT_VALUE = DATA_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__CONSTRAINT = DATA_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__LITERAL = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__SUPER_TYPE = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataStructuredTypeImpl <em>Data Structured Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DataStructuredTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getDataStructuredType()
	 * @generated
	 */
	int DATA_STRUCTURED_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__UNRESTRICTED_NAME = DATA_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__QUALIFIED_NAME = DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__VISIBILITY = DATA_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__KIND = DATA_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__TYPEDEF = DATA_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__MULTIPLICITY = DATA_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__DEFAULT_VALUE = DATA_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__CONSTRAINT = DATA_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE__PROPERTY = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Structured Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Structured Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STRUCTURED_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.StructureTypeImpl <em>Structure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.StructureTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getStructureType()
	 * @generated
	 */
	int STRUCTURE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__NAME = DATA_STRUCTURED_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__UNRESTRICTED_NAME = DATA_STRUCTURED_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__QUALIFIED_NAME = DATA_STRUCTURED_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__VISIBILITY = DATA_STRUCTURED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__KIND = DATA_STRUCTURED_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__TYPEDEF = DATA_STRUCTURED_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__MULTIPLICITY = DATA_STRUCTURED_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__DEFAULT_VALUE = DATA_STRUCTURED_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__CONSTRAINT = DATA_STRUCTURED_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE__PROPERTY = DATA_STRUCTURED_TYPE__PROPERTY;

	/**
	 * The number of structural features of the '<em>Structure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE_FEATURE_COUNT = DATA_STRUCTURED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Structure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_TYPE_OPERATION_COUNT = DATA_STRUCTURED_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.UnionTypeImpl <em>Union Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.UnionTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getUnionType()
	 * @generated
	 */
	int UNION_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__NAME = DATA_STRUCTURED_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__UNRESTRICTED_NAME = DATA_STRUCTURED_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__QUALIFIED_NAME = DATA_STRUCTURED_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__VISIBILITY = DATA_STRUCTURED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__KIND = DATA_STRUCTURED_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__TYPEDEF = DATA_STRUCTURED_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__MULTIPLICITY = DATA_STRUCTURED_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__DEFAULT_VALUE = DATA_STRUCTURED_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__CONSTRAINT = DATA_STRUCTURED_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__PROPERTY = DATA_STRUCTURED_TYPE__PROPERTY;

	/**
	 * The number of structural features of the '<em>Union Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_FEATURE_COUNT = DATA_STRUCTURED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Union Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_OPERATION_COUNT = DATA_STRUCTURED_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.ChoiceTypeImpl <em>Choice Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.ChoiceTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getChoiceType()
	 * @generated
	 */
	int CHOICE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__NAME = DATA_STRUCTURED_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__UNRESTRICTED_NAME = DATA_STRUCTURED_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__QUALIFIED_NAME = DATA_STRUCTURED_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__VISIBILITY = DATA_STRUCTURED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__KIND = DATA_STRUCTURED_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__TYPEDEF = DATA_STRUCTURED_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__MULTIPLICITY = DATA_STRUCTURED_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__DEFAULT_VALUE = DATA_STRUCTURED_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__CONSTRAINT = DATA_STRUCTURED_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__PROPERTY = DATA_STRUCTURED_TYPE__PROPERTY;

	/**
	 * The number of structural features of the '<em>Choice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE_FEATURE_COUNT = DATA_STRUCTURED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Choice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE_OPERATION_COUNT = DATA_STRUCTURED_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataSupportedTypeImpl <em>Data Supported Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DataSupportedTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getDataSupportedType()
	 * @generated
	 */
	int DATA_SUPPORTED_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__UNRESTRICTED_NAME = DATA_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__QUALIFIED_NAME = DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__VISIBILITY = DATA_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__KIND = DATA_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__TYPEDEF = DATA_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__MULTIPLICITY = DATA_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__DEFAULT_VALUE = DATA_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__CONSTRAINT = DATA_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Support</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE__SUPPORT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Supported Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Supported Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUPPORTED_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.IntervalTypeImpl <em>Interval Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.IntervalTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getIntervalType()
	 * @generated
	 */
	int INTERVAL_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__NAME = DATA_SUPPORTED_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__UNRESTRICTED_NAME = DATA_SUPPORTED_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__QUALIFIED_NAME = DATA_SUPPORTED_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__VISIBILITY = DATA_SUPPORTED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__KIND = DATA_SUPPORTED_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__TYPEDEF = DATA_SUPPORTED_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__MULTIPLICITY = DATA_SUPPORTED_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__DEFAULT_VALUE = DATA_SUPPORTED_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__CONSTRAINT = DATA_SUPPORTED_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Support</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__SUPPORT = DATA_SUPPORTED_TYPE__SUPPORT;

	/**
	 * The feature id for the '<em><b>Lopen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__LOPEN = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ropen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__ROPEN = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Infimum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__INFIMUM = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Supremum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__SUPREMUM = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Interval Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE_FEATURE_COUNT = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Interval Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE_OPERATION_COUNT = DATA_SUPPORTED_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.CollectionTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME = DATA_SUPPORTED_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__UNRESTRICTED_NAME = DATA_SUPPORTED_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__QUALIFIED_NAME = DATA_SUPPORTED_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__VISIBILITY = DATA_SUPPORTED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__KIND = DATA_SUPPORTED_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TYPEDEF = DATA_SUPPORTED_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__MULTIPLICITY = DATA_SUPPORTED_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__DEFAULT_VALUE = DATA_SUPPORTED_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__CONSTRAINT = DATA_SUPPORTED_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Support</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__SUPPORT = DATA_SUPPORTED_TYPE__SUPPORT;

	/**
	 * The feature id for the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__CONTAINER = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__SIZE = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__UNBOUNDED = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = DATA_SUPPORTED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_OPERATION_COUNT = DATA_SUPPORTED_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__UNRESTRICTED_NAME = DATA_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__QUALIFIED_NAME = DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__VISIBILITY = DATA_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__KIND = DATA_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TYPEDEF = DATA_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__MULTIPLICITY = DATA_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__DEFAULT_VALUE = DATA_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__CONSTRAINT = DATA_TYPE__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveBooleanTypeImpl <em>Primitive Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveBooleanTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveBooleanType()
	 * @generated
	 */
	int PRIMITIVE_BOOLEAN_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__UNRESTRICTED_NAME = PRIMITIVE_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__QUALIFIED_NAME = PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__KIND = PRIMITIVE_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__TYPEDEF = PRIMITIVE_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__MULTIPLICITY = PRIMITIVE_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__DEFAULT_VALUE = PRIMITIVE_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE__CONSTRAINT = PRIMITIVE_TYPE__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Primitive Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_TYPE_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveNumberTypeImpl <em>Primitive Number Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveNumberTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveNumberType()
	 * @generated
	 */
	int PRIMITIVE_NUMBER_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__UNRESTRICTED_NAME = PRIMITIVE_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__QUALIFIED_NAME = PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__KIND = PRIMITIVE_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__TYPEDEF = PRIMITIVE_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__MULTIPLICITY = PRIMITIVE_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__DEFAULT_VALUE = PRIMITIVE_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__CONSTRAINT = PRIMITIVE_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Sign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__SIGN = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE__SIZE = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Primitive Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Primitive Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_NUMBER_TYPE_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveIntegerTypeImpl <em>Primitive Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveIntegerTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveIntegerType()
	 * @generated
	 */
	int PRIMITIVE_INTEGER_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__NAME = PRIMITIVE_NUMBER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__UNRESTRICTED_NAME = PRIMITIVE_NUMBER_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__QUALIFIED_NAME = PRIMITIVE_NUMBER_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__VISIBILITY = PRIMITIVE_NUMBER_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__KIND = PRIMITIVE_NUMBER_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__TYPEDEF = PRIMITIVE_NUMBER_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__MULTIPLICITY = PRIMITIVE_NUMBER_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__DEFAULT_VALUE = PRIMITIVE_NUMBER_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__CONSTRAINT = PRIMITIVE_NUMBER_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Sign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__SIGN = PRIMITIVE_NUMBER_TYPE__SIGN;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE__SIZE = PRIMITIVE_NUMBER_TYPE__SIZE;

	/**
	 * The number of structural features of the '<em>Primitive Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE_FEATURE_COUNT = PRIMITIVE_NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_TYPE_OPERATION_COUNT = PRIMITIVE_NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveRationalTypeImpl <em>Primitive Rational Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveRationalTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveRationalType()
	 * @generated
	 */
	int PRIMITIVE_RATIONAL_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__NAME = PRIMITIVE_NUMBER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__UNRESTRICTED_NAME = PRIMITIVE_NUMBER_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__QUALIFIED_NAME = PRIMITIVE_NUMBER_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__VISIBILITY = PRIMITIVE_NUMBER_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__KIND = PRIMITIVE_NUMBER_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__TYPEDEF = PRIMITIVE_NUMBER_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__MULTIPLICITY = PRIMITIVE_NUMBER_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__DEFAULT_VALUE = PRIMITIVE_NUMBER_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__CONSTRAINT = PRIMITIVE_NUMBER_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Sign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__SIGN = PRIMITIVE_NUMBER_TYPE__SIGN;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE__SIZE = PRIMITIVE_NUMBER_TYPE__SIZE;

	/**
	 * The number of structural features of the '<em>Primitive Rational Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE_FEATURE_COUNT = PRIMITIVE_NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Rational Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_RATIONAL_TYPE_OPERATION_COUNT = PRIMITIVE_NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveFloatTypeImpl <em>Primitive Float Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveFloatTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveFloatType()
	 * @generated
	 */
	int PRIMITIVE_FLOAT_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__NAME = PRIMITIVE_NUMBER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__UNRESTRICTED_NAME = PRIMITIVE_NUMBER_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__QUALIFIED_NAME = PRIMITIVE_NUMBER_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__VISIBILITY = PRIMITIVE_NUMBER_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__KIND = PRIMITIVE_NUMBER_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__TYPEDEF = PRIMITIVE_NUMBER_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__MULTIPLICITY = PRIMITIVE_NUMBER_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__DEFAULT_VALUE = PRIMITIVE_NUMBER_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__CONSTRAINT = PRIMITIVE_NUMBER_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Sign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__SIGN = PRIMITIVE_NUMBER_TYPE__SIGN;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE__SIZE = PRIMITIVE_NUMBER_TYPE__SIZE;

	/**
	 * The number of structural features of the '<em>Primitive Float Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE_FEATURE_COUNT = PRIMITIVE_NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Float Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FLOAT_TYPE_OPERATION_COUNT = PRIMITIVE_NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveRealTypeImpl <em>Primitive Real Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveRealTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveRealType()
	 * @generated
	 */
	int PRIMITIVE_REAL_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__NAME = PRIMITIVE_NUMBER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__UNRESTRICTED_NAME = PRIMITIVE_NUMBER_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__QUALIFIED_NAME = PRIMITIVE_NUMBER_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__VISIBILITY = PRIMITIVE_NUMBER_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__KIND = PRIMITIVE_NUMBER_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__TYPEDEF = PRIMITIVE_NUMBER_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__MULTIPLICITY = PRIMITIVE_NUMBER_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__DEFAULT_VALUE = PRIMITIVE_NUMBER_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__CONSTRAINT = PRIMITIVE_NUMBER_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Sign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__SIGN = PRIMITIVE_NUMBER_TYPE__SIGN;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE__SIZE = PRIMITIVE_NUMBER_TYPE__SIZE;

	/**
	 * The number of structural features of the '<em>Primitive Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE_FEATURE_COUNT = PRIMITIVE_NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_TYPE_OPERATION_COUNT = PRIMITIVE_NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTimeTypeImpl <em>Primitive Time Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTimeTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveTimeType()
	 * @generated
	 */
	int PRIMITIVE_TIME_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__NAME = PRIMITIVE_NUMBER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__UNRESTRICTED_NAME = PRIMITIVE_NUMBER_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__QUALIFIED_NAME = PRIMITIVE_NUMBER_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__VISIBILITY = PRIMITIVE_NUMBER_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__KIND = PRIMITIVE_NUMBER_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__TYPEDEF = PRIMITIVE_NUMBER_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__MULTIPLICITY = PRIMITIVE_NUMBER_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__DEFAULT_VALUE = PRIMITIVE_NUMBER_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__CONSTRAINT = PRIMITIVE_NUMBER_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Sign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__SIGN = PRIMITIVE_NUMBER_TYPE__SIGN;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__SIZE = PRIMITIVE_NUMBER_TYPE__SIZE;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__CLOCK = PRIMITIVE_NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Support</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE__SUPPORT = PRIMITIVE_NUMBER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Primitive Time Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE_FEATURE_COUNT = PRIMITIVE_NUMBER_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Primitive Time Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TIME_TYPE_OPERATION_COUNT = PRIMITIVE_NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveCharacterTypeImpl <em>Primitive Character Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveCharacterTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveCharacterType()
	 * @generated
	 */
	int PRIMITIVE_CHARACTER_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__UNRESTRICTED_NAME = PRIMITIVE_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__QUALIFIED_NAME = PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__KIND = PRIMITIVE_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__TYPEDEF = PRIMITIVE_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__MULTIPLICITY = PRIMITIVE_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__DEFAULT_VALUE = PRIMITIVE_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE__CONSTRAINT = PRIMITIVE_TYPE__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Primitive Character Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Character Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CHARACTER_TYPE_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveStringTypeImpl <em>Primitive String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveStringTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveStringType()
	 * @generated
	 */
	int PRIMITIVE_STRING_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__UNRESTRICTED_NAME = PRIMITIVE_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__QUALIFIED_NAME = PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__KIND = PRIMITIVE_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__TYPEDEF = PRIMITIVE_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__MULTIPLICITY = PRIMITIVE_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__DEFAULT_VALUE = PRIMITIVE_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__CONSTRAINT = PRIMITIVE_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE__SIZE = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_TYPE_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveInstanceTypeImpl <em>Primitive Instance Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveInstanceTypeImpl
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveInstanceType()
	 * @generated
	 */
	int PRIMITIVE_INSTANCE_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__UNRESTRICTED_NAME = PRIMITIVE_TYPE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__QUALIFIED_NAME = PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__KIND = PRIMITIVE_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__TYPEDEF = PRIMITIVE_TYPE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__MULTIPLICITY = PRIMITIVE_TYPE__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__DEFAULT_VALUE = PRIMITIVE_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__CONSTRAINT = PRIMITIVE_TYPE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__EXPECTED = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE__MODEL = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Primitive Instance Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Primitive Instance Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INSTANCE_TYPE_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind <em>Primitive Type Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveTypeKind()
	 * @generated
	 */
	int PRIMITIVE_TYPE_KIND = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionKind <em>Collection Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionKind
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getCollectionKind()
	 * @generated
	 */
	int COLLECTION_KIND = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign <em>Primitive Number Sign</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveNumberSign()
	 * @generated
	 */
	int PRIMITIVE_NUMBER_SIGN = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind <em>Primitive Instance Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind
	 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveInstanceKind()
	 * @generated
	 */
	int PRIMITIVE_INSTANCE_KIND = 25;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataType#getKind()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#isTypedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typedef</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataType#isTypedef()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Typedef();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataType#getMultiplicity()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Multiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataType#getDefaultValue()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_DefaultValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.DataType#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataType#getConstraint()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Constraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.DataTypeReference <em>Data Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Reference</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataTypeReference
	 * @generated
	 */
	EClass getDataTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.datatype.DataTypeReference#getTyperef <em>Typeref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typeref</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataTypeReference#getTyperef()
	 * @see #getDataTypeReference()
	 * @generated
	 */
	EReference getDataTypeReference_Typeref();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.DataTypeReference#getSupport <em>Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Support</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataTypeReference#getSupport()
	 * @see #getDataTypeReference()
	 * @generated
	 */
	EReference getDataTypeReference_Support();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral#getValue()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EReference getEnumerationLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.EnumerationType <em>Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.EnumerationType
	 * @generated
	 */
	EClass getEnumerationType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.datatype.EnumerationType#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literal</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.EnumerationType#getLiteral()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EReference getEnumerationType_Literal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.datatype.EnumerationType#getSuperType <em>Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.EnumerationType#getSuperType()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EReference getEnumerationType_SuperType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.DataStructuredType <em>Data Structured Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Structured Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataStructuredType
	 * @generated
	 */
	EClass getDataStructuredType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.datatype.DataStructuredType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataStructuredType#getProperty()
	 * @see #getDataStructuredType()
	 * @generated
	 */
	EReference getDataStructuredType_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.StructureType <em>Structure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.StructureType
	 * @generated
	 */
	EClass getStructureType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.UnionType <em>Union Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.UnionType
	 * @generated
	 */
	EClass getUnionType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.ChoiceType <em>Choice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.ChoiceType
	 * @generated
	 */
	EClass getChoiceType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.DataSupportedType <em>Data Supported Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Supported Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataSupportedType
	 * @generated
	 */
	EClass getDataSupportedType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.DataSupportedType#getSupport <em>Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Support</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.DataSupportedType#getSupport()
	 * @see #getDataSupportedType()
	 * @generated
	 */
	EReference getDataSupportedType_Support();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType <em>Interval Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interval Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.IntervalType
	 * @generated
	 */
	EClass getIntervalType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#isLopen <em>Lopen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lopen</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.IntervalType#isLopen()
	 * @see #getIntervalType()
	 * @generated
	 */
	EAttribute getIntervalType_Lopen();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#isRopen <em>Ropen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ropen</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.IntervalType#isRopen()
	 * @see #getIntervalType()
	 * @generated
	 */
	EAttribute getIntervalType_Ropen();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#getInfimum <em>Infimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Infimum</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.IntervalType#getInfimum()
	 * @see #getIntervalType()
	 * @generated
	 */
	EReference getIntervalType_Infimum();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.IntervalType#getSupremum <em>Supremum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Supremum</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.IntervalType#getSupremum()
	 * @see #getIntervalType()
	 * @generated
	 */
	EReference getIntervalType_Supremum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionType#getContainer()
	 * @see #getCollectionType()
	 * @generated
	 */
	EAttribute getCollectionType_Container();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionType#getSize()
	 * @see #getCollectionType()
	 * @generated
	 */
	EAttribute getCollectionType_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionType#isUnbounded <em>Unbounded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unbounded</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionType#isUnbounded()
	 * @see #getCollectionType()
	 * @generated
	 */
	EAttribute getCollectionType_Unbounded();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveBooleanType <em>Primitive Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Boolean Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveBooleanType
	 * @generated
	 */
	EClass getPrimitiveBooleanType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType <em>Primitive Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Number Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType
	 * @generated
	 */
	EClass getPrimitiveNumberType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType#getSign <em>Sign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sign</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType#getSign()
	 * @see #getPrimitiveNumberType()
	 * @generated
	 */
	EAttribute getPrimitiveNumberType_Sign();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberType#getSize()
	 * @see #getPrimitiveNumberType()
	 * @generated
	 */
	EAttribute getPrimitiveNumberType_Size();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveIntegerType <em>Primitive Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Integer Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveIntegerType
	 * @generated
	 */
	EClass getPrimitiveIntegerType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveRationalType <em>Primitive Rational Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Rational Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveRationalType
	 * @generated
	 */
	EClass getPrimitiveRationalType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveFloatType <em>Primitive Float Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Float Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveFloatType
	 * @generated
	 */
	EClass getPrimitiveFloatType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveRealType <em>Primitive Real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Real Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveRealType
	 * @generated
	 */
	EClass getPrimitiveRealType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType <em>Primitive Time Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Time Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType
	 * @generated
	 */
	EClass getPrimitiveTimeType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType#isClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clock</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType#isClock()
	 * @see #getPrimitiveTimeType()
	 * @generated
	 */
	EAttribute getPrimitiveTimeType_Clock();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType#getSupport <em>Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Support</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveTimeType#getSupport()
	 * @see #getPrimitiveTimeType()
	 * @generated
	 */
	EReference getPrimitiveTimeType_Support();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveCharacterType <em>Primitive Character Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Character Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveCharacterType
	 * @generated
	 */
	EClass getPrimitiveCharacterType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType <em>Primitive String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive String Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType
	 * @generated
	 */
	EClass getPrimitiveStringType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType#getSize()
	 * @see #getPrimitiveStringType()
	 * @generated
	 */
	EAttribute getPrimitiveStringType_Size();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType <em>Primitive Instance Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Instance Type</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType
	 * @generated
	 */
	EClass getPrimitiveInstanceType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType#getExpected <em>Expected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType#getExpected()
	 * @see #getPrimitiveInstanceType()
	 * @generated
	 */
	EAttribute getPrimitiveInstanceType_Expected();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType#getModel()
	 * @see #getPrimitiveInstanceType()
	 * @generated
	 */
	EReference getPrimitiveInstanceType_Model();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind <em>Primitive Type Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind
	 * @generated
	 */
	EEnum getPrimitiveTypeKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionKind <em>Collection Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionKind
	 * @generated
	 */
	EEnum getCollectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign <em>Primitive Number Sign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Number Sign</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign
	 * @generated
	 */
	EEnum getPrimitiveNumberSign();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind <em>Primitive Instance Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Instance Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind
	 * @generated
	 */
	EEnum getPrimitiveInstanceKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatatypeFactory getDatatypeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__KIND = eINSTANCE.getDataType_Kind();

		/**
		 * The meta object literal for the '<em><b>Typedef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__TYPEDEF = eINSTANCE.getDataType_Typedef();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__MULTIPLICITY = eINSTANCE.getDataType_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__DEFAULT_VALUE = eINSTANCE.getDataType_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__CONSTRAINT = eINSTANCE.getDataType_Constraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeReferenceImpl <em>Data Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DataTypeReferenceImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getDataTypeReference()
		 * @generated
		 */
		EClass DATA_TYPE_REFERENCE = eINSTANCE.getDataTypeReference();

		/**
		 * The meta object literal for the '<em><b>Typeref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_REFERENCE__TYPEREF = eINSTANCE.getDataTypeReference_Typeref();

		/**
		 * The meta object literal for the '<em><b>Support</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_REFERENCE__SUPPORT = eINSTANCE.getDataTypeReference_Support();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.EnumerationLiteralImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL__VALUE = eINSTANCE.getEnumerationLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.EnumerationTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getEnumerationType()
		 * @generated
		 */
		EClass ENUMERATION_TYPE = eINSTANCE.getEnumerationType();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_TYPE__LITERAL = eINSTANCE.getEnumerationType_Literal();

		/**
		 * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_TYPE__SUPER_TYPE = eINSTANCE.getEnumerationType_SuperType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataStructuredTypeImpl <em>Data Structured Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DataStructuredTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getDataStructuredType()
		 * @generated
		 */
		EClass DATA_STRUCTURED_TYPE = eINSTANCE.getDataStructuredType();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_STRUCTURED_TYPE__PROPERTY = eINSTANCE.getDataStructuredType_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.StructureTypeImpl <em>Structure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.StructureTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getStructureType()
		 * @generated
		 */
		EClass STRUCTURE_TYPE = eINSTANCE.getStructureType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.UnionTypeImpl <em>Union Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.UnionTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getUnionType()
		 * @generated
		 */
		EClass UNION_TYPE = eINSTANCE.getUnionType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.ChoiceTypeImpl <em>Choice Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.ChoiceTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getChoiceType()
		 * @generated
		 */
		EClass CHOICE_TYPE = eINSTANCE.getChoiceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.DataSupportedTypeImpl <em>Data Supported Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DataSupportedTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getDataSupportedType()
		 * @generated
		 */
		EClass DATA_SUPPORTED_TYPE = eINSTANCE.getDataSupportedType();

		/**
		 * The meta object literal for the '<em><b>Support</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SUPPORTED_TYPE__SUPPORT = eINSTANCE.getDataSupportedType_Support();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.IntervalTypeImpl <em>Interval Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.IntervalTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getIntervalType()
		 * @generated
		 */
		EClass INTERVAL_TYPE = eINSTANCE.getIntervalType();

		/**
		 * The meta object literal for the '<em><b>Lopen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_TYPE__LOPEN = eINSTANCE.getIntervalType_Lopen();

		/**
		 * The meta object literal for the '<em><b>Ropen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_TYPE__ROPEN = eINSTANCE.getIntervalType_Ropen();

		/**
		 * The meta object literal for the '<em><b>Infimum</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL_TYPE__INFIMUM = eINSTANCE.getIntervalType_Infimum();

		/**
		 * The meta object literal for the '<em><b>Supremum</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL_TYPE__SUPREMUM = eINSTANCE.getIntervalType_Supremum();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.CollectionTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE__CONTAINER = eINSTANCE.getCollectionType_Container();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE__SIZE = eINSTANCE.getCollectionType_Size();

		/**
		 * The meta object literal for the '<em><b>Unbounded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE__UNBOUNDED = eINSTANCE.getCollectionType_Unbounded();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveBooleanTypeImpl <em>Primitive Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveBooleanTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveBooleanType()
		 * @generated
		 */
		EClass PRIMITIVE_BOOLEAN_TYPE = eINSTANCE.getPrimitiveBooleanType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveNumberTypeImpl <em>Primitive Number Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveNumberTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveNumberType()
		 * @generated
		 */
		EClass PRIMITIVE_NUMBER_TYPE = eINSTANCE.getPrimitiveNumberType();

		/**
		 * The meta object literal for the '<em><b>Sign</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_NUMBER_TYPE__SIGN = eINSTANCE.getPrimitiveNumberType_Sign();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_NUMBER_TYPE__SIZE = eINSTANCE.getPrimitiveNumberType_Size();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveIntegerTypeImpl <em>Primitive Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveIntegerTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveIntegerType()
		 * @generated
		 */
		EClass PRIMITIVE_INTEGER_TYPE = eINSTANCE.getPrimitiveIntegerType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveRationalTypeImpl <em>Primitive Rational Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveRationalTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveRationalType()
		 * @generated
		 */
		EClass PRIMITIVE_RATIONAL_TYPE = eINSTANCE.getPrimitiveRationalType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveFloatTypeImpl <em>Primitive Float Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveFloatTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveFloatType()
		 * @generated
		 */
		EClass PRIMITIVE_FLOAT_TYPE = eINSTANCE.getPrimitiveFloatType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveRealTypeImpl <em>Primitive Real Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveRealTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveRealType()
		 * @generated
		 */
		EClass PRIMITIVE_REAL_TYPE = eINSTANCE.getPrimitiveRealType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTimeTypeImpl <em>Primitive Time Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveTimeTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveTimeType()
		 * @generated
		 */
		EClass PRIMITIVE_TIME_TYPE = eINSTANCE.getPrimitiveTimeType();

		/**
		 * The meta object literal for the '<em><b>Clock</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TIME_TYPE__CLOCK = eINSTANCE.getPrimitiveTimeType_Clock();

		/**
		 * The meta object literal for the '<em><b>Support</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TIME_TYPE__SUPPORT = eINSTANCE.getPrimitiveTimeType_Support();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveCharacterTypeImpl <em>Primitive Character Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveCharacterTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveCharacterType()
		 * @generated
		 */
		EClass PRIMITIVE_CHARACTER_TYPE = eINSTANCE.getPrimitiveCharacterType();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveStringTypeImpl <em>Primitive String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveStringTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveStringType()
		 * @generated
		 */
		EClass PRIMITIVE_STRING_TYPE = eINSTANCE.getPrimitiveStringType();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_STRING_TYPE__SIZE = eINSTANCE.getPrimitiveStringType_Size();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveInstanceTypeImpl <em>Primitive Instance Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.PrimitiveInstanceTypeImpl
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveInstanceType()
		 * @generated
		 */
		EClass PRIMITIVE_INSTANCE_TYPE = eINSTANCE.getPrimitiveInstanceType();

		/**
		 * The meta object literal for the '<em><b>Expected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_INSTANCE_TYPE__EXPECTED = eINSTANCE.getPrimitiveInstanceType_Expected();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_INSTANCE_TYPE__MODEL = eINSTANCE.getPrimitiveInstanceType_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind <em>Primitive Type Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveTypeKind
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveTypeKind()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE_KIND = eINSTANCE.getPrimitiveTypeKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.CollectionKind <em>Collection Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.CollectionKind
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getCollectionKind()
		 * @generated
		 */
		EEnum COLLECTION_KIND = eINSTANCE.getCollectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign <em>Primitive Number Sign</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveNumberSign
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveNumberSign()
		 * @generated
		 */
		EEnum PRIMITIVE_NUMBER_SIGN = eINSTANCE.getPrimitiveNumberSign();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind <em>Primitive Instance Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind
		 * @see org.eclipse.efm.ecore.formalml.datatype.impl.DatatypePackageImpl#getPrimitiveInstanceKind()
		 * @generated
		 */
		EEnum PRIMITIVE_INSTANCE_KIND = eINSTANCE.getPrimitiveInstanceKind();

	}

} //DatatypePackage
