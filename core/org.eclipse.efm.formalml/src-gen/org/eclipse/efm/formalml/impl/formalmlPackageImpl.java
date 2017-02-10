/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml.impl;

import org.eclipse.efm.formalml.Block;
import org.eclipse.efm.formalml.Buffer;
import org.eclipse.efm.formalml.BufferKind;
import org.eclipse.efm.formalml.Clock;
import org.eclipse.efm.formalml.Configuration;
import org.eclipse.efm.formalml.DirectedPort;
import org.eclipse.efm.formalml.FormalBlock;
import org.eclipse.efm.formalml.Part;
import org.eclipse.efm.formalml.PortDirectionKind;
import org.eclipse.efm.formalml.ReceiveAnyEvent;
import org.eclipse.efm.formalml.ReceiveEvent;
import org.eclipse.efm.formalml.ReceiveSignalEvent;
import org.eclipse.efm.formalml.TimedTransition;
import org.eclipse.efm.formalml.formalmlFactory;
import org.eclipse.efm.formalml.formalmlPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class formalmlPackageImpl extends EPackageImpl implements formalmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formalBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveAnyEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveSignalEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directedPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum portDirectionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bufferKindEEnum = null;

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
	 * @see org.eclipse.efm.formalml.formalmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private formalmlPackageImpl() {
		super(eNS_URI, formalmlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link formalmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static formalmlPackage init() {
		if (isInited) return (formalmlPackage)EPackage.Registry.INSTANCE.getEPackage(formalmlPackage.eNS_URI);

		// Obtain or create and register package
		formalmlPackageImpl theformalmlPackage = (formalmlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof formalmlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new formalmlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theformalmlPackage.createPackageContents();

		// Initialize created meta-data
		theformalmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theformalmlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(formalmlPackage.eNS_URI, theformalmlPackage);
		return theformalmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClock() {
		return clockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClock_BaseProperty() {
		return (EReference)clockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_Env() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Timed() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_InputEnabled() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormalBlock() {
		return formalBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormalBlock_BaseClass() {
		return (EReference)formalBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormalBlock_RoutingBehavior() {
		return (EReference)formalBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedTransition() {
		return timedTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedTransition_Tguard() {
		return (EReference)timedTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedTransition_BaseTransition() {
		return (EReference)timedTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPart() {
		return partEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPart_BaseProperty() {
		return (EReference)partEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPart_Instance() {
		return (EReference)partEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceiveAnyEvent() {
		return receiveAnyEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveAnyEvent_BaseAnyReceiveEvent() {
		return (EReference)receiveAnyEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceiveEvent() {
		return receiveEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveEvent_Parameters() {
		return (EReference)receiveEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceiveSignalEvent() {
		return receiveSignalEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveSignalEvent_BaseAnyReceiveEvent() {
		return (EReference)receiveSignalEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveSignalEvent_BaseSignalEvent() {
		return (EReference)receiveSignalEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectedPort() {
		return directedPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirectedPort_BasePort() {
		return (EReference)directedPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDirectedPort_Direction() {
		return (EAttribute)directedPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuffer() {
		return bufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuffer_BaseProperty() {
		return (EReference)bufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuffer_Kind() {
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlock() {
		return blockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPortDirectionKind() {
		return portDirectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBufferKind() {
		return bufferKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public formalmlFactory getformalmlFactory() {
		return (formalmlFactory)getEFactoryInstance();
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
		clockEClass = createEClass(CLOCK);
		createEReference(clockEClass, CLOCK__BASE_PROPERTY);

		configurationEClass = createEClass(CONFIGURATION);
		createEReference(configurationEClass, CONFIGURATION__ENV);
		createEAttribute(configurationEClass, CONFIGURATION__TIMED);
		createEAttribute(configurationEClass, CONFIGURATION__INPUT_ENABLED);

		formalBlockEClass = createEClass(FORMAL_BLOCK);
		createEReference(formalBlockEClass, FORMAL_BLOCK__BASE_CLASS);
		createEReference(formalBlockEClass, FORMAL_BLOCK__ROUTING_BEHAVIOR);

		timedTransitionEClass = createEClass(TIMED_TRANSITION);
		createEReference(timedTransitionEClass, TIMED_TRANSITION__TGUARD);
		createEReference(timedTransitionEClass, TIMED_TRANSITION__BASE_TRANSITION);

		partEClass = createEClass(PART);
		createEReference(partEClass, PART__BASE_PROPERTY);
		createEReference(partEClass, PART__INSTANCE);

		receiveAnyEventEClass = createEClass(RECEIVE_ANY_EVENT);
		createEReference(receiveAnyEventEClass, RECEIVE_ANY_EVENT__BASE_ANY_RECEIVE_EVENT);

		receiveEventEClass = createEClass(RECEIVE_EVENT);
		createEReference(receiveEventEClass, RECEIVE_EVENT__PARAMETERS);

		receiveSignalEventEClass = createEClass(RECEIVE_SIGNAL_EVENT);
		createEReference(receiveSignalEventEClass, RECEIVE_SIGNAL_EVENT__BASE_ANY_RECEIVE_EVENT);
		createEReference(receiveSignalEventEClass, RECEIVE_SIGNAL_EVENT__BASE_SIGNAL_EVENT);

		directedPortEClass = createEClass(DIRECTED_PORT);
		createEReference(directedPortEClass, DIRECTED_PORT__BASE_PORT);
		createEAttribute(directedPortEClass, DIRECTED_PORT__DIRECTION);

		bufferEClass = createEClass(BUFFER);
		createEReference(bufferEClass, BUFFER__BASE_PROPERTY);
		createEAttribute(bufferEClass, BUFFER__KIND);

		blockEClass = createEClass(BLOCK);

		// Create enums
		portDirectionKindEEnum = createEEnum(PORT_DIRECTION_KIND);
		bufferKindEEnum = createEEnum(BUFFER_KIND);
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
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		configurationEClass.getESuperTypes().add(this.getFormalBlock());
		receiveAnyEventEClass.getESuperTypes().add(this.getReceiveEvent());
		receiveSignalEventEClass.getESuperTypes().add(this.getReceiveEvent());
		blockEClass.getESuperTypes().add(this.getFormalBlock());

		// Initialize classes, features, and operations; add parameters
		initEClass(clockEClass, Clock.class, "Clock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClock_BaseProperty(), theUMLPackage.getProperty(), null, "baseProperty", null, 1, 1, Clock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfiguration_Env(), theUMLPackage.getProperty(), null, "env", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConfiguration_Timed(), theTypesPackage.getBoolean(), "timed", "false", 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConfiguration_InputEnabled(), theTypesPackage.getBoolean(), "inputEnabled", "false", 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(formalBlockEClass, FormalBlock.class, "FormalBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormalBlock_BaseClass(), theUMLPackage.getClass_(), null, "baseClass", null, 1, 1, FormalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFormalBlock_RoutingBehavior(), theUMLPackage.getOpaqueBehavior(), null, "routingBehavior", null, 0, 1, FormalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(timedTransitionEClass, TimedTransition.class, "TimedTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimedTransition_Tguard(), theUMLPackage.getConstraint(), null, "tguard", null, 0, 1, TimedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTimedTransition_BaseTransition(), theUMLPackage.getTransition(), null, "baseTransition", null, 1, 1, TimedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(partEClass, Part.class, "Part", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPart_BaseProperty(), theUMLPackage.getProperty(), null, "baseProperty", null, 1, 1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPart_Instance(), theUMLPackage.getInstanceSpecification(), null, "instance", null, 0, -1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(receiveAnyEventEClass, ReceiveAnyEvent.class, "ReceiveAnyEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReceiveAnyEvent_BaseAnyReceiveEvent(), theUMLPackage.getAnyReceiveEvent(), null, "baseAnyReceiveEvent", null, 1, 1, ReceiveAnyEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(receiveEventEClass, ReceiveEvent.class, "ReceiveEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReceiveEvent_Parameters(), theUMLPackage.getProperty(), null, "parameters", null, 1, -1, ReceiveEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(receiveSignalEventEClass, ReceiveSignalEvent.class, "ReceiveSignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReceiveSignalEvent_BaseAnyReceiveEvent(), theUMLPackage.getAnyReceiveEvent(), null, "baseAnyReceiveEvent", null, 1, 1, ReceiveSignalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReceiveSignalEvent_BaseSignalEvent(), theUMLPackage.getSignalEvent(), null, "baseSignalEvent", null, 1, 1, ReceiveSignalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(directedPortEClass, DirectedPort.class, "DirectedPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectedPort_BasePort(), theUMLPackage.getPort(), null, "basePort", null, 1, 1, DirectedPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDirectedPort_Direction(), this.getPortDirectionKind(), "direction", null, 1, 1, DirectedPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(bufferEClass, Buffer.class, "Buffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuffer_BaseProperty(), theUMLPackage.getProperty(), null, "baseProperty", null, 1, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBuffer_Kind(), this.getBufferKind(), "kind", null, 1, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(portDirectionKindEEnum, PortDirectionKind.class, "PortDirectionKind");
		addEEnumLiteral(portDirectionKindEEnum, PortDirectionKind.INOUT);
		addEEnumLiteral(portDirectionKindEEnum, PortDirectionKind.IN);
		addEEnumLiteral(portDirectionKindEEnum, PortDirectionKind.OUT);

		initEEnum(bufferKindEEnum, BufferKind.class, "BufferKind");
		addEEnumLiteral(bufferKindEEnum, BufferKind.FIFO);
		addEEnumLiteral(bufferKindEEnum, BufferKind.LIFO);
		addEEnumLiteral(bufferKindEEnum, BufferKind.MULTISET);
		addEEnumLiteral(bufferKindEEnum, BufferKind.RAM);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "originalName", "fml"
		   });	
		addAnnotation
		  (getClock_BaseProperty(), 
		   source, 
		   new String[] {
			 "originalName", "base_Property"
		   });	
		addAnnotation
		  (getConfiguration_InputEnabled(), 
		   source, 
		   new String[] {
			 "originalName", "input_enabled"
		   });	
		addAnnotation
		  (getFormalBlock_BaseClass(), 
		   source, 
		   new String[] {
			 "originalName", "base_Class"
		   });	
		addAnnotation
		  (getTimedTransition_BaseTransition(), 
		   source, 
		   new String[] {
			 "originalName", "base_Transition"
		   });	
		addAnnotation
		  (getPart_BaseProperty(), 
		   source, 
		   new String[] {
			 "originalName", "base_Property"
		   });	
		addAnnotation
		  (getReceiveAnyEvent_BaseAnyReceiveEvent(), 
		   source, 
		   new String[] {
			 "originalName", "base_AnyReceiveEvent"
		   });	
		addAnnotation
		  (getReceiveSignalEvent_BaseAnyReceiveEvent(), 
		   source, 
		   new String[] {
			 "originalName", "base_AnyReceiveEvent"
		   });	
		addAnnotation
		  (getReceiveSignalEvent_BaseSignalEvent(), 
		   source, 
		   new String[] {
			 "originalName", "base_SignalEvent"
		   });	
		addAnnotation
		  (getDirectedPort_BasePort(), 
		   source, 
		   new String[] {
			 "originalName", "base_Port"
		   });	
		addAnnotation
		  (getBuffer_BaseProperty(), 
		   source, 
		   new String[] {
			 "originalName", "base_Property"
		   });	
		addAnnotation
		  (bufferKindEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "originalName", "FIFO"
		   });	
		addAnnotation
		  (bufferKindEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "originalName", "LIFO"
		   });	
		addAnnotation
		  (bufferKindEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "originalName", "MULTISET"
		   });	
		addAnnotation
		  (bufferKindEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "originalName", "RAM"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";	
		addAnnotation
		  (getClock_BaseProperty(), 
		   source, 
		   new String[] {
			 "body", "extension_ClockVar"
		   });	
		addAnnotation
		  (getFormalBlock_BaseClass(), 
		   source, 
		   new String[] {
			 "body", "extension_FormalBlock"
		   });	
		addAnnotation
		  (getTimedTransition_BaseTransition(), 
		   source, 
		   new String[] {
			 "body", "extension_Transition"
		   });	
		addAnnotation
		  (getPart_BaseProperty(), 
		   source, 
		   new String[] {
			 "body", "extension_BlockPart"
		   });	
		addAnnotation
		  (getReceiveAnyEvent_BaseAnyReceiveEvent(), 
		   source, 
		   new String[] {
			 "body", "extension_ReceiveAnyEvent"
		   });	
		addAnnotation
		  (getReceiveSignalEvent_BaseSignalEvent(), 
		   source, 
		   new String[] {
			 "body", "extension_ReceiveSignalEvent"
		   });	
		addAnnotation
		  (getDirectedPort_BasePort(), 
		   source, 
		   new String[] {
			 "body", "extension_FlowPort"
		   });	
		addAnnotation
		  (getBuffer_BaseProperty(), 
		   source, 
		   new String[] {
			 "body", "extension_BufferVar"
		   });
	}

} //formalmlPackageImpl
