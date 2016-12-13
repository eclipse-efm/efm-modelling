/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml;

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
 * @see org.eclipse.efm.formalml.formalmlFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='fml'"
 * @generated
 */
public interface formalmlPackage extends EPackage {
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
	String eNS_URI = "http://org.eclipse.efm.formalml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "formalml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	formalmlPackage eINSTANCE = org.eclipse.efm.formalml.impl.formalmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.ClockImpl <em>Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.ClockImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getClock()
	 * @generated
	 */
	int CLOCK = 0;

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
	 * The number of operations of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.FormalBlockImpl <em>Formal Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.FormalBlockImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getFormalBlock()
	 * @generated
	 */
	int FORMAL_BLOCK = 2;

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
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.ConfigurationImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

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
	 * The feature id for the '<em><b>Env</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ENV = FORMAL_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__TIMED = FORMAL_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__INPUT_ENABLED = FORMAL_BLOCK_FEATURE_COUNT + 2;

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
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.TimedTransitionImpl <em>Timed Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.TimedTransitionImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getTimedTransition()
	 * @generated
	 */
	int TIMED_TRANSITION = 3;

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
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.PartImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getPart()
	 * @generated
	 */
	int PART = 4;

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
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.ReceiveEventImpl <em>Receive Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.ReceiveEventImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getReceiveEvent()
	 * @generated
	 */
	int RECEIVE_EVENT = 6;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_EVENT__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Receive Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_EVENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Receive Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.ReceiveAnyEventImpl <em>Receive Any Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.ReceiveAnyEventImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getReceiveAnyEvent()
	 * @generated
	 */
	int RECEIVE_ANY_EVENT = 5;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_ANY_EVENT__PARAMETERS = RECEIVE_EVENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Base Any Receive Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT = RECEIVE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Receive Any Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_ANY_EVENT_FEATURE_COUNT = RECEIVE_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Receive Any Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_ANY_EVENT_OPERATION_COUNT = RECEIVE_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.ReceiveSignalEventImpl <em>Receive Signal Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.ReceiveSignalEventImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getReceiveSignalEvent()
	 * @generated
	 */
	int RECEIVE_SIGNAL_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_SIGNAL_EVENT__PARAMETERS = RECEIVE_EVENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Base Any Receive Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT = RECEIVE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Signal Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT = RECEIVE_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Receive Signal Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_SIGNAL_EVENT_FEATURE_COUNT = RECEIVE_EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Receive Signal Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_SIGNAL_EVENT_OPERATION_COUNT = RECEIVE_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.DirectedPortImpl <em>Directed Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.DirectedPortImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getDirectedPort()
	 * @generated
	 */
	int DIRECTED_PORT = 8;

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
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.BufferImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 9;

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
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.formalml.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.impl.BlockImpl
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 10;

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
	 * The meta object id for the '{@link org.eclipse.efm.formalml.PortDirectionKind <em>Port Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.PortDirectionKind
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getPortDirectionKind()
	 * @generated
	 */
	int PORT_DIRECTION_KIND = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.formalml.BufferKind <em>Buffer Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.formalml.BufferKind
	 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getBufferKind()
	 * @generated
	 */
	int BUFFER_KIND = 12;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.Clock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock</em>'.
	 * @see org.eclipse.efm.formalml.Clock
	 * @generated
	 */
	EClass getClock();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.Clock#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.formalml.Clock#getBase_Property()
	 * @see #getClock()
	 * @generated
	 */
	EReference getClock_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.efm.formalml.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.formalml.Configuration#getEnv <em>Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Env</em>'.
	 * @see org.eclipse.efm.formalml.Configuration#getEnv()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Env();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.formalml.Configuration#isTimed <em>Timed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timed</em>'.
	 * @see org.eclipse.efm.formalml.Configuration#isTimed()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Timed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.formalml.Configuration#isInput_enabled <em>Input enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input enabled</em>'.
	 * @see org.eclipse.efm.formalml.Configuration#isInput_enabled()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Input_enabled();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.FormalBlock <em>Formal Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Block</em>'.
	 * @see org.eclipse.efm.formalml.FormalBlock
	 * @generated
	 */
	EClass getFormalBlock();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.FormalBlock#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.efm.formalml.FormalBlock#getBase_Class()
	 * @see #getFormalBlock()
	 * @generated
	 */
	EReference getFormalBlock_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.FormalBlock#getRoutingBehavior <em>Routing Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Routing Behavior</em>'.
	 * @see org.eclipse.efm.formalml.FormalBlock#getRoutingBehavior()
	 * @see #getFormalBlock()
	 * @generated
	 */
	EReference getFormalBlock_RoutingBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.TimedTransition <em>Timed Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Transition</em>'.
	 * @see org.eclipse.efm.formalml.TimedTransition
	 * @generated
	 */
	EClass getTimedTransition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.TimedTransition#getTguard <em>Tguard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tguard</em>'.
	 * @see org.eclipse.efm.formalml.TimedTransition#getTguard()
	 * @see #getTimedTransition()
	 * @generated
	 */
	EReference getTimedTransition_Tguard();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.TimedTransition#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.eclipse.efm.formalml.TimedTransition#getBase_Transition()
	 * @see #getTimedTransition()
	 * @generated
	 */
	EReference getTimedTransition_Base_Transition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see org.eclipse.efm.formalml.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.Part#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.formalml.Part#getBase_Property()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_Base_Property();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.formalml.Part#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instance</em>'.
	 * @see org.eclipse.efm.formalml.Part#getInstance()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_Instance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.ReceiveAnyEvent <em>Receive Any Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Any Event</em>'.
	 * @see org.eclipse.efm.formalml.ReceiveAnyEvent
	 * @generated
	 */
	EClass getReceiveAnyEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.ReceiveAnyEvent#getBase_AnyReceiveEvent <em>Base Any Receive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Any Receive Event</em>'.
	 * @see org.eclipse.efm.formalml.ReceiveAnyEvent#getBase_AnyReceiveEvent()
	 * @see #getReceiveAnyEvent()
	 * @generated
	 */
	EReference getReceiveAnyEvent_Base_AnyReceiveEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.ReceiveEvent <em>Receive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Event</em>'.
	 * @see org.eclipse.efm.formalml.ReceiveEvent
	 * @generated
	 */
	EClass getReceiveEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.formalml.ReceiveEvent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.eclipse.efm.formalml.ReceiveEvent#getParameters()
	 * @see #getReceiveEvent()
	 * @generated
	 */
	EReference getReceiveEvent_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.ReceiveSignalEvent <em>Receive Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Signal Event</em>'.
	 * @see org.eclipse.efm.formalml.ReceiveSignalEvent
	 * @generated
	 */
	EClass getReceiveSignalEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.ReceiveSignalEvent#getBase_AnyReceiveEvent <em>Base Any Receive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Any Receive Event</em>'.
	 * @see org.eclipse.efm.formalml.ReceiveSignalEvent#getBase_AnyReceiveEvent()
	 * @see #getReceiveSignalEvent()
	 * @generated
	 */
	EReference getReceiveSignalEvent_Base_AnyReceiveEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.ReceiveSignalEvent#getBase_SignalEvent <em>Base Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Signal Event</em>'.
	 * @see org.eclipse.efm.formalml.ReceiveSignalEvent#getBase_SignalEvent()
	 * @see #getReceiveSignalEvent()
	 * @generated
	 */
	EReference getReceiveSignalEvent_Base_SignalEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.DirectedPort <em>Directed Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directed Port</em>'.
	 * @see org.eclipse.efm.formalml.DirectedPort
	 * @generated
	 */
	EClass getDirectedPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.DirectedPort#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.efm.formalml.DirectedPort#getBase_Port()
	 * @see #getDirectedPort()
	 * @generated
	 */
	EReference getDirectedPort_Base_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.formalml.DirectedPort#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.efm.formalml.DirectedPort#getDirection()
	 * @see #getDirectedPort()
	 * @generated
	 */
	EAttribute getDirectedPort_Direction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.eclipse.efm.formalml.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.formalml.Buffer#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.formalml.Buffer#getBase_Property()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_Base_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.formalml.Buffer#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.efm.formalml.Buffer#getKind()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.formalml.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.eclipse.efm.formalml.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.formalml.PortDirectionKind <em>Port Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Direction Kind</em>'.
	 * @see org.eclipse.efm.formalml.PortDirectionKind
	 * @generated
	 */
	EEnum getPortDirectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.efm.formalml.BufferKind <em>Buffer Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Buffer Kind</em>'.
	 * @see org.eclipse.efm.formalml.BufferKind
	 * @generated
	 */
	EEnum getBufferKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	formalmlFactory getformalmlFactory();

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
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.ClockImpl <em>Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.ClockImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getClock()
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
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.ConfigurationImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Env</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__ENV = eINSTANCE.getConfiguration_Env();

		/**
		 * The meta object literal for the '<em><b>Timed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__TIMED = eINSTANCE.getConfiguration_Timed();

		/**
		 * The meta object literal for the '<em><b>Input enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__INPUT_ENABLED = eINSTANCE.getConfiguration_Input_enabled();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.FormalBlockImpl <em>Formal Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.FormalBlockImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getFormalBlock()
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
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.TimedTransitionImpl <em>Timed Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.TimedTransitionImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getTimedTransition()
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
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.PartImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getPart()
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
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.ReceiveAnyEventImpl <em>Receive Any Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.ReceiveAnyEventImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getReceiveAnyEvent()
		 * @generated
		 */
		EClass RECEIVE_ANY_EVENT = eINSTANCE.getReceiveAnyEvent();

		/**
		 * The meta object literal for the '<em><b>Base Any Receive Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT = eINSTANCE.getReceiveAnyEvent_Base_AnyReceiveEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.ReceiveEventImpl <em>Receive Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.ReceiveEventImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getReceiveEvent()
		 * @generated
		 */
		EClass RECEIVE_EVENT = eINSTANCE.getReceiveEvent();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_EVENT__PARAMETERS = eINSTANCE.getReceiveEvent_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.ReceiveSignalEventImpl <em>Receive Signal Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.ReceiveSignalEventImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getReceiveSignalEvent()
		 * @generated
		 */
		EClass RECEIVE_SIGNAL_EVENT = eINSTANCE.getReceiveSignalEvent();

		/**
		 * The meta object literal for the '<em><b>Base Any Receive Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT = eINSTANCE.getReceiveSignalEvent_Base_AnyReceiveEvent();

		/**
		 * The meta object literal for the '<em><b>Base Signal Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT = eINSTANCE.getReceiveSignalEvent_Base_SignalEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.DirectedPortImpl <em>Directed Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.DirectedPortImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getDirectedPort()
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
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.BufferImpl <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.BufferImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getBuffer()
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
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.impl.BlockImpl
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.PortDirectionKind <em>Port Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.PortDirectionKind
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getPortDirectionKind()
		 * @generated
		 */
		EEnum PORT_DIRECTION_KIND = eINSTANCE.getPortDirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.formalml.BufferKind <em>Buffer Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.formalml.BufferKind
		 * @see org.eclipse.efm.formalml.impl.formalmlPackageImpl#getBufferKind()
		 * @generated
		 */
		EEnum BUFFER_KIND = eINSTANCE.getBufferKind();

	}

} //formalmlPackage
