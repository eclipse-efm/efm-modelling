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
package org.eclipse.efm.ecore.sew;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.efm.ecore.sew.SewFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface SewPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sew";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/SEW";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SEW";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SewPackage eINSTANCE = org.eclipse.efm.ecore.sew.impl.SewPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.impl.WNamedElementImpl <em>WNamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.impl.WNamedElementImpl
	 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWNamedElement()
	 * @generated
	 */
	int WNAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WNAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WNAMED_ELEMENT__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>WNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WNAMED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>WNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WNAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.impl.WObjectImpl <em>WObject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.impl.WObjectImpl
	 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWObject()
	 * @generated
	 */
	int WOBJECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WOBJECT__NAME = WNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WOBJECT__DESCRIPTION = WNAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WOBJECT__TYPE = WNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WOBJECT__ELEMENT = WNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>WObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WOBJECT_FEATURE_COUNT = WNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>WObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WOBJECT_OPERATION_COUNT = WNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.impl.SEWorkflowImpl <em>SE Workflow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.impl.SEWorkflowImpl
	 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getSEWorkflow()
	 * @generated
	 */
	int SE_WORKFLOW = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_WORKFLOW__NAME = WOBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_WORKFLOW__DESCRIPTION = WOBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_WORKFLOW__TYPE = WOBJECT__TYPE;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_WORKFLOW__ELEMENT = WOBJECT__ELEMENT;

	/**
	 * The number of structural features of the '<em>SE Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_WORKFLOW_FEATURE_COUNT = WOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>SE Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_WORKFLOW_OPERATION_COUNT = WOBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.impl.WPropertyImpl <em>WProperty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.impl.WPropertyImpl
	 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWProperty()
	 * @generated
	 */
	int WPROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPROPERTY__NAME = WNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPROPERTY__DESCRIPTION = WNAMED_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>WProperty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPROPERTY_FEATURE_COUNT = WNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>WProperty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPROPERTY_OPERATION_COUNT = WNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.impl.WSectionImpl <em>WSection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.impl.WSectionImpl
	 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWSection()
	 * @generated
	 */
	int WSECTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSECTION__NAME = WPROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSECTION__DESCRIPTION = WPROPERTY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSECTION__ELEMENT = WPROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>WSection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSECTION_FEATURE_COUNT = WPROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>WSection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSECTION_OPERATION_COUNT = WPROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.impl.WAttributeImpl <em>WAttribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.impl.WAttributeImpl
	 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWAttribute()
	 * @generated
	 */
	int WATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATTRIBUTE__NAME = WPROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATTRIBUTE__DESCRIPTION = WPROPERTY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATTRIBUTE__VALUE = WPROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>WAttribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATTRIBUTE_FEATURE_COUNT = WPROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>WAttribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATTRIBUTE_OPERATION_COUNT = WPROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.sew.impl.WValueSpecificationImpl <em>WValue Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.sew.impl.WValueSpecificationImpl
	 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWValueSpecification()
	 * @generated
	 */
	int WVALUE_SPECIFICATION = 6;

	/**
	 * The number of structural features of the '<em>WValue Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WVALUE_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>WValue Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WVALUE_SPECIFICATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.WNamedElement <em>WNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WNamed Element</em>'.
	 * @see org.eclipse.efm.ecore.sew.WNamedElement
	 * @generated
	 */
	EClass getWNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.WNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.efm.ecore.sew.WNamedElement#getName()
	 * @see #getWNamedElement()
	 * @generated
	 */
	EAttribute getWNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.WNamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.efm.ecore.sew.WNamedElement#getDescription()
	 * @see #getWNamedElement()
	 * @generated
	 */
	EAttribute getWNamedElement_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.SEWorkflow <em>SE Workflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SE Workflow</em>'.
	 * @see org.eclipse.efm.ecore.sew.SEWorkflow
	 * @generated
	 */
	EClass getSEWorkflow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.WObject <em>WObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WObject</em>'.
	 * @see org.eclipse.efm.ecore.sew.WObject
	 * @generated
	 */
	EClass getWObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.sew.WObject#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.efm.ecore.sew.WObject#getType()
	 * @see #getWObject()
	 * @generated
	 */
	EAttribute getWObject_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.sew.WObject#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.eclipse.efm.ecore.sew.WObject#getElement()
	 * @see #getWObject()
	 * @generated
	 */
	EReference getWObject_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.WProperty <em>WProperty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WProperty</em>'.
	 * @see org.eclipse.efm.ecore.sew.WProperty
	 * @generated
	 */
	EClass getWProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.WSection <em>WSection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WSection</em>'.
	 * @see org.eclipse.efm.ecore.sew.WSection
	 * @generated
	 */
	EClass getWSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.sew.WSection#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.eclipse.efm.ecore.sew.WSection#getElement()
	 * @see #getWSection()
	 * @generated
	 */
	EReference getWSection_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.WAttribute <em>WAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WAttribute</em>'.
	 * @see org.eclipse.efm.ecore.sew.WAttribute
	 * @generated
	 */
	EClass getWAttribute();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.sew.WAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.sew.WAttribute#getValue()
	 * @see #getWAttribute()
	 * @generated
	 */
	EReference getWAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.sew.WValueSpecification <em>WValue Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WValue Specification</em>'.
	 * @see org.eclipse.efm.ecore.sew.WValueSpecification
	 * @generated
	 */
	EClass getWValueSpecification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SewFactory getSewFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.impl.WNamedElementImpl <em>WNamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.impl.WNamedElementImpl
		 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWNamedElement()
		 * @generated
		 */
		EClass WNAMED_ELEMENT = eINSTANCE.getWNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WNAMED_ELEMENT__NAME = eINSTANCE.getWNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WNAMED_ELEMENT__DESCRIPTION = eINSTANCE.getWNamedElement_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.impl.SEWorkflowImpl <em>SE Workflow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.impl.SEWorkflowImpl
		 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getSEWorkflow()
		 * @generated
		 */
		EClass SE_WORKFLOW = eINSTANCE.getSEWorkflow();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.impl.WObjectImpl <em>WObject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.impl.WObjectImpl
		 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWObject()
		 * @generated
		 */
		EClass WOBJECT = eINSTANCE.getWObject();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WOBJECT__TYPE = eINSTANCE.getWObject_Type();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WOBJECT__ELEMENT = eINSTANCE.getWObject_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.impl.WPropertyImpl <em>WProperty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.impl.WPropertyImpl
		 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWProperty()
		 * @generated
		 */
		EClass WPROPERTY = eINSTANCE.getWProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.impl.WSectionImpl <em>WSection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.impl.WSectionImpl
		 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWSection()
		 * @generated
		 */
		EClass WSECTION = eINSTANCE.getWSection();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WSECTION__ELEMENT = eINSTANCE.getWSection_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.impl.WAttributeImpl <em>WAttribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.impl.WAttributeImpl
		 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWAttribute()
		 * @generated
		 */
		EClass WATTRIBUTE = eINSTANCE.getWAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WATTRIBUTE__VALUE = eINSTANCE.getWAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.sew.impl.WValueSpecificationImpl <em>WValue Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.sew.impl.WValueSpecificationImpl
		 * @see org.eclipse.efm.ecore.sew.impl.SewPackageImpl#getWValueSpecification()
		 * @generated
		 */
		EClass WVALUE_SPECIFICATION = eINSTANCE.getWValueSpecification();

	}

} //SewPackage
