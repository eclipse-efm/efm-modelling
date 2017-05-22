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

import org.eclipse.efm.modeling.formalml.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FormalMLFactoryImpl extends EFactoryImpl implements FormalMLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FormalMLFactory init() {
		try {
			FormalMLFactory theFormalMLFactory = (FormalMLFactory)EPackage.Registry.INSTANCE.getEFactory(FormalMLPackage.eNS_URI);
			if (theFormalMLFactory != null) {
				return theFormalMLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FormalMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalMLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FormalMLPackage.CONFIGURATION: return createConfiguration();
			case FormalMLPackage.PART: return createPart();
			case FormalMLPackage.BLOCK: return createBlock();
			case FormalMLPackage.CLOCK: return createClock();
			case FormalMLPackage.BUFFER: return createBuffer();
			case FormalMLPackage.DIRECTED_PORT: return createDirectedPort();
			case FormalMLPackage.TIMED_TRANSITION: return createTimedTransition();
			case FormalMLPackage.FIFO_CONTRACT: return createFifoContract();
			case FormalMLPackage.CONNECTOR_CONTRACT: return createConnectorContract();
			case FormalMLPackage.LIFO_CONTRACT: return createLifoContract();
			case FormalMLPackage.MULTI_SET_CONTRACT: return createMultiSetContract();
			case FormalMLPackage.RENDEZ_VOUS_CONTRACT: return createRendezVousContract();
			case FormalMLPackage.MULTI_RENDEZ_VOUS_CONTRACT: return createMultiRendezVousContract();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FormalMLPackage.BUFFER_KIND:
				return createBufferKindFromString(eDataType, initialValue);
			case FormalMLPackage.PORT_DIRECTION_KIND:
				return createPortDirectionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FormalMLPackage.BUFFER_KIND:
				return convertBufferKindToString(eDataType, instanceValue);
			case FormalMLPackage.PORT_DIRECTION_KIND:
				return convertPortDirectionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part createPart() {
		PartImpl part = new PartImpl();
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clock createClock() {
		ClockImpl clock = new ClockImpl();
		return clock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer createBuffer() {
		BufferImpl buffer = new BufferImpl();
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectedPort createDirectedPort() {
		DirectedPortImpl directedPort = new DirectedPortImpl();
		return directedPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimedTransition createTimedTransition() {
		TimedTransitionImpl timedTransition = new TimedTransitionImpl();
		return timedTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FifoContract createFifoContract() {
		FifoContractImpl fifoContract = new FifoContractImpl();
		return fifoContract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorContract createConnectorContract() {
		ConnectorContractImpl connectorContract = new ConnectorContractImpl();
		return connectorContract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifoContract createLifoContract() {
		LifoContractImpl lifoContract = new LifoContractImpl();
		return lifoContract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiSetContract createMultiSetContract() {
		MultiSetContractImpl multiSetContract = new MultiSetContractImpl();
		return multiSetContract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RendezVousContract createRendezVousContract() {
		RendezVousContractImpl rendezVousContract = new RendezVousContractImpl();
		return rendezVousContract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiRendezVousContract createMultiRendezVousContract() {
		MultiRendezVousContractImpl multiRendezVousContract = new MultiRendezVousContractImpl();
		return multiRendezVousContract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferKind createBufferKindFromString(EDataType eDataType, String initialValue) {
		BufferKind result = BufferKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBufferKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortDirectionKind createPortDirectionKindFromString(EDataType eDataType, String initialValue) {
		PortDirectionKind result = PortDirectionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortDirectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalMLPackage getFormalMLPackage() {
		return (FormalMLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FormalMLPackage getPackage() {
		return FormalMLPackage.eINSTANCE;
	}

} //FormalMLFactoryImpl
