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
package org.eclipse.efm.modeling.formalml.impl;

import org.eclipse.efm.modeling.formalml.Block;
import org.eclipse.efm.modeling.formalml.Buffer;
import org.eclipse.efm.modeling.formalml.BufferKind;
import org.eclipse.efm.modeling.formalml.Clock;
import org.eclipse.efm.modeling.formalml.Configuration;
import org.eclipse.efm.modeling.formalml.ConnectorContract;
import org.eclipse.efm.modeling.formalml.DirectedPort;
import org.eclipse.efm.modeling.formalml.FifoContract;
import org.eclipse.efm.modeling.formalml.FormalBlock;
import org.eclipse.efm.modeling.formalml.FormalMLFactory;
import org.eclipse.efm.modeling.formalml.FormalMLPackage;
import org.eclipse.efm.modeling.formalml.LifoContract;
import org.eclipse.efm.modeling.formalml.MultiRendezVousContract;
import org.eclipse.efm.modeling.formalml.MultiSetContract;
import org.eclipse.efm.modeling.formalml.Part;
import org.eclipse.efm.modeling.formalml.PortDirectionKind;
import org.eclipse.efm.modeling.formalml.RendezVousContract;
import org.eclipse.efm.modeling.formalml.TimedTransition;

import org.eclipse.efm.modeling.formalml.util.FormalMLValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FormalMLPackageImpl extends EPackageImpl implements FormalMLPackage {
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
	private EClass partEClass = null;

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
	private EClass clockEClass = null;

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
	private EClass directedPortEClass = null;

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
	private EClass fifoContractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorContractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifoContractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiSetContractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rendezVousContractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiRendezVousContractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bufferKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum portDirectionKindEEnum = null;

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
	 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FormalMLPackageImpl() {
		super(eNS_URI, FormalMLFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FormalMLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FormalMLPackage init() {
		if (isInited) return (FormalMLPackage)EPackage.Registry.INSTANCE.getEPackage(FormalMLPackage.eNS_URI);

		// Obtain or create and register package
		FormalMLPackageImpl theFormalMLPackage = (FormalMLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FormalMLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FormalMLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFormalMLPackage.createPackageContents();

		// Initialize created meta-data
		theFormalMLPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theFormalMLPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return FormalMLValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theFormalMLPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FormalMLPackage.eNS_URI, theFormalMLPackage);
		return theFormalMLPackage;
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
	public EReference getConfiguration_Environment() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_IsTimed() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_IsInputEnabled() {
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
	public EReference getFormalBlock_Base_Class() {
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
	public EClass getPart() {
		return partEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPart_Base_Property() {
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
	public EClass getBlock() {
		return blockEClass;
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
	public EReference getClock_Base_Property() {
		return (EReference)clockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClock__Constraint1__DiagnosticChain_Map() {
		return clockEClass.getEOperations().get(0);
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
	public EReference getBuffer_Base_Property() {
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
	public EAttribute getBuffer_Size() {
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(2);
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
	public EReference getDirectedPort_Base_Port() {
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
	public EReference getTimedTransition_Base_Transition() {
		return (EReference)timedTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFifoContract() {
		return fifoContractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorContract() {
		return connectorContractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorContract_Base_OpaqueBehavior() {
		return (EReference)connectorContractEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLifoContract() {
		return lifoContractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiSetContract() {
		return multiSetContractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRendezVousContract() {
		return rendezVousContractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiRendezVousContract() {
		return multiRendezVousContractEClass;
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
	public EEnum getPortDirectionKind() {
		return portDirectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalMLFactory getFormalMLFactory() {
		return (FormalMLFactory)getEFactoryInstance();
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
		configurationEClass = createEClass(CONFIGURATION);
		createEReference(configurationEClass, CONFIGURATION__ENVIRONMENT);
		createEAttribute(configurationEClass, CONFIGURATION__IS_TIMED);
		createEAttribute(configurationEClass, CONFIGURATION__IS_INPUT_ENABLED);

		formalBlockEClass = createEClass(FORMAL_BLOCK);
		createEReference(formalBlockEClass, FORMAL_BLOCK__BASE_CLASS);
		createEReference(formalBlockEClass, FORMAL_BLOCK__ROUTING_BEHAVIOR);

		partEClass = createEClass(PART);
		createEReference(partEClass, PART__BASE_PROPERTY);
		createEReference(partEClass, PART__INSTANCE);

		blockEClass = createEClass(BLOCK);

		clockEClass = createEClass(CLOCK);
		createEReference(clockEClass, CLOCK__BASE_PROPERTY);
		createEOperation(clockEClass, CLOCK___CONSTRAINT1__DIAGNOSTICCHAIN_MAP);

		bufferEClass = createEClass(BUFFER);
		createEReference(bufferEClass, BUFFER__BASE_PROPERTY);
		createEAttribute(bufferEClass, BUFFER__KIND);
		createEAttribute(bufferEClass, BUFFER__SIZE);

		directedPortEClass = createEClass(DIRECTED_PORT);
		createEReference(directedPortEClass, DIRECTED_PORT__BASE_PORT);
		createEAttribute(directedPortEClass, DIRECTED_PORT__DIRECTION);

		timedTransitionEClass = createEClass(TIMED_TRANSITION);
		createEReference(timedTransitionEClass, TIMED_TRANSITION__TGUARD);
		createEReference(timedTransitionEClass, TIMED_TRANSITION__BASE_TRANSITION);

		fifoContractEClass = createEClass(FIFO_CONTRACT);

		connectorContractEClass = createEClass(CONNECTOR_CONTRACT);
		createEReference(connectorContractEClass, CONNECTOR_CONTRACT__BASE_OPAQUE_BEHAVIOR);

		lifoContractEClass = createEClass(LIFO_CONTRACT);

		multiSetContractEClass = createEClass(MULTI_SET_CONTRACT);

		rendezVousContractEClass = createEClass(RENDEZ_VOUS_CONTRACT);

		multiRendezVousContractEClass = createEClass(MULTI_RENDEZ_VOUS_CONTRACT);

		// Create enums
		bufferKindEEnum = createEEnum(BUFFER_KIND);
		portDirectionKindEEnum = createEEnum(PORT_DIRECTION_KIND);
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
		blockEClass.getESuperTypes().add(this.getFormalBlock());
		fifoContractEClass.getESuperTypes().add(this.getConnectorContract());
		lifoContractEClass.getESuperTypes().add(this.getConnectorContract());
		multiSetContractEClass.getESuperTypes().add(this.getConnectorContract());
		rendezVousContractEClass.getESuperTypes().add(this.getConnectorContract());
		multiRendezVousContractEClass.getESuperTypes().add(this.getConnectorContract());

		// Initialize classes, features, and operations; add parameters
		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfiguration_Environment(), theUMLPackage.getProperty(), null, "environment", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConfiguration_IsTimed(), theTypesPackage.getBoolean(), "isTimed", "false", 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConfiguration_IsInputEnabled(), theTypesPackage.getBoolean(), "isInputEnabled", "false", 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(formalBlockEClass, FormalBlock.class, "FormalBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormalBlock_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, FormalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFormalBlock_RoutingBehavior(), theUMLPackage.getOpaqueBehavior(), null, "routingBehavior", null, 0, 1, FormalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(partEClass, Part.class, "Part", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPart_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPart_Instance(), theUMLPackage.getInstanceSpecification(), null, "instance", null, 0, -1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(clockEClass, Clock.class, "Clock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClock_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, Clock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = initEOperation(getClock__Constraint1__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "Constraint1", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bufferEClass, Buffer.class, "Buffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuffer_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBuffer_Kind(), this.getBufferKind(), "kind", "FIFO", 1, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBuffer_Size(), theTypesPackage.getUnlimitedNatural(), "size", "-1", 1, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(directedPortEClass, DirectedPort.class, "DirectedPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectedPort_Base_Port(), theUMLPackage.getPort(), null, "base_Port", null, 1, 1, DirectedPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDirectedPort_Direction(), this.getPortDirectionKind(), "direction", "inout", 1, 1, DirectedPort.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(timedTransitionEClass, TimedTransition.class, "TimedTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimedTransition_Tguard(), theUMLPackage.getConstraint(), null, "tguard", null, 0, 1, TimedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTimedTransition_Base_Transition(), theUMLPackage.getTransition(), null, "base_Transition", null, 1, 1, TimedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fifoContractEClass, FifoContract.class, "FifoContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(connectorContractEClass, ConnectorContract.class, "ConnectorContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorContract_Base_OpaqueBehavior(), theUMLPackage.getOpaqueBehavior(), null, "base_OpaqueBehavior", null, 1, 1, ConnectorContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(lifoContractEClass, LifoContract.class, "LifoContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiSetContractEClass, MultiSetContract.class, "MultiSetContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rendezVousContractEClass, RendezVousContract.class, "RendezVousContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiRendezVousContractEClass, MultiRendezVousContract.class, "MultiRendezVousContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(bufferKindEEnum, BufferKind.class, "BufferKind");
		addEEnumLiteral(bufferKindEEnum, BufferKind.FIFO);
		addEEnumLiteral(bufferKindEEnum, BufferKind.LIFO);
		addEEnumLiteral(bufferKindEEnum, BufferKind.MULTISET);
		addEEnumLiteral(bufferKindEEnum, BufferKind.RAM);

		initEEnum(portDirectionKindEEnum, PortDirectionKind.class, "PortDirectionKind");
		addEEnumLiteral(portDirectionKindEEnum, PortDirectionKind.INOUT);
		addEEnumLiteral(portDirectionKindEEnum, PortDirectionKind.IN);
		addEEnumLiteral(portDirectionKindEEnum, PortDirectionKind.OUT);

		// Create resource
		createResource(eNS_URI);
	}

} //FormalMLPackageImpl
