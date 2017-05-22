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
package org.eclipse.efm.modeling.formalml.util;

import java.util.Map;

import org.eclipse.efm.modeling.formalml.*;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.modeling.formalml.FormalMLPackage
 * @generated
 */
public class FormalMLValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FormalMLValidator INSTANCE = new FormalMLValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.efm.modeling.formalml";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Constraint1' of 'Clock'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLOCK__CONSTRAINT1 = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalMLValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return FormalMLPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case FormalMLPackage.CONFIGURATION:
				return validateConfiguration((Configuration)value, diagnostics, context);
			case FormalMLPackage.FORMAL_BLOCK:
				return validateFormalBlock((FormalBlock)value, diagnostics, context);
			case FormalMLPackage.PART:
				return validatePart((Part)value, diagnostics, context);
			case FormalMLPackage.BLOCK:
				return validateBlock((Block)value, diagnostics, context);
			case FormalMLPackage.CLOCK:
				return validateClock((Clock)value, diagnostics, context);
			case FormalMLPackage.BUFFER:
				return validateBuffer((Buffer)value, diagnostics, context);
			case FormalMLPackage.DIRECTED_PORT:
				return validateDirectedPort((DirectedPort)value, diagnostics, context);
			case FormalMLPackage.TIMED_TRANSITION:
				return validateTimedTransition((TimedTransition)value, diagnostics, context);
			case FormalMLPackage.FIFO_CONTRACT:
				return validateFifoContract((FifoContract)value, diagnostics, context);
			case FormalMLPackage.CONNECTOR_CONTRACT:
				return validateConnectorContract((ConnectorContract)value, diagnostics, context);
			case FormalMLPackage.LIFO_CONTRACT:
				return validateLifoContract((LifoContract)value, diagnostics, context);
			case FormalMLPackage.MULTI_SET_CONTRACT:
				return validateMultiSetContract((MultiSetContract)value, diagnostics, context);
			case FormalMLPackage.RENDEZ_VOUS_CONTRACT:
				return validateRendezVousContract((RendezVousContract)value, diagnostics, context);
			case FormalMLPackage.MULTI_RENDEZ_VOUS_CONTRACT:
				return validateMultiRendezVousContract((MultiRendezVousContract)value, diagnostics, context);
			case FormalMLPackage.BUFFER_KIND:
				return validateBufferKind((BufferKind)value, diagnostics, context);
			case FormalMLPackage.PORT_DIRECTION_KIND:
				return validatePortDirectionKind((PortDirectionKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfiguration(Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(configuration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFormalBlock(FormalBlock formalBlock, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(formalBlock, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePart(Part part, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(part, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlock(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(block, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClock(Clock clock, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(clock, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(clock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(clock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(clock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(clock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(clock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(clock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(clock, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(clock, diagnostics, context);
		if (result || diagnostics != null) result &= validateClock_Constraint1(clock, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Constraint1 constraint of '<em>Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClock_Constraint1(Clock clock, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return clock.Constraint1(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBuffer(Buffer buffer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(buffer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectedPort(DirectedPort directedPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(directedPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimedTransition(TimedTransition timedTransition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(timedTransition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFifoContract(FifoContract fifoContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fifoContract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectorContract(ConnectorContract connectorContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connectorContract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLifoContract(LifoContract lifoContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(lifoContract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiSetContract(MultiSetContract multiSetContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(multiSetContract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRendezVousContract(RendezVousContract rendezVousContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rendezVousContract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiRendezVousContract(MultiRendezVousContract multiRendezVousContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(multiRendezVousContract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBufferKind(BufferKind bufferKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortDirectionKind(PortDirectionKind portDirectionKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //FormalMLValidator
