/**
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.efm.modeling.formalml;

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
 * @see org.eclipse.efm.modeling.formalml.FormalMLFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='FormalML'"
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
	String eNS_URI = "http://org.eclipse.efm.formalml";

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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.ClockImpl <em>Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.ClockImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getClock()
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.FormalBlockImpl <em>Formal Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalBlockImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getFormalBlock()
	 * @generated
	 */
	int FORMAL_BLOCK = 2;

	/**
	 * The feature id for the '<em><b>Routing Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_BLOCK__ROUTING_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_BLOCK__BASE_CLASS = 1;

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
	int CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Routing Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ROUTING_BEHAVIOR = FORMAL_BLOCK__ROUTING_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BASE_CLASS = FORMAL_BLOCK__BASE_CLASS;

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
	 * The feature id for the '<em><b>Input Enabled</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.TimedTransitionImpl <em>Timed Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.TimedTransitionImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getTimedTransition()
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.PartImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getPart()
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.ReceiveEventImpl <em>Receive Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.ReceiveEventImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getReceiveEvent()
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.ReceiveAnyEventImpl <em>Receive Any Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.ReceiveAnyEventImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getReceiveAnyEvent()
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.ReceiveSignalEventImpl <em>Receive Signal Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.ReceiveSignalEventImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getReceiveSignalEvent()
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.DirectedPortImpl <em>Directed Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.DirectedPortImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getDirectedPort()
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.BufferImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBuffer()
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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.impl.BlockImpl
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 10;

	/**
	 * The feature id for the '<em><b>Routing Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__ROUTING_BEHAVIOR = FORMAL_BLOCK__ROUTING_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__BASE_CLASS = FORMAL_BLOCK__BASE_CLASS;

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
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.PortDirectionKind <em>Port Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.PortDirectionKind
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getPortDirectionKind()
	 * @generated
	 */
	int PORT_DIRECTION_KIND = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.modeling.formalml.BufferKind <em>Buffer Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.modeling.formalml.BufferKind
	 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBufferKind()
	 * @generated
	 */
	int BUFFER_KIND = 12;


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
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.Clock#getBaseProperty <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Clock#getBaseProperty()
	 * @see #getClock()
	 * @generated
	 */
	EReference getClock_BaseProperty();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.modeling.formalml.Configuration#getEnv <em>Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Env</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Configuration#getEnv()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Env();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.modeling.formalml.Configuration#isTimed <em>Timed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timed</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Configuration#isTimed()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Timed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.modeling.formalml.Configuration#isInputEnabled <em>Input Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Enabled</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Configuration#isInputEnabled()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_InputEnabled();

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
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.FormalBlock#getBaseClass <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.efm.modeling.formalml.FormalBlock#getBaseClass()
	 * @see #getFormalBlock()
	 * @generated
	 */
	EReference getFormalBlock_BaseClass();

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
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.TimedTransition#getBaseTransition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.eclipse.efm.modeling.formalml.TimedTransition#getBaseTransition()
	 * @see #getTimedTransition()
	 * @generated
	 */
	EReference getTimedTransition_BaseTransition();

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
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.Part#getBaseProperty <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Part#getBaseProperty()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_BaseProperty();

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
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.ReceiveAnyEvent <em>Receive Any Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Any Event</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ReceiveAnyEvent
	 * @generated
	 */
	EClass getReceiveAnyEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.ReceiveAnyEvent#getBaseAnyReceiveEvent <em>Base Any Receive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Any Receive Event</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ReceiveAnyEvent#getBaseAnyReceiveEvent()
	 * @see #getReceiveAnyEvent()
	 * @generated
	 */
	EReference getReceiveAnyEvent_BaseAnyReceiveEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.ReceiveEvent <em>Receive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Event</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ReceiveEvent
	 * @generated
	 */
	EClass getReceiveEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.efm.modeling.formalml.ReceiveEvent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ReceiveEvent#getParameters()
	 * @see #getReceiveEvent()
	 * @generated
	 */
	EReference getReceiveEvent_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.ReceiveSignalEvent <em>Receive Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Signal Event</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ReceiveSignalEvent
	 * @generated
	 */
	EClass getReceiveSignalEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.ReceiveSignalEvent#getBaseAnyReceiveEvent <em>Base Any Receive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Any Receive Event</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ReceiveSignalEvent#getBaseAnyReceiveEvent()
	 * @see #getReceiveSignalEvent()
	 * @generated
	 */
	EReference getReceiveSignalEvent_BaseAnyReceiveEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.ReceiveSignalEvent#getBaseSignalEvent <em>Base Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Signal Event</em>'.
	 * @see org.eclipse.efm.modeling.formalml.ReceiveSignalEvent#getBaseSignalEvent()
	 * @see #getReceiveSignalEvent()
	 * @generated
	 */
	EReference getReceiveSignalEvent_BaseSignalEvent();

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
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.efm.modeling.formalml.Buffer#getBaseProperty <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Buffer#getBaseProperty()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_BaseProperty();

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
	 * Returns the meta object for class '{@link org.eclipse.efm.modeling.formalml.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.eclipse.efm.modeling.formalml.Block
	 * @generated
	 */
	EClass getBlock();

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
	 * Returns the meta object for enum '{@link org.eclipse.efm.modeling.formalml.BufferKind <em>Buffer Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Buffer Kind</em>'.
	 * @see org.eclipse.efm.modeling.formalml.BufferKind
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
		EReference CLOCK__BASE_PROPERTY = eINSTANCE.getClock_BaseProperty();

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
		 * The meta object literal for the '<em><b>Input Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__INPUT_ENABLED = eINSTANCE.getConfiguration_InputEnabled();

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
		 * The meta object literal for the '<em><b>Routing Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_BLOCK__ROUTING_BEHAVIOR = eINSTANCE.getFormalBlock_RoutingBehavior();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_BLOCK__BASE_CLASS = eINSTANCE.getFormalBlock_BaseClass();

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
		EReference TIMED_TRANSITION__BASE_TRANSITION = eINSTANCE.getTimedTransition_BaseTransition();

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
		EReference PART__BASE_PROPERTY = eINSTANCE.getPart_BaseProperty();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART__INSTANCE = eINSTANCE.getPart_Instance();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.ReceiveAnyEventImpl <em>Receive Any Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.ReceiveAnyEventImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getReceiveAnyEvent()
		 * @generated
		 */
		EClass RECEIVE_ANY_EVENT = eINSTANCE.getReceiveAnyEvent();

		/**
		 * The meta object literal for the '<em><b>Base Any Receive Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT = eINSTANCE.getReceiveAnyEvent_BaseAnyReceiveEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.ReceiveEventImpl <em>Receive Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.ReceiveEventImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getReceiveEvent()
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
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.impl.ReceiveSignalEventImpl <em>Receive Signal Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.impl.ReceiveSignalEventImpl
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getReceiveSignalEvent()
		 * @generated
		 */
		EClass RECEIVE_SIGNAL_EVENT = eINSTANCE.getReceiveSignalEvent();

		/**
		 * The meta object literal for the '<em><b>Base Any Receive Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT = eINSTANCE.getReceiveSignalEvent_BaseAnyReceiveEvent();

		/**
		 * The meta object literal for the '<em><b>Base Signal Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT = eINSTANCE.getReceiveSignalEvent_BaseSignalEvent();

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
		EReference BUFFER__BASE_PROPERTY = eINSTANCE.getBuffer_BaseProperty();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__KIND = eINSTANCE.getBuffer_Kind();

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
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.PortDirectionKind <em>Port Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.PortDirectionKind
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getPortDirectionKind()
		 * @generated
		 */
		EEnum PORT_DIRECTION_KIND = eINSTANCE.getPortDirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.modeling.formalml.BufferKind <em>Buffer Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.modeling.formalml.BufferKind
		 * @see org.eclipse.efm.modeling.formalml.impl.FormalMLPackageImpl#getBufferKind()
		 * @generated
		 */
		EEnum BUFFER_KIND = eINSTANCE.getBufferKind();

	}

} //FormalMLPackage
