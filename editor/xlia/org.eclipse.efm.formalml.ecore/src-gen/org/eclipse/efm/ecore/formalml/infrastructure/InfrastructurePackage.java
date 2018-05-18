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
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.infrastructure;

import org.eclipse.efm.ecore.formalml.common.CommonPackage;

import org.eclipse.efm.ecore.formalml.statemachine.StatemachinePackage;

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
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructureFactory
 * @model kind="package"
 * @generated
 */
public interface InfrastructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "infrastructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/FormalML/Infrastructure";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Infrastructure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InfrastructurePackage eINSTANCE = org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl <em>Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getMachine()
	 * @generated
	 */
	int MACHINE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__NAME = CommonPackage.CLASSIFIER_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__UNRESTRICTED_NAME = CommonPackage.CLASSIFIER_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__QUALIFIED_NAME = CommonPackage.CLASSIFIER_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__VISIBILITY = CommonPackage.CLASSIFIER_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Input enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__INPUT_ENABLED = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__TIMED = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dense timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__DENSE_TIMED = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Discrete timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__DISCRETE_TIMED = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Unsafe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__UNSAFE = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Design</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__DESIGN = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Property Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__PROPERTY_PART = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Composite Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__COMPOSITE_PART = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Behavior Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__BEHAVIOR_PART = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__MACHINE = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__TYPEDEF = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__VARIABLE = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__CHANNEL = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__PORT = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__SIGNAL = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__BUFFER = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__FUNCTION = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Routine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__ROUTINE = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__PROCEDURE = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__INSTANCE = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__BEHAVIOR = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Main</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__MAIN = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 21;

	/**
	 * The number of structural features of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_FEATURE_COUNT = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 22;

	/**
	 * The number of operations of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_OPERATION_COUNT = CommonPackage.CLASSIFIER_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl <em>Property Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getPropertyPart()
	 * @generated
	 */
	int PROPERTY_PART = 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART__TYPEDEF = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART__VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART__CHANNEL = 3;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART__PORT = 4;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART__SIGNAL = 5;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART__BUFFER = 6;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART__FUNCTION = 7;

	/**
	 * The number of structural features of the '<em>Property Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Property Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl <em>Composite Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getCompositePart()
	 * @generated
	 */
	int COMPOSITE_PART = 2;

	/**
	 * The feature id for the '<em><b>Routine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART__ROUTINE = 0;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART__PROCEDURE = 1;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART__MACHINE = 2;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART__INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART__BEHAVIOR = 4;

	/**
	 * The number of structural features of the '<em>Composite Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Composite Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorPartImpl <em>Behavior Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorPartImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getBehaviorPart()
	 * @generated
	 */
	int BEHAVIOR_PART = 3;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_PART__BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Main</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_PART__MAIN = 1;

	/**
	 * The number of structural features of the '<em>Behavior Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_PART_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Behavior Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.SystemImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = MACHINE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__UNRESTRICTED_NAME = MACHINE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__QUALIFIED_NAME = MACHINE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__VISIBILITY = MACHINE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Input enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__INPUT_ENABLED = MACHINE__INPUT_ENABLED;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__TIMED = MACHINE__TIMED;

	/**
	 * The feature id for the '<em><b>Dense timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DENSE_TIMED = MACHINE__DENSE_TIMED;

	/**
	 * The feature id for the '<em><b>Discrete timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DISCRETE_TIMED = MACHINE__DISCRETE_TIMED;

	/**
	 * The feature id for the '<em><b>Unsafe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__UNSAFE = MACHINE__UNSAFE;

	/**
	 * The feature id for the '<em><b>Design</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DESIGN = MACHINE__DESIGN;

	/**
	 * The feature id for the '<em><b>Property Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PROPERTY_PART = MACHINE__PROPERTY_PART;

	/**
	 * The feature id for the '<em><b>Composite Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__COMPOSITE_PART = MACHINE__COMPOSITE_PART;

	/**
	 * The feature id for the '<em><b>Behavior Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BEHAVIOR_PART = MACHINE__BEHAVIOR_PART;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__MACHINE = MACHINE__MACHINE;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__TYPEDEF = MACHINE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__VARIABLE = MACHINE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CHANNEL = MACHINE__CHANNEL;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PORT = MACHINE__PORT;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SIGNAL = MACHINE__SIGNAL;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BUFFER = MACHINE__BUFFER;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__FUNCTION = MACHINE__FUNCTION;

	/**
	 * The feature id for the '<em><b>Routine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ROUTINE = MACHINE__ROUTINE;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PROCEDURE = MACHINE__PROCEDURE;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__INSTANCE = MACHINE__INSTANCE;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BEHAVIOR = MACHINE__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Main</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__MAIN = MACHINE__MAIN;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = MACHINE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = MACHINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModifierImpl <em>Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ModifierImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getModifier()
	 * @generated
	 */
	int MODIFIER = 5;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__STATIC = 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__FINAL = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__VOLATILE = 3;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__TRANSIENT = 4;

	/**
	 * The number of structural features of the '<em>Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyDefinitionImpl <em>Property Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyDefinitionImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getPropertyDefinition()
	 * @generated
	 */
	int PROPERTY_DEFINITION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__NAME = CommonPackage.TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__UNRESTRICTED_NAME = CommonPackage.TYPED_ELEMENT__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__QUALIFIED_NAME = CommonPackage.TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__VISIBILITY = CommonPackage.TYPED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__TYPE = CommonPackage.TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__MODIFIER = CommonPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__DEFAULT_VALUE = CommonPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION_FEATURE_COUNT = CommonPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Property Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION_OPERATION_COUNT = CommonPackage.TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.VariableImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = PROPERTY_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__UNRESTRICTED_NAME = PROPERTY_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__QUALIFIED_NAME = PROPERTY_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VISIBILITY = PROPERTY_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = PROPERTY_DEFINITION__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__MODIFIER = PROPERTY_DEFINITION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DEFAULT_VALUE = PROPERTY_DEFINITION__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CONST = PROPERTY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__REFERENCE = PROPERTY_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Macro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__MACRO = PROPERTY_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>On Write Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ON_WRITE_ACTION = PROPERTY_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = PROPERTY_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = PROPERTY_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.BufferImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__NAME = PROPERTY_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__UNRESTRICTED_NAME = PROPERTY_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__QUALIFIED_NAME = PROPERTY_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__VISIBILITY = PROPERTY_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__TYPE = PROPERTY_DEFINITION__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__MODIFIER = PROPERTY_DEFINITION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__DEFAULT_VALUE = PROPERTY_DEFINITION__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__PROTOCOL = PROPERTY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__CAST = PROPERTY_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inner buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__INNER_BUFFER = PROPERTY_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__BUFFER = PROPERTY_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = PROPERTY_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = PROPERTY_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.PortImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getPort()
	 * @generated
	 */
	int PORT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = PROPERTY_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__UNRESTRICTED_NAME = PROPERTY_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__QUALIFIED_NAME = PROPERTY_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__VISIBILITY = PROPERTY_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = PROPERTY_DEFINITION__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__MODIFIER = PROPERTY_DEFINITION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DEFAULT_VALUE = PROPERTY_DEFINITION__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DIRECTION = PROPERTY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__SIGNAL = PROPERTY_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PARAMETER = PROPERTY_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = PROPERTY_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = PROPERTY_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ChannelImpl <em>Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ChannelImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getChannel()
	 * @generated
	 */
	int CHANNEL = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__NAME = PROPERTY_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__UNRESTRICTED_NAME = PROPERTY_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__QUALIFIED_NAME = PROPERTY_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__VISIBILITY = PROPERTY_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__TYPE = PROPERTY_DEFINITION__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__MODIFIER = PROPERTY_DEFINITION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__DEFAULT_VALUE = PROPERTY_DEFINITION__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__DIRECTION = PROPERTY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__MACHINE = PROPERTY_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__PORT = PROPERTY_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__SIGNAL = PROPERTY_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_FEATURE_COUNT = PROPERTY_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_OPERATION_COUNT = PROPERTY_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.SignalImpl <em>Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.SignalImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getSignal()
	 * @generated
	 */
	int SIGNAL = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__NAME = CommonPackage.CLASSIFIER_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__UNRESTRICTED_NAME = CommonPackage.CLASSIFIER_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__QUALIFIED_NAME = CommonPackage.CLASSIFIER_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__VISIBILITY = CommonPackage.CLASSIFIER_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__DIRECTION = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__PARAMETER = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_FEATURE_COUNT = CommonPackage.CLASSIFIER_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_OPERATION_COUNT = CommonPackage.CLASSIFIER_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.FunctionImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = PROPERTY_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__UNRESTRICTED_NAME = PROPERTY_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__QUALIFIED_NAME = PROPERTY_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__VISIBILITY = PROPERTY_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__TYPE = PROPERTY_DEFINITION__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__MODIFIER = PROPERTY_DEFINITION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DEFAULT_VALUE = PROPERTY_DEFINITION__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ARGUMENT = PROPERTY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RESULT = PROPERTY_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = PROPERTY_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = PROPERTY_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorImpl <em>Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getBehavior()
	 * @generated
	 */
	int BEHAVIOR = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__NAME = MACHINE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__UNRESTRICTED_NAME = MACHINE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__QUALIFIED_NAME = MACHINE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__VISIBILITY = MACHINE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Input enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__INPUT_ENABLED = MACHINE__INPUT_ENABLED;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__TIMED = MACHINE__TIMED;

	/**
	 * The feature id for the '<em><b>Dense timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__DENSE_TIMED = MACHINE__DENSE_TIMED;

	/**
	 * The feature id for the '<em><b>Discrete timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__DISCRETE_TIMED = MACHINE__DISCRETE_TIMED;

	/**
	 * The feature id for the '<em><b>Unsafe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__UNSAFE = MACHINE__UNSAFE;

	/**
	 * The feature id for the '<em><b>Design</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__DESIGN = MACHINE__DESIGN;

	/**
	 * The feature id for the '<em><b>Property Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__PROPERTY_PART = MACHINE__PROPERTY_PART;

	/**
	 * The feature id for the '<em><b>Composite Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__COMPOSITE_PART = MACHINE__COMPOSITE_PART;

	/**
	 * The feature id for the '<em><b>Behavior Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BEHAVIOR_PART = MACHINE__BEHAVIOR_PART;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__MACHINE = MACHINE__MACHINE;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__TYPEDEF = MACHINE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__VARIABLE = MACHINE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__CHANNEL = MACHINE__CHANNEL;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__PORT = MACHINE__PORT;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__SIGNAL = MACHINE__SIGNAL;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BUFFER = MACHINE__BUFFER;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__FUNCTION = MACHINE__FUNCTION;

	/**
	 * The feature id for the '<em><b>Routine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__ROUTINE = MACHINE__ROUTINE;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__PROCEDURE = MACHINE__PROCEDURE;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__INSTANCE = MACHINE__INSTANCE;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BEHAVIOR = MACHINE__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Main</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__MAIN = MACHINE__MAIN;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__PARAMETER = MACHINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Computation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__COMPUTATION = MACHINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Execution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__EXECUTION = MACHINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Interaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__INTERACTION = MACHINE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_FEATURE_COUNT = MACHINE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_OPERATION_COUNT = MACHINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ProcedureImpl <em>Procedure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ProcedureImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getProcedure()
	 * @generated
	 */
	int PROCEDURE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NAME = StatemachinePackage.STATEMACHINE__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__UNRESTRICTED_NAME = StatemachinePackage.STATEMACHINE__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__QUALIFIED_NAME = StatemachinePackage.STATEMACHINE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__VISIBILITY = StatemachinePackage.STATEMACHINE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Input enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__INPUT_ENABLED = StatemachinePackage.STATEMACHINE__INPUT_ENABLED;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__TIMED = StatemachinePackage.STATEMACHINE__TIMED;

	/**
	 * The feature id for the '<em><b>Dense timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__DENSE_TIMED = StatemachinePackage.STATEMACHINE__DENSE_TIMED;

	/**
	 * The feature id for the '<em><b>Discrete timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__DISCRETE_TIMED = StatemachinePackage.STATEMACHINE__DISCRETE_TIMED;

	/**
	 * The feature id for the '<em><b>Unsafe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__UNSAFE = StatemachinePackage.STATEMACHINE__UNSAFE;

	/**
	 * The feature id for the '<em><b>Design</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__DESIGN = StatemachinePackage.STATEMACHINE__DESIGN;

	/**
	 * The feature id for the '<em><b>Property Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__PROPERTY_PART = StatemachinePackage.STATEMACHINE__PROPERTY_PART;

	/**
	 * The feature id for the '<em><b>Composite Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__COMPOSITE_PART = StatemachinePackage.STATEMACHINE__COMPOSITE_PART;

	/**
	 * The feature id for the '<em><b>Behavior Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__BEHAVIOR_PART = StatemachinePackage.STATEMACHINE__BEHAVIOR_PART;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__MACHINE = StatemachinePackage.STATEMACHINE__MACHINE;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__TYPEDEF = StatemachinePackage.STATEMACHINE__TYPEDEF;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__VARIABLE = StatemachinePackage.STATEMACHINE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__CHANNEL = StatemachinePackage.STATEMACHINE__CHANNEL;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__PORT = StatemachinePackage.STATEMACHINE__PORT;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__SIGNAL = StatemachinePackage.STATEMACHINE__SIGNAL;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__BUFFER = StatemachinePackage.STATEMACHINE__BUFFER;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__FUNCTION = StatemachinePackage.STATEMACHINE__FUNCTION;

	/**
	 * The feature id for the '<em><b>Routine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__ROUTINE = StatemachinePackage.STATEMACHINE__ROUTINE;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__PROCEDURE = StatemachinePackage.STATEMACHINE__PROCEDURE;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__INSTANCE = StatemachinePackage.STATEMACHINE__INSTANCE;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__BEHAVIOR = StatemachinePackage.STATEMACHINE__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Main</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__MAIN = StatemachinePackage.STATEMACHINE__MAIN;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__PARAMETER = StatemachinePackage.STATEMACHINE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Computation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__COMPUTATION = StatemachinePackage.STATEMACHINE__COMPUTATION;

	/**
	 * The feature id for the '<em><b>Execution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__EXECUTION = StatemachinePackage.STATEMACHINE__EXECUTION;

	/**
	 * The feature id for the '<em><b>Interaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__INTERACTION = StatemachinePackage.STATEMACHINE__INTERACTION;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__REGION = StatemachinePackage.STATEMACHINE__REGION;

	/**
	 * The number of structural features of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_FEATURE_COUNT = StatemachinePackage.STATEMACHINE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_OPERATION_COUNT = StatemachinePackage.STATEMACHINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl <em>Routine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getRoutine()
	 * @generated
	 */
	int ROUTINE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE__NAME = CommonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE__UNRESTRICTED_NAME = CommonPackage.NAMED_ELEMENT__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE__QUALIFIED_NAME = CommonPackage.NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE__VISIBILITY = CommonPackage.NAMED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE__PARAMETER = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE__BODY_BLOCK = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE__DOMAIN = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Codomain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE__CODOMAIN = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Routine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE_FEATURE_COUNT = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Routine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTINE_OPERATION_COUNT = CommonPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.InstanceMachineImpl <em>Instance Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InstanceMachineImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getInstanceMachine()
	 * @generated
	 */
	int INSTANCE_MACHINE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__NAME = CommonPackage.TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__UNRESTRICTED_NAME = CommonPackage.TYPED_ELEMENT__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__QUALIFIED_NAME = CommonPackage.TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__VISIBILITY = CommonPackage.TYPED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__TYPE = CommonPackage.TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__MODIFIER = CommonPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__MODEL = CommonPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__ARG = CommonPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE__SLOT = CommonPackage.TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Instance Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE_FEATURE_COUNT = CommonPackage.TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Instance Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_MACHINE_OPERATION_COUNT = CommonPackage.TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.SlotPropertyImpl <em>Slot Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.SlotPropertyImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getSlotProperty()
	 * @generated
	 */
	int SLOT_PROPERTY = 16;

	/**
	 * The feature id for the '<em><b>Xlia Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROPERTY__XLIA_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Slot Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Slot Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ParameterImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = PROPERTY_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__UNRESTRICTED_NAME = PROPERTY_DEFINITION__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__QUALIFIED_NAME = PROPERTY_DEFINITION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VISIBILITY = PROPERTY_DEFINITION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = PROPERTY_DEFINITION__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MODIFIER = PROPERTY_DEFINITION__MODIFIER;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DEFAULT_VALUE = PROPERTY_DEFINITION__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DIRECTION = PROPERTY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = PROPERTY_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = PROPERTY_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ParameterSetImpl <em>Parameter Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ParameterSetImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getParameterSet()
	 * @generated
	 */
	int PARAMETER_SET = 18;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SET__PARAMETER = 0;

	/**
	 * The number of structural features of the '<em>Parameter Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Parameter Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfComputationImpl <em>Model Of Computation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfComputationImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getModelOfComputation()
	 * @generated
	 */
	int MODEL_OF_COMPUTATION = 20;

	/**
	 * The number of structural features of the '<em>Model Of Computation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_COMPUTATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Model Of Computation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_COMPUTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl <em>Model Of Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getModelOfExecution()
	 * @generated
	 */
	int MODEL_OF_EXECUTION = 21;

	/**
	 * The feature id for the '<em><b>Init Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__INIT_ROUTINE = 0;

	/**
	 * The feature id for the '<em><b>Final Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__FINAL_ROUTINE = 1;

	/**
	 * The feature id for the '<em><b>Enable Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__ENABLE_ROUTINE = 2;

	/**
	 * The feature id for the '<em><b>Disable Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__DISABLE_ROUTINE = 3;

	/**
	 * The feature id for the '<em><b>Concurrency Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE = 4;

	/**
	 * The feature id for the '<em><b>Schedule Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__SCHEDULE_ROUTINE = 5;

	/**
	 * The feature id for the '<em><b>Irun Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__IRUN_ROUTINE = 6;

	/**
	 * The feature id for the '<em><b>Run Routine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__RUN_ROUTINE = 7;

	/**
	 * The feature id for the '<em><b>Routine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION__ROUTINE = 8;

	/**
	 * The number of structural features of the '<em>Model Of Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Model Of Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_EXECUTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfInteractionImpl <em>Model Of Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfInteractionImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getModelOfInteraction()
	 * @generated
	 */
	int MODEL_OF_INTERACTION = 22;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_INTERACTION__ROUTES = 0;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_INTERACTION__CONNECTIONS = 1;

	/**
	 * The number of structural features of the '<em>Model Of Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_INTERACTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model Of Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OF_INTERACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ComProtocolImpl <em>Com Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ComProtocolImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getComProtocol()
	 * @generated
	 */
	int COM_PROTOCOL = 23;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_PROTOCOL__PROTOCOL = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_PROTOCOL__CAST = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inner buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_PROTOCOL__INNER_BUFFER = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_PROTOCOL__BUFFER = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Com Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_PROTOCOL_FEATURE_COUNT = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Com Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_PROTOCOL_OPERATION_COUNT = CommonPackage.ABSTRACT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RouteImpl <em>Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.RouteImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getRoute()
	 * @generated
	 */
	int ROUTE = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__NAME = CommonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__UNRESTRICTED_NAME = CommonPackage.NAMED_ELEMENT__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__QUALIFIED_NAME = CommonPackage.NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__VISIBILITY = CommonPackage.NAMED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__SIGNALS = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__PROTOCOL = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_FEATURE_COUNT = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_OPERATION_COUNT = CommonPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ConnectorImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__NAME = CommonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Unrestricted Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__UNRESTRICTED_NAME = CommonPackage.NAMED_ELEMENT__UNRESTRICTED_NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__QUALIFIED_NAME = CommonPackage.NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__VISIBILITY = CommonPackage.NAMED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PROTOCOL = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__CAST = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Com Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__COM_POINTS = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = CommonPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_OPERATION_COUNT = CommonPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ComPointImpl <em>Com Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ComPointImpl
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getComPoint()
	 * @generated
	 */
	int COM_POINT = 26;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_POINT__DIRECTION = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_POINT__PROTOCOL = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Point</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_POINT__POINT = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_POINT__POINTS = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Com Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_POINT_FEATURE_COUNT = CommonPackage.ABSTRACT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Com Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_POINT_OPERATION_COUNT = CommonPackage.ABSTRACT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.DesignKind <em>Design Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.DesignKind
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getDesignKind()
	 * @generated
	 */
	int DESIGN_KIND = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection <em>Channel Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getChannelDirection()
	 * @generated
	 */
	int CHANNEL_DIRECTION = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ParameterDirectionKind <em>Parameter Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ParameterDirectionKind
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getParameterDirectionKind()
	 * @generated
	 */
	int PARAMETER_DIRECTION_KIND = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind <em>Com Protocol Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getComProtocolKind()
	 * @generated
	 */
	int COM_PROTOCOL_KIND = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind <em>Com Cast Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getComCastKind()
	 * @generated
	 */
	int COM_CAST_KIND = 31;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine
	 * @generated
	 */
	EClass getMachine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isInput_enabled <em>Input enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input enabled</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#isInput_enabled()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Input_enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isTimed <em>Timed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timed</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#isTimed()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Timed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isDense_timed <em>Dense timed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dense timed</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#isDense_timed()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Dense_timed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isDiscrete_timed <em>Discrete timed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discrete timed</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#isDiscrete_timed()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Discrete_timed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isUnsafe <em>Unsafe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsafe</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#isUnsafe()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Unsafe();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getDesign <em>Design</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Design</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getDesign()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Design();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getPropertyPart <em>Property Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property Part</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getPropertyPart()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_PropertyPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getCompositePart <em>Composite Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Composite Part</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getCompositePart()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_CompositePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBehaviorPart <em>Behavior Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior Part</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBehaviorPart()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_BehaviorPart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getMachine()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Machine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getTypedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Typedef</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getTypedef()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Typedef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getVariable()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Variable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Channel</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getChannel()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Channel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getPort()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Port();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signal</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getSignal()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Signal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBuffer()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Buffer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getFunction()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Function();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getRoutine <em>Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getRoutine()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Routine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getProcedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Procedure</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getProcedure()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Procedure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getInstance()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Instance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBehavior()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Behavior();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Main</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Machine#getMain()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Main();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart <em>Property Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Part</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart
	 * @generated
	 */
	EClass getPropertyPart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getParameter()
	 * @see #getPropertyPart()
	 * @generated
	 */
	EReference getPropertyPart_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getTypedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Typedef</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getTypedef()
	 * @see #getPropertyPart()
	 * @generated
	 */
	EReference getPropertyPart_Typedef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getVariable()
	 * @see #getPropertyPart()
	 * @generated
	 */
	EReference getPropertyPart_Variable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Channel</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getChannel()
	 * @see #getPropertyPart()
	 * @generated
	 */
	EReference getPropertyPart_Channel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getPort()
	 * @see #getPropertyPart()
	 * @generated
	 */
	EReference getPropertyPart_Port();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signal</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getSignal()
	 * @see #getPropertyPart()
	 * @generated
	 */
	EReference getPropertyPart_Signal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getBuffer()
	 * @see #getPropertyPart()
	 * @generated
	 */
	EReference getPropertyPart_Buffer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart#getFunction()
	 * @see #getPropertyPart()
	 * @generated
	 */
	EReference getPropertyPart_Function();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart <em>Composite Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Part</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.CompositePart
	 * @generated
	 */
	EClass getCompositePart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getRoutine <em>Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getRoutine()
	 * @see #getCompositePart()
	 * @generated
	 */
	EReference getCompositePart_Routine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getMachine()
	 * @see #getCompositePart()
	 * @generated
	 */
	EReference getCompositePart_Machine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getProcedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Procedure</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getProcedure()
	 * @see #getCompositePart()
	 * @generated
	 */
	EReference getCompositePart_Procedure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getInstance()
	 * @see #getCompositePart()
	 * @generated
	 */
	EReference getCompositePart_Instance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.CompositePart#getBehavior()
	 * @see #getCompositePart()
	 * @generated
	 */
	EReference getCompositePart_Behavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.BehaviorPart <em>Behavior Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Part</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.BehaviorPart
	 * @generated
	 */
	EClass getBehaviorPart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.BehaviorPart#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.BehaviorPart#getBehavior()
	 * @see #getBehaviorPart()
	 * @generated
	 */
	EReference getBehaviorPart_Behavior();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.BehaviorPart#getMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Main</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.BehaviorPart#getMain()
	 * @see #getBehaviorPart()
	 * @generated
	 */
	EReference getBehaviorPart_Main();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Modifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifier</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Modifier
	 * @generated
	 */
	EClass getModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isStatic()
	 * @see #getModifier()
	 * @generated
	 */
	EAttribute getModifier_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isFinal()
	 * @see #getModifier()
	 * @generated
	 */
	EAttribute getModifier_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isReference()
	 * @see #getModifier()
	 * @generated
	 */
	EAttribute getModifier_Reference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isVolatile <em>Volatile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volatile</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isVolatile()
	 * @see #getModifier()
	 * @generated
	 */
	EAttribute getModifier_Volatile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isTransient <em>Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transient</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Modifier#isTransient()
	 * @see #getModifier()
	 * @generated
	 */
	EAttribute getModifier_Transient();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition <em>Property Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Definition</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition
	 * @generated
	 */
	EClass getPropertyDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Modifier</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition#getModifier()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EReference getPropertyDefinition_Modifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition#getDefaultValue()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EReference getPropertyDefinition_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#isConst <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Const</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Variable#isConst()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Const();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#isReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Variable#isReference()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Reference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#isMacro <em>Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Macro</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Variable#isMacro()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Macro();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Variable#getOnWriteAction <em>On Write Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Write Action</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Variable#getOnWriteAction()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_OnWriteAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Port#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Port#getDirection()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Direction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Port#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signal</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Port#getSignal()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Signal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Port#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Port#getParameter()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Channel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Channel
	 * @generated
	 */
	EClass getChannel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Channel#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Channel#getDirection()
	 * @see #getChannel()
	 * @generated
	 */
	EAttribute getChannel_Direction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Channel#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Channel#getMachine()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Machine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Channel#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Channel#getPort()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Port();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Channel#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signal</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Channel#getSignal()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Signal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Signal
	 * @generated
	 */
	EClass getSignal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Signal#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Signal#getDirection()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_Direction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Signal#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Signal#getParameter()
	 * @see #getSignal()
	 * @generated
	 */
	EReference getSignal_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Function#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Function#getArgument()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Argument();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Function#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Function#getResult()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Procedure
	 * @generated
	 */
	EClass getProcedure();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine <em>Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Routine
	 * @generated
	 */
	EClass getRoutine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Routine#getParameter()
	 * @see #getRoutine()
	 * @generated
	 */
	EReference getRoutine_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getBodyBlock <em>Body Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Block</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Routine#getBodyBlock()
	 * @see #getRoutine()
	 * @generated
	 */
	EReference getRoutine_BodyBlock();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Routine#getDomain()
	 * @see #getRoutine()
	 * @generated
	 */
	EReference getRoutine_Domain();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Routine#getCodomain <em>Codomain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Codomain</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Routine#getCodomain()
	 * @see #getRoutine()
	 * @generated
	 */
	EReference getRoutine_Codomain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine <em>Instance Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Machine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine
	 * @generated
	 */
	EClass getInstanceMachine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Modifier</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine#getModifier()
	 * @see #getInstanceMachine()
	 * @generated
	 */
	EReference getInstanceMachine_Modifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine#getModel()
	 * @see #getInstanceMachine()
	 * @generated
	 */
	EReference getInstanceMachine_Model();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine#getArg <em>Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Arg</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine#getArg()
	 * @see #getInstanceMachine()
	 * @generated
	 */
	EReference getInstanceMachine_Arg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine#getSlot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slot</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine#getSlot()
	 * @see #getInstanceMachine()
	 * @generated
	 */
	EReference getInstanceMachine_Slot();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty <em>Slot Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot Property</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty
	 * @generated
	 */
	EClass getSlotProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty#getXliaProperty <em>Xlia Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Xlia Property</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty#getXliaProperty()
	 * @see #getSlotProperty()
	 * @generated
	 */
	EReference getSlotProperty_XliaProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty#getValue()
	 * @see #getSlotProperty()
	 * @generated
	 */
	EReference getSlotProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Parameter#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Parameter#getDirection()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Direction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet <em>Parameter Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Set</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet
	 * @generated
	 */
	EClass getParameterSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet#getParameter()
	 * @see #getParameterSet()
	 * @generated
	 */
	EReference getParameterSet_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Behavior
	 * @generated
	 */
	EClass getBehavior();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getParameter()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getComputation <em>Computation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Computation</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getComputation()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_Computation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getExecution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Execution</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getExecution()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_Execution();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interaction</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Behavior#getInteraction()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_Interaction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfComputation <em>Model Of Computation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Of Computation</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfComputation
	 * @generated
	 */
	EClass getModelOfComputation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution <em>Model Of Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Of Execution</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution
	 * @generated
	 */
	EClass getModelOfExecution();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getInitRoutine <em>Init Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getInitRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_InitRoutine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getFinalRoutine <em>Final Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Final Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getFinalRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_FinalRoutine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getEnableRoutine <em>Enable Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enable Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getEnableRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_EnableRoutine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getDisableRoutine <em>Disable Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Disable Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getDisableRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_DisableRoutine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getConcurrencyRoutine <em>Concurrency Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Concurrency Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getConcurrencyRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_ConcurrencyRoutine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getScheduleRoutine <em>Schedule Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Schedule Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getScheduleRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_ScheduleRoutine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getIrunRoutine <em>Irun Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Irun Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getIrunRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_IrunRoutine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getRunRoutine <em>Run Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Run Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getRunRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_RunRoutine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getRoutine <em>Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routine</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfExecution#getRoutine()
	 * @see #getModelOfExecution()
	 * @generated
	 */
	EReference getModelOfExecution_Routine();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction <em>Model Of Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Of Interaction</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction
	 * @generated
	 */
	EClass getModelOfInteraction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction#getRoutes()
	 * @see #getModelOfInteraction()
	 * @generated
	 */
	EReference getModelOfInteraction_Routes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ModelOfInteraction#getConnections()
	 * @see #getModelOfInteraction()
	 * @generated
	 */
	EReference getModelOfInteraction_Connections();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol <em>Com Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Com Protocol</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol
	 * @generated
	 */
	EClass getComProtocol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protocol</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getProtocol()
	 * @see #getComProtocol()
	 * @generated
	 */
	EAttribute getComProtocol_Protocol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getCast <em>Cast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cast</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getCast()
	 * @see #getComProtocol()
	 * @generated
	 */
	EAttribute getComProtocol_Cast();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getInner_buffer <em>Inner buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inner buffer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getInner_buffer()
	 * @see #getComProtocol()
	 * @generated
	 */
	EReference getComProtocol_Inner_buffer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocol#getBuffer()
	 * @see #getComProtocol()
	 * @generated
	 */
	EReference getComProtocol_Buffer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Route <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Route
	 * @generated
	 */
	EClass getRoute();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Route#getSignals <em>Signals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Signals</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Route#getSignals()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Signals();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Route#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Protocol</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Route#getProtocol()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Protocol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Protocol</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Connector#getProtocol()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Protocol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector#getCast <em>Cast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cast</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Connector#getCast()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_Cast();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.Connector#getComPoints <em>Com Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Com Points</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.Connector#getComPoints()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_ComPoints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComPoint <em>Com Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Com Point</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComPoint
	 * @generated
	 */
	EClass getComPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComPoint#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComPoint#getDirection()
	 * @see #getComPoint()
	 * @generated
	 */
	EAttribute getComPoint_Direction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComPoint#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Protocol</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComPoint#getProtocol()
	 * @see #getComPoint()
	 * @generated
	 */
	EReference getComPoint_Protocol();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComPoint#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Point</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComPoint#getPoint()
	 * @see #getComPoint()
	 * @generated
	 */
	EReference getComPoint_Point();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComPoint#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComPoint#getPoints()
	 * @see #getComPoint()
	 * @generated
	 */
	EReference getComPoint_Points();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.infrastructure.DesignKind <em>Design Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Design Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.DesignKind
	 * @generated
	 */
	EEnum getDesignKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection <em>Channel Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Channel Direction</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection
	 * @generated
	 */
	EEnum getChannelDirection();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.infrastructure.ParameterDirectionKind <em>Parameter Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Parameter Direction Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ParameterDirectionKind
	 * @generated
	 */
	EEnum getParameterDirectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind <em>Com Protocol Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Com Protocol Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind
	 * @generated
	 */
	EEnum getComProtocolKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind <em>Com Cast Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Com Cast Kind</em>'.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind
	 * @generated
	 */
	EEnum getComCastKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InfrastructureFactory getInfrastructureFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl <em>Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getMachine()
		 * @generated
		 */
		EClass MACHINE = eINSTANCE.getMachine();

		/**
		 * The meta object literal for the '<em><b>Input enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__INPUT_ENABLED = eINSTANCE.getMachine_Input_enabled();

		/**
		 * The meta object literal for the '<em><b>Timed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__TIMED = eINSTANCE.getMachine_Timed();

		/**
		 * The meta object literal for the '<em><b>Dense timed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__DENSE_TIMED = eINSTANCE.getMachine_Dense_timed();

		/**
		 * The meta object literal for the '<em><b>Discrete timed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__DISCRETE_TIMED = eINSTANCE.getMachine_Discrete_timed();

		/**
		 * The meta object literal for the '<em><b>Unsafe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__UNSAFE = eINSTANCE.getMachine_Unsafe();

		/**
		 * The meta object literal for the '<em><b>Design</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__DESIGN = eINSTANCE.getMachine_Design();

		/**
		 * The meta object literal for the '<em><b>Property Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__PROPERTY_PART = eINSTANCE.getMachine_PropertyPart();

		/**
		 * The meta object literal for the '<em><b>Composite Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__COMPOSITE_PART = eINSTANCE.getMachine_CompositePart();

		/**
		 * The meta object literal for the '<em><b>Behavior Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__BEHAVIOR_PART = eINSTANCE.getMachine_BehaviorPart();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__MACHINE = eINSTANCE.getMachine_Machine();

		/**
		 * The meta object literal for the '<em><b>Typedef</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__TYPEDEF = eINSTANCE.getMachine_Typedef();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__VARIABLE = eINSTANCE.getMachine_Variable();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__CHANNEL = eINSTANCE.getMachine_Channel();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__PORT = eINSTANCE.getMachine_Port();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__SIGNAL = eINSTANCE.getMachine_Signal();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__BUFFER = eINSTANCE.getMachine_Buffer();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__FUNCTION = eINSTANCE.getMachine_Function();

		/**
		 * The meta object literal for the '<em><b>Routine</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__ROUTINE = eINSTANCE.getMachine_Routine();

		/**
		 * The meta object literal for the '<em><b>Procedure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__PROCEDURE = eINSTANCE.getMachine_Procedure();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__INSTANCE = eINSTANCE.getMachine_Instance();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__BEHAVIOR = eINSTANCE.getMachine_Behavior();

		/**
		 * The meta object literal for the '<em><b>Main</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__MAIN = eINSTANCE.getMachine_Main();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl <em>Property Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getPropertyPart()
		 * @generated
		 */
		EClass PROPERTY_PART = eINSTANCE.getPropertyPart();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PART__PARAMETER = eINSTANCE.getPropertyPart_Parameter();

		/**
		 * The meta object literal for the '<em><b>Typedef</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PART__TYPEDEF = eINSTANCE.getPropertyPart_Typedef();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PART__VARIABLE = eINSTANCE.getPropertyPart_Variable();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PART__CHANNEL = eINSTANCE.getPropertyPart_Channel();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PART__PORT = eINSTANCE.getPropertyPart_Port();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PART__SIGNAL = eINSTANCE.getPropertyPart_Signal();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PART__BUFFER = eINSTANCE.getPropertyPart_Buffer();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PART__FUNCTION = eINSTANCE.getPropertyPart_Function();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl <em>Composite Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.CompositePartImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getCompositePart()
		 * @generated
		 */
		EClass COMPOSITE_PART = eINSTANCE.getCompositePart();

		/**
		 * The meta object literal for the '<em><b>Routine</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PART__ROUTINE = eINSTANCE.getCompositePart_Routine();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PART__MACHINE = eINSTANCE.getCompositePart_Machine();

		/**
		 * The meta object literal for the '<em><b>Procedure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PART__PROCEDURE = eINSTANCE.getCompositePart_Procedure();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PART__INSTANCE = eINSTANCE.getCompositePart_Instance();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PART__BEHAVIOR = eINSTANCE.getCompositePart_Behavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorPartImpl <em>Behavior Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorPartImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getBehaviorPart()
		 * @generated
		 */
		EClass BEHAVIOR_PART = eINSTANCE.getBehaviorPart();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_PART__BEHAVIOR = eINSTANCE.getBehaviorPart_Behavior();

		/**
		 * The meta object literal for the '<em><b>Main</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_PART__MAIN = eINSTANCE.getBehaviorPart_Main();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.SystemImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModifierImpl <em>Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ModifierImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getModifier()
		 * @generated
		 */
		EClass MODIFIER = eINSTANCE.getModifier();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIER__STATIC = eINSTANCE.getModifier_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIER__FINAL = eINSTANCE.getModifier_Final();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIER__REFERENCE = eINSTANCE.getModifier_Reference();

		/**
		 * The meta object literal for the '<em><b>Volatile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIER__VOLATILE = eINSTANCE.getModifier_Volatile();

		/**
		 * The meta object literal for the '<em><b>Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIER__TRANSIENT = eINSTANCE.getModifier_Transient();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyDefinitionImpl <em>Property Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyDefinitionImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getPropertyDefinition()
		 * @generated
		 */
		EClass PROPERTY_DEFINITION = eINSTANCE.getPropertyDefinition();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DEFINITION__MODIFIER = eINSTANCE.getPropertyDefinition_Modifier();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DEFINITION__DEFAULT_VALUE = eINSTANCE.getPropertyDefinition_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.VariableImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__CONST = eINSTANCE.getVariable_Const();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__REFERENCE = eINSTANCE.getVariable_Reference();

		/**
		 * The meta object literal for the '<em><b>Macro</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__MACRO = eINSTANCE.getVariable_Macro();

		/**
		 * The meta object literal for the '<em><b>On Write Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__ON_WRITE_ACTION = eINSTANCE.getVariable_OnWriteAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BufferImpl <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.BufferImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getBuffer()
		 * @generated
		 */
		EClass BUFFER = eINSTANCE.getBuffer();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.PortImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__DIRECTION = eINSTANCE.getPort_Direction();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__SIGNAL = eINSTANCE.getPort_Signal();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__PARAMETER = eINSTANCE.getPort_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ChannelImpl <em>Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ChannelImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getChannel()
		 * @generated
		 */
		EClass CHANNEL = eINSTANCE.getChannel();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANNEL__DIRECTION = eINSTANCE.getChannel_Direction();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__MACHINE = eINSTANCE.getChannel_Machine();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__PORT = eINSTANCE.getChannel_Port();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__SIGNAL = eINSTANCE.getChannel_Signal();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.SignalImpl <em>Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.SignalImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getSignal()
		 * @generated
		 */
		EClass SIGNAL = eINSTANCE.getSignal();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL__DIRECTION = eINSTANCE.getSignal_Direction();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNAL__PARAMETER = eINSTANCE.getSignal_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.FunctionImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__ARGUMENT = eINSTANCE.getFunction_Argument();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__RESULT = eINSTANCE.getFunction_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ProcedureImpl <em>Procedure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ProcedureImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getProcedure()
		 * @generated
		 */
		EClass PROCEDURE = eINSTANCE.getProcedure();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl <em>Routine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getRoutine()
		 * @generated
		 */
		EClass ROUTINE = eINSTANCE.getRoutine();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTINE__PARAMETER = eINSTANCE.getRoutine_Parameter();

		/**
		 * The meta object literal for the '<em><b>Body Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTINE__BODY_BLOCK = eINSTANCE.getRoutine_BodyBlock();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTINE__DOMAIN = eINSTANCE.getRoutine_Domain();

		/**
		 * The meta object literal for the '<em><b>Codomain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTINE__CODOMAIN = eINSTANCE.getRoutine_Codomain();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.InstanceMachineImpl <em>Instance Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InstanceMachineImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getInstanceMachine()
		 * @generated
		 */
		EClass INSTANCE_MACHINE = eINSTANCE.getInstanceMachine();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_MACHINE__MODIFIER = eINSTANCE.getInstanceMachine_Modifier();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_MACHINE__MODEL = eINSTANCE.getInstanceMachine_Model();

		/**
		 * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_MACHINE__ARG = eINSTANCE.getInstanceMachine_Arg();

		/**
		 * The meta object literal for the '<em><b>Slot</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_MACHINE__SLOT = eINSTANCE.getInstanceMachine_Slot();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.SlotPropertyImpl <em>Slot Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.SlotPropertyImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getSlotProperty()
		 * @generated
		 */
		EClass SLOT_PROPERTY = eINSTANCE.getSlotProperty();

		/**
		 * The meta object literal for the '<em><b>Xlia Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_PROPERTY__XLIA_PROPERTY = eINSTANCE.getSlotProperty_XliaProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_PROPERTY__VALUE = eINSTANCE.getSlotProperty_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ParameterImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DIRECTION = eINSTANCE.getParameter_Direction();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ParameterSetImpl <em>Parameter Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ParameterSetImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getParameterSet()
		 * @generated
		 */
		EClass PARAMETER_SET = eINSTANCE.getParameterSet();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_SET__PARAMETER = eINSTANCE.getParameterSet_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorImpl <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.BehaviorImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getBehavior()
		 * @generated
		 */
		EClass BEHAVIOR = eINSTANCE.getBehavior();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__PARAMETER = eINSTANCE.getBehavior_Parameter();

		/**
		 * The meta object literal for the '<em><b>Computation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__COMPUTATION = eINSTANCE.getBehavior_Computation();

		/**
		 * The meta object literal for the '<em><b>Execution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__EXECUTION = eINSTANCE.getBehavior_Execution();

		/**
		 * The meta object literal for the '<em><b>Interaction</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__INTERACTION = eINSTANCE.getBehavior_Interaction();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfComputationImpl <em>Model Of Computation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfComputationImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getModelOfComputation()
		 * @generated
		 */
		EClass MODEL_OF_COMPUTATION = eINSTANCE.getModelOfComputation();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl <em>Model Of Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfExecutionImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getModelOfExecution()
		 * @generated
		 */
		EClass MODEL_OF_EXECUTION = eINSTANCE.getModelOfExecution();

		/**
		 * The meta object literal for the '<em><b>Init Routine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__INIT_ROUTINE = eINSTANCE.getModelOfExecution_InitRoutine();

		/**
		 * The meta object literal for the '<em><b>Final Routine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__FINAL_ROUTINE = eINSTANCE.getModelOfExecution_FinalRoutine();

		/**
		 * The meta object literal for the '<em><b>Enable Routine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__ENABLE_ROUTINE = eINSTANCE.getModelOfExecution_EnableRoutine();

		/**
		 * The meta object literal for the '<em><b>Disable Routine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__DISABLE_ROUTINE = eINSTANCE.getModelOfExecution_DisableRoutine();

		/**
		 * The meta object literal for the '<em><b>Concurrency Routine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__CONCURRENCY_ROUTINE = eINSTANCE.getModelOfExecution_ConcurrencyRoutine();

		/**
		 * The meta object literal for the '<em><b>Schedule Routine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__SCHEDULE_ROUTINE = eINSTANCE.getModelOfExecution_ScheduleRoutine();

		/**
		 * The meta object literal for the '<em><b>Irun Routine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__IRUN_ROUTINE = eINSTANCE.getModelOfExecution_IrunRoutine();

		/**
		 * The meta object literal for the '<em><b>Run Routine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__RUN_ROUTINE = eINSTANCE.getModelOfExecution_RunRoutine();

		/**
		 * The meta object literal for the '<em><b>Routine</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_EXECUTION__ROUTINE = eINSTANCE.getModelOfExecution_Routine();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfInteractionImpl <em>Model Of Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ModelOfInteractionImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getModelOfInteraction()
		 * @generated
		 */
		EClass MODEL_OF_INTERACTION = eINSTANCE.getModelOfInteraction();

		/**
		 * The meta object literal for the '<em><b>Routes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_INTERACTION__ROUTES = eINSTANCE.getModelOfInteraction_Routes();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_OF_INTERACTION__CONNECTIONS = eINSTANCE.getModelOfInteraction_Connections();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ComProtocolImpl <em>Com Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ComProtocolImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getComProtocol()
		 * @generated
		 */
		EClass COM_PROTOCOL = eINSTANCE.getComProtocol();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COM_PROTOCOL__PROTOCOL = eINSTANCE.getComProtocol_Protocol();

		/**
		 * The meta object literal for the '<em><b>Cast</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COM_PROTOCOL__CAST = eINSTANCE.getComProtocol_Cast();

		/**
		 * The meta object literal for the '<em><b>Inner buffer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_PROTOCOL__INNER_BUFFER = eINSTANCE.getComProtocol_Inner_buffer();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_PROTOCOL__BUFFER = eINSTANCE.getComProtocol_Buffer();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RouteImpl <em>Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.RouteImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getRoute()
		 * @generated
		 */
		EClass ROUTE = eINSTANCE.getRoute();

		/**
		 * The meta object literal for the '<em><b>Signals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE__SIGNALS = eINSTANCE.getRoute_Signals();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE__PROTOCOL = eINSTANCE.getRoute_Protocol();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ConnectorImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getConnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__PROTOCOL = eINSTANCE.getConnector_Protocol();

		/**
		 * The meta object literal for the '<em><b>Cast</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__CAST = eINSTANCE.getConnector_Cast();

		/**
		 * The meta object literal for the '<em><b>Com Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__COM_POINTS = eINSTANCE.getConnector_ComPoints();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.ComPointImpl <em>Com Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.ComPointImpl
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getComPoint()
		 * @generated
		 */
		EClass COM_POINT = eINSTANCE.getComPoint();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COM_POINT__DIRECTION = eINSTANCE.getComPoint_Direction();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_POINT__PROTOCOL = eINSTANCE.getComPoint_Protocol();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_POINT__POINT = eINSTANCE.getComPoint_Point();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_POINT__POINTS = eINSTANCE.getComPoint_Points();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.DesignKind <em>Design Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.DesignKind
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getDesignKind()
		 * @generated
		 */
		EEnum DESIGN_KIND = eINSTANCE.getDesignKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection <em>Channel Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.ChannelDirection
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getChannelDirection()
		 * @generated
		 */
		EEnum CHANNEL_DIRECTION = eINSTANCE.getChannelDirection();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ParameterDirectionKind <em>Parameter Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.ParameterDirectionKind
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getParameterDirectionKind()
		 * @generated
		 */
		EEnum PARAMETER_DIRECTION_KIND = eINSTANCE.getParameterDirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind <em>Com Protocol Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComProtocolKind
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getComProtocolKind()
		 * @generated
		 */
		EEnum COM_PROTOCOL_KIND = eINSTANCE.getComProtocolKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind <em>Com Cast Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.ComCastKind
		 * @see org.eclipse.efm.ecore.formalml.infrastructure.impl.InfrastructurePackageImpl#getComCastKind()
		 * @generated
		 */
		EEnum COM_CAST_KIND = eINSTANCE.getComCastKind();

	}

} //InfrastructurePackage
