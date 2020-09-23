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
package org.eclipse.efm.ecore.formalml.infrastructure.impl;

import org.eclipse.efm.ecore.formalml.common.impl.NamedElementImpl;

import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;

import org.eclipse.efm.ecore.formalml.statement.BlockStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Routine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl#isMacro <em>Macro</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl#getParameterSet <em>Parameter Set</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl#getBodyBlock <em>Body Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoutineImpl extends NamedElementImpl implements Routine {
	/**
	 * The default value of the '{@link #isMacro() <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMacro()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MACRO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMacro() <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMacro()
	 * @generated
	 * @ordered
	 */
	protected boolean macro = MACRO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameterSet() <em>Parameter Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterSet()
	 * @generated
	 * @ordered
	 */
	protected ParameterSet parameterSet;

	/**
	 * The cached value of the '{@link #getResultSet() <em>Result Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultSet()
	 * @generated
	 * @ordered
	 */
	protected ParameterSet resultSet;

	/**
	 * The cached value of the '{@link #getBodyBlock() <em>Body Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyBlock()
	 * @generated
	 * @ordered
	 */
	protected BlockStatement bodyBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoutineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.ROUTINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMacro() {
		return macro;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMacro(boolean newMacro) {
		boolean oldMacro = macro;
		macro = newMacro;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__MACRO, oldMacro, macro));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterSet getParameterSet() {
		return parameterSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterSet(ParameterSet newParameterSet, NotificationChain msgs) {
		ParameterSet oldParameterSet = parameterSet;
		parameterSet = newParameterSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__PARAMETER_SET, oldParameterSet, newParameterSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameterSet(ParameterSet newParameterSet) {
		if (newParameterSet != parameterSet) {
			NotificationChain msgs = null;
			if (parameterSet != null)
				msgs = ((InternalEObject)parameterSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__PARAMETER_SET, null, msgs);
			if (newParameterSet != null)
				msgs = ((InternalEObject)newParameterSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__PARAMETER_SET, null, msgs);
			msgs = basicSetParameterSet(newParameterSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__PARAMETER_SET, newParameterSet, newParameterSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterSet getResultSet() {
		return resultSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultSet(ParameterSet newResultSet, NotificationChain msgs) {
		ParameterSet oldResultSet = resultSet;
		resultSet = newResultSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__RESULT_SET, oldResultSet, newResultSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultSet(ParameterSet newResultSet) {
		if (newResultSet != resultSet) {
			NotificationChain msgs = null;
			if (resultSet != null)
				msgs = ((InternalEObject)resultSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__RESULT_SET, null, msgs);
			if (newResultSet != null)
				msgs = ((InternalEObject)newResultSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__RESULT_SET, null, msgs);
			msgs = basicSetResultSet(newResultSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__RESULT_SET, newResultSet, newResultSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockStatement getBodyBlock() {
		return bodyBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyBlock(BlockStatement newBodyBlock, NotificationChain msgs) {
		BlockStatement oldBodyBlock = bodyBlock;
		bodyBlock = newBodyBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__BODY_BLOCK, oldBodyBlock, newBodyBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBodyBlock(BlockStatement newBodyBlock) {
		if (newBodyBlock != bodyBlock) {
			NotificationChain msgs = null;
			if (bodyBlock != null)
				msgs = ((InternalEObject)bodyBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__BODY_BLOCK, null, msgs);
			if (newBodyBlock != null)
				msgs = ((InternalEObject)newBodyBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__BODY_BLOCK, null, msgs);
			msgs = basicSetBodyBlock(newBodyBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__BODY_BLOCK, newBodyBlock, newBodyBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.ROUTINE__PARAMETER_SET:
				return basicSetParameterSet(null, msgs);
			case InfrastructurePackage.ROUTINE__RESULT_SET:
				return basicSetResultSet(null, msgs);
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				return basicSetBodyBlock(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InfrastructurePackage.ROUTINE__MACRO:
				return isMacro();
			case InfrastructurePackage.ROUTINE__PARAMETER_SET:
				return getParameterSet();
			case InfrastructurePackage.ROUTINE__RESULT_SET:
				return getResultSet();
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				return getBodyBlock();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InfrastructurePackage.ROUTINE__MACRO:
				setMacro((Boolean)newValue);
				return;
			case InfrastructurePackage.ROUTINE__PARAMETER_SET:
				setParameterSet((ParameterSet)newValue);
				return;
			case InfrastructurePackage.ROUTINE__RESULT_SET:
				setResultSet((ParameterSet)newValue);
				return;
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				setBodyBlock((BlockStatement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InfrastructurePackage.ROUTINE__MACRO:
				setMacro(MACRO_EDEFAULT);
				return;
			case InfrastructurePackage.ROUTINE__PARAMETER_SET:
				setParameterSet((ParameterSet)null);
				return;
			case InfrastructurePackage.ROUTINE__RESULT_SET:
				setResultSet((ParameterSet)null);
				return;
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				setBodyBlock((BlockStatement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InfrastructurePackage.ROUTINE__MACRO:
				return macro != MACRO_EDEFAULT;
			case InfrastructurePackage.ROUTINE__PARAMETER_SET:
				return parameterSet != null;
			case InfrastructurePackage.ROUTINE__RESULT_SET:
				return resultSet != null;
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				return bodyBlock != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (macro: ");
		result.append(macro);
		result.append(')');
		return result.toString();
	}

} //RoutineImpl
