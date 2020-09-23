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
package org.eclipse.efm.ecore.formalml.specification;

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
 * @see org.eclipse.efm.ecore.formalml.specification.SpecificationFactory
 * @model kind="package"
 * @generated
 */
public interface SpecificationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "specification";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/FormalML/Specification";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "specification";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpecificationPackage eINSTANCE = org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaModelImpl <em>Xlia Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaModelImpl
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaModel()
	 * @generated
	 */
	int XLIA_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Prolog</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_MODEL__PROLOG = 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_MODEL__SYSTEM = 1;

	/**
	 * The number of structural features of the '<em>Xlia Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Xlia Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaNamedElementImpl <em>Xlia Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaNamedElementImpl
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaNamedElement()
	 * @generated
	 */
	int XLIA_NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Xlia Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Xlia Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaObjectImpl <em>Xlia Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaObjectImpl
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaObject()
	 * @generated
	 */
	int XLIA_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_OBJECT__NAME = XLIA_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_OBJECT__ELEMENTS = XLIA_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xlia Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_OBJECT_FEATURE_COUNT = XLIA_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Xlia Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_OBJECT_OPERATION_COUNT = XLIA_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaSectionImpl <em>Xlia Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaSectionImpl
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaSection()
	 * @generated
	 */
	int XLIA_SECTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_SECTION__NAME = XLIA_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_SECTION__ELEMENTS = XLIA_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xlia Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_SECTION_FEATURE_COUNT = XLIA_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Xlia Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_SECTION_OPERATION_COUNT = XLIA_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaAttributeImpl <em>Xlia Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaAttributeImpl
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaAttribute()
	 * @generated
	 */
	int XLIA_ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_ATTRIBUTE__NAME = XLIA_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_ATTRIBUTE__VALUE = XLIA_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xlia Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_ATTRIBUTE_FEATURE_COUNT = XLIA_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Xlia Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIA_ATTRIBUTE_OPERATION_COUNT = XLIA_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.specification.XliaModelKind <em>Xlia Model Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaModelKind
	 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaModelKind()
	 * @generated
	 */
	int XLIA_MODEL_KIND = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.specification.XliaModel <em>Xlia Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xlia Model</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaModel
	 * @generated
	 */
	EClass getXliaModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.specification.XliaModel#getProlog <em>Prolog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Prolog</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaModel#getProlog()
	 * @see #getXliaModel()
	 * @generated
	 */
	EReference getXliaModel_Prolog();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.specification.XliaModel#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaModel#getSystem()
	 * @see #getXliaModel()
	 * @generated
	 */
	EReference getXliaModel_System();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.specification.XliaNamedElement <em>Xlia Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xlia Named Element</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaNamedElement
	 * @generated
	 */
	EClass getXliaNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.specification.XliaNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaNamedElement#getName()
	 * @see #getXliaNamedElement()
	 * @generated
	 */
	EAttribute getXliaNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.specification.XliaObject <em>Xlia Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xlia Object</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaObject
	 * @generated
	 */
	EClass getXliaObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.specification.XliaObject#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaObject#getElements()
	 * @see #getXliaObject()
	 * @generated
	 */
	EReference getXliaObject_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.specification.XliaSection <em>Xlia Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xlia Section</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaSection
	 * @generated
	 */
	EClass getXliaSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.specification.XliaSection#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaSection#getElements()
	 * @see #getXliaSection()
	 * @generated
	 */
	EReference getXliaSection_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.specification.XliaAttribute <em>Xlia Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xlia Attribute</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaAttribute
	 * @generated
	 */
	EClass getXliaAttribute();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.specification.XliaAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaAttribute#getValue()
	 * @see #getXliaAttribute()
	 * @generated
	 */
	EReference getXliaAttribute_Value();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.specification.XliaModelKind <em>Xlia Model Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Xlia Model Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.specification.XliaModelKind
	 * @generated
	 */
	EEnum getXliaModelKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpecificationFactory getSpecificationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaModelImpl <em>Xlia Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaModelImpl
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaModel()
		 * @generated
		 */
		EClass XLIA_MODEL = eINSTANCE.getXliaModel();

		/**
		 * The meta object literal for the '<em><b>Prolog</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XLIA_MODEL__PROLOG = eINSTANCE.getXliaModel_Prolog();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XLIA_MODEL__SYSTEM = eINSTANCE.getXliaModel_System();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaNamedElementImpl <em>Xlia Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaNamedElementImpl
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaNamedElement()
		 * @generated
		 */
		EClass XLIA_NAMED_ELEMENT = eINSTANCE.getXliaNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XLIA_NAMED_ELEMENT__NAME = eINSTANCE.getXliaNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaObjectImpl <em>Xlia Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaObjectImpl
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaObject()
		 * @generated
		 */
		EClass XLIA_OBJECT = eINSTANCE.getXliaObject();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XLIA_OBJECT__ELEMENTS = eINSTANCE.getXliaObject_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaSectionImpl <em>Xlia Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaSectionImpl
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaSection()
		 * @generated
		 */
		EClass XLIA_SECTION = eINSTANCE.getXliaSection();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XLIA_SECTION__ELEMENTS = eINSTANCE.getXliaSection_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.specification.impl.XliaAttributeImpl <em>Xlia Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.XliaAttributeImpl
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaAttribute()
		 * @generated
		 */
		EClass XLIA_ATTRIBUTE = eINSTANCE.getXliaAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XLIA_ATTRIBUTE__VALUE = eINSTANCE.getXliaAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.specification.XliaModelKind <em>Xlia Model Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.specification.XliaModelKind
		 * @see org.eclipse.efm.ecore.formalml.specification.impl.SpecificationPackageImpl#getXliaModelKind()
		 * @generated
		 */
		EEnum XLIA_MODEL_KIND = eINSTANCE.getXliaModelKind();

	}

} //SpecificationPackage
