/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.modeling.formalml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.eclipse.efm.modeling.formalml.FormalMLFactory
 * @model kind="package"
 * @generated
 */
public interface FormalMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "formalml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/FormalML/profile";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "FormalML";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FormalMLPackage eINSTANCE = org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.FormalBlockImpl <em>Formal Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalBlockImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getFormalBlock()
	 * @generated
	 */
	int FORMAL_BLOCK = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_BLOCK__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Routing Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_BLOCK__ROUTING_BEHAVIOR = 1;

	/**
	 * The number of structural features of the '<em>Formal Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_BLOCK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Formal Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_BLOCK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.ConfigurationImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BASE_CLASS = FORMAL_BLOCK__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Routing Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ROUTING_BEHAVIOR = FORMAL_BLOCK__ROUTING_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ENVIRONMENT = FORMAL_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__IS_TIMED = FORMAL_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Input Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__IS_INPUT_ENABLED = FORMAL_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = FORMAL_BLOCK_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = FORMAL_BLOCK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.PartImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getPart()
	 * @generated
	 */
	int PART = 2;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__INSTANCE = 1;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.BlockImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__BASE_CLASS = FORMAL_BLOCK__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Routing Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__ROUTING_BEHAVIOR = FORMAL_BLOCK__ROUTING_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = FORMAL_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OPERATION_COUNT = FORMAL_BLOCK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.ClockImpl <em>Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.ClockImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getClock()
	 * @generated
	 */
	int CLOCK = 4;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Constraint1</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK___CONSTRAINT1__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.BufferImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 5;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__KIND = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__SIZE = 2;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.DirectedPortImpl <em>Directed Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.DirectedPortImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getDirectedPort()
	 * @generated
	 */
	int DIRECTED_PORT = 6;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTED_PORT__BASE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTED_PORT__DIRECTION = 1;

	/**
	 * The number of structural features of the '<em>Directed Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTED_PORT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Directed Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTED_PORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.TimedTransitionImpl <em>Timed Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.TimedTransitionImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getTimedTransition()
	 * @generated
	 */
	int TIMED_TRANSITION = 7;

	/**
	 * The feature id for the '<em><b>Tguard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION__TGUARD = 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION__BASE_TRANSITION = 1;

	/**
	 * The number of structural features of the '<em>Timed Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Timed Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.ConnectorContractImpl <em>Connector Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.ConnectorContractImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getConnectorContract()
	 * @generated
	 */
	int CONNECTOR_CONTRACT = 9;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR = 0;

	/**
	 * The number of structural features of the '<em>Connector Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONTRACT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Connector Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONTRACT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.FifoContractImpl <em>Fifo Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.FifoContractImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getFifoContract()
	 * @generated
	 */
	int FIFO_CONTRACT = 8;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIFO_CONTRACT__BASE_OPAQUE_BEHAVIOR = CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Fifo Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIFO_CONTRACT_FEATURE_COUNT = CONNECTOR_CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fifo Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIFO_CONTRACT_OPERATION_COUNT = CONNECTOR_CONTRACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.LifoContractImpl <em>Lifo Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.LifoContractImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getLifoContract()
	 * @generated
	 */
	int LIFO_CONTRACT = 10;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFO_CONTRACT__BASE_OPAQUE_BEHAVIOR = CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Lifo Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFO_CONTRACT_FEATURE_COUNT = CONNECTOR_CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Lifo Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFO_CONTRACT_OPERATION_COUNT = CONNECTOR_CONTRACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.MultiSetContractImpl <em>Multi Set Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.MultiSetContractImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getMultiSetContract()
	 * @generated
	 */
	int MULTI_SET_CONTRACT = 11;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SET_CONTRACT__BASE_OPAQUE_BEHAVIOR = CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Multi Set Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SET_CONTRACT_FEATURE_COUNT = CONNECTOR_CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Multi Set Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SET_CONTRACT_OPERATION_COUNT = CONNECTOR_CONTRACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.RendezVousContractImpl <em>Rendez Vous Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.RendezVousContractImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getRendezVousContract()
	 * @generated
	 */
	int RENDEZ_VOUS_CONTRACT = 12;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDEZ_VOUS_CONTRACT__BASE_OPAQUE_BEHAVIOR = CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Rendez Vous Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDEZ_VOUS_CONTRACT_FEATURE_COUNT = CONNECTOR_CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rendez Vous Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDEZ_VOUS_CONTRACT_OPERATION_COUNT = CONNECTOR_CONTRACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.MultiRendezVousContractImpl <em>Multi Rendez Vous Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.MultiRendezVousContractImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getMultiRendezVousContract()
	 * @generated
	 */
	int MULTI_RENDEZ_VOUS_CONTRACT = 13;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_RENDEZ_VOUS_CONTRACT__BASE_OPAQUE_BEHAVIOR = CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Multi Rendez Vous Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_RENDEZ_VOUS_CONTRACT_FEATURE_COUNT = CONNECTOR_CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Multi Rendez Vous Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_RENDEZ_VOUS_CONTRACT_OPERATION_COUNT = CONNECTOR_CONTRACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.BufferKind <em>Buffer Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.BufferKind
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBufferKind()
	 * @generated
	 */
	int BUFFER_KIND = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.PortDirectionKind <em>Port Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.PortDirectionKind
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getPortDirectionKind()
	 * @generated
	 */
	int PORT_DIRECTION_KIND = 15;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.modeling.formalml.Configuration#getEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Environment</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Configuration#getEnvironment()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Environment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.modeling.formalml.Configuration#isTimed <em>Is Timed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Timed</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Configuration#isTimed()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_IsTimed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.modeling.formalml.Configuration#isInputEnabled <em>Is Input Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Input Enabled</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Configuration#isInputEnabled()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_IsInputEnabled();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.FormalBlock <em>Formal Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Block</em>'.
	 * @see org.eclipse.efm.modeling.formalml.FormalBlock
	 * @generated
	 */
	EClass getFormalBlock();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.FormalBlock#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.efm.modeling.formalml.FormalBlock#getBase_Class()
	 * @see #getFormalBlock()
	 * @generated
	 */
	EReference getFormalBlock_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.FormalBlock#getRoutingBehavior <em>Routing Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Routing Behavior</em>'.
	 * @see org.eclipse.efm.modeling.formalml.FormalBlock#getRoutingBehavior()
	 * @see #getFormalBlock()
	 * @generated
	 */
	EReference getFormalBlock_RoutingBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.Part#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Part#getBase_Property()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_Base_Property();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.modeling.formalml.Part#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instance</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Part#getInstance()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_Instance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.Clock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Clock
	 * @generated
	 */
	EClass getClock();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.Clock#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Clock#getBase_Property()
	 * @see #getClock()
	 * @generated
	 */
	EReference getClock_Base_Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.efm.modeling.formalml.Clock#Constraint1(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Constraint1</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Constraint1</em>' operation.
	 * @see org.eclipse.efm.modeling.formalml.Clock#Constraint1(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getClock__Constraint1__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.Buffer#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Buffer#getBase_Property()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_Base_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.modeling.formalml.Buffer#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Buffer#getKind()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.modeling.formalml.Buffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Buffer#getSize()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Size();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.DirectedPort <em>Directed Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directed Port</em>'.
	 * @see org.eclipse.efm.modeling.formalml.DirectedPort
	 * @generated
	 */
	EClass getDirectedPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.DirectedPort#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.efm.modeling.formalml.DirectedPort#getBase_Port()
	 * @see #getDirectedPort()
	 * @generated
	 */
	EReference getDirectedPort_Base_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.modeling.formalml.DirectedPort#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.efm.modeling.formalml.DirectedPort#getDirection()
	 * @see #getDirectedPort()
	 * @generated
	 */
	EAttribute getDirectedPort_Direction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.TimedTransition <em>Timed Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Transition</em>'.
	 * @see org.eclipse.efm.modeling.formalml.TimedTransition
	 * @generated
	 */
	EClass getTimedTransition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.TimedTransition#getTguard <em>Tguard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tguard</em>'.
	 * @see org.eclipse.efm.modeling.formalml.TimedTransition#getTguard()
	 * @see #getTimedTransition()
	 * @generated
	 */
	EReference getTimedTransition_Tguard();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.TimedTransition#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.eclipse.efm.modeling.formalml.TimedTransition#getBase_Transition()
	 * @see #getTimedTransition()
	 * @generated
	 */
	EReference getTimedTransition_Base_Transition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.FifoContract <em>Fifo Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fifo Contract</em>'.
	 * @see org.eclipse.efm.modeling.formalml.FifoContract
	 * @generated
	 */
	EClass getFifoContract();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.ConnectorContract <em>Connector Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Contract</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ConnectorContract
	 * @generated
	 */
	EClass getConnectorContract();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.ConnectorContract#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Opaque Behavior</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ConnectorContract#getBase_OpaqueBehavior()
	 * @see #getConnectorContract()
	 * @generated
	 */
	EReference getConnectorContract_Base_OpaqueBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.LifoContract <em>Lifo Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lifo Contract</em>'.
	 * @see org.eclipse.efm.modeling.formalml.LifoContract
	 * @generated
	 */
	EClass getLifoContract();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.MultiSetContract <em>Multi Set Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Set Contract</em>'.
	 * @see org.eclipse.efm.modeling.formalml.MultiSetContract
	 * @generated
	 */
	EClass getMultiSetContract();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.RendezVousContract <em>Rendez Vous Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rendez Vous Contract</em>'.
	 * @see org.eclipse.efm.modeling.formalml.RendezVousContract
	 * @generated
	 */
	EClass getRendezVousContract();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.MultiRendezVousContract <em>Multi Rendez Vous Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Rendez Vous Contract</em>'.
	 * @see org.eclipse.efm.modeling.formalml.MultiRendezVousContract
	 * @generated
	 */
	EClass getMultiRendezVousContract();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.modeling.formalml.BufferKind <em>Buffer Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Buffer Kind</em>'.
	 * @see org.eclipse.efm.modeling.formalml.BufferKind
	 * @generated
	 */
	EEnum getBufferKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.modeling.formalml.PortDirectionKind <em>Port Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Direction Kind</em>'.
	 * @see org.eclipse.efm.modeling.formalml.PortDirectionKind
	 * @generated
	 */
	EEnum getPortDirectionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FormalMLFactory getFormalMLFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.ConfigurationImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Environment</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__ENVIRONMENT = eINSTANCE.getConfiguration_Environment();

		/**
		 * The meta object literal for the '<em><b>Is Timed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__IS_TIMED = eINSTANCE.getConfiguration_IsTimed();

		/**
		 * The meta object literal for the '<em><b>Is Input Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__IS_INPUT_ENABLED = eINSTANCE.getConfiguration_IsInputEnabled();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.FormalBlockImpl <em>Formal Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalBlockImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getFormalBlock()
		 * @generated
		 */
		EClass FORMAL_BLOCK = eINSTANCE.getFormalBlock();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_BLOCK__BASE_CLASS = eINSTANCE.getFormalBlock_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Routing Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_BLOCK__ROUTING_BEHAVIOR = eINSTANCE.getFormalBlock_RoutingBehavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.PartImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getPart()
		 * @generated
		 */
		EClass PART = eINSTANCE.getPart();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART__BASE_PROPERTY = eINSTANCE.getPart_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART__INSTANCE = eINSTANCE.getPart_Instance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.BlockImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.ClockImpl <em>Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.ClockImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getClock()
		 * @generated
		 */
		EClass CLOCK = eINSTANCE.getClock();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK__BASE_PROPERTY = eINSTANCE.getClock_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Constraint1</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLOCK___CONSTRAINT1__DIAGNOSTICCHAIN_MAP = eINSTANCE.getClock__Constraint1__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.BufferImpl <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.BufferImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBuffer()
		 * @generated
		 */
		EClass BUFFER = eINSTANCE.getBuffer();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER__BASE_PROPERTY = eINSTANCE.getBuffer_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__KIND = eINSTANCE.getBuffer_Kind();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__SIZE = eINSTANCE.getBuffer_Size();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.DirectedPortImpl <em>Directed Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.DirectedPortImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getDirectedPort()
		 * @generated
		 */
		EClass DIRECTED_PORT = eINSTANCE.getDirectedPort();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTED_PORT__BASE_PORT = eINSTANCE.getDirectedPort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTED_PORT__DIRECTION = eINSTANCE.getDirectedPort_Direction();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.TimedTransitionImpl <em>Timed Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.TimedTransitionImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getTimedTransition()
		 * @generated
		 */
		EClass TIMED_TRANSITION = eINSTANCE.getTimedTransition();

		/**
		 * The meta object literal for the '<em><b>Tguard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_TRANSITION__TGUARD = eINSTANCE.getTimedTransition_Tguard();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_TRANSITION__BASE_TRANSITION = eINSTANCE.getTimedTransition_Base_Transition();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.FifoContractImpl <em>Fifo Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.FifoContractImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getFifoContract()
		 * @generated
		 */
		EClass FIFO_CONTRACT = eINSTANCE.getFifoContract();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.ConnectorContractImpl <em>Connector Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.ConnectorContractImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getConnectorContract()
		 * @generated
		 */
		EClass CONNECTOR_CONTRACT = eINSTANCE.getConnectorContract();

		/**
		 * The meta object literal for the '<em><b>Base Opaque Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR = eINSTANCE.getConnectorContract_Base_OpaqueBehavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.LifoContractImpl <em>Lifo Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.LifoContractImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getLifoContract()
		 * @generated
		 */
		EClass LIFO_CONTRACT = eINSTANCE.getLifoContract();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.MultiSetContractImpl <em>Multi Set Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.MultiSetContractImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getMultiSetContract()
		 * @generated
		 */
		EClass MULTI_SET_CONTRACT = eINSTANCE.getMultiSetContract();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.RendezVousContractImpl <em>Rendez Vous Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.RendezVousContractImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getRendezVousContract()
		 * @generated
		 */
		EClass RENDEZ_VOUS_CONTRACT = eINSTANCE.getRendezVousContract();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.MultiRendezVousContractImpl <em>Multi Rendez Vous Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.MultiRendezVousContractImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getMultiRendezVousContract()
		 * @generated
		 */
		EClass MULTI_RENDEZ_VOUS_CONTRACT = eINSTANCE.getMultiRendezVousContract();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.BufferKind <em>Buffer Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.BufferKind
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBufferKind()
		 * @generated
		 */
		EEnum BUFFER_KIND = eINSTANCE.getBufferKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.PortDirectionKind <em>Port Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.PortDirectionKind
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getPortDirectionKind()
		 * @generated
		 */
		EEnum PORT_DIRECTION_KIND = eINSTANCE.getPortDirectionKind();

	}

} //FormalMLPackage
